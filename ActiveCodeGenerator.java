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
        for (String line: filesLines) {
        	System.out.println(processLine(line));
        }
    }

    private static String processLine(String lineText) {
    	String lineFlag = lineText.substring(0,1);
    	String lineContent = lineText.substring(1);
    	String newLine;
    	if(lineFlag.equals("#")){
    		lineContent = processCommentLine(lineContent);
    	} else if(lineFlag.equals("M")) {
    		methodName = lineContent;
    		lineContent = processMethodStartLine(lineContent);
    	} else if(lineFlag.equals("F")) {
    		lineContent = processFieldLine(lineContent);
    	} else if(lineFlag.equals("E")) {
    		lineContent = processMethodEndLine();
    	}
    	return lineContent;
    }

    private static String processCommentLine(String comment) {
    	return "/*" + comment + " */";
    }

    private static String processMethodStartLine(String methodStart) {
    	return "typedef struct {";
    }

    private static String processFieldLine(String field){
    	String[] fieldVal = field.trim().split("\\s+"); 
    	return String.format("   %-10s %s",fieldVal[1],fieldVal[0]);
    }

    private static String processMethodEndLine() {
    	return "} " + methodName + "msg";
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