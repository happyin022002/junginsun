/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CstmsVvdDtlVO.java
*@FileTitle : CstmsVvdDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 정재엽		
*@LastVersion : 1.0
* 2009.05.11 정재엽
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

public class CstmsVvdDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstmsVvdDtlVO> models = new ArrayList<CstmsVvdDtlVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String crnWrkCmncDt = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String cvyRefNo = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String vpsPortCd = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstmsVvdDtlVO() {}

	public CstmsVvdDtlVO(String ibflag, String pagerows, String slanCd, String vslCd, String skdVoyNo, String skdDirCd, String vvdCd, String crrCd, String polCd, String vpsEtbDt, String crnWrkCmncDt, String vpsPortCd, String vpsEtaDt, String cvyRefNo) {
		this.ibflag = ibflag;
		this.skdDirCd = skdDirCd;
		this.crnWrkCmncDt = crnWrkCmncDt;
		this.vpsEtaDt = vpsEtaDt;
		this.vvdCd = vvdCd;
		this.polCd = polCd;
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.crrCd = crrCd;
		this.cvyRefNo = cvyRefNo;
		this.vpsEtbDt = vpsEtbDt;
		this.pagerows = pagerows;
		this.slanCd = slanCd;
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("crn_wrk_cmnc_dt", getCrnWrkCmncDt());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("cvy_ref_no", getCvyRefNo());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("crn_wrk_cmnc_dt", "crnWrkCmncDt");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("cvy_ref_no", "cvyRefNo");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	public String getCrnWrkCmncDt() {
		return this.crnWrkCmncDt;
	}
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	public String getVvdCd() {
		return this.vvdCd;
	}
	public String getPolCd() {
		return this.polCd;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	public String getCrrCd() {
		return this.crrCd;
	}
	public String getCvyRefNo() {
		return this.cvyRefNo;
	}
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getSlanCd() {
		return this.slanCd;
	}
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
		//this.skdDirCd=true;
	}
	public void setCrnWrkCmncDt(String crnWrkCmncDt) {
		this.crnWrkCmncDt = crnWrkCmncDt;
		//this.crnWrkCmncDt=true;
	}
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
		//this.vpsEtaDt=true;
	}
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
		//this.vvdCd=true;
	}
	public void setPolCd(String polCd) {
		this.polCd = polCd;
		//this.polCd=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
		//this.skdVoyNo=true;
	}
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
		//this.crrCd=true;
	}
	public void setCvyRefNo(String cvyRefNo) {
		this.cvyRefNo = cvyRefNo;
		//this.cvyRefNo=true;
	}
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
		//this.vpsEtbDt=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
		//this.slanCd=true;
	}
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
		//this.vpsPortCd=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setCrnWrkCmncDt(JSPUtil.getParameter(request, "crn_wrk_cmnc_dt", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setCvyRefNo(JSPUtil.getParameter(request, "cvy_ref_no", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, "vps_etb_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
	}

	public CstmsVvdDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CstmsVvdDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstmsVvdDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] crnWrkCmncDt = (JSPUtil.getParameter(request, prefix	+ "crn_wrk_cmnc_dt".trim(), length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt".trim(), length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd".trim(), length));
			String[] cvyRefNo = (JSPUtil.getParameter(request, prefix	+ "cvy_ref_no".trim(), length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd".trim(), length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CstmsVvdDtlVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (crnWrkCmncDt[i] != null)
					model.setCrnWrkCmncDt(crnWrkCmncDt[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (cvyRefNo[i] != null)
					model.setCvyRefNo(cvyRefNo[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstmsVvdVOs();
	}

	public CstmsVvdDtlVO[] getCstmsVvdVOs(){
		CstmsVvdDtlVO[] vos = (CstmsVvdDtlVO[])models.toArray(new CstmsVvdDtlVO[models.size()]);
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
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnWrkCmncDt = this.crnWrkCmncDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvyRefNo = this.cvyRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
