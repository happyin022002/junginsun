/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RptSearchChargeSummaryReportBlInquiryVO.java
*@FileTitle : RptSearchChargeSummaryReportBlInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.04
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.06.04 이혜민 
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
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이혜민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RptSearchChargeSummaryReportBlInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RptSearchChargeSummaryReportBlInquiryVO> models = new ArrayList<RptSearchChargeSummaryReportBlInquiryVO>();
	
	/* Column Info */
	private String repChgCd = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String fSlsMon = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String rvisCntrCustTpCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cgoCateCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String perCd = null;
	/* Column Info */
	private String gloAcctFlg = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String bkgPorCd = null;
	/* Column Info */
	private String feu = null;
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
	private String frtTermCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String fToMon = null;
	/* Column Info */
	private String podCntCd = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCntCd = null;
	/* Column Info */
	private String fToWk = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String uiId = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String trfUsdChgAmt = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String fYear = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ratUsdChgAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mdtrCd = null;
	/* Column Info */
	private String ratChgAmt = null;
	/* Column Info */
	private String bkgDelCd = null;
	/* Column Info */
	private String startDt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String rgnAcctFlg = null;
	/* Column Info */
	private String newKeyAcctFlg = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String cltRatio = null;
	/* Column Info */
	private String custClss = null;
	/* Column Info */
	private String rdTermCd = null;
	/* Column Info */
	private String fExcel = null;
	/* DB RowSet 객체  */
	private DBRowSet rowSet = null;	
	
	/* DB RowSet 객체  */
	private DBRowSet[] rowSets = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RptSearchChargeSummaryReportBlInquiryVO() {}

	public RptSearchChargeSummaryReportBlInquiryVO(String ibflag, String pagerows, String repChgCd, String fFmMon, String svcScpCd, String trdCd, String rlaneCd, String fSlsMon, String chgCd, String ctrtNo, String rvisCntrCustTpCd, String bkgPodCd, String costYrmon, String vvdCd, String cgoCateCd, String ctrtOfcCd, String perCd, String gloAcctFlg, String feu, String bkgPorCd, String custGrpId, String ctrtCustSeq, String fFmWk, String rhqCd, String endDt, String fToMon, String podCntCd, String custLglEngNm, String polCntCd, String fToWk, String bkgNo, String custCd, String costWk, String teu, String trfUsdChgAmt, String subTrdCd, String fYear, String region, String ctrtCustCntCd, String currCd, String ratUsdChgAmt, String mdtrCd, String ratChgAmt, String bkgDelCd, String startDt, String dirCd, String custTpCd, String rgnAcctFlg, String newKeyAcctFlg, String bkgPolCd, String cltRatio, String custClss, String rdTermCd, String frtTermCd, String bkgOfcCd, String polCd, String delCd, String podCd, String porCd, String uiId, String fExcel) {
		this.repChgCd = repChgCd;
		this.fFmMon = fFmMon;
		this.svcScpCd = svcScpCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.fSlsMon = fSlsMon;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.ctrtNo = ctrtNo;
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
		this.polCd = polCd;
		this.bkgPodCd = bkgPodCd;
		this.costYrmon = costYrmon;
		this.vvdCd = vvdCd;
		this.cgoCateCd = cgoCateCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.perCd = perCd;
		this.gloAcctFlg = gloAcctFlg;
		this.bkgOfcCd = bkgOfcCd;
		this.bkgPorCd = bkgPorCd;
		this.feu = feu;
		this.ctrtCustSeq = ctrtCustSeq;
		this.custGrpId = custGrpId;
		this.rhqCd = rhqCd;
		this.fFmWk = fFmWk;
		this.endDt = endDt;
		this.frtTermCd = frtTermCd;
		this.delCd = delCd;
		this.fToMon = fToMon;
		this.podCntCd = podCntCd;
		this.custLglEngNm = custLglEngNm;
		this.podCd = podCd;
		this.polCntCd = polCntCd;
		this.fToWk = fToWk;
		this.bkgNo = bkgNo;
		this.custCd = custCd;
		this.costWk = costWk;
		this.uiId = uiId;
		this.teu = teu;
		this.trfUsdChgAmt = trfUsdChgAmt;
		this.subTrdCd = subTrdCd;
		this.fYear = fYear;
		this.porCd = porCd;
		this.region = region;
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.currCd = currCd;
		this.ratUsdChgAmt = ratUsdChgAmt;
		this.ibflag = ibflag;
		this.mdtrCd = mdtrCd;
		this.ratChgAmt = ratChgAmt;
		this.bkgDelCd = bkgDelCd;
		this.startDt = startDt;
		this.dirCd = dirCd;
		this.custTpCd = custTpCd;
		this.rgnAcctFlg = rgnAcctFlg;
		this.newKeyAcctFlg = newKeyAcctFlg;
		this.bkgPolCd = bkgPolCd;
		this.cltRatio = cltRatio;
		this.custClss = custClss;
		this.rdTermCd = rdTermCd;
		this.fExcel = fExcel;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rep_chg_cd", getRepChgCd());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("f_sls_mon", getFSlsMon());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cgo_cate_cd", getCgoCateCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("per_cd", getPerCd());
		this.hashColumns.put("glo_acct_flg", getGloAcctFlg());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("bkg_por_cd", getBkgPorCd());
		this.hashColumns.put("feu", getFeu());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("end_dt", getEndDt());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("pod_cnt_cd", getPodCntCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cnt_cd", getPolCntCd());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("ui_id", getUiId());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("trf_usd_chg_amt", getTrfUsdChgAmt());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("f_year", getFYear());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rat_usd_chg_amt", getRatUsdChgAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mdtr_cd", getMdtrCd());
		this.hashColumns.put("rat_chg_amt", getRatChgAmt());
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());
		this.hashColumns.put("start_dt", getStartDt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("rgn_acct_flg", getRgnAcctFlg());
		this.hashColumns.put("new_key_acct_flg", getNewKeyAcctFlg());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("clt_ratio", getCltRatio());
		this.hashColumns.put("cust_clss", getCustClss());
		this.hashColumns.put("rd_term_cd", getRdTermCd());
		this.hashColumns.put("rd_term_cd", getRdTermCd());
		this.hashColumns.put("f_excel", getFExcel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("f_sls_mon", "fSlsMon");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cgo_cate_cd", "cgoCateCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("per_cd", "perCd");
		this.hashFields.put("glo_acct_flg", "gloAcctFlg");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("bkg_por_cd", "bkgPorCd");
		this.hashFields.put("feu", "feu");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("end_dt", "endDt");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("pod_cnt_cd", "podCntCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pol_cnt_cd", "polCntCd");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("ui_id", "uiId");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("trf_usd_chg_amt", "trfUsdChgAmt");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("f_year", "fYear");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("region", "region");
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rat_usd_chg_amt", "ratUsdChgAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mdtr_cd", "mdtrCd");
		this.hashFields.put("rat_chg_amt", "ratChgAmt");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		this.hashFields.put("start_dt", "startDt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("rgn_acct_flg", "rgnAcctFlg");
		this.hashFields.put("new_key_acct_flg", "newKeyAcctFlg");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("clt_ratio", "cltRatio");
		this.hashFields.put("cust_clss", "custClss");
		this.hashFields.put("rd_term_cd", "rdTermCd");
		this.hashFields.put("f_excel", "fExcel");
		return this.hashFields;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
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
	 * Column Info
	 * @return bkgPodCd
	 */
	public String getBkgPodCd() {
		return this.bkgPodCd;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
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
	 * @return cgoCateCd
	 */
	public String getCgoCateCd() {
		return this.cgoCateCd;
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
	 * @return bkgPorCd
	 */
	public String getBkgPorCd() {
		return this.bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @return feu
	 */
	public String getFeu() {
		return this.feu;
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
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
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
	 * @return podCntCd
	 */
	public String getPodCntCd() {
		return this.podCntCd;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @return polCntCd
	 */
	public String getPolCntCd() {
		return this.polCntCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return uiId
	 */
	public String getUiId() {
		return this.uiId;
	}
	
	/**
	 * Column Info
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return ratUsdChgAmt
	 */
	public String getRatUsdChgAmt() {
		return this.ratUsdChgAmt;
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
	 * @return ratChgAmt
	 */
	public String getRatChgAmt() {
		return this.ratChgAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgDelCd
	 */
	public String getBkgDelCd() {
		return this.bkgDelCd;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
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
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
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
	 * @return custClss
	 */
	public String getCustClss() {
		return this.custClss;
	}
	
	/**
	 * Column Info
	 * @return rdTermCd
	 */
	public String getRdTermCd() {
		return this.rdTermCd;
	}
	
	/**
	 * Column Info
	 * @return fExcel
	 */
	public String getFExcel() {
		return this.fExcel;
	}

	/** DBRowSet Getter */
	public DBRowSet getRowSet() {
		return rowSet;
	}
	
	/** DBRowSets Getter */
	public DBRowSet[] getRowSets() {
		return rowSets;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
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
	 * Column Info
	 * @param bkgPodCd
	 */
	public void setBkgPodCd(String bkgPodCd) {
		this.bkgPodCd = bkgPodCd;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
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
	 * @param cgoCateCd
	 */
	public void setCgoCateCd(String cgoCateCd) {
		this.cgoCateCd = cgoCateCd;
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
	 * @param bkgPorCd
	 */
	public void setBkgPorCd(String bkgPorCd) {
		this.bkgPorCd = bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @param feu
	 */
	public void setFeu(String feu) {
		this.feu = feu;
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
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
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
	 * @param podCntCd
	 */
	public void setPodCntCd(String podCntCd) {
		this.podCntCd = podCntCd;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
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
	 * @param polCntCd
	 */
	public void setPolCntCd(String polCntCd) {
		this.polCntCd = polCntCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param uiId
	 */
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}
	
	/**
	 * Column Info
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param ratUsdChgAmt
	 */
	public void setRatUsdChgAmt(String ratUsdChgAmt) {
		this.ratUsdChgAmt = ratUsdChgAmt;
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
	 * @param ratChgAmt
	 */
	public void setRatChgAmt(String ratChgAmt) {
		this.ratChgAmt = ratChgAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgDelCd
	 */
	public void setBkgDelCd(String bkgDelCd) {
		this.bkgDelCd = bkgDelCd;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
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
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
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
	 * @param custClss
	 */
	public void setCustClss(String custClss) {
		this.custClss = custClss;
	}
	
	/**
	 * Column Info
	 * @param rdTermCd
	 */
	public void setRdTermCd(String rdTermCd) {
		this.rdTermCd = rdTermCd;
	}
	
	/**
	 * Column Info
	 * @param fExcel
	 */
	public void setFExcel(String fExcel) {
		this.fExcel = fExcel;
	}
	
	/** DBRowSet Setter */
	public void setRowSet(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}
	
	/** DBRowSets Setter */
	public void setRowSets(DBRowSet[] rowSets) {
		this.rowSets = rowSets;
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
		setRepChgCd(JSPUtil.getParameter(request, prefix + "rep_chg_cd", ""));
		setFFmMon(JSPUtil.getParameter(request, prefix + "f_fm_mon", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setFSlsMon(JSPUtil.getParameter(request, prefix + "f_sls_mon", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setRvisCntrCustTpCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCgoCateCd(JSPUtil.getParameter(request, prefix + "cgo_cate_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setPerCd(JSPUtil.getParameter(request, prefix + "per_cd", ""));
		setGloAcctFlg(JSPUtil.getParameter(request, prefix + "glo_acct_flg", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setBkgPorCd(JSPUtil.getParameter(request, prefix + "bkg_por_cd", ""));
		setFeu(JSPUtil.getParameter(request, prefix + "feu", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, prefix + "ctrt_cust_seq", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
		setEndDt(JSPUtil.getParameter(request, prefix + "end_dt", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setFToMon(JSPUtil.getParameter(request, prefix + "f_to_mon", ""));
		setPodCntCd(JSPUtil.getParameter(request, prefix + "pod_cnt_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPolCntCd(JSPUtil.getParameter(request, prefix + "pol_cnt_cd", ""));
		setFToWk(JSPUtil.getParameter(request, prefix + "f_to_wk", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setUiId(JSPUtil.getParameter(request, prefix + "ui_id", ""));
		setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
		setTrfUsdChgAmt(JSPUtil.getParameter(request, prefix + "trf_usd_chg_amt", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setRegion(JSPUtil.getParameter(request, prefix + "region", ""));
		setCtrtCustCntCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setRatUsdChgAmt(JSPUtil.getParameter(request, prefix + "rat_usd_chg_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMdtrCd(JSPUtil.getParameter(request, prefix + "mdtr_cd", ""));
		setRatChgAmt(JSPUtil.getParameter(request, prefix + "rat_chg_amt", ""));
		setBkgDelCd(JSPUtil.getParameter(request, prefix + "bkg_del_cd", ""));
		setStartDt(JSPUtil.getParameter(request, prefix + "start_dt", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setRgnAcctFlg(JSPUtil.getParameter(request, prefix + "rgn_acct_flg", ""));
		setNewKeyAcctFlg(JSPUtil.getParameter(request, prefix + "new_key_acct_flg", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setCltRatio(JSPUtil.getParameter(request, prefix + "clt_ratio", ""));
		setCustClss(JSPUtil.getParameter(request, prefix + "cust_clss", ""));
		setRdTermCd(JSPUtil.getParameter(request, prefix + "rd_term_cd", ""));
		setFExcel(JSPUtil.getParameter(request, prefix + "f_excel", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RptSearchChargeSummaryReportBlInquiryVO[]
	 */
	public RptSearchChargeSummaryReportBlInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RptSearchChargeSummaryReportBlInquiryVO[]
	 */
	public RptSearchChargeSummaryReportBlInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RptSearchChargeSummaryReportBlInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] repChgCd = (JSPUtil.getParameter(request, prefix	+ "rep_chg_cd", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] fSlsMon = (JSPUtil.getParameter(request, prefix	+ "f_sls_mon", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_cust_tp_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cgoCateCd = (JSPUtil.getParameter(request, prefix	+ "cgo_cate_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] perCd = (JSPUtil.getParameter(request, prefix	+ "per_cd", length));
			String[] gloAcctFlg = (JSPUtil.getParameter(request, prefix	+ "glo_acct_flg", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] bkgPorCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cd", length));
			String[] feu = (JSPUtil.getParameter(request, prefix	+ "feu", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] endDt = (JSPUtil.getParameter(request, prefix	+ "end_dt", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] podCntCd = (JSPUtil.getParameter(request, prefix	+ "pod_cnt_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] polCntCd = (JSPUtil.getParameter(request, prefix	+ "pol_cnt_cd", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] uiId = (JSPUtil.getParameter(request, prefix	+ "ui_id", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] trfUsdChgAmt = (JSPUtil.getParameter(request, prefix	+ "trf_usd_chg_amt", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ratUsdChgAmt = (JSPUtil.getParameter(request, prefix	+ "rat_usd_chg_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mdtrCd = (JSPUtil.getParameter(request, prefix	+ "mdtr_cd", length));
			String[] ratChgAmt = (JSPUtil.getParameter(request, prefix	+ "rat_chg_amt", length));
			String[] bkgDelCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cd", length));
			String[] startDt = (JSPUtil.getParameter(request, prefix	+ "start_dt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] rgnAcctFlg = (JSPUtil.getParameter(request, prefix	+ "rgn_acct_flg", length));
			String[] newKeyAcctFlg = (JSPUtil.getParameter(request, prefix	+ "new_key_acct_flg", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] cltRatio = (JSPUtil.getParameter(request, prefix	+ "clt_ratio", length));
			String[] custClss = (JSPUtil.getParameter(request, prefix	+ "cust_clss", length));
			String[] rdTermCd = (JSPUtil.getParameter(request, prefix	+ "rd_term_cd", length));
			String[] fExcel = (JSPUtil.getParameter(request, prefix	+ "f_excel", length));

			for (int i = 0; i < length; i++) {
				model = new RptSearchChargeSummaryReportBlInquiryVO();
				if (repChgCd[i] != null)
					model.setRepChgCd(repChgCd[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (fSlsMon[i] != null)
					model.setFSlsMon(fSlsMon[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (rvisCntrCustTpCd[i] != null)
					model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cgoCateCd[i] != null)
					model.setCgoCateCd(cgoCateCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (perCd[i] != null)
					model.setPerCd(perCd[i]);
				if (gloAcctFlg[i] != null)
					model.setGloAcctFlg(gloAcctFlg[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (bkgPorCd[i] != null)
					model.setBkgPorCd(bkgPorCd[i]);
				if (feu[i] != null)
					model.setFeu(feu[i]);
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
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (fToMon[i] != null)
					model.setFToMon(fToMon[i]);
				if (podCntCd[i] != null)
					model.setPodCntCd(podCntCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCntCd[i] != null)
					model.setPolCntCd(polCntCd[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (uiId[i] != null)
					model.setUiId(uiId[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (trfUsdChgAmt[i] != null)
					model.setTrfUsdChgAmt(trfUsdChgAmt[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (region[i] != null)
					model.setRegion(region[i]);
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ratUsdChgAmt[i] != null)
					model.setRatUsdChgAmt(ratUsdChgAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mdtrCd[i] != null)
					model.setMdtrCd(mdtrCd[i]);
				if (ratChgAmt[i] != null)
					model.setRatChgAmt(ratChgAmt[i]);
				if (bkgDelCd[i] != null)
					model.setBkgDelCd(bkgDelCd[i]);
				if (startDt[i] != null)
					model.setStartDt(startDt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (rgnAcctFlg[i] != null)
					model.setRgnAcctFlg(rgnAcctFlg[i]);
				if (newKeyAcctFlg[i] != null)
					model.setNewKeyAcctFlg(newKeyAcctFlg[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (cltRatio[i] != null)
					model.setCltRatio(cltRatio[i]);
				if (custClss[i] != null)
					model.setCustClss(custClss[i]);
				if (rdTermCd[i] != null)
					model.setRdTermCd(rdTermCd[i]);
				if (fExcel[i] != null)
					model.setFExcel(fExcel[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRptSearchChargeSummaryReportBlInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RptSearchChargeSummaryReportBlInquiryVO[]
	 */
	public RptSearchChargeSummaryReportBlInquiryVO[] getRptSearchChargeSummaryReportBlInquiryVOs(){
		RptSearchChargeSummaryReportBlInquiryVO[] vos = (RptSearchChargeSummaryReportBlInquiryVO[])models.toArray(new RptSearchChargeSummaryReportBlInquiryVO[models.size()]);
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
		this.repChgCd = this.repChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlsMon = this.fSlsMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrCustTpCd = this.rvisCntrCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCateCd = this.cgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perCd = this.perCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAcctFlg = this.gloAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCd = this.bkgPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feu = this.feu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDt = this.endDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCntCd = this.podCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCntCd = this.polCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiId = this.uiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfUsdChgAmt = this.trfUsdChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUsdChgAmt = this.ratUsdChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdtrCd = this.mdtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratChgAmt = this.ratChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd = this.bkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startDt = this.startDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnAcctFlg = this.rgnAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newKeyAcctFlg = this.newKeyAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltRatio = this.cltRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custClss = this.custClss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdTermCd = this.rdTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fExcel = this.fExcel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
