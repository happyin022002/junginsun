/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GLEstimateINVO.java
*@FileTitle : GLEstimateINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.11.23 권영법 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo;

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
 * @author 권영법
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GLEstimateINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GLEstimateINVO> models = new ArrayList<GLEstimateINVO>();
	
	/* Column Info */
	private String exeMonth = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String month = null;
	/* Column Info */
	private String exeGubun = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public GLEstimateINVO() {}

	public GLEstimateINVO(String ibflag, String pagerows, String exeMonth, String usrId, String month, String exeGubun) {
		this.exeMonth = exeMonth;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.month = month;
		this.exeGubun = exeGubun;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("exe_month", getExeMonth());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("month", getMonth());
		this.hashColumns.put("exe_gubun", getExeGubun());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("exe_month", "exeMonth");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("month", "month");
		this.hashFields.put("exe_gubun", "exeGubun");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return exeMonth
	 */
	public String getExeMonth() {
		return this.exeMonth;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return month
	 */
	public String getMonth() {
		return this.month;
	}
	
	/**
	 * Column Info
	 * @return exeGubun
	 */
	public String getExeGubun() {
		return this.exeGubun;
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
	 * @param exeMonth
	 */
	public void setExeMonth(String exeMonth) {
		this.exeMonth = exeMonth;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * Column Info
	 * @param exeGubun
	 */
	public void setExeGubun(String exeGubun) {
		this.exeGubun = exeGubun;
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
		setExeMonth(JSPUtil.getParameter(request, "exe_month", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setMonth(JSPUtil.getParameter(request, "month", ""));
		setExeGubun(JSPUtil.getParameter(request, "exe_gubun", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GLEstimateINVO[]
	 */
	public GLEstimateINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GLEstimateINVO[]
	 */
	public GLEstimateINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GLEstimateINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] exeMonth = (JSPUtil.getParameter(request, prefix	+ "exe_month", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] month = (JSPUtil.getParameter(request, prefix	+ "month", length));
			String[] exeGubun = (JSPUtil.getParameter(request, prefix	+ "exe_gubun", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GLEstimateINVO();
				if (exeMonth[i] != null)
					model.setExeMonth(exeMonth[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (month[i] != null)
					model.setMonth(month[i]);
				if (exeGubun[i] != null)
					model.setExeGubun(exeGubun[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGLEstimateINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GLEstimateINVO[]
	 */
	public GLEstimateINVO[] getGLEstimateINVOs(){
		GLEstimateINVO[] vos = (GLEstimateINVO[])models.toArray(new GLEstimateINVO[models.size()]);
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
		this.exeMonth = this.exeMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.month = this.month .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeGubun = this.exeGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
