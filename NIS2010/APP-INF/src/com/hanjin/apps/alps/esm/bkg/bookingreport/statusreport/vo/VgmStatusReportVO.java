/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VgmStatusReportVO.java
*@FileTitle : VgmStatusReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class VgmStatusReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VgmStatusReportVO> models = new ArrayList<VgmStatusReportVO>();
	
	/* Column Info */
	private String pDtType = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String totalVgmCnt = null;
	/* Column Info */
	private String vgmWgtUtCd = null;
	/* Column Info */
	private String totalBkg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String pEtd = null;
	/* Column Info */
	private String pVgmFlg = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pAtd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vol = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String pOfcCd = null;
	/* Column Info */
	private String multiVvd = null;
	/* Column Info */
	private String pBkgOfcCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String qtyBkg = null;
	/* Column Info */
	private String totalCntrCnt = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String pRhqCd = null;
	/* Column Info */
	private String sz = null;
	/* Column Info */
	private String pPolCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String vgmMzdTpCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String vgmCntTarget = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String pVvdCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String qtyCntr = null;
	/* Column Info */
	private String vgmVrfySigCtnt = null;
	/* Column Info */
	private String totalNoVgmCnt = null;
	/* Column Info */
	private String denseRank = null;	
	/* Column Info */
	private String pPolLt = null;
	/* Column Info */
	private String shprName = null;
	/* Column Info */
	private String shipper = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String vgmSetDt = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String refNo = null;	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VgmStatusReportVO() {}

	public VgmStatusReportVO(String ibflag, String pagerows, String bkgNo, String blNo, String bkgOfcCd, String obSlsOfcCd, String ctrtOfcCd, String bkgStsCd, String qtyBkg, String qtyCntr, String cntrNo, String sz, String cntrWgt, String wgtUtCd, String vgmWgt, String vgmWgtUtCd, String vgmVrfySigCtnt, String vgmMzdTpCd, String vol, String polCd, String podCd, String delCd, String porCd, String vvdCd, String vgmCntTarget, String totalBkg, String totalCntrCnt, String pVvdCd, String pPolCd, String pBkgOfcCd, String pRhqCd, String pDtType, String pAtd, String pEtd, String pVgmFlg, String multiVvd, String pOfcCd, String totalNoVgmCnt, String totalVgmCnt, String denseRank, String pPolLt, String shprName, String shipper, String polYdCd, String slanCd, String vgmSetDt, String vpsEtdDt, String refNo) {
		this.pDtType = pDtType;
		this.porCd = porCd;
		this.totalVgmCnt = totalVgmCnt;
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.totalBkg = totalBkg;
		this.bkgStsCd = bkgStsCd;
		this.pEtd = pEtd;
		this.pVgmFlg = pVgmFlg;
		this.vgmWgt = vgmWgt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.pAtd = pAtd;
		this.ibflag = ibflag;
		this.vol = vol;
		this.polCd = polCd;
		this.pOfcCd = pOfcCd;
		this.multiVvd = multiVvd;
		this.pBkgOfcCd = pBkgOfcCd;
		this.vvdCd = vvdCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.wgtUtCd = wgtUtCd;
		this.qtyBkg = qtyBkg;
		this.totalCntrCnt = totalCntrCnt;
		this.obSlsOfcCd = obSlsOfcCd;
		this.pRhqCd = pRhqCd;
		this.sz = sz;
		this.pPolCd = pPolCd;
		this.bkgOfcCd = bkgOfcCd;
		this.cntrWgt = cntrWgt;
		this.vgmMzdTpCd = vgmMzdTpCd;
		this.delCd = delCd;
		this.vgmCntTarget = vgmCntTarget;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.pVvdCd = pVvdCd;
		this.cntrNo = cntrNo;
		this.qtyCntr = qtyCntr;
		this.vgmVrfySigCtnt = vgmVrfySigCtnt;
		this.totalNoVgmCnt = totalNoVgmCnt;
		this.denseRank = denseRank;
		this.pPolLt = pPolLt;
		this.shprName = shprName;
		this.shipper = shipper;
		this.vpsEtdDt = vpsEtdDt;
		this.slanCd = slanCd;
		this.vgmSetDt = vgmSetDt;
		this.polYdCd = polYdCd;	
		this.refNo = refNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p_dt_type", getPDtType());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("total_vgm_cnt", getTotalVgmCnt());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("total_bkg", getTotalBkg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("p_etd", getPEtd());
		this.hashColumns.put("p_vgm_flg", getPVgmFlg());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_atd", getPAtd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vol", getVol());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("p_ofc_cd", getPOfcCd());
		this.hashColumns.put("multi_vvd", getMultiVvd());
		this.hashColumns.put("p_bkg_ofc_cd", getPBkgOfcCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("qty_bkg", getQtyBkg());
		this.hashColumns.put("total_cntr_cnt", getTotalCntrCnt());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("p_rhq_cd", getPRhqCd());
		this.hashColumns.put("sz", getSz());
		this.hashColumns.put("p_pol_cd", getPPolCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("vgm_mzd_tp_cd", getVgmMzdTpCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("vgm_cnt_target", getVgmCntTarget());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("p_vvd_cd", getPVvdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("qty_cntr", getQtyCntr());
		this.hashColumns.put("vgm_vrfy_sig_ctnt", getVgmVrfySigCtnt());
		this.hashColumns.put("total_no_vgm_cnt", getTotalNoVgmCnt());
		this.hashColumns.put("dense_rank", getDenseRank());
		this.hashColumns.put("p_pol_lt", getPPolLt());
		this.hashColumns.put("shpr_name", getShprName());
		this.hashColumns.put("shipper", getShipper());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("vgm_set_dt", getVgmSetDt());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("ref_no", getRefNo());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("p_dt_type", "pDtType");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("total_vgm_cnt", "totalVgmCnt");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("total_bkg", "totalBkg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("p_etd", "pEtd");
		this.hashFields.put("p_vgm_flg", "pVgmFlg");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_atd", "pAtd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vol", "vol");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("p_ofc_cd", "pOfcCd");
		this.hashFields.put("multi_vvd", "multiVvd");
		this.hashFields.put("p_bkg_ofc_cd", "pBkgOfcCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("qty_bkg", "qtyBkg");
		this.hashFields.put("total_cntr_cnt", "totalCntrCnt");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("p_rhq_cd", "pRhqCd");
		this.hashFields.put("sz", "sz");
		this.hashFields.put("p_pol_cd", "pPolCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("vgm_mzd_tp_cd", "vgmMzdTpCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("vgm_cnt_target", "vgmCntTarget");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("p_vvd_cd", "pVvdCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("qty_cntr", "qtyCntr");
		this.hashFields.put("vgm_vrfy_sig_ctnt", "vgmVrfySigCtnt");
		this.hashFields.put("total_no_vgm_cnt", "totalNoVgmCnt");
		this.hashFields.put("dense_rank", "denseRank");
		this.hashFields.put("p_pol_lt", "pPolLt");
		this.hashFields.put("shpr_name", "shprName");
		this.hashFields.put("shipper", "shipper");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vgm_set_dt", "vgmSetDt");
		this.hashFields.put("pol_yd_cd", "polYdCd");		
		this.hashFields.put("ref_no", "refNo");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pDtType
	 */
	public String getPDtType() {
		return this.pDtType;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return totalVgmCnt
	 */
	public String getTotalVgmCnt() {
		return this.totalVgmCnt;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUtCd
	 */
	public String getVgmWgtUtCd() {
		return this.vgmWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return totalBkg
	 */
	public String getTotalBkg() {
		return this.totalBkg;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return pEtd
	 */
	public String getPEtd() {
		return this.pEtd;
	}
	
	/**
	 * Column Info
	 * @return pVgmFlg
	 */
	public String getPVgmFlg() {
		return this.pVgmFlg;
	}
	
	/**
	 * Column Info
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
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
	 * @return pAtd
	 */
	public String getPAtd() {
		return this.pAtd;
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
	 * @return vol
	 */
	public String getVol() {
		return this.vol;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return pOfcCd
	 */
	public String getPOfcCd() {
		return this.pOfcCd;
	}
	
	/**
	 * Column Info
	 * @return multiVvd
	 */
	public String getMultiVvd() {
		return this.multiVvd;
	}
	
	/**
	 * Column Info
	 * @return pBkgOfcCd
	 */
	public String getPBkgOfcCd() {
		return this.pBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
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
	 * @return qtyBkg
	 */
	public String getQtyBkg() {
		return this.qtyBkg;
	}
	
	/**
	 * Column Info
	 * @return totalCntrCnt
	 */
	public String getTotalCntrCnt() {
		return this.totalCntrCnt;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return pRhqCd
	 */
	public String getPRhqCd() {
		return this.pRhqCd;
	}
	
	/**
	 * Column Info
	 * @return sz
	 */
	public String getSz() {
		return this.sz;
	}
	
	/**
	 * Column Info
	 * @return pPolCd
	 */
	public String getPPolCd() {
		return this.pPolCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return vgmMzdTpCd
	 */
	public String getVgmMzdTpCd() {
		return this.vgmMzdTpCd;
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
	 * @return vgmCntTarget
	 */
	public String getVgmCntTarget() {
		return this.vgmCntTarget;
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
	 * @return pVvdCd
	 */
	public String getPVvdCd() {
		return this.pVvdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return qtyCntr
	 */
	public String getQtyCntr() {
		return this.qtyCntr;
	}
	
	/**
	 * Column Info
	 * @return vgmVrfySigCtnt
	 */
	public String getVgmVrfySigCtnt() {
		return this.vgmVrfySigCtnt;
	}
	
	/**
	 * Column Info
	 * @return totalNoVgmCnt
	 */
	public String getTotalNoVgmCnt() {
		return this.totalNoVgmCnt;
	}

	/**
	 * Column Info
	 * @return denseRank
	 */
	public String getDenseRank() {
		return this.denseRank;
	}
	
	/**
	 * Column Info
	 * @return pPolLt
	 */
	public String getPPolLt() {
		return this.pPolLt;
	}

	/**
	 * Column Info
	 * @return shprName
	 */
	public String getShprName() {
		return this.shprName;
	}

	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}

	/**
	 * Column Info
	 * @return shipper
	 */
	public String getShipper() {
		return this.shipper;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return vgmSetDt
	 */
	public String getVgmSetDt() {
		return this.vgmSetDt;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}

	/**
	 * Column Info
	 * @param pDtType
	 */
	public void setPDtType(String pDtType) {
		this.pDtType = pDtType;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param totalVgmCnt
	 */
	public void setTotalVgmCnt(String totalVgmCnt) {
		this.totalVgmCnt = totalVgmCnt;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param totalBkg
	 */
	public void setTotalBkg(String totalBkg) {
		this.totalBkg = totalBkg;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param pEtd
	 */
	public void setPEtd(String pEtd) {
		this.pEtd = pEtd;
	}
	
	/**
	 * Column Info
	 * @param pVgmFlg
	 */
	public void setPVgmFlg(String pVgmFlg) {
		this.pVgmFlg = pVgmFlg;
	}
	
	/**
	 * Column Info
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
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
	 * @param pAtd
	 */
	public void setPAtd(String pAtd) {
		this.pAtd = pAtd;
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
	 * @param vol
	 */
	public void setVol(String vol) {
		this.vol = vol;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param pOfcCd
	 */
	public void setPOfcCd(String pOfcCd) {
		this.pOfcCd = pOfcCd;
	}
	
	/**
	 * Column Info
	 * @param multiVvd
	 */
	public void setMultiVvd(String multiVvd) {
		this.multiVvd = multiVvd;
	}
	
	/**
	 * Column Info
	 * @param pBkgOfcCd
	 */
	public void setPBkgOfcCd(String pBkgOfcCd) {
		this.pBkgOfcCd = pBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
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
	 * @param qtyBkg
	 */
	public void setQtyBkg(String qtyBkg) {
		this.qtyBkg = qtyBkg;
	}
	
	/**
	 * Column Info
	 * @param totalCntrCnt
	 */
	public void setTotalCntrCnt(String totalCntrCnt) {
		this.totalCntrCnt = totalCntrCnt;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param pRhqCd
	 */
	public void setPRhqCd(String pRhqCd) {
		this.pRhqCd = pRhqCd;
	}
	
	/**
	 * Column Info
	 * @param sz
	 */
	public void setSz(String sz) {
		this.sz = sz;
	}
	
	/**
	 * Column Info
	 * @param pPolCd
	 */
	public void setPPolCd(String pPolCd) {
		this.pPolCd = pPolCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param vgmMzdTpCd
	 */
	public void setVgmMzdTpCd(String vgmMzdTpCd) {
		this.vgmMzdTpCd = vgmMzdTpCd;
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
	 * @param vgmCntTarget
	 */
	public void setVgmCntTarget(String vgmCntTarget) {
		this.vgmCntTarget = vgmCntTarget;
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
	 * @param pVvdCd
	 */
	public void setPVvdCd(String pVvdCd) {
		this.pVvdCd = pVvdCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param qtyCntr
	 */
	public void setQtyCntr(String qtyCntr) {
		this.qtyCntr = qtyCntr;
	}
	
	/**
	 * Column Info
	 * @param vgmVrfySigCtnt
	 */
	public void setVgmVrfySigCtnt(String vgmVrfySigCtnt) {
		this.vgmVrfySigCtnt = vgmVrfySigCtnt;
	}
	
	/**
	 * Column Info
	 * @param totalNoVgmCnt
	 */
	public void setTotalNoVgmCnt(String totalNoVgmCnt) {
		this.totalNoVgmCnt = totalNoVgmCnt;
	}
	
	/**
	 * Column Info
	 * @param denseRank
	 */
	public void setDenseRank(String denseRank) {
		this.denseRank = denseRank;
	}

	/**
	 * Column Info
	 * @param pPolLt
	 */
	public void setPPolLt(String pPolLt) {
		this.pPolLt = pPolLt;
	}

	/**
	 * Column Info
	 * @param shprName
	 */
	public void setShprName(String shprName) {
		this.shprName = shprName;
	}
	
	/**
	 * Column Info
	 * @param shipper
	 */
	public void setShipper(String shipper) {
		this.shipper = shipper;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param vgmSetDt
	 */
	public void setVgmSetDt(String vgmSetDt) {
		this.vgmSetDt = vgmSetDt;
	}

	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
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
		setPDtType(JSPUtil.getParameter(request, prefix + "p_dt_type", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setTotalVgmCnt(JSPUtil.getParameter(request, prefix + "total_vgm_cnt", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
		setTotalBkg(JSPUtil.getParameter(request, prefix + "total_bkg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setPEtd(JSPUtil.getParameter(request, prefix + "p_etd", ""));
		setPVgmFlg(JSPUtil.getParameter(request, prefix + "p_vgm_flg", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPAtd(JSPUtil.getParameter(request, prefix + "p_atd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVol(JSPUtil.getParameter(request, prefix + "vol", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPOfcCd(JSPUtil.getParameter(request, prefix + "p_ofc_cd", ""));
		setMultiVvd(JSPUtil.getParameter(request, prefix + "multi_vvd", ""));
		setPBkgOfcCd(JSPUtil.getParameter(request, prefix + "p_bkg_ofc_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setQtyBkg(JSPUtil.getParameter(request, prefix + "qty_bkg", ""));
		setTotalCntrCnt(JSPUtil.getParameter(request, prefix + "total_cntr_cnt", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setPRhqCd(JSPUtil.getParameter(request, prefix + "p_rhq_cd", ""));
		setSz(JSPUtil.getParameter(request, prefix + "sz", ""));
		setPPolCd(JSPUtil.getParameter(request, prefix + "p_pol_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setVgmMzdTpCd(JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setVgmCntTarget(JSPUtil.getParameter(request, prefix + "vgm_cnt_target", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPVvdCd(JSPUtil.getParameter(request, prefix + "p_vvd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setQtyCntr(JSPUtil.getParameter(request, prefix + "qty_cntr", ""));
		setVgmVrfySigCtnt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_sig_ctnt", ""));
		setTotalNoVgmCnt(JSPUtil.getParameter(request, prefix + "total_no_vgm_cnt", ""));
		setDenseRank(JSPUtil.getParameter(request, prefix + "dense_rank", ""));
		setPPolLt(JSPUtil.getParameter(request, prefix + "p_pol_lt", ""));
		setShprName(JSPUtil.getParameter(request, prefix + "shpr_name", ""));
		setShipper(JSPUtil.getParameter(request, prefix + "shipper", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setVgmSetDt(JSPUtil.getParameter(request, prefix + "vgm_set_dt", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));	
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VgmStatusReportVO[]
	 */
	public VgmStatusReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VgmStatusReportVO[]
	 */
	public VgmStatusReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VgmStatusReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pDtType = (JSPUtil.getParameter(request, prefix	+ "p_dt_type", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] totalVgmCnt = (JSPUtil.getParameter(request, prefix	+ "total_vgm_cnt", length));
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));
			String[] totalBkg = (JSPUtil.getParameter(request, prefix	+ "total_bkg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] pEtd = (JSPUtil.getParameter(request, prefix	+ "p_etd", length));
			String[] pVgmFlg = (JSPUtil.getParameter(request, prefix	+ "p_vgm_flg", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pAtd = (JSPUtil.getParameter(request, prefix	+ "p_atd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vol = (JSPUtil.getParameter(request, prefix	+ "vol", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] pOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_ofc_cd", length));
			String[] multiVvd = (JSPUtil.getParameter(request, prefix	+ "multi_vvd", length));
			String[] pBkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_bkg_ofc_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] qtyBkg = (JSPUtil.getParameter(request, prefix	+ "qty_bkg", length));
			String[] totalCntrCnt = (JSPUtil.getParameter(request, prefix	+ "total_cntr_cnt", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] pRhqCd = (JSPUtil.getParameter(request, prefix	+ "p_rhq_cd", length));
			String[] sz = (JSPUtil.getParameter(request, prefix	+ "sz", length));
			String[] pPolCd = (JSPUtil.getParameter(request, prefix	+ "p_pol_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] vgmMzdTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_mzd_tp_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] vgmCntTarget = (JSPUtil.getParameter(request, prefix	+ "vgm_cnt_target", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] pVvdCd = (JSPUtil.getParameter(request, prefix	+ "p_vvd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] qtyCntr = (JSPUtil.getParameter(request, prefix	+ "qty_cntr", length));
			String[] vgmVrfySigCtnt = (JSPUtil.getParameter(request, prefix	+ "vgm_vrfy_sig_ctnt", length));
			String[] totalNoVgmCnt = (JSPUtil.getParameter(request, prefix	+ "total_no_vgm_cnt", length));
			String[] denseRank = (JSPUtil.getParameter(request, prefix	+ "dense_rank", length));
			String[] pPolLt = (JSPUtil.getParameter(request, prefix	+ "p_pol_lt", length));
			String[] shprName = (JSPUtil.getParameter(request, prefix	+ "shpr_name", length));
			String[] shipper = (JSPUtil.getParameter(request, prefix	+ "shipper", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] vgmSetDt = (JSPUtil.getParameter(request, prefix	+ "vgm_set_dt", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new VgmStatusReportVO();
				if (pDtType[i] != null)
					model.setPDtType(pDtType[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (totalVgmCnt[i] != null)
					model.setTotalVgmCnt(totalVgmCnt[i]);
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				if (totalBkg[i] != null)
					model.setTotalBkg(totalBkg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (pEtd[i] != null)
					model.setPEtd(pEtd[i]);
				if (pVgmFlg[i] != null)
					model.setPVgmFlg(pVgmFlg[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pAtd[i] != null)
					model.setPAtd(pAtd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vol[i] != null)
					model.setVol(vol[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (pOfcCd[i] != null)
					model.setPOfcCd(pOfcCd[i]);
				if (multiVvd[i] != null)
					model.setMultiVvd(multiVvd[i]);
				if (pBkgOfcCd[i] != null)
					model.setPBkgOfcCd(pBkgOfcCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (qtyBkg[i] != null)
					model.setQtyBkg(qtyBkg[i]);
				if (totalCntrCnt[i] != null)
					model.setTotalCntrCnt(totalCntrCnt[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (pRhqCd[i] != null)
					model.setPRhqCd(pRhqCd[i]);
				if (sz[i] != null)
					model.setSz(sz[i]);
				if (pPolCd[i] != null)
					model.setPPolCd(pPolCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (vgmMzdTpCd[i] != null)
					model.setVgmMzdTpCd(vgmMzdTpCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (vgmCntTarget[i] != null)
					model.setVgmCntTarget(vgmCntTarget[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (pVvdCd[i] != null)
					model.setPVvdCd(pVvdCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (qtyCntr[i] != null)
					model.setQtyCntr(qtyCntr[i]);
				if (vgmVrfySigCtnt[i] != null)
					model.setVgmVrfySigCtnt(vgmVrfySigCtnt[i]);
				if (totalNoVgmCnt[i] != null)
					model.setTotalNoVgmCnt(totalNoVgmCnt[i]);
				if (denseRank[i] != null)
					model.setDenseRank(denseRank[i]);
				if (pPolLt[i] != null)
					model.setPPolLt(pPolLt[i]);
				if (shprName[i] != null)
					model.setShprName(shprName[i]);				
				if (shipper[i] != null)
					model.setShipper(shipper[i]);				
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (vgmSetDt[i] != null)
					model.setVgmSetDt(vgmSetDt[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);				
				
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVgmStatusReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VgmStatusReportVO[]
	 */
	public VgmStatusReportVO[] getVgmStatusReportVOs(){
		VgmStatusReportVO[] vos = (VgmStatusReportVO[])models.toArray(new VgmStatusReportVO[models.size()]);
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
		this.pDtType = this.pDtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalVgmCnt = this.totalVgmCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalBkg = this.totalBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEtd = this.pEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVgmFlg = this.pVgmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pAtd = this.pAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vol = this.vol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pOfcCd = this.pOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.multiVvd = this.multiVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBkgOfcCd = this.pBkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyBkg = this.qtyBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCntrCnt = this.totalCntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pRhqCd = this.pRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sz = this.sz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPolCd = this.pPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmMzdTpCd = this.vgmMzdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCntTarget = this.vgmCntTarget .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVvdCd = this.pVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyCntr = this.qtyCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfySigCtnt = this.vgmVrfySigCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalNoVgmCnt = this.totalNoVgmCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.denseRank = this.denseRank .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.pPolLt = this.pPolLt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprName = this.shprName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipper = this.shipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmSetDt = this.vgmSetDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
