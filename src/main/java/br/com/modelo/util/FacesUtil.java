package br.com.modelo.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static void addErrorMessage(String key) {
		addMessages(FacesMessage.SEVERITY_ERROR, getBundleValue(key));
	}

	public static void addWarningMessage(String key) {
		addMessages(FacesMessage.SEVERITY_WARN, getBundleValue(key));
	}

	public static void addSuccessMessage(String key) {
		addMessages(FacesMessage.SEVERITY_INFO, getBundleValue(key));
	}

	private static void addMessages(FacesMessage.Severity severity, String bundle) {
		final FacesMessage facesMessage = new FacesMessage(severity, bundle, "");
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setRedirect(true);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public static String getBundleValue(String key) {
		return FacesContext.getCurrentInstance()
				.getApplication()
				.getResourceBundle(FacesContext.getCurrentInstance(), "bundle")
				.getString(key);
	}

}
