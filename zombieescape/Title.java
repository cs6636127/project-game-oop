/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombieescape;

/**
 *
 * @author zitihayathworawatthanachai
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Title extends JFrame {

    private final int frameWidth = 1280, frameHeight = 720;
    private final Image imgBg1 = ImageRS.IMG_BG1;
    private final Image imgBg2 = ImageRS.IMG_BG2;
    private final Image imgBg3 = ImageRS.IMG_BG3;
    private final Image imgStart = ImageRS.IMG_START;
    private final Image imgTitle = ImageRS.IMG_TITLE;

    private String selectedCharacter = "MAN"; // เก็บตัวละครที่เลือก
    private JPanel charSelectPanel;           // panel สำหรับเลือกตัวละคร
    private JLabel selectLabel; // สำหรับ "SELECT"

    
    private final DrawArea d;
    private final TitleDraw Td = new TitleDraw();
    private final bgAnimation Bg;

    private JPanel buttonPanel;

    private final JButton Buttonscene1 = new JButton("SaoChingCha");
    private final JButton Buttonscene2 = new JButton("Wat Arun");
    private final JButton Buttonscene3 = new JButton("Wat Thai");

    public Title(){
        Bg = new bgAnimation(frameWidth, frameHeight, imgBg1,"bg1");
        d = new DrawArea(Bg);

        setLayout(new BorderLayout());
        add(Td, BorderLayout.CENTER);

        initStartButton();
        initSceneButtons();
        initCharacterSelect();


        setTitle("Bangkok Zombie Escape");
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initStartButton() {
    buttonPanel = new JPanel(new GridBagLayout());
    buttonPanel.setOpaque(false);
    
    // ปรับให้เล็กลงมาก
    int btnHeight = frameHeight / 5;   // ความสูงเล็กลง
    int btnWidth = btnHeight * 2;      // width proportional กับ height

    // ปรับขนาดรูป Icon
    Image scaledImg = imgStart.getScaledInstance(btnWidth, btnHeight, Image.SCALE_SMOOTH);
    JButton startButton = new JButton(new ImageIcon(scaledImg));
    startButton.setPreferredSize(new Dimension(btnWidth, btnHeight));

    startButton.setContentAreaFilled(false);
    startButton.setBorderPainted(false);
    startButton.setFocusPainted(false);

    buttonPanel.add(startButton);

    Td.setLayout(null);
    Td.add(buttonPanel);

    // วางตรงกลาง
    int x = (frameWidth - btnWidth) / 2;
    int y = (int) (frameHeight * 0.6 - btnHeight / 2);
    buttonPanel.setBounds(x, y, btnWidth, btnHeight);

    
    startButton.addActionListener(e -> {
    buttonPanel.setVisible(false);
    Td.showTitleImage = false;
    Td.repaint();
    showCharacterSelect(); // แสดง panel เลือกตัวละคร
});

}
    
    
    
    private void initSceneButtons() {
    Td.setLayout(null); // ใช้ absolute layout

    Font font = new Font("Courier", Font.BOLD, 20);
    JButton[] buttons = {Buttonscene1, Buttonscene2, Buttonscene3};
    String[] commands = {"SaoChingcha", "Wat Arun", "Wat Thai"};

    int buttonWidth = frameWidth / 6;
    int buttonHeight = frameHeight / 12;
    int spacing = 30;

    int totalWidth = (buttonWidth * 3) + (spacing * 2);
    int startX = (frameWidth - totalWidth) / 2;
    int yPos = (int)(frameHeight * 0.7);

    // --- สร้าง JLabel "SELECT" และซ่อนไว้ก่อน ---
    selectLabel = new JLabel("SELECT", SwingConstants.CENTER);
    selectLabel.setFont(new Font("Courier", Font.BOLD, 80));
    selectLabel.setForeground(Color.YELLOW);

    int labelWidth = totalWidth;
    int labelHeight = 100;
    int labelX = startX;
    int labelY = yPos - labelHeight - 10;
    selectLabel.setBounds(labelX, labelY, labelWidth, labelHeight);
    selectLabel.setVisible(false); // ซ่อนก่อน

    Td.add(selectLabel);

    // --- สร้างปุ่ม และซ่อนก่อน ---
    for (int i = 0; i < buttons.length; i++) {
        JButton b = buttons[i];
        b.setFont(font);
        b.setForeground(Color.BLACK);
        b.setBackground(Color.WHITE);
        b.setOpaque(true);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setActionCommand(commands[i]);
        b.addActionListener(new ButtonListener());

        int x = startX + i * (buttonWidth + spacing);
        b.setBounds(x, yPos, buttonWidth, buttonHeight);
        Td.add(b);
        b.setVisible(false); // ซ่อนก่อน
    }

    Td.revalidate();
    Td.repaint();
}




  
   private void initCharacterSelect() {
    // Panel หลัก
    charSelectPanel = new JPanel(null);
    charSelectPanel.setOpaque(false);

    int panelWidth = 1000;
    int panelHeight = 900;
    charSelectPanel.setBounds((frameWidth - panelWidth) / 2, (frameHeight - panelHeight) / 2,
                               panelWidth, panelHeight);

    // ข้อความ SELECT (ปรับ scale ตามต้นฉบับ)
ImageIcon selectIconOriginal = new ImageIcon(ImageRS.IMG_SELECT);

// กำหนดความกว้างตามต้องการ
int targetSelectWidth = 600; 

// คำนวณความสูงให้รักษาอัตราส่วน
int selectOriginalWidth = selectIconOriginal.getIconWidth();
int selectOriginalHeight = selectIconOriginal.getIconHeight();
int targetSelectHeight = selectOriginalHeight * targetSelectWidth / selectOriginalWidth;

// สร้าง ImageIcon ใหม่จากขนาดที่ปรับแล้ว
Image selectImg = selectIconOriginal.getImage().getScaledInstance(targetSelectWidth, targetSelectHeight, Image.SCALE_SMOOTH);
JLabel selectText = new JLabel(new ImageIcon(selectImg));

// วางตรงกลาง panel
int xPos = (panelWidth - targetSelectWidth) / 2;
int yPosText = 100; // เว้นขอบบนเล็กน้อย
selectText.setBounds(xPos, yPosText, targetSelectWidth, targetSelectHeight);

charSelectPanel.add(selectText);

  
    int yPos = 300;

  int targetWidth = 500; 

// ปรับรูป MAN
ImageIcon manIconOriginal = new ImageIcon(ImageRS.IMG_SELECT_MAN);
int manOriginalWidth = manIconOriginal.getIconWidth();
int manOriginalHeight = manIconOriginal.getIconHeight();
int manTargetHeight = manOriginalHeight * targetWidth / manOriginalWidth; // ปรับความสูงตามอัตราส่วน
Image manImg = manIconOriginal.getImage().getScaledInstance(targetWidth, manTargetHeight, Image.SCALE_SMOOTH);
JButton btnMan = new JButton(new ImageIcon(manImg));
btnMan.setBounds(100, yPos, targetWidth, manTargetHeight);
btnMan.setBorderPainted(false);
btnMan.setContentAreaFilled(false);
btnMan.addActionListener(e -> {
        selectLabel.setVisible(true);   // แสดง "SELECT"
    selectedCharacter = "MAN";
    charSelectPanel.setVisible(false);
Buttonscene1.setVisible(true);
Buttonscene2.setVisible(true);
Buttonscene3.setVisible(true);

Td.revalidate();
Td.repaint();
});
charSelectPanel.add(btnMan);

// ปรับรูป WOMAN
ImageIcon womanIconOriginal = new ImageIcon(ImageRS.IMG_SELECT_WOMAN);
int womanOriginalWidth = womanIconOriginal.getIconWidth();
int womanOriginalHeight = womanIconOriginal.getIconHeight();
int womanTargetHeight = womanOriginalHeight * targetWidth / womanOriginalWidth; // รักษาอัตราส่วน
Image womanImg = womanIconOriginal.getImage().getScaledInstance(targetWidth, womanTargetHeight, Image.SCALE_SMOOTH);
JButton btnWoman = new JButton(new ImageIcon(womanImg));
btnWoman.setBounds(panelWidth - 100 - targetWidth, yPos, targetWidth, womanTargetHeight);
btnWoman.setBorderPainted(false);
btnWoman.setContentAreaFilled(false);
btnWoman.addActionListener(e -> {
    selectedCharacter = "WOMAN";
    charSelectPanel.setVisible(false);
    
Buttonscene1.setVisible(true);
Buttonscene2.setVisible(true);
Buttonscene3.setVisible(true);


Td.revalidate();
Td.repaint();
});

charSelectPanel.add(btnWoman);

    // เพิ่ม panel หลักลง frame
    Td.add(charSelectPanel, 0);
    charSelectPanel.setVisible(false);
}


    private void showCharacterSelect() {
    charSelectPanel.setVisible(true);
    charSelectPanel.repaint();
}



    class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String cmd = e.getActionCommand();
            switch(cmd){
                case "SaoChingcha" -> Bg.setImageBg(imgBg1);
                case "Wat Arun" -> Bg.setImageBg(imgBg2);
                case "Wat Thai" -> Bg.setImageBg(imgBg3);
            }
            Td.setVisible(false);
            add(d, BorderLayout.CENTER);    
            d.setVisible(true);
            d.startGame();
            revalidate();
            repaint();
            d.requestFocusInWindow();
            d.setPlayerCharacter(selectedCharacter);


        }
    }

    class TitleDraw extends JPanel{
        boolean showTitleImage = true; 
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(imgBg1,0,0,frameWidth,frameHeight,this);

            if (showTitleImage) {
                g.drawImage(
                    imgTitle,
                    (int)(frameWidth * 0.2),
                    (int)(frameHeight * 0.01),
                    (int)(frameWidth * 0.6),
                    (int)(frameHeight * 0.6),
                    this
                );
            }
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new Title().setVisible(true));
    }


}

