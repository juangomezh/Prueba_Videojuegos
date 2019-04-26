/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Characters;

import Map.Mapa;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import Map.*;
import org.newdawn.slick.Image;
/**
 *
 * @author Javier Muñoz
 */
public class PlayableCharacter extends Character
{
    //Interaction with NPCs and enemies need to be implemented.
    private String pCName;
    private Inventory inventory;
    private Hitbox collisionBox;   //This is the rectangles that represents
    private float speed;                    //the collision box of the char.
    
    public PlayableCharacter(String id, float xPos, float yPos, String pCName, float speed, int health)
    {
        super(id, xPos, yPos, speed, health);
        this.pCName = pCName;
        this.inventory = new Inventory();
        this.collisionBox = new Hitbox(xPos, yPos, 25, 25);//This is if the character is 30x30 px
    }
    
    @Override
    public String toString()    //This will return the player in a String format
    {
        return "xPos: "+getxPos()
              +"\nyPos: "+getyPos()
              +"\nID: "+getId()
              +"\nName: "+getpCName()
              +"\nSpeed: "+getSpeed()
              +"\nHealth: "+getHp();
    }
    /**
     * 
     * @return if the character is dead.
     */
    public boolean isDead()
    {
        return this.getHp()<=0;
    }

    /**
     * @return the pCName
     */
    public String getpCName() {
        return pCName;
    }

    /**
     * @param pCName the pCName to set
     */
    public void setpCName(String pCName) {
        this.pCName = pCName;
    }

    /**
     * @return the inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * @param inventory the inventory to set
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * @return the collision box of the character
     */
    public Hitbox getCollision() {
        return collisionBox;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void move(float x, float y) {
        this.xPos = x;
        this.yPos = y;
    }

    @Override
    public float getYPos() {
        return yPos;
    }

    @Override
    public float getXPos() {
        return xPos;
    }

    /**
     * @return the map
     */

    
}
