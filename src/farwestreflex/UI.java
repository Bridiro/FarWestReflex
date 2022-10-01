package farwestreflex;

import javax.swing.*;
import java.awt.*;

public class UI {

    GameManager gm;

    JFrame window;
    JPanel panelText;
    public JTextArea messageText;
    public JButton buttonNext;
    public JButton buttonFire;
    public JButton buttonSkipAll;
    public JButton buttonWelcome;
    public JButton buttonRestart;
    public JPanel[] bgPanel = new JPanel[10];
    public JLabel[] bgLabel = new JLabel[10];

    public UI(GameManager gm){

        this.gm = gm;

        createMainField();
        generateScreen();

        window.setVisible(true);
    }

    //funzione che crea la finestra e tutti i suoi componenti base
    public void createMainField(){

        window = new JFrame("Wild West | Reflex Game");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setResizable(false);

        panelText = new JPanel();
        panelText.setBounds(50, 415, 700, 135);
        panelText.setBackground(Color.white);
        panelText.setLayout(null);
        messageText = new JTextArea("Premere \"Next\" per passare al prossimo dialogo.\nPremere \"Skip\" per andare direttamente allo scontro.");
        messageText.setBounds(5, 5, 535, 125);
        messageText.setBackground(Color.white);
        messageText.setForeground(Color.black);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Poppins", Font.PLAIN, 20));
        panelText.add(messageText);

        buttonNext = new JButton("Next");
        buttonNext.setBounds(550, 8, 140, 52);
        buttonNext.setBackground(Color.black);
        buttonNext.setForeground(Color.white);
        buttonNext.setFont(new Font("Poppins", Font.PLAIN, 18));
        buttonNext.addActionListener(gm.aHandler);
        buttonNext.setActionCommand("next");

        buttonSkipAll = new JButton("Skip");
        buttonSkipAll.setBounds(550, 73, 140, 52);
        buttonSkipAll.setBackground(Color.black);
        buttonSkipAll.setForeground(Color.white);
        buttonSkipAll.setFont(new Font("Poppins", Font.PLAIN, 18));
        buttonSkipAll.addActionListener(gm.aHandler);
        buttonSkipAll.setActionCommand("skip");

        buttonFire = new JButton("FIRE");
        buttonFire.setBounds(550, 8, 140, 119);
        buttonFire.setBackground(Color.red);
        buttonFire.setForeground(Color.white);
        buttonFire.setFont(new Font("Poppins", Font.PLAIN, 40));
        buttonFire.addActionListener(gm.aHandler);
        buttonFire.setActionCommand("fire");
        buttonFire.setVisible(false);

        buttonRestart = new JButton("Restart");
        buttonRestart.setBounds(550, 8, 140, 119);
        buttonRestart.setBackground(Color.black);
        buttonRestart.setForeground(Color.white);
        buttonRestart.setFont(new Font("Poppins", Font.PLAIN, 18));
        buttonRestart.addActionListener(gm.aHandler);
        buttonRestart.setActionCommand("restart");
        buttonRestart.setVisible(false);

        panelText.add(buttonNext);
        panelText.add(buttonSkipAll);
        panelText.add(buttonFire);
        panelText.add(buttonRestart);

        window.add(panelText);
    }

    //funzione che crea la intro
    //paramentri = che layer che deve occupare, il messaggio di base che deve mostrare, il nome del file dello sfondo;
    public void createIntro(int bgNum, String message, String fileName){

        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(0, 0, 800, 600);
        bgPanel[bgNum].setBackground(null);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 50, 800, 350);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(fileName));
        Image image = (bgIcon).getImage().getScaledInstance(bgLabel[bgNum].getWidth(), bgLabel[bgNum].getHeight(), Image.SCALE_SMOOTH);
        bgIcon = new ImageIcon(image);
        bgLabel[bgNum].setIcon(bgIcon);

        JTextArea welcomeArea = new JTextArea(message);
        welcomeArea.setBounds(250, 40, 500, 50);
        welcomeArea.setEditable(false);
        welcomeArea.setBackground(null);
        welcomeArea.setOpaque(false);
        welcomeArea.setForeground(Color.black);
        welcomeArea.setFont(new Font("Poppins", Font.BOLD, 30));

        buttonWelcome = new JButton("START!");
        buttonWelcome.setBounds(300, 420, 200, 50);
        buttonWelcome.setBackground(null);
        buttonWelcome.setForeground(Color.white);
        buttonWelcome.setFont(new Font("Poppins", Font.PLAIN, 30));
        buttonWelcome.addActionListener(gm.aHandler);
        buttonWelcome.setActionCommand("welcome");

        bgLabel[bgNum].add(welcomeArea);
        bgPanel[bgNum].add(buttonWelcome);
        bgPanel[bgNum].add(bgLabel[bgNum]);
    }

    //funzione per creare una scena
    //parametri = che layer deve occupare, nome del file dello sfondo;
    public void createBackground(int bgNum, String fileName){

        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(50, 50, 700, 350);
        bgPanel[bgNum].setBackground(null);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 700, 350);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(fileName));
        Image image = (bgIcon).getImage().getScaledInstance(bgLabel[bgNum].getWidth(), bgLabel[bgNum].getHeight(), Image.SCALE_SMOOTH);
        bgIcon = new ImageIcon(image);
        bgLabel[bgNum].setIcon(bgIcon);
    }

    //funzione per aggiungere oggetti alla scena
    //parametri = in che layer devono essere aggiunti, posizione asse x, pos asse y, grandezza x, grandezza y, nome del file;
    public void createObject(int bgNum, int objx, int objy, int objw, int objh, String objFileName){

        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objx, objy, objw, objh);

        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
        Image image = (objectIcon).getImage().getScaledInstance(objectLabel.getWidth(), objectLabel.getHeight(), Image.SCALE_SMOOTH);
        objectIcon = new ImageIcon(image);
        objectLabel.setIcon(objectIcon);

        bgPanel[bgNum].add(objectLabel);
        bgPanel[bgNum].add(bgLabel[bgNum]);
    }

    //richiamata per creare tutte le scene
    public void generateScreen(){

        //INTRO
        createIntro(0, "Wild West Reflex", "intro.jpeg");
        panelText.setVisible(false);


        //SCENE base
        createBackground(1, "far_west_street.jpg");
        createObject(1, 385, 140, 100, 100, "base_enemy_no_gun.png");
        createObject(1, 100, 180, 200, 200, "man_no_gun.png");


        //SCENE dead enemy
        createBackground(2, "far_west_street.jpg");
        createObject(2, 385, 140, 100, 100, "base_enemy_no_gun_dead.png");
        createObject(2, 410, 180, 55, 55, "blood.png");
        createObject(2, 100, 180, 200, 200, "man_gun.png");


        //SCENE dead good
        createBackground(3, "far_west_street.jpg");
        createObject(3, 385, 140, 100, 100, "base_enemy_gun.png");
        createObject(3, 100, 180, 200, 200, "man_no_gun_dead.png");
        createObject(3, 165, 270, 60, 60, "blood.png");


        //SCENE final
        createBackground(4, "far_west_street.jpg");
        createObject(4, 385, 140, 130, 130, "enemy_mexican.png");
        createObject(4, 100, 180, 200, 200, "man_no_gun.png");


        //SCENE final dead mexican
        createBackground(5, "far_west_street.jpg");
        createObject(5, 385, 140, 130, 130, "enemy_mexican_dead.png");
        createObject(5, 420, 190, 50, 50, "blood.png");
        createObject(5, 100, 180, 200, 200, "man_gun.png");


        //SCENE final dead good
        createBackground(6, "far_west_street.jpg");
        createObject(6, 385, 140, 130, 130, "enemy_mexican.png");
        createObject(6, 100, 180, 200, 200, "man_no_gun_dead.png");
        createObject(6, 165, 270, 60, 60, "blood.png");
    }
}
