/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesMarineTerminalDetailVO.java
*@FileTitle : TesMarineTerminalDetailVO
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

public class TesMarineTerminalDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesMarineTerminalDetailVO> models = new ArrayList<TesMarineTerminalDetailVO>();
	
	/* Column Info */
	private String tierVol = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String volDiffFlg = null;
	/* Column Info */
	private String freq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String volTrUtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String calcVolQty = null;
	/* Column Info */
	private String lgsCostFullNm = null;
	/* Column Info */
	private String invDiffPct = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String n3monTotVol = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String unitAvgCost = null;
	/* Column Info */
	private String agmtRt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String exceedAvgFlg = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String tmlTrnsModCd = null;
	/* Column Info */
	private String estmVol = null;
	/* Column Info */
	private String atbDt = null;
	/* Column Info */
	private String expnAudSeq = null;
	/* Column Info */
	private String calcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String expnMaxPrmtRto = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String rvisVolQty = null;
	/* Column Info */
	private String ctrtRt = null;
	/* Column Info */
	private String calcRmk = null;
	/* Column Info */
	private String invCfmDt = null;
	/* Column Info */
	private String estmAmt = null;
	/* Column Info */
	private String n3monTotInvVol = null;
	/* Column Info */
	private String dscrCtnt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String dgFlg = null;
	/* Column Info */
	private String n3monTotAmt = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String tmlWrkDyCd = null;
	/* Column Info */
	private String vvdVol = null;
	/* Column Info */
	private String eacFlg = null;
	/* Column Info */
	private String vvdCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesMarineTerminalDetailVO() {}

	public TesMarineTerminalDetailVO(String ibflag, String pagerows, String calcTpCd, String lgsCostCd, String lgsCostFullNm, String cntrTpszCd, String ioBndCd, String dgFlg, String rcFlg, String tmlWrkDyCd, String iocCd, String tmlTrnsModCd, String laneCd, String tierVol, String calcVolQty, String rvisVolQty, String volTrUtCd, String ctrtRt, String currCd, String invXchRt, String invAmt, String calcRmk, String n3monTotVol, String n3monTotInvVol, String n3monTotAmt, String freq, String vvdCnt, String agmtRt, String unitAvgCost, String vvdVol, String estmVol, String estmAmt, String exceedAvgFlg, String invDiffPct, String volDiffFlg, String dscrCtnt, String eacFlg, String invNo, String vndrSeq, String atbDt, String ydCd, String invCfmDt, String vslCd, String skdVoyNo, String skdDirCd, String ydNm, String vndrNm, String agmtNo, String agmtVerNo, String expnAudSeq, String expnMaxPrmtRto) {
		this.tierVol = tierVol;
		this.vslCd = vslCd;
		this.volDiffFlg = volDiffFlg;
		this.freq = freq;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.volTrUtCd = volTrUtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.invXchRt = invXchRt;
		this.calcVolQty = calcVolQty;
		this.lgsCostFullNm = lgsCostFullNm;
		this.invDiffPct = invDiffPct;
		this.agmtNo = agmtNo;
		this.n3monTotVol = n3monTotVol;
		this.skdVoyNo = skdVoyNo;
		this.unitAvgCost = unitAvgCost;
		this.agmtRt = agmtRt;
		this.vndrSeq = vndrSeq;
		this.ydNm = ydNm;
		this.exceedAvgFlg = exceedAvgFlg;
		this.rcFlg = rcFlg;
		this.agmtVerNo = agmtVerNo;
		this.laneCd = laneCd;
		this.currCd = currCd;
		this.tmlTrnsModCd = tmlTrnsModCd;
		this.estmVol = estmVol;
		this.atbDt = atbDt;
		this.expnAudSeq = expnAudSeq;
		this.calcTpCd = calcTpCd;
		this.ibflag = ibflag;
		this.expnMaxPrmtRto = expnMaxPrmtRto;
		this.invAmt = invAmt;
		this.iocCd = iocCd;
		this.rvisVolQty = rvisVolQty;
		this.ctrtRt = ctrtRt;
		this.calcRmk = calcRmk;
		this.invCfmDt = invCfmDt;
		this.estmAmt = estmAmt;
		this.n3monTotInvVol = n3monTotInvVol;
		this.dscrCtnt = dscrCtnt;
		this.ioBndCd = ioBndCd;
		this.skdDirCd = skdDirCd;
		this.invNo = invNo;
		this.dgFlg = dgFlg;
		this.n3monTotAmt = n3monTotAmt;
		this.ydCd = ydCd;
		this.lgsCostCd = lgsCostCd;
		this.tmlWrkDyCd = tmlWrkDyCd;
		this.vvdVol = vvdVol;
		this.eacFlg = eacFlg;
		this.vvdCnt = vvdCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tier_vol", getTierVol());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vol_diff_flg", getVolDiffFlg());
		this.hashColumns.put("freq", getFreq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("vol_tr_ut_cd", getVolTrUtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("calc_vol_qty", getCalcVolQty());
		this.hashColumns.put("lgs_cost_full_nm", getLgsCostFullNm());
		this.hashColumns.put("inv_diff_pct", getInvDiffPct());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("n3mon_tot_vol", getN3monTotVol());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("unit_avg_cost", getUnitAvgCost());
		this.hashColumns.put("agmt_rt", getAgmtRt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("exceed_avg_flg", getExceedAvgFlg());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("tml_trns_mod_cd", getTmlTrnsModCd());
		this.hashColumns.put("estm_vol", getEstmVol());
		this.hashColumns.put("atb_dt", getAtbDt());
		this.hashColumns.put("expn_aud_seq", getExpnAudSeq());
		this.hashColumns.put("calc_tp_cd", getCalcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("expn_max_prmt_rto", getExpnMaxPrmtRto());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("rvis_vol_qty", getRvisVolQty());
		this.hashColumns.put("ctrt_rt", getCtrtRt());
		this.hashColumns.put("calc_rmk", getCalcRmk());
		this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
		this.hashColumns.put("estm_amt", getEstmAmt());
		this.hashColumns.put("n3mon_tot_inv_vol", getN3monTotInvVol());
		this.hashColumns.put("dscr_ctnt", getDscrCtnt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("dg_flg", getDgFlg());
		this.hashColumns.put("n3mon_tot_amt", getN3monTotAmt());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("tml_wrk_dy_cd", getTmlWrkDyCd());
		this.hashColumns.put("vvd_vol", getVvdVol());
		this.hashColumns.put("eac_flg", getEacFlg());
		this.hashColumns.put("vvd_cnt", getVvdCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tier_vol", "tierVol");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vol_diff_flg", "volDiffFlg");
		this.hashFields.put("freq", "freq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("vol_tr_ut_cd", "volTrUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("calc_vol_qty", "calcVolQty");
		this.hashFields.put("lgs_cost_full_nm", "lgsCostFullNm");
		this.hashFields.put("inv_diff_pct", "invDiffPct");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("n3mon_tot_vol", "n3monTotVol");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("unit_avg_cost", "unitAvgCost");
		this.hashFields.put("agmt_rt", "agmtRt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("exceed_avg_flg", "exceedAvgFlg");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("tml_trns_mod_cd", "tmlTrnsModCd");
		this.hashFields.put("estm_vol", "estmVol");
		this.hashFields.put("atb_dt", "atbDt");
		this.hashFields.put("expn_aud_seq", "expnAudSeq");
		this.hashFields.put("calc_tp_cd", "calcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("expn_max_prmt_rto", "expnMaxPrmtRto");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("rvis_vol_qty", "rvisVolQty");
		this.hashFields.put("ctrt_rt", "ctrtRt");
		this.hashFields.put("calc_rmk", "calcRmk");
		this.hashFields.put("inv_cfm_dt", "invCfmDt");
		this.hashFields.put("estm_amt", "estmAmt");
		this.hashFields.put("n3mon_tot_inv_vol", "n3monTotInvVol");
		this.hashFields.put("dscr_ctnt", "dscrCtnt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("dg_flg", "dgFlg");
		this.hashFields.put("n3mon_tot_amt", "n3monTotAmt");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("tml_wrk_dy_cd", "tmlWrkDyCd");
		this.hashFields.put("vvd_vol", "vvdVol");
		this.hashFields.put("eac_flg", "eacFlg");
		this.hashFields.put("vvd_cnt", "vvdCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tierVol
	 */
	public String getTierVol() {
		return this.tierVol;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return freq
	 */
	public String getFreq() {
		return this.freq;
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
	 * @return lgsCostFullNm
	 */
	public String getLgsCostFullNm() {
		return this.lgsCostFullNm;
	}
	
	/**
	 * Column Info
	 * @return invDiffPct
	 */
	public String getInvDiffPct() {
		return this.invDiffPct;
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
	 * @return n3monTotVol
	 */
	public String getN3monTotVol() {
		return this.n3monTotVol;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return unitAvgCost
	 */
	public String getUnitAvgCost() {
		return this.unitAvgCost;
	}
	
	/**
	 * Column Info
	 * @return agmtRt
	 */
	public String getAgmtRt() {
		return this.agmtRt;
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
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
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
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
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
	 * @return tmlTrnsModCd
	 */
	public String getTmlTrnsModCd() {
		return this.tmlTrnsModCd;
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
	 * @return atbDt
	 */
	public String getAtbDt() {
		return this.atbDt;
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
	 * @return expnMaxPrmtRto
	 */
	public String getExpnMaxPrmtRto() {
		return this.expnMaxPrmtRto;
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
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
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
	 * @return estmAmt
	 */
	public String getEstmAmt() {
		return this.estmAmt;
	}
	
	/**
	 * Column Info
	 * @return n3monTotInvVol
	 */
	public String getN3monTotInvVol() {
		return this.n3monTotInvVol;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return dgFlg
	 */
	public String getDgFlg() {
		return this.dgFlg;
	}
	
	/**
	 * Column Info
	 * @return n3monTotAmt
	 */
	public String getN3monTotAmt() {
		return this.n3monTotAmt;
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
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
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
	 * @return vvdVol
	 */
	public String getVvdVol() {
		return this.vvdVol;
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
	 * @return vvdCnt
	 */
	public String getVvdCnt() {
		return this.vvdCnt;
	}
	

	/**
	 * Column Info
	 * @param tierVol
	 */
	public void setTierVol(String tierVol) {
		this.tierVol = tierVol;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param freq
	 */
	public void setFreq(String freq) {
		this.freq = freq;
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
	 * @param lgsCostFullNm
	 */
	public void setLgsCostFullNm(String lgsCostFullNm) {
		this.lgsCostFullNm = lgsCostFullNm;
	}
	
	/**
	 * Column Info
	 * @param invDiffPct
	 */
	public void setInvDiffPct(String invDiffPct) {
		this.invDiffPct = invDiffPct;
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
	 * @param n3monTotVol
	 */
	public void setN3monTotVol(String n3monTotVol) {
		this.n3monTotVol = n3monTotVol;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param unitAvgCost
	 */
	public void setUnitAvgCost(String unitAvgCost) {
		this.unitAvgCost = unitAvgCost;
	}
	
	/**
	 * Column Info
	 * @param agmtRt
	 */
	public void setAgmtRt(String agmtRt) {
		this.agmtRt = agmtRt;
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
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
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
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
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
	 * @param tmlTrnsModCd
	 */
	public void setTmlTrnsModCd(String tmlTrnsModCd) {
		this.tmlTrnsModCd = tmlTrnsModCd;
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
	 * @param atbDt
	 */
	public void setAtbDt(String atbDt) {
		this.atbDt = atbDt;
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
	 * @param expnMaxPrmtRto
	 */
	public void setExpnMaxPrmtRto(String expnMaxPrmtRto) {
		this.expnMaxPrmtRto = expnMaxPrmtRto;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
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
	 * @param estmAmt
	 */
	public void setEstmAmt(String estmAmt) {
		this.estmAmt = estmAmt;
	}
	
	/**
	 * Column Info
	 * @param n3monTotInvVol
	 */
	public void setN3monTotInvVol(String n3monTotInvVol) {
		this.n3monTotInvVol = n3monTotInvVol;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param dgFlg
	 */
	public void setDgFlg(String dgFlg) {
		this.dgFlg = dgFlg;
	}
	
	/**
	 * Column Info
	 * @param n3monTotAmt
	 */
	public void setN3monTotAmt(String n3monTotAmt) {
		this.n3monTotAmt = n3monTotAmt;
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
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param tmlWrkDyCd
	 */
	public void setTmlWrkDyCd(String tmlWrkDyCd) {
		this.tmlWrkDyCd = tmlWrkDyCd;
	}
	
	/**
	 * Column Info
	 * @param vvdVol
	 */
	public void setVvdVol(String vvdVol) {
		this.vvdVol = vvdVol;
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
	 * @param vvdCnt
	 */
	public void setVvdCnt(String vvdCnt) {
		this.vvdCnt = vvdCnt;
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
		setTierVol(JSPUtil.getParameter(request, prefix + "tier_vol", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVolDiffFlg(JSPUtil.getParameter(request, prefix + "vol_diff_flg", ""));
		setFreq(JSPUtil.getParameter(request, prefix + "freq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setVolTrUtCd(JSPUtil.getParameter(request, prefix + "vol_tr_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setCalcVolQty(JSPUtil.getParameter(request, prefix + "calc_vol_qty", ""));
		setLgsCostFullNm(JSPUtil.getParameter(request, prefix + "lgs_cost_full_nm", ""));
		setInvDiffPct(JSPUtil.getParameter(request, prefix + "inv_diff_pct", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setN3monTotVol(JSPUtil.getParameter(request, prefix + "n3mon_tot_vol", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setUnitAvgCost(JSPUtil.getParameter(request, prefix + "unit_avg_cost", ""));
		setAgmtRt(JSPUtil.getParameter(request, prefix + "agmt_rt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setExceedAvgFlg(JSPUtil.getParameter(request, prefix + "exceed_avg_flg", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, prefix + "agmt_ver_no", ""));
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTmlTrnsModCd(JSPUtil.getParameter(request, prefix + "tml_trns_mod_cd", ""));
		setEstmVol(JSPUtil.getParameter(request, prefix + "estm_vol", ""));
		setAtbDt(JSPUtil.getParameter(request, prefix + "atb_dt", ""));
		setExpnAudSeq(JSPUtil.getParameter(request, prefix + "expn_aud_seq", ""));
		setCalcTpCd(JSPUtil.getParameter(request, prefix + "calc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExpnMaxPrmtRto(JSPUtil.getParameter(request, prefix + "expn_max_prmt_rto", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setRvisVolQty(JSPUtil.getParameter(request, prefix + "rvis_vol_qty", ""));
		setCtrtRt(JSPUtil.getParameter(request, prefix + "ctrt_rt", ""));
		setCalcRmk(JSPUtil.getParameter(request, prefix + "calc_rmk", ""));
		setInvCfmDt(JSPUtil.getParameter(request, prefix + "inv_cfm_dt", ""));
		setEstmAmt(JSPUtil.getParameter(request, prefix + "estm_amt", ""));
		setN3monTotInvVol(JSPUtil.getParameter(request, prefix + "n3mon_tot_inv_vol", ""));
		setDscrCtnt(JSPUtil.getParameter(request, prefix + "dscr_ctnt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setDgFlg(JSPUtil.getParameter(request, prefix + "dg_flg", ""));
		setN3monTotAmt(JSPUtil.getParameter(request, prefix + "n3mon_tot_amt", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setTmlWrkDyCd(JSPUtil.getParameter(request, prefix + "tml_wrk_dy_cd", ""));
		setVvdVol(JSPUtil.getParameter(request, prefix + "vvd_vol", ""));
		setEacFlg(JSPUtil.getParameter(request, prefix + "eac_flg", ""));
		setVvdCnt(JSPUtil.getParameter(request, prefix + "vvd_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesMarineTerminalDetailVO[]
	 */
	public TesMarineTerminalDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesMarineTerminalDetailVO[]
	 */
	public TesMarineTerminalDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesMarineTerminalDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tierVol = (JSPUtil.getParameter(request, prefix	+ "tier_vol", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] volDiffFlg = (JSPUtil.getParameter(request, prefix	+ "vol_diff_flg", length));
			String[] freq = (JSPUtil.getParameter(request, prefix	+ "freq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] volTrUtCd = (JSPUtil.getParameter(request, prefix	+ "vol_tr_ut_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] calcVolQty = (JSPUtil.getParameter(request, prefix	+ "calc_vol_qty", length));
			String[] lgsCostFullNm = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_full_nm", length));
			String[] invDiffPct = (JSPUtil.getParameter(request, prefix	+ "inv_diff_pct", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] n3monTotVol = (JSPUtil.getParameter(request, prefix	+ "n3mon_tot_vol", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] unitAvgCost = (JSPUtil.getParameter(request, prefix	+ "unit_avg_cost", length));
			String[] agmtRt = (JSPUtil.getParameter(request, prefix	+ "agmt_rt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] exceedAvgFlg = (JSPUtil.getParameter(request, prefix	+ "exceed_avg_flg", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] tmlTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "tml_trns_mod_cd", length));
			String[] estmVol = (JSPUtil.getParameter(request, prefix	+ "estm_vol", length));
			String[] atbDt = (JSPUtil.getParameter(request, prefix	+ "atb_dt", length));
			String[] expnAudSeq = (JSPUtil.getParameter(request, prefix	+ "expn_aud_seq", length));
			String[] calcTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] expnMaxPrmtRto = (JSPUtil.getParameter(request, prefix	+ "expn_max_prmt_rto", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] rvisVolQty = (JSPUtil.getParameter(request, prefix	+ "rvis_vol_qty", length));
			String[] ctrtRt = (JSPUtil.getParameter(request, prefix	+ "ctrt_rt", length));
			String[] calcRmk = (JSPUtil.getParameter(request, prefix	+ "calc_rmk", length));
			String[] invCfmDt = (JSPUtil.getParameter(request, prefix	+ "inv_cfm_dt", length));
			String[] estmAmt = (JSPUtil.getParameter(request, prefix	+ "estm_amt", length));
			String[] n3monTotInvVol = (JSPUtil.getParameter(request, prefix	+ "n3mon_tot_inv_vol", length));
			String[] dscrCtnt = (JSPUtil.getParameter(request, prefix	+ "dscr_ctnt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] dgFlg = (JSPUtil.getParameter(request, prefix	+ "dg_flg", length));
			String[] n3monTotAmt = (JSPUtil.getParameter(request, prefix	+ "n3mon_tot_amt", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] tmlWrkDyCd = (JSPUtil.getParameter(request, prefix	+ "tml_wrk_dy_cd", length));
			String[] vvdVol = (JSPUtil.getParameter(request, prefix	+ "vvd_vol", length));
			String[] eacFlg = (JSPUtil.getParameter(request, prefix	+ "eac_flg", length));
			String[] vvdCnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesMarineTerminalDetailVO();
				if (tierVol[i] != null)
					model.setTierVol(tierVol[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (volDiffFlg[i] != null)
					model.setVolDiffFlg(volDiffFlg[i]);
				if (freq[i] != null)
					model.setFreq(freq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (volTrUtCd[i] != null)
					model.setVolTrUtCd(volTrUtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (calcVolQty[i] != null)
					model.setCalcVolQty(calcVolQty[i]);
				if (lgsCostFullNm[i] != null)
					model.setLgsCostFullNm(lgsCostFullNm[i]);
				if (invDiffPct[i] != null)
					model.setInvDiffPct(invDiffPct[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (n3monTotVol[i] != null)
					model.setN3monTotVol(n3monTotVol[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (unitAvgCost[i] != null)
					model.setUnitAvgCost(unitAvgCost[i]);
				if (agmtRt[i] != null)
					model.setAgmtRt(agmtRt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (exceedAvgFlg[i] != null)
					model.setExceedAvgFlg(exceedAvgFlg[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (tmlTrnsModCd[i] != null)
					model.setTmlTrnsModCd(tmlTrnsModCd[i]);
				if (estmVol[i] != null)
					model.setEstmVol(estmVol[i]);
				if (atbDt[i] != null)
					model.setAtbDt(atbDt[i]);
				if (expnAudSeq[i] != null)
					model.setExpnAudSeq(expnAudSeq[i]);
				if (calcTpCd[i] != null)
					model.setCalcTpCd(calcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (expnMaxPrmtRto[i] != null)
					model.setExpnMaxPrmtRto(expnMaxPrmtRto[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (rvisVolQty[i] != null)
					model.setRvisVolQty(rvisVolQty[i]);
				if (ctrtRt[i] != null)
					model.setCtrtRt(ctrtRt[i]);
				if (calcRmk[i] != null)
					model.setCalcRmk(calcRmk[i]);
				if (invCfmDt[i] != null)
					model.setInvCfmDt(invCfmDt[i]);
				if (estmAmt[i] != null)
					model.setEstmAmt(estmAmt[i]);
				if (n3monTotInvVol[i] != null)
					model.setN3monTotInvVol(n3monTotInvVol[i]);
				if (dscrCtnt[i] != null)
					model.setDscrCtnt(dscrCtnt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (dgFlg[i] != null)
					model.setDgFlg(dgFlg[i]);
				if (n3monTotAmt[i] != null)
					model.setN3monTotAmt(n3monTotAmt[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (tmlWrkDyCd[i] != null)
					model.setTmlWrkDyCd(tmlWrkDyCd[i]);
				if (vvdVol[i] != null)
					model.setVvdVol(vvdVol[i]);
				if (eacFlg[i] != null)
					model.setEacFlg(eacFlg[i]);
				if (vvdCnt[i] != null)
					model.setVvdCnt(vvdCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesMarineTerminalDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesMarineTerminalDetailVO[]
	 */
	public TesMarineTerminalDetailVO[] getTesMarineTerminalDetailVOs(){
		TesMarineTerminalDetailVO[] vos = (TesMarineTerminalDetailVO[])models.toArray(new TesMarineTerminalDetailVO[models.size()]);
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
		this.tierVol = this.tierVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volDiffFlg = this.volDiffFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freq = this.freq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTrUtCd = this.volTrUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcVolQty = this.calcVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostFullNm = this.lgsCostFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDiffPct = this.invDiffPct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3monTotVol = this.n3monTotVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitAvgCost = this.unitAvgCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRt = this.agmtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exceedAvgFlg = this.exceedAvgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlTrnsModCd = this.tmlTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVol = this.estmVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atbDt = this.atbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnAudSeq = this.expnAudSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpCd = this.calcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnMaxPrmtRto = this.expnMaxPrmtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisVolQty = this.rvisVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRt = this.ctrtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcRmk = this.calcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCfmDt = this.invCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmAmt = this.estmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3monTotInvVol = this.n3monTotInvVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscrCtnt = this.dscrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFlg = this.dgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3monTotAmt = this.n3monTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlWrkDyCd = this.tmlWrkDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdVol = this.vvdVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacFlg = this.eacFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCnt = this.vvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
