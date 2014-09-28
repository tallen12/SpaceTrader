package model;

import model.StarSystem;
import java.awt.geom.Point2D;

public class JumpPoint {

	private StarSystem targetSys;
	private Position targetPos;
	private Position pos;

	public JumpPoint(Position pos, StarSystem targetSys,
					 Position targetPos) {
		pos = this.pos;
		targetSys = this.targetSys;
		targetPos = this.targetPos;
	}

	public Position getPos() {
		return pos;
	}

	public StarSystem getTargetSystem() {
		return targetSys;
	}

	public Position getTargetPos() {
		return targetPos;
	}


}