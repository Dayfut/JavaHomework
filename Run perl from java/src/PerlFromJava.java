import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PerlFromJava {

	public static void main(String[] args) {
		
		Process p = null; //???
		BufferedReader inputStream = null;
		String[] cmd = {"perl", "test.pl"}; // string array of command to be executed
		ProcessBuilder process = new ProcessBuilder(cmd);
		
		try {
			
			p = process.start();						//execute the command
			System.out.println("Perl script executed correctly");	//message to say that the command worked
			
			inputStream = new BufferedReader(new FileReader("output.txt"));			//trying to read the lines from the output file into java console
			String lineOfData;														
			while ((lineOfData = inputStream.readLine()) != null){
				System.out.println(lineOfData);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
