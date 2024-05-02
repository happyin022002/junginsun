/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchIHCAmendmentHistoryDetailVO.java
*@FileTitle : SearchIHCAmendmentHistoryDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.10
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.03.10 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchIHCAmendmentHistoryDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchIHCAmendmentHistoryDetailVO> models = new ArrayList<SearchIHCAmendmentHistoryDetailVO>();
	
	/* Column Info */
	private String diff40ft = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String pntLocCd = null;
	/* Column Info */
	private String diffLocl45ft = null;
	/* Column Info */
	private String loclCurrCost20ftFrtRtAmt = null;
	/* Column Info */
	private String glineLoclCurr20ftAmt = null;
	/* Column Info */
	private String loclCurrCost45ftFrtRtAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String glineDg20ftFrtRtAmt = null;
	/* Column Info */
	private String cost20ftTrkFrtRtAmt = null;
	/* Column Info */
	private String loclCurrCost40ftFrtRtAmt = null;
	/* Column Info */
	private String diffTrk20ft = null;
	/* Column Info */
	private String trsp45ftAgmtWgt = null;
	/* Column Info */
	private String gline45ftFrtRtAmt = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String trsp20ftAgmtWgt = null;
	/* Column Info */
	private String glineLoclCurr45ftAmt = null;
	/* Column Info */
	private String gline20ftRailFrtRtAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String glineLoclCurrDg40ftAmt = null;
	/* Column Info */
	private String bsePortLocCd = null;
	/* Column Info */
	private String ihcTrfNo = null;
	/* Column Info */
	private String trsp40ftAgmtWgt = null;
	/* Column Info */
	private String cost40ftFrtRtAmt = null;
	/* Column Info */
	private String detailTp = null;
	/* Column Info */
	private String diffTrk40ft = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String cost40ftRailFrtRtAmt = null;
	/* Column Info */
	private String glineLoclCurr40ftAmt = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String nextN1stCmncAmdtSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String diffLocl20ft = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String diff45ft = null;
	/* Column Info */
	private String prcTrspModCd = null;
	/* Column Info */
	private String glineLoclCurrDg45ftAmt = null;
	/* Column Info */
	private String gline20ftTrkFrtRtAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cost20ftRailFrtRtAmt = null;
	/* Column Info */
	private String pntLocNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cost45ftFrtRtAmt = null;
	/* Column Info */
	private String prcTrfCreTpCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String diffLocl40ft = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cost40ftTrkFrtRtAmt = null;
	/* Column Info */
	private String diffRail40ft = null;
	/* Column Info */
	private String glineLoclCurrDg20ftAmt = null;
	/* Column Info */
	private String gline20ftFrtRtAmt = null;
	/* Column Info */
	private String gline40ftRailFrtRtAmt = null;
	/* Column Info */
	private String glineDg45ftFrtRtAmt = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String diff20ft = null;
	/* Column Info */
	private String cost20ftFrtRtAmt = null;
	/* Column Info */
	private String gline40ftTrkFrtRtAmt = null;
	/* Column Info */
	private String gline40ftFrtRtAmt = null;
	/* Column Info */
	private String diffRail20ft = null;
	/* Column Info */
	private String glineDg40ftFrtRtAmt = null;
	/* Column Info */
	private String ihcCgoTpCd = null;
	/* Column Info */
	private String hubLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchIHCAmendmentHistoryDetailVO() {}

	public SearchIHCAmendmentHistoryDetailVO(String ibflag, String pagerows, String diff40ft, String amdtSeq, String svcScpCd, String pntLocCd, String loclCurrCost20ftFrtRtAmt, String glineLoclCurr20ftAmt, String effDt, String glineDg20ftFrtRtAmt, String cost20ftTrkFrtRtAmt, String loclCurrCost40ftFrtRtAmt, String diffTrk20ft, String rcvDeTermCd, String trsp20ftAgmtWgt, String updUsrId, String gline20ftRailFrtRtAmt, String bsePortLocCd, String glineLoclCurrDg40ftAmt, String ihcTrfNo, String trsp40ftAgmtWgt, String detailTp, String cost40ftFrtRtAmt, String orgDestTpCd, String diffTrk40ft, String cost40ftRailFrtRtAmt, String glineLoclCurr40ftAmt, String rtSeq, String nextN1stCmncAmdtSeq, String creUsrId, String diffLocl20ft, String n1stCmncAmdtSeq, String prcTrspModCd, String gline20ftTrkFrtRtAmt, String creDt, String cost20ftRailFrtRtAmt, String pntLocNm, String prcTrfCreTpCd, String expDt, String diffLocl40ft, String updDt, String cost40ftTrkFrtRtAmt, String diffRail40ft, String glineLoclCurrDg20ftAmt, String gline20ftFrtRtAmt, String gline40ftRailFrtRtAmt, String srcInfoCd, String diff20ft, String cost20ftFrtRtAmt, String gline40ftTrkFrtRtAmt, String gline40ftFrtRtAmt, String diffRail20ft, String glineDg40ftFrtRtAmt, String ihcCgoTpCd, String hubLocCd, String gline45ftFrtRtAmt, String glineDg45ftFrtRtAmt, String glineLoclCurr45ftAmt, String glineLoclCurrDg45ftAmt, String diff45ft, String diffLocl45ft, String cost45ftFrtRtAmt, String loclCurrCost45ftFrtRtAmt, String trsp45ftAgmtWgt) {
		this.diff40ft = diff40ft;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.pntLocCd = pntLocCd;
		this.diffLocl45ft = diffLocl45ft;
		this.loclCurrCost20ftFrtRtAmt = loclCurrCost20ftFrtRtAmt;
		this.glineLoclCurr20ftAmt = glineLoclCurr20ftAmt;
		this.loclCurrCost45ftFrtRtAmt = loclCurrCost45ftFrtRtAmt;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.glineDg20ftFrtRtAmt = glineDg20ftFrtRtAmt;
		this.cost20ftTrkFrtRtAmt = cost20ftTrkFrtRtAmt;
		this.loclCurrCost40ftFrtRtAmt = loclCurrCost40ftFrtRtAmt;
		this.diffTrk20ft = diffTrk20ft;
		this.trsp45ftAgmtWgt = trsp45ftAgmtWgt;
		this.gline45ftFrtRtAmt = gline45ftFrtRtAmt;
		this.rcvDeTermCd = rcvDeTermCd;
		this.trsp20ftAgmtWgt = trsp20ftAgmtWgt;
		this.glineLoclCurr45ftAmt = glineLoclCurr45ftAmt;
		this.gline20ftRailFrtRtAmt = gline20ftRailFrtRtAmt;
		this.updUsrId = updUsrId;
		this.glineLoclCurrDg40ftAmt = glineLoclCurrDg40ftAmt;
		this.bsePortLocCd = bsePortLocCd;
		this.ihcTrfNo = ihcTrfNo;
		this.trsp40ftAgmtWgt = trsp40ftAgmtWgt;
		this.cost40ftFrtRtAmt = cost40ftFrtRtAmt;
		this.detailTp = detailTp;
		this.diffTrk40ft = diffTrk40ft;
		this.orgDestTpCd = orgDestTpCd;
		this.cost40ftRailFrtRtAmt = cost40ftRailFrtRtAmt;
		this.glineLoclCurr40ftAmt = glineLoclCurr40ftAmt;
		this.rtSeq = rtSeq;
		this.nextN1stCmncAmdtSeq = nextN1stCmncAmdtSeq;
		this.creUsrId = creUsrId;
		this.diffLocl20ft = diffLocl20ft;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.diff45ft = diff45ft;
		this.prcTrspModCd = prcTrspModCd;
		this.glineLoclCurrDg45ftAmt = glineLoclCurrDg45ftAmt;
		this.gline20ftTrkFrtRtAmt = gline20ftTrkFrtRtAmt;
		this.creDt = creDt;
		this.cost20ftRailFrtRtAmt = cost20ftRailFrtRtAmt;
		this.pntLocNm = pntLocNm;
		this.ibflag = ibflag;
		this.cost45ftFrtRtAmt = cost45ftFrtRtAmt;
		this.prcTrfCreTpCd = prcTrfCreTpCd;
		this.expDt = expDt;
		this.diffLocl40ft = diffLocl40ft;
		this.updDt = updDt;
		this.cost40ftTrkFrtRtAmt = cost40ftTrkFrtRtAmt;
		this.diffRail40ft = diffRail40ft;
		this.glineLoclCurrDg20ftAmt = glineLoclCurrDg20ftAmt;
		this.gline20ftFrtRtAmt = gline20ftFrtRtAmt;
		this.gline40ftRailFrtRtAmt = gline40ftRailFrtRtAmt;
		this.glineDg45ftFrtRtAmt = glineDg45ftFrtRtAmt;
		this.srcInfoCd = srcInfoCd;
		this.diff20ft = diff20ft;
		this.cost20ftFrtRtAmt = cost20ftFrtRtAmt;
		this.gline40ftTrkFrtRtAmt = gline40ftTrkFrtRtAmt;
		this.gline40ftFrtRtAmt = gline40ftFrtRtAmt;
		this.diffRail20ft = diffRail20ft;
		this.glineDg40ftFrtRtAmt = glineDg40ftFrtRtAmt;
		this.ihcCgoTpCd = ihcCgoTpCd;
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("diff_40ft", getDiff40ft());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pnt_loc_cd", getPntLocCd());
		this.hashColumns.put("diff_locl_45ft", getDiffLocl45ft());
		this.hashColumns.put("locl_curr_cost_20ft_frt_rt_amt", getLoclCurrCost20ftFrtRtAmt());
		this.hashColumns.put("gline_locl_curr_20ft_amt", getGlineLoclCurr20ftAmt());
		this.hashColumns.put("locl_curr_cost_45ft_frt_rt_amt", getLoclCurrCost45ftFrtRtAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("gline_dg_20ft_frt_rt_amt", getGlineDg20ftFrtRtAmt());
		this.hashColumns.put("cost_20ft_trk_frt_rt_amt", getCost20ftTrkFrtRtAmt());
		this.hashColumns.put("locl_curr_cost_40ft_frt_rt_amt", getLoclCurrCost40ftFrtRtAmt());
		this.hashColumns.put("diff_trk_20ft", getDiffTrk20ft());
		this.hashColumns.put("trsp_45ft_agmt_wgt", getTrsp45ftAgmtWgt());
		this.hashColumns.put("gline_45ft_frt_rt_amt", getGline45ftFrtRtAmt());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("trsp_20ft_agmt_wgt", getTrsp20ftAgmtWgt());
		this.hashColumns.put("gline_locl_curr_45ft_amt", getGlineLoclCurr45ftAmt());
		this.hashColumns.put("gline_20ft_rail_frt_rt_amt", getGline20ftRailFrtRtAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("gline_locl_curr_dg_40ft_amt", getGlineLoclCurrDg40ftAmt());
		this.hashColumns.put("bse_port_loc_cd", getBsePortLocCd());
		this.hashColumns.put("ihc_trf_no", getIhcTrfNo());
		this.hashColumns.put("trsp_40ft_agmt_wgt", getTrsp40ftAgmtWgt());
		this.hashColumns.put("cost_40ft_frt_rt_amt", getCost40ftFrtRtAmt());
		this.hashColumns.put("detail_tp", getDetailTp());
		this.hashColumns.put("diff_trk_40ft", getDiffTrk40ft());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("cost_40ft_rail_frt_rt_amt", getCost40ftRailFrtRtAmt());
		this.hashColumns.put("gline_locl_curr_40ft_amt", getGlineLoclCurr40ftAmt());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("next_n1st_cmnc_amdt_seq", getNextN1stCmncAmdtSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("diff_locl_20ft", getDiffLocl20ft());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("diff_45ft", getDiff45ft());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("gline_locl_curr_dg_45ft_amt", getGlineLoclCurrDg45ftAmt());
		this.hashColumns.put("gline_20ft_trk_frt_rt_amt", getGline20ftTrkFrtRtAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cost_20ft_rail_frt_rt_amt", getCost20ftRailFrtRtAmt());
		this.hashColumns.put("pnt_loc_nm", getPntLocNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_45ft_frt_rt_amt", getCost45ftFrtRtAmt());
		this.hashColumns.put("prc_trf_cre_tp_cd", getPrcTrfCreTpCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("diff_locl_40ft", getDiffLocl40ft());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cost_40ft_trk_frt_rt_amt", getCost40ftTrkFrtRtAmt());
		this.hashColumns.put("diff_rail_40ft", getDiffRail40ft());
		this.hashColumns.put("gline_locl_curr_dg_20ft_amt", getGlineLoclCurrDg20ftAmt());
		this.hashColumns.put("gline_20ft_frt_rt_amt", getGline20ftFrtRtAmt());
		this.hashColumns.put("gline_40ft_rail_frt_rt_amt", getGline40ftRailFrtRtAmt());
		this.hashColumns.put("gline_dg_45ft_frt_rt_amt", getGlineDg45ftFrtRtAmt());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("diff_20ft", getDiff20ft());
		this.hashColumns.put("cost_20ft_frt_rt_amt", getCost20ftFrtRtAmt());
		this.hashColumns.put("gline_40ft_trk_frt_rt_amt", getGline40ftTrkFrtRtAmt());
		this.hashColumns.put("gline_40ft_frt_rt_amt", getGline40ftFrtRtAmt());
		this.hashColumns.put("diff_rail_20ft", getDiffRail20ft());
		this.hashColumns.put("gline_dg_40ft_frt_rt_amt", getGlineDg40ftFrtRtAmt());
		this.hashColumns.put("ihc_cgo_tp_cd", getIhcCgoTpCd());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("diff_40ft", "diff40ft");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pnt_loc_cd", "pntLocCd");
		this.hashFields.put("diff_locl_45ft", "diffLocl45ft");
		this.hashFields.put("locl_curr_cost_20ft_frt_rt_amt", "loclCurrCost20ftFrtRtAmt");
		this.hashFields.put("gline_locl_curr_20ft_amt", "glineLoclCurr20ftAmt");
		this.hashFields.put("locl_curr_cost_45ft_frt_rt_amt", "loclCurrCost45ftFrtRtAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("gline_dg_20ft_frt_rt_amt", "glineDg20ftFrtRtAmt");
		this.hashFields.put("cost_20ft_trk_frt_rt_amt", "cost20ftTrkFrtRtAmt");
		this.hashFields.put("locl_curr_cost_40ft_frt_rt_amt", "loclCurrCost40ftFrtRtAmt");
		this.hashFields.put("diff_trk_20ft", "diffTrk20ft");
		this.hashFields.put("trsp_45ft_agmt_wgt", "trsp45ftAgmtWgt");
		this.hashFields.put("gline_45ft_frt_rt_amt", "gline45ftFrtRtAmt");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("trsp_20ft_agmt_wgt", "trsp20ftAgmtWgt");
		this.hashFields.put("gline_locl_curr_45ft_amt", "glineLoclCurr45ftAmt");
		this.hashFields.put("gline_20ft_rail_frt_rt_amt", "gline20ftRailFrtRtAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("gline_locl_curr_dg_40ft_amt", "glineLoclCurrDg40ftAmt");
		this.hashFields.put("bse_port_loc_cd", "bsePortLocCd");
		this.hashFields.put("ihc_trf_no", "ihcTrfNo");
		this.hashFields.put("trsp_40ft_agmt_wgt", "trsp40ftAgmtWgt");
		this.hashFields.put("cost_40ft_frt_rt_amt", "cost40ftFrtRtAmt");
		this.hashFields.put("detail_tp", "detailTp");
		this.hashFields.put("diff_trk_40ft", "diffTrk40ft");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("cost_40ft_rail_frt_rt_amt", "cost40ftRailFrtRtAmt");
		this.hashFields.put("gline_locl_curr_40ft_amt", "glineLoclCurr40ftAmt");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("next_n1st_cmnc_amdt_seq", "nextN1stCmncAmdtSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_locl_20ft", "diffLocl20ft");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("diff_45ft", "diff45ft");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("gline_locl_curr_dg_45ft_amt", "glineLoclCurrDg45ftAmt");
		this.hashFields.put("gline_20ft_trk_frt_rt_amt", "gline20ftTrkFrtRtAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cost_20ft_rail_frt_rt_amt", "cost20ftRailFrtRtAmt");
		this.hashFields.put("pnt_loc_nm", "pntLocNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_45ft_frt_rt_amt", "cost45ftFrtRtAmt");
		this.hashFields.put("prc_trf_cre_tp_cd", "prcTrfCreTpCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("diff_locl_40ft", "diffLocl40ft");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cost_40ft_trk_frt_rt_amt", "cost40ftTrkFrtRtAmt");
		this.hashFields.put("diff_rail_40ft", "diffRail40ft");
		this.hashFields.put("gline_locl_curr_dg_20ft_amt", "glineLoclCurrDg20ftAmt");
		this.hashFields.put("gline_20ft_frt_rt_amt", "gline20ftFrtRtAmt");
		this.hashFields.put("gline_40ft_rail_frt_rt_amt", "gline40ftRailFrtRtAmt");
		this.hashFields.put("gline_dg_45ft_frt_rt_amt", "glineDg45ftFrtRtAmt");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("diff_20ft", "diff20ft");
		this.hashFields.put("cost_20ft_frt_rt_amt", "cost20ftFrtRtAmt");
		this.hashFields.put("gline_40ft_trk_frt_rt_amt", "gline40ftTrkFrtRtAmt");
		this.hashFields.put("gline_40ft_frt_rt_amt", "gline40ftFrtRtAmt");
		this.hashFields.put("diff_rail_20ft", "diffRail20ft");
		this.hashFields.put("gline_dg_40ft_frt_rt_amt", "glineDg40ftFrtRtAmt");
		this.hashFields.put("ihc_cgo_tp_cd", "ihcCgoTpCd");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return diff40ft
	 */
	public String getDiff40ft() {
		return this.diff40ft;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
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
	 * @return pntLocCd
	 */
	public String getPntLocCd() {
		return this.pntLocCd;
	}
	
	/**
	 * Column Info
	 * @return diffLocl45ft
	 */
	public String getDiffLocl45ft() {
		return this.diffLocl45ft;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCost20ftFrtRtAmt
	 */
	public String getLoclCurrCost20ftFrtRtAmt() {
		return this.loclCurrCost20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return glineLoclCurr20ftAmt
	 */
	public String getGlineLoclCurr20ftAmt() {
		return this.glineLoclCurr20ftAmt;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCost45ftFrtRtAmt
	 */
	public String getLoclCurrCost45ftFrtRtAmt() {
		return this.loclCurrCost45ftFrtRtAmt;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return glineDg20ftFrtRtAmt
	 */
	public String getGlineDg20ftFrtRtAmt() {
		return this.glineDg20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cost20ftTrkFrtRtAmt
	 */
	public String getCost20ftTrkFrtRtAmt() {
		return this.cost20ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCost40ftFrtRtAmt
	 */
	public String getLoclCurrCost40ftFrtRtAmt() {
		return this.loclCurrCost40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return diffTrk20ft
	 */
	public String getDiffTrk20ft() {
		return this.diffTrk20ft;
	}
	
	/**
	 * Column Info
	 * @return trsp45ftAgmtWgt
	 */
	public String getTrsp45ftAgmtWgt() {
		return this.trsp45ftAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @return gline45ftFrtRtAmt
	 */
	public String getGline45ftFrtRtAmt() {
		return this.gline45ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return trsp20ftAgmtWgt
	 */
	public String getTrsp20ftAgmtWgt() {
		return this.trsp20ftAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @return glineLoclCurr45ftAmt
	 */
	public String getGlineLoclCurr45ftAmt() {
		return this.glineLoclCurr45ftAmt;
	}
	
	/**
	 * Column Info
	 * @return gline20ftRailFrtRtAmt
	 */
	public String getGline20ftRailFrtRtAmt() {
		return this.gline20ftRailFrtRtAmt;
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
	 * @return glineLoclCurrDg40ftAmt
	 */
	public String getGlineLoclCurrDg40ftAmt() {
		return this.glineLoclCurrDg40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return bsePortLocCd
	 */
	public String getBsePortLocCd() {
		return this.bsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @return ihcTrfNo
	 */
	public String getIhcTrfNo() {
		return this.ihcTrfNo;
	}
	
	/**
	 * Column Info
	 * @return trsp40ftAgmtWgt
	 */
	public String getTrsp40ftAgmtWgt() {
		return this.trsp40ftAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @return cost40ftFrtRtAmt
	 */
	public String getCost40ftFrtRtAmt() {
		return this.cost40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return detailTp
	 */
	public String getDetailTp() {
		return this.detailTp;
	}
	
	/**
	 * Column Info
	 * @return diffTrk40ft
	 */
	public String getDiffTrk40ft() {
		return this.diffTrk40ft;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return cost40ftRailFrtRtAmt
	 */
	public String getCost40ftRailFrtRtAmt() {
		return this.cost40ftRailFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return glineLoclCurr40ftAmt
	 */
	public String getGlineLoclCurr40ftAmt() {
		return this.glineLoclCurr40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
	}
	
	/**
	 * Column Info
	 * @return nextN1stCmncAmdtSeq
	 */
	public String getNextN1stCmncAmdtSeq() {
		return this.nextN1stCmncAmdtSeq;
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
	 * @return diffLocl20ft
	 */
	public String getDiffLocl20ft() {
		return this.diffLocl20ft;
	}
	
	/**
	 * Column Info
	 * @return n1stCmncAmdtSeq
	 */
	public String getN1stCmncAmdtSeq() {
		return this.n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return diff45ft
	 */
	public String getDiff45ft() {
		return this.diff45ft;
	}
	
	/**
	 * Column Info
	 * @return prcTrspModCd
	 */
	public String getPrcTrspModCd() {
		return this.prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return glineLoclCurrDg45ftAmt
	 */
	public String getGlineLoclCurrDg45ftAmt() {
		return this.glineLoclCurrDg45ftAmt;
	}
	
	/**
	 * Column Info
	 * @return gline20ftTrkFrtRtAmt
	 */
	public String getGline20ftTrkFrtRtAmt() {
		return this.gline20ftTrkFrtRtAmt;
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
	 * @return cost20ftRailFrtRtAmt
	 */
	public String getCost20ftRailFrtRtAmt() {
		return this.cost20ftRailFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return pntLocNm
	 */
	public String getPntLocNm() {
		return this.pntLocNm;
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
	 * @return cost45ftFrtRtAmt
	 */
	public String getCost45ftFrtRtAmt() {
		return this.cost45ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return prcTrfCreTpCd
	 */
	public String getPrcTrfCreTpCd() {
		return this.prcTrfCreTpCd;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return diffLocl40ft
	 */
	public String getDiffLocl40ft() {
		return this.diffLocl40ft;
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
	 * @return cost40ftTrkFrtRtAmt
	 */
	public String getCost40ftTrkFrtRtAmt() {
		return this.cost40ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return diffRail40ft
	 */
	public String getDiffRail40ft() {
		return this.diffRail40ft;
	}
	
	/**
	 * Column Info
	 * @return glineLoclCurrDg20ftAmt
	 */
	public String getGlineLoclCurrDg20ftAmt() {
		return this.glineLoclCurrDg20ftAmt;
	}
	
	/**
	 * Column Info
	 * @return gline20ftFrtRtAmt
	 */
	public String getGline20ftFrtRtAmt() {
		return this.gline20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return gline40ftRailFrtRtAmt
	 */
	public String getGline40ftRailFrtRtAmt() {
		return this.gline40ftRailFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return glineDg45ftFrtRtAmt
	 */
	public String getGlineDg45ftFrtRtAmt() {
		return this.glineDg45ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return srcInfoCd
	 */
	public String getSrcInfoCd() {
		return this.srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @return diff20ft
	 */
	public String getDiff20ft() {
		return this.diff20ft;
	}
	
	/**
	 * Column Info
	 * @return cost20ftFrtRtAmt
	 */
	public String getCost20ftFrtRtAmt() {
		return this.cost20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return gline40ftTrkFrtRtAmt
	 */
	public String getGline40ftTrkFrtRtAmt() {
		return this.gline40ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return gline40ftFrtRtAmt
	 */
	public String getGline40ftFrtRtAmt() {
		return this.gline40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return diffRail20ft
	 */
	public String getDiffRail20ft() {
		return this.diffRail20ft;
	}
	
	/**
	 * Column Info
	 * @return glineDg40ftFrtRtAmt
	 */
	public String getGlineDg40ftFrtRtAmt() {
		return this.glineDg40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ihcCgoTpCd
	 */
	public String getIhcCgoTpCd() {
		return this.ihcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
	}
	

	/**
	 * Column Info
	 * @param diff40ft
	 */
	public void setDiff40ft(String diff40ft) {
		this.diff40ft = diff40ft;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
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
	 * @param pntLocCd
	 */
	public void setPntLocCd(String pntLocCd) {
		this.pntLocCd = pntLocCd;
	}
	
	/**
	 * Column Info
	 * @param diffLocl45ft
	 */
	public void setDiffLocl45ft(String diffLocl45ft) {
		this.diffLocl45ft = diffLocl45ft;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCost20ftFrtRtAmt
	 */
	public void setLoclCurrCost20ftFrtRtAmt(String loclCurrCost20ftFrtRtAmt) {
		this.loclCurrCost20ftFrtRtAmt = loclCurrCost20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param glineLoclCurr20ftAmt
	 */
	public void setGlineLoclCurr20ftAmt(String glineLoclCurr20ftAmt) {
		this.glineLoclCurr20ftAmt = glineLoclCurr20ftAmt;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCost45ftFrtRtAmt
	 */
	public void setLoclCurrCost45ftFrtRtAmt(String loclCurrCost45ftFrtRtAmt) {
		this.loclCurrCost45ftFrtRtAmt = loclCurrCost45ftFrtRtAmt;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param glineDg20ftFrtRtAmt
	 */
	public void setGlineDg20ftFrtRtAmt(String glineDg20ftFrtRtAmt) {
		this.glineDg20ftFrtRtAmt = glineDg20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param cost20ftTrkFrtRtAmt
	 */
	public void setCost20ftTrkFrtRtAmt(String cost20ftTrkFrtRtAmt) {
		this.cost20ftTrkFrtRtAmt = cost20ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCost40ftFrtRtAmt
	 */
	public void setLoclCurrCost40ftFrtRtAmt(String loclCurrCost40ftFrtRtAmt) {
		this.loclCurrCost40ftFrtRtAmt = loclCurrCost40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param diffTrk20ft
	 */
	public void setDiffTrk20ft(String diffTrk20ft) {
		this.diffTrk20ft = diffTrk20ft;
	}
	
	/**
	 * Column Info
	 * @param trsp45ftAgmtWgt
	 */
	public void setTrsp45ftAgmtWgt(String trsp45ftAgmtWgt) {
		this.trsp45ftAgmtWgt = trsp45ftAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @param gline45ftFrtRtAmt
	 */
	public void setGline45ftFrtRtAmt(String gline45ftFrtRtAmt) {
		this.gline45ftFrtRtAmt = gline45ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param trsp20ftAgmtWgt
	 */
	public void setTrsp20ftAgmtWgt(String trsp20ftAgmtWgt) {
		this.trsp20ftAgmtWgt = trsp20ftAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @param glineLoclCurr45ftAmt
	 */
	public void setGlineLoclCurr45ftAmt(String glineLoclCurr45ftAmt) {
		this.glineLoclCurr45ftAmt = glineLoclCurr45ftAmt;
	}
	
	/**
	 * Column Info
	 * @param gline20ftRailFrtRtAmt
	 */
	public void setGline20ftRailFrtRtAmt(String gline20ftRailFrtRtAmt) {
		this.gline20ftRailFrtRtAmt = gline20ftRailFrtRtAmt;
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
	 * @param glineLoclCurrDg40ftAmt
	 */
	public void setGlineLoclCurrDg40ftAmt(String glineLoclCurrDg40ftAmt) {
		this.glineLoclCurrDg40ftAmt = glineLoclCurrDg40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param bsePortLocCd
	 */
	public void setBsePortLocCd(String bsePortLocCd) {
		this.bsePortLocCd = bsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @param ihcTrfNo
	 */
	public void setIhcTrfNo(String ihcTrfNo) {
		this.ihcTrfNo = ihcTrfNo;
	}
	
	/**
	 * Column Info
	 * @param trsp40ftAgmtWgt
	 */
	public void setTrsp40ftAgmtWgt(String trsp40ftAgmtWgt) {
		this.trsp40ftAgmtWgt = trsp40ftAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @param cost40ftFrtRtAmt
	 */
	public void setCost40ftFrtRtAmt(String cost40ftFrtRtAmt) {
		this.cost40ftFrtRtAmt = cost40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param detailTp
	 */
	public void setDetailTp(String detailTp) {
		this.detailTp = detailTp;
	}
	
	/**
	 * Column Info
	 * @param diffTrk40ft
	 */
	public void setDiffTrk40ft(String diffTrk40ft) {
		this.diffTrk40ft = diffTrk40ft;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param cost40ftRailFrtRtAmt
	 */
	public void setCost40ftRailFrtRtAmt(String cost40ftRailFrtRtAmt) {
		this.cost40ftRailFrtRtAmt = cost40ftRailFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param glineLoclCurr40ftAmt
	 */
	public void setGlineLoclCurr40ftAmt(String glineLoclCurr40ftAmt) {
		this.glineLoclCurr40ftAmt = glineLoclCurr40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
	}
	
	/**
	 * Column Info
	 * @param nextN1stCmncAmdtSeq
	 */
	public void setNextN1stCmncAmdtSeq(String nextN1stCmncAmdtSeq) {
		this.nextN1stCmncAmdtSeq = nextN1stCmncAmdtSeq;
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
	 * @param diffLocl20ft
	 */
	public void setDiffLocl20ft(String diffLocl20ft) {
		this.diffLocl20ft = diffLocl20ft;
	}
	
	/**
	 * Column Info
	 * @param n1stCmncAmdtSeq
	 */
	public void setN1stCmncAmdtSeq(String n1stCmncAmdtSeq) {
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param diff45ft
	 */
	public void setDiff45ft(String diff45ft) {
		this.diff45ft = diff45ft;
	}
	
	/**
	 * Column Info
	 * @param prcTrspModCd
	 */
	public void setPrcTrspModCd(String prcTrspModCd) {
		this.prcTrspModCd = prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param glineLoclCurrDg45ftAmt
	 */
	public void setGlineLoclCurrDg45ftAmt(String glineLoclCurrDg45ftAmt) {
		this.glineLoclCurrDg45ftAmt = glineLoclCurrDg45ftAmt;
	}
	
	/**
	 * Column Info
	 * @param gline20ftTrkFrtRtAmt
	 */
	public void setGline20ftTrkFrtRtAmt(String gline20ftTrkFrtRtAmt) {
		this.gline20ftTrkFrtRtAmt = gline20ftTrkFrtRtAmt;
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
	 * @param cost20ftRailFrtRtAmt
	 */
	public void setCost20ftRailFrtRtAmt(String cost20ftRailFrtRtAmt) {
		this.cost20ftRailFrtRtAmt = cost20ftRailFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param pntLocNm
	 */
	public void setPntLocNm(String pntLocNm) {
		this.pntLocNm = pntLocNm;
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
	 * @param cost45ftFrtRtAmt
	 */
	public void setCost45ftFrtRtAmt(String cost45ftFrtRtAmt) {
		this.cost45ftFrtRtAmt = cost45ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param prcTrfCreTpCd
	 */
	public void setPrcTrfCreTpCd(String prcTrfCreTpCd) {
		this.prcTrfCreTpCd = prcTrfCreTpCd;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param diffLocl40ft
	 */
	public void setDiffLocl40ft(String diffLocl40ft) {
		this.diffLocl40ft = diffLocl40ft;
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
	 * @param cost40ftTrkFrtRtAmt
	 */
	public void setCost40ftTrkFrtRtAmt(String cost40ftTrkFrtRtAmt) {
		this.cost40ftTrkFrtRtAmt = cost40ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param diffRail40ft
	 */
	public void setDiffRail40ft(String diffRail40ft) {
		this.diffRail40ft = diffRail40ft;
	}
	
	/**
	 * Column Info
	 * @param glineLoclCurrDg20ftAmt
	 */
	public void setGlineLoclCurrDg20ftAmt(String glineLoclCurrDg20ftAmt) {
		this.glineLoclCurrDg20ftAmt = glineLoclCurrDg20ftAmt;
	}
	
	/**
	 * Column Info
	 * @param gline20ftFrtRtAmt
	 */
	public void setGline20ftFrtRtAmt(String gline20ftFrtRtAmt) {
		this.gline20ftFrtRtAmt = gline20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param gline40ftRailFrtRtAmt
	 */
	public void setGline40ftRailFrtRtAmt(String gline40ftRailFrtRtAmt) {
		this.gline40ftRailFrtRtAmt = gline40ftRailFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param glineDg45ftFrtRtAmt
	 */
	public void setGlineDg45ftFrtRtAmt(String glineDg45ftFrtRtAmt) {
		this.glineDg45ftFrtRtAmt = glineDg45ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @param diff20ft
	 */
	public void setDiff20ft(String diff20ft) {
		this.diff20ft = diff20ft;
	}
	
	/**
	 * Column Info
	 * @param cost20ftFrtRtAmt
	 */
	public void setCost20ftFrtRtAmt(String cost20ftFrtRtAmt) {
		this.cost20ftFrtRtAmt = cost20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param gline40ftTrkFrtRtAmt
	 */
	public void setGline40ftTrkFrtRtAmt(String gline40ftTrkFrtRtAmt) {
		this.gline40ftTrkFrtRtAmt = gline40ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param gline40ftFrtRtAmt
	 */
	public void setGline40ftFrtRtAmt(String gline40ftFrtRtAmt) {
		this.gline40ftFrtRtAmt = gline40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param diffRail20ft
	 */
	public void setDiffRail20ft(String diffRail20ft) {
		this.diffRail20ft = diffRail20ft;
	}
	
	/**
	 * Column Info
	 * @param glineDg40ftFrtRtAmt
	 */
	public void setGlineDg40ftFrtRtAmt(String glineDg40ftFrtRtAmt) {
		this.glineDg40ftFrtRtAmt = glineDg40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ihcCgoTpCd
	 */
	public void setIhcCgoTpCd(String ihcCgoTpCd) {
		this.ihcCgoTpCd = ihcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
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
		setDiff40ft(JSPUtil.getParameter(request, prefix + "diff_40ft", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPntLocCd(JSPUtil.getParameter(request, prefix + "pnt_loc_cd", ""));
		setDiffLocl45ft(JSPUtil.getParameter(request, prefix + "diff_locl_45ft", ""));
		setLoclCurrCost20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "locl_curr_cost_20ft_frt_rt_amt", ""));
		setGlineLoclCurr20ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_20ft_amt", ""));
		setLoclCurrCost45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "locl_curr_cost_45ft_frt_rt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setGlineDg20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_dg_20ft_frt_rt_amt", ""));
		setCost20ftTrkFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_20ft_trk_frt_rt_amt", ""));
		setLoclCurrCost40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "locl_curr_cost_40ft_frt_rt_amt", ""));
		setDiffTrk20ft(JSPUtil.getParameter(request, prefix + "diff_trk_20ft", ""));
		setTrsp45ftAgmtWgt(JSPUtil.getParameter(request, prefix + "trsp_45ft_agmt_wgt", ""));
		setGline45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_45ft_frt_rt_amt", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setTrsp20ftAgmtWgt(JSPUtil.getParameter(request, prefix + "trsp_20ft_agmt_wgt", ""));
		setGlineLoclCurr45ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_45ft_amt", ""));
		setGline20ftRailFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_20ft_rail_frt_rt_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setGlineLoclCurrDg40ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_dg_40ft_amt", ""));
		setBsePortLocCd(JSPUtil.getParameter(request, prefix + "bse_port_loc_cd", ""));
		setIhcTrfNo(JSPUtil.getParameter(request, prefix + "ihc_trf_no", ""));
		setTrsp40ftAgmtWgt(JSPUtil.getParameter(request, prefix + "trsp_40ft_agmt_wgt", ""));
		setCost40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_40ft_frt_rt_amt", ""));
		setDetailTp(JSPUtil.getParameter(request, prefix + "detail_tp", ""));
		setDiffTrk40ft(JSPUtil.getParameter(request, prefix + "diff_trk_40ft", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setCost40ftRailFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_40ft_rail_frt_rt_amt", ""));
		setGlineLoclCurr40ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_40ft_amt", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setNextN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "next_n1st_cmnc_amdt_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDiffLocl20ft(JSPUtil.getParameter(request, prefix + "diff_locl_20ft", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setDiff45ft(JSPUtil.getParameter(request, prefix + "diff_45ft", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd", ""));
		setGlineLoclCurrDg45ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_dg_45ft_amt", ""));
		setGline20ftTrkFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_20ft_trk_frt_rt_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCost20ftRailFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_20ft_rail_frt_rt_amt", ""));
		setPntLocNm(JSPUtil.getParameter(request, prefix + "pnt_loc_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCost45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_45ft_frt_rt_amt", ""));
		setPrcTrfCreTpCd(JSPUtil.getParameter(request, prefix + "prc_trf_cre_tp_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setDiffLocl40ft(JSPUtil.getParameter(request, prefix + "diff_locl_40ft", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCost40ftTrkFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_40ft_trk_frt_rt_amt", ""));
		setDiffRail40ft(JSPUtil.getParameter(request, prefix + "diff_rail_40ft", ""));
		setGlineLoclCurrDg20ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_dg_20ft_amt", ""));
		setGline20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_20ft_frt_rt_amt", ""));
		setGline40ftRailFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_40ft_rail_frt_rt_amt", ""));
		setGlineDg45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_dg_45ft_frt_rt_amt", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, prefix + "src_info_cd", ""));
		setDiff20ft(JSPUtil.getParameter(request, prefix + "diff_20ft", ""));
		setCost20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_20ft_frt_rt_amt", ""));
		setGline40ftTrkFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_40ft_trk_frt_rt_amt", ""));
		setGline40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_40ft_frt_rt_amt", ""));
		setDiffRail20ft(JSPUtil.getParameter(request, prefix + "diff_rail_20ft", ""));
		setGlineDg40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_dg_40ft_frt_rt_amt", ""));
		setIhcCgoTpCd(JSPUtil.getParameter(request, prefix + "ihc_cgo_tp_cd", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchIHCAmendmentHistoryDetailVO[]
	 */
	public SearchIHCAmendmentHistoryDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchIHCAmendmentHistoryDetailVO[]
	 */
	public SearchIHCAmendmentHistoryDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchIHCAmendmentHistoryDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] diff40ft = (JSPUtil.getParameter(request, prefix	+ "diff_40ft", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] pntLocCd = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_cd", length));
			String[] diffLocl45ft = (JSPUtil.getParameter(request, prefix	+ "diff_locl_45ft", length));
			String[] loclCurrCost20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cost_20ft_frt_rt_amt", length));
			String[] glineLoclCurr20ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_20ft_amt", length));
			String[] loclCurrCost45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cost_45ft_frt_rt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] glineDg20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_dg_20ft_frt_rt_amt", length));
			String[] cost20ftTrkFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_20ft_trk_frt_rt_amt", length));
			String[] loclCurrCost40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cost_40ft_frt_rt_amt", length));
			String[] diffTrk20ft = (JSPUtil.getParameter(request, prefix	+ "diff_trk_20ft", length));
			String[] trsp45ftAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_agmt_wgt", length));
			String[] gline45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_45ft_frt_rt_amt", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] trsp20ftAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_agmt_wgt", length));
			String[] glineLoclCurr45ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_45ft_amt", length));
			String[] gline20ftRailFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_20ft_rail_frt_rt_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] glineLoclCurrDg40ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_dg_40ft_amt", length));
			String[] bsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_loc_cd", length));
			String[] ihcTrfNo = (JSPUtil.getParameter(request, prefix	+ "ihc_trf_no", length));
			String[] trsp40ftAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_agmt_wgt", length));
			String[] cost40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_40ft_frt_rt_amt", length));
			String[] detailTp = (JSPUtil.getParameter(request, prefix	+ "detail_tp", length));
			String[] diffTrk40ft = (JSPUtil.getParameter(request, prefix	+ "diff_trk_40ft", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] cost40ftRailFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_40ft_rail_frt_rt_amt", length));
			String[] glineLoclCurr40ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_40ft_amt", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] nextN1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "next_n1st_cmnc_amdt_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] diffLocl20ft = (JSPUtil.getParameter(request, prefix	+ "diff_locl_20ft", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] diff45ft = (JSPUtil.getParameter(request, prefix	+ "diff_45ft", length));
			String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd", length));
			String[] glineLoclCurrDg45ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_dg_45ft_amt", length));
			String[] gline20ftTrkFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_20ft_trk_frt_rt_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cost20ftRailFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_20ft_rail_frt_rt_amt", length));
			String[] pntLocNm = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cost45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_45ft_frt_rt_amt", length));
			String[] prcTrfCreTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_trf_cre_tp_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] diffLocl40ft = (JSPUtil.getParameter(request, prefix	+ "diff_locl_40ft", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cost40ftTrkFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_40ft_trk_frt_rt_amt", length));
			String[] diffRail40ft = (JSPUtil.getParameter(request, prefix	+ "diff_rail_40ft", length));
			String[] glineLoclCurrDg20ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_dg_20ft_amt", length));
			String[] gline20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_20ft_frt_rt_amt", length));
			String[] gline40ftRailFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_40ft_rail_frt_rt_amt", length));
			String[] glineDg45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_dg_45ft_frt_rt_amt", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] diff20ft = (JSPUtil.getParameter(request, prefix	+ "diff_20ft", length));
			String[] cost20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_20ft_frt_rt_amt", length));
			String[] gline40ftTrkFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_40ft_trk_frt_rt_amt", length));
			String[] gline40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_40ft_frt_rt_amt", length));
			String[] diffRail20ft = (JSPUtil.getParameter(request, prefix	+ "diff_rail_20ft", length));
			String[] glineDg40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_dg_40ft_frt_rt_amt", length));
			String[] ihcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "ihc_cgo_tp_cd", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchIHCAmendmentHistoryDetailVO();
				if (diff40ft[i] != null)
					model.setDiff40ft(diff40ft[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (pntLocCd[i] != null)
					model.setPntLocCd(pntLocCd[i]);
				if (diffLocl45ft[i] != null)
					model.setDiffLocl45ft(diffLocl45ft[i]);
				if (loclCurrCost20ftFrtRtAmt[i] != null)
					model.setLoclCurrCost20ftFrtRtAmt(loclCurrCost20ftFrtRtAmt[i]);
				if (glineLoclCurr20ftAmt[i] != null)
					model.setGlineLoclCurr20ftAmt(glineLoclCurr20ftAmt[i]);
				if (loclCurrCost45ftFrtRtAmt[i] != null)
					model.setLoclCurrCost45ftFrtRtAmt(loclCurrCost45ftFrtRtAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (glineDg20ftFrtRtAmt[i] != null)
					model.setGlineDg20ftFrtRtAmt(glineDg20ftFrtRtAmt[i]);
				if (cost20ftTrkFrtRtAmt[i] != null)
					model.setCost20ftTrkFrtRtAmt(cost20ftTrkFrtRtAmt[i]);
				if (loclCurrCost40ftFrtRtAmt[i] != null)
					model.setLoclCurrCost40ftFrtRtAmt(loclCurrCost40ftFrtRtAmt[i]);
				if (diffTrk20ft[i] != null)
					model.setDiffTrk20ft(diffTrk20ft[i]);
				if (trsp45ftAgmtWgt[i] != null)
					model.setTrsp45ftAgmtWgt(trsp45ftAgmtWgt[i]);
				if (gline45ftFrtRtAmt[i] != null)
					model.setGline45ftFrtRtAmt(gline45ftFrtRtAmt[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (trsp20ftAgmtWgt[i] != null)
					model.setTrsp20ftAgmtWgt(trsp20ftAgmtWgt[i]);
				if (glineLoclCurr45ftAmt[i] != null)
					model.setGlineLoclCurr45ftAmt(glineLoclCurr45ftAmt[i]);
				if (gline20ftRailFrtRtAmt[i] != null)
					model.setGline20ftRailFrtRtAmt(gline20ftRailFrtRtAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (glineLoclCurrDg40ftAmt[i] != null)
					model.setGlineLoclCurrDg40ftAmt(glineLoclCurrDg40ftAmt[i]);
				if (bsePortLocCd[i] != null)
					model.setBsePortLocCd(bsePortLocCd[i]);
				if (ihcTrfNo[i] != null)
					model.setIhcTrfNo(ihcTrfNo[i]);
				if (trsp40ftAgmtWgt[i] != null)
					model.setTrsp40ftAgmtWgt(trsp40ftAgmtWgt[i]);
				if (cost40ftFrtRtAmt[i] != null)
					model.setCost40ftFrtRtAmt(cost40ftFrtRtAmt[i]);
				if (detailTp[i] != null)
					model.setDetailTp(detailTp[i]);
				if (diffTrk40ft[i] != null)
					model.setDiffTrk40ft(diffTrk40ft[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (cost40ftRailFrtRtAmt[i] != null)
					model.setCost40ftRailFrtRtAmt(cost40ftRailFrtRtAmt[i]);
				if (glineLoclCurr40ftAmt[i] != null)
					model.setGlineLoclCurr40ftAmt(glineLoclCurr40ftAmt[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (nextN1stCmncAmdtSeq[i] != null)
					model.setNextN1stCmncAmdtSeq(nextN1stCmncAmdtSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (diffLocl20ft[i] != null)
					model.setDiffLocl20ft(diffLocl20ft[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (diff45ft[i] != null)
					model.setDiff45ft(diff45ft[i]);
				if (prcTrspModCd[i] != null)
					model.setPrcTrspModCd(prcTrspModCd[i]);
				if (glineLoclCurrDg45ftAmt[i] != null)
					model.setGlineLoclCurrDg45ftAmt(glineLoclCurrDg45ftAmt[i]);
				if (gline20ftTrkFrtRtAmt[i] != null)
					model.setGline20ftTrkFrtRtAmt(gline20ftTrkFrtRtAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cost20ftRailFrtRtAmt[i] != null)
					model.setCost20ftRailFrtRtAmt(cost20ftRailFrtRtAmt[i]);
				if (pntLocNm[i] != null)
					model.setPntLocNm(pntLocNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cost45ftFrtRtAmt[i] != null)
					model.setCost45ftFrtRtAmt(cost45ftFrtRtAmt[i]);
				if (prcTrfCreTpCd[i] != null)
					model.setPrcTrfCreTpCd(prcTrfCreTpCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (diffLocl40ft[i] != null)
					model.setDiffLocl40ft(diffLocl40ft[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cost40ftTrkFrtRtAmt[i] != null)
					model.setCost40ftTrkFrtRtAmt(cost40ftTrkFrtRtAmt[i]);
				if (diffRail40ft[i] != null)
					model.setDiffRail40ft(diffRail40ft[i]);
				if (glineLoclCurrDg20ftAmt[i] != null)
					model.setGlineLoclCurrDg20ftAmt(glineLoclCurrDg20ftAmt[i]);
				if (gline20ftFrtRtAmt[i] != null)
					model.setGline20ftFrtRtAmt(gline20ftFrtRtAmt[i]);
				if (gline40ftRailFrtRtAmt[i] != null)
					model.setGline40ftRailFrtRtAmt(gline40ftRailFrtRtAmt[i]);
				if (glineDg45ftFrtRtAmt[i] != null)
					model.setGlineDg45ftFrtRtAmt(glineDg45ftFrtRtAmt[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (diff20ft[i] != null)
					model.setDiff20ft(diff20ft[i]);
				if (cost20ftFrtRtAmt[i] != null)
					model.setCost20ftFrtRtAmt(cost20ftFrtRtAmt[i]);
				if (gline40ftTrkFrtRtAmt[i] != null)
					model.setGline40ftTrkFrtRtAmt(gline40ftTrkFrtRtAmt[i]);
				if (gline40ftFrtRtAmt[i] != null)
					model.setGline40ftFrtRtAmt(gline40ftFrtRtAmt[i]);
				if (diffRail20ft[i] != null)
					model.setDiffRail20ft(diffRail20ft[i]);
				if (glineDg40ftFrtRtAmt[i] != null)
					model.setGlineDg40ftFrtRtAmt(glineDg40ftFrtRtAmt[i]);
				if (ihcCgoTpCd[i] != null)
					model.setIhcCgoTpCd(ihcCgoTpCd[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchIHCAmendmentHistoryDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchIHCAmendmentHistoryDetailVO[]
	 */
	public SearchIHCAmendmentHistoryDetailVO[] getSearchIHCAmendmentHistoryDetailVOs(){
		SearchIHCAmendmentHistoryDetailVO[] vos = (SearchIHCAmendmentHistoryDetailVO[])models.toArray(new SearchIHCAmendmentHistoryDetailVO[models.size()]);
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
		this.diff40ft = this.diff40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocCd = this.pntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffLocl45ft = this.diffLocl45ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCost20ftFrtRtAmt = this.loclCurrCost20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurr20ftAmt = this.glineLoclCurr20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCost45ftFrtRtAmt = this.loclCurrCost45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineDg20ftFrtRtAmt = this.glineDg20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost20ftTrkFrtRtAmt = this.cost20ftTrkFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCost40ftFrtRtAmt = this.loclCurrCost40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffTrk20ft = this.diffTrk20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftAgmtWgt = this.trsp45ftAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline45ftFrtRtAmt = this.gline45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftAgmtWgt = this.trsp20ftAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurr45ftAmt = this.glineLoclCurr45ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline20ftRailFrtRtAmt = this.gline20ftRailFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurrDg40ftAmt = this.glineLoclCurrDg40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortLocCd = this.bsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfNo = this.ihcTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftAgmtWgt = this.trsp40ftAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost40ftFrtRtAmt = this.cost40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailTp = this.detailTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffTrk40ft = this.diffTrk40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost40ftRailFrtRtAmt = this.cost40ftRailFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurr40ftAmt = this.glineLoclCurr40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextN1stCmncAmdtSeq = this.nextN1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffLocl20ft = this.diffLocl20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff45ft = this.diff45ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd = this.prcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurrDg45ftAmt = this.glineLoclCurrDg45ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline20ftTrkFrtRtAmt = this.gline20ftTrkFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost20ftRailFrtRtAmt = this.cost20ftRailFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocNm = this.pntLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost45ftFrtRtAmt = this.cost45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrfCreTpCd = this.prcTrfCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffLocl40ft = this.diffLocl40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost40ftTrkFrtRtAmt = this.cost40ftTrkFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRail40ft = this.diffRail40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurrDg20ftAmt = this.glineLoclCurrDg20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline20ftFrtRtAmt = this.gline20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline40ftRailFrtRtAmt = this.gline40ftRailFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineDg45ftFrtRtAmt = this.glineDg45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff20ft = this.diff20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost20ftFrtRtAmt = this.cost20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline40ftTrkFrtRtAmt = this.gline40ftTrkFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline40ftFrtRtAmt = this.gline40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRail20ft = this.diffRail20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineDg40ftFrtRtAmt = this.glineDg40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcCgoTpCd = this.ihcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
