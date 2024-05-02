/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr043ConditionVO.java
*@FileTitle : EesEqr043ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.09 이행지 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo;

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
 * @author 이행지
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0043ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0043ConditionVO> models = new ArrayList<EesEqr0043ConditionVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpsztype = null;
	/* Column Info */
	private String oddtpsz = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String loctype = null;
	/* Column Info */
	private ArrayList<String> arrtpsz = null;
	/* Column Info */
	private ArrayList<String> arrlocation = null;
	/* Column Info */
	private String bound = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0043ConditionVO() {}

	public EesEqr0043ConditionVO(String ibflag, String pagerows, String loctype, String location, String company, String tpsztype, String oddtpsz, String bound) {
		this.ibflag = ibflag;
		this.tpsztype = tpsztype;
		this.location = location;
		this.company = company;
		this.loctype = loctype;
		this.oddtpsz = oddtpsz;
		this.bound = bound;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsztype", getTpsztype());
		this.hashColumns.put("oddtpsz", getOddtpsz());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("loctype", getLoctype());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsztype", "tpsztype");
		this.hashFields.put("oddtpsz", "oddtpsz");
		this.hashFields.put("location", "location");
		this.hashFields.put("company", "company");
		this.hashFields.put("loctype", "loctype");
		this.hashFields.put("arrtpsz", "arrtpsz");
		this.hashFields.put("arrlocation", "arrlocation");
		this.hashFields.put("bound", "bound");
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
	 * @return tpsztype
	 */
	public String getTpsztype() {
		return this.tpsztype;
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
	 * @return company
	 */
	public String getCompany() {
		return this.company;
	}
	
	/**
	 * Column Info
	 * @return loctype
	 */
	public String getLoctype() {
		return this.loctype;
	}
	
	/**
	 * Column Info
	 * @return arrtpsz
	 */
	public ArrayList<String> getArrtpsz() {
		return this.arrtpsz;
	}
	
	/**
	 * Column Info
	 * @return arrlocation
	 */
	public ArrayList<String> getArrlocation() {
		return this.arrlocation;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	
	/**
	 * Column Info
	 * @return oddtpsz
	 */
	public String getOddtpsz() {
		return oddtpsz;
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
	 * @param tpsztype
	 */
	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
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
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Column Info
	 * @param loctype
	 */
	public void setLoctype(String loctype) {
		this.loctype = loctype;
	}
	
	/**
	 * Column Info
	 * @param arrtpsz
	 */
	public void setArrtpsz(ArrayList<String> arrtpsz) {
		this.arrtpsz = arrtpsz;
	}
	
	/**
	 * Column Info
	 * @param arrlocation
	 */
	public void setArrlocation(ArrayList<String> arrlocation) {
		this.arrlocation = arrlocation;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}



	public void setOddtpsz(String oddtpsz) {
		this.oddtpsz = oddtpsz;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTpsztype(JSPUtil.getParameter(request, "tpsztype", ""));
		setOddtpsz(JSPUtil.getParameter(request, "oddtpsz", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setLoctype(JSPUtil.getParameter(request, "loctype", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr043ConditionVO[]
	 */
	public EesEqr0043ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr043ConditionVO[]
	 */
	public EesEqr0043ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0043ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tpsztype = (JSPUtil.getParameter(request, prefix	+ "tpsztype", length));
			String[] oddtpsz = (JSPUtil.getParameter(request, prefix	+ "oddtpsz", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] loctype = (JSPUtil.getParameter(request, prefix	+ "loctype", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0043ConditionVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oddtpsz[i] != null)
					model.setOddtpsz(oddtpsz[i]);
				if (tpsztype[i] != null)
					model.setTpsztype(tpsztype[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (loctype[i] != null)
					model.setLoctype(loctype[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr043ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr043ConditionVO[]
	 */
	public EesEqr0043ConditionVO[] getEesEqr043ConditionVOs(){
		EesEqr0043ConditionVO[] vos = (EesEqr0043ConditionVO[])models.toArray(new EesEqr0043ConditionVO[models.size()]);
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
		this.tpsztype = this.tpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oddtpsz = this.oddtpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loctype = this.loctype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
