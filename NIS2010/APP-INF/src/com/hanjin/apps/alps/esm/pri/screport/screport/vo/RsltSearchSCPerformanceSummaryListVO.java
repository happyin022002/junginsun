/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltSearchSCPerformanceSummaryListVO.java
*@FileTitle : RsltSearchSCPerformanceSummaryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.04.09 류선우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.screport.screport.vo;

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
 * @author 류선우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchSCPerformanceSummaryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchSCPerformanceSummaryListVO> models = new ArrayList<RsltSearchSCPerformanceSummaryListVO>();
	
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String fnlMqcQty = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String mqcPerf = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String keyAcctFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtCustSlsOfcCd = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String proRtMqcPerf = null;
	/* Column Info */
	private String propAproOfcCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String ctrtCustSrepCd = null;
	/* Column Info */
	private String ctrtExpDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchSCPerformanceSummaryListVO() {}

	public RsltSearchSCPerformanceSummaryListVO(String ibflag, String pagerows, String rhqCd, String propAproOfcCd, String ctrtCustSlsOfcCd, String keyAcctFlg, String scNo, String ctrtPtyNm, String ctrtCustSrepCd, String prcCtrtCustTpCd, String fnlMqcQty, String ctrtEffDt, String ctrtExpDt, String opCntrQty, String mqcPerf, String proRtMqcPerf) {
		this.rhqCd = rhqCd;
		this.fnlMqcQty = fnlMqcQty;
		this.ctrtEffDt = ctrtEffDt;
		this.mqcPerf = mqcPerf;
		this.pagerows = pagerows;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.keyAcctFlg = keyAcctFlg;
		this.ibflag = ibflag;
		this.ctrtCustSlsOfcCd = ctrtCustSlsOfcCd;
		this.ctrtPtyNm = ctrtPtyNm;
		this.proRtMqcPerf = proRtMqcPerf;
		this.propAproOfcCd = propAproOfcCd;
		this.scNo = scNo;
		this.opCntrQty = opCntrQty;
		this.ctrtCustSrepCd = ctrtCustSrepCd;
		this.ctrtExpDt = ctrtExpDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("fnl_mqc_qty", getFnlMqcQty());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("mqc_perf", getMqcPerf());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("key_acct_flg", getKeyAcctFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_cust_sls_ofc_cd", getCtrtCustSlsOfcCd());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("pro_rt_mqc_perf", getProRtMqcPerf());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("ctrt_cust_srep_cd", getCtrtCustSrepCd());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("fnl_mqc_qty", "fnlMqcQty");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("mqc_perf", "mqcPerf");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("key_acct_flg", "keyAcctFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_cust_sls_ofc_cd", "ctrtCustSlsOfcCd");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("pro_rt_mqc_perf", "proRtMqcPerf");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("ctrt_cust_srep_cd", "ctrtCustSrepCd");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		return this.hashFields;
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
	 * @return fnlMqcQty
	 */
	public String getFnlMqcQty() {
		return this.fnlMqcQty;
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
	 * @return mqcPerf
	 */
	public String getMqcPerf() {
		return this.mqcPerf;
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
	 * @return keyAcctFlg
	 */
	public String getKeyAcctFlg() {
		return this.keyAcctFlg;
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
	 * @return ctrtCustSlsOfcCd
	 */
	public String getCtrtCustSlsOfcCd() {
		return this.ctrtCustSlsOfcCd;
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
	 * @return proRtMqcPerf
	 */
	public String getProRtMqcPerf() {
		return this.proRtMqcPerf;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
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
	 * @param fnlMqcQty
	 */
	public void setFnlMqcQty(String fnlMqcQty) {
		this.fnlMqcQty = fnlMqcQty;
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
	 * @param mqcPerf
	 */
	public void setMqcPerf(String mqcPerf) {
		this.mqcPerf = mqcPerf;
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
	 * @param keyAcctFlg
	 */
	public void setKeyAcctFlg(String keyAcctFlg) {
		this.keyAcctFlg = keyAcctFlg;
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
	 * @param ctrtCustSlsOfcCd
	 */
	public void setCtrtCustSlsOfcCd(String ctrtCustSlsOfcCd) {
		this.ctrtCustSlsOfcCd = ctrtCustSlsOfcCd;
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
	 * @param proRtMqcPerf
	 */
	public void setProRtMqcPerf(String proRtMqcPerf) {
		this.proRtMqcPerf = proRtMqcPerf;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
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
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setFnlMqcQty(JSPUtil.getParameter(request, prefix + "fnl_mqc_qty", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", ""));
		setMqcPerf(JSPUtil.getParameter(request, prefix + "mqc_perf", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_cd", ""));
		setKeyAcctFlg(JSPUtil.getParameter(request, prefix + "key_acct_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrtCustSlsOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_sls_ofc_cd", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, prefix + "ctrt_pty_nm", ""));
		setProRtMqcPerf(JSPUtil.getParameter(request, prefix + "pro_rt_mqc_perf", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, prefix + "prop_apro_ofc_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setCtrtCustSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_srep_cd", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchSCPerformanceSummaryListVO[]
	 */
	public RsltSearchSCPerformanceSummaryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchSCPerformanceSummaryListVO[]
	 */
	public RsltSearchSCPerformanceSummaryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchSCPerformanceSummaryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] fnlMqcQty = (JSPUtil.getParameter(request, prefix	+ "fnl_mqc_qty", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] mqcPerf = (JSPUtil.getParameter(request, prefix	+ "mqc_perf", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] keyAcctFlg = (JSPUtil.getParameter(request, prefix	+ "key_acct_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtCustSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_sls_ofc_cd", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] proRtMqcPerf = (JSPUtil.getParameter(request, prefix	+ "pro_rt_mqc_perf", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_ofc_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] ctrtCustSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_cd", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchSCPerformanceSummaryListVO();
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (fnlMqcQty[i] != null)
					model.setFnlMqcQty(fnlMqcQty[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (mqcPerf[i] != null)
					model.setMqcPerf(mqcPerf[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (keyAcctFlg[i] != null)
					model.setKeyAcctFlg(keyAcctFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtCustSlsOfcCd[i] != null)
					model.setCtrtCustSlsOfcCd(ctrtCustSlsOfcCd[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (proRtMqcPerf[i] != null)
					model.setProRtMqcPerf(proRtMqcPerf[i]);
				if (propAproOfcCd[i] != null)
					model.setPropAproOfcCd(propAproOfcCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (ctrtCustSrepCd[i] != null)
					model.setCtrtCustSrepCd(ctrtCustSrepCd[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchSCPerformanceSummaryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchSCPerformanceSummaryListVO[]
	 */
	public RsltSearchSCPerformanceSummaryListVO[] getRsltSearchSCPerformanceSummaryListVOs(){
		RsltSearchSCPerformanceSummaryListVO[] vos = (RsltSearchSCPerformanceSummaryListVO[])models.toArray(new RsltSearchSCPerformanceSummaryListVO[models.size()]);
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
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMqcQty = this.fnlMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqcPerf = this.mqcPerf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyAcctFlg = this.keyAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSlsOfcCd = this.ctrtCustSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.proRtMqcPerf = this.proRtMqcPerf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepCd = this.ctrtCustSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
