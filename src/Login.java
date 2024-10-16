import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton loginB, cancel;
    JTextField tfusername, tfpassword;

    Login(){

        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.cyan);
        usernameLabel.setFont(new Font("Roboto", Font.BOLD, 20));
        usernameLabel.setBounds(40,20,100,20);
        add(usernameLabel);

        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40,70,100,20);
        passwordLabel.setForeground(Color.cyan);
        passwordLabel.setFont(new Font("Roboto", Font.BOLD, 20));
        add(passwordLabel);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);

        loginB = new JButton("Login");
        loginB.setBounds(40,140,120,30);
        loginB.setBackground(Color.BLACK);
        loginB.setForeground(Color.CYAN);
        loginB.addActionListener(this);
        loginB.setFont(new Font("Roboto",Font.BOLD,18));
        add(loginB);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.CYAN);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Roboto",Font.BOLD,18));
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,175);
        add(image);

        setSize(600,300);
        setLocation(500, 250);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==loginB){
            String username = tfusername.getText();
            String password = tfpassword.getText();

            String query = "Select * from login where username='"+username+"' and password='"+password+"'";

            try{
                Conn c = new Conn();
                ResultSet  rs = c.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Project();
                } else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
                c.s.close();

            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
