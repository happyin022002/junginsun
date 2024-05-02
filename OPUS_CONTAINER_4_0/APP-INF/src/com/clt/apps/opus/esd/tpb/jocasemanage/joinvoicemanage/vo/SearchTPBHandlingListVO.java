/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchTPBHandlingListVO.java
*@FileTitle : SearchTPBHandlingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.02.16 최 선 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo;

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
 * @author 최 선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTPBHandlingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTPBHandlingListVO> models = new ArrayList<SearchTPBHandlingListVO>();
	
	/* Column Info */
	private String trdPartyCode = null;
	/* Column Info */
	private String erpifDt = null;
	/* Column Info */
	private String sBkgNoAll = null;
	/* Column Info */
	private String n3ptyInvRvisCd = null;
	/* Column Info */
	private String sTrdPartyVal = null;
	/* Column Info */
	private String revenueVvd = null;
	/* Column Info */
	private String n3ptyBilTpNm = null;
	/* Column Info */
	private String n3ptyInvNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sN3ptyNoStrsLink = null;
	/* Column Info */
	private String n3ptyBilTpCd = null;
	/* Column Info */
	private String lengthN3ptyBilTpCd = null;
	/* Column Info */
	private String sEqKndCd = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String n3ptyInvRvisSeq = null;
	/* Column Info */
	private String reviseAble = null;
	/* Column Info */
	private String trdPartyName = null;
	/* Column Info */
	private String rcvrActYn = null;
	/* Column Info */
	private String sN3ptySrcNo = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String erpifUsrNm = null;
	/* Column Info */
	private String sBlNoAll = null;
	/* Column Info */
	private String sVndrCustDivCd = null;
	/* Column Info */
	private String trdPartyCodeO = null;
	/* Column Info */
	private String otsAmt = null;
	/* Column Info */
	private String erpifAble = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String ifAmtUsd = null;
	/* Column Info */
	private String n3ptySrcSubSysCd = null;
	/* Column Info */
	private String erpifUsrId = null;
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String cfmUsrNm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String vndrCustDivCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String overdue = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String invoiceAble = null;
	/* Column Info */
	private String sEdate = null;
	/* Column Info */
	private String sN3ptyNo = null;
	/* Column Info */
	private String rvsAmt = null;
	/* Column Info */
	private String sStatus = null;
	/* Column Info */
	private String sSdate = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String sN3ptyInvNoSearch = null;
	/* Column Info */
	private String sN3ptySrcSubSysCd = null;
	/* Column Info */
	private String sEqNo = null;
	/* Column Info */
	private String ifCurrCd = null;
	/* Column Info */
	private String n3ptySrcNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTPBHandlingListVO() {}

	public SearchTPBHandlingListVO(String ibflag, String pagerows, String n3ptyNo, String n3ptyInvNo, String n3ptyInvRvisSeq, String n3ptyInvRvisCd, String n3ptySrcSubSysCd, String n3ptyBilTpCd, String n3ptyBilTpNm, String n3ptySrcNo, String eqNo, String vndrCustDivCd, String trdPartyCode, String trdPartyName, String revenueVvd, String ifCurrCd, String ifAmt, String ifAmtUsd, String currCd, String otsAmt, String rvsAmt, String cfmUsrId, String cfmUsrNm, String cfmDt, String overdue, String erpifUsrId, String erpifUsrNm, String erpifDt, String rcvrActYn, String invoiceAble, String reviseAble, String erpifAble, String lengthN3ptyBilTpCd, String trdPartyCodeO, String sStatus, String userOfcCd, String sN3ptyNoStrsLink, String sN3ptyNo, String sN3ptyInvNoSearch, String sBkgNoAll, String sBlNoAll, String sSdate, String sEdate, String sN3ptySrcSubSysCd, String sN3ptySrcNo, String sVvd, String sEqKndCd, String sEqNo, String sVndrCustDivCd, String sTrdPartyVal) {
		this.trdPartyCode = trdPartyCode;
		this.erpifDt = erpifDt;
		this.sBkgNoAll = sBkgNoAll;
		this.n3ptyInvRvisCd = n3ptyInvRvisCd;
		this.sTrdPartyVal = sTrdPartyVal;
		this.revenueVvd = revenueVvd;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.n3ptyInvNo = n3ptyInvNo;
		this.pagerows = pagerows;
		this.sN3ptyNoStrsLink = sN3ptyNoStrsLink;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.lengthN3ptyBilTpCd = lengthN3ptyBilTpCd;
		this.sEqKndCd = sEqKndCd;
		this.cfmUsrId = cfmUsrId;
		this.n3ptyInvRvisSeq = n3ptyInvRvisSeq;
		this.reviseAble = reviseAble;
		this.trdPartyName = trdPartyName;
		this.rcvrActYn = rcvrActYn;
		this.sN3ptySrcNo = sN3ptySrcNo;
		this.cfmDt = cfmDt;
		this.erpifUsrNm = erpifUsrNm;
		this.sBlNoAll = sBlNoAll;
		this.sVndrCustDivCd = sVndrCustDivCd;
		this.trdPartyCodeO = trdPartyCodeO;
		this.otsAmt = otsAmt;
		this.erpifAble = erpifAble;
		this.ifAmt = ifAmt;
		this.ifAmtUsd = ifAmtUsd;
		this.n3ptySrcSubSysCd = n3ptySrcSubSysCd;
		this.erpifUsrId = erpifUsrId;
		this.userOfcCd = userOfcCd;
		this.cfmUsrNm = cfmUsrNm;
		this.currCd = currCd;
		this.vndrCustDivCd = vndrCustDivCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.overdue = overdue;
		this.n3ptyNo = n3ptyNo;
		this.invoiceAble = invoiceAble;
		this.sEdate = sEdate;
		this.sN3ptyNo = sN3ptyNo;
		this.rvsAmt = rvsAmt;
		this.sStatus = sStatus;
		this.sSdate = sSdate;
		this.sVvd = sVvd;
		this.sN3ptyInvNoSearch = sN3ptyInvNoSearch;
		this.sN3ptySrcSubSysCd = sN3ptySrcSubSysCd;
		this.sEqNo = sEqNo;
		this.ifCurrCd = ifCurrCd;
		this.n3ptySrcNo = n3ptySrcNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trd_party_code", getTrdPartyCode());
		this.hashColumns.put("erpif_dt", getErpifDt());
		this.hashColumns.put("s_bkg_no_all", getSBkgNoAll());
		this.hashColumns.put("n3pty_inv_rvis_cd", getN3ptyInvRvisCd());
		this.hashColumns.put("s_trd_party_val", getSTrdPartyVal());
		this.hashColumns.put("revenue_vvd", getRevenueVvd());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("n3pty_inv_no", getN3ptyInvNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_n3pty_no_strs_link", getSN3ptyNoStrsLink());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("length_n3pty_bil_tp_cd", getLengthN3ptyBilTpCd());
		this.hashColumns.put("s_eq_knd_cd", getSEqKndCd());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("n3pty_inv_rvis_seq", getN3ptyInvRvisSeq());
		this.hashColumns.put("revise_able", getReviseAble());
		this.hashColumns.put("trd_party_name", getTrdPartyName());
		this.hashColumns.put("rcvr_act_yn", getRcvrActYn());
		this.hashColumns.put("s_n3pty_src_no", getSN3ptySrcNo());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("erpif_usr_nm", getErpifUsrNm());
		this.hashColumns.put("s_bl_no_all", getSBlNoAll());
		this.hashColumns.put("s_vndr_cust_div_cd", getSVndrCustDivCd());
		this.hashColumns.put("trd_party_code_o", getTrdPartyCodeO());
		this.hashColumns.put("ots_amt", getOtsAmt());
		this.hashColumns.put("erpif_able", getErpifAble());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("if_amt_usd", getIfAmtUsd());
		this.hashColumns.put("n3pty_src_sub_sys_cd", getN3ptySrcSubSysCd());
		this.hashColumns.put("erpif_usr_id", getErpifUsrId());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("cfm_usr_nm", getCfmUsrNm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("vndr_cust_div_cd", getVndrCustDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("overdue", getOverdue());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("invoice_able", getInvoiceAble());
		this.hashColumns.put("s_edate", getSEdate());
		this.hashColumns.put("s_n3pty_no", getSN3ptyNo());
		this.hashColumns.put("rvs_amt", getRvsAmt());
		this.hashColumns.put("s_status", getSStatus());
		this.hashColumns.put("s_sdate", getSSdate());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("s_n3pty_inv_no_search", getSN3ptyInvNoSearch());
		this.hashColumns.put("s_n3pty_src_sub_sys_cd", getSN3ptySrcSubSysCd());
		this.hashColumns.put("s_eq_no", getSEqNo());
		this.hashColumns.put("if_curr_cd", getIfCurrCd());
		this.hashColumns.put("n3pty_src_no", getN3ptySrcNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trd_party_code", "trdPartyCode");
		this.hashFields.put("erpif_dt", "erpifDt");
		this.hashFields.put("s_bkg_no_all", "sBkgNoAll");
		this.hashFields.put("n3pty_inv_rvis_cd", "n3ptyInvRvisCd");
		this.hashFields.put("s_trd_party_val", "sTrdPartyVal");
		this.hashFields.put("revenue_vvd", "revenueVvd");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
		this.hashFields.put("n3pty_inv_no", "n3ptyInvNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_n3pty_no_strs_link", "sN3ptyNoStrsLink");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("length_n3pty_bil_tp_cd", "lengthN3ptyBilTpCd");
		this.hashFields.put("s_eq_knd_cd", "sEqKndCd");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("n3pty_inv_rvis_seq", "n3ptyInvRvisSeq");
		this.hashFields.put("revise_able", "reviseAble");
		this.hashFields.put("trd_party_name", "trdPartyName");
		this.hashFields.put("rcvr_act_yn", "rcvrActYn");
		this.hashFields.put("s_n3pty_src_no", "sN3ptySrcNo");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("erpif_usr_nm", "erpifUsrNm");
		this.hashFields.put("s_bl_no_all", "sBlNoAll");
		this.hashFields.put("s_vndr_cust_div_cd", "sVndrCustDivCd");
		this.hashFields.put("trd_party_code_o", "trdPartyCodeO");
		this.hashFields.put("ots_amt", "otsAmt");
		this.hashFields.put("erpif_able", "erpifAble");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("if_amt_usd", "ifAmtUsd");
		this.hashFields.put("n3pty_src_sub_sys_cd", "n3ptySrcSubSysCd");
		this.hashFields.put("erpif_usr_id", "erpifUsrId");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("cfm_usr_nm", "cfmUsrNm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("vndr_cust_div_cd", "vndrCustDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("overdue", "overdue");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("invoice_able", "invoiceAble");
		this.hashFields.put("s_edate", "sEdate");
		this.hashFields.put("s_n3pty_no", "sN3ptyNo");
		this.hashFields.put("rvs_amt", "rvsAmt");
		this.hashFields.put("s_status", "sStatus");
		this.hashFields.put("s_sdate", "sSdate");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("s_n3pty_inv_no_search", "sN3ptyInvNoSearch");
		this.hashFields.put("s_n3pty_src_sub_sys_cd", "sN3ptySrcSubSysCd");
		this.hashFields.put("s_eq_no", "sEqNo");
		this.hashFields.put("if_curr_cd", "ifCurrCd");
		this.hashFields.put("n3pty_src_no", "n3ptySrcNo");
		return this.hashFields;
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
	 * @return erpifDt
	 */
	public String getErpifDt() {
		return this.erpifDt;
	}
	
	/**
	 * Column Info
	 * @return sBkgNoAll
	 */
	public String getSBkgNoAll() {
		return this.sBkgNoAll;
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
	 * @return revenueVvd
	 */
	public String getRevenueVvd() {
		return this.revenueVvd;
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
	 * @return sN3ptyNoStrsLink
	 */
	public String getSN3ptyNoStrsLink() {
		return this.sN3ptyNoStrsLink;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpCd
	 */
	public String getN3ptyBilTpCd() {
		return this.n3ptyBilTpCd;
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
	 * @return sEqKndCd
	 */
	public String getSEqKndCd() {
		return this.sEqKndCd;
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
	 * @return n3ptyInvRvisSeq
	 */
	public String getN3ptyInvRvisSeq() {
		return this.n3ptyInvRvisSeq;
	}
	
	/**
	 * Column Info
	 * @return reviseAble
	 */
	public String getReviseAble() {
		return this.reviseAble;
	}
	
	/**
	 * Column Info
	 * @return trdPartyName
	 */
	public String getTrdPartyName() {
		return this.trdPartyName;
	}
	
	/**
	 * Column Info
	 * @return rcvrActYn
	 */
	public String getRcvrActYn() {
		return this.rcvrActYn;
	}
	
	/**
	 * Column Info
	 * @return sN3ptySrcNo
	 */
	public String getSN3ptySrcNo() {
		return this.sN3ptySrcNo;
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
	 * @return erpifUsrNm
	 */
	public String getErpifUsrNm() {
		return this.erpifUsrNm;
	}
	
	/**
	 * Column Info
	 * @return sBlNoAll
	 */
	public String getSBlNoAll() {
		return this.sBlNoAll;
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
	 * @return trdPartyCodeO
	 */
	public String getTrdPartyCodeO() {
		return this.trdPartyCodeO;
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
	 * @return erpifAble
	 */
	public String getErpifAble() {
		return this.erpifAble;
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
	 * @return ifAmtUsd
	 */
	public String getIfAmtUsd() {
		return this.ifAmtUsd;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcSubSysCd
	 */
	public String getN3ptySrcSubSysCd() {
		return this.n3ptySrcSubSysCd;
	}
	
	/**
	 * Column Info
	 * @return erpifUsrId
	 */
	public String getErpifUsrId() {
		return this.erpifUsrId;
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
	 * @return cfmUsrNm
	 */
	public String getCfmUsrNm() {
		return this.cfmUsrNm;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return overdue
	 */
	public String getOverdue() {
		return this.overdue;
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
	 * @return invoiceAble
	 */
	public String getInvoiceAble() {
		return this.invoiceAble;
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
	 * @return sN3ptyNo
	 */
	public String getSN3ptyNo() {
		return this.sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return rvsAmt
	 */
	public String getRvsAmt() {
		return this.rvsAmt;
	}
	
	/**
	 * Column Info
	 * @return sStatus
	 */
	public String getSStatus() {
		return this.sStatus;
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
	 * @return sVvd
	 */
	public String getSVvd() {
		return this.sVvd;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvNoSearch
	 */
	public String getSN3ptyInvNoSearch() {
		return this.sN3ptyInvNoSearch;
	}
	
	/**
	 * Column Info
	 * @return sN3ptySrcSubSysCd
	 */
	public String getSN3ptySrcSubSysCd() {
		return this.sN3ptySrcSubSysCd;
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
	 * @return ifCurrCd
	 */
	public String getIfCurrCd() {
		return this.ifCurrCd;
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
	 * @param trdPartyCode
	 */
	public void setTrdPartyCode(String trdPartyCode) {
		this.trdPartyCode = trdPartyCode;
	}
	
	/**
	 * Column Info
	 * @param erpifDt
	 */
	public void setErpifDt(String erpifDt) {
		this.erpifDt = erpifDt;
	}
	
	/**
	 * Column Info
	 * @param sBkgNoAll
	 */
	public void setSBkgNoAll(String sBkgNoAll) {
		this.sBkgNoAll = sBkgNoAll;
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
	 * @param revenueVvd
	 */
	public void setRevenueVvd(String revenueVvd) {
		this.revenueVvd = revenueVvd;
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
	 * @param sN3ptyNoStrsLink
	 */
	public void setSN3ptyNoStrsLink(String sN3ptyNoStrsLink) {
		this.sN3ptyNoStrsLink = sN3ptyNoStrsLink;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpCd
	 */
	public void setN3ptyBilTpCd(String n3ptyBilTpCd) {
		this.n3ptyBilTpCd = n3ptyBilTpCd;
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
	 * @param sEqKndCd
	 */
	public void setSEqKndCd(String sEqKndCd) {
		this.sEqKndCd = sEqKndCd;
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
	 * @param n3ptyInvRvisSeq
	 */
	public void setN3ptyInvRvisSeq(String n3ptyInvRvisSeq) {
		this.n3ptyInvRvisSeq = n3ptyInvRvisSeq;
	}
	
	/**
	 * Column Info
	 * @param reviseAble
	 */
	public void setReviseAble(String reviseAble) {
		this.reviseAble = reviseAble;
	}
	
	/**
	 * Column Info
	 * @param trdPartyName
	 */
	public void setTrdPartyName(String trdPartyName) {
		this.trdPartyName = trdPartyName;
	}
	
	/**
	 * Column Info
	 * @param rcvrActYn
	 */
	public void setRcvrActYn(String rcvrActYn) {
		this.rcvrActYn = rcvrActYn;
	}
	
	/**
	 * Column Info
	 * @param sN3ptySrcNo
	 */
	public void setSN3ptySrcNo(String sN3ptySrcNo) {
		this.sN3ptySrcNo = sN3ptySrcNo;
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
	 * @param erpifUsrNm
	 */
	public void setErpifUsrNm(String erpifUsrNm) {
		this.erpifUsrNm = erpifUsrNm;
	}
	
	/**
	 * Column Info
	 * @param sBlNoAll
	 */
	public void setSBlNoAll(String sBlNoAll) {
		this.sBlNoAll = sBlNoAll;
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
	 * @param trdPartyCodeO
	 */
	public void setTrdPartyCodeO(String trdPartyCodeO) {
		this.trdPartyCodeO = trdPartyCodeO;
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
	 * @param erpifAble
	 */
	public void setErpifAble(String erpifAble) {
		this.erpifAble = erpifAble;
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
	 * @param ifAmtUsd
	 */
	public void setIfAmtUsd(String ifAmtUsd) {
		this.ifAmtUsd = ifAmtUsd;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcSubSysCd
	 */
	public void setN3ptySrcSubSysCd(String n3ptySrcSubSysCd) {
		this.n3ptySrcSubSysCd = n3ptySrcSubSysCd;
	}
	
	/**
	 * Column Info
	 * @param erpifUsrId
	 */
	public void setErpifUsrId(String erpifUsrId) {
		this.erpifUsrId = erpifUsrId;
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
	 * @param cfmUsrNm
	 */
	public void setCfmUsrNm(String cfmUsrNm) {
		this.cfmUsrNm = cfmUsrNm;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param overdue
	 */
	public void setOverdue(String overdue) {
		this.overdue = overdue;
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
	 * @param invoiceAble
	 */
	public void setInvoiceAble(String invoiceAble) {
		this.invoiceAble = invoiceAble;
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
	 * @param sN3ptyNo
	 */
	public void setSN3ptyNo(String sN3ptyNo) {
		this.sN3ptyNo = sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param rvsAmt
	 */
	public void setRvsAmt(String rvsAmt) {
		this.rvsAmt = rvsAmt;
	}
	
	/**
	 * Column Info
	 * @param sStatus
	 */
	public void setSStatus(String sStatus) {
		this.sStatus = sStatus;
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
	 * @param sVvd
	 */
	public void setSVvd(String sVvd) {
		this.sVvd = sVvd;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvNoSearch
	 */
	public void setSN3ptyInvNoSearch(String sN3ptyInvNoSearch) {
		this.sN3ptyInvNoSearch = sN3ptyInvNoSearch;
	}
	
	/**
	 * Column Info
	 * @param sN3ptySrcSubSysCd
	 */
	public void setSN3ptySrcSubSysCd(String sN3ptySrcSubSysCd) {
		this.sN3ptySrcSubSysCd = sN3ptySrcSubSysCd;
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
	 * @param ifCurrCd
	 */
	public void setIfCurrCd(String ifCurrCd) {
		this.ifCurrCd = ifCurrCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setTrdPartyCode(JSPUtil.getParameter(request, prefix + "trd_party_code", ""));
		setErpifDt(JSPUtil.getParameter(request, prefix + "erpif_dt", ""));
		setSBkgNoAll(JSPUtil.getParameter(request, prefix + "s_bkg_no_all", ""));
		setN3ptyInvRvisCd(JSPUtil.getParameter(request, prefix + "n3pty_inv_rvis_cd", ""));
		setSTrdPartyVal(JSPUtil.getParameter(request, prefix + "s_trd_party_val", ""));
		setRevenueVvd(JSPUtil.getParameter(request, prefix + "revenue_vvd", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, prefix + "n3pty_bil_tp_nm", ""));
		setN3ptyInvNo(JSPUtil.getParameter(request, prefix + "n3pty_inv_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSN3ptyNoStrsLink(JSPUtil.getParameter(request, prefix + "s_n3pty_no_strs_link", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, prefix + "n3pty_bil_tp_cd", ""));
		setLengthN3ptyBilTpCd(JSPUtil.getParameter(request, prefix + "length_n3pty_bil_tp_cd", ""));
		setSEqKndCd(JSPUtil.getParameter(request, prefix + "s_eq_knd_cd", ""));
		setCfmUsrId(JSPUtil.getParameter(request, prefix + "cfm_usr_id", ""));
		setN3ptyInvRvisSeq(JSPUtil.getParameter(request, prefix + "n3pty_inv_rvis_seq", ""));
		setReviseAble(JSPUtil.getParameter(request, prefix + "revise_able", ""));
		setTrdPartyName(JSPUtil.getParameter(request, prefix + "trd_party_name", ""));
		setRcvrActYn(JSPUtil.getParameter(request, prefix + "rcvr_act_yn", ""));
		setSN3ptySrcNo(JSPUtil.getParameter(request, prefix + "s_n3pty_src_no", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setErpifUsrNm(JSPUtil.getParameter(request, prefix + "erpif_usr_nm", ""));
		setSBlNoAll(JSPUtil.getParameter(request, prefix + "s_bl_no_all", ""));
		setSVndrCustDivCd(JSPUtil.getParameter(request, prefix + "s_vndr_cust_div_cd", ""));
		setTrdPartyCodeO(JSPUtil.getParameter(request, prefix + "trd_party_code_o", ""));
		setOtsAmt(JSPUtil.getParameter(request, prefix + "ots_amt", ""));
		setErpifAble(JSPUtil.getParameter(request, prefix + "erpif_able", ""));
		setIfAmt(JSPUtil.getParameter(request, prefix + "if_amt", ""));
		setIfAmtUsd(JSPUtil.getParameter(request, prefix + "if_amt_usd", ""));
		setN3ptySrcSubSysCd(JSPUtil.getParameter(request, prefix + "n3pty_src_sub_sys_cd", ""));
		setErpifUsrId(JSPUtil.getParameter(request, prefix + "erpif_usr_id", ""));
		setUserOfcCd(JSPUtil.getParameter(request, prefix + "user_ofc_cd", ""));
		setCfmUsrNm(JSPUtil.getParameter(request, prefix + "cfm_usr_nm", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setVndrCustDivCd(JSPUtil.getParameter(request, prefix + "vndr_cust_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setOverdue(JSPUtil.getParameter(request, prefix + "overdue", ""));
		setN3ptyNo(JSPUtil.getParameter(request, prefix + "n3pty_no", ""));
		setInvoiceAble(JSPUtil.getParameter(request, prefix + "invoice_able", ""));
		setSEdate(JSPUtil.getParameter(request, prefix + "s_edate", ""));
		setSN3ptyNo(JSPUtil.getParameter(request, prefix + "s_n3pty_no", ""));
		setRvsAmt(JSPUtil.getParameter(request, prefix + "rvs_amt", ""));
		setSStatus(JSPUtil.getParameter(request, prefix + "s_status", ""));
		setSSdate(JSPUtil.getParameter(request, prefix + "s_sdate", ""));
		setSVvd(JSPUtil.getParameter(request, prefix + "s_vvd", ""));
		setSN3ptyInvNoSearch(JSPUtil.getParameter(request, prefix + "s_n3pty_inv_no_search", ""));
		setSN3ptySrcSubSysCd(JSPUtil.getParameter(request, prefix + "s_n3pty_src_sub_sys_cd", ""));
		setSEqNo(JSPUtil.getParameter(request, prefix + "s_eq_no", ""));
		setIfCurrCd(JSPUtil.getParameter(request, prefix + "if_curr_cd", ""));
		setN3ptySrcNo(JSPUtil.getParameter(request, prefix + "n3pty_src_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTPBHandlingListVO[]
	 */
	public SearchTPBHandlingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTPBHandlingListVO[]
	 */
	public SearchTPBHandlingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTPBHandlingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trdPartyCode = (JSPUtil.getParameter(request, prefix	+ "trd_party_code", length));
			String[] erpifDt = (JSPUtil.getParameter(request, prefix	+ "erpif_dt", length));
			String[] sBkgNoAll = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no_all", length));
			String[] n3ptyInvRvisCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_rvis_cd", length));
			String[] sTrdPartyVal = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_val", length));
			String[] revenueVvd = (JSPUtil.getParameter(request, prefix	+ "revenue_vvd", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] n3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sN3ptyNoStrsLink = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no_strs_link", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] lengthN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "length_n3pty_bil_tp_cd", length));
			String[] sEqKndCd = (JSPUtil.getParameter(request, prefix	+ "s_eq_knd_cd", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] n3ptyInvRvisSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_rvis_seq", length));
			String[] reviseAble = (JSPUtil.getParameter(request, prefix	+ "revise_able", length));
			String[] trdPartyName = (JSPUtil.getParameter(request, prefix	+ "trd_party_name", length));
			String[] rcvrActYn = (JSPUtil.getParameter(request, prefix	+ "rcvr_act_yn", length));
			String[] sN3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_src_no", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] erpifUsrNm = (JSPUtil.getParameter(request, prefix	+ "erpif_usr_nm", length));
			String[] sBlNoAll = (JSPUtil.getParameter(request, prefix	+ "s_bl_no_all", length));
			String[] sVndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_div_cd", length));
			String[] trdPartyCodeO = (JSPUtil.getParameter(request, prefix	+ "trd_party_code_o", length));
			String[] otsAmt = (JSPUtil.getParameter(request, prefix	+ "ots_amt", length));
			String[] erpifAble = (JSPUtil.getParameter(request, prefix	+ "erpif_able", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] ifAmtUsd = (JSPUtil.getParameter(request, prefix	+ "if_amt_usd", length));
			String[] n3ptySrcSubSysCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_sub_sys_cd", length));
			String[] erpifUsrId = (JSPUtil.getParameter(request, prefix	+ "erpif_usr_id", length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] cfmUsrNm = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_nm", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] vndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_div_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] overdue = (JSPUtil.getParameter(request, prefix	+ "overdue", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] invoiceAble = (JSPUtil.getParameter(request, prefix	+ "invoice_able", length));
			String[] sEdate = (JSPUtil.getParameter(request, prefix	+ "s_edate", length));
			String[] sN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no", length));
			String[] rvsAmt = (JSPUtil.getParameter(request, prefix	+ "rvs_amt", length));
			String[] sStatus = (JSPUtil.getParameter(request, prefix	+ "s_status", length));
			String[] sSdate = (JSPUtil.getParameter(request, prefix	+ "s_sdate", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] sN3ptyInvNoSearch = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_no_search", length));
			String[] sN3ptySrcSubSysCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_src_sub_sys_cd", length));
			String[] sEqNo = (JSPUtil.getParameter(request, prefix	+ "s_eq_no", length));
			String[] ifCurrCd = (JSPUtil.getParameter(request, prefix	+ "if_curr_cd", length));
			String[] n3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTPBHandlingListVO();
				if (trdPartyCode[i] != null)
					model.setTrdPartyCode(trdPartyCode[i]);
				if (erpifDt[i] != null)
					model.setErpifDt(erpifDt[i]);
				if (sBkgNoAll[i] != null)
					model.setSBkgNoAll(sBkgNoAll[i]);
				if (n3ptyInvRvisCd[i] != null)
					model.setN3ptyInvRvisCd(n3ptyInvRvisCd[i]);
				if (sTrdPartyVal[i] != null)
					model.setSTrdPartyVal(sTrdPartyVal[i]);
				if (revenueVvd[i] != null)
					model.setRevenueVvd(revenueVvd[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (n3ptyInvNo[i] != null)
					model.setN3ptyInvNo(n3ptyInvNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sN3ptyNoStrsLink[i] != null)
					model.setSN3ptyNoStrsLink(sN3ptyNoStrsLink[i]);
				if (n3ptyBilTpCd[i] != null)
					model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);
				if (lengthN3ptyBilTpCd[i] != null)
					model.setLengthN3ptyBilTpCd(lengthN3ptyBilTpCd[i]);
				if (sEqKndCd[i] != null)
					model.setSEqKndCd(sEqKndCd[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (n3ptyInvRvisSeq[i] != null)
					model.setN3ptyInvRvisSeq(n3ptyInvRvisSeq[i]);
				if (reviseAble[i] != null)
					model.setReviseAble(reviseAble[i]);
				if (trdPartyName[i] != null)
					model.setTrdPartyName(trdPartyName[i]);
				if (rcvrActYn[i] != null)
					model.setRcvrActYn(rcvrActYn[i]);
				if (sN3ptySrcNo[i] != null)
					model.setSN3ptySrcNo(sN3ptySrcNo[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (erpifUsrNm[i] != null)
					model.setErpifUsrNm(erpifUsrNm[i]);
				if (sBlNoAll[i] != null)
					model.setSBlNoAll(sBlNoAll[i]);
				if (sVndrCustDivCd[i] != null)
					model.setSVndrCustDivCd(sVndrCustDivCd[i]);
				if (trdPartyCodeO[i] != null)
					model.setTrdPartyCodeO(trdPartyCodeO[i]);
				if (otsAmt[i] != null)
					model.setOtsAmt(otsAmt[i]);
				if (erpifAble[i] != null)
					model.setErpifAble(erpifAble[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (ifAmtUsd[i] != null)
					model.setIfAmtUsd(ifAmtUsd[i]);
				if (n3ptySrcSubSysCd[i] != null)
					model.setN3ptySrcSubSysCd(n3ptySrcSubSysCd[i]);
				if (erpifUsrId[i] != null)
					model.setErpifUsrId(erpifUsrId[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (cfmUsrNm[i] != null)
					model.setCfmUsrNm(cfmUsrNm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (vndrCustDivCd[i] != null)
					model.setVndrCustDivCd(vndrCustDivCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (overdue[i] != null)
					model.setOverdue(overdue[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (invoiceAble[i] != null)
					model.setInvoiceAble(invoiceAble[i]);
				if (sEdate[i] != null)
					model.setSEdate(sEdate[i]);
				if (sN3ptyNo[i] != null)
					model.setSN3ptyNo(sN3ptyNo[i]);
				if (rvsAmt[i] != null)
					model.setRvsAmt(rvsAmt[i]);
				if (sStatus[i] != null)
					model.setSStatus(sStatus[i]);
				if (sSdate[i] != null)
					model.setSSdate(sSdate[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (sN3ptyInvNoSearch[i] != null)
					model.setSN3ptyInvNoSearch(sN3ptyInvNoSearch[i]);
				if (sN3ptySrcSubSysCd[i] != null)
					model.setSN3ptySrcSubSysCd(sN3ptySrcSubSysCd[i]);
				if (sEqNo[i] != null)
					model.setSEqNo(sEqNo[i]);
				if (ifCurrCd[i] != null)
					model.setIfCurrCd(ifCurrCd[i]);
				if (n3ptySrcNo[i] != null)
					model.setN3ptySrcNo(n3ptySrcNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTPBHandlingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTPBHandlingListVO[]
	 */
	public SearchTPBHandlingListVO[] getSearchTPBHandlingListVOs(){
		SearchTPBHandlingListVO[] vos = (SearchTPBHandlingListVO[])models.toArray(new SearchTPBHandlingListVO[models.size()]);
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
		this.trdPartyCode = this.trdPartyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpifDt = this.erpifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNoAll = this.sBkgNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvRvisCd = this.n3ptyInvRvisCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyVal = this.sTrdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revenueVvd = this.revenueVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNo = this.n3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNoStrsLink = this.sN3ptyNoStrsLink .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lengthN3ptyBilTpCd = this.lengthN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqKndCd = this.sEqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvRvisSeq = this.n3ptyInvRvisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reviseAble = this.reviseAble .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyName = this.trdPartyName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrActYn = this.rcvrActYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptySrcNo = this.sN3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpifUsrNm = this.erpifUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBlNoAll = this.sBlNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustDivCd = this.sVndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyCodeO = this.trdPartyCodeO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAmt = this.otsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpifAble = this.erpifAble .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmtUsd = this.ifAmtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcSubSysCd = this.n3ptySrcSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpifUsrId = this.erpifUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrNm = this.cfmUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustDivCd = this.vndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overdue = this.overdue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceAble = this.invoiceAble .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdate = this.sEdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNo = this.sN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsAmt = this.rvsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sStatus = this.sStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSdate = this.sSdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvNoSearch = this.sN3ptyInvNoSearch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptySrcSubSysCd = this.sN3ptySrcSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqNo = this.sEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifCurrCd = this.ifCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNo = this.n3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
