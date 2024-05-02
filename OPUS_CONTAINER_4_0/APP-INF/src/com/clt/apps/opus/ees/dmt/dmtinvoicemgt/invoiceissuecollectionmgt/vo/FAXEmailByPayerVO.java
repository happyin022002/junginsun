/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FAXEmailByPayerVO.java
*@FileTitle : FAXEmailByPayerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.12.17 김태균 
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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FAXEmailByPayerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FAXEmailByPayerVO> models = new ArrayList<FAXEmailByPayerVO>();
	
	/* Column Info */
	private String payerCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String faxNos = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fax = null;
	/* Column Info */
	private String payerGubun = null;
	/* Column Info */
	private String email = null;
	/* Column Info */
	private String emailNos = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FAXEmailByPayerVO() {}

	public FAXEmailByPayerVO(String ibflag, String pagerows, String payerCd, String payerGubun, String ofcCd, String dmdtTrfCd, String ioBndCd, String fax, String email, String faxNos, String emailNos) {
		this.payerCd = payerCd;
		this.ofcCd = ofcCd;
		this.faxNos = faxNos;
		this.ibflag = ibflag;
		this.fax = fax;
		this.payerGubun = payerGubun;
		this.email = email;
		this.emailNos = emailNos;
		this.ioBndCd = ioBndCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("payer_cd", getPayerCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("fax_nos", getFaxNos());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fax", getFax());
		this.hashColumns.put("payer_gubun", getPayerGubun());
		this.hashColumns.put("email", getEmail());
		this.hashColumns.put("email_nos", getEmailNos());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("payer_cd", "payerCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("fax_nos", "faxNos");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fax", "fax");
		this.hashFields.put("payer_gubun", "payerGubun");
		this.hashFields.put("email", "email");
		this.hashFields.put("email_nos", "emailNos");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return payerCd
	 */
	public String getPayerCd() {
		return this.payerCd;
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
	 * @return faxNos
	 */
	public String getFaxNos() {
		return this.faxNos;
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
	 * @return fax
	 */
	public String getFax() {
		return this.fax;
	}
	
	/**
	 * Column Info
	 * @return payerGubun
	 */
	public String getPayerGubun() {
		return this.payerGubun;
	}
	
	/**
	 * Column Info
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Column Info
	 * @return emailNos
	 */
	public String getEmailNos() {
		return this.emailNos;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
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
	 * @param payerCd
	 */
	public void setPayerCd(String payerCd) {
		this.payerCd = payerCd;
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
	 * @param faxNos
	 */
	public void setFaxNos(String faxNos) {
		this.faxNos = faxNos;
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
	 * @param fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	/**
	 * Column Info
	 * @param payerGubun
	 */
	public void setPayerGubun(String payerGubun) {
		this.payerGubun = payerGubun;
	}
	
	/**
	 * Column Info
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Column Info
	 * @param emailNos
	 */
	public void setEmailNos(String emailNos) {
		this.emailNos = emailNos;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
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
		setPayerCd(JSPUtil.getParameter(request, "payer_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setFaxNos(JSPUtil.getParameter(request, "fax_nos", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFax(JSPUtil.getParameter(request, "fax", ""));
		setPayerGubun(JSPUtil.getParameter(request, "payer_gubun", ""));
		setEmail(JSPUtil.getParameter(request, "email", ""));
		setEmailNos(JSPUtil.getParameter(request, "email_nos", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FAXEmailByPayerVO[]
	 */
	public FAXEmailByPayerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FAXEmailByPayerVO[]
	 */
	public FAXEmailByPayerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FAXEmailByPayerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payerCd = (JSPUtil.getParameter(request, prefix	+ "payer_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] faxNos = (JSPUtil.getParameter(request, prefix	+ "fax_nos", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fax = (JSPUtil.getParameter(request, prefix	+ "fax", length));
			String[] payerGubun = (JSPUtil.getParameter(request, prefix	+ "payer_gubun", length));
			String[] email = (JSPUtil.getParameter(request, prefix	+ "email", length));
			String[] emailNos = (JSPUtil.getParameter(request, prefix	+ "email_nos", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new FAXEmailByPayerVO();
				if (payerCd[i] != null)
					model.setPayerCd(payerCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (faxNos[i] != null)
					model.setFaxNos(faxNos[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fax[i] != null)
					model.setFax(fax[i]);
				if (payerGubun[i] != null)
					model.setPayerGubun(payerGubun[i]);
				if (email[i] != null)
					model.setEmail(email[i]);
				if (emailNos[i] != null)
					model.setEmailNos(emailNos[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFAXEmailByPayerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FAXEmailByPayerVO[]
	 */
	public FAXEmailByPayerVO[] getFAXEmailByPayerVOs(){
		FAXEmailByPayerVO[] vos = (FAXEmailByPayerVO[])models.toArray(new FAXEmailByPayerVO[models.size()]);
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
		this.payerCd = this.payerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNos = this.faxNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax = this.fax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerGubun = this.payerGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.email = this.email .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emailNos = this.emailNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
