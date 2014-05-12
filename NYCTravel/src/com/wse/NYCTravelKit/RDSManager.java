package com.wse.NYCTravelKit;





import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.json.JSONArray;
import org.json.JSONObject;

import com.wse.NYCTravelKit.Yelp.Yelp;

import sun.util.locale.InternalLocaleBuilder;

public class RDSManager {
			
	public ArrayList<yelpDO> yelpDeveloperCheapDinner(double Latitude,double Longitude) {
		String consumerKey = "0Zn9dxuhMUyXoNB5WErI1w";
	    String consumerSecret = "nMYqpY1ZqSelxzGCT69WnoswNjU";
	    String token = "BVSsPFNspS-GWA3OmeeDreIGqK-KTFST";
	    String tokenSecret = "TijS_myGG1-EIlzNmY8LOxepETI";
	    ArrayList<yelpDO> yelpList = new ArrayList<yelpDO>();
	    Yelp yelp = new Yelp(consumerKey, consumerSecret, token, tokenSecret);
	    String response = yelp.search("cheap dinner", Latitude, Longitude);
	    
	    System.out.println(response);
	    
	    try{
	    	JSONObject mainJson = new JSONObject(response);
	    	JSONArray businesses = mainJson.getJSONArray("businesses");
	    	for (int i = 0; i < businesses.length(); i++) {
	    		yelpDO yDO = new yelpDO();
	    		JSONObject business = businesses.getJSONObject(i);
	    		yDO.setName(business.getString("name"));
	    		yDO.setReviewCnt(Integer.parseInt(business.getString("review_count")));
	    		yDO.setRating(Double.parseDouble(business.getString("rating")));
	    		yDO.setPhone(business.getString("display_phone"));
	    		JSONArray address = business.getJSONObject("location").getJSONArray("display_address");
	    		JSONObject coordinate = business.getJSONObject("location").getJSONObject("coordinate");
	    		yDO.setLatitude(Double.parseDouble(coordinate.getString("latitude")));
	    		yDO.setLongitude(Double.parseDouble(coordinate.getString("longitude")));
	    		String address_string = "";
	    		for (int j=0; j < address.length(); j++)
	    			address_string = address_string + address.getString(j) + " ";
	    		yDO.setAddress("address: " + address_string);
	    		yelpList.add(yDO);
	    	}	
	    }
	          catch(Exception e){
	        	  System.out.println(e);
	          
	          }
	    return yelpList;
	  }
	
	
	
	public ArrayList<yelpDO> yelpDeveloperGetCousine(String Cosine,double Latitude,double Longitude) {
		String consumerKey = "0Zn9dxuhMUyXoNB5WErI1w";
	    String consumerSecret = "nMYqpY1ZqSelxzGCT69WnoswNjU";
	    String token = "BVSsPFNspS-GWA3OmeeDreIGqK-KTFST";
	    String tokenSecret = "TijS_myGG1-EIlzNmY8LOxepETI";
	    ArrayList<yelpDO> yelpList = new ArrayList<yelpDO>();
	    Yelp yelp = new Yelp(consumerKey, consumerSecret, token, tokenSecret);
	    String response = yelp.search(Cosine, Latitude, Longitude);
	    
	    System.out.println(response);
	    
	    try{
	    	JSONObject mainJson = new JSONObject(response);
	    	JSONArray businesses = mainJson.getJSONArray("businesses");
	    	for (int i = 0; i < businesses.length(); i++) {
	    		yelpDO yDO = new yelpDO();
	    		JSONObject business = businesses.getJSONObject(i);
	    		yDO.setName(business.getString("name"));
	    		yDO.setReviewCnt(Integer.parseInt(business.getString("review_count")));
	    		yDO.setRating(Double.parseDouble(business.getString("rating")));
	    		yDO.setPhone(business.getString("display_phone"));
	    		JSONArray address = business.getJSONObject("location").getJSONArray("display_address");
	    		JSONObject coordinate = business.getJSONObject("location").getJSONObject("coordinate");
	    		yDO.setLatitude(Double.parseDouble(coordinate.getString("latitude")));
	    		yDO.setLongitude(Double.parseDouble(coordinate.getString("longitude")));
	    		String address_string = "";
	    		for (int j=0; j < address.length(); j++)
	    			address_string = address_string + address.getString(j) + " ";
	    		yDO.setAddress("address: " + address_string);
	    		yelpList.add(yDO);
	    	}	
	    }
	          catch(Exception e){
	        	  System.out.println(e);
	          
	          }
	    return yelpList;
	  }

	
	public ArrayList<yelpDO> yelpDeveloperBARS(double Latitude,double Longitude) {
		String consumerKey = "0Zn9dxuhMUyXoNB5WErI1w";
	    String consumerSecret = "nMYqpY1ZqSelxzGCT69WnoswNjU";
	    String token = "BVSsPFNspS-GWA3OmeeDreIGqK-KTFST";
	    String tokenSecret = "TijS_myGG1-EIlzNmY8LOxepETI";
	    ArrayList<yelpDO> yelpList = new ArrayList<yelpDO>();
	    Yelp yelp = new Yelp(consumerKey, consumerSecret, token, tokenSecret);
	    String response = yelp.search("bars", Latitude, Longitude);
	    
	    System.out.println(response);
	    
	    try{
	    	JSONObject mainJson = new JSONObject(response);
	    	JSONArray businesses = mainJson.getJSONArray("businesses");
	    	for (int i = 0; i < businesses.length(); i++) {
	    		yelpDO yDO = new yelpDO();
	    		JSONObject business = businesses.getJSONObject(i);
	    		yDO.setName(business.getString("name"));
	    		yDO.setReviewCnt(Integer.parseInt(business.getString("review_count")));
	    		yDO.setRating(Double.parseDouble(business.getString("rating")));
	    		yDO.setPhone(business.getString("display_phone"));
	    		JSONArray address = business.getJSONObject("location").getJSONArray("display_address");
	    		JSONObject coordinate = business.getJSONObject("location").getJSONObject("coordinate");
	    		yDO.setLatitude(Double.parseDouble(coordinate.getString("latitude")));
	    		yDO.setLongitude(Double.parseDouble(coordinate.getString("longitude")));
	    		String address_string = "";
	    		for (int j=0; j < address.length(); j++)
	    			address_string = address_string + address.getString(j) + " ";
	    		yDO.setAddress("address: " + address_string);
	    		yelpList.add(yDO);
	    	}	
	    }
	          catch(Exception e){
	        	  System.out.println(e);
	          
	          }
	    return yelpList;
	  }

	//Tourist Locations
			public ArrayList<TouristLocationDO> getAllNearTouristLocations(double Latitude,double Longitude) {
				ArrayList<TouristLocationDO> touristList = new ArrayList<TouristLocationDO>();
				Connection myConnection=getConnection();
				PreparedStatement ps=null;
				ResultSet resultSet=null;
				if(myConnection!=null){
					try {
						ps=myConnection.prepareStatement("SELECT * FROM museums_and_galleries WHERE ABS(longitude - ("+Longitude+")) < 0.01 AND ABS(latitude - ("+Latitude+")) < 0.01");
						resultSet=ps.executeQuery();
						while(resultSet!=null){
							resultSet.next();
							TouristLocationDO tlDO = new TouristLocationDO();
							tlDO.setLatitude(resultSet.getDouble(12));
							tlDO.setLongitude(resultSet.getDouble(11));
							tlDO.setTourist_staddress1(resultSet.getString(6));
							tlDO.setTourist_staddress2(resultSet.getString(7));
							tlDO.setTourist_telephone(resultSet.getString(4));
							tlDO.setTourist_url(resultSet.getString(5));
							tlDO.setTourist_locality(resultSet.getString(8));
							tlDO.setTourist_id(resultSet.getInt(1));
							tlDO.setTourist_name(resultSet.getString(3));
							tlDO.setTourist_zip(resultSet.getInt(9));
							touristList.add(tlDO);
						}
					}catch (Exception e) {				
						e.printStackTrace();
					}finally{
						try{
							if(resultSet!=null) resultSet.close();
							if(myConnection!=null) myConnection.close();
							
						}catch(Exception e){
							e.printStackTrace();
						}
						
					}
					
				}
				return touristList;
			}
			
			public ArrayList<TouristLocationDO> getAllTouristLocations() {
				ArrayList<TouristLocationDO> touristList = new ArrayList<TouristLocationDO>();
				Connection myConnection=getConnection();
				PreparedStatement ps=null;
				ResultSet resultSet=null;
				if(myConnection!=null){
					try {
						ps=myConnection.prepareStatement("select * from wifi_location;");
						resultSet=ps.executeQuery();
						while(resultSet!=null){
							resultSet.next();
							TouristLocationDO tlDO = new TouristLocationDO();
							tlDO.setLatitude(resultSet.getDouble(12));
							tlDO.setLongitude(resultSet.getDouble(11));
							tlDO.setTourist_staddress1(resultSet.getString(6));
							tlDO.setTourist_staddress2(resultSet.getString(7));
							tlDO.setTourist_telephone(resultSet.getString(4));
							tlDO.setTourist_url(resultSet.getString(5));
							tlDO.setTourist_locality(resultSet.getString(8));
							tlDO.setTourist_id(resultSet.getInt(1));
							tlDO.setTourist_name(resultSet.getString(3));
							tlDO.setTourist_zip(resultSet.getInt(9));
							touristList.add(tlDO);
						}
					}catch (Exception e) {				
						e.printStackTrace();
					}finally{
						try{
							if(resultSet!=null) resultSet.close();
							if(myConnection!=null) myConnection.close();
							
						}catch(Exception e){
							e.printStackTrace();
						}
						
					}
					
				}
				return touristList;
			}
			
			//Health Center Locations
					public ArrayList<HealthLocationDO> getAllNearHealthLocations(double Latitude,double Longitude) {
						ArrayList<HealthLocationDO> healthList = new ArrayList<HealthLocationDO>();
						Connection myConnection=getConnection();
						PreparedStatement ps=null;
						ResultSet resultSet=null;
						if(myConnection!=null){
							try {
								ps=myConnection.prepareStatement("SELECT * FROM community_health_centers WHERE ABS(longitude - ("+Longitude+")) < 0.08 AND ABS(latitude - ("+Latitude+")) < 0.08");
								resultSet=ps.executeQuery();
								while(resultSet!=null){
									resultSet.next();
									HealthLocationDO hlDO = new HealthLocationDO();
									hlDO.setLatitude(resultSet.getDouble(10));
									hlDO.setLongitude(resultSet.getDouble(9));
									hlDO.setHealth_name(resultSet.getString(3));
									hlDO.setHealth_staddress(resultSet.getString(4));
									hlDO.setHealth_borough(resultSet.getString(2));
									hlDO.setHealth_telephone(resultSet.getString(7));
									hlDO.setHealth_id(resultSet.getInt(1));
									hlDO.setHealth_zip(resultSet.getInt(5));
									healthList.add(hlDO);
								}
							}catch (Exception e) {				
								e.printStackTrace();
							}finally{
								try{
									if(resultSet!=null) resultSet.close();
									if(myConnection!=null) myConnection.close();
									
								}catch(Exception e){
									e.printStackTrace();
								}
								
							}
							
						}
						return healthList;
					}
					
					public ArrayList<HealthLocationDO> getAllHealthLocations() {
						ArrayList<HealthLocationDO> healthList = new ArrayList<HealthLocationDO>();
						Connection myConnection=getConnection();
						PreparedStatement ps=null;
						ResultSet resultSet=null;
						if(myConnection!=null){
							try {
								ps=myConnection.prepareStatement("select * from wifi_location;");
								resultSet=ps.executeQuery();
								while(resultSet!=null){
									resultSet.next();
									HealthLocationDO hlDO = new HealthLocationDO();
									hlDO.setLatitude(resultSet.getDouble(10));
									hlDO.setLongitude(resultSet.getDouble(9));
									hlDO.setHealth_name(resultSet.getString(3));
									hlDO.setHealth_staddress(resultSet.getString(4));
									hlDO.setHealth_borough(resultSet.getString(2));
									hlDO.setHealth_telephone(resultSet.getString(7));
									hlDO.setHealth_id(resultSet.getInt(1));
									hlDO.setHealth_zip(resultSet.getInt(5));
									healthList.add(hlDO);
								}
							}catch (Exception e) {				
								e.printStackTrace();
							}finally{
								try{
									if(resultSet!=null) resultSet.close();
									if(myConnection!=null) myConnection.close();
									
								}catch(Exception e){
									e.printStackTrace();
								}
								
							}
							
						}
						return healthList;
					}
		
					//Broadway Shows
					public ArrayList<BroadwayShowDO> getAllNearBroadwayLocations(double Latitude,double Longitude) {
						ArrayList<BroadwayShowDO> showList = new ArrayList<BroadwayShowDO>();
						Connection myConnection=getConnection();
						PreparedStatement ps=null;
						ResultSet resultSet=null;
						if(myConnection!=null){
							try {
								ps=myConnection.prepareStatement("SELECT * FROM broadway_shows WHERE ABS(longitude - ("+Longitude+")) < 0.01 AND ABS(latitude - ("+Latitude+")) < 0.01");
								resultSet=ps.executeQuery();
								while(resultSet!=null){
									resultSet.next();
									BroadwayShowDO bsDO = new BroadwayShowDO();
									bsDO.setLatitude(resultSet.getDouble(6));
									bsDO.setLongitude(resultSet.getDouble(5));
									bsDO.setShow_staddress(resultSet.getString(4));
									bsDO.setShow_city(resultSet.getString(7));
									bsDO.setShow_theatre(resultSet.getString(3));
									bsDO.setShow_opening(resultSet.getString(9));
									bsDO.setShow_capacity(resultSet.getInt(8));
									bsDO.setShow_name(resultSet.getString(2));
									bsDO.setShow_id(resultSet.getInt(1));
									showList.add(bsDO);
								}
							}catch (Exception e) {				
								e.printStackTrace();
							}finally{
								try{
									if(resultSet!=null) resultSet.close();
									if(myConnection!=null) myConnection.close();
									
								}catch(Exception e){
									e.printStackTrace();
								}
								
							}
							
						}
						return showList;
					}
					
					
					public ArrayList<BroadwayShowDO> BroadwayShowDO() {
						ArrayList<BroadwayShowDO> showList = new ArrayList<BroadwayShowDO>();
						Connection myConnection=getConnection();
						PreparedStatement ps=null;
						ResultSet resultSet=null;
						if(myConnection!=null){
							try {
								ps=myConnection.prepareStatement("select * from wifi_location;");
								resultSet=ps.executeQuery();
								while(resultSet!=null){
									resultSet.next();
									BroadwayShowDO bsDO = new BroadwayShowDO();
									bsDO.setLatitude(resultSet.getDouble(6));
									bsDO.setLongitude(resultSet.getDouble(5));
									bsDO.setShow_staddress(resultSet.getString(4));
									bsDO.setShow_city(resultSet.getString(7));
									bsDO.setShow_theatre(resultSet.getString(3));
									bsDO.setShow_opening(resultSet.getString(9));
									bsDO.setShow_capacity(resultSet.getInt(8));
									bsDO.setShow_name(resultSet.getString(2));
									bsDO.setShow_id(resultSet.getInt(1));
									showList.add(bsDO);
								}
							}catch (Exception e) {				
								e.printStackTrace();
							}finally{
								try{
									if(resultSet!=null) resultSet.close();
									if(myConnection!=null) myConnection.close();
									
								}catch(Exception e){
									e.printStackTrace();
								}
								
							}
							
						}
						return showList;
					}
	
	public ArrayList<subwayDO> getAllNearSubwayEntrance(double Latitude,double Longitude) {
		ArrayList<subwayDO> subwayList = new ArrayList<subwayDO>();
		Connection myConnection=getConnection();
		PreparedStatement ps=null;
		ResultSet resultSet=null;
		if(myConnection!=null){
			try {
				ps=myConnection.prepareStatement("SELECT * FROM nycdb.subway_entrance WHERE ABS(longitude - ("+Longitude+")) < 0.008 AND ABS(latitude - ("+Latitude+")) < 0.008;");
				resultSet=ps.executeQuery();
				while(resultSet!=null){
					resultSet.next();
					subwayDO subwayDO = new subwayDO();
					subwayDO.setCorner(resultSet.getString(29));
					subwayDO.setEastWestStreet(resultSet.getString(28));
					subwayDO.setEntranceType(resultSet.getString(18));
					if(resultSet.getInt(19) == 1){
						subwayDO.setEntryOnlyGate("Yes");
					}else{
						subwayDO.setEntryOnlyGate("No");
					}
					if(resultSet.getInt(20) == 1){
						subwayDO.setExitOnlyGate("Yes");
					}else{
						subwayDO.setExitOnlyGate("No");
					}
					subwayDO.setFreeCrossover(resultSet.getString(26));
					subwayDO.setLatitude(resultSet.getDouble(5));
					subwayDO.setLongitude(resultSet.getDouble(6));
					subwayDO.setName(resultSet.getString(4));
					subwayDO.setNorthSouthStreet(resultSet.getString(27));
					subwayDO.setPostalCode(resultSet.getInt(30));
					if(resultSet.getString(7)!=null){
						if(resultSet.getString(8)!=null){
							if(resultSet.getString(9)!=null){
								if (resultSet.getString(10)!=null){
									if (resultSet.getString(11)!=null){
										if (resultSet.getString(12)!=null){
											if (resultSet.getString(13)!=null){
												if (resultSet.getString(14)!=null){
													if (resultSet.getString(15)!=null){
														if (resultSet.getString(16)!=null){
															if(resultSet.getString(17)!=null){
																subwayDO.setRoutes(resultSet.getString(7)+","+resultSet.getString(8)+","+resultSet.getString(9)+","+resultSet.getString(10)+","+resultSet.getString(11)+","+resultSet.getString(12)+","+resultSet.getString(13)+","+resultSet.getString(14)+","+resultSet.getString(15)+","+resultSet.getString(16)+","+resultSet.getString(17));
															}else
																subwayDO.setRoutes(resultSet.getString(7)+","+resultSet.getString(8)+","+resultSet.getString(9)+","+resultSet.getString(10)+","+resultSet.getString(11)+","+resultSet.getString(12)+","+resultSet.getString(13)+","+resultSet.getString(14)+","+resultSet.getString(15)+","+resultSet.getString(16));
														}else{
															subwayDO.setRoutes(resultSet.getString(7)+","+resultSet.getString(8)+","+resultSet.getString(9)+","+resultSet.getString(10)+","+resultSet.getString(11)+","+resultSet.getString(12)+","+resultSet.getString(13)+","+resultSet.getString(14)+","+resultSet.getString(15));
														}
													}else{
														subwayDO.setRoutes(resultSet.getString(7)+","+resultSet.getString(8)+","+resultSet.getString(9)+","+resultSet.getString(10)+","+resultSet.getString(11)+","+resultSet.getString(12)+","+resultSet.getString(13)+","+resultSet.getString(14));
													}
												}else{
													subwayDO.setRoutes(resultSet.getString(7)+","+resultSet.getString(8)+","+resultSet.getString(9)+","+resultSet.getString(10)+","+resultSet.getString(11)+","+resultSet.getString(12)+","+resultSet.getString(13));
												}
											}else{
												subwayDO.setRoutes(resultSet.getString(7)+","+resultSet.getString(8)+","+resultSet.getString(9)+","+resultSet.getString(10)+","+resultSet.getString(11)+","+resultSet.getString(12));
											}
										}else{
											subwayDO.setRoutes(resultSet.getString(7)+","+resultSet.getString(8)+","+resultSet.getString(9)+","+resultSet.getString(10)+","+resultSet.getString(11));
										}
									}else{
										subwayDO.setRoutes(resultSet.getString(7)+","+resultSet.getString(8)+","+resultSet.getString(9)+","+resultSet.getString(10));
									}
								}else{
									subwayDO.setRoutes(resultSet.getString(7)+","+resultSet.getString(8)+","+resultSet.getString(9));
								}
							} else{
								subwayDO.setRoutes(resultSet.getString(7)+","+resultSet.getString(8));
							}
						}else{
							subwayDO.setRoutes(resultSet.getString(7));
						} 
					}
					if(resultSet.getInt(21) == 1){
						subwayDO.setVendingMachineExist("Yes");
					}else{
						subwayDO.setVendingMachineExist("No");
					}
					subwayDO.setStaffing(resultSet.getString(22));
					subwayDO.setLine(resultSet.getString(3));
					subwayList.add(subwayDO);
				}
			}catch (Exception e) {				
				e.printStackTrace();
			}finally{
				try{
					if(resultSet!=null) resultSet.close();
					if(myConnection!=null) myConnection.close();
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			
		}
		return subwayList;
	}
	
	
	
	public ArrayList<restaurantInfoDO> getAllNearRestaurants(double Latitude,double Longitude) {
		ArrayList<restaurantInfoDO> restaurantList = new ArrayList<restaurantInfoDO>();
		Connection myConnection=getConnection();
		PreparedStatement ps=null;
		ResultSet resultSet=null;
		if(myConnection!=null){
			try {
				ps=myConnection.prepareStatement("SELECT * FROM nycdb.`restaurant-information-results` WHERE ABS(longitude - ("+Longitude+")) < 0.003 AND ABS(latitude - ("+Latitude+")) < 0.003;");
				resultSet=ps.executeQuery();
				while(resultSet!=null){
					resultSet.next();
					restaurantInfoDO restDO = new restaurantInfoDO();
					restDO.setAddressLocality(resultSet.getString(5));
					restDO.setCity(resultSet.getString(13));
					restDO.setCusineDesc(resultSet.getString(47));
					restDO.setDeliverable(resultSet.getString(2));
					restDO.setLatitude(resultSet.getDouble(40));
					restDO.setLongitude(resultSet.getDouble(41));
					restDO.setName(resultSet.getString(3));
					restDO.setPostalCode(resultSet.getInt(7));
					restDO.setState(resultSet.getString(14));
					restDO.setStreetAddress(resultSet.getString(4));
					restDO.setTelephone(resultSet.getString(8));
					restDO.setZIPCode(resultSet.getInt(16));
					restaurantList.add(restDO);
				}
			}catch (Exception e) {				
				e.printStackTrace();
			}finally{
				try{
					if(resultSet!=null) resultSet.close();
					if(myConnection!=null) myConnection.close();
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			
		}
		return restaurantList;
	}
	
	
	public ArrayList<WifiLocationDO> getAllNearWifiLocations(double Latitude,double Longitude) {
		ArrayList<WifiLocationDO> wifiList = new ArrayList<WifiLocationDO>();
		Connection myConnection=getConnection();
		PreparedStatement ps=null;
		ResultSet resultSet=null;
		if(myConnection!=null){
			try {
				ps=myConnection.prepareStatement("SELECT * FROM wifi_location WHERE ABS(longitude - ("+Longitude+")) < 0.01 AND ABS(latitude - ("+Latitude+")) < 0.01");
				resultSet=ps.executeQuery();
				while(resultSet!=null){
					resultSet.next();
					WifiLocationDO wlDO = new WifiLocationDO();
					wlDO.setLatitude(resultSet.getDouble(6));
					wlDO.setLongitude(resultSet.getDouble(7));
					wlDO.setWifi_address(resultSet.getString(3));
					wlDO.setWifi_city(resultSet.getString(4));
					wlDO.setWifi_id(resultSet.getInt(1));
					wlDO.setWifi_name(resultSet.getString(2));
					wlDO.setWifi_type(resultSet.getString(8));
					wlDO.setWifi_zip(resultSet.getInt(5));
					wifiList.add(wlDO);
				}
			}catch (Exception e) {				
				e.printStackTrace();
			}finally{
				try{
					if(resultSet!=null) resultSet.close();
					if(myConnection!=null) myConnection.close();
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			
		}
		return wifiList;
	}
	
	
	
	public ArrayList<WifiLocationDO> getAllWifiLocations() {
		ArrayList<WifiLocationDO> wifiList = new ArrayList<WifiLocationDO>();
		Connection myConnection=getConnection();
		PreparedStatement ps=null;
		ResultSet resultSet=null;
		if(myConnection!=null){
			try {
				ps=myConnection.prepareStatement("select * from wifi_location;");
				resultSet=ps.executeQuery();
				while(resultSet!=null){
					resultSet.next();
					WifiLocationDO wlDO = new WifiLocationDO();
					wlDO.setLatitude(resultSet.getDouble(6));
					wlDO.setLongitude(resultSet.getDouble(7));
					wlDO.setWifi_address(resultSet.getString(3));
					wlDO.setWifi_city(resultSet.getString(4));
					wlDO.setWifi_id(resultSet.getInt(1));
					wlDO.setWifi_name(resultSet.getString(2));
					wlDO.setWifi_type(resultSet.getString(8));
					wlDO.setWifi_zip(resultSet.getInt(5));
					wifiList.add(wlDO);
				}
			}catch (Exception e) {				
				e.printStackTrace();
			}finally{
				try{
					if(resultSet!=null) resultSet.close();
					if(myConnection!=null) myConnection.close();
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			
		}
		return wifiList;
	}
	
	//get connection
	public Connection getConnection(){
		Connection myConnection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//String url="jdbc:mysql://localhost/pinterest?"+"user=root&password=admin";	
			String url= "jdbc:mysql://nycdbinstance.ctucxy7x4taw.us-east-1.rds.amazonaws.com/nycdb?"+"user=admin&password=password";
			myConnection = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}catch (SQLException e) {			
			e.printStackTrace();
		}		
		return myConnection;
	}
}

