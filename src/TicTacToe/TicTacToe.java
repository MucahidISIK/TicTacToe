package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import RoundBtn.RoundBtn;

public class TicTacToe extends JFrame implements ActionListener {

    boolean playerX = true;
    boolean draw = false;
    String winner = null;

    int counterX=0;
    int counterY=0;

    int counter = 0;

    JFrame frame = new JFrame();
    JPanel tictactoeButtons = new JPanel();
    JPanel t_panel = new JPanel();

    JButton[] button = new JButton[9];
    JLabel textfield =  new JLabel();



    public TicTacToe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setTitle("Tic Tac Toe");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setLocation(500,25);
        Image im = Toolkit.getDefaultToolkit().getImage("Icon.png");
        frame.setIconImage(im);


        setSize(500, 500);
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 1));
        setResizable(false);

        t_panel.add(textfield);
        frame.add(t_panel, BorderLayout.NORTH);
        frame.add(tictactoeButtons);

        tictactoeButtons.setLayout(new GridLayout(3,3,2,2));
        tictactoeButtons.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        for(int i =0; i< button.length;i++){
            button[i] = new JButton();
            button[i].setBorder(new RoundBtn(100));
            button[i].setText("?");
            tictactoeButtons.add(button[i]);
            button[i].addActionListener(this);
        }


        SetText();
        SetTextField();

    }

    public  void SetTextField(){
        //textfield.setBackground(Color.white);
        textfield.setForeground(Color.darkGray);
        textfield.setFont(new Font("Arial", Font.BOLD, 40));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("X: "+counterX+"            O: "+ counterY);
        textfield.setOpaque(true);
    }
    public void MatchCheck() {// In this function we are checking wining condition's using conditional statments
        if ((button[0].getText() == "X") && (button[1].getText() == "X") && (button[2].getText() == "X")) {
            winner="X";
            counterX++;
        }
        else if ((button[0].getText() == "X") && (button[4].getText() == "X") && (button[8].getText() == "X")) {

            counterX++;
            winner="X";}
        else if ((button[0].getText() == "X") && (button[3].getText() == "X") && (button[6].getText() == "X")) {
            counterX++;
            winner="X";}
        else if ((button[1].getText() == "X") && (button[4].getText() == "X") && (button[7].getText() == "X")) {
            counterX++;
            winner="X";}
        else if ((button[2].getText() == "X") && (button[4].getText() == "X") && (button[6].getText() == "X")) {
            counterX++;
            winner="X";}
        else if ((button[2].getText() == "X") && (button[5].getText() == "X") && (button[8].getText() == "X")) {
            counterX++;
            winner="X";}
        else if ((button[3].getText() == "X") && (button[4].getText() == "X") && (button[5].getText() == "X")) {
            counterX++;
            winner="X";}
        else if ((button[6].getText() == "X") && (button[7].getText() == "X") && (button[8].getText() == "X")) {
            counterX++;
            winner="X";}

        else if ((button[0].getText() == "O") && (button[1].getText() == "O") && (button[2].getText() == "O")) {

            counterY++;
            winner="O";}
        else if ((button[0].getText() == "O") && (button[3].getText() == "O") && (button[6].getText() == "O")) {
            counterY++;
            winner="O";}
        else if ((button[0].getText() == "O") && (button[4].getText() == "O") && (button[8].getText() == "O")) {
            counterY++;
            winner="O";}
        else if ((button[1].getText() == "O") && (button[4].getText() == "O") && (button[7].getText() == "O")) {
            counterY++;
            winner="O";}
        else if ((button[2].getText() == "O") && (button[4].getText() == "O") && (button[6].getText() == "O")) {
            counterY++;
            winner="O";}
        else if ((button[2].getText() == "O") && (button[5].getText() == "O") && (button[8].getText() == "O")) {
            counterY++;
            winner="O";}
        else if ((button[3].getText() == "O") && (button[4].getText() == "O") && (button[5].getText() == "O")) {
            counterY++;
            winner="O";}
        else if ((button[6].getText() == "O") && (button[7].getText() == "O") && (button[8].getText() == "O")) {
            counterY++;
            winner="O";}

        else if(counter==9) {
            draw = true;
            counterX++;
            counterY++;
        }
    }

    public void GameOver() {
        String[] options = {"Restart", "Exit"};
        UIManager um=new UIManager();

        um.put("OptionPane.background",Color.PINK);
        um.put("Panel.background",Color.PINK);


        if(winner!=null){
            int result = JOptionPane.showOptionDialog(
                    tictactoeButtons,
                    "The winner is "+ winner + " !",
                    "GAME OVER",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,     //no custom icon
                    options,  //button titles
                    options[0] //default button
            );

            if(result == JOptionPane.YES_OPTION){
                Restart();

            }else if (result == JOptionPane.NO_OPTION){
                setDefaultCloseOperation(JOptionPane.CANCEL_OPTION);
                System.exit(0);
            }else{
                System.exit(0);
            }
        }else if (draw){
            int result = JOptionPane.showOptionDialog(
                    tictactoeButtons,
                    "It is a DRAW!",
                    "GAME OVER",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,     //no custom icon
                    options,  //button titles
                    options[0] //default button
            );

            if(result == JOptionPane.YES_OPTION){
                Restart();
            }else if (result == JOptionPane.NO_OPTION){
                setDefaultCloseOperation(JOptionPane.CANCEL_OPTION);
                System.exit(0);
            }else{
                System.exit(0);

            }
        }
    }

    private void Restart() {

        for(int i=0; i< 9;i++) {
            button[i].setEnabled(true);
            button[i].setText("?");
            button[i].setFocusable(false);
            button[i].setBackground(Color.darkGray);
            button[i].setForeground(Color.PINK);
            SetTextField();

            playerX = true;
            draw = false;
            winner = null;
            counter=0;

        }
    }

    private void SetText() {
        tictactoeButtons.setBackground(Color.gray);

        for(int i=0; i< 9;i++) {
            button[i].setFont(new Font("MonoSpaced", Font.BOLD, 150));
            button[i].setBackground(Color.darkGray);
            button[i].setForeground(Color.PINK);
            button[i].setFocusable(false);

        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        for (int i = 0; i < 9; i++) {
            if (event.getSource() == button[i]) {
                if (playerX) {
                    button[i].setBackground(Color.PINK);
                    button[i].setText("X");
                    playerX = false;
                    counter++;
                    button[i].setEnabled(false);
                    MatchCheck();

                    //System.out.println("X");
                    if(winner!=null){
                        GameOver();
                    }else if(draw==true){
                        GameOver();

                    }

                } else {
                    button[i].setBackground(Color.PINK);
                    button[i].setText("O");
                    playerX = true;
                    counter++;

                    button[i].setEnabled(false);
                    MatchCheck();
                    //System.out.println("O");
                    if(winner!=null){
                        GameOver();
                    }else if(draw==true){
                        GameOver();

                    }
                }
            }
        }
    }
}
