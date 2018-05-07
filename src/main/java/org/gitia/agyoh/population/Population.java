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
package org.gitia.agyoh.population;

import java.util.Random;
import org.ejml.simple.SimpleMatrix;

/**
 *
 * @author Matías Roodschild <mroodschild@gmail.com>
 */
public class Population {
    
    /**
     * 
     * @param pop amount of population
     * @param lowBound [1xn] where n is the number of features
     * @param highBound [1xn] where n is the number of features
     * @return Matrix [pop x n] where each row is a gen
     */
    public static SimpleMatrix generatePopulation(int pop, SimpleMatrix lowBound, SimpleMatrix highBound) {
       return generatePopulation(pop, lowBound, highBound, new Random());
    }

    /**
     * 
     * @param pop amount of population
     * @param lowBound [1xn] where n is the number of features
     * @param highBound [1xn] where n is the number of features
     * @param r Random
     * @return Matrix [pop x n] where each row is a gen
     */
    public static SimpleMatrix generatePopulation(int pop, SimpleMatrix lowBound, SimpleMatrix highBound, Random r) {
        if (pop < 1 || lowBound.numCols() != highBound.numCols()) {
            String error = "";
            if (pop < 1) {
                error = "pop < 1 ";
            }
            if (lowBound.numCols() != highBound.numCols()) {
                error = "lowBound.numCols() != highBound.numCols() ";
            }
            System.err.println("Error: " + error);
            System.exit(0);
        }
        SimpleMatrix population = new SimpleMatrix(pop, lowBound.numCols());
        for (int i = 0; i < lowBound.numCols(); i++) {
            SimpleMatrix v = SimpleMatrix.random_DDRM(pop, 1, lowBound.get(i), highBound.get(i), r);
            population.setColumn(i, 0, v.getDDRM().getData());
        }
        return population;
    }

}