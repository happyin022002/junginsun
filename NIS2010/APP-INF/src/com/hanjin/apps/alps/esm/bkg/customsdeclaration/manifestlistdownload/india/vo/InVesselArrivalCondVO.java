/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InVesselCondVO.java
*@FileTitle : InVesselCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.06 경종윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 경종윤
 * @since J2EE 1.5
 */

public class InVesselArrivalCondVO extends VesselArrivalCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<InVesselArrivalCondVO> models = new ArrayList<InVesselArrivalCondVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String vslMrnNo = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InVesselArrivalCondVO() {}

	public InVesselArrivalCondVO(String ibflag, String vvdCd, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String podCd, String vslNm, String vslMrnNo) {
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.vslMrnNo = vslMrnNo;
		this.vslCd = vslCd;
		this.skdDirCd = skdDirCd;
		this.skdVoyNo = skdVoyNo;
		this.podCd = podCd;
		this.vslNm = vslNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_cd", getVslMrnNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("vsl_mrn_no", getVslMrnNo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_mrn_no", "vslMrnNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getVslMrnNo() {
		return this.vslMrnNo;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getVvdCd() {
		return this.vvdCd;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	public String getPodCd() {
		return this.podCd;
	}
	public String getVslNm() {
		return this.vslNm;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setVslMrnNo(String vslMrnNo) {
		this.vslMrnNo = vslMrnNo;
		//this.vslMrnNo=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
		//this.vslCd=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
		//this.skdDirCd=true;
	}
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
		//this.skdVoyNo=true;
	}
	public void setPodCd(String podCd) {
		this.podCd = podCd;
		//this.podCd=true;
	}
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
		//this.vslNm=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setVslMrnNo(JSPUtil.getParameter(request, "vsl_mrn_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public InVesselArrivalCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public InVesselArrivalCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InVesselArrivalCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslMrnNo = (JSPUtil.getParameter(request, prefix	+ "vsl_mrn_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new InVesselArrivalCondVO();
				if (vslMrnNo[i] != null)
					model.setVslMrnNo(vslMrnNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getInVesselCondVOs();
	}

	public InVesselArrivalCondVO[] getInVesselCondVOs(){
		InVesselArrivalCondVO[] vos = (InVesselArrivalCondVO[])models.toArray(new InVesselArrivalCondVO[models.size()]);
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
		this.vslMrnNo = this.vslMrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
