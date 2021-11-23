/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.htlgkr.mayerp190093.PosHausuebung4Ü2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mayer
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
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
            Logger.getLogger(net.htlgkr.mayerp190093.PosHausuebung4.Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(net.htlgkr.mayerp190093.PosHausuebung4.Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(java.lang.Runtime.getRuntime().availableProcessors());
        
        Scanner sc = new Scanner(System.in);
        System.out.print("n>");
        int n = sc.nextInt();
        List<Integer> numbers2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers2.add(i);
        }
        int parts2 = numbers2.size() / 3;
        
        List<Integer> ausg = new ArrayList<>();
        int sum = 0;
        int index2 = 0;
        while (numbers2.size() > index2) {
            Callable<Integer> c = new TaskSummenformel(numbers2.subList(index2, Math.min((int) (index2 + parts2), numbers2.size())),parts2);
            if (index2 + parts2 > numbers2.size()) {
                index2 = numbers2.size();
            } else {
                index2 += parts2;
            }
            Future<Integer> result = executor.submit(c);
            try {
                int ausg2 = result.get().intValue();
                ausg.add(ausg2);
            } catch (ExecutionException ex) {
                Logger.getLogger(net.htlgkr.mayerp190093.PosHausuebung4.Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int finalausg = 0;
        for (int i = 0; i < ausg.size(); i++) {
            finalausg += ausg.get(i);
        }
        finalausg += n;
        System.out.println(finalausg);
        executor.shutdown();
    }
}
