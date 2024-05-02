/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EesEqr1031ConditionVO.java
*@FileTitle : EesEqr1031ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo;

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

public class EesEqr1031ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr1031ConditionVO> models = new ArrayList<EesEqr1031ConditionVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fOfccd = null;
	/* Column Info */
	private String fRhqcd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr1031ConditionVO() {}

	public EesEqr1031ConditionVO(String ibflag, String pagerows, String fRhqcd, String fOfccd) {
		this.ibflag = ibflag;
		this.fOfccd = fOfccd;
		this.fRhqcd = fRhqcd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_ofccd", getFOfccd());
		this.hashColumns.put("f_rhqcd", getFRhqcd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_ofccd", "fOfccd");
		this.hashFields.put("f_rhqcd", "fRhqcd");
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
	 * @return fOfccd
	 */
	public String getFOfccd() {
		return this.fOfccd;
	}
	
	/**
	 * Column Info
	 * @return fRhqcd
	 */
	public String getFRhqcd() {
		return this.fRhqcd;
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
	 * @param fOfccd
	 */
	public void setFOfccd(String fOfccd) {
		this.fOfccd = fOfccd;
	}
	
	/**
	 * Column Info
	 * @param fRhqcd
	 */
	public void setFRhqcd(String fRhqcd) {
		this.fRhqcd = fRhqcd;
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
		setFOfccd(JSPUtil.getParameter(request, prefix + "f_ofccd", ""));
		setFRhqcd(JSPUtil.getParameter(request, prefix + "f_rhqcd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr1031ConditionVO[]
	 */
	public EesEqr1031ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr1031ConditionVO[]
	 */
	public EesEqr1031ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr1031ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fOfccd = (JSPUtil.getParameter(request, prefix	+ "f_ofccd", length));
			String[] fRhqcd = (JSPUtil.getParameter(request, prefix	+ "f_rhqcd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr1031ConditionVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fOfccd[i] != null)
					model.setFOfccd(fOfccd[i]);
				if (fRhqcd[i] != null)
					model.setFRhqcd(fRhqcd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr1031ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr1031ConditionVO[]
	 */
	public EesEqr1031ConditionVO[] getEesEqr1031ConditionVOs(){
		EesEqr1031ConditionVO[] vos = (EesEqr1031ConditionVO[])models.toArray(new EesEqr1031ConditionVO[models.size()]);
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
		this.fOfccd = this.fOfccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRhqcd = this.fRhqcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
