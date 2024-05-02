/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DmtYdExptCostVO.java
*@FileTitle : DmtYdExptCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.22
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.10.22 KIM HYUN HWA 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo;

import java.lang.reflect.Field;
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
 * @author KIM HYUN HWA
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtYdExptCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtYdExptCostVO> models = new ArrayList<DmtYdExptCostVO>();
	
	/* Column Info */
	private String cntrCost20ftRtAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String ydExptCostSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String demDor20ft = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String otrCost20ftRtAmt = null;
	/* Column Info */
	private String demCy40ft = null;
	/* Column Info */
	private String demCy20ft = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String chgCostDorRtAmt = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String demIbCltFlg = null;
	/* Column Info */
	private String costSts = null;
	/* Column Info */
	private String tmlCost40ftRtAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String cntrCost40ftRtAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dmdtOfcCd = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String detCy40ft = null;
	/* Column Info */
	private String dmdtCalcTpCd = null;
	/* Column Info */
	private String otrCost40ftRtAmt = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String cfmOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String demDor40ft = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String detDor20ft = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String detDor40ft = null;
	/* Column Info */
	private String chgCostCyRtAmt = null;
	/* Column Info */
	private String detCy20ft = null;
	/* Column Info */
	private String tmlCost20ftRtAmt = null;
	/* Column Info */
	private String cntrCostStkAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtYdExptCostVO() {}

	public DmtYdExptCostVO(String ibflag, String pagerows, String ydCd, String ydExptCostSeq, String dmdtOfcCd, String cfmFlg, String currCd, String tmlCost20ftRtAmt, String tmlCost40ftRtAmt, String cntrCost20ftRtAmt, String cntrCost40ftRtAmt, String chgCostCyRtAmt, String chgCostDorRtAmt, String otrCost20ftRtAmt, String otrCost40ftRtAmt, String effDt, String expDt, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String cfmDt, String cfmUsrId, String cfmOfcCd, String dmdtCalcTpCd, String deltFlg, String demCy20ft, String demCy40ft, String demDor20ft, String demDor40ft, String detCy20ft, String detCy40ft, String detDor20ft, String detDor40ft, String ydNm, String costSts, String demIbCltFlg,  String cntrCostStkAmt) {
		this.cntrCost20ftRtAmt = cntrCost20ftRtAmt;
		this.currCd = currCd;
		this.deltFlg = deltFlg;
		this.ydExptCostSeq = ydExptCostSeq;
		this.creDt = creDt;
		this.demDor20ft = demDor20ft;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.otrCost20ftRtAmt = otrCost20ftRtAmt;
		this.demCy40ft = demCy40ft;
		this.demCy20ft = demCy20ft;
		this.creOfcCd = creOfcCd;
		this.chgCostDorRtAmt = chgCostDorRtAmt;
		this.cfmUsrId = cfmUsrId;
		this.expDt = expDt;
		this.demIbCltFlg = demIbCltFlg;
		this.costSts = costSts;
		this.tmlCost40ftRtAmt = tmlCost40ftRtAmt;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.cntrCost40ftRtAmt = cntrCost40ftRtAmt;
		this.updDt = updDt;
		this.dmdtOfcCd = dmdtOfcCd;
		this.cfmDt = cfmDt;
		this.detCy40ft = detCy40ft;
		this.dmdtCalcTpCd = dmdtCalcTpCd;
		this.otrCost40ftRtAmt = otrCost40ftRtAmt;
		this.cfmFlg = cfmFlg;
		this.cfmOfcCd = cfmOfcCd;
		this.creUsrId = creUsrId;
		this.demDor40ft = demDor40ft;
		this.ydCd = ydCd;
		this.detDor20ft = detDor20ft;
		this.ydNm = ydNm;
		this.detDor40ft = detDor40ft;
		this.chgCostCyRtAmt = chgCostCyRtAmt;
		this.detCy20ft = detCy20ft;
		this.tmlCost20ftRtAmt = tmlCost20ftRtAmt;
		this.cntrCostStkAmt = cntrCostStkAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_cost_20ft_rt_amt", getCntrCost20ftRtAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("yd_expt_cost_seq", getYdExptCostSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dem_dor_20ft", getDemDor20ft());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("otr_cost_20ft_rt_amt", getOtrCost20ftRtAmt());
		this.hashColumns.put("dem_cy_40ft", getDemCy40ft());
		this.hashColumns.put("dem_cy_20ft", getDemCy20ft());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("chg_cost_dor_rt_amt", getChgCostDorRtAmt());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("dem_ib_clt_flg", getDemIbCltFlg());
		this.hashColumns.put("cost_sts", getCostSts());
		this.hashColumns.put("tml_cost_40ft_rt_amt", getTmlCost40ftRtAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("cntr_cost_40ft_rt_amt", getCntrCost40ftRtAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dmdt_ofc_cd", getDmdtOfcCd());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("det_cy_40ft", getDetCy40ft());
		this.hashColumns.put("dmdt_calc_tp_cd", getDmdtCalcTpCd());
		this.hashColumns.put("otr_cost_40ft_rt_amt", getOtrCost40ftRtAmt());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("cfm_ofc_cd", getCfmOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dem_dor_40ft", getDemDor40ft());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("det_dor_20ft", getDetDor20ft());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("det_dor_40ft", getDetDor40ft());
		this.hashColumns.put("chg_cost_cy_rt_amt", getChgCostCyRtAmt());
		this.hashColumns.put("det_cy_20ft", getDetCy20ft());
		this.hashColumns.put("tml_cost_20ft_rt_amt", getTmlCost20ftRtAmt());
		this.hashColumns.put("cntr_cost_stk_amt", getCntrCostStkAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_cost_20ft_rt_amt", "cntrCost20ftRtAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("yd_expt_cost_seq", "ydExptCostSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dem_dor_20ft", "demDor20ft");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("otr_cost_20ft_rt_amt", "otrCost20ftRtAmt");
		this.hashFields.put("dem_cy_40ft", "demCy40ft");
		this.hashFields.put("dem_cy_20ft", "demCy20ft");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("chg_cost_dor_rt_amt", "chgCostDorRtAmt");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("dem_ib_clt_flg", "demIbCltFlg");
		this.hashFields.put("cost_sts", "costSts");
		this.hashFields.put("tml_cost_40ft_rt_amt", "tmlCost40ftRtAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("cntr_cost_40ft_rt_amt", "cntrCost40ftRtAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dmdt_ofc_cd", "dmdtOfcCd");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("det_cy_40ft", "detCy40ft");
		this.hashFields.put("dmdt_calc_tp_cd", "dmdtCalcTpCd");
		this.hashFields.put("otr_cost_40ft_rt_amt", "otrCost40ftRtAmt");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("cfm_ofc_cd", "cfmOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dem_dor_40ft", "demDor40ft");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("det_dor_20ft", "detDor20ft");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("det_dor_40ft", "detDor40ft");
		this.hashFields.put("chg_cost_cy_rt_amt", "chgCostCyRtAmt");
		this.hashFields.put("det_cy_20ft", "detCy20ft");
		this.hashFields.put("tml_cost_20ft_rt_amt", "tmlCost20ftRtAmt");
		this.hashFields.put("cntr_cost_stk_amt", "cntrCostStkAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrCost20ftRtAmt
	 */
	public String getCntrCost20ftRtAmt() {
		return this.cntrCost20ftRtAmt;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return ydExptCostSeq
	 */
	public String getYdExptCostSeq() {
		return this.ydExptCostSeq;
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
	 * @return demDor20ft
	 */
	public String getDemDor20ft() {
		return this.demDor20ft;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return otrCost20ftRtAmt
	 */
	public String getOtrCost20ftRtAmt() {
		return this.otrCost20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return demCy40ft
	 */
	public String getDemCy40ft() {
		return this.demCy40ft;
	}
	
	/**
	 * Column Info
	 * @return demCy20ft
	 */
	public String getDemCy20ft() {
		return this.demCy20ft;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chgCostDorRtAmt
	 */
	public String getChgCostDorRtAmt() {
		return this.chgCostDorRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cfmUsrId
	 */
	public String getCfmUsrId() {
		return this.cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return demIbCltFlg
	 */
	public String getDemIbCltFlg() {
		return this.demIbCltFlg;
	}
	
	/**
	 * Column Info
	 * @return costSts
	 */
	public String getCostSts() {
		return this.costSts;
	}
	
	/**
	 * Column Info
	 * @return tmlCost40ftRtAmt
	 */
	public String getTmlCost40ftRtAmt() {
		return this.tmlCost40ftRtAmt;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntrCost40ftRtAmt
	 */
	public String getCntrCost40ftRtAmt() {
		return this.cntrCost40ftRtAmt;
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
	 * @return dmdtOfcCd
	 */
	public String getDmdtOfcCd() {
		return this.dmdtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
	}
	
	/**
	 * Column Info
	 * @return detCy40ft
	 */
	public String getDetCy40ft() {
		return this.detCy40ft;
	}
	
	/**
	 * Column Info
	 * @return dmdtCalcTpCd
	 */
	public String getDmdtCalcTpCd() {
		return this.dmdtCalcTpCd;
	}
	
	/**
	 * Column Info
	 * @return otrCost40ftRtAmt
	 */
	public String getOtrCost40ftRtAmt() {
		return this.otrCost40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return cfmOfcCd
	 */
	public String getCfmOfcCd() {
		return this.cfmOfcCd;
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
	 * @return demDor40ft
	 */
	public String getDemDor40ft() {
		return this.demDor40ft;
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
	 * @return detDor20ft
	 */
	public String getDetDor20ft() {
		return this.detDor20ft;
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
	 * @return detDor40ft
	 */
	public String getDetDor40ft() {
		return this.detDor40ft;
	}
	
	/**
	 * Column Info
	 * @return chgCostCyRtAmt
	 */
	public String getChgCostCyRtAmt() {
		return this.chgCostCyRtAmt;
	}
	
	/**
	 * Column Info
	 * @return detCy20ft
	 */
	public String getDetCy20ft() {
		return this.detCy20ft;
	}
	
	/**
	 * Column Info
	 * @return tmlCost20ftRtAmt
	 */
	public String getTmlCost20ftRtAmt() {
		return this.tmlCost20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrCostStkAmt
	 */
	public String getCntrCostStkAmt() {
		return this.cntrCostStkAmt;
	}

	/**
	 * Column Info
	 * @param cntrCostStkAmt
	 */
	public void setCntrCostStkAmt(String cntrCostStkAmt) {
		this.cntrCostStkAmt = cntrCostStkAmt;
	}

	/**
	 * Column Info
	 * @param cntrCost20ftRtAmt
	 */
	public void setCntrCost20ftRtAmt(String cntrCost20ftRtAmt) {
		this.cntrCost20ftRtAmt = cntrCost20ftRtAmt;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param ydExptCostSeq
	 */
	public void setYdExptCostSeq(String ydExptCostSeq) {
		this.ydExptCostSeq = ydExptCostSeq;
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
	 * @param demDor20ft
	 */
	public void setDemDor20ft(String demDor20ft) {
		this.demDor20ft = demDor20ft;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param otrCost20ftRtAmt
	 */
	public void setOtrCost20ftRtAmt(String otrCost20ftRtAmt) {
		this.otrCost20ftRtAmt = otrCost20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param demCy40ft
	 */
	public void setDemCy40ft(String demCy40ft) {
		this.demCy40ft = demCy40ft;
	}
	
	/**
	 * Column Info
	 * @param demCy20ft
	 */
	public void setDemCy20ft(String demCy20ft) {
		this.demCy20ft = demCy20ft;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chgCostDorRtAmt
	 */
	public void setChgCostDorRtAmt(String chgCostDorRtAmt) {
		this.chgCostDorRtAmt = chgCostDorRtAmt;
	}
	
	/**
	 * Column Info
	 * @param cfmUsrId
	 */
	public void setCfmUsrId(String cfmUsrId) {
		this.cfmUsrId = cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param demIbCltFlg
	 */
	public void setDemIbCltFlg(String demIbCltFlg) {
		this.demIbCltFlg = demIbCltFlg;
	}
	
	/**
	 * Column Info
	 * @param costSts
	 */
	public void setCostSts(String costSts) {
		this.costSts = costSts;
	}
	
	/**
	 * Column Info
	 * @param tmlCost40ftRtAmt
	 */
	public void setTmlCost40ftRtAmt(String tmlCost40ftRtAmt) {
		this.tmlCost40ftRtAmt = tmlCost40ftRtAmt;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntrCost40ftRtAmt
	 */
	public void setCntrCost40ftRtAmt(String cntrCost40ftRtAmt) {
		this.cntrCost40ftRtAmt = cntrCost40ftRtAmt;
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
	 * @param dmdtOfcCd
	 */
	public void setDmdtOfcCd(String dmdtOfcCd) {
		this.dmdtOfcCd = dmdtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
	}
	
	/**
	 * Column Info
	 * @param detCy40ft
	 */
	public void setDetCy40ft(String detCy40ft) {
		this.detCy40ft = detCy40ft;
	}
	
	/**
	 * Column Info
	 * @param dmdtCalcTpCd
	 */
	public void setDmdtCalcTpCd(String dmdtCalcTpCd) {
		this.dmdtCalcTpCd = dmdtCalcTpCd;
	}
	
	/**
	 * Column Info
	 * @param otrCost40ftRtAmt
	 */
	public void setOtrCost40ftRtAmt(String otrCost40ftRtAmt) {
		this.otrCost40ftRtAmt = otrCost40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param cfmOfcCd
	 */
	public void setCfmOfcCd(String cfmOfcCd) {
		this.cfmOfcCd = cfmOfcCd;
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
	 * @param demDor40ft
	 */
	public void setDemDor40ft(String demDor40ft) {
		this.demDor40ft = demDor40ft;
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
	 * @param detDor20ft
	 */
	public void setDetDor20ft(String detDor20ft) {
		this.detDor20ft = detDor20ft;
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
	 * @param detDor40ft
	 */
	public void setDetDor40ft(String detDor40ft) {
		this.detDor40ft = detDor40ft;
	}
	
	/**
	 * Column Info
	 * @param chgCostCyRtAmt
	 */
	public void setChgCostCyRtAmt(String chgCostCyRtAmt) {
		this.chgCostCyRtAmt = chgCostCyRtAmt;
	}
	
	/**
	 * Column Info
	 * @param detCy20ft
	 */
	public void setDetCy20ft(String detCy20ft) {
		this.detCy20ft = detCy20ft;
	}
	
	/**
	 * Column Info
	 * @param tmlCost20ftRtAmt
	 */
	public void setTmlCost20ftRtAmt(String tmlCost20ftRtAmt) {
		this.tmlCost20ftRtAmt = tmlCost20ftRtAmt;
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
		setCntrCost20ftRtAmt(JSPUtil.getParameter(request, prefix + "cntr_cost_20ft_rt_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setYdExptCostSeq(JSPUtil.getParameter(request, prefix + "yd_expt_cost_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDemDor20ft(JSPUtil.getParameter(request, prefix + "dem_dor_20ft", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setOtrCost20ftRtAmt(JSPUtil.getParameter(request, prefix + "otr_cost_20ft_rt_amt", ""));
		setDemCy40ft(JSPUtil.getParameter(request, prefix + "dem_cy_40ft", ""));
		setDemCy20ft(JSPUtil.getParameter(request, prefix + "dem_cy_20ft", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setChgCostDorRtAmt(JSPUtil.getParameter(request, prefix + "chg_cost_dor_rt_amt", ""));
		setCfmUsrId(JSPUtil.getParameter(request, prefix + "cfm_usr_id", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setDemIbCltFlg(JSPUtil.getParameter(request, prefix + "dem_ib_clt_flg", ""));
		setCostSts(JSPUtil.getParameter(request, prefix + "cost_sts", ""));
		setTmlCost40ftRtAmt(JSPUtil.getParameter(request, prefix + "tml_cost_40ft_rt_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setCntrCost40ftRtAmt(JSPUtil.getParameter(request, prefix + "cntr_cost_40ft_rt_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDmdtOfcCd(JSPUtil.getParameter(request, prefix + "dmdt_ofc_cd", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setDetCy40ft(JSPUtil.getParameter(request, prefix + "det_cy_40ft", ""));
		setDmdtCalcTpCd(JSPUtil.getParameter(request, prefix + "dmdt_calc_tp_cd", ""));
		setOtrCost40ftRtAmt(JSPUtil.getParameter(request, prefix + "otr_cost_40ft_rt_amt", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setCfmOfcCd(JSPUtil.getParameter(request, prefix + "cfm_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDemDor40ft(JSPUtil.getParameter(request, prefix + "dem_dor_40ft", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setDetDor20ft(JSPUtil.getParameter(request, prefix + "det_dor_20ft", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setDetDor40ft(JSPUtil.getParameter(request, prefix + "det_dor_40ft", ""));
		setChgCostCyRtAmt(JSPUtil.getParameter(request, prefix + "chg_cost_cy_rt_amt", ""));
		setDetCy20ft(JSPUtil.getParameter(request, prefix + "det_cy_20ft", ""));
		setTmlCost20ftRtAmt(JSPUtil.getParameter(request, prefix + "tml_cost_20ft_rt_amt", ""));
		setCntrCostStkAmt(JSPUtil.getParameter(request, prefix + "cntr_cost_stk_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtYdExptCostVO[]
	 */
	public DmtYdExptCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtYdExptCostVO[]
	 */
	public DmtYdExptCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtYdExptCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrCost20ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_cost_20ft_rt_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] ydExptCostSeq = (JSPUtil.getParameter(request, prefix	+ "yd_expt_cost_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] demDor20ft = (JSPUtil.getParameter(request, prefix	+ "dem_dor_20ft", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] otrCost20ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "otr_cost_20ft_rt_amt", length));
			String[] demCy40ft = (JSPUtil.getParameter(request, prefix	+ "dem_cy_40ft", length));
			String[] demCy20ft = (JSPUtil.getParameter(request, prefix	+ "dem_cy_20ft", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] chgCostDorRtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_cost_dor_rt_amt", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] demIbCltFlg = (JSPUtil.getParameter(request, prefix	+ "dem_ib_clt_flg", length));
			String[] costSts = (JSPUtil.getParameter(request, prefix	+ "cost_sts", length));
			String[] tmlCost40ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "tml_cost_40ft_rt_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] cntrCost40ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_cost_40ft_rt_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dmdtOfcCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ofc_cd", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] detCy40ft = (JSPUtil.getParameter(request, prefix	+ "det_cy_40ft", length));
			String[] dmdtCalcTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_calc_tp_cd", length));
			String[] otrCost40ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "otr_cost_40ft_rt_amt", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] cfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "cfm_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] demDor40ft = (JSPUtil.getParameter(request, prefix	+ "dem_dor_40ft", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] detDor20ft = (JSPUtil.getParameter(request, prefix	+ "det_dor_20ft", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] detDor40ft = (JSPUtil.getParameter(request, prefix	+ "det_dor_40ft", length));
			String[] chgCostCyRtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_cost_cy_rt_amt", length));
			String[] detCy20ft = (JSPUtil.getParameter(request, prefix	+ "det_cy_20ft", length));
			String[] tmlCost20ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "tml_cost_20ft_rt_amt", length));
			String[] cntrCostStkAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_cost_stk_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtYdExptCostVO();
				if (cntrCost20ftRtAmt[i] != null)
					model.setCntrCost20ftRtAmt(cntrCost20ftRtAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (ydExptCostSeq[i] != null)
					model.setYdExptCostSeq(ydExptCostSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (demDor20ft[i] != null)
					model.setDemDor20ft(demDor20ft[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (otrCost20ftRtAmt[i] != null)
					model.setOtrCost20ftRtAmt(otrCost20ftRtAmt[i]);
				if (demCy40ft[i] != null)
					model.setDemCy40ft(demCy40ft[i]);
				if (demCy20ft[i] != null)
					model.setDemCy20ft(demCy20ft[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (chgCostDorRtAmt[i] != null)
					model.setChgCostDorRtAmt(chgCostDorRtAmt[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (demIbCltFlg[i] != null)
					model.setDemIbCltFlg(demIbCltFlg[i]);
				if (costSts[i] != null)
					model.setCostSts(costSts[i]);
				if (tmlCost40ftRtAmt[i] != null)
					model.setTmlCost40ftRtAmt(tmlCost40ftRtAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (cntrCost40ftRtAmt[i] != null)
					model.setCntrCost40ftRtAmt(cntrCost40ftRtAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dmdtOfcCd[i] != null)
					model.setDmdtOfcCd(dmdtOfcCd[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (detCy40ft[i] != null)
					model.setDetCy40ft(detCy40ft[i]);
				if (dmdtCalcTpCd[i] != null)
					model.setDmdtCalcTpCd(dmdtCalcTpCd[i]);
				if (otrCost40ftRtAmt[i] != null)
					model.setOtrCost40ftRtAmt(otrCost40ftRtAmt[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (cfmOfcCd[i] != null)
					model.setCfmOfcCd(cfmOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (demDor40ft[i] != null)
					model.setDemDor40ft(demDor40ft[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (detDor20ft[i] != null)
					model.setDetDor20ft(detDor20ft[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (detDor40ft[i] != null)
					model.setDetDor40ft(detDor40ft[i]);
				if (chgCostCyRtAmt[i] != null)
					model.setChgCostCyRtAmt(chgCostCyRtAmt[i]);
				if (detCy20ft[i] != null)
					model.setDetCy20ft(detCy20ft[i]);
				if (tmlCost20ftRtAmt[i] != null)
					model.setTmlCost20ftRtAmt(tmlCost20ftRtAmt[i]);
				if (cntrCostStkAmt[i] != null)
					model.setCntrCostStkAmt(cntrCostStkAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtYdExptCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtYdExptCostVO[]
	 */
	public DmtYdExptCostVO[] getDmtYdExptCostVOs(){
		DmtYdExptCostVO[] vos = (DmtYdExptCostVO[])models.toArray(new DmtYdExptCostVO[models.size()]);
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
		this.cntrCost20ftRtAmt = this.cntrCost20ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydExptCostSeq = this.ydExptCostSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demDor20ft = this.demDor20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrCost20ftRtAmt = this.otrCost20ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demCy40ft = this.demCy40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demCy20ft = this.demCy20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCostDorRtAmt = this.chgCostDorRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demIbCltFlg = this.demIbCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSts = this.costSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCost40ftRtAmt = this.tmlCost40ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCost40ftRtAmt = this.cntrCost40ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtOfcCd = this.dmdtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detCy40ft = this.detCy40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCalcTpCd = this.dmdtCalcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrCost40ftRtAmt = this.otrCost40ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmOfcCd = this.cfmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demDor40ft = this.demDor40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detDor20ft = this.detDor20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detDor40ft = this.detDor40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCostCyRtAmt = this.chgCostCyRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detCy20ft = this.detCy20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCost20ftRtAmt = this.tmlCost20ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCostStkAmt = this.cntrCostStkAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}