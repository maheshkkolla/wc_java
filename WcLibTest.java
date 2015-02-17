import static org.junit.Assert.*;
import org.junit.Test;

public class WcLibTest {
	@Test
	public void getLineCount_gives_2_when_we_give_the_string_that_contains_new_two_lines() {
		WcLib count = new WcLib("Hello \r\n How are You ?\r\n Tell");
		int lineCount = count.getLineCount();
		assertEquals(lineCount, 2);
	}
	@Test
	public void getLineCount_gives_3_when_we_give_the_string_that_contains_new_three_lines() {
		WcLib count = new WcLib("Hello \r\n How are You ?\r\n Tell\r\n");
		int lineCount = count.getLineCount();
		assertEquals(lineCount, 3);
	}
	@Test
	public void getLineCount_gives_0_when_we_give_the_string_that_contains_no_new_lines() {
		WcLib count = new WcLib("Hello ..........");
		int lineCount = count.getLineCount();
		assertEquals(lineCount, 0);
	}
	@Test
	public void getCharCount_gives_5_when_the_string_is_Hello() {
		WcLib count = new WcLib("Hello");
		int charCount = count.getCharCount();
		assertEquals(charCount, 5);
	}
	@Test
	public void getCharCount_gives_27_when_the_string_contains_27_characters_including_spaces_and_new_lines() {
		WcLib count = new WcLib("Hello \r\n How are You ?\r\n Tell");
		int charCount = count.getCharCount();
		assertEquals(charCount, 29);
	}
	@Test
	public void getWordCount_gives_5_when_the_string_contains_5_spaces(){
		WcLib count = new WcLib("Hello Hello Hello Hello Hello");
		int wordCount = count.getWordCount();
		assertEquals(wordCount, 5);
	}
	@Test
	public void getWordCount_gives_7_when_the_string_contains_7_words_in_different_lines(){
		WcLib count = new WcLib("Hello Hello Hello Hello Hello\r\nHello Hello");
		int wordCount = count.getWordCount();
		assertEquals(wordCount, 7);
	}
	@Test
	public void getWordCount_gives_7_when_the_string_contains_7_words_with_more_number_of_spaces(){
		WcLib count = new WcLib("Hello     Hello Hello            Hello Hello   \r\n    Hello Hello");
		int wordCount = count.getWordCount();
		assertEquals(wordCount, 7);
	}
	@Test
	public void getWordCount_gives_7_when_the_string_contains_7_words_with_more_number_of_tabs(){
		WcLib count = new WcLib("Hello		Hello Hello     \r\n       Hello Hello	\r\n 			 Hello Hello");
		int wordCount = count.getWordCount();
		assertEquals(wordCount, 7);
	}
}