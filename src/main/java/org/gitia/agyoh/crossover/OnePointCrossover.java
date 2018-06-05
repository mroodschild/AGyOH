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
package org.gitia.agyoh.crossover;

import java.util.Random;
import org.ejml.simple.SimpleMatrix;

/**
 *
 * @author Matías Roodschild <mroodschild@gmail.com>
 */
public class OnePointCrossover implements Crossover {

    public SimpleMatrix cross(SimpleMatrix gen, int[] idx) {

        SimpleMatrix cruzados = new SimpleMatrix(idx.length, gen.numCols());
        Random r = new Random();

        for (int i = 0; i < idx.length; i = i + 2) {
            SimpleMatrix genA = gen.extractVector(true, i);
            SimpleMatrix genB = gen.extractVector(true, i + 1);
            int point = r.nextInt(idx.length - 1) + 1;
            //int point = 3;
            //System.out.println("point" + point);
            SimpleMatrix partA1 = genA.extractMatrix(0, 1, 0, point);
            SimpleMatrix partA2 = genA.extractMatrix(0, 1, point, SimpleMatrix.END);
            SimpleMatrix partB1 = genB.extractMatrix(0, 1, 0, point);
            SimpleMatrix partB2 = genB.extractMatrix(0, 1, point, SimpleMatrix.END);

            SimpleMatrix genC = partA1.concatColumns(partB2);
            SimpleMatrix genD = partB1.concatColumns(partA2);

            cruzados.setRow(i, 0, genC.getDDRM().getData());
            cruzados.setRow(i + 1, 0, genD.getDDRM().getData());
        }

        return cruzados;
    }

}
