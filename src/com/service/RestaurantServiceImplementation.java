package com.service;


import java.util.List;

import com.dao.RestaurantDao;
import com.dao.RestaurantDaoImplementation;
import com.model.Restaurant;

public class RestaurantServiceImplementation implements RestaurantService {
	
	RestaurantDao restauranDao;
	

	public RestaurantServiceImplementation() {
	//	super();
		restauranDao=new RestaurantDaoImplementation();
	}

	public RestaurantServiceImplementation(RestaurantDao restauranDao) {
		super();
		this.restauranDao = restauranDao;
	}

	public RestaurantDao getRestauranDao() {
		return restauranDao;
	}

	public void setRestauranDao(RestaurantDao restauranDao) {
		this.restauranDao = restauranDao;
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		// TODO Auto-generated method stub
		return restauranDao.getAllRestaurants();
	}

	@Override
	public int addRestaurant(Restaurant rs) {
		// TODO Auto-generated method stub
		return restauranDao.addRestaurant(rs);
	}

	@Override
	public int deleteRestaurant(Restaurant rs) {
		// TODO Auto-generated method stub
		return restauranDao.deleteRestaurant(rs);
	}

	@Override
	public int updateRestaurant(Restaurant rs) {
		// TODO Auto-generated method stub
		return restauranDao.updateRestaurant(rs);
	}

	@Override
	public  List<Restaurant> searchRestaurant(Restaurant rs) {
		// TODO Auto-generated method stub
		return restauranDao.searchRestaurant(rs);
	}
	 
}