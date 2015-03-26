import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class MyGUI extends  JPanel implements ActionListener{	//MyGUI is a subclass of JPanel

	//controls or components that we want to access appear as fields in MyGUI class
	JTextArea inputSequence;
	JTextArea searchFor;
	JButton searchButton;
	Label searchResult;
	
	ActionListener listener = null;
	
	private static final long serialVersionUID = -420254383885138649L; //each window needs a serialVersionUID (generated randomly)

	public MyGUI (){ //default constructor
		JPanel controlsArea = new JPanel(new GridLayout(3, 2)); //create a panel with grid layout 3 rows, 2 columns
		setPreferredSize(new Dimension(300,300)); //create panel inside the frame with default size
		
		
		controlsArea.add(new Label("Sequence: "));
		//instantiate the inputSequence text area
		inputSequence = new JTextArea();
		//add inputSequence to layout
		controlsArea.add(inputSequence);
		
		controlsArea.add(new Label("Search For: "));
		//instantiate the searchFor text area
		searchFor = new JTextArea();
		controlsArea.add(searchFor);
		
		//add a button with a search label
		searchButton = new JButton("Search");
		controlsArea.add(searchButton);
		searchButton.setActionCommand("search");
		//set up listener for the button
		searchButton.addActionListener(this); //pass the current instance of the gui as the action
		
		
		//add a label that is going to display results to the user
		//label will have its own variable name because we want to access it later
		searchResult = new Label("<-- Click to search");
		controlsArea.add(searchResult);
		
		
		//add controls area layout to MYGUI JPanel
		this.add(controlsArea, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//
		if (e.getActionCommand() == "search"){	//action command is passed and if detected,
			String tempText = inputSequence.getText();
			searchResult.setText(tempText);
		}
	}
}
