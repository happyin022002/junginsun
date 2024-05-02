/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchActivityByClosingTPBVO.java
*@FileTitle : SearchActivityByClosingTPBVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchActivityByClosingTPBVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchActivityByClosingTPBVO> models = new ArrayList<SearchActivityByClosingTPBVO>();
	
	/* Column Info */
	private String sCurrCdTp = null;
	/* Column Info */
	private String otsStsCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String trdPartyCode = null;
	/* Column Info */
	private String ifOfcCd = null;
	/* Column Info */
	private String cltAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sUserOfcCd = null;
	/* Column Info */
	private String invIssDt = null;
	/* Column Info */
	private String sIfCtrlCd = null;
	/* Column Info */
	private String n3ptyBilTpNm = null;
	/* Column Info */
	private String n3ptyInvNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrCustDivCd = null;
	/* Column Info */
	private String balAmt = null;
	/* Column Info */
	private String stlToCltCngOfcCd = null;
	/* Column Info */
	private String n3ptyBilTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String soIfSeq = null;
	/* Column Info */
	private String cltActYn = null;
	/* Column Info */
	private String overdue = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String stlRqstOfcCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String ednTpNm = null;
	/* Column Info */
	private String blNoAll = null;
	/* Column Info */
	private String trdPartyName = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String ifUsrId = null;
	/* Column Info */
	private String sEdate = null;
	/* Column Info */
	private String bkgNoAll = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String sSdate = null;
	/* Column Info */
	private String sIfOfcCd = null;
	/* Column Info */
	private String stlAmt = null;
	/* Column Info */
	private String n3ptyStlTpCd = null;
	/* Column Info */
	private String fmCltCngOfcN3ptyNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String n3ptyNoDpSeq = null;
	/* Column Info */
	private String otsStsNm = null;
	/* Column Info */
	private String otsAmt = null;
	/* Column Info */
	private String sIfRhqCd = null;
	/* Column Info */
	private String n3ptySrcSubSysCd = null;
	/* Column Info */
	private String n3ptySrcNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchActivityByClosingTPBVO() {}

	public SearchActivityByClosingTPBVO(String ibflag, String pagerows, String sIfRhqCd, String sIfCtrlCd, String sIfOfcCd, String sCurrCdTp, String sSdate, String sEdate, String sUserOfcCd, String n3ptyNo, String n3ptyNoDpSeq, String rhq, String ofcCd, String n3ptySrcSubSysCd, String n3ptyInvNo, String invIssDt, String n3ptySrcNo, String bkgNoAll, String blNoAll, String vvd, String eqNo, String n3ptyBilTpNm, String trdPartyCode, String trdPartyName, String cltActYn, String otsStsNm, String overdue, String otsAmt, String invAmt, String cltAmt, String stlAmt, String balAmt, String ifUsrId, String ifOfcCd, String n3ptyStlTpCd, String stlRqstOfcCd, String stlToCltCngOfcCd, String fmCltCngOfcN3ptyNo, String ednTpNm, String csrNo, String otsStsCd, String vndrCustDivCd, String currCd, String n3ptyBilTpCd, String cfmDt, String soIfSeq, String creDt) {
		this.sCurrCdTp = sCurrCdTp;
		this.otsStsCd = otsStsCd;
		this.currCd = currCd;
		this.trdPartyCode = trdPartyCode;
		this.ifOfcCd = ifOfcCd;
		this.cltAmt = cltAmt;
		this.creDt = creDt;
		this.sUserOfcCd = sUserOfcCd;
		this.invIssDt = invIssDt;
		this.sIfCtrlCd = sIfCtrlCd;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.n3ptyInvNo = n3ptyInvNo;
		this.pagerows = pagerows;
		this.vndrCustDivCd = vndrCustDivCd;
		this.balAmt = balAmt;
		this.stlToCltCngOfcCd = stlToCltCngOfcCd;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.soIfSeq = soIfSeq;
		this.cltActYn = cltActYn;
		this.overdue = overdue;
		this.n3ptyNo = n3ptyNo;
		this.stlRqstOfcCd = stlRqstOfcCd;
		this.invAmt = invAmt;
		this.ednTpNm = ednTpNm;
		this.blNoAll = blNoAll;
		this.trdPartyName = trdPartyName;
		this.rhq = rhq;
		this.csrNo = csrNo;
		this.ifUsrId = ifUsrId;
		this.sEdate = sEdate;
		this.bkgNoAll = bkgNoAll;
		this.cfmDt = cfmDt;
		this.sSdate = sSdate;
		this.sIfOfcCd = sIfOfcCd;
		this.stlAmt = stlAmt;
		this.n3ptyStlTpCd = n3ptyStlTpCd;
		this.fmCltCngOfcN3ptyNo = fmCltCngOfcN3ptyNo;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.n3ptyNoDpSeq = n3ptyNoDpSeq;
		this.otsStsNm = otsStsNm;
		this.otsAmt = otsAmt;
		this.sIfRhqCd = sIfRhqCd;
		this.n3ptySrcSubSysCd = n3ptySrcSubSysCd;
		this.n3ptySrcNo = n3ptySrcNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_curr_cd_tp", getSCurrCdTp());
		this.hashColumns.put("ots_sts_cd", getOtsStsCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("trd_party_code", getTrdPartyCode());
		this.hashColumns.put("if_ofc_cd", getIfOfcCd());
		this.hashColumns.put("clt_amt", getCltAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("s_user_ofc_cd", getSUserOfcCd());
		this.hashColumns.put("inv_iss_dt", getInvIssDt());
		this.hashColumns.put("s_if_ctrl_cd", getSIfCtrlCd());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("n3pty_inv_no", getN3ptyInvNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_cust_div_cd", getVndrCustDivCd());
		this.hashColumns.put("bal_amt", getBalAmt());
		this.hashColumns.put("stl_to_clt_cng_ofc_cd", getStlToCltCngOfcCd());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("so_if_seq", getSoIfSeq());
		this.hashColumns.put("clt_act_yn", getCltActYn());
		this.hashColumns.put("overdue", getOverdue());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("stl_rqst_ofc_cd", getStlRqstOfcCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("edn_tp_nm", getEdnTpNm());
		this.hashColumns.put("bl_no_all", getBlNoAll());
		this.hashColumns.put("trd_party_name", getTrdPartyName());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("if_usr_id", getIfUsrId());
		this.hashColumns.put("s_edate", getSEdate());
		this.hashColumns.put("bkg_no_all", getBkgNoAll());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("s_sdate", getSSdate());
		this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
		this.hashColumns.put("stl_amt", getStlAmt());
		this.hashColumns.put("n3pty_stl_tp_cd", getN3ptyStlTpCd());
		this.hashColumns.put("fm_clt_cng_ofc_n3pty_no", getFmCltCngOfcN3ptyNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("n3pty_no_dp_seq", getN3ptyNoDpSeq());
		this.hashColumns.put("ots_sts_nm", getOtsStsNm());
		this.hashColumns.put("ots_amt", getOtsAmt());
		this.hashColumns.put("s_if_rhq_cd", getSIfRhqCd());
		this.hashColumns.put("n3pty_src_sub_sys_cd", getN3ptySrcSubSysCd());
		this.hashColumns.put("n3pty_src_no", getN3ptySrcNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_curr_cd_tp", "sCurrCdTp");
		this.hashFields.put("ots_sts_cd", "otsStsCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("trd_party_code", "trdPartyCode");
		this.hashFields.put("if_ofc_cd", "ifOfcCd");
		this.hashFields.put("clt_amt", "cltAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("s_user_ofc_cd", "sUserOfcCd");
		this.hashFields.put("inv_iss_dt", "invIssDt");
		this.hashFields.put("s_if_ctrl_cd", "sIfCtrlCd");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
		this.hashFields.put("n3pty_inv_no", "n3ptyInvNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_cust_div_cd", "vndrCustDivCd");
		this.hashFields.put("bal_amt", "balAmt");
		this.hashFields.put("stl_to_clt_cng_ofc_cd", "stlToCltCngOfcCd");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("so_if_seq", "soIfSeq");
		this.hashFields.put("clt_act_yn", "cltActYn");
		this.hashFields.put("overdue", "overdue");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("stl_rqst_ofc_cd", "stlRqstOfcCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("edn_tp_nm", "ednTpNm");
		this.hashFields.put("bl_no_all", "blNoAll");
		this.hashFields.put("trd_party_name", "trdPartyName");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("if_usr_id", "ifUsrId");
		this.hashFields.put("s_edate", "sEdate");
		this.hashFields.put("bkg_no_all", "bkgNoAll");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("s_sdate", "sSdate");
		this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
		this.hashFields.put("stl_amt", "stlAmt");
		this.hashFields.put("n3pty_stl_tp_cd", "n3ptyStlTpCd");
		this.hashFields.put("fm_clt_cng_ofc_n3pty_no", "fmCltCngOfcN3ptyNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("n3pty_no_dp_seq", "n3ptyNoDpSeq");
		this.hashFields.put("ots_sts_nm", "otsStsNm");
		this.hashFields.put("ots_amt", "otsAmt");
		this.hashFields.put("s_if_rhq_cd", "sIfRhqCd");
		this.hashFields.put("n3pty_src_sub_sys_cd", "n3ptySrcSubSysCd");
		this.hashFields.put("n3pty_src_no", "n3ptySrcNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sCurrCdTp
	 */
	public String getSCurrCdTp() {
		return this.sCurrCdTp;
	}
	
	/**
	 * Column Info
	 * @return otsStsCd
	 */
	public String getOtsStsCd() {
		return this.otsStsCd;
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
	 * @return trdPartyCode
	 */
	public String getTrdPartyCode() {
		return this.trdPartyCode;
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
	 * @return cltAmt
	 */
	public String getCltAmt() {
		return this.cltAmt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return sUserOfcCd
	 */
	public String getSUserOfcCd() {
		return this.sUserOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invIssDt
	 */
	public String getInvIssDt() {
		return this.invIssDt;
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
	 * @return vndrCustDivCd
	 */
	public String getVndrCustDivCd() {
		return this.vndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @return balAmt
	 */
	public String getBalAmt() {
		return this.balAmt;
	}
	
	/**
	 * Column Info
	 * @return stlToCltCngOfcCd
	 */
	public String getStlToCltCngOfcCd() {
		return this.stlToCltCngOfcCd;
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
	 * @return soIfSeq
	 */
	public String getSoIfSeq() {
		return this.soIfSeq;
	}
	
	/**
	 * Column Info
	 * @return cltActYn
	 */
	public String getCltActYn() {
		return this.cltActYn;
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
	 * @return stlRqstOfcCd
	 */
	public String getStlRqstOfcCd() {
		return this.stlRqstOfcCd;
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
	 * @return ednTpNm
	 */
	public String getEdnTpNm() {
		return this.ednTpNm;
	}
	
	/**
	 * Column Info
	 * @return blNoAll
	 */
	public String getBlNoAll() {
		return this.blNoAll;
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
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
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
	 * @return sEdate
	 */
	public String getSEdate() {
		return this.sEdate;
	}
	
	/**
	 * Column Info
	 * @return bkgNoAll
	 */
	public String getBkgNoAll() {
		return this.bkgNoAll;
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
	 * @return sSdate
	 */
	public String getSSdate() {
		return this.sSdate;
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
	 * @return stlAmt
	 */
	public String getStlAmt() {
		return this.stlAmt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyStlTpCd
	 */
	public String getN3ptyStlTpCd() {
		return this.n3ptyStlTpCd;
	}
	
	/**
	 * Column Info
	 * @return fmCltCngOfcN3ptyNo
	 */
	public String getFmCltCngOfcN3ptyNo() {
		return this.fmCltCngOfcN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return n3ptyNoDpSeq
	 */
	public String getN3ptyNoDpSeq() {
		return this.n3ptyNoDpSeq;
	}
	
	/**
	 * Column Info
	 * @return otsStsNm
	 */
	public String getOtsStsNm() {
		return this.otsStsNm;
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
	 * @return n3ptySrcSubSysCd
	 */
	public String getN3ptySrcSubSysCd() {
		return this.n3ptySrcSubSysCd;
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
	 * @param sCurrCdTp
	 */
	public void setSCurrCdTp(String sCurrCdTp) {
		this.sCurrCdTp = sCurrCdTp;
	}
	
	/**
	 * Column Info
	 * @param otsStsCd
	 */
	public void setOtsStsCd(String otsStsCd) {
		this.otsStsCd = otsStsCd;
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
	 * @param trdPartyCode
	 */
	public void setTrdPartyCode(String trdPartyCode) {
		this.trdPartyCode = trdPartyCode;
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
	 * @param cltAmt
	 */
	public void setCltAmt(String cltAmt) {
		this.cltAmt = cltAmt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param sUserOfcCd
	 */
	public void setSUserOfcCd(String sUserOfcCd) {
		this.sUserOfcCd = sUserOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invIssDt
	 */
	public void setInvIssDt(String invIssDt) {
		this.invIssDt = invIssDt;
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
	 * @param vndrCustDivCd
	 */
	public void setVndrCustDivCd(String vndrCustDivCd) {
		this.vndrCustDivCd = vndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @param balAmt
	 */
	public void setBalAmt(String balAmt) {
		this.balAmt = balAmt;
	}
	
	/**
	 * Column Info
	 * @param stlToCltCngOfcCd
	 */
	public void setStlToCltCngOfcCd(String stlToCltCngOfcCd) {
		this.stlToCltCngOfcCd = stlToCltCngOfcCd;
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
	 * @param soIfSeq
	 */
	public void setSoIfSeq(String soIfSeq) {
		this.soIfSeq = soIfSeq;
	}
	
	/**
	 * Column Info
	 * @param cltActYn
	 */
	public void setCltActYn(String cltActYn) {
		this.cltActYn = cltActYn;
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
	 * @param stlRqstOfcCd
	 */
	public void setStlRqstOfcCd(String stlRqstOfcCd) {
		this.stlRqstOfcCd = stlRqstOfcCd;
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
	 * @param ednTpNm
	 */
	public void setEdnTpNm(String ednTpNm) {
		this.ednTpNm = ednTpNm;
	}
	
	/**
	 * Column Info
	 * @param blNoAll
	 */
	public void setBlNoAll(String blNoAll) {
		this.blNoAll = blNoAll;
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
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
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
	 * @param sEdate
	 */
	public void setSEdate(String sEdate) {
		this.sEdate = sEdate;
	}
	
	/**
	 * Column Info
	 * @param bkgNoAll
	 */
	public void setBkgNoAll(String bkgNoAll) {
		this.bkgNoAll = bkgNoAll;
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
	 * @param sSdate
	 */
	public void setSSdate(String sSdate) {
		this.sSdate = sSdate;
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
	 * @param stlAmt
	 */
	public void setStlAmt(String stlAmt) {
		this.stlAmt = stlAmt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyStlTpCd
	 */
	public void setN3ptyStlTpCd(String n3ptyStlTpCd) {
		this.n3ptyStlTpCd = n3ptyStlTpCd;
	}
	
	/**
	 * Column Info
	 * @param fmCltCngOfcN3ptyNo
	 */
	public void setFmCltCngOfcN3ptyNo(String fmCltCngOfcN3ptyNo) {
		this.fmCltCngOfcN3ptyNo = fmCltCngOfcN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param n3ptyNoDpSeq
	 */
	public void setN3ptyNoDpSeq(String n3ptyNoDpSeq) {
		this.n3ptyNoDpSeq = n3ptyNoDpSeq;
	}
	
	/**
	 * Column Info
	 * @param otsStsNm
	 */
	public void setOtsStsNm(String otsStsNm) {
		this.otsStsNm = otsStsNm;
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
	 * @param n3ptySrcSubSysCd
	 */
	public void setN3ptySrcSubSysCd(String n3ptySrcSubSysCd) {
		this.n3ptySrcSubSysCd = n3ptySrcSubSysCd;
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
		setSCurrCdTp(JSPUtil.getParameter(request, prefix + "s_curr_cd_tp", ""));
		setOtsStsCd(JSPUtil.getParameter(request, prefix + "ots_sts_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTrdPartyCode(JSPUtil.getParameter(request, prefix + "trd_party_code", ""));
		setIfOfcCd(JSPUtil.getParameter(request, prefix + "if_ofc_cd", ""));
		setCltAmt(JSPUtil.getParameter(request, prefix + "clt_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSUserOfcCd(JSPUtil.getParameter(request, prefix + "s_user_ofc_cd", ""));
		setInvIssDt(JSPUtil.getParameter(request, prefix + "inv_iss_dt", ""));
		setSIfCtrlCd(JSPUtil.getParameter(request, prefix + "s_if_ctrl_cd", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, prefix + "n3pty_bil_tp_nm", ""));
		setN3ptyInvNo(JSPUtil.getParameter(request, prefix + "n3pty_inv_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrCustDivCd(JSPUtil.getParameter(request, prefix + "vndr_cust_div_cd", ""));
		setBalAmt(JSPUtil.getParameter(request, prefix + "bal_amt", ""));
		setStlToCltCngOfcCd(JSPUtil.getParameter(request, prefix + "stl_to_clt_cng_ofc_cd", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, prefix + "n3pty_bil_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setSoIfSeq(JSPUtil.getParameter(request, prefix + "so_if_seq", ""));
		setCltActYn(JSPUtil.getParameter(request, prefix + "clt_act_yn", ""));
		setOverdue(JSPUtil.getParameter(request, prefix + "overdue", ""));
		setN3ptyNo(JSPUtil.getParameter(request, prefix + "n3pty_no", ""));
		setStlRqstOfcCd(JSPUtil.getParameter(request, prefix + "stl_rqst_ofc_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setEdnTpNm(JSPUtil.getParameter(request, prefix + "edn_tp_nm", ""));
		setBlNoAll(JSPUtil.getParameter(request, prefix + "bl_no_all", ""));
		setTrdPartyName(JSPUtil.getParameter(request, prefix + "trd_party_name", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setIfUsrId(JSPUtil.getParameter(request, prefix + "if_usr_id", ""));
		setSEdate(JSPUtil.getParameter(request, prefix + "s_edate", ""));
		setBkgNoAll(JSPUtil.getParameter(request, prefix + "bkg_no_all", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setSSdate(JSPUtil.getParameter(request, prefix + "s_sdate", ""));
		setSIfOfcCd(JSPUtil.getParameter(request, prefix + "s_if_ofc_cd", ""));
		setStlAmt(JSPUtil.getParameter(request, prefix + "stl_amt", ""));
		setN3ptyStlTpCd(JSPUtil.getParameter(request, prefix + "n3pty_stl_tp_cd", ""));
		setFmCltCngOfcN3ptyNo(JSPUtil.getParameter(request, prefix + "fm_clt_cng_ofc_n3pty_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setN3ptyNoDpSeq(JSPUtil.getParameter(request, prefix + "n3pty_no_dp_seq", ""));
		setOtsStsNm(JSPUtil.getParameter(request, prefix + "ots_sts_nm", ""));
		setOtsAmt(JSPUtil.getParameter(request, prefix + "ots_amt", ""));
		setSIfRhqCd(JSPUtil.getParameter(request, prefix + "s_if_rhq_cd", ""));
		setN3ptySrcSubSysCd(JSPUtil.getParameter(request, prefix + "n3pty_src_sub_sys_cd", ""));
		setN3ptySrcNo(JSPUtil.getParameter(request, prefix + "n3pty_src_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchActivityByClosingTPBVO[]
	 */
	public SearchActivityByClosingTPBVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchActivityByClosingTPBVO[]
	 */
	public SearchActivityByClosingTPBVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchActivityByClosingTPBVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sCurrCdTp = (JSPUtil.getParameter(request, prefix	+ "s_curr_cd_tp", length));
			String[] otsStsCd = (JSPUtil.getParameter(request, prefix	+ "ots_sts_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] trdPartyCode = (JSPUtil.getParameter(request, prefix	+ "trd_party_code", length));
			String[] ifOfcCd = (JSPUtil.getParameter(request, prefix	+ "if_ofc_cd", length));
			String[] cltAmt = (JSPUtil.getParameter(request, prefix	+ "clt_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sUserOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_user_ofc_cd", length));
			String[] invIssDt = (JSPUtil.getParameter(request, prefix	+ "inv_iss_dt", length));
			String[] sIfCtrlCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ctrl_cd", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] n3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_div_cd", length));
			String[] balAmt = (JSPUtil.getParameter(request, prefix	+ "bal_amt", length));
			String[] stlToCltCngOfcCd = (JSPUtil.getParameter(request, prefix	+ "stl_to_clt_cng_ofc_cd", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] soIfSeq = (JSPUtil.getParameter(request, prefix	+ "so_if_seq", length));
			String[] cltActYn = (JSPUtil.getParameter(request, prefix	+ "clt_act_yn", length));
			String[] overdue = (JSPUtil.getParameter(request, prefix	+ "overdue", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] stlRqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "stl_rqst_ofc_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] ednTpNm = (JSPUtil.getParameter(request, prefix	+ "edn_tp_nm", length));
			String[] blNoAll = (JSPUtil.getParameter(request, prefix	+ "bl_no_all", length));
			String[] trdPartyName = (JSPUtil.getParameter(request, prefix	+ "trd_party_name", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] ifUsrId = (JSPUtil.getParameter(request, prefix	+ "if_usr_id", length));
			String[] sEdate = (JSPUtil.getParameter(request, prefix	+ "s_edate", length));
			String[] bkgNoAll = (JSPUtil.getParameter(request, prefix	+ "bkg_no_all", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] sSdate = (JSPUtil.getParameter(request, prefix	+ "s_sdate", length));
			String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ofc_cd", length));
			String[] stlAmt = (JSPUtil.getParameter(request, prefix	+ "stl_amt", length));
			String[] n3ptyStlTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_stl_tp_cd", length));
			String[] fmCltCngOfcN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "fm_clt_cng_ofc_n3pty_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] n3ptyNoDpSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_no_dp_seq", length));
			String[] otsStsNm = (JSPUtil.getParameter(request, prefix	+ "ots_sts_nm", length));
			String[] otsAmt = (JSPUtil.getParameter(request, prefix	+ "ots_amt", length));
			String[] sIfRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_if_rhq_cd", length));
			String[] n3ptySrcSubSysCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_sub_sys_cd", length));
			String[] n3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchActivityByClosingTPBVO();
				if (sCurrCdTp[i] != null)
					model.setSCurrCdTp(sCurrCdTp[i]);
				if (otsStsCd[i] != null)
					model.setOtsStsCd(otsStsCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (trdPartyCode[i] != null)
					model.setTrdPartyCode(trdPartyCode[i]);
				if (ifOfcCd[i] != null)
					model.setIfOfcCd(ifOfcCd[i]);
				if (cltAmt[i] != null)
					model.setCltAmt(cltAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sUserOfcCd[i] != null)
					model.setSUserOfcCd(sUserOfcCd[i]);
				if (invIssDt[i] != null)
					model.setInvIssDt(invIssDt[i]);
				if (sIfCtrlCd[i] != null)
					model.setSIfCtrlCd(sIfCtrlCd[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (n3ptyInvNo[i] != null)
					model.setN3ptyInvNo(n3ptyInvNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrCustDivCd[i] != null)
					model.setVndrCustDivCd(vndrCustDivCd[i]);
				if (balAmt[i] != null)
					model.setBalAmt(balAmt[i]);
				if (stlToCltCngOfcCd[i] != null)
					model.setStlToCltCngOfcCd(stlToCltCngOfcCd[i]);
				if (n3ptyBilTpCd[i] != null)
					model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (soIfSeq[i] != null)
					model.setSoIfSeq(soIfSeq[i]);
				if (cltActYn[i] != null)
					model.setCltActYn(cltActYn[i]);
				if (overdue[i] != null)
					model.setOverdue(overdue[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (stlRqstOfcCd[i] != null)
					model.setStlRqstOfcCd(stlRqstOfcCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (ednTpNm[i] != null)
					model.setEdnTpNm(ednTpNm[i]);
				if (blNoAll[i] != null)
					model.setBlNoAll(blNoAll[i]);
				if (trdPartyName[i] != null)
					model.setTrdPartyName(trdPartyName[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (ifUsrId[i] != null)
					model.setIfUsrId(ifUsrId[i]);
				if (sEdate[i] != null)
					model.setSEdate(sEdate[i]);
				if (bkgNoAll[i] != null)
					model.setBkgNoAll(bkgNoAll[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (sSdate[i] != null)
					model.setSSdate(sSdate[i]);
				if (sIfOfcCd[i] != null)
					model.setSIfOfcCd(sIfOfcCd[i]);
				if (stlAmt[i] != null)
					model.setStlAmt(stlAmt[i]);
				if (n3ptyStlTpCd[i] != null)
					model.setN3ptyStlTpCd(n3ptyStlTpCd[i]);
				if (fmCltCngOfcN3ptyNo[i] != null)
					model.setFmCltCngOfcN3ptyNo(fmCltCngOfcN3ptyNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (n3ptyNoDpSeq[i] != null)
					model.setN3ptyNoDpSeq(n3ptyNoDpSeq[i]);
				if (otsStsNm[i] != null)
					model.setOtsStsNm(otsStsNm[i]);
				if (otsAmt[i] != null)
					model.setOtsAmt(otsAmt[i]);
				if (sIfRhqCd[i] != null)
					model.setSIfRhqCd(sIfRhqCd[i]);
				if (n3ptySrcSubSysCd[i] != null)
					model.setN3ptySrcSubSysCd(n3ptySrcSubSysCd[i]);
				if (n3ptySrcNo[i] != null)
					model.setN3ptySrcNo(n3ptySrcNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchActivityByClosingTPBVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchActivityByClosingTPBVO[]
	 */
	public SearchActivityByClosingTPBVO[] getSearchActivityByClosingTPBVOs(){
		SearchActivityByClosingTPBVO[] vos = (SearchActivityByClosingTPBVO[])models.toArray(new SearchActivityByClosingTPBVO[models.size()]);
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
		this.sCurrCdTp = this.sCurrCdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStsCd = this.otsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyCode = this.trdPartyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOfcCd = this.ifOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltAmt = this.cltAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUserOfcCd = this.sUserOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssDt = this.invIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfCtrlCd = this.sIfCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNo = this.n3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustDivCd = this.vndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balAmt = this.balAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlToCltCngOfcCd = this.stlToCltCngOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soIfSeq = this.soIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltActYn = this.cltActYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overdue = this.overdue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlRqstOfcCd = this.stlRqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ednTpNm = this.ednTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoAll = this.blNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyName = this.trdPartyName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifUsrId = this.ifUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdate = this.sEdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoAll = this.bkgNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSdate = this.sSdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfOfcCd = this.sIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlAmt = this.stlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyStlTpCd = this.n3ptyStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCltCngOfcN3ptyNo = this.fmCltCngOfcN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNoDpSeq = this.n3ptyNoDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStsNm = this.otsStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAmt = this.otsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfRhqCd = this.sIfRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcSubSysCd = this.n3ptySrcSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNo = this.n3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
