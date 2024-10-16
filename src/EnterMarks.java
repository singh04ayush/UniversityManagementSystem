import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {

    Choice crn;
    JButton submit, cancel;
    JComboBox cbs;
    JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5, tfmarks1, tfmarks2, tfmarks3, tfmarks4, tfmarks5;

    EnterMarks(){

        setSize(1000,500);
        setLocation(300, 150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 400, 300);
        add(image);


        JLabel heading = new JLabel("Enter Marks of Stduent");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("Roboto", Font.BOLD, 20));
        add(heading);

        JLabel lrn = new JLabel("Select Roll Number");
        lrn.setBounds(50,70,150,20);
        add(lrn);


        crn = new Choice();
        crn.setBounds(200,70,150,20);
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



        JLabel ls = new JLabel("Select Semester");
        ls.setBounds(50,110,150,20);
        add(ls);

        String[] sem = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"};
        cbs = new JComboBox(sem);
        cbs.setBounds(200,110,150,20);
        cbs.setBackground(Color.WHITE);
        add(cbs);


        JLabel les = new JLabel("Enter Subject");
        les.setBounds(100,150,200,40);
        add(les);

        JLabel lem = new JLabel("Enter Marks");
        lem.setBounds(320,150,200,40);
        add(lem);

        tfsub1 = new JTextField();
        tfsub1.setBounds(50,200,200,20);
        add(tfsub1);

        tfsub2 = new JTextField();
        tfsub2.setBounds(50,230,200,20);
        add(tfsub2);

        tfsub3 = new JTextField();
        tfsub3.setBounds(50,260,200,20);
        add(tfsub3);

        tfsub4 = new JTextField();
        tfsub4.setBounds(50,290,200,20);
        add(tfsub4);

        tfsub5 = new JTextField();
        tfsub5.setBounds(50,320,200,20);
        add(tfsub5);

        tfmarks1 = new JTextField();
        tfmarks1.setBounds(260,200,200,20);
        add(tfmarks1);

        tfmarks2 = new JTextField();
        tfmarks2.setBounds(260,230,200,20);
        add(tfmarks2);

        tfmarks3 = new JTextField();
        tfmarks3.setBounds(260,260,200,20);
        add(tfmarks3);

        tfmarks4 = new JTextField();
        tfmarks4.setBounds(260,290,200,20);
        add(tfmarks4);

        tfmarks5 = new JTextField();
        tfmarks5.setBounds(260,320,200,20);
        add(tfmarks5);

        submit = new JButton("Submit");
        submit.setBounds(70,360,150,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Roboto",Font.BOLD,18));
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(280,360,150,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Roboto",Font.BOLD,18));
        add(cancel);

        setVisible(true);
    }




    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                Conn c = new Conn();
                String query1 = "insert into subject values('"+crn.getSelectedItem()+"', '"+cbs.getSelectedItem()+"', '"+tfsub1.getText()+"', '"+tfsub2.getText()+"', '"+tfsub3.getText()+"', '"+tfsub4.getText()+"', '"+tfsub5.getText()+"')";
                String query2 = "insert into marks values('"+crn.getSelectedItem()+"', '"+cbs.getSelectedItem()+"', '"+tfmarks1.getText()+"', '"+tfmarks2.getText()+"', '"+tfmarks3.getText()+"', '"+tfmarks4.getText()+"', '"+tfmarks5.getText()+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Marks Submitted successfully");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}
