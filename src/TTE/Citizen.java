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
     
    public static void citizenUpgrade(){
        System.out.println("-".repeat(40));
        System.out.println("Citizen's Emotional (Decrease Tower's AttackPoint by 1): " + emotional);
        System.out.println("Citizen's Nervous (Decrease Tower Accuracy Percentage by 5%): " + nervous);
        System.out.println("Citizen's Lazy (Decrease Wall's HealthPoint by 100) : " + lazy);
        System.out.println("Citizen's Berserk (Increase Tower's AttackPoint by 1) : " + berserk);
        System.out.println("Citizen's Diligent (Increse Wall's HealthPoint by 75) : " + diligent);
        System.out.println("Citizen's Fearless (Increase Tower Critical Chance Percentage by 5%): " + fearless);
        System.out.println("\n1. Decrease Emotional (50 Gold -> 50 Emotional Point)");
        System.out.println("2. Decrease Nervous (50 Gold -> 50 Nervous Point)");
        System.out.println("3. Decrease Lazy (50 Gold -> 50 Lazy Point)");
        System.out.println("4. Increase Berserk (50 Gold -> 50 Berserk Point)");
        System.out.println("5. Increase Diligent (50 Gold -> 50 Diligent Point)");
        System.out.println("6. Increase Fearless (50 Gold -> 50 Fearless Point)");
        System.out.println("7. Back to menu");
        System.out.println("-".repeat(40));
        System.out.print("Please enter your command: ");
        
        int cmd = sc.nextInt();
        while (cmd<1 || cmd>7) {
            System.out.println("-".repeat(40));
            System.out.println("Option not available, please try again. ");
            System.out.println("-".repeat(40));
            System.out.print("Please enter your command: ");
            cmd = sc.nextInt();            
            }
        
        System.out.println("-".repeat(40));
        switch(cmd){
            case 1:{
                if(Gold.goldCheck(50)){
                    System.out.print("The citizen have become less emotional. Emotional " + emotional + " -> ");
                    emotional -= 50;
                    System.out.println(emotional);
                    System.out.printf("Gold : %d -> ", Gold.gold);
                    Gold.gold -= 50;
                    System.out.printf("%d\n", Gold.gold);
                    citizenAffect();
                }
                else{
                    System.out.println("Our treasury is empty. Upgrade failed.");
                }
                System.out.println("-".repeat(40));
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 2:{
                if(Gold.goldCheck(50)){
                    System.out.print("The citizen have become less nervous. Nervous " + nervous + " -> ");
                    nervous -= 50;
                    System.out.println(nervous);
                    System.out.printf("Gold : %d -> ", Gold.gold);
                    Gold.gold -= 50;
                    System.out.printf("%d\n", Gold.gold);
                    citizenAffect();
                }
                else{
                    System.out.println("Our treasury is empty. Upgrade failed.");
                }
                System.out.println("-".repeat(40));
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 3:{
                if(Gold.goldCheck(50)){
                    System.out.print("The citizen have become less lazy. Lazy " + lazy + " -> ");
                    lazy -= 50;
                    System.out.println(lazy);
                    System.out.printf("Gold : %d -> ", Gold.gold);
                    Gold.gold -= 50;
                    System.out.printf("%d\n", Gold.gold);
                    citizenAffect();
                }
                else{
                    System.out.println("Our treasury is empty. Upgrade failed.");
                }
                System.out.println("-".repeat(40));
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 4:{
                if(Gold.goldCheck(50)){
                    System.out.print("The citizen have become more berserk! Berserk " + berserk + " -> ");
                    berserk += 50;
                    System.out.println(berserk);
                    System.out.printf("Gold : %d -> ", Gold.gold);
                    Gold.gold -= 50;
                    System.out.printf("%d\n", Gold.gold);
                    citizenAffect();
                }
                else{
                    System.out.println("Our treasury is empty. Upgrade failed.");
                }
                System.out.println("-".repeat(40));
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 5:{
                if(Gold.goldCheck(50)){
                    System.out.print("The citizen have become more diligent! Diligent " + diligent + " -> ");
                    diligent += 50;
                    System.out.println(diligent);
                    System.out.printf("Gold : %d -> ", Gold.gold);
                    Gold.gold -= 50;
                    System.out.printf("%d\n", Gold.gold);
                    citizenAffect();
                }
                else{
                    System.out.println("Our treasury is empty. Upgrade failed.");
                }
                System.out.println("-".repeat(40));
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 6:{
                if(Gold.goldCheck(50)){
                    System.out.print("The citizen have become more fearless! Fearless " + fearless + " -> ");
                    fearless += 50;
                    System.out.println(fearless);
                    System.out.printf("Gold : %d -> ", Gold.gold);
                    Gold.gold -= 50;
                    System.out.printf("%d\n", Gold.gold);
                    citizenAffect();
                }
                else{
                    System.out.println("Our treasury is empty. Upgrade failed.");
                }
                System.out.println("-".repeat(40));
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                citizenUpgrade();
            
            }
            case 7: Game_Logic.waitforCommand();
        }
    }
    
    public static void citizenAffect() {
        if (emotional >= 100) {
            System.out.print("The citizens are too emotional! Tower AP: " + Tower.towerAP + " -> ");
            Tower.towerAP--;
            System.out.println(Tower.towerAP);
            System.out.print("The citizens calmed down after a while. Emotional " + emotional + " -> ");
            emotional -= 100;
            System.out.println(emotional);
        }
        
        if (nervous >= 100) {
            System.out.print("The citizens are too nervous! Tower Accuracy: " + Tower.towerACC + " -> ");
            Tower.towerACC -= 5;
            System.out.println(Tower.towerACC);
            System.out.print("The citizens calmed down after a while. Nervous " + nervous + " -> ");
            nervous -= 100;
            System.out.println(nervous);
        }
        
        if (lazy >= 100) {
            System.out.print("The citizens are too lazy! Wall HP: " + Wall.wallHP + " -> ");
            Wall.wallHP -= 100;
            System.out.println(Wall.wallHP);
            System.out.print("The citizens feel guilty and start working again. Lazy " + lazy + " -> ");
            lazy -= 100;
            System.out.println(lazy);
            
        }
        
        if (berserk >= 100) {
            System.out.print("The citizens are very berserk! Tower AP: " + Tower.towerAP + " -> ");
            Tower.towerAP++;
            System.out.println(Tower.towerAP);
            System.out.print("The citizens calmed down after a while. Berserk " + berserk + " -> ");
            berserk -= 100;
            System.out.println(berserk);
        }
        
        if (diligent >= 100) {
            System.out.print("The citizens are very diligent! Wall HP: " + Wall.wallHP + " -> ");
            Wall.wallHP += 75;
            System.out.println(Wall.wallHP);
            System.out.print("The citizens want to take a break after a while. Diligent " + diligent + " -> ");
            diligent -= 100;
            System.out.println(diligent);
        }
        
        if (fearless >= 100) {
            System.out.print("The citizens are very fearless!");
            if (Tower.towerCritRate + 5 > 50) {
                System.out.println("\nTower's Critical Rate can no longer be improved.");
            } else {
                System.out.print(" Tower Crit Rate: " + Tower.towerCritRate + " -> ");
                Tower.towerCritRate += 5;
                System.out.println(Tower.towerCritRate);                
            }
            System.out.print("The citizens calmed down after a while. Fearless " + fearless + " -> ");
            fearless -= 100;
            System.out.println(fearless);
        }        
    }
}
