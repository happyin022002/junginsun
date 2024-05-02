/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MGSAtdtHistoryINVO.java
*@FileTitle : MGSAtdtHistoryINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.04.28 조재성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo;

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
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSAtdtHistoryINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSAtdtHistoryINVO> models = new ArrayList<MGSAtdtHistoryINVO>();
	
	/* Column Info */
	private String cntrNo2 = null;
	/* Column Info */
	private String orgAtchDt = null;
	/* Column Info */
	private String atchDt2 = null;
	/* Column Info */
	private String atchDtHd = null;
	/* Column Info */
	private String cntrNo1 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String dtchYdCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dtchInpTpCd = null;
	/* Column Info */
	private String atchInpTpCd = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String at = null;
	/* Column Info */
	private String atchYdCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String atchDt = null;
	/* Column Info */
	private String dtchDtHd = null;
	/* Column Info */
	private String cntrChss = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String dtchDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String dtchDtDay = null;
	/* Column Info */
	private String atchDtDay = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MGSAtdtHistoryINVO() {}

	public MGSAtdtHistoryINVO(String ibflag, String pagerows, String cntrNo2, String atchDt2, String status, String atchYdCd, String at, String eqKndCd, String aciacDivCd, String atchDt, String eqTpszCd, String cntrNo1, String dtchDt, String creUsrId, String eqNo, String ydCd, String dtchYdCd, String cntrNo, String cntrTpszCd, String updUsrId, String dtchInpTpCd, String atchInpTpCd, String dtchDtDay, String dtchDtHd, String atchDtDay, String atchDtHd, String cntrChss, String orgAtchDt) {
		this.cntrNo2 = cntrNo2;
		this.orgAtchDt = orgAtchDt;
		this.atchDt2 = atchDt2;
		this.atchDtHd = atchDtHd;
		this.cntrNo1 = cntrNo1;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.dtchYdCd = dtchYdCd;
		this.cntrTpszCd = cntrTpszCd;
		this.updUsrId = updUsrId;
		this.dtchInpTpCd = dtchInpTpCd;
		this.atchInpTpCd = atchInpTpCd;
		this.status = status;
		this.at = at;
		this.atchYdCd = atchYdCd;
		this.aciacDivCd = aciacDivCd;
		this.eqKndCd = eqKndCd;
		this.atchDt = atchDt;
		this.dtchDtHd = dtchDtHd;
		this.cntrChss = cntrChss;
		this.eqTpszCd = eqTpszCd;
		this.dtchDt = dtchDt;
		this.creUsrId = creUsrId;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.dtchDtDay = dtchDtDay;
		this.atchDtDay = atchDtDay;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_no2", getCntrNo2());
		this.hashColumns.put("org_atch_dt", getOrgAtchDt());
		this.hashColumns.put("atch_dt2", getAtchDt2());
		this.hashColumns.put("atch_dt_hd", getAtchDtHd());
		this.hashColumns.put("cntr_no1", getCntrNo1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("dtch_yd_cd", getDtchYdCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dtch_inp_tp_cd", getDtchInpTpCd());
		this.hashColumns.put("atch_inp_tp_cd", getAtchInpTpCd());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("at", getAt());
		this.hashColumns.put("atch_yd_cd", getAtchYdCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("atch_dt", getAtchDt());
		this.hashColumns.put("dtch_dt_hd", getDtchDtHd());
		this.hashColumns.put("cntr_chss", getCntrChss());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("dtch_dt", getDtchDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dtch_dt_day", getDtchDtDay());
		this.hashColumns.put("atch_dt_day", getAtchDtDay());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_no2", "cntrNo2");
		this.hashFields.put("org_atch_dt", "orgAtchDt");
		this.hashFields.put("atch_dt2", "atchDt2");
		this.hashFields.put("atch_dt_hd", "atchDtHd");
		this.hashFields.put("cntr_no1", "cntrNo1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("dtch_yd_cd", "dtchYdCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dtch_inp_tp_cd", "dtchInpTpCd");
		this.hashFields.put("atch_inp_tp_cd", "atchInpTpCd");
		this.hashFields.put("status", "status");
		this.hashFields.put("at", "at");
		this.hashFields.put("atch_yd_cd", "atchYdCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("atch_dt", "atchDt");
		this.hashFields.put("dtch_dt_hd", "dtchDtHd");
		this.hashFields.put("cntr_chss", "cntrChss");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("dtch_dt", "dtchDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dtch_dt_day", "dtchDtDay");
		this.hashFields.put("atch_dt_day", "atchDtDay");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrNo2
	 */
	public String getCntrNo2() {
		return this.cntrNo2;
	}
	
	/**
	 * Column Info
	 * @return orgAtchDt
	 */
	public String getOrgAtchDt() {
		return this.orgAtchDt;
	}
	
	/**
	 * Column Info
	 * @return atchDt2
	 */
	public String getAtchDt2() {
		return this.atchDt2;
	}
	
	/**
	 * Column Info
	 * @return atchDtHd
	 */
	public String getAtchDtHd() {
		return this.atchDtHd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo1
	 */
	public String getCntrNo1() {
		return this.cntrNo1;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return dtchYdCd
	 */
	public String getDtchYdCd() {
		return this.dtchYdCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return dtchInpTpCd
	 */
	public String getDtchInpTpCd() {
		return this.dtchInpTpCd;
	}
	
	/**
	 * Column Info
	 * @return atchInpTpCd
	 */
	public String getAtchInpTpCd() {
		return this.atchInpTpCd;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return at
	 */
	public String getAt() {
		return this.at;
	}
	
	/**
	 * Column Info
	 * @return atchYdCd
	 */
	public String getAtchYdCd() {
		return this.atchYdCd;
	}
	
	/**
	 * Column Info
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return atchDt
	 */
	public String getAtchDt() {
		return this.atchDt;
	}
	
	/**
	 * Column Info
	 * @return dtchDtHd
	 */
	public String getDtchDtHd() {
		return this.dtchDtHd;
	}
	
	/**
	 * Column Info
	 * @return cntrChss
	 */
	public String getCntrChss() {
		return this.cntrChss;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return dtchDt
	 */
	public String getDtchDt() {
		return this.dtchDt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return dtchDtDay
	 */
	public String getDtchDtDay() {
		return this.dtchDtDay;
	}
	
	/**
	 * Column Info
	 * @return atchDtDay
	 */
	public String getAtchDtDay() {
		return this.atchDtDay;
	}
	

	/**
	 * Column Info
	 * @param cntrNo2
	 */
	public void setCntrNo2(String cntrNo2) {
		this.cntrNo2 = cntrNo2;
	}
	
	/**
	 * Column Info
	 * @param orgAtchDt
	 */
	public void setOrgAtchDt(String orgAtchDt) {
		this.orgAtchDt = orgAtchDt;
	}
	
	/**
	 * Column Info
	 * @param atchDt2
	 */
	public void setAtchDt2(String atchDt2) {
		this.atchDt2 = atchDt2;
	}
	
	/**
	 * Column Info
	 * @param atchDtHd
	 */
	public void setAtchDtHd(String atchDtHd) {
		this.atchDtHd = atchDtHd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo1
	 */
	public void setCntrNo1(String cntrNo1) {
		this.cntrNo1 = cntrNo1;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param dtchYdCd
	 */
	public void setDtchYdCd(String dtchYdCd) {
		this.dtchYdCd = dtchYdCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param dtchInpTpCd
	 */
	public void setDtchInpTpCd(String dtchInpTpCd) {
		this.dtchInpTpCd = dtchInpTpCd;
	}
	
	/**
	 * Column Info
	 * @param atchInpTpCd
	 */
	public void setAtchInpTpCd(String atchInpTpCd) {
		this.atchInpTpCd = atchInpTpCd;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param at
	 */
	public void setAt(String at) {
		this.at = at;
	}
	
	/**
	 * Column Info
	 * @param atchYdCd
	 */
	public void setAtchYdCd(String atchYdCd) {
		this.atchYdCd = atchYdCd;
	}
	
	/**
	 * Column Info
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param atchDt
	 */
	public void setAtchDt(String atchDt) {
		this.atchDt = atchDt;
	}
	
	/**
	 * Column Info
	 * @param dtchDtHd
	 */
	public void setDtchDtHd(String dtchDtHd) {
		this.dtchDtHd = dtchDtHd;
	}
	
	/**
	 * Column Info
	 * @param cntrChss
	 */
	public void setCntrChss(String cntrChss) {
		this.cntrChss = cntrChss;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param dtchDt
	 */
	public void setDtchDt(String dtchDt) {
		this.dtchDt = dtchDt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param dtchDtDay
	 */
	public void setDtchDtDay(String dtchDtDay) {
		this.dtchDtDay = dtchDtDay;
	}
	
	/**
	 * Column Info
	 * @param atchDtDay
	 */
	public void setAtchDtDay(String atchDtDay) {
		this.atchDtDay = atchDtDay;
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
		setCntrNo2(JSPUtil.getParameter(request, prefix + "cntr_no2", ""));
		setOrgAtchDt(JSPUtil.getParameter(request, prefix + "org_atch_dt", ""));
		setAtchDt2(JSPUtil.getParameter(request, prefix + "atch_dt2", ""));
		setAtchDtHd(JSPUtil.getParameter(request, prefix + "atch_dt_hd", ""));
		setCntrNo1(JSPUtil.getParameter(request, prefix + "cntr_no1", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setDtchYdCd(JSPUtil.getParameter(request, prefix + "dtch_yd_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDtchInpTpCd(JSPUtil.getParameter(request, prefix + "dtch_inp_tp_cd", ""));
		setAtchInpTpCd(JSPUtil.getParameter(request, prefix + "atch_inp_tp_cd", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setAt(JSPUtil.getParameter(request, prefix + "at", ""));
		setAtchYdCd(JSPUtil.getParameter(request, prefix + "atch_yd_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, prefix + "aciac_div_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setAtchDt(JSPUtil.getParameter(request, prefix + "atch_dt", ""));
		setDtchDtHd(JSPUtil.getParameter(request, prefix + "dtch_dt_hd", ""));
		setCntrChss(JSPUtil.getParameter(request, prefix + "cntr_chss", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setDtchDt(JSPUtil.getParameter(request, prefix + "dtch_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setDtchDtDay(JSPUtil.getParameter(request, prefix + "dtch_dt_day", ""));
		setAtchDtDay(JSPUtil.getParameter(request, prefix + "atch_dt_day", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MGSAtdtHistoryINVO[]
	 */
	public MGSAtdtHistoryINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MGSAtdtHistoryINVO[]
	 */
	public MGSAtdtHistoryINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSAtdtHistoryINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrNo2 = (JSPUtil.getParameter(request, prefix	+ "cntr_no2", length));
			String[] orgAtchDt = (JSPUtil.getParameter(request, prefix	+ "org_atch_dt", length));
			String[] atchDt2 = (JSPUtil.getParameter(request, prefix	+ "atch_dt2", length));
			String[] atchDtHd = (JSPUtil.getParameter(request, prefix	+ "atch_dt_hd", length));
			String[] cntrNo1 = (JSPUtil.getParameter(request, prefix	+ "cntr_no1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] dtchYdCd = (JSPUtil.getParameter(request, prefix	+ "dtch_yd_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dtchInpTpCd = (JSPUtil.getParameter(request, prefix	+ "dtch_inp_tp_cd", length));
			String[] atchInpTpCd = (JSPUtil.getParameter(request, prefix	+ "atch_inp_tp_cd", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] at = (JSPUtil.getParameter(request, prefix	+ "at", length));
			String[] atchYdCd = (JSPUtil.getParameter(request, prefix	+ "atch_yd_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] atchDt = (JSPUtil.getParameter(request, prefix	+ "atch_dt", length));
			String[] dtchDtHd = (JSPUtil.getParameter(request, prefix	+ "dtch_dt_hd", length));
			String[] cntrChss = (JSPUtil.getParameter(request, prefix	+ "cntr_chss", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] dtchDt = (JSPUtil.getParameter(request, prefix	+ "dtch_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] dtchDtDay = (JSPUtil.getParameter(request, prefix	+ "dtch_dt_day", length));
			String[] atchDtDay = (JSPUtil.getParameter(request, prefix	+ "atch_dt_day", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSAtdtHistoryINVO();
				if (cntrNo2[i] != null)
					model.setCntrNo2(cntrNo2[i]);
				if (orgAtchDt[i] != null)
					model.setOrgAtchDt(orgAtchDt[i]);
				if (atchDt2[i] != null)
					model.setAtchDt2(atchDt2[i]);
				if (atchDtHd[i] != null)
					model.setAtchDtHd(atchDtHd[i]);
				if (cntrNo1[i] != null)
					model.setCntrNo1(cntrNo1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (dtchYdCd[i] != null)
					model.setDtchYdCd(dtchYdCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dtchInpTpCd[i] != null)
					model.setDtchInpTpCd(dtchInpTpCd[i]);
				if (atchInpTpCd[i] != null)
					model.setAtchInpTpCd(atchInpTpCd[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (at[i] != null)
					model.setAt(at[i]);
				if (atchYdCd[i] != null)
					model.setAtchYdCd(atchYdCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (atchDt[i] != null)
					model.setAtchDt(atchDt[i]);
				if (dtchDtHd[i] != null)
					model.setDtchDtHd(dtchDtHd[i]);
				if (cntrChss[i] != null)
					model.setCntrChss(cntrChss[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (dtchDt[i] != null)
					model.setDtchDt(dtchDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (dtchDtDay[i] != null)
					model.setDtchDtDay(dtchDtDay[i]);
				if (atchDtDay[i] != null)
					model.setAtchDtDay(atchDtDay[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMGSAtdtHistoryINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MGSAtdtHistoryINVO[]
	 */
	public MGSAtdtHistoryINVO[] getMGSAtdtHistoryINVOs(){
		MGSAtdtHistoryINVO[] vos = (MGSAtdtHistoryINVO[])models.toArray(new MGSAtdtHistoryINVO[models.size()]);
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
		this.cntrNo2 = this.cntrNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgAtchDt = this.orgAtchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchDt2 = this.atchDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchDtHd = this.atchDtHd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo1 = this.cntrNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtchYdCd = this.dtchYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtchInpTpCd = this.dtchInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchInpTpCd = this.atchInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.at = this.at .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchYdCd = this.atchYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchDt = this.atchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtchDtHd = this.dtchDtHd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrChss = this.cntrChss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtchDt = this.dtchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtchDtDay = this.dtchDtDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchDtDay = this.atchDtDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
