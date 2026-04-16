package datastr;

public class MyLinkedHeap<Ttype> {
	//1.mainigie
	private MyNode<Ttype> rootNode = null;
	private MyNode<Ttype> lastNode = null;
	private int howManyElements = 0;
	private int level = 0;
	
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
	
	
	public void enqueue(Ttype element) throws Exception {
		if(isFull()) {
			throw new Exception(
					"Kaudze ir pilna un nav iespējams pievienot elementu");
		}
		
		if(element == null) {
			throw new Exception("Elements nevar būt null");
		}
		
		if(isEmpty()) {//ja tiek pievienots pirmais elements
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			rootNode = newNode;
			lastNode = newNode;
			howManyElements++;
		}
		else//ja tiek pievienots kārtējais ( ne pirmais) elements
		{
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			//ja būs saknes elementam kreisais bērns
			if(howManyElements == 1) {
				rootNode.setLeftChNode(newNode);
				newNode.setParentNode(rootNode);
				lastNode = newNode;
				howManyElements++;
				level++;
				//TODO reheapUp funkcijas izsaukums
				return;
			}
			
			
			
			
			
			//pēdējam blokam nav neviens no bērniem
			if(lastNode.getLeftChNode()==null && lastNode.getRightChNode()==null) {
				lastNode.setLeftChNode(newNode);
				newNode.setParentNode(lastNode);
				lastNode = newNode;
				howManyElements++;
				//TODO izsaukt reheapUp funkciju
				return;
			}
			
			//kad pedjeam blokam nav blakus labais bloks
			if(lastNode.getParentNode()!=null 
					&& lastNode.getParentNode().getRightChNode()==null) {
				
				MyNode<Ttype> parentNodeTemp = lastNode.getParentNode();
				parentNodeTemp.setRightChNode(newNode);
				newNode.setParentNode(parentNodeTemp);
				
				lastNode = newNode;
				howManyElements++;
				//TODO izsaukt reheapUp funkciju
				return;
				
			}
			
			//2^0 = 1 elements 0.līmenī
			//2^1 = 2 elementi 1.līmenī
			//2^2 = 4 elementi 2.līmenī
			int sum = 0;
			//es noskaidroju, cik ir jābūt blokiem līdz šim līmenim ieskaitot
			for(int i = 0; i <= level; i++) {
				sum = (int) (sum + Math.pow(2, i));
			}
			//lastNode ir kā pēdejais bloks sava līmenī
			if(sum == howManyElements) {
				MyNode<Ttype> currentNode = rootNode;
				
				//ja blokam ir kreisais berns, tad jelec uz to
				while(currentNode.getLeftChNode()!=null) {
					currentNode = currentNode.getLeftChNode();
				}
				
				lastNode = currentNode;
				
				lastNode.setLeftChNode(newNode);
				newNode.setParentNode(lastNode);
				
				lastNode = newNode;
				howManyElements++;
				level++;
				//TODO izsaucam reheapUp funciju
				return;
				
			}
			//TODO izveidot pedējo scenāriju, kurs no labā bērna spej pārlekt
			//uz blakus apkaškoka kreiso bērnu
			
		}
		
	}
	
}
