public class JavaLanguage implements Language {
	private String START_COMMENT = "//";
	private String METHOD_SIGNATURE_START = "public void ";
	private String METHOD_SIGNATURE_END = "() {";
	private String METHOD_END = "}";
	private String FIELD_SCOPE = "private ";
	private String methodName;

	public String processCommentLine(final String comment) {
    	return START_COMMENT + comment;
    }

    public String processMethodStartLine(final String methodStart) {
    	return METHOD_SIGNATURE_START + methodStart + METHOD_SIGNATURE_END;
    }

    public String processFieldLine(final String field){
    	String[] fieldVal = field.trim().split("\\s+");
    	String fieldType = FIELD_SCOPE + this.formatFieldType(fieldVal[1]);
    	String fieldName = this.formatFieldName(fieldVal[0]) + ";"; 
    	return String.format("    %-10s %s",fieldType,fieldName);
    }

    public String processMethodEndLine() {
    	return METHOD_END;
    }

    private String formatFieldName(final String fieldName){
    	// convert '_' to camelCase
    	if(fieldName.contains("_")) {
    		String[] fieldNameSplit = fieldName.split("_");
    		StringBuilder sb = new StringBuilder();
    		boolean isFirst = true;
    		for (String name:fieldNameSplit) {
    			if (!isFirst) {
    				sb.append(this.capitalize(name));
    			} else {
    				sb.append(name);
    			}
    			isFirst = false;
    		}
    		return sb.toString();
    	}
    	return fieldName;
    }

    private String capitalize(final String line) {
   		return Character.toUpperCase(line.charAt(0)) + line.substring(1);
	}

    private String formatFieldType(final String fieldType) {
    	if(fieldType.contains("char[")) {
    		return "String[]";
    	}
    	return fieldType;
    }
}