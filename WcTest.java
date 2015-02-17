import static org.junit.Assert.*;
import org.junit.Test;

public class WcTest {
	@Test
	public void getLineCount_gives_2_when_we_give_the_string_that_contains_new_two_lines() {
		Wc count = new Wc("Hello \n How are You ?\n Tell");
		int lineCount = count.getLineCount();
		assertEquals(lineCount, 2);
	}
	@Test
	public void getLineCount_gives_3_when_we_give_the_string_that_contains_new_three_lines() {
		Wc count = new Wc("Hello \n How are You ?\n Tell\n");
		int lineCount = count.getLineCount();
		assertEquals(lineCount, 3);
	}
	@Test
	public void getLineCount_gives_0_when_we_give_the_string_that_contains_no_new_lines() {
		Wc count = new Wc("Hello ..........");
		int lineCount = count.getLineCount();
		assertEquals(lineCount, 0);
	}
	@Test
	public void getCharCount_gives_5_when_the_string_is_Hello() {
		Wc count = new Wc("Hello");
		int charCount = count.getCharCount();
		assertEquals(charCount, 5);
	}
	@Test
	public void getCharCount_gives_27_when_the_string_contains_27_characters_including_spaces_and_new_lines() {
		Wc count = new Wc("Hello \n How are You ?\n Tell");
		int charCount = count.getCharCount();
		assertEquals(charCount, 27);
	}
	@Test
	public void getWordCount_gives_5_when_the_string_contains_5_spaces(){
		Wc count = new Wc("Hello Hello Hello Hello Hello");
		int wordCount = count.getWordCount();
		assertEquals(wordCount, 5);
	}
	@Test
	public void getWordCount_gives_7_when_the_string_contains_7_words_in_different_lines(){
		Wc count = new Wc("Hello Hello Hello Hello Hello\nHello Hello");
		int wordCount = count.getWordCount();
		assertEquals(wordCount, 7);
	}
	@Test
	public void getWordCount_gives_7_when_the_string_contains_7_words_with_more_number_of_spaces(){
		Wc count = new Wc("Hello     Hello Hello            Hello Hello   \n    Hello Hello");
		int wordCount = count.getWordCount();
		assertEquals(wordCount, 7);
	}
	@Test
	public void getWordCount_gives_7_when_the_string_contains_7_words_with_more_number_of_tabs(){
		Wc count = new Wc("Hello		Hello Hello     \n       Hello Hello	\n 			 Hello Hello");
		int wordCount = count.getWordCount();
		assertEquals(wordCount, 7);
	}
}