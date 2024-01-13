package FINAL;

import javax.swing.JOptionPane;

public class Motorcycle extends Vehicle{
	
	StringBuilder bikeDetails = new StringBuilder();
	private String bikeType[];
	int i;
	
	Motorcycle(){
	}
	Motorcycle(int size){
		super(size);
	}
	//setter
	void setBikeType(String []bikeType) {
		this.bikeType = bikeType;
	}
	//getter
	String []getBikeType() {
		return bikeType;
	}
	
	void motorcycleDetails() {
		String bikeType[] = getBikeType();
		String brand[] = getBrand();
		String color[] = getColor();
		int power[] = getPower();
		
		for(i=0; i<brand.length; i++) {	
			
			bikeDetails.append("Bike Type: ").append(bikeType[i]).append("\n");
            bikeDetails.append("Brand: ").append(brand[i]).append("\n");
            bikeDetails.append("Color: ").append(color[i]).append("\n");
            bikeDetails.append("Power: ").append(power[i]).append("\n\n");
            
		}
		  JOptionPane.showMessageDialog(null, "MOTORCYCLE " + (i+1) + " DETAILS\n\n" + bikeDetails, "MOTORCYCLES THAT WE OFFER", JOptionPane.INFORMATION_MESSAGE);
	}
	public double calculateRentPrice() {
		double basePrice = 10.0;
		double bikeTypeMultiplier = getBikeTypeMultiplier();
		int power = getPower()[0];
		
		return basePrice * bikeTypeMultiplier * power;
	}
	private double getBikeTypeMultiplier() {
		
		String biketype = getBikeType()[0];
		
		switch(biketype.toLowerCase()) {
		
		case "sport" : 
			return 1.2;
		case "adventure":
			return 1.3;
		case "classic":
			return 1.1;
		case "scooter":
			return 1.0;
		case "cruiser":
			return 1.15;
		case "dirt":
			return 1.25;
		default:
			return 1.0;
		}
	}
	@Override
	public void printReceipt(int index, AdminUserLogIn adminUserLogIn) {
		
		double totalPrice = calculateRentPrice();
		
		bikeDetails.append("First Name: ").append(adminUserLogIn.getFname()).append("\n");
		bikeDetails.append("Last Name: " ).append(adminUserLogIn.getLname()).append("\n");
		bikeDetails.append("Number: " ).append(adminUserLogIn.getNumber()).append("\n");
		bikeDetails.append("Address: " ).append(adminUserLogIn.getAddress()).append("\n");
		bikeDetails.append("Payment: " ).append(adminUserLogIn.getPayment()).append("\n");
		bikeDetails.append("---------------------------------------------------").append("\n");
		bikeDetails.append("MOTORCYCLE " ).append(index).append(" DETAILS").append("\n");
		bikeDetails.append("Bike Type: " ).append(getBikeType()[0]).append("\n");
		bikeDetails.append("Brand: " ).append(getBrand()[0]).append("\n");
		bikeDetails.append("Color: " ).append(getColor()[0]).append("\n");
		bikeDetails.append("Power: " ).append(getPower()[0]).append("\n");
		bikeDetails.append("Total Rent Price: ₱ ").append(totalPrice).append("\n");
		bikeDetails.append("---------------------------------------------------");
		
		JOptionPane.showMessageDialog(null, bikeDetails, "RECEIPT", JOptionPane.INFORMATION_MESSAGE);

	}

}
