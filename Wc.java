// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
import java.io.*;

public class Wc {
	public static void main(String[] args) throws IOException  {
		String fileData = Wc.getFileContent(args[0]);
		WcLib wc = new WcLib(fileData);
		wc.callAllCounts();
		System.out.println("\t"+wc.lineCount+"\t"+wc.wordCount+"\t"+wc.charCount+"\t"+args[0]);
	}

	// public static char[] getOptions() {

	// }

	// public static String[] getFileNames() {

	// }

	public static String getFileContent(String fileName)  throws IOException {
		File file = new File(fileName);
		int fileLength = (int)file.length();
		char[] fileData = new char[fileLength];		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		br.read(fileData, 0, fileLength);
		return new String(fileData);
	}
}