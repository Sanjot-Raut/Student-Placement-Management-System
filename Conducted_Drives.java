import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.util.ElementScanner14;

import javax.swing.*;

public class Conducted_Drives extends JFrame implements ActionListener {
    Label ltitle, ldno, ldate, ltype, lcno, lname, ladd, lctype, lyear, lcriteria, ldeg, lpackage, lroundsno,
            lappearedno, lplacedno;
    TextField tfdno, tfdate, tfcno, tfname, tfadd, tfctype, tfyear, tfcriteria, tfdeg, tfpackage, tfroundsno,
            tfappearedno, tfplacedno;
    CheckboxGroup cbg;
    Checkbox rboncampus, rboffcampus, rbonline;
    Button butval, buthelp, butadd, butsave, butback;
    BufferedWriter bw;

    Conducted_Drives() {
        setSize(1920, 1080);
        setLayout(null);
        setVisible(true);
        setTitle("Conducted Campus Drives Form");
        setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ltitle = new Label("Conducted Campus Placement Drives Data.");
        ldno = new Label("Drive ID Number");
        ldate = new Label("Drive Conduct Date");
        ltype = new Label("Drive Type");
        lcno = new Label("Company's ID Number");
        lname = new Label("Company's Name ");
        ladd = new Label("Office Address");
        lctype = new Label("Type,Sector");
        lyear = new Label("Drive for - Batch Year No.");
        lcriteria = new Label("Applicable Criteria");
        ldeg = new Label("Offered Designation");
        lpackage = new Label("Offered Package in (LPA)");
        lroundsno = new Label("No. of Rounds Conducted ");
        lappearedno = new Label("No. of Students Appeared");
        lplacedno = new Label("No. of Students Placed");

        tfdno = new TextField();
        tfdate = new TextField();
        tfcno = new TextField();
        tfname = new TextField();
        tfadd = new TextField();
        tfctype = new TextField();
        tfyear = new TextField();
        tfcriteria = new TextField();
        tfdeg = new TextField();
        tfpackage = new TextField();
        tfroundsno = new TextField();
        tfappearedno = new TextField();
        tfplacedno = new TextField();

        cbg = new CheckboxGroup();
        rboncampus = new Checkbox("OnCampus", cbg, true);
        rboffcampus = new Checkbox("OffCampus", cbg, false);
        rbonline = new Checkbox("Online", cbg, false);

        butval = new Button("Validate Company's ID");
        buthelp = new Button("Help for Company's ID");
        butadd = new Button("New Drive Data");
        butsave = new Button("Save Drive Data");
        butback = new Button("Back to Menu");
        butval.addActionListener(this);
        buthelp.addActionListener(this);
        butadd.addActionListener(this);
        butsave.addActionListener(this);
        butback.addActionListener(this);

        Font f1 = new Font("arial black", Font.BOLD, 34);
        Font f2 = new Font("times new roman", Font.BOLD, 28);
        Font f3 = new Font("arial", Font.BOLD, 24);

        ltitle.setFont(f1);
        ltitle.setForeground(Color.RED);
        ldno.setFont(f2);
        ldate.setFont(f2);
        ltype.setFont(f2);
        lcno.setFont(f2);
        lname.setFont(f2);
        ladd.setFont(f2);
        lctype.setFont(f2);
        lyear.setFont(f2);
        lcriteria.setFont(f2);
        ldeg.setFont(f2);
        lpackage.setFont(f2);
        lroundsno.setFont(f2);
        lappearedno.setFont(f2);
        lplacedno.setFont(f2);

        tfdno.setFont(f3);
        tfdate.setFont(f3);
        tfcno.setFont(f3);
        tfname.setFont(f3);
        tfadd.setFont(f3);
        tfctype.setFont(f3);
        tfyear.setFont(f3);
        tfcriteria.setFont(f3);
        tfdeg.setFont(f3);
        tfpackage.setFont(f3);
        tfroundsno.setFont(f3);
        tfappearedno.setFont(f3);
        tfplacedno.setFont(f3);

        rboncampus.setFont(f3);
        rboffcampus.setFont(f3);
        rbonline.setFont(f3);
        butval.setFont(f2);
        buthelp.setFont(f2);
        butadd.setFont(f2);
        butsave.setFont(f2);
        butback.setFont(f2);

        add(ltitle);
        add(ldno);
        add(ldate);
        add(ltype);
        add(lcno);
        add(lname);
        add(ladd);
        add(lctype);
        add(lyear);
        add(lcriteria);
        add(ldeg);
        add(lpackage);
        add(lroundsno);
        add(lappearedno);
        add(lplacedno);

        add(tfdno);
        add(tfdate);
        add(tfcno);
        add(tfname);
        add(tfadd);
        add(tfctype);
        add(tfyear);
        add(tfcriteria);
        add(tfdeg);
        add(tfpackage);
        add(tfroundsno);
        add(tfappearedno);
        add(tfplacedno);

        add(rboncampus);
        add(rboffcampus);
        add(rbonline);
        add(butval);
        add(buthelp);
        add(butadd);
        add(butsave);
        add(butback);

        ltitle.setBounds(400, 10, 800, 40);

        ldno.setBounds(100, 80, 250, 30);
        tfdno.setBounds(475, 80, 150, 30);

        ldate.setBounds(100, 140, 300, 30);
        tfdate.setBounds(475, 140, 150, 30);
        ltype.setBounds(700, 140, 150, 30);
        rboncampus.setBounds(925, 140, 150, 30);
        rboffcampus.setBounds(1100, 140, 150, 30);
        rbonline.setBounds(1275, 140, 150, 30);

        lcno.setBounds(100, 200, 300, 30);
        tfcno.setBounds(475, 200, 150, 30);
        butval.setBounds(700, 200, 300, 30);
        buthelp.setBounds(1075, 200, 300, 30);

        lname.setBounds(100, 260, 300, 30);
        tfname.setBounds(475, 260, 350, 30);
        lctype.setBounds(900, 260, 200, 30);
        tfctype.setBounds(1100, 260, 250, 30);

        ladd.setBounds(100, 320, 300, 30);
        tfadd.setBounds(475, 320, 700, 30);

        lyear.setBounds(100, 380, 340, 30);
        tfyear.setBounds(475, 380, 100, 30);

        lcriteria.setBounds(100, 440, 300, 30);
        tfcriteria.setBounds(475, 440, 700, 30);

        ldeg.setBounds(700, 500, 300, 30);
        tfdeg.setBounds(1075, 500, 300, 30);
        lpackage.setBounds(100, 500, 350, 30);
        tfpackage.setBounds(475, 500, 100, 30);

        lroundsno.setBounds(100, 560, 350, 30);
        tfroundsno.setBounds(475, 560, 400, 30);

        lappearedno.setBounds(100, 620, 350, 30);
        tfappearedno.setBounds(475, 620, 350, 30);

        lplacedno.setBounds(100, 680, 350, 30);
        tfplacedno.setBounds(475, 680, 350, 30);

        butadd.setBounds(275, 740, 250, 40);
        butsave.setBounds(575, 740, 300, 40);
        butback.setBounds(925, 740, 250, 40);

        tfdno.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfdno.getText().length() >= 2)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();

                    }
                });

        tfcno.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfcno.getText().length() >= 10)
                            ke.consume();
                    }
                });

        tfyear.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfyear.getText().length() >= 4)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;

                        else
                            ke.consume();

                    }
                });
        tfcriteria.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfcriteria.getText().length() >= 25)
                            ke.consume();
                        if (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
                            return;
                        else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
                            return;
                        else if (ke.getKeyChar() == ' ')
                            return;
                        else
                            ke.consume();
                    }
                });
        tfdate.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfdate.getText().length() >= 10)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else if (ke.getKeyChar() == '-')
                            return;
                        else if (ke.getKeyChar() == '/')
                            return;
                        else
                            ke.consume();
                    }
                });
        tfdeg.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfdeg.getText().length() >= 25)
                            ke.consume();
                        if (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
                            return;
                        else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
                            return;
                        else if (ke.getKeyChar() == ' ')
                            return;
                        else
                            ke.consume();
                    }
                });
        tfpackage.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfpackage.getText().length() >= 2)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();

                    }
                });
        tfroundsno.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfroundsno.getText().length() >= 2)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();

                    }
                });
        tfroundsno.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfroundsno.getText().length() >= 2)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();

                    }
                });
        tfappearedno.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfappearedno.getText().length() >= 3)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();

                    }
                });
        tfplacedno.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfplacedno.getText().length() >= 3)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();

                    }
                });

        tfdno.setEnabled(false);
        tfdate.setEnabled(false);
        tfcno.setEnabled(false);
        tfname.setEnabled(false);
        tfadd.setEnabled(false);
        tfctype.setEnabled(false);
        tfyear.setEnabled(false);
        tfcriteria.setEnabled(false);
        tfdeg.setEnabled(false);
        tfpackage.setEnabled(false);
        tfroundsno.setEnabled(false);
        tfappearedno.setEnabled(false);
        tfplacedno.setEnabled(false);
        rboncampus.setEnabled(false);
        rboffcampus.setEnabled(false);
        rbonline.setEnabled(false);
        butval.setEnabled(false);
        buthelp.setEnabled(false);
        butsave.setEnabled(false);

        try {
            bw = new BufferedWriter(new FileWriter("Conducted_Drives.txt", true));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problem during opening the Student Registration File.");
        }

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butadd) {
            tfdno.setEnabled(true);
            tfdate.setEnabled(true);
            tfcno.setEnabled(true);
            tfyear.setEnabled(true);
            tfcriteria.setEnabled(true);
            tfdeg.setEnabled(true);
            tfpackage.setEnabled(true);
            tfroundsno.setEnabled(true);
            tfappearedno.setEnabled(true);
            tfplacedno.setEnabled(true);
            rboncampus.setEnabled(true);
            rboffcampus.setEnabled(true);
            rbonline.setEnabled(true);
            butsave.setEnabled(true);
            butval.setEnabled(true);
            buthelp.setEnabled(true);
            tfdno.requestFocus();

            tfdno.setText("");
            tfdate.setText("");
            tfcno.setText("");
            tfyear.setText("");
            tfcriteria.setText("");
            tfdeg.setText("");
            tfpackage.setText("");
            tfroundsno.setText("");
            tfappearedno.setText("");
            tfplacedno.setText("");

        } else if (ae.getSource() == butsave) {
            if (tfdno.getText().length() == 0 || tfdate.getText().length() == 0 || tfcno.getText().length() == 0
                    || tfyear.getText().length() == 0 || tfcriteria.getText().length() == 0
                    || tfdeg.getText().length() == 0 || tfpackage.getText().length() == 0
                    || tfroundsno.getText().length() == 0 || tfappearedno.getText().length() == 0
                    || tfplacedno.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Some TextFields may be empty please check.");
            else {
                String vdno = tfdno.getText();
                String vdate = tfdate.getText();
                String vtype;
                String vcno = tfcno.getText();
                String vyear = tfyear.getText();
                String vcriteria = tfcriteria.getText();
                String vdeg = tfdeg.getText();
                String vpackage = tfpackage.getText();
                String vroundsno = tfroundsno.getText();
                String vappearedno = tfappearedno.getText();
                String vplacedno = tfplacedno.getText();

                if (rboncampus.getState() == true)
                    vtype = "OnCampus";
                else if (rboffcampus.getState() == true)
                    vtype = "OffCampus";
                else
                    vtype = "Online";
                try {
                    bw.write(vdno + "$" + vdate + "$" + vtype + "$" + vcno + "$" + vyear + "$" + vcriteria + "$" + vdeg
                            + "$" + vpackage + "$" + vroundsno + "$" + vappearedno + "$" + vplacedno);
                    bw.newLine();
                    JOptionPane.showMessageDialog(this, "Conducted Drives data is saved successfully.");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Problem during saving the Conducted Drives data.");
                }
                tfdno.setEnabled(false);
                tfdate.setEnabled(false);
                tfcno.setEnabled(false);
                tfyear.setEnabled(false);
                tfcriteria.setEnabled(false);
                tfdeg.setEnabled(false);
                tfpackage.setEnabled(false);
                tfroundsno.setEnabled(false);
                tfappearedno.setEnabled(false);
                tfplacedno.setEnabled(false);
                rboncampus.setEnabled(false);
                rboffcampus.setEnabled(false);
                rbonline.setEnabled(false);
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
            if (tfcno.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "You Have not Entered the Company's ID, You can take Help!");
            else {

                String vprn = tfcno.getText();
                try {
                    BufferedReader br = new BufferedReader(new FileReader("Company_Reg.txt"));
                    int status = 0;
                    String stud;
                    while ((stud = br.readLine()) != null) {
                        String s[] = stud.split("\\$");
                        if (s[0].equals(vprn)) {
                            tfname.setText(s[1]);
                            tfadd.setText(s[2]);
                            tfctype.setText(s[3]);
                            status = 1;
                            butsave.setEnabled(true);

                        }

                    }
                    if (status == 0) {
                        JOptionPane.showMessageDialog(this, "You have entered Invalid Company's ID Number.");
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
                BufferedReader br = new BufferedReader(new FileReader("Company_Reg.txt"));
                String stud;
                while ((stud = br.readLine()) != null) {
                    n++;
                }
                br.close();
                br = new BufferedReader(new FileReader("Company_Reg.txt"));

                String students_data[][] = new String[n][4];
                while ((stud = br.readLine()) != null) {
                    String s[] = stud.split("\\$");
                    students_data[i][0] = s[0];
                    students_data[i][1] = s[1];
                    students_data[i][2] = s[2];
                    students_data[i][3] = s[3];
                    i++;
                }
                String columns[] = { "Company's ID No.", "Company's Name", "Address", "Type / Sector" };
                JFrame f = new JFrame();
                f.setVisible(true);
                f.setSize(500, 500);
                JTable t = new JTable(students_data, columns);
                t.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        int row = t.rowAtPoint(e.getPoint());
                        tfcno.setText(students_data[row][0]);
                        tfname.setText(students_data[row][1]);
                        tfadd.setText(students_data[row][2]);
                        tfctype.setText(students_data[row][3]);
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
