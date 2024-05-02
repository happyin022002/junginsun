/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchAROfficeListVO.java
*@FileTitle : searchAROfficeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.04 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo;

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
 * @author 정휘택
 * @since J2EE 1.5
 */

public class SearchAROfficeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAROfficeListVO> models = new ArrayList<SearchAROfficeListVO>();
	
	/* Column Info */
	private String arCurrCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String arAgnStlCd = null;
	/* Column Info */
	private String arOfcCd2 = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String arCtrlOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String arOfcCd = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAROfficeListVO() {}

	public SearchAROfficeListVO(String ibflag, String pagerows, String arHdQtrOfcCd, String arOfcCd, String arAgnStlCd, String arOfcCd2, String arCurrCd, String arCtrlOfcCd, String locCd, String svrId) {
		this.arCurrCd = arCurrCd;
		this.ibflag = ibflag;
		this.arAgnStlCd = arAgnStlCd;
		this.arOfcCd2 = arOfcCd2;
		this.svrId = svrId;
		this.locCd = locCd;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.arCtrlOfcCd = arCtrlOfcCd;
		this.pagerows = pagerows;
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ar_curr_cd", getArCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ar_agn_stl_cd", getArAgnStlCd());
		this.hashColumns.put("ar_ofc_cd2", getArOfcCd2());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("ar_ctrl_ofc_cd", getArCtrlOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ar_curr_cd", "arCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_agn_stl_cd", "arAgnStlCd");
		this.hashFields.put("ar_ofc_cd2", "arOfcCd2");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("ar_ctrl_ofc_cd", "arCtrlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		return this.hashFields;
	}
	
	public String getArCurrCd() {
		return this.arCurrCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getArAgnStlCd() {
		return this.arAgnStlCd;
	}
	public String getArOfcCd2() {
		return this.arOfcCd2;
	}
	public String getSvrId() {
		return this.svrId;
	}
	public String getLocCd() {
		return this.locCd;
	}
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	public String getArCtrlOfcCd() {
		return this.arCtrlOfcCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getArOfcCd() {
		return this.arOfcCd;
	}

	public void setArCurrCd(String arCurrCd) {
		this.arCurrCd = arCurrCd;
		//this.arCurrCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setArAgnStlCd(String arAgnStlCd) {
		this.arAgnStlCd = arAgnStlCd;
		//this.arAgnStlCd=true;
	}
	public void setArOfcCd2(String arOfcCd2) {
		this.arOfcCd2 = arOfcCd2;
		//this.arOfcCd2=true;
	}
	public void setSvrId(String svrId) {
		this.svrId = svrId;
		//this.svrId=true;
	}
	public void setLocCd(String locCd) {
		this.locCd = locCd;
		//this.locCd=true;
	}
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		//this.arHdQtrOfcCd=true;
	}
	public void setArCtrlOfcCd(String arCtrlOfcCd) {
		this.arCtrlOfcCd = arCtrlOfcCd;
		//this.arCtrlOfcCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
		//this.arOfcCd=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setArCurrCd(JSPUtil.getParameter(request, "ar_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setArAgnStlCd(JSPUtil.getParameter(request, "ar_agn_stl_cd", ""));
		setArOfcCd2(JSPUtil.getParameter(request, "ar_ofc_cd2", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, "ar_hd_qtr_ofc_cd", ""));
		setArCtrlOfcCd(JSPUtil.getParameter(request, "ar_ctrl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
	}

	public SearchAROfficeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchAROfficeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAROfficeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] arCurrCd = (JSPUtil.getParameter(request, prefix	+ "ar_curr_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] arAgnStlCd = (JSPUtil.getParameter(request, prefix	+ "ar_agn_stl_cd".trim(), length));
			String[] arOfcCd2 = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd2".trim(), length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd".trim(), length));
			String[] arCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ctrl_ofc_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAROfficeListVO();
				if (arCurrCd[i] != null)
					model.setArCurrCd(arCurrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arAgnStlCd[i] != null)
					model.setArAgnStlCd(arAgnStlCd[i]);
				if (arOfcCd2[i] != null)
					model.setArOfcCd2(arOfcCd2[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (arCtrlOfcCd[i] != null)
					model.setArCtrlOfcCd(arCtrlOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getsearchAROfficeListVOs();
	}

	public SearchAROfficeListVO[] getsearchAROfficeListVOs(){
		SearchAROfficeListVO[] vos = (SearchAROfficeListVO[])models.toArray(new SearchAROfficeListVO[models.size()]);
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
	 * @exception IllegalAccessException
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
		this.arCurrCd = this.arCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arAgnStlCd = this.arAgnStlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd2 = this.arOfcCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCtrlOfcCd = this.arCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
