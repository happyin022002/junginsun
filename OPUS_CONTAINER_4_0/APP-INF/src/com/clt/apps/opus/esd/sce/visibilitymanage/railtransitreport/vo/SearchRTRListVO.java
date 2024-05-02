/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchRTRListVO.java
*@FileTitle : SearchRTRListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.09.16 이중환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.vo;

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
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRTRListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRTRListVO> models = new ArrayList<SearchRTRListVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String railItchgN1stEtaDate = null;
	/* Column Info */
	private String evntDate = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String orgGateOutDate = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String railItchgN2ndEtdDate = null;
	/* Column Info */
	private String creDate = null;
	/* Column Info */
	private String railItchgN1stEtdDate = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fcarNo = null;
	/* Column Info */
	private String itchgArrSplcLocNm = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String ibdCstmsClrLocCd = null;
	/* Column Info */
	private String ibIpiLoclIndCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String mstBlNo = null;
	/* Column Info */
	private String railTztmHrs = null;
	/* Column Info */
	private String cDate = null;
	/* Column Info */
	private String chgDate = null;
	/* Column Info */
	private String railDestN2ndEtaDate = null;
	/* Column Info */
	private String crntDwllTmHrs = null;
	/* Column Info */
	private String cgorOrgBlRcvrIndFlg = null;
	/* Column Info */
	private String itchgN1stDwllTmHrs = null;
	/* Column Info */
	private String rRailCoDestPntEtaDt = null;
	/* Column Info */
	private String orgDwllTmHrs = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String swoIssDate = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String railItchgN2ndEtaDate = null;
	/* Column Info */
	private String usaEdiCd = null;
	/* Column Info */
	private String arrSteCd = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String arrLocNm = null;
	/* Column Info */
	private String destAvailDate = null;
	/* Column Info */
	private String tztmDiffHrs = null;
	/* Column Info */
	private String itchgN2ndDwllTmHrs = null;
	/* Column Info */
	private String itchgHrs = null;
	/* Column Info */
	private String cstmsAcptFlg = null;
	/* Column Info */
	private String tmlDwllTmHrs = null;
	/* Column Info */
	private String orgDepFlg = null;
	/* Column Info */
	private String bkgHotDeFlg = null;
	/* Column Info */
	private String chgOutDate = null;
	/* Column Info */
	private String woVndrSeq = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String orgSplcLocNm = null;
	/* Column Info */
	private String vdDate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String railCoItchgPntEtaDt = null;
	/* Column Info */
	private String itchgN1stDepFlg = null;
	/* Column Info */
	private String tmlDepFlg = null;
	/* Column Info */
	private String railDestN1stEtaDate = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String dwllHrs = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String destN2ndDwllTmHrs = null;
	/* Column Info */
	private String orgGateInDate = null;
	/* Column Info */
	private String chgArrInDate = null;
	/* Column Info */
	private String itchgN2ndDepFlg = null;
	/* Column Info */
	private String railRunTmHrs = null;
	/* Column Info */
	private String destN2ndDepFlg = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String itchgSplcLocNm = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String destN1stDwllTmHrs = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String trnNo = null;
	/* Column Info */
	private String hldRmk = null;
	/* Column Info */
	private String avgTzHrs = null;
	/* Column Info */
	private String destOutDate = null;
	/* Column Info */
	private String cgorFrtPayIndFlg = null;
	/* Column Info */
	private String destLocNm = null;
	/* Column Info */
	private String destInDate = null;
	/* Column Info */
	private String destN1stDepFlg = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String hldFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRTRListVO() {}

	public SearchRTRListVO(String ibflag, String pagerows, String trspSoOfcCtyCd, String trspSoSeq, String eqNo, String eqTpszCd, String cgoTpCd, String vvdCd, String bkgNo, String mstBlNo, String scNo, String creDate, String swoIssDate, String usaEdiCd, String woVndrSeq, String fmNodCd, String toNodCd, String trspBndCd, String bkgHotDeFlg, String cgorFrtPayIndFlg, String cgorOrgBlRcvrIndFlg, String cstmsAcptFlg, String cDate, String ibIpiLoclIndCd, String ibdCstmsClrLocCd, String nodCd, String vdDate, String hldFlg, String hldRmk, String tmlDwllTmHrs, String tmlDepFlg, String orgSplcLocNm, String orgGateInDate, String orgDwllTmHrs, String orgDepFlg, String orgGateOutDate, String itchgArrSplcLocNm, String chgArrInDate, String itchgN1stDwllTmHrs, String itchgN1stDepFlg, String itchgSplcLocNm, String chgDate, String itchgN2ndDwllTmHrs, String itchgN2ndDepFlg, String chgOutDate, String destLocNm, String destInDate, String destN1stDwllTmHrs, String destN1stDepFlg, String destAvailDate, String destN2ndDwllTmHrs, String destN2ndDepFlg, String destOutDate, String railRunTmHrs, String railTztmHrs, String arrLocNm, String arrSteCd, String evntDate, String crntDwllTmHrs, String trnNo, String fcarNo, String cntrSealNo, String itchgHrs, String railCoItchgPntEtaDt, String railItchgN1stEtaDate, String railItchgN2ndEtaDate, String dwllHrs, String railItchgN1stEtdDate, String railItchgN2ndEtdDate, String avgTzHrs, String rRailCoDestPntEtaDt, String railDestN1stEtaDate, String railDestN2ndEtaDate, String tztmDiffHrs, String shprNm, String cneeNm, String ntfyNm) {
		this.toNodCd = toNodCd;
		this.railItchgN1stEtaDate = railItchgN1stEtaDate;
		this.evntDate = evntDate;
		this.trspSoSeq = trspSoSeq;
		this.orgGateOutDate = orgGateOutDate;
		this.cgoTpCd = cgoTpCd;
		this.railItchgN2ndEtdDate = railItchgN2ndEtdDate;
		this.creDate = creDate;
		this.railItchgN1stEtdDate = railItchgN1stEtdDate;
		this.pagerows = pagerows;
		this.fcarNo = fcarNo;
		this.itchgArrSplcLocNm = itchgArrSplcLocNm;
		this.vvdCd = vvdCd;
		this.ibdCstmsClrLocCd = ibdCstmsClrLocCd;
		this.ibIpiLoclIndCd = ibIpiLoclIndCd;
		this.scNo = scNo;
		this.mstBlNo = mstBlNo;
		this.railTztmHrs = railTztmHrs;
		this.cDate = cDate;
		this.chgDate = chgDate;
		this.railDestN2ndEtaDate = railDestN2ndEtaDate;
		this.crntDwllTmHrs = crntDwllTmHrs;
		this.cgorOrgBlRcvrIndFlg = cgorOrgBlRcvrIndFlg;
		this.itchgN1stDwllTmHrs = itchgN1stDwllTmHrs;
		this.rRailCoDestPntEtaDt = rRailCoDestPntEtaDt;
		this.orgDwllTmHrs = orgDwllTmHrs;
		this.eqTpszCd = eqTpszCd;
		this.swoIssDate = swoIssDate;
		this.bkgNo = bkgNo;
		this.railItchgN2ndEtaDate = railItchgN2ndEtaDate;
		this.usaEdiCd = usaEdiCd;
		this.arrSteCd = arrSteCd;
		this.nodCd = nodCd;
		this.arrLocNm = arrLocNm;
		this.destAvailDate = destAvailDate;
		this.tztmDiffHrs = tztmDiffHrs;
		this.itchgN2ndDwllTmHrs = itchgN2ndDwllTmHrs;
		this.itchgHrs = itchgHrs;
		this.cstmsAcptFlg = cstmsAcptFlg;
		this.tmlDwllTmHrs = tmlDwllTmHrs;
		this.orgDepFlg = orgDepFlg;
		this.bkgHotDeFlg = bkgHotDeFlg;
		this.chgOutDate = chgOutDate;
		this.woVndrSeq = woVndrSeq;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.orgSplcLocNm = orgSplcLocNm;
		this.vdDate = vdDate;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.railCoItchgPntEtaDt = railCoItchgPntEtaDt;
		this.itchgN1stDepFlg = itchgN1stDepFlg;
		this.tmlDepFlg = tmlDepFlg;
		this.railDestN1stEtaDate = railDestN1stEtaDate;
		this.shprNm = shprNm;
		this.dwllHrs = dwllHrs;
		this.trspBndCd = trspBndCd;
		this.destN2ndDwllTmHrs = destN2ndDwllTmHrs;
		this.orgGateInDate = orgGateInDate;
		this.chgArrInDate = chgArrInDate;
		this.itchgN2ndDepFlg = itchgN2ndDepFlg;
		this.railRunTmHrs = railRunTmHrs;
		this.destN2ndDepFlg = destN2ndDepFlg;
		this.ntfyNm = ntfyNm;
		this.itchgSplcLocNm = itchgSplcLocNm;
		this.fmNodCd = fmNodCd;
		this.destN1stDwllTmHrs = destN1stDwllTmHrs;
		this.cneeNm = cneeNm;
		this.trnNo = trnNo;
		this.hldRmk = hldRmk;
		this.avgTzHrs = avgTzHrs;
		this.destOutDate = destOutDate;
		this.cgorFrtPayIndFlg = cgorFrtPayIndFlg;
		this.destLocNm = destLocNm;
		this.destInDate = destInDate;
		this.destN1stDepFlg = destN1stDepFlg;
		this.cntrSealNo = cntrSealNo;
		this.hldFlg = hldFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("rail_itchg_n1st_eta_date", getRailItchgN1stEtaDate());
		this.hashColumns.put("evnt_date", getEvntDate());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("org_gate_out_date", getOrgGateOutDate());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("rail_itchg_n2nd_etd_date", getRailItchgN2ndEtdDate());
		this.hashColumns.put("cre_date", getCreDate());
		this.hashColumns.put("rail_itchg_n1st_etd_date", getRailItchgN1stEtdDate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fcar_no", getFcarNo());
		this.hashColumns.put("itchg_arr_splc_loc_nm", getItchgArrSplcLocNm());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("ibd_cstms_clr_loc_cd", getIbdCstmsClrLocCd());
		this.hashColumns.put("ib_ipi_locl_ind_cd", getIbIpiLoclIndCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("mst_bl_no", getMstBlNo());
		this.hashColumns.put("rail_tztm_hrs", getRailTztmHrs());
		this.hashColumns.put("c_date", getCDate());
		this.hashColumns.put("chg_date", getChgDate());
		this.hashColumns.put("rail_dest_n2nd_eta_date", getRailDestN2ndEtaDate());
		this.hashColumns.put("crnt_dwll_tm_hrs", getCrntDwllTmHrs());
		this.hashColumns.put("cgor_org_bl_rcvr_ind_flg", getCgorOrgBlRcvrIndFlg());
		this.hashColumns.put("itchg_n1st_dwll_tm_hrs", getItchgN1stDwllTmHrs());
		this.hashColumns.put("r_rail_co_dest_pnt_eta_dt", getRRailCoDestPntEtaDt());
		this.hashColumns.put("org_dwll_tm_hrs", getOrgDwllTmHrs());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("swo_iss_date", getSwoIssDate());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rail_itchg_n2nd_eta_date", getRailItchgN2ndEtaDate());
		this.hashColumns.put("usa_edi_cd", getUsaEdiCd());
		this.hashColumns.put("arr_ste_cd", getArrSteCd());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("arr_loc_nm", getArrLocNm());
		this.hashColumns.put("dest_avail_date", getDestAvailDate());
		this.hashColumns.put("tztm_diff_hrs", getTztmDiffHrs());
		this.hashColumns.put("itchg_n2nd_dwll_tm_hrs", getItchgN2ndDwllTmHrs());
		this.hashColumns.put("itchg_hrs", getItchgHrs());
		this.hashColumns.put("cstms_acpt_flg", getCstmsAcptFlg());
		this.hashColumns.put("tml_dwll_tm_hrs", getTmlDwllTmHrs());
		this.hashColumns.put("org_dep_flg", getOrgDepFlg());
		this.hashColumns.put("bkg_hot_de_flg", getBkgHotDeFlg());
		this.hashColumns.put("chg_out_date", getChgOutDate());
		this.hashColumns.put("wo_vndr_seq", getWoVndrSeq());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("org_splc_loc_nm", getOrgSplcLocNm());
		this.hashColumns.put("vd_date", getVdDate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("rail_co_itchg_pnt_eta_dt", getRailCoItchgPntEtaDt());
		this.hashColumns.put("itchg_n1st_dep_flg", getItchgN1stDepFlg());
		this.hashColumns.put("tml_dep_flg", getTmlDepFlg());
		this.hashColumns.put("rail_dest_n1st_eta_date", getRailDestN1stEtaDate());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("dwll_hrs", getDwllHrs());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("dest_n2nd_dwll_tm_hrs", getDestN2ndDwllTmHrs());
		this.hashColumns.put("org_gate_in_date", getOrgGateInDate());
		this.hashColumns.put("chg_arr_in_date", getChgArrInDate());
		this.hashColumns.put("itchg_n2nd_dep_flg", getItchgN2ndDepFlg());
		this.hashColumns.put("rail_run_tm_hrs", getRailRunTmHrs());
		this.hashColumns.put("dest_n2nd_dep_flg", getDestN2ndDepFlg());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("itchg_splc_loc_nm", getItchgSplcLocNm());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("dest_n1st_dwll_tm_hrs", getDestN1stDwllTmHrs());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("trn_no", getTrnNo());
		this.hashColumns.put("hld_rmk", getHldRmk());
		this.hashColumns.put("avg_tz_hrs", getAvgTzHrs());
		this.hashColumns.put("dest_out_date", getDestOutDate());
		this.hashColumns.put("cgor_frt_pay_ind_flg", getCgorFrtPayIndFlg());
		this.hashColumns.put("dest_loc_nm", getDestLocNm());
		this.hashColumns.put("dest_in_date", getDestInDate());
		this.hashColumns.put("dest_n1st_dep_flg", getDestN1stDepFlg());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("hld_flg", getHldFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("rail_itchg_n1st_eta_date", "railItchgN1stEtaDate");
		this.hashFields.put("evnt_date", "evntDate");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("org_gate_out_date", "orgGateOutDate");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("rail_itchg_n2nd_etd_date", "railItchgN2ndEtdDate");
		this.hashFields.put("cre_date", "creDate");
		this.hashFields.put("rail_itchg_n1st_etd_date", "railItchgN1stEtdDate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fcar_no", "fcarNo");
		this.hashFields.put("itchg_arr_splc_loc_nm", "itchgArrSplcLocNm");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("ibd_cstms_clr_loc_cd", "ibdCstmsClrLocCd");
		this.hashFields.put("ib_ipi_locl_ind_cd", "ibIpiLoclIndCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("mst_bl_no", "mstBlNo");
		this.hashFields.put("rail_tztm_hrs", "railTztmHrs");
		this.hashFields.put("c_date", "cDate");
		this.hashFields.put("chg_date", "chgDate");
		this.hashFields.put("rail_dest_n2nd_eta_date", "railDestN2ndEtaDate");
		this.hashFields.put("crnt_dwll_tm_hrs", "crntDwllTmHrs");
		this.hashFields.put("cgor_org_bl_rcvr_ind_flg", "cgorOrgBlRcvrIndFlg");
		this.hashFields.put("itchg_n1st_dwll_tm_hrs", "itchgN1stDwllTmHrs");
		this.hashFields.put("r_rail_co_dest_pnt_eta_dt", "rRailCoDestPntEtaDt");
		this.hashFields.put("org_dwll_tm_hrs", "orgDwllTmHrs");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("swo_iss_date", "swoIssDate");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rail_itchg_n2nd_eta_date", "railItchgN2ndEtaDate");
		this.hashFields.put("usa_edi_cd", "usaEdiCd");
		this.hashFields.put("arr_ste_cd", "arrSteCd");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("arr_loc_nm", "arrLocNm");
		this.hashFields.put("dest_avail_date", "destAvailDate");
		this.hashFields.put("tztm_diff_hrs", "tztmDiffHrs");
		this.hashFields.put("itchg_n2nd_dwll_tm_hrs", "itchgN2ndDwllTmHrs");
		this.hashFields.put("itchg_hrs", "itchgHrs");
		this.hashFields.put("cstms_acpt_flg", "cstmsAcptFlg");
		this.hashFields.put("tml_dwll_tm_hrs", "tmlDwllTmHrs");
		this.hashFields.put("org_dep_flg", "orgDepFlg");
		this.hashFields.put("bkg_hot_de_flg", "bkgHotDeFlg");
		this.hashFields.put("chg_out_date", "chgOutDate");
		this.hashFields.put("wo_vndr_seq", "woVndrSeq");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("org_splc_loc_nm", "orgSplcLocNm");
		this.hashFields.put("vd_date", "vdDate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("rail_co_itchg_pnt_eta_dt", "railCoItchgPntEtaDt");
		this.hashFields.put("itchg_n1st_dep_flg", "itchgN1stDepFlg");
		this.hashFields.put("tml_dep_flg", "tmlDepFlg");
		this.hashFields.put("rail_dest_n1st_eta_date", "railDestN1stEtaDate");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("dwll_hrs", "dwllHrs");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("dest_n2nd_dwll_tm_hrs", "destN2ndDwllTmHrs");
		this.hashFields.put("org_gate_in_date", "orgGateInDate");
		this.hashFields.put("chg_arr_in_date", "chgArrInDate");
		this.hashFields.put("itchg_n2nd_dep_flg", "itchgN2ndDepFlg");
		this.hashFields.put("rail_run_tm_hrs", "railRunTmHrs");
		this.hashFields.put("dest_n2nd_dep_flg", "destN2ndDepFlg");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("itchg_splc_loc_nm", "itchgSplcLocNm");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("dest_n1st_dwll_tm_hrs", "destN1stDwllTmHrs");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("trn_no", "trnNo");
		this.hashFields.put("hld_rmk", "hldRmk");
		this.hashFields.put("avg_tz_hrs", "avgTzHrs");
		this.hashFields.put("dest_out_date", "destOutDate");
		this.hashFields.put("cgor_frt_pay_ind_flg", "cgorFrtPayIndFlg");
		this.hashFields.put("dest_loc_nm", "destLocNm");
		this.hashFields.put("dest_in_date", "destInDate");
		this.hashFields.put("dest_n1st_dep_flg", "destN1stDepFlg");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("hld_flg", "hldFlg");
		return this.hashFields;
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
	 * @return railItchgN1stEtaDate
	 */
	public String getRailItchgN1stEtaDate() {
		return this.railItchgN1stEtaDate;
	}
	
	/**
	 * Column Info
	 * @return evntDate
	 */
	public String getEvntDate() {
		return this.evntDate;
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
	 * @return orgGateOutDate
	 */
	public String getOrgGateOutDate() {
		return this.orgGateOutDate;
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
	 * @return railItchgN2ndEtdDate
	 */
	public String getRailItchgN2ndEtdDate() {
		return this.railItchgN2ndEtdDate;
	}
	
	/**
	 * Column Info
	 * @return creDate
	 */
	public String getCreDate() {
		return this.creDate;
	}
	
	/**
	 * Column Info
	 * @return railItchgN1stEtdDate
	 */
	public String getRailItchgN1stEtdDate() {
		return this.railItchgN1stEtdDate;
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
	 * @return fcarNo
	 */
	public String getFcarNo() {
		return this.fcarNo;
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
	 * @return ibIpiLoclIndCd
	 */
	public String getIbIpiLoclIndCd() {
		return this.ibIpiLoclIndCd;
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
	 * @return railTztmHrs
	 */
	public String getRailTztmHrs() {
		return this.railTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return cDate
	 */
	public String getCDate() {
		return this.cDate;
	}
	
	/**
	 * Column Info
	 * @return chgDate
	 */
	public String getChgDate() {
		return this.chgDate;
	}
	
	/**
	 * Column Info
	 * @return railDestN2ndEtaDate
	 */
	public String getRailDestN2ndEtaDate() {
		return this.railDestN2ndEtaDate;
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
	 * @return rRailCoDestPntEtaDt
	 */
	public String getRRailCoDestPntEtaDt() {
		return this.rRailCoDestPntEtaDt;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return swoIssDate
	 */
	public String getSwoIssDate() {
		return this.swoIssDate;
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
	 * @return railItchgN2ndEtaDate
	 */
	public String getRailItchgN2ndEtaDate() {
		return this.railItchgN2ndEtaDate;
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
	 * @return arrLocNm
	 */
	public String getArrLocNm() {
		return this.arrLocNm;
	}
	
	/**
	 * Column Info
	 * @return destAvailDate
	 */
	public String getDestAvailDate() {
		return this.destAvailDate;
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
	 * @return itchgHrs
	 */
	public String getItchgHrs() {
		return this.itchgHrs;
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
	 * @return tmlDwllTmHrs
	 */
	public String getTmlDwllTmHrs() {
		return this.tmlDwllTmHrs;
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
	 * @return bkgHotDeFlg
	 */
	public String getBkgHotDeFlg() {
		return this.bkgHotDeFlg;
	}
	
	/**
	 * Column Info
	 * @return chgOutDate
	 */
	public String getChgOutDate() {
		return this.chgOutDate;
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
	 * @return vdDate
	 */
	public String getVdDate() {
		return this.vdDate;
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
	 * @return itchgN1stDepFlg
	 */
	public String getItchgN1stDepFlg() {
		return this.itchgN1stDepFlg;
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
	 * @return railDestN1stEtaDate
	 */
	public String getRailDestN1stEtaDate() {
		return this.railDestN1stEtaDate;
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
	 * @return dwllHrs
	 */
	public String getDwllHrs() {
		return this.dwllHrs;
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
	 * @return destN2ndDwllTmHrs
	 */
	public String getDestN2ndDwllTmHrs() {
		return this.destN2ndDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @return orgGateInDate
	 */
	public String getOrgGateInDate() {
		return this.orgGateInDate;
	}
	
	/**
	 * Column Info
	 * @return chgArrInDate
	 */
	public String getChgArrInDate() {
		return this.chgArrInDate;
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
	 * @return destN2ndDepFlg
	 */
	public String getDestN2ndDepFlg() {
		return this.destN2ndDepFlg;
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
	 * @return destN1stDwllTmHrs
	 */
	public String getDestN1stDwllTmHrs() {
		return this.destN1stDwllTmHrs;
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
	 * @return destOutDate
	 */
	public String getDestOutDate() {
		return this.destOutDate;
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
	 * @return destLocNm
	 */
	public String getDestLocNm() {
		return this.destLocNm;
	}
	
	/**
	 * Column Info
	 * @return destInDate
	 */
	public String getDestInDate() {
		return this.destInDate;
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
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param railItchgN1stEtaDate
	 */
	public void setRailItchgN1stEtaDate(String railItchgN1stEtaDate) {
		this.railItchgN1stEtaDate = railItchgN1stEtaDate;
	}
	
	/**
	 * Column Info
	 * @param evntDate
	 */
	public void setEvntDate(String evntDate) {
		this.evntDate = evntDate;
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
	 * @param orgGateOutDate
	 */
	public void setOrgGateOutDate(String orgGateOutDate) {
		this.orgGateOutDate = orgGateOutDate;
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
	 * @param railItchgN2ndEtdDate
	 */
	public void setRailItchgN2ndEtdDate(String railItchgN2ndEtdDate) {
		this.railItchgN2ndEtdDate = railItchgN2ndEtdDate;
	}
	
	/**
	 * Column Info
	 * @param creDate
	 */
	public void setCreDate(String creDate) {
		this.creDate = creDate;
	}
	
	/**
	 * Column Info
	 * @param railItchgN1stEtdDate
	 */
	public void setRailItchgN1stEtdDate(String railItchgN1stEtdDate) {
		this.railItchgN1stEtdDate = railItchgN1stEtdDate;
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
	 * @param fcarNo
	 */
	public void setFcarNo(String fcarNo) {
		this.fcarNo = fcarNo;
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
	 * @param ibIpiLoclIndCd
	 */
	public void setIbIpiLoclIndCd(String ibIpiLoclIndCd) {
		this.ibIpiLoclIndCd = ibIpiLoclIndCd;
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
	 * @param railTztmHrs
	 */
	public void setRailTztmHrs(String railTztmHrs) {
		this.railTztmHrs = railTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param cDate
	 */
	public void setCDate(String cDate) {
		this.cDate = cDate;
	}
	
	/**
	 * Column Info
	 * @param chgDate
	 */
	public void setChgDate(String chgDate) {
		this.chgDate = chgDate;
	}
	
	/**
	 * Column Info
	 * @param railDestN2ndEtaDate
	 */
	public void setRailDestN2ndEtaDate(String railDestN2ndEtaDate) {
		this.railDestN2ndEtaDate = railDestN2ndEtaDate;
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
	 * @param rRailCoDestPntEtaDt
	 */
	public void setRRailCoDestPntEtaDt(String rRailCoDestPntEtaDt) {
		this.rRailCoDestPntEtaDt = rRailCoDestPntEtaDt;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param swoIssDate
	 */
	public void setSwoIssDate(String swoIssDate) {
		this.swoIssDate = swoIssDate;
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
	 * @param railItchgN2ndEtaDate
	 */
	public void setRailItchgN2ndEtaDate(String railItchgN2ndEtaDate) {
		this.railItchgN2ndEtaDate = railItchgN2ndEtaDate;
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
	 * @param arrLocNm
	 */
	public void setArrLocNm(String arrLocNm) {
		this.arrLocNm = arrLocNm;
	}
	
	/**
	 * Column Info
	 * @param destAvailDate
	 */
	public void setDestAvailDate(String destAvailDate) {
		this.destAvailDate = destAvailDate;
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
	 * @param itchgHrs
	 */
	public void setItchgHrs(String itchgHrs) {
		this.itchgHrs = itchgHrs;
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
	 * @param tmlDwllTmHrs
	 */
	public void setTmlDwllTmHrs(String tmlDwllTmHrs) {
		this.tmlDwllTmHrs = tmlDwllTmHrs;
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
	 * @param bkgHotDeFlg
	 */
	public void setBkgHotDeFlg(String bkgHotDeFlg) {
		this.bkgHotDeFlg = bkgHotDeFlg;
	}
	
	/**
	 * Column Info
	 * @param chgOutDate
	 */
	public void setChgOutDate(String chgOutDate) {
		this.chgOutDate = chgOutDate;
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
	 * @param vdDate
	 */
	public void setVdDate(String vdDate) {
		this.vdDate = vdDate;
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
	 * @param itchgN1stDepFlg
	 */
	public void setItchgN1stDepFlg(String itchgN1stDepFlg) {
		this.itchgN1stDepFlg = itchgN1stDepFlg;
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
	 * @param railDestN1stEtaDate
	 */
	public void setRailDestN1stEtaDate(String railDestN1stEtaDate) {
		this.railDestN1stEtaDate = railDestN1stEtaDate;
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
	 * @param dwllHrs
	 */
	public void setDwllHrs(String dwllHrs) {
		this.dwllHrs = dwllHrs;
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
	 * @param destN2ndDwllTmHrs
	 */
	public void setDestN2ndDwllTmHrs(String destN2ndDwllTmHrs) {
		this.destN2ndDwllTmHrs = destN2ndDwllTmHrs;
	}
	
	/**
	 * Column Info
	 * @param orgGateInDate
	 */
	public void setOrgGateInDate(String orgGateInDate) {
		this.orgGateInDate = orgGateInDate;
	}
	
	/**
	 * Column Info
	 * @param chgArrInDate
	 */
	public void setChgArrInDate(String chgArrInDate) {
		this.chgArrInDate = chgArrInDate;
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
	 * @param destN2ndDepFlg
	 */
	public void setDestN2ndDepFlg(String destN2ndDepFlg) {
		this.destN2ndDepFlg = destN2ndDepFlg;
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
	 * @param destN1stDwllTmHrs
	 */
	public void setDestN1stDwllTmHrs(String destN1stDwllTmHrs) {
		this.destN1stDwllTmHrs = destN1stDwllTmHrs;
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
	 * @param destOutDate
	 */
	public void setDestOutDate(String destOutDate) {
		this.destOutDate = destOutDate;
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
	 * @param destLocNm
	 */
	public void setDestLocNm(String destLocNm) {
		this.destLocNm = destLocNm;
	}
	
	/**
	 * Column Info
	 * @param destInDate
	 */
	public void setDestInDate(String destInDate) {
		this.destInDate = destInDate;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToNodCd(JSPUtil.getParameter(request, "to_nod_cd", ""));
		setRailItchgN1stEtaDate(JSPUtil.getParameter(request, "rail_itchg_n1st_eta_date", ""));
		setEvntDate(JSPUtil.getParameter(request, "evnt_date", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, "trsp_so_seq", ""));
		setOrgGateOutDate(JSPUtil.getParameter(request, "org_gate_out_date", ""));
		setCgoTpCd(JSPUtil.getParameter(request, "cgo_tp_cd", ""));
		setRailItchgN2ndEtdDate(JSPUtil.getParameter(request, "rail_itchg_n2nd_etd_date", ""));
		setCreDate(JSPUtil.getParameter(request, "cre_date", ""));
		setRailItchgN1stEtdDate(JSPUtil.getParameter(request, "rail_itchg_n1st_etd_date", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFcarNo(JSPUtil.getParameter(request, "fcar_no", ""));
		setItchgArrSplcLocNm(JSPUtil.getParameter(request, "itchg_arr_splc_loc_nm", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setIbdCstmsClrLocCd(JSPUtil.getParameter(request, "ibd_cstms_clr_loc_cd", ""));
		setIbIpiLoclIndCd(JSPUtil.getParameter(request, "ib_ipi_locl_ind_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setMstBlNo(JSPUtil.getParameter(request, "mst_bl_no", ""));
		setRailTztmHrs(JSPUtil.getParameter(request, "rail_tztm_hrs", ""));
		setCDate(JSPUtil.getParameter(request, "c_date", ""));
		setChgDate(JSPUtil.getParameter(request, "chg_date", ""));
		setRailDestN2ndEtaDate(JSPUtil.getParameter(request, "rail_dest_n2nd_eta_date", ""));
		setCrntDwllTmHrs(JSPUtil.getParameter(request, "crnt_dwll_tm_hrs", ""));
		setCgorOrgBlRcvrIndFlg(JSPUtil.getParameter(request, "cgor_org_bl_rcvr_ind_flg", ""));
		setItchgN1stDwllTmHrs(JSPUtil.getParameter(request, "itchg_n1st_dwll_tm_hrs", ""));
		setRRailCoDestPntEtaDt(JSPUtil.getParameter(request, "r_rail_co_dest_pnt_eta_dt", ""));
		setOrgDwllTmHrs(JSPUtil.getParameter(request, "org_dwll_tm_hrs", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setSwoIssDate(JSPUtil.getParameter(request, "swo_iss_date", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setRailItchgN2ndEtaDate(JSPUtil.getParameter(request, "rail_itchg_n2nd_eta_date", ""));
		setUsaEdiCd(JSPUtil.getParameter(request, "usa_edi_cd", ""));
		setArrSteCd(JSPUtil.getParameter(request, "arr_ste_cd", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setArrLocNm(JSPUtil.getParameter(request, "arr_loc_nm", ""));
		setDestAvailDate(JSPUtil.getParameter(request, "dest_avail_date", ""));
		setTztmDiffHrs(JSPUtil.getParameter(request, "tztm_diff_hrs", ""));
		setItchgN2ndDwllTmHrs(JSPUtil.getParameter(request, "itchg_n2nd_dwll_tm_hrs", ""));
		setItchgHrs(JSPUtil.getParameter(request, "itchg_hrs", ""));
		setCstmsAcptFlg(JSPUtil.getParameter(request, "cstms_acpt_flg", ""));
		setTmlDwllTmHrs(JSPUtil.getParameter(request, "tml_dwll_tm_hrs", ""));
		setOrgDepFlg(JSPUtil.getParameter(request, "org_dep_flg", ""));
		setBkgHotDeFlg(JSPUtil.getParameter(request, "bkg_hot_de_flg", ""));
		setChgOutDate(JSPUtil.getParameter(request, "chg_out_date", ""));
		setWoVndrSeq(JSPUtil.getParameter(request, "wo_vndr_seq", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd", ""));
		setOrgSplcLocNm(JSPUtil.getParameter(request, "org_splc_loc_nm", ""));
		setVdDate(JSPUtil.getParameter(request, "vd_date", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setRailCoItchgPntEtaDt(JSPUtil.getParameter(request, "rail_co_itchg_pnt_eta_dt", ""));
		setItchgN1stDepFlg(JSPUtil.getParameter(request, "itchg_n1st_dep_flg", ""));
		setTmlDepFlg(JSPUtil.getParameter(request, "tml_dep_flg", ""));
		setRailDestN1stEtaDate(JSPUtil.getParameter(request, "rail_dest_n1st_eta_date", ""));
		setShprNm(JSPUtil.getParameter(request, "shpr_nm", ""));
		setDwllHrs(JSPUtil.getParameter(request, "dwll_hrs", ""));
		setTrspBndCd(JSPUtil.getParameter(request, "trsp_bnd_cd", ""));
		setDestN2ndDwllTmHrs(JSPUtil.getParameter(request, "dest_n2nd_dwll_tm_hrs", ""));
		setOrgGateInDate(JSPUtil.getParameter(request, "org_gate_in_date", ""));
		setChgArrInDate(JSPUtil.getParameter(request, "chg_arr_in_date", ""));
		setItchgN2ndDepFlg(JSPUtil.getParameter(request, "itchg_n2nd_dep_flg", ""));
		setRailRunTmHrs(JSPUtil.getParameter(request, "rail_run_tm_hrs", ""));
		setDestN2ndDepFlg(JSPUtil.getParameter(request, "dest_n2nd_dep_flg", ""));
		setNtfyNm(JSPUtil.getParameter(request, "ntfy_nm", ""));
		setItchgSplcLocNm(JSPUtil.getParameter(request, "itchg_splc_loc_nm", ""));
		setFmNodCd(JSPUtil.getParameter(request, "fm_nod_cd", ""));
		setDestN1stDwllTmHrs(JSPUtil.getParameter(request, "dest_n1st_dwll_tm_hrs", ""));
		setCneeNm(JSPUtil.getParameter(request, "cnee_nm", ""));
		setTrnNo(JSPUtil.getParameter(request, "trn_no", ""));
		setHldRmk(JSPUtil.getParameter(request, "hld_rmk", ""));
		setAvgTzHrs(JSPUtil.getParameter(request, "avg_tz_hrs", ""));
		setDestOutDate(JSPUtil.getParameter(request, "dest_out_date", ""));
		setCgorFrtPayIndFlg(JSPUtil.getParameter(request, "cgor_frt_pay_ind_flg", ""));
		setDestLocNm(JSPUtil.getParameter(request, "dest_loc_nm", ""));
		setDestInDate(JSPUtil.getParameter(request, "dest_in_date", ""));
		setDestN1stDepFlg(JSPUtil.getParameter(request, "dest_n1st_dep_flg", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setHldFlg(JSPUtil.getParameter(request, "hld_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRTRListVO[]
	 */
	public SearchRTRListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRTRListVO[]
	 */
	public SearchRTRListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRTRListVO model = null;
		String[] tmp = request.getParameterValues(prefix + "trsp_so_ofc_cty_cd");
		String[] tmp2 = request.getParameterValues(prefix + "cntr_no");
  		if(tmp == null && tmp2 == null) return null;
  		int length = (tmp != null && tmp2 == null) ? tmp.length : tmp2.length;
  		
		try {
			//String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "dest", length));
			String[] railItchgN1stEtaDate = (JSPUtil.getParameter(request, prefix	+ "rail_itchg_n1st_eta_date", length));
			String[] evntDate = (JSPUtil.getParameter(request, prefix	+ "evnt_date", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] orgGateOutDate = (JSPUtil.getParameter(request, prefix	+ "org_gate_out_date", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] railItchgN2ndEtdDate = (JSPUtil.getParameter(request, prefix	+ "rail_itchg_n2nd_etd_date", length));
			String[] creDate = (JSPUtil.getParameter(request, prefix	+ "cre_date", length));
			String[] railItchgN1stEtdDate = (JSPUtil.getParameter(request, prefix	+ "rail_itchg_n1st_etd_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fcarNo = (JSPUtil.getParameter(request, prefix	+ "fcar_no", length));
			String[] itchgArrSplcLocNm = (JSPUtil.getParameter(request, prefix	+ "itchg_arr_splc_loc_nm", length));
			//String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibdCstmsClrLocCd = (JSPUtil.getParameter(request, prefix	+ "ibd_cstms_clr_loc_cd", length));
			String[] ibIpiLoclIndCd = (JSPUtil.getParameter(request, prefix	+ "ib_ipi_locl_ind_cd", length));
			//String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "scno", length));
			//String[] mstBlNo = (JSPUtil.getParameter(request, prefix	+ "mst_bl_no", length));
			String[] mstBlNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] railTztmHrs = (JSPUtil.getParameter(request, prefix	+ "rail_tztm_hrs", length));
			String[] cDate = (JSPUtil.getParameter(request, prefix	+ "c_date", length));
			String[] chgDate = (JSPUtil.getParameter(request, prefix	+ "chg_date", length));
			String[] railDestN2ndEtaDate = (JSPUtil.getParameter(request, prefix	+ "rail_dest_n2nd_eta_date", length));
			String[] crntDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "crnt_dwll_tm_hrs", length));
			String[] cgorOrgBlRcvrIndFlg = (JSPUtil.getParameter(request, prefix	+ "cgor_org_bl_rcvr_ind_flg", length));
			String[] itchgN1stDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "itchg_n1st_dwll_tm_hrs", length));
			String[] rRailCoDestPntEtaDt = (JSPUtil.getParameter(request, prefix	+ "r_rail_co_dest_pnt_eta_dt", length));
			String[] orgDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "org_dwll_tm_hrs", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] swoIssDate = (JSPUtil.getParameter(request, prefix	+ "swo_iss_date", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] railItchgN2ndEtaDate = (JSPUtil.getParameter(request, prefix	+ "rail_itchg_n2nd_eta_date", length));
			String[] usaEdiCd = (JSPUtil.getParameter(request, prefix	+ "usa_edi_cd", length));
			String[] arrSteCd = (JSPUtil.getParameter(request, prefix	+ "arr_ste_cd", length));
			//String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "polpod", length));
			String[] arrLocNm = (JSPUtil.getParameter(request, prefix	+ "arr_loc_nm", length));
			String[] destAvailDate = (JSPUtil.getParameter(request, prefix	+ "dest_avail_date", length));
			String[] tztmDiffHrs = (JSPUtil.getParameter(request, prefix	+ "tztm_diff_hrs", length));
			String[] itchgN2ndDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "itchg_n2nd_dwll_tm_hrs", length));
			String[] itchgHrs = (JSPUtil.getParameter(request, prefix	+ "itchg_hrs", length));
			String[] cstmsAcptFlg = (JSPUtil.getParameter(request, prefix	+ "cstms_acpt_flg", length));
			String[] tmlDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "tml_dwll_tm_hrs", length));
			String[] orgDepFlg = (JSPUtil.getParameter(request, prefix	+ "org_dep_flg", length));
			String[] bkgHotDeFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_hot_de_flg", length));
			String[] chgOutDate = (JSPUtil.getParameter(request, prefix	+ "chg_out_date", length));
			String[] woVndrSeq = (JSPUtil.getParameter(request, prefix	+ "wo_vndr_seq", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] orgSplcLocNm = (JSPUtil.getParameter(request, prefix	+ "org_splc_loc_nm", length));
			String[] vdDate = (JSPUtil.getParameter(request, prefix	+ "vd_date", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] railCoItchgPntEtaDt = (JSPUtil.getParameter(request, prefix	+ "rail_co_itchg_pnt_eta_dt", length));
			String[] itchgN1stDepFlg = (JSPUtil.getParameter(request, prefix	+ "itchg_n1st_dep_flg", length));
			String[] tmlDepFlg = (JSPUtil.getParameter(request, prefix	+ "tml_dep_flg", length));
			String[] railDestN1stEtaDate = (JSPUtil.getParameter(request, prefix	+ "rail_dest_n1st_eta_date", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] dwllHrs = (JSPUtil.getParameter(request, prefix	+ "dwll_hrs", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] destN2ndDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "dest_n2nd_dwll_tm_hrs", length));
			String[] orgGateInDate = (JSPUtil.getParameter(request, prefix	+ "org_gate_in_date", length));
			String[] chgArrInDate = (JSPUtil.getParameter(request, prefix	+ "chg_arr_in_date", length));
			String[] itchgN2ndDepFlg = (JSPUtil.getParameter(request, prefix	+ "itchg_n2nd_dep_flg", length));
			String[] railRunTmHrs = (JSPUtil.getParameter(request, prefix	+ "rail_run_tm_hrs", length));
			String[] destN2ndDepFlg = (JSPUtil.getParameter(request, prefix	+ "dest_n2nd_dep_flg", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] itchgSplcLocNm = (JSPUtil.getParameter(request, prefix	+ "itchg_splc_loc_nm", length));
			//String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "origin", length));
			String[] destN1stDwllTmHrs = (JSPUtil.getParameter(request, prefix	+ "dest_n1st_dwll_tm_hrs", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] trnNo = (JSPUtil.getParameter(request, prefix	+ "trn_no", length));
			String[] hldRmk = (JSPUtil.getParameter(request, prefix	+ "hld_rmk", length));
			String[] avgTzHrs = (JSPUtil.getParameter(request, prefix	+ "avg_tz_hrs", length));
			String[] destOutDate = (JSPUtil.getParameter(request, prefix	+ "dest_out_date", length));
			String[] cgorFrtPayIndFlg = (JSPUtil.getParameter(request, prefix	+ "cgor_frt_pay_ind_flg", length));
			String[] destLocNm = (JSPUtil.getParameter(request, prefix	+ "dest_loc_nm", length));
			String[] destInDate = (JSPUtil.getParameter(request, prefix	+ "dest_in_date", length));
			String[] destN1stDepFlg = (JSPUtil.getParameter(request, prefix	+ "dest_n1st_dep_flg", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] hldFlg = (JSPUtil.getParameter(request, prefix	+ "hld_flg", length));
			
			
			
			for (int i = 0; i < length; i++) {
//				System.out.println ("trspSoOfcCtyCd["+i+"]="+trspSoOfcCtyCd[i]);
				model = new SearchRTRListVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (railItchgN1stEtaDate[i] != null)
					model.setRailItchgN1stEtaDate(railItchgN1stEtaDate[i]);
				if (evntDate[i] != null)
					model.setEvntDate(evntDate[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (orgGateOutDate[i] != null)
					model.setOrgGateOutDate(orgGateOutDate[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (railItchgN2ndEtdDate[i] != null)
					model.setRailItchgN2ndEtdDate(railItchgN2ndEtdDate[i]);
				if (creDate[i] != null)
					model.setCreDate(creDate[i]);
				if (railItchgN1stEtdDate[i] != null)
					model.setRailItchgN1stEtdDate(railItchgN1stEtdDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fcarNo[i] != null)
					model.setFcarNo(fcarNo[i]);
				if (itchgArrSplcLocNm[i] != null)
					model.setItchgArrSplcLocNm(itchgArrSplcLocNm[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (ibdCstmsClrLocCd[i] != null)
					model.setIbdCstmsClrLocCd(ibdCstmsClrLocCd[i]);
				if (ibIpiLoclIndCd[i] != null)
					model.setIbIpiLoclIndCd(ibIpiLoclIndCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (mstBlNo[i] != null)
					model.setMstBlNo(mstBlNo[i]);
				if (railTztmHrs[i] != null)
					model.setRailTztmHrs(railTztmHrs[i]);
				if (cDate[i] != null)
					model.setCDate(cDate[i]);
				if (chgDate[i] != null)
					model.setChgDate(chgDate[i]);
				if (railDestN2ndEtaDate[i] != null)
					model.setRailDestN2ndEtaDate(railDestN2ndEtaDate[i]);
				if (crntDwllTmHrs[i] != null)
					model.setCrntDwllTmHrs(crntDwllTmHrs[i]);
				if (cgorOrgBlRcvrIndFlg[i] != null)
					model.setCgorOrgBlRcvrIndFlg(cgorOrgBlRcvrIndFlg[i]);
				if (itchgN1stDwllTmHrs[i] != null)
					model.setItchgN1stDwllTmHrs(itchgN1stDwllTmHrs[i]);
				if (rRailCoDestPntEtaDt[i] != null)
					model.setRRailCoDestPntEtaDt(rRailCoDestPntEtaDt[i]);
				if (orgDwllTmHrs[i] != null)
					model.setOrgDwllTmHrs(orgDwllTmHrs[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (swoIssDate[i] != null)
					model.setSwoIssDate(swoIssDate[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (railItchgN2ndEtaDate[i] != null)
					model.setRailItchgN2ndEtaDate(railItchgN2ndEtaDate[i]);
				if (usaEdiCd[i] != null)
					model.setUsaEdiCd(usaEdiCd[i]);
				if (arrSteCd[i] != null)
					model.setArrSteCd(arrSteCd[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (arrLocNm[i] != null)
					model.setArrLocNm(arrLocNm[i]);
				if (destAvailDate[i] != null)
					model.setDestAvailDate(destAvailDate[i]);
				if (tztmDiffHrs[i] != null)
					model.setTztmDiffHrs(tztmDiffHrs[i]);
				if (itchgN2ndDwllTmHrs[i] != null)
					model.setItchgN2ndDwllTmHrs(itchgN2ndDwllTmHrs[i]);
				if (itchgHrs[i] != null)
					model.setItchgHrs(itchgHrs[i]);
				if (cstmsAcptFlg[i] != null)
					model.setCstmsAcptFlg(cstmsAcptFlg[i]);
				if (tmlDwllTmHrs[i] != null)
					model.setTmlDwllTmHrs(tmlDwllTmHrs[i]);
				if (orgDepFlg[i] != null)
					model.setOrgDepFlg(orgDepFlg[i]);
				if (bkgHotDeFlg[i] != null)
					model.setBkgHotDeFlg(bkgHotDeFlg[i]);
				if (chgOutDate[i] != null)
					model.setChgOutDate(chgOutDate[i]);
				if (woVndrSeq[i] != null)
					model.setWoVndrSeq(woVndrSeq[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (orgSplcLocNm[i] != null)
					model.setOrgSplcLocNm(orgSplcLocNm[i]);
				if (vdDate[i] != null)
					model.setVdDate(vdDate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (railCoItchgPntEtaDt[i] != null)
					model.setRailCoItchgPntEtaDt(railCoItchgPntEtaDt[i]);
				if (itchgN1stDepFlg[i] != null)
					model.setItchgN1stDepFlg(itchgN1stDepFlg[i]);
				if (tmlDepFlg[i] != null)
					model.setTmlDepFlg(tmlDepFlg[i]);
				if (railDestN1stEtaDate[i] != null)
					model.setRailDestN1stEtaDate(railDestN1stEtaDate[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (dwllHrs[i] != null)
					model.setDwllHrs(dwllHrs[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (destN2ndDwllTmHrs[i] != null)
					model.setDestN2ndDwllTmHrs(destN2ndDwllTmHrs[i]);
				if (orgGateInDate[i] != null)
					model.setOrgGateInDate(orgGateInDate[i]);
				if (chgArrInDate[i] != null)
					model.setChgArrInDate(chgArrInDate[i]);
				if (itchgN2ndDepFlg[i] != null)
					model.setItchgN2ndDepFlg(itchgN2ndDepFlg[i]);
				if (railRunTmHrs[i] != null)
					model.setRailRunTmHrs(railRunTmHrs[i]);
				if (destN2ndDepFlg[i] != null)
					model.setDestN2ndDepFlg(destN2ndDepFlg[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (itchgSplcLocNm[i] != null)
					model.setItchgSplcLocNm(itchgSplcLocNm[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (destN1stDwllTmHrs[i] != null)
					model.setDestN1stDwllTmHrs(destN1stDwllTmHrs[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (trnNo[i] != null)
					model.setTrnNo(trnNo[i]);
				if (hldRmk[i] != null)
					model.setHldRmk(hldRmk[i]);
				if (avgTzHrs[i] != null)
					model.setAvgTzHrs(avgTzHrs[i]);
				if (destOutDate[i] != null)
					model.setDestOutDate(destOutDate[i]);
				if (cgorFrtPayIndFlg[i] != null)
					model.setCgorFrtPayIndFlg(cgorFrtPayIndFlg[i]);
				if (destLocNm[i] != null)
					model.setDestLocNm(destLocNm[i]);
				if (destInDate[i] != null)
					model.setDestInDate(destInDate[i]);
				if (destN1stDepFlg[i] != null)
					model.setDestN1stDepFlg(destN1stDepFlg[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (hldFlg[i] != null)
					model.setHldFlg(hldFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			e.toString();
			return null;
		}
		return getSearchRTRListVOs();
	}

	
	/**
	 * VO 배열을 반환
	 * @return SearchRTRListVO[]
	 */
	public SearchRTRListVO[] getSearchRTRListVOs(){
		SearchRTRListVO[] vos = (SearchRTRListVO[])models.toArray(new SearchRTRListVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railItchgN1stEtaDate = this.railItchgN1stEtaDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDate = this.evntDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgGateOutDate = this.orgGateOutDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railItchgN2ndEtdDate = this.railItchgN2ndEtdDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDate = this.creDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railItchgN1stEtdDate = this.railItchgN1stEtdDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcarNo = this.fcarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgArrSplcLocNm = this.itchgArrSplcLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdCstmsClrLocCd = this.ibdCstmsClrLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibIpiLoclIndCd = this.ibIpiLoclIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBlNo = this.mstBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railTztmHrs = this.railTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cDate = this.cDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDate = this.chgDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railDestN2ndEtaDate = this.railDestN2ndEtaDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntDwllTmHrs = this.crntDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorOrgBlRcvrIndFlg = this.cgorOrgBlRcvrIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgN1stDwllTmHrs = this.itchgN1stDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rRailCoDestPntEtaDt = this.rRailCoDestPntEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDwllTmHrs = this.orgDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.swoIssDate = this.swoIssDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railItchgN2ndEtaDate = this.railItchgN2ndEtaDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaEdiCd = this.usaEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrSteCd = this.arrSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLocNm = this.arrLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destAvailDate = this.destAvailDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tztmDiffHrs = this.tztmDiffHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgN2ndDwllTmHrs = this.itchgN2ndDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgHrs = this.itchgHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAcptFlg = this.cstmsAcptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlDwllTmHrs = this.tmlDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDepFlg = this.orgDepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHotDeFlg = this.bkgHotDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgOutDate = this.chgOutDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woVndrSeq = this.woVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSplcLocNm = this.orgSplcLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vdDate = this.vdDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCoItchgPntEtaDt = this.railCoItchgPntEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgN1stDepFlg = this.itchgN1stDepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlDepFlg = this.tmlDepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railDestN1stEtaDate = this.railDestN1stEtaDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwllHrs = this.dwllHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destN2ndDwllTmHrs = this.destN2ndDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgGateInDate = this.orgGateInDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgArrInDate = this.chgArrInDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgN2ndDepFlg = this.itchgN2ndDepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railRunTmHrs = this.railRunTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destN2ndDepFlg = this.destN2ndDepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgSplcLocNm = this.itchgSplcLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destN1stDwllTmHrs = this.destN1stDwllTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnNo = this.trnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldRmk = this.hldRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgTzHrs = this.avgTzHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destOutDate = this.destOutDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorFrtPayIndFlg = this.cgorFrtPayIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocNm = this.destLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destInDate = this.destInDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destN1stDepFlg = this.destN1stDepFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldFlg = this.hldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
