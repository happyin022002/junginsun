/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SltHirTgtVO.java
*@FileTitle : SltHirTgtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.08.04 민정호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SltHirTgtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SltHirTgtVO> models = new ArrayList<SltHirTgtVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String joOvrBsaTeuQty = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String joAlocEnblFlg = null;
	/* Column Info */
	private String joBsaTeuQty = null;
	/* Column Info */
	private String joOvrOcnPrc = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String joSctrPrcFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fnlStlAmt = null;
	/* Column Info */
	private String joBsaEntrRdrRmk = null;
	/* Column Info */
	private String joStlStsCd = null;
	/* Column Info */
	private String joStlStsCd2 = null;	
	/* Column Info */
	private String joTonTeuQty = null;
	/* Column Info */
	private String joRndRuleLvl = null;
	/* Column Info */
	private String joRdrPortCd = null;
	/* Column Info */
	private String joBsaAddTeuQty = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String joPrcFshFlg = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String joRfInterPrc = null;
	/* Column Info */
	private String joBsaEntrRmk = null;
	/* Column Info */
	private String estmStlAmt = null;
	/* Column Info */
	private String lstLodgPortEtdDt = null;
	/* Column Info */
	private String bsaSltPrc = null;
	/* Column Info */
	private String joRfInterTeuQty = null;
	/* Column Info */
	private String fnlBsaQty = null;
	/* Column Info */
	private String joStlJbCd = null;
	/* Column Info */
	private String joInterOvrFlg = null;
	/* Column Info */
	private String joOvrMtOcnPrc = null;
	/* Column Info */
	private String joRndKndFlg = null;
	/* Column Info */
	private String bsaQty = null;
	/* Column Info */
	private String joRfOcnPrc = null;
	/* Column Info */
	private String joOvrMtInterPrc = null;
	/* Column Info */
	private String jo45ftUndRto = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String jo45ftOvrRto = null;
	/* Column Info */
	private String fnlBsaSltPrc = null;
	/* Column Info */
	private String jo45ftSubTeuQty = null;
	/* Column Info */
	private String joAddBsaCrrFlg = null;
	/* Column Info */
	private String actStlAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String joRfOcnTeuQty = null;
	/* Column Info */
	private String n1stLodgPortEtdDt = null;
	/* Column Info */
	private String joBsaPrc = null;
	/* Column Info */
	private String jo20ftOvrRto = null;
	/* Column Info */
	private String jo40ftOvrRto = null;
	/* Column Info */
	private String lstLodgPortCd = null;
	/* Column Info */
	private String jo40ftSubTeuQty = null;
	/* Column Info */
	private String adjRsltCd = null;
	/* Column Info */
	private String stlVvdSeq = null;
	/* Column Info */
	private String adjRmk = null;
	/* Column Info */
	private String jo20ftSubTeuQty = null;
	/* Column Info */
	private String revPortEtdDt = null;
	/* Column Info */
	private String actBsaQty = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String estmVvdTpCd = null;
	/* Column Info */
	private String joFshFlg = null;
	/* Column Info */
	private String stlClzFlg = null;
	/* Column Info */
	private String joOvrInterPrc = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String joOvrTonWgt = null;
	/* Column Info */
	private String actSltPrc = null;
	/* Column Info */
	private String vndrCust = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String bsaRank = null;
	/* Column Info */
	private String opCrrCd = null;
	/* Column Info */
	private String settleYn = null;
	/* Column Info */
	private String totPageCnt = null;
	/* Column Info */
	private String seqNo = null;
	/* Column Info */
	private String diff = null;	
	/* Column Info */
	private String revDirCd = null;	
	/* Column Info */
	private String revYrmonSeq = null;	
	/* Column Info */
	private String stlAmt = null;	
	/* Column Info */
	private String acctYrmon = null;	
	/* Column Info */
	private String joFshFlg2 = null;	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SltHirTgtVO() {}

	public SltHirTgtVO(String ibflag, String pagerows, String revYrmon, String stlVvdSeq, String trdCd, String crrCd, String rlaneCd, String reDivrCd, String vslCd, String skdVoyNo, String skdDirCd, String estmVvdTpCd, String acctCd, String joStlJbCd, String bsaQty, String bsaSltPrc, String actBsaQty, String actSltPrc, String fnlBsaQty, String fnlBsaSltPrc, String estmStlAmt, String actStlAmt, String fnlStlAmt, String adjRsltCd, String adjRmk, String joStlStsCd, String joStlStsCd2, String n1stLodgPortEtdDt, String lstLodgPortCd, String lstLodgPortEtdDt, String stlClzFlg, String joAlocEnblFlg, String joBsaTeuQty, String joBsaAddTeuQty, String joAddBsaCrrFlg, String joOvrBsaTeuQty, String joTonTeuQty, String joOvrTonWgt, String jo20ftSubTeuQty, String jo20ftOvrRto, String jo40ftSubTeuQty, String jo40ftOvrRto, String jo45ftSubTeuQty, String jo45ftOvrRto, String jo45ftUndRto, String joRfOcnTeuQty, String joRfInterTeuQty, String joRndKndFlg, String joRndRuleLvl, String joInterOvrFlg, String joRdrPortCd, String joFshFlg, String joBsaPrc, String joOvrOcnPrc, String joOvrInterPrc, String joOvrMtOcnPrc, String joOvrMtInterPrc, String joSctrPrcFlg, String joRfOcnPrc, String joRfInterPrc, String joPrcFshFlg, String revPortEtdDt, String joBsaEntrRmk, String joBsaEntrRdrRmk, String deltFlg, String vndrCust, String updUsrId, String bsaRank, String opCrrCd, String settleYn,String totPageCnt, String seqNo, String diff, String revDirCd, String revYrmonSeq, String stlAmt, String acctYrmon, String joFshFlg2) {
		this.vslCd = vslCd;
		this.joOvrBsaTeuQty = joOvrBsaTeuQty;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.joAlocEnblFlg = joAlocEnblFlg;
		this.joBsaTeuQty = joBsaTeuQty;
		this.joOvrOcnPrc = joOvrOcnPrc;
		this.crrCd = crrCd;
		this.joSctrPrcFlg = joSctrPrcFlg;
		this.pagerows = pagerows;
		this.fnlStlAmt = fnlStlAmt;
		this.joBsaEntrRdrRmk = joBsaEntrRdrRmk;
		this.joStlStsCd = joStlStsCd;
		this.joStlStsCd2 = joStlStsCd2;		
		this.joTonTeuQty = joTonTeuQty;
		this.joRndRuleLvl = joRndRuleLvl;
		this.joRdrPortCd = joRdrPortCd;
		this.joBsaAddTeuQty = joBsaAddTeuQty;
		this.revYrmon = revYrmon;
		this.joPrcFshFlg = joPrcFshFlg;
		this.skdVoyNo = skdVoyNo;
		this.joRfInterPrc = joRfInterPrc;
		this.joBsaEntrRmk = joBsaEntrRmk;
		this.estmStlAmt = estmStlAmt;
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
		this.bsaSltPrc = bsaSltPrc;
		this.joRfInterTeuQty = joRfInterTeuQty;
		this.fnlBsaQty = fnlBsaQty;
		this.joStlJbCd = joStlJbCd;
		this.joInterOvrFlg = joInterOvrFlg;
		this.joOvrMtOcnPrc = joOvrMtOcnPrc;
		this.joRndKndFlg = joRndKndFlg;
		this.bsaQty = bsaQty;
		this.joRfOcnPrc = joRfOcnPrc;
		this.joOvrMtInterPrc = joOvrMtInterPrc;
		this.jo45ftUndRto = jo45ftUndRto;
		this.deltFlg = deltFlg;
		this.jo45ftOvrRto = jo45ftOvrRto;
		this.fnlBsaSltPrc = fnlBsaSltPrc;
		this.jo45ftSubTeuQty = jo45ftSubTeuQty;
		this.joAddBsaCrrFlg = joAddBsaCrrFlg;
		this.actStlAmt = actStlAmt;
		this.ibflag = ibflag;
		this.acctCd = acctCd;
		this.joRfOcnTeuQty = joRfOcnTeuQty;
		this.n1stLodgPortEtdDt = n1stLodgPortEtdDt;
		this.joBsaPrc = joBsaPrc;
		this.jo20ftOvrRto = jo20ftOvrRto;
		this.jo40ftOvrRto = jo40ftOvrRto;
		this.lstLodgPortCd = lstLodgPortCd;
		this.jo40ftSubTeuQty = jo40ftSubTeuQty;
		this.adjRsltCd = adjRsltCd;
		this.stlVvdSeq = stlVvdSeq;
		this.adjRmk = adjRmk;
		this.jo20ftSubTeuQty = jo20ftSubTeuQty;
		this.revPortEtdDt = revPortEtdDt;
		this.actBsaQty = actBsaQty;
		this.skdDirCd = skdDirCd;
		this.estmVvdTpCd = estmVvdTpCd;
		this.joFshFlg = joFshFlg;
		this.stlClzFlg = stlClzFlg;
		this.joOvrInterPrc = joOvrInterPrc;
		this.reDivrCd = reDivrCd;
		this.joOvrTonWgt = joOvrTonWgt;
		this.actSltPrc = actSltPrc;
		this.vndrCust = vndrCust;
		this.updUsrId = updUsrId;					
		this.bsaRank = bsaRank;
		this.opCrrCd = opCrrCd;		
		this.settleYn = settleYn;
		this.totPageCnt = totPageCnt;
		this.seqNo = seqNo;
		this.diff = diff;
		this.revDirCd = revDirCd;
		this.revYrmonSeq = revYrmonSeq;
		this.stlAmt = stlAmt;
		this.acctYrmon = acctYrmon;
		this.joFshFlg2 = joFshFlg2;		
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("jo_ovr_bsa_teu_qty", getJoOvrBsaTeuQty());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("jo_aloc_enbl_flg", getJoAlocEnblFlg());
		this.hashColumns.put("jo_bsa_teu_qty", getJoBsaTeuQty());
		this.hashColumns.put("jo_ovr_ocn_prc", getJoOvrOcnPrc());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("jo_sctr_prc_flg", getJoSctrPrcFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fnl_stl_amt", getFnlStlAmt());
		this.hashColumns.put("jo_bsa_entr_rdr_rmk", getJoBsaEntrRdrRmk());
		this.hashColumns.put("jo_stl_sts_cd", getJoStlStsCd());
		this.hashColumns.put("jo_stl_sts_cd2", getJoStlStsCd2());		
		this.hashColumns.put("jo_ton_teu_qty", getJoTonTeuQty());
		this.hashColumns.put("jo_rnd_rule_lvl", getJoRndRuleLvl());
		this.hashColumns.put("jo_rdr_port_cd", getJoRdrPortCd());
		this.hashColumns.put("jo_bsa_add_teu_qty", getJoBsaAddTeuQty());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("jo_prc_fsh_flg", getJoPrcFshFlg());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("jo_rf_inter_prc", getJoRfInterPrc());
		this.hashColumns.put("jo_bsa_entr_rmk", getJoBsaEntrRmk());
		this.hashColumns.put("estm_stl_amt", getEstmStlAmt());
		this.hashColumns.put("lst_lodg_port_etd_dt", getLstLodgPortEtdDt());
		this.hashColumns.put("bsa_slt_prc", getBsaSltPrc());
		this.hashColumns.put("jo_rf_inter_teu_qty", getJoRfInterTeuQty());
		this.hashColumns.put("fnl_bsa_qty", getFnlBsaQty());
		this.hashColumns.put("jo_stl_jb_cd", getJoStlJbCd());
		this.hashColumns.put("jo_inter_ovr_flg", getJoInterOvrFlg());
		this.hashColumns.put("jo_ovr_mt_ocn_prc", getJoOvrMtOcnPrc());
		this.hashColumns.put("jo_rnd_knd_flg", getJoRndKndFlg());
		this.hashColumns.put("bsa_qty", getBsaQty());
		this.hashColumns.put("jo_rf_ocn_prc", getJoRfOcnPrc());
		this.hashColumns.put("jo_ovr_mt_inter_prc", getJoOvrMtInterPrc());
		this.hashColumns.put("jo_45ft_und_rto", getJo45ftUndRto());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("jo_45ft_ovr_rto", getJo45ftOvrRto());
		this.hashColumns.put("fnl_bsa_slt_prc", getFnlBsaSltPrc());
		this.hashColumns.put("jo_45ft_sub_teu_qty", getJo45ftSubTeuQty());
		this.hashColumns.put("jo_add_bsa_crr_flg", getJoAddBsaCrrFlg());
		this.hashColumns.put("act_stl_amt", getActStlAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("jo_rf_ocn_teu_qty", getJoRfOcnTeuQty());
		this.hashColumns.put("n1st_lodg_port_etd_dt", getN1stLodgPortEtdDt());
		this.hashColumns.put("jo_bsa_prc", getJoBsaPrc());
		this.hashColumns.put("jo_20ft_ovr_rto", getJo20ftOvrRto());
		this.hashColumns.put("jo_40ft_ovr_rto", getJo40ftOvrRto());
		this.hashColumns.put("lst_lodg_port_cd", getLstLodgPortCd());
		this.hashColumns.put("jo_40ft_sub_teu_qty", getJo40ftSubTeuQty());
		this.hashColumns.put("adj_rslt_cd", getAdjRsltCd());
		this.hashColumns.put("stl_vvd_seq", getStlVvdSeq());
		this.hashColumns.put("adj_rmk", getAdjRmk());
		this.hashColumns.put("jo_20ft_sub_teu_qty", getJo20ftSubTeuQty());
		this.hashColumns.put("rev_port_etd_dt", getRevPortEtdDt());
		this.hashColumns.put("act_bsa_qty", getActBsaQty());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("estm_vvd_tp_cd", getEstmVvdTpCd());
		this.hashColumns.put("jo_fsh_flg", getJoFshFlg());
		this.hashColumns.put("stl_clz_flg", getStlClzFlg());
		this.hashColumns.put("jo_ovr_inter_prc", getJoOvrInterPrc());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("jo_ovr_ton_wgt", getJoOvrTonWgt());
		this.hashColumns.put("act_slt_prc", getActSltPrc());
		this.hashColumns.put("vndr_cust", getVndrCust());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("bsa_rank", getBsaRank());		
		this.hashColumns.put("op_crr_cd", getOpCrrCd());		
		this.hashColumns.put("tot_page_cnt", getTotPageCnt());
		this.hashColumns.put("settle_yn", getSettleYn());
		this.hashColumns.put("seq_no", getSeqNo());		
		this.hashColumns.put("diff", getDiff());		
		this.hashColumns.put("rev_dir_cd", getRevDirCd());		
		this.hashColumns.put("rev_yrmon_seq", getRevYrmonSeq());		
		this.hashColumns.put("stl_amt", getStlAmt());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("jo_fsh_flg2", getJoFshFlg2());		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("jo_ovr_bsa_teu_qty", "joOvrBsaTeuQty");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("jo_aloc_enbl_flg", "joAlocEnblFlg");
		this.hashFields.put("jo_bsa_teu_qty", "joBsaTeuQty");
		this.hashFields.put("jo_ovr_ocn_prc", "joOvrOcnPrc");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("jo_sctr_prc_flg", "joSctrPrcFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fnl_stl_amt", "fnlStlAmt");
		this.hashFields.put("jo_bsa_entr_rdr_rmk", "joBsaEntrRdrRmk");
		this.hashFields.put("jo_stl_sts_cd", "joStlStsCd");
		this.hashFields.put("jo_stl_sts_cd2", "joStlStsCd2");		
		this.hashFields.put("jo_ton_teu_qty", "joTonTeuQty");
		this.hashFields.put("jo_rnd_rule_lvl", "joRndRuleLvl");
		this.hashFields.put("jo_rdr_port_cd", "joRdrPortCd");
		this.hashFields.put("jo_bsa_add_teu_qty", "joBsaAddTeuQty");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("jo_prc_fsh_flg", "joPrcFshFlg");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("jo_rf_inter_prc", "joRfInterPrc");
		this.hashFields.put("jo_bsa_entr_rmk", "joBsaEntrRmk");
		this.hashFields.put("estm_stl_amt", "estmStlAmt");
		this.hashFields.put("lst_lodg_port_etd_dt", "lstLodgPortEtdDt");
		this.hashFields.put("bsa_slt_prc", "bsaSltPrc");
		this.hashFields.put("jo_rf_inter_teu_qty", "joRfInterTeuQty");
		this.hashFields.put("fnl_bsa_qty", "fnlBsaQty");
		this.hashFields.put("jo_stl_jb_cd", "joStlJbCd");
		this.hashFields.put("jo_inter_ovr_flg", "joInterOvrFlg");
		this.hashFields.put("jo_ovr_mt_ocn_prc", "joOvrMtOcnPrc");
		this.hashFields.put("jo_rnd_knd_flg", "joRndKndFlg");
		this.hashFields.put("bsa_qty", "bsaQty");
		this.hashFields.put("jo_rf_ocn_prc", "joRfOcnPrc");
		this.hashFields.put("jo_ovr_mt_inter_prc", "joOvrMtInterPrc");
		this.hashFields.put("jo_45ft_und_rto", "jo45ftUndRto");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("jo_45ft_ovr_rto", "jo45ftOvrRto");
		this.hashFields.put("fnl_bsa_slt_prc", "fnlBsaSltPrc");
		this.hashFields.put("jo_45ft_sub_teu_qty", "jo45ftSubTeuQty");
		this.hashFields.put("jo_add_bsa_crr_flg", "joAddBsaCrrFlg");
		this.hashFields.put("act_stl_amt", "actStlAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("jo_rf_ocn_teu_qty", "joRfOcnTeuQty");
		this.hashFields.put("n1st_lodg_port_etd_dt", "n1stLodgPortEtdDt");
		this.hashFields.put("jo_bsa_prc", "joBsaPrc");
		this.hashFields.put("jo_20ft_ovr_rto", "jo20ftOvrRto");
		this.hashFields.put("jo_40ft_ovr_rto", "jo40ftOvrRto");
		this.hashFields.put("lst_lodg_port_cd", "lstLodgPortCd");
		this.hashFields.put("jo_40ft_sub_teu_qty", "jo40ftSubTeuQty");
		this.hashFields.put("adj_rslt_cd", "adjRsltCd");
		this.hashFields.put("stl_vvd_seq", "stlVvdSeq");
		this.hashFields.put("adj_rmk", "adjRmk");
		this.hashFields.put("jo_20ft_sub_teu_qty", "jo20ftSubTeuQty");
		this.hashFields.put("rev_port_etd_dt", "revPortEtdDt");
		this.hashFields.put("act_bsa_qty", "actBsaQty");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("estm_vvd_tp_cd", "estmVvdTpCd");
		this.hashFields.put("jo_fsh_flg", "joFshFlg");
		this.hashFields.put("stl_clz_flg", "stlClzFlg");
		this.hashFields.put("jo_ovr_inter_prc", "joOvrInterPrc");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("jo_ovr_ton_wgt", "joOvrTonWgt");
		this.hashFields.put("act_slt_prc", "actSltPrc");
		this.hashFields.put("vndr_cust", "vndrCust");		
		this.hashFields.put("upd_usr_id", "updUsrId");		
		this.hashFields.put("bsa_rank", "bsaRank");
		this.hashFields.put("op_crr_cd", "opCrrCd");
		this.hashFields.put("settle_yn", "settleYn");
		this.hashFields.put("tot_page_cnt", "totPageCnt");
		this.hashFields.put("seq_no", "seqNo");		
		this.hashFields.put("diff", "diff");
		this.hashFields.put("rev_dir_cd", "revDirCd");		
		this.hashFields.put("rev_yrmon_seq", "revYrmonSeq");	
		this.hashFields.put("stl_amt", "stlAmt");		
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("jo_fsh_flg2", "joFshFlg2");		
				
		return this.hashFields;
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
	 * @return joOvrBsaTeuQty
	 */
	public String getJoOvrBsaTeuQty() {
		return this.joOvrBsaTeuQty;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return joAlocEnblFlg
	 */
	public String getJoAlocEnblFlg() {
		return this.joAlocEnblFlg;
	}
	
	/**
	 * Column Info
	 * @return joBsaTeuQty
	 */
	public String getJoBsaTeuQty() {
		return this.joBsaTeuQty;
	}
	
	/**
	 * Column Info
	 * @return joOvrOcnPrc
	 */
	public String getJoOvrOcnPrc() {
		return this.joOvrOcnPrc;
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
	 * @return joSctrPrcFlg
	 */
	public String getJoSctrPrcFlg() {
		return this.joSctrPrcFlg;
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
	 * @return fnlStlAmt
	 */
	public String getFnlStlAmt() {
		return this.fnlStlAmt;
	}
	
	/**
	 * Column Info
	 * @return joBsaEntrRdrRmk
	 */
	public String getJoBsaEntrRdrRmk() {
		return this.joBsaEntrRdrRmk;
	}
	
	/**
	 * Column Info
	 * @return joStlStsCd
	 */
	public String getJoStlStsCd() {
		return this.joStlStsCd;
	}

	/**
	 * Column Info
	 * @return joStlStsCd2
	 */
	public String getJoStlStsCd2() {
		return this.joStlStsCd2;
	}
	
	/**
	 * Column Info
	 * @return joTonTeuQty
	 */
	public String getJoTonTeuQty() {
		return this.joTonTeuQty;
	}
	
	/**
	 * Column Info
	 * @return joRndRuleLvl
	 */
	public String getJoRndRuleLvl() {
		return this.joRndRuleLvl;
	}
	
	/**
	 * Column Info
	 * @return joRdrPortCd
	 */
	public String getJoRdrPortCd() {
		return this.joRdrPortCd;
	}
	
	/**
	 * Column Info
	 * @return joBsaAddTeuQty
	 */
	public String getJoBsaAddTeuQty() {
		return this.joBsaAddTeuQty;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return joPrcFshFlg
	 */
	public String getJoPrcFshFlg() {
		return this.joPrcFshFlg;
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
	 * @return joRfInterPrc
	 */
	public String getJoRfInterPrc() {
		return this.joRfInterPrc;
	}
	
	/**
	 * Column Info
	 * @return joBsaEntrRmk
	 */
	public String getJoBsaEntrRmk() {
		return this.joBsaEntrRmk;
	}
	
	/**
	 * Column Info
	 * @return estmStlAmt
	 */
	public String getEstmStlAmt() {
		return this.estmStlAmt;
	}
	
	/**
	 * Column Info
	 * @return lstLodgPortEtdDt
	 */
	public String getLstLodgPortEtdDt() {
		return this.lstLodgPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return bsaSltPrc
	 */
	public String getBsaSltPrc() {
		return this.bsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return joRfInterTeuQty
	 */
	public String getJoRfInterTeuQty() {
		return this.joRfInterTeuQty;
	}
	
	/**
	 * Column Info
	 * @return fnlBsaQty
	 */
	public String getFnlBsaQty() {
		return this.fnlBsaQty;
	}
	
	/**
	 * Column Info
	 * @return joStlJbCd
	 */
	public String getJoStlJbCd() {
		return this.joStlJbCd;
	}
	
	/**
	 * Column Info
	 * @return joInterOvrFlg
	 */
	public String getJoInterOvrFlg() {
		return this.joInterOvrFlg;
	}
	
	/**
	 * Column Info
	 * @return joOvrMtOcnPrc
	 */
	public String getJoOvrMtOcnPrc() {
		return this.joOvrMtOcnPrc;
	}
	
	/**
	 * Column Info
	 * @return joRndKndFlg
	 */
	public String getJoRndKndFlg() {
		return this.joRndKndFlg;
	}
	
	/**
	 * Column Info
	 * @return bsaQty
	 */
	public String getBsaQty() {
		return this.bsaQty;
	}
	
	/**
	 * Column Info
	 * @return joRfOcnPrc
	 */
	public String getJoRfOcnPrc() {
		return this.joRfOcnPrc;
	}
	
	/**
	 * Column Info
	 * @return joOvrMtInterPrc
	 */
	public String getJoOvrMtInterPrc() {
		return this.joOvrMtInterPrc;
	}
	
	/**
	 * Column Info
	 * @return jo45ftUndRto
	 */
	public String getJo45ftUndRto() {
		return this.jo45ftUndRto;
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
	 * @return jo45ftOvrRto
	 */
	public String getJo45ftOvrRto() {
		return this.jo45ftOvrRto;
	}
	
	/**
	 * Column Info
	 * @return fnlBsaSltPrc
	 */
	public String getFnlBsaSltPrc() {
		return this.fnlBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return jo45ftSubTeuQty
	 */
	public String getJo45ftSubTeuQty() {
		return this.jo45ftSubTeuQty;
	}
	
	/**
	 * Column Info
	 * @return joAddBsaCrrFlg
	 */
	public String getJoAddBsaCrrFlg() {
		return this.joAddBsaCrrFlg;
	}
	
	/**
	 * Column Info
	 * @return actStlAmt
	 */
	public String getActStlAmt() {
		return this.actStlAmt;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return joRfOcnTeuQty
	 */
	public String getJoRfOcnTeuQty() {
		return this.joRfOcnTeuQty;
	}
	
	/**
	 * Column Info
	 * @return n1stLodgPortEtdDt
	 */
	public String getN1stLodgPortEtdDt() {
		return this.n1stLodgPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return joBsaPrc
	 */
	public String getJoBsaPrc() {
		return this.joBsaPrc;
	}
	
	/**
	 * Column Info
	 * @return jo20ftOvrRto
	 */
	public String getJo20ftOvrRto() {
		return this.jo20ftOvrRto;
	}
	
	/**
	 * Column Info
	 * @return jo40ftOvrRto
	 */
	public String getJo40ftOvrRto() {
		return this.jo40ftOvrRto;
	}
	
	/**
	 * Column Info
	 * @return lstLodgPortCd
	 */
	public String getLstLodgPortCd() {
		return this.lstLodgPortCd;
	}
	
	/**
	 * Column Info
	 * @return jo40ftSubTeuQty
	 */
	public String getJo40ftSubTeuQty() {
		return this.jo40ftSubTeuQty;
	}
	
	/**
	 * Column Info
	 * @return adjRsltCd
	 */
	public String getAdjRsltCd() {
		return this.adjRsltCd;
	}
	
	/**
	 * Column Info
	 * @return stlVvdSeq
	 */
	public String getStlVvdSeq() {
		return this.stlVvdSeq;
	}
	
	/**
	 * Column Info
	 * @return adjRmk
	 */
	public String getAdjRmk() {
		return this.adjRmk;
	}
	
	/**
	 * Column Info
	 * @return jo20ftSubTeuQty
	 */
	public String getJo20ftSubTeuQty() {
		return this.jo20ftSubTeuQty;
	}
	
	/**
	 * Column Info
	 * @return revPortEtdDt
	 */
	public String getRevPortEtdDt() {
		return this.revPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return actBsaQty
	 */
	public String getActBsaQty() {
		return this.actBsaQty;
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
	 * @return estmVvdTpCd
	 */
	public String getEstmVvdTpCd() {
		return this.estmVvdTpCd;
	}
	
	/**
	 * Column Info
	 * @return joFshFlg
	 */
	public String getJoFshFlg() {
		return this.joFshFlg;
	}
	
	/**
	 * Column Info
	 * @return stlClzFlg
	 */
	public String getStlClzFlg() {
		return this.stlClzFlg;
	}
	
	/**
	 * Column Info
	 * @return joOvrInterPrc
	 */
	public String getJoOvrInterPrc() {
		return this.joOvrInterPrc;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return joOvrTonWgt
	 */
	public String getJoOvrTonWgt() {
		return this.joOvrTonWgt;
	}
	
	/**
	 * Column Info
	 * @return actSltPrc
	 */
	public String getActSltPrc() {
		return this.actSltPrc;
	}

	/**
	 * Column Info
	 * @return vndrCust
	 */
	public String getVndrCust() {
		return this.vndrCust;
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
	 * @return bsaRank
	 */
	public String getBsaRank() {
		return this.bsaRank;
	}		

	/**
	 * Column Info
	 * @return opCrrCd
	 */
	public String getOpCrrCd() {
		return this.opCrrCd;
	}
	
	/**
	 * Column Info
	 * @return settleYn
	 */
	public String getSettleYn() {
		return this.settleYn;
	}		

	/**
	 * Column Info
	 * @return totPageCnt
	 */
	public String getTotPageCnt() {
		return this.totPageCnt;
	}		
	
	/**
	 * Column Info
	 * @return seqNo
	 */
	public String getSeqNo() {
		return this.seqNo;
	}	

	/**
	 * Column Info
	 * @return diff
	 */
	public String getDiff() {
		return this.diff;
	}	

	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
	}	
	
	/**
	 * Column Info
	 * @return revYrmonSeq
	 */
	public String getRevYrmonSeq() {
		return this.revYrmonSeq;
	}		

	/**
	 * Column Info
	 * @return stlAmt
	 */
	public String getStlAmt() {
		return this.stlAmt;
	}		

	/**
	 * Column Info
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
	}		

	/**
	 * Column Info
	 * @return joFshFlg2
	 */
	public String getJoFshFlg2() {
		return this.joFshFlg2;
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
	 * @param joOvrBsaTeuQty
	 */
	public void setJoOvrBsaTeuQty(String joOvrBsaTeuQty) {
		this.joOvrBsaTeuQty = joOvrBsaTeuQty;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param joAlocEnblFlg
	 */
	public void setJoAlocEnblFlg(String joAlocEnblFlg) {
		this.joAlocEnblFlg = joAlocEnblFlg;
	}
	
	/**
	 * Column Info
	 * @param joBsaTeuQty
	 */
	public void setJoBsaTeuQty(String joBsaTeuQty) {
		this.joBsaTeuQty = joBsaTeuQty;
	}
	
	/**
	 * Column Info
	 * @param joOvrOcnPrc
	 */
	public void setJoOvrOcnPrc(String joOvrOcnPrc) {
		this.joOvrOcnPrc = joOvrOcnPrc;
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
	 * @param joSctrPrcFlg
	 */
	public void setJoSctrPrcFlg(String joSctrPrcFlg) {
		this.joSctrPrcFlg = joSctrPrcFlg;
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
	 * @param fnlStlAmt
	 */
	public void setFnlStlAmt(String fnlStlAmt) {
		this.fnlStlAmt = fnlStlAmt;
	}
	
	/**
	 * Column Info
	 * @param joBsaEntrRdrRmk
	 */
	public void setJoBsaEntrRdrRmk(String joBsaEntrRdrRmk) {
		this.joBsaEntrRdrRmk = joBsaEntrRdrRmk;
	}
	
	/**
	 * Column Info
	 * @param joStlStsCd
	 */
	public void setJoStlStsCd(String joStlStsCd) {
		this.joStlStsCd = joStlStsCd;
	}
	
	/**
	 * Column Info
	 * @param joStlStsCd2
	 */
	public void setJoStlStsCd2(String joStlStsCd2) {
		this.joStlStsCd2 = joStlStsCd2;
	}
	
	/**
	 * Column Info
	 * @param joTonTeuQty
	 */
	public void setJoTonTeuQty(String joTonTeuQty) {
		this.joTonTeuQty = joTonTeuQty;
	}
	
	/**
	 * Column Info
	 * @param joRndRuleLvl
	 */
	public void setJoRndRuleLvl(String joRndRuleLvl) {
		this.joRndRuleLvl = joRndRuleLvl;
	}
	
	/**
	 * Column Info
	 * @param joRdrPortCd
	 */
	public void setJoRdrPortCd(String joRdrPortCd) {
		this.joRdrPortCd = joRdrPortCd;
	}
	
	/**
	 * Column Info
	 * @param joBsaAddTeuQty
	 */
	public void setJoBsaAddTeuQty(String joBsaAddTeuQty) {
		this.joBsaAddTeuQty = joBsaAddTeuQty;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param joPrcFshFlg
	 */
	public void setJoPrcFshFlg(String joPrcFshFlg) {
		this.joPrcFshFlg = joPrcFshFlg;
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
	 * @param joRfInterPrc
	 */
	public void setJoRfInterPrc(String joRfInterPrc) {
		this.joRfInterPrc = joRfInterPrc;
	}
	
	/**
	 * Column Info
	 * @param joBsaEntrRmk
	 */
	public void setJoBsaEntrRmk(String joBsaEntrRmk) {
		this.joBsaEntrRmk = joBsaEntrRmk;
	}
	
	/**
	 * Column Info
	 * @param estmStlAmt
	 */
	public void setEstmStlAmt(String estmStlAmt) {
		this.estmStlAmt = estmStlAmt;
	}
	
	/**
	 * Column Info
	 * @param lstLodgPortEtdDt
	 */
	public void setLstLodgPortEtdDt(String lstLodgPortEtdDt) {
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param bsaSltPrc
	 */
	public void setBsaSltPrc(String bsaSltPrc) {
		this.bsaSltPrc = bsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param joRfInterTeuQty
	 */
	public void setJoRfInterTeuQty(String joRfInterTeuQty) {
		this.joRfInterTeuQty = joRfInterTeuQty;
	}
	
	/**
	 * Column Info
	 * @param fnlBsaQty
	 */
	public void setFnlBsaQty(String fnlBsaQty) {
		this.fnlBsaQty = fnlBsaQty;
	}
	
	/**
	 * Column Info
	 * @param joStlJbCd
	 */
	public void setJoStlJbCd(String joStlJbCd) {
		this.joStlJbCd = joStlJbCd;
	}
	
	/**
	 * Column Info
	 * @param joInterOvrFlg
	 */
	public void setJoInterOvrFlg(String joInterOvrFlg) {
		this.joInterOvrFlg = joInterOvrFlg;
	}
	
	/**
	 * Column Info
	 * @param joOvrMtOcnPrc
	 */
	public void setJoOvrMtOcnPrc(String joOvrMtOcnPrc) {
		this.joOvrMtOcnPrc = joOvrMtOcnPrc;
	}
	
	/**
	 * Column Info
	 * @param joRndKndFlg
	 */
	public void setJoRndKndFlg(String joRndKndFlg) {
		this.joRndKndFlg = joRndKndFlg;
	}
	
	/**
	 * Column Info
	 * @param bsaQty
	 */
	public void setBsaQty(String bsaQty) {
		this.bsaQty = bsaQty;
	}
	
	/**
	 * Column Info
	 * @param joRfOcnPrc
	 */
	public void setJoRfOcnPrc(String joRfOcnPrc) {
		this.joRfOcnPrc = joRfOcnPrc;
	}
	
	/**
	 * Column Info
	 * @param joOvrMtInterPrc
	 */
	public void setJoOvrMtInterPrc(String joOvrMtInterPrc) {
		this.joOvrMtInterPrc = joOvrMtInterPrc;
	}
	
	/**
	 * Column Info
	 * @param jo45ftUndRto
	 */
	public void setJo45ftUndRto(String jo45ftUndRto) {
		this.jo45ftUndRto = jo45ftUndRto;
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
	 * @param jo45ftOvrRto
	 */
	public void setJo45ftOvrRto(String jo45ftOvrRto) {
		this.jo45ftOvrRto = jo45ftOvrRto;
	}
	
	/**
	 * Column Info
	 * @param fnlBsaSltPrc
	 */
	public void setFnlBsaSltPrc(String fnlBsaSltPrc) {
		this.fnlBsaSltPrc = fnlBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param jo45ftSubTeuQty
	 */
	public void setJo45ftSubTeuQty(String jo45ftSubTeuQty) {
		this.jo45ftSubTeuQty = jo45ftSubTeuQty;
	}
	
	/**
	 * Column Info
	 * @param joAddBsaCrrFlg
	 */
	public void setJoAddBsaCrrFlg(String joAddBsaCrrFlg) {
		this.joAddBsaCrrFlg = joAddBsaCrrFlg;
	}
	
	/**
	 * Column Info
	 * @param actStlAmt
	 */
	public void setActStlAmt(String actStlAmt) {
		this.actStlAmt = actStlAmt;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param joRfOcnTeuQty
	 */
	public void setJoRfOcnTeuQty(String joRfOcnTeuQty) {
		this.joRfOcnTeuQty = joRfOcnTeuQty;
	}
	
	/**
	 * Column Info
	 * @param n1stLodgPortEtdDt
	 */
	public void setN1stLodgPortEtdDt(String n1stLodgPortEtdDt) {
		this.n1stLodgPortEtdDt = n1stLodgPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param joBsaPrc
	 */
	public void setJoBsaPrc(String joBsaPrc) {
		this.joBsaPrc = joBsaPrc;
	}
	
	/**
	 * Column Info
	 * @param jo20ftOvrRto
	 */
	public void setJo20ftOvrRto(String jo20ftOvrRto) {
		this.jo20ftOvrRto = jo20ftOvrRto;
	}
	
	/**
	 * Column Info
	 * @param jo40ftOvrRto
	 */
	public void setJo40ftOvrRto(String jo40ftOvrRto) {
		this.jo40ftOvrRto = jo40ftOvrRto;
	}
	
	/**
	 * Column Info
	 * @param lstLodgPortCd
	 */
	public void setLstLodgPortCd(String lstLodgPortCd) {
		this.lstLodgPortCd = lstLodgPortCd;
	}
	
	/**
	 * Column Info
	 * @param jo40ftSubTeuQty
	 */
	public void setJo40ftSubTeuQty(String jo40ftSubTeuQty) {
		this.jo40ftSubTeuQty = jo40ftSubTeuQty;
	}
	
	/**
	 * Column Info
	 * @param adjRsltCd
	 */
	public void setAdjRsltCd(String adjRsltCd) {
		this.adjRsltCd = adjRsltCd;
	}
	
	/**
	 * Column Info
	 * @param stlVvdSeq
	 */
	public void setStlVvdSeq(String stlVvdSeq) {
		this.stlVvdSeq = stlVvdSeq;
	}
	
	/**
	 * Column Info
	 * @param adjRmk
	 */
	public void setAdjRmk(String adjRmk) {
		this.adjRmk = adjRmk;
	}
	
	/**
	 * Column Info
	 * @param jo20ftSubTeuQty
	 */
	public void setJo20ftSubTeuQty(String jo20ftSubTeuQty) {
		this.jo20ftSubTeuQty = jo20ftSubTeuQty;
	}
	
	/**
	 * Column Info
	 * @param revPortEtdDt
	 */
	public void setRevPortEtdDt(String revPortEtdDt) {
		this.revPortEtdDt = revPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param actBsaQty
	 */
	public void setActBsaQty(String actBsaQty) {
		this.actBsaQty = actBsaQty;
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
	 * @param estmVvdTpCd
	 */
	public void setEstmVvdTpCd(String estmVvdTpCd) {
		this.estmVvdTpCd = estmVvdTpCd;
	}
	
	/**
	 * Column Info
	 * @param joFshFlg
	 */
	public void setJoFshFlg(String joFshFlg) {
		this.joFshFlg = joFshFlg;
	}
	
	/**
	 * Column Info
	 * @param stlClzFlg
	 */
	public void setStlClzFlg(String stlClzFlg) {
		this.stlClzFlg = stlClzFlg;
	}
	
	/**
	 * Column Info
	 * @param joOvrInterPrc
	 */
	public void setJoOvrInterPrc(String joOvrInterPrc) {
		this.joOvrInterPrc = joOvrInterPrc;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param joOvrTonWgt
	 */
	public void setJoOvrTonWgt(String joOvrTonWgt) {
		this.joOvrTonWgt = joOvrTonWgt;
	}
	
	/**
	 * Column Info
	 * @param actSltPrc
	 */
	public void setActSltPrc(String actSltPrc) {
		this.actSltPrc = actSltPrc;
	}

	/**
	 * Column Info
	 * @param vndrCust
	 */
	public void setVndrCust(String vndrCust) {
		this.vndrCust = vndrCust;
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
	 * @param bsaRank
	 */
	public void setBsaRank(String bsaRank) {
		this.bsaRank = bsaRank;
	}	
	
	/**
	 * Column Info
	 * @param opCrrCd
	 */
	public void setOpCrrCd(String opCrrCd) {
		this.opCrrCd = opCrrCd;
	}		

	/**
	 * Column Info
	 * @param settleYn
	 */
	public void setSettleYn(String settleYn) {
		this.settleYn = settleYn;
	}	
	
	/**
	 * Column Info
	 * @param totPageCnt
	 */
	public void setTotPageCnt(String totPageCnt) {
		this.totPageCnt = totPageCnt;
	}		
	
	/**
	 * Column Info
	 * @param seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}		
	
	/**
	 * Column Info
	 * @param diff
	 */
	public void setDiff(String diff) {
		this.diff = diff;
	}		

	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
	}		

	/**
	 * Column Info
	 * @param revYrmonSeq
	 */
	public void setRevYrmonSeq(String revYrmonSeq) {
		this.revYrmonSeq = revYrmonSeq;
	}		

	/**
	 * Column Info
	 * @param stlAmt
	 */
	public void setStlAmt(String stlAmt) {
		this.stlAmt = stlAmt;
	}		

	/**
	 * Column Info
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
	}		

	/**
	 * Column Info
	 * @param joFshFlg2
	 */
	public void setJoFshFlg2(String joFshFlg2) {
		this.joFshFlg2 = joFshFlg2;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setJoOvrBsaTeuQty(JSPUtil.getParameter(request, prefix + "jo_ovr_bsa_teu_qty", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setJoAlocEnblFlg(JSPUtil.getParameter(request, prefix + "jo_aloc_enbl_flg", ""));
		setJoBsaTeuQty(JSPUtil.getParameter(request, prefix + "jo_bsa_teu_qty", ""));
		setJoOvrOcnPrc(JSPUtil.getParameter(request, prefix + "jo_ovr_ocn_prc", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setJoSctrPrcFlg(JSPUtil.getParameter(request, prefix + "jo_sctr_prc_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFnlStlAmt(JSPUtil.getParameter(request, prefix + "fnl_stl_amt", ""));
		setJoBsaEntrRdrRmk(JSPUtil.getParameter(request, prefix + "jo_bsa_entr_rdr_rmk", ""));
		setJoStlStsCd(JSPUtil.getParameter(request, prefix + "jo_stl_sts_cd", ""));
		setJoStlStsCd2(JSPUtil.getParameter(request, prefix + "jo_stl_sts_cd2", ""));		
		setJoTonTeuQty(JSPUtil.getParameter(request, prefix + "jo_ton_teu_qty", ""));
		setJoRndRuleLvl(JSPUtil.getParameter(request, prefix + "jo_rnd_rule_lvl", ""));
		setJoRdrPortCd(JSPUtil.getParameter(request, prefix + "jo_rdr_port_cd", ""));
		setJoBsaAddTeuQty(JSPUtil.getParameter(request, prefix + "jo_bsa_add_teu_qty", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setJoPrcFshFlg(JSPUtil.getParameter(request, prefix + "jo_prc_fsh_flg", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setJoRfInterPrc(JSPUtil.getParameter(request, prefix + "jo_rf_inter_prc", ""));
		setJoBsaEntrRmk(JSPUtil.getParameter(request, prefix + "jo_bsa_entr_rmk", ""));
		setEstmStlAmt(JSPUtil.getParameter(request, prefix + "estm_stl_amt", ""));
		setLstLodgPortEtdDt(JSPUtil.getParameter(request, prefix + "lst_lodg_port_etd_dt", ""));
		setBsaSltPrc(JSPUtil.getParameter(request, prefix + "bsa_slt_prc", ""));
		setJoRfInterTeuQty(JSPUtil.getParameter(request, prefix + "jo_rf_inter_teu_qty", ""));
		setFnlBsaQty(JSPUtil.getParameter(request, prefix + "fnl_bsa_qty", ""));
		setJoStlJbCd(JSPUtil.getParameter(request, prefix + "jo_stl_jb_cd", ""));
		setJoInterOvrFlg(JSPUtil.getParameter(request, prefix + "jo_inter_ovr_flg", ""));
		setJoOvrMtOcnPrc(JSPUtil.getParameter(request, prefix + "jo_ovr_mt_ocn_prc", ""));
		setJoRndKndFlg(JSPUtil.getParameter(request, prefix + "jo_rnd_knd_flg", ""));
		setBsaQty(JSPUtil.getParameter(request, prefix + "bsa_qty", ""));
		setJoRfOcnPrc(JSPUtil.getParameter(request, prefix + "jo_rf_ocn_prc", ""));
		setJoOvrMtInterPrc(JSPUtil.getParameter(request, prefix + "jo_ovr_mt_inter_prc", ""));
		setJo45ftUndRto(JSPUtil.getParameter(request, prefix + "jo_45ft_und_rto", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setJo45ftOvrRto(JSPUtil.getParameter(request, prefix + "jo_45ft_ovr_rto", ""));
		setFnlBsaSltPrc(JSPUtil.getParameter(request, prefix + "fnl_bsa_slt_prc", ""));
		setJo45ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_45ft_sub_teu_qty", ""));
		setJoAddBsaCrrFlg(JSPUtil.getParameter(request, prefix + "jo_add_bsa_crr_flg", ""));
		setActStlAmt(JSPUtil.getParameter(request, prefix + "act_stl_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setJoRfOcnTeuQty(JSPUtil.getParameter(request, prefix + "jo_rf_ocn_teu_qty", ""));
		setN1stLodgPortEtdDt(JSPUtil.getParameter(request, prefix + "n1st_lodg_port_etd_dt", ""));
		setJoBsaPrc(JSPUtil.getParameter(request, prefix + "jo_bsa_prc", ""));
		setJo20ftOvrRto(JSPUtil.getParameter(request, prefix + "jo_20ft_ovr_rto", ""));
		setJo40ftOvrRto(JSPUtil.getParameter(request, prefix + "jo_40ft_ovr_rto", ""));
		setLstLodgPortCd(JSPUtil.getParameter(request, prefix + "lst_lodg_port_cd", ""));
		setJo40ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_40ft_sub_teu_qty", ""));
		setAdjRsltCd(JSPUtil.getParameter(request, prefix + "adj_rslt_cd", ""));
		setStlVvdSeq(JSPUtil.getParameter(request, prefix + "stl_vvd_seq", ""));
		setAdjRmk(JSPUtil.getParameter(request, prefix + "adj_rmk", ""));
		setJo20ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_20ft_sub_teu_qty", ""));
		setRevPortEtdDt(JSPUtil.getParameter(request, prefix + "rev_port_etd_dt", ""));
		setActBsaQty(JSPUtil.getParameter(request, prefix + "act_bsa_qty", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setEstmVvdTpCd(JSPUtil.getParameter(request, prefix + "estm_vvd_tp_cd", ""));
		setJoFshFlg(JSPUtil.getParameter(request, prefix + "jo_fsh_flg", ""));
		setStlClzFlg(JSPUtil.getParameter(request, prefix + "stl_clz_flg", ""));
		setJoOvrInterPrc(JSPUtil.getParameter(request, prefix + "jo_ovr_inter_prc", ""));
		setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
		setJoOvrTonWgt(JSPUtil.getParameter(request, prefix + "jo_ovr_ton_wgt", ""));
		setActSltPrc(JSPUtil.getParameter(request, prefix + "act_slt_prc", ""));
		setVndrCust(JSPUtil.getParameter(request, prefix + "vndr_cust", ""));		
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));		
		setBsaRank(JSPUtil.getParameter(request, prefix + "bsa_rank", ""));		
		setOpCrrCd(JSPUtil.getParameter(request, prefix + "op_crr_cd", ""));		
		setSettleYn(JSPUtil.getParameter(request, prefix + "settle_yn", ""));
		setTotPageCnt(JSPUtil.getParameter(request, prefix + "tot_page_cnt", ""));		
		setSeqNo(JSPUtil.getParameter(request, prefix + "seq_no", ""));		
		setDiff(JSPUtil.getParameter(request, prefix + "diff", ""));		
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));		
		setRevYrmonSeq(JSPUtil.getParameter(request, prefix + "rev_yrmon_seq", ""));		
		setStlAmt(JSPUtil.getParameter(request, prefix + "stl_amt", ""));		
		setAcctYrmon(JSPUtil.getParameter(request, prefix + "acct_yrmon", ""));		
		setJoFshFlg2(JSPUtil.getParameter(request, prefix + "jo_fsh_flg2", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SltHirTgtVO[]
	 */
	public SltHirTgtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SltHirTgtVO[]
	 */
	public SltHirTgtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SltHirTgtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] joOvrBsaTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_ovr_bsa_teu_qty", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] joAlocEnblFlg = (JSPUtil.getParameter(request, prefix	+ "jo_aloc_enbl_flg", length));
			String[] joBsaTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_teu_qty", length));
			String[] joOvrOcnPrc = (JSPUtil.getParameter(request, prefix	+ "jo_ovr_ocn_prc", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] joSctrPrcFlg = (JSPUtil.getParameter(request, prefix	+ "jo_sctr_prc_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fnlStlAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_stl_amt", length));
			String[] joBsaEntrRdrRmk = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_entr_rdr_rmk", length));
			String[] joStlStsCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_sts_cd", length));
			String[] joStlStsCd2 = (JSPUtil.getParameter(request, prefix	+ "jo_stl_sts_cd2", length));			
			String[] joTonTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_ton_teu_qty", length));
			String[] joRndRuleLvl = (JSPUtil.getParameter(request, prefix	+ "jo_rnd_rule_lvl", length));
			String[] joRdrPortCd = (JSPUtil.getParameter(request, prefix	+ "jo_rdr_port_cd", length));
			String[] joBsaAddTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_add_teu_qty", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] joPrcFshFlg = (JSPUtil.getParameter(request, prefix	+ "jo_prc_fsh_flg", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] joRfInterPrc = (JSPUtil.getParameter(request, prefix	+ "jo_rf_inter_prc", length));
			String[] joBsaEntrRmk = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_entr_rmk", length));
			String[] estmStlAmt = (JSPUtil.getParameter(request, prefix	+ "estm_stl_amt", length));
			String[] lstLodgPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_etd_dt", length));
			String[] bsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "bsa_slt_prc", length));
			String[] joRfInterTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_rf_inter_teu_qty", length));
			String[] fnlBsaQty = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_qty", length));
			String[] joStlJbCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_jb_cd", length));
			String[] joInterOvrFlg = (JSPUtil.getParameter(request, prefix	+ "jo_inter_ovr_flg", length));
			String[] joOvrMtOcnPrc = (JSPUtil.getParameter(request, prefix	+ "jo_ovr_mt_ocn_prc", length));
			String[] joRndKndFlg = (JSPUtil.getParameter(request, prefix	+ "jo_rnd_knd_flg", length));
			String[] bsaQty = (JSPUtil.getParameter(request, prefix	+ "bsa_qty", length));
			String[] joRfOcnPrc = (JSPUtil.getParameter(request, prefix	+ "jo_rf_ocn_prc", length));
			String[] joOvrMtInterPrc = (JSPUtil.getParameter(request, prefix	+ "jo_ovr_mt_inter_prc", length));
			String[] jo45ftUndRto = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_und_rto", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] jo45ftOvrRto = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_ovr_rto", length));
			String[] fnlBsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_slt_prc", length));
			String[] jo45ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_sub_teu_qty", length));
			String[] joAddBsaCrrFlg = (JSPUtil.getParameter(request, prefix	+ "jo_add_bsa_crr_flg", length));
			String[] actStlAmt = (JSPUtil.getParameter(request, prefix	+ "act_stl_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] joRfOcnTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_rf_ocn_teu_qty", length));
			String[] n1stLodgPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "n1st_lodg_port_etd_dt", length));
			String[] joBsaPrc = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_prc", length));
			String[] jo20ftOvrRto = (JSPUtil.getParameter(request, prefix	+ "jo_20ft_ovr_rto", length));
			String[] jo40ftOvrRto = (JSPUtil.getParameter(request, prefix	+ "jo_40ft_ovr_rto", length));
			String[] lstLodgPortCd = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_cd", length));
			String[] jo40ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_40ft_sub_teu_qty", length));
			String[] adjRsltCd = (JSPUtil.getParameter(request, prefix	+ "adj_rslt_cd", length));
			String[] stlVvdSeq = (JSPUtil.getParameter(request, prefix	+ "stl_vvd_seq", length));
			String[] adjRmk = (JSPUtil.getParameter(request, prefix	+ "adj_rmk", length));
			String[] jo20ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_20ft_sub_teu_qty", length));
			String[] revPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "rev_port_etd_dt", length));
			String[] actBsaQty = (JSPUtil.getParameter(request, prefix	+ "act_bsa_qty", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] estmVvdTpCd = (JSPUtil.getParameter(request, prefix	+ "estm_vvd_tp_cd", length));
			String[] joFshFlg = (JSPUtil.getParameter(request, prefix	+ "jo_fsh_flg", length));
			String[] stlClzFlg = (JSPUtil.getParameter(request, prefix	+ "stl_clz_flg", length));
			String[] joOvrInterPrc = (JSPUtil.getParameter(request, prefix	+ "jo_ovr_inter_prc", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] joOvrTonWgt = (JSPUtil.getParameter(request, prefix	+ "jo_ovr_ton_wgt", length));
			String[] actSltPrc = (JSPUtil.getParameter(request, prefix	+ "act_slt_prc", length));
			String[] vndrCust = (JSPUtil.getParameter(request, prefix	+ "vndr_cust", length));			
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));			
			String[] bsaRank = (JSPUtil.getParameter(request, prefix	+ "bsa_rank", length));		
			String[] opCrrCd = (JSPUtil.getParameter(request, prefix	+ "op_crr_cd", length));			
			String[] totPageCnt = (JSPUtil.getParameter(request, prefix	+ "tot_page_cnt", length));
			String[] settleYn = (JSPUtil.getParameter(request, prefix	+ "settle_yn", length));			
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));			
			String[] diff = (JSPUtil.getParameter(request, prefix	+ "diff", length));		
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));			
			String[] revYrmonSeq = (JSPUtil.getParameter(request, prefix	+ "stl_vvd_seq", length));
			String[] stlAmt = (JSPUtil.getParameter(request, prefix	+ "stl_amt", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));			
			String[] joFshFlg2 = (JSPUtil.getParameter(request, prefix	+ "jo_fsh_flg2", length));			
			
			for (int i = 0; i < length; i++) {
				model = new SltHirTgtVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (joOvrBsaTeuQty[i] != null)
					model.setJoOvrBsaTeuQty(joOvrBsaTeuQty[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (joAlocEnblFlg[i] != null)
					model.setJoAlocEnblFlg(joAlocEnblFlg[i]);
				if (joBsaTeuQty[i] != null)
					model.setJoBsaTeuQty(joBsaTeuQty[i]);
				if (joOvrOcnPrc[i] != null)
					model.setJoOvrOcnPrc(joOvrOcnPrc[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (joSctrPrcFlg[i] != null)
					model.setJoSctrPrcFlg(joSctrPrcFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fnlStlAmt[i] != null)
					model.setFnlStlAmt(fnlStlAmt[i]);
				if (joBsaEntrRdrRmk[i] != null)
					model.setJoBsaEntrRdrRmk(joBsaEntrRdrRmk[i]);
				if (joStlStsCd[i] != null)
					model.setJoStlStsCd(joStlStsCd[i]);
				if (joStlStsCd2[i] != null)
					model.setJoStlStsCd2(joStlStsCd2[i]);				
				if (joTonTeuQty[i] != null)
					model.setJoTonTeuQty(joTonTeuQty[i]);
				if (joRndRuleLvl[i] != null)
					model.setJoRndRuleLvl(joRndRuleLvl[i]);
				if (joRdrPortCd[i] != null)
					model.setJoRdrPortCd(joRdrPortCd[i]);
				if (joBsaAddTeuQty[i] != null)
					model.setJoBsaAddTeuQty(joBsaAddTeuQty[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (joPrcFshFlg[i] != null)
					model.setJoPrcFshFlg(joPrcFshFlg[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (joRfInterPrc[i] != null)
					model.setJoRfInterPrc(joRfInterPrc[i]);
				if (joBsaEntrRmk[i] != null)
					model.setJoBsaEntrRmk(joBsaEntrRmk[i]);
				if (estmStlAmt[i] != null)
					model.setEstmStlAmt(estmStlAmt[i]);
				if (lstLodgPortEtdDt[i] != null)
					model.setLstLodgPortEtdDt(lstLodgPortEtdDt[i]);
				if (bsaSltPrc[i] != null)
					model.setBsaSltPrc(bsaSltPrc[i]);
				if (joRfInterTeuQty[i] != null)
					model.setJoRfInterTeuQty(joRfInterTeuQty[i]);
				if (fnlBsaQty[i] != null)
					model.setFnlBsaQty(fnlBsaQty[i]);
				if (joStlJbCd[i] != null)
					model.setJoStlJbCd(joStlJbCd[i]);
				if (joInterOvrFlg[i] != null)
					model.setJoInterOvrFlg(joInterOvrFlg[i]);
				if (joOvrMtOcnPrc[i] != null)
					model.setJoOvrMtOcnPrc(joOvrMtOcnPrc[i]);
				if (joRndKndFlg[i] != null)
					model.setJoRndKndFlg(joRndKndFlg[i]);
				if (bsaQty[i] != null)
					model.setBsaQty(bsaQty[i]);
				if (joRfOcnPrc[i] != null)
					model.setJoRfOcnPrc(joRfOcnPrc[i]);
				if (joOvrMtInterPrc[i] != null)
					model.setJoOvrMtInterPrc(joOvrMtInterPrc[i]);
				if (jo45ftUndRto[i] != null)
					model.setJo45ftUndRto(jo45ftUndRto[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (jo45ftOvrRto[i] != null)
					model.setJo45ftOvrRto(jo45ftOvrRto[i]);
				if (fnlBsaSltPrc[i] != null)
					model.setFnlBsaSltPrc(fnlBsaSltPrc[i]);
				if (jo45ftSubTeuQty[i] != null)
					model.setJo45ftSubTeuQty(jo45ftSubTeuQty[i]);
				if (joAddBsaCrrFlg[i] != null)
					model.setJoAddBsaCrrFlg(joAddBsaCrrFlg[i]);
				if (actStlAmt[i] != null)
					model.setActStlAmt(actStlAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (joRfOcnTeuQty[i] != null)
					model.setJoRfOcnTeuQty(joRfOcnTeuQty[i]);
				if (n1stLodgPortEtdDt[i] != null)
					model.setN1stLodgPortEtdDt(n1stLodgPortEtdDt[i]);
				if (joBsaPrc[i] != null)
					model.setJoBsaPrc(joBsaPrc[i]);
				if (jo20ftOvrRto[i] != null)
					model.setJo20ftOvrRto(jo20ftOvrRto[i]);
				if (jo40ftOvrRto[i] != null)
					model.setJo40ftOvrRto(jo40ftOvrRto[i]);
				if (lstLodgPortCd[i] != null)
					model.setLstLodgPortCd(lstLodgPortCd[i]);
				if (jo40ftSubTeuQty[i] != null)
					model.setJo40ftSubTeuQty(jo40ftSubTeuQty[i]);
				if (adjRsltCd[i] != null)
					model.setAdjRsltCd(adjRsltCd[i]);
				if (stlVvdSeq[i] != null)
					model.setStlVvdSeq(stlVvdSeq[i]);
				if (adjRmk[i] != null)
					model.setAdjRmk(adjRmk[i]);
				if (jo20ftSubTeuQty[i] != null)
					model.setJo20ftSubTeuQty(jo20ftSubTeuQty[i]);
				if (revPortEtdDt[i] != null)
					model.setRevPortEtdDt(revPortEtdDt[i]);
				if (actBsaQty[i] != null)
					model.setActBsaQty(actBsaQty[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (estmVvdTpCd[i] != null)
					model.setEstmVvdTpCd(estmVvdTpCd[i]);
				if (joFshFlg[i] != null)
					model.setJoFshFlg(joFshFlg[i]);
				if (stlClzFlg[i] != null)
					model.setStlClzFlg(stlClzFlg[i]);
				if (joOvrInterPrc[i] != null)
					model.setJoOvrInterPrc(joOvrInterPrc[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (joOvrTonWgt[i] != null)
					model.setJoOvrTonWgt(joOvrTonWgt[i]);
				if (actSltPrc[i] != null)
					model.setActSltPrc(actSltPrc[i]);
				if (vndrCust[i] != null)
					model.setVndrCust(vndrCust[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bsaRank[i] != null)
					model.setBsaRank(bsaRank[i]);
				if (opCrrCd[i] != null)
					model.setOpCrrCd(opCrrCd[i]);
				if (settleYn[i] != null)
					model.setSettleYn(settleYn[i]);
				if (totPageCnt[i] != null)
					model.setTotPageCnt(totPageCnt[i]);
				if (seqNo[i] != null)
					model.setSeqNo(seqNo[i]);
				if (diff[i] != null)
					model.setDiff(diff[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (revYrmonSeq[i] != null)
					model.setRevYrmonSeq(revYrmonSeq[i]);
				if (stlAmt[i] != null)
					model.setStlAmt(stlAmt[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (joFshFlg2[i] != null)
					model.setJoFshFlg2(joFshFlg2[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSltHirTgtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SltHirTgtVO[]
	 */
	public SltHirTgtVO[] getSltHirTgtVOs(){
		SltHirTgtVO[] vos = (SltHirTgtVO[])models.toArray(new SltHirTgtVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joOvrBsaTeuQty = this.joOvrBsaTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAlocEnblFlg = this.joAlocEnblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaTeuQty = this.joBsaTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joOvrOcnPrc = this.joOvrOcnPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joSctrPrcFlg = this.joSctrPrcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlStlAmt = this.fnlStlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaEntrRdrRmk = this.joBsaEntrRdrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlStsCd = this.joStlStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlStsCd2 = this.joStlStsCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.joTonTeuQty = this.joTonTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRndRuleLvl = this.joRndRuleLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRdrPortCd = this.joRdrPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaAddTeuQty = this.joBsaAddTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joPrcFshFlg = this.joPrcFshFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRfInterPrc = this.joRfInterPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaEntrRmk = this.joBsaEntrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmStlAmt = this.estmStlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortEtdDt = this.lstLodgPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSltPrc = this.bsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRfInterTeuQty = this.joRfInterTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaQty = this.fnlBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlJbCd = this.joStlJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joInterOvrFlg = this.joInterOvrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joOvrMtOcnPrc = this.joOvrMtOcnPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRndKndFlg = this.joRndKndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaQty = this.bsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRfOcnPrc = this.joRfOcnPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joOvrMtInterPrc = this.joOvrMtInterPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftUndRto = this.jo45ftUndRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftOvrRto = this.jo45ftOvrRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaSltPrc = this.fnlBsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftSubTeuQty = this.jo45ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAddBsaCrrFlg = this.joAddBsaCrrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStlAmt = this.actStlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRfOcnTeuQty = this.joRfOcnTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stLodgPortEtdDt = this.n1stLodgPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaPrc = this.joBsaPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo20ftOvrRto = this.jo20ftOvrRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo40ftOvrRto = this.jo40ftOvrRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortCd = this.lstLodgPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo40ftSubTeuQty = this.jo40ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjRsltCd = this.adjRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlVvdSeq = this.stlVvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjRmk = this.adjRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo20ftSubTeuQty = this.jo20ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revPortEtdDt = this.revPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBsaQty = this.actBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVvdTpCd = this.estmVvdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joFshFlg = this.joFshFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlClzFlg = this.stlClzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joOvrInterPrc = this.joOvrInterPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joOvrTonWgt = this.joOvrTonWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actSltPrc = this.actSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCust = this.vndrCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.bsaRank = this.bsaRank .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.opCrrCd = this.opCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.settleYn = this.settleYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.totPageCnt = this.totPageCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.diff = this.diff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.revYrmonSeq = this.revYrmonSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.stlAmt = this.stlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.joFshFlg2 = this.joFshFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
