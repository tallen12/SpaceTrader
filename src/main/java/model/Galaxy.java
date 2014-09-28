package model;

import model.StarSystem;
import java.util.List;
import java.util.ArrayList;

public class Galaxy {

	private List<StarSystem> systems;

	public Galaxy () {
		systems = new ArrayList<StarSystem>();
	}

	public void addSystem(StarSystem system) {
		systems.add(system);
	}

	public List<StarSystem> getSystems() {
		return systems;
	}

}