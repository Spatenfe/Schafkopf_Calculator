package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Schafkopf_cal.Schafkopf_cal;

public class data {
    private static String directory = "C://Users//Felix//Desktop//Schafkopf_cal//directory.txt";
    public static int[] player_b = new int[4];
    public static int tot_matches;
    public static int[] player_round_b = new int[4];
    static ArrayList<String> log = new ArrayList<String>();

    public static void check_file() throws IOException {
        File f = new File(directory);
        if (f.createNewFile()) {
            System.out.println("new File!!!");
        } else {
            System.out.println("load file");
            read_file();
        }
    }
/*
    public static void save() throws IOException {
        File file = new File(directory);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println("febwqfoijwb");
        pw.close();
    }*/

    private static void read_file() throws FileNotFoundException {
        FileReader reader = new FileReader(directory);
        Scanner sc = new Scanner(reader);
        for (int i = 0; i < Schafkopf_cal.PLAYERCOUNT; i++) {
            player_b[i] = Integer.parseInt(sc.nextLine());
        }
        tot_matches = Integer.parseInt(sc.nextLine());
        try {
            while (true) {
                log.add(sc.nextLine());
            }
        } catch (Exception e) {
            sc.close();
        }
    }
    public static void write() throws IOException {
        File file = new File(directory);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        for (int i = 0; i < Schafkopf_cal.PLAYERCOUNT; i++) {
            pw.println(player_b[i]);
        }
        pw.println(tot_matches);
        while (!log.isEmpty()) {
            pw.println(log.get(0));
            log.remove(0);
        }
        pw.close();
    }
    public static void save_round(){
        log.add("");
        for (int i = 0; i < Schafkopf_cal.PLAYERCOUNT; i++) {
            log.add(Integer.toString(player_round_b[i]));
        }
        log.add(Integer.toString(tot_matches));
    }
}
