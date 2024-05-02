/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualVO.java
*@FileTitle : AccrualVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.03 장강철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo;

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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AccrualVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AccrualVO> models = new ArrayList<AccrualVO>();
	
	/* Column Info */
	private String fff = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ffa = null;
	/* Column Info */
	private String adf = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AccrualVO() {}

	public AccrualVO(String ibflag, String pagerows, String adf, String fff, String ffa) {
		this.fff = fff;
		this.ibflag = ibflag;
		this.ffa = ffa;
		this.adf = adf;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fff", getFff());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ffa", getFfa());
		this.hashColumns.put("adf", getAdf());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fff", "fff");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ffa", "ffa");
		this.hashFields.put("adf", "adf");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fff
	 */
	public String getFff() {
		return this.fff;
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
	 * @return ffa
	 */
	public String getFfa() {
		return this.ffa;
	}
	
	/**
	 * Column Info
	 * @return adf
	 */
	public String getAdf() {
		return this.adf;
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
	 * @param fff
	 */
	public void setFff(String fff) {
		this.fff = fff;
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
	 * @param ffa
	 */
	public void setFfa(String ffa) {
		this.ffa = ffa;
	}
	
	/**
	 * Column Info
	 * @param adf
	 */
	public void setAdf(String adf) {
		this.adf = adf;
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
		setFff(JSPUtil.getParameter(request, "fff", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFfa(JSPUtil.getParameter(request, "ffa", ""));
		setAdf(JSPUtil.getParameter(request, "adf", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AccrualVO[]
	 */
	public AccrualVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AccrualVO[]
	 */
	public AccrualVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AccrualVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fff = (JSPUtil.getParameter(request, prefix	+ "fff", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ffa = (JSPUtil.getParameter(request, prefix	+ "ffa", length));
			String[] adf = (JSPUtil.getParameter(request, prefix	+ "adf", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AccrualVO();
				if (fff[i] != null)
					model.setFff(fff[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ffa[i] != null)
					model.setFfa(ffa[i]);
				if (adf[i] != null)
					model.setAdf(adf[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAccrualVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AccrualVO[]
	 */
	public AccrualVO[] getAccrualVOs(){
		AccrualVO[] vos = (AccrualVO[])models.toArray(new AccrualVO[models.size()]);
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
		this.fff = this.fff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffa = this.ffa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adf = this.adf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
