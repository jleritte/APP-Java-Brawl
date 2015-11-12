import javax.swing.*;


public class Brawl /*extends GameSearch*/ {
  static BrawlField playArea = new BrawlField(1,2);
  static BrawlDeck[] deck = new BrawlDeck[2];
  static BrawlDiscard[] discard = new BrawlDiscard[2];
  static BrawlCard[] currentCard = new BrawlCard[2];
  static BrawlIcons[] icons = new BrawlIcons[2];
  static short count = 0;

  public static void main(String[] args) {
    String str;
    short x;
    /*Object[] playerNum = {"1","2"};

    String num = (String)JOptionPane.showInputDialog(null,"Number of Players","PlayMode",JOptionPane.PLAIN_MESSAGE,null,playerNum,playerNum[0]);*/
    for(short i = 0; i < deck.length; i++) {
      deck[i] = new BrawlDeck(getChar(),count);
      discard[i] = new BrawlDiscard(deck[i].getDeckSize());
      deck[i].shuffle();
      currentCard[i] = deck[i].dealCard();
      currentCard[i] = deck[i].dealCard();
      discard[i].setCard(currentCard[i]);
    }
    boolean quit = false,played = false;
    BrawlPanel bp = new BrawlPanel();
  }
  public static boolean exitValue() {
    boolean quit = playArea.checkDone();
    return quit;
  }
  public static String getChar() {
    Object[] characters = {"Bennett","Chris","Darwin","Hale","Morgan","Pearl"};
    String str = (String)JOptionPane.showInputDialog(null,"Please pick character","Character Selection",JOptionPane.PLAIN_MESSAGE,null,characters,characters[0]);
    icons[count] = new BrawlIcons(str);
    count++;
    return str;
  }
}
