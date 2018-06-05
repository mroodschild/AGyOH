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
package org.gitia.agyoh.main;

import org.ejml.simple.SimpleMatrix;
import org.gitia.agyoh.GeneticAlgorithm;
import org.gitia.agyoh.fitness.Fitness;
import org.gitia.agyoh.fitness.Quadratic;

/**
 *
 * @author Matías Roodschild <mroodschild@gmail.com>
 */
public class Main {

    public static void main(String[] args) {
        Fitness f = new Quadratic();
        double[][] low_data = {{-30, 15, 29, 1, -2}};
        double[][] high_data = {{20, 20, 30, 3, -1}};
        SimpleMatrix low = new SimpleMatrix(low_data);
        SimpleMatrix high = new SimpleMatrix(high_data);
        
        GeneticAlgorithm ga = new GeneticAlgorithm(10, f, low, high, 0.1);
        ga.train();
    }
}
