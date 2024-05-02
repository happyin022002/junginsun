/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : DHLEdiTotalVO.java
 * @FileTitle : DHLEdiTotalVO
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.04.26
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.0
 * 2012.04.26 Sang-Hyun Kim
 * 1.0 Creation
 */
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DHLEdiTotalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DHLEdiTotalVO> models = new ArrayList<DHLEdiTotalVO>();
	
	/* Column Info */
	private String invVatRate = null;
	/* Column Info */
	private String invVatAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invTotalAmt = null;
	/* Column Info */
	private String invVatBasis = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DHLEdiTotalVO() {}

	public DHLEdiTotalVO(String ibflag, String pagerows, String invTotalAmt, String invVatBasis, String invVatRate, String invVatAmt) {
		this.invVatRate = invVatRate;
		this.invVatAmt = invVatAmt;
		this.ibflag = ibflag;
		this.invTotalAmt = invTotalAmt;
		this.invVatBasis = invVatBasis;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_vat_rate", getInvVatRate());
		this.hashColumns.put("inv_vat_amt", getInvVatAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_total_amt", getInvTotalAmt());
		this.hashColumns.put("inv_vat_basis", getInvVatBasis());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_vat_rate", "invVatRate");
		this.hashFields.put("inv_vat_amt", "invVatAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_total_amt", "invTotalAmt");
		this.hashFields.put("inv_vat_basis", "invVatBasis");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invVatRate
	 */
	public String getInvVatRate() {
		return this.invVatRate;
	}
	
	/**
	 * Column Info
	 * @return invVatAmt
	 */
	public String getInvVatAmt() {
		return this.invVatAmt;
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
	 * @return invTotalAmt
	 */
	public String getInvTotalAmt() {
		return this.invTotalAmt;
	}
	
	/**
	 * Column Info
	 * @return invVatBasis
	 */
	public String getInvVatBasis() {
		return this.invVatBasis;
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
	 * @param invVatRate
	 */
	public void setInvVatRate(String invVatRate) {
		this.invVatRate = invVatRate;
	}
	
	/**
	 * Column Info
	 * @param invVatAmt
	 */
	public void setInvVatAmt(String invVatAmt) {
		this.invVatAmt = invVatAmt;
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
	 * @param invTotalAmt
	 */
	public void setInvTotalAmt(String invTotalAmt) {
		this.invTotalAmt = invTotalAmt;
	}
	
	/**
	 * Column Info
	 * @param invVatBasis
	 */
	public void setInvVatBasis(String invVatBasis) {
		this.invVatBasis = invVatBasis;
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
		setInvVatRate(JSPUtil.getParameter(request, prefix + "inv_vat_rate", ""));
		setInvVatAmt(JSPUtil.getParameter(request, prefix + "inv_vat_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvTotalAmt(JSPUtil.getParameter(request, prefix + "inv_total_amt", ""));
		setInvVatBasis(JSPUtil.getParameter(request, prefix + "inv_vat_basis", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DHLEdiTotalVO[]
	 */
	public DHLEdiTotalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DHLEdiTotalVO[]
	 */
	public DHLEdiTotalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DHLEdiTotalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invVatRate = (JSPUtil.getParameter(request, prefix	+ "inv_vat_rate", length));
			String[] invVatAmt = (JSPUtil.getParameter(request, prefix	+ "inv_vat_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invTotalAmt = (JSPUtil.getParameter(request, prefix	+ "inv_total_amt", length));
			String[] invVatBasis = (JSPUtil.getParameter(request, prefix	+ "inv_vat_basis", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DHLEdiTotalVO();
				if (invVatRate[i] != null)
					model.setInvVatRate(invVatRate[i]);
				if (invVatAmt[i] != null)
					model.setInvVatAmt(invVatAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invTotalAmt[i] != null)
					model.setInvTotalAmt(invTotalAmt[i]);
				if (invVatBasis[i] != null)
					model.setInvVatBasis(invVatBasis[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDHLEdiTotalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DHLEdiTotalVO[]
	 */
	public DHLEdiTotalVO[] getDHLEdiTotalVOs(){
		DHLEdiTotalVO[] vos = (DHLEdiTotalVO[])models.toArray(new DHLEdiTotalVO[models.size()]);
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
		this.invVatRate = this.invVatRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatAmt = this.invVatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTotalAmt = this.invTotalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatBasis = this.invVatBasis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
