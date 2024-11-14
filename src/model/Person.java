package model;

import java.time.LocalDate;

public class Person extends BaseEntity
{
	String name,surname;
	LocalDate dob;
	int trip_id;
	Trip trip;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public LocalDate getDob()
	{
		return dob;
	}

	public void setDob(LocalDate dob)
	{
		this.dob = dob;
	}

	public int getTrip_id()
	{
		return trip_id;
	}

	public void setTrip_id(int trip_id)
	{
		this.trip_id = trip_id;
	}

	public Trip getTrip()
	{
		return trip;
	}

	public void setTrip(Trip trip)
	{
		trip.addPerson(this);
		this.trip = trip;
		trip_id = trip.id;
	}
}
