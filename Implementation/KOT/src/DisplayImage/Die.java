/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisplayImage;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 *
 * @author Hueletl
 */
public class Die {
    
    private String face1;
    private String face2;
    private String face3;
    private String face4;
    private String face5;
    private String face6;
    private LinkedList<String> faces;
    private LinkedList<BufferedImage> faceImages;
    
    public Die(){
        faces = new LinkedList<>();
        faceImages = new LinkedList<>();
        
        face1 = "1VP";
        face2 = "2VP";
        face3 = "3VP";
        face4 = "EP";
        face5 = "HP";
        face6 = "SMASH";
        
        faces.add(face1);
        faces.add(face2);
        faces.add(face3);
        faces.add(face4);
        faces.add(face5);
        faces.add(face6);
        
        faceImages.add(Setting.resize("face1VP.png", 50, 50));
        faceImages.add(Setting.resize("face2VP.png", 50, 50));
        faceImages.add(Setting.resize("face3VP.png", 50, 50));
        faceImages.add(Setting.resize("faceEP.png", 50, 50));
        faceImages.add(Setting.resize("faceHP.png", 50, 50));
        faceImages.add(Setting.resize("faceSMASH.png", 50, 50));
    }
    
    public BufferedImage roll(){
        int faceUp =  (int) (Math.random() * 6);
        return faceImages.get(faceUp);
    }

    /**
     * @return the face1
     */
    public String getFace1() {
        return face1;
    }

    /**
     * @param face1 the face1 to set
     */
    public void setFace1(String face1) {
        this.face1 = face1;
    }

    /**
     * @return the face2
     */
    public String getFace2() {
        return face2;
    }

    /**
     * @param face2 the face2 to set
     */
    public void setFace2(String face2) {
        this.face2 = face2;
    }

    /**
     * @return the face3
     */
    public String getFace3() {
        return face3;
    }

    /**
     * @param face3 the face3 to set
     */
    public void setFace3(String face3) {
        this.face3 = face3;
    }

    /**
     * @return the face4
     */
    public String getFace4() {
        return face4;
    }

    /**
     * @param face4 the face4 to set
     */
    public void setFace4(String face4) {
        this.face4 = face4;
    }

    /**
     * @return the face5
     */
    public String getFace5() {
        return face5;
    }

    /**
     * @param face5 the face5 to set
     */
    public void setFace5(String face5) {
        this.face5 = face5;
    }

    /**
     * @return the face6
     */
    public String getFace6() {
        return face6;
    }

    /**
     * @param face6 the face6 to set
     */
    public void setFace6(String face6) {
        this.face6 = face6;
    }

    /**
     * @return the faces
     */
    public LinkedList<String> getFaces() {
        return faces;
    }

    /**
     * @param faces the faces to set
     */
    public void setFaces(LinkedList<String> faces) {
        this.faces = faces;
    }

    /**
     * @return the faceImages
     */
    public LinkedList<BufferedImage> getFaceImages() {
        return faceImages;
    }

    /**
     * @param faceImages the faceImages to set
     */
    public void setFaceImages(LinkedList<BufferedImage> faceImages) {
        this.faceImages = faceImages;
    }
    
}
