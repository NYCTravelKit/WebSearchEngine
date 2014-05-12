package com.wse.NYCTravelKit;
public class HealthLocationDO {
	int health_id;
	String health_name;
	String health_staddress;
	String health_borough;
	int health_zip;
	String health_telephone;
	double longitude;
	double latitude;

	public int getHealth_id() {
		return health_id;
	}

	public void setHealth_id(int health_id) {
		this.health_id = health_id;
	}

	public String getHealth_name() {
		return health_name;
	}

	public void setHealth_name(String health_name) {
		this.health_name = health_name;
	}

	public String getHealth_staddress() {
		return health_staddress;
	}

	public void setHealth_staddress(String health_staddress) {
		this.health_staddress = health_staddress;
	}

	public String getHealth_borough() {
		return health_borough;
	}

	public void setHealth_borough(String health_borough) {
		this.health_borough = health_borough;
	}

	public int getHealth_zip() {
		return health_zip;
	}

	public void setHealth_zip(int health_zip) {
		this.health_zip = health_zip;
	}

	public String getHealth_telephone() {
		return health_telephone;
	}

	public void setHealth_telephone(String health_telephone) {
		this.health_telephone = health_telephone;
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
