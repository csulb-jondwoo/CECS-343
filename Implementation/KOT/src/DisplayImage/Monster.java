/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisplayImage;

import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author huele
 */
public class Monster {
    private String name;
    private int player;
    private int turn;
    private int HP;//Heal Points
    private int VP;//Victory Points
    private int EP;//Energy Points
    private int PC;
    private Icon img;
    
    public Monster(String name, int player){
        this.name = name;
        this.player = player;
        this.turn = 0;
        this.HP = 10;
        this.VP = 0;
        this.EP = 0;
        this.PC = 88;
        this.img = new javax.swing.ImageIcon();
        
    }

    
    public Icon getImg(){
        return this.img;
    }
    
    public void setImg(Icon img){
        this.img = img;
    }
    
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the player
     */
    public int getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(int player) {
        this.player = player;
    }

    /**
     * @return the turn
     */
    public int getTurn() {
        return turn;
    }

    /**
     * @param turn the turn to set
     */
    public void setTurn(int turn) {
        this.turn = turn;
    }

    /**
     * @return the HP
     */
    public int getHP() {
        return HP;
    }

    /**
     * @param HP the HP to set
     */
    public void setHP(int HP) {
        this.HP = HP;
    }

    /**
     * @return the VP
     */
    public int getVP() {
        return VP;
    }

    /**
     * @param VP the VP to set
     */
    public void setVP(int VP) {
        this.VP = VP;
    }

    /**
     * @return the EP
     */
    public int getEP() {
        return EP;
    }

    /**
     * @param EP the EP to set
     */
    public void setEP(int EP) {
        this.EP = EP;
    }

    /**
     * @return the PC
     */
    public int getPC() {
        return PC;
    }

    /**
     * @param PC the PC to set
     */
    public void setPC(int PC) {
        this.PC = PC;
    }
    
    
    
}
