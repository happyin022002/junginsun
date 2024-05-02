package com.hanjin.apps.alps.ees.dod.dodcommon.validation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

public class DodValidationINVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<DodValidationINVO> models = new ArrayList<DodValidationINVO>();
	private String sType = null;
	private String sTerm = null;
	private String sValue = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public DodValidationINVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_type", getSType());
		this.hashColumns.put("s_term", getSTerm());
		this.hashColumns.put("s_value", getSValue());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_type", "sType");
		this.hashFields.put("s_term", "sTerm");
		this.hashFields.put("s_value", "sValue");
		return this.hashFields;
	}
	public String getSType() {
		return this.sType;
	}

	public String getSTerm() {
		return this.sTerm;
	}

	public String getSValue() {
		return this.sValue;
	}

	public void setSType(String sType) {
		this.sType = sType;
	}

	public void setSTerm(String sTerm) {
		this.sTerm = sTerm;
	}

	public void setSValue(String sValue) {
		this.sValue = sValue;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setSType(JSPUtil.getParameter(request, prefix + "s_type", ""));
		setSTerm(JSPUtil.getParameter(request, prefix + "s_term", ""));
		setSValue(JSPUtil.getParameter(request, prefix + "s_value", ""));
	}

	public DodValidationINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public DodValidationINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DodValidationINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] sType = (JSPUtil.getParameter(request, prefix	+ "s_type", length));
			String[] sTerm = (JSPUtil.getParameter(request, prefix	+ "s_term", length));
			String[] sValue = (JSPUtil.getParameter(request, prefix	+ "s_value", length));
			for (int i = 0; i < length; i++) {
				model = new DodValidationINVO();
				if (sType[i] != null)
					model.setSType(sType[i]);
				if (sTerm[i] != null)
					model.setSTerm(sTerm[i]);
				if (sValue[i] != null)
					model.setSValue(sValue[i]);
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getDodValidationINVOs();
	}

	public DodValidationINVO[] getDodValidationINVOs(){
		DodValidationINVO[] vos = (DodValidationINVO[])models.toArray(new DodValidationINVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.sType = this.sType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTerm = this.sTerm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sValue = this.sValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}