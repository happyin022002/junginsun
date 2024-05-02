/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchTPBGroupRemakingVO.java
*@FileTitle : SearchTPBGroupRemakingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.09.01 최 선 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo;

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
 * @author 최 선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTPBGroupRemakingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTPBGroupRemakingVO> models = new ArrayList<SearchTPBGroupRemakingVO>();
	
	/* Column Info */
	private String sCandidateIncludeFlag = null;
	/* Column Info */
	private String sN3ptyBilTpCd = null;
	/* Column Info */
	private String n3ptyExpnTpCd = null;
	/* Column Info */
	private String trdPartyCode = null;
	/* Column Info */
	private String sTrdPartyVal = null;
	/* Column Info */
	private String glMonth = null;
	/* Column Info */
	private String otsDtlSeq = null;
	/* Column Info */
	private String n3ptyBilTpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3ptyBilTpCd = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String actVvd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String cfmAmt = null;
	/* Column Info */
	private String cfmCurrCd = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String grpSrtNo = null;
	/* Column Info */
	private String blNoAll = null;
	/* Column Info */
	private String trdPartyName = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String sEdate = null;
	/* Column Info */
	private String bkgNoAll = null;
	/* Column Info */
	private String sBkgNoAll = null;
	/* Column Info */
	private String n3ptyNoOrg = null;
	/* Column Info */
	private String n3ptyNoDpSeqOrg = null;
	/* Column Info */
	private String sBlNoAll = null;
	/* Column Info */
	private String sSdate = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String sVndrCustDivCd = null;
	/* Column Info */
	private String sIfOfcCd = null;
	/* Column Info */
	private String grpSrtNoOrg = null;
	/* Column Info */
	private String n3ptyNoDpSeq = null;
	/* Column Info */
	private String sN3ptySrcSubSysCd = null;
	/* Column Info */
	private String otsStsNm = null;
	/* Column Info */
	private String candidateYn = null;
	/* Column Info */
	private String rocCandidateYn = null;
	/* Column Info */
	private String sEqNo = null;
	/* Column Info */
	private String sN3ptyNoSearch = null;
	/* Column Info */
	private String sIfRhqCd = null;
	/* Column Info */
	private String n3ptySrcNo = null;
	/* Column Info */
	private String revVvd = null;
	/* Column Info */
	private String ifCurrCd = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String sUserOfcCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTPBGroupRemakingVO() {}

	public SearchTPBGroupRemakingVO(String ibflag, String pagerows, String grpSrtNoOrg, String grpSrtNo, String otsDtlSeq, String n3ptyNoOrg, String n3ptyNoDpSeqOrg, String n3ptyNo, String n3ptyNoDpSeq, String n3ptyExpnTpCd, String n3ptyBilTpCd, String n3ptyBilTpNm, String n3ptySrcNo, String bkgNoAll, String sBkgNoAll, String blNoAll, String actVvd, String csrNo, String glMonth, String eqNo, String trdPartyCode, String trdPartyName, String otsStsNm, String candidateYn, String rocCandidateYn, String cfmCurrCd, String cfmAmt, String sIfRhqCd, String sIfOfcCd, String sSdate, String sEdate, String sN3ptySrcSubSysCd, String sN3ptyBilTpCd, String sVndrCustDivCd, String sTrdPartyVal, String sVvd, String sBlNoAll, String sEqNo, String sN3ptyNoSearch, String sCandidateIncludeFlag, String revVvd, String ifCurrCd, String ifAmt, String sUserOfcCd) {
		this.sCandidateIncludeFlag = sCandidateIncludeFlag;
		this.sN3ptyBilTpCd = sN3ptyBilTpCd;
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
		this.trdPartyCode = trdPartyCode;
		this.sTrdPartyVal = sTrdPartyVal;
		this.glMonth = glMonth;
		this.otsDtlSeq = otsDtlSeq;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.pagerows = pagerows;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.ibflag = ibflag;
		this.actVvd = actVvd;
		this.eqNo = eqNo;
		this.cfmAmt = cfmAmt;
		this.cfmCurrCd = cfmCurrCd;
		this.n3ptyNo = n3ptyNo;
		this.grpSrtNo = grpSrtNo;
		this.blNoAll = blNoAll;
		this.trdPartyName = trdPartyName;
		this.csrNo = csrNo;
		this.sEdate = sEdate;
		this.bkgNoAll = bkgNoAll;
		this.sBkgNoAll = sBkgNoAll;
		this.n3ptyNoOrg = n3ptyNoOrg;
		this.n3ptyNoDpSeqOrg = n3ptyNoDpSeqOrg;
		this.sBlNoAll = sBlNoAll;
		this.sSdate = sSdate;
		this.sVvd = sVvd;
		this.sVndrCustDivCd = sVndrCustDivCd;
		this.sIfOfcCd = sIfOfcCd;
		this.grpSrtNoOrg = grpSrtNoOrg;
		this.n3ptyNoDpSeq = n3ptyNoDpSeq;
		this.sN3ptySrcSubSysCd = sN3ptySrcSubSysCd;
		this.otsStsNm = otsStsNm;
		this.candidateYn = candidateYn;
		this.rocCandidateYn = rocCandidateYn;
		this.sEqNo = sEqNo;
		this.sN3ptyNoSearch = sN3ptyNoSearch;
		this.sIfRhqCd = sIfRhqCd;
		this.n3ptySrcNo = n3ptySrcNo;
		this.revVvd = revVvd;
		this.ifCurrCd = ifCurrCd;
		this.ifAmt = ifAmt;
		this.sUserOfcCd = sUserOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_candidate_include_flag", getSCandidateIncludeFlag());
		this.hashColumns.put("s_n3pty_bil_tp_cd", getSN3ptyBilTpCd());
		this.hashColumns.put("n3pty_expn_tp_cd", getN3ptyExpnTpCd());
		this.hashColumns.put("trd_party_code", getTrdPartyCode());
		this.hashColumns.put("s_trd_party_val", getSTrdPartyVal());
		this.hashColumns.put("gl_month", getGlMonth());
		this.hashColumns.put("ots_dtl_seq", getOtsDtlSeq());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_vvd", getActVvd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cfm_amt", getCfmAmt());
		this.hashColumns.put("cfm_curr_cd", getCfmCurrCd());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("grp_srt_no", getGrpSrtNo());
		this.hashColumns.put("bl_no_all", getBlNoAll());
		this.hashColumns.put("trd_party_name", getTrdPartyName());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("s_edate", getSEdate());
		this.hashColumns.put("bkg_no_all", getBkgNoAll());
		this.hashColumns.put("s_bkg_no_all", getSBkgNoAll());
		this.hashColumns.put("n3pty_no_org", getN3ptyNoOrg());
		this.hashColumns.put("n3pty_no_dp_seq_org", getN3ptyNoDpSeqOrg());
		this.hashColumns.put("s_bl_no_all", getSBlNoAll());
		this.hashColumns.put("s_sdate", getSSdate());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("s_vndr_cust_div_cd", getSVndrCustDivCd());
		this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
		this.hashColumns.put("grp_srt_no_org", getGrpSrtNoOrg());
		this.hashColumns.put("n3pty_no_dp_seq", getN3ptyNoDpSeq());
		this.hashColumns.put("s_n3pty_src_sub_sys_cd", getSN3ptySrcSubSysCd());
		this.hashColumns.put("ots_sts_nm", getOtsStsNm());
		this.hashColumns.put("candidate_yn", getCandidateYn());
		this.hashColumns.put("roc_candidate_yn", getRocCandidateYn());
		this.hashColumns.put("s_eq_no", getSEqNo());
		this.hashColumns.put("s_n3pty_no_search", getSN3ptyNoSearch());
		this.hashColumns.put("s_if_rhq_cd", getSIfRhqCd());
		this.hashColumns.put("n3pty_src_no", getN3ptySrcNo());
		this.hashColumns.put("rev_vvd", getRevVvd());
		this.hashColumns.put("if_curr_cd", getIfCurrCd());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("s_user_ofc_cd", getSUserOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_candidate_include_flag", "sCandidateIncludeFlag");
		this.hashFields.put("s_n3pty_bil_tp_cd", "sN3ptyBilTpCd");
		this.hashFields.put("n3pty_expn_tp_cd", "n3ptyExpnTpCd");
		this.hashFields.put("trd_party_code", "trdPartyCode");
		this.hashFields.put("s_trd_party_val", "sTrdPartyVal");
		this.hashFields.put("gl_month", "glMonth");
		this.hashFields.put("ots_dtl_seq", "otsDtlSeq");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_vvd", "actVvd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cfm_amt", "cfmAmt");
		this.hashFields.put("cfm_curr_cd", "cfmCurrCd");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("grp_srt_no", "grpSrtNo");
		this.hashFields.put("bl_no_all", "blNoAll");
		this.hashFields.put("trd_party_name", "trdPartyName");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("s_edate", "sEdate");
		this.hashFields.put("bkg_no_all", "bkgNoAll");
		this.hashFields.put("s_bkg_no_all", "sBkgNoAll");
		this.hashFields.put("n3pty_no_org", "n3ptyNoOrg");
		this.hashFields.put("n3pty_no_dp_seq_org", "n3ptyNoDpSeqOrg");
		this.hashFields.put("s_bl_no_all", "sBlNoAll");
		this.hashFields.put("s_sdate", "sSdate");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("s_vndr_cust_div_cd", "sVndrCustDivCd");
		this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
		this.hashFields.put("grp_srt_no_org", "grpSrtNoOrg");
		this.hashFields.put("n3pty_no_dp_seq", "n3ptyNoDpSeq");
		this.hashFields.put("s_n3pty_src_sub_sys_cd", "sN3ptySrcSubSysCd");
		this.hashFields.put("ots_sts_nm", "otsStsNm");
		this.hashFields.put("candidate_yn", "candidateYn");
		this.hashFields.put("roc_candidate_yn", "rocCandidateYn");
		this.hashFields.put("s_eq_no", "sEqNo");
		this.hashFields.put("s_n3pty_no_search", "sN3ptyNoSearch");
		this.hashFields.put("s_if_rhq_cd", "sIfRhqCd");
		this.hashFields.put("n3pty_src_no", "n3ptySrcNo");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("if_curr_cd", "ifCurrCd");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("s_user_ofc_cd", "sUserOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sCandidateIncludeFlag
	 */
	public String getSCandidateIncludeFlag() {
		return this.sCandidateIncludeFlag;
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
	 * @return sTrdPartyVal
	 */
	public String getSTrdPartyVal() {
		return this.sTrdPartyVal;
	}
	
	/**
	 * Column Info
	 * @return glMonth
	 */
	public String getGlMonth() {
		return this.glMonth;
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
	 * @return n3ptyBilTpCd
	 */
	public String getN3ptyBilTpCd() {
		return this.n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return actVvd
	 */
	public String getActVvd() {
		return this.actVvd;
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
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return grpSrtNo
	 */
	public String getGrpSrtNo() {
		return this.grpSrtNo;
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
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
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
	 * @return sBkgNoAll
	 */
	public String getSBkgNoAll() {
		return this.sBkgNoAll;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNoOrg
	 */
	public String getN3ptyNoOrg() {
		return this.n3ptyNoOrg;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNoDpSeqOrg
	 */
	public String getN3ptyNoDpSeqOrg() {
		return this.n3ptyNoDpSeqOrg;
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
	 * @return grpSrtNoOrg
	 */
	public String getGrpSrtNoOrg() {
		return this.grpSrtNoOrg;
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
	 * @return sN3ptySrcSubSysCd
	 */
	public String getSN3ptySrcSubSysCd() {
		return this.sN3ptySrcSubSysCd;
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
	 * @return candidateYn
	 */
	public String getCandidateYn() {
		return this.candidateYn;
	}
	
	/**
	 * Column Info
	 * @return rocCandidateYn
	 */
	public String getRocCandidateYn() {
		return this.rocCandidateYn;
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
	 * @return sN3ptyNoSearch
	 */
	public String getSN3ptyNoSearch() {
		return this.sN3ptyNoSearch;
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
	 * @return n3ptySrcNo
	 */
	public String getN3ptySrcNo() {
		return this.n3ptySrcNo;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyNoSearch
	 */
	public String getRevVvd() {
		return this.revVvd;
	}
	
	/**
	 * Column Info
	 * @return sIfRhqCd
	 */
	public String getIfCurrCd() {
		return this.ifCurrCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcNo
	 */
	public String getIfAmt() {
		return this.ifAmt;
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
	 * @param sCandidateIncludeFlag
	 */
	public void setSCandidateIncludeFlag(String sCandidateIncludeFlag) {
		this.sCandidateIncludeFlag = sCandidateIncludeFlag;
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
	 * @param sTrdPartyVal
	 */
	public void setSTrdPartyVal(String sTrdPartyVal) {
		this.sTrdPartyVal = sTrdPartyVal;
	}
	
	/**
	 * Column Info
	 * @param glMonth
	 */
	public void setGlMonth(String glMonth) {
		this.glMonth = glMonth;
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
	 * @param n3ptyBilTpCd
	 */
	public void setN3ptyBilTpCd(String n3ptyBilTpCd) {
		this.n3ptyBilTpCd = n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param actVvd
	 */
	public void setActVvd(String actVvd) {
		this.actVvd = actVvd;
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
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param grpSrtNo
	 */
	public void setGrpSrtNo(String grpSrtNo) {
		this.grpSrtNo = grpSrtNo;
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
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
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
	 * @param sBkgNoAll
	 */
	public void setSBkgNoAll(String sBkgNoAll) {
		this.sBkgNoAll = sBkgNoAll;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNoOrg
	 */
	public void setN3ptyNoOrg(String n3ptyNoOrg) {
		this.n3ptyNoOrg = n3ptyNoOrg;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNoDpSeqOrg
	 */
	public void setN3ptyNoDpSeqOrg(String n3ptyNoDpSeqOrg) {
		this.n3ptyNoDpSeqOrg = n3ptyNoDpSeqOrg;
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
	 * @param grpSrtNoOrg
	 */
	public void setGrpSrtNoOrg(String grpSrtNoOrg) {
		this.grpSrtNoOrg = grpSrtNoOrg;
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
	 * @param sN3ptySrcSubSysCd
	 */
	public void setSN3ptySrcSubSysCd(String sN3ptySrcSubSysCd) {
		this.sN3ptySrcSubSysCd = sN3ptySrcSubSysCd;
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
	 * @param candidateYn
	 */
	public void setCandidateYn(String candidateYn) {
		this.candidateYn = candidateYn;
	}
	
	/**
	 * Column Info
	 * @param rocCandidateYn
	 */
	public void setRocCandidateYn(String rocCandidateYn) {
		this.rocCandidateYn = rocCandidateYn;
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
	 * @param sN3ptyNoSearch
	 */
	public void setSN3ptyNoSearch(String sN3ptyNoSearch) {
		this.sN3ptyNoSearch = sN3ptyNoSearch;
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
	 * @param n3ptySrcNo
	 */
	public void setN3ptySrcNo(String n3ptySrcNo) {
		this.n3ptySrcNo = n3ptySrcNo;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyNoSearch
	 */
	public void setRevVvd(String revVvd) {
		this.revVvd = revVvd;
	}
	
	/**
	 * Column Info
	 * @param sIfRhqCd
	 */
	public void setIfCurrCd(String ifCurrCd) {
		this.ifCurrCd = ifCurrCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcNo
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
	}
	
	/**
	 * Column Info
	 * @param sUserOfcCd
	 */
	public void setSUserOfcCd(String sUserOfcCd) {
		this.sUserOfcCd = sUserOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSCandidateIncludeFlag(JSPUtil.getParameter(request, "s_candidate_include_flag", ""));
		setSN3ptyBilTpCd(JSPUtil.getParameter(request, "s_n3pty_bil_tp_cd", ""));
		setN3ptyExpnTpCd(JSPUtil.getParameter(request, "n3pty_expn_tp_cd", ""));
		setTrdPartyCode(JSPUtil.getParameter(request, "trd_party_code", ""));
		setSTrdPartyVal(JSPUtil.getParameter(request, "s_trd_party_val", ""));
		setGlMonth(JSPUtil.getParameter(request, "gl_month", ""));
		setOtsDtlSeq(JSPUtil.getParameter(request, "ots_dtl_seq", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, "n3pty_bil_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, "n3pty_bil_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActVvd(JSPUtil.getParameter(request, "act_vvd", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setCfmAmt(JSPUtil.getParameter(request, "cfm_amt", ""));
		setCfmCurrCd(JSPUtil.getParameter(request, "cfm_curr_cd", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setGrpSrtNo(JSPUtil.getParameter(request, "grp_srt_no", ""));
		setBlNoAll(JSPUtil.getParameter(request, "bl_no_all", ""));
		setTrdPartyName(JSPUtil.getParameter(request, "trd_party_name", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setSEdate(JSPUtil.getParameter(request, "s_edate", ""));
		setBkgNoAll(JSPUtil.getParameter(request, "bkg_no_all", ""));
		setSBkgNoAll(JSPUtil.getParameter(request, "s_bkg_no_all", ""));
		setN3ptyNoOrg(JSPUtil.getParameter(request, "n3pty_no_org", ""));
		setN3ptyNoDpSeqOrg(JSPUtil.getParameter(request, "n3pty_no_dp_seq_org", ""));
		setSBlNoAll(JSPUtil.getParameter(request, "s_bl_no_all", ""));
		setSSdate(JSPUtil.getParameter(request, "s_sdate", ""));
		setSVvd(JSPUtil.getParameter(request, "s_vvd", ""));
		setSVndrCustDivCd(JSPUtil.getParameter(request, "s_vndr_cust_div_cd", ""));
		setSIfOfcCd(JSPUtil.getParameter(request, "s_if_ofc_cd", ""));
		setGrpSrtNoOrg(JSPUtil.getParameter(request, "grp_srt_no_org", ""));
		setN3ptyNoDpSeq(JSPUtil.getParameter(request, "n3pty_no_dp_seq", ""));
		setSN3ptySrcSubSysCd(JSPUtil.getParameter(request, "s_n3pty_src_sub_sys_cd", ""));
		setOtsStsNm(JSPUtil.getParameter(request, "ots_sts_nm", ""));
		setCandidateYn(JSPUtil.getParameter(request, "candidate_yn", ""));
		setCandidateYn(JSPUtil.getParameter(request, "roc_candidate_yn", ""));
		setSEqNo(JSPUtil.getParameter(request, "s_eq_no", ""));
		setSN3ptyNoSearch(JSPUtil.getParameter(request, "s_n3pty_no_search", ""));
		setSIfRhqCd(JSPUtil.getParameter(request, "s_if_rhq_cd", ""));
		setN3ptySrcNo(JSPUtil.getParameter(request, "n3pty_src_no", ""));
		setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
		setIfCurrCd(JSPUtil.getParameter(request, "if_curr_cd", ""));
		setIfAmt(JSPUtil.getParameter(request, "if_amt", ""));
		setSUserOfcCd(JSPUtil.getParameter(request, "s_user_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTPBGroupRemakingVO[]
	 */
	public SearchTPBGroupRemakingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTPBGroupRemakingVO[]
	 */
	public SearchTPBGroupRemakingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTPBGroupRemakingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sCandidateIncludeFlag = (JSPUtil.getParameter(request, prefix	+ "s_candidate_include_flag", length));
			String[] sN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_bil_tp_cd", length));
			String[] n3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_expn_tp_cd", length));
			String[] trdPartyCode = (JSPUtil.getParameter(request, prefix	+ "trd_party_code", length));
			String[] sTrdPartyVal = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_val", length));
			String[] glMonth = (JSPUtil.getParameter(request, prefix	+ "gl_month", length));
			String[] otsDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ots_dtl_seq", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actVvd = (JSPUtil.getParameter(request, prefix	+ "act_vvd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] cfmAmt = (JSPUtil.getParameter(request, prefix	+ "cfm_amt", length));
			String[] cfmCurrCd = (JSPUtil.getParameter(request, prefix	+ "cfm_curr_cd", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] grpSrtNo = (JSPUtil.getParameter(request, prefix	+ "grp_srt_no", length));
			String[] blNoAll = (JSPUtil.getParameter(request, prefix	+ "bl_no_all", length));
			String[] trdPartyName = (JSPUtil.getParameter(request, prefix	+ "trd_party_name", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] sEdate = (JSPUtil.getParameter(request, prefix	+ "s_edate", length));
			String[] bkgNoAll = (JSPUtil.getParameter(request, prefix	+ "bkg_no_all", length));
			String[] sBkgNoAll = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no_all", length));
			String[] n3ptyNoOrg = (JSPUtil.getParameter(request, prefix	+ "n3pty_no_org", length));
			String[] n3ptyNoDpSeqOrg = (JSPUtil.getParameter(request, prefix	+ "n3pty_no_dp_seq_org", length));
			String[] sBlNoAll = (JSPUtil.getParameter(request, prefix	+ "s_bl_no_all", length));
			String[] sSdate = (JSPUtil.getParameter(request, prefix	+ "s_sdate", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] sVndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_div_cd", length));
			String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ofc_cd", length));
			String[] grpSrtNoOrg = (JSPUtil.getParameter(request, prefix	+ "grp_srt_no_org", length));
			String[] n3ptyNoDpSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_no_dp_seq", length));
			String[] sN3ptySrcSubSysCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_src_sub_sys_cd", length));
			String[] otsStsNm = (JSPUtil.getParameter(request, prefix	+ "ots_sts_nm", length));
			String[] candidateYn = (JSPUtil.getParameter(request, prefix	+ "candidate_yn", length));
			String[] rocCandidateYn = (JSPUtil.getParameter(request, prefix	+ "roc_candidate_yn", length));
			String[] sEqNo = (JSPUtil.getParameter(request, prefix	+ "s_eq_no", length));
			String[] sN3ptyNoSearch = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no_search", length));
			String[] sIfRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_if_rhq_cd", length));
			String[] n3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_no", length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd", length));
			String[] ifCurrCd = (JSPUtil.getParameter(request, prefix	+ "if_curr_cd", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] sUserOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_user_ofc_cd", length));

			for (int i = 0; i < length; i++) {
				model = new SearchTPBGroupRemakingVO();
				if (sCandidateIncludeFlag[i] != null)
					model.setSCandidateIncludeFlag(sCandidateIncludeFlag[i]);
				if (sN3ptyBilTpCd[i] != null)
					model.setSN3ptyBilTpCd(sN3ptyBilTpCd[i]);
				if (n3ptyExpnTpCd[i] != null)
					model.setN3ptyExpnTpCd(n3ptyExpnTpCd[i]);
				if (trdPartyCode[i] != null)
					model.setTrdPartyCode(trdPartyCode[i]);
				if (sTrdPartyVal[i] != null)
					model.setSTrdPartyVal(sTrdPartyVal[i]);
				if (glMonth[i] != null)
					model.setGlMonth(glMonth[i]);
				if (otsDtlSeq[i] != null)
					model.setOtsDtlSeq(otsDtlSeq[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3ptyBilTpCd[i] != null)
					model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actVvd[i] != null)
					model.setActVvd(actVvd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (cfmAmt[i] != null)
					model.setCfmAmt(cfmAmt[i]);
				if (cfmCurrCd[i] != null)
					model.setCfmCurrCd(cfmCurrCd[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (grpSrtNo[i] != null)
					model.setGrpSrtNo(grpSrtNo[i]);
				if (blNoAll[i] != null)
					model.setBlNoAll(blNoAll[i]);
				if (trdPartyName[i] != null)
					model.setTrdPartyName(trdPartyName[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (sEdate[i] != null)
					model.setSEdate(sEdate[i]);
				if (bkgNoAll[i] != null)
					model.setBkgNoAll(bkgNoAll[i]);
				if (sBkgNoAll[i] != null)
					model.setSBkgNoAll(sBkgNoAll[i]);
				if (n3ptyNoOrg[i] != null)
					model.setN3ptyNoOrg(n3ptyNoOrg[i]);
				if (n3ptyNoDpSeqOrg[i] != null)
					model.setN3ptyNoDpSeqOrg(n3ptyNoDpSeqOrg[i]);
				if (sBlNoAll[i] != null)
					model.setSBlNoAll(sBlNoAll[i]);
				if (sSdate[i] != null)
					model.setSSdate(sSdate[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (sVndrCustDivCd[i] != null)
					model.setSVndrCustDivCd(sVndrCustDivCd[i]);
				if (sIfOfcCd[i] != null)
					model.setSIfOfcCd(sIfOfcCd[i]);
				if (grpSrtNoOrg[i] != null)
					model.setGrpSrtNoOrg(grpSrtNoOrg[i]);
				if (n3ptyNoDpSeq[i] != null)
					model.setN3ptyNoDpSeq(n3ptyNoDpSeq[i]);
				if (sN3ptySrcSubSysCd[i] != null)
					model.setSN3ptySrcSubSysCd(sN3ptySrcSubSysCd[i]);
				if (otsStsNm[i] != null)
					model.setOtsStsNm(otsStsNm[i]);
				if (candidateYn[i] != null)
					model.setCandidateYn(candidateYn[i]);
				if (rocCandidateYn[i] != null)
					model.setRocCandidateYn(rocCandidateYn[i]);
				if (sEqNo[i] != null)
					model.setSEqNo(sEqNo[i]);
				if (sN3ptyNoSearch[i] != null)
					model.setSN3ptyNoSearch(sN3ptyNoSearch[i]);
				if (sIfRhqCd[i] != null)
					model.setSIfRhqCd(sIfRhqCd[i]);
				if (n3ptySrcNo[i] != null)
					model.setN3ptySrcNo(n3ptySrcNo[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
				if (ifCurrCd[i] != null)
					model.setIfCurrCd(ifCurrCd[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (sUserOfcCd[i] != null)
					model.setSUserOfcCd(sUserOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTPBGroupRemakingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTPBGroupRemakingVO[]
	 */
	public SearchTPBGroupRemakingVO[] getSearchTPBGroupRemakingVOs(){
		SearchTPBGroupRemakingVO[] vos = (SearchTPBGroupRemakingVO[])models.toArray(new SearchTPBGroupRemakingVO[models.size()]);
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
		this.sCandidateIncludeFlag = this.sCandidateIncludeFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyBilTpCd = this.sN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyExpnTpCd = this.n3ptyExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyCode = this.trdPartyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyVal = this.sTrdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glMonth = this.glMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDtlSeq = this.otsDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actVvd = this.actVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmAmt = this.cfmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmCurrCd = this.cfmCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpSrtNo = this.grpSrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoAll = this.blNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyName = this.trdPartyName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdate = this.sEdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoAll = this.bkgNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNoAll = this.sBkgNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNoOrg = this.n3ptyNoOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNoDpSeqOrg = this.n3ptyNoDpSeqOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBlNoAll = this.sBlNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSdate = this.sSdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustDivCd = this.sVndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfOfcCd = this.sIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpSrtNoOrg = this.grpSrtNoOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNoDpSeq = this.n3ptyNoDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptySrcSubSysCd = this.sN3ptySrcSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStsNm = this.otsStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.candidateYn = this.candidateYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rocCandidateYn = this.rocCandidateYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqNo = this.sEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNoSearch = this.sN3ptyNoSearch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfRhqCd = this.sIfRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNo = this.n3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifCurrCd = this.ifCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUserOfcCd = this.sUserOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
