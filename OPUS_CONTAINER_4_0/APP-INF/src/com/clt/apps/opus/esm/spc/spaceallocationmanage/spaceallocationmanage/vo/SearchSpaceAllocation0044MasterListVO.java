/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchSpaceAllocation0044MasterListVO.java
*@FileTitle : SearchSpaceAllocation0044MasterListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class SearchSpaceAllocation0044MasterListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceAllocation0044MasterListVO> models = new ArrayList<SearchSpaceAllocation0044MasterListVO>();
	
	/* Column Info */
	private String ctrlPortFlg = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String adVol = null;
	/* Column Info */
	private String fcTsVol = null;
	/* Column Info */
	private String ctrl40ftHcFlg = null;
	/* Column Info */
	private String apTsWgt = null;
	/* Column Info */
	private String qtaVol = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String tsWgt = null;
	/* Column Info */
	private String fcWgt = null;
	/* Column Info */
	private String ctrlWgtFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String tsVol = null;
	/* Column Info */
	private String apVol = null;
	/* Column Info */
	private String ctrlRfFlg = null;
	/* Column Info */
	private String costMon = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String adWgt = null;
	/* Column Info */
	private String bkgTsVol = null;
	/* Column Info */
	private String bkgTsWgt = null;
	/* Column Info */
	private String apWgt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ctrlSpcFlg = null;
	/* Column Info */
	private String ctrl45ftHcFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String fcTsWgt = null;
	/* Column Info */
	private String bkgWgt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ctrl53ftFlg = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String fcVol = null;
	/* Column Info */
	private String qtaCmb = null;
	/* Column Info */
	private String apTsVol = null;
	/* Column Info */
	private String bkgVol = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchSpaceAllocation0044MasterListVO() {}

	public SearchSpaceAllocation0044MasterListVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String costWk, String costMon, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String adVol, String adWgt, String tsVol, String tsWgt, String qtaVol, String qtaCmb, String fcVol, String fcWgt, String fcTsVol, String fcTsWgt, String apVol, String apWgt, String apTsVol, String apTsWgt, String bkgVol, String bkgWgt, String bkgTsVol, String bkgTsWgt, String ctrlPortFlg, String ctrl40ftHcFlg, String ctrl45ftHcFlg, String ctrl53ftFlg, String ctrlRfFlg, String ctrlWgtFlg, String ctrlSpcFlg) {
		this.ctrlPortFlg = ctrlPortFlg;
		this.vslCd = vslCd;
		this.adVol = adVol;
		this.fcTsVol = fcTsVol;
		this.ctrl40ftHcFlg = ctrl40ftHcFlg;
		this.apTsWgt = apTsWgt;
		this.qtaVol = qtaVol;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.tsWgt = tsWgt;
		this.fcWgt = fcWgt;
		this.ctrlWgtFlg = ctrlWgtFlg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.tsVol = tsVol;
		this.apVol = apVol;
		this.ctrlRfFlg = ctrlRfFlg;
		this.costMon = costMon;
		this.dirCd = dirCd;
		this.adWgt = adWgt;
		this.bkgTsVol = bkgTsVol;
		this.bkgTsWgt = bkgTsWgt;
		this.apWgt = apWgt;
		this.skdVoyNo = skdVoyNo;
		this.ctrlSpcFlg = ctrlSpcFlg;
		this.ctrl45ftHcFlg = ctrl45ftHcFlg;
		this.skdDirCd = skdDirCd;
		this.fcTsWgt = fcTsWgt;
		this.bkgWgt = bkgWgt;
		this.vvd = vvd;
		this.ctrl53ftFlg = ctrl53ftFlg;
		this.costWk = costWk;
		this.fcVol = fcVol;
		this.qtaCmb = qtaCmb;
		this.apTsVol = apTsVol;
		this.bkgVol = bkgVol;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrl_port_flg", getCtrlPortFlg());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ad_vol", getAdVol());
		this.hashColumns.put("fc_ts_vol", getFcTsVol());
		this.hashColumns.put("ctrl_40ft_hc_flg", getCtrl40ftHcFlg());
		this.hashColumns.put("ap_ts_wgt", getApTsWgt());
		this.hashColumns.put("qta_vol", getQtaVol());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ts_wgt", getTsWgt());
		this.hashColumns.put("fc_wgt", getFcWgt());
		this.hashColumns.put("ctrl_wgt_flg", getCtrlWgtFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ts_vol", getTsVol());
		this.hashColumns.put("ap_vol", getApVol());
		this.hashColumns.put("ctrl_rf_flg", getCtrlRfFlg());
		this.hashColumns.put("cost_mon", getCostMon());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("ad_wgt", getAdWgt());
		this.hashColumns.put("bkg_ts_vol", getBkgTsVol());
		this.hashColumns.put("bkg_ts_wgt", getBkgTsWgt());
		this.hashColumns.put("ap_wgt", getApWgt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ctrl_spc_flg", getCtrlSpcFlg());
		this.hashColumns.put("ctrl_45ft_hc_flg", getCtrl45ftHcFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("fc_ts_wgt", getFcTsWgt());
		this.hashColumns.put("bkg_wgt", getBkgWgt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ctrl_53ft_flg", getCtrl53ftFlg());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("fc_vol", getFcVol());
		this.hashColumns.put("qta_cmb", getQtaCmb());
		this.hashColumns.put("ap_ts_vol", getApTsVol());
		this.hashColumns.put("bkg_vol", getBkgVol());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrl_port_flg", "ctrlPortFlg");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ad_vol", "adVol");
		this.hashFields.put("fc_ts_vol", "fcTsVol");
		this.hashFields.put("ctrl_40ft_hc_flg", "ctrl40ftHcFlg");
		this.hashFields.put("ap_ts_wgt", "apTsWgt");
		this.hashFields.put("qta_vol", "qtaVol");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ts_wgt", "tsWgt");
		this.hashFields.put("fc_wgt", "fcWgt");
		this.hashFields.put("ctrl_wgt_flg", "ctrlWgtFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ts_vol", "tsVol");
		this.hashFields.put("ap_vol", "apVol");
		this.hashFields.put("ctrl_rf_flg", "ctrlRfFlg");
		this.hashFields.put("cost_mon", "costMon");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("ad_wgt", "adWgt");
		this.hashFields.put("bkg_ts_vol", "bkgTsVol");
		this.hashFields.put("bkg_ts_wgt", "bkgTsWgt");
		this.hashFields.put("ap_wgt", "apWgt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ctrl_spc_flg", "ctrlSpcFlg");
		this.hashFields.put("ctrl_45ft_hc_flg", "ctrl45ftHcFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("fc_ts_wgt", "fcTsWgt");
		this.hashFields.put("bkg_wgt", "bkgWgt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ctrl_53ft_flg", "ctrl53ftFlg");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("fc_vol", "fcVol");
		this.hashFields.put("qta_cmb", "qtaCmb");
		this.hashFields.put("ap_ts_vol", "apTsVol");
		this.hashFields.put("bkg_vol", "bkgVol");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ctrlPortFlg
	 */
	public String getCtrlPortFlg() {
		return this.ctrlPortFlg;
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
	 * @return adVol
	 */
	public String getAdVol() {
		return this.adVol;
	}
	
	/**
	 * Column Info
	 * @return fcTsVol
	 */
	public String getFcTsVol() {
		return this.fcTsVol;
	}
	
	/**
	 * Column Info
	 * @return ctrl40ftHcFlg
	 */
	public String getCtrl40ftHcFlg() {
		return this.ctrl40ftHcFlg;
	}
	
	/**
	 * Column Info
	 * @return apTsWgt
	 */
	public String getApTsWgt() {
		return this.apTsWgt;
	}
	
	/**
	 * Column Info
	 * @return qtaVol
	 */
	public String getQtaVol() {
		return this.qtaVol;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return tsWgt
	 */
	public String getTsWgt() {
		return this.tsWgt;
	}
	
	/**
	 * Column Info
	 * @return fcWgt
	 */
	public String getFcWgt() {
		return this.fcWgt;
	}
	
	/**
	 * Column Info
	 * @return ctrlWgtFlg
	 */
	public String getCtrlWgtFlg() {
		return this.ctrlWgtFlg;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return tsVol
	 */
	public String getTsVol() {
		return this.tsVol;
	}
	
	/**
	 * Column Info
	 * @return apVol
	 */
	public String getApVol() {
		return this.apVol;
	}
	
	/**
	 * Column Info
	 * @return ctrlRfFlg
	 */
	public String getCtrlRfFlg() {
		return this.ctrlRfFlg;
	}
	
	/**
	 * Column Info
	 * @return costMon
	 */
	public String getCostMon() {
		return this.costMon;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return adWgt
	 */
	public String getAdWgt() {
		return this.adWgt;
	}
	
	/**
	 * Column Info
	 * @return bkgTsVol
	 */
	public String getBkgTsVol() {
		return this.bkgTsVol;
	}
	
	/**
	 * Column Info
	 * @return bkgTsWgt
	 */
	public String getBkgTsWgt() {
		return this.bkgTsWgt;
	}
	
	/**
	 * Column Info
	 * @return apWgt
	 */
	public String getApWgt() {
		return this.apWgt;
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
	 * @return ctrlSpcFlg
	 */
	public String getCtrlSpcFlg() {
		return this.ctrlSpcFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrl45ftHcFlg
	 */
	public String getCtrl45ftHcFlg() {
		return this.ctrl45ftHcFlg;
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
	 * @return fcTsWgt
	 */
	public String getFcTsWgt() {
		return this.fcTsWgt;
	}
	
	/**
	 * Column Info
	 * @return bkgWgt
	 */
	public String getBkgWgt() {
		return this.bkgWgt;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return ctrl53ftFlg
	 */
	public String getCtrl53ftFlg() {
		return this.ctrl53ftFlg;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return fcVol
	 */
	public String getFcVol() {
		return this.fcVol;
	}
	
	/**
	 * Column Info
	 * @return qtaCmb
	 */
	public String getQtaCmb() {
		return this.qtaCmb;
	}
	
	/**
	 * Column Info
	 * @return apTsVol
	 */
	public String getApTsVol() {
		return this.apTsVol;
	}
	
	/**
	 * Column Info
	 * @return bkgVol
	 */
	public String getBkgVol() {
		return this.bkgVol;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param ctrlPortFlg
	 */
	public void setCtrlPortFlg(String ctrlPortFlg) {
		this.ctrlPortFlg = ctrlPortFlg;
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
	 * @param adVol
	 */
	public void setAdVol(String adVol) {
		this.adVol = adVol;
	}
	
	/**
	 * Column Info
	 * @param fcTsVol
	 */
	public void setFcTsVol(String fcTsVol) {
		this.fcTsVol = fcTsVol;
	}
	
	/**
	 * Column Info
	 * @param ctrl40ftHcFlg
	 */
	public void setCtrl40ftHcFlg(String ctrl40ftHcFlg) {
		this.ctrl40ftHcFlg = ctrl40ftHcFlg;
	}
	
	/**
	 * Column Info
	 * @param apTsWgt
	 */
	public void setApTsWgt(String apTsWgt) {
		this.apTsWgt = apTsWgt;
	}
	
	/**
	 * Column Info
	 * @param qtaVol
	 */
	public void setQtaVol(String qtaVol) {
		this.qtaVol = qtaVol;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param tsWgt
	 */
	public void setTsWgt(String tsWgt) {
		this.tsWgt = tsWgt;
	}
	
	/**
	 * Column Info
	 * @param fcWgt
	 */
	public void setFcWgt(String fcWgt) {
		this.fcWgt = fcWgt;
	}
	
	/**
	 * Column Info
	 * @param ctrlWgtFlg
	 */
	public void setCtrlWgtFlg(String ctrlWgtFlg) {
		this.ctrlWgtFlg = ctrlWgtFlg;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param tsVol
	 */
	public void setTsVol(String tsVol) {
		this.tsVol = tsVol;
	}
	
	/**
	 * Column Info
	 * @param apVol
	 */
	public void setApVol(String apVol) {
		this.apVol = apVol;
	}
	
	/**
	 * Column Info
	 * @param ctrlRfFlg
	 */
	public void setCtrlRfFlg(String ctrlRfFlg) {
		this.ctrlRfFlg = ctrlRfFlg;
	}
	
	/**
	 * Column Info
	 * @param costMon
	 */
	public void setCostMon(String costMon) {
		this.costMon = costMon;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param adWgt
	 */
	public void setAdWgt(String adWgt) {
		this.adWgt = adWgt;
	}
	
	/**
	 * Column Info
	 * @param bkgTsVol
	 */
	public void setBkgTsVol(String bkgTsVol) {
		this.bkgTsVol = bkgTsVol;
	}
	
	/**
	 * Column Info
	 * @param bkgTsWgt
	 */
	public void setBkgTsWgt(String bkgTsWgt) {
		this.bkgTsWgt = bkgTsWgt;
	}
	
	/**
	 * Column Info
	 * @param apWgt
	 */
	public void setApWgt(String apWgt) {
		this.apWgt = apWgt;
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
	 * @param ctrlSpcFlg
	 */
	public void setCtrlSpcFlg(String ctrlSpcFlg) {
		this.ctrlSpcFlg = ctrlSpcFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrl45ftHcFlg
	 */
	public void setCtrl45ftHcFlg(String ctrl45ftHcFlg) {
		this.ctrl45ftHcFlg = ctrl45ftHcFlg;
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
	 * @param fcTsWgt
	 */
	public void setFcTsWgt(String fcTsWgt) {
		this.fcTsWgt = fcTsWgt;
	}
	
	/**
	 * Column Info
	 * @param bkgWgt
	 */
	public void setBkgWgt(String bkgWgt) {
		this.bkgWgt = bkgWgt;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param ctrl53ftFlg
	 */
	public void setCtrl53ftFlg(String ctrl53ftFlg) {
		this.ctrl53ftFlg = ctrl53ftFlg;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param fcVol
	 */
	public void setFcVol(String fcVol) {
		this.fcVol = fcVol;
	}
	
	/**
	 * Column Info
	 * @param qtaCmb
	 */
	public void setQtaCmb(String qtaCmb) {
		this.qtaCmb = qtaCmb;
	}
	
	/**
	 * Column Info
	 * @param apTsVol
	 */
	public void setApTsVol(String apTsVol) {
		this.apTsVol = apTsVol;
	}
	
	/**
	 * Column Info
	 * @param bkgVol
	 */
	public void setBkgVol(String bkgVol) {
		this.bkgVol = bkgVol;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setCtrlPortFlg(JSPUtil.getParameter(request, prefix + "ctrl_port_flg", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setAdVol(JSPUtil.getParameter(request, prefix + "ad_vol", ""));
		setFcTsVol(JSPUtil.getParameter(request, prefix + "fc_ts_vol", ""));
		setCtrl40ftHcFlg(JSPUtil.getParameter(request, prefix + "ctrl_40ft_hc_flg", ""));
		setApTsWgt(JSPUtil.getParameter(request, prefix + "ap_ts_wgt", ""));
		setQtaVol(JSPUtil.getParameter(request, prefix + "qta_vol", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setTsWgt(JSPUtil.getParameter(request, prefix + "ts_wgt", ""));
		setFcWgt(JSPUtil.getParameter(request, prefix + "fc_wgt", ""));
		setCtrlWgtFlg(JSPUtil.getParameter(request, prefix + "ctrl_wgt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTsVol(JSPUtil.getParameter(request, prefix + "ts_vol", ""));
		setApVol(JSPUtil.getParameter(request, prefix + "ap_vol", ""));
		setCtrlRfFlg(JSPUtil.getParameter(request, prefix + "ctrl_rf_flg", ""));
		setCostMon(JSPUtil.getParameter(request, prefix + "cost_mon", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setAdWgt(JSPUtil.getParameter(request, prefix + "ad_wgt", ""));
		setBkgTsVol(JSPUtil.getParameter(request, prefix + "bkg_ts_vol", ""));
		setBkgTsWgt(JSPUtil.getParameter(request, prefix + "bkg_ts_wgt", ""));
		setApWgt(JSPUtil.getParameter(request, prefix + "ap_wgt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCtrlSpcFlg(JSPUtil.getParameter(request, prefix + "ctrl_spc_flg", ""));
		setCtrl45ftHcFlg(JSPUtil.getParameter(request, prefix + "ctrl_45ft_hc_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setFcTsWgt(JSPUtil.getParameter(request, prefix + "fc_ts_wgt", ""));
		setBkgWgt(JSPUtil.getParameter(request, prefix + "bkg_wgt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setCtrl53ftFlg(JSPUtil.getParameter(request, prefix + "ctrl_53ft_flg", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setFcVol(JSPUtil.getParameter(request, prefix + "fc_vol", ""));
		setQtaCmb(JSPUtil.getParameter(request, prefix + "qta_cmb", ""));
		setApTsVol(JSPUtil.getParameter(request, prefix + "ap_ts_vol", ""));
		setBkgVol(JSPUtil.getParameter(request, prefix + "bkg_vol", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceAllocation0044MasterListVO[]
	 */
	public SearchSpaceAllocation0044MasterListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceAllocation0044MasterListVO[]
	 */
	public SearchSpaceAllocation0044MasterListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceAllocation0044MasterListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrlPortFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_port_flg", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] adVol = (JSPUtil.getParameter(request, prefix	+ "ad_vol", length));
			String[] fcTsVol = (JSPUtil.getParameter(request, prefix	+ "fc_ts_vol", length));
			String[] ctrl40ftHcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_40ft_hc_flg", length));
			String[] apTsWgt = (JSPUtil.getParameter(request, prefix	+ "ap_ts_wgt", length));
			String[] qtaVol = (JSPUtil.getParameter(request, prefix	+ "qta_vol", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] tsWgt = (JSPUtil.getParameter(request, prefix	+ "ts_wgt", length));
			String[] fcWgt = (JSPUtil.getParameter(request, prefix	+ "fc_wgt", length));
			String[] ctrlWgtFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_wgt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tsVol = (JSPUtil.getParameter(request, prefix	+ "ts_vol", length));
			String[] apVol = (JSPUtil.getParameter(request, prefix	+ "ap_vol", length));
			String[] ctrlRfFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_rf_flg", length));
			String[] costMon = (JSPUtil.getParameter(request, prefix	+ "cost_mon", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] adWgt = (JSPUtil.getParameter(request, prefix	+ "ad_wgt", length));
			String[] bkgTsVol = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_vol", length));
			String[] bkgTsWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_wgt", length));
			String[] apWgt = (JSPUtil.getParameter(request, prefix	+ "ap_wgt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ctrlSpcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_spc_flg", length));
			String[] ctrl45ftHcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_45ft_hc_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] fcTsWgt = (JSPUtil.getParameter(request, prefix	+ "fc_ts_wgt", length));
			String[] bkgWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ctrl53ftFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_53ft_flg", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] fcVol = (JSPUtil.getParameter(request, prefix	+ "fc_vol", length));
			String[] qtaCmb = (JSPUtil.getParameter(request, prefix	+ "qta_cmb", length));
			String[] apTsVol = (JSPUtil.getParameter(request, prefix	+ "ap_ts_vol", length));
			String[] bkgVol = (JSPUtil.getParameter(request, prefix	+ "bkg_vol", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceAllocation0044MasterListVO();
				if (ctrlPortFlg[i] != null)
					model.setCtrlPortFlg(ctrlPortFlg[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (adVol[i] != null)
					model.setAdVol(adVol[i]);
				if (fcTsVol[i] != null)
					model.setFcTsVol(fcTsVol[i]);
				if (ctrl40ftHcFlg[i] != null)
					model.setCtrl40ftHcFlg(ctrl40ftHcFlg[i]);
				if (apTsWgt[i] != null)
					model.setApTsWgt(apTsWgt[i]);
				if (qtaVol[i] != null)
					model.setQtaVol(qtaVol[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (tsWgt[i] != null)
					model.setTsWgt(tsWgt[i]);
				if (fcWgt[i] != null)
					model.setFcWgt(fcWgt[i]);
				if (ctrlWgtFlg[i] != null)
					model.setCtrlWgtFlg(ctrlWgtFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tsVol[i] != null)
					model.setTsVol(tsVol[i]);
				if (apVol[i] != null)
					model.setApVol(apVol[i]);
				if (ctrlRfFlg[i] != null)
					model.setCtrlRfFlg(ctrlRfFlg[i]);
				if (costMon[i] != null)
					model.setCostMon(costMon[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (adWgt[i] != null)
					model.setAdWgt(adWgt[i]);
				if (bkgTsVol[i] != null)
					model.setBkgTsVol(bkgTsVol[i]);
				if (bkgTsWgt[i] != null)
					model.setBkgTsWgt(bkgTsWgt[i]);
				if (apWgt[i] != null)
					model.setApWgt(apWgt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ctrlSpcFlg[i] != null)
					model.setCtrlSpcFlg(ctrlSpcFlg[i]);
				if (ctrl45ftHcFlg[i] != null)
					model.setCtrl45ftHcFlg(ctrl45ftHcFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (fcTsWgt[i] != null)
					model.setFcTsWgt(fcTsWgt[i]);
				if (bkgWgt[i] != null)
					model.setBkgWgt(bkgWgt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ctrl53ftFlg[i] != null)
					model.setCtrl53ftFlg(ctrl53ftFlg[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (fcVol[i] != null)
					model.setFcVol(fcVol[i]);
				if (qtaCmb[i] != null)
					model.setQtaCmb(qtaCmb[i]);
				if (apTsVol[i] != null)
					model.setApTsVol(apTsVol[i]);
				if (bkgVol[i] != null)
					model.setBkgVol(bkgVol[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceAllocation0044MasterListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceAllocation0044MasterListVO[]
	 */
	public SearchSpaceAllocation0044MasterListVO[] getSearchSpaceAllocation0044MasterListVOs(){
		SearchSpaceAllocation0044MasterListVO[] vos = (SearchSpaceAllocation0044MasterListVO[])models.toArray(new SearchSpaceAllocation0044MasterListVO[models.size()]);
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
		this.ctrlPortFlg = this.ctrlPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adVol = this.adVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcTsVol = this.fcTsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl40ftHcFlg = this.ctrl40ftHcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apTsWgt = this.apTsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaVol = this.qtaVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsWgt = this.tsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcWgt = this.fcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlWgtFlg = this.ctrlWgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVol = this.tsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apVol = this.apVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlRfFlg = this.ctrlRfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costMon = this.costMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adWgt = this.adWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsVol = this.bkgTsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsWgt = this.bkgTsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apWgt = this.apWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlSpcFlg = this.ctrlSpcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl45ftHcFlg = this.ctrl45ftHcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcTsWgt = this.fcTsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgt = this.bkgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl53ftFlg = this.ctrl53ftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcVol = this.fcVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaCmb = this.qtaCmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apTsVol = this.apTsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVol = this.bkgVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
