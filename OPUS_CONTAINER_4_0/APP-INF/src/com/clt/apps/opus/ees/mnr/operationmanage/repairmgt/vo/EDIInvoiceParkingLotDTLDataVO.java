/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EDIInvoiceParkingLotDTLDataVO.java
*@FileTitle : EDIInvoiceParkingLotDTLDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.22  
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

public class EDIInvoiceParkingLotDTLDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EDIInvoiceParkingLotDTLDataVO> models = new ArrayList<EDIInvoiceParkingLotDTLDataVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creToDt = null;
	/* Column Info */
	private String mnrRcvOrdInvTmpSeq = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ordDtlRmk = null;
	/* Column Info */
	private String rqstRefNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vrfyRsltDesc = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String mnrRcvOrdInvTmpDtlSeq = null;
	/* Column Info */
	private String creFrDt = null;
	/* Column Info */
	private String rprQty = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String cellValue = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rprRsltDt = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String costCdAll = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EDIInvoiceParkingLotDTLDataVO() {}

	public EDIInvoiceParkingLotDTLDataVO(String ibflag, String pagerows, String mnrRcvOrdInvTmpDtlSeq, String eqKndCd, String eqNo, String rprQty, String currCd, String invAmt, String rprRsltDt, String ydCd, String costCd, String vndrSeq, String ordDtlRmk, String vrfyRsltDesc, String rqstRefNo, String creDt, String invNo, String mnrRcvOrdInvTmpSeq, String updUsrId, String updDt, String cellValue, String creFrDt, String creToDt, String rqstEqNo, String vndrNm, String costCdAll) {
		this.updDt = updDt;
		this.creToDt = creToDt;
		this.mnrRcvOrdInvTmpSeq = mnrRcvOrdInvTmpSeq;
		this.currCd = currCd;
		this.ordDtlRmk = ordDtlRmk;
		this.rqstRefNo = rqstRefNo;
		this.creDt = creDt;
		this.vrfyRsltDesc = vrfyRsltDesc;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.costCd = costCd;
		this.rqstEqNo = rqstEqNo;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.mnrRcvOrdInvTmpDtlSeq = mnrRcvOrdInvTmpDtlSeq;
		this.creFrDt = creFrDt;
		this.rprQty = rprQty;
		this.invAmt = invAmt;
		this.cellValue = cellValue;
		this.updUsrId = updUsrId;
		this.rprRsltDt = rprRsltDt;
		this.vndrNm = vndrNm;
		this.costCdAll = costCdAll;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_to_dt", getCreToDt());
		this.hashColumns.put("mnr_rcv_ord_inv_tmp_seq", getMnrRcvOrdInvTmpSeq());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ord_dtl_rmk", getOrdDtlRmk());
		this.hashColumns.put("rqst_ref_no", getRqstRefNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vrfy_rslt_desc", getVrfyRsltDesc());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("mnr_rcv_ord_inv_tmp_dtl_seq", getMnrRcvOrdInvTmpDtlSeq());
		this.hashColumns.put("cre_fr_dt", getCreFrDt());
		this.hashColumns.put("rpr_qty", getRprQty());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("cell_value", getCellValue());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rpr_rslt_dt", getRprRsltDt());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("cost_cd_all", getCostCdAll());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_to_dt", "creToDt");
		this.hashFields.put("mnr_rcv_ord_inv_tmp_seq", "mnrRcvOrdInvTmpSeq");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ord_dtl_rmk", "ordDtlRmk");
		this.hashFields.put("rqst_ref_no", "rqstRefNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vrfy_rslt_desc", "vrfyRsltDesc");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("mnr_rcv_ord_inv_tmp_dtl_seq", "mnrRcvOrdInvTmpDtlSeq");
		this.hashFields.put("cre_fr_dt", "creFrDt");
		this.hashFields.put("rpr_qty", "rprQty");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("cell_value", "cellValue");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rpr_rslt_dt", "rprRsltDt");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("cost_cd_all", "costCdAll");
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
	 * @return creToDt
	 */
	public String getCreToDt() {
		return this.creToDt;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return ordDtlRmk
	 */
	public String getOrdDtlRmk() {
		return this.ordDtlRmk;
	}
	
	/**
	 * Column Info
	 * @return rqstRefNo
	 */
	public String getRqstRefNo() {
		return this.rqstRefNo;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return mnrRcvOrdInvTmpDtlSeq
	 */
	public String getMnrRcvOrdInvTmpDtlSeq() {
		return this.mnrRcvOrdInvTmpDtlSeq;
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
	 * @return rprQty
	 */
	public String getRprQty() {
		return this.rprQty;
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
	 * @return cellValue
	 */
	public String getCellValue() {
		return this.cellValue;
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
	 * @return rprRsltDt
	 */
	public String getRprRsltDt() {
		return this.rprRsltDt;
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
	 * @param creToDt
	 */
	public void setCreToDt(String creToDt) {
		this.creToDt = creToDt;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param ordDtlRmk
	 */
	public void setOrdDtlRmk(String ordDtlRmk) {
		this.ordDtlRmk = ordDtlRmk;
	}
	
	/**
	 * Column Info
	 * @param rqstRefNo
	 */
	public void setRqstRefNo(String rqstRefNo) {
		this.rqstRefNo = rqstRefNo;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param mnrRcvOrdInvTmpDtlSeq
	 */
	public void setMnrRcvOrdInvTmpDtlSeq(String mnrRcvOrdInvTmpDtlSeq) {
		this.mnrRcvOrdInvTmpDtlSeq = mnrRcvOrdInvTmpDtlSeq;
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
	 * @param rprQty
	 */
	public void setRprQty(String rprQty) {
		this.rprQty = rprQty;
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
	 * @param cellValue
	 */
	public void setCellValue(String cellValue) {
		this.cellValue = cellValue;
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
	 * @param rprRsltDt
	 */
	public void setRprRsltDt(String rprRsltDt) {
		this.rprRsltDt = rprRsltDt;
	}
	
	public String getVndrNm() {
		return vndrNm;
	}

	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}

	public String getCostCdAll() {
		return costCdAll;
	}

	public void setCostCdAll(String costCdAll) {
		this.costCdAll = costCdAll;
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
		setCreToDt(JSPUtil.getParameter(request, prefix + "cre_to_dt", ""));
		setMnrRcvOrdInvTmpSeq(JSPUtil.getParameter(request, prefix + "mnr_rcv_ord_inv_tmp_seq", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setOrdDtlRmk(JSPUtil.getParameter(request, prefix + "ord_dtl_rmk", ""));
		setRqstRefNo(JSPUtil.getParameter(request, prefix + "rqst_ref_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVrfyRsltDesc(JSPUtil.getParameter(request, prefix + "vrfy_rslt_desc", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setRqstEqNo(JSPUtil.getParameter(request, prefix + "rqst_eq_no", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setMnrRcvOrdInvTmpDtlSeq(JSPUtil.getParameter(request, prefix + "mnr_rcv_ord_inv_tmp_dtl_seq", ""));
		setCreFrDt(JSPUtil.getParameter(request, prefix + "cre_fr_dt", ""));
		setRprQty(JSPUtil.getParameter(request, prefix + "rpr_qty", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setCellValue(JSPUtil.getParameter(request, prefix + "cell_value", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRprRsltDt(JSPUtil.getParameter(request, prefix + "rpr_rslt_dt", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setCostCdAll(JSPUtil.getParameter(request, prefix + "cost_cd_all", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EDIInvoiceParkingLotDTLDataVO[]
	 */
	public EDIInvoiceParkingLotDTLDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EDIInvoiceParkingLotDTLDataVO[]
	 */
	public EDIInvoiceParkingLotDTLDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EDIInvoiceParkingLotDTLDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creToDt = (JSPUtil.getParameter(request, prefix	+ "cre_to_dt", length));
			String[] mnrRcvOrdInvTmpSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_rcv_ord_inv_tmp_seq", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ordDtlRmk = (JSPUtil.getParameter(request, prefix	+ "ord_dtl_rmk", length));
			String[] rqstRefNo = (JSPUtil.getParameter(request, prefix	+ "rqst_ref_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vrfyRsltDesc = (JSPUtil.getParameter(request, prefix	+ "vrfy_rslt_desc", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] mnrRcvOrdInvTmpDtlSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_rcv_ord_inv_tmp_dtl_seq", length));
			String[] creFrDt = (JSPUtil.getParameter(request, prefix	+ "cre_fr_dt", length));
			String[] rprQty = (JSPUtil.getParameter(request, prefix	+ "rpr_qty", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] cellValue = (JSPUtil.getParameter(request, prefix	+ "cell_value", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rprRsltDt = (JSPUtil.getParameter(request, prefix	+ "rpr_rslt_dt", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] costCdAll = (JSPUtil.getParameter(request, prefix	+ "cost_cd_all", length));
			
			for (int i = 0; i < length; i++) {
				model = new EDIInvoiceParkingLotDTLDataVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creToDt[i] != null)
					model.setCreToDt(creToDt[i]);
				if (mnrRcvOrdInvTmpSeq[i] != null)
					model.setMnrRcvOrdInvTmpSeq(mnrRcvOrdInvTmpSeq[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ordDtlRmk[i] != null)
					model.setOrdDtlRmk(ordDtlRmk[i]);
				if (rqstRefNo[i] != null)
					model.setRqstRefNo(rqstRefNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vrfyRsltDesc[i] != null)
					model.setVrfyRsltDesc(vrfyRsltDesc[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (mnrRcvOrdInvTmpDtlSeq[i] != null)
					model.setMnrRcvOrdInvTmpDtlSeq(mnrRcvOrdInvTmpDtlSeq[i]);
				if (creFrDt[i] != null)
					model.setCreFrDt(creFrDt[i]);
				if (rprQty[i] != null)
					model.setRprQty(rprQty[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (cellValue[i] != null)
					model.setCellValue(cellValue[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rprRsltDt[i] != null)
					model.setRprRsltDt(rprRsltDt[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (costCdAll[i] != null)
					model.setCostCdAll(costCdAll[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEDIInvoiceParkingLotDTLDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EDIInvoiceParkingLotDTLDataVO[]
	 */
	public EDIInvoiceParkingLotDTLDataVO[] getEDIInvoiceParkingLotDTLDataVOs(){
		EDIInvoiceParkingLotDTLDataVO[] vos = (EDIInvoiceParkingLotDTLDataVO[])models.toArray(new EDIInvoiceParkingLotDTLDataVO[models.size()]);
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
		this.creToDt = this.creToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRcvOrdInvTmpSeq = this.mnrRcvOrdInvTmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordDtlRmk = this.ordDtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRefNo = this.rqstRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vrfyRsltDesc = this.vrfyRsltDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRcvOrdInvTmpDtlSeq = this.mnrRcvOrdInvTmpDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creFrDt = this.creFrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprQty = this.rprQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cellValue = this.cellValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRsltDt = this.rprRsltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCdAll = this.costCdAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
