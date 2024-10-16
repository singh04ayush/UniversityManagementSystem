
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;



public class TeacherDetails extends JFrame implements ActionListener {

    Choice cempid;
    JTable table;
    JButton search, print, update, add, cancel;


    TeacherDetails(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Employee ID");
        heading.setFont(new Font("Roboto", Font.BOLD, 12));
        heading.setBounds(20,20,150,20);
        add(heading);

        cempid = new Choice();
        cempid.setBounds(180,20,150,20);
        add(cempid);

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teachers");
            while(rs.next()){
                cempid.add(rs.getString("empid"));
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

        cancel = new JButton("Search");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "select * from teachers where empid='"+ cempid.getSelectedItem()+"'";
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
            new AddTeacher();
        }else if(ae.getSource() == update){
            setVisible(false);
            new UpdateTeacher();
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }



    public static void main(String[] args) {
        new TeacherDetails();
    }
}
