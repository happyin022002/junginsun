/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairPFMCByRepairCodeVO.java
*@FileTitle : RepairPFMCByRepairCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.28
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.05.28 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**	
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairPFMCByRepairCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairPFMCByRepairCodeVO> models = new ArrayList<RepairPFMCByRepairCodeVO>();
	
	/* Column Info */
	private String eqLocCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String trfDivCd = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String eqRprCd = null;
	/* Column Info */
	private String qty = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String tAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqCmpoNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lbrCostAmt = null;
	/* Column Info */
	private String eqDmgCd = null;
	/* Column Info */
	private String rprLbrRt = null;
	/* Column Info */
	private String mtrlCostAmt = null;
	/* Column Info */
	private String tAvg = null;
	/* Column Info */
	private String trfDivNm = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String rprLbrHrs = null;
	/* Column Info */
	private String vndrSeqNm = null;
	/* Column Info */
	private String eqRprNm = null;
	/* Column Info */
	private String eqDmgNm = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String eqCmpoCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RepairPFMCByRepairCodeVO() {}

	public RepairPFMCByRepairCodeVO(String ibflag, String pagerows, String eqLocCd, String currCd, String trfDivCd, String trfDivNm, String costOfcCd, String eqRprCd, String eqRprNm, String qty, String eqKndCd, String tAmt, String lbrCostAmt, String rprLbrRt, String eqDmgCd, String eqDmgNm, String tAvg, String mtrlCostAmt, String vndrSeq, String vndrSeqNm, String rprLbrHrs, String eqCmpoCd, String eqCmpoNm, String rhq) {
		this.eqLocCd = eqLocCd;
		this.currCd = currCd;
		this.trfDivCd = trfDivCd;
		this.costOfcCd = costOfcCd;
		this.eqRprCd = eqRprCd;
		this.qty = qty;
		this.eqKndCd = eqKndCd;
		this.tAmt = tAmt;
		this.pagerows = pagerows;
		this.eqCmpoNm = eqCmpoNm;
		this.ibflag = ibflag;
		this.lbrCostAmt = lbrCostAmt;
		this.eqDmgCd = eqDmgCd;
		this.rprLbrRt = rprLbrRt;
		this.mtrlCostAmt = mtrlCostAmt;
		this.tAvg = tAvg;
		this.trfDivNm = trfDivNm;
		this.vndrSeq = vndrSeq;
		this.rprLbrHrs = rprLbrHrs;
		this.vndrSeqNm = vndrSeqNm;
		this.eqRprNm = eqRprNm;
		this.eqDmgNm = eqDmgNm;
		this.rhq = rhq;
		this.eqCmpoCd = eqCmpoCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eq_loc_cd", getEqLocCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("trf_div_cd", getTrfDivCd());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("eq_rpr_cd", getEqRprCd());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("t_amt", getTAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_cmpo_nm", getEqCmpoNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lbr_cost_amt", getLbrCostAmt());
		this.hashColumns.put("eq_dmg_cd", getEqDmgCd());
		this.hashColumns.put("rpr_lbr_rt", getRprLbrRt());
		this.hashColumns.put("mtrl_cost_amt", getMtrlCostAmt());
		this.hashColumns.put("t_avg", getTAvg());
		this.hashColumns.put("trf_div_nm", getTrfDivNm());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("rpr_lbr_hrs", getRprLbrHrs());
		this.hashColumns.put("vndr_seq_nm", getVndrSeqNm());
		this.hashColumns.put("eq_rpr_nm", getEqRprNm());
		this.hashColumns.put("eq_dmg_nm", getEqDmgNm());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("eq_cmpo_cd", getEqCmpoCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eq_loc_cd", "eqLocCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("trf_div_cd", "trfDivCd");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("eq_rpr_cd", "eqRprCd");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("t_amt", "tAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_cmpo_nm", "eqCmpoNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lbr_cost_amt", "lbrCostAmt");
		this.hashFields.put("eq_dmg_cd", "eqDmgCd");
		this.hashFields.put("rpr_lbr_rt", "rprLbrRt");
		this.hashFields.put("mtrl_cost_amt", "mtrlCostAmt");
		this.hashFields.put("t_avg", "tAvg");
		this.hashFields.put("trf_div_nm", "trfDivNm");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("rpr_lbr_hrs", "rprLbrHrs");
		this.hashFields.put("vndr_seq_nm", "vndrSeqNm");
		this.hashFields.put("eq_rpr_nm", "eqRprNm");
		this.hashFields.put("eq_dmg_nm", "eqDmgNm");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("eq_cmpo_cd", "eqCmpoCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eqLocCd
	 */
	public String getEqLocCd() {
		return this.eqLocCd;
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
	 * @return trfDivCd
	 */
	public String getTrfDivCd() {
		return this.trfDivCd;
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
	 * @return eqRprCd
	 */
	public String getEqRprCd() {
		return this.eqRprCd;
	}
	
	/**
	 * Column Info
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
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
	 * @return tAmt
	 */
	public String getTAmt() {
		return this.tAmt;
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
	 * @return eqCmpoNm
	 */
	public String getEqCmpoNm() {
		return this.eqCmpoNm;
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
	 * @return eqDmgCd
	 */
	public String getEqDmgCd() {
		return this.eqDmgCd;
	}
	
	/**
	 * Column Info
	 * @return rprLbrRt
	 */
	public String getRprLbrRt() {
		return this.rprLbrRt;
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
	 * @return tAvg
	 */
	public String getTAvg() {
		return this.tAvg;
	}
	
	/**
	 * Column Info
	 * @return trfDivNm
	 */
	public String getTrfDivNm() {
		return this.trfDivNm;
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
	 * @return rprLbrHrs
	 */
	public String getRprLbrHrs() {
		return this.rprLbrHrs;
	}
	
	/**
	 * Column Info
	 * @return vndrSeqNm
	 */
	public String getVndrSeqNm() {
		return this.vndrSeqNm;
	}
	
	/**
	 * Column Info
	 * @return eqRprNm
	 */
	public String getEqRprNm() {
		return this.eqRprNm;
	}
	
	/**
	 * Column Info
	 * @return eqDmgNm
	 */
	public String getEqDmgNm() {
		return this.eqDmgNm;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
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
	 * @param eqLocCd
	 */
	public void setEqLocCd(String eqLocCd) {
		this.eqLocCd = eqLocCd;
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
	 * @param trfDivCd
	 */
	public void setTrfDivCd(String trfDivCd) {
		this.trfDivCd = trfDivCd;
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
	 * @param eqRprCd
	 */
	public void setEqRprCd(String eqRprCd) {
		this.eqRprCd = eqRprCd;
	}
	
	/**
	 * Column Info
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
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
	 * @param tAmt
	 */
	public void setTAmt(String tAmt) {
		this.tAmt = tAmt;
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
	 * @param eqCmpoNm
	 */
	public void setEqCmpoNm(String eqCmpoNm) {
		this.eqCmpoNm = eqCmpoNm;
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
	 * @param eqDmgCd
	 */
	public void setEqDmgCd(String eqDmgCd) {
		this.eqDmgCd = eqDmgCd;
	}
	
	/**
	 * Column Info
	 * @param rprLbrRt
	 */
	public void setRprLbrRt(String rprLbrRt) {
		this.rprLbrRt = rprLbrRt;
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
	 * @param tAvg
	 */
	public void setTAvg(String tAvg) {
		this.tAvg = tAvg;
	}
	
	/**
	 * Column Info
	 * @param trfDivNm
	 */
	public void setTrfDivNm(String trfDivNm) {
		this.trfDivNm = trfDivNm;
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
	 * @param rprLbrHrs
	 */
	public void setRprLbrHrs(String rprLbrHrs) {
		this.rprLbrHrs = rprLbrHrs;
	}
	
	/**
	 * Column Info
	 * @param vndrSeqNm
	 */
	public void setVndrSeqNm(String vndrSeqNm) {
		this.vndrSeqNm = vndrSeqNm;
	}
	
	/**
	 * Column Info
	 * @param eqRprNm
	 */
	public void setEqRprNm(String eqRprNm) {
		this.eqRprNm = eqRprNm;
	}
	
	/**
	 * Column Info
	 * @param eqDmgNm
	 */
	public void setEqDmgNm(String eqDmgNm) {
		this.eqDmgNm = eqDmgNm;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param eqCmpoCd
	 */
	public void setEqCmpoCd(String eqCmpoCd) {
		this.eqCmpoCd = eqCmpoCd;
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
		setEqLocCd(JSPUtil.getParameter(request, prefix + "eq_loc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTrfDivCd(JSPUtil.getParameter(request, prefix + "trf_div_cd", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setEqRprCd(JSPUtil.getParameter(request, prefix + "eq_rpr_cd", ""));
		setQty(JSPUtil.getParameter(request, prefix + "qty", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setTAmt(JSPUtil.getParameter(request, prefix + "t_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEqCmpoNm(JSPUtil.getParameter(request, prefix + "eq_cmpo_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLbrCostAmt(JSPUtil.getParameter(request, prefix + "lbr_cost_amt", ""));
		setEqDmgCd(JSPUtil.getParameter(request, prefix + "eq_dmg_cd", ""));
		setRprLbrRt(JSPUtil.getParameter(request, prefix + "rpr_lbr_rt", ""));
		setMtrlCostAmt(JSPUtil.getParameter(request, prefix + "mtrl_cost_amt", ""));
		setTAvg(JSPUtil.getParameter(request, prefix + "t_avg", ""));
		setTrfDivNm(JSPUtil.getParameter(request, prefix + "trf_div_nm", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setRprLbrHrs(JSPUtil.getParameter(request, prefix + "rpr_lbr_hrs", ""));
		setVndrSeqNm(JSPUtil.getParameter(request, prefix + "vndr_seq_nm", ""));
		setEqRprNm(JSPUtil.getParameter(request, prefix + "eq_rpr_nm", ""));
		setEqDmgNm(JSPUtil.getParameter(request, prefix + "eq_dmg_nm", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setEqCmpoCd(JSPUtil.getParameter(request, prefix + "eq_cmpo_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairPFMCByRepairCodeVO[]
	 */
	public RepairPFMCByRepairCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairPFMCByRepairCodeVO[]
	 */
	public RepairPFMCByRepairCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairPFMCByRepairCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eqLocCd = (JSPUtil.getParameter(request, prefix	+ "eq_loc_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] trfDivCd = (JSPUtil.getParameter(request, prefix	+ "trf_div_cd", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] eqRprCd = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_cd", length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] tAmt = (JSPUtil.getParameter(request, prefix	+ "t_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqCmpoNm = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lbrCostAmt = (JSPUtil.getParameter(request, prefix	+ "lbr_cost_amt", length));
			String[] eqDmgCd = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_cd", length));
			String[] rprLbrRt = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_rt", length));
			String[] mtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mtrl_cost_amt", length));
			String[] tAvg = (JSPUtil.getParameter(request, prefix	+ "t_avg", length));
			String[] trfDivNm = (JSPUtil.getParameter(request, prefix	+ "trf_div_nm", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] rprLbrHrs = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_hrs", length));
			String[] vndrSeqNm = (JSPUtil.getParameter(request, prefix	+ "vndr_seq_nm", length));
			String[] eqRprNm = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_nm", length));
			String[] eqDmgNm = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_nm", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] eqCmpoCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepairPFMCByRepairCodeVO();
				if (eqLocCd[i] != null)
					model.setEqLocCd(eqLocCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (trfDivCd[i] != null)
					model.setTrfDivCd(trfDivCd[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (eqRprCd[i] != null)
					model.setEqRprCd(eqRprCd[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (tAmt[i] != null)
					model.setTAmt(tAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqCmpoNm[i] != null)
					model.setEqCmpoNm(eqCmpoNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lbrCostAmt[i] != null)
					model.setLbrCostAmt(lbrCostAmt[i]);
				if (eqDmgCd[i] != null)
					model.setEqDmgCd(eqDmgCd[i]);
				if (rprLbrRt[i] != null)
					model.setRprLbrRt(rprLbrRt[i]);
				if (mtrlCostAmt[i] != null)
					model.setMtrlCostAmt(mtrlCostAmt[i]);
				if (tAvg[i] != null)
					model.setTAvg(tAvg[i]);
				if (trfDivNm[i] != null)
					model.setTrfDivNm(trfDivNm[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (rprLbrHrs[i] != null)
					model.setRprLbrHrs(rprLbrHrs[i]);
				if (vndrSeqNm[i] != null)
					model.setVndrSeqNm(vndrSeqNm[i]);
				if (eqRprNm[i] != null)
					model.setEqRprNm(eqRprNm[i]);
				if (eqDmgNm[i] != null)
					model.setEqDmgNm(eqDmgNm[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (eqCmpoCd[i] != null)
					model.setEqCmpoCd(eqCmpoCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairPFMCByRepairCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairPFMCByRepairCodeVO[]
	 */
	public RepairPFMCByRepairCodeVO[] getRepairPFMCByRepairCodeVOs(){
		RepairPFMCByRepairCodeVO[] vos = (RepairPFMCByRepairCodeVO[])models.toArray(new RepairPFMCByRepairCodeVO[models.size()]);
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
		this.eqLocCd = this.eqLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfDivCd = this.trfDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprCd = this.eqRprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tAmt = this.tAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoNm = this.eqCmpoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbrCostAmt = this.lbrCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgCd = this.eqDmgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrRt = this.rprLbrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlCostAmt = this.mtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tAvg = this.tAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfDivNm = this.trfDivNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrHrs = this.rprLbrHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeqNm = this.vndrSeqNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprNm = this.eqRprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgNm = this.eqDmgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCd = this.eqCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
