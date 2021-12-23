package TTE;
import java.util.Scanner;
public class Tower {
    //Tower initaial stats
    static Scanner sc = new Scanner(System.in);
    static Scanner enterScanner = new Scanner(System.in);
    //tower initial stats
    String id = "Tower";
    static double towerAP = 5;
        //didn't use percentage cause easier to handle
    static double towerCritRate = 10;
    static double towerACC = 80; 
    int tier = 1;
    
    public void towerUpgrade(){
        
        System.out.println("-".repeat(40));
        System.out.printf("Tower's AttackPoint: %.0f", towerAP);
        System.out.printf("Tower's CriticalRate: %.0f", towerCritRate);
        System.out.println("1. Upgrade Attack (100 Gold -> AttackPoint)");
        System.out.println("2. Upgrade Critical Chance (100 Gold -> 5 Critical Chance %)");
        System.out.println("3. Upgrade Accuracy (100 Gold -> 4 % Accuracy)");
        System.out.println("4. Back to menu");
         System.out.println("-".repeat(40));
        System.out.println("Please Enter Your Command:");
        int com = sc.nextInt();
        //tier++; (to count a level for tower if needed)
        
        
         while (com<1 || com>3) {
            System.out.println("Option not available, please try again. ");
            System.out.println("Please enter your command: ");
            com = sc.nextInt();
         }
         System.out.println("-".repeat(40));
         switch(com){
             case 1 -> {
                 if(Gold.goldCheck(100)){
                     System.out.println("Tower's Attack have been upgraded "+Tower.towerAP+" ->");
                     Tower.towerAP += 1;
                     System.out.println(Tower.towerAP);
                     System.out.printf("Gold : %d ->",Gold.gold);
                     Gold.gold -= 100;
                     System.out.printf("%d\n", Gold.gold);
                 }else{
                     System.out.println("Our treasury is empty. Upgrade failed.");
                }
                 System.out.println("-".repeat(40));
                 System.out.println("Press ENTER to continue.");
                 enterScanner.nextLine();
                 towerUpgrade();
             }
             case 2 -> {
                 if(Gold.goldCheck(100)){
                     if(towerCritRate < 50){
                         System.out.println("Tower's Critical Rate have been upgraded "+Tower.towerCritRate+" ->");
                         Tower.towerCritRate += 5;
                         System.out.println(Tower.towerCritRate);
                         System.out.printf("Gold : %d ->", Gold.gold);
                         Gold.gold -= 100;
                         System.out.printf("%d\n", Gold.gold);
                     }else{
                         System.out.println("Tower's Critical Rate reach maximum level");
                     }
                 }else{
                     System.out.println("Our treasury is empty. Upgrade failed. ");
                 }
                 System.out.println("-".repeat(40));
                 System.out.println("Press ENTER to continue.");
                 enterScanner.nextLine();
                 towerUpgrade();              
             }
             case 3 -> {
                 if(Gold.goldCheck(100)){
                     if(towerACC < 50){
                         System.out.println("Tower's Accuracy have been upgraded "+Tower.towerACC+" ->");
                         Tower.towerACC += 4;
                         System.out.println(Tower.towerACC);
                         System.out.printf("Gold : %d ->", Gold.gold);
                         Gold.gold -= 100;
                         System.out.printf("%d\n", Gold.gold);
                     }else{
                         System.out.println("Tower's Accuracy reach maximum level");
                     }
                 }else{
                     System.out.println("Our treasury is empty. Upgrade failed. ");
                 }
                 System.out.println("-".repeat(40));
                 System.out.println("Press ENTER to continue.");
                 enterScanner.nextLine();
                 towerUpgrade();   
             }
             case 4 -> Game_Logic.waitforCommand();
        
        }   
    }
}