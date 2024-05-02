/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MdmCustomerVenderVO.java
 *@FileTitle : MdmCustomerVenderVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.05
 *@LastModifier : 이호진
 *@LastVersion : 1.0
 * 2009.09.05 이호진
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.common.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 이호진
 * @since J2EE 1.5
 */
public class MdmCustomerVenderVO extends AbstractValueObject{
	
private static final long serialVersionUID = 1L;
	
	private Collection<MdmCustomerVenderVO> models = new ArrayList<MdmCustomerVenderVO>();
	
	private String ibflag = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String name = null;
	
	/*	hashColumnInfo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInfo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MdmCustomerVenderVO() {}

	public MdmCustomerVenderVO(String ibflag, String code, String name) {
		this.ibflag = ibflag;
		this.code = code;
		this.name = name;
	}
	
	/**
	 * hashColumnInfo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("name", getName());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInfo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("code", "code");
		this.hashFields.put("name", "name");
		return this.hashFields;
	}
	
	public String getIbflag() {
    	return ibflag;
    }
	public String getCode() {
		return this.code;
	}
	public String getName() {
		return this.name;
	}
	
	public void setIbflag(String ibflag) {
    	this.ibflag = ibflag;
    }
	public void setCode(String code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCode(JSPUtil.getParameter(request, "code", ""));
		setName(JSPUtil.getParameter(request, "name", ""));
		
	}

	public MdmCustomerVenderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public MdmCustomerVenderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmCustomerVenderVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code".trim(), length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name".trim(), length));
			
			
			for (int i = 0; i < length; i++) {
				model = new MdmCustomerVenderVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (name[i] != null)
					model.setName(name[i]);
				
				models.add(model);
			}

		} catch (Exception e) {}
		return getMdmCustomerVenderVOs();
	}

	public MdmCustomerVenderVO[] getMdmCustomerVenderVOs(){
		MdmCustomerVenderVO[] vos = (MdmCustomerVenderVO[])models.toArray(new MdmCustomerVenderVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}

}
