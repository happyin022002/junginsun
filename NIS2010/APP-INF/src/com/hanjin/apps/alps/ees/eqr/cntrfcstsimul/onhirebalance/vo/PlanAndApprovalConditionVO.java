/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PlanAndApprovalConditionVO.java
*@FileTitle : PlanAndApprovalConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.19
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.08.19 문동선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.vo;

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
 * @author 문동선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PlanAndApprovalConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PlanAndApprovalConditionVO> models = new ArrayList<PlanAndApprovalConditionVO>();
	
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String rccCd = null;	
	/* Column Info */
	private String lccCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	
	/* Column Info */
	private String divFlag = null;	
	/* Column Info */
	private String yrwk = null;
	/* Column Info */
	private String periodtp = null;
	/* Column Info */
	private String fmperiod = null;	
	/* Column Info */
	private String toperiod = null;
	
	/* Column Info */
	private String yrwk_pkup = null;
	/* Column Info */
	private String periodtp_pkup = null;
	/* Column Info */
	private String fmperiod_pkup = null;	
	/* Column Info */
	private String toperiod_pkup = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PlanAndApprovalConditionVO() {}

	public PlanAndApprovalConditionVO(String ibflag, String pagerows, String divFlag, String yrwk, String periodtp, String fmperiod, String toperiod, String rccCd, String lccCd, String stsCd
			, String yrwk_pkup, String periodtp_pkup, String fmperiod_pkup, String toperiod_pkup) {
		this.stsCd = stsCd;


		this.rccCd = rccCd;		
		this.lccCd = lccCd;
		this.ibflag = ibflag;

		this.divFlag = divFlag;
		this.yrwk = yrwk;
		this.periodtp = periodtp;
		this.fmperiod = fmperiod;		
		this.toperiod = toperiod;
		
		this.yrwk_pkup = yrwk_pkup;
		this.periodtp_pkup = periodtp_pkup;
		this.fmperiod_pkup = fmperiod_pkup;		
		this.toperiod_pkup = toperiod_pkup;		
		
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sts_cd", getStsCd());

		this.hashColumns.put("div_flag", getDivFlag());
		this.hashColumns.put("rcc_cd", getRccCd());		
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("ibflag", getIbflag());
		
		this.hashColumns.put("yrwk", getYrwk());
		this.hashColumns.put("periodtp", getPeriodtp());
		this.hashColumns.put("fmperiod", getFmperiod());		
		this.hashColumns.put("toperiod", getToperiod());
		
		this.hashColumns.put("yrwk_pkup", getYrwkPkup());
		this.hashColumns.put("periodtp_pkup", getPeriodtpPkup());
		this.hashColumns.put("fmperiod_pkup", getFmperiodPkup());		
		this.hashColumns.put("toperiod_pkup", getToperiodPkup());		
		
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sts_cd", "stsCd");

		this.hashFields.put("div_flag", "divFlag");
		this.hashFields.put("rcc_cd", "rccCd");		
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("ibflag", "ibflag");
		
		this.hashFields.put("yrwk", "yrwk");
		this.hashFields.put("periodtp", "periodtp");
		this.hashFields.put("fmperiod", "fmperiod");		
		this.hashFields.put("toperiod", "toperiod");
		
		this.hashFields.put("yrwk_pkup", "yrwk_pkup");
		this.hashFields.put("periodtp_pkup", "periodtp_pkup");
		this.hashFields.put("fmperiod_pkup", "fmperiod_pkup");		
		this.hashFields.put("toperiod_pkup", "toperiod_pkup");
		
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
	}
	
	/**
	 * Column Info
	 * @return fmperiod
	 */
	public String getFmperiod() {
		return this.fmperiod;
	}
	
	/**
	 * Column Info
	 * @return fmperiod
	 */
	public String getFmperiodPkup() {
		return this.fmperiod_pkup;
	}	
	
	/**
	 * Column Info
	 * @return divFlag
	 */
	public String getDivFlag() {
		return this.divFlag;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
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
	 * @return yrwk
	 */
	public String getYrwk() {
		return this.yrwk;
	}
	
	/**
	 * Column Info
	 * @return yrwk
	 */
	public String getYrwkPkup() {
		return this.yrwk_pkup;
	}	
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return periodtp
	 */
	public String getPeriodtp() {
		return this.periodtp;
	}
	
	/**
	 * Column Info
	 * @return periodtp
	 */
	public String getPeriodtpPkup() {
		return this.periodtp_pkup;
	}	
	
	/**
	 * Column Info
	 * @return toperiod
	 */
	public String getToperiod() {
		return this.toperiod;
	}
	
	/**
	 * Column Info
	 * @return toperiod
	 */
	public String getToperiodPkup() {
		return this.toperiod_pkup;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}
	
	/**
	 * Column Info
	 * @param fmperiod
	 */
	public void setFmperiod(String fmperiod) {
		this.fmperiod = fmperiod;
	}
	
	/**
	 * Column Info
	 * @param fmperiod
	 */
	public void setFmperiodPkup(String fmperiod_pkup) {
		this.fmperiod_pkup = fmperiod_pkup;
	}	
	
	/**
	 * Column Info
	 * @param divFlag
	 */
	public void setDivFlag(String divFlag) {
		this.divFlag = divFlag;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
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
	 * @param yrwk
	 */
	public void setYrwk(String yrwk) {
		this.yrwk = yrwk;
	}
	
	/**
	 * Column Info
	 * @param yrwk_pkup
	 */
	public void setYrwkPkup(String yrwk_pkup) {
		this.yrwk_pkup = yrwk_pkup;
	}	
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param periodtp
	 */
	public void setPeriodtp(String periodtp) {
		this.periodtp = periodtp;
	}
	
	/**
	 * Column Info
	 * @param periodtp_pkup
	 */
	public void setPeriodtpPkup(String periodtp_pkup) {
		this.periodtp_pkup = periodtp_pkup;
	}	
	
	/**
	 * Column Info
	 * @param toperiod
	 */
	public void setToperiod(String toperiod) {
		this.toperiod = toperiod;
	}
	
	/**
	 * Column Info
	 * @param toperiod
	 */
	public void setToperiodPkup(String toperiod_pkup) {
		this.toperiod_pkup = toperiod_pkup;
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
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setDivFlag(JSPUtil.getParameter(request, prefix + "div_flag", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));		
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		
		setYrwk(JSPUtil.getParameter(request, prefix + "yrwk", ""));
		setPeriodtp(JSPUtil.getParameter(request, prefix + "periodtp", ""));
		setFmperiod(JSPUtil.getParameter(request, prefix + "fmperiod", ""));		
		setToperiod(JSPUtil.getParameter(request, prefix + "toperiod", ""));
		setYrwkPkup(JSPUtil.getParameter(request, prefix + "yrwk_pkup", ""));
		setPeriodtpPkup(JSPUtil.getParameter(request, prefix + "periodtp_pkup", ""));
		setFmperiodPkup(JSPUtil.getParameter(request, prefix + "fmperiod_pkup", ""));		
		setToperiodPkup(JSPUtil.getParameter(request, prefix + "toperiod_pkup", ""));		
		
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PlanAndApprovalConditionVO[]
	 */
	public PlanAndApprovalConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PlanAndApprovalConditionVO[]
	 */
	public PlanAndApprovalConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PlanAndApprovalConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] divFlag = (JSPUtil.getParameter(request, prefix	+ "div_flag", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));			
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			
			String[] yrwk = (JSPUtil.getParameter(request, prefix	+ "yrwk", length));
			String[] fmperiod = (JSPUtil.getParameter(request, prefix	+ "fmperiod", length));			
			String[] toperiod = (JSPUtil.getParameter(request, prefix	+ "toperiod", length));
			String[] periodtp = (JSPUtil.getParameter(request, prefix	+ "periodtp", length));			

			String[] yrwk_pkup     = (JSPUtil.getParameter(request, prefix	+ "yrwk_pkup", length));
			String[] fmperiod_pkup = (JSPUtil.getParameter(request, prefix	+ "fmperiod_pkup", length));			
			String[] toperiod_pkup = (JSPUtil.getParameter(request, prefix	+ "toperiod_pkup", length));
			String[] periodtp_pkup = (JSPUtil.getParameter(request, prefix	+ "periodtp_pkup", length));		
			
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PlanAndApprovalConditionVO();
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (divFlag[i] != null)
					model.setDivFlag(divFlag[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);				
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				
				if (yrwk[i] != null)
					model.setYrwk(yrwk[i]);
				if (fmperiod[i] != null)
					model.setFmperiod(fmperiod[i]);				
				if (toperiod[i] != null)
					model.setToperiod(toperiod[i]);
				if (periodtp[i] != null)
					model.setPeriodtp(periodtp[i]);
				
				if (yrwk_pkup[i] != null)
					model.setYrwkPkup(yrwk_pkup[i]);
				if (fmperiod_pkup[i] != null)
					model.setFmperiodPkup(fmperiod_pkup[i]);				
				if (toperiod_pkup[i] != null)
					model.setToperiodPkup(toperiod_pkup[i]);
				if (periodtp_pkup[i] != null)
					model.setPeriodtpPkup(periodtp_pkup[i]);				
				
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPlanAndApprovalConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PlanAndApprovalConditionVO[]
	 */
	public PlanAndApprovalConditionVO[] getPlanAndApprovalConditionVOs(){
		PlanAndApprovalConditionVO[] vos = (PlanAndApprovalConditionVO[])models.toArray(new PlanAndApprovalConditionVO[models.size()]);
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
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divFlag = this.divFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.yrwk = this.yrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodtp = this.periodtp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmperiod = this.fmperiod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toperiod = this.toperiod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.yrwk_pkup = this.yrwk_pkup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodtp_pkup = this.periodtp_pkup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmperiod_pkup = this.fmperiod_pkup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toperiod_pkup = this.toperiod_pkup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
