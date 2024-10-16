import javax.swing.*;
import java.awt.*;

public class About extends JFrame {


    public About() {

        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(Color.white);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,300,200);
        add(image);

        JLabel heading = new JLabel("<html>University<br>Management System</html>");
        heading.setBounds(70,20,300,130);
        heading.setFont(new Font("Roboto", Font.BOLD, 24));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel name = new JLabel("Developed by Ayush Singh and Bhaskar Srivastava");
        name.setBounds(40,220,550,40);
        name.setFont(new Font("Roboto", Font.BOLD, 20));
        name.setForeground(Color.GRAY);
        add(name);


        JLabel em = new JLabel("Contact Us: 2023505161.ayush@ug.sharda.ac.in");
        em.setBounds(70,260,550,40);
        em.setFont(new Font("Roboto", Font.ITALIC, 18));
        em.setForeground(Color.pink);
        add(em);

        JLabel em2 = new JLabel("Contact Us: 2023754130.bhaskar@ug.sharda.ac.in");
        em2.setBounds(70,290,550,40);
        em2.setFont(new Font("Roboto", Font.ITALIC, 18));
        em2.setForeground(Color.pink);
        add(em2);


        JLabel logo = new JLabel("SHARDA UNIVERSITY");
        logo.setBounds(200,350,500,150);
        logo.setFont(new Font("Roboto", Font.BOLD, 25));
        logo.setForeground(Color.BLUE);
        add(logo);




        setLayout(null);
        setVisible(true);


    }
    public static void main(String[] args) {
        new About();
    }
}
