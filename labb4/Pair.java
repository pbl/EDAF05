public class Pair{
	private Point p1;
	private Point p2;
	
	public Pair(Point p1, Point p2){
		this.p1 = p1;
		this.p2 = p2;
	}

	public double dist(){
		ClosestPoints cp = new ClosestPoints();
		return cp.getDistance(p1, p2);
	}

	public String print(){
		double xDist = Math.abs(p1.getX() - p2.getX());
		double yDist = Math.abs(p1.getY() - p2.getY());
		return String.valueOf(xDist) + " " + String.valueOf(yDist);
	}

}

