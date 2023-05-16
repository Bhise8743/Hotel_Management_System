
package hotel.management;
import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{ //Third Frame

    
	JTextField textField,textField_0,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
        JComboBox c1;
        JRadioButton male,Female;

        public AddEmployee(){
//            getContentPane().setForeground(Color.MAGENTA);
//            getContentPane().setBackground(Color.WHITE);
//            setTitle("ADD EMPLOYEE DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//            setSize(778,486);
//            setBounds(275,100,900,550);
            getContentPane().setLayout(null);
            
            JLabel employeeId = new JLabel("eId");
            employeeId.setFont(new Font("Tahoma", Font.PLAIN, 17));
            employeeId.setBounds(60, 10, 150, 27);
            add(employeeId);
            
            textField_0 = new JTextField();
            textField_0.setBounds(200, 10, 150, 27);
            add(textField_0);
			
            JLabel ename = new JLabel("NAME");
            ename.setFont(new Font("Tahoma", Font.PLAIN, 17));
            ename.setBounds(60, 50, 150, 27);
            add(ename);
            
            textField = new JTextField();
            textField.setBounds(200, 50, 150, 27);
            add(textField);
			
            
			
            JLabel eage = new JLabel("AGE");
            eage.setFont(new Font("Tahoma", Font.PLAIN, 17));
            eage.setBounds(60, 90, 150, 27);
            add(eage);
			
            textField_1 = new JTextField();
            textField_1.setBounds(200, 90, 150, 27);
            add(textField_1);
            
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 130, 150, 27);
            add(Gender);
		
            male = new JRadioButton("MALE");
            male.setBackground(Color.WHITE);
            male.setFont(new Font("Tahoma", Font.PLAIN, 12));
            male.setBounds(200, 130, 70, 27);
            add(male);
	
            Female = new JRadioButton("FEMALE");
            Female.setBackground(Color.WHITE);
            Female.setFont(new Font("Tahoma", Font.PLAIN, 12));
            Female.setBounds(270, 130, 70, 27);
            add(Female);
            
            
            JLabel Address = new JLabel("JOB");
            Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Address.setBounds(60, 180, 150, 27);
            add(Address);
			
            String course[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE);
            c1.setBounds(200,180,150,30);
            add(c1);
            		
            JLabel Nationality = new JLabel("SALARY");
            Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Nationality.setBounds(60, 230, 150, 27);
            add(Nationality);
			
            textField_3 = new JTextField();
            textField_3.setBounds(200, 230, 150, 27);
            add(textField_3);
	
            JLabel Name = new JLabel("PHONE");
            Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Name.setBounds(60, 280, 150, 27);
            add(Name);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200, 290, 150, 27);
            add(textField_4);
	
            JLabel Phno = new JLabel("AADHAR");
            Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Phno.setBounds(60, 330, 150, 27);
            add(Phno);
			
            textField_5 = new JTextField();
            textField_5.setBounds(200, 330, 150, 27);
            add(textField_5);
	
            
            JLabel email = new JLabel("EMAIL");
            email.setFont(new Font("Tahoma", Font.PLAIN, 17));
            email.setBounds(60, 380, 150, 27);
            add(email);
			
            textField_6 = new JTextField();
            textField_6.setBounds(200, 380, 150, 27);
            add(textField_6);
	
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 430, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            Next.addActionListener(this);
            add(Next);
            
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(450, 24, 442, 35);
            add(AddPassengers);
			
     
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Copy of tenth.jpg"));
            Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(410,80,450,410);
            add(image);

            setSize(900,550);
            setVisible(true);
            setLocation(275,100);
         }   
                public void actionPerformed(ActionEvent ae){
                    String name = textField.getText();
                    
// 
                    String age = textField_1.getText();
                    String salary = textField_3.getText();
                    String phone="";
                    String aadhar="";
                    if(textField_4.getText().length()>10){
                        JOptionPane.showMessageDialog(null,"Phone number is not more than 10!!");
                    }else{
                        phone = textField_4.getText();
                    }
                    if(textField_5.getText().length()>10){
                        JOptionPane.showMessageDialog(null,"aadhar number is not more than 12!!");
                    }else{
                        aadhar = textField_5.getText();
                    }
                    //.length()>10?JOptionPane.showMessageDialog(null,"Employee Added"):textField_4.getText();
//                     = textField_5.getText();
                    String email = textField_6.getText();
                    String employeeId = textField_0.getText();
                   
                    String gender = null;
                    
                    if(male.isSelected()){
                        gender = "male";
                    
                    }else if(Female.isSelected()){
                        gender = "female";
                    }

                            
                    String s6 = (String)c1.getSelectedItem();
                    
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+s6+"', '"+salary+"', '"+phone+"','"+email+"', '"+aadhar+"','"+employeeId+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Employee Added");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}        
    public static void main(String[] args){
        new AddEmployee();
    }   
}