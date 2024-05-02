/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchTPBDetailListVO.java
*@FileTitle : SearchTPBDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2009.11.18 변종건 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 변종건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTPBDetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTPBDetailListVO> models = new ArrayList<SearchTPBDetailListVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String n3ptyExpnTpCd = null;
	/* Column Info */
	private String overdueDays = null;
	/* Column Info */
	private String cltAmt = null;
	/* Column Info */
	private String ifOfcCd = null;
	/* Column Info */
	private String otsDtlSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String n3ptyBilTpNm = null;
	/* Column Info */
	private String n3ptyInvNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3ptyBilTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String cfmAmt = null;
	/* Column Info */
	private String cfmCurrCd = null;
	/* Column Info */
	private String sN3ptyInvNo = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String sUsrOfcCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String cltCurrCd = null;
	/* Column Info */
	private String ifUsrId = null;
	/* Column Info */
	private String sN3ptyNo = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String cfmRmk = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String n3ptyNoDpSeq = null;
	/* Column Info */
	private String cfmOfcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ifCurrCd = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String eqKndNm = null;
	/* Column Info */
	private String ifAmtUsd = null;
	/* Column Info */
	private String revVvd = null;
	/* Column Info */
	private String n3ptySrcNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTPBDetailListVO() {}

	public SearchTPBDetailListVO(String ibflag, String pagerows, String n3ptyNo, String n3ptyInvNo, String otsDtlSeq, String n3ptyNoDpSeq, String n3ptyExpnTpCd, String n3ptyBilTpCd, String n3ptyBilTpNm, String eqKndNm, String eqNo, String bkgNo, String blNo, String revVvd, String n3ptySrcNo, String ifCurrCd, String ifAmt, String ifAmtUsd, String cfmCurrCd, String cfmAmt, String invCurrCd, String invAmt, String cltCurrCd, String cltAmt, String ifOfcCd, String ifUsrId, String ifDt, String cfmOfcCd, String cfmUsrId, String cfmDt, String overdueDays, String cfmRmk, String sUsrOfcCd, String sN3ptyNo, String sN3ptyInvNo) {
		this.ifDt = ifDt;
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
		this.overdueDays = overdueDays;
		this.cltAmt = cltAmt;
		this.ifOfcCd = ifOfcCd;
		this.otsDtlSeq = otsDtlSeq;
		this.blNo = blNo;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.n3ptyInvNo = n3ptyInvNo;
		this.pagerows = pagerows;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.cfmAmt = cfmAmt;
		this.cfmCurrCd = cfmCurrCd;
		this.sN3ptyInvNo = sN3ptyInvNo;
		this.n3ptyNo = n3ptyNo;
		this.sUsrOfcCd = sUsrOfcCd;
		this.invAmt = invAmt;
		this.cfmUsrId = cfmUsrId;
		this.cltCurrCd = cltCurrCd;
		this.ifUsrId = ifUsrId;
		this.sN3ptyNo = sN3ptyNo;
		this.cfmDt = cfmDt;
		this.cfmRmk = cfmRmk;
		this.invCurrCd = invCurrCd;
		this.n3ptyNoDpSeq = n3ptyNoDpSeq;
		this.cfmOfcCd = cfmOfcCd;
		this.bkgNo = bkgNo;
		this.ifCurrCd = ifCurrCd;
		this.ifAmt = ifAmt;
		this.eqKndNm = eqKndNm;
		this.ifAmtUsd = ifAmtUsd;
		this.revVvd = revVvd;
		this.n3ptySrcNo = n3ptySrcNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("n3pty_expn_tp_cd", getN3ptyExpnTpCd());
		this.hashColumns.put("overdue_days", getOverdueDays());
		this.hashColumns.put("clt_amt", getCltAmt());
		this.hashColumns.put("if_ofc_cd", getIfOfcCd());
		this.hashColumns.put("ots_dtl_seq", getOtsDtlSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("n3pty_inv_no", getN3ptyInvNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cfm_amt", getCfmAmt());
		this.hashColumns.put("cfm_curr_cd", getCfmCurrCd());
		this.hashColumns.put("s_n3pty_inv_no", getSN3ptyInvNo());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("s_usr_ofc_cd", getSUsrOfcCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("clt_curr_cd", getCltCurrCd());
		this.hashColumns.put("if_usr_id", getIfUsrId());
		this.hashColumns.put("s_n3pty_no", getSN3ptyNo());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("cfm_rmk", getCfmRmk());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("n3pty_no_dp_seq", getN3ptyNoDpSeq());
		this.hashColumns.put("cfm_ofc_cd", getCfmOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("if_curr_cd", getIfCurrCd());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("eq_knd_nm", getEqKndNm());
		this.hashColumns.put("if_amt_usd", getIfAmtUsd());
		this.hashColumns.put("rev_vvd", getRevVvd());
		this.hashColumns.put("n3pty_src_no", getN3ptySrcNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("n3pty_expn_tp_cd", "n3ptyExpnTpCd");
		this.hashFields.put("overdue_days", "overdueDays");
		this.hashFields.put("clt_amt", "cltAmt");
		this.hashFields.put("if_ofc_cd", "ifOfcCd");
		this.hashFields.put("ots_dtl_seq", "otsDtlSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
		this.hashFields.put("n3pty_inv_no", "n3ptyInvNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cfm_amt", "cfmAmt");
		this.hashFields.put("cfm_curr_cd", "cfmCurrCd");
		this.hashFields.put("s_n3pty_inv_no", "sN3ptyInvNo");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("s_usr_ofc_cd", "sUsrOfcCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("clt_curr_cd", "cltCurrCd");
		this.hashFields.put("if_usr_id", "ifUsrId");
		this.hashFields.put("s_n3pty_no", "sN3ptyNo");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("cfm_rmk", "cfmRmk");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("n3pty_no_dp_seq", "n3ptyNoDpSeq");
		this.hashFields.put("cfm_ofc_cd", "cfmOfcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("if_curr_cd", "ifCurrCd");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("eq_knd_nm", "eqKndNm");
		this.hashFields.put("if_amt_usd", "ifAmtUsd");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("n3pty_src_no", "n3ptySrcNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyExpnTpCd
	 */
	public String getN3ptyExpnTpCd() {
		return this.n3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @return overdueDays
	 */
	public String getOverdueDays() {
		return this.overdueDays;
	}
	
	/**
	 * Column Info
	 * @return cltAmt
	 */
	public String getCltAmt() {
		return this.cltAmt;
	}
	
	/**
	 * Column Info
	 * @return ifOfcCd
	 */
	public String getIfOfcCd() {
		return this.ifOfcCd;
	}
	
	/**
	 * Column Info
	 * @return otsDtlSeq
	 */
	public String getOtsDtlSeq() {
		return this.otsDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpNm
	 */
	public String getN3ptyBilTpNm() {
		return this.n3ptyBilTpNm;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvNo
	 */
	public String getN3ptyInvNo() {
		return this.n3ptyInvNo;
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
	 * @return n3ptyBilTpCd
	 */
	public String getN3ptyBilTpCd() {
		return this.n3ptyBilTpCd;
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
	 * @return cfmAmt
	 */
	public String getCfmAmt() {
		return this.cfmAmt;
	}
	
	/**
	 * Column Info
	 * @return cfmCurrCd
	 */
	public String getCfmCurrCd() {
		return this.cfmCurrCd;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvNo
	 */
	public String getSN3ptyInvNo() {
		return this.sN3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return sUsrOfcCd
	 */
	public String getSUsrOfcCd() {
		return this.sUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return cfmUsrId
	 */
	public String getCfmUsrId() {
		return this.cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @return cltCurrCd
	 */
	public String getCltCurrCd() {
		return this.cltCurrCd;
	}
	
	/**
	 * Column Info
	 * @return ifUsrId
	 */
	public String getIfUsrId() {
		return this.ifUsrId;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyNo
	 */
	public String getSN3ptyNo() {
		return this.sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
	}
	
	/**
	 * Column Info
	 * @return cfmRmk
	 */
	public String getCfmRmk() {
		return this.cfmRmk;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNoDpSeq
	 */
	public String getN3ptyNoDpSeq() {
		return this.n3ptyNoDpSeq;
	}
	
	/**
	 * Column Info
	 * @return cfmOfcCd
	 */
	public String getCfmOfcCd() {
		return this.cfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return ifCurrCd
	 */
	public String getIfCurrCd() {
		return this.ifCurrCd;
	}
	
	/**
	 * Column Info
	 * @return ifAmt
	 */
	public String getIfAmt() {
		return this.ifAmt;
	}

	/**
	 * Column Info
	 * @return eqKndNm
	 */
	public String getEqKndNm() {
		return this.eqKndNm;
	}
	
	/**
	 * Column Info
	 * @return ifAmtUsd
	 */
	public String getIfAmtUsd() {
		return this.ifAmtUsd;
	}
	
	/**
	 * Column Info
	 * @return revVvd
	 */
	public String getRevVvd() {
		return this.revVvd;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcNo
	 */
	public String getN3ptySrcNo() {
		return this.n3ptySrcNo;
	}
	

	/**
	 * Column Info
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyExpnTpCd
	 */
	public void setN3ptyExpnTpCd(String n3ptyExpnTpCd) {
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @param overdueDays
	 */
	public void setOverdueDays(String overdueDays) {
		this.overdueDays = overdueDays;
	}
	
	/**
	 * Column Info
	 * @param cltAmt
	 */
	public void setCltAmt(String cltAmt) {
		this.cltAmt = cltAmt;
	}
	
	/**
	 * Column Info
	 * @param ifOfcCd
	 */
	public void setIfOfcCd(String ifOfcCd) {
		this.ifOfcCd = ifOfcCd;
	}
	
	/**
	 * Column Info
	 * @param otsDtlSeq
	 */
	public void setOtsDtlSeq(String otsDtlSeq) {
		this.otsDtlSeq = otsDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpNm
	 */
	public void setN3ptyBilTpNm(String n3ptyBilTpNm) {
		this.n3ptyBilTpNm = n3ptyBilTpNm;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvNo
	 */
	public void setN3ptyInvNo(String n3ptyInvNo) {
		this.n3ptyInvNo = n3ptyInvNo;
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
	 * @param n3ptyBilTpCd
	 */
	public void setN3ptyBilTpCd(String n3ptyBilTpCd) {
		this.n3ptyBilTpCd = n3ptyBilTpCd;
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
	 * @param cfmAmt
	 */
	public void setCfmAmt(String cfmAmt) {
		this.cfmAmt = cfmAmt;
	}
	
	/**
	 * Column Info
	 * @param cfmCurrCd
	 */
	public void setCfmCurrCd(String cfmCurrCd) {
		this.cfmCurrCd = cfmCurrCd;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvNo
	 */
	public void setSN3ptyInvNo(String sN3ptyInvNo) {
		this.sN3ptyInvNo = sN3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param sUsrOfcCd
	 */
	public void setSUsrOfcCd(String sUsrOfcCd) {
		this.sUsrOfcCd = sUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param cfmUsrId
	 */
	public void setCfmUsrId(String cfmUsrId) {
		this.cfmUsrId = cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @param cltCurrCd
	 */
	public void setCltCurrCd(String cltCurrCd) {
		this.cltCurrCd = cltCurrCd;
	}
	
	/**
	 * Column Info
	 * @param ifUsrId
	 */
	public void setIfUsrId(String ifUsrId) {
		this.ifUsrId = ifUsrId;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyNo
	 */
	public void setSN3ptyNo(String sN3ptyNo) {
		this.sN3ptyNo = sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
	}
	
	/**
	 * Column Info
	 * @param cfmRmk
	 */
	public void setCfmRmk(String cfmRmk) {
		this.cfmRmk = cfmRmk;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNoDpSeq
	 */
	public void setN3ptyNoDpSeq(String n3ptyNoDpSeq) {
		this.n3ptyNoDpSeq = n3ptyNoDpSeq;
	}
	
	/**
	 * Column Info
	 * @param cfmOfcCd
	 */
	public void setCfmOfcCd(String cfmOfcCd) {
		this.cfmOfcCd = cfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param ifCurrCd
	 */
	public void setIfCurrCd(String ifCurrCd) {
		this.ifCurrCd = ifCurrCd;
	}
	
	/**
	 * Column Info
	 * @param ifAmt
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
	}
	
	/**
	 * Column Info
	 * @param eqKndNm
	 */
	public void setEqKndNm(String eqKndNm) {
		this.eqKndNm = eqKndNm;
	}
	
	/**
	 * Column Info
	 * @param ifAmtUsd
	 */
	public void setIfAmtUsd(String ifAmtUsd) {
		this.ifAmtUsd = ifAmtUsd;
	}
	
	/**
	 * Column Info
	 * @param revVvd
	 */
	public void setRevVvd(String revVvd) {
		this.revVvd = revVvd;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcNo
	 */
	public void setN3ptySrcNo(String n3ptySrcNo) {
		this.n3ptySrcNo = n3ptySrcNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIfDt(JSPUtil.getParameter(request, "if_dt", ""));
		setN3ptyExpnTpCd(JSPUtil.getParameter(request, "n3pty_expn_tp_cd", ""));
		setOverdueDays(JSPUtil.getParameter(request, "overdue_days", ""));
		setCltAmt(JSPUtil.getParameter(request, "clt_amt", ""));
		setIfOfcCd(JSPUtil.getParameter(request, "if_ofc_cd", ""));
		setOtsDtlSeq(JSPUtil.getParameter(request, "ots_dtl_seq", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, "n3pty_bil_tp_nm", ""));
		setN3ptyInvNo(JSPUtil.getParameter(request, "n3pty_inv_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, "n3pty_bil_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setCfmAmt(JSPUtil.getParameter(request, "cfm_amt", ""));
		setCfmCurrCd(JSPUtil.getParameter(request, "cfm_curr_cd", ""));
		setSN3ptyInvNo(JSPUtil.getParameter(request, "s_n3pty_inv_no", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setSUsrOfcCd(JSPUtil.getParameter(request, "s_usr_ofc_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setCfmUsrId(JSPUtil.getParameter(request, "cfm_usr_id", ""));
		setCltCurrCd(JSPUtil.getParameter(request, "clt_curr_cd", ""));
		setIfUsrId(JSPUtil.getParameter(request, "if_usr_id", ""));
		setSN3ptyNo(JSPUtil.getParameter(request, "s_n3pty_no", ""));
		setCfmDt(JSPUtil.getParameter(request, "cfm_dt", ""));
		setCfmRmk(JSPUtil.getParameter(request, "cfm_rmk", ""));
		setInvCurrCd(JSPUtil.getParameter(request, "inv_curr_cd", ""));
		setN3ptyNoDpSeq(JSPUtil.getParameter(request, "n3pty_no_dp_seq", ""));
		setCfmOfcCd(JSPUtil.getParameter(request, "cfm_ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIfCurrCd(JSPUtil.getParameter(request, "if_curr_cd", ""));
		setIfAmt(JSPUtil.getParameter(request, "if_amt", ""));
		setEqKndNm(JSPUtil.getParameter(request, "eq_knd_nm", ""));
		setIfAmtUsd(JSPUtil.getParameter(request, "if_amt_usd", ""));
		setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
		setN3ptySrcNo(JSPUtil.getParameter(request, "n3pty_src_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTPBDetailListVO[]
	 */
	public SearchTPBDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTPBDetailListVO[]
	 */
	public SearchTPBDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTPBDetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] n3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_expn_tp_cd", length));
			String[] overdueDays = (JSPUtil.getParameter(request, prefix	+ "overdue_days", length));
			String[] cltAmt = (JSPUtil.getParameter(request, prefix	+ "clt_amt", length));
			String[] ifOfcCd = (JSPUtil.getParameter(request, prefix	+ "if_ofc_cd", length));
			String[] otsDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ots_dtl_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] n3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] cfmAmt = (JSPUtil.getParameter(request, prefix	+ "cfm_amt", length));
			String[] cfmCurrCd = (JSPUtil.getParameter(request, prefix	+ "cfm_curr_cd", length));
			String[] sN3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_no", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] sUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_usr_ofc_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] cltCurrCd = (JSPUtil.getParameter(request, prefix	+ "clt_curr_cd", length));
			String[] ifUsrId = (JSPUtil.getParameter(request, prefix	+ "if_usr_id", length));
			String[] sN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] cfmRmk = (JSPUtil.getParameter(request, prefix	+ "cfm_rmk", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] n3ptyNoDpSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_no_dp_seq", length));
			String[] cfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "cfm_ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ifCurrCd = (JSPUtil.getParameter(request, prefix	+ "if_curr_cd", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] eqKndNm = (JSPUtil.getParameter(request, prefix	+ "eq_knd_nm", length));
			String[] ifAmtUsd = (JSPUtil.getParameter(request, prefix	+ "if_amt_usd", length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd", length));
			String[] n3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTPBDetailListVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (n3ptyExpnTpCd[i] != null)
					model.setN3ptyExpnTpCd(n3ptyExpnTpCd[i]);
				if (overdueDays[i] != null)
					model.setOverdueDays(overdueDays[i]);
				if (cltAmt[i] != null)
					model.setCltAmt(cltAmt[i]);
				if (ifOfcCd[i] != null)
					model.setIfOfcCd(ifOfcCd[i]);
				if (otsDtlSeq[i] != null)
					model.setOtsDtlSeq(otsDtlSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (n3ptyInvNo[i] != null)
					model.setN3ptyInvNo(n3ptyInvNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3ptyBilTpCd[i] != null)
					model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (cfmAmt[i] != null)
					model.setCfmAmt(cfmAmt[i]);
				if (cfmCurrCd[i] != null)
					model.setCfmCurrCd(cfmCurrCd[i]);
				if (sN3ptyInvNo[i] != null)
					model.setSN3ptyInvNo(sN3ptyInvNo[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (sUsrOfcCd[i] != null)
					model.setSUsrOfcCd(sUsrOfcCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (cltCurrCd[i] != null)
					model.setCltCurrCd(cltCurrCd[i]);
				if (ifUsrId[i] != null)
					model.setIfUsrId(ifUsrId[i]);
				if (sN3ptyNo[i] != null)
					model.setSN3ptyNo(sN3ptyNo[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (cfmRmk[i] != null)
					model.setCfmRmk(cfmRmk[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (n3ptyNoDpSeq[i] != null)
					model.setN3ptyNoDpSeq(n3ptyNoDpSeq[i]);
				if (cfmOfcCd[i] != null)
					model.setCfmOfcCd(cfmOfcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ifCurrCd[i] != null)
					model.setIfCurrCd(ifCurrCd[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (eqKndNm[i] != null)
					model.setEqKndNm(eqKndNm[i]);
				if (ifAmtUsd[i] != null)
					model.setIfAmtUsd(ifAmtUsd[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
				if (n3ptySrcNo[i] != null)
					model.setN3ptySrcNo(n3ptySrcNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTPBDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTPBDetailListVO[]
	 */
	public SearchTPBDetailListVO[] getSearchTPBDetailListVOs(){
		SearchTPBDetailListVO[] vos = (SearchTPBDetailListVO[])models.toArray(new SearchTPBDetailListVO[models.size()]);
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
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyExpnTpCd = this.n3ptyExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overdueDays = this.overdueDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltAmt = this.cltAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOfcCd = this.ifOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDtlSeq = this.otsDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNo = this.n3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmAmt = this.cfmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmCurrCd = this.cfmCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvNo = this.sN3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUsrOfcCd = this.sUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltCurrCd = this.cltCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifUsrId = this.ifUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNo = this.sN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmRmk = this.cfmRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNoDpSeq = this.n3ptyNoDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmOfcCd = this.cfmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifCurrCd = this.ifCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndNm = this.eqKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmtUsd = this.ifAmtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNo = this.n3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
