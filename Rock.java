
public class Rock implements Item
{
	@Override
	public boolean beats(Item item)
	{
		return item instanceof Scissors;	
	}
	
	@Override
	public String toString()
	{
		return "Rock";
	}
}
