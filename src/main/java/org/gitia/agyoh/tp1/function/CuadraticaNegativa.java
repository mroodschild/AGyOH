/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gitia.agyoh.tp1.function;

import org.ejml.simple.SimpleMatrix;

/**
 *
 * @author Matías Roodschild <mroodschild@gmail.com>
 */
public class CuadraticaNegativa implements Function{

    @Override
    public SimpleMatrix eval(SimpleMatrix X) {
        return X.elementPower(2).negative();
    }
    
}
