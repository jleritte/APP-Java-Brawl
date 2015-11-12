import javax.swing.*;

public class BrawlIcons {
  private final String bennett = "CharacterIcons/Bennett",
             chris = "CharacterIcons/Chris",
             darwin = "CharacterIcons/Darwin",
             hale = "CharacterIcons/Hale",
             morgan = "CharacterIcons/Morgan",
             pearl = "CharacterIcons/Pearl";

  private ImageIcon[] icons = new ImageIcon[26];

  public BrawlIcons() {}
  public BrawlIcons(String character) {
    if(character.equals("Bennett"))
      buildIcons(bennett);
    else if(character.equals("Chris"))
      buildIcons(chris);
    else if(character.equals("Darwin"))
      buildIcons(darwin);
    else if(character.equals("Hale"))
      buildIcons(hale);
    else if(character.equals("Morgan"))
      buildIcons(morgan);
    else if(character.equals("Pearl"))
      buildIcons(pearl);
  }
  private void buildIcons(String who) {
    icons[0] = new ImageIcon(who+"/Back.jpg");
    icons[1] = new ImageIcon(who+"/Base.jpg");
    icons[2] = new ImageIcon(who+"/HitBlueU.jpg");
    icons[3] = new ImageIcon(who+"/HitBlueD.jpg");
    icons[4] = new ImageIcon(who+"/HitGreenU.jpg");
    icons[5] = new ImageIcon(who+"/HitGreenD.jpg");
    icons[6] = new ImageIcon(who+"/HitRedU.jpg");
    icons[7] = new ImageIcon(who+"/HitRedD.jpg");
    icons[8] = new ImageIcon(who+"/Hit2BlueU.jpg");
    icons[9] = new ImageIcon(who+"/Hit2BlueD.jpg");
    icons[10] = new ImageIcon(who+"/Hit2GreenU.jpg");
    icons[11] = new ImageIcon(who+"/Hit2GreenD.jpg");
    icons[12] = new ImageIcon(who+"/Hit2RedU.jpg");
    icons[13] = new ImageIcon(who+"/Hit2RedD.jpg");
    icons[14] = new ImageIcon(who+"/BlockBlueU.jpg");
    icons[15] = new ImageIcon(who+"/BlockBlueD.jpg");
    icons[16] = new ImageIcon(who+"/BlockGreenU.jpg");
    icons[17] = new ImageIcon(who+"/BlockGreenD.jpg");
    icons[18] = new ImageIcon(who+"/BlockRedU.jpg");
    icons[19] = new ImageIcon(who+"/BlockRedD.jpg");
    icons[20] = new ImageIcon(who+"/PressU.jpg");
    icons[21] = new ImageIcon(who+"/PressD.jpg");
    icons[22] = new ImageIcon(who+"/Clear.jpg");
    icons[23] = new ImageIcon(who+"/Freeze.jpg");
    icons[24] = new ImageIcon(who+"/BaseTop.jpg");
    icons[25] = new ImageIcon(who+"/BaseBottom.jpg");
  }
  public ImageIcon getIcon(String card,int i) {
    short x = -1;
    x = findCard(card,i);
    return icons[x];
  }
  private short findCard(String name,int x) {
    if(x == 1) {
      if(name.equals("Blue Hit"))
        return 2;
      else if(name.equals("Green Hit"))
        return 4;
      else if(name.equals("Red Hit"))
        return 6;
      else if(name.equals("Blue Hit-2"))
        return 8;
      else if(name.equals("Green Hit-2"))
        return 10;
      else if(name.equals("Red Hit-2"))
        return 12;
      else if(name.equals("Blue Block"))
        return 14;
      else if(name.equals("Green Block"))
        return 16;
      else if(name.equals("Red Block"))
        return 18;
      else if(name.equals("Press"))
        return 20;
      else if(name.equals("Base"))
        return 1;
      else if(name.equals("Clear"))
        return 22;
      else if(name.equals("Freeze"))
        return 23;
    }
    else if(x == 2) {
      if(name.equals("Blue Hit"))
        return 3;
      else if(name.equals("Green Hit"))
        return 5;
      else if(name.equals("Red Hit"))
        return 7;
      else if(name.equals("Blue Hit-2"))
        return 9;
      else if(name.equals("Green Hit-2"))
        return 11;
      else if(name.equals("Red Hit-2"))
        return 13;
      else if(name.equals("Blue Block"))
        return 15;
      else if(name.equals("Green Block"))
        return 17;
      else if(name.equals("Red Block"))
        return 19;
      else if(name.equals("Press"))
        return 21;
    }
    else {
      if(name.equals("Back"))
        return 0;
      else if(name.equals("Base"))
        return 1;
      else if(name.equals("Clear"))
        return 22;
      else if(name.equals("Freeze"))
        return 23;
      else if(name.equals("Top"))
        return 24;
      else if(name.equals("Bottom"))
        return 25;
    }
    return 0;
  }
}
