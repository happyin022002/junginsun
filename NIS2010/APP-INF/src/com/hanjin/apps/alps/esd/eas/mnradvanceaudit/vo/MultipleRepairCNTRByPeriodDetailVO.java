/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MultipleRepairCNTRByPeriodDetailVO.java
*@FileTitle : MultipleRepairCNTRByPeriodDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.06.29 박정민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo;

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
 * @author 박정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MultipleRepairCNTRByPeriodDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MultipleRepairCNTRByPeriodDetailVO> models = new ArrayList<MultipleRepairCNTRByPeriodDetailVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String eqRprCd = null;
	/* Column Info */
	private String vndrCnt = null;
	/* Column Info */
	private String eqDmgNm = null;
	/* Column Info */
	private String dvValue = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String woAmt = null;
	/* Column Info */
	private String eqCmpoNm = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String eqLocNm = null;
	/* Column Info */
	private String rqstRefNo = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String mnrInpDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String eqRprNm = null;
	/* Column Info */
	private String usingDays = null;
	/* Column Info */
	private String eqDmgCd = null;
	/* Column Info */
	private String mnrVrfyTpNm = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String eqCmpoCd = null;
	/* Column Info */
	private String chgCostAmt = null;
	/* Column Info */
	private String eqLocCd = null;
	/* Column Info */
	private String woUser = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MultipleRepairCNTRByPeriodDetailVO() {}

	public MultipleRepairCNTRByPeriodDetailVO(String ibflag, String pagerows, String ofcCd, String rhqOfcCd, String eqNo, String eqTpszCd, String rqstRefNo, String mnrInpDt, String woNo, String rnum, String vndrSeq, String vndrLglEngNm, String ydCd, String currCd, String woAmt, String chgCostAmt, String eqLocCd, String eqLocNm, String eqCmpoCd, String eqCmpoNm, String eqDmgCd, String eqDmgNm, String eqRprCd, String eqRprNm, String mnrVrfyTpNm, String onhDt, String dvValue, String usingDays, String vndrCnt, String woUser) {
		this.ibflag = ibflag;
		this.vndrLglEngNm = vndrLglEngNm;
		this.eqRprCd = eqRprCd;
		this.vndrCnt = vndrCnt;
		this.eqDmgNm = eqDmgNm;
		this.dvValue = dvValue;
		this.woNo = woNo;
		this.woAmt = woAmt;
		this.eqCmpoNm = eqCmpoNm;
		this.onhDt = onhDt;
		this.rhqOfcCd = rhqOfcCd;
		this.eqLocNm = eqLocNm;
		this.rqstRefNo = rqstRefNo;
		this.eqTpszCd = eqTpszCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.rnum = rnum;
		this.eqNo = eqNo;
		this.mnrInpDt = mnrInpDt;
		this.currCd = currCd;
		this.eqRprNm = eqRprNm;
		this.usingDays = usingDays;
		this.eqDmgCd = eqDmgCd;
		this.mnrVrfyTpNm = mnrVrfyTpNm;
		this.vndrSeq = vndrSeq;
		this.ydCd = ydCd;
		this.eqCmpoCd = eqCmpoCd;
		this.chgCostAmt = chgCostAmt;
		this.eqLocCd = eqLocCd;
		this.woUser = woUser;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("eq_rpr_cd", getEqRprCd());
		this.hashColumns.put("vndr_cnt", getVndrCnt());
		this.hashColumns.put("eq_dmg_nm", getEqDmgNm());
		this.hashColumns.put("dv_value", getDvValue());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("wo_amt", getWoAmt());
		this.hashColumns.put("eq_cmpo_nm", getEqCmpoNm());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("eq_loc_nm", getEqLocNm());
		this.hashColumns.put("rqst_ref_no", getRqstRefNo());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("mnr_inp_dt", getMnrInpDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("eq_rpr_nm", getEqRprNm());
		this.hashColumns.put("using_days", getUsingDays());
		this.hashColumns.put("eq_dmg_cd", getEqDmgCd());
		this.hashColumns.put("mnr_vrfy_tp_nm", getMnrVrfyTpNm());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("eq_cmpo_cd", getEqCmpoCd());
		this.hashColumns.put("chg_cost_amt", getChgCostAmt());
		this.hashColumns.put("eq_loc_cd", getEqLocCd());
		this.hashColumns.put("wo_user", getWoUser());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("eq_rpr_cd", "eqRprCd");
		this.hashFields.put("vndr_cnt", "vndrCnt");
		this.hashFields.put("eq_dmg_nm", "eqDmgNm");
		this.hashFields.put("dv_value", "dvValue");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("wo_amt", "woAmt");
		this.hashFields.put("eq_cmpo_nm", "eqCmpoNm");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("eq_loc_nm", "eqLocNm");
		this.hashFields.put("rqst_ref_no", "rqstRefNo");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("mnr_inp_dt", "mnrInpDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("eq_rpr_nm", "eqRprNm");
		this.hashFields.put("using_days", "usingDays");
		this.hashFields.put("eq_dmg_cd", "eqDmgCd");
		this.hashFields.put("mnr_vrfy_tp_nm", "mnrVrfyTpNm");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("eq_cmpo_cd", "eqCmpoCd");
		this.hashFields.put("chg_cost_amt", "chgCostAmt");
		this.hashFields.put("eq_loc_cd", "eqLocCd");
		this.hashFields.put("wo_user", "woUser");
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return eqRprCd
	 */
	public String getEqRprCd() {
		return this.eqRprCd;
	}
	
	/**
	 * Column Info
	 * @return vndrCnt
	 */
	public String getVndrCnt() {
		return this.vndrCnt;
	}
	
	/**
	 * Column Info
	 * @return eqDmgNm
	 */
	public String getEqDmgNm() {
		return this.eqDmgNm;
	}
	
	/**
	 * Column Info
	 * @return dvValue
	 */
	public String getDvValue() {
		return this.dvValue;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return woAmt
	 */
	public String getWoAmt() {
		return this.woAmt;
	}
	
	/**
	 * Column Info
	 * @return eqCmpoNm
	 */
	public String getEqCmpoNm() {
		return this.eqCmpoNm;
	}
	
	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eqLocNm
	 */
	public String getEqLocNm() {
		return this.eqLocNm;
	}
	
	/**
	 * Column Info
	 * @return rqstRefNo
	 */
	public String getRqstRefNo() {
		return this.rqstRefNo;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
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
	 * @return mnrInpDt
	 */
	public String getMnrInpDt() {
		return this.mnrInpDt;
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
	 * @return eqRprNm
	 */
	public String getEqRprNm() {
		return this.eqRprNm;
	}
	
	/**
	 * Column Info
	 * @return usingDays
	 */
	public String getUsingDays() {
		return this.usingDays;
	}
	
	/**
	 * Column Info
	 * @return eqDmgCd
	 */
	public String getEqDmgCd() {
		return this.eqDmgCd;
	}
	
	/**
	 * Column Info
	 * @return mnrVrfyTpNm
	 */
	public String getMnrVrfyTpNm() {
		return this.mnrVrfyTpNm;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return eqCmpoCd
	 */
	public String getEqCmpoCd() {
		return this.eqCmpoCd;
	}
	
	/**
	 * Column Info
	 * @return chgCostAmt
	 */
	public String getChgCostAmt() {
		return this.chgCostAmt;
	}
	
	/**
	 * Column Info
	 * @return eqLocCd
	 */
	public String getEqLocCd() {
		return this.eqLocCd;
	}

	/**
	 * Column Info
	 * @return woUser
	 */
	public String getWoUser() {
		return this.woUser;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param eqRprCd
	 */
	public void setEqRprCd(String eqRprCd) {
		this.eqRprCd = eqRprCd;
	}
	
	/**
	 * Column Info
	 * @param vndrCnt
	 */
	public void setVndrCnt(String vndrCnt) {
		this.vndrCnt = vndrCnt;
	}
	
	/**
	 * Column Info
	 * @param eqDmgNm
	 */
	public void setEqDmgNm(String eqDmgNm) {
		this.eqDmgNm = eqDmgNm;
	}
	
	/**
	 * Column Info
	 * @param dvValue
	 */
	public void setDvValue(String dvValue) {
		this.dvValue = dvValue;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param woAmt
	 */
	public void setWoAmt(String woAmt) {
		this.woAmt = woAmt;
	}
	
	/**
	 * Column Info
	 * @param eqCmpoNm
	 */
	public void setEqCmpoNm(String eqCmpoNm) {
		this.eqCmpoNm = eqCmpoNm;
	}
	
	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eqLocNm
	 */
	public void setEqLocNm(String eqLocNm) {
		this.eqLocNm = eqLocNm;
	}
	
	/**
	 * Column Info
	 * @param rqstRefNo
	 */
	public void setRqstRefNo(String rqstRefNo) {
		this.rqstRefNo = rqstRefNo;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
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
	 * @param mnrInpDt
	 */
	public void setMnrInpDt(String mnrInpDt) {
		this.mnrInpDt = mnrInpDt;
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
	 * @param eqRprNm
	 */
	public void setEqRprNm(String eqRprNm) {
		this.eqRprNm = eqRprNm;
	}
	
	/**
	 * Column Info
	 * @param usingDays
	 */
	public void setUsingDays(String usingDays) {
		this.usingDays = usingDays;
	}
	
	/**
	 * Column Info
	 * @param eqDmgCd
	 */
	public void setEqDmgCd(String eqDmgCd) {
		this.eqDmgCd = eqDmgCd;
	}
	
	/**
	 * Column Info
	 * @param mnrVrfyTpNm
	 */
	public void setMnrVrfyTpNm(String mnrVrfyTpNm) {
		this.mnrVrfyTpNm = mnrVrfyTpNm;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param eqCmpoCd
	 */
	public void setEqCmpoCd(String eqCmpoCd) {
		this.eqCmpoCd = eqCmpoCd;
	}
	
	/**
	 * Column Info
	 * @param chgCostAmt
	 */
	public void setChgCostAmt(String chgCostAmt) {
		this.chgCostAmt = chgCostAmt;
	}
	
	/**
	 * Column Info
	 * @param eqLocCd
	 */
	public void setEqLocCd(String eqLocCd) {
		this.eqLocCd = eqLocCd;
	}
	
	/**
	 * Column Info
	 * @param woUser
	 */
	public void setWoUser(String woUser) {
		this.woUser = woUser;
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
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setEqRprCd(JSPUtil.getParameter(request, prefix + "eq_rpr_cd", ""));
		setVndrCnt(JSPUtil.getParameter(request, prefix + "vndr_cnt", ""));
		setEqDmgNm(JSPUtil.getParameter(request, prefix + "eq_dmg_nm", ""));
		setDvValue(JSPUtil.getParameter(request, prefix + "dv_value", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setWoAmt(JSPUtil.getParameter(request, prefix + "wo_amt", ""));
		setEqCmpoNm(JSPUtil.getParameter(request, prefix + "eq_cmpo_nm", ""));
		setOnhDt(JSPUtil.getParameter(request, prefix + "onh_dt", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setEqLocNm(JSPUtil.getParameter(request, prefix + "eq_loc_nm", ""));
		setRqstRefNo(JSPUtil.getParameter(request, prefix + "rqst_ref_no", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setMnrInpDt(JSPUtil.getParameter(request, prefix + "mnr_inp_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setEqRprNm(JSPUtil.getParameter(request, prefix + "eq_rpr_nm", ""));
		setUsingDays(JSPUtil.getParameter(request, prefix + "using_days", ""));
		setEqDmgCd(JSPUtil.getParameter(request, prefix + "eq_dmg_cd", ""));
		setMnrVrfyTpNm(JSPUtil.getParameter(request, prefix + "mnr_vrfy_tp_nm", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setEqCmpoCd(JSPUtil.getParameter(request, prefix + "eq_cmpo_cd", ""));
		setChgCostAmt(JSPUtil.getParameter(request, prefix + "chg_cost_amt", ""));
		setEqLocCd(JSPUtil.getParameter(request, prefix + "eq_loc_cd", ""));
		setWoUser(JSPUtil.getParameter(request, prefix + "wo_user", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MultipleRepairCNTRByPeriodDetailVO[]
	 */
	public MultipleRepairCNTRByPeriodDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MultipleRepairCNTRByPeriodDetailVO[]
	 */
	public MultipleRepairCNTRByPeriodDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MultipleRepairCNTRByPeriodDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] eqRprCd = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_cd", length));
			String[] vndrCnt = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt", length));
			String[] eqDmgNm = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_nm", length));
			String[] dvValue = (JSPUtil.getParameter(request, prefix	+ "dv_value", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] woAmt = (JSPUtil.getParameter(request, prefix	+ "wo_amt", length));
			String[] eqCmpoNm = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_nm", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] eqLocNm = (JSPUtil.getParameter(request, prefix	+ "eq_loc_nm", length));
			String[] rqstRefNo = (JSPUtil.getParameter(request, prefix	+ "rqst_ref_no", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] mnrInpDt = (JSPUtil.getParameter(request, prefix	+ "mnr_inp_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] eqRprNm = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_nm", length));
			String[] usingDays = (JSPUtil.getParameter(request, prefix	+ "using_days", length));
			String[] eqDmgCd = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_cd", length));
			String[] mnrVrfyTpNm = (JSPUtil.getParameter(request, prefix	+ "mnr_vrfy_tp_nm", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] eqCmpoCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd", length));
			String[] chgCostAmt = (JSPUtil.getParameter(request, prefix	+ "chg_cost_amt", length));
			String[] eqLocCd = (JSPUtil.getParameter(request, prefix	+ "eq_loc_cd", length));
			String[] woUser = (JSPUtil.getParameter(request, prefix	+ "wo_user", length));
			
			for (int i = 0; i < length; i++) {
				model = new MultipleRepairCNTRByPeriodDetailVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (eqRprCd[i] != null)
					model.setEqRprCd(eqRprCd[i]);
				if (vndrCnt[i] != null)
					model.setVndrCnt(vndrCnt[i]);
				if (eqDmgNm[i] != null)
					model.setEqDmgNm(eqDmgNm[i]);
				if (dvValue[i] != null)
					model.setDvValue(dvValue[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (woAmt[i] != null)
					model.setWoAmt(woAmt[i]);
				if (eqCmpoNm[i] != null)
					model.setEqCmpoNm(eqCmpoNm[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (eqLocNm[i] != null)
					model.setEqLocNm(eqLocNm[i]);
				if (rqstRefNo[i] != null)
					model.setRqstRefNo(rqstRefNo[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (mnrInpDt[i] != null)
					model.setMnrInpDt(mnrInpDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (eqRprNm[i] != null)
					model.setEqRprNm(eqRprNm[i]);
				if (usingDays[i] != null)
					model.setUsingDays(usingDays[i]);
				if (eqDmgCd[i] != null)
					model.setEqDmgCd(eqDmgCd[i]);
				if (mnrVrfyTpNm[i] != null)
					model.setMnrVrfyTpNm(mnrVrfyTpNm[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (eqCmpoCd[i] != null)
					model.setEqCmpoCd(eqCmpoCd[i]);
				if (chgCostAmt[i] != null)
					model.setChgCostAmt(chgCostAmt[i]);
				if (eqLocCd[i] != null)
					model.setEqLocCd(eqLocCd[i]);
				if (woUser[i] != null)
					model.setWoUser(woUser[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMultipleRepairCNTRByPeriodDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MultipleRepairCNTRByPeriodDetailVO[]
	 */
	public MultipleRepairCNTRByPeriodDetailVO[] getMultipleRepairCNTRByPeriodDetailVOs(){
		MultipleRepairCNTRByPeriodDetailVO[] vos = (MultipleRepairCNTRByPeriodDetailVO[])models.toArray(new MultipleRepairCNTRByPeriodDetailVO[models.size()]);
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
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprCd = this.eqRprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCnt = this.vndrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgNm = this.eqDmgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvValue = this.dvValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woAmt = this.woAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoNm = this.eqCmpoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocNm = this.eqLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRefNo = this.rqstRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInpDt = this.mnrInpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprNm = this.eqRprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usingDays = this.usingDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgCd = this.eqDmgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrVrfyTpNm = this.mnrVrfyTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCd = this.eqCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCostAmt = this.chgCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocCd = this.eqLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woUser = this.woUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
