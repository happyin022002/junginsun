/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DamageLocationCodeListINVO.java
*@FileTitle : DamageLocationCodeListINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.09.23 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DamageLocationCodeListINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DamageLocationCodeListINVO> models = new ArrayList<DamageLocationCodeListINVO>();
	
	/* Column Info */
	private String eqLocCdLvl = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locLvl = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String fType = null;
	/* Column Info */
	private String keyValue = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DamageLocationCodeListINVO() {}

	public DamageLocationCodeListINVO(String ibflag, String pagerows, String locLvl, String keyValue, String fType, String eqKndCd, String eqLocCdLvl) {
		this.eqLocCdLvl = eqLocCdLvl;
		this.ibflag = ibflag;
		this.locLvl = locLvl;
		this.eqKndCd = eqKndCd;
		this.fType = fType;
		this.keyValue = keyValue;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eq_loc_cd_lvl", getEqLocCdLvl());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_lvl", getLocLvl());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("f_type", getFType());
		this.hashColumns.put("key_value", getKeyValue());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eq_loc_cd_lvl", "eqLocCdLvl");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_lvl", "locLvl");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("f_type", "fType");
		this.hashFields.put("key_value", "keyValue");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eqLocCdLvl
	 */
	public String getEqLocCdLvl() {
		return this.eqLocCdLvl;
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
	 * @return locLvl
	 */
	public String getLocLvl() {
		return this.locLvl;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return fType
	 */
	public String getFType() {
		return this.fType;
	}
	
	/**
	 * Column Info
	 * @return keyValue
	 */
	public String getKeyValue() {
		return this.keyValue;
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
	 * @param eqLocCdLvl
	 */
	public void setEqLocCdLvl(String eqLocCdLvl) {
		this.eqLocCdLvl = eqLocCdLvl;
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
	 * @param locLvl
	 */
	public void setLocLvl(String locLvl) {
		this.locLvl = locLvl;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param fType
	 */
	public void setFType(String fType) {
		this.fType = fType;
	}
	
	/**
	 * Column Info
	 * @param keyValue
	 */
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
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
		setEqLocCdLvl(JSPUtil.getParameter(request, "eq_loc_cd_lvl", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocLvl(JSPUtil.getParameter(request, "loc_lvl", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setFType(JSPUtil.getParameter(request, "f_type", ""));
		setKeyValue(JSPUtil.getParameter(request, "key_value", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DamageLocationCodeListINVO[]
	 */
	public DamageLocationCodeListINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DamageLocationCodeListINVO[]
	 */
	public DamageLocationCodeListINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DamageLocationCodeListINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eqLocCdLvl = (JSPUtil.getParameter(request, prefix	+ "eq_loc_cd_lvl", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locLvl = (JSPUtil.getParameter(request, prefix	+ "loc_lvl", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] fType = (JSPUtil.getParameter(request, prefix	+ "f_type", length));
			String[] keyValue = (JSPUtil.getParameter(request, prefix	+ "key_value", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DamageLocationCodeListINVO();
				if (eqLocCdLvl[i] != null)
					model.setEqLocCdLvl(eqLocCdLvl[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locLvl[i] != null)
					model.setLocLvl(locLvl[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (fType[i] != null)
					model.setFType(fType[i]);
				if (keyValue[i] != null)
					model.setKeyValue(keyValue[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDamageLocationCodeListINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DamageLocationCodeListINVO[]
	 */
	public DamageLocationCodeListINVO[] getDamageLocationCodeListINVOs(){
		DamageLocationCodeListINVO[] vos = (DamageLocationCodeListINVO[])models.toArray(new DamageLocationCodeListINVO[models.size()]);
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
		this.eqLocCdLvl = this.eqLocCdLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locLvl = this.locLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fType = this.fType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyValue = this.keyValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
