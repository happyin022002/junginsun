/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMnrRprTrfHdrVO.java
*@FileTitle : CustomMnrRprTrfHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.10.15 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrRprTrfHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrRprTrfHdrVO> models = new ArrayList<CustomMnrRprTrfHdrVO>();
	
	/* Column Info */
	private String mnrMeasUtNm = null;
	/* Column Info */
	private String mnrTrfStsCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String mnrTrfKndNm = null;
	/* Column Info */
	private String preTrfNo = null;
	/* Column Info */
	private String mnrInpTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mnrTrfKndCd = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrTrfStsNm = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqKndNm = null;
	/* Column Info */
	private String mnrTrfStsDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String stsRefNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mnrTrfRmk = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String mnrMeasUtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrRprTrfHdrVO() {}

	public CustomMnrRprTrfHdrVO(String ibflag, String pagerows, String currCd, String mnrTrfStsCd, String preTrfNo, String mnrInpTpCd, String mnrTrfKndCd, String creDt, String aproOfcCd, String vndrNm, String effDt, String eqKndNm, String mnrTrfStsDt, String updUsrId, String updDt, String agmtNo, String eqKndCd, String creUsrNm, String stsRefNo, String creUsrId, String mnrTrfRmk, String trfNo, String vndrSeq, String rqstOfcCd, String mnrMeasUtCd, String mnrTrfKndNm, String mnrTrfStsNm, String mnrMeasUtNm) {
		this.mnrMeasUtNm = mnrMeasUtNm;
		this.mnrTrfStsCd = mnrTrfStsCd;
		this.currCd = currCd;
		this.mnrTrfKndNm = mnrTrfKndNm;
		this.preTrfNo = preTrfNo;
		this.mnrInpTpCd = mnrInpTpCd;
		this.creDt = creDt;
		this.mnrTrfKndCd = mnrTrfKndCd;
		this.aproOfcCd = aproOfcCd;
		this.pagerows = pagerows;
		this.mnrTrfStsNm = mnrTrfStsNm;
		this.vndrNm = vndrNm;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.eqKndNm = eqKndNm;
		this.mnrTrfStsDt = mnrTrfStsDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.agmtNo = agmtNo;
		this.eqKndCd = eqKndCd;
		this.creUsrNm = creUsrNm;
		this.stsRefNo = stsRefNo;
		this.creUsrId = creUsrId;
		this.mnrTrfRmk = mnrTrfRmk;
		this.trfNo = trfNo;
		this.vndrSeq = vndrSeq;
		this.rqstOfcCd = rqstOfcCd;
		this.mnrMeasUtCd = mnrMeasUtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_trf_sts_nm", getMnrTrfStsNm());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mnr_meas_ut_cd", getMnrMeasUtCd());
		this.hashColumns.put("mnr_trf_knd_nm", getMnrTrfKndNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mnr_trf_sts_dt", getMnrTrfStsDt());
		this.hashColumns.put("mnr_trf_knd_cd", getMnrTrfKndCd());
		this.hashColumns.put("sts_ref_no", getStsRefNo());
		this.hashColumns.put("mnr_trf_rmk", getMnrTrfRmk());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("eq_knd_nm", getEqKndNm());
		this.hashColumns.put("mnr_inp_tp_cd", getMnrInpTpCd());
		this.hashColumns.put("mnr_trf_sts_cd", getMnrTrfStsCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("mnr_meas_ut_nm", getMnrMeasUtNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pre_trf_no", getPreTrfNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_trf_sts_nm", "mnrTrfStsNm");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mnr_meas_ut_cd", "mnrMeasUtCd");
		this.hashFields.put("mnr_trf_knd_nm", "mnrTrfKndNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mnr_trf_sts_dt", "mnrTrfStsDt");
		this.hashFields.put("mnr_trf_knd_cd", "mnrTrfKndCd");
		this.hashFields.put("sts_ref_no", "stsRefNo");
		this.hashFields.put("mnr_trf_rmk", "mnrTrfRmk");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("eq_knd_nm", "eqKndNm");
		this.hashFields.put("mnr_inp_tp_cd", "mnrInpTpCd");
		this.hashFields.put("mnr_trf_sts_cd", "mnrTrfStsCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("mnr_meas_ut_nm", "mnrMeasUtNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pre_trf_no", "preTrfNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnrMeasUtNm
	 */
	public String getMnrMeasUtNm() {
		return this.mnrMeasUtNm;
	}
	
	/**
	 * Column Info
	 * @return mnrTrfStsCd
	 */
	public String getMnrTrfStsCd() {
		return this.mnrTrfStsCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return mnrTrfKndNm
	 */
	public String getMnrTrfKndNm() {
		return this.mnrTrfKndNm;
	}
	
	/**
	 * Column Info
	 * @return preTrfNo
	 */
	public String getPreTrfNo() {
		return this.preTrfNo;
	}
	
	/**
	 * Column Info
	 * @return mnrInpTpCd
	 */
	public String getMnrInpTpCd() {
		return this.mnrInpTpCd;
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
	 * @return mnrTrfKndCd
	 */
	public String getMnrTrfKndCd() {
		return this.mnrTrfKndCd;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
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
	 * @return mnrTrfStsNm
	 */
	public String getMnrTrfStsNm() {
		return this.mnrTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
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
	 * @return eqKndNm
	 */
	public String getEqKndNm() {
		return this.eqKndNm;
	}
	
	/**
	 * Column Info
	 * @return mnrTrfStsDt
	 */
	public String getMnrTrfStsDt() {
		return this.mnrTrfStsDt;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return stsRefNo
	 */
	public String getStsRefNo() {
		return this.stsRefNo;
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
	 * @return mnrTrfRmk
	 */
	public String getMnrTrfRmk() {
		return this.mnrTrfRmk;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return mnrMeasUtCd
	 */
	public String getMnrMeasUtCd() {
		return this.mnrMeasUtCd;
	}
	

	/**
	 * Column Info
	 * @param mnrMeasUtNm
	 */
	public void setMnrMeasUtNm(String mnrMeasUtNm) {
		this.mnrMeasUtNm = mnrMeasUtNm;
	}
	
	/**
	 * Column Info
	 * @param mnrTrfStsCd
	 */
	public void setMnrTrfStsCd(String mnrTrfStsCd) {
		this.mnrTrfStsCd = mnrTrfStsCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param mnrTrfKndNm
	 */
	public void setMnrTrfKndNm(String mnrTrfKndNm) {
		this.mnrTrfKndNm = mnrTrfKndNm;
	}
	
	/**
	 * Column Info
	 * @param preTrfNo
	 */
	public void setPreTrfNo(String preTrfNo) {
		this.preTrfNo = preTrfNo;
	}
	
	/**
	 * Column Info
	 * @param mnrInpTpCd
	 */
	public void setMnrInpTpCd(String mnrInpTpCd) {
		this.mnrInpTpCd = mnrInpTpCd;
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
	 * @param mnrTrfKndCd
	 */
	public void setMnrTrfKndCd(String mnrTrfKndCd) {
		this.mnrTrfKndCd = mnrTrfKndCd;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
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
	 * @param mnrTrfStsNm
	 */
	public void setMnrTrfStsNm(String mnrTrfStsNm) {
		this.mnrTrfStsNm = mnrTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
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
	 * @param eqKndNm
	 */
	public void setEqKndNm(String eqKndNm) {
		this.eqKndNm = eqKndNm;
	}
	
	/**
	 * Column Info
	 * @param mnrTrfStsDt
	 */
	public void setMnrTrfStsDt(String mnrTrfStsDt) {
		this.mnrTrfStsDt = mnrTrfStsDt;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param stsRefNo
	 */
	public void setStsRefNo(String stsRefNo) {
		this.stsRefNo = stsRefNo;
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
	 * @param mnrTrfRmk
	 */
	public void setMnrTrfRmk(String mnrTrfRmk) {
		this.mnrTrfRmk = mnrTrfRmk;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param mnrMeasUtCd
	 */
	public void setMnrMeasUtCd(String mnrMeasUtCd) {
		this.mnrMeasUtCd = mnrMeasUtCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMnrMeasUtNm(JSPUtil.getParameter(request, "mnr_meas_ut_nm", ""));
		setMnrTrfStsCd(JSPUtil.getParameter(request, "mnr_trf_sts_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setMnrTrfKndNm(JSPUtil.getParameter(request, "mnr_trf_knd_nm", ""));
		setPreTrfNo(JSPUtil.getParameter(request, "pre_trf_no", ""));
		setMnrInpTpCd(JSPUtil.getParameter(request, "mnr_inp_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMnrTrfKndCd(JSPUtil.getParameter(request, "mnr_trf_knd_cd", ""));
		setAproOfcCd(JSPUtil.getParameter(request, "apro_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMnrTrfStsNm(JSPUtil.getParameter(request, "mnr_trf_sts_nm", ""));
		setVndrNm(JSPUtil.getParameter(request, "vndr_nm", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqKndNm(JSPUtil.getParameter(request, "eq_knd_nm", ""));
		setMnrTrfStsDt(JSPUtil.getParameter(request, "mnr_trf_sts_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setCreUsrNm(JSPUtil.getParameter(request, "cre_usr_nm", ""));
		setStsRefNo(JSPUtil.getParameter(request, "sts_ref_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setMnrTrfRmk(JSPUtil.getParameter(request, "mnr_trf_rmk", ""));
		setTrfNo(JSPUtil.getParameter(request, "trf_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, "rqst_ofc_cd", ""));
		setMnrMeasUtCd(JSPUtil.getParameter(request, "mnr_meas_ut_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrRprTrfHdrVO[]
	 */
	public CustomMnrRprTrfHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrRprTrfHdrVO[]
	 */
	public CustomMnrRprTrfHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrRprTrfHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrMeasUtNm = (JSPUtil.getParameter(request, prefix	+ "mnr_meas_ut_nm", length));
			String[] mnrTrfStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_sts_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] mnrTrfKndNm = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_knd_nm", length));
			String[] preTrfNo = (JSPUtil.getParameter(request, prefix	+ "pre_trf_no", length));
			String[] mnrInpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inp_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mnrTrfKndCd = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_knd_cd", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrTrfStsNm = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_sts_nm", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqKndNm = (JSPUtil.getParameter(request, prefix	+ "eq_knd_nm", length));
			String[] mnrTrfStsDt = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_sts_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] stsRefNo = (JSPUtil.getParameter(request, prefix	+ "sts_ref_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mnrTrfRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_rmk", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] mnrMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "mnr_meas_ut_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrRprTrfHdrVO();
				if (mnrMeasUtNm[i] != null)
					model.setMnrMeasUtNm(mnrMeasUtNm[i]);
				if (mnrTrfStsCd[i] != null)
					model.setMnrTrfStsCd(mnrTrfStsCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (mnrTrfKndNm[i] != null)
					model.setMnrTrfKndNm(mnrTrfKndNm[i]);
				if (preTrfNo[i] != null)
					model.setPreTrfNo(preTrfNo[i]);
				if (mnrInpTpCd[i] != null)
					model.setMnrInpTpCd(mnrInpTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mnrTrfKndCd[i] != null)
					model.setMnrTrfKndCd(mnrTrfKndCd[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrTrfStsNm[i] != null)
					model.setMnrTrfStsNm(mnrTrfStsNm[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqKndNm[i] != null)
					model.setEqKndNm(eqKndNm[i]);
				if (mnrTrfStsDt[i] != null)
					model.setMnrTrfStsDt(mnrTrfStsDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (stsRefNo[i] != null)
					model.setStsRefNo(stsRefNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mnrTrfRmk[i] != null)
					model.setMnrTrfRmk(mnrTrfRmk[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (mnrMeasUtCd[i] != null)
					model.setMnrMeasUtCd(mnrMeasUtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrRprTrfHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrRprTrfHdrVO[]
	 */
	public CustomMnrRprTrfHdrVO[] getCustomMnrRprTrfHdrVOs(){
		CustomMnrRprTrfHdrVO[] vos = (CustomMnrRprTrfHdrVO[])models.toArray(new CustomMnrRprTrfHdrVO[models.size()]);
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
		this.mnrMeasUtNm = this.mnrMeasUtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfStsCd = this.mnrTrfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfKndNm = this.mnrTrfKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preTrfNo = this.preTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInpTpCd = this.mnrInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfKndCd = this.mnrTrfKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfStsNm = this.mnrTrfStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndNm = this.eqKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfStsDt = this.mnrTrfStsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsRefNo = this.stsRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfRmk = this.mnrTrfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrMeasUtCd = this.mnrMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
