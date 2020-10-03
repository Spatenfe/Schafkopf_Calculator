package UI_Schafkopf;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.xml.validation.SchemaFactory;

import Schafkopf_cal.Schafkopf_cal;
import data.*;

public final class UI_Schafkopf extends Frame implements WindowListener, ActionListener {

    private static final long serialVersionUID = 1L;
    private TextField text_area;
    private Button b_save;
    private Button b_close;
    private static JTextField laufende_field;
    private JComboBox<String> w_p1;
    private JComboBox<String> w_p2;
    private JComboBox<String> play_kind;
    private JCheckBox contra_box;
    private JCheckBox contra_re_box;
    private JTextField w_points_text;
    private static JPanel bilanz_pan;
    public static ArrayList<JTextArea> bp_text;
    public static JTextArea log_text;

    public UI_Schafkopf(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // setLayout(new FlowLayout());
        setLayout(null);

        JPanel lauf_pan = new JPanel();
        JPanel Spielart_pan = new JPanel();
        JPanel w_p1_pan = new JPanel();
        JPanel w_p2_pan = new JPanel();
        JPanel w_points_pan = new JPanel();
        JPanel contra_pan = new JPanel();
        JPanel contra_re_pan = new JPanel();
        JPanel split_screen = new JPanel();
        JPanel split_screen_2 = new JPanel();
        JPanel log_pan = new JPanel();

        JLabel lauf_lab = new JLabel("Laufende: ");
        JLabel Spielart_lab = new JLabel("Spielart: ");
        JLabel w_p1_lab = new JLabel("Erster Spieler: ");
        JLabel w_p2_lab = new JLabel("Zweiter Spieler: ");
        JLabel w_points_lab = new JLabel("Gewinnerpunkte: ");

        w_points_pan.add(w_points_lab);
        lauf_pan.add(lauf_lab);
        Spielart_pan.add(Spielart_lab);
        w_p1_pan.add(w_p1_lab);
        w_p2_pan.add(w_p2_lab);

        String[] plays = { "Solo", "Wenz", "Sauspiel" };
        String[] Player1 = { "Player 1", "Player 2", "Player 3", "Player 4" };
        String[] Player2 = { "None", "Player 1", "Player 2", "Player 3", "Player 4" };

        play_kind = new JComboBox<String>(plays);
        w_p1 = new JComboBox<String>(Player1);
        w_p2 = new JComboBox<String>(Player2);
        contra_box = new JCheckBox("Contra");
        contra_re_box = new JCheckBox("Contra Re");
        laufende_field = new JTextField("Enter number", 20);
        w_points_text = new JTextField("Enter number", 20);
        log_text = new JTextArea();

        log_text.setEditable(false);
        //log_text.setBackground(Color.);

        w_points_pan.add(w_points_text);
        contra_pan.add(contra_box);
        Spielart_pan.add(play_kind);
        w_p1_pan.add(w_p1);
        w_p2_pan.add(w_p2);
        lauf_pan.add(laufende_field);
        contra_re_pan.add(contra_re_box);

        int x_offset1 = 30;
        int y_offset1 = 40;
        int x_offset2 = 390;
        int big_box_len = 350;
        int small_box_len = 150;
        int y_box_len = 30;
        int y_gab = 10;
        int y_offset_per = y_box_len + y_gab;
        int y_offset2 = y_offset1 + y_offset_per * 5 + 15;
        int y_offset3 = y_offset2 + y_box_len * 2 + y_gab * 2;

        contra_re_pan.setBounds(x_offset2, y_offset1 + y_offset_per * 1, small_box_len, y_box_len);
        contra_pan.setBounds(x_offset2, y_offset1 + y_offset_per * 0, small_box_len, y_box_len);
        
        log_pan.setBounds(x_offset1, y_offset3 + y_gab, 510, 620);
        log_text.setBounds(x_offset1 + 10, y_offset3 + y_gab + 10, 510 - 20, 620 - 20);

        split_screen_2.setBounds(20, y_offset3, 530, 5);
        split_screen.setBounds(20, y_offset1 + y_offset_per * 5, 530, 5);
        split_screen.setBackground(Color.BLACK);
        split_screen_2.setBackground(Color.BLACK);

        Spielart_pan.setBounds(x_offset1, y_offset1 + y_offset_per * 0, big_box_len, y_box_len);
        w_p1_pan.setBounds(x_offset1, y_offset1 + y_offset_per * 1, big_box_len, y_box_len);
        w_p2_pan.setBounds(x_offset1, y_offset1 + y_offset_per * 2, big_box_len, y_box_len);
        lauf_pan.setBounds(x_offset1, y_offset1 + y_offset_per * 3, big_box_len, y_box_len);
        w_points_pan.setBounds(x_offset1, y_offset1 + y_offset_per * 4, big_box_len, y_box_len);

        bilanz_pan = new JPanel();
        create_b();
        bilanz_pan.setBounds(x_offset1, y_offset2, big_box_len + small_box_len + 10, y_box_len * 2 + y_gab);

        b_save = new Button("Save");
        b_save.setBounds(x_offset2, y_offset1 + y_offset_per * 3, 150, 30);
        b_save.setBackground(Color.GREEN);
        b_close = new Button("Close");
        b_close.setBounds(x_offset2, y_offset1 + y_offset_per * 4, 150, 30);
        b_close.setBackground(Color.RED);

        this.add(log_text);
        this.add(log_pan);
        this.add(split_screen_2);
        this.add(b_close);
        this.add(bilanz_pan);
        this.add(split_screen);
        this.add(w_points_pan);
        this.add(contra_pan);
        this.add(w_p1_pan);
        this.add(w_p2_pan);
        this.add(lauf_pan);
        this.add(Spielart_pan);
        this.add(b_save);
        this.add(contra_re_pan);

        b_save.addActionListener(this);
        b_close.addActionListener(this);
    }

    public static void create_b() {
        ArrayList<JPanel> bp_pan = new ArrayList<JPanel>();
        ArrayList<JLabel> bp_lab = new ArrayList<JLabel>();
        bp_text = new ArrayList<JTextArea>();
        for (int i = 0; i < Schafkopf_cal.PLAYERCOUNT; i++) {
            JPanel temp_pan = new JPanel();
            bp_pan.add(temp_pan);
            bilanz_pan.add(bp_pan.get(i));

            JLabel temp_lab = new JLabel("Player " + (i + 1) + ": ");
            bp_lab.add(temp_lab);
            bp_pan.get(i).add(bp_lab.get(i));

            JTextArea temp = new JTextArea();
            bp_text.add(temp);
            bp_pan.get(i).add(bp_text.get(i));
            
            //bp_text.get(i).setText("Billanz: " + data.player_b[i] + " __________ " + data.player_round_b[i]);
            bp_text.get(i).setEditable(false);
        }
        update_b(true);
    }

    public static void update_b(boolean first_time) {
        for (int i = 0; i < Schafkopf_cal.PLAYERCOUNT; i++) {
            String temp = "Billanz: " + data.player_b[i] + data.player_round_b[i];
            int count = 25 - temp.length();
            String _string = "";
            for(int x = 0; x < count; x++){
                _string += ' ';
            }                
            bp_text.get(i).setText("Billanz: " + data.player_b[i] + _string + data.player_round_b[i]);
        }
        //send Message to Log
        if(!first_time){
            log_text.append("\n" + data.tot_matches + ". " + Schafkopf_cal.play + ": ");
            for(int i = 0; i < Schafkopf_cal.PLAYERCOUNT; i++){
                if(Schafkopf_cal.player[i] == 1){
                    log_text.append("W: Player " + (i + 1) + ": " + data.player_round_b[i] + "; ");
                }else{
                    log_text.append("L: Player " + (i + 1) + ": " + data.player_round_b[i] + "; ");
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.b_save) {
            Schafkopf_cal.play = (String) play_kind.getSelectedItem();
            Schafkopf_cal.contra = (boolean) contra_box.isSelected();
            Schafkopf_cal.re = (boolean) contra_re_box.isSelected();
            String temp = (String) laufende_field.getText();
            try {
                Schafkopf_cal.lauf = Integer.parseInt(temp);
            } catch (Exception ex) {
                temp = "0";
                Schafkopf_cal.lauf = Integer.parseInt(temp);
            }
            temp = (String) w_points_text.getText();
            try {
                Schafkopf_cal.points_winner = Integer.parseInt(temp);
            } catch (Exception y) {
                temp = "0";
                Schafkopf_cal.points_winner = Integer.parseInt(temp);
            }
            this.set_winner();
            Schafkopf_cal.get_data();
            // Schafkopf_cal.show_data();
            update_b(false);
            data.save_round();
        } else if (e.getSource() == this.b_close) {
            try {
                data.write();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                System.out.println("ERROR_01");
                e1.printStackTrace();
            }
            System.exit(0);
        }
    }
    
    public void set_winner(){
        String temp = (String) w_p1.getSelectedItem();
        for(int i = 0; i < Schafkopf_cal.PLAYERCOUNT; i++){
            Schafkopf_cal.player[i] = 0;
        }
        for(int i = 0; i < 2; i++){
            switch(temp){
                case "Player 1":
                    Schafkopf_cal.player[0] = 1;
                    break;
                case "Player 2":
                    Schafkopf_cal.player[1] = 1;
                    break;
                case "Player 3":
                    Schafkopf_cal.player[2] = 1;
                    break;
                case "Player 4":
                Schafkopf_cal.player[3] = 1;
                break;
            }
            temp = (String) w_p2.getSelectedItem();
        }
        if(Schafkopf_cal.points_winner < 60){
            for(int i = 0; i < Schafkopf_cal.PLAYERCOUNT; i++){
                if(Schafkopf_cal.player[i] == 1){
                    Schafkopf_cal.player[i] = 0;
                }else{
                    Schafkopf_cal.player[i] = 1;
                }
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }
	public void setDefaultCloseOperation(int exitOnClose) {
	}
}