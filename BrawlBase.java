public class BrawlBase {
  private short player=0;
  private short[] counts= new short[]{0,0};

  private BrawlCard[][] sides = new BrawlCard[2][];

  private char location;

  private boolean freeze;

  public BrawlBase() {  }
  public BrawlBase(int x,char a) {
    player=(short)x;
    location=a;
    sides[0]=new BrawlCard[35];
    sides[1]=new BrawlCard[35];
    freeze=false;
  }
  public boolean addSide(BrawlCard card,int side) {
    boolean rtrn=false;
    if(card.getType()==12) {freeze=true;rtrn=true;}
    if(counts[side]==0) {
      switch(card.getType()) {
        case 1:
        case 4:
        case 7: rtrn=placeCard(card, side);
      }
    }
    else if(counts[side]>0) {
      switch(card.getType()) {
        case 1:
        case 2:
        case 3: {
          if(sides[side][counts[side]-1].getType()==1||sides[side][counts[side]-1].getType()==2) {
            rtrn=placeCard(card,side);
          }
          else if(sides[side][counts[side]-1].getType()==11) {
            if(card.getType()==1) {
              if(sides[side][counts[side]-2].getType()==3) {
                rtrn=placeCard(card,side);
              }
            }
          }
        }
        case 4:
        case 5:
        case 6: {
          if(sides[side][counts[side]-1].getType()==4||sides[side][counts[side]-1].getType()==5) {
            rtrn=placeCard(card,side);
          }
          else if(sides[side][counts[side]-1].getType()==11) {
            if(card.getType()==4) {
              if(sides[side][counts[side]-2].getType()==6) {
                rtrn=placeCard(card,side);
              }
            }
          }
        }
        case 7:
        case 8:
        case 9: {
          if(sides[side][counts[side]-1].getType()==7||sides[side][counts[side]-1].getType()==8) {
            rtrn=placeCard(card,side);
          }
          else if(sides[side][counts[side]-1].getType()==11) {
            if(card.getType()==7) {
              if(sides[side][counts[side]-2].getType()==9) {
                rtrn=placeCard(card,side);
              }
            }
          }
        }
        case 11: {
          switch(sides[side][counts[side]-1].getType()) {
            case 3:
            case 6:
            case 9: rtrn=placeCard(card,side);
          }
        }
      }
    }
    return rtrn;
  }
  private boolean placeCard(BrawlCard card, int side) {
    sides[side][counts[side]]=card;
    counts[side]++;
    return true;
  }
  public BrawlCard getSide(int side) {
    if(counts[side]<=0)
      return sides[side][0];
    else
      return sides[side][counts[side]-1];
  }
  public short scoreSide(int side) {
    counts[side]=0;
    for(short j=0;j<sides[side].length;j++) {
      if(sides[side][j]!=null) {
        switch(sides[side][j].getType()) {
          case 1:
          case 4:
          case 7: counts[side]+=1;break;
          case 2:
          case 5:
          case 8: counts[side]+=2;break;
        }
      }
    }
    System.out.printf("Base %s p%d landed %d hits%n",location,side+1,counts[side]);
    return counts[side];
  }
  public boolean getFreeze() {
    return freeze;
  }
  public short getPlayer() {
    return player;
  }
  public char getLocation() {
    return location;
  }
  public void setLocation(char a) {
    location=a;
  }
  public String getFreezeString() {
    String freezeStr=" ";
    if(freeze==true)
      freezeStr="True";
    else
      freezeStr="False";
    return freezeStr;
  }
}
