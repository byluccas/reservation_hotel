package model.entites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// calculate date of duration
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		// convert millliseconds in days
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDate(Date chickIn, Date checkOut) {

		Date nowDate = new Date();

		if (checkIn.before(nowDate) || checkOut.before(nowDate)) {
			return "Reservation dates for update must be future dates";
		}
		if (!checkOut.after(checkIn)) {
			return "Check-out date must to after check-in date";
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;

		// do not return error equals null if is different null return error
		return null;
	}

	@Override
	public String toString() {
		return "Room " 
	+ roomNumber 
	+ ", check-in: "
	+ sdf.format(checkIn) 
	+ ", check-out: " 
	+ sdf.format(checkOut)
	+ ", " + duration() + " nights";

	}
}
