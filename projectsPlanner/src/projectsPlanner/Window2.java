package projectsPlanner;
import javax.swing.*;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;



public class Window2 extends JFrame implements ActionListener{
	
	private JTextField titl,resp,desc,sd,ed;
	public void populateTaskTable(Project project) {
	    tableModel.setRowCount(0); 

	    for (Task task : project.tasks) {
	        Vector<Object> row = new Vector<>();
	        row.add(task.getTitle());
	        row.add(task.getResponsiblePerson());
	        row.add(task.getDescription());
	        row.add(task.getDuration()); 
	        row.add(task.getEndDate());
	        row.add(task.getStatus());
	        tableModel.addRow(row);
	    }
	}

	
	 public static Project uploadFromFile() {
			Project upP = null;
			try {
				BufferedReader reader = new BufferedReader(new FileReader("project.txt"));
				BufferedReader reader2 = new BufferedReader(new FileReader("tasks.txt"));
				try {
					String line = reader.readLine();
					String s1,s2,s3,s4,s5,s6;
					
					
					
					if (line !=null) {
						s1 = reader.readLine();
						s2 = reader.readLine();
						upP= new Project(s1,s2);
						line = reader.readLine();
					}
					line=reader2.readLine();
					while(line !=null) {
						line=reader2.readLine();
						
						s1=reader2.readLine();
						s2=reader2.readLine();
						s3=reader2.readLine();
						s4=reader2.readLine();
						s5=reader2.readLine();
						s6=reader2.readLine();
						upP.tasks.add(new Task(s1,s2,s3,s4,s5,s6));
						line=reader2.readLine();
						
					}
					
					
					reader.close();
					reader2.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			
			
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			return upP;
			
			
			
			
		}
	
	public void saveProject(Project p) {
	    if (p == null) {
	        JOptionPane.showMessageDialog(this, "Project is null!", "ERROR", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    if (p.tasks == null || p.tasks.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "No tasks to save!", "Warning", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    try {
	        File projectFile = new File("project.txt");
	        boolean projectExists = false;

	        
	        if (projectFile.exists()) {
	        try (Scanner scanner = new Scanner(projectFile)) {
	         while (scanner.hasNextLine()) {
	           String line = scanner.nextLine().trim();
	           if (line.equals(p.getTitle())) { 
	              if (scanner.hasNextLine() && scanner.nextLine().trim().equals(p.getDescription())) {
	                 projectExists = true;
	                  break;
	               }
	            }
	           }
	         }
	        }

	      
	        if (!projectExists) {
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter("project.txt"))) {
	                writer.write("\n" + p.getTitle() + "\n" + p.getDescription() + "\n");
	            }
	        }

	        File taskFile = new File("tasks.txt");
	        
	        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter(taskFile, true))) {
	            for (Task t : p.tasks) {
	                writer2.write("\n" + t.getTitle() + "\n" + t.getDescription() + "\n" +
	                              t.getResponsiblePerson() + "\n" + t.getStatus() + "\n" +
	                              "\n"+t.getStartDate()+"\n"+ t.getEndDate() + "\n");
	            }
	        }

	        JOptionPane.showMessageDialog(this, "Project saved successfully!");

	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(this, "Error saving project: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
	    }
	}

	
	 ImageIcon icn = new ImageIcon("1501772.png");
	 private JTable table;
	 private DefaultTableModel tableModel;
	 private JButton addt,deletet,save;
	 private JLabel title,responsible,description,startd,endd,satut,duration;
	
	 private JComboBox <String>statu;
	 private long durationdays,diffin;
	 
	// private String tit,res,des,sdd,edd,sta,dur="aa";
	 private String [] statuses= {"Not Started","In Progress","Completed"};
	 
	 
	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private  Date sdate,edate,enddDate;
	 ImageIcon img = new ImageIcon("12.43.10.jpeg");
	private Project p;
	  public Window2(Project p) {
		  this.p=p;
	   setSize(900, 600);
	      setLocationRelativeTo(null);
	      setLayout(new BorderLayout());
	      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      createTaskTable();
	      createButtons();
	      createLabel();
	      getContentPane().setBackground(new Color(255, 192, 0));
	      setTitle(p.getTitle()+" - adding tasks");
	      addt.addActionListener(this);
	      deletet.addActionListener(this);
	      setIconImage(img.getImage());
	      setVisible(true);
	      this.setIconImage(icn.getImage());
	      
	  }
	 
	  
	  
	  
	  public void actionPerformed(ActionEvent e) {
	    if(e.getSource().equals(addt)){
	    Task t = new Task();
	    
	      t.setTitle(titl.getText());
	      t.setResponsiblePerson(resp.getText());
	      t.setDescription(desc.getText());
	      
	      t.setStartDate(sd.getText());
	      t.setEndDate(ed.getText());
	      t.setStatus((String)statu.getSelectedItem());
	      try {
	      p.tasks.add(t);}catch(NullPointerException o) {
	    	  o.printStackTrace();
	      }
	      
	      
	      if(t.getTitle().isEmpty()||t.getResponsiblePerson().isEmpty()||t.getDescription().isEmpty()||t.getStartDate().isEmpty()||t.getEndDate().isEmpty()||t.getStatus().isEmpty())
	      {
	       JOptionPane.showMessageDialog(this, "all fields must be filled !","ERROR",JOptionPane.ERROR_MESSAGE);
	      }
	      else {
	    	 
	    	  dateFormat.setLenient(false);
	      }
	    	  
	    	  
	      Vector line = new Vector();
	     
	      try {
	    	  sdate=dateFormat.parse(t.getStartDate());
	    	  edate=dateFormat.parse(t.getEndDate());
	    	  //endDate=edate;
	    	 if(canStartTask(table,t.getStartDate())==false) {
	    		 JOptionPane.showMessageDialog(this, "You cannot start the new task before completing the previous task. Modify the start date","ERROR",JOptionPane.ERROR_MESSAGE);
	    		 sd.setText("");
	    	 }else {
	    		 
	    	 
	    	  if(sdate.compareTo(edate)==0) {
	    		  JOptionPane.showMessageDialog(this, "Start Date and End Date are the same","ERROR",JOptionPane.ERROR_MESSAGE);
	    		  sd.setText("");
		    	  ed.setText("");
	    	  }else {
	    	  if(sdate.compareTo(edate)>0) {
	    		  JOptionPane.showMessageDialog(this, "Start Date must be before End Date","ERROR",JOptionPane.ERROR_MESSAGE);
	    		  sd.setText("");
		    	  ed.setText("");
	    	  }
	    	  else {
	    		  diffin=edate.getTime()-sdate.getTime();
	    		  durationdays=TimeUnit.DAYS.convert(diffin,TimeUnit.MILLISECONDS);
	    	     line.add(t.getTitle());
	             line.add(t.getResponsiblePerson());
	             line.add(t.getDescription());
	             //line.add(t.getStartDate());
	            //line.add(t.getEndDate());
	             line.add(durationdays+" days");
	             line.add(t.getEndDate());
	             line.add(t.getStatus());
	             tableModel.addRow(line);
	             titl.setText("");
	             resp.setText("");
	             desc.setText("");
	             sd.setText("");
	             ed.setText("");
	    	  }
	    	  }
	    	 }
	      }
	    	         	      
	      
	    	 catch(ParseException m) {
	    	  JOptionPane.showMessageDialog(this, "invalid date format use yyyy-MM-dd","ERROR",JOptionPane.ERROR_MESSAGE);
	    	  sd.setText("");
	    	  ed.setText("");
	      }
	    }
	 
	      
	    
	    if(e.getSource().equals(deletet)){
	     int reponse = JOptionPane.showConfirmDialog(null,"Supprimer cette ligne ?", "Confirmation",  JOptionPane.OK_CANCEL_OPTION);
	           if (reponse == 0) {
	            int i = table.getSelectedRow();
	               if (i != -1) {
	                   tableModel.removeRow(i);
	               }
	           }
	           
	     
	    }if(e.getSource().equals(save)) {
	    	
	    	    saveProject(p);
	    	    JOptionPane.showMessageDialog(this, "Project saved successfully!");
	    }
	 }
	 
	 
		    public  boolean canStartTask(JTable table, String newTaskStartDate) {
		        int lastRow = table.getRowCount() - 1; 
		        int endDateColumn = 4;

		        if (lastRow >= 0) { 
		            String lastEndDate = table.getValueAt(lastRow, endDateColumn).toString();
		            
		          
		            return newTaskStartDate.compareTo(lastEndDate) >= 0;
		        }
		        return true;
		    }
		
	 
	 
	 
	 public void createTaskTable() {
	    String []col=new String[]{"Title","responsible","Description","duration","End Date","Status"};
	    tableModel=new DefaultTableModel(col,0);
	    
	    table =new JTable(tableModel);
	    statu = new JComboBox<>(statuses);
	    
	    table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(statu));
	    table.getColumn("Status").setCellRenderer(new StatusColorRenderer());

	    table.setRowHeight(30);
	    
	    JScrollPane Scroll=new JScrollPane(table);
	    add(Scroll, BorderLayout.EAST);
	 }
	 
	 
	 
	 
	 public void createButtons() {
	  addt=new JButton(" ADD TASK");
	  addt.setBackground(new Color(65,105,255));
	  addt.setForeground(Color.WHITE);  
	  addt.setFont(new Font("Arial", Font.BOLD, 16));
	  addt.setFocusPainted(false);
	  addt.setBorderPainted(false);
	  addt.setOpaque(true);
	  
	  deletet=new JButton("DELETE TASK");
	  deletet.setBackground(new Color(65,105,255));
	  deletet.setForeground(Color.WHITE);  
	  deletet.setFont(new Font("Arial", Font.BOLD, 16));
	  deletet.setFocusPainted(false);
	  deletet.setBorderPainted(false);
	  deletet.setOpaque(true);
	  
	  save=new JButton("SAVE");
	  save.setBackground(new Color(65,105,255));
	  save.setForeground(Color.WHITE);  
	  save.setFont(new Font("Arial", Font.BOLD, 16));
	  save.setFocusPainted(false);
	  save.setBorderPainted(false);
	  save.setOpaque(true);
	  save.addActionListener(this);
	
		  
	  
	 
	  JPanel buttonPanel=new JPanel();
	  buttonPanel.add(addt);
	  buttonPanel.add(deletet);
	  buttonPanel.add(save);
	  add(buttonPanel,BorderLayout.SOUTH);
	  buttonPanel.setBackground(new Color(255,192,0));
	  }
	 
	 
	 
	 public void createLabel() {
	  title=new JLabel("Title");
	  responsible=new JLabel("Responsible");
	  description=new JLabel("Description");
	  startd=new JLabel("Start Date");
	  endd=new JLabel("End Date");
	  satut=new JLabel("Status");
	 
	  
	  
	 
	  JPanel labelPanel=new JPanel();
	  GridLayout grid = new GridLayout(6, 1,10,10);
	  
	  labelPanel.setLayout(grid);
	  labelPanel.setBorder(BorderFactory.createTitledBorder("Add a task"));
	  
	   JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT,39, 5));
	   titl = new JTextField();
	   titl.setPreferredSize(new Dimension(300,50));
	   row1.add(title);
	   row1 .add(titl);
	   labelPanel.add(row1);
	   row1.setBackground(new Color(255,192,0));
	   
	   JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT,15, 5));
	   resp = new JTextField();
	   resp.setPreferredSize(new Dimension(300,50));
	   row2.add(responsible);
	   row2 .add(resp);
	   labelPanel.add(row2);
	   row2.setBackground(new Color(255,192,0));
	   
	   JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT,18, 5));
	   desc = new JTextField();
	   desc.setPreferredSize(new Dimension(300,50));
	   row3.add(description);
	   row3.add(desc);
	   labelPanel.add(row3);
	   row3.setBackground(new Color(255,192,0));
	   
	   JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT,24, 5));
	   sd = new JTextField("yyyy-MM-dd");
	   sd.setForeground(Color.DARK_GRAY);
	   sd.setPreferredSize(new Dimension(300,50));
	   row4.add(startd);
	   row4.add(sd);
	   labelPanel.add(row4);
	   row4.setBackground(new Color(255,192,0));
	  
	   JPanel row5 = new JPanel(new FlowLayout(FlowLayout.LEFT,27, 5));
	   ed = new JTextField("yyyy-MM-dd");
	   ed.setForeground(Color.DARK_GRAY);
	   ed.setPreferredSize(new Dimension(300,50));
	   row5.add(endd);
	   row5.add(ed);
	   labelPanel.add(row5);
	   row5.setBackground(new Color(255,192,0));
	   
	  
	   JPanel row6 = new JPanel(new FlowLayout(FlowLayout.LEFT,37, 5));
	  
	   statu = new JComboBox<>(statuses);
	   statu.setPreferredSize(new Dimension(300,50));
	   row6.add(satut);
	   row6.add(statu);
	   labelPanel.add(row6);
	   row6.setBackground(new Color(255,192,0));
	  
	 
	  
	  
	  
	  labelPanel.setPreferredSize(new Dimension(0,500));
	  add(labelPanel,BorderLayout.CENTER);
	 
	  labelPanel.setBackground(new Color(255,192,0));
	  
	  
	 }
	

class StatusColorRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    	
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        String status = (String) value;

        switch (status) {
            case "Not Started":
                cell.setBackground(Color.RED);
                cell.setForeground(Color.BLACK);
                break;
            case "In Progress":
                cell.setBackground(new Color(255,227,2));
                cell.setForeground(Color.BLACK);
                break;
            case "Completed":
                cell.setBackground(new Color(80,195,108));
                cell.setForeground(Color.BLACK);
                break;
            default:
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
                break;
        }

        return cell;
    }
   
}
 public static void main(String []args) {
	 System.out.println("test");
 }
}
