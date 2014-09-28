package model;

public class Position {
    public double x;
    public double y;

    public Position(double x, double y) {
            this.x = x;
            this.y = y;
    }

    public Position(Position that) {
            this.x = that.x;
            this.y = that.y;
    }

    public double distTo(Position that) {
            return Math.sqrt((this.x - that.x) * (this.x - that.x) + (this.y - that.y) * (this.y - that.y));
    }

    public double angleTo(Position that) {
            return Math.atan2(this.x - that.x, this.y - that.y);
    }

    public double toAngle() {
            return Math.atan2(this.x, this.y);
    }


    public int relQuadrant(Position that) {
            if (this.x < that.x && this.y < that.y) return 1;
            if (this.x > that.x && this.y < that.y) return 2;
            if (this.x > that.x && this.y > that.y) return 3;
            if (this.x < that.x && this.y > that.y) return 4;
            return 0;
    }

    public void add(Position that) {
            this.x += that.x;
            this.y += that.y;
    }

    public boolean equals(Position that) {
            return (this.x == that.x && this.y == that.y);
    }

    public String toString() {
            String s = "(" + x + ", " + y + ")";
            return s;
    }

    /**
    Reflects the vector about the input vector
    @param n the vector perpendicular to the surface of the reflecting object
    */
    public Position reflectOff(Position n){
            double len2 = n.x * n.x + n.y * n.y;
            double dot = x * n.x + y * n.y;
            return new Position(x - 2*dot*n.x / len2, y - 2*dot*n.y / len2);
    }
}