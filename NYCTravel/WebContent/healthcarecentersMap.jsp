<html>
<head>
<%@page import="com.wse.NYCTravelKit.HealthLocationDO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wse.NYCTravelKit.RDSManager"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
		   System.out.println(lat);
		   System.out.println(lng);
	   %>
		   var myLatlng = new google.maps.LatLng(<%=lat%>,<%=lng%>);
		   var mapOptions = {
		    zoom: 12,
		    center: myLatlng
		  }
		   var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
		   var marker = new google.maps.Marker({
			      position: myLatlng,
			      map: map,
			      animation: google.maps.Animation.DROP,
			      title: 'Searched Location!'
			  });
	   <%
		   request.getSession().setAttribute("lat",null);
		   request.getSession().setAttribute("lng",null);
		   RDSManager rdsM = new RDSManager();
		   ArrayList<HealthLocationDO> healthList = rdsM.getAllNearHealthLocations(lat,lng);
		   for(int i = 0 ; i < healthList.size();i++){ 
		   %>
			var retLatlng = new google.maps.LatLng(<%=healthList.get(i).getLatitude()%>,<%=healthList.get(i).getLongitude()%>);
			  var marker = new google.maps.Marker({
			      position: retLatlng,
			      map: map,
			      icon: new google.maps.MarkerImage("http://maps.google.com/mapfiles/ms/icons/green.png"),
			      animation: google.maps.Animation.DROP,
			      title: "<%=healthList.get(i).getHealth_name()%>"
			  });
			  
			  <%}}%>
	}


google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
 <div id="map-canvas" style="height:490px; width:950px"></div>
</body>
</html><%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>