package Generators;

import model.Planet;
import model.Position;
import model.StarSystem;

/**
 * @author Michael Lane
 */
public class SimplePlanetGenerator extends PlanetGenerator {

    public SimplePlanetGenerator(
    	String name, 
    	Position pos, 
    	StarSystem system) {
    	
    	super(name, pos, system);
    }
    
	public Planet generate() {
		return new Planet(name, pos);
	}
}
