package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trip extends BaseEntity
{
	private String location;
	private LocalDate start;
	private LocalDate end;
	private int pricePerCustomer;
	private List<Person> people = new ArrayList<>();

	public int revenue()
	{
		return grossRevenue()-guidesCost();
	}

	private int guidesCost()
	{
		int res = 0;
		for(Person p : people)
			if(p instanceof Guide)
			{
				Guide g = (Guide)p;
				res+=((Guide) p).getTariff();
			}

		return res;

	}

	private int grossRevenue()
	{
		int nCustomer = 0;
		for(Person p : people)
			if(p instanceof Customer)
				nCustomer++;

		return nCustomer*pricePerCustomer;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public LocalDate getStart()
	{
		return start;
	}

	public void setStart(LocalDate start)
	{
		this.start = start;
	}

	public LocalDate getEnd()
	{
		return end;
	}

	public void setEnd(LocalDate end)
	{
		this.end = end;
	}

	public int getPricePerCustomer()
	{
		return pricePerCustomer;
	}

	public void setPricePerCustomer(int pricePerCustomer)
	{
		this.pricePerCustomer = pricePerCustomer;
	}

	public List<Person> getPeople()
	{
		return people;
	}

	public void addPerson(Person person)
	{
		people.add(person);
	}
}
