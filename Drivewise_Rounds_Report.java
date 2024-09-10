
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Drivewise_Rounds_Report extends JFrame implements ActionListener {
    Label ltitle;
    Button butback;
    BufferedReader br;
    String students_data[][];
    String s[];
    JTable t;
    JScrollPane jp;
    JFrame f = new JFrame();
    TextArea ta = new TextArea();

    Drivewise_Rounds_Report() {
        setSize(1920, 1080);
        setLayout(null);
        setVisible(true);
        setTitle("Conducted Rounds Report.");
        setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ltitle = new Label("Drivewise Conducted Rounds Information Report.");

        butback = new Button("Close");
        butback.addActionListener(this);

        Font f1 = new Font("arial black", Font.BOLD, 34);
        Font f2 = new Font("times new roman", Font.BOLD, 28);

        ltitle.setFont(f1);
        ltitle.setForeground(Color.RED);
        butback.setFont(f2);

        try {
            int i = 0, n = 0;
            br = new BufferedReader(new FileReader("Drivewise_Rounds.txt"));
            String stud;
            while ((stud = br.readLine()) != null) {
                n++;
            }
            br.close();
            br = new BufferedReader(new FileReader("Drivewise_Rounds.txt"));

            students_data = new String[n][6];
            while ((stud = br.readLine()) != null) {
                s = stud.split("\\$");
                students_data[i][0] = s[0];
                students_data[i][1] = s[1];
                students_data[i][2] = s[2];
                students_data[i][3] = s[3];
                students_data[i][4] = s[4];
                students_data[i][5] = s[5];
                i++;
            }
            br.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Problems during Reading the file.");
        }

        String columns[] = { "Drive ID Number",
                "Round Number",
                "Round Title",
                "Tested Skills",
                "No. of Students Qualified",
                "Qualified Student's PRN"
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
                        "Selected Drives Detail" +
                                "\n----------------------------------------------------" +
                                "\nDrive ID Number : " + students_data[row][0] +
                                "\nRound Number : " + students_data[row][1] +
                                "\nRound Title : " + students_data[row][2] +
                                "\nTested Skills : " + students_data[row][3] +
                                "\nNo. of Students Qualified : " + students_data[row][4] +
                                "\nQualified Student's PRN : " + students_data[row][5]);

                ta.setFont(f2);
                ta.setEditable(false);
                f.add(ta);

            }
        });
        jp = new JScrollPane(t);

        add(ltitle);
        add(jp);
        add(butback);

        ltitle.setBounds(400, 30, 820, 40);
        jp.setBounds(40, 100, 1460, 550);
        butback.setBounds(700, 700, 100, 40);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butback)
            dispose();
        f.dispose();

    }

}
