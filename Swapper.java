//Rohan Ahammed
//APCS1 pd08
//HW40 -- Make It Better
//2017-11-24
//This program works with a default of 4 x 3 2D Array of Strings. You will be asked to enter in the row # and column # of two locations in the 2D Array, in which you are switching the Strings in those locations. When entering row or column #, start from 0.
/*Improvements made in v2:
- Changed the representation of the 2D array to not be in brackets and separated each element with tabs
- Included index numbers for users to have an easier time inputing row and column #'s
- Included Exception handling to handle incorrect index #s. Now asks the user to try again, and prints the array after to notify the user on what index #s are valid. 
*/
import cs1.Keyboard;
public class Swapper{
    public static void print( String[][] a )//from TwoDimArray
    {
	int counter = 0;
	System.out.println("\t0\t1\t2\t");
	for (String[] b: a){
	    String prntStr = "";
	    System.out.print(counter + "\t");
	    counter += 1;
	    for (String c: b){
		prntStr += c + "\t";
	    }
	    System.out.println(prntStr);// deals with last comma
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
	try{
	    String temp = array[location1Row][location1Column];
	    array[location1Row][location1Column] = array[location2Row][location2Column];
	    array[location2Row][location2Column] = temp;
	    System.out.println("You switched " +  array[location1Row][location1Column] + " with " + temp);//notifies the user of what change they made
	}
	catch (Exception e){//if error produced because of invalid index, asks user to run again with proper index #s
	    System.out.println("Invalid index numbers. Try running again with proper index numbers");
	}
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
