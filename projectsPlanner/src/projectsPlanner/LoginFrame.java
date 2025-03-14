package projectsPlanner;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener{
	 JLabel userLabel;
	 JButton connectButton;
	 JTextField username;
    public LoginFrame() {
        setTitle("Project Planner - Login or Sign Up");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        
        JPanel pan = new JPanel();
        pan.setLayout(new GridBagLayout());
        pan.setBackground(new Color(0x123456));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Log in or Sign up");
        titleLabel.setForeground(new Color(255, 192, 0)); 
        titleLabel.setFont(new Font("MV Boli", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        pan.add(titleLabel, gbc);

        
        userLabel = new JLabel("Username:");
        userLabel.setForeground(new Color(255, 192, 0)); 
        userLabel.setFont(new Font("MV Boli", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 1;
        pan.add(userLabel, gbc);

        username = new JTextField(15);
        username.setBackground(Color.WHITE);
        gbc.gridx = 1; gbc.gridy = 1;
        pan.add(username, gbc);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(new Color(255, 192, 0)); 
        passLabel.setFont(new Font("MV Boli", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 2;
        pan.add(passLabel, gbc);

        JPasswordField password = new JPasswordField(15);
        password.setBackground(Color.WHITE);
        gbc.gridx = 1; gbc.gridy = 2;
        pan.add(password, gbc);

        connectButton = new JButton("Connect");
        connectButton.setBackground(new Color(255, 192, 0));
        connectButton.setForeground(Color.BLACK);
        connectButton.setFocusable(false);
        connectButton.addActionListener(this);
        gbc.gridx = 0; gbc.gridy = 3; 
        gbc.gridwidth = 2;
        pan.add(connectButton, gbc);

        add(pan);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==connectButton){
			 String usrN = username.getText();
		 new WelcomeFrame(usrN);
		 }
		 else {System.out.println("Error connecting");}
	}
    

  
}

