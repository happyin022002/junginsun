/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SriLankaVesselArrivalVO.java
*@FileTitle : SriLankaVesselArrivalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.12 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SriLankaVesselArrivalVO extends VesselArrivalVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<SriLankaVesselArrivalVO> models = new ArrayList<SriLankaVesselArrivalVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String vslRgstNo = null;
	/* Column Info */
	private String depaturePort = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vpsEtaDtTime = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	private String arrivalPort = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslNm2 = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String vesselRegNo = null;
	/* Column Info */
	private String vpsEtdDtTime = null;
	/* Column Info */
	private String capNm = null;
	/* Column Info */
	private String vslAuthNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SriLankaVesselArrivalVO() {}

	public SriLankaVesselArrivalVO(String ibflag, String pagerows, String vslRgstNo, String vpsEtaDt,
			String vpsEtaDtTime, String vpsEtdDt, String vpsEtdDtTime, String vslEngNm, String vslRgstCntCd,
			String capNm, String depaturePort, String podCd, String vslNm, String vslNm2, String vslAuthNo,
			String vesselRegNo, String vslCd, String skdVoyNo, String skdDirCd, String arrivalPort) {
		this.vslCd = vslCd;
		this.vpsEtdDt = vpsEtdDt;
		this.vslRgstNo = vslRgstNo;
		this.depaturePort = depaturePort;
		this.skdVoyNo = skdVoyNo;
		this.vslNm = vslNm;
		this.arrivalPort = arrivalPort;
		this.vpsEtaDt = vpsEtaDt;
		this.skdDirCd = skdDirCd;
		this.vpsEtaDtTime = vpsEtaDtTime;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.vslNm2 = vslNm2;
		this.vslEngNm = vslEngNm;
		this.vslRgstCntCd = vslRgstCntCd;
		this.vesselRegNo = vesselRegNo;
		this.vpsEtdDtTime = vpsEtdDtTime;
		this.capNm = capNm;
		this.vslAuthNo = vslAuthNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("vsl_rgst_no", getVslRgstNo());
		this.hashColumns.put("depature_port", getDepaturePort());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("arrival_port", getArrivalPort());
		this.hashColumns.put("vps_eta_dt_time", getVpsEtaDtTime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_nm2", getVslNm2());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
		this.hashColumns.put("vessel_reg_no", getVesselRegNo());
		this.hashColumns.put("vps_etd_dt_time", getVpsEtdDtTime());
		this.hashColumns.put("cap_nm", getCapNm());
		this.hashColumns.put("vsl_auth_no", getVslAuthNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("vsl_rgst_no", "vslRgstNo");
		this.hashFields.put("depature_port", "depaturePort");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("arrival_port", "arrivalPort");
		this.hashFields.put("vps_eta_dt_time", "vpsEtaDtTime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_nm2", "vslNm2");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
		this.hashFields.put("vessel_reg_no", "vesselRegNo");
		this.hashFields.put("vps_etd_dt_time", "vpsEtdDtTime");
		this.hashFields.put("cap_nm", "capNm");
		this.hashFields.put("vsl_auth_no", "vslAuthNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	public String getArrivalPort() {
		return this.arrivalPort;
	}
	
	/**
	 * Column Info
	 * @return vslRgstNo
	 */
	public String getVslRgstNo() {
		return this.vslRgstNo;
	}
	
	/**
	 * Column Info
	 * @return depaturePort
	 */
	public String getDepaturePort() {
		return this.depaturePort;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDtTime
	 */
	public String getVpsEtaDtTime() {
		return this.vpsEtaDtTime;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return vslNm2
	 */
	public String getVslNm2() {
		return this.vslNm2;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return vslRgstCntCd
	 */
	public String getVslRgstCntCd() {
		return this.vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @return vesselRegNo
	 */
	public String getVesselRegNo() {
		return this.vesselRegNo;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDtTime
	 */
	public String getVpsEtdDtTime() {
		return this.vpsEtdDtTime;
	}
	
	/**
	 * Column Info
	 * @return capNm
	 */
	public String getCapNm() {
		return this.capNm;
	}
	
	/**
	 * Column Info
	 * @return vslAuthNo
	 */
	public String getVslAuthNo() {
		return this.vslAuthNo;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param vslRgstNo
	 */
	public void setVslRgstNo(String vslRgstNo) {
		this.vslRgstNo = vslRgstNo;
	}
	
	/**
	 * Column Info
	 * @param depaturePort
	 */
	public void setDepaturePort(String depaturePort) {
		this.depaturePort = depaturePort;
	}
	
	public void setArrivalPort(String arrivalPort) {
		this.arrivalPort = arrivalPort;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDtTime
	 */
	public void setVpsEtaDtTime(String vpsEtaDtTime) {
		this.vpsEtaDtTime = vpsEtaDtTime;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param vslNm2
	 */
	public void setVslNm2(String vslNm2) {
		this.vslNm2 = vslNm2;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param vslRgstCntCd
	 */
	public void setVslRgstCntCd(String vslRgstCntCd) {
		this.vslRgstCntCd = vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @param vesselRegNo
	 */
	public void setVesselRegNo(String vesselRegNo) {
		this.vesselRegNo = vesselRegNo;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDtTime
	 */
	public void setVpsEtdDtTime(String vpsEtdDtTime) {
		this.vpsEtdDtTime = vpsEtdDtTime;
	}
	
	/**
	 * Column Info
	 * @param capNm
	 */
	public void setCapNm(String capNm) {
		this.capNm = capNm;
	}
	
	/**
	 * Column Info
	 * @param vslAuthNo
	 */
	public void setVslAuthNo(String vslAuthNo) {
		this.vslAuthNo = vslAuthNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setVslRgstNo(JSPUtil.getParameter(request, "vsl_rgst_no", ""));
		setDepaturePort(JSPUtil.getParameter(request, "depature_port", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setArrivalPort(JSPUtil.getParameter(request, "arrival_port", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setVpsEtaDtTime(JSPUtil.getParameter(request, "vps_eta_dt_time", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslNm2(JSPUtil.getParameter(request, "vsl_nm2", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, "vsl_rgst_cnt_cd", ""));
		setVesselRegNo(JSPUtil.getParameter(request, "vessel_reg_no", ""));
		setVpsEtdDtTime(JSPUtil.getParameter(request, "vps_etd_dt_time", ""));
		setCapNm(JSPUtil.getParameter(request, "cap_nm", ""));
		setVslAuthNo(JSPUtil.getParameter(request, "vsl_auth_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SriLankaVesselArrivalVO[]
	 */
	public SriLankaVesselArrivalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SriLankaVesselArrivalVO[]
	 */
	public SriLankaVesselArrivalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SriLankaVesselArrivalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] vslRgstNo = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_no", length));
			String[] arrivalPort = (JSPUtil.getParameter(request, prefix	+ "arrival_port", length));
			String[] depaturePort = (JSPUtil.getParameter(request, prefix	+ "depature_port", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vpsEtaDtTime = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_time", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslNm2 = (JSPUtil.getParameter(request, prefix	+ "vsl_nm2", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd", length));
			String[] vesselRegNo = (JSPUtil.getParameter(request, prefix	+ "vessel_reg_no", length));
			String[] vpsEtdDtTime = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt_time", length));
			String[] capNm = (JSPUtil.getParameter(request, prefix	+ "cap_nm", length));
			String[] vslAuthNo = (JSPUtil.getParameter(request, prefix	+ "vsl_auth_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SriLankaVesselArrivalVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (arrivalPort[i] != null)
					model.setArrivalPort(arrivalPort[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (vslRgstNo[i] != null)
					model.setVslRgstNo(vslRgstNo[i]);
				if (depaturePort[i] != null)
					model.setDepaturePort(depaturePort[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vpsEtaDtTime[i] != null)
					model.setVpsEtaDtTime(vpsEtaDtTime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslNm2[i] != null)
					model.setVslNm2(vslNm2[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (vesselRegNo[i] != null)
					model.setVesselRegNo(vesselRegNo[i]);
				if (vpsEtdDtTime[i] != null)
					model.setVpsEtdDtTime(vpsEtdDtTime[i]);
				if (capNm[i] != null)
					model.setCapNm(capNm[i]);
				if (vslAuthNo[i] != null)
					model.setVslAuthNo(vslAuthNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSriLankaVesselArrivalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SriLankaVesselArrivalVO[]
	 */
	public SriLankaVesselArrivalVO[] getSriLankaVesselArrivalVOs(){
		SriLankaVesselArrivalVO[] vos = (SriLankaVesselArrivalVO[])models.toArray(new SriLankaVesselArrivalVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
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
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrivalPort = this.arrivalPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstNo = this.vslRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depaturePort = this.depaturePort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDtTime = this.vpsEtaDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm2 = this.vslNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselRegNo = this.vesselRegNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDtTime = this.vpsEtdDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capNm = this.capNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslAuthNo = this.vslAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
