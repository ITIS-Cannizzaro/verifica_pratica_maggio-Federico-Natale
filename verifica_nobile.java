package nobile;
import javax.swing.*;
import javax.swing.event.*;
import javax.awt.*;
import javax.awt.event.*;
import javax.awt.event.actionListener;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;



	public class verifica_nobile {

	    private ArrayList<Integer> numberList;
	    private DefaultListModel<Integer> listModel;
	    private Component numberListView;
	    private JTextField inputField;

	    public verifica_nobile() {
	        numberList = new ArrayList<>();
	        listModel = new DefaultListModel<>();

	        inputField = new JTextField();
	        JButton addButton = new JButton("Aggiungi");
	        JButton showButton = new JButton("Visualizza");

	        addButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                addNumberToList(inputField.getText());
	            }
	        });

	        showButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                showNumbers();
	            }
	        });

	        JPanel inputPanel = new JPanel();
	        inputPanel.setLayout(new FlowLayout());
	        inputPanel.add(inputField);
	        inputPanel.add(addButton);
	        inputPanel.add(showButton);

	        JFrame frame = new JFrame("ArrayList");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(new BorderLayout());
	        frame.add( numberListView, BorderLayout.NORTH);
	        frame.add(new JScrollPane(numberListView), BorderLayout.CENTER);
	        frame.setSize(300, 200);
	        frame.setVisible(true);
	    }

	    
	    private void addNumberToList(String numberString) {
	        try {
	            int number = Integer.parseInt(numberString);

	            
	            int index = Collections.binarySearch(numberList, number);
	            if (index < 0) {
	                index = -(index + 1);
	            }

	            numberList.add(index, number);
	            listModel.addElement(number);
	        } catch (NumberFormatException e) {
	            System.out.println("Inserisci un numero intero valido.");
	        }
	    }

	    private void showNumbers() {
	        Collections.sort(numberList);
	        listModel.clear();
	        for (Integer number : numberList) {
	            listModel.addElement(number);
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new verifica_nobile();
	            }
	        });
	    }
	



}
