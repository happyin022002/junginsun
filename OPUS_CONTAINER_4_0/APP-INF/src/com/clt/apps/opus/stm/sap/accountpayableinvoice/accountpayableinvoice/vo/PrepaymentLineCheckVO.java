/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PrepaymentLineCheckVO.java
*@FileTitle : PrepaymentLineCheckVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.18  
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

public class PrepaymentLineCheckVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrepaymentLineCheckVO> models = new ArrayList<PrepaymentLineCheckVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dtrbAmt = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String dtrbLineNo = null;
	/* Column Info */
	private String applyAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PrepaymentLineCheckVO() {}

	public PrepaymentLineCheckVO(String ibflag, String pagerows, String invSeq, String dtrbLineNo, String dtrbAmt, String applyAmt) {
		this.ibflag = ibflag;
		this.dtrbAmt = dtrbAmt;
		this.invSeq = invSeq;
		this.dtrbLineNo = dtrbLineNo;
		this.applyAmt = applyAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dtrb_amt", getDtrbAmt());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("dtrb_line_no", getDtrbLineNo());
		this.hashColumns.put("apply_amt", getApplyAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dtrb_amt", "dtrbAmt");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("dtrb_line_no", "dtrbLineNo");
		this.hashFields.put("apply_amt", "applyAmt");
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
	 * @return dtrbAmt
	 */
	public String getDtrbAmt() {
		return this.dtrbAmt;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return dtrbLineNo
	 */
	public String getDtrbLineNo() {
		return this.dtrbLineNo;
	}
	
	/**
	 * Column Info
	 * @return applyAmt
	 */
	public String getApplyAmt() {
		return this.applyAmt;
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
	 * @param dtrbAmt
	 */
	public void setDtrbAmt(String dtrbAmt) {
		this.dtrbAmt = dtrbAmt;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param dtrbLineNo
	 */
	public void setDtrbLineNo(String dtrbLineNo) {
		this.dtrbLineNo = dtrbLineNo;
	}
	
	/**
	 * Column Info
	 * @param applyAmt
	 */
	public void setApplyAmt(String applyAmt) {
		this.applyAmt = applyAmt;
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
		setDtrbAmt(JSPUtil.getParameter(request, prefix + "dtrb_amt", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setDtrbLineNo(JSPUtil.getParameter(request, prefix + "dtrb_line_no", ""));
		setApplyAmt(JSPUtil.getParameter(request, prefix + "apply_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrepaymentLineCheckVO[]
	 */
	public PrepaymentLineCheckVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PrepaymentLineCheckVO[]
	 */
	public PrepaymentLineCheckVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrepaymentLineCheckVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dtrbAmt = (JSPUtil.getParameter(request, prefix	+ "dtrb_amt", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] dtrbLineNo = (JSPUtil.getParameter(request, prefix	+ "dtrb_line_no", length));
			String[] applyAmt = (JSPUtil.getParameter(request, prefix	+ "apply_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PrepaymentLineCheckVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dtrbAmt[i] != null)
					model.setDtrbAmt(dtrbAmt[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (dtrbLineNo[i] != null)
					model.setDtrbLineNo(dtrbLineNo[i]);
				if (applyAmt[i] != null)
					model.setApplyAmt(applyAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrepaymentLineCheckVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrepaymentLineCheckVO[]
	 */
	public PrepaymentLineCheckVO[] getPrepaymentLineCheckVOs(){
		PrepaymentLineCheckVO[] vos = (PrepaymentLineCheckVO[])models.toArray(new PrepaymentLineCheckVO[models.size()]);
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
		this.dtrbAmt = this.dtrbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbLineNo = this.dtrbLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.applyAmt = this.applyAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
