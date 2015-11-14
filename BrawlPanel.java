import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BrawlPanel  {
  private short size = 0;
  private boolean played = false;
  private JFrame frame = new JFrame("Brawl");
  private Container contentPane = frame.getContentPane();
  private JLabel[] playLbl = new JLabel[2];
  private JButton[] play = new JButton[2];
  private JButton[] draw = new JButton[2];
  private JButton[] freeze = new JButton[3];
  private JButton[] addBase = new JButton[2];
  private JButton[][] base = new JButton[3][2];
  private JPanel playField = new JPanel();
  private JPanel[] empty = new JPanel[3];
  private JPanel[] players = new JPanel[2];
  private final Color table = new Color(0,0,0);
  private final Color font = new Color(255,250,255);
  private ImageIcon icon = new ImageIcon("CharacterIcons/icon.jpg");

  public BrawlPanel() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setIconImage(icon.getImage());
    addComponentsToPane();
    frame.setPreferredSize(new Dimension(930,787));
    frame.setLocation(360,50);
    frame.pack();
    frame.setVisible(true);
  }
  private void addComponentsToPane() {
    size = Brawl.playArea.getSize();
    contentPane.setLayout(new BorderLayout(0,0));

    buildNew();
    for(short i = 0;i<players.length;i++)
      players[i]  =  new JPanel();
    buildPlayers();
    buildPlayField();

    contentPane.add(players[0],BorderLayout.PAGE_START);
    contentPane.add(players[1],BorderLayout.PAGE_END);
    contentPane.add(playField,BorderLayout.CENTER);
    contentPane.add(addBase[0],BorderLayout.LINE_START);
    contentPane.add(addBase[1],BorderLayout.LINE_END);
    addBase[0].addActionListener(listen);
    addBase[1].addActionListener(listen);
  }
  public void buildPlayers() {
    buildPlyDrw();
    buildLbl();
    for(short i = 0;i<players.length;i++) {
      players[i].setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
      players[i].setPreferredSize(new Dimension(380,209));
      players[i].add(play[i]);
      players[i].add(playLbl[i]);
      players[i].add(draw[i]);
      players[i].setBackground(table);
      play[i].addActionListener(listen);
      draw[i].addActionListener(listen);
    }
  }
  public void buildPlayField() {
    size = Brawl.playArea.getSize();
    buildBaseBut();
    playField.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
    playField.setBackground(table);
    for(short i = 0;i<empty.length;i++) { empty[i] = new JPanel();
      empty[i].setBackground(table);}
    empty[1].setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
    playField.add(empty[0]);
    playField.add(empty[1]);
    if(size==1) {
      for(short i = 0;i<empty.length;i++) { empty[i].setPreferredSize(new Dimension(209,330));i++;}
      empty[1].setPreferredSize(new Dimension(209,330));
      empty[1].add(base[0][0]);
      empty[1].add(freeze[0]);
      empty[1].add(base[0][1]);
      base[0][0].addActionListener(listen);
      freeze[0].addActionListener(listen);
      base[0][1].addActionListener(listen);
    }
    else if(size==2) {
      for(short i = 0;i<empty.length;i++) { empty[i].setPreferredSize(new Dimension(104,330));i++;}
      empty[1].setPreferredSize(new Dimension(418,330));
      if(Brawl.playArea.check(0).getLocation()=='L') {
        empty[1].add(base[0][0]);
        empty[1].add(base[1][0]);
        empty[1].add(freeze[0]);
        empty[1].add(freeze[1]);
        empty[1].add(base[0][1]);
        empty[1].add(base[1][1]);
        base[0][0].addActionListener(listen);
        freeze[0].addActionListener(listen);
        base[0][1].addActionListener(listen);
        base[1][0].addActionListener(listen);
        freeze[1].addActionListener(listen);
        base[1][1].addActionListener(listen);
      }
      else {
        empty[1].add(base[1][0]);
        empty[1].add(base[0][0]);
        empty[1].add(freeze[1]);
        empty[1].add(freeze[0]);
        empty[1].add(base[1][1]);
        empty[1].add(base[0][1]);
        base[0][0].addActionListener(listen);
        freeze[0].addActionListener(listen);
        base[0][1].addActionListener(listen);
        base[1][0].addActionListener(listen);
        freeze[1].addActionListener(listen);
        base[1][1].addActionListener(listen);
      } 
    }
    else if(size==3) {
      for(short i = 0;i<empty.length;i++) { empty[i].setPreferredSize(new Dimension(0,330));i++;}
      empty[1].setPreferredSize(new Dimension(627,330));
      if(Brawl.playArea.check(0).getLocation()=='L') {  if(Brawl.playArea.check(1).getLocation()=='M') {
          empty[1].add(base[0][0]);
          empty[1].add(base[1][0]);
          empty[1].add(base[2][0]);
          empty[1].add(freeze[0]);
          empty[1].add(freeze[1]);
          empty[1].add(freeze[2]);
          empty[1].add(base[0][1]);
          empty[1].add(base[1][1]);
          empty[1].add(base[2][1]);
          base[0][0].addActionListener(listen);
          base[0][1].addActionListener(listen);
          base[1][0].addActionListener(listen);
          base[1][1].addActionListener(listen);
          base[2][0].addActionListener(listen);
          base[2][1].addActionListener(listen);
          freeze[0].addActionListener(listen);
          freeze[1].addActionListener(listen);
          freeze[2].addActionListener(listen);
        }
        else if(Brawl.playArea.check(1).getLocation()=='R') {
          empty[1].add(base[0][0]);
          empty[1].add(base[2][0]);
          empty[1].add(base[1][0]);
          empty[1].add(freeze[0]);
          empty[1].add(freeze[2]);
          empty[1].add(freeze[1]);
          empty[1].add(base[0][1]);
          empty[1].add(base[2][1]);
          empty[1].add(base[1][1]);
          base[0][0].addActionListener(listen);
          base[0][1].addActionListener(listen);
          base[1][0].addActionListener(listen);
          base[1][1].addActionListener(listen);
          base[2][0].addActionListener(listen);
          base[2][1].addActionListener(listen);
          freeze[0].addActionListener(listen);
          freeze[1].addActionListener(listen);
          freeze[2].addActionListener(listen);
        }
      }
      else if(Brawl.playArea.check(0).getLocation()=='M') { if(Brawl.playArea.check(1).getLocation()=='L') {
          empty[1].add(base[1][0]);
          empty[1].add(base[0][0]);
          empty[1].add(base[2][0]);
          empty[1].add(freeze[1]);
          empty[1].add(freeze[0]);
          empty[1].add(freeze[2]);
          empty[1].add(base[1][1]);
          empty[1].add(base[0][1]);
          empty[1].add(base[2][1]);
          base[0][0].addActionListener(listen);
          base[0][1].addActionListener(listen);
          base[1][0].addActionListener(listen);
          base[1][1].addActionListener(listen);
          base[2][0].addActionListener(listen);
          base[2][1].addActionListener(listen);
          freeze[0].addActionListener(listen);
          freeze[1].addActionListener(listen);
          freeze[2].addActionListener(listen);
        }
        else if(Brawl.playArea.check(1).getLocation()=='R') {
          empty[1].add(base[2][0]);
          empty[1].add(base[0][0]);
          empty[1].add(base[1][0]);
          empty[1].add(freeze[2]);
          empty[1].add(freeze[0]);
          empty[1].add(freeze[1]);
          empty[1].add(base[2][1]);
          empty[1].add(base[0][1]);
          empty[1].add(base[1][1]);
          base[0][0].addActionListener(listen);
          base[0][1].addActionListener(listen);
          base[1][0].addActionListener(listen);
          base[1][1].addActionListener(listen);
          base[2][0].addActionListener(listen);
          base[2][1].addActionListener(listen);
          freeze[0].addActionListener(listen);
          freeze[1].addActionListener(listen);
          freeze[2].addActionListener(listen);
        }
      }
      else if(Brawl.playArea.check(0).getLocation()=='R') { if(Brawl.playArea.check(1).getLocation()=='L') {
          empty[1].add(base[1][0]);
          empty[1].add(base[2][0]);
          empty[1].add(base[0][0]);
          empty[1].add(freeze[1]);
          empty[1].add(freeze[2]);
          empty[1].add(freeze[0]);
          empty[1].add(base[1][1]);
          empty[1].add(base[2][1]);
          empty[1].add(base[0][1]);
          base[0][0].addActionListener(listen);
          base[0][1].addActionListener(listen);
          base[1][0].addActionListener(listen);
          base[1][1].addActionListener(listen);
          base[2][0].addActionListener(listen);
          base[2][1].addActionListener(listen);
          freeze[0].addActionListener(listen);
          freeze[1].addActionListener(listen);
          freeze[2].addActionListener(listen);
        }
        else if(Brawl.playArea.check(1).getLocation()=='M') {
          empty[1].add(base[2][0]);
          empty[1].add(base[1][0]);
          empty[1].add(base[0][0]);
          empty[1].add(freeze[2]);
          empty[1].add(freeze[1]);
          empty[1].add(freeze[0]);
          empty[1].add(base[2][1]);
          empty[1].add(base[1][1]);
          empty[1].add(base[0][1]);
          base[0][0].addActionListener(listen);
          base[0][1].addActionListener(listen);
          base[1][0].addActionListener(listen);
          base[1][1].addActionListener(listen);
          base[2][0].addActionListener(listen);
          base[2][1].addActionListener(listen);
          freeze[0].addActionListener(listen);
          freeze[1].addActionListener(listen);
          freeze[2].addActionListener(listen);
        }
      }
    }
    playField.add(empty[2]);
  }
  public void buildPlyDrw() {
    for(short i = 0;i<4;i++) {
      if(i<2) {
        String str = "";
        if(Brawl.discard[i].getCard().toString().equals("??"))
          play[i] = new JButton();
        else
          play[i] = new JButton(Brawl.icons[i].getIcon(Brawl.discard[i].getCard().toString(),1));
        play[i].setPreferredSize(new Dimension(150,209));
        play[i].setBackground(table);
      }
      else {
        if(Brawl.deck[i-2].cardsLeft()!= 0)
          draw[i-2] = new JButton(Brawl.icons[i-2].getIcon("Back",0));
        else
          draw[i-2] = new JButton();
        draw[i-2].setPreferredSize(new Dimension(150,209));
        draw[i-2].setBackground(table);
      }
    }
  }
  public void buildBaseBut() {
    for(short i = 0;i<size;i++) {
      freeze[i] = new JButton(Brawl.icons[Brawl.playArea.check(i).getPlayer()-1].getIcon("Base",0));
      freeze[i].setPreferredSize(new Dimension(209,30));
      freeze[i].setBackground(table);
      for(short j = 0;j<2;j++) {
        String str = "";
        if(j==0) {  if(Brawl.playArea.check(i).getSide(0)==null) { base[i][j] = new JButton(Brawl.icons[Brawl.playArea.check(i).getPlayer()-1].getIcon("Top",0));}
          else {  base[i][j] = new JButton(Brawl.icons[Brawl.playArea.check(i).getSide(0).getPlayer()-1].getIcon(Brawl.playArea.check(i).getSide(0).toString(),2));}}
        else if(j==1) { if(Brawl.playArea.check(i).getSide(1)==null) { base[i][j] = new JButton(Brawl.icons[Brawl.playArea.check(i).getPlayer()-1].getIcon("Bottom",0));}
          else {  base[i][j] = new JButton(Brawl.icons[Brawl.playArea.check(i).getSide(1).getPlayer()-1].getIcon(Brawl.playArea.check(i).getSide(1).toString(),2));}}
        base[i][j].setPreferredSize(new Dimension(209,150));
        base[i][j].setBackground(table);
      }
      if(Brawl.playArea.check(i).getFreeze()==true) {
        freeze[i].setEnabled(false);
        for(short j = 0;j<2;j++)
          base[i][j].setEnabled(false);
      }
    }
  }
  public void buildNew() {
    for(short i = 0;i<addBase.length;i++) {
      addBase[i] = new JButton();
      addBase[i].setPreferredSize(new Dimension(80,200));
      addBase[i].setBackground(table);
    }
  }
  public void buildLbl() {
    for(short i = 0;i<playLbl.length;i++) {
      String cardCt = Short.toString(Brawl.deck[i].cardsLeft());
      playLbl[i] = new JLabel(cardCt);
      playLbl[i].setPreferredSize(new Dimension(25,30));
      playLbl[i].setForeground(font);
    } 
  }
  public ActionListener listen = (new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==draw[0]||e.getSource()==play[0]) {
        Brawl.currentCard[0] = Brawl.deck[0].dealCard();
        Brawl.discard[0].setCard(Brawl.currentCard[0]);
      }
      else if(e.getSource()==addBase[1]) {
        if(Brawl.discard[0].getCard().toString().equals("Base")) {
          played = Brawl.playArea.addNewBase(1,'R');
          if(played==true) {
            BrawlCard temp = Brawl.discard[0].playCard();
          }
          else
            JOptionPane.showMessageDialog(null,"Invalid Play!");
        }
        else
          JOptionPane.showMessageDialog(null,"Invalid Play!");
      }
      else if(e.getSource()==addBase[0]) {
        if(Brawl.discard[0].getCard().toString().equals("Base")) {
          played=Brawl.playArea.addNewBase(1,'L');
          if(played==true) {
            BrawlCard temp=Brawl.discard[0].playCard();
          }
          else
            JOptionPane.showMessageDialog(null,"Invalid Play!");
        }
        else
          JOptionPane.showMessageDialog(null,"Invalid Play!");
      }
      else if(e.getSource()==base[0][0]) {
        if(Brawl.discard[0].getCard().equals("Freeze")||Brawl.discard[0].getCard().equals("Clear")||Brawl.discard[0].getCard().equals("Base"))
          JOptionPane.showMessageDialog(null,"Invalid Play!");
        else {
          played=Brawl.playArea.playToBase(Brawl.playArea.check(0).getLocation(),1,Brawl.discard[0].getCard());
          if(played==true) {
            BrawlCard temp=Brawl.discard[0].playCard();
          }
          else
            JOptionPane.showMessageDialog(null,"Invalid Play!");
        }
      }
      else if(e.getSource()==base[0][1]) {
        if(Brawl.discard[0].getCard().equals("Freeze")||Brawl.discard[0].getCard().equals("Clear")||Brawl.discard[0].getCard().equals("Base"))
          JOptionPane.showMessageDialog(null,"Invalid Play!");
        else {
          played=Brawl.playArea.playToBase(Brawl.playArea.check(0).getLocation(),2,Brawl.discard[0].getCard());
          if(played==true) {
            BrawlCard temp=Brawl.discard[0].playCard();
          }
          else
            JOptionPane.showMessageDialog(null,"Invalid Play!");
        }
      }
      else if(e.getSource()==base[1][0]) {
        if(Brawl.discard[0].getCard().equals("Freeze")||Brawl.discard[0].getCard().equals("Clear")||Brawl.discard[0].getCard().equals("Base"))
          JOptionPane.showMessageDialog(null,"Invalid Play!");
        else {
          played=Brawl.playArea.playToBase(Brawl.playArea.check(1).getLocation(),1,Brawl.discard[0].getCard());
          if(played==true) {
            BrawlCard temp=Brawl.discard[0].playCard();
          }
          else
            JOptionPane.showMessageDialog(null,"Invalid Play!");
        }
      }
      else if(e.getSource()==base[1][1]) {
        if(Brawl.discard[0].getCard().equals("Freeze")||Brawl.discard[0].getCard().equals("Clear")||Brawl.discard[0].getCard().equals("Base"))
          JOptionPane.showMessageDialog(null,"Invalid Play!");
        else {
          played=Brawl.playArea.playToBase(Brawl.playArea.check(1).getLocation(),2,Brawl.discard[0].getCard());
          if(played==true) {
            BrawlCard temp=Brawl.discard[0].playCard();
          }
          else
            JOptionPane.showMessageDialog(null,"Invalid Play!");
        }
      }
      else if(e.getSource()==base[2][0]) {
        if(Brawl.discard[0].getCard().equals("Freeze")||Brawl.discard[0].getCard().equals("Clear")||Brawl.discard[0].getCard().equals("Base"))
          JOptionPane.showMessageDialog(null,"Invalid Play!");
        else {
          played=Brawl.playArea.playToBase(Brawl.playArea.check(2).getLocation(),1,Brawl.discard[0].getCard());
          if(played==true) {
            BrawlCard temp=Brawl.discard[0].playCard();
          }
          else
            JOptionPane.showMessageDialog(null,"Invalid Play!");
        }
      }
      else if(e.getSource()==base[2][1]) {
          if(Brawl.discard[0].getCard().equals("Freeze")||Brawl.discard[0].getCard().equals("Clear")||Brawl.discard[0].getCard().equals("Base"))
            JOptionPane.showMessageDialog(null,"Invalid Play!");
          else {
            played=Brawl.playArea.playToBase(Brawl.playArea.check(2).getLocation(),2,Brawl.discard[0].getCard());
            if(played==true) {
              BrawlCard temp=Brawl.discard[0].playCard();
            }
            else
              JOptionPane.showMessageDialog(null,"Invalid Play!");
          }
        }
      else if(e.getSource()==freeze[0]) {
        if(Brawl.discard[0].getCard().toString().equals("Freeze")) {
          played=Brawl.playArea.playToBase(Brawl.playArea.check(0).getLocation(),1,Brawl.discard[0].getCard());
          if(played==true) {
            BrawlCard temp=Brawl.discard[0].playCard();
          }
          else
            JOptionPane.showMessageDialog(null,"Invalid Play!");
        }
        else if(Brawl.discard[0].getCard().toString().equals("Clear")) {
          played=Brawl.playArea.clearBase(Brawl.playArea.check(0).getLocation());
          if(played==true) {
            BrawlCard temp=Brawl.discard[0].playCard();
          }
          else
            JOptionPane.showMessageDialog(null,"Invalid Play!");
          }
        else
          JOptionPane.showMessageDialog(null,"Invalid Play!");
      }
      else if(e.getSource()==freeze[1]) {
        if(Brawl.discard[0].getCard().toString().equals("Freeze")) {
          played=Brawl.playArea.playToBase(Brawl.playArea.check(1).getLocation(),1,Brawl.discard[0].getCard());
          if(played==true) {
            BrawlCard temp=Brawl.discard[0].playCard();
          }
          else
            JOptionPane.showMessageDialog(null,"Invalid Play!");
        }
        else if(Brawl.discard[0].getCard().toString().equals("Clear")) {
          played=Brawl.playArea.clearBase(Brawl.playArea.check(1).getLocation());
          if(played==true) {
            BrawlCard temp=Brawl.discard[0].playCard();
          }
          else
            JOptionPane.showMessageDialog(null,"Invalid Play!");
        }
        else
          JOptionPane.showMessageDialog(null,"Invalid Play!");
      }
      else if(e.getSource()==freeze[2]) {
        if(Brawl.discard[0].getCard().toString().equals("Freeze")) {
          played=Brawl.playArea.playToBase(Brawl.playArea.check(2).getLocation(),1,Brawl.discard[0].getCard());
          if(played==true) {
            BrawlCard temp=Brawl.discard[0].playCard();
          }
          else
            JOptionPane.showMessageDialog(null,"Invalid Play!");
        }
        else if(Brawl.discard[0].getCard().toString().equals("Clear")) {
          played=Brawl.playArea.clearBase(Brawl.playArea.check(2).getLocation());
          if(played==true) {
            BrawlCard temp=Brawl.discard[0].playCard();
          }
          else
            JOptionPane.showMessageDialog(null,"Invalid Play!");
        }
        else
          JOptionPane.showMessageDialog(null,"Invalid Play!");
      }
      else
        System.out.println("You screwed up. No Button performed. You hit"+e.getActionCommand());
      playField.removeAll();
      players[0].removeAll();
      players[1].removeAll();
      buildPlayField();
      buildPlayers();
      contentPane.invalidate();
      contentPane.validate();
      contentPane.repaint();
      if(Brawl.exitValue()==true) {
        short winner=Brawl.playArea.calculateScore();
        String win="";
        if(winner!=0) {
          win=String.format("  Player %d, Wins!!",winner);
        }
        else {
          win="              It is a Draw.";
        }
        JOptionPane.showMessageDialog(null,win,"Winner",JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
      }
    }
  });
}
