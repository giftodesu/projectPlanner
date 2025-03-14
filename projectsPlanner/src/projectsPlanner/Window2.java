package projectsPlanner;

import javax.swing.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window2 extends JFrame implements ActionListener{
	 ImageIcon icn = new ImageIcon("1501772.png");
	 private JTable table;
	 private DefaultTableModel tableModel;
	 private JButton addt,deletet,save;
	 private JLabel title,responsible,description,startd,endd,satut,duration;
	 private JTextField titl,resp,desc,sd,ed;
	 private JComboBox <String>statu;
	 private String tit,res,des,sdd,edd,sta;
	 private String [] statuses= {"Not Started","In Progress","Completed"};
	 ImageIcon img = new ImageIcon("12.43.10.jpeg");
	  public Window2(String projectTit) {
	   setSize(900, 600);
	      setLocationRelativeTo(null);
	      setLayout(new BorderLayout());
	      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      createTaskTable();
	      createButtons();
	      createLabel();
	      getContentPane().setBackground(new Color(255, 192, 0));
	      setTitle(projectTit+" - adding tasks");
	      addt.addActionListener(this);
	      deletet.addActionListener(this);
	      setIconImage(img.getImage());
	      setVisible(true);
	      this.setIconImage(icn.getImage());
	  }
	 
	 
	 public void actionPerformed(ActionEvent e) {
	    if(e.getSource().equals(addt)){
	     try {
	      tit= titl.getText();
	      res=resp.getText();
	      des=desc.getText();
	      sdd=sd.getText();
	      edd=ed.getText();
	      sta=(String)statu.getSelectedItem();
	      if(tit.isEmpty()||res.isEmpty()||des.isEmpty()||sdd.isEmpty()||edd.isEmpty()||sta.isEmpty())
	      {
	       JOptionPane.showMessageDialog(this, "all fields must be filled !","ERROR",JOptionPane.ERROR_MESSAGE);
	      }
	      else {
	      Vector line = new Vector();
	      line.add(tit);
	      line.add(res);
	      line.add(des);
	      line.add(sdd);
	      line.add(edd);
	      line.add(sta);
	      tableModel.addRow(line);
	      titl.setText("");
	      resp.setText("");
	      desc.setText("");
	      sd.setText("");
	      ed.setText("");
	     
	      }
	     }catch(Exception ex){
	      
	        }
	    }if(e.getSource().equals(deletet)){
	     int reponse = JOptionPane.showConfirmDialog(null,"Supprimer cette ligne ?", "Confirmation",  JOptionPane.OK_CANCEL_OPTION);
	           if (reponse == 0) {
	            int i = table.getSelectedRow();
	               if (i != -1) {
	                   tableModel.removeRow(i);
	               }
	           }
	           
	     
	    }
	 }
	 
	 
	 public void createTaskTable() {
	    String []col=new String[]{"Title","responsible","Description","Start Date","End Date","Status","duration"};
	    tableModel=new DefaultTableModel(col,0);
	    
	    table =new JTable(tableModel);
	    statu = new JComboBox<>(statuses);
	    
	    table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(statu));
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
	   sd = new JTextField();
	   sd.setPreferredSize(new Dimension(300,50));
	   row4.add(startd);
	   row4.add(sd);
	   labelPanel.add(row4);
	   row4.setBackground(new Color(255,192,0));
	  
	   JPanel row5 = new JPanel(new FlowLayout(FlowLayout.LEFT,27, 5));
	   ed = new JTextField();
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
	

	}