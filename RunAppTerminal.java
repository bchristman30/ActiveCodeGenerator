import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;

public class RunAppTerminal {
	private final String COMMENT_FLAG = "#";
	private final String METHOD_START_FLAG = "M";
	private final String FIELD_FLAG = "F";
	private final String METHOD_END_FLAG = "E";
	private String inputFile;
	private String lang;

	public RunAppTerminal(final String inputFile, final String lang) {
		this.inputFile = inputFile;
		this.lang = lang;
	}

	public RunAppTerminal(final String inputFile) {
		this.inputFile = inputFile;
	}

	public void run() {
		boolean run = true;
		while(run) {
			System.out.println();
			System.out.println("========================================");
			System.out.println("========================================");
			System.out.println("Type a number to select a language.");
			System.out.println("Or type 0 to exit");
			System.out.println("(1)  For C");
			System.out.println("(0)  To Exit");
			String input = System.console().readLine().trim();
			if (input.equals("1")) {
				System.out.println();
				System.out.println();
				this.setLang("C");
				this.readAndProcessFile();
				System.out.println();
				System.out.println();
			} else if (input.equals("0")) {
				run = false;
			}
		}

	}

	public void readAndProcessFile() {
		List<String> filesLines = readFile(this.getInputFile());
        LanguageFactory langFactory = new LanguageFactory();
        Language lang = langFactory.getLanguage(this.getLang());
        for (String line: filesLines) {
        	System.out.println(processLine(line,lang));
        }
	}

	private String processLine(final String lineText,final Language lang) {
    	String lineFlag = lineText.substring(0,1);
    	String lineContent = lineText.substring(1);
    	String newLine;
    	if(lineFlag.equals(COMMENT_FLAG)){
    		lineContent = lang.processCommentLine(lineContent);
    	} else if(lineFlag.equals(METHOD_START_FLAG)) {
    		lineContent = lang.processMethodStartLine(lineContent);
    	} else if(lineFlag.equals(FIELD_FLAG)) {
    		lineContent = lang.processFieldLine(lineContent);
    	} else if(lineFlag.equals(METHOD_END_FLAG)) {
    		lineContent = lang.processMethodEndLine();
    	}
    	return lineContent;
    }
    
    private List<String> readFile(String filename) {
  		List<String> records = new ArrayList<String>();
  		try {
		    BufferedReader reader = new BufferedReader(new FileReader(filename));
		    String line;
		    while ((line = reader.readLine()) != null) {
		      records.add(line);
		    }
		    reader.close();
		    return records;
		}
		catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
			return null;
		}
	}

	public void setInputFile(final String inputFile) { this.inputFile = inputFile;	}
	public String getInputFile() { return this.inputFile; }
	public void setLang(final String lang){ this.lang = lang; }
	public String getLang() { return this.lang; }
}