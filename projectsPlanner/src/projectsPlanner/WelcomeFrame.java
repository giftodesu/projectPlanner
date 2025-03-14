package projectsPlanner;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class WelcomeFrame extends JFrame implements ActionListener{
    ImageIcon icn = new ImageIcon("1501772.png");
    JTextField title = new JTextField();
    JTextArea description = new JTextArea();
    JButton submit;
    public WelcomeFrame(String userName) {
        this.setSize(800, 600);
        this.setTitle("Projects Planner- create project for "+userName);
        this.setIconImage(icn.getImage());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(255, 192, 0)); 
       
       
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 192, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150)); 
        
       
        JLabel lbl = new JLabel("WELCOME TO PROJECT PLANNER");
        lbl.setFont(new Font("MV Boli", Font.BOLD, 25));
        lbl.setForeground(new Color(0x123456));
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        lbl.setOpaque(true);
        lbl.setBackground(new Color(100,0,250));
        
        
       
        title.setFont(new Font("Arial", Font.PLAIN, 14));
        title.setForeground(Color.DARK_GRAY);
        title.setBackground(new Color(245, 245, 245));
       // title.setHorizontalAlignment(JTextField.CENTER);
       title.setBorder(BorderFactory.createLineBorder(new Color(0x123456), 2));
        title.setMaximumSize(new Dimension(300, 40)); 
        
      
      
        description.setFont(new Font("Arial", Font.PLAIN, 14));
        description.setForeground(Color.DARK_GRAY);
        description.setBackground(new Color(245, 245, 245));
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setBorder(BorderFactory.createLineBorder(new Color(0x123456), 2));
        description.setMaximumSize(new Dimension(300, 100));
        JScrollPane scrollPane = new JScrollPane(description);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setMaximumSize(new Dimension(300, 100)); 
        
        submit = new JButton("Create Project");
        submit.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        submit.setForeground(Color.WHITE);
        submit.setBackground(new Color(100, 0, 250));
        submit.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        submit.setAlignmentX(Component.CENTER_ALIGNMENT); 
        submit.setMaximumSize(new Dimension(200, 50));
        submit.setFocusable(false);
        submit.addActionListener(this);
      
        
        
       JLabel titLbl = new JLabel();
       
       JLabel descLbl = new JLabel();
       titLbl.setText("Project title: ");
       titLbl.setForeground(new Color(0x123456));
       titLbl.setFont(new Font("MV boli",Font.BOLD,18));
       titLbl.setLayout(null);
       titLbl.setAlignmentX(JLabel.CENTER_ALIGNMENT);
       descLbl.setText("Project description: ");
       descLbl.setForeground(new Color(0x123456));
       descLbl.setFont(new Font("MV boli",Font.BOLD,18));
       descLbl.setLayout(null);
       descLbl.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      
        panel.add(lbl);
        panel.add(Box.createVerticalStrut(100)); 
        panel.add(titLbl);
        panel.add(Box.createVerticalStrut(10)); 
        panel.add(title);
        panel.add(Box.createVerticalStrut(10)); 
        panel.add(descLbl);
        panel.add(Box.createVerticalStrut(10)); 
        panel.add(scrollPane);
        panel.add(Box.createVerticalStrut(30)); 
        panel.add(submit);   
        
       
        this.add(panel);
        //this.setResizable(false);
        
        this.setVisible(true);
   
    //System.out.println(projectTit+"\n"+projectDesc);
        
    }
    String projectTit;
    String projectDesc;
    
    @Override
    public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==submit){
		 projectTit = title.getText();
		 projectDesc = description.getText();
		new Window2(projectTit);
		 }
		 else {System.out.println("Error creating project");}
	}

}

