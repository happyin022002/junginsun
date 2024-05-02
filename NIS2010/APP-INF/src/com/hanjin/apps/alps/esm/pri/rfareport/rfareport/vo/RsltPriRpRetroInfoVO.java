/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RsltPriRpRetroInfoVO.java
*@FileTitle : RsltPriRpRetroInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.12.19 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo;

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

public class RsltPriRpRetroInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriRpRetroInfoVO> models = new ArrayList<RsltPriRpRetroInfoVO>();
	
	/* Column Info */
	private String propAproDt = null;
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String aproToDt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dtType = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aproFromDt = null;
	/* Column Info */
	private String propSrepNm = null;
	/* Column Info */
	private String ctrtCustNm = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String propAproStaffCd = null;
	/* Column Info */
	private String rtroNoteNm = null;
	/* Column Info */
	private String propSrepCd = null;
	/* Column Info */
	private String ctrtCustSeq = null;
	/* Column Info */
	private String rtroNoteCd = null;
	/* Column Info */
	private String propAproStaffNm = null;
	/* Column Info */
	private String ctrtCustCd = null;
	/* Column Info */
	private String rtroNoteCtnt = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String propAproOfcCd = null;
	/* Column Info */
	private String rfaCtrtTpCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String rfaCtrtTpNm = null;
	/* Column Info */
	private String prcCtrtCustTpNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltPriRpRetroInfoVO() {}

	public RsltPriRpRetroInfoVO(String ibflag, String pagerows, String rfaNo, String propNo, String amdtSeq, String effDt, String expDt, String creDt, String propOfcCd, String propSrepCd, String propSrepNm, String propAproStaffCd, String propAproStaffNm, String propAproOfcCd, String propAproDt, String svcScpCd, String prcCtrtCustTpNm, String ctrtCustCntCd, String ctrtCustSeq, String ctrtCustCd, String ctrtCustNm, String rfaCtrtTpCd, String rfaCtrtTpNm, String rtroNoteCd, String rtroNoteNm, String rtroNoteCtnt, String aproFromDt, String aproToDt, String dtType) {
		this.propAproDt = propAproDt;
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.amdtSeq = amdtSeq;
		this.aproToDt = aproToDt;
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.dtType = dtType;
		this.rfaNo = rfaNo;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.aproFromDt = aproFromDt;
		this.propSrepNm = propSrepNm;
		this.ctrtCustNm = ctrtCustNm;
		this.expDt = expDt;
		this.propAproStaffCd = propAproStaffCd;
		this.rtroNoteNm = rtroNoteNm;
		this.propSrepCd = propSrepCd;
		this.ctrtCustSeq = ctrtCustSeq;
		this.rtroNoteCd = rtroNoteCd;
		this.propAproStaffNm = propAproStaffNm;
		this.ctrtCustCd = ctrtCustCd;
		this.rtroNoteCtnt = rtroNoteCtnt;
		this.propOfcCd = propOfcCd;
		this.propAproOfcCd = propAproOfcCd;
		this.rfaCtrtTpCd = rfaCtrtTpCd;
		this.propNo = propNo;
		this.rfaCtrtTpNm = rfaCtrtTpNm;
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
		this.hashColumns.put("apro_to_dt", getAproToDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dt_type", getDtType());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("apro_from_dt", getAproFromDt());
		this.hashColumns.put("prop_srep_nm", getPropSrepNm());
		this.hashColumns.put("ctrt_cust_nm", getCtrtCustNm());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("prop_apro_staff_cd", getPropAproStaffCd());
		this.hashColumns.put("rtro_note_nm", getRtroNoteNm());
		this.hashColumns.put("prop_srep_cd", getPropSrepCd());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("rtro_note_cd", getRtroNoteCd());
		this.hashColumns.put("prop_apro_staff_nm", getPropAproStaffNm());
		this.hashColumns.put("ctrt_cust_cd", getCtrtCustCd());
		this.hashColumns.put("rtro_note_ctnt", getRtroNoteCtnt());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("rfa_ctrt_tp_cd", getRfaCtrtTpCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("rfa_ctrt_tp_nm", getRfaCtrtTpNm());
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
		this.hashFields.put("apro_to_dt", "aproToDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dt_type", "dtType");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("apro_from_dt", "aproFromDt");
		this.hashFields.put("prop_srep_nm", "propSrepNm");
		this.hashFields.put("ctrt_cust_nm", "ctrtCustNm");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("prop_apro_staff_cd", "propAproStaffCd");
		this.hashFields.put("rtro_note_nm", "rtroNoteNm");
		this.hashFields.put("prop_srep_cd", "propSrepCd");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("rtro_note_cd", "rtroNoteCd");
		this.hashFields.put("prop_apro_staff_nm", "propAproStaffNm");
		this.hashFields.put("ctrt_cust_cd", "ctrtCustCd");
		this.hashFields.put("rtro_note_ctnt", "rtroNoteCtnt");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("rfa_ctrt_tp_cd", "rfaCtrtTpCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("rfa_ctrt_tp_nm", "rfaCtrtTpNm");
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
	 * @return aproToDt
	 */
	public String getAproToDt() {
		return this.aproToDt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return aproFromDt
	 */
	public String getAproFromDt() {
		return this.aproFromDt;
	}
	
	/**
	 * Column Info
	 * @return propSrepNm
	 */
	public String getPropSrepNm() {
		return this.propSrepNm;
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
	 * @return rtroNoteNm
	 */
	public String getRtroNoteNm() {
		return this.rtroNoteNm;
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
	 * @return ctrtCustSeq
	 */
	public String getCtrtCustSeq() {
		return this.ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @return rtroNoteCd
	 */
	public String getRtroNoteCd() {
		return this.rtroNoteCd;
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
	 * @return rtroNoteCtnt
	 */
	public String getRtroNoteCtnt() {
		return this.rtroNoteCtnt;
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
	 * @return rfaCtrtTpCd
	 */
	public String getRfaCtrtTpCd() {
		return this.rfaCtrtTpCd;
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
	 * @return rfaCtrtTpNm
	 */
	public String getRfaCtrtTpNm() {
		return this.rfaCtrtTpNm;
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
	 * @param aproToDt
	 */
	public void setAproToDt(String aproToDt) {
		this.aproToDt = aproToDt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param aproFromDt
	 */
	public void setAproFromDt(String aproFromDt) {
		this.aproFromDt = aproFromDt;
	}
	
	/**
	 * Column Info
	 * @param propSrepNm
	 */
	public void setPropSrepNm(String propSrepNm) {
		this.propSrepNm = propSrepNm;
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
	 * @param rtroNoteNm
	 */
	public void setRtroNoteNm(String rtroNoteNm) {
		this.rtroNoteNm = rtroNoteNm;
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
	 * @param ctrtCustSeq
	 */
	public void setCtrtCustSeq(String ctrtCustSeq) {
		this.ctrtCustSeq = ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @param rtroNoteCd
	 */
	public void setRtroNoteCd(String rtroNoteCd) {
		this.rtroNoteCd = rtroNoteCd;
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
	 * @param rtroNoteCtnt
	 */
	public void setRtroNoteCtnt(String rtroNoteCtnt) {
		this.rtroNoteCtnt = rtroNoteCtnt;
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
	 * @param rfaCtrtTpCd
	 */
	public void setRfaCtrtTpCd(String rfaCtrtTpCd) {
		this.rfaCtrtTpCd = rfaCtrtTpCd;
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
	 * @param rfaCtrtTpNm
	 */
	public void setRfaCtrtTpNm(String rfaCtrtTpNm) {
		this.rfaCtrtTpNm = rfaCtrtTpNm;
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
		setAproToDt(JSPUtil.getParameter(request, prefix + "apro_to_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDtType(JSPUtil.getParameter(request, prefix + "dt_type", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAproFromDt(JSPUtil.getParameter(request, prefix + "apro_from_dt", ""));
		setPropSrepNm(JSPUtil.getParameter(request, prefix + "prop_srep_nm", ""));
		setCtrtCustNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_nm", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setPropAproStaffCd(JSPUtil.getParameter(request, prefix + "prop_apro_staff_cd", ""));
		setRtroNoteNm(JSPUtil.getParameter(request, prefix + "rtro_note_nm", ""));
		setPropSrepCd(JSPUtil.getParameter(request, prefix + "prop_srep_cd", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, prefix + "ctrt_cust_seq", ""));
		setRtroNoteCd(JSPUtil.getParameter(request, prefix + "rtro_note_cd", ""));
		setPropAproStaffNm(JSPUtil.getParameter(request, prefix + "prop_apro_staff_nm", ""));
		setCtrtCustCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cd", ""));
		setRtroNoteCtnt(JSPUtil.getParameter(request, prefix + "rtro_note_ctnt", ""));
		setPropOfcCd(JSPUtil.getParameter(request, prefix + "prop_ofc_cd", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, prefix + "prop_apro_ofc_cd", ""));
		setRfaCtrtTpCd(JSPUtil.getParameter(request, prefix + "rfa_ctrt_tp_cd", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setRfaCtrtTpNm(JSPUtil.getParameter(request, prefix + "rfa_ctrt_tp_nm", ""));
		setPrcCtrtCustTpNm(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriRpRetroInfoVO[]
	 */
	public RsltPriRpRetroInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriRpRetroInfoVO[]
	 */
	public RsltPriRpRetroInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriRpRetroInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] propAproDt = (JSPUtil.getParameter(request, prefix	+ "prop_apro_dt", length));
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] aproToDt = (JSPUtil.getParameter(request, prefix	+ "apro_to_dt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dtType = (JSPUtil.getParameter(request, prefix	+ "dt_type", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aproFromDt = (JSPUtil.getParameter(request, prefix	+ "apro_from_dt", length));
			String[] propSrepNm = (JSPUtil.getParameter(request, prefix	+ "prop_srep_nm", length));
			String[] ctrtCustNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_nm", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] propAproStaffCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_staff_cd", length));
			String[] rtroNoteNm = (JSPUtil.getParameter(request, prefix	+ "rtro_note_nm", length));
			String[] propSrepCd = (JSPUtil.getParameter(request, prefix	+ "prop_srep_cd", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] rtroNoteCd = (JSPUtil.getParameter(request, prefix	+ "rtro_note_cd", length));
			String[] propAproStaffNm = (JSPUtil.getParameter(request, prefix	+ "prop_apro_staff_nm", length));
			String[] ctrtCustCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cd", length));
			String[] rtroNoteCtnt = (JSPUtil.getParameter(request, prefix	+ "rtro_note_ctnt", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_ofc_cd", length));
			String[] rfaCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "rfa_ctrt_tp_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] rfaCtrtTpNm = (JSPUtil.getParameter(request, prefix	+ "rfa_ctrt_tp_nm", length));
			String[] prcCtrtCustTpNm = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriRpRetroInfoVO();
				if (propAproDt[i] != null)
					model.setPropAproDt(propAproDt[i]);
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (aproToDt[i] != null)
					model.setAproToDt(aproToDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dtType[i] != null)
					model.setDtType(dtType[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aproFromDt[i] != null)
					model.setAproFromDt(aproFromDt[i]);
				if (propSrepNm[i] != null)
					model.setPropSrepNm(propSrepNm[i]);
				if (ctrtCustNm[i] != null)
					model.setCtrtCustNm(ctrtCustNm[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (propAproStaffCd[i] != null)
					model.setPropAproStaffCd(propAproStaffCd[i]);
				if (rtroNoteNm[i] != null)
					model.setRtroNoteNm(rtroNoteNm[i]);
				if (propSrepCd[i] != null)
					model.setPropSrepCd(propSrepCd[i]);
				if (ctrtCustSeq[i] != null)
					model.setCtrtCustSeq(ctrtCustSeq[i]);
				if (rtroNoteCd[i] != null)
					model.setRtroNoteCd(rtroNoteCd[i]);
				if (propAproStaffNm[i] != null)
					model.setPropAproStaffNm(propAproStaffNm[i]);
				if (ctrtCustCd[i] != null)
					model.setCtrtCustCd(ctrtCustCd[i]);
				if (rtroNoteCtnt[i] != null)
					model.setRtroNoteCtnt(rtroNoteCtnt[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (propAproOfcCd[i] != null)
					model.setPropAproOfcCd(propAproOfcCd[i]);
				if (rfaCtrtTpCd[i] != null)
					model.setRfaCtrtTpCd(rfaCtrtTpCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (rfaCtrtTpNm[i] != null)
					model.setRfaCtrtTpNm(rfaCtrtTpNm[i]);
				if (prcCtrtCustTpNm[i] != null)
					model.setPrcCtrtCustTpNm(prcCtrtCustTpNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriRpRetroInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriRpRetroInfoVO[]
	 */
	public RsltPriRpRetroInfoVO[] getRsltPriRpRetroInfoVOs(){
		RsltPriRpRetroInfoVO[] vos = (RsltPriRpRetroInfoVO[])models.toArray(new RsltPriRpRetroInfoVO[models.size()]);
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
		this.aproToDt = this.aproToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtType = this.dtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFromDt = this.aproFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSrepNm = this.propSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustNm = this.ctrtCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproStaffCd = this.propAproStaffCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtroNoteNm = this.rtroNoteNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSrepCd = this.propSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtroNoteCd = this.rtroNoteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproStaffNm = this.propAproStaffNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCd = this.ctrtCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtroNoteCtnt = this.rtroNoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaCtrtTpCd = this.rfaCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaCtrtTpNm = this.rfaCtrtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpNm = this.prcCtrtCustTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
