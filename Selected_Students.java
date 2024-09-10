
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketTimeoutException;

import javax.swing.*;

public class Selected_Students extends JFrame implements ActionListener {
    Label ltitle, ldid, ldate, ltype, ldrive, lprn, lname, lyear, lcourse, ldiv, lrollno;
    TextField tfdid, tfdate, tftype, tfprn, tfname, tfyear, tfcourse, tfdiv, tfrollno;
    Button butval, buthelp, butadd, butsave, butback, butvalprn, buthelpprn;
    BufferedWriter bw;
    JFrame f1, f2;

    Selected_Students() {
        setSize(1920, 1080);
        setLayout(null);
        setVisible(true);
        setTitle("Selected students");
        setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ltitle = new Label("Selected students Placement Data.");
        ldid = new Label("Drive ID Number");
        ldate = new Label("Drive Conduct Date");
        ltype = new Label("Drive Type");
        ldrive = new Label(
                "---------------------------------------------------Enter Selected Students PRN For Above Drive----------------------------------------------------");
        lprn = new Label("Students PRN");
        lname = new Label("Students Name ");
        lyear = new Label("Batch Year");
        lcourse = new Label("Course");
        ldiv = new Label("Division");
        lrollno = new Label("Roll No.");

        tfprn = new TextField();
        tfname = new TextField();
        tfyear = new TextField();
        tfcourse = new TextField();
        tfdiv = new TextField();
        tfrollno = new TextField();
        tfdid = new TextField();
        tfdate = new TextField();
        tftype = new TextField();

        butval = new Button("Validate Drive ID");
        buthelp = new Button("Help for Drive ID");
        butvalprn = new Button("Validate PRN");
        buthelpprn = new Button("Help for PRN");
        butadd = new Button("New Result Data");
        butsave = new Button("Save Result Data");
        butback = new Button("Back to Menu");
        butval.addActionListener(this);
        buthelp.addActionListener(this);
        butvalprn.addActionListener(this);
        buthelpprn.addActionListener(this);
        butadd.addActionListener(this);
        butsave.addActionListener(this);
        butback.addActionListener(this);

        Font f1 = new Font("arial black", Font.BOLD, 34);
        Font f2 = new Font("times new roman", Font.BOLD, 28);
        Font f3 = new Font("arial", Font.BOLD, 24);
        Font f4 = new Font("arial", Font.BOLD, 20);

        ltitle.setFont(f1);
        ltitle.setForeground(Color.RED);
        ldid.setFont(f2);
        ldate.setFont(f2);
        ltype.setFont(f2);
        ldrive.setFont(f4);
        lprn.setFont(f2);
        lname.setFont(f2);
        lyear.setFont(f2);
        lcourse.setFont(f2);
        ldiv.setFont(f2);
        lrollno.setFont(f2);

        tfdid.setFont(f3);
        tfdate.setFont(f3);
        tftype.setFont(f3);
        tfprn.setFont(f3);
        tfname.setFont(f3);
        tfyear.setFont(f3);
        tfcourse.setFont(f3);
        tfdiv.setFont(f3);
        tfrollno.setFont(f3);

        butval.setFont(f2);
        buthelp.setFont(f2);
        butvalprn.setFont(f2);
        buthelpprn.setFont(f2);
        butadd.setFont(f2);
        butsave.setFont(f2);
        butback.setFont(f2);

        add(ltitle);
        add(ldid);
        add(ldate);
        add(ltype);
        add(ldrive);
        add(lprn);
        add(lname);
        add(lyear);
        add(lcourse);
        add(ldiv);
        add(lrollno);

        add(tfdid);
        add(tfdate);
        add(tftype);
        add(tfprn);
        add(tfname);
        add(tfyear);
        add(tfcourse);
        add(tfdiv);
        add(tfrollno);

        add(butval);
        add(buthelp);
        add(butvalprn);
        add(buthelpprn);
        add(butadd);
        add(butsave);
        add(butback);

        ltitle.setBounds(450, 30, 800, 40);

        ldid.setBounds(200, 140, 250, 30);
        tfdid.setBounds(575, 140, 150, 30);
        butval.setBounds(800, 140, 220, 30);
        buthelp.setBounds(1075, 140, 220, 30);

        ldate.setBounds(200, 200, 300, 30);
        tfdate.setBounds(575, 200, 400, 30);

        ltype.setBounds(200, 260, 300, 30);
        tftype.setBounds(575, 260, 150, 30);

        ldrive.setBounds(200, 320, 1100, 30);

        lprn.setBounds(200, 380, 200, 30);
        tfprn.setBounds(575, 380, 150, 30);
        butvalprn.setBounds(800, 380, 200, 30);
        buthelpprn.setBounds(1075, 380, 200, 30);

        lname.setBounds(200, 440, 300, 30);
        tfname.setBounds(575, 440, 400, 30);

        lyear.setBounds(200, 500, 300, 30);
        tfyear.setBounds(575, 500, 150, 30);
        lcourse.setBounds(825, 500, 100, 30);
        tfcourse.setBounds(950, 500, 200, 30);

        ldiv.setBounds(200, 560, 200, 30);
        tfdiv.setBounds(575, 560, 40, 30);
        lrollno.setBounds(825, 560, 100, 30);
        tfrollno.setBounds(950, 560, 100, 30);

        butadd.setBounds(275, 700, 250, 40);
        butsave.setBounds(575, 700, 300, 40);
        butback.setBounds(925, 700, 250, 40);

        tfdid.setEnabled(false);
        tfdate.setEnabled(false);
        tftype.setEnabled(false);
        tfprn.setEnabled(false);
        tfname.setEnabled(false);
        tfyear.setEnabled(false);
        tfcourse.setEnabled(false);
        tfdiv.setEnabled(false);
        tfrollno.setEnabled(false);

        butval.setEnabled(false);
        buthelp.setEnabled(false);
        butvalprn.setEnabled(false);
        buthelpprn.setEnabled(false);
        butsave.setEnabled(false);

        try {
            bw = new BufferedWriter(new FileWriter("Selected_Students.txt", true));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problem during opening the Student Registration File.");
        }

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butadd) {
            tfdid.setEnabled(true);
            butval.setEnabled(true);
            buthelp.setEnabled(true);
            tfdid.requestFocus();
            tfprn.setEnabled(false);
            butvalprn.setEnabled(false);
            buthelpprn.setEnabled(false);
            butsave.setEnabled(false);

            tfdid.setText("");
            tfdate.setText("");
            tftype.setText("");
            tfprn.setText("");
            tfname.setText("");
            tfyear.setText("");
            tfcourse.setText("");
            tfdiv.setText("");
            tfrollno.setText("");

        } else if (ae.getSource() == butsave) {
            if (tfdid.getText().length() == 0 || tfprn.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Some TextFields may be empty please check.");
            else {
                String vdid = tfdid.getText();
                String vprn = tfprn.getText();

                try {
                    bw.write(vdid + "$" + vprn);
                    bw.newLine();
                    JOptionPane.showMessageDialog(this, "Drivewise Rounds data is saved successfully.");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Problem during saving the Drivewise Rounds data.");
                }
                tfdid.setEnabled(false);
                tfdate.setEnabled(false);
                tftype.setEnabled(false);
                tfprn.setEnabled(false);

                butval.setEnabled(false);
                buthelp.setEnabled(false);
                butvalprn.setEnabled(false);
                buthelpprn.setEnabled(false);
                butsave.setEnabled(false);
            }
            try {
                bw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Problems during closing the file.");
            }
        } else if (ae.getSource() == butback) {
            dispose();

        } else if (ae.getSource() == butval) {
            if (tfdid.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "You Have not Entered the Drive ID Number,You can take Help!");
            else {

                String vdid = tfdid.getText();
                try {
                    BufferedReader br = new BufferedReader(new FileReader("Conducted_Drives.txt"));
                    int status = 0;
                    String stud;
                    while ((stud = br.readLine()) != null) {
                        String s[] = stud.split("\\$");
                        if (s[0].equals(vdid)) {
                            tfdate.setText(s[1]);
                            tftype.setText(s[2]);
                            status = 1;
                            tfprn.setEnabled(true);
                            butvalprn.setEnabled(true);
                            buthelpprn.setEnabled(true);

                        }

                    }
                    if (status == 0) {
                        JOptionPane.showMessageDialog(this, "You have entered Invalid Drive ID Number.");
                        butsave.setEnabled(false);
                    }
                    br.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Problems during Reading the file.");
                }
            }

        } else if (ae.getSource() == buthelp) {
            try {
                int i = 0, n = 0;
                BufferedReader br = new BufferedReader(new FileReader("Conducted_Drives.txt"));
                String stud;
                while ((stud = br.readLine()) != null) {
                    n++;
                }
                br.close();
                br = new BufferedReader(new FileReader("Conducted_Drives.txt"));

                String students_data[][] = new String[n][6];
                while ((stud = br.readLine()) != null) {
                    String s[] = stud.split("\\$");
                    students_data[i][0] = s[0];
                    students_data[i][1] = s[1];
                    students_data[i][2] = s[2];
                    i++;
                }

                String columns[] = { "Drive ID Number", "Drive Conduct Date", "Drive Type" };
                f2 = new JFrame();
                f2.setVisible(true);
                f2.setSize(500, 500);
                JTable t = new JTable(students_data, columns);
                t.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        int row = t.rowAtPoint(e.getPoint());
                        tfdid.setText(students_data[row][0]);
                        tfdate.setText(students_data[row][1]);
                        tftype.setText(students_data[row][2]);

                        tfprn.setEnabled(true);
                        butvalprn.setEnabled(true);
                        buthelpprn.setEnabled(true);

                    }
                });
                JScrollPane jp = new JScrollPane(t);
                f2.add(jp);
                t.setBounds(10, 10, 400, 400);
                br.close();
            }

            catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Problems during Reading the file.");
            }

        } else if (ae.getSource() == butvalprn) {

            if (tfprn.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "You Have not Entered the PRN,You can take Help!");
            else {

                String vprn = tfprn.getText();
                try {
                    BufferedReader br = new BufferedReader(new FileReader("Student_Reg.txt"));
                    int status = 0;
                    String stud;
                    while ((stud = br.readLine()) != null) {
                        String s[] = stud.split("\\$");
                        if (s[0].equals(vprn)) {
                            tfname.setText(s[1]);
                            tfyear.setText(s[2]);
                            tfcourse.setText(s[3]);
                            tfdiv.setText(s[4]);
                            tfrollno.setText(s[5]);
                            status = 1;
                            butsave.setEnabled(true);

                        }

                    }
                    if (status == 0) {
                        JOptionPane.showMessageDialog(this, "You have entered Invalid PRN.");
                        butsave.setEnabled(false);
                    }
                    br.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Problems during Reading the file.");
                }
            }

        } else if (ae.getSource() == buthelpprn) {

            try {
                int i = 0, n = 0;
                BufferedReader br = new BufferedReader(new FileReader("Student_Reg.txt"));
                String stud;
                while ((stud = br.readLine()) != null) {
                    n++;
                }
                br.close();
                br = new BufferedReader(new FileReader("Student_Reg.txt"));

                String students_data[][] = new String[n][6];
                while ((stud = br.readLine()) != null) {
                    String s[] = stud.split("\\$");
                    students_data[i][0] = s[0];
                    students_data[i][1] = s[1];
                    students_data[i][2] = s[2];
                    students_data[i][3] = s[3];
                    students_data[i][4] = s[4];
                    students_data[i][5] = s[5];
                    i++;
                }
                String columns[] = { "Student's PRN", "Student's Name", "Batch Year", "Course", "Division",
                        "Roll Number" };
                f2 = new JFrame();
                f2.setVisible(true);
                f2.setSize(500, 500);
                JTable t = new JTable(students_data, columns);
                t.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        int row = t.rowAtPoint(e.getPoint());
                        tfprn.setText(students_data[row][0]);
                        tfname.setText(students_data[row][1]);
                        tfyear.setText(students_data[row][2]);
                        tfcourse.setText(students_data[row][3]);
                        tfdiv.setText(students_data[row][4]);
                        tfrollno.setText(students_data[row][5]);
                        butsave.setEnabled(true);

                    }
                });

                JScrollPane jp = new JScrollPane(t);
                f2.add(jp);
                t.setBounds(10, 10, 400, 400);
                br.close();
            }

            catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Problems during Reading the file.");
            }

        }
    }

}
