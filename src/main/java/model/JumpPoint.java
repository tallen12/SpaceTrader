package model;

public class JumpPoint {

	private System targetSys;
	private Position targetPos;
	private Position pos;

	public JumpPoint(Position pos, System targetSys,Position targetPos) {
		pos = this.pos;
		targetSys = this.targetSys;
		targetPos = this.targetPos;
	}

	public Position getPos() {
		return pos;
	}

	public System getTargetSystem() {
		return targetSys;
	}

	public Position getTargetPos() {
		return targetPos;
	}


    
}