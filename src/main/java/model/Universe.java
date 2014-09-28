import java.util.ArrayList;

public class Universe {

	private ArrayList<System> systems;

	public Universe() {
		systems = new ArrayList<System>();
	}

	public void addSystem(System system) {
		systems.add(system);
	}

	public ArrayList<System> getSystems() {
		return systems;
	}

}