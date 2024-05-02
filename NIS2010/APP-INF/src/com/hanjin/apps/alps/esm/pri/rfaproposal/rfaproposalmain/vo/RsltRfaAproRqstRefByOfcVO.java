/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RsltRfaAproRqstRefByOfcVO.java
*@FileTitle : RsltRfaAproRqstRefByOfcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.01.27 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRfaAproRqstRefByOfcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRfaAproRqstRefByOfcVO> models = new ArrayList<RsltRfaAproRqstRefByOfcVO>();
	
	/* Column Info */
	private String propAproDt = null;
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String propProgSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String srchDt = null;
	/* Column Info */
	private String propRqstDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dtType = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String ctrtCustNm = null;
	/* Column Info */
	private String propStsCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String propAproStaffCd = null;
	/* Column Info */
	private String ctrtCustSeq = null;
	/* Column Info */
	private String propSrepCd = null;
	/* Column Info */
	private String propAproStaffNm = null;
	/* Column Info */
	private String ctrtCustCd = null;
	/* Column Info */
	private String propStsNm = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String propAproOfcCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String prcCtrtCustTpNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltRfaAproRqstRefByOfcVO() {}

	public RsltRfaAproRqstRefByOfcVO(String ibflag, String pagerows, String rfaNo, String srchDt, String amdtSeq, String propNo, String propProgSeq, String propStsCd, String propStsNm, String prcCtrtCustTpNm, String ctrtCustCntCd, String ctrtCustSeq, String ctrtCustCd, String ctrtCustNm, String propSrepCd, String propOfcCd, String propRqstDt, String propAproStaffCd, String propAproStaffNm, String propAproOfcCd, String propAproDt, String svcScpCd, String effDt, String expDt, String creDt, String dtType) {
		this.propAproDt = propAproDt;
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.propProgSeq = propProgSeq;
		this.creDt = creDt;
		this.srchDt = srchDt;
		this.propRqstDt = propRqstDt;
		this.pagerows = pagerows;
		this.dtType = dtType;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.ctrtCustNm = ctrtCustNm;
		this.propStsCd = propStsCd;
		this.expDt = expDt;
		this.propAproStaffCd = propAproStaffCd;
		this.ctrtCustSeq = ctrtCustSeq;
		this.propSrepCd = propSrepCd;
		this.propAproStaffNm = propAproStaffNm;
		this.ctrtCustCd = ctrtCustCd;
		this.propStsNm = propStsNm;
		this.propOfcCd = propOfcCd;
		this.propAproOfcCd = propAproOfcCd;
		this.propNo = propNo;
		this.prcCtrtCustTpNm = prcCtrtCustTpNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prop_apro_dt", getPropAproDt());
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("prop_prog_seq", getPropProgSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("srch_dt", getSrchDt());
		this.hashColumns.put("prop_rqst_dt", getPropRqstDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dt_type", getDtType());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ctrt_cust_nm", getCtrtCustNm());
		this.hashColumns.put("prop_sts_cd", getPropStsCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("prop_apro_staff_cd", getPropAproStaffCd());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("prop_srep_cd", getPropSrepCd());
		this.hashColumns.put("prop_apro_staff_nm", getPropAproStaffNm());
		this.hashColumns.put("ctrt_cust_cd", getCtrtCustCd());
		this.hashColumns.put("prop_sts_nm", getPropStsNm());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("prc_ctrt_cust_tp_nm", getPrcCtrtCustTpNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prop_apro_dt", "propAproDt");
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("prop_prog_seq", "propProgSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("srch_dt", "srchDt");
		this.hashFields.put("prop_rqst_dt", "propRqstDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dt_type", "dtType");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ctrt_cust_nm", "ctrtCustNm");
		this.hashFields.put("prop_sts_cd", "propStsCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("prop_apro_staff_cd", "propAproStaffCd");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("prop_srep_cd", "propSrepCd");
		this.hashFields.put("prop_apro_staff_nm", "propAproStaffNm");
		this.hashFields.put("ctrt_cust_cd", "ctrtCustCd");
		this.hashFields.put("prop_sts_nm", "propStsNm");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("prc_ctrt_cust_tp_nm", "prcCtrtCustTpNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return propAproDt
	 */
	public String getPropAproDt() {
		return this.propAproDt;
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
	 * @return propProgSeq
	 */
	public String getPropProgSeq() {
		return this.propProgSeq;
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
	 * @return srchDt
	 */
	public String getSrchDt() {
		return this.srchDt;
	}
	
	/**
	 * Column Info
	 * @return propRqstDt
	 */
	public String getPropRqstDt() {
		return this.propRqstDt;
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
	 * @return dtType
	 */
	public String getDtType() {
		return this.dtType;
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
	 * @return ctrtCustNm
	 */
	public String getCtrtCustNm() {
		return this.ctrtCustNm;
	}
	
	/**
	 * Column Info
	 * @return propStsCd
	 */
	public String getPropStsCd() {
		return this.propStsCd;
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
	 * @return propAproStaffCd
	 */
	public String getPropAproStaffCd() {
		return this.propAproStaffCd;
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
	 * @return propSrepCd
	 */
	public String getPropSrepCd() {
		return this.propSrepCd;
	}
	
	/**
	 * Column Info
	 * @return propAproStaffNm
	 */
	public String getPropAproStaffNm() {
		return this.propAproStaffNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustCd
	 */
	public String getCtrtCustCd() {
		return this.ctrtCustCd;
	}
	
	/**
	 * Column Info
	 * @return propStsNm
	 */
	public String getPropStsNm() {
		return this.propStsNm;
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
	 * @return prcCtrtCustTpNm
	 */
	public String getPrcCtrtCustTpNm() {
		return this.prcCtrtCustTpNm;
	}
	

	/**
	 * Column Info
	 * @param propAproDt
	 */
	public void setPropAproDt(String propAproDt) {
		this.propAproDt = propAproDt;
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
	 * @param propProgSeq
	 */
	public void setPropProgSeq(String propProgSeq) {
		this.propProgSeq = propProgSeq;
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
	 * @param srchDt
	 */
	public void setSrchDt(String srchDt) {
		this.srchDt = srchDt;
	}
	
	/**
	 * Column Info
	 * @param propRqstDt
	 */
	public void setPropRqstDt(String propRqstDt) {
		this.propRqstDt = propRqstDt;
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
	 * @param dtType
	 */
	public void setDtType(String dtType) {
		this.dtType = dtType;
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
	 * @param ctrtCustNm
	 */
	public void setCtrtCustNm(String ctrtCustNm) {
		this.ctrtCustNm = ctrtCustNm;
	}
	
	/**
	 * Column Info
	 * @param propStsCd
	 */
	public void setPropStsCd(String propStsCd) {
		this.propStsCd = propStsCd;
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
	 * @param propAproStaffCd
	 */
	public void setPropAproStaffCd(String propAproStaffCd) {
		this.propAproStaffCd = propAproStaffCd;
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
	 * @param propSrepCd
	 */
	public void setPropSrepCd(String propSrepCd) {
		this.propSrepCd = propSrepCd;
	}
	
	/**
	 * Column Info
	 * @param propAproStaffNm
	 */
	public void setPropAproStaffNm(String propAproStaffNm) {
		this.propAproStaffNm = propAproStaffNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustCd
	 */
	public void setCtrtCustCd(String ctrtCustCd) {
		this.ctrtCustCd = ctrtCustCd;
	}
	
	/**
	 * Column Info
	 * @param propStsNm
	 */
	public void setPropStsNm(String propStsNm) {
		this.propStsNm = propStsNm;
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
	 * @param prcCtrtCustTpNm
	 */
	public void setPrcCtrtCustTpNm(String prcCtrtCustTpNm) {
		this.prcCtrtCustTpNm = prcCtrtCustTpNm;
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
		setPropAproDt(JSPUtil.getParameter(request, prefix + "prop_apro_dt", ""));
		setCtrtCustCntCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPropProgSeq(JSPUtil.getParameter(request, prefix + "prop_prog_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSrchDt(JSPUtil.getParameter(request, prefix + "srch_dt", ""));
		setPropRqstDt(JSPUtil.getParameter(request, prefix + "prop_rqst_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDtType(JSPUtil.getParameter(request, prefix + "dt_type", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setCtrtCustNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_nm", ""));
		setPropStsCd(JSPUtil.getParameter(request, prefix + "prop_sts_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setPropAproStaffCd(JSPUtil.getParameter(request, prefix + "prop_apro_staff_cd", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, prefix + "ctrt_cust_seq", ""));
		setPropSrepCd(JSPUtil.getParameter(request, prefix + "prop_srep_cd", ""));
		setPropAproStaffNm(JSPUtil.getParameter(request, prefix + "prop_apro_staff_nm", ""));
		setCtrtCustCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cd", ""));
		setPropStsNm(JSPUtil.getParameter(request, prefix + "prop_sts_nm", ""));
		setPropOfcCd(JSPUtil.getParameter(request, prefix + "prop_ofc_cd", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, prefix + "prop_apro_ofc_cd", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setPrcCtrtCustTpNm(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRfaAproRqstRefByOfcVO[]
	 */
	public RsltRfaAproRqstRefByOfcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRfaAproRqstRefByOfcVO[]
	 */
	public RsltRfaAproRqstRefByOfcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRfaAproRqstRefByOfcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] propAproDt = (JSPUtil.getParameter(request, prefix	+ "prop_apro_dt", length));
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] propProgSeq = (JSPUtil.getParameter(request, prefix	+ "prop_prog_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] srchDt = (JSPUtil.getParameter(request, prefix	+ "srch_dt", length));
			String[] propRqstDt = (JSPUtil.getParameter(request, prefix	+ "prop_rqst_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dtType = (JSPUtil.getParameter(request, prefix	+ "dt_type", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ctrtCustNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_nm", length));
			String[] propStsCd = (JSPUtil.getParameter(request, prefix	+ "prop_sts_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] propAproStaffCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_staff_cd", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] propSrepCd = (JSPUtil.getParameter(request, prefix	+ "prop_srep_cd", length));
			String[] propAproStaffNm = (JSPUtil.getParameter(request, prefix	+ "prop_apro_staff_nm", length));
			String[] ctrtCustCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cd", length));
			String[] propStsNm = (JSPUtil.getParameter(request, prefix	+ "prop_sts_nm", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_ofc_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] prcCtrtCustTpNm = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRfaAproRqstRefByOfcVO();
				if (propAproDt[i] != null)
					model.setPropAproDt(propAproDt[i]);
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (propProgSeq[i] != null)
					model.setPropProgSeq(propProgSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (srchDt[i] != null)
					model.setSrchDt(srchDt[i]);
				if (propRqstDt[i] != null)
					model.setPropRqstDt(propRqstDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dtType[i] != null)
					model.setDtType(dtType[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ctrtCustNm[i] != null)
					model.setCtrtCustNm(ctrtCustNm[i]);
				if (propStsCd[i] != null)
					model.setPropStsCd(propStsCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (propAproStaffCd[i] != null)
					model.setPropAproStaffCd(propAproStaffCd[i]);
				if (ctrtCustSeq[i] != null)
					model.setCtrtCustSeq(ctrtCustSeq[i]);
				if (propSrepCd[i] != null)
					model.setPropSrepCd(propSrepCd[i]);
				if (propAproStaffNm[i] != null)
					model.setPropAproStaffNm(propAproStaffNm[i]);
				if (ctrtCustCd[i] != null)
					model.setCtrtCustCd(ctrtCustCd[i]);
				if (propStsNm[i] != null)
					model.setPropStsNm(propStsNm[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (propAproOfcCd[i] != null)
					model.setPropAproOfcCd(propAproOfcCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (prcCtrtCustTpNm[i] != null)
					model.setPrcCtrtCustTpNm(prcCtrtCustTpNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRfaAproRqstRefByOfcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRfaAproRqstRefByOfcVO[]
	 */
	public RsltRfaAproRqstRefByOfcVO[] getRsltRfaAproRqstRefByOfcVOs(){
		RsltRfaAproRqstRefByOfcVO[] vos = (RsltRfaAproRqstRefByOfcVO[])models.toArray(new RsltRfaAproRqstRefByOfcVO[models.size()]);
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
		this.propAproDt = this.propAproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propProgSeq = this.propProgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchDt = this.srchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propRqstDt = this.propRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtType = this.dtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustNm = this.ctrtCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsCd = this.propStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproStaffCd = this.propAproStaffCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSrepCd = this.propSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproStaffNm = this.propAproStaffNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCd = this.ctrtCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsNm = this.propStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpNm = this.prcCtrtCustTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
