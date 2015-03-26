import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ConvertCase {
	public static void main(String[] args) {
		//declare our buffered IO streams
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;
		
		
		//must surround with a try/catch
		try {
			inputStream = new BufferedReader(new FileReader("data.txt"));			//make a new input stream from the data.txt file
			outputStream = new PrintWriter(new FileWriter ("processed.txt"));		//make a new output stream to a processed.txt file
			System.out.println("file opened correctly");							//confirmation message that file was opened
			
			String lineOfData;														//initialize a string that will hold each line data
			while ((lineOfData = inputStream.readLine()) != null){
				System.out.println(lineOfData); //print out each line in console
				outputStream.println(lineOfData.toUpperCase());				//print in upper case to file
				outputStream.flush();		//pushes the data into the file
			}
			
			inputStream.close();
			outputStream.close();
			
		} catch (FileNotFoundException e) { //catch file not founds
			e.printStackTrace();
		} catch (IOException e) {			// catch IO exceptions
			e.printStackTrace();
		}
	}

}
