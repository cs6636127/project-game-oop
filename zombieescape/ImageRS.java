/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombieescape;


/**
 *
 * @author zitihayathworawatthanachai
 */
import java.awt.Image;
import javax.swing.ImageIcon;

public class ImageRS {

    public static Image IMG_BG1;
    public static Image IMG_BG2;
    public static Image IMG_BG3;
    public static Image IMG_GAMEOVER;
    public static Image IMG_CARWTRECK;

    public static Image IMG_MAN;
    public static Image IMG_MAN_UP;
    public static Image IMG_MAN_DOWN;

    public static Image IMG_WOMAN;
    public static Image IMG_WOMAN_UP;
    public static Image IMG_WOMAN_DOWN;

    public static Image IMG_ZOMBIE_MAN;
    public static Image IMG_ZOMBIE_FLOWER;
    public static Image IMG_ZOMBIE_CATERPILLAR;

    public static Image IMG_START;
    public static Image IMG_TITLE;
    public static Image IMG_SCORE;
    public static Image IMG_SELECT;
    public static Image IMG_SELECT_MAN;
    public static Image IMG_SELECT_WOMAN;


    static {
        IMG_BG1 = new ImageIcon(ImageRS.class.getResource("/zombieescape/bg1.png")).getImage();
        IMG_BG2 = new ImageIcon(ImageRS.class.getResource("/zombieescape/bg2.png")).getImage();
        IMG_BG3 = new ImageIcon(ImageRS.class.getResource("/zombieescape/bg3.png")).getImage();

        IMG_GAMEOVER = new ImageIcon(ImageRS.class.getResource("/zombieescape/gameOver.png")).getImage();
        IMG_CARWTRECK = new ImageIcon(ImageRS.class.getResource("/zombieescape/carWtreck.png")).getImage();

        IMG_MAN = new ImageIcon(ImageRS.class.getResource("/zombieescape/man.png")).getImage();
        IMG_MAN_UP = new ImageIcon(ImageRS.class.getResource("/zombieescape/manUp.png")).getImage();
        IMG_MAN_DOWN = new ImageIcon(ImageRS.class.getResource("/zombieescape/manDown.png")).getImage();

        IMG_WOMAN = new ImageIcon(ImageRS.class.getResource("/zombieescape/women.png")).getImage();
        IMG_WOMAN_UP = new ImageIcon(ImageRS.class.getResource("/zombieescape/womenUp.png")).getImage();
        IMG_WOMAN_DOWN = new ImageIcon(ImageRS.class.getResource("/zombieescape/womenDown.png")).getImage();

        IMG_ZOMBIE_MAN = new ImageIcon(ImageRS.class.getResource("/zombieescape/zombieMan.png")).getImage();
        IMG_ZOMBIE_FLOWER = new ImageIcon(ImageRS.class.getResource("/zombieescape/zombieFlower.png")).getImage();
        IMG_ZOMBIE_CATERPILLAR = new ImageIcon(ImageRS.class.getResource("/zombieescape/zombieCaterpillar.png")).getImage();

        IMG_START = new ImageIcon(ImageRS.class.getResource("/zombieescape/start.png")).getImage();
        IMG_TITLE = new ImageIcon(ImageRS.class.getResource("/zombieescape/title.png")).getImage();
        IMG_SCORE = new ImageIcon(ImageRS.class.getResource("/zombieescape/score.png")).getImage();
        
        IMG_SELECT = new ImageIcon(ImageRS.class.getResource("/zombieescape/select.png")).getImage();
        IMG_SELECT_MAN = new ImageIcon(ImageRS.class.getResource("/zombieescape/selectman.png")).getImage();
        IMG_SELECT_WOMAN = new ImageIcon(ImageRS.class.getResource("/zombieescape/selectwomen.png")).getImage();

    }
}

