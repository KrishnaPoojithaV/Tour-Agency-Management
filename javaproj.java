import java.util.Scanner;
import Project.*;


public class javaproj
{
	public static void main(String[] args)
	{
	
		Scanner in=new Scanner(System.in);

		System.out.println("\n\n--------------------     WELCOME TO NITK ON WHEELS TOURS & TRAVELS     --------------------\n\n");

		int ModuleSelection;

		while(2>1)
		{
	     	System.out.println("Choose your Module\n");
			System.out.println("\t1.User Module\n\t2.Administrative Module\n\t3.Exit\n");
		
			while(2>1)
			{
				ModuleSelection=in.nextInt();

				if(ModuleSelection<1 || ModuleSelection>3)
					System.out.println("\tPlease choose from the available options only.");
				else
					break;
			}

			if(ModuleSelection==1)
			{
			    System.out.println("\nWelcome to the User Module.\n");

			    Project.UserModule user=new Project.UserModule();

			    System.out.println("\t1.Not yet Registered? Make an account now to avail our services.\n");
			    System.out.println("\t2.Have an existing account? Login to book your tour now.\n");

			    System.out.println("Choose your option.\n");

			    int UserStatus;

			    while(2>1)
			    {
				    UserStatus=in.nextInt();
 
				    if(UserStatus<1 || UserStatus>2)
					    System.out.println("\nPlease choose from the available options only.");
				    else
					    break;
			    }

			    if(UserStatus==1)
			    {
				    boolean t;
				    t=user.CreateAccount();
				    if(t==true)
					    UserStatus=2;
			    }
  
			    if(UserStatus==2)
			    {
				    System.out.println("\n\tPlease login to continue.");

				    boolean LoginDetails;
				    LoginDetails=user.LoginAccount();

				    if(LoginDetails==true)
				    {
					    System.out.print("\nYou have been logged in successfully. Here are the services offered by us :\n");
				        while(2>1)
				        {	
					        System.out.print("\n\t1.Select your Trip.\n\t2.Book your ticket.\n");
					        System.out.println("\t3.Cancel booked tickets.");
					        System.out.println("\t4.Logout and Exit the User Module");
					        System.out.println("\nChoose an option.");

					        int UserServices;

					        while(2>1)
					        {
						        UserServices=in.nextInt();

						        if(UserServices<1 || UserServices>4)
							        System.out.println("\nPlease choose from the available options only.");
						        else
							        break;
					        }

					        if(UserServices==1)
						        user.BusDetail();

					        else if(UserServices==2)
						        user.BookTickets();

					        else if(UserServices==3)
						        user.CancelTickets();

					        else
					        {
						        user.LogoutAccount();
						        System.out.println("\n\t\tThank you for using NITK ON WHEELS Tours & Travels.\n");
						        break;
					        }
				        }
				    }

				    else if(LoginDetails==false)
				    {
					    System.out.println("Sorry, we were not able to find an account with those details.\n");
					    System.out.println("\t1.Forgot password?\n");
					    System.out.println("\t2.In case you are not the user of the accout you tried to login, create a new account\n");
					    System.out.println("Choose an option.");
					    int FalseChoice;

					    while(2>1)
					    {
						    FalseChoice=in.nextInt();

						    if(FalseChoice<1 || FalseChoice>2)
							    System.out.println("\nPlease choose from the available options only.");
						    else
							    break;
					    }

					    if(FalseChoice==1)
						    user.ChangePassword();
					    else if(FalseChoice==2)
						    user.CreateAccount();
				    }
			    }
			}

		    else if(ModuleSelection==2)
	        {
			    System.out.println("\nWelcome to the Administrative Module.");

			    Project.AdminModule admin=new Project.AdminModule();

			    System.out.println("\nTo continue, please login.");

			    System.out.println("\t1.Are you a new staff member of NITK ON WHEELS Tours & Travels? Create an account now.");
			    System.out.println("\t2.Already have an account?	Login.");

			    int AdminStatus;
			    System.out.println("Choose an option.\n");

			    while(2>1)
			    {
				    AdminStatus=in.nextInt();

				    if(AdminStatus<1 || AdminStatus>2)
					    System.out.println("\nPlease choose from the available options only.");
				    else
					    break;
			    }

			    if(AdminStatus==1)
			    {
				    boolean t;

				    t=admin.CreateAccount();

				    if(t==true)
					    AdminStatus=2;
			    }

			    if(AdminStatus==2)
			    {
				    System.out.println("Please login to continue.\n");

				    boolean AdminLogin;

				    AdminLogin=admin.LoginAccount();

				    if(AdminLogin==true)
				    {
					    System.out.println("Here are the services available in this module.");
				        while(2>1)
				        {	
					        System.out.println("\n\t1.Introduce a new Bus \n\t2.Change fares of Buses");
					        System.out.println("\t3.Logout and Exit the Administrative Module\n");

					        int AdminService;

					        System.out.println("Choose your Service\n");

					        while(2>1)
					        {
						        AdminService=in.nextInt();

						        if(AdminService<1 || AdminService>4)
							        System.out.println("Please choose from the available options only.");
							    else
							        break;					
					        }

					        if(AdminService==1)
					        {
						        admin.AddBus();
						        System.out.println("Changes have been updated.\n");
					        }

					        else if(AdminService==2)
					        {
						        admin.ChangeFare();
						        System.out.println("Changes have been updated.\n");
					        }
					
					        else 
					        {
						        admin.LogoutAccount();
						        System.out.println("    Thank you for being a part of NITK ON WHEELS Tours & Travels.    \n");
						        break;
					        }
					    }

				    }

				    else if(AdminLogin==false)
				    {
					    System.out.println("\nWe were not able to find an account with the entered details.\n\n");
					    System.out.println("\t1.Forgot password?\n");
					    System.out.println("\t2.In case you are not the user of the accout you tried to login, create a new account\n");
					    System.out.println("Choose an option.");
					    int FalseChoice;

					    while(2>1)
					    {
						    FalseChoice=in.nextInt();

						    if(FalseChoice<1 || FalseChoice>2)
							    System.out.println("\nPlease choose from the available options only.");
						    else
							    break;
					    }

					    if(FalseChoice==1)
						    admin.ChangePassword();

					    else if(FalseChoice==2)
						    admin.CreateAccount();			
				    }
			    }
		    }

		    else
		    {
			     System.out.println("\n	Thank you & have a nice day. \n");
			     break;
		    }	
		    
		    System.out.println("\n	NITK ON WHEELS TOURS & TRAVELS      \n");
	    }
    }
}	
