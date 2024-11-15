package logic;

import enums.Message;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ItTranslator extends TranslatorAb
{
	private static ItTranslator instance;

	public static ItTranslator getInstance()
	{
		if(instance == null)
		{
			instance = new ItTranslator();
			try
			{
				instance.fileName = "it.txt";
				instance.loadFromFile();
			} catch (FileNotFoundException e)
			{
				System.out.println("File di traduzione italiano non trovato, termino programma");
				System.exit(0);
			}
		}
		return instance;
	}

	private ItTranslator(){}
}
