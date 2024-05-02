/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationAproVO.java
*@FileTitle : AuthorizationAproVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.16  
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

public class AuthorizationAproVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AuthorizationAproVO> models = new ArrayList<AuthorizationAproVO>();
	
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String rqstUsrNm = null;
	/* Column Info */
	private String subSysCd = null;
	/* Column Info */
	private String authAproTpCd = null;
	/* Column Info */
	private String edateAuth = null;
	/* Column Info */
	private String ofcCdAuth = null;
	/* Column Info */
	private String pgmNm = null;
	/* Column Info */
	private String loginUsrId = null;
	/* Column Info */
	private String authApstsCd = null;
	/* Column Info */
	private String pgmNo = null;
	/* Column Info */
	private String authAproTpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sdateAuth = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rqstStDt = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info */
	private String authAproRqstNo = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String subSysCdAuth = null;
	/* Column Info */
	private String edate = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String dtlPgmUrlCtnt = null;
	/* Column Info */
	private String sdate = null;
	/* Column Info */
	private String usrOfcCdAuth = null;
	/* Column Info */
	private String crntSts = null;
	/* Column Info */
	private String authAproRmk = null;
	/* Column Info */
	private String xlsFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AuthorizationAproVO() {}

	public AuthorizationAproVO(String xlsFlg, String ibflag, String pagerows, String crntSts, String subSysCd, String usrOfcCd, String subSysCdAuth, String usrOfcCdAuth, String ofcCdAuth, String ofcCd, String edateAuth, String sdateAuth, String edate, String sdate, String pgmNo, String pgmNm, String authAproRqstNo, String authAproTpCd, String authAproTpNm, String rqstStDt, String rqstUsrId, String rqstUsrNm, String rqstOfcCd, String authApstsCd, String dtlPgmUrlCtnt, String loginUsrId, String usrId, String authAproRmk) {
		this.rqstUsrId = rqstUsrId;
		this.rqstUsrNm = rqstUsrNm;
		this.subSysCd = subSysCd;
		this.authAproTpCd = authAproTpCd;
		this.edateAuth = edateAuth;
		this.ofcCdAuth = ofcCdAuth;
		this.pgmNm = pgmNm;
		this.loginUsrId = loginUsrId;
		this.authApstsCd = authApstsCd;
		this.pgmNo = pgmNo;
		this.authAproTpNm = authAproTpNm;
		this.pagerows = pagerows;
		this.sdateAuth = sdateAuth;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.rqstStDt = rqstStDt;
		this.usrOfcCd = usrOfcCd;
		this.authAproRqstNo = authAproRqstNo;
		this.usrId = usrId;
		this.subSysCdAuth = subSysCdAuth;
		this.edate = edate;
		this.rqstOfcCd = rqstOfcCd;
		this.dtlPgmUrlCtnt = dtlPgmUrlCtnt;
		this.sdate = sdate;
		this.usrOfcCdAuth = usrOfcCdAuth;
		this.crntSts = crntSts;
		this.authAproRmk = authAproRmk;
		this.xlsFlg = xlsFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("rqst_usr_nm", getRqstUsrNm());
		this.hashColumns.put("sub_sys_cd", getSubSysCd());
		this.hashColumns.put("auth_apro_tp_cd", getAuthAproTpCd());
		this.hashColumns.put("edate_auth", getEdateAuth());
		this.hashColumns.put("ofc_cd_auth", getOfcCdAuth());
		this.hashColumns.put("pgm_nm", getPgmNm());
		this.hashColumns.put("login_usr_id", getLoginUsrId());
		this.hashColumns.put("auth_apsts_cd", getAuthApstsCd());
		this.hashColumns.put("pgm_no", getPgmNo());
		this.hashColumns.put("auth_apro_tp_nm", getAuthAproTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sdate_auth", getSdateAuth());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rqst_st_dt", getRqstStDt());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("auth_apro_rqst_no", getAuthAproRqstNo());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("sub_sys_cd_auth", getSubSysCdAuth());
		this.hashColumns.put("edate", getEdate());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("dtl_pgm_url_ctnt", getDtlPgmUrlCtnt());
		this.hashColumns.put("sdate", getSdate());
		this.hashColumns.put("usr_ofc_cd_auth", getUsrOfcCdAuth());
		this.hashColumns.put("crnt_sts", getCrntSts());
		this.hashColumns.put("auth_apro_rmk", getAuthAproRmk());
		this.hashColumns.put("xls_flg", getXlsFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("rqst_usr_nm", "rqstUsrNm");
		this.hashFields.put("sub_sys_cd", "subSysCd");
		this.hashFields.put("auth_apro_tp_cd", "authAproTpCd");
		this.hashFields.put("edate_auth", "edateAuth");
		this.hashFields.put("ofc_cd_auth", "ofcCdAuth");
		this.hashFields.put("pgm_nm", "pgmNm");
		this.hashFields.put("login_usr_id", "loginUsrId");
		this.hashFields.put("auth_apsts_cd", "authApstsCd");
		this.hashFields.put("pgm_no", "pgmNo");
		this.hashFields.put("auth_apro_tp_nm", "authAproTpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sdate_auth", "sdateAuth");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rqst_st_dt", "rqstStDt");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("auth_apro_rqst_no", "authAproRqstNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("sub_sys_cd_auth", "subSysCdAuth");
		this.hashFields.put("edate", "edate");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("dtl_pgm_url_ctnt", "dtlPgmUrlCtnt");
		this.hashFields.put("sdate", "sdate");
		this.hashFields.put("usr_ofc_cd_auth", "usrOfcCdAuth");
		this.hashFields.put("crnt_sts", "crntSts");
		this.hashFields.put("auth_apro_rmk", "authAproRmk");
		this.hashFields.put("xls_flg", "xlsFlg");
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
	 * @return rqstUsrNm
	 */
	public String getRqstUsrNm() {
		return this.rqstUsrNm;
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
	 * @return authAproTpCd
	 */
	public String getAuthAproTpCd() {
		return this.authAproTpCd;
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
	 * @return loginUsrId
	 */
	public String getLoginUsrId() {
		return this.loginUsrId;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return sdateAuth
	 */
	public String getSdateAuth() {
		return this.sdateAuth;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return authAproRqstNo
	 */
	public String getAuthAproRqstNo() {
		return this.authAproRqstNo;
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
	 * @return subSysCdAuth
	 */
	public String getSubSysCdAuth() {
		return this.subSysCdAuth;
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
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
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
	 * @return sdate
	 */
	public String getSdate() {
		return this.sdate;
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
	 * @return crntSts
	 */
	public String getCrntSts() {
		return this.crntSts;
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
	 * @return xlsFlg
	 */
	public String getXlsFlg() {
		return this.xlsFlg;
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
	 * @param rqstUsrNm
	 */
	public void setRqstUsrNm(String rqstUsrNm) {
		this.rqstUsrNm = rqstUsrNm;
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
	 * @param authAproTpCd
	 */
	public void setAuthAproTpCd(String authAproTpCd) {
		this.authAproTpCd = authAproTpCd;
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
	 * @param loginUsrId
	 */
	public void setLoginUsrId(String loginUsrId) {
		this.loginUsrId = loginUsrId;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param sdateAuth
	 */
	public void setSdateAuth(String sdateAuth) {
		this.sdateAuth = sdateAuth;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param authAproRqstNo
	 */
	public void setAuthAproRqstNo(String authAproRqstNo) {
		this.authAproRqstNo = authAproRqstNo;
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
	 * @param subSysCdAuth
	 */
	public void setSubSysCdAuth(String subSysCdAuth) {
		this.subSysCdAuth = subSysCdAuth;
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
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dtlPgmUrlCtnt
	 */
	public void setDtlPgmUrlCtnt(String dtlPgmUrlCtnt) {
		this.dtlPgmUrlCtnt = dtlPgmUrlCtnt;
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
	 * @param usrOfcCdAuth
	 */
	public void setUsrOfcCdAuth(String usrOfcCdAuth) {
		this.usrOfcCdAuth = usrOfcCdAuth;
	}
	
	/**
	 * Column Info
	 * @param crntSts
	 */
	public void setCrntSts(String crntSts) {
		this.crntSts = crntSts;
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
	 * @param xlsFlg
	 */
	public void setXlsFlg(String xlsFlg) {
		this.xlsFlg = xlsFlg;
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
		setRqstUsrNm(JSPUtil.getParameter(request, prefix + "rqst_usr_nm", ""));
		setSubSysCd(JSPUtil.getParameter(request, prefix + "sub_sys_cd", ""));
		setAuthAproTpCd(JSPUtil.getParameter(request, prefix + "auth_apro_tp_cd", ""));
		setEdateAuth(JSPUtil.getParameter(request, prefix + "edate_auth", ""));
		setOfcCdAuth(JSPUtil.getParameter(request, prefix + "ofc_cd_auth", ""));
		setPgmNm(JSPUtil.getParameter(request, prefix + "pgm_nm", ""));
		setLoginUsrId(JSPUtil.getParameter(request, prefix + "login_usr_id", ""));
		setAuthApstsCd(JSPUtil.getParameter(request, prefix + "auth_apsts_cd", ""));
		setPgmNo(JSPUtil.getParameter(request, prefix + "pgm_no", ""));
		setAuthAproTpNm(JSPUtil.getParameter(request, prefix + "auth_apro_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSdateAuth(JSPUtil.getParameter(request, prefix + "sdate_auth", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRqstStDt(JSPUtil.getParameter(request, prefix + "rqst_st_dt", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, prefix + "usr_ofc_cd", ""));
		setAuthAproRqstNo(JSPUtil.getParameter(request, prefix + "auth_apro_rqst_no", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setSubSysCdAuth(JSPUtil.getParameter(request, prefix + "sub_sys_cd_auth", ""));
		setEdate(JSPUtil.getParameter(request, prefix + "edate", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setDtlPgmUrlCtnt(JSPUtil.getParameter(request, prefix + "dtl_pgm_url_ctnt", ""));
		setSdate(JSPUtil.getParameter(request, prefix + "sdate", ""));
		setUsrOfcCdAuth(JSPUtil.getParameter(request, prefix + "usr_ofc_cd_auth", ""));
		setCrntSts(JSPUtil.getParameter(request, prefix + "crnt_sts", ""));
		setCrntSts(JSPUtil.getParameter(request, prefix + "auth_apro_rmk", ""));
		setXlsFlg(JSPUtil.getParameter(request, prefix + "xls_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AuthorizationAproVO[]
	 */
	public AuthorizationAproVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AuthorizationAproVO[]
	 */
	public AuthorizationAproVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AuthorizationAproVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] rqstUsrNm = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_nm", length));
			String[] subSysCd = (JSPUtil.getParameter(request, prefix	+ "sub_sys_cd", length));
			String[] authAproTpCd = (JSPUtil.getParameter(request, prefix	+ "auth_apro_tp_cd", length));
			String[] edateAuth = (JSPUtil.getParameter(request, prefix	+ "edate_auth", length));
			String[] ofcCdAuth = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_auth", length));
			String[] pgmNm = (JSPUtil.getParameter(request, prefix	+ "pgm_nm", length));
			String[] loginUsrId = (JSPUtil.getParameter(request, prefix	+ "login_usr_id", length));
			String[] authApstsCd = (JSPUtil.getParameter(request, prefix	+ "auth_apsts_cd", length));
			String[] pgmNo = (JSPUtil.getParameter(request, prefix	+ "pgm_no", length));
			String[] authAproTpNm = (JSPUtil.getParameter(request, prefix	+ "auth_apro_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sdateAuth = (JSPUtil.getParameter(request, prefix	+ "sdate_auth", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rqstStDt = (JSPUtil.getParameter(request, prefix	+ "rqst_st_dt", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] authAproRqstNo = (JSPUtil.getParameter(request, prefix	+ "auth_apro_rqst_no", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] subSysCdAuth = (JSPUtil.getParameter(request, prefix	+ "sub_sys_cd_auth", length));
			String[] edate = (JSPUtil.getParameter(request, prefix	+ "edate", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] dtlPgmUrlCtnt = (JSPUtil.getParameter(request, prefix	+ "dtl_pgm_url_ctnt", length));
			String[] sdate = (JSPUtil.getParameter(request, prefix	+ "sdate", length));
			String[] usrOfcCdAuth = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd_auth", length));
			String[] crntSts = (JSPUtil.getParameter(request, prefix	+ "crnt_sts", length));
			String[] authAproRmk = (JSPUtil.getParameter(request, prefix	+ "auth_apro_rmk", length));
			String[] xlsFlg = (JSPUtil.getParameter(request, prefix	+ "xls_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new AuthorizationAproVO();
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (rqstUsrNm[i] != null)
					model.setRqstUsrNm(rqstUsrNm[i]);
				if (subSysCd[i] != null)
					model.setSubSysCd(subSysCd[i]);
				if (authAproTpCd[i] != null)
					model.setAuthAproTpCd(authAproTpCd[i]);
				if (edateAuth[i] != null)
					model.setEdateAuth(edateAuth[i]);
				if (ofcCdAuth[i] != null)
					model.setOfcCdAuth(ofcCdAuth[i]);
				if (pgmNm[i] != null)
					model.setPgmNm(pgmNm[i]);
				if (loginUsrId[i] != null)
					model.setLoginUsrId(loginUsrId[i]);
				if (authApstsCd[i] != null)
					model.setAuthApstsCd(authApstsCd[i]);
				if (pgmNo[i] != null)
					model.setPgmNo(pgmNo[i]);
				if (authAproTpNm[i] != null)
					model.setAuthAproTpNm(authAproTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sdateAuth[i] != null)
					model.setSdateAuth(sdateAuth[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rqstStDt[i] != null)
					model.setRqstStDt(rqstStDt[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (authAproRqstNo[i] != null)
					model.setAuthAproRqstNo(authAproRqstNo[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (subSysCdAuth[i] != null)
					model.setSubSysCdAuth(subSysCdAuth[i]);
				if (edate[i] != null)
					model.setEdate(edate[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (dtlPgmUrlCtnt[i] != null)
					model.setDtlPgmUrlCtnt(dtlPgmUrlCtnt[i]);
				if (sdate[i] != null)
					model.setSdate(sdate[i]);
				if (usrOfcCdAuth[i] != null)
					model.setUsrOfcCdAuth(usrOfcCdAuth[i]);
				if (crntSts[i] != null)
					model.setCrntSts(crntSts[i]);
				if (authAproRmk[i] != null)
					model.setAuthAproRmk(authAproRmk[i]);
				if (xlsFlg[i] != null)
					model.setXlsFlg(xlsFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAuthorizationAproVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AuthorizationAproVO[]
	 */
	public AuthorizationAproVO[] getAuthorizationAproVOs(){
		AuthorizationAproVO[] vos = (AuthorizationAproVO[])models.toArray(new AuthorizationAproVO[models.size()]);
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
		this.rqstUsrNm = this.rqstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysCd = this.subSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproTpCd = this.authAproTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edateAuth = this.edateAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCdAuth = this.ofcCdAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNm = this.pgmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginUsrId = this.loginUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authApstsCd = this.authApstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNo = this.pgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproTpNm = this.authAproTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdateAuth = this.sdateAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstStDt = this.rqstStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproRqstNo = this.authAproRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysCdAuth = this.subSysCdAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edate = this.edate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlPgmUrlCtnt = this.dtlPgmUrlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdate = this.sdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCdAuth = this.usrOfcCdAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSts = this.crntSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproRmk = this.authAproRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xlsFlg = this.xlsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
