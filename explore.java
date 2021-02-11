import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
class explore extends JComponent
{
    private static final long serialVersionUID = 1L;
    JFrame f=new JFrame();
    JLabel date,ppl,venue,dec,food,cam;
    JRadioButton b200,b500,b1000,babove,bvint,btrad,bclas,badlux,babad,bflora,btown,bcial,bprem,bsilv,bgold,bprem1,bsilv1,bgold1;
    JButton bill;
    Color mainDark = Color.decode("#1C3558");
    Color mainLight = Color.decode("#516F8C");


  explore(String email)
  {
    //for date
     date=new JLabel("Date:       ");
     String s1[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec"};
     String s2[]={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    JComboBox month=new JComboBox(s1);
    JComboBox dates=new JComboBox(s2);
    JPanel datep=new JPanel();
    datep.add (date);
    datep.add(month);
    datep.add(dates);
    
   //for no of people
   ppl=new JLabel("     No.of People(max):   ");
   b200=new JRadioButton("200");    
   b500=new JRadioButton("500");    
   b1000=new JRadioButton("1000"); 
   babove=new JRadioButton("above 1000");
   ButtonGroup bg=new ButtonGroup();
   bg.add(b200);bg.add(b500);bg.add(b1000);bg.add(babove);
   JPanel pplp=new JPanel();
   pplp.add(ppl);pplp.add(b200);pplp.add(b500);pplp.add(b1000);pplp.add(babove);

   //for venue
   venue=new JLabel("                                                Venue:   ");
   badlux=new JRadioButton("Adlux");
   bcial=new JRadioButton("Cial");
   babad=new JRadioButton("Abad");
   btown=new JRadioButton("Town Hall");
   bflora=new JRadioButton("Flora");
   ButtonGroup bg1=new ButtonGroup();
   bg1.add(badlux);bg1.add(bcial);bg1.add(babad);bg1.add(btown);bg1.add(bflora);
   JPanel venuep=new JPanel();
   venuep.add(venue);venuep.add(badlux);venuep.add(bcial);venuep.add(babad);venuep.add(btown);venuep.add(bflora);

    //for Decoration
    dec=new JLabel("                Decoration:   ");
    bvint=new JRadioButton("Vintage");
    btrad=new JRadioButton("Traditional");
    bclas=new JRadioButton("Classic");
    ButtonGroup bg2=new ButtonGroup();
    bg2.add(btrad);bg2.add(bvint);bg2.add(bclas);
    JPanel decp=new JPanel();
    decp.add(dec);decp.add(bvint);decp.add(btrad);decp.add(bclas);

     //for food
     food=new JLabel("                 Food:  ");
     bprem=new JRadioButton("Premium");
     bgold=new JRadioButton("Gold");
     bsilv=new JRadioButton("Silver");
     ButtonGroup bg3=new ButtonGroup();
     bg3.add(bprem);bg3.add(bgold);bg3.add(bsilv);
     JPanel foodp =new JPanel();
     foodp.add(food);foodp.add(bprem);foodp.add(bgold);foodp.add(bsilv);

     //for camera and video
     cam=new JLabel("Camera & Video:");
     bprem1=new JRadioButton("Premium");
     bgold1=new JRadioButton("Gold");
     bsilv1=new JRadioButton("Silver");
     ButtonGroup bg4=new ButtonGroup();
     bg4.add(bprem1);bg4.add(bgold1);bg4.add(bsilv1);
     JPanel camp =new JPanel();
     camp.add(cam);camp.add(bprem1);camp.add(bgold1);camp.add(bsilv1);

    //for bill
    bill=new JButton("Get My Bill");
    
    JPanel p=new JPanel();
    p.add(datep);p.add(pplp);p.add(venuep);p.add(decp);p.add(foodp);p.add(camp);p.add(bill);
    //p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS)); 
    //p.setLayout(new GridLayout(10,1));;
    GridLayout layout = new GridLayout(10,1);
    layout.setVgap(25);
    p.setLayout(layout);
    f.add(p); 
    bill.setBounds(350,1000, 100,50);
    f.setLayout(new GridBagLayout());
    f.setVisible(true);
    f.setSize(700,800);
    p.setBackground(mainDark);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
//  public static void main(String args[])
//  {
//      new explore();
//  }   
}