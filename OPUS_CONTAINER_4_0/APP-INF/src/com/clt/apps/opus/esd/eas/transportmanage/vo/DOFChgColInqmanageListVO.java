/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DOFChgColInqmanageListVO.java
*@FileTitle : DOFChgColInqmanageListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 최진오
*@LastVersion : 1.0
* 2009.10.21 최진오 
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

public class DOFChgColInqmanageListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DOFChgColInqmanageListVO> models = new ArrayList<DOFChgColInqmanageListVO>();
	
	/* Column Info */
	private String searchChoice = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String oldOfcCd = null;
	/* Column Info */
	private String custCd = null;
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
	private String returnCy = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DOFChgColInqmanageListVO() {}

	public DOFChgColInqmanageListVO(String ibflag, String pagerows, String ctrlOfcCd, String searchChoice, String tromonth, String fromtrodate, String totrodate, String returnCy, String custCd, String custNm, String ctrlUserId, String oldOfcCd) {
		this.searchChoice = searchChoice;
		this.ibflag = ibflag;
		this.custNm = custNm;
		this.oldOfcCd = oldOfcCd;
		this.custCd = custCd;
		this.fromtrodate = fromtrodate;
		this.totrodate = totrodate;
		this.tromonth = tromonth;
		this.ctrlUserId = ctrlUserId;
		this.ctrlOfcCd = ctrlOfcCd;
		this.returnCy = returnCy;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("search_choice", getSearchChoice());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("old_ofc_cd", getOldOfcCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("fromtrodate", getFromtrodate());
		this.hashColumns.put("totrodate", getTotrodate());
		this.hashColumns.put("tromonth", getTromonth());
		this.hashColumns.put("ctrl_user_id", getCtrlUserId());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("return_cy", getReturnCy());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("search_choice", "searchChoice");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("old_ofc_cd", "oldOfcCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("fromtrodate", "fromtrodate");
		this.hashFields.put("totrodate", "totrodate");
		this.hashFields.put("tromonth", "tromonth");
		this.hashFields.put("ctrl_user_id", "ctrlUserId");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("return_cy", "returnCy");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return searchChoice
	 */
	public String getSearchChoice() {
		return this.searchChoice;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
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
	 * @return returnCy
	 */
	public String getReturnCy() {
		return this.returnCy;
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
	 * @param searchChoice
	 */
	public void setSearchChoice(String searchChoice) {
		this.searchChoice = searchChoice;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
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
	 * @param returnCy
	 */
	public void setReturnCy(String returnCy) {
		this.returnCy = returnCy;
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
		setSearchChoice(JSPUtil.getParameter(request, "search_choice", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setOldOfcCd(JSPUtil.getParameter(request, "old_ofc_cd", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setFromtrodate(JSPUtil.getParameter(request, "fromtrodate", ""));
		setTotrodate(JSPUtil.getParameter(request, "totrodate", ""));
		setTromonth(JSPUtil.getParameter(request, "tromonth", ""));
		setCtrlUserId(JSPUtil.getParameter(request, "ctrl_user_id", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setReturnCy(JSPUtil.getParameter(request, "return_cy", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DOFChgColInqmanageListVO[]
	 */
	public DOFChgColInqmanageListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DOFChgColInqmanageListVO[]
	 */
	public DOFChgColInqmanageListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DOFChgColInqmanageListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] searchChoice = (JSPUtil.getParameter(request, prefix	+ "search_choice", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] oldOfcCd = (JSPUtil.getParameter(request, prefix	+ "old_ofc_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] fromtrodate = (JSPUtil.getParameter(request, prefix	+ "fromtrodate", length));
			String[] totrodate = (JSPUtil.getParameter(request, prefix	+ "totrodate", length));
			String[] tromonth = (JSPUtil.getParameter(request, prefix	+ "tromonth", length));
			String[] ctrlUserId = (JSPUtil.getParameter(request, prefix	+ "ctrl_user_id", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] returnCy = (JSPUtil.getParameter(request, prefix	+ "return_cy", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DOFChgColInqmanageListVO();
				if (searchChoice[i] != null)
					model.setSearchChoice(searchChoice[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (oldOfcCd[i] != null)
					model.setOldOfcCd(oldOfcCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
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
				if (returnCy[i] != null)
					model.setReturnCy(returnCy[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDOFChgColInqmanageListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DOFChgColInqmanageListVO[]
	 */
	public DOFChgColInqmanageListVO[] getDOFChgColInqmanageListVOs(){
		DOFChgColInqmanageListVO[] vos = (DOFChgColInqmanageListVO[])models.toArray(new DOFChgColInqmanageListVO[models.size()]);
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
		this.searchChoice = this.searchChoice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldOfcCd = this.oldOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromtrodate = this.fromtrodate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totrodate = this.totrodate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tromonth = this.tromonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlUserId = this.ctrlUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnCy = this.returnCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
