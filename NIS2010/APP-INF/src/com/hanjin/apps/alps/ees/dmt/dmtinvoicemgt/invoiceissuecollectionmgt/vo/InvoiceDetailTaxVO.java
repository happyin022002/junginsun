/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceDetailTaxVO.java
*@FileTitle : InvoiceDetailTaxVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.01.13 김태균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.lang.reflect.Field;
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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceDetailTaxVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceDetailTaxVO> models = new ArrayList<InvoiceDetailTaxVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dtlTaxRto = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String invDtlSeq = null;
	/* Column Info */
	private String dtlTaxAmt = null;
	/* Column Info */
	private String invoiceNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceDetailTaxVO() {}

	public InvoiceDetailTaxVO(String ibflag, String pagerows, String invoiceNo, String creOfcCd, String invDtlSeq, String dtlTaxRto, String dtlTaxAmt) {
		this.ibflag = ibflag;
		this.dtlTaxRto = dtlTaxRto;
		this.creOfcCd = creOfcCd;
		this.invDtlSeq = invDtlSeq;
		this.dtlTaxAmt = dtlTaxAmt;
		this.invoiceNo = invoiceNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dtl_tax_rto", getDtlTaxRto());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("inv_dtl_seq", getInvDtlSeq());
		this.hashColumns.put("dtl_tax_amt", getDtlTaxAmt());
		this.hashColumns.put("invoice_no", getInvoiceNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dtl_tax_rto", "dtlTaxRto");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("inv_dtl_seq", "invDtlSeq");
		this.hashFields.put("dtl_tax_amt", "dtlTaxAmt");
		this.hashFields.put("invoice_no", "invoiceNo");
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
	 * @return dtlTaxRto
	 */
	public String getDtlTaxRto() {
		return this.dtlTaxRto;
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
	 * @return invDtlSeq
	 */
	public String getInvDtlSeq() {
		return this.invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return dtlTaxAmt
	 */
	public String getDtlTaxAmt() {
		return this.dtlTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return invoiceNo
	 */
	public String getInvoiceNo() {
		return this.invoiceNo;
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
	 * @param dtlTaxRto
	 */
	public void setDtlTaxRto(String dtlTaxRto) {
		this.dtlTaxRto = dtlTaxRto;
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
	 * @param invDtlSeq
	 */
	public void setInvDtlSeq(String invDtlSeq) {
		this.invDtlSeq = invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param dtlTaxAmt
	 */
	public void setDtlTaxAmt(String dtlTaxAmt) {
		this.dtlTaxAmt = dtlTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param invoiceNo
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDtlTaxRto(JSPUtil.getParameter(request, "dtl_tax_rto", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setInvDtlSeq(JSPUtil.getParameter(request, "inv_dtl_seq", ""));
		setDtlTaxAmt(JSPUtil.getParameter(request, "dtl_tax_amt", ""));
		setInvoiceNo(JSPUtil.getParameter(request, "invoice_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceDetailTaxVO[]
	 */
	public InvoiceDetailTaxVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceDetailTaxVO[]
	 */
	public InvoiceDetailTaxVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceDetailTaxVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dtlTaxRto = (JSPUtil.getParameter(request, prefix	+ "dtl_tax_rto", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] invDtlSeq = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_seq", length));
			String[] dtlTaxAmt = (JSPUtil.getParameter(request, prefix	+ "dtl_tax_amt", length));
			String[] invoiceNo = (JSPUtil.getParameter(request, prefix	+ "invoice_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceDetailTaxVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dtlTaxRto[i] != null)
					model.setDtlTaxRto(dtlTaxRto[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (invDtlSeq[i] != null)
					model.setInvDtlSeq(invDtlSeq[i]);
				if (dtlTaxAmt[i] != null)
					model.setDtlTaxAmt(dtlTaxAmt[i]);
				if (invoiceNo[i] != null)
					model.setInvoiceNo(invoiceNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceDetailTaxVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceDetailTaxVO[]
	 */
	public InvoiceDetailTaxVO[] getInvoiceDetailTaxVOs(){
		InvoiceDetailTaxVO[] vos = (InvoiceDetailTaxVO[])models.toArray(new InvoiceDetailTaxVO[models.size()]);
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
		this.dtlTaxRto = this.dtlTaxRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlSeq = this.invDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlTaxAmt = this.dtlTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceNo = this.invoiceNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
