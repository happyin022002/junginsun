/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SriLankaVesselArrivalVO.java
*@FileTitle : SriLankaVesselArrivalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
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
	private String arrivalPort = null;
	/* Column Info */
	private String vslRgstNo = null;
	/* Column Info */
	private String depaturePort = null;
	/* Column Info */
	private String cstmsVvdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String ioBndCd = null;
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
	/* Column Info */
	private String msgRefNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String vslNm2 = null;
	/* Column Info */
	private String vesselRegNo = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String vpsEtdDtTime = null;
	/* Column Info */
	private String capNm = null;
	/* Column Info */
	private String vslAuthNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SriLankaVesselArrivalVO() {}

	public SriLankaVesselArrivalVO(String ibflag, String pagerows, String vslCd, String vpsEtdDt, String arrivalPort, String vslRgstNo, String depaturePort, String cstmsVvdCd, String skdVoyNo, String vslNm, String ioBndCd, String vpsEtaDt, String vpsEtaDtTime, String skdDirCd, String podCd, String msgRefNo, String vslNm2, String vslEngNm, String vslRgstCntCd, String vesselRegNo, String vpsEtdDtTime, String capNm, String vslAuthNo, String portCd) {
		this.vslCd = vslCd;
		this.vpsEtdDt = vpsEtdDt;
		this.arrivalPort = arrivalPort;
		this.vslRgstNo = vslRgstNo;
		this.depaturePort = depaturePort;
		this.cstmsVvdCd = cstmsVvdCd;
		this.skdVoyNo = skdVoyNo;
		this.vslNm = vslNm;
		this.ioBndCd = ioBndCd;
		this.vpsEtaDt = vpsEtaDt;
		this.skdDirCd = skdDirCd;
		this.vpsEtaDtTime = vpsEtaDtTime;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.msgRefNo = msgRefNo;
		this.ibflag = ibflag;
		this.vslRgstCntCd = vslRgstCntCd;
		this.vslEngNm = vslEngNm;
		this.vslNm2 = vslNm2;
		this.vesselRegNo = vesselRegNo;
		this.portCd = portCd;
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
		this.hashColumns.put("arrival_port", getArrivalPort());
		this.hashColumns.put("vsl_rgst_no", getVslRgstNo());
		this.hashColumns.put("depature_port", getDepaturePort());
		this.hashColumns.put("cstms_vvd_cd", getCstmsVvdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vps_eta_dt_time", getVpsEtaDtTime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("msg_ref_no", getMsgRefNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("vsl_nm2", getVslNm2());
		this.hashColumns.put("vessel_reg_no", getVesselRegNo());
		this.hashColumns.put("port_cd", getPortCd());
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
		this.hashFields.put("arrival_port", "arrivalPort");
		this.hashFields.put("vsl_rgst_no", "vslRgstNo");
		this.hashFields.put("depature_port", "depaturePort");
		this.hashFields.put("cstms_vvd_cd", "cstmsVvdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vps_eta_dt_time", "vpsEtaDtTime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("msg_ref_no", "msgRefNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("vsl_nm2", "vslNm2");
		this.hashFields.put("vessel_reg_no", "vesselRegNo");
		this.hashFields.put("port_cd", "portCd");
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
	
	/**
	 * Column Info
	 * @return arrivalPort
	 */
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
	 * @return cstmsVvdCd
	 */
	public String getCstmsVvdCd() {
		return this.cstmsVvdCd;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * Column Info
	 * @return msgRefNo
	 */
	public String getMsgRefNo() {
		return this.msgRefNo;
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
	 * @return vslRgstCntCd
	 */
	public String getVslRgstCntCd() {
		return this.vslRgstCntCd;
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
	 * @return vslNm2
	 */
	public String getVslNm2() {
		return this.vslNm2;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @param arrivalPort
	 */
	public void setArrivalPort(String arrivalPort) {
		this.arrivalPort = arrivalPort;
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
	
	/**
	 * Column Info
	 * @param cstmsVvdCd
	 */
	public void setCstmsVvdCd(String cstmsVvdCd) {
		this.cstmsVvdCd = cstmsVvdCd;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * Column Info
	 * @param msgRefNo
	 */
	public void setMsgRefNo(String msgRefNo) {
		this.msgRefNo = msgRefNo;
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
	 * @param vslRgstCntCd
	 */
	public void setVslRgstCntCd(String vslRgstCntCd) {
		this.vslRgstCntCd = vslRgstCntCd;
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
	 * @param vslNm2
	 */
	public void setVslNm2(String vslNm2) {
		this.vslNm2 = vslNm2;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setArrivalPort(JSPUtil.getParameter(request, prefix + "arrival_port", ""));
		setVslRgstNo(JSPUtil.getParameter(request, prefix + "vsl_rgst_no", ""));
		setDepaturePort(JSPUtil.getParameter(request, prefix + "depature_port", ""));
		setCstmsVvdCd(JSPUtil.getParameter(request, prefix + "cstms_vvd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVpsEtaDtTime(JSPUtil.getParameter(request, prefix + "vps_eta_dt_time", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setMsgRefNo(JSPUtil.getParameter(request, prefix + "msg_ref_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, prefix + "vsl_rgst_cnt_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setVslNm2(JSPUtil.getParameter(request, prefix + "vsl_nm2", ""));
		setVesselRegNo(JSPUtil.getParameter(request, prefix + "vessel_reg_no", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setVpsEtdDtTime(JSPUtil.getParameter(request, prefix + "vps_etd_dt_time", ""));
		setCapNm(JSPUtil.getParameter(request, prefix + "cap_nm", ""));
		setVslAuthNo(JSPUtil.getParameter(request, prefix + "vsl_auth_no", ""));
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
			String[] arrivalPort = (JSPUtil.getParameter(request, prefix	+ "arrival_port", length));
			String[] vslRgstNo = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_no", length));
			String[] depaturePort = (JSPUtil.getParameter(request, prefix	+ "depature_port", length));
			String[] cstmsVvdCd = (JSPUtil.getParameter(request, prefix	+ "cstms_vvd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vpsEtaDtTime = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_time", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] msgRefNo = (JSPUtil.getParameter(request, prefix	+ "msg_ref_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] vslNm2 = (JSPUtil.getParameter(request, prefix	+ "vsl_nm2", length));
			String[] vesselRegNo = (JSPUtil.getParameter(request, prefix	+ "vessel_reg_no", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] vpsEtdDtTime = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt_time", length));
			String[] capNm = (JSPUtil.getParameter(request, prefix	+ "cap_nm", length));
			String[] vslAuthNo = (JSPUtil.getParameter(request, prefix	+ "vsl_auth_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SriLankaVesselArrivalVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (arrivalPort[i] != null)
					model.setArrivalPort(arrivalPort[i]);
				if (vslRgstNo[i] != null)
					model.setVslRgstNo(vslRgstNo[i]);
				if (depaturePort[i] != null)
					model.setDepaturePort(depaturePort[i]);
				if (cstmsVvdCd[i] != null)
					model.setCstmsVvdCd(cstmsVvdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
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
				if (msgRefNo[i] != null)
					model.setMsgRefNo(msgRefNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (vslNm2[i] != null)
					model.setVslNm2(vslNm2[i]);
				if (vesselRegNo[i] != null)
					model.setVesselRegNo(vesselRegNo[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
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
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrivalPort = this.arrivalPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstNo = this.vslRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depaturePort = this.depaturePort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsVvdCd = this.cstmsVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDtTime = this.vpsEtaDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRefNo = this.msgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm2 = this.vslNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselRegNo = this.vesselRegNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDtTime = this.vpsEtdDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capNm = this.capNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslAuthNo = this.vslAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
