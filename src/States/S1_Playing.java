/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import Entities.Characters.*;
import static States.S0_MainMenu.lastStage;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import Map.*;
import java.util.ArrayList;
import static org.newdawn.slick.Color.black;
/**
 *
 * @author razvanvc
 */


public class S1_Playing extends BasicGameState {
    private Mapa map;
    private boolean fog=true;
    private boolean interact=false;
    private PlayableCharacter Char;
    private ArrayList<NPC> npcs;
    private Enemy enemy;
    public S1_Playing(int playing) {
    }

    @Override
    //Initialice some stuff (dont know yet)
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        Char=new PlayableCharacter("id",(float) gc.getWidth()/2,(float) gc.getHeight()/2, "pCName",  50, 100);
        map=new Mapa("src/Tiled/Laberinth.tmx", gc, Char, npcs, enemy);
        int positionx=-625, positiony=-405;
        map.setX(positionx);
        map.setY(positiony);
        map.actualizarIt(positionx,positiony);
        map.actualizarMuros(positionx,positiony);
    }

    @Override
    //Draws things on the screen
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        map.renderMap(gc, g, true);
        g.setColor(Color.white);
        interact(g);
        g.setColor(black);
        if(fog)
        {
            g.fillRect(0, 0, gc.getWidth(), (float) (gc.getHeight()/(2.55)));
            g.fillRect(0, 0, (float) (gc.getWidth()/(2.4)), gc.getHeight());
            g.fillRect(0, (float) (gc.getHeight()/(1.54)), gc.getWidth(), (float) (gc.getHeight()/2.4));
            g.fillRect((float) (gc.getWidth()/(1.62)),0, gc.getWidth()/(2), gc.getHeight());
        }
    }

    @Override
    //Make possible the movement
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        map.Movimiento((int) map.getCharacter().getSpeed(), gc);
        interact=map.interact();
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
           sbg.enterState(5);
           lastStage = sbg.getCurrentStateID();
        }
    }
    @Override
    //Return the state of the menu (0)
    public int getID() {
        return 1;
    }
    public void interact(Graphics g)
    {
        if(interact)
        {
            g.drawString("INTERACT", (int) map.getCharacter().getXPos()-20, (int) map.getCharacter().getYPos()+32);
            interact=false;
        }
    }

}
