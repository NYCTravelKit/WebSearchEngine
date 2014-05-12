package com.wse.NYCTravelKit.Yelp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.*;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

/**
* Example for accessing the Yelp API.
*/
public class Yelp {

  OAuthService service;
  Token accessToken;

  /**
* Setup the Yelp API OAuth credentials.
*
* OAuth credentials are available from the developer site, under Manage API access (version 2 API).
*
* @param consumerKey Consumer key
* @param consumerSecret Consumer secret
* @param token Token
* @param tokenSecret Token secret
*/
  public Yelp(String consumerKey, String consumerSecret, String token, String tokenSecret) {
	  System.out.println("creating Yelp");
    this.service = new ServiceBuilder().provider(YelpApi2.class).apiKey(consumerKey).apiSecret(consumerSecret).build();
    this.accessToken = new Token(token, tokenSecret);
  }

  /**
* Search with term and location.
*
* @param term Search term
* @param latitude Latitude
* @param longitude Longitude
* @return JSON string response
*/
  public String search(String term, double latitude, double longitude) {
    OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");
    request.addQuerystringParameter("term", term);
    request.addQuerystringParameter("ll", latitude + "," + longitude);
    request.addQuerystringParameter("limit", "10");
    request.addQuerystringParameter("radius", "10");
    this.service.signRequest(this.accessToken, request);
    Response response = request.send();
    return response.getBody();
  }
  
  /*public String search(String cuisine, String term,  String location) {
	  System.out.println("i am at search"); 
	  OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");
	    request.addQuerystringParameter("term", cuisine + " " + term);
	    request.addQuerystringParameter("location", location);
	    request.addQuerystringParameter("limit", "5");
	    this.service.signRequest(this.accessToken, request);
	    Response response = request.send();
	    System.out.println(response);
	    return response.getBody();
	  }
*/
  // CLI
  
}
