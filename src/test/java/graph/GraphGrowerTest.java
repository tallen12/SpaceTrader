package graph;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import graph.TestNode.TestHeurstic;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tyler Allen <tallen40@gatech.edu>
 */
public class GraphGrowerTest {
    GraphGrower<TestNode> graph;
    public GraphGrowerTest() {
        graph=new GraphGrower(new TestHeurstic());
    }
    
    @BeforeClass
    public static void setUpClass() { 
   }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void Test(){
        ArrayList<TestNode> test=new ArrayList();
        for(int i=0;i<100;i++){
            test.add(new TestNode(i,"Node:"+i));
        }
        graph.addNeighbor(test);
        int c=100;
        for(int i=0;i<100;i++){
            c--;
            assertEquals("Graph outputs correct order",graph.popNext(),new TestNode(c,"Node:"+c));
        }
    }
}
