/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PriTrfIHCRtVO.java
*@FileTitle : PriTrfIHCRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.25  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriTrfIHCRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriTrfIHCRtVO> models = new ArrayList<PriTrfIHCRtVO>();
	
	/* Column Info */
	private String ihcCostLocGrpNo = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String pntLocCd = null;
	/* Column Info */
	private String loclCurrCost20ftFrtRtAmt = null;
	/* Column Info */
	private String glineLoclCurr20ftAmt = null;
	/* Column Info */
	private String loclCurrCost45ftFrtRtAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String glineOvrWgt45ftFrtRtAmt = null;
	/* Column Info */
	private String glineDg20ftFrtRtAmt = null;
	/* Column Info */
	private String loclCurrCost40ftFrtRtAmt = null;
	/* Column Info */
	private String gline45ftFrtRtAmt = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String glineLoclCurr45ftAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String glineLoclCurrDg40ftAmt = null;
	/* Column Info */
	private String mtyTrsp40ftCostAmt = null;
	/* Column Info */
	private String bsePortLocCd = null;
	/* Column Info */
	private String ihcTrfNo = null;
	/* Column Info */
	private String pntNodCd = null;
	/* Column Info */
	private String cost40ftFrtRtAmt = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String trsp40ftCostAmt = null;
	/* Column Info */
	private String bsePortNodCd = null;
	/* Column Info */
	private String glineLoclCurr40ftAmt = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String orgCost20ftFrtRtAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String orgCost45ftFrtRtAmt = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String tml40ftCostAmt = null;
	/* Column Info */
	private String prcTrspModCd = null;
	/* Column Info */
	private String ihcRtRmk = null;
	/* Column Info */
	private String mtyTrsp45ftCostAmt = null;
	/* Column Info */
	private String glineLoclCurrDg45ftAmt = null;
	/* Column Info */
	private String glineLoclCurrOvr40ftAmt = null;
	/* Column Info */
	private String mb20ftRto = null;
	/* Column Info */
	private String orgCost40ftFrtRtAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mtyTrsp20ftCostAmt = null;
	/* Column Info */
	private String glineLoclCurrOvr20ftAmt = null;
	/* Column Info */
	private String glineOvrWgt20ftFrtRtAmt = null;
	/* Column Info */
	private String mb40ftRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String glineOvrWgt40ftFrtRtAmt = null;
	/* Column Info */
	private String trsp45ftCostAmt = null;
	/* Column Info */
	private String cost45ftFrtRtAmt = null;
	/* Column Info */
	private String mb45ftRto = null;
	/* Column Info */
	private String prcTrfCreTpCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String glineLoclCurrDg20ftAmt = null;
	/* Column Info */
	private String gline20ftFrtRtAmt = null;
	/* Column Info */
	private String optmTrspModFlg = null;
	/* Column Info */
	private String trsp20ftCostAmt = null;
	/* Column Info */
	private String glineDg45ftFrtRtAmt = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String hubNodCd = null;
	/* Column Info */
	private String tml45ftCostAmt = null;
	/* Column Info */
	private String cost20ftFrtRtAmt = null;
	/* Column Info */
	private String gline40ftFrtRtAmt = null;
	/* Column Info */
	private String tml20ftCostAmt = null;
	/* Column Info */
	private String glineLoclCurrOvr45ftAmt = null;
	/* Column Info */
	private String dcgoSvcFlg = null;
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
	
	public PriTrfIHCRtVO() {}

	public PriTrfIHCRtVO(String ibflag, String pagerows, String ihcCostLocGrpNo, String amdtSeq, String svcScpCd, String pntLocCd, String loclCurrCost20ftFrtRtAmt, String glineLoclCurr20ftAmt, String glineDg20ftFrtRtAmt, String loclCurrCost40ftFrtRtAmt, String rcvDeTermCd, String updUsrId, String bsePortLocCd, String mtyTrsp40ftCostAmt, String glineLoclCurrDg40ftAmt, String ihcTrfNo, String loclCurrCd, String cost40ftFrtRtAmt, String pntNodCd, String orgDestTpCd, String trsp40ftCostAmt, String bsePortNodCd, String glineLoclCurr40ftAmt, String rtSeq, String orgCost20ftFrtRtAmt, String creUsrId, String n1stCmncAmdtSeq, String tml40ftCostAmt, String prcTrspModCd, String ihcRtRmk, String glineLoclCurrOvr40ftAmt, String mb20ftRto, String orgCost40ftFrtRtAmt, String creDt, String mtyTrsp20ftCostAmt, String glineLoclCurrOvr20ftAmt, String glineOvrWgt20ftFrtRtAmt, String mb40ftRto, String glineOvrWgt40ftFrtRtAmt, String prcTrfCreTpCd, String updDt, String glineLoclCurrDg20ftAmt, String gline20ftFrtRtAmt, String optmTrspModFlg, String trsp20ftCostAmt, String srcInfoCd, String hubNodCd, String cost20ftFrtRtAmt, String gline40ftFrtRtAmt, String tml20ftCostAmt, String glineDg40ftFrtRtAmt, String dcgoSvcFlg, String ihcCgoTpCd, String hubLocCd, String loclCurrCost45ftFrtRtAmt, String mtyTrsp45ftCostAmt, String glineLoclCurrDg45ftAmt, String cost45ftFrtRtAmt, String trsp45ftCostAmt, String glineLoclCurr45ftAmt, String tml45ftCostAmt, String glineLoclCurrOvr45ftAmt, String orgCost45ftFrtRtAmt, String mb45ftRto, String glineOvrWgt45ftFrtRtAmt, String gline45ftFrtRtAmt, String glineDg45ftFrtRtAmt) {
		this.ihcCostLocGrpNo = ihcCostLocGrpNo;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.pntLocCd = pntLocCd;
		this.loclCurrCost20ftFrtRtAmt = loclCurrCost20ftFrtRtAmt;
		this.glineLoclCurr20ftAmt = glineLoclCurr20ftAmt;
		this.loclCurrCost45ftFrtRtAmt = loclCurrCost45ftFrtRtAmt;
		this.pagerows = pagerows;
		this.glineOvrWgt45ftFrtRtAmt = glineOvrWgt45ftFrtRtAmt;
		this.glineDg20ftFrtRtAmt = glineDg20ftFrtRtAmt;
		this.loclCurrCost40ftFrtRtAmt = loclCurrCost40ftFrtRtAmt;
		this.gline45ftFrtRtAmt = gline45ftFrtRtAmt;
		this.rcvDeTermCd = rcvDeTermCd;
		this.glineLoclCurr45ftAmt = glineLoclCurr45ftAmt;
		this.updUsrId = updUsrId;
		this.glineLoclCurrDg40ftAmt = glineLoclCurrDg40ftAmt;
		this.mtyTrsp40ftCostAmt = mtyTrsp40ftCostAmt;
		this.bsePortLocCd = bsePortLocCd;
		this.ihcTrfNo = ihcTrfNo;
		this.pntNodCd = pntNodCd;
		this.cost40ftFrtRtAmt = cost40ftFrtRtAmt;
		this.loclCurrCd = loclCurrCd;
		this.orgDestTpCd = orgDestTpCd;
		this.trsp40ftCostAmt = trsp40ftCostAmt;
		this.bsePortNodCd = bsePortNodCd;
		this.glineLoclCurr40ftAmt = glineLoclCurr40ftAmt;
		this.rtSeq = rtSeq;
		this.orgCost20ftFrtRtAmt = orgCost20ftFrtRtAmt;
		this.creUsrId = creUsrId;
		this.orgCost45ftFrtRtAmt = orgCost45ftFrtRtAmt;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.tml40ftCostAmt = tml40ftCostAmt;
		this.prcTrspModCd = prcTrspModCd;
		this.ihcRtRmk = ihcRtRmk;
		this.mtyTrsp45ftCostAmt = mtyTrsp45ftCostAmt;
		this.glineLoclCurrDg45ftAmt = glineLoclCurrDg45ftAmt;
		this.glineLoclCurrOvr40ftAmt = glineLoclCurrOvr40ftAmt;
		this.mb20ftRto = mb20ftRto;
		this.orgCost40ftFrtRtAmt = orgCost40ftFrtRtAmt;
		this.creDt = creDt;
		this.mtyTrsp20ftCostAmt = mtyTrsp20ftCostAmt;
		this.glineLoclCurrOvr20ftAmt = glineLoclCurrOvr20ftAmt;
		this.glineOvrWgt20ftFrtRtAmt = glineOvrWgt20ftFrtRtAmt;
		this.mb40ftRto = mb40ftRto;
		this.ibflag = ibflag;
		this.glineOvrWgt40ftFrtRtAmt = glineOvrWgt40ftFrtRtAmt;
		this.trsp45ftCostAmt = trsp45ftCostAmt;
		this.cost45ftFrtRtAmt = cost45ftFrtRtAmt;
		this.mb45ftRto = mb45ftRto;
		this.prcTrfCreTpCd = prcTrfCreTpCd;
		this.updDt = updDt;
		this.glineLoclCurrDg20ftAmt = glineLoclCurrDg20ftAmt;
		this.gline20ftFrtRtAmt = gline20ftFrtRtAmt;
		this.optmTrspModFlg = optmTrspModFlg;
		this.trsp20ftCostAmt = trsp20ftCostAmt;
		this.glineDg45ftFrtRtAmt = glineDg45ftFrtRtAmt;
		this.srcInfoCd = srcInfoCd;
		this.hubNodCd = hubNodCd;
		this.tml45ftCostAmt = tml45ftCostAmt;
		this.cost20ftFrtRtAmt = cost20ftFrtRtAmt;
		this.gline40ftFrtRtAmt = gline40ftFrtRtAmt;
		this.tml20ftCostAmt = tml20ftCostAmt;
		this.glineLoclCurrOvr45ftAmt = glineLoclCurrOvr45ftAmt;
		this.dcgoSvcFlg = dcgoSvcFlg;
		this.glineDg40ftFrtRtAmt = glineDg40ftFrtRtAmt;
		this.ihcCgoTpCd = ihcCgoTpCd;
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ihc_cost_loc_grp_no", getIhcCostLocGrpNo());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pnt_loc_cd", getPntLocCd());
		this.hashColumns.put("locl_curr_cost_20ft_frt_rt_amt", getLoclCurrCost20ftFrtRtAmt());
		this.hashColumns.put("gline_locl_curr_20ft_amt", getGlineLoclCurr20ftAmt());
		this.hashColumns.put("locl_curr_cost_45ft_frt_rt_amt", getLoclCurrCost45ftFrtRtAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gline_ovr_wgt_45ft_frt_rt_amt", getGlineOvrWgt45ftFrtRtAmt());
		this.hashColumns.put("gline_dg_20ft_frt_rt_amt", getGlineDg20ftFrtRtAmt());
		this.hashColumns.put("locl_curr_cost_40ft_frt_rt_amt", getLoclCurrCost40ftFrtRtAmt());
		this.hashColumns.put("gline_45ft_frt_rt_amt", getGline45ftFrtRtAmt());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("gline_locl_curr_45ft_amt", getGlineLoclCurr45ftAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("gline_locl_curr_dg_40ft_amt", getGlineLoclCurrDg40ftAmt());
		this.hashColumns.put("mty_trsp_40ft_cost_amt", getMtyTrsp40ftCostAmt());
		this.hashColumns.put("bse_port_loc_cd", getBsePortLocCd());
		this.hashColumns.put("ihc_trf_no", getIhcTrfNo());
		this.hashColumns.put("pnt_nod_cd", getPntNodCd());
		this.hashColumns.put("cost_40ft_frt_rt_amt", getCost40ftFrtRtAmt());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("trsp_40ft_cost_amt", getTrsp40ftCostAmt());
		this.hashColumns.put("bse_port_nod_cd", getBsePortNodCd());
		this.hashColumns.put("gline_locl_curr_40ft_amt", getGlineLoclCurr40ftAmt());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("org_cost_20ft_frt_rt_amt", getOrgCost20ftFrtRtAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("org_cost_45ft_frt_rt_amt", getOrgCost45ftFrtRtAmt());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("tml_40ft_cost_amt", getTml40ftCostAmt());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("ihc_rt_rmk", getIhcRtRmk());
		this.hashColumns.put("mty_trsp_45ft_cost_amt", getMtyTrsp45ftCostAmt());
		this.hashColumns.put("gline_locl_curr_dg_45ft_amt", getGlineLoclCurrDg45ftAmt());
		this.hashColumns.put("gline_locl_curr_ovr_40ft_amt", getGlineLoclCurrOvr40ftAmt());
		this.hashColumns.put("mb_20ft_rto", getMb20ftRto());
		this.hashColumns.put("org_cost_40ft_frt_rt_amt", getOrgCost40ftFrtRtAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mty_trsp_20ft_cost_amt", getMtyTrsp20ftCostAmt());
		this.hashColumns.put("gline_locl_curr_ovr_20ft_amt", getGlineLoclCurrOvr20ftAmt());
		this.hashColumns.put("gline_ovr_wgt_20ft_frt_rt_amt", getGlineOvrWgt20ftFrtRtAmt());
		this.hashColumns.put("mb_40ft_rto", getMb40ftRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gline_ovr_wgt_40ft_frt_rt_amt", getGlineOvrWgt40ftFrtRtAmt());
		this.hashColumns.put("trsp_45ft_cost_amt", getTrsp45ftCostAmt());
		this.hashColumns.put("cost_45ft_frt_rt_amt", getCost45ftFrtRtAmt());
		this.hashColumns.put("mb_45ft_rto", getMb45ftRto());
		this.hashColumns.put("prc_trf_cre_tp_cd", getPrcTrfCreTpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("gline_locl_curr_dg_20ft_amt", getGlineLoclCurrDg20ftAmt());
		this.hashColumns.put("gline_20ft_frt_rt_amt", getGline20ftFrtRtAmt());
		this.hashColumns.put("optm_trsp_mod_flg", getOptmTrspModFlg());
		this.hashColumns.put("trsp_20ft_cost_amt", getTrsp20ftCostAmt());
		this.hashColumns.put("gline_dg_45ft_frt_rt_amt", getGlineDg45ftFrtRtAmt());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("hub_nod_cd", getHubNodCd());
		this.hashColumns.put("tml_45ft_cost_amt", getTml45ftCostAmt());
		this.hashColumns.put("cost_20ft_frt_rt_amt", getCost20ftFrtRtAmt());
		this.hashColumns.put("gline_40ft_frt_rt_amt", getGline40ftFrtRtAmt());
		this.hashColumns.put("tml_20ft_cost_amt", getTml20ftCostAmt());
		this.hashColumns.put("gline_locl_curr_ovr_45ft_amt", getGlineLoclCurrOvr45ftAmt());
		this.hashColumns.put("dcgo_svc_flg", getDcgoSvcFlg());
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
		this.hashFields.put("ihc_cost_loc_grp_no", "ihcCostLocGrpNo");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pnt_loc_cd", "pntLocCd");
		this.hashFields.put("locl_curr_cost_20ft_frt_rt_amt", "loclCurrCost20ftFrtRtAmt");
		this.hashFields.put("gline_locl_curr_20ft_amt", "glineLoclCurr20ftAmt");
		this.hashFields.put("locl_curr_cost_45ft_frt_rt_amt", "loclCurrCost45ftFrtRtAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gline_ovr_wgt_45ft_frt_rt_amt", "glineOvrWgt45ftFrtRtAmt");
		this.hashFields.put("gline_dg_20ft_frt_rt_amt", "glineDg20ftFrtRtAmt");
		this.hashFields.put("locl_curr_cost_40ft_frt_rt_amt", "loclCurrCost40ftFrtRtAmt");
		this.hashFields.put("gline_45ft_frt_rt_amt", "gline45ftFrtRtAmt");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("gline_locl_curr_45ft_amt", "glineLoclCurr45ftAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("gline_locl_curr_dg_40ft_amt", "glineLoclCurrDg40ftAmt");
		this.hashFields.put("mty_trsp_40ft_cost_amt", "mtyTrsp40ftCostAmt");
		this.hashFields.put("bse_port_loc_cd", "bsePortLocCd");
		this.hashFields.put("ihc_trf_no", "ihcTrfNo");
		this.hashFields.put("pnt_nod_cd", "pntNodCd");
		this.hashFields.put("cost_40ft_frt_rt_amt", "cost40ftFrtRtAmt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("trsp_40ft_cost_amt", "trsp40ftCostAmt");
		this.hashFields.put("bse_port_nod_cd", "bsePortNodCd");
		this.hashFields.put("gline_locl_curr_40ft_amt", "glineLoclCurr40ftAmt");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("org_cost_20ft_frt_rt_amt", "orgCost20ftFrtRtAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("org_cost_45ft_frt_rt_amt", "orgCost45ftFrtRtAmt");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("tml_40ft_cost_amt", "tml40ftCostAmt");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("ihc_rt_rmk", "ihcRtRmk");
		this.hashFields.put("mty_trsp_45ft_cost_amt", "mtyTrsp45ftCostAmt");
		this.hashFields.put("gline_locl_curr_dg_45ft_amt", "glineLoclCurrDg45ftAmt");
		this.hashFields.put("gline_locl_curr_ovr_40ft_amt", "glineLoclCurrOvr40ftAmt");
		this.hashFields.put("mb_20ft_rto", "mb20ftRto");
		this.hashFields.put("org_cost_40ft_frt_rt_amt", "orgCost40ftFrtRtAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mty_trsp_20ft_cost_amt", "mtyTrsp20ftCostAmt");
		this.hashFields.put("gline_locl_curr_ovr_20ft_amt", "glineLoclCurrOvr20ftAmt");
		this.hashFields.put("gline_ovr_wgt_20ft_frt_rt_amt", "glineOvrWgt20ftFrtRtAmt");
		this.hashFields.put("mb_40ft_rto", "mb40ftRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gline_ovr_wgt_40ft_frt_rt_amt", "glineOvrWgt40ftFrtRtAmt");
		this.hashFields.put("trsp_45ft_cost_amt", "trsp45ftCostAmt");
		this.hashFields.put("cost_45ft_frt_rt_amt", "cost45ftFrtRtAmt");
		this.hashFields.put("mb_45ft_rto", "mb45ftRto");
		this.hashFields.put("prc_trf_cre_tp_cd", "prcTrfCreTpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("gline_locl_curr_dg_20ft_amt", "glineLoclCurrDg20ftAmt");
		this.hashFields.put("gline_20ft_frt_rt_amt", "gline20ftFrtRtAmt");
		this.hashFields.put("optm_trsp_mod_flg", "optmTrspModFlg");
		this.hashFields.put("trsp_20ft_cost_amt", "trsp20ftCostAmt");
		this.hashFields.put("gline_dg_45ft_frt_rt_amt", "glineDg45ftFrtRtAmt");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("hub_nod_cd", "hubNodCd");
		this.hashFields.put("tml_45ft_cost_amt", "tml45ftCostAmt");
		this.hashFields.put("cost_20ft_frt_rt_amt", "cost20ftFrtRtAmt");
		this.hashFields.put("gline_40ft_frt_rt_amt", "gline40ftFrtRtAmt");
		this.hashFields.put("tml_20ft_cost_amt", "tml20ftCostAmt");
		this.hashFields.put("gline_locl_curr_ovr_45ft_amt", "glineLoclCurrOvr45ftAmt");
		this.hashFields.put("dcgo_svc_flg", "dcgoSvcFlg");
		this.hashFields.put("gline_dg_40ft_frt_rt_amt", "glineDg40ftFrtRtAmt");
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
	 * @return glineOvrWgt45ftFrtRtAmt
	 */
	public String getGlineOvrWgt45ftFrtRtAmt() {
		return this.glineOvrWgt45ftFrtRtAmt;
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
	 * @return loclCurrCost40ftFrtRtAmt
	 */
	public String getLoclCurrCost40ftFrtRtAmt() {
		return this.loclCurrCost40ftFrtRtAmt;
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
	 * @return glineLoclCurr45ftAmt
	 */
	public String getGlineLoclCurr45ftAmt() {
		return this.glineLoclCurr45ftAmt;
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
	 * @return mtyTrsp40ftCostAmt
	 */
	public String getMtyTrsp40ftCostAmt() {
		return this.mtyTrsp40ftCostAmt;
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
	 * @return pntNodCd
	 */
	public String getPntNodCd() {
		return this.pntNodCd;
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
	 * @return orgCost20ftFrtRtAmt
	 */
	public String getOrgCost20ftFrtRtAmt() {
		return this.orgCost20ftFrtRtAmt;
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
	 * @return orgCost45ftFrtRtAmt
	 */
	public String getOrgCost45ftFrtRtAmt() {
		return this.orgCost45ftFrtRtAmt;
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
	 * @return tml40ftCostAmt
	 */
	public String getTml40ftCostAmt() {
		return this.tml40ftCostAmt;
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
	 * @return ihcRtRmk
	 */
	public String getIhcRtRmk() {
		return this.ihcRtRmk;
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
	 * @return glineLoclCurrDg45ftAmt
	 */
	public String getGlineLoclCurrDg45ftAmt() {
		return this.glineLoclCurrDg45ftAmt;
	}
	
	/**
	 * Column Info
	 * @return glineLoclCurrOvr40ftAmt
	 */
	public String getGlineLoclCurrOvr40ftAmt() {
		return this.glineLoclCurrOvr40ftAmt;
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
	 * @return orgCost40ftFrtRtAmt
	 */
	public String getOrgCost40ftFrtRtAmt() {
		return this.orgCost40ftFrtRtAmt;
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
	 * @return mtyTrsp20ftCostAmt
	 */
	public String getMtyTrsp20ftCostAmt() {
		return this.mtyTrsp20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return glineLoclCurrOvr20ftAmt
	 */
	public String getGlineLoclCurrOvr20ftAmt() {
		return this.glineLoclCurrOvr20ftAmt;
	}
	
	/**
	 * Column Info
	 * @return glineOvrWgt20ftFrtRtAmt
	 */
	public String getGlineOvrWgt20ftFrtRtAmt() {
		return this.glineOvrWgt20ftFrtRtAmt;
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
	 * @return glineOvrWgt40ftFrtRtAmt
	 */
	public String getGlineOvrWgt40ftFrtRtAmt() {
		return this.glineOvrWgt40ftFrtRtAmt;
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
	 * @return cost45ftFrtRtAmt
	 */
	public String getCost45ftFrtRtAmt() {
		return this.cost45ftFrtRtAmt;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return optmTrspModFlg
	 */
	public String getOptmTrspModFlg() {
		return this.optmTrspModFlg;
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
	 * @return cost20ftFrtRtAmt
	 */
	public String getCost20ftFrtRtAmt() {
		return this.cost20ftFrtRtAmt;
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
	 * @return tml20ftCostAmt
	 */
	public String getTml20ftCostAmt() {
		return this.tml20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return glineLoclCurrOvr45ftAmt
	 */
	public String getGlineLoclCurrOvr45ftAmt() {
		return this.glineLoclCurrOvr45ftAmt;
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
	 * @param ihcCostLocGrpNo
	 */
	public void setIhcCostLocGrpNo(String ihcCostLocGrpNo) {
		this.ihcCostLocGrpNo = ihcCostLocGrpNo;
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
	 * @param glineOvrWgt45ftFrtRtAmt
	 */
	public void setGlineOvrWgt45ftFrtRtAmt(String glineOvrWgt45ftFrtRtAmt) {
		this.glineOvrWgt45ftFrtRtAmt = glineOvrWgt45ftFrtRtAmt;
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
	 * @param loclCurrCost40ftFrtRtAmt
	 */
	public void setLoclCurrCost40ftFrtRtAmt(String loclCurrCost40ftFrtRtAmt) {
		this.loclCurrCost40ftFrtRtAmt = loclCurrCost40ftFrtRtAmt;
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
	 * @param glineLoclCurr45ftAmt
	 */
	public void setGlineLoclCurr45ftAmt(String glineLoclCurr45ftAmt) {
		this.glineLoclCurr45ftAmt = glineLoclCurr45ftAmt;
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
	 * @param mtyTrsp40ftCostAmt
	 */
	public void setMtyTrsp40ftCostAmt(String mtyTrsp40ftCostAmt) {
		this.mtyTrsp40ftCostAmt = mtyTrsp40ftCostAmt;
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
	 * @param pntNodCd
	 */
	public void setPntNodCd(String pntNodCd) {
		this.pntNodCd = pntNodCd;
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
	 * @param orgCost20ftFrtRtAmt
	 */
	public void setOrgCost20ftFrtRtAmt(String orgCost20ftFrtRtAmt) {
		this.orgCost20ftFrtRtAmt = orgCost20ftFrtRtAmt;
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
	 * @param orgCost45ftFrtRtAmt
	 */
	public void setOrgCost45ftFrtRtAmt(String orgCost45ftFrtRtAmt) {
		this.orgCost45ftFrtRtAmt = orgCost45ftFrtRtAmt;
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
	 * @param tml40ftCostAmt
	 */
	public void setTml40ftCostAmt(String tml40ftCostAmt) {
		this.tml40ftCostAmt = tml40ftCostAmt;
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
	 * @param ihcRtRmk
	 */
	public void setIhcRtRmk(String ihcRtRmk) {
		this.ihcRtRmk = ihcRtRmk;
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
	 * @param glineLoclCurrDg45ftAmt
	 */
	public void setGlineLoclCurrDg45ftAmt(String glineLoclCurrDg45ftAmt) {
		this.glineLoclCurrDg45ftAmt = glineLoclCurrDg45ftAmt;
	}
	
	/**
	 * Column Info
	 * @param glineLoclCurrOvr40ftAmt
	 */
	public void setGlineLoclCurrOvr40ftAmt(String glineLoclCurrOvr40ftAmt) {
		this.glineLoclCurrOvr40ftAmt = glineLoclCurrOvr40ftAmt;
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
	 * @param orgCost40ftFrtRtAmt
	 */
	public void setOrgCost40ftFrtRtAmt(String orgCost40ftFrtRtAmt) {
		this.orgCost40ftFrtRtAmt = orgCost40ftFrtRtAmt;
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
	 * @param mtyTrsp20ftCostAmt
	 */
	public void setMtyTrsp20ftCostAmt(String mtyTrsp20ftCostAmt) {
		this.mtyTrsp20ftCostAmt = mtyTrsp20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param glineLoclCurrOvr20ftAmt
	 */
	public void setGlineLoclCurrOvr20ftAmt(String glineLoclCurrOvr20ftAmt) {
		this.glineLoclCurrOvr20ftAmt = glineLoclCurrOvr20ftAmt;
	}
	
	/**
	 * Column Info
	 * @param glineOvrWgt20ftFrtRtAmt
	 */
	public void setGlineOvrWgt20ftFrtRtAmt(String glineOvrWgt20ftFrtRtAmt) {
		this.glineOvrWgt20ftFrtRtAmt = glineOvrWgt20ftFrtRtAmt;
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
	 * @param glineOvrWgt40ftFrtRtAmt
	 */
	public void setGlineOvrWgt40ftFrtRtAmt(String glineOvrWgt40ftFrtRtAmt) {
		this.glineOvrWgt40ftFrtRtAmt = glineOvrWgt40ftFrtRtAmt;
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
	 * @param cost45ftFrtRtAmt
	 */
	public void setCost45ftFrtRtAmt(String cost45ftFrtRtAmt) {
		this.cost45ftFrtRtAmt = cost45ftFrtRtAmt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param optmTrspModFlg
	 */
	public void setOptmTrspModFlg(String optmTrspModFlg) {
		this.optmTrspModFlg = optmTrspModFlg;
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
	 * @param cost20ftFrtRtAmt
	 */
	public void setCost20ftFrtRtAmt(String cost20ftFrtRtAmt) {
		this.cost20ftFrtRtAmt = cost20ftFrtRtAmt;
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
	 * @param tml20ftCostAmt
	 */
	public void setTml20ftCostAmt(String tml20ftCostAmt) {
		this.tml20ftCostAmt = tml20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param glineLoclCurrOvr45ftAmt
	 */
	public void setGlineLoclCurrOvr45ftAmt(String glineLoclCurrOvr45ftAmt) {
		this.glineLoclCurrOvr45ftAmt = glineLoclCurrOvr45ftAmt;
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
		setIhcCostLocGrpNo(JSPUtil.getParameter(request, prefix + "ihc_cost_loc_grp_no", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPntLocCd(JSPUtil.getParameter(request, prefix + "pnt_loc_cd", ""));
		setLoclCurrCost20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "locl_curr_cost_20ft_frt_rt_amt", ""));
		setGlineLoclCurr20ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_20ft_amt", ""));
		setLoclCurrCost45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "locl_curr_cost_45ft_frt_rt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setGlineOvrWgt45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_ovr_wgt_45ft_frt_rt_amt", ""));
		setGlineDg20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_dg_20ft_frt_rt_amt", ""));
		setLoclCurrCost40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "locl_curr_cost_40ft_frt_rt_amt", ""));
		setGline45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_45ft_frt_rt_amt", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setGlineLoclCurr45ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_45ft_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setGlineLoclCurrDg40ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_dg_40ft_amt", ""));
		setMtyTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_amt", ""));
		setBsePortLocCd(JSPUtil.getParameter(request, prefix + "bse_port_loc_cd", ""));
		setIhcTrfNo(JSPUtil.getParameter(request, prefix + "ihc_trf_no", ""));
		setPntNodCd(JSPUtil.getParameter(request, prefix + "pnt_nod_cd", ""));
		setCost40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_40ft_frt_rt_amt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_cost_amt", ""));
		setBsePortNodCd(JSPUtil.getParameter(request, prefix + "bse_port_nod_cd", ""));
		setGlineLoclCurr40ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_40ft_amt", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setOrgCost20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "org_cost_20ft_frt_rt_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setOrgCost45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "org_cost_45ft_frt_rt_amt", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setTml40ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_amt", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd", ""));
		setIhcRtRmk(JSPUtil.getParameter(request, prefix + "ihc_rt_rmk", ""));
		setMtyTrsp45ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_45ft_cost_amt", ""));
		setGlineLoclCurrDg45ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_dg_45ft_amt", ""));
		setGlineLoclCurrOvr40ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_ovr_40ft_amt", ""));
		setMb20ftRto(JSPUtil.getParameter(request, prefix + "mb_20ft_rto", ""));
		setOrgCost40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "org_cost_40ft_frt_rt_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMtyTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_amt", ""));
		setGlineLoclCurrOvr20ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_ovr_20ft_amt", ""));
		setGlineOvrWgt20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_ovr_wgt_20ft_frt_rt_amt", ""));
		setMb40ftRto(JSPUtil.getParameter(request, prefix + "mb_40ft_rto", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGlineOvrWgt40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_ovr_wgt_40ft_frt_rt_amt", ""));
		setTrsp45ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_45ft_cost_amt", ""));
		setCost45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_45ft_frt_rt_amt", ""));
		setMb45ftRto(JSPUtil.getParameter(request, prefix + "mb_45ft_rto", ""));
		setPrcTrfCreTpCd(JSPUtil.getParameter(request, prefix + "prc_trf_cre_tp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setGlineLoclCurrDg20ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_dg_20ft_amt", ""));
		setGline20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_20ft_frt_rt_amt", ""));
		setOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg", ""));
		setTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_cost_amt", ""));
		setGlineDg45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_dg_45ft_frt_rt_amt", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, prefix + "src_info_cd", ""));
		setHubNodCd(JSPUtil.getParameter(request, prefix + "hub_nod_cd", ""));
		setTml45ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_45ft_cost_amt", ""));
		setCost20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_20ft_frt_rt_amt", ""));
		setGline40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_40ft_frt_rt_amt", ""));
		setTml20ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_amt", ""));
		setGlineLoclCurrOvr45ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_ovr_45ft_amt", ""));
		setDcgoSvcFlg(JSPUtil.getParameter(request, prefix + "dcgo_svc_flg", ""));
		setGlineDg40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_dg_40ft_frt_rt_amt", ""));
		setIhcCgoTpCd(JSPUtil.getParameter(request, prefix + "ihc_cgo_tp_cd", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriTrfIHCRtVO[]
	 */
	public PriTrfIHCRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriTrfIHCRtVO[]
	 */
	public PriTrfIHCRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriTrfIHCRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ihcCostLocGrpNo = (JSPUtil.getParameter(request, prefix	+ "ihc_cost_loc_grp_no", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] pntLocCd = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_cd", length));
			String[] loclCurrCost20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cost_20ft_frt_rt_amt", length));
			String[] glineLoclCurr20ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_20ft_amt", length));
			String[] loclCurrCost45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cost_45ft_frt_rt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] glineOvrWgt45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_ovr_wgt_45ft_frt_rt_amt", length));
			String[] glineDg20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_dg_20ft_frt_rt_amt", length));
			String[] loclCurrCost40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cost_40ft_frt_rt_amt", length));
			String[] gline45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_45ft_frt_rt_amt", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] glineLoclCurr45ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_45ft_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] glineLoclCurrDg40ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_dg_40ft_amt", length));
			String[] mtyTrsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_amt", length));
			String[] bsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_loc_cd", length));
			String[] ihcTrfNo = (JSPUtil.getParameter(request, prefix	+ "ihc_trf_no", length));
			String[] pntNodCd = (JSPUtil.getParameter(request, prefix	+ "pnt_nod_cd", length));
			String[] cost40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_40ft_frt_rt_amt", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] trsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_cost_amt", length));
			String[] bsePortNodCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_nod_cd", length));
			String[] glineLoclCurr40ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_40ft_amt", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] orgCost20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "org_cost_20ft_frt_rt_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] orgCost45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "org_cost_45ft_frt_rt_amt", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] tml40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_amt", length));
			String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd", length));
			String[] ihcRtRmk = (JSPUtil.getParameter(request, prefix	+ "ihc_rt_rmk", length));
			String[] mtyTrsp45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_45ft_cost_amt", length));
			String[] glineLoclCurrDg45ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_dg_45ft_amt", length));
			String[] glineLoclCurrOvr40ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_ovr_40ft_amt", length));
			String[] mb20ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_20ft_rto", length));
			String[] orgCost40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "org_cost_40ft_frt_rt_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mtyTrsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_amt", length));
			String[] glineLoclCurrOvr20ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_ovr_20ft_amt", length));
			String[] glineOvrWgt20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_ovr_wgt_20ft_frt_rt_amt", length));
			String[] mb40ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_40ft_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] glineOvrWgt40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_ovr_wgt_40ft_frt_rt_amt", length));
			String[] trsp45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_cost_amt", length));
			String[] cost45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_45ft_frt_rt_amt", length));
			String[] mb45ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_45ft_rto", length));
			String[] prcTrfCreTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_trf_cre_tp_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] glineLoclCurrDg20ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_dg_20ft_amt", length));
			String[] gline20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_20ft_frt_rt_amt", length));
			String[] optmTrspModFlg = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_flg", length));
			String[] trsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_cost_amt", length));
			String[] glineDg45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_dg_45ft_frt_rt_amt", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] hubNodCd = (JSPUtil.getParameter(request, prefix	+ "hub_nod_cd", length));
			String[] tml45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_45ft_cost_amt", length));
			String[] cost20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_20ft_frt_rt_amt", length));
			String[] gline40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_40ft_frt_rt_amt", length));
			String[] tml20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_amt", length));
			String[] glineLoclCurrOvr45ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_ovr_45ft_amt", length));
			String[] dcgoSvcFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_svc_flg", length));
			String[] glineDg40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_dg_40ft_frt_rt_amt", length));
			String[] ihcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "ihc_cgo_tp_cd", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriTrfIHCRtVO();
				if (ihcCostLocGrpNo[i] != null)
					model.setIhcCostLocGrpNo(ihcCostLocGrpNo[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (pntLocCd[i] != null)
					model.setPntLocCd(pntLocCd[i]);
				if (loclCurrCost20ftFrtRtAmt[i] != null)
					model.setLoclCurrCost20ftFrtRtAmt(loclCurrCost20ftFrtRtAmt[i]);
				if (glineLoclCurr20ftAmt[i] != null)
					model.setGlineLoclCurr20ftAmt(glineLoclCurr20ftAmt[i]);
				if (loclCurrCost45ftFrtRtAmt[i] != null)
					model.setLoclCurrCost45ftFrtRtAmt(loclCurrCost45ftFrtRtAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (glineOvrWgt45ftFrtRtAmt[i] != null)
					model.setGlineOvrWgt45ftFrtRtAmt(glineOvrWgt45ftFrtRtAmt[i]);
				if (glineDg20ftFrtRtAmt[i] != null)
					model.setGlineDg20ftFrtRtAmt(glineDg20ftFrtRtAmt[i]);
				if (loclCurrCost40ftFrtRtAmt[i] != null)
					model.setLoclCurrCost40ftFrtRtAmt(loclCurrCost40ftFrtRtAmt[i]);
				if (gline45ftFrtRtAmt[i] != null)
					model.setGline45ftFrtRtAmt(gline45ftFrtRtAmt[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (glineLoclCurr45ftAmt[i] != null)
					model.setGlineLoclCurr45ftAmt(glineLoclCurr45ftAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (glineLoclCurrDg40ftAmt[i] != null)
					model.setGlineLoclCurrDg40ftAmt(glineLoclCurrDg40ftAmt[i]);
				if (mtyTrsp40ftCostAmt[i] != null)
					model.setMtyTrsp40ftCostAmt(mtyTrsp40ftCostAmt[i]);
				if (bsePortLocCd[i] != null)
					model.setBsePortLocCd(bsePortLocCd[i]);
				if (ihcTrfNo[i] != null)
					model.setIhcTrfNo(ihcTrfNo[i]);
				if (pntNodCd[i] != null)
					model.setPntNodCd(pntNodCd[i]);
				if (cost40ftFrtRtAmt[i] != null)
					model.setCost40ftFrtRtAmt(cost40ftFrtRtAmt[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (trsp40ftCostAmt[i] != null)
					model.setTrsp40ftCostAmt(trsp40ftCostAmt[i]);
				if (bsePortNodCd[i] != null)
					model.setBsePortNodCd(bsePortNodCd[i]);
				if (glineLoclCurr40ftAmt[i] != null)
					model.setGlineLoclCurr40ftAmt(glineLoclCurr40ftAmt[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (orgCost20ftFrtRtAmt[i] != null)
					model.setOrgCost20ftFrtRtAmt(orgCost20ftFrtRtAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (orgCost45ftFrtRtAmt[i] != null)
					model.setOrgCost45ftFrtRtAmt(orgCost45ftFrtRtAmt[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (tml40ftCostAmt[i] != null)
					model.setTml40ftCostAmt(tml40ftCostAmt[i]);
				if (prcTrspModCd[i] != null)
					model.setPrcTrspModCd(prcTrspModCd[i]);
				if (ihcRtRmk[i] != null)
					model.setIhcRtRmk(ihcRtRmk[i]);
				if (mtyTrsp45ftCostAmt[i] != null)
					model.setMtyTrsp45ftCostAmt(mtyTrsp45ftCostAmt[i]);
				if (glineLoclCurrDg45ftAmt[i] != null)
					model.setGlineLoclCurrDg45ftAmt(glineLoclCurrDg45ftAmt[i]);
				if (glineLoclCurrOvr40ftAmt[i] != null)
					model.setGlineLoclCurrOvr40ftAmt(glineLoclCurrOvr40ftAmt[i]);
				if (mb20ftRto[i] != null)
					model.setMb20ftRto(mb20ftRto[i]);
				if (orgCost40ftFrtRtAmt[i] != null)
					model.setOrgCost40ftFrtRtAmt(orgCost40ftFrtRtAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mtyTrsp20ftCostAmt[i] != null)
					model.setMtyTrsp20ftCostAmt(mtyTrsp20ftCostAmt[i]);
				if (glineLoclCurrOvr20ftAmt[i] != null)
					model.setGlineLoclCurrOvr20ftAmt(glineLoclCurrOvr20ftAmt[i]);
				if (glineOvrWgt20ftFrtRtAmt[i] != null)
					model.setGlineOvrWgt20ftFrtRtAmt(glineOvrWgt20ftFrtRtAmt[i]);
				if (mb40ftRto[i] != null)
					model.setMb40ftRto(mb40ftRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (glineOvrWgt40ftFrtRtAmt[i] != null)
					model.setGlineOvrWgt40ftFrtRtAmt(glineOvrWgt40ftFrtRtAmt[i]);
				if (trsp45ftCostAmt[i] != null)
					model.setTrsp45ftCostAmt(trsp45ftCostAmt[i]);
				if (cost45ftFrtRtAmt[i] != null)
					model.setCost45ftFrtRtAmt(cost45ftFrtRtAmt[i]);
				if (mb45ftRto[i] != null)
					model.setMb45ftRto(mb45ftRto[i]);
				if (prcTrfCreTpCd[i] != null)
					model.setPrcTrfCreTpCd(prcTrfCreTpCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (glineLoclCurrDg20ftAmt[i] != null)
					model.setGlineLoclCurrDg20ftAmt(glineLoclCurrDg20ftAmt[i]);
				if (gline20ftFrtRtAmt[i] != null)
					model.setGline20ftFrtRtAmt(gline20ftFrtRtAmt[i]);
				if (optmTrspModFlg[i] != null)
					model.setOptmTrspModFlg(optmTrspModFlg[i]);
				if (trsp20ftCostAmt[i] != null)
					model.setTrsp20ftCostAmt(trsp20ftCostAmt[i]);
				if (glineDg45ftFrtRtAmt[i] != null)
					model.setGlineDg45ftFrtRtAmt(glineDg45ftFrtRtAmt[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (hubNodCd[i] != null)
					model.setHubNodCd(hubNodCd[i]);
				if (tml45ftCostAmt[i] != null)
					model.setTml45ftCostAmt(tml45ftCostAmt[i]);
				if (cost20ftFrtRtAmt[i] != null)
					model.setCost20ftFrtRtAmt(cost20ftFrtRtAmt[i]);
				if (gline40ftFrtRtAmt[i] != null)
					model.setGline40ftFrtRtAmt(gline40ftFrtRtAmt[i]);
				if (tml20ftCostAmt[i] != null)
					model.setTml20ftCostAmt(tml20ftCostAmt[i]);
				if (glineLoclCurrOvr45ftAmt[i] != null)
					model.setGlineLoclCurrOvr45ftAmt(glineLoclCurrOvr45ftAmt[i]);
				if (dcgoSvcFlg[i] != null)
					model.setDcgoSvcFlg(dcgoSvcFlg[i]);
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
		return getPriTrfIHCRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriTrfIHCRtVO[]
	 */
	public PriTrfIHCRtVO[] getPriTrfIHCRtVOs(){
		PriTrfIHCRtVO[] vos = (PriTrfIHCRtVO[])models.toArray(new PriTrfIHCRtVO[models.size()]);
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
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocCd = this.pntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCost20ftFrtRtAmt = this.loclCurrCost20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurr20ftAmt = this.glineLoclCurr20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCost45ftFrtRtAmt = this.loclCurrCost45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineOvrWgt45ftFrtRtAmt = this.glineOvrWgt45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineDg20ftFrtRtAmt = this.glineDg20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCost40ftFrtRtAmt = this.loclCurrCost40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline45ftFrtRtAmt = this.gline45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurr45ftAmt = this.glineLoclCurr45ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurrDg40ftAmt = this.glineLoclCurrDg40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostAmt = this.mtyTrsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortLocCd = this.bsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfNo = this.ihcTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntNodCd = this.pntNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost40ftFrtRtAmt = this.cost40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftCostAmt = this.trsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortNodCd = this.bsePortNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurr40ftAmt = this.glineLoclCurr40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCost20ftFrtRtAmt = this.orgCost20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCost45ftFrtRtAmt = this.orgCost45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostAmt = this.tml40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd = this.prcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcRtRmk = this.ihcRtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp45ftCostAmt = this.mtyTrsp45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurrDg45ftAmt = this.glineLoclCurrDg45ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurrOvr40ftAmt = this.glineLoclCurrOvr40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb20ftRto = this.mb20ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCost40ftFrtRtAmt = this.orgCost40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostAmt = this.mtyTrsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurrOvr20ftAmt = this.glineLoclCurrOvr20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineOvrWgt20ftFrtRtAmt = this.glineOvrWgt20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb40ftRto = this.mb40ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineOvrWgt40ftFrtRtAmt = this.glineOvrWgt40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftCostAmt = this.trsp45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost45ftFrtRtAmt = this.cost45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb45ftRto = this.mb45ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrfCreTpCd = this.prcTrfCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurrDg20ftAmt = this.glineLoclCurrDg20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline20ftFrtRtAmt = this.gline20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlg = this.optmTrspModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftCostAmt = this.trsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineDg45ftFrtRtAmt = this.glineDg45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubNodCd = this.hubNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml45ftCostAmt = this.tml45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost20ftFrtRtAmt = this.cost20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline40ftFrtRtAmt = this.gline40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostAmt = this.tml20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurrOvr45ftAmt = this.glineLoclCurrOvr45ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSvcFlg = this.dcgoSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineDg40ftFrtRtAmt = this.glineDg40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcCgoTpCd = this.ihcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
