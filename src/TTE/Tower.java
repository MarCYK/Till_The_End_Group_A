package TTE;
import java.util.Scanner;
public class Tower {
    static Scanner sc = new Scanner(System.in);
    static Scanner enterScanner = new Scanner(System.in);
    // tower initial stats
    String id = "Tower";
    static double towerAP = 5;
    // didn't use percentage cause easier to handle
    static double towerCritRate = 10;
    static double towerACC = 80; 
    
    public void towerUpgrade(){
        System.out.println("-".repeat(40));
        System.out.printf("Tower's AttackPoint: %.0f\n", towerAP);
        System.out.printf("Tower's CriticalRate: %.0f%%\n", towerCritRate);
        System.out.printf("Tower's Accuracy: %.0f%%\n\n", towerACC);
        System.out.println("1. Upgrade Attack (100 Gold -> AttackPoint)");
        System.out.println("2. Upgrade Critical Chance (100 Gold -> 5 Critical Chance %)");
        System.out.println("3. Upgrade Accuracy (100 Gold -> 4 % Accuracy)");
        System.out.println("4. Back to menu");
        System.out.println("-".repeat(40));
        System.out.print("Please Enter Your Command: ");
        int com = sc.nextInt();
        
        while (com<1 || com>4) {
            System.out.println("-".repeat(40));
            System.out.println("Option not available, please try again. ");
            System.out.println("-".repeat(40));
            System.out.print("Please enter your command: ");
            com = sc.nextInt();
        }
        
        System.out.println("-".repeat(40));
        switch(com){
            case 1 -> {
                if(Gold.goldCheck(100)){
                    System.out.print("Tower's AttackPoint has been upgraded. Tower AP " + Tower.towerAP + " -> ");
                    Tower.towerAP += 1;
                    System.out.println(Tower.towerAP);
                    System.out.printf("Gold : %d -> ", Gold.gold);
                    Gold.gold -= 100;
                    System.out.printf("%d\n", Gold.gold);
                }else{
                    System.out.println("Our treasury is empty. Upgrade failed.");
                }
                System.out.println("-".repeat(40));
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                towerUpgrade();
            }
            case 2 -> {
                if(Gold.goldCheck(100)){
                    if(towerCritRate < 50){
                        System.out.print("Tower's Critical Rate has been upgraded. Tower Crit " + Tower.towerCritRate + " -> ");
                        Tower.towerCritRate += 5;
                        System.out.println(Tower.towerCritRate);
                        System.out.printf("Gold : %d -> ", Gold.gold);
                        Gold.gold -= 100;
                        System.out.printf("%d\n", Gold.gold);
                    }else{
                        System.out.println("Tower's Critical Rate can no longer be improved.");
                    }
                }else{
                    System.out.println("Our treasury is empty. Upgrade failed. ");
                }
                System.out.println("-".repeat(40));
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                towerUpgrade();              
            }
            case 3 -> {
                if(Gold.goldCheck(100)){
                    if(towerACC < 100){
                        System.out.print("Tower's Accuracy has been upgraded. Tower Acc " + Tower.towerACC + " -> ");
                        Tower.towerACC += 4;
                        System.out.println(Tower.towerACC);
                        System.out.printf("Gold : %d -> ", Gold.gold);
                        Gold.gold -= 100;
                        System.out.printf("%d\n", Gold.gold);
                    }else{
                        System.out.println("Tower's Accuracy can no longer be improved.");
                    }
                }else{
                    System.out.println("Our treasury is empty. Upgrade failed. ");
                }
                System.out.println("-".repeat(40));
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                towerUpgrade();   
            }
            case 4 -> Game_Logic.waitforCommand();
        }   
    }
}    