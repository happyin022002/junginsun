/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IHCGuidelineDetailVO.java
*@FileTitle : IHCGuidelineDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo;

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

public class IHCGuidelineDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IHCGuidelineDetailVO> models = new ArrayList<IHCGuidelineDetailVO>();
	
	/* Column Info */
	private String ihcCostLocGrpNo = null;
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
	private String trsp45ftRailCostAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String loclCurrCost45ftFrtRtAmt = null;
	/* Column Info */
	private String gline45ftTrkFrtRtAmt = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String cost45ftRailFrtRtAmt = null;
	/* Column Info */
	private String cost20ftTrkFrtRtAmt = null;
	/* Column Info */
	private String loclCurrCost40ftFrtRtAmt = null;
	/* Column Info */
	private String diffTrk20ft = null;
	/* Column Info */
	private String trsp45ftAgmtWgt = null;
	/* Column Info */
	private String trsp45ftTrkCostAmt = null;
	/* Column Info */
	private String gline45ftFrtRtAmt = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String trsp20ftAgmtWgt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String glineLoclCurr45ftAmt = null;
	/* Column Info */
	private String gline20ftRailFrtRtAmt = null;
	/* Column Info */
	private String bsePortLocCd = null;
	/* Column Info */
	private String mtyTrsp40ftCostAmt = null;
	/* Column Info */
	private String diffRail45ft = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String ihcTrfNo = null;
	/* Column Info */
	private String trsp40ftAgmtWgt = null;
	/* Column Info */
	private String cost40ftFrtRtAmt = null;
	/* Column Info */
	private String pntNodCd = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String diffTrk40ft = null;
	/* Column Info */
	private String trsp20ftTrkCostAmt = null;
	/* Column Info */
	private String cost40ftRailFrtRtAmt = null;
	/* Column Info */
	private String trsp40ftCostAmt = null;
	/* Column Info */
	private String bsePortNodCd = null;
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
	private String tml40ftCostAmt = null;
	/* Column Info */
	private String cost45ftTrkFrtRtAmt = null;
	/* Column Info */
	private String ihcRtRmk = null;
	/* Column Info */
	private String prcTrspModCd = null;
	/* Column Info */
	private String trsp20ftRailCostAmt = null;
	/* Column Info */
	private String usaCostTrfSvcModCd = null;
	/* Column Info */
	private String mtyTrsp45ftCostAmt = null;
	/* Column Info */
	private String gline45ftRailFrtRtAmt = null;
	/* Column Info */
	private String mb20ftRto = null;
	/* Column Info */
	private String trsp40ftRailCostAmt = null;
	/* Column Info */
	private String gline20ftTrkFrtRtAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cost20ftRailFrtRtAmt = null;
	/* Column Info */
	private String mtyTrsp20ftCostAmt = null;
	/* Column Info */
	private String pntLocNm = null;
	/* Column Info */
	private String mb40ftRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cost45ftFrtRtAmt = null;
	/* Column Info */
	private String trsp45ftCostAmt = null;
	/* Column Info */
	private String diffTrk45ft = null;
	/* Column Info */
	private String mb45ftRto = null;
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
	private String gline20ftFrtRtAmt = null;
	/* Column Info */
	private String optmTrspModFlg = null;
	/* Column Info */
	private String gline40ftRailFrtRtAmt = null;
	/* Column Info */
	private String trsp20ftCostAmt = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String hubNodCd = null;
	/* Column Info */
	private String tml45ftCostAmt = null;
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
	private String tml20ftCostAmt = null;
	/* Column Info */
	private String trsp40ftTrkCostAmt = null;
	/* Column Info */
	private String dcgoSvcFlg = null;
	/* Column Info */
	private String ihcCgoTpCd = null;
	/* Column Info */
	private String hubLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IHCGuidelineDetailVO() {}

	public IHCGuidelineDetailVO(String ibflag, String pagerows, String svcScpCd, String orgDestTpCd, String ihcTrfNo, String amdtSeq, String ihcCgoTpCd, String rtSeq, String pntLocCd, String pntNodCd, String pntLocNm, String hubLocCd, String hubNodCd, String bsePortLocCd, String bsePortNodCd, String ihcCostLocGrpNo, String rcvDeTermCd, String prcTrspModCd, String gline20ftFrtRtAmt, String gline40ftFrtRtAmt, String gline45ftFrtRtAmt, String cost20ftFrtRtAmt, String cost40ftFrtRtAmt, String cost45ftFrtRtAmt, String diff20ft, String diff40ft, String diff45ft, String diffRail20ft, String diffRail40ft, String diffRail45ft, String diffTrk20ft, String diffTrk40ft, String diffTrk45ft, String loclCurrCd, String loclCurrCost20ftFrtRtAmt, String loclCurrCost40ftFrtRtAmt, String loclCurrCost45ftFrtRtAmt, String trsp20ftCostAmt, String trsp40ftCostAmt, String trsp45ftCostAmt, String mtyTrsp20ftCostAmt, String mtyTrsp40ftCostAmt, String mtyTrsp45ftCostAmt, String tml20ftCostAmt, String tml40ftCostAmt, String tml45ftCostAmt, String mb20ftRto, String mb40ftRto, String mb45ftRto, String n1stCmncAmdtSeq, String nextN1stCmncAmdtSeq, String effDt, String expDt, String optmTrspModFlg, String srcInfoCd, String ihcRtRmk, String dcgoSvcFlg, String prcTrfCreTpCd, String usaCostTrfSvcModCd, String gline20ftRailFrtRtAmt, String gline40ftRailFrtRtAmt, String gline45ftRailFrtRtAmt, String gline20ftTrkFrtRtAmt, String gline40ftTrkFrtRtAmt, String gline45ftTrkFrtRtAmt, String cost20ftRailFrtRtAmt, String cost40ftRailFrtRtAmt, String cost45ftRailFrtRtAmt, String cost20ftTrkFrtRtAmt, String cost40ftTrkFrtRtAmt, String cost45ftTrkFrtRtAmt, String trsp20ftRailCostAmt, String trsp40ftRailCostAmt, String trsp45ftRailCostAmt, String trsp20ftTrkCostAmt, String trsp40ftTrkCostAmt, String trsp45ftTrkCostAmt, String trsp20ftAgmtWgt, String trsp40ftAgmtWgt, String trsp45ftAgmtWgt, String glineLoclCurr20ftAmt, String glineLoclCurr40ftAmt, String glineLoclCurr45ftAmt, String diffLocl20ft, String diffLocl40ft, String diffLocl45ft, String creUsrId, String creDt, String updUsrId, String updDt, String rhqCd) {
		this.ihcCostLocGrpNo = ihcCostLocGrpNo;
		this.diff40ft = diff40ft;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.pntLocCd = pntLocCd;
		this.diffLocl45ft = diffLocl45ft;
		this.loclCurrCost20ftFrtRtAmt = loclCurrCost20ftFrtRtAmt;
		this.glineLoclCurr20ftAmt = glineLoclCurr20ftAmt;
		this.trsp45ftRailCostAmt = trsp45ftRailCostAmt;
		this.pagerows = pagerows;
		this.loclCurrCost45ftFrtRtAmt = loclCurrCost45ftFrtRtAmt;
		this.gline45ftTrkFrtRtAmt = gline45ftTrkFrtRtAmt;
		this.effDt = effDt;
		this.cost45ftRailFrtRtAmt = cost45ftRailFrtRtAmt;
		this.cost20ftTrkFrtRtAmt = cost20ftTrkFrtRtAmt;
		this.loclCurrCost40ftFrtRtAmt = loclCurrCost40ftFrtRtAmt;
		this.diffTrk20ft = diffTrk20ft;
		this.trsp45ftAgmtWgt = trsp45ftAgmtWgt;
		this.trsp45ftTrkCostAmt = trsp45ftTrkCostAmt;
		this.gline45ftFrtRtAmt = gline45ftFrtRtAmt;
		this.rcvDeTermCd = rcvDeTermCd;
		this.trsp20ftAgmtWgt = trsp20ftAgmtWgt;
		this.updUsrId = updUsrId;
		this.glineLoclCurr45ftAmt = glineLoclCurr45ftAmt;
		this.gline20ftRailFrtRtAmt = gline20ftRailFrtRtAmt;
		this.bsePortLocCd = bsePortLocCd;
		this.mtyTrsp40ftCostAmt = mtyTrsp40ftCostAmt;
		this.diffRail45ft = diffRail45ft;
		this.rhqCd = rhqCd;
		this.ihcTrfNo = ihcTrfNo;
		this.trsp40ftAgmtWgt = trsp40ftAgmtWgt;
		this.cost40ftFrtRtAmt = cost40ftFrtRtAmt;
		this.pntNodCd = pntNodCd;
		this.loclCurrCd = loclCurrCd;
		this.orgDestTpCd = orgDestTpCd;
		this.diffTrk40ft = diffTrk40ft;
		this.trsp20ftTrkCostAmt = trsp20ftTrkCostAmt;
		this.cost40ftRailFrtRtAmt = cost40ftRailFrtRtAmt;
		this.trsp40ftCostAmt = trsp40ftCostAmt;
		this.bsePortNodCd = bsePortNodCd;
		this.glineLoclCurr40ftAmt = glineLoclCurr40ftAmt;
		this.rtSeq = rtSeq;
		this.nextN1stCmncAmdtSeq = nextN1stCmncAmdtSeq;
		this.creUsrId = creUsrId;
		this.diffLocl20ft = diffLocl20ft;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.diff45ft = diff45ft;
		this.tml40ftCostAmt = tml40ftCostAmt;
		this.cost45ftTrkFrtRtAmt = cost45ftTrkFrtRtAmt;
		this.ihcRtRmk = ihcRtRmk;
		this.prcTrspModCd = prcTrspModCd;
		this.trsp20ftRailCostAmt = trsp20ftRailCostAmt;
		this.usaCostTrfSvcModCd = usaCostTrfSvcModCd;
		this.mtyTrsp45ftCostAmt = mtyTrsp45ftCostAmt;
		this.gline45ftRailFrtRtAmt = gline45ftRailFrtRtAmt;
		this.mb20ftRto = mb20ftRto;
		this.trsp40ftRailCostAmt = trsp40ftRailCostAmt;
		this.gline20ftTrkFrtRtAmt = gline20ftTrkFrtRtAmt;
		this.creDt = creDt;
		this.cost20ftRailFrtRtAmt = cost20ftRailFrtRtAmt;
		this.mtyTrsp20ftCostAmt = mtyTrsp20ftCostAmt;
		this.pntLocNm = pntLocNm;
		this.mb40ftRto = mb40ftRto;
		this.ibflag = ibflag;
		this.cost45ftFrtRtAmt = cost45ftFrtRtAmt;
		this.trsp45ftCostAmt = trsp45ftCostAmt;
		this.diffTrk45ft = diffTrk45ft;
		this.mb45ftRto = mb45ftRto;
		this.prcTrfCreTpCd = prcTrfCreTpCd;
		this.expDt = expDt;
		this.diffLocl40ft = diffLocl40ft;
		this.updDt = updDt;
		this.cost40ftTrkFrtRtAmt = cost40ftTrkFrtRtAmt;
		this.diffRail40ft = diffRail40ft;
		this.gline20ftFrtRtAmt = gline20ftFrtRtAmt;
		this.optmTrspModFlg = optmTrspModFlg;
		this.gline40ftRailFrtRtAmt = gline40ftRailFrtRtAmt;
		this.trsp20ftCostAmt = trsp20ftCostAmt;
		this.srcInfoCd = srcInfoCd;
		this.hubNodCd = hubNodCd;
		this.tml45ftCostAmt = tml45ftCostAmt;
		this.diff20ft = diff20ft;
		this.cost20ftFrtRtAmt = cost20ftFrtRtAmt;
		this.gline40ftTrkFrtRtAmt = gline40ftTrkFrtRtAmt;
		this.gline40ftFrtRtAmt = gline40ftFrtRtAmt;
		this.diffRail20ft = diffRail20ft;
		this.tml20ftCostAmt = tml20ftCostAmt;
		this.trsp40ftTrkCostAmt = trsp40ftTrkCostAmt;
		this.dcgoSvcFlg = dcgoSvcFlg;
		this.ihcCgoTpCd = ihcCgoTpCd;
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ihc_cost_loc_grp_no", getIhcCostLocGrpNo());
		this.hashColumns.put("diff_40ft", getDiff40ft());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pnt_loc_cd", getPntLocCd());
		this.hashColumns.put("diff_locl_45ft", getDiffLocl45ft());
		this.hashColumns.put("locl_curr_cost_20ft_frt_rt_amt", getLoclCurrCost20ftFrtRtAmt());
		this.hashColumns.put("gline_locl_curr_20ft_amt", getGlineLoclCurr20ftAmt());
		this.hashColumns.put("trsp_45ft_rail_cost_amt", getTrsp45ftRailCostAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("locl_curr_cost_45ft_frt_rt_amt", getLoclCurrCost45ftFrtRtAmt());
		this.hashColumns.put("gline_45ft_trk_frt_rt_amt", getGline45ftTrkFrtRtAmt());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cost_45ft_rail_frt_rt_amt", getCost45ftRailFrtRtAmt());
		this.hashColumns.put("cost_20ft_trk_frt_rt_amt", getCost20ftTrkFrtRtAmt());
		this.hashColumns.put("locl_curr_cost_40ft_frt_rt_amt", getLoclCurrCost40ftFrtRtAmt());
		this.hashColumns.put("diff_trk_20ft", getDiffTrk20ft());
		this.hashColumns.put("trsp_45ft_agmt_wgt", getTrsp45ftAgmtWgt());
		this.hashColumns.put("trsp_45ft_trk_cost_amt", getTrsp45ftTrkCostAmt());
		this.hashColumns.put("gline_45ft_frt_rt_amt", getGline45ftFrtRtAmt());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("trsp_20ft_agmt_wgt", getTrsp20ftAgmtWgt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("gline_locl_curr_45ft_amt", getGlineLoclCurr45ftAmt());
		this.hashColumns.put("gline_20ft_rail_frt_rt_amt", getGline20ftRailFrtRtAmt());
		this.hashColumns.put("bse_port_loc_cd", getBsePortLocCd());
		this.hashColumns.put("mty_trsp_40ft_cost_amt", getMtyTrsp40ftCostAmt());
		this.hashColumns.put("diff_rail_45ft", getDiffRail45ft());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("ihc_trf_no", getIhcTrfNo());
		this.hashColumns.put("trsp_40ft_agmt_wgt", getTrsp40ftAgmtWgt());
		this.hashColumns.put("cost_40ft_frt_rt_amt", getCost40ftFrtRtAmt());
		this.hashColumns.put("pnt_nod_cd", getPntNodCd());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("diff_trk_40ft", getDiffTrk40ft());
		this.hashColumns.put("trsp_20ft_trk_cost_amt", getTrsp20ftTrkCostAmt());
		this.hashColumns.put("cost_40ft_rail_frt_rt_amt", getCost40ftRailFrtRtAmt());
		this.hashColumns.put("trsp_40ft_cost_amt", getTrsp40ftCostAmt());
		this.hashColumns.put("bse_port_nod_cd", getBsePortNodCd());
		this.hashColumns.put("gline_locl_curr_40ft_amt", getGlineLoclCurr40ftAmt());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("next_n1st_cmnc_amdt_seq", getNextN1stCmncAmdtSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("diff_locl_20ft", getDiffLocl20ft());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("diff_45ft", getDiff45ft());
		this.hashColumns.put("tml_40ft_cost_amt", getTml40ftCostAmt());
		this.hashColumns.put("cost_45ft_trk_frt_rt_amt", getCost45ftTrkFrtRtAmt());
		this.hashColumns.put("ihc_rt_rmk", getIhcRtRmk());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("trsp_20ft_rail_cost_amt", getTrsp20ftRailCostAmt());
		this.hashColumns.put("usa_cost_trf_svc_mod_cd", getUsaCostTrfSvcModCd());
		this.hashColumns.put("mty_trsp_45ft_cost_amt", getMtyTrsp45ftCostAmt());
		this.hashColumns.put("gline_45ft_rail_frt_rt_amt", getGline45ftRailFrtRtAmt());
		this.hashColumns.put("mb_20ft_rto", getMb20ftRto());
		this.hashColumns.put("trsp_40ft_rail_cost_amt", getTrsp40ftRailCostAmt());
		this.hashColumns.put("gline_20ft_trk_frt_rt_amt", getGline20ftTrkFrtRtAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cost_20ft_rail_frt_rt_amt", getCost20ftRailFrtRtAmt());
		this.hashColumns.put("mty_trsp_20ft_cost_amt", getMtyTrsp20ftCostAmt());
		this.hashColumns.put("pnt_loc_nm", getPntLocNm());
		this.hashColumns.put("mb_40ft_rto", getMb40ftRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_45ft_frt_rt_amt", getCost45ftFrtRtAmt());
		this.hashColumns.put("trsp_45ft_cost_amt", getTrsp45ftCostAmt());
		this.hashColumns.put("diff_trk_45ft", getDiffTrk45ft());
		this.hashColumns.put("mb_45ft_rto", getMb45ftRto());
		this.hashColumns.put("prc_trf_cre_tp_cd", getPrcTrfCreTpCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("diff_locl_40ft", getDiffLocl40ft());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cost_40ft_trk_frt_rt_amt", getCost40ftTrkFrtRtAmt());
		this.hashColumns.put("diff_rail_40ft", getDiffRail40ft());
		this.hashColumns.put("gline_20ft_frt_rt_amt", getGline20ftFrtRtAmt());
		this.hashColumns.put("optm_trsp_mod_flg", getOptmTrspModFlg());
		this.hashColumns.put("gline_40ft_rail_frt_rt_amt", getGline40ftRailFrtRtAmt());
		this.hashColumns.put("trsp_20ft_cost_amt", getTrsp20ftCostAmt());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("hub_nod_cd", getHubNodCd());
		this.hashColumns.put("tml_45ft_cost_amt", getTml45ftCostAmt());
		this.hashColumns.put("diff_20ft", getDiff20ft());
		this.hashColumns.put("cost_20ft_frt_rt_amt", getCost20ftFrtRtAmt());
		this.hashColumns.put("gline_40ft_trk_frt_rt_amt", getGline40ftTrkFrtRtAmt());
		this.hashColumns.put("gline_40ft_frt_rt_amt", getGline40ftFrtRtAmt());
		this.hashColumns.put("diff_rail_20ft", getDiffRail20ft());
		this.hashColumns.put("tml_20ft_cost_amt", getTml20ftCostAmt());
		this.hashColumns.put("trsp_40ft_trk_cost_amt", getTrsp40ftTrkCostAmt());
		this.hashColumns.put("dcgo_svc_flg", getDcgoSvcFlg());
		this.hashColumns.put("ihc_cgo_tp_cd", getIhcCgoTpCd());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ihc_cost_loc_grp_no", "ihcCostLocGrpNo");
		this.hashFields.put("diff_40ft", "diff40ft");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pnt_loc_cd", "pntLocCd");
		this.hashFields.put("diff_locl_45ft", "diffLocl45ft");
		this.hashFields.put("locl_curr_cost_20ft_frt_rt_amt", "loclCurrCost20ftFrtRtAmt");
		this.hashFields.put("gline_locl_curr_20ft_amt", "glineLoclCurr20ftAmt");
		this.hashFields.put("trsp_45ft_rail_cost_amt", "trsp45ftRailCostAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("locl_curr_cost_45ft_frt_rt_amt", "loclCurrCost45ftFrtRtAmt");
		this.hashFields.put("gline_45ft_trk_frt_rt_amt", "gline45ftTrkFrtRtAmt");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cost_45ft_rail_frt_rt_amt", "cost45ftRailFrtRtAmt");
		this.hashFields.put("cost_20ft_trk_frt_rt_amt", "cost20ftTrkFrtRtAmt");
		this.hashFields.put("locl_curr_cost_40ft_frt_rt_amt", "loclCurrCost40ftFrtRtAmt");
		this.hashFields.put("diff_trk_20ft", "diffTrk20ft");
		this.hashFields.put("trsp_45ft_agmt_wgt", "trsp45ftAgmtWgt");
		this.hashFields.put("trsp_45ft_trk_cost_amt", "trsp45ftTrkCostAmt");
		this.hashFields.put("gline_45ft_frt_rt_amt", "gline45ftFrtRtAmt");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("trsp_20ft_agmt_wgt", "trsp20ftAgmtWgt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("gline_locl_curr_45ft_amt", "glineLoclCurr45ftAmt");
		this.hashFields.put("gline_20ft_rail_frt_rt_amt", "gline20ftRailFrtRtAmt");
		this.hashFields.put("bse_port_loc_cd", "bsePortLocCd");
		this.hashFields.put("mty_trsp_40ft_cost_amt", "mtyTrsp40ftCostAmt");
		this.hashFields.put("diff_rail_45ft", "diffRail45ft");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("ihc_trf_no", "ihcTrfNo");
		this.hashFields.put("trsp_40ft_agmt_wgt", "trsp40ftAgmtWgt");
		this.hashFields.put("cost_40ft_frt_rt_amt", "cost40ftFrtRtAmt");
		this.hashFields.put("pnt_nod_cd", "pntNodCd");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("diff_trk_40ft", "diffTrk40ft");
		this.hashFields.put("trsp_20ft_trk_cost_amt", "trsp20ftTrkCostAmt");
		this.hashFields.put("cost_40ft_rail_frt_rt_amt", "cost40ftRailFrtRtAmt");
		this.hashFields.put("trsp_40ft_cost_amt", "trsp40ftCostAmt");
		this.hashFields.put("bse_port_nod_cd", "bsePortNodCd");
		this.hashFields.put("gline_locl_curr_40ft_amt", "glineLoclCurr40ftAmt");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("next_n1st_cmnc_amdt_seq", "nextN1stCmncAmdtSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_locl_20ft", "diffLocl20ft");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("diff_45ft", "diff45ft");
		this.hashFields.put("tml_40ft_cost_amt", "tml40ftCostAmt");
		this.hashFields.put("cost_45ft_trk_frt_rt_amt", "cost45ftTrkFrtRtAmt");
		this.hashFields.put("ihc_rt_rmk", "ihcRtRmk");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("trsp_20ft_rail_cost_amt", "trsp20ftRailCostAmt");
		this.hashFields.put("usa_cost_trf_svc_mod_cd", "usaCostTrfSvcModCd");
		this.hashFields.put("mty_trsp_45ft_cost_amt", "mtyTrsp45ftCostAmt");
		this.hashFields.put("gline_45ft_rail_frt_rt_amt", "gline45ftRailFrtRtAmt");
		this.hashFields.put("mb_20ft_rto", "mb20ftRto");
		this.hashFields.put("trsp_40ft_rail_cost_amt", "trsp40ftRailCostAmt");
		this.hashFields.put("gline_20ft_trk_frt_rt_amt", "gline20ftTrkFrtRtAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cost_20ft_rail_frt_rt_amt", "cost20ftRailFrtRtAmt");
		this.hashFields.put("mty_trsp_20ft_cost_amt", "mtyTrsp20ftCostAmt");
		this.hashFields.put("pnt_loc_nm", "pntLocNm");
		this.hashFields.put("mb_40ft_rto", "mb40ftRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_45ft_frt_rt_amt", "cost45ftFrtRtAmt");
		this.hashFields.put("trsp_45ft_cost_amt", "trsp45ftCostAmt");
		this.hashFields.put("diff_trk_45ft", "diffTrk45ft");
		this.hashFields.put("mb_45ft_rto", "mb45ftRto");
		this.hashFields.put("prc_trf_cre_tp_cd", "prcTrfCreTpCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("diff_locl_40ft", "diffLocl40ft");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cost_40ft_trk_frt_rt_amt", "cost40ftTrkFrtRtAmt");
		this.hashFields.put("diff_rail_40ft", "diffRail40ft");
		this.hashFields.put("gline_20ft_frt_rt_amt", "gline20ftFrtRtAmt");
		this.hashFields.put("optm_trsp_mod_flg", "optmTrspModFlg");
		this.hashFields.put("gline_40ft_rail_frt_rt_amt", "gline40ftRailFrtRtAmt");
		this.hashFields.put("trsp_20ft_cost_amt", "trsp20ftCostAmt");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("hub_nod_cd", "hubNodCd");
		this.hashFields.put("tml_45ft_cost_amt", "tml45ftCostAmt");
		this.hashFields.put("diff_20ft", "diff20ft");
		this.hashFields.put("cost_20ft_frt_rt_amt", "cost20ftFrtRtAmt");
		this.hashFields.put("gline_40ft_trk_frt_rt_amt", "gline40ftTrkFrtRtAmt");
		this.hashFields.put("gline_40ft_frt_rt_amt", "gline40ftFrtRtAmt");
		this.hashFields.put("diff_rail_20ft", "diffRail20ft");
		this.hashFields.put("tml_20ft_cost_amt", "tml20ftCostAmt");
		this.hashFields.put("trsp_40ft_trk_cost_amt", "trsp40ftTrkCostAmt");
		this.hashFields.put("dcgo_svc_flg", "dcgoSvcFlg");
		this.hashFields.put("ihc_cgo_tp_cd", "ihcCgoTpCd");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ihcCostLocGrpNo
	 */
	public String getIhcCostLocGrpNo() {
		return this.ihcCostLocGrpNo;
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
	 * @return trsp45ftRailCostAmt
	 */
	public String getTrsp45ftRailCostAmt() {
		return this.trsp45ftRailCostAmt;
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
	 * @return loclCurrCost45ftFrtRtAmt
	 */
	public String getLoclCurrCost45ftFrtRtAmt() {
		return this.loclCurrCost45ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return gline45ftTrkFrtRtAmt
	 */
	public String getGline45ftTrkFrtRtAmt() {
		return this.gline45ftTrkFrtRtAmt;
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
	 * @return cost45ftRailFrtRtAmt
	 */
	public String getCost45ftRailFrtRtAmt() {
		return this.cost45ftRailFrtRtAmt;
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
	 * @return trsp45ftTrkCostAmt
	 */
	public String getTrsp45ftTrkCostAmt() {
		return this.trsp45ftTrkCostAmt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return bsePortLocCd
	 */
	public String getBsePortLocCd() {
		return this.bsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @return mtyTrsp40ftCostAmt
	 */
	public String getMtyTrsp40ftCostAmt() {
		return this.mtyTrsp40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return diffRail45ft
	 */
	public String getDiffRail45ft() {
		return this.diffRail45ft;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
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
	 * @return pntNodCd
	 */
	public String getPntNodCd() {
		return this.pntNodCd;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
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
	 * @return diffTrk40ft
	 */
	public String getDiffTrk40ft() {
		return this.diffTrk40ft;
	}
	
	/**
	 * Column Info
	 * @return trsp20ftTrkCostAmt
	 */
	public String getTrsp20ftTrkCostAmt() {
		return this.trsp20ftTrkCostAmt;
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
	 * @return trsp40ftCostAmt
	 */
	public String getTrsp40ftCostAmt() {
		return this.trsp40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return bsePortNodCd
	 */
	public String getBsePortNodCd() {
		return this.bsePortNodCd;
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
	 * @return tml40ftCostAmt
	 */
	public String getTml40ftCostAmt() {
		return this.tml40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return cost45ftTrkFrtRtAmt
	 */
	public String getCost45ftTrkFrtRtAmt() {
		return this.cost45ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ihcRtRmk
	 */
	public String getIhcRtRmk() {
		return this.ihcRtRmk;
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
	 * @return trsp20ftRailCostAmt
	 */
	public String getTrsp20ftRailCostAmt() {
		return this.trsp20ftRailCostAmt;
	}
	
	/**
	 * Column Info
	 * @return usaCostTrfSvcModCd
	 */
	public String getUsaCostTrfSvcModCd() {
		return this.usaCostTrfSvcModCd;
	}
	
	/**
	 * Column Info
	 * @return mtyTrsp45ftCostAmt
	 */
	public String getMtyTrsp45ftCostAmt() {
		return this.mtyTrsp45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return gline45ftRailFrtRtAmt
	 */
	public String getGline45ftRailFrtRtAmt() {
		return this.gline45ftRailFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return mb20ftRto
	 */
	public String getMb20ftRto() {
		return this.mb20ftRto;
	}
	
	/**
	 * Column Info
	 * @return trsp40ftRailCostAmt
	 */
	public String getTrsp40ftRailCostAmt() {
		return this.trsp40ftRailCostAmt;
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
	 * @return mtyTrsp20ftCostAmt
	 */
	public String getMtyTrsp20ftCostAmt() {
		return this.mtyTrsp20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return pntLocNm
	 */
	public String getPntLocNm() {
		return this.pntLocNm;
	}
	
	/**
	 * Column Info
	 * @return mb40ftRto
	 */
	public String getMb40ftRto() {
		return this.mb40ftRto;
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
	 * @return trsp45ftCostAmt
	 */
	public String getTrsp45ftCostAmt() {
		return this.trsp45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return diffTrk45ft
	 */
	public String getDiffTrk45ft() {
		return this.diffTrk45ft;
	}
	
	/**
	 * Column Info
	 * @return mb45ftRto
	 */
	public String getMb45ftRto() {
		return this.mb45ftRto;
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
	 * @return gline20ftFrtRtAmt
	 */
	public String getGline20ftFrtRtAmt() {
		return this.gline20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return optmTrspModFlg
	 */
	public String getOptmTrspModFlg() {
		return this.optmTrspModFlg;
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
	 * @return trsp20ftCostAmt
	 */
	public String getTrsp20ftCostAmt() {
		return this.trsp20ftCostAmt;
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
	 * @return hubNodCd
	 */
	public String getHubNodCd() {
		return this.hubNodCd;
	}
	
	/**
	 * Column Info
	 * @return tml45ftCostAmt
	 */
	public String getTml45ftCostAmt() {
		return this.tml45ftCostAmt;
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
	 * @return tml20ftCostAmt
	 */
	public String getTml20ftCostAmt() {
		return this.tml20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return trsp40ftTrkCostAmt
	 */
	public String getTrsp40ftTrkCostAmt() {
		return this.trsp40ftTrkCostAmt;
	}
	
	/**
	 * Column Info
	 * @return dcgoSvcFlg
	 */
	public String getDcgoSvcFlg() {
		return this.dcgoSvcFlg;
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
	 * @param ihcCostLocGrpNo
	 */
	public void setIhcCostLocGrpNo(String ihcCostLocGrpNo) {
		this.ihcCostLocGrpNo = ihcCostLocGrpNo;
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
	 * @param trsp45ftRailCostAmt
	 */
	public void setTrsp45ftRailCostAmt(String trsp45ftRailCostAmt) {
		this.trsp45ftRailCostAmt = trsp45ftRailCostAmt;
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
	 * @param loclCurrCost45ftFrtRtAmt
	 */
	public void setLoclCurrCost45ftFrtRtAmt(String loclCurrCost45ftFrtRtAmt) {
		this.loclCurrCost45ftFrtRtAmt = loclCurrCost45ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param gline45ftTrkFrtRtAmt
	 */
	public void setGline45ftTrkFrtRtAmt(String gline45ftTrkFrtRtAmt) {
		this.gline45ftTrkFrtRtAmt = gline45ftTrkFrtRtAmt;
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
	 * @param cost45ftRailFrtRtAmt
	 */
	public void setCost45ftRailFrtRtAmt(String cost45ftRailFrtRtAmt) {
		this.cost45ftRailFrtRtAmt = cost45ftRailFrtRtAmt;
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
	 * @param trsp45ftTrkCostAmt
	 */
	public void setTrsp45ftTrkCostAmt(String trsp45ftTrkCostAmt) {
		this.trsp45ftTrkCostAmt = trsp45ftTrkCostAmt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param bsePortLocCd
	 */
	public void setBsePortLocCd(String bsePortLocCd) {
		this.bsePortLocCd = bsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @param mtyTrsp40ftCostAmt
	 */
	public void setMtyTrsp40ftCostAmt(String mtyTrsp40ftCostAmt) {
		this.mtyTrsp40ftCostAmt = mtyTrsp40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param diffRail45ft
	 */
	public void setDiffRail45ft(String diffRail45ft) {
		this.diffRail45ft = diffRail45ft;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
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
	 * @param pntNodCd
	 */
	public void setPntNodCd(String pntNodCd) {
		this.pntNodCd = pntNodCd;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
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
	 * @param diffTrk40ft
	 */
	public void setDiffTrk40ft(String diffTrk40ft) {
		this.diffTrk40ft = diffTrk40ft;
	}
	
	/**
	 * Column Info
	 * @param trsp20ftTrkCostAmt
	 */
	public void setTrsp20ftTrkCostAmt(String trsp20ftTrkCostAmt) {
		this.trsp20ftTrkCostAmt = trsp20ftTrkCostAmt;
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
	 * @param trsp40ftCostAmt
	 */
	public void setTrsp40ftCostAmt(String trsp40ftCostAmt) {
		this.trsp40ftCostAmt = trsp40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param bsePortNodCd
	 */
	public void setBsePortNodCd(String bsePortNodCd) {
		this.bsePortNodCd = bsePortNodCd;
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
	 * @param tml40ftCostAmt
	 */
	public void setTml40ftCostAmt(String tml40ftCostAmt) {
		this.tml40ftCostAmt = tml40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param cost45ftTrkFrtRtAmt
	 */
	public void setCost45ftTrkFrtRtAmt(String cost45ftTrkFrtRtAmt) {
		this.cost45ftTrkFrtRtAmt = cost45ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ihcRtRmk
	 */
	public void setIhcRtRmk(String ihcRtRmk) {
		this.ihcRtRmk = ihcRtRmk;
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
	 * @param trsp20ftRailCostAmt
	 */
	public void setTrsp20ftRailCostAmt(String trsp20ftRailCostAmt) {
		this.trsp20ftRailCostAmt = trsp20ftRailCostAmt;
	}
	
	/**
	 * Column Info
	 * @param usaCostTrfSvcModCd
	 */
	public void setUsaCostTrfSvcModCd(String usaCostTrfSvcModCd) {
		this.usaCostTrfSvcModCd = usaCostTrfSvcModCd;
	}
	
	/**
	 * Column Info
	 * @param mtyTrsp45ftCostAmt
	 */
	public void setMtyTrsp45ftCostAmt(String mtyTrsp45ftCostAmt) {
		this.mtyTrsp45ftCostAmt = mtyTrsp45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param gline45ftRailFrtRtAmt
	 */
	public void setGline45ftRailFrtRtAmt(String gline45ftRailFrtRtAmt) {
		this.gline45ftRailFrtRtAmt = gline45ftRailFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param mb20ftRto
	 */
	public void setMb20ftRto(String mb20ftRto) {
		this.mb20ftRto = mb20ftRto;
	}
	
	/**
	 * Column Info
	 * @param trsp40ftRailCostAmt
	 */
	public void setTrsp40ftRailCostAmt(String trsp40ftRailCostAmt) {
		this.trsp40ftRailCostAmt = trsp40ftRailCostAmt;
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
	 * @param mtyTrsp20ftCostAmt
	 */
	public void setMtyTrsp20ftCostAmt(String mtyTrsp20ftCostAmt) {
		this.mtyTrsp20ftCostAmt = mtyTrsp20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param pntLocNm
	 */
	public void setPntLocNm(String pntLocNm) {
		this.pntLocNm = pntLocNm;
	}
	
	/**
	 * Column Info
	 * @param mb40ftRto
	 */
	public void setMb40ftRto(String mb40ftRto) {
		this.mb40ftRto = mb40ftRto;
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
	 * @param trsp45ftCostAmt
	 */
	public void setTrsp45ftCostAmt(String trsp45ftCostAmt) {
		this.trsp45ftCostAmt = trsp45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param diffTrk45ft
	 */
	public void setDiffTrk45ft(String diffTrk45ft) {
		this.diffTrk45ft = diffTrk45ft;
	}
	
	/**
	 * Column Info
	 * @param mb45ftRto
	 */
	public void setMb45ftRto(String mb45ftRto) {
		this.mb45ftRto = mb45ftRto;
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
	 * @param gline20ftFrtRtAmt
	 */
	public void setGline20ftFrtRtAmt(String gline20ftFrtRtAmt) {
		this.gline20ftFrtRtAmt = gline20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param optmTrspModFlg
	 */
	public void setOptmTrspModFlg(String optmTrspModFlg) {
		this.optmTrspModFlg = optmTrspModFlg;
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
	 * @param trsp20ftCostAmt
	 */
	public void setTrsp20ftCostAmt(String trsp20ftCostAmt) {
		this.trsp20ftCostAmt = trsp20ftCostAmt;
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
	 * @param hubNodCd
	 */
	public void setHubNodCd(String hubNodCd) {
		this.hubNodCd = hubNodCd;
	}
	
	/**
	 * Column Info
	 * @param tml45ftCostAmt
	 */
	public void setTml45ftCostAmt(String tml45ftCostAmt) {
		this.tml45ftCostAmt = tml45ftCostAmt;
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
	 * @param tml20ftCostAmt
	 */
	public void setTml20ftCostAmt(String tml20ftCostAmt) {
		this.tml20ftCostAmt = tml20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param trsp40ftTrkCostAmt
	 */
	public void setTrsp40ftTrkCostAmt(String trsp40ftTrkCostAmt) {
		this.trsp40ftTrkCostAmt = trsp40ftTrkCostAmt;
	}
	
	/**
	 * Column Info
	 * @param dcgoSvcFlg
	 */
	public void setDcgoSvcFlg(String dcgoSvcFlg) {
		this.dcgoSvcFlg = dcgoSvcFlg;
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
		setIhcCostLocGrpNo(JSPUtil.getParameter(request, prefix + "ihc_cost_loc_grp_no", ""));
		setDiff40ft(JSPUtil.getParameter(request, prefix + "diff_40ft", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPntLocCd(JSPUtil.getParameter(request, prefix + "pnt_loc_cd", ""));
		setDiffLocl45ft(JSPUtil.getParameter(request, prefix + "diff_locl_45ft", ""));
		setLoclCurrCost20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "locl_curr_cost_20ft_frt_rt_amt", ""));
		setGlineLoclCurr20ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_20ft_amt", ""));
		setTrsp45ftRailCostAmt(JSPUtil.getParameter(request, prefix + "trsp_45ft_rail_cost_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLoclCurrCost45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "locl_curr_cost_45ft_frt_rt_amt", ""));
		setGline45ftTrkFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_45ft_trk_frt_rt_amt", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setCost45ftRailFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_45ft_rail_frt_rt_amt", ""));
		setCost20ftTrkFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_20ft_trk_frt_rt_amt", ""));
		setLoclCurrCost40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "locl_curr_cost_40ft_frt_rt_amt", ""));
		setDiffTrk20ft(JSPUtil.getParameter(request, prefix + "diff_trk_20ft", ""));
		setTrsp45ftAgmtWgt(JSPUtil.getParameter(request, prefix + "trsp_45ft_agmt_wgt", ""));
		setTrsp45ftTrkCostAmt(JSPUtil.getParameter(request, prefix + "trsp_45ft_trk_cost_amt", ""));
		setGline45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_45ft_frt_rt_amt", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setTrsp20ftAgmtWgt(JSPUtil.getParameter(request, prefix + "trsp_20ft_agmt_wgt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setGlineLoclCurr45ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_45ft_amt", ""));
		setGline20ftRailFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_20ft_rail_frt_rt_amt", ""));
		setBsePortLocCd(JSPUtil.getParameter(request, prefix + "bse_port_loc_cd", ""));
		setMtyTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_amt", ""));
		setDiffRail45ft(JSPUtil.getParameter(request, prefix + "diff_rail_45ft", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setIhcTrfNo(JSPUtil.getParameter(request, prefix + "ihc_trf_no", ""));
		setTrsp40ftAgmtWgt(JSPUtil.getParameter(request, prefix + "trsp_40ft_agmt_wgt", ""));
		setCost40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_40ft_frt_rt_amt", ""));
		setPntNodCd(JSPUtil.getParameter(request, prefix + "pnt_nod_cd", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setDiffTrk40ft(JSPUtil.getParameter(request, prefix + "diff_trk_40ft", ""));
		setTrsp20ftTrkCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_trk_cost_amt", ""));
		setCost40ftRailFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_40ft_rail_frt_rt_amt", ""));
		setTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_cost_amt", ""));
		setBsePortNodCd(JSPUtil.getParameter(request, prefix + "bse_port_nod_cd", ""));
		setGlineLoclCurr40ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_40ft_amt", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setNextN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "next_n1st_cmnc_amdt_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDiffLocl20ft(JSPUtil.getParameter(request, prefix + "diff_locl_20ft", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setDiff45ft(JSPUtil.getParameter(request, prefix + "diff_45ft", ""));
		setTml40ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_amt", ""));
		setCost45ftTrkFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_45ft_trk_frt_rt_amt", ""));
		setIhcRtRmk(JSPUtil.getParameter(request, prefix + "ihc_rt_rmk", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd", ""));
		setTrsp20ftRailCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_rail_cost_amt", ""));
		setUsaCostTrfSvcModCd(JSPUtil.getParameter(request, prefix + "usa_cost_trf_svc_mod_cd", ""));
		setMtyTrsp45ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_45ft_cost_amt", ""));
		setGline45ftRailFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_45ft_rail_frt_rt_amt", ""));
		setMb20ftRto(JSPUtil.getParameter(request, prefix + "mb_20ft_rto", ""));
		setTrsp40ftRailCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_rail_cost_amt", ""));
		setGline20ftTrkFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_20ft_trk_frt_rt_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCost20ftRailFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_20ft_rail_frt_rt_amt", ""));
		setMtyTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_amt", ""));
		setPntLocNm(JSPUtil.getParameter(request, prefix + "pnt_loc_nm", ""));
		setMb40ftRto(JSPUtil.getParameter(request, prefix + "mb_40ft_rto", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCost45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_45ft_frt_rt_amt", ""));
		setTrsp45ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_45ft_cost_amt", ""));
		setDiffTrk45ft(JSPUtil.getParameter(request, prefix + "diff_trk_45ft", ""));
		setMb45ftRto(JSPUtil.getParameter(request, prefix + "mb_45ft_rto", ""));
		setPrcTrfCreTpCd(JSPUtil.getParameter(request, prefix + "prc_trf_cre_tp_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setDiffLocl40ft(JSPUtil.getParameter(request, prefix + "diff_locl_40ft", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCost40ftTrkFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_40ft_trk_frt_rt_amt", ""));
		setDiffRail40ft(JSPUtil.getParameter(request, prefix + "diff_rail_40ft", ""));
		setGline20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_20ft_frt_rt_amt", ""));
		setOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg", ""));
		setGline40ftRailFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_40ft_rail_frt_rt_amt", ""));
		setTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_cost_amt", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, prefix + "src_info_cd", ""));
		setHubNodCd(JSPUtil.getParameter(request, prefix + "hub_nod_cd", ""));
		setTml45ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_45ft_cost_amt", ""));
		setDiff20ft(JSPUtil.getParameter(request, prefix + "diff_20ft", ""));
		setCost20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_20ft_frt_rt_amt", ""));
		setGline40ftTrkFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_40ft_trk_frt_rt_amt", ""));
		setGline40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_40ft_frt_rt_amt", ""));
		setDiffRail20ft(JSPUtil.getParameter(request, prefix + "diff_rail_20ft", ""));
		setTml20ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_amt", ""));
		setTrsp40ftTrkCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_trk_cost_amt", ""));
		setDcgoSvcFlg(JSPUtil.getParameter(request, prefix + "dcgo_svc_flg", ""));
		setIhcCgoTpCd(JSPUtil.getParameter(request, prefix + "ihc_cgo_tp_cd", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IHCGuidelineDetailVO[]
	 */
	public IHCGuidelineDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IHCGuidelineDetailVO[]
	 */
	public IHCGuidelineDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IHCGuidelineDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ihcCostLocGrpNo = (JSPUtil.getParameter(request, prefix	+ "ihc_cost_loc_grp_no", length));
			String[] diff40ft = (JSPUtil.getParameter(request, prefix	+ "diff_40ft", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] pntLocCd = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_cd", length));
			String[] diffLocl45ft = (JSPUtil.getParameter(request, prefix	+ "diff_locl_45ft", length));
			String[] loclCurrCost20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cost_20ft_frt_rt_amt", length));
			String[] glineLoclCurr20ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_20ft_amt", length));
			String[] trsp45ftRailCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_rail_cost_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] loclCurrCost45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cost_45ft_frt_rt_amt", length));
			String[] gline45ftTrkFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_45ft_trk_frt_rt_amt", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] cost45ftRailFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_45ft_rail_frt_rt_amt", length));
			String[] cost20ftTrkFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_20ft_trk_frt_rt_amt", length));
			String[] loclCurrCost40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cost_40ft_frt_rt_amt", length));
			String[] diffTrk20ft = (JSPUtil.getParameter(request, prefix	+ "diff_trk_20ft", length));
			String[] trsp45ftAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_agmt_wgt", length));
			String[] trsp45ftTrkCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_trk_cost_amt", length));
			String[] gline45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_45ft_frt_rt_amt", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] trsp20ftAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_agmt_wgt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] glineLoclCurr45ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_45ft_amt", length));
			String[] gline20ftRailFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_20ft_rail_frt_rt_amt", length));
			String[] bsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_loc_cd", length));
			String[] mtyTrsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_amt", length));
			String[] diffRail45ft = (JSPUtil.getParameter(request, prefix	+ "diff_rail_45ft", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] ihcTrfNo = (JSPUtil.getParameter(request, prefix	+ "ihc_trf_no", length));
			String[] trsp40ftAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_agmt_wgt", length));
			String[] cost40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_40ft_frt_rt_amt", length));
			String[] pntNodCd = (JSPUtil.getParameter(request, prefix	+ "pnt_nod_cd", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] diffTrk40ft = (JSPUtil.getParameter(request, prefix	+ "diff_trk_40ft", length));
			String[] trsp20ftTrkCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_trk_cost_amt", length));
			String[] cost40ftRailFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_40ft_rail_frt_rt_amt", length));
			String[] trsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_cost_amt", length));
			String[] bsePortNodCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_nod_cd", length));
			String[] glineLoclCurr40ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_40ft_amt", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] nextN1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "next_n1st_cmnc_amdt_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] diffLocl20ft = (JSPUtil.getParameter(request, prefix	+ "diff_locl_20ft", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] diff45ft = (JSPUtil.getParameter(request, prefix	+ "diff_45ft", length));
			String[] tml40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_amt", length));
			String[] cost45ftTrkFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_45ft_trk_frt_rt_amt", length));
			String[] ihcRtRmk = (JSPUtil.getParameter(request, prefix	+ "ihc_rt_rmk", length));
			String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd", length));
			String[] trsp20ftRailCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_rail_cost_amt", length));
			String[] usaCostTrfSvcModCd = (JSPUtil.getParameter(request, prefix	+ "usa_cost_trf_svc_mod_cd", length));
			String[] mtyTrsp45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_45ft_cost_amt", length));
			String[] gline45ftRailFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_45ft_rail_frt_rt_amt", length));
			String[] mb20ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_20ft_rto", length));
			String[] trsp40ftRailCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_rail_cost_amt", length));
			String[] gline20ftTrkFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_20ft_trk_frt_rt_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cost20ftRailFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_20ft_rail_frt_rt_amt", length));
			String[] mtyTrsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_amt", length));
			String[] pntLocNm = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_nm", length));
			String[] mb40ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_40ft_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cost45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_45ft_frt_rt_amt", length));
			String[] trsp45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_cost_amt", length));
			String[] diffTrk45ft = (JSPUtil.getParameter(request, prefix	+ "diff_trk_45ft", length));
			String[] mb45ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_45ft_rto", length));
			String[] prcTrfCreTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_trf_cre_tp_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] diffLocl40ft = (JSPUtil.getParameter(request, prefix	+ "diff_locl_40ft", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cost40ftTrkFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_40ft_trk_frt_rt_amt", length));
			String[] diffRail40ft = (JSPUtil.getParameter(request, prefix	+ "diff_rail_40ft", length));
			String[] gline20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_20ft_frt_rt_amt", length));
			String[] optmTrspModFlg = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_flg", length));
			String[] gline40ftRailFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_40ft_rail_frt_rt_amt", length));
			String[] trsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_cost_amt", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] hubNodCd = (JSPUtil.getParameter(request, prefix	+ "hub_nod_cd", length));
			String[] tml45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_45ft_cost_amt", length));
			String[] diff20ft = (JSPUtil.getParameter(request, prefix	+ "diff_20ft", length));
			String[] cost20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_20ft_frt_rt_amt", length));
			String[] gline40ftTrkFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_40ft_trk_frt_rt_amt", length));
			String[] gline40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_40ft_frt_rt_amt", length));
			String[] diffRail20ft = (JSPUtil.getParameter(request, prefix	+ "diff_rail_20ft", length));
			String[] tml20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_amt", length));
			String[] trsp40ftTrkCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_trk_cost_amt", length));
			String[] dcgoSvcFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_svc_flg", length));
			String[] ihcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "ihc_cgo_tp_cd", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new IHCGuidelineDetailVO();
				if (ihcCostLocGrpNo[i] != null)
					model.setIhcCostLocGrpNo(ihcCostLocGrpNo[i]);
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
				if (trsp45ftRailCostAmt[i] != null)
					model.setTrsp45ftRailCostAmt(trsp45ftRailCostAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (loclCurrCost45ftFrtRtAmt[i] != null)
					model.setLoclCurrCost45ftFrtRtAmt(loclCurrCost45ftFrtRtAmt[i]);
				if (gline45ftTrkFrtRtAmt[i] != null)
					model.setGline45ftTrkFrtRtAmt(gline45ftTrkFrtRtAmt[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (cost45ftRailFrtRtAmt[i] != null)
					model.setCost45ftRailFrtRtAmt(cost45ftRailFrtRtAmt[i]);
				if (cost20ftTrkFrtRtAmt[i] != null)
					model.setCost20ftTrkFrtRtAmt(cost20ftTrkFrtRtAmt[i]);
				if (loclCurrCost40ftFrtRtAmt[i] != null)
					model.setLoclCurrCost40ftFrtRtAmt(loclCurrCost40ftFrtRtAmt[i]);
				if (diffTrk20ft[i] != null)
					model.setDiffTrk20ft(diffTrk20ft[i]);
				if (trsp45ftAgmtWgt[i] != null)
					model.setTrsp45ftAgmtWgt(trsp45ftAgmtWgt[i]);
				if (trsp45ftTrkCostAmt[i] != null)
					model.setTrsp45ftTrkCostAmt(trsp45ftTrkCostAmt[i]);
				if (gline45ftFrtRtAmt[i] != null)
					model.setGline45ftFrtRtAmt(gline45ftFrtRtAmt[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (trsp20ftAgmtWgt[i] != null)
					model.setTrsp20ftAgmtWgt(trsp20ftAgmtWgt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (glineLoclCurr45ftAmt[i] != null)
					model.setGlineLoclCurr45ftAmt(glineLoclCurr45ftAmt[i]);
				if (gline20ftRailFrtRtAmt[i] != null)
					model.setGline20ftRailFrtRtAmt(gline20ftRailFrtRtAmt[i]);
				if (bsePortLocCd[i] != null)
					model.setBsePortLocCd(bsePortLocCd[i]);
				if (mtyTrsp40ftCostAmt[i] != null)
					model.setMtyTrsp40ftCostAmt(mtyTrsp40ftCostAmt[i]);
				if (diffRail45ft[i] != null)
					model.setDiffRail45ft(diffRail45ft[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (ihcTrfNo[i] != null)
					model.setIhcTrfNo(ihcTrfNo[i]);
				if (trsp40ftAgmtWgt[i] != null)
					model.setTrsp40ftAgmtWgt(trsp40ftAgmtWgt[i]);
				if (cost40ftFrtRtAmt[i] != null)
					model.setCost40ftFrtRtAmt(cost40ftFrtRtAmt[i]);
				if (pntNodCd[i] != null)
					model.setPntNodCd(pntNodCd[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (diffTrk40ft[i] != null)
					model.setDiffTrk40ft(diffTrk40ft[i]);
				if (trsp20ftTrkCostAmt[i] != null)
					model.setTrsp20ftTrkCostAmt(trsp20ftTrkCostAmt[i]);
				if (cost40ftRailFrtRtAmt[i] != null)
					model.setCost40ftRailFrtRtAmt(cost40ftRailFrtRtAmt[i]);
				if (trsp40ftCostAmt[i] != null)
					model.setTrsp40ftCostAmt(trsp40ftCostAmt[i]);
				if (bsePortNodCd[i] != null)
					model.setBsePortNodCd(bsePortNodCd[i]);
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
				if (tml40ftCostAmt[i] != null)
					model.setTml40ftCostAmt(tml40ftCostAmt[i]);
				if (cost45ftTrkFrtRtAmt[i] != null)
					model.setCost45ftTrkFrtRtAmt(cost45ftTrkFrtRtAmt[i]);
				if (ihcRtRmk[i] != null)
					model.setIhcRtRmk(ihcRtRmk[i]);
				if (prcTrspModCd[i] != null)
					model.setPrcTrspModCd(prcTrspModCd[i]);
				if (trsp20ftRailCostAmt[i] != null)
					model.setTrsp20ftRailCostAmt(trsp20ftRailCostAmt[i]);
				if (usaCostTrfSvcModCd[i] != null)
					model.setUsaCostTrfSvcModCd(usaCostTrfSvcModCd[i]);
				if (mtyTrsp45ftCostAmt[i] != null)
					model.setMtyTrsp45ftCostAmt(mtyTrsp45ftCostAmt[i]);
				if (gline45ftRailFrtRtAmt[i] != null)
					model.setGline45ftRailFrtRtAmt(gline45ftRailFrtRtAmt[i]);
				if (mb20ftRto[i] != null)
					model.setMb20ftRto(mb20ftRto[i]);
				if (trsp40ftRailCostAmt[i] != null)
					model.setTrsp40ftRailCostAmt(trsp40ftRailCostAmt[i]);
				if (gline20ftTrkFrtRtAmt[i] != null)
					model.setGline20ftTrkFrtRtAmt(gline20ftTrkFrtRtAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cost20ftRailFrtRtAmt[i] != null)
					model.setCost20ftRailFrtRtAmt(cost20ftRailFrtRtAmt[i]);
				if (mtyTrsp20ftCostAmt[i] != null)
					model.setMtyTrsp20ftCostAmt(mtyTrsp20ftCostAmt[i]);
				if (pntLocNm[i] != null)
					model.setPntLocNm(pntLocNm[i]);
				if (mb40ftRto[i] != null)
					model.setMb40ftRto(mb40ftRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cost45ftFrtRtAmt[i] != null)
					model.setCost45ftFrtRtAmt(cost45ftFrtRtAmt[i]);
				if (trsp45ftCostAmt[i] != null)
					model.setTrsp45ftCostAmt(trsp45ftCostAmt[i]);
				if (diffTrk45ft[i] != null)
					model.setDiffTrk45ft(diffTrk45ft[i]);
				if (mb45ftRto[i] != null)
					model.setMb45ftRto(mb45ftRto[i]);
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
				if (gline20ftFrtRtAmt[i] != null)
					model.setGline20ftFrtRtAmt(gline20ftFrtRtAmt[i]);
				if (optmTrspModFlg[i] != null)
					model.setOptmTrspModFlg(optmTrspModFlg[i]);
				if (gline40ftRailFrtRtAmt[i] != null)
					model.setGline40ftRailFrtRtAmt(gline40ftRailFrtRtAmt[i]);
				if (trsp20ftCostAmt[i] != null)
					model.setTrsp20ftCostAmt(trsp20ftCostAmt[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (hubNodCd[i] != null)
					model.setHubNodCd(hubNodCd[i]);
				if (tml45ftCostAmt[i] != null)
					model.setTml45ftCostAmt(tml45ftCostAmt[i]);
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
				if (tml20ftCostAmt[i] != null)
					model.setTml20ftCostAmt(tml20ftCostAmt[i]);
				if (trsp40ftTrkCostAmt[i] != null)
					model.setTrsp40ftTrkCostAmt(trsp40ftTrkCostAmt[i]);
				if (dcgoSvcFlg[i] != null)
					model.setDcgoSvcFlg(dcgoSvcFlg[i]);
				if (ihcCgoTpCd[i] != null)
					model.setIhcCgoTpCd(ihcCgoTpCd[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIHCGuidelineDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IHCGuidelineDetailVO[]
	 */
	public IHCGuidelineDetailVO[] getIHCGuidelineDetailVOs(){
		IHCGuidelineDetailVO[] vos = (IHCGuidelineDetailVO[])models.toArray(new IHCGuidelineDetailVO[models.size()]);
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
		this.ihcCostLocGrpNo = this.ihcCostLocGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff40ft = this.diff40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocCd = this.pntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffLocl45ft = this.diffLocl45ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCost20ftFrtRtAmt = this.loclCurrCost20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurr20ftAmt = this.glineLoclCurr20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftRailCostAmt = this.trsp45ftRailCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCost45ftFrtRtAmt = this.loclCurrCost45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline45ftTrkFrtRtAmt = this.gline45ftTrkFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost45ftRailFrtRtAmt = this.cost45ftRailFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost20ftTrkFrtRtAmt = this.cost20ftTrkFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCost40ftFrtRtAmt = this.loclCurrCost40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffTrk20ft = this.diffTrk20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftAgmtWgt = this.trsp45ftAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftTrkCostAmt = this.trsp45ftTrkCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline45ftFrtRtAmt = this.gline45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftAgmtWgt = this.trsp20ftAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurr45ftAmt = this.glineLoclCurr45ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline20ftRailFrtRtAmt = this.gline20ftRailFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortLocCd = this.bsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostAmt = this.mtyTrsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRail45ft = this.diffRail45ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfNo = this.ihcTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftAgmtWgt = this.trsp40ftAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost40ftFrtRtAmt = this.cost40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntNodCd = this.pntNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffTrk40ft = this.diffTrk40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftTrkCostAmt = this.trsp20ftTrkCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost40ftRailFrtRtAmt = this.cost40ftRailFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftCostAmt = this.trsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortNodCd = this.bsePortNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurr40ftAmt = this.glineLoclCurr40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextN1stCmncAmdtSeq = this.nextN1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffLocl20ft = this.diffLocl20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff45ft = this.diff45ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostAmt = this.tml40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost45ftTrkFrtRtAmt = this.cost45ftTrkFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcRtRmk = this.ihcRtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd = this.prcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftRailCostAmt = this.trsp20ftRailCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaCostTrfSvcModCd = this.usaCostTrfSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp45ftCostAmt = this.mtyTrsp45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline45ftRailFrtRtAmt = this.gline45ftRailFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb20ftRto = this.mb20ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftRailCostAmt = this.trsp40ftRailCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline20ftTrkFrtRtAmt = this.gline20ftTrkFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost20ftRailFrtRtAmt = this.cost20ftRailFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostAmt = this.mtyTrsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocNm = this.pntLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb40ftRto = this.mb40ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost45ftFrtRtAmt = this.cost45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftCostAmt = this.trsp45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffTrk45ft = this.diffTrk45ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb45ftRto = this.mb45ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrfCreTpCd = this.prcTrfCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffLocl40ft = this.diffLocl40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost40ftTrkFrtRtAmt = this.cost40ftTrkFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRail40ft = this.diffRail40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline20ftFrtRtAmt = this.gline20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlg = this.optmTrspModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline40ftRailFrtRtAmt = this.gline40ftRailFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftCostAmt = this.trsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubNodCd = this.hubNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml45ftCostAmt = this.tml45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff20ft = this.diff20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost20ftFrtRtAmt = this.cost20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline40ftTrkFrtRtAmt = this.gline40ftTrkFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline40ftFrtRtAmt = this.gline40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRail20ft = this.diffRail20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostAmt = this.tml20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftTrkCostAmt = this.trsp40ftTrkCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSvcFlg = this.dcgoSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcCgoTpCd = this.ihcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
