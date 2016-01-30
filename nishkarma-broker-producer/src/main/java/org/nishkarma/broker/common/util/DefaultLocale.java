/**
 * Nishkarma EAI Project
 */
package org.nishkarma.broker.common.util;

import java.util.Locale;

/** <pre>
 * 
 * </pre>
 * @Company freelsj
 * @Author lee suk jae
 * @Date 2015. 5. 7. 오전 10:29:33
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date____________Auther________Desc.________________________________
 *          2015. 5. 7.     lee suk jae
 *          -------------------------------------------------------------------
 */

public class DefaultLocale {

	
	private static String defaultLanguage = "en";
	
	
	public static Locale resolveLocale() {
		
		Locale locale =  new Locale(defaultLanguage);
		return locale;
	}


	/**
	 * @return the defaultLanguage
	 */
	public String getDefaultLanguage() {
		return defaultLanguage;
	}


	/**
	 * @param defaultLanguage the defaultLanguage to set
	 */
	public void setDefaultLanguage(String defaultLanguage) {
		DefaultLocale.defaultLanguage = defaultLanguage;
	}
	
	
}
