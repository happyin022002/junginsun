/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DEMDETCostReportbyBKGDetailVO.java
*@FileTitle : DEMDETCostReportbyBKGDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2016.03.21 최덕우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최덕우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DEMDETCostReportbyBKGDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DEMDETCostReportbyBKGDetailVO> models = new ArrayList<DEMDETCostReportbyBKGDetailVO>();
	
	/* Column Info */
	private String pdRtAmt = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String fNode = null;
	/* Column Info */
	private String fItems = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trfCd = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String bkgBndCd = null;
	/* Column Info */
	private String fDelNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String costTtlAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntrToDt = null;
	/* Column Info */
	private String costWthnFtAmt = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String scCustNm = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String fToMon = null;
	/* Column Info */
	private String fScNo = null;
	/* Column Info */
	private String fToWk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String fToyearmonth = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String costAftFtAmt = null;
	/* Column Info */
	private String fYear = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String fBndCd = null;
	/* Column Info */
	private String fChkprd = null;
	/* Column Info */
	private String cntrSts = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fCntrTpszCd = null;
	/* Column Info */
	private String bilAmt = null;
	/* Column Info */
	private String fPorNo = null;
	/* Column Info */
	private String fFmyearmonth = null;
	/* Column Info */
	private String cntrToMvmtStsCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String stayDys = null;
	/* Column Info */
	private String rfaCustNm = null;
	/* Column Info */
	private String cntrFmMvmtStsCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String ftEndDt = null;
	/* Column Info */
	private String itmNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cntrFmDt = null;
	/* Column Info */
	private String stoWthnFtAmt = null;
	/* Column Info */
	private String cntrFmNodCd = null;
	/* Column Info */
	private String itmDesc = null;
	/* Column Info */
	private String invChgAmt = null;
	/* Column Info */
	private String fCntrSts = null;
	/* Column Info */
	private String fItem = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String fTariff = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrToNodCd = null;
	/* Column Info */
	private String fCntrno = null;
	/* Column Info */
	private String fBkgno = null;
	/* Column Info */
	private String orgChgAmt = null;
	/* Column Info */
	private String fRfaNo = null;
	/* Column Info */
	private String stoAftFtAmt = null;
	/* Column Info */
	private String chssTermCd = null;
	/* Column Info */
	private String divNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DEMDETCostReportbyBKGDetailVO() {}

	public DEMDETCostReportbyBKGDetailVO(String ibflag, String pagerows, String pdRtAmt, String fFmMon, String fNode, String trfCd, String costYrmon, String bkgBndCd, String fDelNo, String scNo, String cntrTpszCd, String costTtlAmt, String cntrToDt, String updUsrId, String costWthnFtAmt, String fFmWk, String delCd, String scCustNm, String fToMon, String cnmvEvntDt, String fScNo, String fToWk, String bkgNo, String creUsrId, String fToyearmonth, String costWk, String costAftFtAmt, String fYear, String porCd, String fChkprd, String cntrSts, String creDt, String fCntrTpszCd, String bilAmt, String fPorNo, String fFmyearmonth, String cntrToMvmtStsCd, String rfaNo, String stayDys, String rfaCustNm, String cntrFmMvmtStsCd, String rcvTermCd, String ftEndDt, String itmNm, String updDt, String cntrFmDt, String stoWthnFtAmt, String cntrFmNodCd, String itmDesc, String invChgAmt, String fCntrSts, String fItem, String deTermCd, String fTariff, String mvmtStsCd, String ftDys, String cntrNo, String fCntrno, String cntrToNodCd, String fBkgno, String orgChgAmt, String fRfaNo, String divNm, String chssTermCd, String stoAftFtAmt, String fBndCd, String fItems) {
		this.pdRtAmt = pdRtAmt;
		this.fFmMon = fFmMon;
		this.fNode = fNode;
		this.fItems = fItems;
		this.pagerows = pagerows;
		this.trfCd = trfCd;
		this.costYrmon = costYrmon;
		this.bkgBndCd = bkgBndCd;
		this.fDelNo = fDelNo;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.costTtlAmt = costTtlAmt;
		this.updUsrId = updUsrId;
		this.cntrToDt = cntrToDt;
		this.costWthnFtAmt = costWthnFtAmt;
		this.fFmWk = fFmWk;
		this.scCustNm = scCustNm;
		this.delCd = delCd;
		this.cnmvEvntDt = cnmvEvntDt;
		this.fToMon = fToMon;
		this.fScNo = fScNo;
		this.fToWk = fToWk;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.fToyearmonth = fToyearmonth;
		this.costWk = costWk;
		this.costAftFtAmt = costAftFtAmt;
		this.fYear = fYear;
		this.porCd = porCd;
		this.fBndCd = fBndCd;
		this.fChkprd = fChkprd;
		this.cntrSts = cntrSts;
		this.creDt = creDt;
		this.fCntrTpszCd = fCntrTpszCd;
		this.bilAmt = bilAmt;
		this.fPorNo = fPorNo;
		this.fFmyearmonth = fFmyearmonth;
		this.cntrToMvmtStsCd = cntrToMvmtStsCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.stayDys = stayDys;
		this.rfaCustNm = rfaCustNm;
		this.cntrFmMvmtStsCd = cntrFmMvmtStsCd;
		this.rcvTermCd = rcvTermCd;
		this.ftEndDt = ftEndDt;
		this.itmNm = itmNm;
		this.updDt = updDt;
		this.cntrFmDt = cntrFmDt;
		this.stoWthnFtAmt = stoWthnFtAmt;
		this.cntrFmNodCd = cntrFmNodCd;
		this.itmDesc = itmDesc;
		this.invChgAmt = invChgAmt;
		this.fCntrSts = fCntrSts;
		this.fItem = fItem;
		this.deTermCd = deTermCd;
		this.mvmtStsCd = mvmtStsCd;
		this.fTariff = fTariff;
		this.ftDys = ftDys;
		this.cntrNo = cntrNo;
		this.cntrToNodCd = cntrToNodCd;
		this.fCntrno = fCntrno;
		this.fBkgno = fBkgno;
		this.orgChgAmt = orgChgAmt;
		this.fRfaNo = fRfaNo;
		this.stoAftFtAmt = stoAftFtAmt;
		this.chssTermCd = chssTermCd;
		this.divNm = divNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pd_rt_amt", getPdRtAmt());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("f_node", getFNode());
		this.hashColumns.put("f_items", getFItems());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trf_cd", getTrfCd());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("bkg_bnd_cd", getBkgBndCd());
		this.hashColumns.put("f_del_no", getFDelNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cost_ttl_amt", getCostTtlAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_to_dt", getCntrToDt());
		this.hashColumns.put("cost_wthn_ft_amt", getCostWthnFtAmt());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("sc_cust_nm", getScCustNm());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("f_sc_no", getFScNo());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("f_toyearmonth", getFToyearmonth());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("cost_aft_ft_amt", getCostAftFtAmt());
		this.hashColumns.put("f_year", getFYear());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("f_bnd_cd", getFBndCd());
		this.hashColumns.put("f_chkprd", getFChkprd());
		this.hashColumns.put("cntr_sts", getCntrSts());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("f_cntr_tpsz_cd", getFCntrTpszCd());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("f_por_no", getFPorNo());
		this.hashColumns.put("f_fmyearmonth", getFFmyearmonth());
		this.hashColumns.put("cntr_to_mvmt_sts_cd", getCntrToMvmtStsCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("stay_dys", getStayDys());
		this.hashColumns.put("rfa_cust_nm", getRfaCustNm());
		this.hashColumns.put("cntr_fm_mvmt_sts_cd", getCntrFmMvmtStsCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("itm_nm", getItmNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cntr_fm_dt", getCntrFmDt());
		this.hashColumns.put("sto_wthn_ft_amt", getStoWthnFtAmt());
		this.hashColumns.put("cntr_fm_nod_cd", getCntrFmNodCd());
		this.hashColumns.put("itm_desc", getItmDesc());
		this.hashColumns.put("inv_chg_amt", getInvChgAmt());
		this.hashColumns.put("f_cntr_sts", getFCntrSts());
		this.hashColumns.put("f_item", getFItem());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("f_tariff", getFTariff());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_to_nod_cd", getCntrToNodCd());
		this.hashColumns.put("f_cntrno", getFCntrno());
		this.hashColumns.put("f_bkgno", getFBkgno());
		this.hashColumns.put("org_chg_amt", getOrgChgAmt());
		this.hashColumns.put("f_rfa_no", getFRfaNo());
		this.hashColumns.put("sto_aft_ft_amt", getStoAftFtAmt());
		this.hashColumns.put("chss_term_cd", getChssTermCd());
		this.hashColumns.put("div_nm", getDivNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pd_rt_amt", "pdRtAmt");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("f_node", "fNode");
		this.hashFields.put("f_items", "fItems");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trf_cd", "trfCd");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("bkg_bnd_cd", "bkgBndCd");
		this.hashFields.put("f_del_no", "fDelNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cost_ttl_amt", "costTtlAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_to_dt", "cntrToDt");
		this.hashFields.put("cost_wthn_ft_amt", "costWthnFtAmt");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("sc_cust_nm", "scCustNm");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("f_sc_no", "fScNo");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("f_toyearmonth", "fToyearmonth");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("cost_aft_ft_amt", "costAftFtAmt");
		this.hashFields.put("f_year", "fYear");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("f_bnd_cd", "fBndCd");
		this.hashFields.put("f_chkprd", "fChkprd");
		this.hashFields.put("cntr_sts", "cntrSts");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("f_cntr_tpsz_cd", "fCntrTpszCd");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("f_por_no", "fPorNo");
		this.hashFields.put("f_fmyearmonth", "fFmyearmonth");
		this.hashFields.put("cntr_to_mvmt_sts_cd", "cntrToMvmtStsCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("stay_dys", "stayDys");
		this.hashFields.put("rfa_cust_nm", "rfaCustNm");
		this.hashFields.put("cntr_fm_mvmt_sts_cd", "cntrFmMvmtStsCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("itm_nm", "itmNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cntr_fm_dt", "cntrFmDt");
		this.hashFields.put("sto_wthn_ft_amt", "stoWthnFtAmt");
		this.hashFields.put("cntr_fm_nod_cd", "cntrFmNodCd");
		this.hashFields.put("itm_desc", "itmDesc");
		this.hashFields.put("inv_chg_amt", "invChgAmt");
		this.hashFields.put("f_cntr_sts", "fCntrSts");
		this.hashFields.put("f_item", "fItem");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("f_tariff", "fTariff");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_to_nod_cd", "cntrToNodCd");
		this.hashFields.put("f_cntrno", "fCntrno");
		this.hashFields.put("f_bkgno", "fBkgno");
		this.hashFields.put("org_chg_amt", "orgChgAmt");
		this.hashFields.put("f_rfa_no", "fRfaNo");
		this.hashFields.put("sto_aft_ft_amt", "stoAftFtAmt");
		this.hashFields.put("chss_term_cd", "chssTermCd");
		this.hashFields.put("div_nm", "divNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pdRtAmt
	 */
	public String getPdRtAmt() {
		return this.pdRtAmt;
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
	 * @return fNode
	 */
	public String getFNode() {
		return this.fNode;
	}
	
	/**
	 * Column Info
	 * @return fItems
	 */
	public String getFItems() {
		return this.fItems;
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
	 * @return trfCd
	 */
	public String getTrfCd() {
		return this.trfCd;
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
	 * @return bkgBndCd
	 */
	public String getBkgBndCd() {
		return this.bkgBndCd;
	}
	
	/**
	 * Column Info
	 * @return fDelNo
	 */
	public String getFDelNo() {
		return this.fDelNo;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return costTtlAmt
	 */
	public String getCostTtlAmt() {
		return this.costTtlAmt;
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
	 * @return cntrToDt
	 */
	public String getCntrToDt() {
		return this.cntrToDt;
	}
	
	/**
	 * Column Info
	 * @return costWthnFtAmt
	 */
	public String getCostWthnFtAmt() {
		return this.costWthnFtAmt;
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
	 * @return scCustNm
	 */
	public String getScCustNm() {
		return this.scCustNm;
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
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
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
	 * @return fScNo
	 */
	public String getFScNo() {
		return this.fScNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return fToyearmonth
	 */
	public String getFToyearmonth() {
		return this.fToyearmonth;
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
	 * @return costAftFtAmt
	 */
	public String getCostAftFtAmt() {
		return this.costAftFtAmt;
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
	 * @return fBndCd
	 */
	public String getFBndCd() {
		return this.fBndCd;
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
	 * @return cntrSts
	 */
	public String getCntrSts() {
		return this.cntrSts;
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
	 * @return fCntrTpszCd
	 */
	public String getFCntrTpszCd() {
		return this.fCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return bilAmt
	 */
	public String getBilAmt() {
		return this.bilAmt;
	}
	
	/**
	 * Column Info
	 * @return fPorNo
	 */
	public String getFPorNo() {
		return this.fPorNo;
	}
	
	/**
	 * Column Info
	 * @return fFmyearmonth
	 */
	public String getFFmyearmonth() {
		return this.fFmyearmonth;
	}
	
	/**
	 * Column Info
	 * @return cntrToMvmtStsCd
	 */
	public String getCntrToMvmtStsCd() {
		return this.cntrToMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return stayDys
	 */
	public String getStayDys() {
		return this.stayDys;
	}
	
	/**
	 * Column Info
	 * @return rfaCustNm
	 */
	public String getRfaCustNm() {
		return this.rfaCustNm;
	}
	
	/**
	 * Column Info
	 * @return cntrFmMvmtStsCd
	 */
	public String getCntrFmMvmtStsCd() {
		return this.cntrFmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return ftEndDt
	 */
	public String getFtEndDt() {
		return this.ftEndDt;
	}
	
	/**
	 * Column Info
	 * @return itmNm
	 */
	public String getItmNm() {
		return this.itmNm;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return cntrFmDt
	 */
	public String getCntrFmDt() {
		return this.cntrFmDt;
	}
	
	/**
	 * Column Info
	 * @return stoWthnFtAmt
	 */
	public String getStoWthnFtAmt() {
		return this.stoWthnFtAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrFmNodCd
	 */
	public String getCntrFmNodCd() {
		return this.cntrFmNodCd;
	}
	
	/**
	 * Column Info
	 * @return itmDesc
	 */
	public String getItmDesc() {
		return this.itmDesc;
	}
	
	/**
	 * Column Info
	 * @return invChgAmt
	 */
	public String getInvChgAmt() {
		return this.invChgAmt;
	}
	
	/**
	 * Column Info
	 * @return fCntrSts
	 */
	public String getFCntrSts() {
		return this.fCntrSts;
	}
	
	/**
	 * Column Info
	 * @return fItem
	 */
	public String getFItem() {
		return this.fItem;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return fTariff
	 */
	public String getFTariff() {
		return this.fTariff;
	}
	
	/**
	 * Column Info
	 * @return ftDys
	 */
	public String getFtDys() {
		return this.ftDys;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrToNodCd
	 */
	public String getCntrToNodCd() {
		return this.cntrToNodCd;
	}
	
	/**
	 * Column Info
	 * @return fCntrno
	 */
	public String getFCntrno() {
		return this.fCntrno;
	}
	
	/**
	 * Column Info
	 * @return fBkgno
	 */
	public String getFBkgno() {
		return this.fBkgno;
	}
	
	/**
	 * Column Info
	 * @return orgChgAmt
	 */
	public String getOrgChgAmt() {
		return this.orgChgAmt;
	}
	
	/**
	 * Column Info
	 * @return fRfaNo
	 */
	public String getFRfaNo() {
		return this.fRfaNo;
	}
	
	/**
	 * Column Info
	 * @return stoAftFtAmt
	 */
	public String getStoAftFtAmt() {
		return this.stoAftFtAmt;
	}
	
	/**
	 * Column Info
	 * @return chssTermCd
	 */
	public String getChssTermCd() {
		return this.chssTermCd;
	}
	
	/**
	 * Column Info
	 * @return divNm
	 */
	public String getDivNm() {
		return this.divNm;
	}
	

	/**
	 * Column Info
	 * @param pdRtAmt
	 */
	public void setPdRtAmt(String pdRtAmt) {
		this.pdRtAmt = pdRtAmt;
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
	 * @param fNode
	 */
	public void setFNode(String fNode) {
		this.fNode = fNode;
	}
	
	/**
	 * Column Info
	 * @param fItems
	 */
	public void setFItems(String fItems) {
		this.fItems = fItems;
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
	 * @param trfCd
	 */
	public void setTrfCd(String trfCd) {
		this.trfCd = trfCd;
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
	 * @param bkgBndCd
	 */
	public void setBkgBndCd(String bkgBndCd) {
		this.bkgBndCd = bkgBndCd;
	}
	
	/**
	 * Column Info
	 * @param fDelNo
	 */
	public void setFDelNo(String fDelNo) {
		this.fDelNo = fDelNo;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param costTtlAmt
	 */
	public void setCostTtlAmt(String costTtlAmt) {
		this.costTtlAmt = costTtlAmt;
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
	 * @param cntrToDt
	 */
	public void setCntrToDt(String cntrToDt) {
		this.cntrToDt = cntrToDt;
	}
	
	/**
	 * Column Info
	 * @param costWthnFtAmt
	 */
	public void setCostWthnFtAmt(String costWthnFtAmt) {
		this.costWthnFtAmt = costWthnFtAmt;
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
	 * @param scCustNm
	 */
	public void setScCustNm(String scCustNm) {
		this.scCustNm = scCustNm;
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
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
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
	 * @param fScNo
	 */
	public void setFScNo(String fScNo) {
		this.fScNo = fScNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param fToyearmonth
	 */
	public void setFToyearmonth(String fToyearmonth) {
		this.fToyearmonth = fToyearmonth;
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
	 * @param costAftFtAmt
	 */
	public void setCostAftFtAmt(String costAftFtAmt) {
		this.costAftFtAmt = costAftFtAmt;
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
	 * @param fBndCd
	 */
	public void setFBndCd(String fBndCd) {
		this.fBndCd = fBndCd;
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
	 * @param cntrSts
	 */
	public void setCntrSts(String cntrSts) {
		this.cntrSts = cntrSts;
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
	 * @param fCntrTpszCd
	 */
	public void setFCntrTpszCd(String fCntrTpszCd) {
		this.fCntrTpszCd = fCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param bilAmt
	 */
	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
	}
	
	/**
	 * Column Info
	 * @param fPorNo
	 */
	public void setFPorNo(String fPorNo) {
		this.fPorNo = fPorNo;
	}
	
	/**
	 * Column Info
	 * @param fFmyearmonth
	 */
	public void setFFmyearmonth(String fFmyearmonth) {
		this.fFmyearmonth = fFmyearmonth;
	}
	
	/**
	 * Column Info
	 * @param cntrToMvmtStsCd
	 */
	public void setCntrToMvmtStsCd(String cntrToMvmtStsCd) {
		this.cntrToMvmtStsCd = cntrToMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param stayDys
	 */
	public void setStayDys(String stayDys) {
		this.stayDys = stayDys;
	}
	
	/**
	 * Column Info
	 * @param rfaCustNm
	 */
	public void setRfaCustNm(String rfaCustNm) {
		this.rfaCustNm = rfaCustNm;
	}
	
	/**
	 * Column Info
	 * @param cntrFmMvmtStsCd
	 */
	public void setCntrFmMvmtStsCd(String cntrFmMvmtStsCd) {
		this.cntrFmMvmtStsCd = cntrFmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param ftEndDt
	 */
	public void setFtEndDt(String ftEndDt) {
		this.ftEndDt = ftEndDt;
	}
	
	/**
	 * Column Info
	 * @param itmNm
	 */
	public void setItmNm(String itmNm) {
		this.itmNm = itmNm;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param cntrFmDt
	 */
	public void setCntrFmDt(String cntrFmDt) {
		this.cntrFmDt = cntrFmDt;
	}
	
	/**
	 * Column Info
	 * @param stoWthnFtAmt
	 */
	public void setStoWthnFtAmt(String stoWthnFtAmt) {
		this.stoWthnFtAmt = stoWthnFtAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrFmNodCd
	 */
	public void setCntrFmNodCd(String cntrFmNodCd) {
		this.cntrFmNodCd = cntrFmNodCd;
	}
	
	/**
	 * Column Info
	 * @param itmDesc
	 */
	public void setItmDesc(String itmDesc) {
		this.itmDesc = itmDesc;
	}
	
	/**
	 * Column Info
	 * @param invChgAmt
	 */
	public void setInvChgAmt(String invChgAmt) {
		this.invChgAmt = invChgAmt;
	}
	
	/**
	 * Column Info
	 * @param fCntrSts
	 */
	public void setFCntrSts(String fCntrSts) {
		this.fCntrSts = fCntrSts;
	}
	
	/**
	 * Column Info
	 * @param fItem
	 */
	public void setFItem(String fItem) {
		this.fItem = fItem;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param fTariff
	 */
	public void setFTariff(String fTariff) {
		this.fTariff = fTariff;
	}
	
	/**
	 * Column Info
	 * @param ftDys
	 */
	public void setFtDys(String ftDys) {
		this.ftDys = ftDys;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrToNodCd
	 */
	public void setCntrToNodCd(String cntrToNodCd) {
		this.cntrToNodCd = cntrToNodCd;
	}
	
	/**
	 * Column Info
	 * @param fCntrno
	 */
	public void setFCntrno(String fCntrno) {
		this.fCntrno = fCntrno;
	}
	
	/**
	 * Column Info
	 * @param fBkgno
	 */
	public void setFBkgno(String fBkgno) {
		this.fBkgno = fBkgno;
	}
	
	/**
	 * Column Info
	 * @param orgChgAmt
	 */
	public void setOrgChgAmt(String orgChgAmt) {
		this.orgChgAmt = orgChgAmt;
	}
	
	/**
	 * Column Info
	 * @param fRfaNo
	 */
	public void setFRfaNo(String fRfaNo) {
		this.fRfaNo = fRfaNo;
	}
	
	/**
	 * Column Info
	 * @param stoAftFtAmt
	 */
	public void setStoAftFtAmt(String stoAftFtAmt) {
		this.stoAftFtAmt = stoAftFtAmt;
	}
	
	/**
	 * Column Info
	 * @param chssTermCd
	 */
	public void setChssTermCd(String chssTermCd) {
		this.chssTermCd = chssTermCd;
	}
	
	/**
	 * Column Info
	 * @param divNm
	 */
	public void setDivNm(String divNm) {
		this.divNm = divNm;
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
		setPdRtAmt(JSPUtil.getParameter(request, prefix + "pd_rt_amt", ""));
		setFFmMon(JSPUtil.getParameter(request, prefix + "f_fm_mon", ""));
		setFNode(JSPUtil.getParameter(request, prefix + "f_node", ""));
		setFItems(JSPUtil.getParameter(request, prefix + "f_items", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrfCd(JSPUtil.getParameter(request, prefix + "trf_cd", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setBkgBndCd(JSPUtil.getParameter(request, prefix + "bkg_bnd_cd", ""));
		setFDelNo(JSPUtil.getParameter(request, prefix + "f_del_no", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCostTtlAmt(JSPUtil.getParameter(request, prefix + "cost_ttl_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCntrToDt(JSPUtil.getParameter(request, prefix + "cntr_to_dt", ""));
		setCostWthnFtAmt(JSPUtil.getParameter(request, prefix + "cost_wthn_ft_amt", ""));
		setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
		setScCustNm(JSPUtil.getParameter(request, prefix + "sc_cust_nm", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", ""));
		setFToMon(JSPUtil.getParameter(request, prefix + "f_to_mon", ""));
		setFScNo(JSPUtil.getParameter(request, prefix + "f_sc_no", ""));
		setFToWk(JSPUtil.getParameter(request, prefix + "f_to_wk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setFToyearmonth(JSPUtil.getParameter(request, prefix + "f_toyearmonth", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setCostAftFtAmt(JSPUtil.getParameter(request, prefix + "cost_aft_ft_amt", ""));
		setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setFBndCd(JSPUtil.getParameter(request, prefix + "f_bnd_cd", ""));
		setFChkprd(JSPUtil.getParameter(request, prefix + "f_chkprd", ""));
		setCntrSts(JSPUtil.getParameter(request, prefix + "cntr_sts", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setFCntrTpszCd(JSPUtil.getParameter(request, prefix + "f_cntr_tpsz_cd", ""));
		setBilAmt(JSPUtil.getParameter(request, prefix + "bil_amt", ""));
		setFPorNo(JSPUtil.getParameter(request, prefix + "f_por_no", ""));
		setFFmyearmonth(JSPUtil.getParameter(request, prefix + "f_fmyearmonth", ""));
		setCntrToMvmtStsCd(JSPUtil.getParameter(request, prefix + "cntr_to_mvmt_sts_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setStayDys(JSPUtil.getParameter(request, prefix + "stay_dys", ""));
		setRfaCustNm(JSPUtil.getParameter(request, prefix + "rfa_cust_nm", ""));
		setCntrFmMvmtStsCd(JSPUtil.getParameter(request, prefix + "cntr_fm_mvmt_sts_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setFtEndDt(JSPUtil.getParameter(request, prefix + "ft_end_dt", ""));
		setItmNm(JSPUtil.getParameter(request, prefix + "itm_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCntrFmDt(JSPUtil.getParameter(request, prefix + "cntr_fm_dt", ""));
		setStoWthnFtAmt(JSPUtil.getParameter(request, prefix + "sto_wthn_ft_amt", ""));
		setCntrFmNodCd(JSPUtil.getParameter(request, prefix + "cntr_fm_nod_cd", ""));
		setItmDesc(JSPUtil.getParameter(request, prefix + "itm_desc", ""));
		setInvChgAmt(JSPUtil.getParameter(request, prefix + "inv_chg_amt", ""));
		setFCntrSts(JSPUtil.getParameter(request, prefix + "f_cntr_sts", ""));
		setFItem(JSPUtil.getParameter(request, prefix + "f_item", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setFTariff(JSPUtil.getParameter(request, prefix + "f_tariff", ""));
		setFtDys(JSPUtil.getParameter(request, prefix + "ft_dys", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrToNodCd(JSPUtil.getParameter(request, prefix + "cntr_to_nod_cd", ""));
		setFCntrno(JSPUtil.getParameter(request, prefix + "f_cntrno", ""));
		setFBkgno(JSPUtil.getParameter(request, prefix + "f_bkgno", ""));
		setOrgChgAmt(JSPUtil.getParameter(request, prefix + "org_chg_amt", ""));
		setFRfaNo(JSPUtil.getParameter(request, prefix + "f_rfa_no", ""));
		setStoAftFtAmt(JSPUtil.getParameter(request, prefix + "sto_aft_ft_amt", ""));
		setChssTermCd(JSPUtil.getParameter(request, prefix + "chss_term_cd", ""));
		setDivNm(JSPUtil.getParameter(request, prefix + "div_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DEMDETCostReportbyBKGDetailVO[]
	 */
	public DEMDETCostReportbyBKGDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DEMDETCostReportbyBKGDetailVO[]
	 */
	public DEMDETCostReportbyBKGDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DEMDETCostReportbyBKGDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pdRtAmt = (JSPUtil.getParameter(request, prefix	+ "pd_rt_amt", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] fNode = (JSPUtil.getParameter(request, prefix	+ "f_node", length));
			String[] fItems = (JSPUtil.getParameter(request, prefix	+ "f_items", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trfCd = (JSPUtil.getParameter(request, prefix	+ "trf_cd", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] bkgBndCd = (JSPUtil.getParameter(request, prefix	+ "bkg_bnd_cd", length));
			String[] fDelNo = (JSPUtil.getParameter(request, prefix	+ "f_del_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] costTtlAmt = (JSPUtil.getParameter(request, prefix	+ "cost_ttl_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntrToDt = (JSPUtil.getParameter(request, prefix	+ "cntr_to_dt", length));
			String[] costWthnFtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_wthn_ft_amt", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] scCustNm = (JSPUtil.getParameter(request, prefix	+ "sc_cust_nm", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] fScNo = (JSPUtil.getParameter(request, prefix	+ "f_sc_no", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] fToyearmonth = (JSPUtil.getParameter(request, prefix	+ "f_toyearmonth", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] costAftFtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_aft_ft_amt", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] fBndCd = (JSPUtil.getParameter(request, prefix	+ "f_bnd_cd", length));
			String[] fChkprd = (JSPUtil.getParameter(request, prefix	+ "f_chkprd", length));
			String[] cntrSts = (JSPUtil.getParameter(request, prefix	+ "cntr_sts", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tpsz_cd", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] fPorNo = (JSPUtil.getParameter(request, prefix	+ "f_por_no", length));
			String[] fFmyearmonth = (JSPUtil.getParameter(request, prefix	+ "f_fmyearmonth", length));
			String[] cntrToMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_to_mvmt_sts_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] stayDys = (JSPUtil.getParameter(request, prefix	+ "stay_dys", length));
			String[] rfaCustNm = (JSPUtil.getParameter(request, prefix	+ "rfa_cust_nm", length));
			String[] cntrFmMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_fm_mvmt_sts_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] itmNm = (JSPUtil.getParameter(request, prefix	+ "itm_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cntrFmDt = (JSPUtil.getParameter(request, prefix	+ "cntr_fm_dt", length));
			String[] stoWthnFtAmt = (JSPUtil.getParameter(request, prefix	+ "sto_wthn_ft_amt", length));
			String[] cntrFmNodCd = (JSPUtil.getParameter(request, prefix	+ "cntr_fm_nod_cd", length));
			String[] itmDesc = (JSPUtil.getParameter(request, prefix	+ "itm_desc", length));
			String[] invChgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_chg_amt", length));
			String[] fCntrSts = (JSPUtil.getParameter(request, prefix	+ "f_cntr_sts", length));
			String[] fItem = (JSPUtil.getParameter(request, prefix	+ "f_item", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] fTariff = (JSPUtil.getParameter(request, prefix	+ "f_tariff", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrToNodCd = (JSPUtil.getParameter(request, prefix	+ "cntr_to_nod_cd", length));
			String[] fCntrno = (JSPUtil.getParameter(request, prefix	+ "f_cntrno", length));
			String[] fBkgno = (JSPUtil.getParameter(request, prefix	+ "f_bkgno", length));
			String[] orgChgAmt = (JSPUtil.getParameter(request, prefix	+ "org_chg_amt", length));
			String[] fRfaNo = (JSPUtil.getParameter(request, prefix	+ "f_rfa_no", length));
			String[] stoAftFtAmt = (JSPUtil.getParameter(request, prefix	+ "sto_aft_ft_amt", length));
			String[] chssTermCd = (JSPUtil.getParameter(request, prefix	+ "chss_term_cd", length));
			String[] divNm = (JSPUtil.getParameter(request, prefix	+ "div_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new DEMDETCostReportbyBKGDetailVO();
				if (pdRtAmt[i] != null)
					model.setPdRtAmt(pdRtAmt[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (fNode[i] != null)
					model.setFNode(fNode[i]);
				if (fItems[i] != null)
					model.setFItems(fItems[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trfCd[i] != null)
					model.setTrfCd(trfCd[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (bkgBndCd[i] != null)
					model.setBkgBndCd(bkgBndCd[i]);
				if (fDelNo[i] != null)
					model.setFDelNo(fDelNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (costTtlAmt[i] != null)
					model.setCostTtlAmt(costTtlAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntrToDt[i] != null)
					model.setCntrToDt(cntrToDt[i]);
				if (costWthnFtAmt[i] != null)
					model.setCostWthnFtAmt(costWthnFtAmt[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (scCustNm[i] != null)
					model.setScCustNm(scCustNm[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (fToMon[i] != null)
					model.setFToMon(fToMon[i]);
				if (fScNo[i] != null)
					model.setFScNo(fScNo[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (fToyearmonth[i] != null)
					model.setFToyearmonth(fToyearmonth[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (costAftFtAmt[i] != null)
					model.setCostAftFtAmt(costAftFtAmt[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (fBndCd[i] != null)
					model.setFBndCd(fBndCd[i]);
				if (fChkprd[i] != null)
					model.setFChkprd(fChkprd[i]);
				if (cntrSts[i] != null)
					model.setCntrSts(cntrSts[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fCntrTpszCd[i] != null)
					model.setFCntrTpszCd(fCntrTpszCd[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (fPorNo[i] != null)
					model.setFPorNo(fPorNo[i]);
				if (fFmyearmonth[i] != null)
					model.setFFmyearmonth(fFmyearmonth[i]);
				if (cntrToMvmtStsCd[i] != null)
					model.setCntrToMvmtStsCd(cntrToMvmtStsCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (stayDys[i] != null)
					model.setStayDys(stayDys[i]);
				if (rfaCustNm[i] != null)
					model.setRfaCustNm(rfaCustNm[i]);
				if (cntrFmMvmtStsCd[i] != null)
					model.setCntrFmMvmtStsCd(cntrFmMvmtStsCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (ftEndDt[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				if (itmNm[i] != null)
					model.setItmNm(itmNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cntrFmDt[i] != null)
					model.setCntrFmDt(cntrFmDt[i]);
				if (stoWthnFtAmt[i] != null)
					model.setStoWthnFtAmt(stoWthnFtAmt[i]);
				if (cntrFmNodCd[i] != null)
					model.setCntrFmNodCd(cntrFmNodCd[i]);
				if (itmDesc[i] != null)
					model.setItmDesc(itmDesc[i]);
				if (invChgAmt[i] != null)
					model.setInvChgAmt(invChgAmt[i]);
				if (fCntrSts[i] != null)
					model.setFCntrSts(fCntrSts[i]);
				if (fItem[i] != null)
					model.setFItem(fItem[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (fTariff[i] != null)
					model.setFTariff(fTariff[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrToNodCd[i] != null)
					model.setCntrToNodCd(cntrToNodCd[i]);
				if (fCntrno[i] != null)
					model.setFCntrno(fCntrno[i]);
				if (fBkgno[i] != null)
					model.setFBkgno(fBkgno[i]);
				if (orgChgAmt[i] != null)
					model.setOrgChgAmt(orgChgAmt[i]);
				if (fRfaNo[i] != null)
					model.setFRfaNo(fRfaNo[i]);
				if (stoAftFtAmt[i] != null)
					model.setStoAftFtAmt(stoAftFtAmt[i]);
				if (chssTermCd[i] != null)
					model.setChssTermCd(chssTermCd[i]);
				if (divNm[i] != null)
					model.setDivNm(divNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDEMDETCostReportbyBKGDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DEMDETCostReportbyBKGDetailVO[]
	 */
	public DEMDETCostReportbyBKGDetailVO[] getDEMDETCostReportbyBKGDetailVOs(){
		DEMDETCostReportbyBKGDetailVO[] vos = (DEMDETCostReportbyBKGDetailVO[])models.toArray(new DEMDETCostReportbyBKGDetailVO[models.size()]);
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
		this.pdRtAmt = this.pdRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fNode = this.fNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fItems = this.fItems .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCd = this.trfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBndCd = this.bkgBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDelNo = this.fDelNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTtlAmt = this.costTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrToDt = this.cntrToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWthnFtAmt = this.costWthnFtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scCustNm = this.scCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fScNo = this.fScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToyearmonth = this.fToyearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAftFtAmt = this.costAftFtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBndCd = this.fBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkprd = this.fChkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSts = this.cntrSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpszCd = this.fCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPorNo = this.fPorNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmyearmonth = this.fFmyearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrToMvmtStsCd = this.cntrToMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDys = this.stayDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaCustNm = this.rfaCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFmMvmtStsCd = this.cntrFmMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNm = this.itmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFmDt = this.cntrFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoWthnFtAmt = this.stoWthnFtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFmNodCd = this.cntrFmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmDesc = this.itmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invChgAmt = this.invChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrSts = this.fCntrSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fItem = this.fItem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTariff = this.fTariff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrToNodCd = this.cntrToNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrno = this.fCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgno = this.fBkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgChgAmt = this.orgChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRfaNo = this.fRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoAftFtAmt = this.stoAftFtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTermCd = this.chssTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divNm = this.divNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
