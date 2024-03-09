import java.util.*;
class Patient{
	private int id,amount;
	private String pname,dname,contact,medicalhistory;
	Patient(int id,int amount,String pname,String dname,String contact,String medicalhistory){
		this.id = id;
		this.amount = amount;
		this.pname = pname;
		this.dname = dname;
		this.contact = contact;
		this.medicalhistory = medicalhistory;
		this.contact = contact;
	}
	int getId(){
		return id;
	}
	int getAmount(){
		return amount;
	}
	String getPName(){
		return pname;
	}
	String getDName(){
		return dname;
	}
	String getContact(){
		return contact;
	}
	String getMedicalHistory(){
		return medicalhistory;
	}
}

class Doctor
{
	private int id;
	private String dname,specialization;
	Doctor(int id,String dname,String specialization){
		this.id = id;
		this.dname = dname;
		this.specialization = specialization ;
	}
	int getId(){
		return id;
	}
	String getDName(){
		return dname;
	}
	String getSpecialization(){
		return specialization;
	}

}

class Appointment{
	private int appointmentid,amount;
	private String dname,pname,date,time,am_pm;
	Appointment(int appointmentid,int amount,String dname,String pname,String date,String time,String am_pm){
		this.appointmentid = appointmentid;
		this.amount= amount;
		this.dname = dname;
		this.pname = pname;
		this.date = date;
		this.time = time;
		this.am_pm = am_pm;
	}
	int getAppointmentId(){
		return appointmentid;
	}
	int getAmount(){
		return amount;
	}
	String getDName(){
		return dname;
	}
	String getPName(){
		return pname;
	}
	String getDate(){
		return date;
	}
	String getTime(){
		return time;
	}
	String getAm_Pm(){
		return am_pm;
	}
}

class HospitalChild implements Hospital
{
	Scanner sc = new Scanner(System.in);
	List<Patient> p = new ArrayList<>();
	List<Doctor> d = new ArrayList<>();
	List<Appointment> a = new ArrayList<>();

	HospitalChild(){
		d.add(new Doctor(01,"John","Cardiologist"));
		d.add(new Doctor(02,"Vishwas","Dermatologist"));
		d.add(new Doctor(03,"Suhas","Diabetologist"));
		d.add(new Doctor(04,"Raj","Gynecologist"));
		d.add(new Doctor(05,"Sachin","Neurologist"));
		d.add(new Doctor(06,"Shilpa","Dietitian"));
		d.add(new Doctor(07,"Siddhart","Physiohtherapist"));
	}

	public void choice(){
		System.out.println("Enter Your Choice");
		System.out.println("1. Register patient");
		System.out.println("2. Schedual Appointment");
		System.out.println("3. Display Patient List");
		System.out.println("4. Display Doctors List");
		System.out.println("5. Display Scheduled Appointment List");
		System.out.println("6. Generate bill");
		System.out.println("7. Exit");
	}

	public void registerPatient(){
		int id=0,dup=0,m=0,amount=0;
		String pname=null,contact=null,specialization=null,dname=null;
		System.out.println("enter Patient ID");
		id = sc.nextInt();

		for(Patient p1:p){
			if (p1.getId()==id){
				System.out.println("The Patiant already Registered");
				System.out.println();
				dup = 1;
				break;
			}
		}

		if(dup==0){
			System.out.println("Enter Patient name");
			pname = sc.next();
			System.out.println("Enter Contact Number");
			contact = sc.next();
			System.out.println("Please Choose Patient Medical Contidition");
			System.out.println("1. Heart Pain");
			System.out.println("2. Skin,Hair or Nail Disorders");
			System.out.println("3. Diabetes");
			System.out.println("4. Women's Health Issues");
			System.out.println("5. Neuro Disoders");
			System.out.println("6. Health Issue Regarding to Food");
			System.out.println("7. Physical Body Pain");
			m = sc.nextInt();
			switch(m){
				case 1: {
						specialization="Cardiology";
						dname = "john";
						amount = 2000;
						break;
				}
				case 2: {
						specialization = "Dermatologist";
						dname = "Vishwas";
						amount = 2500;
						break;
				}
				case 3: {
						specialization = "Diabetology";
						dname = "Suhas";
						amount = 1800;
						break;
				}
				case 4: {
						specialization = "Gynecology";
						dname  = "Raj";
						amount = 4000;
						break;
				}
				case 5: {
						specialization = "Neurology";
						dname  = "Sachin";
						amount = 3000;
						break;
				}
				case 6: {
						specialization = "Diet";
						dname  = "Shilpa";
						amount = 1500;
						break;
				}
				case 7: {
						specialization = "Physiotherapy";
						dname  = "Siddarth";
						amount = 5000;
						break;
				}

			}
			p.add(new Patient(id,amount,pname,dname,contact,specialization));
			System.out.println("Patient Registered Succesfully");
		}

	}

	public void scheduleAppointment(){
		int dup =0,appointmentId=0,pid=0,amount=0,m=0,c=0;
		String pname=null,dname = null,date=null,time=null,am_pm=null;
		System.out.println("enter the Appointment Id");
		appointmentId = sc.nextInt();
		for(Appointment a1:a){
			if(a1.getAppointmentId() == appointmentId){
				System.out.print("Patient is Already Scheduled with this ID,");
				System.out.println("please enter other id");
				dup = 1;
			}
		}
		if (dup==0)
		{
			System.out.println("Enter the Patient Id");
			pid = sc.nextInt();
			for(Patient p1:p){
				if(p1.getId()==pid){
					dname = p1.getDName();
					pname = p1.getPName();
					amount = p1.getAmount();
					System.out.println("enter the date For the Appointment");
					date = sc.next();
					System.out.println("Enter the time for the Appointment");
					time = sc.next();
					System.out.println("Select AM/PM \n AM=1 \n PM=2");
					c = sc.nextInt();
					if(c==1){
						am_pm = "AM";
					}
					else{
						am_pm = "PM";
					}
					m=1;
				}
			}
			if(m==0){
				System.out.print("Patient Not Found");
				System.out.print(" Please Kindly Register the patient before ");
				System.out.println("Sceduling Appointment");
			}
			else{
				a.add(new Appointment(appointmentId,amount,dname,pname,date,time,am_pm));
				System.out.println("Successfully scheduled Appointment");
			}

		}
	}

	public void patientList(){
		System.out.println();
		System.out.println("id     petientName     contact        medicalHistory");
		for(Patient p1:p){
			if(p1!=null){
				System.out.println(p1.getId()+"      "+p1.getPName()+"         "+p1.getContact()+"     "+p1.getMedicalHistory());
			}
		}
	}

	public void doctorList(){
		System.out.println();
		System.out.println("Id     DoctorName        specialization");
		for(Doctor d1:d){
			if(d1!=null){
				System.out.println(d1.getId()+"       "+d1.getDName()+"          "+d1.getSpecialization());
			}
		}
	}

	public void appointmentList(){
		System.out.println();
		System.out.println("ID     DoctorName        PatientName        Date     Time     Am/Pm");
		for(Appointment a1:a){
			if(a1!=null){
				System.out.println(a1.getAppointmentId()+"     "+a1.getDName()+"     "+a1.getPName()+"     "+a1.getDate()+"     "+a1.getTime()+"     "+a1.getAm_Pm());
			}
		}
	}

	public void bill(){
		System.out.println("Enter the Appointment ID");
		int ai = sc.nextInt();
		int amt =0,dc=500;
		for(Appointment a1:a){
			if(a1.getAppointmentId()==ai){
				amt = amt + a1.getAmount();
				System.out.println();
				System.out.println("========================");
				System.out.println("Bill generated Successfully");
				System.out.println("Service Charge is : Rs." + amt);
				System.out.println();
				System.out.println("Doctor Charge is : Rs."+dc);
				double cost = amt+dc;
				System.out.println();
				System.out.println();
				System.out.println("Total amount is : Rs."+cost);
				double gst = (0.18*cost);
				System.out.println("IGST 18%: Rs."+gst);
				System.out.println();
				System.out.println();
				System.out.println("Total Final Amount to be paid is : Rs."+(cost+gst));
				System.out.println("========ThankYou==========");
				break;
			}
		}
		if (amt==0){
			System.out.println("Patient/Doctor not Found");
			System.out.println("========ThankYou=========");
		}
	}

}

class HospitalSystem
{
	public Hospital getInstance(){
		return new HospitalChild();
	}
}

interface Hospital{

	void choice();
	void registerPatient();
	void scheduleAppointment();
	void patientList();
	void doctorList();
	void appointmentList();
	void bill();

}



class HospitalManagement
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Hospital");
		HospitalSystem hs = new HospitalSystem();
		Hospital h = hs.getInstance();
		while(true){
			int c=1;
			while(c>0 && c<7){
				h.choice();
				c=sc.nextInt();
				switch (c){
					case 1:{ h.registerPatient(); break;}
					case 2:{ h.scheduleAppointment(); break;}
					case 3:{ h.patientList(); break;}
					case 4:{ h.doctorList(); break;}
					case 5:{ h.appointmentList(); break;}
					case 6:{ h.bill(); break;}
				}
			}
			break;
		}
	}
}
