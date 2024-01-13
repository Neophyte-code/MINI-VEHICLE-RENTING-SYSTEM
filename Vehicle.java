package FINAL;

public abstract class Vehicle {
	
	private String brand[];
	private String color [];
	private int power[];
	
	Vehicle(){
		
	}
	Vehicle (int size){
		
		this.brand = new String[size];
		this.color = new String[size];
		this.power = new int [size];
	}
	//setters
	public void  setBrand (String brand[]) {
		this.brand = brand;
		}
	public void setColor (String color[]) {
		this.color = color;
	}
	public void setPower (int power[]) {
		this.power = power;
	}
	//getters
	String[] getBrand() {
		return this.brand;
	}
	String[] getColor() {
		return this.color;
	}
	int[] getPower() {
		return this.power;
	}
	abstract void printReceipt(int index, AdminUserLogIn adminUserLogIn);
}
