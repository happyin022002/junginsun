/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AfterProgressVO.java
*@FileTitle : AfterProgressVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.24  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AfterProgressVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterProgressVO> models = new ArrayList<AfterProgressVO>();
	
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String progUsrId = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String dmdtExptRqstStsDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmdtExptRqstStsCd = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String progDt = null;
	/* Column Info */
	private String progOfcCd = null;
	/* Column Info */
	private String popupFlag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String progRmk = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String msgDt = null;
	/* Column Info */
	private String progSeq = null;
	/* Column Info */
	private String aftBkgAproNo = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String backendJobFlag = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String jobKey = null;
	/* Column Info */
	private String rqstOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AfterProgressVO() {}

	public AfterProgressVO(String ibflag, String pagerows, String aftExptDarNo, String dmdtExptRqstStsCd, String dmdtExptRqstStsDesc, String rqstUsrId, String rqstOfcCd, String rqstDt, String aftBkgAproNo, String aproUsrId, String aproDt, String aproOfcCd, String rhqOfcCd, String scNo, String rfaNo, String blNo, String custCd, String custNm, String msgDt, String progSeq, String progRmk, String progDt, String progUsrId, String progOfcCd, String jobKey, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String backendJobFlag, String popupFlag) {
		this.rqstUsrId = rqstUsrId;
		this.progUsrId = progUsrId;
		this.custNm = custNm;
		this.creDt = creDt;
		this.aproOfcCd = aproOfcCd;
		this.blNo = blNo;
		this.dmdtExptRqstStsDesc = dmdtExptRqstStsDesc;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.dmdtExptRqstStsCd = dmdtExptRqstStsCd;
		this.aftExptDarNo = aftExptDarNo;
		this.progDt = progDt;
		this.progOfcCd = progOfcCd;
		this.popupFlag = popupFlag;
		this.creOfcCd = creOfcCd;
		this.scNo = scNo;
		this.progRmk = progRmk;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.rqstDt = rqstDt;
		this.msgDt = msgDt;
		this.progSeq = progSeq;
		this.aftBkgAproNo = aftBkgAproNo;
		this.aproDt = aproDt;
		this.backendJobFlag = backendJobFlag;
		this.rhqOfcCd = rhqOfcCd;
		this.creUsrId = creUsrId;
		this.aproUsrId = aproUsrId;
		this.custCd = custCd;
		this.jobKey = jobKey;
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("prog_usr_id", getProgUsrId());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("dmdt_expt_rqst_sts_desc", getDmdtExptRqstStsDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_expt_rqst_sts_cd", getDmdtExptRqstStsCd());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("prog_dt", getProgDt());
		this.hashColumns.put("prog_ofc_cd", getProgOfcCd());
		this.hashColumns.put("popup_flag", getPopupFlag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("prog_rmk", getProgRmk());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("msg_dt", getMsgDt());
		this.hashColumns.put("prog_seq", getProgSeq());
		this.hashColumns.put("aft_bkg_apro_no", getAftBkgAproNo());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("backend_job_flag", getBackendJobFlag());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("job_key", getJobKey());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("prog_usr_id", "progUsrId");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("dmdt_expt_rqst_sts_desc", "dmdtExptRqstStsDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_expt_rqst_sts_cd", "dmdtExptRqstStsCd");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("prog_dt", "progDt");
		this.hashFields.put("prog_ofc_cd", "progOfcCd");
		this.hashFields.put("popup_flag", "popupFlag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("prog_rmk", "progRmk");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("msg_dt", "msgDt");
		this.hashFields.put("prog_seq", "progSeq");
		this.hashFields.put("aft_bkg_apro_no", "aftBkgAproNo");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("backend_job_flag", "backendJobFlag");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("job_key", "jobKey");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
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
	 * @return progUsrId
	 */
	public String getProgUsrId() {
		return this.progUsrId;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
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
	 * @return dmdtExptRqstStsDesc
	 */
	public String getDmdtExptRqstStsDesc() {
		return this.dmdtExptRqstStsDesc;
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
	 * @return dmdtExptRqstStsCd
	 */
	public String getDmdtExptRqstStsCd() {
		return this.dmdtExptRqstStsCd;
	}
	
	/**
	 * Column Info
	 * @return aftExptDarNo
	 */
	public String getAftExptDarNo() {
		return this.aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return progDt
	 */
	public String getProgDt() {
		return this.progDt;
	}
	
	/**
	 * Column Info
	 * @return progOfcCd
	 */
	public String getProgOfcCd() {
		return this.progOfcCd;
	}
	
	/**
	 * Column Info
	 * @return popupFlag
	 */
	public String getPopupFlag() {
		return this.popupFlag;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return progRmk
	 */
	public String getProgRmk() {
		return this.progRmk;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return msgDt
	 */
	public String getMsgDt() {
		return this.msgDt;
	}
	
	/**
	 * Column Info
	 * @return progSeq
	 */
	public String getProgSeq() {
		return this.progSeq;
	}
	
	/**
	 * Column Info
	 * @return aftBkgAproNo
	 */
	public String getAftBkgAproNo() {
		return this.aftBkgAproNo;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}
	
	/**
	 * Column Info
	 * @return backendJobFlag
	 */
	public String getBackendJobFlag() {
		return this.backendJobFlag;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
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
	 * @return jobKey
	 */
	public String getJobKey() {
		return this.jobKey;
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
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param progUsrId
	 */
	public void setProgUsrId(String progUsrId) {
		this.progUsrId = progUsrId;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
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
	 * @param dmdtExptRqstStsDesc
	 */
	public void setDmdtExptRqstStsDesc(String dmdtExptRqstStsDesc) {
		this.dmdtExptRqstStsDesc = dmdtExptRqstStsDesc;
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
	 * @param dmdtExptRqstStsCd
	 */
	public void setDmdtExptRqstStsCd(String dmdtExptRqstStsCd) {
		this.dmdtExptRqstStsCd = dmdtExptRqstStsCd;
	}
	
	/**
	 * Column Info
	 * @param aftExptDarNo
	 */
	public void setAftExptDarNo(String aftExptDarNo) {
		this.aftExptDarNo = aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param progDt
	 */
	public void setProgDt(String progDt) {
		this.progDt = progDt;
	}
	
	/**
	 * Column Info
	 * @param progOfcCd
	 */
	public void setProgOfcCd(String progOfcCd) {
		this.progOfcCd = progOfcCd;
	}
	
	/**
	 * Column Info
	 * @param popupFlag
	 */
	public void setPopupFlag(String popupFlag) {
		this.popupFlag = popupFlag;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param progRmk
	 */
	public void setProgRmk(String progRmk) {
		this.progRmk = progRmk;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param msgDt
	 */
	public void setMsgDt(String msgDt) {
		this.msgDt = msgDt;
	}
	
	/**
	 * Column Info
	 * @param progSeq
	 */
	public void setProgSeq(String progSeq) {
		this.progSeq = progSeq;
	}
	
	/**
	 * Column Info
	 * @param aftBkgAproNo
	 */
	public void setAftBkgAproNo(String aftBkgAproNo) {
		this.aftBkgAproNo = aftBkgAproNo;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}
	
	/**
	 * Column Info
	 * @param backendJobFlag
	 */
	public void setBackendJobFlag(String backendJobFlag) {
		this.backendJobFlag = backendJobFlag;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
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
	 * @param jobKey
	 */
	public void setJobKey(String jobKey) {
		this.jobKey = jobKey;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
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
		setProgUsrId(JSPUtil.getParameter(request, prefix + "prog_usr_id", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setDmdtExptRqstStsDesc(JSPUtil.getParameter(request, prefix + "dmdt_expt_rqst_sts_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDmdtExptRqstStsCd(JSPUtil.getParameter(request, prefix + "dmdt_expt_rqst_sts_cd", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", ""));
		setProgDt(JSPUtil.getParameter(request, prefix + "prog_dt", ""));
		setProgOfcCd(JSPUtil.getParameter(request, prefix + "prog_ofc_cd", ""));
		setPopupFlag(JSPUtil.getParameter(request, prefix + "popup_flag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setProgRmk(JSPUtil.getParameter(request, prefix + "prog_rmk", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setMsgDt(JSPUtil.getParameter(request, prefix + "msg_dt", ""));
		setProgSeq(JSPUtil.getParameter(request, prefix + "prog_seq", ""));
		setAftBkgAproNo(JSPUtil.getParameter(request, prefix + "aft_bkg_apro_no", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setBackendJobFlag(JSPUtil.getParameter(request, prefix + "backend_job_flag", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setJobKey(JSPUtil.getParameter(request, prefix + "job_key", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterProgressVO[]
	 */
	public AfterProgressVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterProgressVO[]
	 */
	public AfterProgressVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterProgressVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] progUsrId = (JSPUtil.getParameter(request, prefix	+ "prog_usr_id", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] dmdtExptRqstStsDesc = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_rqst_sts_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmdtExptRqstStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_rqst_sts_cd", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] progDt = (JSPUtil.getParameter(request, prefix	+ "prog_dt", length));
			String[] progOfcCd = (JSPUtil.getParameter(request, prefix	+ "prog_ofc_cd", length));
			String[] popupFlag = (JSPUtil.getParameter(request, prefix	+ "popup_flag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] progRmk = (JSPUtil.getParameter(request, prefix	+ "prog_rmk", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] msgDt = (JSPUtil.getParameter(request, prefix	+ "msg_dt", length));
			String[] progSeq = (JSPUtil.getParameter(request, prefix	+ "prog_seq", length));
			String[] aftBkgAproNo = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_apro_no", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] backendJobFlag = (JSPUtil.getParameter(request, prefix	+ "backend_job_flag", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] jobKey = (JSPUtil.getParameter(request, prefix	+ "job_key", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterProgressVO();
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (progUsrId[i] != null)
					model.setProgUsrId(progUsrId[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (dmdtExptRqstStsDesc[i] != null)
					model.setDmdtExptRqstStsDesc(dmdtExptRqstStsDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmdtExptRqstStsCd[i] != null)
					model.setDmdtExptRqstStsCd(dmdtExptRqstStsCd[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (progDt[i] != null)
					model.setProgDt(progDt[i]);
				if (progOfcCd[i] != null)
					model.setProgOfcCd(progOfcCd[i]);
				if (popupFlag[i] != null)
					model.setPopupFlag(popupFlag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (progRmk[i] != null)
					model.setProgRmk(progRmk[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (msgDt[i] != null)
					model.setMsgDt(msgDt[i]);
				if (progSeq[i] != null)
					model.setProgSeq(progSeq[i]);
				if (aftBkgAproNo[i] != null)
					model.setAftBkgAproNo(aftBkgAproNo[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (backendJobFlag[i] != null)
					model.setBackendJobFlag(backendJobFlag[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (jobKey[i] != null)
					model.setJobKey(jobKey[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterProgressVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterProgressVO[]
	 */
	public AfterProgressVO[] getAfterProgressVOs(){
		AfterProgressVO[] vos = (AfterProgressVO[])models.toArray(new AfterProgressVO[models.size()]);
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
		this.progUsrId = this.progUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptRqstStsDesc = this.dmdtExptRqstStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptRqstStsCd = this.dmdtExptRqstStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progDt = this.progDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progOfcCd = this.progOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.popupFlag = this.popupFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progRmk = this.progRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgDt = this.msgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progSeq = this.progSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftBkgAproNo = this.aftBkgAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backendJobFlag = this.backendJobFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jobKey = this.jobKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
