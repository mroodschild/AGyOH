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
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Matías Roodschild <mroodschild@gmail.com>
 */
public class PopulationTest {

    public PopulationTest() {
    }

    /**
     * Test of generatePopulation method, of class Population.
     */
    @Test
    public void testGeneratePopulation_3args() {
        System.out.println("generatePopulation");
        int pop = 10;
        SimpleMatrix lowBound = new SimpleMatrix(1, 10);
        lowBound.fill(-3);
        SimpleMatrix highBound = new SimpleMatrix(1, 10);
        highBound.fill(3);
        double[] exp = {1.385, -0.617, 1.170, 0.740, -0.408, -0.752, -0.427, 1.194, -2.947, 1.944,
            -0.540, -0.915, 1.831, -1.892, -1.601, -0.220, -1.151, -1.772, 0.787, -2.258,
            -1.754, -1.236, -2.970, -2.936, 2.339, -0.998, 1.304, -1.471, -1.752, 0.702,
            -1.004, 0.039, 0.139, -2.034, -2.770, -0.341, 2.774, 1.667, 2.282, -0.109,
             2.807, -2.304, 1.464, -1.932, 0.554, 0.025, -1.743, -1.650, 1.242, -2.401,
            -2.963, 1.623, -2.148, 0.242, 0.931, 2.994, -1.964, 2.899, 1.340, 0.703,
             2.782, 0.959, -0.110, 2.843, -2.281, 0.782, 0.294, 1.822, 0.057, -2.831,
             2.639, -2.060, 0.267, -1.527, 0.915, 2.458, 0.333, 2.018, 2.923, 0.549,
             2.683, -0.731, 0.463, -0.633, 2.906, 0.046, 0.527, -2.021, -2.081, -2.562,
             2.622, -2.161, -1.771, -1.694, -1.760, -0.051, 1.735, 0.825, 1.263, -2.556};
        SimpleMatrix expResult = new SimpleMatrix(pop, lowBound.numCols(), true, exp);
        Random r = new Random(1);
        SimpleMatrix result = Population.generatePopulation(pop, lowBound, highBound, r);
        
        assertArrayEquals(expResult.getDDRM().getData(), result.getDDRM().getData(), 0.001);
        
        //fail("The test case is a prototype.");
    }

}
