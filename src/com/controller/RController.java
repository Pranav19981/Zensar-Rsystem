package com.controller;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import com.model.Restaurant;



import com.service.RestaurantService;
import com.service.RestaurantServiceImplementation;


public class RController {

	public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	
		
	      RestaurantService restaurantService= new RestaurantServiceImplementation();
	     
		List<Restaurant> restaurantList=restaurantService.getAllRestaurants();
		Iterator<Restaurant> itr=restaurantList.iterator();
				
		
		
		System.out.println("**********   All  Restaurant Name ***************");
		while (itr.hasNext()) {
			Restaurant restaurant = (Restaurant) itr.next();
			//System.out.println("Enter Restaurant IDe:- "+ restaurant.());
			System.out.println( restaurant.getName());
			/*System.out.println(" Restaurant Otime:- "+ restaurant.getOtime());
			System.out.println(" Restaurant Ctime:- "+ restaurant.getCtime());
			System.out.println(" Restaurant phone:- "+ restaurant.getPhone());
			System.out.println("**************************************");*/
			
		}
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
			System.out.println("Enter Restaurant Out time:- ");
			int restaurantOtime=scanner.nextInt();
			System.out.println("Enter Restaurant Close time:- ");
			int restaurantCtime=scanner.nextInt();
			System.out.println("Enter Restaurant Phone:- ");
			int restaurantPhone=scanner.nextInt();
			String rsphone=String.valueOf(restaurantPhone);
			
			 if(!rsphone.matches("\\d{10}"))
	    	 {
	    		 System.out.println("Enter valid  mobile number" );
	    	 }
	   	
			System.out.println("Enter Restaurant Address:- ");
			String restaurantAddr=scanner.next();
			System.out.println("Enter Restaurant Cuisine:- ");
			String restaurantCuisine=scanner.next();
			
			
			Restaurant rs=new Restaurant(restaurantName,restaurantOtime,restaurantCtime,restaurantPhone,restaurantAddr,restaurantCuisine);
			
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
			int restaurantOtime3=scanner.nextInt();
			System.out.println("Enter Restaurant Close time:- ");
			int restaurantCtime4=scanner.nextInt();
			System.out.println("Enter Restaurant Phone:- ");
			int restaurantPhone5=scanner.nextInt();
			System.out.println("Enter Restaurant Address:- ");
			String restaurantAddr6=scanner.next();
			System.out.println("Enter Restaurant Cuisine:- ");
			String restaurantCuisine7=scanner.next();
			//Restaurant rs2=new Restaurant(restaurantName2);
			Restaurant rs2=new Restaurant(restaurantName2,restaurantOtime3,restaurantCtime4,restaurantPhone5,restaurantAddr6,restaurantCuisine7);
			
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
			Restaurant rs3=new Restaurant(restaurantName3);
			List<Restaurant> restaurantList1=restaurantService.searchRestaurant(rs3);
			 
			Iterator<Restaurant> itr1=restaurantList.iterator();
			
			
			
			System.out.println("**********   All  Restaurant Name ***************");
			while (itr1.hasNext()) {
				Restaurant restaurant = (Restaurant) itr1.next();
				//System.out.println("Enter Restaurant IDe:- "+ restaurant.());
				System.out.println( restaurant.getName());
				System.out.println(" Restaurant Otime:- "+ restaurant.getOtime());
				System.out.println(" Restaurant Ctime:- "+ restaurant.getCtime());
				System.out.println(" Restaurant phone:- "+ restaurant.getPhone());
				System.out.println("**************************************");
				
			}
			break;
		default :
			System.out.println("Enter Valid Choice");
		}
		
	
	    
	}
}
