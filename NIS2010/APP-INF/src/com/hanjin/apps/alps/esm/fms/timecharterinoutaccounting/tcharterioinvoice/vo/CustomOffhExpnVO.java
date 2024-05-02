/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomOffhExpnVO.java
*@FileTitle : CustomOffhExpnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.13 정윤태 
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
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0073HTMLAction
 */

public class CustomOffhExpnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomOffhExpnVO> models = new ArrayList<CustomOffhExpnVO>();
	
	/* Column Info */
	private String offhDurDys = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String offhSeq = null;
	/* Column Info */
	private String onhDtDay = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String offhDesc = null;
	/* Column Info */
	private String doilPrc = null;
	/* Column Info */
	private String foilPrc = null;
	/* Column Info */
	private String onhDtTime = null;
	/* Column Info */
	private String offhDtTime = null;
	/* Column Info */
	private String offhDtDay = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public CustomOffhExpnVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String vslCd, String offhDtDay, String offhDtTime, String onhDtDay, String onhDtTime, String offhDurDys, String foilPrc, String doilPrc, String offhDesc, String offhSeq, String updUsrId
	 * @return 
	 */
	public CustomOffhExpnVO(String ibflag, String pagerows, String vslCd, String offhDtDay, String offhDtTime, String onhDtDay, String onhDtTime, String offhDurDys, String foilPrc, String doilPrc, String offhDesc, String offhSeq, String updUsrId) {
		this.offhDurDys = offhDurDys;
		this.vslCd = vslCd;
		this.offhSeq = offhSeq;
		this.onhDtDay = onhDtDay;
		this.ibflag = ibflag;
		this.offhDesc = offhDesc;
		this.doilPrc = doilPrc;
		this.foilPrc = foilPrc;
		this.onhDtTime = onhDtTime;
		this.offhDtTime = offhDtTime;
		this.offhDtDay = offhDtDay;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("offh_dur_dys", getOffhDurDys());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("offh_seq", getOffhSeq());
		this.hashColumns.put("onh_dt_day", getOnhDtDay());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("offh_desc", getOffhDesc());
		this.hashColumns.put("doil_prc", getDoilPrc());
		this.hashColumns.put("foil_prc", getFoilPrc());
		this.hashColumns.put("onh_dt_time", getOnhDtTime());
		this.hashColumns.put("offh_dt_time", getOffhDtTime());
		this.hashColumns.put("offh_dt_day", getOffhDtDay());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("offh_dur_dys", "offhDurDys");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("offh_seq", "offhSeq");
		this.hashFields.put("onh_dt_day", "onhDtDay");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("offh_desc", "offhDesc");
		this.hashFields.put("doil_prc", "doilPrc");
		this.hashFields.put("foil_prc", "foilPrc");
		this.hashFields.put("onh_dt_time", "onhDtTime");
		this.hashFields.put("offh_dt_time", "offhDtTime");
		this.hashFields.put("offh_dt_day", "offhDtDay");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getOffhDurDys() {
		return this.offhDurDys;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getOffhSeq() {
		return this.offhSeq;
	}
	public String getOnhDtDay() {
		return this.onhDtDay;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getOffhDesc() {
		return this.offhDesc;
	}
	public String getDoilPrc() {
		return this.doilPrc;
	}
	public String getFoilPrc() {
		return this.foilPrc;
	}
	public String getOnhDtTime() {
		return this.onhDtTime;
	}
	public String getOffhDtTime() {
		return this.offhDtTime;
	}
	public String getOffhDtDay() {
		return this.offhDtDay;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setOffhDurDys(String offhDurDys) {
		this.offhDurDys = offhDurDys;
		//this.offhDurDys=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setOffhSeq(String offhSeq) {
		this.offhSeq = offhSeq;
		//this.offhSeq=true;
	}
	public void setOnhDtDay(String onhDtDay) {
		this.onhDtDay = onhDtDay;
		//this.onhDtDay=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setOffhDesc(String offhDesc) {
		this.offhDesc = offhDesc;
		//this.offhDesc=true;
	}
	public void setDoilPrc(String doilPrc) {
		this.doilPrc = doilPrc;
		//this.doilPrc=true;
	}
	public void setFoilPrc(String foilPrc) {
		this.foilPrc = foilPrc;
		//this.foilPrc=true;
	}
	public void setOnhDtTime(String onhDtTime) {
		this.onhDtTime = onhDtTime;
		//this.onhDtTime=true;
	}
	public void setOffhDtTime(String offhDtTime) {
		this.offhDtTime = offhDtTime;
		//this.offhDtTime=true;
	}
	public void setOffhDtDay(String offhDtDay) {
		this.offhDtDay = offhDtDay;
		//this.offhDtDay=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setOffhDurDys(JSPUtil.getParameter(request, "offh_dur_dys", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setOffhSeq(JSPUtil.getParameter(request, "offh_seq", ""));
		setOnhDtDay(JSPUtil.getParameter(request, "onh_dt_day", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOffhDesc(JSPUtil.getParameter(request, "offh_desc", ""));
		setDoilPrc(JSPUtil.getParameter(request, "doil_prc", ""));
		setFoilPrc(JSPUtil.getParameter(request, "foil_prc", ""));
		setOnhDtTime(JSPUtil.getParameter(request, "onh_dt_time", ""));
		setOffhDtTime(JSPUtil.getParameter(request, "offh_dt_time", ""));
		setOffhDtDay(JSPUtil.getParameter(request, "offh_dt_day", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CustomOffhExpnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CustomOffhExpnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomOffhExpnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] offhDurDys = (JSPUtil.getParameter(request, prefix	+ "offh_dur_dys".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] offhSeq = (JSPUtil.getParameter(request, prefix	+ "offh_seq".trim(), length));
			String[] onhDtDay = (JSPUtil.getParameter(request, prefix	+ "onh_dt_day".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] offhDesc = (JSPUtil.getParameter(request, prefix	+ "offh_desc".trim(), length));
			String[] doilPrc = (JSPUtil.getParameter(request, prefix	+ "doil_prc".trim(), length));
			String[] foilPrc = (JSPUtil.getParameter(request, prefix	+ "foil_prc".trim(), length));
			String[] onhDtTime = (JSPUtil.getParameter(request, prefix	+ "onh_dt_time".trim(), length));
			String[] offhDtTime = (JSPUtil.getParameter(request, prefix	+ "offh_dt_time".trim(), length));
			String[] offhDtDay = (JSPUtil.getParameter(request, prefix	+ "offh_dt_day".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomOffhExpnVO();
				if (offhDurDys[i] != null)
					model.setOffhDurDys(offhDurDys[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (offhSeq[i] != null)
					model.setOffhSeq(offhSeq[i]);
				if (onhDtDay[i] != null)
					model.setOnhDtDay(onhDtDay[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (offhDesc[i] != null)
					model.setOffhDesc(offhDesc[i]);
				if (doilPrc[i] != null)
					model.setDoilPrc(doilPrc[i]);
				if (foilPrc[i] != null)
					model.setFoilPrc(foilPrc[i]);
				if (onhDtTime[i] != null)
					model.setOnhDtTime(onhDtTime[i]);
				if (offhDtTime[i] != null)
					model.setOffhDtTime(offhDtTime[i]);
				if (offhDtDay[i] != null)
					model.setOffhDtDay(offhDtDay[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCustomOffhExpnVOs();
	}

	public CustomOffhExpnVO[] getCustomOffhExpnVOs(){
		CustomOffhExpnVO[] vos = (CustomOffhExpnVO[])models.toArray(new CustomOffhExpnVO[models.size()]);
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
		this.offhDurDys = this.offhDurDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhSeq = this.offhSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDtDay = this.onhDtDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDesc = this.offhDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilPrc = this.doilPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilPrc = this.foilPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDtTime = this.onhDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDtTime = this.offhDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDtDay = this.offhDtDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
