public class CLanguage implements Language {
	private String START_COMMENT = "/*";
	private String END_COMMENT = "*/";
	private String METHOD_START = "typedef struct {";
	private String methodName;

	public String processCommentLine(String comment) {
    	return START_COMMENT + comment + END_COMMENT;
    }

    public String processMethodStartLine(String methodStart) {
    	this.setMethodName(methodStart); // save method name for end of method declaration
    	return METHOD_START;
    }

    public String processFieldLine(String field){
    	String[] fieldVal = field.trim().split("\\s+"); 
    	return String.format("    %-10s %s",fieldVal[1],fieldVal[0]);
    }

    public String processMethodEndLine() {
    	return "} " + this.getMethodName() + "msg";
    }

    public void setMethodName(final String methodName) {
    	this.methodName = methodName;
    }

    public String getMethodName() {
    	return this.methodName;
    }
}