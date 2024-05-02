/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OpfCgoBkgFcastCntrVO.java
 *@FileTitle : OpfCgoBkgFcastCntrVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.05.25 우지석 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author 우지석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CBFListOptionVO extends AbstractValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5956208746645809400L;

	private Collection<CBFListOptionVO> models = new ArrayList<CBFListOptionVO>();

	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String exptQtyFlg = null;
	/* Column Info */
	private String cbfSmrySeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lfSdOvrDimLen = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String polClptIndSeq = null;
	/* Column Info */
	private String podClptIndSeq = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String dimWdt = null;
	/* Column Info */
	private String cntrWgtGrpCd = null;
	/* Column Info */
	private String cntrSeq = null;
	/* Column Info */
	private String cntrSeq2 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String fwrdOvrDimLen = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String cgoSeq = null;
	/* Column Info */
	private String dimHgt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String podClptCd = null;
	/* Column Info */
	private String stwgN2ndRmk = null;
	/* Column Info */
	private String hgtOvrDimLen = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String pckGrpCd = null;
	/* Column Info */
	private String lmtQtyFlg = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String cntrGrsWgt = null;
	/* Column Info */
	private String aproRefNo = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String rtSdOvrDimLen = null;
	/* Column Info */
	private String stwgN1stRmk = null;
	/* Column Info */
	private String spclCgoSeq = null;
	/* Column Info */
	private String prnrBkgRefNo = null;
	/* Column Info */
	private String creDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cgoGrsWgt = null;
	/* Column Info */
	private String cbfSpclCgoCateCd = null;
	/* Column Info */
	private String dimLen = null;
	/* Column Info */
	// private String vslOprTpCd = null;
	private String crrCd = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String spclCgoAuthFlg = null;
	/* Column Info */
	private String mlbCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cbfRmk = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String bkwdOvrDimLen = null;
	/* Column Info */
	private String imdgSubsRskLblCd = null;
	/* Column Info */
	private String fdoTemp = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String bkgShprOwnrFlg = null;
	/* Column Info */
	private String prnrCntrRefNo = null;
	/* Column Info */
	private String cdoTemp = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String imdgMrnPolutCd = null;
	/* Column Info */
	private String crnPstStsCd = null;
	/* Column Info */
	private String cbfIndFlg = null;
	/* Column Info */
	private String cbfBkgStsCd = null;
	/* Column Info */
	private String bkSt = null;
	/* Column Info */
	private String rdSt = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String stwgCgoFlg = null;
	/* Column Info */
	private String pcCgoFlg = null;
	/* Column Info */
	private String allFlg = null;
	/* Column Info */
	private String cbfDpCd = null;
	/* Column Info */
	private String cbfCmdtNm = null;
	/* Column Info */
	private String ovrFwd = null;
	/* Column Info */
	private String ovrAft = null;
	/* Column Info */
	private String ovrLft = null;
	/* Column Info */
	private String ovrRgt = null;
	/* Column Info */
	private String ovrHgt = null;
	/* Column Info */
	private String postExd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String qty1 = null;
	/* Column Info */
	private String qty2 = null;
	/* Column Info */
	private String qty3 = null;
	/* Column Info */
	private String qty4 = null;
	/* Column Info */
	private String qty5 = null;
	/* Column Info */
	private String qty6 = null;
	/* Column Info */
	private String qty7 = null;
	/* Column Info */
	private String qty8 = null;
	/* Column Info */
	private String qty9 = null;
	/* Column Info */
	private String qty10 = null;
	/* Column Info */
	private String prctFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String hzdDesc = null;
	/* Column Info */
	private String acCntrFlg = null;
	
	private String bkgRefNoCtnt = null;
	 
	/* VO Info */
	private List<CBFListOptionVO> cBFListOptionVOs = null;
	
	/**
	 * Column Info
	 * 
	 * @return cBFListOptionVOs
	 */
	public List<CBFListOptionVO> getCBFListOptionVOS() {
		return this.cBFListOptionVOs;
	}
	
	/**
	 * Column Info
	 * 
	 * @param cBFListOptionVOs
	 */
	public void setCBFListOptionVOS(List<CBFListOptionVO> cBFListOptionVOs) {
		this.cBFListOptionVOs = cBFListOptionVOs;
	}

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CBFListOptionVO() {
	}

	public CBFListOptionVO(String ibflag, String pagerows, String vslCd,
			String skdVoyNo, String skdDirCd, String ydCd, String polClptIndSeq, String podClptIndSeq, String vpsPortCd,
			String clptIndSeq, String bkgShprOwnrFlg, String crrCd,
			String cbfSmrySeq, String bkgNo, String bkgNoSplit,
			String prnrBkgRefNo, String cntrSeq, String cntrSeq2, String cgoSeq,
			String spclCgoSeq, String cntrNo, String prnrCntrRefNo,
			String podCd, String podClptCd, String mlbCd, String cbfSpclCgoCateCd,
			String cntrWgtGrpCd, String fullMtyCd, String cntrQty,
			String cntrGrsWgt, String cgoGrsWgt, String cntrTpszCd,
			String imdgClssCd, String imdgUnNo, String imdgSubsRskLblCd,
			String imdgMrnPolutCd, String pckGrpCd, String lmtQtyFlg,
			String exptQtyFlg, String fdoTemp, String cdoTemp, String dimLen,
			String dimWdt, String dimHgt, String fwrdOvrDimLen,
			String bkwdOvrDimLen, String hgtOvrDimLen, String lfSdOvrDimLen,
			String rtSdOvrDimLen, String crnPstStsCd, String stwgCd,
			String stwgN1stRmk, String stwgN2ndRmk, String spclCgoAuthFlg,
			String aproRefNo, String cbfRmk, String creUsrId, String creDt,
			String updUsrId, String updDt, String cbfIndFlg,
			String cbfBkgStsCd, String bkSt, String rdSt, String dcgoFlg,
			String rcFlg, String awkCgoFlg, String bbCgoFlg, String cbfDpCd,
			String cbfCmdtNm, String ovrFwd, String ovrAft, String ovrLft,
			String ovrRgt, String ovrHgt, String postExd, String slanCd, String qty1,
			String qty2, String qty3, String qty4, String qty5, String qty6, String qty7, String qty8, String qty9, String qty10, String stwgCgoFlg,
			String pcCgoFlg, String allFlg, String prctFlg, String bkgStsCd, String prpShpNm, String hzdDesc, String acCntrFlg, String bkgRefNoCtnt) {
		this.vslCd = vslCd;
		this.exptQtyFlg = exptQtyFlg;
		this.cbfSmrySeq = cbfSmrySeq;
		this.pagerows = pagerows;
		this.lfSdOvrDimLen = lfSdOvrDimLen;
		this.ydCd = ydCd;
		this.polClptIndSeq = polClptIndSeq;
		this.podClptIndSeq = podClptIndSeq;
		this.vpsPortCd = vpsPortCd;
		this.dimWdt = dimWdt;
		this.cntrWgtGrpCd = cntrWgtGrpCd;
		this.cntrSeq = cntrSeq;
		this.cntrSeq2 = cntrSeq2;
		this.cntrTpszCd = cntrTpszCd;
		this.fwrdOvrDimLen = fwrdOvrDimLen;
		this.stwgCd = stwgCd;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
		this.cgoSeq = cgoSeq;
		this.dimHgt = dimHgt;
		this.skdVoyNo = skdVoyNo;
		this.podCd = podCd;
		this.podClptCd = podClptCd;
		this.stwgN2ndRmk = stwgN2ndRmk;
		this.hgtOvrDimLen = hgtOvrDimLen;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.pckGrpCd = pckGrpCd;
		this.lmtQtyFlg = lmtQtyFlg;
		this.fullMtyCd = fullMtyCd;
		this.cntrGrsWgt = cntrGrsWgt;
		this.aproRefNo = aproRefNo;
		this.imdgClssCd = imdgClssCd;
		this.rtSdOvrDimLen = rtSdOvrDimLen;
		this.stwgN1stRmk = stwgN1stRmk;
		this.spclCgoSeq = spclCgoSeq;
		this.prnrBkgRefNo = prnrBkgRefNo;
		this.creDt = creDt;
		this.ibflag = ibflag;
		this.cgoGrsWgt = cgoGrsWgt;
		this.cbfSpclCgoCateCd = cbfSpclCgoCateCd;
		this.dimLen = dimLen;
		this.crrCd = crrCd;
		this.cntrQty = cntrQty;
		this.spclCgoAuthFlg = spclCgoAuthFlg;
		this.mlbCd = mlbCd;
		this.updDt = updDt;
		this.cbfRmk = cbfRmk;
		this.bkgNoSplit = bkgNoSplit;
		this.bkwdOvrDimLen = bkwdOvrDimLen;
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
		this.fdoTemp = fdoTemp;
		this.skdDirCd = skdDirCd;
		this.bkgShprOwnrFlg = bkgShprOwnrFlg;
		this.prnrCntrRefNo = prnrCntrRefNo;
		this.cdoTemp = cdoTemp;
		this.cntrNo = cntrNo;
		this.clptIndSeq = clptIndSeq;
		this.imdgMrnPolutCd = imdgMrnPolutCd;
		this.crnPstStsCd = crnPstStsCd;
		this.cbfIndFlg = cbfIndFlg;
		this.cbfBkgStsCd = cbfBkgStsCd;
		this.bkSt = bkSt;
		this.rdSt = rdSt;
		this.dcgoFlg = dcgoFlg;
		this.rcFlg = rcFlg;
		this.awkCgoFlg = awkCgoFlg;
		this.bbCgoFlg = bbCgoFlg;
		this.cbfDpCd = cbfDpCd;
		this.cbfCmdtNm = cbfCmdtNm;
		this.ovrFwd = ovrFwd;
		this.ovrAft = ovrAft;
		this.ovrLft = ovrLft;
		this.ovrRgt = ovrRgt;
		this.ovrHgt = ovrHgt;
		this.postExd = postExd;
		this.slanCd = slanCd;
		this.qty1 = qty1;
		this.qty2 = qty2;
		this.qty3 = qty3;
		this.qty4 = qty4;
		this.qty5 = qty5;
		this.qty6 = qty6;
		this.qty7 = qty7;
		this.qty8 = qty8;
		this.qty9 = qty9;
		this.qty10 = qty10;
		this.stwgCgoFlg = stwgCgoFlg;
		this.pcCgoFlg = pcCgoFlg;
		this.allFlg = allFlg;
		this.prctFlg = prctFlg;
		this.bkgStsCd = bkgStsCd;
		this.prpShpNm = prpShpNm;
		this.hzdDesc = hzdDesc;
		this.acCntrFlg = acCntrFlg;
		this.bkgRefNoCtnt = bkgRefNoCtnt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("expt_qty_flg", getExptQtyFlg());
		this.hashColumns.put("cbf_smry_seq", getCbfSmrySeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lf_sd_ovr_dim_len", getLfSdOvrDimLen());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("dim_wdt", getDimWdt());
		this.hashColumns.put("cntr_wgt_grp_cd", getCntrWgtGrpCd());
		this.hashColumns.put("cntr_seq", getCntrSeq());
		this.hashColumns.put("cntr_seq", getCntrSeq2());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("fwrd_ovr_dim_len", getFwrdOvrDimLen());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("cgo_seq", getCgoSeq());
		this.hashColumns.put("dim_hgt", getDimHgt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pod_clpt_cd", getPodClptCd());
		this.hashColumns.put("stwg_n2nd_rmk", getStwgN2ndRmk());
		this.hashColumns.put("hgt_ovr_dim_len", getHgtOvrDimLen());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pck_grp_cd", getPckGrpCd());
		this.hashColumns.put("lmt_qty_flg", getLmtQtyFlg());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("cntr_grs_wgt", getCntrGrsWgt());
		this.hashColumns.put("apro_ref_no", getAproRefNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("rt_sd_ovr_dim_len", getRtSdOvrDimLen());
		this.hashColumns.put("stwg_n1st_rmk", getStwgN1stRmk());
		this.hashColumns.put("spcl_cgo_seq", getSpclCgoSeq());
		this.hashColumns.put("prnr_bkg_ref_no", getPrnrBkgRefNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cgo_grs_wgt", getCgoGrsWgt());
		this.hashColumns.put("cbf_spcl_cgo_cate_cd", getCbfSpclCgoCateCd());
		this.hashColumns.put("dim_len", getDimLen());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("spcl_cgo_auth_flg", getSpclCgoAuthFlg());
		this.hashColumns.put("mlb_cd", getMlbCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cbf_rmk", getCbfRmk());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("bkwd_ovr_dim_len", getBkwdOvrDimLen());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd", getImdgSubsRskLblCd());
		this.hashColumns.put("fdo_temp", getFdoTemp());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("bkg_shpr_ownr_flg", getBkgShprOwnrFlg());
		this.hashColumns.put("prnr_cntr_ref_no", getPrnrCntrRefNo());
		this.hashColumns.put("cdo_temp", getCdoTemp());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("imdg_mrn_polut_cd", getImdgMrnPolutCd());
		this.hashColumns.put("crn_pst_sts_cd", getCrnPstStsCd());
		this.hashColumns.put("cbf_ind_flg", getCbfIndFlg());
		this.hashColumns.put("cbf_bkg_sts_cd", getCbfBkgStsCd());
		this.hashColumns.put("bk_st", getBkSt());
		this.hashColumns.put("rd_st", getRdSt());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("cbf_dp_cd", getCbfDpCd());
		this.hashColumns.put("cbf_cmdt_nm", getCbfCmdtNm());
		this.hashColumns.put("ovr_fwd", getOvrFwd());
		this.hashColumns.put("ovr_aft", getOvrAft());
		this.hashColumns.put("ovr_lft", getOvrLft());
		this.hashColumns.put("ovr_rgt", getOvrRgt());
		this.hashColumns.put("ovr_hgt", getOvrHgt());
		this.hashColumns.put("post_exd", getPostExd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("qty1", getQty1());
		this.hashColumns.put("qty2", getQty2());
		this.hashColumns.put("qty3", getQty3());
		this.hashColumns.put("qty4", getQty4());
		this.hashColumns.put("qty5", getQty5());
		this.hashColumns.put("qty6", getQty6());
		this.hashColumns.put("qty7", getQty7());
		this.hashColumns.put("qty8", getQty8());
		this.hashColumns.put("qty9", getQty9());
		this.hashColumns.put("qty10", getQty10());
		this.hashColumns.put("stwg_cgo_flg", getStwgCgoFlg());
		this.hashColumns.put("pc_cgo_flg", getPcCgoFlg());
		this.hashColumns.put("prct_flg", getPrctFlg());
		this.hashColumns.put("all_flg", getAllFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("hzd_desc", getHzdDesc());
		this.hashColumns.put("ac_cntr_flg", getAcCntrFlg());
		this.hashColumns.put("bkg_ref_no_ctnt", getBkgRefNoCtnt());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("expt_qty_flg", "exptQtyFlg");
		this.hashFields.put("cbf_smry_seq", "cbfSmrySeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lf_sd_ovr_dim_len", "lfSdOvrDimLen");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("dim_wdt", "dimWdt");
		this.hashFields.put("cntr_wgt_grp_cd", "cntrWgtGrpCd");
		this.hashFields.put("cntr_seq", "cntrSeq");
		this.hashFields.put("cntr_seq", "cntrSeq2");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("fwrd_ovr_dim_len", "fwrdOvrDimLen");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("cgo_seq", "cgoSeq");
		this.hashFields.put("dim_hgt", "dimHgt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pod_clpt_cd", "podClptCd");
		this.hashFields.put("stwg_n2nd_rmk", "stwgN2ndRmk");
		this.hashFields.put("hgt_ovr_dim_len", "hgtOvrDimLen");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pck_grp_cd", "pckGrpCd");
		this.hashFields.put("lmt_qty_flg", "lmtQtyFlg");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("cntr_grs_wgt", "cntrGrsWgt");
		this.hashFields.put("apro_ref_no", "aproRefNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("rt_sd_ovr_dim_len", "rtSdOvrDimLen");
		this.hashFields.put("stwg_n1st_rmk", "stwgN1stRmk");
		this.hashFields.put("spcl_cgo_seq", "spclCgoSeq");
		this.hashFields.put("prnr_bkg_ref_no", "prnrBkgRefNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cgo_grs_wgt", "cgoGrsWgt");
		this.hashFields.put("cbf_spcl_cgo_cate_cd", "cbfSpclCgoCateCd");
		this.hashFields.put("dim_len", "dimLen");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("spcl_cgo_auth_flg", "spclCgoAuthFlg");
		this.hashFields.put("mlb_cd", "mlbCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cbf_rmk", "cbfRmk");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("bkwd_ovr_dim_len", "bkwdOvrDimLen");
		this.hashFields.put("imdg_subs_rsk_lbl_cd", "imdgSubsRskLblCd");
		this.hashFields.put("fdo_temp", "fdoTemp");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("bkg_shpr_ownr_flg", "bkgShprOwnrFlg");
		this.hashFields.put("prnr_cntr_ref_no", "prnrCntrRefNo");
		this.hashFields.put("cdo_temp", "cdoTemp");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("imdg_mrn_polut_cd", "imdgMrnPolutCd");
		this.hashFields.put("crn_pst_sts_cd", "crnPstStsCd");
		this.hashFields.put("cbf_ind_flg", "cbfIndFlg");
		this.hashFields.put("cbf_bkg_sts_cd", "cbfBkgStsCd");
		this.hashFields.put("bk_st", "bkSt");
		this.hashFields.put("rd_st", "rdSt");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("cbf_dp_cd", "cbfDpCd");
		this.hashFields.put("cbf_cmdt_nm", "cbfCmdtNm");
		this.hashFields.put("ovr_fwd", "ovrFwd");
		this.hashFields.put("ovr_aft", "ovrAft");
		this.hashFields.put("ovr_lft", "ovrLft");
		this.hashFields.put("ovr_rgt", "ovrRgt");
		this.hashFields.put("ovr_hgt", "ovrHgt");
		this.hashFields.put("post_exd", "postExd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("qty1", "qty1");
		this.hashFields.put("qty2", "qty2");
		this.hashFields.put("qty3", "qty3");
		this.hashFields.put("qty4", "qty4");
		this.hashFields.put("qty5", "qty5");
		this.hashFields.put("qty6", "qty6");
		this.hashFields.put("qty7", "qty7");
		this.hashFields.put("qty8", "qty8");
		this.hashFields.put("qty9", "qty9");
		this.hashFields.put("qty10", "qty10");
		this.hashFields.put("stwg_cgo_flg", "stwgCgoFlg");
		this.hashFields.put("pc_cgo_flg", "pcCgoFlg");
		this.hashFields.put("prct_flg", "prctFlg");
		this.hashFields.put("all_flg", "allFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("hzd_desc", "hzdDesc");
		this.hashFields.put("ac_cntr_flg", "acCntrFlg");
		this.hashFields.put("bkg_ref_no_ctnt", "bkgRefNoCtnt");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}

	/**
	 * Column Info
	 * 
	 * @return exptQtyFlg
	 */
	public String getExptQtyFlg() {
		return this.exptQtyFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return cbfSmrySeq
	 */
	public String getCbfSmrySeq() {
		return this.cbfSmrySeq;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return lfSdOvrDimLen
	 */
	public String getLfSdOvrDimLen() {
		return this.lfSdOvrDimLen;
	}

	/**
	 * Column Info
	 * 
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * 
	 * @return polClptIndSeq
	 */
	public String getPolClptIndSeq() {
		return this.polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * 
	 * @return podClptIndSeq
	 */
	public String getPodClptIndSeq() {
		return this.podClptIndSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}

	/**
	 * Column Info
	 * 
	 * @return dimWdt
	 */
	public String getDimWdt() {
		return this.dimWdt;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrWgtGrpCd
	 */
	public String getCntrWgtGrpCd() {
		return this.cntrWgtGrpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrSeq
	 */
	public String getCntrSeq() {
		return this.cntrSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrSeq2
	 */
	public String getCntrSeq2() {
		return this.cntrSeq2;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	/**
	 * Column Info
	 * 
	 * @return fwrdOvrDimLen
	 */
	public String getFwrdOvrDimLen() {
		return this.fwrdOvrDimLen;
	}

	/**
	 * Column Info
	 * 
	 * @return stwgCd
	 */
	public String getStwgCd() {
		return this.stwgCd;
	}

	/**
	 * Column Info
	 * 
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}

	/**
	 * Column Info
	 * 
	 * @return cgoSeq
	 */
	public String getCgoSeq() {
		return this.cgoSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return dimHgt
	 */
	public String getDimHgt() {
		return this.dimHgt;
	}

	/**
	 * Column Info
	 * 
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}

	/**
	 * Column Info
	 * 
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * 
	 * @return podClptCd
	 */
	public String getPodClptCd() {
		return this.podClptCd;
	}

	/**
	 * Column Info
	 * 
	 * @return stwgN2ndRmk
	 */
	public String getStwgN2ndRmk() {
		return this.stwgN2ndRmk;
	}

	/**
	 * Column Info
	 * 
	 * @return hgtOvrDimLen
	 */
	public String getHgtOvrDimLen() {
		return this.hgtOvrDimLen;
	}

	/**
	 * Column Info
	 * 
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * 
	 * @return pckGrpCd
	 */
	public String getPckGrpCd() {
		return this.pckGrpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return lmtQtyFlg
	 */
	public String getLmtQtyFlg() {
		return this.lmtQtyFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrGrsWgt
	 */
	public String getCntrGrsWgt() {
		return this.cntrGrsWgt;
	}

	/**
	 * Column Info
	 * 
	 * @return aproRefNo
	 */
	public String getAproRefNo() {
		return this.aproRefNo;
	}

	/**
	 * Column Info
	 * 
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}

	/**
	 * Column Info
	 * 
	 * @return rtSdOvrDimLen
	 */
	public String getRtSdOvrDimLen() {
		return this.rtSdOvrDimLen;
	}

	/**
	 * Column Info
	 * 
	 * @return stwgN1stRmk
	 */
	public String getStwgN1stRmk() {
		return this.stwgN1stRmk;
	}

	/**
	 * Column Info
	 * 
	 * @return spclCgoSeq
	 */
	public String getSpclCgoSeq() {
		return this.spclCgoSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return prnrBkgRefNo
	 */
	public String getPrnrBkgRefNo() {
		return this.prnrBkgRefNo;
	}

	/**
	 * Column Info
	 * 
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return cgoGrsWgt
	 */
	public String getCgoGrsWgt() {
		return this.cgoGrsWgt;
	}

	/**
	 * Column Info
	 * 
	 * @return cbfSpclCgoCateCd
	 */
	public String getCbfSpclCgoCateCd() {
		return this.cbfSpclCgoCateCd;
	}

	/**
	 * Column Info
	 * 
	 * @return dimLen
	 */
	public String getDimLen() {
		return this.dimLen;
	}

	/**
	 * Column Info
	 * 
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}

	/**
	 * Column Info
	 * 
	 * @return spclCgoAuthFlg
	 */
	public String getSpclCgoAuthFlg() {
		return this.spclCgoAuthFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return mlbCd
	 */
	public String getMlbCd() {
		return this.mlbCd;
	}

	/**
	 * Column Info
	 * 
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * Column Info
	 * 
	 * @return cbfRmk
	 */
	public String getCbfRmk() {
		return this.cbfRmk;
	}

	/**
	 * Column Info
	 * 
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
	}

	/**
	 * Column Info
	 * 
	 * @return bkwdOvrDimLen
	 */
	public String getBkwdOvrDimLen() {
		return this.bkwdOvrDimLen;
	}

	/**
	 * Column Info
	 * 
	 * @return imdgSubsRskLblCd
	 */
	public String getImdgSubsRskLblCd() {
		return this.imdgSubsRskLblCd;
	}

	/**
	 * Column Info
	 * 
	 * @return fdoTemp
	 */
	public String getFdoTemp() {
		return this.fdoTemp;
	}

	/**
	 * Column Info
	 * 
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}

	/**
	 * Column Info
	 * 
	 * @return bkgShprOwnrFlg
	 */
	public String getBkgShprOwnrFlg() {
		return this.bkgShprOwnrFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return prnrCntrRefNo
	 */
	public String getPrnrCntrRefNo() {
		return this.prnrCntrRefNo;
	}

	/**
	 * Column Info
	 * 
	 * @return cdoTemp
	 */
	public String getCdoTemp() {
		return this.cdoTemp;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * 
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return imdgMrnPolutCd
	 */
	public String getImdgMrnPolutCd() {
		return this.imdgMrnPolutCd;
	}

	/**
	 * Column Info
	 * 
	 * @return crnPstStsCd
	 */
	public String getCrnPstStsCd() {
		return this.crnPstStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cbfIndFlg
	 */
	public String getCbfIndFlg() {
		return this.cbfIndFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return cbfIndFlg
	 */
	public String getCbfBkgStsCd() {
		return this.cbfBkgStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @return bkSt
	 */
	public String getBkSt() {
		return this.bkSt;
	}

	/**
	 * Column Info
	 * 
	 * @return rdSt
	 */
	public String getRdSt() {
		return this.rdSt;
	}

	/**
	 * Column Info
	 * 
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return cbfDpCd
	 */
	public String getCbfDpCd() {
		return this.cbfDpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cbfCmdtFlg
	 */
	public String getCbfCmdtNm() {
		return this.cbfCmdtNm;
	}

	/**
	 * Column Info
	 * 
	 * @return ovrFwd
	 */
	public String getOvrFwd() {
		return this.ovrFwd;
	}

	/**
	 * Column Info
	 * 
	 * @return ovrAft
	 */
	public String getOvrAft() {
		return this.ovrAft;
	}

	/**
	 * Column Info
	 * 
	 * @return ovrLft
	 */
	public String getOvrLft() {
		return this.ovrLft;
	}

	/**
	 * Column Info
	 * 
	 * @return ovrRgt
	 */
	public String getOvrRgt() {
		return this.ovrRgt;
	}

	/**
	 * Column Info
	 * 
	 * @return ovrHgt
	 */
	public String getOvrHgt() {
		return this.ovrHgt;
	}

	/**
	 * Column Info
	 * 
	 * @return postExd
	 */
	public String getPostExd() {
		return this.postExd;
	}

	/**
	 * Column Info
	 * 
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}

	/**
	 * Page Number
	 * 
	 * @return qty1
	 */
	public String getQty1() {
		return this.qty1;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getQty2() {
		return this.qty2;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getQty3() {
		return this.qty3;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getQty4() {
		return this.qty4;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getQty5() {
		return this.qty5;
	}
	
	/**
	 * Column Info
	 * 
	 * @return qty6
	 */
	public String getQty6() {
		return this.qty6;
	}
	
	/**
	 * Column Info
	 * 
	 * @return qty7
	 */
	public String getQty7() {
		return this.qty7;
	}
	
	/**
	 * Column Info
	 * 
	 * @return qty8
	 */
	public String getQty8() {
		return this.qty8;
	}
	
	/**
	 * Column Info
	 * 
	 * @return qty9
	 */
	public String getQty9() {
		return this.qty9;
	}
	
	/**
	 * Column Info
	 * 
	 * @return qty10
	 */
	public String getQty10() {
		return this.qty10;
	}

	/**
	 * Column Info
	 * 
	 * @return stwgCgoFlg
	 */
	public String getStwgCgoFlg() {
		return this.stwgCgoFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return pcCgoFlg
	 */
	public String getPcCgoFlg() {
		return this.pcCgoFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return prctFlg
	 */
	public String getPrctFlg() {
		return this.prctFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return allFlg
	 */
	public String getAllFlg() {
		return this.allFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * 
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	
	/**
	 * Column Info
	 * 
	 * @return hzdDesc
	 */
	public String getHzdDesc() {
		return this.hzdDesc;
	}
	
	/**
	 * Column Info
	 * 
	 * @return acCntrFlg
	 */
	public String getAcCntrFlg() {
		return this.acCntrFlg;
	}

	public String getBkgRefNoCtnt() {
		return bkgRefNoCtnt;
	}

	public void setBkgRefNoCtnt(String bkgRefNoCtnt) {
		this.bkgRefNoCtnt = bkgRefNoCtnt;
	}

	/**
	 * Column Info
	 * 
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	/**
	 * Column Info
	 * 
	 * @param exptQtyFlg
	 */
	public void setExptQtyFlg(String exptQtyFlg) {
		this.exptQtyFlg = exptQtyFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param cbfSmrySeq
	 */
	public void setCbfSmrySeq(String cbfSmrySeq) {
		this.cbfSmrySeq = cbfSmrySeq;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param lfSdOvrDimLen
	 */
	public void setLfSdOvrDimLen(String lfSdOvrDimLen) {
		this.lfSdOvrDimLen = lfSdOvrDimLen;
	}

	/**
	 * Column Info
	 * 
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * 
	 * @param polClptIndSeq
	 */
	public void setPolClptIndSeq(String polClptIndSeq) {
		this.polClptIndSeq = polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * 
	 * @param podClptIndSeq
	 */
	public void setPodClptIndSeq(String podClptIndSeq) {
		this.podClptIndSeq = podClptIndSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}

	/**
	 * Column Info
	 * 
	 * @param dimWdt
	 */
	public void setDimWdt(String dimWdt) {
		this.dimWdt = dimWdt;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrWgtGrpCd
	 */
	public void setCntrWgtGrpCd(String cntrWgtGrpCd) {
		this.cntrWgtGrpCd = cntrWgtGrpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrSeq
	 */
	public void setCntrSeq(String cntrSeq) {
		this.cntrSeq = cntrSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrSeq2
	 */
	public void setCntrSeq2(String cntrSeq2) {
		this.cntrSeq2 = cntrSeq2;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * Column Info
	 * 
	 * @param fwrdOvrDimLen
	 */
	public void setFwrdOvrDimLen(String fwrdOvrDimLen) {
		this.fwrdOvrDimLen = fwrdOvrDimLen;
	}

	/**
	 * Column Info
	 * 
	 * @param stwgCd
	 */
	public void setStwgCd(String stwgCd) {
		this.stwgCd = stwgCd;
	}

	/**
	 * Column Info
	 * 
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}

	/**
	 * Column Info
	 * 
	 * @param cgoSeq
	 */
	public void setCgoSeq(String cgoSeq) {
		this.cgoSeq = cgoSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param dimHgt
	 */
	public void setDimHgt(String dimHgt) {
		this.dimHgt = dimHgt;
	}

	/**
	 * Column Info
	 * 
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	/**
	 * Column Info
	 * 
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * 
	 * @param podClptCd
	 */
	public void setPodClptCd(String podClptCd) {
		this.podClptCd = podClptCd;
	}

	/**
	 * Column Info
	 * 
	 * @param stwgN2ndRmk
	 */
	public void setStwgN2ndRmk(String stwgN2ndRmk) {
		this.stwgN2ndRmk = stwgN2ndRmk;
	}

	/**
	 * Column Info
	 * 
	 * @param hgtOvrDimLen
	 */
	public void setHgtOvrDimLen(String hgtOvrDimLen) {
		this.hgtOvrDimLen = hgtOvrDimLen;
	}

	/**
	 * Column Info
	 * 
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * 
	 * @param pckGrpCd
	 */
	public void setPckGrpCd(String pckGrpCd) {
		this.pckGrpCd = pckGrpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param lmtQtyFlg
	 */
	public void setLmtQtyFlg(String lmtQtyFlg) {
		this.lmtQtyFlg = lmtQtyFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrGrsWgt
	 */
	public void setCntrGrsWgt(String cntrGrsWgt) {
		this.cntrGrsWgt = cntrGrsWgt;
	}

	/**
	 * Column Info
	 * 
	 * @param aproRefNo
	 */
	public void setAproRefNo(String aproRefNo) {
		this.aproRefNo = aproRefNo;
	}

	/**
	 * Column Info
	 * 
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}

	/**
	 * Column Info
	 * 
	 * @param rtSdOvrDimLen
	 */
	public void setRtSdOvrDimLen(String rtSdOvrDimLen) {
		this.rtSdOvrDimLen = rtSdOvrDimLen;
	}

	/**
	 * Column Info
	 * 
	 * @param stwgN1stRmk
	 */
	public void setStwgN1stRmk(String stwgN1stRmk) {
		this.stwgN1stRmk = stwgN1stRmk;
	}

	/**
	 * Column Info
	 * 
	 * @param spclCgoSeq
	 */
	public void setSpclCgoSeq(String spclCgoSeq) {
		this.spclCgoSeq = spclCgoSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param prnrBkgRefNo
	 */
	public void setPrnrBkgRefNo(String prnrBkgRefNo) {
		this.prnrBkgRefNo = prnrBkgRefNo;
	}

	/**
	 * Column Info
	 * 
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param cgoGrsWgt
	 */
	public void setCgoGrsWgt(String cgoGrsWgt) {
		this.cgoGrsWgt = cgoGrsWgt;
	}

	/**
	 * Column Info
	 * 
	 * @param cbfSpclCgoCateCd
	 */
	public void setCbfSpclCgoCateCd(String cBFSpclCgoCateCd) {
		this.cbfSpclCgoCateCd = cBFSpclCgoCateCd;
	}

	/**
	 * Column Info
	 * 
	 * @param dimLen
	 */
	public void setDimLen(String dimLen) {
		this.dimLen = dimLen;
	}

	/**
	 * Column Info
	 * 
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}

	/**
	 * Column Info
	 * 
	 * @param spclCgoAuthFlg
	 */
	public void setSpclCgoAuthFlg(String spclCgoAuthFlg) {
		this.spclCgoAuthFlg = spclCgoAuthFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param mlbCd
	 */
	public void setMlbCd(String mlbCd) {
		this.mlbCd = mlbCd;
	}

	/**
	 * Column Info
	 * 
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * 
	 * @param cbfRmk
	 */
	public void setCbfRmk(String cbfRmk) {
		this.cbfRmk = cbfRmk;
	}

	/**
	 * Column Info
	 * 
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
	}

	/**
	 * Column Info
	 * 
	 * @param bkwdOvrDimLen
	 */
	public void setBkwdOvrDimLen(String bkwdOvrDimLen) {
		this.bkwdOvrDimLen = bkwdOvrDimLen;
	}

	/**
	 * Column Info
	 * 
	 * @param imdgSubsRskLblCd
	 */
	public void setImdgSubsRskLblCd(String imdgSubsRskLblCd) {
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
	}

	/**
	 * Column Info
	 * 
	 * @param fdoTemp
	 */
	public void setFdoTemp(String fdoTemp) {
		this.fdoTemp = fdoTemp;
	}

	/**
	 * Column Info
	 * 
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	/**
	 * Column Info
	 * 
	 * @param bkgShprOwnrFlg
	 */
	public void setBkgShprOwnrFlg(String bkgShprOwnrFlg) {
		this.bkgShprOwnrFlg = bkgShprOwnrFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param prnrCntrRefNo
	 */
	public void setPrnrCntrRefNo(String prnrCntrRefNo) {
		this.prnrCntrRefNo = prnrCntrRefNo;
	}

	/**
	 * Column Info
	 * 
	 * @param cdoTemp
	 */
	public void setCdoTemp(String cdoTemp) {
		this.cdoTemp = cdoTemp;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * 
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param imdgMrnPolutCd
	 */
	public void setImdgMrnPolutCd(String imdgMrnPolutCd) {
		this.imdgMrnPolutCd = imdgMrnPolutCd;
	}

	/**
	 * Column Info
	 * 
	 * @param crnPstStsCd
	 */
	public void setCrnPstStsCd(String crnPstStsCd) {
		this.crnPstStsCd = crnPstStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cbfIndFlg
	 */
	public void setCbfIndFlg(String cbfIndFlg) {
		this.cbfIndFlg = cbfIndFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param cbfIndFlg
	 */
	public void setCbfBkgStsCd(String cbfBkgStsCd) {
		this.cbfBkgStsCd = cbfBkgStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @param bkSt
	 */
	public void setBkSt(String bkSt) {
		this.bkSt = bkSt;
	}

	/**
	 * Column Info
	 * 
	 * @param rdSt
	 */
	public void setRdSt(String rdst) {
		this.rdSt = rdst;
	}

	/**
	 * Column Info
	 * 
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param cbfDpCd
	 */
	public void setCbfDpCd(String cbfDpCd) {
		this.cbfDpCd = cbfDpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cbfCmdtFlg
	 */
	public void setCbfCmdtNm(String cbfCmdtNm) {
		this.cbfCmdtNm = cbfCmdtNm;
	}

	/**
	 * Column Info
	 * 
	 * @param ovrFwd
	 */
	public void setOvrFwd(String ovrFwd) {
		this.ovrFwd = ovrFwd;
	}

	/**
	 * Column Info
	 * 
	 * @param ovrAft
	 */
	public void setOvrAft(String ovrAft) {
		this.ovrAft = ovrAft;
	}

	/**
	 * Column Info
	 * 
	 * @param ovrFwd
	 */
	public void setOvrLft(String ovrLft) {
		this.ovrLft = ovrLft;
	}

	/**
	 * Column Info
	 * 
	 * @param ovrFwd
	 */
	public void setOvrRgt(String ovrRgt) {
		this.ovrRgt = ovrRgt;
	}

	/**
	 * Column Info
	 * 
	 * @param ovrFwd
	 */
	public void setOvrHgt(String ovrHgt) {
		this.ovrHgt = ovrHgt;
	}

	/**
	 * Column Info
	 * 
	 * @param postExd
	 */
	public void setPostExd(String postExd) {
		this.postExd = postExd;
	}

	/**
	 * Column Info
	 * 
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}

	/**
	 * Page Number
	 * 
	 * @param qty1
	 */
	public void setQty1(String qty1) {
		this.qty1 = qty1;
	}

	/**
	 * Page Number
	 * 
	 * @param qty2
	 */
	public void setQty2(String qty2) {
		this.qty2 = qty2;
	}

	/**
	 * Page Number
	 * 
	 * @param qty3
	 */
	public void setQty3(String qty3) {
		this.qty3 = qty3;
	}

	/**
	 * Page Number
	 * 
	 * @param qty4
	 */
	public void setQty4(String qty4) {
		this.qty4 = qty4;
	}

	/**
	 * Page Number
	 * 
	 * @param qty5
	 */
	public void setQty5(String qty5) {
		this.qty5 = qty5;
	}
	
	/**
	 * Column Info
	 * 
	 * @param qty6
	 */
	public void setQty6(String qty6) {
		this.qty6 = qty6;
	}
	
	/**
	 * Column Info
	 * 
	 * @param qty7
	 */
	public void setQty7(String qty7) {
		this.qty7 = qty7;
	}
	
	/**
	 * Column Info
	 * 
	 * @param qty8
	 */
	public void setQty8(String qty8) {
		this.qty8 = qty8;
	}
	
	/**
	 * Column Info
	 * 
	 * @param qty9
	 */
	public void setQty9(String qty9) {
		this.qty9 = qty9;
	}
	
	/**
	 * Column Info
	 * 
	 * @param qty10
	 */
	public void setQty10(String qty10) {
		this.qty10 = qty10;
	}

	/**
	 * Column Info
	 * 
	 * @param stwgCgoFlg
	 */
	public void setStwgCgoFlg(String stwgCgoFlg) {
		this.stwgCgoFlg = stwgCgoFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param pcCgoFlg
	 */
	public void setPcCgoFlg(String pcCgoFlg) {
		this.pcCgoFlg = pcCgoFlg;
	}
	
	/**
	 * Column Info
	 * 
	 * @param prctFlg
	 */
	public void setPrctFlg(String prctFlg) {
		this.prctFlg = prctFlg;
	}
	
	/**
	 * Column Info
	 * 
	 * @param allFlg
	 */
	public void setAllFlg(String allFlg) {
		this.allFlg = allFlg;
	}
	
	/**
	 * Column Info
	 * 
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * 
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * Column Info
	 * 
	 * @param hzdDesc
	 */
	public void setHzdDesc(String hzdDesc) {
		this.hzdDesc = hzdDesc;
	}
	
	/**
	 * Column Info
	 * 
	 * @param acCntrFlg
	 */
	public void setAcCntrFlg(String acCntrFlg) {
		this.acCntrFlg = acCntrFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setExptQtyFlg(JSPUtil.getParameter(request, "expt_qty_flg", ""));
		setCbfSmrySeq(JSPUtil.getParameter(request, "cbf_smry_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLfSdOvrDimLen(JSPUtil.getParameter(request, "lf_sd_ovr_dim_len", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setPolClptIndSeq(JSPUtil.getParameter(request, "pol_clpt_ind_seq", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, "pod_clpt_ind_seq", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setDimWdt(JSPUtil.getParameter(request, "dim_wdt", ""));
		setCntrWgtGrpCd(JSPUtil.getParameter(request, "cntr_wgt_grp_cd", ""));
		setCntrSeq(JSPUtil.getParameter(request, "cntr_seq", ""));
		setCntrSeq2(JSPUtil.getParameter(request, "cntr_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setFwrdOvrDimLen(JSPUtil.getParameter(request, "fwrd_ovr_dim_len", ""));
		setStwgCd(JSPUtil.getParameter(request, "stwg_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setCgoSeq(JSPUtil.getParameter(request, "cgo_seq", ""));
		setDimHgt(JSPUtil.getParameter(request, "dim_hgt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPodClptCd(JSPUtil.getParameter(request, "pod_clpt_cd", ""));
		setStwgN2ndRmk(JSPUtil.getParameter(request, "stwg_n2nd_rmk", ""));
		setHgtOvrDimLen(JSPUtil.getParameter(request, "hgt_ovr_dim_len", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPckGrpCd(JSPUtil.getParameter(request, "pck_grp_cd", ""));
		setLmtQtyFlg(JSPUtil.getParameter(request, "lmt_qty_flg", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setCntrGrsWgt(JSPUtil.getParameter(request, "cntr_grs_wgt", ""));
		setAproRefNo(JSPUtil.getParameter(request, "apro_ref_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setRtSdOvrDimLen(JSPUtil.getParameter(request, "rt_sd_ovr_dim_len", ""));
		setStwgN1stRmk(JSPUtil.getParameter(request, "stwg_n1st_rmk", ""));
		setSpclCgoSeq(JSPUtil.getParameter(request, "spcl_cgo_seq", ""));
		setPrnrBkgRefNo(JSPUtil.getParameter(request, "prnr_bkg_ref_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCgoGrsWgt(JSPUtil.getParameter(request, "cgo_grs_wgt", ""));
		setCbfSpclCgoCateCd(JSPUtil.getParameter(request, "cbf_spcl_cgo_cate_cd", ""));
		setDimLen(JSPUtil.getParameter(request, "dim_len", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setCntrQty(JSPUtil.getParameter(request, "cntr_qty", ""));
		setSpclCgoAuthFlg(JSPUtil
				.getParameter(request, "spcl_cgo_auth_flg", ""));
		setMlbCd(JSPUtil.getParameter(request, "mlb_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCbfRmk(JSPUtil.getParameter(request, "cbf_rmk", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setBkwdOvrDimLen(JSPUtil.getParameter(request, "bkwd_ovr_dim_len", ""));
		setImdgSubsRskLblCd(JSPUtil.getParameter(request,
				"imdg_subs_rsk_lbl_cd", ""));
		setFdoTemp(JSPUtil.getParameter(request, "fdo_temp", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setBkgShprOwnrFlg(JSPUtil
				.getParameter(request, "bkg_shpr_ownr_flg", ""));
		setPrnrCntrRefNo(JSPUtil.getParameter(request, "prnr_cntr_ref_no", ""));
		setCdoTemp(JSPUtil.getParameter(request, "cdo_temp", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		setImdgMrnPolutCd(JSPUtil
				.getParameter(request, "imdg_mrn_polut_cd", ""));
		setCrnPstStsCd(JSPUtil.getParameter(request, "crn_pst_sts_cd", ""));
		setCbfIndFlg(JSPUtil.getParameter(request, "cbf_ind_flg", ""));
		setCbfBkgStsCd(JSPUtil.getParameter(request, "cbf_bkg_sts_cd", ""));
		setBkSt(JSPUtil.getParameter(request, "bk_st", ""));
		setRdSt(JSPUtil.getParameter(request, "rd_st", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setCbfDpCd(JSPUtil.getParameter(request, "cbf_dp_cd", ""));
		setCbfCmdtNm(JSPUtil.getParameter(request, "cbf_cmdt_nm", ""));
		setOvrFwd(JSPUtil.getParameter(request, "ovr_fwd", ""));
		setOvrAft(JSPUtil.getParameter(request, "ovr_aft", ""));
		setOvrLft(JSPUtil.getParameter(request, "ovr_lft", ""));
		setOvrRgt(JSPUtil.getParameter(request, "ovr_rgt", ""));
		setOvrHgt(JSPUtil.getParameter(request, "ovr_hgt", ""));
		setPostExd(JSPUtil.getParameter(request, "post_exd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setQty1(JSPUtil.getParameter(request, "qty1", ""));
		setQty2(JSPUtil.getParameter(request, "qty2", ""));
		setQty3(JSPUtil.getParameter(request, "qty3", ""));
		setQty4(JSPUtil.getParameter(request, "qty4", ""));
		setQty5(JSPUtil.getParameter(request, "qty5", ""));
		setQty6(JSPUtil.getParameter(request, "qty6", ""));
		setQty7(JSPUtil.getParameter(request, "qty7", ""));
		setQty8(JSPUtil.getParameter(request, "qty8", ""));
		setQty9(JSPUtil.getParameter(request, "qty9", ""));
		setQty10(JSPUtil.getParameter(request, "qty10", ""));
		setStwgCgoFlg(JSPUtil.getParameter(request, "stwg_cgo_flg", ""));
		setPcCgoFlg(JSPUtil.getParameter(request, "pc_cgo_flg", ""));
		setPrctFlg(JSPUtil.getParameter(request, "prct_flg", ""));
		setAllFlg(JSPUtil.getParameter(request, "all_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setPrpShpNm(JSPUtil.getParameter(request, "prp_shp_nm", ""));
		setHzdDesc(JSPUtil.getParameter(request, "hzd_desc", ""));
		setAcCntrFlg(JSPUtil.getParameter(request, "ac_cntr_flg", ""));
		setBkgRefNoCtnt(JSPUtil.getParameter(request, "bkg_ref_no_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return OpfCgoBkgFcastCntrVO[]
	 */
	public CBFListOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return OpfCgoBkgFcastCntrVO[]
	 */
	public CBFListOptionVO[] fromRequestGrid(HttpServletRequest request,
			String prefix) {
		CBFListOptionVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix
					+ "vsl_cd".trim(), length));
			String[] exptQtyFlg = (JSPUtil.getParameter(request, prefix
					+ "expt_qty_flg".trim(), length));
			String[] cbfSmrySeq = (JSPUtil.getParameter(request, prefix
					+ "cbf_smry_seq".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix
					+ "pagerows".trim(), length));
			String[] lfSdOvrDimLen = (JSPUtil.getParameter(request, prefix
					+ "lf_sd_ovr_dim_len".trim(), length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix
					+ "yd_cd".trim(), length));
			String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix
					+ "pol_clpt_ind_seq".trim(), length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix
					+ "pod_clpt_ind_seq".trim(), length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix
					+ "vps_port_cd".trim(), length));
			String[] dimWdt = (JSPUtil.getParameter(request, prefix
					+ "dim_wdt".trim(), length));
			String[] cntrWgtGrpCd = (JSPUtil.getParameter(request, prefix
					+ "cntr_wgt_grp_cd".trim(), length));
			String[] cntrSeq = (JSPUtil.getParameter(request, prefix
					+ "cntr_seq".trim(), length));
			String[] cntrSeq2 = (JSPUtil.getParameter(request, prefix
					+ "cntr_seq".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix
					+ "cntr_tpsz_cd".trim(), length));
			String[] fwrdOvrDimLen = (JSPUtil.getParameter(request, prefix
					+ "fwrd_ovr_dim_len".trim(), length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix
					+ "stwg_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix
					+ "upd_usr_id".trim(), length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix
					+ "imdg_un_no".trim(), length));
			String[] cgoSeq = (JSPUtil.getParameter(request, prefix
					+ "cgo_seq".trim(), length));
			String[] dimHgt = (JSPUtil.getParameter(request, prefix
					+ "dim_hgt".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix
					+ "skd_voy_no".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix
					+ "pod_cd".trim(), length));
			String[] podClptCd = (JSPUtil.getParameter(request, prefix
					+ "pod_clpt_cd".trim(), length));
			String[] stwgN2ndRmk = (JSPUtil.getParameter(request, prefix
					+ "stwg_n2nd_rmk".trim(), length));
			String[] hgtOvrDimLen = (JSPUtil.getParameter(request, prefix
					+ "hgt_ovr_dim_len".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix
					+ "cre_usr_id".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix
					+ "bkg_no".trim(), length));
			String[] pckGrpCd = (JSPUtil.getParameter(request, prefix
					+ "pck_grp_cd".trim(), length));
			String[] lmtQtyFlg = (JSPUtil.getParameter(request, prefix
					+ "lmt_qty_flg".trim(), length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix
					+ "full_mty_cd".trim(), length));
			String[] cntrGrsWgt = (JSPUtil.getParameter(request, prefix
					+ "cntr_grs_wgt".trim(), length));
			String[] aproRefNo = (JSPUtil.getParameter(request, prefix
					+ "apro_ref_no".trim(), length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix
					+ "imdg_clss_cd".trim(), length));
			String[] rtSdOvrDimLen = (JSPUtil.getParameter(request, prefix
					+ "rt_sd_ovr_dim_len".trim(), length));
			String[] stwgN1stRmk = (JSPUtil.getParameter(request, prefix
					+ "stwg_n1st_rmk".trim(), length));
			String[] spclCgoSeq = (JSPUtil.getParameter(request, prefix
					+ "spcl_cgo_seq".trim(), length));
			String[] prnrBkgRefNo = (JSPUtil.getParameter(request, prefix
					+ "prnr_bkg_ref_no".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix
					+ "cre_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix
					+ "ibflag".trim(), length));
			String[] cgoGrsWgt = (JSPUtil.getParameter(request, prefix
					+ "cgo_grs_wgt".trim(), length));
			String[] cbfSpclCgoCateCd = (JSPUtil.getParameter(request, prefix
					+ "cbf_spcl_cgo_cate_cd".trim(), length));
			String[] dimLen = (JSPUtil.getParameter(request, prefix
					+ "dim_len".trim(), length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix
					+ "crr_cd".trim(), length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix
					+ "cntr_qty".trim(), length));
			String[] spclCgoAuthFlg = (JSPUtil.getParameter(request, prefix
					+ "spcl_cgo_auth_flg".trim(), length));
			String[] mlbCd = (JSPUtil.getParameter(request, prefix
					+ "mlb_cd".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix
					+ "upd_dt".trim(), length));
			String[] cbfRmk = (JSPUtil.getParameter(request, prefix
					+ "cbf_rmk".trim(), length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix
					+ "bkg_no_split".trim(), length));
			String[] bkwdOvrDimLen = (JSPUtil.getParameter(request, prefix
					+ "bkwd_ovr_dim_len".trim(), length));
			String[] imdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix
					+ "imdg_subs_rsk_lbl_cd".trim(), length));
			String[] fdoTemp = (JSPUtil.getParameter(request, prefix
					+ "fdo_temp".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix
					+ "skd_dir_cd".trim(), length));
			String[] bkgShprOwnrFlg = (JSPUtil.getParameter(request, prefix
					+ "bkg_shpr_ownr_flg".trim(), length));
			String[] prnrCntrRefNo = (JSPUtil.getParameter(request, prefix
					+ "prnr_cntr_ref_no".trim(), length));
			String[] cdoTemp = (JSPUtil.getParameter(request, prefix
					+ "cdo_temp".trim(), length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix
					+ "cntr_no".trim(), length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix
					+ "clpt_ind_seq".trim(), length));
			String[] imdgMrnPolutCd = (JSPUtil.getParameter(request, prefix
					+ "imdg_mrn_polut_cd".trim(), length));
			String[] crnPstStsCd = (JSPUtil.getParameter(request, prefix
					+ "crn_pst_sts_cd".trim(), length));
			String[] cbfIndFlg = (JSPUtil.getParameter(request, prefix
					+ "cbf_ind_flg".trim(), length));
			String[] cbfBkgStsCd = (JSPUtil.getParameter(request, prefix
					+ "cbf_bkg_sts_cd".trim(), length));
			String[] bkSt = (JSPUtil.getParameter(request, prefix
					+ "bk_st".trim(), length));
			String[] rdSt = (JSPUtil.getParameter(request, prefix
					+ "rd_st".trim(), length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix
					+ "dcgo_flg".trim(), length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix
					+ "rc_flg".trim(), length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix
					+ "awk_cgo_flg".trim(), length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix
					+ "bb_cgo_flg".trim(), length));
			String[] cbfDpCd = (JSPUtil.getParameter(request, prefix
					+ "cbf_dp_cd".trim(), length));
			String[] cbfCmdtNm = (JSPUtil.getParameter(request, prefix
					+ "cbf_cmdt_nm".trim(), length));
			String[] ovrFwd = (JSPUtil.getParameter(request, prefix
					+ "ovr_fwd".trim(), length));
			String[] ovrAft = (JSPUtil.getParameter(request, prefix
					+ "ovr_aft".trim(), length));
			String[] ovrLft = (JSPUtil.getParameter(request, prefix
					+ "ovr_lft".trim(), length));
			String[] ovrRgt = (JSPUtil.getParameter(request, prefix
					+ "ovr_rgt".trim(), length));
			String[] ovrHgt = (JSPUtil.getParameter(request, prefix
					+ "ovr_hgt".trim(), length));
			String[] postExd = (JSPUtil.getParameter(request, prefix
					+ "post_exd".trim(), length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix
					+ "slan_cd".trim(), length));
			String[] qty1 = (JSPUtil.getParameter(request, prefix + "qty1",
					length));
			String[] qty2 = (JSPUtil.getParameter(request, prefix + "qty2",
					length));
			String[] qty3 = (JSPUtil.getParameter(request, prefix + "qty3",
					length));
			String[] qty4 = (JSPUtil.getParameter(request, prefix + "qty4",
					length));
			String[] qty5 = (JSPUtil.getParameter(request, prefix + "qty5",
					length));
			String[] qty6 = (JSPUtil.getParameter(request, prefix + "qty6",
					length));
			String[] qty7 = (JSPUtil.getParameter(request, prefix + "qty7",
					length));
			String[] qty8 = (JSPUtil.getParameter(request, prefix + "qty8",
					length));
			String[] qty9 = (JSPUtil.getParameter(request, prefix + "qty9",
					length));
			String[] qty10 = (JSPUtil.getParameter(request, prefix + "qty10",
					length));
			String[] stwgCgoFlg = (JSPUtil.getParameter(request, prefix
					+ "stwg_cgo_flg", length));
			String[] pcCgoFlg = (JSPUtil.getParameter(request, prefix
					+ "pc_cgo_flg", length));
			String[] prctFlg = (JSPUtil.getParameter(request, prefix
					+ "prct_flg", length));
			String[] allFlg = (JSPUtil.getParameter(request, prefix
					+ "all_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix
					+ "bkg_sts_cd", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix
					+ "prp_shp_nm", length));
			String[] hzdDesc = (JSPUtil.getParameter(request, prefix
					+ "hzd_desc", length));
			String[] acCntrFlg = (JSPUtil.getParameter(request, prefix
					+ "ac_cntr_flg", length));
			String[] bkgRefNoCtnt = (JSPUtil.getParameter(request, prefix
					+ "bkg_ref_no_ctnt", length));			

			for (int i = 0; i < length; i++) {
				model = new CBFListOptionVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (exptQtyFlg[i] != null)
					model.setExptQtyFlg(exptQtyFlg[i]);
				if (cbfSmrySeq[i] != null)
					model.setCbfSmrySeq(cbfSmrySeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lfSdOvrDimLen[i] != null)
					model.setLfSdOvrDimLen(lfSdOvrDimLen[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (polClptIndSeq[i] != null)
					model.setPolClptIndSeq(polClptIndSeq[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (dimWdt[i] != null)
					model.setDimWdt(dimWdt[i]);
				if (cntrWgtGrpCd[i] != null)
					model.setCntrWgtGrpCd(cntrWgtGrpCd[i]);
				if (cntrSeq[i] != null)
					model.setCntrSeq(cntrSeq[i]);
				if (cntrSeq2[i] != null)
					model.setCntrSeq2(cntrSeq2[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (fwrdOvrDimLen[i] != null)
					model.setFwrdOvrDimLen(fwrdOvrDimLen[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (cgoSeq[i] != null)
					model.setCgoSeq(cgoSeq[i]);
				if (dimHgt[i] != null)
					model.setDimHgt(dimHgt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (podClptCd[i] != null)
					model.setPodClptCd(podClptCd[i]);
				if (stwgN2ndRmk[i] != null)
					model.setStwgN2ndRmk(stwgN2ndRmk[i]);
				if (hgtOvrDimLen[i] != null)
					model.setHgtOvrDimLen(hgtOvrDimLen[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (pckGrpCd[i] != null)
					model.setPckGrpCd(pckGrpCd[i]);
				if (lmtQtyFlg[i] != null)
					model.setLmtQtyFlg(lmtQtyFlg[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (cntrGrsWgt[i] != null)
					model.setCntrGrsWgt(cntrGrsWgt[i]);
				if (aproRefNo[i] != null)
					model.setAproRefNo(aproRefNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (rtSdOvrDimLen[i] != null)
					model.setRtSdOvrDimLen(rtSdOvrDimLen[i]);
				if (stwgN1stRmk[i] != null)
					model.setStwgN1stRmk(stwgN1stRmk[i]);
				if (spclCgoSeq[i] != null)
					model.setSpclCgoSeq(spclCgoSeq[i]);
				if (prnrBkgRefNo[i] != null)
					model.setPrnrBkgRefNo(prnrBkgRefNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cgoGrsWgt[i] != null)
					model.setCgoGrsWgt(cgoGrsWgt[i]);
				if (cbfSpclCgoCateCd[i] != null)
					model.setCbfSpclCgoCateCd(cbfSpclCgoCateCd[i]);
				if (dimLen[i] != null)
					model.setDimLen(dimLen[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (spclCgoAuthFlg[i] != null)
					model.setSpclCgoAuthFlg(spclCgoAuthFlg[i]);
				if (mlbCd[i] != null)
					model.setMlbCd(mlbCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cbfRmk[i] != null)
					model.setCbfRmk(cbfRmk[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (bkwdOvrDimLen[i] != null)
					model.setBkwdOvrDimLen(bkwdOvrDimLen[i]);
				if (imdgSubsRskLblCd[i] != null)
					model.setImdgSubsRskLblCd(imdgSubsRskLblCd[i]);
				if (fdoTemp[i] != null)
					model.setFdoTemp(fdoTemp[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (bkgShprOwnrFlg[i] != null)
					model.setBkgShprOwnrFlg(bkgShprOwnrFlg[i]);
				if (prnrCntrRefNo[i] != null)
					model.setPrnrCntrRefNo(prnrCntrRefNo[i]);
				if (cdoTemp[i] != null)
					model.setCdoTemp(cdoTemp[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (imdgMrnPolutCd[i] != null)
					model.setImdgMrnPolutCd(imdgMrnPolutCd[i]);
				if (crnPstStsCd[i] != null)
					model.setCrnPstStsCd(crnPstStsCd[i]);
				if (cbfIndFlg[i] != null)
					model.setCbfIndFlg(cbfIndFlg[i]);
				if (cbfBkgStsCd[i] != null)
					model.setCbfBkgStsCd(cbfBkgStsCd[i]);
				if (bkSt[i] != null)
					model.setBkSt(bkSt[i]);
				if (rdSt[i] != null)
					model.setRdSt(rdSt[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (cbfDpCd[i] != null)
					model.setCbfDpCd(cbfDpCd[i]);
				if (cbfCmdtNm[i] != null)
					model.setCbfCmdtNm(cbfCmdtNm[i]);
				if (ovrFwd[i] != null)
					model.setOvrFwd(ovrFwd[i]);
				if (ovrAft[i] != null)
					model.setOvrAft(ovrAft[i]);
				if (ovrLft[i] != null)
					model.setOvrLft(ovrLft[i]);
				if (ovrRgt[i] != null)
					model.setOvrRgt(ovrRgt[i]);
				if (ovrHgt[i] != null)
					model.setOvrHgt(ovrHgt[i]);
				if (postExd[i] != null)
					model.setPostExd(postExd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (qty1[i] != null)
					model.setQty1(qty1[i]);
				if (qty2[i] != null)
					model.setQty2(qty2[i]);
				if (qty3[i] != null)
					model.setQty3(qty3[i]);
				if (qty4[i] != null)
					model.setQty4(qty4[i]);
				if (qty5[i] != null)
					model.setQty5(qty5[i]);
				if (qty6[i] != null)
					model.setQty6(qty6[i]);
				if (qty7[i] != null)
					model.setQty7(qty7[i]);
				if (qty8[i] != null)
					model.setQty8(qty8[i]);
				if (qty9[i] != null)
					model.setQty9(qty9[i]);
				if (qty10[i] != null)
					model.setQty10(qty10[i]);
				if (stwgCgoFlg[i] != null)
					model.setStwgCgoFlg(stwgCgoFlg[i]);
				if (pcCgoFlg[i] != null)
					model.setPcCgoFlg(pcCgoFlg[i]);
				if (prctFlg[i] != null)
					model.setPrctFlg(prctFlg[i]);
				if (allFlg[i] != null)
					model.setAllFlg(allFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (hzdDesc[i] != null)
					model.setHzdDesc(hzdDesc[i]);
				if (acCntrFlg[i] != null)
					model.setAcCntrFlg(acCntrFlg[i]);
				if (bkgRefNoCtnt[i] != null)
					model.setBkgRefNoCtnt(bkgRefNoCtnt[i]);				

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCBFListOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return OpfCgoBkgFcastCntrVO[]
	 */
	public CBFListOptionVO[] getCBFListOptionVOs() {
		CBFListOptionVO[] vos = (CBFListOptionVO[]) models
				.toArray(new CBFListOptionVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(
								0, 30).concat("= ")
								+ arr[j] + "\n");
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
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = null;
		}
		return arr;
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.exptQtyFlg = this.exptQtyFlg.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.cbfSmrySeq = this.cbfSmrySeq.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.lfSdOvrDimLen = this.lfSdOvrDimLen.replaceAll(",", "").replaceAll(
				"-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq = this.polClptIndSeq.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.dimWdt = this.dimWdt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtGrpCd = this.cntrWgtGrpCd.replaceAll(",", "").replaceAll(
				"-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSeq = this.cntrSeq.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cntrSeq2 = this.cntrSeq2.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.fwrdOvrDimLen = this.fwrdOvrDimLen.replaceAll(",", "").replaceAll(
				"-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cgoSeq = this.cgoSeq.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.dimHgt = this.dimHgt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.podClptCd = this.podClptCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.stwgN2ndRmk = this.stwgN2ndRmk.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.hgtOvrDimLen = this.hgtOvrDimLen.replaceAll(",", "").replaceAll(
				"-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.pckGrpCd = this.pckGrpCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.lmtQtyFlg = this.lmtQtyFlg.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cntrGrsWgt = this.cntrGrsWgt.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.aproRefNo = this.aproRefNo.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.rtSdOvrDimLen = this.rtSdOvrDimLen.replaceAll(",", "").replaceAll(
				"-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgN1stRmk = this.stwgN1stRmk.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoSeq = this.spclCgoSeq.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.prnrBkgRefNo = this.prnrBkgRefNo.replaceAll(",", "").replaceAll(
				"-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cgoGrsWgt = this.cgoGrsWgt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cbfSpclCgoCateCd = this.cbfSpclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimLen = this.dimLen.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthFlg = this.spclCgoAuthFlg.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mlbCd = this.mlbCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cbfRmk = this.cbfRmk.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.bkwdOvrDimLen = this.bkwdOvrDimLen.replaceAll(",", "").replaceAll(
				"-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd = this.imdgSubsRskLblCd.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdoTemp = this.fdoTemp.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.bkgShprOwnrFlg = this.bkgShprOwnrFlg.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnrCntrRefNo = this.prnrCntrRefNo.replaceAll(",", "").replaceAll(
				"-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdoTemp = this.cdoTemp.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.imdgMrnPolutCd = this.imdgMrnPolutCd.replaceAll(",", "")
				.replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnPstStsCd = this.crnPstStsCd.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.cbfIndFlg = this.cbfIndFlg.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cbfBkgStsCd = this.cbfBkgStsCd.replaceAll(",", "").replaceAll("-",
				"").replaceAll("/", "").replaceAll(":", "");
		this.bkSt = this.bkSt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.rdSt = this.rdSt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cbfDpCd = this.cbfDpCd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.cbfCmdtNm = this.cbfCmdtNm.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ovrFwd = this.ovrFwd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ovrAft = this.ovrAft.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ovrLft = this.ovrLft.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ovrRgt = this.ovrRgt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.ovrHgt = this.ovrHgt.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.postExd = this.postExd.replaceAll(",", "").replaceAll("-", "")
				.replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.qty1 = this.qty1.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.qty2 = this.qty2.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.qty3 = this.qty3.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.qty4 = this.qty4.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.qty5 = this.qty5.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.qty6 = this.qty6.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.qty7 = this.qty7.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.qty8 = this.qty8.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.qty9 = this.qty9.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.qty10 = this.qty10.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.stwgCgoFlg = this.stwgCgoFlg.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.pcCgoFlg = this.pcCgoFlg.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.prctFlg = this.prctFlg.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.allFlg = this.allFlg.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.hzdDesc = this.hzdDesc.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.acCntrFlg = this.acCntrFlg.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNoCtnt = this.bkgRefNoCtnt.replaceAll(",", "").replaceAll("-", "")
		.replaceAll("/", "").replaceAll(":", "");
	}
}
