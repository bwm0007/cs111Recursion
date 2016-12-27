//Maze.java
//CS 111 solution to the maze problem of assignement 1

public class Maze
{
   private final char PATH = 'P';
   private final char HEDGE = 'H';
   private final char EXIT = 'E';
   
   private char [] [] maze = {{'H','H','H','P','H','H','H','P','H','H'},
    {'H','H','P','P','H','H','P','P','H','H'},
    {'P','H','P','H','H','P','P','H','P','E'},
    {'H','H','H','H','P','P','H','H','P','H'},
    {'P','P','P','H','P','H','H','P','P','H'},
    {'H','H','P','H','P','H','H','P','H','H'},
    {'H','H','P','P','P','H','H','P','P','H'},
    {'H','H','H','P','H','H','H','H','P','H'},
    {'H','H','H','P','P','P','P','P','P','H'},
    {'H','H','H','H','P','H','H','H','H','H'}};
  private int nRows;
  private int nCols;
 
 
  public Maze()
  {
    nRows = 10;
    nCols =10;
  }
  
   
  public String toString()
  { String result = "";;
    for (int i =0;i<nRows;i++)
    {  for (int j=0; j<nCols;j++)
      {if (maze[i][j] == PATH) result +=" ";
           else result += maze [i][j];
       }
     result+='\n';
    }  
     return result;
  }
  
  public boolean wayOut (int r , int c)
  {
    //intialize selection of posibilities
    boolean clear=false;
    int move=0;
    
    System.out.println ("coming in r = " + r + " c = " + c);
    
    //determine if this placement is okay
    if (r < 0 || r > nRows-1 || c < 0 || c > nCols-1) return false;
    //can't make move
    if (maze[r][c]==HEDGE) return false;
    //record the placement
    if (maze[r][c]!= EXIT)maze [r][c] = HEDGE;
   //at an exit?
    if (maze[r][c]==EXIT) return true;
        
    
    //make next move
    do
    {
      move++;
      switch(move)
      { case 1: clear = wayOut(r+1,c);
        break;
        case 2: clear = wayOut(r,c+1);
        break;
        case 3: clear= wayOut(r-1,c);
        break;
        case 4: clear= wayOut(r,c-1);
        break;
      }
      //was move successful
      if (clear) return true;
    
      System.out.println ("on return and not successful, r = " + r + " c = " + c + " move= " + move);
      //try another move while there are still moves to make
    }while (!clear && move < 4);
    //if here that move was totally unsuccessful so unrecord it
    maze[r][c]=PATH;      
    return false;
  }
  
  public static void main(String [] args)
  {
    Maze theMaze = new Maze();
    
    System.out.println (theMaze);
    
    if (theMaze.wayOut(0,3)) System.out.println("I am Free!");
     else System.out.println("I am Trapped!");
  }
}
    
    
