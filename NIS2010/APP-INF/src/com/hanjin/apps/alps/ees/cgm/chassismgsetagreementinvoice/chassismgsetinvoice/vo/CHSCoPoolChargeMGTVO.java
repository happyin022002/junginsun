/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSCoPoolChargeMGTVO.java
*@FileTitle : CHSCoPoolChargeMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.09.24 김창식 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김창식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSCoPoolChargeMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSCoPoolChargeMGTVO> models = new ArrayList<CHSCoPoolChargeMGTVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String payInvSeq = null;
	/* Column Info */
	private String dtlPoolCostItmCd = null;
	/* Column Info */
	private String intgCdValDpDesc = null;
	/* Column Info */
	private String costChssQty = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String costAmt = null;
	/* Column Info */
	private String poolBsrtAmt = null;
	/* Column Info */
	private String chssMgstInvStsCd = null;
	/* Column Info */
	private String actionflag = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String invUsrId = null;
	/* Column Info */
	private String chssMgstInvKndCd = null;
	/* Column Info */
	private String costBilDys = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String chgSmryAmt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String invSmryAmt = null;
	/* Column Info */
	private String agmtVerNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSCoPoolChargeMGTVO() {}

	public CHSCoPoolChargeMGTVO(String ibflag, String pagerows, String actionflag, String costBilDys, String chssMgstInvKndCd, String costOfcCd, String chssPoolCd, String dtlPoolCostItmCd, String payInvSeq, String intgCdValDpDesc, String costChssQty, String agmtOfcCtyCd, String agmtSeq, String agmtVerNo, String eqKndCd, String invNo, String creUsrId, String costYrmon, String costCd, String diffRmk, String costAmt, String vndrSeq, String vndrLglEngNm, String poolBsrtAmt, String chssMgstInvStsCd, String updUsrId, String invDt, String invUsrId, String currCd, String chgSmryAmt, String invSmryAmt) {
		this.currCd = currCd;
		this.chssPoolCd = chssPoolCd;
		this.payInvSeq = payInvSeq;
		this.dtlPoolCostItmCd = dtlPoolCostItmCd;
		this.intgCdValDpDesc = intgCdValDpDesc;
		this.costChssQty = costChssQty;
		this.vndrLglEngNm = vndrLglEngNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.costCd = costCd;
		this.costAmt = costAmt;
		this.poolBsrtAmt = poolBsrtAmt;
		this.chssMgstInvStsCd = chssMgstInvStsCd;
		this.actionflag = actionflag;
		this.updUsrId = updUsrId;
		this.invDt = invDt;
		this.invUsrId = invUsrId;
		this.chssMgstInvKndCd = chssMgstInvKndCd;
		this.costBilDys = costBilDys;
		this.costOfcCd = costOfcCd;
		this.agmtSeq = agmtSeq;
		this.eqKndCd = eqKndCd;
		this.chgSmryAmt = chgSmryAmt;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.diffRmk = diffRmk;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.vndrSeq = vndrSeq;
		this.invSmryAmt = invSmryAmt;
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("pay_inv_seq", getPayInvSeq());
		this.hashColumns.put("dtl_pool_cost_itm_cd", getDtlPoolCostItmCd());
		this.hashColumns.put("intg_cd_val_dp_desc", getIntgCdValDpDesc());
		this.hashColumns.put("cost_chss_qty", getCostChssQty());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("cost_amt", getCostAmt());
		this.hashColumns.put("pool_bsrt_amt", getPoolBsrtAmt());
		this.hashColumns.put("chss_mgst_inv_sts_cd", getChssMgstInvStsCd());
		this.hashColumns.put("actionflag", getActionflag());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("inv_usr_id", getInvUsrId());
		this.hashColumns.put("chss_mgst_inv_knd_cd", getChssMgstInvKndCd());
		this.hashColumns.put("cost_bil_dys", getCostBilDys());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("chg_smry_amt", getChgSmryAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("inv_smry_amt", getInvSmryAmt());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("pay_inv_seq", "payInvSeq");
		this.hashFields.put("dtl_pool_cost_itm_cd", "dtlPoolCostItmCd");
		this.hashFields.put("intg_cd_val_dp_desc", "intgCdValDpDesc");
		this.hashFields.put("cost_chss_qty", "costChssQty");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("pool_bsrt_amt", "poolBsrtAmt");
		this.hashFields.put("chss_mgst_inv_sts_cd", "chssMgstInvStsCd");
		this.hashFields.put("actionflag", "actionflag");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("inv_usr_id", "invUsrId");
		this.hashFields.put("chss_mgst_inv_knd_cd", "chssMgstInvKndCd");
		this.hashFields.put("cost_bil_dys", "costBilDys");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("chg_smry_amt", "chgSmryAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("inv_smry_amt", "invSmryAmt");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
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
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return payInvSeq
	 */
	public String getPayInvSeq() {
		return this.payInvSeq;
	}
	
	/**
	 * Column Info
	 * @return dtlPoolCostItmCd
	 */
	public String getDtlPoolCostItmCd() {
		return this.dtlPoolCostItmCd;
	}
	
	/**
	 * Column Info
	 * @return intgCdValDpDesc
	 */
	public String getIntgCdValDpDesc() {
		return this.intgCdValDpDesc;
	}
	
	/**
	 * Column Info
	 * @return costChssQty
	 */
	public String getCostChssQty() {
		return this.costChssQty;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return costAmt
	 */
	public String getCostAmt() {
		return this.costAmt;
	}
	
	/**
	 * Column Info
	 * @return poolBsrtAmt
	 */
	public String getPoolBsrtAmt() {
		return this.poolBsrtAmt;
	}
	
	/**
	 * Column Info
	 * @return chssMgstInvStsCd
	 */
	public String getChssMgstInvStsCd() {
		return this.chssMgstInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return actionflag
	 */
	public String getActionflag() {
		return this.actionflag;
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
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
	}
	
	/**
	 * Column Info
	 * @return invUsrId
	 */
	public String getInvUsrId() {
		return this.invUsrId;
	}
	
	/**
	 * Column Info
	 * @return chssMgstInvKndCd
	 */
	public String getChssMgstInvKndCd() {
		return this.chssMgstInvKndCd;
	}
	
	/**
	 * Column Info
	 * @return costBilDys
	 */
	public String getCostBilDys() {
		return this.costBilDys;
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
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return chgSmryAmt
	 */
	public String getChgSmryAmt() {
		return this.chgSmryAmt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
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
	 * @return invSmryAmt
	 */
	public String getInvSmryAmt() {
		return this.invSmryAmt;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param payInvSeq
	 */
	public void setPayInvSeq(String payInvSeq) {
		this.payInvSeq = payInvSeq;
	}
	
	/**
	 * Column Info
	 * @param dtlPoolCostItmCd
	 */
	public void setDtlPoolCostItmCd(String dtlPoolCostItmCd) {
		this.dtlPoolCostItmCd = dtlPoolCostItmCd;
	}
	
	/**
	 * Column Info
	 * @param intgCdValDpDesc
	 */
	public void setIntgCdValDpDesc(String intgCdValDpDesc) {
		this.intgCdValDpDesc = intgCdValDpDesc;
	}
	
	/**
	 * Column Info
	 * @param costChssQty
	 */
	public void setCostChssQty(String costChssQty) {
		this.costChssQty = costChssQty;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param costAmt
	 */
	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
	}
	
	/**
	 * Column Info
	 * @param poolBsrtAmt
	 */
	public void setPoolBsrtAmt(String poolBsrtAmt) {
		this.poolBsrtAmt = poolBsrtAmt;
	}
	
	/**
	 * Column Info
	 * @param chssMgstInvStsCd
	 */
	public void setChssMgstInvStsCd(String chssMgstInvStsCd) {
		this.chssMgstInvStsCd = chssMgstInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param actionflag
	 */
	public void setActionflag(String actionflag) {
		this.actionflag = actionflag;
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
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
	}
	
	/**
	 * Column Info
	 * @param invUsrId
	 */
	public void setInvUsrId(String invUsrId) {
		this.invUsrId = invUsrId;
	}
	
	/**
	 * Column Info
	 * @param chssMgstInvKndCd
	 */
	public void setChssMgstInvKndCd(String chssMgstInvKndCd) {
		this.chssMgstInvKndCd = chssMgstInvKndCd;
	}
	
	/**
	 * Column Info
	 * @param costBilDys
	 */
	public void setCostBilDys(String costBilDys) {
		this.costBilDys = costBilDys;
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
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param chgSmryAmt
	 */
	public void setChgSmryAmt(String chgSmryAmt) {
		this.chgSmryAmt = chgSmryAmt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
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
	 * @param invSmryAmt
	 */
	public void setInvSmryAmt(String invSmryAmt) {
		this.invSmryAmt = invSmryAmt;
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
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setPayInvSeq(JSPUtil.getParameter(request, "pay_inv_seq", ""));
		setDtlPoolCostItmCd(JSPUtil.getParameter(request, "dtl_pool_cost_itm_cd", ""));
		setIntgCdValDpDesc(JSPUtil.getParameter(request, "intg_cd_val_dp_desc", ""));
		setCostChssQty(JSPUtil.getParameter(request, "cost_chss_qty", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
		setCostAmt(JSPUtil.getParameter(request, "cost_amt", ""));
		setPoolBsrtAmt(JSPUtil.getParameter(request, "pool_bsrt_amt", ""));
		setChssMgstInvStsCd(JSPUtil.getParameter(request, "chss_mgst_inv_sts_cd", ""));
		setActionflag(JSPUtil.getParameter(request, "actionflag", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setInvDt(JSPUtil.getParameter(request, "inv_dt", ""));
		setInvUsrId(JSPUtil.getParameter(request, "inv_usr_id", ""));
		setChssMgstInvKndCd(JSPUtil.getParameter(request, "chss_mgst_inv_knd_cd", ""));
		setCostBilDys(JSPUtil.getParameter(request, "cost_bil_dys", ""));
		setCostOfcCd(JSPUtil.getParameter(request, "cost_ofc_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setChgSmryAmt(JSPUtil.getParameter(request, "chg_smry_amt", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setInvSmryAmt(JSPUtil.getParameter(request, "inv_smry_amt", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSCoPoolChargeMGTVO[]
	 */
	public CHSCoPoolChargeMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSCoPoolChargeMGTVO[]
	 */
	public CHSCoPoolChargeMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSCoPoolChargeMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] payInvSeq = (JSPUtil.getParameter(request, prefix	+ "pay_inv_seq", length));
			String[] dtlPoolCostItmCd = (JSPUtil.getParameter(request, prefix	+ "dtl_pool_cost_itm_cd", length));
			String[] intgCdValDpDesc = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_dp_desc", length));
			String[] costChssQty = (JSPUtil.getParameter(request, prefix	+ "cost_chss_qty", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] costAmt = (JSPUtil.getParameter(request, prefix	+ "cost_amt", length));
			String[] poolBsrtAmt = (JSPUtil.getParameter(request, prefix	+ "pool_bsrt_amt", length));
			String[] chssMgstInvStsCd = (JSPUtil.getParameter(request, prefix	+ "chss_mgst_inv_sts_cd", length));
			String[] actionflag = (JSPUtil.getParameter(request, prefix	+ "actionflag", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] invUsrId = (JSPUtil.getParameter(request, prefix	+ "inv_usr_id", length));
			String[] chssMgstInvKndCd = (JSPUtil.getParameter(request, prefix	+ "chss_mgst_inv_knd_cd", length));
			String[] costBilDys = (JSPUtil.getParameter(request, prefix	+ "cost_bil_dys", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] chgSmryAmt = (JSPUtil.getParameter(request, prefix	+ "chg_smry_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] invSmryAmt = (JSPUtil.getParameter(request, prefix	+ "inv_smry_amt", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSCoPoolChargeMGTVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (payInvSeq[i] != null)
					model.setPayInvSeq(payInvSeq[i]);
				if (dtlPoolCostItmCd[i] != null)
					model.setDtlPoolCostItmCd(dtlPoolCostItmCd[i]);
				if (intgCdValDpDesc[i] != null)
					model.setIntgCdValDpDesc(intgCdValDpDesc[i]);
				if (costChssQty[i] != null)
					model.setCostChssQty(costChssQty[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (costAmt[i] != null)
					model.setCostAmt(costAmt[i]);
				if (poolBsrtAmt[i] != null)
					model.setPoolBsrtAmt(poolBsrtAmt[i]);
				if (chssMgstInvStsCd[i] != null)
					model.setChssMgstInvStsCd(chssMgstInvStsCd[i]);
				if (actionflag[i] != null)
					model.setActionflag(actionflag[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (invUsrId[i] != null)
					model.setInvUsrId(invUsrId[i]);
				if (chssMgstInvKndCd[i] != null)
					model.setChssMgstInvKndCd(chssMgstInvKndCd[i]);
				if (costBilDys[i] != null)
					model.setCostBilDys(costBilDys[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (chgSmryAmt[i] != null)
					model.setChgSmryAmt(chgSmryAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (invSmryAmt[i] != null)
					model.setInvSmryAmt(invSmryAmt[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSCoPoolChargeMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSCoPoolChargeMGTVO[]
	 */
	public CHSCoPoolChargeMGTVO[] getCHSCoPoolChargeMGTVOs(){
		CHSCoPoolChargeMGTVO[] vos = (CHSCoPoolChargeMGTVO[])models.toArray(new CHSCoPoolChargeMGTVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payInvSeq = this.payInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlPoolCostItmCd = this.dtlPoolCostItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValDpDesc = this.intgCdValDpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costChssQty = this.costChssQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt = this.costAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolBsrtAmt = this.poolBsrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMgstInvStsCd = this.chssMgstInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actionflag = this.actionflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsrId = this.invUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMgstInvKndCd = this.chssMgstInvKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costBilDys = this.costBilDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSmryAmt = this.chgSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSmryAmt = this.invSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
