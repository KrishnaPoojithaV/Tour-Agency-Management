package Project;
import java.util.Scanner;


interface User
{
	public boolean CreateAccount();
	public boolean LoginAccount();

    
	public void BookTickets();
	public void ChangePassword();

	public void CancelTickets();
	public void BusDetail();
	public void LogoutAccount();
}

abstract class UserAbstract implements User
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
		System.out.print("\tFirst Name : ");
		FirstName=s.next();

		System.out.print("\tLast Name : ");
		LastName=s.next();
		try
		{
			System.out.print("\tPhone Number: ");
			PhoneNo=s.next();
			if (PhoneNo.length()<10)
				throw new ArithmeticException("\n\tNumber entered is invalid. Please enter a valid 10-Digit number.");
		}
		catch(ArithmeticException e)
		{
			System.out.print("\tError:"+e.getMessage());
			PhoneNo=s.next();
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
			System.out.print("\tDo you want to continue?\n\tPlease enter (1 for YES / 2 for NO):");
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
				return true;
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

public class UserModule extends UserAbstract
{
	int no;
	Scanner sc=new Scanner(System.in);
	public void BusFilter()
	{   
        int n1, opt = 4;
		while(opt==4)
		{
		    System.out.println("\nChoose the duration of trip:\n\n\t1.One Day Trip\n\t2.Two Day Trip\n\t3.Long trip");
		    while(2>1)
		    {
			    n1=sc.nextInt();
			    if(n1<1 || n1>3)
				    System.out.println("Please choose from available options only\n");
			    else
				    break;
			}
		    if(n1==1)
		    {
			    OneDay oneday = new OneDay();
			    System.out.println("Choose\n\t1. Display places\n\t2. Filter further based on nature of trip\n\t3. Filter further based on distance\n\t4. exit\n ");
	            while(2>1)
		        {
		            opt = sc.nextInt();
			        if(opt<1 || opt>4)
				        System.out.println("Please choose from available options only\n");
			        else
				        break;
		        }
		        if(opt == 1)
		     	    oneday.display();
		        else if(opt == 2)
		     	    oneday.FilterNature();
		        else if(opt == 3)
		     	    oneday.FilterDistance();
		    }
		    else if(n1==2)
		    {
			    TwoDay twoday = new TwoDay();
			    System.out.println("Choose\n\t1. Display places\n\t2. Filter further based on nature of trip\n\t3. Filter further based on distance\n\t4. exit\n ");
	            while(2>1)
		        {
		            opt = sc.nextInt();
			        if(opt<1 || opt>4)
				        System.out.println("Please choose from available options only\n");
			        else
				        break;
			    }
		        if(opt == 1)
		     	    twoday.display();
		        else if(opt == 2)
		     	    twoday.FilterNature();
		        else if(opt == 3)
		     	    twoday.FilterDistance();
		    }
		    else if(n1==3)
		    {
			    LongTrip longtrip = new LongTrip();
			    System.out.println("Choose\n\t1. Display places\n\t2. Filter further based on nature of trip\n\t3. Filter further based on distance\n\t4. exit\n ");
	            while(2>1)
		        {
		            opt = sc.nextInt();
			        if(opt<1 || opt>4)
				        System.out.println("Please choose from available options only\n");
			        else
				        break;
		        }
		        if(opt == 1)
		     	    longtrip.display();
		        else if(opt == 2)
		     	    longtrip.FilterNature();
		        else if(opt == 3)
		     	    longtrip.FilterDistance();
		    }
		}
	}

	public void BookTickets()
	{
		Buses bus=new Buses();
        
		System.out.println("\n\tThese are the buses offered by us:\n\n\tDetails are also provided\n");
		bus.show();

		System.out.println("\nChoose a bus(S.No):");
		no=in.nextInt();
		no=no-1;

		System.out.print("\nEnter the number of passengers:	");
		bus.Bs[no].noPass =in.nextInt();

		BookingStatus=true;
		Passengers=Passengers+bus.Bs[no].noPass;

		System.out.println("Here is your Ticket:\n");

		System.out.print("\t	-----------------------------------------------------------------------------\n\n");
		System.out.print("\t		*******************************************************************\n\n");
		System.out.println("\t		               ----NITK ON WHEELS TOURS & TRAVELS----              \n");
		System.out.println("\t		Bus Number:	"+bus.Bs[no].BusNumber+"\n\n");
		System.out.println("\t		Boarding Point:		"+bus.Bs[no].Boarding);
		System.out.println("\t		Destination Point:	"+bus.Bs[no].Destination+"\n\n");

		System.out.println("\t		Departure Time:		"+bus.Bs[no].DepTime);
		System.out.println("\t		Arrival Time:		"+bus.Bs[no].ArrTime+"\n\n");
		System.out.println("\t		Total Fare:			Rs."+(bus.Bs[no].noPass)*(bus.Bs[no].Fare)+"/- only\n\n");
		System.out.println("\t				-----HAVE A HAPPY JOURNEY-----\n\n");
		System.out.println("\t		*******************************************************************\n\n");
		System.out.println("\t	------------------------------------------------------------------------------\n\n");

	}

	public void CancelTickets()
	{
		String dec;
    	int p;
    	int num;
    	double amount;
		int choice;

		System.out.println("\n\tDetails of Buses:\n\n");
        Buses obj=new Buses();
        obj.show();
		System.out.print("\nSelect the serial number of bus for which tickets are to be cancelled: ");
        num=in.nextInt();
        num=num-1;
		if(no == num)
		{
		    System.out.println("\n\n\tYour ticket has " + Passengers + " passengers");
		    if(Passengers == 0)
		    {
			    System.out.println("\tThere have been no bookings made for this route.\n Please login and book tickets.");
			
				LoginAccount();
	        }
		    else
		    {
		        System.out.println("\n\tAre you sure you want to cancel this ticket?\n");
  		        System.out.println("\nEnter \"Yes\" to cancel the tickets. \"No\" to return ");
		        dec=in.next();
  		        if(dec.equals("Yes"))
  		        {
      
      		        System.out.print("\n\n\tHow many of these ticket(s) do you wish to cancel?\n:");
      
             		p=in.nextInt();

      		        if(p==Passengers)
      			        BookingStatus=false;
      		        amount=obj.Bs[num].Fare*p;
      		        System.out.println("\n\tYour ticket(s) have been cancelled successfully.");
      		        System.out.println("\n\tRupees."+amount+"/- will be refunded into your account.\n");
  		        } 
  		        else
      		        System.out.println("\n\tYour tickets are not cancelled.\n");
		    }
		}
		else
		{
			System.out.println("There have been no bookings made for this route.\n Please login and book tickets.");
			
			LoginAccount();
		}
	}

	public void BusDetail()
	{
		UserModule ob=new UserModule();
		ob.BusFilter();
	}

	public void LogoutAccount()
	{
		System.out.println("You have been successfully logged out.");
	}
}

class OneDay
{   
   void display()
    {
   	    System.out.println("According to your choice, the list of places : ");
   	    System.out.println("\n\n\t1. Madikeri\n\t   Rating : 4.1/5.0\nMadikeri is surrounded by valleys, sholas, paddy fields, grasslands, orange orchards, and coffee, pepper and cardamom plantations. A perfect family spot for summer vacations as it is amidst all shades of green with clean and fresh air to breathe and nearby flows the famous river Cauvery.");
        System.out.println("\n\n\t2. Kudremukh\n\t   Rating : 4.0/5.0\nThis trek is an amazing experience as the landscape offers a gentle gradient in the initial phases and then a more challenging one as a person reaches the summit. The best time to visit this place is from November to February. I would rate this trekking destination difficulty level as high.");
        System.out.println("\n\n\t3. Bandipur National Park\n\t   Rating : 3.6/5.0\nDeer's buffalo tigers elephant's and the green cover, everything was in abundance. Even the people have abundance of knowledge and warmth over there.");
   	    System.out.println("\n\n\t4. Gokarna\n\t   Rating : 3.8/5.0\nFirstly it's a very small town spreaded across the coastal regions. Main attractions are Om beach, kudle beach. There are various shacks present in both Om & Kudle beach.");
   	    System.out.println("\n\n\t5. Devbagh\n\t   Rating : 4.5/5.0\nIts a clean and long beach with a good sunset experience.");
   	    System.out.println("\n\n\t6. Jog Falls\n\t   Rating : 4.3/5.0\nThis is fantastic Jog falls is such a majestic fall.These falls are one of the most important attractions in all of South India.Jog falls drops from a huge hight.This is the one of the tourist place in Karnataka.");
        System.out.println("\n\n\t7. Murudeshwar\n\t   Rating : 4.0/5.0\nThis is one of the famous beach in Karnataka it is located beside Lord Shiva temple there is one big Shiva statue here looking very very beautiful we can enjoy in beach very lot December is the best time to visit here.");
        System.out.println("\n\n\t8. Bekal\n\t   Rating : 4.5/5.0\nGreat location. Can see miles away from the fort. Good view of the sea.");
        System.out.println("\n\n\t9. Shimoga\n   Rating : 4.2/5.0\nBest waterfalls. Easy to reach by all modes of transport. Enjoy the fresh air and fresh waters.");
        System.out.println("\n\n\t10. Chickamagalur\n\t   Rating : 4.5/5.0\nNature at its best at Western Ghats. Haven for coffee lovers. Amazing weekend getaway.");
        System.out.println("\n\n\t11. Coorg\n\t   Rating : 4.4/5.0\nThe misty hills, lush teakwood and sandalwood forests, and acres of tea and coffee plantations of Kodagu are, in a word, stunning. Also known as Coorg and dubbed 'The Scotland of India'.");
        System.out.println("\n\n\t12. Kotagiri\n\t   Rating : 4.0/5.0\nMust visit place when in kothagiri or enroute to Ooty. If Mists stay away you will be amazed by the several mountain views, a water falls in the far off mountain. The beauty here will belittle several other good spots which will come to your mind.");
    }
	void FilterNature()
	{
		Scanner scan=new Scanner(System.in);
        System.out.println("What type of trip do you want?\n\t1.Adventure\n\t2.Scenic\n\t3.Historical and Heritage\n\t4.Hill Station\n\tChoose an option\n");
		int choice1;
		while(2>1)
		{
		    choice1=scan.nextInt();
		    if(choice1 <1 || choice1 > 4)
			    System.out.println("Please choose from given options\n");
		    else
		    	break;
	    }
		if(choice1==1)
		{
    	    System.out.println("According to your choice the list of places are :");
		    System.out.println("\n\n\t1. Madikeri\n\t   Rating : 4.1/5.0\nMadikeri is surrounded by valleys, sholas, paddy fields, grasslands, orange orchards, and coffee, pepper and cardamom plantations. A perfect family spot for summer vacations as it is amidst all shades of green with clean and fresh air to breathe and nearby flows the famous river Cauvery.");
            System.out.println("\n\n\t2. Kudremukh\n\t   Rating : 4.0/5.0\nThis trek is an amazing experience as the landscape offers a gentle gradient in the initial phases and then a more challenging one as a person reaches the summit. The best time to visit this place is from November to February. I would rate this trekking destination difficulty level as high."); 
            System.out.println("\n\n\t3. Bandipur National Park\n\t   Rating : 3.6/5.0\nDeer's buffalo tigers elephant's and the green cover, everything was in abundance. Even the people have abundance of knowledge and warmth over there.");
		}
	    else if(choice1==2)
	   	{   
	   		System.out.println("According to your choice the list of places are :");
            System.out.println("\n\n\t1. Gokarna\n\t   Rating : 3.8/5.0\nFirstly it's a very small town spreaded across the coastal regions. Main attractions are Om beach, kudle beach. There are various shacks present in both Om & Kudle beach.");
            System.out.println("\n\n\t2. Devbagh\n\t   Rating : 4.5/5.0\nIts a clean and long beach with a good sunset experience.");
            System.out.println("\n\n\t3. Jog Falls\n\t   Rating : 4.3/5.0\nThis is fantastic Jog falls is such a majestic fall.These falls are one of the most important attractions in all of South India.Jog falls drops from a huge hight.This is the one of the tourist place in Karnataka.");
	    }
	    else if(choice1==3)
    	{   
    		System.out.println("According to your choice the list of places are :");
            System.out.println("\n\n\t1. Murudeshwar\n\t   Rating : 4.0/5.0\nThis is one of the famous beach in Karnataka	 it is located beside Lord Shiva temple there is one big Shiva statue here looking very very beautiful we can enjoy in beach very lot December is the best time to visit here.");
            System.out.println("\n\n\t2. Bekal\n\t   Rating : 4.5/5.0\nGreat location. Can see miles away from the fort. Good view of the sea.");
            System.out.println("\n\n\t3. Shimoga\n\t   Rating : 4.2/5.0\nBest waterfalls. Easy to reach by all modes of transport. Enjoy the fresh air and fresh waters.");
	    }
	    else 
	    {
	    	System.out.println("According to your choice the list of places are :");
	        System.out.println("\n\n\t1. Chickamagalur\n   Rating : 4.5/5.0\nNature at its best at Western Ghats. Haven for coffee lovers. Amazing weekend getaway.");
            System.out.println("\n\n\t2. Coorg\n\t   Rating : 4.4/5.0\nThe misty hills, lush teakwood and sandalwood forests, and acres of tea and coffee plantations of Kodagu are, in a word, stunning. Also known as Coorg and dubbed 'The Scotland of India'.");
            System.out.println("\n\n\t3. Kotagiri\n\t   Rating : 4.0/5.0\nMust visit place when in kothagiri or enroute to Ooty. If Mists stay away you will be amazed by the several mountain views, a water falls in the far off mountain. The beauty here will belittle several other good spots which will come to your mind.");
	    }  
	}
	
	void FilterDistance()
	{
        System.out.println("\tChoose the distance\n\t1.Within 150km\n\t2.1500-250km\n\tChoose an option");
        int choice1;
        Scanner scan=new Scanner(System.in);
		while(2>1)
		{
		    choice1=scan.nextInt();
		    if(choice1 <1 || choice1 > 2)
			    System.out.println("\tPlease choose from given options\n");
		    else
			    break;
		}
		if(choice1==1)
		{
	    	System.out.println("\tAccording to your choice the list of places are :\n");
		    System.out.println("\n\n\t1. Coorg\n\t   Rating : 4.4/5.0\nThe misty hills, lush teakwood and sandalwood forests, and acres of tea and coffee plantations of Kodagu are, in a word, stunning. Also known as Coorg and dubbed 'The Scotland of India'.");
            System.out.println("\n\n\t2. Chickamagalur\n\t   Rating : 4.5/5.0\nNature at its best at Western Ghats. Haven for coffee lovers. Amazing weekend getaway.");
            System.out.println("\n\n\t3. Murudeshwar\n\t   Rating : 4.0/5.0\nThis is one of the famous beach in Karnataka it is located beside Lord Shiva temple there is one big Shiva statue here looking very very beautiful we can enjoy in beach very lot December is the best time to visit here.");
            System.out.println("\n\n\t4. Kudremukh\n\t   Rating : 4.0/5.0\nThis trek is an amazing experience as the landscape offers a gentle gradient in the initial phases and then a more challenging one as a person reaches the summit. The best time to visit this place is from November to February. I would rate this trekking destination difficulty level as high.");
		    System.out.println("\n\n\t5. Madikeri\n\t   Rating : 4.1/5.0\nMadikeri is surrounded by valleys, sholas, paddy fields, grasslands, orange orchards, and coffee, pepper and cardamom plantations. A perfect family spot for summer vacations as it is amidst all shades of green with clean and fresh air to breathe and nearby flows the famous river Cauvery.");
		    System.out.println("\n\n\t6. Shimoga\n\t   Rating : 4.2/5.0\nBest waterfalls. Easy to reach by all modes of transport. Enjoy the fresh air and fresh waters.");
		}
	    else 
	   	{   
	   		System.out.println("\tAccording to your choice the list of places are :\n");
	        System.out.println("\n\n\t1. Gokarna\n\t   Rating : 3.8/5.0\nFirstly it's a very small town spreaded across the coastal regions. Main attractions are Om beach, kudle beach. There are various shacks present in both Om & Kudle beach.");
	        System.out.println("\n\n\t2. Bekal\n\t   Rating : 4.5/5.0\nGreat location. Can see miles away from the fort. Good view of the sea.");
	        System.out.println("\n\n\t3. Kotagiri\n\t   Rating : 4.0/5.0\nMust visit place when in kothagiri or enroute to Ooty. If Mists stay away you will be amazed by the several mountain views, a water falls in the far off mountain. The beauty here will belittle several other good spots which will come to your mind.");
	        System.out.println("\n\n\t4. Jog Falls\n\t   Rating : 4.3/5.0\nThis is fantastic Jog falls is such a majestic fall.These falls are one of the most important attractions in all of South India.Jog falls drops from a huge hight.This is the one of the tourist place in Karnataka.");
            System.out.println("\n\n\t5. Bandipur National Park\n\t   Rating : 3.6/5.0\nDeer's buffalo tigers elephant's and the green cover, everything was in abundance. Even the people have abundance of knowledge and warmth over there.");
	        System.out.println("\n\n\t6. Devbagh\n\t   Rating : 4.5/5.0\nIts a clean and long beach with a good sunset experience.");
	    }
    }
}

class TwoDay
{     
   void display()
   {
   	    System.out.println("According to your choice, the list of places :");
        System.out.println("\n\n\t1. Dandeli\n\t   Rating : 4.2/5.0\n\tAccommodation : \n\tVinayak Home Stay\n\tJungle Nest - Dandeli\nThe place is serene and you feel that you are staying in the lap of nature. We did 3 safaris and river boating. The guides are very good and informative.");
        System.out.println("\n\n\t2. Yana\n\t   Rating : 4.0/5.0\n\tAccommodation : \n\tSooryodaya Nature Retreat\n\tNature Camp Bellengi\nYana is one of the most beautiful places you will ever see in Karnataka. The route to Yana from Kumta is one of the best for all you people who like to drive through the extreme wilderness. Highly recommended during the monsoon or winters where you get to see the cloud cover throughout the route.");
        System.out.println("\n\n\t3. Gokarna\n\t   Rating : 3.8/5.0\n\tAccommodation : \n\tGokarna Zostel\n\tEvergreen Farm House\nFirstly it's a very small town spreaded across the coastal regions. Main attractions are Om beach, kudle beach. There are various shacks present in both Om & Kudle beach.");
        System.out.println("\n\n\t4. Kabini\n\t   Rating : 4.0/5.0\n\tAccommodation : \n\tWater Woods Lodge\n\tKabini Lake View Resort\nOne of the best and my favourite rivers to do a wild life boat safari. The elephant sightings are a guarantee during the summer months.The river is suited for rafting sports.");
        System.out.println("\n\n\t5. Thusharagiri Falls\n\t   Rating : 4.2/5.0\n\tAccommodation : \n\tUpavan Resort and Spa\n\tVythiri Resort\nWaterfalls are best during and just after monsoons. Our visit was after the first monsoon so the waterfalls was amazing. Milky white water falling on the rocks. Even though its not a big waterfall the place is very beautiful.");
        System.out.println("\n\n\t6. Kemmanagundi Hills\n\t   Rating : 3.9/5.0\n\tAccommodation : \n\tThe Last Resort\n\tHotel Ranga tana\nIt's a lovely place to visit during June to December. It's very attractive with all 3 sides covered with forest and other side is a path to walk.A small temple is attached to the falls, which seems to be beautiful during rainy season.");
        System.out.println("\n\n\t7. Silent Valley\n\t   Rating : 4.0/5.0\n\tAccommodation : \n\tTree Top Resort\n\tHotel Hill View Tower\nIf you are a nature lover, then this is a must visit. This forest is preserved unspoiled. You see lots of birds & even-toed ungulate mammals.");
        System.out.println("\n\n\t8. Edakkal Caves\n\t   Rating : 3.9/5.0\n\tAccommodation : \n\tEdakkal Hermitage Resort\n\tKTDC Pepper Grove\nIts the second best thing in Wayanad to see and explore, its a 340 steps climb up to the caves. Although there is nothing there to see in the cave but the view is awusum. It had drizzled so we got a nice green view from the top.");
        System.out.println("\n\n\t9. Badami\n\t   Rating : 4.5/5.0\n\tAccommodation : \n\tThe Heritage Resort\n\tKSTDC Hotel Mayura\nThe detail in the work is truly stunning. Even though there is quite a bit of damage much can still be seen. Exquisite carvings on pillars and large figures make the climb well worth it.");
        System.out.println("\n\n\t10.Guruvayoor temple\n\t   Rating : 3.6/5.0\n\tAccommodation : \n\tMayura Residency\n\tSreeKrishna Residency\nAs believer, this place to me is a must visit. Had been to the temple in the evening, actually got an opportunity to see the lord twice. Since it was less crowded in evening on a weekday.Also, do not miss out the the way 'Gandha' is made in a mechanical way in large quantities by the people who work in the temple.");
        System.out.println("\n\n\t11.Nandi Hills\n\t   Rating : 4.0/5.0\n\tAccommodation : \n\tHotel Pinetop\n\tHotel Maurya\nNandi Hills : Oasis For The Thirsty & Tired Traveller.If You have decided to explore nature at its pristine best. Fed up with the crowded tourist spots, you long for a place to stand and stare at nature.Nandi Hills The best known and the most popular weekend spot for Bangaloreans.");
        System.out.println("\n\n\t12.Shivaganga Hills\n\t   Rating : 3.8/5.0\n\tAccommodation : \n\tFoothills Stay\n\tUtsav Club and Resort\nThis is one of the famous tourist place in Tumkur. This mountain is very attractive and fully nature oriented place. It is also a historical place");
        System.out.println("\n\n\t13.Kundadri Hills\n\t   Rating : 4.4/5.0\n\tAccommodation : \n\tHingara Nature Stay\n\tHighlands Home Stay\nOnce you reach the top after traveling through a step ghat road the adrenaline rush in your veins would sooth for sure. The views from the top are breathtaking, to say the least. The Jain temple at the top adds to it.");
   }

	void FilterNature()
	{
		Scanner scan=new Scanner(System.in);
        System.out.println("What type of trip do you want?\n\t1.Adventure\n\t2.Scenic\n\t3.Historical and Heritage\n\t4.Hill Station\nChoose an option");
		int choice1;
		while(2>1)
		{
		    choice1=scan.nextInt();
		    if(choice1 <1 || choice1 > 4)
			    System.out.println("Please choose from given options\n");
		    else
			    break;
	    }
		if(choice1==1)
		{
			System.out.println("According to your choice the list of places are :");
		    System.out.println("\n\n\t1. Dandeli\n\t   Rating : 4.2/5.0\n\tAccommodation : \n\tVinayak Home Stay\n\tJungle Nest - Dandeli\nThe place is serene and you feel that you are staying in the lap of nature. We did 3 safaris and river boating. The guides are very good and informative.");
            System.out.println("\n\n\t2. Yana\n\t   Rating : 4.0/5.0\n\tAccommodation : \n\tSooryodaya Nature Retreat\n\tNature Camp Bellengi\nYana is one of the most beautiful places you will ever see in Karnataka. The route to Yana from Kumta is one of the best for all you people who like to drive through the extreme wilderness. Highly recommended during the monsoon or winters where you get to see the cloud cover throughout the route.");
            System.out.println("\n\n\t3. Gokarna\n\t   Rating : 3.8/5.0\n\tAccommodation : \n\tGokarna Zostel\n\tEvergreen Farm House\nFirstly it's a very small town spreaded across the coastal regions. Main attractions are Om beach, kudle beach. There are various shacks present in both Om & Kudle beach.");
		}
	    else if(choice1==2)
	    {
            System.out.println("According to your choice the list of places are :");
	    	System.out.println("\n\n\t1. Kabini\n\t   Rating : 4.0/5.0\n\tAccommodation : \n\tWater Woods Lodge\n\tKabini Lake View Resort\nOne of the best and my favourite rivers to do a wild life boat safari. The elephant sightings are a guarantee during the summer months.The river is suited for rafting sports.");
            System.out.println("\n\n\t2. Thusharagiri Falls\n\t   Rating : 4.2/5.0\n\tAccommodation : \n\tUpavan Resort and Spa\n\tVythiri Resort\nWaterfalls are best during and just after monsoons. Our visit was after the first monsoon so the waterfalls was amazing. Milky white water falling on the rocks. Even though its not a big waterfall the place is very beautiful.");
            System.out.println("\n\n\t3. Kemmanagundi Hills\n\t   Rating : 3.9/5.0\n\tAccommodation : \n\tThe Last Resort\n\tHotel Ranga tana\nIt's a lovely place to visit during June to December. It's very attractive with all 3 sides covered with forest and other side is a path to walk.A small temple is attached to the falls, which seems to be beautiful during rainy season.");
	    }
	    else if(choice1==3)
	    {
	    	System.out.println("According to your choice the list of places are :");
	    	System.out.println("\n\n\t1. Silent Valley\n\t   Rating : 4.0/5.0\n\tAccommodation : \n\tTree Top Resort\n\tHotel Hill View Tower\nIf you are a nature lover, then this is a must visit. This forest is preserved unspoiled. You see lots of birds & even-toed ungulate mammals.");
            System.out.println("\n\n\t2. Edakkal Caves\n\t   Rating : 3.9/5.0\n\tAccommodation : \n\tEdakkal Hermitage Resort\n\tKTDC Pepper Grove\nIts the second best thing in Wayanad to see and explore, its a 340 steps climb up to the caves. Although there is nothing there to see in the cave but the view is awusum. It had drizzled so we got a nice green view from the top.");
            System.out.println("\n\n\t3. Badami\n\t   Rating : 4.5/5.0\n\tAccommodation : \n\tThe Heritage Resort\n\tKSTDC Hotel Mayura\nThe detail in the work is truly stunning. Even though there is quite a bit of damage much can still be seen. Exquisite carvings on pillars and large figures make the climb well worth it.");
            System.out.println("\n\n\t4. Guruvayoor temple\n\t   Rating : 3.6/5.0\n\tAccommodation : \n\tMayura Residency\n\tSreeKrishna Residency\nAs believer, this place to me is a must visit. Had been to the temple in the evening, actually got an opportunity to see the lord twice. Since it was less crowded in evening on a weekday.Also, do not miss out the the way 'Gandha' is made in a mechanical way in large quantities by the people who work in the temple.");
	    }
	    else 
	    {
            System.out.println("According to your choice the list of places are :");
	    	System.out.println("\n\n\t1. Nandi Hills\n\t   Rating : 4.0/5.0\n\tAccommodation : \n\tHotel Pinetop\n\tHotel Maurya\nNandi Hills : Oasis For The Thirsty & Tired Traveller.If You have decided to explore nature at its pristine best. Fed up with the crowded tourist spots, you long for a place to stand and stare at nature.Nandi Hills The best known and the most popular weekend spot for Bangaloreans.");
            System.out.println("\n\n\t2. Shivaganga Hills\n\t   Rating : 3.8/5.0\n\tAccommodation : \n\tFoothills Stay\n\tUtsav Club and Resort\nThis is one of the famous tourist place in Tumkur. This mountain is very attractive and fully nature oriented place. It is also a historical place");
            System.out.println("\n\n\t3. Kundadri Hills\n\t   Rating : 4.4/5.0\n\tAccommodation : \n\tHingara Nature Stay\n\tHighlands Home Stay\nOnce you reach the top after traveling through a step ghat road the adrenaline rush in your veins would sooth for sure. The views from the top are breathtaking, to say the least. The Jain temple at the top adds to it.");
	    }
	}
	
	void FilterDistance()
	{
        System.out.println("Choose the distance\n\t1. Within 200km\n\t2.200-350km\nChoose an option");
        int choice1;
        Scanner scan=new Scanner(System.in);
		while(2>1)
		{
		    choice1=scan.nextInt();
		    if(choice1 <1 || choice1 > 2)
			    System.out.println("Please choose from given options\n");
		    else
			    break;
	    }
		if(choice1==1)
		{
			System.out.println("According to your choice the list of places are :");
		    System.out.println("\n\n\t1. Yana\n\t   Rating : 4.0/5.0\n\tAccommodation : \n\tSooryodaya Nature Retreat\n\tNature Camp Bellengi\nYana is one of the most beautiful places you will ever see in Karnataka. The route to Yana from Kumta is one of the best for all you people who like to drive through the extreme wilderness. Highly recommended during the monsoon or winters where you get to see the cloud cover throughout the route.");
            System.out.println("\n\n\t2. Gokarna\n\t   Rating : 3.8/5.0\n\tAccommodation : \n\tGokarna Zostel\n\tEvergreen Farm House\nFirstly it's a very small town spreaded across the coastal regions. Main attractions are Om beach, kudle beach. There are various shacks present in both Om & Kudle beach.");
            System.out.println("\n\n\t3. Nandi Hills\n\t   Rating : 4.0/5.0\n\tAccommodation : \n\tHotel Pinetop\n\tHotel Maurya\nNandi Hills : Oasis For The Thirsty & Tired Traveller.If You have decided to explore nature at its pristine best. Fed up with the crowded tourist spots, you long for a place to stand and stare at nature.Nandi Hills The best known and the most popular weekend spot for Bangaloreans.");
            System.out.println("\n\n\t4. Shivaganga Hills\n\t   Rating : 3.8/5.0\n\tAccommodation : \n\tFoothills Stay\n\tUtsav Club and Resort\nThis is one of the famous tourist place in Tumkur. This mountain is very attractive and fully nature oriented place. It is also a historical place");                
            System.out.println("\n\n\t5. Kundadri Hills\n\t   Rating : 4.4/5.0\n\tAccommodation : \n\tHingara Nature Stay\n\tHighlands Home Stay\nOnce you reach the top after traveling through a step ghat road the adrenaline rush in your veins would sooth for sure. The views from the top are breathtaking, to say the least. The Jain temple at the top adds to it.");
		}    
	    else  
	    {
	    	System.out.println("According to your choice the list of places are :");
	    	System.out.println("\n\n\t1. Dandeli\n\t   Rating : 4.2/5.0\n\tAccommodation : \n\tVinayak Home Stay\n\tJungle Nest - Dandeli\nThe place is serene and you feel that you are staying in the lap of nature. We did 3 safaris and river boating. The guides are very good and informative.");
	     	System.out.println("\n\n\t2. Badami\n\t   Rating : 4.5/5.0\n\tAccommodation : \n\tThe Heritage Resort\n\tKSTDC Hotel Mayura\nThe detail in the work is truly stunning. Even though there is quite a bit of damage much can still be seen. Exquisite carvings on pillars and large figures make the climb well worth it.");
            System.out.println("\n\n\t3. Edakkal Caves\n\t   Rating : 3.9/5.0\n\tAccommodation : \n\tEdakkal Hermitage Resort\n\tKTDC Pepper Grove\nIts the second best thing in Wayanad to see and explore, its a 340 steps climb up to the caves. Although there is nothing there to see in the cave but the view is awusum. It had drizzled so we got a nice green view from the top.");
            System.out.println("\n\n\t4. Guruvayoor temple\n\t   Rating : 3.6/5.0\n\tAccommodation : \n\tMayura Residency\n\tSreeKrishna Residency\nAs believer, this place to me is a must visit. Had been to the temple in the evening, actually got an opportunity to see the lord twice. Since it was less crowded in evening on a weekday.Also, do not miss out the the way 'Gandha' is made in a mechanical way in large quantities by the people who work in the temple.");               
            System.out.println("\n\n\t5. Silent Valley\n\t   Rating : 4.0/5.0\n\tAccommodation : \n\tTree Top Resort\n\tHotel Hill View Tower\nIf you are a nature lover, then this is a must visit. This forest is preserved unspoiled. You see lots of birds & even-toed ungulate mammals.");
            System.out.println("\n\n\t6. Thusharagiri Falls\n\t   Rating : 4.2/5.0\n\tAccommodation : \n\tUpavan Resort and Spa\n\tVythiri Resort\nWaterfalls are best during and just after monsoons. Our visit was after the first monsoon so the waterfalls was amazing. Milky white water falling on the rocks. Even though its not a big waterfall the place is very beautiful.");
            System.out.println("\n\n\t7. Kabini\n\t   Rating : 4.0/5.0\n\tAccommodation : \n\tWater Woods Lodge\n\tKabini Lake View Resort\nOne of the best and my favourite rivers to do a wild life boat safari. The elephant sightings are a guarantee during the summer months.The river is suited for rafting sports.");
            System.out.println("\n\n\t8. Kemmanagundi Hills\n\t   Rating : 3.9/5.0\n\tAccommodation : \n\tThe Last Resort\n\tHotel Ranga tana\nIt's a lovely place to visit during June to December. It's very attractive with all 3 sides covered with forest and other side is a path to walk.A small temple is attached to the falls, which seems to be beautiful during rainy season.");
	    }
	}
}

class LongTrip
{   
   void display()
    {
   	    System.out.println("According to your choice, the list of places : ");
   	    System.out.println("\n\n\t1. Mysore\n\t   Rating : 3.9/5.0\n\tAccommodation : \n\tAashraya Homestay\n\tOsho Glimpse Mysore\nA perfect blend of the ancient architecture and modern city. Mysore is a very relaxing place with the feel of the small city and facilities of a metro city. Good hotels, good roads and excellent food. The palace is a must see for everyone.");
   	    System.out.println("\n\n\t2. Kumara Parvat\n\t   Rating : 4.1/5.0\n\tAccommodation : Hotel Akshayadhara\n\tVijay Comforts\nKumara parvatha is indeed a tough trek in Karnataka. You need to be properly equipped and prepared to take this trek.But the scenery while trekking is all worth it.");
        System.out.println("\n\n\t3. Mudumalai\n\t   Rating : 3.9/5.0\n\tAccommodation : \n\tSylvan Lodge\n\tKargudi Forest RestHouse\nThe place has a jeep safari that is conducted daily.The safari takes the visitors around the park for about 30 minutes inside the forest where one can see animals like bear,dear,monkey,bison,peacock,if lucky elephants and rarely tigers even.");
        System.out.println("\n\n\t4. Thrissur\n\t   Rating : 4.6/5.0\n\tAccommodation : \n\tHotel Puram International\n\tJoys Palace\nThe place of peace and unity.Its rich in culture.Thrissur pooram is one of the festivals in World which people even tourists love to watch. Is totally an experience.");
        System.out.println("\n\n\t5. Chitradurga\n\t   Rating : 4.2/5.0\n\tAccommodation : \n\tAmogha International Hotel\n\tHotel Mayura Yatri Nivas\nThe most famous landmark in Chitradurga is the Kalline Kote or translated it means Fort constructed with stones.  It has some epic reference to Ramayana.Chitradurga Fort is massive edifice, spread over almost 20 acres with almost 20 gates.  The current access road to this fort is through the city only.");
        System.out.println("\n\n\t6. Agumbe\n\t   Rating : 4.5/5.0\n\tAccommodation : \n\tDodda Mane\n\tMallye Residency\nThis is one of the beautiful places for nature lovers.There are a few view points,the sunset point, and waterfalls.Drive around Agumbe is fabulous.");
        System.out.println("\n\n\t7. Kodaikanal\n\t   Rating : 4.0/5.0\n\tAccommodation : \n\tVilla Retreat\n\tKodai Sunshine\nThere are lot many places of natural beauty like Coker's walk, Dolphin's nose, echo point, suicide point, silent valley, pine forests, guna caves, kodai lake and park. The best was Berijam lake around 20Km from kodai.");
        System.out.println("\n\n\t8. Athirappilly Falls\n\t   Rating : 4.5/5.0\n\tAccommodation : \n\tRainforest\n\tClirind Resort Athirappilly\nAthirapilly is the best waterfalls in South India.It's a real beauty and a visual treat to our eyes.It's the Niagara of this India.The main beauty is the enormous falls itself. Also downside of the falls is also beautiful.");
        System.out.println("\n\n\t9. Coimbatore\n\t   Rating : 4.1/5.0\n\tAccommodation : \n\tVijay Park Inn\n\tVivanta Surya,Coimbatore\nCoimbatore the place of fantasy and fun for me.I liked this place because of its climate and its moistness and breeze that captures every one's attention towards the place.");
        System.out.println("\n\n\t10. Hampi\n\t   Rating : 4.2/5.0\n\tAccommodation : \n\tLotus Riya\n\tVaibhav Homestay\nIt is an excellent tourist destination that has not yet been ravaged by mindless commercialisation. This little town is simply bursting at the seams with lovely temples, monuments and a rich air of history.");
        System.out.println("\n\n\t11. Ooty\n\t   Rating : 4.4/5.0\n\tAccommodation : \n\tFairstay Ooty\n\tZostel Ooty\nOoty is a best attractive cool place for all tourist lovers. Any person can feel something special from there.  It is surrounded by trees, central ooty lake is a huge expanse of water with boats. Mainly the beauty of there is a lot of gardens, mainly botanical gardens, rose gardens etc.");
        System.out.println("\n\n\t12. Goa\n\t   Rating : 4.6/5.0\n\tAccommodation : \n\tGoa Woodlands Hotel\n\tSantana Beach Resort\nI love this place. Mostly I spended the holidays in goa. Its really a super place for fun and enjoyment. I feel relaxed there. New year celebrations was always awesome.");
    }

	void FilterNature()
	{
		Scanner scan=new Scanner(System.in);
        System.out.println("What type of trip do you want?\n\t1.Adventure\n\t2.Scenic\n\t3.Historical and Heritage\n\t4.Hill Station\nChoose an option");
		int choice1;
		while(2>1)
		{
		    choice1=scan.nextInt();
		    if(choice1 <1 || choice1 > 4)
			    System.out.println("Please choose from given options\n");
		    else
			    break;
	    }
		if(choice1==1)
		{
			System.out.println("According to your choice the list of places are:");
	   	   	System.out.println("\n\n\t1. Goa\n\t   Rating : 4.6/5.0\nI love this place. Mostly I spended the holidays in goa. Its really a super place for fun and enjoyment. I feel relaxed there. New year celebrations was always awesome.");
            System.out.println("\n\n\t2. Agumbe\n\t   Rating : 4.5/5.0\n\tAccommodation : \n\tDodda Mane\n\tMallye Residency\nThis is one of the beautiful places for nature lovers.There are a few view points,the sunset point, and waterfalls.Drive around Agumbe is fabulous.");
            System.out.println("\n\n\t3. Kumara Parvat\n\t   Rating : 4.1/5.0\n\tAccommodation : Hotel Akshayadhara\n\tVijay Comforts\nKumara parvatha is indeed a tough trek in Karnataka. You need to be properly equipped and prepared to take this trek.But the scenery while trekking is all worth it.");
		}
	    else if(choice1==2)
	    {
	    	System.out.println("According to your choice the list of places are :");
	   		System.out.println("\n\n\t1. Goa\n\t   Rating : 4.6/5.0\n\tAccommodation : \n\tGoa Woodlands Hotel\n\tSantana Beach Resort\nI love this place. Mostly I spended the holidays in goa. Its really a super place for fun and enjoyment. I feel relaxed there. New year celebrations was always awesome.");
            System.out.println("\n\n\t2. Athirappilly Falls\n\t   Rating : 4.5/5.0\n\tAccommodation : \n\tRainforest\n\tClirind Resort Athirappilly\nAthirapilly is the best waterfalls in South India.It's a real beauty and a visual treat to our eyes.It's the Niagara of this India.The main beauty is the enormous falls itself. Also downside of the falls is also beautiful.");              
            System.out.println("\n\n\t3. Mudumalai\n\t   Rating : 3.9/5.0\n\tAccommodation : \n\tSylvan Lodge\n\tKargudi Forest RestHouse\nThe place has a jeep safari that is conducted daily.The safari takes the visitors around the park for about 30 minutes inside the forest where one can see animals like bear,dear,monkey,bison,peacock,if lucky elephants and rarely tigers even.");
	    }
	    else if(choice1==3)
	    {
	    	System.out.println("According to your choice the list of places are :");
	   		System.out.println("\n\n\t1. Chitradurga\n\t   Rating : 4.2/5.0\n\tAccommodation : \n\tAmogha International Hotel\n\tHotel Mayura Yatri Nivas\nThe most famous landmark in Chitradurga is the Kalline Kote or translated it means Fort constructed with stones.  It has some epic reference to Ramayana.Chitradurga Fort is massive edifice, spread over almost 20 acres with almost 20 gates.  The current access road to this fort is through the city only.");
            System.out.println("\n\n\t2. Thrissur\n\t   Rating : 4.6/5.0\n\tAccommodation : \n\tHotel Puram International\n\tJoys Palace\nThe place of peace and unity.Its rich in culture.Thrissur pooram is one of the festivals in World which people even tourists love to watch. Is totally an experience.");               
            System.out.println("\n\n\t3. Hampi\n\t   Rating : 4.2/5.0\n\tAccommodation : \n\tLotus Riya\n\tVaibhav Homestay\nIt is an excellent tourist destination that has not yet been ravaged by mindless commercialisation. This little town is simply bursting at the seams with lovely temples, monuments and a rich air of history.");
            System.out.println("\n\n\t4. Mysore\n\t   Rating : 3.9/5.0\n\tAccommodation : \n\tAashraya Homestay\n\tOsho Glimpse Mysore\nA perfect blend of the ancient architecture and modern city. Mysore is a very relaxing place with the feel of the small city and facilities of a metro city. Good hotels, good roads and excellent food. The palace is a must see for everyone.");
	    }
	    else 
	    {
	    	System.out.println("According to your choice the list of places are :");
	   		System.out.println("\n\n\t1. Ooty\n\t   Rating : 4.4/5.0\n\tAccommodation : \n\tFairstay Ooty\n\tZostel Ooty\nOoty is a best attractive cool place for all tourist lovers. Any person can feel something special from there.  It is surrounded by trees, central ooty lake is a huge expanse of water with boats. Mainly the beauty of there is a lot of gardens, mainly botanical gardens, rose gardens etc.");              
	   		System.out.println("\n\n\t2. Kodaikanal\n\t   Rating : 4.0/5.0\n\tAccommodation : \n\tVilla Retreat\n\tKodai Sunshine\nThere are lot many places of natural beauty like Coker's walk, Dolphin's nose, echo point, suicide point, silent valley, pine forests, guna caves, kodai lake and park. The best was Berijam lake around 20Km from kodai.");
            System.out.println("\n\n\t3. Coimbatore\n\t   Rating : 4.1/5.0\n\tAccommodation : \n\tVijay Park Inn\n\tVivanta Surya,Coimbatore\nCoimbatore the place of fantasy and fun for me.I liked this place because of its climate and its moistness and breeze that captures every one's attention towards the place.");
	    }
	}
	
	void FilterDistance()
	{
        System.out.println("Choose the distance\n\t1. Around 300km\n\t2.350-500km\nChoose an option");
        int choice1;
        Scanner scan=new Scanner(System.in);
		while(2>1)
		{
		    choice1=scan.nextInt();
		    if(choice1 <1 || choice1 > 2)
		    	System.out.println("\tPlease choose from given options\n");
		    else
			    break;
	    }
		if(choice1==1)
		{
			System.out.println("\tAccording to your choice the list of places are:\n1. Mysore\n2. Kumara Parvat\n3. Mudumalai\n4. Thrissur\n5. Chitradurga\n6. Agumbe\n");
		  	System.out.println("\n\n\t1. Mysore\n\t   Rating : 3.9/5.0\n\tAccommodation : \n\tAashraya Homestay\n\tOsho Glimpse Mysore\nA perfect blend of the ancient architecture and modern city. Mysore is a very relaxing place with the feel of the small city and facilities of a metro city. Good hotels, good roads and excellent food. The palace is a must see for everyone.");
		   	System.out.println("\n\n\t2. Kumara Parvat\n\t   Rating : 4.1/5.0\n\tAccommodation : Hotel Akshayadhara\n\tVijay Comforts\nKumara parvatha is indeed a tough trek in Karnataka. You need to be properly equipped and prepared to take this trek.But the scenery while trekking is all worth it.");
		   	System.out.println("\n\n\t3. Mudumalai\n\t   Rating : 3.9/5.0\n\tAccommodation : \n\tSylvan Lodge\n\tKargudi Forest RestHouse\nThe place has a jeep safari that is conducted daily.The safari takes the visitors around the park for about 30 minutes inside the forest where one can see animals like bear,dear,monkey,bison,peacock,if lucky elephants and rarely tigers even.");
	    	System.out.println("\n\n\t4. Thrissur\n\t   Rating : 4.6/5.0\n\tAccommodation : \n\tHotel Puram International\n\tJoys Palace\nThe place of peace and unity.Its rich in culture.Thrissur pooram is one of the festivals in World which people even tourists love to watch. Is totally an experience.");
            System.out.println("\n\n\t5. Chitradurga\n\t   Rating : 4.2/5.0\n\tAccommodation : \n\tAmogha International Hotel\n\tHotel Mayura Yatri Nivas\nThe most famous landmark in Chitradurga is the Kalline Kote or translated it means Fort constructed with stones.  It has some epic reference to Ramayana.Chitradurga Fort is massive edifice, spread over almost 20 acres with almost 20 gates.  The current access road to this fort is through the city only.");             
            System.out.println("\n\n\t6. Agumbe\n\t   Rating : 4.5/5.0\n\tAccommodation : \n\tDodda Mane\n\tMallye Residency\nThis is one of the beautiful places for nature lovers.There are a few view points,the sunset point, and waterfalls.Drive around Agumbe is fabulous.");
		}    
	    else 
	    {
	    	System.out.println("\tAccording to your choice the list of places are:\n1. Kodaikanal\n2. Athirappilly Falls\n3. Coimbatore\n4. Hampi\n5. OOty\n6. Goa\n");
	   		System.out.println("\n\n\t1. Kodaikanal\n\t   Rating : 4.0/5.0\n\tAccommodation : \n\tVilla Retreat\n\tKodai Sunshine\nThere are lot many places of natural beauty like Coker's walk, Dolphin's nose, echo point, suicide point, silent valley, pine forests, guna caves, kodai lake and park. The best was Berijam lake around 20Km from kodai.");              
	   		System.out.println("\n\n\t2. Athirappilly Falls\n\t   Rating : 4.5/5.0\n\tAccommodation : \n\tRainforest\n\tClirind Resort Athirappilly\nAthirapilly is the best waterfalls in South India.It's a real beauty and a visual treat to our eyes.It's the Niagara of this India.The main beauty is the enormous falls itself. Also downside of the falls is also beautiful.");
            System.out.println("\n\n\t3. Coimbatore\n\t   Rating : 4.1/5.0\n\tAccommodation : \n\tVijay Park Inn\n\tVivanta Surya,Coimbatore\nCoimbatore the place of fantasy and fun for me.I liked this place because of its climate and its moistness and breeze that captures every one's attention towards the place.");
            System.out.println("\n\n\t4. Hampi\n\t   Rating : 4.2/5.0\n\tAccommodation : \n\tLotus Riya\n\tVaibhav Homestay\nIt is an excellent tourist destination that has not yet been ravaged by mindless commercialisation. This little town is simply bursting at the seams with lovely temples, monuments and a rich air of history.");
            System.out.println("\n\n\t5. Ooty\n\t   Rating : 4.4/5.0\n\tAccommodation : \n\tFairstay Ooty\n\tZostel Ooty\nOoty is a best attractive cool place for all tourist lovers. Any person can feel something special from there.  It is surrounded by trees, central ooty lake is a huge expanse of water with boats. Mainly the beauty of there is a lot of gardens, mainly botanical gardens, rose gardens etc.");
            System.out.println("\n\n\t6. Goa\n\t   Rating : 4.6/5.0\n\tAccommodation : \n\tGoa Woodlands Hotel\n\tSantana Beach Resort\nI love this place. Mostly I spended the holidays in goa. Its really a super place for fun and enjoyment. I feel relaxed there. New year celebrations was always awesome.");
	    }	
	}
}
	
class Bus
{
	public String Boarding,Destination;
	public double DepTime,ArrTime;
	public double Fare;
	public int BusNumber, noPass;
	
	public Bus(String b,String d,int bno,double dt,double at,double fare, int npass)
	{
		Boarding=b;
		Destination=d;
		BusNumber=bno;
		DepTime=dt;
		ArrTime=at;
		Fare=fare;
		noPass = npass;	
	}
}

class Buses
{	
	public int number=36;
	int i;

	public Bus Bs[]=new  Bus[100];

	Scanner in=new Scanner(System.in);

	Buses()
	{
		Menu();
	}

	public void Menu()
	{
		
		Bs[0]=new  Bus("	NITK","	Madikeri		       ",1001,03.45,07.25,300,0);
		Bs[1]=new  Bus("	NITK","        Kudremukh              ",1002,08.35,11.05,180,0);
		Bs[2]=new  Bus("	NITK","        Bandipur National Park ",1003,02.45,05.55,80,0);
		Bs[3]=new  Bus("	NITK","	Gokarna	               ",1004,14.55,18.25,320.50,0);
		Bs[4]=new  Bus("	NITK","	Devbagh		           ",1005,17.45,20.35,100,0);
		Bs[5]=new  Bus("	NITK","	Jog Falls		       ",1006,17.45,20.35,130,0);
		Bs[6]=new  Bus("	NITK","	Murdeshwar		       ",1007,06.35,09.35,220,0);
		Bs[7]=new  Bus("	NITK","	Bekal		           ",1101,05.05,07.35,100,0);
		Bs[8]=new  Bus("	NITK","	Shimoga		           ",1008,12.05,16.35,175,0);
		Bs[9]=new  Bus("	NITK","	Chikamagalur		   ",1009,02.05,06.35,200,0);
		Bs[10]=new  Bus("	NITK","	Coorg		           ",1010,08.25,11.35,210,0);
		Bs[11]=new  Bus("	NITK","	Kotagiri		       ",1011,09.35,12.55,150,0);
		Bs[12]=new  Bus("	NITK","	Dandeli      	       ",1012,02.05,10.35,320,0);
		Bs[13]=new  Bus("	NITK","	Yana		           ",1013,01.45,06.35,180,0);
		Bs[14]=new  Bus("	NITK","	Kabini		           ",1014,03.15,08.35,220,0);
		Bs[15]=new  Bus("	NITK","	Tusharagiri Falls	   ",1102,02.55,08.35,270,0);
		Bs[16]=new  Bus("	NITK","	Kemmanagundi Falls	   ",1015,12.55,18.35,280,0);
		Bs[17]=new  Bus("	NITK","	Silent Valley		   ",1103,11.35,19.35,230,0);
		Bs[18]=new  Bus("	NITK","	Edakkal Caves		   ",1104,13.35,19.35,300,0);
		Bs[19]=new  Bus("	NITK","	Badami		           ",1016,14.25,23.35,500,0);
		Bs[20]=new  Bus("	NITK","	Guruvayur Temple	   ",1105,03.15,11.35,450,0);
		Bs[21]=new  Bus("	NITK","	Nandi Hills		       ",1017,05.45,12.55,390,0);
		Bs[22]=new  Bus("	NITK","	Shivaganga Hills	   ",1018,17.15,23.35,370,0);
		Bs[23]=new  Bus("	NITK","	Kundadri Hills		   ",1019,10.55,13.50,260,0);
		Bs[24]=new  Bus("	NITK","	Mysore		           ",1020,12.35,19.35,670,0);
		Bs[25]=new  Bus("	NITK","	Kumara Parvat	       ",1021,06.55,11.05,480,0);
		Bs[26]=new  Bus("	NITK","	Mudumalai		       ",1201,01.45,09.35,570,0);
		Bs[27]=new  Bus("	NITK","	Thrissur		       ",1106,05.15,13.05,490,0);
		Bs[28]=new  Bus("	NITK","	Chitradurga		       ",1022,16.05,22.15,560,0);
		Bs[29]=new  Bus("	NITK","	Agumbe		           ",1023,08.15,11.10,190,0);
		Bs[30]=new  Bus("	NITK","	Kodaikanal		       ",1202,07.15,19.35,750,0);
		Bs[31]=new  Bus("	NITK","	Athirappilly Falls	   ",1107,12.15,21.25,670,0);
		Bs[32]=new  Bus("	NITK","	Coimbatore		       ",1203,14.25,23.35,700,0);
		Bs[33]=new  Bus("	NITK","	Hampi		           ",1024,10.05,19.25,700,0);
		Bs[34]=new  Bus("	NITK","	Ooty		           ",1204,01.25,10.25,560,0);
		Bs[35]=new  Bus("	NITK","	Goa		               ",1300,12.45,21.05,600,0);
	} 

	public void show()
	{
		System.out.println("S.No	Bus.No	Boarding-Point	Destination-Point	Dept-Time	Arr-Time	Fare\n\n");
		for(i=0;i<number;i++)
		{
			System.out.print(i+1+".	"+Bs[i].BusNumber+"	"+Bs[i].Boarding+"	   "+Bs[i].Destination+"       "+Bs[i].DepTime);
			System.out.println("		"+Bs[i].ArrTime+"		"+Bs[i].Fare);
		}
	}		    
}				
	
		    
		    