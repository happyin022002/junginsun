/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceSlipDetailListVO.java
*@FileTitle : InvoiceSlipDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.17  
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

public class InvoiceSlipDetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceSlipDetailListVO> models = new ArrayList<InvoiceSlipDetailListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vendorInvDate = null;
	/* Column Info */
	private String dtrbAmt = null;
	/* Column Info */
	private String dtrbDesc = null;
	/* Column Info */
	private String vatName = null;
	/* Column Info */
	private String dtrbVatCd = null;
	/* Column Info */
	private String lineTpLuCd = null;
	/* Column Info */
	private String acctgDt = null;
	/* Column Info */
	private String dtrbLineNo = null;
	/* Column Info */
	private String vendorInvNo = null;
	/* Column Info */
	private String acctgPstFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvoiceSlipDetailListVO() {}

	public InvoiceSlipDetailListVO(String ibflag, String pagerows, String dtrbLineNo, String lineTpLuCd, String acctgPstFlg, String acctgDt, String dtrbAmt, String dtrbVatCd, String vatName, String vendorInvNo, String vendorInvDate, String dtrbDesc) {
		this.ibflag = ibflag;
		this.vendorInvDate = vendorInvDate;
		this.dtrbAmt = dtrbAmt;
		this.dtrbDesc = dtrbDesc;
		this.vatName = vatName;
		this.dtrbVatCd = dtrbVatCd;
		this.lineTpLuCd = lineTpLuCd;
		this.acctgDt = acctgDt;
		this.dtrbLineNo = dtrbLineNo;
		this.vendorInvNo = vendorInvNo;
		this.acctgPstFlg = acctgPstFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vendor_inv_date", getVendorInvDate());
		this.hashColumns.put("dtrb_amt", getDtrbAmt());
		this.hashColumns.put("dtrb_desc", getDtrbDesc());
		this.hashColumns.put("vat_name", getVatName());
		this.hashColumns.put("dtrb_vat_cd", getDtrbVatCd());
		this.hashColumns.put("line_tp_lu_cd", getLineTpLuCd());
		this.hashColumns.put("acctg_dt", getAcctgDt());
		this.hashColumns.put("dtrb_line_no", getDtrbLineNo());
		this.hashColumns.put("vendor_inv_no", getVendorInvNo());
		this.hashColumns.put("acctg_pst_flg", getAcctgPstFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vendor_inv_date", "vendorInvDate");
		this.hashFields.put("dtrb_amt", "dtrbAmt");
		this.hashFields.put("dtrb_desc", "dtrbDesc");
		this.hashFields.put("vat_name", "vatName");
		this.hashFields.put("dtrb_vat_cd", "dtrbVatCd");
		this.hashFields.put("line_tp_lu_cd", "lineTpLuCd");
		this.hashFields.put("acctg_dt", "acctgDt");
		this.hashFields.put("dtrb_line_no", "dtrbLineNo");
		this.hashFields.put("vendor_inv_no", "vendorInvNo");
		this.hashFields.put("acctg_pst_flg", "acctgPstFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return vendorInvDate
	 */
	public String getVendorInvDate() {
		return this.vendorInvDate;
	}
	
	/**
	 * Column Info
	 * @return dtrbAmt
	 */
	public String getDtrbAmt() {
		return this.dtrbAmt;
	}
	
	/**
	 * Column Info
	 * @return dtrbDesc
	 */
	public String getDtrbDesc() {
		return this.dtrbDesc;
	}
	
	/**
	 * Column Info
	 * @return vatName
	 */
	public String getVatName() {
		return this.vatName;
	}
	
	/**
	 * Column Info
	 * @return dtrbVatCd
	 */
	public String getDtrbVatCd() {
		return this.dtrbVatCd;
	}
	
	/**
	 * Column Info
	 * @return lineTpLuCd
	 */
	public String getLineTpLuCd() {
		return this.lineTpLuCd;
	}
	
	/**
	 * Column Info
	 * @return acctgDt
	 */
	public String getAcctgDt() {
		return this.acctgDt;
	}
	
	/**
	 * Column Info
	 * @return dtrbLineNo
	 */
	public String getDtrbLineNo() {
		return this.dtrbLineNo;
	}
	
	/**
	 * Column Info
	 * @return vendorInvNo
	 */
	public String getVendorInvNo() {
		return this.vendorInvNo;
	}
	
	/**
	 * Column Info
	 * @return acctgPstFlg
	 */
	public String getAcctgPstFlg() {
		return this.acctgPstFlg;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param vendorInvDate
	 */
	public void setVendorInvDate(String vendorInvDate) {
		this.vendorInvDate = vendorInvDate;
	}
	
	/**
	 * Column Info
	 * @param dtrbAmt
	 */
	public void setDtrbAmt(String dtrbAmt) {
		this.dtrbAmt = dtrbAmt;
	}
	
	/**
	 * Column Info
	 * @param dtrbDesc
	 */
	public void setDtrbDesc(String dtrbDesc) {
		this.dtrbDesc = dtrbDesc;
	}
	
	/**
	 * Column Info
	 * @param vatName
	 */
	public void setVatName(String vatName) {
		this.vatName = vatName;
	}
	
	/**
	 * Column Info
	 * @param dtrbVatCd
	 */
	public void setDtrbVatCd(String dtrbVatCd) {
		this.dtrbVatCd = dtrbVatCd;
	}
	
	/**
	 * Column Info
	 * @param lineTpLuCd
	 */
	public void setLineTpLuCd(String lineTpLuCd) {
		this.lineTpLuCd = lineTpLuCd;
	}
	
	/**
	 * Column Info
	 * @param acctgDt
	 */
	public void setAcctgDt(String acctgDt) {
		this.acctgDt = acctgDt;
	}
	
	/**
	 * Column Info
	 * @param dtrbLineNo
	 */
	public void setDtrbLineNo(String dtrbLineNo) {
		this.dtrbLineNo = dtrbLineNo;
	}
	
	/**
	 * Column Info
	 * @param vendorInvNo
	 */
	public void setVendorInvNo(String vendorInvNo) {
		this.vendorInvNo = vendorInvNo;
	}
	
	/**
	 * Column Info
	 * @param acctgPstFlg
	 */
	public void setAcctgPstFlg(String acctgPstFlg) {
		this.acctgPstFlg = acctgPstFlg;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVendorInvDate(JSPUtil.getParameter(request, prefix + "vendor_inv_date", ""));
		setDtrbAmt(JSPUtil.getParameter(request, prefix + "dtrb_amt", ""));
		setDtrbDesc(JSPUtil.getParameter(request, prefix + "dtrb_desc", ""));
		setVatName(JSPUtil.getParameter(request, prefix + "vat_name", ""));
		setDtrbVatCd(JSPUtil.getParameter(request, prefix + "dtrb_vat_cd", ""));
		setLineTpLuCd(JSPUtil.getParameter(request, prefix + "line_tp_lu_cd", ""));
		setAcctgDt(JSPUtil.getParameter(request, prefix + "acctg_dt", ""));
		setDtrbLineNo(JSPUtil.getParameter(request, prefix + "dtrb_line_no", ""));
		setVendorInvNo(JSPUtil.getParameter(request, prefix + "vendor_inv_no", ""));
		setAcctgPstFlg(JSPUtil.getParameter(request, prefix + "acctg_pst_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceSlipDetailListVO[]
	 */
	public InvoiceSlipDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceSlipDetailListVO[]
	 */
	public InvoiceSlipDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceSlipDetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vendorInvDate = (JSPUtil.getParameter(request, prefix	+ "vendor_inv_date", length));
			String[] dtrbAmt = (JSPUtil.getParameter(request, prefix	+ "dtrb_amt", length));
			String[] dtrbDesc = (JSPUtil.getParameter(request, prefix	+ "dtrb_desc", length));
			String[] vatName = (JSPUtil.getParameter(request, prefix	+ "vat_name", length));
			String[] dtrbVatCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_vat_cd", length));
			String[] lineTpLuCd = (JSPUtil.getParameter(request, prefix	+ "line_tp_lu_cd", length));
			String[] acctgDt = (JSPUtil.getParameter(request, prefix	+ "acctg_dt", length));
			String[] dtrbLineNo = (JSPUtil.getParameter(request, prefix	+ "dtrb_line_no", length));
			String[] vendorInvNo = (JSPUtil.getParameter(request, prefix	+ "vendor_inv_no", length));
			String[] acctgPstFlg = (JSPUtil.getParameter(request, prefix	+ "acctg_pst_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceSlipDetailListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vendorInvDate[i] != null)
					model.setVendorInvDate(vendorInvDate[i]);
				if (dtrbAmt[i] != null)
					model.setDtrbAmt(dtrbAmt[i]);
				if (dtrbDesc[i] != null)
					model.setDtrbDesc(dtrbDesc[i]);
				if (vatName[i] != null)
					model.setVatName(vatName[i]);
				if (dtrbVatCd[i] != null)
					model.setDtrbVatCd(dtrbVatCd[i]);
				if (lineTpLuCd[i] != null)
					model.setLineTpLuCd(lineTpLuCd[i]);
				if (acctgDt[i] != null)
					model.setAcctgDt(acctgDt[i]);
				if (dtrbLineNo[i] != null)
					model.setDtrbLineNo(dtrbLineNo[i]);
				if (vendorInvNo[i] != null)
					model.setVendorInvNo(vendorInvNo[i]);
				if (acctgPstFlg[i] != null)
					model.setAcctgPstFlg(acctgPstFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceSlipDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceSlipDetailListVO[]
	 */
	public InvoiceSlipDetailListVO[] getInvoiceSlipDetailListVOs(){
		InvoiceSlipDetailListVO[] vos = (InvoiceSlipDetailListVO[])models.toArray(new InvoiceSlipDetailListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vendorInvDate = this.vendorInvDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbAmt = this.dtrbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbDesc = this.dtrbDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatName = this.vatName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbVatCd = this.dtrbVatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineTpLuCd = this.lineTpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgDt = this.acctgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbLineNo = this.dtrbLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vendorInvNo = this.vendorInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgPstFlg = this.acctgPstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
