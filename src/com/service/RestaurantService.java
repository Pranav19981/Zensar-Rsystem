package com.service;

import java.util.List;

import com.model.Restaurant;

public interface RestaurantService {
	List<Restaurant> getAllRestaurants();
	int addRestaurant(Restaurant rs);
	int deleteRestaurant(Restaurant rs);
	int updateRestaurant(Restaurant rs);
	Restaurant  searchRestaurant(String rs);

}
