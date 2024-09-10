import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm implements ActionListener {
    JFrame f = new JFrame("Login Form (User's Authentication)");

    JLabel lbtitle, lbpname, lblogin, lbid, lbpass;
    JTextField tfid, tfpass;
    JButton butlogin, butcancel;

    LoginForm() {
        f.setBackground(Color.yellow);
        f.setSize(1920, 1080);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        lbtitle = new JLabel("A Mini Project");
        lbpname = new JLabel("Students Campus Placement Information System");
        lblogin = new JLabel("Login Form (User's Authentication)");
        lbid = new JLabel("User ID : ");
        lbpass = new JLabel("Password : ");
        tfid = new JTextField();
        tfpass = new JTextField();

        butlogin = new JButton("Login");
        butcancel = new JButton("Cancel");
        butlogin.addActionListener(this);
        butcancel.addActionListener(this);

        Font f1 = new Font("arial black", Font.PLAIN, 50);
        Font f2 = new Font("arial", Font.BOLD, 40);
        Font f3 = new Font("arial", Font.PLAIN, 30);
        Font f4 = new Font("times new roman", Font.BOLD, 20);

        f.add(lbtitle);
        f.add(lbpname);
        f.add(lblogin);
        f.add(lbid);
        f.add(lbpass);
        f.add(tfid);
        f.add(tfpass);
        f.add(butlogin);
        f.add(butcancel);

        lbtitle.setFont(f1);
        lbtitle.setForeground(Color.RED);
        lbpname.setFont(f2);
        lbpname.setForeground(Color.BLUE);
        lblogin.setFont(f3);
        lblogin.setForeground(Color.MAGENTA);
        lbid.setFont(f4);
        tfid.setFont(f4);
        lbpass.setFont(f4);
        tfpass.setFont(f4);
        butlogin.setFont(f4);
        butcancel.setFont(f4);

        lbtitle.setBounds(600, 50, 400, 60);
        lbpname.setBounds(300, 150, 1000, 50);
        lblogin.setBounds(550, 225, 500, 40);
        lbid.setBounds(600, 350, 700, 30);
        tfid.setBounds(750, 350, 200, 30);
        lbpass.setBounds(600, 450, 700, 30);
        tfpass.setBounds(750, 450, 200, 30);
        butlogin.setBounds(550, 550, 100, 30);
        butcancel.setBounds(900, 550, 100, 30);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butlogin) {
            String id = tfid.getText();
            String pass = tfpass.getText();
            if(id.equals("sr") && pass.equals("sr123"))
                new main_menu();
            else 
            JOptionPane.showMessageDialog(f,"You have Entered Invalid Id or Password Please Check!");
            
        } else if (ae.getSource() == butcancel)
            System.exit(0);
    }

    public static void main(String args[]) {
        new LoginForm();
    }
}