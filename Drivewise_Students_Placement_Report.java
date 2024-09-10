import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Drivewise_Students_Placement_Report extends JFrame implements ActionListener {
    Label ltitle, ldid, ldate, ltype;
    TextField tfdid, tfdate, tftype;
    Button butval, buthelp, butback;
    BufferedReader brplaced, brstudent, brdrive, brcompany;
    String students_data[][];
    String placed[], student[], drive[], company[];
    String columns[] = {
            "Students PRN",
            "Students Name",
            "Batch Year",
            "Course",
            "Division",
            "Drive ID No.",
            "Drive Conduct Date",
            "Drive Type",
            "Company's ID No.",
            "Company's Name ",
            "Type,Sector",
            "Offered Designation",
            "Offered Package (LPA)" };
      JTable t;
    TableModel tm;
    DefaultTableModel dtm;
    JScrollPane jp;
    JFrame f = new JFrame();
    TextArea ta = new TextArea();
    Drivewise_Students_Placement_Report() {
        setSize(1920, 1080);
        setLayout(null);
        setVisible(true);
        setTitle("Drivewise Students Placement.");
        setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ltitle = new Label("Drivewise Students Placement Information Report.");
        ldid = new Label("Drive ID Number");
        ldate = new Label("Drive Conduct Date");
        ltype = new Label("Drive Type");
        tfdid = new TextField();
        tfdate = new TextField();
        tftype = new TextField();
        butval = new Button("Validate Drive ID");
        buthelp = new Button("Help for Drive ID");
        butback = new Button("Close");
        butval.addActionListener(this);
        buthelp.addActionListener(this);
        butback.addActionListener(this);

        Font f1 = new Font("arial black", Font.BOLD, 34);
        Font f2 = new Font("times new roman", Font.BOLD, 28);

        ltitle.setFont(f1);
        ltitle.setForeground(Color.RED);
        ldid.setFont(f2);
        ldate.setFont(f2);
        ltype.setFont(f2);
        tfdid.setFont(f2);
        tfdate.setFont(f2);
        tftype.setFont(f2);
        butval.setFont(f2);
        buthelp.setFont(f2);
        butback.setFont(f2);

        try {
            int i = 0, n = 0;
            String stud;
            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1]))
                        n++;
                }
            }
            students_data = new String[n][13];
            brstudent.close();

            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1])) {
                        brdrive = new BufferedReader(new FileReader("Conducted_Drives.txt"));
                        while ((stud = brdrive.readLine()) != null) {
                            drive = stud.split("\\$");
                            if (placed[0].equals(drive[0])) {
                                brcompany = new BufferedReader(new FileReader("Company_Reg.txt"));
                                while ((stud = brcompany.readLine()) != null) {
                                    company = stud.split("\\$");
                                    if (drive[3].equals(company[0])) {
                                        students_data[i][0] = student[0];
                                        students_data[i][1] = student[1];
                                        students_data[i][2] = student[2];
                                        students_data[i][3] = student[3];
                                        students_data[i][4] = student[4];
                                        students_data[i][5] = drive[0];
                                        students_data[i][6] = drive[1];
                                        students_data[i][7] = drive[2];
                                        students_data[i][8] = company[0];
                                        students_data[i][9] = company[1];
                                        students_data[i][10] = company[3];
                                        students_data[i][11] = drive[6];
                                        students_data[i][12] = drive[7];
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            brstudent.close();
            brplaced.close();
            brdrive.close();
            brcompany.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problems during Reading the file.");
        }

        t = new JTable(students_data, columns);
        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                f.setVisible(true);
                f.setSize(500, 560);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                int row = t.rowAtPoint(e.getPoint());
                ta.setText(
                        "Selected Students Detail" +
                                "\n----------------------------------------------------" +
                                "\nStudents PRN : " + students_data[row][0] +
                                "\nStudents Name : " + students_data[row][1] +
                                "\nBatch Year : " + students_data[row][2] +
                                "\nCourse : " + students_data[row][3] +
                                "\nDivision : " + students_data[row][4] +
                                "\nDrive ID Number : " + students_data[row][5] +
                                "\nDrive Conduct Date : " + students_data[row][6] +
                                "\nDrive Type : " + students_data[row][7] +
                                "\nCompany's ID Number : " + students_data[row][8] +
                                "\nCompany's Name : " + students_data[row][9] +
                                "\nType,Sector : " + students_data[row][10] +
                                "\nOffered Designation : " + students_data[row][11] +
                                "\nOffered Package (LPA) : " + students_data[row][12]);

                ta.setFont(f2);
                ta.setEditable(false);
                f.add(ta);

            }
        });
        jp = new JScrollPane(t);

        add(ltitle);
        add(ldid);
        add(ldate);
        add(ltype);
        add(tfdid);
        add(tfdate);
        add(tftype);
        add(jp);
        add(butval);
        add(buthelp);
        add(butback);

        ltitle.setBounds(350, 10, 830, 40);

        ldid.setBounds(200, 80, 250, 30);
        tfdid.setBounds(575, 80, 150, 30);
        butval.setBounds(800, 80, 220, 30);
        buthelp.setBounds(1075, 80, 220, 30);

        ldate.setBounds(200, 140, 300, 30);
        tfdate.setBounds(575, 140, 150, 30);
        ltype.setBounds(800, 140, 150, 30);
        tftype.setBounds(1025, 140, 150, 30);

        jp.setBounds(20, 200, 1480, 500);
        butback.setBounds(700, 725, 100, 40);
        tfdid.addKeyListener(
                new KeyAdapter() {

                    public void keyTyped(KeyEvent ke) {
                        if (tfdid.getText().length() >= 2)
                            ke.consume();
                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                            return;
                        else
                            ke.consume();

                    }

                });
        tfdate.setEnabled(false);
        tftype.setEnabled(false);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butback) {
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

                        }

                    }
                    if (status == 0) 
                        JOptionPane.showMessageDialog(this, "You have entered Invalid Drive ID Number.");
                    else
                    driveWise_Report(vdid);

                    
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
                        driveWise_Report(students_data[row][0]);
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
    
    void driveWise_Report(String driveid) {
        try {
            int i = 0, n = 0;
            String stud;
            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1]) && driveid.equals(placed[0]))
                        n++;
                }
            }
            students_data = new String[n][13];
            brstudent.close();
            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1]) && driveid.equals(placed[0])) {
                        brdrive = new BufferedReader(new FileReader("Conducted_Drives.txt"));
                        while ((stud = brdrive.readLine()) != null) {
                            drive = stud.split("\\$");
                            if (placed[0].equals(drive[0])) {
                                brcompany = new BufferedReader(new FileReader("Company_Reg.txt"));
                                while ((stud = brcompany.readLine()) != null) {
                                    company = stud.split("\\$");
                                    if (drive[3].equals(company[0])) {
                                        students_data[i][0] = student[0];
                                        students_data[i][1] = student[1];
                                        students_data[i][2] = student[2];
                                        students_data[i][3] = student[3];
                                        students_data[i][4] = student[4];
                                        students_data[i][5] = drive[0];
                                        students_data[i][6] = drive[1];
                                        students_data[i][7] = drive[2];
                                        students_data[i][8] = company[0];
                                        students_data[i][9] = company[1];
                                        students_data[i][10] = company[3];
                                        students_data[i][11] = drive[6];
                                        students_data[i][12] = drive[7];
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                }

            }
            brcompany.close();
            brdrive.close();
            brstudent.close();
            brplaced.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problems during Reading the file.");
        }
        dtm = new DefaultTableModel(students_data, columns);
        t.setModel(dtm);
        

    }

}
