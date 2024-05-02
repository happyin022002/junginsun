/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPrsProposalCmSummaryVO.java
*@FileTitle : RsltPrsProposalCmSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.12.15 송민석 
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

public class RsltPrsProposalCmSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPrsProposalCmSummaryVO> models = new ArrayList<RsltPrsProposalCmSummaryVO>();
	
	/* Column Info */
	private String costDiffCmOffice = null;
	/* Column Info */
	private String costDiffOpOffice = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String gRev = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String cmpbPreviousTrade = null;
	/* Column Info */
	private String cmpbNewTrade = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String loadPrevious = null;
	/* Column Info */
	private String costNewCmOffice = null;
	/* Column Info */
	private String cmPreviousTrade = null;
	/* Column Info */
	private String contractNm = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String cmpbDiffTrade = null;
	private String opbDiff = null;
	/* Column Info */
	private String cmNewTrade = null;
	/* Column Info */
	private String respbSrepCd = null;
	/* Column Info */
	private String cmpbPreviousOffice = null;
	/* Column Info */
	private String opNew = null;
	/* Column Info */
	private String gRevDiff = null;
	/* Column Info */
	private String opbNew = null;
	/* Column Info */
	private String propMqcQty = null;
	/* Column Info */
	private String weekNew = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String loadDiff = null;
	/* Column Info */
	private String propAproOfcCd = null;
	/* Column Info */
	private String cmPreviousOffice = null;
	/* Column Info */
	private String cmpbDiffOffice = null;
	/* Column Info */
	private String cmDiffTrade = null;
	/* Column Info */
	private String loadNew = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String weekPrevious = null;
	/* Column Info */
	private String gRevPrevious = null;
	/* Column Info */
	private String costDiffCmTrade = null;
	/* Column Info */
	private String costNewOpOffice = null;
	/* Column Info */
	private String opPrevious = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costPreviousOpOffice = null;
	/* Column Info */
	private String opbPrevious = null;
	/* Column Info */
	private String costNewCmTrade = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String opDiff = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Column Info */
	private String cmpbNewOffice = null;
	/* Column Info */
	private String propOfcNm = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String weekDiff = null;
	/* Column Info */
	private String costPreviousCmOffice = null;
	/* Column Info */
	private String dataTpCd = null;
	/* Column Info */
	private String cmDiffOffice = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String cmNewOffice = null;
	/* Column Info */
	private String costPreviousCmTrade = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPrsProposalCmSummaryVO() {}

	public RsltPrsProposalCmSummaryVO(String ibflag, String pagerows, String cmpbNewOffice, String cmpbNewTrade, String propOfcCd, String propOfcNm, String propNo, String amdtSeq, String custCntCd, String custSeq, String custNm, String ctrtEffDt, String ctrtExpDt, String weekNew, String ctrtPtyNm, String propMqcQty, String gRev, String costNewCmOffice, String costNewCmTrade, String costNewOpOffice, String opbNew, String loadNew, String cmNewOffice, String cmNewTrade, String opNew, String loadPrevious, String costPreviousCmOffice, String costPreviousCmTrade, String costPreviousOpOffice, String cmpbPreviousOffice, String cmpbPreviousTrade, String cmPreviousOffice, String cmPreviousTrade, String opbPrevious, String opPrevious, String gRevPrevious, String weekPrevious, String loadDiff, String gRevDiff, String costDiffCmOffice, String costDiffCmTrade, String costDiffOpOffice, String weekDiff, String cmpbDiffOffice, String cmpbDiffTrade,String opbDiff, String cmDiffOffice, String cmDiffTrade, String opDiff, String svcScpCd, String custTpCd, String propAproOfcCd, String respbSrepCd, String dataTpCd, String contractNm) {
		this.costDiffCmOffice = costDiffCmOffice;
		this.costDiffOpOffice = costDiffOpOffice;
		this.amdtSeq = amdtSeq;
		this.gRev = gRev;
		this.svcScpCd = svcScpCd;
		this.cmpbPreviousTrade = cmpbPreviousTrade;
		this.cmpbNewTrade = cmpbNewTrade;
		this.pagerows = pagerows;
		this.loadPrevious = loadPrevious;
		this.costNewCmOffice = costNewCmOffice;
		this.cmPreviousTrade = cmPreviousTrade;
		this.contractNm = contractNm;
		this.custCntCd = custCntCd;
		this.cmpbDiffTrade = cmpbDiffTrade;
		this.opbDiff = opbDiff;
		this.cmNewTrade = cmNewTrade;
		this.respbSrepCd = respbSrepCd;
		this.cmpbPreviousOffice = cmpbPreviousOffice;
		this.opNew = opNew;
		this.gRevDiff = gRevDiff;
		this.opbNew = opbNew;
		this.propMqcQty = propMqcQty;
		this.weekNew = weekNew;
		this.ctrtPtyNm = ctrtPtyNm;
		this.propOfcCd = propOfcCd;
		this.loadDiff = loadDiff;
		this.propAproOfcCd = propAproOfcCd;
		this.cmPreviousOffice = cmPreviousOffice;
		this.cmpbDiffOffice = cmpbDiffOffice;
		this.cmDiffTrade = cmDiffTrade;
		this.loadNew = loadNew;
		this.custNm = custNm;
		this.ctrtEffDt = ctrtEffDt;
		this.weekPrevious = weekPrevious;
		this.gRevPrevious = gRevPrevious;
		this.costDiffCmTrade = costDiffCmTrade;
		this.costNewOpOffice = costNewOpOffice;
		this.opPrevious = opPrevious;
		this.ibflag = ibflag;
		this.costPreviousOpOffice = costPreviousOpOffice;
		this.opbPrevious = opbPrevious;
		this.costNewCmTrade = costNewCmTrade;
		this.custTpCd = custTpCd;
		this.opDiff = opDiff;
		this.ctrtExpDt = ctrtExpDt;
		this.cmpbNewOffice = cmpbNewOffice;
		this.propOfcNm = propOfcNm;
		this.custSeq = custSeq;
		this.weekDiff = weekDiff;
		this.costPreviousCmOffice = costPreviousCmOffice;
		this.dataTpCd = dataTpCd;
		this.cmDiffOffice = cmDiffOffice;
		this.propNo = propNo;
		this.cmNewOffice = cmNewOffice;
		this.costPreviousCmTrade = costPreviousCmTrade;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cost_diff_cm_office", getCostDiffCmOffice());
		this.hashColumns.put("cost_diff_op_office", getCostDiffOpOffice());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("g_rev", getGRev());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cmpb_previous_trade", getCmpbPreviousTrade());
		this.hashColumns.put("cmpb_new_trade", getCmpbNewTrade());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("load_previous", getLoadPrevious());
		this.hashColumns.put("cost_new_cm_office", getCostNewCmOffice());
		this.hashColumns.put("cm_previous_trade", getCmPreviousTrade());
		this.hashColumns.put("contract_nm", getContractNm());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cmpb_diff_trade", getCmpbDiffTrade());
		this.hashColumns.put("cm_new_trade", getCmNewTrade());
		this.hashColumns.put("respb_srep_cd", getRespbSrepCd());
		this.hashColumns.put("cmpb_previous_office", getCmpbPreviousOffice());
		this.hashColumns.put("op_new", getOpNew());
		this.hashColumns.put("g_rev_diff", getGRevDiff());
		this.hashColumns.put("opb_new", getOpbNew());
		this.hashColumns.put("prop_mqc_qty", getPropMqcQty());
		this.hashColumns.put("week_new", getWeekNew());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("load_diff", getLoadDiff());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("cm_previous_office", getCmPreviousOffice());
		this.hashColumns.put("cmpb_diff_office", getCmpbDiffOffice());
		this.hashColumns.put("cm_diff_trade", getCmDiffTrade());
		this.hashColumns.put("load_new", getLoadNew());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("week_previous", getWeekPrevious());
		this.hashColumns.put("g_rev_previous", getGRevPrevious());
		this.hashColumns.put("cost_diff_cm_trade", getCostDiffCmTrade());
		this.hashColumns.put("cost_new_op_office", getCostNewOpOffice());
		this.hashColumns.put("op_previous", getOpPrevious());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_previous_op_office", getCostPreviousOpOffice());
		this.hashColumns.put("opb_previous", getOpbPrevious());
		this.hashColumns.put("cost_new_cm_trade", getCostNewCmTrade());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("op_diff", getOpDiff());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("cmpb_new_office", getCmpbNewOffice());
		this.hashColumns.put("prop_ofc_nm", getPropOfcNm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("week_diff", getWeekDiff());
		this.hashColumns.put("cost_previous_cm_office", getCostPreviousCmOffice());
		this.hashColumns.put("data_tp_cd", getDataTpCd());
		this.hashColumns.put("cm_diff_office", getCmDiffOffice());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cm_new_office", getCmNewOffice());
		this.hashColumns.put("cost_previous_cm_trade", getCostPreviousCmTrade());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cost_diff_cm_office", "costDiffCmOffice");
		this.hashFields.put("cost_diff_op_office", "costDiffOpOffice");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("g_rev", "gRev");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cmpb_previous_trade", "cmpbPreviousTrade");
		this.hashFields.put("cmpb_new_trade", "cmpbNewTrade");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("load_previous", "loadPrevious");
		this.hashFields.put("cost_new_cm_office", "costNewCmOffice");
		this.hashFields.put("cm_previous_trade", "cmPreviousTrade");
		this.hashFields.put("contract_nm", "contractNm");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cmpb_diff_trade", "cmpbDiffTrade");
		this.hashFields.put("opb_diff",opbDiff);
		this.hashFields.put("cm_new_trade", "cmNewTrade");
		this.hashFields.put("respb_srep_cd", "respbSrepCd");
		this.hashFields.put("cmpb_previous_office", "cmpbPreviousOffice");
		this.hashFields.put("op_new", "opNew");
		this.hashFields.put("g_rev_diff", "gRevDiff");
		this.hashFields.put("opb_new", "opbNew");
		this.hashFields.put("prop_mqc_qty", "propMqcQty");
		this.hashFields.put("week_new", "weekNew");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("load_diff", "loadDiff");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("cm_previous_office", "cmPreviousOffice");
		this.hashFields.put("cmpb_diff_office", "cmpbDiffOffice");
		this.hashFields.put("cm_diff_trade", "cmDiffTrade");
		this.hashFields.put("load_new", "loadNew");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("week_previous", "weekPrevious");
		this.hashFields.put("g_rev_previous", "gRevPrevious");
		this.hashFields.put("cost_diff_cm_trade", "costDiffCmTrade");
		this.hashFields.put("cost_new_op_office", "costNewOpOffice");
		this.hashFields.put("op_previous", "opPrevious");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_previous_op_office", "costPreviousOpOffice");
		this.hashFields.put("opb_previous", "opbPrevious");
		this.hashFields.put("cost_new_cm_trade", "costNewCmTrade");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("op_diff", "opDiff");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("cmpb_new_office", "cmpbNewOffice");
		this.hashFields.put("prop_ofc_nm", "propOfcNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("week_diff", "weekDiff");
		this.hashFields.put("cost_previous_cm_office", "costPreviousCmOffice");
		this.hashFields.put("data_tp_cd", "dataTpCd");
		this.hashFields.put("cm_diff_office", "cmDiffOffice");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cm_new_office", "cmNewOffice");
		this.hashFields.put("cost_previous_cm_trade", "costPreviousCmTrade");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return costDiffCmOffice
	 */
	public String getCostDiffCmOffice() {
		return this.costDiffCmOffice;
	}
	
	/**
	 * Column Info
	 * @return costDiffOpOffice
	 */
	public String getCostDiffOpOffice() {
		return this.costDiffOpOffice;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return gRev
	 */
	public String getGRev() {
		return this.gRev;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return cmpbPreviousTrade
	 */
	public String getCmpbPreviousTrade() {
		return this.cmpbPreviousTrade;
	}
	
	/**
	 * Column Info
	 * @return cmpbNewTrade
	 */
	public String getCmpbNewTrade() {
		return this.cmpbNewTrade;
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
	 * @return loadPrevious
	 */
	public String getLoadPrevious() {
		return this.loadPrevious;
	}
	
	/**
	 * Column Info
	 * @return costNewCmOffice
	 */
	public String getCostNewCmOffice() {
		return this.costNewCmOffice;
	}
	
	/**
	 * Column Info
	 * @return cmPreviousTrade
	 */
	public String getCmPreviousTrade() {
		return this.cmPreviousTrade;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return cmpbDiffTrade
	 */
	public String getCmpbDiffTrade() {
		return this.cmpbDiffTrade;
	}
	
	/**
	 * Column Info
	 * @return opbDiff
	 */
	public String getOpbDiff() {
		return this.opbDiff;
	}
	
	
	/**
	 * Column Info
	 * @return cmNewTrade
	 */
	public String getCmNewTrade() {
		return this.cmNewTrade;
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
	 * @return cmpbPreviousOffice
	 */
	public String getCmpbPreviousOffice() {
		return this.cmpbPreviousOffice;
	}
	
	/**
	 * Column Info
	 * @return opNew
	 */
	public String getOpNew() {
		return this.opNew;
	}
	
	/**
	 * Column Info
	 * @return gRevDiff
	 */
	public String getGRevDiff() {
		return this.gRevDiff;
	}
	
	/**
	 * Column Info
	 * @return opbNew
	 */
	public String getOpbNew() {
		return this.opbNew;
	}
	
	/**
	 * Column Info
	 * @return propMqcQty
	 */
	public String getPropMqcQty() {
		return this.propMqcQty;
	}
	
	/**
	 * Column Info
	 * @return weekNew
	 */
	public String getWeekNew() {
		return this.weekNew;
	}
	
	/**
	 * Column Info
	 * @return ctrtPtyNm
	 */
	public String getCtrtPtyNm() {
		return this.ctrtPtyNm;
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
	 * @return loadDiff
	 */
	public String getLoadDiff() {
		return this.loadDiff;
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
	 * @return cmPreviousOffice
	 */
	public String getCmPreviousOffice() {
		return this.cmPreviousOffice;
	}
	
	/**
	 * Column Info
	 * @return cmpbDiffOffice
	 */
	public String getCmpbDiffOffice() {
		return this.cmpbDiffOffice;
	}
	
	/**
	 * Column Info
	 * @return cmDiffTrade
	 */
	public String getCmDiffTrade() {
		return this.cmDiffTrade;
	}
	
	/**
	 * Column Info
	 * @return loadNew
	 */
	public String getLoadNew() {
		return this.loadNew;
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
	 * @return weekPrevious
	 */
	public String getWeekPrevious() {
		return this.weekPrevious;
	}
	
	/**
	 * Column Info
	 * @return gRevPrevious
	 */
	public String getGRevPrevious() {
		return this.gRevPrevious;
	}
	
	/**
	 * Column Info
	 * @return costDiffCmTrade
	 */
	public String getCostDiffCmTrade() {
		return this.costDiffCmTrade;
	}
	
	/**
	 * Column Info
	 * @return costNewOpOffice
	 */
	public String getCostNewOpOffice() {
		return this.costNewOpOffice;
	}
	
	/**
	 * Column Info
	 * @return opPrevious
	 */
	public String getOpPrevious() {
		return this.opPrevious;
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
	 * @return costPreviousOpOffice
	 */
	public String getCostPreviousOpOffice() {
		return this.costPreviousOpOffice;
	}
	
	/**
	 * Column Info
	 * @return opbPrevious
	 */
	public String getOpbPrevious() {
		return this.opbPrevious;
	}
	
	/**
	 * Column Info
	 * @return costNewCmTrade
	 */
	public String getCostNewCmTrade() {
		return this.costNewCmTrade;
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
	 * @return opDiff
	 */
	public String getOpDiff() {
		return this.opDiff;
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
	 * @return cmpbNewOffice
	 */
	public String getCmpbNewOffice() {
		return this.cmpbNewOffice;
	}
	
	/**
	 * Column Info
	 * @return propOfcNm
	 */
	public String getPropOfcNm() {
		return this.propOfcNm;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return weekDiff
	 */
	public String getWeekDiff() {
		return this.weekDiff;
	}
	
	/**
	 * Column Info
	 * @return costPreviousCmOffice
	 */
	public String getCostPreviousCmOffice() {
		return this.costPreviousCmOffice;
	}
	
	/**
	 * Column Info
	 * @return dataTpCd
	 */
	public String getDataTpCd() {
		return this.dataTpCd;
	}
	
	/**
	 * Column Info
	 * @return cmDiffOffice
	 */
	public String getCmDiffOffice() {
		return this.cmDiffOffice;
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
	 * @return cmNewOffice
	 */
	public String getCmNewOffice() {
		return this.cmNewOffice;
	}
	
	/**
	 * Column Info
	 * @return costPreviousCmTrade
	 */
	public String getCostPreviousCmTrade() {
		return this.costPreviousCmTrade;
	}
	

	/**
	 * Column Info
	 * @param costDiffCmOffice
	 */
	public void setCostDiffCmOffice(String costDiffCmOffice) {
		this.costDiffCmOffice = costDiffCmOffice;
	}
	
	/**
	 * Column Info
	 * @param costDiffOpOffice
	 */
	public void setCostDiffOpOffice(String costDiffOpOffice) {
		this.costDiffOpOffice = costDiffOpOffice;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param gRev
	 */
	public void setGRev(String gRev) {
		this.gRev = gRev;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param cmpbPreviousTrade
	 */
	public void setCmpbPreviousTrade(String cmpbPreviousTrade) {
		this.cmpbPreviousTrade = cmpbPreviousTrade;
	}
	
	/**
	 * Column Info
	 * @param cmpbNewTrade
	 */
	public void setCmpbNewTrade(String cmpbNewTrade) {
		this.cmpbNewTrade = cmpbNewTrade;
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
	 * @param loadPrevious
	 */
	public void setLoadPrevious(String loadPrevious) {
		this.loadPrevious = loadPrevious;
	}
	
	/**
	 * Column Info
	 * @param costNewCmOffice
	 */
	public void setCostNewCmOffice(String costNewCmOffice) {
		this.costNewCmOffice = costNewCmOffice;
	}
	
	/**
	 * Column Info
	 * @param cmPreviousTrade
	 */
	public void setCmPreviousTrade(String cmPreviousTrade) {
		this.cmPreviousTrade = cmPreviousTrade;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param cmpbDiffTrade
	 */
	public void setCmpbDiffTrade(String cmpbDiffTrade) {
		this.cmpbDiffTrade = cmpbDiffTrade;
	}
	
	/**
	 * Column Info
	 * @param opbDiff
	 */
	public void setOpbDiff(String opbDiff) {
		this.opbDiff = opbDiff;
	}
	
	/**
	 * Column Info
	 * @param cmNewTrade
	 */
	public void setCmNewTrade(String cmNewTrade) {
		this.cmNewTrade = cmNewTrade;
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
	 * @param cmpbPreviousOffice
	 */
	public void setCmpbPreviousOffice(String cmpbPreviousOffice) {
		this.cmpbPreviousOffice = cmpbPreviousOffice;
	}
	
	/**
	 * Column Info
	 * @param opNew
	 */
	public void setOpNew(String opNew) {
		this.opNew = opNew;
	}
	
	/**
	 * Column Info
	 * @param gRevDiff
	 */
	public void setGRevDiff(String gRevDiff) {
		this.gRevDiff = gRevDiff;
	}
	
	/**
	 * Column Info
	 * @param opbNew
	 */
	public void setOpbNew(String opbNew) {
		this.opbNew = opbNew;
	}
	
	/**
	 * Column Info
	 * @param propMqcQty
	 */
	public void setPropMqcQty(String propMqcQty) {
		this.propMqcQty = propMqcQty;
	}
	
	/**
	 * Column Info
	 * @param weekNew
	 */
	public void setWeekNew(String weekNew) {
		this.weekNew = weekNew;
	}
	
	/**
	 * Column Info
	 * @param ctrtPtyNm
	 */
	public void setCtrtPtyNm(String ctrtPtyNm) {
		this.ctrtPtyNm = ctrtPtyNm;
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
	 * @param loadDiff
	 */
	public void setLoadDiff(String loadDiff) {
		this.loadDiff = loadDiff;
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
	 * @param cmPreviousOffice
	 */
	public void setCmPreviousOffice(String cmPreviousOffice) {
		this.cmPreviousOffice = cmPreviousOffice;
	}
	
	/**
	 * Column Info
	 * @param cmpbDiffOffice
	 */
	public void setCmpbDiffOffice(String cmpbDiffOffice) {
		this.cmpbDiffOffice = cmpbDiffOffice;
	}
	
	/**
	 * Column Info
	 * @param cmDiffTrade
	 */
	public void setCmDiffTrade(String cmDiffTrade) {
		this.cmDiffTrade = cmDiffTrade;
	}
	
	/**
	 * Column Info
	 * @param loadNew
	 */
	public void setLoadNew(String loadNew) {
		this.loadNew = loadNew;
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
	 * @param weekPrevious
	 */
	public void setWeekPrevious(String weekPrevious) {
		this.weekPrevious = weekPrevious;
	}
	
	/**
	 * Column Info
	 * @param gRevPrevious
	 */
	public void setGRevPrevious(String gRevPrevious) {
		this.gRevPrevious = gRevPrevious;
	}
	
	/**
	 * Column Info
	 * @param costDiffCmTrade
	 */
	public void setCostDiffCmTrade(String costDiffCmTrade) {
		this.costDiffCmTrade = costDiffCmTrade;
	}
	
	/**
	 * Column Info
	 * @param costNewOpOffice
	 */
	public void setCostNewOpOffice(String costNewOpOffice) {
		this.costNewOpOffice = costNewOpOffice;
	}
	
	/**
	 * Column Info
	 * @param opPrevious
	 */
	public void setOpPrevious(String opPrevious) {
		this.opPrevious = opPrevious;
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
	 * @param costPreviousOpOffice
	 */
	public void setCostPreviousOpOffice(String costPreviousOpOffice) {
		this.costPreviousOpOffice = costPreviousOpOffice;
	}
	
	/**
	 * Column Info
	 * @param opbPrevious
	 */
	public void setOpbPrevious(String opbPrevious) {
		this.opbPrevious = opbPrevious;
	}
	
	/**
	 * Column Info
	 * @param costNewCmTrade
	 */
	public void setCostNewCmTrade(String costNewCmTrade) {
		this.costNewCmTrade = costNewCmTrade;
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
	 * @param opDiff
	 */
	public void setOpDiff(String opDiff) {
		this.opDiff = opDiff;
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
	 * @param cmpbNewOffice
	 */
	public void setCmpbNewOffice(String cmpbNewOffice) {
		this.cmpbNewOffice = cmpbNewOffice;
	}
	
	/**
	 * Column Info
	 * @param propOfcNm
	 */
	public void setPropOfcNm(String propOfcNm) {
		this.propOfcNm = propOfcNm;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param weekDiff
	 */
	public void setWeekDiff(String weekDiff) {
		this.weekDiff = weekDiff;
	}
	
	/**
	 * Column Info
	 * @param costPreviousCmOffice
	 */
	public void setCostPreviousCmOffice(String costPreviousCmOffice) {
		this.costPreviousCmOffice = costPreviousCmOffice;
	}
	
	/**
	 * Column Info
	 * @param dataTpCd
	 */
	public void setDataTpCd(String dataTpCd) {
		this.dataTpCd = dataTpCd;
	}
	
	/**
	 * Column Info
	 * @param cmDiffOffice
	 */
	public void setCmDiffOffice(String cmDiffOffice) {
		this.cmDiffOffice = cmDiffOffice;
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
	 * @param cmNewOffice
	 */
	public void setCmNewOffice(String cmNewOffice) {
		this.cmNewOffice = cmNewOffice;
	}
	
	/**
	 * Column Info
	 * @param costPreviousCmTrade
	 */
	public void setCostPreviousCmTrade(String costPreviousCmTrade) {
		this.costPreviousCmTrade = costPreviousCmTrade;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCostDiffCmOffice(JSPUtil.getParameter(request, "cost_diff_cm_office", ""));
		setCostDiffOpOffice(JSPUtil.getParameter(request, "cost_diff_op_office", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setGRev(JSPUtil.getParameter(request, "g_rev", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCmpbPreviousTrade(JSPUtil.getParameter(request, "cmpb_previous_trade", ""));
		setCmpbNewTrade(JSPUtil.getParameter(request, "cmpb_new_trade", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLoadPrevious(JSPUtil.getParameter(request, "load_previous", ""));
		setCostNewCmOffice(JSPUtil.getParameter(request, "cost_new_cm_office", ""));
		setCmPreviousTrade(JSPUtil.getParameter(request, "cm_previous_trade", ""));
		setContractNm(JSPUtil.getParameter(request, "contract_nm", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCmpbDiffTrade(JSPUtil.getParameter(request, "cmpb_diff_trade", ""));
		setCmNewTrade(JSPUtil.getParameter(request, "cm_new_trade", ""));
		setRespbSrepCd(JSPUtil.getParameter(request, "respb_srep_cd", ""));
		setCmpbPreviousOffice(JSPUtil.getParameter(request, "cmpb_previous_office", ""));
		setOpNew(JSPUtil.getParameter(request, "op_new", ""));
		setGRevDiff(JSPUtil.getParameter(request, "g_rev_diff", ""));
		setOpbNew(JSPUtil.getParameter(request, "opb_new", ""));
		setPropMqcQty(JSPUtil.getParameter(request, "prop_mqc_qty", ""));
		setWeekNew(JSPUtil.getParameter(request, "week_new", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, "ctrt_pty_nm", ""));
		setPropOfcCd(JSPUtil.getParameter(request, "prop_ofc_cd", ""));
		setLoadDiff(JSPUtil.getParameter(request, "load_diff", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, "prop_apro_ofc_cd", ""));
		setCmPreviousOffice(JSPUtil.getParameter(request, "cm_previous_office", ""));
		setCmpbDiffOffice(JSPUtil.getParameter(request, "cmpb_diff_office", ""));
		setCmDiffTrade(JSPUtil.getParameter(request, "cm_diff_trade", ""));
		setLoadNew(JSPUtil.getParameter(request, "load_new", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, "ctrt_eff_dt", ""));
		setWeekPrevious(JSPUtil.getParameter(request, "week_previous", ""));
		setGRevPrevious(JSPUtil.getParameter(request, "g_rev_previous", ""));
		setCostDiffCmTrade(JSPUtil.getParameter(request, "cost_diff_cm_trade", ""));
		setCostNewOpOffice(JSPUtil.getParameter(request, "cost_new_op_office", ""));
		setOpPrevious(JSPUtil.getParameter(request, "op_previous", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostPreviousOpOffice(JSPUtil.getParameter(request, "cost_previous_op_office", ""));
		setOpbPrevious(JSPUtil.getParameter(request, "opb_previous", ""));
		setCostNewCmTrade(JSPUtil.getParameter(request, "cost_new_cm_trade", ""));
		setCustTpCd(JSPUtil.getParameter(request, "cust_tp_cd", ""));
		setOpDiff(JSPUtil.getParameter(request, "op_diff", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, "ctrt_exp_dt", ""));
		setCmpbNewOffice(JSPUtil.getParameter(request, "cmpb_new_office", ""));
		setPropOfcNm(JSPUtil.getParameter(request, "prop_ofc_nm", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setWeekDiff(JSPUtil.getParameter(request, "week_diff", ""));
		setCostPreviousCmOffice(JSPUtil.getParameter(request, "cost_previous_cm_office", ""));
		setDataTpCd(JSPUtil.getParameter(request, "data_tp_cd", ""));
		setCmDiffOffice(JSPUtil.getParameter(request, "cm_diff_office", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setCmNewOffice(JSPUtil.getParameter(request, "cm_new_office", ""));
		setCostPreviousCmTrade(JSPUtil.getParameter(request, "cost_previous_cm_trade", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPrsProposalCmSummaryVO[]
	 */
	public RsltPrsProposalCmSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPrsProposalCmSummaryVO[]
	 */
	public RsltPrsProposalCmSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPrsProposalCmSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] costDiffCmOffice = (JSPUtil.getParameter(request, prefix	+ "cost_diff_cm_office", length));
			String[] costDiffOpOffice = (JSPUtil.getParameter(request, prefix	+ "cost_diff_op_office", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] gRev = (JSPUtil.getParameter(request, prefix	+ "g_rev", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] cmpbPreviousTrade = (JSPUtil.getParameter(request, prefix	+ "cmpb_previous_trade", length));
			String[] cmpbNewTrade = (JSPUtil.getParameter(request, prefix	+ "cmpb_new_trade", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] loadPrevious = (JSPUtil.getParameter(request, prefix	+ "load_previous", length));
			String[] costNewCmOffice = (JSPUtil.getParameter(request, prefix	+ "cost_new_cm_office", length));
			String[] cmPreviousTrade = (JSPUtil.getParameter(request, prefix	+ "cm_previous_trade", length));
			String[] contractNm = (JSPUtil.getParameter(request, prefix	+ "contract_nm", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] cmpbDiffTrade = (JSPUtil.getParameter(request, prefix	+ "cmpb_diff_trade", length));
			String[] opbDiff = (JSPUtil.getParameter(request, prefix	+ "opb_diff", length));
			String[] cmNewTrade = (JSPUtil.getParameter(request, prefix	+ "cm_new_trade", length));
			String[] respbSrepCd = (JSPUtil.getParameter(request, prefix	+ "respb_srep_cd", length));
			String[] cmpbPreviousOffice = (JSPUtil.getParameter(request, prefix	+ "cmpb_previous_office", length));
			String[] opNew = (JSPUtil.getParameter(request, prefix	+ "op_new", length));
			String[] gRevDiff = (JSPUtil.getParameter(request, prefix	+ "g_rev_diff", length));
			String[] opbNew = (JSPUtil.getParameter(request, prefix	+ "opb_new", length));
			String[] propMqcQty = (JSPUtil.getParameter(request, prefix	+ "prop_mqc_qty", length));
			String[] weekNew = (JSPUtil.getParameter(request, prefix	+ "week_new", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] loadDiff = (JSPUtil.getParameter(request, prefix	+ "load_diff", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_ofc_cd", length));
			String[] cmPreviousOffice = (JSPUtil.getParameter(request, prefix	+ "cm_previous_office", length));
			String[] cmpbDiffOffice = (JSPUtil.getParameter(request, prefix	+ "cmpb_diff_office", length));
			String[] cmDiffTrade = (JSPUtil.getParameter(request, prefix	+ "cm_diff_trade", length));
			String[] loadNew = (JSPUtil.getParameter(request, prefix	+ "load_new", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] weekPrevious = (JSPUtil.getParameter(request, prefix	+ "week_previous", length));
			String[] gRevPrevious = (JSPUtil.getParameter(request, prefix	+ "g_rev_previous", length));
			String[] costDiffCmTrade = (JSPUtil.getParameter(request, prefix	+ "cost_diff_cm_trade", length));
			String[] costNewOpOffice = (JSPUtil.getParameter(request, prefix	+ "cost_new_op_office", length));
			String[] opPrevious = (JSPUtil.getParameter(request, prefix	+ "op_previous", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costPreviousOpOffice = (JSPUtil.getParameter(request, prefix	+ "cost_previous_op_office", length));
			String[] opbPrevious = (JSPUtil.getParameter(request, prefix	+ "opb_previous", length));
			String[] costNewCmTrade = (JSPUtil.getParameter(request, prefix	+ "cost_new_cm_trade", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] opDiff = (JSPUtil.getParameter(request, prefix	+ "op_diff", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] cmpbNewOffice = (JSPUtil.getParameter(request, prefix	+ "cmpb_new_office", length));
			String[] propOfcNm = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_nm", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] weekDiff = (JSPUtil.getParameter(request, prefix	+ "week_diff", length));
			String[] costPreviousCmOffice = (JSPUtil.getParameter(request, prefix	+ "cost_previous_cm_office", length));
			String[] dataTpCd = (JSPUtil.getParameter(request, prefix	+ "data_tp_cd", length));
			String[] cmDiffOffice = (JSPUtil.getParameter(request, prefix	+ "cm_diff_office", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] cmNewOffice = (JSPUtil.getParameter(request, prefix	+ "cm_new_office", length));
			String[] costPreviousCmTrade = (JSPUtil.getParameter(request, prefix	+ "cost_previous_cm_trade", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPrsProposalCmSummaryVO();
				if (costDiffCmOffice[i] != null)
					model.setCostDiffCmOffice(costDiffCmOffice[i]);
				if (costDiffOpOffice[i] != null)
					model.setCostDiffOpOffice(costDiffOpOffice[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (gRev[i] != null)
					model.setGRev(gRev[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (cmpbPreviousTrade[i] != null)
					model.setCmpbPreviousTrade(cmpbPreviousTrade[i]);
				if (cmpbNewTrade[i] != null)
					model.setCmpbNewTrade(cmpbNewTrade[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (loadPrevious[i] != null)
					model.setLoadPrevious(loadPrevious[i]);
				if (costNewCmOffice[i] != null)
					model.setCostNewCmOffice(costNewCmOffice[i]);
				if (cmPreviousTrade[i] != null)
					model.setCmPreviousTrade(cmPreviousTrade[i]);
				if (contractNm[i] != null)
					model.setContractNm(contractNm[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (cmpbDiffTrade[i] != null)
					model.setCmpbDiffTrade(cmpbDiffTrade[i]);
				if (opbDiff[i] != null)
					model.setOpbDiff(opbDiff[i]);				
				if (cmNewTrade[i] != null)
					model.setCmNewTrade(cmNewTrade[i]);
				if (respbSrepCd[i] != null)
					model.setRespbSrepCd(respbSrepCd[i]);
				if (cmpbPreviousOffice[i] != null)
					model.setCmpbPreviousOffice(cmpbPreviousOffice[i]);
				if (opNew[i] != null)
					model.setOpNew(opNew[i]);
				if (gRevDiff[i] != null)
					model.setGRevDiff(gRevDiff[i]);
				if (opbNew[i] != null)
					model.setOpbNew(opbNew[i]);
				if (propMqcQty[i] != null)
					model.setPropMqcQty(propMqcQty[i]);
				if (weekNew[i] != null)
					model.setWeekNew(weekNew[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (loadDiff[i] != null)
					model.setLoadDiff(loadDiff[i]);
				if (propAproOfcCd[i] != null)
					model.setPropAproOfcCd(propAproOfcCd[i]);
				if (cmPreviousOffice[i] != null)
					model.setCmPreviousOffice(cmPreviousOffice[i]);
				if (cmpbDiffOffice[i] != null)
					model.setCmpbDiffOffice(cmpbDiffOffice[i]);
				if (cmDiffTrade[i] != null)
					model.setCmDiffTrade(cmDiffTrade[i]);
				if (loadNew[i] != null)
					model.setLoadNew(loadNew[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (weekPrevious[i] != null)
					model.setWeekPrevious(weekPrevious[i]);
				if (gRevPrevious[i] != null)
					model.setGRevPrevious(gRevPrevious[i]);
				if (costDiffCmTrade[i] != null)
					model.setCostDiffCmTrade(costDiffCmTrade[i]);
				if (costNewOpOffice[i] != null)
					model.setCostNewOpOffice(costNewOpOffice[i]);
				if (opPrevious[i] != null)
					model.setOpPrevious(opPrevious[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costPreviousOpOffice[i] != null)
					model.setCostPreviousOpOffice(costPreviousOpOffice[i]);
				if (opbPrevious[i] != null)
					model.setOpbPrevious(opbPrevious[i]);
				if (costNewCmTrade[i] != null)
					model.setCostNewCmTrade(costNewCmTrade[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (opDiff[i] != null)
					model.setOpDiff(opDiff[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (cmpbNewOffice[i] != null)
					model.setCmpbNewOffice(cmpbNewOffice[i]);
				if (propOfcNm[i] != null)
					model.setPropOfcNm(propOfcNm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (weekDiff[i] != null)
					model.setWeekDiff(weekDiff[i]);
				if (costPreviousCmOffice[i] != null)
					model.setCostPreviousCmOffice(costPreviousCmOffice[i]);
				if (dataTpCd[i] != null)
					model.setDataTpCd(dataTpCd[i]);
				if (cmDiffOffice[i] != null)
					model.setCmDiffOffice(cmDiffOffice[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (cmNewOffice[i] != null)
					model.setCmNewOffice(cmNewOffice[i]);
				if (costPreviousCmTrade[i] != null)
					model.setCostPreviousCmTrade(costPreviousCmTrade[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPrsProposalCmSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPrsProposalCmSummaryVO[]
	 */
	public RsltPrsProposalCmSummaryVO[] getRsltPrsProposalCmSummaryVOs(){
		RsltPrsProposalCmSummaryVO[] vos = (RsltPrsProposalCmSummaryVO[])models.toArray(new RsltPrsProposalCmSummaryVO[models.size()]);
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
		this.costDiffCmOffice = this.costDiffCmOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDiffOpOffice = this.costDiffOpOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRev = this.gRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbPreviousTrade = this.cmpbPreviousTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbNewTrade = this.cmpbNewTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadPrevious = this.loadPrevious .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costNewCmOffice = this.costNewCmOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPreviousTrade = this.cmPreviousTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractNm = this.contractNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbDiffTrade = this.cmpbDiffTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opbDiff = this.opbDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmNewTrade = this.cmNewTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbSrepCd = this.respbSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbPreviousOffice = this.cmpbPreviousOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opNew = this.opNew .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRevDiff = this.gRevDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opbNew = this.opbNew .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propMqcQty = this.propMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekNew = this.weekNew .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadDiff = this.loadDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPreviousOffice = this.cmPreviousOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbDiffOffice = this.cmpbDiffOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmDiffTrade = this.cmDiffTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadNew = this.loadNew .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekPrevious = this.weekPrevious .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRevPrevious = this.gRevPrevious .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDiffCmTrade = this.costDiffCmTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costNewOpOffice = this.costNewOpOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opPrevious = this.opPrevious .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costPreviousOpOffice = this.costPreviousOpOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opbPrevious = this.opbPrevious .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costNewCmTrade = this.costNewCmTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opDiff = this.opDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbNewOffice = this.cmpbNewOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcNm = this.propOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekDiff = this.weekDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costPreviousCmOffice = this.costPreviousCmOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dataTpCd = this.dataTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmDiffOffice = this.cmDiffOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmNewOffice = this.cmNewOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costPreviousCmTrade = this.costPreviousCmTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
