public class BrawlDeck {
  private final short[] bennett={7,8,0,1,3,0,1,4,0,1,6,1,3},
                        chris={4,7,0,2,5,0,2,8,0,2,2,0,3},
                        darwin={3,4,1,3,4,0,1,8,1,3,1,3,3},
                        hale={6,5,1,0,8,1,1,4,1,1,4,0,3},
                        morgan={5,8,0,4,6,0,2,2,0,1,4,0,3},
                        pearl={5,7,1,1,7,1,1,1,0,1,5,2,3};

  private BrawlCard[] deck;
  private short cardUsed;
  private final short DECKSIZE=35;

  public BrawlDeck() {    }
  public BrawlDeck(String character,short x) {
    switch(character) {
      case "Bennett":  buildDeck(bennett,x);System.out.println("Bennett");break;
      case "Chris":    buildDeck(chris,x);System.out.println("Chris");break;
      case "Darwin":   buildDeck(darwin,x);System.out.println("Darwin");break;
      case "Hale":     buildDeck(hale,x);System.out.println("Hale");break;
      case "Morgan":   buildDeck(morgan,x);System.out.println("Morgan");break;
      case "Pearl":    buildDeck(pearl,x);System.out.println("Pearl");break;
    }
  }
  private void buildDeck(short[] deckBuilt,short player) {
    deck=new BrawlCard[DECKSIZE];
    short cardCt=0;
    for(short type=0;type<13;type++) {
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
