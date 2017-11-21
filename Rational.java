//Rohan Ahammed
//APCS pd08
//HW37 -- Be More Rational
//2017-11-20
public class Rational{
    //instance variables
    private int numerator;
    private int denominator;
    //constructors
    public Rational(){
	numerator = 0;
	denominator = 1;
    }
    public Rational(int num, int denom){
	this();
	if (denom != 0){
	    numerator = num;
	    denominator = denom;
	}
	else{
	    System.out.println("Invalid #. Default chosen");
	}
    }
    //phase2
    public static int gcd(int a, int b){//from Stats.java, uses Euclid's algo
	if (a>b){
	    return gcd(b,a);
	}
	    
	if (b % a == 0){
	    return a;
	}
	else if (a == 0){
	    return b;
	}
	return gcd(b-a,a);
    }    
    public int gcd (){
	return gcd(numerator, denominator);//use the previously defined static function to find the gcd of the numerator and denominator
    }
    
    public void add (Rational num){
	numerator = (this.numerator *  num.denominator) +
	    (num.numerator * this.denominator);// the simplest way to use the common denominator
	denominator = (this.denominator * num.denominator);
    }
    public void subtract (Rational num){
	numerator = (this.numerator *  num.denominator) -
	    (num.numerator * this.denominator);//like add, but instead subtract the value
	denominator = (this.denominator * num.denominator);//denom stays the same b/c this method is the quickest/simplest way to find a common denominator
    }
    public void reduce (){
	int gcd = gcd();//numerator and denominator change during this method, so the gcd needs to be intiialized in a variable before the num/denom is changed
	numerator /= gcd;
	denominator /=  gcd;
    }
    public int compareTo(Rational num){
	int compareThisNum = this.numerator * num.denominator;
	int compareParamNum = num.numerator * this.denominator;
	    
	if (compareThisNum == compareParamNum){//could have used floatValue, may not be the most precise
	    return 0;
	}
	else if (compareThisNum < compareParamNum){
	    return -1;
	}
	else{
	    return 1;
	}
    }
    //methods
    public String toString(){
	return "" + numerator + " / "+ denominator;
    }
    public double floatValue(){
	return (double) numerator / denominator;
    }
    public void multiply (Rational num){
	numerator = this.numerator *  num.numerator;
	denominator = this.denominator * num.denominator;
    }
    public void divide (Rational num){
	numerator = this.numerator * num.denominator;// dividing two fractions is the same as multiplying one fraction with the reciprocal of the second
	denominator = this.denominator * num.numerator;
    }
    public static void main(String[] args){
	Rational r = new Rational(2,3); //Stores the rational number 2/3
	Rational s = new Rational(1,2); //Stores the rational number 1/2
	Rational t = new Rational(4,18); //Stores the rational number 4/18
	r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2
	System.out.println(r);
	t.reduce(); //Changes t to 2/9
	System.out.println(t);
	System.out.println(r.compareTo(t));//1
	System.out.println(t.compareTo(r));//-1
	r.subtract(s);//Adds r to s, changes r to 8/12.  s remains 1/2
	System.out.println(r);
	System.out.println(r.gcd());//4
	r.reduce();// changes r to 2/3
	System.out.println(r);
    }
    
}// end of class Rational

	
