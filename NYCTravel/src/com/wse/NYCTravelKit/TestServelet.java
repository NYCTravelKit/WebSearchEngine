package com.wse.NYCTravelKit;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.wse.NYCTravelKit.Yelp.Yelp;
import com.wse.NYCTravelKit.fourSquare.FourSquare;

/**
 * Servlet implementation class TestServelet
 */
public class TestServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double latitude = 40.69306;
		double longitude = -73.98725;
		FourSquare fs = new FourSquare();
		fs.searchTrendingVenue(40.7576308, -73.990748);
		//fs.searchVenueArts(latitude, longitude);
		//fs.searchVenueCoffee(latitude, longitude);
		//fs.searchVenueDrinks(latitude, longitude);
		//fs.searchVenueShops(latitude, longitude);
		//fs.searchVenueFood(latitude, longitude);
		//fs.searchVenueOutdoor(latitude, longitude);
		
	
		
		
		}
	}

