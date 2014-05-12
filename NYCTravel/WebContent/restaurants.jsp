<!DOCTYPE html>
<%@page import="com.wse.NYCTravelKit.yelpDO"%>
<html>
<head>
<%@page import="com.wse.NYCTravelKit.restaurantInfoDO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wse.NYCTravelKit.RDSManager"%>
<title>Restaurants - NYC Travel Kit</title>
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
<h2 class="wsite-content-title" style="text-align:left;">New York City Search for Restaurants Ends Here...</h2>

<div><div class="wsite-multicol"><div class='wsite-multicol-table-wrap' style='margin:0 -15px'>
<table class='wsite-multicol-table'>
<tbody class='wsite-multicol-tbody'>
<tr class='wsite-multicol-tr'>
<td class='wsite-multicol-col' style='width:50%;padding:0 15px'>

<div class="paragraph" style="text-align:right;"><br />Enter Your Location Here</div>

</td>
<td class='wsite-multicol-col' style='width:50%;padding:0 15px'>

<div class="paragraph" style="text-align:left;"><form id="tfnewsearch" method="post" action="/GetLatLong">
		        <input type="hidden" name="callingform" value="restaurants">
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
<div class="wsite-map"><iframe allowtransparency="true" frameborder="0" scrolling="no" style="width: 100%; height: 500px; margin-top: 10px; margin-bottom: 10px;" src="/RestaurantsMap.jsp"></iframe></div>

<% 
if(request.getSession().getAttribute("lat")!=null && request.getSession().getAttribute("lng")!=null){
	double lat = Double.parseDouble(request.getSession().getAttribute("lat").toString());
	double lng = Double.parseDouble(request.getSession().getAttribute("lng").toString());
			   RDSManager rdsM = new RDSManager();
			   ArrayList<restaurantInfoDO> restList = rdsM.getAllNearRestaurants(lat,lng);
			   for(int i = 0 ; i < restList.size();i++){%> 
<span class='imgPusher' style='float:left;height:0px'></span><span style='z-index:10;position:relative;float:left;max-width:100%;;clear:left;margin-top:0px;*margin-top:0px'><a><img src="/images/labsinthe.jpg" style="margin-top: 5px; margin-bottom: 10px; margin-left: 0px; margin-right: 10px; border-width:1px;padding:3px;" alt="Picture" class="galleryImageBorder wsite-image" /></a><span style="display: block; font-size: 90%; margin-top: -10px; margin-bottom: 10px; text-align: center;" class="wsite-caption"></span></span>
<div class="paragraph" style="text-align:left;display:block;">
<ul>
	  <li>Restaurant Name : <%=restList.get(i).getName() %></li>
	  <li>Restaurant Cousine : <%=restList.get(i).getCusineDesc() %></li>
	  <li>Restaurant Telephone No. : <%=restList.get(i).getTelephone() %></li>
	  <li>Restaurant Street Address : <%=restList.get(i).getStreetAddress() %></li>
	  <li>Restaurant Locality : <%=restList.get(i).getAddressLocality() %></tli>
	  <li>Restaurant State : <%=restList.get(i).getState() %></li>
	  <li>Restaurant City : <%=restList.get(i).getCity() %></li>
	  <li>Restaurant Postal Code : <%=restList.get(i).getPostalCode() %></li>
	  <li>Restaurant Delivery : <%=restList.get(i).getDeliverable() %></li>
      </br>	  
      </br>
      </br>
      </br>
      </br>
      </br>
      </br>
	  
	</ul>
	<%}} %>

</div>
<% 
if(request.getSession().getAttribute("lat")!=null && request.getSession().getAttribute("lng")!=null){
	double lat = Double.parseDouble(request.getSession().getAttribute("lat").toString());
	double lng = Double.parseDouble(request.getSession().getAttribute("lng").toString());
			   RDSManager rdsM = new RDSManager();
			   ArrayList<yelpDO> barList = rdsM.yelpDeveloperBARS(lat,lng);
			   for(int i = 0 ; i < barList.size();i++){%> 
<span class='imgPusher' style='float:left;height:0px'></span><span style='z-index:10;position:relative;float:left;max-width:100%;;clear:left;margin-top:0px;*margin-top:0px'><a><img src="/images/bar.jpg" style="margin-top: 5px; margin-bottom: 10px; margin-left: 0px; margin-right: 10px; border-width:1px;padding:3px;" alt="Picture" class="galleryImageBorder wsite-image" /></a><span style="display: block; font-size: 90%; margin-top: -10px; margin-bottom: 10px; text-align: center;" class="wsite-caption"></span></span>
<div class="paragraph" style="text-align:left;display:block;">
<ul>
	  <li>Bar Name : <%=barList.get(i).getName() %></li>
	  <li>Bar Rating : <%=barList.get(i).getRating() %></li>
	  <li>Bar Telephone No. : <%=barList.get(i).getPhone() %></li>
	  <li>Bar <%=barList.get(i).getAddress() %></li>
	  <li>Bar Review Count : <%=barList.get(i).getReviewCnt() %></li>
      </br>	  
      </br>
      </br>
      </br>
      </br>
      </br>
      </br>
	  
	</ul>
	<%}} %>

</div>
<% 
if(request.getSession().getAttribute("lat")!=null && request.getSession().getAttribute("lng")!=null){
	double lat = Double.parseDouble(request.getSession().getAttribute("lat").toString());
	double lng = Double.parseDouble(request.getSession().getAttribute("lng").toString());
			   RDSManager rdsM = new RDSManager();
			   ArrayList<yelpDO> cdList = rdsM.yelpDeveloperCheapDinner(lat,lng);
			   for(int i = 0 ; i < cdList.size();i++){%> 
<span class='imgPusher' style='float:left;height:0px'></span><span style='z-index:10;position:relative;float:left;max-width:100%;;clear:left;margin-top:0px;*margin-top:0px'><a><img src="/images/cheap.jpg" style="margin-top: 5px; margin-bottom: 10px; margin-left: 0px; margin-right: 10px; border-width:1px;padding:3px;" alt="Picture" class="galleryImageBorder wsite-image" /></a><span style="display: block; font-size: 90%; margin-top: -10px; margin-bottom: 10px; text-align: center;" class="wsite-caption"></span></span>
<div class="paragraph" style="text-align:left;display:block;">
<ul>
	  <li>Cheap Dinner Place Name : <%=cdList.get(i).getName() %></li>
	  <li>Cheap Dinner Place Rating : <%=cdList.get(i).getRating() %></li>
	  <li>Cheap Dinner Place Telephone No. : <%=cdList.get(i).getPhone() %></li>
	  <li>Cheap Dinner Place <%=cdList.get(i).getAddress() %></li>
	  <li>Cheap Dinner Place Review Count : <%=cdList.get(i).getReviewCnt() %></li>
      </br>	  
      </br>
      </br>
      </br>
      </br>
      </br>
      </br>
	  
	</ul>
	<%}} %>

</div>
<hr style="width:100%;clear:both;visibility:hidden;"></hr></div>
</div>
		</div>
	</div>
</body>
</html>