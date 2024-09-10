
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Coursewise_Students_Placement_Report extends JFrame implements ActionListener, ItemListener {
    Label ltitle;
    Button butback;
    BufferedReader brplaced, brstudent, brdrive, brcompany;
    String students_data[][];
    String placed[], student[], drive[], company[];
    String columns[] = {
            "Students PRN",
            "Students Name",
            "Batch Year",
            "Division",
            "Drive ID Number",
            "Drive Conduct Date",
            "Drive Type",
            "Company's ID Number",
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
    Label lselect;
    CheckboxGroup cbg;
    Checkbox bcs, bca, mcs, mca, mba;

    Coursewise_Students_Placement_Report() {
        setSize(1920, 1080);
        setLayout(null);
        setVisible(true);
        setTitle("Non-Placed Students.");
        setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ltitle = new Label("Coursewise Students Placement Information Reports.");
        lselect = new Label("Select Course :");

        cbg = new CheckboxGroup();
        bcs = new Checkbox("BCS", cbg, false);
        bca = new Checkbox("BCA", cbg, false);
        mca = new Checkbox("MCA", cbg, false);
        mcs = new Checkbox("MCS", cbg, false);
        mba = new Checkbox("MBA", cbg, false);

        bcs.addItemListener(this);
        bca.addItemListener(this);
        mca.addItemListener(this);
        mcs.addItemListener(this);
        mba.addItemListener(this);

        butback = new Button("Close");
        butback.addActionListener(this);

        Font f1 = new Font("arial black", Font.BOLD, 34);
        Font f2 = new Font("times new roman", Font.BOLD, 28);

        ltitle.setFont(f1);
        ltitle.setForeground(Color.RED);
        lselect.setFont(f2);
        lselect.setForeground(Color.BLUE);

        bcs.setFont(f2);
        bca.setFont(f2);
        mca.setFont(f2);
        mcs.setFont(f2);
        mba.setFont(f2);

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
            students_data = new String[n][12];
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
                                        students_data[i][3] = student[4];
                                        students_data[i][4] = drive[0];
                                        students_data[i][5] = drive[1];
                                        students_data[i][6] = drive[2];
                                        students_data[i][7] = company[0];
                                        students_data[i][8] = company[1];
                                        students_data[i][9] = company[3];
                                        students_data[i][10] = drive[6];
                                        students_data[i][11] = drive[7];
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
                f.setSize(500, 520);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                int row = t.rowAtPoint(e.getPoint());
                ta.setText(
                        "Selected Students Detail" +
                                "\n----------------------------------------------------" +
                                "\nStudents PRN : " + students_data[row][0] +
                                "\nStudents Name : " + students_data[row][1] +
                                "\nBatch Year : " + students_data[row][2] +
                                "\nDivision : " + students_data[row][3] +
                                "\nDrive ID Number : " + students_data[row][4] +
                                "\nDrive Conduct Date : " + students_data[row][5] +
                                "\nDrive Type : " + students_data[row][6] +
                                "\nCompany's ID Number : " + students_data[row][7] +
                                "\nCompany's Name : " + students_data[row][8] +
                                "\nType,Sector : " + students_data[row][9] +
                                "\nOffered Designation : " + students_data[row][10] +
                                "\nOffered Package (LPA) : " + students_data[row][11]);

                ta.setFont(f2);
                ta.setEditable(false);
                f.add(ta);

            }
        });
        jp = new JScrollPane(t);

        add(ltitle);
        add(lselect);
        add(bcs);
        add(bca);
        add(mca);
        add(mcs);
        add(mba);
        add(jp);
        add(butback);

        ltitle.setBounds(300, 20, 900, 40);

        lselect.setBounds(400, 100, 200, 30);
        bcs.setBounds(650, 100, 80, 30);
        bca.setBounds(750, 100, 80, 30);
        mca.setBounds(850, 100, 80, 30);
        mcs.setBounds(950, 100, 80, 30);
        mba.setBounds(1050, 100, 80, 30);

        jp.setBounds(20, 160, 1480, 500);
        butback.setBounds(700, 700, 100, 40);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butback) {
            dispose();
            f.dispose();
        }

    }

    public void itemStateChanged(ItemEvent ie) {
        if (bcs.getState() == true) {
            bcs.setForeground(Color.RED);
            bca.setForeground(Color.BLACK);
            mca.setForeground(Color.BLACK);
            mcs.setForeground(Color.BLACK);
            mba.setForeground(Color.BLACK);

            try {
                int i = 0, n = 0;
                String stud;
                brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
                while ((stud = brstudent.readLine()) != null) {
                    student = stud.split("\\$");
                    brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                    while ((stud = brplaced.readLine()) != null) {
                        placed = stud.split("\\$");
                        if (student[0].equals(placed[1]) && student[3].equals("BCS"))
                            n++;
                    }
                }
                students_data = new String[n][12];
                brstudent.close();
                brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
                while ((stud = brstudent.readLine()) != null) {
                    student = stud.split("\\$");
                    brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                    while ((stud = brplaced.readLine()) != null) {
                        placed = stud.split("\\$");
                        if (student[0].equals(placed[1]) && student[3].equals("BCS")) {
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
                                            students_data[i][3] = student[4];
                                            students_data[i][4] = drive[0];
                                            students_data[i][5] = drive[1];
                                            students_data[i][6] = drive[2];
                                            students_data[i][7] = company[0];
                                            students_data[i][8] = company[1];
                                            students_data[i][9] = company[3];
                                            students_data[i][10] = drive[6];
                                            students_data[i][11] = drive[7];
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
            dtm = new DefaultTableModel(students_data, columns);
            t.setModel(dtm);

        }
        else if (bca.getState() == true) {
            bcs.setForeground(Color.BLACK);
            bca.setForeground(Color.RED);
            mca.setForeground(Color.BLACK);
            mcs.setForeground(Color.BLACK);
            mba.setForeground(Color.BLACK);
            try {
                int i = 0, n = 0;
                String stud;
                brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
                while ((stud = brstudent.readLine()) != null) {
                    student = stud.split("\\$");
                    brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                    while ((stud = brplaced.readLine()) != null) {
                        placed = stud.split("\\$");
                        if (student[0].equals(placed[1]) && student[3].equals("BCA"))
                            n++;
                    }
                }
                students_data = new String[n][12];
                brstudent.close();
                brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
                while ((stud = brstudent.readLine()) != null) {
                    student = stud.split("\\$");
                    brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                    while ((stud = brplaced.readLine()) != null) {
                        placed = stud.split("\\$");
                        if (student[0].equals(placed[1]) && student[3].equals("BCA")) {
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
                                            students_data[i][3] = student[4];
                                            students_data[i][4] = drive[0];
                                            students_data[i][5] = drive[1];
                                            students_data[i][6] = drive[2];
                                            students_data[i][7] = company[0];
                                            students_data[i][8] = company[1];
                                            students_data[i][9] = company[3];
                                            students_data[i][10] = drive[6];
                                            students_data[i][11] = drive[7];
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
            dtm = new DefaultTableModel(students_data, columns);
            t.setModel(dtm);

        }
        else if (mca.getState() == true) {
            bcs.setForeground(Color.BLACK);
            bca.setForeground(Color.BLACK);
            mca.setForeground(Color.RED);
            mcs.setForeground(Color.BLACK);
            mba.setForeground(Color.BLACK);
            try {
                int i = 0, n = 0;
                String stud;
                brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
                while ((stud = brstudent.readLine()) != null) {
                    student = stud.split("\\$");
                    brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                    while ((stud = brplaced.readLine()) != null) {
                        placed = stud.split("\\$");
                        if (student[0].equals(placed[1]) && student[3].equals("MCA"))
                            n++;
                    }
                }
                students_data = new String[n][12];
                brstudent.close();
                brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
                while ((stud = brstudent.readLine()) != null) {
                    student = stud.split("\\$");
                    brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                    while ((stud = brplaced.readLine()) != null) {
                        placed = stud.split("\\$");
                        if (student[0].equals(placed[1]) && student[3].equals("MCA")) {
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
                                            students_data[i][3] = student[4];
                                            students_data[i][4] = drive[0];
                                            students_data[i][5] = drive[1];
                                            students_data[i][6] = drive[2];
                                            students_data[i][7] = company[0];
                                            students_data[i][8] = company[1];
                                            students_data[i][9] = company[3];
                                            students_data[i][10] = drive[6];
                                            students_data[i][11] = drive[7];
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
            dtm = new DefaultTableModel(students_data, columns);
            t.setModel(dtm);

        }
        else if (mcs.getState() == true) {
            bcs.setForeground(Color.BLACK);
            bca.setForeground(Color.BLACK);
            mca.setForeground(Color.BLACK);
            mcs.setForeground(Color.RED);
            mba.setForeground(Color.BLACK);
            try {
                int i = 0, n = 0;
                String stud;
                brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
                while ((stud = brstudent.readLine()) != null) {
                    student = stud.split("\\$");
                    brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                    while ((stud = brplaced.readLine()) != null) {
                        placed = stud.split("\\$");
                        if (student[0].equals(placed[1]) && student[3].equals("MCS"))
                            n++;
                    }
                }
                students_data = new String[n][12];
                brstudent.close();
                brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
                while ((stud = brstudent.readLine()) != null) {
                    student = stud.split("\\$");
                    brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                    while ((stud = brplaced.readLine()) != null) {
                        placed = stud.split("\\$");
                        if (student[0].equals(placed[1]) && student[3].equals("MCS")) {
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
                                            students_data[i][3] = student[4];
                                            students_data[i][4] = drive[0];
                                            students_data[i][5] = drive[1];
                                            students_data[i][6] = drive[2];
                                            students_data[i][7] = company[0];
                                            students_data[i][8] = company[1];
                                            students_data[i][9] = company[3];
                                            students_data[i][10] = drive[6];
                                            students_data[i][11] = drive[7];
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
            dtm = new DefaultTableModel(students_data, columns);
            t.setModel(dtm);

        }

        else if (mba.getState() == true) {
            bcs.setForeground(Color.BLACK);
            bca.setForeground(Color.BLACK);
            mca.setForeground(Color.BLACK);
            mcs.setForeground(Color.BLACK);
            mba.setForeground(Color.RED);
            try {
                int i = 0, n = 0;
                String stud;
                brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
                while ((stud = brstudent.readLine()) != null) {
                    student = stud.split("\\$");
                    brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                    while ((stud = brplaced.readLine()) != null) {
                        placed = stud.split("\\$");
                        if (student[0].equals(placed[1]) && student[3].equals("MBA"))
                            n++;
                    }
                }
                students_data = new String[n][12];
                brstudent.close();
                brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
                while ((stud = brstudent.readLine()) != null) {
                    student = stud.split("\\$");
                    brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                    while ((stud = brplaced.readLine()) != null) {
                        placed = stud.split("\\$");
                        if (student[0].equals(placed[1]) && student[3].equals("MBA")) {
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
                                            students_data[i][3] = student[4];
                                            students_data[i][4] = drive[0];
                                            students_data[i][5] = drive[1];
                                            students_data[i][6] = drive[2];
                                            students_data[i][7] = company[0];
                                            students_data[i][8] = company[1];
                                            students_data[i][9] = company[3];
                                            students_data[i][10] = drive[6];
                                            students_data[i][11] = drive[7];
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
            dtm = new DefaultTableModel(students_data, columns);
            t.setModel(dtm);

        }
    }
}
