import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class placement implements ActionListener {
    JFrame f = new JFrame("Students Campus Placement Information System");
    JLabel lbtitle, lbname, lbconducted, lbdrive, lbselected, lbback;
    JButton butconducted, butdrive, butselected, butback;

    placement() {
        f.setSize(1600, 900);
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbtitle = new JLabel("Students Campus Placement Information System");
        lbname = new JLabel("Module 2 : Placement Transactions Data Entry Module");
        lbconducted = new JLabel("Conducted Campus Placement Drives (Data Entry Form)");
        lbdrive = new JLabel("Drive wise conducted rounds Data Entry Form");
        lbselected = new JLabel("Selected students Placement entry form");
        lbback = new JLabel("Back to Main Menu of the Project");

        butconducted = new JButton();
        butdrive = new JButton();
        butselected = new JButton();
        butback = new JButton();

        butconducted.addActionListener(this);
        butdrive.addActionListener(this);
        butselected.addActionListener(this);
        butback.addActionListener(this);

        Font f1 = new Font("arial black", Font.PLAIN, 50);
        Font f2 = new Font("arial", Font.BOLD, 40);
        Font f4 = new Font("times new roman", Font.PLAIN, 20);

        f.add(lbtitle);
        f.add(lbname);
        f.add(lbconducted);
        f.add(lbdrive);
        f.add(lbselected);
        f.add(lbback);
        f.add(butconducted);
        f.add(butdrive);
        f.add(butselected);
        f.add(butback);

        lbtitle.setFont(f1);
        lbtitle.setForeground(Color.red);
        lbname.setFont(f2);
        lbname.setForeground(Color.BLUE);
        lbconducted.setFont(f4);
        lbdrive.setFont(f4);
        lbselected.setFont(f4);
        lbback.setFont(f4);
        butconducted.setFont(f4);
        butdrive.setFont(f4);
        butselected.setFont(f4);
        butback.setFont(f4);

        lbtitle.setBounds(100, 50, 1500, 60);
        lbname.setBounds(250, 150, 1200, 50);

        lbconducted.setBounds(600, 300, 500, 30);
        butconducted.setBounds(450, 300, 50, 30);

        lbdrive.setBounds(600, 350, 500, 30);
        butdrive.setBounds(450, 350, 50, 30);

        lbselected.setBounds(600, 400, 500, 30);
        butselected.setBounds(450, 400, 50, 30);

        lbback.setBounds(600, 450, 500, 30);
        butback.setBounds(450, 450, 50, 30);

    }

    public void actionPerformed(ActionEvent ae) {
       if (ae.getSource() == butconducted) {
            new Conducted_Drives();
        } else if (ae.getSource() == butdrive) {
            new Drivewise_Rounds();
        } else if (ae.getSource() == butselected) {
            new Selected_Students();
        } else if (ae.getSource() == butback) {
            f.dispose();
        }

    }
}
