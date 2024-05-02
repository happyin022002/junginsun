/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMscCheckListVO.java
*@FileTitle : SearchMscCheckListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 최진오
*@LastVersion : 1.0
* 2009.10.16 최진오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.eas.transportmanage.vo;

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
 * @author 최진오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMscCheckListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMscCheckListVO> models = new ArrayList<SearchMscCheckListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oldOfcCd = null;
	/* Column Info */
	private String fromtrodate = null;
	/* Column Info */
	private String totrodate = null;
	/* Column Info */
	private String tromonth = null;
	/* Column Info */
	private String ctrlUserId = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String sBnd = null;
	/* Column Info */
	private String selOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMscCheckListVO() {}

	public SearchMscCheckListVO(String ibflag, String pagerows, String sBnd, String tromonth, String fromtrodate, String totrodate, String ctrlUserId, String ctrlOfcCd, String oldOfcCd, String selOfcCd) {
		this.ibflag = ibflag;
		this.oldOfcCd = oldOfcCd;
		this.fromtrodate = fromtrodate;
		this.totrodate = totrodate;
		this.tromonth = tromonth;
		this.ctrlUserId = ctrlUserId;
		this.ctrlOfcCd = ctrlOfcCd;
		this.sBnd = sBnd;
		this.selOfcCd = selOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("old_ofc_cd", getOldOfcCd());
		this.hashColumns.put("fromtrodate", getFromtrodate());
		this.hashColumns.put("totrodate", getTotrodate());
		this.hashColumns.put("tromonth", getTromonth());
		this.hashColumns.put("ctrl_user_id", getCtrlUserId());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("s_bnd", getSBnd());
		this.hashColumns.put("sel_ofc_cd", getSelOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("old_ofc_cd", "oldOfcCd");
		this.hashFields.put("fromtrodate", "fromtrodate");
		this.hashFields.put("totrodate", "totrodate");
		this.hashFields.put("tromonth", "tromonth");
		this.hashFields.put("ctrl_user_id", "ctrlUserId");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("s_bnd", "sBnd");
		this.hashFields.put("sel_ofc_cd", "selOfcCd");
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
	 * @return oldOfcCd
	 */
	public String getOldOfcCd() {
		return this.oldOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fromtrodate
	 */
	public String getFromtrodate() {
		return this.fromtrodate;
	}
	
	/**
	 * Column Info
	 * @return totrodate
	 */
	public String getTotrodate() {
		return this.totrodate;
	}
	
	/**
	 * Column Info
	 * @return tromonth
	 */
	public String getTromonth() {
		return this.tromonth;
	}
	
	/**
	 * Column Info
	 * @return ctrlUserId
	 */
	public String getCtrlUserId() {
		return this.ctrlUserId;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sBnd
	 */
	public String getSBnd() {
		return this.sBnd;
	}
	
	/**
	 * Column Info
	 * @return selOfcCd
	 */
	public String getSelOfcCd() {
		return this.selOfcCd;
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
	 * @param oldOfcCd
	 */
	public void setOldOfcCd(String oldOfcCd) {
		this.oldOfcCd = oldOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fromtrodate
	 */
	public void setFromtrodate(String fromtrodate) {
		this.fromtrodate = fromtrodate;
	}
	
	/**
	 * Column Info
	 * @param totrodate
	 */
	public void setTotrodate(String totrodate) {
		this.totrodate = totrodate;
	}
	
	/**
	 * Column Info
	 * @param tromonth
	 */
	public void setTromonth(String tromonth) {
		this.tromonth = tromonth;
	}
	
	/**
	 * Column Info
	 * @param ctrlUserId
	 */
	public void setCtrlUserId(String ctrlUserId) {
		this.ctrlUserId = ctrlUserId;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sBnd
	 */
	public void setSBnd(String sBnd) {
		this.sBnd = sBnd;
	}
	
	/**
	 * Column Info
	 * @param selOfcCd
	 */
	public void setSelOfcCd(String selOfcCd) {
		this.selOfcCd = selOfcCd;
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
		setOldOfcCd(JSPUtil.getParameter(request, "old_ofc_cd", ""));
		setFromtrodate(JSPUtil.getParameter(request, "fromtrodate", ""));
		setTotrodate(JSPUtil.getParameter(request, "totrodate", ""));
		setTromonth(JSPUtil.getParameter(request, "tromonth", ""));
		setCtrlUserId(JSPUtil.getParameter(request, "ctrl_user_id", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setSBnd(JSPUtil.getParameter(request, "s_bnd", ""));
		setSelOfcCd(JSPUtil.getParameter(request, "sel_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMscCheckListVO[]
	 */
	public SearchMscCheckListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMscCheckListVO[]
	 */
	public SearchMscCheckListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMscCheckListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oldOfcCd = (JSPUtil.getParameter(request, prefix	+ "old_ofc_cd", length));
			String[] fromtrodate = (JSPUtil.getParameter(request, prefix	+ "fromtrodate", length));
			String[] totrodate = (JSPUtil.getParameter(request, prefix	+ "totrodate", length));
			String[] tromonth = (JSPUtil.getParameter(request, prefix	+ "tromonth", length));
			String[] ctrlUserId = (JSPUtil.getParameter(request, prefix	+ "ctrl_user_id", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] sBnd = (JSPUtil.getParameter(request, prefix	+ "s_bnd", length));
			String[] selOfcCd = (JSPUtil.getParameter(request, prefix	+ "sel_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMscCheckListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oldOfcCd[i] != null)
					model.setOldOfcCd(oldOfcCd[i]);
				if (fromtrodate[i] != null)
					model.setFromtrodate(fromtrodate[i]);
				if (totrodate[i] != null)
					model.setTotrodate(totrodate[i]);
				if (tromonth[i] != null)
					model.setTromonth(tromonth[i]);
				if (ctrlUserId[i] != null)
					model.setCtrlUserId(ctrlUserId[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (sBnd[i] != null)
					model.setSBnd(sBnd[i]);
				if (selOfcCd[i] != null)
					model.setSelOfcCd(selOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMscCheckListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMscCheckListVO[]
	 */
	public SearchMscCheckListVO[] getSearchMscCheckListVOs(){
		SearchMscCheckListVO[] vos = (SearchMscCheckListVO[])models.toArray(new SearchMscCheckListVO[models.size()]);
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
		this.oldOfcCd = this.oldOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromtrodate = this.fromtrodate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totrodate = this.totrodate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tromonth = this.tromonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlUserId = this.ctrlUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBnd = this.sBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selOfcCd = this.selOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
