import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.Graphics;
public class Bill extends JFrame
{
   public void paintComponent(Graphics g)
   {
      super.paintComponents(g);
      g.setColor(Color.black);
      g.drawRect(0,0,400,400);
   }
 Bill()
  {
   JFrame f=new JFrame("Bill");
   f.setContentPane(new JLabel(new ImageIcon("C:\\Program Files\\Java\\bill.jpg")));
   JLabel l1,l2,l3,l4,l5,l6;
   l1=new JLabel("Grand Events");
   l1.setBounds(600,-50,3000,500); 
   l1.setFont(new Font("Gabriola", Font.BOLD, 60));
   l2=new JLabel();
   l2.setBounds(500,150,1000,300);
   //name.setBounds(800,135,1000,300);
   l2.setFont(new Font("Gabriola", Font.BOLD, 30)); 
   l3=new JLabel("	Venue:");
   l3.setBounds(500,200,1000,300);
   l3.setFont(new Font("Gabriola", Font.BOLD, 30)); 
   l4=new JLabel("	Decoration:");
   l4.setBounds(500,250, 1000,300); 
   l4.setFont(new Font("Gabriola", Font.BOLD, 30));
   l5=new JLabel("	Food:");
   l5.setBounds(500,300, 1000,300);
   l5.setFont(new Font("Gabriola", Font.BOLD, 30)); 
   l6=new JLabel("	Total Amount:");
   l6.setBounds(500,350, 1000,300);  
   l6.setFont(new Font("Gabriola", Font.BOLD, 30));
   f.add(l1);
   f.add(l2);
   f.add(l3);
   f.add(l4);
   f.add(l5);
   f.add(l6);
   f.setSize(2100,1100);
   f.setLayout(null);
   f.setVisible(true);
   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   try
   {
       Class.forName("org.postgresql.Driver");
   }
   catch(Exception ex)
   {
      System.out.println("not found");
   }
   try{
         ResultSet rs;
         Connection connection = DriverManager.getConnection("jdbc:postgresql://ziggy.db.elephantsql.com/","neyalvyx","Wi79_4saB3Ys3HYCbvzmjod1Lrme4E_1");
         PreparedStatement pst = null;
         pst = connection.prepareStatement("SELECT * FROM exploredb;");
         rs = pst.executeQuery();
      int venuecharge,foodcharge,deccharge;
      while(rs.next())
      {
         String n=rs.getString("email");
         l2.setText("Email:            "+n);
         int ppls=rs.getInt("attendees");
         String v=rs.getString("venue");
         l3.setText("Venue:           "+v);
         if(v=="Adlux")
          venuecharge=200000;
         else if(v=="Cial")
            venuecharge=100000;
         else if(v=="Abad")
            venuecharge=50000;
         else if(v=="Town Hall")
            venuecharge=40000;
         else
            venuecharge=75000;
         String d=rs.getString("decoration");
         l4.setText("Decoration:   "+d);
         if(d=="Vintage")
            deccharge=60000;
         else if(d=="Traditional")
            deccharge=75000;
         else
            deccharge=90000;
         String fd=rs.getString("food");
         l5.setText("Food:             "+fd);
         if(fd=="Premium")
            foodcharge=ppls*1000;
         else if(fd=="Gold")
            foodcharge=ppls*500;
         else
            foodcharge=ppls*250;
            int t=venuecharge+foodcharge+deccharge;
         String total=String.valueOf(t);
         l6.setText("Total:            "+total);
      }  
      pst.close();
      connection.close();
    }
    catch(Exception e)
    { System.out.println("ERROR 1");}
   }
}