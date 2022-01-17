package TTE;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Tower extends SameBehavior {
    static Scanner sc = new Scanner(System.in);
    static Scanner enterScanner = new Scanner(System.in);
    // tower initial stats
    String id = "Tower";
    static double AP;
    static double CritRate;
    static double Acc;
    public Tower()
    {
        // didn't use percentage cause easier to handle
        ap=5;
        critRate=10;
        ACC=80;
        AP=ap;
        CritRate=critRate;
        Acc=ACC;
    }
    
    @Override
    public void Upgrade(){
        ImageIcon TitlePNG = new ImageIcon("Tower.png");
        JLabel icon = new JLabel(TitlePNG);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(219, 233, 240));
        panel.setLayout(new BorderLayout());
        panel.add(icon, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(null, panel, "Tower", JOptionPane.PLAIN_MESSAGE);
        
        System.out.println("-".repeat(40));
        System.out.printf("Tower's AttackPoint: %.0f\n", AP);
        System.out.printf("Tower's CriticalRate: %.0f%%\n", CritRate);
        System.out.printf("Tower's Accuracy: %.0f%%\n\n", Acc);
        System.out.println("1. Upgrade Attack (100 Gold -> AttackPoint)");
        System.out.println("2. Upgrade Critical Chance (100 Gold -> 5 Critical Chance %)");
        System.out.println("3. Upgrade Accuracy (100 Gold -> 4 % Accuracy)");
        System.out.println("4. Back to menu");
        System.out.println("-".repeat(40));
        boolean bError = true;
        int com = 0;
        do{
            do{
                System.out.print("Please enter your command: ");
                try{
                    com = sc.nextInt();
                    bError = false;

                    if(com<1 || com>4) {
                        System.out.println("Option not available, please try again. ");
                        System.out.println("-".repeat(40));
                        System.out.print("Please enter your command: ");
                        com = sc.nextInt();
                    }

                    System.out.println("-".repeat(40));
                    switch(com){
                        case 1 -> {
                            if(Gold.goldCheck(100)){
                                System.out.print("Tower's AttackPoint has been upgraded. Tower AP " + AP + " -> ");
                                AP += 1;
                                System.out.println(AP);
                                System.out.printf("Gold : %d -> ", Gold.gold);
                                Gold.gold -= 100;
                                System.out.printf("%d\n", Gold.gold);
                            }else{
                                System.out.println("Our treasury is empty. Upgrade failed.");
                            }
                            System.out.println("-".repeat(40));
                            System.out.print("Press ENTER to continue.");
                            enterScanner.nextLine();
                            Upgrade();
                        }
                        case 2 -> {
                            if(Gold.goldCheck(100)){
                                if(CritRate < 50){
                                    System.out.print("Tower's Critical Rate has been upgraded. Tower Crit " + CritRate + " -> ");
                                    CritRate += 5;
                                    System.out.println(CritRate);
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
                            Upgrade();              
                        }
                        case 3 -> {
                            if(Gold.goldCheck(100)){
                                if(Acc < 100){
                                    System.out.print("Tower's Accuracy has been upgraded. Tower Acc " + Acc + " -> ");
                                    Acc += 4;
                                    System.out.println(Acc);
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
                            Upgrade();   
                        }
                        case 4 -> Game_Logic.waitforCommand();
                    }
                }catch(InputMismatchException e){
                    System.out.println("Error! Please enter an Integer.");
                    System.out.println("-".repeat(40));
                    sc.next();
                }
            }while(bError);
        }while (com<1 || com>4);
    }
}    