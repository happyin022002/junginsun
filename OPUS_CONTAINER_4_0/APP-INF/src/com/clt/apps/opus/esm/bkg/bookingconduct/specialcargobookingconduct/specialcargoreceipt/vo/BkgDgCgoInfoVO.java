/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgDgCgoInfoVO.java
*@FileTitle : BkgDgCgoInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2010.02.24 이병규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

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
 * @author 이병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgDgCgoInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgDgCgoInfoVO> models = new ArrayList<BkgDgCgoInfoVO>();
	
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String dcgoSeq = null;
	/* Column Info */
	private String awkCgoSeq = null;
	/* Column Info */
	private String outImdgPckQty1 = null;
	/* Column Info */
	private String inImdgPckDesc1 = null;
	/* Column Info */
	private String outImdgPckQty2 = null;
	/* Column Info */
	private String inImdgPckDesc2 = null;
	/* Column Info */
	private String radaSkdNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String imdgCompGrpCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String ltdQty = null;
	/* Column Info */
	private String intmdImdgPckDesc2 = null;
	/* Column Info */
	private String intmdImdgPckQty1 = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String hcdgFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String intmdImdgPckQty2 = null;
	/* Column Info */
	private String intmdImdgPckDesc1 = null;
	/* Column Info */
	private String hcdgIntmdBcRstrDesc = null;
	/* Column Info */
	private String outImdgPckDesc2 = null;
	/* Column Info */
	private String outImdgPckDesc1 = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String radaAmt = null;
	/* Column Info */
	private String spclRqstDesc = null;
	/* Column Info */
	private String netExploWgt = null;
	/* Column Info */
	private String emerRspnGidNo = null;
	/* Column Info */
	private String cneeDtlDesc = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String spclRqstFlg = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String rcSeq = null;
	/* Column Info */
	private String emerCntcPhnNoCtnt = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String flshPntCdoTemp = null;
	/* Column Info */
	private String emsNo = null;
	/* Column Info */
	private String maxInPckQty = null;
	/* Column Info */
	private String spclCgoAproCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String dgCntrSeq = null;
	/* Column Info */
	private String mergeDgCntrSeq = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String spclStwgRqstDesc = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String inImdgPckQty1 = null;
	/* Column Info */
	private String inImdgPckQty2 = null;
	/* Column Info */
	private String psaNo = null;
	/* Column Info */
	private String emerCntcPsonNm = null;
	/* Column Info */
	private String dcgoStsCd = null;
	/* Column Info */
	private String imdgSpclProviNo = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String hcdgQty = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String mrnPolutFlg = null;
	/* Column Info */
	private String inImdgPckCd1 = null;
	/* Column Info */
	private String inImdgPckCd2 = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String netWgt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cntrCgoSeq = null;
	/* Column Info */
	private String eqTpsz = null;
	/* Column Info */
	private String aplyNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cgoLclFlg = null;
	/* Column Info */
	private String bbCgoSeq = null;
	/* Column Info */
	private String hzdDesc = null;
	/* Column Info */
	private String emerRspnGidChrNo = null;
	/* Column Info */
	private String emerTempCtnt = null;
	/* Column Info */
	private String cntrVolQty = null;
	/* Column Info */
	private String outImdgPckCd2 = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String outImdgPckCd1 = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String radaTrspNo = null;
	/* Column Info */
	private String maxInPckTpCd = null;
	/* Column Info */
	private String radaUtCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imdgExptQtyCd = null;
	/* Column Info */
	private String certiNo = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String hcdgPckRstrDesc = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String imdgExptQtyFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String clodFlg = null;
	/* Column Info */
	private String intmdImdgPckCd1 = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String intmdImdgPckCd2 = null;
	/* Column Info */
	private String ctrlTempCtnt = null;
	/* Column Info */
	private String imdgMrnPolutCd = null;
	/* Column Info */
	private String imdgSubsRskLblCd2 = null;
	/* Column Info */
	private String hcdgDpndQtyFlg = null;
	/* Column Info */
	private String hcdgTnkRstrDesc = null;
	/* Column Info */
	private String imdgSubsRskLblCd1 = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String imdgSubsRskLblCd4 = null;
	/* Column Info */
	private String imdgSubsRskLblCd3 = null;
	/* Column Info */
	private String imdgLmtQtyFlg = null;
	/* Column Info */
	private String dgCntrSeqOriginal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgDgCgoInfoVO() {}

	public BkgDgCgoInfoVO(String ibflag, String pagerows, String imdgCompGrpCd, String cntrVolQty, String imdgSubsRskLblCd4, String bkgNo, String dcgoSeq, String dgCntrSeq, String mergeDgCntrSeq, String cntrCgoSeq, String cntrNo, String cntrTpszCd, String imdgUnNo, String imdgUnNoSeq, String imdgClssCd, String imdgSubsRskLblCd1, String imdgSubsRskLblCd2, String imdgSubsRskLblCd3, String imdgLmtQtyFlg, String imdgExptQtyFlg, String netWgt, String grsWgt, String wgtUtCd, String flshPntCdoTemp, String prpShpNm, String hzdDesc, String measQty, String measUtCd, String clodFlg, String spclStwgRqstDesc, String dcgoStsCd, String cgoLclFlg, String emerCntcPhnNoCtnt, String emerCntcPsonNm, String emerTempCtnt, String ctrlTempCtnt, String emsNo, String emerRspnGidNo, String emerRspnGidChrNo, String imdgPckGrpCd, String mrnPolutFlg, String psaNo, String certiNo, String inImdgPckQty1, String inImdgPckCd1, String inImdgPckQty2, String inImdgPckCd2, String intmdImdgPckQty1, String intmdImdgPckCd1, String intmdImdgPckQty2, String intmdImdgPckCd2, String outImdgPckQty1, String outImdgPckCd1, String outImdgPckQty2, String outImdgPckCd2, String maxInPckQty, String maxInPckTpCd, String cneeDtlDesc, String netExploWgt, String radaSkdNo, String radaAmt, String radaUtCd, String radaTrspNo, String rcFlg, String awkCgoFlg, String bbCgoFlg, String rcSeq, String awkCgoSeq, String bbCgoSeq, String hcdgFlg, String hcdgDpndQtyFlg, String rqstDt, String rqstUsrId, String aplyNo, String spclCgoAproCd, String diffRmk, String creUsrId, String creDt, String updUsrId, String updDt, String spclRqstFlg, String spclRqstDesc, String porCd, String delCd, String rcvTermCd, String deTermCd, String eqTpsz, String inImdgPckDesc1, String inImdgPckDesc2, String intmdImdgPckDesc1, String intmdImdgPckDesc2, String outImdgPckDesc1, String outImdgPckDesc2, String imdgSpclProviNo, String crrCd, String hcdgPckRstrDesc, String hcdgIntmdBcRstrDesc, String hcdgTnkRstrDesc, String imdgMrnPolutCd, String imdgExptQtyCd, String ltdQty, String hcdgQty, String dgCntrSeqOriginal) {
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.dcgoSeq = dcgoSeq;
		this.awkCgoSeq = awkCgoSeq;
		this.outImdgPckQty1 = outImdgPckQty1;
		this.inImdgPckDesc1 = inImdgPckDesc1;
		this.outImdgPckQty2 = outImdgPckQty2;
		this.inImdgPckDesc2 = inImdgPckDesc2;
		this.radaSkdNo = radaSkdNo;
		this.pagerows = pagerows;
		this.imdgCompGrpCd = imdgCompGrpCd;
		this.cntrTpszCd = cntrTpszCd;
		this.ltdQty = ltdQty;
		this.intmdImdgPckDesc2 = intmdImdgPckDesc2;
		this.intmdImdgPckQty1 = intmdImdgPckQty1;
		this.imdgUnNo = imdgUnNo;
		this.hcdgFlg = hcdgFlg;
		this.updUsrId = updUsrId;
		this.intmdImdgPckQty2 = intmdImdgPckQty2;
		this.intmdImdgPckDesc1 = intmdImdgPckDesc1;
		this.hcdgIntmdBcRstrDesc = hcdgIntmdBcRstrDesc;
		this.outImdgPckDesc2 = outImdgPckDesc2;
		this.outImdgPckDesc1 = outImdgPckDesc1;
		this.bkgNo = bkgNo;
		this.radaAmt = radaAmt;
		this.spclRqstDesc = spclRqstDesc;
		this.netExploWgt = netExploWgt;
		this.emerRspnGidNo = emerRspnGidNo;
		this.cneeDtlDesc = cneeDtlDesc;
		this.rcFlg = rcFlg;
		this.spclRqstFlg = spclRqstFlg;
		this.imdgClssCd = imdgClssCd;
		this.rcSeq = rcSeq;
		this.emerCntcPhnNoCtnt = emerCntcPhnNoCtnt;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.flshPntCdoTemp = flshPntCdoTemp;
		this.emsNo = emsNo;
		this.maxInPckQty = maxInPckQty;
		this.spclCgoAproCd = spclCgoAproCd;
		this.measUtCd = measUtCd;
		this.dgCntrSeq = dgCntrSeq;
		this.mergeDgCntrSeq = mergeDgCntrSeq;
		this.rqstDt = rqstDt;
		this.spclStwgRqstDesc = spclStwgRqstDesc;
		this.diffRmk = diffRmk;
		this.cntrNo = cntrNo;
		this.inImdgPckQty1 = inImdgPckQty1;
		this.inImdgPckQty2 = inImdgPckQty2;
		this.psaNo = psaNo;
		this.emerCntcPsonNm = emerCntcPsonNm;
		this.dcgoStsCd = dcgoStsCd;
		this.imdgSpclProviNo = imdgSpclProviNo;
		this.crrCd = crrCd;
		this.hcdgQty = hcdgQty;
		this.wgtUtCd = wgtUtCd;
		this.mrnPolutFlg = mrnPolutFlg;
		this.inImdgPckCd1 = inImdgPckCd1;
		this.inImdgPckCd2 = inImdgPckCd2;
		this.awkCgoFlg = awkCgoFlg;
		this.netWgt = netWgt;
		this.delCd = delCd;
		this.cntrCgoSeq = cntrCgoSeq;
		this.eqTpsz = eqTpsz;
		this.aplyNo = aplyNo;
		this.creUsrId = creUsrId;
		this.cgoLclFlg = cgoLclFlg;
		this.bbCgoSeq = bbCgoSeq;
		this.hzdDesc = hzdDesc;
		this.emerRspnGidChrNo = emerRspnGidChrNo;
		this.emerTempCtnt = emerTempCtnt;
		this.cntrVolQty = cntrVolQty;
		this.outImdgPckCd2 = outImdgPckCd2;
		this.grsWgt = grsWgt;
		this.outImdgPckCd1 = outImdgPckCd1;
		this.porCd = porCd;
		this.rqstUsrId = rqstUsrId;
		this.creDt = creDt;
		this.radaTrspNo = radaTrspNo;
		this.maxInPckTpCd = maxInPckTpCd;
		this.radaUtCd = radaUtCd;
		this.ibflag = ibflag;
		this.imdgExptQtyCd = imdgExptQtyCd;
		this.certiNo = certiNo;
		this.bbCgoFlg = bbCgoFlg;
		this.measQty = measQty;
		this.hcdgPckRstrDesc = hcdgPckRstrDesc;
		this.rcvTermCd = rcvTermCd;
		this.imdgExptQtyFlg = imdgExptQtyFlg;
		this.updDt = updDt;
		this.clodFlg = clodFlg;
		this.intmdImdgPckCd1 = intmdImdgPckCd1;
		this.deTermCd = deTermCd;
		this.intmdImdgPckCd2 = intmdImdgPckCd2;
		this.ctrlTempCtnt = ctrlTempCtnt;
		this.imdgMrnPolutCd = imdgMrnPolutCd;
		this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
		this.hcdgDpndQtyFlg = hcdgDpndQtyFlg;
		this.hcdgTnkRstrDesc = hcdgTnkRstrDesc;
		this.imdgSubsRskLblCd1 = imdgSubsRskLblCd1;
		this.prpShpNm = prpShpNm;
		this.imdgSubsRskLblCd4 = imdgSubsRskLblCd4;
		this.imdgSubsRskLblCd3 = imdgSubsRskLblCd3;
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
		this.dgCntrSeqOriginal = dgCntrSeqOriginal;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("dcgo_seq", getDcgoSeq());
		this.hashColumns.put("awk_cgo_seq", getAwkCgoSeq());
		this.hashColumns.put("out_imdg_pck_qty1", getOutImdgPckQty1());
		this.hashColumns.put("in_imdg_pck_desc1", getInImdgPckDesc1());
		this.hashColumns.put("out_imdg_pck_qty2", getOutImdgPckQty2());
		this.hashColumns.put("in_imdg_pck_desc2", getInImdgPckDesc2());
		this.hashColumns.put("rada_skd_no", getRadaSkdNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ltd_qty", getLtdQty());
		this.hashColumns.put("intmd_imdg_pck_desc2", getIntmdImdgPckDesc2());
		this.hashColumns.put("intmd_imdg_pck_qty1", getIntmdImdgPckQty1());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("hcdg_flg", getHcdgFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("intmd_imdg_pck_qty2", getIntmdImdgPckQty2());
		this.hashColumns.put("intmd_imdg_pck_desc1", getIntmdImdgPckDesc1());
		this.hashColumns.put("hcdg_intmd_bc_rstr_desc", getHcdgIntmdBcRstrDesc());
		this.hashColumns.put("out_imdg_pck_desc2", getOutImdgPckDesc2());
		this.hashColumns.put("out_imdg_pck_desc1", getOutImdgPckDesc1());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rada_amt", getRadaAmt());
		this.hashColumns.put("spcl_rqst_desc", getSpclRqstDesc());
		this.hashColumns.put("net_explo_wgt", getNetExploWgt());
		this.hashColumns.put("emer_rspn_gid_no", getEmerRspnGidNo());
		this.hashColumns.put("cnee_dtl_desc", getCneeDtlDesc());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("spcl_rqst_flg", getSpclRqstFlg());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("rc_seq", getRcSeq());
		this.hashColumns.put("emer_cntc_phn_no_ctnt", getEmerCntcPhnNoCtnt());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
		this.hashColumns.put("ems_no", getEmsNo());
		this.hashColumns.put("max_in_pck_qty", getMaxInPckQty());
		this.hashColumns.put("spcl_cgo_apro_cd", getSpclCgoAproCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("dg_cntr_seq", getDgCntrSeq());
		this.hashColumns.put("merge_dg_cntr_seq", getMergeDgCntrSeq());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("spcl_stwg_rqst_desc", getSpclStwgRqstDesc());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("in_imdg_pck_qty1", getInImdgPckQty1());
		this.hashColumns.put("in_imdg_pck_qty2", getInImdgPckQty2());
		this.hashColumns.put("psa_no", getPsaNo());
		this.hashColumns.put("emer_cntc_pson_nm", getEmerCntcPsonNm());
		this.hashColumns.put("dcgo_sts_cd", getDcgoStsCd());
		this.hashColumns.put("imdg_spcl_provi_no", getImdgSpclProviNo());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("hcdg_qty", getHcdgQty());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
		this.hashColumns.put("in_imdg_pck_cd1", getInImdgPckCd1());
		this.hashColumns.put("in_imdg_pck_cd2", getInImdgPckCd2());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("eq_tpsz", getEqTpsz());
		this.hashColumns.put("aply_no", getAplyNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cgo_lcl_flg", getCgoLclFlg());
		this.hashColumns.put("bb_cgo_seq", getBbCgoSeq());
		this.hashColumns.put("hzd_desc", getHzdDesc());
		this.hashColumns.put("emer_rspn_gid_chr_no", getEmerRspnGidChrNo());
		this.hashColumns.put("emer_temp_ctnt", getEmerTempCtnt());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		this.hashColumns.put("out_imdg_pck_cd2", getOutImdgPckCd2());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("out_imdg_pck_cd1", getOutImdgPckCd1());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rada_trsp_no", getRadaTrspNo());
		this.hashColumns.put("max_in_pck_tp_cd", getMaxInPckTpCd());
		this.hashColumns.put("rada_ut_cd", getRadaUtCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imdg_expt_qty_cd", getImdgExptQtyCd());
		this.hashColumns.put("certi_no", getCertiNo());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("hcdg_pck_rstr_desc", getHcdgPckRstrDesc());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("imdg_expt_qty_flg", getImdgExptQtyFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("clod_flg", getClodFlg());
		this.hashColumns.put("intmd_imdg_pck_cd1", getIntmdImdgPckCd1());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("intmd_imdg_pck_cd2", getIntmdImdgPckCd2());
		this.hashColumns.put("ctrl_temp_ctnt", getCtrlTempCtnt());
		this.hashColumns.put("imdg_mrn_polut_cd", getImdgMrnPolutCd());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd2", getImdgSubsRskLblCd2());
		this.hashColumns.put("hcdg_dpnd_qty_flg", getHcdgDpndQtyFlg());
		this.hashColumns.put("hcdg_tnk_rstr_desc", getHcdgTnkRstrDesc());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd1", getImdgSubsRskLblCd1());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd4", getImdgSubsRskLblCd4());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd3", getImdgSubsRskLblCd3());
		this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
		this.hashColumns.put("dg_cntr_seq_original", getDgCntrSeqOriginal());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("awk_cgo_seq", "awkCgoSeq");
		this.hashFields.put("out_imdg_pck_qty1", "outImdgPckQty1");
		this.hashFields.put("in_imdg_pck_desc1", "inImdgPckDesc1");
		this.hashFields.put("out_imdg_pck_qty2", "outImdgPckQty2");
		this.hashFields.put("in_imdg_pck_desc2", "inImdgPckDesc2");
		this.hashFields.put("rada_skd_no", "radaSkdNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ltd_qty", "ltdQty");
		this.hashFields.put("intmd_imdg_pck_desc2", "intmdImdgPckDesc2");
		this.hashFields.put("intmd_imdg_pck_qty1", "intmdImdgPckQty1");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("hcdg_flg", "hcdgFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("intmd_imdg_pck_qty2", "intmdImdgPckQty2");
		this.hashFields.put("intmd_imdg_pck_desc1", "intmdImdgPckDesc1");
		this.hashFields.put("hcdg_intmd_bc_rstr_desc", "hcdgIntmdBcRstrDesc");
		this.hashFields.put("out_imdg_pck_desc2", "outImdgPckDesc2");
		this.hashFields.put("out_imdg_pck_desc1", "outImdgPckDesc1");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rada_amt", "radaAmt");
		this.hashFields.put("spcl_rqst_desc", "spclRqstDesc");
		this.hashFields.put("net_explo_wgt", "netExploWgt");
		this.hashFields.put("emer_rspn_gid_no", "emerRspnGidNo");
		this.hashFields.put("cnee_dtl_desc", "cneeDtlDesc");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("spcl_rqst_flg", "spclRqstFlg");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("rc_seq", "rcSeq");
		this.hashFields.put("emer_cntc_phn_no_ctnt", "emerCntcPhnNoCtnt");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
		this.hashFields.put("ems_no", "emsNo");
		this.hashFields.put("max_in_pck_qty", "maxInPckQty");
		this.hashFields.put("spcl_cgo_apro_cd", "spclCgoAproCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("dg_cntr_seq", "dgCntrSeq");
		this.hashFields.put("merge_dg_cntr_seq", "mergeDgCntrSeq");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("spcl_stwg_rqst_desc", "spclStwgRqstDesc");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("in_imdg_pck_qty1", "inImdgPckQty1");
		this.hashFields.put("in_imdg_pck_qty2", "inImdgPckQty2");
		this.hashFields.put("psa_no", "psaNo");
		this.hashFields.put("emer_cntc_pson_nm", "emerCntcPsonNm");
		this.hashFields.put("dcgo_sts_cd", "dcgoStsCd");
		this.hashFields.put("imdg_spcl_provi_no", "imdgSpclProviNo");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("hcdg_qty", "hcdgQty");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
		this.hashFields.put("in_imdg_pck_cd1", "inImdgPckCd1");
		this.hashFields.put("in_imdg_pck_cd2", "inImdgPckCd2");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("eq_tpsz", "eqTpsz");
		this.hashFields.put("aply_no", "aplyNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cgo_lcl_flg", "cgoLclFlg");
		this.hashFields.put("bb_cgo_seq", "bbCgoSeq");
		this.hashFields.put("hzd_desc", "hzdDesc");
		this.hashFields.put("emer_rspn_gid_chr_no", "emerRspnGidChrNo");
		this.hashFields.put("emer_temp_ctnt", "emerTempCtnt");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		this.hashFields.put("out_imdg_pck_cd2", "outImdgPckCd2");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("out_imdg_pck_cd1", "outImdgPckCd1");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rada_trsp_no", "radaTrspNo");
		this.hashFields.put("max_in_pck_tp_cd", "maxInPckTpCd");
		this.hashFields.put("rada_ut_cd", "radaUtCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imdg_expt_qty_cd", "imdgExptQtyCd");
		this.hashFields.put("certi_no", "certiNo");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("hcdg_pck_rstr_desc", "hcdgPckRstrDesc");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("imdg_expt_qty_flg", "imdgExptQtyFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("clod_flg", "clodFlg");
		this.hashFields.put("intmd_imdg_pck_cd1", "intmdImdgPckCd1");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("intmd_imdg_pck_cd2", "intmdImdgPckCd2");
		this.hashFields.put("ctrl_temp_ctnt", "ctrlTempCtnt");
		this.hashFields.put("imdg_mrn_polut_cd", "imdgMrnPolutCd");
		this.hashFields.put("imdg_subs_rsk_lbl_cd2", "imdgSubsRskLblCd2");
		this.hashFields.put("hcdg_dpnd_qty_flg", "hcdgDpndQtyFlg");
		this.hashFields.put("hcdg_tnk_rstr_desc", "hcdgTnkRstrDesc");
		this.hashFields.put("imdg_subs_rsk_lbl_cd1", "imdgSubsRskLblCd1");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("imdg_subs_rsk_lbl_cd4", "imdgSubsRskLblCd4");
		this.hashFields.put("imdg_subs_rsk_lbl_cd3", "imdgSubsRskLblCd3");
		this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
		this.hashFields.put("dg_cntr_seq_original", "dgCntrSeqOriginal");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @return dcgoSeq
	 */
	public String getDcgoSeq() {
		return this.dcgoSeq;
	}
	
	/**
	 * Column Info
	 * @return awkCgoSeq
	 */
	public String getAwkCgoSeq() {
		return this.awkCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return outImdgPckQty1
	 */
	public String getOutImdgPckQty1() {
		return this.outImdgPckQty1;
	}
	
	/**
	 * Column Info
	 * @return inImdgPckDesc1
	 */
	public String getInImdgPckDesc1() {
		return this.inImdgPckDesc1;
	}
	
	/**
	 * Column Info
	 * @return outImdgPckQty2
	 */
	public String getOutImdgPckQty2() {
		return this.outImdgPckQty2;
	}
	
	/**
	 * Column Info
	 * @return inImdgPckDesc2
	 */
	public String getInImdgPckDesc2() {
		return this.inImdgPckDesc2;
	}
	
	/**
	 * Column Info
	 * @return radaSkdNo
	 */
	public String getRadaSkdNo() {
		return this.radaSkdNo;
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
	 * @return imdgCompGrpCd
	 */
	public String getImdgCompGrpCd() {
		return this.imdgCompGrpCd;
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
	 * @return ltdQty
	 */
	public String getLtdQty() {
		return this.ltdQty;
	}
	
	/**
	 * Column Info
	 * @return intmdImdgPckDesc2
	 */
	public String getIntmdImdgPckDesc2() {
		return this.intmdImdgPckDesc2;
	}
	
	/**
	 * Column Info
	 * @return intmdImdgPckQty1
	 */
	public String getIntmdImdgPckQty1() {
		return this.intmdImdgPckQty1;
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
	 * @return hcdgFlg
	 */
	public String getHcdgFlg() {
		return this.hcdgFlg;
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
	 * @return intmdImdgPckQty2
	 */
	public String getIntmdImdgPckQty2() {
		return this.intmdImdgPckQty2;
	}
	
	/**
	 * Column Info
	 * @return intmdImdgPckDesc1
	 */
	public String getIntmdImdgPckDesc1() {
		return this.intmdImdgPckDesc1;
	}
	
	/**
	 * Column Info
	 * @return hcdgIntmdBcRstrDesc
	 */
	public String getHcdgIntmdBcRstrDesc() {
		return this.hcdgIntmdBcRstrDesc;
	}
	
	/**
	 * Column Info
	 * @return outImdgPckDesc2
	 */
	public String getOutImdgPckDesc2() {
		return this.outImdgPckDesc2;
	}
	
	/**
	 * Column Info
	 * @return outImdgPckDesc1
	 */
	public String getOutImdgPckDesc1() {
		return this.outImdgPckDesc1;
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
	 * @return radaAmt
	 */
	public String getRadaAmt() {
		return this.radaAmt;
	}
	
	/**
	 * Column Info
	 * @return spclRqstDesc
	 */
	public String getSpclRqstDesc() {
		return this.spclRqstDesc;
	}
	
	/**
	 * Column Info
	 * @return netExploWgt
	 */
	public String getNetExploWgt() {
		return this.netExploWgt;
	}
	
	/**
	 * Column Info
	 * @return emerRspnGidNo
	 */
	public String getEmerRspnGidNo() {
		return this.emerRspnGidNo;
	}
	
	/**
	 * Column Info
	 * @return cneeDtlDesc
	 */
	public String getCneeDtlDesc() {
		return this.cneeDtlDesc;
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
	 * @return spclRqstFlg
	 */
	public String getSpclRqstFlg() {
		return this.spclRqstFlg;
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
	 * @return rcSeq
	 */
	public String getRcSeq() {
		return this.rcSeq;
	}
	
	/**
	 * Column Info
	 * @return emerCntcPhnNoCtnt
	 */
	public String getEmerCntcPhnNoCtnt() {
		return this.emerCntcPhnNoCtnt;
	}
	
	/**
	 * Column Info
	 * @return imdgPckGrpCd
	 */
	public String getImdgPckGrpCd() {
		return this.imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @return flshPntCdoTemp
	 */
	public String getFlshPntCdoTemp() {
		return this.flshPntCdoTemp;
	}
	
	/**
	 * Column Info
	 * @return emsNo
	 */
	public String getEmsNo() {
		return this.emsNo;
	}
	
	/**
	 * Column Info
	 * @return maxInPckQty
	 */
	public String getMaxInPckQty() {
		return this.maxInPckQty;
	}
	
	/**
	 * Column Info
	 * @return spclCgoAproCd
	 */
	public String getSpclCgoAproCd() {
		return this.spclCgoAproCd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return dgCntrSeq
	 */
	public String getDgCntrSeq() {
		return this.dgCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return mergeDgCntrSeq
	 */
	public String getMergeDgCntrSeq() {
		return this.mergeDgCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return spclStwgRqstDesc
	 */
	public String getSpclStwgRqstDesc() {
		return this.spclStwgRqstDesc;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
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
	 * @return inImdgPckQty1
	 */
	public String getInImdgPckQty1() {
		return this.inImdgPckQty1;
	}
	
	/**
	 * Column Info
	 * @return inImdgPckQty2
	 */
	public String getInImdgPckQty2() {
		return this.inImdgPckQty2;
	}
	
	/**
	 * Column Info
	 * @return psaNo
	 */
	public String getPsaNo() {
		return this.psaNo;
	}
	
	/**
	 * Column Info
	 * @return emerCntcPsonNm
	 */
	public String getEmerCntcPsonNm() {
		return this.emerCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return dcgoStsCd
	 */
	public String getDcgoStsCd() {
		return this.dcgoStsCd;
	}
	
	/**
	 * Column Info
	 * @return imdgSpclProviNo
	 */
	public String getImdgSpclProviNo() {
		return this.imdgSpclProviNo;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return hcdgQty
	 */
	public String getHcdgQty() {
		return this.hcdgQty;
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
	 * @return mrnPolutFlg
	 */
	public String getMrnPolutFlg() {
		return this.mrnPolutFlg;
	}
	
	/**
	 * Column Info
	 * @return inImdgPckCd1
	 */
	public String getInImdgPckCd1() {
		return this.inImdgPckCd1;
	}
	
	/**
	 * Column Info
	 * @return inImdgPckCd2
	 */
	public String getInImdgPckCd2() {
		return this.inImdgPckCd2;
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
	 * @return netWgt
	 */
	public String getNetWgt() {
		return this.netWgt;
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
	 * @return cntrCgoSeq
	 */
	public String getCntrCgoSeq() {
		return this.cntrCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return eqTpsz
	 */
	public String getEqTpsz() {
		return this.eqTpsz;
	}
	
	/**
	 * Column Info
	 * @return aplyNo
	 */
	public String getAplyNo() {
		return this.aplyNo;
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
	 * @return cgoLclFlg
	 */
	public String getCgoLclFlg() {
		return this.cgoLclFlg;
	}
	
	/**
	 * Column Info
	 * @return bbCgoSeq
	 */
	public String getBbCgoSeq() {
		return this.bbCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return hzdDesc
	 */
	public String getHzdDesc() {
		return this.hzdDesc;
	}
	
	/**
	 * Column Info
	 * @return emerRspnGidChrNo
	 */
	public String getEmerRspnGidChrNo() {
		return this.emerRspnGidChrNo;
	}
	
	/**
	 * Column Info
	 * @return emerTempCtnt
	 */
	public String getEmerTempCtnt() {
		return this.emerTempCtnt;
	}
	
	/**
	 * Column Info
	 * @return cntrVolQty
	 */
	public String getCntrVolQty() {
		return this.cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return outImdgPckCd2
	 */
	public String getOutImdgPckCd2() {
		return this.outImdgPckCd2;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	
	/**
	 * Column Info
	 * @return outImdgPckCd1
	 */
	public String getOutImdgPckCd1() {
		return this.outImdgPckCd1;
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
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
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
	 * @return radaTrspNo
	 */
	public String getRadaTrspNo() {
		return this.radaTrspNo;
	}
	
	/**
	 * Column Info
	 * @return maxInPckTpCd
	 */
	public String getMaxInPckTpCd() {
		return this.maxInPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return radaUtCd
	 */
	public String getRadaUtCd() {
		return this.radaUtCd;
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
	 * @return imdgExptQtyCd
	 */
	public String getImdgExptQtyCd() {
		return this.imdgExptQtyCd;
	}
	
	/**
	 * Column Info
	 * @return certiNo
	 */
	public String getCertiNo() {
		return this.certiNo;
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
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return hcdgPckRstrDesc
	 */
	public String getHcdgPckRstrDesc() {
		return this.hcdgPckRstrDesc;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return imdgExptQtyFlg
	 */
	public String getImdgExptQtyFlg() {
		return this.imdgExptQtyFlg;
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
	 * @return clodFlg
	 */
	public String getClodFlg() {
		return this.clodFlg;
	}
	
	/**
	 * Column Info
	 * @return intmdImdgPckCd1
	 */
	public String getIntmdImdgPckCd1() {
		return this.intmdImdgPckCd1;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return intmdImdgPckCd2
	 */
	public String getIntmdImdgPckCd2() {
		return this.intmdImdgPckCd2;
	}
	
	/**
	 * Column Info
	 * @return ctrlTempCtnt
	 */
	public String getCtrlTempCtnt() {
		return this.ctrlTempCtnt;
	}
	
	/**
	 * Column Info
	 * @return imdgMrnPolutCd
	 */
	public String getImdgMrnPolutCd() {
		return this.imdgMrnPolutCd;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd2
	 */
	public String getImdgSubsRskLblCd2() {
		return this.imdgSubsRskLblCd2;
	}
	
	/**
	 * Column Info
	 * @return hcdgDpndQtyFlg
	 */
	public String getHcdgDpndQtyFlg() {
		return this.hcdgDpndQtyFlg;
	}
	
	/**
	 * Column Info
	 * @return hcdgTnkRstrDesc
	 */
	public String getHcdgTnkRstrDesc() {
		return this.hcdgTnkRstrDesc;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd1
	 */
	public String getImdgSubsRskLblCd1() {
		return this.imdgSubsRskLblCd1;
	}
	
	/**
	 * Column Info
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd4
	 */
	public String getImdgSubsRskLblCd4() {
		return this.imdgSubsRskLblCd4;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd3
	 */
	public String getImdgSubsRskLblCd3() {
		return this.imdgSubsRskLblCd3;
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
	 * @return dgCntrSeqOriginal
	 */
	public String getDgCntrSeqOriginal() {
		return this.dgCntrSeqOriginal;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @param dcgoSeq
	 */
	public void setDcgoSeq(String dcgoSeq) {
		this.dcgoSeq = dcgoSeq;
	}
	
	/**
	 * Column Info
	 * @param awkCgoSeq
	 */
	public void setAwkCgoSeq(String awkCgoSeq) {
		this.awkCgoSeq = awkCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param outImdgPckQty1
	 */
	public void setOutImdgPckQty1(String outImdgPckQty1) {
		this.outImdgPckQty1 = outImdgPckQty1;
	}
	
	/**
	 * Column Info
	 * @param inImdgPckDesc1
	 */
	public void setInImdgPckDesc1(String inImdgPckDesc1) {
		this.inImdgPckDesc1 = inImdgPckDesc1;
	}
	
	/**
	 * Column Info
	 * @param outImdgPckQty2
	 */
	public void setOutImdgPckQty2(String outImdgPckQty2) {
		this.outImdgPckQty2 = outImdgPckQty2;
	}
	
	/**
	 * Column Info
	 * @param inImdgPckDesc2
	 */
	public void setInImdgPckDesc2(String inImdgPckDesc2) {
		this.inImdgPckDesc2 = inImdgPckDesc2;
	}
	
	/**
	 * Column Info
	 * @param radaSkdNo
	 */
	public void setRadaSkdNo(String radaSkdNo) {
		this.radaSkdNo = radaSkdNo;
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
	 * @param imdgCompGrpCd
	 */
	public void setImdgCompGrpCd(String imdgCompGrpCd) {
		this.imdgCompGrpCd = imdgCompGrpCd;
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
	 * @param ltdQty
	 */
	public void setLtdQty(String ltdQty) {
		this.ltdQty = ltdQty;
	}
	
	/**
	 * Column Info
	 * @param intmdImdgPckDesc2
	 */
	public void setIntmdImdgPckDesc2(String intmdImdgPckDesc2) {
		this.intmdImdgPckDesc2 = intmdImdgPckDesc2;
	}
	
	/**
	 * Column Info
	 * @param intmdImdgPckQty1
	 */
	public void setIntmdImdgPckQty1(String intmdImdgPckQty1) {
		this.intmdImdgPckQty1 = intmdImdgPckQty1;
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
	 * @param hcdgFlg
	 */
	public void setHcdgFlg(String hcdgFlg) {
		this.hcdgFlg = hcdgFlg;
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
	 * @param intmdImdgPckQty2
	 */
	public void setIntmdImdgPckQty2(String intmdImdgPckQty2) {
		this.intmdImdgPckQty2 = intmdImdgPckQty2;
	}
	
	/**
	 * Column Info
	 * @param intmdImdgPckDesc1
	 */
	public void setIntmdImdgPckDesc1(String intmdImdgPckDesc1) {
		this.intmdImdgPckDesc1 = intmdImdgPckDesc1;
	}
	
	/**
	 * Column Info
	 * @param hcdgIntmdBcRstrDesc
	 */
	public void setHcdgIntmdBcRstrDesc(String hcdgIntmdBcRstrDesc) {
		this.hcdgIntmdBcRstrDesc = hcdgIntmdBcRstrDesc;
	}
	
	/**
	 * Column Info
	 * @param outImdgPckDesc2
	 */
	public void setOutImdgPckDesc2(String outImdgPckDesc2) {
		this.outImdgPckDesc2 = outImdgPckDesc2;
	}
	
	/**
	 * Column Info
	 * @param outImdgPckDesc1
	 */
	public void setOutImdgPckDesc1(String outImdgPckDesc1) {
		this.outImdgPckDesc1 = outImdgPckDesc1;
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
	 * @param radaAmt
	 */
	public void setRadaAmt(String radaAmt) {
		this.radaAmt = radaAmt;
	}
	
	/**
	 * Column Info
	 * @param spclRqstDesc
	 */
	public void setSpclRqstDesc(String spclRqstDesc) {
		this.spclRqstDesc = spclRqstDesc;
	}
	
	/**
	 * Column Info
	 * @param netExploWgt
	 */
	public void setNetExploWgt(String netExploWgt) {
		this.netExploWgt = netExploWgt;
	}
	
	/**
	 * Column Info
	 * @param emerRspnGidNo
	 */
	public void setEmerRspnGidNo(String emerRspnGidNo) {
		this.emerRspnGidNo = emerRspnGidNo;
	}
	
	/**
	 * Column Info
	 * @param cneeDtlDesc
	 */
	public void setCneeDtlDesc(String cneeDtlDesc) {
		this.cneeDtlDesc = cneeDtlDesc;
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
	 * @param spclRqstFlg
	 */
	public void setSpclRqstFlg(String spclRqstFlg) {
		this.spclRqstFlg = spclRqstFlg;
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
	 * @param rcSeq
	 */
	public void setRcSeq(String rcSeq) {
		this.rcSeq = rcSeq;
	}
	
	/**
	 * Column Info
	 * @param emerCntcPhnNoCtnt
	 */
	public void setEmerCntcPhnNoCtnt(String emerCntcPhnNoCtnt) {
		this.emerCntcPhnNoCtnt = emerCntcPhnNoCtnt;
	}
	
	/**
	 * Column Info
	 * @param imdgPckGrpCd
	 */
	public void setImdgPckGrpCd(String imdgPckGrpCd) {
		this.imdgPckGrpCd = imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @param flshPntCdoTemp
	 */
	public void setFlshPntCdoTemp(String flshPntCdoTemp) {
		this.flshPntCdoTemp = flshPntCdoTemp;
	}
	
	/**
	 * Column Info
	 * @param emsNo
	 */
	public void setEmsNo(String emsNo) {
		this.emsNo = emsNo;
	}
	
	/**
	 * Column Info
	 * @param maxInPckQty
	 */
	public void setMaxInPckQty(String maxInPckQty) {
		this.maxInPckQty = maxInPckQty;
	}
	
	/**
	 * Column Info
	 * @param spclCgoAproCd
	 */
	public void setSpclCgoAproCd(String spclCgoAproCd) {
		this.spclCgoAproCd = spclCgoAproCd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param dgCntrSeq
	 */
	public void setDgCntrSeq(String dgCntrSeq) {
		this.dgCntrSeq = dgCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param mergeDgCntrSeq
	 */
	public void setMergeDgCntrSeq(String mergeDgCntrSeq) {
		this.mergeDgCntrSeq = mergeDgCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param spclStwgRqstDesc
	 */
	public void setSpclStwgRqstDesc(String spclStwgRqstDesc) {
		this.spclStwgRqstDesc = spclStwgRqstDesc;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
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
	 * @param inImdgPckQty1
	 */
	public void setInImdgPckQty1(String inImdgPckQty1) {
		this.inImdgPckQty1 = inImdgPckQty1;
	}
	
	/**
	 * Column Info
	 * @param inImdgPckQty2
	 */
	public void setInImdgPckQty2(String inImdgPckQty2) {
		this.inImdgPckQty2 = inImdgPckQty2;
	}
	
	/**
	 * Column Info
	 * @param psaNo
	 */
	public void setPsaNo(String psaNo) {
		this.psaNo = psaNo;
	}
	
	/**
	 * Column Info
	 * @param emerCntcPsonNm
	 */
	public void setEmerCntcPsonNm(String emerCntcPsonNm) {
		this.emerCntcPsonNm = emerCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param dcgoStsCd
	 */
	public void setDcgoStsCd(String dcgoStsCd) {
		this.dcgoStsCd = dcgoStsCd;
	}
	
	/**
	 * Column Info
	 * @param imdgSpclProviNo
	 */
	public void setImdgSpclProviNo(String imdgSpclProviNo) {
		this.imdgSpclProviNo = imdgSpclProviNo;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param hcdgQty
	 */
	public void setHcdgQty(String hcdgQty) {
		this.hcdgQty = hcdgQty;
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
	 * @param mrnPolutFlg
	 */
	public void setMrnPolutFlg(String mrnPolutFlg) {
		this.mrnPolutFlg = mrnPolutFlg;
	}
	
	/**
	 * Column Info
	 * @param inImdgPckCd1
	 */
	public void setInImdgPckCd1(String inImdgPckCd1) {
		this.inImdgPckCd1 = inImdgPckCd1;
	}
	
	/**
	 * Column Info
	 * @param inImdgPckCd2
	 */
	public void setInImdgPckCd2(String inImdgPckCd2) {
		this.inImdgPckCd2 = inImdgPckCd2;
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
	 * @param netWgt
	 */
	public void setNetWgt(String netWgt) {
		this.netWgt = netWgt;
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
	 * @param cntrCgoSeq
	 */
	public void setCntrCgoSeq(String cntrCgoSeq) {
		this.cntrCgoSeq = cntrCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param eqTpsz
	 */
	public void setEqTpsz(String eqTpsz) {
		this.eqTpsz = eqTpsz;
	}
	
	/**
	 * Column Info
	 * @param aplyNo
	 */
	public void setAplyNo(String aplyNo) {
		this.aplyNo = aplyNo;
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
	 * @param cgoLclFlg
	 */
	public void setCgoLclFlg(String cgoLclFlg) {
		this.cgoLclFlg = cgoLclFlg;
	}
	
	/**
	 * Column Info
	 * @param bbCgoSeq
	 */
	public void setBbCgoSeq(String bbCgoSeq) {
		this.bbCgoSeq = bbCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param hzdDesc
	 */
	public void setHzdDesc(String hzdDesc) {
		this.hzdDesc = hzdDesc;
	}
	
	/**
	 * Column Info
	 * @param emerRspnGidChrNo
	 */
	public void setEmerRspnGidChrNo(String emerRspnGidChrNo) {
		this.emerRspnGidChrNo = emerRspnGidChrNo;
	}
	
	/**
	 * Column Info
	 * @param emerTempCtnt
	 */
	public void setEmerTempCtnt(String emerTempCtnt) {
		this.emerTempCtnt = emerTempCtnt;
	}
	
	/**
	 * Column Info
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param outImdgPckCd2
	 */
	public void setOutImdgPckCd2(String outImdgPckCd2) {
		this.outImdgPckCd2 = outImdgPckCd2;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
	/**
	 * Column Info
	 * @param outImdgPckCd1
	 */
	public void setOutImdgPckCd1(String outImdgPckCd1) {
		this.outImdgPckCd1 = outImdgPckCd1;
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
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
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
	 * @param radaTrspNo
	 */
	public void setRadaTrspNo(String radaTrspNo) {
		this.radaTrspNo = radaTrspNo;
	}
	
	/**
	 * Column Info
	 * @param maxInPckTpCd
	 */
	public void setMaxInPckTpCd(String maxInPckTpCd) {
		this.maxInPckTpCd = maxInPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param radaUtCd
	 */
	public void setRadaUtCd(String radaUtCd) {
		this.radaUtCd = radaUtCd;
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
	 * @param imdgExptQtyCd
	 */
	public void setImdgExptQtyCd(String imdgExptQtyCd) {
		this.imdgExptQtyCd = imdgExptQtyCd;
	}
	
	/**
	 * Column Info
	 * @param certiNo
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
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
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param hcdgPckRstrDesc
	 */
	public void setHcdgPckRstrDesc(String hcdgPckRstrDesc) {
		this.hcdgPckRstrDesc = hcdgPckRstrDesc;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param imdgExptQtyFlg
	 */
	public void setImdgExptQtyFlg(String imdgExptQtyFlg) {
		this.imdgExptQtyFlg = imdgExptQtyFlg;
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
	 * @param clodFlg
	 */
	public void setClodFlg(String clodFlg) {
		this.clodFlg = clodFlg;
	}
	
	/**
	 * Column Info
	 * @param intmdImdgPckCd1
	 */
	public void setIntmdImdgPckCd1(String intmdImdgPckCd1) {
		this.intmdImdgPckCd1 = intmdImdgPckCd1;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param intmdImdgPckCd2
	 */
	public void setIntmdImdgPckCd2(String intmdImdgPckCd2) {
		this.intmdImdgPckCd2 = intmdImdgPckCd2;
	}
	
	/**
	 * Column Info
	 * @param ctrlTempCtnt
	 */
	public void setCtrlTempCtnt(String ctrlTempCtnt) {
		this.ctrlTempCtnt = ctrlTempCtnt;
	}
	
	/**
	 * Column Info
	 * @param imdgMrnPolutCd
	 */
	public void setImdgMrnPolutCd(String imdgMrnPolutCd) {
		this.imdgMrnPolutCd = imdgMrnPolutCd;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd2
	 */
	public void setImdgSubsRskLblCd2(String imdgSubsRskLblCd2) {
		this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
	}
	
	/**
	 * Column Info
	 * @param hcdgDpndQtyFlg
	 */
	public void setHcdgDpndQtyFlg(String hcdgDpndQtyFlg) {
		this.hcdgDpndQtyFlg = hcdgDpndQtyFlg;
	}
	
	/**
	 * Column Info
	 * @param hcdgTnkRstrDesc
	 */
	public void setHcdgTnkRstrDesc(String hcdgTnkRstrDesc) {
		this.hcdgTnkRstrDesc = hcdgTnkRstrDesc;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd1
	 */
	public void setImdgSubsRskLblCd1(String imdgSubsRskLblCd1) {
		this.imdgSubsRskLblCd1 = imdgSubsRskLblCd1;
	}
	
	/**
	 * Column Info
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd4
	 */
	public void setImdgSubsRskLblCd4(String imdgSubsRskLblCd4) {
		this.imdgSubsRskLblCd4 = imdgSubsRskLblCd4;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd3
	 */
	public void setImdgSubsRskLblCd3(String imdgSubsRskLblCd3) {
		this.imdgSubsRskLblCd3 = imdgSubsRskLblCd3;
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
	 * @param dgCntrSeqOriginal
	 */
	public void setDgCntrSeqOriginal(String dgCntrSeqOriginal) {
		this.dgCntrSeqOriginal = dgCntrSeqOriginal;
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
		setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
		setDcgoSeq(JSPUtil.getParameter(request, prefix + "dcgo_seq", ""));
		setAwkCgoSeq(JSPUtil.getParameter(request, prefix + "awk_cgo_seq", ""));
		setOutImdgPckQty1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_qty1", ""));
		setInImdgPckDesc1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_desc1", ""));
		setOutImdgPckQty2(JSPUtil.getParameter(request, prefix + "out_imdg_pck_qty2", ""));
		setInImdgPckDesc2(JSPUtil.getParameter(request, prefix + "in_imdg_pck_desc2", ""));
		setRadaSkdNo(JSPUtil.getParameter(request, prefix + "rada_skd_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setImdgCompGrpCd(JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setLtdQty(JSPUtil.getParameter(request, prefix + "ltd_qty", ""));
		setIntmdImdgPckDesc2(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_desc2", ""));
		setIntmdImdgPckQty1(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_qty1", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setHcdgFlg(JSPUtil.getParameter(request, prefix + "hcdg_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setIntmdImdgPckQty2(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_qty2", ""));
		setIntmdImdgPckDesc1(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_desc1", ""));
		setHcdgIntmdBcRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_intmd_bc_rstr_desc", ""));
		setOutImdgPckDesc2(JSPUtil.getParameter(request, prefix + "out_imdg_pck_desc2", ""));
		setOutImdgPckDesc1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_desc1", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRadaAmt(JSPUtil.getParameter(request, prefix + "rada_amt", ""));
		setSpclRqstDesc(JSPUtil.getParameter(request, prefix + "spcl_rqst_desc", ""));
		setNetExploWgt(JSPUtil.getParameter(request, prefix + "net_explo_wgt", ""));
		setEmerRspnGidNo(JSPUtil.getParameter(request, prefix + "emer_rspn_gid_no", ""));
		setCneeDtlDesc(JSPUtil.getParameter(request, prefix + "cnee_dtl_desc", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setSpclRqstFlg(JSPUtil.getParameter(request, prefix + "spcl_rqst_flg", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setRcSeq(JSPUtil.getParameter(request, prefix + "rc_seq", ""));
		setEmerCntcPhnNoCtnt(JSPUtil.getParameter(request, prefix + "emer_cntc_phn_no_ctnt", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
		setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
		setEmsNo(JSPUtil.getParameter(request, prefix + "ems_no", ""));
		setMaxInPckQty(JSPUtil.getParameter(request, prefix + "max_in_pck_qty", ""));
		setSpclCgoAproCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setDgCntrSeq(JSPUtil.getParameter(request, prefix + "dg_cntr_seq", ""));
		setMergeDgCntrSeq(JSPUtil.getParameter(request, prefix + "merge_dg_cntr_seq", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setSpclStwgRqstDesc(JSPUtil.getParameter(request, prefix + "spcl_stwg_rqst_desc", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setInImdgPckQty1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_qty1", ""));
		setInImdgPckQty2(JSPUtil.getParameter(request, prefix + "in_imdg_pck_qty2", ""));
		setPsaNo(JSPUtil.getParameter(request, prefix + "psa_no", ""));
		setEmerCntcPsonNm(JSPUtil.getParameter(request, prefix + "emer_cntc_pson_nm", ""));
		setDcgoStsCd(JSPUtil.getParameter(request, prefix + "dcgo_sts_cd", ""));
		setImdgSpclProviNo(JSPUtil.getParameter(request, prefix + "imdg_spcl_provi_no", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setHcdgQty(JSPUtil.getParameter(request, prefix + "hcdg_qty", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setMrnPolutFlg(JSPUtil.getParameter(request, prefix + "mrn_polut_flg", ""));
		setInImdgPckCd1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_cd1", ""));
		setInImdgPckCd2(JSPUtil.getParameter(request, prefix + "in_imdg_pck_cd2", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
		setEqTpsz(JSPUtil.getParameter(request, prefix + "eq_tpsz", ""));
		setAplyNo(JSPUtil.getParameter(request, prefix + "aply_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCgoLclFlg(JSPUtil.getParameter(request, prefix + "cgo_lcl_flg", ""));
		setBbCgoSeq(JSPUtil.getParameter(request, prefix + "bb_cgo_seq", ""));
		setHzdDesc(JSPUtil.getParameter(request, prefix + "hzd_desc", ""));
		setEmerRspnGidChrNo(JSPUtil.getParameter(request, prefix + "emer_rspn_gid_chr_no", ""));
		setEmerTempCtnt(JSPUtil.getParameter(request, prefix + "emer_temp_ctnt", ""));
		setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
		setOutImdgPckCd2(JSPUtil.getParameter(request, prefix + "out_imdg_pck_cd2", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setOutImdgPckCd1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_cd1", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRadaTrspNo(JSPUtil.getParameter(request, prefix + "rada_trsp_no", ""));
		setMaxInPckTpCd(JSPUtil.getParameter(request, prefix + "max_in_pck_tp_cd", ""));
		setRadaUtCd(JSPUtil.getParameter(request, prefix + "rada_ut_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setImdgExptQtyCd(JSPUtil.getParameter(request, prefix + "imdg_expt_qty_cd", ""));
		setCertiNo(JSPUtil.getParameter(request, prefix + "certi_no", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setHcdgPckRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_pck_rstr_desc", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setImdgExptQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_expt_qty_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setClodFlg(JSPUtil.getParameter(request, prefix + "clod_flg", ""));
		setIntmdImdgPckCd1(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_cd1", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setIntmdImdgPckCd2(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_cd2", ""));
		setCtrlTempCtnt(JSPUtil.getParameter(request, prefix + "ctrl_temp_ctnt", ""));
		setImdgMrnPolutCd(JSPUtil.getParameter(request, prefix + "imdg_mrn_polut_cd", ""));
		setImdgSubsRskLblCd2(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd2", ""));
		setHcdgDpndQtyFlg(JSPUtil.getParameter(request, prefix + "hcdg_dpnd_qty_flg", ""));
		setHcdgTnkRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc", ""));
		setImdgSubsRskLblCd1(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd1", ""));
		setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
		setImdgSubsRskLblCd4(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd4", ""));
		setImdgSubsRskLblCd3(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd3", ""));
		setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
		setDgCntrSeqOriginal(JSPUtil.getParameter(request, prefix + "dg_cntr_seq_original", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgDgCgoInfoVO[]
	 */
	public BkgDgCgoInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgDgCgoInfoVO[]
	 */
	public BkgDgCgoInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgDgCgoInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] dcgoSeq = (JSPUtil.getParameter(request, prefix	+ "dcgo_seq", length));
			String[] awkCgoSeq = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_seq", length));
			String[] outImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_qty1", length));
			String[] inImdgPckDesc1 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_desc1", length));
			String[] outImdgPckQty2 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_qty2", length));
			String[] inImdgPckDesc2 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_desc2", length));
			String[] radaSkdNo = (JSPUtil.getParameter(request, prefix	+ "rada_skd_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_comp_grp_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] ltdQty = (JSPUtil.getParameter(request, prefix	+ "ltd_qty", length));
			String[] intmdImdgPckDesc2 = (JSPUtil.getParameter(request, prefix	+ "intmd_imdg_pck_desc2", length));
			String[] intmdImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "intmd_imdg_pck_qty1", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] hcdgFlg = (JSPUtil.getParameter(request, prefix	+ "hcdg_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] intmdImdgPckQty2 = (JSPUtil.getParameter(request, prefix	+ "intmd_imdg_pck_qty2", length));
			String[] intmdImdgPckDesc1 = (JSPUtil.getParameter(request, prefix	+ "intmd_imdg_pck_desc1", length));
			String[] hcdgIntmdBcRstrDesc = (JSPUtil.getParameter(request, prefix	+ "hcdg_intmd_bc_rstr_desc", length));
			String[] outImdgPckDesc2 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_desc2", length));
			String[] outImdgPckDesc1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_desc1", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] radaAmt = (JSPUtil.getParameter(request, prefix	+ "rada_amt", length));
			String[] spclRqstDesc = (JSPUtil.getParameter(request, prefix	+ "spcl_rqst_desc", length));
			String[] netExploWgt = (JSPUtil.getParameter(request, prefix	+ "net_explo_wgt", length));
			String[] emerRspnGidNo = (JSPUtil.getParameter(request, prefix	+ "emer_rspn_gid_no", length));
			String[] cneeDtlDesc = (JSPUtil.getParameter(request, prefix	+ "cnee_dtl_desc", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] spclRqstFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_rqst_flg", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] rcSeq = (JSPUtil.getParameter(request, prefix	+ "rc_seq", length));
			String[] emerCntcPhnNoCtnt = (JSPUtil.getParameter(request, prefix	+ "emer_cntc_phn_no_ctnt", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_cdo_temp", length));
			String[] emsNo = (JSPUtil.getParameter(request, prefix	+ "ems_no", length));
			String[] maxInPckQty = (JSPUtil.getParameter(request, prefix	+ "max_in_pck_qty", length));
			String[] spclCgoAproCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_apro_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] dgCntrSeq = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_seq", length));
			String[] mergeDgCntrSeq = (JSPUtil.getParameter(request, prefix	+ "merge_dg_cntr_seq", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] spclStwgRqstDesc = (JSPUtil.getParameter(request, prefix	+ "spcl_stwg_rqst_desc", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] inImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_qty1", length));
			String[] inImdgPckQty2 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_qty2", length));
			String[] psaNo = (JSPUtil.getParameter(request, prefix	+ "psa_no", length));
			String[] emerCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "emer_cntc_pson_nm", length));
			String[] dcgoStsCd = (JSPUtil.getParameter(request, prefix	+ "dcgo_sts_cd", length));
			String[] imdgSpclProviNo = (JSPUtil.getParameter(request, prefix	+ "imdg_spcl_provi_no", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] hcdgQty = (JSPUtil.getParameter(request, prefix	+ "hcdg_qty", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix	+ "mrn_polut_flg", length));
			String[] inImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_cd1", length));
			String[] inImdgPckCd2 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_cd2", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] eqTpsz = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz", length));
			String[] aplyNo = (JSPUtil.getParameter(request, prefix	+ "aply_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cgoLclFlg = (JSPUtil.getParameter(request, prefix	+ "cgo_lcl_flg", length));
			String[] bbCgoSeq = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_seq", length));
			String[] hzdDesc = (JSPUtil.getParameter(request, prefix	+ "hzd_desc", length));
			String[] emerRspnGidChrNo = (JSPUtil.getParameter(request, prefix	+ "emer_rspn_gid_chr_no", length));
			String[] emerTempCtnt = (JSPUtil.getParameter(request, prefix	+ "emer_temp_ctnt", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			String[] outImdgPckCd2 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_cd2", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] outImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_cd1", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] radaTrspNo = (JSPUtil.getParameter(request, prefix	+ "rada_trsp_no", length));
			String[] maxInPckTpCd = (JSPUtil.getParameter(request, prefix	+ "max_in_pck_tp_cd", length));
			String[] radaUtCd = (JSPUtil.getParameter(request, prefix	+ "rada_ut_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imdgExptQtyCd = (JSPUtil.getParameter(request, prefix	+ "imdg_expt_qty_cd", length));
			String[] certiNo = (JSPUtil.getParameter(request, prefix	+ "certi_no", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] hcdgPckRstrDesc = (JSPUtil.getParameter(request, prefix	+ "hcdg_pck_rstr_desc", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] imdgExptQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_expt_qty_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] clodFlg = (JSPUtil.getParameter(request, prefix	+ "clod_flg", length));
			String[] intmdImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "intmd_imdg_pck_cd1", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] intmdImdgPckCd2 = (JSPUtil.getParameter(request, prefix	+ "intmd_imdg_pck_cd2", length));
			String[] ctrlTempCtnt = (JSPUtil.getParameter(request, prefix	+ "ctrl_temp_ctnt", length));
			String[] imdgMrnPolutCd = (JSPUtil.getParameter(request, prefix	+ "imdg_mrn_polut_cd", length));
			String[] imdgSubsRskLblCd2 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd2", length));
			String[] hcdgDpndQtyFlg = (JSPUtil.getParameter(request, prefix	+ "hcdg_dpnd_qty_flg", length));
			String[] hcdgTnkRstrDesc = (JSPUtil.getParameter(request, prefix	+ "hcdg_tnk_rstr_desc", length));
			String[] imdgSubsRskLblCd1 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd1", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] imdgSubsRskLblCd4 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd4", length));
			String[] imdgSubsRskLblCd3 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd3", length));
			String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_flg", length));
			String[] dgCntrSeqOriginal = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_seq_original", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgDgCgoInfoVO();
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (dcgoSeq[i] != null)
					model.setDcgoSeq(dcgoSeq[i]);
				if (awkCgoSeq[i] != null)
					model.setAwkCgoSeq(awkCgoSeq[i]);
				if (outImdgPckQty1[i] != null)
					model.setOutImdgPckQty1(outImdgPckQty1[i]);
				if (inImdgPckDesc1[i] != null)
					model.setInImdgPckDesc1(inImdgPckDesc1[i]);
				if (outImdgPckQty2[i] != null)
					model.setOutImdgPckQty2(outImdgPckQty2[i]);
				if (inImdgPckDesc2[i] != null)
					model.setInImdgPckDesc2(inImdgPckDesc2[i]);
				if (radaSkdNo[i] != null)
					model.setRadaSkdNo(radaSkdNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (imdgCompGrpCd[i] != null)
					model.setImdgCompGrpCd(imdgCompGrpCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (ltdQty[i] != null)
					model.setLtdQty(ltdQty[i]);
				if (intmdImdgPckDesc2[i] != null)
					model.setIntmdImdgPckDesc2(intmdImdgPckDesc2[i]);
				if (intmdImdgPckQty1[i] != null)
					model.setIntmdImdgPckQty1(intmdImdgPckQty1[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (hcdgFlg[i] != null)
					model.setHcdgFlg(hcdgFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (intmdImdgPckQty2[i] != null)
					model.setIntmdImdgPckQty2(intmdImdgPckQty2[i]);
				if (intmdImdgPckDesc1[i] != null)
					model.setIntmdImdgPckDesc1(intmdImdgPckDesc1[i]);
				if (hcdgIntmdBcRstrDesc[i] != null)
					model.setHcdgIntmdBcRstrDesc(hcdgIntmdBcRstrDesc[i]);
				if (outImdgPckDesc2[i] != null)
					model.setOutImdgPckDesc2(outImdgPckDesc2[i]);
				if (outImdgPckDesc1[i] != null)
					model.setOutImdgPckDesc1(outImdgPckDesc1[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (radaAmt[i] != null)
					model.setRadaAmt(radaAmt[i]);
				if (spclRqstDesc[i] != null)
					model.setSpclRqstDesc(spclRqstDesc[i]);
				if (netExploWgt[i] != null)
					model.setNetExploWgt(netExploWgt[i]);
				if (emerRspnGidNo[i] != null)
					model.setEmerRspnGidNo(emerRspnGidNo[i]);
				if (cneeDtlDesc[i] != null)
					model.setCneeDtlDesc(cneeDtlDesc[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (spclRqstFlg[i] != null)
					model.setSpclRqstFlg(spclRqstFlg[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (rcSeq[i] != null)
					model.setRcSeq(rcSeq[i]);
				if (emerCntcPhnNoCtnt[i] != null)
					model.setEmerCntcPhnNoCtnt(emerCntcPhnNoCtnt[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (flshPntCdoTemp[i] != null)
					model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
				if (emsNo[i] != null)
					model.setEmsNo(emsNo[i]);
				if (maxInPckQty[i] != null)
					model.setMaxInPckQty(maxInPckQty[i]);
				if (spclCgoAproCd[i] != null)
					model.setSpclCgoAproCd(spclCgoAproCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (dgCntrSeq[i] != null)
					model.setDgCntrSeq(dgCntrSeq[i]);
				if (mergeDgCntrSeq[i] != null)
					model.setMergeDgCntrSeq(mergeDgCntrSeq[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (spclStwgRqstDesc[i] != null)
					model.setSpclStwgRqstDesc(spclStwgRqstDesc[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (inImdgPckQty1[i] != null)
					model.setInImdgPckQty1(inImdgPckQty1[i]);
				if (inImdgPckQty2[i] != null)
					model.setInImdgPckQty2(inImdgPckQty2[i]);
				if (psaNo[i] != null)
					model.setPsaNo(psaNo[i]);
				if (emerCntcPsonNm[i] != null)
					model.setEmerCntcPsonNm(emerCntcPsonNm[i]);
				if (dcgoStsCd[i] != null)
					model.setDcgoStsCd(dcgoStsCd[i]);
				if (imdgSpclProviNo[i] != null)
					model.setImdgSpclProviNo(imdgSpclProviNo[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (hcdgQty[i] != null)
					model.setHcdgQty(hcdgQty[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (mrnPolutFlg[i] != null)
					model.setMrnPolutFlg(mrnPolutFlg[i]);
				if (inImdgPckCd1[i] != null)
					model.setInImdgPckCd1(inImdgPckCd1[i]);
				if (inImdgPckCd2[i] != null)
					model.setInImdgPckCd2(inImdgPckCd2[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (netWgt[i] != null)
					model.setNetWgt(netWgt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cntrCgoSeq[i] != null)
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (eqTpsz[i] != null)
					model.setEqTpsz(eqTpsz[i]);
				if (aplyNo[i] != null)
					model.setAplyNo(aplyNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cgoLclFlg[i] != null)
					model.setCgoLclFlg(cgoLclFlg[i]);
				if (bbCgoSeq[i] != null)
					model.setBbCgoSeq(bbCgoSeq[i]);
				if (hzdDesc[i] != null)
					model.setHzdDesc(hzdDesc[i]);
				if (emerRspnGidChrNo[i] != null)
					model.setEmerRspnGidChrNo(emerRspnGidChrNo[i]);
				if (emerTempCtnt[i] != null)
					model.setEmerTempCtnt(emerTempCtnt[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				if (outImdgPckCd2[i] != null)
					model.setOutImdgPckCd2(outImdgPckCd2[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (outImdgPckCd1[i] != null)
					model.setOutImdgPckCd1(outImdgPckCd1[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (radaTrspNo[i] != null)
					model.setRadaTrspNo(radaTrspNo[i]);
				if (maxInPckTpCd[i] != null)
					model.setMaxInPckTpCd(maxInPckTpCd[i]);
				if (radaUtCd[i] != null)
					model.setRadaUtCd(radaUtCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imdgExptQtyCd[i] != null)
					model.setImdgExptQtyCd(imdgExptQtyCd[i]);
				if (certiNo[i] != null)
					model.setCertiNo(certiNo[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (hcdgPckRstrDesc[i] != null)
					model.setHcdgPckRstrDesc(hcdgPckRstrDesc[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (imdgExptQtyFlg[i] != null)
					model.setImdgExptQtyFlg(imdgExptQtyFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (clodFlg[i] != null)
					model.setClodFlg(clodFlg[i]);
				if (intmdImdgPckCd1[i] != null)
					model.setIntmdImdgPckCd1(intmdImdgPckCd1[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (intmdImdgPckCd2[i] != null)
					model.setIntmdImdgPckCd2(intmdImdgPckCd2[i]);
				if (ctrlTempCtnt[i] != null)
					model.setCtrlTempCtnt(ctrlTempCtnt[i]);
				if (imdgMrnPolutCd[i] != null)
					model.setImdgMrnPolutCd(imdgMrnPolutCd[i]);
				if (imdgSubsRskLblCd2[i] != null)
					model.setImdgSubsRskLblCd2(imdgSubsRskLblCd2[i]);
				if (hcdgDpndQtyFlg[i] != null)
					model.setHcdgDpndQtyFlg(hcdgDpndQtyFlg[i]);
				if (hcdgTnkRstrDesc[i] != null)
					model.setHcdgTnkRstrDesc(hcdgTnkRstrDesc[i]);
				if (imdgSubsRskLblCd1[i] != null)
					model.setImdgSubsRskLblCd1(imdgSubsRskLblCd1[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (imdgSubsRskLblCd4[i] != null)
					model.setImdgSubsRskLblCd4(imdgSubsRskLblCd4[i]);
				if (imdgSubsRskLblCd3[i] != null)
					model.setImdgSubsRskLblCd3(imdgSubsRskLblCd3[i]);
				if (imdgLmtQtyFlg[i] != null)
					model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
				if (dgCntrSeqOriginal[i] != null)
					model.setDgCntrSeqOriginal(dgCntrSeqOriginal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgDgCgoInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgDgCgoInfoVO[]
	 */
	public BkgDgCgoInfoVO[] getBkgDgCgoInfoVOs(){
		BkgDgCgoInfoVO[] vos = (BkgDgCgoInfoVO[])models.toArray(new BkgDgCgoInfoVO[models.size()]);
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
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq = this.dcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoSeq = this.awkCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckQty1 = this.outImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckDesc1 = this.inImdgPckDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckQty2 = this.outImdgPckQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckDesc2 = this.inImdgPckDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radaSkdNo = this.radaSkdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCompGrpCd = this.imdgCompGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltdQty = this.ltdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intmdImdgPckDesc2 = this.intmdImdgPckDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intmdImdgPckQty1 = this.intmdImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgFlg = this.hcdgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intmdImdgPckQty2 = this.intmdImdgPckQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intmdImdgPckDesc1 = this.intmdImdgPckDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgIntmdBcRstrDesc = this.hcdgIntmdBcRstrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckDesc2 = this.outImdgPckDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckDesc1 = this.outImdgPckDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radaAmt = this.radaAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclRqstDesc = this.spclRqstDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netExploWgt = this.netExploWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerRspnGidNo = this.emerRspnGidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeDtlDesc = this.cneeDtlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclRqstFlg = this.spclRqstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcSeq = this.rcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerCntcPhnNoCtnt = this.emerCntcPhnNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntCdoTemp = this.flshPntCdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsNo = this.emsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxInPckQty = this.maxInPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAproCd = this.spclCgoAproCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrSeq = this.dgCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mergeDgCntrSeq = this.mergeDgCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclStwgRqstDesc = this.spclStwgRqstDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckQty1 = this.inImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckQty2 = this.inImdgPckQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaNo = this.psaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerCntcPsonNm = this.emerCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoStsCd = this.dcgoStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSpclProviNo = this.imdgSpclProviNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgQty = this.hcdgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPolutFlg = this.mrnPolutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckCd1 = this.inImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckCd2 = this.inImdgPckCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpsz = this.eqTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyNo = this.aplyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoLclFlg = this.cgoLclFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoSeq = this.bbCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdDesc = this.hzdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerRspnGidChrNo = this.emerRspnGidChrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerTempCtnt = this.emerTempCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckCd2 = this.outImdgPckCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckCd1 = this.outImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radaTrspNo = this.radaTrspNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxInPckTpCd = this.maxInPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radaUtCd = this.radaUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgExptQtyCd = this.imdgExptQtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiNo = this.certiNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgPckRstrDesc = this.hcdgPckRstrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgExptQtyFlg = this.imdgExptQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clodFlg = this.clodFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intmdImdgPckCd1 = this.intmdImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intmdImdgPckCd2 = this.intmdImdgPckCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlTempCtnt = this.ctrlTempCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgMrnPolutCd = this.imdgMrnPolutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd2 = this.imdgSubsRskLblCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgDpndQtyFlg = this.hcdgDpndQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgTnkRstrDesc = this.hcdgTnkRstrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd1 = this.imdgSubsRskLblCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd4 = this.imdgSubsRskLblCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd3 = this.imdgSubsRskLblCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyFlg = this.imdgLmtQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrSeqOriginal = this.dgCntrSeqOriginal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
