package com.dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.configuration.ConnectionFactory;
import com.model.Restaurant;

public class RestaurantDaoImplementation implements RestaurantDao {
	 ConnectionFactory connectionFactory;

	public RestaurantDaoImplementation() {

		 connectionFactory = new ConnectionFactory();
	}
	
	@Override
	public List<Restaurant> getAllRestaurants() {
		
		ArrayList<Restaurant> restaurantList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String QUERY = "select * from rest where status=1";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(QUERY);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				Restaurant restaurant = new Restaurant();
				restaurant.setName(resultSet.getString("name"));
				restaurant.setOtime(resultSet.getString("otime"));
				restaurant.setCtime(resultSet.getString("ctime"));
				restaurant.setPhone(resultSet.getString("phone"));
				restaurant.setAddr(resultSet.getString("addr"));
				restaurant.setCuisine(resultSet.getString("cuisine"));
				restaurantList.add(restaurant);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return restaurantList;
	}

	@Override
	public int addRestaurant(Restaurant rs) 
	{
		
		int status = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement("insert into rest values(?,?,?,?,?,?,?)");
			
			
			preparedStatement.setString(1, rs.getName());
			preparedStatement.setString(2, rs.getOtime());
			preparedStatement.setString(3, rs.getCtime());
			preparedStatement.setString(4, rs.getPhone());
			preparedStatement.setString(5, rs.getAddr());
			preparedStatement.setString(6, rs.getCuisine());
			preparedStatement.setInt(7, rs.getStatus());
			status=preparedStatement.executeUpdate();
				
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		} finally {
				try {
					if(preparedStatement!=null)
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(connection!=null)
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		// TODO Auto-generated method stub
		return status;
	
	}

	@Override
	public int deleteRestaurant(Restaurant rs) {
		
			   int statusdelete=0;
			  Connection connection=null;
			  PreparedStatement preparedStatment=null;
			  try {
	                     connection=ConnectionFactory.getConnection();
	                     preparedStatment=connection.prepareStatement("Delete from rest where name=?");
	                     preparedStatment.setString(1, rs.getName());
	                     statusdelete=preparedStatment.executeUpdate();
			  }catch(SQLException | ClassNotFoundException e)
			  {
				  e.printStackTrace();
			  }finally {
					try {
						if(preparedStatment!=null)
							preparedStatment.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						if(connection!=null)
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			  }
			  
		// TODO Auto-generated method stub
		return statusdelete;
	
			  }

	@Override
	public int updateRestaurant(Restaurant rs) {
		int status2=0;
		 Connection connection=null;
		  PreparedStatement preparedStatment=null;
		  try {
			 connection=ConnectionFactory.getConnection();
			 preparedStatment=connection.prepareStatement("update rest SET otime=?,ctime=?,phone=?,addr=?,cuisine=? Where name=?");
			// preparedStatment.setString(1, rs.getName());
			 preparedStatment.setString(1, rs.getOtime());
			 preparedStatment.setString(2, rs.getCtime());
			 preparedStatment.setString(3, rs.getPhone());
			 preparedStatment.setString(4, rs.getAddr());
			 preparedStatment.setString(5, rs.getCuisine());
			 preparedStatment.setString(6, rs.getName());
			 status2=preparedStatment.executeUpdate();
			
			
			  
		  }
		  catch(SQLException | ClassNotFoundException e)
		  {
			  e.printStackTrace();
		  }finally {
			  try {
			       if(preparedStatment!=null)
			    	  preparedStatment.close();
			  }
			  catch(SQLException e)
			  {
				  e.printStackTrace();
			  }
			  try
			  {
				   if(connection!=null)
					   connection.close();
			  }
			  catch(SQLException e)
			  {
				  e.printStackTrace();
			  }
		  }
            		
		  return status2;
	}

	@Override
	public Restaurant  searchRestaurant(String rs) {
		// TODO Auto-generated method stub
		//ArrayList<Restaurant> restaurantList1 = new ArrayList<>();
		
		  Connection connection=null;
		  PreparedStatement preparedStatment=null;
		  ResultSet resultSet = null;
		  Restaurant restaurant=null;
		  try {
                    connection=ConnectionFactory.getConnection();
                    preparedStatment=connection.prepareStatement("select * from rest where name=?");
                    preparedStatment.setString(1, rs);
                    resultSet = preparedStatment.executeQuery();

        			while(resultSet.next()){
        				restaurant = new Restaurant();
        				restaurant.setName(resultSet.getString("name"));
        				restaurant.setOtime(resultSet.getString("otime"));
        				restaurant.setCtime(resultSet.getString("ctime"));
        				restaurant.setPhone(resultSet.getString("phone"));
        				restaurant.setAddr(resultSet.getString("addr"));
        				restaurant.setCuisine(resultSet.getString("cuisine"));
        				//restaurantList1.add(restaurant);
        			}
        			
                   // statussearch=preparedStatment.executeUpdate();
                    System.out.println("ji");
		  }catch(SQLException | ClassNotFoundException e)
		  {
			  e.printStackTrace();
		  }finally {
				try {
					if(preparedStatment!=null)
						preparedStatment.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(connection!=null)
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  }
		  
	// TODO Auto-generated method stub
	return restaurant;
	}
	}

	