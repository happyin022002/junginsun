/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceAccrualCondVO.java
*@FileTitle : InvoiceAccrualCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.11  
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

public class InvoiceAccrualCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceAccrualCondVO> models = new ArrayList<InvoiceAccrualCondVO>();
	
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String vndrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invDateFrom = null;
	/* Column Info */
	private String invDateTo = null;
	/* Column Info */
	private String accrualIfFlag = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvoiceAccrualCondVO() {}

	public InvoiceAccrualCondVO(String ibflag, String pagerows, String ofcCd, String vndrNo, String invNo, String accrualIfFlag, String invDateFrom, String invDateTo) {
		this.invNo = invNo;
		this.ofcCd = ofcCd;
		this.vndrNo = vndrNo;
		this.ibflag = ibflag;
		this.invDateFrom = invDateFrom;
		this.invDateTo = invDateTo;
		this.accrualIfFlag = accrualIfFlag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_date_from", getInvDateFrom());
		this.hashColumns.put("inv_date_to", getInvDateTo());
		this.hashColumns.put("accrual_if_flag", getAccrualIfFlag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_date_from", "invDateFrom");
		this.hashFields.put("inv_date_to", "invDateTo");
		this.hashFields.put("accrual_if_flag", "accrualIfFlag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
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
	 * @return invDateFrom
	 */
	public String getInvDateFrom() {
		return this.invDateFrom;
	}
	
	/**
	 * Column Info
	 * @return invDateTo
	 */
	public String getInvDateTo() {
		return this.invDateTo;
	}
	
	/**
	 * Column Info
	 * @return accrualIfFlag
	 */
	public String getAccrualIfFlag() {
		return this.accrualIfFlag;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
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
	 * @param invDateFrom
	 */
	public void setInvDateFrom(String invDateFrom) {
		this.invDateFrom = invDateFrom;
	}
	
	/**
	 * Column Info
	 * @param invDateTo
	 */
	public void setInvDateTo(String invDateTo) {
		this.invDateTo = invDateTo;
	}
	
	/**
	 * Column Info
	 * @param accrualIfFlag
	 */
	public void setAccrualIfFlag(String accrualIfFlag) {
		this.accrualIfFlag = accrualIfFlag;
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
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvDateFrom(JSPUtil.getParameter(request, prefix + "inv_date_from", ""));
		setInvDateTo(JSPUtil.getParameter(request, prefix + "inv_date_to", ""));
		setAccrualIfFlag(JSPUtil.getParameter(request, prefix + "accrual_if_flag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceAccrualCondVO[]
	 */
	public InvoiceAccrualCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceAccrualCondVO[]
	 */
	public InvoiceAccrualCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceAccrualCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invDateFrom = (JSPUtil.getParameter(request, prefix	+ "inv_date_from", length));
			String[] invDateTo = (JSPUtil.getParameter(request, prefix	+ "inv_date_to", length));
			String[] accrualIfFlag = (JSPUtil.getParameter(request, prefix	+ "accrual_if_flag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceAccrualCondVO();
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invDateFrom[i] != null)
					model.setInvDateFrom(invDateFrom[i]);
				if (invDateTo[i] != null)
					model.setInvDateTo(invDateTo[i]);
				if (accrualIfFlag[i] != null)
					model.setAccrualIfFlag(accrualIfFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceAccrualCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceAccrualCondVO[]
	 */
	public InvoiceAccrualCondVO[] getInvoiceAccrualCondVOs(){
		InvoiceAccrualCondVO[] vos = (InvoiceAccrualCondVO[])models.toArray(new InvoiceAccrualCondVO[models.size()]);
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
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDateFrom = this.invDateFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDateTo = this.invDateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accrualIfFlag = this.accrualIfFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
