/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchJOCandidateConfirmListVO.java
*@FileTitle : SearchJOCandidateConfirmListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.0
* 2009-09-14 Jong-Geon Byeon	1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.jocasemanage.jocandidateconfirm.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class SearchJOCandidateConfirmListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchJOCandidateConfirmListVO> models = new ArrayList<SearchJOCandidateConfirmListVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String gBkgNoAll = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String sBkgNoAll = null;
	/* Column Info */
	private String ifOfcCd = null;
	/* Column Info */
	private String inOtsDtlSeq = null;
	/* Column Info */
	private String otsDtlSeq = null;
	/* Column Info */
	private String currN3ptyNo = null;
	/* Column Info */
	private String n3ptyBilTpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cfmD = null;
	/* Column Info */
	private String n3ptyOfcCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cfmI = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String cfmG = null;
	/* Column Info */
	private String ifUsrNm = null;
	/* Column Info */
	private String rvwOfcCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String cfmR = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String n3ptyIfTpCd = null;
	/* Column Info */
	private String sN3ptySrcNo = null;
	/* Column Info */
	private String sBlNoAll = null;
	/* Column Info */
	private String cfmN = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String estmRvisNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String ifAmtUsd = null;
	/* Column Info */
	private String sCsrNo = null;
	/* Column Info */
	private String n3ptySrcSubSysCd = null;
	/* Column Info */
	private String n3ptyNonCfmRsnCd = null;
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String checkFincDirCd = null;
	/* Column Info */
	private String sN3ptyBilTpCd = null;
	/* Column Info */
	private String costExptFlg = null;
	/* Column Info */
	private String rvwUsrId = null;
	/* Column Info */
	private String vndrCustDivCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cfmAmt = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String estmSeqNo = null;
	/* Column Info */
	private String tesGubun = null;
	/* Column Info */
	private String srcVndrSeq = null;
	/* Column Info */
	private String gBlNoAll = null;
	/* Column Info */
	private String ifUsrId = null;
	/* Column Info */
	private String sEdate = null;
	/* Column Info */
	private String trsGubun = null;
	/* Column Info */
	private String ifRmkFlag = null;
	/* Column Info */
	private String sNr = null;
	/* Column Info */
	private String sSdate = null;
	/* Column Info */
	private String estmSysAreaGrpId = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String sIfOfcCd = null;
	/* Column Info */
	private String cfmRmk = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String sN3ptySrcSubSysCd = null;
	/* Column Info */
	private String cfm = null;
	/* Column Info */
	private String gVvd = null;
	/* Column Info */
	private String eqKndNm = null;
	/* Column Info */
	private String ifCurrCd = null;
	/* Column Info */
	private String estmDtlSeqNo = null;
	/* Column Info */
	private String trdPartyVal = null;
	/* Column Info */
	private String n3ptySrcNo = null;
	/* Column Info */
	private String cfmC = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchJOCandidateConfirmListVO() {}

	public SearchJOCandidateConfirmListVO(String ibflag, String pagerows, String cfmI, String cfmG, String cfmN, String cfmR, String cfmD, String otsDtlSeq, String n3ptyNo, String n3ptySrcSubSysCd, String n3ptyBilTpNm, String n3ptySrcNo, String vndrCustDivCd, String trdPartyVal, String eqKndNm, String eqNo, String eqTpszCd, String gBkgNoAll, String gBlNoAll, String gVvd, String ifCurrCd, String ifAmt, String ifAmtUsd, String ifRmkFlag, String cfmAmt, String ifDt, String ifOfcCd, String ifUsrId, String ifUsrNm, String cfmRmk, String rvwOfcCd, String rvwUsrId, String n3ptyNonCfmRsnCd, String csrNo, String glDt, String vvdCd, String vndrCntCd, String vndrSeq, String custCntCd, String custSeq, String n3ptyOfcCd, String n3ptyIfTpCd, String srcVndrSeq, String tesGubun, String trsGubun, String estmSeqNo, String estmRvisNo, String estmDtlSeqNo, String estmSysAreaGrpId, String costExptFlg, String checkFincDirCd, String ofcCd, String sIfOfcCd, String sVvd, String sBkgNoAll, String sBlNoAll, String sCsrNo, String sN3ptySrcNo, String sN3ptySrcSubSysCd, String sN3ptyBilTpCd, String sNr, String sSdate, String sEdate, String currN3ptyNo, String cfm, String userOfcCd, String userId, String inOtsDtlSeq, String cfmC) {
		this.ifDt = ifDt;
		this.vndrCntCd = vndrCntCd;
		this.gBkgNoAll = gBkgNoAll;
		this.glDt = glDt;
		this.sBkgNoAll = sBkgNoAll;
		this.ifOfcCd = ifOfcCd;
		this.inOtsDtlSeq = inOtsDtlSeq;
		this.otsDtlSeq = otsDtlSeq;
		this.currN3ptyNo = currN3ptyNo;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.pagerows = pagerows;
		this.cfmD = cfmD;
		this.n3ptyOfcCd = n3ptyOfcCd;
		this.vvdCd = vvdCd;
		this.cfmI = cfmI;
		this.userId = userId;
		this.cfmG = cfmG;
		this.ifUsrNm = ifUsrNm;
		this.rvwOfcCd = rvwOfcCd;
		this.custCntCd = custCntCd;
		this.cfmR = cfmR;
		this.csrNo = csrNo;
		this.n3ptyIfTpCd = n3ptyIfTpCd;
		this.sN3ptySrcNo = sN3ptySrcNo;
		this.sBlNoAll = sBlNoAll;
		this.cfmN = cfmN;
		this.eqTpszCd = eqTpszCd;
		this.estmRvisNo = estmRvisNo;
		this.vndrSeq = vndrSeq;
		this.ifAmt = ifAmt;
		this.ifAmtUsd = ifAmtUsd;
		this.sCsrNo = sCsrNo;
		this.n3ptySrcSubSysCd = n3ptySrcSubSysCd;
		this.n3ptyNonCfmRsnCd = n3ptyNonCfmRsnCd;
		this.userOfcCd = userOfcCd;
		this.checkFincDirCd = checkFincDirCd;
		this.sN3ptyBilTpCd = sN3ptyBilTpCd;
		this.costExptFlg = costExptFlg;
		this.rvwUsrId = rvwUsrId;
		this.vndrCustDivCd = vndrCustDivCd;
		this.ibflag = ibflag;
		this.cfmAmt = cfmAmt;
		this.eqNo = eqNo;
		this.n3ptyNo = n3ptyNo;
		this.estmSeqNo = estmSeqNo;
		this.tesGubun = tesGubun;
		this.srcVndrSeq = srcVndrSeq;
		this.gBlNoAll = gBlNoAll;
		this.ifUsrId = ifUsrId;
		this.sEdate = sEdate;
		this.trsGubun = trsGubun;
		this.ifRmkFlag = ifRmkFlag;
		this.sNr = sNr;
		this.sSdate = sSdate;
		this.estmSysAreaGrpId = estmSysAreaGrpId;
		this.sVvd = sVvd;
		this.sIfOfcCd = sIfOfcCd;
		this.cfmRmk = cfmRmk;
		this.custSeq = custSeq;
		this.ofcCd = ofcCd;
		this.sN3ptySrcSubSysCd = sN3ptySrcSubSysCd;
		this.cfm = cfm;
		this.gVvd = gVvd;
		this.eqKndNm = eqKndNm;
		this.ifCurrCd = ifCurrCd;
		this.estmDtlSeqNo = estmDtlSeqNo;
		this.trdPartyVal = trdPartyVal;
		this.n3ptySrcNo = n3ptySrcNo;
		this.cfmC = cfmC;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("g_bkg_no_all", getGBkgNoAll());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("s_bkg_no_all", getSBkgNoAll());
		this.hashColumns.put("if_ofc_cd", getIfOfcCd());
		this.hashColumns.put("in_ots_dtl_seq", getInOtsDtlSeq());
		this.hashColumns.put("ots_dtl_seq", getOtsDtlSeq());
		this.hashColumns.put("curr_n3pty_no", getCurrN3ptyNo());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cfm_d", getCfmD());
		this.hashColumns.put("n3pty_ofc_cd", getN3ptyOfcCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cfm_i", getCfmI());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("cfm_g", getCfmG());
		this.hashColumns.put("if_usr_nm", getIfUsrNm());
		this.hashColumns.put("rvw_ofc_cd", getRvwOfcCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cfm_r", getCfmR());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("n3pty_if_tp_cd", getN3ptyIfTpCd());
		this.hashColumns.put("s_n3pty_src_no", getSN3ptySrcNo());
		this.hashColumns.put("s_bl_no_all", getSBlNoAll());
		this.hashColumns.put("cfm_n", getCfmN());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("estm_rvis_no", getEstmRvisNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("if_amt_usd", getIfAmtUsd());
		this.hashColumns.put("s_csr_no", getSCsrNo());
		this.hashColumns.put("n3pty_src_sub_sys_cd", getN3ptySrcSubSysCd());
		this.hashColumns.put("n3pty_non_cfm_rsn_cd", getN3ptyNonCfmRsnCd());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("check_finc_dir_cd", getCheckFincDirCd());
		this.hashColumns.put("s_n3pty_bil_tp_cd", getSN3ptyBilTpCd());
		this.hashColumns.put("cost_expt_flg", getCostExptFlg());
		this.hashColumns.put("rvw_usr_id", getRvwUsrId());
		this.hashColumns.put("vndr_cust_div_cd", getVndrCustDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cfm_amt", getCfmAmt());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("estm_seq_no", getEstmSeqNo());
		this.hashColumns.put("tes_gubun", getTesGubun());
		this.hashColumns.put("src_vndr_seq", getSrcVndrSeq());
		this.hashColumns.put("g_bl_no_all", getGBlNoAll());
		this.hashColumns.put("if_usr_id", getIfUsrId());
		this.hashColumns.put("s_edate", getSEdate());
		this.hashColumns.put("trs_gubun", getTrsGubun());
		this.hashColumns.put("if_rmk_flag", getIfRmkFlag());
		this.hashColumns.put("s_nr", getSNr());
		this.hashColumns.put("s_sdate", getSSdate());
		this.hashColumns.put("estm_sys_area_grp_id", getEstmSysAreaGrpId());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
		this.hashColumns.put("cfm_rmk", getCfmRmk());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("s_n3pty_src_sub_sys_cd", getSN3ptySrcSubSysCd());
		this.hashColumns.put("cfm", getCfm());
		this.hashColumns.put("g_vvd", getGVvd());
		this.hashColumns.put("eq_knd_nm", getEqKndNm());
		this.hashColumns.put("if_curr_cd", getIfCurrCd());
		this.hashColumns.put("estm_dtl_seq_no", getEstmDtlSeqNo());
		this.hashColumns.put("trd_party_val", getTrdPartyVal());
		this.hashColumns.put("n3pty_src_no", getN3ptySrcNo());
		this.hashColumns.put("cfm_c", getCfmC());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("g_bkg_no_all", "gBkgNoAll");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("s_bkg_no_all", "sBkgNoAll");
		this.hashFields.put("if_ofc_cd", "ifOfcCd");
		this.hashFields.put("in_ots_dtl_seq", "inOtsDtlSeq");
		this.hashFields.put("ots_dtl_seq", "otsDtlSeq");
		this.hashFields.put("curr_n3pty_no", "currN3ptyNo");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cfm_d", "cfmD");
		this.hashFields.put("n3pty_ofc_cd", "n3ptyOfcCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cfm_i", "cfmI");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("cfm_g", "cfmG");
		this.hashFields.put("if_usr_nm", "ifUsrNm");
		this.hashFields.put("rvw_ofc_cd", "rvwOfcCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cfm_r", "cfmR");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("n3pty_if_tp_cd", "n3ptyIfTpCd");
		this.hashFields.put("s_n3pty_src_no", "sN3ptySrcNo");
		this.hashFields.put("s_bl_no_all", "sBlNoAll");
		this.hashFields.put("cfm_n", "cfmN");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("estm_rvis_no", "estmRvisNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("if_amt_usd", "ifAmtUsd");
		this.hashFields.put("s_csr_no", "sCsrNo");
		this.hashFields.put("n3pty_src_sub_sys_cd", "n3ptySrcSubSysCd");
		this.hashFields.put("n3pty_non_cfm_rsn_cd", "n3ptyNonCfmRsnCd");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("check_finc_dir_cd", "checkFincDirCd");
		this.hashFields.put("s_n3pty_bil_tp_cd", "sN3ptyBilTpCd");
		this.hashFields.put("cost_expt_flg", "costExptFlg");
		this.hashFields.put("rvw_usr_id", "rvwUsrId");
		this.hashFields.put("vndr_cust_div_cd", "vndrCustDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cfm_amt", "cfmAmt");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("estm_seq_no", "estmSeqNo");
		this.hashFields.put("tes_gubun", "tesGubun");
		this.hashFields.put("src_vndr_seq", "srcVndrSeq");
		this.hashFields.put("g_bl_no_all", "gBlNoAll");
		this.hashFields.put("if_usr_id", "ifUsrId");
		this.hashFields.put("s_edate", "sEdate");
		this.hashFields.put("trs_gubun", "trsGubun");
		this.hashFields.put("if_rmk_flag", "ifRmkFlag");
		this.hashFields.put("s_nr", "sNr");
		this.hashFields.put("s_sdate", "sSdate");
		this.hashFields.put("estm_sys_area_grp_id", "estmSysAreaGrpId");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
		this.hashFields.put("cfm_rmk", "cfmRmk");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("s_n3pty_src_sub_sys_cd", "sN3ptySrcSubSysCd");
		this.hashFields.put("cfm", "cfm");
		this.hashFields.put("g_vvd", "gVvd");
		this.hashFields.put("eq_knd_nm", "eqKndNm");
		this.hashFields.put("if_curr_cd", "ifCurrCd");
		this.hashFields.put("estm_dtl_seq_no", "estmDtlSeqNo");
		this.hashFields.put("trd_party_val", "trdPartyVal");
		this.hashFields.put("n3pty_src_no", "n3ptySrcNo");
		this.hashFields.put("cfm_c", "cfmC");
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
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return gBkgNoAll
	 */
	public String getGBkgNoAll() {
		return this.gBkgNoAll;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
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
	 * @return ifOfcCd
	 */
	public String getIfOfcCd() {
		return this.ifOfcCd;
	}
	
	/**
	 * Column Info
	 * @return inOtsDtlSeq
	 */
	public String getInOtsDtlSeq() {
		return this.inOtsDtlSeq;
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
	 * @return currN3ptyNo
	 */
	public String getCurrN3ptyNo() {
		return this.currN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpNm
	 */
	public String getN3ptyBilTpNm() {
		return this.n3ptyBilTpNm;
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
	 * @return cfmD
	 */
	public String getCfmD() {
		return this.cfmD;
	}
	
	/**
	 * Column Info
	 * @return n3ptyOfcCd
	 */
	public String getN3ptyOfcCd() {
		return this.n3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return cfmI
	 */
	public String getCfmI() {
		return this.cfmI;
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
	 * @return cfmG
	 */
	public String getCfmG() {
		return this.cfmG;
	}
	
	/**
	 * Column Info
	 * @return ifUsrNm
	 */
	public String getIfUsrNm() {
		return this.ifUsrNm;
	}
	
	/**
	 * Column Info
	 * @return rvwOfcCd
	 */
	public String getRvwOfcCd() {
		return this.rvwOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return cfmR
	 */
	public String getCfmR() {
		return this.cfmR;
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
	 * @return n3ptyIfTpCd
	 */
	public String getN3ptyIfTpCd() {
		return this.n3ptyIfTpCd;
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
	 * @return sBlNoAll
	 */
	public String getSBlNoAll() {
		return this.sBlNoAll;
	}
	
	/**
	 * Column Info
	 * @return cfmN
	 */
	public String getCfmN() {
		return this.cfmN;
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
	 * @return estmRvisNo
	 */
	public String getEstmRvisNo() {
		return this.estmRvisNo;
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
	 * @return sCsrNo
	 */
	public String getSCsrNo() {
		return this.sCsrNo;
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
	 * @return n3ptyNonCfmRsnCd
	 */
	public String getN3ptyNonCfmRsnCd() {
		return this.n3ptyNonCfmRsnCd;
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
	 * @return checkFincDirCd
	 */
	public String getCheckFincDirCd() {
		return this.checkFincDirCd;
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
	 * @return costExptFlg
	 */
	public String getCostExptFlg() {
		return this.costExptFlg;
	}
	
	/**
	 * Column Info
	 * @return rvwUsrId
	 */
	public String getRvwUsrId() {
		return this.rvwUsrId;
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
	 * @return cfmAmt
	 */
	public String getCfmAmt() {
		return this.cfmAmt;
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
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return estmSeqNo
	 */
	public String getEstmSeqNo() {
		return this.estmSeqNo;
	}
	
	/**
	 * Column Info
	 * @return tesGubun
	 */
	public String getTesGubun() {
		return this.tesGubun;
	}
	
	/**
	 * Column Info
	 * @return srcVndrSeq
	 */
	public String getSrcVndrSeq() {
		return this.srcVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return gBlNoAll
	 */
	public String getGBlNoAll() {
		return this.gBlNoAll;
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
	 * @return trsGubun
	 */
	public String getTrsGubun() {
		return this.trsGubun;
	}
	
	/**
	 * Column Info
	 * @return ifRmkFlag
	 */
	public String getIfRmkFlag() {
		return this.ifRmkFlag;
	}
	
	/**
	 * Column Info
	 * @return sNr
	 */
	public String getSNr() {
		return this.sNr;
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
	 * @return estmSysAreaGrpId
	 */
	public String getEstmSysAreaGrpId() {
		return this.estmSysAreaGrpId;
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
	 * @return cfmRmk
	 */
	public String getCfmRmk() {
		return this.cfmRmk;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return sN3ptySrcSubSysCd
	 */
	public String getSN3ptySrcSubSysCd() {
		return this.sN3ptySrcSubSysCd;
	}
	
	/**
	 * Column Info
	 * @return cfm
	 */
	public String getCfm() {
		return this.cfm;
	}
	
	/**
	 * Column Info
	 * @return gVvd
	 */
	public String getGVvd() {
		return this.gVvd;
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
	 * @return ifCurrCd
	 */
	public String getIfCurrCd() {
		return this.ifCurrCd;
	}
	
	/**
	 * Column Info
	 * @return estmDtlSeqNo
	 */
	public String getEstmDtlSeqNo() {
		return this.estmDtlSeqNo;
	}
	
	/**
	 * Column Info
	 * @return trdPartyVal
	 */
	public String getTrdPartyVal() {
		return this.trdPartyVal;
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
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param gBkgNoAll
	 */
	public void setGBkgNoAll(String gBkgNoAll) {
		this.gBkgNoAll = gBkgNoAll;
	}
	
	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
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
	 * @param ifOfcCd
	 */
	public void setIfOfcCd(String ifOfcCd) {
		this.ifOfcCd = ifOfcCd;
	}
	
	/**
	 * Column Info
	 * @param inOtsDtlSeq
	 */
	public void setInOtsDtlSeq(String inOtsDtlSeq) {
		this.inOtsDtlSeq = inOtsDtlSeq;
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
	 * @param currN3ptyNo
	 */
	public void setCurrN3ptyNo(String currN3ptyNo) {
		this.currN3ptyNo = currN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpNm
	 */
	public void setN3ptyBilTpNm(String n3ptyBilTpNm) {
		this.n3ptyBilTpNm = n3ptyBilTpNm;
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
	 * @param cfmD
	 */
	public void setCfmD(String cfmD) {
		this.cfmD = cfmD;
	}
	
	/**
	 * Column Info
	 * @param n3ptyOfcCd
	 */
	public void setN3ptyOfcCd(String n3ptyOfcCd) {
		this.n3ptyOfcCd = n3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param cfmI
	 */
	public void setCfmI(String cfmI) {
		this.cfmI = cfmI;
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
	 * @param cfmG
	 */
	public void setCfmG(String cfmG) {
		this.cfmG = cfmG;
	}
	
	/**
	 * Column Info
	 * @param ifUsrNm
	 */
	public void setIfUsrNm(String ifUsrNm) {
		this.ifUsrNm = ifUsrNm;
	}
	
	/**
	 * Column Info
	 * @param rvwOfcCd
	 */
	public void setRvwOfcCd(String rvwOfcCd) {
		this.rvwOfcCd = rvwOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param cfmR
	 */
	public void setCfmR(String cfmR) {
		this.cfmR = cfmR;
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
	 * @param n3ptyIfTpCd
	 */
	public void setN3ptyIfTpCd(String n3ptyIfTpCd) {
		this.n3ptyIfTpCd = n3ptyIfTpCd;
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
	 * @param sBlNoAll
	 */
	public void setSBlNoAll(String sBlNoAll) {
		this.sBlNoAll = sBlNoAll;
	}
	
	/**
	 * Column Info
	 * @param cfmN
	 */
	public void setCfmN(String cfmN) {
		this.cfmN = cfmN;
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
	 * @param estmRvisNo
	 */
	public void setEstmRvisNo(String estmRvisNo) {
		this.estmRvisNo = estmRvisNo;
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
	 * @param sCsrNo
	 */
	public void setSCsrNo(String sCsrNo) {
		this.sCsrNo = sCsrNo;
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
	 * @param n3ptyNonCfmRsnCd
	 */
	public void setN3ptyNonCfmRsnCd(String n3ptyNonCfmRsnCd) {
		this.n3ptyNonCfmRsnCd = n3ptyNonCfmRsnCd;
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
	 * @param checkFincDirCd
	 */
	public void setCheckFincDirCd(String checkFincDirCd) {
		this.checkFincDirCd = checkFincDirCd;
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
	 * @param costExptFlg
	 */
	public void setCostExptFlg(String costExptFlg) {
		this.costExptFlg = costExptFlg;
	}
	
	/**
	 * Column Info
	 * @param rvwUsrId
	 */
	public void setRvwUsrId(String rvwUsrId) {
		this.rvwUsrId = rvwUsrId;
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
	 * @param cfmAmt
	 */
	public void setCfmAmt(String cfmAmt) {
		this.cfmAmt = cfmAmt;
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
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param estmSeqNo
	 */
	public void setEstmSeqNo(String estmSeqNo) {
		this.estmSeqNo = estmSeqNo;
	}
	
	/**
	 * Column Info
	 * @param tesGubun
	 */
	public void setTesGubun(String tesGubun) {
		this.tesGubun = tesGubun;
	}
	
	/**
	 * Column Info
	 * @param srcVndrSeq
	 */
	public void setSrcVndrSeq(String srcVndrSeq) {
		this.srcVndrSeq = srcVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param gBlNoAll
	 */
	public void setGBlNoAll(String gBlNoAll) {
		this.gBlNoAll = gBlNoAll;
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
	 * @param trsGubun
	 */
	public void setTrsGubun(String trsGubun) {
		this.trsGubun = trsGubun;
	}
	
	/**
	 * Column Info
	 * @param ifRmkFlag
	 */
	public void setIfRmkFlag(String ifRmkFlag) {
		this.ifRmkFlag = ifRmkFlag;
	}
	
	/**
	 * Column Info
	 * @param sNr
	 */
	public void setSNr(String sNr) {
		this.sNr = sNr;
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
	 * @param estmSysAreaGrpId
	 */
	public void setEstmSysAreaGrpId(String estmSysAreaGrpId) {
		this.estmSysAreaGrpId = estmSysAreaGrpId;
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
	 * @param cfmRmk
	 */
	public void setCfmRmk(String cfmRmk) {
		this.cfmRmk = cfmRmk;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param sN3ptySrcSubSysCd
	 */
	public void setSN3ptySrcSubSysCd(String sN3ptySrcSubSysCd) {
		this.sN3ptySrcSubSysCd = sN3ptySrcSubSysCd;
	}
	
	/**
	 * Column Info
	 * @param cfm
	 */
	public void setCfm(String cfm) {
		this.cfm = cfm;
	}
	
	/**
	 * Column Info
	 * @param gVvd
	 */
	public void setGVvd(String gVvd) {
		this.gVvd = gVvd;
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
	 * @param ifCurrCd
	 */
	public void setIfCurrCd(String ifCurrCd) {
		this.ifCurrCd = ifCurrCd;
	}
	
	/**
	 * Column Info
	 * @param estmDtlSeqNo
	 */
	public void setEstmDtlSeqNo(String estmDtlSeqNo) {
		this.estmDtlSeqNo = estmDtlSeqNo;
	}
	
	/**
	 * Column Info
	 * @param trdPartyVal
	 */
	public void setTrdPartyVal(String trdPartyVal) {
		this.trdPartyVal = trdPartyVal;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcNo
	 */
	public void setN3ptySrcNo(String n3ptySrcNo) {
		this.n3ptySrcNo = n3ptySrcNo;
	}
	
	public String getCfmC() {
		return cfmC;
	}

	public void setCfmC(String cfmC) {
		this.cfmC = cfmC;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIfDt(JSPUtil.getParameter(request, "if_dt", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setGBkgNoAll(JSPUtil.getParameter(request, "g_bkg_no_all", ""));
		setGlDt(JSPUtil.getParameter(request, "gl_dt", ""));
		setSBkgNoAll(JSPUtil.getParameter(request, "s_bkg_no_all", ""));
		setIfOfcCd(JSPUtil.getParameter(request, "if_ofc_cd", ""));
		setInOtsDtlSeq(JSPUtil.getParameter(request, "in_ots_dtl_seq", ""));
		setOtsDtlSeq(JSPUtil.getParameter(request, "ots_dtl_seq", ""));
		setCurrN3ptyNo(JSPUtil.getParameter(request, "curr_n3pty_no", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, "n3pty_bil_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCfmD(JSPUtil.getParameter(request, "cfm_d", ""));
		setN3ptyOfcCd(JSPUtil.getParameter(request, "n3pty_ofc_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setCfmI(JSPUtil.getParameter(request, "cfm_i", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setCfmG(JSPUtil.getParameter(request, "cfm_g", ""));
		setIfUsrNm(JSPUtil.getParameter(request, "if_usr_nm", ""));
		setRvwOfcCd(JSPUtil.getParameter(request, "rvw_ofc_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCfmR(JSPUtil.getParameter(request, "cfm_r", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setN3ptyIfTpCd(JSPUtil.getParameter(request, "n3pty_if_tp_cd", ""));
		setSN3ptySrcNo(JSPUtil.getParameter(request, "s_n3pty_src_no", ""));
		setSBlNoAll(JSPUtil.getParameter(request, "s_bl_no_all", ""));
		setCfmN(JSPUtil.getParameter(request, "cfm_n", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setEstmRvisNo(JSPUtil.getParameter(request, "estm_rvis_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setIfAmt(JSPUtil.getParameter(request, "if_amt", ""));
		setIfAmtUsd(JSPUtil.getParameter(request, "if_amt_usd", ""));
		setSCsrNo(JSPUtil.getParameter(request, "s_csr_no", ""));
		setN3ptySrcSubSysCd(JSPUtil.getParameter(request, "n3pty_src_sub_sys_cd", ""));
		setN3ptyNonCfmRsnCd(JSPUtil.getParameter(request, "n3pty_non_cfm_rsn_cd", ""));
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setCheckFincDirCd(JSPUtil.getParameter(request, "check_finc_dir_cd", ""));
		setSN3ptyBilTpCd(JSPUtil.getParameter(request, "s_n3pty_bil_tp_cd", ""));
		setCostExptFlg(JSPUtil.getParameter(request, "cost_expt_flg", ""));
		setRvwUsrId(JSPUtil.getParameter(request, "rvw_usr_id", ""));
		setVndrCustDivCd(JSPUtil.getParameter(request, "vndr_cust_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCfmAmt(JSPUtil.getParameter(request, "cfm_amt", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setEstmSeqNo(JSPUtil.getParameter(request, "estm_seq_no", ""));
		setTesGubun(JSPUtil.getParameter(request, "tes_gubun", ""));
		setSrcVndrSeq(JSPUtil.getParameter(request, "src_vndr_seq", ""));
		setGBlNoAll(JSPUtil.getParameter(request, "g_bl_no_all", ""));
		setIfUsrId(JSPUtil.getParameter(request, "if_usr_id", ""));
		setSEdate(JSPUtil.getParameter(request, "s_edate", ""));
		setTrsGubun(JSPUtil.getParameter(request, "trs_gubun", ""));
		setIfRmkFlag(JSPUtil.getParameter(request, "if_rmk_flag", ""));
		setSNr(JSPUtil.getParameter(request, "s_nr", ""));
		setSSdate(JSPUtil.getParameter(request, "s_sdate", ""));
		setEstmSysAreaGrpId(JSPUtil.getParameter(request, "estm_sys_area_grp_id", ""));
		setSVvd(JSPUtil.getParameter(request, "s_vvd", ""));
		setSIfOfcCd(JSPUtil.getParameter(request, "s_if_ofc_cd", ""));
		setCfmRmk(JSPUtil.getParameter(request, "cfm_rmk", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSN3ptySrcSubSysCd(JSPUtil.getParameter(request, "s_n3pty_src_sub_sys_cd", ""));
		setCfm(JSPUtil.getParameter(request, "cfm", ""));
		setGVvd(JSPUtil.getParameter(request, "g_vvd", ""));
		setEqKndNm(JSPUtil.getParameter(request, "eq_knd_nm", ""));
		setIfCurrCd(JSPUtil.getParameter(request, "if_curr_cd", ""));
		setEstmDtlSeqNo(JSPUtil.getParameter(request, "estm_dtl_seq_no", ""));
		setTrdPartyVal(JSPUtil.getParameter(request, "trd_party_val", ""));
		setN3ptySrcNo(JSPUtil.getParameter(request, "n3pty_src_no", ""));
		setCfmC(JSPUtil.getParameter(request, "cfm_c", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchJOCandidateConfirmListVO[]
	 */
	public SearchJOCandidateConfirmListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchJOCandidateConfirmListVO[]
	 */
	public SearchJOCandidateConfirmListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchJOCandidateConfirmListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] gBkgNoAll = (JSPUtil.getParameter(request, prefix	+ "g_bkg_no_all", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] sBkgNoAll = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no_all", length));
			String[] ifOfcCd = (JSPUtil.getParameter(request, prefix	+ "if_ofc_cd", length));
			String[] inOtsDtlSeq = (JSPUtil.getParameter(request, prefix	+ "in_ots_dtl_seq", length));
			String[] otsDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ots_dtl_seq", length));
			String[] currN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "curr_n3pty_no", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cfmD = (JSPUtil.getParameter(request, prefix	+ "cfm_d", length));
			String[] n3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ofc_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cfmI = (JSPUtil.getParameter(request, prefix	+ "cfm_i", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] cfmG = (JSPUtil.getParameter(request, prefix	+ "cfm_g", length));
			String[] ifUsrNm = (JSPUtil.getParameter(request, prefix	+ "if_usr_nm", length));
			String[] rvwOfcCd = (JSPUtil.getParameter(request, prefix	+ "rvw_ofc_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] cfmR = (JSPUtil.getParameter(request, prefix	+ "cfm_r", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] n3ptyIfTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_if_tp_cd", length));
			String[] sN3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_src_no", length));
			String[] sBlNoAll = (JSPUtil.getParameter(request, prefix	+ "s_bl_no_all", length));
			String[] cfmN = (JSPUtil.getParameter(request, prefix	+ "cfm_n", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] estmRvisNo = (JSPUtil.getParameter(request, prefix	+ "estm_rvis_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] ifAmtUsd = (JSPUtil.getParameter(request, prefix	+ "if_amt_usd", length));
			String[] sCsrNo = (JSPUtil.getParameter(request, prefix	+ "s_csr_no", length));
			String[] n3ptySrcSubSysCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_sub_sys_cd", length));
			String[] n3ptyNonCfmRsnCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_non_cfm_rsn_cd", length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] checkFincDirCd = (JSPUtil.getParameter(request, prefix	+ "check_finc_dir_cd", length));
			String[] sN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_bil_tp_cd", length));
			String[] costExptFlg = (JSPUtil.getParameter(request, prefix	+ "cost_expt_flg", length));
			String[] rvwUsrId = (JSPUtil.getParameter(request, prefix	+ "rvw_usr_id", length));
			String[] vndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_div_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cfmAmt = (JSPUtil.getParameter(request, prefix	+ "cfm_amt", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] estmSeqNo = (JSPUtil.getParameter(request, prefix	+ "estm_seq_no", length));
			String[] tesGubun = (JSPUtil.getParameter(request, prefix	+ "tes_gubun", length));
			String[] srcVndrSeq = (JSPUtil.getParameter(request, prefix	+ "src_vndr_seq", length));
			String[] gBlNoAll = (JSPUtil.getParameter(request, prefix	+ "g_bl_no_all", length));
			String[] ifUsrId = (JSPUtil.getParameter(request, prefix	+ "if_usr_id", length));
			String[] sEdate = (JSPUtil.getParameter(request, prefix	+ "s_edate", length));
			String[] trsGubun = (JSPUtil.getParameter(request, prefix	+ "trs_gubun", length));
			String[] ifRmkFlag = (JSPUtil.getParameter(request, prefix	+ "if_rmk_flag", length));
			String[] sNr = (JSPUtil.getParameter(request, prefix	+ "s_nr", length));
			String[] sSdate = (JSPUtil.getParameter(request, prefix	+ "s_sdate", length));
			String[] estmSysAreaGrpId = (JSPUtil.getParameter(request, prefix	+ "estm_sys_area_grp_id", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ofc_cd", length));
			String[] cfmRmk = (JSPUtil.getParameter(request, prefix	+ "cfm_rmk", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] sN3ptySrcSubSysCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_src_sub_sys_cd", length));
			String[] cfm = (JSPUtil.getParameter(request, prefix	+ "cfm", length));
			String[] gVvd = (JSPUtil.getParameter(request, prefix	+ "g_vvd", length));
			String[] eqKndNm = (JSPUtil.getParameter(request, prefix	+ "eq_knd_nm", length));
			String[] ifCurrCd = (JSPUtil.getParameter(request, prefix	+ "if_curr_cd", length));
			String[] estmDtlSeqNo = (JSPUtil.getParameter(request, prefix	+ "estm_dtl_seq_no", length));
			String[] trdPartyVal = (JSPUtil.getParameter(request, prefix	+ "trd_party_val", length));
			String[] n3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_no", length));
			String[] cfmC = (JSPUtil.getParameter(request, prefix	+ "cfm_c", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchJOCandidateConfirmListVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (gBkgNoAll[i] != null)
					model.setGBkgNoAll(gBkgNoAll[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (sBkgNoAll[i] != null)
					model.setSBkgNoAll(sBkgNoAll[i]);
				if (ifOfcCd[i] != null)
					model.setIfOfcCd(ifOfcCd[i]);
				if (inOtsDtlSeq[i] != null)
					model.setInOtsDtlSeq(inOtsDtlSeq[i]);
				if (otsDtlSeq[i] != null)
					model.setOtsDtlSeq(otsDtlSeq[i]);
				if (currN3ptyNo[i] != null)
					model.setCurrN3ptyNo(currN3ptyNo[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cfmD[i] != null)
					model.setCfmD(cfmD[i]);
				if (n3ptyOfcCd[i] != null)
					model.setN3ptyOfcCd(n3ptyOfcCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cfmI[i] != null)
					model.setCfmI(cfmI[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (cfmG[i] != null)
					model.setCfmG(cfmG[i]);
				if (ifUsrNm[i] != null)
					model.setIfUsrNm(ifUsrNm[i]);
				if (rvwOfcCd[i] != null)
					model.setRvwOfcCd(rvwOfcCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (cfmR[i] != null)
					model.setCfmR(cfmR[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (n3ptyIfTpCd[i] != null)
					model.setN3ptyIfTpCd(n3ptyIfTpCd[i]);
				if (sN3ptySrcNo[i] != null)
					model.setSN3ptySrcNo(sN3ptySrcNo[i]);
				if (sBlNoAll[i] != null)
					model.setSBlNoAll(sBlNoAll[i]);
				if (cfmN[i] != null)
					model.setCfmN(cfmN[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (estmRvisNo[i] != null)
					model.setEstmRvisNo(estmRvisNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (ifAmtUsd[i] != null)
					model.setIfAmtUsd(ifAmtUsd[i]);
				if (sCsrNo[i] != null)
					model.setSCsrNo(sCsrNo[i]);
				if (n3ptySrcSubSysCd[i] != null)
					model.setN3ptySrcSubSysCd(n3ptySrcSubSysCd[i]);
				if (n3ptyNonCfmRsnCd[i] != null)
					model.setN3ptyNonCfmRsnCd(n3ptyNonCfmRsnCd[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (checkFincDirCd[i] != null)
					model.setCheckFincDirCd(checkFincDirCd[i]);
				if (sN3ptyBilTpCd[i] != null)
					model.setSN3ptyBilTpCd(sN3ptyBilTpCd[i]);
				if (costExptFlg[i] != null)
					model.setCostExptFlg(costExptFlg[i]);
				if (rvwUsrId[i] != null)
					model.setRvwUsrId(rvwUsrId[i]);
				if (vndrCustDivCd[i] != null)
					model.setVndrCustDivCd(vndrCustDivCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cfmAmt[i] != null)
					model.setCfmAmt(cfmAmt[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (estmSeqNo[i] != null)
					model.setEstmSeqNo(estmSeqNo[i]);
				if (tesGubun[i] != null)
					model.setTesGubun(tesGubun[i]);
				if (srcVndrSeq[i] != null)
					model.setSrcVndrSeq(srcVndrSeq[i]);
				if (gBlNoAll[i] != null)
					model.setGBlNoAll(gBlNoAll[i]);
				if (ifUsrId[i] != null)
					model.setIfUsrId(ifUsrId[i]);
				if (sEdate[i] != null)
					model.setSEdate(sEdate[i]);
				if (trsGubun[i] != null)
					model.setTrsGubun(trsGubun[i]);
				if (ifRmkFlag[i] != null)
					model.setIfRmkFlag(ifRmkFlag[i]);
				if (sNr[i] != null)
					model.setSNr(sNr[i]);
				if (sSdate[i] != null)
					model.setSSdate(sSdate[i]);
				if (estmSysAreaGrpId[i] != null)
					model.setEstmSysAreaGrpId(estmSysAreaGrpId[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (sIfOfcCd[i] != null)
					model.setSIfOfcCd(sIfOfcCd[i]);
				if (cfmRmk[i] != null)
					model.setCfmRmk(cfmRmk[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (sN3ptySrcSubSysCd[i] != null)
					model.setSN3ptySrcSubSysCd(sN3ptySrcSubSysCd[i]);
				if (cfm[i] != null)
					model.setCfm(cfm[i]);
				if (gVvd[i] != null)
					model.setGVvd(gVvd[i]);
				if (eqKndNm[i] != null)
					model.setEqKndNm(eqKndNm[i]);
				if (ifCurrCd[i] != null)
					model.setIfCurrCd(ifCurrCd[i]);
				if (estmDtlSeqNo[i] != null)
					model.setEstmDtlSeqNo(estmDtlSeqNo[i]);
				if (trdPartyVal[i] != null)
					model.setTrdPartyVal(trdPartyVal[i]);
				if (n3ptySrcNo[i] != null)
					model.setN3ptySrcNo(n3ptySrcNo[i]);
				if (cfmC[i] != null)
					model.setCfmC(cfmC[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchJOCandidateConfirmListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchJOCandidateConfirmListVO[]
	 */
	public SearchJOCandidateConfirmListVO[] getSearchJOCandidateConfirmListVOs(){
		SearchJOCandidateConfirmListVO[] vos = (SearchJOCandidateConfirmListVO[])models.toArray(new SearchJOCandidateConfirmListVO[models.size()]);
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
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gBkgNoAll = this.gBkgNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNoAll = this.sBkgNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOfcCd = this.ifOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inOtsDtlSeq = this.inOtsDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDtlSeq = this.otsDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currN3ptyNo = this.currN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmD = this.cfmD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyOfcCd = this.n3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmI = this.cfmI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmG = this.cfmG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifUsrNm = this.ifUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvwOfcCd = this.rvwOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmR = this.cfmR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyIfTpCd = this.n3ptyIfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptySrcNo = this.sN3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBlNoAll = this.sBlNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmN = this.cfmN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmRvisNo = this.estmRvisNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmtUsd = this.ifAmtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCsrNo = this.sCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcSubSysCd = this.n3ptySrcSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNonCfmRsnCd = this.n3ptyNonCfmRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkFincDirCd = this.checkFincDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyBilTpCd = this.sN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costExptFlg = this.costExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvwUsrId = this.rvwUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustDivCd = this.vndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmAmt = this.cfmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSeqNo = this.estmSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tesGubun = this.tesGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcVndrSeq = this.srcVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gBlNoAll = this.gBlNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifUsrId = this.ifUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdate = this.sEdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsGubun = this.trsGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRmkFlag = this.ifRmkFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNr = this.sNr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSdate = this.sSdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSysAreaGrpId = this.estmSysAreaGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfOfcCd = this.sIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmRmk = this.cfmRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptySrcSubSysCd = this.sN3ptySrcSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfm = this.cfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gVvd = this.gVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndNm = this.eqKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifCurrCd = this.ifCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmDtlSeqNo = this.estmDtlSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyVal = this.trdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNo = this.n3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmC = this.cfmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
