public class BrawlDeck {
	private final short[]	bennett={7,8,0,1,3,0,1,4,0,1,6,1,3},
							chris={4,7,0,2,5,0,2,8,0,2,2,0,3},
							darwin={3,4,1,3,4,0,1,8,1,3,1,3,3},
							hale={6,5,1,0,8,1,1,4,1,1,4,0,3},
							morgan={5,8,0,4,6,0,2,2,0,1,4,0,3},
							pearl={5,7,1,1,7,1,1,1,0,1,5,2,3};

	private BrawlCard[] deck;
	private short cardUsed;
	private final short DECKSIZE=35;

	public BrawlDeck() {	}
	public BrawlDeck(String character,short x) {
		if(character.equals("Bennett")) {	buildDeck(bennett,x);System.out.println("Bennett");}
		else if(character.equals("Chris")) {	buildDeck(chris,x);System.out.println("Chris");}
		else if(character.equals("Darwin")) {	buildDeck(darwin,x);System.out.println("Darwin");}
		else if(character.equals("Hale")) {  buildDeck(hale,x);System.out.println("Hale");}
		else if(character.equals("Morgan")) {	buildDeck(morgan,x);System.out.println("Morgan");}
		else if(character.equals("Pearl")) {	buildDeck(pearl,x);System.out.println("Pearl");}
	}
	private void buildDeck(short[] deckBuilt,short player) {
		deck=new BrawlCard[DECKSIZE];
		short cardCt=0;
		for(short type=0;type<13;type++) {
			if(type==0)
				for(short i=1;i<=deckBuilt[type];i++) {
					deck[cardCt]=new BrawlCard(type,player);
					cardCt++;
				}
			else if(type==1)
				for(short i=1;i<=deckBuilt[type];i++) {
					deck[cardCt]=new BrawlCard(type,player);
					cardCt++;
				}
			else if(type==2)
				for(short i=1;i<=deckBuilt[type];i++) {
					deck[cardCt]=new BrawlCard(type,player);
					cardCt++;
				}
			else if(type==3)
				for(short i=1;i<=deckBuilt[type];i++) {
					deck[cardCt]=new BrawlCard(type,player);
					cardCt++;
				}
			else if(type==4)
				for(short i=1;i<=deckBuilt[type];i++) {
					deck[cardCt]=new BrawlCard(type,player);
					cardCt++;
				}
			else if(type==5)
				for(short i=1;i<=deckBuilt[type];i++) {
					deck[cardCt]=new BrawlCard(type,player);
					cardCt++;
				}
			else if(type==6)
				for(short i=1;i<=deckBuilt[type];i++) {
					deck[cardCt]=new BrawlCard(type,player);
					cardCt++;
				}
			else if(type==7)
				for(short i=1;i<=deckBuilt[type];i++) {
					deck[cardCt]=new BrawlCard(type,player);
					cardCt++;
				}
			else if(type==8)
				for(short i=1;i<=deckBuilt[type];i++) {
					deck[cardCt]=new BrawlCard(type,player);
					cardCt++;
				}
			else if(type==9)
				for(short i=1;i<=deckBuilt[type];i++) {
					deck[cardCt]=new BrawlCard(type,player);
					cardCt++;
				}
			else if(type==10)
				for(short i=1;i<=deckBuilt[type];i++) {
					deck[cardCt]=new BrawlCard(type,player);
					cardCt++;
				}
			else if(type==11)
				for(short i=1;i<=deckBuilt[type];i++) {
					deck[cardCt]=new BrawlCard(type,player);
					cardCt++;
				}
			else if(type==12)
				for(short i=1;i<=deckBuilt[type];i++) {
					deck[cardCt]=new BrawlCard(type,player);
					cardCt++;
				}
		}
		cardUsed=0;
	}
	public void shuffle() {
		for(short i=31;i>0;i--) {
			short rand = (short)(Math.random()*(i+1));
			if(rand>0) {
				BrawlCard temp = deck[i];
				deck[i] = deck[rand];
				deck[rand] = temp;
			}
      }
        cardUsed = 0;
	}
	public short cardsLeft() {
		return (short)(35-cardUsed);
	}
	public BrawlCard dealCard() {
		cardUsed++;
		return deck[cardUsed-1];
	}
	public short getDeckSize() {
		return DECKSIZE;
	}
}
