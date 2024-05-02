/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : IssuedInvoiceParamVO.java
*@FileTitle : IssuedInvoiceParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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

public class IssuedInvoiceParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IssuedInvoiceParamVO> models = new ArrayList<IssuedInvoiceParamVO>();
	
	/* Column Info */
	private String caller = null;
	/* Column Info */
	private String sInvOverTo = null;
	/* Column Info */
	private String sBkgNo = null;
	/* Column Info */
	private String sIssueOfc = null;
	/* Column Info */
	private String fmCfmDt = null;
	/* Column Info */
	private String sDmdtInvStsCd = null;
	/* Column Info */
	private String sIssueTo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sBlNo = null;
	/* Column Info */
	private String dateCntr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sIssueFm = null;
	/* Column Info */
	private String sScNo = null;
	/* Column Info */
	private String sCustCd = null;
	/* Column Info */
	private String sInvCheck = null;
	/* Column Info */
	private String sChgType = null;
	/* Column Info */
	private String toCfmDt = null;
	/* Column Info */
	private String sRfaNo = null;
	/* Column Info */
	private String sInvoiceNo = null;
	/* Column Info */
	private String sIssueUsrId = null;
	/* Column Info */
	private String pgmId = null;
	/* Column Info */
	private String sCustGubun = null;
	/* Column Info */
	private String sGroupBy = null;
	/* Column Info */
	private String sDmdtArIfCd = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String sOfcCheck = null;
	/* Column Info */
	private String sCntrNo = null;
	/* Column Info */
	private String sPayerCd = null;
	/* Column Info */
	private String dmdtChgStsCds = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String sDmdtTrfCd = null;
	/* Column Info */
	private String invFlg = null;
	/* Column Info */
	private String sessionRhqOfcCd = null;
	/* Column Info */
	private String sInvOverFm = null;
	/* Column Info */
	private String usrCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IssuedInvoiceParamVO() {}

	public IssuedInvoiceParamVO(String ibflag, String pagerows, String sOfcCd, String sIssueOfc, String sDmdtTrfCd, String sGroupBy, String sChgType, String dateCntr, String fmCfmDt, String toCfmDt, String sBkgNo, String sBlNo, String sCntrNo, String sCustCd, String sScNo, String sRfaNo, String sInvoiceNo, String dmdtChgStsCds, String sDmdtArIfCd, String sDmdtInvStsCd, String sOfcCheck, String sIssueFm, String sIssueTo, String sInvOverFm, String sInvOverTo, String sIssueUsrId, String sInvCheck, String sPayerCd, String sCustGubun, String caller, String ofcCd, String pgmId, String sessionRhqOfcCd, String invFlg, String usrCntCd) {
		this.caller = caller;
		this.sInvOverTo = sInvOverTo;
		this.sBkgNo = sBkgNo;
		this.sIssueOfc = sIssueOfc;
		this.fmCfmDt = fmCfmDt;
		this.sDmdtInvStsCd = sDmdtInvStsCd;
		this.sIssueTo = sIssueTo;
		this.pagerows = pagerows;
		this.sBlNo = sBlNo;
		this.dateCntr = dateCntr;
		this.ibflag = ibflag;
		this.sIssueFm = sIssueFm;
		this.sScNo = sScNo;
		this.sCustCd = sCustCd;
		this.sInvCheck = sInvCheck;
		this.sChgType = sChgType;
		this.toCfmDt = toCfmDt;
		this.sRfaNo = sRfaNo;
		this.sInvoiceNo = sInvoiceNo;
		this.sIssueUsrId = sIssueUsrId;
		this.pgmId = pgmId;
		this.sCustGubun = sCustGubun;
		this.sGroupBy = sGroupBy;
		this.sDmdtArIfCd = sDmdtArIfCd;
		this.sOfcCd = sOfcCd;
		this.sOfcCheck = sOfcCheck;
		this.sCntrNo = sCntrNo;
		this.sPayerCd = sPayerCd;
		this.dmdtChgStsCds = dmdtChgStsCds;
		this.ofcCd = ofcCd;
		this.sDmdtTrfCd = sDmdtTrfCd;
		this.invFlg = invFlg;
		this.sessionRhqOfcCd = sessionRhqOfcCd;
		this.sInvOverFm = sInvOverFm;
		this.usrCntCd = usrCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("caller", getCaller());
		this.hashColumns.put("s_inv_over_to", getSInvOverTo());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("s_issue_ofc", getSIssueOfc());
		this.hashColumns.put("fm_cfm_dt", getFmCfmDt());
		this.hashColumns.put("s_dmdt_inv_sts_cd", getSDmdtInvStsCd());
		this.hashColumns.put("s_issue_to", getSIssueTo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_bl_no", getSBlNo());
		this.hashColumns.put("date_cntr", getDateCntr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_issue_fm", getSIssueFm());
		this.hashColumns.put("s_sc_no", getSScNo());
		this.hashColumns.put("s_cust_cd", getSCustCd());
		this.hashColumns.put("s_inv_check", getSInvCheck());
		this.hashColumns.put("s_chg_type", getSChgType());
		this.hashColumns.put("to_cfm_dt", getToCfmDt());
		this.hashColumns.put("s_rfa_no", getSRfaNo());
		this.hashColumns.put("s_invoice_no", getSInvoiceNo());
		this.hashColumns.put("s_issue_usr_id", getSIssueUsrId());
		this.hashColumns.put("pgm_id", getPgmId());
		this.hashColumns.put("s_cust_gubun", getSCustGubun());
		this.hashColumns.put("s_group_by", getSGroupBy());
		this.hashColumns.put("s_dmdt_ar_if_cd", getSDmdtArIfCd());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("s_ofc_check", getSOfcCheck());
		this.hashColumns.put("s_cntr_no", getSCntrNo());
		this.hashColumns.put("s_payer_cd", getSPayerCd());
		this.hashColumns.put("dmdt_chg_sts_cds", getDmdtChgStsCds());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("s_dmdt_trf_cd", getSDmdtTrfCd());
		this.hashColumns.put("inv_flg", getInvFlg());
		this.hashColumns.put("session_rhq_ofc_cd", getSessionRhqOfcCd());
		this.hashColumns.put("s_inv_over_fm", getSInvOverFm());
		this.hashColumns.put("usr_cnt_cd", getUsrCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("caller", "caller");
		this.hashFields.put("s_inv_over_to", "sInvOverTo");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("s_issue_ofc", "sIssueOfc");
		this.hashFields.put("fm_cfm_dt", "fmCfmDt");
		this.hashFields.put("s_dmdt_inv_sts_cd", "sDmdtInvStsCd");
		this.hashFields.put("s_issue_to", "sIssueTo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_bl_no", "sBlNo");
		this.hashFields.put("date_cntr", "dateCntr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_issue_fm", "sIssueFm");
		this.hashFields.put("s_sc_no", "sScNo");
		this.hashFields.put("s_cust_cd", "sCustCd");
		this.hashFields.put("s_inv_check", "sInvCheck");
		this.hashFields.put("s_chg_type", "sChgType");
		this.hashFields.put("to_cfm_dt", "toCfmDt");
		this.hashFields.put("s_rfa_no", "sRfaNo");
		this.hashFields.put("s_invoice_no", "sInvoiceNo");
		this.hashFields.put("s_issue_usr_id", "sIssueUsrId");
		this.hashFields.put("pgm_id", "pgmId");
		this.hashFields.put("s_cust_gubun", "sCustGubun");
		this.hashFields.put("s_group_by", "sGroupBy");
		this.hashFields.put("s_dmdt_ar_if_cd", "sDmdtArIfCd");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("s_ofc_check", "sOfcCheck");
		this.hashFields.put("s_cntr_no", "sCntrNo");
		this.hashFields.put("s_payer_cd", "sPayerCd");
		this.hashFields.put("dmdt_chg_sts_cds", "dmdtChgStsCds");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("s_dmdt_trf_cd", "sDmdtTrfCd");
		this.hashFields.put("inv_flg", "invFlg");
		this.hashFields.put("session_rhq_ofc_cd", "sessionRhqOfcCd");
		this.hashFields.put("s_inv_over_fm", "sInvOverFm");
		this.hashFields.put("usr_cnt_cd", "usrCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return caller
	 */
	public String getCaller() {
		return this.caller;
	}
	
	/**
	 * Column Info
	 * @return sInvOverTo
	 */
	public String getSInvOverTo() {
		return this.sInvOverTo;
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
	 * @return sIssueOfc
	 */
	public String getSIssueOfc() {
		return this.sIssueOfc;
	}
	
	/**
	 * Column Info
	 * @return fmCfmDt
	 */
	public String getFmCfmDt() {
		return this.fmCfmDt;
	}
	
	/**
	 * Column Info
	 * @return sDmdtInvStsCd
	 */
	public String getSDmdtInvStsCd() {
		return this.sDmdtInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return sIssueTo
	 */
	public String getSIssueTo() {
		return this.sIssueTo;
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
	 * @return sBlNo
	 */
	public String getSBlNo() {
		return this.sBlNo;
	}
	
	/**
	 * Column Info
	 * @return dateCntr
	 */
	public String getDateCntr() {
		return this.dateCntr;
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
	 * @return sIssueFm
	 */
	public String getSIssueFm() {
		return this.sIssueFm;
	}
	
	/**
	 * Column Info
	 * @return sScNo
	 */
	public String getSScNo() {
		return this.sScNo;
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
	 * @return sInvCheck
	 */
	public String getSInvCheck() {
		return this.sInvCheck;
	}
	
	/**
	 * Column Info
	 * @return sChgType
	 */
	public String getSChgType() {
		return this.sChgType;
	}
	
	/**
	 * Column Info
	 * @return toCfmDt
	 */
	public String getToCfmDt() {
		return this.toCfmDt;
	}
	
	/**
	 * Column Info
	 * @return sRfaNo
	 */
	public String getSRfaNo() {
		return this.sRfaNo;
	}
	
	/**
	 * Column Info
	 * @return sInvoiceNo
	 */
	public String getSInvoiceNo() {
		return this.sInvoiceNo;
	}
	
	/**
	 * Column Info
	 * @return sIssueUsrId
	 */
	public String getSIssueUsrId() {
		return this.sIssueUsrId;
	}
	
	/**
	 * Column Info
	 * @return pgmId
	 */
	public String getPgmId() {
		return this.pgmId;
	}
	
	/**
	 * Column Info
	 * @return sCustGubun
	 */
	public String getSCustGubun() {
		return this.sCustGubun;
	}
	
	/**
	 * Column Info
	 * @return sGroupBy
	 */
	public String getSGroupBy() {
		return this.sGroupBy;
	}
	
	/**
	 * Column Info
	 * @return sDmdtArIfCd
	 */
	public String getSDmdtArIfCd() {
		return this.sDmdtArIfCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCheck
	 */
	public String getSOfcCheck() {
		return this.sOfcCheck;
	}
	
	/**
	 * Column Info
	 * @return sCntrNo
	 */
	public String getSCntrNo() {
		return this.sCntrNo;
	}
	
	/**
	 * Column Info
	 * @return sPayerCd
	 */
	public String getSPayerCd() {
		return this.sPayerCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgStsCds
	 */
	public String getDmdtChgStsCds() {
		return this.dmdtChgStsCds;
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
	 * @return sDmdtTrfCd
	 */
	public String getSDmdtTrfCd() {
		return this.sDmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return invFlg
	 */
	public String getInvFlg() {
		return this.invFlg;
	}
	
	/**
	 * Column Info
	 * @return sessionRhqOfcCd
	 */
	public String getSessionRhqOfcCd() {
		return this.sessionRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sInvOverFm
	 */
	public String getSInvOverFm() {
		return this.sInvOverFm;
	}
	

	/**
	 * Column Info
	 * @param caller
	 */
	public void setCaller(String caller) {
		this.caller = caller;
	}
	
	/**
	 * Column Info
	 * @param sInvOverTo
	 */
	public void setSInvOverTo(String sInvOverTo) {
		this.sInvOverTo = sInvOverTo;
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
	 * @param sIssueOfc
	 */
	public void setSIssueOfc(String sIssueOfc) {
		this.sIssueOfc = sIssueOfc;
	}
	
	/**
	 * Column Info
	 * @param fmCfmDt
	 */
	public void setFmCfmDt(String fmCfmDt) {
		this.fmCfmDt = fmCfmDt;
	}
	
	/**
	 * Column Info
	 * @param sDmdtInvStsCd
	 */
	public void setSDmdtInvStsCd(String sDmdtInvStsCd) {
		this.sDmdtInvStsCd = sDmdtInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param sIssueTo
	 */
	public void setSIssueTo(String sIssueTo) {
		this.sIssueTo = sIssueTo;
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
	 * @param sBlNo
	 */
	public void setSBlNo(String sBlNo) {
		this.sBlNo = sBlNo;
	}
	
	/**
	 * Column Info
	 * @param dateCntr
	 */
	public void setDateCntr(String dateCntr) {
		this.dateCntr = dateCntr;
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
	 * @param sIssueFm
	 */
	public void setSIssueFm(String sIssueFm) {
		this.sIssueFm = sIssueFm;
	}
	
	/**
	 * Column Info
	 * @param sScNo
	 */
	public void setSScNo(String sScNo) {
		this.sScNo = sScNo;
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
	 * @param sInvCheck
	 */
	public void setSInvCheck(String sInvCheck) {
		this.sInvCheck = sInvCheck;
	}
	
	/**
	 * Column Info
	 * @param sChgType
	 */
	public void setSChgType(String sChgType) {
		this.sChgType = sChgType;
	}
	
	/**
	 * Column Info
	 * @param toCfmDt
	 */
	public void setToCfmDt(String toCfmDt) {
		this.toCfmDt = toCfmDt;
	}
	
	/**
	 * Column Info
	 * @param sRfaNo
	 */
	public void setSRfaNo(String sRfaNo) {
		this.sRfaNo = sRfaNo;
	}
	
	/**
	 * Column Info
	 * @param sInvoiceNo
	 */
	public void setSInvoiceNo(String sInvoiceNo) {
		this.sInvoiceNo = sInvoiceNo;
	}
	
	/**
	 * Column Info
	 * @param sIssueUsrId
	 */
	public void setSIssueUsrId(String sIssueUsrId) {
		this.sIssueUsrId = sIssueUsrId;
	}
	
	/**
	 * Column Info
	 * @param pgmId
	 */
	public void setPgmId(String pgmId) {
		this.pgmId = pgmId;
	}
	
	/**
	 * Column Info
	 * @param sCustGubun
	 */
	public void setSCustGubun(String sCustGubun) {
		this.sCustGubun = sCustGubun;
	}
	
	/**
	 * Column Info
	 * @param sGroupBy
	 */
	public void setSGroupBy(String sGroupBy) {
		this.sGroupBy = sGroupBy;
	}
	
	/**
	 * Column Info
	 * @param sDmdtArIfCd
	 */
	public void setSDmdtArIfCd(String sDmdtArIfCd) {
		this.sDmdtArIfCd = sDmdtArIfCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCheck
	 */
	public void setSOfcCheck(String sOfcCheck) {
		this.sOfcCheck = sOfcCheck;
	}
	
	/**
	 * Column Info
	 * @param sCntrNo
	 */
	public void setSCntrNo(String sCntrNo) {
		this.sCntrNo = sCntrNo;
	}
	
	/**
	 * Column Info
	 * @param sPayerCd
	 */
	public void setSPayerCd(String sPayerCd) {
		this.sPayerCd = sPayerCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgStsCds
	 */
	public void setDmdtChgStsCds(String dmdtChgStsCds) {
		this.dmdtChgStsCds = dmdtChgStsCds;
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
	 * @param sDmdtTrfCd
	 */
	public void setSDmdtTrfCd(String sDmdtTrfCd) {
		this.sDmdtTrfCd = sDmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param invFlg
	 */
	public void setInvFlg(String invFlg) {
		this.invFlg = invFlg;
	}
	
	/**
	 * Column Info
	 * @param sessionRhqOfcCd
	 */
	public void setSessionRhqOfcCd(String sessionRhqOfcCd) {
		this.sessionRhqOfcCd = sessionRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sInvOverFm
	 */
	public void setSInvOverFm(String sInvOverFm) {
		this.sInvOverFm = sInvOverFm;
	}

	public String getUsrCntCd() {
		return usrCntCd;
	}

	public void setUsrCntCd(String usrCntCd) {
		this.usrCntCd = usrCntCd;
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
		setCaller(JSPUtil.getParameter(request, prefix + "caller", ""));
		setSInvOverTo(JSPUtil.getParameter(request, prefix + "s_inv_over_to", ""));
		setSBkgNo(JSPUtil.getParameter(request, prefix + "s_bkg_no", ""));
		setSIssueOfc(JSPUtil.getParameter(request, prefix + "s_issue_ofc", ""));
		setFmCfmDt(JSPUtil.getParameter(request, prefix + "fm_cfm_dt", ""));
		setSDmdtInvStsCd(JSPUtil.getParameter(request, prefix + "s_dmdt_inv_sts_cd", ""));
		setSIssueTo(JSPUtil.getParameter(request, prefix + "s_issue_to", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSBlNo(JSPUtil.getParameter(request, prefix + "s_bl_no", ""));
		setDateCntr(JSPUtil.getParameter(request, prefix + "date_cntr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSIssueFm(JSPUtil.getParameter(request, prefix + "s_issue_fm", ""));
		setSScNo(JSPUtil.getParameter(request, prefix + "s_sc_no", ""));
		setSCustCd(JSPUtil.getParameter(request, prefix + "s_cust_cd", ""));
		setSInvCheck(JSPUtil.getParameter(request, prefix + "s_inv_check", ""));
		setSChgType(JSPUtil.getParameter(request, prefix + "s_chg_type", ""));
		setToCfmDt(JSPUtil.getParameter(request, prefix + "to_cfm_dt", ""));
		setSRfaNo(JSPUtil.getParameter(request, prefix + "s_rfa_no", ""));
		setSInvoiceNo(JSPUtil.getParameter(request, prefix + "s_invoice_no", ""));
		setSIssueUsrId(JSPUtil.getParameter(request, prefix + "s_issue_usr_id", ""));
		setPgmId(JSPUtil.getParameter(request, prefix + "pgm_id", ""));
		setSCustGubun(JSPUtil.getParameter(request, prefix + "s_cust_gubun", ""));
		setSGroupBy(JSPUtil.getParameter(request, prefix + "s_group_by", ""));
		setSDmdtArIfCd(JSPUtil.getParameter(request, prefix + "s_dmdt_ar_if_cd", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setSOfcCheck(JSPUtil.getParameter(request, prefix + "s_ofc_check", ""));
		setSCntrNo(JSPUtil.getParameter(request, prefix + "s_cntr_no", ""));
		setSPayerCd(JSPUtil.getParameter(request, prefix + "s_payer_cd", ""));
		setDmdtChgStsCds(JSPUtil.getParameter(request, prefix + "dmdt_chg_sts_cds", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setSDmdtTrfCd(JSPUtil.getParameter(request, prefix + "s_dmdt_trf_cd", ""));
		setInvFlg(JSPUtil.getParameter(request, prefix + "inv_flg", ""));
		setSessionRhqOfcCd(JSPUtil.getParameter(request, prefix + "session_rhq_ofc_cd", ""));
		setSInvOverFm(JSPUtil.getParameter(request, prefix + "s_inv_over_fm", ""));
		setUsrCntCd(JSPUtil.getParameter(request, prefix + "usr_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IssuedInvoiceParamVO[]
	 */
	public IssuedInvoiceParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IssuedInvoiceParamVO[]
	 */
	public IssuedInvoiceParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IssuedInvoiceParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] caller = (JSPUtil.getParameter(request, prefix	+ "caller", length));
			String[] sInvOverTo = (JSPUtil.getParameter(request, prefix	+ "s_inv_over_to", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] sIssueOfc = (JSPUtil.getParameter(request, prefix	+ "s_issue_ofc", length));
			String[] fmCfmDt = (JSPUtil.getParameter(request, prefix	+ "fm_cfm_dt", length));
			String[] sDmdtInvStsCd = (JSPUtil.getParameter(request, prefix	+ "s_dmdt_inv_sts_cd", length));
			String[] sIssueTo = (JSPUtil.getParameter(request, prefix	+ "s_issue_to", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sBlNo = (JSPUtil.getParameter(request, prefix	+ "s_bl_no", length));
			String[] dateCntr = (JSPUtil.getParameter(request, prefix	+ "date_cntr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sIssueFm = (JSPUtil.getParameter(request, prefix	+ "s_issue_fm", length));
			String[] sScNo = (JSPUtil.getParameter(request, prefix	+ "s_sc_no", length));
			String[] sCustCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cd", length));
			String[] sInvCheck = (JSPUtil.getParameter(request, prefix	+ "s_inv_check", length));
			String[] sChgType = (JSPUtil.getParameter(request, prefix	+ "s_chg_type", length));
			String[] toCfmDt = (JSPUtil.getParameter(request, prefix	+ "to_cfm_dt", length));
			String[] sRfaNo = (JSPUtil.getParameter(request, prefix	+ "s_rfa_no", length));
			String[] sInvoiceNo = (JSPUtil.getParameter(request, prefix	+ "s_invoice_no", length));
			String[] sIssueUsrId = (JSPUtil.getParameter(request, prefix	+ "s_issue_usr_id", length));
			String[] pgmId = (JSPUtil.getParameter(request, prefix	+ "pgm_id", length));
			String[] sCustGubun = (JSPUtil.getParameter(request, prefix	+ "s_cust_gubun", length));
			String[] sGroupBy = (JSPUtil.getParameter(request, prefix	+ "s_group_by", length));
			String[] sDmdtArIfCd = (JSPUtil.getParameter(request, prefix	+ "s_dmdt_ar_if_cd", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] sOfcCheck = (JSPUtil.getParameter(request, prefix	+ "s_ofc_check", length));
			String[] sCntrNo = (JSPUtil.getParameter(request, prefix	+ "s_cntr_no", length));
			String[] sPayerCd = (JSPUtil.getParameter(request, prefix	+ "s_payer_cd", length));
			String[] dmdtChgStsCds = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cds", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] sDmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "s_dmdt_trf_cd", length));
			String[] invFlg = (JSPUtil.getParameter(request, prefix	+ "inv_flg", length));
			String[] sessionRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "session_rhq_ofc_cd", length));
			String[] sInvOverFm = (JSPUtil.getParameter(request, prefix	+ "s_inv_over_fm", length));
			String[] usrCntCd = (JSPUtil.getParameter(request, prefix	+ "usr_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new IssuedInvoiceParamVO();
				if (caller[i] != null)
					model.setCaller(caller[i]);
				if (sInvOverTo[i] != null)
					model.setSInvOverTo(sInvOverTo[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (sIssueOfc[i] != null)
					model.setSIssueOfc(sIssueOfc[i]);
				if (fmCfmDt[i] != null)
					model.setFmCfmDt(fmCfmDt[i]);
				if (sDmdtInvStsCd[i] != null)
					model.setSDmdtInvStsCd(sDmdtInvStsCd[i]);
				if (sIssueTo[i] != null)
					model.setSIssueTo(sIssueTo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sBlNo[i] != null)
					model.setSBlNo(sBlNo[i]);
				if (dateCntr[i] != null)
					model.setDateCntr(dateCntr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sIssueFm[i] != null)
					model.setSIssueFm(sIssueFm[i]);
				if (sScNo[i] != null)
					model.setSScNo(sScNo[i]);
				if (sCustCd[i] != null)
					model.setSCustCd(sCustCd[i]);
				if (sInvCheck[i] != null)
					model.setSInvCheck(sInvCheck[i]);
				if (sChgType[i] != null)
					model.setSChgType(sChgType[i]);
				if (toCfmDt[i] != null)
					model.setToCfmDt(toCfmDt[i]);
				if (sRfaNo[i] != null)
					model.setSRfaNo(sRfaNo[i]);
				if (sInvoiceNo[i] != null)
					model.setSInvoiceNo(sInvoiceNo[i]);
				if (sIssueUsrId[i] != null)
					model.setSIssueUsrId(sIssueUsrId[i]);
				if (pgmId[i] != null)
					model.setPgmId(pgmId[i]);
				if (sCustGubun[i] != null)
					model.setSCustGubun(sCustGubun[i]);
				if (sGroupBy[i] != null)
					model.setSGroupBy(sGroupBy[i]);
				if (sDmdtArIfCd[i] != null)
					model.setSDmdtArIfCd(sDmdtArIfCd[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (sOfcCheck[i] != null)
					model.setSOfcCheck(sOfcCheck[i]);
				if (sCntrNo[i] != null)
					model.setSCntrNo(sCntrNo[i]);
				if (sPayerCd[i] != null)
					model.setSPayerCd(sPayerCd[i]);
				if (dmdtChgStsCds[i] != null)
					model.setDmdtChgStsCds(dmdtChgStsCds[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (sDmdtTrfCd[i] != null)
					model.setSDmdtTrfCd(sDmdtTrfCd[i]);
				if (invFlg[i] != null)
					model.setInvFlg(invFlg[i]);
				if (sessionRhqOfcCd[i] != null)
					model.setSessionRhqOfcCd(sessionRhqOfcCd[i]);
				if (sInvOverFm[i] != null)
					model.setSInvOverFm(sInvOverFm[i]);
				if (usrCntCd[i] != null)
					model.setUsrCntCd(usrCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIssuedInvoiceParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IssuedInvoiceParamVO[]
	 */
	public IssuedInvoiceParamVO[] getIssuedInvoiceParamVOs(){
		IssuedInvoiceParamVO[] vos = (IssuedInvoiceParamVO[])models.toArray(new IssuedInvoiceParamVO[models.size()]);
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
		this.caller = this.caller .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvOverTo = this.sInvOverTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIssueOfc = this.sIssueOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCfmDt = this.fmCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDmdtInvStsCd = this.sDmdtInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIssueTo = this.sIssueTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBlNo = this.sBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateCntr = this.dateCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIssueFm = this.sIssueFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sScNo = this.sScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCd = this.sCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvCheck = this.sInvCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChgType = this.sChgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCfmDt = this.toCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRfaNo = this.sRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvoiceNo = this.sInvoiceNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIssueUsrId = this.sIssueUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmId = this.pgmId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustGubun = this.sCustGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sGroupBy = this.sGroupBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDmdtArIfCd = this.sDmdtArIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCheck = this.sOfcCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrNo = this.sCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPayerCd = this.sPayerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCds = this.dmdtChgStsCds .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDmdtTrfCd = this.sDmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invFlg = this.invFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sessionRhqOfcCd = this.sessionRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvOverFm = this.sInvOverFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrCntCd = this.usrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
