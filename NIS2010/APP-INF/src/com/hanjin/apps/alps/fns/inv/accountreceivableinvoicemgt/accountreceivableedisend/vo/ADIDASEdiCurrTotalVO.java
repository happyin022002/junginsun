/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : ADIDASEdiCurrTotalVO.java
 * @FileTitle : ADIDASEdiCurrTotalVO
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

public class ADIDASEdiCurrTotalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ADIDASEdiCurrTotalVO> models = new ArrayList<ADIDASEdiCurrTotalVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invPosCurramt = null;
	/* Column Info */
	private String invPosExchrate = null;
	/* Column Info */
	private String invPosCurrcde = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ADIDASEdiCurrTotalVO() {}

	public ADIDASEdiCurrTotalVO(String ibflag, String pagerows, String invPosCurrcde, String invPosCurramt, String invPosExchrate) {
		this.ibflag = ibflag;
		this.invPosCurramt = invPosCurramt;
		this.invPosExchrate = invPosExchrate;
		this.invPosCurrcde = invPosCurrcde;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_pos_curramt", getInvPosCurramt());
		this.hashColumns.put("inv_pos_exchrate", getInvPosExchrate());
		this.hashColumns.put("inv_pos_currcde", getInvPosCurrcde());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_pos_curramt", "invPosCurramt");
		this.hashFields.put("inv_pos_exchrate", "invPosExchrate");
		this.hashFields.put("inv_pos_currcde", "invPosCurrcde");
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
	 * @return invPosCurramt
	 */
	public String getInvPosCurramt() {
		return this.invPosCurramt;
	}
	
	/**
	 * Column Info
	 * @return invPosExchrate
	 */
	public String getInvPosExchrate() {
		return this.invPosExchrate;
	}
	
	/**
	 * Column Info
	 * @return invPosCurrcde
	 */
	public String getInvPosCurrcde() {
		return this.invPosCurrcde;
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
	 * @param invPosCurramt
	 */
	public void setInvPosCurramt(String invPosCurramt) {
		this.invPosCurramt = invPosCurramt;
	}
	
	/**
	 * Column Info
	 * @param invPosExchrate
	 */
	public void setInvPosExchrate(String invPosExchrate) {
		this.invPosExchrate = invPosExchrate;
	}
	
	/**
	 * Column Info
	 * @param invPosCurrcde
	 */
	public void setInvPosCurrcde(String invPosCurrcde) {
		this.invPosCurrcde = invPosCurrcde;
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
		setInvPosCurramt(JSPUtil.getParameter(request, prefix + "inv_pos_curramt", ""));
		setInvPosExchrate(JSPUtil.getParameter(request, prefix + "inv_pos_exchrate", ""));
		setInvPosCurrcde(JSPUtil.getParameter(request, prefix + "inv_pos_currcde", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ADIDASEdiCurrTotalVO[]
	 */
	public ADIDASEdiCurrTotalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ADIDASEdiCurrTotalVO[]
	 */
	public ADIDASEdiCurrTotalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ADIDASEdiCurrTotalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invPosCurramt = (JSPUtil.getParameter(request, prefix	+ "inv_pos_curramt", length));
			String[] invPosExchrate = (JSPUtil.getParameter(request, prefix	+ "inv_pos_exchrate", length));
			String[] invPosCurrcde = (JSPUtil.getParameter(request, prefix	+ "inv_pos_currcde", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ADIDASEdiCurrTotalVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invPosCurramt[i] != null)
					model.setInvPosCurramt(invPosCurramt[i]);
				if (invPosExchrate[i] != null)
					model.setInvPosExchrate(invPosExchrate[i]);
				if (invPosCurrcde[i] != null)
					model.setInvPosCurrcde(invPosCurrcde[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getADIDASEdiCurrTotalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ADIDASEdiCurrTotalVO[]
	 */
	public ADIDASEdiCurrTotalVO[] getADIDASEdiCurrTotalVOs(){
		ADIDASEdiCurrTotalVO[] vos = (ADIDASEdiCurrTotalVO[])models.toArray(new ADIDASEdiCurrTotalVO[models.size()]);
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
		this.invPosCurramt = this.invPosCurramt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPosExchrate = this.invPosExchrate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPosCurrcde = this.invPosCurrcde .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
