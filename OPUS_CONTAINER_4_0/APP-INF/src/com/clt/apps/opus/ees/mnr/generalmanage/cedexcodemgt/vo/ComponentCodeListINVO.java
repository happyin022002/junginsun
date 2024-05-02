/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComponentCodeListINVO.java
*@FileTitle : ComponentCodeListINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.05.04 김완규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김완규
 * @since J2EE 1.5
 * @see
 */

public class ComponentCodeListINVO extends AbstractValueObject {
	private Logger log = Logger.getLogger("org.apache.log4j.Logger");
	private static final long serialVersionUID = 1L;
	
	private Collection<ComponentCodeListINVO> models = new ArrayList<ComponentCodeListINVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String fType = null;
	/* Column Info */
	private String eqCmpoGrpTpCd = null;
	/* Column Info */
	private String keyValue = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ComponentCodeListINVO() {}

	/**
	 * ComponentCodeListINVO 객체 생성
	 */
	public ComponentCodeListINVO(String ibflag, String pagerows, String eqCmpoGrpTpCd, String fType, String keyValue) {
		this.ibflag = ibflag;
		this.fType = fType;
		this.eqCmpoGrpTpCd = eqCmpoGrpTpCd;
		this.keyValue = keyValue;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_type", getFType());
		this.hashColumns.put("eq_cmpo_grp_tp_cd", getEqCmpoGrpTpCd());
		this.hashColumns.put("key_value", getKeyValue());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_type", "fType");
		this.hashFields.put("eq_cmpo_grp_tp_cd", "eqCmpoGrpTpCd");
		this.hashFields.put("key_value", "keyValue");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getFType() {
		return this.fType;
	}
	public String getEqCmpoGrpTpCd() {
		return this.eqCmpoGrpTpCd;
	}
	public String getKeyValue() {
		return this.keyValue;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setFType(String fType) {
		this.fType = fType;
		//this.fType=true;
	}
	public void setEqCmpoGrpTpCd(String eqCmpoGrpTpCd) {
		this.eqCmpoGrpTpCd = eqCmpoGrpTpCd;
		//this.eqCmpoGrpTpCd=true;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
		//this.keyValue=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	
	/**
	 * request로 받아온 화면값을 해당 VO로 매핑한다.
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFType(JSPUtil.getParameter(request, "f_type", ""));
		setEqCmpoGrpTpCd(JSPUtil.getParameter(request, "eq_cmpo_grp_tp_cd", ""));
		setKeyValue(JSPUtil.getParameter(request, "key_value", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * 그리드값을 통채로 받아와 해당 VO배열로 리턴 
	 * @return	ComponentCodeListINVO[]   VO배열로    
	 */
	public ComponentCodeListINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * 그리드값을 통채로 받아와 해당 VO배열로 리턴 
	 * @return	ComponentCodeListINVO[]   VO배열로    
	 */
	public ComponentCodeListINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComponentCodeListINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] fType = (JSPUtil.getParameter(request, prefix	+ "f_type".trim(), length));
			String[] eqCmpoGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_grp_tp_cd".trim(), length));
			String[] keyValue = (JSPUtil.getParameter(request, prefix	+ "key_value".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ComponentCodeListINVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fType[i] != null)
					model.setFType(fType[i]);
				if (eqCmpoGrpTpCd[i] != null)
					model.setEqCmpoGrpTpCd(eqCmpoGrpTpCd[i]);
				if (keyValue[i] != null)
					model.setKeyValue(keyValue[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			log.error("err " + e.toString(), e);
		}
		return getComponentCodeListINVOs();
	}

	/**
	 * getComponentCodeListINVOs 
	 * @return	ComponentCodeListINVO[]   VO배열로    
	 */
	public ComponentCodeListINVO[] getComponentCodeListINVOs(){
		ComponentCodeListINVO[] vos = (ComponentCodeListINVO[])models.toArray(new ComponentCodeListINVO[models.size()]);
		return vos;
	}

	/**
	 * 전체 필드네임을 리턴  
	 * @return String
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
			log.error("err " + ex.toString(), ex);
		}
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
			throw new IllegalAccessException(ex.getMessage());
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fType = this.fType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoGrpTpCd = this.eqCmpoGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyValue = this.keyValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
