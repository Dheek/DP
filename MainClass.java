package com.pesit.main;

import com.pesit.maze.EnchantedMazeFactory;
import com.pesit.maze.Maze;
import com.pesit.maze.MazeFactory;
import com.pesit.maze.MazeGame;
import java.util.*;
import java.io.*;

/**
 * Created by vp2 on 20/02/16.
 */

public class MainClass 
{

    public static void main(String args[]) throws NumberFormatException, IOException 
    {  
    	MazeGame game = new MazeGame();
	    MazeFactory factory = new EnchantedMazeFactory();
        game.CreateMaze(factory);
      
        
        int[][] myInt = new int[100][100];
        int x=0;
        int y=0;
        try
         {
          BufferedReader in = new BufferedReader(new FileReader("CreateMaze.txt"));//reading files in specified directory
          String line;
          while ((line = in.readLine()) != null)
          {
        	String[] values = line.split(" ");
        	//System.out.println(values.length);
           	for (int i=0;i<values.length;i++)
          	{
        	  int str_int = Integer.parseInt(values[i]);
        	  myInt[x][y]=str_int;
        	  //System.out.print(myInt[x][y] + " ");
        	   y=y+1;
        	}
        	 // System.out.println("");
           	y=0;
        	x=x+1;
          }
                in.close();
         }
         
        catch( IOException ioException ) {}
        Traversal(myInt);
    }
    public static void Traversal(int my[][]) throws NumberFormatException, IOException
	{
    	BufferedReader in = new BufferedReader(new FileReader("TraverseMaze.txt"));
		StringBuffer sbf = new StringBuffer();
		String line;
         int room=0;
         while ((line = in.readLine()) != null)	//file reading
         {
       	String[] values = line.split("\\s+");
       	int str_int[]=new int[values.length];
          	for (int t=0;t<values.length;t++)
         	{
          		str_int[t] = Integer.parseInt(values[t]);
          		//System.out.println(str_int[t]);
          		
         	}
          	//System.out.println();
          	room=str_int[0]-1;
          //System.out.println(room);
          	for(int e=1;e<values.length;e++){
          		if(my[room][str_int[e]+1]>0)
          		{
          			room=my[room][str_int[e]+1]-1;
          		}
          	}
          	//System.out.println();
          	//System.out.println(room+1);
			sbf.append((room+1));
			sbf.append(" ");
			BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("Destination.txt")) );
			bwr.write(sbf.toString());
			bwr.flush();
			bwr.close();
         }
    }
}
