// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
import java.io.*;
import java.lang.*;

public class Wc {
	public static void main(String[] args) throws IOException  {
		String[] options = Wc.getOptions(args);
		WcFile[] allFiles = Wc.readAllFiles(args); 
	}
	public static String[] getOptions(String[] args) {
		String options = new String();
		for(String arg : args){
			if(arg.charAt(0) == '-')options += arg.charAt(1);
		}
		return options.split("");
	}
	public static String getFileContent(String fileName)  throws IOException {
		File file = new File(fileName);
		int fileLength = (int)file.length();
		char[] fileData = new char[fileLength];		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		br.read(fileData, 0, fileLength);
		return new String(fileData);
	}
	public static int getNoOfFiles(String[] args) {
		int countOfFiles = 0;
		for(String arg: args){
			if(arg.charAt(0) != '-') countOfFiles++;
		}
		return countOfFiles;
	}

	public static String[] getFileNames(String[] args) {
		String[] fileNames = new String[Wc.getNoOfFiles(args)];
		int index = 0;
		for(String arg: args){
			if(arg.charAt(0) != '-') {
				fileNames[index] = arg;
				index++;
			}
		}
		return fileNames;
	}
	public static WcFile[] readAllFiles(String[] args) {
		int noOfFiles = Wc.getNoOfFiles(args);
		WcFile[] allFiles = new WcFile[noOfFiles];
		String[] fileNames = Wc.getFileNames(args);
		for(int i =0; i<noOfFiles; i++){
			String fileName = fileNames[i];
			allFiles[i] = new WcFile(fileName, Wc.getFileContent(fileName));
		}
		return allFiles;
	}
}
class WcFile {
	String fileName;
	String fileContent;
	public WcFile(String fileName, String fileContent) {
		this.fileName = fileName;
		this.fileContent = fileContent;
	}
}