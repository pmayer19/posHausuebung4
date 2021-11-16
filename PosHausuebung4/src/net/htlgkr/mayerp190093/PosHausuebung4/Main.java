/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mayerp190093.PosHausuebung4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author mayer
 */
public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        String filename = "numbers.csv";
        File file = new File(filename);
        try (final BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {
                String[] input = line.split(":");
                for (int i = 0; i < input.length; i++) {
                    try {
                        numbers.add(Integer.parseInt(input[i]));
                    } catch (NumberFormatException n) {
                    }

                }
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(java.lang.Runtime.getRuntime().availableProcessors());

        Scanner sc = new Scanner(System.in);
//        System.out.print("Teiler>");
//        int chunks = sc.nextInt();
//        System.out.print("Chunks>");
//        int divider = sc.nextInt();
//
//        int parts = numbers.size() / chunks;
//
//        int index = 0;
//
//        while (numbers.size() > index) {
//            Task task = new Task(numbers.subList(index, Math.min((int) (index + parts), numbers.size())), divider);
//            executor.execute(task);
//            if (index + parts > numbers.size()) {
//                index += numbers.size() - index;
//            } else {
//                index += parts;
//            }
//        }
//

        System.out.print("n>");
        int n = sc.nextInt();
        List<Integer> numbers2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers2.add(i);
        }
        int parts2 = numbers2.size() / 3;

        int index2 = 0;
        while (numbers2.size() > index2) {
            TaskSummenformel tasksu = new TaskSummenformel(numbers2.subList(index2, Math.min((int) (index2 + parts2), numbers2.size())));
            executor.execute(tasksu);
            if (index2 + parts2 > numbers2.size()) {
                index2 += numbers2.size() - index2;
            } else {
                index2 += parts2;
            }
        }
        executor.shutdown();
    }
}
