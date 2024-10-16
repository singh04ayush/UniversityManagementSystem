
import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    Conn(){
        try{
            //make changes according to your database. Below all should contain your details else won't work
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","your username","yourpassword");
            s = c.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
