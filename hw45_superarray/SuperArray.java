// Rohan Ahammed
// APCS1 pd08
// HW45 -- In America, the Driver Sits on the Left
// 2017-12-01

/***************************
 * class SuperArray version 4.0
 * Wrapper class for array. Facilitates resizing,
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 *
 * ...and now SuperArray complies with the specifications of the
 * List interface. (List.java must be in same dir as this file)
 ***************************/

public class SuperArray implements List
{
  private Object [] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new Object[10];
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
      foo += _data[i] + ",";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    return foo;
  }


  //double capacity of SuperArray
  private void expand()
  {
    Object[] temp = new Object[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
      temp[i] = _data[i];
    _data = temp;
  }


  //accessor -- return value at specified index
  public Object get( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException("\n Index out of range. Make sure index is positive and within the indices of SuperArray");
    
	return _data[index];
  }


  //mutator -- set value at index to Object o,
  //           return old value at index
  public Object set( int index, Object o )
  {
      if ( index < 0 || index >= size() )
	  throw new IndexOutOfBoundsException("\n Index out of range. Make sure index is positive and within the indices of SuperArray");
    Object temp = _data[index];
    _data[index] = o;
    return temp;
  }


  //adds an item after the last item
  public boolean add( Object x )
  {
    add( _size, x );
    return true;
  }


  //inserts an item at index
  public void add( int index, Object o )
  {
    //first expand if necessary
    if ( _size >= _data.length )
      expand();
    for( int i = _size; i > index; i-- ) {
      _data[i] = _data[i-1]; //each slot gets value of left neighbor
    }
    _data[index] = o;
    _size++;
    if ( index < 0 || index >= size() )
	throw new IndexOutOfBoundsException("\n Index out of range. Make sure index is positive and within the indices of SuperArray");
    
  }


  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  //returns removed value
  public Object remove( int index )
  {
      if ( index < 0 || index >= size() )
	  throw new IndexOutOfBoundsException("\n Index out of range. Make sure index is positive and within the indices of SuperArray");
  
    Object o = _data[index];
    for( int i = index; i < _size - 1; i++ ) {
      _data[i] = _data[i+1];
    }
    _size--;
    return o;
  }


  //return number of meaningful items in _data
  public int size()
  {
    return _size;
  }



  //main method for testing
  public static void main( String[] args )
  {
    List mayfield = new SuperArray();
    System.out.println("Printing empty SuperArray mayfield...");
    System.out.println(mayfield);

    mayfield.add("cat");
    mayfield.add("flat");
    mayfield.add("sat");
    mayfield.add("rat");
    mayfield.add("twat");

    System.out.println("Printing populated SuperArray mayfield...");
    System.out.println(mayfield);

    mayfield.remove(3);
    System.out.println("Printing SuperArray mayfield post-remove...");
    System.out.println(mayfield);
    mayfield.remove(3);
    System.out.println("Printing SuperArray mayfield post-remove...");
    System.out.println(mayfield);

    mayfield.add(3,"bat");
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    mayfield.add(2,"twit");
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    mayfield.add(1,"sit");
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);

    /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class


