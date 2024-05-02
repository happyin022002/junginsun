/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtChgCorrHisVO.java
*@FileTitle : DmtChgCorrHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.11.12 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo;

import java.lang.reflect.Field;
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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtChgCorrHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtChgCorrHisVO> models = new ArrayList<DmtChgCorrHisVO>();
	
	/* Column Info */
	private String webCreDt = null;
	/* Column Info */
	private String corrHisRmk = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String fmYdCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String creNm = null;
	/* Column Info */
	private String toYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String creId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String toMvmtDt = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String corrHisSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String toMvmtStsCd = null;
	/* Column Info */
	private String fmMvmtStsCd = null;
	/* Column Info */
	private String webMtyNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String webMtyDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String chgStsCd = null;
	/* Column Info */
	private String webCreUsrId = null;
	/* Column Info */
	private String webMtyId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtChgCorrHisVO() {}

	public DmtChgCorrHisVO(String ibflag, String pagerows, String corrHisSeq, String chgStsCd, String fmMvmtStsCd, String fmMvmtDt, String fmYdCd, String toMvmtStsCd, String toMvmtDt, String toYdCd, String corrHisRmk, String creDt, String creNm, String creId, String creOfcCd, String webMtyDt, String webMtyNm, String webMtyId, String svrId, String cntrNo, String cntrCycNo, String dmdtTrfCd, String dmdtChgLocDivCd, String chgSeq, String bkgNo, String webCreUsrId, String webCreDt, String creUsrId, String updUsrId, String updDt, String updOfcCd) {
		this.webCreDt = webCreDt;
		this.corrHisRmk = corrHisRmk;
		this.cntrCycNo = cntrCycNo;
		this.fmYdCd = fmYdCd;
		this.creDt = creDt;
		this.chgSeq = chgSeq;
		this.creNm = creNm;
		this.toYdCd = toYdCd;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.creId = creId;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.toMvmtDt = toMvmtDt;
		this.dmdtTrfCd = dmdtTrfCd;
		this.corrHisSeq = corrHisSeq;
		this.updDt = updDt;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.toMvmtStsCd = toMvmtStsCd;
		this.fmMvmtStsCd = fmMvmtStsCd;
		this.webMtyNm = webMtyNm;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.webMtyDt = webMtyDt;
		this.cntrNo = cntrNo;
		this.fmMvmtDt = fmMvmtDt;
		this.chgStsCd = chgStsCd;
		this.webCreUsrId = webCreUsrId;
		this.webMtyId = webMtyId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("web_cre_dt", getWebCreDt());
		this.hashColumns.put("corr_his_rmk", getCorrHisRmk());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("fm_yd_cd", getFmYdCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("cre_nm", getCreNm());
		this.hashColumns.put("to_yd_cd", getToYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cre_id", getCreId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("corr_his_seq", getCorrHisSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("to_mvmt_sts_cd", getToMvmtStsCd());
		this.hashColumns.put("fm_mvmt_sts_cd", getFmMvmtStsCd());
		this.hashColumns.put("web_mty_nm", getWebMtyNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("web_mty_dt", getWebMtyDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("chg_sts_cd", getChgStsCd());
		this.hashColumns.put("web_cre_usr_id", getWebCreUsrId());
		this.hashColumns.put("web_mty_id", getWebMtyId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("web_cre_dt", "webCreDt");
		this.hashFields.put("corr_his_rmk", "corrHisRmk");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("fm_yd_cd", "fmYdCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("cre_nm", "creNm");
		this.hashFields.put("to_yd_cd", "toYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cre_id", "creId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("corr_his_seq", "corrHisSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("to_mvmt_sts_cd", "toMvmtStsCd");
		this.hashFields.put("fm_mvmt_sts_cd", "fmMvmtStsCd");
		this.hashFields.put("web_mty_nm", "webMtyNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("web_mty_dt", "webMtyDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("chg_sts_cd", "chgStsCd");
		this.hashFields.put("web_cre_usr_id", "webCreUsrId");
		this.hashFields.put("web_mty_id", "webMtyId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return webCreDt
	 */
	public String getWebCreDt() {
		return this.webCreDt;
	}
	
	/**
	 * Column Info
	 * @return corrHisRmk
	 */
	public String getCorrHisRmk() {
		return this.corrHisRmk;
	}
	
	/**
	 * Column Info
	 * @return cntrCycNo
	 */
	public String getCntrCycNo() {
		return this.cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @return fmYdCd
	 */
	public String getFmYdCd() {
		return this.fmYdCd;
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
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return creNm
	 */
	public String getCreNm() {
		return this.creNm;
	}
	
	/**
	 * Column Info
	 * @return toYdCd
	 */
	public String getToYdCd() {
		return this.toYdCd;
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
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return creId
	 */
	public String getCreId() {
		return this.creId;
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
	 * @return toMvmtDt
	 */
	public String getToMvmtDt() {
		return this.toMvmtDt;
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
	 * @return corrHisSeq
	 */
	public String getCorrHisSeq() {
		return this.corrHisSeq;
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
	 * @return dmdtChgLocDivCd
	 */
	public String getDmdtChgLocDivCd() {
		return this.dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return toMvmtStsCd
	 */
	public String getToMvmtStsCd() {
		return this.toMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtStsCd
	 */
	public String getFmMvmtStsCd() {
		return this.fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return webMtyNm
	 */
	public String getWebMtyNm() {
		return this.webMtyNm;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return webMtyDt
	 */
	public String getWebMtyDt() {
		return this.webMtyDt;
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
	 * @return fmMvmtDt
	 */
	public String getFmMvmtDt() {
		return this.fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return chgStsCd
	 */
	public String getChgStsCd() {
		return this.chgStsCd;
	}
	
	/**
	 * Column Info
	 * @return webCreUsrId
	 */
	public String getWebCreUsrId() {
		return this.webCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return webMtyId
	 */
	public String getWebMtyId() {
		return this.webMtyId;
	}
	

	/**
	 * Column Info
	 * @param webCreDt
	 */
	public void setWebCreDt(String webCreDt) {
		this.webCreDt = webCreDt;
	}
	
	/**
	 * Column Info
	 * @param corrHisRmk
	 */
	public void setCorrHisRmk(String corrHisRmk) {
		this.corrHisRmk = corrHisRmk;
	}
	
	/**
	 * Column Info
	 * @param cntrCycNo
	 */
	public void setCntrCycNo(String cntrCycNo) {
		this.cntrCycNo = cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @param fmYdCd
	 */
	public void setFmYdCd(String fmYdCd) {
		this.fmYdCd = fmYdCd;
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
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param creNm
	 */
	public void setCreNm(String creNm) {
		this.creNm = creNm;
	}
	
	/**
	 * Column Info
	 * @param toYdCd
	 */
	public void setToYdCd(String toYdCd) {
		this.toYdCd = toYdCd;
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
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param creId
	 */
	public void setCreId(String creId) {
		this.creId = creId;
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
	 * @param toMvmtDt
	 */
	public void setToMvmtDt(String toMvmtDt) {
		this.toMvmtDt = toMvmtDt;
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
	 * @param corrHisSeq
	 */
	public void setCorrHisSeq(String corrHisSeq) {
		this.corrHisSeq = corrHisSeq;
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
	 * @param dmdtChgLocDivCd
	 */
	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param toMvmtStsCd
	 */
	public void setToMvmtStsCd(String toMvmtStsCd) {
		this.toMvmtStsCd = toMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtStsCd
	 */
	public void setFmMvmtStsCd(String fmMvmtStsCd) {
		this.fmMvmtStsCd = fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param webMtyNm
	 */
	public void setWebMtyNm(String webMtyNm) {
		this.webMtyNm = webMtyNm;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param webMtyDt
	 */
	public void setWebMtyDt(String webMtyDt) {
		this.webMtyDt = webMtyDt;
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
	 * @param fmMvmtDt
	 */
	public void setFmMvmtDt(String fmMvmtDt) {
		this.fmMvmtDt = fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param chgStsCd
	 */
	public void setChgStsCd(String chgStsCd) {
		this.chgStsCd = chgStsCd;
	}
	
	/**
	 * Column Info
	 * @param webCreUsrId
	 */
	public void setWebCreUsrId(String webCreUsrId) {
		this.webCreUsrId = webCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param webMtyId
	 */
	public void setWebMtyId(String webMtyId) {
		this.webMtyId = webMtyId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setWebCreDt(JSPUtil.getParameter(request, "web_cre_dt", ""));
		setCorrHisRmk(JSPUtil.getParameter(request, "corr_his_rmk", ""));
		setCntrCycNo(JSPUtil.getParameter(request, "cntr_cyc_no", ""));
		setFmYdCd(JSPUtil.getParameter(request, "fm_yd_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setCreNm(JSPUtil.getParameter(request, "cre_nm", ""));
		setToYdCd(JSPUtil.getParameter(request, "to_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCreId(JSPUtil.getParameter(request, "cre_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setToMvmtDt(JSPUtil.getParameter(request, "to_mvmt_dt", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setCorrHisSeq(JSPUtil.getParameter(request, "corr_his_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", ""));
		setToMvmtStsCd(JSPUtil.getParameter(request, "to_mvmt_sts_cd", ""));
		setFmMvmtStsCd(JSPUtil.getParameter(request, "fm_mvmt_sts_cd", ""));
		setWebMtyNm(JSPUtil.getParameter(request, "web_mty_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setWebMtyDt(JSPUtil.getParameter(request, "web_mty_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, "fm_mvmt_dt", ""));
		setChgStsCd(JSPUtil.getParameter(request, "chg_sts_cd", ""));
		setWebCreUsrId(JSPUtil.getParameter(request, "web_cre_usr_id", ""));
		setWebMtyId(JSPUtil.getParameter(request, "web_mty_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtChgCorrHisVO[]
	 */
	public DmtChgCorrHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtChgCorrHisVO[]
	 */
	public DmtChgCorrHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtChgCorrHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] webCreDt = (JSPUtil.getParameter(request, prefix	+ "web_cre_dt", length));
			String[] corrHisRmk = (JSPUtil.getParameter(request, prefix	+ "corr_his_rmk", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] fmYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_yd_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] creNm = (JSPUtil.getParameter(request, prefix	+ "cre_nm", length));
			String[] toYdCd = (JSPUtil.getParameter(request, prefix	+ "to_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] creId = (JSPUtil.getParameter(request, prefix	+ "cre_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] corrHisSeq = (JSPUtil.getParameter(request, prefix	+ "corr_his_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] toMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_sts_cd", length));
			String[] fmMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_sts_cd", length));
			String[] webMtyNm = (JSPUtil.getParameter(request, prefix	+ "web_mty_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] webMtyDt = (JSPUtil.getParameter(request, prefix	+ "web_mty_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] chgStsCd = (JSPUtil.getParameter(request, prefix	+ "chg_sts_cd", length));
			String[] webCreUsrId = (JSPUtil.getParameter(request, prefix	+ "web_cre_usr_id", length));
			String[] webMtyId = (JSPUtil.getParameter(request, prefix	+ "web_mty_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtChgCorrHisVO();
				if (webCreDt[i] != null)
					model.setWebCreDt(webCreDt[i]);
				if (corrHisRmk[i] != null)
					model.setCorrHisRmk(corrHisRmk[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (fmYdCd[i] != null)
					model.setFmYdCd(fmYdCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (creNm[i] != null)
					model.setCreNm(creNm[i]);
				if (toYdCd[i] != null)
					model.setToYdCd(toYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (creId[i] != null)
					model.setCreId(creId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (corrHisSeq[i] != null)
					model.setCorrHisSeq(corrHisSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (toMvmtStsCd[i] != null)
					model.setToMvmtStsCd(toMvmtStsCd[i]);
				if (fmMvmtStsCd[i] != null)
					model.setFmMvmtStsCd(fmMvmtStsCd[i]);
				if (webMtyNm[i] != null)
					model.setWebMtyNm(webMtyNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (webMtyDt[i] != null)
					model.setWebMtyDt(webMtyDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (chgStsCd[i] != null)
					model.setChgStsCd(chgStsCd[i]);
				if (webCreUsrId[i] != null)
					model.setWebCreUsrId(webCreUsrId[i]);
				if (webMtyId[i] != null)
					model.setWebMtyId(webMtyId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtChgCorrHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtChgCorrHisVO[]
	 */
	public DmtChgCorrHisVO[] getDmtChgCorrHisVOs(){
		DmtChgCorrHisVO[] vos = (DmtChgCorrHisVO[])models.toArray(new DmtChgCorrHisVO[models.size()]);
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
		this.webCreDt = this.webCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrHisRmk = this.corrHisRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYdCd = this.fmYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creNm = this.creNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdCd = this.toYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creId = this.creId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrHisSeq = this.corrHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtStsCd = this.toMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtStsCd = this.fmMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webMtyNm = this.webMtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webMtyDt = this.webMtyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgStsCd = this.chgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webCreUsrId = this.webCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webMtyId = this.webMtyId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
