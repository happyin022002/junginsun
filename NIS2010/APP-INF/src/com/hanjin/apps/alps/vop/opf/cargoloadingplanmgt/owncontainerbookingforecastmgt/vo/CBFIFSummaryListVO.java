/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CBFIFSummaryListVO.java
*@FileTitle : CBFIFSummaryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.02
*@LastModifier : 김도현 
*@LastVersion : 1.0
* 2015.10.02 김도현 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo;

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

public class CBFIFSummaryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CBFIFSummaryListVO> models = new ArrayList<CBFIFSummaryListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cbfSmrySeq = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Column Info */
	private String full20ftCntrKnt = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lfSdOvrDimLen = null;
	/* Column Info */
	private String bkg45ftHcQty = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String fwrdOvrDimLen = null;
	/* Column Info */
	private String polClptIndSeq = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String hcFull40ftCntrKnt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String hgtOvrDimLen = null;
	/* Column Info */
	private String cbfSmryDcgoSeq = null;
	/* Column Info */
	private String bkg40ftQty = null;
	/* Column Info */
	private String bkg40ftHcQty = null;
	/* Column Info */
	private String cntrGrsWgt = null;
	/* Column Info */
	private String full45ftCntrKnt = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String rtSdOvrDimLen = null;
	/* Column Info */
	private String full40ftCntrKnt = null;
	/* Column Info */
	private String void20ftQty = null;
	/* Column Info */
	private String bkg20ftQty = null;
	/* Column Info */
	private String cgoGrsWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hcMty40ftCntrKnt = null;
	/* Column Info */
	private String usdBkgTtlQty = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String mty45ftCntrKnt = null;
	/* Column Info */
	private String mty20ftCntrKnt = null;
	/* Column Info */
	private String cbfRmk = null;
	/* Column Info */
	private String mtyBkgFlg = null;
	/* Column Info */
	private String bkwdOvrDimLen = null;
	/* Column Info */
	private String stwgCgoFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cbfSpclSmrySeq = null;
	/* Column Info */
	private String bdlCgoFlg = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String mrnPolutFlg = null;
	/* Column Info */
	private String mty40ftCntrKnt = null;
	/* Column Info */
	private String crnPstStsCd = null;
	/* Column Info */
	private String cbfIndFlg = null;
	/* Column Info */
	private String imdgLmtQtyFlg = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podStwgCd = null;
	/* Column Info */
	private String carrierCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String conditionGb = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String cargoType = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String coLoad = null;
	/* Column Info */
	private String crrCdFlag = null;
	/* Column Info */
	private String fcastCrrCd1 = null;
	/* Column Info */
	private String fcastCrrCd2 = null;
	/* Column Info */
	private String fcastCrrCd3 = null;
	/* Column Info */
	private String fcastCrrCd4 = null;
	/* Column Info */
	private String fcastCrrCd5 = null;
	/* Column Info */
	private String fcastCrrCd6 = null;
	/* Column Info */
	private String fcastCrrCd7 = null;
	/* Column Info */
	private String fcastCrrCdFlg1 = null;
	/* Column Info */
	private String fcastCrrCdFlg2 = null;
	/* Column Info */
	private String fcastCrrCdFlg3 = null;
	/* Column Info */
	private String fcastCrrCdFlg4 = null;
	/* Column Info */
	private String fcastCrrCdFlg5 = null;
	/* Column Info */
	private String fcastCrrCdFlg6 = null;
	/* Column Info */
	private String fcastCrrCdFlg7 = null;
	/* Column Info */
	private String podChk = null;
	/* Column Info */
	private String srl1 = null;
	/* Column Info */
	private String podNm2 = null;
	/* Column Info */
	private String prctFlg = null;
	/* Column Info */
	private String imdgSubsRskLblCd = null;
	/* Column Info */
	private String bkgRevMcgoFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CBFIFSummaryListVO() {}

	public CBFIFSummaryListVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String ydCd, String polClptIndSeq, String crrCd, String podCd, String blckStwgCd, String cbfIndFlg, String full20ftCntrKnt, String mty20ftCntrKnt, String full40ftCntrKnt, String mty40ftCntrKnt, String hcFull40ftCntrKnt, String hcMty40ftCntrKnt, String full45ftCntrKnt, String mty45ftCntrKnt, String cntrGrsWgt, String bkg20ftQty, String bkg40ftQty, String bkg40ftHcQty, String bkg45ftHcQty, String cbfSmrySeq, String cbfSmryDcgoSeq, String cntrTpszCd, String imdgUnNo, String imdgClssCd, String mrnPolutFlg, String imdgLmtQtyFlg, String cbfSpclSmrySeq, String dcgoFlg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String bdlCgoFlg, String stwgCgoFlg, String mtyBkgFlg, String crnPstStsCd, String cntrQty, String stwgCd, String fwrdOvrDimLen, String bkwdOvrDimLen, String hgtOvrDimLen, String lfSdOvrDimLen, String rtSdOvrDimLen, String cbfRmk, String usdBkgTtlQty, String void20ftQty, String cgoGrsWgt, String vpsPortCd, String vpsEtaDt, String polCd, String podStwgCd, String carrierCd, String creUsrId, String updUsrId, String conditionGb, String podNm, String cargoType, String bkgStsCd, String coLoad, String crrCdFlag, String fcastCrrCd1, String fcastCrrCd2, String fcastCrrCd3, String fcastCrrCd4, String fcastCrrCd5, String fcastCrrCd6, String fcastCrrCd7, String fcastCrrCdFlg1, String fcastCrrCdFlg2, String fcastCrrCdFlg3, String fcastCrrCdFlg4, String fcastCrrCdFlg5, String fcastCrrCdFlg6, String fcastCrrCdFlg7, String podChk, String srl1, String podNm2, String prctFlg, String imdgSubsRskLblCd, String bkgRevMcgoFlg) {
		this.vslCd = vslCd;
		this.cbfSmrySeq = cbfSmrySeq;
		this.blckStwgCd = blckStwgCd;
		this.full20ftCntrKnt = full20ftCntrKnt;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.lfSdOvrDimLen = lfSdOvrDimLen;
		this.bkg45ftHcQty = bkg45ftHcQty;
		this.cntrTpszCd = cntrTpszCd;
		this.fwrdOvrDimLen = fwrdOvrDimLen;
		this.polClptIndSeq = polClptIndSeq;
		this.stwgCd = stwgCd;
		this.imdgUnNo = imdgUnNo;
		this.awkCgoFlg = awkCgoFlg;
		this.hcFull40ftCntrKnt = hcFull40ftCntrKnt;
		this.skdVoyNo = skdVoyNo;
		this.podCd = podCd;
		this.hgtOvrDimLen = hgtOvrDimLen;
		this.cbfSmryDcgoSeq = cbfSmryDcgoSeq;
		this.bkg40ftQty = bkg40ftQty;
		this.bkg40ftHcQty = bkg40ftHcQty;
		this.cntrGrsWgt = cntrGrsWgt;
		this.full45ftCntrKnt = full45ftCntrKnt;
		this.rcFlg = rcFlg;
		this.imdgClssCd = imdgClssCd;
		this.rtSdOvrDimLen = rtSdOvrDimLen;
		this.full40ftCntrKnt = full40ftCntrKnt;
		this.void20ftQty = void20ftQty;
		this.bkg20ftQty = bkg20ftQty;
		this.cgoGrsWgt = cgoGrsWgt;
		this.ibflag = ibflag;
		this.hcMty40ftCntrKnt = hcMty40ftCntrKnt;
		this.usdBkgTtlQty = usdBkgTtlQty;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.cntrQty = cntrQty;
		this.mty45ftCntrKnt = mty45ftCntrKnt;
		this.mty20ftCntrKnt = mty20ftCntrKnt;
		this.cbfRmk = cbfRmk;
		this.mtyBkgFlg = mtyBkgFlg;
		this.bkwdOvrDimLen = bkwdOvrDimLen;
		this.stwgCgoFlg = stwgCgoFlg;
		this.skdDirCd = skdDirCd;
		this.cbfSpclSmrySeq = cbfSpclSmrySeq;
		this.bdlCgoFlg = bdlCgoFlg;
		this.ydCd = ydCd;
		this.mrnPolutFlg = mrnPolutFlg;
		this.mty40ftCntrKnt = mty40ftCntrKnt;
		this.crnPstStsCd = crnPstStsCd;
		this.cbfIndFlg = cbfIndFlg;
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
		this.vpsPortCd = vpsPortCd;
		this.vpsEtaDt = vpsEtaDt;
		this.polCd = polCd;
		this.podStwgCd = podStwgCd;
		this.carrierCd = carrierCd;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.conditionGb = conditionGb;
		this.podNm = podNm;
		this.cargoType = cargoType;
		this.bkgStsCd = bkgStsCd;
		this.coLoad   = coLoad;
		this.crrCdFlag   = crrCdFlag;
		this.fcastCrrCd1   = fcastCrrCd1;
		this.fcastCrrCd2   = fcastCrrCd2;
		this.fcastCrrCd3   = fcastCrrCd3;
		this.fcastCrrCd4   = fcastCrrCd4;
		this.fcastCrrCd5   = fcastCrrCd5;
		this.fcastCrrCd6   = fcastCrrCd6;
		this.fcastCrrCd7   = fcastCrrCd7;
		this.fcastCrrCdFlg1   = fcastCrrCdFlg1;
		this.fcastCrrCdFlg2   = fcastCrrCdFlg2;
		this.fcastCrrCdFlg3   = fcastCrrCdFlg3;
		this.fcastCrrCdFlg4   = fcastCrrCdFlg4;
		this.fcastCrrCdFlg5   = fcastCrrCdFlg5;
		this.fcastCrrCdFlg6   = fcastCrrCdFlg6;
		this.fcastCrrCdFlg7   = fcastCrrCdFlg7;
		this.podChk   = podChk;
		this.srl1   = srl1;
		this.podNm2   = podNm2;
		this.prctFlg   = prctFlg;
		this.imdgSubsRskLblCd   = imdgSubsRskLblCd;
		this.bkgRevMcgoFlg   = bkgRevMcgoFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cbf_smry_seq", getCbfSmrySeq());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("full_20ft_cntr_knt", getFull20ftCntrKnt());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lf_sd_ovr_dim_len", getLfSdOvrDimLen());
		this.hashColumns.put("bkg_45ft_hc_qty", getBkg45ftHcQty());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("fwrd_ovr_dim_len", getFwrdOvrDimLen());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("hc_full_40ft_cntr_knt", getHcFull40ftCntrKnt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("hgt_ovr_dim_len", getHgtOvrDimLen());
		this.hashColumns.put("cbf_smry_dcgo_seq", getCbfSmryDcgoSeq());
		this.hashColumns.put("bkg_40ft_qty", getBkg40ftQty());
		this.hashColumns.put("bkg_40ft_hc_qty", getBkg40ftHcQty());
		this.hashColumns.put("cntr_grs_wgt", getCntrGrsWgt());
		this.hashColumns.put("full_45ft_cntr_knt", getFull45ftCntrKnt());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("rt_sd_ovr_dim_len", getRtSdOvrDimLen());
		this.hashColumns.put("full_40ft_cntr_knt", getFull40ftCntrKnt());
		this.hashColumns.put("void_20ft_qty", getVoid20ftQty());
		this.hashColumns.put("bkg_20ft_qty", getBkg20ftQty());
		this.hashColumns.put("cgo_grs_wgt", getCgoGrsWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hc_mty_40ft_cntr_knt", getHcMty40ftCntrKnt());
		this.hashColumns.put("usd_bkg_ttl_qty", getUsdBkgTtlQty());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("mty_45ft_cntr_knt", getMty45ftCntrKnt());
		this.hashColumns.put("mty_20ft_cntr_knt", getMty20ftCntrKnt());
		this.hashColumns.put("cbf_rmk", getCbfRmk());
		this.hashColumns.put("mty_bkg_flg", getMtyBkgFlg());
		this.hashColumns.put("bkwd_ovr_dim_len", getBkwdOvrDimLen());
		this.hashColumns.put("stwg_cgo_flg", getStwgCgoFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cbf_spcl_smry_seq", getCbfSpclSmrySeq());
		this.hashColumns.put("bdl_cgo_flg", getBdlCgoFlg());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
		this.hashColumns.put("mty_40ft_cntr_knt", getMty40ftCntrKnt());
		this.hashColumns.put("crn_pst_sts_cd", getCrnPstStsCd());
		this.hashColumns.put("cbf_ind_flg", getCbfIndFlg());
		this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_stwg_cd", getPodStwgCd());
		this.hashColumns.put("carrier_cd", getCarrierCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("condition_gb", getConditionGb());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("cargo_type", getCargoType());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("co_load", getCoLoad());
		this.hashColumns.put("crr_cd_flag", getCrrCdFlag());
		this.hashColumns.put("fcast_crr_cd1", getFcastCrrCd1());
		this.hashColumns.put("fcast_crr_cd2", getFcastCrrCd2());
		this.hashColumns.put("fcast_crr_cd3", getFcastCrrCd3());
		this.hashColumns.put("fcast_crr_cd4", getFcastCrrCd4());
		this.hashColumns.put("fcast_crr_cd5", getFcastCrrCd5());
		this.hashColumns.put("fcast_crr_cd6", getFcastCrrCd6());
		this.hashColumns.put("fcast_crr_cd7", getFcastCrrCd7());
		this.hashColumns.put("fcast_crr_cd_flg1", getFcastCrrCdFlg1());
		this.hashColumns.put("fcast_crr_cd_flg2", getFcastCrrCdFlg2());
		this.hashColumns.put("fcast_crr_cd_flg3", getFcastCrrCdFlg3());
		this.hashColumns.put("fcast_crr_cd_flg4", getFcastCrrCdFlg4());
		this.hashColumns.put("fcast_crr_cd_flg5", getFcastCrrCdFlg5());
		this.hashColumns.put("fcast_crr_cd_flg6", getFcastCrrCdFlg6());
		this.hashColumns.put("fcast_crr_cd_flg7", getFcastCrrCdFlg7());
		this.hashColumns.put("pod_chk", getPodChk());
		this.hashColumns.put("srl1", getSrl1());
		this.hashColumns.put("pod_nm2", getPodNm2());
		this.hashColumns.put("prct_flg", getPrctFlg());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd", getImdgSubsRskLblCd());
		this.hashColumns.put("bkg_rev_mcgo_flg", getBkgRevMcgoFlg());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cbf_smry_seq", "cbfSmrySeq");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("full_20ft_cntr_knt", "full20ftCntrKnt");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lf_sd_ovr_dim_len", "lfSdOvrDimLen");
		this.hashFields.put("bkg_45ft_hc_qty", "bkg45ftHcQty");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("fwrd_ovr_dim_len", "fwrdOvrDimLen");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("hc_full_40ft_cntr_knt", "hcFull40ftCntrKnt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("hgt_ovr_dim_len", "hgtOvrDimLen");
		this.hashFields.put("cbf_smry_dcgo_seq", "cbfSmryDcgoSeq");
		this.hashFields.put("bkg_40ft_qty", "bkg40ftQty");
		this.hashFields.put("bkg_40ft_hc_qty", "bkg40ftHcQty");
		this.hashFields.put("cntr_grs_wgt", "cntrGrsWgt");
		this.hashFields.put("full_45ft_cntr_knt", "full45ftCntrKnt");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("rt_sd_ovr_dim_len", "rtSdOvrDimLen");
		this.hashFields.put("full_40ft_cntr_knt", "full40ftCntrKnt");
		this.hashFields.put("void_20ft_qty", "void20ftQty");
		this.hashFields.put("bkg_20ft_qty", "bkg20ftQty");
		this.hashFields.put("cgo_grs_wgt", "cgoGrsWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hc_mty_40ft_cntr_knt", "hcMty40ftCntrKnt");
		this.hashFields.put("usd_bkg_ttl_qty", "usdBkgTtlQty");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("mty_45ft_cntr_knt", "mty45ftCntrKnt");
		this.hashFields.put("mty_20ft_cntr_knt", "mty20ftCntrKnt");
		this.hashFields.put("cbf_rmk", "cbfRmk");
		this.hashFields.put("mty_bkg_flg", "mtyBkgFlg");
		this.hashFields.put("bkwd_ovr_dim_len", "bkwdOvrDimLen");
		this.hashFields.put("stwg_cgo_flg", "stwgCgoFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cbf_spcl_smry_seq", "cbfSpclSmrySeq");
		this.hashFields.put("bdl_cgo_flg", "bdlCgoFlg");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
		this.hashFields.put("mty_40ft_cntr_knt", "mty40ftCntrKnt");
		this.hashFields.put("crn_pst_sts_cd", "crnPstStsCd");
		this.hashFields.put("cbf_ind_flg", "cbfIndFlg");
		this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_stwg_cd", "podStwgCd");
		this.hashFields.put("carrier_cd", "carrierCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("condition_gb", "conditionGb");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("cargo_type", "cargoType");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("co_load", "coLoad");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("crr_cd_flag", "crrCdFlag");
		this.hashFields.put("fcast_crr_cd1", "fcastCrrCd1");
		this.hashFields.put("fcast_crr_cd2", "fcastCrrCd2");
		this.hashFields.put("fcast_crr_cd3", "fcastCrrCd3");
		this.hashFields.put("fcast_crr_cd4", "fcastCrrCd4");
		this.hashFields.put("fcast_crr_cd5", "fcastCrrCd5");
		this.hashFields.put("fcast_crr_cd6", "fcastCrrCd6");
		this.hashFields.put("fcast_crr_cd7", "fcastCrrCd7");
		this.hashFields.put("fcast_crr_cd_flg1", "fcastCrrCdFlg1");
		this.hashFields.put("fcast_crr_cd_flg2", "fcastCrrCdFlg2");
		this.hashFields.put("fcast_crr_cd_flg3", "fcastCrrCdFlg3");
		this.hashFields.put("fcast_crr_cd_flg4", "fcastCrrCdFlg4");
		this.hashFields.put("fcast_crr_cd_flg5", "fcastCrrCdFlg5");
		this.hashFields.put("fcast_crr_cd_flg6", "fcastCrrCdFlg6");
		this.hashFields.put("fcast_crr_cd_flg7", "fcastCrrCdFlg7");
		this.hashFields.put("pod_chk", "podChk");
		this.hashFields.put("srl1", "srl1");
		this.hashFields.put("pod_nm2", "podNm2");
		this.hashFields.put("prct_flg", "prctFlg");
		this.hashFields.put("imdg_subs_rsk_lbl_cd", "imdgSubsRskLblCd");
		this.hashFields.put("bkg_rev_mcgo_flg", "bkgRevMcgoFlg");
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
	 * @return cbfSmrySeq
	 */
	public String getCbfSmrySeq() {
		return this.cbfSmrySeq;
	}
	
	/**
	 * Column Info
	 * @return blckStwgCd
	 */
	public String getBlckStwgCd() {
		return this.blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @return full20ftCntrKnt
	 */
	public String getFull20ftCntrKnt() {
		return this.full20ftCntrKnt;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return lfSdOvrDimLen
	 */
	public String getLfSdOvrDimLen() {
		return this.lfSdOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @return bkg45ftHcQty
	 */
	public String getBkg45ftHcQty() {
		return this.bkg45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return fwrdOvrDimLen
	 */
	public String getFwrdOvrDimLen() {
		return this.fwrdOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @return polClptIndSeq
	 */
	public String getPolClptIndSeq() {
		return this.polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return stwgCd
	 */
	public String getStwgCd() {
		return this.stwgCd;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
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
	 * @return hcFull40ftCntrKnt
	 */
	public String getHcFull40ftCntrKnt() {
		return this.hcFull40ftCntrKnt;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return hgtOvrDimLen
	 */
	public String getHgtOvrDimLen() {
		return this.hgtOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @return cbfSmryDcgoSeq
	 */
	public String getCbfSmryDcgoSeq() {
		return this.cbfSmryDcgoSeq;
	}
	
	/**
	 * Column Info
	 * @return bkg40ftQty
	 */
	public String getBkg40ftQty() {
		return this.bkg40ftQty;
	}
	
	/**
	 * Column Info
	 * @return bkg40ftHcQty
	 */
	public String getBkg40ftHcQty() {
		return this.bkg40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return cntrGrsWgt
	 */
	public String getCntrGrsWgt() {
		return this.cntrGrsWgt;
	}
	
	/**
	 * Column Info
	 * @return full45ftCntrKnt
	 */
	public String getFull45ftCntrKnt() {
		return this.full45ftCntrKnt;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return rtSdOvrDimLen
	 */
	public String getRtSdOvrDimLen() {
		return this.rtSdOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @return full40ftCntrKnt
	 */
	public String getFull40ftCntrKnt() {
		return this.full40ftCntrKnt;
	}
	
	/**
	 * Column Info
	 * @return void20ftQty
	 */
	public String getVoid20ftQty() {
		return this.void20ftQty;
	}
	
	/**
	 * Column Info
	 * @return bkg20ftQty
	 */
	public String getBkg20ftQty() {
		return this.bkg20ftQty;
	}
	
	/**
	 * Column Info
	 * @return cgoGrsWgt
	 */
	public String getCgoGrsWgt() {
		return this.cgoGrsWgt;
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
	 * @return hcMty40ftCntrKnt
	 */
	public String getHcMty40ftCntrKnt() {
		return this.hcMty40ftCntrKnt;
	}
	
	/**
	 * Column Info
	 * @return usdBkgTtlQty
	 */
	public String getUsdBkgTtlQty() {
		return this.usdBkgTtlQty;
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
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return mty45ftCntrKnt
	 */
	public String getMty45ftCntrKnt() {
		return this.mty45ftCntrKnt;
	}
	
	/**
	 * Column Info
	 * @return mty20ftCntrKnt
	 */
	public String getMty20ftCntrKnt() {
		return this.mty20ftCntrKnt;
	}
	
	/**
	 * Column Info
	 * @return cbfRmk
	 */
	public String getCbfRmk() {
		return this.cbfRmk;
	}
	
	/**
	 * Column Info
	 * @return mtyBkgFlg
	 */
	public String getMtyBkgFlg() {
		return this.mtyBkgFlg;
	}
	
	/**
	 * Column Info
	 * @return bkwdOvrDimLen
	 */
	public String getBkwdOvrDimLen() {
		return this.bkwdOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @return stwgCgoFlg
	 */
	public String getStwgCgoFlg() {
		return this.stwgCgoFlg;
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
	 * @return cbfSpclSmrySeq
	 */
	public String getCbfSpclSmrySeq() {
		return this.cbfSpclSmrySeq;
	}
	
	/**
	 * Column Info
	 * @return bdlCgoFlg
	 */
	public String getBdlCgoFlg() {
		return this.bdlCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return mrnPolutFlg
	 */
	public String getMrnPolutFlg() {
		return this.mrnPolutFlg;
	}
	
	/**
	 * Column Info
	 * @return mty40ftCntrKnt
	 */
	public String getMty40ftCntrKnt() {
		return this.mty40ftCntrKnt;
	}
	
	/**
	 * Column Info
	 * @return crnPstStsCd
	 */
	public String getCrnPstStsCd() {
		return this.crnPstStsCd;
	}
	
	/**
	 * Column Info
	 * @return cbfIndFlg
	 */
	public String getCbfIndFlg() {
		return this.cbfIndFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgLmtQtyFlg
	 */
	public String getImdgLmtQtyFlg() {
		return this.imdgLmtQtyFlg;
	}
	
	/**
	 * Column Info
	 * @return coLoad
	 */
	public String getCoLoad() {
		return this.coLoad;
	}
	
	
	
	/**
	 * Column Info
	 * @param coLoad
	 */
	public void setCoLoad(String coLoad) {
		this.coLoad = coLoad;
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
	 * @param cbfSmrySeq
	 */
	public void setCbfSmrySeq(String cbfSmrySeq) {
		this.cbfSmrySeq = cbfSmrySeq;
	}
	
	/**
	 * Column Info
	 * @param blckStwgCd
	 */
	public void setBlckStwgCd(String blckStwgCd) {
		this.blckStwgCd = blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @param full20ftCntrKnt
	 */
	public void setFull20ftCntrKnt(String full20ftCntrKnt) {
		this.full20ftCntrKnt = full20ftCntrKnt;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param lfSdOvrDimLen
	 */
	public void setLfSdOvrDimLen(String lfSdOvrDimLen) {
		this.lfSdOvrDimLen = lfSdOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @param bkg45ftHcQty
	 */
	public void setBkg45ftHcQty(String bkg45ftHcQty) {
		this.bkg45ftHcQty = bkg45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param fwrdOvrDimLen
	 */
	public void setFwrdOvrDimLen(String fwrdOvrDimLen) {
		this.fwrdOvrDimLen = fwrdOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @param polClptIndSeq
	 */
	public void setPolClptIndSeq(String polClptIndSeq) {
		this.polClptIndSeq = polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param stwgCd
	 */
	public void setStwgCd(String stwgCd) {
		this.stwgCd = stwgCd;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
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
	 * @param hcFull40ftCntrKnt
	 */
	public void setHcFull40ftCntrKnt(String hcFull40ftCntrKnt) {
		this.hcFull40ftCntrKnt = hcFull40ftCntrKnt;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param hgtOvrDimLen
	 */
	public void setHgtOvrDimLen(String hgtOvrDimLen) {
		this.hgtOvrDimLen = hgtOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @param cbfSmryDcgoSeq
	 */
	public void setCbfSmryDcgoSeq(String cbfSmryDcgoSeq) {
		this.cbfSmryDcgoSeq = cbfSmryDcgoSeq;
	}
	
	/**
	 * Column Info
	 * @param bkg40ftQty
	 */
	public void setBkg40ftQty(String bkg40ftQty) {
		this.bkg40ftQty = bkg40ftQty;
	}
	
	/**
	 * Column Info
	 * @param bkg40ftHcQty
	 */
	public void setBkg40ftHcQty(String bkg40ftHcQty) {
		this.bkg40ftHcQty = bkg40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param cntrGrsWgt
	 */
	public void setCntrGrsWgt(String cntrGrsWgt) {
		this.cntrGrsWgt = cntrGrsWgt;
	}
	
	/**
	 * Column Info
	 * @param full45ftCntrKnt
	 */
	public void setFull45ftCntrKnt(String full45ftCntrKnt) {
		this.full45ftCntrKnt = full45ftCntrKnt;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param rtSdOvrDimLen
	 */
	public void setRtSdOvrDimLen(String rtSdOvrDimLen) {
		this.rtSdOvrDimLen = rtSdOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @param full40ftCntrKnt
	 */
	public void setFull40ftCntrKnt(String full40ftCntrKnt) {
		this.full40ftCntrKnt = full40ftCntrKnt;
	}
	
	/**
	 * Column Info
	 * @param void20ftQty
	 */
	public void setVoid20ftQty(String void20ftQty) {
		this.void20ftQty = void20ftQty;
	}
	
	/**
	 * Column Info
	 * @param bkg20ftQty
	 */
	public void setBkg20ftQty(String bkg20ftQty) {
		this.bkg20ftQty = bkg20ftQty;
	}
	
	/**
	 * Column Info
	 * @param cgoGrsWgt
	 */
	public void setCgoGrsWgt(String cgoGrsWgt) {
		this.cgoGrsWgt = cgoGrsWgt;
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
	 * @param hcMty40ftCntrKnt
	 */
	public void setHcMty40ftCntrKnt(String hcMty40ftCntrKnt) {
		this.hcMty40ftCntrKnt = hcMty40ftCntrKnt;
	}
	
	/**
	 * Column Info
	 * @param usdBkgTtlQty
	 */
	public void setUsdBkgTtlQty(String usdBkgTtlQty) {
		this.usdBkgTtlQty = usdBkgTtlQty;
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
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param mty45ftCntrKnt
	 */
	public void setMty45ftCntrKnt(String mty45ftCntrKnt) {
		this.mty45ftCntrKnt = mty45ftCntrKnt;
	}
	
	/**
	 * Column Info
	 * @param mty20ftCntrKnt
	 */
	public void setMty20ftCntrKnt(String mty20ftCntrKnt) {
		this.mty20ftCntrKnt = mty20ftCntrKnt;
	}
	
	/**
	 * Column Info
	 * @param cbfRmk
	 */
	public void setCbfRmk(String cbfRmk) {
		this.cbfRmk = cbfRmk;
	}
	
	/**
	 * Column Info
	 * @param mtyBkgFlg
	 */
	public void setMtyBkgFlg(String mtyBkgFlg) {
		this.mtyBkgFlg = mtyBkgFlg;
	}
	
	/**
	 * Column Info
	 * @param bkwdOvrDimLen
	 */
	public void setBkwdOvrDimLen(String bkwdOvrDimLen) {
		this.bkwdOvrDimLen = bkwdOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @param stwgCgoFlg
	 */
	public void setStwgCgoFlg(String stwgCgoFlg) {
		this.stwgCgoFlg = stwgCgoFlg;
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
	 * @param cbfSpclSmrySeq
	 */
	public void setCbfSpclSmrySeq(String cbfSpclSmrySeq) {
		this.cbfSpclSmrySeq = cbfSpclSmrySeq;
	}
	
	/**
	 * Column Info
	 * @param bdlCgoFlg
	 */
	public void setBdlCgoFlg(String bdlCgoFlg) {
		this.bdlCgoFlg = bdlCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param mrnPolutFlg
	 */
	public void setMrnPolutFlg(String mrnPolutFlg) {
		this.mrnPolutFlg = mrnPolutFlg;
	}
	
	/**
	 * Column Info
	 * @param mty40ftCntrKnt
	 */
	public void setMty40ftCntrKnt(String mty40ftCntrKnt) {
		this.mty40ftCntrKnt = mty40ftCntrKnt;
	}
	
	/**
	 * Column Info
	 * @param crnPstStsCd
	 */
	public void setCrnPstStsCd(String crnPstStsCd) {
		this.crnPstStsCd = crnPstStsCd;
	}
	
	/**
	 * Column Info
	 * @param cbfIndFlg
	 */
	public void setCbfIndFlg(String cbfIndFlg) {
		this.cbfIndFlg = cbfIndFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgLmtQtyFlg
	 */
	public void setImdgLmtQtyFlg(String imdgLmtQtyFlg) {
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public String getVpsPortCd() {
		return vpsPortCd;
	}

	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}

	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return vpsEtaDt;
	}

	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public String getPolCd() {
		return polCd;
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
	 * @param podStwgCd
	 */
	public String getPodStwgCd() {
		return podStwgCd;
	}

	/**
	 * Column Info
	 * @param podStwgCd
	 */
	public void setPodStwgCd(String podStwgCd) {
		this.podStwgCd = podStwgCd;
	}
	
	/**
	 * Column Info
	 * @param carrierCd
	 */
	public String getCarrierCd() {
		return carrierCd;
	}

	/**
	 * Column Info
	 * @param carrierCd
	 */
	public void setCarrierCd(String carrierCd) {
		this.carrierCd = carrierCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
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
	 * @param updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
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
	 * @param conditionGb
	 */
	public String getConditionGb() {
		return conditionGb;
	}

	/**
	 * Column Info
	 * @param conditionGb
	 */
	public void setConditionGb(String conditionGb) {
		this.conditionGb = conditionGb;
	}
	
	/**
	 * Column Info
	 * @param podNm
	 */
	public String getPodNm() {
		return podNm;
	}

	/**
	 * Column Info
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	
	/**
	 * Column Info
	 * @param cargoType
	 */
	public String getCargoType() {
		return cargoType;
	}

	/**
	 * Column Info
	 * @param cargoType
	 */
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public String getBkgStsCd() {
		return bkgStsCd;
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
	 * @param crrCdFlag
	 */
	public String getCrrCdFlag() {
		return crrCdFlag;
	}

	/**
	 * Column Info
	 * @param crrCdFlag
	 */
	public void setCrrCdFlag(String crrCdFlag) {
		this.crrCdFlag = crrCdFlag;
	}

	/**
	 * Column Info
	 * @param fcastCrrCd1
	 */
	public String getFcastCrrCd1() {
		return fcastCrrCd1;
	}

	/**
	 * Column Info
	 * @param fcastCrrCd1
	 */
	public void setFcastCrrCd1(String fcastCrrCd1) {
		this.fcastCrrCd1 = fcastCrrCd1;
	}

	/**
	 * Column Info
	 * @param fcastCrrCd2
	 */
	public String getFcastCrrCd2() {
		return fcastCrrCd2;
	}

	/**
	 * Column Info
	 * @param fcastCrrCd2
	 */
	public void setFcastCrrCd2(String fcastCrrCd2) {
		this.fcastCrrCd2 = fcastCrrCd2;
	}

	/**
	 * Column Info
	 * @param fcastCrrCd3
	 */
	public String getFcastCrrCd3() {
		return fcastCrrCd3;
	}

	/**
	 * Column Info
	 * @param fcastCrrCd3
	 */
	public void setFcastCrrCd3(String fcastCrrCd3) {
		this.fcastCrrCd3 = fcastCrrCd3;
	}

	/**
	 * Column Info
	 * @param fcastCrrCd4
	 */
	public String getFcastCrrCd4() {
		return fcastCrrCd4;
	}

	/**
	 * Column Info
	 * @param fcastCrrCd4
	 */
	public void setFcastCrrCd4(String fcastCrrCd4) {
		this.fcastCrrCd4 = fcastCrrCd4;
	}
	
	/**
	 * Column Info
	 * @param fcastCrrCd5
	 */
	public String getFcastCrrCd5() {
		return fcastCrrCd5;
	}

	/**
	 * Column Info
	 * @param fcastCrrCd5
	 */
	public void setFcastCrrCd5(String fcastCrrCd5) {
		this.fcastCrrCd5 = fcastCrrCd5;
	}

	/**
	 * Column Info
	 * @param fcastCrrCd6
	 */
	public String getFcastCrrCd6() {
		return fcastCrrCd6;
	}

	/**
	 * Column Info
	 * @param fcastCrrCd6
	 */
	public void setFcastCrrCd6(String fcastCrrCd6) {
		this.fcastCrrCd6 = fcastCrrCd6;
	}

	/**
	 * Column Info
	 * @param fcastCrrCdFlg1
	 */
	public String getFcastCrrCdFlg1() {
		return fcastCrrCdFlg1;
	}

	/**
	 * Column Info
	 * @param fcastCrrCdFlg1
	 */
	public void setFcastCrrCdFlg1(String fcastCrrCdFlg1) {
		this.fcastCrrCdFlg1 = fcastCrrCdFlg1;
	}

	/**
	 * Column Info
	 * @param fcastCrrCdFlg2
	 */
	public String getFcastCrrCdFlg2() {
		return fcastCrrCdFlg2;
	}

	/**
	 * Column Info
	 * @param fcastCrrCdFlg2
	 */
	public void setFcastCrrCdFlg2(String fcastCrrCdFlg2) {
		this.fcastCrrCdFlg2 = fcastCrrCdFlg2;
	}

	/**
	 * Column Info
	 * @param fcastCrrCdFlg3
	 */
	public String getFcastCrrCdFlg3() {
		return fcastCrrCdFlg3;
	}

	/**
	 * Column Info
	 * @param fcastCrrCdFlg3
	 */
	public void setFcastCrrCdFlg3(String fcastCrrCdFlg3) {
		this.fcastCrrCdFlg3 = fcastCrrCdFlg3;
	}

	/**
	 * Column Info
	 * @param fcastCrrCdFlg4
	 */
	public String getFcastCrrCdFlg4() {
		return fcastCrrCdFlg4;
	}

	/**
	 * Column Info
	 * @param fcastCrrCdFlg4
	 */
	public void setFcastCrrCdFlg4(String fcastCrrCdFlg4) {
		this.fcastCrrCdFlg4 = fcastCrrCdFlg4;
	}
	
	/**
	 * Column Info
	 * @param fcastCrrCdFlg5
	 */
	public String getFcastCrrCdFlg5() {
		return fcastCrrCdFlg5;
	}

	/**
	 * Column Info
	 * @param fcastCrrCdFlg5
	 */
	public void setFcastCrrCdFlg5(String fcastCrrCdFlg5) {
		this.fcastCrrCdFlg5 = fcastCrrCdFlg5;
	}

	/**
	 * Column Info
	 * @param fcastCrrCdFlg6
	 */
	public String getFcastCrrCdFlg6() {
		return fcastCrrCdFlg6;
	}

	/**
	 * Column Info
	 * @param fcastCrrCdFlg6
	 */
	public void setFcastCrrCdFlg6(String fcastCrrCdFlg6) {
		this.fcastCrrCdFlg6 = fcastCrrCdFlg6;
	}

	/**
	 * Column Info
	 * @param podChk
	 */
	public String getPodChk() {
		return podChk;
	}

	/**
	 * Column Info
	 * @param podChk
	 */
	public void setPodChk(String podChk) {
		this.podChk = podChk;
	}
	
	/**
	 * Column Info
	 * @param srl1
	 */
	public String getSrl1() {
		return srl1;
	}

	/**
	 * Column Info
	 * @param srl1
	 */
	public void setSrl1(String srl1) {
		this.srl1 = srl1;
	}
	
	/**
	 * Column Info
	 * @param podNm2
	 */
	public String getPodNm2() {
		return podNm2;
	}

	/**
	 * Column Info
	 * @param podNm2
	 */
	public void setPodNm2(String podNm2) {
		this.podNm2 = podNm2;
	}
	
	/**
	 * Column Info
	 * @param prctFlg
	 */
	public String getPrctFlg() {
		return prctFlg;
	}

	/**
	 * Column Info
	 * @param prctFlg
	 */
	public void setPrctFlg(String prctFlg) {
		this.prctFlg = prctFlg;
	}

	/**
	 * Column Info
	 * @param imdgSubsRskLblCd
	 */
	public String getImdgSubsRskLblCd() {
		return imdgSubsRskLblCd;
	}

	/**
	 * Column Info
	 * @param imdgSubsRskLblCd
	 */
	public void setImdgSubsRskLblCd(String imdgSubsRskLblCd) {
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
	}

	/**
	 * Column Info
	 * @param bkgRevMcgoFlg
	 */
	public String getBkgRevMcgoFlg() {
		return bkgRevMcgoFlg;
	}

	/**
	 * Column Info
	 * @param bkgRevMcgoFlg
	 */
	public void setBkgRevMcgoFlg(String bkgRevMcgoFlg) {
		this.bkgRevMcgoFlg = bkgRevMcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param fcastCrrCd7
	 */
	public String getFcastCrrCd7() {
		return fcastCrrCd7;
	}

	/**
	 * Column Info
	 * @param fcastCrrCd7
	 */
	public void setFcastCrrCd7(String fcastCrrCd7) {
		this.fcastCrrCd7 = fcastCrrCd7;
	}

	/**
	 * Column Info
	 * @param fcastCrrCdFlg7
	 */
	public String getFcastCrrCdFlg7() {
		return fcastCrrCdFlg7;
	}

	/**
	 * Column Info
	 * @param fcastCrrCdFlg7
	 */
	public void setFcastCrrCdFlg7(String fcastCrrCdFlg7) {
		this.fcastCrrCdFlg7 = fcastCrrCdFlg7;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCbfSmrySeq(JSPUtil.getParameter(request, prefix + "cbf_smry_seq", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setFull20ftCntrKnt(JSPUtil.getParameter(request, prefix + "full_20ft_cntr_knt", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLfSdOvrDimLen(JSPUtil.getParameter(request, prefix + "lf_sd_ovr_dim_len", ""));
		setBkg45ftHcQty(JSPUtil.getParameter(request, prefix + "bkg_45ft_hc_qty", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setFwrdOvrDimLen(JSPUtil.getParameter(request, prefix + "fwrd_ovr_dim_len", ""));
		setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
		setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setHcFull40ftCntrKnt(JSPUtil.getParameter(request, prefix + "hc_full_40ft_cntr_knt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setHgtOvrDimLen(JSPUtil.getParameter(request, prefix + "hgt_ovr_dim_len", ""));
		setCbfSmryDcgoSeq(JSPUtil.getParameter(request, prefix + "cbf_smry_dcgo_seq", ""));
		setBkg40ftQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_qty", ""));
		setBkg40ftHcQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_hc_qty", ""));
		setCntrGrsWgt(JSPUtil.getParameter(request, prefix + "cntr_grs_wgt", ""));
		setFull45ftCntrKnt(JSPUtil.getParameter(request, prefix + "full_45ft_cntr_knt", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setRtSdOvrDimLen(JSPUtil.getParameter(request, prefix + "rt_sd_ovr_dim_len", ""));
		setFull40ftCntrKnt(JSPUtil.getParameter(request, prefix + "full_40ft_cntr_knt", ""));
		setVoid20ftQty(JSPUtil.getParameter(request, prefix + "void_20ft_qty", ""));
		setBkg20ftQty(JSPUtil.getParameter(request, prefix + "bkg_20ft_qty", ""));
		setCgoGrsWgt(JSPUtil.getParameter(request, prefix + "cgo_grs_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setHcMty40ftCntrKnt(JSPUtil.getParameter(request, prefix + "hc_mty_40ft_cntr_knt", ""));
		setUsdBkgTtlQty(JSPUtil.getParameter(request, prefix + "usd_bkg_ttl_qty", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setMty45ftCntrKnt(JSPUtil.getParameter(request, prefix + "mty_45ft_cntr_knt", ""));
		setMty20ftCntrKnt(JSPUtil.getParameter(request, prefix + "mty_20ft_cntr_knt", ""));
		setCbfRmk(JSPUtil.getParameter(request, prefix + "cbf_rmk", ""));
		setMtyBkgFlg(JSPUtil.getParameter(request, prefix + "mty_bkg_flg", ""));
		setBkwdOvrDimLen(JSPUtil.getParameter(request, prefix + "bkwd_ovr_dim_len", ""));
		setStwgCgoFlg(JSPUtil.getParameter(request, prefix + "stwg_cgo_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCbfSpclSmrySeq(JSPUtil.getParameter(request, prefix + "cbf_spcl_smry_seq", ""));
		setBdlCgoFlg(JSPUtil.getParameter(request, prefix + "bdl_cgo_flg", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setMrnPolutFlg(JSPUtil.getParameter(request, prefix + "mrn_polut_flg", ""));
		setMty40ftCntrKnt(JSPUtil.getParameter(request, prefix + "mty_40ft_cntr_knt", ""));
		setCrnPstStsCd(JSPUtil.getParameter(request, prefix + "crn_pst_sts_cd", ""));
		setCbfIndFlg(JSPUtil.getParameter(request, prefix + "cbf_ind_flg", ""));
		setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPodStwgCd(JSPUtil.getParameter(request, prefix + "pod_stwg_cd", ""));
		setCarrierCd(JSPUtil.getParameter(request, prefix + "carrier_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setConditionGb(JSPUtil.getParameter(request, prefix + "condition_gb", ""));
		setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
		setCargoType(JSPUtil.getParameter(request, prefix + "cargo_type", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setCoLoad(JSPUtil.getParameter(request, prefix + "co_load", ""));
		setCrrCdFlag(JSPUtil.getParameter(request, prefix + "crr_cd_flag", ""));
		setFcastCrrCd1(JSPUtil.getParameter(request, prefix + "fcast_crr_cd1", ""));
		setFcastCrrCd2(JSPUtil.getParameter(request, prefix + "fcast_crr_cd2", ""));
		setFcastCrrCd3(JSPUtil.getParameter(request, prefix + "fcast_crr_cd3", ""));
		setFcastCrrCd4(JSPUtil.getParameter(request, prefix + "fcast_crr_cd4", ""));
		setFcastCrrCd5(JSPUtil.getParameter(request, prefix + "fcast_crr_cd5", ""));
		setFcastCrrCd6(JSPUtil.getParameter(request, prefix + "fcast_crr_cd6", ""));
		setFcastCrrCd7(JSPUtil.getParameter(request, prefix + "fcast_crr_cd7", ""));
		setFcastCrrCdFlg1(JSPUtil.getParameter(request, prefix + "fcast_crr_cd_flg1", ""));
		setFcastCrrCdFlg2(JSPUtil.getParameter(request, prefix + "fcast_crr_cd_flg2", ""));
		setFcastCrrCdFlg3(JSPUtil.getParameter(request, prefix + "fcast_crr_cd_flg3", ""));
		setFcastCrrCdFlg4(JSPUtil.getParameter(request, prefix + "fcast_crr_cd_flg4", ""));
		setFcastCrrCdFlg5(JSPUtil.getParameter(request, prefix + "fcast_crr_cd_flg5", ""));
		setFcastCrrCdFlg6(JSPUtil.getParameter(request, prefix + "fcast_crr_cd_flg6", ""));
		setFcastCrrCdFlg7(JSPUtil.getParameter(request, prefix + "fcast_crr_cd_flg7", ""));
		setPodChk(JSPUtil.getParameter(request, prefix + "pod_chk", ""));
		setSrl1(JSPUtil.getParameter(request, prefix + "srl1", ""));
		setPodNm2(JSPUtil.getParameter(request, prefix + "pod_nm2", ""));
		setPrctFlg(JSPUtil.getParameter(request, prefix + "prct_flg", ""));
		setImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd", ""));
		setBkgRevMcgoFlg(JSPUtil.getParameter(request, prefix + "bkg_rev_mcgo_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CBFIFSummaryListVO[]
	 */
	public CBFIFSummaryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CBFIFSummaryListVO[]
	 */
	public CBFIFSummaryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CBFIFSummaryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cbfSmrySeq = (JSPUtil.getParameter(request, prefix	+ "cbf_smry_seq", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] full20ftCntrKnt = (JSPUtil.getParameter(request, prefix	+ "full_20ft_cntr_knt", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lfSdOvrDimLen = (JSPUtil.getParameter(request, prefix	+ "lf_sd_ovr_dim_len", length));
			String[] bkg45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "bkg_45ft_hc_qty", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] fwrdOvrDimLen = (JSPUtil.getParameter(request, prefix	+ "fwrd_ovr_dim_len", length));
			String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] hcFull40ftCntrKnt = (JSPUtil.getParameter(request, prefix	+ "hc_full_40ft_cntr_knt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] hgtOvrDimLen = (JSPUtil.getParameter(request, prefix	+ "hgt_ovr_dim_len", length));
			String[] cbfSmryDcgoSeq = (JSPUtil.getParameter(request, prefix	+ "cbf_smry_dcgo_seq", length));
			String[] bkg40ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_40ft_qty", length));
			String[] bkg40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "bkg_40ft_hc_qty", length));
			String[] cntrGrsWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_grs_wgt", length));
			String[] full45ftCntrKnt = (JSPUtil.getParameter(request, prefix	+ "full_45ft_cntr_knt", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] rtSdOvrDimLen = (JSPUtil.getParameter(request, prefix	+ "rt_sd_ovr_dim_len", length));
			String[] full40ftCntrKnt = (JSPUtil.getParameter(request, prefix	+ "full_40ft_cntr_knt", length));
			String[] void20ftQty = (JSPUtil.getParameter(request, prefix	+ "void_20ft_qty", length));
			String[] bkg20ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_20ft_qty", length));
			String[] cgoGrsWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_grs_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hcMty40ftCntrKnt = (JSPUtil.getParameter(request, prefix	+ "hc_mty_40ft_cntr_knt", length));
			String[] usdBkgTtlQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_ttl_qty", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] mty45ftCntrKnt = (JSPUtil.getParameter(request, prefix	+ "mty_45ft_cntr_knt", length));
			String[] mty20ftCntrKnt = (JSPUtil.getParameter(request, prefix	+ "mty_20ft_cntr_knt", length));
			String[] cbfRmk = (JSPUtil.getParameter(request, prefix	+ "cbf_rmk", length));
			String[] mtyBkgFlg = (JSPUtil.getParameter(request, prefix	+ "mty_bkg_flg", length));
			String[] bkwdOvrDimLen = (JSPUtil.getParameter(request, prefix	+ "bkwd_ovr_dim_len", length));
			String[] stwgCgoFlg = (JSPUtil.getParameter(request, prefix	+ "stwg_cgo_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cbfSpclSmrySeq = (JSPUtil.getParameter(request, prefix	+ "cbf_spcl_smry_seq", length));
			String[] bdlCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bdl_cgo_flg", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix	+ "mrn_polut_flg", length));
			String[] mty40ftCntrKnt = (JSPUtil.getParameter(request, prefix	+ "mty_40ft_cntr_knt", length));
			String[] crnPstStsCd = (JSPUtil.getParameter(request, prefix	+ "crn_pst_sts_cd", length));
			String[] cbfIndFlg = (JSPUtil.getParameter(request, prefix	+ "cbf_ind_flg", length));
			String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_flg", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podStwgCd = (JSPUtil.getParameter(request, prefix	+ "pod_stwg_cd", length));
			String[] carrierCd = (JSPUtil.getParameter(request, prefix	+ "carrier_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] conditionGb = (JSPUtil.getParameter(request, prefix	+ "condition_gb", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] cargoType = (JSPUtil.getParameter(request, prefix	+ "cargo_type", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] coLoad = (JSPUtil.getParameter(request, prefix	+ "co_load", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] crrCdFlag = (JSPUtil.getParameter(request, prefix	+ "crr_cd_flag", length));
			String[] fcastCrrCd1 = (JSPUtil.getParameter(request, prefix	+ "fcast_crr_cd1", length));
			String[] fcastCrrCd2 = (JSPUtil.getParameter(request, prefix	+ "fcast_crr_cd2", length));
			String[] fcastCrrCd3 = (JSPUtil.getParameter(request, prefix	+ "fcast_crr_cd3", length));
			String[] fcastCrrCd4 = (JSPUtil.getParameter(request, prefix	+ "fcast_crr_cd4", length));
			String[] fcastCrrCd5 = (JSPUtil.getParameter(request, prefix	+ "fcast_crr_cd5", length));
			String[] fcastCrrCd6 = (JSPUtil.getParameter(request, prefix	+ "fcast_crr_cd6", length));
			String[] fcastCrrCd7 = (JSPUtil.getParameter(request, prefix	+ "fcast_crr_cd7", length));
			String[] fcastCrrCdFlg1 = (JSPUtil.getParameter(request, prefix	+ "fcast_crr_cd_flg1", length));
			String[] fcastCrrCdFlg2 = (JSPUtil.getParameter(request, prefix	+ "fcast_crr_cd_flg2", length));
			String[] fcastCrrCdFlg3 = (JSPUtil.getParameter(request, prefix	+ "fcast_crr_cd_flg3", length));
			String[] fcastCrrCdFlg4 = (JSPUtil.getParameter(request, prefix	+ "fcast_crr_cd_flg4", length));
			String[] fcastCrrCdFlg5 = (JSPUtil.getParameter(request, prefix	+ "fcast_crr_cd_flg5", length));
			String[] fcastCrrCdFlg6 = (JSPUtil.getParameter(request, prefix	+ "fcast_crr_cd_flg6", length));
			String[] fcastCrrCdFlg7 = (JSPUtil.getParameter(request, prefix	+ "fcast_crr_cd_flg7", length));
			String[] podChk = (JSPUtil.getParameter(request, prefix	+ "pod_chk", length));
			String[] srl1 = (JSPUtil.getParameter(request, prefix	+ "srl1", length));
			String[] podNm2 = (JSPUtil.getParameter(request, prefix	+ "pod_nm2", length));
			String[] prctFlg = (JSPUtil.getParameter(request, prefix	+ "prct_flg", length));
			String[] imdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd", length));
			String[] bkgRevMcgoFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_rev_mcgo_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CBFIFSummaryListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cbfSmrySeq[i] != null)
					model.setCbfSmrySeq(cbfSmrySeq[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (full20ftCntrKnt[i] != null)
					model.setFull20ftCntrKnt(full20ftCntrKnt[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lfSdOvrDimLen[i] != null)
					model.setLfSdOvrDimLen(lfSdOvrDimLen[i]);
				if (bkg45ftHcQty[i] != null)
					model.setBkg45ftHcQty(bkg45ftHcQty[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (fwrdOvrDimLen[i] != null)
					model.setFwrdOvrDimLen(fwrdOvrDimLen[i]);
				if (polClptIndSeq[i] != null)
					model.setPolClptIndSeq(polClptIndSeq[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (hcFull40ftCntrKnt[i] != null)
					model.setHcFull40ftCntrKnt(hcFull40ftCntrKnt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (hgtOvrDimLen[i] != null)
					model.setHgtOvrDimLen(hgtOvrDimLen[i]);
				if (cbfSmryDcgoSeq[i] != null)
					model.setCbfSmryDcgoSeq(cbfSmryDcgoSeq[i]);
				if (bkg40ftQty[i] != null)
					model.setBkg40ftQty(bkg40ftQty[i]);
				if (bkg40ftHcQty[i] != null)
					model.setBkg40ftHcQty(bkg40ftHcQty[i]);
				if (cntrGrsWgt[i] != null)
					model.setCntrGrsWgt(cntrGrsWgt[i]);
				if (full45ftCntrKnt[i] != null)
					model.setFull45ftCntrKnt(full45ftCntrKnt[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (rtSdOvrDimLen[i] != null)
					model.setRtSdOvrDimLen(rtSdOvrDimLen[i]);
				if (full40ftCntrKnt[i] != null)
					model.setFull40ftCntrKnt(full40ftCntrKnt[i]);
				if (void20ftQty[i] != null)
					model.setVoid20ftQty(void20ftQty[i]);
				if (bkg20ftQty[i] != null)
					model.setBkg20ftQty(bkg20ftQty[i]);
				if (cgoGrsWgt[i] != null)
					model.setCgoGrsWgt(cgoGrsWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hcMty40ftCntrKnt[i] != null)
					model.setHcMty40ftCntrKnt(hcMty40ftCntrKnt[i]);
				if (usdBkgTtlQty[i] != null)
					model.setUsdBkgTtlQty(usdBkgTtlQty[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (mty45ftCntrKnt[i] != null)
					model.setMty45ftCntrKnt(mty45ftCntrKnt[i]);
				if (mty20ftCntrKnt[i] != null)
					model.setMty20ftCntrKnt(mty20ftCntrKnt[i]);
				if (cbfRmk[i] != null)
					model.setCbfRmk(cbfRmk[i]);
				if (mtyBkgFlg[i] != null)
					model.setMtyBkgFlg(mtyBkgFlg[i]);
				if (bkwdOvrDimLen[i] != null)
					model.setBkwdOvrDimLen(bkwdOvrDimLen[i]);
				if (stwgCgoFlg[i] != null)
					model.setStwgCgoFlg(stwgCgoFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cbfSpclSmrySeq[i] != null)
					model.setCbfSpclSmrySeq(cbfSpclSmrySeq[i]);
				if (bdlCgoFlg[i] != null)
					model.setBdlCgoFlg(bdlCgoFlg[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (mrnPolutFlg[i] != null)
					model.setMrnPolutFlg(mrnPolutFlg[i]);
				if (mty40ftCntrKnt[i] != null)
					model.setMty40ftCntrKnt(mty40ftCntrKnt[i]);
				if (crnPstStsCd[i] != null)
					model.setCrnPstStsCd(crnPstStsCd[i]);
				if (cbfIndFlg[i] != null)
					model.setCbfIndFlg(cbfIndFlg[i]);
				if (imdgLmtQtyFlg[i] != null)
					model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podStwgCd[i] != null)
					model.setPodStwgCd(podStwgCd[i]);
				if (carrierCd[i] != null)
					model.setCarrierCd(carrierCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (conditionGb[i] != null)
					model.setConditionGb(conditionGb[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (cargoType[i] != null)
					model.setCargoType(cargoType[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (coLoad[i] != null)
					model.setCoLoad(coLoad[i]);
				if (crrCdFlag[i] != null)
					model.setCrrCdFlag(crrCdFlag[i]);
				if (fcastCrrCd1[i] != null)
					model.setFcastCrrCd1(fcastCrrCd1[i]);
				if (fcastCrrCd2[i] != null)
					model.setFcastCrrCd2(fcastCrrCd2[i]);
				if (fcastCrrCd3[i] != null)
					model.setFcastCrrCd3(fcastCrrCd3[i]);
				if (fcastCrrCd4[i] != null)
					model.setFcastCrrCd4(fcastCrrCd4[i]);
				if (fcastCrrCd5[i] != null)
					model.setFcastCrrCd5(fcastCrrCd5[i]);
				if (fcastCrrCd6[i] != null)
					model.setFcastCrrCd6(fcastCrrCd6[i]);
				if (fcastCrrCd7[i] != null)
					model.setFcastCrrCd7(fcastCrrCd7[i]);
				if (fcastCrrCdFlg1[i] != null)
					model.setFcastCrrCdFlg1(fcastCrrCdFlg1[i]);
				if (fcastCrrCdFlg2[i] != null)
					model.setFcastCrrCdFlg2(fcastCrrCdFlg2[i]);
				if (fcastCrrCdFlg3[i] != null)
					model.setFcastCrrCdFlg3(fcastCrrCdFlg3[i]);
				if (fcastCrrCdFlg4[i] != null)
					model.setFcastCrrCdFlg4(fcastCrrCdFlg4[i]);
				if (fcastCrrCdFlg5[i] != null)
					model.setFcastCrrCdFlg5(fcastCrrCdFlg5[i]);
				if (fcastCrrCdFlg6[i] != null)
					model.setFcastCrrCdFlg6(fcastCrrCdFlg6[i]);
				if (fcastCrrCdFlg7[i] != null)
					model.setFcastCrrCdFlg7(fcastCrrCdFlg7[i]);
				if (podChk[i] != null)
					model.setPodChk(podChk[i]);
				if (srl1[i] != null)
					model.setSrl1(srl1[i]);
				if (podNm2[i] != null)
					model.setPodNm2(podNm2[i]);
				if (prctFlg[i] != null)
					model.setPrctFlg(prctFlg[i]);
				if (imdgSubsRskLblCd[i] != null)
					model.setImdgSubsRskLblCd(imdgSubsRskLblCd[i]);
				if (bkgRevMcgoFlg[i] != null)
					model.setBkgRevMcgoFlg(bkgRevMcgoFlg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCBFIFSummaryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CBFIFSummaryListVO[]
	 */
	public CBFIFSummaryListVO[] getCBFIFSummaryListVOs(){
		CBFIFSummaryListVO[] vos = (CBFIFSummaryListVO[])models.toArray(new CBFIFSummaryListVO[models.size()]);
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
		this.cbfSmrySeq = this.cbfSmrySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full20ftCntrKnt = this.full20ftCntrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfSdOvrDimLen = this.lfSdOvrDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg45ftHcQty = this.bkg45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwrdOvrDimLen = this.fwrdOvrDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq = this.polClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcFull40ftCntrKnt = this.hcFull40ftCntrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hgtOvrDimLen = this.hgtOvrDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbfSmryDcgoSeq = this.cbfSmryDcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40ftQty = this.bkg40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40ftHcQty = this.bkg40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGrsWgt = this.cntrGrsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full45ftCntrKnt = this.full45ftCntrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSdOvrDimLen = this.rtSdOvrDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full40ftCntrKnt = this.full40ftCntrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.void20ftQty = this.void20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg20ftQty = this.bkg20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoGrsWgt = this.cgoGrsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcMty40ftCntrKnt = this.hcMty40ftCntrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgTtlQty = this.usdBkgTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty45ftCntrKnt = this.mty45ftCntrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty20ftCntrKnt = this.mty20ftCntrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbfRmk = this.cbfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgFlg = this.mtyBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkwdOvrDimLen = this.bkwdOvrDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCgoFlg = this.stwgCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbfSpclSmrySeq = this.cbfSpclSmrySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdlCgoFlg = this.bdlCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPolutFlg = this.mrnPolutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mty40ftCntrKnt = this.mty40ftCntrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnPstStsCd = this.crnPstStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbfIndFlg = this.cbfIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyFlg = this.imdgLmtQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podStwgCd = this.podStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrierCd = this.carrierCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conditionGb = this.conditionGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoType = this.cargoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coLoad = this.coLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCdFlag = this.crrCdFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCrrCd1 = this.fcastCrrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCrrCd2 = this.fcastCrrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCrrCd3 = this.fcastCrrCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCrrCd4 = this.fcastCrrCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCrrCd5 = this.fcastCrrCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCrrCd6 = this.fcastCrrCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCrrCd7 = this.fcastCrrCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCrrCdFlg1 = this.fcastCrrCdFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCrrCdFlg2 = this.fcastCrrCdFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCrrCdFlg3 = this.fcastCrrCdFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCrrCdFlg4 = this.fcastCrrCdFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCrrCdFlg5 = this.fcastCrrCdFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCrrCdFlg6 = this.fcastCrrCdFlg6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCrrCdFlg7 = this.fcastCrrCdFlg7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podChk = this.podChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srl1 = this.srl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm2 = this.podNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prctFlg = this.prctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd = this.imdgSubsRskLblCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRevMcgoFlg = this.bkgRevMcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
