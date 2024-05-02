/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCandidateListVO.java
*@FileTitle : SearchCandidateListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.11.17 박성진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCandidateListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCandidateListVO> models = new ArrayList<SearchCandidateListVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String sSkdVoyNo = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String gBkgNoAll = null;
	/* Column Info */
	private String sBkgNoAll = null;
	/* Column Info */
	private String ifOfcCd = null;
	/* Column Info */
	private String inOtsDtlSeq = null;
	/* Column Info */
	private String sTrdPartyVal = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String estmSvrId = null;
	/* Column Info */
	private String otsDtlSeq = null;
	/* Column Info */
	private String currN3ptyNo = null;
	/* Column Info */
	private String n3ptyBilTpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3ptyOfcCd = null;
	/* Column Info */
	private String cfmD = null;
	/* Column Info */
	private String sBlNo = null;
	/* Column Info */
	private String sN3ptyNoStrsLink = null;
	/* Column Info */
	private String cfmI = null;
	/* Column Info */
	private String cfmG = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String ifUsrNm = null;
	/* Column Info */
	private String sOfcTopLvl = null;
	/* Column Info */
	private String userName = null;
	/* Column Info */
	private String rvwOfcCd = null;
	/* Column Info */
	private String sOfficeLevel = null;
	/* Column Info */
	private String updUsrId = null;
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
	private String sVndrCustDivCd = null;
	/* Column Info */
	private String cfmN = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sCfmStatus = null;
	/* Column Info */
	private String estmRvisNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String ifAmtUsd = null;
	/* Column Info */
	private String sIfRhqCd = null;
	/* Column Info */
	private String sCsrNo = null;
	/* Column Info */
	private String sEqKndCd = null;
	/* Column Info */
	private String n3ptySrcSubSysCd = null;
	/* Column Info */
	private String n3ptyNonCfmRsnCd = null;
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String checkFincDirCd = null;
	/* Column Info */
	private String sVslCd = null;
	/* Column Info */
	private String sN3ptyBilTpCd = null;
	/* Column Info */
	private String sBkgNo = null;
	/* Column Info */
	private String costExptFlg = null;
	/* Column Info */
	private String userEmail = null;
	/* Column Info */
	private String rvwUsrId = null;
	/* Column Info */
	private String sIfCtrlCd = null;
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
	private String ifUsrId = null;
	/* Column Info */
	private String gBlNoAll = null;
	/* Column Info */
	private String trsGubun = null;
	/* Column Info */
	private String sEdate = null;
	/* Column Info */
	private String ifRmk = null;
	/* Column Info */
	private String sNr = null;
	/* Column Info */
	private String sSdate = null;
	/* Column Info */
	private String sIfOfcCd = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cfmRmk = null;
	/* Column Info */
	private String sSkdDirCd = null;
	/* Column Info */
	private String sOfcCdForRhq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String sRhqCdForRhq = null;
	/* Column Info */
	private String sN3ptySrcSubSysCd = null;
	/* Column Info */
	private String sEqNo = null;
	/* Column Info */
	private String cfm = null;
	/* Column Info */
	private String gVvd = null;
	/* Column Info */
	private String eqKndNm = null;
	/* Column Info */
	private String estmDtlSeqNo = null;
	/* Column Info */
	private String ifCurrCd = null;
	/* Column Info */
	private String eqKndCd = null;
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
	
	public SearchCandidateListVO() {}

	public SearchCandidateListVO(String ibflag, String pagerows, String ifDt, String sSkdVoyNo, String vndrCntCd, String gBkgNoAll, String sBkgNoAll, String ifOfcCd, String inOtsDtlSeq, String sTrdPartyVal, String fCmd, String estmSvrId, String otsDtlSeq, String currN3ptyNo, String n3ptyBilTpNm, String cfmD, String n3ptyOfcCd, String sN3ptyNoStrsLink, String sBlNo, String cfmI, String userId, String cfmG, String ifUsrNm, String userName, String sOfcTopLvl, String rvwOfcCd, String sOfficeLevel, String updUsrId, String custCntCd, String cfmR, String csrNo, String n3ptyIfTpCd, String sN3ptySrcNo, String sBlNoAll, String sVndrCustDivCd, String cfmN, String eqTpszCd, String creUsrId, String sCfmStatus, String estmRvisNo, String vndrSeq, String ifAmt, String ifAmtUsd, String sIfRhqCd, String sCsrNo, String sEqKndCd, String n3ptySrcSubSysCd, String n3ptyNonCfmRsnCd, String userOfcCd, String checkFincDirCd, String sN3ptyBilTpCd, String sVslCd, String sBkgNo, String costExptFlg, String userEmail, String sIfCtrlCd, String rvwUsrId, String vndrCustDivCd, String eqNo, String cfmAmt, String n3ptyNo, String estmSeqNo, String tesGubun, String srcVndrSeq, String gBlNoAll, String ifUsrId, String sEdate, String trsGubun, String ifRmk, String sNr, String sSdate, String sVvd, String sIfOfcCd, String sSkdDirCd, String cfmRmk, String custSeq, String sOfcCdForRhq, String ofcCd, String sN3ptySrcSubSysCd, String sRhqCdForRhq, String sEqNo, String cfm, String gVvd, String eqKndNm, String ifCurrCd, String estmDtlSeqNo, String trdPartyVal, String n3ptySrcNo, String eqKndCd, String cfmC) {
		this.ifDt = ifDt;
		this.sSkdVoyNo = sSkdVoyNo;
		this.vndrCntCd = vndrCntCd;
		this.gBkgNoAll = gBkgNoAll;
		this.sBkgNoAll = sBkgNoAll;
		this.ifOfcCd = ifOfcCd;
		this.inOtsDtlSeq = inOtsDtlSeq;
		this.sTrdPartyVal = sTrdPartyVal;
		this.fCmd = fCmd;
		this.estmSvrId = estmSvrId;
		this.otsDtlSeq = otsDtlSeq;
		this.currN3ptyNo = currN3ptyNo;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.pagerows = pagerows;
		this.n3ptyOfcCd = n3ptyOfcCd;
		this.cfmD = cfmD;
		this.sBlNo = sBlNo;
		this.sN3ptyNoStrsLink = sN3ptyNoStrsLink;
		this.cfmI = cfmI;
		this.cfmG = cfmG;
		this.userId = userId;
		this.ifUsrNm = ifUsrNm;
		this.sOfcTopLvl = sOfcTopLvl;
		this.userName = userName;
		this.rvwOfcCd = rvwOfcCd;
		this.sOfficeLevel = sOfficeLevel;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.cfmR = cfmR;
		this.csrNo = csrNo;
		this.n3ptyIfTpCd = n3ptyIfTpCd;
		this.sN3ptySrcNo = sN3ptySrcNo;
		this.sBlNoAll = sBlNoAll;
		this.sVndrCustDivCd = sVndrCustDivCd;
		this.cfmN = cfmN;
		this.eqTpszCd = eqTpszCd;
		this.creUsrId = creUsrId;
		this.sCfmStatus = sCfmStatus;
		this.estmRvisNo = estmRvisNo;
		this.vndrSeq = vndrSeq;
		this.ifAmt = ifAmt;
		this.ifAmtUsd = ifAmtUsd;
		this.sIfRhqCd = sIfRhqCd;
		this.sCsrNo = sCsrNo;
		this.sEqKndCd = sEqKndCd;
		this.n3ptySrcSubSysCd = n3ptySrcSubSysCd;
		this.n3ptyNonCfmRsnCd = n3ptyNonCfmRsnCd;
		this.userOfcCd = userOfcCd;
		this.checkFincDirCd = checkFincDirCd;
		this.sVslCd = sVslCd;
		this.sN3ptyBilTpCd = sN3ptyBilTpCd;
		this.sBkgNo = sBkgNo;
		this.costExptFlg = costExptFlg;
		this.userEmail = userEmail;
		this.rvwUsrId = rvwUsrId;
		this.sIfCtrlCd = sIfCtrlCd;
		this.vndrCustDivCd = vndrCustDivCd;
		this.ibflag = ibflag;
		this.cfmAmt = cfmAmt;
		this.eqNo = eqNo;
		this.n3ptyNo = n3ptyNo;
		this.estmSeqNo = estmSeqNo;
		this.tesGubun = tesGubun;
		this.srcVndrSeq = srcVndrSeq;
		this.ifUsrId = ifUsrId;
		this.gBlNoAll = gBlNoAll;
		this.trsGubun = trsGubun;
		this.sEdate = sEdate;
		this.ifRmk = ifRmk;
		this.sNr = sNr;
		this.sSdate = sSdate;
		this.sIfOfcCd = sIfOfcCd;
		this.sVvd = sVvd;
		this.custSeq = custSeq;
		this.cfmRmk = cfmRmk;
		this.sSkdDirCd = sSkdDirCd;
		this.sOfcCdForRhq = sOfcCdForRhq;
		this.ofcCd = ofcCd;
		this.sRhqCdForRhq = sRhqCdForRhq;
		this.sN3ptySrcSubSysCd = sN3ptySrcSubSysCd;
		this.sEqNo = sEqNo;
		this.cfm = cfm;
		this.gVvd = gVvd;
		this.eqKndNm = eqKndNm;
		this.estmDtlSeqNo = estmDtlSeqNo;
		this.ifCurrCd = ifCurrCd;
		this.eqKndCd = eqKndCd;
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
		this.hashColumns.put("s_skd_voy_no", getSSkdVoyNo());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("g_bkg_no_all", getGBkgNoAll());
		this.hashColumns.put("s_bkg_no_all", getSBkgNoAll());
		this.hashColumns.put("if_ofc_cd", getIfOfcCd());
		this.hashColumns.put("in_ots_dtl_seq", getInOtsDtlSeq());
		this.hashColumns.put("s_trd_party_val", getSTrdPartyVal());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("estm_svr_id", getEstmSvrId());
		this.hashColumns.put("ots_dtl_seq", getOtsDtlSeq());
		this.hashColumns.put("curr_n3pty_no", getCurrN3ptyNo());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3pty_ofc_cd", getN3ptyOfcCd());
		this.hashColumns.put("cfm_d", getCfmD());
		this.hashColumns.put("s_bl_no", getSBlNo());
		this.hashColumns.put("s_n3pty_no_strs_link", getSN3ptyNoStrsLink());
		this.hashColumns.put("cfm_i", getCfmI());
		this.hashColumns.put("cfm_g", getCfmG());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("if_usr_nm", getIfUsrNm());
		this.hashColumns.put("s_ofc_top_lvl", getSOfcTopLvl());
		this.hashColumns.put("user_name", getUserName());
		this.hashColumns.put("rvw_ofc_cd", getRvwOfcCd());
		this.hashColumns.put("s_office_level", getSOfficeLevel());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cfm_r", getCfmR());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("n3pty_if_tp_cd", getN3ptyIfTpCd());
		this.hashColumns.put("s_n3pty_src_no", getSN3ptySrcNo());
		this.hashColumns.put("s_bl_no_all", getSBlNoAll());
		this.hashColumns.put("s_vndr_cust_div_cd", getSVndrCustDivCd());
		this.hashColumns.put("cfm_n", getCfmN());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("s_cfm_status", getSCfmStatus());
		this.hashColumns.put("estm_rvis_no", getEstmRvisNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("if_amt_usd", getIfAmtUsd());
		this.hashColumns.put("s_if_rhq_cd", getSIfRhqCd());
		this.hashColumns.put("s_csr_no", getSCsrNo());
		this.hashColumns.put("s_eq_knd_cd", getSEqKndCd());
		this.hashColumns.put("n3pty_src_sub_sys_cd", getN3ptySrcSubSysCd());
		this.hashColumns.put("n3pty_non_cfm_rsn_cd", getN3ptyNonCfmRsnCd());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("check_finc_dir_cd", getCheckFincDirCd());
		this.hashColumns.put("s_vsl_cd", getSVslCd());
		this.hashColumns.put("s_n3pty_bil_tp_cd", getSN3ptyBilTpCd());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("cost_expt_flg", getCostExptFlg());
		this.hashColumns.put("user_email", getUserEmail());
		this.hashColumns.put("rvw_usr_id", getRvwUsrId());
		this.hashColumns.put("s_if_ctrl_cd", getSIfCtrlCd());
		this.hashColumns.put("vndr_cust_div_cd", getVndrCustDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cfm_amt", getCfmAmt());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("estm_seq_no", getEstmSeqNo());
		this.hashColumns.put("tes_gubun", getTesGubun());
		this.hashColumns.put("src_vndr_seq", getSrcVndrSeq());
		this.hashColumns.put("if_usr_id", getIfUsrId());
		this.hashColumns.put("g_bl_no_all", getGBlNoAll());
		this.hashColumns.put("trs_gubun", getTrsGubun());
		this.hashColumns.put("s_edate", getSEdate());
		this.hashColumns.put("if_rmk", getifRmk());
		this.hashColumns.put("s_nr", getSNr());
		this.hashColumns.put("s_sdate", getSSdate());
		this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cfm_rmk", getCfmRmk());
		this.hashColumns.put("s_skd_dir_cd", getSSkdDirCd());
		this.hashColumns.put("s_ofc_cd_for_rhq", getSOfcCdForRhq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("s_rhq_cd_for_rhq", getSRhqCdForRhq());
		this.hashColumns.put("s_n3pty_src_sub_sys_cd", getSN3ptySrcSubSysCd());
		this.hashColumns.put("s_eq_no", getSEqNo());
		this.hashColumns.put("cfm", getCfm());
		this.hashColumns.put("g_vvd", getGVvd());
		this.hashColumns.put("eq_knd_nm", getEqKndNm());
		this.hashColumns.put("estm_dtl_seq_no", getEstmDtlSeqNo());
		this.hashColumns.put("if_curr_cd", getIfCurrCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
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
		this.hashFields.put("s_skd_voy_no", "sSkdVoyNo");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("g_bkg_no_all", "gBkgNoAll");
		this.hashFields.put("s_bkg_no_all", "sBkgNoAll");
		this.hashFields.put("if_ofc_cd", "ifOfcCd");
		this.hashFields.put("in_ots_dtl_seq", "inOtsDtlSeq");
		this.hashFields.put("s_trd_party_val", "sTrdPartyVal");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("estm_svr_id", "estmSvrId");
		this.hashFields.put("ots_dtl_seq", "otsDtlSeq");
		this.hashFields.put("curr_n3pty_no", "currN3ptyNo");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3pty_ofc_cd", "n3ptyOfcCd");
		this.hashFields.put("cfm_d", "cfmD");
		this.hashFields.put("s_bl_no", "sBlNo");
		this.hashFields.put("s_n3pty_no_strs_link", "sN3ptyNoStrsLink");
		this.hashFields.put("cfm_i", "cfmI");
		this.hashFields.put("cfm_g", "cfmG");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("if_usr_nm", "ifUsrNm");
		this.hashFields.put("s_ofc_top_lvl", "sOfcTopLvl");
		this.hashFields.put("user_name", "userName");
		this.hashFields.put("rvw_ofc_cd", "rvwOfcCd");
		this.hashFields.put("s_office_level", "sOfficeLevel");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cfm_r", "cfmR");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("n3pty_if_tp_cd", "n3ptyIfTpCd");
		this.hashFields.put("s_n3pty_src_no", "sN3ptySrcNo");
		this.hashFields.put("s_bl_no_all", "sBlNoAll");
		this.hashFields.put("s_vndr_cust_div_cd", "sVndrCustDivCd");
		this.hashFields.put("cfm_n", "cfmN");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("s_cfm_status", "sCfmStatus");
		this.hashFields.put("estm_rvis_no", "estmRvisNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("if_amt_usd", "ifAmtUsd");
		this.hashFields.put("s_if_rhq_cd", "sIfRhqCd");
		this.hashFields.put("s_csr_no", "sCsrNo");
		this.hashFields.put("s_eq_knd_cd", "sEqKndCd");
		this.hashFields.put("n3pty_src_sub_sys_cd", "n3ptySrcSubSysCd");
		this.hashFields.put("n3pty_non_cfm_rsn_cd", "n3ptyNonCfmRsnCd");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("check_finc_dir_cd", "checkFincDirCd");
		this.hashFields.put("s_vsl_cd", "sVslCd");
		this.hashFields.put("s_n3pty_bil_tp_cd", "sN3ptyBilTpCd");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("cost_expt_flg", "costExptFlg");
		this.hashFields.put("user_email", "userEmail");
		this.hashFields.put("rvw_usr_id", "rvwUsrId");
		this.hashFields.put("s_if_ctrl_cd", "sIfCtrlCd");
		this.hashFields.put("vndr_cust_div_cd", "vndrCustDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cfm_amt", "cfmAmt");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("estm_seq_no", "estmSeqNo");
		this.hashFields.put("tes_gubun", "tesGubun");
		this.hashFields.put("src_vndr_seq", "srcVndrSeq");
		this.hashFields.put("if_usr_id", "ifUsrId");
		this.hashFields.put("g_bl_no_all", "gBlNoAll");
		this.hashFields.put("trs_gubun", "trsGubun");
		this.hashFields.put("s_edate", "sEdate");
		this.hashFields.put("if_rmk", "ifRmk");
		this.hashFields.put("s_nr", "sNr");
		this.hashFields.put("s_sdate", "sSdate");
		this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cfm_rmk", "cfmRmk");
		this.hashFields.put("s_skd_dir_cd", "sSkdDirCd");
		this.hashFields.put("s_ofc_cd_for_rhq", "sOfcCdForRhq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("s_rhq_cd_for_rhq", "sRhqCdForRhq");
		this.hashFields.put("s_n3pty_src_sub_sys_cd", "sN3ptySrcSubSysCd");
		this.hashFields.put("s_eq_no", "sEqNo");
		this.hashFields.put("cfm", "cfm");
		this.hashFields.put("g_vvd", "gVvd");
		this.hashFields.put("eq_knd_nm", "eqKndNm");
		this.hashFields.put("estm_dtl_seq_no", "estmDtlSeqNo");
		this.hashFields.put("if_curr_cd", "ifCurrCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
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
	 * @return sSkdVoyNo
	 */
	public String getSSkdVoyNo() {
		return this.sSkdVoyNo;
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
	 * @return sTrdPartyVal
	 */
	public String getSTrdPartyVal() {
		return this.sTrdPartyVal;
	}
	
	/**
	 * Column Info
	 * @return fCmd
	 */
	public String getFCmd() {
		return this.fCmd;
	}
	
	/**
	 * Column Info
	 * @return estmSvrId
	 */
	public String getEstmSvrId() {
		return this.estmSvrId;
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
	 * @return n3ptyOfcCd
	 */
	public String getN3ptyOfcCd() {
		return this.n3ptyOfcCd;
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
	 * @return sBlNo
	 */
	public String getSBlNo() {
		return this.sBlNo;
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
	 * @return cfmI
	 */
	public String getCfmI() {
		return this.cfmI;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
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
	 * @return sOfcTopLvl
	 */
	public String getSOfcTopLvl() {
		return this.sOfcTopLvl;
	}
	
	/**
	 * Column Info
	 * @return userName
	 */
	public String getUserName() {
		return this.userName;
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
	 * @return sOfficeLevel
	 */
	public String getSOfficeLevel() {
		return this.sOfficeLevel;
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
	 * @return sVndrCustDivCd
	 */
	public String getSVndrCustDivCd() {
		return this.sVndrCustDivCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return sCfmStatus
	 */
	public String getSCfmStatus() {
		return this.sCfmStatus;
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
	 * @return sIfRhqCd
	 */
	public String getSIfRhqCd() {
		return this.sIfRhqCd;
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
	 * @return sEqKndCd
	 */
	public String getSEqKndCd() {
		return this.sEqKndCd;
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
	 * @return sVslCd
	 */
	public String getSVslCd() {
		return this.sVslCd;
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
	 * @return sBkgNo
	 */
	public String getSBkgNo() {
		return this.sBkgNo;
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
	 * @return userEmail
	 */
	public String getUserEmail() {
		return this.userEmail;
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
	 * @return sIfCtrlCd
	 */
	public String getSIfCtrlCd() {
		return this.sIfCtrlCd;
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
	 * @return ifUsrId
	 */
	public String getIfUsrId() {
		return this.ifUsrId;
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
	 * @return trsGubun
	 */
	public String getTrsGubun() {
		return this.trsGubun;
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
	 * @return ifRmk
	 */
	public String getifRmk() {
		return this.ifRmk;
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
	 * @return sIfOfcCd
	 */
	public String getSIfOfcCd() {
		return this.sIfOfcCd;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return sSkdDirCd
	 */
	public String getSSkdDirCd() {
		return this.sSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCdForRhq
	 */
	public String getSOfcCdForRhq() {
		return this.sOfcCdForRhq;
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
	 * @return sRhqCdForRhq
	 */
	public String getSRhqCdForRhq() {
		return this.sRhqCdForRhq;
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
	 * @return estmDtlSeqNo
	 */
	public String getEstmDtlSeqNo() {
		return this.estmDtlSeqNo;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @param sSkdVoyNo
	 */
	public void setSSkdVoyNo(String sSkdVoyNo) {
		this.sSkdVoyNo = sSkdVoyNo;
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
	 * @param sTrdPartyVal
	 */
	public void setSTrdPartyVal(String sTrdPartyVal) {
		this.sTrdPartyVal = sTrdPartyVal;
	}
	
	/**
	 * Column Info
	 * @param fCmd
	 */
	public void setFCmd(String fCmd) {
		this.fCmd = fCmd;
	}
	
	/**
	 * Column Info
	 * @param estmSvrId
	 */
	public void setEstmSvrId(String estmSvrId) {
		this.estmSvrId = estmSvrId;
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
	 * @param n3ptyOfcCd
	 */
	public void setN3ptyOfcCd(String n3ptyOfcCd) {
		this.n3ptyOfcCd = n3ptyOfcCd;
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
	 * @param sBlNo
	 */
	public void setSBlNo(String sBlNo) {
		this.sBlNo = sBlNo;
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
	 * @param cfmI
	 */
	public void setCfmI(String cfmI) {
		this.cfmI = cfmI;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @param sOfcTopLvl
	 */
	public void setSOfcTopLvl(String sOfcTopLvl) {
		this.sOfcTopLvl = sOfcTopLvl;
	}
	
	/**
	 * Column Info
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @param sOfficeLevel
	 */
	public void setSOfficeLevel(String sOfficeLevel) {
		this.sOfficeLevel = sOfficeLevel;
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
	 * @param sVndrCustDivCd
	 */
	public void setSVndrCustDivCd(String sVndrCustDivCd) {
		this.sVndrCustDivCd = sVndrCustDivCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param sCfmStatus
	 */
	public void setSCfmStatus(String sCfmStatus) {
		this.sCfmStatus = sCfmStatus;
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
	 * @param sIfRhqCd
	 */
	public void setSIfRhqCd(String sIfRhqCd) {
		this.sIfRhqCd = sIfRhqCd;
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
	 * @param sEqKndCd
	 */
	public void setSEqKndCd(String sEqKndCd) {
		this.sEqKndCd = sEqKndCd;
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
	 * @param sVslCd
	 */
	public void setSVslCd(String sVslCd) {
		this.sVslCd = sVslCd;
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
	 * @param sBkgNo
	 */
	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
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
	 * @param userEmail
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	 * @param sIfCtrlCd
	 */
	public void setSIfCtrlCd(String sIfCtrlCd) {
		this.sIfCtrlCd = sIfCtrlCd;
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
	 * @param ifUsrId
	 */
	public void setIfUsrId(String ifUsrId) {
		this.ifUsrId = ifUsrId;
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
	 * @param trsGubun
	 */
	public void setTrsGubun(String trsGubun) {
		this.trsGubun = trsGubun;
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
	 * @param ifRmk
	 */
	public void setifRmk(String ifRmk) {
		this.ifRmk = ifRmk;
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
	 * @param sIfOfcCd
	 */
	public void setSIfOfcCd(String sIfOfcCd) {
		this.sIfOfcCd = sIfOfcCd;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param sSkdDirCd
	 */
	public void setSSkdDirCd(String sSkdDirCd) {
		this.sSkdDirCd = sSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCdForRhq
	 */
	public void setSOfcCdForRhq(String sOfcCdForRhq) {
		this.sOfcCdForRhq = sOfcCdForRhq;
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
	 * @param sRhqCdForRhq
	 */
	public void setSRhqCdForRhq(String sRhqCdForRhq) {
		this.sRhqCdForRhq = sRhqCdForRhq;
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
	 * @param estmDtlSeqNo
	 */
	public void setEstmDtlSeqNo(String estmDtlSeqNo) {
		this.estmDtlSeqNo = estmDtlSeqNo;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
		setSSkdVoyNo(JSPUtil.getParameter(request, "s_skd_voy_no", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setGBkgNoAll(JSPUtil.getParameter(request, "g_bkg_no_all", ""));
		setSBkgNoAll(JSPUtil.getParameter(request, "s_bkg_no_all", ""));
		setIfOfcCd(JSPUtil.getParameter(request, "if_ofc_cd", ""));
		setInOtsDtlSeq(JSPUtil.getParameter(request, "in_ots_dtl_seq", ""));
		setSTrdPartyVal(JSPUtil.getParameter(request, "s_trd_party_val", ""));
		setFCmd(JSPUtil.getParameter(request, "f_cmd", ""));
		setEstmSvrId(JSPUtil.getParameter(request, "estm_svr_id", ""));
		setOtsDtlSeq(JSPUtil.getParameter(request, "ots_dtl_seq", ""));
		setCurrN3ptyNo(JSPUtil.getParameter(request, "curr_n3pty_no", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, "n3pty_bil_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setN3ptyOfcCd(JSPUtil.getParameter(request, "n3pty_ofc_cd", ""));
		setCfmD(JSPUtil.getParameter(request, "cfm_d", ""));
		setSBlNo(JSPUtil.getParameter(request, "s_bl_no", ""));
		setSN3ptyNoStrsLink(JSPUtil.getParameter(request, "s_n3pty_no_strs_link", ""));
		setCfmI(JSPUtil.getParameter(request, "cfm_i", ""));
		setCfmG(JSPUtil.getParameter(request, "cfm_g", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setIfUsrNm(JSPUtil.getParameter(request, "if_usr_nm", ""));
		setSOfcTopLvl(JSPUtil.getParameter(request, "s_ofc_top_lvl", ""));
		setUserName(JSPUtil.getParameter(request, "user_name", ""));
		setRvwOfcCd(JSPUtil.getParameter(request, "rvw_ofc_cd", ""));
		setSOfficeLevel(JSPUtil.getParameter(request, "s_office_level", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCfmR(JSPUtil.getParameter(request, "cfm_r", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setN3ptyIfTpCd(JSPUtil.getParameter(request, "n3pty_if_tp_cd", ""));
		setSN3ptySrcNo(JSPUtil.getParameter(request, "s_n3pty_src_no", ""));
		setSBlNoAll(JSPUtil.getParameter(request, "s_bl_no_all", ""));
		setSVndrCustDivCd(JSPUtil.getParameter(request, "s_vndr_cust_div_cd", ""));
		setCfmN(JSPUtil.getParameter(request, "cfm_n", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSCfmStatus(JSPUtil.getParameter(request, "s_cfm_status", ""));
		setEstmRvisNo(JSPUtil.getParameter(request, "estm_rvis_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setIfAmt(JSPUtil.getParameter(request, "if_amt", ""));
		setIfAmtUsd(JSPUtil.getParameter(request, "if_amt_usd", ""));
		setSIfRhqCd(JSPUtil.getParameter(request, "s_if_rhq_cd", ""));
		setSCsrNo(JSPUtil.getParameter(request, "s_csr_no", ""));
		setSEqKndCd(JSPUtil.getParameter(request, "s_eq_knd_cd", ""));
		setN3ptySrcSubSysCd(JSPUtil.getParameter(request, "n3pty_src_sub_sys_cd", ""));
		setN3ptyNonCfmRsnCd(JSPUtil.getParameter(request, "n3pty_non_cfm_rsn_cd", ""));
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setCheckFincDirCd(JSPUtil.getParameter(request, "check_finc_dir_cd", ""));
		setSVslCd(JSPUtil.getParameter(request, "s_vsl_cd", ""));
		setSN3ptyBilTpCd(JSPUtil.getParameter(request, "s_n3pty_bil_tp_cd", ""));
		setSBkgNo(JSPUtil.getParameter(request, "s_bkg_no", ""));
		setCostExptFlg(JSPUtil.getParameter(request, "cost_expt_flg", ""));
		setUserEmail(JSPUtil.getParameter(request, "user_email", ""));
		setRvwUsrId(JSPUtil.getParameter(request, "rvw_usr_id", ""));
		setSIfCtrlCd(JSPUtil.getParameter(request, "s_if_ctrl_cd", ""));
		setVndrCustDivCd(JSPUtil.getParameter(request, "vndr_cust_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCfmAmt(JSPUtil.getParameter(request, "cfm_amt", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setEstmSeqNo(JSPUtil.getParameter(request, "estm_seq_no", ""));
		setTesGubun(JSPUtil.getParameter(request, "tes_gubun", ""));
		setSrcVndrSeq(JSPUtil.getParameter(request, "src_vndr_seq", ""));
		setIfUsrId(JSPUtil.getParameter(request, "if_usr_id", ""));
		setGBlNoAll(JSPUtil.getParameter(request, "g_bl_no_all", ""));
		setTrsGubun(JSPUtil.getParameter(request, "trs_gubun", ""));
		setSEdate(JSPUtil.getParameter(request, "s_edate", ""));
		setifRmk(JSPUtil.getParameter(request, "if_rmk", ""));
		setSNr(JSPUtil.getParameter(request, "s_nr", ""));
		setSSdate(JSPUtil.getParameter(request, "s_sdate", ""));
		setSIfOfcCd(JSPUtil.getParameter(request, "s_if_ofc_cd", ""));
		setSVvd(JSPUtil.getParameter(request, "s_vvd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCfmRmk(JSPUtil.getParameter(request, "cfm_rmk", ""));
		setSSkdDirCd(JSPUtil.getParameter(request, "s_skd_dir_cd", ""));
		setSOfcCdForRhq(JSPUtil.getParameter(request, "s_ofc_cd_for_rhq", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSRhqCdForRhq(JSPUtil.getParameter(request, "s_rhq_cd_for_rhq", ""));
		setSN3ptySrcSubSysCd(JSPUtil.getParameter(request, "s_n3pty_src_sub_sys_cd", ""));
		setSEqNo(JSPUtil.getParameter(request, "s_eq_no", ""));
		setCfm(JSPUtil.getParameter(request, "cfm", ""));
		setGVvd(JSPUtil.getParameter(request, "g_vvd", ""));
		setEqKndNm(JSPUtil.getParameter(request, "eq_knd_nm", ""));
		setEstmDtlSeqNo(JSPUtil.getParameter(request, "estm_dtl_seq_no", ""));
		setIfCurrCd(JSPUtil.getParameter(request, "if_curr_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setTrdPartyVal(JSPUtil.getParameter(request, "trd_party_val", ""));
		setN3ptySrcNo(JSPUtil.getParameter(request, "n3pty_src_no", ""));
		setCfmC(JSPUtil.getParameter(request, "cfm_c", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCandidateListVO[]
	 */
	public SearchCandidateListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCandidateListVO[]
	 */
	public SearchCandidateListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCandidateListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] sSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "s_skd_voy_no", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] gBkgNoAll = (JSPUtil.getParameter(request, prefix	+ "g_bkg_no_all", length));
			String[] sBkgNoAll = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no_all", length));
			String[] ifOfcCd = (JSPUtil.getParameter(request, prefix	+ "if_ofc_cd", length));
			String[] inOtsDtlSeq = (JSPUtil.getParameter(request, prefix	+ "in_ots_dtl_seq", length));
			String[] sTrdPartyVal = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_val", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] estmSvrId = (JSPUtil.getParameter(request, prefix	+ "estm_svr_id", length));
			String[] otsDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ots_dtl_seq", length));
			String[] currN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "curr_n3pty_no", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ofc_cd", length));
			String[] cfmD = (JSPUtil.getParameter(request, prefix	+ "cfm_d", length));
			String[] sBlNo = (JSPUtil.getParameter(request, prefix	+ "s_bl_no", length));
			String[] sN3ptyNoStrsLink = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no_strs_link", length));
			String[] cfmI = (JSPUtil.getParameter(request, prefix	+ "cfm_i", length));
			String[] cfmG = (JSPUtil.getParameter(request, prefix	+ "cfm_g", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] ifUsrNm = (JSPUtil.getParameter(request, prefix	+ "if_usr_nm", length));
			String[] sOfcTopLvl = (JSPUtil.getParameter(request, prefix	+ "s_ofc_top_lvl", length));
			String[] userName = (JSPUtil.getParameter(request, prefix	+ "user_name", length));
			String[] rvwOfcCd = (JSPUtil.getParameter(request, prefix	+ "rvw_ofc_cd", length));
			String[] sOfficeLevel = (JSPUtil.getParameter(request, prefix	+ "s_office_level", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] cfmR = (JSPUtil.getParameter(request, prefix	+ "cfm_r", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] n3ptyIfTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_if_tp_cd", length));
			String[] sN3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_src_no", length));
			String[] sBlNoAll = (JSPUtil.getParameter(request, prefix	+ "s_bl_no_all", length));
			String[] sVndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_div_cd", length));
			String[] cfmN = (JSPUtil.getParameter(request, prefix	+ "cfm_n", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sCfmStatus = (JSPUtil.getParameter(request, prefix	+ "s_cfm_status", length));
			String[] estmRvisNo = (JSPUtil.getParameter(request, prefix	+ "estm_rvis_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] ifAmtUsd = (JSPUtil.getParameter(request, prefix	+ "if_amt_usd", length));
			String[] sIfRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_if_rhq_cd", length));
			String[] sCsrNo = (JSPUtil.getParameter(request, prefix	+ "s_csr_no", length));
			String[] sEqKndCd = (JSPUtil.getParameter(request, prefix	+ "s_eq_knd_cd", length));
			String[] n3ptySrcSubSysCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_sub_sys_cd", length));
			String[] n3ptyNonCfmRsnCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_non_cfm_rsn_cd", length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] checkFincDirCd = (JSPUtil.getParameter(request, prefix	+ "check_finc_dir_cd", length));
			String[] sVslCd = (JSPUtil.getParameter(request, prefix	+ "s_vsl_cd", length));
			String[] sN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_bil_tp_cd", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] costExptFlg = (JSPUtil.getParameter(request, prefix	+ "cost_expt_flg", length));
			String[] userEmail = (JSPUtil.getParameter(request, prefix	+ "user_email", length));
			String[] rvwUsrId = (JSPUtil.getParameter(request, prefix	+ "rvw_usr_id", length));
			String[] sIfCtrlCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ctrl_cd", length));
			String[] vndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_div_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cfmAmt = (JSPUtil.getParameter(request, prefix	+ "cfm_amt", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] estmSeqNo = (JSPUtil.getParameter(request, prefix	+ "estm_seq_no", length));
			String[] tesGubun = (JSPUtil.getParameter(request, prefix	+ "tes_gubun", length));
			String[] srcVndrSeq = (JSPUtil.getParameter(request, prefix	+ "src_vndr_seq", length));
			String[] ifUsrId = (JSPUtil.getParameter(request, prefix	+ "if_usr_id", length));
			String[] gBlNoAll = (JSPUtil.getParameter(request, prefix	+ "g_bl_no_all", length));
			String[] trsGubun = (JSPUtil.getParameter(request, prefix	+ "trs_gubun", length));
			String[] sEdate = (JSPUtil.getParameter(request, prefix	+ "s_edate", length));
			String[] ifRmk = (JSPUtil.getParameter(request, prefix	+ "if_rmk", length));
			String[] sNr = (JSPUtil.getParameter(request, prefix	+ "s_nr", length));
			String[] sSdate = (JSPUtil.getParameter(request, prefix	+ "s_sdate", length));
			String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ofc_cd", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] cfmRmk = (JSPUtil.getParameter(request, prefix	+ "cfm_rmk", length));
			String[] sSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "s_skd_dir_cd", length));
			String[] sOfcCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd_for_rhq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] sRhqCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_rhq_cd_for_rhq", length));
			String[] sN3ptySrcSubSysCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_src_sub_sys_cd", length));
			String[] sEqNo = (JSPUtil.getParameter(request, prefix	+ "s_eq_no", length));
			String[] cfm = (JSPUtil.getParameter(request, prefix	+ "cfm", length));
			String[] gVvd = (JSPUtil.getParameter(request, prefix	+ "g_vvd", length));
			String[] eqKndNm = (JSPUtil.getParameter(request, prefix	+ "eq_knd_nm", length));
			String[] estmDtlSeqNo = (JSPUtil.getParameter(request, prefix	+ "estm_dtl_seq_no", length));
			String[] ifCurrCd = (JSPUtil.getParameter(request, prefix	+ "if_curr_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] trdPartyVal = (JSPUtil.getParameter(request, prefix	+ "trd_party_val", length));
			String[] n3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_no", length));
			String[] cfmC = (JSPUtil.getParameter(request, prefix	+ "cfm_c", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCandidateListVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (sSkdVoyNo[i] != null)
					model.setSSkdVoyNo(sSkdVoyNo[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (gBkgNoAll[i] != null)
					model.setGBkgNoAll(gBkgNoAll[i]);
				if (sBkgNoAll[i] != null)
					model.setSBkgNoAll(sBkgNoAll[i]);
				if (ifOfcCd[i] != null)
					model.setIfOfcCd(ifOfcCd[i]);
				if (inOtsDtlSeq[i] != null)
					model.setInOtsDtlSeq(inOtsDtlSeq[i]);
				if (sTrdPartyVal[i] != null)
					model.setSTrdPartyVal(sTrdPartyVal[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (estmSvrId[i] != null)
					model.setEstmSvrId(estmSvrId[i]);
				if (otsDtlSeq[i] != null)
					model.setOtsDtlSeq(otsDtlSeq[i]);
				if (currN3ptyNo[i] != null)
					model.setCurrN3ptyNo(currN3ptyNo[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3ptyOfcCd[i] != null)
					model.setN3ptyOfcCd(n3ptyOfcCd[i]);
				if (cfmD[i] != null)
					model.setCfmD(cfmD[i]);
				if (sBlNo[i] != null)
					model.setSBlNo(sBlNo[i]);
				if (sN3ptyNoStrsLink[i] != null)
					model.setSN3ptyNoStrsLink(sN3ptyNoStrsLink[i]);
				if (cfmI[i] != null)
					model.setCfmI(cfmI[i]);
				if (cfmG[i] != null)
					model.setCfmG(cfmG[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (ifUsrNm[i] != null)
					model.setIfUsrNm(ifUsrNm[i]);
				if (sOfcTopLvl[i] != null)
					model.setSOfcTopLvl(sOfcTopLvl[i]);
				if (userName[i] != null)
					model.setUserName(userName[i]);
				if (rvwOfcCd[i] != null)
					model.setRvwOfcCd(rvwOfcCd[i]);
				if (sOfficeLevel[i] != null)
					model.setSOfficeLevel(sOfficeLevel[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
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
				if (sVndrCustDivCd[i] != null)
					model.setSVndrCustDivCd(sVndrCustDivCd[i]);
				if (cfmN[i] != null)
					model.setCfmN(cfmN[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sCfmStatus[i] != null)
					model.setSCfmStatus(sCfmStatus[i]);
				if (estmRvisNo[i] != null)
					model.setEstmRvisNo(estmRvisNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (ifAmtUsd[i] != null)
					model.setIfAmtUsd(ifAmtUsd[i]);
				if (sIfRhqCd[i] != null)
					model.setSIfRhqCd(sIfRhqCd[i]);
				if (sCsrNo[i] != null)
					model.setSCsrNo(sCsrNo[i]);
				if (sEqKndCd[i] != null)
					model.setSEqKndCd(sEqKndCd[i]);
				if (n3ptySrcSubSysCd[i] != null)
					model.setN3ptySrcSubSysCd(n3ptySrcSubSysCd[i]);
				if (n3ptyNonCfmRsnCd[i] != null)
					model.setN3ptyNonCfmRsnCd(n3ptyNonCfmRsnCd[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (checkFincDirCd[i] != null)
					model.setCheckFincDirCd(checkFincDirCd[i]);
				if (sVslCd[i] != null)
					model.setSVslCd(sVslCd[i]);
				if (sN3ptyBilTpCd[i] != null)
					model.setSN3ptyBilTpCd(sN3ptyBilTpCd[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (costExptFlg[i] != null)
					model.setCostExptFlg(costExptFlg[i]);
				if (userEmail[i] != null)
					model.setUserEmail(userEmail[i]);
				if (rvwUsrId[i] != null)
					model.setRvwUsrId(rvwUsrId[i]);
				if (sIfCtrlCd[i] != null)
					model.setSIfCtrlCd(sIfCtrlCd[i]);
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
				if (ifUsrId[i] != null)
					model.setIfUsrId(ifUsrId[i]);
				if (gBlNoAll[i] != null)
					model.setGBlNoAll(gBlNoAll[i]);
				if (trsGubun[i] != null)
					model.setTrsGubun(trsGubun[i]);
				if (sEdate[i] != null)
					model.setSEdate(sEdate[i]);
				if (ifRmk[i] != null)
					model.setifRmk(ifRmk[i]);
				if (sNr[i] != null)
					model.setSNr(sNr[i]);
				if (sSdate[i] != null)
					model.setSSdate(sSdate[i]);
				if (sIfOfcCd[i] != null)
					model.setSIfOfcCd(sIfOfcCd[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cfmRmk[i] != null)
					model.setCfmRmk(cfmRmk[i]);
				if (sSkdDirCd[i] != null)
					model.setSSkdDirCd(sSkdDirCd[i]);
				if (sOfcCdForRhq[i] != null)
					model.setSOfcCdForRhq(sOfcCdForRhq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (sRhqCdForRhq[i] != null)
					model.setSRhqCdForRhq(sRhqCdForRhq[i]);
				if (sN3ptySrcSubSysCd[i] != null)
					model.setSN3ptySrcSubSysCd(sN3ptySrcSubSysCd[i]);
				if (sEqNo[i] != null)
					model.setSEqNo(sEqNo[i]);
				if (cfm[i] != null)
					model.setCfm(cfm[i]);
				if (gVvd[i] != null)
					model.setGVvd(gVvd[i]);
				if (eqKndNm[i] != null)
					model.setEqKndNm(eqKndNm[i]);
				if (estmDtlSeqNo[i] != null)
					model.setEstmDtlSeqNo(estmDtlSeqNo[i]);
				if (ifCurrCd[i] != null)
					model.setIfCurrCd(ifCurrCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
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
		return getSearchCandidateListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCandidateListVO[]
	 */
	public SearchCandidateListVO[] getSearchCandidateListVOs(){
		SearchCandidateListVO[] vos = (SearchCandidateListVO[])models.toArray(new SearchCandidateListVO[models.size()]);
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
		this.sSkdVoyNo = this.sSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gBkgNoAll = this.gBkgNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNoAll = this.sBkgNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOfcCd = this.ifOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inOtsDtlSeq = this.inOtsDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyVal = this.sTrdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSvrId = this.estmSvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDtlSeq = this.otsDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currN3ptyNo = this.currN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyOfcCd = this.n3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmD = this.cfmD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBlNo = this.sBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNoStrsLink = this.sN3ptyNoStrsLink .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmI = this.cfmI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmG = this.cfmG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifUsrNm = this.ifUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcTopLvl = this.sOfcTopLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userName = this.userName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvwOfcCd = this.rvwOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfficeLevel = this.sOfficeLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmR = this.cfmR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyIfTpCd = this.n3ptyIfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptySrcNo = this.sN3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBlNoAll = this.sBlNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustDivCd = this.sVndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmN = this.cfmN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCfmStatus = this.sCfmStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmRvisNo = this.estmRvisNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmtUsd = this.ifAmtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfRhqCd = this.sIfRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCsrNo = this.sCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqKndCd = this.sEqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcSubSysCd = this.n3ptySrcSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNonCfmRsnCd = this.n3ptyNonCfmRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkFincDirCd = this.checkFincDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVslCd = this.sVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyBilTpCd = this.sN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costExptFlg = this.costExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userEmail = this.userEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvwUsrId = this.rvwUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfCtrlCd = this.sIfCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustDivCd = this.vndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmAmt = this.cfmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSeqNo = this.estmSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tesGubun = this.tesGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcVndrSeq = this.srcVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifUsrId = this.ifUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gBlNoAll = this.gBlNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsGubun = this.trsGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdate = this.sEdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRmk = this.ifRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNr = this.sNr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSdate = this.sSdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfOfcCd = this.sIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmRmk = this.cfmRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSkdDirCd = this.sSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCdForRhq = this.sOfcCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqCdForRhq = this.sRhqCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptySrcSubSysCd = this.sN3ptySrcSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqNo = this.sEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfm = this.cfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gVvd = this.gVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndNm = this.eqKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmDtlSeqNo = this.estmDtlSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifCurrCd = this.ifCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyVal = this.trdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNo = this.n3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmC = this.cfmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
