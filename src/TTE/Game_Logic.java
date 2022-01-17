package TTE;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;

public class Game_Logic {
    static Scanner sc = new Scanner(System.in);
    static Scanner enterScanner = new Scanner(System.in);
    static Tower tower = new Tower();
    static Dragon dragon = new Dragon();
    static Events events = new Events();
    static Save save = new Save();
    static Font Determined20;
    static Font Determined24;
    static Font Determined30;
    static boolean isHardMode=false;
    
    public Game_Logic(){
        //import custom font
        try{
            Determined20 = Font.createFont(Font.TRUETYPE_FONT, new File("DeterminationSansWebRegular-369X.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Determined20);
        }catch(IOException | FontFormatException e){
            
        }
        
        try{
            Determined24 = Font.createFont(Font.TRUETYPE_FONT, new File("DeterminationSansWebRegular-369X.ttf")).deriveFont(24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Determined24);
        }catch(IOException | FontFormatException e){
            
        }
        
        try{
            Determined30 = Font.createFont(Font.TRUETYPE_FONT, new File("DeterminationSansWebRegular-369X.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Determined24);
        }catch(IOException | FontFormatException e){
            
        }
    }
    static Sound sound = new Sound("victory.wav");
    public static void game(){
        sound.play();
        ImageIcon TitlePNG = new ImageIcon("intro.gif");
        JLabel icon = new JLabel(TitlePNG);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(icon, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(null, panel, "Intro", JOptionPane.PLAIN_MESSAGE);
        
        //create Popup title
        ImageIcon TitlePNG2 = new ImageIcon("Front_page.png");
        JLabel icon2 = new JLabel(TitlePNG2);
        JLabel text2 = new JLabel(" ".repeat(30)+ "Welcome to Till The End - A Tower Defense Game!");
        text2.setFont(Determined20);
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(219, 233, 240));
        panel2.setLayout(new BorderLayout());
        panel2.add(icon2, BorderLayout.CENTER);
        panel2.add(text2, BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(null, panel2, "Title Screen", JOptionPane.PLAIN_MESSAGE);
        //catch InputMismatchException - not Int
        boolean bError = true;
        int com = 0;
        int hardcom = 0;
        do{
            do{
                System.out.println("1. New game\n2. Load previous save");
                System.out.println("-".repeat(40));
                System.out.print("Please enter your command: ");
                try{
                    com = sc.nextInt();
                    bError = false;

                    if(com<1 || com>2) {
                        System.out.println("Option not available, please try again.");
                        System.out.println("-".repeat(40));
                    }

                    switch(com){
                        case 1 -> { 
                            System.out.println("-".repeat(40));
                            System.out.println("1. Normal\n2. Hard");
                            System.out.println("-".repeat(40));

                            System.out.print("Plese select the difficulty: ");
                            hardcom= sc.nextInt();
                            if(hardcom<1 || hardcom>2){
                                System.out.println("Option not available, please try again.");
                                System.out.println("-".repeat(40));
                            }
                            switch(hardcom){
                                case 1 -> fight();
                                case 2 -> {
                                    isHardMode=true;
                                    Dragon.AP=8;
                                    Dragon.CritRate=24;
                                    Dragon.dragonHP=130;
                                    fight();
                                }
                            }
                        }
                        case 2 -> Save.load();
                    }
                }catch(InputMismatchException e){
                    System.out.println("Error! Please enter an Integer.");
                    System.out.println("-".repeat(40)); 
                    sc.next();
                }
            }while(bError);
        }while(com<1 || com>2 && hardcom<1 || hardcom>2);
        
    }
    
    //main interface
    public static void waitforCommand(){
        sound.stop();
        System.out.print("1. Tower\n2. Wall\n3. Citizen\n4. I am all ready!\n5. Save your progress\n");
        System.out.println("-".repeat(40));
        boolean bError = true;
        int com = 0;
        do{
            do{
                System.out.print("Please enter your command: ");
                try{
                    com = sc.nextInt();
                    bError = false;

                    if (com<1 || com>5) {
                        System.out.println("Option not available, please try again.");
                        System.out.println("-".repeat(40));
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
                }catch(InputMismatchException e){
                    System.out.println("Error! Please enter an Integer.");
                    System.out.println("-".repeat(40));
                    sc.next();
                }
            }while(bError);
        }while (com<1 || com>5);
    }
    
    //Transition to attack sequence
    public static void fight(){
        sound.stop();
        new AePlayWave("DragonRoar.wav").start();
        //create Fight Popup
        ImageIcon DragonPNG = new ImageIcon("Dragonchibi.png");
        JLabel icon = new JLabel(DragonPNG);
        JLabel text = new JLabel("<html>" + "A dragon performs a sudden attack to your city!"
                + "<br> Dragon's Level: " + Dragon.dragonLvl
                + "<br> Dragon's HealthPoint: " + Dragon.dragonHP 
                + "<br> Dragon's AttackPoint: " + Dragon.AP 
                + "<br> Dragon's Critical Chance: " + Dragon.CritRate 
                + "%<br> Dragon's Accuracy: " + Dragon.Acc + "%</html>");
        text.setFont(Determined24);
        text.setForeground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BorderLayout());
        panel.add(icon, BorderLayout.CENTER);
        panel.add(text, BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(null, panel, "Fight Screen", JOptionPane.PLAIN_MESSAGE);
        
        /*System.out.println("A dragon performs a sudden attack to your city!");
        System.out.printf("Dragon's Level: %.0f\n", Dragon.dragonLvl);
        System.out.printf("Dragon's HealthPoint: %.0f\n", Dragon.dragonHP);
        System.out.printf("Dragon's AttackPoint: %.0f\n", Dragon.AP);
        System.out.printf("Dragon's Critical Chance: %.0f%%\n", Dragon.CritRate);
        System.out.printf("Dragon's Accuracy: %.0f%%\n",Dragon.Acc);*/
        
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
        new AePlayWave("TEUTON.wav").start();
        dragon.Upgrade(); // line 120
        // Complete one dragon fight message
        //create Survival PopUp
        ImageIcon Survival = new ImageIcon("flagBrearer.gif");
        JLabel iconSurvive = new JLabel(Survival);
        JLabel textSurvive = new JLabel("<html>" + " The dragon grows weary and fled." 
                + "<br> The citizens cheer as they survived the attack." 
                + "<br> They resume their daily life and prepare for the next season.");
        textSurvive.setFont(Determined20);
        textSurvive.setForeground(Color.WHITE);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLACK);
        panel2.setLayout(new BorderLayout());
        panel2.add(iconSurvive, BorderLayout.CENTER);
        panel2.add(textSurvive, BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(null, panel2, "Survival Screen", JOptionPane.PLAIN_MESSAGE);
        
        /*System.out.println("-".repeat(40));
        System.out.println("The dragon grows weary and fled.");
        System.out.println("The citizens cheer as they survived the attack.");
        System.out.println("They resume their daily life and prepare for the next season.");
        System.out.println("-".repeat(40));*/
        
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
                new AePlayWave("DragonAttack.wav").start();
                ImageIcon TitlePNG = new ImageIcon("DragonAttack2.gif");
                JLabel icon = new JLabel(TitlePNG);
                JLabel text = new JLabel(" ".repeat(30)+ "Dragon attacked our wall with critical attack!");
                text.setFont(Determined20);
                text.setForeground(Color.WHITE);
                JPanel panel = new JPanel();
                panel.setBackground(Color.BLACK);
                panel.setLayout(new BorderLayout());
                panel.add(icon, BorderLayout.CENTER);
                panel.add(text, BorderLayout.SOUTH);
                JOptionPane.showMessageDialog(null, panel, "Title Screen", JOptionPane.PLAIN_MESSAGE);
                
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
                    new AePlayWave("sword.wav").start();
                    ImageIcon TitlePNG = new ImageIcon("swordslash.gif");
                    JLabel icon = new JLabel(TitlePNG);
                    JLabel text = new JLabel("Tower attacked dragon with critical attack!");
                    text.setFont(Determined20);
                    text.setForeground(Color.WHITE);
                    JPanel panel = new JPanel();
                    panel.setBackground(Color.BLACK);
                    panel.setLayout(new BorderLayout());
                    panel.add(icon, BorderLayout.CENTER);
                    panel.add(text, BorderLayout.SOUTH);
                    JOptionPane.showMessageDialog(null, panel, "Title Screen", JOptionPane.PLAIN_MESSAGE);

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
        System.out.printf("Year : %d\n", Events.year);
        System.out.printf("Season : %s\n", Events.seasonName);
        System.out.printf("Gold : %d\n", Gold.gold);
        waitforCommand(); // line 22
    }
    
    //Lost the game
    public static void defeat()
    {
        new AePlayWave("Defeat.wav").start();
        ImageIcon TitlePNG = new ImageIcon("Defeated.gif");
        JLabel icon = new JLabel(TitlePNG);
        JLabel text = new JLabel(" ".repeat(20)+ "You failed to protect your city!");
        text.setFont(Determined24);
        text.setForeground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BorderLayout());
        panel.add(icon, BorderLayout.CENTER);
        panel.add(text, BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(null, panel, "Defeat Screen", JOptionPane.PLAIN_MESSAGE);
        
        //System.out.println("You failed to protect your city!");
        
        credit();
    }
    
    //Won the game
    public static void victory()
    {
        new AePlayWave("WON1.wav").start();
        ImageIcon TitlePNG = new ImageIcon("Victory.png");
        JLabel icon = new JLabel(TitlePNG);
        JLabel text = new JLabel(" ".repeat(10)+ "You killed the dragon! You protected your city!");
        text.setFont(Determined24);
        text.setForeground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BorderLayout());
        panel.add(icon, BorderLayout.CENTER);
        panel.add(text, BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(null, panel, "Defeat Screen", JOptionPane.PLAIN_MESSAGE);
        
        //System.out.println("You killed the dragon! You protected your city!");
        
        credit();
    }
    
    public static void credit()
    {
        ImageIcon TitlePNG = new ImageIcon("Victory.gif");
        JLabel icon = new JLabel(TitlePNG);
        JLabel text = new JLabel("<html><center>CREDITS<br>DERRICK MARVIN LUQMAN ALVIN ANN</center></html>");
        text.setFont(Determined30);
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.add(icon, BorderLayout.CENTER);
        panel.add(text, BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(null, panel, "Defeat Screen", JOptionPane.PLAIN_MESSAGE);
        
        //System.out.println("You killed the dragon! You protected your city!");
        
        System.exit(0);
    }
    
    //play audio
    //new AePlayWave("file.wav").start();
    public static class AePlayWave extends Thread { 
 
        private String filename;

        private Position curPosition;

        private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb 

        enum Position { 
            LEFT, RIGHT, NORMAL
        };

        public AePlayWave(String wavfile) { 
            filename = wavfile;
            curPosition = Position.NORMAL;
        } 

        public AePlayWave(String wavfile, Position p) { 
            filename = wavfile;
            curPosition = p;
        } 

        public void run() { 

            File soundFile = new File(filename);
            if (!soundFile.exists()) { 
                System.err.println("Wave file not found: " + filename);
                return;
            } 

            AudioInputStream audioInputStream = null;
            try { 
                audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            } catch (UnsupportedAudioFileException e1) { 
                e1.printStackTrace();
                return;
            } catch (IOException e1) { 
                e1.printStackTrace();
                return;
            } 

            AudioFormat format = audioInputStream.getFormat();
            SourceDataLine auline = null;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            try { 
                auline = (SourceDataLine) AudioSystem.getLine(info);
                auline.open(format);
            } catch (LineUnavailableException e) { 
                e.printStackTrace();
                return;
            } catch (Exception e) { 
                e.printStackTrace();
                return;
            } 

            if (auline.isControlSupported(FloatControl.Type.PAN)) { 
                FloatControl pan = (FloatControl) auline
                        .getControl(FloatControl.Type.PAN);
                if (curPosition == Position.RIGHT) 
                    pan.setValue(1.0f);
                else if (curPosition == Position.LEFT) 
                    pan.setValue(-1.0f);
            } 

            auline.start();
            int nBytesRead = 0;
            byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

            try { 
                while (nBytesRead != -1) { 
                    nBytesRead = audioInputStream.read(abData, 0, abData.length);
                    if (nBytesRead >= 0) 
                        auline.write(abData, 0, nBytesRead);
                } 
            } catch (IOException e) { 
                e.printStackTrace();
                return;
            } finally { 
                auline.drain();
                auline.close();
            } 

        } 
    } 
}
