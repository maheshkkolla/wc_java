import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Wc {
	public static void main(String[] args) {
		String fileData = "";

		try{
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String newLine;
			while ((newLine = br.readLine()) != null){fileData += newLine+"\r\n";}
		} catch(Exception err){
			System.out.println("Error--------"+err);
		}
		WcLib count = new WcLib(fileData);
		count.callAllCounts();
		System.out.println("\t"+count.lineCount+"\t"+count.wordCount+"\t"+count.charCount+"\t"+args[0]);
	}
}