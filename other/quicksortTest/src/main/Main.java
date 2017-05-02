package main;

public class Main {

	public static void main(String[] args) {

		int a = 0;				//count win
		int b = 0;
		double asum = 0;		//count milliseconds
		double bsum = 0;
		int alltimes = 10000;	//TODO can change
		int num = 10000;		//TODO can change
		
		for (int times = 0; times < alltimes; times++) {
			int[] A = new int[num];
			int[] B = new int[num];
			for (int i = 0; i < num; i++) {
				A[i] = (int) (Math.random() * (num + 1));
				B[i] = A[i];
				/*worst case*///num cannot be too big
//				A[i] = i;
//				B[i] = i;
				// System.out.println(A[i]);
			}
			/*random array to sort*/
//			for(int i = 0; i < A.length; i++){
//				System.out.print(A[i] + " ");
//			}
//			System.out.println("");
//			for(int i = 0; i < B.length; i++){
//				System.out.print(B[i] + " ");
//			}
//			System.out.println("");

			long startTimeA = System.nanoTime();
			Sort.quicksort(A, 0, A.length - 1);
			long endTimeA = System.nanoTime();
			double durationA = (double)(endTimeA - startTimeA) / 1000000;// get milliseconds.
			asum += durationA;
			//System.out.println(durationA);

			long startTimeB = System.nanoTime();
			Sort.randomized_quicksort(B, 0, B.length - 1);
			long endTimeB = System.nanoTime();
			double durationB = (double)(endTimeB - startTimeB) / 1000000;// get milliseconds.
			bsum += durationB;
			//System.out.println(durationB);
			
			if(durationA < durationB){
				//System.out.println("A");
				a++;
			}
			else if(durationA > durationB){
				//System.out.println("B");
				b++;
			}
			else{
				//System.out.println("equal");
			}
			
			/*sort answer*/
//			for(int i = 0; i < A.length; i++){
//				System.out.print(A[i] + " ");
//			}
//			System.out.println("");
//			for(int i = 0; i < B.length; i++){
//				System.out.print(B[i] + " ");
//			}
//			System.out.println("");
		}
		System.out.println(alltimes + " comparisons(each comparison sort " + num + " integers):");
		System.out.println("nonrandom: "+a+"\t(average = " + asum / alltimes + " ms)");
		System.out.println("randomize: "+b+"\t(average = " + bsum / alltimes + " ms)");
	}

}
