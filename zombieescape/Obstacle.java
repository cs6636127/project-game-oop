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

public class Obstacle {

    private int x;
    private final int y;
    private final int width;
    private final int height;
    private final Image img;

    public Obstacle(int x, int y, int width, int height, Image img){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
    }

    public void draw(Graphics g){
        g.drawImage(img, x, y, width, height, null);
    }

    public void update(int speed){
        if (img == ImageRS.IMG_ZOMBIE_MAN) {
    x -= speed * 1.4;  // ZombieMan = เร็วขึ้น 80%
} else {
    x -= speed;        // zombie อื่นความเร็วเดิม
}

    }

    public boolean isOffScreen(){
        return x + width < 0;
    }

    public Rectangle getBounds(){ 
        int padX = width / 3; 
        int padY; 
        
        if(img == ImageRS.IMG_ZOMBIE_MAN){ 
            padY = height / 3; 
            int h = height / 2;
            
            return new Rectangle(x + padX, y + padY, width - 2*padX, h/3);
        } 
        else { 
            padY = height / 4; 
            return new Rectangle(x + padX, y + padY, width - 2*padX, height - 2*padY); }
    }
}

