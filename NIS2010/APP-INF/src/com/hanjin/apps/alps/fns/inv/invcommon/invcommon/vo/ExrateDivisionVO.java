/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExrateDivisionVO.java
*@FileTitle : ExrateDivisionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.27 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo;

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
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExrateDivisionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExrateDivisionVO> models = new ArrayList<ExrateDivisionVO>();
	
	/* Column Info */
	private String cngIndivCd = null;
	/* Column Info */
	private String aplyStDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String divCd2 = null;
	/* Column Info */
	private String divCd1 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExrateDivisionVO() {}

	public ExrateDivisionVO(String ibflag, String pagerows, String divCd1, String divCd2, String aplyStDt, String cngIndivCd) {
		this.cngIndivCd = cngIndivCd;
		this.aplyStDt = aplyStDt;
		this.ibflag = ibflag;
		this.divCd2 = divCd2;
		this.divCd1 = divCd1;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cng_indiv_cd", getCngIndivCd());
		this.hashColumns.put("aply_st_dt", getAplyStDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("div_cd2", getDivCd2());
		this.hashColumns.put("div_cd1", getDivCd1());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cng_indiv_cd", "cngIndivCd");
		this.hashFields.put("aply_st_dt", "aplyStDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("div_cd2", "divCd2");
		this.hashFields.put("div_cd1", "divCd1");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cngIndivCd
	 */
	public String getCngIndivCd() {
		return this.cngIndivCd;
	}
	
	/**
	 * Column Info
	 * @return aplyStDt
	 */
	public String getAplyStDt() {
		return this.aplyStDt;
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
	 * @return divCd2
	 */
	public String getDivCd2() {
		return this.divCd2;
	}
	
	/**
	 * Column Info
	 * @return divCd1
	 */
	public String getDivCd1() {
		return this.divCd1;
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
	 * @param cngIndivCd
	 */
	public void setCngIndivCd(String cngIndivCd) {
		this.cngIndivCd = cngIndivCd;
	}
	
	/**
	 * Column Info
	 * @param aplyStDt
	 */
	public void setAplyStDt(String aplyStDt) {
		this.aplyStDt = aplyStDt;
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
	 * @param divCd2
	 */
	public void setDivCd2(String divCd2) {
		this.divCd2 = divCd2;
	}
	
	/**
	 * Column Info
	 * @param divCd1
	 */
	public void setDivCd1(String divCd1) {
		this.divCd1 = divCd1;
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
		setCngIndivCd(JSPUtil.getParameter(request, "cng_indiv_cd", ""));
		setAplyStDt(JSPUtil.getParameter(request, "aply_st_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDivCd2(JSPUtil.getParameter(request, "div_cd2", ""));
		setDivCd1(JSPUtil.getParameter(request, "div_cd1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExrateDivisionVO[]
	 */
	public ExrateDivisionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExrateDivisionVO[]
	 */
	public ExrateDivisionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExrateDivisionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cngIndivCd = (JSPUtil.getParameter(request, prefix	+ "cng_indiv_cd".trim(), length));
			String[] aplyStDt = (JSPUtil.getParameter(request, prefix	+ "aply_st_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] divCd2 = (JSPUtil.getParameter(request, prefix	+ "div_cd2".trim(), length));
			String[] divCd1 = (JSPUtil.getParameter(request, prefix	+ "div_cd1".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ExrateDivisionVO();
				if (cngIndivCd[i] != null)
					model.setCngIndivCd(cngIndivCd[i]);
				if (aplyStDt[i] != null)
					model.setAplyStDt(aplyStDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (divCd2[i] != null)
					model.setDivCd2(divCd2[i]);
				if (divCd1[i] != null)
					model.setDivCd1(divCd1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExrateDivisionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExrateDivisionVO[]
	 */
	public ExrateDivisionVO[] getExrateDivisionVOs(){
		ExrateDivisionVO[] vos = (ExrateDivisionVO[])models.toArray(new ExrateDivisionVO[models.size()]);
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
		this.cngIndivCd = this.cngIndivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyStDt = this.aplyStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divCd2 = this.divCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divCd1 = this.divCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
