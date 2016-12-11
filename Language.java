public abstract class Language {
	public abstract String processCommentLine(final String comment);
	public abstract String processMethodStartLine(final String methodStart);
    public abstract String processFieldLine(final String field);
    public abstract String processMethodEndLine();
}