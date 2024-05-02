/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeVO.java
*@FileTitle : EqInterchangeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.04  
* 1.0 Creation
* 2015-07-09 [CHM-201536018] EQ INTERCHANGE WORK module 신규 개발 제안
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EqInterchangeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqInterchangeVO> models = new ArrayList<EqInterchangeVO>();
	
	/* Column Info */
	private String locFm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String lseItchgRqstNo = null;
	/* Column Info */
	private String lseFreeDys = null;
	/* Column Info */
	private String tpszCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lseItchgAuthNo = null;
	/* Column Info */
	private String lseItchgAuthSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String fmLocCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String lseItchgOffrQty = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String toCostAmt = null;
	/* Column Info */
	private String locTp = null;
	/* Column Info */
	private String addTtlCostAmt = null;
	/* Column Info */
	private String locTo = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String authNo = null;
	/* Column Info */
	private String toLocCd = null;
	/* Column Info */
	private String lrVndrSeq = null;
	/* Column Info */
	private String rqstQty = null;
	/* Column Info */
	private String lseLocGrpCd = null;
	/* Column Info */
	private String lseItchgAuthQty = null;
	/* Column Info */
	private String ttlSavAmt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String fmCostAmt = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String pkupUtAmt = null;
	/* Column Info */
	private String pkupCrAmt = null;
	/* Column Info */
	private String lseItchgRqstSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EqInterchangeVO() {}

	public EqInterchangeVO(String ibflag, String pagerows, String lseItchgRqstNo, String lseItchgRqstSeq, String lstmCd, String lrVndrSeq, String fmLocCd, String cntrTpszCd, String lseLocGrpCd, String toLocCd, String fmCostAmt, String toCostAmt, String rqstQty, String lseFreeDys, String pkupUtAmt, String addTtlCostAmt, String pkupCrAmt, String ttlSavAmt, String lseItchgAuthNo, String lseItchgAuthSeq, String agmtCtyCd, String agmtSeq, String lseItchgOffrQty, String lseItchgAuthQty, String deltFlg, String authNo, String locFm, String locTo, String tpszCd, String vndrSeq, String locTp, String vndrAbbrNm, String updUsrId) {
		this.locFm = locFm;
		this.deltFlg = deltFlg;
		this.lseItchgRqstNo = lseItchgRqstNo;
		this.lseFreeDys = lseFreeDys;
		this.tpszCd = tpszCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.lseItchgAuthNo = lseItchgAuthNo;
		this.lseItchgAuthSeq = lseItchgAuthSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.fmLocCd = fmLocCd;
		this.agmtCtyCd = agmtCtyCd;
		this.lseItchgOffrQty = lseItchgOffrQty;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.toCostAmt = toCostAmt;
		this.locTp = locTp;
		this.addTtlCostAmt = addTtlCostAmt;
		this.locTo = locTo;
		this.agmtSeq = agmtSeq;
		this.authNo = authNo;
		this.toLocCd = toLocCd;
		this.lrVndrSeq = lrVndrSeq;
		this.rqstQty = rqstQty;
		this.lseLocGrpCd = lseLocGrpCd;
		this.lseItchgAuthQty = lseItchgAuthQty;
		this.ttlSavAmt = ttlSavAmt;
		this.vndrSeq = vndrSeq;
		this.fmCostAmt = fmCostAmt;
		this.vndrAbbrNm = vndrAbbrNm;
		this.pkupUtAmt = pkupUtAmt;
		this.pkupCrAmt = pkupCrAmt;
		this.lseItchgRqstSeq = lseItchgRqstSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc_fm", getLocFm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("lse_itchg_rqst_no", getLseItchgRqstNo());
		this.hashColumns.put("lse_free_dys", getLseFreeDys());
		this.hashColumns.put("tpsz_cd", getTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lse_itchg_auth_no", getLseItchgAuthNo());
		this.hashColumns.put("lse_itchg_auth_seq", getLseItchgAuthSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("fm_loc_cd", getFmLocCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("lse_itchg_offr_qty", getLseItchgOffrQty());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("to_cost_amt", getToCostAmt());
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("add_ttl_cost_amt", getAddTtlCostAmt());
		this.hashColumns.put("loc_to", getLocTo());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("auth_no", getAuthNo());
		this.hashColumns.put("to_loc_cd", getToLocCd());
		this.hashColumns.put("lr_vndr_seq", getLrVndrSeq());
		this.hashColumns.put("rqst_qty", getRqstQty());
		this.hashColumns.put("lse_loc_grp_cd", getLseLocGrpCd());
		this.hashColumns.put("lse_itchg_auth_qty", getLseItchgAuthQty());
		this.hashColumns.put("ttl_sav_amt", getTtlSavAmt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("fm_cost_amt", getFmCostAmt());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("pkup_ut_amt", getPkupUtAmt());
		this.hashColumns.put("pkup_cr_amt", getPkupCrAmt());
		this.hashColumns.put("lse_itchg_rqst_seq", getLseItchgRqstSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc_fm", "locFm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("lse_itchg_rqst_no", "lseItchgRqstNo");
		this.hashFields.put("lse_free_dys", "lseFreeDys");
		this.hashFields.put("tpsz_cd", "tpszCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lse_itchg_auth_no", "lseItchgAuthNo");
		this.hashFields.put("lse_itchg_auth_seq", "lseItchgAuthSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("fm_loc_cd", "fmLocCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("lse_itchg_offr_qty", "lseItchgOffrQty");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("to_cost_amt", "toCostAmt");
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("add_ttl_cost_amt", "addTtlCostAmt");
		this.hashFields.put("loc_to", "locTo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("auth_no", "authNo");
		this.hashFields.put("to_loc_cd", "toLocCd");
		this.hashFields.put("lr_vndr_seq", "lrVndrSeq");
		this.hashFields.put("rqst_qty", "rqstQty");
		this.hashFields.put("lse_loc_grp_cd", "lseLocGrpCd");
		this.hashFields.put("lse_itchg_auth_qty", "lseItchgAuthQty");
		this.hashFields.put("ttl_sav_amt", "ttlSavAmt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("fm_cost_amt", "fmCostAmt");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("pkup_ut_amt", "pkupUtAmt");
		this.hashFields.put("pkup_cr_amt", "pkupCrAmt");
		this.hashFields.put("lse_itchg_rqst_seq", "lseItchgRqstSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return locFm
	 */
	public String getLocFm() {
		return this.locFm;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return lseItchgRqstNo
	 */
	public String getLseItchgRqstNo() {
		return this.lseItchgRqstNo;
	}
	
	/**
	 * Column Info
	 * @return lseFreeDys
	 */
	public String getLseFreeDys() {
		return this.lseFreeDys;
	}
	
	/**
	 * Column Info
	 * @return tpszCd
	 */
	public String getTpszCd() {
		return this.tpszCd;
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
	 * @return lseItchgAuthNo
	 */
	public String getLseItchgAuthNo() {
		return this.lseItchgAuthNo;
	}
	
	/**
	 * Column Info
	 * @return lseItchgAuthSeq
	 */
	public String getLseItchgAuthSeq() {
		return this.lseItchgAuthSeq;
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
	 * @return fmLocCd
	 */
	public String getFmLocCd() {
		return this.fmLocCd;
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
	 * @return lseItchgOffrQty
	 */
	public String getLseItchgOffrQty() {
		return this.lseItchgOffrQty;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return toCostAmt
	 */
	public String getToCostAmt() {
		return this.toCostAmt;
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
	 * @return addTtlCostAmt
	 */
	public String getAddTtlCostAmt() {
		return this.addTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return locTo
	 */
	public String getLocTo() {
		return this.locTo;
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
	 * @return authNo
	 */
	public String getAuthNo() {
		return this.authNo;
	}
	
	/**
	 * Column Info
	 * @return toLocCd
	 */
	public String getToLocCd() {
		return this.toLocCd;
	}
	
	/**
	 * Column Info
	 * @return lrVndrSeq
	 */
	public String getLrVndrSeq() {
		return this.lrVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return rqstQty
	 */
	public String getRqstQty() {
		return this.rqstQty;
	}
	
	/**
	 * Column Info
	 * @return lseLocGrpCd
	 */
	public String getLseLocGrpCd() {
		return this.lseLocGrpCd;
	}
	
	/**
	 * Column Info
	 * @return lseItchgAuthQty
	 */
	public String getLseItchgAuthQty() {
		return this.lseItchgAuthQty;
	}
	
	/**
	 * Column Info
	 * @return ttlSavAmt
	 */
	public String getTtlSavAmt() {
		return this.ttlSavAmt;
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
	 * @return fmCostAmt
	 */
	public String getFmCostAmt() {
		return this.fmCostAmt;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return pkupUtAmt
	 */
	public String getPkupUtAmt() {
		return this.pkupUtAmt;
	}
	
	/**
	 * Column Info
	 * @return pkupCrAmt
	 */
	public String getPkupCrAmt() {
		return this.pkupCrAmt;
	}
	
	/**
	 * Column Info
	 * @return lseItchgRqstSeq
	 */
	public String getLseItchgRqstSeq() {
		return this.lseItchgRqstSeq;
	}
	

	/**
	 * Column Info
	 * @param locFm
	 */
	public void setLocFm(String locFm) {
		this.locFm = locFm;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param lseItchgRqstNo
	 */
	public void setLseItchgRqstNo(String lseItchgRqstNo) {
		this.lseItchgRqstNo = lseItchgRqstNo;
	}
	
	/**
	 * Column Info
	 * @param lseFreeDys
	 */
	public void setLseFreeDys(String lseFreeDys) {
		this.lseFreeDys = lseFreeDys;
	}
	
	/**
	 * Column Info
	 * @param tpszCd
	 */
	public void setTpszCd(String tpszCd) {
		this.tpszCd = tpszCd;
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
	 * @param lseItchgAuthNo
	 */
	public void setLseItchgAuthNo(String lseItchgAuthNo) {
		this.lseItchgAuthNo = lseItchgAuthNo;
	}
	
	/**
	 * Column Info
	 * @param lseItchgAuthSeq
	 */
	public void setLseItchgAuthSeq(String lseItchgAuthSeq) {
		this.lseItchgAuthSeq = lseItchgAuthSeq;
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
	 * @param fmLocCd
	 */
	public void setFmLocCd(String fmLocCd) {
		this.fmLocCd = fmLocCd;
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
	 * @param lseItchgOffrQty
	 */
	public void setLseItchgOffrQty(String lseItchgOffrQty) {
		this.lseItchgOffrQty = lseItchgOffrQty;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param toCostAmt
	 */
	public void setToCostAmt(String toCostAmt) {
		this.toCostAmt = toCostAmt;
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
	 * @param addTtlCostAmt
	 */
	public void setAddTtlCostAmt(String addTtlCostAmt) {
		this.addTtlCostAmt = addTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param locTo
	 */
	public void setLocTo(String locTo) {
		this.locTo = locTo;
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
	 * @param authNo
	 */
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	
	/**
	 * Column Info
	 * @param toLocCd
	 */
	public void setToLocCd(String toLocCd) {
		this.toLocCd = toLocCd;
	}
	
	/**
	 * Column Info
	 * @param lrVndrSeq
	 */
	public void setLrVndrSeq(String lrVndrSeq) {
		this.lrVndrSeq = lrVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param rqstQty
	 */
	public void setRqstQty(String rqstQty) {
		this.rqstQty = rqstQty;
	}
	
	/**
	 * Column Info
	 * @param lseLocGrpCd
	 */
	public void setLseLocGrpCd(String lseLocGrpCd) {
		this.lseLocGrpCd = lseLocGrpCd;
	}
	
	/**
	 * Column Info
	 * @param lseItchgAuthQty
	 */
	public void setLseItchgAuthQty(String lseItchgAuthQty) {
		this.lseItchgAuthQty = lseItchgAuthQty;
	}
	
	/**
	 * Column Info
	 * @param ttlSavAmt
	 */
	public void setTtlSavAmt(String ttlSavAmt) {
		this.ttlSavAmt = ttlSavAmt;
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
	 * @param fmCostAmt
	 */
	public void setFmCostAmt(String fmCostAmt) {
		this.fmCostAmt = fmCostAmt;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param pkupUtAmt
	 */
	public void setPkupUtAmt(String pkupUtAmt) {
		this.pkupUtAmt = pkupUtAmt;
	}
	
	/**
	 * Column Info
	 * @param pkupCrAmt
	 */
	public void setPkupCrAmt(String pkupCrAmt) {
		this.pkupCrAmt = pkupCrAmt;
	}
	
	/**
	 * Column Info
	 * @param lseItchgRqstSeq
	 */
	public void setLseItchgRqstSeq(String lseItchgRqstSeq) {
		this.lseItchgRqstSeq = lseItchgRqstSeq;
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
		setLocFm(JSPUtil.getParameter(request, prefix + "loc_fm", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setLseItchgRqstNo(JSPUtil.getParameter(request, prefix + "lse_itchg_rqst_no", ""));
		setLseFreeDys(JSPUtil.getParameter(request, prefix + "lse_free_dys", ""));
		setTpszCd(JSPUtil.getParameter(request, prefix + "tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLseItchgAuthNo(JSPUtil.getParameter(request, prefix + "lse_itchg_auth_no", ""));
		setLseItchgAuthSeq(JSPUtil.getParameter(request, prefix + "lse_itchg_auth_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setFmLocCd(JSPUtil.getParameter(request, prefix + "fm_loc_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, prefix + "agmt_cty_cd", ""));
		setLseItchgOffrQty(JSPUtil.getParameter(request, prefix + "lse_itchg_offr_qty", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setToCostAmt(JSPUtil.getParameter(request, prefix + "to_cost_amt", ""));
		setLocTp(JSPUtil.getParameter(request, prefix + "loc_tp", ""));
		setAddTtlCostAmt(JSPUtil.getParameter(request, prefix + "add_ttl_cost_amt", ""));
		setLocTo(JSPUtil.getParameter(request, prefix + "loc_to", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setAuthNo(JSPUtil.getParameter(request, prefix + "auth_no", ""));
		setToLocCd(JSPUtil.getParameter(request, prefix + "to_loc_cd", ""));
		setLrVndrSeq(JSPUtil.getParameter(request, prefix + "lr_vndr_seq", ""));
		setRqstQty(JSPUtil.getParameter(request, prefix + "rqst_qty", ""));
		setLseLocGrpCd(JSPUtil.getParameter(request, prefix + "lse_loc_grp_cd", ""));
		setLseItchgAuthQty(JSPUtil.getParameter(request, prefix + "lse_itchg_auth_qty", ""));
		setTtlSavAmt(JSPUtil.getParameter(request, prefix + "ttl_sav_amt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setFmCostAmt(JSPUtil.getParameter(request, prefix + "fm_cost_amt", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
		setPkupUtAmt(JSPUtil.getParameter(request, prefix + "pkup_ut_amt", ""));
		setPkupCrAmt(JSPUtil.getParameter(request, prefix + "pkup_cr_amt", ""));
		setLseItchgRqstSeq(JSPUtil.getParameter(request, prefix + "lse_itchg_rqst_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqInterchangeVO[]
	 */
	public EqInterchangeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqInterchangeVO[]
	 */
	public EqInterchangeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqInterchangeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locFm = (JSPUtil.getParameter(request, prefix	+ "loc_fm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] lseItchgRqstNo = (JSPUtil.getParameter(request, prefix	+ "lse_itchg_rqst_no", length));
			String[] lseFreeDys = (JSPUtil.getParameter(request, prefix	+ "lse_free_dys", length));
			String[] tpszCd = (JSPUtil.getParameter(request, prefix	+ "tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lseItchgAuthNo = (JSPUtil.getParameter(request, prefix	+ "lse_itchg_auth_no", length));
			String[] lseItchgAuthSeq = (JSPUtil.getParameter(request, prefix	+ "lse_itchg_auth_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] fmLocCd = (JSPUtil.getParameter(request, prefix	+ "fm_loc_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] lseItchgOffrQty = (JSPUtil.getParameter(request, prefix	+ "lse_itchg_offr_qty", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] toCostAmt = (JSPUtil.getParameter(request, prefix	+ "to_cost_amt", length));
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp", length));
			String[] addTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "add_ttl_cost_amt", length));
			String[] locTo = (JSPUtil.getParameter(request, prefix	+ "loc_to", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] authNo = (JSPUtil.getParameter(request, prefix	+ "auth_no", length));
			String[] toLocCd = (JSPUtil.getParameter(request, prefix	+ "to_loc_cd", length));
			String[] lrVndrSeq = (JSPUtil.getParameter(request, prefix	+ "lr_vndr_seq", length));
			String[] rqstQty = (JSPUtil.getParameter(request, prefix	+ "rqst_qty", length));
			String[] lseLocGrpCd = (JSPUtil.getParameter(request, prefix	+ "lse_loc_grp_cd", length));
			String[] lseItchgAuthQty = (JSPUtil.getParameter(request, prefix	+ "lse_itchg_auth_qty", length));
			String[] ttlSavAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_sav_amt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] fmCostAmt = (JSPUtil.getParameter(request, prefix	+ "fm_cost_amt", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] pkupUtAmt = (JSPUtil.getParameter(request, prefix	+ "pkup_ut_amt", length));
			String[] pkupCrAmt = (JSPUtil.getParameter(request, prefix	+ "pkup_cr_amt", length));
			String[] lseItchgRqstSeq = (JSPUtil.getParameter(request, prefix	+ "lse_itchg_rqst_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqInterchangeVO();
				if (locFm[i] != null)
					model.setLocFm(locFm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (lseItchgRqstNo[i] != null)
					model.setLseItchgRqstNo(lseItchgRqstNo[i]);
				if (lseFreeDys[i] != null)
					model.setLseFreeDys(lseFreeDys[i]);
				if (tpszCd[i] != null)
					model.setTpszCd(tpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lseItchgAuthNo[i] != null)
					model.setLseItchgAuthNo(lseItchgAuthNo[i]);
				if (lseItchgAuthSeq[i] != null)
					model.setLseItchgAuthSeq(lseItchgAuthSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (fmLocCd[i] != null)
					model.setFmLocCd(fmLocCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (lseItchgOffrQty[i] != null)
					model.setLseItchgOffrQty(lseItchgOffrQty[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (toCostAmt[i] != null)
					model.setToCostAmt(toCostAmt[i]);
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (addTtlCostAmt[i] != null)
					model.setAddTtlCostAmt(addTtlCostAmt[i]);
				if (locTo[i] != null)
					model.setLocTo(locTo[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (authNo[i] != null)
					model.setAuthNo(authNo[i]);
				if (toLocCd[i] != null)
					model.setToLocCd(toLocCd[i]);
				if (lrVndrSeq[i] != null)
					model.setLrVndrSeq(lrVndrSeq[i]);
				if (rqstQty[i] != null)
					model.setRqstQty(rqstQty[i]);
				if (lseLocGrpCd[i] != null)
					model.setLseLocGrpCd(lseLocGrpCd[i]);
				if (lseItchgAuthQty[i] != null)
					model.setLseItchgAuthQty(lseItchgAuthQty[i]);
				if (ttlSavAmt[i] != null)
					model.setTtlSavAmt(ttlSavAmt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (fmCostAmt[i] != null)
					model.setFmCostAmt(fmCostAmt[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (pkupUtAmt[i] != null)
					model.setPkupUtAmt(pkupUtAmt[i]);
				if (pkupCrAmt[i] != null)
					model.setPkupCrAmt(pkupCrAmt[i]);
				if (lseItchgRqstSeq[i] != null)
					model.setLseItchgRqstSeq(lseItchgRqstSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqInterchangeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqInterchangeVO[]
	 */
	public EqInterchangeVO[] getEqInterchangeVOs(){
		EqInterchangeVO[] vos = (EqInterchangeVO[])models.toArray(new EqInterchangeVO[models.size()]);
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
		this.locFm = this.locFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseItchgRqstNo = this.lseItchgRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseFreeDys = this.lseFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCd = this.tpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseItchgAuthNo = this.lseItchgAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseItchgAuthSeq = this.lseItchgAuthSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocCd = this.fmLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseItchgOffrQty = this.lseItchgOffrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCostAmt = this.toCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addTtlCostAmt = this.addTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTo = this.locTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authNo = this.authNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocCd = this.toLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lrVndrSeq = this.lrVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstQty = this.rqstQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseLocGrpCd = this.lseLocGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseItchgAuthQty = this.lseItchgAuthQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlSavAmt = this.ttlSavAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCostAmt = this.fmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupUtAmt = this.pkupUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupCrAmt = this.pkupCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseItchgRqstSeq = this.lseItchgRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
