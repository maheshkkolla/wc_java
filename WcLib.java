public class WcLib {
	String fileContent;
	int wordCount;
	int charCount;
	int lineCount;
	public WcLib(String data){
		fileContent = data;
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

	public void callAllCounts() {
		getLineCount();
		getCharCount();
		getWordCount();
	}

}