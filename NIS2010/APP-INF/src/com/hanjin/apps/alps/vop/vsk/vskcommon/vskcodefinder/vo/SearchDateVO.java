/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchDateVO.java
*@FileTitle : SearchDateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo;

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

public class SearchDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDateVO> models = new ArrayList<SearchDateVO>();
	
	/* Column Info */
	private String wmCd = null;
	/* Column Info */
	private String fmWk = null;
	/* Column Info */
	private String toMon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmMon = null;
	/* Column Info */
	private String toWk = null;
	/* Column Info */
	private String rtnDate = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDateVO() {}

	public SearchDateVO(String ibflag, String pagerows, String fmMon, String toMon, String fmWk, String toWk, String wmCd, String rtnDate) {
		this.wmCd = wmCd;
		this.fmWk = fmWk;
		this.toMon = toMon;
		this.ibflag = ibflag;
		this.fmMon = fmMon;
		this.toWk = toWk;
		this.rtnDate = rtnDate;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("wm_cd", getWmCd());
		this.hashColumns.put("fm_wk", getFmWk());
		this.hashColumns.put("to_mon", getToMon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_mon", getFmMon());
		this.hashColumns.put("to_wk", getToWk());
		this.hashColumns.put("rtn_date", getRtnDate());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("wm_cd", "wmCd");
		this.hashFields.put("fm_wk", "fmWk");
		this.hashFields.put("to_mon", "toMon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_mon", "fmMon");
		this.hashFields.put("to_wk", "toWk");
		this.hashFields.put("rtn_date", "rtnDate");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return wmCd
	 */
	public String getWmCd() {
		return this.wmCd;
	}
	
	/**
	 * Column Info
	 * @return fmWk
	 */
	public String getFmWk() {
		return this.fmWk;
	}
	
	/**
	 * Column Info
	 * @return toMon
	 */
	public String getToMon() {
		return this.toMon;
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
	 * @return fmMon
	 */
	public String getFmMon() {
		return this.fmMon;
	}
	
	/**
	 * Column Info
	 * @return toWk
	 */
	public String getToWk() {
		return this.toWk;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	public String getRtnDate() {
		return rtnDate;
	}

	public void setRtnDate(String rtnDate) {
		this.rtnDate = rtnDate;
	}

	/**
	 * Column Info
	 * @param wmCd
	 */
	public void setWmCd(String wmCd) {
		this.wmCd = wmCd;
	}
	
	/**
	 * Column Info
	 * @param fmWk
	 */
	public void setFmWk(String fmWk) {
		this.fmWk = fmWk;
	}
	
	/**
	 * Column Info
	 * @param toMon
	 */
	public void setToMon(String toMon) {
		this.toMon = toMon;
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
	 * @param fmMon
	 */
	public void setFmMon(String fmMon) {
		this.fmMon = fmMon;
	}
	
	/**
	 * Column Info
	 * @param toWk
	 */
	public void setToWk(String toWk) {
		this.toWk = toWk;
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
		setWmCd(JSPUtil.getParameter(request, prefix + "wm_cd", ""));
		setFmWk(JSPUtil.getParameter(request, prefix + "fm_wk", ""));
		setToMon(JSPUtil.getParameter(request, prefix + "to_mon", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmMon(JSPUtil.getParameter(request, prefix + "fm_mon", ""));
		setToWk(JSPUtil.getParameter(request, prefix + "to_wk", ""));
		setRtnDate(JSPUtil.getParameter(request, prefix + "rtn_date", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDateVO[]
	 */
	public SearchDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDateVO[]
	 */
	public SearchDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] wmCd = (JSPUtil.getParameter(request, prefix	+ "wm_cd", length));
			String[] fmWk = (JSPUtil.getParameter(request, prefix	+ "fm_wk", length));
			String[] toMon = (JSPUtil.getParameter(request, prefix	+ "to_mon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmMon = (JSPUtil.getParameter(request, prefix	+ "fm_mon", length));
			String[] toWk = (JSPUtil.getParameter(request, prefix	+ "to_wk", length));
			String[] rtnDate = (JSPUtil.getParameter(request, prefix	+ "rtn_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDateVO();
				if (wmCd[i] != null)
					model.setWmCd(wmCd[i]);
				if (fmWk[i] != null)
					model.setFmWk(fmWk[i]);
				if (toMon[i] != null)
					model.setToMon(toMon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmMon[i] != null)
					model.setFmMon(fmMon[i]);
				if (toWk[i] != null)
					model.setToWk(toWk[i]);
				if (rtnDate[i] != null)
					model.setRtnDate(rtnDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDateVO[]
	 */
	public SearchDateVO[] getSearchDateVOs(){
		SearchDateVO[] vos = (SearchDateVO[])models.toArray(new SearchDateVO[models.size()]);
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
		this.wmCd = this.wmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmWk = this.fmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMon = this.toMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMon = this.fmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWk = this.toWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnDate = this.rtnDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
