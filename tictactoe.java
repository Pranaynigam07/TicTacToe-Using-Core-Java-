/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PRANAY
 */
import java.util.*;
public class tictactoe {
    public static int[] findPosition(String ele,String[][] arr)
    {
        //function which returns the indexes of 2x2 Matrix if index not found it returns -1 ,-1
        int[] index=new int[2];
        index[0]=-1;//indicates the row index
        index[1]=-1;//indicates the column index
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(arr[i][j].equalsIgnoreCase(ele))
                {  
                    index[0]=i;
                    index[1]=j;
                }
            }
        }
        return(index);
    
    }
    public static String checkRow(String[][] arr,int row)
    {
        //Traversing through the rows and checking for "XXX or OOO" to decide the winner
        String result="";
        for(int i=0;i<3;i++)
        {
            result=result+arr[row][i];
        }
        return result;
    }
    public static String checkCol(String[][] arr,int col)
    {
        //Traversing through the columns and checking for "XXX or OOO" to decide the winner
        String result="";
        for(int i=0;i<3;i++)
        {
            result=result+arr[i][col];
        }
        return result;
    }
    public static String checkDia(String[][] arr)
    {
        //Traversing through the diagonals and checking for "XXX or OOO" to decide the winner
        String result="";
        for(int i=0;i<3;i++)
        {
            result=result+arr[i][i];
        }
        return result;
    }
    public static String checkOppDia(String[][] arr)
    {
        //Traversing through the opposite diagonals and checking for "XXX or OOO" to decide the winner
        String result="";
        int j=2;
        for(int i=0;i<3;i++)
        {
           result=result+arr[i][j];
           j--;
        }
        return result;
    }
    public static void printMat(String[][] arr)
    {
      //prints the 2x2 matrix
     for(int i=0;i<3;i++)
       {
           for(int j=0;j<3;j++)
           {
               System.out.print(arr[i][j]+"\t");
           }
           System.out.println();
       }
    }
    public static void main(String args[])
    {
       Scanner sc=new Scanner(System.in);
       int count=0;
       String[][] arr=new String[3][3];
       arr[0][0]="A";
       arr[0][1]="B";
       arr[0][2]="C";
       arr[1][0]="D";
       arr[1][1]="E";
       arr[1][2]="F";
       arr[2][0]="G";
       arr[2][1]="H";
       arr[2][2]="I";
       int x_count=0;
       int y_count=0;
       System.out.println("Enter the first player name");
       String first=sc.next();
       System.out.println("Enter the second player name");
       String second=sc.next();
       printMat(arr);
       int flag=0;
     for(int a=0;a<9;a++)
    {
        if(a%2==0)
        {
            //even chances for 1st player i.e., X
            System.out.println(first+" Chance");
            System.out.println("Enter x position");
            String st=sc.next();
            int[] index=findPosition(st,arr);
            if(index[0]!=-1 && index[1]!=-1)
            {
                //replace array index with  x
                arr[index[0]][index[1]]="X";
                if(x_count>=2)
                {
                     //after two entries checking for winner
                    String row=checkRow(arr,index[0]);
                    String col=checkCol(arr,index[1]);
                    String dia=checkDia(arr);
                    String dia2=checkOppDia(arr);
                    //System.out.println(row);
                    if(row.equals("XXX") ||col.equals("XXX")||dia.equals("XXX")||dia2.equals("XXX"))
                    {
                        System.out.println(first+" won!!!!!!!");
                        flag=1;
                        break;
                    }
                }
                x_count++;
            }
            else
            {
                //invalid index or letter exception handling
                System.out.println("Enter the alphabets as per the given matrix b/w [A-I] only");
            }
        }
        else
        {
            //odd chance for player 2 i.e.,O
            System.out.println(second+" Chance");
            System.out.println("Enter y position");
            String st=sc.next();
            int[] index=findPosition(st,arr);
            //System.out.println(index[0]);
            //System.out.println(index[1]);
            if(index[0]!=-1 && index[1]!=-1)
            {
                //replace array index with O
                arr[index[0]][index[1]]="O";
                if(y_count>=2)
                {
                    //after two entries checking for winner
                    String row=checkRow(arr,index[0]);
                    String col=checkCol(arr,index[1]);
                    String dia=checkDia(arr);
                    String dia2=checkOppDia(arr);
                    //System.out.println(row);
                    if(row.equals("OOO") ||col.equals("OOO")||dia.equals("OOO")||dia2.equals("OOO"))
                    {
                        System.out.println(second+"  won!!!!!!!!!");
                        flag=1;
                        break;
                    }
                }
                y_count++;
            }
            else
            {
                //invalid index or letter exception handling
                System.out.println("Enter the alphabets as per the given matrix b/w [A-I]");
            }
        }
       printMat(arr);
    }
     if(flag==0)
     {
         System.out.println("Game is Drawn!!!!!!");
     }
    }
   
    
}
