/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPrsAmendmentCmSummaryDownExcelVO.java
*@FileTitle : RsltPrsAmendmentCmSummaryDownExcelVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.11.05 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPrsAmendmentCmSummaryDownExcelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPrsAmendmentCmSummaryDownExcelVO> models = new ArrayList<RsltPrsAmendmentCmSummaryDownExcelVO>();
	
	/* Column Info */
	private String a1Load = null;
	/* Column Info */
	private String sumLoad = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String e1CostCmTrade = null;
	/* Column Info */
	private String e1CmTrade = null;
	/* Column Info */
	private String a1WeekCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String aScNo = null;
	/* Column Info */
	private String e1TotWk = null;
	/* Column Info */
	private String e1CmpbTrade = null;
	/* Column Info */
	private String e1Opb = null;
	/* Column Info */
	private String sumCmOffice = null;
	/* Column Info */
	private String contractNm = null;
	/* Column Info */
	private String sumCostCmTrade = null;
	/* Column Info */
	private String a1CostCmTrade = null;
	/* Column Info */
	private String a1GRev = null;
	/* Column Info */
	private String isSubTot = null;
	/* Column Info */
	private String diffCmpbOffice = null;
	/* Column Info */
	private String e1CostCmOffice = null;
	/* Column Info */
	private String respbSrepCd = null;
	/* Column Info */
	private String a1CmpbTrade = null;
	/* Column Info */
	private String e1CmOffice = null;
	/* Column Info */
	private String a1CostOpOffice = null;
	/* Column Info */
	private String e1GRev = null;
	/* Column Info */
	private String e1CmpbOffice = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String mqcQty = null;
	/* Column Info */
	private String propAproOfcCd = null;
	/* Column Info */
	private String a1CmOffice = null;
	/* Column Info */
	private String e1CostOpOffice = null;
	/* Column Info */
	private String a1Op = null;
	/* Column Info */
	private String sumWeek = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String a1CostCmOffice = null;
	/* Column Info */
	private String diffOpb = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String e1Load = null;
	/* Column Info */
	private String diffCmpbTrade = null;
	/* Column Info */
	private String a1CmTrade = null;
	/* Column Info */
	private String e1Op = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String a1CmpbOffice = null;
	/* Column Info */
	private String sumOp = null;
	/* Column Info */
	private String sumCmTrade = null;
	/* Column Info */
	private String sumCostCmOffice = null;
	/* Column Info */
	private String sumCostOpOffice = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String sumGrev = null;
	/* Column Info */
	private String isTot = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Column Info */
	private String a1Opb = null;
	/* Column Info */
	private String rowProperties = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String seq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPrsAmendmentCmSummaryDownExcelVO() {}

	public RsltPrsAmendmentCmSummaryDownExcelVO(String ibflag, String pagerows, String aScNo, String subTrdCd, String rlaneCd, String a1Load, String a1CostCmOffice, String a1CostCmTrade, String a1CostOpOffice, String a1CmpbOffice, String a1CmpbTrade, String a1Opb, String a1CmOffice, String a1CmTrade, String a1Op, String a1GRev, String a1WeekCnt, String e1Load, String e1CmOffice, String e1CmTrade, String e1Op, String e1CmpbOffice, String e1CmpbTrade, String e1Opb, String e1TotWk, String e1CostCmOffice, String e1CostCmTrade, String e1CostOpOffice, String e1GRev, String sumLoad, String sumGrev, String sumCostCmOffice, String sumCostCmTrade, String sumCostOpOffice, String sumWeek, String sumCmOffice, String sumCmTrade, String sumOp, String diffCmpbOffice, String diffCmpbTrade, String diffOpb, String custNm, String propOfcCd, String mqcQty, String propNo, String propAproOfcCd, String respbSrepCd, String ctrtEffDt, String ctrtExpDt, String custTpCd, String seq, String contractNm, String isTot, String isSubTot, String rowProperties) {
		this.a1Load = a1Load;
		this.sumLoad = sumLoad;
		this.rlaneCd = rlaneCd;
		this.e1CostCmTrade = e1CostCmTrade;
		this.e1CmTrade = e1CmTrade;
		this.a1WeekCnt = a1WeekCnt;
		this.pagerows = pagerows;
		this.aScNo = aScNo;
		this.e1TotWk = e1TotWk;
		this.e1CmpbTrade = e1CmpbTrade;
		this.e1Opb = e1Opb;
		this.sumCmOffice = sumCmOffice;
		this.contractNm = contractNm;
		this.sumCostCmTrade = sumCostCmTrade;
		this.a1CostCmTrade = a1CostCmTrade;
		this.a1GRev = a1GRev;
		this.isSubTot = isSubTot;
		this.diffCmpbOffice = diffCmpbOffice;
		this.e1CostCmOffice = e1CostCmOffice;
		this.respbSrepCd = respbSrepCd;
		this.a1CmpbTrade = a1CmpbTrade;
		this.e1CmOffice = e1CmOffice;
		this.a1CostOpOffice = a1CostOpOffice;
		this.e1GRev = e1GRev;
		this.e1CmpbOffice = e1CmpbOffice;
		this.propOfcCd = propOfcCd;
		this.mqcQty = mqcQty;
		this.propAproOfcCd = propAproOfcCd;
		this.a1CmOffice = a1CmOffice;
		this.e1CostOpOffice = e1CostOpOffice;
		this.a1Op = a1Op;
		this.sumWeek = sumWeek;
		this.subTrdCd = subTrdCd;
		this.a1CostCmOffice = a1CostCmOffice;
		this.diffOpb = diffOpb;
		this.custNm = custNm;
		this.ctrtEffDt = ctrtEffDt;
		this.e1Load = e1Load;
		this.diffCmpbTrade = diffCmpbTrade;
		this.a1CmTrade = a1CmTrade;
		this.e1Op = e1Op;
		this.ibflag = ibflag;
		this.a1CmpbOffice = a1CmpbOffice;
		this.sumOp = sumOp;
		this.sumCmTrade = sumCmTrade;
		this.sumCostCmOffice = sumCostCmOffice;
		this.sumCostOpOffice = sumCostOpOffice;
		this.custTpCd = custTpCd;
		this.sumGrev = sumGrev;
		this.isTot = isTot;
		this.ctrtExpDt = ctrtExpDt;
		this.a1Opb = a1Opb;
		this.rowProperties = rowProperties;
		this.propNo = propNo;
		this.seq = seq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("a1_load", getA1Load());
		this.hashColumns.put("sum_load", getSumLoad());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("e1_cost_cm_trade", getE1CostCmTrade());
		this.hashColumns.put("e1_cm_trade", getE1CmTrade());
		this.hashColumns.put("a1_week_cnt", getA1WeekCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("a_sc_no", getAScNo());
		this.hashColumns.put("e1_tot_wk", getE1TotWk());
		this.hashColumns.put("e1_cmpb_trade", getE1CmpbTrade());
		this.hashColumns.put("e1_opb", getE1Opb());
		this.hashColumns.put("sum_cm_office", getSumCmOffice());
		this.hashColumns.put("contract_nm", getContractNm());
		this.hashColumns.put("sum_cost_cm_trade", getSumCostCmTrade());
		this.hashColumns.put("a1_cost_cm_trade", getA1CostCmTrade());
		this.hashColumns.put("a1_g_rev", getA1GRev());
		this.hashColumns.put("is_sub_tot", getIsSubTot());
		this.hashColumns.put("diff_cmpb_office", getDiffCmpbOffice());
		this.hashColumns.put("e1_cost_cm_office", getE1CostCmOffice());
		this.hashColumns.put("respb_srep_cd", getRespbSrepCd());
		this.hashColumns.put("a1_cmpb_trade", getA1CmpbTrade());
		this.hashColumns.put("e1_cm_office", getE1CmOffice());
		this.hashColumns.put("a1_cost_op_office", getA1CostOpOffice());
		this.hashColumns.put("e1_g_rev", getE1GRev());
		this.hashColumns.put("e1_cmpb_office", getE1CmpbOffice());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("mqc_qty", getMqcQty());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("a1_cm_office", getA1CmOffice());
		this.hashColumns.put("e1_cost_op_office", getE1CostOpOffice());
		this.hashColumns.put("a1_op", getA1Op());
		this.hashColumns.put("sum_week", getSumWeek());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("a1_cost_cm_office", getA1CostCmOffice());
		this.hashColumns.put("diff_opb", getDiffOpb());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("e1_load", getE1Load());
		this.hashColumns.put("diff_cmpb_trade", getDiffCmpbTrade());
		this.hashColumns.put("a1_cm_trade", getA1CmTrade());
		this.hashColumns.put("e1_op", getE1Op());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("a1_cmpb_office", getA1CmpbOffice());
		this.hashColumns.put("sum_op", getSumOp());
		this.hashColumns.put("sum_cm_trade", getSumCmTrade());
		this.hashColumns.put("sum_cost_cm_office", getSumCostCmOffice());
		this.hashColumns.put("sum_cost_op_office", getSumCostOpOffice());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("sum_grev", getSumGrev());
		this.hashColumns.put("is_tot", getIsTot());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("a1_opb", getA1Opb());
		this.hashColumns.put("row_properties", getRowProperties());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("seq", getSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("a1_load", "a1Load");
		this.hashFields.put("sum_load", "sumLoad");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("e1_cost_cm_trade", "e1CostCmTrade");
		this.hashFields.put("e1_cm_trade", "e1CmTrade");
		this.hashFields.put("a1_week_cnt", "a1WeekCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("a_sc_no", "aScNo");
		this.hashFields.put("e1_tot_wk", "e1TotWk");
		this.hashFields.put("e1_cmpb_trade", "e1CmpbTrade");
		this.hashFields.put("e1_opb", "e1Opb");
		this.hashFields.put("sum_cm_office", "sumCmOffice");
		this.hashFields.put("contract_nm", "contractNm");
		this.hashFields.put("sum_cost_cm_trade", "sumCostCmTrade");
		this.hashFields.put("a1_cost_cm_trade", "a1CostCmTrade");
		this.hashFields.put("a1_g_rev", "a1GRev");
		this.hashFields.put("is_sub_tot", "isSubTot");
		this.hashFields.put("diff_cmpb_office", "diffCmpbOffice");
		this.hashFields.put("e1_cost_cm_office", "e1CostCmOffice");
		this.hashFields.put("respb_srep_cd", "respbSrepCd");
		this.hashFields.put("a1_cmpb_trade", "a1CmpbTrade");
		this.hashFields.put("e1_cm_office", "e1CmOffice");
		this.hashFields.put("a1_cost_op_office", "a1CostOpOffice");
		this.hashFields.put("e1_g_rev", "e1GRev");
		this.hashFields.put("e1_cmpb_office", "e1CmpbOffice");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("mqc_qty", "mqcQty");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("a1_cm_office", "a1CmOffice");
		this.hashFields.put("e1_cost_op_office", "e1CostOpOffice");
		this.hashFields.put("a1_op", "a1Op");
		this.hashFields.put("sum_week", "sumWeek");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("a1_cost_cm_office", "a1CostCmOffice");
		this.hashFields.put("diff_opb", "diffOpb");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("e1_load", "e1Load");
		this.hashFields.put("diff_cmpb_trade", "diffCmpbTrade");
		this.hashFields.put("a1_cm_trade", "a1CmTrade");
		this.hashFields.put("e1_op", "e1Op");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("a1_cmpb_office", "a1CmpbOffice");
		this.hashFields.put("sum_op", "sumOp");
		this.hashFields.put("sum_cm_trade", "sumCmTrade");
		this.hashFields.put("sum_cost_cm_office", "sumCostCmOffice");
		this.hashFields.put("sum_cost_op_office", "sumCostOpOffice");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("sum_grev", "sumGrev");
		this.hashFields.put("is_tot", "isTot");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("a1_opb", "a1Opb");
		this.hashFields.put("row_properties", "rowProperties");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("seq", "seq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return a1Load
	 */
	public String getA1Load() {
		return this.a1Load;
	}
	
	/**
	 * Column Info
	 * @return sumLoad
	 */
	public String getSumLoad() {
		return this.sumLoad;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return e1CostCmTrade
	 */
	public String getE1CostCmTrade() {
		return this.e1CostCmTrade;
	}
	
	/**
	 * Column Info
	 * @return e1CmTrade
	 */
	public String getE1CmTrade() {
		return this.e1CmTrade;
	}
	
	/**
	 * Column Info
	 * @return a1WeekCnt
	 */
	public String getA1WeekCnt() {
		return this.a1WeekCnt;
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
	 * @return aScNo
	 */
	public String getAScNo() {
		return this.aScNo;
	}
	
	/**
	 * Column Info
	 * @return e1TotWk
	 */
	public String getE1TotWk() {
		return this.e1TotWk;
	}
	
	/**
	 * Column Info
	 * @return e1CmpbTrade
	 */
	public String getE1CmpbTrade() {
		return this.e1CmpbTrade;
	}
	
	/**
	 * Column Info
	 * @return e1Opb
	 */
	public String getE1Opb() {
		return this.e1Opb;
	}
	
	/**
	 * Column Info
	 * @return sumCmOffice
	 */
	public String getSumCmOffice() {
		return this.sumCmOffice;
	}
	
	/**
	 * Column Info
	 * @return contractNm
	 */
	public String getContractNm() {
		return this.contractNm;
	}
	
	/**
	 * Column Info
	 * @return sumCostCmTrade
	 */
	public String getSumCostCmTrade() {
		return this.sumCostCmTrade;
	}
	
	/**
	 * Column Info
	 * @return a1CostCmTrade
	 */
	public String getA1CostCmTrade() {
		return this.a1CostCmTrade;
	}
	
	/**
	 * Column Info
	 * @return a1GRev
	 */
	public String getA1GRev() {
		return this.a1GRev;
	}
	
	/**
	 * Column Info
	 * @return isSubTot
	 */
	public String getIsSubTot() {
		return this.isSubTot;
	}
	
	/**
	 * Column Info
	 * @return diffCmpbOffice
	 */
	public String getDiffCmpbOffice() {
		return this.diffCmpbOffice;
	}
	
	/**
	 * Column Info
	 * @return e1CostCmOffice
	 */
	public String getE1CostCmOffice() {
		return this.e1CostCmOffice;
	}
	
	/**
	 * Column Info
	 * @return respbSrepCd
	 */
	public String getRespbSrepCd() {
		return this.respbSrepCd;
	}
	
	/**
	 * Column Info
	 * @return a1CmpbTrade
	 */
	public String getA1CmpbTrade() {
		return this.a1CmpbTrade;
	}
	
	/**
	 * Column Info
	 * @return e1CmOffice
	 */
	public String getE1CmOffice() {
		return this.e1CmOffice;
	}
	
	/**
	 * Column Info
	 * @return a1CostOpOffice
	 */
	public String getA1CostOpOffice() {
		return this.a1CostOpOffice;
	}
	
	/**
	 * Column Info
	 * @return e1GRev
	 */
	public String getE1GRev() {
		return this.e1GRev;
	}
	
	/**
	 * Column Info
	 * @return e1CmpbOffice
	 */
	public String getE1CmpbOffice() {
		return this.e1CmpbOffice;
	}
	
	/**
	 * Column Info
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mqcQty
	 */
	public String getMqcQty() {
		return this.mqcQty;
	}
	
	/**
	 * Column Info
	 * @return propAproOfcCd
	 */
	public String getPropAproOfcCd() {
		return this.propAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return a1CmOffice
	 */
	public String getA1CmOffice() {
		return this.a1CmOffice;
	}
	
	/**
	 * Column Info
	 * @return e1CostOpOffice
	 */
	public String getE1CostOpOffice() {
		return this.e1CostOpOffice;
	}
	
	/**
	 * Column Info
	 * @return a1Op
	 */
	public String getA1Op() {
		return this.a1Op;
	}
	
	/**
	 * Column Info
	 * @return sumWeek
	 */
	public String getSumWeek() {
		return this.sumWeek;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return a1CostCmOffice
	 */
	public String getA1CostCmOffice() {
		return this.a1CostCmOffice;
	}
	
	/**
	 * Column Info
	 * @return diffOpb
	 */
	public String getDiffOpb() {
		return this.diffOpb;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtEffDt
	 */
	public String getCtrtEffDt() {
		return this.ctrtEffDt;
	}
	
	/**
	 * Column Info
	 * @return e1Load
	 */
	public String getE1Load() {
		return this.e1Load;
	}
	
	/**
	 * Column Info
	 * @return diffCmpbTrade
	 */
	public String getDiffCmpbTrade() {
		return this.diffCmpbTrade;
	}
	
	/**
	 * Column Info
	 * @return a1CmTrade
	 */
	public String getA1CmTrade() {
		return this.a1CmTrade;
	}
	
	/**
	 * Column Info
	 * @return e1Op
	 */
	public String getE1Op() {
		return this.e1Op;
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
	 * @return a1CmpbOffice
	 */
	public String getA1CmpbOffice() {
		return this.a1CmpbOffice;
	}
	
	/**
	 * Column Info
	 * @return sumOp
	 */
	public String getSumOp() {
		return this.sumOp;
	}
	
	/**
	 * Column Info
	 * @return sumCmTrade
	 */
	public String getSumCmTrade() {
		return this.sumCmTrade;
	}
	
	/**
	 * Column Info
	 * @return sumCostCmOffice
	 */
	public String getSumCostCmOffice() {
		return this.sumCostCmOffice;
	}
	
	/**
	 * Column Info
	 * @return sumCostOpOffice
	 */
	public String getSumCostOpOffice() {
		return this.sumCostOpOffice;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return sumGrev
	 */
	public String getSumGrev() {
		return this.sumGrev;
	}
	
	/**
	 * Column Info
	 * @return isTot
	 */
	public String getIsTot() {
		return this.isTot;
	}
	
	/**
	 * Column Info
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
	}
	
	/**
	 * Column Info
	 * @return a1Opb
	 */
	public String getA1Opb() {
		return this.a1Opb;
	}
	
	/**
	 * Column Info
	 * @return rowProperties
	 */
	public String getRowProperties() {
		return this.rowProperties;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	

	/**
	 * Column Info
	 * @param a1Load
	 */
	public void setA1Load(String a1Load) {
		this.a1Load = a1Load;
	}
	
	/**
	 * Column Info
	 * @param sumLoad
	 */
	public void setSumLoad(String sumLoad) {
		this.sumLoad = sumLoad;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param e1CostCmTrade
	 */
	public void setE1CostCmTrade(String e1CostCmTrade) {
		this.e1CostCmTrade = e1CostCmTrade;
	}
	
	/**
	 * Column Info
	 * @param e1CmTrade
	 */
	public void setE1CmTrade(String e1CmTrade) {
		this.e1CmTrade = e1CmTrade;
	}
	
	/**
	 * Column Info
	 * @param a1WeekCnt
	 */
	public void setA1WeekCnt(String a1WeekCnt) {
		this.a1WeekCnt = a1WeekCnt;
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
	 * @param aScNo
	 */
	public void setAScNo(String aScNo) {
		this.aScNo = aScNo;
	}
	
	/**
	 * Column Info
	 * @param e1TotWk
	 */
	public void setE1TotWk(String e1TotWk) {
		this.e1TotWk = e1TotWk;
	}
	
	/**
	 * Column Info
	 * @param e1CmpbTrade
	 */
	public void setE1CmpbTrade(String e1CmpbTrade) {
		this.e1CmpbTrade = e1CmpbTrade;
	}
	
	/**
	 * Column Info
	 * @param e1Opb
	 */
	public void setE1Opb(String e1Opb) {
		this.e1Opb = e1Opb;
	}
	
	/**
	 * Column Info
	 * @param sumCmOffice
	 */
	public void setSumCmOffice(String sumCmOffice) {
		this.sumCmOffice = sumCmOffice;
	}
	
	/**
	 * Column Info
	 * @param contractNm
	 */
	public void setContractNm(String contractNm) {
		this.contractNm = contractNm;
	}
	
	/**
	 * Column Info
	 * @param sumCostCmTrade
	 */
	public void setSumCostCmTrade(String sumCostCmTrade) {
		this.sumCostCmTrade = sumCostCmTrade;
	}
	
	/**
	 * Column Info
	 * @param a1CostCmTrade
	 */
	public void setA1CostCmTrade(String a1CostCmTrade) {
		this.a1CostCmTrade = a1CostCmTrade;
	}
	
	/**
	 * Column Info
	 * @param a1GRev
	 */
	public void setA1GRev(String a1GRev) {
		this.a1GRev = a1GRev;
	}
	
	/**
	 * Column Info
	 * @param isSubTot
	 */
	public void setIsSubTot(String isSubTot) {
		this.isSubTot = isSubTot;
	}
	
	/**
	 * Column Info
	 * @param diffCmpbOffice
	 */
	public void setDiffCmpbOffice(String diffCmpbOffice) {
		this.diffCmpbOffice = diffCmpbOffice;
	}
	
	/**
	 * Column Info
	 * @param e1CostCmOffice
	 */
	public void setE1CostCmOffice(String e1CostCmOffice) {
		this.e1CostCmOffice = e1CostCmOffice;
	}
	
	/**
	 * Column Info
	 * @param respbSrepCd
	 */
	public void setRespbSrepCd(String respbSrepCd) {
		this.respbSrepCd = respbSrepCd;
	}
	
	/**
	 * Column Info
	 * @param a1CmpbTrade
	 */
	public void setA1CmpbTrade(String a1CmpbTrade) {
		this.a1CmpbTrade = a1CmpbTrade;
	}
	
	/**
	 * Column Info
	 * @param e1CmOffice
	 */
	public void setE1CmOffice(String e1CmOffice) {
		this.e1CmOffice = e1CmOffice;
	}
	
	/**
	 * Column Info
	 * @param a1CostOpOffice
	 */
	public void setA1CostOpOffice(String a1CostOpOffice) {
		this.a1CostOpOffice = a1CostOpOffice;
	}
	
	/**
	 * Column Info
	 * @param e1GRev
	 */
	public void setE1GRev(String e1GRev) {
		this.e1GRev = e1GRev;
	}
	
	/**
	 * Column Info
	 * @param e1CmpbOffice
	 */
	public void setE1CmpbOffice(String e1CmpbOffice) {
		this.e1CmpbOffice = e1CmpbOffice;
	}
	
	/**
	 * Column Info
	 * @param propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mqcQty
	 */
	public void setMqcQty(String mqcQty) {
		this.mqcQty = mqcQty;
	}
	
	/**
	 * Column Info
	 * @param propAproOfcCd
	 */
	public void setPropAproOfcCd(String propAproOfcCd) {
		this.propAproOfcCd = propAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param a1CmOffice
	 */
	public void setA1CmOffice(String a1CmOffice) {
		this.a1CmOffice = a1CmOffice;
	}
	
	/**
	 * Column Info
	 * @param e1CostOpOffice
	 */
	public void setE1CostOpOffice(String e1CostOpOffice) {
		this.e1CostOpOffice = e1CostOpOffice;
	}
	
	/**
	 * Column Info
	 * @param a1Op
	 */
	public void setA1Op(String a1Op) {
		this.a1Op = a1Op;
	}
	
	/**
	 * Column Info
	 * @param sumWeek
	 */
	public void setSumWeek(String sumWeek) {
		this.sumWeek = sumWeek;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param a1CostCmOffice
	 */
	public void setA1CostCmOffice(String a1CostCmOffice) {
		this.a1CostCmOffice = a1CostCmOffice;
	}
	
	/**
	 * Column Info
	 * @param diffOpb
	 */
	public void setDiffOpb(String diffOpb) {
		this.diffOpb = diffOpb;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtEffDt
	 */
	public void setCtrtEffDt(String ctrtEffDt) {
		this.ctrtEffDt = ctrtEffDt;
	}
	
	/**
	 * Column Info
	 * @param e1Load
	 */
	public void setE1Load(String e1Load) {
		this.e1Load = e1Load;
	}
	
	/**
	 * Column Info
	 * @param diffCmpbTrade
	 */
	public void setDiffCmpbTrade(String diffCmpbTrade) {
		this.diffCmpbTrade = diffCmpbTrade;
	}
	
	/**
	 * Column Info
	 * @param a1CmTrade
	 */
	public void setA1CmTrade(String a1CmTrade) {
		this.a1CmTrade = a1CmTrade;
	}
	
	/**
	 * Column Info
	 * @param e1Op
	 */
	public void setE1Op(String e1Op) {
		this.e1Op = e1Op;
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
	 * @param a1CmpbOffice
	 */
	public void setA1CmpbOffice(String a1CmpbOffice) {
		this.a1CmpbOffice = a1CmpbOffice;
	}
	
	/**
	 * Column Info
	 * @param sumOp
	 */
	public void setSumOp(String sumOp) {
		this.sumOp = sumOp;
	}
	
	/**
	 * Column Info
	 * @param sumCmTrade
	 */
	public void setSumCmTrade(String sumCmTrade) {
		this.sumCmTrade = sumCmTrade;
	}
	
	/**
	 * Column Info
	 * @param sumCostCmOffice
	 */
	public void setSumCostCmOffice(String sumCostCmOffice) {
		this.sumCostCmOffice = sumCostCmOffice;
	}
	
	/**
	 * Column Info
	 * @param sumCostOpOffice
	 */
	public void setSumCostOpOffice(String sumCostOpOffice) {
		this.sumCostOpOffice = sumCostOpOffice;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param sumGrev
	 */
	public void setSumGrev(String sumGrev) {
		this.sumGrev = sumGrev;
	}
	
	/**
	 * Column Info
	 * @param isTot
	 */
	public void setIsTot(String isTot) {
		this.isTot = isTot;
	}
	
	/**
	 * Column Info
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
	}
	
	/**
	 * Column Info
	 * @param a1Opb
	 */
	public void setA1Opb(String a1Opb) {
		this.a1Opb = a1Opb;
	}
	
	/**
	 * Column Info
	 * @param rowProperties
	 */
	public void setRowProperties(String rowProperties) {
		this.rowProperties = rowProperties;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setA1Load(JSPUtil.getParameter(request, "a1_load", ""));
		setSumLoad(JSPUtil.getParameter(request, "sum_load", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setE1CostCmTrade(JSPUtil.getParameter(request, "e1_cost_cm_trade", ""));
		setE1CmTrade(JSPUtil.getParameter(request, "e1_cm_trade", ""));
		setA1WeekCnt(JSPUtil.getParameter(request, "a1_week_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAScNo(JSPUtil.getParameter(request, "a_sc_no", ""));
		setE1TotWk(JSPUtil.getParameter(request, "e1_tot_wk", ""));
		setE1CmpbTrade(JSPUtil.getParameter(request, "e1_cmpb_trade", ""));
		setE1Opb(JSPUtil.getParameter(request, "e1_opb", ""));
		setSumCmOffice(JSPUtil.getParameter(request, "sum_cm_office", ""));
		setContractNm(JSPUtil.getParameter(request, "contract_nm", ""));
		setSumCostCmTrade(JSPUtil.getParameter(request, "sum_cost_cm_trade", ""));
		setA1CostCmTrade(JSPUtil.getParameter(request, "a1_cost_cm_trade", ""));
		setA1GRev(JSPUtil.getParameter(request, "a1_g_rev", ""));
		setIsSubTot(JSPUtil.getParameter(request, "is_sub_tot", ""));
		setDiffCmpbOffice(JSPUtil.getParameter(request, "diff_cmpb_office", ""));
		setE1CostCmOffice(JSPUtil.getParameter(request, "e1_cost_cm_office", ""));
		setRespbSrepCd(JSPUtil.getParameter(request, "respb_srep_cd", ""));
		setA1CmpbTrade(JSPUtil.getParameter(request, "a1_cmpb_trade", ""));
		setE1CmOffice(JSPUtil.getParameter(request, "e1_cm_office", ""));
		setA1CostOpOffice(JSPUtil.getParameter(request, "a1_cost_op_office", ""));
		setE1GRev(JSPUtil.getParameter(request, "e1_g_rev", ""));
		setE1CmpbOffice(JSPUtil.getParameter(request, "e1_cmpb_office", ""));
		setPropOfcCd(JSPUtil.getParameter(request, "prop_ofc_cd", ""));
		setMqcQty(JSPUtil.getParameter(request, "mqc_qty", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, "prop_apro_ofc_cd", ""));
		setA1CmOffice(JSPUtil.getParameter(request, "a1_cm_office", ""));
		setE1CostOpOffice(JSPUtil.getParameter(request, "e1_cost_op_office", ""));
		setA1Op(JSPUtil.getParameter(request, "a1_op", ""));
		setSumWeek(JSPUtil.getParameter(request, "sum_week", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setA1CostCmOffice(JSPUtil.getParameter(request, "a1_cost_cm_office", ""));
		setDiffOpb(JSPUtil.getParameter(request, "diff_opb", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, "ctrt_eff_dt", ""));
		setE1Load(JSPUtil.getParameter(request, "e1_load", ""));
		setDiffCmpbTrade(JSPUtil.getParameter(request, "diff_cmpb_trade", ""));
		setA1CmTrade(JSPUtil.getParameter(request, "a1_cm_trade", ""));
		setE1Op(JSPUtil.getParameter(request, "e1_op", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setA1CmpbOffice(JSPUtil.getParameter(request, "a1_cmpb_office", ""));
		setSumOp(JSPUtil.getParameter(request, "sum_op", ""));
		setSumCmTrade(JSPUtil.getParameter(request, "sum_cm_trade", ""));
		setSumCostCmOffice(JSPUtil.getParameter(request, "sum_cost_cm_office", ""));
		setSumCostOpOffice(JSPUtil.getParameter(request, "sum_cost_op_office", ""));
		setCustTpCd(JSPUtil.getParameter(request, "cust_tp_cd", ""));
		setSumGrev(JSPUtil.getParameter(request, "sum_grev", ""));
		setIsTot(JSPUtil.getParameter(request, "is_tot", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, "ctrt_exp_dt", ""));
		setA1Opb(JSPUtil.getParameter(request, "a1_opb", ""));
		setRowProperties(JSPUtil.getParameter(request, "row_properties", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPrsAmendmentCmSummaryDownExcelVO[]
	 */
	public RsltPrsAmendmentCmSummaryDownExcelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPrsAmendmentCmSummaryDownExcelVO[]
	 */
	public RsltPrsAmendmentCmSummaryDownExcelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPrsAmendmentCmSummaryDownExcelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] a1Load = (JSPUtil.getParameter(request, prefix	+ "a1_load", length));
			String[] sumLoad = (JSPUtil.getParameter(request, prefix	+ "sum_load", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] e1CostCmTrade = (JSPUtil.getParameter(request, prefix	+ "e1_cost_cm_trade", length));
			String[] e1CmTrade = (JSPUtil.getParameter(request, prefix	+ "e1_cm_trade", length));
			String[] a1WeekCnt = (JSPUtil.getParameter(request, prefix	+ "a1_week_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] aScNo = (JSPUtil.getParameter(request, prefix	+ "a_sc_no", length));
			String[] e1TotWk = (JSPUtil.getParameter(request, prefix	+ "e1_tot_wk", length));
			String[] e1CmpbTrade = (JSPUtil.getParameter(request, prefix	+ "e1_cmpb_trade", length));
			String[] e1Opb = (JSPUtil.getParameter(request, prefix	+ "e1_opb", length));
			String[] sumCmOffice = (JSPUtil.getParameter(request, prefix	+ "sum_cm_office", length));
			String[] contractNm = (JSPUtil.getParameter(request, prefix	+ "contract_nm", length));
			String[] sumCostCmTrade = (JSPUtil.getParameter(request, prefix	+ "sum_cost_cm_trade", length));
			String[] a1CostCmTrade = (JSPUtil.getParameter(request, prefix	+ "a1_cost_cm_trade", length));
			String[] a1GRev = (JSPUtil.getParameter(request, prefix	+ "a1_g_rev", length));
			String[] isSubTot = (JSPUtil.getParameter(request, prefix	+ "is_sub_tot", length));
			String[] diffCmpbOffice = (JSPUtil.getParameter(request, prefix	+ "diff_cmpb_office", length));
			String[] e1CostCmOffice = (JSPUtil.getParameter(request, prefix	+ "e1_cost_cm_office", length));
			String[] respbSrepCd = (JSPUtil.getParameter(request, prefix	+ "respb_srep_cd", length));
			String[] a1CmpbTrade = (JSPUtil.getParameter(request, prefix	+ "a1_cmpb_trade", length));
			String[] e1CmOffice = (JSPUtil.getParameter(request, prefix	+ "e1_cm_office", length));
			String[] a1CostOpOffice = (JSPUtil.getParameter(request, prefix	+ "a1_cost_op_office", length));
			String[] e1GRev = (JSPUtil.getParameter(request, prefix	+ "e1_g_rev", length));
			String[] e1CmpbOffice = (JSPUtil.getParameter(request, prefix	+ "e1_cmpb_office", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] mqcQty = (JSPUtil.getParameter(request, prefix	+ "mqc_qty", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_ofc_cd", length));
			String[] a1CmOffice = (JSPUtil.getParameter(request, prefix	+ "a1_cm_office", length));
			String[] e1CostOpOffice = (JSPUtil.getParameter(request, prefix	+ "e1_cost_op_office", length));
			String[] a1Op = (JSPUtil.getParameter(request, prefix	+ "a1_op", length));
			String[] sumWeek = (JSPUtil.getParameter(request, prefix	+ "sum_week", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] a1CostCmOffice = (JSPUtil.getParameter(request, prefix	+ "a1_cost_cm_office", length));
			String[] diffOpb = (JSPUtil.getParameter(request, prefix	+ "diff_opb", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] e1Load = (JSPUtil.getParameter(request, prefix	+ "e1_load", length));
			String[] diffCmpbTrade = (JSPUtil.getParameter(request, prefix	+ "diff_cmpb_trade", length));
			String[] a1CmTrade = (JSPUtil.getParameter(request, prefix	+ "a1_cm_trade", length));
			String[] e1Op = (JSPUtil.getParameter(request, prefix	+ "e1_op", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] a1CmpbOffice = (JSPUtil.getParameter(request, prefix	+ "a1_cmpb_office", length));
			String[] sumOp = (JSPUtil.getParameter(request, prefix	+ "sum_op", length));
			String[] sumCmTrade = (JSPUtil.getParameter(request, prefix	+ "sum_cm_trade", length));
			String[] sumCostCmOffice = (JSPUtil.getParameter(request, prefix	+ "sum_cost_cm_office", length));
			String[] sumCostOpOffice = (JSPUtil.getParameter(request, prefix	+ "sum_cost_op_office", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] sumGrev = (JSPUtil.getParameter(request, prefix	+ "sum_grev", length));
			String[] isTot = (JSPUtil.getParameter(request, prefix	+ "is_tot", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] a1Opb = (JSPUtil.getParameter(request, prefix	+ "a1_opb", length));
			String[] rowProperties = (JSPUtil.getParameter(request, prefix	+ "row_properties", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPrsAmendmentCmSummaryDownExcelVO();
				if (a1Load[i] != null)
					model.setA1Load(a1Load[i]);
				if (sumLoad[i] != null)
					model.setSumLoad(sumLoad[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (e1CostCmTrade[i] != null)
					model.setE1CostCmTrade(e1CostCmTrade[i]);
				if (e1CmTrade[i] != null)
					model.setE1CmTrade(e1CmTrade[i]);
				if (a1WeekCnt[i] != null)
					model.setA1WeekCnt(a1WeekCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (aScNo[i] != null)
					model.setAScNo(aScNo[i]);
				if (e1TotWk[i] != null)
					model.setE1TotWk(e1TotWk[i]);
				if (e1CmpbTrade[i] != null)
					model.setE1CmpbTrade(e1CmpbTrade[i]);
				if (e1Opb[i] != null)
					model.setE1Opb(e1Opb[i]);
				if (sumCmOffice[i] != null)
					model.setSumCmOffice(sumCmOffice[i]);
				if (contractNm[i] != null)
					model.setContractNm(contractNm[i]);
				if (sumCostCmTrade[i] != null)
					model.setSumCostCmTrade(sumCostCmTrade[i]);
				if (a1CostCmTrade[i] != null)
					model.setA1CostCmTrade(a1CostCmTrade[i]);
				if (a1GRev[i] != null)
					model.setA1GRev(a1GRev[i]);
				if (isSubTot[i] != null)
					model.setIsSubTot(isSubTot[i]);
				if (diffCmpbOffice[i] != null)
					model.setDiffCmpbOffice(diffCmpbOffice[i]);
				if (e1CostCmOffice[i] != null)
					model.setE1CostCmOffice(e1CostCmOffice[i]);
				if (respbSrepCd[i] != null)
					model.setRespbSrepCd(respbSrepCd[i]);
				if (a1CmpbTrade[i] != null)
					model.setA1CmpbTrade(a1CmpbTrade[i]);
				if (e1CmOffice[i] != null)
					model.setE1CmOffice(e1CmOffice[i]);
				if (a1CostOpOffice[i] != null)
					model.setA1CostOpOffice(a1CostOpOffice[i]);
				if (e1GRev[i] != null)
					model.setE1GRev(e1GRev[i]);
				if (e1CmpbOffice[i] != null)
					model.setE1CmpbOffice(e1CmpbOffice[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (mqcQty[i] != null)
					model.setMqcQty(mqcQty[i]);
				if (propAproOfcCd[i] != null)
					model.setPropAproOfcCd(propAproOfcCd[i]);
				if (a1CmOffice[i] != null)
					model.setA1CmOffice(a1CmOffice[i]);
				if (e1CostOpOffice[i] != null)
					model.setE1CostOpOffice(e1CostOpOffice[i]);
				if (a1Op[i] != null)
					model.setA1Op(a1Op[i]);
				if (sumWeek[i] != null)
					model.setSumWeek(sumWeek[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (a1CostCmOffice[i] != null)
					model.setA1CostCmOffice(a1CostCmOffice[i]);
				if (diffOpb[i] != null)
					model.setDiffOpb(diffOpb[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (e1Load[i] != null)
					model.setE1Load(e1Load[i]);
				if (diffCmpbTrade[i] != null)
					model.setDiffCmpbTrade(diffCmpbTrade[i]);
				if (a1CmTrade[i] != null)
					model.setA1CmTrade(a1CmTrade[i]);
				if (e1Op[i] != null)
					model.setE1Op(e1Op[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (a1CmpbOffice[i] != null)
					model.setA1CmpbOffice(a1CmpbOffice[i]);
				if (sumOp[i] != null)
					model.setSumOp(sumOp[i]);
				if (sumCmTrade[i] != null)
					model.setSumCmTrade(sumCmTrade[i]);
				if (sumCostCmOffice[i] != null)
					model.setSumCostCmOffice(sumCostCmOffice[i]);
				if (sumCostOpOffice[i] != null)
					model.setSumCostOpOffice(sumCostOpOffice[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (sumGrev[i] != null)
					model.setSumGrev(sumGrev[i]);
				if (isTot[i] != null)
					model.setIsTot(isTot[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (a1Opb[i] != null)
					model.setA1Opb(a1Opb[i]);
				if (rowProperties[i] != null)
					model.setRowProperties(rowProperties[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPrsAmendmentCmSummaryDownExcelVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPrsAmendmentCmSummaryDownExcelVO[]
	 */
	public RsltPrsAmendmentCmSummaryDownExcelVO[] getRsltPrsAmendmentCmSummaryDownExcelVOs(){
		RsltPrsAmendmentCmSummaryDownExcelVO[] vos = (RsltPrsAmendmentCmSummaryDownExcelVO[])models.toArray(new RsltPrsAmendmentCmSummaryDownExcelVO[models.size()]);
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
		this.a1Load = this.a1Load .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumLoad = this.sumLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1CostCmTrade = this.e1CostCmTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1CmTrade = this.e1CmTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1WeekCnt = this.a1WeekCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aScNo = this.aScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1TotWk = this.e1TotWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1CmpbTrade = this.e1CmpbTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1Opb = this.e1Opb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCmOffice = this.sumCmOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractNm = this.contractNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCostCmTrade = this.sumCostCmTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1CostCmTrade = this.a1CostCmTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1GRev = this.a1GRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isSubTot = this.isSubTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffCmpbOffice = this.diffCmpbOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1CostCmOffice = this.e1CostCmOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbSrepCd = this.respbSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1CmpbTrade = this.a1CmpbTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1CmOffice = this.e1CmOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1CostOpOffice = this.a1CostOpOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1GRev = this.e1GRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1CmpbOffice = this.e1CmpbOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqcQty = this.mqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1CmOffice = this.a1CmOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1CostOpOffice = this.e1CostOpOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1Op = this.a1Op .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumWeek = this.sumWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1CostCmOffice = this.a1CostCmOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffOpb = this.diffOpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1Load = this.e1Load .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffCmpbTrade = this.diffCmpbTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1CmTrade = this.a1CmTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1Op = this.e1Op .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1CmpbOffice = this.a1CmpbOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumOp = this.sumOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCmTrade = this.sumCmTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCostCmOffice = this.sumCostCmOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCostOpOffice = this.sumCostOpOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumGrev = this.sumGrev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isTot = this.isTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1Opb = this.a1Opb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowProperties = this.rowProperties .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
