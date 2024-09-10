import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class main_menu implements ActionListener
{
JFrame f=new JFrame("Main Menu of the Project");
JLabel lbtitle,lbpname,lbmain,lbm1,lbm2,lbm3,lbprimary,lbplacement,lbonline,lbclose;
JButton butprimary,butplacement,butonline,butclose;
main_menu()
{
f.setSize(1600,900);
f.setVisible(true);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

lbtitle=new JLabel("A Mini Project");
lbpname=new JLabel("Students Campus Placement Information System");
lbmain=new JLabel("Main Menu of the Project");
lbm1=new JLabel("Module 1");
lbm2=new JLabel("Module 2");
lbm3=new JLabel("Module 3");
lbprimary=new JLabel("Primary Data Retrival Module");
lbplacement=new JLabel("Placement Transactions Data Entry Module");
lbonline=new JLabel("Online Information (Reports) Module");
lbclose=new JLabel("Close(quit) the project");

butprimary=new JButton();
butplacement=new JButton();
butonline=new JButton();
butclose=new JButton();

butprimary.addActionListener(this);
butplacement.addActionListener(this);
butonline.addActionListener(this);
butclose.addActionListener(this);

Font f1=new Font("arial black",Font.PLAIN,50);
Font f2=new Font("arial",Font.BOLD,40);
Font f3=new Font("arial",Font.PLAIN,30);
Font f4=new Font("times new roman",Font.PLAIN,20);


f.add(lbtitle);
f.add(lbpname);
f.add(lbmain);
f.add(lbm1);
f.add(lbm2);
f.add(lbm3);
f.add(lbprimary);
f.add(lbplacement);
f.add(lbonline);
f.add(lbclose);
f.add(butprimary);
f.add(butplacement);
f.add(butonline);
f.add(butclose);

lbtitle.setFont(f1);
lbtitle.setForeground(Color.RED);
lbpname.setFont(f2);
lbpname.setForeground(Color.BLUE);
lbmain.setFont(f3);
lbmain.setForeground(Color.MAGENTA);
lbm1.setFont(f4);
lbm2.setFont(f4);
lbm3.setFont(f4);
lbprimary.setFont(f4);
lbplacement.setFont(f4);
lbonline.setFont(f4);
lbclose.setFont(f4);
butprimary.setFont(f4);
butplacement.setFont(f4);
butonline.setFont(f4);
butclose.setFont(f4);

lbtitle.setBounds(550,50,400,60);
lbpname.setBounds(300,150,1000,50);
lbmain.setBounds(575,225,500,40);

lbm1.setBounds(450,300,200,30);
butprimary.setBounds(600,300,50,30);
lbprimary.setBounds(700,300,500,30);

lbm2.setBounds(450,350,200,30);
butplacement.setBounds(600,350,50,30);
lbplacement.setBounds(700,350,500,30);

lbm3.setBounds(450,400,200,30);
butonline.setBounds(600,400,50,30);
lbonline.setBounds(700,400,500,30);

butclose.setBounds(600,450,50,30);
lbclose.setBounds(700,450,500,30);
}
public void actionPerformed(ActionEvent ae)
{
if (ae.getSource()==butprimary)
new primary();
else if (ae.getSource()==butplacement)
new placement();
else if (ae.getSource()==butonline)
new online();
else if (ae.getSource()==butclose)
System.exit(0);
}
}
