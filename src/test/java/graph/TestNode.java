/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import graph.Heurstic;
import graph.Node;
import java.util.Objects;

/**
 *
 * @author Tyler Allen <tallen40@gatech.edu>
 */
public class TestNode implements Node {
    private int testnum;
    private String name;
    public static class TestHeurstic extends Heurstic<TestNode>{
        public TestHeurstic(){
            this.reverse=true;
        }
        @Override
        public int calculate(TestNode n) {
            return n.testnum;
        }
    }
    public TestNode(int n,String na){
        testnum=n;
        name=na;
    }
    public void print(){
        System.out.println(name+": "+testnum);
    }
    @Override
    public boolean equals(Object o){
        TestNode n=(TestNode)o;
        return n.testnum==testnum&&n.name.equals(name);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.testnum;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }
    @Override
    public String toString(){
        return name;
    }
}
