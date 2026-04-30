package service;

import datastr.MyLinkedHeap;
import model.Patient;

public class MainService {

	public static void main(String[] args) {
		System.out.println("----------DARBĪBAS AR INT------------");
		MyLinkedHeap<Integer> integersInHeap = new MyLinkedHeap<Integer>();
		try
		{
			integersInHeap.enqueue(40);//P: 40
			integersInHeap.enqueue(50);//P: 50(LC: 40)
			integersInHeap.enqueue(35);//P: 50(LC: 40, RC:35)
			integersInHeap.enqueue(99);//P:99 (LC:50, RC:35), P:50 (LC:40)
			integersInHeap.enqueue(55);//P:99 (LC:55, RC:35), P:55 (LC:40, RC:50)
			integersInHeap.enqueue(2);//P:99 (LC:55, RC:35), P:55 (LC:40, RC:50); ):35 (LC:2)
			integersInHeap.print();
			
			System.out.println("Max vērtība " + integersInHeap.dequeue());
			integersInHeap.print();
			//TODO notestēt vēlreiz, bet tad, kad lastNode ir uztaisīts
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("----------DARBĪBAS AR PATIENT------------");
		
		MyLinkedHeap<Patient> patients = new MyLinkedHeap<Patient>();
		try
		{
			patients.enqueue(new Patient("Jānis", "Bērziņs", 1));//P: Janis
			patients.enqueue(new Patient("Līga", "Jaukā", 3)); //P: Līga (LC: Jānis)
			patients.enqueue(new Patient("Baiba", "Kalniņa", 2));//P: Līga (LC: Jānis, RC: Baiba)
			patients.enqueue(new Patient("Juris", "Nejaukais", 5));//P: Juris (LC: Līga, RC: Baiba), P:Līga (LC:Jānis)
			patients.print();
			
			System.out.println("Max pacients: " + patients.dequeue());//Juris
			patients.print();//P: Līga (LC: Jānis, RC: Baiba)
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
