/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OfficeHierarchyVO.java
*@FileTitle : OfficeHierarchyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.19 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 진윤오
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class OfficeHierarchyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OfficeHierarchyVO> models = new ArrayList<OfficeHierarchyVO>();
	
	/* Column Info */
	private String level2 = null;
	/* Column Info */
	private String level3 = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String level1 = null;
	/* Column Info */
	private String rgnOfcFlg = null;
	/* Column Info */
	private String level4 = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OfficeHierarchyVO() {}

	public OfficeHierarchyVO(String ibflag, String pagerows, String level1, String level2, String level3, String level4, String rgnOfcFlg) {
		this.level2 = level2;
		this.level3 = level3;
		this.ibflag = ibflag;
		this.level1 = level1;
		this.rgnOfcFlg = rgnOfcFlg;
		this.level4 = level4;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("level2", getLevel2());
		this.hashColumns.put("level3", getLevel3());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("level1", getLevel1());
		this.hashColumns.put("rgn_ofc_flg", getRgnOfcFlg());
		this.hashColumns.put("level4", getLevel4());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("level2", "level2");
		this.hashFields.put("level3", "level3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("level1", "level1");
		this.hashFields.put("rgn_ofc_flg", "rgnOfcFlg");
		this.hashFields.put("level4", "level4");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return level2
	 */
	public String getLevel2() {
		return this.level2;
	}
	
	/**
	 * Column Info
	 * @return level3
	 */
	public String getLevel3() {
		return this.level3;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return level1
	 */
	public String getLevel1() {
		return this.level1;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcFlg
	 */
	public String getRgnOfcFlg() {
		return this.rgnOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return level4
	 */
	public String getLevel4() {
		return this.level4;
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
	 * @param level2
	 */
	public void setLevel2(String level2) {
		this.level2 = level2;
	}
	
	/**
	 * Column Info
	 * @param level3
	 */
	public void setLevel3(String level3) {
		this.level3 = level3;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param level1
	 */
	public void setLevel1(String level1) {
		this.level1 = level1;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcFlg
	 */
	public void setRgnOfcFlg(String rgnOfcFlg) {
		this.rgnOfcFlg = rgnOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param level4
	 */
	public void setLevel4(String level4) {
		this.level4 = level4;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLevel2(JSPUtil.getParameter(request, "level2", ""));
		setLevel3(JSPUtil.getParameter(request, "level3", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLevel1(JSPUtil.getParameter(request, "level1", ""));
		setRgnOfcFlg(JSPUtil.getParameter(request, "rgn_ofc_flg", ""));
		setLevel4(JSPUtil.getParameter(request, "level4", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return OfficeHierarchyVO[]
	 */
	public OfficeHierarchyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfficeHierarchyVO[]
	 */
	public OfficeHierarchyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OfficeHierarchyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] level2 = (JSPUtil.getParameter(request, prefix	+ "level2".trim(), length));
			String[] level3 = (JSPUtil.getParameter(request, prefix	+ "level3".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] level1 = (JSPUtil.getParameter(request, prefix	+ "level1".trim(), length));
			String[] rgnOfcFlg = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_flg".trim(), length));
			String[] level4 = (JSPUtil.getParameter(request, prefix	+ "level4".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new OfficeHierarchyVO();
				if (level2[i] != null)
					model.setLevel2(level2[i]);
				if (level3[i] != null)
					model.setLevel3(level3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (level1[i] != null)
					model.setLevel1(level1[i]);
				if (rgnOfcFlg[i] != null)
					model.setRgnOfcFlg(rgnOfcFlg[i]);
				if (level4[i] != null)
					model.setLevel4(level4[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOfficeHierarchyVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return OfficeHierarchyVO[]
	 */
	public OfficeHierarchyVO[] getOfficeHierarchyVOs(){
		OfficeHierarchyVO[] vos = (OfficeHierarchyVO[])models.toArray(new OfficeHierarchyVO[models.size()]);
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
	public void unDataFormat(){
		this.level2 = this.level2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level3 = this.level3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level1 = this.level1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcFlg = this.rgnOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level4 = this.level4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
