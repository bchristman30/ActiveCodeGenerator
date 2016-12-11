import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;

public class RunAppTerminal {
	private String inputFile;
	private String lang;

	public RunAppTerminal(final String inputFile, final String lang) {
		this.inputFile = inputFile;
		this.lang = lang;
	}

	public RunAppTerminal(final String inputFile) {
		this.inputFile = inputFile;
		this.lang = "C";
	}

	public void run() {
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
    	if(lineFlag.equals("#")){
    		lineContent = lang.processCommentLine(lineContent);
    	} else if(lineFlag.equals("M")) {
    		lineContent = lang.processMethodStartLine(lineContent);
    	} else if(lineFlag.equals("F")) {
    		lineContent = lang.processFieldLine(lineContent);
    	} else if(lineFlag.equals("E")) {
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