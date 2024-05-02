/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomManHrListVO.java
*@FileTitle : CustomManHrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.13 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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
 * @author 최우석
 * @see
 * @since J2EE 1.5
 */

public class CustomManHrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomManHrListVO> models = new ArrayList<CustomManHrListVO>();
	
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String manHrItmNm = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String manHrListSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomManHrListVO() {}

	public CustomManHrListVO(String ibflag, String pagerows, String manHrListSeq, String manHrItmNm, String creUsrId, String updUsrId) {
		this.updUsrId = updUsrId;
		this.manHrItmNm = manHrItmNm;
		this.ibflag = ibflag;
		this.manHrListSeq = manHrListSeq;
		this.creUsrId = creUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("man_hr_itm_nm", getManHrItmNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("man_hr_list_seq", getManHrListSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("man_hr_itm_nm", "manHrItmNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("man_hr_list_seq", "manHrListSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getUpdUsrId() {
		return this.updUsrId;
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
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
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
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setManHrItmNm(JSPUtil.getParameter(request, "man_hr_itm_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setManHrListSeq(JSPUtil.getParameter(request, "man_hr_list_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CustomManHrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CustomManHrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomManHrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] manHrItmNm = (JSPUtil.getParameter(request, prefix	+ "man_hr_itm_nm".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] manHrListSeq = (JSPUtil.getParameter(request, prefix	+ "man_hr_list_seq".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomManHrListVO();
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (manHrItmNm[i] != null)
					model.setManHrItmNm(manHrItmNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (manHrListSeq[i] != null)
					model.setManHrListSeq(manHrListSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchManhourItemRegistrationListVOs();
	}

	public CustomManHrListVO[] getSearchManhourItemRegistrationListVOs(){
		CustomManHrListVO[] vos = (CustomManHrListVO[])models.toArray(new CustomManHrListVO[models.size()]);
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
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manHrItmNm = this.manHrItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manHrListSeq = this.manHrListSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
