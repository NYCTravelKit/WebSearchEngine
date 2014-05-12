package com.wse.NYCTravelKit;

public class restaurantInfoDO {
	String Deliverable;
	String name;
	String StreetAddress;
	String addressLocality;
	int postalCode;
	String telephone;
	String City;
	String State;
	int ZIPCode;
	double latitude;
	double longitude;
	String CusineDesc;
	public String getDeliverable() {
		return Deliverable;
	}
	public void setDeliverable(String deliverable) {
		Deliverable = deliverable;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreetAddress() {
		return StreetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		StreetAddress = streetAddress;
	}
	public String getAddressLocality() {
		return addressLocality;
	}
	public void setAddressLocality(String addressLocality) {
		this.addressLocality = addressLocality;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getZIPCode() {
		return ZIPCode;
	}
	public void setZIPCode(int zIPCode) {
		ZIPCode = zIPCode;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getCusineDesc() {
		return CusineDesc;
	}
	public void setCusineDesc(String cusineDesc) {
		CusineDesc = cusineDesc;
	}
}
