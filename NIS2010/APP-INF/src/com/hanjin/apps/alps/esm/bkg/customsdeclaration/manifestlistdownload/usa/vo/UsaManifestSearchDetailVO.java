/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaManifestSearchDetailVO.java
*@FileTitle : UsaManifestSearchDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.12.11 김민정 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.04.02 김보배 [CHM-201323809] [BKG] [US AMS] MI 전송 화면 & Transmission & receiving history 화면 보완
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaManifestSearchDetailVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaManifestSearchDetailVO> models = new ArrayList<UsaManifestSearchDetailVO>();
	
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String selIsfActCd = null;
	/* Column Info */
	private String seal = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String cntrWt = null;
	/* Column Info */
	private String shprAd = null;
	/* Column Info */
	private String mfStsCode = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String cntrMk = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String filer = null;
	/* Column Info */
	private String pageGubun = null;
	/* Column Info */
	private String ntfyAd = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String wt = null;
	/* Column Info */
	private String transmitCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String cneeAd = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String cntrDs = null;
	/* Column Info */
	private String rowSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String cntrPk = null;
	/* Column Info */
	private String pk = null;
	/* Column Info */
	private String cgoTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaManifestSearchDetailVO() {}

	public UsaManifestSearchDetailVO(String ibflag, String pagerows, String blNo, String pol, String pod, String del, String pk, String wt, String shprNm, String shprAd, String cneeNm, String cneeAd, String ntfyNm, String ntfyAd, String cntrNo, String seal, String cntrPk, String cntrWt, String cntrMk, String cntrDs, String filer, String vvd, String transmitCd, String fullMtyCd, String usrId, String ofcCd, String eta, String rowSeq, String mfStsCode, String pageGubun, String selIsfActCd, String cgoTpCd) {
		this.eta = eta;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.selIsfActCd = selIsfActCd;
		this.seal = seal;
		this.usrId = usrId;
		this.pol = pol;
		this.cntrWt = cntrWt;
		this.shprAd = shprAd;
		this.mfStsCode = mfStsCode;
		this.del = del;
		this.shprNm = shprNm;
		this.cntrMk = cntrMk;
		this.pod = pod;
		this.filer = filer;
		this.pageGubun = pageGubun;
		this.ntfyAd = ntfyAd;
		this.ntfyNm = ntfyNm;
		this.wt = wt;
		this.transmitCd = transmitCd;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.cneeAd = cneeAd;
		this.cneeNm = cneeNm;
		this.cntrDs = cntrDs;
		this.rowSeq = rowSeq;
		this.cntrNo = cntrNo;
		this.fullMtyCd = fullMtyCd;
		this.cntrPk = cntrPk;
		this.pk = pk;
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sel_isf_act_cd", getSelIsfActCd());
		this.hashColumns.put("seal", getSeal());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("cntr_wt", getCntrWt());
		this.hashColumns.put("shpr_ad", getShprAd());
		this.hashColumns.put("mf_sts_code", getMfStsCode());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("cntr_mk", getCntrMk());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("filer", getFiler());
		this.hashColumns.put("page_gubun", getPageGubun());
		this.hashColumns.put("ntfy_ad", getNtfyAd());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("wt", getWt());
		this.hashColumns.put("transmit_cd", getTransmitCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cnee_ad", getCneeAd());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("cntr_ds", getCntrDs());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("cntr_pk", getCntrPk());
		this.hashColumns.put("pk", getPk());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta", "eta");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sel_isf_act_cd", "selIsfActCd");
		this.hashFields.put("seal", "seal");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("cntr_wt", "cntrWt");
		this.hashFields.put("shpr_ad", "shprAd");
		this.hashFields.put("mf_sts_code", "mfStsCode");
		this.hashFields.put("del", "del");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("cntr_mk", "cntrMk");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("filer", "filer");
		this.hashFields.put("page_gubun", "pageGubun");
		this.hashFields.put("ntfy_ad", "ntfyAd");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("wt", "wt");
		this.hashFields.put("transmit_cd", "transmitCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cnee_ad", "cneeAd");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("cntr_ds", "cntrDs");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("cntr_pk", "cntrPk");
		this.hashFields.put("pk", "pk");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return selIsfActCd
	 */
	public String getSelIsfActCd() {
		return this.selIsfActCd;
	}
	
	/**
	 * Column Info
	 * @return seal
	 */
	public String getSeal() {
		return this.seal;
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
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return cntrWt
	 */
	public String getCntrWt() {
		return this.cntrWt;
	}
	
	/**
	 * Column Info
	 * @return shprAd
	 */
	public String getShprAd() {
		return this.shprAd;
	}
	
	/**
	 * Column Info
	 * @return mfStsCode
	 */
	public String getMfStsCode() {
		return this.mfStsCode;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return cntrMk
	 */
	public String getCntrMk() {
		return this.cntrMk;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return filer
	 */
	public String getFiler() {
		return this.filer;
	}
	
	/**
	 * Column Info
	 * @return pageGubun
	 */
	public String getPageGubun() {
		return this.pageGubun;
	}
	
	/**
	 * Column Info
	 * @return ntfyAd
	 */
	public String getNtfyAd() {
		return this.ntfyAd;
	}
	
	/**
	 * Column Info
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
	}
	
	/**
	 * Column Info
	 * @return wt
	 */
	public String getWt() {
		return this.wt;
	}
	
	/**
	 * Column Info
	 * @return transmitCd
	 */
	public String getTransmitCd() {
		return this.transmitCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return cneeAd
	 */
	public String getCneeAd() {
		return this.cneeAd;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return cntrDs
	 */
	public String getCntrDs() {
		return this.cntrDs;
	}
	
	/**
	 * Column Info
	 * @return rowSeq
	 */
	public String getRowSeq() {
		return this.rowSeq;
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
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return cntrPk
	 */
	public String getCntrPk() {
		return this.cntrPk;
	}
	
	/**
	 * Column Info
	 * @return pk
	 */
	public String getPk() {
		return this.pk;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd(){
		return this.cgoTpCd;
	}
	

	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param selIsfActCd
	 */
	public void setSelIsfActCd(String selIsfActCd) {
		this.selIsfActCd = selIsfActCd;
	}
	
	/**
	 * Column Info
	 * @param seal
	 */
	public void setSeal(String seal) {
		this.seal = seal;
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
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param cntrWt
	 */
	public void setCntrWt(String cntrWt) {
		this.cntrWt = cntrWt;
	}
	
	/**
	 * Column Info
	 * @param shprAd
	 */
	public void setShprAd(String shprAd) {
		this.shprAd = shprAd;
	}
	
	/**
	 * Column Info
	 * @param mfStsCode
	 */
	public void setMfStsCode(String mfStsCode) {
		this.mfStsCode = mfStsCode;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param cntrMk
	 */
	public void setCntrMk(String cntrMk) {
		this.cntrMk = cntrMk;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param filer
	 */
	public void setFiler(String filer) {
		this.filer = filer;
	}
	
	/**
	 * Column Info
	 * @param pageGubun
	 */
	public void setPageGubun(String pageGubun) {
		this.pageGubun = pageGubun;
	}
	
	/**
	 * Column Info
	 * @param ntfyAd
	 */
	public void setNtfyAd(String ntfyAd) {
		this.ntfyAd = ntfyAd;
	}
	
	/**
	 * Column Info
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
	}
	
	/**
	 * Column Info
	 * @param wt
	 */
	public void setWt(String wt) {
		this.wt = wt;
	}
	
	/**
	 * Column Info
	 * @param transmitCd
	 */
	public void setTransmitCd(String transmitCd) {
		this.transmitCd = transmitCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param cneeAd
	 */
	public void setCneeAd(String cneeAd) {
		this.cneeAd = cneeAd;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param cntrDs
	 */
	public void setCntrDs(String cntrDs) {
		this.cntrDs = cntrDs;
	}
	
	/**
	 * Column Info
	 * @param rowSeq
	 */
	public void setRowSeq(String rowSeq) {
		this.rowSeq = rowSeq;
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
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param cntrPk
	 */
	public void setCntrPk(String cntrPk) {
		this.cntrPk = cntrPk;
	}
	
	/**
	 * Column Info
	 * @param pk
	 */
	public void setPk(String pk) {
		this.pk = pk;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd){
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSelIsfActCd(JSPUtil.getParameter(request, "sel_isf_act_cd", ""));
		setSeal(JSPUtil.getParameter(request, "seal", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setCntrWt(JSPUtil.getParameter(request, "cntr_wt", ""));
		setShprAd(JSPUtil.getParameter(request, "shpr_ad", ""));
		setMfStsCode(JSPUtil.getParameter(request, "mf_sts_code", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setShprNm(JSPUtil.getParameter(request, "shpr_nm", ""));
		setCntrMk(JSPUtil.getParameter(request, "cntr_mk", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setFiler(JSPUtil.getParameter(request, "filer", ""));
		setPageGubun(JSPUtil.getParameter(request, "page_gubun", ""));
		setNtfyAd(JSPUtil.getParameter(request, "ntfy_ad", ""));
		setNtfyNm(JSPUtil.getParameter(request, "ntfy_nm", ""));
		setWt(JSPUtil.getParameter(request, "wt", ""));
		setTransmitCd(JSPUtil.getParameter(request, "transmit_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCneeAd(JSPUtil.getParameter(request, "cnee_ad", ""));
		setCneeNm(JSPUtil.getParameter(request, "cnee_nm", ""));
		setCntrDs(JSPUtil.getParameter(request, "cntr_ds", ""));
		setRowSeq(JSPUtil.getParameter(request, "row_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setCntrPk(JSPUtil.getParameter(request, "cntr_pk", ""));
		setPk(JSPUtil.getParameter(request, "pk", ""));
		setPagerows(JSPUtil.getParameter(request, "cgo_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaManifestSearchDetailVO[]
	 */
	public UsaManifestSearchDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaManifestSearchDetailVO[]
	 */
	public UsaManifestSearchDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaManifestSearchDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] selIsfActCd = (JSPUtil.getParameter(request, prefix	+ "sel_isf_act_cd", length));
			String[] seal = (JSPUtil.getParameter(request, prefix	+ "seal", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] cntrWt = (JSPUtil.getParameter(request, prefix	+ "cntr_wt", length));
			String[] shprAd = (JSPUtil.getParameter(request, prefix	+ "shpr_ad", length));
			String[] mfStsCode = (JSPUtil.getParameter(request, prefix	+ "mf_sts_code", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] cntrMk = (JSPUtil.getParameter(request, prefix	+ "cntr_mk", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] filer = (JSPUtil.getParameter(request, prefix	+ "filer", length));
			String[] pageGubun = (JSPUtil.getParameter(request, prefix	+ "page_gubun", length));
			String[] ntfyAd = (JSPUtil.getParameter(request, prefix	+ "ntfy_ad", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] wt = (JSPUtil.getParameter(request, prefix	+ "wt", length));
			String[] transmitCd = (JSPUtil.getParameter(request, prefix	+ "transmit_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] cneeAd = (JSPUtil.getParameter(request, prefix	+ "cnee_ad", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] cntrDs = (JSPUtil.getParameter(request, prefix	+ "cntr_ds", length));
			String[] rowSeq = (JSPUtil.getParameter(request, prefix	+ "row_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] cntrPk = (JSPUtil.getParameter(request, prefix	+ "cntr_pk", length));
			String[] pk = (JSPUtil.getParameter(request, prefix	+ "pk", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaManifestSearchDetailVO();
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (selIsfActCd[i] != null)
					model.setSelIsfActCd(selIsfActCd[i]);
				if (seal[i] != null)
					model.setSeal(seal[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (cntrWt[i] != null)
					model.setCntrWt(cntrWt[i]);
				if (shprAd[i] != null)
					model.setShprAd(shprAd[i]);
				if (mfStsCode[i] != null)
					model.setMfStsCode(mfStsCode[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (cntrMk[i] != null)
					model.setCntrMk(cntrMk[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (filer[i] != null)
					model.setFiler(filer[i]);
				if (pageGubun[i] != null)
					model.setPageGubun(pageGubun[i]);
				if (ntfyAd[i] != null)
					model.setNtfyAd(ntfyAd[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (wt[i] != null)
					model.setWt(wt[i]);
				if (transmitCd[i] != null)
					model.setTransmitCd(transmitCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (cneeAd[i] != null)
					model.setCneeAd(cneeAd[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (cntrDs[i] != null)
					model.setCntrDs(cntrDs[i]);
				if (rowSeq[i] != null)
					model.setRowSeq(rowSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (cntrPk[i] != null)
					model.setCntrPk(cntrPk[i]);
				if (pk[i] != null)
					model.setPk(pk[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaManifestSearchDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaManifestSearchDetailVO[]
	 */
	public UsaManifestSearchDetailVO[] getUsaManifestSearchDetailVOs(){
		UsaManifestSearchDetailVO[] vos = (UsaManifestSearchDetailVO[])models.toArray(new UsaManifestSearchDetailVO[models.size()]);
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
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selIsfActCd = this.selIsfActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seal = this.seal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWt = this.cntrWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAd = this.shprAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfStsCode = this.mfStsCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMk = this.cntrMk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filer = this.filer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageGubun = this.pageGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAd = this.ntfyAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wt = this.wt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transmitCd = this.transmitCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAd = this.cneeAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDs = this.cntrDs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq = this.rowSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPk = this.cntrPk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pk = this.pk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
