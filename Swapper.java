//Rohan Ahammed
//APCS1 pd08
//HW38 -- Put It Together
//2017-11-21
//This program works with a default of 4 x 3 2D Array of Strings. You will be asked to enter in the row # and column # of two locations in the 2D Array, in which you are switching the Strings in those locations. When entering row or column #, start from 0.
import cs1.Keyboard;
public class Swapper{
    public static void print( String[][] a )//from TwoDimArray
    {
	for (String[] b: a){
	    String prntStr = "{";
	    for (String c: b){
		prntStr += c + ",";
	    }
	    System.out.println( prntStr.substring(0, prntStr.length() -1) + "}");// deals with last comma
	}
    }
    public static void swap(String[][] array){
	System.out.print("Enter row # of first location: ");
	int location1Row = Keyboard.readInt();
	System.out.print("Enter column # of first location: ");
	int location1Column = Keyboard.readInt();
	System.out.print("Enter row # of second location: ");
	int location2Row = Keyboard.readInt();
	System.out.print("Enter column # of second location: ");
	int location2Column = Keyboard.readInt();
	String temp = array[location1Row][location1Column];
	array[location1Row][location1Column] = array[location2Row][location2Column];
	array[location2Row][location2Column] = temp;
	//this is the simplest way to achieve this functionality. maybe using Keyboard.readString() can offer something that is more concise(?)
    }
    
	public static void main(String[] args){
	
	    String [][] array = { {"Cat", "Hat", "Sat"},
				  {"Chit", "Chat", "Flat"},
				  {"Mit","Met","Mat"},
				    {"Chow", "Pow", "Sow"}};
	    print(array);//prints the array
	    swap(array);// asks the user and properly swaps
	    print(array);//prints the array with the swap 
    }
	
}//end of class Swappers
