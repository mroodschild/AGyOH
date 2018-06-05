/*
 * The MIT License
 *
 * Copyright 2018 Matías Roodschild <mroodschild@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.gitia.agyoh.selector;

import java.util.Random;
import org.ejml.simple.SimpleMatrix;

/**
 *
 * @author Matías Roodschild <mroodschild@gmail.com>
 */
public class RouletteWheelSelection implements Selector {

    double sumFit = 0;
    int[] idx;
    SimpleMatrix tickets;
    double eps = 0.0000000000000001;

    @Override
    public void setFitness(SimpleMatrix fitness) {
        idx = new int[fitness.numRows()];
        tickets = new SimpleMatrix(fitness.numRows(), 2);
        sumFit = fitness.elementSum();
        double sum = 0;
        for (int i = 0; i < fitness.numRows(); i++) {
            tickets.set(i, 0, sum);
            sum += fitness.get(i) / sumFit + eps;
            tickets.set(i, 1, sum);
        }
    }

    @Override
    public SimpleMatrix getTickets() {
        return tickets;
    }

    @Override
    public int[] getSelection(int number) {
        Random r = new Random();
        int[] selection = new int[number];
        double winTicket;
        for (int i = 0; i < number; i++) {
            winTicket = r.nextDouble();
            for (int j = 0; j < tickets.numRows(); j++) {
                if (winTicket >= tickets.get(j, 0) && winTicket < tickets.get(j, 1)) {
                    selection[i] = j;
                    break;
                }
            }
        }
        return selection;
    }

}
