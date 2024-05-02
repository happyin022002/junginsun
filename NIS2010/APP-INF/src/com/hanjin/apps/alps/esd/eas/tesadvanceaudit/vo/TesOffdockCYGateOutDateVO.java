/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesOffdockCYGateOutDateVO.java
*@FileTitle : TesOffdockCYGateOutDateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.26
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.05.26 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesOffdockCYGateOutDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesOffdockCYGateOutDateVO> models = new ArrayList<TesOffdockCYGateOutDateVO>();
	
	/* Column Info */
	private String fmGoDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toGoDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesOffdockCYGateOutDateVO() {}

	public TesOffdockCYGateOutDateVO(String ibflag, String pagerows, String fmGoDt, String toGoDt) {
		this.fmGoDt = fmGoDt;
		this.ibflag = ibflag;
		this.toGoDt = toGoDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_go_dt", getFmGoDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_go_dt", getToGoDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_go_dt", "fmGoDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_go_dt", "toGoDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmGoDt
	 */
	public String getFmGoDt() {
		return this.fmGoDt;
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
	 * @return toGoDt
	 */
	public String getToGoDt() {
		return this.toGoDt;
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
	 * @param fmGoDt
	 */
	public void setFmGoDt(String fmGoDt) {
		this.fmGoDt = fmGoDt;
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
	 * @param toGoDt
	 */
	public void setToGoDt(String toGoDt) {
		this.toGoDt = toGoDt;
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
		setFmGoDt(JSPUtil.getParameter(request, prefix + "fm_go_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setToGoDt(JSPUtil.getParameter(request, prefix + "to_go_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesOffdockCYGateOutDateVO[]
	 */
	public TesOffdockCYGateOutDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesOffdockCYGateOutDateVO[]
	 */
	public TesOffdockCYGateOutDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesOffdockCYGateOutDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmGoDt = (JSPUtil.getParameter(request, prefix	+ "fm_go_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toGoDt = (JSPUtil.getParameter(request, prefix	+ "to_go_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesOffdockCYGateOutDateVO();
				if (fmGoDt[i] != null)
					model.setFmGoDt(fmGoDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toGoDt[i] != null)
					model.setToGoDt(toGoDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesOffdockCYGateOutDateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesOffdockCYGateOutDateVO[]
	 */
	public TesOffdockCYGateOutDateVO[] getTesOffdockCYGateOutDateVOs(){
		TesOffdockCYGateOutDateVO[] vos = (TesOffdockCYGateOutDateVO[])models.toArray(new TesOffdockCYGateOutDateVO[models.size()]);
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
		this.fmGoDt = this.fmGoDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGoDt = this.toGoDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
