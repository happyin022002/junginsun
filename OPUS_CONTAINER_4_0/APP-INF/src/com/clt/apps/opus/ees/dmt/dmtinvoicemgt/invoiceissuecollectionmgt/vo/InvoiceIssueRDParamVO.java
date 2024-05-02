/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueRDParamVO.java
*@FileTitle : InvoiceIssueRDParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.06  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceIssueRDParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceIssueRDParamVO> models = new ArrayList<InvoiceIssueRDParamVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String jspno = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String invoiceNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceIssueRDParamVO() {}

	public InvoiceIssueRDParamVO(String ibflag, String pagerows, String invoiceNo, String jspno, String creOfcCd) {
		this.ibflag = ibflag;
		this.jspno = jspno;
		this.creOfcCd = creOfcCd;
		this.invoiceNo = invoiceNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("jspno", getJspno());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
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
		this.hashFields.put("jspno", "jspno");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
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
	 * @return jspno
	 */
	public String getJspno() {
		return this.jspno;
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
	 * @param jspno
	 */
	public void setJspno(String jspno) {
		this.jspno = jspno;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setJspno(JSPUtil.getParameter(request, prefix + "jspno", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setInvoiceNo(JSPUtil.getParameter(request, prefix + "invoice_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceIssueRDParamVO[]
	 */
	public InvoiceIssueRDParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceIssueRDParamVO[]
	 */
	public InvoiceIssueRDParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceIssueRDParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] jspno = (JSPUtil.getParameter(request, prefix	+ "jspno", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] invoiceNo = (JSPUtil.getParameter(request, prefix	+ "invoice_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceIssueRDParamVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (jspno[i] != null)
					model.setJspno(jspno[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (invoiceNo[i] != null)
					model.setInvoiceNo(invoiceNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceIssueRDParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceIssueRDParamVO[]
	 */
	public InvoiceIssueRDParamVO[] getInvoiceIssueRDParamVOs(){
		InvoiceIssueRDParamVO[] vos = (InvoiceIssueRDParamVO[])models.toArray(new InvoiceIssueRDParamVO[models.size()]);
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
		this.jspno = this.jspno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceNo = this.invoiceNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
