/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ClosingDateVO.java
*@FileTitle : ClosingDateVO
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

public class ClosingDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ClosingDateVO> models = new ArrayList<ClosingDateVO>();
	
	/* Column Info */
	private String clzDivCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String clzFlg = null;
	/* Column Info */
	private String clzDt = null;
	/* Column Info */
	private String glIfFlg = null;
	/* Column Info */
	private String clzYrmon = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ClosingDateVO() {}

	public ClosingDateVO(String ibflag, String pagerows, String clzYrmon, String clzDt, String clzDivCd, String clzFlg, String glIfFlg) {
		this.clzDivCd = clzDivCd;
		this.ibflag = ibflag;
		this.clzFlg = clzFlg;
		this.clzDt = clzDt;
		this.glIfFlg = glIfFlg;
		this.clzYrmon = clzYrmon;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("clz_div_cd", getClzDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("clz_flg", getClzFlg());
		this.hashColumns.put("clz_dt", getClzDt());
		this.hashColumns.put("gl_if_flg", getGlIfFlg());
		this.hashColumns.put("clz_yrmon", getClzYrmon());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("clz_div_cd", "clzDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("clz_flg", "clzFlg");
		this.hashFields.put("clz_dt", "clzDt");
		this.hashFields.put("gl_if_flg", "glIfFlg");
		this.hashFields.put("clz_yrmon", "clzYrmon");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return clzDivCd
	 */
	public String getClzDivCd() {
		return this.clzDivCd;
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
	 * @return clzFlg
	 */
	public String getClzFlg() {
		return this.clzFlg;
	}
	
	/**
	 * Column Info
	 * @return clzDt
	 */
	public String getClzDt() {
		return this.clzDt;
	}
	
	/**
	 * Column Info
	 * @return glIfFlg
	 */
	public String getGlIfFlg() {
		return this.glIfFlg;
	}
	
	/**
	 * Column Info
	 * @return clzYrmon
	 */
	public String getClzYrmon() {
		return this.clzYrmon;
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
	 * @param clzDivCd
	 */
	public void setClzDivCd(String clzDivCd) {
		this.clzDivCd = clzDivCd;
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
	 * @param clzFlg
	 */
	public void setClzFlg(String clzFlg) {
		this.clzFlg = clzFlg;
	}
	
	/**
	 * Column Info
	 * @param clzDt
	 */
	public void setClzDt(String clzDt) {
		this.clzDt = clzDt;
	}
	
	/**
	 * Column Info
	 * @param glIfFlg
	 */
	public void setGlIfFlg(String glIfFlg) {
		this.glIfFlg = glIfFlg;
	}
	
	/**
	 * Column Info
	 * @param clzYrmon
	 */
	public void setClzYrmon(String clzYrmon) {
		this.clzYrmon = clzYrmon;
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
		setClzDivCd(JSPUtil.getParameter(request, "clz_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setClzFlg(JSPUtil.getParameter(request, "clz_flg", ""));
		setClzDt(JSPUtil.getParameter(request, "clz_dt", ""));
		setGlIfFlg(JSPUtil.getParameter(request, "gl_if_flg", ""));
		setClzYrmon(JSPUtil.getParameter(request, "clz_yrmon", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return ClosingDateVO[]
	 */
	public ClosingDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ClosingDateVO[]
	 */
	public ClosingDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ClosingDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] clzDivCd = (JSPUtil.getParameter(request, prefix	+ "clz_div_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] clzFlg = (JSPUtil.getParameter(request, prefix	+ "clz_flg".trim(), length));
			String[] clzDt = (JSPUtil.getParameter(request, prefix	+ "clz_dt".trim(), length));
			String[] glIfFlg = (JSPUtil.getParameter(request, prefix	+ "gl_if_flg".trim(), length));
			String[] clzYrmon = (JSPUtil.getParameter(request, prefix	+ "clz_yrmon".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ClosingDateVO();
				if (clzDivCd[i] != null)
					model.setClzDivCd(clzDivCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (clzFlg[i] != null)
					model.setClzFlg(clzFlg[i]);
				if (clzDt[i] != null)
					model.setClzDt(clzDt[i]);
				if (glIfFlg[i] != null)
					model.setGlIfFlg(glIfFlg[i]);
				if (clzYrmon[i] != null)
					model.setClzYrmon(clzYrmon[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getClosingDateVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return ClosingDateVO[]
	 */
	public ClosingDateVO[] getClosingDateVOs(){
		ClosingDateVO[] vos = (ClosingDateVO[])models.toArray(new ClosingDateVO[models.size()]);
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
		this.clzDivCd = this.clzDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clzFlg = this.clzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clzDt = this.clzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glIfFlg = this.glIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clzYrmon = this.clzYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
