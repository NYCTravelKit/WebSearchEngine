package com.wse.NYCTravelKit;

public class subwayDO {
	String Line;
	String name;
	double latitude;
	double longitude;
	String Routes;
	String entranceType;
	String EntryOnlyGate;
	String ExitOnlyGate;
	String vendingMachineExist;
	String staffing;
	String FreeCrossover;
	String northSouthStreet;
	String eastWestStreet;
	String corner;
	int postalCode;
	
	
	public String getLine() {
		return Line;
	}
	public void setLine(String line) {
		Line = line;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRoutes() {
		return Routes;
	}
	public void setRoutes(String routes) {
		Routes = routes;
	}
	public String getEntranceType() {
		return entranceType;
	}
	public void setEntranceType(String entranceType) {
		this.entranceType = entranceType;
	}
	public String getEntryOnlyGate() {
		return EntryOnlyGate;
	}
	public void setEntryOnlyGate(String entryOnlyGate) {
		EntryOnlyGate = entryOnlyGate;
	}
	public String getExitOnlyGate() {
		return ExitOnlyGate;
	}
	public void setExitOnlyGate(String exitOnlyGate) {
		ExitOnlyGate = exitOnlyGate;
	}
	public String getVendingMachineExist() {
		return vendingMachineExist;
	}
	public void setVendingMachineExist(String vendingMachineExist) {
		this.vendingMachineExist = vendingMachineExist;
	}
	public String getStaffing() {
		return staffing;
	}
	public void setStaffing(String staffing) {
		this.staffing = staffing;
	}
	public String getFreeCrossover() {
		return FreeCrossover;
	}
	public void setFreeCrossover(String freeCrossover) {
		FreeCrossover = freeCrossover;
	}
	public String getNorthSouthStreet() {
		return northSouthStreet;
	}
	public void setNorthSouthStreet(String northSouthStreet) {
		this.northSouthStreet = northSouthStreet;
	}
	public String getEastWestStreet() {
		return eastWestStreet;
	}
	public void setEastWestStreet(String eastWestStreet) {
		this.eastWestStreet = eastWestStreet;
	}
	public String getCorner() {
		return corner;
	}
	public void setCorner(String corner) {
		this.corner = corner;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	
}
