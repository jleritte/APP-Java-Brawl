public class BennetDeck
{
	private final static int bH=8,
									 bH2=0,
									 bB=1,
									 gH=3,
									 gH2=0,
									 gB=1,
									 rH=4,
									 rH2=0,
									 rB=1,
									 bas=7,
									 cl=6,
									 pr=1,
									 fr=3;
	private BrawlCard[] deck;
	private int cardUsed;

	public BennetDeck()
	{
		deck=new BrawlCard[35];
		int cardCt=0;
		for(int type=0;type<=13;type++)
		{
			
			if(type==0)
				for(int i=1;i<=bas;i++)
				{
					deck[cardCt]=new BrawlCard(type);
					cardCt++;
				}
			else if(type==1)
				for(int i=1;i<=bH;i++)
				{
					deck[cardCt]=new BrawlCard(type);
					cardCt++;
				}
			else if(type==2)
				for(int i=1;i<=bH2;i++)
				{
					deck[cardCt]=new BrawlCard(type);
					cardCt++;
				}
			else if(type==3)
				for(int i=1;i<=bB;i++)
				{
					deck[cardCt]=new BrawlCard(type);
					cardCt++;
				}
			else if(type==4)
				for(int i=1;i<=gH;i++)
				{
					deck[cardCt]=new BrawlCard(type);
					cardCt++;
				}
			else if(type==5)
				for(int i=1;i<=gH2;i++)
				{
					deck[cardCt]=new BrawlCard(type);
					cardCt++;
				}
			else if(type==6)
				for(int i=1;i<=gB;i++)
				{
					deck[cardCt]=new BrawlCard(type);
					cardCt++;
				}
			else if(type==7)
				for(int i=1;i<=rH;i++)
				{
					deck[cardCt]=new BrawlCard(type);
					cardCt++;
				}
			else if(type==8)
				for(int i=1;i<=rH2;i++)
				{
					deck[cardCt]=new BrawlCard(type);
					cardCt++;
				}
			else if(type==9)
				for(int i=1;i<=rB;i++)
				{
					deck[cardCt]=new BrawlCard(type);
					cardCt++;
				}
			else if(type==10)
				for(int i=1;i<=cl;i++)
				{
					deck[cardCt]=new BrawlCard(type);
					cardCt++;
				}
			else if(type==11)
				for(int i=1;i<=pr;i++)
				{
					deck[cardCt]=new BrawlCard(type);
					cardCt++;
				}
			else if(type==12)
				for(int i=1;i<=fr;i++)
				{
					deck[cardCt]=new BrawlCard(type);
					cardCt++;
				}
		}
		cardUsed=0;
	}
	public void shuffle()
	{
		for(int i=31;i>0;i--)
		{
			int rand = (int)(Math.random()*(i+1));
			if(rand>0)
			{
				BrawlCard temp = deck[i];
				deck[i] = deck[rand];
				deck[rand] = temp;
			}
      }
        cardUsed = 0;
	}
	public int cardsLeft()
	{
		return 35-cardUsed;
	}
	public BrawlCard dealCard()
	{
		cardUsed++;
		return deck[cardUsed-1];
	}
}
