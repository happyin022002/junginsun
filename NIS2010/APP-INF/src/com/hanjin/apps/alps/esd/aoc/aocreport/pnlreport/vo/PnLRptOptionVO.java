/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PnLRptOptionVO.java
*@FileTitle : PnLRptOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class PnLRptOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PnLRptOptionVO> models = new ArrayList<PnLRptOptionVO>();
	
	/* Column Info */
	private String sCtrtOfcCd1 = null;
	/* Column Info */
	private String cSubOfc2 = null;
	/* Column Info */
	private String cSubOfc1 = null;
	/* Column Info */
	private String fChkprd = null;
	/* Column Info */
	private String sCtrtOfcCd2 = null;
	/* Column Info */
	private String sBkgNo = null;
	/* Column Info */
	private String sToDate = null;
	/* Column Info */
	private String iFmWm = null;
	/* Column Info */
	private String sWoOfcCd1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String iToWm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sPnlTp = null;
	/* Column Info */
	private String sPnlDiv = null;
	/* Column Info */
	private String sCustTp = null;
	/* Column Info */
	private String sCustCd = null;
	/* Column Info */
	private String sFmDate = null;
	/* Column Info */
	private String sCtrtNo = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String sRevTp = null;
	/* Column Info */
	private String rPrdBkgDiv = null;
	/* Column Info */
	private String rView = null;
	/* Column Info */
	private String sIoBndCd = null;
	/* Column Info */
	private String sTrfCntCd = null;
	/* Column Info */
	private String sSvcScp = null;
	/* Column Info */
	private String sXcldSvcScp = null;
	/* Column Info */
	private String fYear = null;
	/* Column Info */
	private String sCond = null;
	/* Column Info */
	private String sExlFlg = null;
	/* Column Info */
	private String sView = null;
	/* Column Info */
	private String sWoOfcCd2 = null;
	/* Column Info */
	private String sRdTerm = null;
	/* Column Info */
	private String cXcldOfc = null;
	/* Column Info */
	private String sRhqCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PnLRptOptionVO() {}

	public PnLRptOptionVO(String ibflag, String pagerows, String sFmDate, String sToDate, String rView, String rPrdBkgDiv, String fChkprd, String fYear, String iFmWm, String iToWm, String sCtrtOfcCd1, String cSubOfc1, String sSvcScp, String sXcldSvcScp, String sTrfCntCd, String sWoOfcCd1, String sIoBndCd, String sCtrtOfcCd2, String cSubOfc2, String sCustTp, String sCustCd, String sCustNm, String sPnlDiv, String sPnlTp, String sRevTp, String sBkgNo, String sCtrtNo, String sCond, String sExlFlg, String sView, String sWoOfcCd2, String sRdTerm, String cXcldOfc, String sRhqCd) {
		this.sCtrtOfcCd1 = sCtrtOfcCd1;
		this.cSubOfc2 = cSubOfc2;
		this.cSubOfc1 = cSubOfc1;
		this.fChkprd = fChkprd;
		this.sCtrtOfcCd2 = sCtrtOfcCd2;
		this.sBkgNo = sBkgNo;
		this.sToDate = sToDate;
		this.iFmWm = iFmWm;
		this.sWoOfcCd1 = sWoOfcCd1;
		this.pagerows = pagerows;
		this.iToWm = iToWm;
		this.ibflag = ibflag;
		this.sPnlTp = sPnlTp;
		this.sPnlDiv = sPnlDiv;
		this.sCustTp = sCustTp;
		this.sCustCd = sCustCd;
		this.sFmDate = sFmDate;
		this.sCtrtNo = sCtrtNo;
		this.sCustNm = sCustNm;
		this.sRevTp = sRevTp;
		this.rPrdBkgDiv = rPrdBkgDiv;
		this.rView = rView;
		this.sIoBndCd = sIoBndCd;
		this.sTrfCntCd = sTrfCntCd;
		this.sSvcScp = sSvcScp;
		this.sXcldSvcScp = sXcldSvcScp;
		this.fYear = fYear;
		this.sCond = sCond;
		this.sExlFlg = sExlFlg;
		this.sView = sView;
		this.sWoOfcCd2 = sWoOfcCd2;
		this.sRdTerm = sRdTerm;
		this.cXcldOfc = cXcldOfc;
		this.sRhqCd = sRhqCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_ctrt_ofc_cd1", getSCtrtOfcCd1());
		this.hashColumns.put("c_sub_ofc2", getCSubOfc2());
		this.hashColumns.put("c_sub_ofc1", getCSubOfc1());
		this.hashColumns.put("f_chkprd", getFChkprd());
		this.hashColumns.put("s_ctrt_ofc_cd2", getSCtrtOfcCd2());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("s_to_date", getSToDate());
		this.hashColumns.put("i_fm_wm", getIFmWm());
		this.hashColumns.put("s_wo_ofc_cd1", getSWoOfcCd1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("i_to_wm", getIToWm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_pnl_tp", getSPnlTp());
		this.hashColumns.put("s_pnl_div", getSPnlDiv());
		this.hashColumns.put("s_cust_tp", getSCustTp());
		this.hashColumns.put("s_cust_cd", getSCustCd());
		this.hashColumns.put("s_fm_date", getSFmDate());
		this.hashColumns.put("s_ctrt_no", getSCtrtNo());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("s_rev_tp", getSRevTp());
		this.hashColumns.put("r_prd_bkg_div", getRPrdBkgDiv());
		this.hashColumns.put("r_view", getRView());
		this.hashColumns.put("s_io_bnd_cd", getSIoBndCd());
		this.hashColumns.put("s_trf_cnt_cd", getSTrfCntCd());
		this.hashColumns.put("s_svc_scp", getSSvcScp());
		this.hashColumns.put("s_xcld_svc_scp", getSXcldSvcScp());
		this.hashColumns.put("f_year", getFYear());
		this.hashColumns.put("s_cond", getSCond());
		this.hashColumns.put("s_exl_flg", getSExlFlg());
		this.hashColumns.put("s_view", getSView());
		this.hashColumns.put("s_wo_ofc_cd2", getSWoOfcCd2());
		this.hashColumns.put("s_rd_term", getSRdTerm());
		this.hashColumns.put("c_xcld_ofc", getCXcldOfc());
		this.hashColumns.put("s_rhq_cd", getSRhqCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_ctrt_ofc_cd1", "sCtrtOfcCd1");
		this.hashFields.put("c_sub_ofc2", "cSubOfc2");
		this.hashFields.put("c_sub_ofc1", "cSubOfc1");
		this.hashFields.put("f_chkprd", "fChkprd");
		this.hashFields.put("s_ctrt_ofc_cd2", "sCtrtOfcCd2");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("s_to_date", "sToDate");
		this.hashFields.put("i_fm_wm", "iFmWm");
		this.hashFields.put("s_wo_ofc_cd1", "sWoOfcCd1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("i_to_wm", "iToWm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_pnl_tp", "sPnlTp");
		this.hashFields.put("s_pnl_div", "sPnlDiv");
		this.hashFields.put("s_cust_tp", "sCustTp");
		this.hashFields.put("s_cust_cd", "sCustCd");
		this.hashFields.put("s_fm_date", "sFmDate");
		this.hashFields.put("s_ctrt_no", "sCtrtNo");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("s_rev_tp", "sRevTp");
		this.hashFields.put("r_prd_bkg_div", "rPrdBkgDiv");
		this.hashFields.put("r_view", "rView");
		this.hashFields.put("s_io_bnd_cd", "sIoBndCd");
		this.hashFields.put("s_trf_cnt_cd", "sTrfCntCd");
		this.hashFields.put("s_svc_scp", "sSvcScp");
		this.hashFields.put("s_xcld_svc_scp", "sXcldSvcScp");
		this.hashFields.put("f_year", "fYear");
		this.hashFields.put("s_cond", "sCond");
		this.hashFields.put("s_exl_flg", "sExlFlg");
		this.hashFields.put("s_view", "sView");
		this.hashFields.put("s_wo_ofc_cd2", "sWoOfcCd2");
		this.hashFields.put("s_rd_term", "sRdTerm");
		this.hashFields.put("c_xcld_ofc", "cXcldOfc");
		this.hashFields.put("s_rhq_cd", "sRhqCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sCtrtOfcCd1
	 */
	public String getSCtrtOfcCd1() {
		return this.sCtrtOfcCd1;
	}
	
	/**
	 * Column Info
	 * @return cSubOfc2
	 */
	public String getCSubOfc2() {
		return this.cSubOfc2;
	}
	
	/**
	 * Column Info
	 * @return cSubOfc1
	 */
	public String getCSubOfc1() {
		return this.cSubOfc1;
	}
	
	/**
	 * Column Info
	 * @return fChkprd
	 */
	public String getFChkprd() {
		return this.fChkprd;
	}
	
	/**
	 * Column Info
	 * @return sCtrtOfcCd2
	 */
	public String getSCtrtOfcCd2() {
		return this.sCtrtOfcCd2;
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
	 * @return sToDate
	 */
	public String getSToDate() {
		return this.sToDate;
	}
	
	/**
	 * Column Info
	 * @return iFmWm
	 */
	public String getIFmWm() {
		return this.iFmWm;
	}
	
	/**
	 * Column Info
	 * @return sWoOfcCd1
	 */
	public String getSWoOfcCd1() {
		return this.sWoOfcCd1;
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
	 * @return iToWm
	 */
	public String getIToWm() {
		return this.iToWm;
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
	 * @return sPnlTp
	 */
	public String getSPnlTp() {
		return this.sPnlTp;
	}
	
	/**
	 * Column Info
	 * @return sPnlDiv
	 */
	public String getSPnlDiv() {
		return this.sPnlDiv;
	}
	
	/**
	 * Column Info
	 * @return sCustTp
	 */
	public String getSCustTp() {
		return this.sCustTp;
	}
	
	/**
	 * Column Info
	 * @return sCustCd
	 */
	public String getSCustCd() {
		return this.sCustCd;
	}
	
	/**
	 * Column Info
	 * @return sFmDate
	 */
	public String getSFmDate() {
		return this.sFmDate;
	}
	
	/**
	 * Column Info
	 * @return sCtrtNo
	 */
	public String getSCtrtNo() {
		return this.sCtrtNo;
	}
	
	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
	}
	
	/**
	 * Column Info
	 * @return sRevTp
	 */
	public String getSRevTp() {
		return this.sRevTp;
	}
	
	/**
	 * Column Info
	 * @return rPrdBkgDiv
	 */
	public String getRPrdBkgDiv() {
		return this.rPrdBkgDiv;
	}
	
	/**
	 * Column Info
	 * @return rView
	 */
	public String getRView() {
		return this.rView;
	}
	
	/**
	 * Column Info
	 * @return sIoBndCd
	 */
	public String getSIoBndCd() {
		return this.sIoBndCd;
	}
	
	/**
	 * Column Info
	 * @return sTrfCntCd
	 */
	public String getSTrfCntCd() {
		return this.sTrfCntCd;
	}
	
	/**
	 * Column Info
	 * @return sSvcScp
	 */
	public String getSSvcScp() {
		return this.sSvcScp;
	}
	
	/**
	 * Column Info
	 * @return sXcldSvcScp
	 */
	public String getSXcldSvcScp() {
		return this.sXcldSvcScp;
	}
	
	/**
	 * Column Info
	 * @return fYear
	 */
	public String getFYear() {
		return this.fYear;
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
	 * @return sExlFlg
	 */
	public String getSExlFlg() {
		return this.sExlFlg;
	}
	
	/**
	 * Column Info
	 * @return sView
	 */
	public String getSView() {
		return this.sView;
	}
	
	/**
	 * Column Info
	 * @return sWoOfcCd2
	 */
	public String getSWoOfcCd2() {
		return this.sWoOfcCd2;
	}
	
	/**
	 * Column Info
	 * @return sRdTerm
	 */
	public String getSRdTerm() {
		return this.sRdTerm;
	}
	
	/**
	 * Column Info
	 * @return cXcldOfc
	 */
	public String getCXcldOfc() {
		return this.cXcldOfc;
	}
	
	/**
	 * Column Info
	 * @return sRhqCd
	 */
	public String getSRhqCd() {
		return this.sRhqCd;
	}
	

	/**
	 * Column Info
	 * @param sCtrtOfcCd1
	 */
	public void setSCtrtOfcCd1(String sCtrtOfcCd1) {
		this.sCtrtOfcCd1 = sCtrtOfcCd1;
	}
	
	/**
	 * Column Info
	 * @param cSubOfc2
	 */
	public void setCSubOfc2(String cSubOfc2) {
		this.cSubOfc2 = cSubOfc2;
	}
	
	/**
	 * Column Info
	 * @param cSubOfc1
	 */
	public void setCSubOfc1(String cSubOfc1) {
		this.cSubOfc1 = cSubOfc1;
	}
	
	/**
	 * Column Info
	 * @param fChkprd
	 */
	public void setFChkprd(String fChkprd) {
		this.fChkprd = fChkprd;
	}
	
	/**
	 * Column Info
	 * @param sCtrtOfcCd2
	 */
	public void setSCtrtOfcCd2(String sCtrtOfcCd2) {
		this.sCtrtOfcCd2 = sCtrtOfcCd2;
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
	 * @param sToDate
	 */
	public void setSToDate(String sToDate) {
		this.sToDate = sToDate;
	}
	
	/**
	 * Column Info
	 * @param iFmWm
	 */
	public void setIFmWm(String iFmWm) {
		this.iFmWm = iFmWm;
	}
	
	/**
	 * Column Info
	 * @param sWoOfcCd1
	 */
	public void setSWoOfcCd1(String sWoOfcCd1) {
		this.sWoOfcCd1 = sWoOfcCd1;
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
	 * @param iToWm
	 */
	public void setIToWm(String iToWm) {
		this.iToWm = iToWm;
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
	 * @param sPnlTp
	 */
	public void setSPnlTp(String sPnlTp) {
		this.sPnlTp = sPnlTp;
	}
	
	/**
	 * Column Info
	 * @param sPnlDiv
	 */
	public void setSPnlDiv(String sPnlDiv) {
		this.sPnlDiv = sPnlDiv;
	}
	
	/**
	 * Column Info
	 * @param sCustTp
	 */
	public void setSCustTp(String sCustTp) {
		this.sCustTp = sCustTp;
	}
	
	/**
	 * Column Info
	 * @param sCustCd
	 */
	public void setSCustCd(String sCustCd) {
		this.sCustCd = sCustCd;
	}
	
	/**
	 * Column Info
	 * @param sFmDate
	 */
	public void setSFmDate(String sFmDate) {
		this.sFmDate = sFmDate;
	}
	
	/**
	 * Column Info
	 * @param sCtrtNo
	 */
	public void setSCtrtNo(String sCtrtNo) {
		this.sCtrtNo = sCtrtNo;
	}
	
	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
	}
	
	/**
	 * Column Info
	 * @param sRevTp
	 */
	public void setSRevTp(String sRevTp) {
		this.sRevTp = sRevTp;
	}
	
	/**
	 * Column Info
	 * @param rPrdBkgDiv
	 */
	public void setRPrdBkgDiv(String rPrdBkgDiv) {
		this.rPrdBkgDiv = rPrdBkgDiv;
	}
	
	/**
	 * Column Info
	 * @param rView
	 */
	public void setRView(String rView) {
		this.rView = rView;
	}
	
	/**
	 * Column Info
	 * @param sIoBndCd
	 */
	public void setSIoBndCd(String sIoBndCd) {
		this.sIoBndCd = sIoBndCd;
	}
	
	/**
	 * Column Info
	 * @param sTrfCntCd
	 */
	public void setSTrfCntCd(String sTrfCntCd) {
		this.sTrfCntCd = sTrfCntCd;
	}
	
	/**
	 * Column Info
	 * @param sSvcScp
	 */
	public void setSSvcScp(String sSvcScp) {
		this.sSvcScp = sSvcScp;
	}
	
	/**
	 * Column Info
	 * @param sXcldSvcScp
	 */
	public void setSXcldSvcScp(String sXcldSvcScp) {
		this.sXcldSvcScp = sXcldSvcScp;
	}
	
	/**
	 * Column Info
	 * @param fYear
	 */
	public void setFYear(String fYear) {
		this.fYear = fYear;
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
	 * @param sExlFlg
	 */
	public void setSExlFlg(String sExlFlg) {
		this.sExlFlg = sExlFlg;
	}
	
	/**
	 * Column Info
	 * @param sView
	 */
	public void setSView(String sView) {
		this.sView = sView;
	}
	
	/**
	 * Column Info
	 * @param sWoOfcCd2
	 */
	public void setSWoOfcCd2(String sWoOfcCd2) {
		this.sWoOfcCd2 = sWoOfcCd2;
	}
	
	/**
	 * Column Info
	 * @param sRdTerm
	 */
	public void setSRdTerm(String sRdTerm) {
		this.sRdTerm = sRdTerm;
	}
	
	/**
	 * Column Info
	 * @param cXcldOfc
	 */
	public void setCXcldOfc(String cXcldOfc) {
		this.cXcldOfc = cXcldOfc;
	}
	
	/**
	 * Column Info
	 * @param sRhqCd
	 */
	public void setSRhqCd(String sRhqCd) {
		this.sRhqCd = sRhqCd;
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
		setSCtrtOfcCd1(JSPUtil.getParameter(request, prefix + "s_ctrt_ofc_cd1", ""));
		setCSubOfc2(JSPUtil.getParameter(request, prefix + "c_sub_ofc2", ""));
		setCSubOfc1(JSPUtil.getParameter(request, prefix + "c_sub_ofc1", ""));
		setFChkprd(JSPUtil.getParameter(request, prefix + "f_chkprd", ""));
		setSCtrtOfcCd2(JSPUtil.getParameter(request, prefix + "s_ctrt_ofc_cd2", ""));
		setSBkgNo(JSPUtil.getParameter(request, prefix + "s_bkg_no", ""));
		setSToDate(JSPUtil.getParameter(request, prefix + "s_to_date", ""));
		setIFmWm(JSPUtil.getParameter(request, prefix + "i_fm_wm", ""));
		setSWoOfcCd1(JSPUtil.getParameter(request, prefix + "s_wo_ofc_cd1", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIToWm(JSPUtil.getParameter(request, prefix + "i_to_wm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSPnlTp(JSPUtil.getParameter(request, prefix + "s_pnl_tp", ""));
		setSPnlDiv(JSPUtil.getParameter(request, prefix + "s_pnl_div", ""));
		setSCustTp(JSPUtil.getParameter(request, prefix + "s_cust_tp", ""));
		setSCustCd(JSPUtil.getParameter(request, prefix + "s_cust_cd", ""));
		setSFmDate(JSPUtil.getParameter(request, prefix + "s_fm_date", ""));
		setSCtrtNo(JSPUtil.getParameter(request, prefix + "s_ctrt_no", ""));
		setSCustNm(JSPUtil.getParameter(request, prefix + "s_cust_nm", ""));
		setSRevTp(JSPUtil.getParameter(request, prefix + "s_rev_tp", ""));
		setRPrdBkgDiv(JSPUtil.getParameter(request, prefix + "r_prd_bkg_div", ""));
		setRView(JSPUtil.getParameter(request, prefix + "r_view", ""));
		setSIoBndCd(JSPUtil.getParameter(request, prefix + "s_io_bnd_cd", ""));
		setSTrfCntCd(JSPUtil.getParameter(request, prefix + "s_trf_cnt_cd", ""));
		setSSvcScp(JSPUtil.getParameter(request, prefix + "s_svc_scp", ""));
		setSXcldSvcScp(JSPUtil.getParameter(request, prefix + "s_xcld_svc_scp", ""));
		setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
		setSCond(JSPUtil.getParameter(request, prefix + "s_cond", ""));
		setSExlFlg(JSPUtil.getParameter(request, prefix + "s_exl_flg", ""));
		setSView(JSPUtil.getParameter(request, prefix + "s_view", ""));
		setSWoOfcCd2(JSPUtil.getParameter(request, prefix + "s_wo_ofc_cd2", ""));
		setSRdTerm(JSPUtil.getParameter(request, prefix + "s_rd_term", ""));
		setCXcldOfc(JSPUtil.getParameter(request, prefix + "c_xcld_ofc", ""));
		setSRhqCd(JSPUtil.getParameter(request, prefix + "s_rhq_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PnLRptOptionVO[]
	 */
	public PnLRptOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PnLRptOptionVO[]
	 */
	public PnLRptOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PnLRptOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sCtrtOfcCd1 = (JSPUtil.getParameter(request, prefix	+ "s_ctrt_ofc_cd1", length));
			String[] cSubOfc2 = (JSPUtil.getParameter(request, prefix	+ "c_sub_ofc2", length));
			String[] cSubOfc1 = (JSPUtil.getParameter(request, prefix	+ "c_sub_ofc1", length));
			String[] fChkprd = (JSPUtil.getParameter(request, prefix	+ "f_chkprd", length));
			String[] sCtrtOfcCd2 = (JSPUtil.getParameter(request, prefix	+ "s_ctrt_ofc_cd2", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] sToDate = (JSPUtil.getParameter(request, prefix	+ "s_to_date", length));
			String[] iFmWm = (JSPUtil.getParameter(request, prefix	+ "i_fm_wm", length));
			String[] sWoOfcCd1 = (JSPUtil.getParameter(request, prefix	+ "s_wo_ofc_cd1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] iToWm = (JSPUtil.getParameter(request, prefix	+ "i_to_wm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sPnlTp = (JSPUtil.getParameter(request, prefix	+ "s_pnl_tp", length));
			String[] sPnlDiv = (JSPUtil.getParameter(request, prefix	+ "s_pnl_div", length));
			String[] sCustTp = (JSPUtil.getParameter(request, prefix	+ "s_cust_tp", length));
			String[] sCustCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cd", length));
			String[] sFmDate = (JSPUtil.getParameter(request, prefix	+ "s_fm_date", length));
			String[] sCtrtNo = (JSPUtil.getParameter(request, prefix	+ "s_ctrt_no", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] sRevTp = (JSPUtil.getParameter(request, prefix	+ "s_rev_tp", length));
			String[] rPrdBkgDiv = (JSPUtil.getParameter(request, prefix	+ "r_prd_bkg_div", length));
			String[] rView = (JSPUtil.getParameter(request, prefix	+ "r_view", length));
			String[] sIoBndCd = (JSPUtil.getParameter(request, prefix	+ "s_io_bnd_cd", length));
			String[] sTrfCntCd = (JSPUtil.getParameter(request, prefix	+ "s_trf_cnt_cd", length));
			String[] sSvcScp = (JSPUtil.getParameter(request, prefix	+ "s_svc_scp", length));
			String[] sXcldSvcScp = (JSPUtil.getParameter(request, prefix	+ "s_xcld_svc_scp", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			String[] sCond = (JSPUtil.getParameter(request, prefix	+ "s_cond", length));
			String[] sExlFlg = (JSPUtil.getParameter(request, prefix	+ "s_exl_flg", length));
			String[] sView = (JSPUtil.getParameter(request, prefix	+ "s_exl_flg", length));
			String[] sWoOfcCd2 = (JSPUtil.getParameter(request, prefix	+ "s_wo_ofc_cd2", length));
			String[] sRdTerm = (JSPUtil.getParameter(request, prefix	+ "s_wo_ofc_cd2", length));
			String[] cXcldOfc = (JSPUtil.getParameter(request, prefix	+ "c_xcld_ofc", length));
			String[] sRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PnLRptOptionVO();
				if (sCtrtOfcCd1[i] != null)
					model.setSCtrtOfcCd1(sCtrtOfcCd1[i]);
				if (cSubOfc2[i] != null)
					model.setCSubOfc2(cSubOfc2[i]);
				if (cSubOfc1[i] != null)
					model.setCSubOfc1(cSubOfc1[i]);
				if (fChkprd[i] != null)
					model.setFChkprd(fChkprd[i]);
				if (sCtrtOfcCd2[i] != null)
					model.setSCtrtOfcCd2(sCtrtOfcCd2[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (sToDate[i] != null)
					model.setSToDate(sToDate[i]);
				if (iFmWm[i] != null)
					model.setIFmWm(iFmWm[i]);
				if (sWoOfcCd1[i] != null)
					model.setSWoOfcCd1(sWoOfcCd1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (iToWm[i] != null)
					model.setIToWm(iToWm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sPnlTp[i] != null)
					model.setSPnlTp(sPnlTp[i]);
				if (sPnlDiv[i] != null)
					model.setSPnlDiv(sPnlDiv[i]);
				if (sCustTp[i] != null)
					model.setSCustTp(sCustTp[i]);
				if (sCustCd[i] != null)
					model.setSCustCd(sCustCd[i]);
				if (sFmDate[i] != null)
					model.setSFmDate(sFmDate[i]);
				if (sCtrtNo[i] != null)
					model.setSCtrtNo(sCtrtNo[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (sRevTp[i] != null)
					model.setSRevTp(sRevTp[i]);
				if (rPrdBkgDiv[i] != null)
					model.setRPrdBkgDiv(rPrdBkgDiv[i]);
				if (rView[i] != null)
					model.setRView(rView[i]);
				if (sIoBndCd[i] != null)
					model.setSIoBndCd(sIoBndCd[i]);
				if (sTrfCntCd[i] != null)
					model.setSTrfCntCd(sTrfCntCd[i]);
				if (sSvcScp[i] != null)
					model.setSSvcScp(sSvcScp[i]);
				if (sXcldSvcScp[i] != null)
					model.setSXcldSvcScp(sXcldSvcScp[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				if (sCond[i] != null)
					model.setSCond(sCond[i]);
				if (sExlFlg[i] != null)
					model.setSExlFlg(sExlFlg[i]);
				if (sView[i] != null)
					model.setSView(sView[i]);
				if (sWoOfcCd2[i] != null)
					model.setSWoOfcCd2(sWoOfcCd2[i]);
				if (sRdTerm[i] != null)
					model.setSRdTerm(sRdTerm[i]);
				if (cXcldOfc[i] != null)
					model.setCXcldOfc(cXcldOfc[i]);
				if (sRhqCd[i] != null)
					model.setSRhqCd(sRhqCd[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPnLRptOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PnLRptOptionVO[]
	 */
	public PnLRptOptionVO[] getPnLRptOptionVOs(){
		PnLRptOptionVO[] vos = (PnLRptOptionVO[])models.toArray(new PnLRptOptionVO[models.size()]);
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
		this.sCtrtOfcCd1 = this.sCtrtOfcCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cSubOfc2 = this.cSubOfc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cSubOfc1 = this.cSubOfc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkprd = this.fChkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCtrtOfcCd2 = this.sCtrtOfcCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToDate = this.sToDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iFmWm = this.iFmWm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sWoOfcCd1 = this.sWoOfcCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iToWm = this.iToWm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPnlTp = this.sPnlTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPnlDiv = this.sPnlDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustTp = this.sCustTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCd = this.sCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmDate = this.sFmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCtrtNo = this.sCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRevTp = this.sRevTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rPrdBkgDiv = this.rPrdBkgDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rView = this.rView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIoBndCd = this.sIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrfCntCd = this.sTrfCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSvcScp = this.sSvcScp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sXcldSvcScp = this.sXcldSvcScp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCond = this.sCond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sExlFlg = this.sExlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sView = this.sView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sWoOfcCd2 = this.sWoOfcCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRdTerm = this.sRdTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cXcldOfc = this.cXcldOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqCd = this.sRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
