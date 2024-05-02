/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchApprovalDetailVO.java
*@FileTitle : SearchApprovalDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.04 진준성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 진준성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchApprovalDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchApprovalDetailVO> models = new ArrayList<SearchApprovalDetailVO>();
	
	/* Column Info */
	private String detailAgmtSeq = null;
	/* Column Info */
	private String onHireLoc = null;
	/* Column Info */
	private String onHireDt = null;
	/* Column Info */
	private String div = null;
	/* Column Info */
	private String fDays = null;
	/* Column Info */
	private String usingDay = null;
	/* Column Info */
	private String periodStdt = null;
	/* Column Info */
	private String newVanTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrAuthNo = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mvnt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String detailDivsion = null;
	/* Column Info */
	private String minDays = null;
	/* Column Info */
	private String locTp = null;
	/* Column Info */
	private String lessor = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String pkupDueDt = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String authNo = null;
	/* Column Info */
	private String offHireLoc = null;
	/* Column Info */
	private String detailAuthNo = null;
	/* Column Info */
	private String detailAgmtCtyCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String detailCntrTpszCd = null;
	/* Column Info */
	private String offHireDt = null;
	/* Column Info */
	private String mvmtDt = null;
	/* Column Info */
	private String periodEddt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchApprovalDetailVO() {}

	public SearchApprovalDetailVO(String ibflag, String pagerows, String detailDivsion, String detailAgmtSeq, String onHireDt, String onHireLoc, String div, String fDays, String usingDay, String periodStdt, String newVanTpCd, String cntrAuthNo, String locCd, String mvnt, String cntrTpszCd, String agmtCtyCd, String lstmCd, String dueDt, String minDays, String locTp, String lessor, String agmtSeq, String pkupDueDt, String agmtNo, String authNo, String offHireLoc, String detailAgmtCtyCd, String detailAuthNo, String cntrNo, String detailCntrTpszCd, String mvmtDt, String offHireDt, String periodEddt) {
		this.detailAgmtSeq = detailAgmtSeq;
		this.onHireLoc = onHireLoc;
		this.onHireDt = onHireDt;
		this.div = div;
		this.fDays = fDays;
		this.usingDay = usingDay;
		this.periodStdt = periodStdt;
		this.newVanTpCd = newVanTpCd;
		this.pagerows = pagerows;
		this.cntrAuthNo = cntrAuthNo;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.mvnt = mvnt;
		this.cntrTpszCd = cntrTpszCd;
		this.agmtCtyCd = agmtCtyCd;
		this.lstmCd = lstmCd;
		this.dueDt = dueDt;
		this.detailDivsion = detailDivsion;
		this.minDays = minDays;
		this.locTp = locTp;
		this.lessor = lessor;
		this.agmtSeq = agmtSeq;
		this.pkupDueDt = pkupDueDt;
		this.agmtNo = agmtNo;
		this.authNo = authNo;
		this.offHireLoc = offHireLoc;
		this.detailAuthNo = detailAuthNo;
		this.detailAgmtCtyCd = detailAgmtCtyCd;
		this.cntrNo = cntrNo;
		this.detailCntrTpszCd = detailCntrTpszCd;
		this.offHireDt = offHireDt;
		this.mvmtDt = mvmtDt;
		this.periodEddt = periodEddt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("detail_agmt_seq", getDetailAgmtSeq());
		this.hashColumns.put("on_hire_loc", getOnHireLoc());
		this.hashColumns.put("on_hire_dt", getOnHireDt());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("f_days", getFDays());
		this.hashColumns.put("using_day", getUsingDay());
		this.hashColumns.put("period_stdt", getPeriodStdt());
		this.hashColumns.put("new_van_tp_cd", getNewVanTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_auth_no", getCntrAuthNo());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mvnt", getMvnt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("detail_divsion", getDetailDivsion());
		this.hashColumns.put("min_days", getMinDays());
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("lessor", getLessor());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("pkup_due_dt", getPkupDueDt());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("auth_no", getAuthNo());
		this.hashColumns.put("off_hire_loc", getOffHireLoc());
		this.hashColumns.put("detail_auth_no", getDetailAuthNo());
		this.hashColumns.put("detail_agmt_cty_cd", getDetailAgmtCtyCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("detail_cntr_tpsz_cd", getDetailCntrTpszCd());
		this.hashColumns.put("off_hire_dt", getOffHireDt());
		this.hashColumns.put("mvmt_dt", getMvmtDt());
		this.hashColumns.put("period_eddt", getPeriodEddt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("detail_agmt_seq", "detailAgmtSeq");
		this.hashFields.put("on_hire_loc", "onHireLoc");
		this.hashFields.put("on_hire_dt", "onHireDt");
		this.hashFields.put("div", "div");
		this.hashFields.put("f_days", "fDays");
		this.hashFields.put("using_day", "usingDay");
		this.hashFields.put("period_stdt", "periodStdt");
		this.hashFields.put("new_van_tp_cd", "newVanTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_auth_no", "cntrAuthNo");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mvnt", "mvnt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("detail_divsion", "detailDivsion");
		this.hashFields.put("min_days", "minDays");
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("lessor", "lessor");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("pkup_due_dt", "pkupDueDt");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("auth_no", "authNo");
		this.hashFields.put("off_hire_loc", "offHireLoc");
		this.hashFields.put("detail_auth_no", "detailAuthNo");
		this.hashFields.put("detail_agmt_cty_cd", "detailAgmtCtyCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("detail_cntr_tpsz_cd", "detailCntrTpszCd");
		this.hashFields.put("off_hire_dt", "offHireDt");
		this.hashFields.put("mvmt_dt", "mvmtDt");
		this.hashFields.put("period_eddt", "periodEddt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return detailAgmtSeq
	 */
	public String getDetailAgmtSeq() {
		return this.detailAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return onHireLoc
	 */
	public String getOnHireLoc() {
		return this.onHireLoc;
	}
	
	/**
	 * Column Info
	 * @return onHireDt
	 */
	public String getOnHireDt() {
		return this.onHireDt;
	}
	
	/**
	 * Column Info
	 * @return div
	 */
	public String getDiv() {
		return this.div;
	}
	
	/**
	 * Column Info
	 * @return fDays
	 */
	public String getFDays() {
		return this.fDays;
	}
	
	/**
	 * Column Info
	 * @return usingDay
	 */
	public String getUsingDay() {
		return this.usingDay;
	}
	
	/**
	 * Column Info
	 * @return periodStdt
	 */
	public String getPeriodStdt() {
		return this.periodStdt;
	}
	
	/**
	 * Column Info
	 * @return newVanTpCd
	 */
	public String getNewVanTpCd() {
		return this.newVanTpCd;
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
	 * @return cntrAuthNo
	 */
	public String getCntrAuthNo() {
		return this.cntrAuthNo;
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
	 * @return mvnt
	 */
	public String getMvnt() {
		return this.mvnt;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
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
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return detailDivsion
	 */
	public String getDetailDivsion() {
		return this.detailDivsion;
	}
	
	/**
	 * Column Info
	 * @return minDays
	 */
	public String getMinDays() {
		return this.minDays;
	}
	
	/**
	 * Column Info
	 * @return locTp
	 */
	public String getLocTp() {
		return this.locTp;
	}
	
	/**
	 * Column Info
	 * @return lessor
	 */
	public String getLessor() {
		return this.lessor;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return pkupDueDt
	 */
	public String getPkupDueDt() {
		return this.pkupDueDt;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return authNo
	 */
	public String getAuthNo() {
		return this.authNo;
	}
	
	/**
	 * Column Info
	 * @return offHireLoc
	 */
	public String getOffHireLoc() {
		return this.offHireLoc;
	}
	
	/**
	 * Column Info
	 * @return detailAuthNo
	 */
	public String getDetailAuthNo() {
		return this.detailAuthNo;
	}
	
	/**
	 * Column Info
	 * @return detailAgmtCtyCd
	 */
	public String getDetailAgmtCtyCd() {
		return this.detailAgmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return detailCntrTpszCd
	 */
	public String getDetailCntrTpszCd() {
		return this.detailCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return offHireDt
	 */
	public String getOffHireDt() {
		return this.offHireDt;
	}
	
	/**
	 * Column Info
	 * @return mvmtDt
	 */
	public String getMvmtDt() {
		return this.mvmtDt;
	}
	
	/**
	 * Column Info
	 * @return periodEddt
	 */
	public String getPeriodEddt() {
		return this.periodEddt;
	}
	

	/**
	 * Column Info
	 * @param detailAgmtSeq
	 */
	public void setDetailAgmtSeq(String detailAgmtSeq) {
		this.detailAgmtSeq = detailAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param onHireLoc
	 */
	public void setOnHireLoc(String onHireLoc) {
		this.onHireLoc = onHireLoc;
	}
	
	/**
	 * Column Info
	 * @param onHireDt
	 */
	public void setOnHireDt(String onHireDt) {
		this.onHireDt = onHireDt;
	}
	
	/**
	 * Column Info
	 * @param div
	 */
	public void setDiv(String div) {
		this.div = div;
	}
	
	/**
	 * Column Info
	 * @param fDays
	 */
	public void setFDays(String fDays) {
		this.fDays = fDays;
	}
	
	/**
	 * Column Info
	 * @param usingDay
	 */
	public void setUsingDay(String usingDay) {
		this.usingDay = usingDay;
	}
	
	/**
	 * Column Info
	 * @param periodStdt
	 */
	public void setPeriodStdt(String periodStdt) {
		this.periodStdt = periodStdt;
	}
	
	/**
	 * Column Info
	 * @param newVanTpCd
	 */
	public void setNewVanTpCd(String newVanTpCd) {
		this.newVanTpCd = newVanTpCd;
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
	 * @param cntrAuthNo
	 */
	public void setCntrAuthNo(String cntrAuthNo) {
		this.cntrAuthNo = cntrAuthNo;
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
	 * @param mvnt
	 */
	public void setMvnt(String mvnt) {
		this.mvnt = mvnt;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
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
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param detailDivsion
	 */
	public void setDetailDivsion(String detailDivsion) {
		this.detailDivsion = detailDivsion;
	}
	
	/**
	 * Column Info
	 * @param minDays
	 */
	public void setMinDays(String minDays) {
		this.minDays = minDays;
	}
	
	/**
	 * Column Info
	 * @param locTp
	 */
	public void setLocTp(String locTp) {
		this.locTp = locTp;
	}
	
	/**
	 * Column Info
	 * @param lessor
	 */
	public void setLessor(String lessor) {
		this.lessor = lessor;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param pkupDueDt
	 */
	public void setPkupDueDt(String pkupDueDt) {
		this.pkupDueDt = pkupDueDt;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param authNo
	 */
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	
	/**
	 * Column Info
	 * @param offHireLoc
	 */
	public void setOffHireLoc(String offHireLoc) {
		this.offHireLoc = offHireLoc;
	}
	
	/**
	 * Column Info
	 * @param detailAuthNo
	 */
	public void setDetailAuthNo(String detailAuthNo) {
		this.detailAuthNo = detailAuthNo;
	}
	
	/**
	 * Column Info
	 * @param detailAgmtCtyCd
	 */
	public void setDetailAgmtCtyCd(String detailAgmtCtyCd) {
		this.detailAgmtCtyCd = detailAgmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param detailCntrTpszCd
	 */
	public void setDetailCntrTpszCd(String detailCntrTpszCd) {
		this.detailCntrTpszCd = detailCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param offHireDt
	 */
	public void setOffHireDt(String offHireDt) {
		this.offHireDt = offHireDt;
	}
	
	/**
	 * Column Info
	 * @param mvmtDt
	 */
	public void setMvmtDt(String mvmtDt) {
		this.mvmtDt = mvmtDt;
	}
	
	/**
	 * Column Info
	 * @param periodEddt
	 */
	public void setPeriodEddt(String periodEddt) {
		this.periodEddt = periodEddt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDetailAgmtSeq(JSPUtil.getParameter(request, "detail_agmt_seq", ""));
		setOnHireLoc(JSPUtil.getParameter(request, "on_hire_loc", ""));
		setOnHireDt(JSPUtil.getParameter(request, "on_hire_dt", ""));
		setDiv(JSPUtil.getParameter(request, "div", ""));
		setFDays(JSPUtil.getParameter(request, "f_days", ""));
		setUsingDay(JSPUtil.getParameter(request, "using_day", ""));
		setPeriodStdt(JSPUtil.getParameter(request, "period_stdt", ""));
		setNewVanTpCd(JSPUtil.getParameter(request, "new_van_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrAuthNo(JSPUtil.getParameter(request, "cntr_auth_no", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMvnt(JSPUtil.getParameter(request, "mvnt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setDetailDivsion(JSPUtil.getParameter(request, "detail_divsion", ""));
		setMinDays(JSPUtil.getParameter(request, "min_days", ""));
		setLocTp(JSPUtil.getParameter(request, "loc_tp", ""));
		setLessor(JSPUtil.getParameter(request, "lessor", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setPkupDueDt(JSPUtil.getParameter(request, "pkup_due_dt", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setAuthNo(JSPUtil.getParameter(request, "auth_no", ""));
		setOffHireLoc(JSPUtil.getParameter(request, "off_hire_loc", ""));
		setDetailAuthNo(JSPUtil.getParameter(request, "detail_auth_no", ""));
		setDetailAgmtCtyCd(JSPUtil.getParameter(request, "detail_agmt_cty_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setDetailCntrTpszCd(JSPUtil.getParameter(request, "detail_cntr_tpsz_cd", ""));
		setOffHireDt(JSPUtil.getParameter(request, "off_hire_dt", ""));
		setMvmtDt(JSPUtil.getParameter(request, "mvmt_dt", ""));
		setPeriodEddt(JSPUtil.getParameter(request, "period_eddt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchApprovalDetailVO[]
	 */
	public SearchApprovalDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchApprovalDetailVO[]
	 */
	public SearchApprovalDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchApprovalDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] detailAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "detail_agmt_seq", length));
			String[] onHireLoc = (JSPUtil.getParameter(request, prefix	+ "on_hire_loc", length));
			String[] onHireDt = (JSPUtil.getParameter(request, prefix	+ "on_hire_dt", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] fDays = (JSPUtil.getParameter(request, prefix	+ "f_days", length));
			String[] usingDay = (JSPUtil.getParameter(request, prefix	+ "using_day", length));
			String[] periodStdt = (JSPUtil.getParameter(request, prefix	+ "period_stdt", length));
			String[] newVanTpCd = (JSPUtil.getParameter(request, prefix	+ "new_van_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrAuthNo = (JSPUtil.getParameter(request, prefix	+ "cntr_auth_no", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mvnt = (JSPUtil.getParameter(request, prefix	+ "mvnt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] detailDivsion = (JSPUtil.getParameter(request, prefix	+ "detail_divsion", length));
			String[] minDays = (JSPUtil.getParameter(request, prefix	+ "min_days", length));
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp", length));
			String[] lessor = (JSPUtil.getParameter(request, prefix	+ "lessor", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] pkupDueDt = (JSPUtil.getParameter(request, prefix	+ "pkup_due_dt", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] authNo = (JSPUtil.getParameter(request, prefix	+ "auth_no", length));
			String[] offHireLoc = (JSPUtil.getParameter(request, prefix	+ "off_hire_loc", length));
			String[] detailAuthNo = (JSPUtil.getParameter(request, prefix	+ "detail_auth_no", length));
			String[] detailAgmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "detail_agmt_cty_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] detailCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "detail_cntr_tpsz_cd", length));
			String[] offHireDt = (JSPUtil.getParameter(request, prefix	+ "off_hire_dt", length));
			String[] mvmtDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt", length));
			String[] periodEddt = (JSPUtil.getParameter(request, prefix	+ "period_eddt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchApprovalDetailVO();
				if (detailAgmtSeq[i] != null)
					model.setDetailAgmtSeq(detailAgmtSeq[i]);
				if (onHireLoc[i] != null)
					model.setOnHireLoc(onHireLoc[i]);
				if (onHireDt[i] != null)
					model.setOnHireDt(onHireDt[i]);
				if (div[i] != null)
					model.setDiv(div[i]);
				if (fDays[i] != null)
					model.setFDays(fDays[i]);
				if (usingDay[i] != null)
					model.setUsingDay(usingDay[i]);
				if (periodStdt[i] != null)
					model.setPeriodStdt(periodStdt[i]);
				if (newVanTpCd[i] != null)
					model.setNewVanTpCd(newVanTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrAuthNo[i] != null)
					model.setCntrAuthNo(cntrAuthNo[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mvnt[i] != null)
					model.setMvnt(mvnt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (detailDivsion[i] != null)
					model.setDetailDivsion(detailDivsion[i]);
				if (minDays[i] != null)
					model.setMinDays(minDays[i]);
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (lessor[i] != null)
					model.setLessor(lessor[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (pkupDueDt[i] != null)
					model.setPkupDueDt(pkupDueDt[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (authNo[i] != null)
					model.setAuthNo(authNo[i]);
				if (offHireLoc[i] != null)
					model.setOffHireLoc(offHireLoc[i]);
				if (detailAuthNo[i] != null)
					model.setDetailAuthNo(detailAuthNo[i]);
				if (detailAgmtCtyCd[i] != null)
					model.setDetailAgmtCtyCd(detailAgmtCtyCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (detailCntrTpszCd[i] != null)
					model.setDetailCntrTpszCd(detailCntrTpszCd[i]);
				if (offHireDt[i] != null)
					model.setOffHireDt(offHireDt[i]);
				if (mvmtDt[i] != null)
					model.setMvmtDt(mvmtDt[i]);
				if (periodEddt[i] != null)
					model.setPeriodEddt(periodEddt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchApprovalDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchApprovalDetailVO[]
	 */
	public SearchApprovalDetailVO[] getSearchApprovalDetailVOs(){
		SearchApprovalDetailVO[] vos = (SearchApprovalDetailVO[])models.toArray(new SearchApprovalDetailVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.detailAgmtSeq = this.detailAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onHireLoc = this.onHireLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onHireDt = this.onHireDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDays = this.fDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usingDay = this.usingDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodStdt = this.periodStdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVanTpCd = this.newVanTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAuthNo = this.cntrAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvnt = this.mvnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailDivsion = this.detailDivsion .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minDays = this.minDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessor = this.lessor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupDueDt = this.pkupDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authNo = this.authNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offHireLoc = this.offHireLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailAuthNo = this.detailAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailAgmtCtyCd = this.detailAgmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailCntrTpszCd = this.detailCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offHireDt = this.offHireDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt = this.mvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodEddt = this.periodEddt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
