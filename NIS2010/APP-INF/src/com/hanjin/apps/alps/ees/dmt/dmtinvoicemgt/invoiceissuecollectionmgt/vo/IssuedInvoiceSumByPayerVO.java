/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : IssuedInvoiceSumByPayerVO.java
*@FileTitle : IssuedInvoiceSumByPayerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.26
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.05.26 김태균 
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

public class IssuedInvoiceSumByPayerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IssuedInvoiceSumByPayerVO> models = new ArrayList<IssuedInvoiceSumByPayerVO>();
	
	/* Column Info */
	private String tDcAmt = null;
	/* Column Info */
	private String tName = null;
	/* Column Info */
	private String tExptAmt = null;
	/* Column Info */
	private String tChrCnt = null;
	/* Column Info */
	private String tBilAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tIncurredAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tInvAmt = null;
	/* Column Info */
	private String tCurr = null;
	/* Column Info */
	private String tInvCurr = null;
	/* Column Info */
	private String tTaxAmt = null;
	/* Column Info */
	private String tInvChgAmt = null;
	/* Column Info */
	private String tCharges = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IssuedInvoiceSumByPayerVO() {}

	public IssuedInvoiceSumByPayerVO(String ibflag, String pagerows, String tCurr, String tName, String tCharges, String tIncurredAmt, String tExptAmt, String tDcAmt, String tBilAmt, String tInvCurr, String tChrCnt, String tInvChgAmt, String tTaxAmt, String tInvAmt) {
		this.tDcAmt = tDcAmt;
		this.tName = tName;
		this.tExptAmt = tExptAmt;
		this.tChrCnt = tChrCnt;
		this.tBilAmt = tBilAmt;
		this.pagerows = pagerows;
		this.tIncurredAmt = tIncurredAmt;
		this.ibflag = ibflag;
		this.tInvAmt = tInvAmt;
		this.tCurr = tCurr;
		this.tInvCurr = tInvCurr;
		this.tTaxAmt = tTaxAmt;
		this.tInvChgAmt = tInvChgAmt;
		this.tCharges = tCharges;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("t_dc_amt", getTDcAmt());
		this.hashColumns.put("t_name", getTName());
		this.hashColumns.put("t_expt_amt", getTExptAmt());
		this.hashColumns.put("t_chr_cnt", getTChrCnt());
		this.hashColumns.put("t_bil_amt", getTBilAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("t_incurred_amt", getTIncurredAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("t_inv_amt", getTInvAmt());
		this.hashColumns.put("t_curr", getTCurr());
		this.hashColumns.put("t_inv_curr", getTInvCurr());
		this.hashColumns.put("t_tax_amt", getTTaxAmt());
		this.hashColumns.put("t_inv_chg_amt", getTInvChgAmt());
		this.hashColumns.put("t_charges", getTCharges());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("t_dc_amt", "tDcAmt");
		this.hashFields.put("t_name", "tName");
		this.hashFields.put("t_expt_amt", "tExptAmt");
		this.hashFields.put("t_chr_cnt", "tChrCnt");
		this.hashFields.put("t_bil_amt", "tBilAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("t_incurred_amt", "tIncurredAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("t_inv_amt", "tInvAmt");
		this.hashFields.put("t_curr", "tCurr");
		this.hashFields.put("t_inv_curr", "tInvCurr");
		this.hashFields.put("t_tax_amt", "tTaxAmt");
		this.hashFields.put("t_inv_chg_amt", "tInvChgAmt");
		this.hashFields.put("t_charges", "tCharges");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tDcAmt
	 */
	public String getTDcAmt() {
		return this.tDcAmt;
	}
	
	/**
	 * Column Info
	 * @return tName
	 */
	public String getTName() {
		return this.tName;
	}
	
	/**
	 * Column Info
	 * @return tExptAmt
	 */
	public String getTExptAmt() {
		return this.tExptAmt;
	}
	
	/**
	 * Column Info
	 * @return tChrCnt
	 */
	public String getTChrCnt() {
		return this.tChrCnt;
	}
	
	/**
	 * Column Info
	 * @return tBilAmt
	 */
	public String getTBilAmt() {
		return this.tBilAmt;
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
	 * @return tIncurredAmt
	 */
	public String getTIncurredAmt() {
		return this.tIncurredAmt;
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
	 * @return tInvAmt
	 */
	public String getTInvAmt() {
		return this.tInvAmt;
	}
	
	/**
	 * Column Info
	 * @return tCurr
	 */
	public String getTCurr() {
		return this.tCurr;
	}
	
	/**
	 * Column Info
	 * @return tInvCurr
	 */
	public String getTInvCurr() {
		return this.tInvCurr;
	}
	
	/**
	 * Column Info
	 * @return tTaxAmt
	 */
	public String getTTaxAmt() {
		return this.tTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return tInvChgAmt
	 */
	public String getTInvChgAmt() {
		return this.tInvChgAmt;
	}
	
	/**
	 * Column Info
	 * @return tCharges
	 */
	public String getTCharges() {
		return this.tCharges;
	}
	

	/**
	 * Column Info
	 * @param tDcAmt
	 */
	public void setTDcAmt(String tDcAmt) {
		this.tDcAmt = tDcAmt;
	}
	
	/**
	 * Column Info
	 * @param tName
	 */
	public void setTName(String tName) {
		this.tName = tName;
	}
	
	/**
	 * Column Info
	 * @param tExptAmt
	 */
	public void setTExptAmt(String tExptAmt) {
		this.tExptAmt = tExptAmt;
	}
	
	/**
	 * Column Info
	 * @param tChrCnt
	 */
	public void setTChrCnt(String tChrCnt) {
		this.tChrCnt = tChrCnt;
	}
	
	/**
	 * Column Info
	 * @param tBilAmt
	 */
	public void setTBilAmt(String tBilAmt) {
		this.tBilAmt = tBilAmt;
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
	 * @param tIncurredAmt
	 */
	public void setTIncurredAmt(String tIncurredAmt) {
		this.tIncurredAmt = tIncurredAmt;
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
	 * @param tInvAmt
	 */
	public void setTInvAmt(String tInvAmt) {
		this.tInvAmt = tInvAmt;
	}
	
	/**
	 * Column Info
	 * @param tCurr
	 */
	public void setTCurr(String tCurr) {
		this.tCurr = tCurr;
	}
	
	/**
	 * Column Info
	 * @param tInvCurr
	 */
	public void setTInvCurr(String tInvCurr) {
		this.tInvCurr = tInvCurr;
	}
	
	/**
	 * Column Info
	 * @param tTaxAmt
	 */
	public void setTTaxAmt(String tTaxAmt) {
		this.tTaxAmt = tTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param tInvChgAmt
	 */
	public void setTInvChgAmt(String tInvChgAmt) {
		this.tInvChgAmt = tInvChgAmt;
	}
	
	/**
	 * Column Info
	 * @param tCharges
	 */
	public void setTCharges(String tCharges) {
		this.tCharges = tCharges;
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
		setTDcAmt(JSPUtil.getParameter(request, prefix + "t_dc_amt", ""));
		setTName(JSPUtil.getParameter(request, prefix + "t_name", ""));
		setTExptAmt(JSPUtil.getParameter(request, prefix + "t_expt_amt", ""));
		setTChrCnt(JSPUtil.getParameter(request, prefix + "t_chr_cnt", ""));
		setTBilAmt(JSPUtil.getParameter(request, prefix + "t_bil_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTIncurredAmt(JSPUtil.getParameter(request, prefix + "t_incurred_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTInvAmt(JSPUtil.getParameter(request, prefix + "t_inv_amt", ""));
		setTCurr(JSPUtil.getParameter(request, prefix + "t_curr", ""));
		setTInvCurr(JSPUtil.getParameter(request, prefix + "t_inv_curr", ""));
		setTTaxAmt(JSPUtil.getParameter(request, prefix + "t_tax_amt", ""));
		setTInvChgAmt(JSPUtil.getParameter(request, prefix + "t_inv_chg_amt", ""));
		setTCharges(JSPUtil.getParameter(request, prefix + "t_charges", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IssuedInvoiceSumByPayerVO[]
	 */
	public IssuedInvoiceSumByPayerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IssuedInvoiceSumByPayerVO[]
	 */
	public IssuedInvoiceSumByPayerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IssuedInvoiceSumByPayerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tDcAmt = (JSPUtil.getParameter(request, prefix	+ "t_dc_amt", length));
			String[] tName = (JSPUtil.getParameter(request, prefix	+ "t_name", length));
			String[] tExptAmt = (JSPUtil.getParameter(request, prefix	+ "t_expt_amt", length));
			String[] tChrCnt = (JSPUtil.getParameter(request, prefix	+ "t_chr_cnt", length));
			String[] tBilAmt = (JSPUtil.getParameter(request, prefix	+ "t_bil_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tIncurredAmt = (JSPUtil.getParameter(request, prefix	+ "t_incurred_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tInvAmt = (JSPUtil.getParameter(request, prefix	+ "t_inv_amt", length));
			String[] tCurr = (JSPUtil.getParameter(request, prefix	+ "t_curr", length));
			String[] tInvCurr = (JSPUtil.getParameter(request, prefix	+ "t_inv_curr", length));
			String[] tTaxAmt = (JSPUtil.getParameter(request, prefix	+ "t_tax_amt", length));
			String[] tInvChgAmt = (JSPUtil.getParameter(request, prefix	+ "t_inv_chg_amt", length));
			String[] tCharges = (JSPUtil.getParameter(request, prefix	+ "t_charges", length));
			
			for (int i = 0; i < length; i++) {
				model = new IssuedInvoiceSumByPayerVO();
				if (tDcAmt[i] != null)
					model.setTDcAmt(tDcAmt[i]);
				if (tName[i] != null)
					model.setTName(tName[i]);
				if (tExptAmt[i] != null)
					model.setTExptAmt(tExptAmt[i]);
				if (tChrCnt[i] != null)
					model.setTChrCnt(tChrCnt[i]);
				if (tBilAmt[i] != null)
					model.setTBilAmt(tBilAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tIncurredAmt[i] != null)
					model.setTIncurredAmt(tIncurredAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tInvAmt[i] != null)
					model.setTInvAmt(tInvAmt[i]);
				if (tCurr[i] != null)
					model.setTCurr(tCurr[i]);
				if (tInvCurr[i] != null)
					model.setTInvCurr(tInvCurr[i]);
				if (tTaxAmt[i] != null)
					model.setTTaxAmt(tTaxAmt[i]);
				if (tInvChgAmt[i] != null)
					model.setTInvChgAmt(tInvChgAmt[i]);
				if (tCharges[i] != null)
					model.setTCharges(tCharges[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIssuedInvoiceSumByPayerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IssuedInvoiceSumByPayerVO[]
	 */
	public IssuedInvoiceSumByPayerVO[] getIssuedInvoiceSumByPayerVOs(){
		IssuedInvoiceSumByPayerVO[] vos = (IssuedInvoiceSumByPayerVO[])models.toArray(new IssuedInvoiceSumByPayerVO[models.size()]);
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
		this.tDcAmt = this.tDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tName = this.tName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tExptAmt = this.tExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tChrCnt = this.tChrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tBilAmt = this.tBilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tIncurredAmt = this.tIncurredAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tInvAmt = this.tInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCurr = this.tCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tInvCurr = this.tInvCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tTaxAmt = this.tTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tInvChgAmt = this.tInvChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCharges = this.tCharges .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
