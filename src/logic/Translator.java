package logic;

import enums.Message;

import java.io.FileNotFoundException;

public interface Translator
{
	void loadFromFile() throws FileNotFoundException;

	String translate(Message toTranslate);
}
