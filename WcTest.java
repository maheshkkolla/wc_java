import static org.junit.Assert.*;
import org.junit.Test;
public class WcTest {
	@Test
	public void getNoOfFiles_gives_the_number_number_of_arguments_if_it_contains_only_file_names() {
		String[] args = {"one", "two", "three"};
		int count = Wc.getNoOfFiles(args);
		assertEquals(count,3);
	} 
	@Test
	public void getNoOfFiles_gives_the_number_of_files_even_arguments_contains_files_and_options() {
		String[] args = {"one","-l","two","-c","-b","three","four"};
		int count = Wc.getNoOfFiles(args);
		assertEquals(count,4);
	}
	@Test
	public void getOptions_gives_the_options_as_string_array() {
		String[] args = {"-l","-c","-b","-w"};
		String[] optionsExpected = {"l","c","b","w"};
		String[] options = Wc.getOptions(args);
		assertEquals(options, optionsExpected);
	}
	@Test
	public void getOptions_gives_the_options_as_string_array_by_excluding_the_file_names() {
		String[] args = {"one","-l","two","-c","-b","three","four","-w"};
		String[] optionsExpected = {"l","c","b","w"};
		String[] options = Wc.getOptions(args);
		assertEquals(options, optionsExpected);
	}
	@Test
	public void getFileNames_gives_the_all_fileNames_sent_as_arguments() {
		String[] args = {"one","two","three"};
		assertEquals(Wc.getFileNames(args), args);
	}
	@Test
	public void getFileNames_gives_the_all_fileNames_sent_as_arguments_by_excluding_the_options() {
		String[] args = {"one","-l","two","-c","-b","three","four","-w"};
		String[] expectedFileNames = {"one","two","three","four"};
		assertEquals(Wc.getFileNames(args), expectedFileNames);
	}
}