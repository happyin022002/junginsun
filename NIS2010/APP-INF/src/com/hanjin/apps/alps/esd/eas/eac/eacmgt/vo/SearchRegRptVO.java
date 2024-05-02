/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchRegRptVO.java
*@FileTitle : SearchRegRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo;

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

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 백형인
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRegRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRegRptVO> models = new ArrayList<SearchRegRptVO>();
	
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String sEacYrmonFm = null;
	/* Column Info */
	private String sEacYrmonTo = null;
	/* Column Info */
	private String sRnkDivCd = null;
	/* Column Info */
	private String sEacRsnCd = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sEacTpCd = null;
	/* Column Info */
	private String sOfcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sCalVal = null;
	/* Column Info */
	private String sEacAproTpCd = null;
	/* Column Info */
	private String sEacExpnTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchRegRptVO() {}

	public SearchRegRptVO(String ibflag, String pagerows, String sEacYrmonFm, String sEacYrmonTo, String sRhqOfcCd, String sOfcCd, String sCalVal, String sEacTpCd, String sEacAproTpCd, String sRnkDivCd, String sOfcTpCd, String sEacRsnCd, String sEacExpnTpCd) {
		this.sRhqOfcCd = sRhqOfcCd;
		this.sEacYrmonFm = sEacYrmonFm;
		this.sEacYrmonTo = sEacYrmonTo;
		this.sRnkDivCd = sRnkDivCd;
		this.sEacRsnCd = sEacRsnCd;
		this.sOfcCd = sOfcCd;
		this.pagerows = pagerows;
		this.sEacTpCd = sEacTpCd;
		this.sOfcTpCd = sOfcTpCd;
		this.ibflag = ibflag;
		this.sCalVal = sCalVal;
		this.sEacAproTpCd = sEacAproTpCd;
		this.sEacExpnTpCd = sEacExpnTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("s_eac_yrmon_fm", getSEacYrmonFm());
		this.hashColumns.put("s_eac_yrmon_to", getSEacYrmonTo());
		this.hashColumns.put("s_rnk_div_cd", getSRnkDivCd());
		this.hashColumns.put("s_eac_rsn_cd", getSEacRsnCd());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_eac_tp_cd", getSEacTpCd());
		this.hashColumns.put("s_ofc_tp_cd", getSOfcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_cal_val", getSCalVal());
		this.hashColumns.put("s_eac_apro_tp_cd", getSEacAproTpCd());
		this.hashColumns.put("s_eac_expn_tp_cd", getSEacExpnTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("s_eac_yrmon_fm", "sEacYrmonFm");
		this.hashFields.put("s_eac_yrmon_to", "sEacYrmonTo");
		this.hashFields.put("s_rnk_div_cd", "sRnkDivCd");
		this.hashFields.put("s_eac_rsn_cd", "sEacRsnCd");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_eac_tp_cd", "sEacTpCd");
		this.hashFields.put("s_ofc_tp_cd", "sOfcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_cal_val", "sCalVal");
		this.hashFields.put("s_eac_apro_tp_cd", "sEacAproTpCd");
		this.hashFields.put("s_eac_expn_tp_cd", "sEacExpnTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sRhqOfcCd
	 */
	public String getSRhqOfcCd() {
		return this.sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sEacYrmonFm
	 */
	public String getSEacYrmonFm() {
		return this.sEacYrmonFm;
	}
	
	/**
	 * Column Info
	 * @return sEacYrmonTo
	 */
	public String getSEacYrmonTo() {
		return this.sEacYrmonTo;
	}
	
	/**
	 * Column Info
	 * @return sRnkDivCd
	 */
	public String getSRnkDivCd() {
		return this.sRnkDivCd;
	}
	
	/**
	 * Column Info
	 * @return sEacRsnCd
	 */
	public String getSEacRsnCd() {
		return this.sEacRsnCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return sEacTpCd
	 */
	public String getSEacTpCd() {
		return this.sEacTpCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcTpCd
	 */
	public String getSOfcTpCd() {
		return this.sOfcTpCd;
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
	 * @return sCalVal
	 */
	public String getSCalVal() {
		return this.sCalVal;
	}
	
	/**
	 * Column Info
	 * @return sEacAproTpCd
	 */
	public String getSEacAproTpCd() {
		return this.sEacAproTpCd;
	}
	
	/**
	 * Column Info
	 * @return sEacExpnTpCd
	 */
	public String getSEacExpnTpCd() {
		return this.sEacExpnTpCd;
	}
	

	/**
	 * Column Info
	 * @param sRhqOfcCd
	 */
	public void setSRhqOfcCd(String sRhqOfcCd) {
		this.sRhqOfcCd = sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sEacYrmonFm
	 */
	public void setSEacYrmonFm(String sEacYrmonFm) {
		this.sEacYrmonFm = sEacYrmonFm;
	}
	
	/**
	 * Column Info
	 * @param sEacYrmonTo
	 */
	public void setSEacYrmonTo(String sEacYrmonTo) {
		this.sEacYrmonTo = sEacYrmonTo;
	}
	
	/**
	 * Column Info
	 * @param sRnkDivCd
	 */
	public void setSRnkDivCd(String sRnkDivCd) {
		this.sRnkDivCd = sRnkDivCd;
	}
	
	/**
	 * Column Info
	 * @param sEacRsnCd
	 */
	public void setSEacRsnCd(String sEacRsnCd) {
		this.sEacRsnCd = sEacRsnCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param sEacTpCd
	 */
	public void setSEacTpCd(String sEacTpCd) {
		this.sEacTpCd = sEacTpCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcTpCd
	 */
	public void setSOfcTpCd(String sOfcTpCd) {
		this.sOfcTpCd = sOfcTpCd;
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
	 * @param sCalVal
	 */
	public void setSCalVal(String sCalVal) {
		this.sCalVal = sCalVal;
	}
	
	/**
	 * Column Info
	 * @param sEacAproTpCd
	 */
	public void setSEacAproTpCd(String sEacAproTpCd) {
		this.sEacAproTpCd = sEacAproTpCd;
	}
	
	/**
	 * Column Info
	 * @param sEacExpnTpCd
	 */
	public void setSEacExpnTpCd(String sEacExpnTpCd) {
		this.sEacExpnTpCd = sEacExpnTpCd;
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
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setSEacYrmonFm(JSPUtil.getParameter(request, prefix + "s_eac_yrmon_fm", ""));
		setSEacYrmonTo(JSPUtil.getParameter(request, prefix + "s_eac_yrmon_to", ""));
		setSRnkDivCd(JSPUtil.getParameter(request, prefix + "s_rnk_div_cd", ""));
		setSEacRsnCd(JSPUtil.getParameter(request, prefix + "s_eac_rsn_cd", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSEacTpCd(JSPUtil.getParameter(request, prefix + "s_eac_tp_cd", ""));
		setSOfcTpCd(JSPUtil.getParameter(request, prefix + "s_ofc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSCalVal(JSPUtil.getParameter(request, prefix + "s_cal_val", ""));
		setSEacAproTpCd(JSPUtil.getParameter(request, prefix + "s_eac_apro_tp_cd", ""));
		setSEacExpnTpCd(JSPUtil.getParameter(request, prefix + "s_eac_expn_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRegRptVO[]
	 */
	public SearchRegRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRegRptVO[]
	 */
	public SearchRegRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRegRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] sEacYrmonFm = (JSPUtil.getParameter(request, prefix	+ "s_eac_yrmon_fm", length));
			String[] sEacYrmonTo = (JSPUtil.getParameter(request, prefix	+ "s_eac_yrmon_to", length));
			String[] sRnkDivCd = (JSPUtil.getParameter(request, prefix	+ "s_rnk_div_cd", length));
			String[] sEacRsnCd = (JSPUtil.getParameter(request, prefix	+ "s_eac_rsn_cd", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sEacTpCd = (JSPUtil.getParameter(request, prefix	+ "s_eac_tp_cd", length));
			String[] sOfcTpCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sCalVal = (JSPUtil.getParameter(request, prefix	+ "s_cal_val", length));
			String[] sEacAproTpCd = (JSPUtil.getParameter(request, prefix	+ "s_eac_apro_tp_cd", length));
			String[] sEacExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "s_eac_expn_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRegRptVO();
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (sEacYrmonFm[i] != null)
					model.setSEacYrmonFm(sEacYrmonFm[i]);
				if (sEacYrmonTo[i] != null)
					model.setSEacYrmonTo(sEacYrmonTo[i]);
				if (sRnkDivCd[i] != null)
					model.setSRnkDivCd(sRnkDivCd[i]);
				if (sEacRsnCd[i] != null)
					model.setSEacRsnCd(sEacRsnCd[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sEacTpCd[i] != null)
					model.setSEacTpCd(sEacTpCd[i]);
				if (sOfcTpCd[i] != null)
					model.setSOfcTpCd(sOfcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sCalVal[i] != null)
					model.setSCalVal(sCalVal[i]);
				if (sEacAproTpCd[i] != null)
					model.setSEacAproTpCd(sEacAproTpCd[i]);
				if (sEacExpnTpCd[i] != null)
					model.setSEacExpnTpCd(sEacExpnTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRegRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRegRptVO[]
	 */
	public SearchRegRptVO[] getSearchRegRptVOs(){
		SearchRegRptVO[] vos = (SearchRegRptVO[])models.toArray(new SearchRegRptVO[models.size()]);
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
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacYrmonFm = this.sEacYrmonFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacYrmonTo = this.sEacYrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRnkDivCd = this.sRnkDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacRsnCd = this.sEacRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacTpCd = this.sEacTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcTpCd = this.sOfcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCalVal = this.sCalVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacAproTpCd = this.sEacAproTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacExpnTpCd = this.sEacExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
