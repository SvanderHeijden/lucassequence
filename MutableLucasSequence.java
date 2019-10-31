import java.math.BigInteger;

/** 
 * This class computes the Mutable Lucas sequence starting with two sequential 
 * numbers (x0,x1) from the sequence and two constant values (a, b) that
 * are equal to (1,0) for the Fibonacci sequence. The class uses BigIntegers 
 * to be able to store the large numbers that can result from a sequence. 
 * @author 532033sh Sjoerd van der Heijden
 */

public class MutableLucasSequence {
	
	private BigInteger aA;
	
	private BigInteger bB;
	
	private BigInteger xX0;
	
	private BigInteger xX1;
	
	/**
	 * This construct stores the input for the Lucas sequence.
	 * The following values are required:
	 * 
	 * @param a constant (=1 for Fibonacci sequence)
	 * @param b constant (=0 for Fibonacci sequence)
	 * @param x0 first value
	 * @param x1 second value
	 */
	
	public MutableLucasSequence(int a, int b, int x0, int x1) {
		aA = BigInteger.valueOf(a);
		
		bB = BigInteger.valueOf(b);
		
		xX0 = BigInteger.valueOf(x0);
		
		xX1 = BigInteger.valueOf(x1);
	}
	
	/**
	 * This method computes the next value in the sequence.
	 * The x0 instance variable is overwritten by the x1
	 * instance variable and the new x1 instance variable is
	 * computed with x1new = a*x0+(a+b)*x1.
	 * Note: in the x1new computation, the original x0 instance
	 * variable is used.
	 * 
	 * @return X1 to keep the code running
	 */
	
	public BigInteger nextValue(){
		
		BigInteger mult1 = aA.multiply(xX0);
		
		xX0 = xX1;
		
		BigInteger add = aA.add(bB);
		
		BigInteger mult2 = add.multiply(xX1);
		
		xX1 = mult2.add(mult1);
		
		return xX1;
	}
	
	/**
	 * This method computes the previous value in the sequence. 
	 * The x1 instance variable is overwritten by the x0 
	 * instance variable and the new x0 instance variable is
	 * computed with x0new = (x1-(a+b)x0)/a.
	 * Note: in the x0new computation, the original x1 instance 
	 * variable is used. 
	 * 
	 * @return X1 to keep the program running
	 */
	
	public BigInteger previousValue() {
		
		BigInteger add = aA.add(bB);
		
		BigInteger mult = add.multiply(xX0);
		
		BigInteger sub = xX1.subtract(mult);
		
		xX1 = xX0;
		
		xX0 = sub.divide(aA);
		
		return xX1;		
	}
}
