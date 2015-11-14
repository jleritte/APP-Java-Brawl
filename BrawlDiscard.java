public class BrawlDiscard {
  private BrawlCard[] discard;
  private short cardLocation=-1;

  public BrawlDiscard() { }
  public BrawlDiscard(short deckSize) {
    discard=new BrawlCard[deckSize];
  }
  public void setCard(BrawlCard card) {
    discard[++cardLocation]=card;
  }
  public BrawlCard getCard() {
    if(cardLocation>=0)
      return discard[cardLocation];
    else
      return new BrawlCard((short)-1,(short)0);
  }
  public BrawlCard playCard() {
    return discard[cardLocation--];
  }
}
