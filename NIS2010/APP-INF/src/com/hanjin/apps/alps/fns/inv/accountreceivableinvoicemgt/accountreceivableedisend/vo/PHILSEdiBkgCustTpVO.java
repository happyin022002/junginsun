/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PHILSEdiBkgCustTpVO.java
*@FileTitle : PHILSEdiBkgCustTpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.06  
* 1.0 Creation
=========================================================*/

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

public class PHILSEdiBkgCustTpVO extends AbstractValueObject { 

	private static final long serialVersionUID = 1L;
	
	private Collection<PHILSEdiBkgCustTpVO> models = new ArrayList<PHILSEdiBkgCustTpVO>();
	
	/* Column Info */ 
	private String pCustTp = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String custCtyNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String unLocCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PHILSEdiBkgCustTpVO() {}

	public PHILSEdiBkgCustTpVO(String ibflag, String pagerows, String pCustTp, String custNm, String custAddr, String custCtyNm, String unLocCd, String locCd) {
		this.pCustTp = pCustTp;
		this.custNm = custNm;
		this.custAddr = custAddr;
		this.custCtyNm = custCtyNm;
		this.pagerows = pagerows;
		this.unLocCd = unLocCd;
		this.ibflag = ibflag;
		this.locCd = locCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p_cust_tp", getPCustTp());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("cust_cty_nm", getCustCtyNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("un_loc_cd", getUnLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("p_cust_tp", "pCustTp");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("cust_cty_nm", "custCtyNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("un_loc_cd", "unLocCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pCustTp
	 */
	public String getPCustTp() {
		return this.pCustTp;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return custAddr
	 */
	public String getCustAddr() {
		return this.custAddr;
	}
	
	/**
	 * Column Info
	 * @return custCtyNm
	 */
	public String getCustCtyNm() {
		return this.custCtyNm;
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
	 * @return unLocCd
	 */
	public String getUnLocCd() {
		return this.unLocCd;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}

	/**
	 * Column Info
	 * @param pCustTp
	 */
	public void setPCustTp(String pCustTp) {
		this.pCustTp = pCustTp;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param custAddr
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	
	/**
	 * Column Info
	 * @param custCtyNm
	 */
	public void setCustCtyNm(String custCtyNm) {
		this.custCtyNm = custCtyNm;
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
	 * @param unLocCd
	 */
	public void setUnLocCd(String unLocCd) {
		this.unLocCd = unLocCd;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
		setPCustTp(JSPUtil.getParameter(request, prefix + "p_cust_tp", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCustAddr(JSPUtil.getParameter(request, prefix + "cust_addr", ""));
		setCustCtyNm(JSPUtil.getParameter(request, prefix + "cust_cty_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUnLocCd(JSPUtil.getParameter(request, prefix + "un_loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PHILSEdiBkgCustTpVO[]
	 */
	public PHILSEdiBkgCustTpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PHILSEdiBkgCustTpVO[]
	 */
	public PHILSEdiBkgCustTpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PHILSEdiBkgCustTpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pCustTp = (JSPUtil.getParameter(request, prefix	+ "p_cust_tp", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr", length));
			String[] custCtyNm = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] unLocCd = (JSPUtil.getParameter(request, prefix	+ "un_loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PHILSEdiBkgCustTpVO();
				if (pCustTp[i] != null)
					model.setPCustTp(pCustTp[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (custCtyNm[i] != null)
					model.setCustCtyNm(custCtyNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (unLocCd[i] != null)
					model.setUnLocCd(unLocCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPHILSEdiBkgCustTpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PHILSEdiBkgCustTpVO[]
	 */
	public PHILSEdiBkgCustTpVO[] getPHILSEdiBkgCustTpVOs(){
		PHILSEdiBkgCustTpVO[] vos = (PHILSEdiBkgCustTpVO[])models.toArray(new PHILSEdiBkgCustTpVO[models.size()]);
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
		this.pCustTp = this.pCustTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNm = this.custCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unLocCd = this.unLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
