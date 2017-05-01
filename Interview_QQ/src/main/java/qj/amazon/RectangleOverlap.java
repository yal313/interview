package qj.amazon;

import java.awt.Point;

public class RectangleOverlap {

	public static void main(String[] args){
		
		Point l1 = new Point();
		l1.x = 0;
		l1.y = 10;	
		Point r1 = new Point();
		r1.x = 10;
		r1.y = 0;

		Point l2 = new Point();
		l2.x = 5;
		l2.y = 5;
		Point r2 = new Point();
		r2.x = 15;

	    if (doOverlap(l1, r1, l2, r2))
	        System.out.println("Rectangles Overlap");
	    else
	    	System.out.println("Rectangles Don't Overlap");
	}
	
	public static boolean doOverlap(Point l1, Point r1, Point l2, Point r2){
		if(l1.x>r2.x || l2.x > r1.x){
			return false;
		}
		if(r1.y>l2.y || r2.y > l1.y){
			return false;
		}
		return true;
	}
}
