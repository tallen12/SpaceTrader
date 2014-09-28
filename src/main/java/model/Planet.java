package model;

public class Planet {

	private Position pos;

	public Planet(Position pos) {
		this.pos = pos;
	}

    public Planet(String name, Position pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

}