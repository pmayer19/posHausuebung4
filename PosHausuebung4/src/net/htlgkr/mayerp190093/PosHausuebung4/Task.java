/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mayerp190093.PosHausuebung4;

import java.util.List;

/**
 *
 * @author mayer
 */
public class Task implements Runnable {

    List<Integer> numbers;
    int divider;

    public Task(List<Integer> numbers, int divider) {
        this.numbers = numbers;
        this.divider = divider;
    }

    @Override
    public void run() {
        for (Integer number : numbers) {
            if (number % divider == 0) {
                System.out.println(number);
            }
        }
    }

}
