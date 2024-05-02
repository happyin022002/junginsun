/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JoLoadingVO.java
*@FileTitle : JoLoadingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.04.26 박정민 
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
 * @author 박정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JoLoadingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JoLoadingVO> models = new ArrayList<JoLoadingVO>();
	
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String grandTtlWgt = null;
	/* Column Info */
	private String bkgMt20 = null;
	/* Column Info */
	private String rmkFlg = null;
	/* Column Info */
	private String bkgHcLd40 = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dg40 = null;
	/* Column Info */
	private String robCntrWgt = null;
	/* Column Info */
	private String rf20ftCntrStlAmt = null;
	/* Column Info */
	private String bkgHcLd45 = null;
	/* Column Info */
	private String mt20 = null;
	/* Column Info */
	private String bkgDg40 = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String stlClzFlg = null;
	/* Column Info */
	private String dgCntrStlRmk = null;
	/* Column Info */
	private String bkgFull40 = null;
	/* Column Info */
	private String ovrUsdSltTeuCapa = null;
	/* Column Info */
	private String pass = null;
	/* Column Info */
	private String dgCntrStlPrc = null;
	/* Column Info */
	private String dg20 = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bkgRf20Qty = null;
	/* Column Info */
	private String ovrUsdSltAmt = null;
	/* Column Info */
	private String hcBsa45 = null;
	/* Column Info */
	private String hcBsa40 = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String teuQty = null;
	/* Column Info */
	private String bkgAkUnit = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String grandTtlSlot = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String bkgMt40 = null;
	/* Column Info */
	private String bkgHcLd20 = null;
	/* Column Info */
	private String jo20ftN1stRto = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String akVoid = null;
	/* Column Info */
	private String mt40 = null;
	/* Column Info */
	private String stlTgtFlg = null;
	/* Column Info */
	private String bkgAkVoid = null;
	/* Column Info */
	private String akUnit = null;
	/* Column Info */
	private String hcLd20 = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String allTeu = null;
	/* Column Info */
	private String rf40Qty = null;
	/* Column Info */
	private String stlVvdSeq = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String finUsed = null;
	/* Column Info */
	private String overSlot = null;
	/* Column Info */
	private String hcBsa20 = null;
	/* Column Info */
	private String portSkdSts = null;
	/* Column Info */
	private String rf40ftCntrStlTeuCapa = null;
	/* Column Info */
	private String hcLd40 = null;
	/* Column Info */
	private String bkgHcBsa45 = null;
	/* Column Info */
	private String jo40ftN1stRto = null;
	/* Column Info */
	private String rf20Qty = null;
	/* Column Info */
	private String rf40ftCntrStlAmt = null;
	/* Column Info */
	private String source = null;
	/* Column Info */
	private String bkgHcBsa40 = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String bkgRfRdrQty = null;
	/* Column Info */
	private String bkgRfRdr40Qty = null;
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String stlTgtFlg2 = null;
	/* Column Info */
	private String hcLd45 = null;
	/* Column Info */
	private String subChk = null;
	/* Column Info */
	private String rf20ftCntrStlTeuCapa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String jo20ftSubTeuQty = null;
	/* Column Info */
	private String bsaFlg = null;
	/* Column Info */
	private String jo45ftN2ndRto = null;
	/* Column Info */
	private String jo40ftSubTeuQty = null;
	/* Column Info */
	private String revYrmonSeq = null;
	/* Column Info */
	private String full20 = null;
	/* Column Info */
	private String jo45ftN1stRto = null;
	/* Column Info */
	private String joRndRuleLvl = null;
	/* Column Info */
	private String rf40ftCntrStlRmk = null;
	/* Column Info */
	private String joFshFlg = null;
	/* Column Info */
	private String overWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dgCntrStlAmt = null;
	/* Column Info */
	private String mtTeu = null;
	/* Column Info */
	private String rf20ftCntrStlPrc = null;
	/* Column Info */
	private String bkgHcBsa20 = null;
	/* Column Info */
	private String rfScgStlTpCd = null;
	/* Column Info */
	private String rfRdrQty = null;
	/* Column Info */
	private String rf40ftCntrStlPrc = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String mtWt = null;
	/* Column Info */
	private String bkgRf40Qty = null;
	/* Column Info */
	private String bkgDg20 = null;
	/* Column Info */
	private String rf20ftCntrStlRmk = null;
	/* Column Info */
	private String ovrUsdSltPrc = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String bkgFull20 = null;
	/* Column Info */
	private String allWgt = null;
	/* Column Info */
	private String rfRdr40Qty = null;
	/* Column Info */
	private String dgCntrStlTeuCapa = null;
	/* Column Info */
	private String ovrUsdSltRmk = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String jo45ftSubTeuQty = null;
	/* Column Info */
	private String bkgGrandTtlWgt = null;
	/* Column Info */
	private String full40 = null;
	/* Column Info */
	private String rdrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public JoLoadingVO() {}

	public JoLoadingVO(String ibflag, String pagerows, String vslCd, String hcLd45, String hcBsa20, String akVoid, String trdCd, String rlaneCd, String mt40, String rfRdrQty, String crrCd, String jo45ftN1stRto, String full40, String vpsPortCd, String hcLd40, String updUsrId, String joRndRuleLvl, String vpsEtdDt, String revYrmon, String skdVoyNo, String akUnit, String teuQty, String jo40ftN1stRto, String hcBsa40, String rf20Qty, String hcBsa45, String rf40Qty, String mt20, String jo45ftSubTeuQty, String hcLd20, String full20, String robCntrWgt, String allWgt, String mtTeu, String stlTgtFlg, String jo45ftN2ndRto, String dg20, String jo40ftSubTeuQty, String mtWt, String stlVvdSeq, String subChk, String jo20ftSubTeuQty, String dg40, String rdrFlg, String allTeu, String skdDirCd, String joFshFlg, String source, String ydCd, String clptIndSeq, String reDivrCd, String jo20ftN1stRto, String grandTtlWgt, String rf20ftCntrStlTeuCapa, String rf40ftCntrStlPrc, String dgCntrStlRmk, String rf20ftCntrStlRmk, String dgCntrStlAmt, String rf40ftCntrStlTeuCapa, String tmlCd, String ovrUsdSltRmk, String rf40ftCntrStlRmk, String dgCntrStlTeuCapa, String rf20ftCntrStlAmt, String ovrUsdSltPrc, String rf20ftCntrStlPrc, String dgCntrStlPrc, String rf40ftCntrStlAmt, String ovrUsdSltTeuCapa, String ovrUsdSltAmt, String grandTtlSlot, String overSlot, String overWgt, String revDirCd, String rfScgStlTpCd, String revYrmonSeq, String stlClzFlg, String pass, String finUsed, String slanCd, String acctYrmon, String stlTgtFlg2, String rmkFlg, String rmk, String portSkdSts, String clptSeq, String rfRdr40Qty, String bsaFlg, String bkgGrandTtlWgt, String bkgFull20, String bkgMt20, String bkgFull40, String bkgMt40, String bkgHcLd20, String bkgHcBsa20, String bkgHcLd40, String bkgHcBsa40, String bkgHcLd45, String bkgHcBsa45, String bkgAkUnit, String bkgRf20Qty, String bkgRfRdrQty, String bkgRfRdr40Qty, String bkgRf40Qty, String bkgDg20, String bkgDg40, String bkgAkVoid) {
		this.rlaneCd = rlaneCd;
		this.grandTtlWgt = grandTtlWgt;
		this.bkgMt20 = bkgMt20;
		this.rmkFlg = rmkFlg;
		this.bkgHcLd40 = bkgHcLd40;
		this.crrCd = crrCd;
		this.updUsrId = updUsrId;
		this.dg40 = dg40;
		this.robCntrWgt = robCntrWgt;
		this.rf20ftCntrStlAmt = rf20ftCntrStlAmt;
		this.bkgHcLd45 = bkgHcLd45;
		this.mt20 = mt20;
		this.bkgDg40 = bkgDg40;
		this.acctYrmon = acctYrmon;
		this.slanCd = slanCd;
		this.stlClzFlg = stlClzFlg;
		this.dgCntrStlRmk = dgCntrStlRmk;
		this.bkgFull40 = bkgFull40;
		this.ovrUsdSltTeuCapa = ovrUsdSltTeuCapa;
		this.pass = pass;
		this.dgCntrStlPrc = dgCntrStlPrc;
		this.dg20 = dg20;
		this.trdCd = trdCd;
		this.bkgRf20Qty = bkgRf20Qty;
		this.ovrUsdSltAmt = ovrUsdSltAmt;
		this.hcBsa45 = hcBsa45;
		this.hcBsa40 = hcBsa40;
		this.tmlCd = tmlCd;
		this.teuQty = teuQty;
		this.bkgAkUnit = bkgAkUnit;
		this.clptSeq = clptSeq;
		this.grandTtlSlot = grandTtlSlot;
		this.vpsEtdDt = vpsEtdDt;
		this.bkgMt40 = bkgMt40;
		this.bkgHcLd20 = bkgHcLd20;
		this.jo20ftN1stRto = jo20ftN1stRto;
		this.vpsPortCd = vpsPortCd;
		this.akVoid = akVoid;
		this.mt40 = mt40;
		this.stlTgtFlg = stlTgtFlg;
		this.bkgAkVoid = bkgAkVoid;
		this.akUnit = akUnit;
		this.hcLd20 = hcLd20;
		this.clptIndSeq = clptIndSeq;
		this.allTeu = allTeu;
		this.rf40Qty = rf40Qty;
		this.stlVvdSeq = stlVvdSeq;
		this.reDivrCd = reDivrCd;
		this.finUsed = finUsed;
		this.overSlot = overSlot;
		this.hcBsa20 = hcBsa20;
		this.portSkdSts = portSkdSts;
		this.rf40ftCntrStlTeuCapa = rf40ftCntrStlTeuCapa;
		this.hcLd40 = hcLd40;
		this.bkgHcBsa45 = bkgHcBsa45;
		this.jo40ftN1stRto = jo40ftN1stRto;
		this.rf20Qty = rf20Qty;
		this.rf40ftCntrStlAmt = rf40ftCntrStlAmt;
		this.source = source;
		this.bkgHcBsa40 = bkgHcBsa40;
		this.revDirCd = revDirCd;
		this.bkgRfRdrQty = bkgRfRdrQty;
		this.bkgRfRdr40Qty = bkgRfRdr40Qty;
		this.rmk = rmk;
		this.stlTgtFlg2 = stlTgtFlg2;
		this.hcLd45 = hcLd45;
		this.subChk = subChk;
		this.rf20ftCntrStlTeuCapa = rf20ftCntrStlTeuCapa;
		this.pagerows = pagerows;
		this.vslCd = vslCd;
		this.jo20ftSubTeuQty = jo20ftSubTeuQty;
		this.bsaFlg = bsaFlg;
		this.jo45ftN2ndRto = jo45ftN2ndRto;
		this.jo40ftSubTeuQty = jo40ftSubTeuQty;
		this.revYrmonSeq = revYrmonSeq;
		this.full20 = full20;
		this.jo45ftN1stRto = jo45ftN1stRto;
		this.joRndRuleLvl = joRndRuleLvl;
		this.rf40ftCntrStlRmk = rf40ftCntrStlRmk;
		this.joFshFlg = joFshFlg;
		this.overWgt = overWgt;
		this.ibflag = ibflag;
		this.dgCntrStlAmt = dgCntrStlAmt;
		this.mtTeu = mtTeu;
		this.rf20ftCntrStlPrc = rf20ftCntrStlPrc;
		this.bkgHcBsa20 = bkgHcBsa20;
		this.rfScgStlTpCd = rfScgStlTpCd;
		this.rfRdrQty = rfRdrQty;
		this.rf40ftCntrStlPrc = rf40ftCntrStlPrc;
		this.skdDirCd = skdDirCd;
		this.mtWt = mtWt;
		this.bkgRf40Qty = bkgRf40Qty;
		this.bkgDg20 = bkgDg20;
		this.rf20ftCntrStlRmk = rf20ftCntrStlRmk;
		this.ovrUsdSltPrc = ovrUsdSltPrc;
		this.revYrmon = revYrmon;
		this.skdVoyNo = skdVoyNo;
		this.bkgFull20 = bkgFull20;
		this.allWgt = allWgt;
		this.rfRdr40Qty = rfRdr40Qty;
		this.dgCntrStlTeuCapa = dgCntrStlTeuCapa;
		this.ovrUsdSltRmk = ovrUsdSltRmk;
		this.ydCd = ydCd;
		this.jo45ftSubTeuQty = jo45ftSubTeuQty;
		this.bkgGrandTtlWgt = bkgGrandTtlWgt;
		this.full40 = full40;
		this.rdrFlg = rdrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("grand_ttl_wgt", getGrandTtlWgt());
		this.hashColumns.put("bkg_mt_20", getBkgMt20());
		this.hashColumns.put("rmk_flg", getRmkFlg());
		this.hashColumns.put("bkg_hc_ld_40", getBkgHcLd40());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dg_40", getDg40());
		this.hashColumns.put("rob_cntr_wgt", getRobCntrWgt());
		this.hashColumns.put("rf_20ft_cntr_stl_amt", getRf20ftCntrStlAmt());
		this.hashColumns.put("bkg_hc_ld_45", getBkgHcLd45());
		this.hashColumns.put("mt_20", getMt20());
		this.hashColumns.put("bkg_dg_40", getBkgDg40());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("stl_clz_flg", getStlClzFlg());
		this.hashColumns.put("dg_cntr_stl_rmk", getDgCntrStlRmk());
		this.hashColumns.put("bkg_full_40", getBkgFull40());
		this.hashColumns.put("ovr_usd_slt_teu_capa", getOvrUsdSltTeuCapa());
		this.hashColumns.put("pass", getPass());
		this.hashColumns.put("dg_cntr_stl_prc", getDgCntrStlPrc());
		this.hashColumns.put("dg_20", getDg20());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bkg_rf_20_qty", getBkgRf20Qty());
		this.hashColumns.put("ovr_usd_slt_amt", getOvrUsdSltAmt());
		this.hashColumns.put("hc_bsa_45", getHcBsa45());
		this.hashColumns.put("hc_bsa_40", getHcBsa40());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("teu_qty", getTeuQty());
		this.hashColumns.put("bkg_ak_unit", getBkgAkUnit());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("grand_ttl_slot", getGrandTtlSlot());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("bkg_mt_40", getBkgMt40());
		this.hashColumns.put("bkg_hc_ld_20", getBkgHcLd20());
		this.hashColumns.put("jo_20ft_n1st_rto", getJo20ftN1stRto());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ak_void", getAkVoid());
		this.hashColumns.put("mt_40", getMt40());
		this.hashColumns.put("stl_tgt_flg", getStlTgtFlg());
		this.hashColumns.put("bkg_ak_void", getBkgAkVoid());
		this.hashColumns.put("ak_unit", getAkUnit());
		this.hashColumns.put("hc_ld_20", getHcLd20());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("all_teu", getAllTeu());
		this.hashColumns.put("rf_40_qty", getRf40Qty());
		this.hashColumns.put("stl_vvd_seq", getStlVvdSeq());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("fin_used", getFinUsed());
		this.hashColumns.put("over_slot", getOverSlot());
		this.hashColumns.put("hc_bsa_20", getHcBsa20());
		this.hashColumns.put("port_skd_sts", getPortSkdSts());
		this.hashColumns.put("rf_40ft_cntr_stl_teu_capa", getRf40ftCntrStlTeuCapa());
		this.hashColumns.put("hc_ld_40", getHcLd40());
		this.hashColumns.put("bkg_hc_bsa_45", getBkgHcBsa45());
		this.hashColumns.put("jo_40ft_n1st_rto", getJo40ftN1stRto());
		this.hashColumns.put("rf_20_qty", getRf20Qty());
		this.hashColumns.put("rf_40ft_cntr_stl_amt", getRf40ftCntrStlAmt());
		this.hashColumns.put("source", getSource());
		this.hashColumns.put("bkg_hc_bsa_40", getBkgHcBsa40());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("bkg_rf_rdr_qty", getBkgRfRdrQty());
		this.hashColumns.put("bkg_rf_rdr_40_qty", getBkgRfRdr40Qty());
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("stl_tgt_flg2", getStlTgtFlg2());
		this.hashColumns.put("hc_ld_45", getHcLd45());
		this.hashColumns.put("sub_chk", getSubChk());
		this.hashColumns.put("rf_20ft_cntr_stl_teu_capa", getRf20ftCntrStlTeuCapa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("jo_20ft_sub_teu_qty", getJo20ftSubTeuQty());
		this.hashColumns.put("bsa_flg", getBsaFlg());
		this.hashColumns.put("jo_45ft_n2nd_rto", getJo45ftN2ndRto());
		this.hashColumns.put("jo_40ft_sub_teu_qty", getJo40ftSubTeuQty());
		this.hashColumns.put("rev_yrmon_seq", getRevYrmonSeq());
		this.hashColumns.put("full_20", getFull20());
		this.hashColumns.put("jo_45ft_n1st_rto", getJo45ftN1stRto());
		this.hashColumns.put("jo_rnd_rule_lvl", getJoRndRuleLvl());
		this.hashColumns.put("rf_40ft_cntr_stl_rmk", getRf40ftCntrStlRmk());
		this.hashColumns.put("jo_fsh_flg", getJoFshFlg());
		this.hashColumns.put("over_wgt", getOverWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dg_cntr_stl_amt", getDgCntrStlAmt());
		this.hashColumns.put("mt_teu", getMtTeu());
		this.hashColumns.put("rf_20ft_cntr_stl_prc", getRf20ftCntrStlPrc());
		this.hashColumns.put("bkg_hc_bsa_20", getBkgHcBsa20());
		this.hashColumns.put("rf_scg_stl_tp_cd", getRfScgStlTpCd());
		this.hashColumns.put("rf_rdr_qty", getRfRdrQty());
		this.hashColumns.put("rf_40ft_cntr_stl_prc", getRf40ftCntrStlPrc());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("mt_wt", getMtWt());
		this.hashColumns.put("bkg_rf_40_qty", getBkgRf40Qty());
		this.hashColumns.put("bkg_dg_20", getBkgDg20());
		this.hashColumns.put("rf_20ft_cntr_stl_rmk", getRf20ftCntrStlRmk());
		this.hashColumns.put("ovr_usd_slt_prc", getOvrUsdSltPrc());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bkg_full_20", getBkgFull20());
		this.hashColumns.put("all_wgt", getAllWgt());
		this.hashColumns.put("rf_rdr_40_qty", getRfRdr40Qty());
		this.hashColumns.put("dg_cntr_stl_teu_capa", getDgCntrStlTeuCapa());
		this.hashColumns.put("ovr_usd_slt_rmk", getOvrUsdSltRmk());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("jo_45ft_sub_teu_qty", getJo45ftSubTeuQty());
		this.hashColumns.put("bkg_grand_ttl_wgt", getBkgGrandTtlWgt());
		this.hashColumns.put("full_40", getFull40());
		this.hashColumns.put("rdr_flg", getRdrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("grand_ttl_wgt", "grandTtlWgt");
		this.hashFields.put("bkg_mt_20", "bkgMt20");
		this.hashFields.put("rmk_flg", "rmkFlg");
		this.hashFields.put("bkg_hc_ld_40", "bkgHcLd40");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dg_40", "dg40");
		this.hashFields.put("rob_cntr_wgt", "robCntrWgt");
		this.hashFields.put("rf_20ft_cntr_stl_amt", "rf20ftCntrStlAmt");
		this.hashFields.put("bkg_hc_ld_45", "bkgHcLd45");
		this.hashFields.put("mt_20", "mt20");
		this.hashFields.put("bkg_dg_40", "bkgDg40");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("stl_clz_flg", "stlClzFlg");
		this.hashFields.put("dg_cntr_stl_rmk", "dgCntrStlRmk");
		this.hashFields.put("bkg_full_40", "bkgFull40");
		this.hashFields.put("ovr_usd_slt_teu_capa", "ovrUsdSltTeuCapa");
		this.hashFields.put("pass", "pass");
		this.hashFields.put("dg_cntr_stl_prc", "dgCntrStlPrc");
		this.hashFields.put("dg_20", "dg20");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bkg_rf_20_qty", "bkgRf20Qty");
		this.hashFields.put("ovr_usd_slt_amt", "ovrUsdSltAmt");
		this.hashFields.put("hc_bsa_45", "hcBsa45");
		this.hashFields.put("hc_bsa_40", "hcBsa40");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("teu_qty", "teuQty");
		this.hashFields.put("bkg_ak_unit", "bkgAkUnit");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("grand_ttl_slot", "grandTtlSlot");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("bkg_mt_40", "bkgMt40");
		this.hashFields.put("bkg_hc_ld_20", "bkgHcLd20");
		this.hashFields.put("jo_20ft_n1st_rto", "jo20ftN1stRto");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ak_void", "akVoid");
		this.hashFields.put("mt_40", "mt40");
		this.hashFields.put("stl_tgt_flg", "stlTgtFlg");
		this.hashFields.put("bkg_ak_void", "bkgAkVoid");
		this.hashFields.put("ak_unit", "akUnit");
		this.hashFields.put("hc_ld_20", "hcLd20");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("all_teu", "allTeu");
		this.hashFields.put("rf_40_qty", "rf40Qty");
		this.hashFields.put("stl_vvd_seq", "stlVvdSeq");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("fin_used", "finUsed");
		this.hashFields.put("over_slot", "overSlot");
		this.hashFields.put("hc_bsa_20", "hcBsa20");
		this.hashFields.put("port_skd_sts", "portSkdSts");
		this.hashFields.put("rf_40ft_cntr_stl_teu_capa", "rf40ftCntrStlTeuCapa");
		this.hashFields.put("hc_ld_40", "hcLd40");
		this.hashFields.put("bkg_hc_bsa_45", "bkgHcBsa45");
		this.hashFields.put("jo_40ft_n1st_rto", "jo40ftN1stRto");
		this.hashFields.put("rf_20_qty", "rf20Qty");
		this.hashFields.put("rf_40ft_cntr_stl_amt", "rf40ftCntrStlAmt");
		this.hashFields.put("source", "source");
		this.hashFields.put("bkg_hc_bsa_40", "bkgHcBsa40");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("bkg_rf_rdr_qty", "bkgRfRdrQty");
		this.hashFields.put("bkg_rf_rdr_40_qty", "bkgRfRdr40Qty");
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("stl_tgt_flg2", "stlTgtFlg2");
		this.hashFields.put("hc_ld_45", "hcLd45");
		this.hashFields.put("sub_chk", "subChk");
		this.hashFields.put("rf_20ft_cntr_stl_teu_capa", "rf20ftCntrStlTeuCapa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("jo_20ft_sub_teu_qty", "jo20ftSubTeuQty");
		this.hashFields.put("bsa_flg", "bsaFlg");
		this.hashFields.put("jo_45ft_n2nd_rto", "jo45ftN2ndRto");
		this.hashFields.put("jo_40ft_sub_teu_qty", "jo40ftSubTeuQty");
		this.hashFields.put("rev_yrmon_seq", "revYrmonSeq");
		this.hashFields.put("full_20", "full20");
		this.hashFields.put("jo_45ft_n1st_rto", "jo45ftN1stRto");
		this.hashFields.put("jo_rnd_rule_lvl", "joRndRuleLvl");
		this.hashFields.put("rf_40ft_cntr_stl_rmk", "rf40ftCntrStlRmk");
		this.hashFields.put("jo_fsh_flg", "joFshFlg");
		this.hashFields.put("over_wgt", "overWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dg_cntr_stl_amt", "dgCntrStlAmt");
		this.hashFields.put("mt_teu", "mtTeu");
		this.hashFields.put("rf_20ft_cntr_stl_prc", "rf20ftCntrStlPrc");
		this.hashFields.put("bkg_hc_bsa_20", "bkgHcBsa20");
		this.hashFields.put("rf_scg_stl_tp_cd", "rfScgStlTpCd");
		this.hashFields.put("rf_rdr_qty", "rfRdrQty");
		this.hashFields.put("rf_40ft_cntr_stl_prc", "rf40ftCntrStlPrc");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("mt_wt", "mtWt");
		this.hashFields.put("bkg_rf_40_qty", "bkgRf40Qty");
		this.hashFields.put("bkg_dg_20", "bkgDg20");
		this.hashFields.put("rf_20ft_cntr_stl_rmk", "rf20ftCntrStlRmk");
		this.hashFields.put("ovr_usd_slt_prc", "ovrUsdSltPrc");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bkg_full_20", "bkgFull20");
		this.hashFields.put("all_wgt", "allWgt");
		this.hashFields.put("rf_rdr_40_qty", "rfRdr40Qty");
		this.hashFields.put("dg_cntr_stl_teu_capa", "dgCntrStlTeuCapa");
		this.hashFields.put("ovr_usd_slt_rmk", "ovrUsdSltRmk");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("jo_45ft_sub_teu_qty", "jo45ftSubTeuQty");
		this.hashFields.put("bkg_grand_ttl_wgt", "bkgGrandTtlWgt");
		this.hashFields.put("full_40", "full40");
		this.hashFields.put("rdr_flg", "rdrFlg");
		return this.hashFields;
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
	 * @return grandTtlWgt
	 */
	public String getGrandTtlWgt() {
		return this.grandTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return bkgMt20
	 */
	public String getBkgMt20() {
		return this.bkgMt20;
	}
	
	/**
	 * Column Info
	 * @return rmkFlg
	 */
	public String getRmkFlg() {
		return this.rmkFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgHcLd40
	 */
	public String getBkgHcLd40() {
		return this.bkgHcLd40;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return dg40
	 */
	public String getDg40() {
		return this.dg40;
	}
	
	/**
	 * Column Info
	 * @return robCntrWgt
	 */
	public String getRobCntrWgt() {
		return this.robCntrWgt;
	}
	
	/**
	 * Column Info
	 * @return rf20ftCntrStlAmt
	 */
	public String getRf20ftCntrStlAmt() {
		return this.rf20ftCntrStlAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgHcLd45
	 */
	public String getBkgHcLd45() {
		return this.bkgHcLd45;
	}
	
	/**
	 * Column Info
	 * @return mt20
	 */
	public String getMt20() {
		return this.mt20;
	}
	
	/**
	 * Column Info
	 * @return bkgDg40
	 */
	public String getBkgDg40() {
		return this.bkgDg40;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @return dgCntrStlRmk
	 */
	public String getDgCntrStlRmk() {
		return this.dgCntrStlRmk;
	}
	
	/**
	 * Column Info
	 * @return bkgFull40
	 */
	public String getBkgFull40() {
		return this.bkgFull40;
	}
	
	/**
	 * Column Info
	 * @return ovrUsdSltTeuCapa
	 */
	public String getOvrUsdSltTeuCapa() {
		return this.ovrUsdSltTeuCapa;
	}
	
	/**
	 * Column Info
	 * @return pass
	 */
	public String getPass() {
		return this.pass;
	}
	
	/**
	 * Column Info
	 * @return dgCntrStlPrc
	 */
	public String getDgCntrStlPrc() {
		return this.dgCntrStlPrc;
	}
	
	/**
	 * Column Info
	 * @return dg20
	 */
	public String getDg20() {
		return this.dg20;
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
	 * @return bkgRf20Qty
	 */
	public String getBkgRf20Qty() {
		return this.bkgRf20Qty;
	}
	
	/**
	 * Column Info
	 * @return ovrUsdSltAmt
	 */
	public String getOvrUsdSltAmt() {
		return this.ovrUsdSltAmt;
	}
	
	/**
	 * Column Info
	 * @return hcBsa45
	 */
	public String getHcBsa45() {
		return this.hcBsa45;
	}
	
	/**
	 * Column Info
	 * @return hcBsa40
	 */
	public String getHcBsa40() {
		return this.hcBsa40;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	/**
	 * Column Info
	 * @return teuQty
	 */
	public String getTeuQty() {
		return this.teuQty;
	}
	
	/**
	 * Column Info
	 * @return bkgAkUnit
	 */
	public String getBkgAkUnit() {
		return this.bkgAkUnit;
	}
	
	/**
	 * Column Info
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
	}
	
	/**
	 * Column Info
	 * @return grandTtlSlot
	 */
	public String getGrandTtlSlot() {
		return this.grandTtlSlot;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return bkgMt40
	 */
	public String getBkgMt40() {
		return this.bkgMt40;
	}
	
	/**
	 * Column Info
	 * @return bkgHcLd20
	 */
	public String getBkgHcLd20() {
		return this.bkgHcLd20;
	}
	
	/**
	 * Column Info
	 * @return jo20ftN1stRto
	 */
	public String getJo20ftN1stRto() {
		return this.jo20ftN1stRto;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return akVoid
	 */
	public String getAkVoid() {
		return this.akVoid;
	}
	
	/**
	 * Column Info
	 * @return mt40
	 */
	public String getMt40() {
		return this.mt40;
	}
	
	/**
	 * Column Info
	 * @return stlTgtFlg
	 */
	public String getStlTgtFlg() {
		return this.stlTgtFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgAkVoid
	 */
	public String getBkgAkVoid() {
		return this.bkgAkVoid;
	}
	
	/**
	 * Column Info
	 * @return akUnit
	 */
	public String getAkUnit() {
		return this.akUnit;
	}
	
	/**
	 * Column Info
	 * @return hcLd20
	 */
	public String getHcLd20() {
		return this.hcLd20;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return allTeu
	 */
	public String getAllTeu() {
		return this.allTeu;
	}
	
	/**
	 * Column Info
	 * @return rf40Qty
	 */
	public String getRf40Qty() {
		return this.rf40Qty;
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
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return finUsed
	 */
	public String getFinUsed() {
		return this.finUsed;
	}
	
	/**
	 * Column Info
	 * @return overSlot
	 */
	public String getOverSlot() {
		return this.overSlot;
	}
	
	/**
	 * Column Info
	 * @return hcBsa20
	 */
	public String getHcBsa20() {
		return this.hcBsa20;
	}
	
	/**
	 * Column Info
	 * @return portSkdSts
	 */
	public String getPortSkdSts() {
		return this.portSkdSts;
	}
	
	/**
	 * Column Info
	 * @return rf40ftCntrStlTeuCapa
	 */
	public String getRf40ftCntrStlTeuCapa() {
		return this.rf40ftCntrStlTeuCapa;
	}
	
	/**
	 * Column Info
	 * @return hcLd40
	 */
	public String getHcLd40() {
		return this.hcLd40;
	}
	
	/**
	 * Column Info
	 * @return bkgHcBsa45
	 */
	public String getBkgHcBsa45() {
		return this.bkgHcBsa45;
	}
	
	/**
	 * Column Info
	 * @return jo40ftN1stRto
	 */
	public String getJo40ftN1stRto() {
		return this.jo40ftN1stRto;
	}
	
	/**
	 * Column Info
	 * @return rf20Qty
	 */
	public String getRf20Qty() {
		return this.rf20Qty;
	}
	
	/**
	 * Column Info
	 * @return rf40ftCntrStlAmt
	 */
	public String getRf40ftCntrStlAmt() {
		return this.rf40ftCntrStlAmt;
	}
	
	/**
	 * Column Info
	 * @return source
	 */
	public String getSource() {
		return this.source;
	}
	
	/**
	 * Column Info
	 * @return bkgHcBsa40
	 */
	public String getBkgHcBsa40() {
		return this.bkgHcBsa40;
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
	 * @return bkgRfRdrQty
	 */
	public String getBkgRfRdrQty() {
		return this.bkgRfRdrQty;
	}
	
	/**
	 * Column Info
	 * @return bkgRfRdr40Qty
	 */
	public String getBkgRfRdr40Qty() {
		return this.bkgRfRdr40Qty;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
	}
	
	/**
	 * Column Info
	 * @return stlTgtFlg2
	 */
	public String getStlTgtFlg2() {
		return this.stlTgtFlg2;
	}
	
	/**
	 * Column Info
	 * @return hcLd45
	 */
	public String getHcLd45() {
		return this.hcLd45;
	}
	
	/**
	 * Column Info
	 * @return subChk
	 */
	public String getSubChk() {
		return this.subChk;
	}
	
	/**
	 * Column Info
	 * @return rf20ftCntrStlTeuCapa
	 */
	public String getRf20ftCntrStlTeuCapa() {
		return this.rf20ftCntrStlTeuCapa;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return bsaFlg
	 */
	public String getBsaFlg() {
		return this.bsaFlg;
	}
	
	/**
	 * Column Info
	 * @return jo45ftN2ndRto
	 */
	public String getJo45ftN2ndRto() {
		return this.jo45ftN2ndRto;
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
	 * @return revYrmonSeq
	 */
	public String getRevYrmonSeq() {
		return this.revYrmonSeq;
	}
	
	/**
	 * Column Info
	 * @return full20
	 */
	public String getFull20() {
		return this.full20;
	}
	
	/**
	 * Column Info
	 * @return jo45ftN1stRto
	 */
	public String getJo45ftN1stRto() {
		return this.jo45ftN1stRto;
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
	 * @return rf40ftCntrStlRmk
	 */
	public String getRf40ftCntrStlRmk() {
		return this.rf40ftCntrStlRmk;
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
	 * @return overWgt
	 */
	public String getOverWgt() {
		return this.overWgt;
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
	 * @return dgCntrStlAmt
	 */
	public String getDgCntrStlAmt() {
		return this.dgCntrStlAmt;
	}
	
	/**
	 * Column Info
	 * @return mtTeu
	 */
	public String getMtTeu() {
		return this.mtTeu;
	}
	
	/**
	 * Column Info
	 * @return rf20ftCntrStlPrc
	 */
	public String getRf20ftCntrStlPrc() {
		return this.rf20ftCntrStlPrc;
	}
	
	/**
	 * Column Info
	 * @return bkgHcBsa20
	 */
	public String getBkgHcBsa20() {
		return this.bkgHcBsa20;
	}
	
	/**
	 * Column Info
	 * @return rfScgStlTpCd
	 */
	public String getRfScgStlTpCd() {
		return this.rfScgStlTpCd;
	}
	
	/**
	 * Column Info
	 * @return rfRdrQty
	 */
	public String getRfRdrQty() {
		return this.rfRdrQty;
	}
	
	/**
	 * Column Info
	 * @return rf40ftCntrStlPrc
	 */
	public String getRf40ftCntrStlPrc() {
		return this.rf40ftCntrStlPrc;
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
	 * @return mtWt
	 */
	public String getMtWt() {
		return this.mtWt;
	}
	
	/**
	 * Column Info
	 * @return bkgRf40Qty
	 */
	public String getBkgRf40Qty() {
		return this.bkgRf40Qty;
	}
	
	/**
	 * Column Info
	 * @return bkgDg20
	 */
	public String getBkgDg20() {
		return this.bkgDg20;
	}
	
	/**
	 * Column Info
	 * @return rf20ftCntrStlRmk
	 */
	public String getRf20ftCntrStlRmk() {
		return this.rf20ftCntrStlRmk;
	}
	
	/**
	 * Column Info
	 * @return ovrUsdSltPrc
	 */
	public String getOvrUsdSltPrc() {
		return this.ovrUsdSltPrc;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return bkgFull20
	 */
	public String getBkgFull20() {
		return this.bkgFull20;
	}
	
	/**
	 * Column Info
	 * @return allWgt
	 */
	public String getAllWgt() {
		return this.allWgt;
	}
	
	/**
	 * Column Info
	 * @return rfRdr40Qty
	 */
	public String getRfRdr40Qty() {
		return this.rfRdr40Qty;
	}
	
	/**
	 * Column Info
	 * @return dgCntrStlTeuCapa
	 */
	public String getDgCntrStlTeuCapa() {
		return this.dgCntrStlTeuCapa;
	}
	
	/**
	 * Column Info
	 * @return ovrUsdSltRmk
	 */
	public String getOvrUsdSltRmk() {
		return this.ovrUsdSltRmk;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return bkgGrandTtlWgt
	 */
	public String getBkgGrandTtlWgt() {
		return this.bkgGrandTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return full40
	 */
	public String getFull40() {
		return this.full40;
	}
	
	/**
	 * Column Info
	 * @return rdrFlg
	 */
	public String getRdrFlg() {
		return this.rdrFlg;
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
	 * @param grandTtlWgt
	 */
	public void setGrandTtlWgt(String grandTtlWgt) {
		this.grandTtlWgt = grandTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param bkgMt20
	 */
	public void setBkgMt20(String bkgMt20) {
		this.bkgMt20 = bkgMt20;
	}
	
	/**
	 * Column Info
	 * @param rmkFlg
	 */
	public void setRmkFlg(String rmkFlg) {
		this.rmkFlg = rmkFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgHcLd40
	 */
	public void setBkgHcLd40(String bkgHcLd40) {
		this.bkgHcLd40 = bkgHcLd40;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param dg40
	 */
	public void setDg40(String dg40) {
		this.dg40 = dg40;
	}
	
	/**
	 * Column Info
	 * @param robCntrWgt
	 */
	public void setRobCntrWgt(String robCntrWgt) {
		this.robCntrWgt = robCntrWgt;
	}
	
	/**
	 * Column Info
	 * @param rf20ftCntrStlAmt
	 */
	public void setRf20ftCntrStlAmt(String rf20ftCntrStlAmt) {
		this.rf20ftCntrStlAmt = rf20ftCntrStlAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgHcLd45
	 */
	public void setBkgHcLd45(String bkgHcLd45) {
		this.bkgHcLd45 = bkgHcLd45;
	}
	
	/**
	 * Column Info
	 * @param mt20
	 */
	public void setMt20(String mt20) {
		this.mt20 = mt20;
	}
	
	/**
	 * Column Info
	 * @param bkgDg40
	 */
	public void setBkgDg40(String bkgDg40) {
		this.bkgDg40 = bkgDg40;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
	 * @param dgCntrStlRmk
	 */
	public void setDgCntrStlRmk(String dgCntrStlRmk) {
		this.dgCntrStlRmk = dgCntrStlRmk;
	}
	
	/**
	 * Column Info
	 * @param bkgFull40
	 */
	public void setBkgFull40(String bkgFull40) {
		this.bkgFull40 = bkgFull40;
	}
	
	/**
	 * Column Info
	 * @param ovrUsdSltTeuCapa
	 */
	public void setOvrUsdSltTeuCapa(String ovrUsdSltTeuCapa) {
		this.ovrUsdSltTeuCapa = ovrUsdSltTeuCapa;
	}
	
	/**
	 * Column Info
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/**
	 * Column Info
	 * @param dgCntrStlPrc
	 */
	public void setDgCntrStlPrc(String dgCntrStlPrc) {
		this.dgCntrStlPrc = dgCntrStlPrc;
	}
	
	/**
	 * Column Info
	 * @param dg20
	 */
	public void setDg20(String dg20) {
		this.dg20 = dg20;
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
	 * @param bkgRf20Qty
	 */
	public void setBkgRf20Qty(String bkgRf20Qty) {
		this.bkgRf20Qty = bkgRf20Qty;
	}
	
	/**
	 * Column Info
	 * @param ovrUsdSltAmt
	 */
	public void setOvrUsdSltAmt(String ovrUsdSltAmt) {
		this.ovrUsdSltAmt = ovrUsdSltAmt;
	}
	
	/**
	 * Column Info
	 * @param hcBsa45
	 */
	public void setHcBsa45(String hcBsa45) {
		this.hcBsa45 = hcBsa45;
	}
	
	/**
	 * Column Info
	 * @param hcBsa40
	 */
	public void setHcBsa40(String hcBsa40) {
		this.hcBsa40 = hcBsa40;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	
	/**
	 * Column Info
	 * @param teuQty
	 */
	public void setTeuQty(String teuQty) {
		this.teuQty = teuQty;
	}
	
	/**
	 * Column Info
	 * @param bkgAkUnit
	 */
	public void setBkgAkUnit(String bkgAkUnit) {
		this.bkgAkUnit = bkgAkUnit;
	}
	
	/**
	 * Column Info
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
	}
	
	/**
	 * Column Info
	 * @param grandTtlSlot
	 */
	public void setGrandTtlSlot(String grandTtlSlot) {
		this.grandTtlSlot = grandTtlSlot;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param bkgMt40
	 */
	public void setBkgMt40(String bkgMt40) {
		this.bkgMt40 = bkgMt40;
	}
	
	/**
	 * Column Info
	 * @param bkgHcLd20
	 */
	public void setBkgHcLd20(String bkgHcLd20) {
		this.bkgHcLd20 = bkgHcLd20;
	}
	
	/**
	 * Column Info
	 * @param jo20ftN1stRto
	 */
	public void setJo20ftN1stRto(String jo20ftN1stRto) {
		this.jo20ftN1stRto = jo20ftN1stRto;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param akVoid
	 */
	public void setAkVoid(String akVoid) {
		this.akVoid = akVoid;
	}
	
	/**
	 * Column Info
	 * @param mt40
	 */
	public void setMt40(String mt40) {
		this.mt40 = mt40;
	}
	
	/**
	 * Column Info
	 * @param stlTgtFlg
	 */
	public void setStlTgtFlg(String stlTgtFlg) {
		this.stlTgtFlg = stlTgtFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgAkVoid
	 */
	public void setBkgAkVoid(String bkgAkVoid) {
		this.bkgAkVoid = bkgAkVoid;
	}
	
	/**
	 * Column Info
	 * @param akUnit
	 */
	public void setAkUnit(String akUnit) {
		this.akUnit = akUnit;
	}
	
	/**
	 * Column Info
	 * @param hcLd20
	 */
	public void setHcLd20(String hcLd20) {
		this.hcLd20 = hcLd20;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param allTeu
	 */
	public void setAllTeu(String allTeu) {
		this.allTeu = allTeu;
	}
	
	/**
	 * Column Info
	 * @param rf40Qty
	 */
	public void setRf40Qty(String rf40Qty) {
		this.rf40Qty = rf40Qty;
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
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param finUsed
	 */
	public void setFinUsed(String finUsed) {
		this.finUsed = finUsed;
	}
	
	/**
	 * Column Info
	 * @param overSlot
	 */
	public void setOverSlot(String overSlot) {
		this.overSlot = overSlot;
	}
	
	/**
	 * Column Info
	 * @param hcBsa20
	 */
	public void setHcBsa20(String hcBsa20) {
		this.hcBsa20 = hcBsa20;
	}
	
	/**
	 * Column Info
	 * @param portSkdSts
	 */
	public void setPortSkdSts(String portSkdSts) {
		this.portSkdSts = portSkdSts;
	}
	
	/**
	 * Column Info
	 * @param rf40ftCntrStlTeuCapa
	 */
	public void setRf40ftCntrStlTeuCapa(String rf40ftCntrStlTeuCapa) {
		this.rf40ftCntrStlTeuCapa = rf40ftCntrStlTeuCapa;
	}
	
	/**
	 * Column Info
	 * @param hcLd40
	 */
	public void setHcLd40(String hcLd40) {
		this.hcLd40 = hcLd40;
	}
	
	/**
	 * Column Info
	 * @param bkgHcBsa45
	 */
	public void setBkgHcBsa45(String bkgHcBsa45) {
		this.bkgHcBsa45 = bkgHcBsa45;
	}
	
	/**
	 * Column Info
	 * @param jo40ftN1stRto
	 */
	public void setJo40ftN1stRto(String jo40ftN1stRto) {
		this.jo40ftN1stRto = jo40ftN1stRto;
	}
	
	/**
	 * Column Info
	 * @param rf20Qty
	 */
	public void setRf20Qty(String rf20Qty) {
		this.rf20Qty = rf20Qty;
	}
	
	/**
	 * Column Info
	 * @param rf40ftCntrStlAmt
	 */
	public void setRf40ftCntrStlAmt(String rf40ftCntrStlAmt) {
		this.rf40ftCntrStlAmt = rf40ftCntrStlAmt;
	}
	
	/**
	 * Column Info
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Column Info
	 * @param bkgHcBsa40
	 */
	public void setBkgHcBsa40(String bkgHcBsa40) {
		this.bkgHcBsa40 = bkgHcBsa40;
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
	 * @param bkgRfRdrQty
	 */
	public void setBkgRfRdrQty(String bkgRfRdrQty) {
		this.bkgRfRdrQty = bkgRfRdrQty;
	}
	
	/**
	 * Column Info
	 * @param bkgRfRdr40Qty
	 */
	public void setBkgRfRdr40Qty(String bkgRfRdr40Qty) {
		this.bkgRfRdr40Qty = bkgRfRdr40Qty;
	}
	
	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	/**
	 * Column Info
	 * @param stlTgtFlg2
	 */
	public void setStlTgtFlg2(String stlTgtFlg2) {
		this.stlTgtFlg2 = stlTgtFlg2;
	}
	
	/**
	 * Column Info
	 * @param hcLd45
	 */
	public void setHcLd45(String hcLd45) {
		this.hcLd45 = hcLd45;
	}
	
	/**
	 * Column Info
	 * @param subChk
	 */
	public void setSubChk(String subChk) {
		this.subChk = subChk;
	}
	
	/**
	 * Column Info
	 * @param rf20ftCntrStlTeuCapa
	 */
	public void setRf20ftCntrStlTeuCapa(String rf20ftCntrStlTeuCapa) {
		this.rf20ftCntrStlTeuCapa = rf20ftCntrStlTeuCapa;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param bsaFlg
	 */
	public void setBsaFlg(String bsaFlg) {
		this.bsaFlg = bsaFlg;
	}
	
	/**
	 * Column Info
	 * @param jo45ftN2ndRto
	 */
	public void setJo45ftN2ndRto(String jo45ftN2ndRto) {
		this.jo45ftN2ndRto = jo45ftN2ndRto;
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
	 * @param revYrmonSeq
	 */
	public void setRevYrmonSeq(String revYrmonSeq) {
		this.revYrmonSeq = revYrmonSeq;
	}
	
	/**
	 * Column Info
	 * @param full20
	 */
	public void setFull20(String full20) {
		this.full20 = full20;
	}
	
	/**
	 * Column Info
	 * @param jo45ftN1stRto
	 */
	public void setJo45ftN1stRto(String jo45ftN1stRto) {
		this.jo45ftN1stRto = jo45ftN1stRto;
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
	 * @param rf40ftCntrStlRmk
	 */
	public void setRf40ftCntrStlRmk(String rf40ftCntrStlRmk) {
		this.rf40ftCntrStlRmk = rf40ftCntrStlRmk;
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
	 * @param overWgt
	 */
	public void setOverWgt(String overWgt) {
		this.overWgt = overWgt;
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
	 * @param dgCntrStlAmt
	 */
	public void setDgCntrStlAmt(String dgCntrStlAmt) {
		this.dgCntrStlAmt = dgCntrStlAmt;
	}
	
	/**
	 * Column Info
	 * @param mtTeu
	 */
	public void setMtTeu(String mtTeu) {
		this.mtTeu = mtTeu;
	}
	
	/**
	 * Column Info
	 * @param rf20ftCntrStlPrc
	 */
	public void setRf20ftCntrStlPrc(String rf20ftCntrStlPrc) {
		this.rf20ftCntrStlPrc = rf20ftCntrStlPrc;
	}
	
	/**
	 * Column Info
	 * @param bkgHcBsa20
	 */
	public void setBkgHcBsa20(String bkgHcBsa20) {
		this.bkgHcBsa20 = bkgHcBsa20;
	}
	
	/**
	 * Column Info
	 * @param rfScgStlTpCd
	 */
	public void setRfScgStlTpCd(String rfScgStlTpCd) {
		this.rfScgStlTpCd = rfScgStlTpCd;
	}
	
	/**
	 * Column Info
	 * @param rfRdrQty
	 */
	public void setRfRdrQty(String rfRdrQty) {
		this.rfRdrQty = rfRdrQty;
	}
	
	/**
	 * Column Info
	 * @param rf40ftCntrStlPrc
	 */
	public void setRf40ftCntrStlPrc(String rf40ftCntrStlPrc) {
		this.rf40ftCntrStlPrc = rf40ftCntrStlPrc;
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
	 * @param mtWt
	 */
	public void setMtWt(String mtWt) {
		this.mtWt = mtWt;
	}
	
	/**
	 * Column Info
	 * @param bkgRf40Qty
	 */
	public void setBkgRf40Qty(String bkgRf40Qty) {
		this.bkgRf40Qty = bkgRf40Qty;
	}
	
	/**
	 * Column Info
	 * @param bkgDg20
	 */
	public void setBkgDg20(String bkgDg20) {
		this.bkgDg20 = bkgDg20;
	}
	
	/**
	 * Column Info
	 * @param rf20ftCntrStlRmk
	 */
	public void setRf20ftCntrStlRmk(String rf20ftCntrStlRmk) {
		this.rf20ftCntrStlRmk = rf20ftCntrStlRmk;
	}
	
	/**
	 * Column Info
	 * @param ovrUsdSltPrc
	 */
	public void setOvrUsdSltPrc(String ovrUsdSltPrc) {
		this.ovrUsdSltPrc = ovrUsdSltPrc;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param bkgFull20
	 */
	public void setBkgFull20(String bkgFull20) {
		this.bkgFull20 = bkgFull20;
	}
	
	/**
	 * Column Info
	 * @param allWgt
	 */
	public void setAllWgt(String allWgt) {
		this.allWgt = allWgt;
	}
	
	/**
	 * Column Info
	 * @param rfRdr40Qty
	 */
	public void setRfRdr40Qty(String rfRdr40Qty) {
		this.rfRdr40Qty = rfRdr40Qty;
	}
	
	/**
	 * Column Info
	 * @param dgCntrStlTeuCapa
	 */
	public void setDgCntrStlTeuCapa(String dgCntrStlTeuCapa) {
		this.dgCntrStlTeuCapa = dgCntrStlTeuCapa;
	}
	
	/**
	 * Column Info
	 * @param ovrUsdSltRmk
	 */
	public void setOvrUsdSltRmk(String ovrUsdSltRmk) {
		this.ovrUsdSltRmk = ovrUsdSltRmk;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param bkgGrandTtlWgt
	 */
	public void setBkgGrandTtlWgt(String bkgGrandTtlWgt) {
		this.bkgGrandTtlWgt = bkgGrandTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param full40
	 */
	public void setFull40(String full40) {
		this.full40 = full40;
	}
	
	/**
	 * Column Info
	 * @param rdrFlg
	 */
	public void setRdrFlg(String rdrFlg) {
		this.rdrFlg = rdrFlg;
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
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setGrandTtlWgt(JSPUtil.getParameter(request, prefix + "grand_ttl_wgt", ""));
		setBkgMt20(JSPUtil.getParameter(request, prefix + "bkg_mt_20", ""));
		setRmkFlg(JSPUtil.getParameter(request, prefix + "rmk_flg", ""));
		setBkgHcLd40(JSPUtil.getParameter(request, prefix + "bkg_hc_ld_40", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDg40(JSPUtil.getParameter(request, prefix + "dg_40", ""));
		setRobCntrWgt(JSPUtil.getParameter(request, prefix + "rob_cntr_wgt", ""));
		setRf20ftCntrStlAmt(JSPUtil.getParameter(request, prefix + "rf_20ft_cntr_stl_amt", ""));
		setBkgHcLd45(JSPUtil.getParameter(request, prefix + "bkg_hc_ld_45", ""));
		setMt20(JSPUtil.getParameter(request, prefix + "mt_20", ""));
		setBkgDg40(JSPUtil.getParameter(request, prefix + "bkg_dg_40", ""));
		setAcctYrmon(JSPUtil.getParameter(request, prefix + "acct_yrmon", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setStlClzFlg(JSPUtil.getParameter(request, prefix + "stl_clz_flg", ""));
		setDgCntrStlRmk(JSPUtil.getParameter(request, prefix + "dg_cntr_stl_rmk", ""));
		setBkgFull40(JSPUtil.getParameter(request, prefix + "bkg_full_40", ""));
		setOvrUsdSltTeuCapa(JSPUtil.getParameter(request, prefix + "ovr_usd_slt_teu_capa", ""));
		setPass(JSPUtil.getParameter(request, prefix + "pass", ""));
		setDgCntrStlPrc(JSPUtil.getParameter(request, prefix + "dg_cntr_stl_prc", ""));
		setDg20(JSPUtil.getParameter(request, prefix + "dg_20", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setBkgRf20Qty(JSPUtil.getParameter(request, prefix + "bkg_rf_20_qty", ""));
		setOvrUsdSltAmt(JSPUtil.getParameter(request, prefix + "ovr_usd_slt_amt", ""));
		setHcBsa45(JSPUtil.getParameter(request, prefix + "hc_bsa_45", ""));
		setHcBsa40(JSPUtil.getParameter(request, prefix + "hc_bsa_40", ""));
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setTeuQty(JSPUtil.getParameter(request, prefix + "teu_qty", ""));
		setBkgAkUnit(JSPUtil.getParameter(request, prefix + "bkg_ak_unit", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setGrandTtlSlot(JSPUtil.getParameter(request, prefix + "grand_ttl_slot", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setBkgMt40(JSPUtil.getParameter(request, prefix + "bkg_mt_40", ""));
		setBkgHcLd20(JSPUtil.getParameter(request, prefix + "bkg_hc_ld_20", ""));
		setJo20ftN1stRto(JSPUtil.getParameter(request, prefix + "jo_20ft_n1st_rto", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setAkVoid(JSPUtil.getParameter(request, prefix + "ak_void", ""));
		setMt40(JSPUtil.getParameter(request, prefix + "mt_40", ""));
		setStlTgtFlg(JSPUtil.getParameter(request, prefix + "stl_tgt_flg", ""));
		setBkgAkVoid(JSPUtil.getParameter(request, prefix + "bkg_ak_void", ""));
		setAkUnit(JSPUtil.getParameter(request, prefix + "ak_unit", ""));
		setHcLd20(JSPUtil.getParameter(request, prefix + "hc_ld_20", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setAllTeu(JSPUtil.getParameter(request, prefix + "all_teu", ""));
		setRf40Qty(JSPUtil.getParameter(request, prefix + "rf_40_qty", ""));
		setStlVvdSeq(JSPUtil.getParameter(request, prefix + "stl_vvd_seq", ""));
		setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
		setFinUsed(JSPUtil.getParameter(request, prefix + "fin_used", ""));
		setOverSlot(JSPUtil.getParameter(request, prefix + "over_slot", ""));
		setHcBsa20(JSPUtil.getParameter(request, prefix + "hc_bsa_20", ""));
		setPortSkdSts(JSPUtil.getParameter(request, prefix + "port_skd_sts", ""));
		setRf40ftCntrStlTeuCapa(JSPUtil.getParameter(request, prefix + "rf_40ft_cntr_stl_teu_capa", ""));
		setHcLd40(JSPUtil.getParameter(request, prefix + "hc_ld_40", ""));
		setBkgHcBsa45(JSPUtil.getParameter(request, prefix + "bkg_hc_bsa_45", ""));
		setJo40ftN1stRto(JSPUtil.getParameter(request, prefix + "jo_40ft_n1st_rto", ""));
		setRf20Qty(JSPUtil.getParameter(request, prefix + "rf_20_qty", ""));
		setRf40ftCntrStlAmt(JSPUtil.getParameter(request, prefix + "rf_40ft_cntr_stl_amt", ""));
		setSource(JSPUtil.getParameter(request, prefix + "source", ""));
		setBkgHcBsa40(JSPUtil.getParameter(request, prefix + "bkg_hc_bsa_40", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setBkgRfRdrQty(JSPUtil.getParameter(request, prefix + "bkg_rf_rdr_qty", ""));
		setBkgRfRdr40Qty(JSPUtil.getParameter(request, prefix + "bkg_rf_rdr_40_qty", ""));
		setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
		setStlTgtFlg2(JSPUtil.getParameter(request, prefix + "stl_tgt_flg2", ""));
		setHcLd45(JSPUtil.getParameter(request, prefix + "hc_ld_45", ""));
		setSubChk(JSPUtil.getParameter(request, prefix + "sub_chk", ""));
		setRf20ftCntrStlTeuCapa(JSPUtil.getParameter(request, prefix + "rf_20ft_cntr_stl_teu_capa", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setJo20ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_20ft_sub_teu_qty", ""));
		setBsaFlg(JSPUtil.getParameter(request, prefix + "bsa_flg", ""));
		setJo45ftN2ndRto(JSPUtil.getParameter(request, prefix + "jo_45ft_n2nd_rto", ""));
		setJo40ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_40ft_sub_teu_qty", ""));
		setRevYrmonSeq(JSPUtil.getParameter(request, prefix + "rev_yrmon_seq", ""));
		setFull20(JSPUtil.getParameter(request, prefix + "full_20", ""));
		setJo45ftN1stRto(JSPUtil.getParameter(request, prefix + "jo_45ft_n1st_rto", ""));
		setJoRndRuleLvl(JSPUtil.getParameter(request, prefix + "jo_rnd_rule_lvl", ""));
		setRf40ftCntrStlRmk(JSPUtil.getParameter(request, prefix + "rf_40ft_cntr_stl_rmk", ""));
		setJoFshFlg(JSPUtil.getParameter(request, prefix + "jo_fsh_flg", ""));
		setOverWgt(JSPUtil.getParameter(request, prefix + "over_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDgCntrStlAmt(JSPUtil.getParameter(request, prefix + "dg_cntr_stl_amt", ""));
		setMtTeu(JSPUtil.getParameter(request, prefix + "mt_teu", ""));
		setRf20ftCntrStlPrc(JSPUtil.getParameter(request, prefix + "rf_20ft_cntr_stl_prc", ""));
		setBkgHcBsa20(JSPUtil.getParameter(request, prefix + "bkg_hc_bsa_20", ""));
		setRfScgStlTpCd(JSPUtil.getParameter(request, prefix + "rf_scg_stl_tp_cd", ""));
		setRfRdrQty(JSPUtil.getParameter(request, prefix + "rf_rdr_qty", ""));
		setRf40ftCntrStlPrc(JSPUtil.getParameter(request, prefix + "rf_40ft_cntr_stl_prc", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setMtWt(JSPUtil.getParameter(request, prefix + "mt_wt", ""));
		setBkgRf40Qty(JSPUtil.getParameter(request, prefix + "bkg_rf_40_qty", ""));
		setBkgDg20(JSPUtil.getParameter(request, prefix + "bkg_dg_20", ""));
		setRf20ftCntrStlRmk(JSPUtil.getParameter(request, prefix + "rf_20ft_cntr_stl_rmk", ""));
		setOvrUsdSltPrc(JSPUtil.getParameter(request, prefix + "ovr_usd_slt_prc", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setBkgFull20(JSPUtil.getParameter(request, prefix + "bkg_full_20", ""));
		setAllWgt(JSPUtil.getParameter(request, prefix + "all_wgt", ""));
		setRfRdr40Qty(JSPUtil.getParameter(request, prefix + "rf_rdr_40_qty", ""));
		setDgCntrStlTeuCapa(JSPUtil.getParameter(request, prefix + "dg_cntr_stl_teu_capa", ""));
		setOvrUsdSltRmk(JSPUtil.getParameter(request, prefix + "ovr_usd_slt_rmk", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setJo45ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_45ft_sub_teu_qty", ""));
		setBkgGrandTtlWgt(JSPUtil.getParameter(request, prefix + "bkg_grand_ttl_wgt", ""));
		setFull40(JSPUtil.getParameter(request, prefix + "full_40", ""));
		setRdrFlg(JSPUtil.getParameter(request, prefix + "rdr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JoLoadingVO[]
	 */
	public JoLoadingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	} 

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JoLoadingVO[]
	 */
	public JoLoadingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JoLoadingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] grandTtlWgt = (JSPUtil.getParameter(request, prefix	+ "grand_ttl_wgt", length));
			String[] bkgMt20 = (JSPUtil.getParameter(request, prefix	+ "bkg_mt_20", length));
			String[] rmkFlg = (JSPUtil.getParameter(request, prefix	+ "rmk_flg", length));
			String[] bkgHcLd40 = (JSPUtil.getParameter(request, prefix	+ "bkg_hc_ld_40", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dg40 = (JSPUtil.getParameter(request, prefix	+ "dg_40", length));
			String[] robCntrWgt = (JSPUtil.getParameter(request, prefix	+ "rob_cntr_wgt", length));
			String[] rf20ftCntrStlAmt = (JSPUtil.getParameter(request, prefix	+ "rf_20ft_cntr_stl_amt", length));
			String[] bkgHcLd45 = (JSPUtil.getParameter(request, prefix	+ "bkg_hc_ld_45", length));
			String[] mt20 = (JSPUtil.getParameter(request, prefix	+ "mt_20", length));
			String[] bkgDg40 = (JSPUtil.getParameter(request, prefix	+ "bkg_dg_40", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] stlClzFlg = (JSPUtil.getParameter(request, prefix	+ "stl_clz_flg", length));
			String[] dgCntrStlRmk = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_stl_rmk", length));
			String[] bkgFull40 = (JSPUtil.getParameter(request, prefix	+ "bkg_full_40", length));
			String[] ovrUsdSltTeuCapa = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_slt_teu_capa", length));
			String[] pass = (JSPUtil.getParameter(request, prefix	+ "pass", length));
			String[] dgCntrStlPrc = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_stl_prc", length));
			String[] dg20 = (JSPUtil.getParameter(request, prefix	+ "dg_20", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bkgRf20Qty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_20_qty", length));
			String[] ovrUsdSltAmt = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_slt_amt", length));
			String[] hcBsa45 = (JSPUtil.getParameter(request, prefix	+ "hc_bsa_45", length));
			String[] hcBsa40 = (JSPUtil.getParameter(request, prefix	+ "hc_bsa_40", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] teuQty = (JSPUtil.getParameter(request, prefix	+ "teu_qty", length));
			String[] bkgAkUnit = (JSPUtil.getParameter(request, prefix	+ "bkg_ak_unit", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] grandTtlSlot = (JSPUtil.getParameter(request, prefix	+ "grand_ttl_slot", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] bkgMt40 = (JSPUtil.getParameter(request, prefix	+ "bkg_mt_40", length));
			String[] bkgHcLd20 = (JSPUtil.getParameter(request, prefix	+ "bkg_hc_ld_20", length));
			String[] jo20ftN1stRto = (JSPUtil.getParameter(request, prefix	+ "jo_20ft_n1st_rto", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] akVoid = (JSPUtil.getParameter(request, prefix	+ "ak_void", length));
			String[] mt40 = (JSPUtil.getParameter(request, prefix	+ "mt_40", length));
			String[] stlTgtFlg = (JSPUtil.getParameter(request, prefix	+ "stl_tgt_flg", length));
			String[] bkgAkVoid = (JSPUtil.getParameter(request, prefix	+ "bkg_ak_void", length));
			String[] akUnit = (JSPUtil.getParameter(request, prefix	+ "ak_unit", length));
			String[] hcLd20 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_20", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] allTeu = (JSPUtil.getParameter(request, prefix	+ "all_teu", length));
			String[] rf40Qty = (JSPUtil.getParameter(request, prefix	+ "rf_40_qty", length));
			String[] stlVvdSeq = (JSPUtil.getParameter(request, prefix	+ "stl_vvd_seq", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] finUsed = (JSPUtil.getParameter(request, prefix	+ "fin_used", length));
			String[] overSlot = (JSPUtil.getParameter(request, prefix	+ "over_slot", length));
			String[] hcBsa20 = (JSPUtil.getParameter(request, prefix	+ "hc_bsa_20", length));
			String[] portSkdSts = (JSPUtil.getParameter(request, prefix	+ "port_skd_sts", length));
			String[] rf40ftCntrStlTeuCapa = (JSPUtil.getParameter(request, prefix	+ "rf_40ft_cntr_stl_teu_capa", length));
			String[] hcLd40 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_40", length));
			String[] bkgHcBsa45 = (JSPUtil.getParameter(request, prefix	+ "bkg_hc_bsa_45", length));
			String[] jo40ftN1stRto = (JSPUtil.getParameter(request, prefix	+ "jo_40ft_n1st_rto", length));
			String[] rf20Qty = (JSPUtil.getParameter(request, prefix	+ "rf_20_qty", length));
			String[] rf40ftCntrStlAmt = (JSPUtil.getParameter(request, prefix	+ "rf_40ft_cntr_stl_amt", length));
			String[] source = (JSPUtil.getParameter(request, prefix	+ "source", length));
			String[] bkgHcBsa40 = (JSPUtil.getParameter(request, prefix	+ "bkg_hc_bsa_40", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] bkgRfRdrQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_rdr_qty", length));
			String[] bkgRfRdr40Qty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_rdr_40_qty", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] stlTgtFlg2 = (JSPUtil.getParameter(request, prefix	+ "stl_tgt_flg2", length));
			String[] hcLd45 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_45", length));
			String[] subChk = (JSPUtil.getParameter(request, prefix	+ "sub_chk", length));
			String[] rf20ftCntrStlTeuCapa = (JSPUtil.getParameter(request, prefix	+ "rf_20ft_cntr_stl_teu_capa", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] jo20ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_20ft_sub_teu_qty", length));
			String[] bsaFlg = (JSPUtil.getParameter(request, prefix	+ "bsa_flg", length));
			String[] jo45ftN2ndRto = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_n2nd_rto", length));
			String[] jo40ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_40ft_sub_teu_qty", length));
			String[] revYrmonSeq = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon_seq", length));
			String[] full20 = (JSPUtil.getParameter(request, prefix	+ "full_20", length));
			String[] jo45ftN1stRto = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_n1st_rto", length));
			String[] joRndRuleLvl = (JSPUtil.getParameter(request, prefix	+ "jo_rnd_rule_lvl", length));
			String[] rf40ftCntrStlRmk = (JSPUtil.getParameter(request, prefix	+ "rf_40ft_cntr_stl_rmk", length));
			String[] joFshFlg = (JSPUtil.getParameter(request, prefix	+ "jo_fsh_flg", length));
			String[] overWgt = (JSPUtil.getParameter(request, prefix	+ "over_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dgCntrStlAmt = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_stl_amt", length));
			String[] mtTeu = (JSPUtil.getParameter(request, prefix	+ "mt_teu", length));
			String[] rf20ftCntrStlPrc = (JSPUtil.getParameter(request, prefix	+ "rf_20ft_cntr_stl_prc", length));
			String[] bkgHcBsa20 = (JSPUtil.getParameter(request, prefix	+ "bkg_hc_bsa_20", length));
			String[] rfScgStlTpCd = (JSPUtil.getParameter(request, prefix	+ "rf_scg_stl_tp_cd", length));
			String[] rfRdrQty = (JSPUtil.getParameter(request, prefix	+ "rf_rdr_qty", length));
			String[] rf40ftCntrStlPrc = (JSPUtil.getParameter(request, prefix	+ "rf_40ft_cntr_stl_prc", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] mtWt = (JSPUtil.getParameter(request, prefix	+ "mt_wt", length));
			String[] bkgRf40Qty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_40_qty", length));
			String[] bkgDg20 = (JSPUtil.getParameter(request, prefix	+ "bkg_dg_20", length));
			String[] rf20ftCntrStlRmk = (JSPUtil.getParameter(request, prefix	+ "rf_20ft_cntr_stl_rmk", length));
			String[] ovrUsdSltPrc = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_slt_prc", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] bkgFull20 = (JSPUtil.getParameter(request, prefix	+ "bkg_full_20", length));
			String[] allWgt = (JSPUtil.getParameter(request, prefix	+ "all_wgt", length));
			String[] rfRdr40Qty = (JSPUtil.getParameter(request, prefix	+ "rf_rdr_40_qty", length));
			String[] dgCntrStlTeuCapa = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_stl_teu_capa", length));
			String[] ovrUsdSltRmk = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_slt_rmk", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] jo45ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_sub_teu_qty", length));
			String[] bkgGrandTtlWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_grand_ttl_wgt", length));
			String[] full40 = (JSPUtil.getParameter(request, prefix	+ "full_40", length));
			String[] rdrFlg = (JSPUtil.getParameter(request, prefix	+ "rdr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new JoLoadingVO();
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (grandTtlWgt[i] != null)
					model.setGrandTtlWgt(grandTtlWgt[i]);
				if (bkgMt20[i] != null)
					model.setBkgMt20(bkgMt20[i]);
				if (rmkFlg[i] != null)
					model.setRmkFlg(rmkFlg[i]);
				if (bkgHcLd40[i] != null)
					model.setBkgHcLd40(bkgHcLd40[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dg40[i] != null)
					model.setDg40(dg40[i]);
				if (robCntrWgt[i] != null)
					model.setRobCntrWgt(robCntrWgt[i]);
				if (rf20ftCntrStlAmt[i] != null)
					model.setRf20ftCntrStlAmt(rf20ftCntrStlAmt[i]);
				if (bkgHcLd45[i] != null)
					model.setBkgHcLd45(bkgHcLd45[i]);
				if (mt20[i] != null)
					model.setMt20(mt20[i]);
				if (bkgDg40[i] != null)
					model.setBkgDg40(bkgDg40[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (stlClzFlg[i] != null)
					model.setStlClzFlg(stlClzFlg[i]);
				if (dgCntrStlRmk[i] != null)
					model.setDgCntrStlRmk(dgCntrStlRmk[i]);
				if (bkgFull40[i] != null)
					model.setBkgFull40(bkgFull40[i]);
				if (ovrUsdSltTeuCapa[i] != null)
					model.setOvrUsdSltTeuCapa(ovrUsdSltTeuCapa[i]);
				if (pass[i] != null)
					model.setPass(pass[i]);
				if (dgCntrStlPrc[i] != null)
					model.setDgCntrStlPrc(dgCntrStlPrc[i]);
				if (dg20[i] != null)
					model.setDg20(dg20[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bkgRf20Qty[i] != null)
					model.setBkgRf20Qty(bkgRf20Qty[i]);
				if (ovrUsdSltAmt[i] != null)
					model.setOvrUsdSltAmt(ovrUsdSltAmt[i]);
				if (hcBsa45[i] != null)
					model.setHcBsa45(hcBsa45[i]);
				if (hcBsa40[i] != null)
					model.setHcBsa40(hcBsa40[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (teuQty[i] != null)
					model.setTeuQty(teuQty[i]);
				if (bkgAkUnit[i] != null)
					model.setBkgAkUnit(bkgAkUnit[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (grandTtlSlot[i] != null)
					model.setGrandTtlSlot(grandTtlSlot[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (bkgMt40[i] != null)
					model.setBkgMt40(bkgMt40[i]);
				if (bkgHcLd20[i] != null)
					model.setBkgHcLd20(bkgHcLd20[i]);
				if (jo20ftN1stRto[i] != null)
					model.setJo20ftN1stRto(jo20ftN1stRto[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (akVoid[i] != null)
					model.setAkVoid(akVoid[i]);
				if (mt40[i] != null)
					model.setMt40(mt40[i]);
				if (stlTgtFlg[i] != null)
					model.setStlTgtFlg(stlTgtFlg[i]);
				if (bkgAkVoid[i] != null)
					model.setBkgAkVoid(bkgAkVoid[i]);
				if (akUnit[i] != null)
					model.setAkUnit(akUnit[i]);
				if (hcLd20[i] != null)
					model.setHcLd20(hcLd20[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (allTeu[i] != null)
					model.setAllTeu(allTeu[i]);
				if (rf40Qty[i] != null)
					model.setRf40Qty(rf40Qty[i]);
				if (stlVvdSeq[i] != null)
					model.setStlVvdSeq(stlVvdSeq[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (finUsed[i] != null)
					model.setFinUsed(finUsed[i]);
				if (overSlot[i] != null)
					model.setOverSlot(overSlot[i]);
				if (hcBsa20[i] != null)
					model.setHcBsa20(hcBsa20[i]);
				if (portSkdSts[i] != null)
					model.setPortSkdSts(portSkdSts[i]);
				if (rf40ftCntrStlTeuCapa[i] != null)
					model.setRf40ftCntrStlTeuCapa(rf40ftCntrStlTeuCapa[i]);
				if (hcLd40[i] != null)
					model.setHcLd40(hcLd40[i]);
				if (bkgHcBsa45[i] != null)
					model.setBkgHcBsa45(bkgHcBsa45[i]);
				if (jo40ftN1stRto[i] != null)
					model.setJo40ftN1stRto(jo40ftN1stRto[i]);
				if (rf20Qty[i] != null)
					model.setRf20Qty(rf20Qty[i]);
				if (rf40ftCntrStlAmt[i] != null)
					model.setRf40ftCntrStlAmt(rf40ftCntrStlAmt[i]);
				if (source[i] != null)
					model.setSource(source[i]);
				if (bkgHcBsa40[i] != null)
					model.setBkgHcBsa40(bkgHcBsa40[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (bkgRfRdrQty[i] != null)
					model.setBkgRfRdrQty(bkgRfRdrQty[i]);
				if (bkgRfRdr40Qty[i] != null)
					model.setBkgRfRdr40Qty(bkgRfRdr40Qty[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (stlTgtFlg2[i] != null)
					model.setStlTgtFlg2(stlTgtFlg2[i]);
				if (hcLd45[i] != null)
					model.setHcLd45(hcLd45[i]);
				if (subChk[i] != null)
					model.setSubChk(subChk[i]);
				if (rf20ftCntrStlTeuCapa[i] != null)
					model.setRf20ftCntrStlTeuCapa(rf20ftCntrStlTeuCapa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (jo20ftSubTeuQty[i] != null)
					model.setJo20ftSubTeuQty(jo20ftSubTeuQty[i]);
				if (bsaFlg[i] != null)
					model.setBsaFlg(bsaFlg[i]);
				if (jo45ftN2ndRto[i] != null)
					model.setJo45ftN2ndRto(jo45ftN2ndRto[i]);
				if (jo40ftSubTeuQty[i] != null)
					model.setJo40ftSubTeuQty(jo40ftSubTeuQty[i]);
				if (revYrmonSeq[i] != null)
					model.setRevYrmonSeq(revYrmonSeq[i]);
				if (full20[i] != null)
					model.setFull20(full20[i]);
				if (jo45ftN1stRto[i] != null)
					model.setJo45ftN1stRto(jo45ftN1stRto[i]);
				if (joRndRuleLvl[i] != null)
					model.setJoRndRuleLvl(joRndRuleLvl[i]);
				if (rf40ftCntrStlRmk[i] != null)
					model.setRf40ftCntrStlRmk(rf40ftCntrStlRmk[i]);
				if (joFshFlg[i] != null)
					model.setJoFshFlg(joFshFlg[i]);
				if (overWgt[i] != null)
					model.setOverWgt(overWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dgCntrStlAmt[i] != null)
					model.setDgCntrStlAmt(dgCntrStlAmt[i]);
				if (mtTeu[i] != null)
					model.setMtTeu(mtTeu[i]);
				if (rf20ftCntrStlPrc[i] != null)
					model.setRf20ftCntrStlPrc(rf20ftCntrStlPrc[i]);
				if (bkgHcBsa20[i] != null)
					model.setBkgHcBsa20(bkgHcBsa20[i]);
				if (rfScgStlTpCd[i] != null)
					model.setRfScgStlTpCd(rfScgStlTpCd[i]);
				if (rfRdrQty[i] != null)
					model.setRfRdrQty(rfRdrQty[i]);
				if (rf40ftCntrStlPrc[i] != null)
					model.setRf40ftCntrStlPrc(rf40ftCntrStlPrc[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (mtWt[i] != null)
					model.setMtWt(mtWt[i]);
				if (bkgRf40Qty[i] != null)
					model.setBkgRf40Qty(bkgRf40Qty[i]);
				if (bkgDg20[i] != null)
					model.setBkgDg20(bkgDg20[i]);
				if (rf20ftCntrStlRmk[i] != null)
					model.setRf20ftCntrStlRmk(rf20ftCntrStlRmk[i]);
				if (ovrUsdSltPrc[i] != null)
					model.setOvrUsdSltPrc(ovrUsdSltPrc[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bkgFull20[i] != null)
					model.setBkgFull20(bkgFull20[i]);
				if (allWgt[i] != null)
					model.setAllWgt(allWgt[i]);
				if (rfRdr40Qty[i] != null)
					model.setRfRdr40Qty(rfRdr40Qty[i]);
				if (dgCntrStlTeuCapa[i] != null)
					model.setDgCntrStlTeuCapa(dgCntrStlTeuCapa[i]);
				if (ovrUsdSltRmk[i] != null)
					model.setOvrUsdSltRmk(ovrUsdSltRmk[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (jo45ftSubTeuQty[i] != null)
					model.setJo45ftSubTeuQty(jo45ftSubTeuQty[i]);
				if (bkgGrandTtlWgt[i] != null)
					model.setBkgGrandTtlWgt(bkgGrandTtlWgt[i]);
				if (full40[i] != null)
					model.setFull40(full40[i]);
				if (rdrFlg[i] != null)
					model.setRdrFlg(rdrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJoLoadingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JoLoadingVO[]
	 */
	public JoLoadingVO[] getJoLoadingVOs(){
		JoLoadingVO[] vos = (JoLoadingVO[])models.toArray(new JoLoadingVO[models.size()]);
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
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grandTtlWgt = this.grandTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMt20 = this.bkgMt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmkFlg = this.rmkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHcLd40 = this.bkgHcLd40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40 = this.dg40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.robCntrWgt = this.robCntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20ftCntrStlAmt = this.rf20ftCntrStlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHcLd45 = this.bkgHcLd45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt20 = this.mt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDg40 = this.bkgDg40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlClzFlg = this.stlClzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrStlRmk = this.dgCntrStlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFull40 = this.bkgFull40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrUsdSltTeuCapa = this.ovrUsdSltTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pass = this.pass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrStlPrc = this.dgCntrStlPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20 = this.dg20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRf20Qty = this.bkgRf20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrUsdSltAmt = this.ovrUsdSltAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcBsa45 = this.hcBsa45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcBsa40 = this.hcBsa40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuQty = this.teuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAkUnit = this.bkgAkUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grandTtlSlot = this.grandTtlSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMt40 = this.bkgMt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHcLd20 = this.bkgHcLd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo20ftN1stRto = this.jo20ftN1stRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akVoid = this.akVoid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt40 = this.mt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlTgtFlg = this.stlTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAkVoid = this.bkgAkVoid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akUnit = this.akUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcLd20 = this.hcLd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allTeu = this.allTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Qty = this.rf40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlVvdSeq = this.stlVvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finUsed = this.finUsed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overSlot = this.overSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcBsa20 = this.hcBsa20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkdSts = this.portSkdSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40ftCntrStlTeuCapa = this.rf40ftCntrStlTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcLd40 = this.hcLd40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHcBsa45 = this.bkgHcBsa45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo40ftN1stRto = this.jo40ftN1stRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Qty = this.rf20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40ftCntrStlAmt = this.rf40ftCntrStlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.source = this.source .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHcBsa40 = this.bkgHcBsa40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfRdrQty = this.bkgRfRdrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfRdr40Qty = this.bkgRfRdr40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlTgtFlg2 = this.stlTgtFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcLd45 = this.hcLd45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subChk = this.subChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20ftCntrStlTeuCapa = this.rf20ftCntrStlTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo20ftSubTeuQty = this.jo20ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaFlg = this.bsaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftN2ndRto = this.jo45ftN2ndRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo40ftSubTeuQty = this.jo40ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmonSeq = this.revYrmonSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full20 = this.full20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftN1stRto = this.jo45ftN1stRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRndRuleLvl = this.joRndRuleLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40ftCntrStlRmk = this.rf40ftCntrStlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joFshFlg = this.joFshFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overWgt = this.overWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrStlAmt = this.dgCntrStlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtTeu = this.mtTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20ftCntrStlPrc = this.rf20ftCntrStlPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHcBsa20 = this.bkgHcBsa20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfScgStlTpCd = this.rfScgStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRdrQty = this.rfRdrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40ftCntrStlPrc = this.rf40ftCntrStlPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtWt = this.mtWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRf40Qty = this.bkgRf40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDg20 = this.bkgDg20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20ftCntrStlRmk = this.rf20ftCntrStlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrUsdSltPrc = this.ovrUsdSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFull20 = this.bkgFull20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allWgt = this.allWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRdr40Qty = this.rfRdr40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrStlTeuCapa = this.dgCntrStlTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrUsdSltRmk = this.ovrUsdSltRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftSubTeuQty = this.jo45ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgGrandTtlWgt = this.bkgGrandTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full40 = this.full40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdrFlg = this.rdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
