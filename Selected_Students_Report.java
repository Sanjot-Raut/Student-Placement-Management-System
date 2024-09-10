
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Selected_Students_Report extends JFrame implements ActionListener {
    Label ltitle;
    Button butback;
    BufferedReader brplaced, brstudent, brdrive;
    String students_data[][];
    String placed[], student[], drive[];
    JTable t;
    JScrollPane jp;
    JFrame f = new JFrame();
    TextArea ta = new TextArea();

    Selected_Students_Report() {
        setSize(1920, 1080);
        setLayout(null);
        setVisible(true);
        setTitle("Selected Students Report.");
        setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ltitle = new Label("Selected Students Placement Information Report.");

        butback = new Button("Close");
        butback.addActionListener(this);

        Font f1 = new Font("arial black", Font.BOLD, 34);
        Font f2 = new Font("times new roman", Font.BOLD, 28);

        ltitle.setFont(f1);
        ltitle.setForeground(Color.RED);
        butback.setFont(f2);

        try {
            int i = 0, n = 0;
            brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));
            String stud;
            while ((stud = brplaced.readLine()) != null) {
                n++;
            }
            students_data = new String[n][9];
            brplaced.close();
            brplaced = new BufferedReader(new FileReader("Selected_Students.txt"));

            while ((stud = brplaced.readLine()) != null) {
                placed = stud.split("\\$");
                students_data[i][0] = placed[0];
                students_data[i][3] = placed[1];

                brdrive = new BufferedReader(new FileReader("Conducted_Drives.txt"));
                while ((stud = brdrive.readLine()) != null) {
                    drive = stud.split("\\$");
                    if (placed[0].equals(drive[0])) {
                        students_data[i][1] = drive[1];
                        students_data[i][2] = drive[2];
                    }
                }
                brstudent = new BufferedReader(new FileReader("Student_Reg.txt"));
                while ((stud = brstudent.readLine()) != null) {
                    student = stud.split("\\$");
                    if (placed[1].equals(student[0])) {
                        students_data[i][4] = student[1];
                        students_data[i][5] = student[2];
                        students_data[i][6] = student[3];
                        students_data[i][7] = student[4];
                        students_data[i][8] = student[5];
                    }

                }

                i++;
            }
            brdrive.close();
            brplaced.close();
            brstudent.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problems during Reading the file.");
        }

        String columns[] = { "Drive ID Number",
                "Drive Conduct Date",
                "Drive Type", "Students PRN", "Students Name", "Batch Year", "Course", "Division", "Roll No."
        };
        t = new JTable(students_data, columns);
        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                f.setVisible(true);
                f.setSize(500, 500);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                int row = t.rowAtPoint(e.getPoint());
                ta.setText(
                        "Selected Placed Student's  Detail" +
                                "\n----------------------------------------------------" +
                                "\nDrive ID Number : " + students_data[row][0] +
                                "\nDrive Conduct Date : " + students_data[row][1] +
                                "\nDrive Type : " + students_data[row][2] +
                                "\nStudents PRN : " + students_data[row][3] +
                                "\nStudents Name : " + students_data[row][4] +
                                "\nBatch Year : " + students_data[row][5] +
                                "\nCourse : " + students_data[row][6] +
                                "\nDivision : " + students_data[row][7] +
                                "\nRoll No. : " + students_data[row][8]);

                ta.setFont(f2);
                ta.setEditable(false);
                f.add(ta);

            }
        });
        jp = new JScrollPane(t);

        add(ltitle);
        add(jp);
        add(butback);

        ltitle.setBounds(400, 30, 810, 40);
        jp.setBounds(40, 100, 1460, 550);
        butback.setBounds(700, 700, 100, 40);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butback)
            dispose();
        f.dispose();

    }

}
