/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairPFMCBySPINVO.java
*@FileTitle : RepairPFMCBySPINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.12
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.02.12 함형석 
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
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairPFMCBySPINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairPFMCBySPINVO> models = new ArrayList<RepairPFMCBySPINVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String reportType = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String fqaFmDt = null;
	/* Column Info */
	private String tpSzCd = null;
	/* Column Info */
	private String reportPeriodType = null;
	/* Column Info */
	private String eqType = null;
	/* Column Info */
	private String fqaToDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String component = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepairPFMCBySPINVO() {}

	public RepairPFMCBySPINVO(String ibflag, String pagerows, String currCd, String reportType, String fmDt, String fqaFmDt, String tpSzCd, String reportPeriodType, String eqType, String fqaToDt, String toDt, String ofcCd, String ydCd, String component, String vndrSeq, String rhq, String userOfcCd) {
		this.userOfcCd = userOfcCd;
		this.currCd = currCd;
		this.reportType = reportType;
		this.fmDt = fmDt;
		this.fqaFmDt = fqaFmDt;
		this.tpSzCd = tpSzCd;
		this.reportPeriodType = reportPeriodType;
		this.eqType = eqType;
		this.fqaToDt = fqaToDt;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.component = component;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.rhq = rhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("report_type", getReportType());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("fqa_fm_dt", getFqaFmDt());
		this.hashColumns.put("tp_sz_cd", getTpSzCd());
		this.hashColumns.put("report_period_type", getReportPeriodType());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("fqa_to_dt", getFqaToDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("component", getComponent());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("report_type", "reportType");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("fqa_fm_dt", "fqaFmDt");
		this.hashFields.put("tp_sz_cd", "tpSzCd");
		this.hashFields.put("report_period_type", "reportPeriodType");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("fqa_to_dt", "fqaToDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("component", "component");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
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
	 * @return reportType
	 */
	public String getReportType() {
		return this.reportType;
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
	 * @return fqaFmDt
	 */
	public String getFqaFmDt() {
		return this.fqaFmDt;
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
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
	}
	
	/**
	 * Column Info
	 * @return fqaToDt
	 */
	public String getFqaToDt() {
		return this.fqaToDt;
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
	 * @return component
	 */
	public String getComponent() {
		return this.component;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
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
	 * @param reportType
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
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
	 * @param fqaFmDt
	 */
	public void setFqaFmDt(String fqaFmDt) {
		this.fqaFmDt = fqaFmDt;
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
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
	}
	
	/**
	 * Column Info
	 * @param fqaToDt
	 */
	public void setFqaToDt(String fqaToDt) {
		this.fqaToDt = fqaToDt;
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
	 * @param component
	 */
	public void setComponent(String component) {
		this.component = component;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
		setUserOfcCd(JSPUtil.getParameter(request, prefix + "user_ofc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setReportType(JSPUtil.getParameter(request, prefix + "report_type", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setFqaFmDt(JSPUtil.getParameter(request, prefix + "fqa_fm_dt", ""));
		setTpSzCd(JSPUtil.getParameter(request, prefix + "tp_sz_cd", ""));
		setReportPeriodType(JSPUtil.getParameter(request, prefix + "report_period_type", ""));
		setEqType(JSPUtil.getParameter(request, prefix + "eq_type", ""));
		setFqaToDt(JSPUtil.getParameter(request, prefix + "fqa_to_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setComponent(JSPUtil.getParameter(request, prefix + "component", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairPFMCBySPINVO[]
	 */
	public RepairPFMCBySPINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairPFMCBySPINVO[]
	 */
	public RepairPFMCBySPINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairPFMCBySPINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] reportType = (JSPUtil.getParameter(request, prefix	+ "report_type", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] fqaFmDt = (JSPUtil.getParameter(request, prefix	+ "fqa_fm_dt", length));
			String[] tpSzCd = (JSPUtil.getParameter(request, prefix	+ "tp_sz_cd", length));
			String[] reportPeriodType = (JSPUtil.getParameter(request, prefix	+ "report_period_type", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] fqaToDt = (JSPUtil.getParameter(request, prefix	+ "fqa_to_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] component = (JSPUtil.getParameter(request, prefix	+ "component", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairPFMCBySPINVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (reportType[i] != null)
					model.setReportType(reportType[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (fqaFmDt[i] != null)
					model.setFqaFmDt(fqaFmDt[i]);
				if (tpSzCd[i] != null)
					model.setTpSzCd(tpSzCd[i]);
				if (reportPeriodType[i] != null)
					model.setReportPeriodType(reportPeriodType[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (fqaToDt[i] != null)
					model.setFqaToDt(fqaToDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (component[i] != null)
					model.setComponent(component[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairPFMCBySPINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairPFMCBySPINVO[]
	 */
	public RepairPFMCBySPINVO[] getRepairPFMCBySPINVOs(){
		RepairPFMCBySPINVO[] vos = (RepairPFMCBySPINVO[])models.toArray(new RepairPFMCBySPINVO[models.size()]);
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
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportType = this.reportType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fqaFmDt = this.fqaFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpSzCd = this.tpSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportPeriodType = this.reportPeriodType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fqaToDt = this.fqaToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.component = this.component .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
