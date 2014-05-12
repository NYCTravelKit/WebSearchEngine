
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="com.wse.NYCTravelKit.WifiLocationDO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wse.NYCTravelKit.RDSManager"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script
    src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script>



function initialize() {
	
	   <%
	   if(request.getSession().getAttribute("lat")==null && request.getSession().getAttribute("lng")==null){
		%>
		   var myLatlng = new google.maps.LatLng(40.692338,-73.987342);
		   var mapOptions = {
		    zoom: 15,
		    center: myLatlng
		  }
		   var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
		   var marker = new google.maps.Marker({
			      position: myLatlng,
			      map: map,
			      animation: google.maps.Animation.DROP,
			      title: 'Searched Location!'
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
			      title: 'Searched Location!'
			  });
	   <%
		   request.getSession().setAttribute("lat",null);
		   request.getSession().setAttribute("lng",null);
		   RDSManager rdsM = new RDSManager();
		   ArrayList<WifiLocationDO> wifiList = rdsM.getAllNearWifiLocations(lat,lng);
		   for(int i = 0 ; i < wifiList.size();i++){ 
		   %>
			var retLatlng = new google.maps.LatLng(<%=wifiList.get(i).getLongitude()%>,<%=wifiList.get(i).getLatitude()%>);
			  var marker = new google.maps.Marker({
			      position: retLatlng,
			      map: map,
			      icon: new google.maps.MarkerImage("http://maps.google.com/mapfiles/ms/icons/green.png"),
			      animation: google.maps.Animation.DROP,
			      title: "<%=wifiList.get(i).getWifi_name()%>"
			  });
			  
			  <%}}%>
	}


google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
 <div id="map-canvas" style="height:490px; width:950px"></div>
</body>
</html>