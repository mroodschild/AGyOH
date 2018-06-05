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
package org.gitia.agyoh.selection;

import org.gitia.agyoh.selector.RouletteWheelSelection;
import org.ejml.simple.SimpleMatrix;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matías Roodschild <mroodschild@gmail.com>
 */
public class RouletteWheelSelectionTest {

    public RouletteWheelSelectionTest() {
    }

    /**
     * Test of setFitness method, of class RouletteWheelSelection.
     */
    @Test
    public void testSetFitness() {
        System.out.println("setFitness");
        double[] data = {1, 4, 3, 4};
        SimpleMatrix fitness = new SimpleMatrix(4, 1, true, data);
        RouletteWheelSelection instance = new RouletteWheelSelection();
        instance.setFitness(fitness);
        instance.getTickets().print("%.20f");
        int sel[] = instance.getSelection(12000);
        int count[] = new int[data.length];
        for (int i = 0; i < sel.length; i++) {
            count[sel[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println(i+":\t" + count[i]);
        }
        // TODO review the generated test code and remove the default call to fail.

    }

//    /**
//     * Test of getTickets method, of class RouletteWheelSelection.
//     */
//    @Test
//    public void testGetTickets() {
//        System.out.println("getTickets");
//        RouletteWheelSelection instance = new RouletteWheelSelection();
//        double[][] expResult = null;
//        double[][] result = instance.getTickets();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
