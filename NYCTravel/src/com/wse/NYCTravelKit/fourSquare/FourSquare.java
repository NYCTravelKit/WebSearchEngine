package com.wse.NYCTravelKit.fourSquare;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import com.wse.NYCTravelKit.FourSquareDO;
import com.wse.NYCTravelKit.TrendingPlaceDO;

public class FourSquare {
	public ArrayList<TrendingPlaceDO> searchTrendingVenue(double latitude, double longitude) {
		ArrayList<TrendingPlaceDO> tpList = new ArrayList<TrendingPlaceDO>();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    Date date = new Date();
	    OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.foursquare.com/v2/venues/trending");
	    request.addQuerystringParameter("oauth_token", "RT3RNXM5ZUMF11ACES3YNFRWEK30JN2YYNKQVB5LDFZ4WBJT");
	    request.addQuerystringParameter("ll", latitude + "," + longitude);
	    request.addQuerystringParameter("v",dateFormat.format(date));
	    Response response = request.send();
	    JSONObject mainJson;
		try {
			mainJson = new JSONObject(response.getBody());
			JSONObject res = mainJson.getJSONObject("response");
			JSONArray venues = res.getJSONArray("venues");
	    	for (int i = 0; i < venues.length(); i++) {
	    		JSONObject venue = venues.getJSONObject(i);
	    		TrendingPlaceDO tpDO = new TrendingPlaceDO();
	    		tpDO.setVenueName(venue.getString("name"));
	    		tpDO.setContactAddress(venue.getJSONObject("location").getString("address"));
	    		tpDO.setCity(venue.getJSONObject("location").getString("city"));
	    		tpDO.setLat(Double.parseDouble(venue.getJSONObject("location").getString("lat")));
	    		tpDO.setLng(Double.parseDouble(venue.getJSONObject("location").getString("lng")));
	    		tpDO.setStatCheckinCnt(Integer.parseInt(venue.getJSONObject("stats").getString("checkinsCount")));
	    		tpDO.setStatUserCnt(Integer.parseInt(venue.getJSONObject("stats").getString("usersCount")));
	    		tpDO.setStatTipCnt(Integer.parseInt(venue.getJSONObject("stats").getString("tipCount")));
	    		tpDO.setCurrPop(Integer.parseInt(venue.getJSONObject("hereNow").getString("count")));
	    		tpDO.setPostalCode(venue.getJSONObject("location").getString("postalCode"));
	    		tpList.add(tpDO);
	    	}	
	    	
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			
			
		}
		
		return tpList;
	  }
	
	
	public ArrayList<FourSquareDO> searchVenueArts(double latitude, double longitude){
		ArrayList<FourSquareDO> fsList = new ArrayList<FourSquareDO>();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    Date date = new Date();
	    OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.foursquare.com/v2/venues/explore");
	    request.addQuerystringParameter("oauth_token", "RT3RNXM5ZUMF11ACES3YNFRWEK30JN2YYNKQVB5LDFZ4WBJT");
	    request.addQuerystringParameter("section","arts");
	    request.addQuerystringParameter("novelty","new");
	    request.addQuerystringParameter("ll", latitude + "," + longitude);
	    request.addQuerystringParameter("v",dateFormat.format(date));
	    Response response = request.send();
	    	JSONObject mainJson;
			try {
				mainJson = new JSONObject(response.getBody());
		    	String group = mainJson.getJSONObject("response").getJSONArray("groups").toString();
		    	//group = group.replace(group.substring(group.length()-1), "");
		    	group = group.substring(0,group.length()-1);
		    	group = group.substring(1);
		    	JSONObject newJSON = new JSONObject(group);
		    	JSONArray items = newJSON.getJSONArray("items");
		    	for (int i = 0; i < items.length(); i++) {
		    		JSONObject item = items.getJSONObject(i);
		    		FourSquareDO fsDO = new FourSquareDO();
		    		fsDO.setVenueName(item.getJSONObject("venue").getString("name"));
		    		fsDO.setContactAddress(item.getJSONObject("venue").getJSONObject("location").getString("address"));
		    		fsDO.setCity(item.getJSONObject("venue").getJSONObject("location").getString("city"));
		    		fsDO.setRating(Double.parseDouble(item.getJSONObject("venue").getString("rating")));
		    		fsDO.setPhone(item.getJSONObject("venue").getJSONObject("contact").getString("formattedPhone"));
		    		fsDO.setLat(Double.parseDouble(item.getJSONObject("venue").getJSONObject("location").getString("lat")));
		    		fsDO.setLng(Double.parseDouble(item.getJSONObject("venue").getJSONObject("location").getString("lng")));
		    		fsDO.setStatCheckinCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("checkinsCount")));
		    		fsDO.setStatUserCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("usersCount")));
		    		fsDO.setStatTipCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("tipCount")));
		    		fsDO.setCurrPop(Integer.parseInt(item.getJSONObject("venue").getJSONObject("hereNow").getString("count")));
		    		fsList.add(fsDO);
		    	}	
		    	
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				
				
			}
		    	
			return fsList;
	    }
	         
	
	public ArrayList<FourSquareDO> searchVenueOutdoor(double latitude, double longitude){
		ArrayList<FourSquareDO> fsList = new ArrayList<FourSquareDO>();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    Date date = new Date();
	    OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.foursquare.com/v2/venues/explore");
	    request.addQuerystringParameter("oauth_token", "RT3RNXM5ZUMF11ACES3YNFRWEK30JN2YYNKQVB5LDFZ4WBJT");
	    request.addQuerystringParameter("section","outdoors");
	    request.addQuerystringParameter("novelty","new");
	    request.addQuerystringParameter("ll", latitude + "," + longitude);
	    request.addQuerystringParameter("v",dateFormat.format(date));
	    Response response = request.send();
	    	JSONObject mainJson;
			try {
				mainJson = new JSONObject(response.getBody());
		    	String group = mainJson.getJSONObject("response").getJSONArray("groups").toString();
		    	//group = group.replace(group.substring(group.length()-1), "");
		    	group = group.substring(0,group.length()-1);
		    	group = group.substring(1);
		    	JSONObject newJSON = new JSONObject(group);
		    	JSONArray items = newJSON.getJSONArray("items");
		    	for (int i = 0; i < items.length(); i++) {
		    		JSONObject item = items.getJSONObject(i);
		    		FourSquareDO fsDO = new FourSquareDO();
		    		fsDO.setVenueName(item.getJSONObject("venue").getString("name"));
		    		fsDO.setContactAddress(item.getJSONObject("venue").getJSONObject("location").getString("address"));
		    		fsDO.setCity(item.getJSONObject("venue").getJSONObject("location").getString("city"));
		    		fsDO.setRating(Double.parseDouble(item.getJSONObject("venue").getString("rating")));
		    		fsDO.setPhone(item.getJSONObject("venue").getJSONObject("contact").getString("formattedPhone"));
		    		fsDO.setLat(Double.parseDouble(item.getJSONObject("venue").getJSONObject("location").getString("lat")));
		    		fsDO.setLng(Double.parseDouble(item.getJSONObject("venue").getJSONObject("location").getString("lng")));
		    		fsDO.setStatCheckinCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("checkinsCount")));
		    		fsDO.setStatUserCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("usersCount")));
		    		fsDO.setStatTipCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("tipCount")));
		    		fsDO.setCurrPop(Integer.parseInt(item.getJSONObject("venue").getJSONObject("hereNow").getString("count")));
		    		fsList.add(fsDO);
		    	}	
		    	
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				
				
			}
		    	
			return fsList;
	    }
		
		
	public ArrayList<FourSquareDO> searchVenueFood(double latitude, double longitude){
		ArrayList<FourSquareDO> fsList = new ArrayList<FourSquareDO>();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    Date date = new Date();
	    OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.foursquare.com/v2/venues/explore");
	    request.addQuerystringParameter("oauth_token", "RT3RNXM5ZUMF11ACES3YNFRWEK30JN2YYNKQVB5LDFZ4WBJT");
	    request.addQuerystringParameter("section","food");
	    request.addQuerystringParameter("novelty","new");
	    request.addQuerystringParameter("ll", latitude + "," + longitude);
	    request.addQuerystringParameter("v",dateFormat.format(date));
	    Response response = request.send();
	    	JSONObject mainJson;
			try {
				mainJson = new JSONObject(response.getBody());
		    	String group = mainJson.getJSONObject("response").getJSONArray("groups").toString();
		    	//group = group.replace(group.substring(group.length()-1), "");
		    	group = group.substring(0,group.length()-1);
		    	group = group.substring(1);
		    	JSONObject newJSON = new JSONObject(group);
		    	JSONArray items = newJSON.getJSONArray("items");
		    	for (int i = 0; i < items.length(); i++) {
		    		JSONObject item = items.getJSONObject(i);
		    		FourSquareDO fsDO = new FourSquareDO();
		    		fsDO.setVenueName(item.getJSONObject("venue").getString("name"));
		    		fsDO.setContactAddress(item.getJSONObject("venue").getJSONObject("location").getString("address"));
		    		fsDO.setCity(item.getJSONObject("venue").getJSONObject("location").getString("city"));
		    		fsDO.setRating(Double.parseDouble(item.getJSONObject("venue").getString("rating")));
		    		fsDO.setPhone(item.getJSONObject("venue").getJSONObject("contact").getString("formattedPhone"));
		    		fsDO.setLat(Double.parseDouble(item.getJSONObject("venue").getJSONObject("location").getString("lat")));
		    		fsDO.setLng(Double.parseDouble(item.getJSONObject("venue").getJSONObject("location").getString("lng")));
		    		fsDO.setStatCheckinCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("checkinsCount")));
		    		fsDO.setStatUserCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("usersCount")));
		    		fsDO.setStatTipCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("tipCount")));
		    		fsDO.setCurrPop(Integer.parseInt(item.getJSONObject("venue").getJSONObject("hereNow").getString("count")));
		    		fsList.add(fsDO);
		    	}	
		    	
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				
				
			}
		    	
			return fsList;
	    }
	
	
	public ArrayList<FourSquareDO> searchVenueDrinks(double latitude, double longitude){
		ArrayList<FourSquareDO> fsList = new ArrayList<FourSquareDO>();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    Date date = new Date();
	    OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.foursquare.com/v2/venues/explore");
	    request.addQuerystringParameter("oauth_token", "RT3RNXM5ZUMF11ACES3YNFRWEK30JN2YYNKQVB5LDFZ4WBJT");
	    request.addQuerystringParameter("section","drinks");
	    request.addQuerystringParameter("novelty","new");
	    request.addQuerystringParameter("ll", latitude + "," + longitude);
	    request.addQuerystringParameter("v",dateFormat.format(date));
	    Response response = request.send();
	    	JSONObject mainJson;
			try {
				mainJson = new JSONObject(response.getBody());
		    	String group = mainJson.getJSONObject("response").getJSONArray("groups").toString();
		    	//group = group.replace(group.substring(group.length()-1), "");
		    	group = group.substring(0,group.length()-1);
		    	group = group.substring(1);
		    	JSONObject newJSON = new JSONObject(group);
		    	JSONArray items = newJSON.getJSONArray("items");
		    	for (int i = 0; i < items.length(); i++) {
		    		JSONObject item = items.getJSONObject(i);
		    		FourSquareDO fsDO = new FourSquareDO();
		    		fsDO.setVenueName(item.getJSONObject("venue").getString("name"));
		    		fsDO.setContactAddress(item.getJSONObject("venue").getJSONObject("location").getString("address"));
		    		fsDO.setCity(item.getJSONObject("venue").getJSONObject("location").getString("city"));
		    		fsDO.setRating(Double.parseDouble(item.getJSONObject("venue").getString("rating")));
		    		fsDO.setPhone(item.getJSONObject("venue").getJSONObject("contact").getString("formattedPhone"));
		    		fsDO.setLat(Double.parseDouble(item.getJSONObject("venue").getJSONObject("location").getString("lat")));
		    		fsDO.setLng(Double.parseDouble(item.getJSONObject("venue").getJSONObject("location").getString("lng")));
		    		fsDO.setStatCheckinCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("checkinsCount")));
		    		fsDO.setStatUserCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("usersCount")));
		    		fsDO.setStatTipCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("tipCount")));
		    		fsDO.setCurrPop(Integer.parseInt(item.getJSONObject("venue").getJSONObject("hereNow").getString("count")));
		    		fsList.add(fsDO);
		    	}	
		    	
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				
				
			}
		    	
			return fsList;
	    }
	
	
	public ArrayList<FourSquareDO> searchVenueShops(double latitude, double longitude){
		ArrayList<FourSquareDO> fsList = new ArrayList<FourSquareDO>();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    Date date = new Date();
	    OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.foursquare.com/v2/venues/explore");
	    request.addQuerystringParameter("oauth_token", "RT3RNXM5ZUMF11ACES3YNFRWEK30JN2YYNKQVB5LDFZ4WBJT");
	    request.addQuerystringParameter("section","shops");
	    request.addQuerystringParameter("novelty","new");
	    request.addQuerystringParameter("ll", latitude + "," + longitude);
	    request.addQuerystringParameter("v",dateFormat.format(date));
	    Response response = request.send();
	    	JSONObject mainJson;
			try {
				mainJson = new JSONObject(response.getBody());
		    	String group = mainJson.getJSONObject("response").getJSONArray("groups").toString();
		    	//group = group.replace(group.substring(group.length()-1), "");
		    	group = group.substring(0,group.length()-1);
		    	group = group.substring(1);
		    	JSONObject newJSON = new JSONObject(group);
		    	JSONArray items = newJSON.getJSONArray("items");
		    	for (int i = 0; i < items.length(); i++) {
		    		JSONObject item = items.getJSONObject(i);
		    		FourSquareDO fsDO = new FourSquareDO();
		    		fsDO.setVenueName(item.getJSONObject("venue").getString("name"));
		    		fsDO.setContactAddress(item.getJSONObject("venue").getJSONObject("location").getString("address"));
		    		fsDO.setCity(item.getJSONObject("venue").getJSONObject("location").getString("city"));
		    		fsDO.setRating(Double.parseDouble(item.getJSONObject("venue").getString("rating")));
		    		fsDO.setPhone(item.getJSONObject("venue").getJSONObject("contact").getString("formattedPhone"));
		    		fsDO.setLat(Double.parseDouble(item.getJSONObject("venue").getJSONObject("location").getString("lat")));
		    		fsDO.setLng(Double.parseDouble(item.getJSONObject("venue").getJSONObject("location").getString("lng")));
		    		fsDO.setStatCheckinCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("checkinsCount")));
		    		fsDO.setStatUserCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("usersCount")));
		    		fsDO.setStatTipCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("tipCount")));
		    		fsDO.setCurrPop(Integer.parseInt(item.getJSONObject("venue").getJSONObject("hereNow").getString("count")));
		    		fsList.add(fsDO);
		    	}	
		    	
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				
				
			}
		    	
			return fsList;
	    }
	
	
	
	public ArrayList<FourSquareDO> searchVenueCoffee(double latitude, double longitude){
		ArrayList<FourSquareDO> fsList = new ArrayList<FourSquareDO>();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    Date date = new Date();
	    OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.foursquare.com/v2/venues/explore");
	    request.addQuerystringParameter("oauth_token", "RT3RNXM5ZUMF11ACES3YNFRWEK30JN2YYNKQVB5LDFZ4WBJT");
	    request.addQuerystringParameter("section","coffee");
	    request.addQuerystringParameter("novelty","new");
	    request.addQuerystringParameter("ll", latitude + "," + longitude);
	    request.addQuerystringParameter("v",dateFormat.format(date));
	    Response response = request.send();
	    	JSONObject mainJson;
			try {
				mainJson = new JSONObject(response.getBody());
		    	String group = mainJson.getJSONObject("response").getJSONArray("groups").toString();
		    	//group = group.replace(group.substring(group.length()-1), "");
		    	group = group.substring(0,group.length()-1);
		    	group = group.substring(1);
		    	JSONObject newJSON = new JSONObject(group);
		    	JSONArray items = newJSON.getJSONArray("items");
		    	for (int i = 0; i < items.length(); i++) {
		    		JSONObject item = items.getJSONObject(i);
		    		FourSquareDO fsDO = new FourSquareDO();
		    		fsDO.setVenueName(item.getJSONObject("venue").getString("name"));
		    		fsDO.setContactAddress(item.getJSONObject("venue").getJSONObject("location").getString("address"));
		    		fsDO.setCity(item.getJSONObject("venue").getJSONObject("location").getString("city"));
		    		fsDO.setRating(Double.parseDouble(item.getJSONObject("venue").getString("rating")));
		    		fsDO.setPhone(item.getJSONObject("venue").getJSONObject("contact").getString("formattedPhone"));
		    		fsDO.setLat(Double.parseDouble(item.getJSONObject("venue").getJSONObject("location").getString("lat")));
		    		fsDO.setLng(Double.parseDouble(item.getJSONObject("venue").getJSONObject("location").getString("lng")));
		    		fsDO.setStatCheckinCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("checkinsCount")));
		    		fsDO.setStatUserCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("usersCount")));
		    		fsDO.setStatTipCnt(Integer.parseInt(item.getJSONObject("venue").getJSONObject("stats").getString("tipCount")));
		    		fsDO.setCurrPop(Integer.parseInt(item.getJSONObject("venue").getJSONObject("hereNow").getString("count")));
		    		fsList.add(fsDO);
		    	}	
		    	
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				
				
			}
		    	
			return fsList;
	    }
	  
}
