/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomReceivableInvoiceDetailINVO.java
*@FileTitle : CustomReceivableInvoiceDetailINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.11.04 함형석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo;

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
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomReceivableInvoiceDetailINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomReceivableInvoiceDetailINVO> models = new ArrayList<CustomReceivableInvoiceDetailINVO>();
	
	/* Column Info */
	private String mnrVrfyTpCd = null;
	/* Column Info */
	private String dispTpCd = null;
	/* Column Info */
	private String dispSoldDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String mnrDispDtlRmk = null;
	/* Column Info */
	private String mnrPrnrLglEngNm = null;
	/* Column Info */
	private String dispQty = null;
	/* Column Info */
	private String dispDtlSeq = null;
	/* Column Info */
	private String dispTpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String dispYdCd = null;
	/* Column Info */
	private String partAmt = null;
	/* Column Info */
	private String rcvInvSeq = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String dispRlseNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomReceivableInvoiceDetailINVO() {}

	public CustomReceivableInvoiceDetailINVO(String ibflag, String pagerows, String mnrVrfyTpCd, String dispTpCd, String dispSoldDt, String currCd, String dispNo, String mnrDispDtlRmk, String mnrPrnrLglEngNm, String dispDtlSeq, String dispTpNm, String eqTpszCd, String invNo, String creUsrId, String eqNo, String dispYdCd, String partAmt, String invAmt, String rcvInvSeq, String dispRlseNo, String dispQty) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
		this.dispTpCd = dispTpCd;
		this.dispSoldDt = dispSoldDt;
		this.currCd = currCd;
		this.dispNo = dispNo;
		this.mnrDispDtlRmk = mnrDispDtlRmk;
		this.mnrPrnrLglEngNm = mnrPrnrLglEngNm;
		this.dispQty = dispQty;
		this.dispDtlSeq = dispDtlSeq;
		this.dispTpNm = dispTpNm;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.dispYdCd = dispYdCd;
		this.partAmt = partAmt;
		this.rcvInvSeq = rcvInvSeq;
		this.invAmt = invAmt;
		this.dispRlseNo = dispRlseNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_vrfy_tp_cd", getMnrVrfyTpCd());
		this.hashColumns.put("disp_tp_cd", getDispTpCd());
		this.hashColumns.put("disp_sold_dt", getDispSoldDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("mnr_disp_dtl_rmk", getMnrDispDtlRmk());
		this.hashColumns.put("mnr_prnr_lgl_eng_nm", getMnrPrnrLglEngNm());
		this.hashColumns.put("disp_qty", getDispQty());
		this.hashColumns.put("disp_dtl_seq", getDispDtlSeq());
		this.hashColumns.put("disp_tp_nm", getDispTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("disp_yd_cd", getDispYdCd());
		this.hashColumns.put("part_amt", getPartAmt());
		this.hashColumns.put("rcv_inv_seq", getRcvInvSeq());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("disp_rlse_no", getDispRlseNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_vrfy_tp_cd", "mnrVrfyTpCd");
		this.hashFields.put("disp_tp_cd", "dispTpCd");
		this.hashFields.put("disp_sold_dt", "dispSoldDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("mnr_disp_dtl_rmk", "mnrDispDtlRmk");
		this.hashFields.put("mnr_prnr_lgl_eng_nm", "mnrPrnrLglEngNm");
		this.hashFields.put("disp_qty", "dispQty");
		this.hashFields.put("disp_dtl_seq", "dispDtlSeq");
		this.hashFields.put("disp_tp_nm", "dispTpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("disp_yd_cd", "dispYdCd");
		this.hashFields.put("part_amt", "partAmt");
		this.hashFields.put("rcv_inv_seq", "rcvInvSeq");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("disp_rlse_no", "dispRlseNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnrVrfyTpCd
	 */
	public String getMnrVrfyTpCd() {
		return this.mnrVrfyTpCd;
	}
	
	/**
	 * Column Info
	 * @return dispTpCd
	 */
	public String getDispTpCd() {
		return this.dispTpCd;
	}
	
	/**
	 * Column Info
	 * @return dispSoldDt
	 */
	public String getDispSoldDt() {
		return this.dispSoldDt;
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
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return mnrDispDtlRmk
	 */
	public String getMnrDispDtlRmk() {
		return this.mnrDispDtlRmk;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrLglEngNm
	 */
	public String getMnrPrnrLglEngNm() {
		return this.mnrPrnrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return dispQty
	 */
	public String getDispQty() {
		return this.dispQty;
	}
	
	/**
	 * Column Info
	 * @return dispDtlSeq
	 */
	public String getDispDtlSeq() {
		return this.dispDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return dispTpNm
	 */
	public String getDispTpNm() {
		return this.dispTpNm;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return dispYdCd
	 */
	public String getDispYdCd() {
		return this.dispYdCd;
	}
	
	/**
	 * Column Info
	 * @return partAmt
	 */
	public String getPartAmt() {
		return this.partAmt;
	}
	
	/**
	 * Column Info
	 * @return rcvInvSeq
	 */
	public String getRcvInvSeq() {
		return this.rcvInvSeq;
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
	 * @return dispRlseNo
	 */
	public String getDispRlseNo() {
		return this.dispRlseNo;
	}
	

	/**
	 * Column Info
	 * @param mnrVrfyTpCd
	 */
	public void setMnrVrfyTpCd(String mnrVrfyTpCd) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
	}
	
	/**
	 * Column Info
	 * @param dispTpCd
	 */
	public void setDispTpCd(String dispTpCd) {
		this.dispTpCd = dispTpCd;
	}
	
	/**
	 * Column Info
	 * @param dispSoldDt
	 */
	public void setDispSoldDt(String dispSoldDt) {
		this.dispSoldDt = dispSoldDt;
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
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param mnrDispDtlRmk
	 */
	public void setMnrDispDtlRmk(String mnrDispDtlRmk) {
		this.mnrDispDtlRmk = mnrDispDtlRmk;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrLglEngNm
	 */
	public void setMnrPrnrLglEngNm(String mnrPrnrLglEngNm) {
		this.mnrPrnrLglEngNm = mnrPrnrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param dispQty
	 */
	public void setDispQty(String dispQty) {
		this.dispQty = dispQty;
	}
	
	/**
	 * Column Info
	 * @param dispDtlSeq
	 */
	public void setDispDtlSeq(String dispDtlSeq) {
		this.dispDtlSeq = dispDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param dispTpNm
	 */
	public void setDispTpNm(String dispTpNm) {
		this.dispTpNm = dispTpNm;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param dispYdCd
	 */
	public void setDispYdCd(String dispYdCd) {
		this.dispYdCd = dispYdCd;
	}
	
	/**
	 * Column Info
	 * @param partAmt
	 */
	public void setPartAmt(String partAmt) {
		this.partAmt = partAmt;
	}
	
	/**
	 * Column Info
	 * @param rcvInvSeq
	 */
	public void setRcvInvSeq(String rcvInvSeq) {
		this.rcvInvSeq = rcvInvSeq;
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
	 * @param dispRlseNo
	 */
	public void setDispRlseNo(String dispRlseNo) {
		this.dispRlseNo = dispRlseNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMnrVrfyTpCd(JSPUtil.getParameter(request, "mnr_vrfy_tp_cd", ""));
		setDispTpCd(JSPUtil.getParameter(request, "disp_tp_cd", ""));
		setDispSoldDt(JSPUtil.getParameter(request, "disp_sold_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setDispNo(JSPUtil.getParameter(request, "disp_no", ""));
		setMnrDispDtlRmk(JSPUtil.getParameter(request, "mnr_disp_dtl_rmk", ""));
		setMnrPrnrLglEngNm(JSPUtil.getParameter(request, "mnr_prnr_lgl_eng_nm", ""));
		setDispQty(JSPUtil.getParameter(request, "disp_qty", ""));
		setDispDtlSeq(JSPUtil.getParameter(request, "disp_dtl_seq", ""));
		setDispTpNm(JSPUtil.getParameter(request, "disp_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setDispYdCd(JSPUtil.getParameter(request, "disp_yd_cd", ""));
		setPartAmt(JSPUtil.getParameter(request, "part_amt", ""));
		setRcvInvSeq(JSPUtil.getParameter(request, "rcv_inv_seq", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setDispRlseNo(JSPUtil.getParameter(request, "disp_rlse_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomReceivableInvoiceDetailINVO[]
	 */
	public CustomReceivableInvoiceDetailINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomReceivableInvoiceDetailINVO[]
	 */
	public CustomReceivableInvoiceDetailINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomReceivableInvoiceDetailINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_vrfy_tp_cd", length));
			String[] dispTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_tp_cd", length));
			String[] dispSoldDt = (JSPUtil.getParameter(request, prefix	+ "disp_sold_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] mnrDispDtlRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_dtl_rmk", length));
			String[] mnrPrnrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_lgl_eng_nm", length));
			String[] dispQty = (JSPUtil.getParameter(request, prefix	+ "disp_qty", length));
			String[] dispDtlSeq = (JSPUtil.getParameter(request, prefix	+ "disp_dtl_seq", length));
			String[] dispTpNm = (JSPUtil.getParameter(request, prefix	+ "disp_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] dispYdCd = (JSPUtil.getParameter(request, prefix	+ "disp_yd_cd", length));
			String[] partAmt = (JSPUtil.getParameter(request, prefix	+ "part_amt", length));
			String[] rcvInvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_inv_seq", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] dispRlseNo = (JSPUtil.getParameter(request, prefix	+ "disp_rlse_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomReceivableInvoiceDetailINVO();
				if (mnrVrfyTpCd[i] != null)
					model.setMnrVrfyTpCd(mnrVrfyTpCd[i]);
				if (dispTpCd[i] != null)
					model.setDispTpCd(dispTpCd[i]);
				if (dispSoldDt[i] != null)
					model.setDispSoldDt(dispSoldDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (mnrDispDtlRmk[i] != null)
					model.setMnrDispDtlRmk(mnrDispDtlRmk[i]);
				if (mnrPrnrLglEngNm[i] != null)
					model.setMnrPrnrLglEngNm(mnrPrnrLglEngNm[i]);
				if (dispQty[i] != null)
					model.setDispQty(dispQty[i]);
				if (dispDtlSeq[i] != null)
					model.setDispDtlSeq(dispDtlSeq[i]);
				if (dispTpNm[i] != null)
					model.setDispTpNm(dispTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (dispYdCd[i] != null)
					model.setDispYdCd(dispYdCd[i]);
				if (partAmt[i] != null)
					model.setPartAmt(partAmt[i]);
				if (rcvInvSeq[i] != null)
					model.setRcvInvSeq(rcvInvSeq[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (dispRlseNo[i] != null)
					model.setDispRlseNo(dispRlseNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomReceivableInvoiceDetailINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomReceivableInvoiceDetailINVO[]
	 */
	public CustomReceivableInvoiceDetailINVO[] getCustomReceivableInvoiceDetailINVOs(){
		CustomReceivableInvoiceDetailINVO[] vos = (CustomReceivableInvoiceDetailINVO[])models.toArray(new CustomReceivableInvoiceDetailINVO[models.size()]);
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
		this.mnrVrfyTpCd = this.mnrVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTpCd = this.dispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispSoldDt = this.dispSoldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispDtlRmk = this.mnrDispDtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrLglEngNm = this.mnrPrnrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispQty = this.dispQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispDtlSeq = this.dispDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTpNm = this.dispTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispYdCd = this.dispYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partAmt = this.partAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvInvSeq = this.rcvInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRlseNo = this.dispRlseNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
