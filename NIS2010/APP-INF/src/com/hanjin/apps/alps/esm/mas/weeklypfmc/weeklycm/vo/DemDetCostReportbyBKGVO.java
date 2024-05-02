/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DemDetCostReportbyBKGVO.java
*@FileTitle : DemDetCostReportbyBKGVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.18  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DemDetCostReportbyBKGVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DemDetCostReportbyBKGVO> models = new ArrayList<DemDetCostReportbyBKGVO>();
	
	/* Column Info */
	private String cntrStatus = null;
	/* Column Info */
	private String cntrEqWthn = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String fSlsMon = null;
	/* Column Info */
	private String fLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String fStatus = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String fPorCd = null;
	/* Column Info */
	private String cntrToDt = null;
	/* Column Info */
	private String cntrStayDys = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String stoStatus = null;
	/* Column Info */
	private String overDys = null;
	/* Column Info */
	private String fToMon = null;
	/* Column Info */
	private String fScNo = null;
	/* Column Info */
	private String railStoWthn = null;
	/* Column Info */
	private String chssComWthn = null;
	/* Column Info */
	private String fToWk = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chssStWthn = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String ttlStatus = null;
	/* Column Info */
	private String fYear = null;
	/* Column Info */
	private String incAmt = null;
	/* Column Info */
	private String fChkprd = null;
	/* Column Info */
	private String fDelCd = null;
	/* Column Info */
	private String fCntrNo = null;
	/* Column Info */
	private String fCntrTpszCd = null;
	/* Column Info */
	private String bilAmt = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chssStAft = null;
	/* Column Info */
	private String fCntrOfcCd = null;
	/* Column Info */
	private String mrnStoAft = null;
	/* Column Info */
	private String costTtlAft = null;
	/* Column Info */
	private String ftEndDt = null;
	/* Column Info */
	private String cntrFmDt = null;
	/* Column Info */
	private String cntrOfcCd = null;
	/* Column Info */
	private String cntrFmNodCd = null;
	/* Column Info */
	private String chssStatus = null;
	/* Column Info */
	private String fBkgNo = null;
	/* Column Info */
	private String invChgAmt = null;
	/* Column Info */
	private String chssComAft = null;
	/* Column Info */
	private String rfHndlAft = null;
	/* Column Info */
	private String costTtlWthn = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String railStoAft = null;
	/* Column Info */
	private String cntrEqAft = null;
	/* Column Info */
	private String mrnStoWthn = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String rfHndlWthn = null;
	/* Column Info */
	private String fRfaNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DemDetCostReportbyBKGVO() {}

	public DemDetCostReportbyBKGVO(String ibflag, String pagerows, String fChkprd, String fYear, String fFmMon, String fToMon, String fSlsMon, String fFmWk, String fToWk, String fStatus, String fBkgNo, String fCntrNo, String fCntrOfcCd, String fPorCd, String fDelCd, String fCntrTpszCd, String fScNo, String fRfaNo, String fLocCd, String costYrmon, String costWk, String bkgNo, String cntrNo, String cntrTpszCd, String scNo, String rfaNo, String cntrOfcCd, String cntrFmNodCd, String ioBndCd, String cntrFmDt, String cntrToDt, String cntrStayDys, String ftEndDt, String overDys, String incAmt, String bilAmt, String invChgAmt, String mrnStoWthn, String railStoWthn, String cntrEqWthn, String chssStWthn, String chssComWthn, String rfHndlWthn, String costTtlWthn, String mrnStoAft, String railStoAft, String cntrEqAft, String chssStAft, String chssComAft, String rfHndlAft, String costTtlAft, String stoStatus, String cntrStatus, String chssStatus, String ttlStatus) {
		this.cntrStatus = cntrStatus;
		this.cntrEqWthn = cntrEqWthn;
		this.fFmMon = fFmMon;
		this.fSlsMon = fSlsMon;
		this.fLocCd = fLocCd;
		this.pagerows = pagerows;
		this.costYrmon = costYrmon;
		this.fStatus = fStatus;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.fPorCd = fPorCd;
		this.cntrToDt = cntrToDt;
		this.cntrStayDys = cntrStayDys;
		this.fFmWk = fFmWk;
		this.stoStatus = stoStatus;
		this.overDys = overDys;
		this.fToMon = fToMon;
		this.fScNo = fScNo;
		this.railStoWthn = railStoWthn;
		this.chssComWthn = chssComWthn;
		this.fToWk = fToWk;
		this.bkgNo = bkgNo;
		this.chssStWthn = chssStWthn;
		this.costWk = costWk;
		this.ttlStatus = ttlStatus;
		this.fYear = fYear;
		this.incAmt = incAmt;
		this.fChkprd = fChkprd;
		this.fDelCd = fDelCd;
		this.fCntrNo = fCntrNo;
		this.fCntrTpszCd = fCntrTpszCd;
		this.bilAmt = bilAmt;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.chssStAft = chssStAft;
		this.fCntrOfcCd = fCntrOfcCd;
		this.mrnStoAft = mrnStoAft;
		this.costTtlAft = costTtlAft;
		this.ftEndDt = ftEndDt;
		this.cntrFmDt = cntrFmDt;
		this.cntrOfcCd = cntrOfcCd;
		this.cntrFmNodCd = cntrFmNodCd;
		this.chssStatus = chssStatus;
		this.fBkgNo = fBkgNo;
		this.invChgAmt = invChgAmt;
		this.chssComAft = chssComAft;
		this.rfHndlAft = rfHndlAft;
		this.costTtlWthn = costTtlWthn;
		this.ioBndCd = ioBndCd;
		this.railStoAft = railStoAft;
		this.cntrEqAft = cntrEqAft;
		this.mrnStoWthn = mrnStoWthn;
		this.cntrNo = cntrNo;
		this.rfHndlWthn = rfHndlWthn;
		this.fRfaNo = fRfaNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_status", getCntrStatus());
		this.hashColumns.put("cntr_eq_wthn", getCntrEqWthn());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("f_sls_mon", getFSlsMon());
		this.hashColumns.put("f_loc_cd", getFLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("f_status", getFStatus());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("f_por_cd", getFPorCd());
		this.hashColumns.put("cntr_to_dt", getCntrToDt());
		this.hashColumns.put("cntr_stay_dys", getCntrStayDys());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("sto_status", getStoStatus());
		this.hashColumns.put("over_dys", getOverDys());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("f_sc_no", getFScNo());
		this.hashColumns.put("rail_sto_wthn", getRailStoWthn());
		this.hashColumns.put("chss_com_wthn", getChssComWthn());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("chss_st_wthn", getChssStWthn());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("ttl_status", getTtlStatus());
		this.hashColumns.put("f_year", getFYear());
		this.hashColumns.put("inc_amt", getIncAmt());
		this.hashColumns.put("f_chkprd", getFChkprd());
		this.hashColumns.put("f_del_cd", getFDelCd());
		this.hashColumns.put("f_cntr_no", getFCntrNo());
		this.hashColumns.put("f_cntr_tpsz_cd", getFCntrTpszCd());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chss_st_aft", getChssStAft());
		this.hashColumns.put("f_cntr_ofc_cd", getFCntrOfcCd());
		this.hashColumns.put("mrn_sto_aft", getMrnStoAft());
		this.hashColumns.put("cost_ttl_aft", getCostTtlAft());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("cntr_fm_dt", getCntrFmDt());
		this.hashColumns.put("cntr_ofc_cd", getCntrOfcCd());
		this.hashColumns.put("cntr_fm_nod_cd", getCntrFmNodCd());
		this.hashColumns.put("chss_status", getChssStatus());
		this.hashColumns.put("f_bkg_no", getFBkgNo());
		this.hashColumns.put("inv_chg_amt", getInvChgAmt());
		this.hashColumns.put("chss_com_aft", getChssComAft());
		this.hashColumns.put("rf_hndl_aft", getRfHndlAft());
		this.hashColumns.put("cost_ttl_wthn", getCostTtlWthn());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("rail_sto_aft", getRailStoAft());
		this.hashColumns.put("cntr_eq_aft", getCntrEqAft());
		this.hashColumns.put("mrn_sto_wthn", getMrnStoWthn());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rf_hndl_wthn", getRfHndlWthn());
		this.hashColumns.put("f_rfa_no", getFRfaNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_status", "cntrStatus");
		this.hashFields.put("cntr_eq_wthn", "cntrEqWthn");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("f_sls_mon", "fSlsMon");
		this.hashFields.put("f_loc_cd", "fLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("f_status", "fStatus");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("f_por_cd", "fPorCd");
		this.hashFields.put("cntr_to_dt", "cntrToDt");
		this.hashFields.put("cntr_stay_dys", "cntrStayDys");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("sto_status", "stoStatus");
		this.hashFields.put("over_dys", "overDys");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("f_sc_no", "fScNo");
		this.hashFields.put("rail_sto_wthn", "railStoWthn");
		this.hashFields.put("chss_com_wthn", "chssComWthn");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chss_st_wthn", "chssStWthn");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("ttl_status", "ttlStatus");
		this.hashFields.put("f_year", "fYear");
		this.hashFields.put("inc_amt", "incAmt");
		this.hashFields.put("f_chkprd", "fChkprd");
		this.hashFields.put("f_del_cd", "fDelCd");
		this.hashFields.put("f_cntr_no", "fCntrNo");
		this.hashFields.put("f_cntr_tpsz_cd", "fCntrTpszCd");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chss_st_aft", "chssStAft");
		this.hashFields.put("f_cntr_ofc_cd", "fCntrOfcCd");
		this.hashFields.put("mrn_sto_aft", "mrnStoAft");
		this.hashFields.put("cost_ttl_aft", "costTtlAft");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("cntr_fm_dt", "cntrFmDt");
		this.hashFields.put("cntr_ofc_cd", "cntrOfcCd");
		this.hashFields.put("cntr_fm_nod_cd", "cntrFmNodCd");
		this.hashFields.put("chss_status", "chssStatus");
		this.hashFields.put("f_bkg_no", "fBkgNo");
		this.hashFields.put("inv_chg_amt", "invChgAmt");
		this.hashFields.put("chss_com_aft", "chssComAft");
		this.hashFields.put("rf_hndl_aft", "rfHndlAft");
		this.hashFields.put("cost_ttl_wthn", "costTtlWthn");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("rail_sto_aft", "railStoAft");
		this.hashFields.put("cntr_eq_aft", "cntrEqAft");
		this.hashFields.put("mrn_sto_wthn", "mrnStoWthn");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rf_hndl_wthn", "rfHndlWthn");
		this.hashFields.put("f_rfa_no", "fRfaNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrStatus
	 */
	public String getCntrStatus() {
		return this.cntrStatus;
	}
	
	/**
	 * Column Info
	 * @return cntrEqWthn
	 */
	public String getCntrEqWthn() {
		return this.cntrEqWthn;
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
	 * @return fSlsMon
	 */
	public String getFSlsMon() {
		return this.fSlsMon;
	}
	
	/**
	 * Column Info
	 * @return fLocCd
	 */
	public String getFLocCd() {
		return this.fLocCd;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return fStatus
	 */
	public String getFStatus() {
		return this.fStatus;
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
	 * @return fPorCd
	 */
	public String getFPorCd() {
		return this.fPorCd;
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
	 * @return cntrStayDys
	 */
	public String getCntrStayDys() {
		return this.cntrStayDys;
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
	 * @return stoStatus
	 */
	public String getStoStatus() {
		return this.stoStatus;
	}
	
	/**
	 * Column Info
	 * @return overDys
	 */
	public String getOverDys() {
		return this.overDys;
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
	 * @return railStoWthn
	 */
	public String getRailStoWthn() {
		return this.railStoWthn;
	}
	
	/**
	 * Column Info
	 * @return chssComWthn
	 */
	public String getChssComWthn() {
		return this.chssComWthn;
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
	 * @return chssStWthn
	 */
	public String getChssStWthn() {
		return this.chssStWthn;
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
	 * @return ttlStatus
	 */
	public String getTtlStatus() {
		return this.ttlStatus;
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
	 * @return incAmt
	 */
	public String getIncAmt() {
		return this.incAmt;
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
	 * @return fDelCd
	 */
	public String getFDelCd() {
		return this.fDelCd;
	}
	
	/**
	 * Column Info
	 * @return fCntrNo
	 */
	public String getFCntrNo() {
		return this.fCntrNo;
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
	 * @return chssStAft
	 */
	public String getChssStAft() {
		return this.chssStAft;
	}
	
	/**
	 * Column Info
	 * @return fCntrOfcCd
	 */
	public String getFCntrOfcCd() {
		return this.fCntrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mrnStoAft
	 */
	public String getMrnStoAft() {
		return this.mrnStoAft;
	}
	
	/**
	 * Column Info
	 * @return costTtlAft
	 */
	public String getCostTtlAft() {
		return this.costTtlAft;
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
	 * @return cntrFmDt
	 */
	public String getCntrFmDt() {
		return this.cntrFmDt;
	}
	
	/**
	 * Column Info
	 * @return cntrOfcCd
	 */
	public String getCntrOfcCd() {
		return this.cntrOfcCd;
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
	 * @return chssStatus
	 */
	public String getChssStatus() {
		return this.chssStatus;
	}
	
	/**
	 * Column Info
	 * @return fBkgNo
	 */
	public String getFBkgNo() {
		return this.fBkgNo;
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
	 * @return chssComAft
	 */
	public String getChssComAft() {
		return this.chssComAft;
	}
	
	/**
	 * Column Info
	 * @return rfHndlAft
	 */
	public String getRfHndlAft() {
		return this.rfHndlAft;
	}
	
	/**
	 * Column Info
	 * @return costTtlWthn
	 */
	public String getCostTtlWthn() {
		return this.costTtlWthn;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return railStoAft
	 */
	public String getRailStoAft() {
		return this.railStoAft;
	}
	
	/**
	 * Column Info
	 * @return cntrEqAft
	 */
	public String getCntrEqAft() {
		return this.cntrEqAft;
	}
	
	/**
	 * Column Info
	 * @return mrnStoWthn
	 */
	public String getMrnStoWthn() {
		return this.mrnStoWthn;
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
	 * @return rfHndlWthn
	 */
	public String getRfHndlWthn() {
		return this.rfHndlWthn;
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
	 * @param cntrStatus
	 */
	public void setCntrStatus(String cntrStatus) {
		this.cntrStatus = cntrStatus;
	}
	
	/**
	 * Column Info
	 * @param cntrEqWthn
	 */
	public void setCntrEqWthn(String cntrEqWthn) {
		this.cntrEqWthn = cntrEqWthn;
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
	 * @param fSlsMon
	 */
	public void setFSlsMon(String fSlsMon) {
		this.fSlsMon = fSlsMon;
	}
	
	/**
	 * Column Info
	 * @param fLocCd
	 */
	public void setFLocCd(String fLocCd) {
		this.fLocCd = fLocCd;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param fStatus
	 */
	public void setFStatus(String fStatus) {
		this.fStatus = fStatus;
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
	 * @param fPorCd
	 */
	public void setFPorCd(String fPorCd) {
		this.fPorCd = fPorCd;
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
	 * @param cntrStayDys
	 */
	public void setCntrStayDys(String cntrStayDys) {
		this.cntrStayDys = cntrStayDys;
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
	 * @param stoStatus
	 */
	public void setStoStatus(String stoStatus) {
		this.stoStatus = stoStatus;
	}
	
	/**
	 * Column Info
	 * @param overDys
	 */
	public void setOverDys(String overDys) {
		this.overDys = overDys;
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
	 * @param railStoWthn
	 */
	public void setRailStoWthn(String railStoWthn) {
		this.railStoWthn = railStoWthn;
	}
	
	/**
	 * Column Info
	 * @param chssComWthn
	 */
	public void setChssComWthn(String chssComWthn) {
		this.chssComWthn = chssComWthn;
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
	 * @param chssStWthn
	 */
	public void setChssStWthn(String chssStWthn) {
		this.chssStWthn = chssStWthn;
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
	 * @param ttlStatus
	 */
	public void setTtlStatus(String ttlStatus) {
		this.ttlStatus = ttlStatus;
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
	 * @param incAmt
	 */
	public void setIncAmt(String incAmt) {
		this.incAmt = incAmt;
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
	 * @param fDelCd
	 */
	public void setFDelCd(String fDelCd) {
		this.fDelCd = fDelCd;
	}
	
	/**
	 * Column Info
	 * @param fCntrNo
	 */
	public void setFCntrNo(String fCntrNo) {
		this.fCntrNo = fCntrNo;
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
	 * @param chssStAft
	 */
	public void setChssStAft(String chssStAft) {
		this.chssStAft = chssStAft;
	}
	
	/**
	 * Column Info
	 * @param fCntrOfcCd
	 */
	public void setFCntrOfcCd(String fCntrOfcCd) {
		this.fCntrOfcCd = fCntrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mrnStoAft
	 */
	public void setMrnStoAft(String mrnStoAft) {
		this.mrnStoAft = mrnStoAft;
	}
	
	/**
	 * Column Info
	 * @param costTtlAft
	 */
	public void setCostTtlAft(String costTtlAft) {
		this.costTtlAft = costTtlAft;
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
	 * @param cntrFmDt
	 */
	public void setCntrFmDt(String cntrFmDt) {
		this.cntrFmDt = cntrFmDt;
	}
	
	/**
	 * Column Info
	 * @param cntrOfcCd
	 */
	public void setCntrOfcCd(String cntrOfcCd) {
		this.cntrOfcCd = cntrOfcCd;
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
	 * @param chssStatus
	 */
	public void setChssStatus(String chssStatus) {
		this.chssStatus = chssStatus;
	}
	
	/**
	 * Column Info
	 * @param fBkgNo
	 */
	public void setFBkgNo(String fBkgNo) {
		this.fBkgNo = fBkgNo;
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
	 * @param chssComAft
	 */
	public void setChssComAft(String chssComAft) {
		this.chssComAft = chssComAft;
	}
	
	/**
	 * Column Info
	 * @param rfHndlAft
	 */
	public void setRfHndlAft(String rfHndlAft) {
		this.rfHndlAft = rfHndlAft;
	}
	
	/**
	 * Column Info
	 * @param costTtlWthn
	 */
	public void setCostTtlWthn(String costTtlWthn) {
		this.costTtlWthn = costTtlWthn;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param railStoAft
	 */
	public void setRailStoAft(String railStoAft) {
		this.railStoAft = railStoAft;
	}
	
	/**
	 * Column Info
	 * @param cntrEqAft
	 */
	public void setCntrEqAft(String cntrEqAft) {
		this.cntrEqAft = cntrEqAft;
	}
	
	/**
	 * Column Info
	 * @param mrnStoWthn
	 */
	public void setMrnStoWthn(String mrnStoWthn) {
		this.mrnStoWthn = mrnStoWthn;
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
	 * @param rfHndlWthn
	 */
	public void setRfHndlWthn(String rfHndlWthn) {
		this.rfHndlWthn = rfHndlWthn;
	}
	
	/**
	 * Column Info
	 * @param fRfaNo
	 */
	public void setFRfaNo(String fRfaNo) {
		this.fRfaNo = fRfaNo;
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
		setCntrStatus(JSPUtil.getParameter(request, prefix + "cntr_status", ""));
		setCntrEqWthn(JSPUtil.getParameter(request, prefix + "cntr_eq_wthn", ""));
		setFFmMon(JSPUtil.getParameter(request, prefix + "f_fm_mon", ""));
		setFSlsMon(JSPUtil.getParameter(request, prefix + "f_sls_mon", ""));
		setFLocCd(JSPUtil.getParameter(request, prefix + "f_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setFStatus(JSPUtil.getParameter(request, prefix + "f_status", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setFPorCd(JSPUtil.getParameter(request, prefix + "f_por_cd", ""));
		setCntrToDt(JSPUtil.getParameter(request, prefix + "cntr_to_dt", ""));
		setCntrStayDys(JSPUtil.getParameter(request, prefix + "cntr_stay_dys", ""));
		setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
		setStoStatus(JSPUtil.getParameter(request, prefix + "sto_status", ""));
		setOverDys(JSPUtil.getParameter(request, prefix + "over_dys", ""));
		setFToMon(JSPUtil.getParameter(request, prefix + "f_to_mon", ""));
		setFScNo(JSPUtil.getParameter(request, prefix + "f_sc_no", ""));
		setRailStoWthn(JSPUtil.getParameter(request, prefix + "rail_sto_wthn", ""));
		setChssComWthn(JSPUtil.getParameter(request, prefix + "chss_com_wthn", ""));
		setFToWk(JSPUtil.getParameter(request, prefix + "f_to_wk", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setChssStWthn(JSPUtil.getParameter(request, prefix + "chss_st_wthn", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setTtlStatus(JSPUtil.getParameter(request, prefix + "ttl_status", ""));
		setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
		setIncAmt(JSPUtil.getParameter(request, prefix + "inc_amt", ""));
		setFChkprd(JSPUtil.getParameter(request, prefix + "f_chkprd", ""));
		setFDelCd(JSPUtil.getParameter(request, prefix + "f_del_cd", ""));
		setFCntrNo(JSPUtil.getParameter(request, prefix + "f_cntr_no", ""));
		setFCntrTpszCd(JSPUtil.getParameter(request, prefix + "f_cntr_tpsz_cd", ""));
		setBilAmt(JSPUtil.getParameter(request, prefix + "bil_amt", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChssStAft(JSPUtil.getParameter(request, prefix + "chss_st_aft", ""));
		setFCntrOfcCd(JSPUtil.getParameter(request, prefix + "f_cntr_ofc_cd", ""));
		setMrnStoAft(JSPUtil.getParameter(request, prefix + "mrn_sto_aft", ""));
		setCostTtlAft(JSPUtil.getParameter(request, prefix + "cost_ttl_aft", ""));
		setFtEndDt(JSPUtil.getParameter(request, prefix + "ft_end_dt", ""));
		setCntrFmDt(JSPUtil.getParameter(request, prefix + "cntr_fm_dt", ""));
		setCntrOfcCd(JSPUtil.getParameter(request, prefix + "cntr_ofc_cd", ""));
		setCntrFmNodCd(JSPUtil.getParameter(request, prefix + "cntr_fm_nod_cd", ""));
		setChssStatus(JSPUtil.getParameter(request, prefix + "chss_status", ""));
		setFBkgNo(JSPUtil.getParameter(request, prefix + "f_bkg_no", ""));
		setInvChgAmt(JSPUtil.getParameter(request, prefix + "inv_chg_amt", ""));
		setChssComAft(JSPUtil.getParameter(request, prefix + "chss_com_aft", ""));
		setRfHndlAft(JSPUtil.getParameter(request, prefix + "rf_hndl_aft", ""));
		setCostTtlWthn(JSPUtil.getParameter(request, prefix + "cost_ttl_wthn", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setRailStoAft(JSPUtil.getParameter(request, prefix + "rail_sto_aft", ""));
		setCntrEqAft(JSPUtil.getParameter(request, prefix + "cntr_eq_aft", ""));
		setMrnStoWthn(JSPUtil.getParameter(request, prefix + "mrn_sto_wthn", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setRfHndlWthn(JSPUtil.getParameter(request, prefix + "rf_hndl_wthn", ""));
		setFRfaNo(JSPUtil.getParameter(request, prefix + "f_rfa_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DemDetCostReportbyBKGVO[]
	 */
	public DemDetCostReportbyBKGVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DemDetCostReportbyBKGVO[]
	 */
	public DemDetCostReportbyBKGVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DemDetCostReportbyBKGVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrStatus = (JSPUtil.getParameter(request, prefix	+ "cntr_status", length));
			String[] cntrEqWthn = (JSPUtil.getParameter(request, prefix	+ "cntr_eq_wthn", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] fSlsMon = (JSPUtil.getParameter(request, prefix	+ "f_sls_mon", length));
			String[] fLocCd = (JSPUtil.getParameter(request, prefix	+ "f_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] fStatus = (JSPUtil.getParameter(request, prefix	+ "f_status", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] fPorCd = (JSPUtil.getParameter(request, prefix	+ "f_por_cd", length));
			String[] cntrToDt = (JSPUtil.getParameter(request, prefix	+ "cntr_to_dt", length));
			String[] cntrStayDys = (JSPUtil.getParameter(request, prefix	+ "cntr_stay_dys", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] stoStatus = (JSPUtil.getParameter(request, prefix	+ "sto_status", length));
			String[] overDys = (JSPUtil.getParameter(request, prefix	+ "over_dys", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] fScNo = (JSPUtil.getParameter(request, prefix	+ "f_sc_no", length));
			String[] railStoWthn = (JSPUtil.getParameter(request, prefix	+ "rail_sto_wthn", length));
			String[] chssComWthn = (JSPUtil.getParameter(request, prefix	+ "chss_com_wthn", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chssStWthn = (JSPUtil.getParameter(request, prefix	+ "chss_st_wthn", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] ttlStatus = (JSPUtil.getParameter(request, prefix	+ "ttl_status", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			String[] incAmt = (JSPUtil.getParameter(request, prefix	+ "inc_amt", length));
			String[] fChkprd = (JSPUtil.getParameter(request, prefix	+ "f_chkprd", length));
			String[] fDelCd = (JSPUtil.getParameter(request, prefix	+ "f_del_cd", length));
			String[] fCntrNo = (JSPUtil.getParameter(request, prefix	+ "f_cntr_no", length));
			String[] fCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tpsz_cd", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chssStAft = (JSPUtil.getParameter(request, prefix	+ "chss_st_aft", length));
			String[] fCntrOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_ofc_cd", length));
			String[] mrnStoAft = (JSPUtil.getParameter(request, prefix	+ "mrn_sto_aft", length));
			String[] costTtlAft = (JSPUtil.getParameter(request, prefix	+ "cost_ttl_aft", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] cntrFmDt = (JSPUtil.getParameter(request, prefix	+ "cntr_fm_dt", length));
			String[] cntrOfcCd = (JSPUtil.getParameter(request, prefix	+ "cntr_ofc_cd", length));
			String[] cntrFmNodCd = (JSPUtil.getParameter(request, prefix	+ "cntr_fm_nod_cd", length));
			String[] chssStatus = (JSPUtil.getParameter(request, prefix	+ "chss_status", length));
			String[] fBkgNo = (JSPUtil.getParameter(request, prefix	+ "f_bkg_no", length));
			String[] invChgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_chg_amt", length));
			String[] chssComAft = (JSPUtil.getParameter(request, prefix	+ "chss_com_aft", length));
			String[] rfHndlAft = (JSPUtil.getParameter(request, prefix	+ "rf_hndl_aft", length));
			String[] costTtlWthn = (JSPUtil.getParameter(request, prefix	+ "cost_ttl_wthn", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] railStoAft = (JSPUtil.getParameter(request, prefix	+ "rail_sto_aft", length));
			String[] cntrEqAft = (JSPUtil.getParameter(request, prefix	+ "cntr_eq_aft", length));
			String[] mrnStoWthn = (JSPUtil.getParameter(request, prefix	+ "mrn_sto_wthn", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] rfHndlWthn = (JSPUtil.getParameter(request, prefix	+ "rf_hndl_wthn", length));
			String[] fRfaNo = (JSPUtil.getParameter(request, prefix	+ "f_rfa_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new DemDetCostReportbyBKGVO();
				if (cntrStatus[i] != null)
					model.setCntrStatus(cntrStatus[i]);
				if (cntrEqWthn[i] != null)
					model.setCntrEqWthn(cntrEqWthn[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (fSlsMon[i] != null)
					model.setFSlsMon(fSlsMon[i]);
				if (fLocCd[i] != null)
					model.setFLocCd(fLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (fStatus[i] != null)
					model.setFStatus(fStatus[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (fPorCd[i] != null)
					model.setFPorCd(fPorCd[i]);
				if (cntrToDt[i] != null)
					model.setCntrToDt(cntrToDt[i]);
				if (cntrStayDys[i] != null)
					model.setCntrStayDys(cntrStayDys[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (stoStatus[i] != null)
					model.setStoStatus(stoStatus[i]);
				if (overDys[i] != null)
					model.setOverDys(overDys[i]);
				if (fToMon[i] != null)
					model.setFToMon(fToMon[i]);
				if (fScNo[i] != null)
					model.setFScNo(fScNo[i]);
				if (railStoWthn[i] != null)
					model.setRailStoWthn(railStoWthn[i]);
				if (chssComWthn[i] != null)
					model.setChssComWthn(chssComWthn[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (chssStWthn[i] != null)
					model.setChssStWthn(chssStWthn[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (ttlStatus[i] != null)
					model.setTtlStatus(ttlStatus[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				if (incAmt[i] != null)
					model.setIncAmt(incAmt[i]);
				if (fChkprd[i] != null)
					model.setFChkprd(fChkprd[i]);
				if (fDelCd[i] != null)
					model.setFDelCd(fDelCd[i]);
				if (fCntrNo[i] != null)
					model.setFCntrNo(fCntrNo[i]);
				if (fCntrTpszCd[i] != null)
					model.setFCntrTpszCd(fCntrTpszCd[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chssStAft[i] != null)
					model.setChssStAft(chssStAft[i]);
				if (fCntrOfcCd[i] != null)
					model.setFCntrOfcCd(fCntrOfcCd[i]);
				if (mrnStoAft[i] != null)
					model.setMrnStoAft(mrnStoAft[i]);
				if (costTtlAft[i] != null)
					model.setCostTtlAft(costTtlAft[i]);
				if (ftEndDt[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				if (cntrFmDt[i] != null)
					model.setCntrFmDt(cntrFmDt[i]);
				if (cntrOfcCd[i] != null)
					model.setCntrOfcCd(cntrOfcCd[i]);
				if (cntrFmNodCd[i] != null)
					model.setCntrFmNodCd(cntrFmNodCd[i]);
				if (chssStatus[i] != null)
					model.setChssStatus(chssStatus[i]);
				if (fBkgNo[i] != null)
					model.setFBkgNo(fBkgNo[i]);
				if (invChgAmt[i] != null)
					model.setInvChgAmt(invChgAmt[i]);
				if (chssComAft[i] != null)
					model.setChssComAft(chssComAft[i]);
				if (rfHndlAft[i] != null)
					model.setRfHndlAft(rfHndlAft[i]);
				if (costTtlWthn[i] != null)
					model.setCostTtlWthn(costTtlWthn[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (railStoAft[i] != null)
					model.setRailStoAft(railStoAft[i]);
				if (cntrEqAft[i] != null)
					model.setCntrEqAft(cntrEqAft[i]);
				if (mrnStoWthn[i] != null)
					model.setMrnStoWthn(mrnStoWthn[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (rfHndlWthn[i] != null)
					model.setRfHndlWthn(rfHndlWthn[i]);
				if (fRfaNo[i] != null)
					model.setFRfaNo(fRfaNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDemDetCostReportbyBKGVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DemDetCostReportbyBKGVO[]
	 */
	public DemDetCostReportbyBKGVO[] getDemDetCostReportbyBKGVOs(){
		DemDetCostReportbyBKGVO[] vos = (DemDetCostReportbyBKGVO[])models.toArray(new DemDetCostReportbyBKGVO[models.size()]);
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
		this.cntrStatus = this.cntrStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrEqWthn = this.cntrEqWthn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlsMon = this.fSlsMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLocCd = this.fLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStatus = this.fStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPorCd = this.fPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrToDt = this.cntrToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStayDys = this.cntrStayDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoStatus = this.stoStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDys = this.overDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fScNo = this.fScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railStoWthn = this.railStoWthn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssComWthn = this.chssComWthn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssStWthn = this.chssStWthn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlStatus = this.ttlStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incAmt = this.incAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkprd = this.fChkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDelCd = this.fDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrNo = this.fCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpszCd = this.fCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssStAft = this.chssStAft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrOfcCd = this.fCntrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnStoAft = this.mrnStoAft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTtlAft = this.costTtlAft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFmDt = this.cntrFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOfcCd = this.cntrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFmNodCd = this.cntrFmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssStatus = this.chssStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgNo = this.fBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invChgAmt = this.invChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssComAft = this.chssComAft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfHndlAft = this.rfHndlAft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTtlWthn = this.costTtlWthn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railStoAft = this.railStoAft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrEqAft = this.cntrEqAft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnStoWthn = this.mrnStoWthn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfHndlWthn = this.rfHndlWthn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRfaNo = this.fRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
