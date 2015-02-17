import static org.junit.Assert.*;
import org.junit.Test;

class wcTest {
	@test
	public void getLineCount_gives_2_when_we_give_the_string_that_contains_new_two_lines() {
		Wc count = new Wc("Hello \n How are You ?\n Tell");
		int lineCount = count.getLineCount();
		assertEqual(lineCount, 2);
	}
}