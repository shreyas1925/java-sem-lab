package package1;

import java.awt.*;
import javax.swing.*;



public class UI {
    JFrame window;
    JPanel titleNamePanel,startButtonPanel,mainTextPanel,choiceButtonPanel, playerPanel;
    JLabel titleNameLabel,HPLabel,HPLabelNumber,coinLabel,coinNumberLabel,WeaponLabel,WeaponLabelName,gregLabel,cordLabel,cordxyLabel;
    JTextArea mainTextArea;
//    Container cont;
    JButton startButton,choice1,choice2,choice3,choice4,choice5;
    Font titleFont = new Font("Time New Roman",Font.PLAIN,70);
    Font normalfont = new Font("Time New Roman",Font.PLAIN,26);
    Font smallFont = new Font("Time New Roman",Font.BOLD,20);
    Font smallerFont = new Font("Time New Roman",Font.BOLD,13);
    

    public void createUI(NGame.ChoiceHandler cHandler) {
        //Window
        window = new JFrame();
        window.setSize(900, 800);
        window.setDefaultCloseOperation(3);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
       



        // Title Screen

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(150,250,600,150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        gregLabel = new JLabel("Life of a Adventurer !!");
        gregLabel.setFont(normalfont);
        gregLabel.setForeground(Color.yellow);
        titleNamePanel.add(titleNameLabel);
        titleNamePanel.add(gregLabel);


        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(350,600,200,100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setBackground(Color.green);
        startButton.setForeground(Color.white);
        startButton.setFont(normalfont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startButtonPanel.add(startButton);
        window.add(titleNamePanel);
        window.add(startButtonPanel);
       //

        // Game Screen
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);

        mainTextArea = new JTextArea("This is the main text are. This game is going to be great. I'm sure of it!!!!!!!");
        mainTextArea.setBounds(100,100,600,200);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.magenta);
        mainTextArea.setFont(smallFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);
        window.add(mainTextPanel);


        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250,350,300,150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(5,1));
        window.add(choiceButtonPanel);


        choice1 = new JButton("choice1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalfont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("choice2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalfont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("choice3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalfont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("choice4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalfont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        choice5 = new JButton("choice5");
        choice5.setBackground(Color.black);
        choice5.setForeground(Color.white);
        choice5.setFont(normalfont);
        choice5.setFocusPainted(false);
        choice5.addActionListener(cHandler);
        choice5.setActionCommand("c5");
        choiceButtonPanel.add(choice5);

        playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		window.add(playerPanel);
		
		HPLabel = new JLabel("HP : ");
		HPLabel.setFont(normalfont);
		HPLabel.setForeground(Color.white);
		playerPanel.add(HPLabel);
		
		HPLabelNumber = new JLabel();
		HPLabelNumber.setFont(normalfont);
		HPLabelNumber.setForeground(Color.white);
		playerPanel.add(HPLabelNumber);
		
		WeaponLabel = new JLabel("Weapon : ");
		WeaponLabel.setFont(normalfont);
		WeaponLabel.setForeground(Color.white);
		playerPanel.add(WeaponLabel);
		
		WeaponLabelName=new JLabel();
		WeaponLabelName.setFont(normalfont);
		WeaponLabelName.setForeground(Color.white);
		playerPanel.add(WeaponLabelName);
        


 
        window.setVisible(true);


    }
}