package FINAL;

import javax.swing.JOptionPane;

public class Cars extends Vehicle{
	
	StringBuilder carDetails =  new StringBuilder();
	private String carType[];
	int i;
	
	Cars (){
	}
	Cars (int size){
		super(size);
	}
	//setter
	void setCarType(String [] carType ) {
		this.carType = carType ;
	}
	//getter
	String [] getCarType() {
		return this.carType;
	}
	
	void carDetails() {
		String carType [] = getCarType();
		String brand [] = getBrand();
		String color [] = getColor();
		int power [] = getPower();
		
		for(i=0; i<brand.length; i++) {
			
			carDetails.append("Bike Type: ").append(carType[i]).append("\n");
			carDetails.append("Brand: ").append(brand[i]).append("\n");
            carDetails.append("Color: ").append(color[i]).append("\n");
            carDetails.append("Power: ").append(power[i]).append("\n\n");
		}
		JOptionPane.showMessageDialog(null, "CAR " + (i+1) + " DETAILS\n\n" + carDetails, "MOTORCYCLES THAT WE OFFER", JOptionPane.INFORMATION_MESSAGE);
	}
	public double calculateRentPrice() {
		double basePrice = 20.0;
		double carTypeMultiplier = getCarTypeMultiplier();
		int power = getPower()[0];
		
		return basePrice * carTypeMultiplier * power;
	}
	public double getCarTypeMultiplier() {
		String cartype = getCarType()[0];
		
		switch(cartype.toLowerCase()) {
		
		case "sport":
			return 1.5;
		case "camper":
			return 1.4;
		case "sedan":
			return 1.3;
		case "van":
			return 1.4;
		case "suv":
			return 1.4;
		case "coupe":
			return 2.0;
			default:
				return 1.0;
		}
	}
	@Override
	void printReceipt(int index1, AdminUserLogIn adminUserLogIn) {
		
		double totalPrice = calculateRentPrice();
		
		carDetails.append("First Name: ").append(adminUserLogIn.getFname()).append("\n");
		carDetails.append("Last Name: " ).append(adminUserLogIn.getLname()).append("\n");
		carDetails.append("Number: " ).append(adminUserLogIn.getNumber()).append("\n");
		carDetails.append("Address: " ).append(adminUserLogIn.getAddress()).append("\n");
		carDetails.append("Payment: " ).append(adminUserLogIn.getPayment()).append("\n");
		carDetails.append("---------------------------------------------------").append("\n");
		carDetails.append("CAR " ).append(index1).append(" DETAILS").append("\n");
		carDetails.append("Car Type: " ).append(getCarType()[0]).append("\n");
		carDetails.append("Brand: " ).append(getBrand()[0]).append("\n");
		carDetails.append("Color: " ).append(getColor()[0]).append("\n");
		carDetails.append("Power: " ).append(getPower()[0]).append("\n");
		carDetails.append("Total Rent Price: ₱ ").append(totalPrice).append("\n");
		carDetails.append("---------------------------------------------------");
		
		JOptionPane.showMessageDialog(null, carDetails, "RECEIPT", JOptionPane.INFORMATION_MESSAGE);
	}
}



