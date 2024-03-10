//package edu.iastate.cs228.hw2;
// @author Michael Jones V

import java.util.Comparator;
import java.io.FileNotFoundException;
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;

/**
 * This abstract class is extended by SelectionSort, InsertionSort, MergeSort, and QuickSort.
 * It stores the input (later the sorted) sequence. 
 */

public abstract class AbstractSorter
{
	
	protected Point[] points;
	
	protected String algorithm = null; 
		 
	protected Comparator<Point> pointComparator = null;  
	
	// Add other protected or private instance variables you may need. 
	

	protected AbstractSorter(){}

	protected AbstractSorter(Point[] pts) throws IllegalArgumentException
	{
    points = pts;
    if(pts == null || pts.length == 0)
      throw new IllegalArgumentException("Invalid input array");
	}

		
	
	
	

	/**
	 * Generates a comparator on the fly that compares by x-coordinate if order == 0, by y-coordinate
	 * if order == 1. Assign the 
     * comparator to the variable pointComparator. 
     *  
	 * 
	 * @param order  0   by x-coordinate 
	 * 				 1   by y-coordinate
	 * 			    
	 * 
	 * @throws IllegalArgumentException if order is less than 0 or greater than 1
	 *        
	 */
	public void setComparator(int order) throws IllegalArgumentException
	{
		if(order == 0){
      pointComparator = new Comparator<Point>(){
        
        public int compare(Point p1, Point p2) {
          p1.xORy = true;
          return p1.compareTo(p2);
        }
      };
    }
    if(order == 1){
      pointComparator = new Comparator<Point>(){
        
        public int compare(Point p1, Point p2) {
          p1.xORy = false;
          return p1.compareTo(p2);
        }
      };
    }
    else{
      throw new IllegalArgumentException("Invalid order");
    }
	}

	public abstract void sort(); // abstract class for sorting algoritms
	
	public Point getMedian() // returns median point
	{
		return points[points.length/2]; 
	}
	
	
	public void getPoints(Point[] pts) // Copies the array
	{
		pts = points;
	}
	
	protected void swap(int i, int j) // Swaps the points at indexes i and j
	{
		Point p = points[i];
    points[i] = points[j];
    points[j] = p;
	}	
}
