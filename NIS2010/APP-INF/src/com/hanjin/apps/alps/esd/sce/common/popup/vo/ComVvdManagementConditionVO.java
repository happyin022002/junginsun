/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComVvdManagementConditionVO.java
*@FileTitle : ComVvdManagementConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.07.28 신한성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.common.popup.vo;

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
 * @author 신한성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComVvdManagementConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComVvdManagementConditionVO> models = new ArrayList<ComVvdManagementConditionVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String selpod = null;
	/* Column Info */
	private String edate = null;
	/* Column Info */
	private String sellane = null;
	/* Column Info */
	private String selvvd = null;
	/* Column Info */
	private String sdate = null;
	/* Column Info */
	private String selpol = null;
	/* Column Info */
	private String seletad = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComVvdManagementConditionVO() {}

	public ComVvdManagementConditionVO(String ibflag, String pagerows, String seletad, String sdate, String edate, String sellane, String selpol, String selpod, String selvvd) {
		this.ibflag = ibflag;
		this.selpod = selpod;
		this.edate = edate;
		this.sellane = sellane;
		this.selvvd = selvvd;
		this.sdate = sdate;
		this.selpol = selpol;
		this.seletad = seletad;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("selpod", getSelpod());
		this.hashColumns.put("edate", getEdate());
		this.hashColumns.put("sellane", getSellane());
		this.hashColumns.put("selvvd", getSelvvd());
		this.hashColumns.put("sdate", getSdate());
		this.hashColumns.put("selpol", getSelpol());
		this.hashColumns.put("seletad", getSeletad());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("selpod", "selpod");
		this.hashFields.put("edate", "edate");
		this.hashFields.put("sellane", "sellane");
		this.hashFields.put("selvvd", "selvvd");
		this.hashFields.put("sdate", "sdate");
		this.hashFields.put("selpol", "selpol");
		this.hashFields.put("seletad", "seletad");
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
	 * @return selpod
	 */
	public String getSelpod() {
		return this.selpod;
	}
	
	/**
	 * Column Info
	 * @return edate
	 */
	public String getEdate() {
		return this.edate;
	}
	
	/**
	 * Column Info
	 * @return sellane
	 */
	public String getSellane() {
		return this.sellane;
	}
	
	/**
	 * Column Info
	 * @return selvvd
	 */
	public String getSelvvd() {
		return this.selvvd;
	}
	
	/**
	 * Column Info
	 * @return sdate
	 */
	public String getSdate() {
		return this.sdate;
	}
	
	/**
	 * Column Info
	 * @return selpol
	 */
	public String getSelpol() {
		return this.selpol;
	}
	
	/**
	 * Column Info
	 * @return seletad
	 */
	public String getSeletad() {
		return this.seletad;
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
	 * @param selpod
	 */
	public void setSelpod(String selpod) {
		this.selpod = selpod;
	}
	
	/**
	 * Column Info
	 * @param edate
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	/**
	 * Column Info
	 * @param sellane
	 */
	public void setSellane(String sellane) {
		this.sellane = sellane;
	}
	
	/**
	 * Column Info
	 * @param selvvd
	 */
	public void setSelvvd(String selvvd) {
		this.selvvd = selvvd;
	}
	
	/**
	 * Column Info
	 * @param sdate
	 */
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
	/**
	 * Column Info
	 * @param selpol
	 */
	public void setSelpol(String selpol) {
		this.selpol = selpol;
	}
	
	/**
	 * Column Info
	 * @param seletad
	 */
	public void setSeletad(String seletad) {
		this.seletad = seletad;
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
		setSelpod(JSPUtil.getParameter(request, "selpod", ""));
		setEdate(JSPUtil.getParameter(request, "edate", ""));
		setSellane(JSPUtil.getParameter(request, "sellane", ""));
		setSelvvd(JSPUtil.getParameter(request, "selvvd", ""));
		setSdate(JSPUtil.getParameter(request, "sdate", ""));
		setSelpol(JSPUtil.getParameter(request, "selpol", ""));
		setSeletad(JSPUtil.getParameter(request, "seletad", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComVvdManagementConditionVO[]
	 */
	public ComVvdManagementConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComVvdManagementConditionVO[]
	 */
	public ComVvdManagementConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComVvdManagementConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] selpod = (JSPUtil.getParameter(request, prefix	+ "selpod", length));
			String[] edate = (JSPUtil.getParameter(request, prefix	+ "edate", length));
			String[] sellane = (JSPUtil.getParameter(request, prefix	+ "sellane", length));
			String[] selvvd = (JSPUtil.getParameter(request, prefix	+ "selvvd", length));
			String[] sdate = (JSPUtil.getParameter(request, prefix	+ "sdate", length));
			String[] selpol = (JSPUtil.getParameter(request, prefix	+ "selpol", length));
			String[] seletad = (JSPUtil.getParameter(request, prefix	+ "seletad", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComVvdManagementConditionVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (selpod[i] != null)
					model.setSelpod(selpod[i]);
				if (edate[i] != null)
					model.setEdate(edate[i]);
				if (sellane[i] != null)
					model.setSellane(sellane[i]);
				if (selvvd[i] != null)
					model.setSelvvd(selvvd[i]);
				if (sdate[i] != null)
					model.setSdate(sdate[i]);
				if (selpol[i] != null)
					model.setSelpol(selpol[i]);
				if (seletad[i] != null)
					model.setSeletad(seletad[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComVvdManagementConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComVvdManagementConditionVO[]
	 */
	public ComVvdManagementConditionVO[] getComVvdManagementConditionVOs(){
		ComVvdManagementConditionVO[] vos = (ComVvdManagementConditionVO[])models.toArray(new ComVvdManagementConditionVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selpod = this.selpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edate = this.edate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sellane = this.sellane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selvvd = this.selvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdate = this.sdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selpol = this.selpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seletad = this.seletad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
