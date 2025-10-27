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

public abstract class Character {
    protected int x, y, width, height;
    protected Image img;

    public Character() {
        this.x = 0;
        this.y = 0;
        this.width = 50;
        this.height = 50;
    }

    public int getX(){ return x; }
    public int getY(){ return y; }
    public void setX(int x){ this.x=x; }
    public void setY(int y){ this.y=y; }
    public void setWidth(int w){ this.width=w; }
    public void setHeight(int h){ this.height=h; }
    public int getWidth(){ return width; }
    public int getHeight(){ return height; }
    public void setImage(Image img){ this.img=img; }
    public Image getImage(){ return img; }
    public abstract void moving();
    public abstract void update(int a);
    public void draw(Graphics g){
        g.drawImage(img, x, y, width, height, null);
    }
    public abstract Rectangle getBounds();
}
