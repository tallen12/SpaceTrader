package model;

import java.util.List;
import java.util.ArrayList;

public class StarSystem {

	private String name;
	private Position pos;
	private StarType starType;
	private List<Planet> planets;
	private List<JumpPoint> jumpPoints;

	public Position getPosition() {
		return pos;
	}

	public StarSystem(String name, Position pos, StarType starType) {
		this.name = name;
		this.pos = pos;
		this.planets = new ArrayList<Planet>();
		this.jumpPoints = new ArrayList<JumpPoint>();
		this.starType = starType;
	}

	public void addPlanet(Planet planet) {
		planets.add(planet);
	}

	public void addJumpPoint(Position pos, StarSystem targetSys, Position targetPos) {
		jumpPoints.add(new JumpPoint(pos, targetSys, targetPos));
		targetSys.asymmetricalAddJumpPoint(new JumpPoint(targetPos, this, pos));
	}

	private void asymmetricalAddJumpPoint(JumpPoint jumpPoint) {
		jumpPoints.add(jumpPoint);
	}
       public ArrayList<StarSystem> getNeighbors(){
            ArrayList<StarSystem> out=new ArrayList();
            jumpPoints.stream().forEach((j) -> {
                out.add(j.getTargetSystem());
            });
            return out;
        }
}
