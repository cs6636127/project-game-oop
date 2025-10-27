/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombieescape;

/**
 *
 * @author zitihayathworawatthanachai
 */

import java.awt.*;

public class bgAnimation {
    private Image imgBg;
    private String nImage;

    public bgAnimation(int width, int height, Image imgBg, String nImage){
        this.imgBg = imgBg;
        this.nImage = nImage;
    }

    public void setImageBg(Image img){ this.imgBg = img; }
    public Image getImageBg(){ return imgBg; }

    public void setNImage(String nImage){ this.nImage = nImage; }
    public String getNImage(){ return nImage; }

    public void update(int gameSpeed){}
    public void draw(Graphics g){}
}

