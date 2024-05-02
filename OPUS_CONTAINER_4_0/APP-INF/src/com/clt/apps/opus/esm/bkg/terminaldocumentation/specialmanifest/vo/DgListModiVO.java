/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DgListModiVO.java
*@FileTitle : DgListModiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.02.15 이종길 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이종길
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DgListModiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DgListModiVO> models = new ArrayList<DgListModiVO>();
	
	/* Column Info */
	private String eurInrPckDesc = null;
	/* Column Info */
	private String dg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String emerCntcPsonNm = null;
	/* Column Info */
	private String stupFlg = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cgoOprCd = null;
	/* Column Info */
	private String eurPckDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String outImdgPckQty1 = null;
	/* Column Info */
	private String anrSpclTpId = null;
	/* Column Info */
	private String dType = null;
	/* Column Info */
	private String outImdgPckCd1 = null;
	/* Column Info */
	private String hzdDesc = null;
	/* Column Info */
	private String fdrSvcRqstNo = null;
	/* Column Info */
	private String localDbYn = null;
	/* Column Info */
	private String eurDcgoMrnPolutCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String dupCntr = null;
	/* Column Info */
	private String svcRqstNo = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String etaT = null;
	/* Column Info */
	private String spclCgoSeq = null;
	/* Column Info */
	private String emsNo = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String eurOutrPckDesc = null;
	/* Column Info */
	private String fdrVslLloydNo = null;
	/* Column Info */
	private String xtdStayPrmtNo = null;
	/* Column Info */
	private String sendType = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String netWgt = null;
	/* Column Info */
	private String aplyNo = null;
	/* Column Info */
	private String brthYdCd = null;
	/* Column Info */
	private String eurDgDeclTpCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String emerCntcPhnNo = null;
	/* Column Info */
	private String firstMsgSndNo = null;
	/* Column Info */
	private String dcgoRefNo = null;
	/* Column Info */
	private String netExploWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String cntrCgoSeq = null;
	/* Column Info */
	private String cntrRefNo = null;
	/* Column Info */
	private String imdgLmtQtyFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String emerRspnGidNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String anrRoleDivCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String msgSndNo = null;
	/* Column Info */
	private String etaD = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String dupCell = null;
	/* Column Info */
	private String anrCrrTpCd = null;
	/* Column Info */
	private String imdgCompGrpCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String anrFwrdId = null;
	/* Column Info */
	private String inImdgPckQty1 = null;
	/* Column Info */
	private String imdgSubsRskLblCd2 = null;
	/* Column Info */
	private String fdrVvdId = null;
	/* Column Info */
	private String imdgSubsRskLblCd1 = null;
	/* Column Info */
	private String hcdgFlg = null;
	/* Column Info */
	private String mfagNo = null;
	/* Column Info */
	private String imdgSubsRskLblCd4 = null;
	/* Column Info */
	private String flshPntCdoTemp = null;
	/* Column Info */
	private String cntrNoOld = null;
	/* Column Info */
	private String imdgSubsRskLblCd3 = null;
	/* Column Info */
	private String inImdgPckCd1 = null;
	/* Column Info */
	private String mergeBlNo = null;
	/* Column Info */
	private String spclCntrSeq = null;
	/* Column Info */
	private String fdrVslNm = null;
	/* Column Info */
	private String crrDt = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String cellPsnNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String etdD = null;
	/* Column Info */
	private String etdT = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DgListModiVO() {}

	public DgListModiVO(String ibflag, String pagerows, String brthYdCd, String vslCd, String svcRqstNo, String dcgoRefNo, String imdgUnNoSeq, String eurPckDesc, String emerCntcPsonNm, String outImdgPckQty1, String blNo, String anrCrrTpCd, String polCd, String etaT, String vvdCd, String dType, String xtdStayPrmtNo, String cntrTpszCd, String eurDgDeclTpCd, String fdrVvdId, String hcdgFlg, String inImdgPckCd1, String updUsrId, String imdgUnNo, String cntrRefNo, String callSgnNo, String netWgt, String anrRoleDivCd, String skdVoyNo, String cntrCgoSeq, String podCd, String aplyNo, String creUsrId, String lloydNo, String netExploWgt, String emerRspnGidNo, String ydNm, String hzdDesc, String imdgClssCd, String grsWgt, String outImdgPckCd1, String emerCntcPhnNo, String fdrVslNm, String imdgPckGrpCd, String flshPntCdoTemp, String emsNo, String cntrNoOld, String vslEngNm, String mfagNo, String anrFwrdId, String pckQty, String eurDcgoMrnPolutCd, String portCd, String pckTpCd, String eurOutrPckDesc, String vslCntCd, String eurInrPckDesc, String cellPsnNo, String fdrSvcRqstNo, String fdrVslLloydNo, String skdDirCd, String cgoOprCd, String diffRmk, String cntrNo, String anrSpclTpId, String inImdgPckQty1, String imdgSubsRskLblCd2, String imdgSubsRskLblCd1, String prpShpNm, String imdgSubsRskLblCd4, String crrDt, String etaD, String imdgSubsRskLblCd3, String imdgLmtQtyFlg, String localDbYn, String dupCntr, String bkgNo, String cntrCnt, String dg, String firstMsgSndNo, String imdgCompGrpCd, String mergeBlNo, String msgSndNo, String sendType, String seq, String stupFlg, String dupCell, String spclCntrSeq, String spclCgoSeq, String etdD, String etdT) {
		this.eurInrPckDesc = eurInrPckDesc;
		this.dg = dg;
		this.blNo = blNo;
		this.emerCntcPsonNm = emerCntcPsonNm;
		this.stupFlg = stupFlg;
		this.imdgClssCd = imdgClssCd;
		this.bkgNo = bkgNo;
		this.cgoOprCd = cgoOprCd;
		this.eurPckDesc = eurPckDesc;
		this.updUsrId = updUsrId;
		this.vvdCd = vvdCd;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.ydNm = ydNm;
		this.outImdgPckQty1 = outImdgPckQty1;
		this.anrSpclTpId = anrSpclTpId;
		this.dType = dType;
		this.outImdgPckCd1 = outImdgPckCd1;
		this.hzdDesc = hzdDesc;
		this.fdrSvcRqstNo = fdrSvcRqstNo;
		this.localDbYn = localDbYn;
		this.eurDcgoMrnPolutCd = eurDcgoMrnPolutCd;
		this.pagerows = pagerows;
		this.grsWgt = grsWgt;
		this.diffRmk = diffRmk;
		this.vslCd = vslCd;
		this.prpShpNm = prpShpNm;
		this.dupCntr = dupCntr;
		this.svcRqstNo = svcRqstNo;
		this.vslEngNm = vslEngNm;
		this.etaT = etaT;
		this.spclCgoSeq = spclCgoSeq;
		this.emsNo = emsNo;
		this.portCd = portCd;
		this.eurOutrPckDesc = eurOutrPckDesc;
		this.fdrVslLloydNo = fdrVslLloydNo;
		this.xtdStayPrmtNo = xtdStayPrmtNo;
		this.sendType = sendType;
		this.cntrTpszCd = cntrTpszCd;
		this.netWgt = netWgt;
		this.aplyNo = aplyNo;
		this.brthYdCd = brthYdCd;
		this.eurDgDeclTpCd = eurDgDeclTpCd;
		this.pckTpCd = pckTpCd;
		this.emerCntcPhnNo = emerCntcPhnNo;
		this.firstMsgSndNo = firstMsgSndNo;
		this.dcgoRefNo = dcgoRefNo;
		this.netExploWgt = netExploWgt;
		this.ibflag = ibflag;
		this.callSgnNo = callSgnNo;
		this.cntrCgoSeq = cntrCgoSeq;
		this.cntrRefNo = cntrRefNo;
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
		this.creUsrId = creUsrId;
		this.polCd = polCd;
		this.emerRspnGidNo = emerRspnGidNo;
		this.skdDirCd = skdDirCd;
		this.cntrCnt = cntrCnt;
		this.anrRoleDivCd = anrRoleDivCd;
		this.podCd = podCd;
		this.lloydNo = lloydNo;
		this.imdgUnNo = imdgUnNo;
		this.msgSndNo = msgSndNo;
		this.etaD = etaD;
		this.seq = seq;
		this.dupCell = dupCell;
		this.anrCrrTpCd = anrCrrTpCd;
		this.imdgCompGrpCd = imdgCompGrpCd;
		this.skdVoyNo = skdVoyNo;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.anrFwrdId = anrFwrdId;
		this.inImdgPckQty1 = inImdgPckQty1;
		this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
		this.fdrVvdId = fdrVvdId;
		this.imdgSubsRskLblCd1 = imdgSubsRskLblCd1;
		this.hcdgFlg = hcdgFlg;
		this.mfagNo = mfagNo;
		this.imdgSubsRskLblCd4 = imdgSubsRskLblCd4;
		this.flshPntCdoTemp = flshPntCdoTemp;
		this.cntrNoOld = cntrNoOld;
		this.imdgSubsRskLblCd3 = imdgSubsRskLblCd3;
		this.inImdgPckCd1 = inImdgPckCd1;
		this.mergeBlNo = mergeBlNo;
		this.spclCntrSeq = spclCntrSeq;
		this.fdrVslNm = fdrVslNm;
		this.crrDt = crrDt;
		this.pckQty = pckQty;
		this.vslCntCd = vslCntCd;
		this.cellPsnNo = cellPsnNo;
		this.cntrNo = cntrNo;
		this.etdD = etdD;
		this.etdT = etdT;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eur_inr_pck_desc", getEurInrPckDesc());
		this.hashColumns.put("dg", getDg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("emer_cntc_pson_nm", getEmerCntcPsonNm());
		this.hashColumns.put("stup_flg", getStupFlg());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cgo_opr_cd", getCgoOprCd());
		this.hashColumns.put("eur_pck_desc", getEurPckDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("out_imdg_pck_qty1", getOutImdgPckQty1());
		this.hashColumns.put("anr_spcl_tp_id", getAnrSpclTpId());
		this.hashColumns.put("d_type", getDType());
		this.hashColumns.put("out_imdg_pck_cd1", getOutImdgPckCd1());
		this.hashColumns.put("hzd_desc", getHzdDesc());
		this.hashColumns.put("fdr_svc_rqst_no", getFdrSvcRqstNo());
		this.hashColumns.put("local_db_yn", getLocalDbYn());
		this.hashColumns.put("eur_dcgo_mrn_polut_cd", getEurDcgoMrnPolutCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("dup_cntr", getDupCntr());
		this.hashColumns.put("svc_rqst_no", getSvcRqstNo());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("eta_t", getEtaT());
		this.hashColumns.put("spcl_cgo_seq", getSpclCgoSeq());
		this.hashColumns.put("ems_no", getEmsNo());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("eur_outr_pck_desc", getEurOutrPckDesc());
		this.hashColumns.put("fdr_vsl_lloyd_no", getFdrVslLloydNo());
		this.hashColumns.put("xtd_stay_prmt_no", getXtdStayPrmtNo());
		this.hashColumns.put("send_type", getSendType());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("aply_no", getAplyNo());
		this.hashColumns.put("brth_yd_cd", getBrthYdCd());
		this.hashColumns.put("eur_dg_decl_tp_cd", getEurDgDeclTpCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("emer_cntc_phn_no", getEmerCntcPhnNo());
		this.hashColumns.put("first_msg_snd_no", getFirstMsgSndNo());
		this.hashColumns.put("dcgo_ref_no", getDcgoRefNo());
		this.hashColumns.put("net_explo_wgt", getNetExploWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("cntr_ref_no", getCntrRefNo());
		this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("emer_rspn_gid_no", getEmerRspnGidNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("anr_role_div_cd", getAnrRoleDivCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("msg_snd_no", getMsgSndNo());
		this.hashColumns.put("eta_d", getEtaD());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("dup_cell", getDupCell());
		this.hashColumns.put("anr_crr_tp_cd", getAnrCrrTpCd());
		this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("anr_fwrd_id", getAnrFwrdId());
		this.hashColumns.put("in_imdg_pck_qty1", getInImdgPckQty1());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd2", getImdgSubsRskLblCd2());
		this.hashColumns.put("fdr_vvd_id", getFdrVvdId());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd1", getImdgSubsRskLblCd1());
		this.hashColumns.put("hcdg_flg", getHcdgFlg());
		this.hashColumns.put("mfag_no", getMfagNo());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd4", getImdgSubsRskLblCd4());
		this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
		this.hashColumns.put("cntr_no_old", getCntrNoOld());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd3", getImdgSubsRskLblCd3());
		this.hashColumns.put("in_imdg_pck_cd1", getInImdgPckCd1());
		this.hashColumns.put("merge_bl_no", getMergeBlNo());
		this.hashColumns.put("spcl_cntr_seq", getSpclCntrSeq());
		this.hashColumns.put("fdr_vsl_nm", getFdrVslNm());
		this.hashColumns.put("crr_dt", getCrrDt());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("cell_psn_no", getCellPsnNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("etd_d", getEtdD());
		this.hashColumns.put("etd_t", getEtdT());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eur_inr_pck_desc", "eurInrPckDesc");
		this.hashFields.put("dg", "dg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("emer_cntc_pson_nm", "emerCntcPsonNm");
		this.hashFields.put("stup_flg", "stupFlg");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cgo_opr_cd", "cgoOprCd");
		this.hashFields.put("eur_pck_desc", "eurPckDesc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("out_imdg_pck_qty1", "outImdgPckQty1");
		this.hashFields.put("anr_spcl_tp_id", "anrSpclTpId");
		this.hashFields.put("d_type", "dType");
		this.hashFields.put("out_imdg_pck_cd1", "outImdgPckCd1");
		this.hashFields.put("hzd_desc", "hzdDesc");
		this.hashFields.put("fdr_svc_rqst_no", "fdrSvcRqstNo");
		this.hashFields.put("local_db_yn", "localDbYn");
		this.hashFields.put("eur_dcgo_mrn_polut_cd", "eurDcgoMrnPolutCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("dup_cntr", "dupCntr");
		this.hashFields.put("svc_rqst_no", "svcRqstNo");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("eta_t", "etaT");
		this.hashFields.put("spcl_cgo_seq", "spclCgoSeq");
		this.hashFields.put("ems_no", "emsNo");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("eur_outr_pck_desc", "eurOutrPckDesc");
		this.hashFields.put("fdr_vsl_lloyd_no", "fdrVslLloydNo");
		this.hashFields.put("xtd_stay_prmt_no", "xtdStayPrmtNo");
		this.hashFields.put("send_type", "sendType");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("aply_no", "aplyNo");
		this.hashFields.put("brth_yd_cd", "brthYdCd");
		this.hashFields.put("eur_dg_decl_tp_cd", "eurDgDeclTpCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("emer_cntc_phn_no", "emerCntcPhnNo");
		this.hashFields.put("first_msg_snd_no", "firstMsgSndNo");
		this.hashFields.put("dcgo_ref_no", "dcgoRefNo");
		this.hashFields.put("net_explo_wgt", "netExploWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("cntr_ref_no", "cntrRefNo");
		this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("emer_rspn_gid_no", "emerRspnGidNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("anr_role_div_cd", "anrRoleDivCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("msg_snd_no", "msgSndNo");
		this.hashFields.put("eta_d", "etaD");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("dup_cell", "dupCell");
		this.hashFields.put("anr_crr_tp_cd", "anrCrrTpCd");
		this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("anr_fwrd_id", "anrFwrdId");
		this.hashFields.put("in_imdg_pck_qty1", "inImdgPckQty1");
		this.hashFields.put("imdg_subs_rsk_lbl_cd2", "imdgSubsRskLblCd2");
		this.hashFields.put("fdr_vvd_id", "fdrVvdId");
		this.hashFields.put("imdg_subs_rsk_lbl_cd1", "imdgSubsRskLblCd1");
		this.hashFields.put("hcdg_flg", "hcdgFlg");
		this.hashFields.put("mfag_no", "mfagNo");
		this.hashFields.put("imdg_subs_rsk_lbl_cd4", "imdgSubsRskLblCd4");
		this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
		this.hashFields.put("cntr_no_old", "cntrNoOld");
		this.hashFields.put("imdg_subs_rsk_lbl_cd3", "imdgSubsRskLblCd3");
		this.hashFields.put("in_imdg_pck_cd1", "inImdgPckCd1");
		this.hashFields.put("merge_bl_no", "mergeBlNo");
		this.hashFields.put("spcl_cntr_seq", "spclCntrSeq");
		this.hashFields.put("fdr_vsl_nm", "fdrVslNm");
		this.hashFields.put("crr_dt", "crrDt");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("cell_psn_no", "cellPsnNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("etd_d", "etdD");
		this.hashFields.put("etd_t", "etdT");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eurInrPckDesc
	 */
	public String getEurInrPckDesc() {
		return this.eurInrPckDesc;
	}
	
	/**
	 * Column Info
	 * @return dg
	 */
	public String getDg() {
		return this.dg;
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
	 * @return emerCntcPsonNm
	 */
	public String getEmerCntcPsonNm() {
		return this.emerCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return stupFlg
	 */
	public String getStupFlg() {
		return this.stupFlg;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cgoOprCd
	 */
	public String getCgoOprCd() {
		return this.cgoOprCd;
	}
	
	/**
	 * Column Info
	 * @return eurPckDesc
	 */
	public String getEurPckDesc() {
		return this.eurPckDesc;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
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
	 * @return anrSpclTpId
	 */
	public String getAnrSpclTpId() {
		return this.anrSpclTpId;
	}
	
	/**
	 * Column Info
	 * @return dType
	 */
	public String getDType() {
		return this.dType;
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
	 * @return hzdDesc
	 */
	public String getHzdDesc() {
		return this.hzdDesc;
	}
	
	/**
	 * Column Info
	 * @return fdrSvcRqstNo
	 */
	public String getFdrSvcRqstNo() {
		return this.fdrSvcRqstNo;
	}
	
	/**
	 * Column Info
	 * @return localDbYn
	 */
	public String getLocalDbYn() {
		return this.localDbYn;
	}
	
	/**
	 * Column Info
	 * @return eurDcgoMrnPolutCd
	 */
	public String getEurDcgoMrnPolutCd() {
		return this.eurDcgoMrnPolutCd;
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
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return dupCntr
	 */
	public String getDupCntr() {
		return this.dupCntr;
	}
	
	/**
	 * Column Info
	 * @return svcRqstNo
	 */
	public String getSvcRqstNo() {
		return this.svcRqstNo;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return etaT
	 */
	public String getEtaT() {
		return this.etaT;
	}
	
	/**
	 * Column Info
	 * @return spclCgoSeq
	 */
	public String getSpclCgoSeq() {
		return this.spclCgoSeq;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return eurOutrPckDesc
	 */
	public String getEurOutrPckDesc() {
		return this.eurOutrPckDesc;
	}
	
	/**
	 * Column Info
	 * @return fdrVslLloydNo
	 */
	public String getFdrVslLloydNo() {
		return this.fdrVslLloydNo;
	}
	
	/**
	 * Column Info
	 * @return xtdStayPrmtNo
	 */
	public String getXtdStayPrmtNo() {
		return this.xtdStayPrmtNo;
	}
	
	/**
	 * Column Info
	 * @return sendType
	 */
	public String getSendType() {
		return this.sendType;
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
	 * @return netWgt
	 */
	public String getNetWgt() {
		return this.netWgt;
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
	 * @return brthYdCd
	 */
	public String getBrthYdCd() {
		return this.brthYdCd;
	}
	
	/**
	 * Column Info
	 * @return eurDgDeclTpCd
	 */
	public String getEurDgDeclTpCd() {
		return this.eurDgDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return emerCntcPhnNo
	 */
	public String getEmerCntcPhnNo() {
		return this.emerCntcPhnNo;
	}
	
	/**
	 * Column Info
	 * @return firstMsgSndNo
	 */
	public String getFirstMsgSndNo() {
		return this.firstMsgSndNo;
	}
	
	/**
	 * Column Info
	 * @return dcgoRefNo
	 */
	public String getDcgoRefNo() {
		return this.dcgoRefNo;
	}
	
	/**
	 * Column Info
	 * @return netExploWgt
	 */
	public String getNetExploWgt() {
		return this.netExploWgt;
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
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
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
	 * @return cntrRefNo
	 */
	public String getCntrRefNo() {
		return this.cntrRefNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return emerRspnGidNo
	 */
	public String getEmerRspnGidNo() {
		return this.emerRspnGidNo;
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
	 * @return cntrCnt
	 */
	public String getCntrCnt() {
		return this.cntrCnt;
	}
	
	/**
	 * Column Info
	 * @return anrRoleDivCd
	 */
	public String getAnrRoleDivCd() {
		return this.anrRoleDivCd;
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
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
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
	 * @return msgSndNo
	 */
	public String getMsgSndNo() {
		return this.msgSndNo;
	}
	
	/**
	 * Column Info
	 * @return etaD
	 */
	public String getEtaD() {
		return this.etaD;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return dupCell
	 */
	public String getDupCell() {
		return this.dupCell;
	}
	
	/**
	 * Column Info
	 * @return anrCrrTpCd
	 */
	public String getAnrCrrTpCd() {
		return this.anrCrrTpCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return anrFwrdId
	 */
	public String getAnrFwrdId() {
		return this.anrFwrdId;
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
	 * @return imdgSubsRskLblCd2
	 */
	public String getImdgSubsRskLblCd2() {
		return this.imdgSubsRskLblCd2;
	}
	
	/**
	 * Column Info
	 * @return fdrVvdId
	 */
	public String getFdrVvdId() {
		return this.fdrVvdId;
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
	 * @return hcdgFlg
	 */
	public String getHcdgFlg() {
		return this.hcdgFlg;
	}
	
	/**
	 * Column Info
	 * @return mfagNo
	 */
	public String getMfagNo() {
		return this.mfagNo;
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
	 * @return flshPntCdoTemp
	 */
	public String getFlshPntCdoTemp() {
		return this.flshPntCdoTemp;
	}
	
	/**
	 * Column Info
	 * @return cntrNoOld
	 */
	public String getCntrNoOld() {
		return this.cntrNoOld;
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
	 * @return inImdgPckCd1
	 */
	public String getInImdgPckCd1() {
		return this.inImdgPckCd1;
	}
	
	/**
	 * Column Info
	 * @return mergeBlNo
	 */
	public String getMergeBlNo() {
		return this.mergeBlNo;
	}
	
	/**
	 * Column Info
	 * @return spclCntrSeq
	 */
	public String getSpclCntrSeq() {
		return this.spclCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return fdrVslNm
	 */
	public String getFdrVslNm() {
		return this.fdrVslNm;
	}
	
	/**
	 * Column Info
	 * @return crrDt
	 */
	public String getCrrDt() {
		return this.crrDt;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}
	
	/**
	 * Column Info
	 * @return cellPsnNo
	 */
	public String getCellPsnNo() {
		return this.cellPsnNo;
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
	 * @return etdD
	 */
	public String getEtdD() {
		return this.etdD;
	}
	
	/**
	 * Column Info
	 * @return etdT
	 */
	public String getEtdT() {
		return this.etdT;
	}

	/**
	 * Column Info
	 * @param eurInrPckDesc
	 */
	public void setEurInrPckDesc(String eurInrPckDesc) {
		this.eurInrPckDesc = eurInrPckDesc;
	}
	
	/**
	 * Column Info
	 * @param dg
	 */
	public void setDg(String dg) {
		this.dg = dg;
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
	 * @param emerCntcPsonNm
	 */
	public void setEmerCntcPsonNm(String emerCntcPsonNm) {
		this.emerCntcPsonNm = emerCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param stupFlg
	 */
	public void setStupFlg(String stupFlg) {
		this.stupFlg = stupFlg;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cgoOprCd
	 */
	public void setCgoOprCd(String cgoOprCd) {
		this.cgoOprCd = cgoOprCd;
	}
	
	/**
	 * Column Info
	 * @param eurPckDesc
	 */
	public void setEurPckDesc(String eurPckDesc) {
		this.eurPckDesc = eurPckDesc;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
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
	 * @param anrSpclTpId
	 */
	public void setAnrSpclTpId(String anrSpclTpId) {
		this.anrSpclTpId = anrSpclTpId;
	}
	
	/**
	 * Column Info
	 * @param dType
	 */
	public void setDType(String dType) {
		this.dType = dType;
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
	 * @param hzdDesc
	 */
	public void setHzdDesc(String hzdDesc) {
		this.hzdDesc = hzdDesc;
	}
	
	/**
	 * Column Info
	 * @param fdrSvcRqstNo
	 */
	public void setFdrSvcRqstNo(String fdrSvcRqstNo) {
		this.fdrSvcRqstNo = fdrSvcRqstNo;
	}
	
	/**
	 * Column Info
	 * @param localDbYn
	 */
	public void setLocalDbYn(String localDbYn) {
		this.localDbYn = localDbYn;
	}
	
	/**
	 * Column Info
	 * @param eurDcgoMrnPolutCd
	 */
	public void setEurDcgoMrnPolutCd(String eurDcgoMrnPolutCd) {
		this.eurDcgoMrnPolutCd = eurDcgoMrnPolutCd;
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
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param dupCntr
	 */
	public void setDupCntr(String dupCntr) {
		this.dupCntr = dupCntr;
	}
	
	/**
	 * Column Info
	 * @param svcRqstNo
	 */
	public void setSvcRqstNo(String svcRqstNo) {
		this.svcRqstNo = svcRqstNo;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param etaT
	 */
	public void setEtaT(String etaT) {
		this.etaT = etaT;
	}
	
	/**
	 * Column Info
	 * @param spclCgoSeq
	 */
	public void setSpclCgoSeq(String spclCgoSeq) {
		this.spclCgoSeq = spclCgoSeq;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param eurOutrPckDesc
	 */
	public void setEurOutrPckDesc(String eurOutrPckDesc) {
		this.eurOutrPckDesc = eurOutrPckDesc;
	}
	
	/**
	 * Column Info
	 * @param fdrVslLloydNo
	 */
	public void setFdrVslLloydNo(String fdrVslLloydNo) {
		this.fdrVslLloydNo = fdrVslLloydNo;
	}
	
	/**
	 * Column Info
	 * @param xtdStayPrmtNo
	 */
	public void setXtdStayPrmtNo(String xtdStayPrmtNo) {
		this.xtdStayPrmtNo = xtdStayPrmtNo;
	}
	
	/**
	 * Column Info
	 * @param sendType
	 */
	public void setSendType(String sendType) {
		this.sendType = sendType;
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
	 * @param netWgt
	 */
	public void setNetWgt(String netWgt) {
		this.netWgt = netWgt;
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
	 * @param brthYdCd
	 */
	public void setBrthYdCd(String brthYdCd) {
		this.brthYdCd = brthYdCd;
	}
	
	/**
	 * Column Info
	 * @param eurDgDeclTpCd
	 */
	public void setEurDgDeclTpCd(String eurDgDeclTpCd) {
		this.eurDgDeclTpCd = eurDgDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param emerCntcPhnNo
	 */
	public void setEmerCntcPhnNo(String emerCntcPhnNo) {
		this.emerCntcPhnNo = emerCntcPhnNo;
	}
	
	/**
	 * Column Info
	 * @param firstMsgSndNo
	 */
	public void setFirstMsgSndNo(String firstMsgSndNo) {
		this.firstMsgSndNo = firstMsgSndNo;
	}
	
	/**
	 * Column Info
	 * @param dcgoRefNo
	 */
	public void setDcgoRefNo(String dcgoRefNo) {
		this.dcgoRefNo = dcgoRefNo;
	}
	
	/**
	 * Column Info
	 * @param netExploWgt
	 */
	public void setNetExploWgt(String netExploWgt) {
		this.netExploWgt = netExploWgt;
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
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
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
	 * @param cntrRefNo
	 */
	public void setCntrRefNo(String cntrRefNo) {
		this.cntrRefNo = cntrRefNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param emerRspnGidNo
	 */
	public void setEmerRspnGidNo(String emerRspnGidNo) {
		this.emerRspnGidNo = emerRspnGidNo;
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
	 * @param cntrCnt
	 */
	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
	}
	
	/**
	 * Column Info
	 * @param anrRoleDivCd
	 */
	public void setAnrRoleDivCd(String anrRoleDivCd) {
		this.anrRoleDivCd = anrRoleDivCd;
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
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
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
	 * @param msgSndNo
	 */
	public void setMsgSndNo(String msgSndNo) {
		this.msgSndNo = msgSndNo;
	}
	
	/**
	 * Column Info
	 * @param etaD
	 */
	public void setEtaD(String etaD) {
		this.etaD = etaD;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param dupCell
	 */
	public void setDupCell(String dupCell) {
		this.dupCell = dupCell;
	}
	
	/**
	 * Column Info
	 * @param anrCrrTpCd
	 */
	public void setAnrCrrTpCd(String anrCrrTpCd) {
		this.anrCrrTpCd = anrCrrTpCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param anrFwrdId
	 */
	public void setAnrFwrdId(String anrFwrdId) {
		this.anrFwrdId = anrFwrdId;
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
	 * @param imdgSubsRskLblCd2
	 */
	public void setImdgSubsRskLblCd2(String imdgSubsRskLblCd2) {
		this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
	}
	
	/**
	 * Column Info
	 * @param fdrVvdId
	 */
	public void setFdrVvdId(String fdrVvdId) {
		this.fdrVvdId = fdrVvdId;
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
	 * @param hcdgFlg
	 */
	public void setHcdgFlg(String hcdgFlg) {
		this.hcdgFlg = hcdgFlg;
	}
	
	/**
	 * Column Info
	 * @param mfagNo
	 */
	public void setMfagNo(String mfagNo) {
		this.mfagNo = mfagNo;
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
	 * @param flshPntCdoTemp
	 */
	public void setFlshPntCdoTemp(String flshPntCdoTemp) {
		this.flshPntCdoTemp = flshPntCdoTemp;
	}
	
	/**
	 * Column Info
	 * @param cntrNoOld
	 */
	public void setCntrNoOld(String cntrNoOld) {
		this.cntrNoOld = cntrNoOld;
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
	 * @param inImdgPckCd1
	 */
	public void setInImdgPckCd1(String inImdgPckCd1) {
		this.inImdgPckCd1 = inImdgPckCd1;
	}
	
	/**
	 * Column Info
	 * @param mergeBlNo
	 */
	public void setMergeBlNo(String mergeBlNo) {
		this.mergeBlNo = mergeBlNo;
	}
	
	/**
	 * Column Info
	 * @param spclCntrSeq
	 */
	public void setSpclCntrSeq(String spclCntrSeq) {
		this.spclCntrSeq = spclCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param fdrVslNm
	 */
	public void setFdrVslNm(String fdrVslNm) {
		this.fdrVslNm = fdrVslNm;
	}
	
	/**
	 * Column Info
	 * @param crrDt
	 */
	public void setCrrDt(String crrDt) {
		this.crrDt = crrDt;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
	}
	
	/**
	 * Column Info
	 * @param cellPsnNo
	 */
	public void setCellPsnNo(String cellPsnNo) {
		this.cellPsnNo = cellPsnNo;
	}
	
	/**
	 * Column Info
	 * @param etdD
	 */
	public void setEtdD(String etdD) {
		this.etdD = etdD;
	}
	
	/**
	 * Column Info
	 * @param etdT
	 */
	public void setEtdT(String etdT) {
		this.etdT = etdT;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
		setEurInrPckDesc(JSPUtil.getParameter(request, prefix + "eur_inr_pck_desc", ""));
		setDg(JSPUtil.getParameter(request, prefix + "dg", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setEmerCntcPsonNm(JSPUtil.getParameter(request, prefix + "emer_cntc_pson_nm", ""));
		setStupFlg(JSPUtil.getParameter(request, prefix + "stup_flg", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCgoOprCd(JSPUtil.getParameter(request, prefix + "cgo_opr_cd", ""));
		setEurPckDesc(JSPUtil.getParameter(request, prefix + "eur_pck_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setOutImdgPckQty1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_qty1", ""));
		setAnrSpclTpId(JSPUtil.getParameter(request, prefix + "anr_spcl_tp_id", ""));
		setDType(JSPUtil.getParameter(request, prefix + "d_type", ""));
		setOutImdgPckCd1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_cd1", ""));
		setHzdDesc(JSPUtil.getParameter(request, prefix + "hzd_desc", ""));
		setFdrSvcRqstNo(JSPUtil.getParameter(request, prefix + "fdr_svc_rqst_no", ""));
		setLocalDbYn(JSPUtil.getParameter(request, prefix + "local_db_yn", ""));
		setEurDcgoMrnPolutCd(JSPUtil.getParameter(request, prefix + "eur_dcgo_mrn_polut_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
		setDupCntr(JSPUtil.getParameter(request, prefix + "dup_cntr", ""));
		setSvcRqstNo(JSPUtil.getParameter(request, prefix + "svc_rqst_no", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setEtaT(JSPUtil.getParameter(request, prefix + "eta_t", ""));
		setSpclCgoSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_seq", ""));
		setEmsNo(JSPUtil.getParameter(request, prefix + "ems_no", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setEurOutrPckDesc(JSPUtil.getParameter(request, prefix + "eur_outr_pck_desc", ""));
		setFdrVslLloydNo(JSPUtil.getParameter(request, prefix + "fdr_vsl_lloyd_no", ""));
		setXtdStayPrmtNo(JSPUtil.getParameter(request, prefix + "xtd_stay_prmt_no", ""));
		setSendType(JSPUtil.getParameter(request, prefix + "send_type", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
		setAplyNo(JSPUtil.getParameter(request, prefix + "aply_no", ""));
		setBrthYdCd(JSPUtil.getParameter(request, prefix + "brth_yd_cd", ""));
		setEurDgDeclTpCd(JSPUtil.getParameter(request, prefix + "eur_dg_decl_tp_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setEmerCntcPhnNo(JSPUtil.getParameter(request, prefix + "emer_cntc_phn_no", ""));
		setFirstMsgSndNo(JSPUtil.getParameter(request, prefix + "first_msg_snd_no", ""));
		setDcgoRefNo(JSPUtil.getParameter(request, prefix + "dcgo_ref_no", ""));
		setNetExploWgt(JSPUtil.getParameter(request, prefix + "net_explo_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
		setCntrRefNo(JSPUtil.getParameter(request, prefix + "cntr_ref_no", ""));
		setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setEmerRspnGidNo(JSPUtil.getParameter(request, prefix + "emer_rspn_gid_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setAnrRoleDivCd(JSPUtil.getParameter(request, prefix + "anr_role_div_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setMsgSndNo(JSPUtil.getParameter(request, prefix + "msg_snd_no", ""));
		setEtaD(JSPUtil.getParameter(request, prefix + "eta_d", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setDupCell(JSPUtil.getParameter(request, prefix + "dup_cell", ""));
		setAnrCrrTpCd(JSPUtil.getParameter(request, prefix + "anr_crr_tp_cd", ""));
		setImdgCompGrpCd(JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
		setAnrFwrdId(JSPUtil.getParameter(request, prefix + "anr_fwrd_id", ""));
		setInImdgPckQty1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_qty1", ""));
		setImdgSubsRskLblCd2(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd2", ""));
		setFdrVvdId(JSPUtil.getParameter(request, prefix + "fdr_vvd_id", ""));
		setImdgSubsRskLblCd1(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd1", ""));
		setHcdgFlg(JSPUtil.getParameter(request, prefix + "hcdg_flg", ""));
		setMfagNo(JSPUtil.getParameter(request, prefix + "mfag_no", ""));
		setImdgSubsRskLblCd4(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd4", ""));
		setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
		setCntrNoOld(JSPUtil.getParameter(request, prefix + "cntr_no_old", ""));
		setImdgSubsRskLblCd3(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd3", ""));
		setInImdgPckCd1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_cd1", ""));
		setMergeBlNo(JSPUtil.getParameter(request, prefix + "merge_bl_no", ""));
		setSpclCntrSeq(JSPUtil.getParameter(request, prefix + "spcl_cntr_seq", ""));
		setFdrVslNm(JSPUtil.getParameter(request, prefix + "fdr_vsl_nm", ""));
		setCrrDt(JSPUtil.getParameter(request, prefix + "crr_dt", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setVslCntCd(JSPUtil.getParameter(request, prefix + "vsl_cnt_cd", ""));
		setCellPsnNo(JSPUtil.getParameter(request, prefix + "cell_psn_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setEtdD(JSPUtil.getParameter(request, prefix + "etd_d", ""));
		setEtdT(JSPUtil.getParameter(request, prefix + "etd_t", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DgListModiVO[]
	 */
	public DgListModiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DgListModiVO[]
	 */
	public DgListModiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DgListModiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eurInrPckDesc = (JSPUtil.getParameter(request, prefix	+ "eur_inr_pck_desc", length));
			String[] dg = (JSPUtil.getParameter(request, prefix	+ "dg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] emerCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "emer_cntc_pson_nm", length));
			String[] stupFlg = (JSPUtil.getParameter(request, prefix	+ "stup_flg", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cgoOprCd = (JSPUtil.getParameter(request, prefix	+ "cgo_opr_cd", length));
			String[] eurPckDesc = (JSPUtil.getParameter(request, prefix	+ "eur_pck_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] outImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_qty1", length));
			String[] anrSpclTpId = (JSPUtil.getParameter(request, prefix	+ "anr_spcl_tp_id", length));
			String[] dType = (JSPUtil.getParameter(request, prefix	+ "d_type", length));
			String[] outImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_cd1", length));
			String[] hzdDesc = (JSPUtil.getParameter(request, prefix	+ "hzd_desc", length));
			String[] fdrSvcRqstNo = (JSPUtil.getParameter(request, prefix	+ "fdr_svc_rqst_no", length));
			String[] localDbYn = (JSPUtil.getParameter(request, prefix	+ "local_db_yn", length));
			String[] eurDcgoMrnPolutCd = (JSPUtil.getParameter(request, prefix	+ "eur_dcgo_mrn_polut_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] dupCntr = (JSPUtil.getParameter(request, prefix	+ "dup_cntr", length));
			String[] svcRqstNo = (JSPUtil.getParameter(request, prefix	+ "svc_rqst_no", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] etaT = (JSPUtil.getParameter(request, prefix	+ "eta_t", length));
			String[] spclCgoSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_seq", length));
			String[] emsNo = (JSPUtil.getParameter(request, prefix	+ "ems_no", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] eurOutrPckDesc = (JSPUtil.getParameter(request, prefix	+ "eur_outr_pck_desc", length));
			String[] fdrVslLloydNo = (JSPUtil.getParameter(request, prefix	+ "fdr_vsl_lloyd_no", length));
			String[] xtdStayPrmtNo = (JSPUtil.getParameter(request, prefix	+ "xtd_stay_prmt_no", length));
			String[] sendType = (JSPUtil.getParameter(request, prefix	+ "send_type", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] aplyNo = (JSPUtil.getParameter(request, prefix	+ "aply_no", length));
			String[] brthYdCd = (JSPUtil.getParameter(request, prefix	+ "brth_yd_cd", length));
			String[] eurDgDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "eur_dg_decl_tp_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] emerCntcPhnNo = (JSPUtil.getParameter(request, prefix	+ "emer_cntc_phn_no", length));
			String[] firstMsgSndNo = (JSPUtil.getParameter(request, prefix	+ "first_msg_snd_no", length));
			String[] dcgoRefNo = (JSPUtil.getParameter(request, prefix	+ "dcgo_ref_no", length));
			String[] netExploWgt = (JSPUtil.getParameter(request, prefix	+ "net_explo_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] cntrRefNo = (JSPUtil.getParameter(request, prefix	+ "cntr_ref_no", length));
			String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] emerRspnGidNo = (JSPUtil.getParameter(request, prefix	+ "emer_rspn_gid_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] anrRoleDivCd = (JSPUtil.getParameter(request, prefix	+ "anr_role_div_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] msgSndNo = (JSPUtil.getParameter(request, prefix	+ "msg_snd_no", length));
			String[] etaD = (JSPUtil.getParameter(request, prefix	+ "eta_d", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] dupCell = (JSPUtil.getParameter(request, prefix	+ "dup_cell", length));
			String[] anrCrrTpCd = (JSPUtil.getParameter(request, prefix	+ "anr_crr_tp_cd", length));
			String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_comp_grp_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] anrFwrdId = (JSPUtil.getParameter(request, prefix	+ "anr_fwrd_id", length));
			String[] inImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_qty1", length));
			String[] imdgSubsRskLblCd2 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd2", length));
			String[] fdrVvdId = (JSPUtil.getParameter(request, prefix	+ "fdr_vvd_id", length));
			String[] imdgSubsRskLblCd1 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd1", length));
			String[] hcdgFlg = (JSPUtil.getParameter(request, prefix	+ "hcdg_flg", length));
			String[] mfagNo = (JSPUtil.getParameter(request, prefix	+ "mfag_no", length));
			String[] imdgSubsRskLblCd4 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd4", length));
			String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_cdo_temp", length));
			String[] cntrNoOld = (JSPUtil.getParameter(request, prefix	+ "cntr_no_old", length));
			String[] imdgSubsRskLblCd3 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd3", length));
			String[] inImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_cd1", length));
			String[] mergeBlNo = (JSPUtil.getParameter(request, prefix	+ "merge_bl_no", length));
			String[] spclCntrSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cntr_seq", length));
			String[] fdrVslNm = (JSPUtil.getParameter(request, prefix	+ "fdr_vsl_nm", length));
			String[] crrDt = (JSPUtil.getParameter(request, prefix	+ "crr_dt", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] cellPsnNo = (JSPUtil.getParameter(request, prefix	+ "cell_psn_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] etdD = (JSPUtil.getParameter(request, prefix	+ "etd_d", length));
			String[] etdT = (JSPUtil.getParameter(request, prefix	+ "etd_t", length));
			
			for (int i = 0; i < length; i++) {
				model = new DgListModiVO();
				if (eurInrPckDesc[i] != null)
					model.setEurInrPckDesc(eurInrPckDesc[i]);
				if (dg[i] != null)
					model.setDg(dg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (emerCntcPsonNm[i] != null)
					model.setEmerCntcPsonNm(emerCntcPsonNm[i]);
				if (stupFlg[i] != null)
					model.setStupFlg(stupFlg[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cgoOprCd[i] != null)
					model.setCgoOprCd(cgoOprCd[i]);
				if (eurPckDesc[i] != null)
					model.setEurPckDesc(eurPckDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (outImdgPckQty1[i] != null)
					model.setOutImdgPckQty1(outImdgPckQty1[i]);
				if (anrSpclTpId[i] != null)
					model.setAnrSpclTpId(anrSpclTpId[i]);
				if (dType[i] != null)
					model.setDType(dType[i]);
				if (outImdgPckCd1[i] != null)
					model.setOutImdgPckCd1(outImdgPckCd1[i]);
				if (hzdDesc[i] != null)
					model.setHzdDesc(hzdDesc[i]);
				if (fdrSvcRqstNo[i] != null)
					model.setFdrSvcRqstNo(fdrSvcRqstNo[i]);
				if (localDbYn[i] != null)
					model.setLocalDbYn(localDbYn[i]);
				if (eurDcgoMrnPolutCd[i] != null)
					model.setEurDcgoMrnPolutCd(eurDcgoMrnPolutCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (dupCntr[i] != null)
					model.setDupCntr(dupCntr[i]);
				if (svcRqstNo[i] != null)
					model.setSvcRqstNo(svcRqstNo[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (etaT[i] != null)
					model.setEtaT(etaT[i]);
				if (spclCgoSeq[i] != null)
					model.setSpclCgoSeq(spclCgoSeq[i]);
				if (emsNo[i] != null)
					model.setEmsNo(emsNo[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (eurOutrPckDesc[i] != null)
					model.setEurOutrPckDesc(eurOutrPckDesc[i]);
				if (fdrVslLloydNo[i] != null)
					model.setFdrVslLloydNo(fdrVslLloydNo[i]);
				if (xtdStayPrmtNo[i] != null)
					model.setXtdStayPrmtNo(xtdStayPrmtNo[i]);
				if (sendType[i] != null)
					model.setSendType(sendType[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (netWgt[i] != null)
					model.setNetWgt(netWgt[i]);
				if (aplyNo[i] != null)
					model.setAplyNo(aplyNo[i]);
				if (brthYdCd[i] != null)
					model.setBrthYdCd(brthYdCd[i]);
				if (eurDgDeclTpCd[i] != null)
					model.setEurDgDeclTpCd(eurDgDeclTpCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (emerCntcPhnNo[i] != null)
					model.setEmerCntcPhnNo(emerCntcPhnNo[i]);
				if (firstMsgSndNo[i] != null)
					model.setFirstMsgSndNo(firstMsgSndNo[i]);
				if (dcgoRefNo[i] != null)
					model.setDcgoRefNo(dcgoRefNo[i]);
				if (netExploWgt[i] != null)
					model.setNetExploWgt(netExploWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (cntrCgoSeq[i] != null)
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (cntrRefNo[i] != null)
					model.setCntrRefNo(cntrRefNo[i]);
				if (imdgLmtQtyFlg[i] != null)
					model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (emerRspnGidNo[i] != null)
					model.setEmerRspnGidNo(emerRspnGidNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (anrRoleDivCd[i] != null)
					model.setAnrRoleDivCd(anrRoleDivCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (msgSndNo[i] != null)
					model.setMsgSndNo(msgSndNo[i]);
				if (etaD[i] != null)
					model.setEtaD(etaD[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (dupCell[i] != null)
					model.setDupCell(dupCell[i]);
				if (anrCrrTpCd[i] != null)
					model.setAnrCrrTpCd(anrCrrTpCd[i]);
				if (imdgCompGrpCd[i] != null)
					model.setImdgCompGrpCd(imdgCompGrpCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (anrFwrdId[i] != null)
					model.setAnrFwrdId(anrFwrdId[i]);
				if (inImdgPckQty1[i] != null)
					model.setInImdgPckQty1(inImdgPckQty1[i]);
				if (imdgSubsRskLblCd2[i] != null)
					model.setImdgSubsRskLblCd2(imdgSubsRskLblCd2[i]);
				if (fdrVvdId[i] != null)
					model.setFdrVvdId(fdrVvdId[i]);
				if (imdgSubsRskLblCd1[i] != null)
					model.setImdgSubsRskLblCd1(imdgSubsRskLblCd1[i]);
				if (hcdgFlg[i] != null)
					model.setHcdgFlg(hcdgFlg[i]);
				if (mfagNo[i] != null)
					model.setMfagNo(mfagNo[i]);
				if (imdgSubsRskLblCd4[i] != null)
					model.setImdgSubsRskLblCd4(imdgSubsRskLblCd4[i]);
				if (flshPntCdoTemp[i] != null)
					model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
				if (cntrNoOld[i] != null)
					model.setCntrNoOld(cntrNoOld[i]);
				if (imdgSubsRskLblCd3[i] != null)
					model.setImdgSubsRskLblCd3(imdgSubsRskLblCd3[i]);
				if (inImdgPckCd1[i] != null)
					model.setInImdgPckCd1(inImdgPckCd1[i]);
				if (mergeBlNo[i] != null)
					model.setMergeBlNo(mergeBlNo[i]);
				if (spclCntrSeq[i] != null)
					model.setSpclCntrSeq(spclCntrSeq[i]);
				if (fdrVslNm[i] != null)
					model.setFdrVslNm(fdrVslNm[i]);
				if (crrDt[i] != null)
					model.setCrrDt(crrDt[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (cellPsnNo[i] != null)
					model.setCellPsnNo(cellPsnNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (etdD[i] != null)
					model.setEtdD(etdD[i]);
				if (etdT[i] != null)
					model.setEtdT(etdT[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDgListModiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DgListModiVO[]
	 */
	public DgListModiVO[] getDgListModiVOs(){
		DgListModiVO[] vos = (DgListModiVO[])models.toArray(new DgListModiVO[models.size()]);
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
		this.eurInrPckDesc = this.eurInrPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg = this.dg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerCntcPsonNm = this.emerCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stupFlg = this.stupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoOprCd = this.cgoOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurPckDesc = this.eurPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckQty1 = this.outImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrSpclTpId = this.anrSpclTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dType = this.dType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckCd1 = this.outImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdDesc = this.hzdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrSvcRqstNo = this.fdrSvcRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localDbYn = this.localDbYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurDcgoMrnPolutCd = this.eurDcgoMrnPolutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupCntr = this.dupCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcRqstNo = this.svcRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaT = this.etaT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoSeq = this.spclCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsNo = this.emsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurOutrPckDesc = this.eurOutrPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVslLloydNo = this.fdrVslLloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xtdStayPrmtNo = this.xtdStayPrmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendType = this.sendType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyNo = this.aplyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brthYdCd = this.brthYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurDgDeclTpCd = this.eurDgDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerCntcPhnNo = this.emerCntcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstMsgSndNo = this.firstMsgSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoRefNo = this.dcgoRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netExploWgt = this.netExploWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRefNo = this.cntrRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyFlg = this.imdgLmtQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerRspnGidNo = this.emerRspnGidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrRoleDivCd = this.anrRoleDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndNo = this.msgSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaD = this.etaD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupCell = this.dupCell .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrCrrTpCd = this.anrCrrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCompGrpCd = this.imdgCompGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrFwrdId = this.anrFwrdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckQty1 = this.inImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd2 = this.imdgSubsRskLblCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVvdId = this.fdrVvdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd1 = this.imdgSubsRskLblCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdgFlg = this.hcdgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfagNo = this.mfagNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd4 = this.imdgSubsRskLblCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntCdoTemp = this.flshPntCdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNoOld = this.cntrNoOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd3 = this.imdgSubsRskLblCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckCd1 = this.inImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mergeBlNo = this.mergeBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCntrSeq = this.spclCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVslNm = this.fdrVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrDt = this.crrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cellPsnNo = this.cellPsnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdT = this.etdT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdD = this.etdD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
