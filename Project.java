import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.BorderFactory;
public class Project extends JFrame
{
	int flag=3;
	JFrame f;
	JTextField t1,t2;
	JLabel l1,l2,l3,l4,l5,su;
	JPasswordField tp;
	JButton b1;
	Color brown = Color.decode("#b08913");
	Color yelow=Color.decode("#BDA55D");

	Project()
	{
		f=new JFrame("Wedding Planner");
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		JPanel p6=new JPanel(new BorderLayout());
		JPanel p7=new JPanel();
		JPanel p8=new JPanel(new FlowLayout());
		//ImageIcon im=new ImageIcon("C:\\Program Files\\Java\\Pro5.jpg");
		l1=new JLabel("WELCOME",JLabel.CENTER);
		l1.setFont(new Font("Lucida Calligraphy", Font.BOLD, 50));
		l1.setForeground(Color.BLACK);
		l2=new JLabel("     E-mail");
		l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		t1=new JTextField(15);
		Font bigFont = t1.getFont().deriveFont(Font.PLAIN, 20f);
        t1.setFont(bigFont);
		l3=new JLabel("Password");
		l3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tp=new JPasswordField(15);
		Font bigPFont = tp.getFont().deriveFont(Font.PLAIN, 20f);
        tp.setFont(bigPFont);
		l4=new JLabel("_______");
		b1=new JButton("Log In");
		b1.setBackground(Color.lightGray);
		l5=new JLabel("Dont have an Account?");
		su=new JLabel("Sign Up");
		su.setForeground(Color.darkGray);
		f.setContentPane(new JLabel(new ImageIcon("C:\\Program Files\\Java\\Pro4.jpg")));
		p2.add(l1); //welcome
		p1.add(p2);//sub panel
		p3.add(l4);
		p1.add(p3);
		p4.add(l2);//username
		p4.add(t1);
		p1.add(p4);//paswrd
		p5.add(l3);p5.add(tp);
		p1.add(p5);
		p7.add(b1);
		p1.add(p7);
		p8.add(l5);
		p8.add(su);
		p1.add(p8);
		p1.setBorder(new EmptyBorder(new Insets(50, 100, 100, 50)));
		//p1.setBounds(100, 11, 200, 140);
		p1.setAlignmentX(Component.CENTER_ALIGNMENT);
		p1.setBorder(BorderFactory.createLineBorder(Color.black));
		p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
		p6.add(p1);
		f.setLayout(new GridBagLayout());
		f.add(p6, new GridBagConstraints());
		p6.setPreferredSize(new Dimension(400,300));
        //f.setSize(new Dimension(200, 200));
		//f.setLayout(new FlowLayout());
		f.setSize(700,800); 
		p6.setOpaque(false);
		p2.setBackground(brown);
		p3.setBackground(yelow);
		p4.setBackground(yelow);
		p5.setBackground(yelow);
		p1.setBackground(yelow);
		p7.setBackground(yelow);
		p8.setBackground(yelow);
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		su.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				f.dispose();
				SignUp signu=new SignUp();
				signu.setVisible(true);
			}
		});
        b1.addActionListener(new ActionListener() 
{
    public void actionPerformed(ActionEvent e) {
        String emailId = t1.getText();
        String password =new String(tp.getPassword());
        String emailid,password1;

        try
        {
            Class.forName("org.postgresql.Driver");
        }
        catch(Exception ex)
        {
           System.out.println("not found");
        }
        try {
            ResultSet rs;
            Connection connection = DriverManager.getConnection("jdbc:postgresql://ziggy.db.elephantsql.com/","neyalvyx","Wi79_4saB3Ys3HYCbvzmjod1Lrme4E_1");
            PreparedStatement pst = null;
            
            pst = connection.prepareStatement("SELECT * FROM register;");
//                  }
          rs = pst.executeQuery();
          while(rs.next())
          {
              emailId = rs.getString("email");
			  password1 = rs.getString("password");

           if(emailId.equals(t1.getText())&& password.equals(password1)) {
               JOptionPane.showMessageDialog(b1, "Welcome");
               f.dispose();
               explore comp=new explore(emailId);
               comp.setVisible(true);
               flag=0;
               break;
           }
           else {
               flag=-1;
      	    //	 JOptionPane.showMessageDialog(b1, "please SignIn first");
           }
          }
            
          if(flag==-1) {
            pst = connection.prepareStatement("SELECT * FROM register;");
//                    }
            rs = pst.executeQuery();
            while(rs.next())
            {
                emailid = rs.getString("email");
             password1 = rs.getString("password");

             if(t1.getText().equals(emailid) && password.equals(password1)) {
                 JOptionPane.showMessageDialog(b1, "Welcome");
                 f.dispose();
                 explore exploring=new explore(emailid);
                 exploring.setVisible(true);
				 flag=0;
                 break;
             }
             else {
    	    	 JOptionPane.showMessageDialog(b1, "INVALID email or password !\n Are you new? Then please create an account");
             }
            }
          }
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
});
		
	}
	public static void main(String[] args)
	{
		new Project();
	}
}