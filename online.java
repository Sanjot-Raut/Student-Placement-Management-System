import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class online implements ActionListener {
    JFrame f = new JFrame("Students Campus Placement Information System");
    JLabel lbtitle, lbname, lbprimary, lbplacement, lbstudent, lbregistered, lbacademic, lbcertified, lbjob,
            lbconducted, lbdrive, lbselected, lbdrivewise, lbcourse, lbnonplaced, lbback;
    JButton butregistered, butacademic, butcertified, butjob, butconducted, butdrive, butselected, butdrivewise,
            butcourse, butnonplaced, butback;

    online() {
        f.setSize(1600, 900);
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbtitle = new JLabel("Students Campus Placement Information System");
        lbname = new JLabel("Module 3 : Online Information (Reports) Module");

        lbprimary = new JLabel("1. Primary Information Reports");
        lbplacement = new JLabel("2. Placement drives Information Reports");
        lbstudent = new JLabel("3. Students Placement information Reports");

        lbregistered = new JLabel("Registered students information report");
        lbacademic = new JLabel("Students academic results information report");
        lbcertified = new JLabel("Students certified courses information report");
        lbjob = new JLabel("Job provider companys information report");

        lbconducted = new JLabel("Conducted placement drives information reports");
        lbdrive = new JLabel("Drivewise conducted rounds information report");
        lbselected = new JLabel("Selected students placement information report");

        lbdrivewise = new JLabel("Drivewise students placement information reports");
        lbcourse = new JLabel("Coursewise students placement information reports");
        lbnonplaced = new JLabel("Non placed students information report (Course wise)");

        lbback = new JLabel("Back to Main Menu of the Project");

        butregistered = new JButton();
        butacademic = new JButton();
        butcertified = new JButton();
        butjob = new JButton();
        butconducted = new JButton();
        butdrive = new JButton();
        butselected = new JButton();
        butdrivewise = new JButton();
        butcourse = new JButton();
        butnonplaced = new JButton();
        butback = new JButton();

        butregistered.addActionListener(this);
        butacademic.addActionListener(this);
        butcertified.addActionListener(this);
        butjob.addActionListener(this);
        butconducted.addActionListener(this);
        butdrive.addActionListener(this);
        butselected.addActionListener(this);
        butdrivewise.addActionListener(this);
        butcourse.addActionListener(this);
        butnonplaced.addActionListener(this);
        butback.addActionListener(this);

        Font f1 = new Font("arial black", Font.PLAIN, 50);
        Font f2 = new Font("arial", Font.BOLD, 40);
        Font f3 = new Font("arial", Font.PLAIN, 30);
        Font f4 = new Font("times new roman", Font.PLAIN, 20);

        lbtitle.setFont(f1);
        lbtitle.setForeground(Color.RED);
        lbname.setFont(f2);
        lbname.setForeground(Color.BLUE);
        lbprimary.setFont(f3);
        lbprimary.setForeground(Color.MAGENTA);
        lbplacement.setFont(f3);
        lbplacement.setForeground(Color.MAGENTA);
        lbstudent.setFont(f3);
        lbstudent.setForeground(Color.MAGENTA);
        lbregistered.setFont(f4);
        lbacademic.setFont(f4);
        lbcertified.setFont(f4);
        lbjob.setFont(f4);
        lbconducted.setFont(f4);
        lbdrive.setFont(f4);
        lbselected.setFont(f4);
        lbdrivewise.setFont(f4);
        lbcourse.setFont(f4);
        lbnonplaced.setFont(f4);
        lbback.setFont(f3);
        butback.setFont(f4);

        f.add(lbtitle);
        f.add(lbname);
        f.add(lbprimary);
        f.add(lbplacement);
        f.add(lbstudent);
        f.add(lbregistered);
        f.add(lbacademic);
        f.add(lbcertified);
        f.add(lbjob);
        f.add(lbconducted);
        f.add(lbdrive);
        f.add(lbselected);
        f.add(lbdrivewise);
        f.add(lbcourse);
        f.add(lbnonplaced);
        f.add(butback);
        f.add(lbback);

        f.add(butregistered);
        f.add(butacademic);
        f.add(butcertified);
        f.add(butjob);
        f.add(butconducted);
        f.add(butdrive);
        f.add(butselected);
        f.add(butdrivewise);
        f.add(butcourse);
        f.add(butnonplaced);
        f.add(butback);

        lbtitle.setBounds(100, 0, 1500, 60);
        lbname.setBounds(250, 80, 1200, 50);

        lbprimary.setBounds(450, 160, 450, 40);
        lbregistered.setBounds(550, 210, 500, 25);
        butregistered.setBounds(500, 210, 26, 25);
        lbacademic.setBounds(550, 250, 600, 25);
        butacademic.setBounds(500, 250, 26, 25);
        lbcertified.setBounds(550, 290, 600, 25);
        butcertified.setBounds(500, 290, 26, 25);
        lbjob.setBounds(550, 330, 600, 25);
        butjob.setBounds(500, 330, 26, 25);

        lbplacement.setBounds(450, 380, 600, 40);
        lbconducted.setBounds(550, 430, 600, 25);
        butconducted.setBounds(500, 430, 26, 25);
        lbdrive.setBounds(550, 470, 600, 25);
        butdrive.setBounds(500, 470, 26, 25);
        lbselected.setBounds(550, 510, 600, 25);
        butselected.setBounds(500, 510, 26, 25);

        lbstudent.setBounds(450, 560, 600, 40);
        lbdrivewise.setBounds(550, 610, 600, 25);
        butdrivewise.setBounds(500, 610, 26, 25);
        lbcourse.setBounds(550, 650, 600, 25);
        butcourse.setBounds(500, 650, 26, 25);
        lbnonplaced.setBounds(550, 690, 600, 25);
        butnonplaced.setBounds(500, 690, 26, 25);

        lbback.setBounds(500, 740, 600, 40);
        butback.setBounds(450, 740, 40, 40);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butregistered) {
            new Registered_Students_Report();
        } else if (ae.getSource() == butacademic) {
            new Students_Results_Report();
        } else if (ae.getSource() == butcertified) {
            new Students_Courses_Report();
        } else if (ae.getSource() == butjob) {
            new Registered_Companys_Report();
        } else if (ae.getSource() == butconducted) {
            new Conducted_Drives_Report();
        } else if (ae.getSource() == butdrive) {
            new Drivewise_Rounds_Report();
        } else if (ae.getSource() == butselected) {
            new Selected_Students_Report();
        } else if (ae.getSource() == butdrivewise) {
            new Drivewise_Students_Placement_Report();
        } else if (ae.getSource() == butcourse) {
            new Coursewise_Students_Placement_Report();
        } else if (ae.getSource() == butnonplaced) {
            new Nonplaced_Students_Report();
        } else if (ae.getSource() == butback)
            f.dispose();
    }
}
