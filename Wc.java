// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
import java.io.*;
import java.lang.*;

public class Wc {
	String[] options;
	WcFile[] allFiles; 
	WcLib[] allWcs;
	WcCounts[] allWcCounts;

	public Wc(String[] options, WcFile[] allFiles, WcLib[] allWcs, WcCounts[] allWcCounts){
		this.options = options;
		this.allFiles = allFiles;
		this.allWcs = allWcs;
		this.allWcCounts = allWcCounts;
	}

	public static void main(String[] args) throws IOException  {
		String[] options = Wc.getOptions(args);
		WcFile[] allFiles = Wc.readAllFiles(args); 
		WcLib[] allWcs = new WcLib[allFiles.length];
		WcCounts[] allWcCounts = new WcCounts[allFiles.length];
		Wc wcMain = new Wc(options, allFiles, allWcs, allWcCounts);
		if(options.length == 0){
			wcMain.handleWcWithoutOptions();
		} else {
			wcMain.handleWcWithOptions();
		}
	}

	public void handleWcWithOptions() {
		for(int i=0; i<allFiles.length;i++) {
			allWcs[i] = new WcLib(allFiles[i].fileContent);
			allWcs[i].callAllCounts();
			allWcCounts[i] = new WcCounts(allFiles[i].fileName, allWcs[i], options);	
			allWcCounts[i].printCountsAsPerOptions();
		}
	}
	public void handleWcWithoutOptions(){
		for(int i=0; i<allFiles.length;i++) {
			allWcs[i] = new WcLib(allFiles[i].fileContent);
			allWcs[i].callAllCounts();
			allWcCounts[i] = new WcCounts(allFiles[i].fileName, allWcs[i]);	
			allWcCounts[i].printCounts();
		}
	}
	public static String[] getOptions(String[] args) {
		String options = new String("");
		for(String arg : args){
			if(arg.charAt(0) == '-')options += arg.charAt(1);
		}
		if(options.isEmpty()) return new String[0];
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
	public static WcFile[] readAllFiles(String[] args) throws IOException{
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

class WcCounts {
	String fileName;
	WcLib wc;
	String[] options;
	public WcCounts(String fileName, WcLib wc) {
		this.fileName = fileName;
		this.wc = wc;
	}
	public WcCounts(String fileName, WcLib wc, String[] options) {
		this.fileName = fileName;
		this.wc = wc;
		this.options = options;
	}

	public void printCounts() {
		System.out.println("\t"+wc.lineCount+"\t"+wc.wordCount+"\t"+wc.charCount+"\t"+fileName);
	}

	private String getCountStringOfOption(String previousCounts, String option) {
		switch(option){
			case "l": previousCounts += wc.lineCount + "\t";
			break;
			case "w": previousCounts += wc.wordCount + "\t";
			break;
			case "c": previousCounts += wc.charCount + "\t";
			break;
			case "L": previousCounts = wc.longestLineLength+"\t"+wc.longestLine+"\t";
			break;
			case "S": previousCounts = wc.shortestLineLength+"\t"+wc.shortestLine+"\t";
			break;
		}
		return previousCounts;
	} 

	private String getCountsAsStringAsPerOptions() {
		String counts = new String("");
		for(String option: options){
			counts = this.getCountStringOfOption(counts ,option);
		}
		return counts;
	}

	public void printCountsAsPerOptions() {
		String countsInString = this.getCountsAsStringAsPerOptions();
		countsInString += fileName;
		System.out.println(countsInString);
	}
}