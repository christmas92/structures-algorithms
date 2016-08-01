package queue;

public class PriorityQueue{
	private int maxSize;
	private long[] array;
	private int nItems;
	
	public PriorityQueue(int maxSize) {
		this.maxSize = maxSize;
		this.nItems = 0;
		this.array = new long[maxSize];
	}
	
	public int size() {
		return nItems;
	}
	
	public boolean isFull() {
		return (maxSize == nItems);
	}
	
	public boolean isEmpty(){
		return (nItems == 0);
	}
	
	public void insert(long value){
		if(!isFull()){
			if(isEmpty()){
				array[maxSize-1] = value;
				nItems++;
			}else {
				int i = maxSize - nItems;
				while (i < maxSize && array[i] < value) {
					array[i-1] = array[i];
					i++;
				}
				array[--i] = value;
				nItems++;
			}
		}else {
			System.out.println("Can't insert, queue is full");
		}
	}
	
	public long remove() {
		if(!isEmpty()){
			long result = array[maxSize - nItems];
			nItems--;
			return result;
		}else {
			System.out.println("Can't remove, queue is empty");
			return -1;
		}
	}
	
	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue(5);
		queue.insert(10);
		queue.insert(30);
		queue.insert(50);
		queue.insert(60);
		queue.insert(20);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.remove());	
		}
	}
}
