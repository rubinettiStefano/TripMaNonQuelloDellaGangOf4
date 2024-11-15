package model;

import enums.Language;

public class Customer extends Person
{
	private Language language;

	public Language getLanguage()
	{
		return language;
	}

	public void setLanguage(Language language)
	{
		this.language = language;
	}

	@Override
	public String presentation()
	{
		return "Ciao sono un customer di nome "+name+" "+surname+" e parlo "+language;
	}
}
