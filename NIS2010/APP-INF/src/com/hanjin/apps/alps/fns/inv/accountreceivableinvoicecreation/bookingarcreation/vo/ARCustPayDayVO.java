/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ARCustPayDayVO.java
*@FileTitle : ARCustPayDayVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class ARCustPayDayVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARCustPayDayVO> models = new ArrayList<ARCustPayDayVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String payWkDyCd = null;
	/* Column Info */
	private String colPay3 = null;
	/* Column Info */
	private String colPay2 = null;
	/* Column Info */
	private String colPay1 = null;
	/* Column Info */
	private String colPay5 = null;
	/* Column Info */
	private String colPay4 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ARCustPayDayVO() {}

	public ARCustPayDayVO(String ibflag, String pagerows, String payWkDyCd, String colPay1, String colPay2, String colPay3, String colPay4, String colPay5) {
		this.ibflag = ibflag;
		this.payWkDyCd = payWkDyCd;
		this.colPay3 = colPay3;
		this.colPay2 = colPay2;
		this.colPay1 = colPay1;
		this.colPay5 = colPay5;
		this.colPay4 = colPay4;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pay_wk_dy_cd", getPayWkDyCd());
		this.hashColumns.put("col_pay_3", getColPay3());
		this.hashColumns.put("col_pay_2", getColPay2());
		this.hashColumns.put("col_pay_1", getColPay1());
		this.hashColumns.put("col_pay_5", getColPay5());
		this.hashColumns.put("col_pay_4", getColPay4());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pay_wk_dy_cd", "payWkDyCd");
		this.hashFields.put("col_pay_3", "colPay3");
		this.hashFields.put("col_pay_2", "colPay2");
		this.hashFields.put("col_pay_1", "colPay1");
		this.hashFields.put("col_pay_5", "colPay5");
		this.hashFields.put("col_pay_4", "colPay4");
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
	 * @return payWkDyCd
	 */
	public String getPayWkDyCd() {
		return this.payWkDyCd;
	}
	
	/**
	 * Column Info
	 * @return colPay3
	 */
	public String getColPay3() {
		return this.colPay3;
	}
	
	/**
	 * Column Info
	 * @return colPay2
	 */
	public String getColPay2() {
		return this.colPay2;
	}
	
	/**
	 * Column Info
	 * @return colPay1
	 */
	public String getColPay1() {
		return this.colPay1;
	}
	
	/**
	 * Column Info
	 * @return colPay5
	 */
	public String getColPay5() {
		return this.colPay5;
	}
	
	/**
	 * Column Info
	 * @return colPay4
	 */
	public String getColPay4() {
		return this.colPay4;
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
	 * @param payWkDyCd
	 */
	public void setPayWkDyCd(String payWkDyCd) {
		this.payWkDyCd = payWkDyCd;
	}
	
	/**
	 * Column Info
	 * @param colPay3
	 */
	public void setColPay3(String colPay3) {
		this.colPay3 = colPay3;
	}
	
	/**
	 * Column Info
	 * @param colPay2
	 */
	public void setColPay2(String colPay2) {
		this.colPay2 = colPay2;
	}
	
	/**
	 * Column Info
	 * @param colPay1
	 */
	public void setColPay1(String colPay1) {
		this.colPay1 = colPay1;
	}
	
	/**
	 * Column Info
	 * @param colPay5
	 */
	public void setColPay5(String colPay5) {
		this.colPay5 = colPay5;
	}
	
	/**
	 * Column Info
	 * @param colPay4
	 */
	public void setColPay4(String colPay4) {
		this.colPay4 = colPay4;
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
		setPayWkDyCd(JSPUtil.getParameter(request, prefix + "pay_wk_dy_cd", ""));
		setColPay3(JSPUtil.getParameter(request, prefix + "col_pay_3", ""));
		setColPay2(JSPUtil.getParameter(request, prefix + "col_pay_2", ""));
		setColPay1(JSPUtil.getParameter(request, prefix + "col_pay_1", ""));
		setColPay5(JSPUtil.getParameter(request, prefix + "col_pay_5", ""));
		setColPay4(JSPUtil.getParameter(request, prefix + "col_pay_4", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARCustPayDayVO[]
	 */
	public ARCustPayDayVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARCustPayDayVO[]
	 */
	public ARCustPayDayVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARCustPayDayVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] payWkDyCd = (JSPUtil.getParameter(request, prefix	+ "pay_wk_dy_cd", length));
			String[] colPay3 = (JSPUtil.getParameter(request, prefix	+ "col_pay_3", length));
			String[] colPay2 = (JSPUtil.getParameter(request, prefix	+ "col_pay_2", length));
			String[] colPay1 = (JSPUtil.getParameter(request, prefix	+ "col_pay_1", length));
			String[] colPay5 = (JSPUtil.getParameter(request, prefix	+ "col_pay_5", length));
			String[] colPay4 = (JSPUtil.getParameter(request, prefix	+ "col_pay_4", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARCustPayDayVO();
				if (payWkDyCd[i] != null)
					model.setPayWkDyCd(payWkDyCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (colPay3[i] != null)
					model.setColPay3(colPay3[i]);
				if (colPay2[i] != null)
					model.setColPay2(colPay2[i]);
				if (colPay1[i] != null)
					model.setColPay1(colPay1[i]);
				if (colPay5[i] != null)
					model.setColPay5(colPay5[i]);
				if (colPay4[i] != null)
					model.setColPay4(colPay4[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARCustPayDayVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARCustPayDayVO[]
	 */
	public ARCustPayDayVO[] getARCustPayDayVOs(){
		ARCustPayDayVO[] vos = (ARCustPayDayVO[])models.toArray(new ARCustPayDayVO[models.size()]);
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
		this.payWkDyCd = this.payWkDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colPay3 = this.colPay3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colPay2 = this.colPay2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colPay1 = this.colPay1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colPay5 = this.colPay5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colPay4 = this.colPay4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
