
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
public class AddStudent extends JFrame implements ActionListener {

    JTextField tfName, tffName, tfadd, tfp, tfm, tfx, tfxii, tfad;
    JLabel lrn;
    JDateChooser dcdob;
    JComboBox cbc, cbb;
    JButton submit, cancel;
    Random ran  = new Random();
    long f4 = Math.abs((ran.nextLong()%9000L)+1000L);

    AddStudent(){
        setSize(900, 700);
        setLocation(350,50);
        setLayout(null);

        JLabel heading = new JLabel("New Student Information");
        heading.setBounds(300,30,500,50);
        heading.setFont(new Font("Roboto", Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);
        tfName = new JTextField();
        tfName.setBounds(200,150,150,30);
        add(tfName);


        JLabel fn = new JLabel("father's Name");
        fn.setBounds(400,150,200,30);
        fn.setFont(new Font("serif", Font.BOLD, 20));
        add(fn);
        tffName = new JTextField();
        tffName.setBounds(600,150,150,30);
        add(tffName);

        JLabel rn = new JLabel("Roll No");
        rn.setBounds(50,200,200,30);
        rn.setFont(new Font("serif", Font.BOLD, 20));
        add(rn);

        lrn = new JLabel("202350"+f4);
        lrn.setBounds(200,200,200,30);
        lrn.setFont(new Font("serif", Font.BOLD, 20));
        add(lrn);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);

        JLabel lad = new JLabel("Address");
        lad.setBounds(50,250,200,30);
        lad.setFont(new Font("serif", Font.BOLD, 20));
        add(lad);
        tfadd = new JTextField();
        tfadd.setBounds(200,250,150,30);
        add(tfadd);

        JLabel lp = new JLabel("Mobile No");
        lp.setBounds(400,250,200,30);
        lp.setFont(new Font("serif", Font.BOLD, 20));
        add(lp);
        tfp = new JTextField();
        tfp.setBounds(600,250,150,30);
        add(tfp);

        JLabel ei = new JLabel("Email Id");
        ei.setBounds(50,300,200,30);
        ei.setFont(new Font("serif", Font.BOLD, 20));
        add(ei);
        tfm = new JTextField();
        tfm.setBounds(200,300,150,30);
        add(tfm);

        JLabel lx = new JLabel("Class X (%)");
        lx.setBounds(400,300,200,30);
        lx.setFont(new Font("serif", Font.BOLD, 20));
        add(lx);
        tfx = new JTextField();
        tfx.setBounds(600,300,150,30);
        add(tfx);

        JLabel lxii = new JLabel("Class XII (%)");
        lxii.setBounds(50,350,200,30);
        lxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lxii);
        tfxii = new JTextField();
        tfxii.setBounds(200,350,150,30);
        add(tfxii);

        JLabel la = new JLabel("Aadhar Number");
        la.setBounds(400,350,200,30);
        la.setFont(new Font("serif", Font.BOLD, 20));
        add(la);
        tfad = new JTextField();
        tfad.setBounds(600,350,150,30);
        add(tfad);

        JLabel lc = new JLabel("Choose Course");
        lc.setBounds(50,400,200,30);
        lc.setFont(new Font("serif", Font.BOLD, 20));
        add(lc);
        String[] c = {"B.Tech", "BBA", "BCA", "BSC", "Msc", "MBA", "MCA", "M.Tech", "MA", "BA"};
        cbc = new JComboBox(c);
        cbc.setBounds(200,400,150,30);
        cbc.setBackground(Color.WHITE);
        add(cbc);

        JLabel lb = new JLabel("Choose Branch");
        lb.setBounds(400,400,200,30);
        lb.setFont(new Font("serif", Font.BOLD, 20));
        add(lb);
        String[] b = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT", "AR/VR", "BioTech", "Areonautics"};
        cbb = new JComboBox(b);
        cbb.setBounds(600,400,150,30);
        cbb.setBackground(Color.WHITE);
        add(cbb);

        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Roboto",Font.BOLD,18));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Roboto",Font.BOLD,18));
        add(cancel);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String name = tfName.getText();
            String fname = tffName.getText();
            String rollno = lrn.getText();
            String dob =((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfadd.getText();
            String mobile = tfp.getText();
            String email = tfm.getText();
            String high = tfx.getText();
            String senior = tfxii.getText();
            String aadhar = tfad.getText();
            String course = (String) cbc.getSelectedItem();
            String branch = (String) cbb.getSelectedItem();

            try{
                String query = "INSERT INTO students (name, fname, rollno, dob, address, mobile, email, high, senior, aadhar, course, branch) VALUES ('"
                        + name + "', '"
                        + fname + "', '"
                        + rollno + "', '"
                        + dob + "', '"
                        + address + "', '"
                        + mobile + "', '"
                        + email + "', '"
                        + high + "', '"
                        + senior + "', '"
                        + aadhar + "', '"
                        + course + "', '"
                        + branch + "')";
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "details Inserted Successfuly");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }

        } else  {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
