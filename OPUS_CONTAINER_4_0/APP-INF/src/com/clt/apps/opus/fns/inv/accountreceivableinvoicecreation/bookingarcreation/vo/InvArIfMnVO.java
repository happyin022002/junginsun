/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvArIfMnVO.java
*@FileTitle : InvArIfMnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.07 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvArIfMnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvArIfMnVO> models = new ArrayList<InvArIfMnVO>();
	
	/* Column Info */
	private String srcIfSeq = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String srcIfDt = null;
	/* Column Info */
	private String whfDeclNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String destTrnsSvcModCd = null;
	/* Column Info */
	private String ifSrcCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String mstBlNo = null;
	/* Column Info */
	private String vvdTrnsFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String cgoWgt = null;
	/* Column Info */
	private String bkgCorrNo = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String whfDeclDirCd = null;
	/* Column Info */
	private String frtFwrdCustSeq = null;
	/* Column Info */
	private String sailDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String whfDeclVoyNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String siRefNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String trnkVslCd = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String trnkSkdVoyNo = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String whfDeclCfmDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String whfDeclOfcCd = null;
	/* Column Info */
	private String trnkSkdDirCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String whfDeclVslCd = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bkgCorrDt = null;
	/* Column Info */
	private String cgoMeasQty = null;
	/* Column Info */
	private String blInvIfDt = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String whfMrnNo = null;
	/* Column Info */
	private String invRefNo = null;
	/* Column Info */
	private String glEffDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String trspRqstOrdFlg = null;
	/* Column Info */
	private String blInvIfFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String bkgRefNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String invSrcNo = null;
	/* Column Info */
	private String apArOffstNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String frtFwrdCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvArIfMnVO() {}

	public InvArIfMnVO(String ibflag, String pagerows, String srcIfDt, String srcIfSeq, String blNo, String blTpCd, String blSrcNo, String invSrcNo, String bkgNo, String bkgCorrNo, String bkgCorrDt, String vvdTrnsFlg, String custCntCd, String custSeq, String frtFwrdCntCd, String frtFwrdCustSeq, String ofcCd, String ifSrcCd, String vslCd, String skdVoyNo, String skdDirCd, String svcScpCd, String sailDt, String sailArrDt, String dueDt, String glEffDt, String slanCd, String ioBndCd, String trnkVslCd, String trnkSkdVoyNo, String trnkSkdDirCd, String porCd, String polCd, String podCd, String delCd, String cgoWgt, String cgoMeasQty, String bkgTeuQty, String bkgFeuQty, String scNo, String rfaNo, String srepCd, String slsOfcCd, String mstBlNo, String destTrnsSvcModCd, String whfDeclNo, String whfDeclCfmDt, String whfDeclVslCd, String whfDeclVoyNo, String whfDeclDirCd, String whfDeclOfcCd, String whfMrnNo, String siRefNo, String bkgRefNo, String invRefNo, String blInvIfFlg, String blInvIfDt, String arIfNo, String trspRqstOrdFlg, String apArOffstNo, String invRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.srcIfSeq = srcIfSeq;
		this.vslCd = vslCd;
		this.svcScpCd = svcScpCd;
		this.srcIfDt = srcIfDt;
		this.whfDeclNo = whfDeclNo;
		this.sailArrDt = sailArrDt;
		this.blNo = blNo;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.destTrnsSvcModCd = destTrnsSvcModCd;
		this.ifSrcCd = ifSrcCd;
		this.scNo = scNo;
		this.slsOfcCd = slsOfcCd;
		this.mstBlNo = mstBlNo;
		this.vvdTrnsFlg = vvdTrnsFlg;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.cgoWgt = cgoWgt;
		this.bkgCorrNo = bkgCorrNo;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.whfDeclDirCd = whfDeclDirCd;
		this.frtFwrdCustSeq = frtFwrdCustSeq;
		this.sailDt = sailDt;
		this.podCd = podCd;
		this.whfDeclVoyNo = whfDeclVoyNo;
		this.creUsrId = creUsrId;
		this.siRefNo = siRefNo;
		this.bkgNo = bkgNo;
		this.trnkVslCd = trnkVslCd;
		this.bkgTeuQty = bkgTeuQty;
		this.trnkSkdVoyNo = trnkSkdVoyNo;
		this.porCd = porCd;
		this.whfDeclCfmDt = whfDeclCfmDt;
		this.creDt = creDt;
		this.whfDeclOfcCd = whfDeclOfcCd;
		this.trnkSkdDirCd = trnkSkdDirCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.bkgFeuQty = bkgFeuQty;
		this.arIfNo = arIfNo;
		this.whfDeclVslCd = whfDeclVslCd;
		this.dueDt = dueDt;
		this.updDt = updDt;
		this.bkgCorrDt = bkgCorrDt;
		this.cgoMeasQty = cgoMeasQty;
		this.blInvIfDt = blInvIfDt;
		this.blSrcNo = blSrcNo;
		this.whfMrnNo = whfMrnNo;
		this.invRefNo = invRefNo;
		this.glEffDt = glEffDt;
		this.custSeq = custSeq;
		this.ioBndCd = ioBndCd;
		this.trspRqstOrdFlg = trspRqstOrdFlg;
		this.blInvIfFlg = blInvIfFlg;
		this.skdDirCd = skdDirCd;
		this.blTpCd = blTpCd;
		this.bkgRefNo = bkgRefNo;
		this.ofcCd = ofcCd;
		this.invSrcNo = invSrcNo;
		this.apArOffstNo = apArOffstNo;
		this.slanCd = slanCd;
		this.invRmk = invRmk;
		this.frtFwrdCntCd = frtFwrdCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("src_if_seq", getSrcIfSeq());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("src_if_dt", getSrcIfDt());
		this.hashColumns.put("whf_decl_no", getWhfDeclNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("dest_trns_svc_mod_cd", getDestTrnsSvcModCd());
		this.hashColumns.put("if_src_cd", getIfSrcCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("mst_bl_no", getMstBlNo());
		this.hashColumns.put("vvd_trns_flg", getVvdTrnsFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		this.hashColumns.put("bkg_corr_no", getBkgCorrNo());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("whf_decl_dir_cd", getWhfDeclDirCd());
		this.hashColumns.put("frt_fwrd_cust_seq", getFrtFwrdCustSeq());
		this.hashColumns.put("sail_dt", getSailDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("whf_decl_voy_no", getWhfDeclVoyNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("si_ref_no", getSiRefNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("trnk_vsl_cd", getTrnkVslCd());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("trnk_skd_voy_no", getTrnkSkdVoyNo());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("whf_decl_cfm_dt", getWhfDeclCfmDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("whf_decl_ofc_cd", getWhfDeclOfcCd());
		this.hashColumns.put("trnk_skd_dir_cd", getTrnkSkdDirCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("whf_decl_vsl_cd", getWhfDeclVslCd());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bkg_corr_dt", getBkgCorrDt());
		this.hashColumns.put("cgo_meas_qty", getCgoMeasQty());
		this.hashColumns.put("bl_inv_if_dt", getBlInvIfDt());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("whf_mrn_no", getWhfMrnNo());
		this.hashColumns.put("inv_ref_no", getInvRefNo());
		this.hashColumns.put("gl_eff_dt", getGlEffDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("trsp_rqst_ord_flg", getTrspRqstOrdFlg());
		this.hashColumns.put("bl_inv_if_flg", getBlInvIfFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("inv_src_no", getInvSrcNo());
		this.hashColumns.put("ap_ar_offst_no", getApArOffstNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("frt_fwrd_cnt_cd", getFrtFwrdCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("src_if_seq", "srcIfSeq");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("src_if_dt", "srcIfDt");
		this.hashFields.put("whf_decl_no", "whfDeclNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("dest_trns_svc_mod_cd", "destTrnsSvcModCd");
		this.hashFields.put("if_src_cd", "ifSrcCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("mst_bl_no", "mstBlNo");
		this.hashFields.put("vvd_trns_flg", "vvdTrnsFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cgo_wgt", "cgoWgt");
		this.hashFields.put("bkg_corr_no", "bkgCorrNo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("whf_decl_dir_cd", "whfDeclDirCd");
		this.hashFields.put("frt_fwrd_cust_seq", "frtFwrdCustSeq");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("whf_decl_voy_no", "whfDeclVoyNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("si_ref_no", "siRefNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("trnk_vsl_cd", "trnkVslCd");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("trnk_skd_voy_no", "trnkSkdVoyNo");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("whf_decl_cfm_dt", "whfDeclCfmDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("whf_decl_ofc_cd", "whfDeclOfcCd");
		this.hashFields.put("trnk_skd_dir_cd", "trnkSkdDirCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("whf_decl_vsl_cd", "whfDeclVslCd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bkg_corr_dt", "bkgCorrDt");
		this.hashFields.put("cgo_meas_qty", "cgoMeasQty");
		this.hashFields.put("bl_inv_if_dt", "blInvIfDt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("whf_mrn_no", "whfMrnNo");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("trsp_rqst_ord_flg", "trspRqstOrdFlg");
		this.hashFields.put("bl_inv_if_flg", "blInvIfFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("inv_src_no", "invSrcNo");
		this.hashFields.put("ap_ar_offst_no", "apArOffstNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("frt_fwrd_cnt_cd", "frtFwrdCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return srcIfSeq
	 */
	public String getSrcIfSeq() {
		return this.srcIfSeq;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return srcIfDt
	 */
	public String getSrcIfDt() {
		return this.srcIfDt;
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
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
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
	 * Column Info
	 * @return destTrnsSvcModCd
	 */
	public String getDestTrnsSvcModCd() {
		return this.destTrnsSvcModCd;
	}
	
	/**
	 * Column Info
	 * @return ifSrcCd
	 */
	public String getIfSrcCd() {
		return this.ifSrcCd;
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
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return cgoWgt
	 */
	public String getCgoWgt() {
		return this.cgoWgt;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return sailDt
	 */
	public String getSailDt() {
		return this.sailDt;
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
	 * @return whfDeclVoyNo
	 */
	public String getWhfDeclVoyNo() {
		return this.whfDeclVoyNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return trnkSkdVoyNo
	 */
	public String getTrnkSkdVoyNo() {
		return this.trnkSkdVoyNo;
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
	 * @return whfDeclCfmDt
	 */
	public String getWhfDeclCfmDt() {
		return this.whfDeclCfmDt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
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
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return blInvIfDt
	 */
	public String getBlInvIfDt() {
		return this.blInvIfDt;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
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
	 * @return glEffDt
	 */
	public String getGlEffDt() {
		return this.glEffDt;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return trspRqstOrdFlg
	 */
	public String getTrspRqstOrdFlg() {
		return this.trspRqstOrdFlg;
	}
	
	/**
	 * Column Info
	 * @return blInvIfFlg
	 */
	public String getBlInvIfFlg() {
		return this.blInvIfFlg;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return invSrcNo
	 */
	public String getInvSrcNo() {
		return this.invSrcNo;
	}
	
	/**
	 * Column Info
	 * @return apArOffstNo
	 */
	public String getApArOffstNo() {
		return this.apArOffstNo;
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
	 * @return invRmk
	 */
	public String getInvRmk() {
		return this.invRmk;
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
	 * @param srcIfSeq
	 */
	public void setSrcIfSeq(String srcIfSeq) {
		this.srcIfSeq = srcIfSeq;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param srcIfDt
	 */
	public void setSrcIfDt(String srcIfDt) {
		this.srcIfDt = srcIfDt;
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
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
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
	 * Column Info
	 * @param destTrnsSvcModCd
	 */
	public void setDestTrnsSvcModCd(String destTrnsSvcModCd) {
		this.destTrnsSvcModCd = destTrnsSvcModCd;
	}
	
	/**
	 * Column Info
	 * @param ifSrcCd
	 */
	public void setIfSrcCd(String ifSrcCd) {
		this.ifSrcCd = ifSrcCd;
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
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param cgoWgt
	 */
	public void setCgoWgt(String cgoWgt) {
		this.cgoWgt = cgoWgt;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param sailDt
	 */
	public void setSailDt(String sailDt) {
		this.sailDt = sailDt;
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
	 * @param whfDeclVoyNo
	 */
	public void setWhfDeclVoyNo(String whfDeclVoyNo) {
		this.whfDeclVoyNo = whfDeclVoyNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param trnkSkdVoyNo
	 */
	public void setTrnkSkdVoyNo(String trnkSkdVoyNo) {
		this.trnkSkdVoyNo = trnkSkdVoyNo;
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
	 * @param whfDeclCfmDt
	 */
	public void setWhfDeclCfmDt(String whfDeclCfmDt) {
		this.whfDeclCfmDt = whfDeclCfmDt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
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
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param blInvIfDt
	 */
	public void setBlInvIfDt(String blInvIfDt) {
		this.blInvIfDt = blInvIfDt;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
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
	 * @param glEffDt
	 */
	public void setGlEffDt(String glEffDt) {
		this.glEffDt = glEffDt;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param trspRqstOrdFlg
	 */
	public void setTrspRqstOrdFlg(String trspRqstOrdFlg) {
		this.trspRqstOrdFlg = trspRqstOrdFlg;
	}
	
	/**
	 * Column Info
	 * @param blInvIfFlg
	 */
	public void setBlInvIfFlg(String blInvIfFlg) {
		this.blInvIfFlg = blInvIfFlg;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param invSrcNo
	 */
	public void setInvSrcNo(String invSrcNo) {
		this.invSrcNo = invSrcNo;
	}
	
	/**
	 * Column Info
	 * @param apArOffstNo
	 */
	public void setApArOffstNo(String apArOffstNo) {
		this.apArOffstNo = apArOffstNo;
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
	 * @param invRmk
	 */
	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
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
		setSrcIfSeq(JSPUtil.getParameter(request, "src_if_seq", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setSrcIfDt(JSPUtil.getParameter(request, "src_if_dt", ""));
		setWhfDeclNo(JSPUtil.getParameter(request, "whf_decl_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSrepCd(JSPUtil.getParameter(request, "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setDestTrnsSvcModCd(JSPUtil.getParameter(request, "dest_trns_svc_mod_cd", ""));
		setIfSrcCd(JSPUtil.getParameter(request, "if_src_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, "sls_ofc_cd", ""));
		setMstBlNo(JSPUtil.getParameter(request, "mst_bl_no", ""));
		setVvdTrnsFlg(JSPUtil.getParameter(request, "vvd_trns_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCgoWgt(JSPUtil.getParameter(request, "cgo_wgt", ""));
		setBkgCorrNo(JSPUtil.getParameter(request, "bkg_corr_no", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setWhfDeclDirCd(JSPUtil.getParameter(request, "whf_decl_dir_cd", ""));
		setFrtFwrdCustSeq(JSPUtil.getParameter(request, "frt_fwrd_cust_seq", ""));
		setSailDt(JSPUtil.getParameter(request, "sail_dt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setWhfDeclVoyNo(JSPUtil.getParameter(request, "whf_decl_voy_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSiRefNo(JSPUtil.getParameter(request, "si_ref_no", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setTrnkVslCd(JSPUtil.getParameter(request, "trnk_vsl_cd", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, "bkg_teu_qty", ""));
		setTrnkSkdVoyNo(JSPUtil.getParameter(request, "trnk_skd_voy_no", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setWhfDeclCfmDt(JSPUtil.getParameter(request, "whf_decl_cfm_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setWhfDeclOfcCd(JSPUtil.getParameter(request, "whf_decl_ofc_cd", ""));
		setTrnkSkdDirCd(JSPUtil.getParameter(request, "trnk_skd_dir_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, "bkg_feu_qty", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setWhfDeclVslCd(JSPUtil.getParameter(request, "whf_decl_vsl_cd", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setBkgCorrDt(JSPUtil.getParameter(request, "bkg_corr_dt", ""));
		setCgoMeasQty(JSPUtil.getParameter(request, "cgo_meas_qty", ""));
		setBlInvIfDt(JSPUtil.getParameter(request, "bl_inv_if_dt", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setWhfMrnNo(JSPUtil.getParameter(request, "whf_mrn_no", ""));
		setInvRefNo(JSPUtil.getParameter(request, "inv_ref_no", ""));
		setGlEffDt(JSPUtil.getParameter(request, "gl_eff_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setTrspRqstOrdFlg(JSPUtil.getParameter(request, "trsp_rqst_ord_flg", ""));
		setBlInvIfFlg(JSPUtil.getParameter(request, "bl_inv_if_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setBkgRefNo(JSPUtil.getParameter(request, "bkg_ref_no", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setInvSrcNo(JSPUtil.getParameter(request, "inv_src_no", ""));
		setApArOffstNo(JSPUtil.getParameter(request, "ap_ar_offst_no", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setInvRmk(JSPUtil.getParameter(request, "inv_rmk", ""));
		setFrtFwrdCntCd(JSPUtil.getParameter(request, "frt_fwrd_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvArIfMnVO[]
	 */
	public InvArIfMnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvArIfMnVO[]
	 */
	public InvArIfMnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvArIfMnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] srcIfSeq = (JSPUtil.getParameter(request, prefix	+ "src_if_seq", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] srcIfDt = (JSPUtil.getParameter(request, prefix	+ "src_if_dt", length));
			String[] whfDeclNo = (JSPUtil.getParameter(request, prefix	+ "whf_decl_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] destTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_svc_mod_cd", length));
			String[] ifSrcCd = (JSPUtil.getParameter(request, prefix	+ "if_src_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] mstBlNo = (JSPUtil.getParameter(request, prefix	+ "mst_bl_no", length));
			String[] vvdTrnsFlg = (JSPUtil.getParameter(request, prefix	+ "vvd_trns_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt", length));
			String[] bkgCorrNo = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_no", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] whfDeclDirCd = (JSPUtil.getParameter(request, prefix	+ "whf_decl_dir_cd", length));
			String[] frtFwrdCustSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cust_seq", length));
			String[] sailDt = (JSPUtil.getParameter(request, prefix	+ "sail_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] whfDeclVoyNo = (JSPUtil.getParameter(request, prefix	+ "whf_decl_voy_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] siRefNo = (JSPUtil.getParameter(request, prefix	+ "si_ref_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] trnkVslCd = (JSPUtil.getParameter(request, prefix	+ "trnk_vsl_cd", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] trnkSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_voy_no", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] whfDeclCfmDt = (JSPUtil.getParameter(request, prefix	+ "whf_decl_cfm_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] whfDeclOfcCd = (JSPUtil.getParameter(request, prefix	+ "whf_decl_ofc_cd", length));
			String[] trnkSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_dir_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] whfDeclVslCd = (JSPUtil.getParameter(request, prefix	+ "whf_decl_vsl_cd", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bkgCorrDt = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_dt", length));
			String[] cgoMeasQty = (JSPUtil.getParameter(request, prefix	+ "cgo_meas_qty", length));
			String[] blInvIfDt = (JSPUtil.getParameter(request, prefix	+ "bl_inv_if_dt", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] whfMrnNo = (JSPUtil.getParameter(request, prefix	+ "whf_mrn_no", length));
			String[] invRefNo = (JSPUtil.getParameter(request, prefix	+ "inv_ref_no", length));
			String[] glEffDt = (JSPUtil.getParameter(request, prefix	+ "gl_eff_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] trspRqstOrdFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_rqst_ord_flg", length));
			String[] blInvIfFlg = (JSPUtil.getParameter(request, prefix	+ "bl_inv_if_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] bkgRefNo = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] invSrcNo = (JSPUtil.getParameter(request, prefix	+ "inv_src_no", length));
			String[] apArOffstNo = (JSPUtil.getParameter(request, prefix	+ "ap_ar_offst_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] frtFwrdCntCd = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvArIfMnVO();
				if (srcIfSeq[i] != null)
					model.setSrcIfSeq(srcIfSeq[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (srcIfDt[i] != null)
					model.setSrcIfDt(srcIfDt[i]);
				if (whfDeclNo[i] != null)
					model.setWhfDeclNo(whfDeclNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (destTrnsSvcModCd[i] != null)
					model.setDestTrnsSvcModCd(destTrnsSvcModCd[i]);
				if (ifSrcCd[i] != null)
					model.setIfSrcCd(ifSrcCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (mstBlNo[i] != null)
					model.setMstBlNo(mstBlNo[i]);
				if (vvdTrnsFlg[i] != null)
					model.setVvdTrnsFlg(vvdTrnsFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				if (bkgCorrNo[i] != null)
					model.setBkgCorrNo(bkgCorrNo[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (whfDeclDirCd[i] != null)
					model.setWhfDeclDirCd(whfDeclDirCd[i]);
				if (frtFwrdCustSeq[i] != null)
					model.setFrtFwrdCustSeq(frtFwrdCustSeq[i]);
				if (sailDt[i] != null)
					model.setSailDt(sailDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (whfDeclVoyNo[i] != null)
					model.setWhfDeclVoyNo(whfDeclVoyNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (siRefNo[i] != null)
					model.setSiRefNo(siRefNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (trnkVslCd[i] != null)
					model.setTrnkVslCd(trnkVslCd[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (trnkSkdVoyNo[i] != null)
					model.setTrnkSkdVoyNo(trnkSkdVoyNo[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (whfDeclCfmDt[i] != null)
					model.setWhfDeclCfmDt(whfDeclCfmDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (whfDeclOfcCd[i] != null)
					model.setWhfDeclOfcCd(whfDeclOfcCd[i]);
				if (trnkSkdDirCd[i] != null)
					model.setTrnkSkdDirCd(trnkSkdDirCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (whfDeclVslCd[i] != null)
					model.setWhfDeclVslCd(whfDeclVslCd[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bkgCorrDt[i] != null)
					model.setBkgCorrDt(bkgCorrDt[i]);
				if (cgoMeasQty[i] != null)
					model.setCgoMeasQty(cgoMeasQty[i]);
				if (blInvIfDt[i] != null)
					model.setBlInvIfDt(blInvIfDt[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (whfMrnNo[i] != null)
					model.setWhfMrnNo(whfMrnNo[i]);
				if (invRefNo[i] != null)
					model.setInvRefNo(invRefNo[i]);
				if (glEffDt[i] != null)
					model.setGlEffDt(glEffDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (trspRqstOrdFlg[i] != null)
					model.setTrspRqstOrdFlg(trspRqstOrdFlg[i]);
				if (blInvIfFlg[i] != null)
					model.setBlInvIfFlg(blInvIfFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (bkgRefNo[i] != null)
					model.setBkgRefNo(bkgRefNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (invSrcNo[i] != null)
					model.setInvSrcNo(invSrcNo[i]);
				if (apArOffstNo[i] != null)
					model.setApArOffstNo(apArOffstNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (frtFwrdCntCd[i] != null)
					model.setFrtFwrdCntCd(frtFwrdCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvArIfMnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvArIfMnVO[]
	 */
	public InvArIfMnVO[] getInvArIfMnVOs(){
		InvArIfMnVO[] vos = (InvArIfMnVO[])models.toArray(new InvArIfMnVO[models.size()]);
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
		this.srcIfSeq = this.srcIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcIfDt = this.srcIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclNo = this.whfDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsSvcModCd = this.destTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSrcCd = this.ifSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBlNo = this.mstBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdTrnsFlg = this.vvdTrnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrNo = this.bkgCorrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclDirCd = this.whfDeclDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCustSeq = this.frtFwrdCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt = this.sailDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclVoyNo = this.whfDeclVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siRefNo = this.siRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVslCd = this.trnkVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdVoyNo = this.trnkSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclCfmDt = this.whfDeclCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclOfcCd = this.whfDeclOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdDirCd = this.trnkSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclVslCd = this.whfDeclVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrDt = this.bkgCorrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoMeasQty = this.cgoMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvIfDt = this.blInvIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfMrnNo = this.whfMrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo = this.invRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt = this.glEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRqstOrdFlg = this.trspRqstOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvIfFlg = this.blInvIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo = this.bkgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSrcNo = this.invSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apArOffstNo = this.apArOffstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntCd = this.frtFwrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
