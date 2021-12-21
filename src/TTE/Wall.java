package TTE;
import java.util.Scanner;
public class Wall {
    static Scanner sc = new Scanner(System.in);
    static Scanner enterScanner = new Scanner(System.in);
    //Player initial stats
    String id = "Wall";
    static double wallHP = 100;
        //didn't use percentage cause easier to handle
    static double wallBlock = 10;      
    
    //Wall Upgrade
    public static void wallUpgrade(){
        System.out.println("-".repeat(40));
        System.out.printf("Wall's HealthPoint: %.0f\n", wallHP);
        System.out.printf("Wall's Block: %.0f%%\n\n", wallBlock);
        System.out.println("1. Upgrade Health (100 Gold -> 75 HealthPoint)");
        System.out.println("2. Upgrade Block Chance (100 Gold -> 5 Block Chance %)");
        System.out.println("3. Back to menu");
        System.out.println("-".repeat(40));
        System.out.print("Please enter your command: ");
        int com = sc.nextInt();
        
        while (com<1 || com>3) {
            System.out.println("Option not available, please try again. ");
            System.out.print("Please enter your command: ");
            com = sc.nextInt();
        }
        
        System.out.println("-".repeat(40));
        switch(com){
            case 1 -> {
                if(Gold.goldCheck(100)){
                    System.out.print("Our walls have been strengthened! " + Wall.wallHP + " -> ");
                    Wall.wallHP += 75;
                    System.out.println(Wall.wallHP);
                    System.out.printf("Gold : %d -> ", Gold.gold);
                    Gold.gold -= 100;
                    System.out.printf("%d\n", Gold.gold);
                }
                else{
                    System.out.println("Our treasury is empty");
                }
                System.out.println("-".repeat(40));
                System.out.print("Press ENTER to continue.");
                enterScanner.nextLine();
                wallUpgrade();
            }
            case 2 -> {
                if(Gold.goldCheck(100)){
                    if(wallBlock < 50){
                        Gold.gold -= 100;
                        System.out.print("Our walls have been improved! " + Wall.wallBlock + " -> ");
                        Wall.wallBlock += 5;
                        System.out.println(Wall.wallBlock);
                        System.out.printf("Gold : %d -> ", Gold.gold);
                        Gold.gold -= 100;
                        System.out.printf("%d\n", Gold.gold);
                    }
                    else{
                        System.out.println("Our walls can no longer be improved.");
                    }
                }
                else{
                    System.out.println("Our treasury is empty");
                }
                System.out.println("-".repeat(40));
                System.out.print("Press ENTER to continue.");                
                enterScanner.nextLine();
                wallUpgrade();
            }
            case 3 -> Game_Logic.waitforCommand();
        }
    }
}
