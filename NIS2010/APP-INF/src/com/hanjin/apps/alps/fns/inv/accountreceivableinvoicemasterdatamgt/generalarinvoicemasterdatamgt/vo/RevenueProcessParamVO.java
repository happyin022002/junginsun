/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RevenueProcessParamVO.java
*@FileTitle : RevenueProcessParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.12
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.05.12 김태균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RevenueProcessParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RevenueProcessParamVO> models = new ArrayList<RevenueProcessParamVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sRlaneCd = null;
	/* Column Info */
	private String sVvdCd = null;
	/* Column Info */
	private String sEstmVvdTpCd = null;
	/* Column Info */
	private String sEstmBcDivCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String yrmonFm = null;
	/* Column Info */
	private String sSlanCd = null;
	/* Column Info */
	private String yrmonTo = null;
	/* Column Info */
	private String optionValue = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RevenueProcessParamVO() {}

	public RevenueProcessParamVO(String ibflag, String pagerows, String optionValue, String yrmonFm, String yrmonTo, String delCd, String sVvdCd, String sSlanCd, String sRlaneCd, String sEstmBcDivCd, String sEstmVvdTpCd) {
		this.ibflag = ibflag;
		this.sRlaneCd = sRlaneCd;
		this.sVvdCd = sVvdCd;
		this.sEstmVvdTpCd = sEstmVvdTpCd;
		this.sEstmBcDivCd = sEstmBcDivCd;
		this.delCd = delCd;
		this.yrmonFm = yrmonFm;
		this.sSlanCd = sSlanCd;
		this.yrmonTo = yrmonTo;
		this.optionValue = optionValue;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_rlane_cd", getSRlaneCd());
		this.hashColumns.put("s_vvd_cd", getSVvdCd());
		this.hashColumns.put("s_estm_vvd_tp_cd", getSEstmVvdTpCd());
		this.hashColumns.put("s_estm_bc_div_cd", getSEstmBcDivCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("yrmon_fm", getYrmonFm());
		this.hashColumns.put("s_slan_cd", getSSlanCd());
		this.hashColumns.put("yrmon_to", getYrmonTo());
		this.hashColumns.put("option_value", getOptionValue());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_rlane_cd", "sRlaneCd");
		this.hashFields.put("s_vvd_cd", "sVvdCd");
		this.hashFields.put("s_estm_vvd_tp_cd", "sEstmVvdTpCd");
		this.hashFields.put("s_estm_bc_div_cd", "sEstmBcDivCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("yrmon_fm", "yrmonFm");
		this.hashFields.put("s_slan_cd", "sSlanCd");
		this.hashFields.put("yrmon_to", "yrmonTo");
		this.hashFields.put("option_value", "optionValue");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return sRlaneCd
	 */
	public String getSRlaneCd() {
		return this.sRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return sVvdCd
	 */
	public String getSVvdCd() {
		return this.sVvdCd;
	}
	
	/**
	 * Column Info
	 * @return sEstmVvdTpCd
	 */
	public String getSEstmVvdTpCd() {
		return this.sEstmVvdTpCd;
	}
	
	/**
	 * Column Info
	 * @return sEstmBcDivCd
	 */
	public String getSEstmBcDivCd() {
		return this.sEstmBcDivCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return yrmonFm
	 */
	public String getYrmonFm() {
		return this.yrmonFm;
	}
	
	/**
	 * Column Info
	 * @return sSlanCd
	 */
	public String getSSlanCd() {
		return this.sSlanCd;
	}
	
	/**
	 * Column Info
	 * @return yrmonTo
	 */
	public String getYrmonTo() {
		return this.yrmonTo;
	}
	
	/**
	 * Column Info
	 * @return optionValue
	 */
	public String getOptionValue() {
		return this.optionValue;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param sRlaneCd
	 */
	public void setSRlaneCd(String sRlaneCd) {
		this.sRlaneCd = sRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param sVvdCd
	 */
	public void setSVvdCd(String sVvdCd) {
		this.sVvdCd = sVvdCd;
	}
	
	/**
	 * Column Info
	 * @param sEstmVvdTpCd
	 */
	public void setSEstmVvdTpCd(String sEstmVvdTpCd) {
		this.sEstmVvdTpCd = sEstmVvdTpCd;
	}
	
	/**
	 * Column Info
	 * @param sEstmBcDivCd
	 */
	public void setSEstmBcDivCd(String sEstmBcDivCd) {
		this.sEstmBcDivCd = sEstmBcDivCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param yrmonFm
	 */
	public void setYrmonFm(String yrmonFm) {
		this.yrmonFm = yrmonFm;
	}
	
	/**
	 * Column Info
	 * @param sSlanCd
	 */
	public void setSSlanCd(String sSlanCd) {
		this.sSlanCd = sSlanCd;
	}
	
	/**
	 * Column Info
	 * @param yrmonTo
	 */
	public void setYrmonTo(String yrmonTo) {
		this.yrmonTo = yrmonTo;
	}
	
	/**
	 * Column Info
	 * @param optionValue
	 */
	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSRlaneCd(JSPUtil.getParameter(request, prefix + "s_rlane_cd", ""));
		setSVvdCd(JSPUtil.getParameter(request, prefix + "s_vvd_cd", ""));
		setSEstmVvdTpCd(JSPUtil.getParameter(request, prefix + "s_estm_vvd_tp_cd", ""));
		setSEstmBcDivCd(JSPUtil.getParameter(request, prefix + "s_estm_bc_div_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setYrmonFm(JSPUtil.getParameter(request, prefix + "yrmon_fm", ""));
		setSSlanCd(JSPUtil.getParameter(request, prefix + "s_slan_cd", ""));
		setYrmonTo(JSPUtil.getParameter(request, prefix + "yrmon_to", ""));
		setOptionValue(JSPUtil.getParameter(request, prefix + "option_value", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RevenueProcessParamVO[]
	 */
	public RevenueProcessParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RevenueProcessParamVO[]
	 */
	public RevenueProcessParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RevenueProcessParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sRlaneCd = (JSPUtil.getParameter(request, prefix	+ "s_rlane_cd", length));
			String[] sVvdCd = (JSPUtil.getParameter(request, prefix	+ "s_vvd_cd", length));
			String[] sEstmVvdTpCd = (JSPUtil.getParameter(request, prefix	+ "s_estm_vvd_tp_cd", length));
			String[] sEstmBcDivCd = (JSPUtil.getParameter(request, prefix	+ "s_estm_bc_div_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] yrmonFm = (JSPUtil.getParameter(request, prefix	+ "yrmon_fm", length));
			String[] sSlanCd = (JSPUtil.getParameter(request, prefix	+ "s_slan_cd", length));
			String[] yrmonTo = (JSPUtil.getParameter(request, prefix	+ "yrmon_to", length));
			String[] optionValue = (JSPUtil.getParameter(request, prefix	+ "option_value", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RevenueProcessParamVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sRlaneCd[i] != null)
					model.setSRlaneCd(sRlaneCd[i]);
				if (sVvdCd[i] != null)
					model.setSVvdCd(sVvdCd[i]);
				if (sEstmVvdTpCd[i] != null)
					model.setSEstmVvdTpCd(sEstmVvdTpCd[i]);
				if (sEstmBcDivCd[i] != null)
					model.setSEstmBcDivCd(sEstmBcDivCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (yrmonFm[i] != null)
					model.setYrmonFm(yrmonFm[i]);
				if (sSlanCd[i] != null)
					model.setSSlanCd(sSlanCd[i]);
				if (yrmonTo[i] != null)
					model.setYrmonTo(yrmonTo[i]);
				if (optionValue[i] != null)
					model.setOptionValue(optionValue[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRevenueProcessParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RevenueProcessParamVO[]
	 */
	public RevenueProcessParamVO[] getRevenueProcessParamVOs(){
		RevenueProcessParamVO[] vos = (RevenueProcessParamVO[])models.toArray(new RevenueProcessParamVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRlaneCd = this.sRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvdCd = this.sVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEstmVvdTpCd = this.sEstmVvdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEstmBcDivCd = this.sEstmBcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrmonFm = this.yrmonFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSlanCd = this.sSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrmonTo = this.yrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optionValue = this.optionValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
