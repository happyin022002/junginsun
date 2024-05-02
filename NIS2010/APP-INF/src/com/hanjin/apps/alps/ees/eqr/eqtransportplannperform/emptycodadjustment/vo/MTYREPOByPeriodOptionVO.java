/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYREPOByPeriodOptionVO.java
*@FileTitle : MTYREPOByPeriodOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.08.12 문중철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MTYREPOByPeriodOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MTYREPOByPeriodOptionVO> models = new ArrayList<MTYREPOByPeriodOptionVO>();
	
	/* Column Info */
	private String inquirylevel = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String div = null;
	/* Column Info */
	private String fromdate = null;
	/* Column Info */
	private String enddate = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MTYREPOByPeriodOptionVO() {}

	public MTYREPOByPeriodOptionVO(String ibflag, String pagerows, String tpsz, String fromdate, String enddate, String div, String inquirylevel, String location) {
		this.inquirylevel = inquirylevel;
		this.ibflag = ibflag;
		this.tpsz = tpsz;
		this.location = location;
		this.div = div;
		this.fromdate = fromdate;
		this.enddate = enddate;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inquirylevel", getInquirylevel());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("fromdate", getFromdate());
		this.hashColumns.put("enddate", getEnddate());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inquirylevel", "inquirylevel");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("location", "location");
		this.hashFields.put("div", "div");
		this.hashFields.put("fromdate", "fromdate");
		this.hashFields.put("enddate", "enddate");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inquirylevel
	 */
	public String getInquirylevel() {
		return this.inquirylevel;
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
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return div
	 */
	public String getDiv() {
		return this.div;
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
	 * @return enddate
	 */
	public String getEnddate() {
		return this.enddate;
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
	 * @param inquirylevel
	 */
	public void setInquirylevel(String inquirylevel) {
		this.inquirylevel = inquirylevel;
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
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	
	/**
	 * Column Info
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param div
	 */
	public void setDiv(String div) {
		this.div = div;
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
	 * @param enddate
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
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
		setInquirylevel(JSPUtil.getParameter(request, "inquirylevel", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTpsz(JSPUtil.getParameter(request, "tpsz", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setDiv(JSPUtil.getParameter(request, "div", ""));
		setFromdate(JSPUtil.getParameter(request, "fromdate", ""));
		setEnddate(JSPUtil.getParameter(request, "enddate", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MTYREPOByPeriodOptionVO[]
	 */
	public MTYREPOByPeriodOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MTYREPOByPeriodOptionVO[]
	 */
	public MTYREPOByPeriodOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MTYREPOByPeriodOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inquirylevel = (JSPUtil.getParameter(request, prefix	+ "inquirylevel", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] fromdate = (JSPUtil.getParameter(request, prefix	+ "fromdate", length));
			String[] enddate = (JSPUtil.getParameter(request, prefix	+ "enddate", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MTYREPOByPeriodOptionVO();
				if (inquirylevel[i] != null)
					model.setInquirylevel(inquirylevel[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (div[i] != null)
					model.setDiv(div[i]);
				if (fromdate[i] != null)
					model.setFromdate(fromdate[i]);
				if (enddate[i] != null)
					model.setEnddate(enddate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMTYREPOByPeriodOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MTYREPOByPeriodOptionVO[]
	 */
	public MTYREPOByPeriodOptionVO[] getMTYREPOByPeriodOptionVOs(){
		MTYREPOByPeriodOptionVO[] vos = (MTYREPOByPeriodOptionVO[])models.toArray(new MTYREPOByPeriodOptionVO[models.size()]);
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
		this.inquirylevel = this.inquirylevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromdate = this.fromdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.enddate = this.enddate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
