/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FwdrListCondVO.java
*@FileTitle : FwdrListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.12 경종윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo;

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
 * @author 경종윤
 * @since J2EE 1.5
 * @see ..
 */

public class FwdrListCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FwdrListCondVO> models = new ArrayList<FwdrListCondVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String anrFwrdId = null;
	/* Column Info */
	private String oldAnrFwrdId = null;
	/* Column Info */
	private String fwrdNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FwdrListCondVO() {}

	public FwdrListCondVO(String ibflag, String pagerows, String anrFwrdId, String oldAnrFwrdId, String fwrdNm) {
		this.ibflag = ibflag;
		this.anrFwrdId = anrFwrdId;
		this.oldAnrFwrdId = oldAnrFwrdId;
		this.fwrdNm = fwrdNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("anr_fwrd_id", getAnrFwrdId());
		this.hashColumns.put("old_anr_fwrd_id", getOldAnrFwrdId());
		this.hashColumns.put("fwrd_nm", getFwrdNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("anr_fwrd_id", "anrFwrdId");
		this.hashFields.put("old_anr_fwrd_id", "oldAnrFwrdId");
		this.hashFields.put("fwrd_nm", "fwrdNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getAnrFwrdId() {
		return this.anrFwrdId;
	}
	public String getOldAnrFwrdId() {
		return this.oldAnrFwrdId;
	}
	public String getFwrdNm() {
		return this.fwrdNm;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setAnrFwrdId(String anrFwrdId) {
		this.anrFwrdId = anrFwrdId;
		//this.anrFwrdId=true;
	}
	public void setOldAnrFwrdId(String oldAnrFwrdId) {
		this.oldAnrFwrdId = oldAnrFwrdId;
		//this.anrFwrdId=true;
	}
	public void setFwrdNm(String fwrdNm) {
		this.fwrdNm = fwrdNm;
		//this.fwrdNm=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAnrFwrdId(JSPUtil.getParameter(request, "anr_fwrd_id", ""));
		setOldAnrFwrdId(JSPUtil.getParameter(request, "old_anr_fwrd_id", ""));
		setFwrdNm(JSPUtil.getParameter(request, "fwrd_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public FwdrListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public FwdrListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FwdrListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] anrFwrdId = (JSPUtil.getParameter(request, prefix	+ "anr_fwrd_id".trim(), length));
			String[] oldAnrFwrdId = (JSPUtil.getParameter(request, prefix	+ "old_anr_fwrd_id".trim(), length));
			String[] fwrdNm = (JSPUtil.getParameter(request, prefix	+ "fwrd_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new FwdrListCondVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (anrFwrdId[i] != null)
					model.setAnrFwrdId(anrFwrdId[i]);
				if (oldAnrFwrdId[i] != null)
					model.setOldAnrFwrdId(oldAnrFwrdId[i]);
				if (fwrdNm[i] != null)
					model.setFwrdNm(fwrdNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFwdrListCondVOs();
	}

	public FwdrListCondVO[] getFwdrListCondVOs(){
		FwdrListCondVO[] vos = (FwdrListCondVO[])models.toArray(new FwdrListCondVO[models.size()]);
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
		this.anrFwrdId = this.anrFwrdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAnrFwrdId = this.oldAnrFwrdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwrdNm = this.fwrdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
