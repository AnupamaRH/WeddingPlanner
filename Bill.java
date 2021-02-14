import javax.swing.*;
import java.awt.*;

public class Bill extends JFrame
{
 Bill()
  {
   JFrame f=new JFrame("Bill");
   JLabel l1,l2,l3,l4,l5,l6;
   l1=new JLabel("     Grand Events");
   l1.setBounds(600,-50,3000,500); 
   l1.setFont(new Font("Gabriola", Font.BOLD, 60));
   l2=new JLabel("	Name:");
   l2.setBounds(500,150,1000,300);
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
   f.setSize(300,300);
   f.setLayout(null);
   f.setVisible(true);
   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}