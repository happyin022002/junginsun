/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StopDaysVO.java
*@FileTitle : StopDaysVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.20  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StopDaysVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StopDaysVO> models = new ArrayList<StopDaysVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tmpCstopNo = null;
	/* Column Info */
	private String tmpCstopDay = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public StopDaysVO() {}

	public StopDaysVO(String ibflag, String pagerows, String tmpCstopNo, String tmpCstopDay) {
		this.ibflag = ibflag;
		this.tmpCstopNo = tmpCstopNo;
		this.tmpCstopDay = tmpCstopDay;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tmp_cstop_no", getTmpCstopNo());
		this.hashColumns.put("tmp_cstop_day", getTmpCstopDay());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tmp_cstop_no", "tmpCstopNo");
		this.hashFields.put("tmp_cstop_day", "tmpCstopDay");
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
	 * @return tmpCstopNo
	 */
	public String getTmpCstopNo() {
		return this.tmpCstopNo;
	}
	
	/**
	 * Column Info
	 * @return tmpCstopDay
	 */
	public String getTmpCstopDay() {
		return this.tmpCstopDay;
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
	 * @param tmpCstopNo
	 */
	public void setTmpCstopNo(String tmpCstopNo) {
		this.tmpCstopNo = tmpCstopNo;
	}
	
	/**
	 * Column Info
	 * @param tmpCstopDay
	 */
	public void setTmpCstopDay(String tmpCstopDay) {
		this.tmpCstopDay = tmpCstopDay;
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
		setTmpCstopNo(JSPUtil.getParameter(request, prefix + "tmp_cstop_no", ""));
		setTmpCstopDay(JSPUtil.getParameter(request, prefix + "tmp_cstop_day", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StopDaysVO[]
	 */
	public StopDaysVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StopDaysVO[]
	 */
	public StopDaysVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StopDaysVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tmpCstopNo = (JSPUtil.getParameter(request, prefix	+ "tmp_cstop_no", length));
			String[] tmpCstopDay = (JSPUtil.getParameter(request, prefix	+ "tmp_cstop_day", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new StopDaysVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tmpCstopNo[i] != null)
					model.setTmpCstopNo(tmpCstopNo[i]);
				if (tmpCstopDay[i] != null)
					model.setTmpCstopDay(tmpCstopDay[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStopDaysVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StopDaysVO[]
	 */
	public StopDaysVO[] getStopDaysVOs(){
		StopDaysVO[] vos = (StopDaysVO[])models.toArray(new StopDaysVO[models.size()]);
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
		this.tmpCstopNo = this.tmpCstopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpCstopDay = this.tmpCstopDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}