package logic;

import enums.Language;
import enums.Message;
import model.Customer;
import model.Guide;
import model.Person;
import model.Trip;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TripApplication
{
	static Translator t;
	static Scanner sc = new Scanner(System.in);
	static List<Trip> trips = new ArrayList<>();
	static int lastId = 0;

	public static void main(String[] args)
	{
		String cmd="";
		do
		{
			System.out.println("Insert command: ");
			cmd = sc.nextLine();

			switch(cmd)
			{
				case "newtrip"-> newtrip();
				case "newcustomer"-> newcustomer();
				case "newguide"-> newguide();
				case "print"-> print();
				case "quit"-> System.out.println("Goodbye!");
				default -> System.out.println("Invalid command");
			}
		}while (!cmd.equals("quit"));
	}

	private static void newtrip()
	{
		Trip trip = new Trip();
		System.out.print("Enter location: ");
		trip.setLocation(sc.nextLine());

		System.out.print("Enter start date: ");
		String startInput = sc.nextLine();
		trip.setStart(LocalDate.parse(startInput));

		System.out.print("Enter end date: ");
		String endInput = sc.nextLine();
		trip.setEnd(LocalDate.parse(endInput));

		System.out.print("Enter price per customer: ");
		trip.setPricePerCustomer(Integer.parseInt(sc.nextLine()));

		trip.setId(++lastId);
		trips.add(trip);
		System.out.println("New trip created");
	}

	private static void newcustomer()
	{
		Customer customer = new Customer();
		System.out.println("Language/Lingua: IT/EN");
		customer.setLanguage(Language.valueOf(sc.nextLine().toUpperCase()));

		if(customer.getLanguage().equals(Language.IT))
			t=ItTranslator.getInstance();
		else
			t=EnTranslator.getInstance();
		try
		{
			t.loadFromFile();
		} catch (FileNotFoundException e)
		{
			System.out.println("File di traduzione non creato");
			return;
		}

		System.out.print(t.translate(Message.ASKNAME));
		customer.setName(sc.nextLine());

		System.out.print(t.translate(Message.ASKSURNAME));
		customer.setSurname(sc.nextLine());

		System.out.print(t.translate(Message.ASKDOB));
		String dobInput = sc.nextLine();
		customer.setDob(LocalDate.parse(dobInput));

		System.out.println(t.translate(Message.ASKTRIPID));
		showTripIds();
		int tripId = Integer.parseInt(sc.nextLine());

		Trip trip = null;
		for(Trip t : trips)
			if(t.getId() == tripId)
				trip = t;

		if(trip == null)
		{
			System.out.println(t.translate(Message.TRIPNOTFOUND));
			return;
		}

		customer.setTrip(trip);
		customer.setId(++lastId);
		System.out.println(t.translate(Message.NEWCUSTOMER));
	}

	private static void newguide()
	{
		Guide guide = new Guide();
		System.out.print("Enter guide's name: ");
		guide.setName(sc.nextLine());

		System.out.print("Enter guide's surname: ");
		guide.setSurname(sc.nextLine());

		System.out.print("Enter date of birth: ");
		String dobInput = sc.nextLine();
		guide.setDob(LocalDate.parse(dobInput));

		System.out.print("Enter guide's tariff: ");
		guide.setTariff(sc.nextInt());

		System.out.println("Enter trip id");
		showTripIds();
		int tripId = Integer.parseInt(sc.nextLine());

		Trip trip = null;
		for(Trip t : trips)
			if(t.getId() == tripId)
				trip = t;

		if(trip == null)
		{
			System.out.println("Trip not found");
			return;
		}

		guide.setTrip(trip);
		guide.setId(++lastId);
		System.out.println("New guide created");
	}

	private static void showTripIds()
	{
		for(Trip t : trips)
			System.out.println("id: "+t.getId()+", location: "+t.getLocation() );
	}

	private static void print()
	{
		for(Trip t : trips)
			System.out.println("Location: "+t.getLocation()+", net revenue: "+t.revenue()+" euro");
	}

	private static void creaPerson()
	{
		Person person = new Person();
	}
}
