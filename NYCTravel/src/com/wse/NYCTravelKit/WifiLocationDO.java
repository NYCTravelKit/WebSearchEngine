package com.wse.NYCTravelKit;
public class WifiLocationDO {
	int wifi_id;
	String wifi_name;
	String wifi_address;
	String wifi_city;
	int wifi_zip;
	double longitude;
	double latitude;
	String wifi_type;

	public int getWifi_id() {
		return wifi_id;
	}

	public void setWifi_id(int wifi_id) {
		this.wifi_id = wifi_id;
	}

	public String getWifi_name() {
		return wifi_name;
	}

	public void setWifi_name(String wifi_name) {
		this.wifi_name = wifi_name;
	}

	public String getWifi_address() {
		return wifi_address;
	}

	public void setWifi_address(String wifi_address) {
		this.wifi_address = wifi_address;
	}

	public String getWifi_city() {
		return wifi_city;
	}

	public void setWifi_city(String wifi_city) {
		this.wifi_city = wifi_city;
	}

	public int getWifi_zip() {
		return wifi_zip;
	}

	public void setWifi_zip(int wifi_zip) {
		this.wifi_zip = wifi_zip;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getWifi_type() {
		return wifi_type;
	}

	public void setWifi_type(String wifi_type) {
		this.wifi_type = wifi_type;
	}
}
