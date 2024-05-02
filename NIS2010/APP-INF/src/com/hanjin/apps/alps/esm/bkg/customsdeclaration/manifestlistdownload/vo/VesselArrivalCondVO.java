/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselArrivalCondVO.java
*@FileTitle : VesselArrivalCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.05.07 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김민정
 * @since J2EE 1.5
 */

public class VesselArrivalCondVO extends VesselCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<VesselArrivalCondVO> models = new ArrayList<VesselArrivalCondVO>();
	
	/* Column Info */
	private String frmVvdCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String frmVpsPortCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VesselArrivalCondVO() {}

	public VesselArrivalCondVO(String ibflag, String pagerows, String frmVvdCd, String frmVpsPortCd) {
		this.frmVvdCd = frmVvdCd;
		this.ibflag = ibflag;
		this.frmVpsPortCd = frmVpsPortCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frm_vvd_cd", getFrmVvdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frm_vps_port_cd", getFrmVpsPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frm_vvd_cd", "frmVvdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frm_vps_port_cd", "frmVpsPortCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getFrmVvdCd() {
		return this.frmVvdCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getFrmVpsPortCd() {
		return this.frmVpsPortCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setFrmVvdCd(String frmVvdCd) {
		this.frmVvdCd = frmVvdCd;
		//this.frmVvdCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setFrmVpsPortCd(String frmVpsPortCd) {
		this.frmVpsPortCd = frmVpsPortCd;
		//this.frmVpsPortCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setFrmVvdCd(JSPUtil.getParameter(request, "frm_vvd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFrmVpsPortCd(JSPUtil.getParameter(request, "frm_vps_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public VesselArrivalCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public VesselArrivalCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VesselArrivalCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frmVvdCd = (JSPUtil.getParameter(request, prefix	+ "frm_vvd_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] frmVpsPortCd = (JSPUtil.getParameter(request, prefix	+ "frm_vps_port_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new VesselArrivalCondVO();
				if (frmVvdCd[i] != null)
					model.setFrmVvdCd(frmVvdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frmVpsPortCd[i] != null)
					model.setFrmVpsPortCd(frmVpsPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getVesselArrivalCondVOs();
	}

	public VesselArrivalCondVO[] getVesselArrivalCondVOs(){
		VesselArrivalCondVO[] vos = (VesselArrivalCondVO[])models.toArray(new VesselArrivalCondVO[models.size()]);
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
		this.frmVvdCd = this.frmVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmVpsPortCd = this.frmVpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
