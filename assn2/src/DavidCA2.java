import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
I declare that the attached assignment is my own work in accordance
with Seneca Academic Policy. No part of this assignment has been
copied manually or electronically from any other source (including web
sites) or distributed to other students.
Name : David Cheung
Student ID: 060670031
*/

public class DavidCA2 extends JPanel implements ActionListener {

	JTextArea rawSeq;				//text area for user to input sequence
	JComboBox<Integer> numChars;	//drop down menu for user to choose number of characters per line
	JCheckBox grouped;				//check box if user wants to display sequence in groups of 10 characters
	JRadioButton lowerCase; 		//radio for upper/lower case output, default
	JRadioButton upperCase;			//radio button for upper/lower case output
	JButton processSeq;				//button to start processing data
	JButton resetWindow;			//button to reset the contents of the window
	JTextArea formattedSeq;			//text area showing the formatted sequence
	JTextArea numPercent;			//text area showing the bases and the percentage composition of each base

	private static final long serialVersionUID = -420254383885138649L;
	
	public DavidCA2() {	//assn2ContentPane default constructor
		JPanel windowContents = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		setPreferredSize(new Dimension(800, 650));
		Font font = new Font("Courier New", Font.PLAIN, 12);
		
		//RAW SEQUENCE LABEL AND INPUT BOX
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		windowContents.add(new Label("Sequence: "), c);	//create a label for text area
		
		c.gridy = 1;
		c.gridwidth = 4;
		c.gridheight = 3;
		rawSeq = new JTextArea(10,80);	//create text area object
		rawSeq.setLineWrap(true);		//set word wrapping
		rawSeq.setFont(font);
		JScrollPane scrollRawSeq = new JScrollPane(rawSeq,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);	//allows text area to be scrollable
		windowContents.add(scrollRawSeq, c);
		
		//COMBO BOX LABEL AND COMBO BOX
		c.gridheight = 1;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 4;
		c.anchor = GridBagConstraints.WEST;
		windowContents.add(new Label("Number of characters per line:"), c);
		
		c.gridx = 1;
		c.gridy = 4;
		numChars = new JComboBox<Integer>();
		numChars.addItem(40);
		numChars.addItem(50);
		numChars.addItem(60);
		numChars.addItem(70);
		windowContents.add(numChars, c);
		
		//CHECKBOX
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.WEST;
		grouped = new JCheckBox("Display the sequence as 10-character groups");
		windowContents.add(grouped, c);
		
		//RADIO BUTTONS
		lowerCase = new JRadioButton("Output LOWER CASE");	//set radio buttons and their labels
		upperCase = new JRadioButton("Output UPPER CASE");
		lowerCase.setSelected(true);	//sets lower case button as default
		ButtonGroup upperLowerGroup = new ButtonGroup();	//sets upper and lower case buttons to a group such that only one can be selected at a time
		upperLowerGroup.add(lowerCase);
		upperLowerGroup.add(upperCase);
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.WEST;
		windowContents.add(lowerCase, c);	//add radio buttons to the content pane
		
		c.gridx = 1;
		c.gridy = 5;
		c.anchor = GridBagConstraints.CENTER;
		windowContents.add(upperCase, c);
		lowerCase.addActionListener(this);		//add listeners for radio buttons
		upperCase.addActionListener(this);
		
		//BUTTON TO START PROCESSING THE SEQUENCE
		c.gridx = 2;
		c.gridy = 5;
		c.anchor = GridBagConstraints.CENTER;
		processSeq = new JButton("Proccess Sequence");
		windowContents.add(processSeq, c);
		processSeq.addActionListener(this);
		processSeq.setActionCommand("process");
		
		//BUTTON TO RESET WINDOW CONTENTS
		c.gridx = 3;
		c.gridy = 5;
		c.anchor = GridBagConstraints.WEST;
		resetWindow = new JButton("Reset Window Contents");
		windowContents.add(resetWindow, c);
		resetWindow.addActionListener(this);
		resetWindow.setActionCommand("reset");
		
		//TEXT AREA WITH FORMATED SEQUENCES
		c.gridx = 0;
		c.gridy = 6;
		c.anchor = GridBagConstraints.WEST;
		windowContents.add(new Label("Formatted Sequence:"), c);
		c.gridy = 7;
		c.gridwidth = 4;
		c.anchor = GridBagConstraints.WEST;
		formattedSeq = new JTextArea(10, 80);
		JScrollPane scrollFormattedSeq = new JScrollPane(formattedSeq, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		formattedSeq.setFont(font);
		windowContents.add(scrollFormattedSeq, c);
		
		//TEXT AREA WITH BASE COUNTS
		c.gridy = 8;
		c.anchor = GridBagConstraints.WEST;
		windowContents.add(new Label("Base Counts:"), c);
		c.gridy = 9;
		c.anchor = GridBagConstraints.WEST;
		numPercent = new JTextArea(10, 80);
		JScrollPane scrollNumPercent = new JScrollPane(numPercent);
		numPercent.setFont(font);
		windowContents.add(scrollNumPercent, c);
		
		//add controls area layout to MYGUI JPanel
		this.add(windowContents, BorderLayout.SOUTH);
	}
	
	// ACTION LISTENER CARRYS OUT ACTIONS WHEN A BUTTON IS PRESSED....
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "process"){	//action command is passed and if detected,
			String sequence = rawSeq.getText();
			sequence = sequence.replace("\n", ""); //remove newline characters and spaces if present
			sequence = sequence.replace(" ", "");
			
			
			//set up regular expressions to check if invalid characters are present
			Pattern pattern = Pattern.compile("[^actg]", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(sequence);
			boolean found = false;
			while (matcher.find()) {	//look through sequence to find invalid characters
				found = true;
			}
			//print error message if inputed sequence contains any characters other than agct
			if (found) {
				JOptionPane.showMessageDialog(null, "Sequence must only contain ACGTs", "Error", JOptionPane.ERROR_MESSAGE);
			
			} else { 	//perform analysis and formatting if sequence is valid
				int aCount = 0;		//counters to count the bases 
				int cCount = 0;
				int tCount = 0;
				int gCount = 0;
				for (int index = 0; index < sequence.length(); index++){		//looks at each character in the string and checks to see which is which to add to counters
					if (sequence.substring(index, index + 1).equals("a") | sequence.substring(index, index + 1).equals("A")){
						aCount++;
					} else if (sequence.substring(index, index + 1).equals("c") | sequence.substring(index, index + 1).equals("C")){
						cCount++;
					} else if (sequence.substring(index, index + 1).equals("t") | sequence.substring(index, index + 1).equals("T")) {
						tCount++;
					} else{
						gCount++;
					}
				}
				
				//convert sequence to upper or lower case depending on the radio button selected
				if (lowerCase.isSelected()){
					sequence = sequence.toLowerCase();
				} else {
					sequence = sequence.toUpperCase();
				}
				
				//output sequence in rows of 40, 50, 60, 70 characters
				StringBuilder formattedText = new StringBuilder();
				int i = 0;
				while (i < sequence.length()){
					formattedText.append(sequence.substring(i, Math.min(i + 10, sequence.length()))); //add sequence to stringbuilder in groups of 10
					if (grouped.isSelected()) {		//if "grouped in 10 characters" is selected, add a space between each addition
						formattedText.append(" ");
					}
					i += 10;
					if (i % (int)numChars.getSelectedItem() == 0) { //if the index divides with no remainder to the number of characters per column, add a newline character
						formattedText.append("\n");
					}
				}
				formattedSeq.setText(formattedText.toString()); //output to formatted sequence text box
				
				StringBuilder baseCount = new StringBuilder();  //build string and output to the text box containing he base counts
				double totalBase = aCount + cCount + tCount + gCount;
				String aPercent = String.format("%.3f", aCount / totalBase * 100);
				String cPercent = String.format("%.3f", cCount / totalBase * 100);
				String tPercent = String.format("%.3f", tCount / totalBase * 100);
				String gPercent = String.format("%.3f", gCount / totalBase * 100);
				baseCount.append("Number of A's: " + aCount + "\tPercentage of A's: " + aPercent + "%\n");
				baseCount.append("Number of C's: " + cCount + "\tPercentage of C's: " + cPercent + "%\n");
				baseCount.append("Number of T's: " + tCount + "\tPercentage of T's: " + tPercent + "%\n");
				baseCount.append("Number of G's: " + gCount + "\tPercentage of G's: " + gPercent + "%\n\n");
				baseCount.append("Total basecount: " + totalBase);
				numPercent.setText(baseCount.toString());
				
			}
		} else if (e.getActionCommand() == "reset") {
			JFrame resetFrame = new JFrame("Reset Confirmation");
			Object[] options = {"Yes", "No", "Cancel"};
			int n = JOptionPane.showOptionDialog(resetFrame, "Are you sure you want to reset the window contents?", "Reset Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
			if (n == JOptionPane.YES_OPTION) {
				rawSeq.setText("");
				numChars.setSelectedItem(40);
				grouped.setSelected(false);
				formattedSeq.setText("");
				numPercent.setText("");
				lowerCase.setSelected(true);
			}
		}
		
	}
	
	// MAIN METHOD
	public static void main (String [] args){
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		//indicate to java to call createAndShowGUI "asynchronously" => "later"
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				createAndShowGUI();
			}
		});
	}
	
	private static void createAndShowGUI(){		//create and set up GUI window
		//JFrame is the outer container for the GUI
		JFrame frame = new JFrame("David's Raw Sequence Base Counter");		//sets window name
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//window closes when X button pressed on rame
		
		//create and set up the content pane ass
		JComponent newContentPane = new DavidCA2();
		//make content pane opaque
		newContentPane.setOpaque(true);
		//set panel inside the frame
		frame.setContentPane(newContentPane);
		
		//display GUI window
		frame.pack();
		frame.setVisible(true);
	}

}
