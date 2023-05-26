package nobile;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

public class verifica_nobile {
    private ArrayList<Integer> numberList;
    private DefaultListModel<Integer> listModel;
    private JList<Integer> numberListView;
    private JTextField inputField;

    public verifica_nobile() {
        numberList = new ArrayList<>();
        listModel = new DefaultListModel<>();
        numberListView = new JList<>(listModel);

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension (20, 30));
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
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(numberListView), BorderLayout.CENTER);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }

    private void addNumberToList(String numberString) {
        try {
            int number = Integer.parseInt(numberString);
            int index = 0;

            for (int i = 0; i < numberList.size(); i++) {
                if (numberList.get(i) <= number) {
                    index = i + 1;
                } else {
                    break;
                }
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

        // ho usato al posto del comando "Collections.binarySearch()" un "for"
	// il main era già presente nel precedente programma
	// ho aggiunto gli import mancanti, che mi ero dimenticato di aggiungere nella verifica
	
	/* al codice manca la classe main per essere eseguito, inoltre sono poco sicuro del fatto che sia farina del tuo sacco.
	 * Ad esempio sai dirmi cosa fà il metodo "Collections.binarySearch()" ?.
	 * Inoltre manca l'import delle librerie java.awt.* e java.awt.event.* Senza di esse il codice non potrebbe girare.
	 * */
