/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisplayImage;

import java.awt.Point;
import java.util.LinkedList;

/**
 *
 * @author huele
 */
public class Monster {
    private String name;
    private int player;
    private int turn;
    private javax.swing.JLabel VP;//Victory Points
    private javax.swing.JLabel HP;//Heal Points
    private javax.swing.JLabel EP;//Energy Points
    private javax.swing.JLabel PC;
    private javax.swing.JLabel pIcon;
    private javax.swing.JLabel pLabel;
    private javax.swing.JLabel PCurrent;
    private LinkedList<Card> monsterCards;
    private boolean insideTokyo;
    private int howManyDice;
    private Monster curMonser; 
    private Point pLabelOrigLocation;
    
    public Monster(String name, int player){
        this.name = name;
        this.player = player;
        this.turn = 0;
        this.VP = new javax.swing.JLabel();
        this.HP = new javax.swing.JLabel();
        this.EP = new javax.swing.JLabel();
        this.PC = new javax.swing.JLabel();
        this.pIcon = new javax.swing.JLabel();
        this.pLabel = new javax.swing.JLabel();
        this.PCurrent = new javax.swing.JLabel();
        this.insideTokyo = false; 
        this.howManyDice = 6;
        monsterCards = new LinkedList<Card>();
        this.pLabelOrigLocation = new Point(0,0);
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
    public javax.swing.JLabel getHP() {
        return HP;
    }

    /**
     * @param HP the HP to set
     */
    public void setHP(javax.swing.JLabel HP) {
        this.HP = HP;
    }

    /**
     * @return the VP
     */
    public javax.swing.JLabel getVP() {
        return VP;
    }

    /**
     * @param VP the VP to set
     */
    public void setVP(javax.swing.JLabel VP) {
        this.VP = VP;
    }

    /**
     * @return the EP
     */
    public javax.swing.JLabel getEP() {
        return EP;
    }

    /**
     * @param EP the EP to set
     */
    public void setEP(javax.swing.JLabel EP) {
        this.EP = EP;
    }

    /**
     * @return the PC
     */
    public javax.swing.JLabel getPC() {
        return PC;
    }

    /**
     * @param PC the PC to set
     */
    public void setPC(javax.swing.JLabel PC) {
        this.PC = PC;
    }

    /**
     * @return the pIcon
     */
    public javax.swing.JLabel getpIcon() {
        return pIcon;
    }

    /**
     * @param pIcon the pIcon to set
     */
    public void setpIcon(javax.swing.JLabel pIcon) {
        this.pIcon = pIcon;
    }

    /**
     * @return the pLabel
     */
    public javax.swing.JLabel getpLabel() {
        return pLabel;
    }

    /**
     * @param pLabel the pLabel to set
     */
    public void setpLabel(javax.swing.JLabel pLabel) {
        this.pLabel = pLabel;
    }

    /**
     * @return the PCurrent
     */
    public javax.swing.JLabel getPCurrent() {
        return PCurrent;
    }

    /**
     * @param PCurrent the PCurrent to set
     */
    public void setPCurrent(javax.swing.JLabel PCurrent) {
        this.PCurrent = PCurrent;
    }

    /**
     * @return the isInsideTokyo
     */
    public boolean isInsideTokyo() {
        return insideTokyo;
    }

    /**
     * @param isInsideTokyo the isInsideTokyo to set
     */
    public void setInsideTokyo(boolean isInsideTokyo) {
        this.insideTokyo = isInsideTokyo;
    }

    /**
     * @return the howManyDice
     */
    public int getHowManyDice() {
        return howManyDice;
    }

    /**
     * @param howManyDice the howManyDice to set
     */
    public void setHowManyDice(int howManyDice) {
        this.howManyDice = howManyDice;
    }
    
    public void addCard(Card card) {
        monsterCards.add(card);
    }
    
    public LinkedList getMonsterCards() {
        return monsterCards;
    }
    
    public Monster getCurMonster() {
        return curMonser;
    }
    
    public void setcurMonster(Monster curM) {
        this.curMonser = curM;
    }
    /**
     * @return the origLocation
     */
    public Point getpLabelOrigLocation() {
        return pLabelOrigLocation;
    }

    /**
     * @param origLocation the origLocation to set
     */
    public void setpLabelOrigLocation(Point origLocation) {
        this.pLabelOrigLocation = origLocation;
    }
}