package TTE;
import static TTE.Game_Logic.Determined24;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Events {
    Random random = new Random();
    static int year = 1;
    static int season = 0;
    static String seasonName;
    static boolean isWinter = false;
    static boolean tempStatDrop = false;
    
    
    public void Spring(){
        seasonName = "Spring";
        
        ImageIcon TitlePNG = new ImageIcon("Spring.png");
        JLabel icon = new JLabel(TitlePNG);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(219, 233, 240));
        panel.setLayout(new BorderLayout());
        panel.add(icon, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(null, panel, "Spring Screen", JOptionPane.PLAIN_MESSAGE);
        
        //Generate 0,1,2
        int rand = random.nextInt(3);
        switch(rand){
            //reinforcement; towerAP +1
            case 0 -> {         
                System.out.println("Reinforcements have arrived! Tower's AttackPoint +1");
                System.out.print("Tower AP " + Tower.AP + " -> ");
                Tower.AP++;
                System.out.println(Tower.AP);
                
                Sound sound = new Sound("Rome Total War - Reinforcements Sound.wav");
                sound.play();
                ImageIcon TitlePNG2 = new ImageIcon("reinforcements.jpg");
                JLabel icon2 = new JLabel(TitlePNG2);
                JPanel panel2 = new JPanel();
                panel2.setBackground(Color.BLACK);
                panel2.setLayout(new BorderLayout());
                panel2.add(icon2, BorderLayout.CENTER);
                JOptionPane.showMessageDialog(null, panel2, "reinforcements", JOptionPane.PLAIN_MESSAGE);
                sound.stop();
            }
            //Visitors; gold +100
            case 1 -> {
                System.out.println("A group of merchants visit your city! Gold +100");
                System.out.print("Gold " + Gold.gold + " -> ");
                Gold.gold += 100;
                System.out.println(Gold.gold);
            }
            //Festival; berserk,diligent,fearless +50
            case 2 -> {
                System.out.println("Festival Celebration! Citizen's Berserk, Diligent and Fearless +50");
                System.out.print("Berserk " + Citizen.berserk + " -> ");
                Citizen.berserk += 50;
                System.out.println(Citizen.berserk);
                System.out.print("Diligent " + Citizen.diligent + " -> ");
                Citizen.diligent += 50;
                System.out.println(Citizen.diligent);
                System.out.print("Fearless " + Citizen.fearless + " -> ");
                Citizen.fearless += 50;
                System.out.println(Citizen.fearless);
                Citizen.citizenAffect();
            }
        }
    }
    
    public void Summer(){
        seasonName = "Summer";
        
        ImageIcon TitlePNG = new ImageIcon("Summer.png");
        JLabel icon = new JLabel(TitlePNG);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(219, 233, 240));
        panel.setLayout(new BorderLayout());
        panel.add(icon, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(null, panel, "Summer Screen", JOptionPane.PLAIN_MESSAGE);
        
        int rand = random.nextInt(3);
        switch(rand){
            case 0 -> {
                System.out.println("Drought! Too thirsty to guard the walls. Wall HP -50");
                System.out.print("Wall HP " + Wall.wallHP + " -> ");
                Wall.wallHP -= 50;
                System.out.println(Wall.wallHP);
            }
            case 1 -> {
                System.out.println("Outing! Citizens' spirits are lifted. Citizen's Berserk, Diligent and Fearless +50");
                System.out.print("Berserk " + Citizen.berserk + " -> ");
                Citizen.berserk += 50;
                System.out.println(Citizen.berserk);
                System.out.print("Diligent " + Citizen.diligent + " -> ");
                Citizen.diligent += 50;
                System.out.println(Citizen.diligent);
                System.out.print("Fearless " + Citizen.fearless + " -> ");
                Citizen.fearless += 50;
                System.out.println(Citizen.fearless);             
                Citizen.citizenAffect();                
            }
            case 2 -> {
                System.out.println("Heatstroke! Some citizens become bedridden. Citizen's Emotional, Nervous and Lazy +50");
                System.out.print("Emotional " + Citizen.emotional + " -> ");
                Citizen.emotional += 50;
                System.out.println(Citizen.emotional);
                System.out.print("Nervous " + Citizen.nervous + " -> ");
                Citizen.nervous += 50;
                System.out.println(Citizen.nervous);
                System.out.print("Lazy " + Citizen.lazy + " -> ");
                Citizen.lazy += 50;
                System.out.println(Citizen.lazy);                  
                Citizen.citizenAffect();
            }
        }
    }
    
    public void Autumn(){
        seasonName = "Autumn";
        
        ImageIcon TitlePNG = new ImageIcon("Autumn.png");
        JLabel icon = new JLabel(TitlePNG);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(219, 233, 240));
        panel.setLayout(new BorderLayout());
        panel.add(icon, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(null, panel, "Autumn Screen", JOptionPane.PLAIN_MESSAGE);
        
        int rand = random.nextInt(3);
        switch(rand){
            case 0 -> {
                System.out.print("Rainy! Vision reduced. ");
                System.out.println("Tower Accuracy -20%(This season only)");
                // apply seasonal debuff
                System.out.print("Tower Accuracy " + Tower.Acc + " -> ");
                Tower.Acc -= 20;
                System.out.println(Tower.Acc);
                tempStatDrop = true;
            }
            case 1 -> {
                System.out.println("Flood! Tower walls are damaged. Wall HP -50");
                System.out.print("Wall HP " + Wall.wallHP + " -> ");
                Wall.wallHP -= 50;
                System.out.println(Wall.wallHP);
            }
            case 2 -> {
                System.out.println("Harvest! Gold +100");
                System.out.print("Gold " + Gold.gold + " -> ");
                Gold.gold += 100;
                System.out.println(Gold.gold);
            }
        }        
    }
    
    public void Winter(){
        seasonName = "Winter";
        isWinter = true;
        
        ImageIcon TitlePNG = new ImageIcon("winter.png");
        JLabel icon = new JLabel(TitlePNG);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(219, 233, 240));
        panel.setLayout(new BorderLayout());
        panel.add(icon, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(null, panel, "Winter Screen", JOptionPane.PLAIN_MESSAGE);
        
        int rand = random.nextInt(4);
        switch(rand){
            case 0 -> {
                new Game_Logic.AePlayWave("blizzard.wav").start();
                System.out.println("Blizzard! Tower walls are damaged. Wall HP -50");
                System.out.print("Wall HP " + Wall.wallHP + " -> ");
                Wall.wallHP -= 50;
                System.out.println(Wall.wallHP);
            }
            case 1 -> {
                System.out.println("Avalanche! The citizens are panicking. Citizen's Emotional, Nervous and Lazy +50");
                System.out.print("Emotional " + Citizen.emotional + " -> ");
                Citizen.emotional += 50;
                System.out.println(Citizen.emotional);
                System.out.print("Nervous " + Citizen.nervous + " -> ");
                Citizen.nervous += 50;
                System.out.println(Citizen.nervous);
                System.out.print("Lazy " + Citizen.lazy + " -> ");
                Citizen.lazy += 50;
                System.out.println(Citizen.lazy);              
                Citizen.citizenAffect();
            }
            case 2 -> {
                System.out.print("Hunger! The citizens can't think straight. ");
                System.out.println("Tower Accuracy -20%(This season only)");
                // apply seasonal debuff
                System.out.print("Tower Accuracy " + Tower.Acc + " -> ");
                Tower.Acc -= 20;
                System.out.println(Tower.Acc);
                tempStatDrop = true;
            }
            case 3 -> {
                System.out.println("Tour Group! Extra income. Gold +100");
                System.out.print("Gold " + Gold.gold + " -> ");
                Gold.gold += 100;
                System.out.println(Gold.gold);           
            }
        }
    }
    
    public void events(){
        // move on to next season
        season++;
        // remove seasonal debuff (line 80)
        if (tempStatDrop) {
            System.out.println("The citizens have recovered from previous season.");
            System.out.print("Tower Accuracy " + Tower.Acc + " -> ");
            if (Tower.Acc >= 80) { // To prevent reaching past stat cap
                Tower.Acc = 100;
            } else {
                Tower.Acc += 20;                
            }
            System.out.println(Tower.Acc);
            tempStatDrop = false;
        }
        // move on to next year if past winter season
        if (isWinter) {
            year++;
            season = 1;
            isWinter = false;
        }
        
        System.out.print("Event: ");
        switch(season){
            case 1 -> Spring();
            case 2 -> Summer();
            case 3 -> Autumn();
            case 4 -> Winter();
            default -> {}
        }
    }
}
