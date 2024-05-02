/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvIssGRPVO.java
*@FileTitle : InvIssGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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

public class InvoiceIssueSndToErpVO extends AbstractValueObject {
	
	private static final long serialVersionUID = 1L; 
	
	private Collection<InvoiceIssueSndToErpVO> models = new ArrayList<InvoiceIssueSndToErpVO>();
	
	/* Column Info */
	private String otssmrycd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private List<String> ifnolist = new ArrayList<String>();
	/* Column Info */
	private List<String> invnos = new ArrayList<String>();
	/* Column Info */
	private String ofccd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceIssueSndToErpVO() {}

	public InvoiceIssueSndToErpVO(String ibflag, String pagerows, List<String> invnos, List<String> ifnolist, String ofccd, String otssmrycd) {
		this.otssmrycd = otssmrycd;
		this.ibflag = ibflag;
		this.ifnolist = ifnolist;
		this.invnos = invnos;
		this.ofccd = ofccd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("otssmrycd", getOtssmrycd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ofccd", getOfccd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("otssmrycd", "otssmrycd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ifnolist", "ifnolist");
		this.hashFields.put("invnos", "invnos");
		this.hashFields.put("ofccd", "ofccd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return otssmrycd
	 */
	public String getOtssmrycd() {
		return this.otssmrycd;
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
	 * @return ifnolist
	 */
	public List<String> getIfnolist() {
		return this.ifnolist;
	}
	
	/**
	 * Column Info
	 * @return invnos
	 */
	public List<String> getInvnos() {
		return this.invnos;
	}
	
	/**
	 * Column Info
	 * @return ofccd
	 */
	public String getOfccd() {
		return this.ofccd;
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
	 * @param otssmrycd
	 */
	public void setOtssmrycd(String otssmrycd) {
		this.otssmrycd = otssmrycd;
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
	 * @param ifnolist
	 */
	public void setIfnolist(List<String> ifnolist) {
		this.ifnolist = ifnolist;
	}
	
	/**
	 * Column Info
	 * @param invnos
	 */
	public void setInvnos(List<String> invnos) {
		this.invnos = invnos;
	}
	
	/**
	 * Column Info
	 * @param ofccd
	 */
	public void setOfccd(String ofccd) {
		this.ofccd = ofccd;
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
		setOtssmrycd(JSPUtil.getParameter(request, prefix + "otssmrycd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOfccd(JSPUtil.getParameter(request, prefix + "ofccd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvIssGRPVO[]
	 */
	public InvoiceIssueSndToErpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvIssGRPVO[]
	 */
	public InvoiceIssueSndToErpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceIssueSndToErpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] otssmrycd = (JSPUtil.getParameter(request, prefix	+ "otssmrycd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ofccd = (JSPUtil.getParameter(request, prefix	+ "ofccd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceIssueSndToErpVO();
				if (otssmrycd[i] != null)
					model.setOtssmrycd(otssmrycd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ofccd[i] != null)
					model.setOfccd(ofccd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvIssGRPVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvIssGRPVO[]
	 */
	public InvoiceIssueSndToErpVO[] getInvIssGRPVOs(){
		InvoiceIssueSndToErpVO[] vos = (InvoiceIssueSndToErpVO[])models.toArray(new InvoiceIssueSndToErpVO[models.size()]);
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
		this.otssmrycd = this.otssmrycd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofccd = this.ofccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
