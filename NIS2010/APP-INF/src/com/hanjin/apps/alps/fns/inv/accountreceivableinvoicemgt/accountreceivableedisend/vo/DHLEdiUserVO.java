/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : DHLEdiUserVO.java
 * @FileTitle : DHLEdiUserVO
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.04.27
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.0
 * 2012.04.27 Sang-Hyun Kim
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

public class DHLEdiUserVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DHLEdiUserVO> models = new ArrayList<DHLEdiUserVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ptCtaContact = null;
	/* Column Info */
	private String ptComNbr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DHLEdiUserVO() {}

	public DHLEdiUserVO(String ibflag, String pagerows, String ptCtaContact, String ptComNbr) {
		this.ibflag = ibflag;
		this.ptCtaContact = ptCtaContact;
		this.ptComNbr = ptComNbr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pt_cta_contact", getPtCtaContact());
		this.hashColumns.put("pt_com_nbr", getPtComNbr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pt_cta_contact", "ptCtaContact");
		this.hashFields.put("pt_com_nbr", "ptComNbr");
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
	 * @return ptCtaContact
	 */
	public String getPtCtaContact() {
		return this.ptCtaContact;
	}
	
	/**
	 * Column Info
	 * @return ptComNbr
	 */
	public String getPtComNbr() {
		return this.ptComNbr;
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
	 * @param ptCtaContact
	 */
	public void setPtCtaContact(String ptCtaContact) {
		this.ptCtaContact = ptCtaContact;
	}
	
	/**
	 * Column Info
	 * @param ptComNbr
	 */
	public void setPtComNbr(String ptComNbr) {
		this.ptComNbr = ptComNbr;
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
		setPtCtaContact(JSPUtil.getParameter(request, prefix + "pt_cta_contact", ""));
		setPtComNbr(JSPUtil.getParameter(request, prefix + "pt_com_nbr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DHLEdiUserVO[]
	 */
	public DHLEdiUserVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DHLEdiUserVO[]
	 */
	public DHLEdiUserVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DHLEdiUserVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ptCtaContact = (JSPUtil.getParameter(request, prefix	+ "pt_cta_contact", length));
			String[] ptComNbr = (JSPUtil.getParameter(request, prefix	+ "pt_com_nbr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DHLEdiUserVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ptCtaContact[i] != null)
					model.setPtCtaContact(ptCtaContact[i]);
				if (ptComNbr[i] != null)
					model.setPtComNbr(ptComNbr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDHLEdiUserVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DHLEdiUserVO[]
	 */
	public DHLEdiUserVO[] getDHLEdiUserVOs(){
		DHLEdiUserVO[] vos = (DHLEdiUserVO[])models.toArray(new DHLEdiUserVO[models.size()]);
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
		this.ptCtaContact = this.ptCtaContact .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptComNbr = this.ptComNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
