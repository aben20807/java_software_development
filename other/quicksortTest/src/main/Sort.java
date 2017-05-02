package main;

public class Sort {

	public static void quicksort(int A[], int p, int r){
		
		if(p < r){
			int q = partition(A, p, r);
			quicksort(A, p, q - 1);
			quicksort(A, q + 1, r);
		}
	}
	
	private static int partition(int A[], int p, int r){
		
		int x = A[r];
		int i = p - 1;
		for(int j = p; j <= r - 1; j++){
			if(A[j] <= x){
				i++;
				int tmp = A[i];//exchange
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		int tmp = A[i+1];//exchange
		A[i+1] = A[r];
		A[r] = tmp;
		return i + 1;
	}
	
	public static void randomized_quicksort(int A[], int p, int r){
		
		if(p < r){
			int q = randomized_partition(A, p, r);
			randomized_quicksort(A, p, q - 1);
			randomized_quicksort(A, q + 1, r);
		}
	}
	
	private static int randomized_partition(int A[], int p, int r){
		
		int i = (int) (Math.random() * (r - p + 1)) + p;
		int tmp = A[i];//exchange
		A[i] = A[r];
		A[r] = tmp;
		return partition(A, p, r);
	}
}

