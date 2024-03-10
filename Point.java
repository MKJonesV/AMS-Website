//package edu.iastate.cs228.hw2;
// @author Michael Jones V

public class Point implements Comparable<Point>
{
	private int x; 
	private int y;
	
	public static boolean xORy;  
// compare x coordinates if xORy == true and y coordinates otherwise 
// To set its value, use Point.xORy = true or false. 
	
	public Point(){}  // default constructor
		// x and y get default value 0
	
	public Point(int x, int y) {
		this.x = x;  
		this.y = y;   
	}
	
	public Point(Point p) { // copy constructor
		x = p.getX();
		y = p.getY();
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public static void setXorY(boolean xy) {
		xORy = xy; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass())
		{
			return false;
		}
    
		Point other = (Point) obj;
		return x == other.x && y == other.y;   
	}

	public int compareTo(Point q) {
    if (xORy == true && (this.x < q.x || (this.x == q.x && this.y < q.y))){
      return -1;
    } 
    if (xORy == false && (this.y < q.y || (this.y == q.y && this.x < q.x))){
      return -1;
    } 
    if (this.x == q.x && this.y == q.y){
      return 0;
    }
    return 1;
	}
	
	@Override
  public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
