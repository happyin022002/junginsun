/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VariableHeaderVO.java
*@FileTitle : VariableHeaderVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 박상희
*@LastVersion : 1.0
* 2009.07.24 박상희 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo;

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
 * @author 박상희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VariableHeaderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VariableHeaderVO> models = new ArrayList<VariableHeaderVO>();
	
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String value = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VariableHeaderVO() {}

	public VariableHeaderVO(String code, String value){
		this.code = code;
		this.value = value;
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("value", getValue());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("code", "code");
		this.hashFields.put("value", "value");
		return this.hashFields;
	}

	/**
	 * VO 배열을 반환
	 * @return VariableHeaderVO[]
	 */
	public VariableHeaderVO[] getVariableHeaderVOs(){
		VariableHeaderVO[] vos = (VariableHeaderVO[])models.toArray(new VariableHeaderVO[models.size()]);
		return vos;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCode(JSPUtil.getParameter(request, "code", ""));
		setValue(JSPUtil.getParameter(request, "value", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSoCodeVO[]
	 */
	public VariableHeaderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}
	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSoCodeVO[]
	 */
	public VariableHeaderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VariableHeaderVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] value = (JSPUtil.getParameter(request, prefix	+ "value", length));
			for (int i = 0; i < length; i++) {
				model = new VariableHeaderVO();
				if (code[i] != null)
					model.setCode(code[i]);
				if (value[i] != null)
					model.setValue(value[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVariableHeaderVOs();
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
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.value = this.value .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
