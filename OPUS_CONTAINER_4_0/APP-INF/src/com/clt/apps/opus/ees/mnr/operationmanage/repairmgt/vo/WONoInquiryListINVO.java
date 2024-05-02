/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WONoInquiryINVO.java
*@FileTitle : WONoInquiryINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.07.08 정영훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정영훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class WONoInquiryListINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<WONoInquiryListINVO> models = new ArrayList<WONoInquiryListINVO>();
	
	/* Column Info */
	private String tocal = null;
	/* Column Info */
	private String wotype = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currofccd = null;
	/* Column Info */
	private String eqtype = null;
	/* Column Info */
	private String fromcal = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public WONoInquiryListINVO() {}

	public WONoInquiryListINVO(String ibflag, String pagerows, String tocal, String wotype, String eqtype, String fromcal, String currofccd) {
		this.tocal = tocal;
		this.wotype = wotype;
		this.ibflag = ibflag;
		this.currofccd = currofccd;
		this.eqtype = eqtype;
		this.fromcal = fromcal;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tocal", getTocal());
		this.hashColumns.put("wotype", getWotype());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("currofccd", getCurrofccd());
		this.hashColumns.put("eqtype", getEqtype());
		this.hashColumns.put("fromcal", getFromcal());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tocal", "tocal");
		this.hashFields.put("wotype", "wotype");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("currofccd", "currofccd");
		this.hashFields.put("eqtype", "eqtype");
		this.hashFields.put("fromcal", "fromcal");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tocal
	 */
	public String getTocal() {
		return this.tocal;
	}
	
	/**
	 * Column Info
	 * @return wotype
	 */
	public String getWotype() {
		return this.wotype;
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
	 * @return currofccd
	 */
	public String getCurrofccd() {
		return this.currofccd;
	}
	
	/**
	 * Column Info
	 * @return eqtype
	 */
	public String getEqtype() {
		return this.eqtype;
	}
	
	/**
	 * Column Info
	 * @return fromcal
	 */
	public String getFromcal() {
		return this.fromcal;
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
	 * @param tocal
	 */
	public void setTocal(String tocal) {
		this.tocal = tocal;
	}
	
	/**
	 * Column Info
	 * @param wotype
	 */
	public void setWotype(String wotype) {
		this.wotype = wotype;
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
	 * @param currofccd
	 */
	public void setCurrofccd(String currofccd) {
		this.currofccd = currofccd;
	}
	
	/**
	 * Column Info
	 * @param eqtype
	 */
	public void setEqtype(String eqtype) {
		this.eqtype = eqtype;
	}
	
	/**
	 * Column Info
	 * @param fromcal
	 */
	public void setFromcal(String fromcal) {
		this.fromcal = fromcal;
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
		setTocal(JSPUtil.getParameter(request, "tocal", ""));
		setWotype(JSPUtil.getParameter(request, "wotype", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCurrofccd(JSPUtil.getParameter(request, "currofccd", ""));
		setEqtype(JSPUtil.getParameter(request, "eqtype", ""));
		setFromcal(JSPUtil.getParameter(request, "fromcal", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return WONoInquiryINVO[]
	 */
	public WONoInquiryListINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return WONoInquiryINVO[]
	 */
	public WONoInquiryListINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		WONoInquiryListINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tocal = (JSPUtil.getParameter(request, prefix	+ "tocal", length));
			String[] wotype = (JSPUtil.getParameter(request, prefix	+ "wotype", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currofccd = (JSPUtil.getParameter(request, prefix	+ "currofccd", length));
			String[] eqtype = (JSPUtil.getParameter(request, prefix	+ "eqtype", length));
			String[] fromcal = (JSPUtil.getParameter(request, prefix	+ "fromcal", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new WONoInquiryListINVO();
				if (tocal[i] != null)
					model.setTocal(tocal[i]);
				if (wotype[i] != null)
					model.setWotype(wotype[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currofccd[i] != null)
					model.setCurrofccd(currofccd[i]);
				if (eqtype[i] != null)
					model.setEqtype(eqtype[i]);
				if (fromcal[i] != null)
					model.setFromcal(fromcal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getWONoInquiryINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return WONoInquiryINVO[]
	 */
	public WONoInquiryListINVO[] getWONoInquiryINVOs(){
		WONoInquiryListINVO[] vos = (WONoInquiryListINVO[])models.toArray(new WONoInquiryListINVO[models.size()]);
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
		this.tocal = this.tocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wotype = this.wotype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currofccd = this.currofccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqtype = this.eqtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromcal = this.fromcal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
