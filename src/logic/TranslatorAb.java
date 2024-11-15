package logic;

import enums.Message;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class TranslatorAb implements Translator
{
	private final Map<Message,String> dictionary = new HashMap<>();
	String fileName;

	@Override
	public void loadFromFile() throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File(fileName));

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
