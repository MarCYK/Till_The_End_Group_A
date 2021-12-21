package TTE;

import java.util.Scanner;

public class Citizen {
    static Scanner sc = new Scanner(System.in);
    static Scanner enterScanner = new Scanner(System.in);
    //Citizen initial stats
    String id = "Citizen";
    static double emotional = 10;
    static double nervous = 10;
    static double lazy = 10;
    static double berserk = 10;
    static double diligent = 10;
    static double fearless = 10;
    
    Tower tower = new Tower();
    Wall wall = new Wall();
    
    public void citizenUpgrade(){
        System.out.println("Citizen's Emotional (Decrease Tower's AttackPoint by 1): " + emotional);
        System.out.println("Citizen's Nervous (Decrease Tower Accuracy Percentage by 5%): " + nervous);
        System.out.println("Citizen's Lazy (Decrease Wall's HealthPoint by 100) : " + lazy);
        System.out.println("Citizen's Berserk (Increase Tower's AttackPoint by 1) : " + berserk);
        System.out.println("Citizen's Diligent (Increse Wall's HealthPoint by 75) : " + diligent);
        System.out.println("Citizen's Fearless (Increase Tower Critical Chance Percentage by 5%): " + fearless);
        System.out.println("1. Decrease Emotional (50 Gold -> 50 Emotional Point)");
        System.out.println("2. Decrease Nervous (50 Gold -> 50 Nervous Point)");
        System.out.println("3. Decrease Lazy (50 Gold -> 50 Lazy Point)");
        System.out.println("4. Increase Berserk (50 Gold -> 50 Berserk Point)");
        System.out.println("5. Increase Diligent (50 Gold -> 50 Diligent Point)");
        System.out.println("6. Increase Fearless (50 Gold -> 50 Fearless Point)");
        System.out.println("7. Back to menu");
        System.out.println("Please enter your command: ");
        
        int cmd = sc.nextInt();
        while (cmd<1 || cmd>7) {
            System.out.println("Option not available, please try again. ");
            System.out.print("Please enter your command: ");
            cmd = sc.nextInt();            
            }
        switch(cmd){
            case 1:{
                if(Gold.goldCheck(50)){
                    emotional -= 50;
                    Gold.gold -= 50;
                    System.out.println("The citizen have become less emotional.");
                    System.out.printf("Gold : %d\n", Gold.gold);
                    citizenAffect();
                }
                else{
                    System.out.println("Our treasury is empty");
                }
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 2:{
                if(Gold.goldCheck(50)){
                    nervous -= 50;
                    Gold.gold -= 50;
                    System.out.println("The citizen have become less nervous.");
                    System.out.printf("Gold : %d\n", Gold.gold);
                    citizenAffect();
                }
                else{
                    System.out.println("Our treasury is empty");
                }
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 3:{
                if(Gold.goldCheck(50)){
                    lazy -= 50;
                    Gold.gold -= 50;
                    System.out.println("The citizen have become less lazy.");
                    System.out.printf("Gold : %d\n", Gold.gold);
                    citizenAffect();
                }
                else{
                    System.out.println("Our treasury is empty");
                }
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 4:{
                if(Gold.goldCheck(50)){
                    berserk += 50;
                    Gold.gold -= 50;
                    System.out.println("The citizen have become more berserk!");
                    System.out.printf("Gold : %d\n", Gold.gold);
                    citizenAffect();
                }
                else{
                    System.out.println("Our treasury is empty");
                }
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 5:{
                if(Gold.goldCheck(50)){
                    diligent += 50;
                    Gold.gold -= 50;
                    System.out.println("The citizen have become more diligent!");
                    System.out.printf("Gold : %d\n", Gold.gold);
                    citizenAffect();
                }
                else{
                    System.out.println("Our treasury is empty");
                }
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 6:{
                if(Gold.goldCheck(50)){
                    fearless += 50;
                    Gold.gold -= 50;
                    System.out.println("The citizen have become more fearless!");
                    System.out.printf("Gold : %d\n", Gold.gold);
                    citizenAffect();
                }
                else{
                    System.out.println("Our treasury is empty");
                }
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 7: Game_Logic.waitforCommand();
        }
    }
    
    public void citizenAffect() {
        if (emotional >= 100) {
            System.out.print("The citizens are too emotional! Tower AP: " + tower.towerAP + " -> ");
            tower.towerAP--;
            System.out.println(tower.towerAP);
            emotional -= 100;
        }
        
        if (nervous >= 100) {
            System.out.print("The citizens are too nervous! Tower Accuracy: " + tower.towerACC + " -> ");
            tower.towerACC -= 5;
            System.out.println(tower.towerACC);
            nervous -= 100;
        }
        
        if (lazy >= 100) {
            System.out.print("The citizens are too lazy! Wall HP: " + Wall.wallHP + " -> ");
            Wall.wallHP -= 100;
            System.out.println(Wall.wallHP);
            lazy -= 100;
        }
        
        if (berserk >= 100) {
            System.out.print("The citizens are very berserk! Tower AP: " + tower.towerAP + " -> ");
            tower.towerAP++;
            System.out.println(tower.towerAP);
            berserk -= 100;
        }
        
        if (diligent >= 100) {
            System.out.print("The citizens are very diligent! Wall HP: " + Wall.wallHP + " -> ");
            Wall.wallHP += 75;
            System.out.println(Wall.wallHP);
            diligent -= 100;
        }
        
        if (fearless >= 100) {
            System.out.print("The citizens are very fearless! Tower Crit Rate: " + tower.towerCritRate + " -> ");
            tower.towerCritRate += 5;
            System.out.println(tower.towerCritRate);
            fearless -= 100;
        }        
    }
}
