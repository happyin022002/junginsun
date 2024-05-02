/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvBkgIfMnVO.java
*@FileTitle : InvBkgIfMnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.29
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.01.29 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

import java.lang.reflect.Field;
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

public class InvBkgIfMnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvBkgIfMnVO> models = new ArrayList<InvBkgIfMnVO>();
	
	/* Column Info */
	private String bkgTms = null;
	/* Column Info */
	private String polVslCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String srcIfDt = null;
	/* Column Info */
	private String whfDeclNo = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podVslCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String mstBlNo = null;
	/* Column Info */
	private String podSkdDirCd = null;
	/* Column Info */
	private String chnAgnCd = null;
	/* Column Info */
	private String podSkdVoyNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cgoWgt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String bkgCorrNo = null;
	/* Column Info */
	private String destSvcModCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String troPayrCntCd = null;
	/* Column Info */
	private String whfNtcNo = null;
	/* Column Info */
	private String whfDeclDirCd = null;
	/* Column Info */
	private String frtFwrdCustSeq = null;
	/* Column Info */
	private String whfDeclVoyNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String troIoBndCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String siRefNo = null;
	/* Column Info */
	private String trnkVslCd = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String trnkSkdVoyNo = null;
	/* Column Info */
	private String whfDeclCfmDt = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String polSkdDirCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String whfDeclOfcCd = null;
	/* Column Info */
	private String autoMnlDivCd = null;
	/* Column Info */
	private String invArIfCd = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String trnkSkdDirCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* Column Info */
	private String troPayrSeq = null;
	/* Column Info */
	private String whfDeclVslCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String caRsnCd = null;
	/* Column Info */
	private String bkgCorrDt = null;
	/* Column Info */
	private String cgoMeasQty = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String whfMrnNo = null;
	/* Column Info */
	private String invRefNo = null;
	/* Column Info */
	private String cxlDt = null;
	/* Column Info */
	private String polSkdVoyNo = null;
	/* Column Info */
	private String bkgSeq = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String bkgRefNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String arIfErrRsn = null;
	/* Column Info */
	private String bdrIndFlg = null;
	/* Column Info */
	private String frtFwrdCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvBkgIfMnVO() {}

	public InvBkgIfMnVO(String ibflag, String pagerows, String bkgNo, String bkgSeq, String bkgTms, String srcIfDt, String blSrcNo, String blTpCd, String bkgStsCd, String cxlFlg, String cxlDt, String bdrIndFlg, String bkgCorrNo, String bkgCorrDt, String caRsnCd, String slanCd, String trnkVslCd, String trnkSkdVoyNo, String trnkSkdDirCd, String revDirCd, String porCd, String polCd, String podCd, String delCd, String cgoWgt, String cgoMeasQty, String srepCd, String destSvcModCd, String mstBlNo, String svcScpCd, String bkgRefNo, String invRefNo, String siRefNo, String autoMnlDivCd, String frtFwrdCntCd, String frtFwrdCustSeq, String scNo, String rfaNo, String bkgTeuQty, String bkgFeuQty, String polVslCd, String polSkdVoyNo, String polSkdDirCd, String podVslCd, String podSkdVoyNo, String podSkdDirCd, String troPayrCntCd, String troPayrSeq, String troIoBndCd, String whfDeclNo, String whfDeclCfmDt, String whfDeclOfcCd, String whfMrnNo, String whfNtcNo, String whfDeclVslCd, String whfDeclVoyNo, String whfDeclDirCd, String csrNo, String chnAgnCd, String invArIfCd, String arIfErrRsn, String creUsrId, String creDt, String updUsrId, String updDt, String ctrtOfcCd) {
		this.bkgTms = bkgTms;
		this.polVslCd = polVslCd;
		this.svcScpCd = svcScpCd;
		this.cxlFlg = cxlFlg;
		this.srcIfDt = srcIfDt;
		this.whfDeclNo = whfDeclNo;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.podVslCd = podVslCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.scNo = scNo;
		this.mstBlNo = mstBlNo;
		this.podSkdDirCd = podSkdDirCd;
		this.chnAgnCd = chnAgnCd;
		this.podSkdVoyNo = podSkdVoyNo;
		this.updUsrId = updUsrId;
		this.cgoWgt = cgoWgt;
		this.csrNo = csrNo;
		this.bkgCorrNo = bkgCorrNo;
		this.destSvcModCd = destSvcModCd;
		this.delCd = delCd;
		this.troPayrCntCd = troPayrCntCd;
		this.whfNtcNo = whfNtcNo;
		this.whfDeclDirCd = whfDeclDirCd;
		this.frtFwrdCustSeq = frtFwrdCustSeq;
		this.whfDeclVoyNo = whfDeclVoyNo;
		this.podCd = podCd;
		this.troIoBndCd = troIoBndCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.siRefNo = siRefNo;
		this.trnkVslCd = trnkVslCd;
		this.bkgTeuQty = bkgTeuQty;
		this.trnkSkdVoyNo = trnkSkdVoyNo;
		this.whfDeclCfmDt = whfDeclCfmDt;
		this.porCd = porCd;
		this.bkgStsCd = bkgStsCd;
		this.polSkdDirCd = polSkdDirCd;
		this.creDt = creDt;
		this.whfDeclOfcCd = whfDeclOfcCd;
		this.autoMnlDivCd = autoMnlDivCd;
		this.invArIfCd = invArIfCd;
		this.revDirCd = revDirCd;
		this.trnkSkdDirCd = trnkSkdDirCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.bkgFeuQty = bkgFeuQty;
		this.troPayrSeq = troPayrSeq;
		this.whfDeclVslCd = whfDeclVslCd;
		this.updDt = updDt;
		this.caRsnCd = caRsnCd;
		this.bkgCorrDt = bkgCorrDt;
		this.cgoMeasQty = cgoMeasQty;
		this.blSrcNo = blSrcNo;
		this.whfMrnNo = whfMrnNo;
		this.invRefNo = invRefNo;
		this.cxlDt = cxlDt;
		this.polSkdVoyNo = polSkdVoyNo;
		this.bkgSeq = bkgSeq;
		this.blTpCd = blTpCd;
		this.bkgRefNo = bkgRefNo;
		this.slanCd = slanCd;
		this.arIfErrRsn = arIfErrRsn;
		this.bdrIndFlg = bdrIndFlg;
		this.frtFwrdCntCd = frtFwrdCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_tms", getBkgTms());
		this.hashColumns.put("pol_vsl_cd", getPolVslCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("src_if_dt", getSrcIfDt());
		this.hashColumns.put("whf_decl_no", getWhfDeclNo());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_vsl_cd", getPodVslCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("mst_bl_no", getMstBlNo());
		this.hashColumns.put("pod_skd_dir_cd", getPodSkdDirCd());
		this.hashColumns.put("chn_agn_cd", getChnAgnCd());
		this.hashColumns.put("pod_skd_voy_no", getPodSkdVoyNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("bkg_corr_no", getBkgCorrNo());
		this.hashColumns.put("dest_svc_mod_cd", getDestSvcModCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("tro_payr_cnt_cd", getTroPayrCntCd());
		this.hashColumns.put("whf_ntc_no", getWhfNtcNo());
		this.hashColumns.put("whf_decl_dir_cd", getWhfDeclDirCd());
		this.hashColumns.put("frt_fwrd_cust_seq", getFrtFwrdCustSeq());
		this.hashColumns.put("whf_decl_voy_no", getWhfDeclVoyNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("tro_io_bnd_cd", getTroIoBndCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("si_ref_no", getSiRefNo());
		this.hashColumns.put("trnk_vsl_cd", getTrnkVslCd());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("trnk_skd_voy_no", getTrnkSkdVoyNo());
		this.hashColumns.put("whf_decl_cfm_dt", getWhfDeclCfmDt());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("pol_skd_dir_cd", getPolSkdDirCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("whf_decl_ofc_cd", getWhfDeclOfcCd());
		this.hashColumns.put("auto_mnl_div_cd", getAutoMnlDivCd());
		this.hashColumns.put("inv_ar_if_cd", getInvArIfCd());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("trnk_skd_dir_cd", getTrnkSkdDirCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("tro_payr_seq", getTroPayrSeq());
		this.hashColumns.put("whf_decl_vsl_cd", getWhfDeclVslCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ca_rsn_cd", getCaRsnCd());
		this.hashColumns.put("bkg_corr_dt", getBkgCorrDt());
		this.hashColumns.put("cgo_meas_qty", getCgoMeasQty());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("whf_mrn_no", getWhfMrnNo());
		this.hashColumns.put("inv_ref_no", getInvRefNo());
		this.hashColumns.put("cxl_dt", getCxlDt());
		this.hashColumns.put("pol_skd_voy_no", getPolSkdVoyNo());
		this.hashColumns.put("bkg_seq", getBkgSeq());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("ar_if_err_rsn", getArIfErrRsn());
		this.hashColumns.put("bdr_ind_flg", getBdrIndFlg());
		this.hashColumns.put("frt_fwrd_cnt_cd", getFrtFwrdCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_tms", "bkgTms");
		this.hashFields.put("pol_vsl_cd", "polVslCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("src_if_dt", "srcIfDt");
		this.hashFields.put("whf_decl_no", "whfDeclNo");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_vsl_cd", "podVslCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("mst_bl_no", "mstBlNo");
		this.hashFields.put("pod_skd_dir_cd", "podSkdDirCd");
		this.hashFields.put("chn_agn_cd", "chnAgnCd");
		this.hashFields.put("pod_skd_voy_no", "podSkdVoyNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cgo_wgt", "cgoWgt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("bkg_corr_no", "bkgCorrNo");
		this.hashFields.put("dest_svc_mod_cd", "destSvcModCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("tro_payr_cnt_cd", "troPayrCntCd");
		this.hashFields.put("whf_ntc_no", "whfNtcNo");
		this.hashFields.put("whf_decl_dir_cd", "whfDeclDirCd");
		this.hashFields.put("frt_fwrd_cust_seq", "frtFwrdCustSeq");
		this.hashFields.put("whf_decl_voy_no", "whfDeclVoyNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("tro_io_bnd_cd", "troIoBndCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("si_ref_no", "siRefNo");
		this.hashFields.put("trnk_vsl_cd", "trnkVslCd");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("trnk_skd_voy_no", "trnkSkdVoyNo");
		this.hashFields.put("whf_decl_cfm_dt", "whfDeclCfmDt");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("pol_skd_dir_cd", "polSkdDirCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("whf_decl_ofc_cd", "whfDeclOfcCd");
		this.hashFields.put("auto_mnl_div_cd", "autoMnlDivCd");
		this.hashFields.put("inv_ar_if_cd", "invArIfCd");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("trnk_skd_dir_cd", "trnkSkdDirCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("tro_payr_seq", "troPayrSeq");
		this.hashFields.put("whf_decl_vsl_cd", "whfDeclVslCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ca_rsn_cd", "caRsnCd");
		this.hashFields.put("bkg_corr_dt", "bkgCorrDt");
		this.hashFields.put("cgo_meas_qty", "cgoMeasQty");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("whf_mrn_no", "whfMrnNo");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("cxl_dt", "cxlDt");
		this.hashFields.put("pol_skd_voy_no", "polSkdVoyNo");
		this.hashFields.put("bkg_seq", "bkgSeq");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("ar_if_err_rsn", "arIfErrRsn");
		this.hashFields.put("bdr_ind_flg", "bdrIndFlg");
		this.hashFields.put("frt_fwrd_cnt_cd", "frtFwrdCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgTms
	 */
	public String getBkgTms() {
		return this.bkgTms;
	}
	
	/**
	 * Column Info
	 * @return polVslCd
	 */
	public String getPolVslCd() {
		return this.polVslCd;
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
	 * @return cxlFlg
	 */
	public String getCxlFlg() {
		return this.cxlFlg;
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
	 * @return podVslCd
	 */
	public String getPodVslCd() {
		return this.podVslCd;
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
	 * @return podSkdDirCd
	 */
	public String getPodSkdDirCd() {
		return this.podSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return chnAgnCd
	 */
	public String getChnAgnCd() {
		return this.chnAgnCd;
	}
	
	/**
	 * Column Info
	 * @return podSkdVoyNo
	 */
	public String getPodSkdVoyNo() {
		return this.podSkdVoyNo;
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
	 * @return troPayrCntCd
	 */
	public String getTroPayrCntCd() {
		return this.troPayrCntCd;
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
	 * @return whfDeclVoyNo
	 */
	public String getWhfDeclVoyNo() {
		return this.whfDeclVoyNo;
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
	 * @return troIoBndCd
	 */
	public String getTroIoBndCd() {
		return this.troIoBndCd;
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
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return polSkdDirCd
	 */
	public String getPolSkdDirCd() {
		return this.polSkdDirCd;
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
	 * @return autoMnlDivCd
	 */
	public String getAutoMnlDivCd() {
		return this.autoMnlDivCd;
	}
	
	/**
	 * Column Info
	 * @return invArIfCd
	 */
	public String getInvArIfCd() {
		return this.invArIfCd;
	}
	
	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
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
	 * @return troPayrSeq
	 */
	public String getTroPayrSeq() {
		return this.troPayrSeq;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return cxlDt
	 */
	public String getCxlDt() {
		return this.cxlDt;
	}
	
	/**
	 * Column Info
	 * @return polSkdVoyNo
	 */
	public String getPolSkdVoyNo() {
		return this.polSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return bkgSeq
	 */
	public String getBkgSeq() {
		return this.bkgSeq;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return arIfErrRsn
	 */
	public String getArIfErrRsn() {
		return this.arIfErrRsn;
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
	 * @return frtFwrdCntCd
	 */
	public String getFrtFwrdCntCd() {
		return this.frtFwrdCntCd;
	}
	

	/**
	 * Column Info
	 * @param bkgTms
	 */
	public void setBkgTms(String bkgTms) {
		this.bkgTms = bkgTms;
	}
	
	/**
	 * Column Info
	 * @param polVslCd
	 */
	public void setPolVslCd(String polVslCd) {
		this.polVslCd = polVslCd;
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
	 * @param cxlFlg
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
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
	 * @param podVslCd
	 */
	public void setPodVslCd(String podVslCd) {
		this.podVslCd = podVslCd;
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
	 * @param podSkdDirCd
	 */
	public void setPodSkdDirCd(String podSkdDirCd) {
		this.podSkdDirCd = podSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param chnAgnCd
	 */
	public void setChnAgnCd(String chnAgnCd) {
		this.chnAgnCd = chnAgnCd;
	}
	
	/**
	 * Column Info
	 * @param podSkdVoyNo
	 */
	public void setPodSkdVoyNo(String podSkdVoyNo) {
		this.podSkdVoyNo = podSkdVoyNo;
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
	 * @param troPayrCntCd
	 */
	public void setTroPayrCntCd(String troPayrCntCd) {
		this.troPayrCntCd = troPayrCntCd;
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
	 * @param whfDeclVoyNo
	 */
	public void setWhfDeclVoyNo(String whfDeclVoyNo) {
		this.whfDeclVoyNo = whfDeclVoyNo;
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
	 * @param troIoBndCd
	 */
	public void setTroIoBndCd(String troIoBndCd) {
		this.troIoBndCd = troIoBndCd;
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
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param polSkdDirCd
	 */
	public void setPolSkdDirCd(String polSkdDirCd) {
		this.polSkdDirCd = polSkdDirCd;
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
	 * @param autoMnlDivCd
	 */
	public void setAutoMnlDivCd(String autoMnlDivCd) {
		this.autoMnlDivCd = autoMnlDivCd;
	}
	
	/**
	 * Column Info
	 * @param invArIfCd
	 */
	public void setInvArIfCd(String invArIfCd) {
		this.invArIfCd = invArIfCd;
	}
	
	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
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
	 * @param troPayrSeq
	 */
	public void setTroPayrSeq(String troPayrSeq) {
		this.troPayrSeq = troPayrSeq;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param cxlDt
	 */
	public void setCxlDt(String cxlDt) {
		this.cxlDt = cxlDt;
	}
	
	/**
	 * Column Info
	 * @param polSkdVoyNo
	 */
	public void setPolSkdVoyNo(String polSkdVoyNo) {
		this.polSkdVoyNo = polSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param bkgSeq
	 */
	public void setBkgSeq(String bkgSeq) {
		this.bkgSeq = bkgSeq;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param arIfErrRsn
	 */
	public void setArIfErrRsn(String arIfErrRsn) {
		this.arIfErrRsn = arIfErrRsn;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setBkgTms(JSPUtil.getParameter(request, prefix + "bkg_tms", ""));
		setPolVslCd(JSPUtil.getParameter(request, prefix + "pol_vsl_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCxlFlg(JSPUtil.getParameter(request, prefix + "cxl_flg", ""));
		setSrcIfDt(JSPUtil.getParameter(request, prefix + "src_if_dt", ""));
		setWhfDeclNo(JSPUtil.getParameter(request, prefix + "whf_decl_no", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPodVslCd(JSPUtil.getParameter(request, prefix + "pod_vsl_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setMstBlNo(JSPUtil.getParameter(request, prefix + "mst_bl_no", ""));
		setPodSkdDirCd(JSPUtil.getParameter(request, prefix + "pod_skd_dir_cd", ""));
		setChnAgnCd(JSPUtil.getParameter(request, prefix + "chn_agn_cd", ""));
		setPodSkdVoyNo(JSPUtil.getParameter(request, prefix + "pod_skd_voy_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCgoWgt(JSPUtil.getParameter(request, prefix + "cgo_wgt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setBkgCorrNo(JSPUtil.getParameter(request, prefix + "bkg_corr_no", ""));
		setDestSvcModCd(JSPUtil.getParameter(request, prefix + "dest_svc_mod_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setTroPayrCntCd(JSPUtil.getParameter(request, prefix + "tro_payr_cnt_cd", ""));
		setWhfNtcNo(JSPUtil.getParameter(request, prefix + "whf_ntc_no", ""));
		setWhfDeclDirCd(JSPUtil.getParameter(request, prefix + "whf_decl_dir_cd", ""));
		setFrtFwrdCustSeq(JSPUtil.getParameter(request, prefix + "frt_fwrd_cust_seq", ""));
		setWhfDeclVoyNo(JSPUtil.getParameter(request, prefix + "whf_decl_voy_no", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setTroIoBndCd(JSPUtil.getParameter(request, prefix + "tro_io_bnd_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSiRefNo(JSPUtil.getParameter(request, prefix + "si_ref_no", ""));
		setTrnkVslCd(JSPUtil.getParameter(request, prefix + "trnk_vsl_cd", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, prefix + "bkg_teu_qty", ""));
		setTrnkSkdVoyNo(JSPUtil.getParameter(request, prefix + "trnk_skd_voy_no", ""));
		setWhfDeclCfmDt(JSPUtil.getParameter(request, prefix + "whf_decl_cfm_dt", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setPolSkdDirCd(JSPUtil.getParameter(request, prefix + "pol_skd_dir_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setWhfDeclOfcCd(JSPUtil.getParameter(request, prefix + "whf_decl_ofc_cd", ""));
		setAutoMnlDivCd(JSPUtil.getParameter(request, prefix + "auto_mnl_div_cd", ""));
		setInvArIfCd(JSPUtil.getParameter(request, prefix + "inv_ar_if_cd", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setTrnkSkdDirCd(JSPUtil.getParameter(request, prefix + "trnk_skd_dir_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, prefix + "bkg_feu_qty", ""));
		setTroPayrSeq(JSPUtil.getParameter(request, prefix + "tro_payr_seq", ""));
		setWhfDeclVslCd(JSPUtil.getParameter(request, prefix + "whf_decl_vsl_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCaRsnCd(JSPUtil.getParameter(request, prefix + "ca_rsn_cd", ""));
		setBkgCorrDt(JSPUtil.getParameter(request, prefix + "bkg_corr_dt", ""));
		setCgoMeasQty(JSPUtil.getParameter(request, prefix + "cgo_meas_qty", ""));
		setBlSrcNo(JSPUtil.getParameter(request, prefix + "bl_src_no", ""));
		setWhfMrnNo(JSPUtil.getParameter(request, prefix + "whf_mrn_no", ""));
		setInvRefNo(JSPUtil.getParameter(request, prefix + "inv_ref_no", ""));
		setCxlDt(JSPUtil.getParameter(request, prefix + "cxl_dt", ""));
		setPolSkdVoyNo(JSPUtil.getParameter(request, prefix + "pol_skd_voy_no", ""));
		setBkgSeq(JSPUtil.getParameter(request, prefix + "bkg_seq", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setBkgRefNo(JSPUtil.getParameter(request, prefix + "bkg_ref_no", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setArIfErrRsn(JSPUtil.getParameter(request, prefix + "ar_if_err_rsn", ""));
		setBdrIndFlg(JSPUtil.getParameter(request, prefix + "bdr_ind_flg", ""));
		setFrtFwrdCntCd(JSPUtil.getParameter(request, prefix + "frt_fwrd_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvBkgIfMnVO[]
	 */
	public InvBkgIfMnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvBkgIfMnVO[]
	 */
	public InvBkgIfMnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvBkgIfMnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgTms = (JSPUtil.getParameter(request, prefix	+ "bkg_tms", length));
			String[] polVslCd = (JSPUtil.getParameter(request, prefix	+ "pol_vsl_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] srcIfDt = (JSPUtil.getParameter(request, prefix	+ "src_if_dt", length));
			String[] whfDeclNo = (JSPUtil.getParameter(request, prefix	+ "whf_decl_no", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podVslCd = (JSPUtil.getParameter(request, prefix	+ "pod_vsl_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] mstBlNo = (JSPUtil.getParameter(request, prefix	+ "mst_bl_no", length));
			String[] podSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "pod_skd_dir_cd", length));
			String[] chnAgnCd = (JSPUtil.getParameter(request, prefix	+ "chn_agn_cd", length));
			String[] podSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "pod_skd_voy_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] bkgCorrNo = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_no", length));
			String[] destSvcModCd = (JSPUtil.getParameter(request, prefix	+ "dest_svc_mod_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] troPayrCntCd = (JSPUtil.getParameter(request, prefix	+ "tro_payr_cnt_cd", length));
			String[] whfNtcNo = (JSPUtil.getParameter(request, prefix	+ "whf_ntc_no", length));
			String[] whfDeclDirCd = (JSPUtil.getParameter(request, prefix	+ "whf_decl_dir_cd", length));
			String[] frtFwrdCustSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cust_seq", length));
			String[] whfDeclVoyNo = (JSPUtil.getParameter(request, prefix	+ "whf_decl_voy_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] troIoBndCd = (JSPUtil.getParameter(request, prefix	+ "tro_io_bnd_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] siRefNo = (JSPUtil.getParameter(request, prefix	+ "si_ref_no", length));
			String[] trnkVslCd = (JSPUtil.getParameter(request, prefix	+ "trnk_vsl_cd", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] trnkSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_voy_no", length));
			String[] whfDeclCfmDt = (JSPUtil.getParameter(request, prefix	+ "whf_decl_cfm_dt", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] polSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "pol_skd_dir_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] whfDeclOfcCd = (JSPUtil.getParameter(request, prefix	+ "whf_decl_ofc_cd", length));
			String[] autoMnlDivCd = (JSPUtil.getParameter(request, prefix	+ "auto_mnl_div_cd", length));
			String[] invArIfCd = (JSPUtil.getParameter(request, prefix	+ "inv_ar_if_cd", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] trnkSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_dir_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty", length));
			String[] troPayrSeq = (JSPUtil.getParameter(request, prefix	+ "tro_payr_seq", length));
			String[] whfDeclVslCd = (JSPUtil.getParameter(request, prefix	+ "whf_decl_vsl_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] caRsnCd = (JSPUtil.getParameter(request, prefix	+ "ca_rsn_cd", length));
			String[] bkgCorrDt = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_dt", length));
			String[] cgoMeasQty = (JSPUtil.getParameter(request, prefix	+ "cgo_meas_qty", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] whfMrnNo = (JSPUtil.getParameter(request, prefix	+ "whf_mrn_no", length));
			String[] invRefNo = (JSPUtil.getParameter(request, prefix	+ "inv_ref_no", length));
			String[] cxlDt = (JSPUtil.getParameter(request, prefix	+ "cxl_dt", length));
			String[] polSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "pol_skd_voy_no", length));
			String[] bkgSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_seq", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] bkgRefNo = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] arIfErrRsn = (JSPUtil.getParameter(request, prefix	+ "ar_if_err_rsn", length));
			String[] bdrIndFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_ind_flg", length));
			String[] frtFwrdCntCd = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvBkgIfMnVO();
				if (bkgTms[i] != null)
					model.setBkgTms(bkgTms[i]);
				if (polVslCd[i] != null)
					model.setPolVslCd(polVslCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (srcIfDt[i] != null)
					model.setSrcIfDt(srcIfDt[i]);
				if (whfDeclNo[i] != null)
					model.setWhfDeclNo(whfDeclNo[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podVslCd[i] != null)
					model.setPodVslCd(podVslCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (mstBlNo[i] != null)
					model.setMstBlNo(mstBlNo[i]);
				if (podSkdDirCd[i] != null)
					model.setPodSkdDirCd(podSkdDirCd[i]);
				if (chnAgnCd[i] != null)
					model.setChnAgnCd(chnAgnCd[i]);
				if (podSkdVoyNo[i] != null)
					model.setPodSkdVoyNo(podSkdVoyNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (bkgCorrNo[i] != null)
					model.setBkgCorrNo(bkgCorrNo[i]);
				if (destSvcModCd[i] != null)
					model.setDestSvcModCd(destSvcModCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (troPayrCntCd[i] != null)
					model.setTroPayrCntCd(troPayrCntCd[i]);
				if (whfNtcNo[i] != null)
					model.setWhfNtcNo(whfNtcNo[i]);
				if (whfDeclDirCd[i] != null)
					model.setWhfDeclDirCd(whfDeclDirCd[i]);
				if (frtFwrdCustSeq[i] != null)
					model.setFrtFwrdCustSeq(frtFwrdCustSeq[i]);
				if (whfDeclVoyNo[i] != null)
					model.setWhfDeclVoyNo(whfDeclVoyNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (troIoBndCd[i] != null)
					model.setTroIoBndCd(troIoBndCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (siRefNo[i] != null)
					model.setSiRefNo(siRefNo[i]);
				if (trnkVslCd[i] != null)
					model.setTrnkVslCd(trnkVslCd[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (trnkSkdVoyNo[i] != null)
					model.setTrnkSkdVoyNo(trnkSkdVoyNo[i]);
				if (whfDeclCfmDt[i] != null)
					model.setWhfDeclCfmDt(whfDeclCfmDt[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (polSkdDirCd[i] != null)
					model.setPolSkdDirCd(polSkdDirCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (whfDeclOfcCd[i] != null)
					model.setWhfDeclOfcCd(whfDeclOfcCd[i]);
				if (autoMnlDivCd[i] != null)
					model.setAutoMnlDivCd(autoMnlDivCd[i]);
				if (invArIfCd[i] != null)
					model.setInvArIfCd(invArIfCd[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (trnkSkdDirCd[i] != null)
					model.setTrnkSkdDirCd(trnkSkdDirCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (troPayrSeq[i] != null)
					model.setTroPayrSeq(troPayrSeq[i]);
				if (whfDeclVslCd[i] != null)
					model.setWhfDeclVslCd(whfDeclVslCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (caRsnCd[i] != null)
					model.setCaRsnCd(caRsnCd[i]);
				if (bkgCorrDt[i] != null)
					model.setBkgCorrDt(bkgCorrDt[i]);
				if (cgoMeasQty[i] != null)
					model.setCgoMeasQty(cgoMeasQty[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (whfMrnNo[i] != null)
					model.setWhfMrnNo(whfMrnNo[i]);
				if (invRefNo[i] != null)
					model.setInvRefNo(invRefNo[i]);
				if (cxlDt[i] != null)
					model.setCxlDt(cxlDt[i]);
				if (polSkdVoyNo[i] != null)
					model.setPolSkdVoyNo(polSkdVoyNo[i]);
				if (bkgSeq[i] != null)
					model.setBkgSeq(bkgSeq[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (bkgRefNo[i] != null)
					model.setBkgRefNo(bkgRefNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (arIfErrRsn[i] != null)
					model.setArIfErrRsn(arIfErrRsn[i]);
				if (bdrIndFlg[i] != null)
					model.setBdrIndFlg(bdrIndFlg[i]);
				if (frtFwrdCntCd[i] != null)
					model.setFrtFwrdCntCd(frtFwrdCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvBkgIfMnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvBkgIfMnVO[]
	 */
	public InvBkgIfMnVO[] getInvBkgIfMnVOs(){
		InvBkgIfMnVO[] vos = (InvBkgIfMnVO[])models.toArray(new InvBkgIfMnVO[models.size()]);
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
		this.bkgTms = this.bkgTms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polVslCd = this.polVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcIfDt = this.srcIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclNo = this.whfDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podVslCd = this.podVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBlNo = this.mstBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSkdDirCd = this.podSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnAgnCd = this.chnAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSkdVoyNo = this.podSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrNo = this.bkgCorrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destSvcModCd = this.destSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troPayrCntCd = this.troPayrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfNtcNo = this.whfNtcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclDirCd = this.whfDeclDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCustSeq = this.frtFwrdCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclVoyNo = this.whfDeclVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troIoBndCd = this.troIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siRefNo = this.siRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVslCd = this.trnkVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdVoyNo = this.trnkSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclCfmDt = this.whfDeclCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSkdDirCd = this.polSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclOfcCd = this.whfDeclOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoMnlDivCd = this.autoMnlDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invArIfCd = this.invArIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdDirCd = this.trnkSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troPayrSeq = this.troPayrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclVslCd = this.whfDeclVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caRsnCd = this.caRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrDt = this.bkgCorrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoMeasQty = this.cgoMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfMrnNo = this.whfMrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo = this.invRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlDt = this.cxlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSkdVoyNo = this.polSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq = this.bkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo = this.bkgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfErrRsn = this.arIfErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrIndFlg = this.bdrIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntCd = this.frtFwrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
