/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mayerp190093.PosHausuebung4;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author mayer
 */
public class TaskSummenformel implements Runnable {

    List<Integer> numbers;

    public TaskSummenformel(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int ret = 0;
        for (int i = 0; i < numbers.size(); i++) {
            ret += numbers.get(i);
        }
        System.out.println(ret);
    }

}
