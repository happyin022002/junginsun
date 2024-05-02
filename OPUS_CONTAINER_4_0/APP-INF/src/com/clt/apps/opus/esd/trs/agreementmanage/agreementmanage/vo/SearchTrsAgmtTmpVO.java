/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchTrsAgmtTmpVO.java
*@FileTitle : SearchTrsAgmtTmpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.20  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTrsAgmtTmpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTrsAgmtTmpVO> models = new ArrayList<SearchTrsAgmtTmpVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String rtUpdStsCd = null;
	/* Column Info */
	private String woAplyFlg = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String trspRndRt = null;
	/* Column Info */
	private String trspAgmtRtTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trspAgmtEqSzCd = null;
	/* Column Info */
	private String agmtRmk = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String trspScgCd = null;
	/* Column Info */
	private String trspTmpSeq = null;
	/* Column Info */
	private String trspOneWyRt = null;
	/* Column Info */
	private String trspAgmtDist = null;
	/* Column Info */
	private String comScgAplyFlg = null;
	/* Column Info */
	private String cmdtGrpCd = null;
	/* Column Info */
	private String distMeasUtCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String trspAgmtSeq = null;
	/* Column Info */
	private String wgtMeasUtCd = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String railSvcTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String agmtRoutAllFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String toWgt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trspAgmtOfcCtyCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wtrRcvTermCd = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String wtrDeTermCd = null;
	/* Column Info */
	private String trspRvsAplyFlg = null;
	/* Column Info */
	private String subRowNo = null;
	/* Column Info */
	private String agmtScgRtDivCd = null;
	/* Column Info */
	private String trspAgmtEqTpCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String trspCostModCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String agmtTrspTpCd = null;
	/* Column Info */
	private String trspDistTpCd = null;
	/* Column Info */
	private String trspAgmtBdlQty = null;
	/* Column Info */
	private String rowNo = null;
	/* Column Info */
	private String custNomiTrkrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchTrsAgmtTmpVO() {}

	public SearchTrsAgmtTmpVO(String ibflag, String pagerows, String trspTmpSeq, String trspAgmtOfcCtyCd, String trspAgmtSeq, String eqKndCd, String cgoTpCd, String agmtTrspTpCd, String trspCostModCd, String custNomiTrkrFlg, String cmdtGrpCd, String railSvcTpCd, String custCntCd, String custSeq, String fmNodCd, String viaNodCd, String dorNodCd, String toNodCd, String trspAgmtEqTpCd, String trspAgmtEqSzCd, String eqTpszCd, String effFmDt, String effToDt, String wgtMeasUtCd, String toWgt, String currCd, String trspOneWyRt, String trspRndRt, String trspAgmtRtTpCd, String trspAgmtBdlQty, String wtrRcvTermCd, String wtrDeTermCd, String trspAgmtDist, String distMeasUtCd, String trspDistTpCd, String trspScgCd, String trspRvsAplyFlg, String agmtRmk, String rowNo, String subRowNo, String creUsrId, String creDt, String updUsrId, String updDt, String agmtRoutAllFlg, String deltFlg, String rtUpdStsCd, String agmtScgRtDivCd, String comScgAplyFlg, String woAplyFlg) {
		this.toNodCd = toNodCd;
		this.rtUpdStsCd = rtUpdStsCd;
		this.woAplyFlg = woAplyFlg;
		this.cgoTpCd = cgoTpCd;
		this.trspRndRt = trspRndRt;
		this.trspAgmtRtTpCd = trspAgmtRtTpCd;
		this.pagerows = pagerows;
		this.trspAgmtEqSzCd = trspAgmtEqSzCd;
		this.agmtRmk = agmtRmk;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
		this.trspScgCd = trspScgCd;
		this.trspTmpSeq = trspTmpSeq;
		this.trspOneWyRt = trspOneWyRt;
		this.trspAgmtDist = trspAgmtDist;
		this.comScgAplyFlg = comScgAplyFlg;
		this.cmdtGrpCd = cmdtGrpCd;
		this.distMeasUtCd = distMeasUtCd;
		this.eqTpszCd = eqTpszCd;
		this.creUsrId = creUsrId;
		this.trspAgmtSeq = trspAgmtSeq;
		this.wgtMeasUtCd = wgtMeasUtCd;
		this.effToDt = effToDt;
		this.railSvcTpCd = railSvcTpCd;
		this.currCd = currCd;
		this.agmtRoutAllFlg = agmtRoutAllFlg;
		this.deltFlg = deltFlg;
		this.toWgt = toWgt;
		this.creDt = creDt;
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
		this.ibflag = ibflag;
		this.wtrRcvTermCd = wtrRcvTermCd;
		this.dorNodCd = dorNodCd;
		this.effFmDt = effFmDt;
		this.wtrDeTermCd = wtrDeTermCd;
		this.trspRvsAplyFlg = trspRvsAplyFlg;
		this.subRowNo = subRowNo;
		this.agmtScgRtDivCd = agmtScgRtDivCd;
		this.trspAgmtEqTpCd = trspAgmtEqTpCd;
		this.updDt = updDt;
		this.trspCostModCd = trspCostModCd;
		this.eqKndCd = eqKndCd;
		this.custSeq = custSeq;
		this.fmNodCd = fmNodCd;
		this.viaNodCd = viaNodCd;
		this.agmtTrspTpCd = agmtTrspTpCd;
		this.trspDistTpCd = trspDistTpCd;
		this.trspAgmtBdlQty = trspAgmtBdlQty;
		this.rowNo = rowNo;
		this.custNomiTrkrFlg = custNomiTrkrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("rt_upd_sts_cd", getRtUpdStsCd());
		this.hashColumns.put("wo_aply_flg", getWoAplyFlg());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("trsp_rnd_rt", getTrspRndRt());
		this.hashColumns.put("trsp_agmt_rt_tp_cd", getTrspAgmtRtTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsp_agmt_eq_sz_cd", getTrspAgmtEqSzCd());
		this.hashColumns.put("agmt_rmk", getAgmtRmk());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("trsp_scg_cd", getTrspScgCd());
		this.hashColumns.put("trsp_tmp_seq", getTrspTmpSeq());
		this.hashColumns.put("trsp_one_wy_rt", getTrspOneWyRt());
		this.hashColumns.put("trsp_agmt_dist", getTrspAgmtDist());
		this.hashColumns.put("com_scg_aply_flg", getComScgAplyFlg());
		this.hashColumns.put("cmdt_grp_cd", getCmdtGrpCd());
		this.hashColumns.put("dist_meas_ut_cd", getDistMeasUtCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("trsp_agmt_seq", getTrspAgmtSeq());
		this.hashColumns.put("wgt_meas_ut_cd", getWgtMeasUtCd());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("rail_svc_tp_cd", getRailSvcTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("agmt_rout_all_flg", getAgmtRoutAllFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("to_wgt", getToWgt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trsp_agmt_ofc_cty_cd", getTrspAgmtOfcCtyCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wtr_rcv_term_cd", getWtrRcvTermCd());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("wtr_de_term_cd", getWtrDeTermCd());
		this.hashColumns.put("trsp_rvs_aply_flg", getTrspRvsAplyFlg());
		this.hashColumns.put("sub_row_no", getSubRowNo());
		this.hashColumns.put("agmt_scg_rt_div_cd", getAgmtScgRtDivCd());
		this.hashColumns.put("trsp_agmt_eq_tp_cd", getTrspAgmtEqTpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("trsp_cost_mod_cd", getTrspCostModCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("agmt_trsp_tp_cd", getAgmtTrspTpCd());
		this.hashColumns.put("trsp_dist_tp_cd", getTrspDistTpCd());
		this.hashColumns.put("trsp_agmt_bdl_qty", getTrspAgmtBdlQty());
		this.hashColumns.put("row_no", getRowNo());
		this.hashColumns.put("cust_nomi_trkr_flg", getCustNomiTrkrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("rt_upd_sts_cd", "rtUpdStsCd");
		this.hashFields.put("wo_aply_flg", "woAplyFlg");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("trsp_rnd_rt", "trspRndRt");
		this.hashFields.put("trsp_agmt_rt_tp_cd", "trspAgmtRtTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsp_agmt_eq_sz_cd", "trspAgmtEqSzCd");
		this.hashFields.put("agmt_rmk", "agmtRmk");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("trsp_scg_cd", "trspScgCd");
		this.hashFields.put("trsp_tmp_seq", "trspTmpSeq");
		this.hashFields.put("trsp_one_wy_rt", "trspOneWyRt");
		this.hashFields.put("trsp_agmt_dist", "trspAgmtDist");
		this.hashFields.put("com_scg_aply_flg", "comScgAplyFlg");
		this.hashFields.put("cmdt_grp_cd", "cmdtGrpCd");
		this.hashFields.put("dist_meas_ut_cd", "distMeasUtCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("trsp_agmt_seq", "trspAgmtSeq");
		this.hashFields.put("wgt_meas_ut_cd", "wgtMeasUtCd");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("rail_svc_tp_cd", "railSvcTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("agmt_rout_all_flg", "agmtRoutAllFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("to_wgt", "toWgt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trsp_agmt_ofc_cty_cd", "trspAgmtOfcCtyCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wtr_rcv_term_cd", "wtrRcvTermCd");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("wtr_de_term_cd", "wtrDeTermCd");
		this.hashFields.put("trsp_rvs_aply_flg", "trspRvsAplyFlg");
		this.hashFields.put("sub_row_no", "subRowNo");
		this.hashFields.put("agmt_scg_rt_div_cd", "agmtScgRtDivCd");
		this.hashFields.put("trsp_agmt_eq_tp_cd", "trspAgmtEqTpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("trsp_cost_mod_cd", "trspCostModCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("agmt_trsp_tp_cd", "agmtTrspTpCd");
		this.hashFields.put("trsp_dist_tp_cd", "trspDistTpCd");
		this.hashFields.put("trsp_agmt_bdl_qty", "trspAgmtBdlQty");
		this.hashFields.put("row_no", "rowNo");
		this.hashFields.put("cust_nomi_trkr_flg", "custNomiTrkrFlg");
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
	 * @return rtUpdStsCd
	 */
	public String getRtUpdStsCd() {
		return this.rtUpdStsCd;
	}
	
	/**
	 * Column Info
	 * @return woAplyFlg
	 */
	public String getWoAplyFlg() {
		return this.woAplyFlg;
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
	 * @return trspRndRt
	 */
	public String getTrspRndRt() {
		return this.trspRndRt;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtRtTpCd
	 */
	public String getTrspAgmtRtTpCd() {
		return this.trspAgmtRtTpCd;
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
	 * @return trspAgmtEqSzCd
	 */
	public String getTrspAgmtEqSzCd() {
		return this.trspAgmtEqSzCd;
	}
	
	/**
	 * Column Info
	 * @return agmtRmk
	 */
	public String getAgmtRmk() {
		return this.agmtRmk;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return trspScgCd
	 */
	public String getTrspScgCd() {
		return this.trspScgCd;
	}
	
	/**
	 * Column Info
	 * @return trspTmpSeq
	 */
	public String getTrspTmpSeq() {
		return this.trspTmpSeq;
	}
	
	/**
	 * Column Info
	 * @return trspOneWyRt
	 */
	public String getTrspOneWyRt() {
		return this.trspOneWyRt;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtDist
	 */
	public String getTrspAgmtDist() {
		return this.trspAgmtDist;
	}
	
	/**
	 * Column Info
	 * @return comScgAplyFlg
	 */
	public String getComScgAplyFlg() {
		return this.comScgAplyFlg;
	}
	
	/**
	 * Column Info
	 * @return cmdtGrpCd
	 */
	public String getCmdtGrpCd() {
		return this.cmdtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return distMeasUtCd
	 */
	public String getDistMeasUtCd() {
		return this.distMeasUtCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtSeq
	 */
	public String getTrspAgmtSeq() {
		return this.trspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return wgtMeasUtCd
	 */
	public String getWgtMeasUtCd() {
		return this.wgtMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
	}
	
	/**
	 * Column Info
	 * @return railSvcTpCd
	 */
	public String getRailSvcTpCd() {
		return this.railSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return agmtRoutAllFlg
	 */
	public String getAgmtRoutAllFlg() {
		return this.agmtRoutAllFlg;
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
	 * @return toWgt
	 */
	public String getToWgt() {
		return this.toWgt;
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
	 * @return trspAgmtOfcCtyCd
	 */
	public String getTrspAgmtOfcCtyCd() {
		return this.trspAgmtOfcCtyCd;
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
	 * @return wtrRcvTermCd
	 */
	public String getWtrRcvTermCd() {
		return this.wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	
	/**
	 * Column Info
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
	}
	
	/**
	 * Column Info
	 * @return wtrDeTermCd
	 */
	public String getWtrDeTermCd() {
		return this.wtrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return trspRvsAplyFlg
	 */
	public String getTrspRvsAplyFlg() {
		return this.trspRvsAplyFlg;
	}
	
	/**
	 * Column Info
	 * @return subRowNo
	 */
	public String getSubRowNo() {
		return this.subRowNo;
	}
	
	/**
	 * Column Info
	 * @return agmtScgRtDivCd
	 */
	public String getAgmtScgRtDivCd() {
		return this.agmtScgRtDivCd;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtEqTpCd
	 */
	public String getTrspAgmtEqTpCd() {
		return this.trspAgmtEqTpCd;
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
	 * @return trspCostModCd
	 */
	public String getTrspCostModCd() {
		return this.trspCostModCd;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
	}
	
	/**
	 * Column Info
	 * @return agmtTrspTpCd
	 */
	public String getAgmtTrspTpCd() {
		return this.agmtTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @return trspDistTpCd
	 */
	public String getTrspDistTpCd() {
		return this.trspDistTpCd;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtBdlQty
	 */
	public String getTrspAgmtBdlQty() {
		return this.trspAgmtBdlQty;
	}
	
	/**
	 * Column Info
	 * @return rowNo
	 */
	public String getRowNo() {
		return this.rowNo;
	}
	
	/**
	 * Column Info
	 * @return custNomiTrkrFlg
	 */
	public String getCustNomiTrkrFlg() {
		return this.custNomiTrkrFlg;
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
	 * @param rtUpdStsCd
	 */
	public void setRtUpdStsCd(String rtUpdStsCd) {
		this.rtUpdStsCd = rtUpdStsCd;
	}
	
	/**
	 * Column Info
	 * @param woAplyFlg
	 */
	public void setWoAplyFlg(String woAplyFlg) {
		this.woAplyFlg = woAplyFlg;
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
	 * @param trspRndRt
	 */
	public void setTrspRndRt(String trspRndRt) {
		this.trspRndRt = trspRndRt;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtRtTpCd
	 */
	public void setTrspAgmtRtTpCd(String trspAgmtRtTpCd) {
		this.trspAgmtRtTpCd = trspAgmtRtTpCd;
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
	 * @param trspAgmtEqSzCd
	 */
	public void setTrspAgmtEqSzCd(String trspAgmtEqSzCd) {
		this.trspAgmtEqSzCd = trspAgmtEqSzCd;
	}
	
	/**
	 * Column Info
	 * @param agmtRmk
	 */
	public void setAgmtRmk(String agmtRmk) {
		this.agmtRmk = agmtRmk;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param trspScgCd
	 */
	public void setTrspScgCd(String trspScgCd) {
		this.trspScgCd = trspScgCd;
	}
	
	/**
	 * Column Info
	 * @param trspTmpSeq
	 */
	public void setTrspTmpSeq(String trspTmpSeq) {
		this.trspTmpSeq = trspTmpSeq;
	}
	
	/**
	 * Column Info
	 * @param trspOneWyRt
	 */
	public void setTrspOneWyRt(String trspOneWyRt) {
		this.trspOneWyRt = trspOneWyRt;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtDist
	 */
	public void setTrspAgmtDist(String trspAgmtDist) {
		this.trspAgmtDist = trspAgmtDist;
	}
	
	/**
	 * Column Info
	 * @param comScgAplyFlg
	 */
	public void setComScgAplyFlg(String comScgAplyFlg) {
		this.comScgAplyFlg = comScgAplyFlg;
	}
	
	/**
	 * Column Info
	 * @param cmdtGrpCd
	 */
	public void setCmdtGrpCd(String cmdtGrpCd) {
		this.cmdtGrpCd = cmdtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param distMeasUtCd
	 */
	public void setDistMeasUtCd(String distMeasUtCd) {
		this.distMeasUtCd = distMeasUtCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtSeq
	 */
	public void setTrspAgmtSeq(String trspAgmtSeq) {
		this.trspAgmtSeq = trspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param wgtMeasUtCd
	 */
	public void setWgtMeasUtCd(String wgtMeasUtCd) {
		this.wgtMeasUtCd = wgtMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
	}
	
	/**
	 * Column Info
	 * @param railSvcTpCd
	 */
	public void setRailSvcTpCd(String railSvcTpCd) {
		this.railSvcTpCd = railSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param agmtRoutAllFlg
	 */
	public void setAgmtRoutAllFlg(String agmtRoutAllFlg) {
		this.agmtRoutAllFlg = agmtRoutAllFlg;
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
	 * @param toWgt
	 */
	public void setToWgt(String toWgt) {
		this.toWgt = toWgt;
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
	 * @param trspAgmtOfcCtyCd
	 */
	public void setTrspAgmtOfcCtyCd(String trspAgmtOfcCtyCd) {
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
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
	 * @param wtrRcvTermCd
	 */
	public void setWtrRcvTermCd(String wtrRcvTermCd) {
		this.wtrRcvTermCd = wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * Column Info
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
	}
	
	/**
	 * Column Info
	 * @param wtrDeTermCd
	 */
	public void setWtrDeTermCd(String wtrDeTermCd) {
		this.wtrDeTermCd = wtrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param trspRvsAplyFlg
	 */
	public void setTrspRvsAplyFlg(String trspRvsAplyFlg) {
		this.trspRvsAplyFlg = trspRvsAplyFlg;
	}
	
	/**
	 * Column Info
	 * @param subRowNo
	 */
	public void setSubRowNo(String subRowNo) {
		this.subRowNo = subRowNo;
	}
	
	/**
	 * Column Info
	 * @param agmtScgRtDivCd
	 */
	public void setAgmtScgRtDivCd(String agmtScgRtDivCd) {
		this.agmtScgRtDivCd = agmtScgRtDivCd;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtEqTpCd
	 */
	public void setTrspAgmtEqTpCd(String trspAgmtEqTpCd) {
		this.trspAgmtEqTpCd = trspAgmtEqTpCd;
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
	 * @param trspCostModCd
	 */
	public void setTrspCostModCd(String trspCostModCd) {
		this.trspCostModCd = trspCostModCd;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * Column Info
	 * @param agmtTrspTpCd
	 */
	public void setAgmtTrspTpCd(String agmtTrspTpCd) {
		this.agmtTrspTpCd = agmtTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @param trspDistTpCd
	 */
	public void setTrspDistTpCd(String trspDistTpCd) {
		this.trspDistTpCd = trspDistTpCd;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtBdlQty
	 */
	public void setTrspAgmtBdlQty(String trspAgmtBdlQty) {
		this.trspAgmtBdlQty = trspAgmtBdlQty;
	}
	
	/**
	 * Column Info
	 * @param rowNo
	 */
	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}
	
	/**
	 * Column Info
	 * @param custNomiTrkrFlg
	 */
	public void setCustNomiTrkrFlg(String custNomiTrkrFlg) {
		this.custNomiTrkrFlg = custNomiTrkrFlg;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setRtUpdStsCd(JSPUtil.getParameter(request, prefix + "rt_upd_sts_cd", ""));
		setWoAplyFlg(JSPUtil.getParameter(request, prefix + "wo_aply_flg", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setTrspRndRt(JSPUtil.getParameter(request, prefix + "trsp_rnd_rt", ""));
		setTrspAgmtRtTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrspAgmtEqSzCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_eq_sz_cd", ""));
		setAgmtRmk(JSPUtil.getParameter(request, prefix + "agmt_rmk", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setTrspScgCd(JSPUtil.getParameter(request, prefix + "trsp_scg_cd", ""));
		setTrspTmpSeq(JSPUtil.getParameter(request, prefix + "trsp_tmp_seq", ""));
		setTrspOneWyRt(JSPUtil.getParameter(request, prefix + "trsp_one_wy_rt", ""));
		setTrspAgmtDist(JSPUtil.getParameter(request, prefix + "trsp_agmt_dist", ""));
		setComScgAplyFlg(JSPUtil.getParameter(request, prefix + "com_scg_aply_flg", ""));
		setCmdtGrpCd(JSPUtil.getParameter(request, prefix + "cmdt_grp_cd", ""));
		setDistMeasUtCd(JSPUtil.getParameter(request, prefix + "dist_meas_ut_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_seq", ""));
		setWgtMeasUtCd(JSPUtil.getParameter(request, prefix + "wgt_meas_ut_cd", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setRailSvcTpCd(JSPUtil.getParameter(request, prefix + "rail_svc_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setAgmtRoutAllFlg(JSPUtil.getParameter(request, prefix + "agmt_rout_all_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setToWgt(JSPUtil.getParameter(request, prefix + "to_wgt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_ofc_cty_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWtrRcvTermCd(JSPUtil.getParameter(request, prefix + "wtr_rcv_term_cd", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setWtrDeTermCd(JSPUtil.getParameter(request, prefix + "wtr_de_term_cd", ""));
		setTrspRvsAplyFlg(JSPUtil.getParameter(request, prefix + "trsp_rvs_aply_flg", ""));
		setSubRowNo(JSPUtil.getParameter(request, prefix + "sub_row_no", ""));
		setAgmtScgRtDivCd(JSPUtil.getParameter(request, prefix + "agmt_scg_rt_div_cd", ""));
		setTrspAgmtEqTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_eq_tp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTrspCostModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_mod_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setAgmtTrspTpCd(JSPUtil.getParameter(request, prefix + "agmt_trsp_tp_cd", ""));
		setTrspDistTpCd(JSPUtil.getParameter(request, prefix + "trsp_dist_tp_cd", ""));
		setTrspAgmtBdlQty(JSPUtil.getParameter(request, prefix + "trsp_agmt_bdl_qty", ""));
		setRowNo(JSPUtil.getParameter(request, prefix + "row_no", ""));
		setCustNomiTrkrFlg(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTrsAgmtTmpVO[]
	 */
	public SearchTrsAgmtTmpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTrsAgmtTmpVO[]
	 */
	public SearchTrsAgmtTmpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTrsAgmtTmpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] rtUpdStsCd = (JSPUtil.getParameter(request, prefix	+ "rt_upd_sts_cd", length));
			String[] woAplyFlg = (JSPUtil.getParameter(request, prefix	+ "wo_aply_flg", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] trspRndRt = (JSPUtil.getParameter(request, prefix	+ "trsp_rnd_rt", length));
			String[] trspAgmtRtTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_rt_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trspAgmtEqSzCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_eq_sz_cd", length));
			String[] agmtRmk = (JSPUtil.getParameter(request, prefix	+ "agmt_rmk", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] trspScgCd = (JSPUtil.getParameter(request, prefix	+ "trsp_scg_cd", length));
			String[] trspTmpSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_tmp_seq", length));
			String[] trspOneWyRt = (JSPUtil.getParameter(request, prefix	+ "trsp_one_wy_rt", length));
			String[] trspAgmtDist = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_dist", length));
			String[] comScgAplyFlg = (JSPUtil.getParameter(request, prefix	+ "com_scg_aply_flg", length));
			String[] cmdtGrpCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_grp_cd", length));
			String[] distMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "dist_meas_ut_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] trspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_seq", length));
			String[] wgtMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_meas_ut_cd", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] railSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_svc_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] agmtRoutAllFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_rout_all_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] toWgt = (JSPUtil.getParameter(request, prefix	+ "to_wgt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_ofc_cty_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wtrRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_rcv_term_cd", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] wtrDeTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_de_term_cd", length));
			String[] trspRvsAplyFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_rvs_aply_flg", length));
			String[] subRowNo = (JSPUtil.getParameter(request, prefix	+ "sub_row_no", length));
			String[] agmtScgRtDivCd = (JSPUtil.getParameter(request, prefix	+ "agmt_scg_rt_div_cd", length));
			String[] trspAgmtEqTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_eq_tp_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] trspCostModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_mod_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] agmtTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "agmt_trsp_tp_cd", length));
			String[] trspDistTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_dist_tp_cd", length));
			String[] trspAgmtBdlQty = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_bdl_qty", length));
			String[] rowNo = (JSPUtil.getParameter(request, prefix	+ "row_no", length));
			String[] custNomiTrkrFlg = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTrsAgmtTmpVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (rtUpdStsCd[i] != null)
					model.setRtUpdStsCd(rtUpdStsCd[i]);
				if (woAplyFlg[i] != null)
					model.setWoAplyFlg(woAplyFlg[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (trspRndRt[i] != null)
					model.setTrspRndRt(trspRndRt[i]);
				if (trspAgmtRtTpCd[i] != null)
					model.setTrspAgmtRtTpCd(trspAgmtRtTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trspAgmtEqSzCd[i] != null)
					model.setTrspAgmtEqSzCd(trspAgmtEqSzCd[i]);
				if (agmtRmk[i] != null)
					model.setAgmtRmk(agmtRmk[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (trspScgCd[i] != null)
					model.setTrspScgCd(trspScgCd[i]);
				if (trspTmpSeq[i] != null)
					model.setTrspTmpSeq(trspTmpSeq[i]);
				if (trspOneWyRt[i] != null)
					model.setTrspOneWyRt(trspOneWyRt[i]);
				if (trspAgmtDist[i] != null)
					model.setTrspAgmtDist(trspAgmtDist[i]);
				if (comScgAplyFlg[i] != null)
					model.setComScgAplyFlg(comScgAplyFlg[i]);
				if (cmdtGrpCd[i] != null)
					model.setCmdtGrpCd(cmdtGrpCd[i]);
				if (distMeasUtCd[i] != null)
					model.setDistMeasUtCd(distMeasUtCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (trspAgmtSeq[i] != null)
					model.setTrspAgmtSeq(trspAgmtSeq[i]);
				if (wgtMeasUtCd[i] != null)
					model.setWgtMeasUtCd(wgtMeasUtCd[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (railSvcTpCd[i] != null)
					model.setRailSvcTpCd(railSvcTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (agmtRoutAllFlg[i] != null)
					model.setAgmtRoutAllFlg(agmtRoutAllFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (toWgt[i] != null)
					model.setToWgt(toWgt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trspAgmtOfcCtyCd[i] != null)
					model.setTrspAgmtOfcCtyCd(trspAgmtOfcCtyCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wtrRcvTermCd[i] != null)
					model.setWtrRcvTermCd(wtrRcvTermCd[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (wtrDeTermCd[i] != null)
					model.setWtrDeTermCd(wtrDeTermCd[i]);
				if (trspRvsAplyFlg[i] != null)
					model.setTrspRvsAplyFlg(trspRvsAplyFlg[i]);
				if (subRowNo[i] != null)
					model.setSubRowNo(subRowNo[i]);
				if (agmtScgRtDivCd[i] != null)
					model.setAgmtScgRtDivCd(agmtScgRtDivCd[i]);
				if (trspAgmtEqTpCd[i] != null)
					model.setTrspAgmtEqTpCd(trspAgmtEqTpCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (trspCostModCd[i] != null)
					model.setTrspCostModCd(trspCostModCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (agmtTrspTpCd[i] != null)
					model.setAgmtTrspTpCd(agmtTrspTpCd[i]);
				if (trspDistTpCd[i] != null)
					model.setTrspDistTpCd(trspDistTpCd[i]);
				if (trspAgmtBdlQty[i] != null)
					model.setTrspAgmtBdlQty(trspAgmtBdlQty[i]);
				if (rowNo[i] != null)
					model.setRowNo(rowNo[i]);
				if (custNomiTrkrFlg[i] != null)
					model.setCustNomiTrkrFlg(custNomiTrkrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTrsAgmtTmpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTrsAgmtTmpVO[]
	 */
	public SearchTrsAgmtTmpVO[] getSearchTrsAgmtTmpVOs(){
		SearchTrsAgmtTmpVO[] vos = (SearchTrsAgmtTmpVO[])models.toArray(new SearchTrsAgmtTmpVO[models.size()]);
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
		this.rtUpdStsCd = this.rtUpdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woAplyFlg = this.woAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRndRt = this.trspRndRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRtTpCd = this.trspAgmtRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtEqSzCd = this.trspAgmtEqSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRmk = this.agmtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspScgCd = this.trspScgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspTmpSeq = this.trspTmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspOneWyRt = this.trspOneWyRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtDist = this.trspAgmtDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comScgAplyFlg = this.comScgAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtGrpCd = this.cmdtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distMeasUtCd = this.distMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtSeq = this.trspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtMeasUtCd = this.wgtMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railSvcTpCd = this.railSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRoutAllFlg = this.agmtRoutAllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWgt = this.toWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtOfcCtyCd = this.trspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrRcvTermCd = this.wtrRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrDeTermCd = this.wtrDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRvsAplyFlg = this.trspRvsAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subRowNo = this.subRowNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtScgRtDivCd = this.agmtScgRtDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtEqTpCd = this.trspAgmtEqTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostModCd = this.trspCostModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtTrspTpCd = this.agmtTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDistTpCd = this.trspDistTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtBdlQty = this.trspAgmtBdlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNo = this.rowNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrFlg = this.custNomiTrkrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
