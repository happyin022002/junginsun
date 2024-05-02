/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchManhourItemRegistrationListVO.java
*@FileTitle : SearchManhourItemRegistrationListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.13 최우석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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
 * @author 최우석
 * @see
 * @since J2EE 1.5
 */

public class SearchManhourItemRegistrationListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchManhourItemRegistrationListVO> models = new ArrayList<SearchManhourItemRegistrationListVO>();
	
	/* Column Info */
	private String manHrItmNm = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String manHrListSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchManhourItemRegistrationListVO() {}

	public SearchManhourItemRegistrationListVO(String ibflag, String pagerows, String manHrListSeq, String manHrItmNm) {
		this.manHrItmNm = manHrItmNm;
		this.ibflag = ibflag;
		this.manHrListSeq = manHrListSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("man_hr_itm_nm", getManHrItmNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("man_hr_list_seq", getManHrListSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("man_hr_itm_nm", "manHrItmNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("man_hr_list_seq", "manHrListSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getManHrItmNm() {
		return this.manHrItmNm;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getManHrListSeq() {
		return this.manHrListSeq;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setManHrItmNm(String manHrItmNm) {
		this.manHrItmNm = manHrItmNm;
		//this.manHrItmNm=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setManHrListSeq(String manHrListSeq) {
		this.manHrListSeq = manHrListSeq;
		//this.manHrListSeq=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setManHrItmNm(JSPUtil.getParameter(request, "man_hr_itm_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setManHrListSeq(JSPUtil.getParameter(request, "man_hr_list_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchManhourItemRegistrationListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchManhourItemRegistrationListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchManhourItemRegistrationListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] manHrItmNm = (JSPUtil.getParameter(request, prefix	+ "man_hr_itm_nm".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] manHrListSeq = (JSPUtil.getParameter(request, prefix	+ "man_hr_list_seq".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchManhourItemRegistrationListVO();
				if (manHrItmNm[i] != null)
					model.setManHrItmNm(manHrItmNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (manHrListSeq[i] != null)
					model.setManHrListSeq(manHrListSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchManhourItemRegistrationListVOs();
	}

	public SearchManhourItemRegistrationListVO[] getSearchManhourItemRegistrationListVOs(){
		SearchManhourItemRegistrationListVO[] vos = (SearchManhourItemRegistrationListVO[])models.toArray(new SearchManhourItemRegistrationListVO[models.size()]);
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
		this.manHrItmNm = this.manHrItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manHrListSeq = this.manHrListSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
