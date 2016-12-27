//Knights.java
//a CS 111 solution to the knights tour using the general algorithm

import java.util.Scanner;

public class Knights
{
    private final int BOARDSIZE=8;
    private int [] [] board;

    public Knights()
    {
      board = new int [BOARDSIZE][BOARDSIZE];
      for ( int i=0; i < BOARDSIZE;i++)
        for (int j=0;j<BOARDSIZE;j++)
           board[i][j] = -1;

    }
    
    private boolean onBoard(int r, int c)
    {
      return (r>=0 && r < BOARDSIZE && c >=0 && c < BOARDSIZE);
    }

    private boolean available(int r, int c)
    {
      return (board[r][c]== -1);
    }

    private boolean ktour (int r, int c, int moveNum)
    {
      int i, nr=0, nc=0;

      System.out.println("movenum=" + moveNum);
      //is spot acceptable
      if (!onBoard(r,c) || !available(r,c)) return false;

      //record move
      board[r][c]=moveNum;
 
      //done the whole board?
      if (moveNum==BOARDSIZE*BOARDSIZE) return true;

      //pick next move
      for (i=0;i<8;i++)
      {switch (i)
	      { case 0: nr = r-2; nc=c+1; break;
          case 1: nr = r+1; nc = c-2; break;
          case 2: nr = r +2; nc =c+1; break;
          case 3: nr = r+2; nc = c-1; break;
          case 4: nr = r-1; nc = c-2; break;
          case 5: nr = r-1; nc = c+2; break;
          case 6: nr = r-2; nc=c-1;break;
          case 7: nr= r+1; nc= c+2; break;
      }
      if (ktour (nr,nc,moveNum+1)) return true;
      }

      //all eight possible moves tried no success
      //unrecord move and backtrack
      board[r][c] = -1;
      return false;
    }

    public String toString()
    {
      String result = "";
      
       for (int i=0; i < BOARDSIZE;i++)
       {for (int j=0;j<BOARDSIZE;j++)
         result += (board[i][j]+ "  ");
        result +='\n';
       }
       return result;
    }
      
    public static void main(String [] args)
    {
      int startRow, startCol;
      Scanner sc = new Scanner(System.in);

      Knights kBoard = new Knights(); 
      //enter start point
      System.out.print("enter starting row: ");
      startRow = sc.nextInt();
      System.out.print("enter starting Col: ");
      startCol = sc.nextInt();
 
      //start the tour
      if (kBoard.ktour (startRow, startCol,1))
      { System.out.println ("tour successful contents are: ");
        System.out.print(kBoard);
      }
      else System.out.println ("Tour not possible from (" + startRow + "," + startCol + ")");
      
      sc.close();
    }
}
