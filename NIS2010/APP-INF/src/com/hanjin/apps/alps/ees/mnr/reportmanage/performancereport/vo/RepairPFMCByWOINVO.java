/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairPFMCByWOINVO.java
*@FileTitle : RepairPFMCByWOINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.05
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.10.05 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairPFMCByWOINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairPFMCByWOINVO> models = new ArrayList<RepairPFMCByWOINVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String tpSzCd = null;
	/* Column Info */
	private String reportPeriodType = null;
	/* Column Info */
	private String mnrWoTpCd = null;
	/* Column Info */
	private String eqType = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String country = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepairPFMCByWOINVO() {}

	public RepairPFMCByWOINVO(String ibflag, String pagerows, String toDt, String ofcCd, String currCd, String fmDt, String vndrSeq, String tpSzCd, String reportPeriodType, String mnrWoTpCd, String eqType, String rhq, String country) {
		this.currCd = currCd;
		this.fmDt = fmDt;
		this.tpSzCd = tpSzCd;
		this.reportPeriodType = reportPeriodType;
		this.mnrWoTpCd = mnrWoTpCd;
		this.eqType = eqType;
		this.pagerows = pagerows;
		this.country = country;
		this.toDt = toDt;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.rhq = rhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("tp_sz_cd", getTpSzCd());
		this.hashColumns.put("report_period_type", getReportPeriodType());
		this.hashColumns.put("mnr_wo_tp_cd", getMnrWoTpCd());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("country", getCountry());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("tp_sz_cd", "tpSzCd");
		this.hashFields.put("report_period_type", "reportPeriodType");
		this.hashFields.put("mnr_wo_tp_cd", "mnrWoTpCd");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("country", "country");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return tpSzCd
	 */
	public String getTpSzCd() {
		return this.tpSzCd;
	}
	
	/**
	 * Column Info
	 * @return reportPeriodType
	 */
	public String getReportPeriodType() {
		return this.reportPeriodType;
	}
	
	/**
	 * Column Info
	 * @return mnrWoTpCd
	 */
	public String getMnrWoTpCd() {
		return this.mnrWoTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
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
	 * @return country
	 */
	public String getCountry() {
		return this.country;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	

	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param tpSzCd
	 */
	public void setTpSzCd(String tpSzCd) {
		this.tpSzCd = tpSzCd;
	}
	
	/**
	 * Column Info
	 * @param reportPeriodType
	 */
	public void setReportPeriodType(String reportPeriodType) {
		this.reportPeriodType = reportPeriodType;
	}
	
	/**
	 * Column Info
	 * @param mnrWoTpCd
	 */
	public void setMnrWoTpCd(String mnrWoTpCd) {
		this.mnrWoTpCd = mnrWoTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
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
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setTpSzCd(JSPUtil.getParameter(request, prefix + "tp_sz_cd", ""));
		setReportPeriodType(JSPUtil.getParameter(request, prefix + "report_period_type", ""));
		setMnrWoTpCd(JSPUtil.getParameter(request, prefix + "mnr_wo_tp_cd", ""));
		setEqType(JSPUtil.getParameter(request, prefix + "eq_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCountry(JSPUtil.getParameter(request, prefix + "country", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairPFMCByWOINVO[]
	 */
	public RepairPFMCByWOINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairPFMCByWOINVO[]
	 */
	public RepairPFMCByWOINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairPFMCByWOINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] tpSzCd = (JSPUtil.getParameter(request, prefix	+ "tp_sz_cd", length));
			String[] reportPeriodType = (JSPUtil.getParameter(request, prefix	+ "report_period_type", length));
			String[] mnrWoTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_wo_tp_cd", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] country = (JSPUtil.getParameter(request, prefix	+ "country", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairPFMCByWOINVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (tpSzCd[i] != null)
					model.setTpSzCd(tpSzCd[i]);
				if (reportPeriodType[i] != null)
					model.setReportPeriodType(reportPeriodType[i]);
				if (mnrWoTpCd[i] != null)
					model.setMnrWoTpCd(mnrWoTpCd[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (country[i] != null)
					model.setCountry(country[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairPFMCByWOINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairPFMCByWOINVO[]
	 */
	public RepairPFMCByWOINVO[] getRepairPFMCByWOINVOs(){
		RepairPFMCByWOINVO[] vos = (RepairPFMCByWOINVO[])models.toArray(new RepairPFMCByWOINVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpSzCd = this.tpSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportPeriodType = this.reportPeriodType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWoTpCd = this.mnrWoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.country = this.country .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
