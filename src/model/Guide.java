package model;

public class Guide extends Person
{
	private int tariff;

	public int getTariff()
	{
		return tariff;
	}

	public void setTariff(int tariff)
	{
		this.tariff = tariff;
	}

	@Override
	public String presentation()
	{
		return "Buongiorno a tutti, sono una guida di nome "+name+" "+surname+" e prendo "+tariff+" euro a viaggio";
	}
}
