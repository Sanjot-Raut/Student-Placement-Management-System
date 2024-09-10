import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketTimeoutException;
import javax.swing.*;

public class Students_Courses extends JFrame implements ActionListener {
    Label ltitle, lprn, lname, lyear, lcourse, ldiv, lrollno, lstudent, lcno, lctitle, lcdur, lhighlight, lresult;
    TextField tfprn, tfname, tfyear, tfcourse, tfdiv, tfrollno, tfcno, tfctitle, tfcdur, tfhighlight, tfresult;
    Button butval, buthelp, butadd, butsave, butback;
    BufferedWriter bw;

    Students_Courses() {
        setSize(1920, 1080);
        setLayout(null);
        setVisible(true);
        setTitle("Student's Certified Courses / Projects Data");
        setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ltitle = new Label("Student's Certified Courses / Projects Record Keeping.");
        lprn = new Label("Students PRN");
        lname = new Label("Students Name ");
        lyear = new Label("Batch Year");
        lcourse = new Label("Course");
        ldiv = new Label("Division");
        lrollno = new Label("Roll No.");
        lstudent = new Label(
                "------------------------------------------Enter Certified Courses / Projects Data For Above Student-------------------------------------------");
        lcno = new Label("Course Sr. No.");
        lctitle = new Label("Course Title");
        lcdur = new Label("Course Duration");
        lhighlight = new Label("Highlighted Key Contents");
        lresult = new Label("Result in %");

        tfprn = new TextField();
        tfname = new TextField();
        tfyear = new TextField();
        tfcourse = new TextField();
        tfdiv = new TextField();
        tfrollno = new TextField();
        tfcno = new TextField();
        tfctitle = new TextField();
        tfcdur = new TextField();
        tfhighlight = new TextField();
        tfresult = new TextField();

        butval = new Button("Validate PRN");
        buthelp = new Button("Help for PRN");
        butadd = new Button("New Course Data");
        butsave = new Button("Save Course Data");
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
        lcno.setFont(f2);
        lctitle.setFont(f2);
        lcdur.setFont(f2);
        lhighlight.setFont(f2);
        lresult.setFont(f2);

        tfprn.setFont(f3);
        tfname.setFont(f3);
        tfyear.setFont(f3);
        tfcourse.setFont(f3);
        tfdiv.setFont(f3);
        tfrollno.setFont(f3);
        tfcno.setFont(f3);
        tfctitle.setFont(f3);
        tfcdur.setFont(f3);
        tfhighlight.setFont(f3);
        tfresult.setFont(f3);

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
        add(lcno);
        add(lctitle);
        add(lcdur);
        add(lhighlight);
        add(lresult);

        add(tfprn);
        add(tfname);
        add(tfyear);
        add(tfcourse);
        add(tfdiv);
        add(tfrollno);
        add(tfcno);
        add(tfctitle);
        add(tfcdur);
        add(tfhighlight);
        add(tfresult);

        add(butval);
        add(buthelp);
        add(butadd);
        add(butsave);
        add(butback);

        ltitle.setBounds(300, 30, 900, 40);
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

        lcno.setBounds(200, 440, 300, 30);
        tfcno.setBounds(575, 440, 150, 30);

        lctitle.setBounds(200, 490, 300, 30);
        tfctitle.setBounds(575, 490, 300, 30);

        lcdur.setBounds(200, 540, 300, 30);
        tfcdur.setBounds(575, 540, 150, 30);

        lhighlight.setBounds(200, 590, 350, 30);
        tfhighlight.setBounds(575, 590, 400, 30);

        lresult.setBounds(200, 640, 300, 30);
        tfresult.setBounds(575, 640, 150, 30);

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
        tfcno.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfcno.getText().length() >= 2)
                            ke.consume();
                    }
                });

        tfresult.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfresult.getText().length() >= 5)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else if (ke.getKeyChar() == '.')
                            return;
                        else
                            ke.consume();

                    }
                });
        tfctitle.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfctitle.getText().length() >= 25)
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
        tfcno.setEnabled(false);
        tfctitle.setEnabled(false);
        tfcdur.setEnabled(false);
        tfhighlight.setEnabled(false);
        tfresult.setEnabled(false);

        butval.setEnabled(false);
        buthelp.setEnabled(false);
        butsave.setEnabled(false);

        try {
            bw = new BufferedWriter(new FileWriter("Student_Courses.txt", true));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problem during opening the Student Courses File.");
        }

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butadd) {
            tfprn.setEnabled(true);
            tfcno.setEnabled(true);
            tfctitle.setEnabled(true);
            tfcdur.setEnabled(true);
            tfhighlight.setEnabled(true);
            tfresult.setEnabled(true);

            butval.setEnabled(true);
            buthelp.setEnabled(true);
            tfprn.requestFocus();

            tfprn.setText("");
            tfname.setText("");
            tfyear.setText("");
            tfcourse.setText("");
            tfdiv.setText("");
            tfrollno.setText("");
            tfcno.setText("");
            tfctitle.setText("");
            tfcdur.setText("");
            tfhighlight.setText("");
            tfresult.setText("");

        } else if (ae.getSource() == butsave) {
            if (tfprn.getText().length() == 0 || tfcno.getText().length() == 0 || tfctitle.getText().length() == 0
                    || tfcdur.getText().length() == 0 || tfhighlight.getText().length() == 0
                    || tfresult.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Some TextFields may be empty please check.");
            else {
                String vprn = tfprn.getText();
                String vcno = tfcno.getText();
                String vctitle = tfctitle.getText();
                String vcdur = tfcdur.getText();
                String vhighlight = tfhighlight.getText();
                String vresult = tfresult.getText();

                try {
                    bw.write(vprn + "$" + vcno + "$" + vctitle + "$" + vcdur + "$" + vhighlight + "$" + vresult);
                    bw.newLine();
                    JOptionPane.showMessageDialog(this, "Student's Courses data is saved successfully.");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Problem during saving the Student's Courses data.");
                }
                tfprn.setEnabled(false);
                tfcno.setEnabled(false);
                tfctitle.setEnabled(false);
                tfcdur.setEnabled(false);
                tfhighlight.setEnabled(false);
                tfresult.setEnabled(false);

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
