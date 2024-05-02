/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceInterfaceARByDetailVO.java
*@FileTitle : InvoiceInterfaceARByDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.11.10 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceInterfaceARByDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceInterfaceARByDetailVO> models = new ArrayList<InvoiceInterfaceARByDetailVO>();
	
	/* Column Info */
	private String dmdtInvStsCd = null;
	/* Column Info */
	private String overDays = null;
	/* Column Info */
	private String invChgAmt = null;
	/* Column Info */
	private String dmdtInvNo = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dmdtSubInvNo = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String sessionOfcCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String crInvNo = null;
	/* Column Info */
	private String dmdtArIfCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceInterfaceARByDetailVO() {}

	public InvoiceInterfaceARByDetailVO(String ibflag, String pagerows, String dmdtInvNo, String dmdtArIfCd, String overDays, String invCurrCd, String invChgAmt, String taxAmt, String invAmt, String dmdtTrfCd, String blNo, String bkgNo, String crInvNo, String creOfcCd, String sessionOfcCd, String dmdtSubInvNo, String dmdtInvStsCd) {
		this.dmdtInvStsCd = dmdtInvStsCd;
		this.overDays = overDays;
		this.invChgAmt = invChgAmt;
		this.dmdtInvNo = dmdtInvNo;
		this.invCurrCd = invCurrCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.dmdtSubInvNo = dmdtSubInvNo;
		this.taxAmt = taxAmt;
		this.sessionOfcCd = sessionOfcCd;
		this.creOfcCd = creOfcCd;
		this.invAmt = invAmt;
		this.crInvNo = crInvNo;
		this.dmdtArIfCd = dmdtArIfCd;
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dmdt_inv_sts_cd", getDmdtInvStsCd());
		this.hashColumns.put("over_days", getOverDays());
		this.hashColumns.put("inv_chg_amt", getInvChgAmt());
		this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("dmdt_sub_inv_no", getDmdtSubInvNo());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("session_ofc_cd", getSessionOfcCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("cr_inv_no", getCrInvNo());
		this.hashColumns.put("dmdt_ar_if_cd", getDmdtArIfCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dmdt_inv_sts_cd", "dmdtInvStsCd");
		this.hashFields.put("over_days", "overDays");
		this.hashFields.put("inv_chg_amt", "invChgAmt");
		this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("dmdt_sub_inv_no", "dmdtSubInvNo");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("session_ofc_cd", "sessionOfcCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("cr_inv_no", "crInvNo");
		this.hashFields.put("dmdt_ar_if_cd", "dmdtArIfCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dmdtInvStsCd
	 */
	public String getDmdtInvStsCd() {
		return this.dmdtInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return overDays
	 */
	public String getOverDays() {
		return this.overDays;
	}
	
	/**
	 * Column Info
	 * @return invChgAmt
	 */
	public String getInvChgAmt() {
		return this.invChgAmt;
	}
	
	/**
	 * Column Info
	 * @return dmdtInvNo
	 */
	public String getDmdtInvNo() {
		return this.dmdtInvNo;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return dmdtSubInvNo
	 */
	public String getDmdtSubInvNo() {
		return this.dmdtSubInvNo;
	}
	
	/**
	 * Column Info
	 * @return taxAmt
	 */
	public String getTaxAmt() {
		return this.taxAmt;
	}
	
	/**
	 * Column Info
	 * @return sessionOfcCd
	 */
	public String getSessionOfcCd() {
		return this.sessionOfcCd;
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
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return crInvNo
	 */
	public String getCrInvNo() {
		return this.crInvNo;
	}
	
	/**
	 * Column Info
	 * @return dmdtArIfCd
	 */
	public String getDmdtArIfCd() {
		return this.dmdtArIfCd;
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
	 * @param dmdtInvStsCd
	 */
	public void setDmdtInvStsCd(String dmdtInvStsCd) {
		this.dmdtInvStsCd = dmdtInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param overDays
	 */
	public void setOverDays(String overDays) {
		this.overDays = overDays;
	}
	
	/**
	 * Column Info
	 * @param invChgAmt
	 */
	public void setInvChgAmt(String invChgAmt) {
		this.invChgAmt = invChgAmt;
	}
	
	/**
	 * Column Info
	 * @param dmdtInvNo
	 */
	public void setDmdtInvNo(String dmdtInvNo) {
		this.dmdtInvNo = dmdtInvNo;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param dmdtSubInvNo
	 */
	public void setDmdtSubInvNo(String dmdtSubInvNo) {
		this.dmdtSubInvNo = dmdtSubInvNo;
	}
	
	/**
	 * Column Info
	 * @param taxAmt
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}
	
	/**
	 * Column Info
	 * @param sessionOfcCd
	 */
	public void setSessionOfcCd(String sessionOfcCd) {
		this.sessionOfcCd = sessionOfcCd;
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
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param crInvNo
	 */
	public void setCrInvNo(String crInvNo) {
		this.crInvNo = crInvNo;
	}
	
	/**
	 * Column Info
	 * @param dmdtArIfCd
	 */
	public void setDmdtArIfCd(String dmdtArIfCd) {
		this.dmdtArIfCd = dmdtArIfCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDmdtInvStsCd(JSPUtil.getParameter(request, "dmdt_inv_sts_cd", ""));
		setOverDays(JSPUtil.getParameter(request, "over_days", ""));
		setInvChgAmt(JSPUtil.getParameter(request, "inv_chg_amt", ""));
		setDmdtInvNo(JSPUtil.getParameter(request, "dmdt_inv_no", ""));
		setInvCurrCd(JSPUtil.getParameter(request, "inv_curr_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDmdtSubInvNo(JSPUtil.getParameter(request, "dmdt_sub_inv_no", ""));
		setTaxAmt(JSPUtil.getParameter(request, "tax_amt", ""));
		setSessionOfcCd(JSPUtil.getParameter(request, "session_ofc_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setCrInvNo(JSPUtil.getParameter(request, "cr_inv_no", ""));
		setDmdtArIfCd(JSPUtil.getParameter(request, "dmdt_ar_if_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceInterfaceARByDetailVO[]
	 */
	public InvoiceInterfaceARByDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceInterfaceARByDetailVO[]
	 */
	public InvoiceInterfaceARByDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceInterfaceARByDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dmdtInvStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_sts_cd", length));
			String[] overDays = (JSPUtil.getParameter(request, prefix	+ "over_days", length));
			String[] invChgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_chg_amt", length));
			String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_no", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dmdtSubInvNo = (JSPUtil.getParameter(request, prefix	+ "dmdt_sub_inv_no", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] sessionOfcCd = (JSPUtil.getParameter(request, prefix	+ "session_ofc_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] crInvNo = (JSPUtil.getParameter(request, prefix	+ "cr_inv_no", length));
			String[] dmdtArIfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ar_if_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceInterfaceARByDetailVO();
				if (dmdtInvStsCd[i] != null)
					model.setDmdtInvStsCd(dmdtInvStsCd[i]);
				if (overDays[i] != null)
					model.setOverDays(overDays[i]);
				if (invChgAmt[i] != null)
					model.setInvChgAmt(invChgAmt[i]);
				if (dmdtInvNo[i] != null)
					model.setDmdtInvNo(dmdtInvNo[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dmdtSubInvNo[i] != null)
					model.setDmdtSubInvNo(dmdtSubInvNo[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (sessionOfcCd[i] != null)
					model.setSessionOfcCd(sessionOfcCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (crInvNo[i] != null)
					model.setCrInvNo(crInvNo[i]);
				if (dmdtArIfCd[i] != null)
					model.setDmdtArIfCd(dmdtArIfCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceInterfaceARByDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceInterfaceARByDetailVO[]
	 */
	public InvoiceInterfaceARByDetailVO[] getInvoiceInterfaceARByDetailVOs(){
		InvoiceInterfaceARByDetailVO[] vos = (InvoiceInterfaceARByDetailVO[])models.toArray(new InvoiceInterfaceARByDetailVO[models.size()]);
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
		this.dmdtInvStsCd = this.dmdtInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDays = this.overDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invChgAmt = this.invChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvNo = this.dmdtInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtSubInvNo = this.dmdtSubInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sessionOfcCd = this.sessionOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crInvNo = this.crInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtArIfCd = this.dmdtArIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
