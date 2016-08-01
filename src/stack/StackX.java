package stack;

public class StackX {
	private int maxSize;
	private char[] array;
	private int top;
	
	public StackX(int maxSize) {
		this.maxSize = maxSize;
		array = new char[maxSize];
		top = -1;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == maxSize -1);
	}
	
	public void push(char value){
		if (!isFull()) {
			array[++top] = value;
		}else {
			System.out.println("Can't push,stack is full");
		}	
	}
	
	public char pop(){
		if(!isEmpty()){
			return array[top--];
		}else {
			System.out.println("Can't pop,stack is empty");
			return '0';
		}
	}
	
	public char peek() {
		return array[top];
	}
	
}
