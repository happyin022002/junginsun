/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BaseDataInterfaceVO.java
*@FileTitle : BaseDataInterfaceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.14  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class BaseDataInterfaceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BaseDataInterfaceVO> models = new ArrayList<BaseDataInterfaceVO>();
	
	/* Column Info */
	private String fcastTrnsStsCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String initCmAmt = null;
	/* Column Info */
	private String repTrdCd = null;
	/* Column Info */
	private String chngSlsOfcCd = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String chngCmUcAmt = null;
	/* Column Info */
	private String mtyTrspUcAmt = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String ldfRto = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String year = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String fullTrspUcAmt = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String ctrtFlg = null;
	/* Column Info */
	private String slsAqCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String stDt = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String agnCommUtAmt = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String cmpb = null;
	/* Column Info */
	private String orgLdfRto = null;
	/* Column Info */
	private String chngOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String polCd1 = null;
	/* Column Info */
	private String polCd2 = null;
	/* Column Info */
	private String polCd3 = null;
	/* Column Info */
	private String ioc = null;
	/* Column Info */
	private String polCd4 = null;
	/* Column Info */
	private String slsFlg = null;
	/* Column Info */
	private String polCd5 = null;
	/* Column Info */
	private String polCd6 = null;
	/* Column Info */
	private String polCd7 = null;
	/* Column Info */
	private String polCd8 = null;
	/* Column Info */
	private String polCd9 = null;
	/* Column Info */
	private String polCd10 = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String orgRlaneCd = null;
	/* Column Info */
	private String cmUcAmt = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String splAmt = null;
	/* Column Info */
	private String orgGrsRpbRev = null;
	/* Column Info */
	private String glineCmAmt = null;
	/* Column Info */
	private String yearMon = null;
	/* Column Info */
	private String bseYrwk = null;
	/* Column Info */
	private String ctrtRhqCd = null;
	/* Column Info */
	private String rowClr = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String mtyStvgUcAmt = null;
	/* Column Info */
	private String searchLane = null;
	/* Column Info */
	private String grsRpbRev = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String mqtaMdlVerNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String iocTsCd = null;
	/* Column Info */
	private String ctrtAqCd = null;
	/* Column Info */
	private String savFlg = null;
	/* Column Info */
	private String glineStsFlg = null;
	/* Column Info */
	private String tmlVolIncntAmt = null;
	/* Column Info */
	private String chngCtrtOfcCd = null;
	/* Column Info */
	private String ctrtRgnOfcCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String cmAmt = null;
	/* Column Info */
	private String orgCmUcAmt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String cdDpSeq = null;
	/* Column Info */
	private String bseMonth = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String fullStvgUcAmt = null;
	/* Column Info */
	private String repSubTrdCd = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String orgLodQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BaseDataInterfaceVO() {}

	public BaseDataInterfaceVO(String ibflag, String pagerows, String fcastTrnsStsCd, String trdCd, String rlaneCd, String initCmAmt, String chngSlsOfcCd, String chngCmUcAmt, String mtyTrspUcAmt, String bseQtrCd, String ldfRto, String ctrtOfcCd, String userId, String slsOfcCd, String year, String fullTrspUcAmt, String lodQty, String slsAqCd, String ctrtFlg, String rhqCd, String stDt, String agnCommUtAmt, String cmpb, String slsRhqCd, String orgLdfRto, String chngOfcCd, String ioc, String slsFlg, String subTrdCd, String orgRlaneCd, String cmUcAmt, String trade, String splAmt, String orgGrsRpbRev, String glineCmAmt, String yearMon, String ctrtRhqCd, String rowClr, String bseMon, String mtyStvgUcAmt, String searchLane, String grsRpbRev, String dirCd, String mqtaMdlVerNo, String iocCd, String ctrtAqCd, String savFlg, String glineStsFlg, String tmlVolIncntAmt, String chngCtrtOfcCd, String bseYr, String ctrtRgnOfcCd, String cmAmt, String orgCmUcAmt, String ofcCd, String bseMonth, String slsRgnOfcCd, String fullStvgUcAmt, String orgLodQty, String bound, String updDt, String iocTsCd, String creDt, String repTrdCd, String bseYrwk, String creUsrId, String cdDpSeq, String polCd, String polCd1, String polCd2, String polCd3, String polCd4, String polCd5, String polCd6, String polCd7, String polCd8, String polCd9, String polCd10, String repSubTrdCd, String updUsrId, String bseWk) {
		this.fcastTrnsStsCd = fcastTrnsStsCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.initCmAmt = initCmAmt;
		this.repTrdCd = repTrdCd;
		this.chngSlsOfcCd = chngSlsOfcCd;
		this.pagerows = pagerows;
		this.chngCmUcAmt = chngCmUcAmt;
		this.mtyTrspUcAmt = mtyTrspUcAmt;
		this.bseQtrCd = bseQtrCd;
		this.ldfRto = ldfRto;
		this.polCd = polCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.slsOfcCd = slsOfcCd;
		this.userId = userId;
		this.year = year;
		this.updUsrId = updUsrId;
		this.fullTrspUcAmt = fullTrspUcAmt;
		this.lodQty = lodQty;
		this.ctrtFlg = ctrtFlg;
		this.slsAqCd = slsAqCd;
		this.rhqCd = rhqCd;
		this.stDt = stDt;
		this.bseWk = bseWk;
		this.agnCommUtAmt = agnCommUtAmt;
		this.slsRhqCd = slsRhqCd;
		this.cmpb = cmpb;
		this.orgLdfRto = orgLdfRto;
		this.chngOfcCd = chngOfcCd;
		this.creUsrId = creUsrId;
		this.polCd1 = polCd1;
		this.polCd2 = polCd2;
		this.polCd3 = polCd3;
		this.ioc = ioc;
		this.polCd4 = polCd4;
		this.slsFlg = slsFlg;
		this.polCd5 = polCd5;
		this.polCd6 = polCd6;
		this.polCd7 = polCd7;
		this.polCd8 = polCd8;
		this.polCd9 = polCd9;
		this.polCd10 = polCd10;
		this.subTrdCd = subTrdCd;
		this.orgRlaneCd = orgRlaneCd;
		this.cmUcAmt = cmUcAmt;
		this.trade = trade;
		this.creDt = creDt;
		this.splAmt = splAmt;
		this.orgGrsRpbRev = orgGrsRpbRev;
		this.glineCmAmt = glineCmAmt;
		this.yearMon = yearMon;
		this.bseYrwk = bseYrwk;
		this.ctrtRhqCd = ctrtRhqCd;
		this.rowClr = rowClr;
		this.bseMon = bseMon;
		this.ibflag = ibflag;
		this.mtyStvgUcAmt = mtyStvgUcAmt;
		this.searchLane = searchLane;
		this.grsRpbRev = grsRpbRev;
		this.dirCd = dirCd;
		this.mqtaMdlVerNo = mqtaMdlVerNo;
		this.updDt = updDt;
		this.iocCd = iocCd;
		this.iocTsCd = iocTsCd;
		this.ctrtAqCd = ctrtAqCd;
		this.savFlg = savFlg;
		this.glineStsFlg = glineStsFlg;
		this.tmlVolIncntAmt = tmlVolIncntAmt;
		this.chngCtrtOfcCd = chngCtrtOfcCd;
		this.ctrtRgnOfcCd = ctrtRgnOfcCd;
		this.bseYr = bseYr;
		this.cmAmt = cmAmt;
		this.orgCmUcAmt = orgCmUcAmt;
		this.ofcCd = ofcCd;
		this.cdDpSeq = cdDpSeq;
		this.bseMonth = bseMonth;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.fullStvgUcAmt = fullStvgUcAmt;
		this.repSubTrdCd = repSubTrdCd;
		this.bound = bound;
		this.orgLodQty = orgLodQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fcast_trns_sts_cd", getFcastTrnsStsCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("init_cm_amt", getInitCmAmt());
		this.hashColumns.put("rep_trd_cd", getRepTrdCd());
		this.hashColumns.put("chng_sls_ofc_cd", getChngSlsOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chng_cm_uc_amt", getChngCmUcAmt());
		this.hashColumns.put("mty_trsp_uc_amt", getMtyTrspUcAmt());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("ldf_rto", getLdfRto());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("year", getYear());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("full_trsp_uc_amt", getFullTrspUcAmt());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("ctrt_flg", getCtrtFlg());
		this.hashColumns.put("sls_aq_cd", getSlsAqCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("st_dt", getStDt());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("agn_comm_ut_amt", getAgnCommUtAmt());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("cmpb", getCmpb());
		this.hashColumns.put("org_ldf_rto", getOrgLdfRto());
		this.hashColumns.put("chng_ofc_cd", getChngOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pol_cd1", getPolCd1());
		this.hashColumns.put("pol_cd2", getPolCd2());
		this.hashColumns.put("pol_cd3", getPolCd3());
		this.hashColumns.put("ioc", getIoc());
		this.hashColumns.put("pol_cd4", getPolCd4());
		this.hashColumns.put("sls_flg", getSlsFlg());
		this.hashColumns.put("pol_cd5", getPolCd5());
		this.hashColumns.put("pol_cd6", getPolCd6());
		this.hashColumns.put("pol_cd7", getPolCd7());
		this.hashColumns.put("pol_cd8", getPolCd8());
		this.hashColumns.put("pol_cd9", getPolCd9());
		this.hashColumns.put("pol_cd10", getPolCd10());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("org_rlane_cd", getOrgRlaneCd());
		this.hashColumns.put("cm_uc_amt", getCmUcAmt());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("spl_amt", getSplAmt());
		this.hashColumns.put("org_grs_rpb_rev", getOrgGrsRpbRev());
		this.hashColumns.put("gline_cm_amt", getGlineCmAmt());
		this.hashColumns.put("year_mon", getYearMon());
		this.hashColumns.put("bse_yrwk", getBseYrwk());
		this.hashColumns.put("ctrt_rhq_cd", getCtrtRhqCd());
		this.hashColumns.put("row_clr", getRowClr());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mty_stvg_uc_amt", getMtyStvgUcAmt());
		this.hashColumns.put("search_lane", getSearchLane());
		this.hashColumns.put("grs_rpb_rev", getGrsRpbRev());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("mqta_mdl_ver_no", getMqtaMdlVerNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("ioc_ts_cd", getIocTsCd());
		this.hashColumns.put("ctrt_aq_cd", getCtrtAqCd());
		this.hashColumns.put("sav_flg", getSavFlg());
		this.hashColumns.put("gline_sts_flg", getGlineStsFlg());
		this.hashColumns.put("tml_vol_incnt_amt", getTmlVolIncntAmt());
		this.hashColumns.put("chng_ctrt_ofc_cd", getChngCtrtOfcCd());
		this.hashColumns.put("ctrt_rgn_ofc_cd", getCtrtRgnOfcCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("cm_amt", getCmAmt());
		this.hashColumns.put("org_cm_uc_amt", getOrgCmUcAmt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cd_dp_seq", getCdDpSeq());
		this.hashColumns.put("bse_month", getBseMonth());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("full_stvg_uc_amt", getFullStvgUcAmt());
		this.hashColumns.put("rep_sub_trd_cd", getRepSubTrdCd());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("org_lod_qty", getOrgLodQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fcast_trns_sts_cd", "fcastTrnsStsCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("init_cm_amt", "initCmAmt");
		this.hashFields.put("rep_trd_cd", "repTrdCd");
		this.hashFields.put("chng_sls_ofc_cd", "chngSlsOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chng_cm_uc_amt", "chngCmUcAmt");
		this.hashFields.put("mty_trsp_uc_amt", "mtyTrspUcAmt");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("ldf_rto", "ldfRto");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("year", "year");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("full_trsp_uc_amt", "fullTrspUcAmt");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("ctrt_flg", "ctrtFlg");
		this.hashFields.put("sls_aq_cd", "slsAqCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("st_dt", "stDt");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("agn_comm_ut_amt", "agnCommUtAmt");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("cmpb", "cmpb");
		this.hashFields.put("org_ldf_rto", "orgLdfRto");
		this.hashFields.put("chng_ofc_cd", "chngOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pol_cd1", "polCd1");
		this.hashFields.put("pol_cd2", "polCd2");
		this.hashFields.put("pol_cd3", "polCd3");
		this.hashFields.put("ioc", "ioc");
		this.hashFields.put("pol_cd4", "polCd4");
		this.hashFields.put("sls_flg", "slsFlg");
		this.hashFields.put("pol_cd5", "polCd5");
		this.hashFields.put("pol_cd6", "polCd6");
		this.hashFields.put("pol_cd7", "polCd7");
		this.hashFields.put("pol_cd8", "polCd8");
		this.hashFields.put("pol_cd9", "polCd9");
		this.hashFields.put("pol_cd10", "polCd10");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("org_rlane_cd", "orgRlaneCd");
		this.hashFields.put("cm_uc_amt", "cmUcAmt");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("spl_amt", "splAmt");
		this.hashFields.put("org_grs_rpb_rev", "orgGrsRpbRev");
		this.hashFields.put("gline_cm_amt", "glineCmAmt");
		this.hashFields.put("year_mon", "yearMon");
		this.hashFields.put("bse_yrwk", "bseYrwk");
		this.hashFields.put("ctrt_rhq_cd", "ctrtRhqCd");
		this.hashFields.put("row_clr", "rowClr");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mty_stvg_uc_amt", "mtyStvgUcAmt");
		this.hashFields.put("search_lane", "searchLane");
		this.hashFields.put("grs_rpb_rev", "grsRpbRev");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("mqta_mdl_ver_no", "mqtaMdlVerNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("ioc_ts_cd", "iocTsCd");
		this.hashFields.put("ctrt_aq_cd", "ctrtAqCd");
		this.hashFields.put("sav_flg", "savFlg");
		this.hashFields.put("gline_sts_flg", "glineStsFlg");
		this.hashFields.put("tml_vol_incnt_amt", "tmlVolIncntAmt");
		this.hashFields.put("chng_ctrt_ofc_cd", "chngCtrtOfcCd");
		this.hashFields.put("ctrt_rgn_ofc_cd", "ctrtRgnOfcCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("cm_amt", "cmAmt");
		this.hashFields.put("org_cm_uc_amt", "orgCmUcAmt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cd_dp_seq", "cdDpSeq");
		this.hashFields.put("bse_month", "bseMonth");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("full_stvg_uc_amt", "fullStvgUcAmt");
		this.hashFields.put("rep_sub_trd_cd", "repSubTrdCd");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("org_lod_qty", "orgLodQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fcastTrnsStsCd
	 */
	public String getFcastTrnsStsCd() {
		return this.fcastTrnsStsCd;
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
	 * @return initCmAmt
	 */
	public String getInitCmAmt() {
		return this.initCmAmt;
	}
	
	/**
	 * Column Info
	 * @return repTrdCd
	 */
	public String getRepTrdCd() {
		return this.repTrdCd;
	}
	
	/**
	 * Column Info
	 * @return chngSlsOfcCd
	 */
	public String getChngSlsOfcCd() {
		return this.chngSlsOfcCd;
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
	 * @return chngCmUcAmt
	 */
	public String getChngCmUcAmt() {
		return this.chngCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyTrspUcAmt
	 */
	public String getMtyTrspUcAmt() {
		return this.mtyTrspUcAmt;
	}
	
	/**
	 * Column Info
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return ldfRto
	 */
	public String getLdfRto() {
		return this.ldfRto;
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
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
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
	 * @return year
	 */
	public String getYear() {
		return this.year;
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
	 * @return fullTrspUcAmt
	 */
	public String getFullTrspUcAmt() {
		return this.fullTrspUcAmt;
	}
	
	/**
	 * Column Info
	 * @return lodQty
	 */
	public String getLodQty() {
		return this.lodQty;
	}
	
	/**
	 * Column Info
	 * @return ctrtFlg
	 */
	public String getCtrtFlg() {
		return this.ctrtFlg;
	}
	
	/**
	 * Column Info
	 * @return slsAqCd
	 */
	public String getSlsAqCd() {
		return this.slsAqCd;
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
	 * @return stDt
	 */
	public String getStDt() {
		return this.stDt;
	}
	
	/**
	 * Column Info
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
	}
	
	/**
	 * Column Info
	 * @return agnCommUtAmt
	 */
	public String getAgnCommUtAmt() {
		return this.agnCommUtAmt;
	}
	
	/**
	 * Column Info
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @return cmpb
	 */
	public String getCmpb() {
		return this.cmpb;
	}
	
	/**
	 * Column Info
	 * @return orgLdfRto
	 */
	public String getOrgLdfRto() {
		return this.orgLdfRto;
	}
	
	/**
	 * Column Info
	 * @return chngOfcCd
	 */
	public String getChngOfcCd() {
		return this.chngOfcCd;
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
	 * @return polCd1
	 */
	public String getPolCd1() {
		return this.polCd1;
	}
	
	/**
	 * Column Info
	 * @return polCd2
	 */
	public String getPolCd2() {
		return this.polCd2;
	}
	
	/**
	 * Column Info
	 * @return polCd3
	 */
	public String getPolCd3() {
		return this.polCd3;
	}
	
	/**
	 * Column Info
	 * @return ioc
	 */
	public String getIoc() {
		return this.ioc;
	}
	
	/**
	 * Column Info
	 * @return polCd4
	 */
	public String getPolCd4() {
		return this.polCd4;
	}
	
	/**
	 * Column Info
	 * @return slsFlg
	 */
	public String getSlsFlg() {
		return this.slsFlg;
	}
	
	/**
	 * Column Info
	 * @return polCd5
	 */
	public String getPolCd5() {
		return this.polCd5;
	}
	
	/**
	 * Column Info
	 * @return polCd6
	 */
	public String getPolCd6() {
		return this.polCd6;
	}
	
	/**
	 * Column Info
	 * @return polCd7
	 */
	public String getPolCd7() {
		return this.polCd7;
	}
	
	/**
	 * Column Info
	 * @return polCd8
	 */
	public String getPolCd8() {
		return this.polCd8;
	}
	
	/**
	 * Column Info
	 * @return polCd9
	 */
	public String getPolCd9() {
		return this.polCd9;
	}
	
	/**
	 * Column Info
	 * @return polCd10
	 */
	public String getPolCd10() {
		return this.polCd10;
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
	 * @return orgRlaneCd
	 */
	public String getOrgRlaneCd() {
		return this.orgRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return cmUcAmt
	 */
	public String getCmUcAmt() {
		return this.cmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
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
	 * @return splAmt
	 */
	public String getSplAmt() {
		return this.splAmt;
	}
	
	/**
	 * Column Info
	 * @return orgGrsRpbRev
	 */
	public String getOrgGrsRpbRev() {
		return this.orgGrsRpbRev;
	}
	
	/**
	 * Column Info
	 * @return glineCmAmt
	 */
	public String getGlineCmAmt() {
		return this.glineCmAmt;
	}
	
	/**
	 * Column Info
	 * @return yearMon
	 */
	public String getYearMon() {
		return this.yearMon;
	}
	
	/**
	 * Column Info
	 * @return bseYrwk
	 */
	public String getBseYrwk() {
		return this.bseYrwk;
	}
	
	/**
	 * Column Info
	 * @return ctrtRhqCd
	 */
	public String getCtrtRhqCd() {
		return this.ctrtRhqCd;
	}
	
	/**
	 * Column Info
	 * @return rowClr
	 */
	public String getRowClr() {
		return this.rowClr;
	}
	
	/**
	 * Column Info
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
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
	 * @return mtyStvgUcAmt
	 */
	public String getMtyStvgUcAmt() {
		return this.mtyStvgUcAmt;
	}
	
	/**
	 * Column Info
	 * @return searchLane
	 */
	public String getSearchLane() {
		return this.searchLane;
	}
	
	/**
	 * Column Info
	 * @return grsRpbRev
	 */
	public String getGrsRpbRev() {
		return this.grsRpbRev;
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
	 * @return mqtaMdlVerNo
	 */
	public String getMqtaMdlVerNo() {
		return this.mqtaMdlVerNo;
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
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return iocTsCd
	 */
	public String getIocTsCd() {
		return this.iocTsCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtAqCd
	 */
	public String getCtrtAqCd() {
		return this.ctrtAqCd;
	}
	
	/**
	 * Column Info
	 * @return savFlg
	 */
	public String getSavFlg() {
		return this.savFlg;
	}
	
	/**
	 * Column Info
	 * @return glineStsFlg
	 */
	public String getGlineStsFlg() {
		return this.glineStsFlg;
	}
	
	/**
	 * Column Info
	 * @return tmlVolIncntAmt
	 */
	public String getTmlVolIncntAmt() {
		return this.tmlVolIncntAmt;
	}
	
	/**
	 * Column Info
	 * @return chngCtrtOfcCd
	 */
	public String getChngCtrtOfcCd() {
		return this.chngCtrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtRgnOfcCd
	 */
	public String getCtrtRgnOfcCd() {
		return this.ctrtRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return cmAmt
	 */
	public String getCmAmt() {
		return this.cmAmt;
	}
	
	/**
	 * Column Info
	 * @return orgCmUcAmt
	 */
	public String getOrgCmUcAmt() {
		return this.orgCmUcAmt;
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
	 * @return cdDpSeq
	 */
	public String getCdDpSeq() {
		return this.cdDpSeq;
	}
	
	/**
	 * Column Info
	 * @return bseMonth
	 */
	public String getBseMonth() {
		return this.bseMonth;
	}
	
	/**
	 * Column Info
	 * @return slsRgnOfcCd
	 */
	public String getSlsRgnOfcCd() {
		return this.slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fullStvgUcAmt
	 */
	public String getFullStvgUcAmt() {
		return this.fullStvgUcAmt;
	}
	
	/**
	 * Column Info
	 * @return repSubTrdCd
	 */
	public String getRepSubTrdCd() {
		return this.repSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	
	/**
	 * Column Info
	 * @return orgLodQty
	 */
	public String getOrgLodQty() {
		return this.orgLodQty;
	}
	

	/**
	 * Column Info
	 * @param fcastTrnsStsCd
	 */
	public void setFcastTrnsStsCd(String fcastTrnsStsCd) {
		this.fcastTrnsStsCd = fcastTrnsStsCd;
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
	 * @param initCmAmt
	 */
	public void setInitCmAmt(String initCmAmt) {
		this.initCmAmt = initCmAmt;
	}
	
	/**
	 * Column Info
	 * @param repTrdCd
	 */
	public void setRepTrdCd(String repTrdCd) {
		this.repTrdCd = repTrdCd;
	}
	
	/**
	 * Column Info
	 * @param chngSlsOfcCd
	 */
	public void setChngSlsOfcCd(String chngSlsOfcCd) {
		this.chngSlsOfcCd = chngSlsOfcCd;
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
	 * @param chngCmUcAmt
	 */
	public void setChngCmUcAmt(String chngCmUcAmt) {
		this.chngCmUcAmt = chngCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyTrspUcAmt
	 */
	public void setMtyTrspUcAmt(String mtyTrspUcAmt) {
		this.mtyTrspUcAmt = mtyTrspUcAmt;
	}
	
	/**
	 * Column Info
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param ldfRto
	 */
	public void setLdfRto(String ldfRto) {
		this.ldfRto = ldfRto;
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
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
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
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
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
	 * @param fullTrspUcAmt
	 */
	public void setFullTrspUcAmt(String fullTrspUcAmt) {
		this.fullTrspUcAmt = fullTrspUcAmt;
	}
	
	/**
	 * Column Info
	 * @param lodQty
	 */
	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
	}
	
	/**
	 * Column Info
	 * @param ctrtFlg
	 */
	public void setCtrtFlg(String ctrtFlg) {
		this.ctrtFlg = ctrtFlg;
	}
	
	/**
	 * Column Info
	 * @param slsAqCd
	 */
	public void setSlsAqCd(String slsAqCd) {
		this.slsAqCd = slsAqCd;
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
	 * @param stDt
	 */
	public void setStDt(String stDt) {
		this.stDt = stDt;
	}
	
	/**
	 * Column Info
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
	}
	
	/**
	 * Column Info
	 * @param agnCommUtAmt
	 */
	public void setAgnCommUtAmt(String agnCommUtAmt) {
		this.agnCommUtAmt = agnCommUtAmt;
	}
	
	/**
	 * Column Info
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @param cmpb
	 */
	public void setCmpb(String cmpb) {
		this.cmpb = cmpb;
	}
	
	/**
	 * Column Info
	 * @param orgLdfRto
	 */
	public void setOrgLdfRto(String orgLdfRto) {
		this.orgLdfRto = orgLdfRto;
	}
	
	/**
	 * Column Info
	 * @param chngOfcCd
	 */
	public void setChngOfcCd(String chngOfcCd) {
		this.chngOfcCd = chngOfcCd;
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
	 * @param polCd1
	 */
	public void setPolCd1(String polCd1) {
		this.polCd1 = polCd1;
	}
	
	/**
	 * Column Info
	 * @param polCd2
	 */
	public void setPolCd2(String polCd2) {
		this.polCd2 = polCd2;
	}
	
	/**
	 * Column Info
	 * @param polCd3
	 */
	public void setPolCd3(String polCd3) {
		this.polCd3 = polCd3;
	}
	
	/**
	 * Column Info
	 * @param ioc
	 */
	public void setIoc(String ioc) {
		this.ioc = ioc;
	}
	
	/**
	 * Column Info
	 * @param polCd4
	 */
	public void setPolCd4(String polCd4) {
		this.polCd4 = polCd4;
	}
	
	/**
	 * Column Info
	 * @param slsFlg
	 */
	public void setSlsFlg(String slsFlg) {
		this.slsFlg = slsFlg;
	}
	
	/**
	 * Column Info
	 * @param polCd5
	 */
	public void setPolCd5(String polCd5) {
		this.polCd5 = polCd5;
	}
	
	/**
	 * Column Info
	 * @param polCd6
	 */
	public void setPolCd6(String polCd6) {
		this.polCd6 = polCd6;
	}
	
	/**
	 * Column Info
	 * @param polCd7
	 */
	public void setPolCd7(String polCd7) {
		this.polCd7 = polCd7;
	}
	
	/**
	 * Column Info
	 * @param polCd8
	 */
	public void setPolCd8(String polCd8) {
		this.polCd8 = polCd8;
	}
	
	/**
	 * Column Info
	 * @param polCd9
	 */
	public void setPolCd9(String polCd9) {
		this.polCd9 = polCd9;
	}
	
	/**
	 * Column Info
	 * @param polCd10
	 */
	public void setPolCd10(String polCd10) {
		this.polCd10 = polCd10;
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
	 * @param orgRlaneCd
	 */
	public void setOrgRlaneCd(String orgRlaneCd) {
		this.orgRlaneCd = orgRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param cmUcAmt
	 */
	public void setCmUcAmt(String cmUcAmt) {
		this.cmUcAmt = cmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
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
	 * @param splAmt
	 */
	public void setSplAmt(String splAmt) {
		this.splAmt = splAmt;
	}
	
	/**
	 * Column Info
	 * @param orgGrsRpbRev
	 */
	public void setOrgGrsRpbRev(String orgGrsRpbRev) {
		this.orgGrsRpbRev = orgGrsRpbRev;
	}
	
	/**
	 * Column Info
	 * @param glineCmAmt
	 */
	public void setGlineCmAmt(String glineCmAmt) {
		this.glineCmAmt = glineCmAmt;
	}
	
	/**
	 * Column Info
	 * @param yearMon
	 */
	public void setYearMon(String yearMon) {
		this.yearMon = yearMon;
	}
	
	/**
	 * Column Info
	 * @param bseYrwk
	 */
	public void setBseYrwk(String bseYrwk) {
		this.bseYrwk = bseYrwk;
	}
	
	/**
	 * Column Info
	 * @param ctrtRhqCd
	 */
	public void setCtrtRhqCd(String ctrtRhqCd) {
		this.ctrtRhqCd = ctrtRhqCd;
	}
	
	/**
	 * Column Info
	 * @param rowClr
	 */
	public void setRowClr(String rowClr) {
		this.rowClr = rowClr;
	}
	
	/**
	 * Column Info
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
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
	 * @param mtyStvgUcAmt
	 */
	public void setMtyStvgUcAmt(String mtyStvgUcAmt) {
		this.mtyStvgUcAmt = mtyStvgUcAmt;
	}
	
	/**
	 * Column Info
	 * @param searchLane
	 */
	public void setSearchLane(String searchLane) {
		this.searchLane = searchLane;
	}
	
	/**
	 * Column Info
	 * @param grsRpbRev
	 */
	public void setGrsRpbRev(String grsRpbRev) {
		this.grsRpbRev = grsRpbRev;
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
	 * @param mqtaMdlVerNo
	 */
	public void setMqtaMdlVerNo(String mqtaMdlVerNo) {
		this.mqtaMdlVerNo = mqtaMdlVerNo;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param iocTsCd
	 */
	public void setIocTsCd(String iocTsCd) {
		this.iocTsCd = iocTsCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtAqCd
	 */
	public void setCtrtAqCd(String ctrtAqCd) {
		this.ctrtAqCd = ctrtAqCd;
	}
	
	/**
	 * Column Info
	 * @param savFlg
	 */
	public void setSavFlg(String savFlg) {
		this.savFlg = savFlg;
	}
	
	/**
	 * Column Info
	 * @param glineStsFlg
	 */
	public void setGlineStsFlg(String glineStsFlg) {
		this.glineStsFlg = glineStsFlg;
	}
	
	/**
	 * Column Info
	 * @param tmlVolIncntAmt
	 */
	public void setTmlVolIncntAmt(String tmlVolIncntAmt) {
		this.tmlVolIncntAmt = tmlVolIncntAmt;
	}
	
	/**
	 * Column Info
	 * @param chngCtrtOfcCd
	 */
	public void setChngCtrtOfcCd(String chngCtrtOfcCd) {
		this.chngCtrtOfcCd = chngCtrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtRgnOfcCd
	 */
	public void setCtrtRgnOfcCd(String ctrtRgnOfcCd) {
		this.ctrtRgnOfcCd = ctrtRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param cmAmt
	 */
	public void setCmAmt(String cmAmt) {
		this.cmAmt = cmAmt;
	}
	
	/**
	 * Column Info
	 * @param orgCmUcAmt
	 */
	public void setOrgCmUcAmt(String orgCmUcAmt) {
		this.orgCmUcAmt = orgCmUcAmt;
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
	 * @param cdDpSeq
	 */
	public void setCdDpSeq(String cdDpSeq) {
		this.cdDpSeq = cdDpSeq;
	}
	
	/**
	 * Column Info
	 * @param bseMonth
	 */
	public void setBseMonth(String bseMonth) {
		this.bseMonth = bseMonth;
	}
	
	/**
	 * Column Info
	 * @param slsRgnOfcCd
	 */
	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fullStvgUcAmt
	 */
	public void setFullStvgUcAmt(String fullStvgUcAmt) {
		this.fullStvgUcAmt = fullStvgUcAmt;
	}
	
	/**
	 * Column Info
	 * @param repSubTrdCd
	 */
	public void setRepSubTrdCd(String repSubTrdCd) {
		this.repSubTrdCd = repSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * Column Info
	 * @param orgLodQty
	 */
	public void setOrgLodQty(String orgLodQty) {
		this.orgLodQty = orgLodQty;
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
		setFcastTrnsStsCd(JSPUtil.getParameter(request, prefix + "fcast_trns_sts_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setInitCmAmt(JSPUtil.getParameter(request, prefix + "init_cm_amt", ""));
		setRepTrdCd(JSPUtil.getParameter(request, prefix + "rep_trd_cd", ""));
		setChngSlsOfcCd(JSPUtil.getParameter(request, prefix + "chng_sls_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setChngCmUcAmt(JSPUtil.getParameter(request, prefix + "chng_cm_uc_amt", ""));
		setMtyTrspUcAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_uc_amt", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setLdfRto(JSPUtil.getParameter(request, prefix + "ldf_rto", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setYear(JSPUtil.getParameter(request, prefix + "year", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFullTrspUcAmt(JSPUtil.getParameter(request, prefix + "full_trsp_uc_amt", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setCtrtFlg(JSPUtil.getParameter(request, prefix + "ctrt_flg", ""));
		setSlsAqCd(JSPUtil.getParameter(request, prefix + "sls_aq_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setStDt(JSPUtil.getParameter(request, prefix + "st_dt", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setAgnCommUtAmt(JSPUtil.getParameter(request, prefix + "agn_comm_ut_amt", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setCmpb(JSPUtil.getParameter(request, prefix + "cmpb", ""));
		setOrgLdfRto(JSPUtil.getParameter(request, prefix + "org_ldf_rto", ""));
		setChngOfcCd(JSPUtil.getParameter(request, prefix + "chng_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPolCd1(JSPUtil.getParameter(request, prefix + "pol_cd1", ""));
		setPolCd2(JSPUtil.getParameter(request, prefix + "pol_cd2", ""));
		setPolCd3(JSPUtil.getParameter(request, prefix + "pol_cd3", ""));
		setIoc(JSPUtil.getParameter(request, prefix + "ioc", ""));
		setPolCd4(JSPUtil.getParameter(request, prefix + "pol_cd4", ""));
		setSlsFlg(JSPUtil.getParameter(request, prefix + "sls_flg", ""));
		setPolCd5(JSPUtil.getParameter(request, prefix + "pol_cd5", ""));
		setPolCd6(JSPUtil.getParameter(request, prefix + "pol_cd6", ""));
		setPolCd7(JSPUtil.getParameter(request, prefix + "pol_cd7", ""));
		setPolCd8(JSPUtil.getParameter(request, prefix + "pol_cd8", ""));
		setPolCd9(JSPUtil.getParameter(request, prefix + "pol_cd9", ""));
		setPolCd10(JSPUtil.getParameter(request, prefix + "pol_cd10", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setOrgRlaneCd(JSPUtil.getParameter(request, prefix + "org_rlane_cd", ""));
		setCmUcAmt(JSPUtil.getParameter(request, prefix + "cm_uc_amt", ""));
		setTrade(JSPUtil.getParameter(request, prefix + "trade", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSplAmt(JSPUtil.getParameter(request, prefix + "spl_amt", ""));
		setOrgGrsRpbRev(JSPUtil.getParameter(request, prefix + "org_grs_rpb_rev", ""));
		setGlineCmAmt(JSPUtil.getParameter(request, prefix + "gline_cm_amt", ""));
		setYearMon(JSPUtil.getParameter(request, prefix + "year_mon", ""));
		setBseYrwk(JSPUtil.getParameter(request, prefix + "bse_yrwk", ""));
		setCtrtRhqCd(JSPUtil.getParameter(request, prefix + "ctrt_rhq_cd", ""));
		setRowClr(JSPUtil.getParameter(request, prefix + "row_clr", ""));
		setBseMon(JSPUtil.getParameter(request, prefix + "bse_mon", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMtyStvgUcAmt(JSPUtil.getParameter(request, prefix + "mty_stvg_uc_amt", ""));
		setSearchLane(JSPUtil.getParameter(request, prefix + "search_lane", ""));
		setGrsRpbRev(JSPUtil.getParameter(request, prefix + "grs_rpb_rev", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setMqtaMdlVerNo(JSPUtil.getParameter(request, prefix + "mqta_mdl_ver_no", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setIocTsCd(JSPUtil.getParameter(request, prefix + "ioc_ts_cd", ""));
		setCtrtAqCd(JSPUtil.getParameter(request, prefix + "ctrt_aq_cd", ""));
		setSavFlg(JSPUtil.getParameter(request, prefix + "sav_flg", ""));
		setGlineStsFlg(JSPUtil.getParameter(request, prefix + "gline_sts_flg", ""));
		setTmlVolIncntAmt(JSPUtil.getParameter(request, prefix + "tml_vol_incnt_amt", ""));
		setChngCtrtOfcCd(JSPUtil.getParameter(request, prefix + "chng_ctrt_ofc_cd", ""));
		setCtrtRgnOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_rgn_ofc_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setCmAmt(JSPUtil.getParameter(request, prefix + "cm_amt", ""));
		setOrgCmUcAmt(JSPUtil.getParameter(request, prefix + "org_cm_uc_amt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCdDpSeq(JSPUtil.getParameter(request, prefix + "cd_dp_seq", ""));
		setBseMonth(JSPUtil.getParameter(request, prefix + "bse_month", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd", ""));
		setFullStvgUcAmt(JSPUtil.getParameter(request, prefix + "full_stvg_uc_amt", ""));
		setRepSubTrdCd(JSPUtil.getParameter(request, prefix + "rep_sub_trd_cd", ""));
		setBound(JSPUtil.getParameter(request, prefix + "bound", ""));
		setOrgLodQty(JSPUtil.getParameter(request, prefix + "org_lod_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BaseDataInterfaceVO[]
	 */
	public BaseDataInterfaceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BaseDataInterfaceVO[]
	 */
	public BaseDataInterfaceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BaseDataInterfaceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fcastTrnsStsCd = (JSPUtil.getParameter(request, prefix	+ "fcast_trns_sts_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] initCmAmt = (JSPUtil.getParameter(request, prefix	+ "init_cm_amt", length));
			String[] repTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_trd_cd", length));
			String[] chngSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "chng_sls_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chngCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "chng_cm_uc_amt", length));
			String[] mtyTrspUcAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_uc_amt", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] ldfRto = (JSPUtil.getParameter(request, prefix	+ "ldf_rto", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] year = (JSPUtil.getParameter(request, prefix	+ "year", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fullTrspUcAmt = (JSPUtil.getParameter(request, prefix	+ "full_trsp_uc_amt", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] ctrtFlg = (JSPUtil.getParameter(request, prefix	+ "ctrt_flg", length));
			String[] slsAqCd = (JSPUtil.getParameter(request, prefix	+ "sls_aq_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] stDt = (JSPUtil.getParameter(request, prefix	+ "st_dt", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] agnCommUtAmt = (JSPUtil.getParameter(request, prefix	+ "agn_comm_ut_amt", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] cmpb = (JSPUtil.getParameter(request, prefix	+ "cmpb", length));
			String[] orgLdfRto = (JSPUtil.getParameter(request, prefix	+ "org_ldf_rto", length));
			String[] chngOfcCd = (JSPUtil.getParameter(request, prefix	+ "chng_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] polCd1 = (JSPUtil.getParameter(request, prefix	+ "pol_cd1", length));
			String[] polCd2 = (JSPUtil.getParameter(request, prefix	+ "pol_cd2", length));
			String[] polCd3 = (JSPUtil.getParameter(request, prefix	+ "pol_cd3", length));
			String[] ioc = (JSPUtil.getParameter(request, prefix	+ "ioc", length));
			String[] polCd4 = (JSPUtil.getParameter(request, prefix	+ "pol_cd4", length));
			String[] slsFlg = (JSPUtil.getParameter(request, prefix	+ "sls_flg", length));
			String[] polCd5 = (JSPUtil.getParameter(request, prefix	+ "pol_cd5", length));
			String[] polCd6 = (JSPUtil.getParameter(request, prefix	+ "pol_cd6", length));
			String[] polCd7 = (JSPUtil.getParameter(request, prefix	+ "pol_cd7", length));
			String[] polCd8 = (JSPUtil.getParameter(request, prefix	+ "pol_cd8", length));
			String[] polCd9 = (JSPUtil.getParameter(request, prefix	+ "pol_cd9", length));
			String[] polCd10 = (JSPUtil.getParameter(request, prefix	+ "pol_cd10", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] orgRlaneCd = (JSPUtil.getParameter(request, prefix	+ "org_rlane_cd", length));
			String[] cmUcAmt = (JSPUtil.getParameter(request, prefix	+ "cm_uc_amt", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] splAmt = (JSPUtil.getParameter(request, prefix	+ "spl_amt", length));
			String[] orgGrsRpbRev = (JSPUtil.getParameter(request, prefix	+ "org_grs_rpb_rev", length));
			String[] glineCmAmt = (JSPUtil.getParameter(request, prefix	+ "gline_cm_amt", length));
			String[] yearMon = (JSPUtil.getParameter(request, prefix	+ "year_mon", length));
			String[] bseYrwk = (JSPUtil.getParameter(request, prefix	+ "bse_yrwk", length));
			String[] ctrtRhqCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_rhq_cd", length));
			String[] rowClr = (JSPUtil.getParameter(request, prefix	+ "row_clr", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mtyStvgUcAmt = (JSPUtil.getParameter(request, prefix	+ "mty_stvg_uc_amt", length));
			String[] searchLane = (JSPUtil.getParameter(request, prefix	+ "search_lane", length));
			String[] grsRpbRev = (JSPUtil.getParameter(request, prefix	+ "grs_rpb_rev", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] mqtaMdlVerNo = (JSPUtil.getParameter(request, prefix	+ "mqta_mdl_ver_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] iocTsCd = (JSPUtil.getParameter(request, prefix	+ "ioc_ts_cd", length));
			String[] ctrtAqCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_aq_cd", length));
			String[] savFlg = (JSPUtil.getParameter(request, prefix	+ "sav_flg", length));
			String[] glineStsFlg = (JSPUtil.getParameter(request, prefix	+ "gline_sts_flg", length));
			String[] tmlVolIncntAmt = (JSPUtil.getParameter(request, prefix	+ "tml_vol_incnt_amt", length));
			String[] chngCtrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "chng_ctrt_ofc_cd", length));
			String[] ctrtRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_rgn_ofc_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] cmAmt = (JSPUtil.getParameter(request, prefix	+ "cm_amt", length));
			String[] orgCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "org_cm_uc_amt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] cdDpSeq = (JSPUtil.getParameter(request, prefix	+ "cd_dp_seq", length));
			String[] bseMonth = (JSPUtil.getParameter(request, prefix	+ "bse_month", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] fullStvgUcAmt = (JSPUtil.getParameter(request, prefix	+ "full_stvg_uc_amt", length));
			String[] repSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_sub_trd_cd", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] orgLodQty = (JSPUtil.getParameter(request, prefix	+ "org_lod_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new BaseDataInterfaceVO();
				if (fcastTrnsStsCd[i] != null)
					model.setFcastTrnsStsCd(fcastTrnsStsCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (initCmAmt[i] != null)
					model.setInitCmAmt(initCmAmt[i]);
				if (repTrdCd[i] != null)
					model.setRepTrdCd(repTrdCd[i]);
				if (chngSlsOfcCd[i] != null)
					model.setChngSlsOfcCd(chngSlsOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chngCmUcAmt[i] != null)
					model.setChngCmUcAmt(chngCmUcAmt[i]);
				if (mtyTrspUcAmt[i] != null)
					model.setMtyTrspUcAmt(mtyTrspUcAmt[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (ldfRto[i] != null)
					model.setLdfRto(ldfRto[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (year[i] != null)
					model.setYear(year[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fullTrspUcAmt[i] != null)
					model.setFullTrspUcAmt(fullTrspUcAmt[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (ctrtFlg[i] != null)
					model.setCtrtFlg(ctrtFlg[i]);
				if (slsAqCd[i] != null)
					model.setSlsAqCd(slsAqCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (stDt[i] != null)
					model.setStDt(stDt[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (agnCommUtAmt[i] != null)
					model.setAgnCommUtAmt(agnCommUtAmt[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (cmpb[i] != null)
					model.setCmpb(cmpb[i]);
				if (orgLdfRto[i] != null)
					model.setOrgLdfRto(orgLdfRto[i]);
				if (chngOfcCd[i] != null)
					model.setChngOfcCd(chngOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (polCd1[i] != null)
					model.setPolCd1(polCd1[i]);
				if (polCd2[i] != null)
					model.setPolCd2(polCd2[i]);
				if (polCd3[i] != null)
					model.setPolCd3(polCd3[i]);
				if (ioc[i] != null)
					model.setIoc(ioc[i]);
				if (polCd4[i] != null)
					model.setPolCd4(polCd4[i]);
				if (slsFlg[i] != null)
					model.setSlsFlg(slsFlg[i]);
				if (polCd5[i] != null)
					model.setPolCd5(polCd5[i]);
				if (polCd6[i] != null)
					model.setPolCd6(polCd6[i]);
				if (polCd7[i] != null)
					model.setPolCd7(polCd7[i]);
				if (polCd8[i] != null)
					model.setPolCd8(polCd8[i]);
				if (polCd9[i] != null)
					model.setPolCd9(polCd9[i]);
				if (polCd10[i] != null)
					model.setPolCd10(polCd10[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (orgRlaneCd[i] != null)
					model.setOrgRlaneCd(orgRlaneCd[i]);
				if (cmUcAmt[i] != null)
					model.setCmUcAmt(cmUcAmt[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (splAmt[i] != null)
					model.setSplAmt(splAmt[i]);
				if (orgGrsRpbRev[i] != null)
					model.setOrgGrsRpbRev(orgGrsRpbRev[i]);
				if (glineCmAmt[i] != null)
					model.setGlineCmAmt(glineCmAmt[i]);
				if (yearMon[i] != null)
					model.setYearMon(yearMon[i]);
				if (bseYrwk[i] != null)
					model.setBseYrwk(bseYrwk[i]);
				if (ctrtRhqCd[i] != null)
					model.setCtrtRhqCd(ctrtRhqCd[i]);
				if (rowClr[i] != null)
					model.setRowClr(rowClr[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mtyStvgUcAmt[i] != null)
					model.setMtyStvgUcAmt(mtyStvgUcAmt[i]);
				if (searchLane[i] != null)
					model.setSearchLane(searchLane[i]);
				if (grsRpbRev[i] != null)
					model.setGrsRpbRev(grsRpbRev[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (mqtaMdlVerNo[i] != null)
					model.setMqtaMdlVerNo(mqtaMdlVerNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (iocTsCd[i] != null)
					model.setIocTsCd(iocTsCd[i]);
				if (ctrtAqCd[i] != null)
					model.setCtrtAqCd(ctrtAqCd[i]);
				if (savFlg[i] != null)
					model.setSavFlg(savFlg[i]);
				if (glineStsFlg[i] != null)
					model.setGlineStsFlg(glineStsFlg[i]);
				if (tmlVolIncntAmt[i] != null)
					model.setTmlVolIncntAmt(tmlVolIncntAmt[i]);
				if (chngCtrtOfcCd[i] != null)
					model.setChngCtrtOfcCd(chngCtrtOfcCd[i]);
				if (ctrtRgnOfcCd[i] != null)
					model.setCtrtRgnOfcCd(ctrtRgnOfcCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (cmAmt[i] != null)
					model.setCmAmt(cmAmt[i]);
				if (orgCmUcAmt[i] != null)
					model.setOrgCmUcAmt(orgCmUcAmt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (cdDpSeq[i] != null)
					model.setCdDpSeq(cdDpSeq[i]);
				if (bseMonth[i] != null)
					model.setBseMonth(bseMonth[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (fullStvgUcAmt[i] != null)
					model.setFullStvgUcAmt(fullStvgUcAmt[i]);
				if (repSubTrdCd[i] != null)
					model.setRepSubTrdCd(repSubTrdCd[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (orgLodQty[i] != null)
					model.setOrgLodQty(orgLodQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBaseDataInterfaceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BaseDataInterfaceVO[]
	 */
	public BaseDataInterfaceVO[] getBaseDataInterfaceVOs(){
		BaseDataInterfaceVO[] vos = (BaseDataInterfaceVO[])models.toArray(new BaseDataInterfaceVO[models.size()]);
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
		this.fcastTrnsStsCd = this.fcastTrnsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initCmAmt = this.initCmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrdCd = this.repTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chngSlsOfcCd = this.chngSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chngCmUcAmt = this.chngCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspUcAmt = this.mtyTrspUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldfRto = this.ldfRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year = this.year .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullTrspUcAmt = this.fullTrspUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtFlg = this.ctrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsAqCd = this.slsAqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stDt = this.stDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCommUtAmt = this.agnCommUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpb = this.cmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLdfRto = this.orgLdfRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chngOfcCd = this.chngOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd1 = this.polCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd2 = this.polCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd3 = this.polCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioc = this.ioc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd4 = this.polCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsFlg = this.slsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd5 = this.polCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd6 = this.polCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd7 = this.polCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd8 = this.polCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd9 = this.polCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd10 = this.polCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRlaneCd = this.orgRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmUcAmt = this.cmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splAmt = this.splAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgGrsRpbRev = this.orgGrsRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineCmAmt = this.glineCmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearMon = this.yearMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYrwk = this.bseYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRhqCd = this.ctrtRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowClr = this.rowClr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyStvgUcAmt = this.mtyStvgUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchLane = this.searchLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRpbRev = this.grsRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqtaMdlVerNo = this.mqtaMdlVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocTsCd = this.iocTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtAqCd = this.ctrtAqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savFlg = this.savFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineStsFlg = this.glineStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlVolIncntAmt = this.tmlVolIncntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chngCtrtOfcCd = this.chngCtrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRgnOfcCd = this.ctrtRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmAmt = this.cmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCmUcAmt = this.orgCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdDpSeq = this.cdDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMonth = this.bseMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullStvgUcAmt = this.fullStvgUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repSubTrdCd = this.repSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLodQty = this.orgLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
