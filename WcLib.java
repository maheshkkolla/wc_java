public class WcLib {
	String fileContent;
	int wordCount;
	int charCount;
	int lineCount;
	int longestLineLength;
	String longestLine;
	public WcLib(String data){
		fileContent = data;
		longestLineLength = 0;
	}

	public int getLineCount(){
		int count = 0;
		for (int i = 0; i < this.getCharCount()-1 ;i++ ) {
			if(fileContent.substring(i,i+2).equals("\r\n"))count++;
		}
		lineCount = count;
		return count;
	}

	public int getCharCount() {
		charCount = fileContent.length();
		return charCount;
	}

	public int getWordCount() {
		String str = fileContent.replaceAll("\\s+", " ");
		String[] words = str.split(" ");
		wordCount = words.length;
		return wordCount;
	}

	public int getLongestLineLength() {
		String[] lines = this.fileContent.split("\r\n");
		for(String line: lines){
			if(line.length() > longestLineLength){
				longestLineLength = line.length();
				longestLine = line;
			}
		}
		return longestLineLength;
	}

	public void callAllCounts() {
		getLineCount();
		getCharCount();
		getWordCount();
		getLongestLineLength();
	}

}