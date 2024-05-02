/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOptionByTradeLaneVvdVO.java
*@FileTitle : SearchOptionByTradeLaneVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.06.11 박광석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박광석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOptionByTradeLaneVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOptionByTradeLaneVvdVO> models = new ArrayList<SearchOptionByTradeLaneVvdVO>();
	
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String fromdate = null;
	/* Column Info */
	private String todate = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOptionByTradeLaneVvdVO() {}

	public SearchOptionByTradeLaneVvdVO(String ibflag, String pagerows, String fromdate, String todate, String trade, String lane, String vvd, String company) {
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.trade = trade;
		this.company = company;
		this.fromdate = fromdate;
		this.todate = todate;
		this.lane = lane;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("fromdate", getFromdate());
		this.hashColumns.put("todate", getTodate());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("company", "company");
		this.hashFields.put("fromdate", "fromdate");
		this.hashFields.put("todate", "todate");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}
	
	/**
	 * Column Info
	 * @return company
	 */
	public String getCompany() {
		return this.company;
	}
	
	/**
	 * Column Info
	 * @return fromdate
	 */
	public String getFromdate() {
		return this.fromdate;
	}
	
	/**
	 * Column Info
	 * @return todate
	 */
	public String getTodate() {
		return this.todate;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * Column Info
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Column Info
	 * @param fromdate
	 */
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	
	/**
	 * Column Info
	 * @param todate
	 */
	public void setTodate(String todate) {
		this.todate = todate;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTrade(JSPUtil.getParameter(request, "trade", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setFromdate(JSPUtil.getParameter(request, "fromdate", ""));
		setTodate(JSPUtil.getParameter(request, "todate", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOptionByTradeLaneVvdVO[]
	 */
	public SearchOptionByTradeLaneVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOptionByTradeLaneVvdVO[]
	 */
	public SearchOptionByTradeLaneVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOptionByTradeLaneVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] fromdate = (JSPUtil.getParameter(request, prefix	+ "fromdate", length));
			String[] todate = (JSPUtil.getParameter(request, prefix	+ "todate", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOptionByTradeLaneVvdVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (fromdate[i] != null)
					model.setFromdate(fromdate[i]);
				if (todate[i] != null)
					model.setTodate(todate[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOptionByTradeLaneVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOptionByTradeLaneVvdVO[]
	 */
	public SearchOptionByTradeLaneVvdVO[] getSearchOptionByTradeLaneVvdVOs(){
		SearchOptionByTradeLaneVvdVO[] vos = (SearchOptionByTradeLaneVvdVO[])models.toArray(new SearchOptionByTradeLaneVvdVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromdate = this.fromdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todate = this.todate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
