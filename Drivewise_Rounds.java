
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketTimeoutException;

import javax.swing.*;

public class Drivewise_Rounds extends JFrame implements ActionListener {
    Label ltitle, ldid, ldate, ltype, ldrive, lrno, lrtitle, lskills, lsno, lqsprn;
    TextField tfdid, tfdate, tftype, tfrno, tfrtitle, tfskills, tfsno, tfqsprn;
    Button butval, buthelp, butadd, butsave, butback;
    BufferedWriter bw;
    JFrame f;

    Drivewise_Rounds() {
        setSize(1920, 1080);
        setLayout(null);
        setVisible(true);
        setTitle("Drivewise  Rounds");
        setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ltitle = new Label("Drivewise Conducted Rounds Data.");
        ldid = new Label("Drive ID Number");
        ldate = new Label("Drive Conduct Date");
        ltype = new Label("Drive Type");
        ldrive = new Label(
                "-----------------------------------------------------------Enter Rounds Data For Above Drive-----------------------------------------------------------");

        lrno = new Label("Round Number");
        lrtitle = new Label("Round Title");
        lskills = new Label("Tested Skills");
        lsno = new Label("No. of Students Qualified");
        lqsprn = new Label("Qualified Student's PRN");

        tfdid = new TextField();
        tfdate = new TextField();
        tftype = new TextField();
        tfrno = new TextField();
        tfrtitle = new TextField();
        tfskills = new TextField();
        tfsno = new TextField();
        tfqsprn = new TextField();

        butval = new Button("Validate Drive ID");
        buthelp = new Button("Help for Drive ID");
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
        ldid.setFont(f2);
        ldate.setFont(f2);
        ltype.setFont(f2);
        ldrive.setFont(f4);
        lrno.setFont(f2);
        lrtitle.setFont(f2);
        lskills.setFont(f2);
        lsno.setFont(f2);
        lqsprn.setFont(f2);

        tfdid.setFont(f3);
        tfdate.setFont(f3);
        tftype.setFont(f3);
        tfrno.setFont(f3);
        tfrtitle.setFont(f3);
        tfskills.setFont(f3);
        tfsno.setFont(f3);
        tfqsprn.setFont(f3);

        butval.setFont(f2);
        buthelp.setFont(f2);
        butadd.setFont(f2);
        butsave.setFont(f2);
        butback.setFont(f2);

        add(ltitle);
        add(ldid);
        add(ldate);
        add(ltype);
        add(ldrive);
        add(lrno);
        add(lrtitle);
        add(lskills);
        add(lsno);
        add(lqsprn);

        add(tfdid);
        add(tfdate);
        add(tftype);
        add(tfrno);
        add(tfrtitle);
        add(tfskills);
        add(tfsno);
        add(tfqsprn);

        add(butval);
        add(buthelp);
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

        lrno.setBounds(200, 380, 200, 30);
        tfrno.setBounds(575, 380, 40, 30);

        lrtitle.setBounds(200, 440, 300, 30);
        tfrtitle.setBounds(575, 440, 300, 30);

        lskills.setBounds(200, 500, 300, 30);
        tfskills.setBounds(575, 500, 500, 30);

        lsno.setBounds(200, 560, 330, 30);
        tfsno.setBounds(575, 560, 100, 30);

        lqsprn.setBounds(200, 620, 320, 30);
        tfqsprn.setBounds(575, 620, 725, 30);

        butadd.setBounds(275, 700, 250, 40);
        butsave.setBounds(575, 700, 300, 40);
        butback.setBounds(925, 700, 250, 40);

        tfrno.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfrno.getText().length() >= 2)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();

                    }
                });

        tfdid.setEnabled(false);
        tfdate.setEnabled(false);
        tftype.setEnabled(false);
        tfrno.setEnabled(false);
        tfrtitle.setEnabled(false);
        tfskills.setEnabled(false);
        tfsno.setEnabled(false);
        tfqsprn.setEnabled(false);
        butval.setEnabled(false);
        buthelp.setEnabled(false);
        butsave.setEnabled(false);

        try {
            bw = new BufferedWriter(new FileWriter("Drivewise_Rounds.txt", true));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problem during opening the Student Registration File.");
        }

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butadd) {
            tfdid.setEnabled(true);
            tfrno.setEnabled(true);
            tfrtitle.setEnabled(true);
            tfskills.setEnabled(true);
            tfsno.setEnabled(true);
            tfqsprn.setEnabled(true);
            butval.setEnabled(true);
            buthelp.setEnabled(true);
            tfdid.requestFocus();

            tfdid.setText("");
            tfdate.setText("");
            tftype.setText("");
            tfrno.setText("");
            tfrtitle.setText("");
            tfskills.setText("");
            tfsno.setText("");
            tfqsprn.setText("");

        } else if (ae.getSource() == butsave) {
            if (tfdid.getText().length() == 0 || tfrno.getText().length() == 0 || tfrtitle.getText().length() == 0
                    || tfskills.getText().length() == 0 || tfsno.getText().length() == 0
                    || tfqsprn.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Some TextFields may be empty please check.");
            else {
                String vdid = tfdid.getText();
                String vrno = tfrno.getText();
                String vrtitle = tfrtitle.getText();
                String vskills = tfskills.getText();
                String vsno = tfsno.getText();
                String vqsprn = tfqsprn.getText();

                try {
                    bw.write(vdid + "$" + vrno + "$" + vrtitle + "$" + vskills + "$" + vsno + "$" + vqsprn);
                    bw.newLine();
                    JOptionPane.showMessageDialog(this, "Drivewise Rounds data is saved successfully.");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Problem during saving the Drivewise Rounds data.");
                }
                tfdid.setEnabled(false);
                tfdate.setEnabled(false);
                tftype.setEnabled(false);
                tfrno.setEnabled(false);
                tfrtitle.setEnabled(false);
                tfskills.setEnabled(false);
                tfsno.setEnabled(false);
                tfqsprn.setEnabled(false);
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
            f.dispose();
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
                            butsave.setEnabled(true);

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
                f = new JFrame();
                f.setVisible(true);
                f.setSize(500, 500);
                JTable t = new JTable(students_data, columns);
                t.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        int row = t.rowAtPoint(e.getPoint());
                        tfdid.setText(students_data[row][0]);
                        tfdate.setText(students_data[row][1]);
                        tftype.setText(students_data[row][2]);
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
