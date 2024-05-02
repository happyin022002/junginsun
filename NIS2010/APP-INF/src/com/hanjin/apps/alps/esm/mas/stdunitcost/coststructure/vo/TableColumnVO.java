/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchConditionVO.java
*@FileTitle : SearchConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.07.24 임옥영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo;

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
 * @author 임옥영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TableColumnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TableColumnVO> models = new ArrayList<TableColumnVO>();
	
	/* Column Info */
	private String ibflag = null;
	private String pagerows = null;
	/* Column Info */
	private String colname = null;
	/* Column Info */
	private String inequality = null;
	/* Column Info */
	private String value = null;	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TableColumnVO() {}

	public TableColumnVO(String ibflag, String pagerows,String colname, String inequality, String value){
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.colname = colname;
		this.inequality = inequality;
		this.value = value;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("colname", getColName());
		this.hashColumns.put("inequality", getInEquality());
		this.hashColumns.put("value", getValue());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("colname", "colname");
		this.hashFields.put("inequality", "inequality");
		this.hashFields.put("value", "value");
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	/**
	 * colname
	 * @return colname
	 */
	public String getColName() {
		return this.colname;
	}
	/**
	 * inequality
	 * @return inequality
	 */
	public String getInEquality() {
		return this.inequality;
	}	
	/**
	 * inequality
	 * @param value
	 */
	public String getValue() {
		return this.value;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	/**
	 * colname
	 * @param colname
	 */
	public void setColName(String colname) {
		this.colname = colname;
	}
	/**
	 * inequality
	 * @param inequality
	 */
	public void setInEquality(String inequality) {
		this.inequality = inequality;
	}
	/**
	 * value
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setColName(JSPUtil.getParameter(request, "colname", ""));
		setInEquality(JSPUtil.getParameter(request, "inequality", ""));
		setValue(JSPUtil.getParameter(request, "value", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchConditionVO[]
	 */
	public TableColumnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchConditionVO[]
	 */
	public TableColumnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TableColumnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] colname = (JSPUtil.getParameter(request, prefix	+ "colname", length));
			String[] inequality = (JSPUtil.getParameter(request, prefix	+ "inequality", length));
			String[] value = (JSPUtil.getParameter(request, prefix	+ "value", length));
			
			for (int i = 0; i < length; i++) {
				model = new TableColumnVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (colname[i] != null)
					model.setColName(colname[i]);
				if (inequality[i] != null)
					model.setInEquality(inequality[i]);
				if (value[i] != null)
					model.setValue(value[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTableColumnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchConditionVO[]
	 */
	public TableColumnVO[] getTableColumnVOs(){
		TableColumnVO[] vos = (TableColumnVO[])models.toArray(new TableColumnVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colname = this.colname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inequality = this.inequality .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.value = this.value .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
