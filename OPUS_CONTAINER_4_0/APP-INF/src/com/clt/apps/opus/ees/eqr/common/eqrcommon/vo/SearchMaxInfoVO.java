/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchMaxInfoVO.java
*@FileTitle : searchMaxInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.10 채창호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.common.eqrcommon.vo;

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
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMaxInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMaxInfoVO> models = new ArrayList<SearchMaxInfoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String condition = null;
	/* Column Info */
	private String tableName = null;
	/* Column Info */
	private String maxUsrid = null;
	/* Column Info */
	private String maxUpdate = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMaxInfoVO() {}

	public SearchMaxInfoVO(String ibflag, String pagerows, String maxUsrid, String maxUpdate, String updDt, String tableName, String condition) {
		this.updDt = updDt;
		this.ibflag = ibflag;
		this.condition = condition;
		this.tableName = tableName;
		this.maxUsrid = maxUsrid;
		this.maxUpdate = maxUpdate;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("condition", getCondition());
		this.hashColumns.put("table_name", getTableName());
		this.hashColumns.put("max_usrid", getMaxUsrid());
		this.hashColumns.put("max_update", getMaxUpdate());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("condition", "condition");
		this.hashFields.put("table_name", "tableName");
		this.hashFields.put("max_usrid", "maxUsrid");
		this.hashFields.put("max_update", "maxUpdate");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return condition
	 */
	public String getCondition() {
		return this.condition;
	}
	
	/**
	 * Column Info
	 * @return tableName
	 */
	public String getTableName() {
		return this.tableName;
	}
	
	/**
	 * Column Info
	 * @return maxUsrid
	 */
	public String getMaxUsrid() {
		return this.maxUsrid;
	}
	
	/**
	 * Column Info
	 * @return maxUpdate
	 */
	public String getMaxUpdate() {
		return this.maxUpdate;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	/**
	 * Column Info
	 * @param tableName
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	/**
	 * Column Info
	 * @param maxUsrid
	 */
	public void setMaxUsrid(String maxUsrid) {
		this.maxUsrid = maxUsrid;
	}
	
	/**
	 * Column Info
	 * @param maxUpdate
	 */
	public void setMaxUpdate(String maxUpdate) {
		this.maxUpdate = maxUpdate;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCondition(JSPUtil.getParameter(request, "condition", ""));
		setTableName(JSPUtil.getParameter(request, "table_name", ""));
		setMaxUsrid(JSPUtil.getParameter(request, "max_usrid", ""));
		setMaxUpdate(JSPUtil.getParameter(request, "max_update", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchMaxInfoVO[]
	 */
	public SearchMaxInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchMaxInfoVO[]
	 */
	public SearchMaxInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMaxInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] condition = (JSPUtil.getParameter(request, prefix	+ "condition", length));
			String[] tableName = (JSPUtil.getParameter(request, prefix	+ "table_name", length));
			String[] maxUsrid = (JSPUtil.getParameter(request, prefix	+ "max_usrid", length));
			String[] maxUpdate = (JSPUtil.getParameter(request, prefix	+ "max_update", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMaxInfoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (condition[i] != null)
					model.setCondition(condition[i]);
				if (tableName[i] != null)
					model.setTableName(tableName[i]);
				if (maxUsrid[i] != null)
					model.setMaxUsrid(maxUsrid[i]);
				if (maxUpdate[i] != null)
					model.setMaxUpdate(maxUpdate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchMaxInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchMaxInfoVO[]
	 */
	public SearchMaxInfoVO[] getsearchMaxInfoVOs(){
		SearchMaxInfoVO[] vos = (SearchMaxInfoVO[])models.toArray(new SearchMaxInfoVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condition = this.condition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tableName = this.tableName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxUsrid = this.maxUsrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxUpdate = this.maxUpdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
