// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
import java.io.*;

public class Wc {
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		int fileLength = (int)file.length();
		char[] fileData = new char[fileLength];		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		br.read(fileData, 0, fileLength);
		WcLib wc = new WcLib(new String(fileData));
		wc.callAllCounts();
		System.out.println(wc.lineCount+"\t"+wc.wordCount+"\t"+wc.charCount+"\t"+args[0]);
	}
}