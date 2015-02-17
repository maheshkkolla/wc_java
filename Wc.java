public class Wc {
	String fileContent;
	public Wc(String data){
		fileContent = data;
	}

	public int getLineCount(){
		int count = 0;
		for (int i = 0; i < this.getCharCount() ;i++ ) {
			if(fileContent.charAt(i) == '\n')count++;
		}
		return count;
	}

	public int getCharCount() {
		return fileContent.length();
	}

	public int getWordCount() {
		String str = fileContent.replaceAll("\\s+", " ");
		String[] words = str.split(" ");
		return words.length;
	}
}