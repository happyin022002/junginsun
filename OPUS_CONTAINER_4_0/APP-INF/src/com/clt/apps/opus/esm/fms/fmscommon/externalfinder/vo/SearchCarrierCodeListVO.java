/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCarrierCodeListVO.java
*@FileTitle : SearchCarrierCodeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.13 윤세영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 윤세영
 * @since J2EE 1.5
 * @see  ESM_FMS_0077HTMLAction
 */

public class SearchCarrierCodeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCarrierCodeListVO> models = new ArrayList<SearchCarrierCodeListVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String crrFullNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCarrierCodeListVO() {}

	public SearchCarrierCodeListVO(String ibflag, String pagerows, String crrCd, String crrFullNm) {
		this.ibflag = ibflag;
		this.crrCd = crrCd;
		this.crrFullNm = crrFullNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("crr_full_nm", getCrrFullNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("crr_full_nm", "crrFullNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getCrrCd() {
		return this.crrCd;
	}
	public String getCrrFullNm() {
		return this.crrFullNm;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
		//this.crrCd=true;
	}
	public void setCrrFullNm(String crrFullNm) {
		this.crrFullNm = crrFullNm;
		//this.crrFullNm=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setCrrFullNm(JSPUtil.getParameter(request, "crr_full_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchCarrierCodeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchCarrierCodeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCarrierCodeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd".trim(), length));
			String[] crrFullNm = (JSPUtil.getParameter(request, prefix	+ "crr_full_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCarrierCodeListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (crrFullNm[i] != null)
					model.setCrrFullNm(crrFullNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchCarrierCodeListVOs();
	}

	public SearchCarrierCodeListVO[] getSearchCarrierCodeListVOs(){
		SearchCarrierCodeListVO[] vos = (SearchCarrierCodeListVO[])models.toArray(new SearchCarrierCodeListVO[models.size()]);
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
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrFullNm = this.crrFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
