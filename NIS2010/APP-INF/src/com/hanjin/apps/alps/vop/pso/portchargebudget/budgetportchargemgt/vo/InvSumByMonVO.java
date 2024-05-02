/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvSumByMonVO.java
*@FileTitle : InvSumByMonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.01.12 이석준 
* 1.0 Creation
* 
* History
* 2011.03.04 진마리아 CHM-201108565-01 Port Charge Invoice Summary 조회 로직 변경 - ctrl h/q 조회로직 변경 및 조회조건(created id), 결과(csr no, status) 컬럼 추가
* 2014.07.22 이성훈 CHM-201430727 [PSO] Tariff 및 Adjustment Cost 칼럼 추가 - 조회결과(tariffCost, adjustCost) 컬럼 추가
* 2014.12.29 김기원 CHM-201433349  조회 조건 추가 및 정렬기준 변경
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo;

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
 * @author 이석준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvSumByMonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvSumByMonVO> models = new ArrayList<InvSumByMonVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String combo1 = null;
	/* Column Info */
	private String costNm = null;
	/* Column Info */
	private String soSeq = null;
	/* Column Info */
	private String fomlDesc = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String acctEngNm = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String issCtyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String vopPortRhqCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String berthDate = null;
	/* Column Info */
	private String loclAmt = null;
	/* Column Info */
	private String adjAmt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String psoChgStsNm = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String dateType = null;
	/* Column Info */
	private String calcAmt = null;
	/* Column Info */
	private String cntrVslClssCapa = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vskdPortRhqCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String differ = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String soDtlSeq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String xprDesc = null;
	/* Column Info */
	private String termCode = null;
	/* Column Info */
	private String vslClss = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String tariffCost = null;
	/* Column Info */
	private String adjustCost = null;	
	/* Column Info */
	private String conDt = null;
	/* Column Info */
	private String cntCd = null;	
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvSumByMonVO() {}

	public InvSumByMonVO(String ibflag, String pagerows, String vslCd, String currCd, String combo1, String fomlDesc, String soSeq, String vndrLglEngNm, String acctEngNm, String issCtyCd, String vopPortRhqCd, String slsOfcCd, String acctCd, String portCd, String csrNo, String status, String loclAmt, String adjAmt, String skdVoyNo, String psoChgStsNm, String toDate, String calcAmt, String skdDirCd, String invNo, String differ, String usdAmt, String diffRmk, String fromDate, String ydCd, String soDtlSeq, String vndrSeq, String xprDesc, String termCode, String dateType, String cntrVslClssCapa, String costCd, String costNm, String vvd, String vskdPortRhqCd, String vslSlanCd, String vslClss, String berthDate, String creUsrId, String tariffCost, String adjustCost, String conDt,String cntCd) {
		this.vslCd = vslCd;
		this.currCd = currCd;
		this.combo1 = combo1;
		this.costNm = costNm;
		this.soSeq = soSeq;
		this.fomlDesc = fomlDesc;
		this.vndrLglEngNm = vndrLglEngNm;
		this.acctEngNm = acctEngNm;
		this.vslSlanCd = vslSlanCd;
		this.issCtyCd = issCtyCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costCd = costCd;
		this.vopPortRhqCd = vopPortRhqCd;
		this.acctCd = acctCd;
		this.slsOfcCd = slsOfcCd;
		this.portCd = portCd;
		this.csrNo = csrNo;
		this.status = status;
		this.berthDate = berthDate;
		this.loclAmt = loclAmt;
		this.adjAmt = adjAmt;
		this.skdVoyNo = skdVoyNo;
		this.psoChgStsNm = psoChgStsNm;
		this.toDate = toDate;
		this.dateType = dateType;
		this.calcAmt = calcAmt;
		this.cntrVslClssCapa = cntrVslClssCapa;
		this.skdDirCd = skdDirCd;
		this.vskdPortRhqCd = vskdPortRhqCd;
		this.vvd = vvd;
		this.invNo = invNo;
		this.differ = differ;
		this.usdAmt = usdAmt;
		this.diffRmk = diffRmk;
		this.fromDate = fromDate;
		this.soDtlSeq = soDtlSeq;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.xprDesc = xprDesc;
		this.termCode = termCode;
		this.vslClss = vslClss;
		this.creUsrId = creUsrId;
		this.tariffCost = tariffCost;
		this.adjustCost = adjustCost;
		this.conDt      = conDt;
		this.cntCd      = cntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("combo1", getCombo1());
		this.hashColumns.put("cost_nm", getCostNm());
		this.hashColumns.put("so_seq", getSoSeq());
		this.hashColumns.put("foml_desc", getFomlDesc());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("acct_eng_nm", getAcctEngNm());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("iss_cty_cd", getIssCtyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("vop_port_rhq_cd", getVopPortRhqCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("berth_date", getBerthDate());
		this.hashColumns.put("locl_amt", getLoclAmt());
		this.hashColumns.put("adj_amt", getAdjAmt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pso_chg_sts_nm", getPsoChgStsNm());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("date_type", getDateType());
		this.hashColumns.put("calc_amt", getCalcAmt());
		this.hashColumns.put("cntr_vsl_clss_capa", getCntrVslClssCapa());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vskd_port_rhq_cd", getVskdPortRhqCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("differ", getDiffer());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("so_dtl_seq", getSoDtlSeq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("xpr_desc", getXprDesc());
		this.hashColumns.put("term_code", getTermCode());
		this.hashColumns.put("vsl_clss", getVslClss());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("tariff_cost", getTariffCost());	
		this.hashColumns.put("adjust_cost", getAdjustCost());	
		this.hashColumns.put("con_dt", getConDt());	
		this.hashColumns.put("cnt_cd", getCntCd());	
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("combo1", "combo1");
		this.hashFields.put("cost_nm", "costNm");
		this.hashFields.put("so_seq", "soSeq");
		this.hashFields.put("foml_desc", "fomlDesc");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("acct_eng_nm", "acctEngNm");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("iss_cty_cd", "issCtyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("vop_port_rhq_cd", "vopPortRhqCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("status", "status");
		this.hashFields.put("berth_date", "berthDate");
		this.hashFields.put("locl_amt", "loclAmt");
		this.hashFields.put("adj_amt", "adjAmt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pso_chg_sts_nm", "psoChgStsNm");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("date_type", "dateType");
		this.hashFields.put("calc_amt", "calcAmt");
		this.hashFields.put("cntr_vsl_clss_capa", "cntrVslClssCapa");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vskd_port_rhq_cd", "vskdPortRhqCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("differ", "differ");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("so_dtl_seq", "soDtlSeq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("xpr_desc", "xprDesc");
		this.hashFields.put("term_code", "termCode");
		this.hashFields.put("vsl_clss", "vslClss");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("tariff_cost", "tariffCost");
		this.hashFields.put("adjust_cost", "adjustCost");		
		this.hashFields.put("con_dt", "conDt");		
		this.hashFields.put("cnt_cd", "cntCd");	
		return this.hashFields;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return combo1
	 */
	public String getCombo1() {
		return this.combo1;
	}
	
	/**
	 * Column Info
	 * @return costNm
	 */
	public String getCostNm() {
		return this.costNm;
	}
	
	/**
	 * Column Info
	 * @return soSeq
	 */
	public String getSoSeq() {
		return this.soSeq;
	}
	
	/**
	 * Column Info
	 * @return fomlDesc
	 */
	public String getFomlDesc() {
		return this.fomlDesc;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return acctEngNm
	 */
	public String getAcctEngNm() {
		return this.acctEngNm;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return issCtyCd
	 */
	public String getIssCtyCd() {
		return this.issCtyCd;
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
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return vopPortRhqCd
	 */
	public String getVopPortRhqCd() {
		return this.vopPortRhqCd;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return berthDate
	 */
	public String getBerthDate() {
		return this.berthDate;
	}
	
	/**
	 * Column Info
	 * @return loclAmt
	 */
	public String getLoclAmt() {
		return this.loclAmt;
	}
	
	/**
	 * Column Info
	 * @return adjAmt
	 */
	public String getAdjAmt() {
		return this.adjAmt;
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
	 * @return psoChgStsNm
	 */
	public String getPsoChgStsNm() {
		return this.psoChgStsNm;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return dateType
	 */
	public String getDateType() {
		return this.dateType;
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
	 * @return cntrVslClssCapa
	 */
	public String getCntrVslClssCapa() {
		return this.cntrVslClssCapa;
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
	 * @return vskdPortRhqCd
	 */
	public String getVskdPortRhqCd() {
		return this.vskdPortRhqCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return differ
	 */
	public String getDiffer() {
		return this.differ;
	}
	
	/**
	 * Column Info
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
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
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
	}
	
	/**
	 * Column Info
	 * @return soDtlSeq
	 */
	public String getSoDtlSeq() {
		return this.soDtlSeq;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return xprDesc
	 */
	public String getXprDesc() {
		return this.xprDesc;
	}
	
	/**
	 * Column Info
	 * @return termCode
	 */
	public String getTermCode() {
		return this.termCode;
	}
	
	/**
	 * Column Info
	 * @return vslClss
	 */
	public String getVslClss() {
		return this.vslClss;
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
	 * @return tariffCost
	 */
	public String getTariffCost() {
		return this.tariffCost;
	}

	/**
	 * Column Info
	 * @return adjustCost
	 */
	public String getAdjustCost() {
		return this.adjustCost;
	}
	
	/**
	 * Column Info
	 * @return conDt
	 */
	public String getConDt() {
		return this.conDt;
	}

	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}

	
	/**
	 * Column Info
	 * @param conDt
	 */
	public void setConDt(String conDt) {
		this.conDt = conDt;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param combo1
	 */
	public void setCombo1(String combo1) {
		this.combo1 = combo1;
	}
	
	/**
	 * Column Info
	 * @param costNm
	 */
	public void setCostNm(String costNm) {
		this.costNm = costNm;
	}
	
	/**
	 * Column Info
	 * @param soSeq
	 */
	public void setSoSeq(String soSeq) {
		this.soSeq = soSeq;
	}
	
	/**
	 * Column Info
	 * @param fomlDesc
	 */
	public void setFomlDesc(String fomlDesc) {
		this.fomlDesc = fomlDesc;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param acctEngNm
	 */
	public void setAcctEngNm(String acctEngNm) {
		this.acctEngNm = acctEngNm;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param issCtyCd
	 */
	public void setIssCtyCd(String issCtyCd) {
		this.issCtyCd = issCtyCd;
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
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param vopPortRhqCd
	 */
	public void setVopPortRhqCd(String vopPortRhqCd) {
		this.vopPortRhqCd = vopPortRhqCd;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param berthDate
	 */
	public void setBerthDate(String berthDate) {
		this.berthDate = berthDate;
	}
	
	/**
	 * Column Info
	 * @param loclAmt
	 */
	public void setLoclAmt(String loclAmt) {
		this.loclAmt = loclAmt;
	}
	
	/**
	 * Column Info
	 * @param adjAmt
	 */
	public void setAdjAmt(String adjAmt) {
		this.adjAmt = adjAmt;
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
	 * @param psoChgStsNm
	 */
	public void setPsoChgStsNm(String psoChgStsNm) {
		this.psoChgStsNm = psoChgStsNm;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param dateType
	 */
	public void setDateType(String dateType) {
		this.dateType = dateType;
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
	 * @param cntrVslClssCapa
	 */
	public void setCntrVslClssCapa(String cntrVslClssCapa) {
		this.cntrVslClssCapa = cntrVslClssCapa;
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
	 * @param vskdPortRhqCd
	 */
	public void setVskdPortRhqCd(String vskdPortRhqCd) {
		this.vskdPortRhqCd = vskdPortRhqCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param differ
	 */
	public void setDiffer(String differ) {
		this.differ = differ;
	}
	
	/**
	 * Column Info
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
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
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	/**
	 * Column Info
	 * @param soDtlSeq
	 */
	public void setSoDtlSeq(String soDtlSeq) {
		this.soDtlSeq = soDtlSeq;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param xprDesc
	 */
	public void setXprDesc(String xprDesc) {
		this.xprDesc = xprDesc;
	}
	
	/**
	 * Column Info
	 * @param termCode
	 */
	public void setTermCode(String termCode) {
		this.termCode = termCode;
	}
	
	/**
	 * Column Info
	 * @param vslClss
	 */
	public void setVslClss(String vslClss) {
		this.vslClss = vslClss;
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
	 * @param tariffCost
	 */
	public void setTariffCost(String tariffCost) {
		this.tariffCost = tariffCost;
	}

	/**
	 * Column Info
	 * @param adjustCost
	 */
	public void setAdjustCost(String adjustCost) {
		this.adjustCost = adjustCost;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCombo1(JSPUtil.getParameter(request, prefix + "combo1", ""));
		setCostNm(JSPUtil.getParameter(request, prefix + "cost_nm", ""));
		setSoSeq(JSPUtil.getParameter(request, prefix + "so_seq", ""));
		setFomlDesc(JSPUtil.getParameter(request, prefix + "foml_desc", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setAcctEngNm(JSPUtil.getParameter(request, prefix + "acct_eng_nm", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setIssCtyCd(JSPUtil.getParameter(request, prefix + "iss_cty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setVopPortRhqCd(JSPUtil.getParameter(request, prefix + "vop_port_rhq_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setBerthDate(JSPUtil.getParameter(request, prefix + "berth_date", ""));
		setLoclAmt(JSPUtil.getParameter(request, prefix + "locl_amt", ""));
		setAdjAmt(JSPUtil.getParameter(request, prefix + "adj_amt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setPsoChgStsNm(JSPUtil.getParameter(request, prefix + "pso_chg_sts_nm", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setDateType(JSPUtil.getParameter(request, prefix + "date_type", ""));
		setCalcAmt(JSPUtil.getParameter(request, prefix + "calc_amt", ""));
		setCntrVslClssCapa(JSPUtil.getParameter(request, prefix + "cntr_vsl_clss_capa", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVskdPortRhqCd(JSPUtil.getParameter(request, prefix + "vskd_port_rhq_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setDiffer(JSPUtil.getParameter(request, prefix + "differ", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setFromDate(JSPUtil.getParameter(request, prefix + "from_date", ""));
		setSoDtlSeq(JSPUtil.getParameter(request, prefix + "so_dtl_seq", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setXprDesc(JSPUtil.getParameter(request, prefix + "xpr_desc", ""));
		setTermCode(JSPUtil.getParameter(request, prefix + "term_code", ""));
		setVslClss(JSPUtil.getParameter(request, prefix + "vsl_clss", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTariffCost(JSPUtil.getParameter(request, prefix + "tariff_cost", ""));
		setAdjustCost(JSPUtil.getParameter(request, prefix + "adjust_cost", ""));		
		setConDt(JSPUtil.getParameter(request, prefix + "con_dt", ""));	
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));	
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvSumByMonVO[]
	 */
	public InvSumByMonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvSumByMonVO[]
	 */
	public InvSumByMonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvSumByMonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] combo1 = (JSPUtil.getParameter(request, prefix	+ "combo1", length));
			String[] costNm = (JSPUtil.getParameter(request, prefix	+ "cost_nm", length));
			String[] soSeq = (JSPUtil.getParameter(request, prefix	+ "so_seq", length));
			String[] fomlDesc = (JSPUtil.getParameter(request, prefix	+ "foml_desc", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] acctEngNm = (JSPUtil.getParameter(request, prefix	+ "acct_eng_nm", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] issCtyCd = (JSPUtil.getParameter(request, prefix	+ "iss_cty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] vopPortRhqCd = (JSPUtil.getParameter(request, prefix	+ "vop_port_rhq_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] berthDate = (JSPUtil.getParameter(request, prefix	+ "berth_date", length));
			String[] loclAmt = (JSPUtil.getParameter(request, prefix	+ "locl_amt", length));
			String[] adjAmt = (JSPUtil.getParameter(request, prefix	+ "adj_amt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] psoChgStsNm = (JSPUtil.getParameter(request, prefix	+ "pso_chg_sts_nm", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] dateType = (JSPUtil.getParameter(request, prefix	+ "date_type", length));
			String[] calcAmt = (JSPUtil.getParameter(request, prefix	+ "calc_amt", length));
			String[] cntrVslClssCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_vsl_clss_capa", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vskdPortRhqCd = (JSPUtil.getParameter(request, prefix	+ "vskd_port_rhq_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] differ = (JSPUtil.getParameter(request, prefix	+ "differ", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] soDtlSeq = (JSPUtil.getParameter(request, prefix	+ "so_dtl_seq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] xprDesc = (JSPUtil.getParameter(request, prefix	+ "xpr_desc", length));
			String[] termCode = (JSPUtil.getParameter(request, prefix	+ "term_code", length));
			String[] vslClss = (JSPUtil.getParameter(request, prefix	+ "vsl_clss", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] tariffCost = (JSPUtil.getParameter(request, prefix	+ "tariff_cost", length));
			String[] adjustCost = (JSPUtil.getParameter(request, prefix	+ "adjust_cost", length));
			String[] conDt = (JSPUtil.getParameter(request, prefix	+ "con_dt", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvSumByMonVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (combo1[i] != null)
					model.setCombo1(combo1[i]);
				if (costNm[i] != null)
					model.setCostNm(costNm[i]);
				if (soSeq[i] != null)
					model.setSoSeq(soSeq[i]);
				if (fomlDesc[i] != null)
					model.setFomlDesc(fomlDesc[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (acctEngNm[i] != null)
					model.setAcctEngNm(acctEngNm[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (issCtyCd[i] != null)
					model.setIssCtyCd(issCtyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (vopPortRhqCd[i] != null)
					model.setVopPortRhqCd(vopPortRhqCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (berthDate[i] != null)
					model.setBerthDate(berthDate[i]);
				if (loclAmt[i] != null)
					model.setLoclAmt(loclAmt[i]);
				if (adjAmt[i] != null)
					model.setAdjAmt(adjAmt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (psoChgStsNm[i] != null)
					model.setPsoChgStsNm(psoChgStsNm[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (dateType[i] != null)
					model.setDateType(dateType[i]);
				if (calcAmt[i] != null)
					model.setCalcAmt(calcAmt[i]);
				if (cntrVslClssCapa[i] != null)
					model.setCntrVslClssCapa(cntrVslClssCapa[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vskdPortRhqCd[i] != null)
					model.setVskdPortRhqCd(vskdPortRhqCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (differ[i] != null)
					model.setDiffer(differ[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (soDtlSeq[i] != null)
					model.setSoDtlSeq(soDtlSeq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (xprDesc[i] != null)
					model.setXprDesc(xprDesc[i]);
				if (termCode[i] != null)
					model.setTermCode(termCode[i]);
				if (vslClss[i] != null)
					model.setVslClss(vslClss[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (tariffCost[i] != null)
					model.setTariffCost(tariffCost[i]);
				if (adjustCost[i] != null)
					model.setAdjustCost(adjustCost[i]);			
				if (conDt[i] != null)
					model.setConDt(conDt[i]);	
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);	
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvSumByMonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvSumByMonVO[]
	 */
	public InvSumByMonVO[] getInvSumByMonVOs(){
		InvSumByMonVO[] vos = (InvSumByMonVO[])models.toArray(new InvSumByMonVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.combo1 = this.combo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costNm = this.costNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soSeq = this.soSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fomlDesc = this.fomlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctEngNm = this.acctEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issCtyCd = this.issCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopPortRhqCd = this.vopPortRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.berthDate = this.berthDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAmt = this.loclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjAmt = this.adjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoChgStsNm = this.psoChgStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateType = this.dateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcAmt = this.calcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVslClssCapa = this.cntrVslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskdPortRhqCd = this.vskdPortRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.differ = this.differ .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soDtlSeq = this.soDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xprDesc = this.xprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termCode = this.termCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClss = this.vslClss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariffCost = this.tariffCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjustCost = this.adjustCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.conDt = this.conDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
	}
}