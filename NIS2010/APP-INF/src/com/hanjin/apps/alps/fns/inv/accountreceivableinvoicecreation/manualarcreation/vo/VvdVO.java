/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VvdVO.java
*@FileTitle : VvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VvdVO> models = new ArrayList<VvdVO>();
	
	/* Column Info */
	private String obVvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ibVvd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VvdVO() {}

	public VvdVO(String ibflag, String pagerows, String ibVvd, String obVvd) {
		this.obVvd = obVvd;
		this.ibflag = ibflag;
		this.ibVvd = ibVvd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ob_vvd", getObVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ib_vvd", getIbVvd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ob_vvd", "obVvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ib_vvd", "ibVvd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return obVvd
	 */
	public String getObVvd() {
		return this.obVvd;
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
	 * @return ibVvd
	 */
	public String getIbVvd() {
		return this.ibVvd;
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
	 * @param obVvd
	 */
	public void setObVvd(String obVvd) {
		this.obVvd = obVvd;
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
	 * @param ibVvd
	 */
	public void setIbVvd(String ibVvd) {
		this.ibVvd = ibVvd;
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
		setObVvd(JSPUtil.getParameter(request, prefix + "ob_vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setIbVvd(JSPUtil.getParameter(request, prefix + "ib_vvd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VvdVO[]
	 */
	public VvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VvdVO[]
	 */
	public VvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] obVvd = (JSPUtil.getParameter(request, prefix	+ "ob_vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ibVvd = (JSPUtil.getParameter(request, prefix	+ "ib_vvd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VvdVO();
				if (obVvd[i] != null)
					model.setObVvd(obVvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ibVvd[i] != null)
					model.setIbVvd(ibVvd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VvdVO[]
	 */
	public VvdVO[] getVvdVOs(){
		VvdVO[] vos = (VvdVO[])models.toArray(new VvdVO[models.size()]);
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
		this.obVvd = this.obVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibVvd = this.ibVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
