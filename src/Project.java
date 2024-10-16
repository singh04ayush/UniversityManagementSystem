import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    Project(){
        setSize(1500, 940);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/one.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();

        JMenu ni = new JMenu("New Information");
        ni.setForeground(Color.GRAY);
        mb.add(ni);
        JMenuItem fi = new JMenuItem("New Faculty Information");
        fi.setForeground(Color.GRAY);
        fi.setBackground(Color.WHITE);
        fi.addActionListener(this);
        ni.add(fi);
        JMenuItem si = new JMenuItem("New Student Information");
        si.setForeground(Color.GRAY);
        si.setBackground(Color.WHITE);
        si.addActionListener(this);
        ni.add(si);

        JMenu details = new JMenu("View Details");
        details.setForeground(Color.GRAY);
        mb.add(details);
        JMenuItem fd = new JMenuItem("View Faculty Details");
        fd.setForeground(Color.GRAY);
        fd.setBackground(Color.WHITE);
        fd.addActionListener(this);
        details.add(fd);
        JMenuItem sd = new JMenuItem("View Student Details");
        sd.setForeground(Color.GRAY);
        sd.setBackground(Color.WHITE);
        sd.addActionListener(this);
        details.add(sd);

        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.RED);
        mb.add(leave);
        JMenuItem fl = new JMenuItem("Faculty Leave");
        fl.setForeground(Color.GRAY);
        fl.setBackground(Color.WHITE);
        fl.addActionListener(this);
        leave.add(fl);
        JMenuItem sl = new JMenuItem("Student Leave");
        sl.setForeground(Color.GRAY);
        sl.setBackground(Color.WHITE);
        sl.addActionListener(this);
        leave.add(sl);

        JMenu ld = new JMenu("Leave Details");
        ld.setForeground(Color.GRAY);
        mb.add(ld);
        JMenuItem fld = new JMenuItem("Faculty Leave Details");
        fld.setForeground(Color.GRAY);
        fld.setBackground(Color.WHITE);
        fld.addActionListener(this);
        ld.add(fld);
        JMenuItem sld = new JMenuItem("Student Leave details");
        sld.setForeground(Color.GRAY);
        sld.setBackground(Color.WHITE);
        sld.addActionListener(this);
        ld.add(sld);

        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.GRAY);
        mb.add(exam);
        JMenuItem ed = new JMenuItem("Examinations Results");
        ed.setForeground(Color.GRAY);
        ed.setBackground(Color.WHITE);
        ed.addActionListener(this);
        exam.add(ed);
        JMenuItem em = new JMenuItem("Enter Student Marks");
        em.setForeground(Color.GRAY);
        em.setBackground(Color.WHITE);
        em.addActionListener(this);
        exam.add(em);

        JMenu ui = new JMenu("Update Info");
        ui.setForeground(Color.BLUE);
        mb.add(ui);
        JMenuItem ufi = new JMenuItem("Update Faculty");
        ufi.setForeground(Color.GRAY);
        ufi.setBackground(Color.WHITE);
        ufi.addActionListener(this);
        ui.add(ufi);
        JMenuItem usi = new JMenuItem("Update Student");
        usi.setForeground(Color.GRAY);
        usi.setBackground(Color.WHITE);
        usi.addActionListener(this);
        ui.add(usi);

        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.GRAY);
        mb.add(fee);
        JMenuItem fs = new JMenuItem("Fee Structure");
        fs.setForeground(Color.GRAY);
        fs.setBackground(Color.WHITE);
        fs.addActionListener(this);
        fee.add(fs);
        JMenuItem ff = new JMenuItem("Student Fee Form");
        ff.setForeground(Color.GRAY);
        ff.setBackground(Color.WHITE);
        ff.addActionListener(this);
        fee.add(ff);

        JMenu u = new JMenu("Utility");
        u.setForeground(Color.BLUE);
        mb.add(u);
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setForeground(Color.GRAY);
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        u.add(calc);
        JMenuItem np = new JMenuItem("Notepad");
        np.setForeground(Color.GRAY);
        np.setBackground(Color.WHITE);
        np.addActionListener(this);
        u.add(np);

        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);
        JMenuItem ab = new JMenuItem("About");
        ab.setForeground(Color.GRAY);
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);


        JMenu ex = new JMenu("Exit");
        ex.setForeground(Color.RED);
        mb.add(ex);
        JMenuItem exit = new JMenuItem("Logout");
        exit.setForeground(Color.GRAY);
        exit.setBackground(Color.WHITE);
        exit.addActionListener(this);
        ex.add(exit);

        setJMenuBar(mb);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();

        if(msg.equals("Logout")){
            setVisible(false);
        } else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e){}
        } else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e){}
        } else if(msg.equals("New Faculty Information")){
            new AddTeacher();
        } else if(msg.equals("New Student Information")){
            new AddStudent();
        }else if(msg.equals("View Faculty Details")) {
            new TeacherDetails();
        }else if(msg.equals("View Student Details")) {
            new StudentDetails();
        } else if(msg.equals("Faculty Leave")){
            new Teacherleave();
        }else if(msg.equals("Student Leave")){
            new StudentLeave();
        } else if(msg.equals("Faculty Leave Details")){
            new Teacherleavedetails();
        }else if(msg.equals("Student Leave details")){
            new Studentleavedetails();
        }else if(msg.equals("Update Faculty")){
            new UpdateTeacher();
        }else if(msg.equals("Update Student")){
            new UpdateStudent();
        }else if(msg.equals("Enter Student Marks")){
            new EnterMarks();
        }else if(msg.equals("Examinations Results")){
            new ExaminationDetails();
        }else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }else if(msg.equals("About")){
            new About();
        } else if (msg.equals("Student Fee Form")) {
            new StudentFeeForm();

        }
    }

    public static void main(String[] args) {
        new Project();
    }
}
