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

public class Player extends Character {

    private boolean jumping = false;
    private boolean crouching = false;  // ⬅ เพิ่มตัวแปรสถานะหมอบ
    private int yVelocity = 0;
    private int jumpCount = 0;
    private final int groundY;

    public Player(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.groundY = y;
        this.img = ImageRS.IMG_MAN;
    }

    @Override
    public void moving(){
        if(jumping){
            y += yVelocity;
            yVelocity += 1; // gravity
            if(y >= groundY){
                y = groundY;
                jumping = false;
                yVelocity = 0;
                jumpCount = 0;
            }
        }
    }

    @Override
    public void update(int a){
        moving();
    }

    public void jump(){
        if(jumpCount < 2){
            jumping = true;
            yVelocity = -15;
            jumpCount++;
            img = ImageRS.IMG_MAN_UP;
        }
    }

    public void crouch(){
        crouching = true;           // ⬅ set สถานะหมอบ
        img = ImageRS.IMG_MAN_DOWN; // เปลี่ยนรูป
    }

    public void stand(){
        crouching = false;          // ⬅ กลับสถานะยืน
        if(!jumping) img = ImageRS.IMG_MAN;
    }

    public boolean isCrouching(){
        return crouching;
    }

    @Override
    public Rectangle getBounds() {
        int padX = width / 3;
        int padY;
        int h;

        if(isCrouching()){
            padY = height / 2; // hitbox ต่ำลงครึ่งตัว
            h = height / 2;
        } else {
            padY = height / 8; // hitbox ปกติ
            h = height - 2 * padY;
        }

        return new Rectangle(x + padX, y + padY, width - 2 * padX, h);
    }

    @Override
    public void draw(Graphics g){
        g.drawImage(img, x, y, width, height, null);

        // Debug: วาดกรอบ hitbox สีแดง
        g.setColor(Color.RED);
        Rectangle hb = getBounds();
        g.drawRect(hb.x, hb.y, hb.width, hb.height);
    }
}
