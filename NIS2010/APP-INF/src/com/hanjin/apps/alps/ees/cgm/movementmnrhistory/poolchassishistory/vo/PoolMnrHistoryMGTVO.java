/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PoolMnrHistoryMGTVO.java
*@FileTitle : PoolMnrHistoryMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.02.01 최민회 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PoolMnrHistoryMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PoolMnrHistoryMGTVO> models = new ArrayList<PoolMnrHistoryMGTVO>();
	
	/* Column Info */
	private String vndrLocNm = null;
	/* Column Info */
	private String rprCmplDt = null;
	/* Column Info */
	private String chssLbr = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String chssCmpoNm = null;
	/* Column Info */
	private String invCreDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String lbrCostAmt = null;
	/* Column Info */
	private String chssCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String chssAmt = null;
	/* Column Info */
	private String unChssMtrl = null;
	/* Column Info */
	private String costTtlAmt = null;
	/* Column Info */
	private String chssMtrl = null;
	/* Column Info */
	private String rprRqstDt = null;
	/* Column Info */
	private String chssCost = null;
	/* Column Info */
	private String chssLocNm = null;
	/* Column Info */
	private String unChssTtl = null;
	/* Column Info */
	private String mstChk = null;
	/* Column Info */
	private String splCmpoTpCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String unChssLbr = null;
	/* Column Info */
	private String chssTtl = null;
	/* Column Info */
	private String dmgDesc = null;
	/* Column Info */
	private String mtrlCostAmt = null;
	/* Column Info */
	private String rprHrs = null;
	/* Column Info */
	private String unChssCnt = null;
	/* Column Info */
	private String rprDesc = null;
	/* Column Info */
	private String rprInspTpDesc = null;
	/* Column Info */
	private String unChssAmt = null;
	/* Column Info */
	private String unChssCost = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PoolMnrHistoryMGTVO() {}

	public PoolMnrHistoryMGTVO(String ibflag, String pagerows, String vndrLocNm, String rprCmplDt, String chssLbr, String chssNo, String chssCmpoNm, String invCreDt, String splCmpoTpCd, String vndrNm, String chssCnt, String lbrCostAmt, String taxAmt, String chssAmt, String unChssMtrl, String costTtlAmt, String chssMtrl, String rprRqstDt, String chssCost, String chssLocNm, String unChssTtl, String mstChk, String invNo, String chssTtl, String dmgDesc, String unChssLbr, String mtrlCostAmt, String unChssCnt, String rprHrs, String rprInspTpDesc, String rprDesc, String unChssAmt, String unChssCost) {
		this.vndrLocNm = vndrLocNm;
		this.rprCmplDt = rprCmplDt;
		this.chssLbr = chssLbr;
		this.chssNo = chssNo;
		this.chssCmpoNm = chssCmpoNm;
		this.invCreDt = invCreDt;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.lbrCostAmt = lbrCostAmt;
		this.chssCnt = chssCnt;
		this.ibflag = ibflag;
		this.taxAmt = taxAmt;
		this.chssAmt = chssAmt;
		this.unChssMtrl = unChssMtrl;
		this.costTtlAmt = costTtlAmt;
		this.chssMtrl = chssMtrl;
		this.rprRqstDt = rprRqstDt;
		this.chssCost = chssCost;
		this.chssLocNm = chssLocNm;
		this.unChssTtl = unChssTtl;
		this.mstChk = mstChk;
		this.splCmpoTpCd = splCmpoTpCd;
		this.invNo = invNo;
		this.unChssLbr = unChssLbr;
		this.chssTtl = chssTtl;
		this.dmgDesc = dmgDesc;
		this.mtrlCostAmt = mtrlCostAmt;
		this.rprHrs = rprHrs;
		this.unChssCnt = unChssCnt;
		this.rprDesc = rprDesc;
		this.rprInspTpDesc = rprInspTpDesc;
		this.unChssAmt = unChssAmt;
		this.unChssCost = unChssCost;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_loc_nm", getVndrLocNm());
		this.hashColumns.put("rpr_cmpl_dt", getRprCmplDt());
		this.hashColumns.put("chss_lbr", getChssLbr());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("chss_cmpo_nm", getChssCmpoNm());
		this.hashColumns.put("inv_cre_dt", getInvCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("lbr_cost_amt", getLbrCostAmt());
		this.hashColumns.put("chss_cnt", getChssCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("chss_amt", getChssAmt());
		this.hashColumns.put("un_chss_mtrl", getUnChssMtrl());
		this.hashColumns.put("cost_ttl_amt", getCostTtlAmt());
		this.hashColumns.put("chss_mtrl", getChssMtrl());
		this.hashColumns.put("rpr_rqst_dt", getRprRqstDt());
		this.hashColumns.put("chss_cost", getChssCost());
		this.hashColumns.put("chss_loc_nm", getChssLocNm());
		this.hashColumns.put("un_chss_ttl", getUnChssTtl());
		this.hashColumns.put("mst_chk", getMstChk());
		this.hashColumns.put("spl_cmpo_tp_cd", getSplCmpoTpCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("un_chss_lbr", getUnChssLbr());
		this.hashColumns.put("chss_ttl", getChssTtl());
		this.hashColumns.put("dmg_desc", getDmgDesc());
		this.hashColumns.put("mtrl_cost_amt", getMtrlCostAmt());
		this.hashColumns.put("rpr_hrs", getRprHrs());
		this.hashColumns.put("un_chss_cnt", getUnChssCnt());
		this.hashColumns.put("rpr_desc", getRprDesc());
		this.hashColumns.put("rpr_insp_tp_desc", getRprInspTpDesc());
		this.hashColumns.put("un_chss_amt", getUnChssAmt());
		this.hashColumns.put("un_chss_cost", getUnChssCost());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_loc_nm", "vndrLocNm");
		this.hashFields.put("rpr_cmpl_dt", "rprCmplDt");
		this.hashFields.put("chss_lbr", "chssLbr");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("chss_cmpo_nm", "chssCmpoNm");
		this.hashFields.put("inv_cre_dt", "invCreDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("lbr_cost_amt", "lbrCostAmt");
		this.hashFields.put("chss_cnt", "chssCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("chss_amt", "chssAmt");
		this.hashFields.put("un_chss_mtrl", "unChssMtrl");
		this.hashFields.put("cost_ttl_amt", "costTtlAmt");
		this.hashFields.put("chss_mtrl", "chssMtrl");
		this.hashFields.put("rpr_rqst_dt", "rprRqstDt");
		this.hashFields.put("chss_cost", "chssCost");
		this.hashFields.put("chss_loc_nm", "chssLocNm");
		this.hashFields.put("un_chss_ttl", "unChssTtl");
		this.hashFields.put("mst_chk", "mstChk");
		this.hashFields.put("spl_cmpo_tp_cd", "splCmpoTpCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("un_chss_lbr", "unChssLbr");
		this.hashFields.put("chss_ttl", "chssTtl");
		this.hashFields.put("dmg_desc", "dmgDesc");
		this.hashFields.put("mtrl_cost_amt", "mtrlCostAmt");
		this.hashFields.put("rpr_hrs", "rprHrs");
		this.hashFields.put("un_chss_cnt", "unChssCnt");
		this.hashFields.put("rpr_desc", "rprDesc");
		this.hashFields.put("rpr_insp_tp_desc", "rprInspTpDesc");
		this.hashFields.put("un_chss_amt", "unChssAmt");
		this.hashFields.put("un_chss_cost", "unChssCost");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vndrLocNm
	 */
	public String getVndrLocNm() {
		return this.vndrLocNm;
	}
	
	/**
	 * Column Info
	 * @return rprCmplDt
	 */
	public String getRprCmplDt() {
		return this.rprCmplDt;
	}
	
	/**
	 * Column Info
	 * @return chssLbr
	 */
	public String getChssLbr() {
		return this.chssLbr;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return chssCmpoNm
	 */
	public String getChssCmpoNm() {
		return this.chssCmpoNm;
	}
	
	/**
	 * Column Info
	 * @return invCreDt
	 */
	public String getInvCreDt() {
		return this.invCreDt;
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
	 * @return lbrCostAmt
	 */
	public String getLbrCostAmt() {
		return this.lbrCostAmt;
	}
	
	/**
	 * Column Info
	 * @return chssCnt
	 */
	public String getChssCnt() {
		return this.chssCnt;
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
	 * @return taxAmt
	 */
	public String getTaxAmt() {
		return this.taxAmt;
	}
	
	/**
	 * Column Info
	 * @return chssAmt
	 */
	public String getChssAmt() {
		return this.chssAmt;
	}
	
	/**
	 * Column Info
	 * @return unChssMtrl
	 */
	public String getUnChssMtrl() {
		return this.unChssMtrl;
	}
	
	/**
	 * Column Info
	 * @return costTtlAmt
	 */
	public String getCostTtlAmt() {
		return this.costTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return chssMtrl
	 */
	public String getChssMtrl() {
		return this.chssMtrl;
	}
	
	/**
	 * Column Info
	 * @return rprRqstDt
	 */
	public String getRprRqstDt() {
		return this.rprRqstDt;
	}
	
	/**
	 * Column Info
	 * @return chssCost
	 */
	public String getChssCost() {
		return this.chssCost;
	}
	
	/**
	 * Column Info
	 * @return chssLocNm
	 */
	public String getChssLocNm() {
		return this.chssLocNm;
	}
	
	/**
	 * Column Info
	 * @return unChssTtl
	 */
	public String getUnChssTtl() {
		return this.unChssTtl;
	}
	
	/**
	 * Column Info
	 * @return mstChk
	 */
	public String getMstChk() {
		return this.mstChk;
	}
	
	/**
	 * Column Info
	 * @return splCmpoTpCd
	 */
	public String getSplCmpoTpCd() {
		return this.splCmpoTpCd;
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
	 * @return unChssLbr
	 */
	public String getUnChssLbr() {
		return this.unChssLbr;
	}
	
	/**
	 * Column Info
	 * @return chssTtl
	 */
	public String getChssTtl() {
		return this.chssTtl;
	}
	
	/**
	 * Column Info
	 * @return dmgDesc
	 */
	public String getDmgDesc() {
		return this.dmgDesc;
	}
	
	/**
	 * Column Info
	 * @return mtrlCostAmt
	 */
	public String getMtrlCostAmt() {
		return this.mtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return rprHrs
	 */
	public String getRprHrs() {
		return this.rprHrs;
	}
	
	/**
	 * Column Info
	 * @return unChssCnt
	 */
	public String getUnChssCnt() {
		return this.unChssCnt;
	}
	
	/**
	 * Column Info
	 * @return rprDesc
	 */
	public String getRprDesc() {
		return this.rprDesc;
	}
	
	/**
	 * Column Info
	 * @return rprInspTpDesc
	 */
	public String getRprInspTpDesc() {
		return this.rprInspTpDesc;
	}
	
	/**
	 * Column Info
	 * @return unChssAmt
	 */
	public String getUnChssAmt() {
		return this.unChssAmt;
	}
	
	/**
	 * Column Info
	 * @return unChssCost
	 */
	public String getUnChssCost() {
		return this.unChssCost;
	}
	

	/**
	 * Column Info
	 * @param vndrLocNm
	 */
	public void setVndrLocNm(String vndrLocNm) {
		this.vndrLocNm = vndrLocNm;
	}
	
	/**
	 * Column Info
	 * @param rprCmplDt
	 */
	public void setRprCmplDt(String rprCmplDt) {
		this.rprCmplDt = rprCmplDt;
	}
	
	/**
	 * Column Info
	 * @param chssLbr
	 */
	public void setChssLbr(String chssLbr) {
		this.chssLbr = chssLbr;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param chssCmpoNm
	 */
	public void setChssCmpoNm(String chssCmpoNm) {
		this.chssCmpoNm = chssCmpoNm;
	}
	
	/**
	 * Column Info
	 * @param invCreDt
	 */
	public void setInvCreDt(String invCreDt) {
		this.invCreDt = invCreDt;
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
	 * @param lbrCostAmt
	 */
	public void setLbrCostAmt(String lbrCostAmt) {
		this.lbrCostAmt = lbrCostAmt;
	}
	
	/**
	 * Column Info
	 * @param chssCnt
	 */
	public void setChssCnt(String chssCnt) {
		this.chssCnt = chssCnt;
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
	 * @param taxAmt
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}
	
	/**
	 * Column Info
	 * @param chssAmt
	 */
	public void setChssAmt(String chssAmt) {
		this.chssAmt = chssAmt;
	}
	
	/**
	 * Column Info
	 * @param unChssMtrl
	 */
	public void setUnChssMtrl(String unChssMtrl) {
		this.unChssMtrl = unChssMtrl;
	}
	
	/**
	 * Column Info
	 * @param costTtlAmt
	 */
	public void setCostTtlAmt(String costTtlAmt) {
		this.costTtlAmt = costTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param chssMtrl
	 */
	public void setChssMtrl(String chssMtrl) {
		this.chssMtrl = chssMtrl;
	}
	
	/**
	 * Column Info
	 * @param rprRqstDt
	 */
	public void setRprRqstDt(String rprRqstDt) {
		this.rprRqstDt = rprRqstDt;
	}
	
	/**
	 * Column Info
	 * @param chssCost
	 */
	public void setChssCost(String chssCost) {
		this.chssCost = chssCost;
	}
	
	/**
	 * Column Info
	 * @param chssLocNm
	 */
	public void setChssLocNm(String chssLocNm) {
		this.chssLocNm = chssLocNm;
	}
	
	/**
	 * Column Info
	 * @param unChssTtl
	 */
	public void setUnChssTtl(String unChssTtl) {
		this.unChssTtl = unChssTtl;
	}
	
	/**
	 * Column Info
	 * @param mstChk
	 */
	public void setMstChk(String mstChk) {
		this.mstChk = mstChk;
	}
	
	/**
	 * Column Info
	 * @param splCmpoTpCd
	 */
	public void setSplCmpoTpCd(String splCmpoTpCd) {
		this.splCmpoTpCd = splCmpoTpCd;
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
	 * @param unChssLbr
	 */
	public void setUnChssLbr(String unChssLbr) {
		this.unChssLbr = unChssLbr;
	}
	
	/**
	 * Column Info
	 * @param chssTtl
	 */
	public void setChssTtl(String chssTtl) {
		this.chssTtl = chssTtl;
	}
	
	/**
	 * Column Info
	 * @param dmgDesc
	 */
	public void setDmgDesc(String dmgDesc) {
		this.dmgDesc = dmgDesc;
	}
	
	/**
	 * Column Info
	 * @param mtrlCostAmt
	 */
	public void setMtrlCostAmt(String mtrlCostAmt) {
		this.mtrlCostAmt = mtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param rprHrs
	 */
	public void setRprHrs(String rprHrs) {
		this.rprHrs = rprHrs;
	}
	
	/**
	 * Column Info
	 * @param unChssCnt
	 */
	public void setUnChssCnt(String unChssCnt) {
		this.unChssCnt = unChssCnt;
	}
	
	/**
	 * Column Info
	 * @param rprDesc
	 */
	public void setRprDesc(String rprDesc) {
		this.rprDesc = rprDesc;
	}
	
	/**
	 * Column Info
	 * @param rprInspTpDesc
	 */
	public void setRprInspTpDesc(String rprInspTpDesc) {
		this.rprInspTpDesc = rprInspTpDesc;
	}
	
	/**
	 * Column Info
	 * @param unChssAmt
	 */
	public void setUnChssAmt(String unChssAmt) {
		this.unChssAmt = unChssAmt;
	}
	
	/**
	 * Column Info
	 * @param unChssCost
	 */
	public void setUnChssCost(String unChssCost) {
		this.unChssCost = unChssCost;
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
		setVndrLocNm(JSPUtil.getParameter(request, prefix + "vndr_loc_nm", ""));
		setRprCmplDt(JSPUtil.getParameter(request, prefix + "rpr_cmpl_dt", ""));
		setChssLbr(JSPUtil.getParameter(request, prefix + "chss_lbr", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setChssCmpoNm(JSPUtil.getParameter(request, prefix + "chss_cmpo_nm", ""));
		setInvCreDt(JSPUtil.getParameter(request, prefix + "inv_cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setLbrCostAmt(JSPUtil.getParameter(request, prefix + "lbr_cost_amt", ""));
		setChssCnt(JSPUtil.getParameter(request, prefix + "chss_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTaxAmt(JSPUtil.getParameter(request, prefix + "tax_amt", ""));
		setChssAmt(JSPUtil.getParameter(request, prefix + "chss_amt", ""));
		setUnChssMtrl(JSPUtil.getParameter(request, prefix + "un_chss_mtrl", ""));
		setCostTtlAmt(JSPUtil.getParameter(request, prefix + "cost_ttl_amt", ""));
		setChssMtrl(JSPUtil.getParameter(request, prefix + "chss_mtrl", ""));
		setRprRqstDt(JSPUtil.getParameter(request, prefix + "rpr_rqst_dt", ""));
		setChssCost(JSPUtil.getParameter(request, prefix + "chss_cost", ""));
		setChssLocNm(JSPUtil.getParameter(request, prefix + "chss_loc_nm", ""));
		setUnChssTtl(JSPUtil.getParameter(request, prefix + "un_chss_ttl", ""));
		setMstChk(JSPUtil.getParameter(request, prefix + "mst_chk", ""));
		setSplCmpoTpCd(JSPUtil.getParameter(request, prefix + "spl_cmpo_tp_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setUnChssLbr(JSPUtil.getParameter(request, prefix + "un_chss_lbr", ""));
		setChssTtl(JSPUtil.getParameter(request, prefix + "chss_ttl", ""));
		setDmgDesc(JSPUtil.getParameter(request, prefix + "dmg_desc", ""));
		setMtrlCostAmt(JSPUtil.getParameter(request, prefix + "mtrl_cost_amt", ""));
		setRprHrs(JSPUtil.getParameter(request, prefix + "rpr_hrs", ""));
		setUnChssCnt(JSPUtil.getParameter(request, prefix + "un_chss_cnt", ""));
		setRprDesc(JSPUtil.getParameter(request, prefix + "rpr_desc", ""));
		setRprInspTpDesc(JSPUtil.getParameter(request, prefix + "rpr_insp_tp_desc", ""));
		setUnChssAmt(JSPUtil.getParameter(request, prefix + "un_chss_amt", ""));
		setUnChssCost(JSPUtil.getParameter(request, prefix + "un_chss_cost", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PoolMnrHistoryMGTVO[]
	 */
	public PoolMnrHistoryMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PoolMnrHistoryMGTVO[]
	 */
	public PoolMnrHistoryMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PoolMnrHistoryMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrLocNm = (JSPUtil.getParameter(request, prefix	+ "vndr_loc_nm", length));
			String[] rprCmplDt = (JSPUtil.getParameter(request, prefix	+ "rpr_cmpl_dt", length));
			String[] chssLbr = (JSPUtil.getParameter(request, prefix	+ "chss_lbr", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] chssCmpoNm = (JSPUtil.getParameter(request, prefix	+ "chss_cmpo_nm", length));
			String[] invCreDt = (JSPUtil.getParameter(request, prefix	+ "inv_cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] lbrCostAmt = (JSPUtil.getParameter(request, prefix	+ "lbr_cost_amt", length));
			String[] chssCnt = (JSPUtil.getParameter(request, prefix	+ "chss_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] chssAmt = (JSPUtil.getParameter(request, prefix	+ "chss_amt", length));
			String[] unChssMtrl = (JSPUtil.getParameter(request, prefix	+ "un_chss_mtrl", length));
			String[] costTtlAmt = (JSPUtil.getParameter(request, prefix	+ "cost_ttl_amt", length));
			String[] chssMtrl = (JSPUtil.getParameter(request, prefix	+ "chss_mtrl", length));
			String[] rprRqstDt = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_dt", length));
			String[] chssCost = (JSPUtil.getParameter(request, prefix	+ "chss_cost", length));
			String[] chssLocNm = (JSPUtil.getParameter(request, prefix	+ "chss_loc_nm", length));
			String[] unChssTtl = (JSPUtil.getParameter(request, prefix	+ "un_chss_ttl", length));
			String[] mstChk = (JSPUtil.getParameter(request, prefix	+ "mst_chk", length));
			String[] splCmpoTpCd = (JSPUtil.getParameter(request, prefix	+ "spl_cmpo_tp_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] unChssLbr = (JSPUtil.getParameter(request, prefix	+ "un_chss_lbr", length));
			String[] chssTtl = (JSPUtil.getParameter(request, prefix	+ "chss_ttl", length));
			String[] dmgDesc = (JSPUtil.getParameter(request, prefix	+ "dmg_desc", length));
			String[] mtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mtrl_cost_amt", length));
			String[] rprHrs = (JSPUtil.getParameter(request, prefix	+ "rpr_hrs", length));
			String[] unChssCnt = (JSPUtil.getParameter(request, prefix	+ "un_chss_cnt", length));
			String[] rprDesc = (JSPUtil.getParameter(request, prefix	+ "rpr_desc", length));
			String[] rprInspTpDesc = (JSPUtil.getParameter(request, prefix	+ "rpr_insp_tp_desc", length));
			String[] unChssAmt = (JSPUtil.getParameter(request, prefix	+ "un_chss_amt", length));
			String[] unChssCost = (JSPUtil.getParameter(request, prefix	+ "un_chss_cost", length));
			
			for (int i = 0; i < length; i++) {
				model = new PoolMnrHistoryMGTVO();
				if (vndrLocNm[i] != null)
					model.setVndrLocNm(vndrLocNm[i]);
				if (rprCmplDt[i] != null)
					model.setRprCmplDt(rprCmplDt[i]);
				if (chssLbr[i] != null)
					model.setChssLbr(chssLbr[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (chssCmpoNm[i] != null)
					model.setChssCmpoNm(chssCmpoNm[i]);
				if (invCreDt[i] != null)
					model.setInvCreDt(invCreDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (lbrCostAmt[i] != null)
					model.setLbrCostAmt(lbrCostAmt[i]);
				if (chssCnt[i] != null)
					model.setChssCnt(chssCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (chssAmt[i] != null)
					model.setChssAmt(chssAmt[i]);
				if (unChssMtrl[i] != null)
					model.setUnChssMtrl(unChssMtrl[i]);
				if (costTtlAmt[i] != null)
					model.setCostTtlAmt(costTtlAmt[i]);
				if (chssMtrl[i] != null)
					model.setChssMtrl(chssMtrl[i]);
				if (rprRqstDt[i] != null)
					model.setRprRqstDt(rprRqstDt[i]);
				if (chssCost[i] != null)
					model.setChssCost(chssCost[i]);
				if (chssLocNm[i] != null)
					model.setChssLocNm(chssLocNm[i]);
				if (unChssTtl[i] != null)
					model.setUnChssTtl(unChssTtl[i]);
				if (mstChk[i] != null)
					model.setMstChk(mstChk[i]);
				if (splCmpoTpCd[i] != null)
					model.setSplCmpoTpCd(splCmpoTpCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (unChssLbr[i] != null)
					model.setUnChssLbr(unChssLbr[i]);
				if (chssTtl[i] != null)
					model.setChssTtl(chssTtl[i]);
				if (dmgDesc[i] != null)
					model.setDmgDesc(dmgDesc[i]);
				if (mtrlCostAmt[i] != null)
					model.setMtrlCostAmt(mtrlCostAmt[i]);
				if (rprHrs[i] != null)
					model.setRprHrs(rprHrs[i]);
				if (unChssCnt[i] != null)
					model.setUnChssCnt(unChssCnt[i]);
				if (rprDesc[i] != null)
					model.setRprDesc(rprDesc[i]);
				if (rprInspTpDesc[i] != null)
					model.setRprInspTpDesc(rprInspTpDesc[i]);
				if (unChssAmt[i] != null)
					model.setUnChssAmt(unChssAmt[i]);
				if (unChssCost[i] != null)
					model.setUnChssCost(unChssCost[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPoolMnrHistoryMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PoolMnrHistoryMGTVO[]
	 */
	public PoolMnrHistoryMGTVO[] getPoolMnrHistoryMGTVOs(){
		PoolMnrHistoryMGTVO[] vos = (PoolMnrHistoryMGTVO[])models.toArray(new PoolMnrHistoryMGTVO[models.size()]);
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
		this.vndrLocNm = this.vndrLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprCmplDt = this.rprCmplDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssLbr = this.chssLbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssCmpoNm = this.chssCmpoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCreDt = this.invCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbrCostAmt = this.lbrCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssCnt = this.chssCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssAmt = this.chssAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unChssMtrl = this.unChssMtrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTtlAmt = this.costTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMtrl = this.chssMtrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstDt = this.rprRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssCost = this.chssCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssLocNm = this.chssLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unChssTtl = this.unChssTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstChk = this.mstChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splCmpoTpCd = this.splCmpoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unChssLbr = this.unChssLbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTtl = this.chssTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgDesc = this.dmgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlCostAmt = this.mtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprHrs = this.rprHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unChssCnt = this.unChssCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprDesc = this.rprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprInspTpDesc = this.rprInspTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unChssAmt = this.unChssAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unChssCost = this.unChssCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
