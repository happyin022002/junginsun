/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMnrGeneralCodeVO.java
*@FileTitle : CustomMnrGeneralCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.12 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

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
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 박명신
 * @since J2EE 1.5
 * @see ..
 */

public class CustomMnrGeneralCodeVO extends AbstractValueObject {
	
	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrGeneralCodeVO> models = new ArrayList<CustomMnrGeneralCodeVO>();
	
	/* Column Info */
	private String cdDesc = null; 
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String cdId = null; 
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String evDesc = null;
	/* Column Info */
	private String maxPntNo = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrGeneralCodeVO() {}

	/**
	 * CustomMnrGeneralCodeVO 객체를 생성  
	 */
	public CustomMnrGeneralCodeVO(String ibflag, String pagerows, String cdId, String cdDesc, String evDesc, String maxPntNo) {
		this.cdDesc = cdDesc;
		this.ibflag = ibflag;
		this.cdId = cdId;
		this.pagerows = pagerows;
		this.evDesc = evDesc;
		this.maxPntNo = maxPntNo;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cd_desc", getCdDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cd_id", getCdId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sheet1_ev_desc", getEvDesc());
		this.hashColumns.put("sheet1_max_pnt_no", getMaxPntNo());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cd_desc", "cdDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cd_id", "cdId");
		this.hashFields.put("sheet1_ev_desc", "evDesc");
		this.hashFields.put("sheet1_max_pnt_no", "maxPntNo");
		return this.hashFields;
	}
	
	public String getCdDesc() {
		return this.cdDesc;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getCdId() {
		return this.cdId;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getEvDesc() {
		return this.evDesc;
	}
	public String getMaxPntNo() {
		return this.maxPntNo;
	}

	public void setCdDesc(String cdDesc) {
		this.cdDesc = cdDesc;
		//this.cdDesc=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setCdId(String cdId) {
		this.cdId = cdId;
		//this.cdId=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setEvDesc(String evDesc) {
		this.evDesc = evDesc;
		//this.evDesc=true;
	}
	public void setMaxPntNo(String maxPntNo) {
		this.maxPntNo = maxPntNo;
		//this.maxPntNo=true;
	}
	/**
	 * request로 받아온 화면값을 해당 VO로 매핑한다.
	 */
	public void fromRequest(HttpServletRequest request) {
		setCdDesc(JSPUtil.getParameter(request, "cd_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCdId(JSPUtil.getParameter(request, "cd_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEvDesc(JSPUtil.getParameter(request, "sheet1_ev_desc", ""));
		setMaxPntNo(JSPUtil.getParameter(request, "sheet1_max_pnt_no", ""));
	}
	
	/**
	 * 그리드값을 통채로 받아와 해당 VO배열로 리턴 
	 * @return	CustomMnrGeneralCodeVO[]   VO배열로    
	 */
	public CustomMnrGeneralCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * 그리드값을 통채로 받아와 해당 VO배열로 리턴 
	 * @return	CustomMnrGeneralCodeVO[]   VO배열로    
	 */
	public CustomMnrGeneralCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrGeneralCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cdDesc = (JSPUtil.getParameter(request, prefix	+ "cd_desc".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cdId = (JSPUtil.getParameter(request, prefix	+ "cd_id".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] evDesc = (JSPUtil.getParameter(request, prefix	+ "ev_desc".trim(), length));
			String[] maxPntNo = (JSPUtil.getParameter(request, prefix	+ "max_pnt_no".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrGeneralCodeVO();
				if (cdDesc[i] != null)
					model.setCdDesc(cdDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cdId[i] != null)
					model.setCdId(cdId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (evDesc[i] != null)
					model.setPagerows(evDesc[i]);
				if (maxPntNo[i] != null)
					model.setPagerows(maxPntNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrGeneralCodeVOs();
	}

	/**
	 * getCustomMnrGeneralCodeVOs 
	 * @return	CustomMnrGeneralCodeVO[]   VO배열로    
	 */
	public CustomMnrGeneralCodeVO[] getCustomMnrGeneralCodeVOs(){
		CustomMnrGeneralCodeVO[] vos = (CustomMnrGeneralCodeVO[])models.toArray(new CustomMnrGeneralCodeVO[models.size()]);
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
		this.cdDesc = this.cdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdId = this.cdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evDesc = this.evDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxPntNo = this.maxPntNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
