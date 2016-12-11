public interface Language {
	public String processCommentLine(final String comment);
	public String processMethodStartLine(final String methodStart);
    public String processFieldLine(final String field);
    public String processMethodEndLine();
}