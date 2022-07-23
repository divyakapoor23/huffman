package Assign2;

public class ArrayHeap<E extends Comparable<E>> {
	  
	private E[] array;
	private int size;
	
	public ArrayHeap() {
		this.size = 0;
		array = (E[]) new Comparable[1];
	}
	
	public boolean isEmpty() {    
		return size == 0;
	}  
	
	public int getSize() {
		return size;
	}
	
	public void addElement(E element) {
		if (this.size == this.array.length) {
			expand();
		}
		this.array[size] = element;
		heapifyAdd(element);
		this.size++;
	}
	
	public E removeNext() {
		if (isEmpty()) {
			throw new IllegalStateException("No more element to remove");
		}
		E rootElement = this.array[0];
		this.array[0] = null;
		this.size--;
		heapifyRemove();
		return rootElement;
	}
	
	public void printHeap() {
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + ", ");    
		}
	}
	
	private void heapifyAdd(E element) {
		int currentPosition = size, parentPosition = (currentPosition - 1) / 2;
		while(parentPosition >= 0 && this.array[parentPosition].compareTo(array[currentPosition]) > 0) {
			swap(currentPosition, parentPosition);
			currentPosition = parentPosition;
			parentPosition = (currentPosition - 1) / 2;
		}
	}
	
	private void heapifyRemove() {
		swap(0, this.size);
		int currentPosition = 0, left = currentPosition * 2 + 1, right = currentPosition * 2 + 2;
		while (currentPosition < this.size && 
		((left < size && array[currentPosition].compareTo(array[left]) >= 0) || (right < size && array[currentPosition].compareTo(array[right]) >= 0))) {
		if (right >= this.size) {
			swap(currentPosition, left);
			currentPosition = left;
			} else {
				if (array[left].compareTo(array[right]) <= 0) {
				swap(currentPosition, left);
				currentPosition = left;
				} else {
					swap(currentPosition, right);
					currentPosition = right;
						}
					}      
				left = currentPosition * 2 + 1;
				right = currentPosition * 2 + 2;
			}
		}
	
	private void swap(int currentPosition, int parentPosition) {
		E tempElement = array[currentPosition];
		array[currentPosition] = array[parentPosition];
		array[parentPosition] = tempElement;
	}
	
	private void expand() {
		E[] newArray = (E[]) new Comparable[this.array.length * 2];
		System.arraycopy(this.array, 0, newArray, 0, this.size);
		this.array = newArray;
		newArray = null;
	}
}

