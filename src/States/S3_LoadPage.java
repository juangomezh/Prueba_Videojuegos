/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import static States.S0_MainMenu.lastStage;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
/**
 *
 * @author razvanvc
 */
public class S3_LoadPage extends BasicGameState{

    public S3_LoadPage(int state) {
    }
    
    
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("You're in the load page",100,100);
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
           sbg.enterState(lastStage);
        }
    }
    @Override
    public int getID() {
        return 3;
    }
}
