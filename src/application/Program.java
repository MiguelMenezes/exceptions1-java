package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (DD/MM/YYY): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation res = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + res);

			System.out.println("Enter date to update the reservation:");
			System.out.print("Check-in date (DD/MM/YYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			res.updateDates(checkIn, checkOut);

			System.out.println("Reservation updated: " + res);
		} 
		catch (ParseException e) {
			System.out.println("Invalid date format!");
		} 
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} 
		//trata qualquer outro tipo de exceção que possa ocorrer:
		catch (RuntimeException e) {
			System.out.println("Unexpected error!!!");
		}
		sc.close();
	}

}
