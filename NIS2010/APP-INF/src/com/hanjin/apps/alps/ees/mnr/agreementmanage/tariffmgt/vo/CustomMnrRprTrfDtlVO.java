/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomMnrRprTrfDtlVO.java
*@FileTitle : CustomMnrRprTrfDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.03.10 김완규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo;

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
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrRprTrfDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrRprTrfDtlVO> models = new ArrayList<CustomMnrRprTrfDtlVO>();
	
	/* Column Info */
	private String mnrVrfyTpCd = null;
	/* Column Info */
	private String tempSeq = null;
	/* Column Info */
	private String xchMtrlCostAmt = null;
	/* Column Info */
	private String mnrRngTpCdView = null;
	/* Column Info */
	private String cmTo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cmSize = null;
	/* Column Info */
	private String inchTo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String volTpCdView = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rprSzNo = null;
	/* Column Info */
	private String mapgRsltCd = null;
	/* Column Info */
	private String rprQty = null;
	/* Column Info */
	private String volTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String eqCmpoCd = null;
	/* Column Info */
	private String mnrRngTpCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dtlDesc = null;
	/* Column Info */
	private String trfDivCd = null;
	/* Column Info */
	private String stdTrfNo = null;
	/* Column Info */
	private String trfOptCd = null;
	/* Column Info */
	private String eqRprCd = null;
	/* Column Info */
	private String trfDtlSeq = null;
	/* Column Info */
	private String inchSize = null;
	/* Column Info */
	private String mtrlRecoAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mtrlCostAmt = null;
	/* Column Info */
	private String toRngSzNo = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String costGrpCd = null;
	/* Column Info */
	private String cmFm = null;
	/* Column Info */
	private String dtlRmk = null;
	/* Column Info */
	private String inchFm = null;
	/* Column Info */
	private String fmRngSzNo = null;
	/* Column Info */
	private String rprLbrHrs = null;
	/* Column Info */
	private String eqCmpoUpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrRprTrfDtlVO() {}

	public CustomMnrRprTrfDtlVO(String ibflag, String pagerows, String tempSeq, String mnrVrfyTpCd, String xchMtrlCostAmt, String mnrRngTpCdView, String cmTo, String creDt, String cmSize, String inchTo, String volTpCdView, String rprSzNo, String mapgRsltCd, String rprQty, String volTpCd, String updUsrId, String eqCmpoCd, String mnrRngTpCd, String updDt, String dtlDesc, String trfDivCd, String trfOptCd, String eqRprCd, String trfDtlSeq, String inchSize, String mtrlRecoAmt, String creUsrId, String mtrlCostAmt, String trfNo, String toRngSzNo, String costGrpCd, String dtlRmk, String cmFm, String rprLbrHrs, String fmRngSzNo, String inchFm, String eqCmpoUpCd, String stdTrfNo) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
		this.tempSeq = tempSeq;
		this.xchMtrlCostAmt = xchMtrlCostAmt;
		this.mnrRngTpCdView = mnrRngTpCdView;
		this.cmTo = cmTo;
		this.creDt = creDt;
		this.cmSize = cmSize;
		this.inchTo = inchTo;
		this.pagerows = pagerows;
		this.volTpCdView = volTpCdView;
		this.ibflag = ibflag;
		this.rprSzNo = rprSzNo;
		this.mapgRsltCd = mapgRsltCd;
		this.rprQty = rprQty;
		this.volTpCd = volTpCd;
		this.updUsrId = updUsrId;
		this.eqCmpoCd = eqCmpoCd;
		this.mnrRngTpCd = mnrRngTpCd;
		this.updDt = updDt;
		this.dtlDesc = dtlDesc;
		this.trfDivCd = trfDivCd;
		this.stdTrfNo = stdTrfNo;
		this.trfOptCd = trfOptCd;
		this.eqRprCd = eqRprCd;
		this.trfDtlSeq = trfDtlSeq;
		this.inchSize = inchSize;
		this.mtrlRecoAmt = mtrlRecoAmt;
		this.creUsrId = creUsrId;
		this.mtrlCostAmt = mtrlCostAmt;
		this.toRngSzNo = toRngSzNo;
		this.trfNo = trfNo;
		this.costGrpCd = costGrpCd;
		this.cmFm = cmFm;
		this.dtlRmk = dtlRmk;
		this.inchFm = inchFm;
		this.fmRngSzNo = fmRngSzNo;
		this.rprLbrHrs = rprLbrHrs;
		this.eqCmpoUpCd = eqCmpoUpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_vrfy_tp_cd", getMnrVrfyTpCd());
		this.hashColumns.put("temp_seq", getTempSeq());
		this.hashColumns.put("xch_mtrl_cost_amt", getXchMtrlCostAmt());
		this.hashColumns.put("mnr_rng_tp_cd_view", getMnrRngTpCdView());
		this.hashColumns.put("cm_to", getCmTo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cm_size", getCmSize());
		this.hashColumns.put("inch_to", getInchTo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vol_tp_cd_view", getVolTpCdView());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rpr_sz_no", getRprSzNo());
		this.hashColumns.put("mapg_rslt_cd", getMapgRsltCd());
		this.hashColumns.put("rpr_qty", getRprQty());
		this.hashColumns.put("vol_tp_cd", getVolTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eq_cmpo_cd", getEqCmpoCd());
		this.hashColumns.put("mnr_rng_tp_cd", getMnrRngTpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dtl_desc", getDtlDesc());
		this.hashColumns.put("trf_div_cd", getTrfDivCd());
		this.hashColumns.put("std_trf_no", getStdTrfNo());
		this.hashColumns.put("trf_opt_cd", getTrfOptCd());
		this.hashColumns.put("eq_rpr_cd", getEqRprCd());
		this.hashColumns.put("trf_dtl_seq", getTrfDtlSeq());
		this.hashColumns.put("inch_size", getInchSize());
		this.hashColumns.put("mtrl_reco_amt", getMtrlRecoAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mtrl_cost_amt", getMtrlCostAmt());
		this.hashColumns.put("to_rng_sz_no", getToRngSzNo());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("cost_grp_cd", getCostGrpCd());
		this.hashColumns.put("cm_fm", getCmFm());
		this.hashColumns.put("dtl_rmk", getDtlRmk());
		this.hashColumns.put("inch_fm", getInchFm());
		this.hashColumns.put("fm_rng_sz_no", getFmRngSzNo());
		this.hashColumns.put("rpr_lbr_hrs", getRprLbrHrs());
		this.hashColumns.put("eq_cmpo_up_cd", getEqCmpoUpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_vrfy_tp_cd", "mnrVrfyTpCd");
		this.hashFields.put("temp_seq", "tempSeq");
		this.hashFields.put("xch_mtrl_cost_amt", "xchMtrlCostAmt");
		this.hashFields.put("mnr_rng_tp_cd_view", "mnrRngTpCdView");
		this.hashFields.put("cm_to", "cmTo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cm_size", "cmSize");
		this.hashFields.put("inch_to", "inchTo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vol_tp_cd_view", "volTpCdView");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rpr_sz_no", "rprSzNo");
		this.hashFields.put("mapg_rslt_cd", "mapgRsltCd");
		this.hashFields.put("rpr_qty", "rprQty");
		this.hashFields.put("vol_tp_cd", "volTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eq_cmpo_cd", "eqCmpoCd");
		this.hashFields.put("mnr_rng_tp_cd", "mnrRngTpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dtl_desc", "dtlDesc");
		this.hashFields.put("trf_div_cd", "trfDivCd");
		this.hashFields.put("std_trf_no", "stdTrfNo");
		this.hashFields.put("trf_opt_cd", "trfOptCd");
		this.hashFields.put("eq_rpr_cd", "eqRprCd");
		this.hashFields.put("trf_dtl_seq", "trfDtlSeq");
		this.hashFields.put("inch_size", "inchSize");
		this.hashFields.put("mtrl_reco_amt", "mtrlRecoAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mtrl_cost_amt", "mtrlCostAmt");
		this.hashFields.put("to_rng_sz_no", "toRngSzNo");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("cost_grp_cd", "costGrpCd");
		this.hashFields.put("cm_fm", "cmFm");
		this.hashFields.put("dtl_rmk", "dtlRmk");
		this.hashFields.put("inch_fm", "inchFm");
		this.hashFields.put("fm_rng_sz_no", "fmRngSzNo");
		this.hashFields.put("rpr_lbr_hrs", "rprLbrHrs");
		this.hashFields.put("eq_cmpo_up_cd", "eqCmpoUpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnrVrfyTpCd
	 */
	public String getMnrVrfyTpCd() {
		return this.mnrVrfyTpCd;
	}
	
	/**
	 * Column Info
	 * @return tempSeq
	 */
	public String getTempSeq() {
		return this.tempSeq;
	}
	
	/**
	 * Column Info
	 * @return xchMtrlCostAmt
	 */
	public String getXchMtrlCostAmt() {
		return this.xchMtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return mnrRngTpCdView
	 */
	public String getMnrRngTpCdView() {
		return this.mnrRngTpCdView;
	}
	
	/**
	 * Column Info
	 * @return cmTo
	 */
	public String getCmTo() {
		return this.cmTo;
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
	 * @return cmSize
	 */
	public String getCmSize() {
		return this.cmSize;
	}
	
	/**
	 * Column Info
	 * @return inchTo
	 */
	public String getInchTo() {
		return this.inchTo;
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
	 * @return volTpCdView
	 */
	public String getVolTpCdView() {
		return this.volTpCdView;
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
	 * @return rprSzNo
	 */
	public String getRprSzNo() {
		return this.rprSzNo;
	}
	
	/**
	 * Column Info
	 * @return mapgRsltCd
	 */
	public String getMapgRsltCd() {
		return this.mapgRsltCd;
	}
	
	/**
	 * Column Info
	 * @return rprQty
	 */
	public String getRprQty() {
		return this.rprQty;
	}
	
	/**
	 * Column Info
	 * @return volTpCd
	 */
	public String getVolTpCd() {
		return this.volTpCd;
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
	 * @return eqCmpoCd
	 */
	public String getEqCmpoCd() {
		return this.eqCmpoCd;
	}
	
	/**
	 * Column Info
	 * @return mnrRngTpCd
	 */
	public String getMnrRngTpCd() {
		return this.mnrRngTpCd;
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
	 * @return dtlDesc
	 */
	public String getDtlDesc() {
		return this.dtlDesc;
	}
	
	/**
	 * Column Info
	 * @return trfDivCd
	 */
	public String getTrfDivCd() {
		return this.trfDivCd;
	}
	
	/**
	 * Column Info
	 * @return stdTrfNo
	 */
	public String getStdTrfNo() {
		return this.stdTrfNo;
	}
	
	/**
	 * Column Info
	 * @return trfOptCd
	 */
	public String getTrfOptCd() {
		return this.trfOptCd;
	}
	
	/**
	 * Column Info
	 * @return eqRprCd
	 */
	public String getEqRprCd() {
		return this.eqRprCd;
	}
	
	/**
	 * Column Info
	 * @return trfDtlSeq
	 */
	public String getTrfDtlSeq() {
		return this.trfDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return inchSize
	 */
	public String getInchSize() {
		return this.inchSize;
	}
	
	/**
	 * Column Info
	 * @return mtrlRecoAmt
	 */
	public String getMtrlRecoAmt() {
		return this.mtrlRecoAmt;
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
	 * @return mtrlCostAmt
	 */
	public String getMtrlCostAmt() {
		return this.mtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return toRngSzNo
	 */
	public String getToRngSzNo() {
		return this.toRngSzNo;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return costGrpCd
	 */
	public String getCostGrpCd() {
		return this.costGrpCd;
	}
	
	/**
	 * Column Info
	 * @return cmFm
	 */
	public String getCmFm() {
		return this.cmFm;
	}
	
	/**
	 * Column Info
	 * @return dtlRmk
	 */
	public String getDtlRmk() {
		return this.dtlRmk;
	}
	
	/**
	 * Column Info
	 * @return inchFm
	 */
	public String getInchFm() {
		return this.inchFm;
	}
	
	/**
	 * Column Info
	 * @return fmRngSzNo
	 */
	public String getFmRngSzNo() {
		return this.fmRngSzNo;
	}
	
	/**
	 * Column Info
	 * @return rprLbrHrs
	 */
	public String getRprLbrHrs() {
		return this.rprLbrHrs;
	}
	
	/**
	 * Column Info
	 * @return eqCmpoUpCd
	 */
	public String getEqCmpoUpCd() {
		return this.eqCmpoUpCd;
	}
	

	/**
	 * Column Info
	 * @param mnrVrfyTpCd
	 */
	public void setMnrVrfyTpCd(String mnrVrfyTpCd) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
	}
	
	/**
	 * Column Info
	 * @param tempSeq
	 */
	public void setTempSeq(String tempSeq) {
		this.tempSeq = tempSeq;
	}
	
	/**
	 * Column Info
	 * @param xchMtrlCostAmt
	 */
	public void setXchMtrlCostAmt(String xchMtrlCostAmt) {
		this.xchMtrlCostAmt = xchMtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param mnrRngTpCdView
	 */
	public void setMnrRngTpCdView(String mnrRngTpCdView) {
		this.mnrRngTpCdView = mnrRngTpCdView;
	}
	
	/**
	 * Column Info
	 * @param cmTo
	 */
	public void setCmTo(String cmTo) {
		this.cmTo = cmTo;
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
	 * @param cmSize
	 */
	public void setCmSize(String cmSize) {
		this.cmSize = cmSize;
	}
	
	/**
	 * Column Info
	 * @param inchTo
	 */
	public void setInchTo(String inchTo) {
		this.inchTo = inchTo;
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
	 * @param volTpCdView
	 */
	public void setVolTpCdView(String volTpCdView) {
		this.volTpCdView = volTpCdView;
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
	 * @param rprSzNo
	 */
	public void setRprSzNo(String rprSzNo) {
		this.rprSzNo = rprSzNo;
	}
	
	/**
	 * Column Info
	 * @param mapgRsltCd
	 */
	public void setMapgRsltCd(String mapgRsltCd) {
		this.mapgRsltCd = mapgRsltCd;
	}
	
	/**
	 * Column Info
	 * @param rprQty
	 */
	public void setRprQty(String rprQty) {
		this.rprQty = rprQty;
	}
	
	/**
	 * Column Info
	 * @param volTpCd
	 */
	public void setVolTpCd(String volTpCd) {
		this.volTpCd = volTpCd;
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
	 * @param eqCmpoCd
	 */
	public void setEqCmpoCd(String eqCmpoCd) {
		this.eqCmpoCd = eqCmpoCd;
	}
	
	/**
	 * Column Info
	 * @param mnrRngTpCd
	 */
	public void setMnrRngTpCd(String mnrRngTpCd) {
		this.mnrRngTpCd = mnrRngTpCd;
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
	 * @param dtlDesc
	 */
	public void setDtlDesc(String dtlDesc) {
		this.dtlDesc = dtlDesc;
	}
	
	/**
	 * Column Info
	 * @param trfDivCd
	 */
	public void setTrfDivCd(String trfDivCd) {
		this.trfDivCd = trfDivCd;
	}
	
	/**
	 * Column Info
	 * @param stdTrfNo
	 */
	public void setStdTrfNo(String stdTrfNo) {
		this.stdTrfNo = stdTrfNo;
	}
	
	/**
	 * Column Info
	 * @param trfOptCd
	 */
	public void setTrfOptCd(String trfOptCd) {
		this.trfOptCd = trfOptCd;
	}
	
	/**
	 * Column Info
	 * @param eqRprCd
	 */
	public void setEqRprCd(String eqRprCd) {
		this.eqRprCd = eqRprCd;
	}
	
	/**
	 * Column Info
	 * @param trfDtlSeq
	 */
	public void setTrfDtlSeq(String trfDtlSeq) {
		this.trfDtlSeq = trfDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param inchSize
	 */
	public void setInchSize(String inchSize) {
		this.inchSize = inchSize;
	}
	
	/**
	 * Column Info
	 * @param mtrlRecoAmt
	 */
	public void setMtrlRecoAmt(String mtrlRecoAmt) {
		this.mtrlRecoAmt = mtrlRecoAmt;
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
	 * @param mtrlCostAmt
	 */
	public void setMtrlCostAmt(String mtrlCostAmt) {
		this.mtrlCostAmt = mtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param toRngSzNo
	 */
	public void setToRngSzNo(String toRngSzNo) {
		this.toRngSzNo = toRngSzNo;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param costGrpCd
	 */
	public void setCostGrpCd(String costGrpCd) {
		this.costGrpCd = costGrpCd;
	}
	
	/**
	 * Column Info
	 * @param cmFm
	 */
	public void setCmFm(String cmFm) {
		this.cmFm = cmFm;
	}
	
	/**
	 * Column Info
	 * @param dtlRmk
	 */
	public void setDtlRmk(String dtlRmk) {
		this.dtlRmk = dtlRmk;
	}
	
	/**
	 * Column Info
	 * @param inchFm
	 */
	public void setInchFm(String inchFm) {
		this.inchFm = inchFm;
	}
	
	/**
	 * Column Info
	 * @param fmRngSzNo
	 */
	public void setFmRngSzNo(String fmRngSzNo) {
		this.fmRngSzNo = fmRngSzNo;
	}
	
	/**
	 * Column Info
	 * @param rprLbrHrs
	 */
	public void setRprLbrHrs(String rprLbrHrs) {
		this.rprLbrHrs = rprLbrHrs;
	}
	
	/**
	 * Column Info
	 * @param eqCmpoUpCd
	 */
	public void setEqCmpoUpCd(String eqCmpoUpCd) {
		this.eqCmpoUpCd = eqCmpoUpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMnrVrfyTpCd(JSPUtil.getParameter(request, "mnr_vrfy_tp_cd", ""));
		setTempSeq(JSPUtil.getParameter(request, "temp_seq", ""));
		setXchMtrlCostAmt(JSPUtil.getParameter(request, "xch_mtrl_cost_amt", ""));
		setMnrRngTpCdView(JSPUtil.getParameter(request, "mnr_rng_tp_cd_view", ""));
		setCmTo(JSPUtil.getParameter(request, "cm_to", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCmSize(JSPUtil.getParameter(request, "cm_size", ""));
		setInchTo(JSPUtil.getParameter(request, "inch_to", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVolTpCdView(JSPUtil.getParameter(request, "vol_tp_cd_view", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRprSzNo(JSPUtil.getParameter(request, "rpr_sz_no", ""));
		setMapgRsltCd(JSPUtil.getParameter(request, "mapg_rslt_cd", ""));
		setRprQty(JSPUtil.getParameter(request, "rpr_qty", ""));
		setVolTpCd(JSPUtil.getParameter(request, "vol_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setEqCmpoCd(JSPUtil.getParameter(request, "eq_cmpo_cd", ""));
		setMnrRngTpCd(JSPUtil.getParameter(request, "mnr_rng_tp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDtlDesc(JSPUtil.getParameter(request, "dtl_desc", ""));
		setTrfDivCd(JSPUtil.getParameter(request, "trf_div_cd", ""));
		setStdTrfNo(JSPUtil.getParameter(request, "std_trf_no", ""));
		setTrfOptCd(JSPUtil.getParameter(request, "trf_opt_cd", ""));
		setEqRprCd(JSPUtil.getParameter(request, "eq_rpr_cd", ""));
		setTrfDtlSeq(JSPUtil.getParameter(request, "trf_dtl_seq", ""));
		setInchSize(JSPUtil.getParameter(request, "inch_size", ""));
		setMtrlRecoAmt(JSPUtil.getParameter(request, "mtrl_reco_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setMtrlCostAmt(JSPUtil.getParameter(request, "mtrl_cost_amt", ""));
		setToRngSzNo(JSPUtil.getParameter(request, "to_rng_sz_no", ""));
		setTrfNo(JSPUtil.getParameter(request, "trf_no", ""));
		setCostGrpCd(JSPUtil.getParameter(request, "cost_grp_cd", ""));
		setCmFm(JSPUtil.getParameter(request, "cm_fm", ""));
		setDtlRmk(JSPUtil.getParameter(request, "dtl_rmk", ""));
		setInchFm(JSPUtil.getParameter(request, "inch_fm", ""));
		setFmRngSzNo(JSPUtil.getParameter(request, "fm_rng_sz_no", ""));
		setRprLbrHrs(JSPUtil.getParameter(request, "rpr_lbr_hrs", ""));
		setEqCmpoUpCd(JSPUtil.getParameter(request, "eq_cmpo_up_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrRprTrfDtlVO[]
	 */
	public CustomMnrRprTrfDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrRprTrfDtlVO[]
	 */
	public CustomMnrRprTrfDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrRprTrfDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_vrfy_tp_cd", length));
			String[] tempSeq = (JSPUtil.getParameter(request, prefix	+ "temp_seq", length));
			String[] xchMtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "xch_mtrl_cost_amt", length));
			String[] mnrRngTpCdView = (JSPUtil.getParameter(request, prefix	+ "mnr_rng_tp_cd_view", length));
			String[] cmTo = (JSPUtil.getParameter(request, prefix	+ "cm_to", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cmSize = (JSPUtil.getParameter(request, prefix	+ "cm_size", length));
			String[] inchTo = (JSPUtil.getParameter(request, prefix	+ "inch_to", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] volTpCdView = (JSPUtil.getParameter(request, prefix	+ "vol_tp_cd_view", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rprSzNo = (JSPUtil.getParameter(request, prefix	+ "rpr_sz_no", length));
			String[] mapgRsltCd = (JSPUtil.getParameter(request, prefix	+ "mapg_rslt_cd", length));
			String[] rprQty = (JSPUtil.getParameter(request, prefix	+ "rpr_qty", length));
			String[] volTpCd = (JSPUtil.getParameter(request, prefix	+ "vol_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] eqCmpoCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd", length));
			String[] mnrRngTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_rng_tp_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dtlDesc = (JSPUtil.getParameter(request, prefix	+ "dtl_desc", length));
			String[] trfDivCd = (JSPUtil.getParameter(request, prefix	+ "trf_div_cd", length));
			String[] stdTrfNo = (JSPUtil.getParameter(request, prefix	+ "std_trf_no", length));
			String[] trfOptCd = (JSPUtil.getParameter(request, prefix	+ "trf_opt_cd", length));
			String[] eqRprCd = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_cd", length));
			String[] trfDtlSeq = (JSPUtil.getParameter(request, prefix	+ "trf_dtl_seq", length));
			String[] inchSize = (JSPUtil.getParameter(request, prefix	+ "inch_size", length));
			String[] mtrlRecoAmt = (JSPUtil.getParameter(request, prefix	+ "mtrl_reco_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mtrl_cost_amt", length));
			String[] toRngSzNo = (JSPUtil.getParameter(request, prefix	+ "to_rng_sz_no", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] costGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_grp_cd", length));
			String[] cmFm = (JSPUtil.getParameter(request, prefix	+ "cm_fm", length));
			String[] dtlRmk = (JSPUtil.getParameter(request, prefix	+ "dtl_rmk", length));
			String[] inchFm = (JSPUtil.getParameter(request, prefix	+ "inch_fm", length));
			String[] fmRngSzNo = (JSPUtil.getParameter(request, prefix	+ "fm_rng_sz_no", length));
			String[] rprLbrHrs = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_hrs", length));
			String[] eqCmpoUpCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_up_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrRprTrfDtlVO();
				if (mnrVrfyTpCd[i] != null)
					model.setMnrVrfyTpCd(mnrVrfyTpCd[i]);
				if (tempSeq[i] != null)
					model.setTempSeq(tempSeq[i]);
				if (xchMtrlCostAmt[i] != null)
					model.setXchMtrlCostAmt(xchMtrlCostAmt[i]);
				if (mnrRngTpCdView[i] != null)
					model.setMnrRngTpCdView(mnrRngTpCdView[i]);
				if (cmTo[i] != null)
					model.setCmTo(cmTo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cmSize[i] != null)
					model.setCmSize(cmSize[i]);
				if (inchTo[i] != null)
					model.setInchTo(inchTo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (volTpCdView[i] != null)
					model.setVolTpCdView(volTpCdView[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rprSzNo[i] != null)
					model.setRprSzNo(rprSzNo[i]);
				if (mapgRsltCd[i] != null)
					model.setMapgRsltCd(mapgRsltCd[i]);
				if (rprQty[i] != null)
					model.setRprQty(rprQty[i]);
				if (volTpCd[i] != null)
					model.setVolTpCd(volTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (eqCmpoCd[i] != null)
					model.setEqCmpoCd(eqCmpoCd[i]);
				if (mnrRngTpCd[i] != null)
					model.setMnrRngTpCd(mnrRngTpCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dtlDesc[i] != null)
					model.setDtlDesc(dtlDesc[i]);
				if (trfDivCd[i] != null)
					model.setTrfDivCd(trfDivCd[i]);
				if (stdTrfNo[i] != null)
					model.setStdTrfNo(stdTrfNo[i]);
				if (trfOptCd[i] != null)
					model.setTrfOptCd(trfOptCd[i]);
				if (eqRprCd[i] != null)
					model.setEqRprCd(eqRprCd[i]);
				if (trfDtlSeq[i] != null)
					model.setTrfDtlSeq(trfDtlSeq[i]);
				if (inchSize[i] != null)
					model.setInchSize(inchSize[i]);
				if (mtrlRecoAmt[i] != null)
					model.setMtrlRecoAmt(mtrlRecoAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mtrlCostAmt[i] != null)
					model.setMtrlCostAmt(mtrlCostAmt[i]);
				if (toRngSzNo[i] != null)
					model.setToRngSzNo(toRngSzNo[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (costGrpCd[i] != null)
					model.setCostGrpCd(costGrpCd[i]);
				if (cmFm[i] != null)
					model.setCmFm(cmFm[i]);
				if (dtlRmk[i] != null)
					model.setDtlRmk(dtlRmk[i]);
				if (inchFm[i] != null)
					model.setInchFm(inchFm[i]);
				if (fmRngSzNo[i] != null)
					model.setFmRngSzNo(fmRngSzNo[i]);
				if (rprLbrHrs[i] != null)
					model.setRprLbrHrs(rprLbrHrs[i]);
				if (eqCmpoUpCd[i] != null)
					model.setEqCmpoUpCd(eqCmpoUpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrRprTrfDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrRprTrfDtlVO[]
	 */
	public CustomMnrRprTrfDtlVO[] getCustomMnrRprTrfDtlVOs(){
		CustomMnrRprTrfDtlVO[] vos = (CustomMnrRprTrfDtlVO[])models.toArray(new CustomMnrRprTrfDtlVO[models.size()]);
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
		this.mnrVrfyTpCd = this.mnrVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempSeq = this.tempSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchMtrlCostAmt = this.xchMtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRngTpCdView = this.mnrRngTpCdView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmTo = this.cmTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmSize = this.cmSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inchTo = this.inchTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTpCdView = this.volTpCdView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprSzNo = this.rprSzNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgRsltCd = this.mapgRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprQty = this.rprQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTpCd = this.volTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCd = this.eqCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRngTpCd = this.mnrRngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlDesc = this.dtlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfDivCd = this.trfDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stdTrfNo = this.stdTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfOptCd = this.trfOptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprCd = this.eqRprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfDtlSeq = this.trfDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inchSize = this.inchSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlRecoAmt = this.mtrlRecoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlCostAmt = this.mtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRngSzNo = this.toRngSzNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costGrpCd = this.costGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmFm = this.cmFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlRmk = this.dtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inchFm = this.inchFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRngSzNo = this.fmRngSzNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrHrs = this.rprLbrHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoUpCd = this.eqCmpoUpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
