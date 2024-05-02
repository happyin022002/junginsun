/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RsltPropMnMstVO.java
*@FileTitle : RsltPropMnMstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.29
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.29  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPropMnMstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPropMnMstVO> models = new ArrayList<RsltPropMnMstVO>();
	
	/* Column Info */
	private String rfaCtrtTpCd = null;
	/* Column Info */
	private String propSrepCd = null;
	/* Column Info */
	private String preExpDt = null;
	/* Column Info */
	private String reqUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String aproUsrFlg = null;
	/* Column Info */
	private String allUsrFlg = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String durDupFlg = null;
	/* Column Info */
	private String creTp = null;
	/* Column Info */
	private String propUsrNm = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String propSts = null;
	/* Column Info */
	private String propAproDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String propUsrId = null;
	/* Column Info */
	private String propStsCd = null;
	/* Column Info */
	private String fileDt = null;
	/* Column Info */
	private String propAproStaff = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Column Info */
	private String reqUsrNm = null;
	/* Column Info */
	private String propAproOfcCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String reqUsrFlg = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String copyAuth = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dmdtFtTpCd = null;
	/* Column Info */
	private String preAmdtSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltPropMnMstVO() {}

	public RsltPropMnMstVO(String ibflag, String pagerows, String rfaNo, String propNo, String amdtSeq, String preAmdtSeq, String ctrtEffDt, String ctrtExpDt, String effDt, String expDt, String preExpDt, String durDupFlg, String fileDt, String svcScpCd, String propStsCd, String propSts, String propOfcCd, String propSrepCd, String reqUsrNm, String reqUsrId, String propUsrId, String propUsrNm, String propAproOfcCd, String propAproStaff, String propAproDt, String creDt, String reqUsrFlg, String aproUsrFlg, String allUsrFlg, String copyAuth, String creTp, String updDt, String rfaCtrtTpCd, String dmdtFtTpCd) {
		this.rfaCtrtTpCd = rfaCtrtTpCd;
		this.propSrepCd = propSrepCd;
		this.preExpDt = preExpDt;
		this.reqUsrId = reqUsrId;
		this.ibflag = ibflag;
		this.expDt = expDt;
		this.aproUsrFlg = aproUsrFlg;
		this.allUsrFlg = allUsrFlg;
		this.ctrtEffDt = ctrtEffDt;
		this.svcScpCd = svcScpCd;
		this.durDupFlg = durDupFlg;
		this.creTp = creTp;
		this.propUsrNm = propUsrNm;
		this.propNo = propNo;
		this.propSts = propSts;
		this.propAproDt = propAproDt;
		this.pagerows = pagerows;
		this.propUsrId = propUsrId;
		this.propStsCd = propStsCd;
		this.fileDt = fileDt;
		this.propAproStaff = propAproStaff;
		this.ctrtExpDt = ctrtExpDt;
		this.reqUsrNm = reqUsrNm;
		this.propAproOfcCd = propAproOfcCd;
		this.effDt = effDt;
		this.creDt = creDt;
		this.reqUsrFlg = reqUsrFlg;
		this.amdtSeq = amdtSeq;
		this.copyAuth = copyAuth;
		this.rfaNo = rfaNo;
		this.propOfcCd = propOfcCd;
		this.updDt = updDt;
		this.dmdtFtTpCd = dmdtFtTpCd;
		this.preAmdtSeq = preAmdtSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rfa_ctrt_tp_cd", getRfaCtrtTpCd());
		this.hashColumns.put("prop_srep_cd", getPropSrepCd());
		this.hashColumns.put("pre_exp_dt", getPreExpDt());
		this.hashColumns.put("req_usr_id", getReqUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("apro_usr_flg", getAproUsrFlg());
		this.hashColumns.put("all_usr_flg", getAllUsrFlg());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("dur_dup_flg", getDurDupFlg());
		this.hashColumns.put("cre_tp", getCreTp());
		this.hashColumns.put("prop_usr_nm", getPropUsrNm());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("prop_sts", getPropSts());
		this.hashColumns.put("prop_apro_dt", getPropAproDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prop_usr_id", getPropUsrId());
		this.hashColumns.put("prop_sts_cd", getPropStsCd());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("prop_apro_staff", getPropAproStaff());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("req_usr_nm", getReqUsrNm());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("req_usr_flg", getReqUsrFlg());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("copy_auth", getCopyAuth());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dmdt_ft_tp_cd", getDmdtFtTpCd());
		this.hashColumns.put("pre_amdt_seq", getPreAmdtSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rfa_ctrt_tp_cd", "rfaCtrtTpCd");
		this.hashFields.put("prop_srep_cd", "propSrepCd");
		this.hashFields.put("pre_exp_dt", "preExpDt");
		this.hashFields.put("req_usr_id", "reqUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("apro_usr_flg", "aproUsrFlg");
		this.hashFields.put("all_usr_flg", "allUsrFlg");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("dur_dup_flg", "durDupFlg");
		this.hashFields.put("cre_tp", "creTp");
		this.hashFields.put("prop_usr_nm", "propUsrNm");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("prop_sts", "propSts");
		this.hashFields.put("prop_apro_dt", "propAproDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prop_usr_id", "propUsrId");
		this.hashFields.put("prop_sts_cd", "propStsCd");
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("prop_apro_staff", "propAproStaff");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("req_usr_nm", "reqUsrNm");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("req_usr_flg", "reqUsrFlg");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("copy_auth", "copyAuth");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dmdt_ft_tp_cd", "dmdtFtTpCd");
		this.hashFields.put("pre_amdt_seq", "preAmdtSeq");
		return this.hashFields;
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
	 * @return propSrepCd
	 */
	public String getPropSrepCd() {
		return this.propSrepCd;
	}
	
	/**
	 * Column Info
	 * @return preExpDt
	 */
	public String getPreExpDt() {
		return this.preExpDt;
	}
	
	/**
	 * Column Info
	 * @return reqUsrId
	 */
	public String getReqUsrId() {
		return this.reqUsrId;
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
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return aproUsrFlg
	 */
	public String getAproUsrFlg() {
		return this.aproUsrFlg;
	}
	
	/**
	 * Column Info
	 * @return allUsrFlg
	 */
	public String getAllUsrFlg() {
		return this.allUsrFlg;
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
	 * @return durDupFlg
	 */
	public String getDurDupFlg() {
		return this.durDupFlg;
	}
	
	/**
	 * Column Info
	 * @return creTp
	 */
	public String getCreTp() {
		return this.creTp;
	}
	
	/**
	 * Column Info
	 * @return propUsrNm
	 */
	public String getPropUsrNm() {
		return this.propUsrNm;
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
	 * @return propSts
	 */
	public String getPropSts() {
		return this.propSts;
	}
	
	/**
	 * Column Info
	 * @return propAproDt
	 */
	public String getPropAproDt() {
		return this.propAproDt;
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
	 * @return propUsrId
	 */
	public String getPropUsrId() {
		return this.propUsrId;
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
	 * @return fileDt
	 */
	public String getFileDt() {
		return this.fileDt;
	}
	
	/**
	 * Column Info
	 * @return propAproStaff
	 */
	public String getPropAproStaff() {
		return this.propAproStaff;
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
	 * @return reqUsrNm
	 */
	public String getReqUsrNm() {
		return this.reqUsrNm;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return reqUsrFlg
	 */
	public String getReqUsrFlg() {
		return this.reqUsrFlg;
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
	 * @return copyAuth
	 */
	public String getCopyAuth() {
		return this.copyAuth;
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
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return dmdtFtTpCd
	 */
	public String getDmdtFtTpCd() {
		return this.dmdtFtTpCd;
	}
	
	/**
	 * Column Info
	 * @return preAmdtSeq
	 */
	public String getPreAmdtSeq() {
		return this.preAmdtSeq;
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
	 * @param propSrepCd
	 */
	public void setPropSrepCd(String propSrepCd) {
		this.propSrepCd = propSrepCd;
	}
	
	/**
	 * Column Info
	 * @param preExpDt
	 */
	public void setPreExpDt(String preExpDt) {
		this.preExpDt = preExpDt;
	}
	
	/**
	 * Column Info
	 * @param reqUsrId
	 */
	public void setReqUsrId(String reqUsrId) {
		this.reqUsrId = reqUsrId;
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
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param aproUsrFlg
	 */
	public void setAproUsrFlg(String aproUsrFlg) {
		this.aproUsrFlg = aproUsrFlg;
	}
	
	/**
	 * Column Info
	 * @param allUsrFlg
	 */
	public void setAllUsrFlg(String allUsrFlg) {
		this.allUsrFlg = allUsrFlg;
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
	 * @param durDupFlg
	 */
	public void setDurDupFlg(String durDupFlg) {
		this.durDupFlg = durDupFlg;
	}
	
	/**
	 * Column Info
	 * @param creTp
	 */
	public void setCreTp(String creTp) {
		this.creTp = creTp;
	}
	
	/**
	 * Column Info
	 * @param propUsrNm
	 */
	public void setPropUsrNm(String propUsrNm) {
		this.propUsrNm = propUsrNm;
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
	 * @param propSts
	 */
	public void setPropSts(String propSts) {
		this.propSts = propSts;
	}
	
	/**
	 * Column Info
	 * @param propAproDt
	 */
	public void setPropAproDt(String propAproDt) {
		this.propAproDt = propAproDt;
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
	 * @param propUsrId
	 */
	public void setPropUsrId(String propUsrId) {
		this.propUsrId = propUsrId;
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
	 * @param fileDt
	 */
	public void setFileDt(String fileDt) {
		this.fileDt = fileDt;
	}
	
	/**
	 * Column Info
	 * @param propAproStaff
	 */
	public void setPropAproStaff(String propAproStaff) {
		this.propAproStaff = propAproStaff;
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
	 * @param reqUsrNm
	 */
	public void setReqUsrNm(String reqUsrNm) {
		this.reqUsrNm = reqUsrNm;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param reqUsrFlg
	 */
	public void setReqUsrFlg(String reqUsrFlg) {
		this.reqUsrFlg = reqUsrFlg;
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
	 * @param copyAuth
	 */
	public void setCopyAuth(String copyAuth) {
		this.copyAuth = copyAuth;
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
	 * @param propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param dmdtFtTpCd
	 */
	public void setDmdtFtTpCd(String dmdtFtTpCd) {
		this.dmdtFtTpCd = dmdtFtTpCd;
	}
	
	/**
	 * Column Info
	 * @param preAmdtSeq
	 */
	public void setPreAmdtSeq(String preAmdtSeq) {
		this.preAmdtSeq = preAmdtSeq;
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
		setRfaCtrtTpCd(JSPUtil.getParameter(request, prefix + "rfa_ctrt_tp_cd", ""));
		setPropSrepCd(JSPUtil.getParameter(request, prefix + "prop_srep_cd", ""));
		setPreExpDt(JSPUtil.getParameter(request, prefix + "pre_exp_dt", ""));
		setReqUsrId(JSPUtil.getParameter(request, prefix + "req_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setAproUsrFlg(JSPUtil.getParameter(request, prefix + "apro_usr_flg", ""));
		setAllUsrFlg(JSPUtil.getParameter(request, prefix + "all_usr_flg", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setDurDupFlg(JSPUtil.getParameter(request, prefix + "dur_dup_flg", ""));
		setCreTp(JSPUtil.getParameter(request, prefix + "cre_tp", ""));
		setPropUsrNm(JSPUtil.getParameter(request, prefix + "prop_usr_nm", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setPropSts(JSPUtil.getParameter(request, prefix + "prop_sts", ""));
		setPropAproDt(JSPUtil.getParameter(request, prefix + "prop_apro_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPropUsrId(JSPUtil.getParameter(request, prefix + "prop_usr_id", ""));
		setPropStsCd(JSPUtil.getParameter(request, prefix + "prop_sts_cd", ""));
		setFileDt(JSPUtil.getParameter(request, prefix + "file_dt", ""));
		setPropAproStaff(JSPUtil.getParameter(request, prefix + "prop_apro_staff", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", ""));
		setReqUsrNm(JSPUtil.getParameter(request, prefix + "req_usr_nm", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, prefix + "prop_apro_ofc_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setReqUsrFlg(JSPUtil.getParameter(request, prefix + "req_usr_flg", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setCopyAuth(JSPUtil.getParameter(request, prefix + "copy_auth", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setPropOfcCd(JSPUtil.getParameter(request, prefix + "prop_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDmdtFtTpCd(JSPUtil.getParameter(request, prefix + "dmdt_ft_tp_cd", ""));
		setPreAmdtSeq(JSPUtil.getParameter(request, prefix + "pre_amdt_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPropMnMstVO[]
	 */
	public RsltPropMnMstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPropMnMstVO[]
	 */
	public RsltPropMnMstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPropMnMstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rfaCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "rfa_ctrt_tp_cd", length));
			String[] propSrepCd = (JSPUtil.getParameter(request, prefix	+ "prop_srep_cd", length));
			String[] preExpDt = (JSPUtil.getParameter(request, prefix	+ "pre_exp_dt", length));
			String[] reqUsrId = (JSPUtil.getParameter(request, prefix	+ "req_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] aproUsrFlg = (JSPUtil.getParameter(request, prefix	+ "apro_usr_flg", length));
			String[] allUsrFlg = (JSPUtil.getParameter(request, prefix	+ "all_usr_flg", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] durDupFlg = (JSPUtil.getParameter(request, prefix	+ "dur_dup_flg", length));
			String[] creTp = (JSPUtil.getParameter(request, prefix	+ "cre_tp", length));
			String[] propUsrNm = (JSPUtil.getParameter(request, prefix	+ "prop_usr_nm", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] propSts = (JSPUtil.getParameter(request, prefix	+ "prop_sts", length));
			String[] propAproDt = (JSPUtil.getParameter(request, prefix	+ "prop_apro_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] propUsrId = (JSPUtil.getParameter(request, prefix	+ "prop_usr_id", length));
			String[] propStsCd = (JSPUtil.getParameter(request, prefix	+ "prop_sts_cd", length));
			String[] fileDt = (JSPUtil.getParameter(request, prefix	+ "file_dt", length));
			String[] propAproStaff = (JSPUtil.getParameter(request, prefix	+ "prop_apro_staff", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] reqUsrNm = (JSPUtil.getParameter(request, prefix	+ "req_usr_nm", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_ofc_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] reqUsrFlg = (JSPUtil.getParameter(request, prefix	+ "req_usr_flg", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] copyAuth = (JSPUtil.getParameter(request, prefix	+ "copy_auth", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dmdtFtTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ft_tp_cd", length));
			String[] preAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "pre_amdt_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPropMnMstVO();
				if (rfaCtrtTpCd[i] != null)
					model.setRfaCtrtTpCd(rfaCtrtTpCd[i]);
				if (propSrepCd[i] != null)
					model.setPropSrepCd(propSrepCd[i]);
				if (preExpDt[i] != null)
					model.setPreExpDt(preExpDt[i]);
				if (reqUsrId[i] != null)
					model.setReqUsrId(reqUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (aproUsrFlg[i] != null)
					model.setAproUsrFlg(aproUsrFlg[i]);
				if (allUsrFlg[i] != null)
					model.setAllUsrFlg(allUsrFlg[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (durDupFlg[i] != null)
					model.setDurDupFlg(durDupFlg[i]);
				if (creTp[i] != null)
					model.setCreTp(creTp[i]);
				if (propUsrNm[i] != null)
					model.setPropUsrNm(propUsrNm[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (propSts[i] != null)
					model.setPropSts(propSts[i]);
				if (propAproDt[i] != null)
					model.setPropAproDt(propAproDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (propUsrId[i] != null)
					model.setPropUsrId(propUsrId[i]);
				if (propStsCd[i] != null)
					model.setPropStsCd(propStsCd[i]);
				if (fileDt[i] != null)
					model.setFileDt(fileDt[i]);
				if (propAproStaff[i] != null)
					model.setPropAproStaff(propAproStaff[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (reqUsrNm[i] != null)
					model.setReqUsrNm(reqUsrNm[i]);
				if (propAproOfcCd[i] != null)
					model.setPropAproOfcCd(propAproOfcCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (reqUsrFlg[i] != null)
					model.setReqUsrFlg(reqUsrFlg[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (copyAuth[i] != null)
					model.setCopyAuth(copyAuth[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dmdtFtTpCd[i] != null)
					model.setDmdtFtTpCd(dmdtFtTpCd[i]);
				if (preAmdtSeq[i] != null)
					model.setPreAmdtSeq(preAmdtSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPropMnMstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPropMnMstVO[]
	 */
	public RsltPropMnMstVO[] getRsltPropMnMstVOs(){
		RsltPropMnMstVO[] vos = (RsltPropMnMstVO[])models.toArray(new RsltPropMnMstVO[models.size()]);
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
		this.rfaCtrtTpCd = this.rfaCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSrepCd = this.propSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preExpDt = this.preExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqUsrId = this.reqUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrFlg = this.aproUsrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allUsrFlg = this.allUsrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durDupFlg = this.durDupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creTp = this.creTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propUsrNm = this.propUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSts = this.propSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproDt = this.propAproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propUsrId = this.propUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsCd = this.propStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt = this.fileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproStaff = this.propAproStaff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqUsrNm = this.reqUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqUsrFlg = this.reqUsrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copyAuth = this.copyAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtFtTpCd = this.dmdtFtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preAmdtSeq = this.preAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
