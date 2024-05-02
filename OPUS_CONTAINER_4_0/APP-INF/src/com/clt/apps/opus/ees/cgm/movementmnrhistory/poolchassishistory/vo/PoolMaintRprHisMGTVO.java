/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolMaintRprHisMGTVO.java
*@FileTitle : PoolMaintRprHisMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.23 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PoolMaintRprHisMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PoolMaintRprHisMGTVO> models = new ArrayList<PoolMaintRprHisMGTVO>();
	
	/* Column Info */
	private String vndrLocNm = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String rprCmplDt = null;
	/* Column Info */
	private String invAproDt = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String chssCmpoNm = null;
	/* Column Info */
	private String invCreDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lbrCostAmt = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String costTtlAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String chssLocNm = null;
	/* Column Info */
	private String rprRqstDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String invRefNo = null;
	/* Column Info */
	private String splCmpoTpCd = null;
	/* Column Info */
	private String chssOwnrCoNm = null;
	/* Column Info */
	private String chssUseCoNm = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String dmgDesc = null;
	/* Column Info */
	private String chssAsptNm = null;
	/* Column Info */
	private String mtrlCostAmt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String rprHrs = null;
	/* Column Info */
	private String issOfcNm = null;
	/* Column Info */
	private String rprDesc = null;
	/* Column Info */
	private String rprInspTpDesc = null;
	/* Column Info */
	private String splCmpoQty = null;
	/* Column Info */
	private String rprCmpoQty = null;
	/* Column Info */
	private String respbPtyNm = null;
	/* Column Info */
	private String poolMgmtCoCd = null;
	/* Column Info */
	private String sysSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PoolMaintRprHisMGTVO() {}

	public PoolMaintRprHisMGTVO(String ibflag, String pagerows, String chssNo, String sysSeq, String poolMgmtCoCd, String chssPoolCd, String vndrNm, String vndrLocNm, String invNo, String chssAsptNm, String chssCmpoNm, String chssLocNm, String dmgDesc, String rprDesc, String rprCmpoQty, String rprHrs, String rprInspTpDesc, String lbrCostAmt, String mtrlCostAmt, String taxAmt, String costTtlAmt, String invCreDt, String invAproDt, String rprRqstDt, String rprCmplDt, String cntrNo, String chssUseCoNm, String issOfcNm, String chssOwnrCoNm, String respbPtyNm, String invRefNo, String splCmpoTpCd, String splCmpoQty, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.vndrLocNm = vndrLocNm;
		this.chssPoolCd = chssPoolCd;
		this.rprCmplDt = rprCmplDt;
		this.invAproDt = invAproDt;
		this.chssNo = chssNo;
		this.creDt = creDt;
		this.chssCmpoNm = chssCmpoNm;
		this.invCreDt = invCreDt;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.ibflag = ibflag;
		this.lbrCostAmt = lbrCostAmt;
		this.taxAmt = taxAmt;
		this.costTtlAmt = costTtlAmt;
		this.updUsrId = updUsrId;
		this.chssLocNm = chssLocNm;
		this.rprRqstDt = rprRqstDt;
		this.updDt = updDt;
		this.invRefNo = invRefNo;
		this.splCmpoTpCd = splCmpoTpCd;
		this.chssOwnrCoNm = chssOwnrCoNm;
		this.chssUseCoNm = chssUseCoNm;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.dmgDesc = dmgDesc;
		this.chssAsptNm = chssAsptNm;
		this.mtrlCostAmt = mtrlCostAmt;
		this.cntrNo = cntrNo;
		this.rprHrs = rprHrs;
		this.issOfcNm = issOfcNm;
		this.rprDesc = rprDesc;
		this.rprInspTpDesc = rprInspTpDesc;
		this.splCmpoQty = splCmpoQty;
		this.rprCmpoQty = rprCmpoQty;
		this.respbPtyNm = respbPtyNm;
		this.poolMgmtCoCd = poolMgmtCoCd;
		this.sysSeq = sysSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_loc_nm", getVndrLocNm());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("rpr_cmpl_dt", getRprCmplDt());
		this.hashColumns.put("inv_apro_dt", getInvAproDt());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("chss_cmpo_nm", getChssCmpoNm());
		this.hashColumns.put("inv_cre_dt", getInvCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lbr_cost_amt", getLbrCostAmt());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("cost_ttl_amt", getCostTtlAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("chss_loc_nm", getChssLocNm());
		this.hashColumns.put("rpr_rqst_dt", getRprRqstDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inv_ref_no", getInvRefNo());
		this.hashColumns.put("spl_cmpo_tp_cd", getSplCmpoTpCd());
		this.hashColumns.put("chss_ownr_co_nm", getChssOwnrCoNm());
		this.hashColumns.put("chss_use_co_nm", getChssUseCoNm());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dmg_desc", getDmgDesc());
		this.hashColumns.put("chss_aspt_nm", getChssAsptNm());
		this.hashColumns.put("mtrl_cost_amt", getMtrlCostAmt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rpr_hrs", getRprHrs());
		this.hashColumns.put("iss_ofc_nm", getIssOfcNm());
		this.hashColumns.put("rpr_desc", getRprDesc());
		this.hashColumns.put("rpr_insp_tp_desc", getRprInspTpDesc());
		this.hashColumns.put("spl_cmpo_qty", getSplCmpoQty());
		this.hashColumns.put("rpr_cmpo_qty", getRprCmpoQty());
		this.hashColumns.put("respb_pty_nm", getRespbPtyNm());
		this.hashColumns.put("pool_mgmt_co_cd", getPoolMgmtCoCd());
		this.hashColumns.put("sys_seq", getSysSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_loc_nm", "vndrLocNm");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("rpr_cmpl_dt", "rprCmplDt");
		this.hashFields.put("inv_apro_dt", "invAproDt");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("chss_cmpo_nm", "chssCmpoNm");
		this.hashFields.put("inv_cre_dt", "invCreDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lbr_cost_amt", "lbrCostAmt");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("cost_ttl_amt", "costTtlAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("chss_loc_nm", "chssLocNm");
		this.hashFields.put("rpr_rqst_dt", "rprRqstDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("spl_cmpo_tp_cd", "splCmpoTpCd");
		this.hashFields.put("chss_ownr_co_nm", "chssOwnrCoNm");
		this.hashFields.put("chss_use_co_nm", "chssUseCoNm");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dmg_desc", "dmgDesc");
		this.hashFields.put("chss_aspt_nm", "chssAsptNm");
		this.hashFields.put("mtrl_cost_amt", "mtrlCostAmt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rpr_hrs", "rprHrs");
		this.hashFields.put("iss_ofc_nm", "issOfcNm");
		this.hashFields.put("rpr_desc", "rprDesc");
		this.hashFields.put("rpr_insp_tp_desc", "rprInspTpDesc");
		this.hashFields.put("spl_cmpo_qty", "splCmpoQty");
		this.hashFields.put("rpr_cmpo_qty", "rprCmpoQty");
		this.hashFields.put("respb_pty_nm", "respbPtyNm");
		this.hashFields.put("pool_mgmt_co_cd", "poolMgmtCoCd");
		this.hashFields.put("sys_seq", "sysSeq");
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
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
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
	 * @return invAproDt
	 */
	public String getInvAproDt() {
		return this.invAproDt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return taxAmt
	 */
	public String getTaxAmt() {
		return this.taxAmt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return rprRqstDt
	 */
	public String getRprRqstDt() {
		return this.rprRqstDt;
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
	 * @return invRefNo
	 */
	public String getInvRefNo() {
		return this.invRefNo;
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
	 * @return chssOwnrCoNm
	 */
	public String getChssOwnrCoNm() {
		return this.chssOwnrCoNm;
	}
	
	/**
	 * Column Info
	 * @return chssUseCoNm
	 */
	public String getChssUseCoNm() {
		return this.chssUseCoNm;
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
	 * @return dmgDesc
	 */
	public String getDmgDesc() {
		return this.dmgDesc;
	}
	
	/**
	 * Column Info
	 * @return chssAsptNm
	 */
	public String getChssAsptNm() {
		return this.chssAsptNm;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return issOfcNm
	 */
	public String getIssOfcNm() {
		return this.issOfcNm;
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
	 * @return splCmpoQty
	 */
	public String getSplCmpoQty() {
		return this.splCmpoQty;
	}
	
	/**
	 * Column Info
	 * @return rprCmpoQty
	 */
	public String getRprCmpoQty() {
		return this.rprCmpoQty;
	}
	
	/**
	 * Column Info
	 * @return respbPtyNm
	 */
	public String getRespbPtyNm() {
		return this.respbPtyNm;
	}
	
	/**
	 * Column Info
	 * @return poolMgmtCoCd
	 */
	public String getPoolMgmtCoCd() {
		return this.poolMgmtCoCd;
	}
	
	/**
	 * Column Info
	 * @return sysSeq
	 */
	public String getSysSeq() {
		return this.sysSeq;
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
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
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
	 * @param invAproDt
	 */
	public void setInvAproDt(String invAproDt) {
		this.invAproDt = invAproDt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param taxAmt
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param rprRqstDt
	 */
	public void setRprRqstDt(String rprRqstDt) {
		this.rprRqstDt = rprRqstDt;
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
	 * @param invRefNo
	 */
	public void setInvRefNo(String invRefNo) {
		this.invRefNo = invRefNo;
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
	 * @param chssOwnrCoNm
	 */
	public void setChssOwnrCoNm(String chssOwnrCoNm) {
		this.chssOwnrCoNm = chssOwnrCoNm;
	}
	
	/**
	 * Column Info
	 * @param chssUseCoNm
	 */
	public void setChssUseCoNm(String chssUseCoNm) {
		this.chssUseCoNm = chssUseCoNm;
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
	 * @param dmgDesc
	 */
	public void setDmgDesc(String dmgDesc) {
		this.dmgDesc = dmgDesc;
	}
	
	/**
	 * Column Info
	 * @param chssAsptNm
	 */
	public void setChssAsptNm(String chssAsptNm) {
		this.chssAsptNm = chssAsptNm;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param issOfcNm
	 */
	public void setIssOfcNm(String issOfcNm) {
		this.issOfcNm = issOfcNm;
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
	 * @param splCmpoQty
	 */
	public void setSplCmpoQty(String splCmpoQty) {
		this.splCmpoQty = splCmpoQty;
	}
	
	/**
	 * Column Info
	 * @param rprCmpoQty
	 */
	public void setRprCmpoQty(String rprCmpoQty) {
		this.rprCmpoQty = rprCmpoQty;
	}
	
	/**
	 * Column Info
	 * @param respbPtyNm
	 */
	public void setRespbPtyNm(String respbPtyNm) {
		this.respbPtyNm = respbPtyNm;
	}
	
	/**
	 * Column Info
	 * @param poolMgmtCoCd
	 */
	public void setPoolMgmtCoCd(String poolMgmtCoCd) {
		this.poolMgmtCoCd = poolMgmtCoCd;
	}
	
	/**
	 * Column Info
	 * @param sysSeq
	 */
	public void setSysSeq(String sysSeq) {
		this.sysSeq = sysSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVndrLocNm(JSPUtil.getParameter(request, "vndr_loc_nm", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setRprCmplDt(JSPUtil.getParameter(request, "rpr_cmpl_dt", ""));
		setInvAproDt(JSPUtil.getParameter(request, "inv_apro_dt", ""));
		setChssNo(JSPUtil.getParameter(request, "chss_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setChssCmpoNm(JSPUtil.getParameter(request, "chss_cmpo_nm", ""));
		setInvCreDt(JSPUtil.getParameter(request, "inv_cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, "vndr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLbrCostAmt(JSPUtil.getParameter(request, "lbr_cost_amt", ""));
		setTaxAmt(JSPUtil.getParameter(request, "tax_amt", ""));
		setCostTtlAmt(JSPUtil.getParameter(request, "cost_ttl_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setChssLocNm(JSPUtil.getParameter(request, "chss_loc_nm", ""));
		setRprRqstDt(JSPUtil.getParameter(request, "rpr_rqst_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setInvRefNo(JSPUtil.getParameter(request, "inv_ref_no", ""));
		setSplCmpoTpCd(JSPUtil.getParameter(request, "spl_cmpo_tp_cd", ""));
		setChssOwnrCoNm(JSPUtil.getParameter(request, "chss_ownr_co_nm", ""));
		setChssUseCoNm(JSPUtil.getParameter(request, "chss_use_co_nm", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setDmgDesc(JSPUtil.getParameter(request, "dmg_desc", ""));
		setChssAsptNm(JSPUtil.getParameter(request, "chss_aspt_nm", ""));
		setMtrlCostAmt(JSPUtil.getParameter(request, "mtrl_cost_amt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setRprHrs(JSPUtil.getParameter(request, "rpr_hrs", ""));
		setIssOfcNm(JSPUtil.getParameter(request, "iss_ofc_nm", ""));
		setRprDesc(JSPUtil.getParameter(request, "rpr_desc", ""));
		setRprInspTpDesc(JSPUtil.getParameter(request, "rpr_insp_tp_desc", ""));
		setSplCmpoQty(JSPUtil.getParameter(request, "spl_cmpo_qty", ""));
		setRprCmpoQty(JSPUtil.getParameter(request, "rpr_cmpo_qty", ""));
		setRespbPtyNm(JSPUtil.getParameter(request, "respb_pty_nm", ""));
		setPoolMgmtCoCd(JSPUtil.getParameter(request, "pool_mgmt_co_cd", ""));
		setSysSeq(JSPUtil.getParameter(request, "sys_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PoolMaintRprHisMGTVO[]
	 */
	public PoolMaintRprHisMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PoolMaintRprHisMGTVO[]
	 */
	public PoolMaintRprHisMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PoolMaintRprHisMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrLocNm = (JSPUtil.getParameter(request, prefix	+ "vndr_loc_nm", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] rprCmplDt = (JSPUtil.getParameter(request, prefix	+ "rpr_cmpl_dt", length));
			String[] invAproDt = (JSPUtil.getParameter(request, prefix	+ "inv_apro_dt", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] chssCmpoNm = (JSPUtil.getParameter(request, prefix	+ "chss_cmpo_nm", length));
			String[] invCreDt = (JSPUtil.getParameter(request, prefix	+ "inv_cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lbrCostAmt = (JSPUtil.getParameter(request, prefix	+ "lbr_cost_amt", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] costTtlAmt = (JSPUtil.getParameter(request, prefix	+ "cost_ttl_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] chssLocNm = (JSPUtil.getParameter(request, prefix	+ "chss_loc_nm", length));
			String[] rprRqstDt = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] invRefNo = (JSPUtil.getParameter(request, prefix	+ "inv_ref_no", length));
			String[] splCmpoTpCd = (JSPUtil.getParameter(request, prefix	+ "spl_cmpo_tp_cd", length));
			String[] chssOwnrCoNm = (JSPUtil.getParameter(request, prefix	+ "chss_ownr_co_nm", length));
			String[] chssUseCoNm = (JSPUtil.getParameter(request, prefix	+ "chss_use_co_nm", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] dmgDesc = (JSPUtil.getParameter(request, prefix	+ "dmg_desc", length));
			String[] chssAsptNm = (JSPUtil.getParameter(request, prefix	+ "chss_aspt_nm", length));
			String[] mtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mtrl_cost_amt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] rprHrs = (JSPUtil.getParameter(request, prefix	+ "rpr_hrs", length));
			String[] issOfcNm = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_nm", length));
			String[] rprDesc = (JSPUtil.getParameter(request, prefix	+ "rpr_desc", length));
			String[] rprInspTpDesc = (JSPUtil.getParameter(request, prefix	+ "rpr_insp_tp_desc", length));
			String[] splCmpoQty = (JSPUtil.getParameter(request, prefix	+ "spl_cmpo_qty", length));
			String[] rprCmpoQty = (JSPUtil.getParameter(request, prefix	+ "rpr_cmpo_qty", length));
			String[] respbPtyNm = (JSPUtil.getParameter(request, prefix	+ "respb_pty_nm", length));
			String[] poolMgmtCoCd = (JSPUtil.getParameter(request, prefix	+ "pool_mgmt_co_cd", length));
			String[] sysSeq = (JSPUtil.getParameter(request, prefix	+ "sys_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new PoolMaintRprHisMGTVO();
				if (vndrLocNm[i] != null)
					model.setVndrLocNm(vndrLocNm[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (rprCmplDt[i] != null)
					model.setRprCmplDt(rprCmplDt[i]);
				if (invAproDt[i] != null)
					model.setInvAproDt(invAproDt[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (chssCmpoNm[i] != null)
					model.setChssCmpoNm(chssCmpoNm[i]);
				if (invCreDt[i] != null)
					model.setInvCreDt(invCreDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lbrCostAmt[i] != null)
					model.setLbrCostAmt(lbrCostAmt[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (costTtlAmt[i] != null)
					model.setCostTtlAmt(costTtlAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (chssLocNm[i] != null)
					model.setChssLocNm(chssLocNm[i]);
				if (rprRqstDt[i] != null)
					model.setRprRqstDt(rprRqstDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (invRefNo[i] != null)
					model.setInvRefNo(invRefNo[i]);
				if (splCmpoTpCd[i] != null)
					model.setSplCmpoTpCd(splCmpoTpCd[i]);
				if (chssOwnrCoNm[i] != null)
					model.setChssOwnrCoNm(chssOwnrCoNm[i]);
				if (chssUseCoNm[i] != null)
					model.setChssUseCoNm(chssUseCoNm[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (dmgDesc[i] != null)
					model.setDmgDesc(dmgDesc[i]);
				if (chssAsptNm[i] != null)
					model.setChssAsptNm(chssAsptNm[i]);
				if (mtrlCostAmt[i] != null)
					model.setMtrlCostAmt(mtrlCostAmt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (rprHrs[i] != null)
					model.setRprHrs(rprHrs[i]);
				if (issOfcNm[i] != null)
					model.setIssOfcNm(issOfcNm[i]);
				if (rprDesc[i] != null)
					model.setRprDesc(rprDesc[i]);
				if (rprInspTpDesc[i] != null)
					model.setRprInspTpDesc(rprInspTpDesc[i]);
				if (splCmpoQty[i] != null)
					model.setSplCmpoQty(splCmpoQty[i]);
				if (rprCmpoQty[i] != null)
					model.setRprCmpoQty(rprCmpoQty[i]);
				if (respbPtyNm[i] != null)
					model.setRespbPtyNm(respbPtyNm[i]);
				if (poolMgmtCoCd[i] != null)
					model.setPoolMgmtCoCd(poolMgmtCoCd[i]);
				if (sysSeq[i] != null)
					model.setSysSeq(sysSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPoolMaintRprHisMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PoolMaintRprHisMGTVO[]
	 */
	public PoolMaintRprHisMGTVO[] getPoolMaintRprHisMGTVOs(){
		PoolMaintRprHisMGTVO[] vos = (PoolMaintRprHisMGTVO[])models.toArray(new PoolMaintRprHisMGTVO[models.size()]);
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
		this.vndrLocNm = this.vndrLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprCmplDt = this.rprCmplDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAproDt = this.invAproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssCmpoNm = this.chssCmpoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCreDt = this.invCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbrCostAmt = this.lbrCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTtlAmt = this.costTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssLocNm = this.chssLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstDt = this.rprRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo = this.invRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splCmpoTpCd = this.splCmpoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssOwnrCoNm = this.chssOwnrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssUseCoNm = this.chssUseCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgDesc = this.dmgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssAsptNm = this.chssAsptNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlCostAmt = this.mtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprHrs = this.rprHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcNm = this.issOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprDesc = this.rprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprInspTpDesc = this.rprInspTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splCmpoQty = this.splCmpoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprCmpoQty = this.rprCmpoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbPtyNm = this.respbPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolMgmtCoCd = this.poolMgmtCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSeq = this.sysSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
