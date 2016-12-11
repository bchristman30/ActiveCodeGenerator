import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;

public class ActiveCodeGenerator {

	public static String methodName;

    public static void main(String[] args) {
        String filename = args[0];
        //String language = args[1];
        List<String> filesLines = readFile(filename);
        LanguageFactory langFactory = new LanguageFactory();
        Language lang = langFactory.getLanguage("C");
        for (String line: filesLines) {
        	System.out.println(processLine(line,lang));
        }
    }

    private static String processLine(final String lineText,final Language lang) {
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
    
    private static List<String> readFile(String filename) {
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
}