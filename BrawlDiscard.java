public class BrawlDiscard
{
	private BrawlCard[] discard;
	private short cardLocation=0;

	public BrawlDiscard()
	{	}
	public BrawlDiscard(short deckSize)
	{
		discard=new BrawlCard[deckSize];
	}
	public void setCard(BrawlCard card)
	{
		discard[cardLocation]=card;
		cardLocation++;
	}
	public BrawlCard getCard()
	{
		if(cardLocation<=0)
			return discard[0];
		else
			return discard[cardLocation-1];
	}
	public BrawlCard getCard(int x)
	{
		if(cardLocation<=0)
			return null;
		else
			return discard[cardLocation-1];
	}
	public BrawlCard playCard()
	{
		cardLocation--;
		return discard[cardLocation];
	}
}
