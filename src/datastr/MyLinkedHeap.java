package datastr;

public class MyLinkedHeap<Ttype> {
	//1.mainigie
	private MyNode<Ttype> rootNode = null;
	private MyNode<Ttype> lastNode = null;
	private int howManyElements = 0;
	
	//2.getter, priekš blokiem nav nepieciešams
	public int getHowManyElements()
	{
		return howManyElements;
	}
	//3.setter - nav nepieciesams nevienam mainigajam
	
	//4.konstruktors/i - bezargumenta konstruktors būs no Object klases
	
	public boolean isEmpty() {
		return (howManyElements==0);
	}
	
	public boolean isFull() {
		try {
			new MyNode<Character>('A');
			return false;
		}
		catch (OutOfMemoryError e) {
			return true;
		}
	}
	
}
