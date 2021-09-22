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
		final String QUERY = "select * from rest";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(QUERY);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				Restaurant restaurant = new Restaurant();
				restaurant.setName(resultSet.getString("name"));
				restaurant.setOtime(resultSet.getInt("otime"));
				restaurant.setCtime(resultSet.getInt("ctime"));
				restaurant.setPhone(resultSet.getInt("phone"));
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
			preparedStatement = connection.prepareStatement("insert into rest values(?,?,?,?,?,?)");
			
			
			preparedStatement.setString(1, rs.getName());
			preparedStatement.setInt(2, rs.getOtime());
			preparedStatement.setInt(3, rs.getCtime());
			preparedStatement.setInt(4, rs.getPhone());
			preparedStatement.setString(5, rs.getAddr());
			preparedStatement.setString(6, rs.getCuisine());
			status=preparedStatement.executeUpdate();
			System.out.println("jii"+status);	
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
			 preparedStatment.setInt(1, rs.getOtime());
			 preparedStatment.setInt(2, rs.getCtime());
			 preparedStatment.setInt(3, rs.getPhone());
			 preparedStatment.setString(4, rs.getAddr());
			 preparedStatment.setString(5, rs.getCuisine());
			 preparedStatment.setString(6, rs.getName());
			 status2=preparedStatment.executeUpdate();
			
			System.out.println("jii"+status2);	
			  
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
	public List<Restaurant>  searchRestaurant(Restaurant rs) {
		// TODO Auto-generated method stub
		ArrayList<Restaurant> restaurantList1 = new ArrayList<>();
		 int statussearch=0;
		  Connection connection=null;
		  PreparedStatement preparedStatment=null;
		  ResultSet resultSet = null;
		  try {
                    connection=ConnectionFactory.getConnection();
                    preparedStatment=connection.prepareStatement("select * from rest where name=?");
                    preparedStatment.setString(1, rs.getName());
                    resultSet = preparedStatment.executeQuery();

        			
        				Restaurant restaurant = new Restaurant();
        				restaurant.setName(resultSet.getString("name"));
        				restaurant.setOtime(resultSet.getInt("otime"));
        				restaurant.setCtime(resultSet.getInt("ctime"));
        				restaurant.setPhone(resultSet.getInt("phone"));
        				restaurant.setAddr(resultSet.getString("addr"));
        				restaurant.setCuisine(resultSet.getString("cuisine"));
        				restaurantList1.add(restaurant);

        			
                    statussearch=preparedStatment.executeUpdate();
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
	return restaurantList1;
	}
	}

	