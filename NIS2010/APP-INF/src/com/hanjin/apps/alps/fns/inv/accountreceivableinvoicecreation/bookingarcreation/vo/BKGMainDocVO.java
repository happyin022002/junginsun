/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BKGMainDocVO.java
*@FileTitle : BKGMainDocVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.26 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BKGMainDocVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BKGMainDocVO> models = new ArrayList<BKGMainDocVO>();
	
	/* Column Info */
	private String whfDeclCfmDt = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String whfDeclOfcCd = null;
	/* Column Info */
	private String whfDeclNo = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trnkSkdDirCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String whfDeclVslCd = null;
	/* Column Info */
	private String mstBlNo = null;
	/* Column Info */
	private String vvdTrnsFlg = null;
	/* Column Info */
	private String cgoWgt = null;
	/* Column Info */
	private String caRsnCd = null;
	/* Column Info */
	private String bkgCorrDt = null;
	/* Column Info */
	private String cgoMeasQty = null;
	/* Column Info */
	private String whfMrnNo = null;
	/* Column Info */
	private String invRefNo = null;
	/* Column Info */
	private String bkgCorrNo = null;
	/* Column Info */
	private String destSvcModCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String whfNtcNo = null;
	/* Column Info */
	private String whfDeclDirCd = null;
	/* Column Info */
	private String frtFwrdCustSeq = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String whfDeclVoyNo = null;
	/* Column Info */
	private String bkgRefNo = null;
	/* Column Info */
	private String siRefNo = null;
	/* Column Info */
	private String trnkVslCd = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String bdrIndFlg = null;
	/* Column Info */
	private String trnkSkdVoyNo = null;
	/* Column Info */
	private String frtFwrdCntCd = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String whfFlg = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String obrdDt = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BKGMainDocVO() {}

	public BKGMainDocVO(String ibflag, String pagerows, String blTpCd, String trnkVslCd, String trnkSkdVoyNo, String trnkSkdDirCd, String porCd, String delCd, String cgoWgt, String cgoMeasQty, String srepCd, String bkgRefNo, String scNo, String rfaNo, String mstBlNo, String invRefNo, String siRefNo, String bkgTeuQty, String bkgFeuQty, String frtFwrdCntCd, String frtFwrdCustSeq, String vvdTrnsFlg, String destSvcModCd, String bdrIndFlg, String bkgCorrNo, String bkgCorrDt, String caRsnCd, String whfDeclNo, String whfDeclCfmDt, String whfDeclOfcCd, String whfMrnNo, String whfNtcNo, String whfDeclVslCd, String whfDeclVoyNo, String whfDeclDirCd, String cxlFlg, String csrNo, String whfFlg, String ctrtOfcCd, String obrdDt) {
		this.whfDeclCfmDt = whfDeclCfmDt;
		this.porCd = porCd;
		this.cxlFlg = cxlFlg;
		this.whfDeclOfcCd = whfDeclOfcCd;
		this.whfDeclNo = whfDeclNo;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.trnkSkdDirCd = trnkSkdDirCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.bkgFeuQty = bkgFeuQty;
		this.scNo = scNo;
		this.whfDeclVslCd = whfDeclVslCd;
		this.mstBlNo = mstBlNo;
		this.vvdTrnsFlg = vvdTrnsFlg;
		this.cgoWgt = cgoWgt;
		this.caRsnCd = caRsnCd;
		this.bkgCorrDt = bkgCorrDt;
		this.cgoMeasQty = cgoMeasQty;
		this.whfMrnNo = whfMrnNo;
		this.invRefNo = invRefNo;
		this.bkgCorrNo = bkgCorrNo;
		this.destSvcModCd = destSvcModCd;
		this.delCd = delCd;
		this.whfNtcNo = whfNtcNo;
		this.whfDeclDirCd = whfDeclDirCd;
		this.frtFwrdCustSeq = frtFwrdCustSeq;
		this.blTpCd = blTpCd;
		this.whfDeclVoyNo = whfDeclVoyNo;
		this.bkgRefNo = bkgRefNo;
		this.siRefNo = siRefNo;
		this.trnkVslCd = trnkVslCd;
		this.bkgTeuQty = bkgTeuQty;
		this.bdrIndFlg = bdrIndFlg;
		this.trnkSkdVoyNo = trnkSkdVoyNo;
		this.frtFwrdCntCd = frtFwrdCntCd;
		this.csrNo = csrNo;
		this.whfFlg = whfFlg;
		this.ctrtOfcCd = ctrtOfcCd;
		this.obrdDt = obrdDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("whf_decl_cfm_dt", getWhfDeclCfmDt());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("whf_decl_ofc_cd", getWhfDeclOfcCd());
		this.hashColumns.put("whf_decl_no", getWhfDeclNo());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trnk_skd_dir_cd", getTrnkSkdDirCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("whf_decl_vsl_cd", getWhfDeclVslCd());
		this.hashColumns.put("mst_bl_no", getMstBlNo());
		this.hashColumns.put("vvd_trns_flg", getVvdTrnsFlg());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		this.hashColumns.put("ca_rsn_cd", getCaRsnCd());
		this.hashColumns.put("bkg_corr_dt", getBkgCorrDt());
		this.hashColumns.put("cgo_meas_qty", getCgoMeasQty());
		this.hashColumns.put("whf_mrn_no", getWhfMrnNo());
		this.hashColumns.put("inv_ref_no", getInvRefNo());
		this.hashColumns.put("bkg_corr_no", getBkgCorrNo());
		this.hashColumns.put("dest_svc_mod_cd", getDestSvcModCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("whf_ntc_no", getWhfNtcNo());
		this.hashColumns.put("whf_decl_dir_cd", getWhfDeclDirCd());
		this.hashColumns.put("frt_fwrd_cust_seq", getFrtFwrdCustSeq());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("whf_decl_voy_no", getWhfDeclVoyNo());
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());
		this.hashColumns.put("si_ref_no", getSiRefNo());
		this.hashColumns.put("trnk_vsl_cd", getTrnkVslCd());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("bdr_ind_flg", getBdrIndFlg());
		this.hashColumns.put("trnk_skd_voy_no", getTrnkSkdVoyNo());
		this.hashColumns.put("frt_fwrd_cnt_cd", getFrtFwrdCntCd());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("whf_flg", getWhfFlg());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("obrd_dt", getObrdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("whf_decl_cfm_dt", "whfDeclCfmDt");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("whf_decl_ofc_cd", "whfDeclOfcCd");
		this.hashFields.put("whf_decl_no", "whfDeclNo");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trnk_skd_dir_cd", "trnkSkdDirCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("whf_decl_vsl_cd", "whfDeclVslCd");
		this.hashFields.put("mst_bl_no", "mstBlNo");
		this.hashFields.put("vvd_trns_flg", "vvdTrnsFlg");
		this.hashFields.put("cgo_wgt", "cgoWgt");
		this.hashFields.put("ca_rsn_cd", "caRsnCd");
		this.hashFields.put("bkg_corr_dt", "bkgCorrDt");
		this.hashFields.put("cgo_meas_qty", "cgoMeasQty");
		this.hashFields.put("whf_mrn_no", "whfMrnNo");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("bkg_corr_no", "bkgCorrNo");
		this.hashFields.put("dest_svc_mod_cd", "destSvcModCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("whf_ntc_no", "whfNtcNo");
		this.hashFields.put("whf_decl_dir_cd", "whfDeclDirCd");
		this.hashFields.put("frt_fwrd_cust_seq", "frtFwrdCustSeq");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("whf_decl_voy_no", "whfDeclVoyNo");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("si_ref_no", "siRefNo");
		this.hashFields.put("trnk_vsl_cd", "trnkVslCd");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("bdr_ind_flg", "bdrIndFlg");
		this.hashFields.put("trnk_skd_voy_no", "trnkSkdVoyNo");
		this.hashFields.put("frt_fwrd_cnt_cd", "frtFwrdCntCd");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("whf_flg", "whfFlg");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("obrd_dt", "obrdDt");
		return this.hashFields;
	}
	
	/**
	 * @return the obrdDt
	 */
	public String getObrdDt() {
		return obrdDt;
	}

	/**
	 * @param obrdDt the obrdDt to set
	 */
	public void setObrdDt(String obrdDt) {
		this.obrdDt = obrdDt;
	}

	/**
	 * @return the ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return ctrtOfcCd;
	}

	/**
	 * @param ctrtOfcCd the ctrtOfcCd to set
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}

	/**
	 * @return the whfFlg
	 */
	public String getWhfFlg() {
		return whfFlg;
	}

	/**
	 * @param whfFlg the whfFlg to set
	 */
	public void setWhfFlg(String whfFlg) {
		this.whfFlg = whfFlg;
	}

	/**
	 * @return the csrNo
	 */
	public String getCsrNo() {
		return csrNo;
	}

	/**
	 * @param csrNo the csrNo to set
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}

	/**
	 * Column Info
	 * @return whfDeclCfmDt
	 */
	public String getWhfDeclCfmDt() {
		return this.whfDeclCfmDt;
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
	 * @return cxlFlg
	 */
	public String getCxlFlg() {
		return this.cxlFlg;
	}
	
	/**
	 * Column Info
	 * @return whfDeclOfcCd
	 */
	public String getWhfDeclOfcCd() {
		return this.whfDeclOfcCd;
	}
	
	/**
	 * Column Info
	 * @return whfDeclNo
	 */
	public String getWhfDeclNo() {
		return this.whfDeclNo;
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
	 * @return trnkSkdDirCd
	 */
	public String getTrnkSkdDirCd() {
		return this.trnkSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return bkgFeuQty
	 */
	public String getBkgFeuQty() {
		return this.bkgFeuQty;
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
	 * @return whfDeclVslCd
	 */
	public String getWhfDeclVslCd() {
		return this.whfDeclVslCd;
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
	 * @return vvdTrnsFlg
	 */
	public String getVvdTrnsFlg() {
		return this.vvdTrnsFlg;
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
	 * @return caRsnCd
	 */
	public String getCaRsnCd() {
		return this.caRsnCd;
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
	 * @return cgoMeasQty
	 */
	public String getCgoMeasQty() {
		return this.cgoMeasQty;
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
	 * @return bkgCorrNo
	 */
	public String getBkgCorrNo() {
		return this.bkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @return destSvcModCd
	 */
	public String getDestSvcModCd() {
		return this.destSvcModCd;
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
	 * @return whfDeclDirCd
	 */
	public String getWhfDeclDirCd() {
		return this.whfDeclDirCd;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return whfDeclVoyNo
	 */
	public String getWhfDeclVoyNo() {
		return this.whfDeclVoyNo;
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
	 * @return siRefNo
	 */
	public String getSiRefNo() {
		return this.siRefNo;
	}
	
	/**
	 * Column Info
	 * @return trnkVslCd
	 */
	public String getTrnkVslCd() {
		return this.trnkVslCd;
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
	 * @return bdrIndFlg
	 */
	public String getBdrIndFlg() {
		return this.bdrIndFlg;
	}
	
	/**
	 * Column Info
	 * @return trnkSkdVoyNo
	 */
	public String getTrnkSkdVoyNo() {
		return this.trnkSkdVoyNo;
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
	 * @param whfDeclCfmDt
	 */
	public void setWhfDeclCfmDt(String whfDeclCfmDt) {
		this.whfDeclCfmDt = whfDeclCfmDt;
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
	 * @param cxlFlg
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
	}
	
	/**
	 * Column Info
	 * @param whfDeclOfcCd
	 */
	public void setWhfDeclOfcCd(String whfDeclOfcCd) {
		this.whfDeclOfcCd = whfDeclOfcCd;
	}
	
	/**
	 * Column Info
	 * @param whfDeclNo
	 */
	public void setWhfDeclNo(String whfDeclNo) {
		this.whfDeclNo = whfDeclNo;
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
	 * @param trnkSkdDirCd
	 */
	public void setTrnkSkdDirCd(String trnkSkdDirCd) {
		this.trnkSkdDirCd = trnkSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param bkgFeuQty
	 */
	public void setBkgFeuQty(String bkgFeuQty) {
		this.bkgFeuQty = bkgFeuQty;
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
	 * @param whfDeclVslCd
	 */
	public void setWhfDeclVslCd(String whfDeclVslCd) {
		this.whfDeclVslCd = whfDeclVslCd;
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
	 * @param vvdTrnsFlg
	 */
	public void setVvdTrnsFlg(String vvdTrnsFlg) {
		this.vvdTrnsFlg = vvdTrnsFlg;
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
	 * @param caRsnCd
	 */
	public void setCaRsnCd(String caRsnCd) {
		this.caRsnCd = caRsnCd;
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
	 * @param cgoMeasQty
	 */
	public void setCgoMeasQty(String cgoMeasQty) {
		this.cgoMeasQty = cgoMeasQty;
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
	 * @param bkgCorrNo
	 */
	public void setBkgCorrNo(String bkgCorrNo) {
		this.bkgCorrNo = bkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @param destSvcModCd
	 */
	public void setDestSvcModCd(String destSvcModCd) {
		this.destSvcModCd = destSvcModCd;
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
	 * @param whfDeclDirCd
	 */
	public void setWhfDeclDirCd(String whfDeclDirCd) {
		this.whfDeclDirCd = whfDeclDirCd;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param whfDeclVoyNo
	 */
	public void setWhfDeclVoyNo(String whfDeclVoyNo) {
		this.whfDeclVoyNo = whfDeclVoyNo;
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
	 * @param siRefNo
	 */
	public void setSiRefNo(String siRefNo) {
		this.siRefNo = siRefNo;
	}
	
	/**
	 * Column Info
	 * @param trnkVslCd
	 */
	public void setTrnkVslCd(String trnkVslCd) {
		this.trnkVslCd = trnkVslCd;
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
	 * @param bdrIndFlg
	 */
	public void setBdrIndFlg(String bdrIndFlg) {
		this.bdrIndFlg = bdrIndFlg;
	}
	
	/**
	 * Column Info
	 * @param trnkSkdVoyNo
	 */
	public void setTrnkSkdVoyNo(String trnkSkdVoyNo) {
		this.trnkSkdVoyNo = trnkSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdCntCd
	 */
	public void setFrtFwrdCntCd(String frtFwrdCntCd) {
		this.frtFwrdCntCd = frtFwrdCntCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setWhfDeclCfmDt(JSPUtil.getParameter(request, "whf_decl_cfm_dt", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCxlFlg(JSPUtil.getParameter(request, "cxl_flg", ""));
		setWhfDeclOfcCd(JSPUtil.getParameter(request, "whf_decl_ofc_cd", ""));
		setWhfDeclNo(JSPUtil.getParameter(request, "whf_decl_no", ""));
		setSrepCd(JSPUtil.getParameter(request, "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTrnkSkdDirCd(JSPUtil.getParameter(request, "trnk_skd_dir_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, "bkg_feu_qty", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setWhfDeclVslCd(JSPUtil.getParameter(request, "whf_decl_vsl_cd", ""));
		setMstBlNo(JSPUtil.getParameter(request, "mst_bl_no", ""));
		setVvdTrnsFlg(JSPUtil.getParameter(request, "vvd_trns_flg", ""));
		setCgoWgt(JSPUtil.getParameter(request, "cgo_wgt", ""));
		setCaRsnCd(JSPUtil.getParameter(request, "ca_rsn_cd", ""));
		setBkgCorrDt(JSPUtil.getParameter(request, "bkg_corr_dt", ""));
		setCgoMeasQty(JSPUtil.getParameter(request, "cgo_meas_qty", ""));
		setWhfMrnNo(JSPUtil.getParameter(request, "whf_mrn_no", ""));
		setInvRefNo(JSPUtil.getParameter(request, "inv_ref_no", ""));
		setBkgCorrNo(JSPUtil.getParameter(request, "bkg_corr_no", ""));
		setDestSvcModCd(JSPUtil.getParameter(request, "dest_svc_mod_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setWhfNtcNo(JSPUtil.getParameter(request, "whf_ntc_no", ""));
		setWhfDeclDirCd(JSPUtil.getParameter(request, "whf_decl_dir_cd", ""));
		setFrtFwrdCustSeq(JSPUtil.getParameter(request, "frt_fwrd_cust_seq", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setWhfDeclVoyNo(JSPUtil.getParameter(request, "whf_decl_voy_no", ""));
		setBkgRefNo(JSPUtil.getParameter(request, "bkg_ref_no", ""));
		setSiRefNo(JSPUtil.getParameter(request, "si_ref_no", ""));
		setTrnkVslCd(JSPUtil.getParameter(request, "trnk_vsl_cd", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, "bkg_teu_qty", ""));
		setBdrIndFlg(JSPUtil.getParameter(request, "bdr_ind_flg", ""));
		setTrnkSkdVoyNo(JSPUtil.getParameter(request, "trnk_skd_voy_no", ""));
		setFrtFwrdCntCd(JSPUtil.getParameter(request, "frt_fwrd_cnt_cd", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setWhfFlg(JSPUtil.getParameter(request, "whf_flg", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, "ctrt_ofc_cd", ""));
		setObrdDt(JSPUtil.getParameter(request, "obrd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BKGMainDocVO[]
	 */
	public BKGMainDocVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BKGMainDocVO[]
	 */
	public BKGMainDocVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BKGMainDocVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] whfDeclCfmDt = (JSPUtil.getParameter(request, prefix	+ "whf_decl_cfm_dt", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] whfDeclOfcCd = (JSPUtil.getParameter(request, prefix	+ "whf_decl_ofc_cd", length));
			String[] whfDeclNo = (JSPUtil.getParameter(request, prefix	+ "whf_decl_no", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trnkSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_dir_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] whfDeclVslCd = (JSPUtil.getParameter(request, prefix	+ "whf_decl_vsl_cd", length));
			String[] mstBlNo = (JSPUtil.getParameter(request, prefix	+ "mst_bl_no", length));
			String[] vvdTrnsFlg = (JSPUtil.getParameter(request, prefix	+ "vvd_trns_flg", length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt", length));
			String[] caRsnCd = (JSPUtil.getParameter(request, prefix	+ "ca_rsn_cd", length));
			String[] bkgCorrDt = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_dt", length));
			String[] cgoMeasQty = (JSPUtil.getParameter(request, prefix	+ "cgo_meas_qty", length));
			String[] whfMrnNo = (JSPUtil.getParameter(request, prefix	+ "whf_mrn_no", length));
			String[] invRefNo = (JSPUtil.getParameter(request, prefix	+ "inv_ref_no", length));
			String[] bkgCorrNo = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_no", length));
			String[] destSvcModCd = (JSPUtil.getParameter(request, prefix	+ "dest_svc_mod_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] whfNtcNo = (JSPUtil.getParameter(request, prefix	+ "whf_ntc_no", length));
			String[] whfDeclDirCd = (JSPUtil.getParameter(request, prefix	+ "whf_decl_dir_cd", length));
			String[] frtFwrdCustSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cust_seq", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] whfDeclVoyNo = (JSPUtil.getParameter(request, prefix	+ "whf_decl_voy_no", length));
			String[] bkgRefNo = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_no", length));
			String[] siRefNo = (JSPUtil.getParameter(request, prefix	+ "si_ref_no", length));
			String[] trnkVslCd = (JSPUtil.getParameter(request, prefix	+ "trnk_vsl_cd", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] bdrIndFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_ind_flg", length));
			String[] trnkSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_voy_no", length));
			String[] frtFwrdCntCd = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_cd", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] whfFlg = (JSPUtil.getParameter(request, prefix	+ "whf_flg", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] obrdDt = (JSPUtil.getParameter(request, prefix	+ "obrd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BKGMainDocVO();
				if (whfDeclCfmDt[i] != null)
					model.setWhfDeclCfmDt(whfDeclCfmDt[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (whfDeclOfcCd[i] != null)
					model.setWhfDeclOfcCd(whfDeclOfcCd[i]);
				if (whfDeclNo[i] != null)
					model.setWhfDeclNo(whfDeclNo[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trnkSkdDirCd[i] != null)
					model.setTrnkSkdDirCd(trnkSkdDirCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (whfDeclVslCd[i] != null)
					model.setWhfDeclVslCd(whfDeclVslCd[i]);
				if (mstBlNo[i] != null)
					model.setMstBlNo(mstBlNo[i]);
				if (vvdTrnsFlg[i] != null)
					model.setVvdTrnsFlg(vvdTrnsFlg[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				if (caRsnCd[i] != null)
					model.setCaRsnCd(caRsnCd[i]);
				if (bkgCorrDt[i] != null)
					model.setBkgCorrDt(bkgCorrDt[i]);
				if (cgoMeasQty[i] != null)
					model.setCgoMeasQty(cgoMeasQty[i]);
				if (whfMrnNo[i] != null)
					model.setWhfMrnNo(whfMrnNo[i]);
				if (invRefNo[i] != null)
					model.setInvRefNo(invRefNo[i]);
				if (bkgCorrNo[i] != null)
					model.setBkgCorrNo(bkgCorrNo[i]);
				if (destSvcModCd[i] != null)
					model.setDestSvcModCd(destSvcModCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (whfNtcNo[i] != null)
					model.setWhfNtcNo(whfNtcNo[i]);
				if (whfDeclDirCd[i] != null)
					model.setWhfDeclDirCd(whfDeclDirCd[i]);
				if (frtFwrdCustSeq[i] != null)
					model.setFrtFwrdCustSeq(frtFwrdCustSeq[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (whfDeclVoyNo[i] != null)
					model.setWhfDeclVoyNo(whfDeclVoyNo[i]);
				if (bkgRefNo[i] != null)
					model.setBkgRefNo(bkgRefNo[i]);
				if (siRefNo[i] != null)
					model.setSiRefNo(siRefNo[i]);
				if (trnkVslCd[i] != null)
					model.setTrnkVslCd(trnkVslCd[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (bdrIndFlg[i] != null)
					model.setBdrIndFlg(bdrIndFlg[i]);
				if (trnkSkdVoyNo[i] != null)
					model.setTrnkSkdVoyNo(trnkSkdVoyNo[i]);
				if (frtFwrdCntCd[i] != null)
					model.setFrtFwrdCntCd(frtFwrdCntCd[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (whfFlg[i] != null)
					model.setWhfFlg(whfFlg[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (obrdDt[i] != null)
					model.setObrdDt(obrdDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBKGMainDocVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BKGMainDocVO[]
	 */
	public BKGMainDocVO[] getBKGMainDocVOs(){
		BKGMainDocVO[] vos = (BKGMainDocVO[])models.toArray(new BKGMainDocVO[models.size()]);
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
		this.whfDeclCfmDt = this.whfDeclCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclOfcCd = this.whfDeclOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclNo = this.whfDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdDirCd = this.trnkSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclVslCd = this.whfDeclVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBlNo = this.mstBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdTrnsFlg = this.vvdTrnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caRsnCd = this.caRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrDt = this.bkgCorrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoMeasQty = this.cgoMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfMrnNo = this.whfMrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo = this.invRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrNo = this.bkgCorrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destSvcModCd = this.destSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfNtcNo = this.whfNtcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclDirCd = this.whfDeclDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCustSeq = this.frtFwrdCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclVoyNo = this.whfDeclVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo = this.bkgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siRefNo = this.siRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVslCd = this.trnkVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrIndFlg = this.bdrIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdVoyNo = this.trnkSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntCd = this.frtFwrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfFlg = this.whfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obrdDt = this.obrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
