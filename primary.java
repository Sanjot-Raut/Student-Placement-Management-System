import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class primary implements ActionListener {
    JFrame f = new JFrame("Students Campus Placement Information System");
    JLabel lbtitle, lbname, lbstudent, lbacademic, lbcertified, lbjob, lbback;
    JButton butstudent, butacademic, butcertified, butjob, butback;

    primary() {
        f.setSize(1600, 900);
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbtitle = new JLabel("Students Campus Placement Information System");
        lbname = new JLabel("Module 1 : Primary Data Retrival Module");
        lbstudent = new JLabel("Students Registration for Job Placement(data retrival form)");
        lbacademic = new JLabel("Registered Students Academic Results (data retrival form)");
        lbcertified = new JLabel("Registered Students Certified Courses data retrival");
        lbjob = new JLabel("Job provider Company's Data retrival form");
        lbback = new JLabel("Back to Main Menu of the Project");

        butstudent = new JButton();
        butacademic = new JButton();
        butcertified = new JButton();
        butjob = new JButton();
        butback = new JButton();

        butstudent.addActionListener(this);
        butacademic.addActionListener(this);
        butcertified.addActionListener(this);
        butjob.addActionListener(this);
        butback.addActionListener(this);

        Font f1 = new Font("arial black", Font.PLAIN, 50);
        Font f2 = new Font("arial", Font.BOLD, 40);
        Font f4 = new Font("times new roman", Font.PLAIN, 20);

        f.add(lbtitle);
        f.add(lbname);
        f.add(lbstudent);
        f.add(lbacademic);
        f.add(lbcertified);
        f.add(lbjob);
        f.add(lbback);
        f.add(butstudent);
        f.add(butacademic);
        f.add(butcertified);
        f.add(butjob);
        f.add(butback);

        lbtitle.setFont(f1);
        lbtitle.setForeground(Color.RED);
        lbname.setFont(f2);
        lbname.setForeground(Color.blue);
        lbstudent.setFont(f4);
        lbacademic.setFont(f4);
        lbcertified.setFont(f4);
        lbjob.setFont(f4);
        lbback.setFont(f4);
        butstudent.setFont(f4);
        butacademic.setFont(f4);
        butcertified.setFont(f4);
        butjob.setFont(f4);
        butback.setFont(f4);

        lbtitle.setBounds(100, 50, 1500, 60);
        lbname.setBounds(350, 150, 1200, 50);

        lbstudent.setBounds(600, 300, 500, 30);
        butstudent.setBounds(450, 300, 50, 30);

        lbacademic.setBounds(600, 350, 500, 30);
        butacademic.setBounds(450, 350, 50, 30);

        lbcertified.setBounds(600, 400, 500, 30);
        butcertified.setBounds(450, 400, 50, 30);

        lbjob.setBounds(600, 450, 500, 30);
        butjob.setBounds(450, 450, 50, 30);

        lbback.setBounds(600, 500, 500, 30);
        butback.setBounds(450, 500, 50, 30);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butstudent) {
            new Student_Reg();
        } else if (ae.getSource() == butacademic) {
            new Student_Results();
        } else if (ae.getSource() == butcertified) {
            new Students_Courses();
        } else if (ae.getSource() == butjob) {
            new Company_Reg();
        } else if (ae.getSource() == butback)
            f.dispose();
    }

}
