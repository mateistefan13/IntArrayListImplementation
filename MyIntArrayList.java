package Ex1;
import java.util.Arrays; 

public class MyIntArrayList {
	
	private int[] array;
	private int size;
	
	// Constructorul 1
	MyIntArrayList() {
		array = new int[10];
	}
	
	// Constructorul 2
	MyIntArrayList(int nrElemente) {
		array = new int[nrElemente];
	}
	
	// Constructorul 3
	MyIntArrayList(MyIntArrayList ob) {
		this.size = ob.size;
		this.array = Arrays.copyOf(ob.array, ob.size);
	}
	
	// verify capacity
	private void verifyCapacity() {
		if (size == array.length) {
			array = Arrays.copyOf(array, array.length * 2);
		}
	}
	
	// 1. void add(int index, E element)
	public void add(int index, int element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		}
		verifyCapacity();
		for (int i = size - 1; i >= index; i--) {
			array[i + 1] = array[i];
		}
		array[index] = element;
		size++;
	}
	
	// 2. boolean add(E element)
	public boolean add(int element) {
		verifyCapacity();
		array[size] = element;
		size++;
		return true;
	}
	
	// 3. size()
	public int size() {
		return size;
	}
	
	// 4. boolean contains(Object o)
	public boolean contains(int numar) {
		for (int i = 0; i < size; i++) {
			if (array[i] == numar) {
				return true;
			}
		}
		return false;
	}
	
	// 5. E get(int index)
	public int get(int index) {
		return array[index];
	}
	
	// 6. int indexOf(Object o)
	public int indexOf(int numar) {
		for (int i = 0; i < size; i++) {
			if (array[i] == numar) {
				return i;
			}
		}
		return -1;
	}
	
	// 7. int lastIndexOf(Object o)
	public int lastIndexOf(int numar) {
		for (int i = size - 1; i >= 0; i--) {
			if (array[i] == numar) {
				return i;
			}
		}
		return -1;
	}
	
	// 8. boolean remove(Object o)
	public boolean remove(int element) {
		boolean exists = false;
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (array[i] == element) {
				index = i;
				exists = true;
				break;
			}
		}
		if (exists) {
			for (int i = index + 1; i < size ; i++) {
				array[i-1] = array[i];
			}
			//array[size-1] = 0;
			size--;
		}
		return exists;
	}
	
	// 9. removeElementAtIndex
	public int removeAtIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		}
		for (int i = index + 1; i < size; i++) {
			array[i-1] = array[i];
		}
		//array[size - 1] = 0;
		size--;
		return array[index];
	}
	
	// 10. void clear()
	public void voidClear() {
		size = 0;
	}
	
	// 11. int set(int index, int e)
	public int set(int index, int element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		}
		int wasHere = array[index];
		array[index] = element;
		return wasHere;
	}
	
	// 12. boolean addAll(Collection c)
	public boolean addAll(MyIntArrayList ob) {
		int countObjectArray = 0;
		int[] auxArray = Arrays.copyOf(array, this.size + ob.size);
		for (int i = this.size; i < auxArray.length; i++) {
			auxArray[i] = ob.array[countObjectArray];
			countObjectArray++;
		}
		this.array = Arrays.copyOf(auxArray, auxArray.length);
		this.size += ob.size;
		return true;
	}
	
	// 13. boolean addAll(int index, Collection c)
	public boolean addAllIndex(int index, MyIntArrayList ob) {
		int countObjectArray = 0;
		int countBetweenValues = index;
		int[] auxArray = new int[this.size + ob.size];
		for (int i = 0; i < auxArray.length; i++) {
			if (i < index) {
				auxArray[i] = this.array[i];
			} else if (i >= index && i < index + ob.size) {
				auxArray[i] = ob.array[countObjectArray];
				countObjectArray++;
			} else {
				auxArray[i] = this.array[countBetweenValues];
				countBetweenValues++;
			}
		}
		this.array = Arrays.copyOf(auxArray, auxArray.length);
		this.size += ob.size;
		return true;
	}
	
	// 14. toArray
	public int[] toArray() {
		int[] array = Arrays.copyOf(this.array, size);
		return array;
	}
	
	// 15.void ensureCapacity(int minCapacity)
	public void ensureCapacity(int minCapacity) {
		array = Arrays.copyOf(array, minCapacity);
	}
	
	// 15.trimToSize
	public void trimToSize() {
		array = Arrays.copyOf(array, size);
	}
	
	// Print Out
	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	

}


