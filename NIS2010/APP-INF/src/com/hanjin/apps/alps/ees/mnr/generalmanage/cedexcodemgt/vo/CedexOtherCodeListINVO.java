/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CedexOtherCodeListINVO.java
*@FileTitle : CedexOtherCodeListINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.11 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo;

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
 * @author 박명신
 * @since J2EE 1.5
 * @see ..
 */
 
public class CedexOtherCodeListINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CedexOtherCodeListINVO> models = new ArrayList<CedexOtherCodeListINVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String eqCedexOtrTpCd = null;
	/* Column Info */
	private String eqCedexOtrCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CedexOtherCodeListINVO() {}
	
	/**
	 * CedexOtherCodeListINVO 객체를 생성   
	 */
	public CedexOtherCodeListINVO(String ibflag, String pagerows, String eqCedexOtrTpCd, String eqCedexOtrCd) {
		this.ibflag = ibflag;
		this.eqCedexOtrTpCd = eqCedexOtrTpCd;
		this.eqCedexOtrCd = eqCedexOtrCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_cedex_otr_tp_cd", getEqCedexOtrTpCd());
		this.hashColumns.put("eq_cedex_otr_cd", getEqCedexOtrCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_cedex_otr_tp_cd", "eqCedexOtrTpCd");
		this.hashFields.put("eq_cedex_otr_cd", "eqCedexOtrCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getEqCedexOtrTpCd() {
		return this.eqCedexOtrTpCd;
	}
	public String getEqCedexOtrCd() {
		return this.eqCedexOtrCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setEqCedexOtrTpCd(String eqCedexOtrTpCd) {
		this.eqCedexOtrTpCd = eqCedexOtrTpCd;
		//this.eqCedexOtrTpCd=true;
	}
	public void setEqCedexOtrCd(String eqCedexOtrCd) {
		this.eqCedexOtrCd = eqCedexOtrCd;
		//this.eqCedexOtrCd=true;
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
		setEqCedexOtrTpCd(JSPUtil.getParameter(request, "eq_cedex_otr_tp_cd", ""));
		setEqCedexOtrCd(JSPUtil.getParameter(request, "eq_cedex_otr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * 그리드값을 통채로 받아와 해당 VO배열로 리턴 
	 * @return	CedexOtherCodeListINVO[]   VO배열로    
	 */
	public CedexOtherCodeListINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * 그리드값을 통채로 받아와 해당 VO배열로 리턴 
	 * @return	CedexOtherCodeListINVO[]   VO배열로    
	 */
	public CedexOtherCodeListINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CedexOtherCodeListINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] eqCedexOtrTpCd = (JSPUtil.getParameter(request, prefix	+ "eq_cedex_otr_tp_cd".trim(), length));
			String[] eqCedexOtrCd = (JSPUtil.getParameter(request, prefix	+ "eq_cedex_otr_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CedexOtherCodeListINVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqCedexOtrTpCd[i] != null)
					model.setEqCedexOtrTpCd(eqCedexOtrTpCd[i]);
				if (eqCedexOtrCd[i] != null)
					model.setEqCedexOtrCd(eqCedexOtrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCedexOtherCodeListINVOs();
	}

	/**
	 * getCedexOtherCodeListINVOs 
	 * @return	CedexOtherCodeListINVO[]   VO배열로    
	 */
	public CedexOtherCodeListINVO[] getCedexOtherCodeListINVOs(){
		CedexOtherCodeListINVO[] vos = (CedexOtherCodeListINVO[])models.toArray(new CedexOtherCodeListINVO[models.size()]);
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
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field 
	 * @param i 
	 * @param arr
	 * @return arr    
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1]; 
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null; 
		}
		return arr; 
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCedexOtrTpCd = this.eqCedexOtrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCedexOtrCd = this.eqCedexOtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
