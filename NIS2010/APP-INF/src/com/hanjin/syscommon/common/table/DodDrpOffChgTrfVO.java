/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DodDrpOffChgTrfVO.java
*@FileTitle : DodDrpOffChgTrfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.28 손진환 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 손진환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DodDrpOffChgTrfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DodDrpOffChgTrfVO> models = new ArrayList<DodDrpOffChgTrfVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String spclCustCntCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String drpOffChgTrfSeq = null;
	/* Column Info */
	private String drpOffChgTrfExpDt = null;
	/* Column Info */
	private String cntrRtnYdSfxCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String drpOffChgTrfCfmDt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String drpOffChgTrfRmk = null;
	/* Column Info */
	private String drpOffChgTrfExptFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String drpOffChgTrfEffDt = null;
	/* Column Info */
	private String drpOffChgTrfAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String drpOffChgTrfExpFlg = null;
	/* Column Info */
	private String drpOffChgTrfCfmFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String drpOffChgTrfCntCd = null;
	/* Column Info */
	private String polContiCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String spclCustSeq = null;
	/* Column Info */
	private String cntrRtnLocCd = null;
	/* Column Info */
	private String drpOffChgTrfDivCd = null;
	/* Column Info */
	private String drpOffChgTrfCfmUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DodDrpOffChgTrfVO() {}

	public DodDrpOffChgTrfVO(String ibflag, String pagerows, String drpOffChgTrfSeq, String drpOffChgTrfDivCd, String drpOffChgTrfCntCd, String drpOffChgTrfEffDt, String drpOffChgTrfExpDt, String drpOffChgTrfExpFlg, String delCd, String cntrRtnLocCd, String cntrRtnYdSfxCd, String polContiCd, String cntrTpszCd, String currCd, String spclCustCntCd, String spclCustSeq, String drpOffChgTrfAmt, String drpOffChgTrfExptFlg, String drpOffChgTrfCfmUsrId, String drpOffChgTrfCfmDt, String drpOffChgTrfCfmFlg, String drpOffChgTrfRmk, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.currCd = currCd;
		this.deltFlg = deltFlg;
		this.spclCustCntCd = spclCustCntCd;
		this.creDt = creDt;
		this.drpOffChgTrfSeq = drpOffChgTrfSeq;
		this.drpOffChgTrfExpDt = drpOffChgTrfExpDt;
		this.cntrRtnYdSfxCd = cntrRtnYdSfxCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.drpOffChgTrfCfmDt = drpOffChgTrfCfmDt;
		this.cntrTpszCd = cntrTpszCd;
		this.drpOffChgTrfRmk = drpOffChgTrfRmk;
		this.drpOffChgTrfExptFlg = drpOffChgTrfExptFlg;
		this.updUsrId = updUsrId;
		this.drpOffChgTrfEffDt = drpOffChgTrfEffDt;
		this.drpOffChgTrfAmt = drpOffChgTrfAmt;
		this.updDt = updDt;
		this.drpOffChgTrfExpFlg = drpOffChgTrfExpFlg;
		this.drpOffChgTrfCfmFlg = drpOffChgTrfCfmFlg;
		this.delCd = delCd;
		this.drpOffChgTrfCntCd = drpOffChgTrfCntCd;
		this.polContiCd = polContiCd;
		this.creUsrId = creUsrId;
		this.spclCustSeq = spclCustSeq;
		this.cntrRtnLocCd = cntrRtnLocCd;
		this.drpOffChgTrfDivCd = drpOffChgTrfDivCd;
		this.drpOffChgTrfCfmUsrId = drpOffChgTrfCfmUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("spcl_cust_cnt_cd", getSpclCustCntCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("drp_off_chg_trf_seq", getDrpOffChgTrfSeq());
		this.hashColumns.put("drp_off_chg_trf_exp_dt", getDrpOffChgTrfExpDt());
		this.hashColumns.put("cntr_rtn_yd_sfx_cd", getCntrRtnYdSfxCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("drp_off_chg_trf_cfm_dt", getDrpOffChgTrfCfmDt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("drp_off_chg_trf_rmk", getDrpOffChgTrfRmk());
		this.hashColumns.put("drp_off_chg_trf_expt_flg", getDrpOffChgTrfExptFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("drp_off_chg_trf_eff_dt", getDrpOffChgTrfEffDt());
		this.hashColumns.put("drp_off_chg_trf_amt", getDrpOffChgTrfAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("drp_off_chg_trf_exp_flg", getDrpOffChgTrfExpFlg());
		this.hashColumns.put("drp_off_chg_trf_cfm_flg", getDrpOffChgTrfCfmFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("drp_off_chg_trf_cnt_cd", getDrpOffChgTrfCntCd());
		this.hashColumns.put("pol_conti_cd", getPolContiCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("spcl_cust_seq", getSpclCustSeq());
		this.hashColumns.put("cntr_rtn_loc_cd", getCntrRtnLocCd());
		this.hashColumns.put("drp_off_chg_trf_div_cd", getDrpOffChgTrfDivCd());
		this.hashColumns.put("drp_off_chg_trf_cfm_usr_id", getDrpOffChgTrfCfmUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("spcl_cust_cnt_cd", "spclCustCntCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("drp_off_chg_trf_seq", "drpOffChgTrfSeq");
		this.hashFields.put("drp_off_chg_trf_exp_dt", "drpOffChgTrfExpDt");
		this.hashFields.put("cntr_rtn_yd_sfx_cd", "cntrRtnYdSfxCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("drp_off_chg_trf_cfm_dt", "drpOffChgTrfCfmDt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("drp_off_chg_trf_rmk", "drpOffChgTrfRmk");
		this.hashFields.put("drp_off_chg_trf_expt_flg", "drpOffChgTrfExptFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("drp_off_chg_trf_eff_dt", "drpOffChgTrfEffDt");
		this.hashFields.put("drp_off_chg_trf_amt", "drpOffChgTrfAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("drp_off_chg_trf_exp_flg", "drpOffChgTrfExpFlg");
		this.hashFields.put("drp_off_chg_trf_cfm_flg", "drpOffChgTrfCfmFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("drp_off_chg_trf_cnt_cd", "drpOffChgTrfCntCd");
		this.hashFields.put("pol_conti_cd", "polContiCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("spcl_cust_seq", "spclCustSeq");
		this.hashFields.put("cntr_rtn_loc_cd", "cntrRtnLocCd");
		this.hashFields.put("drp_off_chg_trf_div_cd", "drpOffChgTrfDivCd");
		this.hashFields.put("drp_off_chg_trf_cfm_usr_id", "drpOffChgTrfCfmUsrId");
		return this.hashFields;
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
	 * @return spclCustCntCd
	 */
	public String getSpclCustCntCd() {
		return this.spclCustCntCd;
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
	 * @return drpOffChgTrfSeq
	 */
	public String getDrpOffChgTrfSeq() {
		return this.drpOffChgTrfSeq;
	}
	
	/**
	 * Column Info
	 * @return drpOffChgTrfExpDt
	 */
	public String getDrpOffChgTrfExpDt() {
		return this.drpOffChgTrfExpDt;
	}
	
	/**
	 * Column Info
	 * @return cntrRtnYdSfxCd
	 */
	public String getCntrRtnYdSfxCd() {
		return this.cntrRtnYdSfxCd;
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
	 * @return drpOffChgTrfCfmDt
	 */
	public String getDrpOffChgTrfCfmDt() {
		return this.drpOffChgTrfCfmDt;
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
	 * @return drpOffChgTrfRmk
	 */
	public String getDrpOffChgTrfRmk() {
		return this.drpOffChgTrfRmk;
	}
	
	/**
	 * Column Info
	 * @return drpOffChgTrfExptFlg
	 */
	public String getDrpOffChgTrfExptFlg() {
		return this.drpOffChgTrfExptFlg;
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
	 * @return drpOffChgTrfEffDt
	 */
	public String getDrpOffChgTrfEffDt() {
		return this.drpOffChgTrfEffDt;
	}
	
	/**
	 * Column Info
	 * @return drpOffChgTrfAmt
	 */
	public String getDrpOffChgTrfAmt() {
		return this.drpOffChgTrfAmt;
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
	 * @return drpOffChgTrfExpFlg
	 */
	public String getDrpOffChgTrfExpFlg() {
		return this.drpOffChgTrfExpFlg;
	}
	
	/**
	 * Column Info
	 * @return drpOffChgTrfCfmFlg
	 */
	public String getDrpOffChgTrfCfmFlg() {
		return this.drpOffChgTrfCfmFlg;
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
	 * @return drpOffChgTrfCntCd
	 */
	public String getDrpOffChgTrfCntCd() {
		return this.drpOffChgTrfCntCd;
	}
	
	/**
	 * Column Info
	 * @return polContiCd
	 */
	public String getPolContiCd() {
		return this.polContiCd;
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
	 * @return spclCustSeq
	 */
	public String getSpclCustSeq() {
		return this.spclCustSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrRtnLocCd
	 */
	public String getCntrRtnLocCd() {
		return this.cntrRtnLocCd;
	}
	
	/**
	 * Column Info
	 * @return drpOffChgTrfDivCd
	 */
	public String getDrpOffChgTrfDivCd() {
		return this.drpOffChgTrfDivCd;
	}
	
	/**
	 * Column Info
	 * @return drpOffChgTrfCfmUsrId
	 */
	public String getDrpOffChgTrfCfmUsrId() {
		return this.drpOffChgTrfCfmUsrId;
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
	 * @param spclCustCntCd
	 */
	public void setSpclCustCntCd(String spclCustCntCd) {
		this.spclCustCntCd = spclCustCntCd;
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
	 * @param drpOffChgTrfSeq
	 */
	public void setDrpOffChgTrfSeq(String drpOffChgTrfSeq) {
		this.drpOffChgTrfSeq = drpOffChgTrfSeq;
	}
	
	/**
	 * Column Info
	 * @param drpOffChgTrfExpDt
	 */
	public void setDrpOffChgTrfExpDt(String drpOffChgTrfExpDt) {
		this.drpOffChgTrfExpDt = drpOffChgTrfExpDt;
	}
	
	/**
	 * Column Info
	 * @param cntrRtnYdSfxCd
	 */
	public void setCntrRtnYdSfxCd(String cntrRtnYdSfxCd) {
		this.cntrRtnYdSfxCd = cntrRtnYdSfxCd;
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
	 * @param drpOffChgTrfCfmDt
	 */
	public void setDrpOffChgTrfCfmDt(String drpOffChgTrfCfmDt) {
		this.drpOffChgTrfCfmDt = drpOffChgTrfCfmDt;
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
	 * @param drpOffChgTrfRmk
	 */
	public void setDrpOffChgTrfRmk(String drpOffChgTrfRmk) {
		this.drpOffChgTrfRmk = drpOffChgTrfRmk;
	}
	
	/**
	 * Column Info
	 * @param drpOffChgTrfExptFlg
	 */
	public void setDrpOffChgTrfExptFlg(String drpOffChgTrfExptFlg) {
		this.drpOffChgTrfExptFlg = drpOffChgTrfExptFlg;
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
	 * @param drpOffChgTrfEffDt
	 */
	public void setDrpOffChgTrfEffDt(String drpOffChgTrfEffDt) {
		this.drpOffChgTrfEffDt = drpOffChgTrfEffDt;
	}
	
	/**
	 * Column Info
	 * @param drpOffChgTrfAmt
	 */
	public void setDrpOffChgTrfAmt(String drpOffChgTrfAmt) {
		this.drpOffChgTrfAmt = drpOffChgTrfAmt;
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
	 * @param drpOffChgTrfExpFlg
	 */
	public void setDrpOffChgTrfExpFlg(String drpOffChgTrfExpFlg) {
		this.drpOffChgTrfExpFlg = drpOffChgTrfExpFlg;
	}
	
	/**
	 * Column Info
	 * @param drpOffChgTrfCfmFlg
	 */
	public void setDrpOffChgTrfCfmFlg(String drpOffChgTrfCfmFlg) {
		this.drpOffChgTrfCfmFlg = drpOffChgTrfCfmFlg;
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
	 * @param drpOffChgTrfCntCd
	 */
	public void setDrpOffChgTrfCntCd(String drpOffChgTrfCntCd) {
		this.drpOffChgTrfCntCd = drpOffChgTrfCntCd;
	}
	
	/**
	 * Column Info
	 * @param polContiCd
	 */
	public void setPolContiCd(String polContiCd) {
		this.polContiCd = polContiCd;
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
	 * @param spclCustSeq
	 */
	public void setSpclCustSeq(String spclCustSeq) {
		this.spclCustSeq = spclCustSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrRtnLocCd
	 */
	public void setCntrRtnLocCd(String cntrRtnLocCd) {
		this.cntrRtnLocCd = cntrRtnLocCd;
	}
	
	/**
	 * Column Info
	 * @param drpOffChgTrfDivCd
	 */
	public void setDrpOffChgTrfDivCd(String drpOffChgTrfDivCd) {
		this.drpOffChgTrfDivCd = drpOffChgTrfDivCd;
	}
	
	/**
	 * Column Info
	 * @param drpOffChgTrfCfmUsrId
	 */
	public void setDrpOffChgTrfCfmUsrId(String drpOffChgTrfCfmUsrId) {
		this.drpOffChgTrfCfmUsrId = drpOffChgTrfCfmUsrId;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setSpclCustCntCd(JSPUtil.getParameter(request, prefix + "spcl_cust_cnt_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDrpOffChgTrfSeq(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_seq", ""));
		setDrpOffChgTrfExpDt(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_exp_dt", ""));
		setCntrRtnYdSfxCd(JSPUtil.getParameter(request, prefix + "cntr_rtn_yd_sfx_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDrpOffChgTrfCfmDt(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_cfm_dt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDrpOffChgTrfRmk(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_rmk", ""));
		setDrpOffChgTrfExptFlg(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_expt_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDrpOffChgTrfEffDt(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_eff_dt", ""));
		setDrpOffChgTrfAmt(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDrpOffChgTrfExpFlg(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_exp_flg", ""));
		setDrpOffChgTrfCfmFlg(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_cfm_flg", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setDrpOffChgTrfCntCd(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_cnt_cd", ""));
		setPolContiCd(JSPUtil.getParameter(request, prefix + "pol_conti_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSpclCustSeq(JSPUtil.getParameter(request, prefix + "spcl_cust_seq", ""));
		setCntrRtnLocCd(JSPUtil.getParameter(request, prefix + "cntr_rtn_loc_cd", ""));
		setDrpOffChgTrfDivCd(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_div_cd", ""));
		setDrpOffChgTrfCfmUsrId(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_cfm_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DodDrpOffChgTrfVO[]
	 */
	public DodDrpOffChgTrfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DodDrpOffChgTrfVO[]
	 */
	public DodDrpOffChgTrfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DodDrpOffChgTrfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] spclCustCntCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cust_cnt_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] drpOffChgTrfSeq = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_seq", length));
			String[] drpOffChgTrfExpDt = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_exp_dt", length));
			String[] cntrRtnYdSfxCd = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_yd_sfx_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] drpOffChgTrfCfmDt = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_cfm_dt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] drpOffChgTrfRmk = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_rmk", length));
			String[] drpOffChgTrfExptFlg = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_expt_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] drpOffChgTrfEffDt = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_eff_dt", length));
			String[] drpOffChgTrfAmt = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] drpOffChgTrfExpFlg = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_exp_flg", length));
			String[] drpOffChgTrfCfmFlg = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_cfm_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] drpOffChgTrfCntCd = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_cnt_cd", length));
			String[] polContiCd = (JSPUtil.getParameter(request, prefix	+ "pol_conti_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] spclCustSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cust_seq", length));
			String[] cntrRtnLocCd = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_loc_cd", length));
			String[] drpOffChgTrfDivCd = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_div_cd", length));
			String[] drpOffChgTrfCfmUsrId = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_cfm_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new DodDrpOffChgTrfVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (spclCustCntCd[i] != null)
					model.setSpclCustCntCd(spclCustCntCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (drpOffChgTrfSeq[i] != null)
					model.setDrpOffChgTrfSeq(drpOffChgTrfSeq[i]);
				if (drpOffChgTrfExpDt[i] != null)
					model.setDrpOffChgTrfExpDt(drpOffChgTrfExpDt[i]);
				if (cntrRtnYdSfxCd[i] != null)
					model.setCntrRtnYdSfxCd(cntrRtnYdSfxCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (drpOffChgTrfCfmDt[i] != null)
					model.setDrpOffChgTrfCfmDt(drpOffChgTrfCfmDt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (drpOffChgTrfRmk[i] != null)
					model.setDrpOffChgTrfRmk(drpOffChgTrfRmk[i]);
				if (drpOffChgTrfExptFlg[i] != null)
					model.setDrpOffChgTrfExptFlg(drpOffChgTrfExptFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (drpOffChgTrfEffDt[i] != null)
					model.setDrpOffChgTrfEffDt(drpOffChgTrfEffDt[i]);
				if (drpOffChgTrfAmt[i] != null)
					model.setDrpOffChgTrfAmt(drpOffChgTrfAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (drpOffChgTrfExpFlg[i] != null)
					model.setDrpOffChgTrfExpFlg(drpOffChgTrfExpFlg[i]);
				if (drpOffChgTrfCfmFlg[i] != null)
					model.setDrpOffChgTrfCfmFlg(drpOffChgTrfCfmFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (drpOffChgTrfCntCd[i] != null)
					model.setDrpOffChgTrfCntCd(drpOffChgTrfCntCd[i]);
				if (polContiCd[i] != null)
					model.setPolContiCd(polContiCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (spclCustSeq[i] != null)
					model.setSpclCustSeq(spclCustSeq[i]);
				if (cntrRtnLocCd[i] != null)
					model.setCntrRtnLocCd(cntrRtnLocCd[i]);
				if (drpOffChgTrfDivCd[i] != null)
					model.setDrpOffChgTrfDivCd(drpOffChgTrfDivCd[i]);
				if (drpOffChgTrfCfmUsrId[i] != null)
					model.setDrpOffChgTrfCfmUsrId(drpOffChgTrfCfmUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDodDrpOffChgTrfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DodDrpOffChgTrfVO[]
	 */
	public DodDrpOffChgTrfVO[] getDodDrpOffChgTrfVOs(){
		DodDrpOffChgTrfVO[] vos = (DodDrpOffChgTrfVO[])models.toArray(new DodDrpOffChgTrfVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustCntCd = this.spclCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfSeq = this.drpOffChgTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfExpDt = this.drpOffChgTrfExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnYdSfxCd = this.cntrRtnYdSfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfCfmDt = this.drpOffChgTrfCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfRmk = this.drpOffChgTrfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfExptFlg = this.drpOffChgTrfExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfEffDt = this.drpOffChgTrfEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfAmt = this.drpOffChgTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfExpFlg = this.drpOffChgTrfExpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfCfmFlg = this.drpOffChgTrfCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfCntCd = this.drpOffChgTrfCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polContiCd = this.polContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustSeq = this.spclCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnLocCd = this.cntrRtnLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfDivCd = this.drpOffChgTrfDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfCfmUsrId = this.drpOffChgTrfCfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
