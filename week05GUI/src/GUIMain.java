import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUIMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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


	private static void createAndShowGUI(){
		//create and set up the GUI window
		//JFrame is the outer container for the GUI
		JFrame frame = new JFrame("My First GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create and set up the content pane named "MyGUI"
		JComponent newContentPane = new MyGUI();
		//make content pane opaque
		newContentPane.setOpaque(true);
		//set panel inside the frame
		frame.setContentPane(newContentPane);
		
		//display GUI window
		frame.pack();
		frame.setVisible(true);
	}
	
}

