/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceSumVO.java
*@FileTitle : InvoiceSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.09.03 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceSumVO> models = new ArrayList<InvoiceSumVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grandLclTotal = null;
	/* Column Info */
	private String grandUsdTotal = null;
	/* Column Info */
	private String blCount = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceSumVO() {}

	public InvoiceSumVO(String ibflag, String pagerows, String blCount, String grandUsdTotal, String grandLclTotal) {
		this.ibflag = ibflag;
		this.grandLclTotal = grandLclTotal;
		this.grandUsdTotal = grandUsdTotal;
		this.blCount = blCount;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grand_lcl_total", getGrandLclTotal());
		this.hashColumns.put("grand_usd_total", getGrandUsdTotal());
		this.hashColumns.put("bl_count", getBlCount());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grand_lcl_total", "grandLclTotal");
		this.hashFields.put("grand_usd_total", "grandUsdTotal");
		this.hashFields.put("bl_count", "blCount");
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
	 * @return grandLclTotal
	 */
	public String getGrandLclTotal() {
		return this.grandLclTotal;
	}
	
	/**
	 * Column Info
	 * @return grandUsdTotal
	 */
	public String getGrandUsdTotal() {
		return this.grandUsdTotal;
	}
	
	/**
	 * Column Info
	 * @return blCount
	 */
	public String getBlCount() {
		return this.blCount;
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
	 * @param grandLclTotal
	 */
	public void setGrandLclTotal(String grandLclTotal) {
		this.grandLclTotal = grandLclTotal;
	}
	
	/**
	 * Column Info
	 * @param grandUsdTotal
	 */
	public void setGrandUsdTotal(String grandUsdTotal) {
		this.grandUsdTotal = grandUsdTotal;
	}
	
	/**
	 * Column Info
	 * @param blCount
	 */
	public void setBlCount(String blCount) {
		this.blCount = blCount;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGrandLclTotal(JSPUtil.getParameter(request, "grand_lcl_total", ""));
		setGrandUsdTotal(JSPUtil.getParameter(request, "grand_usd_total", ""));
		setBlCount(JSPUtil.getParameter(request, "bl_count", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceSumVO[]
	 */
	public InvoiceSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceSumVO[]
	 */
	public InvoiceSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grandLclTotal = (JSPUtil.getParameter(request, prefix	+ "grand_lcl_total", length));
			String[] grandUsdTotal = (JSPUtil.getParameter(request, prefix	+ "grand_usd_total", length));
			String[] blCount = (JSPUtil.getParameter(request, prefix	+ "bl_count", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceSumVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grandLclTotal[i] != null)
					model.setGrandLclTotal(grandLclTotal[i]);
				if (grandUsdTotal[i] != null)
					model.setGrandUsdTotal(grandUsdTotal[i]);
				if (blCount[i] != null)
					model.setBlCount(blCount[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceSumVO[]
	 */
	public InvoiceSumVO[] getInvoiceSumVOs(){
		InvoiceSumVO[] vos = (InvoiceSumVO[])models.toArray(new InvoiceSumVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grandLclTotal = this.grandLclTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grandUsdTotal = this.grandUsdTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCount = this.blCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
