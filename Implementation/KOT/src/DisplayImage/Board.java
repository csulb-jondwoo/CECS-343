/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisplayImage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.lang.Math.*;


/**
 *
 * @author Hueletl
 */
public class Board extends javax.swing.JFrame {

    /**
     * Creates new form Board
     */
    public Board() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public Board(LinkedList <Monster> monsters) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.monsters = monsters; 
        
        // add monsters to frames list
        monsterFrames = new LinkedList<javax.swing.JLabel>();
        monsterFrames.add(frame1);
        monsterFrames.add(frame2);
        monsterFrames.add(frame3);
        monsterFrames.add(frame4);
        monsterFrames.add(frame5);
        monsterFrames.add(frame6);
        
        // add splitpane to splitpanes list
        splitPanes = new LinkedList<javax.swing.JSplitPane>();
        splitPanes.add(jSplitPane1);
        splitPanes.add(jSplitPane2);
        splitPanes.add(jSplitPane3);
        splitPanes.add(jSplitPane4);
        splitPanes.add(jSplitPane5);
        splitPanes.add(jSplitPane6);
        splitPanes.add(jSplitPane7);
        splitPanes.add(jSplitPane8);
        splitPanes.add(jSplitPane9);
        splitPanes.add(jSplitPane10);
        splitPanes.add(jSplitPane11);
        splitPanes.add(jSplitPane12);
        splitPanes.add(jSplitPane13);
        splitPanes.add(jSplitPane14);
        splitPanes.add(jSplitPane15);
        splitPanes.add(jSplitPane16);
        splitPanes.add(jSplitPane17);
        splitPanes.add(jSplitPane18);
        splitPanes.add(jSplitPane19);
        splitPanes.add(jSplitPane20);
        splitPanes.add(jSplitPane21);
        splitPanes.add(jSplitPane22);
        splitPanes.add(jSplitPane23);
        splitPanes.add(jSplitPane24);
        
        
        // set map background and frame to window size
        map.setBounds(600, 0, 600, 800);
        ImageResizer.setImage(map, "tokyoLand.jpg");
        
        // set monster frame and its panes
        for(int i = 0; i < 6; i++){
            // monster frame
            setFrameVisible(monsterFrames.get(i), false);
            int x = 0;
            int y = 0;
            if(i % 2 == 0){
                y = (i/2) * 266;         
            }else{
                x = 300;
                y = (int)Math.floor(i/2) * 266;
            }
            setFrameBounds(monsterFrames.get(i), x, y);
            
            
            // splitpanes
            int k = 0;
            for(int j = (4*i); j < (4*(i+1)); ++j, ++k){
                setPaneVisible(splitPanes.get(j), false);
                int paneX = x + 2;
                int paneY = y + 2;
                if(k%2 == 0){
                    paneY = y + ((k/2) * 222) + 2;
                }else{
                    paneX = x + 208;
                    paneY = y + ((int)Math.floor(k/2)* 222) + 2;
                }
                setPaneBounds(splitPanes.get(j), paneX, paneY);
            }
        }
        
        // set monster image to frames image and makes its panes visible
        for (int i = 0; i < monsters.size(); i++){
            setImgToMonsterFrame(monsters.get(i), monsterFrames.get(i));
            for(int j = (i * 4); j < (4*(i+1)); ++j){
                setPaneVisible(splitPanes.get(j), true);
            }
        }    
    }
    
    public void setFrameBounds(javax.swing.JLabel frame, int x, int y){
        frame.setBounds(x, y, 300, 266);
    }
    public void setPaneBounds(javax.swing.JSplitPane pane, int x, int y){
        pane.setBounds(x, y, 90, 40);
    }
    
    public void setFrameVisible(javax.swing.JLabel frame, boolean flag){
        frame.setVisible(flag);
    }
    public void setPaneVisible(javax.swing.JSplitPane pane, boolean flag){
        pane.setVisible(flag);
    }
    
    public void setImgToMonsterFrame(Monster m, javax.swing.JLabel frame){
//        frame.setIcon(m.getImg());
        
        ImageResizer.setImage(frame, m.getName()+".jpg");
        setFrameVisible(frame, true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSplitPane3 = new javax.swing.JSplitPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSplitPane4 = new javax.swing.JSplitPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSplitPane5 = new javax.swing.JSplitPane();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSplitPane6 = new javax.swing.JSplitPane();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSplitPane7 = new javax.swing.JSplitPane();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSplitPane8 = new javax.swing.JSplitPane();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSplitPane9 = new javax.swing.JSplitPane();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSplitPane10 = new javax.swing.JSplitPane();
        jLabel20 = new javax.swing.JLabel();
        jSplitPane11 = new javax.swing.JSplitPane();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jSplitPane12 = new javax.swing.JSplitPane();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSplitPane13 = new javax.swing.JSplitPane();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSplitPane14 = new javax.swing.JSplitPane();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jSplitPane15 = new javax.swing.JSplitPane();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jSplitPane16 = new javax.swing.JSplitPane();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSplitPane17 = new javax.swing.JSplitPane();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jSplitPane18 = new javax.swing.JSplitPane();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jSplitPane19 = new javax.swing.JSplitPane();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jSplitPane20 = new javax.swing.JSplitPane();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jSplitPane21 = new javax.swing.JSplitPane();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jSplitPane22 = new javax.swing.JSplitPane();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jSplitPane23 = new javax.swing.JSplitPane();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jSplitPane24 = new javax.swing.JSplitPane();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        map = new javax.swing.JLabel();
        frame2 = new javax.swing.JLabel();
        frame4 = new javax.swing.JLabel();
        frame6 = new javax.swing.JLabel();
        frame3 = new javax.swing.JLabel();
        frame5 = new javax.swing.JLabel();
        frame1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1200, 820));
        setMaximumSize(new java.awt.Dimension(1200, 820));
        setMinimumSize(new java.awt.Dimension(1200, 820));
        setPreferredSize(new java.awt.Dimension(1200, 820));
        setSize(new java.awt.Dimension(1200, 820));
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/VP.png"))); // NOI18N
        jLabel1.setBounds(new java.awt.Rectangle(0, 0, 5, 5));
        jSplitPane1.setLeftComponent(jLabel1);

        jLabel3.setText("88");
        jSplitPane1.setRightComponent(jLabel3);

        getContentPane().add(jSplitPane1);
        jSplitPane1.setBounds(2, 2, 90, 40);

        jSplitPane2.setBounds(new java.awt.Rectangle(208, 2, 90, 40));

        jLabel4.setText("jLabel1");
        jSplitPane2.setLeftComponent(jLabel4);

        jLabel5.setText("jLabel3");
        jSplitPane2.setRightComponent(jLabel5);

        getContentPane().add(jSplitPane2);
        jSplitPane2.setBounds(208, 2, 90, 40);

        jLabel6.setText("jLabel1");
        jSplitPane3.setLeftComponent(jLabel6);

        jLabel7.setText("jLabel3");
        jSplitPane3.setRightComponent(jLabel7);

        getContentPane().add(jSplitPane3);
        jSplitPane3.setBounds(10, 280, 130, 40);

        jLabel8.setText("jLabel1");
        jSplitPane4.setLeftComponent(jLabel8);

        jLabel9.setText("jLabel3");
        jSplitPane4.setRightComponent(jLabel9);

        getContentPane().add(jSplitPane4);
        jSplitPane4.setBounds(240, 280, 130, 40);

        jLabel10.setText("jLabel1");
        jSplitPane5.setLeftComponent(jLabel10);

        jLabel11.setText("jLabel3");
        jSplitPane5.setRightComponent(jLabel11);

        getContentPane().add(jSplitPane5);
        jSplitPane5.setBounds(390, 10, 130, 40);

        jLabel12.setText("jLabel1");
        jSplitPane6.setLeftComponent(jLabel12);

        jLabel13.setText("jLabel3");
        jSplitPane6.setRightComponent(jLabel13);

        getContentPane().add(jSplitPane6);
        jSplitPane6.setBounds(620, 10, 130, 40);

        jLabel14.setText("jLabel1");
        jSplitPane7.setLeftComponent(jLabel14);

        jLabel15.setText("jLabel3");
        jSplitPane7.setRightComponent(jLabel15);

        getContentPane().add(jSplitPane7);
        jSplitPane7.setBounds(390, 280, 130, 40);

        jLabel16.setText("jLabel1");
        jSplitPane8.setLeftComponent(jLabel16);

        jLabel17.setText("jLabel3");
        jSplitPane8.setRightComponent(jLabel17);

        getContentPane().add(jSplitPane8);
        jSplitPane8.setBounds(620, 280, 130, 40);

        jLabel18.setText("jLabel1");
        jSplitPane9.setLeftComponent(jLabel18);

        jLabel19.setText("jLabel3");
        jSplitPane9.setRightComponent(jLabel19);

        getContentPane().add(jSplitPane9);
        jSplitPane9.setBounds(10, 340, 130, 40);

        jLabel20.setText("jLabel1");
        jSplitPane10.setLeftComponent(jLabel20);

        getContentPane().add(jSplitPane10);
        jSplitPane10.setBounds(240, 340, 130, 40);

        jLabel22.setText("jLabel1");
        jSplitPane11.setLeftComponent(jLabel22);

        jLabel23.setText("jLabel3");
        jSplitPane11.setRightComponent(jLabel23);

        getContentPane().add(jSplitPane11);
        jSplitPane11.setBounds(10, 610, 130, 40);

        jLabel24.setText("jLabel1");
        jSplitPane12.setLeftComponent(jLabel24);

        jLabel25.setText("jLabel3");
        jSplitPane12.setRightComponent(jLabel25);

        getContentPane().add(jSplitPane12);
        jSplitPane12.setBounds(240, 610, 130, 40);

        jLabel26.setText("jLabel1");
        jSplitPane13.setLeftComponent(jLabel26);

        jLabel27.setText("jLabel3");
        jSplitPane13.setRightComponent(jLabel27);

        jLabel21.setText("jLabel3");
        jSplitPane13.setLeftComponent(jLabel21);

        getContentPane().add(jSplitPane13);
        jSplitPane13.setBounds(390, 340, 130, 40);

        jLabel28.setText("jLabel1");
        jSplitPane14.setLeftComponent(jLabel28);

        jLabel29.setText("jLabel3");
        jSplitPane14.setRightComponent(jLabel29);

        getContentPane().add(jSplitPane14);
        jSplitPane14.setBounds(620, 340, 130, 40);

        jLabel30.setText("jLabel1");
        jSplitPane15.setLeftComponent(jLabel30);

        jLabel31.setText("jLabel3");
        jSplitPane15.setRightComponent(jLabel31);

        getContentPane().add(jSplitPane15);
        jSplitPane15.setBounds(390, 610, 130, 40);

        jLabel32.setText("jLabel1");
        jSplitPane16.setLeftComponent(jLabel32);

        jLabel33.setText("jLabel3");
        jSplitPane16.setRightComponent(jLabel33);

        getContentPane().add(jSplitPane16);
        jSplitPane16.setBounds(620, 610, 130, 40);

        jLabel34.setText("jLabel1");
        jSplitPane17.setLeftComponent(jLabel34);

        jLabel35.setText("jLabel3");
        jSplitPane17.setRightComponent(jLabel35);

        getContentPane().add(jSplitPane17);
        jSplitPane17.setBounds(10, 670, 130, 40);

        jLabel36.setText("jLabel1");
        jSplitPane18.setLeftComponent(jLabel36);

        jLabel37.setText("jLabel3");
        jSplitPane18.setRightComponent(jLabel37);

        getContentPane().add(jSplitPane18);
        jSplitPane18.setBounds(240, 670, 130, 40);

        jLabel38.setText("jLabel1");
        jSplitPane19.setLeftComponent(jLabel38);

        jLabel39.setText("jLabel3");
        jSplitPane19.setRightComponent(jLabel39);

        getContentPane().add(jSplitPane19);
        jSplitPane19.setBounds(10, 950, 130, 40);

        jLabel40.setText("jLabel1");
        jSplitPane20.setLeftComponent(jLabel40);

        jLabel41.setText("jLabel3");
        jSplitPane20.setRightComponent(jLabel41);

        getContentPane().add(jSplitPane20);
        jSplitPane20.setBounds(240, 950, 130, 40);

        jLabel42.setText("jLabel1");
        jSplitPane21.setLeftComponent(jLabel42);

        jLabel43.setText("jLabel3");
        jSplitPane21.setRightComponent(jLabel43);

        getContentPane().add(jSplitPane21);
        jSplitPane21.setBounds(390, 670, 130, 40);

        jLabel44.setText("jLabel1");
        jSplitPane22.setLeftComponent(jLabel44);

        jLabel45.setText("jLabel3");
        jSplitPane22.setRightComponent(jLabel45);

        getContentPane().add(jSplitPane22);
        jSplitPane22.setBounds(620, 670, 130, 40);

        jLabel46.setText("jLabel1");
        jSplitPane23.setLeftComponent(jLabel46);

        jLabel47.setText("jLabel3");
        jSplitPane23.setRightComponent(jLabel47);

        getContentPane().add(jSplitPane23);
        jSplitPane23.setBounds(390, 950, 130, 40);

        jLabel48.setText("jLabel1");
        jSplitPane24.setLeftComponent(jLabel48);

        jLabel49.setText("jLabel3");
        jSplitPane24.setRightComponent(jLabel49);

        getContentPane().add(jSplitPane24);
        jSplitPane24.setBounds(620, 950, 130, 40);

        map.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tokyoLand.jpg"))); // NOI18N
        map.setText("jLabel1");
        map.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(map);
        map.setBounds(760, 0, 720, 1000);

        frame2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/boardGigaZaur.jpg"))); // NOI18N
        frame2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        frame2.setMaximumSize(new java.awt.Dimension(384, 333));
        frame2.setMinimumSize(new java.awt.Dimension(384, 333));
        frame2.setPreferredSize(new java.awt.Dimension(384, 333));
        getContentPane().add(frame2);
        frame2.setBounds(380, 0, 384, 333);

        frame4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/boardSpacePenguin.jpg"))); // NOI18N
        frame4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(frame4);
        frame4.setBounds(380, 330, 380, 330);

        frame6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/boardMecaDragon.jpg"))); // NOI18N
        frame6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(frame6);
        frame6.setBounds(380, 660, 388, 337);

        frame3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/boardAlienoid.jpg"))); // NOI18N
        frame3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(frame3);
        frame3.setBounds(0, 330, 388, 337);

        frame5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/boardKing.jpg"))); // NOI18N
        frame5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(frame5);
        frame5.setBounds(0, 660, 388, 337);

        frame1.setBackground(new java.awt.Color(255, 255, 255));
        frame1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/boardCyberKitty.jpg"))); // NOI18N
        frame1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        frame1.setMaximumSize(new java.awt.Dimension(388, 266));
        getContentPane().add(frame1);
        frame1.setBounds(0, 0, 388, 337);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Board().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel frame1;
    private javax.swing.JLabel frame2;
    private javax.swing.JLabel frame3;
    private javax.swing.JLabel frame4;
    private javax.swing.JLabel frame5;
    private javax.swing.JLabel frame6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane10;
    private javax.swing.JSplitPane jSplitPane11;
    private javax.swing.JSplitPane jSplitPane12;
    private javax.swing.JSplitPane jSplitPane13;
    private javax.swing.JSplitPane jSplitPane14;
    private javax.swing.JSplitPane jSplitPane15;
    private javax.swing.JSplitPane jSplitPane16;
    private javax.swing.JSplitPane jSplitPane17;
    private javax.swing.JSplitPane jSplitPane18;
    private javax.swing.JSplitPane jSplitPane19;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane20;
    private javax.swing.JSplitPane jSplitPane21;
    private javax.swing.JSplitPane jSplitPane22;
    private javax.swing.JSplitPane jSplitPane23;
    private javax.swing.JSplitPane jSplitPane24;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JSplitPane jSplitPane5;
    private javax.swing.JSplitPane jSplitPane6;
    private javax.swing.JSplitPane jSplitPane7;
    private javax.swing.JSplitPane jSplitPane8;
    private javax.swing.JSplitPane jSplitPane9;
    private javax.swing.JLabel map;
    // End of variables declaration//GEN-END:variables
    private LinkedList <Monster> monsters;
    private LinkedList <javax.swing.JLabel> monsterFrames;
    private javax.swing.JLabel frame;
    private LinkedList <javax.swing.JSplitPane> splitPanes;
    private javax.swing.JSplitPane splitPane;
}
