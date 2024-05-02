/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DummyAgmtRateVO.java
*@FileTitle : DummyAgmtRateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.07
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2016.01.07 SHIN DONG IL 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo;

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
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DummyAgmtRateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DummyAgmtRateVO> models = new ArrayList<DummyAgmtRateVO>();
	
	/* Column Info */
	private String toNodYd = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String trspRndRt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqAal = null;
	/* Column Info */
	private String ckVf = null;
	/* Column Info */
	private String eqAl2 = null;
	/* Column Info */
	private String eqF2 = null;
	/* Column Info */
	private String eqF4 = null;
	/* Column Info */
	private String eqF5 = null;
	/* Column Info */
	private String eqAl5 = null;
	/* Column Info */
	private String eqAl4 = null;
	/* Column Info */
	private String eqDw = null;
	/* Column Info */
	private String trspScgCd = null;
	/* Column Info */
	private String eqAl7 = null;
	/* Column Info */
	private String eqO4 = null;
	/* Column Info */
	private String eqAl8 = null;
	/* Column Info */
	private String eqO5 = null;
	/* Column Info */
	private String eqO7 = null;	
	/* Column Info */
	private String eqAl9 = null;
	/* Column Info */
	private String eqT2 = null;
	/* Column Info */
	private String eqDx = null;
	/* Column Info */
	private String eqT4 = null;
	/* Column Info */
	private String trspOneWyRt = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String cmdtGrpCd = null;
	/* Column Info */
	private String eqPal = null;
	/* Column Info */
	private String eqTal = null;
	/* Column Info */
	private String eqGn4 = null;
	/* Column Info */
	private String eqGn5 = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String eqRal = null;
	/* Column Info */
	private String eqSal = null;
	/* Column Info */
	private String agmtAproDt = null;
	/* Column Info */
	private String eqO2 = null;
	/* Column Info */
	private String railSvcTpCd = null;
	/* Column Info */
	private String orgTrspAgmtEqSzCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String toWgt = null;
	/* Column Info */
	private String eqAlal = null;
	/* Column Info */
	private String eqD4 = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String eqSf4 = null;
	/* Column Info */
	private String eqD5 = null;
	/* Column Info */
	private String wtrDeTermCd = null;
	/* Column Info */
	private String eqD7 = null;
	/* Column Info */
	private String eqD2 = null;
	/* Column Info */
	private String eqSf2 = null;
	/* Column Info */
	private String eqD3 = null;
	/* Column Info */
	private String agmtScgRtDivCd = null;
	/* Column Info */
	private String trspAgmtEqTpCd = null;
	/* Column Info */
	private String eqTa2 = null;
	/* Column Info */
	private String eqD9 = null;
	/* Column Info */
	private String eqD8 = null;
	/* Column Info */
	private String chkRowno = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String eqUg = null;
	/* Column Info */
	private String eqCg = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String agmtTrspTpCd = null;
	/* Column Info */
	private String trspAgmtBdlQty = null;
	/* Column Info */
	private String viaNodYd = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String rlt = null;
	/* Column Info */
	private String orgTrspAgmtEqTpCd = null;
	/* Column Info */
	private String rowno = null;
	/* Column Info */
	private String eqR9 = null;
	/* Column Info */
	private String eqR8 = null;
	/* Column Info */
	private String eqR7 = null;
	/* Column Info */
	private String eqSfal = null;
	/* Column Info */
	private String trspAgmtRtTpCd = null;
	/* Column Info */
	private String trspAgmtEqSzCd = null;
	/* Column Info */
	private String eqCb4 = null;
	/* Column Info */
	private String eqR4 = null;
	/* Column Info */
	private String eqR5 = null;
	/* Column Info */
	private String eqR2 = null;
	/* Column Info */
	private String orgEqtype = null;
	/* Column Info */
	private String eqGnal = null;
	/* Column Info */
	private String trspAgmtDist = null;
	/* Column Info */
	private String eqOal = null;
	/* Column Info */
	private String distMeasUtCd = null;
	/* Column Info */
	private String eqZt4 = null;
	/* Column Info */
	private String eqS2 = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String eqS4 = null;
	/* Column Info */
	private String eqSlal = null;
	/* Column Info */
	private String trspAgmtSeq = null;
	/* Column Info */
	private String wgtMeasUtCd = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String eqA5 = null;
	/* Column Info */
	private String eqEg5 = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String eqA2 = null;
	/* Column Info */
	private String agmtRoutAllFlg = null;
	/* Column Info */
	private String eqA4 = null;
	/* Column Info */
	private String trspAgmtOfcCtyCd = null;
	/* Column Info */
	private String eqEg8 = null;
	/* Column Info */
	private String eqTaal = null;
	/* Column Info */
	private String custNomiTrkrIndCd = null;
	/* Column Info */
	private String eqP4 = null;
	/* Column Info */
	private String eqP2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wtrRcvTermCd = null;
	/* Column Info */
	private String trspRvsAplyFlg = null;
	/* Column Info */
	private String eqFal = null;
	/* Column Info */
	private String trspCostModCd = null;
	/* Column Info */
	private String fmNodYd = null;
	/* Column Info */
	private String eqEgal = null;
	/* Column Info */
	private String eqSl2 = null;
	/* Column Info */
	private String dorNodYd = null;
	/* Column Info */
	private String uiSeqno = null;
	/* Column Info */
	private String eqDal = null;
	/* Column Info */
	private String trspDistTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DummyAgmtRateVO() {}

	public DummyAgmtRateVO(String ibflag, String pagerows, String eqA5, String toNodYd, String cgoTpCd, String trspRndRt, String eqAal, String ckVf, String eqF2, String eqAl2, String eqF4, String eqF5, String eqAl5, String eqAl4, String eqDw, String trspScgCd, String eqAl7, String eqO4, String eqAl8, String eqO5, String eqO7, String eqAl9, String eqT2, String eqDx, String eqT4, String trspOneWyRt, String agmtNo, String cmdtGrpCd, String eqTal, String eqPal, String eqGn4, String eqGn5, String custCd, String eqRal, String eqSal, String agmtAproDt, String eqO2, String railSvcTpCd, String orgTrspAgmtEqSzCd, String deltFlg, String toWgt, String eqAlal, String dorNodCd, String eqD4, String eqD5, String eqSf4, String effFmDt, String wtrDeTermCd, String eqD7, String eqD2, String eqSf2, String eqD3, String agmtScgRtDivCd, String trspAgmtEqTpCd, String eqTa2, String eqD9, String eqD8, String chkRowno, String eqKndCd, String fmNodCd, String eqUg, String eqCg, String viaNodCd, String agmtTrspTpCd, String trspAgmtBdlQty, String viaNodYd, String toNodCd, String rlt, String orgTrspAgmtEqTpCd, String rowno, String eqR9, String eqR8, String eqR7, String eqSfal, String trspAgmtRtTpCd, String trspAgmtEqSzCd, String eqCb4, String eqR4, String eqR5, String eqR2, String orgEqtype, String eqGnal, String trspAgmtDist, String eqOal, String distMeasUtCd, String eqZt4, String eqS2, String chk, String eqS4, String eqSlal, String trspAgmtSeq, String wgtMeasUtCd, String effToDt, String eqEg5, String currCd, String eqA2, String agmtRoutAllFlg, String eqA4, String trspAgmtOfcCtyCd, String eqTaal, String eqEg8, String eqP4, String custNomiTrkrIndCd, String eqP2, String wtrRcvTermCd, String trspRvsAplyFlg, String eqFal, String trspCostModCd, String fmNodYd, String eqEgal, String eqSl2, String uiSeqno, String dorNodYd, String eqDal, String trspDistTpCd) {
		this.toNodYd = toNodYd;
		this.cgoTpCd = cgoTpCd;
		this.trspRndRt = trspRndRt;
		this.pagerows = pagerows;
		this.eqAal = eqAal;
		this.ckVf = ckVf;
		this.eqAl2 = eqAl2;
		this.eqF2 = eqF2;
		this.eqF4 = eqF4;
		this.eqF5 = eqF5;
		this.eqAl5 = eqAl5;
		this.eqAl4 = eqAl4;
		this.eqDw = eqDw;
		this.trspScgCd = trspScgCd;
		this.eqAl7 = eqAl7;
		this.eqO4 = eqO4;
		this.eqAl8 = eqAl8;
		this.eqO5 = eqO5;
		this.eqO7 = eqO7;
		this.eqAl9 = eqAl9;
		this.eqT2 = eqT2;
		this.eqDx = eqDx;
		this.eqT4 = eqT4;
		this.trspOneWyRt = trspOneWyRt;
		this.agmtNo = agmtNo;
		this.cmdtGrpCd = cmdtGrpCd;
		this.eqPal = eqPal;
		this.eqTal = eqTal;
		this.eqGn4 = eqGn4;
		this.eqGn5 = eqGn5;
		this.custCd = custCd;
		this.eqRal = eqRal;
		this.eqSal = eqSal;
		this.agmtAproDt = agmtAproDt;
		this.eqO2 = eqO2;
		this.railSvcTpCd = railSvcTpCd;
		this.orgTrspAgmtEqSzCd = orgTrspAgmtEqSzCd;
		this.deltFlg = deltFlg;
		this.toWgt = toWgt;
		this.eqAlal = eqAlal;
		this.eqD4 = eqD4;
		this.dorNodCd = dorNodCd;
		this.effFmDt = effFmDt;
		this.eqSf4 = eqSf4;
		this.eqD5 = eqD5;
		this.wtrDeTermCd = wtrDeTermCd;
		this.eqD7 = eqD7;
		this.eqD2 = eqD2;
		this.eqSf2 = eqSf2;
		this.eqD3 = eqD3;
		this.agmtScgRtDivCd = agmtScgRtDivCd;
		this.trspAgmtEqTpCd = trspAgmtEqTpCd;
		this.eqTa2 = eqTa2;
		this.eqD9 = eqD9;
		this.eqD8 = eqD8;
		this.chkRowno = chkRowno;
		this.eqKndCd = eqKndCd;
		this.fmNodCd = fmNodCd;
		this.eqUg = eqUg;
		this.eqCg = eqCg;
		this.viaNodCd = viaNodCd;
		this.agmtTrspTpCd = agmtTrspTpCd;
		this.trspAgmtBdlQty = trspAgmtBdlQty;
		this.viaNodYd = viaNodYd;
		this.toNodCd = toNodCd;
		this.rlt = rlt;
		this.orgTrspAgmtEqTpCd = orgTrspAgmtEqTpCd;
		this.rowno = rowno;
		this.eqR9 = eqR9;
		this.eqR8 = eqR8;
		this.eqR7 = eqR7;
		this.eqSfal = eqSfal;
		this.trspAgmtRtTpCd = trspAgmtRtTpCd;
		this.trspAgmtEqSzCd = trspAgmtEqSzCd;
		this.eqCb4 = eqCb4;
		this.eqR4 = eqR4;
		this.eqR5 = eqR5;
		this.eqR2 = eqR2;
		this.orgEqtype = orgEqtype;
		this.eqGnal = eqGnal;
		this.trspAgmtDist = trspAgmtDist;
		this.eqOal = eqOal;
		this.distMeasUtCd = distMeasUtCd;
		this.eqZt4 = eqZt4;
		this.eqS2 = eqS2;
		this.chk = chk;
		this.eqS4 = eqS4;
		this.eqSlal = eqSlal;
		this.trspAgmtSeq = trspAgmtSeq;
		this.wgtMeasUtCd = wgtMeasUtCd;
		this.effToDt = effToDt;
		this.eqA5 = eqA5;
		this.eqEg5 = eqEg5;
		this.currCd = currCd;
		this.eqA2 = eqA2;
		this.agmtRoutAllFlg = agmtRoutAllFlg;
		this.eqA4 = eqA4;
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
		this.eqEg8 = eqEg8;
		this.eqTaal = eqTaal;
		this.custNomiTrkrIndCd = custNomiTrkrIndCd;
		this.eqP4 = eqP4;
		this.eqP2 = eqP2;
		this.ibflag = ibflag;
		this.wtrRcvTermCd = wtrRcvTermCd;
		this.trspRvsAplyFlg = trspRvsAplyFlg;
		this.eqFal = eqFal;
		this.trspCostModCd = trspCostModCd;
		this.fmNodYd = fmNodYd;
		this.eqEgal = eqEgal;
		this.eqSl2 = eqSl2;
		this.dorNodYd = dorNodYd;
		this.uiSeqno = uiSeqno;
		this.eqDal = eqDal;
		this.trspDistTpCd = trspDistTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_yd", getToNodYd());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("trsp_rnd_rt", getTrspRndRt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_aal", getEqAal());
		this.hashColumns.put("ck_vf", getCkVf());
		this.hashColumns.put("eq_al2", getEqAl2());
		this.hashColumns.put("eq_f2", getEqF2());
		this.hashColumns.put("eq_f4", getEqF4());
		this.hashColumns.put("eq_f5", getEqF5());
		this.hashColumns.put("eq_al5", getEqAl5());
		this.hashColumns.put("eq_al4", getEqAl4());
		this.hashColumns.put("eq_dw", getEqDw());
		this.hashColumns.put("trsp_scg_cd", getTrspScgCd());
		this.hashColumns.put("eq_al7", getEqAl7());
		this.hashColumns.put("eq_o4", getEqO4());
		this.hashColumns.put("eq_al8", getEqAl8());
		this.hashColumns.put("eq_o5", getEqO5());
		this.hashColumns.put("eq_o7", getEqO7());
		this.hashColumns.put("eq_al9", getEqAl9());
		this.hashColumns.put("eq_t2", getEqT2());
		this.hashColumns.put("eq_dx", getEqDx());
		this.hashColumns.put("eq_t4", getEqT4());
		this.hashColumns.put("trsp_one_wy_rt", getTrspOneWyRt());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("cmdt_grp_cd", getCmdtGrpCd());
		this.hashColumns.put("eq_pal", getEqPal());
		this.hashColumns.put("eq_tal", getEqTal());
		this.hashColumns.put("eq_gn4", getEqGn4());
		this.hashColumns.put("eq_gn5", getEqGn5());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("eq_ral", getEqRal());
		this.hashColumns.put("eq_sal", getEqSal());
		this.hashColumns.put("agmt_apro_dt", getAgmtAproDt());
		this.hashColumns.put("eq_o2", getEqO2());
		this.hashColumns.put("rail_svc_tp_cd", getRailSvcTpCd());
		this.hashColumns.put("org_trsp_agmt_eq_sz_cd", getOrgTrspAgmtEqSzCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("to_wgt", getToWgt());
		this.hashColumns.put("eq_alal", getEqAlal());
		this.hashColumns.put("eq_d4", getEqD4());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("eq_sf4", getEqSf4());
		this.hashColumns.put("eq_d5", getEqD5());
		this.hashColumns.put("wtr_de_term_cd", getWtrDeTermCd());
		this.hashColumns.put("eq_d7", getEqD7());
		this.hashColumns.put("eq_d2", getEqD2());
		this.hashColumns.put("eq_sf2", getEqSf2());
		this.hashColumns.put("eq_d3", getEqD3());
		this.hashColumns.put("agmt_scg_rt_div_cd", getAgmtScgRtDivCd());
		this.hashColumns.put("trsp_agmt_eq_tp_cd", getTrspAgmtEqTpCd());
		this.hashColumns.put("eq_ta2", getEqTa2());
		this.hashColumns.put("eq_d9", getEqD9());
		this.hashColumns.put("eq_d8", getEqD8());
		this.hashColumns.put("chk_rowno", getChkRowno());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("eq_ug", getEqUg());
		this.hashColumns.put("eq_cg", getEqCg());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("agmt_trsp_tp_cd", getAgmtTrspTpCd());
		this.hashColumns.put("trsp_agmt_bdl_qty", getTrspAgmtBdlQty());
		this.hashColumns.put("via_nod_yd", getViaNodYd());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("rlt", getRlt());
		this.hashColumns.put("org_trsp_agmt_eq_tp_cd", getOrgTrspAgmtEqTpCd());
		this.hashColumns.put("rowno", getRowno());
		this.hashColumns.put("eq_r9", getEqR9());
		this.hashColumns.put("eq_r8", getEqR8());
		this.hashColumns.put("eq_r7", getEqR7());
		this.hashColumns.put("eq_sfal", getEqSfal());
		this.hashColumns.put("trsp_agmt_rt_tp_cd", getTrspAgmtRtTpCd());
		this.hashColumns.put("trsp_agmt_eq_sz_cd", getTrspAgmtEqSzCd());
		this.hashColumns.put("eq_cb4", getEqCb4());
		this.hashColumns.put("eq_r4", getEqR4());
		this.hashColumns.put("eq_r5", getEqR5());
		this.hashColumns.put("eq_r2", getEqR2());
		this.hashColumns.put("org_eqtype", getOrgEqtype());
		this.hashColumns.put("eq_gnal", getEqGnal());
		this.hashColumns.put("trsp_agmt_dist", getTrspAgmtDist());
		this.hashColumns.put("eq_oal", getEqOal());
		this.hashColumns.put("dist_meas_ut_cd", getDistMeasUtCd());
		this.hashColumns.put("eq_zt4", getEqZt4());
		this.hashColumns.put("eq_s2", getEqS2());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("eq_s4", getEqS4());
		this.hashColumns.put("eq_slal", getEqSlal());
		this.hashColumns.put("trsp_agmt_seq", getTrspAgmtSeq());
		this.hashColumns.put("wgt_meas_ut_cd", getWgtMeasUtCd());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("eq_a5", getEqA5());
		this.hashColumns.put("eq_eg5", getEqEg5());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("eq_a2", getEqA2());
		this.hashColumns.put("agmt_rout_all_flg", getAgmtRoutAllFlg());
		this.hashColumns.put("eq_a4", getEqA4());
		this.hashColumns.put("trsp_agmt_ofc_cty_cd", getTrspAgmtOfcCtyCd());
		this.hashColumns.put("eq_eg8", getEqEg8());
		this.hashColumns.put("eq_taal", getEqTaal());
		this.hashColumns.put("cust_nomi_trkr_ind_cd", getCustNomiTrkrIndCd());
		this.hashColumns.put("eq_p4", getEqP4());
		this.hashColumns.put("eq_p2", getEqP2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wtr_rcv_term_cd", getWtrRcvTermCd());
		this.hashColumns.put("trsp_rvs_aply_flg", getTrspRvsAplyFlg());
		this.hashColumns.put("eq_fal", getEqFal());
		this.hashColumns.put("trsp_cost_mod_cd", getTrspCostModCd());
		this.hashColumns.put("fm_nod_yd", getFmNodYd());
		this.hashColumns.put("eq_egal", getEqEgal());
		this.hashColumns.put("eq_sl2", getEqSl2());
		this.hashColumns.put("dor_nod_yd", getDorNodYd());
		this.hashColumns.put("ui_seqno", getUiSeqno());
		this.hashColumns.put("eq_dal", getEqDal());
		this.hashColumns.put("trsp_dist_tp_cd", getTrspDistTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_yd", "toNodYd");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("trsp_rnd_rt", "trspRndRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_aal", "eqAal");
		this.hashFields.put("ck_vf", "ckVf");
		this.hashFields.put("eq_al2", "eqAl2");
		this.hashFields.put("eq_f2", "eqF2");
		this.hashFields.put("eq_f4", "eqF4");
		this.hashFields.put("eq_f5", "eqF5");
		this.hashFields.put("eq_al5", "eqAl5");
		this.hashFields.put("eq_al4", "eqAl4");
		this.hashFields.put("eq_dw", "eqDw");
		this.hashFields.put("trsp_scg_cd", "trspScgCd");
		this.hashFields.put("eq_al7", "eqAl7");
		this.hashFields.put("eq_o4", "eqO4");
		this.hashFields.put("eq_al8", "eqAl8");
		this.hashFields.put("eq_o5", "eqO5");
		this.hashFields.put("eq_o7", "eqO7");
		this.hashFields.put("eq_al9", "eqAl9");
		this.hashFields.put("eq_t2", "eqT2");
		this.hashFields.put("eq_dx", "eqDx");
		this.hashFields.put("eq_t4", "eqT4");
		this.hashFields.put("trsp_one_wy_rt", "trspOneWyRt");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("cmdt_grp_cd", "cmdtGrpCd");
		this.hashFields.put("eq_pal", "eqPal");
		this.hashFields.put("eq_tal", "eqTal");
		this.hashFields.put("eq_gn4", "eqGn4");
		this.hashFields.put("eq_gn5", "eqGn5");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("eq_ral", "eqRal");
		this.hashFields.put("eq_sal", "eqSal");
		this.hashFields.put("agmt_apro_dt", "agmtAproDt");
		this.hashFields.put("eq_o2", "eqO2");
		this.hashFields.put("rail_svc_tp_cd", "railSvcTpCd");
		this.hashFields.put("org_trsp_agmt_eq_sz_cd", "orgTrspAgmtEqSzCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("to_wgt", "toWgt");
		this.hashFields.put("eq_alal", "eqAlal");
		this.hashFields.put("eq_d4", "eqD4");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("eq_sf4", "eqSf4");
		this.hashFields.put("eq_d5", "eqD5");
		this.hashFields.put("wtr_de_term_cd", "wtrDeTermCd");
		this.hashFields.put("eq_d7", "eqD7");
		this.hashFields.put("eq_d2", "eqD2");
		this.hashFields.put("eq_sf2", "eqSf2");
		this.hashFields.put("eq_d3", "eqD3");
		this.hashFields.put("agmt_scg_rt_div_cd", "agmtScgRtDivCd");
		this.hashFields.put("trsp_agmt_eq_tp_cd", "trspAgmtEqTpCd");
		this.hashFields.put("eq_ta2", "eqTa2");
		this.hashFields.put("eq_d9", "eqD9");
		this.hashFields.put("eq_d8", "eqD8");
		this.hashFields.put("chk_rowno", "chkRowno");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("eq_ug", "eqUg");
		this.hashFields.put("eq_cg", "eqCg");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("agmt_trsp_tp_cd", "agmtTrspTpCd");
		this.hashFields.put("trsp_agmt_bdl_qty", "trspAgmtBdlQty");
		this.hashFields.put("via_nod_yd", "viaNodYd");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("rlt", "rlt");
		this.hashFields.put("org_trsp_agmt_eq_tp_cd", "orgTrspAgmtEqTpCd");
		this.hashFields.put("rowno", "rowno");
		this.hashFields.put("eq_r9", "eqR9");
		this.hashFields.put("eq_r8", "eqR8");
		this.hashFields.put("eq_r7", "eqR7");
		this.hashFields.put("eq_sfal", "eqSfal");
		this.hashFields.put("trsp_agmt_rt_tp_cd", "trspAgmtRtTpCd");
		this.hashFields.put("trsp_agmt_eq_sz_cd", "trspAgmtEqSzCd");
		this.hashFields.put("eq_cb4", "eqCb4");
		this.hashFields.put("eq_r4", "eqR4");
		this.hashFields.put("eq_r5", "eqR5");
		this.hashFields.put("eq_r2", "eqR2");
		this.hashFields.put("org_eqtype", "orgEqtype");
		this.hashFields.put("eq_gnal", "eqGnal");
		this.hashFields.put("trsp_agmt_dist", "trspAgmtDist");
		this.hashFields.put("eq_oal", "eqOal");
		this.hashFields.put("dist_meas_ut_cd", "distMeasUtCd");
		this.hashFields.put("eq_zt4", "eqZt4");
		this.hashFields.put("eq_s2", "eqS2");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("eq_s4", "eqS4");
		this.hashFields.put("eq_slal", "eqSlal");
		this.hashFields.put("trsp_agmt_seq", "trspAgmtSeq");
		this.hashFields.put("wgt_meas_ut_cd", "wgtMeasUtCd");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("eq_a5", "eqA5");
		this.hashFields.put("eq_eg5", "eqEg5");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("eq_a2", "eqA2");
		this.hashFields.put("agmt_rout_all_flg", "agmtRoutAllFlg");
		this.hashFields.put("eq_a4", "eqA4");
		this.hashFields.put("trsp_agmt_ofc_cty_cd", "trspAgmtOfcCtyCd");
		this.hashFields.put("eq_eg8", "eqEg8");
		this.hashFields.put("eq_taal", "eqTaal");
		this.hashFields.put("cust_nomi_trkr_ind_cd", "custNomiTrkrIndCd");
		this.hashFields.put("eq_p4", "eqP4");
		this.hashFields.put("eq_p2", "eqP2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wtr_rcv_term_cd", "wtrRcvTermCd");
		this.hashFields.put("trsp_rvs_aply_flg", "trspRvsAplyFlg");
		this.hashFields.put("eq_fal", "eqFal");
		this.hashFields.put("trsp_cost_mod_cd", "trspCostModCd");
		this.hashFields.put("fm_nod_yd", "fmNodYd");
		this.hashFields.put("eq_egal", "eqEgal");
		this.hashFields.put("eq_sl2", "eqSl2");
		this.hashFields.put("dor_nod_yd", "dorNodYd");
		this.hashFields.put("ui_seqno", "uiSeqno");
		this.hashFields.put("eq_dal", "eqDal");
		this.hashFields.put("trsp_dist_tp_cd", "trspDistTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodYd
	 */
	public String getToNodYd() {
		return this.toNodYd;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return eqAal
	 */
	public String getEqAal() {
		return this.eqAal;
	}
	
	/**
	 * Column Info
	 * @return ckVf
	 */
	public String getCkVf() {
		return this.ckVf;
	}
	
	/**
	 * Column Info
	 * @return eqAl2
	 */
	public String getEqAl2() {
		return this.eqAl2;
	}
	
	/**
	 * Column Info
	 * @return eqF2
	 */
	public String getEqF2() {
		return this.eqF2;
	}
	
	/**
	 * Column Info
	 * @return eqF4
	 */
	public String getEqF4() {
		return this.eqF4;
	}
	
	/**
	 * Column Info
	 * @return eqF5
	 */
	public String getEqF5() {
		return this.eqF5;
	}
	
	/**
	 * Column Info
	 * @return eqAl5
	 */
	public String getEqAl5() {
		return this.eqAl5;
	}
	
	/**
	 * Column Info
	 * @return eqAl4
	 */
	public String getEqAl4() {
		return this.eqAl4;
	}
	
	/**
	 * Column Info
	 * @return eqDw
	 */
	public String getEqDw() {
		return this.eqDw;
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
	 * @return eqAl7
	 */
	public String getEqAl7() {
		return this.eqAl7;
	}
	
	/**
	 * Column Info
	 * @return eqO4
	 */
	public String getEqO4() {
		return this.eqO4;
	}
	
	/**
	 * Column Info
	 * @return eqAl8
	 */
	public String getEqAl8() {
		return this.eqAl8;
	}
	
	/**
	 * Column Info
	 * @return eqO5
	 */
	public String getEqO5() {
		return this.eqO5;
	}
	
	/**
	 * Column Info
	 * @return eqO7
	 */
	public String getEqO7() {
		return this.eqO7;
	}
	
	/**
	 * Column Info
	 * @return eqAl9
	 */
	public String getEqAl9() {
		return this.eqAl9;
	}
	
	/**
	 * Column Info
	 * @return eqT2
	 */
	public String getEqT2() {
		return this.eqT2;
	}
	
	/**
	 * Column Info
	 * @return eqDx
	 */
	public String getEqDx() {
		return this.eqDx;
	}
	
	/**
	 * Column Info
	 * @return eqT4
	 */
	public String getEqT4() {
		return this.eqT4;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
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
	 * @return eqPal
	 */
	public String getEqPal() {
		return this.eqPal;
	}
	
	/**
	 * Column Info
	 * @return eqTal
	 */
	public String getEqTal() {
		return this.eqTal;
	}
	
	/**
	 * Column Info
	 * @return eqGn4
	 */
	public String getEqGn4() {
		return this.eqGn4;
	}
	
	/**
	 * Column Info
	 * @return eqGn5
	 */
	public String getEqGn5() {
		return this.eqGn5;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return eqRal
	 */
	public String getEqRal() {
		return this.eqRal;
	}
	
	/**
	 * Column Info
	 * @return eqSal
	 */
	public String getEqSal() {
		return this.eqSal;
	}
	
	/**
	 * Column Info
	 * @return agmtAproDt
	 */
	public String getAgmtAproDt() {
		return this.agmtAproDt;
	}
	
	/**
	 * Column Info
	 * @return eqO2
	 */
	public String getEqO2() {
		return this.eqO2;
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
	 * @return orgTrspAgmtEqSzCd
	 */
	public String getOrgTrspAgmtEqSzCd() {
		return this.orgTrspAgmtEqSzCd;
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
	 * @return eqAlal
	 */
	public String getEqAlal() {
		return this.eqAlal;
	}
	
	/**
	 * Column Info
	 * @return eqD4
	 */
	public String getEqD4() {
		return this.eqD4;
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
	 * @return eqSf4
	 */
	public String getEqSf4() {
		return this.eqSf4;
	}
	
	/**
	 * Column Info
	 * @return eqD5
	 */
	public String getEqD5() {
		return this.eqD5;
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
	 * @return eqD7
	 */
	public String getEqD7() {
		return this.eqD7;
	}
	
	/**
	 * Column Info
	 * @return eqD2
	 */
	public String getEqD2() {
		return this.eqD2;
	}
	
	/**
	 * Column Info
	 * @return eqSf2
	 */
	public String getEqSf2() {
		return this.eqSf2;
	}
	
	/**
	 * Column Info
	 * @return eqD3
	 */
	public String getEqD3() {
		return this.eqD3;
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
	 * @return eqTa2
	 */
	public String getEqTa2() {
		return this.eqTa2;
	}
	
	/**
	 * Column Info
	 * @return eqD9
	 */
	public String getEqD9() {
		return this.eqD9;
	}
	
	/**
	 * Column Info
	 * @return eqD8
	 */
	public String getEqD8() {
		return this.eqD8;
	}
	
	/**
	 * Column Info
	 * @return chkRowno
	 */
	public String getChkRowno() {
		return this.chkRowno;
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
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return eqUg
	 */
	public String getEqUg() {
		return this.eqUg;
	}
	
	/**
	 * Column Info
	 * @return eqCg
	 */
	public String getEqCg() {
		return this.eqCg;
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
	 * @return trspAgmtBdlQty
	 */
	public String getTrspAgmtBdlQty() {
		return this.trspAgmtBdlQty;
	}
	
	/**
	 * Column Info
	 * @return viaNodYd
	 */
	public String getViaNodYd() {
		return this.viaNodYd;
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
	 * @return rlt
	 */
	public String getRlt() {
		return this.rlt;
	}
	
	/**
	 * Column Info
	 * @return orgTrspAgmtEqTpCd
	 */
	public String getOrgTrspAgmtEqTpCd() {
		return this.orgTrspAgmtEqTpCd;
	}
	
	/**
	 * Column Info
	 * @return rowno
	 */
	public String getRowno() {
		return this.rowno;
	}
	
	/**
	 * Column Info
	 * @return eqR9
	 */
	public String getEqR9() {
		return this.eqR9;
	}
	
	/**
	 * Column Info
	 * @return eqR8
	 */
	public String getEqR8() {
		return this.eqR8;
	}
	
	/**
	 * Column Info
	 * @return eqR7
	 */
	public String getEqR7() {
		return this.eqR7;
	}
	
	/**
	 * Column Info
	 * @return eqSfal
	 */
	public String getEqSfal() {
		return this.eqSfal;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtRtTpCd
	 */
	public String getTrspAgmtRtTpCd() {
		return this.trspAgmtRtTpCd;
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
	 * @return eqCb4
	 */
	public String getEqCb4() {
		return this.eqCb4;
	}
	
	/**
	 * Column Info
	 * @return eqR4
	 */
	public String getEqR4() {
		return this.eqR4;
	}
	
	/**
	 * Column Info
	 * @return eqR5
	 */
	public String getEqR5() {
		return this.eqR5;
	}
	
	/**
	 * Column Info
	 * @return eqR2
	 */
	public String getEqR2() {
		return this.eqR2;
	}
	
	/**
	 * Column Info
	 * @return orgEqtype
	 */
	public String getOrgEqtype() {
		return this.orgEqtype;
	}
	
	/**
	 * Column Info
	 * @return eqGnal
	 */
	public String getEqGnal() {
		return this.eqGnal;
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
	 * @return eqOal
	 */
	public String getEqOal() {
		return this.eqOal;
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
	 * @return eqZt4
	 */
	public String getEqZt4() {
		return this.eqZt4;
	}
	
	/**
	 * Column Info
	 * @return eqS2
	 */
	public String getEqS2() {
		return this.eqS2;
	}
	
	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return eqS4
	 */
	public String getEqS4() {
		return this.eqS4;
	}
	
	/**
	 * Column Info
	 * @return eqSlal
	 */
	public String getEqSlal() {
		return this.eqSlal;
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
	 * @return eqA5
	 */
	public String getEqA5() {
		return this.eqA5;
	}
	
	/**
	 * Column Info
	 * @return eqEg5
	 */
	public String getEqEg5() {
		return this.eqEg5;
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
	 * @return eqA2
	 */
	public String getEqA2() {
		return this.eqA2;
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
	 * @return eqA4
	 */
	public String getEqA4() {
		return this.eqA4;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtOfcCtyCd
	 */
	public String getTrspAgmtOfcCtyCd() {
		return this.trspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return eqEg8
	 */
	public String getEqEg8() {
		return this.eqEg8;
	}
	
	/**
	 * Column Info
	 * @return eqTaal
	 */
	public String getEqTaal() {
		return this.eqTaal;
	}
	
	/**
	 * Column Info
	 * @return custNomiTrkrIndCd
	 */
	public String getCustNomiTrkrIndCd() {
		return this.custNomiTrkrIndCd;
	}
	
	/**
	 * Column Info
	 * @return eqP4
	 */
	public String getEqP4() {
		return this.eqP4;
	}
	
	/**
	 * Column Info
	 * @return eqP2
	 */
	public String getEqP2() {
		return this.eqP2;
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
	 * @return trspRvsAplyFlg
	 */
	public String getTrspRvsAplyFlg() {
		return this.trspRvsAplyFlg;
	}
	
	/**
	 * Column Info
	 * @return eqFal
	 */
	public String getEqFal() {
		return this.eqFal;
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
	 * @return fmNodYd
	 */
	public String getFmNodYd() {
		return this.fmNodYd;
	}
	
	/**
	 * Column Info
	 * @return eqEgal
	 */
	public String getEqEgal() {
		return this.eqEgal;
	}
	
	/**
	 * Column Info
	 * @return eqSl2
	 */
	public String getEqSl2() {
		return this.eqSl2;
	}
	
	/**
	 * Column Info
	 * @return dorNodYd
	 */
	public String getDorNodYd() {
		return this.dorNodYd;
	}
	
	/**
	 * Column Info
	 * @return uiSeqno
	 */
	public String getUiSeqno() {
		return this.uiSeqno;
	}
	
	/**
	 * Column Info
	 * @return eqDal
	 */
	public String getEqDal() {
		return this.eqDal;
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
	 * @param toNodYd
	 */
	public void setToNodYd(String toNodYd) {
		this.toNodYd = toNodYd;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param eqAal
	 */
	public void setEqAal(String eqAal) {
		this.eqAal = eqAal;
	}
	
	/**
	 * Column Info
	 * @param ckVf
	 */
	public void setCkVf(String ckVf) {
		this.ckVf = ckVf;
	}
	
	/**
	 * Column Info
	 * @param eqAl2
	 */
	public void setEqAl2(String eqAl2) {
		this.eqAl2 = eqAl2;
	}
	
	/**
	 * Column Info
	 * @param eqF2
	 */
	public void setEqF2(String eqF2) {
		this.eqF2 = eqF2;
	}
	
	/**
	 * Column Info
	 * @param eqF4
	 */
	public void setEqF4(String eqF4) {
		this.eqF4 = eqF4;
	}
	
	/**
	 * Column Info
	 * @param eqF5
	 */
	public void setEqF5(String eqF5) {
		this.eqF5 = eqF5;
	}
	
	/**
	 * Column Info
	 * @param eqAl5
	 */
	public void setEqAl5(String eqAl5) {
		this.eqAl5 = eqAl5;
	}
	
	/**
	 * Column Info
	 * @param eqAl4
	 */
	public void setEqAl4(String eqAl4) {
		this.eqAl4 = eqAl4;
	}
	
	/**
	 * Column Info
	 * @param eqDw
	 */
	public void setEqDw(String eqDw) {
		this.eqDw = eqDw;
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
	 * @param eqAl7
	 */
	public void setEqAl7(String eqAl7) {
		this.eqAl7 = eqAl7;
	}
	
	/**
	 * Column Info
	 * @param eqO4
	 */
	public void setEqO4(String eqO4) {
		this.eqO4 = eqO4;
	}
	
	/**
	 * Column Info
	 * @param eqAl8
	 */
	public void setEqAl8(String eqAl8) {
		this.eqAl8 = eqAl8;
	}
	
	/**
	 * Column Info
	 * @param eqO5
	 */
	public void setEqO5(String eqO5) {
		this.eqO5 = eqO5;
	}
	
	/**
	 * Column Info
	 * @param eqO7
	 */
	public void setEqO7(String eqO7) {
		this.eqO7 = eqO7;
	}
	
	/**
	 * Column Info
	 * @param eqAl9
	 */
	public void setEqAl9(String eqAl9) {
		this.eqAl9 = eqAl9;
	}
	
	/**
	 * Column Info
	 * @param eqT2
	 */
	public void setEqT2(String eqT2) {
		this.eqT2 = eqT2;
	}
	
	/**
	 * Column Info
	 * @param eqDx
	 */
	public void setEqDx(String eqDx) {
		this.eqDx = eqDx;
	}
	
	/**
	 * Column Info
	 * @param eqT4
	 */
	public void setEqT4(String eqT4) {
		this.eqT4 = eqT4;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
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
	 * @param eqPal
	 */
	public void setEqPal(String eqPal) {
		this.eqPal = eqPal;
	}
	
	/**
	 * Column Info
	 * @param eqTal
	 */
	public void setEqTal(String eqTal) {
		this.eqTal = eqTal;
	}
	
	/**
	 * Column Info
	 * @param eqGn4
	 */
	public void setEqGn4(String eqGn4) {
		this.eqGn4 = eqGn4;
	}
	
	/**
	 * Column Info
	 * @param eqGn5
	 */
	public void setEqGn5(String eqGn5) {
		this.eqGn5 = eqGn5;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param eqRal
	 */
	public void setEqRal(String eqRal) {
		this.eqRal = eqRal;
	}
	
	/**
	 * Column Info
	 * @param eqSal
	 */
	public void setEqSal(String eqSal) {
		this.eqSal = eqSal;
	}
	
	/**
	 * Column Info
	 * @param agmtAproDt
	 */
	public void setAgmtAproDt(String agmtAproDt) {
		this.agmtAproDt = agmtAproDt;
	}
	
	/**
	 * Column Info
	 * @param eqO2
	 */
	public void setEqO2(String eqO2) {
		this.eqO2 = eqO2;
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
	 * @param orgTrspAgmtEqSzCd
	 */
	public void setOrgTrspAgmtEqSzCd(String orgTrspAgmtEqSzCd) {
		this.orgTrspAgmtEqSzCd = orgTrspAgmtEqSzCd;
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
	 * @param eqAlal
	 */
	public void setEqAlal(String eqAlal) {
		this.eqAlal = eqAlal;
	}
	
	/**
	 * Column Info
	 * @param eqD4
	 */
	public void setEqD4(String eqD4) {
		this.eqD4 = eqD4;
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
	 * @param eqSf4
	 */
	public void setEqSf4(String eqSf4) {
		this.eqSf4 = eqSf4;
	}
	
	/**
	 * Column Info
	 * @param eqD5
	 */
	public void setEqD5(String eqD5) {
		this.eqD5 = eqD5;
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
	 * @param eqD7
	 */
	public void setEqD7(String eqD7) {
		this.eqD7 = eqD7;
	}
	
	/**
	 * Column Info
	 * @param eqD2
	 */
	public void setEqD2(String eqD2) {
		this.eqD2 = eqD2;
	}
	
	/**
	 * Column Info
	 * @param eqSf2
	 */
	public void setEqSf2(String eqSf2) {
		this.eqSf2 = eqSf2;
	}
	
	/**
	 * Column Info
	 * @param eqD3
	 */
	public void setEqD3(String eqD3) {
		this.eqD3 = eqD3;
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
	 * @param eqTa2
	 */
	public void setEqTa2(String eqTa2) {
		this.eqTa2 = eqTa2;
	}
	
	/**
	 * Column Info
	 * @param eqD9
	 */
	public void setEqD9(String eqD9) {
		this.eqD9 = eqD9;
	}
	
	/**
	 * Column Info
	 * @param eqD8
	 */
	public void setEqD8(String eqD8) {
		this.eqD8 = eqD8;
	}
	
	/**
	 * Column Info
	 * @param chkRowno
	 */
	public void setChkRowno(String chkRowno) {
		this.chkRowno = chkRowno;
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
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param eqUg
	 */
	public void setEqUg(String eqUg) {
		this.eqUg = eqUg;
	}
	
	/**
	 * Column Info
	 * @param eqCg
	 */
	public void setEqCg(String eqCg) {
		this.eqCg = eqCg;
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
	 * @param trspAgmtBdlQty
	 */
	public void setTrspAgmtBdlQty(String trspAgmtBdlQty) {
		this.trspAgmtBdlQty = trspAgmtBdlQty;
	}
	
	/**
	 * Column Info
	 * @param viaNodYd
	 */
	public void setViaNodYd(String viaNodYd) {
		this.viaNodYd = viaNodYd;
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
	 * @param rlt
	 */
	public void setRlt(String rlt) {
		this.rlt = rlt;
	}
	
	/**
	 * Column Info
	 * @param orgTrspAgmtEqTpCd
	 */
	public void setOrgTrspAgmtEqTpCd(String orgTrspAgmtEqTpCd) {
		this.orgTrspAgmtEqTpCd = orgTrspAgmtEqTpCd;
	}
	
	/**
	 * Column Info
	 * @param rowno
	 */
	public void setRowno(String rowno) {
		this.rowno = rowno;
	}
	
	/**
	 * Column Info
	 * @param eqR9
	 */
	public void setEqR9(String eqR9) {
		this.eqR9 = eqR9;
	}
	
	/**
	 * Column Info
	 * @param eqR8
	 */
	public void setEqR8(String eqR8) {
		this.eqR8 = eqR8;
	}
	
	/**
	 * Column Info
	 * @param eqR7
	 */
	public void setEqR7(String eqR7) {
		this.eqR7 = eqR7;
	}
	
	/**
	 * Column Info
	 * @param eqSfal
	 */
	public void setEqSfal(String eqSfal) {
		this.eqSfal = eqSfal;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtRtTpCd
	 */
	public void setTrspAgmtRtTpCd(String trspAgmtRtTpCd) {
		this.trspAgmtRtTpCd = trspAgmtRtTpCd;
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
	 * @param eqCb4
	 */
	public void setEqCb4(String eqCb4) {
		this.eqCb4 = eqCb4;
	}
	
	/**
	 * Column Info
	 * @param eqR4
	 */
	public void setEqR4(String eqR4) {
		this.eqR4 = eqR4;
	}
	
	/**
	 * Column Info
	 * @param eqR5
	 */
	public void setEqR5(String eqR5) {
		this.eqR5 = eqR5;
	}
	
	/**
	 * Column Info
	 * @param eqR2
	 */
	public void setEqR2(String eqR2) {
		this.eqR2 = eqR2;
	}
	
	/**
	 * Column Info
	 * @param orgEqtype
	 */
	public void setOrgEqtype(String orgEqtype) {
		this.orgEqtype = orgEqtype;
	}
	
	/**
	 * Column Info
	 * @param eqGnal
	 */
	public void setEqGnal(String eqGnal) {
		this.eqGnal = eqGnal;
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
	 * @param eqOal
	 */
	public void setEqOal(String eqOal) {
		this.eqOal = eqOal;
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
	 * @param eqZt4
	 */
	public void setEqZt4(String eqZt4) {
		this.eqZt4 = eqZt4;
	}
	
	/**
	 * Column Info
	 * @param eqS2
	 */
	public void setEqS2(String eqS2) {
		this.eqS2 = eqS2;
	}
	
	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param eqS4
	 */
	public void setEqS4(String eqS4) {
		this.eqS4 = eqS4;
	}
	
	/**
	 * Column Info
	 * @param eqSlal
	 */
	public void setEqSlal(String eqSlal) {
		this.eqSlal = eqSlal;
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
	 * @param eqA5
	 */
	public void setEqA5(String eqA5) {
		this.eqA5 = eqA5;
	}
	
	/**
	 * Column Info
	 * @param eqEg5
	 */
	public void setEqEg5(String eqEg5) {
		this.eqEg5 = eqEg5;
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
	 * @param eqA2
	 */
	public void setEqA2(String eqA2) {
		this.eqA2 = eqA2;
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
	 * @param eqA4
	 */
	public void setEqA4(String eqA4) {
		this.eqA4 = eqA4;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtOfcCtyCd
	 */
	public void setTrspAgmtOfcCtyCd(String trspAgmtOfcCtyCd) {
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param eqEg8
	 */
	public void setEqEg8(String eqEg8) {
		this.eqEg8 = eqEg8;
	}
	
	/**
	 * Column Info
	 * @param eqTaal
	 */
	public void setEqTaal(String eqTaal) {
		this.eqTaal = eqTaal;
	}
	
	/**
	 * Column Info
	 * @param custNomiTrkrIndCd
	 */
	public void setCustNomiTrkrIndCd(String custNomiTrkrIndCd) {
		this.custNomiTrkrIndCd = custNomiTrkrIndCd;
	}
	
	/**
	 * Column Info
	 * @param eqP4
	 */
	public void setEqP4(String eqP4) {
		this.eqP4 = eqP4;
	}
	
	/**
	 * Column Info
	 * @param eqP2
	 */
	public void setEqP2(String eqP2) {
		this.eqP2 = eqP2;
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
	 * @param trspRvsAplyFlg
	 */
	public void setTrspRvsAplyFlg(String trspRvsAplyFlg) {
		this.trspRvsAplyFlg = trspRvsAplyFlg;
	}
	
	/**
	 * Column Info
	 * @param eqFal
	 */
	public void setEqFal(String eqFal) {
		this.eqFal = eqFal;
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
	 * @param fmNodYd
	 */
	public void setFmNodYd(String fmNodYd) {
		this.fmNodYd = fmNodYd;
	}
	
	/**
	 * Column Info
	 * @param eqEgal
	 */
	public void setEqEgal(String eqEgal) {
		this.eqEgal = eqEgal;
	}
	
	/**
	 * Column Info
	 * @param eqSl2
	 */
	public void setEqSl2(String eqSl2) {
		this.eqSl2 = eqSl2;
	}
	
	/**
	 * Column Info
	 * @param dorNodYd
	 */
	public void setDorNodYd(String dorNodYd) {
		this.dorNodYd = dorNodYd;
	}
	
	/**
	 * Column Info
	 * @param uiSeqno
	 */
	public void setUiSeqno(String uiSeqno) {
		this.uiSeqno = uiSeqno;
	}
	
	/**
	 * Column Info
	 * @param eqDal
	 */
	public void setEqDal(String eqDal) {
		this.eqDal = eqDal;
	}
	
	/**
	 * Column Info
	 * @param trspDistTpCd
	 */
	public void setTrspDistTpCd(String trspDistTpCd) {
		this.trspDistTpCd = trspDistTpCd;
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
		setToNodYd(JSPUtil.getParameter(request, prefix + "to_nod_yd", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setTrspRndRt(JSPUtil.getParameter(request, prefix + "trsp_rnd_rt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEqAal(JSPUtil.getParameter(request, prefix + "eq_aal", ""));
		setCkVf(JSPUtil.getParameter(request, prefix + "ck_vf", ""));
		setEqAl2(JSPUtil.getParameter(request, prefix + "eq_al2", ""));
		setEqF2(JSPUtil.getParameter(request, prefix + "eq_f2", ""));
		setEqF4(JSPUtil.getParameter(request, prefix + "eq_f4", ""));
		setEqF5(JSPUtil.getParameter(request, prefix + "eq_f5", ""));
		setEqAl5(JSPUtil.getParameter(request, prefix + "eq_al5", ""));
		setEqAl4(JSPUtil.getParameter(request, prefix + "eq_al4", ""));
		setEqDw(JSPUtil.getParameter(request, prefix + "eq_dw", ""));
		setTrspScgCd(JSPUtil.getParameter(request, prefix + "trsp_scg_cd", ""));
		setEqAl7(JSPUtil.getParameter(request, prefix + "eq_al7", ""));
		setEqO4(JSPUtil.getParameter(request, prefix + "eq_o4", ""));
		setEqAl8(JSPUtil.getParameter(request, prefix + "eq_al8", ""));
		setEqO5(JSPUtil.getParameter(request, prefix + "eq_o5", ""));
		setEqO7(JSPUtil.getParameter(request, prefix + "eq_o7", ""));
		setEqAl9(JSPUtil.getParameter(request, prefix + "eq_al9", ""));
		setEqT2(JSPUtil.getParameter(request, prefix + "eq_t2", ""));
		setEqDx(JSPUtil.getParameter(request, prefix + "eq_dx", ""));
		setEqT4(JSPUtil.getParameter(request, prefix + "eq_t4", ""));
		setTrspOneWyRt(JSPUtil.getParameter(request, prefix + "trsp_one_wy_rt", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setCmdtGrpCd(JSPUtil.getParameter(request, prefix + "cmdt_grp_cd", ""));
		setEqPal(JSPUtil.getParameter(request, prefix + "eq_pal", ""));
		setEqTal(JSPUtil.getParameter(request, prefix + "eq_tal", ""));
		setEqGn4(JSPUtil.getParameter(request, prefix + "eq_gn4", ""));
		setEqGn5(JSPUtil.getParameter(request, prefix + "eq_gn5", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setEqRal(JSPUtil.getParameter(request, prefix + "eq_ral", ""));
		setEqSal(JSPUtil.getParameter(request, prefix + "eq_sal", ""));
		setAgmtAproDt(JSPUtil.getParameter(request, prefix + "agmt_apro_dt", ""));
		setEqO2(JSPUtil.getParameter(request, prefix + "eq_o2", ""));
		setRailSvcTpCd(JSPUtil.getParameter(request, prefix + "rail_svc_tp_cd", ""));
		setOrgTrspAgmtEqSzCd(JSPUtil.getParameter(request, prefix + "org_trsp_agmt_eq_sz_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setToWgt(JSPUtil.getParameter(request, prefix + "to_wgt", ""));
		setEqAlal(JSPUtil.getParameter(request, prefix + "eq_alal", ""));
		setEqD4(JSPUtil.getParameter(request, prefix + "eq_d4", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setEqSf4(JSPUtil.getParameter(request, prefix + "eq_sf4", ""));
		setEqD5(JSPUtil.getParameter(request, prefix + "eq_d5", ""));
		setWtrDeTermCd(JSPUtil.getParameter(request, prefix + "wtr_de_term_cd", ""));
		setEqD7(JSPUtil.getParameter(request, prefix + "eq_d7", ""));
		setEqD2(JSPUtil.getParameter(request, prefix + "eq_d2", ""));
		setEqSf2(JSPUtil.getParameter(request, prefix + "eq_sf2", ""));
		setEqD3(JSPUtil.getParameter(request, prefix + "eq_d3", ""));
		setAgmtScgRtDivCd(JSPUtil.getParameter(request, prefix + "agmt_scg_rt_div_cd", ""));
		setTrspAgmtEqTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_eq_tp_cd", ""));
		setEqTa2(JSPUtil.getParameter(request, prefix + "eq_ta2", ""));
		setEqD9(JSPUtil.getParameter(request, prefix + "eq_d9", ""));
		setEqD8(JSPUtil.getParameter(request, prefix + "eq_d8", ""));
		setChkRowno(JSPUtil.getParameter(request, prefix + "chk_rowno", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setEqUg(JSPUtil.getParameter(request, prefix + "eq_ug", ""));
		setEqCg(JSPUtil.getParameter(request, prefix + "eq_cg", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setAgmtTrspTpCd(JSPUtil.getParameter(request, prefix + "agmt_trsp_tp_cd", ""));
		setTrspAgmtBdlQty(JSPUtil.getParameter(request, prefix + "trsp_agmt_bdl_qty", ""));
		setViaNodYd(JSPUtil.getParameter(request, prefix + "via_nod_yd", ""));
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setRlt(JSPUtil.getParameter(request, prefix + "rlt", ""));
		setOrgTrspAgmtEqTpCd(JSPUtil.getParameter(request, prefix + "org_trsp_agmt_eq_tp_cd", ""));
		setRowno(JSPUtil.getParameter(request, prefix + "rowno", ""));
		setEqR9(JSPUtil.getParameter(request, prefix + "eq_r9", ""));
		setEqR8(JSPUtil.getParameter(request, prefix + "eq_r8", ""));
		setEqR7(JSPUtil.getParameter(request, prefix + "eq_r7", ""));
		setEqSfal(JSPUtil.getParameter(request, prefix + "eq_sfal", ""));
		setTrspAgmtRtTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_cd", ""));
		setTrspAgmtEqSzCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_eq_sz_cd", ""));
		setEqCb4(JSPUtil.getParameter(request, prefix + "eq_cb4", ""));
		setEqR4(JSPUtil.getParameter(request, prefix + "eq_r4", ""));
		setEqR5(JSPUtil.getParameter(request, prefix + "eq_r5", ""));
		setEqR2(JSPUtil.getParameter(request, prefix + "eq_r2", ""));
		setOrgEqtype(JSPUtil.getParameter(request, prefix + "org_eqtype", ""));
		setEqGnal(JSPUtil.getParameter(request, prefix + "eq_gnal", ""));
		setTrspAgmtDist(JSPUtil.getParameter(request, prefix + "trsp_agmt_dist", ""));
		setEqOal(JSPUtil.getParameter(request, prefix + "eq_oal", ""));
		setDistMeasUtCd(JSPUtil.getParameter(request, prefix + "dist_meas_ut_cd", ""));
		setEqZt4(JSPUtil.getParameter(request, prefix + "eq_zt4", ""));
		setEqS2(JSPUtil.getParameter(request, prefix + "eq_s2", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setEqS4(JSPUtil.getParameter(request, prefix + "eq_s4", ""));
		setEqSlal(JSPUtil.getParameter(request, prefix + "eq_slal", ""));
		setTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_seq", ""));
		setWgtMeasUtCd(JSPUtil.getParameter(request, prefix + "wgt_meas_ut_cd", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setEqA5(JSPUtil.getParameter(request, prefix + "eq_a5", ""));
		setEqEg5(JSPUtil.getParameter(request, prefix + "eq_eg5", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setEqA2(JSPUtil.getParameter(request, prefix + "eq_a2", ""));
		setAgmtRoutAllFlg(JSPUtil.getParameter(request, prefix + "agmt_rout_all_flg", ""));
		setEqA4(JSPUtil.getParameter(request, prefix + "eq_a4", ""));
		setTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_ofc_cty_cd", ""));
		setEqEg8(JSPUtil.getParameter(request, prefix + "eq_eg8", ""));
		setEqTaal(JSPUtil.getParameter(request, prefix + "eq_taal", ""));
		setCustNomiTrkrIndCd(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_ind_cd", ""));
		setEqP4(JSPUtil.getParameter(request, prefix + "eq_p4", ""));
		setEqP2(JSPUtil.getParameter(request, prefix + "eq_p2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWtrRcvTermCd(JSPUtil.getParameter(request, prefix + "wtr_rcv_term_cd", ""));
		setTrspRvsAplyFlg(JSPUtil.getParameter(request, prefix + "trsp_rvs_aply_flg", ""));
		setEqFal(JSPUtil.getParameter(request, prefix + "eq_fal", ""));
		setTrspCostModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_mod_cd", ""));
		setFmNodYd(JSPUtil.getParameter(request, prefix + "fm_nod_yd", ""));
		setEqEgal(JSPUtil.getParameter(request, prefix + "eq_egal", ""));
		setEqSl2(JSPUtil.getParameter(request, prefix + "eq_sl2", ""));
		setDorNodYd(JSPUtil.getParameter(request, prefix + "dor_nod_yd", ""));
		setUiSeqno(JSPUtil.getParameter(request, prefix + "ui_seqno", ""));
		setEqDal(JSPUtil.getParameter(request, prefix + "eq_dal", ""));
		setTrspDistTpCd(JSPUtil.getParameter(request, prefix + "trsp_dist_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DummyAgmtRateVO[]
	 */
	public DummyAgmtRateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DummyAgmtRateVO[]
	 */
	public DummyAgmtRateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DummyAgmtRateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodYd = (JSPUtil.getParameter(request, prefix	+ "to_nod_yd", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] trspRndRt = (JSPUtil.getParameter(request, prefix	+ "trsp_rnd_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqAal = (JSPUtil.getParameter(request, prefix	+ "eq_aal", length));
			String[] ckVf = (JSPUtil.getParameter(request, prefix	+ "ck_vf", length));
			String[] eqAl2 = (JSPUtil.getParameter(request, prefix	+ "eq_al2", length));
			String[] eqF2 = (JSPUtil.getParameter(request, prefix	+ "eq_f2", length));
			String[] eqF4 = (JSPUtil.getParameter(request, prefix	+ "eq_f4", length));
			String[] eqF5 = (JSPUtil.getParameter(request, prefix	+ "eq_f5", length));
			String[] eqAl5 = (JSPUtil.getParameter(request, prefix	+ "eq_al5", length));
			String[] eqAl4 = (JSPUtil.getParameter(request, prefix	+ "eq_al4", length));
			String[] eqDw = (JSPUtil.getParameter(request, prefix	+ "eq_dw", length));
			String[] trspScgCd = (JSPUtil.getParameter(request, prefix	+ "trsp_scg_cd", length));
			String[] eqAl7 = (JSPUtil.getParameter(request, prefix	+ "eq_al7", length));
			String[] eqO4 = (JSPUtil.getParameter(request, prefix	+ "eq_o4", length));
			String[] eqAl8 = (JSPUtil.getParameter(request, prefix	+ "eq_al8", length));
			String[] eqO5 = (JSPUtil.getParameter(request, prefix	+ "eq_o5", length));
			String[] eqO7 = (JSPUtil.getParameter(request, prefix	+ "eq_o7", length));
			String[] eqAl9 = (JSPUtil.getParameter(request, prefix	+ "eq_al9", length));
			String[] eqT2 = (JSPUtil.getParameter(request, prefix	+ "eq_t2", length));
			String[] eqDx = (JSPUtil.getParameter(request, prefix	+ "eq_dx", length));
			String[] eqT4 = (JSPUtil.getParameter(request, prefix	+ "eq_t4", length));
			String[] trspOneWyRt = (JSPUtil.getParameter(request, prefix	+ "trsp_one_wy_rt", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] cmdtGrpCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_grp_cd", length));
			String[] eqPal = (JSPUtil.getParameter(request, prefix	+ "eq_pal", length));
			String[] eqTal = (JSPUtil.getParameter(request, prefix	+ "eq_tal", length));
			String[] eqGn4 = (JSPUtil.getParameter(request, prefix	+ "eq_gn4", length));
			String[] eqGn5 = (JSPUtil.getParameter(request, prefix	+ "eq_gn5", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] eqRal = (JSPUtil.getParameter(request, prefix	+ "eq_ral", length));
			String[] eqSal = (JSPUtil.getParameter(request, prefix	+ "eq_sal", length));
			String[] agmtAproDt = (JSPUtil.getParameter(request, prefix	+ "agmt_apro_dt", length));
			String[] eqO2 = (JSPUtil.getParameter(request, prefix	+ "eq_o2", length));
			String[] railSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_svc_tp_cd", length));
			String[] orgTrspAgmtEqSzCd = (JSPUtil.getParameter(request, prefix	+ "org_trsp_agmt_eq_sz_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] toWgt = (JSPUtil.getParameter(request, prefix	+ "to_wgt", length));
			String[] eqAlal = (JSPUtil.getParameter(request, prefix	+ "eq_alal", length));
			String[] eqD4 = (JSPUtil.getParameter(request, prefix	+ "eq_d4", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] eqSf4 = (JSPUtil.getParameter(request, prefix	+ "eq_sf4", length));
			String[] eqD5 = (JSPUtil.getParameter(request, prefix	+ "eq_d5", length));
			String[] wtrDeTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_de_term_cd", length));
			String[] eqD7 = (JSPUtil.getParameter(request, prefix	+ "eq_d7", length));
			String[] eqD2 = (JSPUtil.getParameter(request, prefix	+ "eq_d2", length));
			String[] eqSf2 = (JSPUtil.getParameter(request, prefix	+ "eq_sf2", length));
			String[] eqD3 = (JSPUtil.getParameter(request, prefix	+ "eq_d3", length));
			String[] agmtScgRtDivCd = (JSPUtil.getParameter(request, prefix	+ "agmt_scg_rt_div_cd", length));
			String[] trspAgmtEqTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_eq_tp_cd", length));
			String[] eqTa2 = (JSPUtil.getParameter(request, prefix	+ "eq_ta2", length));
			String[] eqD9 = (JSPUtil.getParameter(request, prefix	+ "eq_d9", length));
			String[] eqD8 = (JSPUtil.getParameter(request, prefix	+ "eq_d8", length));
			String[] chkRowno = (JSPUtil.getParameter(request, prefix	+ "chk_rowno", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] eqUg = (JSPUtil.getParameter(request, prefix	+ "eq_ug", length));
			String[] eqCg = (JSPUtil.getParameter(request, prefix	+ "eq_cg", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] agmtTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "agmt_trsp_tp_cd", length));
			String[] trspAgmtBdlQty = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_bdl_qty", length));
			String[] viaNodYd = (JSPUtil.getParameter(request, prefix	+ "via_nod_yd", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] rlt = (JSPUtil.getParameter(request, prefix	+ "rlt", length));
			String[] orgTrspAgmtEqTpCd = (JSPUtil.getParameter(request, prefix	+ "org_trsp_agmt_eq_tp_cd", length));
			String[] rowno = (JSPUtil.getParameter(request, prefix	+ "rowno", length));
			String[] eqR9 = (JSPUtil.getParameter(request, prefix	+ "eq_r9", length));
			String[] eqR8 = (JSPUtil.getParameter(request, prefix	+ "eq_r8", length));
			String[] eqR7 = (JSPUtil.getParameter(request, prefix	+ "eq_r7", length));
			String[] eqSfal = (JSPUtil.getParameter(request, prefix	+ "eq_sfal", length));
			String[] trspAgmtRtTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_rt_tp_cd", length));
			String[] trspAgmtEqSzCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_eq_sz_cd", length));
			String[] eqCb4 = (JSPUtil.getParameter(request, prefix	+ "eq_cb4", length));
			String[] eqR4 = (JSPUtil.getParameter(request, prefix	+ "eq_r4", length));
			String[] eqR5 = (JSPUtil.getParameter(request, prefix	+ "eq_r5", length));
			String[] eqR2 = (JSPUtil.getParameter(request, prefix	+ "eq_r2", length));
			String[] orgEqtype = (JSPUtil.getParameter(request, prefix	+ "org_eqtype", length));
			String[] eqGnal = (JSPUtil.getParameter(request, prefix	+ "eq_gnal", length));
			String[] trspAgmtDist = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_dist", length));
			String[] eqOal = (JSPUtil.getParameter(request, prefix	+ "eq_oal", length));
			String[] distMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "dist_meas_ut_cd", length));
			String[] eqZt4 = (JSPUtil.getParameter(request, prefix	+ "eq_zt4", length));
			String[] eqS2 = (JSPUtil.getParameter(request, prefix	+ "eq_s2", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] eqS4 = (JSPUtil.getParameter(request, prefix	+ "eq_s4", length));
			String[] eqSlal = (JSPUtil.getParameter(request, prefix	+ "eq_slal", length));
			String[] trspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_seq", length));
			String[] wgtMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_meas_ut_cd", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] eqA5 = (JSPUtil.getParameter(request, prefix	+ "eq_a5", length));
			String[] eqEg5 = (JSPUtil.getParameter(request, prefix	+ "eq_eg5", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] eqA2 = (JSPUtil.getParameter(request, prefix	+ "eq_a2", length));
			String[] agmtRoutAllFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_rout_all_flg", length));
			String[] eqA4 = (JSPUtil.getParameter(request, prefix	+ "eq_a4", length));
			String[] trspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_ofc_cty_cd", length));
			String[] eqEg8 = (JSPUtil.getParameter(request, prefix	+ "eq_eg8", length));
			String[] eqTaal = (JSPUtil.getParameter(request, prefix	+ "eq_taal", length));
			String[] custNomiTrkrIndCd = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_ind_cd", length));
			String[] eqP4 = (JSPUtil.getParameter(request, prefix	+ "eq_p4", length));
			String[] eqP2 = (JSPUtil.getParameter(request, prefix	+ "eq_p2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wtrRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_rcv_term_cd", length));
			String[] trspRvsAplyFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_rvs_aply_flg", length));
			String[] eqFal = (JSPUtil.getParameter(request, prefix	+ "eq_fal", length));
			String[] trspCostModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_mod_cd", length));
			String[] fmNodYd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_yd", length));
			String[] eqEgal = (JSPUtil.getParameter(request, prefix	+ "eq_egal", length));
			String[] eqSl2 = (JSPUtil.getParameter(request, prefix	+ "eq_sl2", length));
			String[] dorNodYd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_yd", length));
			String[] uiSeqno = (JSPUtil.getParameter(request, prefix	+ "ui_seqno", length));
			String[] eqDal = (JSPUtil.getParameter(request, prefix	+ "eq_dal", length));
			String[] trspDistTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_dist_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DummyAgmtRateVO();
				if (toNodYd[i] != null)
					model.setToNodYd(toNodYd[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (trspRndRt[i] != null)
					model.setTrspRndRt(trspRndRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqAal[i] != null)
					model.setEqAal(eqAal[i]);
				if (ckVf[i] != null)
					model.setCkVf(ckVf[i]);
				if (eqAl2[i] != null)
					model.setEqAl2(eqAl2[i]);
				if (eqF2[i] != null)
					model.setEqF2(eqF2[i]);
				if (eqF4[i] != null)
					model.setEqF4(eqF4[i]);
				if (eqF5[i] != null)
					model.setEqF5(eqF5[i]);
				if (eqAl5[i] != null)
					model.setEqAl5(eqAl5[i]);
				if (eqAl4[i] != null)
					model.setEqAl4(eqAl4[i]);
				if (eqDw[i] != null)
					model.setEqDw(eqDw[i]);
				if (trspScgCd[i] != null)
					model.setTrspScgCd(trspScgCd[i]);
				if (eqAl7[i] != null)
					model.setEqAl7(eqAl7[i]);
				if (eqO4[i] != null)
					model.setEqO4(eqO4[i]);
				if (eqAl8[i] != null)
					model.setEqAl8(eqAl8[i]);
				if (eqO5[i] != null)
					model.setEqO5(eqO5[i]);
				if (eqO7[i] != null)
					model.setEqO7(eqO7[i]);
				if (eqAl9[i] != null)
					model.setEqAl9(eqAl9[i]);
				if (eqT2[i] != null)
					model.setEqT2(eqT2[i]);
				if (eqDx[i] != null)
					model.setEqDx(eqDx[i]);
				if (eqT4[i] != null)
					model.setEqT4(eqT4[i]);
				if (trspOneWyRt[i] != null)
					model.setTrspOneWyRt(trspOneWyRt[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (cmdtGrpCd[i] != null)
					model.setCmdtGrpCd(cmdtGrpCd[i]);
				if (eqPal[i] != null)
					model.setEqPal(eqPal[i]);
				if (eqTal[i] != null)
					model.setEqTal(eqTal[i]);
				if (eqGn4[i] != null)
					model.setEqGn4(eqGn4[i]);
				if (eqGn5[i] != null)
					model.setEqGn5(eqGn5[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (eqRal[i] != null)
					model.setEqRal(eqRal[i]);
				if (eqSal[i] != null)
					model.setEqSal(eqSal[i]);
				if (agmtAproDt[i] != null)
					model.setAgmtAproDt(agmtAproDt[i]);
				if (eqO2[i] != null)
					model.setEqO2(eqO2[i]);
				if (railSvcTpCd[i] != null)
					model.setRailSvcTpCd(railSvcTpCd[i]);
				if (orgTrspAgmtEqSzCd[i] != null)
					model.setOrgTrspAgmtEqSzCd(orgTrspAgmtEqSzCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (toWgt[i] != null)
					model.setToWgt(toWgt[i]);
				if (eqAlal[i] != null)
					model.setEqAlal(eqAlal[i]);
				if (eqD4[i] != null)
					model.setEqD4(eqD4[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (eqSf4[i] != null)
					model.setEqSf4(eqSf4[i]);
				if (eqD5[i] != null)
					model.setEqD5(eqD5[i]);
				if (wtrDeTermCd[i] != null)
					model.setWtrDeTermCd(wtrDeTermCd[i]);
				if (eqD7[i] != null)
					model.setEqD7(eqD7[i]);
				if (eqD2[i] != null)
					model.setEqD2(eqD2[i]);
				if (eqSf2[i] != null)
					model.setEqSf2(eqSf2[i]);
				if (eqD3[i] != null)
					model.setEqD3(eqD3[i]);
				if (agmtScgRtDivCd[i] != null)
					model.setAgmtScgRtDivCd(agmtScgRtDivCd[i]);
				if (trspAgmtEqTpCd[i] != null)
					model.setTrspAgmtEqTpCd(trspAgmtEqTpCd[i]);
				if (eqTa2[i] != null)
					model.setEqTa2(eqTa2[i]);
				if (eqD9[i] != null)
					model.setEqD9(eqD9[i]);
				if (eqD8[i] != null)
					model.setEqD8(eqD8[i]);
				if (chkRowno[i] != null)
					model.setChkRowno(chkRowno[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (eqUg[i] != null)
					model.setEqUg(eqUg[i]);
				if (eqCg[i] != null)
					model.setEqCg(eqCg[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (agmtTrspTpCd[i] != null)
					model.setAgmtTrspTpCd(agmtTrspTpCd[i]);
				if (trspAgmtBdlQty[i] != null)
					model.setTrspAgmtBdlQty(trspAgmtBdlQty[i]);
				if (viaNodYd[i] != null)
					model.setViaNodYd(viaNodYd[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (rlt[i] != null)
					model.setRlt(rlt[i]);
				if (orgTrspAgmtEqTpCd[i] != null)
					model.setOrgTrspAgmtEqTpCd(orgTrspAgmtEqTpCd[i]);
				if (rowno[i] != null)
					model.setRowno(rowno[i]);
				if (eqR9[i] != null)
					model.setEqR9(eqR9[i]);
				if (eqR8[i] != null)
					model.setEqR8(eqR8[i]);
				if (eqR7[i] != null)
					model.setEqR7(eqR7[i]);
				if (eqSfal[i] != null)
					model.setEqSfal(eqSfal[i]);
				if (trspAgmtRtTpCd[i] != null)
					model.setTrspAgmtRtTpCd(trspAgmtRtTpCd[i]);
				if (trspAgmtEqSzCd[i] != null)
					model.setTrspAgmtEqSzCd(trspAgmtEqSzCd[i]);
				if (eqCb4[i] != null)
					model.setEqCb4(eqCb4[i]);
				if (eqR4[i] != null)
					model.setEqR4(eqR4[i]);
				if (eqR5[i] != null)
					model.setEqR5(eqR5[i]);
				if (eqR2[i] != null)
					model.setEqR2(eqR2[i]);
				if (orgEqtype[i] != null)
					model.setOrgEqtype(orgEqtype[i]);
				if (eqGnal[i] != null)
					model.setEqGnal(eqGnal[i]);
				if (trspAgmtDist[i] != null)
					model.setTrspAgmtDist(trspAgmtDist[i]);
				if (eqOal[i] != null)
					model.setEqOal(eqOal[i]);
				if (distMeasUtCd[i] != null)
					model.setDistMeasUtCd(distMeasUtCd[i]);
				if (eqZt4[i] != null)
					model.setEqZt4(eqZt4[i]);
				if (eqS2[i] != null)
					model.setEqS2(eqS2[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (eqS4[i] != null)
					model.setEqS4(eqS4[i]);
				if (eqSlal[i] != null)
					model.setEqSlal(eqSlal[i]);
				if (trspAgmtSeq[i] != null)
					model.setTrspAgmtSeq(trspAgmtSeq[i]);
				if (wgtMeasUtCd[i] != null)
					model.setWgtMeasUtCd(wgtMeasUtCd[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (eqA5[i] != null)
					model.setEqA5(eqA5[i]);
				if (eqEg5[i] != null)
					model.setEqEg5(eqEg5[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (eqA2[i] != null)
					model.setEqA2(eqA2[i]);
				if (agmtRoutAllFlg[i] != null)
					model.setAgmtRoutAllFlg(agmtRoutAllFlg[i]);
				if (eqA4[i] != null)
					model.setEqA4(eqA4[i]);
				if (trspAgmtOfcCtyCd[i] != null)
					model.setTrspAgmtOfcCtyCd(trspAgmtOfcCtyCd[i]);
				if (eqEg8[i] != null)
					model.setEqEg8(eqEg8[i]);
				if (eqTaal[i] != null)
					model.setEqTaal(eqTaal[i]);
				if (custNomiTrkrIndCd[i] != null)
					model.setCustNomiTrkrIndCd(custNomiTrkrIndCd[i]);
				if (eqP4[i] != null)
					model.setEqP4(eqP4[i]);
				if (eqP2[i] != null)
					model.setEqP2(eqP2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wtrRcvTermCd[i] != null)
					model.setWtrRcvTermCd(wtrRcvTermCd[i]);
				if (trspRvsAplyFlg[i] != null)
					model.setTrspRvsAplyFlg(trspRvsAplyFlg[i]);
				if (eqFal[i] != null)
					model.setEqFal(eqFal[i]);
				if (trspCostModCd[i] != null)
					model.setTrspCostModCd(trspCostModCd[i]);
				if (fmNodYd[i] != null)
					model.setFmNodYd(fmNodYd[i]);
				if (eqEgal[i] != null)
					model.setEqEgal(eqEgal[i]);
				if (eqSl2[i] != null)
					model.setEqSl2(eqSl2[i]);
				if (dorNodYd[i] != null)
					model.setDorNodYd(dorNodYd[i]);
				if (uiSeqno[i] != null)
					model.setUiSeqno(uiSeqno[i]);
				if (eqDal[i] != null)
					model.setEqDal(eqDal[i]);
				if (trspDistTpCd[i] != null)
					model.setTrspDistTpCd(trspDistTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDummyAgmtRateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DummyAgmtRateVO[]
	 */
	public DummyAgmtRateVO[] getDummyAgmtRateVOs(){
		DummyAgmtRateVO[] vos = (DummyAgmtRateVO[])models.toArray(new DummyAgmtRateVO[models.size()]);
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
		this.toNodYd = this.toNodYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRndRt = this.trspRndRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAal = this.eqAal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ckVf = this.ckVf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAl2 = this.eqAl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqF2 = this.eqF2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqF4 = this.eqF4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqF5 = this.eqF5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAl5 = this.eqAl5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAl4 = this.eqAl4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDw = this.eqDw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspScgCd = this.trspScgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAl7 = this.eqAl7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqO4 = this.eqO4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAl8 = this.eqAl8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqO5 = this.eqO5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqO7 = this.eqO7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAl9 = this.eqAl9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqT2 = this.eqT2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDx = this.eqDx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqT4 = this.eqT4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspOneWyRt = this.trspOneWyRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtGrpCd = this.cmdtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqPal = this.eqPal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTal = this.eqTal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqGn4 = this.eqGn4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqGn5 = this.eqGn5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRal = this.eqRal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSal = this.eqSal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtAproDt = this.agmtAproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqO2 = this.eqO2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railSvcTpCd = this.railSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrspAgmtEqSzCd = this.orgTrspAgmtEqSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWgt = this.toWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAlal = this.eqAlal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqD4 = this.eqD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSf4 = this.eqSf4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqD5 = this.eqD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrDeTermCd = this.wtrDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqD7 = this.eqD7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqD2 = this.eqD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSf2 = this.eqSf2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqD3 = this.eqD3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtScgRtDivCd = this.agmtScgRtDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtEqTpCd = this.trspAgmtEqTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTa2 = this.eqTa2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqD9 = this.eqD9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqD8 = this.eqD8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkRowno = this.chkRowno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqUg = this.eqUg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCg = this.eqCg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtTrspTpCd = this.agmtTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtBdlQty = this.trspAgmtBdlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodYd = this.viaNodYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlt = this.rlt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrspAgmtEqTpCd = this.orgTrspAgmtEqTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowno = this.rowno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqR9 = this.eqR9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqR8 = this.eqR8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqR7 = this.eqR7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSfal = this.eqSfal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRtTpCd = this.trspAgmtRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtEqSzCd = this.trspAgmtEqSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCb4 = this.eqCb4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqR4 = this.eqR4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqR5 = this.eqR5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqR2 = this.eqR2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgEqtype = this.orgEqtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqGnal = this.eqGnal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtDist = this.trspAgmtDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOal = this.eqOal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distMeasUtCd = this.distMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqZt4 = this.eqZt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqS2 = this.eqS2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqS4 = this.eqS4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSlal = this.eqSlal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtSeq = this.trspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtMeasUtCd = this.wgtMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqA5 = this.eqA5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqEg5 = this.eqEg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqA2 = this.eqA2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRoutAllFlg = this.agmtRoutAllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqA4 = this.eqA4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtOfcCtyCd = this.trspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqEg8 = this.eqEg8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTaal = this.eqTaal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrIndCd = this.custNomiTrkrIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqP4 = this.eqP4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqP2 = this.eqP2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrRcvTermCd = this.wtrRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRvsAplyFlg = this.trspRvsAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqFal = this.eqFal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostModCd = this.trspCostModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodYd = this.fmNodYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqEgal = this.eqEgal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSl2 = this.eqSl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodYd = this.dorNodYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiSeqno = this.uiSeqno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDal = this.eqDal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDistTpCd = this.trspDistTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
