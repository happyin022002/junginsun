/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EQForecastSummaryINVO.java
*@FileTitle : EQForecastSummaryINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo;

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

public class EQForecastSummaryINVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<EQForecastSummaryINVO> models = new ArrayList<EQForecastSummaryINVO>();
	private String pagerows = null;
	private String ibflag = null;
	private String sRccCd = null;
	private String sLocGrpCd = null;
	private String sLocCd = null;
	private String sHulBndCd = null;
	private String fcastYrwk = null;
	private String sOptionCd = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public EQForecastSummaryINVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_rcc_cd", getSRccCd());
		this.hashColumns.put("s_loc_grp_cd", getSLocGrpCd());
		this.hashColumns.put("s_loc_cd", getSLocCd());
		this.hashColumns.put("s_hul_bnd_cd", getSHulBndCd());
		this.hashColumns.put("fcast_yrwk", getFcastYrwk());
		this.hashColumns.put("s_option_cd", getsOptionCd());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_rcc_cd", "sRccCd");
		this.hashFields.put("s_loc_grp_cd", "sLocGrpCd");
		this.hashFields.put("s_loc_cd", "sLocCd");
		this.hashFields.put("s_hul_bnd_cd", "sHulBndCd");
		this.hashFields.put("fcast_yrwk", "fcastYrwk");
		this.hashFields.put("s_option_cd", "sOptionCd");
		return this.hashFields;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public String getIbflag() {
		return this.ibflag;
	}

	public String getSRccCd() {
		return this.sRccCd;
	}

	public String getSLocGrpCd() {
		return this.sLocGrpCd;
	}

	public String getSLocCd() {
		return this.sLocCd;
	}

	public String getSHulBndCd() {
		return this.sHulBndCd;
	}

	public String getFcastYrwk() {
		return this.fcastYrwk;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public void setSRccCd(String sRccCd) {
		this.sRccCd = sRccCd;
	}

	public void setSLocGrpCd(String sLocGrpCd) {
		this.sLocGrpCd = sLocGrpCd;
	}

	public void setSLocCd(String sLocCd) {
		this.sLocCd = sLocCd;
	}

	public void setSHulBndCd(String sHulBndCd) {
		this.sHulBndCd = sHulBndCd;
	}

	public void setFcastYrwk(String fcastYrwk) {
		this.fcastYrwk = fcastYrwk;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSRccCd(JSPUtil.getParameter(request, prefix + "s_rcc_cd", ""));
		setSLocGrpCd(JSPUtil.getParameter(request, prefix + "s_loc_grp_cd", ""));
		setSLocCd(JSPUtil.getParameter(request, prefix + "s_loc_cd", ""));
		setSHulBndCd(JSPUtil.getParameter(request, prefix + "s_hul_bnd_cd", ""));
		setFcastYrwk(JSPUtil.getParameter(request, prefix + "fcast_yrwk", ""));
		setsOptionCd(JSPUtil.getParameter(request, prefix + "s_option_cd", ""));
	}

	public EQForecastSummaryINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public EQForecastSummaryINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EQForecastSummaryINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sRccCd = (JSPUtil.getParameter(request, prefix	+ "s_rcc_cd", length));
			String[] sLocGrpCd = (JSPUtil.getParameter(request, prefix	+ "s_loc_grp_cd", length));
			String[] sLocCd = (JSPUtil.getParameter(request, prefix	+ "s_loc_cd", length));
			String[] sHulBndCd = (JSPUtil.getParameter(request, prefix	+ "s_hul_bnd_cd", length));
			String[] fcastYrwk = (JSPUtil.getParameter(request, prefix	+ "fcast_yrwk", length));
			String[] sOptionCd = (JSPUtil.getParameter(request, prefix	+ "s_option_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EQForecastSummaryINVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sRccCd[i] != null)
					model.setSRccCd(sRccCd[i]);
				if (sLocGrpCd[i] != null)
					model.setSLocGrpCd(sLocGrpCd[i]);
				if (sLocCd[i] != null)
					model.setSLocCd(sLocCd[i]);
				if (sHulBndCd[i] != null)
					model.setSHulBndCd(sHulBndCd[i]);
				if (fcastYrwk[i] != null)
					model.setFcastYrwk(fcastYrwk[i]);
				if (sOptionCd[i] != null)
					model.setsOptionCd(sOptionCd[i]);				
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getEQForecastSummaryINVOs();
	}

	public EQForecastSummaryINVO[] getEQForecastSummaryINVOs(){
		EQForecastSummaryINVO[] vos = (EQForecastSummaryINVO[])models.toArray(new EQForecastSummaryINVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRccCd = this.sRccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLocGrpCd = this.sLocGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLocCd = this.sLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sHulBndCd = this.sHulBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastYrwk = this.fcastYrwk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOptionCd = this.sOptionCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getsOptionCd() {
		return sOptionCd;
	}

	public void setsOptionCd(String sOptionCd) {
		this.sOptionCd = sOptionCd;
	}
}