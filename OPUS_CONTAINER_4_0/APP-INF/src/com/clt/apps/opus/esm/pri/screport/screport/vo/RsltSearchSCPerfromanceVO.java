/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltSearchSCPerfromanceVO.java
*@FileTitle : RsltSearchSCPerfromanceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.11.11 김대호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchSCPerfromanceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchSCPerfromanceVO> models = new ArrayList<RsltSearchSCPerfromanceVO>();
	
	/* Column Info */
	private String rfFlg = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String mqcPerf = null;
	/* Column Info */
	private String blObrdDtTo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String keyAcctFlg = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String ctrtCustSlsOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String proRtMqcPerf = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String blObrdDtFrom = null;
	/* Column Info */
	private String cnt = null;
	/* Column Info */
	private String fnlMqcQty = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String gamtFlg = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String propAproOfcCd = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String ctrtCustSrepCd = null;
	/* Column Info */
	private String byScope = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchSCPerfromanceVO() {}

	public RsltSearchSCPerfromanceVO(String ibflag, String pagerows, String blObrdDtFrom, String blObrdDtTo, String byScope, String cnt, String ctrtCustSlsOfcCd, String ctrtCustSrepCd, String ctrtPtyNm, String ctrtEffDt, String ctrtExpDt, String effDt, String expDt, String fnlMqcQty, String gamtFlg, String keyAcctFlg, String mqcPerf, String opCntrQty, String prcCtrtCustTpCd, String proRtMqcPerf, String propAproOfcCd, String rhq, String rhqCd, String rfFlg, String scNo, String svcScpCd) {
		this.rfFlg = rfFlg;
		this.ctrtEffDt = ctrtEffDt;
		this.svcScpCd = svcScpCd;
		this.mqcPerf = mqcPerf;
		this.blObrdDtTo = blObrdDtTo;
		this.pagerows = pagerows;
		this.keyAcctFlg = keyAcctFlg;
		this.effDt = effDt;
		this.ctrtCustSlsOfcCd = ctrtCustSlsOfcCd;
		this.ibflag = ibflag;
		this.proRtMqcPerf = proRtMqcPerf;
		this.scNo = scNo;
		this.expDt = expDt;
		this.ctrtExpDt = ctrtExpDt;
		this.rhq = rhq;
		this.blObrdDtFrom = blObrdDtFrom;
		this.cnt = cnt;
		this.fnlMqcQty = fnlMqcQty;
		this.rhqCd = rhqCd;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.gamtFlg = gamtFlg;
		this.ctrtPtyNm = ctrtPtyNm;
		this.propAproOfcCd = propAproOfcCd;
		this.opCntrQty = opCntrQty;
		this.ctrtCustSrepCd = ctrtCustSrepCd;
		this.byScope = byScope;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rf_flg", getRfFlg());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("mqc_perf", getMqcPerf());
		this.hashColumns.put("bl_obrd_dt_to", getBlObrdDtTo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("key_acct_flg", getKeyAcctFlg());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ctrt_cust_sls_ofc_cd", getCtrtCustSlsOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pro_rt_mqc_perf", getProRtMqcPerf());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("bl_obrd_dt_from", getBlObrdDtFrom());
		this.hashColumns.put("cnt", getCnt());
		this.hashColumns.put("fnl_mqc_qty", getFnlMqcQty());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("gamt_flg", getGamtFlg());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("ctrt_cust_srep_cd", getCtrtCustSrepCd());
		this.hashColumns.put("by_scope", getByScope());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rf_flg", "rfFlg");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("mqc_perf", "mqcPerf");
		this.hashFields.put("bl_obrd_dt_to", "blObrdDtTo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("key_acct_flg", "keyAcctFlg");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ctrt_cust_sls_ofc_cd", "ctrtCustSlsOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pro_rt_mqc_perf", "proRtMqcPerf");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("bl_obrd_dt_from", "blObrdDtFrom");
		this.hashFields.put("cnt", "cnt");
		this.hashFields.put("fnl_mqc_qty", "fnlMqcQty");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("gamt_flg", "gamtFlg");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("ctrt_cust_srep_cd", "ctrtCustSrepCd");
		this.hashFields.put("by_scope", "byScope");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rfFlg
	 */
	public String getRfFlg() {
		return this.rfFlg;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return mqcPerf
	 */
	public String getMqcPerf() {
		return this.mqcPerf;
	}
	
	/**
	 * Column Info
	 * @return blObrdDtTo
	 */
	public String getBlObrdDtTo() {
		return this.blObrdDtTo;
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
	 * @return keyAcctFlg
	 */
	public String getKeyAcctFlg() {
		return this.keyAcctFlg;
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
	 * @return ctrtCustSlsOfcCd
	 */
	public String getCtrtCustSlsOfcCd() {
		return this.ctrtCustSlsOfcCd;
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
	 * @return proRtMqcPerf
	 */
	public String getProRtMqcPerf() {
		return this.proRtMqcPerf;
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
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
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
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return blObrdDtFrom
	 */
	public String getBlObrdDtFrom() {
		return this.blObrdDtFrom;
	}
	
	/**
	 * Column Info
	 * @return cnt
	 */
	public String getCnt() {
		return this.cnt;
	}
	
	/**
	 * Column Info
	 * @return fnlMqcQty
	 */
	public String getFnlMqcQty() {
		return this.fnlMqcQty;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
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
	 * @return gamtFlg
	 */
	public String getGamtFlg() {
		return this.gamtFlg;
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
	 * @return propAproOfcCd
	 */
	public String getPropAproOfcCd() {
		return this.propAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSrepCd
	 */
	public String getCtrtCustSrepCd() {
		return this.ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @return byScope
	 */
	public String getByScope() {
		return this.byScope;
	}
	

	/**
	 * Column Info
	 * @param rfFlg
	 */
	public void setRfFlg(String rfFlg) {
		this.rfFlg = rfFlg;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param mqcPerf
	 */
	public void setMqcPerf(String mqcPerf) {
		this.mqcPerf = mqcPerf;
	}
	
	/**
	 * Column Info
	 * @param blObrdDtTo
	 */
	public void setBlObrdDtTo(String blObrdDtTo) {
		this.blObrdDtTo = blObrdDtTo;
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
	 * @param keyAcctFlg
	 */
	public void setKeyAcctFlg(String keyAcctFlg) {
		this.keyAcctFlg = keyAcctFlg;
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
	 * @param ctrtCustSlsOfcCd
	 */
	public void setCtrtCustSlsOfcCd(String ctrtCustSlsOfcCd) {
		this.ctrtCustSlsOfcCd = ctrtCustSlsOfcCd;
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
	 * @param proRtMqcPerf
	 */
	public void setProRtMqcPerf(String proRtMqcPerf) {
		this.proRtMqcPerf = proRtMqcPerf;
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
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
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
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param blObrdDtFrom
	 */
	public void setBlObrdDtFrom(String blObrdDtFrom) {
		this.blObrdDtFrom = blObrdDtFrom;
	}
	
	/**
	 * Column Info
	 * @param cnt
	 */
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
	/**
	 * Column Info
	 * @param fnlMqcQty
	 */
	public void setFnlMqcQty(String fnlMqcQty) {
		this.fnlMqcQty = fnlMqcQty;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
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
	 * @param gamtFlg
	 */
	public void setGamtFlg(String gamtFlg) {
		this.gamtFlg = gamtFlg;
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
	 * @param propAproOfcCd
	 */
	public void setPropAproOfcCd(String propAproOfcCd) {
		this.propAproOfcCd = propAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSrepCd
	 */
	public void setCtrtCustSrepCd(String ctrtCustSrepCd) {
		this.ctrtCustSrepCd = ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @param byScope
	 */
	public void setByScope(String byScope) {
		this.byScope = byScope;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRfFlg(JSPUtil.getParameter(request, "rf_flg", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, "ctrt_eff_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setMqcPerf(JSPUtil.getParameter(request, "mqc_perf", ""));
		setBlObrdDtTo(JSPUtil.getParameter(request, "bl_obrd_dt_to", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setKeyAcctFlg(JSPUtil.getParameter(request, "key_acct_flg", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setCtrtCustSlsOfcCd(JSPUtil.getParameter(request, "ctrt_cust_sls_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setProRtMqcPerf(JSPUtil.getParameter(request, "pro_rt_mqc_perf", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, "ctrt_exp_dt", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
		setBlObrdDtFrom(JSPUtil.getParameter(request, "bl_obrd_dt_from", ""));
		setCnt(JSPUtil.getParameter(request, "cnt", ""));
		setFnlMqcQty(JSPUtil.getParameter(request, "fnl_mqc_qty", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, "prc_ctrt_cust_tp_cd", ""));
		setGamtFlg(JSPUtil.getParameter(request, "gamt_flg", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, "ctrt_pty_nm", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, "prop_apro_ofc_cd", ""));
		setOpCntrQty(JSPUtil.getParameter(request, "op_cntr_qty", ""));
		setCtrtCustSrepCd(JSPUtil.getParameter(request, "ctrt_cust_srep_cd", ""));
		setByScope(JSPUtil.getParameter(request, "by_scope", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchSCPerfromanceVO[]
	 */
	public RsltSearchSCPerfromanceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchSCPerfromanceVO[]
	 */
	public RsltSearchSCPerfromanceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchSCPerfromanceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rfFlg = (JSPUtil.getParameter(request, prefix	+ "rf_flg", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] mqcPerf = (JSPUtil.getParameter(request, prefix	+ "mqc_perf", length));
			String[] blObrdDtTo = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt_to", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] keyAcctFlg = (JSPUtil.getParameter(request, prefix	+ "key_acct_flg", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ctrtCustSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_sls_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] proRtMqcPerf = (JSPUtil.getParameter(request, prefix	+ "pro_rt_mqc_perf", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] blObrdDtFrom = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt_from", length));
			String[] cnt = (JSPUtil.getParameter(request, prefix	+ "cnt", length));
			String[] fnlMqcQty = (JSPUtil.getParameter(request, prefix	+ "fnl_mqc_qty", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] gamtFlg = (JSPUtil.getParameter(request, prefix	+ "gamt_flg", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_ofc_cd", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] ctrtCustSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_cd", length));
			String[] byScope = (JSPUtil.getParameter(request, prefix	+ "by_scope", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchSCPerfromanceVO();
				if (rfFlg[i] != null)
					model.setRfFlg(rfFlg[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (mqcPerf[i] != null)
					model.setMqcPerf(mqcPerf[i]);
				if (blObrdDtTo[i] != null)
					model.setBlObrdDtTo(blObrdDtTo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (keyAcctFlg[i] != null)
					model.setKeyAcctFlg(keyAcctFlg[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ctrtCustSlsOfcCd[i] != null)
					model.setCtrtCustSlsOfcCd(ctrtCustSlsOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (proRtMqcPerf[i] != null)
					model.setProRtMqcPerf(proRtMqcPerf[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (blObrdDtFrom[i] != null)
					model.setBlObrdDtFrom(blObrdDtFrom[i]);
				if (cnt[i] != null)
					model.setCnt(cnt[i]);
				if (fnlMqcQty[i] != null)
					model.setFnlMqcQty(fnlMqcQty[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (gamtFlg[i] != null)
					model.setGamtFlg(gamtFlg[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (propAproOfcCd[i] != null)
					model.setPropAproOfcCd(propAproOfcCd[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (ctrtCustSrepCd[i] != null)
					model.setCtrtCustSrepCd(ctrtCustSrepCd[i]);
				if (byScope[i] != null)
					model.setByScope(byScope[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchSCPerfromanceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchSCPerfromanceVO[]
	 */
	public RsltSearchSCPerfromanceVO[] getRsltSearchSCPerfromanceVOs(){
		RsltSearchSCPerfromanceVO[] vos = (RsltSearchSCPerfromanceVO[])models.toArray(new RsltSearchSCPerfromanceVO[models.size()]);
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
		this.rfFlg = this.rfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqcPerf = this.mqcPerf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDtTo = this.blObrdDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyAcctFlg = this.keyAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSlsOfcCd = this.ctrtCustSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.proRtMqcPerf = this.proRtMqcPerf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDtFrom = this.blObrdDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt = this.cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMqcQty = this.fnlMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gamtFlg = this.gamtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepCd = this.ctrtCustSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.byScope = this.byScope .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
