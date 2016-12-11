public class LanguageFactory {
	public Language getLanguage(final String lang) {
		if(lang == null) {
			return null;
		} else if (lang.equals("C")) {
			return new CLanguage();
		} else if (lang.equals("Java")) {
			return new JavaLanguage();
		}
		return null;
	}
}