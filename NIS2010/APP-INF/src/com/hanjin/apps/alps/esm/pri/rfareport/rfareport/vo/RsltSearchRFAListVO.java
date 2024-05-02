/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RsltSearchRFAListVO.java
*@FileTitle : RsltSearchRFAListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.22
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.01.22 CHLOE MIJIN SEO 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo;

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
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author CHLOE MIJIN SEO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchRFAListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchRFAListVO> models = new ArrayList<RsltSearchRFAListVO>();
	
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String propScpSrepCd = null;
	/* Column Info */
	private String ctrtCustSeq = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String code = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String rfaCtrtTpCd = null;
	/* Column Info */
	private String actCustNm = null;
	/* Column Info */
	private String customerCode = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String prcCtrtCustTpNm = null;
	/* Column Info */
	private String propScpOfcCd = null;
	/* Column Info */
	private String ctrtExpDt = null;
	//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
	/* Column Info */
	private String propScpSrepNm = null;
	/* Column Info */
	private String svcTgtQty = null;
	/* Column Info */
	private String dmdtFtTpNm = null;
	/* Column Info */
	private String mnTgtQty = null;
	/* Column Info */
	private String propScpOfcSrepNm = null;
	/* Column Info */
	private String propScpOfcSrepCd = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltSearchRFAListVO() {}

	public RsltSearchRFAListVO(String ibflag, String pagerows, String ctrtCustCntCd, String propScpSrepCd, String ctrtCustSeq, String ctrtEffDt, String custNm, String amdtSeq, String svcScpCd, String code, String prcCtrtCustTpCd, String rfaNo, String effDt, String rfaCtrtTpCd, String customerCode, String expDt, String prcCtrtCustTpNm, String ctrtExpDt, String propScpOfcCd, String actCustNm, String propScpOfcSrepCd, String propScpOfcSrepNm, String propScpSrepNm, String svcTgtQty, String mnTgtQty, String dmdtFtTpNm) {
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.propScpSrepCd = propScpSrepCd;
		this.ctrtCustSeq = ctrtCustSeq;
		this.ctrtEffDt = ctrtEffDt;
		this.custNm = custNm;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.code = code;
		this.pagerows = pagerows;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.rfaCtrtTpCd = rfaCtrtTpCd;
		this.actCustNm = actCustNm;
		this.customerCode = customerCode;
		this.expDt = expDt;
		this.prcCtrtCustTpNm = prcCtrtCustTpNm;
		this.propScpOfcCd = propScpOfcCd;
		this.ctrtExpDt = ctrtExpDt;
		//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
		this.propScpSrepNm = propScpSrepNm;
		this.svcTgtQty = svcTgtQty;
		this.dmdtFtTpNm = dmdtFtTpNm;
		this.mnTgtQty = mnTgtQty;
		this.propScpOfcSrepNm = propScpOfcSrepNm;
		this.propScpOfcSrepCd = propScpOfcSrepCd;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("prop_scp_srep_cd", getPropScpSrepCd());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("rfa_ctrt_tp_cd", getRfaCtrtTpCd());
		this.hashColumns.put("act_cust_nm", getActCustNm());
		this.hashColumns.put("customer_code", getCustomerCode());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("prc_ctrt_cust_tp_nm", getPrcCtrtCustTpNm());
		this.hashColumns.put("prop_scp_ofc_cd", getPropScpOfcCd());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
		this.hashColumns.put("prop_scp_srep_nm", getPropScpSrepNm());
		this.hashColumns.put("svc_tgt_qty", getSvcTgtQty());
		this.hashColumns.put("dmdt_ft_tp_nm", getDmdtFtTpNm());
		this.hashColumns.put("mn_tgt_qty", getMnTgtQty());
		this.hashColumns.put("prop_scp_ofc_srep_nm", getPropScpOfcSrepNm());
		this.hashColumns.put("prop_scp_ofc_srep_cd", getPropScpOfcSrepCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("prop_scp_srep_cd", "propScpSrepCd");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("code", "code");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("rfa_ctrt_tp_cd", "rfaCtrtTpCd");
		this.hashFields.put("act_cust_nm", "actCustNm");
		this.hashFields.put("customer_code", "customerCode");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("prc_ctrt_cust_tp_nm", "prcCtrtCustTpNm");
		this.hashFields.put("prop_scp_ofc_cd", "propScpOfcCd");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
		this.hashFields.put("prop_scp_srep_nm", "propScpSrepNm");
		this.hashFields.put("svc_tgt_qty", "svcTgtQty");
		this.hashFields.put("dmdt_ft_tp_nm", "dmdtFtTpNm");
		this.hashFields.put("mn_tgt_qty", "mnTgtQty");
		this.hashFields.put("prop_scp_ofc_srep_nm", "propScpOfcSrepNm");
		this.hashFields.put("prop_scp_ofc_srep_cd", "propScpOfcSrepCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustCntCd
	 */
	public String getCtrtCustCntCd() {
		return this.ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return propScpSrepCd
	 */
	public String getPropScpSrepCd() {
		return this.propScpSrepCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSeq
	 */
	public String getCtrtCustSeq() {
		return this.ctrtCustSeq;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
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
	 * @return prcCtrtCustTpCd
	 */
	public String getPrcCtrtCustTpCd() {
		return this.prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return rfaCtrtTpCd
	 */
	public String getRfaCtrtTpCd() {
		return this.rfaCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return actCustNm
	 */
	public String getActCustNm() {
		return this.actCustNm;
	}
	
	/**
	 * Column Info
	 * @return customerCode
	 */
	public String getCustomerCode() {
		return this.customerCode;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return prcCtrtCustTpNm
	 */
	public String getPrcCtrtCustTpNm() {
		return this.prcCtrtCustTpNm;
	}
	
	/**
	 * Column Info
	 * @return propScpOfcCd
	 */
	public String getPropScpOfcCd() {
		return this.propScpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
	}
	
	//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
	/**
	 * Column Info
	 * @return propScpSrepNm
	 */
	public String getPropScpSrepNm() {
		return this.propScpSrepNm;
	}
	
	
	/**
	 * Column Info
	 * @return svcTgtQty
	 */
	public String getSvcTgtQty() {
		return this.svcTgtQty;
	}
	
	/**
	 * Column Info
	 * @return dmdtFtTpNm
	 */
	public String getDmdtFtTpNm() {
		return this.dmdtFtTpNm;
	}
	
	/**
	 * Column Info
	 * @return mnTgtQty
	 */
	public String getMnTgtQty() {
		return this.mnTgtQty;
	}
	
	/**
	 * Column Info
	 * @return propScpOfcSrepNm
	 */
	public String getPropScpOfcSrepNm() {
		return this.propScpOfcSrepNm;
	}
	
	/**
	 * Column Info
	 * @return propScpOfcSrepCd
	 */
	public String getPropScpOfcSrepCd() {
		return this.propScpOfcSrepCd;
	}

	/**
	 * Column Info
	 * @param ctrtCustCntCd
	 */
	public void setCtrtCustCntCd(String ctrtCustCntCd) {
		this.ctrtCustCntCd = ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param propScpSrepCd
	 */
	public void setPropScpSrepCd(String propScpSrepCd) {
		this.propScpSrepCd = propScpSrepCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSeq
	 */
	public void setCtrtCustSeq(String ctrtCustSeq) {
		this.ctrtCustSeq = ctrtCustSeq;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @param prcCtrtCustTpCd
	 */
	public void setPrcCtrtCustTpCd(String prcCtrtCustTpCd) {
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param rfaCtrtTpCd
	 */
	public void setRfaCtrtTpCd(String rfaCtrtTpCd) {
		this.rfaCtrtTpCd = rfaCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param actCustNm
	 */
	public void setActCustNm(String actCustNm) {
		this.actCustNm = actCustNm;
	}
	
	/**
	 * Column Info
	 * @param customerCode
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param prcCtrtCustTpNm
	 */
	public void setPrcCtrtCustTpNm(String prcCtrtCustTpNm) {
		this.prcCtrtCustTpNm = prcCtrtCustTpNm;
	}
	
	/**
	 * Column Info
	 * @param propScpOfcCd
	 */
	public void setPropScpOfcCd(String propScpOfcCd) {
		this.propScpOfcCd = propScpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
	}
	
	
	//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
	/**
	 * Column Info
	 * @param propScpSrepNm
	 */
	public void setPropScpSrepNm(String propScpSrepNm) {
		this.propScpSrepNm = propScpSrepNm;
	}

	
	/**
	 * Column Info
	 * @param svcTgtQty
	 */
	public void setSvcTgtQty(String svcTgtQty) {
		this.svcTgtQty = svcTgtQty;
	}
	
	/**
	 * Column Info
	 * @param dmdtFtTpNm
	 */
	public void setDmdtFtTpNm(String dmdtFtTpNm) {
		this.dmdtFtTpNm = dmdtFtTpNm;
	}
	
	/**
	 * Column Info
	 * @param mnTgtQty
	 */
	public void setMnTgtQty(String mnTgtQty) {
		this.mnTgtQty = mnTgtQty;
	}
	
	/**
	 * Column Info
	 * @param propScpOfcSrepNm
	 */
	public void setPropScpOfcSrepNm(String propScpOfcSrepNm) {
		this.propScpOfcSrepNm = propScpOfcSrepNm;
	}
	
	/**
	 * Column Info
	 * @param propScpOfcSrepCd
	 */
	public void setPropScpOfcSrepCd(String propScpOfcSrepCd) {
		this.propScpOfcSrepCd = propScpOfcSrepCd;
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
		setCtrtCustCntCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_cd", ""));
		setPropScpSrepCd(JSPUtil.getParameter(request, prefix + "prop_scp_srep_cd", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, prefix + "ctrt_cust_seq", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setRfaCtrtTpCd(JSPUtil.getParameter(request, prefix + "rfa_ctrt_tp_cd", ""));
		setActCustNm(JSPUtil.getParameter(request, prefix + "act_cust_nm", ""));
		setCustomerCode(JSPUtil.getParameter(request, prefix + "customer_code", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setPrcCtrtCustTpNm(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_nm", ""));
		setPropScpOfcCd(JSPUtil.getParameter(request, prefix + "prop_scp_ofc_cd", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", ""));
		//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
		setPropScpSrepNm(JSPUtil.getParameter(request, prefix + "prop_scp_srep_nm", ""));
		setSvcTgtQty(JSPUtil.getParameter(request, prefix + "svc_tgt_qty", ""));
		setDmdtFtTpNm(JSPUtil.getParameter(request, prefix + "dmdt_ft_tp_nm", ""));
		setMnTgtQty(JSPUtil.getParameter(request, prefix + "mn_tgt_qty", ""));
		setPropScpOfcSrepNm(JSPUtil.getParameter(request, prefix + "prop_scp_ofc_srep_nm", ""));
		setPropScpOfcSrepCd(JSPUtil.getParameter(request, prefix + "prop_scp_ofc_srep_cd", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchRFAListVO[]
	 */
	public RsltSearchRFAListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchRFAListVO[]
	 */
	public RsltSearchRFAListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchRFAListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] propScpSrepCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_srep_cd", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] rfaCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "rfa_ctrt_tp_cd", length));
			String[] actCustNm = (JSPUtil.getParameter(request, prefix	+ "act_cust_nm", length));
			String[] customerCode = (JSPUtil.getParameter(request, prefix	+ "customer_code", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] prcCtrtCustTpNm = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_nm", length));
			String[] propScpOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_ofc_cd", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
			String[] propScpSrepNm = (JSPUtil.getParameter(request, prefix	+ "prop_scp_srep_nm", length));
			String[] svcTgtQty = (JSPUtil.getParameter(request, prefix	+ "svc_tgt_qty", length));
			String[] dmdtFtTpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_ft_tp_nm", length));
			String[] mnTgtQty = (JSPUtil.getParameter(request, prefix	+ "mn_tgt_qty", length));
			String[] propScpOfcSrepNm = (JSPUtil.getParameter(request, prefix	+ "prop_scp_ofc_srep_nm", length));
			String[] propScpOfcSrepCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_ofc_srep_cd", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchRFAListVO();
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (propScpSrepCd[i] != null)
					model.setPropScpSrepCd(propScpSrepCd[i]);
				if (ctrtCustSeq[i] != null)
					model.setCtrtCustSeq(ctrtCustSeq[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (rfaCtrtTpCd[i] != null)
					model.setRfaCtrtTpCd(rfaCtrtTpCd[i]);
				if (actCustNm[i] != null)
					model.setActCustNm(actCustNm[i]);
				if (customerCode[i] != null)
					model.setCustomerCode(customerCode[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (prcCtrtCustTpNm[i] != null)
					model.setPrcCtrtCustTpNm(prcCtrtCustTpNm[i]);
				if (propScpOfcCd[i] != null)
					model.setPropScpOfcCd(propScpOfcCd[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
				if (propScpSrepNm[i] != null)
					model.setPropScpSrepNm(propScpSrepNm[i]);
				if (svcTgtQty[i] != null)
					model.setSvcTgtQty(svcTgtQty[i]);
				if (dmdtFtTpNm[i] != null)
					model.setDmdtFtTpNm(dmdtFtTpNm[i]);
				if (mnTgtQty[i] != null)
					model.setMnTgtQty(mnTgtQty[i]);
				if (propScpOfcSrepNm[i] != null)
					model.setPropScpOfcSrepNm(propScpOfcSrepNm[i]);
				if (propScpOfcSrepCd[i] != null)
					model.setPropScpOfcSrepCd(propScpOfcSrepCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchRFAListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchRFAListVO[]
	 */
	public RsltSearchRFAListVO[] getRsltSearchRFAListVOs(){
		RsltSearchRFAListVO[] vos = (RsltSearchRFAListVO[])models.toArray(new RsltSearchRFAListVO[models.size()]);
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
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpSrepCd = this.propScpSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaCtrtTpCd = this.rfaCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustNm = this.actCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerCode = this.customerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpNm = this.prcCtrtCustTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpOfcCd = this.propScpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
		this.propScpSrepNm = this.propScpSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTgtQty = this.svcTgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtFtTpNm = this.dmdtFtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnTgtQty = this.mnTgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpOfcSrepNm = this.propScpOfcSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpOfcSrepCd = this.propScpOfcSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
