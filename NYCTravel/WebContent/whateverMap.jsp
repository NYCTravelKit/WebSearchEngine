
<html>
<head>
<%@page import="com.wse.NYCTravelKit.FourSquareDO"%>
<%@page import="com.wse.NYCTravelKit.fourSquare.FourSquare"%>
<%@page import="com.wse.NYCTravelKit.TrendingPlaceDO"%>
<%@page import="com.wse.NYCTravelKit.yelpDO"%>
<%@page import="com.wse.NYCTravelKit.restaurantInfoDO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wse.NYCTravelKit.RDSManager"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta charset="utf-8">
    <title>Weather layer</title>
<style>
      html, body, #map-canvas {
        height: 100%;
        margin: 0px;
        padding: 0px
      }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=weather"></script>
    <script>



function initialize() {
	
	<%
	   if(request.getSession().getAttribute("lat")==null && request.getSession().getAttribute("lng")==null){
		%>
		var mapOptions = {
			    zoom: 6,
			    center: new google.maps.LatLng(40.692338,-73.987342)
			  };
		   var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
		   var weatherLayer = new google.maps.weather.WeatherLayer({
			    temperatureUnits: google.maps.weather.TemperatureUnit.FAHRENHEIT
			  });
			  weatherLayer.setMap(map);

			  var cloudLayer = new google.maps.weather.CloudLayer();
			  cloudLayer.setMap(map);

			  var marker = new google.maps.Marker({
			  			      position: new google.maps.LatLng(40.692338,-73.987342),
			  			      map: map,
			  			      animation: google.maps.Animation.DROP,
			  			      title: 'Current Location!'
						  });
	   <%}else{
		   double lat = Double.parseDouble(request.getSession().getAttribute("lat").toString());
		   double lng = Double.parseDouble(request.getSession().getAttribute("lng").toString());
	   %>
		   var myLatlng = new google.maps.LatLng(<%=lat%>,<%=lng%>);
		   var mapOptions = {
		    zoom: 15,
		    center: myLatlng
		  }
		   var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
		   var marker = new google.maps.Marker({
			      position: myLatlng,
			      map: map,
			      animation: google.maps.Animation.DROP,
			      title: 'Searched Location'
			  });
	   <%
		   
		   FourSquare fsO = new FourSquare();
		   ArrayList<FourSquareDO> artList = fsO.searchVenueArts(lat,lng);
		   for(int i = 0 ; i < artList.size();i++){ 
		   %>
			var retLatlng = new google.maps.LatLng(<%=artList.get(i).getLat()%>,<%=artList.get(i).getLng()%>);
			  var marker = new google.maps.Marker({
			      position: retLatlng,
			      map: map,
			      icon: new google.maps.MarkerImage("http://maps.google.com/mapfiles/ms/icons/arts.png"),
			      animation: google.maps.Animation.DROP,
			      title: "<%=artList.get(i).getVenueName()%>"
			  });
			  
			  
			  <%}
		   
		   ArrayList<FourSquareDO> coffeeList = fsO.searchVenueCoffee(lat,lng);
		   for(int i = 0 ; i < coffeeList.size();i++){ 
		   %>
			var retLatlng = new google.maps.LatLng(<%=coffeeList.get(i).getLat()%>,<%=coffeeList.get(i).getLng()%>);
			  var marker = new google.maps.Marker({
			      position: retLatlng,
			      map: map,
			      icon: new google.maps.MarkerImage("http://maps.google.com/mapfiles/ms/icons/orange.png"),
			      animation: google.maps.Animation.DROP,
			      title: "<%=coffeeList.get(i).getVenueName()%>"
			  });
				  
				  
				  <%}
		   ArrayList<FourSquareDO> drkList = fsO.searchVenueDrinks(lat,lng);
		   for(int i = 0 ; i < drkList.size();i++){ 
		   %>
			var retLatlng = new google.maps.LatLng(<%=drkList.get(i).getLat()%>,<%=drkList.get(i).getLng()%>);
			  var marker = new google.maps.Marker({
			      position: retLatlng,
			      map: map,
			      icon: new google.maps.MarkerImage("http://maps.google.com/mapfiles/ms/icons/bar.png"),
			      animation: google.maps.Animation.DROP,
			      title: "<%=drkList.get(i).getVenueName()%>"
			  });
				  
				  <%}
		   
		   ArrayList<FourSquareDO> foodList = fsO.searchVenueFood(lat,lng);
		   for(int i = 0 ; i < foodList.size();i++){ 
		   %>
			var retLatlng = new google.maps.LatLng(<%=foodList.get(i).getLat()%>,<%=foodList.get(i).getLng()%>);
			  var marker = new google.maps.Marker({
			      position: retLatlng,
			      map: map,
			      icon: new google.maps.MarkerImage("http://maps.google.com/mapfiles/ms/icons/restaurant.png"),
			      animation: google.maps.Animation.DROP,
			      title: "<%=foodList.get(i).getVenueName()%>"
			  });
				  
				  <%}
		   
		   ArrayList<FourSquareDO> shopList = fsO.searchVenueShops(lat,lng);
		   for(int i = 0 ; i < shopList.size();i++){ 
		   %>
			var retLatlng = new google.maps.LatLng(<%=shopList.get(i).getLat()%>,<%=shopList.get(i).getLng()%>);
			  var marker = new google.maps.Marker({
			      position: retLatlng,
			      map: map,
			      icon: new google.maps.MarkerImage("http://maps.google.com/mapfiles/ms/icons/shopping.png"),
			      animation: google.maps.Animation.DROP,
			      title: "<%=shopList.get(i).getVenueName()%>"
			  });
				  
				  <%}
		   
		   ArrayList<FourSquareDO> outList = fsO.searchVenueOutdoor(lat,lng);
		   for(int i = 0 ; i < outList.size();i++){ 
		   %>
			var retLatlng = new google.maps.LatLng(<%=outList.get(i).getLat()%>,<%=outList.get(i).getLng()%>);
			  var marker = new google.maps.Marker({
			      position: retLatlng,
			      map: map,
			      icon: new google.maps.MarkerImage("http://maps.google.com/mapfiles/ms/icons/pink.png"),
			      animation: google.maps.Animation.DROP,
			      title: "<%=outList.get(i).getVenueName()%>"
			  });
				  
				  <%}
		   
		   ArrayList<TrendingPlaceDO> trendList = fsO.searchTrendingVenue(lat,lng);
		   for(int i = 0 ; i < trendList.size();i++){ 
		   %>
			var retLatlng = new google.maps.LatLng(<%=trendList.get(i).getLat()%>,<%=trendList.get(i).getLng()%>);
			  var marker = new google.maps.Marker({
			      position: retLatlng,
			      map: map,
			      icon: new google.maps.MarkerImage("http://maps.google.com/mapfiles/ms/icons/green.png"),
			      animation: google.maps.Animation.DROP,
			      title: "<%=trendList.get(i).getVenueName()%>"
			  });
				  
				  <%}
		   request.getSession().setAttribute("lat",null);
		   request.getSession().setAttribute("lng",null);
	   }%>
	   
	   
	}


google.maps.event.addDomListener(window, 'load', initialize);

</script>
</head>
<body>
 <div id="map-canvas" style="height:490px; width:950px"></div>
</body>
</html>