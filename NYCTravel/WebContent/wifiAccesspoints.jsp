<!DOCTYPE html>
<html>
<head>
<%@page import="com.wse.NYCTravelKit.WifiLocationDO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wse.NYCTravelKit.RDSManager"%>
<title>WifiSpots - NYC Travel Kit</title>
<meta property='og:site_name' content='NYC Travel Kit' />
<meta property='og:title' content='WifiSpots' />
<meta property='og:description' content='﻿ Enter Your Location' />
<meta property='og:image' content='http://www.editmysite.com/editor/images/na.png' />
<meta property='og:url' content='/wifispots.html' />

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
function initFlyouts(){initPublishedFlyoutMenus([{"id":"987216572151817234","title":"Home","url":"index.html","target":""},{"id":"486155740550470557","title":"About","url":"about.html","target":""},{"id":"476020318251171610","title":"Contact","url":"contact.html","target":""}],"751849950511274518","<li><a href='#'>{{title}}<\/a><\/li>",'',false)}
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
<body class='  wsite-theme-light wsite-page-wifispots'>
<div id="wrapper">
	<div class="bg-wrapper">
		<div id="header">
			<div id="sitename"><span class='wsite-logo'><a href='/'><span id="wsite-title">NYC Travel Kit</span></a></span></div>
		</div>
		<div id="navigation"><ul class='wsite-menu-default'><li id='pg987216572151817234'><a href='/'>Home</a></li><li id='pg486155740550470557'><a href='/about.jsp'>About</a></li><li id='pg476020318251171610'><a href='/contact.jsp'>Contact</a></li></ul></div>
		<div id="content-wrapper">
			<div id="content"><div id='wsite-content' class='wsite-elements wsite-not-footer'>
<h2 class="wsite-content-title" style="text-align:left;">Search for Free Wifi Access Points Ends Here...</h2>

<div><div class="wsite-multicol"><div class='wsite-multicol-table-wrap' style='margin:0 -15px'>
<table class='wsite-multicol-table'>
<tbody class='wsite-multicol-tbody'>
<tr class='wsite-multicol-tr'>
<td class='wsite-multicol-col' style='width:50%;padding:0 15px'>

<div class="paragraph" style="text-align:right;"><br /><span style="line-height: 0; display: none;">&#65279;</span>Enter Your Location</div>

</td>
<td class='wsite-multicol-col'>
<div class="paragraph" style="text-align:left;">
		<form id="tfnewsearch" method="post" action="/GetLatLong">
		        <input type="hidden" name="callingform" value="wifiAccess">
		        <input type="text" class="tftextinput" name="q" size="50" maxlength="300"><input type="submit" value="search" class="tfbutton">
		</form>
	<div class="tfclear"></div></div>
	<br />

</td>
</tr>
</tbody>
</table>
</div></div></div>

<div class="wsite-map"><iframe allowtransparency="true" frameborder="0" scrolling="no" style="width: 100%; height: 500px; margin-top: 10px; margin-bottom: 10px;" src="/wifiAccessPointsMap.jsp"></iframe></div>
<% 
if(request.getSession().getAttribute("lat")!=null && request.getSession().getAttribute("lng")!=null){
	double lat = Double.parseDouble(request.getSession().getAttribute("lat").toString());
	double lng = Double.parseDouble(request.getSession().getAttribute("lng").toString());
			   RDSManager rdsM = new RDSManager();
			   ArrayList<WifiLocationDO> wifiList = rdsM.getAllNearWifiLocations(lat,lng);
			   for(int i = 0 ; i < wifiList.size();i++){%> 
	<span class='imgPusher' style='float:left;height:0px'></span><span style='z-index:10;position:relative;float:left;max-width:50%;;clear:left;margin-top:0px;*margin-top:0px'><a><img src="/images/WiFi.jpg" style="margin-top: 5px; margin-bottom: 10px; margin-left: 0px; margin-right: 10px; border-width:1px;padding:3px; height:125px; width:125px" alt="Picture" class="galleryImageBorder wsite-image" /></a><span style="display: block; font-size: 90%; margin-top: -10px; margin-bottom: 10px; text-align: center;" class="wsite-caption"></span></span>
	<div class="paragraph" style="text-align:left;display:block;">
	<ul>
	  <li>Wifi Name : <%=wifiList.get(i).getWifi_name() %></li>
	  <li>Wifi Address : <%=wifiList.get(i).getWifi_address() %></li>
	  <li>Wifi City : <%=wifiList.get(i).getWifi_city() %></li>
	  <li>Wifi zip : <%=wifiList.get(i).getWifi_zip() %></tli>
	  <li>Wifi Type : <%=wifiList.get(i).getWifi_type() %></li>
	  </br>
	  </br>
	  </br>
	  </br>
	  </br>
	  
	</ul>
	<%}} %></div></div>
<hr style="width:100%;clear:both;visibility:hidden;"></hr></div>
</div>
		</div>
	</div>
</body>
</html>