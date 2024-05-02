/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesMarineStorageDetailCostByPoolVO.java
*@FileTitle : TesMarineStorageDetailCostByPoolVO
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

public class TesMarineStorageDetailCostByPoolVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesMarineStorageDetailCostByPoolVO> models = new ArrayList<TesMarineStorageDetailCostByPoolVO>();
	
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String estmVol = null;
	/* Column Info */
	private String stkVolQty = null;
	/* Column Info */
	private String avgRt = null;
	/* Column Info */
	private String calcCostGrpCd = null;
	/* Column Info */
	private String tmlInvTpCd = null;
	/* Column Info */
	private String tmlCalcIndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String expnAudSeq = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String tmlAgmtVerNo = null;
	/* Column Info */
	private String calcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fpCalcPrdCd = null;
	/* Column Info */
	private String volTrUtCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String fmPrdDt = null;
	/* Column Info */
	private String lgsCostFullNm = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String ovrVolQty = null;
	/* Column Info */
	private String totVol = null;
	/* Column Info */
	private String tmlAgmtOfcCtyCd = null;
	/* Column Info */
	private String ctrtRt = null;
	/* Column Info */
	private String invCfmDt = null;
	/* Column Info */
	private String calcRmk = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String estmAmt = null;
	/* Column Info */
	private String toPrdDt = null;
	/* Column Info */
	private String diffVolQty = null;
	/* Column Info */
	private String calcAmt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String fpTeuQty = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String tmlAgmtSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String prdYm = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String exceedAvgFlg = null;
	/* Column Info */
	private String stoDysIndCd = null;
	/* Column Info */
	private String invVolQty = null;
	/* Column Info */
	private String eacFlg = null;
	/* Column Info */
	private String agmtVerNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesMarineStorageDetailCostByPoolVO() {}

	public TesMarineStorageDetailCostByPoolVO(String ibflag, String pagerows, String calcTpCd, String lgsCostCd, String lgsCostFullNm, String fpCalcPrdCd, String prdYm, String stkVolQty, String invVolQty, String diffVolQty, String fpTeuQty, String ovrVolQty, String volTrUtCd, String ctrtRt, String currCd, String invXchRt, String invAmt, String calcAmt, String calcRmk, String invOfcCd, String invNo, String ydCd, String vndrSeq, String ydNm, String vndrNm, String invCfmDt, String fmPrdDt, String toPrdDt, String tmlInvTpCd, String tmlCalcIndCd, String stoDysIndCd, String calcCostGrpCd, String tmlAgmtOfcCtyCd, String tmlAgmtSeq, String tmlAgmtVerNo, String agmtNo, String agmtVerNo, String totVol, String totAmt, String avgRt, String estmVol, String estmAmt, String exceedAvgFlg, String eacFlg, String expnAudSeq) {
		this.totAmt = totAmt;
		this.currCd = currCd;
		this.estmVol = estmVol;
		this.stkVolQty = stkVolQty;
		this.avgRt = avgRt;
		this.calcCostGrpCd = calcCostGrpCd;
		this.tmlInvTpCd = tmlInvTpCd;
		this.tmlCalcIndCd = tmlCalcIndCd;
		this.pagerows = pagerows;
		this.expnAudSeq = expnAudSeq;
		this.vndrNm = vndrNm;
		this.tmlAgmtVerNo = tmlAgmtVerNo;
		this.calcTpCd = calcTpCd;
		this.ibflag = ibflag;
		this.fpCalcPrdCd = fpCalcPrdCd;
		this.volTrUtCd = volTrUtCd;
		this.invAmt = invAmt;
		this.fmPrdDt = fmPrdDt;
		this.lgsCostFullNm = lgsCostFullNm;
		this.invXchRt = invXchRt;
		this.invOfcCd = invOfcCd;
		this.ovrVolQty = ovrVolQty;
		this.totVol = totVol;
		this.tmlAgmtOfcCtyCd = tmlAgmtOfcCtyCd;
		this.ctrtRt = ctrtRt;
		this.invCfmDt = invCfmDt;
		this.calcRmk = calcRmk;
		this.agmtNo = agmtNo;
		this.estmAmt = estmAmt;
		this.toPrdDt = toPrdDt;
		this.diffVolQty = diffVolQty;
		this.calcAmt = calcAmt;
		this.invNo = invNo;
		this.fpTeuQty = fpTeuQty;
		this.ydCd = ydCd;
		this.tmlAgmtSeq = tmlAgmtSeq;
		this.vndrSeq = vndrSeq;
		this.prdYm = prdYm;
		this.lgsCostCd = lgsCostCd;
		this.ydNm = ydNm;
		this.exceedAvgFlg = exceedAvgFlg;
		this.stoDysIndCd = stoDysIndCd;
		this.invVolQty = invVolQty;
		this.eacFlg = eacFlg;
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("estm_vol", getEstmVol());
		this.hashColumns.put("stk_vol_qty", getStkVolQty());
		this.hashColumns.put("avg_rt", getAvgRt());
		this.hashColumns.put("calc_cost_grp_cd", getCalcCostGrpCd());
		this.hashColumns.put("tml_inv_tp_cd", getTmlInvTpCd());
		this.hashColumns.put("tml_calc_ind_cd", getTmlCalcIndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("expn_aud_seq", getExpnAudSeq());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("tml_agmt_ver_no", getTmlAgmtVerNo());
		this.hashColumns.put("calc_tp_cd", getCalcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fp_calc_prd_cd", getFpCalcPrdCd());
		this.hashColumns.put("vol_tr_ut_cd", getVolTrUtCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("fm_prd_dt", getFmPrdDt());
		this.hashColumns.put("lgs_cost_full_nm", getLgsCostFullNm());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("ovr_vol_qty", getOvrVolQty());
		this.hashColumns.put("tot_vol", getTotVol());
		this.hashColumns.put("tml_agmt_ofc_cty_cd", getTmlAgmtOfcCtyCd());
		this.hashColumns.put("ctrt_rt", getCtrtRt());
		this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
		this.hashColumns.put("calc_rmk", getCalcRmk());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("estm_amt", getEstmAmt());
		this.hashColumns.put("to_prd_dt", getToPrdDt());
		this.hashColumns.put("diff_vol_qty", getDiffVolQty());
		this.hashColumns.put("calc_amt", getCalcAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("fp_teu_qty", getFpTeuQty());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("tml_agmt_seq", getTmlAgmtSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("prd_ym", getPrdYm());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("exceed_avg_flg", getExceedAvgFlg());
		this.hashColumns.put("sto_dys_ind_cd", getStoDysIndCd());
		this.hashColumns.put("inv_vol_qty", getInvVolQty());
		this.hashColumns.put("eac_flg", getEacFlg());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tot_amt", "totAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("estm_vol", "estmVol");
		this.hashFields.put("stk_vol_qty", "stkVolQty");
		this.hashFields.put("avg_rt", "avgRt");
		this.hashFields.put("calc_cost_grp_cd", "calcCostGrpCd");
		this.hashFields.put("tml_inv_tp_cd", "tmlInvTpCd");
		this.hashFields.put("tml_calc_ind_cd", "tmlCalcIndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("expn_aud_seq", "expnAudSeq");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("tml_agmt_ver_no", "tmlAgmtVerNo");
		this.hashFields.put("calc_tp_cd", "calcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fp_calc_prd_cd", "fpCalcPrdCd");
		this.hashFields.put("vol_tr_ut_cd", "volTrUtCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("fm_prd_dt", "fmPrdDt");
		this.hashFields.put("lgs_cost_full_nm", "lgsCostFullNm");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("ovr_vol_qty", "ovrVolQty");
		this.hashFields.put("tot_vol", "totVol");
		this.hashFields.put("tml_agmt_ofc_cty_cd", "tmlAgmtOfcCtyCd");
		this.hashFields.put("ctrt_rt", "ctrtRt");
		this.hashFields.put("inv_cfm_dt", "invCfmDt");
		this.hashFields.put("calc_rmk", "calcRmk");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("estm_amt", "estmAmt");
		this.hashFields.put("to_prd_dt", "toPrdDt");
		this.hashFields.put("diff_vol_qty", "diffVolQty");
		this.hashFields.put("calc_amt", "calcAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("fp_teu_qty", "fpTeuQty");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("tml_agmt_seq", "tmlAgmtSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("prd_ym", "prdYm");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("exceed_avg_flg", "exceedAvgFlg");
		this.hashFields.put("sto_dys_ind_cd", "stoDysIndCd");
		this.hashFields.put("inv_vol_qty", "invVolQty");
		this.hashFields.put("eac_flg", "eacFlg");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		return this.hashFields;
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
	 * @return stkVolQty
	 */
	public String getStkVolQty() {
		return this.stkVolQty;
	}
	
	/**
	 * Column Info
	 * @return avgRt
	 */
	public String getAvgRt() {
		return this.avgRt;
	}
	
	/**
	 * Column Info
	 * @return calcCostGrpCd
	 */
	public String getCalcCostGrpCd() {
		return this.calcCostGrpCd;
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
	 * @return tmlCalcIndCd
	 */
	public String getTmlCalcIndCd() {
		return this.tmlCalcIndCd;
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
	 * @return expnAudSeq
	 */
	public String getExpnAudSeq() {
		return this.expnAudSeq;
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
	 * @return tmlAgmtVerNo
	 */
	public String getTmlAgmtVerNo() {
		return this.tmlAgmtVerNo;
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
	 * @return fpCalcPrdCd
	 */
	public String getFpCalcPrdCd() {
		return this.fpCalcPrdCd;
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
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
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
	 * @return lgsCostFullNm
	 */
	public String getLgsCostFullNm() {
		return this.lgsCostFullNm;
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
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ovrVolQty
	 */
	public String getOvrVolQty() {
		return this.ovrVolQty;
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
	 * @return tmlAgmtOfcCtyCd
	 */
	public String getTmlAgmtOfcCtyCd() {
		return this.tmlAgmtOfcCtyCd;
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
	 * @return invCfmDt
	 */
	public String getInvCfmDt() {
		return this.invCfmDt;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
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
	 * @return toPrdDt
	 */
	public String getToPrdDt() {
		return this.toPrdDt;
	}
	
	/**
	 * Column Info
	 * @return diffVolQty
	 */
	public String getDiffVolQty() {
		return this.diffVolQty;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return fpTeuQty
	 */
	public String getFpTeuQty() {
		return this.fpTeuQty;
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
	 * @return tmlAgmtSeq
	 */
	public String getTmlAgmtSeq() {
		return this.tmlAgmtSeq;
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
	 * @return prdYm
	 */
	public String getPrdYm() {
		return this.prdYm;
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
	 * @return stoDysIndCd
	 */
	public String getStoDysIndCd() {
		return this.stoDysIndCd;
	}
	
	/**
	 * Column Info
	 * @return invVolQty
	 */
	public String getInvVolQty() {
		return this.invVolQty;
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
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
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
	 * @param stkVolQty
	 */
	public void setStkVolQty(String stkVolQty) {
		this.stkVolQty = stkVolQty;
	}
	
	/**
	 * Column Info
	 * @param avgRt
	 */
	public void setAvgRt(String avgRt) {
		this.avgRt = avgRt;
	}
	
	/**
	 * Column Info
	 * @param calcCostGrpCd
	 */
	public void setCalcCostGrpCd(String calcCostGrpCd) {
		this.calcCostGrpCd = calcCostGrpCd;
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
	 * @param tmlCalcIndCd
	 */
	public void setTmlCalcIndCd(String tmlCalcIndCd) {
		this.tmlCalcIndCd = tmlCalcIndCd;
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
	 * @param expnAudSeq
	 */
	public void setExpnAudSeq(String expnAudSeq) {
		this.expnAudSeq = expnAudSeq;
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
	 * @param tmlAgmtVerNo
	 */
	public void setTmlAgmtVerNo(String tmlAgmtVerNo) {
		this.tmlAgmtVerNo = tmlAgmtVerNo;
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
	 * @param fpCalcPrdCd
	 */
	public void setFpCalcPrdCd(String fpCalcPrdCd) {
		this.fpCalcPrdCd = fpCalcPrdCd;
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
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
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
	 * @param lgsCostFullNm
	 */
	public void setLgsCostFullNm(String lgsCostFullNm) {
		this.lgsCostFullNm = lgsCostFullNm;
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
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ovrVolQty
	 */
	public void setOvrVolQty(String ovrVolQty) {
		this.ovrVolQty = ovrVolQty;
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
	 * @param tmlAgmtOfcCtyCd
	 */
	public void setTmlAgmtOfcCtyCd(String tmlAgmtOfcCtyCd) {
		this.tmlAgmtOfcCtyCd = tmlAgmtOfcCtyCd;
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
	 * @param invCfmDt
	 */
	public void setInvCfmDt(String invCfmDt) {
		this.invCfmDt = invCfmDt;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
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
	 * @param toPrdDt
	 */
	public void setToPrdDt(String toPrdDt) {
		this.toPrdDt = toPrdDt;
	}
	
	/**
	 * Column Info
	 * @param diffVolQty
	 */
	public void setDiffVolQty(String diffVolQty) {
		this.diffVolQty = diffVolQty;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param fpTeuQty
	 */
	public void setFpTeuQty(String fpTeuQty) {
		this.fpTeuQty = fpTeuQty;
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
	 * @param tmlAgmtSeq
	 */
	public void setTmlAgmtSeq(String tmlAgmtSeq) {
		this.tmlAgmtSeq = tmlAgmtSeq;
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
	 * @param prdYm
	 */
	public void setPrdYm(String prdYm) {
		this.prdYm = prdYm;
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
	 * @param stoDysIndCd
	 */
	public void setStoDysIndCd(String stoDysIndCd) {
		this.stoDysIndCd = stoDysIndCd;
	}
	
	/**
	 * Column Info
	 * @param invVolQty
	 */
	public void setInvVolQty(String invVolQty) {
		this.invVolQty = invVolQty;
	}
	
	/**
	 * Column Info
	 * @param eacFlg
	 */
	public void setEacFlg(String eacFlg) {
		this.eacFlg = eacFlg;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
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
		setTotAmt(JSPUtil.getParameter(request, prefix + "tot_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setEstmVol(JSPUtil.getParameter(request, prefix + "estm_vol", ""));
		setStkVolQty(JSPUtil.getParameter(request, prefix + "stk_vol_qty", ""));
		setAvgRt(JSPUtil.getParameter(request, prefix + "avg_rt", ""));
		setCalcCostGrpCd(JSPUtil.getParameter(request, prefix + "calc_cost_grp_cd", ""));
		setTmlInvTpCd(JSPUtil.getParameter(request, prefix + "tml_inv_tp_cd", ""));
		setTmlCalcIndCd(JSPUtil.getParameter(request, prefix + "tml_calc_ind_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setExpnAudSeq(JSPUtil.getParameter(request, prefix + "expn_aud_seq", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setTmlAgmtVerNo(JSPUtil.getParameter(request, prefix + "tml_agmt_ver_no", ""));
		setCalcTpCd(JSPUtil.getParameter(request, prefix + "calc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFpCalcPrdCd(JSPUtil.getParameter(request, prefix + "fp_calc_prd_cd", ""));
		setVolTrUtCd(JSPUtil.getParameter(request, prefix + "vol_tr_ut_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setFmPrdDt(JSPUtil.getParameter(request, prefix + "fm_prd_dt", ""));
		setLgsCostFullNm(JSPUtil.getParameter(request, prefix + "lgs_cost_full_nm", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setOvrVolQty(JSPUtil.getParameter(request, prefix + "ovr_vol_qty", ""));
		setTotVol(JSPUtil.getParameter(request, prefix + "tot_vol", ""));
		setTmlAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "tml_agmt_ofc_cty_cd", ""));
		setCtrtRt(JSPUtil.getParameter(request, prefix + "ctrt_rt", ""));
		setInvCfmDt(JSPUtil.getParameter(request, prefix + "inv_cfm_dt", ""));
		setCalcRmk(JSPUtil.getParameter(request, prefix + "calc_rmk", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setEstmAmt(JSPUtil.getParameter(request, prefix + "estm_amt", ""));
		setToPrdDt(JSPUtil.getParameter(request, prefix + "to_prd_dt", ""));
		setDiffVolQty(JSPUtil.getParameter(request, prefix + "diff_vol_qty", ""));
		setCalcAmt(JSPUtil.getParameter(request, prefix + "calc_amt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setFpTeuQty(JSPUtil.getParameter(request, prefix + "fp_teu_qty", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setTmlAgmtSeq(JSPUtil.getParameter(request, prefix + "tml_agmt_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setPrdYm(JSPUtil.getParameter(request, prefix + "prd_ym", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setExceedAvgFlg(JSPUtil.getParameter(request, prefix + "exceed_avg_flg", ""));
		setStoDysIndCd(JSPUtil.getParameter(request, prefix + "sto_dys_ind_cd", ""));
		setInvVolQty(JSPUtil.getParameter(request, prefix + "inv_vol_qty", ""));
		setEacFlg(JSPUtil.getParameter(request, prefix + "eac_flg", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, prefix + "agmt_ver_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesMarineStorageDetailCostByPoolVO[]
	 */
	public TesMarineStorageDetailCostByPoolVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesMarineStorageDetailCostByPoolVO[]
	 */
	public TesMarineStorageDetailCostByPoolVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesMarineStorageDetailCostByPoolVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] estmVol = (JSPUtil.getParameter(request, prefix	+ "estm_vol", length));
			String[] stkVolQty = (JSPUtil.getParameter(request, prefix	+ "stk_vol_qty", length));
			String[] avgRt = (JSPUtil.getParameter(request, prefix	+ "avg_rt", length));
			String[] calcCostGrpCd = (JSPUtil.getParameter(request, prefix	+ "calc_cost_grp_cd", length));
			String[] tmlInvTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_inv_tp_cd", length));
			String[] tmlCalcIndCd = (JSPUtil.getParameter(request, prefix	+ "tml_calc_ind_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] expnAudSeq = (JSPUtil.getParameter(request, prefix	+ "expn_aud_seq", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] tmlAgmtVerNo = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_ver_no", length));
			String[] calcTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fpCalcPrdCd = (JSPUtil.getParameter(request, prefix	+ "fp_calc_prd_cd", length));
			String[] volTrUtCd = (JSPUtil.getParameter(request, prefix	+ "vol_tr_ut_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] fmPrdDt = (JSPUtil.getParameter(request, prefix	+ "fm_prd_dt", length));
			String[] lgsCostFullNm = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_full_nm", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] ovrVolQty = (JSPUtil.getParameter(request, prefix	+ "ovr_vol_qty", length));
			String[] totVol = (JSPUtil.getParameter(request, prefix	+ "tot_vol", length));
			String[] tmlAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_ofc_cty_cd", length));
			String[] ctrtRt = (JSPUtil.getParameter(request, prefix	+ "ctrt_rt", length));
			String[] invCfmDt = (JSPUtil.getParameter(request, prefix	+ "inv_cfm_dt", length));
			String[] calcRmk = (JSPUtil.getParameter(request, prefix	+ "calc_rmk", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] estmAmt = (JSPUtil.getParameter(request, prefix	+ "estm_amt", length));
			String[] toPrdDt = (JSPUtil.getParameter(request, prefix	+ "to_prd_dt", length));
			String[] diffVolQty = (JSPUtil.getParameter(request, prefix	+ "diff_vol_qty", length));
			String[] calcAmt = (JSPUtil.getParameter(request, prefix	+ "calc_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] fpTeuQty = (JSPUtil.getParameter(request, prefix	+ "fp_teu_qty", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] tmlAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] prdYm = (JSPUtil.getParameter(request, prefix	+ "prd_ym", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] exceedAvgFlg = (JSPUtil.getParameter(request, prefix	+ "exceed_avg_flg", length));
			String[] stoDysIndCd = (JSPUtil.getParameter(request, prefix	+ "sto_dys_ind_cd", length));
			String[] invVolQty = (JSPUtil.getParameter(request, prefix	+ "inv_vol_qty", length));
			String[] eacFlg = (JSPUtil.getParameter(request, prefix	+ "eac_flg", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesMarineStorageDetailCostByPoolVO();
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (estmVol[i] != null)
					model.setEstmVol(estmVol[i]);
				if (stkVolQty[i] != null)
					model.setStkVolQty(stkVolQty[i]);
				if (avgRt[i] != null)
					model.setAvgRt(avgRt[i]);
				if (calcCostGrpCd[i] != null)
					model.setCalcCostGrpCd(calcCostGrpCd[i]);
				if (tmlInvTpCd[i] != null)
					model.setTmlInvTpCd(tmlInvTpCd[i]);
				if (tmlCalcIndCd[i] != null)
					model.setTmlCalcIndCd(tmlCalcIndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (expnAudSeq[i] != null)
					model.setExpnAudSeq(expnAudSeq[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (tmlAgmtVerNo[i] != null)
					model.setTmlAgmtVerNo(tmlAgmtVerNo[i]);
				if (calcTpCd[i] != null)
					model.setCalcTpCd(calcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fpCalcPrdCd[i] != null)
					model.setFpCalcPrdCd(fpCalcPrdCd[i]);
				if (volTrUtCd[i] != null)
					model.setVolTrUtCd(volTrUtCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (fmPrdDt[i] != null)
					model.setFmPrdDt(fmPrdDt[i]);
				if (lgsCostFullNm[i] != null)
					model.setLgsCostFullNm(lgsCostFullNm[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (ovrVolQty[i] != null)
					model.setOvrVolQty(ovrVolQty[i]);
				if (totVol[i] != null)
					model.setTotVol(totVol[i]);
				if (tmlAgmtOfcCtyCd[i] != null)
					model.setTmlAgmtOfcCtyCd(tmlAgmtOfcCtyCd[i]);
				if (ctrtRt[i] != null)
					model.setCtrtRt(ctrtRt[i]);
				if (invCfmDt[i] != null)
					model.setInvCfmDt(invCfmDt[i]);
				if (calcRmk[i] != null)
					model.setCalcRmk(calcRmk[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (estmAmt[i] != null)
					model.setEstmAmt(estmAmt[i]);
				if (toPrdDt[i] != null)
					model.setToPrdDt(toPrdDt[i]);
				if (diffVolQty[i] != null)
					model.setDiffVolQty(diffVolQty[i]);
				if (calcAmt[i] != null)
					model.setCalcAmt(calcAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (fpTeuQty[i] != null)
					model.setFpTeuQty(fpTeuQty[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (tmlAgmtSeq[i] != null)
					model.setTmlAgmtSeq(tmlAgmtSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (prdYm[i] != null)
					model.setPrdYm(prdYm[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (exceedAvgFlg[i] != null)
					model.setExceedAvgFlg(exceedAvgFlg[i]);
				if (stoDysIndCd[i] != null)
					model.setStoDysIndCd(stoDysIndCd[i]);
				if (invVolQty[i] != null)
					model.setInvVolQty(invVolQty[i]);
				if (eacFlg[i] != null)
					model.setEacFlg(eacFlg[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesMarineStorageDetailCostByPoolVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesMarineStorageDetailCostByPoolVO[]
	 */
	public TesMarineStorageDetailCostByPoolVO[] getTesMarineStorageDetailCostByPoolVOs(){
		TesMarineStorageDetailCostByPoolVO[] vos = (TesMarineStorageDetailCostByPoolVO[])models.toArray(new TesMarineStorageDetailCostByPoolVO[models.size()]);
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
		this.totAmt = this.totAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVol = this.estmVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkVolQty = this.stkVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgRt = this.avgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcCostGrpCd = this.calcCostGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvTpCd = this.tmlInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCalcIndCd = this.tmlCalcIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnAudSeq = this.expnAudSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtVerNo = this.tmlAgmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpCd = this.calcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fpCalcPrdCd = this.fpCalcPrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTrUtCd = this.volTrUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrdDt = this.fmPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostFullNm = this.lgsCostFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrVolQty = this.ovrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totVol = this.totVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtOfcCtyCd = this.tmlAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRt = this.ctrtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCfmDt = this.invCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcRmk = this.calcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmAmt = this.estmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrdDt = this.toPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffVolQty = this.diffVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcAmt = this.calcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fpTeuQty = this.fpTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtSeq = this.tmlAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prdYm = this.prdYm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exceedAvgFlg = this.exceedAvgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoDysIndCd = this.stoDysIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVolQty = this.invVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacFlg = this.eacFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
