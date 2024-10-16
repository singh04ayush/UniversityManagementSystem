import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Teacherleave extends JFrame implements ActionListener {

    Choice cempid, ct;
    JDateChooser dcdob;
    JButton submit, cancel;
    Teacherleave(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Apply Faculty Leave");
        heading.setBounds(20,50,300,30);
        heading.setFont(new Font("Roboto",Font.BOLD,20));
        add(heading);

        JLabel lrn = new JLabel("Search by Employee Id");
        lrn.setFont(new Font("Roboto", Font.PLAIN, 18));
        lrn.setBounds(60,100,200,20);
        add(lrn);

        cempid = new Choice();
        cempid.setBounds(60,130,200,20);
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


        JLabel ld = new JLabel("Date");
        ld.setFont(new Font("Roboto", Font.PLAIN, 18));
        ld.setBounds(60,180,200,20);
        add(ld);

        dcdob = new JDateChooser();
        dcdob.setBounds(60,210,200,25);
        add(dcdob);

        JLabel lt = new JLabel("Time Duration");
        lt.setFont(new Font("Roboto", Font.PLAIN, 18));
        lt.setBounds(60,260,200,20);
        add(lt);

        ct = new Choice();
        ct.setBounds(60,290,200,20);
        ct.add("Half Day");
        ct.add("Full Day");
        add(ct);

        submit = new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Roboto",Font.BOLD,18));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Roboto",Font.BOLD,18));
        add(cancel);

        setSize(500,550);
        setLocation(550,100);
        setVisible(true);
    }



    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String rollno = cempid.getSelectedItem();
            String date = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String duration = ct.getSelectedItem();

            String query = "insert into Teacherleave values('"+rollno+"','"+date+"','"+duration+"')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Faculty Leave Confirmed");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new Teacherleave();
    }
}
