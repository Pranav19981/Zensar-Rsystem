package com.controller;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.model.Restaurant;



import com.service.RestaurantService;
import com.service.RestaurantServiceImplementation;


public class RController {
	static String str;
	public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	
	       String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
	        Pattern p = Pattern.compile(regex);
	      RestaurantService restaurantService= new RestaurantServiceImplementation();
	     
		List<Restaurant> restaurantList=restaurantService.getAllRestaurants();
		Iterator<Restaurant> itr=restaurantList.iterator();
				
		System.out.println("**********   All  Active Restaurant Name ***************");
		while (itr.hasNext()) {
			Restaurant restaurant = (Restaurant) itr.next();
			//System.out.println("Enter Restaurant IDe:- "+ restaurant.());
			System.out.println( restaurant.getName());
			/*System.out.println(" Restaurant Otime:- "+ restaurant.getOtime());
			System.out.println(" Restaurant Ctime:- "+ restaurant.getCtime());
			System.out.println(" Restaurant phone:- "+ restaurant.getPhone());
			System.out.println("**************************************");*/
			
		}
		System.out.println(" ");
		
		
	
		
		do {
		System.out.println("Enter Your Choice");
		System.out.println("1.Add Restaurant");
		System.out.println("2.Delete Restaurant");
		System.out.println("3.Update Restaurant");
		System.out.println("4.Search Restaurant");
		int ch=scanner.nextInt();
		
		switch(ch)
		{
		case 1:
			System.out.println(" ");
			System.out.println("******* Enter  Restaurant information ************");
		
			System.out.println("Enter Restaurant Name:- ");
			String restaurantName=scanner.next();
			if( restaurantName!= null && restaurantName.matches("^[a-zA-Z0-9]*$"))
			{
				System.out.println("This is valid Restaurant ");
			}else
			{
				System.out.println("THis is Not Valid Restaurant Name :- ");
				System.out.println("Enter Restaurant Name Again:- ");
				 restaurantName=scanner.next();
			}
			System.out.println("Enter Restaurant Out time:- ");
			String restaurantOtime=scanner.next();
			
			//Matcher m = p.matcher(time);
			if(restaurantOtime.matches(regex))
			{
				System.out.println("This is Valid Time:- ");
			}else {
				System.out.println("This is not valid time Please Enter Valid Time:- ");
				System.out.println("Enter Restaurant Out time:- ");
				restaurantOtime=scanner.next();
			}
			
			System.out.println("Enter Restaurant Close time:- ");
			String restaurantCtime=scanner.next();
			
			
			
			
			if(restaurantCtime.matches(regex))
			{
				System.out.println("This is Valid Time:- ");
			}else {
				System.out.println("This is not valid time Please Enter Valid Time:- ");
				System.out.println("Enter Restaurant Out time:- ");
				restaurantCtime=scanner.next();
			}
			
			System.out.println("Enter Restaurant Phone:- ");
			String restaurantPhone=scanner.next();
			
			
			Pattern pattern = Pattern.compile(("(0/91)?[7-9][0-9]{9}"));
			Matcher match = pattern.matcher(restaurantPhone);
			
			
			
			 if(match.find() && match.group().equals(restaurantPhone))
	    	 {	
	    		 System.out.println("This is  valid  mobile number" );
	    	 }
			 else
			 {
				 System.out.println("This is  not valid  mobile number" );
				 System.out.println("Enter Restaurant Phone:- ");
					restaurantPhone=scanner.next();
					
			 }
	   	
			System.out.println("Enter Restaurant Address:- ");
			String restaurantAddr=scanner.next();
			System.out.println("Select Cuisine:- ");
			
			System.out.println("---------1.Indian:- ");
			System.out.println("---------2.Maxican:- ");
			System.out.println("---------3.Chineese:- ");
			System.out.println("---------4.Italian:- ");
			    int c=scanner.nextInt();
			    String restaurantCuisine=null;
			   switch(c) {
			   case 1:
				   restaurantCuisine="Indian";
				   break;
			   case 2:
				   restaurantCuisine="Maxican";
				   break;
			   case 3:
				   restaurantCuisine="Chineese";
				   break;
			   case 4:
				   restaurantCuisine="Italian";
				   break;
			   }
			
			
			
			
			
			System.out.println("Enter Restaurant Status:- ");
			
			System.out.println("---------1.Activate:- ");
			System.out.println("---------2.Deactivate:- ");
			int restatus=scanner.nextInt();
			
			 	
			
			
			
			
			Restaurant rs=new Restaurant(restaurantName,restaurantOtime,restaurantCtime,restaurantPhone,restaurantAddr,restaurantCuisine,restatus);
			
		    int status=restaurantService.addRestaurant(rs);
		    if(status>0) {
		    	System.out.println("Restaurant added sucessfully.....");
		    }else {
		    	System.out.println("Unable to add Restaurant.........");
		    }
		    break;
		case 2:
			System.out.println("Enter Restaurant to delete");
			String restaurantName1=scanner.next();
			 
			Restaurant rs1=new Restaurant(restaurantName1);
			 int status1=restaurantService.deleteRestaurant(rs1);
			 
			    if(status1>0) {
			    	System.out.println("Restaurant delete sucessfully.....");
			    }else {
			    	System.out.println("Unable to delete Restaurant.........");
			    }
		
			break;
		case 3:
			System.out.println("Enter Restaurant to update");
			String restaurantName2=scanner.next();
			//System.out.println("Enter Restaurant Name:- ");
			//String restaurantName22=scanner.next();
			System.out.println("Enter Restaurant Out time:- ");
			String restaurantOtime3=scanner.next();
			System.out.println("Enter Restaurant Close time:- ");
			String restaurantCtime4=scanner.next();
			System.out.println("Enter Restaurant Phone:- ");
			String restaurantPhone5=scanner.next();
			System.out.println("Enter Restaurant Address:- ");
			String restaurantAddr6=scanner.next();
			System.out.println("Enter Restaurant Cuisine:- ");
			String restaurantCuisine7=scanner.next();
			System.out.println("Enter Restaurant Status:- ");
			int  rstatus=scanner.nextInt();
			//Restaurant rs2=new Restaurant(restaurantName2);
			Restaurant rs2=new Restaurant(restaurantName2,restaurantOtime3,restaurantCtime4,restaurantPhone5,restaurantAddr6,restaurantCuisine7,rstatus);
			
int status2=restaurantService.updateRestaurant(rs2);
			
			 if(status2>0) {
			    	System.out.println("Restaurant Updated sucessfully.....");
			    }else {
			    	System.out.println("Unable to Updated Restaurant.........");
			    }
			
			 break;
		case 4:
			System.out.println("Search the Restaurant");
			String restaurantName3=scanner.next();
		//	Restaurant rs3=new Restaurant(restaurantName3);
			Restaurant restaruntDetails=restaurantService.searchRestaurant(restaurantName3);
			 
			if (restaruntDetails != null) {
			
			
			System.out.println("**********   All  Restaurant Name ***************");
			
			
				System.out.println( restaruntDetails.getName());
				System.out.println(" Restaurant Otime:- "+ restaruntDetails.getOtime());
				System.out.println(" Restaurant Ctime:- "+ restaruntDetails.getCtime());
				System.out.println(" Restaurant phone:- "+ restaruntDetails.getPhone());
				System.out.println(" Restaurant Address:- "+ restaruntDetails.getAddr());
				System.out.println(" Restaurant cuisine:- "+ restaruntDetails.getCuisine());
				System.out.println("**************************************");
			}else
			{
				System.out.println("Record not available");
			}
			
			break;
		default :
			System.out.println("Enter Valid Choice");
		}
		
		System.out.println();
		System.out.println("Do you wish to continue(y/n)?");
		str = scanner.next();
	} while (str.equals("y") || str.equals("Y"));
	    
	}
}
