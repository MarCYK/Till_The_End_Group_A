package TTE;
import java.util.Scanner;
public class Game_Logic {
    static Scanner sc = new Scanner(System.in);
    static Scanner enterScanner = new Scanner(System.in);
    static Tower tower = new Tower();
    static Dragon dragon = new Dragon();
    static Events events = new Events();
    static Save save = new Save();
    
    public Game_Logic(){
        
    }
    
    public static void game(){
        System.out.println("Welcome to Till The End - A Tower Defense Game!");
        System.out.println("1. New game\n2. Load previous save");
        System.out.println("-".repeat(40));
        System.out.print("Please enter your command: ");
        int com = sc.nextInt();
        
        while (com<1 || com>2) {
            System.out.println("-".repeat(40));
            System.out.println("Option not available, please try again.");
            System.out.println("-".repeat(40));
            System.out.print("Please enter your command: ");
            com = sc.nextInt();            
        }
        
        System.out.println("-".repeat(40));
        
        switch(com){
            case 1 -> fight();
            case 2 -> Save.load();
        }
    }
    
    //main interface
    public static void waitforCommand(){
        System.out.print("1. Tower\n2. Wall\n3. Citizen\n4. I am all ready!\n5. Save your progress\n");
        System.out.println("-".repeat(40));
        System.out.print("Please enter your command: ");
        int com = sc.nextInt();
        
        while (com<1 || com>5) {
            System.out.println("-".repeat(40));
            System.out.println("Option not available, please try again.");
            System.out.println("-".repeat(40));
            System.out.print("Please enter your command: ");
            com = sc.nextInt();            
        }
        
        switch(com){
            case 1 -> tower.Upgrade();
            case 2 -> Wall.wallUpgrade();
            case 3 -> Citizen.citizenUpgrade();
            case 4 -> {
                System.out.println("-".repeat(40));
                fight();
            }
            case 5 -> Save.save();
        }
    }
    
    //Transition to attack sequence
    public static void fight(){
        System.out.println("A dragon performs a sudden attack to your city!");
        System.out.printf("Dragon's Level: %.0f\n", Dragon.dragonLvl);
        System.out.printf("Dragon's HealthPoint: %.0f\n", Dragon.dragonHP);
        System.out.printf("Dragon's AttackPoint: %.0f\n", Dragon.AP);
        System.out.printf("Dragon's Critical Chance: %.0f%%\n", Dragon.CritRate);
        System.out.printf("Dragon's Accuracy: %.0f%%\n",Dragon.Acc);
        // Prompt message
        System.out.println("-".repeat(40));
        System.out.print("Press ENTER to continue.");
        enterScanner.nextLine();
        
        for(int i=0; i<10; i++){
            System.out.println("-".repeat(40));
            System.out.println("[Round " + (i+1) + "]");
            dragonAttack();
            System.out.println("-".repeat(40));
            System.out.print("Press ENTER to continue.");
            enterScanner.nextLine();            
        }
        dragon.Upgrade(); // line 120
        // Complete one dragon fight message
        System.out.println("-".repeat(40));
        System.out.println("The dragon grows weary and fled.");
        System.out.println("The citizens cheer as they survived the attack.");
        System.out.println("They resume their daily life and prepare for the next season.");
        System.out.println("-".repeat(40));
        // Prompt message
        System.out.print("Press ENTER to continue.");
        enterScanner.nextLine(); 

        nextSeason(); // line 155
    }
    
    //COMBAT SYSTEM ---> dragonAttack(), towerAttack() and chance()
    //dragon attack
    public static void dragonAttack(){
        if((chance(Dragon.Acc))||!(chance(Wall.wallBlock))){ // line 114
            //attack successful     
            double dmg = Dragon.AP;
            
            if(chance(Dragon.CritRate)){
                //critical attack
                System.out.println("Dragon attacked our wall with critical attack!");
                dmg += (int)dmg/2;
            }
            else{
                System.out.println("Dragon attacked our wall!");
            }
            Wall.wallHP -= dmg;
            System.out.printf("Wall's HealthPoint minus %.0f\n", dmg);
            System.out.printf("Current Wall's HealthPoint: %.0f\n\n", Wall.wallHP);     
        }
        else{
            System.out.println("Wall successfully blocked dragon's attack");
            System.out.printf("Current Wall's HealthPoint: %.0f\n\n", Wall.wallHP);  
        }
        
        if(Wall.wallHP > 0){
            towerAttack();
        }
        else{
            defeat();
        }
    }
    
    //tower attack
    public static void towerAttack(){
        if(Dragon.tempHP > 0){
            if(chance(Tower.Acc)){
                //attack successful     
                double dmg = Tower.AP;

                if(chance(Tower.CritRate)){
                    //critical attack
                    System.out.println("Tower attacked dragon with critical attack!");
                    dmg += (int)dmg/2;
                }
                else{
                    System.out.println("Tower attacked dragon!");
                }
                Dragon.tempHP -= dmg;
                System.out.printf("Dragon's HealthPoint minus %.0f\n", dmg);
                System.out.printf("Current Dragon's HealthPoint: %.0f\n", Dragon.tempHP);     
            }
            else{
                System.out.println("Dragon dodged tower's attack!");
                System.out.printf("Current Dragon's HealthPoint: %.0f\n", Dragon.tempHP);  
            } 
        }
        else{
            victory();
        }
        
    }
    
    //check if attack/crit/block successful or not
    public static boolean chance(double x){
        double r = Math.random()*100;
        return r <= x;
    } 
    
    //Transition to the next season
    public static void nextSeason(){
        System.out.println("-".repeat(40));
        events.events();
        Gold.tax();
        System.out.printf("Year : %d\n", events.year);
        System.out.printf("Season : %s\n", events.seasonName);
        System.out.printf("Gold : %d\n", Gold.gold);
        waitforCommand(); // line 22
    }
    
    //Lost the game
    public static void defeat()
    {
        System.out.println("You failed to protect your city!");
        System.exit(0);
    }
    
    //Won the game
    public static void victory()
    {
        System.out.println("You killed the dragon! You protected your city!");
        System.exit(0);
    }
    
}
