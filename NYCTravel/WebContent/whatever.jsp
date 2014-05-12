<!DOCTYPE html>
<%@page import="com.wse.NYCTravelKit.TrendingPlaceDO"%>
<%@page import="com.wse.NYCTravelKit.fourSquare.FourSquare"%>
<%@page import="com.wse.NYCTravelKit.FourSquareDO"%>
<%@page import="com.wse.NYCTravelKit.yelpDO"%>
<html>
<head>
<%@page import="com.wse.NYCTravelKit.restaurantInfoDO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wse.NYCTravelKit.RDSManager"%>
<title>Whatever - NYC Travel Kit</title>
<meta property='og:site_name' content='NYC Travel Kit' />
<meta property='og:title' content='Restaurants' />
<meta property='og:description' content='Enter Your Location Here' />
<meta property='og:image' content='http://www.editmysite.com/editor/images/na.png' />
<meta property='og:url' content='/restaurants.html' />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<link rel="stylesheet" href="/styles/sites.css" type="text/css" /><link rel='stylesheet' type='text/css' href='/styles/fancybox.css' />
<link rel='stylesheet' type='text/css' href='/styles/mainStyle.css' title='wsite-theme-css' />
<link href='/styles/italicfonts.css' rel='stylesheet' type='text/css' />
<link href='/styles/googleapis.css' rel='stylesheet' type='text/css' />
<script src="/JavaScripts/Chart.js"></script>
		<meta name = "viewport" content = "initial-scale = 1, user-scalable = no">
		<style>
			canvas{
			}
		</style>
<style type='text/css'>
.wsite-elements.wsite-not-footer div.paragraph, .wsite-elements.wsite-not-footer p, .wsite-elements.wsite-not-footer .product-block .product-title, .wsite-elements.wsite-not-footer .product-description, .wsite-elements.wsite-not-footer .wsite-form-field label, .wsite-elements.wsite-not-footer .wsite-form-field label, #wsite-content div.paragraph, #wsite-content p, #wsite-content .product-block .product-title, #wsite-content .product-description, #wsite-content .wsite-form-field label, #wsite-content .wsite-form-field label, .blog-sidebar div.paragraph, .blog-sidebar p, .blog-sidebar .wsite-form-field label, .blog-sidebar .wsite-form-field label {}
#wsite-content div.paragraph, #wsite-content p, #wsite-content .product-block .product-title, #wsite-content .product-description, #wsite-content .wsite-form-field label, #wsite-content .wsite-form-field label, .blog-sidebar div.paragraph, .blog-sidebar p, .blog-sidebar .wsite-form-field label, .blog-sidebar .wsite-form-field label {}
.wsite-elements.wsite-footer div.paragraph, .wsite-elements.wsite-footer p, .wsite-elements.wsite-footer .product-block .product-title, .wsite-elements.wsite-footer .product-description, .wsite-elements.wsite-footer .wsite-form-field label, .wsite-elements.wsite-footer .wsite-form-field label{}
.wsite-elements.wsite-not-footer h2, .wsite-elements.wsite-not-footer .product-long .product-title, .wsite-elements.wsite-not-footer .product-large .product-title, .wsite-elements.wsite-not-footer .product-small .product-title, #wsite-content h2, #wsite-content .product-long .product-title, #wsite-content .product-large .product-title, #wsite-content .product-small .product-title, .blog-sidebar h2 {}
#wsite-content h2, #wsite-content .product-long .product-title, #wsite-content .product-large .product-title, #wsite-content .product-small .product-title, .blog-sidebar h2 {}
.wsite-elements.wsite-footer h2, .wsite-elements.wsite-footer .product-long .product-title, .wsite-elements.wsite-footer .product-large .product-title, .wsite-elements.wsite-footer .product-small .product-title{}
#wsite-title {}
.wsite-menu-default a {}
.wsite-menu a {}
.wsite-image div, .wsite-caption {}
.galleryCaptionInnerText {}
.fancybox-title {}
.wslide-caption-text {}
.wsite-phone {}
.wsite-headline {}
.wsite-headline-paragraph {}
.wsite-button-inner {}
.wsite-not-footer blockquote, #wsite-com-product-tab blockquote {}
.wsite-footer blockquote {}
.blog-header h2 a {}
h2.wsite-product-title {}
.wsite-product .wsite-product-price a {}
</style>
<style>
.wsite-background {
background-image: url('/images/513848636.jpg') !important;
background-repeat: no-repeat !important;
background-position: 50% 50% !important;
background-size: cover !important;
}
body.wsite-background {
background-attachment: fixed !important;
}
</style>
<style type="text/css">
	#tfheader{
		background-color:#c3dfef;
	}
	#tfnewsearch{
		float:right;
		padding:20px;
	}
	.tftextinput{
		margin: 0;
		padding: 5px 15px;
		font-family: Arial, Helvetica, sans-serif;
		font-size:14px;
		border:1px solid #0076a3; border-right:0px;
		border-top-left-radius: 5px 5px;
		border-bottom-left-radius: 5px 5px;
	}
	.tfbutton {
		margin: 0;
		padding: 5px 15px;
		font-family: Arial, Helvetica, sans-serif;
		font-size:14px;
		outline: none;
		cursor: pointer;
		text-align: center;
		text-decoration: none;
		color: #ffffff;
		border: solid 1px #0076a3; border-right:0px;
		background: #0095cd;
		background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));
		background: -moz-linear-gradient(top,  #00adee,  #0078a5);
		border-top-right-radius: 5px 5px;
		border-bottom-right-radius: 5px 5px;
	}
	.tfbutton:hover {
		text-decoration: none;
		background: #007ead;
		background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));
		background: -moz-linear-gradient(top,  #0095cc,  #00678e);
	}
	/* Fixes submit button height problem in Firefox */
	.tfbutton::-moz-focus-inner {
	  border: 0;
	}
	.tfclear{
		clear:both;
	}
</style>
<script><!--
var STATIC_BASE = '//cdn1.editmysite.com/';
var STYLE_PREFIX = 'wsite';
//-->
</script>
<script src='/JavaScripts/jquery.min.js'></script>
<script src='/JavaScripts/main.js'></script>
<script>_W.relinquish && _W.relinquish()</script>
<script type='text/javascript'><!--
(function(jQuery){
function initFlyouts(){initPublishedFlyoutMenus([{"id":"987216572151817234","title":"Home","url":"index.html","target":""},{"id":"486155740550470557","title":"About","url":"about.html","target":""},{"id":"476020318251171610","title":"Contact","url":"contact.html","target":""}],"706124491857900448","<li><a href='#'>{{title}}<\/a><\/li>",'',false)}
if (jQuery) {
if (jQuery.browser.msie && !window.flyoutMenusRefreshable) window.onload = initFlyouts;
else jQuery(initFlyouts);
}else{
if (Prototype.Browser.IE) window.onload = initFlyouts;
else document.observe('dom:loaded', initFlyouts);
}
})(window._W && _W.jQuery)
//-->
</script>
</head>
<body class='  wsite-theme-light wsite-page-restaurants'>
<div id="wrapper">
	<div class="bg-wrapper">
		<div id="header">
			<div id="sitename"><span class='wsite-logo'><a href='/'><span id="wsite-title">NYC Travel Kit</span></a></span></div>
		</div>
		<div id="navigation"><ul class='wsite-menu-default'><li id='pg987216572151817234'><a href='/'>Home</a></li><li id='pg486155740550470557'><a href='/about.jsp'>About</a></li><li id='pg476020318251171610'><a href='/contact.jsp'>Contact</a></li></ul></div>
		<div id="content-wrapper">
			<div id="content"><div id='wsite-content' class='wsite-elements wsite-not-footer'>
<h2 class="wsite-content-title" style="text-align:left;">Confused on What to do ? Lets Get Top trends...</h2>

<div><div class="wsite-multicol"><div class='wsite-multicol-table-wrap' style='margin:0 -15px'>
<table class='wsite-multicol-table'>
<tbody class='wsite-multicol-tbody'>
<tr class='wsite-multicol-tr'>
<td class='wsite-multicol-col' style='width:50%;padding:0 15px'>

<div class="paragraph" style="text-align:right;"><br />Enter Your Location Here</div>

</td>
<td class='wsite-multicol-col' style='width:50%;padding:0 15px'>

<div class="paragraph" style="text-align:left;"><form id="tfnewsearch" method="post" action="/GetLatLong">
		        <input type="hidden" name="callingform" value="whatever">
		        <input type="text" class="tftextinput" name="q" size="45" maxlength="300"><input type="submit" value="search" class="tfbutton">
		</form>
	<div class="tfclear"></div></div>

</td>
</tr>
</tbody>
</table>
</div></div></div>
<a href="http://www.accuweather.com/en/us/new-york-ny/11416/weather-forecast/349727" class="aw-widget-legal">
<!--
By accessing and/or using this code snippet, you agree to AccuWeather’s terms and conditions (in English) which can be found at http://www.accuweather.com/en/free-weather-widgets/terms and AccuWeather’s Privacy Statement (in English) which can be found at http://www.accuweather.com/en/privacy.
-->
</a><div id="awcc1399690724076" class="aw-widget-current"  data-locationkey="" data-unit="f" data-language="en-us" data-useip="true" data-uid="awcc1399690724076"></div><script type="text/javascript" src="http://oap.accuweather.com/launch.js"></script>
<div class="wsite-map"><iframe allowtransparency="true" frameborder="0" scrolling="no" style="width: 100%; height: 500px; margin-top: 10px; margin-bottom: 10px;" src="/whateverMap.jsp"></iframe></div>
<% 
if(request.getSession().getAttribute("lat")!=null && request.getSession().getAttribute("lng")!=null){
	double lat = Double.parseDouble(request.getSession().getAttribute("lat").toString());
	double lng = Double.parseDouble(request.getSession().getAttribute("lng").toString());
			   FourSquare fs = new FourSquare();
			   ArrayList<TrendingPlaceDO> trendingList = fs.searchTrendingVenue(lat,lng);
			   String param="";
			   String usrCnt="";
			   String curPop="";
			   if(trendingList.size() > 1){
				   for (int j = 0 ; j < trendingList.size();j++){
					   param=param+"\""+trendingList.get(j).getVenueName()+"\",";
					   usrCnt=usrCnt+"\""+((trendingList.get(j).getStatCheckinCnt()*100)/100000)+"\",";
					   curPop=curPop+"\""+(trendingList.get(j).getCurrPop())+"\",";
				   }
				   param = param.substring(0,param.length()-1);
				   usrCnt = usrCnt.substring(0,usrCnt.length()-1);
				   curPop = curPop.substring(0,curPop.length()-1);
				   System.out.println(usrCnt);
				   System.out.println(curPop);
				   
				   
				   

%>
<canvas id="canvas" height="400" width="900"></canvas>


	<script>

		var lineChartData = {
				
			labels : [<%=param%>],
			datasets : [
				{
					fillColor : "rgba(220,220,220,0.5)",
					strokeColor : "rgba(220,220,220,1)",
					pointColor : "rgba(220,220,220,1)",
					pointStrokeColor : "#fff",
					data : [<%=usrCnt%>]
				},
				{
					fillColor : "rgba(151,187,205,0.5)",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "rgba(151,187,205,1)",
					pointStrokeColor : "#fff",
					data : [<%=curPop%>]
				}
			]
			
		}
		
	var myLine = new Chart(document.getElementById("canvas").getContext("2d")).Line(lineChartData, { scaleOverride : true,
        scaleSteps : 10,
        scaleStepWidth : 10,
                          scaleStartValue : 0 });
	
	</script>
	<img alt="" src="/images/CheckinStatus.png" align="right"/>
<div class="paragraph" style="text-align:left;"><br />Top Trends ....</div>
<% 

			   for(int i = 0 ; i < trendingList.size();i++){%> 
<span class='imgPusher' style='float:left;height:0px'></span><span style='z-index:10;position:relative;float:left;max-width:100%;;clear:left;margin-top:0px;*margin-top:0px'><a><img src="/images/trends.jpg" style="margin-top: 5px; margin-bottom: 10px; margin-left: 0px; margin-right: 10px; border-width:1px;padding:3px;" alt="Picture" class="galleryImageBorder wsite-image" /></a><span style="display: block; font-size: 90%; margin-top: -10px; margin-bottom: 10px; text-align: center;" class="wsite-caption"></span></span>

<div class="paragraph" style="text-align:left;display:block;">
<ul>
	  <li>Venue Name : <%=trendingList.get(i).getVenueName() %></li>
	  <li>Venue Address : <%=trendingList.get(i).getContactAddress() %></li>
	  <li>Venue City : <%=trendingList.get(i).getCity() %></li>
	  <li>Venue Postal Code : <%=trendingList.get(i).getPostalCode() %></li>
	  <li>Total Checkin : <%=trendingList.get(i).getStatCheckinCnt() %></tli>
	  <li>Total User Count : <%=trendingList.get(i).getStatUserCnt() %></li>
	  <li>Total Tip Count : <%=trendingList.get(i).getStatTipCnt() %></li>
	  <li>Todays Checkin : <%=trendingList.get(i).getCurrPop() %></li>
      </br>	  
      </br>
      </br>
      </br>
      </br>
      </br>
      </br>
	  
	</ul>
	<%}} }%>

</div>
<%
if(request.getSession().getAttribute("lat")!=null && request.getSession().getAttribute("lng")!=null){
	double lat = Double.parseDouble(request.getSession().getAttribute("lat").toString());
	double lng = Double.parseDouble(request.getSession().getAttribute("lng").toString());
	FourSquare fs = new FourSquare();
	ArrayList<FourSquareDO> artsList = fs.searchVenueArts(lat,lng);
	if(artsList.size()>0){
%>
<div class="paragraph" style="text-align:left;"><br />Top Arts Venue ....</div>
<% 

			   
			   for(int i = 0 ; i < artsList.size();i++){%> 
<span class='imgPusher' style='float:left;height:0px'></span><span style='z-index:10;position:relative;float:left;max-width:100%;;clear:left;margin-top:0px;*margin-top:0px'><a><img src="/images/arts.jpg" style="margin-top: 5px; margin-bottom: 10px; margin-left: 0px; margin-right: 10px; border-width:1px;padding:3px;" alt="Picture" class="galleryImageBorder wsite-image" /></a><span style="display: block; font-size: 90%; margin-top: -10px; margin-bottom: 10px; text-align: center;" class="wsite-caption"></span></span>
<div class="paragraph" style="text-align:left;display:block;">
<ul>
	  <li>Venue Name : <%=artsList.get(i).getVenueName() %></li>
	  <li>Venue Address : <%=artsList.get(i).getContactAddress() %></li>
	  <li>Venue City : <%=artsList.get(i).getCity() %></li>
	  <li>Venue Phone Number : <%=artsList.get(i).getPhone() %></li>
	  <li>Venue Rating : <%=artsList.get(i).getRating() %></li>
	  <li>Total Checkin : <%=artsList.get(i).getStatCheckinCnt() %></tli>
	  <li>Total User Count : <%=artsList.get(i).getStatUserCnt() %></li>
	  <li>Total Tip Count : <%=artsList.get(i).getStatTipCnt() %></li>
	  <li>Todays Checkin : <%=artsList.get(i).getCurrPop() %></li>
      
      </br>
      </br>
      </br>
      </br>
	  
	</ul>
	<%}} }%>

</div>
<%if(request.getSession().getAttribute("lat")!=null && request.getSession().getAttribute("lng")!=null){
	double lat = Double.parseDouble(request.getSession().getAttribute("lat").toString());
	double lng = Double.parseDouble(request.getSession().getAttribute("lng").toString());
	FourSquare fs = new FourSquare();
	   ArrayList<FourSquareDO> outdoorList = fs.searchVenueOutdoor(lat,lng);
	   if(outdoorList.size()>0){
	   %>
<div class="paragraph" style="text-align:left;"><br />Top Outdoor Venue ....</div>
<% 

			   for(int i = 0 ; i < outdoorList.size();i++){%> 
<span class='imgPusher' style='float:left;height:0px'></span><span style='z-index:10;position:relative;float:left;max-width:100%;;clear:left;margin-top:0px;*margin-top:0px'><a><img src="/images/outdoor.jpg" style="margin-top: 5px; margin-bottom: 10px; margin-left: 0px; margin-right: 10px; border-width:1px;padding:3px;" alt="Picture" class="galleryImageBorder wsite-image" /></a><span style="display: block; font-size: 90%; margin-top: -10px; margin-bottom: 10px; text-align: center;" class="wsite-caption"></span></span>
<div class="paragraph" style="text-align:left;display:block;">
<ul>
	  <li>Venue Name : <%=outdoorList.get(i).getVenueName() %></li>
	  <li>Venue Address : <%=outdoorList.get(i).getContactAddress() %></li>
	  <li>Venue City : <%=outdoorList.get(i).getCity() %></li>
	  <li>Venue Phone Number : <%=outdoorList.get(i).getPhone() %></li>
	  <li>Venue Rating : <%=outdoorList.get(i).getRating() %></li>
	  <li>Total Checkin : <%=outdoorList.get(i).getStatCheckinCnt() %></tli>
	  <li>Total User Count : <%=outdoorList.get(i).getStatUserCnt() %></li>
	  <li>Total Tip Count : <%=outdoorList.get(i).getStatTipCnt() %></li>
	  <li>Todays Checkin : <%=outdoorList.get(i).getCurrPop() %></li>
      </br>
      </br>
      </br>
      </br>
      </br>
	  
	</ul>
	<%}} }%>

</div>
<% 
if(request.getSession().getAttribute("lat")!=null && request.getSession().getAttribute("lng")!=null){
	double lat = Double.parseDouble(request.getSession().getAttribute("lat").toString());
	double lng = Double.parseDouble(request.getSession().getAttribute("lng").toString());
	FourSquare fs = new FourSquare();
	   ArrayList<FourSquareDO> foodList = fs.searchVenueFood(lat,lng);
	   if(foodList.size()>0){

%>
<div class="paragraph" style="text-align:left;"><br />Top Food Venue ....</div>
<% 
			   for(int i = 0 ; i < foodList.size();i++){%> 
<span class='imgPusher' style='float:left;height:0px'></span><span style='z-index:10;position:relative;float:left;max-width:100%;;clear:left;margin-top:0px;*margin-top:0px'><a><img src="/images/food.jpg" style="margin-top: 5px; margin-bottom: 10px; margin-left: 0px; margin-right: 10px; border-width:1px;padding:3px;" alt="Picture" class="galleryImageBorder wsite-image" /></a><span style="display: block; font-size: 90%; margin-top: -10px; margin-bottom: 10px; text-align: center;" class="wsite-caption"></span></span>
<div class="paragraph" style="text-align:left;display:block;">
<ul>
	   <li>Venue Name : <%=foodList.get(i).getVenueName() %></li>
	  <li>Venue Address : <%=foodList.get(i).getContactAddress() %></li>
	  <li>Venue City : <%=foodList.get(i).getCity() %></li>
	  <li>Venue Phone Number : <%=foodList.get(i).getPhone() %></li>
	  <li>Venue Rating : <%=foodList.get(i).getRating() %></li>
	  <li>Total Checkin : <%=foodList.get(i).getStatCheckinCnt() %></tli>
	  <li>Total User Count : <%=foodList.get(i).getStatUserCnt() %></li>
	  <li>Total Tip Count : <%=foodList.get(i).getStatTipCnt() %></li>
	  <li>Todays Checkin : <%=foodList.get(i).getCurrPop() %></li>
      </br>
      </br>
      </br>
      </br>
      </br>
	  
	</ul>
	<%}}} %>

</div>
<% 
if(request.getSession().getAttribute("lat")!=null && request.getSession().getAttribute("lng")!=null){
	double lat = Double.parseDouble(request.getSession().getAttribute("lat").toString());
	double lng = Double.parseDouble(request.getSession().getAttribute("lng").toString());
	FourSquare fs = new FourSquare();
	   ArrayList<FourSquareDO> drinkList = fs.searchVenueDrinks(lat,lng);
	   if(drinkList.size()>0){
%>
<div class="paragraph" style="text-align:left;"><br />Top Bar Venue ....</div>
<% 
			   for(int i = 0 ; i < drinkList.size();i++){%> 
<span class='imgPusher' style='float:left;height:0px'></span><span style='z-index:10;position:relative;float:left;max-width:100%;;clear:left;margin-top:0px;*margin-top:0px'><a><img src="/images/drinks.jpg" style="margin-top: 5px; margin-bottom: 10px; margin-left: 0px; margin-right: 10px; border-width:1px;padding:3px;" alt="Picture" class="galleryImageBorder wsite-image" /></a><span style="display: block; font-size: 90%; margin-top: -10px; margin-bottom: 10px; text-align: center;" class="wsite-caption"></span></span>
<div class="paragraph" style="text-align:left;display:block;">
<ul>
	  <li>Venue Name : <%=drinkList.get(i).getVenueName() %></li>
	  <li>Venue Address : <%=drinkList.get(i).getContactAddress() %></li>
	  <li>Venue City : <%=drinkList.get(i).getCity() %></li>
	  <li>Venue Phone Number : <%=drinkList.get(i).getPhone() %></li>
	  <li>Venue Rating : <%=drinkList.get(i).getRating() %></li>
	  <li>Total Checkin : <%=drinkList.get(i).getStatCheckinCnt() %></tli>
	  <li>Total User Count : <%=drinkList.get(i).getStatUserCnt() %></li>
	  <li>Total Tip Count : <%=drinkList.get(i).getStatTipCnt() %></li>
	  <li>Todays Checkin : <%=drinkList.get(i).getCurrPop() %></li>
      </br>
      </br>
      </br>
      </br>
	  
	</ul>
	<%}} }%>

</div>
<% 
if(request.getSession().getAttribute("lat")!=null && request.getSession().getAttribute("lng")!=null){
	double lat = Double.parseDouble(request.getSession().getAttribute("lat").toString());
	double lng = Double.parseDouble(request.getSession().getAttribute("lng").toString());
	FourSquare fs = new FourSquare();
	   ArrayList<FourSquareDO> shopList = fs.searchVenueShops(lat,lng);
	   if(shopList.size()>0){
%>
<div class="paragraph" style="text-align:left;"><br />Top Shop Venue ....</div>
<% 

			   for(int i = 0 ; i < shopList.size();i++){%> 
<span class='imgPusher' style='float:left;height:0px'></span><span style='z-index:10;position:relative;float:left;max-width:100%;;clear:left;margin-top:0px;*margin-top:0px'><a><img src="/images/shopping.jpg" style="margin-top: 5px; margin-bottom: 10px; margin-left: 0px; margin-right: 10px; border-width:1px;padding:3px;" alt="Picture" class="galleryImageBorder wsite-image" /></a><span style="display: block; font-size: 90%; margin-top: -10px; margin-bottom: 10px; text-align: center;" class="wsite-caption"></span></span>
<div class="paragraph" style="text-align:left;display:block;">
<ul>
	  <li>Venue Name : <%=shopList.get(i).getVenueName() %></li>
	  <li>Venue Address : <%=shopList.get(i).getContactAddress() %></li>
	  <li>Venue City : <%=shopList.get(i).getCity() %></li>
	  <li>Venue Phone Number : <%=shopList.get(i).getPhone() %></li>
	  <li>Venue Rating : <%=shopList.get(i).getRating() %></li>
	  <li>Total Checkin : <%=shopList.get(i).getStatCheckinCnt() %></tli>
	  <li>Total User Count : <%=shopList.get(i).getStatUserCnt() %></li>
	  <li>Total Tip Count : <%=shopList.get(i).getStatTipCnt() %></li>
	  <li>Todays Checkin : <%=shopList.get(i).getCurrPop() %></li>
      </br>
      </br>
      </br>
      </br>
	  
	</ul>
	<%}} }%>

</div>
<%
if(request.getSession().getAttribute("lat")!=null && request.getSession().getAttribute("lng")!=null){
	double lat = Double.parseDouble(request.getSession().getAttribute("lat").toString());
	double lng = Double.parseDouble(request.getSession().getAttribute("lng").toString());
	FourSquare fs = new FourSquare();
			   ArrayList<FourSquareDO> coffeeList = fs.searchVenueCoffee(lat,lng);
          if(coffeeList.size()>0){
	%>
<div class="paragraph" style="text-align:left;"><br />Top coffee Venue ....</div>
<% 
			   for(int i = 0 ; i < coffeeList.size();i++){%> 
<span class='imgPusher' style='float:left;height:0px'></span><span style='z-index:10;position:relative;float:left;max-width:100%;;clear:left;margin-top:0px;*margin-top:0px'><a><img src="/images/coffee.jpg" style="margin-top: 5px; margin-bottom: 10px; margin-left: 0px; margin-right: 10px; border-width:1px;padding:3px;" alt="Picture" class="galleryImageBorder wsite-image" /></a><span style="display: block; font-size: 90%; margin-top: -10px; margin-bottom: 10px; text-align: center;" class="wsite-caption"></span></span>
<div class="paragraph" style="text-align:left;display:block;">
<ul>
	  <li>Venue Name : <%=coffeeList.get(i).getVenueName() %></li>
	  <li>Venue Address : <%=coffeeList.get(i).getContactAddress() %></li>
	  <li>Venue City : <%=coffeeList.get(i).getCity() %></li>
	  <li>Venue Phone Number : <%=coffeeList.get(i).getPhone() %></li>
	  <li>Venue Rating : <%=coffeeList.get(i).getRating() %></li>
	  <li>Total Checkin : <%=coffeeList.get(i).getStatCheckinCnt() %></tli>
	  <li>Total User Count : <%=coffeeList.get(i).getStatUserCnt() %></li>
	  <li>Total Tip Count : <%=coffeeList.get(i).getStatTipCnt() %></li>
	  <li>Todays Checkin : <%=coffeeList.get(i).getCurrPop() %></li>
      </br>
      </br>
      </br>
      </br>
	  
	</ul>
	<%}}} %>

</div>
<hr style="width:100%;clear:both;visibility:hidden;"></hr></div>
</div>
		</div>
	</div>
</body>
</html>