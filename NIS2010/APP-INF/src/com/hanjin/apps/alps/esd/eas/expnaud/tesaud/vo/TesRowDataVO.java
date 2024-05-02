/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesRowDataVO.java
*@FileTitle : TesRowDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo;

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

public class TesRowDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesRowDataVO> models = new ArrayList<TesRowDataVO>();
	
	/* Column Info */
	private String spName = null;
	/* Column Info */
	private String tier = null;
	/* Column Info */
	private String rvisVol = null;
	/* Column Info */
	private String rowCount = null;
	/* Column Info */
	private String calcVol = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String amount = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String volTrUtCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String usdRate = null;
	/* Column Info */
	private String manualCheck = null;
	/* Column Info */
	private String fmPrdDt = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String calcVolQty = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String invDateType = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String dcgoIndCd = null;
	/* Column Info */
	private String invoiceStatus = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String n1stNodCd = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String actVvdCd = null;
	/* Column Info */
	private String agmtCurr = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String tmlTrnsModCd = null;
	/* Column Info */
	private String coaCostSrcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String lgsCostDtlCd = null;
	/* Column Info */
	private String tmlCrrCd = null;
	/* Column Info */
	private String atbDt = null;
	/* Column Info */
	private String spCode = null;
	/* Column Info */
	private String issDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lgsCostSubjCd = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String calcType = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String n3ptyFlg = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String rvisVolQty = null;
	/* Column Info */
	private String calcRmk = null;
	/* Column Info */
	private String toPrdDt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String tmlInvStsCd = null;
	/* Column Info */
	private String tmlWrkDyCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesRowDataVO() {}

	public TesRowDataVO(String ibflag, String pagerows, String pageNo, String rowCount, String spName, String cntCd, String tier, String rvisVol, String calcVol, String amount, String rcvDt, String volTrUtCd, String cntrTpszCd, String usdRate, String manualCheck, String fmPrdDt, String calcVolQty, String invXchRt, String rhq, String exeYrmon, String invDateType, String dcgoIndCd, String invoiceStatus, String vvd, String n1stNodCd, String vndrSeq, String rcFlg, String actVvdCd, String agmtCurr, String laneCd, String tmlTrnsModCd, String coaCostSrcCd, String creDt, String lgsCostDtlCd, String tmlCrrCd, String atbDt, String spCode, String issDt, String lgsCostSubjCd, String rate, String calcType, String acctCd, String invAmt, String invOfcCd, String iocCd, String n3ptyFlg, String costOfcCd, String rvisVolQty, String calcRmk, String toPrdDt, String ioBndCd, String invNo, String ydCd, String tmlInvStsCd, String tmlWrkDyCd, String creUsrNm) {
		this.spName = spName;
		this.tier = tier;
		this.rvisVol = rvisVol;
		this.rowCount = rowCount;
		this.calcVol = calcVol;
		this.pagerows = pagerows;
		this.amount = amount;
		this.rcvDt = rcvDt;
		this.volTrUtCd = volTrUtCd;
		this.cntCd = cntCd;
		this.cntrTpszCd = cntrTpszCd;
		this.usdRate = usdRate;
		this.manualCheck = manualCheck;
		this.fmPrdDt = fmPrdDt;
		this.invXchRt = invXchRt;
		this.calcVolQty = calcVolQty;
		this.rhq = rhq;
		this.exeYrmon = exeYrmon;
		this.invDateType = invDateType;
		this.creUsrNm = creUsrNm;
		this.dcgoIndCd = dcgoIndCd;
		this.invoiceStatus = invoiceStatus;
		this.vvd = vvd;
		this.n1stNodCd = n1stNodCd;
		this.pageNo = pageNo;
		this.vndrSeq = vndrSeq;
		this.rcFlg = rcFlg;
		this.actVvdCd = actVvdCd;
		this.agmtCurr = agmtCurr;
		this.laneCd = laneCd;
		this.tmlTrnsModCd = tmlTrnsModCd;
		this.coaCostSrcCd = coaCostSrcCd;
		this.creDt = creDt;
		this.lgsCostDtlCd = lgsCostDtlCd;
		this.tmlCrrCd = tmlCrrCd;
		this.atbDt = atbDt;
		this.spCode = spCode;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.lgsCostSubjCd = lgsCostSubjCd;
		this.rate = rate;
		this.calcType = calcType;
		this.acctCd = acctCd;
		this.invAmt = invAmt;
		this.invOfcCd = invOfcCd;
		this.iocCd = iocCd;
		this.n3ptyFlg = n3ptyFlg;
		this.costOfcCd = costOfcCd;
		this.rvisVolQty = rvisVolQty;
		this.calcRmk = calcRmk;
		this.toPrdDt = toPrdDt;
		this.ioBndCd = ioBndCd;
		this.invNo = invNo;
		this.ydCd = ydCd;
		this.tmlInvStsCd = tmlInvStsCd;
		this.tmlWrkDyCd = tmlWrkDyCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sp_name", getSpName());
		this.hashColumns.put("tier", getTier());
		this.hashColumns.put("rvis_vol", getRvisVol());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("calc_vol", getCalcVol());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("vol_tr_ut_cd", getVolTrUtCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("usd_rate", getUsdRate());
		this.hashColumns.put("manual_check", getManualCheck());
		this.hashColumns.put("fm_prd_dt", getFmPrdDt());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("calc_vol_qty", getCalcVolQty());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("inv_date_type", getInvDateType());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("dcgo_ind_cd", getDcgoIndCd());
		this.hashColumns.put("invoice_status", getInvoiceStatus());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("n1st_nod_cd", getN1stNodCd());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("act_vvd_cd", getActVvdCd());
		this.hashColumns.put("agmt_curr", getAgmtCurr());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("tml_trns_mod_cd", getTmlTrnsModCd());
		this.hashColumns.put("coa_cost_src_cd", getCoaCostSrcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("lgs_cost_dtl_cd", getLgsCostDtlCd());
		this.hashColumns.put("tml_crr_cd", getTmlCrrCd());
		this.hashColumns.put("atb_dt", getAtbDt());
		this.hashColumns.put("sp_code", getSpCode());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lgs_cost_subj_cd", getLgsCostSubjCd());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("calc_type", getCalcType());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("rvis_vol_qty", getRvisVolQty());
		this.hashColumns.put("calc_rmk", getCalcRmk());
		this.hashColumns.put("to_prd_dt", getToPrdDt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("tml_inv_sts_cd", getTmlInvStsCd());
		this.hashColumns.put("tml_wrk_dy_cd", getTmlWrkDyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sp_name", "spName");
		this.hashFields.put("tier", "tier");
		this.hashFields.put("rvis_vol", "rvisVol");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("calc_vol", "calcVol");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("vol_tr_ut_cd", "volTrUtCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("usd_rate", "usdRate");
		this.hashFields.put("manual_check", "manualCheck");
		this.hashFields.put("fm_prd_dt", "fmPrdDt");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("calc_vol_qty", "calcVolQty");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("inv_date_type", "invDateType");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("dcgo_ind_cd", "dcgoIndCd");
		this.hashFields.put("invoice_status", "invoiceStatus");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("n1st_nod_cd", "n1stNodCd");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("act_vvd_cd", "actVvdCd");
		this.hashFields.put("agmt_curr", "agmtCurr");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("tml_trns_mod_cd", "tmlTrnsModCd");
		this.hashFields.put("coa_cost_src_cd", "coaCostSrcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("lgs_cost_dtl_cd", "lgsCostDtlCd");
		this.hashFields.put("tml_crr_cd", "tmlCrrCd");
		this.hashFields.put("atb_dt", "atbDt");
		this.hashFields.put("sp_code", "spCode");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lgs_cost_subj_cd", "lgsCostSubjCd");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("calc_type", "calcType");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("rvis_vol_qty", "rvisVolQty");
		this.hashFields.put("calc_rmk", "calcRmk");
		this.hashFields.put("to_prd_dt", "toPrdDt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("tml_inv_sts_cd", "tmlInvStsCd");
		this.hashFields.put("tml_wrk_dy_cd", "tmlWrkDyCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return spName
	 */
	public String getSpName() {
		return this.spName;
	}
	
	/**
	 * Column Info
	 * @return tier
	 */
	public String getTier() {
		return this.tier;
	}
	
	/**
	 * Column Info
	 * @return rvisVol
	 */
	public String getRvisVol() {
		return this.rvisVol;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
	}
	
	/**
	 * Column Info
	 * @return calcVol
	 */
	public String getCalcVol() {
		return this.calcVol;
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
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return volTrUtCd
	 */
	public String getVolTrUtCd() {
		return this.volTrUtCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return usdRate
	 */
	public String getUsdRate() {
		return this.usdRate;
	}
	
	/**
	 * Column Info
	 * @return manualCheck
	 */
	public String getManualCheck() {
		return this.manualCheck;
	}
	
	/**
	 * Column Info
	 * @return fmPrdDt
	 */
	public String getFmPrdDt() {
		return this.fmPrdDt;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return calcVolQty
	 */
	public String getCalcVolQty() {
		return this.calcVolQty;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return exeYrmon
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
	}
	
	/**
	 * Column Info
	 * @return invDateType
	 */
	public String getInvDateType() {
		return this.invDateType;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return dcgoIndCd
	 */
	public String getDcgoIndCd() {
		return this.dcgoIndCd;
	}
	
	/**
	 * Column Info
	 * @return invoiceStatus
	 */
	public String getInvoiceStatus() {
		return this.invoiceStatus;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return n1stNodCd
	 */
	public String getN1stNodCd() {
		return this.n1stNodCd;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
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
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return actVvdCd
	 */
	public String getActVvdCd() {
		return this.actVvdCd;
	}
	
	/**
	 * Column Info
	 * @return agmtCurr
	 */
	public String getAgmtCurr() {
		return this.agmtCurr;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return tmlTrnsModCd
	 */
	public String getTmlTrnsModCd() {
		return this.tmlTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @return coaCostSrcCd
	 */
	public String getCoaCostSrcCd() {
		return this.coaCostSrcCd;
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
	 * @return lgsCostDtlCd
	 */
	public String getLgsCostDtlCd() {
		return this.lgsCostDtlCd;
	}
	
	/**
	 * Column Info
	 * @return tmlCrrCd
	 */
	public String getTmlCrrCd() {
		return this.tmlCrrCd;
	}
	
	/**
	 * Column Info
	 * @return atbDt
	 */
	public String getAtbDt() {
		return this.atbDt;
	}
	
	/**
	 * Column Info
	 * @return spCode
	 */
	public String getSpCode() {
		return this.spCode;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return lgsCostSubjCd
	 */
	public String getLgsCostSubjCd() {
		return this.lgsCostSubjCd;
	}
	
	/**
	 * Column Info
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Column Info
	 * @return calcType
	 */
	public String getCalcType() {
		return this.calcType;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
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
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
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
	 * @return n3ptyFlg
	 */
	public String getN3ptyFlg() {
		return this.n3ptyFlg;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rvisVolQty
	 */
	public String getRvisVolQty() {
		return this.rvisVolQty;
	}
	
	/**
	 * Column Info
	 * @return calcRmk
	 */
	public String getCalcRmk() {
		return this.calcRmk;
	}
	
	/**
	 * Column Info
	 * @return toPrdDt
	 */
	public String getToPrdDt() {
		return this.toPrdDt;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return tmlInvStsCd
	 */
	public String getTmlInvStsCd() {
		return this.tmlInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return tmlWrkDyCd
	 */
	public String getTmlWrkDyCd() {
		return this.tmlWrkDyCd;
	}
	

	/**
	 * Column Info
	 * @param spName
	 */
	public void setSpName(String spName) {
		this.spName = spName;
	}
	
	/**
	 * Column Info
	 * @param tier
	 */
	public void setTier(String tier) {
		this.tier = tier;
	}
	
	/**
	 * Column Info
	 * @param rvisVol
	 */
	public void setRvisVol(String rvisVol) {
		this.rvisVol = rvisVol;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}
	
	/**
	 * Column Info
	 * @param calcVol
	 */
	public void setCalcVol(String calcVol) {
		this.calcVol = calcVol;
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
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param volTrUtCd
	 */
	public void setVolTrUtCd(String volTrUtCd) {
		this.volTrUtCd = volTrUtCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param usdRate
	 */
	public void setUsdRate(String usdRate) {
		this.usdRate = usdRate;
	}
	
	/**
	 * Column Info
	 * @param manualCheck
	 */
	public void setManualCheck(String manualCheck) {
		this.manualCheck = manualCheck;
	}
	
	/**
	 * Column Info
	 * @param fmPrdDt
	 */
	public void setFmPrdDt(String fmPrdDt) {
		this.fmPrdDt = fmPrdDt;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param calcVolQty
	 */
	public void setCalcVolQty(String calcVolQty) {
		this.calcVolQty = calcVolQty;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}
	
	/**
	 * Column Info
	 * @param invDateType
	 */
	public void setInvDateType(String invDateType) {
		this.invDateType = invDateType;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param dcgoIndCd
	 */
	public void setDcgoIndCd(String dcgoIndCd) {
		this.dcgoIndCd = dcgoIndCd;
	}
	
	/**
	 * Column Info
	 * @param invoiceStatus
	 */
	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param n1stNodCd
	 */
	public void setN1stNodCd(String n1stNodCd) {
		this.n1stNodCd = n1stNodCd;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
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
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param actVvdCd
	 */
	public void setActVvdCd(String actVvdCd) {
		this.actVvdCd = actVvdCd;
	}
	
	/**
	 * Column Info
	 * @param agmtCurr
	 */
	public void setAgmtCurr(String agmtCurr) {
		this.agmtCurr = agmtCurr;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param tmlTrnsModCd
	 */
	public void setTmlTrnsModCd(String tmlTrnsModCd) {
		this.tmlTrnsModCd = tmlTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param coaCostSrcCd
	 */
	public void setCoaCostSrcCd(String coaCostSrcCd) {
		this.coaCostSrcCd = coaCostSrcCd;
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
	 * @param lgsCostDtlCd
	 */
	public void setLgsCostDtlCd(String lgsCostDtlCd) {
		this.lgsCostDtlCd = lgsCostDtlCd;
	}
	
	/**
	 * Column Info
	 * @param tmlCrrCd
	 */
	public void setTmlCrrCd(String tmlCrrCd) {
		this.tmlCrrCd = tmlCrrCd;
	}
	
	/**
	 * Column Info
	 * @param atbDt
	 */
	public void setAtbDt(String atbDt) {
		this.atbDt = atbDt;
	}
	
	/**
	 * Column Info
	 * @param spCode
	 */
	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param lgsCostSubjCd
	 */
	public void setLgsCostSubjCd(String lgsCostSubjCd) {
		this.lgsCostSubjCd = lgsCostSubjCd;
	}
	
	/**
	 * Column Info
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * Column Info
	 * @param calcType
	 */
	public void setCalcType(String calcType) {
		this.calcType = calcType;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
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
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
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
	 * @param n3ptyFlg
	 */
	public void setN3ptyFlg(String n3ptyFlg) {
		this.n3ptyFlg = n3ptyFlg;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rvisVolQty
	 */
	public void setRvisVolQty(String rvisVolQty) {
		this.rvisVolQty = rvisVolQty;
	}
	
	/**
	 * Column Info
	 * @param calcRmk
	 */
	public void setCalcRmk(String calcRmk) {
		this.calcRmk = calcRmk;
	}
	
	/**
	 * Column Info
	 * @param toPrdDt
	 */
	public void setToPrdDt(String toPrdDt) {
		this.toPrdDt = toPrdDt;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param tmlInvStsCd
	 */
	public void setTmlInvStsCd(String tmlInvStsCd) {
		this.tmlInvStsCd = tmlInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param tmlWrkDyCd
	 */
	public void setTmlWrkDyCd(String tmlWrkDyCd) {
		this.tmlWrkDyCd = tmlWrkDyCd;
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
		setSpName(JSPUtil.getParameter(request, prefix + "sp_name", ""));
		setTier(JSPUtil.getParameter(request, prefix + "tier", ""));
		setRvisVol(JSPUtil.getParameter(request, prefix + "rvis_vol", ""));
		setRowCount(JSPUtil.getParameter(request, prefix + "row_count", ""));
		setCalcVol(JSPUtil.getParameter(request, prefix + "calc_vol", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAmount(JSPUtil.getParameter(request, prefix + "amount", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setVolTrUtCd(JSPUtil.getParameter(request, prefix + "vol_tr_ut_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setUsdRate(JSPUtil.getParameter(request, prefix + "usd_rate", ""));
		setManualCheck(JSPUtil.getParameter(request, prefix + "manual_check", ""));
		setFmPrdDt(JSPUtil.getParameter(request, prefix + "fm_prd_dt", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setCalcVolQty(JSPUtil.getParameter(request, prefix + "calc_vol_qty", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setExeYrmon(JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
		setInvDateType(JSPUtil.getParameter(request, prefix + "inv_date_type", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setDcgoIndCd(JSPUtil.getParameter(request, prefix + "dcgo_ind_cd", ""));
		setInvoiceStatus(JSPUtil.getParameter(request, prefix + "invoice_status", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setN1stNodCd(JSPUtil.getParameter(request, prefix + "n1st_nod_cd", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setActVvdCd(JSPUtil.getParameter(request, prefix + "act_vvd_cd", ""));
		setAgmtCurr(JSPUtil.getParameter(request, prefix + "agmt_curr", ""));
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setTmlTrnsModCd(JSPUtil.getParameter(request, prefix + "tml_trns_mod_cd", ""));
		setCoaCostSrcCd(JSPUtil.getParameter(request, prefix + "coa_cost_src_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setLgsCostDtlCd(JSPUtil.getParameter(request, prefix + "lgs_cost_dtl_cd", ""));
		setTmlCrrCd(JSPUtil.getParameter(request, prefix + "tml_crr_cd", ""));
		setAtbDt(JSPUtil.getParameter(request, prefix + "atb_dt", ""));
		setSpCode(JSPUtil.getParameter(request, prefix + "sp_code", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLgsCostSubjCd(JSPUtil.getParameter(request, prefix + "lgs_cost_subj_cd", ""));
		setRate(JSPUtil.getParameter(request, prefix + "rate", ""));
		setCalcType(JSPUtil.getParameter(request, prefix + "calc_type", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setN3ptyFlg(JSPUtil.getParameter(request, prefix + "n3pty_flg", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setRvisVolQty(JSPUtil.getParameter(request, prefix + "rvis_vol_qty", ""));
		setCalcRmk(JSPUtil.getParameter(request, prefix + "calc_rmk", ""));
		setToPrdDt(JSPUtil.getParameter(request, prefix + "to_prd_dt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setTmlInvStsCd(JSPUtil.getParameter(request, prefix + "tml_inv_sts_cd", ""));
		setTmlWrkDyCd(JSPUtil.getParameter(request, prefix + "tml_wrk_dy_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesRowDataVO[]
	 */
	public TesRowDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesRowDataVO[]
	 */
	public TesRowDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesRowDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] spName = (JSPUtil.getParameter(request, prefix	+ "sp_name", length));
			String[] tier = (JSPUtil.getParameter(request, prefix	+ "tier", length));
			String[] rvisVol = (JSPUtil.getParameter(request, prefix	+ "rvis_vol", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] calcVol = (JSPUtil.getParameter(request, prefix	+ "calc_vol", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] volTrUtCd = (JSPUtil.getParameter(request, prefix	+ "vol_tr_ut_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] usdRate = (JSPUtil.getParameter(request, prefix	+ "usd_rate", length));
			String[] manualCheck = (JSPUtil.getParameter(request, prefix	+ "manual_check", length));
			String[] fmPrdDt = (JSPUtil.getParameter(request, prefix	+ "fm_prd_dt", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] calcVolQty = (JSPUtil.getParameter(request, prefix	+ "calc_vol_qty", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] invDateType = (JSPUtil.getParameter(request, prefix	+ "inv_date_type", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] dcgoIndCd = (JSPUtil.getParameter(request, prefix	+ "dcgo_ind_cd", length));
			String[] invoiceStatus = (JSPUtil.getParameter(request, prefix	+ "invoice_status", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] n1stNodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_cd", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] actVvdCd = (JSPUtil.getParameter(request, prefix	+ "act_vvd_cd", length));
			String[] agmtCurr = (JSPUtil.getParameter(request, prefix	+ "agmt_curr", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] tmlTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "tml_trns_mod_cd", length));
			String[] coaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] lgsCostDtlCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_dtl_cd", length));
			String[] tmlCrrCd = (JSPUtil.getParameter(request, prefix	+ "tml_crr_cd", length));
			String[] atbDt = (JSPUtil.getParameter(request, prefix	+ "atb_dt", length));
			String[] spCode = (JSPUtil.getParameter(request, prefix	+ "sp_code", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lgsCostSubjCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_subj_cd", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] calcType = (JSPUtil.getParameter(request, prefix	+ "calc_type", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] n3ptyFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_flg", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] rvisVolQty = (JSPUtil.getParameter(request, prefix	+ "rvis_vol_qty", length));
			String[] calcRmk = (JSPUtil.getParameter(request, prefix	+ "calc_rmk", length));
			String[] toPrdDt = (JSPUtil.getParameter(request, prefix	+ "to_prd_dt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] tmlInvStsCd = (JSPUtil.getParameter(request, prefix	+ "tml_inv_sts_cd", length));
			String[] tmlWrkDyCd = (JSPUtil.getParameter(request, prefix	+ "tml_wrk_dy_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesRowDataVO();
				if (spName[i] != null)
					model.setSpName(spName[i]);
				if (tier[i] != null)
					model.setTier(tier[i]);
				if (rvisVol[i] != null)
					model.setRvisVol(rvisVol[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (calcVol[i] != null)
					model.setCalcVol(calcVol[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (volTrUtCd[i] != null)
					model.setVolTrUtCd(volTrUtCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (usdRate[i] != null)
					model.setUsdRate(usdRate[i]);
				if (manualCheck[i] != null)
					model.setManualCheck(manualCheck[i]);
				if (fmPrdDt[i] != null)
					model.setFmPrdDt(fmPrdDt[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (calcVolQty[i] != null)
					model.setCalcVolQty(calcVolQty[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (invDateType[i] != null)
					model.setInvDateType(invDateType[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (dcgoIndCd[i] != null)
					model.setDcgoIndCd(dcgoIndCd[i]);
				if (invoiceStatus[i] != null)
					model.setInvoiceStatus(invoiceStatus[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (n1stNodCd[i] != null)
					model.setN1stNodCd(n1stNodCd[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (actVvdCd[i] != null)
					model.setActVvdCd(actVvdCd[i]);
				if (agmtCurr[i] != null)
					model.setAgmtCurr(agmtCurr[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (tmlTrnsModCd[i] != null)
					model.setTmlTrnsModCd(tmlTrnsModCd[i]);
				if (coaCostSrcCd[i] != null)
					model.setCoaCostSrcCd(coaCostSrcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (lgsCostDtlCd[i] != null)
					model.setLgsCostDtlCd(lgsCostDtlCd[i]);
				if (tmlCrrCd[i] != null)
					model.setTmlCrrCd(tmlCrrCd[i]);
				if (atbDt[i] != null)
					model.setAtbDt(atbDt[i]);
				if (spCode[i] != null)
					model.setSpCode(spCode[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lgsCostSubjCd[i] != null)
					model.setLgsCostSubjCd(lgsCostSubjCd[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (calcType[i] != null)
					model.setCalcType(calcType[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (n3ptyFlg[i] != null)
					model.setN3ptyFlg(n3ptyFlg[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (rvisVolQty[i] != null)
					model.setRvisVolQty(rvisVolQty[i]);
				if (calcRmk[i] != null)
					model.setCalcRmk(calcRmk[i]);
				if (toPrdDt[i] != null)
					model.setToPrdDt(toPrdDt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (tmlInvStsCd[i] != null)
					model.setTmlInvStsCd(tmlInvStsCd[i]);
				if (tmlWrkDyCd[i] != null)
					model.setTmlWrkDyCd(tmlWrkDyCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesRowDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesRowDataVO[]
	 */
	public TesRowDataVO[] getTesRowDataVOs(){
		TesRowDataVO[] vos = (TesRowDataVO[])models.toArray(new TesRowDataVO[models.size()]);
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
		this.spName = this.spName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tier = this.tier .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisVol = this.rvisVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcVol = this.calcVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTrUtCd = this.volTrUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdRate = this.usdRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manualCheck = this.manualCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrdDt = this.fmPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcVolQty = this.calcVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDateType = this.invDateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoIndCd = this.dcgoIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceStatus = this.invoiceStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodCd = this.n1stNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actVvdCd = this.actVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCurr = this.agmtCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlTrnsModCd = this.tmlTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCostSrcCd = this.coaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostDtlCd = this.lgsCostDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCrrCd = this.tmlCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atbDt = this.atbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCode = this.spCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostSubjCd = this.lgsCostSubjCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcType = this.calcType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyFlg = this.n3ptyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisVolQty = this.rvisVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcRmk = this.calcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrdDt = this.toPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvStsCd = this.tmlInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlWrkDyCd = this.tmlWrkDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
