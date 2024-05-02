/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GRWEmailNoticeBasicCmdtVO.java
*@FileTitle : GRWEmailNoticeBasicCmdtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo;

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

public class GRWEmailNoticeBasicCmdtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GRWEmailNoticeBasicCmdtVO> models = new ArrayList<GRWEmailNoticeBasicCmdtVO>();
	
	/* Column Info */
	private String textcontent = null;
	/* Column Info */
	private String orgDest = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String subject = null;
	/* Column Info */
	private String trfMngUsrEml = null;
	/* Column Info */
	private String expDtEng = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String recipient = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sender = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String verNo = null;
	/* Column Info */
	private String dmdtBzcTrfGrpNm = null;
	/* Column Info */
	private String cmdt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String picTeamEml = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String expDt7Eng = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String darNo = null;
	/* Column Info */
	private String apvlNo = null;
	/* Column Info */
	private String htmltemplate = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String dmdtDeTermNm = null;
	/* Column Info */
	private String comments = null;
	/* Column Info */
	private String covrg = null;
	/* Column Info */
	private String tpCd = null;
	/* Column Info */
	private String trfMngUsrId = null;
	/* Column Info */
	private String dmdtCntrTpNm = null;
	/* Column Info */
	private String dmdtCgoTpNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public GRWEmailNoticeBasicCmdtVO() {}

	public GRWEmailNoticeBasicCmdtVO(String ibflag, String pagerows, String sender, String subject, String recipient, String textcontent, String htmltemplate, String darNo, String verNo, String apvlNo, String status, String scNo, String rfaNo, String propNo, String blNo, String custCd, String custNm, String comments, String covrg, String dmdtTrfCd, String orgDest, String dmdtBzcTrfGrpNm, String dmdtDeTermNm, String effDt, String expDt, String picTeamEml, String trfMngUsrEml, String expDt7Eng, String expDtEng, String cmdt, String tpCd, String trfMngUsrId, String dmdtCntrTpNm, String dmdtCgoTpNm) {
		this.textcontent = textcontent;
		this.orgDest = orgDest;
		this.custNm = custNm;
		this.subject = subject;
		this.trfMngUsrEml = trfMngUsrEml;
		this.expDtEng = expDtEng;
		this.blNo = blNo;
		this.recipient = recipient;
		this.pagerows = pagerows;
		this.sender = sender;
		this.rfaNo = rfaNo;
		this.verNo = verNo;
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
		this.cmdt = cmdt;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.picTeamEml = picTeamEml;
		this.scNo = scNo;
		this.expDt = expDt;
		this.expDt7Eng = expDt7Eng;
		this.dmdtTrfCd = dmdtTrfCd;
		this.status = status;
		this.darNo = darNo;
		this.apvlNo = apvlNo;
		this.htmltemplate = htmltemplate;
		this.propNo = propNo;
		this.custCd = custCd;
		this.dmdtDeTermNm = dmdtDeTermNm;
		this.comments = comments;
		this.covrg = covrg;
		this.tpCd = tpCd;
		this.trfMngUsrId = trfMngUsrId;
		this.dmdtCntrTpNm = dmdtCntrTpNm;
		this.dmdtCgoTpNm = dmdtCgoTpNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("textcontent", getTextcontent());
		this.hashColumns.put("org_dest", getOrgDest());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("trf_mng_usr_eml", getTrfMngUsrEml());
		this.hashColumns.put("exp_dt_eng", getExpDtEng());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("recipient", getRecipient());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sender", getSender());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ver_no", getVerNo());
		this.hashColumns.put("dmdt_bzc_trf_grp_nm", getDmdtBzcTrfGrpNm());
		this.hashColumns.put("cmdt", getCmdt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("pic_team_eml", getPicTeamEml());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("exp_dt_7_eng", getExpDt7Eng());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("dar_no", getDarNo());
		this.hashColumns.put("apvl_no", getApvlNo());
		this.hashColumns.put("htmltemplate", getHtmltemplate());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("dmdt_de_term_nm", getDmdtDeTermNm());
		this.hashColumns.put("comments", getComments());
		this.hashColumns.put("covrg", getCovrg());
		this.hashColumns.put("tp_cd", getTpCd());
		this.hashColumns.put("trf_mng_usr_id", getTrfMngUsrId());
		this.hashColumns.put("dmdt_cntr_tp_nm", getDmdtCntrTpNm());
		this.hashColumns.put("dmdt_cgo_tp_nm", getDmdtCgoTpNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("textcontent", "textcontent");
		this.hashFields.put("org_dest", "orgDest");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("subject", "subject");
		this.hashFields.put("trf_mng_usr_eml", "trfMngUsrEml");
		this.hashFields.put("exp_dt_eng", "expDtEng");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("recipient", "recipient");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sender", "sender");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ver_no", "verNo");
		this.hashFields.put("dmdt_bzc_trf_grp_nm", "dmdtBzcTrfGrpNm");
		this.hashFields.put("cmdt", "cmdt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("pic_team_eml", "picTeamEml");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("exp_dt_7_eng", "expDt7Eng");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("status", "status");
		this.hashFields.put("dar_no", "darNo");
		this.hashFields.put("apvl_no", "apvlNo");
		this.hashFields.put("htmltemplate", "htmltemplate");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("dmdt_de_term_nm", "dmdtDeTermNm");
		this.hashFields.put("comments", "comments");
		this.hashFields.put("covrg", "covrg");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("trf_mng_usr_id", "trfMngUsrId");
		this.hashFields.put("dmdt_cntr_tp_nm", "dmdtCntrTpNm");
		this.hashFields.put("dmdt_cgo_tp_nm", "dmdtCgoTpNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return textcontent
	 */
	public String getTextcontent() {
		return this.textcontent;
	}
	
	/**
	 * Column Info
	 * @return orgDest
	 */
	public String getOrgDest() {
		return this.orgDest;
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
	 * @return subject
	 */
	public String getSubject() {
		return this.subject;
	}
	
	/**
	 * Column Info
	 * @return trfMngUsrEml
	 */
	public String getTrfMngUsrEml() {
		return this.trfMngUsrEml;
	}
	
	/**
	 * Column Info
	 * @return expDtEng
	 */
	public String getExpDtEng() {
		return this.expDtEng;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return recipient
	 */
	public String getRecipient() {
		return this.recipient;
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
	 * @return sender
	 */
	public String getSender() {
		return this.sender;
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
	 * @return verNo
	 */
	public String getVerNo() {
		return this.verNo;
	}
	
	/**
	 * Column Info
	 * @return dmdtBzcTrfGrpNm
	 */
	public String getDmdtBzcTrfGrpNm() {
		return this.dmdtBzcTrfGrpNm;
	}
	
	/**
	 * Column Info
	 * @return cmdt
	 */
	public String getCmdt() {
		return this.cmdt;
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
	 * @return picTeamEml
	 */
	public String getPicTeamEml() {
		return this.picTeamEml;
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
	 * @return expDt7Eng
	 */
	public String getExpDt7Eng() {
		return this.expDt7Eng;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return darNo
	 */
	public String getDarNo() {
		return this.darNo;
	}
	
	/**
	 * Column Info
	 * @return apvlNo
	 */
	public String getApvlNo() {
		return this.apvlNo;
	}
	
	/**
	 * Column Info
	 * @return htmltemplate
	 */
	public String getHtmltemplate() {
		return this.htmltemplate;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeTermNm
	 */
	public String getDmdtDeTermNm() {
		return this.dmdtDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return comments
	 */
	public String getComments() {
		return this.comments;
	}
	
	/**
	 * Column Info
	 * @return covrg
	 */
	public String getCovrg() {
		return this.covrg;
	}
	

	/**
	 * Column Info
	 * @param textcontent
	 */
	public void setTextcontent(String textcontent) {
		this.textcontent = textcontent;
	}
	
	/**
	 * Column Info
	 * @param orgDest
	 */
	public void setOrgDest(String orgDest) {
		this.orgDest = orgDest;
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
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * Column Info
	 * @param trfMngUsrEml
	 */
	public void setTrfMngUsrEml(String trfMngUsrEml) {
		this.trfMngUsrEml = trfMngUsrEml;
	}
	
	/**
	 * Column Info
	 * @param expDtEng
	 */
	public void setExpDtEng(String expDtEng) {
		this.expDtEng = expDtEng;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param recipient
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
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
	 * @param sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
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
	 * @param verNo
	 */
	public void setVerNo(String verNo) {
		this.verNo = verNo;
	}
	
	/**
	 * Column Info
	 * @param dmdtBzcTrfGrpNm
	 */
	public void setDmdtBzcTrfGrpNm(String dmdtBzcTrfGrpNm) {
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
	}
	
	/**
	 * Column Info
	 * @param cmdt
	 */
	public void setCmdt(String cmdt) {
		this.cmdt = cmdt;
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
	 * @param picTeamEml
	 */
	public void setPicTeamEml(String picTeamEml) {
		this.picTeamEml = picTeamEml;
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
	 * @param expDt7Eng
	 */
	public void setExpDt7Eng(String expDt7Eng) {
		this.expDt7Eng = expDt7Eng;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param darNo
	 */
	public void setDarNo(String darNo) {
		this.darNo = darNo;
	}
	
	/**
	 * Column Info
	 * @param apvlNo
	 */
	public void setApvlNo(String apvlNo) {
		this.apvlNo = apvlNo;
	}
	
	/**
	 * Column Info
	 * @param htmltemplate
	 */
	public void setHtmltemplate(String htmltemplate) {
		this.htmltemplate = htmltemplate;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtDeTermNm
	 */
	public void setDmdtDeTermNm(String dmdtDeTermNm) {
		this.dmdtDeTermNm = dmdtDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param comments
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	/**
	 * Column Info
	 * @param covrg
	 */
	public void setCovrg(String covrg) {
		this.covrg = covrg;
	}
	
	public String getTpCd() {
		return tpCd;
	}

	public void setTpCd(String tpCd) {
		this.tpCd = tpCd;
	}

	public String getTrfMngUsrId() {
		return trfMngUsrId;
	}

	public void setTrfMngUsrId(String trfMngUsrId) {
		this.trfMngUsrId = trfMngUsrId;
	}

	public String getDmdtCntrTpNm() {
		return dmdtCntrTpNm;
	}

	public void setDmdtCntrTpNm(String dmdtCntrTpNm) {
		this.dmdtCntrTpNm = dmdtCntrTpNm;
	}

	public String getDmdtCgoTpNm() {
		return dmdtCgoTpNm;
	}

	public void setDmdtCgoTpNm(String dmdtCgoTpNm) {
		this.dmdtCgoTpNm = dmdtCgoTpNm;
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
		setTextcontent(JSPUtil.getParameter(request, prefix + "textcontent", ""));
		setOrgDest(JSPUtil.getParameter(request, prefix + "org_dest", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setSubject(JSPUtil.getParameter(request, prefix + "subject", ""));
		setTrfMngUsrEml(JSPUtil.getParameter(request, prefix + "trf_mng_usr_eml", ""));
		setExpDtEng(JSPUtil.getParameter(request, prefix + "exp_dt_eng", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setRecipient(JSPUtil.getParameter(request, prefix + "recipient", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSender(JSPUtil.getParameter(request, prefix + "sender", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setVerNo(JSPUtil.getParameter(request, prefix + "ver_no", ""));
		setDmdtBzcTrfGrpNm(JSPUtil.getParameter(request, prefix + "dmdt_bzc_trf_grp_nm", ""));
		setCmdt(JSPUtil.getParameter(request, prefix + "cmdt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setPicTeamEml(JSPUtil.getParameter(request, prefix + "pic_team_eml", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setExpDt7Eng(JSPUtil.getParameter(request, prefix + "exp_dt_7_eng", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setDarNo(JSPUtil.getParameter(request, prefix + "dar_no", ""));
		setApvlNo(JSPUtil.getParameter(request, prefix + "apvl_no", ""));
		setHtmltemplate(JSPUtil.getParameter(request, prefix + "htmltemplate", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setDmdtDeTermNm(JSPUtil.getParameter(request, prefix + "dmdt_de_term_nm", ""));
		setComments(JSPUtil.getParameter(request, prefix + "comments", ""));
		setCovrg(JSPUtil.getParameter(request, prefix + "covrg", ""));
		
		setTpCd(JSPUtil.getParameter(request, prefix + "tp_cd", ""));
		setTrfMngUsrId(JSPUtil.getParameter(request, prefix + "trf_mng_usr_id", ""));
		setDmdtCntrTpNm(JSPUtil.getParameter(request, prefix + "dmdt_cntr_tp_nm", ""));
		setDmdtCgoTpNm(JSPUtil.getParameter(request, prefix + "dmdt_cgo_tp_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GRWEmailNoticeBasicCmdtVO[]
	 */
	public GRWEmailNoticeBasicCmdtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GRWEmailNoticeBasicCmdtVO[]
	 */
	public GRWEmailNoticeBasicCmdtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GRWEmailNoticeBasicCmdtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] textcontent = (JSPUtil.getParameter(request, prefix	+ "textcontent", length));
			String[] orgDest = (JSPUtil.getParameter(request, prefix	+ "org_dest", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] subject = (JSPUtil.getParameter(request, prefix	+ "subject", length));
			String[] trfMngUsrEml = (JSPUtil.getParameter(request, prefix	+ "trf_mng_usr_eml", length));
			String[] expDtEng = (JSPUtil.getParameter(request, prefix	+ "exp_dt_eng", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] recipient = (JSPUtil.getParameter(request, prefix	+ "recipient", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sender = (JSPUtil.getParameter(request, prefix	+ "sender", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] verNo = (JSPUtil.getParameter(request, prefix	+ "ver_no", length));
			String[] dmdtBzcTrfGrpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_bzc_trf_grp_nm", length));
			String[] cmdt = (JSPUtil.getParameter(request, prefix	+ "cmdt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] picTeamEml = (JSPUtil.getParameter(request, prefix	+ "pic_team_eml", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] expDt7Eng = (JSPUtil.getParameter(request, prefix	+ "exp_dt_7_eng", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] darNo = (JSPUtil.getParameter(request, prefix	+ "dar_no", length));
			String[] apvlNo = (JSPUtil.getParameter(request, prefix	+ "apvl_no", length));
			String[] htmltemplate = (JSPUtil.getParameter(request, prefix	+ "htmltemplate", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] dmdtDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_nm", length));
			String[] comments = (JSPUtil.getParameter(request, prefix	+ "comments", length));
			String[] covrg = (JSPUtil.getParameter(request, prefix	+ "covrg", length));
			String[] tpCd = (JSPUtil.getParameter(request, prefix	+ "tp_cd", length));
			String[] trfMngUsrId = (JSPUtil.getParameter(request, prefix	+ "trf_mng_usr_id", length));
			String[] dmdtCntrTpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_nm", length));
			String[] dmdtCgoTpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new GRWEmailNoticeBasicCmdtVO();
				if (textcontent[i] != null)
					model.setTextcontent(textcontent[i]);
				if (orgDest[i] != null)
					model.setOrgDest(orgDest[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (subject[i] != null)
					model.setSubject(subject[i]);
				if (trfMngUsrEml[i] != null)
					model.setTrfMngUsrEml(trfMngUsrEml[i]);
				if (expDtEng[i] != null)
					model.setExpDtEng(expDtEng[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (recipient[i] != null)
					model.setRecipient(recipient[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sender[i] != null)
					model.setSender(sender[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (verNo[i] != null)
					model.setVerNo(verNo[i]);
				if (dmdtBzcTrfGrpNm[i] != null)
					model.setDmdtBzcTrfGrpNm(dmdtBzcTrfGrpNm[i]);
				if (cmdt[i] != null)
					model.setCmdt(cmdt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (picTeamEml[i] != null)
					model.setPicTeamEml(picTeamEml[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (expDt7Eng[i] != null)
					model.setExpDt7Eng(expDt7Eng[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (darNo[i] != null)
					model.setDarNo(darNo[i]);
				if (apvlNo[i] != null)
					model.setApvlNo(apvlNo[i]);
				if (htmltemplate[i] != null)
					model.setHtmltemplate(htmltemplate[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (dmdtDeTermNm[i] != null)
					model.setDmdtDeTermNm(dmdtDeTermNm[i]);
				if (comments[i] != null)
					model.setComments(comments[i]);
				if (covrg[i] != null)
					model.setCovrg(covrg[i]);
				if (tpCd[i] != null)
					model.setTpCd(tpCd[i]);
				if (trfMngUsrId[i] != null)
					model.setTrfMngUsrId(trfMngUsrId[i]);
				if (dmdtCntrTpNm[i] != null)
					model.setDmdtCntrTpNm(dmdtCntrTpNm[i]);
				if (dmdtCgoTpNm[i] != null)
					model.setDmdtCgoTpNm(dmdtCgoTpNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGRWEmailNoticeBasicCmdtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GRWEmailNoticeBasicCmdtVO[]
	 */
	public GRWEmailNoticeBasicCmdtVO[] getGRWEmailNoticeBasicCmdtVOs(){
		GRWEmailNoticeBasicCmdtVO[] vos = (GRWEmailNoticeBasicCmdtVO[])models.toArray(new GRWEmailNoticeBasicCmdtVO[models.size()]);
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
		this.textcontent = this.textcontent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDest = this.orgDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfMngUsrEml = this.trfMngUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDtEng = this.expDtEng .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recipient = this.recipient .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sender = this.sender .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verNo = this.verNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBzcTrfGrpNm = this.dmdtBzcTrfGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdt = this.cmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picTeamEml = this.picTeamEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt7Eng = this.expDt7Eng .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.darNo = this.darNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlNo = this.apvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htmltemplate = this.htmltemplate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermNm = this.dmdtDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comments = this.comments .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.covrg = this.covrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd = this.tpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfMngUsrId = this.trfMngUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpNm = this.dmdtCntrTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpNm = this.dmdtCgoTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
