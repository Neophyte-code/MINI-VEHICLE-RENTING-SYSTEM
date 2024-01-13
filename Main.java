package FINAL;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main {
	
	private static AdminUserLogIn adminUserLogIn = new AdminUserLogIn();
	private static StringBuilder carDetails = new StringBuilder();
	private static StringBuilder bikeDetails = new StringBuilder();
	private static StringBuilder carChoose = new StringBuilder();
	private static StringBuilder bikeChoose = new StringBuilder();
	private static Motorcycle[] bike;
	private static Cars[] car;
	
	
	public static void main(String[] args) {
		
		boolean backMain = false;
		try {
		do {
			String [] options = {"ADMIN", "CUSTOMER", "EXIT"};
			
		int choice = JOptionPane.showOptionDialog(null, "Welcome To Vehicle Renting System","VEHICLE RENTING SYSTEM", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);
		
		switch(choice) {
		
		case JOptionPane.YES_OPTION: 
			
			boolean makeAgain = false;
			
			adminLogin();
			
			do {
				String[]create = {"MOTORCYCLE", "CAR"};
				
				int createVehicle = JOptionPane.showOptionDialog(null, "Choose a vehicle you want to create", "VEHICLE RENTING SYSTEM", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
						null, create,null);
			
				//Create Motorcycles
				if(createVehicle == JOptionPane.YES_OPTION) {
				
					String numInput = JOptionPane.showInputDialog(null, "How many motorcycle you want to create?");
					int num = Integer.parseInt(numInput);
				
					bike = new Motorcycle[num];
			
					for(int loop=0; loop<bike.length; loop++) {
					
						bike[loop] = new Motorcycle();
					
						String[] bikeTypes = {"SPORT", "ADVENTURE", "CLASSIC", "SCOOTER", "CRUISER", "DIRT"};
					
						String selectedBikeType = (String) JOptionPane.showInputDialog(
		                    null,
		                    "Choose Bike Type:",
		                    "MOTORCYCLE " + (loop+1) + " DETAILS",
		                    JOptionPane.QUESTION_MESSAGE,
		                    null,
		                    bikeTypes,
		                    null);
					
						bike[loop].setBikeType(new String[] {selectedBikeType});
						String brand = JOptionPane.showInputDialog(null,"Enter Motorcycle Brand: ", "MOTORCYCLE " + (loop+1) + " DETAILS", JOptionPane.QUESTION_MESSAGE );
						bike[loop].setBrand(new String[]{brand});
						String color = JOptionPane.showInputDialog(null, "Enter Motorcycle Color: ", "MOTORCYCLE " + (loop+1) + " DETAILS", JOptionPane.QUESTION_MESSAGE);
						bike[loop].setColor(new String[] {color});
						String powerCast = JOptionPane.showInputDialog(null, "Enter Motorcycle Power: ", "MOTORCYCLE " + (loop+1) + " DETAILS", JOptionPane.QUESTION_MESSAGE);
						int power = Integer.parseInt(powerCast);
						bike[loop].setPower(new int[] {power});
				}
				//Create Cars
				}else if(createVehicle == JOptionPane.NO_OPTION) {
				
					String numInput = JOptionPane.showInputDialog("How many car you want to create? ");
					int num = Integer.parseInt(numInput);
				
					car = new Cars[num];
				
					for(int loop=0; loop<car.length; loop++) {
						car[loop] = new Cars();
					
						String [] carTypes = {"SPORT", "CAMPER", "SEDAN", "VAN", "SUV", "COUPE"};
					
						String selectedCarType = (String)JOptionPane.showInputDialog(
									null, "Choose Car Type: ",
									" CAR " +(loop+1)+ " DETAILS",
									JOptionPane.QUESTION_MESSAGE,
									null, carTypes, null);
					
						car[loop].setCarType(new String[] {selectedCarType});
						String brand = JOptionPane.showInputDialog(null,"Enter Car Brand: ", "CAR " + (loop+1) + " DETAILS", JOptionPane.QUESTION_MESSAGE);
						car[loop].setBrand(new String[] {brand});
						String color = JOptionPane.showInputDialog(null,"Enter Car Color: ", "CAR " + (loop+1)+ " DETAILS",JOptionPane.QUESTION_MESSAGE);
						car[loop].setColor(new String[] {color});
						String powerCast = JOptionPane.showInputDialog(null,"Enter Car Power: ", "CAR " + (loop+1) + " DETAILS",JOptionPane.QUESTION_MESSAGE);
						int power = Integer.parseInt(powerCast);
						car[loop].setPower(new int[] {power});
						
				}
				}else if(createVehicle == JOptionPane.CLOSED_OPTION) {
					break;
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid input. Please choose a valid option.");
				}
				
				String[] make = {"YES","NO"};
			
				int make1 = JOptionPane.showOptionDialog(null, "Do you want to make another vehicle?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, make, null);
			
				if(make1 == JOptionPane.YES_OPTION) {
					makeAgain = true;
				}else if(make1 == JOptionPane.NO_OPTION) {
					makeAgain = false;
				}else{
					break;
				}	
			}while(makeAgain);
			break;
			
			//RENT VEHICLES
		case JOptionPane.NO_OPTION:
			
			boolean rentAgain = false;
			
			customerLogin();
			do {
				
			String[] rent = {"MOTORCYCLE", "CAR"};
				
			int rentVehicle = JOptionPane.showOptionDialog(null, "What vehicle you want to rent? ", "VEHICLE RENTING SYSTEM", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, rent, null);
			
			//DISPLAY MOTORCYCLES OFFER
			if(rentVehicle == JOptionPane.YES_OPTION) {
				for (int i=0; i<bike.length; i++) {
					
					bikeDetails.append("MOTORCYCLE ").append(i + 1).append(" DETAILS\n\n");
				    bikeDetails.append("Bike Type: ").append(bike[i].getBikeType()[0]).append("\n");
				    bikeDetails.append("Brand: ").append(bike[i].getBrand()[0]).append("\n");
				    bikeDetails.append("Color: ").append(bike[i].getColor()[0]).append("\n");
				    bikeDetails.append("Power: ").append(bike[i].getPower()[0]).append("\n\n");
	            }
				String indexCast = JOptionPane.showInputDialog(null, bikeDetails + "Which motorcycle you want to rent? ", "MOTORCYCLES THAT WE OFFER\n", JOptionPane.INFORMATION_MESSAGE);
				int index = Integer.parseInt(indexCast);
				
				if(index >=1 && index<=bike.length) {
					int displayIndex = index-1;
					
					bikeChoose.append("Bike Type: ").append(bike[displayIndex].getBikeType()[0]).append("\n");
					bikeChoose.append("Brand: ").append(bike[displayIndex].getBrand()[0]).append("\n");
					bikeChoose.append("Color: ").append(bike[displayIndex].getColor()[0]).append("\n");
					bikeChoose.append("Power: ").append(bike[displayIndex].getPower()[0]).append("\n");
					
					JOptionPane.showMessageDialog(null, bikeChoose + "\n\nPress enter for the receipt", "MOTORCYCLE " + index + " DETAILS:", JOptionPane.INFORMATION_MESSAGE);
				    
				    bike[displayIndex].printReceipt(index,adminUserLogIn);
				    
				}else {
				    JOptionPane.showMessageDialog(null, "Invalid index. Please enter a valid index.");
				}
			//DISPLAY CARS OFFER
			}else if(rentVehicle == JOptionPane.NO_OPTION) {
				
				for(int i=0; i<car.length; i++) {
					
					carDetails.append("CAR ").append(i + 1).append(" DETAILS\n\n");
				    carDetails.append("Car Type: ").append(car[i].getCarType()[0]).append("\n");
				    carDetails.append("Brand: ").append(car[i].getBrand()[0]).append("\n");
				    carDetails.append("Color: ").append(car[i].getColor()[0]).append("\n");
				    carDetails.append("Power: ").append(car[i].getPower()[0]).append("\n\n");
				}
				String indexCast = JOptionPane.showInputDialog(null, carDetails + "Which car you want to rent? ", "CARS THAT WE OFFER", JOptionPane.INFORMATION_MESSAGE);
				int index1 = Integer.parseInt(indexCast);
				
				if(index1>=1 && index1<=car.length) {
					
					int displayIndex = index1-1;
					
					carChoose.append("Car Type: ").append(car[displayIndex].getCarType()[0]).append("\n");
					carChoose.append("Brand: ").append(car[displayIndex].getBrand()[0]).append("\n");
					carChoose.append("Color: ").append(car[displayIndex].getColor()[0]).append("\n");
					carChoose.append("Power: ").append(car[displayIndex].getPower()[0]).append("\n");
					
					JOptionPane.showMessageDialog(null, carChoose + "\n\nPress enter for the receipt", "CAR " + index1 + " DETAILS:\n", JOptionPane.INFORMATION_MESSAGE);
				    
				    car[displayIndex].printReceipt(index1,adminUserLogIn);
							
				}else {
					JOptionPane.showMessageDialog(null, "Invalid index. Please enter a valid index.");
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Invalid Input, try again.");
				
			}
			String [] rentAgainChoice = {"YES", "NO"};
			
			int rentVehicleAgain = JOptionPane.showOptionDialog(null,"Do you want to rent another vehicle? ", "RENT VEHICLE AGAIN",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, rentAgainChoice,null);
			
			if(rentVehicleAgain == JOptionPane.YES_OPTION) {
				rentAgain = true;
			}else if(rentVehicleAgain == JOptionPane.NO_OPTION){
				rentAgain = false;
				JOptionPane.showMessageDialog(null, "Thank you for trusting our services, come again.");
				break;
			}
			}while(rentAgain);
			
		case JOptionPane.CANCEL_OPTION:
			System.exit(0);
			break;
		case JOptionPane.CLOSED_OPTION:
			System.exit(0);
			break;	
		}
		
		int userInput = JOptionPane.showOptionDialog(null, "Proceed to Main Menu?", "Confirmation",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
		
		if(userInput == JOptionPane.YES_OPTION) {
			backMain = true;
		}else if(userInput == JOptionPane.NO_OPTION) {
			backMain = false;
			JOptionPane.showMessageDialog(null, "Thank you for trusting our services, come again.");
			break;
		}
	}while(backMain);
		
	}catch (InputMismatchException inputMismatchException) {
		JOptionPane.showMessageDialog(null, "InputMismatchException Error occurred. Try again with valid input.", null, JOptionPane.WARNING_MESSAGE);
	}catch (NullPointerException nullPointerException) {
        JOptionPane.showMessageDialog(null, "NullPointerException Error Occurred, The admin must make vehicle first.",null, JOptionPane.WARNING_MESSAGE );
	}catch(NumberFormatException numberFormatException) {
		JOptionPane.showMessageDialog(null, "NumberFormatException Error occurred. Try again with valid input.", null, JOptionPane.WARNING_MESSAGE);
	}
		finally {
		JOptionPane.showMessageDialog(null, "Program ended.", null, JOptionPane.INFORMATION_MESSAGE);
	}
	}
		
	private static void adminLogin() {
		
		boolean login = false;
		
		do {
			JTextField usernameField = new JTextField();
			JPasswordField passwordField = new JPasswordField();
			
			Object[]message = {	"Enter Admin Username: ", usernameField, 
								"Enter Admin Password: ", passwordField};
			
			int option = JOptionPane.showConfirmDialog(null, message,"ADMIN LOGIN",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.PLAIN_MESSAGE);
			
			if(option==JOptionPane.OK_OPTION) {
				
				String username = usernameField.getText();
				String password = (new String (passwordField.getPassword()));		
			
	        	AdminUserLogIn admin = new AdminUserLogIn();
	        
	        	if (admin.aunthenticateAdmin(username, password)) {
	        		JOptionPane.showMessageDialog(null, "Admin login successful." );
	        		login = true;
	        	} else {
	        		JOptionPane.showMessageDialog(null, "Invalid admin credentials. Please try again.");
	        	}
	        }else {
	        	JOptionPane.showMessageDialog(null, "Login Canceled");
	        	break;
	        }
		}while(!login);
	}
	private static void customerLogin() {
		
		String [] paymentMethod = {"CASH","CARD"};
		
		String Fname = JOptionPane.showInputDialog(null, "Enter Your First Name: ", "CUSTOMER DETAILS", JOptionPane.QUESTION_MESSAGE);
		adminUserLogIn.setFname(Fname);
		String Lname = JOptionPane.showInputDialog(null, "Enter Your Last Name: ", "CUSTOMER DETAILS", JOptionPane.QUESTION_MESSAGE);
		adminUserLogIn.setLname(Lname);
		String address = JOptionPane.showInputDialog(null, "Enter Address: ", "CUSTOMER DETAILS", JOptionPane.QUESTION_MESSAGE);
		adminUserLogIn.setAddress(address);
		String payment = (String) JOptionPane.showInputDialog(null, "Choose Method of Payment: ", "CUSTOMER DETAILS", JOptionPane.QUESTION_MESSAGE,null, paymentMethod,null);
		adminUserLogIn.setPayment(payment);
		String numberCast = JOptionPane.showInputDialog(null, "Enter Contact Number: ", "CUSTOMER DETAILS", JOptionPane.QUESTION_MESSAGE);
		Long number = Long.parseLong(numberCast);
		adminUserLogIn.setNumber(number);
	}

}
