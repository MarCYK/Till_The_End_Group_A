package TTE;
import java.util.Scanner;
public class Wall {
    static Scanner sc = new Scanner(System.in);
    static Scanner enterScanner = new Scanner(System.in);
    static Gold gold = new Gold();
    //Player initial stats
    String id = "Wall";
    static double wallHP = 100;
        //didn't use percentage cause easier to handle
    static double wallBlock = 10;      
    
    public static void wallUpgrade(){
        System.out.printf("Wall's HealthPoint: %.0f\n", wallHP);
        System.out.printf("Wall's Block: %.0f%%\n\n", wallBlock);
        System.out.println("1. Upgrade Health (100 Gold -> 75 HealthPoint)");
        System.out.println("2. Upgrade Block Chance (100 Gold -> 5 Block Chance %)");
        System.out.println("3. Back to menu");
        System.out.print("Please enter your command: ");
        int com = sc.nextInt();
        
        while (com != 1 && com != 2 && com != 3) {
            System.out.println("Option not available, please try again. ");
            System.out.print("Please enter your command: ");
            com = sc.nextInt();
        }
        
        switch(com){
            case 1 -> {
                Wall.wallHP += 75;
                gold.gold -= 100;
                System.out.println("Our walls have been strengthen!");
                System.out.printf("Wall's HealthPoint: %.0f\n", wallHP);
                System.out.printf("Gold : %d\n", gold.gold);
                enterScanner.nextLine();
                wallUpgrade();
            }
            case 2 -> {
                if(wallBlock < 50){
                    Wall.wallBlock += 5;
                    gold.gold -= 100;
                    System.out.println("Our walls have been improved!");
                    System.out.printf("Wall's Block: %.0f\n", wallBlock);
                    System.out.printf("Gold : %d\n", gold.gold);
                    enterScanner.nextLine();
                    wallUpgrade();
                }
                else{
                    System.out.println("Our walls can no longer be improved.");
                    enterScanner.nextLine();
                    wallUpgrade();
                }
            }
            case 3 -> Game_Logic.waitforCommand();
        }
    }
}
