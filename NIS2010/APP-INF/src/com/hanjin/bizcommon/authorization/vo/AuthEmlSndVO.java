/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthEmlSndVO.java
*@FileTitle : AuthEmlSndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.23  
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

public class AuthEmlSndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AuthEmlSndVO> models = new ArrayList<AuthEmlSndVO>();
	
	/* Column Info */
	private String emlRcvUsrId = null;
	/* Column Info */
	private String authEmlPurpCd = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String authAproUsrNm = null;
	/* Column Info */
	private String sndrEml = null;
	/* Column Info */
	private String emlSndNo = null;
	/* Column Info */
	private String authRjctDt = null;
	/* Column Info */
	private String emlCtnt = null;
	/* Column Info */
	private String emlSndUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String authEmlSndRsltCd = null;
	/* Column Info */
	private String rcvrEml = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String authAproRqstNo = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String authEmlSndNo = null;
	/* Column Info */
	private String authAproRqstRoutSeq = null;
	/* Column Info */
	private String emlSndRsltRmk = null;
	/* Column Info */
	private String authAproDt = null;
	/* Column Info */
	private String authAproUsrId = null;
	/* Column Info */
	private String emlSubjCtnt = null;
	/* Column Info */
	private String emlSndRsltFlg = null;
	/* Column Info */
	private String autoMnlFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AuthEmlSndVO() {}

	public AuthEmlSndVO(String ibflag, String pagerows, String authEmlSndNo, String authAproRqstNo, String authEmlPurpCd, String emlSndRsltFlg, String authEmlSndRsltCd, String autoMnlFlg, String emlSndDt, String emlSndNo, String emlSndUsrId, String sndrEml, String emlRcvUsrId, String rcvrEml, String emlSubjCtnt, String emlCtnt, String emlSndRsltRmk, String usrId, String authAproRqstRoutSeq, String authAproUsrId, String authAproUsrNm, String authAproDt, String authRjctDt) {
		this.emlRcvUsrId = emlRcvUsrId;
		this.authEmlPurpCd = authEmlPurpCd;
		this.emlSndDt = emlSndDt;
		this.authAproUsrNm = authAproUsrNm;
		this.sndrEml = sndrEml;
		this.emlSndNo = emlSndNo;
		this.authRjctDt = authRjctDt;
		this.emlCtnt = emlCtnt;
		this.emlSndUsrId = emlSndUsrId;
		this.pagerows = pagerows;
		this.authEmlSndRsltCd = authEmlSndRsltCd;
		this.rcvrEml = rcvrEml;
		this.ibflag = ibflag;
		this.authAproRqstNo = authAproRqstNo;
		this.usrId = usrId;
		this.authEmlSndNo = authEmlSndNo;
		this.authAproRqstRoutSeq = authAproRqstRoutSeq;
		this.emlSndRsltRmk = emlSndRsltRmk;
		this.authAproDt = authAproDt;
		this.authAproUsrId = authAproUsrId;
		this.emlSubjCtnt = emlSubjCtnt;
		this.emlSndRsltFlg = emlSndRsltFlg;
		this.autoMnlFlg = autoMnlFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eml_rcv_usr_id", getEmlRcvUsrId());
		this.hashColumns.put("auth_eml_purp_cd", getAuthEmlPurpCd());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("auth_apro_usr_nm", getAuthAproUsrNm());
		this.hashColumns.put("sndr_eml", getSndrEml());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("auth_rjct_dt", getAuthRjctDt());
		this.hashColumns.put("eml_ctnt", getEmlCtnt());
		this.hashColumns.put("eml_snd_usr_id", getEmlSndUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("auth_eml_snd_rslt_cd", getAuthEmlSndRsltCd());
		this.hashColumns.put("rcvr_eml", getRcvrEml());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("auth_apro_rqst_no", getAuthAproRqstNo());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("auth_eml_snd_no", getAuthEmlSndNo());
		this.hashColumns.put("auth_apro_rqst_rout_seq", getAuthAproRqstRoutSeq());
		this.hashColumns.put("eml_snd_rslt_rmk", getEmlSndRsltRmk());
		this.hashColumns.put("auth_apro_dt", getAuthAproDt());
		this.hashColumns.put("auth_apro_usr_id", getAuthAproUsrId());
		this.hashColumns.put("eml_subj_ctnt", getEmlSubjCtnt());
		this.hashColumns.put("eml_snd_rslt_flg", getEmlSndRsltFlg());
		this.hashColumns.put("auto_mnl_flg", getAutoMnlFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eml_rcv_usr_id", "emlRcvUsrId");
		this.hashFields.put("auth_eml_purp_cd", "authEmlPurpCd");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("auth_apro_usr_nm", "authAproUsrNm");
		this.hashFields.put("sndr_eml", "sndrEml");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("auth_rjct_dt", "authRjctDt");
		this.hashFields.put("eml_ctnt", "emlCtnt");
		this.hashFields.put("eml_snd_usr_id", "emlSndUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("auth_eml_snd_rslt_cd", "authEmlSndRsltCd");
		this.hashFields.put("rcvr_eml", "rcvrEml");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("auth_apro_rqst_no", "authAproRqstNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("auth_eml_snd_no", "authEmlSndNo");
		this.hashFields.put("auth_apro_rqst_rout_seq", "authAproRqstRoutSeq");
		this.hashFields.put("eml_snd_rslt_rmk", "emlSndRsltRmk");
		this.hashFields.put("auth_apro_dt", "authAproDt");
		this.hashFields.put("auth_apro_usr_id", "authAproUsrId");
		this.hashFields.put("eml_subj_ctnt", "emlSubjCtnt");
		this.hashFields.put("eml_snd_rslt_flg", "emlSndRsltFlg");
		this.hashFields.put("auto_mnl_flg", "autoMnlFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return emlRcvUsrId
	 */
	public String getEmlRcvUsrId() {
		return this.emlRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return authEmlPurpCd
	 */
	public String getAuthEmlPurpCd() {
		return this.authEmlPurpCd;
	}
	
	/**
	 * Column Info
	 * @return emlSndDt
	 */
	public String getEmlSndDt() {
		return this.emlSndDt;
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
	 * @return sndrEml
	 */
	public String getSndrEml() {
		return this.sndrEml;
	}
	
	/**
	 * Column Info
	 * @return emlSndNo
	 */
	public String getEmlSndNo() {
		return this.emlSndNo;
	}
	
	/**
	 * Column Info
	 * @return authRjctDt
	 */
	public String getAuthRjctDt() {
		return this.authRjctDt;
	}
	
	/**
	 * Column Info
	 * @return emlCtnt
	 */
	public String getEmlCtnt() {
		return this.emlCtnt;
	}
	
	/**
	 * Column Info
	 * @return emlSndUsrId
	 */
	public String getEmlSndUsrId() {
		return this.emlSndUsrId;
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
	 * @return authEmlSndRsltCd
	 */
	public String getAuthEmlSndRsltCd() {
		return this.authEmlSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @return rcvrEml
	 */
	public String getRcvrEml() {
		return this.rcvrEml;
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
	 * @return authEmlSndNo
	 */
	public String getAuthEmlSndNo() {
		return this.authEmlSndNo;
	}
	
	/**
	 * Column Info
	 * @return authAproRqstRoutSeq
	 */
	public String getAuthAproRqstRoutSeq() {
		return this.authAproRqstRoutSeq;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltRmk
	 */
	public String getEmlSndRsltRmk() {
		return this.emlSndRsltRmk;
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
	 * @return authAproUsrId
	 */
	public String getAuthAproUsrId() {
		return this.authAproUsrId;
	}
	
	/**
	 * Column Info
	 * @return emlSubjCtnt
	 */
	public String getEmlSubjCtnt() {
		return this.emlSubjCtnt;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltFlg
	 */
	public String getEmlSndRsltFlg() {
		return this.emlSndRsltFlg;
	}
	
	/**
	 * Column Info
	 * @return autoMnlFlg
	 */
	public String getAutoMnlFlg() {
		return this.autoMnlFlg;
	}
	

	/**
	 * Column Info
	 * @param emlRcvUsrId
	 */
	public void setEmlRcvUsrId(String emlRcvUsrId) {
		this.emlRcvUsrId = emlRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param authEmlPurpCd
	 */
	public void setAuthEmlPurpCd(String authEmlPurpCd) {
		this.authEmlPurpCd = authEmlPurpCd;
	}
	
	/**
	 * Column Info
	 * @param emlSndDt
	 */
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
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
	 * @param sndrEml
	 */
	public void setSndrEml(String sndrEml) {
		this.sndrEml = sndrEml;
	}
	
	/**
	 * Column Info
	 * @param emlSndNo
	 */
	public void setEmlSndNo(String emlSndNo) {
		this.emlSndNo = emlSndNo;
	}
	
	/**
	 * Column Info
	 * @param authRjctDt
	 */
	public void setAuthRjctDt(String authRjctDt) {
		this.authRjctDt = authRjctDt;
	}
	
	/**
	 * Column Info
	 * @param emlCtnt
	 */
	public void setEmlCtnt(String emlCtnt) {
		this.emlCtnt = emlCtnt;
	}
	
	/**
	 * Column Info
	 * @param emlSndUsrId
	 */
	public void setEmlSndUsrId(String emlSndUsrId) {
		this.emlSndUsrId = emlSndUsrId;
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
	 * @param authEmlSndRsltCd
	 */
	public void setAuthEmlSndRsltCd(String authEmlSndRsltCd) {
		this.authEmlSndRsltCd = authEmlSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @param rcvrEml
	 */
	public void setRcvrEml(String rcvrEml) {
		this.rcvrEml = rcvrEml;
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
	 * @param authEmlSndNo
	 */
	public void setAuthEmlSndNo(String authEmlSndNo) {
		this.authEmlSndNo = authEmlSndNo;
	}
	
	/**
	 * Column Info
	 * @param authAproRqstRoutSeq
	 */
	public void setAuthAproRqstRoutSeq(String authAproRqstRoutSeq) {
		this.authAproRqstRoutSeq = authAproRqstRoutSeq;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltRmk
	 */
	public void setEmlSndRsltRmk(String emlSndRsltRmk) {
		this.emlSndRsltRmk = emlSndRsltRmk;
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
	 * @param authAproUsrId
	 */
	public void setAuthAproUsrId(String authAproUsrId) {
		this.authAproUsrId = authAproUsrId;
	}
	
	/**
	 * Column Info
	 * @param emlSubjCtnt
	 */
	public void setEmlSubjCtnt(String emlSubjCtnt) {
		this.emlSubjCtnt = emlSubjCtnt;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltFlg
	 */
	public void setEmlSndRsltFlg(String emlSndRsltFlg) {
		this.emlSndRsltFlg = emlSndRsltFlg;
	}
	
	/**
	 * Column Info
	 * @param autoMnlFlg
	 */
	public void setAutoMnlFlg(String autoMnlFlg) {
		this.autoMnlFlg = autoMnlFlg;
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
		setEmlRcvUsrId(JSPUtil.getParameter(request, prefix + "eml_rcv_usr_id", ""));
		setAuthEmlPurpCd(JSPUtil.getParameter(request, prefix + "auth_eml_purp_cd", ""));
		setEmlSndDt(JSPUtil.getParameter(request, prefix + "eml_snd_dt", ""));
		setAuthAproUsrNm(JSPUtil.getParameter(request, prefix + "auth_apro_usr_nm", ""));
		setSndrEml(JSPUtil.getParameter(request, prefix + "sndr_eml", ""));
		setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
		setAuthRjctDt(JSPUtil.getParameter(request, prefix + "auth_rjct_dt", ""));
		setEmlCtnt(JSPUtil.getParameter(request, prefix + "eml_ctnt", ""));
		setEmlSndUsrId(JSPUtil.getParameter(request, prefix + "eml_snd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAuthEmlSndRsltCd(JSPUtil.getParameter(request, prefix + "auth_eml_snd_rslt_cd", ""));
		setRcvrEml(JSPUtil.getParameter(request, prefix + "rcvr_eml", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAuthAproRqstNo(JSPUtil.getParameter(request, prefix + "auth_apro_rqst_no", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setAuthEmlSndNo(JSPUtil.getParameter(request, prefix + "auth_eml_snd_no", ""));
		setAuthAproRqstRoutSeq(JSPUtil.getParameter(request, prefix + "auth_apro_rqst_rout_seq", ""));
		setEmlSndRsltRmk(JSPUtil.getParameter(request, prefix + "eml_snd_rslt_rmk", ""));
		setAuthAproDt(JSPUtil.getParameter(request, prefix + "auth_apro_dt", ""));
		setAuthAproUsrId(JSPUtil.getParameter(request, prefix + "auth_apro_usr_id", ""));
		setEmlSubjCtnt(JSPUtil.getParameter(request, prefix + "eml_subj_ctnt", ""));
		setEmlSndRsltFlg(JSPUtil.getParameter(request, prefix + "eml_snd_rslt_flg", ""));
		setAutoMnlFlg(JSPUtil.getParameter(request, prefix + "auto_mnl_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AuthEmlSndVO[]
	 */
	public AuthEmlSndVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AuthEmlSndVO[]
	 */
	public AuthEmlSndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AuthEmlSndVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] emlRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "eml_rcv_usr_id", length));
			String[] authEmlPurpCd = (JSPUtil.getParameter(request, prefix	+ "auth_eml_purp_cd", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] authAproUsrNm = (JSPUtil.getParameter(request, prefix	+ "auth_apro_usr_nm", length));
			String[] sndrEml = (JSPUtil.getParameter(request, prefix	+ "sndr_eml", length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no", length));
			String[] authRjctDt = (JSPUtil.getParameter(request, prefix	+ "auth_rjct_dt", length));
			String[] emlCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_ctnt", length));
			String[] emlSndUsrId = (JSPUtil.getParameter(request, prefix	+ "eml_snd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] authEmlSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "auth_eml_snd_rslt_cd", length));
			String[] rcvrEml = (JSPUtil.getParameter(request, prefix	+ "rcvr_eml", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] authAproRqstNo = (JSPUtil.getParameter(request, prefix	+ "auth_apro_rqst_no", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] authEmlSndNo = (JSPUtil.getParameter(request, prefix	+ "auth_eml_snd_no", length));
			String[] authAproRqstRoutSeq = (JSPUtil.getParameter(request, prefix	+ "auth_apro_rqst_rout_seq", length));
			String[] emlSndRsltRmk = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_rmk", length));
			String[] authAproDt = (JSPUtil.getParameter(request, prefix	+ "auth_apro_dt", length));
			String[] authAproUsrId = (JSPUtil.getParameter(request, prefix	+ "auth_apro_usr_id", length));
			String[] emlSubjCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_subj_ctnt", length));
			String[] emlSndRsltFlg = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_flg", length));
			String[] autoMnlFlg = (JSPUtil.getParameter(request, prefix	+ "auto_mnl_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new AuthEmlSndVO();
				if (emlRcvUsrId[i] != null)
					model.setEmlRcvUsrId(emlRcvUsrId[i]);
				if (authEmlPurpCd[i] != null)
					model.setAuthEmlPurpCd(authEmlPurpCd[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (authAproUsrNm[i] != null)
					model.setAuthAproUsrNm(authAproUsrNm[i]);
				if (sndrEml[i] != null)
					model.setSndrEml(sndrEml[i]);
				if (emlSndNo[i] != null)
					model.setEmlSndNo(emlSndNo[i]);
				if (authRjctDt[i] != null)
					model.setAuthRjctDt(authRjctDt[i]);
				if (emlCtnt[i] != null)
					model.setEmlCtnt(emlCtnt[i]);
				if (emlSndUsrId[i] != null)
					model.setEmlSndUsrId(emlSndUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (authEmlSndRsltCd[i] != null)
					model.setAuthEmlSndRsltCd(authEmlSndRsltCd[i]);
				if (rcvrEml[i] != null)
					model.setRcvrEml(rcvrEml[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (authAproRqstNo[i] != null)
					model.setAuthAproRqstNo(authAproRqstNo[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (authEmlSndNo[i] != null)
					model.setAuthEmlSndNo(authEmlSndNo[i]);
				if (authAproRqstRoutSeq[i] != null)
					model.setAuthAproRqstRoutSeq(authAproRqstRoutSeq[i]);
				if (emlSndRsltRmk[i] != null)
					model.setEmlSndRsltRmk(emlSndRsltRmk[i]);
				if (authAproDt[i] != null)
					model.setAuthAproDt(authAproDt[i]);
				if (authAproUsrId[i] != null)
					model.setAuthAproUsrId(authAproUsrId[i]);
				if (emlSubjCtnt[i] != null)
					model.setEmlSubjCtnt(emlSubjCtnt[i]);
				if (emlSndRsltFlg[i] != null)
					model.setEmlSndRsltFlg(emlSndRsltFlg[i]);
				if (autoMnlFlg[i] != null)
					model.setAutoMnlFlg(autoMnlFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAuthEmlSndVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AuthEmlSndVO[]
	 */
	public AuthEmlSndVO[] getAuthEmlSndVOs(){
		AuthEmlSndVO[] vos = (AuthEmlSndVO[])models.toArray(new AuthEmlSndVO[models.size()]);
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
		this.emlRcvUsrId = this.emlRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authEmlPurpCd = this.authEmlPurpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproUsrNm = this.authAproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrEml = this.sndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authRjctDt = this.authRjctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlCtnt = this.emlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndUsrId = this.emlSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authEmlSndRsltCd = this.authEmlSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrEml = this.rcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproRqstNo = this.authAproRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authEmlSndNo = this.authEmlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproRqstRoutSeq = this.authAproRqstRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltRmk = this.emlSndRsltRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproDt = this.authAproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproUsrId = this.authAproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSubjCtnt = this.emlSubjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltFlg = this.emlSndRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoMnlFlg = this.autoMnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
