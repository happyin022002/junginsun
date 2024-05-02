/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ACEPListINVO.java
*@FileTitle : ACEPListINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.10.22 김완규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ACEPListINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ACEPListINVO> models = new ArrayList<ACEPListINVO>();
	
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String termType = null;
	/* Column Info */
	private String curDt = null;
	/* Column Info */
	private String acepType = null;
	/* Column Info */
	private String month = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ACEPListINVO() {}

	public ACEPListINVO(String ibflag, String pagerows, String curDt, String month, String termType, String acepType, String locCd) {
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.termType = termType;
		this.curDt = curDt;
		this.acepType = acepType;
		this.month = month;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("term_type", getTermType());
		this.hashColumns.put("cur_dt", getCurDt());
		this.hashColumns.put("acep_type", getAcepType());
		this.hashColumns.put("month", getMonth());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("term_type", "termType");
		this.hashFields.put("cur_dt", "curDt");
		this.hashFields.put("acep_type", "acepType");
		this.hashFields.put("month", "month");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return termType
	 */
	public String getTermType() {
		return this.termType;
	}
	
	/**
	 * Column Info
	 * @return curDt
	 */
	public String getCurDt() {
		return this.curDt;
	}
	
	/**
	 * Column Info
	 * @return acepType
	 */
	public String getAcepType() {
		return this.acepType;
	}
	
	/**
	 * Column Info
	 * @return month
	 */
	public String getMonth() {
		return this.month;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param termType
	 */
	public void setTermType(String termType) {
		this.termType = termType;
	}
	
	/**
	 * Column Info
	 * @param curDt
	 */
	public void setCurDt(String curDt) {
		this.curDt = curDt;
	}
	
	/**
	 * Column Info
	 * @param acepType
	 */
	public void setAcepType(String acepType) {
		this.acepType = acepType;
	}
	
	/**
	 * Column Info
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
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
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTermType(JSPUtil.getParameter(request, "term_type", ""));
		setCurDt(JSPUtil.getParameter(request, "cur_dt", ""));
		setAcepType(JSPUtil.getParameter(request, "acep_type", ""));
		setMonth(JSPUtil.getParameter(request, "month", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ACEPListINVO[]
	 */
	public ACEPListINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ACEPListINVO[]
	 */
	public ACEPListINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ACEPListINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] termType = (JSPUtil.getParameter(request, prefix	+ "term_type", length));
			String[] curDt = (JSPUtil.getParameter(request, prefix	+ "cur_dt", length));
			String[] acepType = (JSPUtil.getParameter(request, prefix	+ "acep_type", length));
			String[] month = (JSPUtil.getParameter(request, prefix	+ "month", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ACEPListINVO();
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (termType[i] != null)
					model.setTermType(termType[i]);
				if (curDt[i] != null)
					model.setCurDt(curDt[i]);
				if (acepType[i] != null)
					model.setAcepType(acepType[i]);
				if (month[i] != null)
					model.setMonth(month[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getACEPListINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ACEPListINVO[]
	 */
	public ACEPListINVO[] getACEPListINVOs(){
		ACEPListINVO[] vos = (ACEPListINVO[])models.toArray(new ACEPListINVO[models.size()]);
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
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termType = this.termType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curDt = this.curDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acepType = this.acepType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.month = this.month .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
