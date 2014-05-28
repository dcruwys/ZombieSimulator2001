package edu.du.cs;

import java.util.ArrayList;

public class Simulate {
	private int[][] grid;
	int myX, myY;
	private int mySize; //Grid Size
	//More node stuff
	private ArrayList<Node> walkway = new ArrayList<Node>();
	
	public Simulate() {
		mySize = 50;
		grid = new int[mySize][mySize];
	}
	//0 is walkway
	//9 is intersection (walkway)
	//1 is building
	public void generateBuildings(){
		for (int row=0; row < mySize; row ++){
			for (int col=0; col < mySize; col ++){
				grid[row][col] = 3;
			}
		}
		//first pass
		for (int row=0; row < mySize; row += 5){
			for (int col=0; col < mySize; col ++){
				   grid[row][col] = 0;
			}
		}
		//second pass
		for (int row=0; row < mySize; row ++){
			for (int col=0; col < mySize; col += 5){
				   grid[row][col] = 0;
			}
		}
		//generation
		for (int row=0; row < mySize; row ++){
			for (int col=0; col < mySize; col ++){
				if(grid[row][col] != 0 && (int) Math.ceil(Math.random()*100) > 10){
				   grid[row][col] = 1;
				}
				if(grid[row][col] == 3){
					grid[row][col] = 0;
				}
			}
		}
		for (int row=0; row < mySize; row ++){
			for (int col=0; col < mySize; col ++){
				if(grid[row][col] == 0 || grid[row][col] == 9)
					walkway.add(new Node((row*10-5), (col*10-5), true));
				else
					walkway.add(new Node((row*10-5), (col*10-5), false));
			}
		}
		
	}
	
	public ArrayList<Node> getWalkwayNodes(){
		return walkway;
	}
	
	public int[][] getGrid(){
		return grid;
	}
	
}
