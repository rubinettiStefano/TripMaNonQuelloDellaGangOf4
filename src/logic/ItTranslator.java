package logic;

import enums.Message;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ItTranslator implements Translator
{
	private static ItTranslator instance;

	public static ItTranslator getInstance()
	{
		if(instance == null)
		{
			instance = new ItTranslator();
			try
			{
				instance.loadFromFile();
			} catch (FileNotFoundException e)
			{
				System.out.println("File di traduzione italiano non trovato, termino programma");
				System.exit(0);
			}
		}
		return instance;
	}

	private final Map<Message,String> dictionary = new HashMap<>();

	private ItTranslator(){}

	@Override
	public void loadFromFile() throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("it.txt"));

		while (sc.hasNextLine())
		{
			String riga = sc.nextLine();
			String[] splitted = riga.split("=");
			dictionary.put(Message.valueOf(splitted[0]), splitted[1]);
		}
	}

	@Override
	public String translate(Message toTranslate)
	{
		if(!dictionary.containsKey(toTranslate))
			throw new NoSuchElementException();

		return dictionary.get(toTranslate);
	}
}
