package bg.swift.HW10_Ex08;

public class Segment {
	private int x;
    private int y;

    public Segment(int x, int y) {
       this.x = x;
       this.y = y;
    }

    public boolean isOnCoordinates(int x, int y) {
       return this.x == x && this.y == y;
    }
    
    public int getY() {
		return y;
	}

	public int getX() {
    	return this.x;
    }
    
}
