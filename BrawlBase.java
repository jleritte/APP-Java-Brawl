public class BrawlBase
{
	private short player=0, p1Count=0, p2Count=0;

	private BrawlCard[] p1, p2;

	private char location;

	private boolean freeze;

	public BrawlBase()
	{	}
	public BrawlBase(int x,char a)
	{
		player=(short)x;
		location=a;
		p1=new BrawlCard[35];
		p2=new BrawlCard[35];
		freeze=false;
	}
	public boolean addP1Side(BrawlCard card)
	{
		if(card.getType()==12)
			{freeze=true;return true;}
		if(p1Count==0)
		{
			switch(card.getType())
			{
				case 1:
				case 4:
				case 7:
				{
					p1[p1Count]=card;
					p1Count++;
					return true;
				}
				default:
				{
					return false;
				}
			}
		}
		else if(p1Count>0)
		{
			switch(card.getType())
			{
				case 1:
				case 2:
				case 3:
				{
					if(p1[p1Count-1].getType()==1||p1[p1Count-1].getType()==2)
					{	p1[p1Count]=card;p1Count++;return true;}
					else if(p1[p1Count-1].getType()==11)
					{	if(card.getType()==1)
						{	if(p1[p1Count-2].getType()==3)
								{	p1[p1Count]=card;p1Count++;return true;}
							else
								return false;
						}
						else
							return false;
					}
					else
						return false;
				}
				case 4:
				case 5:
				case 6:
				{
					if(p1[p1Count-1].getType()==4||p1[p1Count-1].getType()==5)
					{	p1[p1Count]=card;p1Count++;return true;}
					else if(p1[p1Count-1].getType()==11)
					{	if(card.getType()==4)
						{	if(p1[p1Count-2].getType()==6)
								{	p1[p1Count]=card;p1Count++;return true;}
							else
								return false;
						}
						else
							return false;
					}
					else
						return false;
				}
				case 7:
				case 8:
				case 9:
				{
					if(p1[p1Count-1].getType()==7||p1[p1Count-1].getType()==8)
					{	p1[p1Count]=card;p1Count++;return true;}
					else if(p1[p1Count-1].getType()==11)
					{	if(card.getType()==7)
						{	if(p1[p1Count-2].getType()==9)
								{	p1[p1Count]=card;p1Count++;return true;}
							else
								return false;
						}
						else
							return false;
					}
					else
						return false;
				}
				case 11:
				{	switch(p1[p1Count-1].getType())
					{
						case 3:
						case 6:
						case 9:
						{	p1[p1Count]=card;p1Count++;return true;}
						default:
							return false;
					}
				}
				default:
					return false;
			}
		}
		else
			return false;
	}
	public BrawlCard getP1Side()
	{
		if(p1Count<=0)
			return p1[0];
		else
			return p1[p1Count-1];
	}
	public short scoreP1()
	{
		p1Count=0;
		for(short j=0;j<p1.length;j++)
		{
			if(p1[j]!=null)
			{
				switch(p1[j].getType())
				{
					case 1:
					case 4:
					case 7:	p1Count+=1;break;
					case 2:
					case 5:
					case 8:	p1Count+=2;break;
					default:	break;
				}
			}
		}
		System.out.printf("Base %s p1 landed %d hits%n",location,p1Count);
		return p1Count;
	}
	public boolean addP2Side(BrawlCard card)
	{
		if(card.getType()==12)
			{freeze=true;return true;}
		if(p2Count==0)
		{
			switch(card.getType())
			{
				case 1:
				case 4:
				case 7:
				{
					p2[p2Count]=card;
					p2Count++;
					return true;
				}
				default:
				{
					return true;
				}
			}
		}
		else if(p2Count>0)
		{
			switch(card.getType())
			{
				case 1:
				case 2:
				case 3:
				{
					if(p2[p2Count-1].getType()==1||p2[p2Count-1].getType()==2)
					{	p2[p2Count]=card;p2Count++;return true;}
					else if(p2[p2Count-1].getType()==11)
					{	if(card.getType()==1)
						{	if(p2[p2Count-2].getType()==3)
								{	p2[p2Count]=card;p2Count++;return true;}
							else
								return false;
						}
						else
							return false;
					}
					else
						return false;
				}
				case 4:
				case 5:
				case 6:
				{
					if(p2[p2Count-1].getType()==4||p2[p2Count-1].getType()==5)
					{	p2[p2Count]=card;p2Count++;return true;}
					else if(p2[p2Count-1].getType()==11)
					{	if(card.getType()==4)
						{	if(p2[p2Count-2].getType()==6)
								{	p2[p2Count]=card;p2Count++;return true;}
							else
								return false;
						}
						else
							return false;
					}
					else
						return false;
				}
				case 7:
				case 8:
				case 9:
				{
					if(p2[p2Count-1].getType()==7||p2[p2Count-1].getType()==8)
					{	p2[p2Count]=card;p2Count++;return true;}
					else if(p2[p2Count-1].getType()==11)
					{	if(card.getType()==7)
						{	if(p2[p2Count-2].getType()==9)
								{	p2[p2Count]=card;p2Count++;return true;}
							else
								return false;
						}
						else
							return false;
					}
					else
						return false;
				}
				case 11:
				{	switch(p2[p2Count-1].getType())
					{
						case 3:
						case 6:
						case 9:
						{	p2[p2Count]=card;p2Count++;return true;}
						default:
							return false;
					}
				}
				default:
					return false;
			}
		}
		else
			return false;
	}
	public BrawlCard getP2Side()
	{
		if(p2Count<=0)
			return p2[0];
		else
			return p2[p2Count-1];
	}
	public short scoreP2()
	{
		p2Count=0;
		for(short j=0;j<p2.length;j++)
		{
			if(p2[j]!=null)
			{
				switch(p2[j].getType())
				{
					case 1:
					case 4:
					case 7:	p2Count+=1;break;
					case 2:
					case 5:
					case 8:	p2Count+=2;break;
					default:	break;
				}
			}
		}
		System.out.printf("Base %s p2 landed %d hits%n",location,p2Count);
		return p2Count;
	}
	public boolean getFreeze()
	{
		return freeze;
	}
	public short getPlayer()
	{
		return player;
	}
	public char getLocation()
	{
		return location;
	}
	public void setLocation(char a)
	{
		location=a;
	}
	public String getFreezeString()
	{
		String freezeStr=" ";
		if(freeze==true)
			freezeStr="True";
		else
			freezeStr="False";
		return freezeStr;
	}
}
