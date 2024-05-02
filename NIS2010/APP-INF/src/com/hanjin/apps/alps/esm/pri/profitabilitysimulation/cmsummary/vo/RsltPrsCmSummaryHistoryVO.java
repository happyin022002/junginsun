/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPrsCmSummaryHistoryVO.java
*@FileTitle : RsltPrsCmSummaryHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.10.20 송민석 
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

public class RsltPrsCmSummaryHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPrsCmSummaryHistoryVO> models = new ArrayList<RsltPrsCmSummaryHistoryVO>();
	
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String cmpbOffice = null;
	/* Column Info */
	private String cmOffice = null;
	/* Column Info */
	private String opb = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String contractNo = null;
	/* Column Info */
	private String contractNm = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String op = null;
	/* Column Info */
	private String cmpbTrade = null;
	/* Column Info */
	private String respbSrepCd = null;
	/* Column Info */
	private String propOfcNm = null;
	/* Column Info */
	private String contractBasis = null;
	/* Column Info */
	private String cmTrade = null;
	/* Column Info */
	private String propMqcQty = null;
	/* Column Info */
	private String sortKey = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String duration = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String propAproOfcCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String load = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPrsCmSummaryHistoryVO() {}

	public RsltPrsCmSummaryHistoryVO(String ibflag, String pagerows, String scNo, String contractNm, String contractBasis, String sortKey, String propOfcCd, String propOfcNm, String propNo, String amdtSeq, String contractNo, String custNm, String custCntCd, String custSeq, String duration, String ctrtPtyNm, String propMqcQty, String load, String cmOffice, String cmTrade, String op, String cmpbOffice, String cmpbTrade, String opb, String seq, String custTpCd, String propAproOfcCd, String respbSrepCd) {
		this.custNm = custNm;
		this.amdtSeq = amdtSeq;
		this.cmpbOffice = cmpbOffice;
		this.cmOffice = cmOffice;
		this.opb = opb;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.scNo = scNo;
		this.contractNo = contractNo;
		this.contractNm = contractNm;
		this.custTpCd = custTpCd;
		this.custCntCd = custCntCd;
		this.op = op;
		this.cmpbTrade = cmpbTrade;
		this.respbSrepCd = respbSrepCd;
		this.propOfcNm = propOfcNm;
		this.contractBasis = contractBasis;
		this.cmTrade = cmTrade;
		this.propMqcQty = propMqcQty;
		this.sortKey = sortKey;
		this.custSeq = custSeq;
		this.duration = duration;
		this.ctrtPtyNm = ctrtPtyNm;
		this.propOfcCd = propOfcCd;
		this.propAproOfcCd = propAproOfcCd;
		this.propNo = propNo;
		this.seq = seq;
		this.load = load;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("cmpb_office", getCmpbOffice());
		this.hashColumns.put("cm_office", getCmOffice());
		this.hashColumns.put("opb", getOpb());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("contract_no", getContractNo());
		this.hashColumns.put("contract_nm", getContractNm());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("op", getOp());
		this.hashColumns.put("cmpb_trade", getCmpbTrade());
		this.hashColumns.put("respb_srep_cd", getRespbSrepCd());
		this.hashColumns.put("prop_ofc_nm", getPropOfcNm());
		this.hashColumns.put("contract_basis", getContractBasis());
		this.hashColumns.put("cm_trade", getCmTrade());
		this.hashColumns.put("prop_mqc_qty", getPropMqcQty());
		this.hashColumns.put("sort_key", getSortKey());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("duration", getDuration());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("load", getLoad());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("cmpb_office", "cmpbOffice");
		this.hashFields.put("cm_office", "cmOffice");
		this.hashFields.put("opb", "opb");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("contract_no", "contractNo");
		this.hashFields.put("contract_nm", "contractNm");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("op", "op");
		this.hashFields.put("cmpb_trade", "cmpbTrade");
		this.hashFields.put("respb_srep_cd", "respbSrepCd");
		this.hashFields.put("prop_ofc_nm", "propOfcNm");
		this.hashFields.put("contract_basis", "contractBasis");
		this.hashFields.put("cm_trade", "cmTrade");
		this.hashFields.put("prop_mqc_qty", "propMqcQty");
		this.hashFields.put("sort_key", "sortKey");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("duration", "duration");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("load", "load");
		return this.hashFields;
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return cmpbOffice
	 */
	public String getCmpbOffice() {
		return this.cmpbOffice;
	}
	
	/**
	 * Column Info
	 * @return cmOffice
	 */
	public String getCmOffice() {
		return this.cmOffice;
	}
	
	/**
	 * Column Info
	 * @return opb
	 */
	public String getOpb() {
		return this.opb;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return contractNo
	 */
	public String getContractNo() {
		return this.contractNo;
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
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
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
	 * @return op
	 */
	public String getOp() {
		return this.op;
	}
	
	/**
	 * Column Info
	 * @return cmpbTrade
	 */
	public String getCmpbTrade() {
		return this.cmpbTrade;
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
	 * @return propOfcNm
	 */
	public String getPropOfcNm() {
		return this.propOfcNm;
	}
	
	/**
	 * Column Info
	 * @return contractBasis
	 */
	public String getContractBasis() {
		return this.contractBasis;
	}
	
	/**
	 * Column Info
	 * @return cmTrade
	 */
	public String getCmTrade() {
		return this.cmTrade;
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
	 * @return sortKey
	 */
	public String getSortKey() {
		return this.sortKey;
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
	 * @return duration
	 */
	public String getDuration() {
		return this.duration;
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
	 * @return propAproOfcCd
	 */
	public String getPropAproOfcCd() {
		return this.propAproOfcCd;
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
	 * @return load
	 */
	public String getLoad() {
		return this.load;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param cmpbOffice
	 */
	public void setCmpbOffice(String cmpbOffice) {
		this.cmpbOffice = cmpbOffice;
	}
	
	/**
	 * Column Info
	 * @param cmOffice
	 */
	public void setCmOffice(String cmOffice) {
		this.cmOffice = cmOffice;
	}
	
	/**
	 * Column Info
	 * @param opb
	 */
	public void setOpb(String opb) {
		this.opb = opb;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param contractNo
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
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
	 * @param op
	 */
	public void setOp(String op) {
		this.op = op;
	}
	
	/**
	 * Column Info
	 * @param cmpbTrade
	 */
	public void setCmpbTrade(String cmpbTrade) {
		this.cmpbTrade = cmpbTrade;
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
	 * @param propOfcNm
	 */
	public void setPropOfcNm(String propOfcNm) {
		this.propOfcNm = propOfcNm;
	}
	
	/**
	 * Column Info
	 * @param contractBasis
	 */
	public void setContractBasis(String contractBasis) {
		this.contractBasis = contractBasis;
	}
	
	/**
	 * Column Info
	 * @param cmTrade
	 */
	public void setCmTrade(String cmTrade) {
		this.cmTrade = cmTrade;
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
	 * @param sortKey
	 */
	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
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
	 * @param duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
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
	 * @param propAproOfcCd
	 */
	public void setPropAproOfcCd(String propAproOfcCd) {
		this.propAproOfcCd = propAproOfcCd;
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
	 * Column Info
	 * @param load
	 */
	public void setLoad(String load) {
		this.load = load;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setCmpbOffice(JSPUtil.getParameter(request, "cmpb_office", ""));
		setCmOffice(JSPUtil.getParameter(request, "cm_office", ""));
		setOpb(JSPUtil.getParameter(request, "opb", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setContractNo(JSPUtil.getParameter(request, "contract_no", ""));
		setContractNm(JSPUtil.getParameter(request, "contract_nm", ""));
		setCustTpCd(JSPUtil.getParameter(request, "cust_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setOp(JSPUtil.getParameter(request, "op", ""));
		setCmpbTrade(JSPUtil.getParameter(request, "cmpb_trade", ""));
		setRespbSrepCd(JSPUtil.getParameter(request, "respb_srep_cd", ""));
		setPropOfcNm(JSPUtil.getParameter(request, "prop_ofc_nm", ""));
		setContractBasis(JSPUtil.getParameter(request, "contract_basis", ""));
		setCmTrade(JSPUtil.getParameter(request, "cm_trade", ""));
		setPropMqcQty(JSPUtil.getParameter(request, "prop_mqc_qty", ""));
		setSortKey(JSPUtil.getParameter(request, "sort_key", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setDuration(JSPUtil.getParameter(request, "duration", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, "ctrt_pty_nm", ""));
		setPropOfcCd(JSPUtil.getParameter(request, "prop_ofc_cd", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, "prop_apro_ofc_cd", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setLoad(JSPUtil.getParameter(request, "load", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPrsCmSummaryHistoryVO[]
	 */
	public RsltPrsCmSummaryHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPrsCmSummaryHistoryVO[]
	 */
	public RsltPrsCmSummaryHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPrsCmSummaryHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] cmpbOffice = (JSPUtil.getParameter(request, prefix	+ "cmpb_office", length));
			String[] cmOffice = (JSPUtil.getParameter(request, prefix	+ "cm_office", length));
			String[] opb = (JSPUtil.getParameter(request, prefix	+ "opb", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] contractNo = (JSPUtil.getParameter(request, prefix	+ "contract_no", length));
			String[] contractNm = (JSPUtil.getParameter(request, prefix	+ "contract_nm", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] op = (JSPUtil.getParameter(request, prefix	+ "op", length));
			String[] cmpbTrade = (JSPUtil.getParameter(request, prefix	+ "cmpb_trade", length));
			String[] respbSrepCd = (JSPUtil.getParameter(request, prefix	+ "respb_srep_cd", length));
			String[] propOfcNm = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_nm", length));
			String[] contractBasis = (JSPUtil.getParameter(request, prefix	+ "contract_basis", length));
			String[] cmTrade = (JSPUtil.getParameter(request, prefix	+ "cm_trade", length));
			String[] propMqcQty = (JSPUtil.getParameter(request, prefix	+ "prop_mqc_qty", length));
			String[] sortKey = (JSPUtil.getParameter(request, prefix	+ "sort_key", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] duration = (JSPUtil.getParameter(request, prefix	+ "duration", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_ofc_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] load = (JSPUtil.getParameter(request, prefix	+ "load", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPrsCmSummaryHistoryVO();
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (cmpbOffice[i] != null)
					model.setCmpbOffice(cmpbOffice[i]);
				if (cmOffice[i] != null)
					model.setCmOffice(cmOffice[i]);
				if (opb[i] != null)
					model.setOpb(opb[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (contractNo[i] != null)
					model.setContractNo(contractNo[i]);
				if (contractNm[i] != null)
					model.setContractNm(contractNm[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (op[i] != null)
					model.setOp(op[i]);
				if (cmpbTrade[i] != null)
					model.setCmpbTrade(cmpbTrade[i]);
				if (respbSrepCd[i] != null)
					model.setRespbSrepCd(respbSrepCd[i]);
				if (propOfcNm[i] != null)
					model.setPropOfcNm(propOfcNm[i]);
				if (contractBasis[i] != null)
					model.setContractBasis(contractBasis[i]);
				if (cmTrade[i] != null)
					model.setCmTrade(cmTrade[i]);
				if (propMqcQty[i] != null)
					model.setPropMqcQty(propMqcQty[i]);
				if (sortKey[i] != null)
					model.setSortKey(sortKey[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (duration[i] != null)
					model.setDuration(duration[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (propAproOfcCd[i] != null)
					model.setPropAproOfcCd(propAproOfcCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (load[i] != null)
					model.setLoad(load[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPrsCmSummaryHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPrsCmSummaryHistoryVO[]
	 */
	public RsltPrsCmSummaryHistoryVO[] getRsltPrsCmSummaryHistoryVOs(){
		RsltPrsCmSummaryHistoryVO[] vos = (RsltPrsCmSummaryHistoryVO[])models.toArray(new RsltPrsCmSummaryHistoryVO[models.size()]);
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
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbOffice = this.cmpbOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOffice = this.cmOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opb = this.opb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractNo = this.contractNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractNm = this.contractNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.op = this.op .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbTrade = this.cmpbTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbSrepCd = this.respbSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcNm = this.propOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractBasis = this.contractBasis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmTrade = this.cmTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propMqcQty = this.propMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortKey = this.sortKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration = this.duration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load = this.load .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
