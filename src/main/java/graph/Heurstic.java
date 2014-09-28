/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Comparator;

/**
 *
 * @author Tyler Allen <tallen40@gatech.edu>
 */
abstract class Heurstic<N extends Node> implements Comparator<N>{
    protected boolean reverse=false;
    public abstract int calculate(N n);
    @Override
    public int compare(N t, N t1) {
        int q1=calculate(t);
        int q2=calculate(t1);
        return (reverse)?q2-q1:q1-q2;
    }
}
