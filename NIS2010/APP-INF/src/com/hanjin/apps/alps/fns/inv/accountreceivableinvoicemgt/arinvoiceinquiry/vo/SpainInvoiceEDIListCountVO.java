/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpainInvoiceEDIListCountVO.java
*@FileTitle : SpainInvoiceEDIListCountVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2010.03.10 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpainInvoiceEDIListCountVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpainInvoiceEDIListCountVO> models = new ArrayList<SpainInvoiceEDIListCountVO>();
	
	/* Column Info */
	private String loclTotSum = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invCnt = null;
	/* Column Info */
	private String rowCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpainInvoiceEDIListCountVO() {}

	public SpainInvoiceEDIListCountVO(String ibflag, String pagerows, String rowCnt, String invCnt, String loclTotSum) {
		this.loclTotSum = loclTotSum;
		this.ibflag = ibflag;
		this.invCnt = invCnt;
		this.rowCnt = rowCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("locl_tot_sum", getLoclTotSum());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_cnt", getInvCnt());
		this.hashColumns.put("row_cnt", getRowCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("locl_tot_sum", "loclTotSum");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_cnt", "invCnt");
		this.hashFields.put("row_cnt", "rowCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return loclTotSum
	 */
	public String getLoclTotSum() {
		return this.loclTotSum;
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
	 * @return invCnt
	 */
	public String getInvCnt() {
		return this.invCnt;
	}
	
	/**
	 * Column Info
	 * @return rowCnt
	 */
	public String getRowCnt() {
		return this.rowCnt;
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
	 * @param loclTotSum
	 */
	public void setLoclTotSum(String loclTotSum) {
		this.loclTotSum = loclTotSum;
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
	 * @param invCnt
	 */
	public void setInvCnt(String invCnt) {
		this.invCnt = invCnt;
	}
	
	/**
	 * Column Info
	 * @param rowCnt
	 */
	public void setRowCnt(String rowCnt) {
		this.rowCnt = rowCnt;
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
		setLoclTotSum(JSPUtil.getParameter(request, prefix + "locl_tot_sum", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvCnt(JSPUtil.getParameter(request, prefix + "inv_cnt", ""));
		setRowCnt(JSPUtil.getParameter(request, prefix + "row_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpainInvoiceEDIListCountVO[]
	 */
	public SpainInvoiceEDIListCountVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpainInvoiceEDIListCountVO[]
	 */
	public SpainInvoiceEDIListCountVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpainInvoiceEDIListCountVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] loclTotSum = (JSPUtil.getParameter(request, prefix	+ "locl_tot_sum", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invCnt = (JSPUtil.getParameter(request, prefix	+ "inv_cnt", length));
			String[] rowCnt = (JSPUtil.getParameter(request, prefix	+ "row_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpainInvoiceEDIListCountVO();
				if (loclTotSum[i] != null)
					model.setLoclTotSum(loclTotSum[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invCnt[i] != null)
					model.setInvCnt(invCnt[i]);
				if (rowCnt[i] != null)
					model.setRowCnt(rowCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpainInvoiceEDIListCountVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpainInvoiceEDIListCountVO[]
	 */
	public SpainInvoiceEDIListCountVO[] getSpainInvoiceEDIListCountVOs(){
		SpainInvoiceEDIListCountVO[] vos = (SpainInvoiceEDIListCountVO[])models.toArray(new SpainInvoiceEDIListCountVO[models.size()]);
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
		this.loclTotSum = this.loclTotSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCnt = this.invCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCnt = this.rowCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
