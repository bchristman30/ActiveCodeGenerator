public class LanguageFactory {
	public Language getLanguage(final String lang) {
		if(lang == null) {
			return null;
		} else if (lang.equals("C")) {
			return new CLanguage();
		}
		return null;
	}
}