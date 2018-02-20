package Numbers;

public class divide2integers {
/*
 * https://leetcode.com/problems/divide-two-integers/discuss/
 * Divide two integers without using multiplication, division and mod operator.
If it is overflow, return MAX_INT.
 */
	public static void main(String[] args) {
		System.out.println(divide(20,2));
	}
	
	public static int divide(int dividend, int divisor){
		boolean isNegative = false;
		if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
			isNegative = true;
		}
		
		long ldividend = Math.abs(dividend);
		long ldivisor = Math.abs(divisor);
		
		if(ldividend == 0 || ldividend < ldivisor) return 0;
		if(ldivisor == 0) return Integer.MAX_VALUE;
		
		long ans = lDivide(ldividend,ldivisor);
		
		if(ans > Integer.MAX_VALUE){
			if(!isNegative)
				return Integer.MAX_VALUE;
			else
				return Integer.MIN_VALUE;
		}else{
			if(!isNegative) return (int) ans;
			else
				return (int) (-1 * ans);
		}
	}
	
	public static long lDivide(long ldividend, long ldivisor){
		if(ldividend < ldivisor) return 0;
		
		long sum = ldivisor;
		long multiple = 1;
		
		while((sum + sum) <= ldividend){
			sum += sum;
			multiple += multiple;
		}
		
		return multiple + lDivide(ldividend - sum, ldivisor);
	}
	
	//other method
	// if you want remainder also
	public static long lDivides(long ldividend, long ldivisor){
		if(ldividend < ldivisor) return 0;
		
		long sum = 0;
		long multiple = 0;

		while(sum < ldividend){
			sum += ldivisor;
			multiple++;
		}
		long  remainder = 0;
		if(sum  == ldividend){
			remainder = 0;
		}else if (sum > ldividend){
			multiple--;
			remainder = sum - ldividend;
		}
		System.out.println("remainder : " + remainder);
		return multiple;
	}
}
