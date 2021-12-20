package TTE;

import java.util.Scanner;

public class Citizen {
    static Scanner sc = new Scanner(System.in);
    static Scanner enterScanner = new Scanner(System.in);
    //Citizen initial stats
    String id = "Citizen";
    double emotional = 10;
    double nervous = 10;
    double lazy = 10;
    double berserk = 10;
    double diligent = 10;
    double fearless = 10;
    
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
        System.out.println("4. Decrease Berserk (50 Gold -> 50 Berserk Point)");
        System.out.println("5. Decrease Diligent (50 Gold -> 50 Diligent Point)");
        System.out.println("6. Decrease Fearless (50 Gold -> 50 Fearless Point)");
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
                }
                else{
                    System.out.println("Our treasury is empty");
                }
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 2:{
                if(Gold.goldCheck(50)){
                    nervous -= 50;
                    Gold.gold -= 50;
                    System.out.println("The citizen have become less nervous.");
                    System.out.printf("Gold : %d\n", Gold.gold);
                }
                else{
                    System.out.println("Our treasury is empty");
                }
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 3:{
                if(Gold.goldCheck(50)){
                    lazy -= 50;
                    Gold.gold -= 50;
                    System.out.println("The citizen have become less lazy.");
                    System.out.printf("Gold : %d\n", Gold.gold);
                }
                else{
                    System.out.println("Our treasury is empty");
                }
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 4:{
                if(Gold.goldCheck(50)){
                    berserk += 50;
                    Gold.gold -= 50;
                    System.out.println("The citizen have become more berserk!");
                    System.out.printf("Gold : %d\n", Gold.gold);
                }
                else{
                    System.out.println("Our treasury is empty");
                }
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 5:{
                if(Gold.goldCheck(50)){
                    diligent += 50;
                    Gold.gold -= 50;
                    System.out.println("The citizen have become more diligent!");
                    System.out.printf("Gold : %d\n", Gold.gold);
                }
                else{
                    System.out.println("Our treasury is empty");
                }
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 6:{
                if(Gold.goldCheck(50)){
                    fearless += 50;
                    Gold.gold -= 50;
                    System.out.println("The citizen have become more fearless!");
                    System.out.printf("Gold : %d\n", Gold.gold);
                }
                else{
                    System.out.println("Our treasury is empty");
                }
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 7: Game_Logic.waitforCommand();
        }
    }
    
    public void citizenAffect() {
        if (emotional >= 100) {
            tower.towerAP--;
            emotional -= 100;
        }
        
        if (nervous >= 100) {
            tower.towerACC -= 5;
            nervous -= 100;
        }
        
        if (lazy >= 100) {
            Wall.wallHP -= 100;
            lazy -= 100;
        }
        
        if (berserk >= 100) {
            tower.towerAP++;
            berserk -= 100;
        }
        
        if (diligent >= 100) {
            Wall.wallHP += 75;
            diligent -= 100;
        }
        
        if (fearless >= 100) {
            tower.towerCritRate += 5;
            fearless -= 100;
        }        
    }
}
