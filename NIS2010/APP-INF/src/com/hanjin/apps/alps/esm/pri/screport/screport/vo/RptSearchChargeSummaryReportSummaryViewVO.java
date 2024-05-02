/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RptSearchChargeSummaryReportSummaryViewVO.java
*@FileTitle : RptSearchChargeSummaryReportSummaryViewVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.31
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.05.31 이혜민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.screport.screport.vo;

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
 * @author 이혜민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RptSearchChargeSummaryReportSummaryViewVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RptSearchChargeSummaryReportSummaryViewVO> models = new ArrayList<RptSearchChargeSummaryReportSummaryViewVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String repChgCd = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String fSlsMon = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ratUsdChgAmt = null;
	/* Column Info */
	private String rvisCntrCustTpCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mdtrCd = null;
	/* Column Info */
	private String cgoCateCd = null;
	/* Column Info */
	private String startDt = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String perCd = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String rgnAcctFlg = null;
	/* Column Info */
	private String newKeyAcctFlg = null;
	/* Column Info */
	private String gloAcctFlg = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String ctrtCustSeq = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String endDt = null;
	/* Column Info */
	private String cltRatio = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String fToMon = null;
	/* Column Info */
	private String custClss = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String fToWk = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String trfUsdChgAmt = null;
	/* Column Info */
	private String fYear = null;
	/* Column Info */
	private String bkgCount = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RptSearchChargeSummaryReportSummaryViewVO() {}

	public RptSearchChargeSummaryReportSummaryViewVO(String ibflag, String pagerows, String ctrtCustCntCd, String repChgCd, String fFmMon, String svcScpCd, String fSlsMon, String chgCd, String ratUsdChgAmt, String rvisCntrCustTpCd, String mdtrCd, String ctrtOfcCd, String startDt, String perCd, String custTpCd, String rgnAcctFlg, String newKeyAcctFlg, String gloAcctFlg, String ctrtCustSeq, String custGrpId, String rhqCd, String fFmWk, String endDt, String cltRatio, String fToMon, String custClss, String fToWk, String custCd, String trfUsdChgAmt, String fYear, String bkgOfcCd, String porCd, String polCd, String podCd, String delCd, String cgoCateCd, String bkgCount) {
		this.porCd = porCd;
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.repChgCd = repChgCd;
		this.fFmMon = fFmMon;
		this.svcScpCd = svcScpCd;
		this.fSlsMon = fSlsMon;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.ratUsdChgAmt = ratUsdChgAmt;
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.mdtrCd = mdtrCd;
		this.cgoCateCd = cgoCateCd;
		this.startDt = startDt;
		this.ctrtOfcCd = ctrtOfcCd;
		this.perCd = perCd;
		this.custTpCd = custTpCd;
		this.rgnAcctFlg = rgnAcctFlg;
		this.newKeyAcctFlg = newKeyAcctFlg;
		this.gloAcctFlg = gloAcctFlg;
		this.bkgOfcCd = bkgOfcCd;
		this.ctrtCustSeq = ctrtCustSeq;
		this.custGrpId = custGrpId;
		this.rhqCd = rhqCd;
		this.fFmWk = fFmWk;
		this.endDt = endDt;
		this.cltRatio = cltRatio;
		this.delCd = delCd;
		this.fToMon = fToMon;
		this.custClss = custClss;
		this.podCd = podCd;
		this.fToWk = fToWk;
		this.custCd = custCd;
		this.trfUsdChgAmt = trfUsdChgAmt;
		this.fYear = fYear;
		this.bkgCount = bkgCount;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("rep_chg_cd", getRepChgCd());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("f_sls_mon", getFSlsMon());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rat_usd_chg_amt", getRatUsdChgAmt());
		this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mdtr_cd", getMdtrCd());
		this.hashColumns.put("cgo_cate_cd", getCgoCateCd());
		this.hashColumns.put("start_dt", getStartDt());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("per_cd", getPerCd());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("rgn_acct_flg", getRgnAcctFlg());
		this.hashColumns.put("new_key_acct_flg", getNewKeyAcctFlg());
		this.hashColumns.put("glo_acct_flg", getGloAcctFlg());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("end_dt", getEndDt());
		this.hashColumns.put("clt_ratio", getCltRatio());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("cust_clss", getCustClss());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("trf_usd_chg_amt", getTrfUsdChgAmt());
		this.hashColumns.put("f_year", getFYear());
		this.hashColumns.put("bkg_count", getBkgCount());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("f_sls_mon", "fSlsMon");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rat_usd_chg_amt", "ratUsdChgAmt");
		this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mdtr_cd", "mdtrCd");
		this.hashFields.put("cgo_cate_cd", "cgoCateCd");
		this.hashFields.put("start_dt", "startDt");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("per_cd", "perCd");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("rgn_acct_flg", "rgnAcctFlg");
		this.hashFields.put("new_key_acct_flg", "newKeyAcctFlg");
		this.hashFields.put("glo_acct_flg", "gloAcctFlg");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("end_dt", "endDt");
		this.hashFields.put("clt_ratio", "cltRatio");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("cust_clss", "custClss");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("trf_usd_chg_amt", "trfUsdChgAmt");
		this.hashFields.put("f_year", "fYear");
		this.hashFields.put("bkg_count", "bkgCount");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustCntCd
	 */
	public String getCtrtCustCntCd() {
		return this.ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return repChgCd
	 */
	public String getRepChgCd() {
		return this.repChgCd;
	}
	
	/**
	 * Column Info
	 * @return fFmMon
	 */
	public String getFFmMon() {
		return this.fFmMon;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return fSlsMon
	 */
	public String getFSlsMon() {
		return this.fSlsMon;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return ratUsdChgAmt
	 */
	public String getRatUsdChgAmt() {
		return this.ratUsdChgAmt;
	}
	
	/**
	 * Column Info
	 * @return rvisCntrCustTpCd
	 */
	public String getRvisCntrCustTpCd() {
		return this.rvisCntrCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return mdtrCd
	 */
	public String getMdtrCd() {
		return this.mdtrCd;
	}
	
	/**
	 * Column Info
	 * @return cgoCateCd
	 */
	public String getCgoCateCd() {
		return this.cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @return startDt
	 */
	public String getStartDt() {
		return this.startDt;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return perCd
	 */
	public String getPerCd() {
		return this.perCd;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return rgnAcctFlg
	 */
	public String getRgnAcctFlg() {
		return this.rgnAcctFlg;
	}
	
	/**
	 * Column Info
	 * @return newKeyAcctFlg
	 */
	public String getNewKeyAcctFlg() {
		return this.newKeyAcctFlg;
	}
	
	/**
	 * Column Info
	 * @return gloAcctFlg
	 */
	public String getGloAcctFlg() {
		return this.gloAcctFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSeq
	 */
	public String getCtrtCustSeq() {
		return this.ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @return custGrpId
	 */
	public String getCustGrpId() {
		return this.custGrpId;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return fFmWk
	 */
	public String getFFmWk() {
		return this.fFmWk;
	}
	
	/**
	 * Column Info
	 * @return endDt
	 */
	public String getEndDt() {
		return this.endDt;
	}
	
	/**
	 * Column Info
	 * @return cltRatio
	 */
	public String getCltRatio() {
		return this.cltRatio;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return fToMon
	 */
	public String getFToMon() {
		return this.fToMon;
	}
	
	/**
	 * Column Info
	 * @return custClss
	 */
	public String getCustClss() {
		return this.custClss;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return fToWk
	 */
	public String getFToWk() {
		return this.fToWk;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return trfUsdChgAmt
	 */
	public String getTrfUsdChgAmt() {
		return this.trfUsdChgAmt;
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
	 * @return bkgCount
	 */
	public String getBkgCount() {
		return this.bkgCount;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustCntCd
	 */
	public void setCtrtCustCntCd(String ctrtCustCntCd) {
		this.ctrtCustCntCd = ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param repChgCd
	 */
	public void setRepChgCd(String repChgCd) {
		this.repChgCd = repChgCd;
	}
	
	/**
	 * Column Info
	 * @param fFmMon
	 */
	public void setFFmMon(String fFmMon) {
		this.fFmMon = fFmMon;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param fSlsMon
	 */
	public void setFSlsMon(String fSlsMon) {
		this.fSlsMon = fSlsMon;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param ratUsdChgAmt
	 */
	public void setRatUsdChgAmt(String ratUsdChgAmt) {
		this.ratUsdChgAmt = ratUsdChgAmt;
	}
	
	/**
	 * Column Info
	 * @param rvisCntrCustTpCd
	 */
	public void setRvisCntrCustTpCd(String rvisCntrCustTpCd) {
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param mdtrCd
	 */
	public void setMdtrCd(String mdtrCd) {
		this.mdtrCd = mdtrCd;
	}
	
	/**
	 * Column Info
	 * @param cgoCateCd
	 */
	public void setCgoCateCd(String cgoCateCd) {
		this.cgoCateCd = cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @param startDt
	 */
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param perCd
	 */
	public void setPerCd(String perCd) {
		this.perCd = perCd;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param rgnAcctFlg
	 */
	public void setRgnAcctFlg(String rgnAcctFlg) {
		this.rgnAcctFlg = rgnAcctFlg;
	}
	
	/**
	 * Column Info
	 * @param newKeyAcctFlg
	 */
	public void setNewKeyAcctFlg(String newKeyAcctFlg) {
		this.newKeyAcctFlg = newKeyAcctFlg;
	}
	
	/**
	 * Column Info
	 * @param gloAcctFlg
	 */
	public void setGloAcctFlg(String gloAcctFlg) {
		this.gloAcctFlg = gloAcctFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSeq
	 */
	public void setCtrtCustSeq(String ctrtCustSeq) {
		this.ctrtCustSeq = ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param fFmWk
	 */
	public void setFFmWk(String fFmWk) {
		this.fFmWk = fFmWk;
	}
	
	/**
	 * Column Info
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	
	/**
	 * Column Info
	 * @param cltRatio
	 */
	public void setCltRatio(String cltRatio) {
		this.cltRatio = cltRatio;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param fToMon
	 */
	public void setFToMon(String fToMon) {
		this.fToMon = fToMon;
	}
	
	/**
	 * Column Info
	 * @param custClss
	 */
	public void setCustClss(String custClss) {
		this.custClss = custClss;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param fToWk
	 */
	public void setFToWk(String fToWk) {
		this.fToWk = fToWk;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param trfUsdChgAmt
	 */
	public void setTrfUsdChgAmt(String trfUsdChgAmt) {
		this.trfUsdChgAmt = trfUsdChgAmt;
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
	 * @param bkgCount
	 */
	public void setBkgCount(String bkgCount) {
		this.bkgCount = bkgCount;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCtrtCustCntCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_cd", ""));
		setRepChgCd(JSPUtil.getParameter(request, prefix + "rep_chg_cd", ""));
		setFFmMon(JSPUtil.getParameter(request, prefix + "f_fm_mon", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setFSlsMon(JSPUtil.getParameter(request, prefix + "f_sls_mon", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRatUsdChgAmt(JSPUtil.getParameter(request, prefix + "rat_usd_chg_amt", ""));
		setRvisCntrCustTpCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMdtrCd(JSPUtil.getParameter(request, prefix + "mdtr_cd", ""));
		setCgoCateCd(JSPUtil.getParameter(request, prefix + "cgo_cate_cd", ""));
		setStartDt(JSPUtil.getParameter(request, prefix + "start_dt", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setPerCd(JSPUtil.getParameter(request, prefix + "per_cd", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setRgnAcctFlg(JSPUtil.getParameter(request, prefix + "rgn_acct_flg", ""));
		setNewKeyAcctFlg(JSPUtil.getParameter(request, prefix + "new_key_acct_flg", ""));
		setGloAcctFlg(JSPUtil.getParameter(request, prefix + "glo_acct_flg", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, prefix + "ctrt_cust_seq", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
		setEndDt(JSPUtil.getParameter(request, prefix + "end_dt", ""));
		setCltRatio(JSPUtil.getParameter(request, prefix + "clt_ratio", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setFToMon(JSPUtil.getParameter(request, prefix + "f_to_mon", ""));
		setCustClss(JSPUtil.getParameter(request, prefix + "cust_clss", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setFToWk(JSPUtil.getParameter(request, prefix + "f_to_wk", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setTrfUsdChgAmt(JSPUtil.getParameter(request, prefix + "trf_usd_chg_amt", ""));
		setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
		setBkgCount(JSPUtil.getParameter(request, prefix + "bkg_count", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RptSearchChargeSummaryReportSummaryViewVO[]
	 */
	public RptSearchChargeSummaryReportSummaryViewVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RptSearchChargeSummaryReportSummaryViewVO[]
	 */
	public RptSearchChargeSummaryReportSummaryViewVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RptSearchChargeSummaryReportSummaryViewVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] repChgCd = (JSPUtil.getParameter(request, prefix	+ "rep_chg_cd", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] fSlsMon = (JSPUtil.getParameter(request, prefix	+ "f_sls_mon", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ratUsdChgAmt = (JSPUtil.getParameter(request, prefix	+ "rat_usd_chg_amt", length));
			String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_cust_tp_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mdtrCd = (JSPUtil.getParameter(request, prefix	+ "mdtr_cd", length));
			String[] cgoCateCd = (JSPUtil.getParameter(request, prefix	+ "cgo_cate_cd", length));
			String[] startDt = (JSPUtil.getParameter(request, prefix	+ "start_dt", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] perCd = (JSPUtil.getParameter(request, prefix	+ "per_cd", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] rgnAcctFlg = (JSPUtil.getParameter(request, prefix	+ "rgn_acct_flg", length));
			String[] newKeyAcctFlg = (JSPUtil.getParameter(request, prefix	+ "new_key_acct_flg", length));
			String[] gloAcctFlg = (JSPUtil.getParameter(request, prefix	+ "glo_acct_flg", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] endDt = (JSPUtil.getParameter(request, prefix	+ "end_dt", length));
			String[] cltRatio = (JSPUtil.getParameter(request, prefix	+ "clt_ratio", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] custClss = (JSPUtil.getParameter(request, prefix	+ "cust_clss", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] trfUsdChgAmt = (JSPUtil.getParameter(request, prefix	+ "trf_usd_chg_amt", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			String[] bkgCount = (JSPUtil.getParameter(request, prefix	+ "bkg_count", length));
			
			for (int i = 0; i < length; i++) {
				model = new RptSearchChargeSummaryReportSummaryViewVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (repChgCd[i] != null)
					model.setRepChgCd(repChgCd[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (fSlsMon[i] != null)
					model.setFSlsMon(fSlsMon[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ratUsdChgAmt[i] != null)
					model.setRatUsdChgAmt(ratUsdChgAmt[i]);
				if (rvisCntrCustTpCd[i] != null)
					model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mdtrCd[i] != null)
					model.setMdtrCd(mdtrCd[i]);
				if (cgoCateCd[i] != null)
					model.setCgoCateCd(cgoCateCd[i]);
				if (startDt[i] != null)
					model.setStartDt(startDt[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (perCd[i] != null)
					model.setPerCd(perCd[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (rgnAcctFlg[i] != null)
					model.setRgnAcctFlg(rgnAcctFlg[i]);
				if (newKeyAcctFlg[i] != null)
					model.setNewKeyAcctFlg(newKeyAcctFlg[i]);
				if (gloAcctFlg[i] != null)
					model.setGloAcctFlg(gloAcctFlg[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (ctrtCustSeq[i] != null)
					model.setCtrtCustSeq(ctrtCustSeq[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (endDt[i] != null)
					model.setEndDt(endDt[i]);
				if (cltRatio[i] != null)
					model.setCltRatio(cltRatio[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (fToMon[i] != null)
					model.setFToMon(fToMon[i]);
				if (custClss[i] != null)
					model.setCustClss(custClss[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (trfUsdChgAmt[i] != null)
					model.setTrfUsdChgAmt(trfUsdChgAmt[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				if (bkgCount[i] != null)
					model.setBkgCount(bkgCount[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRptSearchChargeSummaryReportSummaryViewVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RptSearchChargeSummaryReportSummaryViewVO[]
	 */
	public RptSearchChargeSummaryReportSummaryViewVO[] getRptSearchChargeSummaryReportSummaryViewVOs(){
		RptSearchChargeSummaryReportSummaryViewVO[] vos = (RptSearchChargeSummaryReportSummaryViewVO[])models.toArray(new RptSearchChargeSummaryReportSummaryViewVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repChgCd = this.repChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlsMon = this.fSlsMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUsdChgAmt = this.ratUsdChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrCustTpCd = this.rvisCntrCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdtrCd = this.mdtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCateCd = this.cgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startDt = this.startDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perCd = this.perCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnAcctFlg = this.rgnAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newKeyAcctFlg = this.newKeyAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAcctFlg = this.gloAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDt = this.endDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltRatio = this.cltRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custClss = this.custClss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfUsdChgAmt = this.trfUsdChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCount = this.bkgCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
