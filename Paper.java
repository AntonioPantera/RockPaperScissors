
public class Paper implements Item
{
	@Override
	public boolean beats(Item item)
	{
		return item instanceof Rock;
	}

	@Override
	public String toString()
	{
		return "Paper";
	}
}
