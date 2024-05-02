/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AuthorizationInquiryVO.java
*@FileTitle : AuthorizationInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.authorization.vo;

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

public class AuthorizationInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AuthorizationInquiryVO> models = new ArrayList<AuthorizationInquiryVO>();
	
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String subSysCd = null;
	/* Column Info */
	private String authAproUsrNm = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String ofcCdAuth = null;
	/* Column Info */
	private String pgmNm = null;
	/* Column Info */
	private String pgmNo = null;
	/* Column Info */
	private String authAproTpNm = null;
	/* Column Info */
	private String sdateAuth = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rqstStDt = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String edate = null;
	/* Column Info */
	private String xlsFlg = null;
	/* Column Info */
	private String authAproUsrId = null;
	/* Column Info */
	private String authAproDt = null;
	/* Column Info */
	private String usrOfcCdAuth = null;
	/* Column Info */
	private String rhqOfcCdAuth = null;
	/* Column Info */
	private String edateAuth = null;
	/* Column Info */
	private String authAproTpCd = null;
	/* Column Info */
	private String rqstUsrNm = null;
	/* Column Info */
	private String aproRslt = null;
	/* Column Info */
	private String authApstsCd = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String authAproRqstNo = null;
	/* Column Info */
	private String subSysCdAuth = null;
	/* Column Info */
	private String authAproRmk = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String sdate = null;
	/* Column Info */
	private String dtlPgmUrlCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AuthorizationInquiryVO() {}

	public AuthorizationInquiryVO(String ibflag, String pagerows, String rqstUsrId, String rqstUsrNm, String subSysCd, String ofcCdAuth, String pgmNm, String pgmNo, String sdateAuth, String authAproTpNm, String usrOfcCd, String rqstStDt, String usrId, String edate, String authAproUsrId, String authAproUsrNm, String authAproDt, String usrOfcCdAuth, String rhqOfcCdAuth, String edateAuth, String authAproTpCd, String aproRslt, String authApstsCd, String rhqOfcCd, String ofcCd, String authAproRqstNo, String subSysCdAuth, String rqstOfcCd, String authAproRmk, String dtlPgmUrlCtnt, String sdate, String xlsFlg, String cxlFlg) {
		this.rqstUsrId = rqstUsrId;
		this.subSysCd = subSysCd;
		this.authAproUsrNm = authAproUsrNm;
		this.cxlFlg = cxlFlg;
		this.ofcCdAuth = ofcCdAuth;
		this.pgmNm = pgmNm;
		this.pgmNo = pgmNo;
		this.authAproTpNm = authAproTpNm;
		this.sdateAuth = sdateAuth;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rqstStDt = rqstStDt;
		this.usrOfcCd = usrOfcCd;
		this.usrId = usrId;
		this.edate = edate;
		this.xlsFlg = xlsFlg;
		this.authAproUsrId = authAproUsrId;
		this.authAproDt = authAproDt;
		this.usrOfcCdAuth = usrOfcCdAuth;
		this.rhqOfcCdAuth = rhqOfcCdAuth;
		this.edateAuth = edateAuth;
		this.authAproTpCd = authAproTpCd;
		this.rqstUsrNm = rqstUsrNm;
		this.aproRslt = aproRslt;
		this.authApstsCd = authApstsCd;
		this.rhqOfcCd = rhqOfcCd;
		this.ofcCd = ofcCd;
		this.authAproRqstNo = authAproRqstNo;
		this.subSysCdAuth = subSysCdAuth;
		this.authAproRmk = authAproRmk;
		this.rqstOfcCd = rqstOfcCd;
		this.sdate = sdate;
		this.dtlPgmUrlCtnt = dtlPgmUrlCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("sub_sys_cd", getSubSysCd());
		this.hashColumns.put("auth_apro_usr_nm", getAuthAproUsrNm());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("ofc_cd_auth", getOfcCdAuth());
		this.hashColumns.put("pgm_nm", getPgmNm());
		this.hashColumns.put("pgm_no", getPgmNo());
		this.hashColumns.put("auth_apro_tp_nm", getAuthAproTpNm());
		this.hashColumns.put("sdate_auth", getSdateAuth());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rqst_st_dt", getRqstStDt());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("edate", getEdate());
		this.hashColumns.put("xls_flg", getXlsFlg());
		this.hashColumns.put("auth_apro_usr_id", getAuthAproUsrId());
		this.hashColumns.put("auth_apro_dt", getAuthAproDt());
		this.hashColumns.put("usr_ofc_cd_auth", getUsrOfcCdAuth());
		this.hashColumns.put("rhq_ofc_cd_auth", getRhqOfcCdAuth());
		this.hashColumns.put("edate_auth", getEdateAuth());
		this.hashColumns.put("auth_apro_tp_cd", getAuthAproTpCd());
		this.hashColumns.put("rqst_usr_nm", getRqstUsrNm());
		this.hashColumns.put("apro_rslt", getAproRslt());
		this.hashColumns.put("auth_apsts_cd", getAuthApstsCd());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("auth_apro_rqst_no", getAuthAproRqstNo());
		this.hashColumns.put("sub_sys_cd_auth", getSubSysCdAuth());
		this.hashColumns.put("auth_apro_rmk", getAuthAproRmk());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("sdate", getSdate());
		this.hashColumns.put("dtl_pgm_url_ctnt", getDtlPgmUrlCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("sub_sys_cd", "subSysCd");
		this.hashFields.put("auth_apro_usr_nm", "authAproUsrNm");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("ofc_cd_auth", "ofcCdAuth");
		this.hashFields.put("pgm_nm", "pgmNm");
		this.hashFields.put("pgm_no", "pgmNo");
		this.hashFields.put("auth_apro_tp_nm", "authAproTpNm");
		this.hashFields.put("sdate_auth", "sdateAuth");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rqst_st_dt", "rqstStDt");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("edate", "edate");
		this.hashFields.put("xls_flg", "xlsFlg");
		this.hashFields.put("auth_apro_usr_id", "authAproUsrId");
		this.hashFields.put("auth_apro_dt", "authAproDt");
		this.hashFields.put("usr_ofc_cd_auth", "usrOfcCdAuth");
		this.hashFields.put("rhq_ofc_cd_auth", "rhqOfcCdAuth");
		this.hashFields.put("edate_auth", "edateAuth");
		this.hashFields.put("auth_apro_tp_cd", "authAproTpCd");
		this.hashFields.put("rqst_usr_nm", "rqstUsrNm");
		this.hashFields.put("apro_rslt", "aproRslt");
		this.hashFields.put("auth_apsts_cd", "authApstsCd");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("auth_apro_rqst_no", "authAproRqstNo");
		this.hashFields.put("sub_sys_cd_auth", "subSysCdAuth");
		this.hashFields.put("auth_apro_rmk", "authAproRmk");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("sdate", "sdate");
		this.hashFields.put("dtl_pgm_url_ctnt", "dtlPgmUrlCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return subSysCd
	 */
	public String getSubSysCd() {
		return this.subSysCd;
	}
	
	/**
	 * Column Info
	 * @return authAproUsrNm
	 */
	public String getAuthAproUsrNm() {
		return this.authAproUsrNm;
	}
	
	/**
	 * Column Info
	 * @return cxlFlg
	 */
	public String getCxlFlg() {
		return this.cxlFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcCdAuth
	 */
	public String getOfcCdAuth() {
		return this.ofcCdAuth;
	}
	
	/**
	 * Column Info
	 * @return pgmNm
	 */
	public String getPgmNm() {
		return this.pgmNm;
	}
	
	/**
	 * Column Info
	 * @return pgmNo
	 */
	public String getPgmNo() {
		return this.pgmNo;
	}
	
	/**
	 * Column Info
	 * @return authAproTpNm
	 */
	public String getAuthAproTpNm() {
		return this.authAproTpNm;
	}
	
	/**
	 * Column Info
	 * @return sdateAuth
	 */
	public String getSdateAuth() {
		return this.sdateAuth;
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
	 * @return rqstStDt
	 */
	public String getRqstStDt() {
		return this.rqstStDt;
	}
	
	/**
	 * Column Info
	 * @return usrOfcCd
	 */
	public String getUsrOfcCd() {
		return this.usrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return edate
	 */
	public String getEdate() {
		return this.edate;
	}
	
	/**
	 * Column Info
	 * @return xlsFlg
	 */
	public String getXlsFlg() {
		return this.xlsFlg;
	}
	
	/**
	 * Column Info
	 * @return authAproUsrId
	 */
	public String getAuthAproUsrId() {
		return this.authAproUsrId;
	}
	
	/**
	 * Column Info
	 * @return authAproDt
	 */
	public String getAuthAproDt() {
		return this.authAproDt;
	}
	
	/**
	 * Column Info
	 * @return usrOfcCdAuth
	 */
	public String getUsrOfcCdAuth() {
		return this.usrOfcCdAuth;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCdAuth
	 */
	public String getRhqOfcCdAuth() {
		return this.rhqOfcCdAuth;
	}
	
	/**
	 * Column Info
	 * @return edateAuth
	 */
	public String getEdateAuth() {
		return this.edateAuth;
	}
	
	/**
	 * Column Info
	 * @return authAproTpCd
	 */
	public String getAuthAproTpCd() {
		return this.authAproTpCd;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrNm
	 */
	public String getRqstUsrNm() {
		return this.rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @return aproRslt
	 */
	public String getAproRslt() {
		return this.aproRslt;
	}
	
	/**
	 * Column Info
	 * @return authApstsCd
	 */
	public String getAuthApstsCd() {
		return this.authApstsCd;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return authAproRqstNo
	 */
	public String getAuthAproRqstNo() {
		return this.authAproRqstNo;
	}
	
	/**
	 * Column Info
	 * @return subSysCdAuth
	 */
	public String getSubSysCdAuth() {
		return this.subSysCdAuth;
	}
	
	/**
	 * Column Info
	 * @return authAproRmk
	 */
	public String getAuthAproRmk() {
		return this.authAproRmk;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sdate
	 */
	public String getSdate() {
		return this.sdate;
	}
	
	/**
	 * Column Info
	 * @return dtlPgmUrlCtnt
	 */
	public String getDtlPgmUrlCtnt() {
		return this.dtlPgmUrlCtnt;
	}
	

	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param subSysCd
	 */
	public void setSubSysCd(String subSysCd) {
		this.subSysCd = subSysCd;
	}
	
	/**
	 * Column Info
	 * @param authAproUsrNm
	 */
	public void setAuthAproUsrNm(String authAproUsrNm) {
		this.authAproUsrNm = authAproUsrNm;
	}
	
	/**
	 * Column Info
	 * @param cxlFlg
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcCdAuth
	 */
	public void setOfcCdAuth(String ofcCdAuth) {
		this.ofcCdAuth = ofcCdAuth;
	}
	
	/**
	 * Column Info
	 * @param pgmNm
	 */
	public void setPgmNm(String pgmNm) {
		this.pgmNm = pgmNm;
	}
	
	/**
	 * Column Info
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}
	
	/**
	 * Column Info
	 * @param authAproTpNm
	 */
	public void setAuthAproTpNm(String authAproTpNm) {
		this.authAproTpNm = authAproTpNm;
	}
	
	/**
	 * Column Info
	 * @param sdateAuth
	 */
	public void setSdateAuth(String sdateAuth) {
		this.sdateAuth = sdateAuth;
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
	 * @param rqstStDt
	 */
	public void setRqstStDt(String rqstStDt) {
		this.rqstStDt = rqstStDt;
	}
	
	/**
	 * Column Info
	 * @param usrOfcCd
	 */
	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param edate
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	/**
	 * Column Info
	 * @param xlsFlg
	 */
	public void setXlsFlg(String xlsFlg) {
		this.xlsFlg = xlsFlg;
	}
	
	/**
	 * Column Info
	 * @param authAproUsrId
	 */
	public void setAuthAproUsrId(String authAproUsrId) {
		this.authAproUsrId = authAproUsrId;
	}
	
	/**
	 * Column Info
	 * @param authAproDt
	 */
	public void setAuthAproDt(String authAproDt) {
		this.authAproDt = authAproDt;
	}
	
	/**
	 * Column Info
	 * @param usrOfcCdAuth
	 */
	public void setUsrOfcCdAuth(String usrOfcCdAuth) {
		this.usrOfcCdAuth = usrOfcCdAuth;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCdAuth
	 */
	public void setRhqOfcCdAuth(String rhqOfcCdAuth) {
		this.rhqOfcCdAuth = rhqOfcCdAuth;
	}
	
	/**
	 * Column Info
	 * @param edateAuth
	 */
	public void setEdateAuth(String edateAuth) {
		this.edateAuth = edateAuth;
	}
	
	/**
	 * Column Info
	 * @param authAproTpCd
	 */
	public void setAuthAproTpCd(String authAproTpCd) {
		this.authAproTpCd = authAproTpCd;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrNm
	 */
	public void setRqstUsrNm(String rqstUsrNm) {
		this.rqstUsrNm = rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @param aproRslt
	 */
	public void setAproRslt(String aproRslt) {
		this.aproRslt = aproRslt;
	}
	
	/**
	 * Column Info
	 * @param authApstsCd
	 */
	public void setAuthApstsCd(String authApstsCd) {
		this.authApstsCd = authApstsCd;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param authAproRqstNo
	 */
	public void setAuthAproRqstNo(String authAproRqstNo) {
		this.authAproRqstNo = authAproRqstNo;
	}
	
	/**
	 * Column Info
	 * @param subSysCdAuth
	 */
	public void setSubSysCdAuth(String subSysCdAuth) {
		this.subSysCdAuth = subSysCdAuth;
	}
	
	/**
	 * Column Info
	 * @param authAproRmk
	 */
	public void setAuthAproRmk(String authAproRmk) {
		this.authAproRmk = authAproRmk;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sdate
	 */
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
	/**
	 * Column Info
	 * @param dtlPgmUrlCtnt
	 */
	public void setDtlPgmUrlCtnt(String dtlPgmUrlCtnt) {
		this.dtlPgmUrlCtnt = dtlPgmUrlCtnt;
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
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setSubSysCd(JSPUtil.getParameter(request, prefix + "sub_sys_cd", ""));
		setAuthAproUsrNm(JSPUtil.getParameter(request, prefix + "auth_apro_usr_nm", ""));
		setCxlFlg(JSPUtil.getParameter(request, prefix + "cxl_flg", ""));
		setOfcCdAuth(JSPUtil.getParameter(request, prefix + "ofc_cd_auth", ""));
		setPgmNm(JSPUtil.getParameter(request, prefix + "pgm_nm", ""));
		setPgmNo(JSPUtil.getParameter(request, prefix + "pgm_no", ""));
		setAuthAproTpNm(JSPUtil.getParameter(request, prefix + "auth_apro_tp_nm", ""));
		setSdateAuth(JSPUtil.getParameter(request, prefix + "sdate_auth", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRqstStDt(JSPUtil.getParameter(request, prefix + "rqst_st_dt", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, prefix + "usr_ofc_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setEdate(JSPUtil.getParameter(request, prefix + "edate", ""));
		setXlsFlg(JSPUtil.getParameter(request, prefix + "xls_flg", ""));
		setAuthAproUsrId(JSPUtil.getParameter(request, prefix + "auth_apro_usr_id", ""));
		setAuthAproDt(JSPUtil.getParameter(request, prefix + "auth_apro_dt", ""));
		setUsrOfcCdAuth(JSPUtil.getParameter(request, prefix + "usr_ofc_cd_auth", ""));
		setRhqOfcCdAuth(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd_auth", ""));
		setEdateAuth(JSPUtil.getParameter(request, prefix + "edate_auth", ""));
		setAuthAproTpCd(JSPUtil.getParameter(request, prefix + "auth_apro_tp_cd", ""));
		setRqstUsrNm(JSPUtil.getParameter(request, prefix + "rqst_usr_nm", ""));
		setAproRslt(JSPUtil.getParameter(request, prefix + "apro_rslt", ""));
		setAuthApstsCd(JSPUtil.getParameter(request, prefix + "auth_apsts_cd", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setAuthAproRqstNo(JSPUtil.getParameter(request, prefix + "auth_apro_rqst_no", ""));
		setSubSysCdAuth(JSPUtil.getParameter(request, prefix + "sub_sys_cd_auth", ""));
		setAuthAproRmk(JSPUtil.getParameter(request, prefix + "auth_apro_rmk", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setSdate(JSPUtil.getParameter(request, prefix + "sdate", ""));
		setDtlPgmUrlCtnt(JSPUtil.getParameter(request, prefix + "dtl_pgm_url_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AuthorizationInquiryVO[]
	 */
	public AuthorizationInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AuthorizationInquiryVO[]
	 */
	public AuthorizationInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AuthorizationInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] subSysCd = (JSPUtil.getParameter(request, prefix	+ "sub_sys_cd", length));
			String[] authAproUsrNm = (JSPUtil.getParameter(request, prefix	+ "auth_apro_usr_nm", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] ofcCdAuth = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_auth", length));
			String[] pgmNm = (JSPUtil.getParameter(request, prefix	+ "pgm_nm", length));
			String[] pgmNo = (JSPUtil.getParameter(request, prefix	+ "pgm_no", length));
			String[] authAproTpNm = (JSPUtil.getParameter(request, prefix	+ "auth_apro_tp_nm", length));
			String[] sdateAuth = (JSPUtil.getParameter(request, prefix	+ "sdate_auth", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rqstStDt = (JSPUtil.getParameter(request, prefix	+ "rqst_st_dt", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] edate = (JSPUtil.getParameter(request, prefix	+ "edate", length));
			String[] xlsFlg = (JSPUtil.getParameter(request, prefix	+ "xls_flg", length));
			String[] authAproUsrId = (JSPUtil.getParameter(request, prefix	+ "auth_apro_usr_id", length));
			String[] authAproDt = (JSPUtil.getParameter(request, prefix	+ "auth_apro_dt", length));
			String[] usrOfcCdAuth = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd_auth", length));
			String[] rhqOfcCdAuth = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd_auth", length));
			String[] edateAuth = (JSPUtil.getParameter(request, prefix	+ "edate_auth", length));
			String[] authAproTpCd = (JSPUtil.getParameter(request, prefix	+ "auth_apro_tp_cd", length));
			String[] rqstUsrNm = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_nm", length));
			String[] aproRslt = (JSPUtil.getParameter(request, prefix	+ "apro_rslt", length));
			String[] authApstsCd = (JSPUtil.getParameter(request, prefix	+ "auth_apsts_cd", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] authAproRqstNo = (JSPUtil.getParameter(request, prefix	+ "auth_apro_rqst_no", length));
			String[] subSysCdAuth = (JSPUtil.getParameter(request, prefix	+ "sub_sys_cd_auth", length));
			String[] authAproRmk = (JSPUtil.getParameter(request, prefix	+ "auth_apro_rmk", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] sdate = (JSPUtil.getParameter(request, prefix	+ "sdate", length));
			String[] dtlPgmUrlCtnt = (JSPUtil.getParameter(request, prefix	+ "dtl_pgm_url_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new AuthorizationInquiryVO();
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (subSysCd[i] != null)
					model.setSubSysCd(subSysCd[i]);
				if (authAproUsrNm[i] != null)
					model.setAuthAproUsrNm(authAproUsrNm[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (ofcCdAuth[i] != null)
					model.setOfcCdAuth(ofcCdAuth[i]);
				if (pgmNm[i] != null)
					model.setPgmNm(pgmNm[i]);
				if (pgmNo[i] != null)
					model.setPgmNo(pgmNo[i]);
				if (authAproTpNm[i] != null)
					model.setAuthAproTpNm(authAproTpNm[i]);
				if (sdateAuth[i] != null)
					model.setSdateAuth(sdateAuth[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rqstStDt[i] != null)
					model.setRqstStDt(rqstStDt[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (edate[i] != null)
					model.setEdate(edate[i]);
				if (xlsFlg[i] != null)
					model.setXlsFlg(xlsFlg[i]);
				if (authAproUsrId[i] != null)
					model.setAuthAproUsrId(authAproUsrId[i]);
				if (authAproDt[i] != null)
					model.setAuthAproDt(authAproDt[i]);
				if (usrOfcCdAuth[i] != null)
					model.setUsrOfcCdAuth(usrOfcCdAuth[i]);
				if (rhqOfcCdAuth[i] != null)
					model.setRhqOfcCdAuth(rhqOfcCdAuth[i]);
				if (edateAuth[i] != null)
					model.setEdateAuth(edateAuth[i]);
				if (authAproTpCd[i] != null)
					model.setAuthAproTpCd(authAproTpCd[i]);
				if (rqstUsrNm[i] != null)
					model.setRqstUsrNm(rqstUsrNm[i]);
				if (aproRslt[i] != null)
					model.setAproRslt(aproRslt[i]);
				if (authApstsCd[i] != null)
					model.setAuthApstsCd(authApstsCd[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (authAproRqstNo[i] != null)
					model.setAuthAproRqstNo(authAproRqstNo[i]);
				if (subSysCdAuth[i] != null)
					model.setSubSysCdAuth(subSysCdAuth[i]);
				if (authAproRmk[i] != null)
					model.setAuthAproRmk(authAproRmk[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (sdate[i] != null)
					model.setSdate(sdate[i]);
				if (dtlPgmUrlCtnt[i] != null)
					model.setDtlPgmUrlCtnt(dtlPgmUrlCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAuthorizationInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AuthorizationInquiryVO[]
	 */
	public AuthorizationInquiryVO[] getAuthorizationInquiryVOs(){
		AuthorizationInquiryVO[] vos = (AuthorizationInquiryVO[])models.toArray(new AuthorizationInquiryVO[models.size()]);
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
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysCd = this.subSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproUsrNm = this.authAproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCdAuth = this.ofcCdAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNm = this.pgmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNo = this.pgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproTpNm = this.authAproTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdateAuth = this.sdateAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstStDt = this.rqstStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edate = this.edate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xlsFlg = this.xlsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproUsrId = this.authAproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproDt = this.authAproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCdAuth = this.usrOfcCdAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCdAuth = this.rhqOfcCdAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edateAuth = this.edateAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproTpCd = this.authAproTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrNm = this.rqstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRslt = this.aproRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authApstsCd = this.authApstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproRqstNo = this.authAproRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysCdAuth = this.subSysCdAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproRmk = this.authAproRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdate = this.sdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlPgmUrlCtnt = this.dtlPgmUrlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
