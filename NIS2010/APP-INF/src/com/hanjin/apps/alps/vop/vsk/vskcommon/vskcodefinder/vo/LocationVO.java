/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationVO.java
*@FileTitle : LocationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.04 유혁 
* 1.0 Creation
* 
* History
* 2011.10.11 진마리아 CHM-201112898-01 Port Code Inquiry 조회 조건 추가 - Conti, Sconti, lat, long, period 등
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 유혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LocationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LocationVO> models = new ArrayList<LocationVO>();
	
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String bfrEqCtrlOfcCd = null;
	/* Column Info */
	private String unLocCd = null;
	/* Column Info */
	private String portInlndCd = null;
	/* Column Info */
	private String cstmsCd = null;
	/* Column Info */
	private String mtyPkupYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String frgnVatFlg = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String vopLocUrl = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String locChrCd = null;
	/* Column Info */
	private String bfrOfcCngDt = null;
	/* Column Info */
	private String repZnCd = null;
	/* Column Info */
	private String bkgAddrOrdCd = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String locGrdNo = null;
	/* Column Info */
	private String eqRtnYdCd = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String fincCtrlOfcCd = null;
	/* Column Info */
	private String senEqOfcCd = null;
	/* Column Info */
	private String locTpCd = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String znDivBselCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String gmtHrs = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String bkgAddrOrdDesc = null;
	/* Column Info */
	private String cmlZnFlg = null;
	/* Column Info */
	private String exptCustSvcOfcCd = null;
	/* Column Info */
	private String locAmsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntNm = null;
	/* Column Info */
	private String bfrFincCtrlOfcCd = null;
	/* Column Info */
	private String vopPortRhqCd = null;
	/* Column Info */
	private String vskdPortRhqCd = null;
	/* Column Info */
	private String bkgBlPfxCd = null;
	/* Column Info */
	private String vopPortMntrFlg = null;
	/* Column Info */
	private String vopPortFlg = null;
	/* Column Info */
	private String callPortFlg = null;
	/* Column Info */
	private String unLocIndCd = null;
	/* Column Info */
	private String exptLgsOfcCd = null;
	/* Column Info */
	private String vopPortCtrlOfcCd = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String blkPortFlg = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String hubLocCd = null;
	/* Column Info */
	private String bfrSlsOfcCd = null;
	/* Column Info */
	private String scontiCd = null;
	/* Column Info */
	private String zd = null;
	/* Column Info */
	private String locLat = null;
	/* Column Info */
	private String latUtCd = null;
	/* Column Info */
	private String fmLocLat = null;
	/* Column Info */
	private String toLocLat = null;
	/* Column Info */
	private String fmLatUtCd = null;
	/* Column Info */
	private String toLatUtCd = null;
	/* Column Info */
	private String locLon = null;
	/* Column Info */
	private String lonUtCd = null;
	/* Column Info */
	private String fmLocLon = null;
	/* Column Info */
	private String toLocLon = null;
	/* Column Info */
	private String fmLonUtCd = null;
	/* Column Info */
	private String toLonUtCd = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String euPort = null;
	/* Column Info */
	private String contiNm = null;
	/* Column Info */
	private String scontiNm = null;
	/* Column Info */
	private String vslSvcTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LocationVO() {}

	public LocationVO(String ibflag, String pagerows, String locCd, String sccCd, String locNm, String rgnCd, String cntCd, String steCd, String contiCd, String portInlndCd, String locChrCd, String blkPortFlg, String hubLocCd, String slsOfcCd, String locGrdNo, String gmtHrs, String bkgBlPfxCd, String callPortFlg, String locAmsPortCd, String fincCtrlOfcCd, String eqCtrlOfcCd, String mtyPkupYdCd, String senEqOfcCd, String eqRtnYdCd, String unLocIndCd, String unLocCd, String cmlZnFlg, String cstmsCd, String locTpCd, String bfrFincCtrlOfcCd, String bfrEqCtrlOfcCd, String bfrSlsOfcCd, String bfrOfcCngDt, String repZnCd, String zipCd, String scontiCd, String exptLgsOfcCd, String exptCustSvcOfcCd, String vopPortRhqCd, String vskdPortRhqCd, String vopPortCtrlOfcCd, String vopPortMntrFlg, String vopLocUrl, String vopPortFlg, String cntNm, String currCd, String frgnVatFlg, String znDivBselCd, String bkgAddrOrdCd, String bkgAddrOrdDesc, String zd, String locLat, String latUtCd, String fmLocLat, String toLocLat, String fmLatUtCd, String toLatUtCd, String locLon, String lonUtCd, String fmLocLon, String toLocLon, String fmLonUtCd, String toLonUtCd, String fmDt, String toDt, String euPort, String contiNm, String scontiNm, String vslSvcTpCd) {
		this.rgnCd = rgnCd;
		this.bfrEqCtrlOfcCd = bfrEqCtrlOfcCd;
		this.unLocCd = unLocCd;
		this.portInlndCd = portInlndCd;
		this.cstmsCd = cstmsCd;
		this.mtyPkupYdCd = mtyPkupYdCd;
		this.pagerows = pagerows;
		this.frgnVatFlg = frgnVatFlg;
		this.locCd = locCd;
		this.vopLocUrl = vopLocUrl;
		this.slsOfcCd = slsOfcCd;
		this.cntCd = cntCd;
		this.locChrCd = locChrCd;
		this.bfrOfcCngDt = bfrOfcCngDt;
		this.repZnCd = repZnCd;
		this.bkgAddrOrdCd = bkgAddrOrdCd;
		this.locNm = locNm;
		this.locGrdNo = locGrdNo;
		this.eqRtnYdCd = eqRtnYdCd;
		this.zipCd = zipCd;
		this.fincCtrlOfcCd = fincCtrlOfcCd;
		this.senEqOfcCd = senEqOfcCd;
		this.locTpCd = locTpCd;
		this.contiCd = contiCd;
		this.znDivBselCd = znDivBselCd;
		this.currCd = currCd;
		this.gmtHrs = gmtHrs;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.bkgAddrOrdDesc = bkgAddrOrdDesc;
		this.cmlZnFlg = cmlZnFlg;
		this.exptCustSvcOfcCd = exptCustSvcOfcCd;
		this.locAmsPortCd = locAmsPortCd;
		this.ibflag = ibflag;
		this.cntNm = cntNm;
		this.bfrFincCtrlOfcCd = bfrFincCtrlOfcCd;
		this.vopPortRhqCd = vopPortRhqCd;
		this.vskdPortRhqCd = vskdPortRhqCd;
		this.bkgBlPfxCd = bkgBlPfxCd;
		this.vopPortMntrFlg = vopPortMntrFlg;
		this.vopPortFlg = vopPortFlg;
		this.callPortFlg = callPortFlg;
		this.unLocIndCd = unLocIndCd;
		this.exptLgsOfcCd = exptLgsOfcCd;
		this.vopPortCtrlOfcCd = vopPortCtrlOfcCd;
		this.sccCd = sccCd;
		this.blkPortFlg = blkPortFlg;
		this.steCd = steCd;
		this.hubLocCd = hubLocCd;
		this.bfrSlsOfcCd = bfrSlsOfcCd;
		this.scontiCd = scontiCd;
		this.zd = zd;
		this.locLat = locLat; 
		this.latUtCd = latUtCd; 
		this.fmLocLat = fmLocLat; 
		this.toLocLat = toLocLat; 
		this.fmLatUtCd = fmLatUtCd; 
		this.toLatUtCd = toLatUtCd; 
		this.locLon = locLon; 
		this.lonUtCd = lonUtCd; 
		this.fmLocLon = fmLocLon; 
		this.toLocLon = toLocLon; 
		this.fmLonUtCd = fmLonUtCd; 
		this.toLonUtCd = toLonUtCd;
		this.fmDt = fmDt;
		this.toDt = toDt;
		this.euPort = euPort;
		this.contiNm = contiNm;
		this.scontiNm = scontiNm;
		this.vslSvcTpCd = vslSvcTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("bfr_eq_ctrl_ofc_cd", getBfrEqCtrlOfcCd());
		this.hashColumns.put("un_loc_cd", getUnLocCd());
		this.hashColumns.put("port_inlnd_cd", getPortInlndCd());
		this.hashColumns.put("cstms_cd", getCstmsCd());
		this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("frgn_vat_flg", getFrgnVatFlg());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("vop_loc_url", getVopLocUrl());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("loc_chr_cd", getLocChrCd());
		this.hashColumns.put("bfr_ofc_cng_dt", getBfrOfcCngDt());
		this.hashColumns.put("rep_zn_cd", getRepZnCd());
		this.hashColumns.put("bkg_addr_ord_cd", getBkgAddrOrdCd());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("loc_grd_no", getLocGrdNo());
		this.hashColumns.put("eq_rtn_yd_cd", getEqRtnYdCd());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("finc_ctrl_ofc_cd", getFincCtrlOfcCd());
		this.hashColumns.put("sen_eq_ofc_cd", getSenEqOfcCd());
		this.hashColumns.put("loc_tp_cd", getLocTpCd());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("zn_div_bsel_cd", getZnDivBselCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("gmt_hrs", getGmtHrs());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("bkg_addr_ord_desc", getBkgAddrOrdDesc());
		this.hashColumns.put("cml_zn_flg", getCmlZnFlg());
		this.hashColumns.put("expt_cust_svc_ofc_cd", getExptCustSvcOfcCd());
		this.hashColumns.put("loc_ams_port_cd", getLocAmsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("bfr_finc_ctrl_ofc_cd", getBfrFincCtrlOfcCd());
		this.hashColumns.put("vop_port_rhq_cd", getVopPortRhqCd());
		this.hashColumns.put("vskd_port_rhq_cd", getVskdPortRhqCd());
		this.hashColumns.put("bkg_bl_pfx_cd", getBkgBlPfxCd());
		this.hashColumns.put("vop_port_mntr_flg", getVopPortMntrFlg());
		this.hashColumns.put("vop_port_flg", getVopPortFlg());
		this.hashColumns.put("call_port_flg", getCallPortFlg());
		this.hashColumns.put("un_loc_ind_cd", getUnLocIndCd());
		this.hashColumns.put("expt_lgs_ofc_cd", getExptLgsOfcCd());
		this.hashColumns.put("vop_port_ctrl_ofc_cd", getVopPortCtrlOfcCd());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("blk_port_flg", getBlkPortFlg());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("bfr_sls_ofc_cd", getBfrSlsOfcCd());
		this.hashColumns.put("sconti_cd", getScontiCd());
		this.hashColumns.put("zd", getZd());
		this.hashColumns.put("loc_lat", getLocLat()); 
		this.hashColumns.put("lat_ut_cd", getLatUtCd()); 
		this.hashColumns.put("fm_loc_lat", getFmLocLat()); 
		this.hashColumns.put("to_loc_lat", getToLocLat()); 
		this.hashColumns.put("fm_lat_ut_cd", getFmLatUtCd()); 
		this.hashColumns.put("to_lat_ut_cd", getToLatUtCd()); 
		this.hashColumns.put("loc_lon", getLocLon()); 
		this.hashColumns.put("lon_ut_cd", getLonUtCd()); 
		this.hashColumns.put("fm_loc_lon", getFmLocLon()); 
		this.hashColumns.put("to_loc_lon", getToLocLon()); 
		this.hashColumns.put("fm_lon_ut_cd", getFmLonUtCd()); 
		this.hashColumns.put("to_lon_ut_cd", getToLonUtCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("eu_port", getEuPort());
		this.hashColumns.put("conti_nm", getContiNm());
		this.hashColumns.put("sconti_nm", getScontiNm());
		this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("bfr_eq_ctrl_ofc_cd", "bfrEqCtrlOfcCd");
		this.hashFields.put("un_loc_cd", "unLocCd");
		this.hashFields.put("port_inlnd_cd", "portInlndCd");
		this.hashFields.put("cstms_cd", "cstmsCd");
		this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("frgn_vat_flg", "frgnVatFlg");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("vop_loc_url", "vopLocUrl");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("loc_chr_cd", "locChrCd");
		this.hashFields.put("bfr_ofc_cng_dt", "bfrOfcCngDt");
		this.hashFields.put("rep_zn_cd", "repZnCd");
		this.hashFields.put("bkg_addr_ord_cd", "bkgAddrOrdCd");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("loc_grd_no", "locGrdNo");
		this.hashFields.put("eq_rtn_yd_cd", "eqRtnYdCd");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("finc_ctrl_ofc_cd", "fincCtrlOfcCd");
		this.hashFields.put("sen_eq_ofc_cd", "senEqOfcCd");
		this.hashFields.put("loc_tp_cd", "locTpCd");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("zn_div_bsel_cd", "znDivBselCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("gmt_hrs", "gmtHrs");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("bkg_addr_ord_desc", "bkgAddrOrdDesc");
		this.hashFields.put("cml_zn_flg", "cmlZnFlg");
		this.hashFields.put("expt_cust_svc_ofc_cd", "exptCustSvcOfcCd");
		this.hashFields.put("loc_ams_port_cd", "locAmsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("bfr_finc_ctrl_ofc_cd", "bfrFincCtrlOfcCd");
		this.hashFields.put("vop_port_rhq_cd", "vopPortRhqCd");
		this.hashFields.put("vskd_port_rhq_cd", "vskdPortRhqCd");
		this.hashFields.put("bkg_bl_pfx_cd", "bkgBlPfxCd");
		this.hashFields.put("vop_port_mntr_flg", "vopPortMntrFlg");
		this.hashFields.put("vop_port_flg", "vopPortFlg");
		this.hashFields.put("call_port_flg", "callPortFlg");
		this.hashFields.put("un_loc_ind_cd", "unLocIndCd");
		this.hashFields.put("expt_lgs_ofc_cd", "exptLgsOfcCd");
		this.hashFields.put("vop_port_ctrl_ofc_cd", "vopPortCtrlOfcCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("blk_port_flg", "blkPortFlg");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("bfr_sls_ofc_cd", "bfrSlsOfcCd");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("zd", "zd");
		this.hashFields.put("loc_lat", "locLat"); 
		this.hashFields.put("lat_ut_cd", "latUtCd"); 
		this.hashFields.put("fm_loc_lat", "fmLocLat"); 
		this.hashFields.put("to_loc_lat", "toLocLat"); 
		this.hashFields.put("fm_lat_ut_cd", "fmLatUtCd"); 
		this.hashFields.put("to_lat_ut_cd", "toLatUtCd"); 
		this.hashFields.put("loc_lon", "locLon"); 
		this.hashFields.put("lon_ut_cd", "lonUtCd"); 
		this.hashFields.put("fm_loc_lon", "fmLocLon"); 
		this.hashFields.put("to_loc_lon", "toLocLon"); 
		this.hashFields.put("fm_lon_ut_cd", "fmLonUtCd"); 
		this.hashFields.put("to_lon_ut_cd", "toLonUtCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("eu_port", "euPort");
		this.hashFields.put("conti_nm", "contiNm");
		this.hashFields.put("sconti_nm", "scontiNm");
		this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return bfrEqCtrlOfcCd
	 */
	public String getBfrEqCtrlOfcCd() {
		return this.bfrEqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return unLocCd
	 */
	public String getUnLocCd() {
		return this.unLocCd;
	}
	
	/**
	 * Column Info
	 * @return portInlndCd
	 */
	public String getPortInlndCd() {
		return this.portInlndCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsCd
	 */
	public String getCstmsCd() {
		return this.cstmsCd;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupYdCd
	 */
	public String getMtyPkupYdCd() {
		return this.mtyPkupYdCd;
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
	 * @return frgnVatFlg
	 */
	public String getFrgnVatFlg() {
		return this.frgnVatFlg;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return vopLocUrl
	 */
	public String getVopLocUrl() {
		return this.vopLocUrl;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return locChrCd
	 */
	public String getLocChrCd() {
		return this.locChrCd;
	}
	
	/**
	 * Column Info
	 * @return bfrOfcCngDt
	 */
	public String getBfrOfcCngDt() {
		return this.bfrOfcCngDt;
	}
	
	/**
	 * Column Info
	 * @return repZnCd
	 */
	public String getRepZnCd() {
		return this.repZnCd;
	}
	
	/**
	 * Column Info
	 * @return bkgAddrOrdCd
	 */
	public String getBkgAddrOrdCd() {
		return this.bkgAddrOrdCd;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
	}
	
	/**
	 * Column Info
	 * @return locGrdNo
	 */
	public String getLocGrdNo() {
		return this.locGrdNo;
	}
	
	/**
	 * Column Info
	 * @return eqRtnYdCd
	 */
	public String getEqRtnYdCd() {
		return this.eqRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return fincCtrlOfcCd
	 */
	public String getFincCtrlOfcCd() {
		return this.fincCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return senEqOfcCd
	 */
	public String getSenEqOfcCd() {
		return this.senEqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return locTpCd
	 */
	public String getLocTpCd() {
		return this.locTpCd;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
	}
	
	/**
	 * Column Info
	 * @return znDivBselCd
	 */
	public String getZnDivBselCd() {
		return this.znDivBselCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return gmtHrs
	 */
	public String getGmtHrs() {
		return this.gmtHrs;
	}
	
	/**
	 * Column Info
	 * @return eqCtrlOfcCd
	 */
	public String getEqCtrlOfcCd() {
		return this.eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgAddrOrdDesc
	 */
	public String getBkgAddrOrdDesc() {
		return this.bkgAddrOrdDesc;
	}
	
	/**
	 * Column Info
	 * @return cmlZnFlg
	 */
	public String getCmlZnFlg() {
		return this.cmlZnFlg;
	}
	
	/**
	 * Column Info
	 * @return exptCustSvcOfcCd
	 */
	public String getExptCustSvcOfcCd() {
		return this.exptCustSvcOfcCd;
	}
	
	/**
	 * Column Info
	 * @return locAmsPortCd
	 */
	public String getLocAmsPortCd() {
		return this.locAmsPortCd;
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
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
	}
	
	/**
	 * Column Info
	 * @return bfrFincCtrlOfcCd
	 */
	public String getBfrFincCtrlOfcCd() {
		return this.bfrFincCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vopPortRhqCd
	 */
	public String getVopPortRhqCd() {
		return this.vopPortRhqCd;
	}
	
	/**
	 * Column Info
	 * @return vskdPortRhqCd
	 */
	public String getVskdPortRhqCd() {
		return this.vskdPortRhqCd;
	}
	
	/**
	 * Column Info
	 * @return bkgBlPfxCd
	 */
	public String getBkgBlPfxCd() {
		return this.bkgBlPfxCd;
	}
	
	/**
	 * Column Info
	 * @return vopPortMntrFlg
	 */
	public String getVopPortMntrFlg() {
		return this.vopPortMntrFlg;
	}
	
	/**
	 * Column Info
	 * @return vopPortFlg
	 */
	public String getVopPortFlg() {
		return this.vopPortFlg;
	}
	
	/**
	 * Column Info
	 * @return callPortFlg
	 */
	public String getCallPortFlg() {
		return this.callPortFlg;
	}
	
	/**
	 * Column Info
	 * @return unLocIndCd
	 */
	public String getUnLocIndCd() {
		return this.unLocIndCd;
	}
	
	/**
	 * Column Info
	 * @return exptLgsOfcCd
	 */
	public String getExptLgsOfcCd() {
		return this.exptLgsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vopPortCtrlOfcCd
	 */
	public String getVopPortCtrlOfcCd() {
		return this.vopPortCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return blkPortFlg
	 */
	public String getBlkPortFlg() {
		return this.blkPortFlg;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
	}
	
	/**
	 * Column Info
	 * @return bfrSlsOfcCd
	 */
	public String getBfrSlsOfcCd() {
		return this.bfrSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return scontiCd
	 */
	public String getScontiCd() {
		return this.scontiCd;
	}
	
	/**
	 * Column Info
	 * @return zd
	 */
	public String getZd() {
		return this.zd;
	}
	
	/**
	 * Column Info
	 * @return locLat
	 */
	public String getLocLat() {
		return this.locLat;
	}
	
	/**
	 * Column Info
	 * @return latUtCd
	 */
	public String getLatUtCd() {
		return this.latUtCd;
	}
	
	/**
	 * Column Info
	 * @return fmLocLat
	 */
	public String getFmLocLat() {
		return this.fmLocLat;
	}
	
	/**
	 * Column Info
	 * @return toLocLat
	 */
	public String getToLocLat() {
		return this.toLocLat;
	}
	
	/**
	 * Column Info
	 * @return fmLatUtCd
	 */
	public String getFmLatUtCd() {
		return this.fmLatUtCd;
	}
	
	/**
	 * Column Info
	 * @return toLatUtCd
	 */
	public String getToLatUtCd() {
		return this.toLatUtCd;
	}
	
	/**
	 * Column Info
	 * @return locLon
	 */
	public String getLocLon() {
		return this.locLon;
	}
	
	/**
	 * Column Info
	 * @return lonUtCd
	 */
	public String getLonUtCd() {
		return this.lonUtCd;
	}
	
	/**
	 * Column Info
	 * @return fmLocLon
	 */
	public String getFmLocLon() {
		return this.fmLocLon;
	}
	
	/**
	 * Column Info
	 * @return toLocLon
	 */
	public String getToLocLon() {
		return this.toLocLon;
	}
	
	/**
	 * Column Info
	 * @return fmLonUtCd
	 */
	public String getFmLonUtCd() {
		return this.fmLonUtCd;
	}
	
	/**
	 * Column Info
	 * @return toLonUtCd
	 */
	public String getToLonUtCd() {
		return this.toLonUtCd;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return euPort
	 */
	public String getEuPort() {
		return this.euPort;
	}
	
	/**
	 * Column Info
	 * @return contiNm
	 */
	public String getContiNm() {
		return this.contiNm;
	}
	
	/**
	 * Column Info
	 * @return scontiNm
	 */
	public String getScontiNm() {
		return this.scontiNm;
	}
	
	/**
	 * Column Info
	 * @return vslSvcTpCd
	 */
	public String getVslSvcTpCd() {
		return this.vslSvcTpCd;
	}

	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param bfrEqCtrlOfcCd
	 */
	public void setBfrEqCtrlOfcCd(String bfrEqCtrlOfcCd) {
		this.bfrEqCtrlOfcCd = bfrEqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param unLocCd
	 */
	public void setUnLocCd(String unLocCd) {
		this.unLocCd = unLocCd;
	}
	
	/**
	 * Column Info
	 * @param portInlndCd
	 */
	public void setPortInlndCd(String portInlndCd) {
		this.portInlndCd = portInlndCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsCd
	 */
	public void setCstmsCd(String cstmsCd) {
		this.cstmsCd = cstmsCd;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupYdCd
	 */
	public void setMtyPkupYdCd(String mtyPkupYdCd) {
		this.mtyPkupYdCd = mtyPkupYdCd;
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
	 * @param frgnVatFlg
	 */
	public void setFrgnVatFlg(String frgnVatFlg) {
		this.frgnVatFlg = frgnVatFlg;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param vopLocUrl
	 */
	public void setVopLocUrl(String vopLocUrl) {
		this.vopLocUrl = vopLocUrl;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param locChrCd
	 */
	public void setLocChrCd(String locChrCd) {
		this.locChrCd = locChrCd;
	}
	
	/**
	 * Column Info
	 * @param bfrOfcCngDt
	 */
	public void setBfrOfcCngDt(String bfrOfcCngDt) {
		this.bfrOfcCngDt = bfrOfcCngDt;
	}
	
	/**
	 * Column Info
	 * @param repZnCd
	 */
	public void setRepZnCd(String repZnCd) {
		this.repZnCd = repZnCd;
	}
	
	/**
	 * Column Info
	 * @param bkgAddrOrdCd
	 */
	public void setBkgAddrOrdCd(String bkgAddrOrdCd) {
		this.bkgAddrOrdCd = bkgAddrOrdCd;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
	}
	
	/**
	 * Column Info
	 * @param locGrdNo
	 */
	public void setLocGrdNo(String locGrdNo) {
		this.locGrdNo = locGrdNo;
	}
	
	/**
	 * Column Info
	 * @param eqRtnYdCd
	 */
	public void setEqRtnYdCd(String eqRtnYdCd) {
		this.eqRtnYdCd = eqRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param fincCtrlOfcCd
	 */
	public void setFincCtrlOfcCd(String fincCtrlOfcCd) {
		this.fincCtrlOfcCd = fincCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param senEqOfcCd
	 */
	public void setSenEqOfcCd(String senEqOfcCd) {
		this.senEqOfcCd = senEqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param locTpCd
	 */
	public void setLocTpCd(String locTpCd) {
		this.locTpCd = locTpCd;
	}
	
	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}
	
	/**
	 * Column Info
	 * @param znDivBselCd
	 */
	public void setZnDivBselCd(String znDivBselCd) {
		this.znDivBselCd = znDivBselCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param gmtHrs
	 */
	public void setGmtHrs(String gmtHrs) {
		this.gmtHrs = gmtHrs;
	}
	
	/**
	 * Column Info
	 * @param eqCtrlOfcCd
	 */
	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgAddrOrdDesc
	 */
	public void setBkgAddrOrdDesc(String bkgAddrOrdDesc) {
		this.bkgAddrOrdDesc = bkgAddrOrdDesc;
	}
	
	/**
	 * Column Info
	 * @param cmlZnFlg
	 */
	public void setCmlZnFlg(String cmlZnFlg) {
		this.cmlZnFlg = cmlZnFlg;
	}
	
	/**
	 * Column Info
	 * @param exptCustSvcOfcCd
	 */
	public void setExptCustSvcOfcCd(String exptCustSvcOfcCd) {
		this.exptCustSvcOfcCd = exptCustSvcOfcCd;
	}
	
	/**
	 * Column Info
	 * @param locAmsPortCd
	 */
	public void setLocAmsPortCd(String locAmsPortCd) {
		this.locAmsPortCd = locAmsPortCd;
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
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
	}
	
	/**
	 * Column Info
	 * @param bfrFincCtrlOfcCd
	 */
	public void setBfrFincCtrlOfcCd(String bfrFincCtrlOfcCd) {
		this.bfrFincCtrlOfcCd = bfrFincCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vopPortRhqCd
	 */
	public void setVopPortRhqCd(String vopPortRhqCd) {
		this.vopPortRhqCd = vopPortRhqCd;
	}
	
	/**
	 * Column Info
	 * @param vskdPortRhqCd
	 */
	public void setVskdPortRhqCd(String vskdPortRhqCd) {
		this.vskdPortRhqCd = vskdPortRhqCd;
	}
	
	/**
	 * Column Info
	 * @param bkgBlPfxCd
	 */
	public void setBkgBlPfxCd(String bkgBlPfxCd) {
		this.bkgBlPfxCd = bkgBlPfxCd;
	}
	
	/**
	 * Column Info
	 * @param vopPortMntrFlg
	 */
	public void setVopPortMntrFlg(String vopPortMntrFlg) {
		this.vopPortMntrFlg = vopPortMntrFlg;
	}
	
	/**
	 * Column Info
	 * @param vopPortFlg
	 */
	public void setVopPortFlg(String vopPortFlg) {
		this.vopPortFlg = vopPortFlg;
	}
	
	/**
	 * Column Info
	 * @param callPortFlg
	 */
	public void setCallPortFlg(String callPortFlg) {
		this.callPortFlg = callPortFlg;
	}
	
	/**
	 * Column Info
	 * @param unLocIndCd
	 */
	public void setUnLocIndCd(String unLocIndCd) {
		this.unLocIndCd = unLocIndCd;
	}
	
	/**
	 * Column Info
	 * @param exptLgsOfcCd
	 */
	public void setExptLgsOfcCd(String exptLgsOfcCd) {
		this.exptLgsOfcCd = exptLgsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vopPortCtrlOfcCd
	 */
	public void setVopPortCtrlOfcCd(String vopPortCtrlOfcCd) {
		this.vopPortCtrlOfcCd = vopPortCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param blkPortFlg
	 */
	public void setBlkPortFlg(String blkPortFlg) {
		this.blkPortFlg = blkPortFlg;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * Column Info
	 * @param bfrSlsOfcCd
	 */
	public void setBfrSlsOfcCd(String bfrSlsOfcCd) {
		this.bfrSlsOfcCd = bfrSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param scontiCd
	 */
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
	}
	
	/**
	 * Column Info
	 * @param zd
	 */
	public void setZd(String zd) {
		this.zd = zd;
	}
	
	/**
	 * Column Info
	 * @param locLat
	 */
	public void setLocLat(String locLat) {
		this.locLat = locLat;
	}
	
	/**
	 * Column Info
	 * @param latUtCd
	 */
	public void setLatUtCd(String latUtCd) {
		this.latUtCd = latUtCd;
	}
	
	/**
	 * Column Info
	 * @param fmLocLat
	 */
	public void setFmLocLat(String fmLocLat) {
		this.fmLocLat = fmLocLat;
	}
	
	/**
	 * Column Info
	 * @param toLocLat
	 */
	public void setToLocLat(String toLocLat) {
		this.toLocLat = toLocLat;
	}
	
	/**
	 * Column Info
	 * @param fmLatUtCd
	 */
	public void setFmLatUtCd(String fmLatUtCd) {
		this.fmLatUtCd = fmLatUtCd;
	}
	
	/**
	 * Column Info
	 * @param toLatUtCd
	 */
	public void setToLatUtCd(String toLatUtCd) {
		this.toLatUtCd = toLatUtCd;
	}
	
	/**
	 * Column Info
	 * @param locLon
	 */
	public void setLocLon(String locLon) {
		this.locLon = locLon;
	}
	
	/**
	 * Column Info
	 * @param lonUtCd
	 */
	public void setLonUtCd(String lonUtCd) {
		this.lonUtCd = lonUtCd;
	}
	
	/**
	 * Column Info
	 * @param fmLocLon
	 */
	public void setFmLocLon(String fmLocLon) {
		this.fmLocLon = fmLocLon;
	}
	
	/**
	 * Column Info
	 * @param toLocLon
	 */
	public void setToLocLon(String toLocLon) {
		this.toLocLon = toLocLon;
	}
	
	/**
	 * Column Info
	 * @param fmLonUtCd
	 */
	public void setFmLonUtCd(String fmLonUtCd) {
		this.fmLonUtCd = fmLonUtCd;
	}
	
	/**
	 * Column Info
	 * @param toLonUtCd
	 */
	public void setToLonUtCd(String toLonUtCd) {
		this.toLonUtCd = toLonUtCd;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param euPort
	 */
	public void setEuPort(String euPort) {
		this.euPort = euPort;
	}
	
	/**
	 * Column Info
	 * @param contiNm
	 */
	public void setContiNm(String contiNm) {
		this.contiNm = contiNm;
	}
	
	/**
	 * Column Info
	 * @param scontiNm
	 */
	public void setScontiNm(String scontiNm) {
		this.scontiNm = scontiNm;
	}
	
	/**
	 * Column Info
	 * @param vslSvcTpCd
	 */
	public void setVslSvcTpCd(String vslSvcTpCd) {
		this.vslSvcTpCd = vslSvcTpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRgnCd(JSPUtil.getParameter(request, "rgn_cd", ""));
		setBfrEqCtrlOfcCd(JSPUtil.getParameter(request, "bfr_eq_ctrl_ofc_cd", ""));
		setUnLocCd(JSPUtil.getParameter(request, "un_loc_cd", ""));
		setPortInlndCd(JSPUtil.getParameter(request, "port_inlnd_cd", ""));
		setCstmsCd(JSPUtil.getParameter(request, "cstms_cd", ""));
		setMtyPkupYdCd(JSPUtil.getParameter(request, "mty_pkup_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFrgnVatFlg(JSPUtil.getParameter(request, "frgn_vat_flg", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setVopLocUrl(JSPUtil.getParameter(request, "vop_loc_url", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, "sls_ofc_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setLocChrCd(JSPUtil.getParameter(request, "loc_chr_cd", ""));
		setBfrOfcCngDt(JSPUtil.getParameter(request, "bfr_ofc_cng_dt", ""));
		setRepZnCd(JSPUtil.getParameter(request, "rep_zn_cd", ""));
		setBkgAddrOrdCd(JSPUtil.getParameter(request, "bkg_addr_ord_cd", ""));
		setLocNm(JSPUtil.getParameter(request, "loc_nm", ""));
		setLocGrdNo(JSPUtil.getParameter(request, "loc_grd_no", ""));
		setEqRtnYdCd(JSPUtil.getParameter(request, "eq_rtn_yd_cd", ""));
		setZipCd(JSPUtil.getParameter(request, "zip_cd", ""));
		setFincCtrlOfcCd(JSPUtil.getParameter(request, "finc_ctrl_ofc_cd", ""));
		setSenEqOfcCd(JSPUtil.getParameter(request, "sen_eq_ofc_cd", ""));
		setLocTpCd(JSPUtil.getParameter(request, "loc_tp_cd", ""));
		setContiCd(JSPUtil.getParameter(request, "conti_cd", ""));
		setZnDivBselCd(JSPUtil.getParameter(request, "zn_div_bsel_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setGmtHrs(JSPUtil.getParameter(request, "gmt_hrs", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, "eq_ctrl_ofc_cd", ""));
		setBkgAddrOrdDesc(JSPUtil.getParameter(request, "bkg_addr_ord_desc", ""));
		setCmlZnFlg(JSPUtil.getParameter(request, "cml_zn_flg", ""));
		setExptCustSvcOfcCd(JSPUtil.getParameter(request, "expt_cust_svc_ofc_cd", ""));
		setLocAmsPortCd(JSPUtil.getParameter(request, "loc_ams_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntNm(JSPUtil.getParameter(request, "cnt_nm", ""));
		setBfrFincCtrlOfcCd(JSPUtil.getParameter(request, "bfr_finc_ctrl_ofc_cd", ""));
		setVopPortRhqCd(JSPUtil.getParameter(request, "vop_port_rhq_cd", ""));
		setVskdPortRhqCd(JSPUtil.getParameter(request, "vskd_port_rhq_cd", ""));
		setBkgBlPfxCd(JSPUtil.getParameter(request, "bkg_bl_pfx_cd", ""));
		setVopPortMntrFlg(JSPUtil.getParameter(request, "vop_port_mntr_flg", ""));
		setVopPortFlg(JSPUtil.getParameter(request, "vop_port_flg", ""));
		setCallPortFlg(JSPUtil.getParameter(request, "call_port_flg", ""));
		setUnLocIndCd(JSPUtil.getParameter(request, "un_loc_ind_cd", ""));
		setExptLgsOfcCd(JSPUtil.getParameter(request, "expt_lgs_ofc_cd", ""));
		setVopPortCtrlOfcCd(JSPUtil.getParameter(request, "vop_port_ctrl_ofc_cd", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setBlkPortFlg(JSPUtil.getParameter(request, "blk_port_flg", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
		setHubLocCd(JSPUtil.getParameter(request, "hub_loc_cd", ""));
		setBfrSlsOfcCd(JSPUtil.getParameter(request, "bfr_sls_ofc_cd", ""));
		setScontiCd(JSPUtil.getParameter(request, "sconti_cd", ""));
		setZd(JSPUtil.getParameter(request, "zd", ""));
		setLocLat(JSPUtil.getParameter(request, "loc_lat", ""));
		setLatUtCd(JSPUtil.getParameter(request, "lat_ut_cd", ""));
		setFmLocLat(JSPUtil.getParameter(request, "fm_loc_lat", ""));
		setToLocLat(JSPUtil.getParameter(request, "to_loc_lat", ""));
		setFmLatUtCd(JSPUtil.getParameter(request, "fm_lat_ut_cd", ""));
		setToLatUtCd(JSPUtil.getParameter(request, "to_lat_ut_cd", ""));
		setLocLon(JSPUtil.getParameter(request, "loc_lon", ""));
		setLonUtCd(JSPUtil.getParameter(request, "lon_ut_cd", ""));
		setFmLocLon(JSPUtil.getParameter(request, "fm_loc_lon", ""));
		setToLocLon(JSPUtil.getParameter(request, "to_loc_lon", ""));
		setFmLonUtCd(JSPUtil.getParameter(request, "fm_lon_ut_cd", ""));
		setToLonUtCd(JSPUtil.getParameter(request, "to_lon_ut_cd", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setEuPort(JSPUtil.getParameter(request, "eu_port", ""));
		setContiNm(JSPUtil.getParameter(request, "conti_nm", ""));
		setScontiNm(JSPUtil.getParameter(request, "sconti_nm", ""));
		setVslSvcTpCd(JSPUtil.getParameter(request, "vsl_svc_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LocationVO[]
	 */
	public LocationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LocationVO[]
	 */
	public LocationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LocationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd".trim(), length));
			String[] bfrEqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "bfr_eq_ctrl_ofc_cd".trim(), length));
			String[] unLocCd = (JSPUtil.getParameter(request, prefix	+ "un_loc_cd".trim(), length));
			String[] portInlndCd = (JSPUtil.getParameter(request, prefix	+ "port_inlnd_cd".trim(), length));
			String[] cstmsCd = (JSPUtil.getParameter(request, prefix	+ "cstms_cd".trim(), length));
			String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_yd_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] frgnVatFlg = (JSPUtil.getParameter(request, prefix	+ "frgn_vat_flg".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] vopLocUrl = (JSPUtil.getParameter(request, prefix	+ "vop_loc_url".trim(), length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd".trim(), length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			String[] locChrCd = (JSPUtil.getParameter(request, prefix	+ "loc_chr_cd".trim(), length));
			String[] bfrOfcCngDt = (JSPUtil.getParameter(request, prefix	+ "bfr_ofc_cng_dt".trim(), length));
			String[] repZnCd = (JSPUtil.getParameter(request, prefix	+ "rep_zn_cd".trim(), length));
			String[] bkgAddrOrdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_addr_ord_cd".trim(), length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm".trim(), length));
			String[] locGrdNo = (JSPUtil.getParameter(request, prefix	+ "loc_grd_no".trim(), length));
			String[] eqRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "eq_rtn_yd_cd".trim(), length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd".trim(), length));
			String[] fincCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "finc_ctrl_ofc_cd".trim(), length));
			String[] senEqOfcCd = (JSPUtil.getParameter(request, prefix	+ "sen_eq_ofc_cd".trim(), length));
			String[] locTpCd = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd".trim(), length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd".trim(), length));
			String[] znDivBselCd = (JSPUtil.getParameter(request, prefix	+ "zn_div_bsel_cd".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] gmtHrs = (JSPUtil.getParameter(request, prefix	+ "gmt_hrs".trim(), length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd".trim(), length));
			String[] bkgAddrOrdDesc = (JSPUtil.getParameter(request, prefix	+ "bkg_addr_ord_desc".trim(), length));
			String[] cmlZnFlg = (JSPUtil.getParameter(request, prefix	+ "cml_zn_flg".trim(), length));
			String[] exptCustSvcOfcCd = (JSPUtil.getParameter(request, prefix	+ "expt_cust_svc_ofc_cd".trim(), length));
			String[] locAmsPortCd = (JSPUtil.getParameter(request, prefix	+ "loc_ams_port_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm".trim(), length));
			String[] bfrFincCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "bfr_finc_ctrl_ofc_cd".trim(), length));
			String[] vopPortRhqCd = (JSPUtil.getParameter(request, prefix	+ "vop_port_rhq_cd".trim(), length));
			String[] vskdPortRhqCd = (JSPUtil.getParameter(request, prefix	+ "vskd_port_rhq_cd".trim(), length));
			String[] bkgBlPfxCd = (JSPUtil.getParameter(request, prefix	+ "bkg_bl_pfx_cd".trim(), length));
			String[] vopPortMntrFlg = (JSPUtil.getParameter(request, prefix	+ "vop_port_mntr_flg".trim(), length));
			String[] vopPortFlg = (JSPUtil.getParameter(request, prefix	+ "vop_port_flg".trim(), length));
			String[] callPortFlg = (JSPUtil.getParameter(request, prefix	+ "call_port_flg".trim(), length));
			String[] unLocIndCd = (JSPUtil.getParameter(request, prefix	+ "un_loc_ind_cd".trim(), length));
			String[] exptLgsOfcCd = (JSPUtil.getParameter(request, prefix	+ "expt_lgs_ofc_cd".trim(), length));
			String[] vopPortCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "vop_port_ctrl_ofc_cd".trim(), length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd".trim(), length));
			String[] blkPortFlg = (JSPUtil.getParameter(request, prefix	+ "blk_port_flg".trim(), length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd".trim(), length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd".trim(), length));
			String[] bfrSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "bfr_sls_ofc_cd".trim(), length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd".trim(), length));
			String[] zd = (JSPUtil.getParameter(request, prefix	+ "zd".trim(), length));
			String[] locLat = (JSPUtil.getParameter(request, prefix + "loc_lat".trim(), length));
			String[] latUtCd = (JSPUtil.getParameter(request, prefix + "lat_ut_cd".trim(), length));
			String[] fmLocLat = (JSPUtil.getParameter(request, prefix + "fm_loc_lat".trim(), length));
			String[] toLocLat = (JSPUtil.getParameter(request, prefix + "to_loc_lat".trim(), length));
			String[] fmLatUtCd = (JSPUtil.getParameter(request, prefix + "fm_lat_ut_cd".trim(), length));
			String[] toLatUtCd = (JSPUtil.getParameter(request, prefix + "to_lat_ut_cd".trim(), length));
			String[] locLon = (JSPUtil.getParameter(request, prefix + "loc_lon".trim(), length));
			String[] lonUtCd = (JSPUtil.getParameter(request, prefix + "lon_ut_cd".trim(), length));
			String[] fmLocLon = (JSPUtil.getParameter(request, prefix + "fm_loc_lon".trim(), length));
			String[] toLocLon = (JSPUtil.getParameter(request, prefix + "to_loc_lon".trim(), length));
			String[] fmLonUtCd = (JSPUtil.getParameter(request, prefix + "fm_lon_ut_cd".trim(), length));
			String[] toLonUtCd = (JSPUtil.getParameter(request, prefix + "to_lon_ut_cd".trim(), length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix + "fm_dt".trim(), length));
			String[] toDt = (JSPUtil.getParameter(request, prefix + "to_dt".trim(), length));
			String[] euPort = (JSPUtil.getParameter(request, prefix + "eu_port".trim(), length));
			String[] contiNm = (JSPUtil.getParameter(request, prefix + "conti_nm".trim(), length));
			String[] scontiNm = (JSPUtil.getParameter(request, prefix + "sconti_nm".trim(), length));
			String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix + "vsl_svc_tp_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new LocationVO();
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (bfrEqCtrlOfcCd[i] != null)
					model.setBfrEqCtrlOfcCd(bfrEqCtrlOfcCd[i]);
				if (unLocCd[i] != null)
					model.setUnLocCd(unLocCd[i]);
				if (portInlndCd[i] != null)
					model.setPortInlndCd(portInlndCd[i]);
				if (cstmsCd[i] != null)
					model.setCstmsCd(cstmsCd[i]);
				if (mtyPkupYdCd[i] != null)
					model.setMtyPkupYdCd(mtyPkupYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (frgnVatFlg[i] != null)
					model.setFrgnVatFlg(frgnVatFlg[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (vopLocUrl[i] != null)
					model.setVopLocUrl(vopLocUrl[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (locChrCd[i] != null)
					model.setLocChrCd(locChrCd[i]);
				if (bfrOfcCngDt[i] != null)
					model.setBfrOfcCngDt(bfrOfcCngDt[i]);
				if (repZnCd[i] != null)
					model.setRepZnCd(repZnCd[i]);
				if (bkgAddrOrdCd[i] != null)
					model.setBkgAddrOrdCd(bkgAddrOrdCd[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (locGrdNo[i] != null)
					model.setLocGrdNo(locGrdNo[i]);
				if (eqRtnYdCd[i] != null)
					model.setEqRtnYdCd(eqRtnYdCd[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (fincCtrlOfcCd[i] != null)
					model.setFincCtrlOfcCd(fincCtrlOfcCd[i]);
				if (senEqOfcCd[i] != null)
					model.setSenEqOfcCd(senEqOfcCd[i]);
				if (locTpCd[i] != null)
					model.setLocTpCd(locTpCd[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (znDivBselCd[i] != null)
					model.setZnDivBselCd(znDivBselCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (gmtHrs[i] != null)
					model.setGmtHrs(gmtHrs[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (bkgAddrOrdDesc[i] != null)
					model.setBkgAddrOrdDesc(bkgAddrOrdDesc[i]);
				if (cmlZnFlg[i] != null)
					model.setCmlZnFlg(cmlZnFlg[i]);
				if (exptCustSvcOfcCd[i] != null)
					model.setExptCustSvcOfcCd(exptCustSvcOfcCd[i]);
				if (locAmsPortCd[i] != null)
					model.setLocAmsPortCd(locAmsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (bfrFincCtrlOfcCd[i] != null)
					model.setBfrFincCtrlOfcCd(bfrFincCtrlOfcCd[i]);
				if (vopPortRhqCd[i] != null)
					model.setVopPortRhqCd(vopPortRhqCd[i]);
				if (vskdPortRhqCd[i] != null)
					model.setVskdPortRhqCd(vskdPortRhqCd[i]);
				if (bkgBlPfxCd[i] != null)
					model.setBkgBlPfxCd(bkgBlPfxCd[i]);
				if (vopPortMntrFlg[i] != null)
					model.setVopPortMntrFlg(vopPortMntrFlg[i]);
				if (vopPortFlg[i] != null)
					model.setVopPortFlg(vopPortFlg[i]);
				if (callPortFlg[i] != null)
					model.setCallPortFlg(callPortFlg[i]);
				if (unLocIndCd[i] != null)
					model.setUnLocIndCd(unLocIndCd[i]);
				if (exptLgsOfcCd[i] != null)
					model.setExptLgsOfcCd(exptLgsOfcCd[i]);
				if (vopPortCtrlOfcCd[i] != null)
					model.setVopPortCtrlOfcCd(vopPortCtrlOfcCd[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (blkPortFlg[i] != null)
					model.setBlkPortFlg(blkPortFlg[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (bfrSlsOfcCd[i] != null)
					model.setBfrSlsOfcCd(bfrSlsOfcCd[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				if (zd[i] != null)
					model.setZd(zd[i]);
				if (locLat[i] != null)
					model.setLocLat(locLat[i]);
				if (latUtCd[i] != null)
					model.setLatUtCd(latUtCd[i]);
				if (fmLocLat[i] != null)
					model.setFmLocLat(fmLocLat[i]);
				if (toLocLat[i] != null)
					model.setToLocLat(toLocLat[i]);
				if (fmLatUtCd[i] != null)
					model.setFmLatUtCd(fmLatUtCd[i]);
				if (toLatUtCd[i] != null)
					model.setToLatUtCd(toLatUtCd[i]);
				if (locLon[i] != null)
					model.setLocLon(locLon[i]);
				if (lonUtCd[i] != null)
					model.setLonUtCd(lonUtCd[i]);
				if (fmLocLon[i] != null)
					model.setFmLocLon(fmLocLon[i]);
				if (toLocLon[i] != null)
					model.setToLocLon(toLocLon[i]);
				if (fmLonUtCd[i] != null)
					model.setFmLonUtCd(fmLonUtCd[i]);
				if (toLonUtCd[i] != null)
					model.setToLonUtCd(toLonUtCd[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (euPort[i] != null)
					model.setEuPort(euPort[i]);
				if (contiNm[i] != null)
					model.setContiNm(contiNm[i]);
				if (scontiNm[i] != null)
					model.setScontiNm(scontiNm[i]);
				if (vslSvcTpCd[i] != null)
					model.setVslSvcTpCd(vslSvcTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLocationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LocationVO[]
	 */
	public LocationVO[] getLocationVOs(){
		LocationVO[] vos = (LocationVO[])models.toArray(new LocationVO[models.size()]);
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
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrEqCtrlOfcCd = this.bfrEqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unLocCd = this.unLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portInlndCd = this.portInlndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCd = this.cstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupYdCd = this.mtyPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frgnVatFlg = this.frgnVatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopLocUrl = this.vopLocUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locChrCd = this.locChrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrOfcCngDt = this.bfrOfcCngDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repZnCd = this.repZnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAddrOrdCd = this.bkgAddrOrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrdNo = this.locGrdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRtnYdCd = this.eqRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincCtrlOfcCd = this.fincCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senEqOfcCd = this.senEqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCd = this.locTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znDivBselCd = this.znDivBselCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtHrs = this.gmtHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAddrOrdDesc = this.bkgAddrOrdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmlZnFlg = this.cmlZnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptCustSvcOfcCd = this.exptCustSvcOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locAmsPortCd = this.locAmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrFincCtrlOfcCd = this.bfrFincCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopPortRhqCd = this.vopPortRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskdPortRhqCd = this.vskdPortRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBlPfxCd = this.bkgBlPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopPortMntrFlg = this.vopPortMntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopPortFlg = this.vopPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callPortFlg = this.callPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unLocIndCd = this.unLocIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptLgsOfcCd = this.exptLgsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopPortCtrlOfcCd = this.vopPortCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkPortFlg = this.blkPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrSlsOfcCd = this.bfrSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zd = this.zd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locLat = this.locLat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.latUtCd = this.latUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocLat = this.fmLocLat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocLat = this.toLocLat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLatUtCd = this.fmLatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLatUtCd = this.toLatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locLon = this.locLon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lonUtCd = this.lonUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocLon = this.fmLocLon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocLon = this.toLocLon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLonUtCd = this.fmLonUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLonUtCd = this.toLonUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euPort = this.euPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiNm = this.contiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiNm = this.scontiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSvcTpCd = this.vslSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
