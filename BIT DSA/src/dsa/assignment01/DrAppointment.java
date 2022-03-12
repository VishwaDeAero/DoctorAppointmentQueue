package dsa.assignment01;


public class DrAppointment {
	
	private Node front, rear; 
	private int queueLength; // queue size 
	
	//linked list node
	 private class Node { 
		 String name;
		 int queNumber;
		 Node next;
		 
		 public void display(){
			  System.out.println("Apt.Number : "+queNumber+"    Patient Name : " + name);
			  System.out.println("----------------------------------------------------");
		  }
	 }
	 
	//initially front & rear are null; size=0; queue is empty
	 public DrAppointment()
	 {
		 front = null;
		 rear = null;
		 queueLength = 0;
		 
	 }
	 
	//check if the queue is empty
	 public boolean isEmpty()
	 {
		 return (queueLength == 0);
	 }
	 
	//Get New Appointment
	 public void newAppointment(String name)
	 {
		 int queNumber;
		 Node oldRear = rear;
		 rear = new Node();
		 rear.name = name;
		 rear.next = null;
		 
		 if (isEmpty()) 
		 {
			 front = rear;
			 queNumber = 1;
		 }
		 else  {
			 oldRear.next = rear;
			 queNumber = oldRear.queNumber+1;
		 }
		 
		 rear.queNumber = queNumber;
		 
		 queueLength++;
		 System.out.println(name+ " added to the appointment list");
		 System.out.println("your number is " + rear.queNumber+ "./n");
	 }
	 
	 //Call Next Patient and Remove from Queue
	 public void callAppointment()
	 {
		 if (!isEmpty()) {
			 System.out.println("Please Come Patient");
			 front.display();

			 front = front.next;

			 queueLength--;
		 }
		 else {
			 System.out.println("No Patients in Queue");
			 rear = null;
		 }		 
	 }
	
	 
	 //print next patient
	 public void showNextPatient() {
		 if (!isEmpty()) 
		 {
			 System.out.println("Next Patient is");
		     front.display();
		 }else {
			 System.out.println("No Patients in Queue");
		 }
	 }
	 
	//print last patient
	public void showLastPatient() {
		 if (!isEmpty()) 
		 {
			 System.out.println("Last Patient is");
			 rear.display();
		 }else {
			 System.out.println("No Patients in Queue");
		 }
	}
	
	//print patients count
	public void showPatientCount() {
		System.out.println("Number of Patients Listed in Queue : "+queueLength);
	}
	
	//print patients list
	public void showPatientList() {
		if (!isEmpty()) 
		 {
			System.out.println("----------------------------------------------------");
			System.out.println("Patients List");
			System.out.println("----------------------------------------------------");
			Node current = front;
			while(current != null){
				 current.display();
				 current = current.next;
			}
		 }else {
			 System.out.println("No Patients in Queue");
		 }
	}
}

class Main{
	public static void main(String a[]){
	  
		DrAppointment quelist = new DrAppointment();
		
//		Add new patient to queue
		quelist.newAppointment("Vishwa Nipun Srimal");
		quelist.newAppointment("Hashini Bhagya");
		quelist.newAppointment("Kavindu Tharaka");
		quelist.newAppointment("Samali Rathnayake");
		quelist.newAppointment("Kushan Srimal");
//		Show next patient to be observed		
		quelist.showNextPatient();
//		Show last patient in queue
		quelist.showLastPatient();
//		Show remaining patients count
		quelist.showPatientCount();
//		Call the patient to get observed by the doctor
		quelist.callAppointment();
//		Show remaining patients list
		quelist.showPatientList();
	}
}
