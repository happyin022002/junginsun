/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgListForWorkWithBkgInputVO.java
*@FileTitle : BkgListForWorkWithBkgInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.12.15 이일민 
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.11.09 최도순 [CHM-201006977] Work with Bookings의 조회 옵션에 E/Q Type 추가
* 2016.07.18 조창우 [CHM-201642657] BKG모듈의 Work With Bookings 결과값에 3가지 항목 추가 요청 
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo;

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
 * @author 이일민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgListForWorkWithBkgInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgListForWorkWithBkgInputVO> models = new ArrayList<BkgListForWorkWithBkgInputVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String rfFlg = null;
	/* Column Info */
	private String bkgViaCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgToDt = null;
	/* Column Info */
	private String siViaCd = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String siCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String custRefNo = null;
	/* Column Info */
	private String tsPort = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String bkgStfCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String custRefTpCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String excelFlg = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String dateGbn = null;
	/* Column Info */
	private String hngrFlg = null;
	/* Column Info */
	private String bkgFromDt = null;
	/* Column Info */
	private String dlvCtntCd = null;
	/* Column Info */
	private String scRfaGbn = null;
	
	/* Column Info */
	private String eqTpSzCd = null;
	/* Column Info */
	private String nonRtStsCd = null;
	/* Column Info */
	private String spotGuideFlg = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String rtroKndCd = null;
	/* Column Info */
	private String alocStsCd = null;
	/* Column Info */
	private String extRmk = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String sysSetDt = null;
	/* Column Info */
	private String mnlSetDt = null;
	/* Column Info */
	private String sysSetDtDesc = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgListForWorkWithBkgInputVO() {}

	public BkgListForWorkWithBkgInputVO(String ibflag, String pagerows, String porCd, String rfFlg, String bkgViaCd, String custNm, String rdCgoFlg, String bdrFlg, String bkgStsCd, String srepCd, String polCd, String siViaCd, String bkgToDt, String bbCgoFlg, String slsOfcCd, String dcgoFlg, String bkgCustTpCd, String siCd, String custCntCd, String bkgOfcCd, String custRefNo, String tsPort, String awkCgoFlg, String delCd, String custSeq, String podCd, String vvd, String bkgStfCd, String custRefTpCd, String bkgNo, String scRfaNo, String polYdCd, String dateGbn, String bkgFromDt, String dlvCtntCd, String scRfaGbn, String pageNo, String excelFlg, String podYdCd, String hngrFlg, String eqTpSzCd, String nonRtStsCd, String spotGuideFlg, String vpsEtbDt, String rtroKndCd, String alocStsCd,  String extRmk, String wgt, String wgtUtCd, String sysSetDt, String mnlSetDt, String sysSetDtDesc) {
		this.porCd = porCd;
		this.rfFlg = rfFlg;
		this.bkgViaCd = bkgViaCd;
		this.custNm = custNm;
		this.rdCgoFlg = rdCgoFlg;
		this.bkgStsCd = bkgStsCd;
		this.bdrFlg = bdrFlg;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bkgToDt = bkgToDt;
		this.siViaCd = siViaCd;
		this.bbCgoFlg = bbCgoFlg;
		this.slsOfcCd = slsOfcCd;
		this.dcgoFlg = dcgoFlg;
		this.podYdCd = podYdCd;
		this.bkgCustTpCd = bkgCustTpCd;
		this.siCd = siCd;
		this.custCntCd = custCntCd;
		this.bkgOfcCd = bkgOfcCd;
		this.custRefNo = custRefNo;
		this.tsPort = tsPort;
		this.awkCgoFlg = awkCgoFlg;
		this.delCd = delCd;
		this.custSeq = custSeq;
		this.bkgStfCd = bkgStfCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.custRefTpCd = custRefTpCd;
		this.bkgNo = bkgNo;
		this.scRfaNo = scRfaNo;
		this.excelFlg = excelFlg;
		this.pageNo = pageNo;
		this.polYdCd = polYdCd;
		this.dateGbn = dateGbn;
		this.hngrFlg = hngrFlg;
		this.bkgFromDt = bkgFromDt;
		this.dlvCtntCd = dlvCtntCd;
		this.scRfaGbn = scRfaGbn;
		this.eqTpSzCd = eqTpSzCd;
		this.nonRtStsCd = nonRtStsCd;
		this.spotGuideFlg = spotGuideFlg;
		this.vpsEtbDt = vpsEtbDt;
		this.rtroKndCd = rtroKndCd;
		this.alocStsCd = alocStsCd;
		this.extRmk = extRmk;
		this.wgt = wgt;
		this.wgtUtCd = wgtUtCd;
		this.sysSetDt = sysSetDt;
		this.mnlSetDt = mnlSetDt;
		this.sysSetDtDesc = sysSetDtDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("rf_flg", getRfFlg());
		this.hashColumns.put("bkg_via_cd", getBkgViaCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_to_dt", getBkgToDt());
		this.hashColumns.put("si_via_cd", getSiViaCd());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("si_cd", getSiCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("cust_ref_no", getCustRefNo());
		this.hashColumns.put("ts_port", getTsPort());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bkg_stf_cd", getBkgStfCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cust_ref_tp_cd", getCustRefTpCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("excel_flg", getExcelFlg());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("date_gbn", getDateGbn());
		this.hashColumns.put("hngr_flg", getHngrFlg());
		this.hashColumns.put("bkg_from_dt", getBkgFromDt());
		this.hashColumns.put("dlv_ctnt_cd", getDlvCtntCd());
		this.hashColumns.put("sc_rfa_gbn", getScRfaGbn());
		this.hashColumns.put("eq_tp_sz_cd", getEqTpSzCd());
		this.hashColumns.put("non_rt_sts_cd", getNonRtStsCd());
		this.hashColumns.put("spot_guide_flg", getSpotGuideFlg());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("rtro_knd_cd", getRtroKndCd());
		this.hashColumns.put("aloc_sts_cd", getAlocStsCd());
		this.hashColumns.put("ext_rmk", getExtRmk());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("sys_set_dt", getSysSetDt());
		this.hashColumns.put("mnl_set_dt", getMnlSetDt());
		this.hashColumns.put("sys_set_dt_desc", getsysSetDtDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("rf_flg", "rfFlg");
		this.hashFields.put("bkg_via_cd", "bkgViaCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_to_dt", "bkgToDt");
		this.hashFields.put("si_via_cd", "siViaCd");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("si_cd", "siCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("cust_ref_no", "custRefNo");
		this.hashFields.put("ts_port", "tsPort");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bkg_stf_cd", "bkgStfCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cust_ref_tp_cd", "custRefTpCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("excel_flg", "excelFlg");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("date_gbn", "dateGbn");
		this.hashFields.put("hngr_flg", "hngrFlg");
		this.hashFields.put("bkg_from_dt", "bkgFromDt");
		this.hashFields.put("dlv_ctnt_cd", "dlvCtntCd");
		this.hashFields.put("sc_rfa_gbn", "scRfaGbn");
		this.hashFields.put("eq_tp_sz_cd", "eqTpSzCd");
		this.hashFields.put("non_rt_sts_cd", "nonRtStsCd");
		this.hashFields.put("spot_guide_flg", "spotGuideFlg");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("rtro_knd_cd", "rtroKndCd");
		this.hashFields.put("aloc_sts_cd", "alocStsCd");
		this.hashFields.put("ext_rmk", "extRmk");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("sys_set_dt", "sysSetDt");
		this.hashFields.put("mnl_set_dt", "mnlSetDt");
		this.hashFields.put("sys_set_dt_desc", "sysSetDtDesc");
		return this.hashFields;
	}
	
	
	/**
	 * @return the eqTpSzCd
	 */
	public String getEqTpSzCd() {
		return eqTpSzCd;
	}

	/**
	 * @param eqTpSzCd the eqTpSzCd to set
	 */
	public void setEqTpSzCd(String eqTpSzCd) {
		this.eqTpSzCd = eqTpSzCd;
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
	 * @return rfFlg
	 */
	public String getRfFlg() {
		return this.rfFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgViaCd
	 */
	public String getBkgViaCd() {
		return this.bkgViaCd;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
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
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
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
	 * @return bkgToDt
	 */
	public String getBkgToDt() {
		return this.bkgToDt;
	}
	
	/**
	 * Column Info
	 * @return siViaCd
	 */
	public String getSiViaCd() {
		return this.siViaCd;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
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
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return siCd
	 */
	public String getSiCd() {
		return this.siCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return custRefNo
	 */
	public String getCustRefNo() {
		return this.custRefNo;
	}
	
	/**
	 * Column Info
	 * @return tsPort
	 */
	public String getTsPort() {
		return this.tsPort;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgStfCd
	 */
	public String getBkgStfCd() {
		return this.bkgStfCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return custRefTpCd
	 */
	public String getCustRefTpCd() {
		return this.custRefTpCd;
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
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
	}
	
	/**
	 * Column Info
	 * @return excelFlg
	 */
	public String getExcelFlg() {
		return this.excelFlg;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
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
	 * @return dateGbn
	 */
	public String getDateGbn() {
		return this.dateGbn;
	}
	
	/**
	 * Column Info
	 * @return hngrFlg
	 */
	public String getHngrFlg() {
		return this.hngrFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgFromDt
	 */
	public String getBkgFromDt() {
		return this.bkgFromDt;
	}
	
	/**
	 * Column Info
	 * @return dlvCtntCd
	 */
	public String getDlvCtntCd() {
		return this.dlvCtntCd;
	}
	
	/**
	 * Column Info
	 * @return scRfaGbn
	 */
	public String getScRfaGbn() {
		return this.scRfaGbn;
	}

	/**
	 * Column Info
	 * @return nonRtStsCd
	 */
	public String getNonRtStsCd() {
		return this.nonRtStsCd;
	}
	
	/**
	 * Column Info
	 * @return spotGuideFlg
	 */
	public String getSpotGuideFlg() {
		return this.spotGuideFlg;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return rtroKndCd
	 */
	public String getRtroKndCd() {
		return this.rtroKndCd;
	}
	
	/**
	 * Column Info
	 * @return alocStsCd
	 */
	public String getAlocStsCd() {
		return this.alocStsCd;
	}

	/**
	 * Column Info
	 * @return extRmk
	 */
	public String getExtRmk() {
		return this.extRmk;
	}

	/**
	 * Column Info
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
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
	 * @return sysSetDt
	 */
	public String getSysSetDt() {
		return this.sysSetDt;
	}
	/**
	 * Column Info
	 * @return mnlSetDt
	 */
	public String getMnlSetDt() {
		return this.mnlSetDt;
	}

	/**
	 * Column Info
	 * @return sysSetDtDesc
	 */
	public String getsysSetDtDesc() {
		return this.sysSetDtDesc;
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
	 * @param rfFlg
	 */
	public void setRfFlg(String rfFlg) {
		this.rfFlg = rfFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgViaCd
	 */
	public void setBkgViaCd(String bkgViaCd) {
		this.bkgViaCd = bkgViaCd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
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
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
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
	 * @param bkgToDt
	 */
	public void setBkgToDt(String bkgToDt) {
		this.bkgToDt = bkgToDt;
	}
	
	/**
	 * Column Info
	 * @param siViaCd
	 */
	public void setSiViaCd(String siViaCd) {
		this.siViaCd = siViaCd;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
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
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param siCd
	 */
	public void setSiCd(String siCd) {
		this.siCd = siCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param custRefNo
	 */
	public void setCustRefNo(String custRefNo) {
		this.custRefNo = custRefNo;
	}
	
	/**
	 * Column Info
	 * @param tsPort
	 */
	public void setTsPort(String tsPort) {
		this.tsPort = tsPort;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgStfCd
	 */
	public void setBkgStfCd(String bkgStfCd) {
		this.bkgStfCd = bkgStfCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param custRefTpCd
	 */
	public void setCustRefTpCd(String custRefTpCd) {
		this.custRefTpCd = custRefTpCd;
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
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
	}
	
	/**
	 * Column Info
	 * @param excelFlg
	 */
	public void setExcelFlg(String excelFlg) {
		this.excelFlg = excelFlg;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
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
	 * @param dateGbn
	 */
	public void setDateGbn(String dateGbn) {
		this.dateGbn = dateGbn;
	}
	
	/**
	 * Column Info
	 * @param hngrFlg
	 */
	public void setHngrFlg(String hngrFlg) {
		this.hngrFlg = hngrFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgFromDt
	 */
	public void setBkgFromDt(String bkgFromDt) {
		this.bkgFromDt = bkgFromDt;
	}
	
	/**
	 * Column Info
	 * @param dlvCtntCd
	 */
	public void setDlvCtntCd(String dlvCtntCd) {
		this.dlvCtntCd = dlvCtntCd;
	}
	
	/**
	 * Column Info
	 * @param scRfaGbn
	 */
	public void setScRfaGbn(String scRfaGbn) {
		this.scRfaGbn = scRfaGbn;
	}
	
	/**
	 * Column Info
	 * @param nonRtStsCd
	 */
	public void setNonRtStsCd(String nonRtStsCd) {
		this.nonRtStsCd = nonRtStsCd;
	}
	
	/**
	 * Column Info
	 * @param spotGuideFlg
	 */
	public void setSpotGuideFlg(String spotGuideFlg) {
		this.spotGuideFlg = spotGuideFlg;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param rtroKndCd
	 */
	public void setRtroKndCd(String rtroKndCd) {
		this.rtroKndCd = rtroKndCd;
	}
	
	/**
	 * Column Info
	 * @param alocStsCd
	 */
	public void setAlocStsCd(String alocStsCd) {
		this.alocStsCd = alocStsCd;
	}
	
	/**
	 * Column Info
	 * @return extRmk
	 */
	public void setExtRmk(String extRmk) {
		this.extRmk = extRmk;
	}
	/**
	 * Column Info
	 * @return wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
	}
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	/**
	 * Column Info
	 * @return sysSetDt
	 */
	public void setSysSetDt(String sysSetDt) {
		this.sysSetDt = sysSetDt;
	}
	/**
	 * Column Info
	 * @return mnlSetDt
	 */
	public void setMnlSetDt(String mnlSetDt) {
		this.mnlSetDt = mnlSetDt;
	}
	/**
	 * Column Info
	 * @return sysSetDtDesc
	 */
	public void setsysSetDtDesc(String sysSetDtDesc) {
		this.sysSetDtDesc = sysSetDtDesc;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setRfFlg(JSPUtil.getParameter(request, "rf_flg", ""));
		setBkgViaCd(JSPUtil.getParameter(request, "bkg_via_cd", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, "rd_cgo_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, "bdr_flg", ""));
		setSrepCd(JSPUtil.getParameter(request, "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgToDt(JSPUtil.getParameter(request, "bkg_to_dt", ""));
		setSiViaCd(JSPUtil.getParameter(request, "si_via_cd", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, "sls_ofc_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, "bkg_cust_tp_cd", ""));
		setSiCd(JSPUtil.getParameter(request, "si_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setCustRefNo(JSPUtil.getParameter(request, "cust_ref_no", ""));
		setTsPort(JSPUtil.getParameter(request, "ts_port", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setBkgStfCd(JSPUtil.getParameter(request, "bkg_stf_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCustRefTpCd(JSPUtil.getParameter(request, "cust_ref_tp_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setScRfaNo(JSPUtil.getParameter(request, "sc_rfa_no", ""));
		setExcelFlg(JSPUtil.getParameter(request, "excel_flg", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setPolYdCd(JSPUtil.getParameter(request, "pol_yd_cd", ""));
		setDateGbn(JSPUtil.getParameter(request, "date_gbn", ""));
		setHngrFlg(JSPUtil.getParameter(request, "hngr_flg", ""));
		setBkgFromDt(JSPUtil.getParameter(request, "bkg_from_dt", ""));
		setDlvCtntCd(JSPUtil.getParameter(request, "dlv_ctnt_cd", ""));
		setScRfaGbn(JSPUtil.getParameter(request, "sc_rfa_gbn", ""));
		setEqTpSzCd(JSPUtil.getParameter(request, "eq_tp_sz_cd", ""));
		setNonRtStsCd(JSPUtil.getParameter(request, "non_rt_sts_cd", ""));
		setSpotGuideFlg(JSPUtil.getParameter(request, "spot_guide_flg", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, "vps_etb_dt", ""));
		setRtroKndCd(JSPUtil.getParameter(request, "rtro_knd_cd", ""));
		setAlocStsCd(JSPUtil.getParameter(request, "aloc_sts_cd", ""));
		setExtRmk(JSPUtil.getParameter(request, "ext_rmk", ""));
		setWgt(JSPUtil.getParameter(request, "wgt", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setSysSetDt(JSPUtil.getParameter(request, "sys_set_dt", ""));
		setMnlSetDt(JSPUtil.getParameter(request, "mnl_set_dt", ""));
		setsysSetDtDesc(JSPUtil.getParameter(request, "sys_set_dt_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgListForWorkWithBkgInputVO[]
	 */
	public BkgListForWorkWithBkgInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgListForWorkWithBkgInputVO[]
	 */
	public BkgListForWorkWithBkgInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgListForWorkWithBkgInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] rfFlg = (JSPUtil.getParameter(request, prefix	+ "rf_flg", length));
			String[] bkgViaCd = (JSPUtil.getParameter(request, prefix	+ "bkg_via_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgToDt = (JSPUtil.getParameter(request, prefix	+ "bkg_to_dt", length));
			String[] siViaCd = (JSPUtil.getParameter(request, prefix	+ "si_via_cd", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] siCd = (JSPUtil.getParameter(request, prefix	+ "si_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] custRefNo = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no", length));
			String[] tsPort = (JSPUtil.getParameter(request, prefix	+ "ts_port", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] bkgStfCd = (JSPUtil.getParameter(request, prefix	+ "bkg_stf_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] custRefTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_ref_tp_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] excelFlg = (JSPUtil.getParameter(request, prefix	+ "excel_flg", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] dateGbn = (JSPUtil.getParameter(request, prefix	+ "date_gbn", length));
			String[] hngrFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_flg", length));
			String[] bkgFromDt = (JSPUtil.getParameter(request, prefix	+ "bkg_from_dt", length));
			String[] dlvCtntCd = (JSPUtil.getParameter(request, prefix	+ "dlv_ctnt_cd", length));
			String[] scRfaGbn = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_gbn", length));
			String[] eqTpSzCd = (JSPUtil.getParameter(request, prefix	+ "eq_tp_sz_cd", length));
			String[] nonRtStsCd = (JSPUtil.getParameter(request, prefix	+ "non_rt_sts_cd", length));
			String[] spotGuideFlg = (JSPUtil.getParameter(request, prefix	+ "spot_guide_flg", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] rtroKndCd = (JSPUtil.getParameter(request, prefix	+ "rtro_knd_cd", length));
			String[] alocStsCd = (JSPUtil.getParameter(request, prefix	+ "aloc_sts_cd", length));
			String[] extRmk = (JSPUtil.getParameter(request, prefix	+ "ext_rmk", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] sysSetDt = (JSPUtil.getParameter(request, prefix	+ "sys_set_dt", length));
			String[] mnlSetDt = (JSPUtil.getParameter(request, prefix	+ "mnl_set_dt", length));
			String[] sysSetDtDesc = (JSPUtil.getParameter(request, prefix	+ "sys_set_dt_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgListForWorkWithBkgInputVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (rfFlg[i] != null)
					model.setRfFlg(rfFlg[i]);
				if (bkgViaCd[i] != null)
					model.setBkgViaCd(bkgViaCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgToDt[i] != null)
					model.setBkgToDt(bkgToDt[i]);
				if (siViaCd[i] != null)
					model.setSiViaCd(siViaCd[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (siCd[i] != null)
					model.setSiCd(siCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (custRefNo[i] != null)
					model.setCustRefNo(custRefNo[i]);
				if (tsPort[i] != null)
					model.setTsPort(tsPort[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (bkgStfCd[i] != null)
					model.setBkgStfCd(bkgStfCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (custRefTpCd[i] != null)
					model.setCustRefTpCd(custRefTpCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (excelFlg[i] != null)
					model.setExcelFlg(excelFlg[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (dateGbn[i] != null)
					model.setDateGbn(dateGbn[i]);
				if (hngrFlg[i] != null)
					model.setHngrFlg(hngrFlg[i]);
				if (bkgFromDt[i] != null)
					model.setBkgFromDt(bkgFromDt[i]);
				if (dlvCtntCd[i] != null)
					model.setDlvCtntCd(dlvCtntCd[i]);
				if (scRfaGbn[i] != null)
					model.setScRfaGbn(scRfaGbn[i]);
				if (eqTpSzCd[i] != null)
					model.setEqTpSzCd(eqTpSzCd[i]);
				if (nonRtStsCd[i] != null)
					model.setNonRtStsCd(nonRtStsCd[i]);
				if (spotGuideFlg[i] != null)
					model.setSpotGuideFlg(spotGuideFlg[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (rtroKndCd[i] != null)
					model.setRtroKndCd(rtroKndCd[i]);
				if (alocStsCd[i] != null)
					model.setAlocStsCd(alocStsCd[i]);
				if (extRmk[i] != null)
					model.setExtRmk(extRmk[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (sysSetDt[i] != null)
					model.setSysSetDt(sysSetDt[i]);
				if (mnlSetDt[i] != null)
					model.setMnlSetDt(mnlSetDt[i]);
				if (sysSetDtDesc[i] != null)
					model.setsysSetDtDesc(sysSetDtDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgListForWorkWithBkgInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgListForWorkWithBkgInputVO[]
	 */
	public BkgListForWorkWithBkgInputVO[] getBkgListForWorkWithBkgInputVOs(){
		BkgListForWorkWithBkgInputVO[] vos = (BkgListForWorkWithBkgInputVO[])models.toArray(new BkgListForWorkWithBkgInputVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfFlg = this.rfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgViaCd = this.bkgViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgToDt = this.bkgToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siViaCd = this.siViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siCd = this.siCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNo = this.custRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPort = this.tsPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStfCd = this.bkgStfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefTpCd = this.custRefTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelFlg = this.excelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateGbn = this.dateGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlg = this.hngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFromDt = this.bkgFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlvCtntCd = this.dlvCtntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaGbn = this.scRfaGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpSzCd = this.eqTpSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonRtStsCd = this.nonRtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotGuideFlg = this.spotGuideFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtroKndCd = this.rtroKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocStsCd = this.alocStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.extRmk = this.extRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSetDt = this.sysSetDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlSetDt = this.mnlSetDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSetDtDesc = this.sysSetDtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
