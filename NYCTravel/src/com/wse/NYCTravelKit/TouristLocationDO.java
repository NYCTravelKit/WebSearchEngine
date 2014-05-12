package com.wse.NYCTravelKit;
public class TouristLocationDO {
	int tourist_id;
	String tourist_name;
	String tourist_staddress1;
	String tourist_staddress2;
	String tourist_url;
	String tourist_telephone;
	String tourist_locality;
	int tourist_zip;
	double longitude;
	double latitude;

	public int getTourist_id() {
		return tourist_id;
	}

	public void setTourist_id(int tourist_id) {
		this.tourist_id = tourist_id;
	}

	public String getTourist_name() {
		return tourist_name;
	}

	public void setTourist_name(String tourist_name) {
		this.tourist_name = tourist_name;
	}

	public String getTourist_telephone() {
		return tourist_telephone;
	}

	public void setTourist_telephone(String tourist_telephone) {
		this.tourist_telephone = tourist_telephone;
	}

	public String getTourist_staddress1() {
		return tourist_staddress1;
	}

	public void setTourist_staddress1(String tourist_staddress1) {
		this.tourist_staddress1 = tourist_staddress1;
	}

	public String getTourist_staddress2() {
		return tourist_staddress2;
	}

	public void setTourist_staddress2(String tourist_staddress2) {
		this.tourist_staddress2 = tourist_staddress2;
	}

	public String getTourist_url() {
		return tourist_url;
	}

	public void setTourist_url(String tourist_url) {
		this.tourist_url = tourist_url;
	}

	public String getTourist_locality() {
		return tourist_locality;
	}

	public void setTourist_locality(String tourist_locality) {
		this.tourist_locality = tourist_locality;
	}

	public int getTourist_zip() {
		return tourist_zip;
	}

	public void setTourist_zip(int tourist_zip) {
		this.tourist_zip = tourist_zip;
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
