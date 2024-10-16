import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener{

    Choice crn;
    JComboBox cbc, cbb, cbs;
    JLabel tt;
    JButton submit, fee, cancel;

    StudentFeeForm(){
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);

        JLabel lrn = new JLabel("Select by Roll No");
        lrn.setFont(new Font("Tahoma", Font.BOLD, 16));
        lrn.setBounds(40,60,150,20);
        add(lrn);

        crn = new Choice();
        crn.setBounds(200,60,150,20);
        add(crn);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from students");
            while(rs.next()){
                crn.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(40,100,150,20);
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(name);

        JLabel tfName = new JLabel();
        tfName.setBounds(200,100,150,30);
        tfName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfName);



        JLabel fn = new JLabel("Father's Name");
        fn.setBounds(40,140,150,20);
        fn.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(fn);
        JLabel tffName = new JLabel();
        tffName.setBounds(200,140,150,20);
        tffName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tffName);


        try{
            Conn c = new Conn();
            String query = "select * from students where rollno='"+crn.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                tfName.setText(rs.getString("name"));
                tffName.setText(rs.getString("fname"));
                lrn.setText(rs.getString("rollno"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        crn.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c = new Conn();
                    String query = "select * from students where rollno='"+crn.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        tfName.setText(rs.getString("name"));
                        tffName.setText(rs.getString("fname"));
                        lrn.setText(rs.getString("rollno"));
                    }

                }catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });


        JLabel lc = new JLabel("Course");
        lc.setBounds(40,180,150,20);
        lc.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lc);
        String[] c = {"B.Teech", "BBA", "BCA", "BSC", "Msc", "MBA", "MCA", "M.Tech", "MA", "BA"};
        cbc = new JComboBox(c);
        cbc.setBounds(200,180,150,20);
        cbc.setBackground(Color.WHITE);
        add(cbc);

        JLabel lb = new JLabel("Branch");
        lb.setBounds(40,220,150,20);
        lb.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lb);
        String[] b = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT", "AR/VR", "BioTech", "Areonautics"};
        cbb = new JComboBox(b);
        cbb.setBounds(200,220,150,20);
        cbb.setBackground(Color.WHITE);
        add(cbb);


        JLabel ls = new JLabel("Semester");
        ls.setBounds(40,260,150,20);
        ls.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ls);

        String[] sem = {"semester1", "semester2", "semester3", "semester4", "semester5", "semester6", "semester7", "semester8"};
        cbs = new JComboBox(sem);
        cbs.setBounds(200,260,150,20);
        cbs.setBackground(Color.WHITE);
        add(cbs);

        JLabel total = new JLabel("Total Payable");
        total.setBounds(40,300,150,20);
        total.setFont(new Font("Roboto", Font.BOLD, 16));
        add(total);

        tt = new JLabel("");
        tt.setBounds(200,300,150,20);
        tt.setFont(new Font("Roboto", Font.PLAIN, 16));
        add(tt);


        submit = new JButton("Update");
        submit.setBounds(30,380,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        fee = new JButton("Pay Fee");
        fee.setBounds(150,380,100,25);
        fee.setBackground(Color.BLACK);
        fee.setForeground(Color.WHITE);
        fee.addActionListener(this);
        add(fee);

        cancel = new JButton("Back");
        cancel.setBounds(270,380,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==submit){
                String course = cbc.getSelectedItem().toString();
                String semester = cbs.getSelectedItem().toString();

                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from fee where course='"+course+"'");
                    while(rs.next()){
                        tt.setText(rs.getString(semester));
                    }


                }catch (Exception e){
                    e.printStackTrace();
                }


            }else if(ae.getSource()==fee){

                String rollno = crn.getSelectedItem().toString();
                String course = cbc.getSelectedItem().toString();
                String semester = cbs.getSelectedItem().toString();
                String branch = cbb.getSelectedItem().toString();
                String total = tt.getText();

                try{
                    Conn c = new Conn();
                    String query = "insert into studentfee values('"+rollno+"', '"+course+"', '"+branch+"', '"+semester+"', '"+total+"')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Fee Submitted successfully");


                }catch (Exception e){
                    e.printStackTrace();
                }

            }else if(ae.getSource()==cancel){
                setVisible(false);
            }
    }

    public static void main(String[] args){
        new StudentFeeForm();
    }
}
