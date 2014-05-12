package com.wse.NYCTravelKit;
public class BroadwayShowDO {
	int show_id;
	String show_name;
	String show_theatre;
	String show_staddress;
	String show_city;
	int show_capacity;
	String show_opening;
	double longitude;
	double latitude;

	public int getShow_id() {
		return show_id;
	}

	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}

	public String getShow_name() {
		return show_name;
	}

	public void setShow_name(String show_name) {
		this.show_name = show_name;
	}

	public String getShow_theatre() {
		return show_theatre;
	}

	public void setShow_theatre(String show_theatre) {
		this.show_theatre = show_theatre;
	}

	public String getShow_staddress() {
		return show_staddress;
	}

	public void setShow_staddress(String show_staddress) {
		this.show_staddress = show_staddress;
	}


	public String getShow_city() {
		return show_city;
	}

	public void setShow_city(String show_city) {
		this.show_city = show_city;
	}

	public String getShow_opening() {
		return show_opening;
	}

	public void setShow_opening(String show_opening) {
		this.show_opening = show_opening;
	}

	public int getShow_capacity() {
		return show_capacity;
	}

	public void setShow_capacity(int show_capacity) {
		this.show_capacity = show_capacity;
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
}
