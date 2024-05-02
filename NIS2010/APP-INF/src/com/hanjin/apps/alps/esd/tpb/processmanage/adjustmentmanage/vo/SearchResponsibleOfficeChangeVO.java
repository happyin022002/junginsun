/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchResponsibleOfficeChangeVO.java
*@FileTitle : SearchResponsibleOfficeChangeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.09.28 최 선 
* 1.0 Creation  
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo;

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
 * @author 최 선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchResponsibleOfficeChangeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchResponsibleOfficeChangeVO> models = new ArrayList<SearchResponsibleOfficeChangeVO>();
	
	/* Column Info */
	private String sCurrCdTp = null;
	/* Column Info */
	private String rejOfc = null;
	/* Column Info */
	private String ifOfcCd = null;
	/* Column Info */
	private String sTrdPartyVal = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String sUserOfcCd = null;
	/* Column Info */
	private String sFileNo = null;
	/* Column Info */
	private String stlCltOfcCngAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String n3ptyInvNo = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String sRaRmk2 = null;
	/* Column Info */
	private String stlToCltCngOfcCd = null;
	/* Column Info */
	private String sN3ptyNoStrsLink = null;
	/* Column Info */
	private String cltActYn = null;
	/* Column Info */
	private String sSTrdPartyVal = null;
	/* Column Info */
	private String sRaRmk1 = null;
	/* Column Info */
	private String appOfc = null;
	/* Column Info */
	private String sOfficeLevel = null;
	/* Column Info */
	private String cDateKindFlag = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String sVndrCustDivCd = null;
	/* Column Info */
	private String otsStsCdVal = null;
	/* Column Info */
	private String ifRhqCd = null;
	/* Column Info */
	private String stlAmt = null;
	/* Column Info */
	private String n3ptyStlTpCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String otsAmt = null;
	/* Column Info */
	private String sIfRhqCd = null;
	/* Column Info */
	private String n3ptySrcSubSysCd = null;
	/* Column Info */
	private String n3ptyBilTpNm = null;
	/* Column Info */
	private String sSVndrCustDivCd = null;
	/* Column Info */
	private String otsStsCd = null;
	/* Column Info */
	private String appId = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cltAmt = null;
	/* Column Info */
	private String sDateKindFlag = null;
	/* Column Info */
	private String reviewStep = null;
	/* Column Info */
	private String ipage = null;
	/* Column Info */
	private String reqDate = null;
	/* Column Info */
	private String sIfCtrlCd = null;
	/* Column Info */
	private String rejDate = null;
	/* Column Info */
	private String sCalendarDate1 = null;
	/* Column Info */
	private String sCalendarDate2 = null;
	/* Column Info */
	private String balAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sN3ptyNoStrs = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String reqOfc = null;
	/* Column Info */
	private String appDate = null;
	/* Column Info */
	private String sDateFlagI = null;
	/* Column Info */
	private String reqId = null;
	/* Column Info */
	private String sN3ptyNo = null;
	/* Column Info */
	private String sDateFlagR = null;
	/* Column Info */
	private String rejId = null;
	/* Column Info */
	private String approval = null;
	/* Column Info */
	private String sIfOfcCd = null;
	/* Column Info */
	private String dateType = null;
	/* Column Info */
	private String stlRqstDt = null;
	/* Column Info */
	private String sOfcCdForRhq = null;
	/* Column Info */
	private String stlRqstRmk = null;
	/* Column Info */
	private String chkReq = null;
	/* Column Info */
	private String sRhqCdForRhq = null;
	/* Column Info */
	private String chkApp = null;
	/* Column Info */
	private String chkRej = null;
	/* Column Info */
	private String n3pty = null;
	/* Column Info */
	private String n2ndRvwChk = null;
	/* Column Info */
	private String tpbNxtPrcChk = null;
	/* Column Info */
	private String diffRhqChk = null;
	/* Column Info */
	private String adjStsSeq = null;
	/* Column Info */
	private String adjN2ndRvwSeq = null;
	/* Column Info */
	private String adjN2ndRvwStsCd = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchResponsibleOfficeChangeVO() {}

	public SearchResponsibleOfficeChangeVO(String ibflag, String pagerows, String fCmd, String ipage, String sUserOfcCd, String sOfficeLevel, String sRhqCdForRhq, String sOfcCdForRhq, String sN3ptyNoStrs, String sFileNo, String sRaRmk1, String sRaRmk2, String stlRqstRmk, String n3ptyStlTpCd, String sDateKindFlag, String sSTrdPartyVal, String sSVndrCustDivCd, String sN3ptyNoStrsLink, String stlToCltCngOfcCd, String approval, String chkReq, String chkApp, String chkRej, String n3ptyNo, String reqDate, String reqOfc, String reqId, String appDate, String appOfc, String appId, String rejDate, String rejOfc, String rejId, String n3ptySrcSubSysCd, String n3ptyBilTpNm, String n3ptyInvNo, String otsStsCd, String otsStsCdVal, String bkgNo, String blNo, String eqNo, String ifRhqCd, String ifOfcCd, String n3pty, String currCd, String otsAmt, String cfmDt, String invAmt, String cltAmt, String stlAmt, String balAmt, String stlCltOfcCngAmt, String cltActYn, String stlRqstDt, String reviewStep, String cDateKindFlag, String sDateFlagR, String sDateFlagI, String sCalendarDate1, String sCalendarDate2, String dateType, String sIfRhqCd, String sIfCtrlCd, String sIfOfcCd, String sTrdPartyVal, String sVndrCustDivCd, String sN3ptyNo, String sCurrCdTp, String n2ndRvwChk, String tpbNxtPrcChk, String diffRhqChk, String adjStsSeq, String adjN2ndRvwSeq, String adjN2ndRvwStsCd) {
		this.sCurrCdTp = sCurrCdTp;
		this.rejOfc = rejOfc;
		this.ifOfcCd = ifOfcCd;
		this.sTrdPartyVal = sTrdPartyVal;
		this.fCmd = fCmd;
		this.sUserOfcCd = sUserOfcCd;
		this.sFileNo = sFileNo;
		this.stlCltOfcCngAmt = stlCltOfcCngAmt;
		this.blNo = blNo;
		this.n3ptyInvNo = n3ptyInvNo;
		this.pagerows = pagerows;
		this.sRaRmk2 = sRaRmk2;
		this.stlToCltCngOfcCd = stlToCltCngOfcCd;
		this.sN3ptyNoStrsLink = sN3ptyNoStrsLink;
		this.cltActYn = cltActYn;
		this.sSTrdPartyVal = sSTrdPartyVal;
		this.sRaRmk1 = sRaRmk1;
		this.appOfc = appOfc;
		this.sOfficeLevel = sOfficeLevel;
		this.cDateKindFlag = cDateKindFlag;
		this.cfmDt = cfmDt;
		this.sVndrCustDivCd = sVndrCustDivCd;
		this.otsStsCdVal = otsStsCdVal;
		this.ifRhqCd = ifRhqCd;
		this.stlAmt = stlAmt;
		this.n3ptyStlTpCd = n3ptyStlTpCd;
		this.bkgNo = bkgNo;
		this.otsAmt = otsAmt;
		this.sIfRhqCd = sIfRhqCd;
		this.n3ptySrcSubSysCd = n3ptySrcSubSysCd;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.sSVndrCustDivCd = sSVndrCustDivCd;
		this.otsStsCd = otsStsCd;
		this.appId = appId;
		this.currCd = currCd;
		this.cltAmt = cltAmt;
		this.sDateKindFlag = sDateKindFlag;
		this.reviewStep = reviewStep;
		this.ipage = ipage;
		this.reqDate = reqDate;
		this.sIfCtrlCd = sIfCtrlCd;
		this.rejDate = rejDate;
		this.sCalendarDate1 = sCalendarDate1;
		this.sCalendarDate2 = sCalendarDate2;
		this.balAmt = balAmt;
		this.ibflag = ibflag;
		this.sN3ptyNoStrs = sN3ptyNoStrs;
		this.eqNo = eqNo;
		this.n3ptyNo = n3ptyNo;
		this.invAmt = invAmt;
		this.reqOfc = reqOfc;
		this.appDate = appDate;
		this.sDateFlagI = sDateFlagI;
		this.reqId = reqId;
		this.sN3ptyNo = sN3ptyNo;
		this.sDateFlagR = sDateFlagR;
		this.rejId = rejId;
		this.approval = approval;
		this.sIfOfcCd = sIfOfcCd;
		this.dateType = dateType;
		this.stlRqstDt = stlRqstDt;
		this.sOfcCdForRhq = sOfcCdForRhq;
		this.stlRqstRmk = stlRqstRmk;
		this.chkReq = chkReq;
		this.sRhqCdForRhq = sRhqCdForRhq;
		this.chkApp = chkApp;
		this.chkRej = chkRej;
		this.n3pty = n3pty;
		this.n2ndRvwChk = n2ndRvwChk;
		this.tpbNxtPrcChk = tpbNxtPrcChk;
		this.diffRhqChk = diffRhqChk;
		this.adjStsSeq = adjStsSeq;
		this.adjN2ndRvwSeq = adjN2ndRvwSeq;
		this.adjN2ndRvwStsCd = adjN2ndRvwStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_curr_cd_tp", getSCurrCdTp());
		this.hashColumns.put("rej_ofc", getRejOfc());
		this.hashColumns.put("if_ofc_cd", getIfOfcCd());
		this.hashColumns.put("s_trd_party_val", getSTrdPartyVal());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("s_user_ofc_cd", getSUserOfcCd());
		this.hashColumns.put("s_file_no", getSFileNo());
		this.hashColumns.put("stl_clt_ofc_cng_amt", getStlCltOfcCngAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("n3pty_inv_no", getN3ptyInvNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_ra_rmk2", getSRaRmk2());
		this.hashColumns.put("stl_to_clt_cng_ofc_cd", getStlToCltCngOfcCd());
		this.hashColumns.put("s_n3pty_no_strs_link", getSN3ptyNoStrsLink());
		this.hashColumns.put("clt_act_yn", getCltActYn());
		this.hashColumns.put("s_s_trd_party_val", getSSTrdPartyVal());
		this.hashColumns.put("s_ra_rmk1", getSRaRmk1());
		this.hashColumns.put("app_ofc", getAppOfc());
		this.hashColumns.put("s_office_level", getSOfficeLevel());
		this.hashColumns.put("c_date_kind_flag", getCDateKindFlag());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("s_vndr_cust_div_cd", getSVndrCustDivCd());
		this.hashColumns.put("ots_sts_cd_val", getOtsStsCdVal());
		this.hashColumns.put("if_rhq_cd", getIfRhqCd());
		this.hashColumns.put("stl_amt", getStlAmt());
		this.hashColumns.put("n3pty_stl_tp_cd", getN3ptyStlTpCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ots_amt", getOtsAmt());
		this.hashColumns.put("s_if_rhq_cd", getSIfRhqCd());
		this.hashColumns.put("n3pty_src_sub_sys_cd", getN3ptySrcSubSysCd());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("s_s_vndr_cust_div_cd", getSSVndrCustDivCd());
		this.hashColumns.put("ots_sts_cd", getOtsStsCd());
		this.hashColumns.put("app_id", getAppId());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("clt_amt", getCltAmt());
		this.hashColumns.put("s_date_kind_flag", getSDateKindFlag());
		this.hashColumns.put("review_step", getReviewStep());
		this.hashColumns.put("ipage", getIpage());
		this.hashColumns.put("req_date", getReqDate());
		this.hashColumns.put("s_if_ctrl_cd", getSIfCtrlCd());
		this.hashColumns.put("rej_date", getRejDate());
		this.hashColumns.put("s_calendar_date1", getSCalendarDate1());
		this.hashColumns.put("s_calendar_date2", getSCalendarDate2());
		this.hashColumns.put("bal_amt", getBalAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_n3pty_no_strs", getSN3ptyNoStrs());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("req_ofc", getReqOfc());
		this.hashColumns.put("app_date", getAppDate());
		this.hashColumns.put("s_date_flag_i", getSDateFlagI());
		this.hashColumns.put("req_id", getReqId());
		this.hashColumns.put("s_n3pty_no", getSN3ptyNo());
		this.hashColumns.put("s_date_flag_r", getSDateFlagR());
		this.hashColumns.put("rej_id", getRejId());
		this.hashColumns.put("approval", getApproval());
		this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
		this.hashColumns.put("date_type", getDateType());
		this.hashColumns.put("stl_rqst_dt", getStlRqstDt());
		this.hashColumns.put("s_ofc_cd_for_rhq", getSOfcCdForRhq());
		this.hashColumns.put("stl_rqst_rmk", getStlRqstRmk());
		this.hashColumns.put("chk_req", getChkReq());
		this.hashColumns.put("s_rhq_cd_for_rhq", getSRhqCdForRhq());
		this.hashColumns.put("chk_app", getChkApp());
		this.hashColumns.put("chk_rej", getChkRej());
		this.hashColumns.put("n3pty", getN3pty());
		this.hashColumns.put("n2nd_rvw_chk", getN2ndRvwChk());
		this.hashColumns.put("tpb_nxt_prc_chk", getTpbNxtPrcChk());
		this.hashColumns.put("diff_rhq_chk", getDiffRhqChk());
		this.hashColumns.put("adj_sts_seq", getAdjStsSeq());
		this.hashColumns.put("adj_n2nd_rvw_seq", getAdjN2ndRvwSeq());
		this.hashColumns.put("adj_n2nd_rvw_sts_cd", getAdjN2ndRvwStsCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_curr_cd_tp", "sCurrCdTp");
		this.hashFields.put("rej_ofc", "rejOfc");
		this.hashFields.put("if_ofc_cd", "ifOfcCd");
		this.hashFields.put("s_trd_party_val", "sTrdPartyVal");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("s_user_ofc_cd", "sUserOfcCd");
		this.hashFields.put("s_file_no", "sFileNo");
		this.hashFields.put("stl_clt_ofc_cng_amt", "stlCltOfcCngAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("n3pty_inv_no", "n3ptyInvNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_ra_rmk2", "sRaRmk2");
		this.hashFields.put("stl_to_clt_cng_ofc_cd", "stlToCltCngOfcCd");
		this.hashFields.put("s_n3pty_no_strs_link", "sN3ptyNoStrsLink");
		this.hashFields.put("clt_act_yn", "cltActYn");
		this.hashFields.put("s_s_trd_party_val", "sSTrdPartyVal");
		this.hashFields.put("s_ra_rmk1", "sRaRmk1");
		this.hashFields.put("app_ofc", "appOfc");
		this.hashFields.put("s_office_level", "sOfficeLevel");
		this.hashFields.put("c_date_kind_flag", "cDateKindFlag");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("s_vndr_cust_div_cd", "sVndrCustDivCd");
		this.hashFields.put("ots_sts_cd_val", "otsStsCdVal");
		this.hashFields.put("if_rhq_cd", "ifRhqCd");
		this.hashFields.put("stl_amt", "stlAmt");
		this.hashFields.put("n3pty_stl_tp_cd", "n3ptyStlTpCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ots_amt", "otsAmt");
		this.hashFields.put("s_if_rhq_cd", "sIfRhqCd");
		this.hashFields.put("n3pty_src_sub_sys_cd", "n3ptySrcSubSysCd");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");  
		this.hashFields.put("s_s_vndr_cust_div_cd", "sSVndrCustDivCd");
		this.hashFields.put("ots_sts_cd", "otsStsCd");
		this.hashFields.put("app_id", "appId");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("clt_amt", "cltAmt");
		this.hashFields.put("s_date_kind_flag", "sDateKindFlag");
		this.hashFields.put("review_step", "reviewStep");
		this.hashFields.put("ipage", "ipage");
		this.hashFields.put("req_date", "reqDate");
		this.hashFields.put("s_if_ctrl_cd", "sIfCtrlCd");
		this.hashFields.put("rej_date", "rejDate");
		this.hashFields.put("s_calendar_date1", "sCalendarDate1");
		this.hashFields.put("s_calendar_date2", "sCalendarDate2");
		this.hashFields.put("bal_amt", "balAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_n3pty_no_strs", "sN3ptyNoStrs");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("req_ofc", "reqOfc");
		this.hashFields.put("app_date", "appDate");
		this.hashFields.put("s_date_flag_i", "sDateFlagI");
		this.hashFields.put("req_id", "reqId");
		this.hashFields.put("s_n3pty_no", "sN3ptyNo");
		this.hashFields.put("s_date_flag_r", "sDateFlagR");
		this.hashFields.put("rej_id", "rejId");
		this.hashFields.put("approval", "approval");
		this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
		this.hashFields.put("date_type", "dateType");
		this.hashFields.put("stl_rqst_dt", "stlRqstDt");
		this.hashFields.put("s_ofc_cd_for_rhq", "sOfcCdForRhq");
		this.hashFields.put("stl_rqst_rmk", "stlRqstRmk");
		this.hashFields.put("chk_req", "chkReq");
		this.hashFields.put("s_rhq_cd_for_rhq", "sRhqCdForRhq");
		this.hashFields.put("chk_app", "chkApp");
		this.hashFields.put("chk_rej", "chkRej");
		this.hashFields.put("n3pty", "n3pty");
		this.hashFields.put("n2nd_rvw_chk", "n2ndRvwChk");
		this.hashFields.put("tpb_nxt_prc_chk", "tpbNxtPrcChk");
		this.hashFields.put("diff_rhq_chk", "diffRhqChk");
		this.hashFields.put("adj_sts_seq", "adjStsSeq");
		this.hashFields.put("adj_n2nd_rvw_seq", "adjN2ndRvwSeq");
		this.hashFields.put("adj_n2nd_rvw_sts_cd", "adjN2ndRvwStsCd");
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
	 * @return rejOfc
	 */
	public String getRejOfc() {
		return this.rejOfc;
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
	 * @return sUserOfcCd
	 */
	public String getSUserOfcCd() {
		return this.sUserOfcCd;
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
	 * @return stlCltOfcCngAmt
	 */
	public String getStlCltOfcCngAmt() {
		return this.stlCltOfcCngAmt;
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
	 * @return n3ptyInvNo
	 */
	public String getN3ptyInvNo() {
		return this.n3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return sRaRmk2
	 */
	public String getSRaRmk2() {
		return this.sRaRmk2;
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
	 * @return sN3ptyNoStrsLink
	 */
	public String getSN3ptyNoStrsLink() {
		return this.sN3ptyNoStrsLink;
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
	 * @return sSTrdPartyVal
	 */
	public String getSSTrdPartyVal() {
		return this.sSTrdPartyVal;
	}
	
	/**
	 * Column Info
	 * @return sRaRmk1
	 */
	public String getSRaRmk1() {
		return this.sRaRmk1;
	}
	
	/**
	 * Column Info
	 * @return appOfc
	 */
	public String getAppOfc() {
		return this.appOfc;
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
	 * @return cDateKindFlag
	 */
	public String getCDateKindFlag() {
		return this.cDateKindFlag;
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
	 * @return sVndrCustDivCd
	 */
	public String getSVndrCustDivCd() {
		return this.sVndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @return otsStsCdVal
	 */
	public String getOtsStsCdVal() {
		return this.otsStsCdVal;
	}
	
	/**
	 * Column Info
	 * @return ifRhqCd
	 */
	public String getIfRhqCd() {
		return this.ifRhqCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	
	
	
	public String getN3ptyBilTpNm() {
		return n3ptyBilTpNm;
	}

	/**
	 * Column Info
	 * @return sSVndrCustDivCd
	 */
	public String getSSVndrCustDivCd() {
		return this.sSVndrCustDivCd;
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
	 * @return appId
	 */
	public String getAppId() {
		return this.appId;
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
	 * @return cltAmt
	 */
	public String getCltAmt() {
		return this.cltAmt;
	}
	
	/**
	 * Column Info
	 * @return sDateKindFlag
	 */
	public String getSDateKindFlag() {
		return this.sDateKindFlag;
	}
	
	/**
	 * Column Info
	 * @return reviewStep
	 */
	public String getReviewStep() {
		return this.reviewStep;
	}
	
	/**
	 * Column Info
	 * @return ipage
	 */
	public String getIpage() {
		return this.ipage;
	}
	
	/**
	 * Column Info
	 * @return reqDate
	 */
	public String getReqDate() {
		return this.reqDate;
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
	 * @return rejDate
	 */
	public String getRejDate() {
		return this.rejDate;
	}
	
	/**
	 * Column Info
	 * @return sCalendarDate1
	 */
	public String getSCalendarDate1() {
		return this.sCalendarDate1;
	}
	
	/**
	 * Column Info
	 * @return sCalendarDate2
	 */
	public String getSCalendarDate2() {
		return this.sCalendarDate2;
	}
	
	/**
	 * Column Info
	 * @return balAmt
	 */
	public String getBalAmt() {
		return this.balAmt;
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
	 * @return sN3ptyNoStrs
	 */
	public String getSN3ptyNoStrs() {
		return this.sN3ptyNoStrs;
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
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return reqOfc
	 */
	public String getReqOfc() {
		return this.reqOfc;
	}
	
	/**
	 * Column Info
	 * @return appDate
	 */
	public String getAppDate() {
		return this.appDate;
	}
	
	/**
	 * Column Info
	 * @return sDateFlagI
	 */
	public String getSDateFlagI() {
		return this.sDateFlagI;
	}
	
	/**
	 * Column Info
	 * @return reqId
	 */
	public String getReqId() {
		return this.reqId;
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
	 * @return sDateFlagR
	 */
	public String getSDateFlagR() {
		return this.sDateFlagR;
	}
	
	/**
	 * Column Info
	 * @return rejId
	 */
	public String getRejId() {
		return this.rejId;
	}
	
	/**
	 * Column Info
	 * @return approval
	 */
	public String getApproval() {
		return this.approval;
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
	 * @return dateType
	 */
	public String getDateType() {
		return this.dateType;
	}
	
	/**
	 * Column Info
	 * @return stlRqstDt
	 */
	public String getStlRqstDt() {
		return this.stlRqstDt;
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
	 * @return stlRqstRmk
	 */
	public String getStlRqstRmk() {
		return this.stlRqstRmk;
	}
	
	/**
	 * Column Info
	 * @return chkReq
	 */
	public String getChkReq() {
		return this.chkReq;
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
	 * @return chkApp
	 */
	public String getChkApp() {
		return this.chkApp;
	}
	
	/**
	 * Column Info
	 * @return chkRej
	 */
	public String getChkRej() {
		return this.chkRej;
	}
	
	/**
	 * Column Info
	 * @return n3pty
	 */
	public String getN3pty() {
		return this.n3pty;
	}
	
	/**
	 * Column Info
	 * @return n2ndRvwChk
	 */
	public String getN2ndRvwChk() {
		return this.n2ndRvwChk;
	}
	
	/**
	 * Column Info
	 * @return tpbNxtPrcChk
	 */
	public String getTpbNxtPrcChk() {
		return this.tpbNxtPrcChk;
	}
	
	/**
	 * Column Info
	 * @return diffRhqChk
	 */
	public String getDiffRhqChk() {
		return this.diffRhqChk;
	}
	
	/**
	 * Column Info
	 * @return adjStsSeq
	 */
	public String getAdjStsSeq() {
		return this.adjStsSeq;
	}
	
	/**
	 * Column Info
	 * @return adjN2ndRvwSeq
	 */
	public String getAdjN2ndRvwSeq() {
		return this.adjN2ndRvwSeq;
	}
	
	/**
	 * Column Info
	 * @return adjN2ndRvwStsCd
	 */
	public String getAdjN2ndRvwStsCd() {
		return this.adjN2ndRvwStsCd;
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
	 * @param rejOfc
	 */
	public void setRejOfc(String rejOfc) {
		this.rejOfc = rejOfc;
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
	 * @param sUserOfcCd
	 */
	public void setSUserOfcCd(String sUserOfcCd) {
		this.sUserOfcCd = sUserOfcCd;
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
	 * @param stlCltOfcCngAmt
	 */
	public void setStlCltOfcCngAmt(String stlCltOfcCngAmt) {
		this.stlCltOfcCngAmt = stlCltOfcCngAmt;
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
	 * @param n3ptyInvNo
	 */
	public void setN3ptyInvNo(String n3ptyInvNo) {
		this.n3ptyInvNo = n3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param sRaRmk2
	 */
	public void setSRaRmk2(String sRaRmk2) {
		this.sRaRmk2 = sRaRmk2;
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
	 * @param sN3ptyNoStrsLink
	 */
	public void setSN3ptyNoStrsLink(String sN3ptyNoStrsLink) {
		this.sN3ptyNoStrsLink = sN3ptyNoStrsLink;
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
	 * @param sSTrdPartyVal
	 */
	public void setSSTrdPartyVal(String sSTrdPartyVal) {
		this.sSTrdPartyVal = sSTrdPartyVal;
	}
	
	/**
	 * Column Info
	 * @param sRaRmk1
	 */
	public void setSRaRmk1(String sRaRmk1) {
		this.sRaRmk1 = sRaRmk1;
	}
	
	/**
	 * Column Info
	 * @param appOfc
	 */
	public void setAppOfc(String appOfc) {
		this.appOfc = appOfc;
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
	 * @param cDateKindFlag
	 */
	public void setCDateKindFlag(String cDateKindFlag) {
		this.cDateKindFlag = cDateKindFlag;
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
	 * @param sVndrCustDivCd
	 */
	public void setSVndrCustDivCd(String sVndrCustDivCd) {
		this.sVndrCustDivCd = sVndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @param otsStsCdVal
	 */
	public void setOtsStsCdVal(String otsStsCdVal) {
		this.otsStsCdVal = otsStsCdVal;
	}
	
	/**
	 * Column Info
	 * @param ifRhqCd
	 */
	public void setIfRhqCd(String ifRhqCd) {
		this.ifRhqCd = ifRhqCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	
	
	public void setN3ptyBilTpNm(String n3ptyBilTpNm) {
		this.n3ptyBilTpNm = n3ptyBilTpNm;
	}

	/**
	 * Column Info
	 * @param sSVndrCustDivCd
	 */
	public void setSSVndrCustDivCd(String sSVndrCustDivCd) {
		this.sSVndrCustDivCd = sSVndrCustDivCd;
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
	 * @param appId
	 */
	public void setAppId(String appId) {
		this.appId = appId;
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
	 * @param cltAmt
	 */
	public void setCltAmt(String cltAmt) {
		this.cltAmt = cltAmt;
	}
	
	/**
	 * Column Info
	 * @param sDateKindFlag
	 */
	public void setSDateKindFlag(String sDateKindFlag) {
		this.sDateKindFlag = sDateKindFlag;
	}
	
	/**
	 * Column Info
	 * @param reviewStep
	 */
	public void setReviewStep(String reviewStep) {
		this.reviewStep = reviewStep;
	}
	
	/**
	 * Column Info
	 * @param ipage
	 */
	public void setIpage(String ipage) {
		this.ipage = ipage;
	}
	
	/**
	 * Column Info
	 * @param reqDate
	 */
	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
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
	 * @param rejDate
	 */
	public void setRejDate(String rejDate) {
		this.rejDate = rejDate;
	}
	
	/**
	 * Column Info
	 * @param sCalendarDate1
	 */
	public void setSCalendarDate1(String sCalendarDate1) {
		this.sCalendarDate1 = sCalendarDate1;
	}
	
	/**
	 * Column Info
	 * @param sCalendarDate2
	 */
	public void setSCalendarDate2(String sCalendarDate2) {
		this.sCalendarDate2 = sCalendarDate2;
	}
	
	/**
	 * Column Info
	 * @param balAmt
	 */
	public void setBalAmt(String balAmt) {
		this.balAmt = balAmt;
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
	 * @param sN3ptyNoStrs
	 */
	public void setSN3ptyNoStrs(String sN3ptyNoStrs) {
		this.sN3ptyNoStrs = sN3ptyNoStrs;
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
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param reqOfc
	 */
	public void setReqOfc(String reqOfc) {
		this.reqOfc = reqOfc;
	}
	
	/**
	 * Column Info
	 * @param appDate
	 */
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	
	/**
	 * Column Info
	 * @param sDateFlagI
	 */
	public void setSDateFlagI(String sDateFlagI) {
		this.sDateFlagI = sDateFlagI;
	}
	
	/**
	 * Column Info
	 * @param reqId
	 */
	public void setReqId(String reqId) {
		this.reqId = reqId;
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
	 * @param sDateFlagR
	 */
	public void setSDateFlagR(String sDateFlagR) {
		this.sDateFlagR = sDateFlagR;
	}
	
	/**
	 * Column Info
	 * @param rejId
	 */
	public void setRejId(String rejId) {
		this.rejId = rejId;
	}
	
	/**
	 * Column Info
	 * @param approval
	 */
	public void setApproval(String approval) {
		this.approval = approval;
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
	 * @param dateType
	 */
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	
	/**
	 * Column Info
	 * @param stlRqstDt
	 */
	public void setStlRqstDt(String stlRqstDt) {
		this.stlRqstDt = stlRqstDt;
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
	 * @param stlRqstRmk
	 */
	public void setStlRqstRmk(String stlRqstRmk) {
		this.stlRqstRmk = stlRqstRmk;
	}
	
	/**
	 * Column Info
	 * @param chkReq
	 */
	public void setChkReq(String chkReq) {
		this.chkReq = chkReq;
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
	 * @param chkApp
	 */
	public void setChkApp(String chkApp) {
		this.chkApp = chkApp;
	}
	
	/**
	 * Column Info
	 * @param chkRej
	 */
	public void setChkRej(String chkRej) {
		this.chkRej = chkRej;
	}
	
	/**
	 * Column Info
	 * @param n3pty
	 */
	public void setN3pty(String n3pty) {
		this.n3pty = n3pty;
	}
	
	/**
	 * Column Info
	 * @param n2ndRvwChk
	 */
	public void setN2ndRvwChk(String n2ndRvwChk) {
		this.n2ndRvwChk = n2ndRvwChk;
	}
	
	/**
	 * Column Info
	 * @param tpbNxtPrcChk
	 */
	public void setTpbNxtPrcChk(String tpbNxtPrcChk) {
		this.tpbNxtPrcChk = tpbNxtPrcChk;
	}
	
	/**
	 * Column Info
	 * @param diffRhqChk
	 */
	public void setDiffRhqChk(String diffRhqChk) {
		this.diffRhqChk = diffRhqChk;
	}
	
	/**
	 * Column Info
	 * @param adjStsSeq
	 */
	public void setAdjStsSeq(String adjStsSeq) {
		this.adjStsSeq = adjStsSeq;
	}
	
	/**
	 * Column Info
	 * @param adjN2ndRvwSeq
	 */
	public void setAdjN2ndRvwSeq(String adjN2ndRvwSeq) {
		this.adjN2ndRvwSeq = adjN2ndRvwSeq;
	}
	
	/**
	 * Column Info
	 * @param adjN2ndRvwStsCd
	 */
	public void setAdjN2ndRvwStsCd(String adjN2ndRvwStsCd) {
		this.adjN2ndRvwStsCd = adjN2ndRvwStsCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSCurrCdTp(JSPUtil.getParameter(request, "s_curr_cd_tp", ""));
		setRejOfc(JSPUtil.getParameter(request, "rej_ofc", ""));
		setIfOfcCd(JSPUtil.getParameter(request, "if_ofc_cd", ""));
		setSTrdPartyVal(JSPUtil.getParameter(request, "s_trd_party_val", ""));
		setFCmd(JSPUtil.getParameter(request, "f_cmd", ""));
		setSUserOfcCd(JSPUtil.getParameter(request, "s_user_ofc_cd", ""));
		setSFileNo(JSPUtil.getParameter(request, "s_file_no", ""));
		setStlCltOfcCngAmt(JSPUtil.getParameter(request, "stl_clt_ofc_cng_amt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setN3ptyInvNo(JSPUtil.getParameter(request, "n3pty_inv_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSRaRmk2(JSPUtil.getParameter(request, "s_ra_rmk2", ""));
		setStlToCltCngOfcCd(JSPUtil.getParameter(request, "stl_to_clt_cng_ofc_cd", ""));
		setSN3ptyNoStrsLink(JSPUtil.getParameter(request, "s_n3pty_no_strs_link", ""));
		setCltActYn(JSPUtil.getParameter(request, "clt_act_yn", ""));
		setSSTrdPartyVal(JSPUtil.getParameter(request, "s_s_trd_party_val", ""));
		setSRaRmk1(JSPUtil.getParameter(request, "s_ra_rmk1", ""));
		setAppOfc(JSPUtil.getParameter(request, "app_ofc", ""));
		setSOfficeLevel(JSPUtil.getParameter(request, "s_office_level", ""));
		setCDateKindFlag(JSPUtil.getParameter(request, "c_date_kind_flag", ""));
		setCfmDt(JSPUtil.getParameter(request, "cfm_dt", ""));
		setSVndrCustDivCd(JSPUtil.getParameter(request, "s_vndr_cust_div_cd", ""));
		setOtsStsCdVal(JSPUtil.getParameter(request, "ots_sts_cd_val", ""));
		setIfRhqCd(JSPUtil.getParameter(request, "if_rhq_cd", ""));
		setStlAmt(JSPUtil.getParameter(request, "stl_amt", ""));
		setN3ptyStlTpCd(JSPUtil.getParameter(request, "n3pty_stl_tp_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setOtsAmt(JSPUtil.getParameter(request, "ots_amt", ""));
		setSIfRhqCd(JSPUtil.getParameter(request, "s_if_rhq_cd", ""));
		setN3ptySrcSubSysCd(JSPUtil.getParameter(request, "n3pty_src_sub_sys_cd", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, "n3pty_bil_tp_nm", ""));
		setSSVndrCustDivCd(JSPUtil.getParameter(request, "s_s_vndr_cust_div_cd", ""));
		setOtsStsCd(JSPUtil.getParameter(request, "ots_sts_cd", ""));
		setAppId(JSPUtil.getParameter(request, "app_id", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCltAmt(JSPUtil.getParameter(request, "clt_amt", ""));
		setSDateKindFlag(JSPUtil.getParameter(request, "s_date_kind_flag", ""));
		setReviewStep(JSPUtil.getParameter(request, "review_step", ""));
		setIpage(JSPUtil.getParameter(request, "ipage", ""));
		setReqDate(JSPUtil.getParameter(request, "req_date", ""));
		setSIfCtrlCd(JSPUtil.getParameter(request, "s_if_ctrl_cd", ""));
		setRejDate(JSPUtil.getParameter(request, "rej_date", ""));
		setSCalendarDate1(JSPUtil.getParameter(request, "s_calendar_date1", ""));
		setSCalendarDate2(JSPUtil.getParameter(request, "s_calendar_date2", ""));
		setBalAmt(JSPUtil.getParameter(request, "bal_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSN3ptyNoStrs(JSPUtil.getParameter(request, "s_n3pty_no_strs", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setReqOfc(JSPUtil.getParameter(request, "req_ofc", ""));
		setAppDate(JSPUtil.getParameter(request, "app_date", ""));
		setSDateFlagI(JSPUtil.getParameter(request, "s_date_flag_i", ""));
		setReqId(JSPUtil.getParameter(request, "req_id", ""));
		setSN3ptyNo(JSPUtil.getParameter(request, "s_n3pty_no", ""));
		setSDateFlagR(JSPUtil.getParameter(request, "s_date_flag_r", ""));
		setRejId(JSPUtil.getParameter(request, "rej_id", ""));
		setApproval(JSPUtil.getParameter(request, "approval", ""));
		setSIfOfcCd(JSPUtil.getParameter(request, "s_if_ofc_cd", ""));
		setDateType(JSPUtil.getParameter(request, "date_type", ""));
		setStlRqstDt(JSPUtil.getParameter(request, "stl_rqst_dt", ""));
		setSOfcCdForRhq(JSPUtil.getParameter(request, "s_ofc_cd_for_rhq", ""));
		setStlRqstRmk(JSPUtil.getParameter(request, "stl_rqst_rmk", ""));
		setChkReq(JSPUtil.getParameter(request, "chk_req", ""));
		setSRhqCdForRhq(JSPUtil.getParameter(request, "s_rhq_cd_for_rhq", ""));
		setChkApp(JSPUtil.getParameter(request, "chk_app", ""));
		setChkRej(JSPUtil.getParameter(request, "chk_rej", ""));
		setN3pty(JSPUtil.getParameter(request, "n3pty", ""));
		setN2ndRvwChk(JSPUtil.getParameter(request, "n2nd_rvw_chk", ""));
		setTpbNxtPrcChk(JSPUtil.getParameter(request, "tpb_nxt_prc_chk", ""));
		setDiffRhqChk(JSPUtil.getParameter(request, "diff_rhq_chk", ""));
		setAdjStsSeq(JSPUtil.getParameter(request, "adj_sts_seq", ""));
		setAdjN2ndRvwSeq(JSPUtil.getParameter(request, "adj_n2nd_rvw_seq", ""));
		setAdjN2ndRvwStsCd(JSPUtil.getParameter(request, "adj_n2nd_rvw_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchResponsibleOfficeChangeVO[]
	 */
	public SearchResponsibleOfficeChangeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchResponsibleOfficeChangeVO[]
	 */
	public SearchResponsibleOfficeChangeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchResponsibleOfficeChangeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sCurrCdTp = (JSPUtil.getParameter(request, prefix	+ "s_curr_cd_tp", length));
			String[] rejOfc = (JSPUtil.getParameter(request, prefix	+ "rej_ofc", length));
			String[] ifOfcCd = (JSPUtil.getParameter(request, prefix	+ "if_ofc_cd", length));
			String[] sTrdPartyVal = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_val", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] sUserOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_user_ofc_cd", length));
			String[] sFileNo = (JSPUtil.getParameter(request, prefix	+ "s_file_no", length));
			String[] stlCltOfcCngAmt = (JSPUtil.getParameter(request, prefix	+ "stl_clt_ofc_cng_amt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] n3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sRaRmk2 = (JSPUtil.getParameter(request, prefix	+ "s_ra_rmk2", length));
			String[] stlToCltCngOfcCd = (JSPUtil.getParameter(request, prefix	+ "stl_to_clt_cng_ofc_cd", length));
			String[] sN3ptyNoStrsLink = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no_strs_link", length));
			String[] cltActYn = (JSPUtil.getParameter(request, prefix	+ "clt_act_yn", length));
			String[] sSTrdPartyVal = (JSPUtil.getParameter(request, prefix	+ "s_s_trd_party_val", length));
			String[] sRaRmk1 = (JSPUtil.getParameter(request, prefix	+ "s_ra_rmk1", length));
			String[] appOfc = (JSPUtil.getParameter(request, prefix	+ "app_ofc", length));
			String[] sOfficeLevel = (JSPUtil.getParameter(request, prefix	+ "s_office_level", length));
			String[] cDateKindFlag = (JSPUtil.getParameter(request, prefix	+ "c_date_kind_flag", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] sVndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_div_cd", length));
			String[] otsStsCdVal = (JSPUtil.getParameter(request, prefix	+ "ots_sts_cd_val", length));
			String[] ifRhqCd = (JSPUtil.getParameter(request, prefix	+ "if_rhq_cd", length));
			String[] stlAmt = (JSPUtil.getParameter(request, prefix	+ "stl_amt", length));
			String[] n3ptyStlTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_stl_tp_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] otsAmt = (JSPUtil.getParameter(request, prefix	+ "ots_amt", length));
			String[] sIfRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_if_rhq_cd", length));
			String[] n3ptySrcSubSysCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_sub_sys_cd", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] sSVndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "s_s_vndr_cust_div_cd", length));
			String[] otsStsCd = (JSPUtil.getParameter(request, prefix	+ "ots_sts_cd", length));
			String[] appId = (JSPUtil.getParameter(request, prefix	+ "app_id", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cltAmt = (JSPUtil.getParameter(request, prefix	+ "clt_amt", length));
			String[] sDateKindFlag = (JSPUtil.getParameter(request, prefix	+ "s_date_kind_flag", length));
			String[] reviewStep = (JSPUtil.getParameter(request, prefix	+ "review_step", length));
			String[] ipage = (JSPUtil.getParameter(request, prefix	+ "ipage", length));
			String[] reqDate = (JSPUtil.getParameter(request, prefix	+ "req_date", length));
			String[] sIfCtrlCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ctrl_cd", length));
			String[] rejDate = (JSPUtil.getParameter(request, prefix	+ "rej_date", length));
			String[] sCalendarDate1 = (JSPUtil.getParameter(request, prefix	+ "s_calendar_date1", length));
			String[] sCalendarDate2 = (JSPUtil.getParameter(request, prefix	+ "s_calendar_date2", length));
			String[] balAmt = (JSPUtil.getParameter(request, prefix	+ "bal_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sN3ptyNoStrs = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no_strs", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] reqOfc = (JSPUtil.getParameter(request, prefix	+ "req_ofc", length));
			String[] appDate = (JSPUtil.getParameter(request, prefix	+ "app_date", length));
			String[] sDateFlagI = (JSPUtil.getParameter(request, prefix	+ "s_date_flag_i", length));
			String[] reqId = (JSPUtil.getParameter(request, prefix	+ "req_id", length));
			String[] sN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no", length));
			String[] sDateFlagR = (JSPUtil.getParameter(request, prefix	+ "s_date_flag_r", length));
			String[] rejId = (JSPUtil.getParameter(request, prefix	+ "rej_id", length));
			String[] approval = (JSPUtil.getParameter(request, prefix	+ "approval", length));
			String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ofc_cd", length));
			String[] dateType = (JSPUtil.getParameter(request, prefix	+ "date_type", length));
			String[] stlRqstDt = (JSPUtil.getParameter(request, prefix	+ "stl_rqst_dt", length));
			String[] sOfcCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd_for_rhq", length));
			String[] stlRqstRmk = (JSPUtil.getParameter(request, prefix	+ "stl_rqst_rmk", length));
			String[] chkReq = (JSPUtil.getParameter(request, prefix	+ "chk_req", length));
			String[] sRhqCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_rhq_cd_for_rhq", length));
			String[] chkApp = (JSPUtil.getParameter(request, prefix	+ "chk_app", length));
			String[] chkRej = (JSPUtil.getParameter(request, prefix	+ "chk_rej", length));
			String[] n3pty = (JSPUtil.getParameter(request, prefix	+ "n3pty", length));
			String[] n2ndRvwChk = (JSPUtil.getParameter(request, prefix	+ "n2nd_rvw_chk", length));
			String[] tpbNxtPrcChk = (JSPUtil.getParameter(request, prefix	+ "tpb_nxt_prc_chk", length));
			String[] diffRhqChk = (JSPUtil.getParameter(request, prefix	+ "diff_rhq_chk", length));
			String[] adjStsSeq = (JSPUtil.getParameter(request, prefix	+ "adj_sts_seq", length));
			String[] adjN2ndRvwSeq = (JSPUtil.getParameter(request, prefix	+ "adj_n2nd_rvw_seq", length));
			String[] adjN2ndRvwStsCd = (JSPUtil.getParameter(request, prefix	+ "adj_n2nd_rvw_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchResponsibleOfficeChangeVO();
				if (sCurrCdTp[i] != null)
					model.setSCurrCdTp(sCurrCdTp[i]);
				if (rejOfc[i] != null)
					model.setRejOfc(rejOfc[i]);
				if (ifOfcCd[i] != null)
					model.setIfOfcCd(ifOfcCd[i]);
				if (sTrdPartyVal[i] != null)
					model.setSTrdPartyVal(sTrdPartyVal[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (sUserOfcCd[i] != null)
					model.setSUserOfcCd(sUserOfcCd[i]);
				if (sFileNo[i] != null)
					model.setSFileNo(sFileNo[i]);
				if (stlCltOfcCngAmt[i] != null)
					model.setStlCltOfcCngAmt(stlCltOfcCngAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (n3ptyInvNo[i] != null)
					model.setN3ptyInvNo(n3ptyInvNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sRaRmk2[i] != null)
					model.setSRaRmk2(sRaRmk2[i]);
				if (stlToCltCngOfcCd[i] != null)
					model.setStlToCltCngOfcCd(stlToCltCngOfcCd[i]);
				if (sN3ptyNoStrsLink[i] != null)
					model.setSN3ptyNoStrsLink(sN3ptyNoStrsLink[i]);
				if (cltActYn[i] != null)
					model.setCltActYn(cltActYn[i]);
				if (sSTrdPartyVal[i] != null)
					model.setSSTrdPartyVal(sSTrdPartyVal[i]);
				if (sRaRmk1[i] != null)
					model.setSRaRmk1(sRaRmk1[i]);
				if (appOfc[i] != null)
					model.setAppOfc(appOfc[i]);
				if (sOfficeLevel[i] != null)
					model.setSOfficeLevel(sOfficeLevel[i]);
				if (cDateKindFlag[i] != null)
					model.setCDateKindFlag(cDateKindFlag[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (sVndrCustDivCd[i] != null)
					model.setSVndrCustDivCd(sVndrCustDivCd[i]);
				if (otsStsCdVal[i] != null)
					model.setOtsStsCdVal(otsStsCdVal[i]);
				if (ifRhqCd[i] != null)
					model.setIfRhqCd(ifRhqCd[i]);
				if (stlAmt[i] != null)
					model.setStlAmt(stlAmt[i]);
				if (n3ptyStlTpCd[i] != null)
					model.setN3ptyStlTpCd(n3ptyStlTpCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (otsAmt[i] != null)
					model.setOtsAmt(otsAmt[i]);
				if (sIfRhqCd[i] != null)
					model.setSIfRhqCd(sIfRhqCd[i]);
				if (n3ptySrcSubSysCd[i] != null)
					model.setN3ptySrcSubSysCd(n3ptySrcSubSysCd[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (sSVndrCustDivCd[i] != null)
					model.setSSVndrCustDivCd(sSVndrCustDivCd[i]);
				if (otsStsCd[i] != null)
					model.setOtsStsCd(otsStsCd[i]);
				if (appId[i] != null)
					model.setAppId(appId[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cltAmt[i] != null)
					model.setCltAmt(cltAmt[i]);
				if (sDateKindFlag[i] != null)
					model.setSDateKindFlag(sDateKindFlag[i]);
				if (reviewStep[i] != null)
					model.setReviewStep(reviewStep[i]);
				if (ipage[i] != null)
					model.setIpage(ipage[i]);
				if (reqDate[i] != null)
					model.setReqDate(reqDate[i]);
				if (sIfCtrlCd[i] != null)
					model.setSIfCtrlCd(sIfCtrlCd[i]);
				if (rejDate[i] != null)
					model.setRejDate(rejDate[i]);
				if (sCalendarDate1[i] != null)
					model.setSCalendarDate1(sCalendarDate1[i]);
				if (sCalendarDate2[i] != null)
					model.setSCalendarDate2(sCalendarDate2[i]);
				if (balAmt[i] != null)
					model.setBalAmt(balAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sN3ptyNoStrs[i] != null)
					model.setSN3ptyNoStrs(sN3ptyNoStrs[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (reqOfc[i] != null)
					model.setReqOfc(reqOfc[i]);
				if (appDate[i] != null)
					model.setAppDate(appDate[i]);
				if (sDateFlagI[i] != null)
					model.setSDateFlagI(sDateFlagI[i]);
				if (reqId[i] != null)
					model.setReqId(reqId[i]);
				if (sN3ptyNo[i] != null)
					model.setSN3ptyNo(sN3ptyNo[i]);
				if (sDateFlagR[i] != null)
					model.setSDateFlagR(sDateFlagR[i]);
				if (rejId[i] != null)
					model.setRejId(rejId[i]);
				if (approval[i] != null)
					model.setApproval(approval[i]);
				if (sIfOfcCd[i] != null)
					model.setSIfOfcCd(sIfOfcCd[i]);
				if (dateType[i] != null)
					model.setDateType(dateType[i]);
				if (stlRqstDt[i] != null)
					model.setStlRqstDt(stlRqstDt[i]);
				if (sOfcCdForRhq[i] != null)
					model.setSOfcCdForRhq(sOfcCdForRhq[i]);
				if (stlRqstRmk[i] != null)
					model.setStlRqstRmk(stlRqstRmk[i]);
				if (chkReq[i] != null)
					model.setChkReq(chkReq[i]);
				if (sRhqCdForRhq[i] != null)
					model.setSRhqCdForRhq(sRhqCdForRhq[i]);
				if (chkApp[i] != null)
					model.setChkApp(chkApp[i]);
				if (chkRej[i] != null)
					model.setChkRej(chkRej[i]);
				if (n3pty[i] != null)
					model.setN3pty(n3pty[i]);
				if (n2ndRvwChk[i] != null)
					model.setN2ndRvwChk(n2ndRvwChk[i]);
				if (tpbNxtPrcChk[i] != null)
					model.setTpbNxtPrcChk(tpbNxtPrcChk[i]);
				if (diffRhqChk[i] != null)
					model.setDiffRhqChk(diffRhqChk[i]);
				if (adjStsSeq[i] != null)
					model.setAdjStsSeq(adjStsSeq[i]);
				if (adjN2ndRvwSeq[i] != null)
					model.setAdjN2ndRvwSeq(adjN2ndRvwSeq[i]);
				if (adjN2ndRvwStsCd[i] != null)
					model.setAdjN2ndRvwStsCd(adjN2ndRvwStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchResponsibleOfficeChangeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchResponsibleOfficeChangeVO[]
	 */
	public SearchResponsibleOfficeChangeVO[] getSearchResponsibleOfficeChangeVOs(){
		SearchResponsibleOfficeChangeVO[] vos = (SearchResponsibleOfficeChangeVO[])models.toArray(new SearchResponsibleOfficeChangeVO[models.size()]);
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
		this.sCurrCdTp = this.sCurrCdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejOfc = this.rejOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOfcCd = this.ifOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyVal = this.sTrdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUserOfcCd = this.sUserOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFileNo = this.sFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCltOfcCngAmt = this.stlCltOfcCngAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNo = this.n3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRaRmk2 = this.sRaRmk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlToCltCngOfcCd = this.stlToCltCngOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNoStrsLink = this.sN3ptyNoStrsLink .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltActYn = this.cltActYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSTrdPartyVal = this.sSTrdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRaRmk1 = this.sRaRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appOfc = this.appOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfficeLevel = this.sOfficeLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cDateKindFlag = this.cDateKindFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustDivCd = this.sVndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStsCdVal = this.otsStsCdVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRhqCd = this.ifRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlAmt = this.stlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyStlTpCd = this.n3ptyStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAmt = this.otsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfRhqCd = this.sIfRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcSubSysCd = this.n3ptySrcSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSVndrCustDivCd = this.sSVndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStsCd = this.otsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appId = this.appId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltAmt = this.cltAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDateKindFlag = this.sDateKindFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reviewStep = this.reviewStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ipage = this.ipage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqDate = this.reqDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfCtrlCd = this.sIfCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejDate = this.rejDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCalendarDate1 = this.sCalendarDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCalendarDate2 = this.sCalendarDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balAmt = this.balAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNoStrs = this.sN3ptyNoStrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqOfc = this.reqOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appDate = this.appDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDateFlagI = this.sDateFlagI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqId = this.reqId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNo = this.sN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDateFlagR = this.sDateFlagR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejId = this.rejId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approval = this.approval .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfOfcCd = this.sIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateType = this.dateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlRqstDt = this.stlRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCdForRhq = this.sOfcCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlRqstRmk = this.stlRqstRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkReq = this.chkReq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqCdForRhq = this.sRhqCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkApp = this.chkApp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkRej = this.chkRej .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3pty = this.n3pty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndRvwChk = this.n2ndRvwChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbNxtPrcChk = this.tpbNxtPrcChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRhqChk = this.diffRhqChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjStsSeq = this.adjStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjN2ndRvwSeq = this.adjN2ndRvwSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjN2ndRvwStsCd = this.adjN2ndRvwStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
