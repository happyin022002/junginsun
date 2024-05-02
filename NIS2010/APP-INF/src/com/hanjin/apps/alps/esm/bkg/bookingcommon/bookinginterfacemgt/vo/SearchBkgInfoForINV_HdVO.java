/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBkgInfoForINV_HdVO.java
*@FileTitle : SearchBkgInfoForINV_HdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.10.22 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBkgInfoForINV_HdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBkgInfoForINV_HdVO> models = new ArrayList<SearchBkgInfoForINV_HdVO>();
	
	/* Column Info */
	private String whfDlcOfcCd = null;
	/* Column Info */
	private String trunkSkdVoyNo = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String cct3rdCnt3 = null;
	/* Column Info */
	private String cct3rdCnt2 = null;
	/* Column Info */
	private String cct3rdCnt1 = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ppd3rdCust1 = null;
	/* Column Info */
	private String trunkSkdDirCd = null;
	/* Column Info */
	private String ppd3rdCust2 = null;
	/* Column Info */
	private String ppd3rdCust3 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String autoRatingDivision = null;
	/* Column Info */
	private String ppd3rdCnt1 = null;
	/* Column Info */
	private String destTrnsSvcModCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ppd3rdCnt2 = null;
	/* Column Info */
	private String whfVvd = null;
	/* Column Info */
	private String ppd3rdCnt3 = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String mstBlNo = null;
	/* Column Info */
	private String cgoWgt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String bookingSer = null;
	/* Column Info */
	private String finDirCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String whfNtcNo = null;
	/* Column Info */
	private String frtFwrdCustSeq = null;
	/* Column Info */
	private String whfDlcNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cct3rdOfc2 = null;
	/* Column Info */
	private String caRsn = null;
	/* Column Info */
	private String cct3rdOfc1 = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String siRefNo = null;
	/* Column Info */
	private String ppd3rdOfc2 = null;
	/* Column Info */
	private String ppd3rdOfc1 = null;
	/* Column Info */
	private String ppdOfc = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String ppd3rdOfc3 = null;
	/* Column Info */
	private String ppdPayrCustSeq = null;
	/* Column Info */
	private String cct3rdOfc3 = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String ppdPayrCntCd = null;
	/* Column Info */
	private String cct3rdCust1 = null;
	/* Column Info */
	private String cct3rdCust2 = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String cct3rdCust3 = null;
	/* Column Info */
	private String polVvd = null;
	/* Column Info */
	private String cltPayrCustSeq = null;
	/* Column Info */
	private String cltPayrCntCd = null;
	/* Column Info */
	private String timestamp = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String trunkVslCd = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podVvd = null;
	/* Column Info */
	private String cgoMeasQty = null;
	/* Column Info */
	private String bkgCorrDt = null;
	/* Column Info */
	private String whfMrnNo = null;
	/* Column Info */
	private String invRefNo = null;
	/* Column Info */
	private String corrNo = null;
	/* Column Info */
	private String bkgRefNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String whfDlcDt = null;
	/* Column Info */
	private String cancelMk = null;
	/* Column Info */
	private String actShpr = null;
	/* Column Info */
	private String frtFwrdCntCd = null;
	/* Column Info */
	private String cctOfc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBkgInfoForINV_HdVO() {}

	public SearchBkgInfoForINV_HdVO(String ibflag, String pagerows, String bkgNo, String bookingSer, String timestamp, String blNo, String bkgStsCd, String cancelMk, String corrNo, String bkgCorrDt, String caRsn, String slanCd, String trunkVslCd, String trunkSkdVoyNo, String trunkSkdDirCd, String finDirCd, String porCd, String polCd, String podCd, String delCd, String cgoWgt, String cgoMeasQty, String srepCd, String destTrnsSvcModCd, String mstBlNo, String svcScpCd, String bkgRefNo, String invRefNo, String siRefNo, String autoRatingDivision, String ppd3rdOfc1, String cct3rdOfc1, String ppd3rdOfc2, String cct3rdOfc2, String ppd3rdOfc3, String cct3rdOfc3, String ppdOfc, String cctOfc, String ppdPayrCntCd, String ppdPayrCustSeq, String cltPayrCntCd, String cltPayrCustSeq, String ppd3rdCnt1, String ppd3rdCust1, String cct3rdCnt1, String cct3rdCust1, String ppd3rdCnt2, String ppd3rdCust2, String cct3rdCnt2, String cct3rdCust2, String ppd3rdCnt3, String ppd3rdCust3, String cct3rdCnt3, String cct3rdCust3, String frtFwrdCntCd, String frtFwrdCustSeq, String scNo, String rfaNo, String bkgTeuQty, String bkgFeuQty, String polVvd, String podVvd, String actShpr, String whfDlcNo, String whfDlcDt, String whfDlcOfcCd, String whfMrnNo, String whfNtcNo, String whfVvd, String csrNo) {
		this.whfDlcOfcCd = whfDlcOfcCd;
		this.trunkSkdVoyNo = trunkSkdVoyNo;
		this.svcScpCd = svcScpCd;
		this.cct3rdCnt3 = cct3rdCnt3;
		this.cct3rdCnt2 = cct3rdCnt2;
		this.cct3rdCnt1 = cct3rdCnt1;
		this.srepCd = srepCd;
		this.blNo = blNo;
		this.ppd3rdCust1 = ppd3rdCust1;
		this.trunkSkdDirCd = trunkSkdDirCd;
		this.ppd3rdCust2 = ppd3rdCust2;
		this.ppd3rdCust3 = ppd3rdCust3;
		this.pagerows = pagerows;
		this.autoRatingDivision = autoRatingDivision;
		this.ppd3rdCnt1 = ppd3rdCnt1;
		this.destTrnsSvcModCd = destTrnsSvcModCd;
		this.polCd = polCd;
		this.ppd3rdCnt2 = ppd3rdCnt2;
		this.whfVvd = whfVvd;
		this.ppd3rdCnt3 = ppd3rdCnt3;
		this.scNo = scNo;
		this.mstBlNo = mstBlNo;
		this.cgoWgt = cgoWgt;
		this.csrNo = csrNo;
		this.bookingSer = bookingSer;
		this.finDirCd = finDirCd;
		this.delCd = delCd;
		this.whfNtcNo = whfNtcNo;
		this.frtFwrdCustSeq = frtFwrdCustSeq;
		this.whfDlcNo = whfDlcNo;
		this.podCd = podCd;
		this.cct3rdOfc2 = cct3rdOfc2;
		this.caRsn = caRsn;
		this.cct3rdOfc1 = cct3rdOfc1;
		this.bkgNo = bkgNo;
		this.siRefNo = siRefNo;
		this.ppd3rdOfc2 = ppd3rdOfc2;
		this.ppd3rdOfc1 = ppd3rdOfc1;
		this.ppdOfc = ppdOfc;
		this.bkgTeuQty = bkgTeuQty;
		this.ppd3rdOfc3 = ppd3rdOfc3;
		this.ppdPayrCustSeq = ppdPayrCustSeq;
		this.cct3rdOfc3 = cct3rdOfc3;
		this.porCd = porCd;
		this.ppdPayrCntCd = ppdPayrCntCd;
		this.cct3rdCust1 = cct3rdCust1;
		this.cct3rdCust2 = cct3rdCust2;
		this.bkgStsCd = bkgStsCd;
		this.cct3rdCust3 = cct3rdCust3;
		this.polVvd = polVvd;
		this.cltPayrCustSeq = cltPayrCustSeq;
		this.cltPayrCntCd = cltPayrCntCd;
		this.timestamp = timestamp;
		this.rfaNo = rfaNo;
		this.trunkVslCd = trunkVslCd;
		this.bkgFeuQty = bkgFeuQty;
		this.ibflag = ibflag;
		this.podVvd = podVvd;
		this.cgoMeasQty = cgoMeasQty;
		this.bkgCorrDt = bkgCorrDt;
		this.whfMrnNo = whfMrnNo;
		this.invRefNo = invRefNo;
		this.corrNo = corrNo;
		this.bkgRefNo = bkgRefNo;
		this.slanCd = slanCd;
		this.whfDlcDt = whfDlcDt;
		this.cancelMk = cancelMk;
		this.actShpr = actShpr;
		this.frtFwrdCntCd = frtFwrdCntCd;
		this.cctOfc = cctOfc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("whf_dlc_ofc_cd", getWhfDlcOfcCd());
		this.hashColumns.put("trunk_skd_voy_no", getTrunkSkdVoyNo());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cct_3rd_cnt3", getCct3rdCnt3());
		this.hashColumns.put("cct_3rd_cnt2", getCct3rdCnt2());
		this.hashColumns.put("cct_3rd_cnt1", getCct3rdCnt1());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ppd_3rd_cust1", getPpd3rdCust1());
		this.hashColumns.put("trunk_skd_dir_cd", getTrunkSkdDirCd());
		this.hashColumns.put("ppd_3rd_cust2", getPpd3rdCust2());
		this.hashColumns.put("ppd_3rd_cust3", getPpd3rdCust3());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("auto_rating_division", getAutoRatingDivision());
		this.hashColumns.put("ppd_3rd_cnt1", getPpd3rdCnt1());
		this.hashColumns.put("dest_trns_svc_mod_cd", getDestTrnsSvcModCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ppd_3rd_cnt2", getPpd3rdCnt2());
		this.hashColumns.put("whf_vvd", getWhfVvd());
		this.hashColumns.put("ppd_3rd_cnt3", getPpd3rdCnt3());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("mst_bl_no", getMstBlNo());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("booking_ser", getBookingSer());
		this.hashColumns.put("fin_dir_cd", getFinDirCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("whf_ntc_no", getWhfNtcNo());
		this.hashColumns.put("frt_fwrd_cust_seq", getFrtFwrdCustSeq());
		this.hashColumns.put("whf_dlc_no", getWhfDlcNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cct_3rd_ofc2", getCct3rdOfc2());
		this.hashColumns.put("ca_rsn", getCaRsn());
		this.hashColumns.put("cct_3rd_ofc1", getCct3rdOfc1());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("si_ref_no", getSiRefNo());
		this.hashColumns.put("ppd_3rd_ofc2", getPpd3rdOfc2());
		this.hashColumns.put("ppd_3rd_ofc1", getPpd3rdOfc1());
		this.hashColumns.put("ppd_ofc", getPpdOfc());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("ppd_3rd_ofc3", getPpd3rdOfc3());
		this.hashColumns.put("ppd_payr_cust_seq", getPpdPayrCustSeq());
		this.hashColumns.put("cct_3rd_ofc3", getCct3rdOfc3());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("ppd_payr_cnt_cd", getPpdPayrCntCd());
		this.hashColumns.put("cct_3rd_cust1", getCct3rdCust1());
		this.hashColumns.put("cct_3rd_cust2", getCct3rdCust2());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("cct_3rd_cust3", getCct3rdCust3());
		this.hashColumns.put("pol_vvd", getPolVvd());
		this.hashColumns.put("clt_payr_cust_seq", getCltPayrCustSeq());
		this.hashColumns.put("clt_payr_cnt_cd", getCltPayrCntCd());
		this.hashColumns.put("timestamp", getTimestamp());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("trunk_vsl_cd", getTrunkVslCd());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_vvd", getPodVvd());
		this.hashColumns.put("cgo_meas_qty", getCgoMeasQty());
		this.hashColumns.put("bkg_corr_dt", getBkgCorrDt());
		this.hashColumns.put("whf_mrn_no", getWhfMrnNo());
		this.hashColumns.put("inv_ref_no", getInvRefNo());
		this.hashColumns.put("corr_no", getCorrNo());
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("whf_dlc_dt", getWhfDlcDt());
		this.hashColumns.put("cancel_mk", getCancelMk());
		this.hashColumns.put("act_shpr", getActShpr());
		this.hashColumns.put("frt_fwrd_cnt_cd", getFrtFwrdCntCd());
		this.hashColumns.put("cct_ofc", getCctOfc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("whf_dlc_ofc_cd", "whfDlcOfcCd");
		this.hashFields.put("trunk_skd_voy_no", "trunkSkdVoyNo");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cct_3rd_cnt3", "cct3rdCnt3");
		this.hashFields.put("cct_3rd_cnt2", "cct3rdCnt2");
		this.hashFields.put("cct_3rd_cnt1", "cct3rdCnt1");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ppd_3rd_cust1", "ppd3rdCust1");
		this.hashFields.put("trunk_skd_dir_cd", "trunkSkdDirCd");
		this.hashFields.put("ppd_3rd_cust2", "ppd3rdCust2");
		this.hashFields.put("ppd_3rd_cust3", "ppd3rdCust3");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("auto_rating_division", "autoRatingDivision");
		this.hashFields.put("ppd_3rd_cnt1", "ppd3rdCnt1");
		this.hashFields.put("dest_trns_svc_mod_cd", "destTrnsSvcModCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ppd_3rd_cnt2", "ppd3rdCnt2");
		this.hashFields.put("whf_vvd", "whfVvd");
		this.hashFields.put("ppd_3rd_cnt3", "ppd3rdCnt3");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("mst_bl_no", "mstBlNo");
		this.hashFields.put("cgo_wgt", "cgoWgt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("booking_ser", "bookingSer");
		this.hashFields.put("fin_dir_cd", "finDirCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("whf_ntc_no", "whfNtcNo");
		this.hashFields.put("frt_fwrd_cust_seq", "frtFwrdCustSeq");
		this.hashFields.put("whf_dlc_no", "whfDlcNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cct_3rd_ofc2", "cct3rdOfc2");
		this.hashFields.put("ca_rsn", "caRsn");
		this.hashFields.put("cct_3rd_ofc1", "cct3rdOfc1");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("si_ref_no", "siRefNo");
		this.hashFields.put("ppd_3rd_ofc2", "ppd3rdOfc2");
		this.hashFields.put("ppd_3rd_ofc1", "ppd3rdOfc1");
		this.hashFields.put("ppd_ofc", "ppdOfc");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("ppd_3rd_ofc3", "ppd3rdOfc3");
		this.hashFields.put("ppd_payr_cust_seq", "ppdPayrCustSeq");
		this.hashFields.put("cct_3rd_ofc3", "cct3rdOfc3");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("ppd_payr_cnt_cd", "ppdPayrCntCd");
		this.hashFields.put("cct_3rd_cust1", "cct3rdCust1");
		this.hashFields.put("cct_3rd_cust2", "cct3rdCust2");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("cct_3rd_cust3", "cct3rdCust3");
		this.hashFields.put("pol_vvd", "polVvd");
		this.hashFields.put("clt_payr_cust_seq", "cltPayrCustSeq");
		this.hashFields.put("clt_payr_cnt_cd", "cltPayrCntCd");
		this.hashFields.put("timestamp", "timestamp");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("trunk_vsl_cd", "trunkVslCd");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_vvd", "podVvd");
		this.hashFields.put("cgo_meas_qty", "cgoMeasQty");
		this.hashFields.put("bkg_corr_dt", "bkgCorrDt");
		this.hashFields.put("whf_mrn_no", "whfMrnNo");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("corr_no", "corrNo");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("whf_dlc_dt", "whfDlcDt");
		this.hashFields.put("cancel_mk", "cancelMk");
		this.hashFields.put("act_shpr", "actShpr");
		this.hashFields.put("frt_fwrd_cnt_cd", "frtFwrdCntCd");
		this.hashFields.put("cct_ofc", "cctOfc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return whfDlcOfcCd
	 */
	public String getWhfDlcOfcCd() {
		return this.whfDlcOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trunkSkdVoyNo
	 */
	public String getTrunkSkdVoyNo() {
		return this.trunkSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return cct3rdCnt3
	 */
	public String getCct3rdCnt3() {
		return this.cct3rdCnt3;
	}
	
	/**
	 * Column Info
	 * @return cct3rdCnt2
	 */
	public String getCct3rdCnt2() {
		return this.cct3rdCnt2;
	}
	
	/**
	 * Column Info
	 * @return cct3rdCnt1
	 */
	public String getCct3rdCnt1() {
		return this.cct3rdCnt1;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return ppd3rdCust1
	 */
	public String getPpd3rdCust1() {
		return this.ppd3rdCust1;
	}
	
	/**
	 * Column Info
	 * @return trunkSkdDirCd
	 */
	public String getTrunkSkdDirCd() {
		return this.trunkSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return ppd3rdCust2
	 */
	public String getPpd3rdCust2() {
		return this.ppd3rdCust2;
	}
	
	/**
	 * Column Info
	 * @return ppd3rdCust3
	 */
	public String getPpd3rdCust3() {
		return this.ppd3rdCust3;
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
	 * @return autoRatingDivision
	 */
	public String getAutoRatingDivision() {
		return this.autoRatingDivision;
	}
	
	/**
	 * Column Info
	 * @return ppd3rdCnt1
	 */
	public String getPpd3rdCnt1() {
		return this.ppd3rdCnt1;
	}
	
	/**
	 * Column Info
	 * @return destTrnsSvcModCd
	 */
	public String getDestTrnsSvcModCd() {
		return this.destTrnsSvcModCd;
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
	 * @return ppd3rdCnt2
	 */
	public String getPpd3rdCnt2() {
		return this.ppd3rdCnt2;
	}
	
	/**
	 * Column Info
	 * @return whfVvd
	 */
	public String getWhfVvd() {
		return this.whfVvd;
	}
	
	/**
	 * Column Info
	 * @return ppd3rdCnt3
	 */
	public String getPpd3rdCnt3() {
		return this.ppd3rdCnt3;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return mstBlNo
	 */
	public String getMstBlNo() {
		return this.mstBlNo;
	}
	
	/**
	 * Column Info
	 * @return cgoWgt
	 */
	public String getCgoWgt() {
		return this.cgoWgt;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return bookingSer
	 */
	public String getBookingSer() {
		return this.bookingSer;
	}
	
	/**
	 * Column Info
	 * @return finDirCd
	 */
	public String getFinDirCd() {
		return this.finDirCd;
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
	 * @return whfNtcNo
	 */
	public String getWhfNtcNo() {
		return this.whfNtcNo;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdCustSeq
	 */
	public String getFrtFwrdCustSeq() {
		return this.frtFwrdCustSeq;
	}
	
	/**
	 * Column Info
	 * @return whfDlcNo
	 */
	public String getWhfDlcNo() {
		return this.whfDlcNo;
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
	 * @return cct3rdOfc2
	 */
	public String getCct3rdOfc2() {
		return this.cct3rdOfc2;
	}
	
	/**
	 * Column Info
	 * @return caRsn
	 */
	public String getCaRsn() {
		return this.caRsn;
	}
	
	/**
	 * Column Info
	 * @return cct3rdOfc1
	 */
	public String getCct3rdOfc1() {
		return this.cct3rdOfc1;
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
	 * @return siRefNo
	 */
	public String getSiRefNo() {
		return this.siRefNo;
	}
	
	/**
	 * Column Info
	 * @return ppd3rdOfc2
	 */
	public String getPpd3rdOfc2() {
		return this.ppd3rdOfc2;
	}
	
	/**
	 * Column Info
	 * @return ppd3rdOfc1
	 */
	public String getPpd3rdOfc1() {
		return this.ppd3rdOfc1;
	}
	
	/**
	 * Column Info
	 * @return ppdOfc
	 */
	public String getPpdOfc() {
		return this.ppdOfc;
	}
	
	/**
	 * Column Info
	 * @return bkgTeuQty
	 */
	public String getBkgTeuQty() {
		return this.bkgTeuQty;
	}
	
	/**
	 * Column Info
	 * @return ppd3rdOfc3
	 */
	public String getPpd3rdOfc3() {
		return this.ppd3rdOfc3;
	}
	
	/**
	 * Column Info
	 * @return ppdPayrCustSeq
	 */
	public String getPpdPayrCustSeq() {
		return this.ppdPayrCustSeq;
	}
	
	/**
	 * Column Info
	 * @return cct3rdOfc3
	 */
	public String getCct3rdOfc3() {
		return this.cct3rdOfc3;
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
	 * @return ppdPayrCntCd
	 */
	public String getPpdPayrCntCd() {
		return this.ppdPayrCntCd;
	}
	
	/**
	 * Column Info
	 * @return cct3rdCust1
	 */
	public String getCct3rdCust1() {
		return this.cct3rdCust1;
	}
	
	/**
	 * Column Info
	 * @return cct3rdCust2
	 */
	public String getCct3rdCust2() {
		return this.cct3rdCust2;
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
	 * @return cct3rdCust3
	 */
	public String getCct3rdCust3() {
		return this.cct3rdCust3;
	}
	
	/**
	 * Column Info
	 * @return polVvd
	 */
	public String getPolVvd() {
		return this.polVvd;
	}
	
	/**
	 * Column Info
	 * @return cltPayrCustSeq
	 */
	public String getCltPayrCustSeq() {
		return this.cltPayrCustSeq;
	}
	
	/**
	 * Column Info
	 * @return cltPayrCntCd
	 */
	public String getCltPayrCntCd() {
		return this.cltPayrCntCd;
	}
	
	/**
	 * Column Info
	 * @return timestamp
	 */
	public String getTimestamp() {
		return this.timestamp;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return trunkVslCd
	 */
	public String getTrunkVslCd() {
		return this.trunkVslCd;
	}
	
	/**
	 * Column Info
	 * @return bkgFeuQty
	 */
	public String getBkgFeuQty() {
		return this.bkgFeuQty;
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
	 * @return podVvd
	 */
	public String getPodVvd() {
		return this.podVvd;
	}
	
	/**
	 * Column Info
	 * @return cgoMeasQty
	 */
	public String getCgoMeasQty() {
		return this.cgoMeasQty;
	}
	
	/**
	 * Column Info
	 * @return bkgCorrDt
	 */
	public String getBkgCorrDt() {
		return this.bkgCorrDt;
	}
	
	/**
	 * Column Info
	 * @return whfMrnNo
	 */
	public String getWhfMrnNo() {
		return this.whfMrnNo;
	}
	
	/**
	 * Column Info
	 * @return invRefNo
	 */
	public String getInvRefNo() {
		return this.invRefNo;
	}
	
	/**
	 * Column Info
	 * @return corrNo
	 */
	public String getCorrNo() {
		return this.corrNo;
	}
	
	/**
	 * Column Info
	 * @return bkgRefNo
	 */
	public String getBkgRefNo() {
		return this.bkgRefNo;
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
	 * @return whfDlcDt
	 */
	public String getWhfDlcDt() {
		return this.whfDlcDt;
	}
	
	/**
	 * Column Info
	 * @return cancelMk
	 */
	public String getCancelMk() {
		return this.cancelMk;
	}
	
	/**
	 * Column Info
	 * @return actShpr
	 */
	public String getActShpr() {
		return this.actShpr;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdCntCd
	 */
	public String getFrtFwrdCntCd() {
		return this.frtFwrdCntCd;
	}
	
	/**
	 * Column Info
	 * @return cctOfc
	 */
	public String getCctOfc() {
		return this.cctOfc;
	}
	

	/**
	 * Column Info
	 * @param whfDlcOfcCd
	 */
	public void setWhfDlcOfcCd(String whfDlcOfcCd) {
		this.whfDlcOfcCd = whfDlcOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trunkSkdVoyNo
	 */
	public void setTrunkSkdVoyNo(String trunkSkdVoyNo) {
		this.trunkSkdVoyNo = trunkSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param cct3rdCnt3
	 */
	public void setCct3rdCnt3(String cct3rdCnt3) {
		this.cct3rdCnt3 = cct3rdCnt3;
	}
	
	/**
	 * Column Info
	 * @param cct3rdCnt2
	 */
	public void setCct3rdCnt2(String cct3rdCnt2) {
		this.cct3rdCnt2 = cct3rdCnt2;
	}
	
	/**
	 * Column Info
	 * @param cct3rdCnt1
	 */
	public void setCct3rdCnt1(String cct3rdCnt1) {
		this.cct3rdCnt1 = cct3rdCnt1;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param ppd3rdCust1
	 */
	public void setPpd3rdCust1(String ppd3rdCust1) {
		this.ppd3rdCust1 = ppd3rdCust1;
	}
	
	/**
	 * Column Info
	 * @param trunkSkdDirCd
	 */
	public void setTrunkSkdDirCd(String trunkSkdDirCd) {
		this.trunkSkdDirCd = trunkSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param ppd3rdCust2
	 */
	public void setPpd3rdCust2(String ppd3rdCust2) {
		this.ppd3rdCust2 = ppd3rdCust2;
	}
	
	/**
	 * Column Info
	 * @param ppd3rdCust3
	 */
	public void setPpd3rdCust3(String ppd3rdCust3) {
		this.ppd3rdCust3 = ppd3rdCust3;
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
	 * @param autoRatingDivision
	 */
	public void setAutoRatingDivision(String autoRatingDivision) {
		this.autoRatingDivision = autoRatingDivision;
	}
	
	/**
	 * Column Info
	 * @param ppd3rdCnt1
	 */
	public void setPpd3rdCnt1(String ppd3rdCnt1) {
		this.ppd3rdCnt1 = ppd3rdCnt1;
	}
	
	/**
	 * Column Info
	 * @param destTrnsSvcModCd
	 */
	public void setDestTrnsSvcModCd(String destTrnsSvcModCd) {
		this.destTrnsSvcModCd = destTrnsSvcModCd;
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
	 * @param ppd3rdCnt2
	 */
	public void setPpd3rdCnt2(String ppd3rdCnt2) {
		this.ppd3rdCnt2 = ppd3rdCnt2;
	}
	
	/**
	 * Column Info
	 * @param whfVvd
	 */
	public void setWhfVvd(String whfVvd) {
		this.whfVvd = whfVvd;
	}
	
	/**
	 * Column Info
	 * @param ppd3rdCnt3
	 */
	public void setPpd3rdCnt3(String ppd3rdCnt3) {
		this.ppd3rdCnt3 = ppd3rdCnt3;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param mstBlNo
	 */
	public void setMstBlNo(String mstBlNo) {
		this.mstBlNo = mstBlNo;
	}
	
	/**
	 * Column Info
	 * @param cgoWgt
	 */
	public void setCgoWgt(String cgoWgt) {
		this.cgoWgt = cgoWgt;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param bookingSer
	 */
	public void setBookingSer(String bookingSer) {
		this.bookingSer = bookingSer;
	}
	
	/**
	 * Column Info
	 * @param finDirCd
	 */
	public void setFinDirCd(String finDirCd) {
		this.finDirCd = finDirCd;
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
	 * @param whfNtcNo
	 */
	public void setWhfNtcNo(String whfNtcNo) {
		this.whfNtcNo = whfNtcNo;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdCustSeq
	 */
	public void setFrtFwrdCustSeq(String frtFwrdCustSeq) {
		this.frtFwrdCustSeq = frtFwrdCustSeq;
	}
	
	/**
	 * Column Info
	 * @param whfDlcNo
	 */
	public void setWhfDlcNo(String whfDlcNo) {
		this.whfDlcNo = whfDlcNo;
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
	 * @param cct3rdOfc2
	 */
	public void setCct3rdOfc2(String cct3rdOfc2) {
		this.cct3rdOfc2 = cct3rdOfc2;
	}
	
	/**
	 * Column Info
	 * @param caRsn
	 */
	public void setCaRsn(String caRsn) {
		this.caRsn = caRsn;
	}
	
	/**
	 * Column Info
	 * @param cct3rdOfc1
	 */
	public void setCct3rdOfc1(String cct3rdOfc1) {
		this.cct3rdOfc1 = cct3rdOfc1;
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
	 * @param siRefNo
	 */
	public void setSiRefNo(String siRefNo) {
		this.siRefNo = siRefNo;
	}
	
	/**
	 * Column Info
	 * @param ppd3rdOfc2
	 */
	public void setPpd3rdOfc2(String ppd3rdOfc2) {
		this.ppd3rdOfc2 = ppd3rdOfc2;
	}
	
	/**
	 * Column Info
	 * @param ppd3rdOfc1
	 */
	public void setPpd3rdOfc1(String ppd3rdOfc1) {
		this.ppd3rdOfc1 = ppd3rdOfc1;
	}
	
	/**
	 * Column Info
	 * @param ppdOfc
	 */
	public void setPpdOfc(String ppdOfc) {
		this.ppdOfc = ppdOfc;
	}
	
	/**
	 * Column Info
	 * @param bkgTeuQty
	 */
	public void setBkgTeuQty(String bkgTeuQty) {
		this.bkgTeuQty = bkgTeuQty;
	}
	
	/**
	 * Column Info
	 * @param ppd3rdOfc3
	 */
	public void setPpd3rdOfc3(String ppd3rdOfc3) {
		this.ppd3rdOfc3 = ppd3rdOfc3;
	}
	
	/**
	 * Column Info
	 * @param ppdPayrCustSeq
	 */
	public void setPpdPayrCustSeq(String ppdPayrCustSeq) {
		this.ppdPayrCustSeq = ppdPayrCustSeq;
	}
	
	/**
	 * Column Info
	 * @param cct3rdOfc3
	 */
	public void setCct3rdOfc3(String cct3rdOfc3) {
		this.cct3rdOfc3 = cct3rdOfc3;
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
	 * @param ppdPayrCntCd
	 */
	public void setPpdPayrCntCd(String ppdPayrCntCd) {
		this.ppdPayrCntCd = ppdPayrCntCd;
	}
	
	/**
	 * Column Info
	 * @param cct3rdCust1
	 */
	public void setCct3rdCust1(String cct3rdCust1) {
		this.cct3rdCust1 = cct3rdCust1;
	}
	
	/**
	 * Column Info
	 * @param cct3rdCust2
	 */
	public void setCct3rdCust2(String cct3rdCust2) {
		this.cct3rdCust2 = cct3rdCust2;
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
	 * @param cct3rdCust3
	 */
	public void setCct3rdCust3(String cct3rdCust3) {
		this.cct3rdCust3 = cct3rdCust3;
	}
	
	/**
	 * Column Info
	 * @param polVvd
	 */
	public void setPolVvd(String polVvd) {
		this.polVvd = polVvd;
	}
	
	/**
	 * Column Info
	 * @param cltPayrCustSeq
	 */
	public void setCltPayrCustSeq(String cltPayrCustSeq) {
		this.cltPayrCustSeq = cltPayrCustSeq;
	}
	
	/**
	 * Column Info
	 * @param cltPayrCntCd
	 */
	public void setCltPayrCntCd(String cltPayrCntCd) {
		this.cltPayrCntCd = cltPayrCntCd;
	}
	
	/**
	 * Column Info
	 * @param timestamp
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param trunkVslCd
	 */
	public void setTrunkVslCd(String trunkVslCd) {
		this.trunkVslCd = trunkVslCd;
	}
	
	/**
	 * Column Info
	 * @param bkgFeuQty
	 */
	public void setBkgFeuQty(String bkgFeuQty) {
		this.bkgFeuQty = bkgFeuQty;
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
	 * @param podVvd
	 */
	public void setPodVvd(String podVvd) {
		this.podVvd = podVvd;
	}
	
	/**
	 * Column Info
	 * @param cgoMeasQty
	 */
	public void setCgoMeasQty(String cgoMeasQty) {
		this.cgoMeasQty = cgoMeasQty;
	}
	
	/**
	 * Column Info
	 * @param bkgCorrDt
	 */
	public void setBkgCorrDt(String bkgCorrDt) {
		this.bkgCorrDt = bkgCorrDt;
	}
	
	/**
	 * Column Info
	 * @param whfMrnNo
	 */
	public void setWhfMrnNo(String whfMrnNo) {
		this.whfMrnNo = whfMrnNo;
	}
	
	/**
	 * Column Info
	 * @param invRefNo
	 */
	public void setInvRefNo(String invRefNo) {
		this.invRefNo = invRefNo;
	}
	
	/**
	 * Column Info
	 * @param corrNo
	 */
	public void setCorrNo(String corrNo) {
		this.corrNo = corrNo;
	}
	
	/**
	 * Column Info
	 * @param bkgRefNo
	 */
	public void setBkgRefNo(String bkgRefNo) {
		this.bkgRefNo = bkgRefNo;
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
	 * @param whfDlcDt
	 */
	public void setWhfDlcDt(String whfDlcDt) {
		this.whfDlcDt = whfDlcDt;
	}
	
	/**
	 * Column Info
	 * @param cancelMk
	 */
	public void setCancelMk(String cancelMk) {
		this.cancelMk = cancelMk;
	}
	
	/**
	 * Column Info
	 * @param actShpr
	 */
	public void setActShpr(String actShpr) {
		this.actShpr = actShpr;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdCntCd
	 */
	public void setFrtFwrdCntCd(String frtFwrdCntCd) {
		this.frtFwrdCntCd = frtFwrdCntCd;
	}
	
	/**
	 * Column Info
	 * @param cctOfc
	 */
	public void setCctOfc(String cctOfc) {
		this.cctOfc = cctOfc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setWhfDlcOfcCd(JSPUtil.getParameter(request, "whf_dlc_ofc_cd", ""));
		setTrunkSkdVoyNo(JSPUtil.getParameter(request, "trunk_skd_voy_no", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCct3rdCnt3(JSPUtil.getParameter(request, "cct_3rd_cnt3", ""));
		setCct3rdCnt2(JSPUtil.getParameter(request, "cct_3rd_cnt2", ""));
		setCct3rdCnt1(JSPUtil.getParameter(request, "cct_3rd_cnt1", ""));
		setSrepCd(JSPUtil.getParameter(request, "srep_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPpd3rdCust1(JSPUtil.getParameter(request, "ppd_3rd_cust1", ""));
		setTrunkSkdDirCd(JSPUtil.getParameter(request, "trunk_skd_dir_cd", ""));
		setPpd3rdCust2(JSPUtil.getParameter(request, "ppd_3rd_cust2", ""));
		setPpd3rdCust3(JSPUtil.getParameter(request, "ppd_3rd_cust3", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAutoRatingDivision(JSPUtil.getParameter(request, "auto_rating_division", ""));
		setPpd3rdCnt1(JSPUtil.getParameter(request, "ppd_3rd_cnt1", ""));
		setDestTrnsSvcModCd(JSPUtil.getParameter(request, "dest_trns_svc_mod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPpd3rdCnt2(JSPUtil.getParameter(request, "ppd_3rd_cnt2", ""));
		setWhfVvd(JSPUtil.getParameter(request, "whf_vvd", ""));
		setPpd3rdCnt3(JSPUtil.getParameter(request, "ppd_3rd_cnt3", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setMstBlNo(JSPUtil.getParameter(request, "mst_bl_no", ""));
		setCgoWgt(JSPUtil.getParameter(request, "cgo_wgt", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setBookingSer(JSPUtil.getParameter(request, "booking_ser", ""));
		setFinDirCd(JSPUtil.getParameter(request, "fin_dir_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setWhfNtcNo(JSPUtil.getParameter(request, "whf_ntc_no", ""));
		setFrtFwrdCustSeq(JSPUtil.getParameter(request, "frt_fwrd_cust_seq", ""));
		setWhfDlcNo(JSPUtil.getParameter(request, "whf_dlc_no", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCct3rdOfc2(JSPUtil.getParameter(request, "cct_3rd_ofc2", ""));
		setCaRsn(JSPUtil.getParameter(request, "ca_rsn", ""));
		setCct3rdOfc1(JSPUtil.getParameter(request, "cct_3rd_ofc1", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSiRefNo(JSPUtil.getParameter(request, "si_ref_no", ""));
		setPpd3rdOfc2(JSPUtil.getParameter(request, "ppd_3rd_ofc2", ""));
		setPpd3rdOfc1(JSPUtil.getParameter(request, "ppd_3rd_ofc1", ""));
		setPpdOfc(JSPUtil.getParameter(request, "ppd_ofc", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, "bkg_teu_qty", ""));
		setPpd3rdOfc3(JSPUtil.getParameter(request, "ppd_3rd_ofc3", ""));
		setPpdPayrCustSeq(JSPUtil.getParameter(request, "ppd_payr_cust_seq", ""));
		setCct3rdOfc3(JSPUtil.getParameter(request, "cct_3rd_ofc3", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setPpdPayrCntCd(JSPUtil.getParameter(request, "ppd_payr_cnt_cd", ""));
		setCct3rdCust1(JSPUtil.getParameter(request, "cct_3rd_cust1", ""));
		setCct3rdCust2(JSPUtil.getParameter(request, "cct_3rd_cust2", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setCct3rdCust3(JSPUtil.getParameter(request, "cct_3rd_cust3", ""));
		setPolVvd(JSPUtil.getParameter(request, "pol_vvd", ""));
		setCltPayrCustSeq(JSPUtil.getParameter(request, "clt_payr_cust_seq", ""));
		setCltPayrCntCd(JSPUtil.getParameter(request, "clt_payr_cnt_cd", ""));
		setTimestamp(JSPUtil.getParameter(request, "timestamp", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setTrunkVslCd(JSPUtil.getParameter(request, "trunk_vsl_cd", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, "bkg_feu_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPodVvd(JSPUtil.getParameter(request, "pod_vvd", ""));
		setCgoMeasQty(JSPUtil.getParameter(request, "cgo_meas_qty", ""));
		setBkgCorrDt(JSPUtil.getParameter(request, "bkg_corr_dt", ""));
		setWhfMrnNo(JSPUtil.getParameter(request, "whf_mrn_no", ""));
		setInvRefNo(JSPUtil.getParameter(request, "inv_ref_no", ""));
		setCorrNo(JSPUtil.getParameter(request, "corr_no", ""));
		setBkgRefNo(JSPUtil.getParameter(request, "bkg_ref_no", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setWhfDlcDt(JSPUtil.getParameter(request, "whf_dlc_dt", ""));
		setCancelMk(JSPUtil.getParameter(request, "cancel_mk", ""));
		setActShpr(JSPUtil.getParameter(request, "act_shpr", ""));
		setFrtFwrdCntCd(JSPUtil.getParameter(request, "frt_fwrd_cnt_cd", ""));
		setCctOfc(JSPUtil.getParameter(request, "cct_ofc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBkgInfoForINV_HdVO[]
	 */
	public SearchBkgInfoForINV_HdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBkgInfoForINV_HdVO[]
	 */
	public SearchBkgInfoForINV_HdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBkgInfoForINV_HdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] whfDlcOfcCd = (JSPUtil.getParameter(request, prefix	+ "whf_dlc_ofc_cd", length));
			String[] trunkSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "trunk_skd_voy_no", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] cct3rdCnt3 = (JSPUtil.getParameter(request, prefix	+ "cct_3rd_cnt3", length));
			String[] cct3rdCnt2 = (JSPUtil.getParameter(request, prefix	+ "cct_3rd_cnt2", length));
			String[] cct3rdCnt1 = (JSPUtil.getParameter(request, prefix	+ "cct_3rd_cnt1", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ppd3rdCust1 = (JSPUtil.getParameter(request, prefix	+ "ppd_3rd_cust1", length));
			String[] trunkSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "trunk_skd_dir_cd", length));
			String[] ppd3rdCust2 = (JSPUtil.getParameter(request, prefix	+ "ppd_3rd_cust2", length));
			String[] ppd3rdCust3 = (JSPUtil.getParameter(request, prefix	+ "ppd_3rd_cust3", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] autoRatingDivision = (JSPUtil.getParameter(request, prefix	+ "auto_rating_division", length));
			String[] ppd3rdCnt1 = (JSPUtil.getParameter(request, prefix	+ "ppd_3rd_cnt1", length));
			String[] destTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_svc_mod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ppd3rdCnt2 = (JSPUtil.getParameter(request, prefix	+ "ppd_3rd_cnt2", length));
			String[] whfVvd = (JSPUtil.getParameter(request, prefix	+ "whf_vvd", length));
			String[] ppd3rdCnt3 = (JSPUtil.getParameter(request, prefix	+ "ppd_3rd_cnt3", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] mstBlNo = (JSPUtil.getParameter(request, prefix	+ "mst_bl_no", length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] bookingSer = (JSPUtil.getParameter(request, prefix	+ "booking_ser", length));
			String[] finDirCd = (JSPUtil.getParameter(request, prefix	+ "fin_dir_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] whfNtcNo = (JSPUtil.getParameter(request, prefix	+ "whf_ntc_no", length));
			String[] frtFwrdCustSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cust_seq", length));
			String[] whfDlcNo = (JSPUtil.getParameter(request, prefix	+ "whf_dlc_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cct3rdOfc2 = (JSPUtil.getParameter(request, prefix	+ "cct_3rd_ofc2", length));
			String[] caRsn = (JSPUtil.getParameter(request, prefix	+ "ca_rsn", length));
			String[] cct3rdOfc1 = (JSPUtil.getParameter(request, prefix	+ "cct_3rd_ofc1", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] siRefNo = (JSPUtil.getParameter(request, prefix	+ "si_ref_no", length));
			String[] ppd3rdOfc2 = (JSPUtil.getParameter(request, prefix	+ "ppd_3rd_ofc2", length));
			String[] ppd3rdOfc1 = (JSPUtil.getParameter(request, prefix	+ "ppd_3rd_ofc1", length));
			String[] ppdOfc = (JSPUtil.getParameter(request, prefix	+ "ppd_ofc", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] ppd3rdOfc3 = (JSPUtil.getParameter(request, prefix	+ "ppd_3rd_ofc3", length));
			String[] ppdPayrCustSeq = (JSPUtil.getParameter(request, prefix	+ "ppd_payr_cust_seq", length));
			String[] cct3rdOfc3 = (JSPUtil.getParameter(request, prefix	+ "cct_3rd_ofc3", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] ppdPayrCntCd = (JSPUtil.getParameter(request, prefix	+ "ppd_payr_cnt_cd", length));
			String[] cct3rdCust1 = (JSPUtil.getParameter(request, prefix	+ "cct_3rd_cust1", length));
			String[] cct3rdCust2 = (JSPUtil.getParameter(request, prefix	+ "cct_3rd_cust2", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] cct3rdCust3 = (JSPUtil.getParameter(request, prefix	+ "cct_3rd_cust3", length));
			String[] polVvd = (JSPUtil.getParameter(request, prefix	+ "pol_vvd", length));
			String[] cltPayrCustSeq = (JSPUtil.getParameter(request, prefix	+ "clt_payr_cust_seq", length));
			String[] cltPayrCntCd = (JSPUtil.getParameter(request, prefix	+ "clt_payr_cnt_cd", length));
			String[] timestamp = (JSPUtil.getParameter(request, prefix	+ "timestamp", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] trunkVslCd = (JSPUtil.getParameter(request, prefix	+ "trunk_vsl_cd", length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podVvd = (JSPUtil.getParameter(request, prefix	+ "pod_vvd", length));
			String[] cgoMeasQty = (JSPUtil.getParameter(request, prefix	+ "cgo_meas_qty", length));
			String[] bkgCorrDt = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_dt", length));
			String[] whfMrnNo = (JSPUtil.getParameter(request, prefix	+ "whf_mrn_no", length));
			String[] invRefNo = (JSPUtil.getParameter(request, prefix	+ "inv_ref_no", length));
			String[] corrNo = (JSPUtil.getParameter(request, prefix	+ "corr_no", length));
			String[] bkgRefNo = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] whfDlcDt = (JSPUtil.getParameter(request, prefix	+ "whf_dlc_dt", length));
			String[] cancelMk = (JSPUtil.getParameter(request, prefix	+ "cancel_mk", length));
			String[] actShpr = (JSPUtil.getParameter(request, prefix	+ "act_shpr", length));
			String[] frtFwrdCntCd = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_cd", length));
			String[] cctOfc = (JSPUtil.getParameter(request, prefix	+ "cct_ofc", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBkgInfoForINV_HdVO();
				if (whfDlcOfcCd[i] != null)
					model.setWhfDlcOfcCd(whfDlcOfcCd[i]);
				if (trunkSkdVoyNo[i] != null)
					model.setTrunkSkdVoyNo(trunkSkdVoyNo[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (cct3rdCnt3[i] != null)
					model.setCct3rdCnt3(cct3rdCnt3[i]);
				if (cct3rdCnt2[i] != null)
					model.setCct3rdCnt2(cct3rdCnt2[i]);
				if (cct3rdCnt1[i] != null)
					model.setCct3rdCnt1(cct3rdCnt1[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ppd3rdCust1[i] != null)
					model.setPpd3rdCust1(ppd3rdCust1[i]);
				if (trunkSkdDirCd[i] != null)
					model.setTrunkSkdDirCd(trunkSkdDirCd[i]);
				if (ppd3rdCust2[i] != null)
					model.setPpd3rdCust2(ppd3rdCust2[i]);
				if (ppd3rdCust3[i] != null)
					model.setPpd3rdCust3(ppd3rdCust3[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (autoRatingDivision[i] != null)
					model.setAutoRatingDivision(autoRatingDivision[i]);
				if (ppd3rdCnt1[i] != null)
					model.setPpd3rdCnt1(ppd3rdCnt1[i]);
				if (destTrnsSvcModCd[i] != null)
					model.setDestTrnsSvcModCd(destTrnsSvcModCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ppd3rdCnt2[i] != null)
					model.setPpd3rdCnt2(ppd3rdCnt2[i]);
				if (whfVvd[i] != null)
					model.setWhfVvd(whfVvd[i]);
				if (ppd3rdCnt3[i] != null)
					model.setPpd3rdCnt3(ppd3rdCnt3[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (mstBlNo[i] != null)
					model.setMstBlNo(mstBlNo[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (bookingSer[i] != null)
					model.setBookingSer(bookingSer[i]);
				if (finDirCd[i] != null)
					model.setFinDirCd(finDirCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (whfNtcNo[i] != null)
					model.setWhfNtcNo(whfNtcNo[i]);
				if (frtFwrdCustSeq[i] != null)
					model.setFrtFwrdCustSeq(frtFwrdCustSeq[i]);
				if (whfDlcNo[i] != null)
					model.setWhfDlcNo(whfDlcNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cct3rdOfc2[i] != null)
					model.setCct3rdOfc2(cct3rdOfc2[i]);
				if (caRsn[i] != null)
					model.setCaRsn(caRsn[i]);
				if (cct3rdOfc1[i] != null)
					model.setCct3rdOfc1(cct3rdOfc1[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (siRefNo[i] != null)
					model.setSiRefNo(siRefNo[i]);
				if (ppd3rdOfc2[i] != null)
					model.setPpd3rdOfc2(ppd3rdOfc2[i]);
				if (ppd3rdOfc1[i] != null)
					model.setPpd3rdOfc1(ppd3rdOfc1[i]);
				if (ppdOfc[i] != null)
					model.setPpdOfc(ppdOfc[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (ppd3rdOfc3[i] != null)
					model.setPpd3rdOfc3(ppd3rdOfc3[i]);
				if (ppdPayrCustSeq[i] != null)
					model.setPpdPayrCustSeq(ppdPayrCustSeq[i]);
				if (cct3rdOfc3[i] != null)
					model.setCct3rdOfc3(cct3rdOfc3[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (ppdPayrCntCd[i] != null)
					model.setPpdPayrCntCd(ppdPayrCntCd[i]);
				if (cct3rdCust1[i] != null)
					model.setCct3rdCust1(cct3rdCust1[i]);
				if (cct3rdCust2[i] != null)
					model.setCct3rdCust2(cct3rdCust2[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (cct3rdCust3[i] != null)
					model.setCct3rdCust3(cct3rdCust3[i]);
				if (polVvd[i] != null)
					model.setPolVvd(polVvd[i]);
				if (cltPayrCustSeq[i] != null)
					model.setCltPayrCustSeq(cltPayrCustSeq[i]);
				if (cltPayrCntCd[i] != null)
					model.setCltPayrCntCd(cltPayrCntCd[i]);
				if (timestamp[i] != null)
					model.setTimestamp(timestamp[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (trunkVslCd[i] != null)
					model.setTrunkVslCd(trunkVslCd[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podVvd[i] != null)
					model.setPodVvd(podVvd[i]);
				if (cgoMeasQty[i] != null)
					model.setCgoMeasQty(cgoMeasQty[i]);
				if (bkgCorrDt[i] != null)
					model.setBkgCorrDt(bkgCorrDt[i]);
				if (whfMrnNo[i] != null)
					model.setWhfMrnNo(whfMrnNo[i]);
				if (invRefNo[i] != null)
					model.setInvRefNo(invRefNo[i]);
				if (corrNo[i] != null)
					model.setCorrNo(corrNo[i]);
				if (bkgRefNo[i] != null)
					model.setBkgRefNo(bkgRefNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (whfDlcDt[i] != null)
					model.setWhfDlcDt(whfDlcDt[i]);
				if (cancelMk[i] != null)
					model.setCancelMk(cancelMk[i]);
				if (actShpr[i] != null)
					model.setActShpr(actShpr[i]);
				if (frtFwrdCntCd[i] != null)
					model.setFrtFwrdCntCd(frtFwrdCntCd[i]);
				if (cctOfc[i] != null)
					model.setCctOfc(cctOfc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBkgInfoForINV_HdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBkgInfoForINV_HdVO[]
	 */
	public SearchBkgInfoForINV_HdVO[] getSearchBkgInfoForINV_HdVOs(){
		SearchBkgInfoForINV_HdVO[] vos = (SearchBkgInfoForINV_HdVO[])models.toArray(new SearchBkgInfoForINV_HdVO[models.size()]);
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
		this.whfDlcOfcCd = this.whfDlcOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkSkdVoyNo = this.trunkSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct3rdCnt3 = this.cct3rdCnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct3rdCnt2 = this.cct3rdCnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct3rdCnt1 = this.cct3rdCnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppd3rdCust1 = this.ppd3rdCust1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkSkdDirCd = this.trunkSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppd3rdCust2 = this.ppd3rdCust2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppd3rdCust3 = this.ppd3rdCust3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatingDivision = this.autoRatingDivision .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppd3rdCnt1 = this.ppd3rdCnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsSvcModCd = this.destTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppd3rdCnt2 = this.ppd3rdCnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfVvd = this.whfVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppd3rdCnt3 = this.ppd3rdCnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBlNo = this.mstBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingSer = this.bookingSer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finDirCd = this.finDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfNtcNo = this.whfNtcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCustSeq = this.frtFwrdCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDlcNo = this.whfDlcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct3rdOfc2 = this.cct3rdOfc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caRsn = this.caRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct3rdOfc1 = this.cct3rdOfc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siRefNo = this.siRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppd3rdOfc2 = this.ppd3rdOfc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppd3rdOfc1 = this.ppd3rdOfc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdOfc = this.ppdOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppd3rdOfc3 = this.ppd3rdOfc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdPayrCustSeq = this.ppdPayrCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct3rdOfc3 = this.cct3rdOfc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdPayrCntCd = this.ppdPayrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct3rdCust1 = this.cct3rdCust1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct3rdCust2 = this.cct3rdCust2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct3rdCust3 = this.cct3rdCust3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polVvd = this.polVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltPayrCustSeq = this.cltPayrCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltPayrCntCd = this.cltPayrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.timestamp = this.timestamp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVslCd = this.trunkVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podVvd = this.podVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoMeasQty = this.cgoMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrDt = this.bkgCorrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfMrnNo = this.whfMrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo = this.invRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrNo = this.corrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo = this.bkgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDlcDt = this.whfDlcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cancelMk = this.cancelMk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShpr = this.actShpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntCd = this.frtFwrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOfc = this.cctOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
