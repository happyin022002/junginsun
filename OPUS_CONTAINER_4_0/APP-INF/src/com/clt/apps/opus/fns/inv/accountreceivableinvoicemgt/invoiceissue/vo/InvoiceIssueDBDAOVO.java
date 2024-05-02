/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueDBDAOVO.java
*@FileTitle : InvoiceIssueDBDAOVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.28 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceIssueDBDAOVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceIssueDBDAOVO> models = new ArrayList<InvoiceIssueDBDAOVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String chgCurr = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String arIfSerNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceIssueDBDAOVO() {}

	public InvoiceIssueDBDAOVO(String ibflag, String pagerows, String arIfNo, String arIfSerNo, String chgSeq, String chgCurr) {
		this.ibflag = ibflag;
		this.arIfNo = arIfNo;
		this.chgCurr = chgCurr;
		this.chgSeq = chgSeq;
		this.arIfSerNo = arIfSerNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("chg_curr", getChgCurr());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("ar_if_ser_no", getArIfSerNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("chg_curr", "chgCurr");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("ar_if_ser_no", "arIfSerNo");
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
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
	}
	
	/**
	 * Column Info
	 * @return chgCurr
	 */
	public String getChgCurr() {
		return this.chgCurr;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return arIfSerNo
	 */
	public String getArIfSerNo() {
		return this.arIfSerNo;
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
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	
	/**
	 * Column Info
	 * @param chgCurr
	 */
	public void setChgCurr(String chgCurr) {
		this.chgCurr = chgCurr;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param arIfSerNo
	 */
	public void setArIfSerNo(String arIfSerNo) {
		this.arIfSerNo = arIfSerNo;
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
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setChgCurr(JSPUtil.getParameter(request, "chg_curr", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setArIfSerNo(JSPUtil.getParameter(request, "ar_if_ser_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceIssueDBDAOVO[]
	 */
	public InvoiceIssueDBDAOVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceIssueDBDAOVO[]
	 */
	public InvoiceIssueDBDAOVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceIssueDBDAOVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] chgCurr = (JSPUtil.getParameter(request, prefix	+ "chg_curr", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] arIfSerNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_ser_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceIssueDBDAOVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (chgCurr[i] != null)
					model.setChgCurr(chgCurr[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (arIfSerNo[i] != null)
					model.setArIfSerNo(arIfSerNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceIssueDBDAOVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceIssueDBDAOVO[]
	 */
	public InvoiceIssueDBDAOVO[] getInvoiceIssueDBDAOVOs(){
		InvoiceIssueDBDAOVO[] vos = (InvoiceIssueDBDAOVO[])models.toArray(new InvoiceIssueDBDAOVO[models.size()]);
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
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCurr = this.chgCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfSerNo = this.arIfSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
