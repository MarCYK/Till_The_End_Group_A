package TTE;
public class TTE {
    static Game_Logic gl = new Game_Logic();
    
    public static void main(String[] args) {
        game_loop();
        
        /* To do create a run time loop
        while(true){
            game_loop();
        }
        */
    }
    
    public static void game_loop(){
        gl.game();
    }
    
}
