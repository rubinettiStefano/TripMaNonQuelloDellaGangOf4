package logic;

import enums.Message;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EnTranslator implements Translator
{
	private static EnTranslator instance;

	public static EnTranslator getInstance()
	{
		if(instance == null)
		{
			instance = new EnTranslator();
			try
			{
				instance.loadFromFile();
			} catch (FileNotFoundException e)
			{
				System.out.println("File di traduzione inglese non trovato, termino programma");
				System.exit(0);
			}
		}
		return instance;
	}

	private final Map<Message,String> dictionary = new HashMap<>();


	private EnTranslator(){}

	@Override
	public void loadFromFile() throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("en.txt"));

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
