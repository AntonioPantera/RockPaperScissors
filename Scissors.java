
public class Scissors implements Item
{
	@Override
	public boolean beats(Item item)
	{
		return item instanceof Paper;
	}
	
	@Override
	public String toString()
	{
		return "Scissors";
	}
}
