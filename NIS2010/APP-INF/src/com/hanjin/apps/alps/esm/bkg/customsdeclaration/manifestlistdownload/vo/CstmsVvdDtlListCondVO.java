/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CstmsVvdDtlListCondVO.java
*@FileTitle : CstmsVvdDtlListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.05.13 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo;

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
 * @author 김민정
 * @since J2EE 1.5
 * @see ..
 */

public class CstmsVvdDtlListCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstmsVvdDtlListCondVO> models = new ArrayList<CstmsVvdDtlListCondVO>();
	
	/* Column Info */
	private String sVpsEtaDt = null;
	/* Column Info */
	private String eVpsEtaDt = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String cvyRefNo = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstmsVvdDtlListCondVO() {}

	public CstmsVvdDtlListCondVO(String ibflag, String pagerows, String eVpsEtaDt, String sVpsEtaDt, String vvdCd, String cvyRefNo, String slanCd, String vpsPortCd, String crrCd, String polCd) {
		this.sVpsEtaDt = sVpsEtaDt;
		this.eVpsEtaDt = eVpsEtaDt;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.crrCd = crrCd;
		this.cvyRefNo = cvyRefNo;
		this.vpsPortCd = vpsPortCd;
		this.slanCd = slanCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_vps_eta_dt", getSVpsEtaDt());
		this.hashColumns.put("e_vps_eta_dt", getEVpsEtaDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("cvy_ref_no", getCvyRefNo());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_vps_eta_dt", "sVpsEtaDt");
		this.hashFields.put("e_vps_eta_dt", "eVpsEtaDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("cvy_ref_no", "cvyRefNo");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getSVpsEtaDt() {
		return this.sVpsEtaDt;
	}
	public String getEVpsEtaDt() {
		return this.eVpsEtaDt;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getPolCd() {
		return this.polCd;
	}
	public String getVvdCd() {
		return this.vvdCd;
	}
	public String getCrrCd() {
		return this.crrCd;
	}
	public String getCvyRefNo() {
		return this.cvyRefNo;
	}
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	public String getSlanCd() {
		return this.slanCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setSVpsEtaDt(String sVpsEtaDt) {
		this.sVpsEtaDt = sVpsEtaDt;
		//this.sVpsEtaDt=true;
	}
	public void setEVpsEtaDt(String eVpsEtaDt) {
		this.eVpsEtaDt = eVpsEtaDt;
		//this.eVpsEtaDt=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setPolCd(String polCd) {
		this.polCd = polCd;
		//this.polCd=true;
	}
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
		//this.vvdCd=true;
	}
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
		//this.crrCd=true;
	}
	public void setCvyRefNo(String cvyRefNo) {
		this.cvyRefNo = cvyRefNo;
		//this.cvyRefNo=true;
	}
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
		//this.vpsPortCd=true;
	}
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
		//this.slanCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setSVpsEtaDt(JSPUtil.getParameter(request, "s_vps_eta_dt", ""));
		setEVpsEtaDt(JSPUtil.getParameter(request, "e_vps_eta_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setCvyRefNo(JSPUtil.getParameter(request, "cvy_ref_no", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CstmsVvdDtlListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CstmsVvdDtlListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstmsVvdDtlListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sVpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "s_vps_eta_dt".trim(), length));
			String[] eVpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "e_vps_eta_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd".trim(), length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd".trim(), length));
			String[] cvyRefNo = (JSPUtil.getParameter(request, prefix	+ "cvy_ref_no".trim(), length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd".trim(), length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CstmsVvdDtlListCondVO();
				if (sVpsEtaDt[i] != null)
					model.setSVpsEtaDt(sVpsEtaDt[i]);
				if (eVpsEtaDt[i] != null)
					model.setEVpsEtaDt(eVpsEtaDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (cvyRefNo[i] != null)
					model.setCvyRefNo(cvyRefNo[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstmsVvdListCondVOs();
	}

	public CstmsVvdDtlListCondVO[] getCstmsVvdListCondVOs(){
		CstmsVvdDtlListCondVO[] vos = (CstmsVvdDtlListCondVO[])models.toArray(new CstmsVvdDtlListCondVO[models.size()]);
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
		this.sVpsEtaDt = this.sVpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eVpsEtaDt = this.eVpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvyRefNo = this.cvyRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
