import java.util.HashMap;
import java.util.Map;

public class CLanguage extends Language {
	public CLanguage() {
		comment = new HashMap();
		comment.put("startComment", "/*");
		comment.put("endComment", "*/");
	}

	public String writeComment() {
		return "we did it! " + comment.get("startComment");
	}
}