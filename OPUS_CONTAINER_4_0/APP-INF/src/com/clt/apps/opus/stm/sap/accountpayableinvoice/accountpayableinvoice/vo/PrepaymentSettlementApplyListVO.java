/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PrepaymentSettlementApplyListVO.java
*@FileTitle : PrepaymentSettlementApplyListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.21  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo;

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

public class PrepaymentSettlementApplyListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrepaymentSettlementApplyListVO> models = new ArrayList<PrepaymentSettlementApplyListVO>();
	
	/* Column Info */
	private String apply = null;
	/* Column Info */
	private String invPayCurrCd = null;
	/* Column Info */
	private String amountUnpaid = null;
	/* Column Info */
	private String applyGlDate = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String rowId = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String taxUnpaid = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrNo = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String payCrossRateDt = null;
	/* Column Info */
	private String amountApply = null;
	/* Column Info */
	private String invDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PrepaymentSettlementApplyListVO() {}

	public PrepaymentSettlementApplyListVO(String ibflag, String pagerows, String rowId, String invSeq, String invNo, String vndrNo, String vndrLglEngNm, String invCurrCd, String invPayCurrCd, String invDt, String payCrossRateDt, String invDesc, String amountUnpaid, String taxUnpaid, String amountApply, String applyGlDate, String apply) {
		this.apply = apply;
		this.invPayCurrCd = invPayCurrCd;
		this.amountUnpaid = amountUnpaid;
		this.applyGlDate = applyGlDate;
		this.vndrLglEngNm = vndrLglEngNm;
		this.rowId = rowId;
		this.invSeq = invSeq;
		this.taxUnpaid = taxUnpaid;
		this.invCurrCd = invCurrCd;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.vndrNo = vndrNo;
		this.invDesc = invDesc;
		this.payCrossRateDt = payCrossRateDt;
		this.amountApply = amountApply;
		this.invDt = invDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apply", getApply());
		this.hashColumns.put("inv_pay_curr_cd", getInvPayCurrCd());
		this.hashColumns.put("amount_unpaid", getAmountUnpaid());
		this.hashColumns.put("apply_gl_date", getApplyGlDate());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("row_id", getRowId());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("tax_unpaid", getTaxUnpaid());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("pay_cross_rate_dt", getPayCrossRateDt());
		this.hashColumns.put("amount_apply", getAmountApply());
		this.hashColumns.put("inv_dt", getInvDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apply", "apply");
		this.hashFields.put("inv_pay_curr_cd", "invPayCurrCd");
		this.hashFields.put("amount_unpaid", "amountUnpaid");
		this.hashFields.put("apply_gl_date", "applyGlDate");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("row_id", "rowId");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("tax_unpaid", "taxUnpaid");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("pay_cross_rate_dt", "payCrossRateDt");
		this.hashFields.put("amount_apply", "amountApply");
		this.hashFields.put("inv_dt", "invDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return apply
	 */
	public String getApply() {
		return this.apply;
	}
	
	/**
	 * Column Info
	 * @return invPayCurrCd
	 */
	public String getInvPayCurrCd() {
		return this.invPayCurrCd;
	}
	
	/**
	 * Column Info
	 * @return amountUnpaid
	 */
	public String getAmountUnpaid() {
		return this.amountUnpaid;
	}
	
	/**
	 * Column Info
	 * @return applyGlDate
	 */
	public String getApplyGlDate() {
		return this.applyGlDate;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return rowId
	 */
	public String getRowId() {
		return this.rowId;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return taxUnpaid
	 */
	public String getTaxUnpaid() {
		return this.taxUnpaid;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
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
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
	}
	
	/**
	 * Column Info
	 * @return invDesc
	 */
	public String getInvDesc() {
		return this.invDesc;
	}
	
	/**
	 * Column Info
	 * @return payCrossRateDt
	 */
	public String getPayCrossRateDt() {
		return this.payCrossRateDt;
	}
	
	/**
	 * Column Info
	 * @return amountApply
	 */
	public String getAmountApply() {
		return this.amountApply;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
	}
	

	/**
	 * Column Info
	 * @param apply
	 */
	public void setApply(String apply) {
		this.apply = apply;
	}
	
	/**
	 * Column Info
	 * @param invPayCurrCd
	 */
	public void setInvPayCurrCd(String invPayCurrCd) {
		this.invPayCurrCd = invPayCurrCd;
	}
	
	/**
	 * Column Info
	 * @param amountUnpaid
	 */
	public void setAmountUnpaid(String amountUnpaid) {
		this.amountUnpaid = amountUnpaid;
	}
	
	/**
	 * Column Info
	 * @param applyGlDate
	 */
	public void setApplyGlDate(String applyGlDate) {
		this.applyGlDate = applyGlDate;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param rowId
	 */
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param taxUnpaid
	 */
	public void setTaxUnpaid(String taxUnpaid) {
		this.taxUnpaid = taxUnpaid;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
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
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
	}
	
	/**
	 * Column Info
	 * @param invDesc
	 */
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
	}
	
	/**
	 * Column Info
	 * @param payCrossRateDt
	 */
	public void setPayCrossRateDt(String payCrossRateDt) {
		this.payCrossRateDt = payCrossRateDt;
	}
	
	/**
	 * Column Info
	 * @param amountApply
	 */
	public void setAmountApply(String amountApply) {
		this.amountApply = amountApply;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
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
		setApply(JSPUtil.getParameter(request, prefix + "apply", ""));
		setInvPayCurrCd(JSPUtil.getParameter(request, prefix + "inv_pay_curr_cd", ""));
		setAmountUnpaid(JSPUtil.getParameter(request, prefix + "amount_unpaid", ""));
		setApplyGlDate(JSPUtil.getParameter(request, prefix + "apply_gl_date", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setRowId(JSPUtil.getParameter(request, prefix + "row_id", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setTaxUnpaid(JSPUtil.getParameter(request, prefix + "tax_unpaid", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setPayCrossRateDt(JSPUtil.getParameter(request, prefix + "pay_cross_rate_dt", ""));
		setAmountApply(JSPUtil.getParameter(request, prefix + "amount_apply", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrepaymentSettlementApplyListVO[]
	 */
	public PrepaymentSettlementApplyListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PrepaymentSettlementApplyListVO[]
	 */
	public PrepaymentSettlementApplyListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrepaymentSettlementApplyListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] apply = (JSPUtil.getParameter(request, prefix	+ "apply", length));
			String[] invPayCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_pay_curr_cd", length));
			String[] amountUnpaid = (JSPUtil.getParameter(request, prefix	+ "amount_unpaid", length));
			String[] applyGlDate = (JSPUtil.getParameter(request, prefix	+ "apply_gl_date", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] rowId = (JSPUtil.getParameter(request, prefix	+ "row_id", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] taxUnpaid = (JSPUtil.getParameter(request, prefix	+ "tax_unpaid", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] payCrossRateDt = (JSPUtil.getParameter(request, prefix	+ "pay_cross_rate_dt", length));
			String[] amountApply = (JSPUtil.getParameter(request, prefix	+ "amount_apply", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PrepaymentSettlementApplyListVO();
				if (apply[i] != null)
					model.setApply(apply[i]);
				if (invPayCurrCd[i] != null)
					model.setInvPayCurrCd(invPayCurrCd[i]);
				if (amountUnpaid[i] != null)
					model.setAmountUnpaid(amountUnpaid[i]);
				if (applyGlDate[i] != null)
					model.setApplyGlDate(applyGlDate[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (rowId[i] != null)
					model.setRowId(rowId[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (taxUnpaid[i] != null)
					model.setTaxUnpaid(taxUnpaid[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (payCrossRateDt[i] != null)
					model.setPayCrossRateDt(payCrossRateDt[i]);
				if (amountApply[i] != null)
					model.setAmountApply(amountApply[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrepaymentSettlementApplyListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrepaymentSettlementApplyListVO[]
	 */
	public PrepaymentSettlementApplyListVO[] getPrepaymentSettlementApplyListVOs(){
		PrepaymentSettlementApplyListVO[] vos = (PrepaymentSettlementApplyListVO[])models.toArray(new PrepaymentSettlementApplyListVO[models.size()]);
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
		this.apply = this.apply .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayCurrCd = this.invPayCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amountUnpaid = this.amountUnpaid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.applyGlDate = this.applyGlDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowId = this.rowId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxUnpaid = this.taxUnpaid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCrossRateDt = this.payCrossRateDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amountApply = this.amountApply .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
