/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesOffdockCYDetailTMNLVO.java
*@FileTitle : TesOffdockCYDetailTMNLVO
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

public class TesOffdockCYDetailTMNLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesOffdockCYDetailTMNLVO> models = new ArrayList<TesOffdockCYDetailTMNLVO>();
	
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String volDiffFlg = null;
	/* Column Info */
	private String estmVol = null;
	/* Column Info */
	private String avgRt = null;
	/* Column Info */
	private String tmlInvTpCd = null;
	/* Column Info */
	private String calcCostGrpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tmlCalcIndCd = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String calcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String volTrUtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String fmPrdDt = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String lgsCostFullNm = null;
	/* Column Info */
	private String calcVolQty = null;
	/* Column Info */
	private String n3ptyFlg = null;
	/* Column Info */
	private String totVol = null;
	/* Column Info */
	private String rvisVolQty = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String ctrtRt = null;
	/* Column Info */
	private String calcRmk = null;
	/* Column Info */
	private String invCfmDt = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String estmAmt = null;
	/* Column Info */
	private String toPrdDt = null;
	/* Column Info */
	private String dscrCtnt = null;
	/* Column Info */
	private String calcAmt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrStyCd = null;
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
	private String agmtVerNo = null;
	/* Column Info */
	private String eacFlg = null;
	/* Column Info */
	private String rcFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesOffdockCYDetailTMNLVO() {}

	public TesOffdockCYDetailTMNLVO(String ibflag, String pagerows, String calcTpCd, String lgsCostCd, String lgsCostFullNm, String rcFlg, String cntrTpszCd, String ydCd, String vndrSeq, String invNo, String invCfmDt, String invOfcCd, String prdYm, String fmPrdDt, String toPrdDt, String tmlInvTpCd, String tmlCalcIndCd, String stoDysIndCd, String calcCostGrpCd, String cntrStyCd, String calcVolQty, String revYrmon, String rvisVolQty, String volTrUtCd, String ctrtRt, String currCd, String invXchRt, String invAmt, String calcAmt, String calcRmk, String n3ptyFlg, String dscrCtnt, String totVol, String totAmt, String estmVol, String avgRt, String estmAmt, String eacFlg, String ydNm, String vndrNm, String agmtNo, String agmtVerNo, String exceedAvgFlg, String volDiffFlg) {
		this.totAmt = totAmt;
		this.currCd = currCd;
		this.volDiffFlg = volDiffFlg;
		this.estmVol = estmVol;
		this.avgRt = avgRt;
		this.tmlInvTpCd = tmlInvTpCd;
		this.calcCostGrpCd = calcCostGrpCd;
		this.pagerows = pagerows;
		this.tmlCalcIndCd = tmlCalcIndCd;
		this.vndrNm = vndrNm;
		this.calcTpCd = calcTpCd;
		this.ibflag = ibflag;
		this.volTrUtCd = volTrUtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.invAmt = invAmt;
		this.fmPrdDt = fmPrdDt;
		this.invXchRt = invXchRt;
		this.invOfcCd = invOfcCd;
		this.lgsCostFullNm = lgsCostFullNm;
		this.calcVolQty = calcVolQty;
		this.n3ptyFlg = n3ptyFlg;
		this.totVol = totVol;
		this.rvisVolQty = rvisVolQty;
		this.revYrmon = revYrmon;
		this.ctrtRt = ctrtRt;
		this.calcRmk = calcRmk;
		this.invCfmDt = invCfmDt;
		this.agmtNo = agmtNo;
		this.estmAmt = estmAmt;
		this.toPrdDt = toPrdDt;
		this.dscrCtnt = dscrCtnt;
		this.calcAmt = calcAmt;
		this.invNo = invNo;
		this.ydCd = ydCd;
		this.cntrStyCd = cntrStyCd;
		this.vndrSeq = vndrSeq;
		this.prdYm = prdYm;
		this.lgsCostCd = lgsCostCd;
		this.ydNm = ydNm;
		this.exceedAvgFlg = exceedAvgFlg;
		this.stoDysIndCd = stoDysIndCd;
		this.agmtVerNo = agmtVerNo;
		this.eacFlg = eacFlg;
		this.rcFlg = rcFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("vol_diff_flg", getVolDiffFlg());
		this.hashColumns.put("estm_vol", getEstmVol());
		this.hashColumns.put("avg_rt", getAvgRt());
		this.hashColumns.put("tml_inv_tp_cd", getTmlInvTpCd());
		this.hashColumns.put("calc_cost_grp_cd", getCalcCostGrpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tml_calc_ind_cd", getTmlCalcIndCd());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("calc_tp_cd", getCalcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vol_tr_ut_cd", getVolTrUtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("fm_prd_dt", getFmPrdDt());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("lgs_cost_full_nm", getLgsCostFullNm());
		this.hashColumns.put("calc_vol_qty", getCalcVolQty());
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());
		this.hashColumns.put("tot_vol", getTotVol());
		this.hashColumns.put("rvis_vol_qty", getRvisVolQty());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("ctrt_rt", getCtrtRt());
		this.hashColumns.put("calc_rmk", getCalcRmk());
		this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("estm_amt", getEstmAmt());
		this.hashColumns.put("to_prd_dt", getToPrdDt());
		this.hashColumns.put("dscr_ctnt", getDscrCtnt());
		this.hashColumns.put("calc_amt", getCalcAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_sty_cd", getCntrStyCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("prd_ym", getPrdYm());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("exceed_avg_flg", getExceedAvgFlg());
		this.hashColumns.put("sto_dys_ind_cd", getStoDysIndCd());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("eac_flg", getEacFlg());
		this.hashColumns.put("rc_flg", getRcFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tot_amt", "totAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("vol_diff_flg", "volDiffFlg");
		this.hashFields.put("estm_vol", "estmVol");
		this.hashFields.put("avg_rt", "avgRt");
		this.hashFields.put("tml_inv_tp_cd", "tmlInvTpCd");
		this.hashFields.put("calc_cost_grp_cd", "calcCostGrpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tml_calc_ind_cd", "tmlCalcIndCd");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("calc_tp_cd", "calcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vol_tr_ut_cd", "volTrUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("fm_prd_dt", "fmPrdDt");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("lgs_cost_full_nm", "lgsCostFullNm");
		this.hashFields.put("calc_vol_qty", "calcVolQty");
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("tot_vol", "totVol");
		this.hashFields.put("rvis_vol_qty", "rvisVolQty");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("ctrt_rt", "ctrtRt");
		this.hashFields.put("calc_rmk", "calcRmk");
		this.hashFields.put("inv_cfm_dt", "invCfmDt");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("estm_amt", "estmAmt");
		this.hashFields.put("to_prd_dt", "toPrdDt");
		this.hashFields.put("dscr_ctnt", "dscrCtnt");
		this.hashFields.put("calc_amt", "calcAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_sty_cd", "cntrStyCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("prd_ym", "prdYm");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("exceed_avg_flg", "exceedAvgFlg");
		this.hashFields.put("sto_dys_ind_cd", "stoDysIndCd");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("eac_flg", "eacFlg");
		this.hashFields.put("rc_flg", "rcFlg");
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
	 * @return volDiffFlg
	 */
	public String getVolDiffFlg() {
		return this.volDiffFlg;
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
	 * @return avgRt
	 */
	public String getAvgRt() {
		return this.avgRt;
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
	 * @return calcCostGrpCd
	 */
	public String getCalcCostGrpCd() {
		return this.calcCostGrpCd;
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
	 * @return tmlCalcIndCd
	 */
	public String getTmlCalcIndCd() {
		return this.tmlCalcIndCd;
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
	 * @return lgsCostFullNm
	 */
	public String getLgsCostFullNm() {
		return this.lgsCostFullNm;
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
	 * @return n3ptyFlg
	 */
	public String getN3ptyFlg() {
		return this.n3ptyFlg;
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
	 * @return rvisVolQty
	 */
	public String getRvisVolQty() {
		return this.rvisVolQty;
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
	 * @return dscrCtnt
	 */
	public String getDscrCtnt() {
		return this.dscrCtnt;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return cntrStyCd
	 */
	public String getCntrStyCd() {
		return this.cntrStyCd;
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
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
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
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
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
	 * @param volDiffFlg
	 */
	public void setVolDiffFlg(String volDiffFlg) {
		this.volDiffFlg = volDiffFlg;
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
	 * @param avgRt
	 */
	public void setAvgRt(String avgRt) {
		this.avgRt = avgRt;
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
	 * @param calcCostGrpCd
	 */
	public void setCalcCostGrpCd(String calcCostGrpCd) {
		this.calcCostGrpCd = calcCostGrpCd;
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
	 * @param tmlCalcIndCd
	 */
	public void setTmlCalcIndCd(String tmlCalcIndCd) {
		this.tmlCalcIndCd = tmlCalcIndCd;
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
	 * @param lgsCostFullNm
	 */
	public void setLgsCostFullNm(String lgsCostFullNm) {
		this.lgsCostFullNm = lgsCostFullNm;
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
	 * @param n3ptyFlg
	 */
	public void setN3ptyFlg(String n3ptyFlg) {
		this.n3ptyFlg = n3ptyFlg;
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
	 * @param rvisVolQty
	 */
	public void setRvisVolQty(String rvisVolQty) {
		this.rvisVolQty = rvisVolQty;
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
	 * @param dscrCtnt
	 */
	public void setDscrCtnt(String dscrCtnt) {
		this.dscrCtnt = dscrCtnt;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param cntrStyCd
	 */
	public void setCntrStyCd(String cntrStyCd) {
		this.cntrStyCd = cntrStyCd;
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
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
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
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
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
		setVolDiffFlg(JSPUtil.getParameter(request, prefix + "vol_diff_flg", ""));
		setEstmVol(JSPUtil.getParameter(request, prefix + "estm_vol", ""));
		setAvgRt(JSPUtil.getParameter(request, prefix + "avg_rt", ""));
		setTmlInvTpCd(JSPUtil.getParameter(request, prefix + "tml_inv_tp_cd", ""));
		setCalcCostGrpCd(JSPUtil.getParameter(request, prefix + "calc_cost_grp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTmlCalcIndCd(JSPUtil.getParameter(request, prefix + "tml_calc_ind_cd", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setCalcTpCd(JSPUtil.getParameter(request, prefix + "calc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVolTrUtCd(JSPUtil.getParameter(request, prefix + "vol_tr_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setFmPrdDt(JSPUtil.getParameter(request, prefix + "fm_prd_dt", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setLgsCostFullNm(JSPUtil.getParameter(request, prefix + "lgs_cost_full_nm", ""));
		setCalcVolQty(JSPUtil.getParameter(request, prefix + "calc_vol_qty", ""));
		setN3ptyFlg(JSPUtil.getParameter(request, prefix + "n3pty_flg", ""));
		setTotVol(JSPUtil.getParameter(request, prefix + "tot_vol", ""));
		setRvisVolQty(JSPUtil.getParameter(request, prefix + "rvis_vol_qty", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setCtrtRt(JSPUtil.getParameter(request, prefix + "ctrt_rt", ""));
		setCalcRmk(JSPUtil.getParameter(request, prefix + "calc_rmk", ""));
		setInvCfmDt(JSPUtil.getParameter(request, prefix + "inv_cfm_dt", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setEstmAmt(JSPUtil.getParameter(request, prefix + "estm_amt", ""));
		setToPrdDt(JSPUtil.getParameter(request, prefix + "to_prd_dt", ""));
		setDscrCtnt(JSPUtil.getParameter(request, prefix + "dscr_ctnt", ""));
		setCalcAmt(JSPUtil.getParameter(request, prefix + "calc_amt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrStyCd(JSPUtil.getParameter(request, prefix + "cntr_sty_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setPrdYm(JSPUtil.getParameter(request, prefix + "prd_ym", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setExceedAvgFlg(JSPUtil.getParameter(request, prefix + "exceed_avg_flg", ""));
		setStoDysIndCd(JSPUtil.getParameter(request, prefix + "sto_dys_ind_cd", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, prefix + "agmt_ver_no", ""));
		setEacFlg(JSPUtil.getParameter(request, prefix + "eac_flg", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesOffdockCYDetailTMNLVO[]
	 */
	public TesOffdockCYDetailTMNLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesOffdockCYDetailTMNLVO[]
	 */
	public TesOffdockCYDetailTMNLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesOffdockCYDetailTMNLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] volDiffFlg = (JSPUtil.getParameter(request, prefix	+ "vol_diff_flg", length));
			String[] estmVol = (JSPUtil.getParameter(request, prefix	+ "estm_vol", length));
			String[] avgRt = (JSPUtil.getParameter(request, prefix	+ "avg_rt", length));
			String[] tmlInvTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_inv_tp_cd", length));
			String[] calcCostGrpCd = (JSPUtil.getParameter(request, prefix	+ "calc_cost_grp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tmlCalcIndCd = (JSPUtil.getParameter(request, prefix	+ "tml_calc_ind_cd", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] calcTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] volTrUtCd = (JSPUtil.getParameter(request, prefix	+ "vol_tr_ut_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] fmPrdDt = (JSPUtil.getParameter(request, prefix	+ "fm_prd_dt", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] lgsCostFullNm = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_full_nm", length));
			String[] calcVolQty = (JSPUtil.getParameter(request, prefix	+ "calc_vol_qty", length));
			String[] n3ptyFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_flg", length));
			String[] totVol = (JSPUtil.getParameter(request, prefix	+ "tot_vol", length));
			String[] rvisVolQty = (JSPUtil.getParameter(request, prefix	+ "rvis_vol_qty", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] ctrtRt = (JSPUtil.getParameter(request, prefix	+ "ctrt_rt", length));
			String[] calcRmk = (JSPUtil.getParameter(request, prefix	+ "calc_rmk", length));
			String[] invCfmDt = (JSPUtil.getParameter(request, prefix	+ "inv_cfm_dt", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] estmAmt = (JSPUtil.getParameter(request, prefix	+ "estm_amt", length));
			String[] toPrdDt = (JSPUtil.getParameter(request, prefix	+ "to_prd_dt", length));
			String[] dscrCtnt = (JSPUtil.getParameter(request, prefix	+ "dscr_ctnt", length));
			String[] calcAmt = (JSPUtil.getParameter(request, prefix	+ "calc_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrStyCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sty_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] prdYm = (JSPUtil.getParameter(request, prefix	+ "prd_ym", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] exceedAvgFlg = (JSPUtil.getParameter(request, prefix	+ "exceed_avg_flg", length));
			String[] stoDysIndCd = (JSPUtil.getParameter(request, prefix	+ "sto_dys_ind_cd", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] eacFlg = (JSPUtil.getParameter(request, prefix	+ "eac_flg", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesOffdockCYDetailTMNLVO();
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (volDiffFlg[i] != null)
					model.setVolDiffFlg(volDiffFlg[i]);
				if (estmVol[i] != null)
					model.setEstmVol(estmVol[i]);
				if (avgRt[i] != null)
					model.setAvgRt(avgRt[i]);
				if (tmlInvTpCd[i] != null)
					model.setTmlInvTpCd(tmlInvTpCd[i]);
				if (calcCostGrpCd[i] != null)
					model.setCalcCostGrpCd(calcCostGrpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tmlCalcIndCd[i] != null)
					model.setTmlCalcIndCd(tmlCalcIndCd[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (calcTpCd[i] != null)
					model.setCalcTpCd(calcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (volTrUtCd[i] != null)
					model.setVolTrUtCd(volTrUtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (fmPrdDt[i] != null)
					model.setFmPrdDt(fmPrdDt[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (lgsCostFullNm[i] != null)
					model.setLgsCostFullNm(lgsCostFullNm[i]);
				if (calcVolQty[i] != null)
					model.setCalcVolQty(calcVolQty[i]);
				if (n3ptyFlg[i] != null)
					model.setN3ptyFlg(n3ptyFlg[i]);
				if (totVol[i] != null)
					model.setTotVol(totVol[i]);
				if (rvisVolQty[i] != null)
					model.setRvisVolQty(rvisVolQty[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (ctrtRt[i] != null)
					model.setCtrtRt(ctrtRt[i]);
				if (calcRmk[i] != null)
					model.setCalcRmk(calcRmk[i]);
				if (invCfmDt[i] != null)
					model.setInvCfmDt(invCfmDt[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (estmAmt[i] != null)
					model.setEstmAmt(estmAmt[i]);
				if (toPrdDt[i] != null)
					model.setToPrdDt(toPrdDt[i]);
				if (dscrCtnt[i] != null)
					model.setDscrCtnt(dscrCtnt[i]);
				if (calcAmt[i] != null)
					model.setCalcAmt(calcAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrStyCd[i] != null)
					model.setCntrStyCd(cntrStyCd[i]);
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
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (eacFlg[i] != null)
					model.setEacFlg(eacFlg[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesOffdockCYDetailTMNLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesOffdockCYDetailTMNLVO[]
	 */
	public TesOffdockCYDetailTMNLVO[] getTesOffdockCYDetailTMNLVOs(){
		TesOffdockCYDetailTMNLVO[] vos = (TesOffdockCYDetailTMNLVO[])models.toArray(new TesOffdockCYDetailTMNLVO[models.size()]);
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
		this.volDiffFlg = this.volDiffFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVol = this.estmVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgRt = this.avgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvTpCd = this.tmlInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcCostGrpCd = this.calcCostGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCalcIndCd = this.tmlCalcIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpCd = this.calcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTrUtCd = this.volTrUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrdDt = this.fmPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostFullNm = this.lgsCostFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcVolQty = this.calcVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyFlg = this.n3ptyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totVol = this.totVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisVolQty = this.rvisVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRt = this.ctrtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcRmk = this.calcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCfmDt = this.invCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmAmt = this.estmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrdDt = this.toPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscrCtnt = this.dscrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcAmt = this.calcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStyCd = this.cntrStyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prdYm = this.prdYm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exceedAvgFlg = this.exceedAvgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoDysIndCd = this.stoDysIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacFlg = this.eacFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
