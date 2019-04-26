/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import MusicPlayer.*;
import java.awt.Font;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 *
 * @author razvanvc
 */
public class S0_MainMenu extends BasicGameState{

    public String mouse = "No input yet!";
    Image play;
    private int playersChoice = 0;
    private static final int NOCHOICES = 4;
    private static final int START = 0;
    private static final int LOAD = 1;
    private static final int OPTIONS = 2;
    private static final int QUIT = 3;
    private final String[] playersOptions = new String[NOCHOICES];
    private Font font;
    private TrueTypeFont playersOptionsTTF;
    private final Color notChosen = new Color(153, 204, 255);
    private final Color background = new Color(0, 0, 255);
    public static int lastStage;
    
    private boolean playingMuscic = true;
    public MusicPlayer musicplayer = new MusicPlayer();
    
    
    public S0_MainMenu(int state) {
    }
    
    
    @Override
    //Initialice some stuff (dont know yet)
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        //play = new Image("res/play button.png");
        
        playersOptions[0] = "Start";
        playersOptions[1] = "Load";
        playersOptions[2] = "Options";
        playersOptions[3] = "Quit";
        font = new Font("Verdana", Font.BOLD, 25);
        playersOptionsTTF = new TrueTypeFont(font, true);
        lastStage = sbg.getCurrentStateID();
        musicplayer.playTrack(1);
        //musicplayer.setVolume(); Implement function (dont work yet)
    }

    @Override
    //Draws things on the screen
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString(mouse, 950, 10);//muestra la posicion de raton
        renderPlayersOptions();
    }

    @Override
    //Make possible the movement
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        //Consigue la posicion del raton
        int xpos = Mouse.getX();
        int ypos = Mouse.getY();
        mouse = xpos + " " + ypos; //cambia la variable de la posicion del raton
        
        Input input = gc.getInput();
        if (input.isKeyPressed(Input.KEY_DOWN)) {
            if (playersChoice == (NOCHOICES - 1)) {
                playersChoice = 0;
            } else {
                playersChoice++;
            }
        }
        if (input.isKeyPressed(Input.KEY_UP)) {
            if (playersChoice == 0) {
                playersChoice = NOCHOICES - 1;
            } else {
                playersChoice--;
            }
        }
        if (input.isKeyPressed(Input.KEY_ENTER)) {
            switch (playersChoice) {
                case QUIT:
                    sbg.enterState(6);
                    break;
                case START:
                    sbg.enterState(1);
                    playingMuscic = false;
                    break;
                case LOAD:
                    sbg.enterState(3);
                    break;
                case OPTIONS:
                    sbg.enterState(4);
                    break;    
            }
        }
        if (input.isKeyPressed(Input.KEY_ESCAPE) && lastStage == 1){
            sbg.enterState(1);
        }
        
    }
    
    @Override
    //Return the state of the menu (0)
    public int getID() {
        return 0;
    }
    
    private void renderPlayersOptions() {
        for (int i = 0; i < NOCHOICES; i++) {
            if (playersChoice == i) {
                playersOptionsTTF.drawString(100, i * 50 + 200, playersOptions[i]);
            } else {
                playersOptionsTTF.drawString(100, i * 50 + 200, playersOptions[i], notChosen);
            }
        }
    }
}