/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchTPBInvoiceListVO.java
*@FileTitle : SearchTPBInvoiceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2009.10.26 변종건 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 변종건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTPBInvoiceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTPBInvoiceListVO> models = new ArrayList<SearchTPBInvoiceListVO>();
	
	/* Column Info */
	private String sN3ptyInvNoForSearch = null;
	/* Column Info */
	private String cltAgnFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String n3ptyExpnTpCd = null;
	/* Column Info */
	private String trdPartyCode = null;
	/* Column Info */
	private String sN3ptyInvRmdCdForSearch = null;
	/* Column Info */
	private String cltAmt = null;
	/* Column Info */
	private String n3ptyInvRvisCd = null;
	/* Column Info */
	private String sTrdPartyVal = null;
	/* Column Info */
	private String sIfCtrlCd = null;
	/* Column Info */
	private String n3ptyInvNo = null;
	/* Column Info */
	private String n3ptyInvHisSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrCustDivCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sCltAgnFlg = null;
	/* Column Info */
	private String lengthN3ptyBilTpCd = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String trdPartyNm = null;
	/* Column Info */
	private String sUsrOfcCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String arIfDt = null;
	/* Column Info */
	private String sN3ptyInvStsCd = null;
	/* Column Info */
	private String sInvceSearchVersion = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sCond = null;
	/* Column Info */
	private String sEdate = null;
	/* Column Info */
	private String ifBlNo = null;
	/* Column Info */
	private String sSdate = null;
	/* Column Info */
	private String sVndrCustDivCd = null;
	/* Column Info */
	private String sIfOfcCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String vatAmt = null;
	/* Column Info */
	private String invIssLoclDt = null;
	/* Column Info */
	private String sEqNo = null;
	/* Column Info */
	private String otsAmt = null;
	/* Column Info */
	private String sIfRhqCd = null;
	/* Column Info */
	private String cntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTPBInvoiceListVO() {}

	public SearchTPBInvoiceListVO(String ibflag, String pagerows, String ofcCd, String n3ptyNo, String n3ptyInvNo, String n3ptyInvRvisCd, String ifBlNo, String n3ptyExpnTpCd, String currCd, String otsAmt, String vatAmt, String invAmt, String cltAmt, String invIssLoclDt, String updUsrId, String cltAgnFlg, String trdPartyNm, String arIfDt, String lengthN3ptyBilTpCd, String vndrCustDivCd, String trdPartyCode, String n3ptyInvHisSeq, String sUsrOfcCd, String sCond, String sSdate, String sEdate, String sIfRhqCd, String sIfCtrlCd, String sIfOfcCd, String sN3ptyInvNoForSearch, String sN3ptyInvRmdCdForSearch, String sEqNo, String sCltAgnFlg, String sN3ptyInvStsCd, String sVndrCustDivCd, String sTrdPartyVal, String sInvceSearchVersion, String cntCd) {
		this.sN3ptyInvNoForSearch = sN3ptyInvNoForSearch;
		this.cltAgnFlg = cltAgnFlg;
		this.currCd = currCd;
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
		this.trdPartyCode = trdPartyCode;
		this.sN3ptyInvRmdCdForSearch = sN3ptyInvRmdCdForSearch;
		this.cltAmt = cltAmt;
		this.n3ptyInvRvisCd = n3ptyInvRvisCd;
		this.sTrdPartyVal = sTrdPartyVal;
		this.sIfCtrlCd = sIfCtrlCd;
		this.n3ptyInvNo = n3ptyInvNo;
		this.n3ptyInvHisSeq = n3ptyInvHisSeq;
		this.pagerows = pagerows;
		this.vndrCustDivCd = vndrCustDivCd;
		this.ibflag = ibflag;
		this.sCltAgnFlg = sCltAgnFlg;
		this.lengthN3ptyBilTpCd = lengthN3ptyBilTpCd;
		this.n3ptyNo = n3ptyNo;
		this.trdPartyNm = trdPartyNm;
		this.sUsrOfcCd = sUsrOfcCd;
		this.invAmt = invAmt;
		this.arIfDt = arIfDt;
		this.sN3ptyInvStsCd = sN3ptyInvStsCd;
		this.sInvceSearchVersion = sInvceSearchVersion;
		this.updUsrId = updUsrId;
		this.sCond = sCond;
		this.sEdate = sEdate;
		this.ifBlNo = ifBlNo;
		this.sSdate = sSdate;
		this.sVndrCustDivCd = sVndrCustDivCd;
		this.sIfOfcCd = sIfOfcCd;
		this.ofcCd = ofcCd;
		this.vatAmt = vatAmt;
		this.invIssLoclDt = invIssLoclDt;
		this.sEqNo = sEqNo;
		this.otsAmt = otsAmt;
		this.sIfRhqCd = sIfRhqCd;
		this.cntCd = cntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_n3pty_inv_no_for_search", getSN3ptyInvNoForSearch());
		this.hashColumns.put("clt_agn_flg", getCltAgnFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("n3pty_expn_tp_cd", getN3ptyExpnTpCd());
		this.hashColumns.put("trd_party_code", getTrdPartyCode());
		this.hashColumns.put("s_n3pty_inv_rmd_cd_for_search", getSN3ptyInvRmdCdForSearch());
		this.hashColumns.put("clt_amt", getCltAmt());
		this.hashColumns.put("n3pty_inv_rvis_cd", getN3ptyInvRvisCd());
		this.hashColumns.put("s_trd_party_val", getSTrdPartyVal());
		this.hashColumns.put("s_if_ctrl_cd", getSIfCtrlCd());
		this.hashColumns.put("n3pty_inv_no", getN3ptyInvNo());
		this.hashColumns.put("n3pty_inv_his_seq", getN3ptyInvHisSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_cust_div_cd", getVndrCustDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_clt_agn_flg", getSCltAgnFlg());
		this.hashColumns.put("length_n3pty_bil_tp_cd", getLengthN3ptyBilTpCd());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("trd_party_nm", getTrdPartyNm());
		this.hashColumns.put("s_usr_ofc_cd", getSUsrOfcCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("ar_if_dt", getArIfDt());
		this.hashColumns.put("s_n3pty_inv_sts_cd", getSN3ptyInvStsCd());
		this.hashColumns.put("s_invce_search_version", getSInvceSearchVersion());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("s_cond", getSCond());
		this.hashColumns.put("s_edate", getSEdate());
		this.hashColumns.put("if_bl_no", getIfBlNo());
		this.hashColumns.put("s_sdate", getSSdate());
		this.hashColumns.put("s_vndr_cust_div_cd", getSVndrCustDivCd());
		this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("vat_amt", getVatAmt());
		this.hashColumns.put("inv_iss_locl_dt", getInvIssLoclDt());
		this.hashColumns.put("s_eq_no", getSEqNo());
		this.hashColumns.put("ots_amt", getOtsAmt());
		this.hashColumns.put("s_if_rhq_cd", getSIfRhqCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_n3pty_inv_no_for_search", "sN3ptyInvNoForSearch");
		this.hashFields.put("clt_agn_flg", "cltAgnFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("n3pty_expn_tp_cd", "n3ptyExpnTpCd");
		this.hashFields.put("trd_party_code", "trdPartyCode");
		this.hashFields.put("s_n3pty_inv_rmd_cd_for_search", "sN3ptyInvRmdCdForSearch");
		this.hashFields.put("clt_amt", "cltAmt");
		this.hashFields.put("n3pty_inv_rvis_cd", "n3ptyInvRvisCd");
		this.hashFields.put("s_trd_party_val", "sTrdPartyVal");
		this.hashFields.put("s_if_ctrl_cd", "sIfCtrlCd");
		this.hashFields.put("n3pty_inv_no", "n3ptyInvNo");
		this.hashFields.put("n3pty_inv_his_seq", "n3ptyInvHisSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_cust_div_cd", "vndrCustDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_clt_agn_flg", "sCltAgnFlg");
		this.hashFields.put("length_n3pty_bil_tp_cd", "lengthN3ptyBilTpCd");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("trd_party_nm", "trdPartyNm");
		this.hashFields.put("s_usr_ofc_cd", "sUsrOfcCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("ar_if_dt", "arIfDt");
		this.hashFields.put("s_n3pty_inv_sts_cd", "sN3ptyInvStsCd");
		this.hashFields.put("s_invce_search_version", "sInvceSearchVersion");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("s_cond", "sCond");
		this.hashFields.put("s_edate", "sEdate");
		this.hashFields.put("if_bl_no", "ifBlNo");
		this.hashFields.put("s_sdate", "sSdate");
		this.hashFields.put("s_vndr_cust_div_cd", "sVndrCustDivCd");
		this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("vat_amt", "vatAmt");
		this.hashFields.put("inv_iss_locl_dt", "invIssLoclDt");
		this.hashFields.put("s_eq_no", "sEqNo");
		this.hashFields.put("ots_amt", "otsAmt");
		this.hashFields.put("s_if_rhq_cd", "sIfRhqCd");
		this.hashFields.put("cnt_cd", "cntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvNoForSearch
	 */
	public String getSN3ptyInvNoForSearch() {
		return this.sN3ptyInvNoForSearch;
	}
	
	/**
	 * Column Info
	 * @return cltAgnFlg
	 */
	public String getCltAgnFlg() {
		return this.cltAgnFlg;
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
	 * @return n3ptyExpnTpCd
	 */
	public String getN3ptyExpnTpCd() {
		return this.n3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @return trdPartyCode
	 */
	public String getTrdPartyCode() {
		return this.trdPartyCode;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvRmdCdForSearch
	 */
	public String getSN3ptyInvRmdCdForSearch() {
		return this.sN3ptyInvRmdCdForSearch;
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
	 * @return n3ptyInvRvisCd
	 */
	public String getN3ptyInvRvisCd() {
		return this.n3ptyInvRvisCd;
	}
	
	/**
	 * Column Info
	 * @return sTrdPartyVal
	 */
	public String getSTrdPartyVal() {
		return this.sTrdPartyVal;
	}
	
	/**
	 * Column Info
	 * @return sIfCtrlCd
	 */
	public String getSIfCtrlCd() {
		return this.sIfCtrlCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvNo
	 */
	public String getN3ptyInvNo() {
		return this.n3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvHisSeq
	 */
	public String getN3ptyInvHisSeq() {
		return this.n3ptyInvHisSeq;
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
	 * @return vndrCustDivCd
	 */
	public String getVndrCustDivCd() {
		return this.vndrCustDivCd;
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
	 * @return sCltAgnFlg
	 */
	public String getSCltAgnFlg() {
		return this.sCltAgnFlg;
	}
	
	/**
	 * Column Info
	 * @return lengthN3ptyBilTpCd
	 */
	public String getLengthN3ptyBilTpCd() {
		return this.lengthN3ptyBilTpCd;
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
	 * @return trdPartyNm
	 */
	public String getTrdPartyNm() {
		return this.trdPartyNm;
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
	 * @return arIfDt
	 */
	public String getArIfDt() {
		return this.arIfDt;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvStsCd
	 */
	public String getSN3ptyInvStsCd() {
		return this.sN3ptyInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return sInvceSearchVersion
	 */
	public String getSInvceSearchVersion() {
		return this.sInvceSearchVersion;
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
	 * @return sCond
	 */
	public String getSCond() {
		return this.sCond;
	}
	
	/**
	 * Column Info
	 * @return sEdate
	 */
	public String getSEdate() {
		return this.sEdate;
	}
	
	/**
	 * Column Info
	 * @return ifBlNo
	 */
	public String getIfBlNo() {
		return this.ifBlNo;
	}
	
	/**
	 * Column Info
	 * @return sSdate
	 */
	public String getSSdate() {
		return this.sSdate;
	}
	
	/**
	 * Column Info
	 * @return sVndrCustDivCd
	 */
	public String getSVndrCustDivCd() {
		return this.sVndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @return sIfOfcCd
	 */
	public String getSIfOfcCd() {
		return this.sIfOfcCd;
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
	 * @return vatAmt
	 */
	public String getVatAmt() {
		return this.vatAmt;
	}
	
	/**
	 * Column Info
	 * @return invIssLoclDt
	 */
	public String getInvIssLoclDt() {
		return this.invIssLoclDt;
	}
	
	/**
	 * Column Info
	 * @return sEqNo
	 */
	public String getSEqNo() {
		return this.sEqNo;
	}
	
	/**
	 * Column Info
	 * @return otsAmt
	 */
	public String getOtsAmt() {
		return this.otsAmt;
	}
	
	/**
	 * Column Info
	 * @return sIfRhqCd
	 */
	public String getSIfRhqCd() {
		return this.sIfRhqCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}

	/**
	 * Column Info
	 * @param sN3ptyInvNoForSearch
	 */
	public void setSN3ptyInvNoForSearch(String sN3ptyInvNoForSearch) {
		this.sN3ptyInvNoForSearch = sN3ptyInvNoForSearch;
	}
	
	/**
	 * Column Info
	 * @param cltAgnFlg
	 */
	public void setCltAgnFlg(String cltAgnFlg) {
		this.cltAgnFlg = cltAgnFlg;
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
	 * @param n3ptyExpnTpCd
	 */
	public void setN3ptyExpnTpCd(String n3ptyExpnTpCd) {
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @param trdPartyCode
	 */
	public void setTrdPartyCode(String trdPartyCode) {
		this.trdPartyCode = trdPartyCode;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvRmdCdForSearch
	 */
	public void setSN3ptyInvRmdCdForSearch(String sN3ptyInvRmdCdForSearch) {
		this.sN3ptyInvRmdCdForSearch = sN3ptyInvRmdCdForSearch;
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
	 * @param n3ptyInvRvisCd
	 */
	public void setN3ptyInvRvisCd(String n3ptyInvRvisCd) {
		this.n3ptyInvRvisCd = n3ptyInvRvisCd;
	}
	
	/**
	 * Column Info
	 * @param sTrdPartyVal
	 */
	public void setSTrdPartyVal(String sTrdPartyVal) {
		this.sTrdPartyVal = sTrdPartyVal;
	}
	
	/**
	 * Column Info
	 * @param sIfCtrlCd
	 */
	public void setSIfCtrlCd(String sIfCtrlCd) {
		this.sIfCtrlCd = sIfCtrlCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvNo
	 */
	public void setN3ptyInvNo(String n3ptyInvNo) {
		this.n3ptyInvNo = n3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvHisSeq
	 */
	public void setN3ptyInvHisSeq(String n3ptyInvHisSeq) {
		this.n3ptyInvHisSeq = n3ptyInvHisSeq;
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
	 * @param vndrCustDivCd
	 */
	public void setVndrCustDivCd(String vndrCustDivCd) {
		this.vndrCustDivCd = vndrCustDivCd;
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
	 * @param sCltAgnFlg
	 */
	public void setSCltAgnFlg(String sCltAgnFlg) {
		this.sCltAgnFlg = sCltAgnFlg;
	}
	
	/**
	 * Column Info
	 * @param lengthN3ptyBilTpCd
	 */
	public void setLengthN3ptyBilTpCd(String lengthN3ptyBilTpCd) {
		this.lengthN3ptyBilTpCd = lengthN3ptyBilTpCd;
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
	 * @param trdPartyNm
	 */
	public void setTrdPartyNm(String trdPartyNm) {
		this.trdPartyNm = trdPartyNm;
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
	 * @param arIfDt
	 */
	public void setArIfDt(String arIfDt) {
		this.arIfDt = arIfDt;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvStsCd
	 */
	public void setSN3ptyInvStsCd(String sN3ptyInvStsCd) {
		this.sN3ptyInvStsCd = sN3ptyInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param sInvceSearchVersion
	 */
	public void setSInvceSearchVersion(String sInvceSearchVersion) {
		this.sInvceSearchVersion = sInvceSearchVersion;
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
	 * @param sCond
	 */
	public void setSCond(String sCond) {
		this.sCond = sCond;
	}
	
	/**
	 * Column Info
	 * @param sEdate
	 */
	public void setSEdate(String sEdate) {
		this.sEdate = sEdate;
	}
	
	/**
	 * Column Info
	 * @param ifBlNo
	 */
	public void setIfBlNo(String ifBlNo) {
		this.ifBlNo = ifBlNo;
	}
	
	/**
	 * Column Info
	 * @param sSdate
	 */
	public void setSSdate(String sSdate) {
		this.sSdate = sSdate;
	}
	
	/**
	 * Column Info
	 * @param sVndrCustDivCd
	 */
	public void setSVndrCustDivCd(String sVndrCustDivCd) {
		this.sVndrCustDivCd = sVndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @param sIfOfcCd
	 */
	public void setSIfOfcCd(String sIfOfcCd) {
		this.sIfOfcCd = sIfOfcCd;
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
	 * @param vatAmt
	 */
	public void setVatAmt(String vatAmt) {
		this.vatAmt = vatAmt;
	}
	
	/**
	 * Column Info
	 * @param invIssLoclDt
	 */
	public void setInvIssLoclDt(String invIssLoclDt) {
		this.invIssLoclDt = invIssLoclDt;
	}
	
	/**
	 * Column Info
	 * @param sEqNo
	 */
	public void setSEqNo(String sEqNo) {
		this.sEqNo = sEqNo;
	}
	
	/**
	 * Column Info
	 * @param otsAmt
	 */
	public void setOtsAmt(String otsAmt) {
		this.otsAmt = otsAmt;
	}
	
	/**
	 * Column Info
	 * @param sIfRhqCd
	 */
	public void setSIfRhqCd(String sIfRhqCd) {
		this.sIfRhqCd = sIfRhqCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSN3ptyInvNoForSearch(JSPUtil.getParameter(request, "s_n3pty_inv_no_for_search", ""));
		setCltAgnFlg(JSPUtil.getParameter(request, "clt_agn_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setN3ptyExpnTpCd(JSPUtil.getParameter(request, "n3pty_expn_tp_cd", ""));
		setTrdPartyCode(JSPUtil.getParameter(request, "trd_party_code", ""));
		setSN3ptyInvRmdCdForSearch(JSPUtil.getParameter(request, "s_n3pty_inv_rmd_cd_for_search", ""));
		setCltAmt(JSPUtil.getParameter(request, "clt_amt", ""));
		setN3ptyInvRvisCd(JSPUtil.getParameter(request, "n3pty_inv_rvis_cd", ""));
		setSTrdPartyVal(JSPUtil.getParameter(request, "s_trd_party_val", ""));
		setSIfCtrlCd(JSPUtil.getParameter(request, "s_if_ctrl_cd", ""));
		setN3ptyInvNo(JSPUtil.getParameter(request, "n3pty_inv_no", ""));
		setN3ptyInvHisSeq(JSPUtil.getParameter(request, "n3pty_inv_his_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVndrCustDivCd(JSPUtil.getParameter(request, "vndr_cust_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSCltAgnFlg(JSPUtil.getParameter(request, "s_clt_agn_flg", ""));
		setLengthN3ptyBilTpCd(JSPUtil.getParameter(request, "length_n3pty_bil_tp_cd", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setTrdPartyNm(JSPUtil.getParameter(request, "trd_party_nm", ""));
		setSUsrOfcCd(JSPUtil.getParameter(request, "s_usr_ofc_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setArIfDt(JSPUtil.getParameter(request, "ar_if_dt", ""));
		setSN3ptyInvStsCd(JSPUtil.getParameter(request, "s_n3pty_inv_sts_cd", ""));
		setSInvceSearchVersion(JSPUtil.getParameter(request, "s_invce_search_version", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSCond(JSPUtil.getParameter(request, "s_cond", ""));
		setSEdate(JSPUtil.getParameter(request, "s_edate", ""));
		setIfBlNo(JSPUtil.getParameter(request, "if_bl_no", ""));
		setSSdate(JSPUtil.getParameter(request, "s_sdate", ""));
		setSVndrCustDivCd(JSPUtil.getParameter(request, "s_vndr_cust_div_cd", ""));
		setSIfOfcCd(JSPUtil.getParameter(request, "s_if_ofc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setVatAmt(JSPUtil.getParameter(request, "vat_amt", ""));
		setInvIssLoclDt(JSPUtil.getParameter(request, "inv_iss_locl_dt", ""));
		setSEqNo(JSPUtil.getParameter(request, "s_eq_no", ""));
		setOtsAmt(JSPUtil.getParameter(request, "ots_amt", ""));
		setSIfRhqCd(JSPUtil.getParameter(request, "s_if_rhq_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTPBInvoiceListVO[]
	 */
	public SearchTPBInvoiceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTPBInvoiceListVO[]
	 */
	public SearchTPBInvoiceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTPBInvoiceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sN3ptyInvNoForSearch = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_no_for_search", length));
			String[] cltAgnFlg = (JSPUtil.getParameter(request, prefix	+ "clt_agn_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] n3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_expn_tp_cd", length));
			String[] trdPartyCode = (JSPUtil.getParameter(request, prefix	+ "trd_party_code", length));
			String[] sN3ptyInvRmdCdForSearch = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_rmd_cd_for_search", length));
			String[] cltAmt = (JSPUtil.getParameter(request, prefix	+ "clt_amt", length));
			String[] n3ptyInvRvisCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_rvis_cd", length));
			String[] sTrdPartyVal = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_val", length));
			String[] sIfCtrlCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ctrl_cd", length));
			String[] n3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no", length));
			String[] n3ptyInvHisSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_his_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_div_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sCltAgnFlg = (JSPUtil.getParameter(request, prefix	+ "s_clt_agn_flg", length));
			String[] lengthN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "length_n3pty_bil_tp_cd", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] trdPartyNm = (JSPUtil.getParameter(request, prefix	+ "trd_party_nm", length));
			String[] sUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_usr_ofc_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] arIfDt = (JSPUtil.getParameter(request, prefix	+ "ar_if_dt", length));
			String[] sN3ptyInvStsCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_sts_cd", length));
			String[] sInvceSearchVersion = (JSPUtil.getParameter(request, prefix	+ "s_invce_search_version", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] sCond = (JSPUtil.getParameter(request, prefix	+ "s_cond", length));
			String[] sEdate = (JSPUtil.getParameter(request, prefix	+ "s_edate", length));
			String[] ifBlNo = (JSPUtil.getParameter(request, prefix	+ "if_bl_no", length));
			String[] sSdate = (JSPUtil.getParameter(request, prefix	+ "s_sdate", length));
			String[] sVndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_div_cd", length));
			String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ofc_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] vatAmt = (JSPUtil.getParameter(request, prefix	+ "vat_amt", length));
			String[] invIssLoclDt = (JSPUtil.getParameter(request, prefix	+ "inv_iss_locl_dt", length));
			String[] sEqNo = (JSPUtil.getParameter(request, prefix	+ "s_eq_no", length));
			String[] otsAmt = (JSPUtil.getParameter(request, prefix	+ "ots_amt", length));
			String[] sIfRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_if_rhq_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTPBInvoiceListVO();
				if (sN3ptyInvNoForSearch[i] != null)
					model.setSN3ptyInvNoForSearch(sN3ptyInvNoForSearch[i]);
				if (cltAgnFlg[i] != null)
					model.setCltAgnFlg(cltAgnFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (n3ptyExpnTpCd[i] != null)
					model.setN3ptyExpnTpCd(n3ptyExpnTpCd[i]);
				if (trdPartyCode[i] != null)
					model.setTrdPartyCode(trdPartyCode[i]);
				if (sN3ptyInvRmdCdForSearch[i] != null)
					model.setSN3ptyInvRmdCdForSearch(sN3ptyInvRmdCdForSearch[i]);
				if (cltAmt[i] != null)
					model.setCltAmt(cltAmt[i]);
				if (n3ptyInvRvisCd[i] != null)
					model.setN3ptyInvRvisCd(n3ptyInvRvisCd[i]);
				if (sTrdPartyVal[i] != null)
					model.setSTrdPartyVal(sTrdPartyVal[i]);
				if (sIfCtrlCd[i] != null)
					model.setSIfCtrlCd(sIfCtrlCd[i]);
				if (n3ptyInvNo[i] != null)
					model.setN3ptyInvNo(n3ptyInvNo[i]);
				if (n3ptyInvHisSeq[i] != null)
					model.setN3ptyInvHisSeq(n3ptyInvHisSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrCustDivCd[i] != null)
					model.setVndrCustDivCd(vndrCustDivCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sCltAgnFlg[i] != null)
					model.setSCltAgnFlg(sCltAgnFlg[i]);
				if (lengthN3ptyBilTpCd[i] != null)
					model.setLengthN3ptyBilTpCd(lengthN3ptyBilTpCd[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (trdPartyNm[i] != null)
					model.setTrdPartyNm(trdPartyNm[i]);
				if (sUsrOfcCd[i] != null)
					model.setSUsrOfcCd(sUsrOfcCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (arIfDt[i] != null)
					model.setArIfDt(arIfDt[i]);
				if (sN3ptyInvStsCd[i] != null)
					model.setSN3ptyInvStsCd(sN3ptyInvStsCd[i]);
				if (sInvceSearchVersion[i] != null)
					model.setSInvceSearchVersion(sInvceSearchVersion[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sCond[i] != null)
					model.setSCond(sCond[i]);
				if (sEdate[i] != null)
					model.setSEdate(sEdate[i]);
				if (ifBlNo[i] != null)
					model.setIfBlNo(ifBlNo[i]);
				if (sSdate[i] != null)
					model.setSSdate(sSdate[i]);
				if (sVndrCustDivCd[i] != null)
					model.setSVndrCustDivCd(sVndrCustDivCd[i]);
				if (sIfOfcCd[i] != null)
					model.setSIfOfcCd(sIfOfcCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (vatAmt[i] != null)
					model.setVatAmt(vatAmt[i]);
				if (invIssLoclDt[i] != null)
					model.setInvIssLoclDt(invIssLoclDt[i]);
				if (sEqNo[i] != null)
					model.setSEqNo(sEqNo[i]);
				if (otsAmt[i] != null)
					model.setOtsAmt(otsAmt[i]);
				if (sIfRhqCd[i] != null)
					model.setSIfRhqCd(sIfRhqCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTpbInvoiceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTPBInvoiceListVO[]
	 */
	public SearchTPBInvoiceListVO[] getSearchTpbInvoiceListVOs(){
		SearchTPBInvoiceListVO[] vos = (SearchTPBInvoiceListVO[])models.toArray(new SearchTPBInvoiceListVO[models.size()]);
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
		this.sN3ptyInvNoForSearch = this.sN3ptyInvNoForSearch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltAgnFlg = this.cltAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyExpnTpCd = this.n3ptyExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyCode = this.trdPartyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvRmdCdForSearch = this.sN3ptyInvRmdCdForSearch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltAmt = this.cltAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvRvisCd = this.n3ptyInvRvisCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyVal = this.sTrdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfCtrlCd = this.sIfCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNo = this.n3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvHisSeq = this.n3ptyInvHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustDivCd = this.vndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCltAgnFlg = this.sCltAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lengthN3ptyBilTpCd = this.lengthN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyNm = this.trdPartyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUsrOfcCd = this.sUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfDt = this.arIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvStsCd = this.sN3ptyInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvceSearchVersion = this.sInvceSearchVersion .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCond = this.sCond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdate = this.sEdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifBlNo = this.ifBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSdate = this.sSdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustDivCd = this.sVndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfOfcCd = this.sIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatAmt = this.vatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssLoclDt = this.invIssLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqNo = this.sEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAmt = this.otsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfRhqCd = this.sIfRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
