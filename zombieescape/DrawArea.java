/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombieescape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class DrawArea extends JPanel implements ActionListener, KeyListener {

    private final int WIDTH = 1280, HEIGHT = 720;
    private final Timer timer;
    private final Player player;
    
    private final bgAnimation bg;
    private final ArrayList<Obstacle> obstacles;
    private final int gameSpeed = 5;
    private final Random rand = new Random();
    private int obstacleTimer = 0;

    private final JButton btnRestart;

    public DrawArea(bgAnimation bg){
        this.bg = bg;
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);

        player = new Player(100, HEIGHT - 320, 300, 200);

        obstacles = new ArrayList<>();
        timer = new Timer(20, this);
        addKeyListener(this);

        // ปุ่ม Restart
        btnRestart = new JButton("Restart Game");
        btnRestart.setBounds(WIDTH/2 - 100, HEIGHT/2 - 25, 200, 50);
        btnRestart.setVisible(false);
        btnRestart.addActionListener(e -> restartGame());
        setLayout(null);
        add(btnRestart);
        
        
        
    }

    public void startGame(){
        obstacles.clear();
        obstacleTimer = 0;
        player.stand();
        btnRestart.setVisible(false);
        timer.start();
        requestFocusInWindow();
    }

    public void restartGame(){
        obstacles.clear();
        obstacleTimer = 0;
        player.setX(100);
        player.setY(HEIGHT - 150);
        player.stand();
        btnRestart.setVisible(false);
        timer.start();
        requestFocusInWindow();
    }
    public void setPlayerCharacter(String type){
    if(type.equals("MAN")){
        player.setImage(ImageRS.IMG_MAN);
    } else {
        player.setImage(ImageRS.IMG_WOMAN);
    }
    }
  


    @Override
public void paintComponent(Graphics g){
    super.paintComponent(g);
    if(bg.getImageBg()!=null) g.drawImage(bg.getImageBg(), 0, 0, WIDTH, HEIGHT, null);
    player.draw(g);
    for(Obstacle ob : obstacles) ob.draw(g);

    g.setColor(Color.RED);
    Rectangle pb = player.getBounds();
    g.drawRect(pb.x, pb.y, pb.width, pb.height);

    for(Obstacle ob : obstacles){
        Rectangle rb = ob.getBounds();
        g.drawRect(rb.x, rb.y, rb.width, rb.height);
    }
    
    
}


//อัลกอริทึมหลักของโปรแกรม
//หน้าที่:
//คอยอัปเดตตำแหน่งของ Player และ Obstacle ทุก ๆ 20 มิลลิวินาที (หรือ 50 เฟรมต่อวินาที)
//ตรวจสอบการชน (Collision Detection)
//สร้างสิ่งกีดขวาง (Obstacle Spawning)
//เรียก repaint() เพื่อวาดภาพใหม่ตลอดเวลา
    @Override
    public void actionPerformed(ActionEvent e){
        player.update(0);

        obstacleTimer++;
        if(obstacleTimer > 130){
            obstacleTimer = 0;
            int type = rand.nextInt(4);
            Obstacle ob;
            switch(type){
            case 0 -> ob = new Obstacle(WIDTH, HEIGHT-250, 200, 150, ImageRS.IMG_CARWTRECK);
            case 1 -> ob = new Obstacle(WIDTH, HEIGHT-400, 220, 150, ImageRS.IMG_ZOMBIE_FLOWER);
            case 2 -> ob = new Obstacle(WIDTH, HEIGHT-210, 100, 80, ImageRS.IMG_ZOMBIE_MAN);
            case 3 -> ob = new Obstacle(WIDTH, HEIGHT-400, 220, 150, ImageRS.IMG_ZOMBIE_CATERPILLAR);
            default -> ob = new Obstacle(WIDTH, HEIGHT-250, 200, 150, ImageRS.IMG_CARWTRECK);
}

            obstacles.add(ob);
        }

        obstacles.forEach(ob -> ob.update(gameSpeed));
        obstacles.removeIf(Obstacle::isOffScreen);

        // ตรวจสอบชน
        for(Obstacle ob : obstacles){
            if(player.getBounds().intersects(ob.getBounds())){
                timer.stop();
                btnRestart.setVisible(true); // แสดงปุ่ม Restart
        }
        }
        


        repaint();
    }
    
    

    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_W -> player.jump();
            case KeyEvent.VK_S -> player.crouch();
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_S) player.stand();
    }

    @Override
    public void keyTyped(KeyEvent e){}

}
