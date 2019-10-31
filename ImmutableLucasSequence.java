import java.math.BigInteger;

/** 
 * This class computes the Immutable Lucas sequence starting with two sequential 
 * numbers (x0,x1) from the sequence and two constant values (a, b) that
 * are equal to (1,0) for the Fibonacci sequence. The class uses BigIntegers 
 * to be able to store the large numbers that can result from a sequence. The 
 * immutable objects never change their state. 
 * 
 * @author 532033sh Sjoerd van der Heijden
 */

public class ImmutableLucasSequence {
	
	private final BigInteger aA;
	
	private final BigInteger bB;
	
	private final BigInteger xX0;
	
	private final BigInteger xX1;
	
	/**
	 * This construct stores the input for the Immutable Lucas sequence.
	 * The following values are required:
	 * @param a constant (=1 for Fibonacci sequence)
	 * @param b constant (=0 for Fibonacci sequence)
	 * @param x0 first value
	 * @param x1 second value
	 */
	
	public ImmutableLucasSequence(int a, int b, int x0, int x1) {
		
		aA = BigInteger.valueOf(a);
		
		bB = BigInteger.valueOf(b);
		
		xX0 = BigInteger.valueOf(x0);
		
		xX1 = BigInteger.valueOf(x1);
		
	}
	
	/**
	 * This construct stores the input for the Immutable Lucas sequence 
	 * with BigIntegers. It is needed to make the class immutable.
	 * The following values are required:
	 * 
	 * @param a constant (=1 for Fibonacci sequence)
	 * @param b constant (=0 for Fibonacci sequence)
	 * @param bigx0 first value
	 * @param bigx1 second value
	 */
	
	public ImmutableLucasSequence(BigInteger a, BigInteger b, BigInteger bigx0, BigInteger bigx1) {
		
		aA = a;
		
		bB = b;
		
		xX0 = bigx0;
		
		xX1 = bigx1;
	}
	
	/**
	 * This method computes the next value in the sequence.
	 * The instance variable and the new x1 instance variable is
	 * computed with x1new = a*x0+(a+b)*x1.
	 * 
	 * @return ImmutableLucasSequence with new state.
	 */
	
	public ImmutableLucasSequence getNext(){
		
		BigInteger mult1 = aA.multiply(xX0);
		
		BigInteger newX0 = xX1;
		
		BigInteger add = aA.add(bB);
		
		BigInteger mult2 = add.multiply(xX1);
		
		BigInteger newX1 = mult2.add(mult1);
		
		return new ImmutableLucasSequence(aA, bB, newX0,newX1);
	}
	
	/**
	 * This method computes the previous value in the sequence.
	 * The instance variable and the new x1 instance variable is
	 * computed with x0new = (x1-(a+b)x0)/a.
	 * 
	 * @return new Immutable Lucas Sequence with new state.
	 */
	
	public ImmutableLucasSequence getPrevious() {
		
		BigInteger add = aA.add(bB);
		
		BigInteger mult = add.multiply(xX0);
		
		BigInteger sub = xX1.subtract(mult);
		
		BigInteger newX1 = xX0;
		
		BigInteger newX0 = sub.divide(aA);
		
		return new ImmutableLucasSequence(aA, bB, newX0,newX1);	
	}
	
	/**
	 * @return BigInteger x1 from the current sequence
	 */
	
	public BigInteger getValue() {
		
		BigInteger value = xX1;
		
		return value;
	}
}
