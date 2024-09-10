import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Company_Reg extends JFrame implements ActionListener {
    Label ltitle, lid, lname, ladd, ltype, lcontact1, lname1, ldeg1, lmobno1, lemail1, lcontact2, lname2, ldeg2,lmobno2, lemail2;
    TextField tfid, tfname, tfadd, tftype, tfname1, tfdeg1, tfmobno1, tfemail1, tfname2, tfdeg2, tfmobno2, tfemail2;
    Button butadd, butsave, butback;
    BufferedWriter bw;

    Company_Reg() {
        setSize(1920, 1080);
        setLayout(null);
        setVisible(true);
        setTitle("Company Registration Form");
        setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ltitle = new Label("Job Provider Companies Data Retrieval.");
        lid = new Label("Company's ID Number");
        lname = new Label("Company's Name ");
        ladd = new Label("Office Address");
        ltype = new Label("Type,Sector");
        lcontact1 = new Label(
                "------------------------------------------------------------------------------------------Contact Person 1--------------------------------------------------------------------------------");
        lname1 = new Label("Person-1 Name");
        ldeg1 = new Label("Person-1 Designation");
        lmobno1 = new Label("Person-1 Mobile Number ");
        lemail1 = new Label("Person-1  E-Mail ID ");
        lcontact2 = new Label(
                "------------------------------------------------------------------------------------------Contact Person 2--------------------------------------------------------------------------------");
        lname2 = new Label("Person-1 Name");
        ldeg2 = new Label("Person-1 Designation");
        lmobno2 = new Label("Person-2 Mobile Number");
        lemail2 = new Label("Person-2  E-Mail ID ");

        tfid = new TextField();
        tfname = new TextField();
        tfadd = new TextField();
        tftype = new TextField();
        tfname1 = new TextField();
        tfdeg1 = new TextField();
        tfmobno1 = new TextField();
        tfemail1 = new TextField();
        tfname2 = new TextField();
        tfdeg2 = new TextField();
        tfmobno2 = new TextField();
        tfemail2 = new TextField();

        butadd = new Button("New Registration");
        butsave = new Button("Save Registered Data");
        butback = new Button("Back to Menu");
        butadd.addActionListener(this);
        butsave.addActionListener(this);
        butback.addActionListener(this);

        Font f1 = new Font("arial black", Font.BOLD, 34);
        Font f2 = new Font("times new roman", Font.BOLD, 28);
        Font f3 = new Font("arial", Font.BOLD, 24);
        Font f4 = new Font("arial", Font.BOLD, 20);

        ltitle.setFont(f1);
        ltitle.setForeground(Color.RED);
        lid.setFont(f2);
        lname.setFont(f2);
        ladd.setFont(f2);
        ltype.setFont(f2);
        lcontact1.setFont(f4);
        lname1.setFont(f2);
        ldeg1.setFont(f2);
        lmobno1.setFont(f2);
        lemail1.setFont(f2);
        lcontact2.setFont(f4);
        lname2.setFont(f2);
        ldeg2.setFont(f2);
        lmobno2.setFont(f2);
        lemail2.setFont(f2);
        tfid.setFont(f3);
        tfname.setFont(f3);
        tfadd.setFont(f3);
        tftype.setFont(f3);
        tfname1.setFont(f3);
        tfdeg1.setFont(f3);
        tfmobno1.setFont(f3);
        tfemail1.setFont(f3);
        tfname2.setFont(f3);
        tfdeg2.setFont(f3);
        tfmobno2.setFont(f3);
        tfemail2.setFont(f3);
        butadd.setFont(f2);
        butsave.setFont(f2);
        butback.setFont(f2);

        add(ltitle);
        add(lid);
        add(lname);
        add(ladd);
        add(ltype);
        add(lcontact1);
        add(lname1);
        add(ldeg1);
        add(lmobno1);
        add(lemail1);
        add(lcontact2);
        add(lname2);
        add(ldeg2);
        add(lmobno2);
        add(lemail2);
        add(tfid);
        add(tfname);
        add(tfadd);
        add(tftype);
        add(tfname1);
        add(tfdeg1);
        add(tfmobno1);
        add(tfemail1);
        add(tfname2);
        add(tfdeg2);
        add(tfmobno2);
        add(tfemail2);
        add(butadd);
        add(butsave);
        add(butback);

        ltitle.setBounds(400, 0, 800, 40);
        lid.setBounds(100, 70, 300, 30);
        tfid.setBounds(475, 70, 150, 30);
        lname.setBounds(100, 130, 300, 30);
        tfname.setBounds(475, 130, 400, 30);
        ladd.setBounds(100, 190, 300, 30);
        tfadd.setBounds(475, 190, 700, 30);
        ltype.setBounds(100, 250, 200, 30);
        tftype.setBounds(475, 250, 500, 30);

        lcontact1.setBounds(100, 310, 1250, 20);
        lname1.setBounds(100, 360, 300, 30);
        tfname1.setBounds(475, 360, 400, 30);
        ldeg1.setBounds(100, 410, 300, 30);
        tfdeg1.setBounds(475, 410, 400, 30);
        lmobno1.setBounds(100, 460, 350, 30);
        tfmobno1.setBounds(475, 460, 175, 30);
        lemail1.setBounds(715, 460, 250, 30);
        tfemail1.setBounds(1000, 460, 350, 30);

        lcontact2.setBounds(100, 520, 1250, 20);
        lname2.setBounds(100, 570, 300, 30);
        tfname2.setBounds(475, 570, 400, 30);
        ldeg2.setBounds(100, 620, 300, 30);
        tfdeg2.setBounds(475, 620, 400, 30);
        lmobno2.setBounds(100, 670, 350, 30);
        tfmobno2.setBounds(475, 670, 175, 30);
        lemail2.setBounds(715, 670, 250, 30);
        tfemail2.setBounds(1000, 670, 350, 30);
        butadd.setBounds(275, 730, 250, 40);
        butsave.setBounds(575, 730, 300, 40);
        butback.setBounds(925, 730, 250, 40);

        tfid.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfid.getText().length() >= 10)
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
        tfadd.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfadd.getText().length() >= 60)
                            ke.consume();
                    }
                });
        tftype.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tftype.getText().length() >= 25)
                            ke.consume();
                    }
                });
        tfname1.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfname1.getText().length() >= 25)
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
        tfname2.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfname2.getText().length() >= 25)
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
        tfdeg1.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfdeg1.getText().length() >= 25)
                            ke.consume();
                    }
                });
        tfdeg2.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfdeg2.getText().length() >= 25)
                            ke.consume();
                    }
                });
        tfmobno1.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfmobno1.getText().length() >= 10)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();
                    }
                });
        tfmobno2.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfmobno2.getText().length() >= 10)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();
                    }
                });
        tfemail1.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfemail1.getText().length() >= 25)
                            ke.consume();
                    }
                });
        tfemail2.addKeyListener(
                new KeyAdapter() {
                    public void keyTyped(KeyEvent ke) {
                        if (tfemail2.getText().length() >= 25)
                            ke.consume();
                    }
                });

        tfid.setEnabled(false);
        tfname.setEnabled(false);
        tfadd.setEnabled(false);
        tftype.setEnabled(false);
        tfname1.setEnabled(false);
        tfdeg1.setEnabled(false);
        tfmobno1.setEnabled(false);
        tfemail1.setEnabled(false);
        tfname2.setEnabled(false);
        tfdeg2.setEnabled(false);
        tfmobno2.setEnabled(false);
        tfemail2.setEnabled(false);
        butsave.setEnabled(false);

        try {
            bw = new BufferedWriter(new FileWriter("Company_Reg.txt", true));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problem during opening the Company Registration File.");
        }

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butadd) {
            tfid.setEnabled(true);
            tfname.setEnabled(true);
            tfadd.setEnabled(true);
            tftype.setEnabled(true);
            tfname1.setEnabled(true);
            tfdeg1.setEnabled(true);
            tfmobno1.setEnabled(true);
            tfemail1.setEnabled(true);
            tfname2.setEnabled(true);
            tfdeg2.setEnabled(true);
            tfmobno2.setEnabled(true);
            tfemail2.setEnabled(true);
            butsave.setEnabled(true);
            tfid.requestFocus();

            tfid.setText("");
            tfname.setText("");
            tfadd.setText("");
            tftype.setText("");
            tfname1.setText("");
            tfdeg1.setText("");
            tfmobno1.setText("");
            tfemail1.setText("");
            tfname2.setText("");
            tfdeg2.setText("");
            tfmobno2.setText("");
            tfemail2.setText("");
        } else if (ae.getSource() == butsave) {
            if (tfid.getText().length() == 0 || tfname.getText().length() == 0 || tfadd.getText().length() == 0 ||
                    tftype.getText().length() == 0 || tfdeg1.getText().length() == 0 || tfname1.getText().length() == 0 || tfmobno1.getText().length() == 0
                    ||
                    tfemail1.getText().length() == 0 || tfdeg2.getText().length() == 0 || tfname2.getText().length() == 0
                    || tfmobno2.getText().length() == 0 ||
                    tfemail2.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Some TextFields may be empty please check.");
            else {
                String vid = tfid.getText();
                String vname = tfname.getText();
                String vadd = tfadd.getText();
                String vtype = tftype.getText();
                String vname1 = tfname1.getText();
                String vdeg1 = tfdeg1.getText();
                String vmobno1 = tfmobno1.getText();
                String vemail1 = tfemail1.getText();
                String vname2 = tfname2.getText();
                String vdeg2 = tfdeg2.getText();
                String vmobno2 = tfmobno2.getText();
                String vemail2 = tfemail2.getText();

                try {
                    bw.write(vid + "$" + vname + "$" + vadd + "$" + vtype + "$" + vname1+ "$" +vdeg1 + "$" + vmobno1 + "$" + vemail1
                            + "$" + vname2 + "$"+vdeg2 + "$"
                            + vmobno2 + "$" + vemail2);
                    bw.newLine();
                    JOptionPane.showMessageDialog(this, "Company's Registration data is saved successfully.");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Problem during saving the Company's Registration data.");
                }

                tfid.setEnabled(false);
                tfname.setEnabled(false);
                tfadd.setEnabled(false);
                tftype.setEnabled(false);
                tfname1.setEnabled(false);
                tfdeg1.setEnabled(false);
                tfmobno1.setEnabled(false);
                tfemail1.setEnabled(false);
                tfname2.setEnabled(false);
                tfdeg2.setEnabled(false);
                tfmobno2.setEnabled(false);
                tfemail2.setEnabled(false);
                butsave.setEnabled(false);

            }

            try {
                bw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Problems during closing the file.");
            }

        } else if (ae.getSource() == butback)

        {
            dispose();
        }

    }
}
