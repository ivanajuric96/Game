import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static Integer myNumber= ThreadLocalRandom.current().nextInt(0,100+1);
    static Integer tries=0;
    static JLabel label= new JLabel("Gebe eine zahl ein");
    static JTextField feld=new JTextField();
    //label ist jzt überall verfügbar
    public static void main(String [] args){
        openUI();


    }public static void openUI(){
        JFrame frame= new JFrame();
        frame.setTitle("Ratespiel");
        frame.setSize(700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);


        label.setBounds(50,50,500,30);


        feld.setBounds(50,150,200,30);

        JButton button= new JButton("Raten!");
        button.setBounds(50,200,200,30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textfromfeld= feld.getText();
                Integer number= Integer.parseInt(textfromfeld);
                guess(number);
            }
        });

        frame.add(label);
        frame.add(feld);
        frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void guess(Integer number){
        if(number == myNumber){
            System.out.println("Richtig geraten");
            System.out.println("Du hast " + tries + " versuche gebraucht");
            label.setText("Richtig geraten mit " + tries + " versuchen");
        }else{
            tries++;
            System.out.println("Falsch geraten");
            label.setText("Falsch Geraten!");

            if(number<myNumber){
                System.out.println("deine zahl ist kleiner");
                label.setText("Falsch geraten, deine zahl ist zu klein");
            } else{
                System.out.println("deine zahl ist großer");
                label.setText("Falsch geraten, deine zahl ist zu groß");
            }
            feld.setText("");
        }
    }

}