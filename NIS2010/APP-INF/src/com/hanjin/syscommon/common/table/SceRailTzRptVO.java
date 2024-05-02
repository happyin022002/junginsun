/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SceRailTzRptVO.java
*@FileTitle : SceRailTzRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SceRailTzRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SceRailTzRptVO> models = new ArrayList<SceRailTzRptVO>();
	
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String destAvalDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dwllRsnLocNm = null;
	/* Column Info */
	private String itchgArrSplcLocNm = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String ibdCstmsClrLocCd = null;
	/* Column Info */
	private String mstBlNo = null;
	/* Column Info */
	private String orgGateInDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String woIssDt = null;
	/* Column Info */
	private String amsUpdDt = null;
	/* Column Info */
	private String cgorOrgBlRcvrIndFlg = null;
	/* Column Info */
	private String itchgN1stDwllTmHrs = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rptUpdStsCd = null;
	/* Column Info */
	private String usaEdiCd = null;
	/* Column Info */
	private String orgGateOutDt = null;
	/* Column Info */
	private String railItchgN2ndEtaDt = null;
	/* Column Info */
	private String cstmsAcptFlg = null;
	/* Column Info */
	private String itchgHrs = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String arrDt = null;
	/* Column Info */
	private String orgDepFlg = null;
	/* Column Info */
	private String woVndrSeq = null;
	/* Column Info */
	private String itchgN1stDepFlg = null;
	/* Column Info */
	private String clmSghtCd = null;
	/* Column Info */
	private String lstFreeDt = null;
	/* Column Info */
	private String arrSplcCd = null;
	/* Column Info */
	private String dwllHrs = null;
	/* Column Info */
	private String railCoDestPntEtaDt = null;
	/* Column Info */
	private String destN2ndDwllTmHrs = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String preDwllRmk = null;
	/* Column Info */
	private String destN2ndDepFlg = null;
	/* Column Info */
	private String crntDwllRmk = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String itchgSplcLocNm = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String cgorFrtPayIndFlg = null;
	/* Column Info */
	private String destGateOutDt = null;
	/* Column Info */
	private String railItchgN1stEtdDt = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String railItchgN2ndEtdDt = null;
	/* Column Info */
	private String railItchgN1stEtaDt = null;
	/* Column Info */
	private String fcarNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String ibIpiLoclIndCd = null;
	/* Column Info */
	private String itchgGateInDt = null;
	/* Column Info */
	private String railTztmHrs = null;
	/* Column Info */
	private String crntDwllTmHrs = null;
	/* Column Info */
	private String orgDwllTmHrs = null;
	/* Column Info */
	private String soCreDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String arrSteCd = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String railDestN2ndEtaDt = null;
	/* Column Info */
	private String arrLocNm = null;
	/* Column Info */
	private String tztmDiffHrs = null;
	/* Column Info */
	private String itchgN2ndDwllTmHrs = null;
	/* Column Info */
	private String itchgDt = null;
	/* Column Info */
	private String tmlDwllTmHrs = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String bkgHotDeFlg = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String orgSplcLocNm = null;
	/* Column Info */
	private String itchgGateOutDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String copExptNo = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String railCoItchgPntEtaDt = null;
	/* Column Info */
	private String crntDwllRmkUpdDt = null;
	/* Column Info */
	private String tmlDepFlg = null;
	/* Column Info */
	private String copExptTpCd = null;
	/* Column Info */
	private String preDwllRmkUpdDt = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String railDestN1stEtaDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String avalFlg = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String vdDt = null;
	/* Column Info */
	private String itchgN2ndDepFlg = null;
	/* Column Info */
	private String railRunTmHrs = null;
	/* Column Info */
	private String destN1stDwllTmHrs = null;
	/* Column Info */
	private String orgGateOutUpdFlg = null;
	/* Column Info */
	private String trnNo = null;
	/* Column Info */
	private String hldRmk = null;
	/* Column Info */
	private String avgTzHrs = null;
	/* Column Info */
	private String destGateInDt = null;
	/* Column Info */
	private String destN1stDepFlg = null;
	/* Column Info */
	private String destLocNm = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String hldFlg = null;
	/* Column Info */
	private String orgGateInUpdFlg = null;
	/* Column Info */
	private String copExptStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SceRailTzRptVO() {}

	public SceRailTzRptVO(String ibflag, String pagerows, String trspSoOfcCtyCd, String trspSoSeq, String eqNo, String eqTpszCd, String cgoTpCd, String vvdCd, String bkgNo, String mstBlNo, String scNo, String destAvalDt, String soCreDt, String woIssDt, String usaEdiCd, String fmNodCd, String toNodCd, String trspBndCd, String bkgHotDeFlg, String cstmsAcptFlg, String amsUpdDt, String ibIpiLoclIndCd, String ibdCstmsClrLocCd, String nodCd, String vdDt, String hldFlg, String hldRmk, String tmlDwllTmHrs, String tmlDepFlg, String orgSplcLocNm, String orgGateInDt, String orgDwllTmHrs, String orgDepFlg, String orgGateOutDt, String itchgArrSplcLocNm, String itchgGateInDt, String itchgN1stDwllTmHrs, String itchgN1stDepFlg, String itchgSplcLocNm, String itchgDt, String itchgN2ndDwllTmHrs, String itchgN2ndDepFlg, String itchgGateOutDt, String destLocNm, String destGateInDt, String destN1stDwllTmHrs, String destN1stDepFlg, String destN2ndDwllTmHrs, String destN2ndDepFlg, String destGateOutDt, String railRunTmHrs, String railTztmHrs, String arrLocNm, String arrSteCd, String arrDt, String crntDwllTmHrs, String trnNo, String fcarNo, String cntrSealNo, String itchgHrs, String railItchgN1stEtaDt, String railItchgN2ndEtaDt, String dwllHrs, String railItchgN1stEtdDt, String railItchgN2ndEtdDt, String avgTzHrs, String railDestN1stEtaDt, String railDestN2ndEtaDt, String tztmDiffHrs, String shprNm, String cneeNm, String ntfyNm, String copExptTpCd, String copExptStsCd, String copExptNo, String rptUpdStsCd, String copNo, String lstFreeDt, String arrSplcCd, String clmSghtCd, String woVndrSeq, String costActGrpSeq, String railCoItchgPntEtaDt, String railCoDestPntEtaDt, String cgorFrtPayIndFlg, String cgorOrgBlRcvrIndFlg, String orgGateOutUpdFlg, String eqKndCd, String orgGateInUpdFlg, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String crntDwllRmk, String preDwllRmk, String crntDwllRmkUpdDt, String preDwllRmkUpdDt, String dwllRsnLocNm, String avalFlg) {
		this.cgoTpCd = cgoTpCd;
		this.destAvalDt = destAvalDt;
		this.pagerows = pagerows;
		this.dwllRsnLocNm = dwllRsnLocNm;
		this.itchgArrSplcLocNm = itchgArrSplcLocNm;
		this.vvdCd = vvdCd;
		this.ibdCstmsClrLocCd = ibdCstmsClrLocCd;
		this.mstBlNo = mstBlNo;
		this.orgGateInDt = orgGateInDt;
		this.updUsrId = updUsrId;
		this.woIssDt = woIssDt;
		this.amsUpdDt = amsUpdDt;
		this.cgorOrgBlRcvrIndFlg = cgorOrgBlRcvrIndFlg;
		this.itchgN1stDwllTmHrs = itchgN1stDwllTmHrs;
		this.eqTpszCd = eqTpszCd;
		this.bkgNo = bkgNo;
		this.rptUpdStsCd = rptUpdStsCd;
		this.usaEdiCd = usaEdiCd;
		this.orgGateOutDt = orgGateOutDt;
		this.railItchgN2ndEtaDt = railItchgN2ndEtaDt;
		this.cstmsAcptFlg = cstmsAcptFlg;
		this.itchgHrs = itchgHrs;
		this.deltFlg = deltFlg;
		this.arrDt = arrDt;
		this.orgDepFlg = orgDepFlg;
		this.woVndrSeq = woVndrSeq;
		this.itchgN1stDepFlg = itchgN1stDepFlg;
		this.clmSghtCd = clmSghtCd;
		this.lstFreeDt = lstFreeDt;
		this.arrSplcCd = arrSplcCd;
		this.dwllHrs = dwllHrs;
		this.railCoDestPntEtaDt = railCoDestPntEtaDt;
		this.destN2ndDwllTmHrs = destN2ndDwllTmHrs;
		this.eqKndCd = eqKndCd;
		this.preDwllRmk = preDwllRmk;
		this.destN2ndDepFlg = destN2ndDepFlg;
		this.crntDwllRmk = crntDwllRmk;
		this.ntfyNm = ntfyNm;
		this.itchgSplcLocNm = itchgSplcLocNm;
		this.fmNodCd = fmNodCd;
		this.cneeNm = cneeNm;
		this.costActGrpSeq = costActGrpSeq;
		this.cgorFrtPayIndFlg = cgorFrtPayIndFlg;
		this.destGateOutDt = destGateOutDt;
		this.railItchgN1stEtdDt = railItchgN1stEtdDt;
		this.toNodCd = toNodCd;
		this.trspSoSeq = trspSoSeq;
		this.copNo = copNo;
		this.railItchgN2ndEtdDt = railItchgN2ndEtdDt;
		this.railItchgN1stEtaDt = railItchgN1stEtaDt;
		this.fcarNo = fcarNo;
		this.scNo = scNo;
		this.ibIpiLoclIndCd = ibIpiLoclIndCd;
		this.itchgGateInDt = itchgGateInDt;
		this.railTztmHrs = railTztmHrs;
		this.crntDwllTmHrs = crntDwllTmHrs;
		this.orgDwllTmHrs = orgDwllTmHrs;
		this.soCreDt = soCreDt;
		this.creUsrId = creUsrId;
		this.arrSteCd = arrSteCd;
		this.nodCd = nodCd;
		this.railDestN2ndEtaDt = railDestN2ndEtaDt;
		this.arrLocNm = arrLocNm;
		this.tztmDiffHrs = tztmDiffHrs;
		this.itchgN2ndDwllTmHrs = itchgN2ndDwllTmHrs;
		this.itchgDt = itchgDt;
		this.tmlDwllTmHrs = tmlDwllTmHrs;
		this.creDt = creDt;
		this.bkgHotDeFlg = bkgHotDeFlg;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.orgSplcLocNm = orgSplcLocNm;
		this.itchgGateOutDt = itchgGateOutDt;
		this.ibflag = ibflag;
		this.copExptNo = copExptNo;
		this.eqNo = eqNo;
		this.railCoItchgPntEtaDt = railCoItchgPntEtaDt;
		this.crntDwllRmkUpdDt = crntDwllRmkUpdDt;
		this.tmlDepFlg = tmlDepFlg;
		this.copExptTpCd = copExptTpCd;
		this.preDwllRmkUpdDt = preDwllRmkUpdDt;
		this.shprNm = shprNm;
		this.railDestN1stEtaDt = railDestN1stEtaDt;
		this.updDt = updDt;
		this.avalFlg = avalFlg;
		this.trspBndCd = trspBndCd;
		this.vdDt = vdDt;
		this.itchgN2ndDepFlg = itchgN2ndDepFlg;
		this.railRunTmHrs = railRunTmHrs;
		this.destN1stDwllTmHrs = destN1stDwllTmHrs;
		this.orgGateOutUpdFlg = orgGateOutUpdFlg;
		this.trnNo = trnNo;
		this.hldRmk = hldRmk;
		this.avgTzHrs = avgTzHrs;
		this.destGateInDt = destGateInDt;
		this.destN1stDepFlg = destN1stDepFlg;
		this.destLocNm = destLocNm;
		this.cntrSealNo = cntrSealNo;
		this.hldFlg = hldFlg;
		this.orgGateInUpdFlg = orgGateInUpdFlg;
		this.copExptStsCd = copExptStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("dest_aval_dt", getDestAvalDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dwll_rsn_loc_nm", getDwllRsnLocNm());
		this.hashColumns.put("itchg_arr_splc_loc_nm", getItchgArrSplcLocNm());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("ibd_cstms_clr_loc_cd", getIbdCstmsClrLocCd());
		this.hashColumns.put("mst_bl_no", getMstBlNo());
		this.hashColumns.put("org_gate_in_dt", getOrgGateInDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("wo_iss_dt", getWoIssDt());
		this.hashColumns.put("ams_upd_dt", getAmsUpdDt());
		this.hashColumns.put("cgor_org_bl_rcvr_ind_flg", getCgorOrgBlRcvrIndFlg());
		this.hashColumns.put("itchg_n1st_dwll_tm_hrs", getItchgN1stDwllTmHrs());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rpt_upd_sts_cd", getRptUpdStsCd());
		this.hashColumns.put("usa_edi_cd", getUsaEdiCd());
		this.hashColumns.put("org_gate_out_dt", getOrgGateOutDt());
		this.hashColumns.put("rail_itchg_n2nd_eta_dt", getRailItchgN2ndEtaDt());
		this.hashColumns.put("cstms_acpt_flg", getCstmsAcptFlg());
		this.hashColumns.put("itchg_hrs", getItchgHrs());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("arr_dt", getArrDt());
		this.hashColumns.put("org_dep_flg", getOrgDepFlg());
		this.hashColumns.put("wo_vndr_seq", getWoVndrSeq());
		this.hashColumns.put("itchg_n1st_dep_flg", getItchgN1stDepFlg());
		this.hashColumns.put("clm_sght_cd", getClmSghtCd());
		this.hashColumns.put("lst_free_dt", getLstFreeDt());
		this.hashColumns.put("arr_splc_cd", getArrSplcCd());
		this.hashColumns.put("dwll_hrs", getDwllHrs());
		this.hashColumns.put("rail_co_dest_pnt_eta_dt", getRailCoDestPntEtaDt());
		this.hashColumns.put("dest_n2nd_dwll_tm_hrs", getDestN2ndDwllTmHrs());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pre_dwll_rmk", getPreDwllRmk());
		this.hashColumns.put("dest_n2nd_dep_flg", getDestN2ndDepFlg());
		this.hashColumns.put("crnt_dwll_rmk", getCrntDwllRmk());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("itchg_splc_loc_nm", getItchgSplcLocNm());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("cgor_frt_pay_ind_flg", getCgorFrtPayIndFlg());
		this.hashColumns.put("dest_gate_out_dt", getDestGateOutDt());
		this.hashColumns.put("rail_itchg_n1st_etd_dt", getRailItchgN1stEtdDt());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("rail_itchg_n2nd_etd_dt", getRailItchgN2ndEtdDt());
		this.hashColumns.put("rail_itchg_n1st_eta_dt", getRailItchgN1stEtaDt());
		this.hashColumns.put("fcar_no", getFcarNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ib_ipi_locl_ind_cd", getIbIpiLoclIndCd());
		this.hashColumns.put("itchg_gate_in_dt", getItchgGateInDt());
		this.hashColumns.put("rail_tztm_hrs", getRailTztmHrs());
		this.hashColumns.put("crnt_dwll_tm_hrs", getCrntDwllTmHrs());
		this.hashColumns.put("org_dwll_tm_hrs", getOrgDwllTmHrs());
		this.hashColumns.put("so_cre_dt", getSoCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("arr_ste_cd", getArrSteCd());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("rail_dest_n2nd_eta_dt", getRailDestN2ndEtaDt());
		this.hashColumns.put("arr_loc_nm", getArrLocNm());
		this.hashColumns.put("tztm_diff_hrs", getTztmDiffHrs());
		this.hashColumns.put("itchg_n2nd_dwll_tm_hrs", getItchgN2ndDwllTmHrs());
		this.hashColumns.put("itchg_dt", getItchgDt());
		this.hashColumns.put("tml_dwll_tm_hrs", getTmlDwllTmHrs());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bkg_hot_de_flg", getBkgHotDeFlg());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("org_splc_loc_nm", getOrgSplcLocNm());
		this.hashColumns.put("itchg_gate_out_dt", getItchgGateOutDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cop_expt_no", getCopExptNo());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("rail_co_itchg_pnt_eta_dt", getRailCoItchgPntEtaDt());
		this.hashColumns.put("crnt_dwll_rmk_upd_dt", getCrntDwllRmkUpdDt());
		this.hashColumns.put("tml_dep_flg", getTmlDepFlg());
		this.hashColumns.put("cop_expt_tp_cd", getCopExptTpCd());
		this.hashColumns.put("pre_dwll_rmk_upd_dt", getPreDwllRmkUpdDt());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("rail_dest_n1st_eta_dt", getRailDestN1stEtaDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("aval_flg", getAvalFlg());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("vd_dt", getVdDt());
		this.hashColumns.put("itchg_n2nd_dep_flg", getItchgN2ndDepFlg());
		this.hashColumns.put("rail_run_tm_hrs", getRailRunTmHrs());
		this.hashColumns.put("dest_n1st_dwll_tm_hrs", getDestN1stDwllTmHrs());
		this.hashColumns.put("org_gate_out_upd_flg", getOrgGateOutUpdFlg());
		this.hashColumns.put("trn_no", getTrnNo());
		this.hashColumns.put("hld_rmk", getHldRmk());
		this.hashColumns.put("avg_tz_hrs", getAvgTzHrs());
		this.hashColumns.put("dest_gate_in_dt", getDestGateInDt());
		this.hashColumns.put("dest_n1st_dep_flg", getDestN1stDepFlg());
		this.hashColumns.put("dest_loc_nm", getDestLocNm());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("hld_flg", getHldFlg());
		this.hashColumns.put("org_gate_in_upd_flg", getOrgGateInUpdFlg());
		this.hashColumns.put("cop_expt_sts_cd", getCopExptStsCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("dest_aval_dt", "destAvalDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dwll_rsn_loc_nm", "dwllRsnLocNm");
		this.hashFields.put("itchg_arr_splc_loc_nm", "itchgArrSplcLocNm");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("ibd_cstms_clr_loc_cd", "ibdCstmsClrLocCd");
		this.hashFields.put("mst_bl_no", "mstBlNo");
		this.hashFields.put("org_gate_in_dt", "orgGateInDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("wo_iss_dt", "woIssDt");
		this.hashFields.put("ams_upd_dt", "amsUpdDt");
		this.hashFields.put("cgor_org_bl_rcvr_ind_flg", "cgorOrgBlRcvrIndFlg");
		this.hashFields.put("itchg_n1st_dwll_tm_hrs", "itchgN1stDwllTmHrs");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rpt_upd_sts_cd", "rptUpdStsCd");
		this.hashFields.put("usa_edi_cd", "usaEdiCd");
		this.hashFields.put("org_gate_out_dt", "orgGateOutDt");
		this.hashFields.put("rail_itchg_n2nd_eta_dt", "railItchgN2ndEtaDt");
		this.hashFields.put("cstms_acpt_flg", "cstmsAcptFlg");
		this.hashFields.put("itchg_hrs", "itchgHrs");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("arr_dt", "arrDt");
		this.hashFields.put("org_dep_flg", "orgDepFlg");
		this.hashFields.put("wo_vndr_seq", "woVndrSeq");
		this.hashFields.put("itchg_n1st_dep_flg", "itchgN1stDepFlg");
		this.hashFields.put("clm_sght_cd", "clmSghtCd");
		this.hashFields.put("lst_free_dt", "lstFreeDt");
		this.hashFields.put("arr_splc_cd", "arrSplcCd");
		this.hashFields.put("dwll_hrs", "dwllHrs");
		this.hashFields.put("rail_co_dest_pnt_eta_dt", "railCoDestPntEtaDt");
		this.hashFields.put("dest_n2nd_dwll_tm_hrs", "destN2ndDwllTmHrs");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pre_dwll_rmk", "preDwllRmk");
		this.hashFields.put("dest_n2nd_dep_flg", "destN2ndDepFlg");
		this.hashFields.put("crnt_dwll_rmk", "crntDwllRmk");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("itchg_splc_loc_nm", "itchgSplcLocNm");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("cgor_frt_pay_ind_flg", "cgorFrtPayIndFlg");
		this.hashFields.put("dest_gate_out_dt", "destGateOutDt");
		this.hashFields.put("rail_itchg_n1st_etd_dt", "railItchgN1stEtdDt");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("rail_itchg_n2nd_etd_dt", "railItchgN2ndEtdDt");
		this.hashFields.put("rail_itchg_n1st_eta_dt", "railItchgN1stEtaDt");
		this.hashFields.put("fcar_no", "fcarNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ib_ipi_locl_ind_cd", "ibIpiLoclIndCd");
		this.hashFields.put("itchg_gate_in_dt", "itchgGateInDt");
		this.hashFields.put("rail_tztm_hrs", "railTztmHrs");
		this.hashFields.put("crnt_dwll_tm_hrs", "crntDwllTmHrs");
		this.hashFields.put("org_dwll_tm_hrs", "orgDwllTmHrs");
		this.hashFields.put("so_cre_dt", "soCreDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("arr_ste_cd", "arrSteCd");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("rail_dest_n2nd_eta_dt", "railDestN2ndEtaDt");
		this.hashFields.put("arr_loc_nm", "arrLocNm");
		this.hashFields.put("tztm_diff_hrs", "tztmDiffHrs");
		this.hashFields.put("itchg_n2nd_dwll_tm_hrs", "itchgN2ndDwllTmHrs");
		this.hashFields.put("itchg_dt", "itchgDt");
		this.hashFields.put("tml_dwll_tm_hrs", "tmlDwllTmHrs");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bkg_hot_de_flg", "bkgHotDeFlg");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("org_splc_loc_nm", "orgSplcLocNm");
		this.hashFields.put("itchg_gate_out_dt", "itchgGateOutDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cop_expt_no", "copExptNo");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("rail_co_itchg_pnt_eta_dt", "railCoItchgPntEtaDt");
		this.hashFields.put("crnt_dwll_rmk_upd_dt", "crntDwllRmkUpdDt");
		this.hashFields.put("tml_dep_flg", "tmlDepFlg");
		this.hashFields.put("cop_expt_tp_cd", "copExptTpCd");
		this.hashFields.put("pre_dwll_rmk_upd_dt", "preDwllRmkUpdDt");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("rail_dest_n1st_eta_dt", "railDestN1stEtaDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("aval_flg", "avalFlg");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("vd_dt", "vdDt");
		this.hashFields.put("itchg_n2nd_dep_flg", "itchgN2ndDepFlg");
		this.hashFields.put("rail_run_tm_hrs", "railRunTmHrs");
		this.hashFields.put("dest_n1st_dwll_tm_hrs", "destN1stDwllTmHrs");
		this.hashFields.put("org_gate_out_upd_flg", "orgGateOutUpdFlg");
		this.hashFields.put("trn_no", "trnNo");
		this.hashFields.put("hld_rmk", "hldRmk");
		this.hashFields.put("avg_tz_hrs", "avgTzHrs");
		this.hashFields.put("dest_gate_in_dt", "destGateInDt");
		this.hashFields.put("dest_n1st_dep_flg", "destN1stDepFlg");
		this.hashFields.put("dest_loc_nm", "destLocNm");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("hld_flg", "hldFlg");
		this.hashFields.put("org_gate_in_upd_flg", "orgGateInUpdFlg");
		this.hashFields.put("cop_expt_sts_cd", "copExptStsCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return destAvalDt
	 */
	public String getDestAvalDt() {
		return this.destAvalDt;
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
	 * @return dwllRsnLocNm
	 */
	public String getDwllRsnLocNm() {
		return this.dwllRsnLocNm;
	}
	
	/**
	 * Column Info
	 * @return itchgArrSplcLocNm
	 */
	public String getItchgArrSplcLocNm() {
		return this.itchgArrSplcLocNm;
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
	 * @return ibdCstmsClrLocCd
	 */
	public String getIbdCstmsClrLocCd() {
		return this.ibdCstmsClrLocCd;
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
	 * @return orgGateInDt
	 */
	public String getOrgGateInDt() {
		return this.orgGateInDt;
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
	 * @return woIssDt
	 */
	public String getWoIssDt() {
		return this.woIssDt;
	}
	
	/**
	 * Column Info
	 * @return amsUpdDt
	 */
	public String getAmsUpdDt() {
		return this.amsUpdDt;
	}
	
	/**
	 * Column Info
	 * @return cgorOrgBlRcvrIndFlg
	 */
	public String getCgorOrgBlRcvrIndFlg() {
		return this.cgorOrgBlRcvrIndFlg;
	}
	
	/**
	 * Column Info
	 * @return itchgN1stDwllTmHrs
	 */
	public String getItchgN1stDwllTmHrs() {
		return this.itchgN1stDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return rptUpdStsCd
	 */
	public String getRptUpdStsCd() {
		return this.rptUpdStsCd;
	}
	
	/**
	 * Column Info
	 * @return usaEdiCd
	 */
	public String getUsaEdiCd() {
		return this.usaEdiCd;
	}
	
	/**
	 * Column Info
	 * @return orgGateOutDt
	 */
	public String getOrgGateOutDt() {
		return this.orgGateOutDt;
	}
	
	/**
	 * Column Info
	 * @return railItchgN2ndEtaDt
	 */
	public String getRailItchgN2ndEtaDt() {
		return this.railItchgN2ndEtaDt;
	}
	
	/**
	 * Column Info
	 * @return cstmsAcptFlg
	 */
	public String getCstmsAcptFlg() {
		return this.cstmsAcptFlg;
	}
	
	/**
	 * Column Info
	 * @return itchgHrs
	 */
	public String getItchgHrs() {
		return this.itchgHrs;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return arrDt
	 */
	public String getArrDt() {
		return this.arrDt;
	}
	
	/**
	 * Column Info
	 * @return orgDepFlg
	 */
	public String getOrgDepFlg() {
		return this.orgDepFlg;
	}
	
	/**
	 * Column Info
	 * @return woVndrSeq
	 */
	public String getWoVndrSeq() {
		return this.woVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return itchgN1stDepFlg
	 */
	public String getItchgN1stDepFlg() {
		return this.itchgN1stDepFlg;
	}
	
	/**
	 * Column Info
	 * @return clmSghtCd
	 */
	public String getClmSghtCd() {
		return this.clmSghtCd;
	}
	
	/**
	 * Column Info
	 * @return lstFreeDt
	 */
	public String getLstFreeDt() {
		return this.lstFreeDt;
	}
	
	/**
	 * Column Info
	 * @return arrSplcCd
	 */
	public String getArrSplcCd() {
		return this.arrSplcCd;
	}
	
	/**
	 * Column Info
	 * @return dwllHrs
	 */
	public String getDwllHrs() {
		return this.dwllHrs;
	}
	
	/**
	 * Column Info
	 * @return railCoDestPntEtaDt
	 */
	public String getRailCoDestPntEtaDt() {
		return this.railCoDestPntEtaDt;
	}
	
	/**
	 * Column Info
	 * @return destN2ndDwllTmHrs
	 */
	public String getDestN2ndDwllTmHrs() {
		return this.destN2ndDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return preDwllRmk
	 */
	public String getPreDwllRmk() {
		return this.preDwllRmk;
	}
	
	/**
	 * Column Info
	 * @return destN2ndDepFlg
	 */
	public String getDestN2ndDepFlg() {
		return this.destN2ndDepFlg;
	}
	
	/**
	 * Column Info
	 * @return crntDwllRmk
	 */
	public String getCrntDwllRmk() {
		return this.crntDwllRmk;
	}
	
	/**
	 * Column Info
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
	}
	
	/**
	 * Column Info
	 * @return itchgSplcLocNm
	 */
	public String getItchgSplcLocNm() {
		return this.itchgSplcLocNm;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return costActGrpSeq
	 */
	public String getCostActGrpSeq() {
		return this.costActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return cgorFrtPayIndFlg
	 */
	public String getCgorFrtPayIndFlg() {
		return this.cgorFrtPayIndFlg;
	}
	
	/**
	 * Column Info
	 * @return destGateOutDt
	 */
	public String getDestGateOutDt() {
		return this.destGateOutDt;
	}
	
	/**
	 * Column Info
	 * @return railItchgN1stEtdDt
	 */
	public String getRailItchgN1stEtdDt() {
		return this.railItchgN1stEtdDt;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return railItchgN2ndEtdDt
	 */
	public String getRailItchgN2ndEtdDt() {
		return this.railItchgN2ndEtdDt;
	}
	
	/**
	 * Column Info
	 * @return railItchgN1stEtaDt
	 */
	public String getRailItchgN1stEtaDt() {
		return this.railItchgN1stEtaDt;
	}
	
	/**
	 * Column Info
	 * @return fcarNo
	 */
	public String getFcarNo() {
		return this.fcarNo;
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
	 * @return ibIpiLoclIndCd
	 */
	public String getIbIpiLoclIndCd() {
		return this.ibIpiLoclIndCd;
	}
	
	/**
	 * Column Info
	 * @return itchgGateInDt
	 */
	public String getItchgGateInDt() {
		return this.itchgGateInDt;
	}
	
	/**
	 * Column Info
	 * @return railTztmHrs
	 */
	public String getRailTztmHrs() {
		return this.railTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return crntDwllTmHrs
	 */
	public String getCrntDwllTmHrs() {
		return this.crntDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @return orgDwllTmHrs
	 */
	public String getOrgDwllTmHrs() {
		return this.orgDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @return soCreDt
	 */
	public String getSoCreDt() {
		return this.soCreDt;
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
	 * @return arrSteCd
	 */
	public String getArrSteCd() {
		return this.arrSteCd;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return railDestN2ndEtaDt
	 */
	public String getRailDestN2ndEtaDt() {
		return this.railDestN2ndEtaDt;
	}
	
	/**
	 * Column Info
	 * @return arrLocNm
	 */
	public String getArrLocNm() {
		return this.arrLocNm;
	}
	
	/**
	 * Column Info
	 * @return tztmDiffHrs
	 */
	public String getTztmDiffHrs() {
		return this.tztmDiffHrs;
	}
	
	/**
	 * Column Info
	 * @return itchgN2ndDwllTmHrs
	 */
	public String getItchgN2ndDwllTmHrs() {
		return this.itchgN2ndDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @return itchgDt
	 */
	public String getItchgDt() {
		return this.itchgDt;
	}
	
	/**
	 * Column Info
	 * @return tmlDwllTmHrs
	 */
	public String getTmlDwllTmHrs() {
		return this.tmlDwllTmHrs;
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
	 * @return bkgHotDeFlg
	 */
	public String getBkgHotDeFlg() {
		return this.bkgHotDeFlg;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return orgSplcLocNm
	 */
	public String getOrgSplcLocNm() {
		return this.orgSplcLocNm;
	}
	
	/**
	 * Column Info
	 * @return itchgGateOutDt
	 */
	public String getItchgGateOutDt() {
		return this.itchgGateOutDt;
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
	 * @return copExptNo
	 */
	public String getCopExptNo() {
		return this.copExptNo;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return railCoItchgPntEtaDt
	 */
	public String getRailCoItchgPntEtaDt() {
		return this.railCoItchgPntEtaDt;
	}
	
	/**
	 * Column Info
	 * @return crntDwllRmkUpdDt
	 */
	public String getCrntDwllRmkUpdDt() {
		return this.crntDwllRmkUpdDt;
	}
	
	/**
	 * Column Info
	 * @return tmlDepFlg
	 */
	public String getTmlDepFlg() {
		return this.tmlDepFlg;
	}
	
	/**
	 * Column Info
	 * @return copExptTpCd
	 */
	public String getCopExptTpCd() {
		return this.copExptTpCd;
	}
	
	/**
	 * Column Info
	 * @return preDwllRmkUpdDt
	 */
	public String getPreDwllRmkUpdDt() {
		return this.preDwllRmkUpdDt;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return railDestN1stEtaDt
	 */
	public String getRailDestN1stEtaDt() {
		return this.railDestN1stEtaDt;
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
	 * @return avalFlg
	 */
	public String getAvalFlg() {
		return this.avalFlg;
	}
	
	/**
	 * Column Info
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}
	
	/**
	 * Column Info
	 * @return vdDt
	 */
	public String getVdDt() {
		return this.vdDt;
	}
	
	/**
	 * Column Info
	 * @return itchgN2ndDepFlg
	 */
	public String getItchgN2ndDepFlg() {
		return this.itchgN2ndDepFlg;
	}
	
	/**
	 * Column Info
	 * @return railRunTmHrs
	 */
	public String getRailRunTmHrs() {
		return this.railRunTmHrs;
	}
	
	/**
	 * Column Info
	 * @return destN1stDwllTmHrs
	 */
	public String getDestN1stDwllTmHrs() {
		return this.destN1stDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @return orgGateOutUpdFlg
	 */
	public String getOrgGateOutUpdFlg() {
		return this.orgGateOutUpdFlg;
	}
	
	/**
	 * Column Info
	 * @return trnNo
	 */
	public String getTrnNo() {
		return this.trnNo;
	}
	
	/**
	 * Column Info
	 * @return hldRmk
	 */
	public String getHldRmk() {
		return this.hldRmk;
	}
	
	/**
	 * Column Info
	 * @return avgTzHrs
	 */
	public String getAvgTzHrs() {
		return this.avgTzHrs;
	}
	
	/**
	 * Column Info
	 * @return destGateInDt
	 */
	public String getDestGateInDt() {
		return this.destGateInDt;
	}
	
	/**
	 * Column Info
	 * @return destN1stDepFlg
	 */
	public String getDestN1stDepFlg() {
		return this.destN1stDepFlg;
	}
	
	/**
	 * Column Info
	 * @return destLocNm
	 */
	public String getDestLocNm() {
		return this.destLocNm;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return hldFlg
	 */
	public String getHldFlg() {
		return this.hldFlg;
	}
	
	/**
	 * Column Info
	 * @return orgGateInUpdFlg
	 */
	public String getOrgGateInUpdFlg() {
		return this.orgGateInUpdFlg;
	}
	
	/**
	 * Column Info
	 * @return copExptStsCd
	 */
	public String getCopExptStsCd() {
		return this.copExptStsCd;
	}
	

	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param destAvalDt
	 */
	public void setDestAvalDt(String destAvalDt) {
		this.destAvalDt = destAvalDt;
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
	 * @param dwllRsnLocNm
	 */
	public void setDwllRsnLocNm(String dwllRsnLocNm) {
		this.dwllRsnLocNm = dwllRsnLocNm;
	}
	
	/**
	 * Column Info
	 * @param itchgArrSplcLocNm
	 */
	public void setItchgArrSplcLocNm(String itchgArrSplcLocNm) {
		this.itchgArrSplcLocNm = itchgArrSplcLocNm;
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
	 * @param ibdCstmsClrLocCd
	 */
	public void setIbdCstmsClrLocCd(String ibdCstmsClrLocCd) {
		this.ibdCstmsClrLocCd = ibdCstmsClrLocCd;
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
	 * @param orgGateInDt
	 */
	public void setOrgGateInDt(String orgGateInDt) {
		this.orgGateInDt = orgGateInDt;
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
	 * @param woIssDt
	 */
	public void setWoIssDt(String woIssDt) {
		this.woIssDt = woIssDt;
	}
	
	/**
	 * Column Info
	 * @param amsUpdDt
	 */
	public void setAmsUpdDt(String amsUpdDt) {
		this.amsUpdDt = amsUpdDt;
	}
	
	/**
	 * Column Info
	 * @param cgorOrgBlRcvrIndFlg
	 */
	public void setCgorOrgBlRcvrIndFlg(String cgorOrgBlRcvrIndFlg) {
		this.cgorOrgBlRcvrIndFlg = cgorOrgBlRcvrIndFlg;
	}
	
	/**
	 * Column Info
	 * @param itchgN1stDwllTmHrs
	 */
	public void setItchgN1stDwllTmHrs(String itchgN1stDwllTmHrs) {
		this.itchgN1stDwllTmHrs = itchgN1stDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param rptUpdStsCd
	 */
	public void setRptUpdStsCd(String rptUpdStsCd) {
		this.rptUpdStsCd = rptUpdStsCd;
	}
	
	/**
	 * Column Info
	 * @param usaEdiCd
	 */
	public void setUsaEdiCd(String usaEdiCd) {
		this.usaEdiCd = usaEdiCd;
	}
	
	/**
	 * Column Info
	 * @param orgGateOutDt
	 */
	public void setOrgGateOutDt(String orgGateOutDt) {
		this.orgGateOutDt = orgGateOutDt;
	}
	
	/**
	 * Column Info
	 * @param railItchgN2ndEtaDt
	 */
	public void setRailItchgN2ndEtaDt(String railItchgN2ndEtaDt) {
		this.railItchgN2ndEtaDt = railItchgN2ndEtaDt;
	}
	
	/**
	 * Column Info
	 * @param cstmsAcptFlg
	 */
	public void setCstmsAcptFlg(String cstmsAcptFlg) {
		this.cstmsAcptFlg = cstmsAcptFlg;
	}
	
	/**
	 * Column Info
	 * @param itchgHrs
	 */
	public void setItchgHrs(String itchgHrs) {
		this.itchgHrs = itchgHrs;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param arrDt
	 */
	public void setArrDt(String arrDt) {
		this.arrDt = arrDt;
	}
	
	/**
	 * Column Info
	 * @param orgDepFlg
	 */
	public void setOrgDepFlg(String orgDepFlg) {
		this.orgDepFlg = orgDepFlg;
	}
	
	/**
	 * Column Info
	 * @param woVndrSeq
	 */
	public void setWoVndrSeq(String woVndrSeq) {
		this.woVndrSeq = woVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param itchgN1stDepFlg
	 */
	public void setItchgN1stDepFlg(String itchgN1stDepFlg) {
		this.itchgN1stDepFlg = itchgN1stDepFlg;
	}
	
	/**
	 * Column Info
	 * @param clmSghtCd
	 */
	public void setClmSghtCd(String clmSghtCd) {
		this.clmSghtCd = clmSghtCd;
	}
	
	/**
	 * Column Info
	 * @param lstFreeDt
	 */
	public void setLstFreeDt(String lstFreeDt) {
		this.lstFreeDt = lstFreeDt;
	}
	
	/**
	 * Column Info
	 * @param arrSplcCd
	 */
	public void setArrSplcCd(String arrSplcCd) {
		this.arrSplcCd = arrSplcCd;
	}
	
	/**
	 * Column Info
	 * @param dwllHrs
	 */
	public void setDwllHrs(String dwllHrs) {
		this.dwllHrs = dwllHrs;
	}
	
	/**
	 * Column Info
	 * @param railCoDestPntEtaDt
	 */
	public void setRailCoDestPntEtaDt(String railCoDestPntEtaDt) {
		this.railCoDestPntEtaDt = railCoDestPntEtaDt;
	}
	
	/**
	 * Column Info
	 * @param destN2ndDwllTmHrs
	 */
	public void setDestN2ndDwllTmHrs(String destN2ndDwllTmHrs) {
		this.destN2ndDwllTmHrs = destN2ndDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param preDwllRmk
	 */
	public void setPreDwllRmk(String preDwllRmk) {
		this.preDwllRmk = preDwllRmk;
	}
	
	/**
	 * Column Info
	 * @param destN2ndDepFlg
	 */
	public void setDestN2ndDepFlg(String destN2ndDepFlg) {
		this.destN2ndDepFlg = destN2ndDepFlg;
	}
	
	/**
	 * Column Info
	 * @param crntDwllRmk
	 */
	public void setCrntDwllRmk(String crntDwllRmk) {
		this.crntDwllRmk = crntDwllRmk;
	}
	
	/**
	 * Column Info
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
	}
	
	/**
	 * Column Info
	 * @param itchgSplcLocNm
	 */
	public void setItchgSplcLocNm(String itchgSplcLocNm) {
		this.itchgSplcLocNm = itchgSplcLocNm;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param costActGrpSeq
	 */
	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param cgorFrtPayIndFlg
	 */
	public void setCgorFrtPayIndFlg(String cgorFrtPayIndFlg) {
		this.cgorFrtPayIndFlg = cgorFrtPayIndFlg;
	}
	
	/**
	 * Column Info
	 * @param destGateOutDt
	 */
	public void setDestGateOutDt(String destGateOutDt) {
		this.destGateOutDt = destGateOutDt;
	}
	
	/**
	 * Column Info
	 * @param railItchgN1stEtdDt
	 */
	public void setRailItchgN1stEtdDt(String railItchgN1stEtdDt) {
		this.railItchgN1stEtdDt = railItchgN1stEtdDt;
	}
	
	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param railItchgN2ndEtdDt
	 */
	public void setRailItchgN2ndEtdDt(String railItchgN2ndEtdDt) {
		this.railItchgN2ndEtdDt = railItchgN2ndEtdDt;
	}
	
	/**
	 * Column Info
	 * @param railItchgN1stEtaDt
	 */
	public void setRailItchgN1stEtaDt(String railItchgN1stEtaDt) {
		this.railItchgN1stEtaDt = railItchgN1stEtaDt;
	}
	
	/**
	 * Column Info
	 * @param fcarNo
	 */
	public void setFcarNo(String fcarNo) {
		this.fcarNo = fcarNo;
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
	 * @param ibIpiLoclIndCd
	 */
	public void setIbIpiLoclIndCd(String ibIpiLoclIndCd) {
		this.ibIpiLoclIndCd = ibIpiLoclIndCd;
	}
	
	/**
	 * Column Info
	 * @param itchgGateInDt
	 */
	public void setItchgGateInDt(String itchgGateInDt) {
		this.itchgGateInDt = itchgGateInDt;
	}
	
	/**
	 * Column Info
	 * @param railTztmHrs
	 */
	public void setRailTztmHrs(String railTztmHrs) {
		this.railTztmHrs = railTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param crntDwllTmHrs
	 */
	public void setCrntDwllTmHrs(String crntDwllTmHrs) {
		this.crntDwllTmHrs = crntDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @param orgDwllTmHrs
	 */
	public void setOrgDwllTmHrs(String orgDwllTmHrs) {
		this.orgDwllTmHrs = orgDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @param soCreDt
	 */
	public void setSoCreDt(String soCreDt) {
		this.soCreDt = soCreDt;
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
	 * @param arrSteCd
	 */
	public void setArrSteCd(String arrSteCd) {
		this.arrSteCd = arrSteCd;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param railDestN2ndEtaDt
	 */
	public void setRailDestN2ndEtaDt(String railDestN2ndEtaDt) {
		this.railDestN2ndEtaDt = railDestN2ndEtaDt;
	}
	
	/**
	 * Column Info
	 * @param arrLocNm
	 */
	public void setArrLocNm(String arrLocNm) {
		this.arrLocNm = arrLocNm;
	}
	
	/**
	 * Column Info
	 * @param tztmDiffHrs
	 */
	public void setTztmDiffHrs(String tztmDiffHrs) {
		this.tztmDiffHrs = tztmDiffHrs;
	}
	
	/**
	 * Column Info
	 * @param itchgN2ndDwllTmHrs
	 */
	public void setItchgN2ndDwllTmHrs(String itchgN2ndDwllTmHrs) {
		this.itchgN2ndDwllTmHrs = itchgN2ndDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @param itchgDt
	 */
	public void setItchgDt(String itchgDt) {
		this.itchgDt = itchgDt;
	}
	
	/**
	 * Column Info
	 * @param tmlDwllTmHrs
	 */
	public void setTmlDwllTmHrs(String tmlDwllTmHrs) {
		this.tmlDwllTmHrs = tmlDwllTmHrs;
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
	 * @param bkgHotDeFlg
	 */
	public void setBkgHotDeFlg(String bkgHotDeFlg) {
		this.bkgHotDeFlg = bkgHotDeFlg;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param orgSplcLocNm
	 */
	public void setOrgSplcLocNm(String orgSplcLocNm) {
		this.orgSplcLocNm = orgSplcLocNm;
	}
	
	/**
	 * Column Info
	 * @param itchgGateOutDt
	 */
	public void setItchgGateOutDt(String itchgGateOutDt) {
		this.itchgGateOutDt = itchgGateOutDt;
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
	 * @param copExptNo
	 */
	public void setCopExptNo(String copExptNo) {
		this.copExptNo = copExptNo;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param railCoItchgPntEtaDt
	 */
	public void setRailCoItchgPntEtaDt(String railCoItchgPntEtaDt) {
		this.railCoItchgPntEtaDt = railCoItchgPntEtaDt;
	}
	
	/**
	 * Column Info
	 * @param crntDwllRmkUpdDt
	 */
	public void setCrntDwllRmkUpdDt(String crntDwllRmkUpdDt) {
		this.crntDwllRmkUpdDt = crntDwllRmkUpdDt;
	}
	
	/**
	 * Column Info
	 * @param tmlDepFlg
	 */
	public void setTmlDepFlg(String tmlDepFlg) {
		this.tmlDepFlg = tmlDepFlg;
	}
	
	/**
	 * Column Info
	 * @param copExptTpCd
	 */
	public void setCopExptTpCd(String copExptTpCd) {
		this.copExptTpCd = copExptTpCd;
	}
	
	/**
	 * Column Info
	 * @param preDwllRmkUpdDt
	 */
	public void setPreDwllRmkUpdDt(String preDwllRmkUpdDt) {
		this.preDwllRmkUpdDt = preDwllRmkUpdDt;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param railDestN1stEtaDt
	 */
	public void setRailDestN1stEtaDt(String railDestN1stEtaDt) {
		this.railDestN1stEtaDt = railDestN1stEtaDt;
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
	 * @param avalFlg
	 */
	public void setAvalFlg(String avalFlg) {
		this.avalFlg = avalFlg;
	}
	
	/**
	 * Column Info
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
	 * Column Info
	 * @param vdDt
	 */
	public void setVdDt(String vdDt) {
		this.vdDt = vdDt;
	}
	
	/**
	 * Column Info
	 * @param itchgN2ndDepFlg
	 */
	public void setItchgN2ndDepFlg(String itchgN2ndDepFlg) {
		this.itchgN2ndDepFlg = itchgN2ndDepFlg;
	}
	
	/**
	 * Column Info
	 * @param railRunTmHrs
	 */
	public void setRailRunTmHrs(String railRunTmHrs) {
		this.railRunTmHrs = railRunTmHrs;
	}
	
	/**
	 * Column Info
	 * @param destN1stDwllTmHrs
	 */
	public void setDestN1stDwllTmHrs(String destN1stDwllTmHrs) {
		this.destN1stDwllTmHrs = destN1stDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @param orgGateOutUpdFlg
	 */
	public void setOrgGateOutUpdFlg(String orgGateOutUpdFlg) {
		this.orgGateOutUpdFlg = orgGateOutUpdFlg;
	}
	
	/**
	 * Column Info
	 * @param trnNo
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}
	
	/**
	 * Column Info
	 * @param hldRmk
	 */
	public void setHldRmk(String hldRmk) {
		this.hldRmk = hldRmk;
	}
	
	/**
	 * Column Info
	 * @param avgTzHrs
	 */
	public void setAvgTzHrs(String avgTzHrs) {
		this.avgTzHrs = avgTzHrs;
	}
	
	/**
	 * Column Info
	 * @param destGateInDt
	 */
	public void setDestGateInDt(String destGateInDt) {
		this.destGateInDt = destGateInDt;
	}
	
	/**
	 * Column Info
	 * @param destN1stDepFlg
	 */
	public void setDestN1stDepFlg(String destN1stDepFlg) {
		this.destN1stDepFlg = destN1stDepFlg;
	}
	
	/**
	 * Column Info
	 * @param destLocNm
	 */
	public void setDestLocNm(String destLocNm) {
		this.destLocNm = destLocNm;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param hldFlg
	 */
	public void setHldFlg(String hldFlg) {
		this.hldFlg = hldFlg;
	}
	
	/**
	 * Column Info
	 * @param orgGateInUpdFlg
	 */
	public void setOrgGateInUpdFlg(String orgGateInUpdFlg) {
		this.orgGateInUpdFlg = orgGateInUpdFlg;
	}
	
	/**
	 * Column Info
	 * @param copExptStsCd
	 */
	public void setCopExptStsCd(String copExptStsCd) {
		this.copExptStsCd = copExptStsCd;
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
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setDestAvalDt(JSPUtil.getParameter(request, prefix + "dest_aval_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDwllRsnLocNm(JSPUtil.getParameter(request, prefix + "dwll_rsn_loc_nm", ""));
		setItchgArrSplcLocNm(JSPUtil.getParameter(request, prefix + "itchg_arr_splc_loc_nm", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setIbdCstmsClrLocCd(JSPUtil.getParameter(request, prefix + "ibd_cstms_clr_loc_cd", ""));
		setMstBlNo(JSPUtil.getParameter(request, prefix + "mst_bl_no", ""));
		setOrgGateInDt(JSPUtil.getParameter(request, prefix + "org_gate_in_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setWoIssDt(JSPUtil.getParameter(request, prefix + "wo_iss_dt", ""));
		setAmsUpdDt(JSPUtil.getParameter(request, prefix + "ams_upd_dt", ""));
		setCgorOrgBlRcvrIndFlg(JSPUtil.getParameter(request, prefix + "cgor_org_bl_rcvr_ind_flg", ""));
		setItchgN1stDwllTmHrs(JSPUtil.getParameter(request, prefix + "itchg_n1st_dwll_tm_hrs", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRptUpdStsCd(JSPUtil.getParameter(request, prefix + "rpt_upd_sts_cd", ""));
		setUsaEdiCd(JSPUtil.getParameter(request, prefix + "usa_edi_cd", ""));
		setOrgGateOutDt(JSPUtil.getParameter(request, prefix + "org_gate_out_dt", ""));
		setRailItchgN2ndEtaDt(JSPUtil.getParameter(request, prefix + "rail_itchg_n2nd_eta_dt", ""));
		setCstmsAcptFlg(JSPUtil.getParameter(request, prefix + "cstms_acpt_flg", ""));
		setItchgHrs(JSPUtil.getParameter(request, prefix + "itchg_hrs", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setArrDt(JSPUtil.getParameter(request, prefix + "arr_dt", ""));
		setOrgDepFlg(JSPUtil.getParameter(request, prefix + "org_dep_flg", ""));
		setWoVndrSeq(JSPUtil.getParameter(request, prefix + "wo_vndr_seq", ""));
		setItchgN1stDepFlg(JSPUtil.getParameter(request, prefix + "itchg_n1st_dep_flg", ""));
		setClmSghtCd(JSPUtil.getParameter(request, prefix + "clm_sght_cd", ""));
		setLstFreeDt(JSPUtil.getParameter(request, prefix + "lst_free_dt", ""));
		setArrSplcCd(JSPUtil.getParameter(request, prefix + "arr_splc_cd", ""));
		setDwllHrs(JSPUtil.getParameter(request, prefix + "dwll_hrs", ""));
		setRailCoDestPntEtaDt(JSPUtil.getParameter(request, prefix + "rail_co_dest_pnt_eta_dt", ""));
		setDestN2ndDwllTmHrs(JSPUtil.getParameter(request, prefix + "dest_n2nd_dwll_tm_hrs", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setPreDwllRmk(JSPUtil.getParameter(request, prefix + "pre_dwll_rmk", ""));
		setDestN2ndDepFlg(JSPUtil.getParameter(request, prefix + "dest_n2nd_dep_flg", ""));
		setCrntDwllRmk(JSPUtil.getParameter(request, prefix + "crnt_dwll_rmk", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setItchgSplcLocNm(JSPUtil.getParameter(request, prefix + "itchg_splc_loc_nm", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, prefix + "cost_act_grp_seq", ""));
		setCgorFrtPayIndFlg(JSPUtil.getParameter(request, prefix + "cgor_frt_pay_ind_flg", ""));
		setDestGateOutDt(JSPUtil.getParameter(request, prefix + "dest_gate_out_dt", ""));
		setRailItchgN1stEtdDt(JSPUtil.getParameter(request, prefix + "rail_itchg_n1st_etd_dt", ""));
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setRailItchgN2ndEtdDt(JSPUtil.getParameter(request, prefix + "rail_itchg_n2nd_etd_dt", ""));
		setRailItchgN1stEtaDt(JSPUtil.getParameter(request, prefix + "rail_itchg_n1st_eta_dt", ""));
		setFcarNo(JSPUtil.getParameter(request, prefix + "fcar_no", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setIbIpiLoclIndCd(JSPUtil.getParameter(request, prefix + "ib_ipi_locl_ind_cd", ""));
		setItchgGateInDt(JSPUtil.getParameter(request, prefix + "itchg_gate_in_dt", ""));
		setRailTztmHrs(JSPUtil.getParameter(request, prefix + "rail_tztm_hrs", ""));
		setCrntDwllTmHrs(JSPUtil.getParameter(request, prefix + "crnt_dwll_tm_hrs", ""));
		setOrgDwllTmHrs(JSPUtil.getParameter(request, prefix + "org_dwll_tm_hrs", ""));
		setSoCreDt(JSPUtil.getParameter(request, prefix + "so_cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setArrSteCd(JSPUtil.getParameter(request, prefix + "arr_ste_cd", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setRailDestN2ndEtaDt(JSPUtil.getParameter(request, prefix + "rail_dest_n2nd_eta_dt", ""));
		setArrLocNm(JSPUtil.getParameter(request, prefix + "arr_loc_nm", ""));
		setTztmDiffHrs(JSPUtil.getParameter(request, prefix + "tztm_diff_hrs", ""));
		setItchgN2ndDwllTmHrs(JSPUtil.getParameter(request, prefix + "itchg_n2nd_dwll_tm_hrs", ""));
		setItchgDt(JSPUtil.getParameter(request, prefix + "itchg_dt", ""));
		setTmlDwllTmHrs(JSPUtil.getParameter(request, prefix + "tml_dwll_tm_hrs", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setBkgHotDeFlg(JSPUtil.getParameter(request, prefix + "bkg_hot_de_flg", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setOrgSplcLocNm(JSPUtil.getParameter(request, prefix + "org_splc_loc_nm", ""));
		setItchgGateOutDt(JSPUtil.getParameter(request, prefix + "itchg_gate_out_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCopExptNo(JSPUtil.getParameter(request, prefix + "cop_expt_no", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setRailCoItchgPntEtaDt(JSPUtil.getParameter(request, prefix + "rail_co_itchg_pnt_eta_dt", ""));
		setCrntDwllRmkUpdDt(JSPUtil.getParameter(request, prefix + "crnt_dwll_rmk_upd_dt", ""));
		setTmlDepFlg(JSPUtil.getParameter(request, prefix + "tml_dep_flg", ""));
		setCopExptTpCd(JSPUtil.getParameter(request, prefix + "cop_expt_tp_cd", ""));
		setPreDwllRmkUpdDt(JSPUtil.getParameter(request, prefix + "pre_dwll_rmk_upd_dt", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setRailDestN1stEtaDt(JSPUtil.getParameter(request, prefix + "rail_dest_n1st_eta_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setAvalFlg(JSPUtil.getParameter(request, prefix + "aval_flg", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setVdDt(JSPUtil.getParameter(request, prefix + "vd_dt", ""));
		setItchgN2ndDepFlg(JSPUtil.getParameter(request, prefix + "itchg_n2nd_dep_flg", ""));
		setRailRunTmHrs(JSPUtil.getParameter(request, prefix + "rail_run_tm_hrs", ""));
		setDestN1stDwllTmHrs(JSPUtil.getParameter(request, prefix + "dest_n1st_dwll_tm_hrs", ""));
		setOrgGateOutUpdFlg(JSPUtil.getParameter(request, prefix + "org_gate_out_upd_flg", ""));
		setTrnNo(JSPUtil.getParameter(request, prefix + "trn_no", ""));
		setHldRmk(JSPUtil.getParameter(request, prefix + "hld_rmk", ""));
		setAvgTzHrs(JSPUtil.getParameter(request, prefix + "avg_tz_hrs", ""));
		setDestGateInDt(JSPUtil.getParameter(request, prefix + "dest_gate_in_dt", ""));
		setDestN1stDepFlg(JSPUtil.getParameter(request, prefix + "dest_n1st_dep_flg", ""));
		setDestLocNm(JSPUtil.getParameter(request, prefix + "dest_loc_nm", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setHldFlg(JSPUtil.getParameter(request, prefix + "hld_flg", ""));
		setOrgGateInUpdFlg(JSPUtil.getParameter(request, prefix + "org_gate_in_upd_flg", ""));
		setCopExptStsCd(JSPUtil.getParameter(request, prefix + "cop_expt_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SceRailTzRptVO[]
	 */
	public SceRailTzRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SceRailTzRptVO[]
	 */
	public SceRailTzRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SceRailTzRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] destAvalDt = (JSPUtil.getParameter(request, prefix	+ "dest_aval_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dwllRsnLocNm = (JSPUtil.getParameter(request, prefix	+ "dwll_rsn_loc_nm", length));
			String[] itchgArrSplcLocNm = (JSPUtil.getParameter(request, prefix	+ "itchg_arr_splc_loc_nm", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] ibdCstmsClrLocCd = (JSPUtil.getParameter(request, prefix	+ "ibd_cstms_clr_loc_cd", length));
			String[] mstBlNo = (JSPUtil.getParameter(request, prefix	+ "mst_bl_no", length));
			String[] orgGateInDt = (JSPUtil.getParameter(request, prefix	+ "org_gate_in_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] woIssDt = (JSPUtil.getParameter(request, prefix	+ "wo_iss_dt", length));
			String[] amsUpdDt = (JSPUtil.getParameter(request, prefix	+ "ams_upd_dt", length));
			String[] cgorOrgBlRcvrIndFlg = (JSPUtil.getParameter(request, prefix	+ "cgor_org_bl_rcvr_ind_flg", length));
			String[] itchgN1stDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "itchg_n1st_dwll_tm_hrs", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rptUpdStsCd = (JSPUtil.getParameter(request, prefix	+ "rpt_upd_sts_cd", length));
			String[] usaEdiCd = (JSPUtil.getParameter(request, prefix	+ "usa_edi_cd", length));
			String[] orgGateOutDt = (JSPUtil.getParameter(request, prefix	+ "org_gate_out_dt", length));
			String[] railItchgN2ndEtaDt = (JSPUtil.getParameter(request, prefix	+ "rail_itchg_n2nd_eta_dt", length));
			String[] cstmsAcptFlg = (JSPUtil.getParameter(request, prefix	+ "cstms_acpt_flg", length));
			String[] itchgHrs = (JSPUtil.getParameter(request, prefix	+ "itchg_hrs", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] arrDt = (JSPUtil.getParameter(request, prefix	+ "arr_dt", length));
			String[] orgDepFlg = (JSPUtil.getParameter(request, prefix	+ "org_dep_flg", length));
			String[] woVndrSeq = (JSPUtil.getParameter(request, prefix	+ "wo_vndr_seq", length));
			String[] itchgN1stDepFlg = (JSPUtil.getParameter(request, prefix	+ "itchg_n1st_dep_flg", length));
			String[] clmSghtCd = (JSPUtil.getParameter(request, prefix	+ "clm_sght_cd", length));
			String[] lstFreeDt = (JSPUtil.getParameter(request, prefix	+ "lst_free_dt", length));
			String[] arrSplcCd = (JSPUtil.getParameter(request, prefix	+ "arr_splc_cd", length));
			String[] dwllHrs = (JSPUtil.getParameter(request, prefix	+ "dwll_hrs", length));
			String[] railCoDestPntEtaDt = (JSPUtil.getParameter(request, prefix	+ "rail_co_dest_pnt_eta_dt", length));
			String[] destN2ndDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "dest_n2nd_dwll_tm_hrs", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] preDwllRmk = (JSPUtil.getParameter(request, prefix	+ "pre_dwll_rmk", length));
			String[] destN2ndDepFlg = (JSPUtil.getParameter(request, prefix	+ "dest_n2nd_dep_flg", length));
			String[] crntDwllRmk = (JSPUtil.getParameter(request, prefix	+ "crnt_dwll_rmk", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] itchgSplcLocNm = (JSPUtil.getParameter(request, prefix	+ "itchg_splc_loc_nm", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_seq", length));
			String[] cgorFrtPayIndFlg = (JSPUtil.getParameter(request, prefix	+ "cgor_frt_pay_ind_flg", length));
			String[] destGateOutDt = (JSPUtil.getParameter(request, prefix	+ "dest_gate_out_dt", length));
			String[] railItchgN1stEtdDt = (JSPUtil.getParameter(request, prefix	+ "rail_itchg_n1st_etd_dt", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] railItchgN2ndEtdDt = (JSPUtil.getParameter(request, prefix	+ "rail_itchg_n2nd_etd_dt", length));
			String[] railItchgN1stEtaDt = (JSPUtil.getParameter(request, prefix	+ "rail_itchg_n1st_eta_dt", length));
			String[] fcarNo = (JSPUtil.getParameter(request, prefix	+ "fcar_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] ibIpiLoclIndCd = (JSPUtil.getParameter(request, prefix	+ "ib_ipi_locl_ind_cd", length));
			String[] itchgGateInDt = (JSPUtil.getParameter(request, prefix	+ "itchg_gate_in_dt", length));
			String[] railTztmHrs = (JSPUtil.getParameter(request, prefix	+ "rail_tztm_hrs", length));
			String[] crntDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "crnt_dwll_tm_hrs", length));
			String[] orgDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "org_dwll_tm_hrs", length));
			String[] soCreDt = (JSPUtil.getParameter(request, prefix	+ "so_cre_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] arrSteCd = (JSPUtil.getParameter(request, prefix	+ "arr_ste_cd", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] railDestN2ndEtaDt = (JSPUtil.getParameter(request, prefix	+ "rail_dest_n2nd_eta_dt", length));
			String[] arrLocNm = (JSPUtil.getParameter(request, prefix	+ "arr_loc_nm", length));
			String[] tztmDiffHrs = (JSPUtil.getParameter(request, prefix	+ "tztm_diff_hrs", length));
			String[] itchgN2ndDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "itchg_n2nd_dwll_tm_hrs", length));
			String[] itchgDt = (JSPUtil.getParameter(request, prefix	+ "itchg_dt", length));
			String[] tmlDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "tml_dwll_tm_hrs", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] bkgHotDeFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_hot_de_flg", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] orgSplcLocNm = (JSPUtil.getParameter(request, prefix	+ "org_splc_loc_nm", length));
			String[] itchgGateOutDt = (JSPUtil.getParameter(request, prefix	+ "itchg_gate_out_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] copExptNo = (JSPUtil.getParameter(request, prefix	+ "cop_expt_no", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] railCoItchgPntEtaDt = (JSPUtil.getParameter(request, prefix	+ "rail_co_itchg_pnt_eta_dt", length));
			String[] crntDwllRmkUpdDt = (JSPUtil.getParameter(request, prefix	+ "crnt_dwll_rmk_upd_dt", length));
			String[] tmlDepFlg = (JSPUtil.getParameter(request, prefix	+ "tml_dep_flg", length));
			String[] copExptTpCd = (JSPUtil.getParameter(request, prefix	+ "cop_expt_tp_cd", length));
			String[] preDwllRmkUpdDt = (JSPUtil.getParameter(request, prefix	+ "pre_dwll_rmk_upd_dt", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] railDestN1stEtaDt = (JSPUtil.getParameter(request, prefix	+ "rail_dest_n1st_eta_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] avalFlg = (JSPUtil.getParameter(request, prefix	+ "aval_flg", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] vdDt = (JSPUtil.getParameter(request, prefix	+ "vd_dt", length));
			String[] itchgN2ndDepFlg = (JSPUtil.getParameter(request, prefix	+ "itchg_n2nd_dep_flg", length));
			String[] railRunTmHrs = (JSPUtil.getParameter(request, prefix	+ "rail_run_tm_hrs", length));
			String[] destN1stDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "dest_n1st_dwll_tm_hrs", length));
			String[] orgGateOutUpdFlg = (JSPUtil.getParameter(request, prefix	+ "org_gate_out_upd_flg", length));
			String[] trnNo = (JSPUtil.getParameter(request, prefix	+ "trn_no", length));
			String[] hldRmk = (JSPUtil.getParameter(request, prefix	+ "hld_rmk", length));
			String[] avgTzHrs = (JSPUtil.getParameter(request, prefix	+ "avg_tz_hrs", length));
			String[] destGateInDt = (JSPUtil.getParameter(request, prefix	+ "dest_gate_in_dt", length));
			String[] destN1stDepFlg = (JSPUtil.getParameter(request, prefix	+ "dest_n1st_dep_flg", length));
			String[] destLocNm = (JSPUtil.getParameter(request, prefix	+ "dest_loc_nm", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] hldFlg = (JSPUtil.getParameter(request, prefix	+ "hld_flg", length));
			String[] orgGateInUpdFlg = (JSPUtil.getParameter(request, prefix	+ "org_gate_in_upd_flg", length));
			String[] copExptStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_expt_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SceRailTzRptVO();
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (destAvalDt[i] != null)
					model.setDestAvalDt(destAvalDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dwllRsnLocNm[i] != null)
					model.setDwllRsnLocNm(dwllRsnLocNm[i]);
				if (itchgArrSplcLocNm[i] != null)
					model.setItchgArrSplcLocNm(itchgArrSplcLocNm[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (ibdCstmsClrLocCd[i] != null)
					model.setIbdCstmsClrLocCd(ibdCstmsClrLocCd[i]);
				if (mstBlNo[i] != null)
					model.setMstBlNo(mstBlNo[i]);
				if (orgGateInDt[i] != null)
					model.setOrgGateInDt(orgGateInDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (woIssDt[i] != null)
					model.setWoIssDt(woIssDt[i]);
				if (amsUpdDt[i] != null)
					model.setAmsUpdDt(amsUpdDt[i]);
				if (cgorOrgBlRcvrIndFlg[i] != null)
					model.setCgorOrgBlRcvrIndFlg(cgorOrgBlRcvrIndFlg[i]);
				if (itchgN1stDwllTmHrs[i] != null)
					model.setItchgN1stDwllTmHrs(itchgN1stDwllTmHrs[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rptUpdStsCd[i] != null)
					model.setRptUpdStsCd(rptUpdStsCd[i]);
				if (usaEdiCd[i] != null)
					model.setUsaEdiCd(usaEdiCd[i]);
				if (orgGateOutDt[i] != null)
					model.setOrgGateOutDt(orgGateOutDt[i]);
				if (railItchgN2ndEtaDt[i] != null)
					model.setRailItchgN2ndEtaDt(railItchgN2ndEtaDt[i]);
				if (cstmsAcptFlg[i] != null)
					model.setCstmsAcptFlg(cstmsAcptFlg[i]);
				if (itchgHrs[i] != null)
					model.setItchgHrs(itchgHrs[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (arrDt[i] != null)
					model.setArrDt(arrDt[i]);
				if (orgDepFlg[i] != null)
					model.setOrgDepFlg(orgDepFlg[i]);
				if (woVndrSeq[i] != null)
					model.setWoVndrSeq(woVndrSeq[i]);
				if (itchgN1stDepFlg[i] != null)
					model.setItchgN1stDepFlg(itchgN1stDepFlg[i]);
				if (clmSghtCd[i] != null)
					model.setClmSghtCd(clmSghtCd[i]);
				if (lstFreeDt[i] != null)
					model.setLstFreeDt(lstFreeDt[i]);
				if (arrSplcCd[i] != null)
					model.setArrSplcCd(arrSplcCd[i]);
				if (dwllHrs[i] != null)
					model.setDwllHrs(dwllHrs[i]);
				if (railCoDestPntEtaDt[i] != null)
					model.setRailCoDestPntEtaDt(railCoDestPntEtaDt[i]);
				if (destN2ndDwllTmHrs[i] != null)
					model.setDestN2ndDwllTmHrs(destN2ndDwllTmHrs[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (preDwllRmk[i] != null)
					model.setPreDwllRmk(preDwllRmk[i]);
				if (destN2ndDepFlg[i] != null)
					model.setDestN2ndDepFlg(destN2ndDepFlg[i]);
				if (crntDwllRmk[i] != null)
					model.setCrntDwllRmk(crntDwllRmk[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (itchgSplcLocNm[i] != null)
					model.setItchgSplcLocNm(itchgSplcLocNm[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (cgorFrtPayIndFlg[i] != null)
					model.setCgorFrtPayIndFlg(cgorFrtPayIndFlg[i]);
				if (destGateOutDt[i] != null)
					model.setDestGateOutDt(destGateOutDt[i]);
				if (railItchgN1stEtdDt[i] != null)
					model.setRailItchgN1stEtdDt(railItchgN1stEtdDt[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (railItchgN2ndEtdDt[i] != null)
					model.setRailItchgN2ndEtdDt(railItchgN2ndEtdDt[i]);
				if (railItchgN1stEtaDt[i] != null)
					model.setRailItchgN1stEtaDt(railItchgN1stEtaDt[i]);
				if (fcarNo[i] != null)
					model.setFcarNo(fcarNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (ibIpiLoclIndCd[i] != null)
					model.setIbIpiLoclIndCd(ibIpiLoclIndCd[i]);
				if (itchgGateInDt[i] != null)
					model.setItchgGateInDt(itchgGateInDt[i]);
				if (railTztmHrs[i] != null)
					model.setRailTztmHrs(railTztmHrs[i]);
				if (crntDwllTmHrs[i] != null)
					model.setCrntDwllTmHrs(crntDwllTmHrs[i]);
				if (orgDwllTmHrs[i] != null)
					model.setOrgDwllTmHrs(orgDwllTmHrs[i]);
				if (soCreDt[i] != null)
					model.setSoCreDt(soCreDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (arrSteCd[i] != null)
					model.setArrSteCd(arrSteCd[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (railDestN2ndEtaDt[i] != null)
					model.setRailDestN2ndEtaDt(railDestN2ndEtaDt[i]);
				if (arrLocNm[i] != null)
					model.setArrLocNm(arrLocNm[i]);
				if (tztmDiffHrs[i] != null)
					model.setTztmDiffHrs(tztmDiffHrs[i]);
				if (itchgN2ndDwllTmHrs[i] != null)
					model.setItchgN2ndDwllTmHrs(itchgN2ndDwllTmHrs[i]);
				if (itchgDt[i] != null)
					model.setItchgDt(itchgDt[i]);
				if (tmlDwllTmHrs[i] != null)
					model.setTmlDwllTmHrs(tmlDwllTmHrs[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (bkgHotDeFlg[i] != null)
					model.setBkgHotDeFlg(bkgHotDeFlg[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (orgSplcLocNm[i] != null)
					model.setOrgSplcLocNm(orgSplcLocNm[i]);
				if (itchgGateOutDt[i] != null)
					model.setItchgGateOutDt(itchgGateOutDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (copExptNo[i] != null)
					model.setCopExptNo(copExptNo[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (railCoItchgPntEtaDt[i] != null)
					model.setRailCoItchgPntEtaDt(railCoItchgPntEtaDt[i]);
				if (crntDwllRmkUpdDt[i] != null)
					model.setCrntDwllRmkUpdDt(crntDwllRmkUpdDt[i]);
				if (tmlDepFlg[i] != null)
					model.setTmlDepFlg(tmlDepFlg[i]);
				if (copExptTpCd[i] != null)
					model.setCopExptTpCd(copExptTpCd[i]);
				if (preDwllRmkUpdDt[i] != null)
					model.setPreDwllRmkUpdDt(preDwllRmkUpdDt[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (railDestN1stEtaDt[i] != null)
					model.setRailDestN1stEtaDt(railDestN1stEtaDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (avalFlg[i] != null)
					model.setAvalFlg(avalFlg[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (vdDt[i] != null)
					model.setVdDt(vdDt[i]);
				if (itchgN2ndDepFlg[i] != null)
					model.setItchgN2ndDepFlg(itchgN2ndDepFlg[i]);
				if (railRunTmHrs[i] != null)
					model.setRailRunTmHrs(railRunTmHrs[i]);
				if (destN1stDwllTmHrs[i] != null)
					model.setDestN1stDwllTmHrs(destN1stDwllTmHrs[i]);
				if (orgGateOutUpdFlg[i] != null)
					model.setOrgGateOutUpdFlg(orgGateOutUpdFlg[i]);
				if (trnNo[i] != null)
					model.setTrnNo(trnNo[i]);
				if (hldRmk[i] != null)
					model.setHldRmk(hldRmk[i]);
				if (avgTzHrs[i] != null)
					model.setAvgTzHrs(avgTzHrs[i]);
				if (destGateInDt[i] != null)
					model.setDestGateInDt(destGateInDt[i]);
				if (destN1stDepFlg[i] != null)
					model.setDestN1stDepFlg(destN1stDepFlg[i]);
				if (destLocNm[i] != null)
					model.setDestLocNm(destLocNm[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (hldFlg[i] != null)
					model.setHldFlg(hldFlg[i]);
				if (orgGateInUpdFlg[i] != null)
					model.setOrgGateInUpdFlg(orgGateInUpdFlg[i]);
				if (copExptStsCd[i] != null)
					model.setCopExptStsCd(copExptStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSceRailTzRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SceRailTzRptVO[]
	 */
	public SceRailTzRptVO[] getSceRailTzRptVOs(){
		SceRailTzRptVO[] vos = (SceRailTzRptVO[])models.toArray(new SceRailTzRptVO[models.size()]);
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
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destAvalDt = this.destAvalDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwllRsnLocNm = this.dwllRsnLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgArrSplcLocNm = this.itchgArrSplcLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdCstmsClrLocCd = this.ibdCstmsClrLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBlNo = this.mstBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgGateInDt = this.orgGateInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssDt = this.woIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amsUpdDt = this.amsUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorOrgBlRcvrIndFlg = this.cgorOrgBlRcvrIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgN1stDwllTmHrs = this.itchgN1stDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptUpdStsCd = this.rptUpdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaEdiCd = this.usaEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgGateOutDt = this.orgGateOutDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railItchgN2ndEtaDt = this.railItchgN2ndEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAcptFlg = this.cstmsAcptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgHrs = this.itchgHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDt = this.arrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDepFlg = this.orgDepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woVndrSeq = this.woVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgN1stDepFlg = this.itchgN1stDepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmSghtCd = this.clmSghtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFreeDt = this.lstFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrSplcCd = this.arrSplcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwllHrs = this.dwllHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCoDestPntEtaDt = this.railCoDestPntEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destN2ndDwllTmHrs = this.destN2ndDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preDwllRmk = this.preDwllRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destN2ndDepFlg = this.destN2ndDepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntDwllRmk = this.crntDwllRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgSplcLocNm = this.itchgSplcLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorFrtPayIndFlg = this.cgorFrtPayIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destGateOutDt = this.destGateOutDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railItchgN1stEtdDt = this.railItchgN1stEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railItchgN2ndEtdDt = this.railItchgN2ndEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railItchgN1stEtaDt = this.railItchgN1stEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcarNo = this.fcarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibIpiLoclIndCd = this.ibIpiLoclIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgGateInDt = this.itchgGateInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railTztmHrs = this.railTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntDwllTmHrs = this.crntDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDwllTmHrs = this.orgDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCreDt = this.soCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrSteCd = this.arrSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railDestN2ndEtaDt = this.railDestN2ndEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLocNm = this.arrLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tztmDiffHrs = this.tztmDiffHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgN2ndDwllTmHrs = this.itchgN2ndDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgDt = this.itchgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlDwllTmHrs = this.tmlDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHotDeFlg = this.bkgHotDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSplcLocNm = this.orgSplcLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgGateOutDt = this.itchgGateOutDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptNo = this.copExptNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCoItchgPntEtaDt = this.railCoItchgPntEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntDwllRmkUpdDt = this.crntDwllRmkUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlDepFlg = this.tmlDepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptTpCd = this.copExptTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preDwllRmkUpdDt = this.preDwllRmkUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railDestN1stEtaDt = this.railDestN1stEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avalFlg = this.avalFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vdDt = this.vdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgN2ndDepFlg = this.itchgN2ndDepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railRunTmHrs = this.railRunTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destN1stDwllTmHrs = this.destN1stDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgGateOutUpdFlg = this.orgGateOutUpdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnNo = this.trnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldRmk = this.hldRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgTzHrs = this.avgTzHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destGateInDt = this.destGateInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destN1stDepFlg = this.destN1stDepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocNm = this.destLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldFlg = this.hldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgGateInUpdFlg = this.orgGateInUpdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptStsCd = this.copExptStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
