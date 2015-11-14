import java.util.Vector;
import javax.swing.JOptionPane;

public class BrawlField {
  private Vector<BrawlBase> inPlay;

  private short p1Score=0,p2Score=0;

  public BrawlField() {   }
  public BrawlField(int p1,int p2) {
    inPlay=new Vector<BrawlBase>(3,1);
    inPlay.add(new BrawlBase(p1,'L'));
    inPlay.add(new BrawlBase(p2,'R'));
  }
  public boolean addNewBase(int player,char a) {
    boolean rtrn=false;
    if(inPlay.size()<3) {
      if(inPlay.size()>1) {
        short x=findLocation(a);
        inPlay.get(x).setLocation('M');
        inPlay.add(new BrawlBase(player,a));
      }
      else if(inPlay.size()==1) {
        inPlay.add(new BrawlBase(player,a));
        switch(a) {
          case 'L': {a='R';break;}
          case 'R': {a='L';break;}
        }
        short x=findLocation('M');
        inPlay.get(x).setLocation(a);
      }
      rtrn=true;
    }
    return rtrn;
  }
  public boolean clearBase(char a) {
    boolean rtrn=false;
    if(a!='M'&&inPlay.size()!=1) {
      short x=findLocation(a);
      boolean freeze=checkFreeze(x);
      if(!freeze) {
        inPlay.remove(x);
        if(inPlay.size()>1) {
          x=findLocation('M');
          inPlay.get(x).setLocation(a);
        }
        else if(inPlay.size()==1) {
          switch(a) {
            case 'L': {a='R';break;}
            case 'R': {a='L';break;}
          }
          x=findLocation(a);
          inPlay.get(x).setLocation('M');
        }
        rtrn=true;
      }
    }
    return rtrn;
  }
  public boolean playToBase(char a,int y,BrawlCard card) {
    boolean freeze=false,played=false;
    if(inPlay.size()==1) {
      short x=0;
      freeze=checkFreeze(x);
      if(!freeze) {
        played=inPlay.get(x).addSide(card,y-1);
      }
    }
    else if(inPlay.size()==2&&a!='M') {
      short x=findLocation(a);
      freeze=checkFreeze(x);
      if(!freeze) {
        played=inPlay.get(x).addSide(card,y-1);
      }
    }
    else if(inPlay.size()==3) {
      short x=findLocation(a);
      freeze=checkFreeze(x);
      if(!freeze) {
        played=inPlay.get(x).addSide(card,y-1);
      }
    }
    return played;
  }
  private short findLocation(char a) {
    short i=-1;
    do {
      i++;
      if(inPlay.get(i).getLocation()==a)
        return i;
    }
    while(i<inPlay.size());
    return 3;
  }
  private boolean checkFreeze(short x) {
    return inPlay.get(x).getFreeze();
  }
  public boolean checkDone() {
    boolean[] freeze={false,false,false};
    boolean done=false;
    for(short i=0;i<inPlay.size();i++) {
      freeze[i]=inPlay.get(i).getFreeze();
    }
    if(inPlay.size()==1) {
      if(freeze[0])
        done=true;
    }
    else if(inPlay.size()==2) {
      if(freeze[0]&&freeze[1])
        done=true;
    }
    else if(inPlay.size()==3) {
      if(freeze[0]&&freeze[1]&&freeze[2])
        done=true;
    }
    return done;
  }
  public short calculateScore() {
    short p1Count=0,p2Count=0;
    for(short i=0;i<inPlay.size();i++) {
      p1Count=inPlay.get(i).scoreSide(0);
      p2Count=inPlay.get(i).scoreSide(1);
      if(p1Count==p2Count) {
        if(inPlay.get(i).getPlayer()==1)
          p1Score+=1;
        else
          p2Score+=1;
      }
      else if(p1Count>p2Count)
        p1Score+=1;
      else
        p2Score+=1;
    }
    System.out.println("Pleyer 1 score:"+p1Score);
    System.out.println("Player 2 score:"+p2Score);
    if(p1Score>p2Score)
      return 1;
    else if(p1Score<p2Score)
      return 2;
    else
      return 0;
  }
  public BrawlBase check(int i) {
    return inPlay.get(i);
  }
  public short getSize() {
    return (short)inPlay.size();
  }
}
