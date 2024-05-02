/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : IfSchemaVO.java
*@FileTitle : IfSchemaVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class IfSchemaVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IfSchemaVO> models = new ArrayList<IfSchemaVO>();
	
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String webCreDt = null;
	/* Column Info */
	private String toMvmtStsCd = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String sysAreaGrpId = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String webMtyDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String webNtfyPicNm = null;
	/* Column Info */
	private String webCreUsrId = null;
	/* Column Info */
	private String webIndFlg = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String toMvmtDt = null;
	/* Column Info */
	private String toMvmtYdCd = null;
	/* Column Info */
	private String webNtfyPicTelcmNo = null;
	/* Column Info */
	private String fxFtOvrDys = null;
	/* Column Info */
	private String bzcTrfCurrCd = null;
	/* Column Info */
	private String bilAmt = null;
	/* Column Info */
	private String actCntCd = null; 
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String fmMvmtStsCd = null;
	/* Column Info */
	private String fmMvmtYdCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String ofcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IfSchemaVO() {}

	public IfSchemaVO(String ibflag, String pagerows, String sysAreaGrpId, String cntrNo, String cntrCycNo, String dmdtTrfCd, String dmdtChgLocDivCd, 
						String chgSeq, String toMvmtStsCd, String fmMvmtDt, String toMvmtDt, String webMtyDt, String toMvmtYdCd, String webIndFlg, String webCreUsrId, 
							String webCreDt, String webNtfyPicNm, String webNtfyPicTelcmNo, String fxFtOvrDys, String bzcTrfCurrCd, String bilAmt, String actCntCd, String actCustSeq,
								String bkgNo, String cntrTpszCd, String custCntCd, String custSeq, String fmMvmtStsCd, String fmMvmtYdCd, String ioBndCd, String ofcCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.webCreDt = webCreDt;
		this.toMvmtStsCd = toMvmtStsCd;
		this.cntrCycNo = cntrCycNo;
		this.chgSeq = chgSeq;
		this.sysAreaGrpId = sysAreaGrpId;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.webMtyDt = webMtyDt;
		this.cntrNo = cntrNo;
		this.webNtfyPicNm = webNtfyPicNm;
		this.webCreUsrId = webCreUsrId;
		this.webIndFlg = webIndFlg;
		this.dmdtTrfCd = dmdtTrfCd;
		this.fmMvmtDt = fmMvmtDt;
		this.toMvmtDt = toMvmtDt;
		this.toMvmtYdCd = toMvmtYdCd;
		this.webNtfyPicTelcmNo = webNtfyPicTelcmNo;
		this.fxFtOvrDys = fxFtOvrDys;
		this.bzcTrfCurrCd = bzcTrfCurrCd;
		this.bilAmt = bilAmt;
		this.actCntCd = actCntCd;
		this.actCustSeq = actCustSeq;
		this.bkgNo = bkgNo;
		this.cntrTpszCd = cntrTpszCd;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.fmMvmtStsCd = fmMvmtStsCd;
		this.fmMvmtYdCd = fmMvmtYdCd;
		this.ioBndCd = ioBndCd;
		this.ofcCd = ofcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("web_cre_dt", getWebCreDt());
		this.hashColumns.put("to_mvmt_sts_cd", getToMvmtStsCd());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("sys_area_grp_id", getSysAreaGrpId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("web_mty_dt", getWebMtyDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("web_ntfy_pic_nm", getWebNtfyPicNm());
		this.hashColumns.put("web_cre_usr_id", getWebCreUsrId());
		this.hashColumns.put("web_ind_flg", getWebIndFlg());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("to_mvmt_yd_cd", getToMvmtYdCd());
		this.hashColumns.put("web_ntfy_pic_telcm_no", getWebNtfyPicTelcmNo());
		this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
		this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("act_cnt_cd", getActCntCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("fm_mvmt_sts_cd", getFmMvmtStsCd());
		this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("web_cre_dt", "webCreDt");
		this.hashFields.put("to_mvmt_sts_cd", "toMvmtStsCd");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("sys_area_grp_id", "sysAreaGrpId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("web_mty_dt", "webMtyDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("web_ntfy_pic_nm", "webNtfyPicNm");
		this.hashFields.put("web_cre_usr_id", "webCreUsrId");
		this.hashFields.put("web_ind_flg", "webIndFlg");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("to_mvmt_yd_cd", "toMvmtYdCd");
		this.hashFields.put("web_ntfy_pic_telcm_no", "webNtfyPicTelcmNo");
		this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
		this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("act_cnt_cd", "actCntCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("fm_mvmt_sts_cd", "fmMvmtStsCd");
		this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		
		return this.hashFields;
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
	 * @return webCreDt
	 */
	public String getWebCreDt() {
		return this.webCreDt;
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
	 * @return cntrCycNo
	 */
	public String getCntrCycNo() {
		return this.cntrCycNo;
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
	 * @return sysAreaGrpId
	 */
	public String getSysAreaGrpId() {
		return this.sysAreaGrpId;
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
	 * @return webNtfyPicNm
	 */
	public String getWebNtfyPicNm() {
		return this.webNtfyPicNm;
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
	 * @return webIndFlg
	 */
	public String getWebIndFlg() {
		return this.webIndFlg;
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
	 * @return fmMvmtDt
	 */
	public String getFmMvmtDt() {
		return this.fmMvmtDt;
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
	 * @return toMvmtYdCd
	 */
	public String getToMvmtYdCd() {
		return this.toMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return webNtfyPicTelcmNo
	 */
	public String getWebNtfyPicTelcmNo() {
		return this.webNtfyPicTelcmNo;
	}
	
	/**
	 * Column Info
	 * @return fxFtOvrDys
	 */
	public String getFxFtOvrDys() {
		return this.fxFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfCurrCd
	 */
	public String getBzcTrfCurrCd() {
		return this.bzcTrfCurrCd;
	}
	
	/**
	 * Column Info
	 * @return bilAmt
	 */
	public String getBilAmt() {
		return this.bilAmt;
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
	 * @param webCreDt
	 */
	public void setWebCreDt(String webCreDt) {
		this.webCreDt = webCreDt;
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
	 * @param cntrCycNo
	 */
	public void setCntrCycNo(String cntrCycNo) {
		this.cntrCycNo = cntrCycNo;
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
	 * @param sysAreaGrpId
	 */
	public void setSysAreaGrpId(String sysAreaGrpId) {
		this.sysAreaGrpId = sysAreaGrpId;
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
	 * @param webNtfyPicNm
	 */
	public void setWebNtfyPicNm(String webNtfyPicNm) {
		this.webNtfyPicNm = webNtfyPicNm;
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
	 * @param webIndFlg
	 */
	public void setWebIndFlg(String webIndFlg) {
		this.webIndFlg = webIndFlg;
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
	 * @param fmMvmtDt
	 */
	public void setFmMvmtDt(String fmMvmtDt) {
		this.fmMvmtDt = fmMvmtDt;
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
	 * @param toMvmtYdCd
	 */
	public void setToMvmtYdCd(String toMvmtYdCd) {
		this.toMvmtYdCd = toMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @param webNtfyPicTelcmNo
	 */
	public void setWebNtfyPicTelcmNo(String webNtfyPicTelcmNo) {
		this.webNtfyPicTelcmNo = webNtfyPicTelcmNo;
	}
	
	/**
	 * Column Info
	 * @param fxFtOvrDys
	 */
	public void setFxFtOvrDys(String fxFtOvrDys) {
		this.fxFtOvrDys = fxFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfCurrCd
	 */
	public void setBzcTrfCurrCd(String bzcTrfCurrCd) {
		this.bzcTrfCurrCd = bzcTrfCurrCd;
	}
	
	/**
	 * Column Info
	 * @param bilAmt
	 */
	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
	}
	
	/**
	 * Column Info
	 * @return actCntCd
	 */
	public String getActCntCd() {
		return actCntCd;
	}

	/**
	 * Column Info
	 * @param actCntCd
	 */
	public void setActCntCd(String actCntCd) {
		this.actCntCd = actCntCd;
	}

	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return actCustSeq;
	}

	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return cntrTpszCd;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return custCntCd;
	}

	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return custSeq;
	}

	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * Column Info
	 * @return fmMvmtStsCd
	 */
	public String getFmMvmtStsCd() {
		return fmMvmtStsCd;
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
	 * @return fmMvmtYdCd
	 */
	public String getFmMvmtYdCd() {
		return fmMvmtYdCd;
	}

	/**
	 * Column Info
	 * @param fmMvmtYdCd
	 */
	public void setFmMvmtYdCd(String fmMvmtYdCd) {
		this.fmMvmtYdCd = fmMvmtYdCd;
	}

	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return ioBndCd;
	}

	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
		setWebCreDt(JSPUtil.getParameter(request, prefix + "web_cre_dt", ""));
		setToMvmtStsCd(JSPUtil.getParameter(request, prefix + "to_mvmt_sts_cd", ""));
		setCntrCycNo(JSPUtil.getParameter(request, prefix + "cntr_cyc_no", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setSysAreaGrpId(JSPUtil.getParameter(request, prefix + "sys_area_grp_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWebMtyDt(JSPUtil.getParameter(request, prefix + "web_mty_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setWebNtfyPicNm(JSPUtil.getParameter(request, prefix + "web_ntfy_pic_nm", ""));
		setWebCreUsrId(JSPUtil.getParameter(request, prefix + "web_cre_usr_id", ""));
		setWebIndFlg(JSPUtil.getParameter(request, prefix + "web_ind_flg", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", ""));
		setToMvmtDt(JSPUtil.getParameter(request, prefix + "to_mvmt_dt", ""));
		setToMvmtYdCd(JSPUtil.getParameter(request, prefix + "to_mvmt_yd_cd", ""));
		setWebNtfyPicTelcmNo(JSPUtil.getParameter(request, prefix + "web_ntfy_pic_telcm_no", ""));
		setFxFtOvrDys(JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", ""));
		setBzcTrfCurrCd(JSPUtil.getParameter(request, prefix + "bzc_trf_curr_cd", ""));
		setBilAmt(JSPUtil.getParameter(request, prefix + "bil_amt", ""));
		setActCntCd(JSPUtil.getParameter(request, prefix + "act_cnt_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setFmMvmtStsCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_sts_cd", ""));
		setFmMvmtYdCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IfSchemaVO[]
	 */
	public IfSchemaVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IfSchemaVO[]
	 */
	public IfSchemaVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IfSchemaVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] webCreDt = (JSPUtil.getParameter(request, prefix	+ "web_cre_dt", length));
			String[] toMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_sts_cd", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] sysAreaGrpId = (JSPUtil.getParameter(request, prefix	+ "sys_area_grp_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] webMtyDt = (JSPUtil.getParameter(request, prefix	+ "web_mty_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] webNtfyPicNm = (JSPUtil.getParameter(request, prefix	+ "web_ntfy_pic_nm", length));
			String[] webCreUsrId = (JSPUtil.getParameter(request, prefix	+ "web_cre_usr_id", length));
			String[] webIndFlg = (JSPUtil.getParameter(request, prefix	+ "web_ind_flg", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] toMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_yd_cd", length));
			String[] webNtfyPicTelcmNo = (JSPUtil.getParameter(request, prefix	+ "web_ntfy_pic_telcm_no", length));
			String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "fx_ft_ovr_dys", length));
			String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_curr_cd", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] actCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cnt_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] fmMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_sts_cd", length));
			String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yd_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new IfSchemaVO();
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (webCreDt[i] != null)
					model.setWebCreDt(webCreDt[i]);
				if (toMvmtStsCd[i] != null)
					model.setToMvmtStsCd(toMvmtStsCd[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (sysAreaGrpId[i] != null)
					model.setSysAreaGrpId(sysAreaGrpId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (webMtyDt[i] != null)
					model.setWebMtyDt(webMtyDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (webNtfyPicNm[i] != null)
					model.setWebNtfyPicNm(webNtfyPicNm[i]);
				if (webCreUsrId[i] != null)
					model.setWebCreUsrId(webCreUsrId[i]);
				if (webIndFlg[i] != null)
					model.setWebIndFlg(webIndFlg[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				if (toMvmtYdCd[i] != null)
					model.setToMvmtYdCd(toMvmtYdCd[i]);
				if (webNtfyPicTelcmNo[i] != null)
					model.setWebNtfyPicTelcmNo(webNtfyPicTelcmNo[i]);
				if (fxFtOvrDys[i] != null)
					model.setFxFtOvrDys(fxFtOvrDys[i]);
				if (bzcTrfCurrCd[i] != null)
					model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (actCntCd[i] != null)
					model.setActCntCd(actCntCd[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (fmMvmtStsCd[i] != null)
					model.setFmMvmtStsCd(fmMvmtStsCd[i]);
				if (fmMvmtYdCd[i] != null)
					model.setFmMvmtYdCd(fmMvmtYdCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIfSchemaVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IfSchemaVO[]
	 */
	public IfSchemaVO[] getIfSchemaVOs(){
		IfSchemaVO[] vos = (IfSchemaVO[])models.toArray(new IfSchemaVO[models.size()]);
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
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webCreDt = this.webCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtStsCd = this.toMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysAreaGrpId = this.sysAreaGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webMtyDt = this.webMtyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webNtfyPicNm = this.webNtfyPicNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webCreUsrId = this.webCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webIndFlg = this.webIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtYdCd = this.toMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webNtfyPicTelcmNo = this.webNtfyPicTelcmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxFtOvrDys = this.fxFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfCurrCd = this.bzcTrfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCntCd = this.actCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtStsCd = this.fmMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYdCd = this.fmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
