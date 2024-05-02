/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesMarineStorageDetailCostByDayVO.java
*@FileTitle : TesMarineStorageDetailCostByDayVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo;

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

public class TesMarineStorageDetailCostByDayVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesMarineStorageDetailCostByDayVO> models = new ArrayList<TesMarineStorageDetailCostByDayVO>();
	
	/* Column Info */
	private String totQty = null;
	/* Column Info */
	private String tmlInvTpCd = null;
	/* Column Info */
	private String avgRt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String freeDyXcldDys = null;
	/* Column Info */
	private String volTrUtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String fmPrdDt = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String lgsCostFullNm = null;
	/* Column Info */
	private String estmTermTime = null;
	/* Column Info */
	private String totVol = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String calcAmt = null;
	/* Column Info */
	private String totTermTime = null;
	/* Column Info */
	private String dcgoIndFlg = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String exceedAvgFlg = null;
	/* Column Info */
	private String cntrVol = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String ovrDys = null;
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String estmVol = null;
	/* Column Info */
	private String tmlCalcIndCd = null;
	/* Column Info */
	private String expnAudSeq = null;
	/* Column Info */
	private String calcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String stayDys = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String ctrtRt = null;
	/* Column Info */
	private String calcRmk = null;
	/* Column Info */
	private String invCfmDt = null;
	/* Column Info */
	private String toPrdDt = null;
	/* Column Info */
	private String stoCntrSzNm = null;
	/* Column Info */
	private String estmAmt = null;
	/* Column Info */
	private String dscrCtnt = null;
	/* Column Info */
	private String estmQty = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String payDys = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String freeDys = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String stoDysIndCd = null;
	/* Column Info */
	private String eacFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesMarineStorageDetailCostByDayVO() {}

	public TesMarineStorageDetailCostByDayVO(String ibflag, String pagerows, String calcTpCd, String lgsCostCd, String lgsCostFullNm, String cntrTpszCd, String dcgoIndFlg, String cntrVol, String revYrmon, String stayDys, String freeDys, String payDys, String freeDyXcldDys, String ovrDys, String volTrUtCd, String ctrtRt, String currCd, String invXchRt, String invAmt, String calcAmt, String calcRmk, String ydCd, String ydNm, String invNo, String vndrSeq, String vndrNm, String tmlInvTpCd, String invCfmDt, String fmPrdDt, String toPrdDt, String invOfcCd, String stoCntrSzNm, String agmtNo, String agmtVerNo, String totVol, String totQty, String totAmt, String totTermTime, String avgRt, String estmVol, String estmQty, String estmTermTime, String estmAmt, String exceedAvgFlg, String dscrCtnt, String eacFlg, String expnAudSeq, String tmlCalcIndCd, String stoDysIndCd) {
		this.totQty = totQty;
		this.tmlInvTpCd = tmlInvTpCd;
		this.avgRt = avgRt;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.freeDyXcldDys = freeDyXcldDys;
		this.volTrUtCd = volTrUtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.fmPrdDt = fmPrdDt;
		this.invXchRt = invXchRt;
		this.lgsCostFullNm = lgsCostFullNm;
		this.estmTermTime = estmTermTime;
		this.totVol = totVol;
		this.revYrmon = revYrmon;
		this.agmtNo = agmtNo;
		this.calcAmt = calcAmt;
		this.totTermTime = totTermTime;
		this.dcgoIndFlg = dcgoIndFlg;
		this.vndrSeq = vndrSeq;
		this.ydNm = ydNm;
		this.exceedAvgFlg = exceedAvgFlg;
		this.cntrVol = cntrVol;
		this.agmtVerNo = agmtVerNo;
		this.ovrDys = ovrDys;
		this.totAmt = totAmt;
		this.currCd = currCd;
		this.estmVol = estmVol;
		this.tmlCalcIndCd = tmlCalcIndCd;
		this.expnAudSeq = expnAudSeq;
		this.calcTpCd = calcTpCd;
		this.ibflag = ibflag;
		this.stayDys = stayDys;
		this.invAmt = invAmt;
		this.invOfcCd = invOfcCd;
		this.ctrtRt = ctrtRt;
		this.calcRmk = calcRmk;
		this.invCfmDt = invCfmDt;
		this.toPrdDt = toPrdDt;
		this.stoCntrSzNm = stoCntrSzNm;
		this.estmAmt = estmAmt;
		this.dscrCtnt = dscrCtnt;
		this.estmQty = estmQty;
		this.invNo = invNo;
		this.payDys = payDys;
		this.ydCd = ydCd;
		this.freeDys = freeDys;
		this.lgsCostCd = lgsCostCd;
		this.stoDysIndCd = stoDysIndCd;
		this.eacFlg = eacFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tot_qty", getTotQty());
		this.hashColumns.put("tml_inv_tp_cd", getTmlInvTpCd());
		this.hashColumns.put("avg_rt", getAvgRt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("free_dy_xcld_dys", getFreeDyXcldDys());
		this.hashColumns.put("vol_tr_ut_cd", getVolTrUtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("fm_prd_dt", getFmPrdDt());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("lgs_cost_full_nm", getLgsCostFullNm());
		this.hashColumns.put("estm_term_time", getEstmTermTime());
		this.hashColumns.put("tot_vol", getTotVol());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("calc_amt", getCalcAmt());
		this.hashColumns.put("tot_term_time", getTotTermTime());
		this.hashColumns.put("dcgo_ind_flg", getDcgoIndFlg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("exceed_avg_flg", getExceedAvgFlg());
		this.hashColumns.put("cntr_vol", getCntrVol());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("ovr_dys", getOvrDys());
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("estm_vol", getEstmVol());
		this.hashColumns.put("tml_calc_ind_cd", getTmlCalcIndCd());
		this.hashColumns.put("expn_aud_seq", getExpnAudSeq());
		this.hashColumns.put("calc_tp_cd", getCalcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("stay_dys", getStayDys());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("ctrt_rt", getCtrtRt());
		this.hashColumns.put("calc_rmk", getCalcRmk());
		this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
		this.hashColumns.put("to_prd_dt", getToPrdDt());
		this.hashColumns.put("sto_cntr_sz_nm", getStoCntrSzNm());
		this.hashColumns.put("estm_amt", getEstmAmt());
		this.hashColumns.put("dscr_ctnt", getDscrCtnt());
		this.hashColumns.put("estm_qty", getEstmQty());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("pay_dys", getPayDys());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("free_dys", getFreeDys());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("sto_dys_ind_cd", getStoDysIndCd());
		this.hashColumns.put("eac_flg", getEacFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tot_qty", "totQty");
		this.hashFields.put("tml_inv_tp_cd", "tmlInvTpCd");
		this.hashFields.put("avg_rt", "avgRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("free_dy_xcld_dys", "freeDyXcldDys");
		this.hashFields.put("vol_tr_ut_cd", "volTrUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("fm_prd_dt", "fmPrdDt");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("lgs_cost_full_nm", "lgsCostFullNm");
		this.hashFields.put("estm_term_time", "estmTermTime");
		this.hashFields.put("tot_vol", "totVol");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("calc_amt", "calcAmt");
		this.hashFields.put("tot_term_time", "totTermTime");
		this.hashFields.put("dcgo_ind_flg", "dcgoIndFlg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("exceed_avg_flg", "exceedAvgFlg");
		this.hashFields.put("cntr_vol", "cntrVol");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("ovr_dys", "ovrDys");
		this.hashFields.put("tot_amt", "totAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("estm_vol", "estmVol");
		this.hashFields.put("tml_calc_ind_cd", "tmlCalcIndCd");
		this.hashFields.put("expn_aud_seq", "expnAudSeq");
		this.hashFields.put("calc_tp_cd", "calcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("stay_dys", "stayDys");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("ctrt_rt", "ctrtRt");
		this.hashFields.put("calc_rmk", "calcRmk");
		this.hashFields.put("inv_cfm_dt", "invCfmDt");
		this.hashFields.put("to_prd_dt", "toPrdDt");
		this.hashFields.put("sto_cntr_sz_nm", "stoCntrSzNm");
		this.hashFields.put("estm_amt", "estmAmt");
		this.hashFields.put("dscr_ctnt", "dscrCtnt");
		this.hashFields.put("estm_qty", "estmQty");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("pay_dys", "payDys");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("free_dys", "freeDys");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("sto_dys_ind_cd", "stoDysIndCd");
		this.hashFields.put("eac_flg", "eacFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return totQty
	 */
	public String getTotQty() {
		return this.totQty;
	}
	
	/**
	 * Column Info
	 * @return tmlInvTpCd
	 */
	public String getTmlInvTpCd() {
		return this.tmlInvTpCd;
	}
	
	/**
	 * Column Info
	 * @return avgRt
	 */
	public String getAvgRt() {
		return this.avgRt;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return freeDyXcldDys
	 */
	public String getFreeDyXcldDys() {
		return this.freeDyXcldDys;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return lgsCostFullNm
	 */
	public String getLgsCostFullNm() {
		return this.lgsCostFullNm;
	}
	
	/**
	 * Column Info
	 * @return estmTermTime
	 */
	public String getEstmTermTime() {
		return this.estmTermTime;
	}
	
	/**
	 * Column Info
	 * @return totVol
	 */
	public String getTotVol() {
		return this.totVol;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return calcAmt
	 */
	public String getCalcAmt() {
		return this.calcAmt;
	}
	
	/**
	 * Column Info
	 * @return totTermTime
	 */
	public String getTotTermTime() {
		return this.totTermTime;
	}
	
	/**
	 * Column Info
	 * @return dcgoIndFlg
	 */
	public String getDcgoIndFlg() {
		return this.dcgoIndFlg;
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
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return exceedAvgFlg
	 */
	public String getExceedAvgFlg() {
		return this.exceedAvgFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrVol
	 */
	public String getCntrVol() {
		return this.cntrVol;
	}
	
	/**
	 * Column Info
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @return ovrDys
	 */
	public String getOvrDys() {
		return this.ovrDys;
	}
	
	/**
	 * Column Info
	 * @return totAmt
	 */
	public String getTotAmt() {
		return this.totAmt;
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
	 * @return estmVol
	 */
	public String getEstmVol() {
		return this.estmVol;
	}
	
	/**
	 * Column Info
	 * @return tmlCalcIndCd
	 */
	public String getTmlCalcIndCd() {
		return this.tmlCalcIndCd;
	}
	
	/**
	 * Column Info
	 * @return expnAudSeq
	 */
	public String getExpnAudSeq() {
		return this.expnAudSeq;
	}
	
	/**
	 * Column Info
	 * @return calcTpCd
	 */
	public String getCalcTpCd() {
		return this.calcTpCd;
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
	 * @return ctrtRt
	 */
	public String getCtrtRt() {
		return this.ctrtRt;
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
	 * @return invCfmDt
	 */
	public String getInvCfmDt() {
		return this.invCfmDt;
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
	 * @return stoCntrSzNm
	 */
	public String getStoCntrSzNm() {
		return this.stoCntrSzNm;
	}
	
	/**
	 * Column Info
	 * @return estmAmt
	 */
	public String getEstmAmt() {
		return this.estmAmt;
	}
	
	/**
	 * Column Info
	 * @return dscrCtnt
	 */
	public String getDscrCtnt() {
		return this.dscrCtnt;
	}
	
	/**
	 * Column Info
	 * @return estmQty
	 */
	public String getEstmQty() {
		return this.estmQty;
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
	 * @return payDys
	 */
	public String getPayDys() {
		return this.payDys;
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
	 * @return freeDys
	 */
	public String getFreeDys() {
		return this.freeDys;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return stoDysIndCd
	 */
	public String getStoDysIndCd() {
		return this.stoDysIndCd;
	}
	
	/**
	 * Column Info
	 * @return eacFlg
	 */
	public String getEacFlg() {
		return this.eacFlg;
	}
	

	/**
	 * Column Info
	 * @param totQty
	 */
	public void setTotQty(String totQty) {
		this.totQty = totQty;
	}
	
	/**
	 * Column Info
	 * @param tmlInvTpCd
	 */
	public void setTmlInvTpCd(String tmlInvTpCd) {
		this.tmlInvTpCd = tmlInvTpCd;
	}
	
	/**
	 * Column Info
	 * @param avgRt
	 */
	public void setAvgRt(String avgRt) {
		this.avgRt = avgRt;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param freeDyXcldDys
	 */
	public void setFreeDyXcldDys(String freeDyXcldDys) {
		this.freeDyXcldDys = freeDyXcldDys;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param lgsCostFullNm
	 */
	public void setLgsCostFullNm(String lgsCostFullNm) {
		this.lgsCostFullNm = lgsCostFullNm;
	}
	
	/**
	 * Column Info
	 * @param estmTermTime
	 */
	public void setEstmTermTime(String estmTermTime) {
		this.estmTermTime = estmTermTime;
	}
	
	/**
	 * Column Info
	 * @param totVol
	 */
	public void setTotVol(String totVol) {
		this.totVol = totVol;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param calcAmt
	 */
	public void setCalcAmt(String calcAmt) {
		this.calcAmt = calcAmt;
	}
	
	/**
	 * Column Info
	 * @param totTermTime
	 */
	public void setTotTermTime(String totTermTime) {
		this.totTermTime = totTermTime;
	}
	
	/**
	 * Column Info
	 * @param dcgoIndFlg
	 */
	public void setDcgoIndFlg(String dcgoIndFlg) {
		this.dcgoIndFlg = dcgoIndFlg;
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
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param exceedAvgFlg
	 */
	public void setExceedAvgFlg(String exceedAvgFlg) {
		this.exceedAvgFlg = exceedAvgFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrVol
	 */
	public void setCntrVol(String cntrVol) {
		this.cntrVol = cntrVol;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @param ovrDys
	 */
	public void setOvrDys(String ovrDys) {
		this.ovrDys = ovrDys;
	}
	
	/**
	 * Column Info
	 * @param totAmt
	 */
	public void setTotAmt(String totAmt) {
		this.totAmt = totAmt;
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
	 * @param estmVol
	 */
	public void setEstmVol(String estmVol) {
		this.estmVol = estmVol;
	}
	
	/**
	 * Column Info
	 * @param tmlCalcIndCd
	 */
	public void setTmlCalcIndCd(String tmlCalcIndCd) {
		this.tmlCalcIndCd = tmlCalcIndCd;
	}
	
	/**
	 * Column Info
	 * @param expnAudSeq
	 */
	public void setExpnAudSeq(String expnAudSeq) {
		this.expnAudSeq = expnAudSeq;
	}
	
	/**
	 * Column Info
	 * @param calcTpCd
	 */
	public void setCalcTpCd(String calcTpCd) {
		this.calcTpCd = calcTpCd;
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
	 * @param ctrtRt
	 */
	public void setCtrtRt(String ctrtRt) {
		this.ctrtRt = ctrtRt;
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
	 * @param invCfmDt
	 */
	public void setInvCfmDt(String invCfmDt) {
		this.invCfmDt = invCfmDt;
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
	 * @param stoCntrSzNm
	 */
	public void setStoCntrSzNm(String stoCntrSzNm) {
		this.stoCntrSzNm = stoCntrSzNm;
	}
	
	/**
	 * Column Info
	 * @param estmAmt
	 */
	public void setEstmAmt(String estmAmt) {
		this.estmAmt = estmAmt;
	}
	
	/**
	 * Column Info
	 * @param dscrCtnt
	 */
	public void setDscrCtnt(String dscrCtnt) {
		this.dscrCtnt = dscrCtnt;
	}
	
	/**
	 * Column Info
	 * @param estmQty
	 */
	public void setEstmQty(String estmQty) {
		this.estmQty = estmQty;
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
	 * @param payDys
	 */
	public void setPayDys(String payDys) {
		this.payDys = payDys;
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
	 * @param freeDys
	 */
	public void setFreeDys(String freeDys) {
		this.freeDys = freeDys;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param stoDysIndCd
	 */
	public void setStoDysIndCd(String stoDysIndCd) {
		this.stoDysIndCd = stoDysIndCd;
	}
	
	/**
	 * Column Info
	 * @param eacFlg
	 */
	public void setEacFlg(String eacFlg) {
		this.eacFlg = eacFlg;
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
		setTotQty(JSPUtil.getParameter(request, prefix + "tot_qty", ""));
		setTmlInvTpCd(JSPUtil.getParameter(request, prefix + "tml_inv_tp_cd", ""));
		setAvgRt(JSPUtil.getParameter(request, prefix + "avg_rt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setFreeDyXcldDys(JSPUtil.getParameter(request, prefix + "free_dy_xcld_dys", ""));
		setVolTrUtCd(JSPUtil.getParameter(request, prefix + "vol_tr_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setFmPrdDt(JSPUtil.getParameter(request, prefix + "fm_prd_dt", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setLgsCostFullNm(JSPUtil.getParameter(request, prefix + "lgs_cost_full_nm", ""));
		setEstmTermTime(JSPUtil.getParameter(request, prefix + "estm_term_time", ""));
		setTotVol(JSPUtil.getParameter(request, prefix + "tot_vol", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setCalcAmt(JSPUtil.getParameter(request, prefix + "calc_amt", ""));
		setTotTermTime(JSPUtil.getParameter(request, prefix + "tot_term_time", ""));
		setDcgoIndFlg(JSPUtil.getParameter(request, prefix + "dcgo_ind_flg", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setExceedAvgFlg(JSPUtil.getParameter(request, prefix + "exceed_avg_flg", ""));
		setCntrVol(JSPUtil.getParameter(request, prefix + "cntr_vol", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, prefix + "agmt_ver_no", ""));
		setOvrDys(JSPUtil.getParameter(request, prefix + "ovr_dys", ""));
		setTotAmt(JSPUtil.getParameter(request, prefix + "tot_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setEstmVol(JSPUtil.getParameter(request, prefix + "estm_vol", ""));
		setTmlCalcIndCd(JSPUtil.getParameter(request, prefix + "tml_calc_ind_cd", ""));
		setExpnAudSeq(JSPUtil.getParameter(request, prefix + "expn_aud_seq", ""));
		setCalcTpCd(JSPUtil.getParameter(request, prefix + "calc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setStayDys(JSPUtil.getParameter(request, prefix + "stay_dys", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setCtrtRt(JSPUtil.getParameter(request, prefix + "ctrt_rt", ""));
		setCalcRmk(JSPUtil.getParameter(request, prefix + "calc_rmk", ""));
		setInvCfmDt(JSPUtil.getParameter(request, prefix + "inv_cfm_dt", ""));
		setToPrdDt(JSPUtil.getParameter(request, prefix + "to_prd_dt", ""));
		setStoCntrSzNm(JSPUtil.getParameter(request, prefix + "sto_cntr_sz_nm", ""));
		setEstmAmt(JSPUtil.getParameter(request, prefix + "estm_amt", ""));
		setDscrCtnt(JSPUtil.getParameter(request, prefix + "dscr_ctnt", ""));
		setEstmQty(JSPUtil.getParameter(request, prefix + "estm_qty", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setPayDys(JSPUtil.getParameter(request, prefix + "pay_dys", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setFreeDys(JSPUtil.getParameter(request, prefix + "free_dys", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setStoDysIndCd(JSPUtil.getParameter(request, prefix + "sto_dys_ind_cd", ""));
		setEacFlg(JSPUtil.getParameter(request, prefix + "eac_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesMarineStorageDetailCostByDayVO[]
	 */
	public TesMarineStorageDetailCostByDayVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesMarineStorageDetailCostByDayVO[]
	 */
	public TesMarineStorageDetailCostByDayVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesMarineStorageDetailCostByDayVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totQty = (JSPUtil.getParameter(request, prefix	+ "tot_qty", length));
			String[] tmlInvTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_inv_tp_cd", length));
			String[] avgRt = (JSPUtil.getParameter(request, prefix	+ "avg_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] freeDyXcldDys = (JSPUtil.getParameter(request, prefix	+ "free_dy_xcld_dys", length));
			String[] volTrUtCd = (JSPUtil.getParameter(request, prefix	+ "vol_tr_ut_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] fmPrdDt = (JSPUtil.getParameter(request, prefix	+ "fm_prd_dt", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] lgsCostFullNm = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_full_nm", length));
			String[] estmTermTime = (JSPUtil.getParameter(request, prefix	+ "estm_term_time", length));
			String[] totVol = (JSPUtil.getParameter(request, prefix	+ "tot_vol", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] calcAmt = (JSPUtil.getParameter(request, prefix	+ "calc_amt", length));
			String[] totTermTime = (JSPUtil.getParameter(request, prefix	+ "tot_term_time", length));
			String[] dcgoIndFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_ind_flg", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] exceedAvgFlg = (JSPUtil.getParameter(request, prefix	+ "exceed_avg_flg", length));
			String[] cntrVol = (JSPUtil.getParameter(request, prefix	+ "cntr_vol", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] ovrDys = (JSPUtil.getParameter(request, prefix	+ "ovr_dys", length));
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] estmVol = (JSPUtil.getParameter(request, prefix	+ "estm_vol", length));
			String[] tmlCalcIndCd = (JSPUtil.getParameter(request, prefix	+ "tml_calc_ind_cd", length));
			String[] expnAudSeq = (JSPUtil.getParameter(request, prefix	+ "expn_aud_seq", length));
			String[] calcTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] stayDys = (JSPUtil.getParameter(request, prefix	+ "stay_dys", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] ctrtRt = (JSPUtil.getParameter(request, prefix	+ "ctrt_rt", length));
			String[] calcRmk = (JSPUtil.getParameter(request, prefix	+ "calc_rmk", length));
			String[] invCfmDt = (JSPUtil.getParameter(request, prefix	+ "inv_cfm_dt", length));
			String[] toPrdDt = (JSPUtil.getParameter(request, prefix	+ "to_prd_dt", length));
			String[] stoCntrSzNm = (JSPUtil.getParameter(request, prefix	+ "sto_cntr_sz_nm", length));
			String[] estmAmt = (JSPUtil.getParameter(request, prefix	+ "estm_amt", length));
			String[] dscrCtnt = (JSPUtil.getParameter(request, prefix	+ "dscr_ctnt", length));
			String[] estmQty = (JSPUtil.getParameter(request, prefix	+ "estm_qty", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] payDys = (JSPUtil.getParameter(request, prefix	+ "pay_dys", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] freeDys = (JSPUtil.getParameter(request, prefix	+ "free_dys", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] stoDysIndCd = (JSPUtil.getParameter(request, prefix	+ "sto_dys_ind_cd", length));
			String[] eacFlg = (JSPUtil.getParameter(request, prefix	+ "eac_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesMarineStorageDetailCostByDayVO();
				if (totQty[i] != null)
					model.setTotQty(totQty[i]);
				if (tmlInvTpCd[i] != null)
					model.setTmlInvTpCd(tmlInvTpCd[i]);
				if (avgRt[i] != null)
					model.setAvgRt(avgRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (freeDyXcldDys[i] != null)
					model.setFreeDyXcldDys(freeDyXcldDys[i]);
				if (volTrUtCd[i] != null)
					model.setVolTrUtCd(volTrUtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (fmPrdDt[i] != null)
					model.setFmPrdDt(fmPrdDt[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (lgsCostFullNm[i] != null)
					model.setLgsCostFullNm(lgsCostFullNm[i]);
				if (estmTermTime[i] != null)
					model.setEstmTermTime(estmTermTime[i]);
				if (totVol[i] != null)
					model.setTotVol(totVol[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (calcAmt[i] != null)
					model.setCalcAmt(calcAmt[i]);
				if (totTermTime[i] != null)
					model.setTotTermTime(totTermTime[i]);
				if (dcgoIndFlg[i] != null)
					model.setDcgoIndFlg(dcgoIndFlg[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (exceedAvgFlg[i] != null)
					model.setExceedAvgFlg(exceedAvgFlg[i]);
				if (cntrVol[i] != null)
					model.setCntrVol(cntrVol[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (ovrDys[i] != null)
					model.setOvrDys(ovrDys[i]);
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (estmVol[i] != null)
					model.setEstmVol(estmVol[i]);
				if (tmlCalcIndCd[i] != null)
					model.setTmlCalcIndCd(tmlCalcIndCd[i]);
				if (expnAudSeq[i] != null)
					model.setExpnAudSeq(expnAudSeq[i]);
				if (calcTpCd[i] != null)
					model.setCalcTpCd(calcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (stayDys[i] != null)
					model.setStayDys(stayDys[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (ctrtRt[i] != null)
					model.setCtrtRt(ctrtRt[i]);
				if (calcRmk[i] != null)
					model.setCalcRmk(calcRmk[i]);
				if (invCfmDt[i] != null)
					model.setInvCfmDt(invCfmDt[i]);
				if (toPrdDt[i] != null)
					model.setToPrdDt(toPrdDt[i]);
				if (stoCntrSzNm[i] != null)
					model.setStoCntrSzNm(stoCntrSzNm[i]);
				if (estmAmt[i] != null)
					model.setEstmAmt(estmAmt[i]);
				if (dscrCtnt[i] != null)
					model.setDscrCtnt(dscrCtnt[i]);
				if (estmQty[i] != null)
					model.setEstmQty(estmQty[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (payDys[i] != null)
					model.setPayDys(payDys[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (freeDys[i] != null)
					model.setFreeDys(freeDys[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (stoDysIndCd[i] != null)
					model.setStoDysIndCd(stoDysIndCd[i]);
				if (eacFlg[i] != null)
					model.setEacFlg(eacFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesMarineStorageDetailCostByDayVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesMarineStorageDetailCostByDayVO[]
	 */
	public TesMarineStorageDetailCostByDayVO[] getTesMarineStorageDetailCostByDayVOs(){
		TesMarineStorageDetailCostByDayVO[] vos = (TesMarineStorageDetailCostByDayVO[])models.toArray(new TesMarineStorageDetailCostByDayVO[models.size()]);
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
		this.totQty = this.totQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvTpCd = this.tmlInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgRt = this.avgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDyXcldDys = this.freeDyXcldDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTrUtCd = this.volTrUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrdDt = this.fmPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostFullNm = this.lgsCostFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmTermTime = this.estmTermTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totVol = this.totVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcAmt = this.calcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTermTime = this.totTermTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoIndFlg = this.dcgoIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exceedAvgFlg = this.exceedAvgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVol = this.cntrVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDys = this.ovrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmt = this.totAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVol = this.estmVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCalcIndCd = this.tmlCalcIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnAudSeq = this.expnAudSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpCd = this.calcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDys = this.stayDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRt = this.ctrtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcRmk = this.calcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCfmDt = this.invCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrdDt = this.toPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoCntrSzNm = this.stoCntrSzNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmAmt = this.estmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscrCtnt = this.dscrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmQty = this.estmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDys = this.payDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDys = this.freeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoDysIndCd = this.stoDysIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacFlg = this.eacFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
