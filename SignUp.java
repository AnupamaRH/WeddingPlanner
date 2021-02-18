import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import java.awt.event.*;
import java.sql.*;
public class SignUp extends JFrame
{
	//private static final long serialVersionUID = 1L;
	JFrame f;
	JTextField namef,t2,pht;
	JLabel l1,name,pass,l4,l5,email,ph,si;
	JPasswordField passf;
	JButton b1;
	Color brown = Color.decode("#b08913");
	Color yelow=Color.decode("#BDA55D");
	Color Reg=Color.decode("#5c4102");
	SignUp()
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
		JPanel p9=new JPanel();
		JPanel p10=new JPanel();
		JPanel p11=new JPanel();
		l1=new JLabel("Register",JLabel.CENTER);
		l1.setFont(new Font("Forte", Font.BOLD, 50));
		l1.setForeground(Reg);
		name=new JLabel("Name       ");
		name.setFont(new Font("Times New Roman", Font.BOLD, 20));
		namef=new JTextField(15);
		Font bigFont = namef.getFont().deriveFont(Font.PLAIN, 20f);
        namef.setFont(bigFont);
		email=new JLabel("E-mail      ");
		email.setFont(new Font("Times New Roman", Font.BOLD, 20));
		t2=new JTextField(15);
		Font bigFont1 = t2.getFont().deriveFont(Font.PLAIN, 20f);
        t2.setFont(bigFont1);
		pass=new JLabel("Password ");
		pass.setFont(new Font("Times New Roman", Font.BOLD, 20));
		passf=new JPasswordField(15);
		Font bigPFont = passf.getFont().deriveFont(Font.PLAIN, 20f);
        passf.setFont(bigPFont);
		ph=new JLabel("Phone No.");
		ph.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pht=new JTextField(15);
		Font bigFont2= pht.getFont().deriveFont(Font.PLAIN, 20f);
        pht.setFont(bigFont2);
		l4=new JLabel("_____________________________________________________");
		b1=new JButton("SignUp");
		b1.setBackground(Color.lightGray);
		l5=new JLabel("Already have an Account?");
		si=new JLabel("Sign In");
		f.setContentPane(new JLabel(new ImageIcon("C:\\Program Files\\Java\\Pro4.jpg")));
		p2.add(l1); //register
		p1.add(p2);//sub panel
		p3.add(l4);//dash
		p1.add(p3);
		p4.add(name);p4.add(namef);//name
		p1.add(p4);
		p9.add(email);p9.add(t2);//email
		p1.add(p9);
		p11.add(ph);p11.add(pht);//phone
		p1.add(p11);
		p5.add(pass);p5.add(passf);//paswrd
		p1.add(p5);
		p7.add(b1);
		p1.add(p7);
		p8.add(l5);
		p8.add(si);
		p1.add(p8);
		p1.setBorder(new EmptyBorder(new Insets(50, 100, 100, 50)));
		//p1.setBounds(100, 11, 200, 140);
		p1.setAlignmentX(Component.CENTER_ALIGNMENT);
		p1.setBorder(BorderFactory.createLineBorder(Color.black));
		p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
		p6.add(p1);
		f.setLayout(new GridBagLayout());
		f.add(p6, new GridBagConstraints());
		p6.setPreferredSize(new Dimension(400,400));
        //f.setSize(new Dimension(200, 200));
		//f.setLayout(new FlowLayout());
		f.setSize(700,800); 
		p2.setOpaque(true);
		p2.setBackground(brown);
		p3.setBackground(yelow);
		p4.setBackground(yelow);
		p5.setBackground(yelow);
		p6.setBackground(yelow);
		p1.setBackground(yelow);
		p8.setBackground(yelow);
		p9.setBackground(yelow);
		p11.setBackground(yelow);
		p7.setBackground(yelow);

		si.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				f.dispose();
				Project pro=new Project();
				pro.setVisible(true);
			}
		});
		b1.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) {
                String emailId = t2.getText();
                String password =new String(passf.getPassword());
				String name=namef.getText();
                //String name_database,email,password1;
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
                    Statement st = null;
                    
                    st = connection.createStatement();
                  int res = st.executeUpdate("INSERT INTO register VALUES('"+name + "','"+emailId+ "','" +password+"')");
				  if (res == 0)
					  JOptionPane.showMessageDialog(b1, "This is alredy exist");
				   else 
				    {
					  JOptionPane.showMessageDialog(b1,"Welcome, Your account is sucessfully created");
					  dispose();
					  Project login=new Project();
					  login.setVisible(true);
					}
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            
        });

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		new SignUp();
	}
}