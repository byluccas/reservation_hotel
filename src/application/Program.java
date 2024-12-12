package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int enterNumberOfRoom = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date enterDateOfCheckIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date enterDateOfCheckOut = sdf.parse(sc.next());

		if (!enterDateOfCheckOut.after(enterDateOfCheckIn)) {
			System.out.println("Error in reservation: Check-out date must to after check-in date");
		} else {
			Reservation reservation = new Reservation(enterNumberOfRoom, enterDateOfCheckIn, enterDateOfCheckOut);
			System.out.println();
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			enterDateOfCheckIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			enterDateOfCheckOut = sdf.parse(sc.next());

			Date now = new Date();

			if (enterDateOfCheckIn.before(now) || enterDateOfCheckOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (!enterDateOfCheckOut.after(enterDateOfCheckIn)) {
				System.out.println("Error in reservation: Check-out date must to after check-in date");
			} else {
				// date to update the reservation
				reservation.updateDate(enterDateOfCheckIn, enterDateOfCheckOut);
				System.out.println("Reservation: " + reservation);
			}

		}

		sc.close();

	}

}
