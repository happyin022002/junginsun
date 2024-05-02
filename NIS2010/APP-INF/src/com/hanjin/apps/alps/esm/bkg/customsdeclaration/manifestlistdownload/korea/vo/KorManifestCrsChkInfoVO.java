/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KorManifestCrsChkInfoVO.java
*@FileTitle : KorManifestCrsChkInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.27
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.09.27 조원주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 조원주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorManifestCrsChkInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorManifestCrsChkInfoVO> models = new ArrayList<KorManifestCrsChkInfoVO>();
	
	/* Column Info */
	private String inVvd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String tp = null;
	/* Column Info */
	private String rmkBkgNo = null;
	/* Column Info */
	private String dnMeasQty = null;
	/* Column Info */
	private String xptLicNo = null;
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
	private String roChk = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String dnWgtUtCd = null;
	/* Column Info */
	private String aBkgNo = null;
	/* Column Info */
	private String dnPckQty = null;
	/* Column Info */
	private String errchk = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String dnXptLicNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String blMeasUtCd = null;
	/* Column Info */
	private String cstmsRmk1 = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String hidden3 = null;
	/* Column Info */
	private String dnPckTpCd = null;
	/* Column Info */
	private String downYn = null;
	/* Column Info */
	private String cntrTtlWgt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String sc = null;
	/* Column Info */
	private String fe = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorManifestCrsChkInfoVO() {}

	public KorManifestCrsChkInfoVO(String ibflag, String pagerows, String errchk, String hidden3, String cntrCnt, String aBkgNo, String blNo, String bkgNo, String downYn, String roChk, String polCd, String podCd, String pckQty, String pckTpCd, String actWgt, String wgtUtCd, String measQty, String measUtCd, String xptLicNo, String dnPckQty, String dnPckTpCd, String cntrTtlWgt, String dnWgtUtCd, String dnMeasQty, String blMeasUtCd, String dnXptLicNo, String cstmsRmk1, String tp, String inVvd, String rmkBkgNo, String vslCd, String skdVoyNo, String skdDirCd, String portCd, String sc, String fe) {
		this.inVvd = inVvd;
		this.vslCd = vslCd;
		this.tp = tp;
		this.rmkBkgNo = rmkBkgNo;
		this.dnMeasQty = dnMeasQty;
		this.xptLicNo = xptLicNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.roChk = roChk;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.dnWgtUtCd = dnWgtUtCd;
		this.aBkgNo = aBkgNo;
		this.dnPckQty = dnPckQty;
		this.errchk = errchk;
		this.skdVoyNo = skdVoyNo;
		this.cntrCnt = cntrCnt;
		this.dnXptLicNo = dnXptLicNo;
		this.skdDirCd = skdDirCd;
		this.actWgt = actWgt;
		this.podCd = podCd;
		this.blMeasUtCd = blMeasUtCd;
		this.cstmsRmk1 = cstmsRmk1;
		this.bkgNo = bkgNo;
		this.hidden3 = hidden3;
		this.dnPckTpCd = dnPckTpCd;
		this.downYn = downYn;
		this.cntrTtlWgt = cntrTtlWgt;
		this.portCd = portCd;
		this.sc = sc;
		this.fe = fe;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_vvd", getInVvd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("tp", getTp());
		this.hashColumns.put("rmk_bkg_no", getRmkBkgNo());
		this.hashColumns.put("dn_meas_qty", getDnMeasQty());
		this.hashColumns.put("xpt_lic_no", getXptLicNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("ro_chk", getRoChk());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("dn_wgt_ut_cd", getDnWgtUtCd());
		this.hashColumns.put("a_bkg_no", getABkgNo());
		this.hashColumns.put("dn_pck_qty", getDnPckQty());
		this.hashColumns.put("errchk", getErrchk());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("dn_xpt_lic_no", getDnXptLicNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bl_meas_ut_cd", getBlMeasUtCd());
		this.hashColumns.put("cstms_rmk1", getCstmsRmk1());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("hidden3", getHidden3());
		this.hashColumns.put("dn_pck_tp_cd", getDnPckTpCd());
		this.hashColumns.put("down_yn", getDownYn());
		this.hashColumns.put("cntr_ttl_wgt", getCntrTtlWgt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("sc", getSc());
		this.hashColumns.put("fe", getFe());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_vvd", "inVvd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("tp", "tp");
		this.hashFields.put("rmk_bkg_no", "rmkBkgNo");
		this.hashFields.put("dn_meas_qty", "dnMeasQty");
		this.hashFields.put("xpt_lic_no", "xptLicNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("ro_chk", "roChk");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("dn_wgt_ut_cd", "dnWgtUtCd");
		this.hashFields.put("a_bkg_no", "aBkgNo");
		this.hashFields.put("dn_pck_qty", "dnPckQty");
		this.hashFields.put("errchk", "errchk");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("dn_xpt_lic_no", "dnXptLicNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bl_meas_ut_cd", "blMeasUtCd");
		this.hashFields.put("cstms_rmk1", "cstmsRmk1");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("hidden3", "hidden3");
		this.hashFields.put("dn_pck_tp_cd", "dnPckTpCd");
		this.hashFields.put("down_yn", "downYn");
		this.hashFields.put("cntr_ttl_wgt", "cntrTtlWgt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("sc", "sc");
		this.hashFields.put("fe", "fe");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inVvd
	 */
	public String getInVvd() {
		return this.inVvd;
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
	 * @return tp
	 */
	public String getTp() {
		return this.tp;
	}
	
	/**
	 * Column Info
	 * @return rmkBkgNo
	 */
	public String getRmkBkgNo() {
		return this.rmkBkgNo;
	}
	
	/**
	 * Column Info
	 * @return dnMeasQty
	 */
	public String getDnMeasQty() {
		return this.dnMeasQty;
	}
	
	/**
	 * Column Info
	 * @return xptLicNo
	 */
	public String getXptLicNo() {
		return this.xptLicNo;
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
	 * @return roChk
	 */
	public String getRoChk() {
		return this.roChk;
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
	 * @return dnWgtUtCd
	 */
	public String getDnWgtUtCd() {
		return this.dnWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return aBkgNo
	 */
	public String getABkgNo() {
		return this.aBkgNo;
	}
	
	/**
	 * Column Info
	 * @return dnPckQty
	 */
	public String getDnPckQty() {
		return this.dnPckQty;
	}
	
	/**
	 * Column Info
	 * @return errchk
	 */
	public String getErrchk() {
		return this.errchk;
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
	 * @return cntrCnt
	 */
	public String getCntrCnt() {
		return this.cntrCnt;
	}
	
	/**
	 * Column Info
	 * @return dnXptLicNo
	 */
	public String getDnXptLicNo() {
		return this.dnXptLicNo;
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
	 * @return blMeasUtCd
	 */
	public String getBlMeasUtCd() {
		return this.blMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsRmk1
	 */
	public String getCstmsRmk1() {
		return this.cstmsRmk1;
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
	 * @return hidden3
	 */
	public String getHidden3() {
		return this.hidden3;
	}
	
	/**
	 * Column Info
	 * @return dnPckTpCd
	 */
	public String getDnPckTpCd() {
		return this.dnPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return downYn
	 */
	public String getDownYn() {
		return this.downYn;
	}
	
	/**
	 * Column Info
	 * @return cntrTtlWgt
	 */
	public String getCntrTtlWgt() {
		return this.cntrTtlWgt;
	}
	

	/**
	 * Column Info
	 * @param inVvd
	 */
	public void setInVvd(String inVvd) {
		this.inVvd = inVvd;
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
	 * @param tp
	 */
	public void setTp(String tp) {
		this.tp = tp;
	}
	
	/**
	 * Column Info
	 * @param rmkBkgNo
	 */
	public void setRmkBkgNo(String rmkBkgNo) {
		this.rmkBkgNo = rmkBkgNo;
	}
	
	/**
	 * Column Info
	 * @param dnMeasQty
	 */
	public void setDnMeasQty(String dnMeasQty) {
		this.dnMeasQty = dnMeasQty;
	}
	
	/**
	 * Column Info
	 * @param xptLicNo
	 */
	public void setXptLicNo(String xptLicNo) {
		this.xptLicNo = xptLicNo;
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
	 * @param roChk
	 */
	public void setRoChk(String roChk) {
		this.roChk = roChk;
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
	 * @param dnWgtUtCd
	 */
	public void setDnWgtUtCd(String dnWgtUtCd) {
		this.dnWgtUtCd = dnWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param aBkgNo
	 */
	public void setABkgNo(String aBkgNo) {
		this.aBkgNo = aBkgNo;
	}
	
	/**
	 * Column Info
	 * @param dnPckQty
	 */
	public void setDnPckQty(String dnPckQty) {
		this.dnPckQty = dnPckQty;
	}
	
	/**
	 * Column Info
	 * @param errchk
	 */
	public void setErrchk(String errchk) {
		this.errchk = errchk;
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
	 * @param cntrCnt
	 */
	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
	}
	
	/**
	 * Column Info
	 * @param dnXptLicNo
	 */
	public void setDnXptLicNo(String dnXptLicNo) {
		this.dnXptLicNo = dnXptLicNo;
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
	 * @param blMeasUtCd
	 */
	public void setBlMeasUtCd(String blMeasUtCd) {
		this.blMeasUtCd = blMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsRmk1
	 */
	public void setCstmsRmk1(String cstmsRmk1) {
		this.cstmsRmk1 = cstmsRmk1;
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
	 * @param hidden3
	 */
	public void setHidden3(String hidden3) {
		this.hidden3 = hidden3;
	}
	
	/**
	 * Column Info
	 * @param dnPckTpCd
	 */
	public void setDnPckTpCd(String dnPckTpCd) {
		this.dnPckTpCd = dnPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param downYn
	 */
	public void setDownYn(String downYn) {
		this.downYn = downYn;
	}
	
	/**
	 * Column Info
	 * @param cntrTtlWgt
	 */
	public void setCntrTtlWgt(String cntrTtlWgt) {
		this.cntrTtlWgt = cntrTtlWgt;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public String getPortCd() {
		return portCd;
	}
	
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getFe() {
		return fe;
	}

	public void setFe(String fe) {
		this.fe = fe;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setInVvd(JSPUtil.getParameter(request, prefix + "in_vvd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setTp(JSPUtil.getParameter(request, prefix + "tp", ""));
		setRmkBkgNo(JSPUtil.getParameter(request, prefix + "rmk_bkg_no", ""));
		setDnMeasQty(JSPUtil.getParameter(request, prefix + "dn_meas_qty", ""));
		setXptLicNo(JSPUtil.getParameter(request, prefix + "xpt_lic_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setRoChk(JSPUtil.getParameter(request, prefix + "ro_chk", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setDnWgtUtCd(JSPUtil.getParameter(request, prefix + "dn_wgt_ut_cd", ""));
		setABkgNo(JSPUtil.getParameter(request, prefix + "a_bkg_no", ""));
		setDnPckQty(JSPUtil.getParameter(request, prefix + "dn_pck_qty", ""));
		setErrchk(JSPUtil.getParameter(request, prefix + "errchk", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setDnXptLicNo(JSPUtil.getParameter(request, prefix + "dn_xpt_lic_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBlMeasUtCd(JSPUtil.getParameter(request, prefix + "bl_meas_ut_cd", ""));
		setCstmsRmk1(JSPUtil.getParameter(request, prefix + "cstms_rmk1", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setHidden3(JSPUtil.getParameter(request, prefix + "hidden3", ""));
		setDnPckTpCd(JSPUtil.getParameter(request, prefix + "dn_pck_tp_cd", ""));
		setDownYn(JSPUtil.getParameter(request, prefix + "down_yn", ""));
		setCntrTtlWgt(JSPUtil.getParameter(request, prefix + "cntr_ttl_wgt", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setSc(JSPUtil.getParameter(request, prefix + "sc", ""));
		setFe(JSPUtil.getParameter(request, prefix + "fe", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorManifestCrsChkInfoVO[]
	 */
	public KorManifestCrsChkInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorManifestCrsChkInfoVO[]
	 */
	public KorManifestCrsChkInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorManifestCrsChkInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inVvd = (JSPUtil.getParameter(request, prefix	+ "in_vvd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] tp = (JSPUtil.getParameter(request, prefix	+ "tp", length));
			String[] rmkBkgNo = (JSPUtil.getParameter(request, prefix	+ "rmk_bkg_no", length));
			String[] dnMeasQty = (JSPUtil.getParameter(request, prefix	+ "dn_meas_qty", length));
			String[] xptLicNo = (JSPUtil.getParameter(request, prefix	+ "xpt_lic_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] roChk = (JSPUtil.getParameter(request, prefix	+ "ro_chk", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] dnWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "dn_wgt_ut_cd", length));
			String[] aBkgNo = (JSPUtil.getParameter(request, prefix	+ "a_bkg_no", length));
			String[] dnPckQty = (JSPUtil.getParameter(request, prefix	+ "dn_pck_qty", length));
			String[] errchk = (JSPUtil.getParameter(request, prefix	+ "errchk", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] dnXptLicNo = (JSPUtil.getParameter(request, prefix	+ "dn_xpt_lic_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] blMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "bl_meas_ut_cd", length));
			String[] cstmsRmk1 = (JSPUtil.getParameter(request, prefix	+ "cstms_rmk1", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] hidden3 = (JSPUtil.getParameter(request, prefix	+ "hidden3", length));
			String[] dnPckTpCd = (JSPUtil.getParameter(request, prefix	+ "dn_pck_tp_cd", length));
			String[] downYn = (JSPUtil.getParameter(request, prefix	+ "down_yn", length));
			String[] cntrTtlWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_wgt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] sc = (JSPUtil.getParameter(request, prefix	+ "sc", length));
			String[] fe = (JSPUtil.getParameter(request, prefix	+ "fe", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorManifestCrsChkInfoVO();
				if (inVvd[i] != null)
					model.setInVvd(inVvd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (tp[i] != null)
					model.setTp(tp[i]);
				if (rmkBkgNo[i] != null)
					model.setRmkBkgNo(rmkBkgNo[i]);
				if (dnMeasQty[i] != null)
					model.setDnMeasQty(dnMeasQty[i]);
				if (xptLicNo[i] != null)
					model.setXptLicNo(xptLicNo[i]);
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
				if (roChk[i] != null)
					model.setRoChk(roChk[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (dnWgtUtCd[i] != null)
					model.setDnWgtUtCd(dnWgtUtCd[i]);
				if (aBkgNo[i] != null)
					model.setABkgNo(aBkgNo[i]);
				if (dnPckQty[i] != null)
					model.setDnPckQty(dnPckQty[i]);
				if (errchk[i] != null)
					model.setErrchk(errchk[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (dnXptLicNo[i] != null)
					model.setDnXptLicNo(dnXptLicNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (blMeasUtCd[i] != null)
					model.setBlMeasUtCd(blMeasUtCd[i]);
				if (cstmsRmk1[i] != null)
					model.setCstmsRmk1(cstmsRmk1[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (hidden3[i] != null)
					model.setHidden3(hidden3[i]);
				if (dnPckTpCd[i] != null)
					model.setDnPckTpCd(dnPckTpCd[i]);
				if (downYn[i] != null)
					model.setDownYn(downYn[i]);
				if (cntrTtlWgt[i] != null)
					model.setCntrTtlWgt(cntrTtlWgt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (sc[i] != null)
					model.setSc(sc[i]);
				if (fe[i] != null)
					model.setFe(fe[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorManifestCrsChkInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorManifestCrsChkInfoVO[]
	 */
	public KorManifestCrsChkInfoVO[] getKorManifestCrsChkInfoVOs(){
		KorManifestCrsChkInfoVO[] vos = (KorManifestCrsChkInfoVO[])models.toArray(new KorManifestCrsChkInfoVO[models.size()]);
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
		this.inVvd = this.inVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tp = this.tp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmkBkgNo = this.rmkBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dnMeasQty = this.dnMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptLicNo = this.xptLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roChk = this.roChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dnWgtUtCd = this.dnWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aBkgNo = this.aBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dnPckQty = this.dnPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errchk = this.errchk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dnXptLicNo = this.dnXptLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMeasUtCd = this.blMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRmk1 = this.cstmsRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidden3 = this.hidden3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dnPckTpCd = this.dnPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.downYn = this.downYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlWgt = this.cntrTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sc = this.sc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fe = this.fe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
