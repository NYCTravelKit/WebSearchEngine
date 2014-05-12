package com.wse.NYCTravelKit;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONException;

/**
 * Servlet implementation class GetLatLong
 */
public class GetLatLong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static LatLongDO getLatLong(String searchString) {
		LatLongDO ldo = new LatLongDO();
        try 
        {
            URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address="+searchString+"&sensor=false");
            URLConnection conn = url.openConnection();                                                                    
            conn.connect();
            InputStreamReader isr = new InputStreamReader(conn.getInputStream());
            StringBuffer sbLocation = new StringBuffer();

            for (int i=0; i != -1; i = isr.read())
            {   
                sbLocation.append((char)i);
            }
            String getContent = sbLocation.toString().trim();   
            if(getContent.contains("results"))
            {
                
            	String temp = getContent.substring(getContent.indexOf("["));
                JSONArray JSONArrayForAll;
				JSONArrayForAll = new JSONArray(temp);
                String lng = JSONArrayForAll.getJSONObject(0).getJSONObject("geometry").getJSONObject("location").get("lng").toString();
                String lat = JSONArrayForAll.getJSONObject(0).getJSONObject("geometry").getJSONObject("location").get("lat").toString();
                ldo.setLangitude(Double.parseDouble(lng));
                ldo.setLatitude(Double.parseDouble(lat));
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return ldo;
}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLatLong() {
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
		String callingJSP = request.getParameter("callingform");
		System.out.println(callingJSP);
		String searchString = request.getParameter("q");
		searchString = searchString.replace(" ", "+");
		LatLongDO ldo = getLatLong(searchString);
		System.out.println(" Latitude : " + ldo.getLatitude());
        System.out.println(" Longitude : " + ldo.getLangitude());
        if (callingJSP.equals("wifiAccess")){
        	request.getSession().setAttribute("lat", ldo.getLatitude());
            request.getSession().setAttribute("lng", ldo.getLangitude());
        	request.getRequestDispatcher("/wifiAccesspoints.jsp").forward(request, response);
        }else if (callingJSP.equals("restaurants")){
        	request.getSession().setAttribute("lat", ldo.getLatitude());
            request.getSession().setAttribute("lng", ldo.getLangitude());
        	request.getRequestDispatcher("/restaurants.jsp").forward(request, response);
        }else if (callingJSP.equals("subway")){
        	request.getSession().setAttribute("lat", ldo.getLatitude());
            request.getSession().setAttribute("lng", ldo.getLangitude());
        	request.getRequestDispatcher("/subway.jsp").forward(request, response);
        }else if (callingJSP.equals("touristAccess")){
        	request.getSession().setAttribute("lat", ldo.getLatitude());
            request.getSession().setAttribute("lng", ldo.getLangitude());
        	request.getRequestDispatcher("/touristattractions.jsp").forward(request, response);
        }
        else if (callingJSP.equals("healthAccess")){
        	request.getSession().setAttribute("lat", ldo.getLatitude());
            request.getSession().setAttribute("lng", ldo.getLangitude());
        	request.getRequestDispatcher("/healthcarecenters.jsp").forward(request, response);
        }
        else if (callingJSP.equals("broadwayAccess")){
        	request.getSession().setAttribute("lat", ldo.getLatitude());
            request.getSession().setAttribute("lng", ldo.getLangitude());
        	request.getRequestDispatcher("/broadwayshows.jsp").forward(request, response);
        }else if (callingJSP.equals("whatever")){
        	request.getSession().setAttribute("lat", ldo.getLatitude());
            request.getSession().setAttribute("lng", ldo.getLangitude());
        	request.getRequestDispatcher("/whatever.jsp").forward(request, response);
        }else if (callingJSP.equals("foodie")){
        	request.getSession().setAttribute("lat", ldo.getLatitude());
            request.getSession().setAttribute("lng", ldo.getLangitude());
            request.getSession().setAttribute("cosine", request.getParameter("cosine"));
        	request.getRequestDispatcher("/foodie.jsp").forward(request, response);
        }
	}

}
