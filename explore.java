import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.Enumeration;
import java.sql.*;
class explore extends JComponent 
{
    //private static final long serialVersionUID = 1L;
    JFrame f=new JFrame("Plan Your Event");
    JLabel date,ppl,venue,dec,food,cam;
    JRadioButton b200,b500,b1000,babove,bvint,btrad,bclas,badlux,babad,bflora,btown,bcial,bprem,bsilv,bgold,bprem1,bsilv1,bgold1;
    JButton bill,bcheck;
    Color brown = Color.decode("#b08913");
	  Color yelow=Color.decode("#BDA55D");
    Color wood=Color.decode("#D29E01");
    String emailhere,attend,ven,deco,fud,camera;
    Connection conn;
    ButtonGroup bg1;
  explore(String email)
  {
    emailhere=email;
    //for date
     date=new JLabel("Date:       ");
     String s1[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec"};
     String s2[]={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    JComboBox month=new JComboBox(s1);
    JComboBox dates=new JComboBox(s2);
    bcheck=new JButton("Check Availability");bcheck.setBackground(wood);
    JPanel datep=new JPanel();
    datep.add (date);
    datep.add(month);
    datep.add(dates);
    datep.add(bcheck);
    datep.setBackground(brown);
    bcheck.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        try{
          Connection conn = DriverManager.getConnection("jdbc:postgresql://ziggy.db.elephantsql.com/","neyalvyx","Wi79_4saB3Ys3HYCbvzmjod1Lrme4E_1");
          java.sql.Statement sta=conn.createStatement();
          java.sql.ResultSet rst=sta.executeQuery("SELECT date,venue from exploredb");
          String result=month.getSelectedItem()+"-"+dates.getSelectedItem();
          while(rst.next())
          {
            if(result.equals(rst.getString("date"))==true)
            {
              for (Enumeration<AbstractButton> buttonsat = bg1.getElements(); buttonsat.hasMoreElements();)
               {
                 System.out.println("onnu work aavo?");
                AbstractButton buttonat = buttonsat.nextElement();
                System.out.println(buttonat.getText());
                System.out.println(rst.getString("venue"));
                boolean a=(buttonat.getText()).equals(rst.getString("venue"));
                System.out.println(a);
                if (a==true)
                {
                  buttonat.setEnabled(false);
                  continue;
                }
              }
            }
          }
         }
          catch(Exception e1)
          {
            System.out.println("ERROR 1");
          }
        
      }
    });
    f.setSize(1280,853);
    f.setContentPane(new JLabel(new ImageIcon("D:\\oop JAVA\\WedPlanner\\pro2.jpg")));
   //for no of people
   ppl=new JLabel("     No.of People(max):   ");
   b200=new JRadioButton("200");   
   b200.setBackground(brown); 
   b500=new JRadioButton("500");  b500.setBackground(brown);  
   b1000=new JRadioButton("1000"); b1000.setBackground(brown);
   babove=new JRadioButton("above 1000");babove.setBackground(brown);
   ButtonGroup bg=new ButtonGroup();
   bg.add(b200);bg.add(b500);bg.add(b1000);bg.add(babove);
   JPanel pplp=new JPanel();
   pplp.add(ppl);pplp.add(b200);pplp.add(b500);pplp.add(b1000);pplp.add(babove);
   pplp.setBackground(brown);
   //for venue
   venue=new JLabel("                                                Venue:   ");
   badlux=new JRadioButton("Adlux");badlux.setBackground(brown);
   bcial=new JRadioButton("Cial");bcial.setBackground(brown);
   babad=new JRadioButton("Abad");babad.setBackground(brown);
   btown=new JRadioButton("Town Hall");btown.setBackground(brown);
   bflora=new JRadioButton("Flora");bflora.setBackground(brown);
   bg1=new ButtonGroup();
   bg1.add(badlux);bg1.add(bcial);bg1.add(babad);bg1.add(btown);bg1.add(bflora);
   JPanel venuep=new JPanel();
   venuep.add(venue);venuep.add(badlux);venuep.add(bcial);venuep.add(babad);venuep.add(btown);venuep.add(bflora);
   venuep.setBackground(brown);
    //for Decoration
    dec=new JLabel("                Decoration:   ");
    bvint=new JRadioButton("Vintage");bvint.setBackground(brown);
    btrad=new JRadioButton("Traditional");btrad.setBackground(brown);
    bclas=new JRadioButton("Classic");bclas.setBackground(brown);
    ButtonGroup bg2=new ButtonGroup();
    bg2.add(btrad);bg2.add(bvint);bg2.add(bclas);
    JPanel decp=new JPanel();
    decp.add(dec);decp.add(bvint);decp.add(btrad);decp.add(bclas);
    decp.setBackground(brown);
     //for food
     food=new JLabel("                 Food:  ");
     bprem=new JRadioButton("Premium");bprem.setBackground(brown);
     bgold=new JRadioButton("Gold");bgold.setBackground(brown);
     bsilv=new JRadioButton("Silver");bsilv.setBackground(brown);
     ButtonGroup bg3=new ButtonGroup();
     bg3.add(bprem);bg3.add(bgold);bg3.add(bsilv);
     JPanel foodp =new JPanel();
     foodp.add(food);foodp.add(bprem);foodp.add(bgold);foodp.add(bsilv);
     foodp.setBackground(brown);
     //for camera and video
     cam=new JLabel("Camera & Video:");cam.setBackground(brown);
     bprem1=new JRadioButton("Premium");bprem1.setBackground(brown);
     bgold1=new JRadioButton("Gold");bgold1.setBackground(brown);
     bsilv1=new JRadioButton("Silver");bsilv1.setBackground(brown);
     ButtonGroup bg4=new ButtonGroup();
     bg4.add(bprem1);bg4.add(bgold1);bg4.add(bsilv1);
     JPanel camp =new JPanel();
     camp.add(cam);camp.add(bprem1);camp.add(bgold1);camp.add(bsilv1);
     camp.setBackground(brown);
    //for bill
    bill=new JButton("Get My Bill");bill.setBackground(wood);
    
    JPanel p=new JPanel();
    p.add(datep);p.add(pplp);p.add(venuep);p.add(decp);p.add(foodp);p.add(camp);p.add(bill);
    GridLayout layout = new GridLayout(10,1);
    layout.setVgap(25);
    p.setLayout(layout);
    f.add(p); 
    bill.setBounds(350,1000, 100,50);
    f.setLayout(new GridBagLayout());
    f.setVisible(true);
    f.setSize(700,800);
    p.setBackground(yelow);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    bill.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) 
      {
        //venue
        for (Enumeration<AbstractButton> buttons = bg1.getElements(); buttons.hasMoreElements();) {
          AbstractButton button = buttons.nextElement();
  
          if (button.isSelected())
          {
              ven=button.getText();
          }
        }
        //attendees
        for (Enumeration<AbstractButton> buttonsat = bg.getElements(); buttonsat.hasMoreElements();) {
          AbstractButton buttonat = buttonsat.nextElement();
  
          if (buttonat.isSelected())
            attend=buttonat.getText();
        }
        //food
        for (Enumeration<AbstractButton> buttonfud = bg3.getElements(); buttonfud.hasMoreElements();) {
          AbstractButton bfud = buttonfud.nextElement();
  
          if (bfud.isSelected())
            fud=bfud.getText();
        }
        //camera
        for (Enumeration<AbstractButton> buttonscam = bg4.getElements(); buttonscam.hasMoreElements();) {
          AbstractButton buttonc = buttonscam.nextElement();
  
          if (buttonc.isSelected()) 
            camera=buttonc.getText();
        }
        //decorations
        for (Enumeration<AbstractButton> butdec = bg2.getElements(); butdec.hasMoreElements();) {
          AbstractButton decbut = butdec.nextElement();
  
          if (decbut.isSelected()) {
            deco=decbut.getText();
          }
        }
        try
   {
       Class.forName("org.postgresql.Driver");
   }
   catch(Exception ex)
   {
      System.out.println("not found");
   }
        try{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://ziggy.db.elephantsql.com/","neyalvyx","Wi79_4saB3Ys3HYCbvzmjod1Lrme4E_1");
        java.sql.Statement st=conn.createStatement();
        String query="INSERT INTO exploredb VALUES(\'"+month.getSelectedItem()+"-"+dates.getSelectedItem()+"','"+emailhere+"',"+attend+",'"+ven+"','"+fud+"','"+camera+"','"+deco+"');";
        int g=st.executeUpdate(query);
        System.out.println(query);
        Bill b=new Bill();
	f.dispose();
        b.setVisible(true);
        }
        catch(Exception e1)
        {
          System.out.println("ERROR");
        }
      }
    });
  }  
}