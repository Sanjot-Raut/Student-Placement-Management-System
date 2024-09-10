import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketTimeoutException;

import javax.swing.*;

public class Student_Results extends JFrame implements ActionListener {
    Label ltitle, lprn, lname, lyear, lcourse, ldiv, lrollno, lstudent, lsem1, lsem2, lsem3, lsem4, lsem5, lbacklogs;
    TextField tfprn, tfname, tfyear, tfcourse, tfdiv, tfrollno, tfsem1, tfsem2, tfsem3, tfsem4, tfsem5, tfbacklogs;
    Button butval, buthelp, butadd, butsave, butback;
    BufferedWriter bw;

    Student_Results() {
        setSize(1920, 1080);
        setLayout(null);
        setVisible(true);
        setTitle("Student's Academic Results Form");
        setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ltitle = new Label("Student's Academic Results Record Keeping.");
        lprn = new Label("Students PRN");
        lname = new Label("Students Name ");
        lyear = new Label("Batch Year");
        lcourse = new Label("Course");
        ldiv = new Label("Division");
        lrollno = new Label("Roll No.");
        lstudent = new Label(
                "--------------------------------------------------Enter Academic Result Data For Above Student----------------------------------------------------");
        lsem1 = new Label("Sem-1 % Marks");
        lsem2 = new Label("Sem-2 % Marks");
        lsem3 = new Label("Sem-3 % Marks");
        lsem4 = new Label("Sem-4 % Marks");
        lsem5 = new Label("Sem-5 % Marks");
        lbacklogs = new Label("Active Backlogs");

        tfprn = new TextField();
        tfname = new TextField();
        tfyear = new TextField();
        tfcourse = new TextField();
        tfdiv = new TextField();
        tfrollno = new TextField();
        tfsem1 = new TextField();
        tfsem2 = new TextField();
        tfsem3 = new TextField();
        tfsem4 = new TextField();
        tfsem5 = new TextField();
        tfbacklogs = new TextField();

        butval = new Button("Validate PRN");
        buthelp = new Button("Help for PRN");
        butadd = new Button("New Result Data");
        butsave = new Button("Save Result Data");
        butback = new Button("Back to Menu");
        butval.addActionListener(this);
        buthelp.addActionListener(this);
        butadd.addActionListener(this);
        butsave.addActionListener(this);
        butback.addActionListener(this);

        Font f1 = new Font("arial black", Font.BOLD, 34);
        Font f2 = new Font("times new roman", Font.BOLD, 28);
        Font f3 = new Font("arial", Font.BOLD, 24);
        Font f4 = new Font("arial", Font.BOLD, 20);

        ltitle.setFont(f1);
        ltitle.setForeground(Color.RED);
        lprn.setFont(f2);
        lname.setFont(f2);
        lyear.setFont(f2);
        lcourse.setFont(f2);
        ldiv.setFont(f2);
        lrollno.setFont(f2);
        lstudent.setFont(f4);
        lsem1.setFont(f2);
        lsem2.setFont(f2);
        lsem3.setFont(f2);
        lsem4.setFont(f2);
        lsem5.setFont(f2);
        lbacklogs.setFont(f2);

        tfprn.setFont(f3);
        tfname.setFont(f3);
        tfyear.setFont(f3);
        tfcourse.setFont(f3);
        tfdiv.setFont(f3);
        tfrollno.setFont(f3);
        tfsem1.setFont(f3);
        tfsem2.setFont(f3);
        tfsem3.setFont(f3);
        tfsem4.setFont(f3);
        tfsem5.setFont(f3);
        tfbacklogs.setFont(f3);

        butval.setFont(f2);
        buthelp.setFont(f2);
        butadd.setFont(f2);
        butsave.setFont(f2);
        butback.setFont(f2);

        add(ltitle);
        add(lprn);
        add(lname);
        add(lyear);
        add(lcourse);
        add(ldiv);
        add(lrollno);
        add(lstudent);
        add(lsem1);
        add(lsem2);
        add(lsem3);
        add(lsem4);
        add(lsem5);
        add(lbacklogs);

        add(tfprn);
        add(tfname);
        add(tfyear);
        add(tfcourse);
        add(tfdiv);
        add(tfrollno);
        add(tfsem1);
        add(tfsem2);
        add(tfsem3);
        add(tfsem4);
        add(tfsem5);
        add(tfbacklogs);

        add(butval);
        add(buthelp);
        add(butadd);
        add(butsave);
        add(butback);

        ltitle.setBounds(400, 30, 800, 40);
        
        lprn.setBounds(200, 140, 200, 30);
        tfprn.setBounds(575, 140, 150, 30);
        butval.setBounds(800, 140, 200, 30);
        buthelp.setBounds(1075, 140, 200, 30);

        lname.setBounds(200, 200, 300, 30);
        tfname.setBounds(575, 200, 400, 30);

        lyear.setBounds(200, 260, 300, 30);
        tfyear.setBounds(575, 260, 150, 30);
        lcourse.setBounds(825, 260, 100, 30);
        tfcourse.setBounds(950, 260, 200, 30);
        
        ldiv.setBounds(200, 320, 200, 30);
        tfdiv.setBounds(575, 320, 40, 30);
        lrollno.setBounds(825, 320, 100, 30);
        tfrollno.setBounds(950, 320, 100, 30);

        lstudent.setBounds(200, 380, 1100, 20);

        lsem1.setBounds(200, 440, 300, 30);
        tfsem1.setBounds(575, 440, 150, 30);
        lsem2.setBounds(800, 440, 300, 30);
        tfsem2.setBounds(1100, 440, 150, 30);

        lsem3.setBounds(200, 500, 300, 30);
        tfsem3.setBounds(575, 500, 150, 30);
        lsem4.setBounds(800, 500, 300, 30);
        tfsem4.setBounds(1100, 500, 150, 30);

        lsem5.setBounds(200, 560, 300, 30);
        tfsem5.setBounds(575, 560, 150, 30);

        lbacklogs.setBounds(200, 620, 300, 30);
        tfbacklogs.setBounds(575, 620, 400, 30);

        butadd.setBounds(275, 700, 250, 40);
        butsave.setBounds(575, 700, 300, 40);
        butback.setBounds(925, 700, 250, 40);

        tfprn.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfprn.getText().length() >= 10)
                            ke.consume();
                    }
                });

        tfsem1.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfsem1.getText().length() >= 5)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else if (ke.getKeyChar() == '.')
                            return;
                        else
                            ke.consume();

                    }
                });
        tfsem2.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfsem2.getText().length() >= 5)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else if (ke.getKeyChar() == '.')
                            return;
                        else
                            ke.consume();

                    }
                });
        tfsem3.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfsem3.getText().length() >= 5)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else if (ke.getKeyChar() == '.')
                            return;
                        else
                            ke.consume();

                    }
                });
        tfsem4.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfsem4.getText().length() >= 5)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else if (ke.getKeyChar() == '.')
                            return;
                        else
                            ke.consume();

                    }
                });
        tfsem5.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfsem5.getText().length() >= 5)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else if (ke.getKeyChar() == '.')
                            return;
                        else
                            ke.consume();

                    }
                });

        tfbacklogs.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfbacklogs.getText().length() >= 25)
                            ke.consume();
                        if (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
                            return;
                        else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
                            return;
                        else if (ke.getKeyChar() == ' ')
                            return;
                        else if (ke.getKeyChar() == ',')
                            return;
                        else
                            ke.consume();
                    }
                });

        tfprn.setEnabled(false);
        tfname.setEnabled(false);
        tfyear.setEnabled(false);
        tfcourse.setEnabled(false);
        tfdiv.setEnabled(false);
        tfrollno.setEnabled(false);
        tfsem1.setEnabled(false);
        tfsem2.setEnabled(false);
        tfsem3.setEnabled(false);
        tfsem4.setEnabled(false);
        tfsem5.setEnabled(false);
        tfbacklogs.setEnabled(false);
        butval.setEnabled(false);
        buthelp.setEnabled(false);
        butsave.setEnabled(false);

        try {
            bw = new BufferedWriter(new FileWriter("Student_Results.txt", true));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problem during opening the Student Registration File.");
        }

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butadd) {
            tfprn.setEnabled(true);
            tfsem1.setEnabled(true);
            tfsem2.setEnabled(true);
            tfsem3.setEnabled(true);
            tfsem4.setEnabled(true);
            tfsem5.setEnabled(true);
            tfbacklogs.setEnabled(true);

            butval.setEnabled(true);
            buthelp.setEnabled(true);
            tfprn.requestFocus();

            tfprn.setText("");
            tfname.setText("");
            tfyear.setText("");
            tfcourse.setText("");
            tfdiv.setText("");
            tfrollno.setText("");
            tfsem1.setText("");
            tfsem2.setText("");
            tfsem3.setText("");
            tfsem4.setText("");
            tfsem5.setText("");
            tfbacklogs.setText("");

        } else if (ae.getSource() == butsave) {
            if (tfprn.getText().length() == 0 || tfsem1.getText().length() == 0 || tfsem2.getText().length() == 0
                    || tfsem3.getText().length() == 0 || tfsem4.getText().length() == 0
                    || tfsem5.getText().length() == 0 || tfbacklogs.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Some TextFields may be empty please check.");
            else {
                String vprn = tfprn.getText();
                String vsem1 = tfsem1.getText();
                String vsem2 = tfsem2.getText();
                String vsem3 = tfsem3.getText();
                String vsem4 = tfsem4.getText();
                String vsem5 = tfsem5.getText();
                String vbacklogs = tfbacklogs.getText();

                try {
                    bw.write(vprn + "$" + vsem1 + "$" + vsem2 + "$" + vsem3 + "$" + vsem4 + "$" + vsem5 + "$"
                            + vbacklogs);
                    bw.newLine();
                    JOptionPane.showMessageDialog(this, "Student's Results data is saved successfully.");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Problem during saving the Student's Results data.");
                }
                tfprn.setEnabled(false);
                tfsem1.setEnabled(false);
                tfsem2.setEnabled(false);
                tfsem3.setEnabled(false);
                tfsem4.setEnabled(false);
                tfsem5.setEnabled(false);
                tfbacklogs.setEnabled(false);
                butval.setEnabled(false);
                buthelp.setEnabled(false);
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

        } else if (ae.getSource() == buthelp) {
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
                JFrame f = new JFrame();
                f.setVisible(true);
                f.setSize(500, 500);
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
                f.add(jp);
                t.setBounds(10, 10, 400, 400);
                br.close();
            }

            catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Problems during Reading the file.");
            }

        }

    }

}
