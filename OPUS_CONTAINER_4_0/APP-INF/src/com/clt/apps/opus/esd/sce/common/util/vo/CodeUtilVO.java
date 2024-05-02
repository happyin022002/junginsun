/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeUtilVO.java
*@FileTitle : CodeUtilVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.08.06 신한성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.common.util.vo;

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
 * @author 신한성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CodeUtilVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CodeUtilVO> models = new ArrayList<CodeUtilVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String textfield = null;
	/* Column Info */
	private String sltcd = null;
	/* Column Info */
	private String valuefield = null;
	/* Column Info */
	private String orderbyfield = null;
	/* Column Info */
	private String wherefield = null;
	/* Column Info */
	private String tablefield = null;
	/* Column Info */
	private String dist = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CodeUtilVO() {}

	public CodeUtilVO(String ibflag, String pagerows, String sltcd, String dist, String valuefield, String textfield, String tablefield, String wherefield, String orderbyfield) {
		this.ibflag = ibflag;
		this.textfield = textfield;
		this.sltcd = sltcd;
		this.valuefield = valuefield;
		this.orderbyfield = orderbyfield;
		this.wherefield = wherefield;
		this.tablefield = tablefield;
		this.dist = dist;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("textfield", getTextfield());
		this.hashColumns.put("sltcd", getSltcd());
		this.hashColumns.put("valuefield", getValuefield());
		this.hashColumns.put("orderbyfield", getOrderbyfield());
		this.hashColumns.put("wherefield", getWherefield());
		this.hashColumns.put("tablefield", getTablefield());
		this.hashColumns.put("dist", getDist());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("textfield", "textfield");
		this.hashFields.put("sltcd", "sltcd");
		this.hashFields.put("valuefield", "valuefield");
		this.hashFields.put("orderbyfield", "orderbyfield");
		this.hashFields.put("wherefield", "wherefield");
		this.hashFields.put("tablefield", "tablefield");
		this.hashFields.put("dist", "dist");
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
	 * @return textfield
	 */
	public String getTextfield() {
		return this.textfield;
	}
	
	/**
	 * Column Info
	 * @return sltcd
	 */
	public String getSltcd() {
		return this.sltcd;
	}
	
	/**
	 * Column Info
	 * @return valuefield
	 */
	public String getValuefield() {
		return this.valuefield;
	}
	
	/**
	 * Column Info
	 * @return orderbyfield
	 */
	public String getOrderbyfield() {
		return this.orderbyfield;
	}
	
	/**
	 * Column Info
	 * @return wherefield
	 */
	public String getWherefield() {
		return this.wherefield;
	}
	
	/**
	 * Column Info
	 * @return tablefield
	 */
	public String getTablefield() {
		return this.tablefield;
	}
	
	/**
	 * Column Info
	 * @return dist
	 */
	public String getDist() {
		return this.dist;
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
	 * @param textfield
	 */
	public void setTextfield(String textfield) {
		this.textfield = textfield;
	}
	
	/**
	 * Column Info
	 * @param sltcd
	 */
	public void setSltcd(String sltcd) {
		this.sltcd = sltcd;
	}
	
	/**
	 * Column Info
	 * @param valuefield
	 */
	public void setValuefield(String valuefield) {
		this.valuefield = valuefield;
	}
	
	/**
	 * Column Info
	 * @param orderbyfield
	 */
	public void setOrderbyfield(String orderbyfield) {
		this.orderbyfield = orderbyfield;
	}
	
	/**
	 * Column Info
	 * @param wherefield
	 */
	public void setWherefield(String wherefield) {
		this.wherefield = wherefield;
	}
	
	/**
	 * Column Info
	 * @param tablefield
	 */
	public void setTablefield(String tablefield) {
		this.tablefield = tablefield;
	}
	
	/**
	 * Column Info
	 * @param dist
	 */
	public void setDist(String dist) {
		this.dist = dist;
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
		setTextfield(JSPUtil.getParameter(request, "textfield", ""));
		setSltcd(JSPUtil.getParameter(request, "sltcd", ""));
		setValuefield(JSPUtil.getParameter(request, "valuefield", ""));
		setOrderbyfield(JSPUtil.getParameter(request, "orderbyfield", ""));
		setWherefield(JSPUtil.getParameter(request, "wherefield", ""));
		setTablefield(JSPUtil.getParameter(request, "tablefield", ""));
		setDist(JSPUtil.getParameter(request, "dist", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CodeUtilVO[]
	 */
	public CodeUtilVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CodeUtilVO[]
	 */
	public CodeUtilVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CodeUtilVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] textfield = (JSPUtil.getParameter(request, prefix	+ "textfield", length));
			String[] sltcd = (JSPUtil.getParameter(request, prefix	+ "sltcd", length));
			String[] valuefield = (JSPUtil.getParameter(request, prefix	+ "valuefield", length));
			String[] orderbyfield = (JSPUtil.getParameter(request, prefix	+ "orderbyfield", length));
			String[] wherefield = (JSPUtil.getParameter(request, prefix	+ "wherefield", length));
			String[] tablefield = (JSPUtil.getParameter(request, prefix	+ "tablefield", length));
			String[] dist = (JSPUtil.getParameter(request, prefix	+ "dist", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CodeUtilVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (textfield[i] != null)
					model.setTextfield(textfield[i]);
				if (sltcd[i] != null)
					model.setSltcd(sltcd[i]);
				if (valuefield[i] != null)
					model.setValuefield(valuefield[i]);
				if (orderbyfield[i] != null)
					model.setOrderbyfield(orderbyfield[i]);
				if (wherefield[i] != null)
					model.setWherefield(wherefield[i]);
				if (tablefield[i] != null)
					model.setTablefield(tablefield[i]);
				if (dist[i] != null)
					model.setDist(dist[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCodeUtilVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CodeUtilVO[]
	 */
	public CodeUtilVO[] getCodeUtilVOs(){
		CodeUtilVO[] vos = (CodeUtilVO[])models.toArray(new CodeUtilVO[models.size()]);
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
		this.textfield = this.textfield .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltcd = this.sltcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valuefield = this.valuefield .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderbyfield = this.orderbyfield .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wherefield = this.wherefield .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tablefield = this.tablefield .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dist = this.dist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
