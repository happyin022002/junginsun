/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CreateTPBCandidateVO.java
*@FileTitle : CreateTPBCandidateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.08.13 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CreateTPBCandidateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CreateTPBCandidateVO> models = new ArrayList<CreateTPBCandidateVO>();
	
	/* Column Info */
	private String otsDtlSeq = null;
	/* Column Info */
	private String sSkdVoyNo = null;
	/* Column Info */
	private String sBkgNoAll = null;
	/* Column Info */
	private String sN3ptyBilTpCd = null;
	/* Column Info */
	private String sVslCd = null;
	/* Column Info */ 
	private String sCustSeq = null;
	/* Column Info */
	private String sCustLglEngNm = null;
	/* Column Info */
	private String sBkgNo = null;
	/* Column Info */
	private String sSvrId = null;
	/* Column Info */
	private String sCurrCd = null;
	/* Column Info */
	private String sFileNo = null;
	/* Column Info */
	private String sBkgFincDirCd = null;
	/* Column Info */
	private String sTrdPartyNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sVndrCntCd = null;
	/* Column Info */
	private String sBlNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String sLgsCostCd = null;
	/* Column Info */
	private String sCostExptFlg = null;
	/* Column Info */
	private String sN3ptyOfcCd = null;
	/* Column Info */
	private String sSoNo = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String sMnlInpTpCd = null;
	/* Column Info */
	private String sIfDt = null;
	/* Column Info */
	private String sYdCd = null;
	/* Column Info */
	private String sIfRmk = null;
	/* Column Info */
	private String sTmlInvTpCd = null;
	/* Column Info */
	private String sN3ptySrcNo = null;
	/* Column Info */
	private String sVndrSeq = null;
	/* Column Info */
	private String sCustCntCd = null;
	/* Column Info */
	private String sSrcVndrSeq = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String sIfOfcCd = null;
	/* Column Info */
	private String sVndrCustDivCd = null;
	/* Column Info */
	private String sSkdDirCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String sVndrLglEngNm = null;
	/* Column Info */
	private String sN3ptySrcSubSysCd = null;
	/* Column Info */
	private String sN3ptyIfTpCd = null;
	/* Column Info */
	private String sSrcVndrCntCd = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String sN3ptyExpnTpCd = null;
	/* Column Info */
	private String sAcctCd = null;
	/* Column Info */
	private String eacTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CreateTPBCandidateVO() {}

	public CreateTPBCandidateVO(String ibflag, String pagerows, String userId, String sIfRmk, String ofcCd, String sN3ptySrcSubSysCd, String sN3ptyIfTpCd, String sIfOfcCd, String sN3ptyBilTpCd, String sN3ptyExpnTpCd, String sN3ptySrcNo, String sSoNo, String sBkgNo, String sBlNo, String sVslCd, String sSkdVoyNo, String sSkdDirCd, String sCurrCd, String sFileNo, String sVndrCustDivCd, String sVndrCntCd, String sVndrSeq, String sCustCntCd, String sCustSeq, String sN3ptyOfcCd, String sYdCd, String sIfDt, String sSvrId, String sSrcVndrCntCd, String sSrcVndrSeq, String sMnlInpTpCd, String sTrdPartyNm, String sBkgNoAll, String sVvd, String eqKndCd, String eqNo, String eqTpszCd, String ifAmt, String sVndrLglEngNm, String sCustLglEngNm, String sBkgFincDirCd, String sCostExptFlg, String sAcctCd, String sLgsCostCd, String sTmlInvTpCd, String otsDtlSeq,String eacTpCd) {
		this.otsDtlSeq = otsDtlSeq;
		this.sSkdVoyNo = sSkdVoyNo;
		this.sBkgNoAll = sBkgNoAll;
		this.sN3ptyBilTpCd = sN3ptyBilTpCd;
		this.sVslCd = sVslCd;
		this.sCustSeq = sCustSeq;
		this.sCustLglEngNm = sCustLglEngNm;
		this.sBkgNo = sBkgNo;
		this.sSvrId = sSvrId;
		this.sCurrCd = sCurrCd;
		this.sFileNo = sFileNo;
		this.sBkgFincDirCd = sBkgFincDirCd;
		this.sTrdPartyNm = sTrdPartyNm;
		this.pagerows = pagerows;
		this.sVndrCntCd = sVndrCntCd;
		this.sBlNo = sBlNo;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.sLgsCostCd = sLgsCostCd;
		this.sCostExptFlg = sCostExptFlg;
		this.sN3ptyOfcCd = sN3ptyOfcCd;
		this.sSoNo = sSoNo;
		this.userId = userId;
		this.sMnlInpTpCd = sMnlInpTpCd;
		this.sIfDt = sIfDt;
		this.sYdCd = sYdCd;
		this.sIfRmk = sIfRmk;
		this.sTmlInvTpCd = sTmlInvTpCd;
		this.sN3ptySrcNo = sN3ptySrcNo;
		this.sVndrSeq = sVndrSeq;
		this.sCustCntCd = sCustCntCd;
		this.sSrcVndrSeq = sSrcVndrSeq;
		this.sVvd = sVvd;
		this.sIfOfcCd = sIfOfcCd;
		this.sVndrCustDivCd = sVndrCustDivCd;
		this.sSkdDirCd = sSkdDirCd;
		this.eqTpszCd = eqTpszCd;
		this.ofcCd = ofcCd;
		this.sVndrLglEngNm = sVndrLglEngNm;
		this.sN3ptySrcSubSysCd = sN3ptySrcSubSysCd;
		this.sN3ptyIfTpCd = sN3ptyIfTpCd;
		this.sSrcVndrCntCd = sSrcVndrCntCd;
		this.ifAmt = ifAmt;
		this.eqKndCd = eqKndCd;
		this.sN3ptyExpnTpCd = sN3ptyExpnTpCd;
		this.sAcctCd = sAcctCd;
		this.eacTpCd = eacTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ots_dtl_seq", getOtsDtlSeq());
		this.hashColumns.put("s_skd_voy_no", getSSkdVoyNo());
		this.hashColumns.put("s_bkg_no_all", getSBkgNoAll());
		this.hashColumns.put("s_n3pty_bil_tp_cd", getSN3ptyBilTpCd());
		this.hashColumns.put("s_vsl_cd", getSVslCd());
		this.hashColumns.put("s_cust_seq", getSCustSeq());
		this.hashColumns.put("s_cust_lgl_eng_nm", getSCustLglEngNm());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("s_svr_id", getSSvrId());
		this.hashColumns.put("s_curr_cd", getSCurrCd());
		this.hashColumns.put("s_file_no", getSFileNo());
		this.hashColumns.put("s_bkg_finc_dir_cd", getSBkgFincDirCd());
		this.hashColumns.put("s_trd_party_nm", getSTrdPartyNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_vndr_cnt_cd", getSVndrCntCd());
		this.hashColumns.put("s_bl_no", getSBlNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("s_lgs_cost_cd", getSLgsCostCd());
		this.hashColumns.put("s_cost_expt_flg", getSCostExptFlg());
		this.hashColumns.put("s_n3pty_ofc_cd", getSN3ptyOfcCd());
		this.hashColumns.put("s_so_no", getSSoNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("s_mnl_inp_tp_cd", getSMnlInpTpCd());
		this.hashColumns.put("s_if_dt", getSIfDt());
		this.hashColumns.put("s_yd_cd", getSYdCd());
		this.hashColumns.put("s_if_rmk", getSIfRmk());
		this.hashColumns.put("s_tml_inv_tp_cd", getSTmlInvTpCd());
		this.hashColumns.put("s_n3pty_src_no", getSN3ptySrcNo());
		this.hashColumns.put("s_vndr_seq", getSVndrSeq());
		this.hashColumns.put("s_cust_cnt_cd", getSCustCntCd());
		this.hashColumns.put("s_src_vndr_seq", getSSrcVndrSeq());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
		this.hashColumns.put("s_vndr_cust_div_cd", getSVndrCustDivCd());
		this.hashColumns.put("s_skd_dir_cd", getSSkdDirCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("s_vndr_lgl_eng_nm", getSVndrLglEngNm());
		this.hashColumns.put("s_n3pty_src_sub_sys_cd", getSN3ptySrcSubSysCd());
		this.hashColumns.put("s_n3pty_if_tp_cd", getSN3ptyIfTpCd());
		this.hashColumns.put("s_src_vndr_cnt_cd", getSSrcVndrCntCd());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("s_n3pty_expn_tp_cd", getSN3ptyExpnTpCd());
		this.hashColumns.put("s_acct_cd", getSAcctCd());
		this.hashColumns.put("eac_tp_cd", getEacTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ots_dtl_seq", "otsDtlSeq");
		this.hashFields.put("s_skd_voy_no", "sSkdVoyNo");
		this.hashFields.put("s_bkg_no_all", "sBkgNoAll");
		this.hashFields.put("s_n3pty_bil_tp_cd", "sN3ptyBilTpCd");
		this.hashFields.put("s_vsl_cd", "sVslCd");
		this.hashFields.put("s_cust_seq", "sCustSeq");
		this.hashFields.put("s_cust_lgl_eng_nm", "sCustLglEngNm");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("s_svr_id", "sSvrId");
		this.hashFields.put("s_curr_cd", "sCurrCd");
		this.hashFields.put("s_file_no", "sFileNo");
		this.hashFields.put("s_bkg_finc_dir_cd", "sBkgFincDirCd");
		this.hashFields.put("s_trd_party_nm", "sTrdPartyNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_vndr_cnt_cd", "sVndrCntCd");
		this.hashFields.put("s_bl_no", "sBlNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("s_lgs_cost_cd", "sLgsCostCd");
		this.hashFields.put("s_cost_expt_flg", "sCostExptFlg");
		this.hashFields.put("s_n3pty_ofc_cd", "sN3ptyOfcCd");
		this.hashFields.put("s_so_no", "sSoNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("s_mnl_inp_tp_cd", "sMnlInpTpCd");
		this.hashFields.put("s_if_dt", "sIfDt");
		this.hashFields.put("s_yd_cd", "sYdCd");
		this.hashFields.put("s_if_rmk", "sIfRmk");
		this.hashFields.put("s_tml_inv_tp_cd", "sTmlInvTpCd");
		this.hashFields.put("s_n3pty_src_no", "sN3ptySrcNo");
		this.hashFields.put("s_vndr_seq", "sVndrSeq");
		this.hashFields.put("s_cust_cnt_cd", "sCustCntCd");
		this.hashFields.put("s_src_vndr_seq", "sSrcVndrSeq");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
		this.hashFields.put("s_vndr_cust_div_cd", "sVndrCustDivCd");
		this.hashFields.put("s_skd_dir_cd", "sSkdDirCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("s_vndr_lgl_eng_nm", "sVndrLglEngNm");
		this.hashFields.put("s_n3pty_src_sub_sys_cd", "sN3ptySrcSubSysCd");
		this.hashFields.put("s_n3pty_if_tp_cd", "sN3ptyIfTpCd");
		this.hashFields.put("s_src_vndr_cnt_cd", "sSrcVndrCntCd");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("s_n3pty_expn_tp_cd", "sN3ptyExpnTpCd");
		this.hashFields.put("s_acct_cd", "sAcctCd");
		this.hashFields.put("eac_tp_cd", "eacTpCd");
		return this.hashFields;
	}
	
	public String getOtsDtlSeq() {
		return otsDtlSeq;
	}

	public void setOtsDtlSeq(String otsDtlSeq) {
		this.otsDtlSeq = otsDtlSeq;
	}

	/**
	 * Column Info
	 * @return sSkdVoyNo
	 */
	public String getSSkdVoyNo() {
		return this.sSkdVoyNo;
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
	 * @return sN3ptyBilTpCd
	 */
	public String getSN3ptyBilTpCd() {
		return this.sN3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @return sVslCd
	 */
	public String getSVslCd() {
		return this.sVslCd;
	}
	
	/**
	 * Column Info
	 * @return sCustSeq
	 */
	public String getSCustSeq() {
		return this.sCustSeq;
	}
	
	/**
	 * Column Info
	 * @return sCustLglEngNm
	 */
	public String getSCustLglEngNm() {
		return this.sCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return sBkgNo
	 */
	public String getSBkgNo() {
		return this.sBkgNo;
	}
	
	/**
	 * Column Info
	 * @return sSvrId
	 */
	public String getSSvrId() {
		return this.sSvrId;
	}
	
	/**
	 * Column Info
	 * @return sCurrCd
	 */
	public String getSCurrCd() {
		return this.sCurrCd;
	}
	
	/**
	 * Column Info
	 * @return sFileNo
	 */
	public String getSFileNo() {
		return this.sFileNo;
	}
	
	/**
	 * Column Info
	 * @return sBkgFincDirCd
	 */
	public String getSBkgFincDirCd() {
		return this.sBkgFincDirCd;
	}
	
	/**
	 * Column Info
	 * @return sTrdPartyNm
	 */
	public String getSTrdPartyNm() {
		return this.sTrdPartyNm;
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
	 * @return sVndrCntCd
	 */
	public String getSVndrCntCd() {
		return this.sVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return sBlNo
	 */
	public String getSBlNo() {
		return this.sBlNo;
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
	 * @return sLgsCostCd
	 */
	public String getSLgsCostCd() {
		return this.sLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return sCostExptFlg
	 */
	public String getSCostExptFlg() {
		return this.sCostExptFlg;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyOfcCd
	 */
	public String getSN3ptyOfcCd() {
		return this.sN3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sSoNo
	 */
	public String getSSoNo() {
		return this.sSoNo;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return sMnlInpTpCd
	 */
	public String getSMnlInpTpCd() {
		return this.sMnlInpTpCd;
	}
	
	/**
	 * Column Info
	 * @return sIfDt
	 */
	public String getSIfDt() {
		return this.sIfDt;
	}
	
	/**
	 * Column Info
	 * @return sYdCd
	 */
	public String getSYdCd() {
		return this.sYdCd;
	}
	
	/**
	 * Column Info
	 * @return sIfRmk
	 */
	public String getSIfRmk() {
		return this.sIfRmk;
	}
	
	/**
	 * Column Info
	 * @return sTmlInvTpCd
	 */
	public String getSTmlInvTpCd() {
		return this.sTmlInvTpCd;
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
	 * @return sVndrSeq
	 */
	public String getSVndrSeq() {
		return this.sVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return sCustCntCd
	 */
	public String getSCustCntCd() {
		return this.sCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return sSrcVndrSeq
	 */
	public String getSSrcVndrSeq() {
		return this.sSrcVndrSeq;
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
	 * @return sIfOfcCd
	 */
	public String getSIfOfcCd() {
		return this.sIfOfcCd;
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
	 * @return sSkdDirCd
	 */
	public String getSSkdDirCd() {
		return this.sSkdDirCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return sVndrLglEngNm
	 */
	public String getSVndrLglEngNm() {
		return this.sVndrLglEngNm;
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
	 * @return sN3ptyIfTpCd
	 */
	public String getSN3ptyIfTpCd() {
		return this.sN3ptyIfTpCd;
	}
	
	/**
	 * Column Info
	 * @return sSrcVndrCntCd
	 */
	public String getSSrcVndrCntCd() {
		return this.sSrcVndrCntCd;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyExpnTpCd
	 */
	public String getSN3ptyExpnTpCd() {
		return this.sN3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @return sAcctCd
	 */
	public String getSAcctCd() {
		return this.sAcctCd;
	}
	
	
	/**
	 * Column Info
	 * @return eacTpCd
	 */
	public String getEacTpCd() {
		return this.eacTpCd;
	}
	

	/**
	 * Column Info
	 * @param sSkdVoyNo
	 */
	public void setSSkdVoyNo(String sSkdVoyNo) {
		this.sSkdVoyNo = sSkdVoyNo;
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
	 * @param sN3ptyBilTpCd
	 */
	public void setSN3ptyBilTpCd(String sN3ptyBilTpCd) {
		this.sN3ptyBilTpCd = sN3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @param sVslCd
	 */
	public void setSVslCd(String sVslCd) {
		this.sVslCd = sVslCd;
	}
	
	/**
	 * Column Info
	 * @param sCustSeq
	 */
	public void setSCustSeq(String sCustSeq) {
		this.sCustSeq = sCustSeq;
	}
	
	/**
	 * Column Info
	 * @param sCustLglEngNm
	 */
	public void setSCustLglEngNm(String sCustLglEngNm) {
		this.sCustLglEngNm = sCustLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param sBkgNo
	 */
	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
	}
	
	/**
	 * Column Info
	 * @param sSvrId
	 */
	public void setSSvrId(String sSvrId) {
		this.sSvrId = sSvrId;
	}
	
	/**
	 * Column Info
	 * @param sCurrCd
	 */
	public void setSCurrCd(String sCurrCd) {
		this.sCurrCd = sCurrCd;
	}
	
	/**
	 * Column Info
	 * @param sFileNo
	 */
	public void setSFileNo(String sFileNo) {
		this.sFileNo = sFileNo;
	}
	
	/**
	 * Column Info
	 * @param sBkgFincDirCd
	 */
	public void setSBkgFincDirCd(String sBkgFincDirCd) {
		this.sBkgFincDirCd = sBkgFincDirCd;
	}
	
	/**
	 * Column Info
	 * @param sTrdPartyNm
	 */
	public void setSTrdPartyNm(String sTrdPartyNm) {
		this.sTrdPartyNm = sTrdPartyNm;
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
	 * @param sVndrCntCd
	 */
	public void setSVndrCntCd(String sVndrCntCd) {
		this.sVndrCntCd = sVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param sBlNo
	 */
	public void setSBlNo(String sBlNo) {
		this.sBlNo = sBlNo;
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
	 * @param sLgsCostCd
	 */
	public void setSLgsCostCd(String sLgsCostCd) {
		this.sLgsCostCd = sLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param sCostExptFlg
	 */
	public void setSCostExptFlg(String sCostExptFlg) {
		this.sCostExptFlg = sCostExptFlg;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyOfcCd
	 */
	public void setSN3ptyOfcCd(String sN3ptyOfcCd) {
		this.sN3ptyOfcCd = sN3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sSoNo
	 */
	public void setSSoNo(String sSoNo) {
		this.sSoNo = sSoNo;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param sMnlInpTpCd
	 */
	public void setSMnlInpTpCd(String sMnlInpTpCd) {
		this.sMnlInpTpCd = sMnlInpTpCd;
	}
	
	/**
	 * Column Info
	 * @param sIfDt
	 */
	public void setSIfDt(String sIfDt) {
		this.sIfDt = sIfDt;
	}
	
	/**
	 * Column Info
	 * @param sYdCd
	 */
	public void setSYdCd(String sYdCd) {
		this.sYdCd = sYdCd;
	}
	
	/**
	 * Column Info
	 * @param sIfRmk
	 */
	public void setSIfRmk(String sIfRmk) {
		this.sIfRmk = sIfRmk;
	}
	
	/**
	 * Column Info
	 * @param sTmlInvTpCd
	 */
	public void setSTmlInvTpCd(String sTmlInvTpCd) {
		this.sTmlInvTpCd = sTmlInvTpCd;
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
	 * @param sVndrSeq
	 */
	public void setSVndrSeq(String sVndrSeq) {
		this.sVndrSeq = sVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param sCustCntCd
	 */
	public void setSCustCntCd(String sCustCntCd) {
		this.sCustCntCd = sCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param sSrcVndrSeq
	 */
	public void setSSrcVndrSeq(String sSrcVndrSeq) {
		this.sSrcVndrSeq = sSrcVndrSeq;
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
	 * @param sIfOfcCd
	 */
	public void setSIfOfcCd(String sIfOfcCd) {
		this.sIfOfcCd = sIfOfcCd;
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
	 * @param sSkdDirCd
	 */
	public void setSSkdDirCd(String sSkdDirCd) {
		this.sSkdDirCd = sSkdDirCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param sVndrLglEngNm
	 */
	public void setSVndrLglEngNm(String sVndrLglEngNm) {
		this.sVndrLglEngNm = sVndrLglEngNm;
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
	 * @param sN3ptyIfTpCd
	 */
	public void setSN3ptyIfTpCd(String sN3ptyIfTpCd) {
		this.sN3ptyIfTpCd = sN3ptyIfTpCd;
	}
	
	/**
	 * Column Info
	 * @param sSrcVndrCntCd
	 */
	public void setSSrcVndrCntCd(String sSrcVndrCntCd) {
		this.sSrcVndrCntCd = sSrcVndrCntCd;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyExpnTpCd
	 */
	public void setSN3ptyExpnTpCd(String sN3ptyExpnTpCd) {
		this.sN3ptyExpnTpCd = sN3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @param sAcctCd
	 */
	public void setSAcctCd(String sAcctCd) {
		this.sAcctCd = sAcctCd;
	}

	/**
	 * Column Info
	 * @param eacTpCd
	 */
	public void setEacTpCd(String eacTpCd) {
		this.eacTpCd = eacTpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOtsDtlSeq(JSPUtil.getParameter(request, "ots_dtl_seq", ""));
		setSSkdVoyNo(JSPUtil.getParameter(request, "s_skd_voy_no", ""));
		setSBkgNoAll(JSPUtil.getParameter(request, "s_bkg_no_all", ""));
		setSN3ptyBilTpCd(JSPUtil.getParameter(request, "s_n3pty_bil_tp_cd", ""));
		setSVslCd(JSPUtil.getParameter(request, "s_vsl_cd", ""));
		setSCustSeq(JSPUtil.getParameter(request, "s_cust_seq", ""));
		setSCustLglEngNm(JSPUtil.getParameter(request, "s_cust_lgl_eng_nm", ""));
		setSBkgNo(JSPUtil.getParameter(request, "s_bkg_no", ""));
		setSSvrId(JSPUtil.getParameter(request, "s_svr_id", ""));
		setSCurrCd(JSPUtil.getParameter(request, "s_curr_cd", ""));
		setSFileNo(JSPUtil.getParameter(request, "s_file_no", ""));
		setSBkgFincDirCd(JSPUtil.getParameter(request, "s_bkg_finc_dir_cd", ""));
		setSTrdPartyNm(JSPUtil.getParameter(request, "s_trd_party_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSVndrCntCd(JSPUtil.getParameter(request, "s_vndr_cnt_cd", ""));
		setSBlNo(JSPUtil.getParameter(request, "s_bl_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setSLgsCostCd(JSPUtil.getParameter(request, "s_lgs_cost_cd", ""));
		setSCostExptFlg(JSPUtil.getParameter(request, "s_cost_expt_flg", ""));
		setSN3ptyOfcCd(JSPUtil.getParameter(request, "s_n3pty_ofc_cd", ""));
		setSSoNo(JSPUtil.getParameter(request, "s_so_no", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setSMnlInpTpCd(JSPUtil.getParameter(request, "s_mnl_inp_tp_cd", ""));
		setSIfDt(JSPUtil.getParameter(request, "s_if_dt", ""));
		setSYdCd(JSPUtil.getParameter(request, "s_yd_cd", ""));
		setSIfRmk(JSPUtil.getParameter(request, "s_if_rmk", ""));
		setSTmlInvTpCd(JSPUtil.getParameter(request, "s_tml_inv_tp_cd", ""));
		setSN3ptySrcNo(JSPUtil.getParameter(request, "s_n3pty_src_no", ""));
		setSVndrSeq(JSPUtil.getParameter(request, "s_vndr_seq", ""));
		setSCustCntCd(JSPUtil.getParameter(request, "s_cust_cnt_cd", ""));
		setSSrcVndrSeq(JSPUtil.getParameter(request, "s_src_vndr_seq", ""));
		setSVvd(JSPUtil.getParameter(request, "s_vvd", ""));
		setSIfOfcCd(JSPUtil.getParameter(request, "s_if_ofc_cd", ""));
		setSVndrCustDivCd(JSPUtil.getParameter(request, "s_vndr_cust_div_cd", ""));
		setSSkdDirCd(JSPUtil.getParameter(request, "s_skd_dir_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSVndrLglEngNm(JSPUtil.getParameter(request, "s_vndr_lgl_eng_nm", ""));
		setSN3ptySrcSubSysCd(JSPUtil.getParameter(request, "s_n3pty_src_sub_sys_cd", ""));
		setSN3ptyIfTpCd(JSPUtil.getParameter(request, "s_n3pty_if_tp_cd", ""));
		setSSrcVndrCntCd(JSPUtil.getParameter(request, "s_src_vndr_cnt_cd", ""));
		setIfAmt(JSPUtil.getParameter(request, "if_amt", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setSN3ptyExpnTpCd(JSPUtil.getParameter(request, "s_n3pty_expn_tp_cd", ""));
		setSAcctCd(JSPUtil.getParameter(request, "s_acct_cd", ""));
		setEacTpCd(JSPUtil.getParameter(request, "eac_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreateTPBCandidateVO[]
	 */
	public CreateTPBCandidateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreateTPBCandidateVO[]
	 */
	public CreateTPBCandidateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreateTPBCandidateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] otsDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ots_dtl_seq", length));
			String[] sSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "s_skd_voy_no", length));
			String[] sBkgNoAll = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no_all", length));
			String[] sN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_bil_tp_cd", length));
			String[] sVslCd = (JSPUtil.getParameter(request, prefix	+ "s_vsl_cd", length));
			String[] sCustSeq = (JSPUtil.getParameter(request, prefix	+ "s_cust_seq", length));
			String[] sCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_lgl_eng_nm", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] sSvrId = (JSPUtil.getParameter(request, prefix	+ "s_svr_id", length));
			String[] sCurrCd = (JSPUtil.getParameter(request, prefix	+ "s_curr_cd", length));
			String[] sFileNo = (JSPUtil.getParameter(request, prefix	+ "s_file_no", length));
			String[] sBkgFincDirCd = (JSPUtil.getParameter(request, prefix	+ "s_bkg_finc_dir_cd", length));
			String[] sTrdPartyNm = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sVndrCntCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cnt_cd", length));
			String[] sBlNo = (JSPUtil.getParameter(request, prefix	+ "s_bl_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] sLgsCostCd = (JSPUtil.getParameter(request, prefix	+ "s_lgs_cost_cd", length));
			String[] sCostExptFlg = (JSPUtil.getParameter(request, prefix	+ "s_cost_expt_flg", length));
			String[] sN3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_ofc_cd", length));
			String[] sSoNo = (JSPUtil.getParameter(request, prefix	+ "s_so_no", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] sMnlInpTpCd = (JSPUtil.getParameter(request, prefix	+ "s_mnl_inp_tp_cd", length));
			String[] sIfDt = (JSPUtil.getParameter(request, prefix	+ "s_if_dt", length));
			String[] sYdCd = (JSPUtil.getParameter(request, prefix	+ "s_yd_cd", length));
			String[] sIfRmk = (JSPUtil.getParameter(request, prefix	+ "s_if_rmk", length));
			String[] sTmlInvTpCd = (JSPUtil.getParameter(request, prefix	+ "s_tml_inv_tp_cd", length));
			String[] sN3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_src_no", length));
			String[] sVndrSeq = (JSPUtil.getParameter(request, prefix	+ "s_vndr_seq", length));
			String[] sCustCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cnt_cd", length));
			String[] sSrcVndrSeq = (JSPUtil.getParameter(request, prefix	+ "s_src_vndr_seq", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ofc_cd", length));
			String[] sVndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_div_cd", length));
			String[] sSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "s_skd_dir_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] sVndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "s_vndr_lgl_eng_nm", length));
			String[] sN3ptySrcSubSysCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_src_sub_sys_cd", length));
			String[] sN3ptyIfTpCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_if_tp_cd", length));
			String[] sSrcVndrCntCd = (JSPUtil.getParameter(request, prefix	+ "s_src_vndr_cnt_cd", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] sN3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_expn_tp_cd", length));
			String[] sAcctCd = (JSPUtil.getParameter(request, prefix	+ "s_acct_cd", length));
			String[] eacTpCd = (JSPUtil.getParameter(request, prefix	+ "eac_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CreateTPBCandidateVO();
				if (otsDtlSeq[i] != null)
					model.setOtsDtlSeq(otsDtlSeq[i]);
				if (sSkdVoyNo[i] != null)
					model.setSSkdVoyNo(sSkdVoyNo[i]);
				if (sBkgNoAll[i] != null)
					model.setSBkgNoAll(sBkgNoAll[i]);
				if (sN3ptyBilTpCd[i] != null)
					model.setSN3ptyBilTpCd(sN3ptyBilTpCd[i]);
				if (sVslCd[i] != null)
					model.setSVslCd(sVslCd[i]);
				if (sCustSeq[i] != null)
					model.setSCustSeq(sCustSeq[i]);
				if (sCustLglEngNm[i] != null)
					model.setSCustLglEngNm(sCustLglEngNm[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (sSvrId[i] != null)
					model.setSSvrId(sSvrId[i]);
				if (sCurrCd[i] != null)
					model.setSCurrCd(sCurrCd[i]);
				if (sFileNo[i] != null)
					model.setSFileNo(sFileNo[i]);
				if (sBkgFincDirCd[i] != null)
					model.setSBkgFincDirCd(sBkgFincDirCd[i]);
				if (sTrdPartyNm[i] != null)
					model.setSTrdPartyNm(sTrdPartyNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sVndrCntCd[i] != null)
					model.setSVndrCntCd(sVndrCntCd[i]);
				if (sBlNo[i] != null)
					model.setSBlNo(sBlNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (sLgsCostCd[i] != null)
					model.setSLgsCostCd(sLgsCostCd[i]);
				if (sCostExptFlg[i] != null)
					model.setSCostExptFlg(sCostExptFlg[i]);
				if (sN3ptyOfcCd[i] != null)
					model.setSN3ptyOfcCd(sN3ptyOfcCd[i]);
				if (sSoNo[i] != null)
					model.setSSoNo(sSoNo[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (sMnlInpTpCd[i] != null)
					model.setSMnlInpTpCd(sMnlInpTpCd[i]);
				if (sIfDt[i] != null)
					model.setSIfDt(sIfDt[i]);
				if (sYdCd[i] != null)
					model.setSYdCd(sYdCd[i]);
				if (sIfRmk[i] != null)
					model.setSIfRmk(sIfRmk[i]);
				if (sTmlInvTpCd[i] != null)
					model.setSTmlInvTpCd(sTmlInvTpCd[i]);
				if (sN3ptySrcNo[i] != null)
					model.setSN3ptySrcNo(sN3ptySrcNo[i]);
				if (sVndrSeq[i] != null)
					model.setSVndrSeq(sVndrSeq[i]);
				if (sCustCntCd[i] != null)
					model.setSCustCntCd(sCustCntCd[i]);
				if (sSrcVndrSeq[i] != null)
					model.setSSrcVndrSeq(sSrcVndrSeq[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (sIfOfcCd[i] != null)
					model.setSIfOfcCd(sIfOfcCd[i]);
				if (sVndrCustDivCd[i] != null)
					model.setSVndrCustDivCd(sVndrCustDivCd[i]);
				if (sSkdDirCd[i] != null)
					model.setSSkdDirCd(sSkdDirCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (sVndrLglEngNm[i] != null)
					model.setSVndrLglEngNm(sVndrLglEngNm[i]);
				if (sN3ptySrcSubSysCd[i] != null)
					model.setSN3ptySrcSubSysCd(sN3ptySrcSubSysCd[i]);
				if (sN3ptyIfTpCd[i] != null)
					model.setSN3ptyIfTpCd(sN3ptyIfTpCd[i]);
				if (sSrcVndrCntCd[i] != null)
					model.setSSrcVndrCntCd(sSrcVndrCntCd[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (sN3ptyExpnTpCd[i] != null)
					model.setSN3ptyExpnTpCd(sN3ptyExpnTpCd[i]);
				if (sAcctCd[i] != null)
					model.setSAcctCd(sAcctCd[i]);
				if (eacTpCd[i] != null)
					model.setEacTpCd(eacTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreateTPBCandidateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreateTPBCandidateVO[]
	 */
	public CreateTPBCandidateVO[] getCreateTPBCandidateVOs(){
		CreateTPBCandidateVO[] vos = (CreateTPBCandidateVO[])models.toArray(new CreateTPBCandidateVO[models.size()]);
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
		this.otsDtlSeq = this.otsDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSkdVoyNo = this.sSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNoAll = this.sBkgNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyBilTpCd = this.sN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVslCd = this.sVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustSeq = this.sCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustLglEngNm = this.sCustLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSvrId = this.sSvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCurrCd = this.sCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFileNo = this.sFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgFincDirCd = this.sBkgFincDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyNm = this.sTrdPartyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCntCd = this.sVndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBlNo = this.sBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLgsCostCd = this.sLgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCostExptFlg = this.sCostExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyOfcCd = this.sN3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSoNo = this.sSoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sMnlInpTpCd = this.sMnlInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfDt = this.sIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sYdCd = this.sYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfRmk = this.sIfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTmlInvTpCd = this.sTmlInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptySrcNo = this.sN3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrSeq = this.sVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCntCd = this.sCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSrcVndrSeq = this.sSrcVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfOfcCd = this.sIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustDivCd = this.sVndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSkdDirCd = this.sSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrLglEngNm = this.sVndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptySrcSubSysCd = this.sN3ptySrcSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyIfTpCd = this.sN3ptyIfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSrcVndrCntCd = this.sSrcVndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyExpnTpCd = this.sN3ptyExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAcctCd = this.sAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacTpCd = this.eacTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
