/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RepairPFMCByEqNoINVO.java
*@FileTitle : RepairPFMCByEqNoINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.18
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.04.18 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairPFMCByEqNoINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairPFMCByEqNoINVO> models = new ArrayList<RepairPFMCByEqNoINVO>();
	
	/* Column Info */
	private String mnrVrfyTpCd = null;
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String reportType = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String tpSzCd = null;
	/* Column Info */
	private String backendjobKey = null;
	/* Column Info */
	private String reportPeriodType = null;
	/* Column Info */
	private String manuVndrSeq = null;
	/* Column Info */
	private String verifyResult = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String component = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String eqList = null;
	/* Column Info */
	private String repair = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String rprStsCd = null;
	/* Column Info */
	private String unitVndrSeq = null;
	/* Column Info */
	private String damage = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String eqType = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String eqnos = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String vndrSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepairPFMCByEqNoINVO() {}

	public RepairPFMCByEqNoINVO(String ibflag, String pagerows, String userOfcCd, String mnrVrfyTpCd, String currCd, String reportType, String tpSzCd, String backendjobKey, String manuVndrSeq, String reportPeriodType, String locCd, String component, String acctCd, String eqList, String repair, String lstmCd, String rhq, String fmDt, String rprStsCd, String unitVndrSeq, String damage, String toDate, String eqType, String toDt, String eqnos, String ofcCd, String fromDate, String vndrSeq, String verifyResult) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
		this.userOfcCd = userOfcCd;
		this.reportType = reportType;
		this.currCd = currCd;
		this.tpSzCd = tpSzCd;
		this.backendjobKey = backendjobKey;
		this.reportPeriodType = reportPeriodType;
		this.manuVndrSeq = manuVndrSeq;
		this.verifyResult = verifyResult;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.component = component;
		this.acctCd = acctCd;
		this.eqList = eqList;
		this.repair = repair;
		this.lstmCd = lstmCd;
		this.rhq = rhq;
		this.fmDt = fmDt;
		this.rprStsCd = rprStsCd;
		this.unitVndrSeq = unitVndrSeq;
		this.damage = damage;
		this.toDate = toDate;
		this.eqType = eqType;
		this.toDt = toDt;
		this.eqnos = eqnos;
		this.ofcCd = ofcCd;
		this.fromDate = fromDate;
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_vrfy_tp_cd", getMnrVrfyTpCd());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("report_type", getReportType());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("tp_sz_cd", getTpSzCd());
		this.hashColumns.put("backendjob_key", getBackendjobKey());
		this.hashColumns.put("report_period_type", getReportPeriodType());
		this.hashColumns.put("manu_vndr_seq", getManuVndrSeq());
		this.hashColumns.put("verify_result", getVerifyResult());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("component", getComponent());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("eq_list", getEqList());
		this.hashColumns.put("repair", getRepair());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("rpr_sts_cd", getRprStsCd());
		this.hashColumns.put("unit_vndr_seq", getUnitVndrSeq());
		this.hashColumns.put("damage", getDamage());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("eqnos", getEqnos());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_vrfy_tp_cd", "mnrVrfyTpCd");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("report_type", "reportType");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("tp_sz_cd", "tpSzCd");
		this.hashFields.put("backendjob_key", "backendjobKey");
		this.hashFields.put("report_period_type", "reportPeriodType");
		this.hashFields.put("manu_vndr_seq", "manuVndrSeq");
		this.hashFields.put("verify_result", "verifyResult");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("component", "component");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("eq_list", "eqList");
		this.hashFields.put("repair", "repair");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("rpr_sts_cd", "rprStsCd");
		this.hashFields.put("unit_vndr_seq", "unitVndrSeq");
		this.hashFields.put("damage", "damage");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("eqnos", "eqnos");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("vndr_seq", "vndrSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnrVrfyTpCd
	 */
	public String getMnrVrfyTpCd() {
		return this.mnrVrfyTpCd;
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
	 * @return reportType
	 */
	public String getReportType() {
		return this.reportType;
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
	 * @return tpSzCd
	 */
	public String getTpSzCd() {
		return this.tpSzCd;
	}
	
	/**
	 * Column Info
	 * @return backendjobKey
	 */
	public String getBackendjobKey() {
		return this.backendjobKey;
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
	 * @return manuVndrSeq
	 */
	public String getManuVndrSeq() {
		return this.manuVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return verifyResult
	 */
	public String getVerifyResult() {
		return this.verifyResult;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return eqList
	 */
	public String getEqList() {
		return this.eqList;
	}
	
	/**
	 * Column Info
	 * @return repair
	 */
	public String getRepair() {
		return this.repair;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return rprStsCd
	 */
	public String getRprStsCd() {
		return this.rprStsCd;
	}
	
	/**
	 * Column Info
	 * @return unitVndrSeq
	 */
	public String getUnitVndrSeq() {
		return this.unitVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return damage
	 */
	public String getDamage() {
		return this.damage;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return eqnos
	 */
	public String getEqnos() {
		return this.eqnos;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
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
	 * @param mnrVrfyTpCd
	 */
	public void setMnrVrfyTpCd(String mnrVrfyTpCd) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
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
	 * @param reportType
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
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
	 * @param tpSzCd
	 */
	public void setTpSzCd(String tpSzCd) {
		this.tpSzCd = tpSzCd;
	}
	
	/**
	 * Column Info
	 * @param backendjobKey
	 */
	public void setBackendjobKey(String backendjobKey) {
		this.backendjobKey = backendjobKey;
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
	 * @param manuVndrSeq
	 */
	public void setManuVndrSeq(String manuVndrSeq) {
		this.manuVndrSeq = manuVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param verifyResult
	 */
	public void setVerifyResult(String verifyResult) {
		this.verifyResult = verifyResult;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param eqList
	 */
	public void setEqList(String eqList) {
		this.eqList = eqList;
	}
	
	/**
	 * Column Info
	 * @param repair
	 */
	public void setRepair(String repair) {
		this.repair = repair;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
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
	 * @param rprStsCd
	 */
	public void setRprStsCd(String rprStsCd) {
		this.rprStsCd = rprStsCd;
	}
	
	/**
	 * Column Info
	 * @param unitVndrSeq
	 */
	public void setUnitVndrSeq(String unitVndrSeq) {
		this.unitVndrSeq = unitVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param damage
	 */
	public void setDamage(String damage) {
		this.damage = damage;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param eqnos
	 */
	public void setEqnos(String eqnos) {
		this.eqnos = eqnos;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
		setMnrVrfyTpCd(JSPUtil.getParameter(request, prefix + "mnr_vrfy_tp_cd", ""));
		setUserOfcCd(JSPUtil.getParameter(request, prefix + "user_ofc_cd", ""));
		setReportType(JSPUtil.getParameter(request, prefix + "report_type", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTpSzCd(JSPUtil.getParameter(request, prefix + "tp_sz_cd", ""));
		setBackendjobKey(JSPUtil.getParameter(request, prefix + "backendjob_key", ""));
		setReportPeriodType(JSPUtil.getParameter(request, prefix + "report_period_type", ""));
		setManuVndrSeq(JSPUtil.getParameter(request, prefix + "manu_vndr_seq", ""));
		setVerifyResult(JSPUtil.getParameter(request, prefix + "verify_result", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setComponent(JSPUtil.getParameter(request, prefix + "component", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setEqList(JSPUtil.getParameter(request, prefix + "eq_list", ""));
		setRepair(JSPUtil.getParameter(request, prefix + "repair", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setRprStsCd(JSPUtil.getParameter(request, prefix + "rpr_sts_cd", ""));
		setUnitVndrSeq(JSPUtil.getParameter(request, prefix + "unit_vndr_seq", ""));
		setDamage(JSPUtil.getParameter(request, prefix + "damage", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setEqType(JSPUtil.getParameter(request, prefix + "eq_type", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setEqnos(JSPUtil.getParameter(request, prefix + "eqnos", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setFromDate(JSPUtil.getParameter(request, prefix + "from_date", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairPFMCByEqNoINVO[]
	 */
	public RepairPFMCByEqNoINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairPFMCByEqNoINVO[]
	 */
	public RepairPFMCByEqNoINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairPFMCByEqNoINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_vrfy_tp_cd", length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] reportType = (JSPUtil.getParameter(request, prefix	+ "report_type", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] tpSzCd = (JSPUtil.getParameter(request, prefix	+ "tp_sz_cd", length));
			String[] backendjobKey = (JSPUtil.getParameter(request, prefix	+ "backendjob_key", length));
			String[] reportPeriodType = (JSPUtil.getParameter(request, prefix	+ "report_period_type", length));
			String[] manuVndrSeq = (JSPUtil.getParameter(request, prefix	+ "manu_vndr_seq", length));
			String[] verifyResult = (JSPUtil.getParameter(request, prefix	+ "verify_result", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] component = (JSPUtil.getParameter(request, prefix	+ "component", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] eqList = (JSPUtil.getParameter(request, prefix	+ "eq_list", length));
			String[] repair = (JSPUtil.getParameter(request, prefix	+ "repair", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] rprStsCd = (JSPUtil.getParameter(request, prefix	+ "rpr_sts_cd", length));
			String[] unitVndrSeq = (JSPUtil.getParameter(request, prefix	+ "unit_vndr_seq", length));
			String[] damage = (JSPUtil.getParameter(request, prefix	+ "damage", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] eqnos = (JSPUtil.getParameter(request, prefix	+ "eqnos", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairPFMCByEqNoINVO();
				if (mnrVrfyTpCd[i] != null)
					model.setMnrVrfyTpCd(mnrVrfyTpCd[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (reportType[i] != null)
					model.setReportType(reportType[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (tpSzCd[i] != null)
					model.setTpSzCd(tpSzCd[i]);
				if (backendjobKey[i] != null)
					model.setBackendjobKey(backendjobKey[i]);
				if (reportPeriodType[i] != null)
					model.setReportPeriodType(reportPeriodType[i]);
				if (manuVndrSeq[i] != null)
					model.setManuVndrSeq(manuVndrSeq[i]);
				if (verifyResult[i] != null)
					model.setVerifyResult(verifyResult[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (component[i] != null)
					model.setComponent(component[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (eqList[i] != null)
					model.setEqList(eqList[i]);
				if (repair[i] != null)
					model.setRepair(repair[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (rprStsCd[i] != null)
					model.setRprStsCd(rprStsCd[i]);
				if (unitVndrSeq[i] != null)
					model.setUnitVndrSeq(unitVndrSeq[i]);
				if (damage[i] != null)
					model.setDamage(damage[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (eqnos[i] != null)
					model.setEqnos(eqnos[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairPFMCByEqNoINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairPFMCByEqNoINVO[]
	 */
	public RepairPFMCByEqNoINVO[] getRepairPFMCByEqNoINVOs(){
		RepairPFMCByEqNoINVO[] vos = (RepairPFMCByEqNoINVO[])models.toArray(new RepairPFMCByEqNoINVO[models.size()]);
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
		this.mnrVrfyTpCd = this.mnrVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportType = this.reportType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpSzCd = this.tpSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backendjobKey = this.backendjobKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportPeriodType = this.reportPeriodType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manuVndrSeq = this.manuVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verifyResult = this.verifyResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.component = this.component .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqList = this.eqList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repair = this.repair .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprStsCd = this.rprStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitVndrSeq = this.unitVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.damage = this.damage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqnos = this.eqnos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
