package swing.ikram.collection;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class labelCol extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					labelCol frame = new labelCol();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	   final ArrayList<String> dataList = new ArrayList<String>();
	   private JTextField textField_4;
	   private JTextField textField_5;

	/**
	 * Create the frame.
	 */
	public labelCol() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 767);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("chercher un article ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String search = textField_4.getText();
				
				if(!search.equals("")) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					
					for (String data : dataList) {
						String[] row = data.split(",");
						if(row[0].equals(search)) {
							model.addRow(row);
						}
					}
				}else {
					// si le champ est vide, afficher tous les articles
					showData();
				}
			}
				
				
			
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(20, 286, 172, 33);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("supprimer un article");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				   String tabn = table.getValueAt(table.getSelectedRow(),0).toString();
					String tabref = table.getValueAt(table.getSelectedRow(),1).toString();
			        String tabpri =  table.getValueAt(table.getSelectedRow(),2).toString();
			        String tabquanti =  table.getValueAt(table.getSelectedRow(),1).toString();
			        
			model.removeRow(selectedRow); 
			Object[] rowData = new Object[model.getColumnCount()];
            for (int i = 0; i < model.getColumnCount(); i++) {
                rowData[i] = model.getValueAt(selectedRow, i);
            }
            deleteArticleFromJSONFile(rowData); 
				
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(756, 286, 168, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("modifier un article");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if(table.getSelectedRow() == 1) {
					  String data = textField.getText();
						String data1 = textField_1.getText();
				        String data2 = textField_2.getText();
				        String data3 = textField_3.getText();
				        model.setValueAt(data, table.getSelectedRow(), 0);
				        model.setValueAt(data1, table.getSelectedRow(), 1);
				        model.setValueAt(data2, table.getSelectedRow(), 2);
				        model.setValueAt(data3, table.getSelectedRow(), 3);
				        System.out.println("updated");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(559, 286, 199, 33);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				   String tabn = table.getValueAt(table.getSelectedRow(),0).toString();
					String tabref = table.getValueAt(table.getSelectedRow(),1).toString();
			        String tabpri =  table.getValueAt(table.getSelectedRow(),2).toString();
			        String tabquanti =  table.getValueAt(table.getSelectedRow(),1).toString();
			        
			        
			        textField.setText(tabn);
				    textField_1.setText(tabref);
			        textField_2.setText(tabpri);
			        textField_3.setText(tabquanti); 
			        
			        
			}
		});
		scrollPane.setToolTipText("");
		scrollPane.setBounds(10, 363, 524, 137);
		contentPane.add(scrollPane);
		// JTABLE
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Name article");
		model.addColumn("réference article");
		model.addColumn("prix article");
		model.addColumn("Quantité article");
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {	 },	new String[] {
					"Name article", "réference article", "prix article", "Quantité article"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Entrer le nom de l'article");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 76, 199, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(43, 99, 217, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEntrerLeRference = new JLabel("Entrer le réference de l'article");
		lblEntrerLeRference.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEntrerLeRference.setBounds(10, 128, 240, 13);
		contentPane.add(lblEntrerLeRference);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(43, 152, 217, 19);
		contentPane.add(textField_1);
		
		JLabel lblEntrerLePrixde = new JLabel("Entrer le prix de l'article");
		lblEntrerLePrixde.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEntrerLePrixde.setBounds(10, 181, 199, 13);
		contentPane.add(lblEntrerLePrixde);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(43, 205, 217, 19);
		contentPane.add(textField_2);
		
		JLabel lblEntrerLaDuantit = new JLabel("Entrer la quantité de l'article");
		lblEntrerLaDuantit.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEntrerLaDuantit.setBounds(10, 234, 199, 13);
		contentPane.add(lblEntrerLaDuantit);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(43, 257, 217, 19);
		contentPane.add(textField_3);
		// button ajouter dans le tableau
		
		JButton ajout_tab = new JButton("Ajouter un article dans le tableau  et dans un fichier ");
		ajout_tab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String data = textField.getText();
				String data1 = textField_1.getText();
		        String data2 = textField_2.getText();
		        String data3 = textField_3.getText();
		        // Add the data to the table model
		        model.addRow(new Object[] { data,data1, data2,data3 });
		        table.setModel(model);
		        // Clear the text fields
		        textField.setText("");
			    textField_1.setText("");
		        textField_2.setText("");
		        textField_3.setText("");
		        
			}
		});
		ajout_tab.setFont(new Font("Tahoma", Font.BOLD, 13));
		ajout_tab.setBounds(192, 286, 377, 33);
		contentPane.add(ajout_tab);
	    
		ajout_tab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (e.getSource() == ajout_tab) {
		            String name = textField.getText();
		            int REF = Integer.parseInt(textField_1.getText());
		            int P = Integer.parseInt(textField_2.getText());
		            int Q = Integer.parseInt(textField_3.getText());

                    
		          
		            
		            String data = "[" +name + "," + REF + "," + P +"," + Q +  "]" +"\n";
		            try {
		                BufferedWriter writer = new BufferedWriter(new FileWriter("fichierakhor.json", true));
		                writer.write(data);
		                writer.close();
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
			}
		});
	    getContentPane().add(ajout_tab, BorderLayout.CENTER);
	    
	    JButton btnNewButton_4 = new JButton("supprimer par nom");
	    btnNewButton_4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
	    btnNewButton_4.setBounds(85, 643, 187, 33);
	    contentPane.add(btnNewButton_4);
	    
	    JButton btnNewButton_4_1 = new JButton("chercher par réference");
	    btnNewButton_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	    btnNewButton_4_1.setBounds(85, 531, 187, 33);
	    contentPane.add(btnNewButton_4_1);
	    
	    JLabel lblNewLabel_1 = new JLabel("Entrer le référence de l'articel");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	    lblNewLabel_1.setBounds(312, 538, 222, 19);
	    contentPane.add(lblNewLabel_1);
	    
	    JButton btnNewButton_5 = new JButton("Modifier par référence");
	    btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
	    btnNewButton_5.setBounds(85, 587, 187, 35);
	    contentPane.add(btnNewButton_5);
	    
	    
	    textField_4 = new JTextField();
	    textField_4.setBounds(363, 578, 96, 19);
	    contentPane.add(textField_4);
	    textField_4.setColumns(10);
	    
	    textField_5 = new JTextField();
	    textField_5.setBounds(363, 665, 96, 19);
	    contentPane.add(textField_5);
	    textField_5.setColumns(10);
	    
	    JLabel lblNewLabel_2 = new JLabel("Entrer le nom");
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
	    lblNewLabel_2.setBounds(312, 627, 104, 13);
	    contentPane.add(lblNewLabel_2);
	    
	    JLabel lblNewLabel_3 = new JLabel("La gestion des articles");
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 30));
	    lblNewLabel_3.setBounds(326, 10, 387, 55);
	    contentPane.add(lblNewLabel_3);

        // Display the JFrame
        setVisible(true);
    
       }
	public static void removeItemByRef() {
	

 
    
	}
	public void showData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		System.out.println("wslty schoz");
		for (String data : dataList) {
			String[] row = data.split(",");
			model.addRow(row);
		}
	
	}






}

