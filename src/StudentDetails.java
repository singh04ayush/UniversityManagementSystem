
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener {

    Choice crn;
    JTable table;
    JButton search, print, update, add, cancel;

    StudentDetails(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Roll Number");
        heading.setFont(new Font("Roboto", Font.BOLD, 12));
        heading.setBounds(20,20,150,20);
        add(heading);

        crn = new Choice();
        crn.setBounds(180,20,150,20);
        add(crn);

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from students");
            while(rs.next()){
                crn.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from students");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }


        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,650);
        add(jsp);


        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        add= new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Search");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "select * from students where rollno='"+crn.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == print){
            try{
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == add){
            setVisible(false);
            new AddStudent();
        }else if(ae.getSource() == update){
            setVisible(false);
            new UpdateStudent();
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}
