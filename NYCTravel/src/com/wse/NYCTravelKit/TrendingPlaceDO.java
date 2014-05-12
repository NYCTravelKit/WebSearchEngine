package com.wse.NYCTravelKit;

public class TrendingPlaceDO {
		String venueName;
		String contactAddress;
		String City;
		String postalCode;
		double lat;
		double lng;
		int statCheckinCnt;
		int statUserCnt;
		int statTipCnt;
		int currPop;
		public String getVenueName() {
			return venueName;
		}
		public void setVenueName(String venueName) {
			this.venueName = venueName;
		}
		public String getContactAddress() {
			return contactAddress;
		}
		public void setContactAddress(String contactAddress) {
			this.contactAddress = contactAddress;
		}
		public String getCity() {
			return City;
		}
		public void setCity(String city) {
			City = city;
		}
		public String getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		public double getLat() {
			return lat;
		}
		public void setLat(double lat) {
			this.lat = lat;
		}
		public double getLng() {
			return lng;
		}
		public void setLng(double lng) {
			this.lng = lng;
		}
		public int getStatCheckinCnt() {
			return statCheckinCnt;
		}
		public void setStatCheckinCnt(int statCheckinCnt) {
			this.statCheckinCnt = statCheckinCnt;
		}
		public int getStatUserCnt() {
			return statUserCnt;
		}
		public void setStatUserCnt(int statUserCnt) {
			this.statUserCnt = statUserCnt;
		}
		public int getStatTipCnt() {
			return statTipCnt;
		}
		public void setStatTipCnt(int statTipCnt) {
			this.statTipCnt = statTipCnt;
		}
		public int getCurrPop() {
			return currPop;
		}
		public void setCurrPop(int currPop) {
			this.currPop = currPop;
		}
		
		
}
