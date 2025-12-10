package question1;
public class Heap {
	private int heapSize;
	
	public Heap(int size) {
		heapSize = size;
	}
	
	public void heapify(int arr[]) {
		
		for(int i = heapSize / 2 ; i >= 1 ; i--) {
		
			int pi = i;
			int ci = pi * 2;	
			while(ci <= heapSize) {
				
				if((ci + 1) <= heapSize && arr[ci + 1] > arr[ci])
					ci = ci + 1;
				
				if(arr[pi] > arr[ci])
					break;
				
				int temp = arr[ci];
				arr[ci] = arr[pi];
				arr[pi] = temp;
				
				pi = ci;
				ci = pi * 2;
			}
		}
	}
	
	public void deleteHeap(int arr[]) {
		
		for(int i = 1 ; i < arr.length ; i++) {
			
			int max = arr[1];
			arr[1] = arr[heapSize];
			arr[heapSize] = max;
			
			heapSize--;
			
			int pi = 1;
			int ci = pi * 2;	
			while(ci <= heapSize) {
				
				if((ci + 1) <= heapSize && arr[ci + 1] > arr[ci])
					ci = ci + 1;
				
				if(arr[pi] > arr[ci])
					break;
				
				int temp = arr[ci];
				arr[ci] = arr[pi];
				arr[pi] = temp;
				
				pi = ci;
				ci = pi * 2;
			}
		}
	}
	
	public void heapSort(int arr[]) {
		
		heapify(arr);
		
		deleteHeap(arr);
	}

}





