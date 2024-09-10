import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.lang.model.util.ElementScanner14;
import javax.swing.*;

public class Student_Reg extends JFrame implements ActionListener {
    Label ltitle, lprn, lname, lyear, lcourse, ldiv, lrollno, ladd, lgender, lmobno, lemail, lhobbies, lexparea;
    TextField tfprn, tfname, tfyear, tfdiv, tfrollno, tfadd, tfmobno, tfemail, tfhobbies, tfexparea;
    Choice ccourse;
    CheckboxGroup cbg;
    Checkbox rbmale, rbfemale, rbother;
    Button butadd, butsave, butback;
    BufferedWriter bw;

    Student_Reg() {
        setSize(1920, 1080);
        setLayout(null);
        setVisible(true);
        setTitle("Student Registration Form");
        setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ltitle = new Label("Students Registration for job Placement.");
        lprn = new Label("Students PRN");
        lname = new Label("Students Name ");
        lyear = new Label("Batch Year");
        lcourse = new Label("Course");
        ldiv = new Label("Division");
        lrollno = new Label("Roll No.");
        ladd = new Label("Permanent Address ");
        lgender = new Label("Gender");
        lmobno = new Label("Mobile Number ");
        lemail = new Label("E-Mail ID");
        lhobbies = new Label("Hobbies ");
        lexparea = new Label("Expertise Area ");

        tfprn = new TextField();
        tfname = new TextField();
        tfyear = new TextField();
        tfdiv = new TextField();
        tfrollno = new TextField();
        tfadd = new TextField();
        tfmobno = new TextField();
        tfemail = new TextField();
        tfhobbies = new TextField();
        tfexparea = new TextField();
        ccourse = new Choice();
        ccourse.add("");
        ccourse.add("MCA");
        ccourse.add("MCS");
        ccourse.add("MBA");
        ccourse.add("BCA");
        ccourse.add("BCS");
        cbg = new CheckboxGroup();
        rbmale = new Checkbox("Male", cbg, true);
        rbfemale = new Checkbox("Female", cbg, false);
        rbother = new Checkbox("Other", cbg, false);

        butadd = new Button("New Registration");
        butsave = new Button("Save Registered Data");
        butback = new Button("Back to Menu");
        butadd.addActionListener(this);
        butsave.addActionListener(this);
        butback.addActionListener(this);

        Font f1 = new Font("arial black", Font.BOLD, 34);
        Font f2 = new Font("times new roman", Font.BOLD, 28);
        Font f3 = new Font("arial", Font.BOLD, 24);

        ltitle.setFont(f1);
        ltitle.setForeground(Color.RED);
        lprn.setFont(f2);
        lname.setFont(f2);
        lyear.setFont(f2);
        lcourse.setFont(f2);
        ldiv.setFont(f2);
        lrollno.setFont(f2);
        ladd.setFont(f2);
        lgender.setFont(f2);
        lmobno.setFont(f2);
        lemail.setFont(f2);
        lhobbies.setFont(f2);
        lexparea.setFont(f2);
        tfprn.setFont(f3);
        tfname.setFont(f3);
        tfyear.setFont(f3);
        tfdiv.setFont(f3);
        tfrollno.setFont(f3);
        tfadd.setFont(f3);
        tfmobno.setFont(f3);
        tfemail.setFont(f3);
        tfhobbies.setFont(f3);
        tfexparea.setFont(f3);
        rbmale.setFont(f3);
        rbfemale.setFont(f3);
        rbother.setFont(f3);
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
        add(ladd);
        add(lgender);
        add(lmobno);
        add(lemail);
        add(lhobbies);
        add(lexparea);
        add(tfprn);
        add(tfname);
        add(tfyear);
        add(tfdiv);
        add(tfrollno);
        add(tfadd);
        add(tfmobno);
        add(tfemail);
        add(tfhobbies);
        add(tfexparea);
        add(ccourse);
        add(rbmale);
        add(rbfemale);
        add(rbother);
        add(butadd);
        add(butsave);
        add(butback);

        ltitle.setBounds(400, 30, 800, 40);
        lprn.setBounds(100, 140, 200, 30);
        tfprn.setBounds(475, 140, 150, 30);
        lname.setBounds(100, 200, 300, 30);
        tfname.setBounds(475, 200, 400, 30);
        lyear.setBounds(100, 260, 300, 30);
        tfyear.setBounds(475, 260, 150, 30);
        lcourse.setBounds(725, 260, 100, 30);
        ccourse.setBounds(850, 260, 200, 30);
        ldiv.setBounds(100, 320, 200, 30);
        tfdiv.setBounds(475, 320, 40, 30);
        lrollno.setBounds(725, 320, 100, 30);
        tfrollno.setBounds(850, 320, 100, 30);
        ladd.setBounds(100, 380, 300, 30);
        tfadd.setBounds(475, 380, 700, 30);
        lgender.setBounds(100, 440, 100, 30);
        rbmale.setBounds(475, 440, 100, 30);
        rbfemale.setBounds(575, 440, 100, 30);
        rbother.setBounds(700, 440, 100, 30);
        lmobno.setBounds(100, 500, 200, 30);
        tfmobno.setBounds(475, 500, 175, 30);
        lemail.setBounds(715, 500, 125, 30);
        tfemail.setBounds(850, 500, 350, 30);
        lhobbies.setBounds(100, 560, 150, 30);
        tfhobbies.setBounds(475, 560, 400, 30);
        lexparea.setBounds(100, 620, 250, 30);
        tfexparea.setBounds(475, 620, 350, 30);
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
        tfname.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfname.getText().length() >= 25)
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

        tfdiv.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfdiv.getText().length() >= 1)
                            ke.consume();
                        if (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
                            return;
                        else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
                            return;
                        else
                            ke.consume();
                    }
                });

        tfrollno.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfrollno.getText().length() >= 2)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();

                    }
                });
        tfadd.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfadd.getText().length() >= 60)
                            ke.consume();
                    }
                });
        tfmobno.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfmobno.getText().length() >= 10)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();
                    }
                });
        tfemail.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfemail.getText().length() >= 25)
                            ke.consume();
                    }
                });

        tfhobbies.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfhobbies.getText().length() >= 40)
                            ke.consume();
                    }
                });
        tfexparea.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfexparea.getText().length() >= 40)
                            ke.consume();
                    }
                });
        tfprn.setEnabled(false);
        tfname.setEnabled(false);
        tfyear.setEnabled(false);
        tfdiv.setEnabled(false);
        tfrollno.setEnabled(false);
        tfadd.setEnabled(false);
        tfmobno.setEnabled(false);
        tfemail.setEnabled(false);
        tfhobbies.setEnabled(false);
        tfexparea.setEnabled(false);
        ccourse.setEnabled(false);
        rbmale.setEnabled(false);
        rbfemale.setEnabled(false);
        rbother.setEnabled(false);
        butsave.setEnabled(false);

        try {
            bw = new BufferedWriter(new FileWriter("Student_Reg.txt", true));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problem during opening the Student Registration File.");
        }

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butadd) {
            tfprn.setEnabled(true);
            tfname.setEnabled(true);
            tfyear.setEnabled(true);
            tfdiv.setEnabled(true);
            tfrollno.setEnabled(true);
            tfadd.setEnabled(true);
            tfmobno.setEnabled(true);
            tfemail.setEnabled(true);
            tfhobbies.setEnabled(true);
            tfexparea.setEnabled(true);
            ccourse.setEnabled(true);
            rbmale.setEnabled(true);
            rbfemale.setEnabled(true);
            rbother.setEnabled(true);
            butsave.setEnabled(true);
            tfprn.requestFocus();

            tfprn.setText("");
            tfname.setText("");
            tfyear.setText("");
            tfdiv.setText("");
            tfrollno.setText("");
            tfadd.setText("");
            tfmobno.setText("");
            tfemail.setText("");
            tfhobbies.setText("");
            tfexparea.setText("");
            ccourse.select(0);
        } else if (ae.getSource() == butsave) {
            if (tfprn.getText().length() == 0 || tfname.getText().length() == 0 || tfyear.getText().length() == 0
                    || tfdiv.getText().length() == 0 || tfrollno.getText().length() == 0
                    || tfadd.getText().length() == 0 || tfmobno.getText().length() == 0
                    || tfemail.getText().length() == 0 || tfhobbies.getText().length() == 0
                    || tfexparea.getText().length() == 0 || ccourse.getSelectedIndex() == 0)
                JOptionPane.showMessageDialog(this, "Some TextFields may be empty please check.");
            else {
                String vprn = tfprn.getText();
                String vname = tfname.getText();
                String vyear = tfyear.getText();
                String vcourse = ccourse.getSelectedItem();
                String vdiv = tfdiv.getText();
                String vrollno = tfrollno.getText();
                String vadd = tfadd.getText();
                String vmobno = tfmobno.getText();
                String vemail = tfemail.getText();
                String vhobbies = tfhobbies.getText();
                String vexparea = tfexparea.getText();
                String vgender;
                if (rbmale.getState() == true)
                    vgender = "M";
                else if (rbfemale.getState() == true)
                    vgender = "F";
                else
                    vgender = "O";
                try {
                    bw.write(vprn + "$" + vname + "$" + vyear + "$" + vcourse + "$" + vdiv + "$" + vrollno + "$" + vadd
                            + "$" + vgender + "$" + vmobno + "$" + vemail + "$" + vhobbies + "$" + vexparea);
                    bw.newLine();
                    JOptionPane.showMessageDialog(this, "Student's Registration data is saved successfully.");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Problem during saving the Student's Registration data.");
                }
                tfprn.setEnabled(false);
                tfname.setEnabled(false);
                tfyear.setEnabled(false);
                tfdiv.setEnabled(false);
                tfrollno.setEnabled(false);
                tfadd.setEnabled(false);
                tfmobno.setEnabled(false);
                tfemail.setEnabled(false);
                tfhobbies.setEnabled(false);
                tfexparea.setEnabled(false);
                ccourse.setEnabled(false);
                rbmale.setEnabled(false);
                rbfemale.setEnabled(false);
                rbother.setEnabled(false);
                butsave.setEnabled(false);
            }
            try {
                bw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Problems during closing the file.");
            }
        } else if (ae.getSource() == butback) {
            dispose();
        }

    }

}
