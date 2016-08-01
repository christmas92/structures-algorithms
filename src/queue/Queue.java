package queue;

public class Queue {
	private int maxSize;
	private long[] array;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue(int maxSize){
		this.maxSize = maxSize;
		array = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
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
			if (rear == maxSize - 1) {
				rear = -1;
			}
			array[++rear] = value;
			nItems++;
		}else {
			System.out.println("Can't insert, queue is full");
		}
	}
	
	public long revome() {
		if (!isEmpty()) {
			long result = array[front++];
			if (front == maxSize) {		
				front = 0;
			}
			nItems--;
			return result;
		}else {
			System.out.println("Can't remove, queue is empty");
			return -1;
		}
	}
	
	public long peek() {
		return array[front];
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.insert(10);
		queue.insert(20);
		queue.insert(30);
		queue.insert(40);		//(10,20,30,40,  )
		
		queue.revome();			//(  ,20,30,40,  )
		queue.revome();			//(  ,  ,30,40,  )
		queue.revome();			//(  ,  ,  ,40,  )
		
		queue.insert(50);		//(  ,  ,  ,40,50)
		queue.insert(60);		//(60,  ,  ,40,50)  wraps around
		queue.insert(70);		//(60,70,  ,40,50)
		queue.insert(80);		//(60,70,80,40,50)

		while (!queue.isEmpty()) {
			System.out.println(queue.revome());	
		}
	}
}
