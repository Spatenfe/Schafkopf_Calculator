package Schafkopf_cal;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import UI_Schafkopf.UI_Schafkopf;
import data.data;

public class Schafkopf_cal {
    public static int points_winner;
    public static String play;
    public static boolean contra;
    public static boolean re;
    public static int lauf;
    public static int[] player = new int[4];
    public static int round_b = 0;
    public static final int PLAYERCOUNT = 4;



    public static void main(String[] args) throws IOException {
        json_setup();
        UI_Schafkopf frame = new UI_Schafkopf("Test1");
        frame.setSize(570, 1000);
        frame.setVisible(true);
        show_data();
    }
    public static void show_data(){
        System.out.println("Round_b: " + round_b);
        for(int i = 0; i < Schafkopf_cal.PLAYERCOUNT; i++){
            System.out.println(data.player_b[i]);
        }
    }

    public static void get_data() {
        data.tot_matches++;
        round_b = 0;
        if(points_winner == 120){
            round_b += 20;
        }else if(points_winner > 90){
            round_b += 10;
        }
        switch (play) {
            case "Solo":
                round_b += 50;
                break;
            case "Wenz":
                round_b += 40;
                break;
            case "Sauspiel":
                round_b += 20;
                break;
        }
        if(lauf >= 2 && play == "Wenz" || lauf > 2){
            round_b += 10 * lauf;
        }
        if(contra){
            if(re){
                round_b *= 4;
            }else{
                round_b *= 2;
            }
        }
        cal_b();
    }
    public static void cal_b(){
        int round_b_player = round_b;
        if((play == "Solo" || play == "Wenz") && points_winner < 60){
            round_b *= 3;
        }else if(play == "Solo" || play == "Wenz"){
            round_b_player *= 3;
        }
        for(int i = 0; i < PLAYERCOUNT; i++){
            if(player[i] == 1){
                data.player_b[i] += round_b_player;
                data.player_round_b[i] = round_b_player;
                System.out.println(i + "_" + round_b_player);
            }else if(player[i] == 0){
                data.player_b[i] -= round_b;
                data.player_round_b[i] = round_b * -1;
                System.out.println(i + "_" + round_b);
            }
        }
    }

    private static void json_setup() throws IOException {
        data.check_file();
    }
}
