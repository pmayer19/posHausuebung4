/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mayerp190093.PosHausuebung4Ü2;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author mayer
 */
public class TaskSummenformel implements Callable<Integer> {

    List<Integer> numbers;
    int parts;

    public TaskSummenformel(List<Integer> numbers, int parts) {
        this.numbers = numbers;
        this.parts = parts;
    }


    @Override
    public Integer call() throws Exception {
       int ret = 0;
        for (int i = 0; i < numbers.size(); i++) {
            ret += numbers.get(i);
        }
        return ret;
    }

}
