package Project;
import java.util.Scanner;

interface Admin
{
	public boolean CreateAccount();
	public boolean LoginAccount();
	public void LogoutAccount();
	public void ChangePassword();

	public void AddBus();

	public void ChangeFare();	
}

abstract class AdminAccount implements Admin
{
	String FirstName,LastName;
	String PhoneNo;
	String email;
	static String UserName="student",Password="student";
	boolean BookingStatus;
	int Passengers=0;

	Scanner s=new Scanner(System.in);
	Scanner in=new Scanner(System.in);
		
	public boolean CreateAccount()
	{
		int n;
		System.out.println("\tPlease enter your details to create an account.\n");
		System.out.print("\tFirst Name: ");
		FirstName=s.next();

		System.out.print("\tLast Name: ");
		LastName=s.next();
		try
		{
			System.out.print("\tPhone Number: ");
			PhoneNo=s.next();
			if (PhoneNo.length()<10)
				throw new ArithmeticException("\tInvalid. Please enter a valid 10-Digit number.");
		}
		catch(ArithmeticException e)
		{
			System.out.print("Error:"+e.getMessage());
			PhoneNo=s.next();
			System.out.println("\n");
		}
		finally
		{
			System.out.print("\tEmail ID: ");
			email=s.next();

			System.out.print("\tEnter a valid username: ");
			UserName=s.next();

			System.out.print("\tEnter an 8-Character password: ");
			Password=s.next();

			System.out.println("\tYour account has been created successfully.\n");
			System.out.print("\tDo you want to continue?\n\nPlease enter (1 for YES/2 for NO):");
			n=s.nextInt();
			if(n==1)
				return true;
			else
				return false;
		}
	}

	public boolean LoginAccount()
	{
		int i=0, option;
		String name,pwd;
		
		while(i<=2)
		{
			System.out.print("\tEnter your username: ");
			name=s.next();
			System.out.print("\tEnter your password: ");
			pwd=s.next();
			if(name.equals(UserName) && pwd.equals(Password))
			{
				System.out.println("\tYou have been logged in successfully.\n");
				return true;
			}
			else
				System.out.println("\tInvalid username/password. Please try again. "+(int)(2-i)+" Trials are available. ");
			i=i+1;
		}

		System.out.println("\tYou have exceeded the given number of trials.\n");
		return false;
	}

	public void ChangePassword()
	{

		String Passwd;
     	String Passwd2;
     	int t1=2;
     	int t2=3;
     
    	System.out.println("\n\tYour password must contain minimum 8 characters.");
    	System.out.println("\n\tAtleast one character must be numeric.");
    	System.out.println("\n\tEnter your new password:");
     
     	while(t1>1)
     	{
  			Passwd=in.nextLine();
  
  			int length=Passwd.length();
  
  			if(length>=8)
  			{
     			System.out.println("\n\tRe-enter your password:");
      			Passwd2=in.nextLine();
      			while(t2>1)
      			{
          			if(Passwd.equals(Passwd2))
          			{
              			System.out.println("\tPassword successfully changed.");
              			Password=Passwd;
              			t2=0;
              			t1=0;
          			}
          			else
              			System.out.println("\tRe-enter your password");
      			}
  			}
  			else
      			System.out.println("\tPlease enter a valid password:");
     	}
	}	
}

abstract class AdminAbstract extends AdminAccount
{
	Buses1 ob=new Buses1();

	public void AddBus()
	{
		ob.AddBus();
	}
}

public class AdminModule extends AdminAbstract
{
	public void ChangeFare()
	{
		System.out.println("\tHere are the details of the buses provided.");
		ob.show(ob);

		Scanner in=new Scanner(System.in);
		System.out.print("\tChoose the bus to change the Fare.");
		int n=in.nextInt();
		n=n-1;

		System.out.print("\tEnter the new Fare.");
		double f=in.nextDouble();

		ob.Bs[n].Fare=f;

		System.out.println("\tThe new fare has been updated.\n");

		ob.show(ob);
	}
	public void LogoutAccount()
	{
		System.out.println("\tYou have been successfully logged out.");
	}	
}

class Bus1
{	
	public String Boarding,Destination;
	public double DepTime,ArrTime;
	public double Fare;
	public String BusNumber;

	public Bus1(String b,String d,String bno,double dt,double at,double fare)
	{
		Boarding=b;
		Destination=d;
		BusNumber=bno;
		DepTime=dt;
		ArrTime=at;
		Fare=fare;
	}
}

class Buses1
{	
	public int number=36;
	
	int i;

	public Bus1 Bs[]=new  Bus1[100];

	Scanner in=new Scanner(System.in);

	Buses1()
	{
		Menu();
	}

	public void Menu()
	{	
		Bs[0]=new  Bus1("	NITK","	Madikeri		       ","1001",03.45,07.25,300);
		Bs[1]=new  Bus1("	NITK"," Kudremukh		       ","1002",08.35,11.05,180.50);
		Bs[2]=new  Bus1("	NITK"," Bandipur National Park ","1003",02.45,05.55,80);
		Bs[3]=new  Bus1("	NITK","	Gokarna	               ","1004",14.55,18.25,320.50);
		Bs[4]=new  Bus1("	NITK","	Devbagh		           ","1005",17.45,20.35,100);
		Bs[5]=new  Bus1("	NITK","	Jog Falls		       ","1006",17.45,20.35,130);
		Bs[6]=new  Bus1("	NITK","	Murdeshwar		       ","1007",06.35,09.35,220);
		Bs[7]=new  Bus1("	NITK","	Bekal		           ","1101",05.05,07.35,100);
		Bs[8]=new  Bus1("	NITK","	Shimoga		           ","1008",12.05,16.35,175);
		Bs[9]=new  Bus1("	NITK","	Chikamagalur		   ","1009",02.05,06.35,200);
		Bs[10]=new  Bus1("	NITK","	Coorg		           ","1010",08.25,11.35,210);
		Bs[11]=new  Bus1("	NITK","	Kotagiri		       ","1011",09.35,12.55,150);
		Bs[12]=new  Bus1("	NITK","	Dandeli       	       ","1012",02.05,10.35,320);
		Bs[13]=new  Bus1("	NITK","	Yana		           ","1013",01.45,06.35,180);
		Bs[14]=new  Bus1("	NITK","	Kabini		           ","1014",03.15,08.35,220);
		Bs[15]=new  Bus1("	NITK","	Tusharagiri Falls	   ","1102",02.55,08.35,270);
		Bs[16]=new  Bus1("	NITK","	Kemmanagundi Falls	   ","1015",12.55,18.35,280);
		Bs[17]=new  Bus1("	NITK","	Silent Valley		   ","1103",11.35,19.35,230);
		Bs[18]=new  Bus1("	NITK","	Edakkal Caves		   ","1104",13.35,19.35,300);
		Bs[19]=new  Bus1("	NITK","	Badami		           ","1016",14.25,23.35,500);
		Bs[20]=new  Bus1("	NITK","	Guruvayur Temple	   ","1105",03.15,11.35,450);
		Bs[21]=new  Bus1("	NITK","	Nandi Hills		       ","1017",05.45,12.55,390);
		Bs[22]=new  Bus1("	NITK","	Shivaganga Hills	   ","1018",17.15,23.35,370);
		Bs[23]=new  Bus1("	NITK","	Kundadri Hills		   ","1019",10.55,13.50,260);
		Bs[24]=new  Bus1("	NITK","	Mysore		           ","1020",12.35,19.35,670);
		Bs[25]=new  Bus1("	NITK","	Kumara Parvat		   ","1021",06.55,11.05,480);
		Bs[26]=new  Bus1("	NITK","	Mudumalai		       ","1201",01.45,09.35,570);
		Bs[27]=new  Bus1("	NITK","	Thrissur		       ","1106",05.15,13.05,490);
		Bs[28]=new  Bus1("	NITK","	Chitradurga		       ","1022",16.05,22.15,560);
		Bs[29]=new  Bus1("	NITK","	Agumbe		           ","1023",08.15,11.10,190);
		Bs[30]=new  Bus1("	NITK","	Kodaikanal		       ","1202",07.15,19.35,750);
		Bs[31]=new  Bus1("	NITK","	Athirappilly Falls	   ","1107",12.15,21.25,670);
		Bs[32]=new  Bus1("	NITK","	Coimbatore		       ","1203",14.25,23.35,700);
		Bs[33]=new  Bus1("	NITK","	Hampi		           ","1024",10.05,19.25,700);
		Bs[34]=new  Bus1("	NITK","	Ooty		           ","1204",01.25,10.25,560);
		Bs[35]=new  Bus1("	NITK","	Goa		               ","1300",12.45,21.05,600);
	}

	public void show(Buses1 ob)
	{
		System.out.println("S.No	Bus.No	Boarding-Point	Destination-Point	Dept-Time	Arr-Time	Fare\n\n");
		for(i=0;i<ob.number;i++)
		{
			System.out.print(i+1+".	"+Bs[i].BusNumber+"	"+Bs[i].Boarding+"	"+Bs[i].Destination+"	"+Bs[i].DepTime);
			System.out.println("		"+Bs[i].ArrTime+"		"+Bs[i].Fare);
		}
	}

	public void AddBus()
	{
		System.out.println("\tHere are the bus Details:");
		show(this);

		System.out.print("\n\tEnter the 5-digit bus number: ");
		String bno;
		while(2>1)
		{
			bno=in.next();
            if(bno.length() != 5)
                System.out.println("\tPlease enter a 5 Digit bus number only");
			else
				break;
		}
		
		String b="NITK";
		b="	"+b;

		System.out.print("\n\tDestination-point: ");
		String d=in.next();
		d="	"+d+"		";

		System.out.print("\n\tDeparture-time(in 24-hr format): ");
		double dt=in.nextDouble();

		System.out.print("\n\tArrival-time(in 24-hr format): ");
		double at=in.nextDouble();

		System.out.print("\n\tEnter the Fare(in Rupees): ");
		double fare=in.nextDouble();

		Bs[number]=new  Bus1(b,d,bno,dt,at,fare);
		number=number+1;
		System.out.print("\n\tThe details have been added. \n");

		show(this);
	}
}