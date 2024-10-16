
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateTeacher extends JFrame implements ActionListener {

    JLabel fn,lad, lp, lx,lxii, dob, dcdob, rn, name, heading, lrn,la,lb,lc, tfName, tffName, tfx, tfxii, tfad;
    JTextField tfadd,tfp,tfm,cbc,cbb;

    JButton submit, cancel;
    Choice cempid;
    UpdateTeacher(){
        setSize(900, 650);
        setLocation(350,50);
        setLayout(null);

        heading = new JLabel("Update Teacher Information");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Roboto", Font.ITALIC, 35));
        add(heading);

        lrn = new JLabel("Select Employee ID");
        lrn.setFont(new Font("Roboto", Font.PLAIN, 20));
        lrn.setBounds(50,100,200,20);
        add(lrn);

        cempid = new Choice();
        cempid.setBounds(250,100,200,20);
        add(cempid);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teachers");
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);
        tfName = new JLabel();
        tfName.setBounds(200,150,150,30);
        add(tfName);



        fn = new JLabel("father's Name");
        fn.setBounds(400,150,200,30);
        fn.setFont(new Font("serif", Font.BOLD, 20));
        add(fn);
        tffName = new JLabel();
        tffName.setBounds(600,150,150,30);
        add(tffName);

        rn = new JLabel("Employee ID");
        rn.setBounds(50,200,200,30);
        rn.setFont(new Font("serif", Font.BOLD, 20));
        add(rn);

        lrn = new JLabel();
        lrn.setBounds(200,200,200,30);
        lrn.setFont(new Font("serif", Font.BOLD, 20));
        add(lrn);

        dob = new JLabel("Date Of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        dcdob = new JLabel();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);

        lad = new JLabel("Address");
        lad.setBounds(50,250,200,30);
        lad.setFont(new Font("serif", Font.BOLD, 20));
        add(lad);
        tfadd = new JTextField();
        tfadd.setBounds(200,250,150,30);
        add(tfadd);

        lp = new JLabel("Mobile No");
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

        lx = new JLabel("Class X (%)");
        lx.setBounds(400,300,200,30);
        lx.setFont(new Font("serif", Font.BOLD, 20));
        add(lx);
        tfx = new JLabel();
        tfx.setBounds(600,300,150,30);
        add(tfx);

        lxii = new JLabel("Class XII (%)");
        lxii.setBounds(50,350,200,30);
        lxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lxii);
        tfxii = new JLabel();
        tfxii.setBounds(200,350,150,30);
        add(tfxii);

        la = new JLabel("Aadhar Number");
        la.setBounds(400,350,200,30);
        la.setFont(new Font("serif", Font.BOLD, 20));
        add(la);
        tfad = new JLabel();
        tfad.setBounds(600,350,150,30);
        add(tfad);

        lc = new JLabel("Qualification");
        lc.setBounds(50,400,200,30);
        lc.setFont(new Font("serif", Font.BOLD, 20));
        add(lc);
        cbc = new JTextField();
        cbc.setBounds(200,400,150,30);
        add(cbc);

        lb = new JLabel("Department");
        lb.setBounds(400,400,200,30);
        lb.setFont(new Font("serif", Font.BOLD, 20));
        add(lb);
        cbb = new JTextField();
        cbb.setBounds(600,400,150,30);
        add(cbb);

        try{
            Conn c = new Conn();
            String query = "select * from teachers where empid='"+ cempid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                tfName.setText(rs.getString("name"));
                tffName.setText(rs.getString("fname"));
                lrn.setText(rs.getString("empid"));
                dcdob.setText(rs.getString("dob"));
                tfadd.setText(rs.getString("address"));
                tfp.setText(rs.getString("mobile"));
                tfm.setText(rs.getString("email"));
                tfx.setText(rs.getString("high"));
                tfxii.setText(rs.getString("senior"));
                tfad.setText(rs.getString("aadhar"));
                cbc.setText(rs.getString("qualification"));
                cbb.setText(rs.getString("department"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        cempid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c = new Conn();
                    String query = "select * from teachers where empid='"+ cempid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        tfName.setText(rs.getString("name"));
                        tffName.setText(rs.getString("fname"));
                        lrn.setText(rs.getString("empid"));
                        dcdob.setText(rs.getString("dob"));
                        tfadd.setText(rs.getString("address"));
                        tfp.setText(rs.getString("mobile"));
                        tfm.setText(rs.getString("email"));
                        tfx.setText(rs.getString("high"));
                        tfxii.setText(rs.getString("senior"));
                        tfad.setText(rs.getString("aadhar"));
                        cbc.setText(rs.getString("qualification"));
                        cbb.setText(rs.getString("department"));

                    }

                }catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
        submit.setBounds(250,500,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Roboto",Font.BOLD,18));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Roboto",Font.BOLD,18));
        add(cancel);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String rollno = lrn.getText();
            String address = tfadd.getText();
            String mobile = tfp.getText();
            String email = tfm.getText();
            String course = cbc.getText();
            String branch = cbb.getText();

            try{
                String query = "UPDATE students SET "
                        + "address = '" + address + "', "
                        + "mobile = '" + mobile + "', "
                        + "email = '" + email + "', "
                        + "course = '" + course + "', "
                        + "branch = '" + branch + "' "
                        + "WHERE rollno = '" + rollno + "'";

                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Details Update Successfuly");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }

        } else  {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }
}
