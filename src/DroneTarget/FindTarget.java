package DroneTarget;
import java.util.Scanner;


public class FindTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enetr Size of the grid");
		int x = sc.nextInt();
		int y = sc.nextInt();
		int [][] grid = new int[x][y];
		System.out.println("Enter Target Coordinate");
		int targetX= sc.nextInt();
		int targetY = sc.nextInt();
		int [][] Drone = {{0,0},{x-1,0},{0,y-1},{x-1,y-1}};

		
		int closestDrone = nearestDrone(Drone,targetX,targetY);
		System.out.println("Closest Drone :"+ closestDrone+1);
		int droneX = Drone[closestDrone][0];
		int droneY = Drone[closestDrone][1];
		printGrid(grid,targetX,targetY,droneX,droneY);
		printPath(targetX,targetY,droneX,droneY,x,y,closestDrone);
		sc.close();
		
	}
	public static int nearestDrone(int [][]Drone , int targetX , int targetY)
	{
		int droneNum=-1;
		int minDist = Integer.MAX_VALUE;
		for(int i=0;i<4;i++)
		{
			int distance = Math.abs(Drone[i][0]-targetX) + Math.abs(Drone[i][1]-targetY);
			if(distance<minDist)
			{
				droneNum=i;
				minDist = distance;
			}
			
		}
		return droneNum;
	}
	public static void printGrid(int [][]grid, int targetX , int targetY, int droneX , int droneY) {
		int sizeX = grid.length;
		int sizeY = grid[0].length;
		for(int i=0;i<sizeX;i++)
		{
			for(int j=0;j<sizeY;j++)
			{
				if(droneX == i && droneY == j)
				{
					grid[i][j]=1;
				}
				else if(targetX == i && targetY ==j)
				{
					grid[i][j]=2;
				}
				else
				{
					grid[i][j]=0;
				}
				
			}
		}
		System.out.println("Initial Grid:");
		for(int i=0;i<sizeX;i++)
		{
			for(int j=0;j<sizeY;j++)
			{
				if(grid[i][j]==1)
				{
					System.out.print("D ");
				}
				else if(grid[i][j]==2)
				{
					System.out.print("T ");
				}
				else {
					System.out.print(grid[i][j]+ " ");
				}
				
			}
			System.out.println();
		}
		
		
	}
	public static void printPath(int targetX, int targetY,int droneX, int droneY, int x, int y,int closestDrone)
	{
		System.out.println("Path Taken:");
		System.out.print("("+ droneX+","+droneY+") =>");
		while(targetX!=droneX && targetY != droneY)
		{
			if(droneX<targetX)
			{
				droneX= Math.min(droneX+1, x-1);
			}
			else if(droneX> targetX)
			{
				droneX= Math.max(droneX-1, 0);
			}
			if(droneY<targetY)
			{
				droneY= Math.min(droneY+1, y-1);
			}
			else if(droneY> targetY)
			{
				droneY= Math.max(droneY-1, 0);
			}
			System.out.print("("+ droneX+","+droneY+") =>");		
		}
		System.out.print("Target Reached by Drone:"+ closestDrone+1);
	}
	
	

}
