/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MisUseReqContainerVO.java
*@FileTitle : MisUseReqContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.14 장준우
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MisUseReqContainerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<MisUseReqContainerVO> models = new ArrayList<MisUseReqContainerVO>();

	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String liborPtyNm = null;
	/* Column Info */
	private String rqstNo = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String rqstLocCd = null;
	/* Column Info */
	private String rqstLocNm = null;
	/* Column Info */
	private String mssUsdFmNm = null;
	/* Column Info */
	private String mssUsdDt = null;
	/* Column Info */
	private String pdChgRtAmt = null;
	/* Column Info */
	private String lftChgRtAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String mssUsePlcNm = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String mssUsdAproModCd = null;
	/* Column Info */
	private String aproAgmtSeq = null;
	/* Column Info */
	private String aproAgmtCtyCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String rqstFileSavId = null;
	/* Column Info */
	private String rqstFileSavNm = null;
	/* Column Info */
	private String rqstRsnDesc = null;
	/* Column Info */
	private String aproFileSavId = null;
	/* Column Info */
	private String aproFileSavNm = null;
	/* Column Info */
	private String aproRsnDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private int iPage = 1;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	/**
	 * Constructor
	 */
	public MisUseReqContainerVO() {}

	/**
	 * Constructor
	 */
	public MisUseReqContainerVO(String ibflag, String aproFileSavId, String aproFileSavNm, String aproRsnDesc, String rqstFileSavId, String rqstFileSavNm, String rqstRsnDesc, String mvmtStsCd, String podCd, String polCd, String rqstNo, String rqstLocNm, String cntrNo, String agmtNo, String agmtCtyCd, String agmtSeq, String cntrTpszCd, String lstmCd, String mssUsdAproModCd, String mssUsdDt, String mssUsdFmNm, String mssUsePlcNm, String pdChgRtAmt, String lftChgRtAmt, String liborPtyNm, String rqstLocCd, String aproAgmtCtyCd, String aproAgmtSeq, String creUsrId, String updUsrId, String pagerows) {
		this.ibflag = ibflag;
		this.liborPtyNm = liborPtyNm;
		this.rqstNo = rqstNo;
		this.agmtNo = agmtNo;
		this.agmtSeq = agmtSeq;
		this.rqstLocCd = rqstLocCd;
		this.rqstLocNm = rqstLocNm;
		this.mssUsdFmNm = mssUsdFmNm;
		this.mssUsdDt = mssUsdDt;
		this.pdChgRtAmt = pdChgRtAmt;
		this.lftChgRtAmt = lftChgRtAmt;
		this.creUsrId = creUsrId;
		this.cntrNo = cntrNo;
		this.mssUsePlcNm = mssUsePlcNm;
		this.agmtCtyCd = agmtCtyCd;
		this.cntrTpszCd = cntrTpszCd;
		this.lstmCd = lstmCd;
		this.mssUsdAproModCd = mssUsdAproModCd;
		this.aproAgmtSeq = aproAgmtSeq;
		this.aproAgmtCtyCd = aproAgmtCtyCd;
		this.updUsrId = updUsrId;
		this.mvmtStsCd = mvmtStsCd;
		this.podCd = podCd;
		this.polCd = polCd;
		this.rqstFileSavId = rqstFileSavId;
		this.rqstFileSavNm = rqstFileSavNm;
		this.rqstRsnDesc = rqstRsnDesc;
		this.aproFileSavId = aproFileSavId;
		this.aproFileSavNm = aproFileSavNm;
		this.aproRsnDesc = aproRsnDesc;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("libor_pty_nm", getLiborPtyNm());
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("rqst_loc_cd", getRqstLocCd());
		this.hashColumns.put("rqst_loc_nm", getRqstLocNm());
		this.hashColumns.put("mss_usd_fm_nm", getMssUsdFmNm());
		this.hashColumns.put("mss_usd_dt", getMssUsdDt());
		this.hashColumns.put("pd_chg_rt_amt", getPdChgRtAmt());
		this.hashColumns.put("lft_chg_rt_amt", getLftChgRtAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("mss_use_plc_nm", getMssUsePlcNm());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("mss_usd_apro_mod_cd", getMssUsdAproModCd());
		this.hashColumns.put("apro_agmt_seq", getAproAgmtSeq());
		this.hashColumns.put("apro_agmt_cty_cd", getAproAgmtCtyCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("rqst_file_sav_id", getRqstFileSavId());
		this.hashColumns.put("rqst_file_sav_nm", getRqstFileSavNm());
		this.hashColumns.put("rqst_rsn_desc", getRqstRsnDesc());
		this.hashColumns.put("apro_file_sav_id", getAproFileSavId());
		this.hashColumns.put("apro_file_sav_nm", getAproFileSavNm());
		this.hashColumns.put("apro_rsn_desc", getAproRsnDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("libor_pty_nm", "liborPtyNm");
		this.hashFields.put("rqst_no", "rqstNo");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("rqst_loc_cd", "rqstLocCd");
		this.hashFields.put("rqst_loc_nm", "rqstLocNm");
		this.hashFields.put("mss_usd_fm_nm", "mssUsdFmNm");
		this.hashFields.put("mss_usd_dt", "mssUsdDt");
		this.hashFields.put("pd_chg_rt_amt", "pdChgRtAmt");
		this.hashFields.put("lft_chg_rt_amt", "lftChgRtAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("mss_use_plc_nm", "mssUsePlcNm");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("mss_usd_apro_mod_cd", "mssUsdAproModCd");
		this.hashFields.put("apro_agmt_seq", "aproAgmtSeq");
		this.hashFields.put("apro_agmt_cty_cd", "aproAgmtCtyCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rqst_file_sav_id", "rqstFileSavId");
		this.hashFields.put("rqst_file_sav_nm", "rqstFileSavNm");
		this.hashFields.put("rqst_rsn_desc", "rqstRsnDesc");
		this.hashFields.put("apro_file_sav_id", "aproFileSavId");
		this.hashFields.put("apro_file_sav_nm", "aproFileSavNm");
		this.hashFields.put("apro_rsn_desc", "aproRsnDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return liborPtyNm
	 */
	public String getLiborPtyNm() {
		return this.liborPtyNm;
	}

	/**
	 * Column Info
	 * @return rqstNo
	 */
	public String getRqstNo() {
		return this.rqstNo;
	}

	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}

	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}

	/**
	 * Column Info
	 * @return aproAgmtSeq
	 */
	public String getAproAgmtSeq() {
		return this.aproAgmtSeq;
	}

	/**
	 * Column Info
	 * @return rqstLocCd
	 */
	public String getRqstLocCd() {
		return this.rqstLocCd;
	}

	/**
	 * Column Info
	 * @return mssUsdFmNm
	 */
	public String getMssUsdFmNm() {
		return this.mssUsdFmNm;
	}

	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * @return mssUsdDt
	 */
	public String getMssUsdDt() {
		return this.mssUsdDt;
	}

	/**
	 * Column Info
	 * @return pdChgRtAmt
	 */
	public String getPdChgRtAmt() {
		return this.pdChgRtAmt;
	}

	/**
	 * Column Info
	 * @return lftChgRtAmt
	 */
	public String getLftChgRtAmt() {
		return this.lftChgRtAmt;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return mssUsePlcNm
	 */
	public String getMssUsePlcNm() {
		return this.mssUsePlcNm;
	}

	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}

	/**
	 * Column Info
	 * @return aproAgmtCtyCd
	 */
	public String getAproAgmtCtyCd() {
		return this.aproAgmtCtyCd;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}

	/**
	 * Column Info
	 * @return mssUsdAproModCd
	 */
	public String getMssUsdAproModCd() {
		return this.mssUsdAproModCd;
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
	 * @param liborPtyNm
	 */
	public void setLiborPtyNm(String liborPtyNm) {
		this.liborPtyNm = liborPtyNm;
	}

	/**
	 * Column Info
	 * @param rqstNo
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}

	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	/**
	 * Column Info
	 * @param aproAgmtSeq
	 */
	public void setAproAgmtSeq(String aproAgmtSeq) {
		this.aproAgmtSeq = aproAgmtSeq;
	}

	/**
	 * Column Info
	 * @param rqstLocCd
	 */
	public void setRqstLocCd(String rqstLocCd) {
		this.rqstLocCd = rqstLocCd;
	}

	/**
	 * Column Info
	 * @param mssUsdFmNm
	 */
	public void setMssUsdFmNm(String mssUsdFmNm) {
		this.mssUsdFmNm = mssUsdFmNm;
	}

	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * @param mssUsdDt
	 */
	public void setMssUsdDt(String mssUsdDt) {
		this.mssUsdDt = mssUsdDt;
	}

	/**
	 * Column Info
	 * @param pdChgRtAmt
	 */
	public void setPdChgRtAmt(String pdChgRtAmt) {
		this.pdChgRtAmt = pdChgRtAmt;
	}

	/**
	 * Column Info
	 * @param lftChgRtAmt
	 */
	public void setLftChgRtAmt(String lftChgRtAmt) {
		this.lftChgRtAmt = lftChgRtAmt;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param mssUsePlcNm
	 */
	public void setMssUsePlcNm(String mssUsePlcNm) {
		this.mssUsePlcNm = mssUsePlcNm;
	}

	/**
	 * Column Info
	 * @param aproAgmtCtyCd
	 */
	public void setAproAgmtCtyCd(String aproAgmtCtyCd) {
		this.aproAgmtCtyCd = aproAgmtCtyCd;
	}

	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	/**
	 * Column Info
	 * @param mssUsdAproModCd
	 */
	public void setMssUsdAproModCd(String mssUsdAproModCd) {
		this.mssUsdAproModCd = mssUsdAproModCd;
	}

	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * @return the iPage
	 */
	public int getIPage() {
		return iPage;
	}

	/**
	 * @param page the iPage to set
	 */
	public void setIPage(int page) {
		iPage = page;
	}

	/**
	 * @return the rqstLocNm
	 */
	public String getRqstLocNm() {
		return rqstLocNm;
	}

	/**
	 * @param rqstLocNm the rqstLocNm to set
	 */
	public void setRqstLocNm(String rqstLocNm) {
		this.rqstLocNm = rqstLocNm;
	}

	/**
	 * @return the mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return mvmtStsCd;
	}

	/**
	 * @param mvmtStsCd the mvmtStsCd to set
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}

	/**
	 * @return the podCd
	 */
	public String getPodCd() {
		return podCd;
	}

	/**
	 * @param podCd the podCd to set
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * @return the polCd
	 */
	public String getPolCd() {
		return polCd;
	}

	/**
	 * @param polCd the polCd to set
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * @return the rqstFileSavId
	 */
	public String getRqstFileSavId() {
		return rqstFileSavId;
	}

	/**
	 * @param rqstFileSavId the rqstFileSavId to set
	 */
	public void setRqstFileSavId(String rqstFileSavId) {
		this.rqstFileSavId = rqstFileSavId;
	}

	/**
	 * @return the rqstFileSavNm
	 */
	public String getRqstFileSavNm() {
		return rqstFileSavNm;
	}

	/**
	 * @param rqstFileSavNm the rqstFileSavNm to set
	 */
	public void setRqstFileSavNm(String rqstFileSavNm) {
		this.rqstFileSavNm = rqstFileSavNm;
	}

	/**
	 * @return the rqstRsnDesc
	 */
	public String getRqstRsnDesc() {
		return rqstRsnDesc;
	}

	/**
	 * @param rqstRsnDesc the rqstRsnDesc to set
	 */
	public void setRqstRsnDesc(String rqstRsnDesc) {
		this.rqstRsnDesc = rqstRsnDesc;
	}

	/**
	 * @return the aproFileSavId
	 */
	public String getAproFileSavId() {
		return aproFileSavId;
	}

	/**
	 * @param aproFileSavId the aproFileSavId to set
	 */
	public void setAproFileSavId(String aproFileSavId) {
		this.aproFileSavId = aproFileSavId;
	}

	/**
	 * @return the aproFileSavNm
	 */
	public String getAproFileSavNm() {
		return aproFileSavNm;
	}

	/**
	 * @param aproFileSavNm the aproFileSavNm to set
	 */
	public void setAproFileSavNm(String aproFileSavNm) {
		this.aproFileSavNm = aproFileSavNm;
	}

	/**
	 * @return the aproRsnDesc
	 */
	public String getAproRsnDesc() {
		return aproRsnDesc;
	}

	/**
	 * @param aproRsnDesc the aproRsnDesc to set
	 */
	public void setAproRsnDesc(String aproRsnDesc) {
		this.aproRsnDesc = aproRsnDesc;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLiborPtyNm(JSPUtil.getParameter(request, "libor_pty_nm", ""));
		setRqstNo(JSPUtil.getParameter(request, "rqst_no", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setRqstLocCd(JSPUtil.getParameter(request, "rqst_loc_cd", ""));
		setRqstLocNm(JSPUtil.getParameter(request, "rqst_loc_nm", ""));
		setMssUsdFmNm(JSPUtil.getParameter(request, "mss_usd_fm_nm", ""));
		setMssUsdDt(JSPUtil.getParameter(request, "mss_usd_dt", ""));
		setPdChgRtAmt(JSPUtil.getParameter(request, "pd_chg_rt_amt", ""));
		setLftChgRtAmt(JSPUtil.getParameter(request, "lft_chg_rt_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setMssUsePlcNm(JSPUtil.getParameter(request, "mss_use_plc_nm", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setMssUsdAproModCd(JSPUtil.getParameter(request, "mss_usd_apro_mod_cd", ""));
		setAproAgmtSeq(JSPUtil.getParameter(request, "apro_agmt_seq", ""));
		setAproAgmtCtyCd(JSPUtil.getParameter(request, "apro_agmt_cty_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setRqstFileSavId(JSPUtil.getParameter(request, "rqst_file_sav_id", ""));
		setRqstFileSavNm(JSPUtil.getParameter(request, "rqst_file_sav_nm", ""));
		setRqstRsnDesc(JSPUtil.getParameter(request, "rqst_rsn_desc", ""));
		setAproFileSavId(JSPUtil.getParameter(request, "apro_file_sav_id", ""));
		setAproFileSavNm(JSPUtil.getParameter(request, "apro_file_sav_nm", ""));
		setAproRsnDesc(JSPUtil.getParameter(request, "apro_rsn_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MisUseReqContainerVO[]
	 */
	public MisUseReqContainerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return MisUseReqContainerVO[]
	 */
	public MisUseReqContainerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MisUseReqContainerVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] liborPtyNm = (JSPUtil.getParameter(request, prefix	+ "libor_pty_nm", length));
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqst_no", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] rqstLocCd = (JSPUtil.getParameter(request, prefix	+ "rqst_loc_cd", length));
			String[] rqstLocNm = (JSPUtil.getParameter(request, prefix	+ "rqst_loc_nm", length));
			String[] mssUsdFmNm = (JSPUtil.getParameter(request, prefix	+ "mss_usd_fm_nm", length));
			String[] mssUsdDt = (JSPUtil.getParameter(request, prefix	+ "mss_usd_dt", length));
			String[] pdChgRtAmt = (JSPUtil.getParameter(request, prefix	+ "pd_chg_rt_amt", length));
			String[] lftChgRtAmt = (JSPUtil.getParameter(request, prefix	+ "lft_chg_rt_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] mssUsePlcNm = (JSPUtil.getParameter(request, prefix	+ "mss_use_plc_nm", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] mssUsdAproModCd = (JSPUtil.getParameter(request, prefix	+ "mss_usd_apro_mod_cd", length));
			String[] aproAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "apro_agmt_seq", length));
			String[] aproAgmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "apro_agmt_cty_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] rqstFileSavId = (JSPUtil.getParameter(request, prefix	+ "rqst_file_sav_id", length));
			String[] rqstFileSavNm = (JSPUtil.getParameter(request, prefix	+ "rqst_file_sav_nm", length));
			String[] rqstRsnDesc = (JSPUtil.getParameter(request, prefix	+ "rqst_rsn_desc", length));
			String[] aproFileSavId = (JSPUtil.getParameter(request, prefix	+ "apro_file_sav_id", length));
			String[] aproFileSavNm = (JSPUtil.getParameter(request, prefix	+ "apro_rsn_desc", length));
			String[] aproRsnDesc = (JSPUtil.getParameter(request, prefix	+ "apro_rsn_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new MisUseReqContainerVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (liborPtyNm[i] != null)
					model.setLiborPtyNm(liborPtyNm[i]);
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (rqstLocCd[i] != null)
					model.setRqstLocCd(rqstLocCd[i]);
				if (rqstLocNm[i] != null)
					model.setRqstLocNm(rqstLocNm[i]);
				if (mssUsdFmNm[i] != null)
					model.setMssUsdFmNm(mssUsdFmNm[i]);
				if (mssUsdDt[i] != null)
					model.setMssUsdDt(mssUsdDt[i]);
				if (pdChgRtAmt[i] != null)
					model.setPdChgRtAmt(pdChgRtAmt[i]);
				if (lftChgRtAmt[i] != null)
					model.setLftChgRtAmt(lftChgRtAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (mssUsePlcNm[i] != null)
					model.setMssUsePlcNm(mssUsePlcNm[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (mssUsdAproModCd[i] != null)
					model.setMssUsdAproModCd(mssUsdAproModCd[i]);
				if (aproAgmtSeq[i] != null)
					model.setAproAgmtSeq(aproAgmtSeq[i]);
				if (aproAgmtCtyCd[i] != null)
					model.setAproAgmtCtyCd(aproAgmtCtyCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (rqstFileSavId[i] != null)
					model.setRqstFileSavId(rqstFileSavId[i]);
				if (rqstFileSavNm[i] != null)
					model.setRqstFileSavNm(rqstFileSavNm[i]);
				if (rqstRsnDesc[i] != null)
					model.setRqstRsnDesc(rqstRsnDesc[i]);
				if (aproFileSavId[i] != null)
					model.setAproFileSavId(aproFileSavId[i]);
				if (aproFileSavNm[i] != null)
					model.setAproFileSavNm(aproFileSavNm[i]);
				if (aproRsnDesc[i] != null)
					model.setAproRsnDesc(aproRsnDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMisUseReqContainerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MisUseReqContainerVO[]
	 */
	public MisUseReqContainerVO[] getMisUseReqContainerVOs(){
		MisUseReqContainerVO[] vos = (MisUseReqContainerVO[])models.toArray(new MisUseReqContainerVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}

	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.liborPtyNm = this.liborPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstLocCd = this.rqstLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstLocNm = this.rqstLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssUsdFmNm = this.mssUsdFmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssUsdDt = this.mssUsdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdChgRtAmt = this.pdChgRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lftChgRtAmt = this.lftChgRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssUsePlcNm = this.mssUsePlcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproAgmtSeq = this.aproAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproAgmtCtyCd = this.aproAgmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssUsdAproModCd = this.mssUsdAproModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstFileSavId = this.rqstFileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstFileSavNm = this.rqstFileSavNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRsnDesc = this.rqstRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFileSavId = this.aproFileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFileSavNm = this.aproFileSavNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRsnDesc = this.aproRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
