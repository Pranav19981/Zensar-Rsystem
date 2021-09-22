package com.dao;

import java.util.List;

import com.model.Restaurant;

public interface RestaurantDao {
	List<Restaurant> getAllRestaurants();
	int addRestaurant(Restaurant rs);
	int deleteRestaurant(Restaurant rs);
	int updateRestaurant(Restaurant rs);
	List<Restaurant> searchRestaurant(Restaurant rs);
}


