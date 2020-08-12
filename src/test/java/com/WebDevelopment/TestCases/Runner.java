package com.WebDevelopment.TestCases;

public class Runner {

	public static void main(String[] args) {

		
		BookingTest bt = new BookingTest();
		
		String firstName = args[0];

		String lastName = args[1];

		String email = args[2];

		String phone = args[3];

		System.out.println(firstName+" "+lastName+" "+ email+" "+phone);
		
		bt.flightBooking();

	}
}
