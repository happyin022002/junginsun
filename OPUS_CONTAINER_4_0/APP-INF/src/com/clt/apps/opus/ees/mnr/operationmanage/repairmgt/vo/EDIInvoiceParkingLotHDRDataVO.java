/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EDIInvoiceParkingLotHDRDataVO.java
*@FileTitle : EDIInvoiceParkingLotHDRDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.26  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EDIInvoiceParkingLotHDRDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EDIInvoiceParkingLotHDRDataVO> models = new ArrayList<EDIInvoiceParkingLotHDRDataVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mnrRcvOrdInvTmpSeq = null;
	/* Column Info */
	private String creToDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String invCfmDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vrfyRsltDesc = null;
	/* Column Info */
	private String invWhldTaxAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ordHdrRmk = null;
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vatAmt = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String creFrDt = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vndrNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EDIInvoiceParkingLotHDRDataVO() {}

	public EDIInvoiceParkingLotHDRDataVO(String ibflag, String pagerows, String currCd, String vndrSeq, String invAmt, String vatAmt, String invWhldTaxAmt, String invNo, String rcvDt, String invCfmDt, String costOfcCd, String ordHdrRmk, String vrfyRsltDesc, String creDt, String updUsrId, String updDt, String creFrDt, String creToDt, String mnrRcvOrdInvTmpSeq, String rqstEqNo, String vndrNm) {
		this.updDt = updDt;
		this.mnrRcvOrdInvTmpSeq = mnrRcvOrdInvTmpSeq;
		this.creToDt = creToDt;
		this.currCd = currCd;
		this.costOfcCd = costOfcCd;
		this.invCfmDt = invCfmDt;
		this.creDt = creDt;
		this.vrfyRsltDesc = vrfyRsltDesc;
		this.invWhldTaxAmt = invWhldTaxAmt;
		this.pagerows = pagerows;
		this.ordHdrRmk = ordHdrRmk;
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.vatAmt = vatAmt;
		this.rqstEqNo = rqstEqNo;
		this.vndrSeq = vndrSeq;
		this.rcvDt = rcvDt;
		this.creFrDt = creFrDt;
		this.invAmt = invAmt;
		this.updUsrId = updUsrId;
		this.vndrNm = vndrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mnr_rcv_ord_inv_tmp_seq", getMnrRcvOrdInvTmpSeq());
		this.hashColumns.put("cre_to_dt", getCreToDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vrfy_rslt_desc", getVrfyRsltDesc());
		this.hashColumns.put("inv_whld_tax_amt", getInvWhldTaxAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ord_hdr_rmk", getOrdHdrRmk());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vat_amt", getVatAmt());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("cre_fr_dt", getCreFrDt());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vndr_nm", getVndrNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mnr_rcv_ord_inv_tmp_seq", "mnrRcvOrdInvTmpSeq");
		this.hashFields.put("cre_to_dt", "creToDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("inv_cfm_dt", "invCfmDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vrfy_rslt_desc", "vrfyRsltDesc");
		this.hashFields.put("inv_whld_tax_amt", "invWhldTaxAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ord_hdr_rmk", "ordHdrRmk");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vat_amt", "vatAmt");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("cre_fr_dt", "creFrDt");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vndr_nm", "vndrNm");
		return this.hashFields;
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
	 * @return mnrRcvOrdInvTmpSeq
	 */
	public String getMnrRcvOrdInvTmpSeq() {
		return this.mnrRcvOrdInvTmpSeq;
	}
	
	/**
	 * Column Info
	 * @return creToDt
	 */
	public String getCreToDt() {
		return this.creToDt;
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
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invCfmDt
	 */
	public String getInvCfmDt() {
		return this.invCfmDt;
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
	 * @return vrfyRsltDesc
	 */
	public String getVrfyRsltDesc() {
		return this.vrfyRsltDesc;
	}
	
	/**
	 * Column Info
	 * @return invWhldTaxAmt
	 */
	public String getInvWhldTaxAmt() {
		return this.invWhldTaxAmt;
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
	 * @return ordHdrRmk
	 */
	public String getOrdHdrRmk() {
		return this.ordHdrRmk;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return vatAmt
	 */
	public String getVatAmt() {
		return this.vatAmt;
	}
	
	/**
	 * Column Info
	 * @return rqstEqNo
	 */
	public String getRqstEqNo() {
		return this.rqstEqNo;
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
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return creFrDt
	 */
	public String getCreFrDt() {
		return this.creFrDt;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param mnrRcvOrdInvTmpSeq
	 */
	public void setMnrRcvOrdInvTmpSeq(String mnrRcvOrdInvTmpSeq) {
		this.mnrRcvOrdInvTmpSeq = mnrRcvOrdInvTmpSeq;
	}
	
	/**
	 * Column Info
	 * @param creToDt
	 */
	public void setCreToDt(String creToDt) {
		this.creToDt = creToDt;
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
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invCfmDt
	 */
	public void setInvCfmDt(String invCfmDt) {
		this.invCfmDt = invCfmDt;
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
	 * @param vrfyRsltDesc
	 */
	public void setVrfyRsltDesc(String vrfyRsltDesc) {
		this.vrfyRsltDesc = vrfyRsltDesc;
	}
	
	/**
	 * Column Info
	 * @param invWhldTaxAmt
	 */
	public void setInvWhldTaxAmt(String invWhldTaxAmt) {
		this.invWhldTaxAmt = invWhldTaxAmt;
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
	 * @param ordHdrRmk
	 */
	public void setOrdHdrRmk(String ordHdrRmk) {
		this.ordHdrRmk = ordHdrRmk;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param vatAmt
	 */
	public void setVatAmt(String vatAmt) {
		this.vatAmt = vatAmt;
	}
	
	/**
	 * Column Info
	 * @param rqstEqNo
	 */
	public void setRqstEqNo(String rqstEqNo) {
		this.rqstEqNo = rqstEqNo;
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
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param creFrDt
	 */
	public void setCreFrDt(String creFrDt) {
		this.creFrDt = creFrDt;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	public String getVndrNm() {
		return vndrNm;
	}

	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setMnrRcvOrdInvTmpSeq(JSPUtil.getParameter(request, prefix + "mnr_rcv_ord_inv_tmp_seq", ""));
		setCreToDt(JSPUtil.getParameter(request, prefix + "cre_to_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setInvCfmDt(JSPUtil.getParameter(request, prefix + "inv_cfm_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVrfyRsltDesc(JSPUtil.getParameter(request, prefix + "vrfy_rslt_desc", ""));
		setInvWhldTaxAmt(JSPUtil.getParameter(request, prefix + "inv_whld_tax_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOrdHdrRmk(JSPUtil.getParameter(request, prefix + "ord_hdr_rmk", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVatAmt(JSPUtil.getParameter(request, prefix + "vat_amt", ""));
		setRqstEqNo(JSPUtil.getParameter(request, prefix + "rqst_eq_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setCreFrDt(JSPUtil.getParameter(request, prefix + "cre_fr_dt", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EDIInvoiceParkingLotHDRDataVO[]
	 */
	public EDIInvoiceParkingLotHDRDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EDIInvoiceParkingLotHDRDataVO[]
	 */
	public EDIInvoiceParkingLotHDRDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EDIInvoiceParkingLotHDRDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mnrRcvOrdInvTmpSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_rcv_ord_inv_tmp_seq", length));
			String[] creToDt = (JSPUtil.getParameter(request, prefix	+ "cre_to_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] invCfmDt = (JSPUtil.getParameter(request, prefix	+ "inv_cfm_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vrfyRsltDesc = (JSPUtil.getParameter(request, prefix	+ "vrfy_rslt_desc", length));
			String[] invWhldTaxAmt = (JSPUtil.getParameter(request, prefix	+ "inv_whld_tax_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ordHdrRmk = (JSPUtil.getParameter(request, prefix	+ "ord_hdr_rmk", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vatAmt = (JSPUtil.getParameter(request, prefix	+ "vat_amt", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] creFrDt = (JSPUtil.getParameter(request, prefix	+ "cre_fr_dt", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new EDIInvoiceParkingLotHDRDataVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mnrRcvOrdInvTmpSeq[i] != null)
					model.setMnrRcvOrdInvTmpSeq(mnrRcvOrdInvTmpSeq[i]);
				if (creToDt[i] != null)
					model.setCreToDt(creToDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (invCfmDt[i] != null)
					model.setInvCfmDt(invCfmDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vrfyRsltDesc[i] != null)
					model.setVrfyRsltDesc(vrfyRsltDesc[i]);
				if (invWhldTaxAmt[i] != null)
					model.setInvWhldTaxAmt(invWhldTaxAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ordHdrRmk[i] != null)
					model.setOrdHdrRmk(ordHdrRmk[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vatAmt[i] != null)
					model.setVatAmt(vatAmt[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (creFrDt[i] != null)
					model.setCreFrDt(creFrDt[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEDIInvoiceParkingLotHDRDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EDIInvoiceParkingLotHDRDataVO[]
	 */
	public EDIInvoiceParkingLotHDRDataVO[] getEDIInvoiceParkingLotHDRDataVOs(){
		EDIInvoiceParkingLotHDRDataVO[] vos = (EDIInvoiceParkingLotHDRDataVO[])models.toArray(new EDIInvoiceParkingLotHDRDataVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRcvOrdInvTmpSeq = this.mnrRcvOrdInvTmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creToDt = this.creToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCfmDt = this.invCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vrfyRsltDesc = this.vrfyRsltDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invWhldTaxAmt = this.invWhldTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordHdrRmk = this.ordHdrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatAmt = this.vatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creFrDt = this.creFrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
