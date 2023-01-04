import java.util.Scanner;

public class PrimeBenchmark extends Thread{
	
		int i;
		static int count=0;
		public PrimeBenchmark (int i) {
			this.i =i;}
		public void run() {
			int j=i;
			int k = i+100;
			while(j<(k)){
				boolean prime=true;
				int l;
				for(l=2; l<j; l++) {
					if(j%l==0) {
						prime=false;
						break;
					
					}
					
				}
				if(prime==true) {
					//System.out.println(j);
					count++;
				
			}
				j++;
			}
		}
		public static int counter() {
			return count;
		}
		
		
		public static void main(String[] args) throws InterruptedException {
		Scanner sc= new Scanner(System.in);
		System.out.println("Check primes up to?");
		int n=sc.nextInt();
		//System.out.println("The prime numbers are ");
		int p=1;
		long startTime =  System.currentTimeMillis();
		while(p<n){
			boolean prime=true;
			int j;
			for(j=2; j<p; j++) {
				if(p%j==0) {
					prime=false;
					break;
				
				}
				
			}
			if(prime==true) {
				//System.out.println(p);
				}
			p++;
		}
		
		long endTime =  System.currentTimeMillis();
		
		long sTime =  System.currentTimeMillis();
		int i=1;
		while(i<n){
			PrimeBenchmark obj = new PrimeBenchmark(i);
			obj.start();
			if(i+100>n) {
				obj.join();
			}
			
			i=i+100;
				
			}
		long eTime =  System.currentTimeMillis();
		System.out.println("Single thread Took "+(endTime - startTime) + " ms"); 
		System.out.println("Multi thread Took "+(eTime - sTime) + " ms"); 

		}
}
