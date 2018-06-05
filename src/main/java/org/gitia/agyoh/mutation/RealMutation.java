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
package org.gitia.agyoh.mutation;

import java.util.Random;
import org.ejml.simple.SimpleMatrix;

/**
 *
 * @author Matías Roodschild <mroodschild@gmail.com>
 */
public class RealMutation {

    Random r = new Random();

    public SimpleMatrix mutar(SimpleMatrix gen, double percent) {

        SimpleMatrix mutados = gen.copy();

        int cant = (int) ((double) gen.numRows() * percent) + 1;

        int sel[] = new int[cant];
        for (int i = 0; i < sel.length; i++) {
            sel[i] = -1;
        }
        //buscamos los elegidos
        for (int i = 0; i < sel.length; i++) {
            int aux = r.nextInt(gen.numRows());
            aux = exist(sel, gen.numRows(), aux);
            sel[i] = aux;
        }

        System.out.println("Seleccionados:\t " + sel.length);
        for (int i = 0; i < sel.length; i++) {
            System.out.println(i + ":\t" + sel[i]);
        }

        //cambiamos los elegidos
        for (int i = 0; i < sel.length; i++) {
            int auxPos = r.nextInt(gen.numCols());
            double val = gen.get(sel[i], auxPos) + 0.2 * r.nextGaussian();
            mutados.set(sel[i], auxPos, val);
        }
        return mutados;
    }

    private int exist(int[] x, int size, int a) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == a) {
                a = r.nextInt(size);
                a=exist(x, size, a);
                System.out.println("Existe");
                return a;
            }
        }
        return a;
    }
}
