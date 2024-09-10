
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Nonplaced_Students_Report extends JFrame implements ActionListener,ItemListener {
    Label ltitle;
    Button butback;
    BufferedReader brplaced, brstudent;
    String students_data[][];
    String placed[], student[], drive[];
    String columns[] = { "Students PRN", "Students Name", "Batch Year", "Course", "Division", "Roll No.",
                "Permanent Address", "Gender", "Mobile Number", "E-Mail ID", "Hobbies", "Expertise Area" };
    JTable t;
    TableModel tm;
    DefaultTableModel dtm;
    JScrollPane jp;
    JFrame f = new JFrame();
    TextArea ta = new TextArea();
    Label lselect;
    CheckboxGroup cbg;
    Checkbox bcs, bca, mcs, mca, mba;

    Nonplaced_Students_Report() {
        setSize(1920, 1080);
        setLayout(null);
        setVisible(true);
        setTitle("Non-Placed Students.");
        setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ltitle = new Label("Non Placed Students Information Report (Course Wise).");
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

        bcs.setFont(f2);
        bca.setFont(f2);
        mca.setFont(f2);
        mcs.setFont(f2);
        mba.setFont(f2);

        butback.setFont(f2);

        try {
            int i = 0, n = 0, status = 0;
            String stud;
            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1]))
                        status = 1;
                }
                if (status == 0)
                    n++;
                status = 0;
          
               
            }
            students_data = new String[n][12];
            brstudent.close();
            brplaced.close();
            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1]))
                        status = 1;
                }
                if (status == 0) {
                    students_data[i][0] = student[0];
                    students_data[i][1] = student[1];
                    students_data[i][2] = student[2];
                    students_data[i][3] = student[3];
                    students_data[i][4] = student[4];
                    students_data[i][5] = student[5];
                    students_data[i][6] = student[6];
                    students_data[i][7] = student[7];
                    students_data[i][8] = student[8];
                    students_data[i][9] = student[9];
                    students_data[i][10] = student[10];
                    students_data[i][11] = student[11];
                    i++;
                }
                status = 0;
            }
            brstudent.close();
            brplaced.close();
           

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problems during Reading the file.");
        }

        
        t = new JTable(students_data,columns);
        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                f.setVisible(true);
                f.setSize(500, 500);
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
                                "\nRoll No. : " + students_data[row][5] +
                                "\nPermanent Address : " + students_data[row][6] +
                                "\nGender : " + students_data[row][7] +
                                "\nMobile Number : " + students_data[row][8] +
                                "\nE-Mail ID : " + students_data[row][9] +
                                "\nHobbies : " + students_data[row][10] +
                                "\nExpertise Area : " + students_data[row][11]);

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

        jp.setBounds(40, 160, 1460, 500);
        butback.setBounds(700, 700, 100, 40);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butback)
            dispose();
        f.dispose();

    }

    public void itemStateChanged(ItemEvent ie) {
        if (bcs.getState() == true) {
            bcs.setForeground(Color.RED);
            bca.setForeground(Color.BLACK);
            mca.setForeground(Color.BLACK);
            mcs.setForeground(Color.BLACK);
            mba.setForeground(Color.BLACK);
            try {
            int i = 0, n = 0, status = 0;
            String stud;
            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1]))
                        status = 1;
                }
                if (status == 0 && student[3].equals("BCS"))
                    n++;
                status = 0;
            }
            students_data = new String[n][12];
            brstudent.close();
            brplaced.close();
            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1]))
                        status = 1;
                }
                if (status == 0 && student[3].equals("BCS")) {
                    students_data[i][0] = student[0];
                    students_data[i][1] = student[1];
                    students_data[i][2] = student[2];
                    students_data[i][3] = student[3];
                    students_data[i][4] = student[4];
                    students_data[i][5] = student[5];
                    students_data[i][6] = student[6];
                    students_data[i][7] = student[7];
                    students_data[i][8] = student[8];
                    students_data[i][9] = student[9];
                    students_data[i][10] = student[10];
                    students_data[i][11] = student[11];
                    i++;
                }
                status = 0;

            }
            brstudent.close();
            brplaced.close();
         

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problems during Reading the file.");
        }
        dtm = new DefaultTableModel(students_data, columns);
        t.setModel(dtm);
        }
        if (bca.getState() == true) {
            bcs.setForeground(Color.BLACK);
            bca.setForeground(Color.RED);
            mca.setForeground(Color.BLACK);
            mcs.setForeground(Color.BLACK);
            mba.setForeground(Color.BLACK);
          
            try {
            int i = 0, n = 0, status = 0;
            String stud;
            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1]))
                        status = 1;
                }
                if (status == 0 && student[3].equals("BCA"))
                    n++;
                status = 0;
            }
            students_data = new String[n][12];
            brstudent.close();
            brplaced.close();
            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1]))
                        status = 1;
                }
                if (status == 0 && student[3].equals("BCA")) {
                    students_data[i][0] = student[0];
                    students_data[i][1] = student[1];
                    students_data[i][2] = student[2];
                    students_data[i][3] = student[3];
                    students_data[i][4] = student[4];
                    students_data[i][5] = student[5];
                    students_data[i][6] = student[6];
                    students_data[i][7] = student[7];
                    students_data[i][8] = student[8];
                    students_data[i][9] = student[9];
                    students_data[i][10] = student[10];
                    students_data[i][11] = student[11];
                    i++;
                }
                status = 0;

            }
            brstudent.close();
            brplaced.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problems during Reading the file.");
        }
        dtm = new DefaultTableModel(students_data, columns);
        t.setModel(dtm);
        

            
           
        }
        if (mca.getState() == true) {
            bcs.setForeground(Color.BLACK);
            bca.setForeground(Color.BLACK);
            mca.setForeground(Color.RED);
            mcs.setForeground(Color.BLACK);
            mba.setForeground(Color.BLACK);
          
            try {
            int i = 0, n = 0, status = 0;
            String stud;
            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1]))
                        status = 1;
                }
                if (status == 0 && student[3].equals("MCA"))
                    n++;
                status = 0;
            }
            students_data = new String[n][12];
            brstudent.close();
            brplaced.close();

            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1]))
                        status = 1;
                }
                if (status == 0 && student[3].equals("MCA")) {
                    students_data[i][0] = student[0];
                    students_data[i][1] = student[1];
                    students_data[i][2] = student[2];
                    students_data[i][3] = student[3];
                    students_data[i][4] = student[4];
                    students_data[i][5] = student[5];
                    students_data[i][6] = student[6];
                    students_data[i][7] = student[7];
                    students_data[i][8] = student[8];
                    students_data[i][9] = student[9];
                    students_data[i][10] = student[10];
                    students_data[i][11] = student[11];
                    i++;
                }
                status = 0;

            }
            brstudent.close();
            brplaced.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problems during Reading the file.");
        }
        dtm = new DefaultTableModel(students_data, columns);
        t.setModel(dtm);
        

            
           
        }
        if (mcs.getState() == true) {
            bcs.setForeground(Color.BLACK);
            bca.setForeground(Color.BLACK);
            mca.setForeground(Color.BLACK);
            mcs.setForeground(Color.RED);
            mba.setForeground(Color.BLACK);
          
            try {
            int i = 0, n = 0, status = 0;
            String stud;
            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1]))
                        status = 1;
                }
                if (status == 0 && student[3].equals("MCS"))
                    n++;
                status = 0;
            }
            students_data = new String[n][12];
            brstudent.close();
            brplaced.close();
            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1]))
                        status = 1;
                }
                if (status == 0 && student[3].equals("MCS")) {
                    students_data[i][0] = student[0];
                    students_data[i][1] = student[1];
                    students_data[i][2] = student[2];
                    students_data[i][3] = student[3];
                    students_data[i][4] = student[4];
                    students_data[i][5] = student[5];
                    students_data[i][6] = student[6];
                    students_data[i][7] = student[7];
                    students_data[i][8] = student[8];
                    students_data[i][9] = student[9];
                    students_data[i][10] = student[10];
                    students_data[i][11] = student[11];
                    i++;
                }
                status = 0;

            }
            brstudent.close();
            brplaced.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problems during Reading the file.");
        }
        dtm = new DefaultTableModel(students_data, columns);
        t.setModel(dtm);
        

            
        }
            
        if (mba.getState() == true) {
            bcs.setForeground(Color.BLACK);
            bca.setForeground(Color.BLACK);
            mca.setForeground(Color.BLACK);
            mcs.setForeground(Color.BLACK);
            mba.setForeground(Color.RED);
          
            try {
            int i = 0, n = 0, status = 0;
            String stud;
            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1]))
                        status = 1;
                }
                if (status == 0 && student[3].equals("MBA"))
                    n++;
                status = 0;
            }
            students_data = new String[n][12];
            brstudent.close();
            brplaced.close();
            brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
            while ((stud = brstudent.readLine()) != null) {
                student = stud.split("\\$");
                brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
                while ((stud = brplaced.readLine()) != null) {
                    placed = stud.split("\\$");
                    if (student[0].equals(placed[1]))
                        status = 1;
                }
                if (status == 0 && student[3].equals("MBA")) {
                    students_data[i][0] = student[0];
                    students_data[i][1] = student[1];
                    students_data[i][2] = student[2];
                    students_data[i][3] = student[3];
                    students_data[i][4] = student[4];
                    students_data[i][5] = student[5];
                    students_data[i][6] = student[6];
                    students_data[i][7] = student[7];
                    students_data[i][8] = student[8];
                    students_data[i][9] = student[9];
                    students_data[i][10] = student[10];
                    students_data[i][11] = student[11];
                    i++;
                }
                status = 0;

            }
            brstudent.close();
            brplaced.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problems during Reading the file.");
        }
        dtm = new DefaultTableModel(students_data, columns);
        t.setModel(dtm);
        

            
            
        }
    }

}
