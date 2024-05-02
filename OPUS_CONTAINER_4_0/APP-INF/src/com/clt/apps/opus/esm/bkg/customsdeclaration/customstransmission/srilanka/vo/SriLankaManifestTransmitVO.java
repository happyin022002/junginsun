/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SriLankaManifestTransmitVO.java
*@FileTitle : SriLankaManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.05  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SriLankaManifestTransmitVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<SriLankaManifestTransmitVO> models = new ArrayList<SriLankaManifestTransmitVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String customsOfficeCode = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String authNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String carrierNo = null;
	/* Column Info */
	private String cgoTp = null;
	/* Column Info */
	private String regNo = null;
	/* Column Info */
	private String vvdNumber = null;
	/* Column Info */
	private String callPort = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SriLankaManifestTransmitVO() {}

	public SriLankaManifestTransmitVO(String ibflag, String pagerows, String etaDt, String authNo, String delCd, String vslNm, String etdDt, String blNo, String actWgt, String bkgNo, String polCd, String carrierNo, String wgtUtCd, String measQty, String cgoTp, String pckQty, String regNo, String pckTpCd, String measUtCd, String customsOfficeCode, String vvdNumber, String callPort, String vslCd, String skdVoyNo, String skdDirCd, String podCd) {
		this.vslCd = vslCd;
		this.etaDt = etaDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.customsOfficeCode = customsOfficeCode;
		this.delCd = delCd;
		this.authNo = authNo;
		this.skdVoyNo = skdVoyNo;
		this.vslNm = vslNm;
		this.etdDt = etdDt;
		this.skdDirCd = skdDirCd;
		this.actWgt = actWgt;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.carrierNo = carrierNo;
		this.cgoTp = cgoTp;
		this.regNo = regNo;
		this.vvdNumber = vvdNumber;
		this.callPort = callPort;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("customs_office_code", getCustomsOfficeCode());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("auth_no", getAuthNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("carrier_no", getCarrierNo());
		this.hashColumns.put("cgo_tp", getCgoTp());
		this.hashColumns.put("reg_no", getRegNo());
		this.hashColumns.put("vvd_number", getVvdNumber());
		this.hashColumns.put("call_port", getCallPort());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("customs_office_code", "customsOfficeCode");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("auth_no", "authNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("carrier_no", "carrierNo");
		this.hashFields.put("cgo_tp", "cgoTp");
		this.hashFields.put("reg_no", "regNo");
		this.hashFields.put("vvd_number", "vvdNumber");
		this.hashFields.put("call_port", "callPort");
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
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return customsOfficeCode
	 */
	public String getCustomsOfficeCode() {
		return this.customsOfficeCode;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return authNo
	 */
	public String getAuthNo() {
		return this.authNo;
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
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
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
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return carrierNo
	 */
	public String getCarrierNo() {
		return this.carrierNo;
	}
	
	/**
	 * Column Info
	 * @return cgoTp
	 */
	public String getCgoTp() {
		return this.cgoTp;
	}
	
	/**
	 * Column Info
	 * @return regNo
	 */
	public String getRegNo() {
		return this.regNo;
	}
	
	/**
	 * Column Info
	 * @return vvdNumber
	 */
	public String getVvdNumber() {
		return this.vvdNumber;
	}
	
	/**
	 * Column Info
	 * @return callPort
	 */
	public String getCallPort() {
		return this.callPort;
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
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param customsOfficeCode
	 */
	public void setCustomsOfficeCode(String customsOfficeCode) {
		this.customsOfficeCode = customsOfficeCode;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param authNo
	 */
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
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
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
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
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param carrierNo
	 */
	public void setCarrierNo(String carrierNo) {
		this.carrierNo = carrierNo;
	}
	
	/**
	 * Column Info
	 * @param cgoTp
	 */
	public void setCgoTp(String cgoTp) {
		this.cgoTp = cgoTp;
	}
	
	/**
	 * Column Info
	 * @param regNo
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	/**
	 * Column Info
	 * @param vvdNumber
	 */
	public void setVvdNumber(String vvdNumber) {
		this.vvdNumber = vvdNumber;
	}
	
	/**
	 * Column Info
	 * @param callPort
	 */
	public void setCallPort(String callPort) {
		this.callPort = callPort;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setCustomsOfficeCode(JSPUtil.getParameter(request, "customs_office_code", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setAuthNo(JSPUtil.getParameter(request, "auth_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCarrierNo(JSPUtil.getParameter(request, "carrier_no", ""));
		setCgoTp(JSPUtil.getParameter(request, "cgo_tp", ""));
		setRegNo(JSPUtil.getParameter(request, "reg_no", ""));
		setVvdNumber(JSPUtil.getParameter(request, "vvd_number", ""));
		setCallPort(JSPUtil.getParameter(request, "call_port", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SriLankaManifestTransmitVO[]
	 */
	public SriLankaManifestTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SriLankaManifestTransmitVO[]
	 */
	public SriLankaManifestTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SriLankaManifestTransmitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] customsOfficeCode = (JSPUtil.getParameter(request, prefix	+ "customs_office_code", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] authNo = (JSPUtil.getParameter(request, prefix	+ "auth_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] carrierNo = (JSPUtil.getParameter(request, prefix	+ "carrier_no", length));
			String[] cgoTp = (JSPUtil.getParameter(request, prefix	+ "cgo_tp", length));
			String[] regNo = (JSPUtil.getParameter(request, prefix	+ "reg_no", length));
			String[] vvdNumber = (JSPUtil.getParameter(request, prefix	+ "vvd_number", length));
			String[] callPort = (JSPUtil.getParameter(request, prefix	+ "call_port", length));
			
			for (int i = 0; i < length; i++) {
				model = new SriLankaManifestTransmitVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (customsOfficeCode[i] != null)
					model.setCustomsOfficeCode(customsOfficeCode[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (authNo[i] != null)
					model.setAuthNo(authNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (carrierNo[i] != null)
					model.setCarrierNo(carrierNo[i]);
				if (cgoTp[i] != null)
					model.setCgoTp(cgoTp[i]);
				if (regNo[i] != null)
					model.setRegNo(regNo[i]);
				if (vvdNumber[i] != null)
					model.setVvdNumber(vvdNumber[i]);
				if (callPort[i] != null)
					model.setCallPort(callPort[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSriLankaManifestTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SriLankaManifestTransmitVO[]
	 */
	public SriLankaManifestTransmitVO[] getSriLankaManifestTransmitVOs(){
		SriLankaManifestTransmitVO[] vos = (SriLankaManifestTransmitVO[])models.toArray(new SriLankaManifestTransmitVO[models.size()]);
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
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customsOfficeCode = this.customsOfficeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authNo = this.authNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrierNo = this.carrierNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTp = this.cgoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regNo = this.regNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNumber = this.vvdNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callPort = this.callPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
