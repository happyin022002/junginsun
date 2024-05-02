/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CARIssueTransferSlipManageCommonVO.java
*@FileTitle : CARIssueTransferSlipManageCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.20  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.vo;

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

public class CARIssueTransferSlipManageCommonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CARIssueTransferSlipManageCommonVO> models = new ArrayList<CARIssueTransferSlipManageCommonVO>();
	
	/* Column Info */
	private String taxNo1 = null;
	/* Column Info */
	private String taxNo2 = null;
	/* Column Info */
	private String eviCtnt12 = null;
	/* Column Info */
	private String invNo2 = null;
	/* Column Info */
	private String payGroupCd = null;
	/* Column Info */
	private String maxIssDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sEviInvDt = null;
	/* Column Info */
	private String eviInvDt = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String asanogb = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String maxRcvDt = null;
	/* Column Info */
	private String fmEffDt = null;
	/* Column Info */
	private String eviCtnt11 = null;
	/* Column Info */
	private String invKnt = null;
	/* Column Info */
	private String eviCtnt10 = null;
	/* Column Info */
	private String apOfcCd = null;
	/* Column Info */
	private String ifStatus = null;
	/* Column Info */
	private String compNo = null;
	/* Column Info */
	private String eviCtnt9 = null;
	/* Column Info */
	private String eviCtnt8 = null;
	/* Column Info */
	private String eviGb = null;
	/* Column Info */
	private String eviCtnt7 = null;
	/* Column Info */
	private String eviCtnt6 = null;
	/* Column Info */
	private String eviCtnt5 = null;
	/* Column Info */
	private String eviCtnt4 = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String eviCtnt3 = null;
	/* Column Info */
	private String chks = null;
	/* Column Info */
	private String eviCtnt2 = null;
	/* Column Info */
	private String eviCtnt1 = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String searchTpCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String dtStatus = null;
	/* Column Info */
	private String asaNo = null;
	/* Column Info */
	private String csrAproTpCd = null;
	/* Column Info */
	private String eviTaxNo2 = null;
	/* Column Info */
	private String gap = null;
	/* Column Info */
	private String aproStep = null;
	/* Column Info */
	private String eviTaxNo = null;
	/* Column Info */
	private String eviTotalNetAmt = null;
	/* Column Info */
	private String attrCtnt8 = null;
	/* Column Info */
	private String totalAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String searchCsrNo = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String genPayTermCd = null;
	/* Column Info */
	private String paymentDueDt = null;
	/* Column Info */
	private String eviTotalTaxAmt = null;
	/* Column Info */
	private String eviTaxCode = null;
	/* Column Info */
	private String taxType = null;
	/* Column Info */
	private String csrUsdAmt = null;
	/* Column Info */
	private String eviCompNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CARIssueTransferSlipManageCommonVO() {}

	public CARIssueTransferSlipManageCommonVO(String ibflag, String pagerows, String taxNo1, String taxNo2, String eviCtnt12, String invNo2, String payGroupCd, String maxIssDt, String sEviInvDt, String eviInvDt, String locCd, String asanogb, String costCd, String cntrTpszCd, String cntCd, String fmEffDt, String maxRcvDt, String invKnt, String eviCtnt11, String eviCtnt10, String apOfcCd, String compNo, String ifStatus, String eviCtnt9, String eviCtnt8, String eviGb, String eviCtnt7, String eviCtnt6, String eviCtnt5, String eviCtnt4, String toEffDt, String eviCtnt3, String chks, String eviCtnt2, String eviCtnt1, String creUsrId, String vndrSeq, String dtStatus, String asaNo, String csrAproTpCd, String eviTaxNo2, String gap, String aproStep, String eviTaxNo, String eviTotalNetAmt, String attrCtnt8, String totalAmt, String searchCsrNo, String acctCd, String genPayTermCd, String paymentDueDt, String eviTotalTaxAmt, String eviTaxCode, String csrUsdAmt, String taxType, String eviCompNo, String searchTpCd) {
		this.taxNo1 = taxNo1;
		this.taxNo2 = taxNo2;
		this.eviCtnt12 = eviCtnt12;
		this.invNo2 = invNo2;
		this.payGroupCd = payGroupCd;
		this.maxIssDt = maxIssDt;
		this.pagerows = pagerows;
		this.sEviInvDt = sEviInvDt;
		this.eviInvDt = eviInvDt;
		this.locCd = locCd;
		this.asanogb = asanogb;
		this.costCd = costCd;
		this.cntCd = cntCd;
		this.cntrTpszCd = cntrTpszCd;
		this.maxRcvDt = maxRcvDt;
		this.fmEffDt = fmEffDt;
		this.eviCtnt11 = eviCtnt11;
		this.invKnt = invKnt;
		this.eviCtnt10 = eviCtnt10;
		this.apOfcCd = apOfcCd;
		this.ifStatus = ifStatus;
		this.compNo = compNo;
		this.eviCtnt9 = eviCtnt9;
		this.eviCtnt8 = eviCtnt8;
		this.eviGb = eviGb;
		this.eviCtnt7 = eviCtnt7;
		this.eviCtnt6 = eviCtnt6;
		this.eviCtnt5 = eviCtnt5;
		this.eviCtnt4 = eviCtnt4;
		this.toEffDt = toEffDt;
		this.eviCtnt3 = eviCtnt3;
		this.chks = chks;
		this.eviCtnt2 = eviCtnt2;
		this.eviCtnt1 = eviCtnt1;
		this.creUsrId = creUsrId;
		this.searchTpCd = searchTpCd;
		this.vndrSeq = vndrSeq;
		this.dtStatus = dtStatus;
		this.asaNo = asaNo;
		this.csrAproTpCd = csrAproTpCd;
		this.eviTaxNo2 = eviTaxNo2;
		this.gap = gap;
		this.aproStep = aproStep;
		this.eviTaxNo = eviTaxNo;
		this.eviTotalNetAmt = eviTotalNetAmt;
		this.attrCtnt8 = attrCtnt8;
		this.totalAmt = totalAmt;
		this.ibflag = ibflag;
		this.searchCsrNo = searchCsrNo;
		this.acctCd = acctCd;
		this.genPayTermCd = genPayTermCd;
		this.paymentDueDt = paymentDueDt;
		this.eviTotalTaxAmt = eviTotalTaxAmt;
		this.eviTaxCode = eviTaxCode;
		this.taxType = taxType;
		this.csrUsdAmt = csrUsdAmt;
		this.eviCompNo = eviCompNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tax_no1", getTaxNo1());
		this.hashColumns.put("tax_no2", getTaxNo2());
		this.hashColumns.put("evi_ctnt12", getEviCtnt12());
		this.hashColumns.put("inv_no2", getInvNo2());
		this.hashColumns.put("pay_group_cd", getPayGroupCd());
		this.hashColumns.put("max_iss_dt", getMaxIssDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_evi_inv_dt", getSEviInvDt());
		this.hashColumns.put("evi_inv_dt", getEviInvDt());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("asanogb", getAsanogb());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("max_rcv_dt", getMaxRcvDt());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		this.hashColumns.put("evi_ctnt11", getEviCtnt11());
		this.hashColumns.put("inv_knt", getInvKnt());
		this.hashColumns.put("evi_ctnt10", getEviCtnt10());
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());
		this.hashColumns.put("if_status", getIfStatus());
		this.hashColumns.put("comp_no", getCompNo());
		this.hashColumns.put("evi_ctnt9", getEviCtnt9());
		this.hashColumns.put("evi_ctnt8", getEviCtnt8());
		this.hashColumns.put("evi_gb", getEviGb());
		this.hashColumns.put("evi_ctnt7", getEviCtnt7());
		this.hashColumns.put("evi_ctnt6", getEviCtnt6());
		this.hashColumns.put("evi_ctnt5", getEviCtnt5());
		this.hashColumns.put("evi_ctnt4", getEviCtnt4());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("evi_ctnt3", getEviCtnt3());
		this.hashColumns.put("chks", getChks());
		this.hashColumns.put("evi_ctnt2", getEviCtnt2());
		this.hashColumns.put("evi_ctnt1", getEviCtnt1());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("search_tp_cd", getSearchTpCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("dt_status", getDtStatus());
		this.hashColumns.put("asa_no", getAsaNo());
		this.hashColumns.put("csr_apro_tp_cd", getCsrAproTpCd());
		this.hashColumns.put("evi_tax_no2", getEviTaxNo2());
		this.hashColumns.put("gap", getGap());
		this.hashColumns.put("apro_step", getAproStep());
		this.hashColumns.put("evi_tax_no", getEviTaxNo());
		this.hashColumns.put("evi_total_net_amt", getEviTotalNetAmt());
		this.hashColumns.put("attr_ctnt8", getAttrCtnt8());
		this.hashColumns.put("total_amt", getTotalAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("search_csr_no", getSearchCsrNo());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("gen_pay_term_cd", getGenPayTermCd());
		this.hashColumns.put("payment_due_dt", getPaymentDueDt());
		this.hashColumns.put("evi_total_tax_amt", getEviTotalTaxAmt());
		this.hashColumns.put("evi_tax_code", getEviTaxCode());
		this.hashColumns.put("tax_type", getTaxType());
		this.hashColumns.put("csr_usd_amt", getCsrUsdAmt());
		this.hashColumns.put("evi_comp_no", getEviCompNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tax_no1", "taxNo1");
		this.hashFields.put("tax_no2", "taxNo2");
		this.hashFields.put("evi_ctnt12", "eviCtnt12");
		this.hashFields.put("inv_no2", "invNo2");
		this.hashFields.put("pay_group_cd", "payGroupCd");
		this.hashFields.put("max_iss_dt", "maxIssDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_evi_inv_dt", "sEviInvDt");
		this.hashFields.put("evi_inv_dt", "eviInvDt");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("asanogb", "asanogb");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("max_rcv_dt", "maxRcvDt");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("evi_ctnt11", "eviCtnt11");
		this.hashFields.put("inv_knt", "invKnt");
		this.hashFields.put("evi_ctnt10", "eviCtnt10");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("if_status", "ifStatus");
		this.hashFields.put("comp_no", "compNo");
		this.hashFields.put("evi_ctnt9", "eviCtnt9");
		this.hashFields.put("evi_ctnt8", "eviCtnt8");
		this.hashFields.put("evi_gb", "eviGb");
		this.hashFields.put("evi_ctnt7", "eviCtnt7");
		this.hashFields.put("evi_ctnt6", "eviCtnt6");
		this.hashFields.put("evi_ctnt5", "eviCtnt5");
		this.hashFields.put("evi_ctnt4", "eviCtnt4");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("evi_ctnt3", "eviCtnt3");
		this.hashFields.put("chks", "chks");
		this.hashFields.put("evi_ctnt2", "eviCtnt2");
		this.hashFields.put("evi_ctnt1", "eviCtnt1");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("search_tp_cd", "searchTpCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("dt_status", "dtStatus");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("csr_apro_tp_cd", "csrAproTpCd");
		this.hashFields.put("evi_tax_no2", "eviTaxNo2");
		this.hashFields.put("gap", "gap");
		this.hashFields.put("apro_step", "aproStep");
		this.hashFields.put("evi_tax_no", "eviTaxNo");
		this.hashFields.put("evi_total_net_amt", "eviTotalNetAmt");
		this.hashFields.put("attr_ctnt8", "attrCtnt8");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("search_csr_no", "searchCsrNo");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("gen_pay_term_cd", "genPayTermCd");
		this.hashFields.put("payment_due_dt", "paymentDueDt");
		this.hashFields.put("evi_total_tax_amt", "eviTotalTaxAmt");
		this.hashFields.put("evi_tax_code", "eviTaxCode");
		this.hashFields.put("tax_type", "taxType");
		this.hashFields.put("csr_usd_amt", "csrUsdAmt");
		this.hashFields.put("evi_comp_no", "eviCompNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return taxNo1
	 */
	public String getTaxNo1() {
		return this.taxNo1;
	}
	
	/**
	 * Column Info
	 * @return taxNo2
	 */
	public String getTaxNo2() {
		return this.taxNo2;
	}
	
	/**
	 * Column Info
	 * @return eviCtnt12
	 */
	public String getEviCtnt12() {
		return this.eviCtnt12;
	}
	
	/**
	 * Column Info
	 * @return invNo2
	 */
	public String getInvNo2() {
		return this.invNo2;
	}
	
	/**
	 * Column Info
	 * @return payGroupCd
	 */
	public String getPayGroupCd() {
		return this.payGroupCd;
	}
	
	/**
	 * Column Info
	 * @return maxIssDt
	 */
	public String getMaxIssDt() {
		return this.maxIssDt;
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
	 * @return sEviInvDt
	 */
	public String getSEviInvDt() {
		return this.sEviInvDt;
	}
	
	/**
	 * Column Info
	 * @return eviInvDt
	 */
	public String getEviInvDt() {
		return this.eviInvDt;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return asanogb
	 */
	public String getAsanogb() {
		return this.asanogb;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return maxRcvDt
	 */
	public String getMaxRcvDt() {
		return this.maxRcvDt;
	}
	
	/**
	 * Column Info
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
	}
	
	/**
	 * Column Info
	 * @return eviCtnt11
	 */
	public String getEviCtnt11() {
		return this.eviCtnt11;
	}
	
	/**
	 * Column Info
	 * @return invKnt
	 */
	public String getInvKnt() {
		return this.invKnt;
	}
	
	/**
	 * Column Info
	 * @return eviCtnt10
	 */
	public String getEviCtnt10() {
		return this.eviCtnt10;
	}
	
	/**
	 * Column Info
	 * @return apOfcCd
	 */
	public String getApOfcCd() {
		return this.apOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ifStatus
	 */
	public String getIfStatus() {
		return this.ifStatus;
	}
	
	/**
	 * Column Info
	 * @return compNo
	 */
	public String getCompNo() {
		return this.compNo;
	}
	
	/**
	 * Column Info
	 * @return eviCtnt9
	 */
	public String getEviCtnt9() {
		return this.eviCtnt9;
	}
	
	/**
	 * Column Info
	 * @return eviCtnt8
	 */
	public String getEviCtnt8() {
		return this.eviCtnt8;
	}
	
	/**
	 * Column Info
	 * @return eviGb
	 */
	public String getEviGb() {
		return this.eviGb;
	}
	
	/**
	 * Column Info
	 * @return eviCtnt7
	 */
	public String getEviCtnt7() {
		return this.eviCtnt7;
	}
	
	/**
	 * Column Info
	 * @return eviCtnt6
	 */
	public String getEviCtnt6() {
		return this.eviCtnt6;
	}
	
	/**
	 * Column Info
	 * @return eviCtnt5
	 */
	public String getEviCtnt5() {
		return this.eviCtnt5;
	}
	
	/**
	 * Column Info
	 * @return eviCtnt4
	 */
	public String getEviCtnt4() {
		return this.eviCtnt4;
	}
	
	/**
	 * Column Info
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
	}
	
	/**
	 * Column Info
	 * @return eviCtnt3
	 */
	public String getEviCtnt3() {
		return this.eviCtnt3;
	}
	
	/**
	 * Column Info
	 * @return chks
	 */
	public String getChks() {
		return this.chks;
	}
	
	/**
	 * Column Info
	 * @return eviCtnt2
	 */
	public String getEviCtnt2() {
		return this.eviCtnt2;
	}
	
	/**
	 * Column Info
	 * @return eviCtnt1
	 */
	public String getEviCtnt1() {
		return this.eviCtnt1;
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
	 * @return searchTpCd
	 */
	public String getSearchTpCd() {
		return this.searchTpCd;
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
	 * @return dtStatus
	 */
	public String getDtStatus() {
		return this.dtStatus;
	}
	
	/**
	 * Column Info
	 * @return asaNo
	 */
	public String getAsaNo() {
		return this.asaNo;
	}
	
	/**
	 * Column Info
	 * @return csrAproTpCd
	 */
	public String getCsrAproTpCd() {
		return this.csrAproTpCd;
	}
	
	/**
	 * Column Info
	 * @return eviTaxNo2
	 */
	public String getEviTaxNo2() {
		return this.eviTaxNo2;
	}
	
	/**
	 * Column Info
	 * @return gap
	 */
	public String getGap() {
		return this.gap;
	}
	
	/**
	 * Column Info
	 * @return aproStep
	 */
	public String getAproStep() {
		return this.aproStep;
	}
	
	/**
	 * Column Info
	 * @return eviTaxNo
	 */
	public String getEviTaxNo() {
		return this.eviTaxNo;
	}
	
	/**
	 * Column Info
	 * @return eviTotalNetAmt
	 */
	public String getEviTotalNetAmt() {
		return this.eviTotalNetAmt;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt8
	 */
	public String getAttrCtnt8() {
		return this.attrCtnt8;
	}
	
	/**
	 * Column Info
	 * @return totalAmt
	 */
	public String getTotalAmt() {
		return this.totalAmt;
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
	 * @return searchCsrNo
	 */
	public String getSearchCsrNo() {
		return this.searchCsrNo;
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
	 * @return genPayTermCd
	 */
	public String getGenPayTermCd() {
		return this.genPayTermCd;
	}
	
	/**
	 * Column Info
	 * @return paymentDueDt
	 */
	public String getPaymentDueDt() {
		return this.paymentDueDt;
	}
	
	/**
	 * Column Info
	 * @return eviTotalTaxAmt
	 */
	public String getEviTotalTaxAmt() {
		return this.eviTotalTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return eviTaxCode
	 */
	public String getEviTaxCode() {
		return this.eviTaxCode;
	}
	
	/**
	 * Column Info
	 * @return taxType
	 */
	public String getTaxType() {
		return this.taxType;
	}
	
	/**
	 * Column Info
	 * @return csrUsdAmt
	 */
	public String getCsrUsdAmt() {
		return this.csrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return eviCompNo
	 */
	public String getEviCompNo() {
		return this.eviCompNo;
	}
	

	/**
	 * Column Info
	 * @param taxNo1
	 */
	public void setTaxNo1(String taxNo1) {
		this.taxNo1 = taxNo1;
	}
	
	/**
	 * Column Info
	 * @param taxNo2
	 */
	public void setTaxNo2(String taxNo2) {
		this.taxNo2 = taxNo2;
	}
	
	/**
	 * Column Info
	 * @param eviCtnt12
	 */
	public void setEviCtnt12(String eviCtnt12) {
		this.eviCtnt12 = eviCtnt12;
	}
	
	/**
	 * Column Info
	 * @param invNo2
	 */
	public void setInvNo2(String invNo2) {
		this.invNo2 = invNo2;
	}
	
	/**
	 * Column Info
	 * @param payGroupCd
	 */
	public void setPayGroupCd(String payGroupCd) {
		this.payGroupCd = payGroupCd;
	}
	
	/**
	 * Column Info
	 * @param maxIssDt
	 */
	public void setMaxIssDt(String maxIssDt) {
		this.maxIssDt = maxIssDt;
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
	 * @param sEviInvDt
	 */
	public void setSEviInvDt(String sEviInvDt) {
		this.sEviInvDt = sEviInvDt;
	}
	
	/**
	 * Column Info
	 * @param eviInvDt
	 */
	public void setEviInvDt(String eviInvDt) {
		this.eviInvDt = eviInvDt;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param asanogb
	 */
	public void setAsanogb(String asanogb) {
		this.asanogb = asanogb;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param maxRcvDt
	 */
	public void setMaxRcvDt(String maxRcvDt) {
		this.maxRcvDt = maxRcvDt;
	}
	
	/**
	 * Column Info
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
	}
	
	/**
	 * Column Info
	 * @param eviCtnt11
	 */
	public void setEviCtnt11(String eviCtnt11) {
		this.eviCtnt11 = eviCtnt11;
	}
	
	/**
	 * Column Info
	 * @param invKnt
	 */
	public void setInvKnt(String invKnt) {
		this.invKnt = invKnt;
	}
	
	/**
	 * Column Info
	 * @param eviCtnt10
	 */
	public void setEviCtnt10(String eviCtnt10) {
		this.eviCtnt10 = eviCtnt10;
	}
	
	/**
	 * Column Info
	 * @param apOfcCd
	 */
	public void setApOfcCd(String apOfcCd) {
		this.apOfcCd = apOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ifStatus
	 */
	public void setIfStatus(String ifStatus) {
		this.ifStatus = ifStatus;
	}
	
	/**
	 * Column Info
	 * @param compNo
	 */
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}
	
	/**
	 * Column Info
	 * @param eviCtnt9
	 */
	public void setEviCtnt9(String eviCtnt9) {
		this.eviCtnt9 = eviCtnt9;
	}
	
	/**
	 * Column Info
	 * @param eviCtnt8
	 */
	public void setEviCtnt8(String eviCtnt8) {
		this.eviCtnt8 = eviCtnt8;
	}
	
	/**
	 * Column Info
	 * @param eviGb
	 */
	public void setEviGb(String eviGb) {
		this.eviGb = eviGb;
	}
	
	/**
	 * Column Info
	 * @param eviCtnt7
	 */
	public void setEviCtnt7(String eviCtnt7) {
		this.eviCtnt7 = eviCtnt7;
	}
	
	/**
	 * Column Info
	 * @param eviCtnt6
	 */
	public void setEviCtnt6(String eviCtnt6) {
		this.eviCtnt6 = eviCtnt6;
	}
	
	/**
	 * Column Info
	 * @param eviCtnt5
	 */
	public void setEviCtnt5(String eviCtnt5) {
		this.eviCtnt5 = eviCtnt5;
	}
	
	/**
	 * Column Info
	 * @param eviCtnt4
	 */
	public void setEviCtnt4(String eviCtnt4) {
		this.eviCtnt4 = eviCtnt4;
	}
	
	/**
	 * Column Info
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}
	
	/**
	 * Column Info
	 * @param eviCtnt3
	 */
	public void setEviCtnt3(String eviCtnt3) {
		this.eviCtnt3 = eviCtnt3;
	}
	
	/**
	 * Column Info
	 * @param chks
	 */
	public void setChks(String chks) {
		this.chks = chks;
	}
	
	/**
	 * Column Info
	 * @param eviCtnt2
	 */
	public void setEviCtnt2(String eviCtnt2) {
		this.eviCtnt2 = eviCtnt2;
	}
	
	/**
	 * Column Info
	 * @param eviCtnt1
	 */
	public void setEviCtnt1(String eviCtnt1) {
		this.eviCtnt1 = eviCtnt1;
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
	 * @param searchTpCd
	 */
	public void setSearchTpCd(String searchTpCd) {
		this.searchTpCd = searchTpCd;
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
	 * @param dtStatus
	 */
	public void setDtStatus(String dtStatus) {
		this.dtStatus = dtStatus;
	}
	
	/**
	 * Column Info
	 * @param asaNo
	 */
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
	}
	
	/**
	 * Column Info
	 * @param csrAproTpCd
	 */
	public void setCsrAproTpCd(String csrAproTpCd) {
		this.csrAproTpCd = csrAproTpCd;
	}
	
	/**
	 * Column Info
	 * @param eviTaxNo2
	 */
	public void setEviTaxNo2(String eviTaxNo2) {
		this.eviTaxNo2 = eviTaxNo2;
	}
	
	/**
	 * Column Info
	 * @param gap
	 */
	public void setGap(String gap) {
		this.gap = gap;
	}
	
	/**
	 * Column Info
	 * @param aproStep
	 */
	public void setAproStep(String aproStep) {
		this.aproStep = aproStep;
	}
	
	/**
	 * Column Info
	 * @param eviTaxNo
	 */
	public void setEviTaxNo(String eviTaxNo) {
		this.eviTaxNo = eviTaxNo;
	}
	
	/**
	 * Column Info
	 * @param eviTotalNetAmt
	 */
	public void setEviTotalNetAmt(String eviTotalNetAmt) {
		this.eviTotalNetAmt = eviTotalNetAmt;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt8
	 */
	public void setAttrCtnt8(String attrCtnt8) {
		this.attrCtnt8 = attrCtnt8;
	}
	
	/**
	 * Column Info
	 * @param totalAmt
	 */
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
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
	 * @param searchCsrNo
	 */
	public void setSearchCsrNo(String searchCsrNo) {
		this.searchCsrNo = searchCsrNo;
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
	 * @param genPayTermCd
	 */
	public void setGenPayTermCd(String genPayTermCd) {
		this.genPayTermCd = genPayTermCd;
	}
	
	/**
	 * Column Info
	 * @param paymentDueDt
	 */
	public void setPaymentDueDt(String paymentDueDt) {
		this.paymentDueDt = paymentDueDt;
	}
	
	/**
	 * Column Info
	 * @param eviTotalTaxAmt
	 */
	public void setEviTotalTaxAmt(String eviTotalTaxAmt) {
		this.eviTotalTaxAmt = eviTotalTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param eviTaxCode
	 */
	public void setEviTaxCode(String eviTaxCode) {
		this.eviTaxCode = eviTaxCode;
	}
	
	/**
	 * Column Info
	 * @param taxType
	 */
	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}
	
	/**
	 * Column Info
	 * @param csrUsdAmt
	 */
	public void setCsrUsdAmt(String csrUsdAmt) {
		this.csrUsdAmt = csrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param eviCompNo
	 */
	public void setEviCompNo(String eviCompNo) {
		this.eviCompNo = eviCompNo;
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
		setTaxNo1(JSPUtil.getParameter(request, prefix + "tax_no1", ""));
		setTaxNo2(JSPUtil.getParameter(request, prefix + "tax_no2", ""));
		setEviCtnt12(JSPUtil.getParameter(request, prefix + "evi_ctnt12", ""));
		setInvNo2(JSPUtil.getParameter(request, prefix + "inv_no2", ""));
		setPayGroupCd(JSPUtil.getParameter(request, prefix + "pay_group_cd", ""));
		setMaxIssDt(JSPUtil.getParameter(request, prefix + "max_iss_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSEviInvDt(JSPUtil.getParameter(request, prefix + "s_evi_inv_dt", ""));
		setEviInvDt(JSPUtil.getParameter(request, prefix + "evi_inv_dt", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setAsanogb(JSPUtil.getParameter(request, prefix + "asanogb", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setMaxRcvDt(JSPUtil.getParameter(request, prefix + "max_rcv_dt", ""));
		setFmEffDt(JSPUtil.getParameter(request, prefix + "fm_eff_dt", ""));
		setEviCtnt11(JSPUtil.getParameter(request, prefix + "evi_ctnt11", ""));
		setInvKnt(JSPUtil.getParameter(request, prefix + "inv_knt", ""));
		setEviCtnt10(JSPUtil.getParameter(request, prefix + "evi_ctnt10", ""));
		setApOfcCd(JSPUtil.getParameter(request, prefix + "ap_ofc_cd", ""));
		setIfStatus(JSPUtil.getParameter(request, prefix + "if_status", ""));
		setCompNo(JSPUtil.getParameter(request, prefix + "comp_no", ""));
		setEviCtnt9(JSPUtil.getParameter(request, prefix + "evi_ctnt9", ""));
		setEviCtnt8(JSPUtil.getParameter(request, prefix + "evi_ctnt8", ""));
		setEviGb(JSPUtil.getParameter(request, prefix + "evi_gb", ""));
		setEviCtnt7(JSPUtil.getParameter(request, prefix + "evi_ctnt7", ""));
		setEviCtnt6(JSPUtil.getParameter(request, prefix + "evi_ctnt6", ""));
		setEviCtnt5(JSPUtil.getParameter(request, prefix + "evi_ctnt5", ""));
		setEviCtnt4(JSPUtil.getParameter(request, prefix + "evi_ctnt4", ""));
		setToEffDt(JSPUtil.getParameter(request, prefix + "to_eff_dt", ""));
		setEviCtnt3(JSPUtil.getParameter(request, prefix + "evi_ctnt3", ""));
		setChks(JSPUtil.getParameter(request, prefix + "chks", ""));
		setEviCtnt2(JSPUtil.getParameter(request, prefix + "evi_ctnt2", ""));
		setEviCtnt1(JSPUtil.getParameter(request, prefix + "evi_ctnt1", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSearchTpCd(JSPUtil.getParameter(request, prefix + "search_tp_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setDtStatus(JSPUtil.getParameter(request, prefix + "dt_status", ""));
		setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
		setCsrAproTpCd(JSPUtil.getParameter(request, prefix + "csr_apro_tp_cd", ""));
		setEviTaxNo2(JSPUtil.getParameter(request, prefix + "evi_tax_no2", ""));
		setGap(JSPUtil.getParameter(request, prefix + "gap", ""));
		setAproStep(JSPUtil.getParameter(request, prefix + "apro_step", ""));
		setEviTaxNo(JSPUtil.getParameter(request, prefix + "evi_tax_no", ""));
		setEviTotalNetAmt(JSPUtil.getParameter(request, prefix + "evi_total_net_amt", ""));
		setAttrCtnt8(JSPUtil.getParameter(request, prefix + "attr_ctnt8", ""));
		setTotalAmt(JSPUtil.getParameter(request, prefix + "total_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSearchCsrNo(JSPUtil.getParameter(request, prefix + "search_csr_no", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setGenPayTermCd(JSPUtil.getParameter(request, prefix + "gen_pay_term_cd", ""));
		setPaymentDueDt(JSPUtil.getParameter(request, prefix + "payment_due_dt", ""));
		setEviTotalTaxAmt(JSPUtil.getParameter(request, prefix + "evi_total_tax_amt", ""));
		setEviTaxCode(JSPUtil.getParameter(request, prefix + "evi_tax_code", ""));
		setTaxType(JSPUtil.getParameter(request, prefix + "tax_type", ""));
		setCsrUsdAmt(JSPUtil.getParameter(request, prefix + "csr_usd_amt", ""));
		setEviCompNo(JSPUtil.getParameter(request, prefix + "evi_comp_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CARIssueTransferSlipManageCommonVO[]
	 */
	public CARIssueTransferSlipManageCommonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CARIssueTransferSlipManageCommonVO[]
	 */
	public CARIssueTransferSlipManageCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CARIssueTransferSlipManageCommonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] taxNo1 = (JSPUtil.getParameter(request, prefix	+ "tax_no1", length));
			String[] taxNo2 = (JSPUtil.getParameter(request, prefix	+ "tax_no2", length));
			String[] eviCtnt12 = (JSPUtil.getParameter(request, prefix	+ "evi_ctnt12", length));
			String[] invNo2 = (JSPUtil.getParameter(request, prefix	+ "inv_no2", length));
			String[] payGroupCd = (JSPUtil.getParameter(request, prefix	+ "pay_group_cd", length));
			String[] maxIssDt = (JSPUtil.getParameter(request, prefix	+ "max_iss_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sEviInvDt = (JSPUtil.getParameter(request, prefix	+ "s_evi_inv_dt", length));
			String[] eviInvDt = (JSPUtil.getParameter(request, prefix	+ "evi_inv_dt", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] asanogb = (JSPUtil.getParameter(request, prefix	+ "asanogb", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] maxRcvDt = (JSPUtil.getParameter(request, prefix	+ "max_rcv_dt", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			String[] eviCtnt11 = (JSPUtil.getParameter(request, prefix	+ "evi_ctnt11", length));
			String[] invKnt = (JSPUtil.getParameter(request, prefix	+ "inv_knt", length));
			String[] eviCtnt10 = (JSPUtil.getParameter(request, prefix	+ "evi_ctnt10", length));
			String[] apOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ofc_cd", length));
			String[] ifStatus = (JSPUtil.getParameter(request, prefix	+ "if_status", length));
			String[] compNo = (JSPUtil.getParameter(request, prefix	+ "comp_no", length));
			String[] eviCtnt9 = (JSPUtil.getParameter(request, prefix	+ "evi_ctnt9", length));
			String[] eviCtnt8 = (JSPUtil.getParameter(request, prefix	+ "evi_ctnt8", length));
			String[] eviGb = (JSPUtil.getParameter(request, prefix	+ "evi_gb", length));
			String[] eviCtnt7 = (JSPUtil.getParameter(request, prefix	+ "evi_ctnt7", length));
			String[] eviCtnt6 = (JSPUtil.getParameter(request, prefix	+ "evi_ctnt6", length));
			String[] eviCtnt5 = (JSPUtil.getParameter(request, prefix	+ "evi_ctnt5", length));
			String[] eviCtnt4 = (JSPUtil.getParameter(request, prefix	+ "evi_ctnt4", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] eviCtnt3 = (JSPUtil.getParameter(request, prefix	+ "evi_ctnt3", length));
			String[] chks = (JSPUtil.getParameter(request, prefix	+ "chks", length));
			String[] eviCtnt2 = (JSPUtil.getParameter(request, prefix	+ "evi_ctnt2", length));
			String[] eviCtnt1 = (JSPUtil.getParameter(request, prefix	+ "evi_ctnt1", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] searchTpCd = (JSPUtil.getParameter(request, prefix	+ "search_tp_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] dtStatus = (JSPUtil.getParameter(request, prefix	+ "dt_status", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			String[] csrAproTpCd = (JSPUtil.getParameter(request, prefix	+ "csr_apro_tp_cd", length));
			String[] eviTaxNo2 = (JSPUtil.getParameter(request, prefix	+ "evi_tax_no2", length));
			String[] gap = (JSPUtil.getParameter(request, prefix	+ "gap", length));
			String[] aproStep = (JSPUtil.getParameter(request, prefix	+ "apro_step", length));
			String[] eviTaxNo = (JSPUtil.getParameter(request, prefix	+ "evi_tax_no", length));
			String[] eviTotalNetAmt = (JSPUtil.getParameter(request, prefix	+ "evi_total_net_amt", length));
			String[] attrCtnt8 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt8", length));
			String[] totalAmt = (JSPUtil.getParameter(request, prefix	+ "total_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] searchCsrNo = (JSPUtil.getParameter(request, prefix	+ "search_csr_no", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] genPayTermCd = (JSPUtil.getParameter(request, prefix	+ "gen_pay_term_cd", length));
			String[] paymentDueDt = (JSPUtil.getParameter(request, prefix	+ "payment_due_dt", length));
			String[] eviTotalTaxAmt = (JSPUtil.getParameter(request, prefix	+ "evi_total_tax_amt", length));
			String[] eviTaxCode = (JSPUtil.getParameter(request, prefix	+ "evi_tax_code", length));
			String[] taxType = (JSPUtil.getParameter(request, prefix	+ "tax_type", length));
			String[] csrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "csr_usd_amt", length));
			String[] eviCompNo = (JSPUtil.getParameter(request, prefix	+ "evi_comp_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CARIssueTransferSlipManageCommonVO();
				if (taxNo1[i] != null)
					model.setTaxNo1(taxNo1[i]);
				if (taxNo2[i] != null)
					model.setTaxNo2(taxNo2[i]);
				if (eviCtnt12[i] != null)
					model.setEviCtnt12(eviCtnt12[i]);
				if (invNo2[i] != null)
					model.setInvNo2(invNo2[i]);
				if (payGroupCd[i] != null)
					model.setPayGroupCd(payGroupCd[i]);
				if (maxIssDt[i] != null)
					model.setMaxIssDt(maxIssDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sEviInvDt[i] != null)
					model.setSEviInvDt(sEviInvDt[i]);
				if (eviInvDt[i] != null)
					model.setEviInvDt(eviInvDt[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (asanogb[i] != null)
					model.setAsanogb(asanogb[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (maxRcvDt[i] != null)
					model.setMaxRcvDt(maxRcvDt[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				if (eviCtnt11[i] != null)
					model.setEviCtnt11(eviCtnt11[i]);
				if (invKnt[i] != null)
					model.setInvKnt(invKnt[i]);
				if (eviCtnt10[i] != null)
					model.setEviCtnt10(eviCtnt10[i]);
				if (apOfcCd[i] != null)
					model.setApOfcCd(apOfcCd[i]);
				if (ifStatus[i] != null)
					model.setIfStatus(ifStatus[i]);
				if (compNo[i] != null)
					model.setCompNo(compNo[i]);
				if (eviCtnt9[i] != null)
					model.setEviCtnt9(eviCtnt9[i]);
				if (eviCtnt8[i] != null)
					model.setEviCtnt8(eviCtnt8[i]);
				if (eviGb[i] != null)
					model.setEviGb(eviGb[i]);
				if (eviCtnt7[i] != null)
					model.setEviCtnt7(eviCtnt7[i]);
				if (eviCtnt6[i] != null)
					model.setEviCtnt6(eviCtnt6[i]);
				if (eviCtnt5[i] != null)
					model.setEviCtnt5(eviCtnt5[i]);
				if (eviCtnt4[i] != null)
					model.setEviCtnt4(eviCtnt4[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (eviCtnt3[i] != null)
					model.setEviCtnt3(eviCtnt3[i]);
				if (chks[i] != null)
					model.setChks(chks[i]);
				if (eviCtnt2[i] != null)
					model.setEviCtnt2(eviCtnt2[i]);
				if (eviCtnt1[i] != null)
					model.setEviCtnt1(eviCtnt1[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (searchTpCd[i] != null)
					model.setSearchTpCd(searchTpCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (dtStatus[i] != null)
					model.setDtStatus(dtStatus[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				if (csrAproTpCd[i] != null)
					model.setCsrAproTpCd(csrAproTpCd[i]);
				if (eviTaxNo2[i] != null)
					model.setEviTaxNo2(eviTaxNo2[i]);
				if (gap[i] != null)
					model.setGap(gap[i]);
				if (aproStep[i] != null)
					model.setAproStep(aproStep[i]);
				if (eviTaxNo[i] != null)
					model.setEviTaxNo(eviTaxNo[i]);
				if (eviTotalNetAmt[i] != null)
					model.setEviTotalNetAmt(eviTotalNetAmt[i]);
				if (attrCtnt8[i] != null)
					model.setAttrCtnt8(attrCtnt8[i]);
				if (totalAmt[i] != null)
					model.setTotalAmt(totalAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (searchCsrNo[i] != null)
					model.setSearchCsrNo(searchCsrNo[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (genPayTermCd[i] != null)
					model.setGenPayTermCd(genPayTermCd[i]);
				if (paymentDueDt[i] != null)
					model.setPaymentDueDt(paymentDueDt[i]);
				if (eviTotalTaxAmt[i] != null)
					model.setEviTotalTaxAmt(eviTotalTaxAmt[i]);
				if (eviTaxCode[i] != null)
					model.setEviTaxCode(eviTaxCode[i]);
				if (taxType[i] != null)
					model.setTaxType(taxType[i]);
				if (csrUsdAmt[i] != null)
					model.setCsrUsdAmt(csrUsdAmt[i]);
				if (eviCompNo[i] != null)
					model.setEviCompNo(eviCompNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCARIssueTransferSlipManageCommonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CARIssueTransferSlipManageCommonVO[]
	 */
	public CARIssueTransferSlipManageCommonVO[] getCARIssueTransferSlipManageCommonVOs(){
		CARIssueTransferSlipManageCommonVO[] vos = (CARIssueTransferSlipManageCommonVO[])models.toArray(new CARIssueTransferSlipManageCommonVO[models.size()]);
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
		this.taxNo1 = this.taxNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxNo2 = this.taxNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviCtnt12 = this.eviCtnt12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo2 = this.invNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payGroupCd = this.payGroupCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxIssDt = this.maxIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEviInvDt = this.sEviInvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviInvDt = this.eviInvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asanogb = this.asanogb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxRcvDt = this.maxRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviCtnt11 = this.eviCtnt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invKnt = this.invKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviCtnt10 = this.eviCtnt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd = this.apOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifStatus = this.ifStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.compNo = this.compNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviCtnt9 = this.eviCtnt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviCtnt8 = this.eviCtnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviGb = this.eviGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviCtnt7 = this.eviCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviCtnt6 = this.eviCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviCtnt5 = this.eviCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviCtnt4 = this.eviCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviCtnt3 = this.eviCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chks = this.chks .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviCtnt2 = this.eviCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviCtnt1 = this.eviCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchTpCd = this.searchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtStatus = this.dtStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAproTpCd = this.csrAproTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviTaxNo2 = this.eviTaxNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gap = this.gap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproStep = this.aproStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviTaxNo = this.eviTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviTotalNetAmt = this.eviTotalNetAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt8 = this.attrCtnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt = this.totalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchCsrNo = this.searchCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genPayTermCd = this.genPayTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paymentDueDt = this.paymentDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviTotalTaxAmt = this.eviTotalTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviTaxCode = this.eviTaxCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxType = this.taxType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrUsdAmt = this.csrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eviCompNo = this.eviCompNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
