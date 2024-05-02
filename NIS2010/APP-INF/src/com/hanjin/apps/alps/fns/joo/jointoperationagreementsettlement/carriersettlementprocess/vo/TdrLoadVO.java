/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TdrLoadVO.java
*@FileTitle : TdrLoadVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.25
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.10.25 김영오 
* 2012.01.07 이수진 [CHM-201322276] 모델링 표준에 맞게 처리 되도록 테이블 칼럼 변경 작업 및 기능 변경
*                  : JO_REP_CRR_CD_FLG => JO_REP_CRR_FLG으로 컬럼명 변경 작업
* 2013.11.05 이수진  [CHM-201327425] R/F 로직 변경 - DG 20'/40' 추가                                 
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TdrLoadVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TdrLoadVO> models = new ArrayList<TdrLoadVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String hcLd45 = null;
	/* Column Info */
	private String akVoid = null;
	/* Column Info */
	private String hcBsa20 = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String mt40 = null;
	/* Column Info */
	private String jo45ftN1stRto = null;
	/* Column Info */
	private String full40 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String preFr = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String hcLd40 = null;
	/* Column Info */
	private String joRndRuleLvl = null;
	/* Column Info */
	private String joRgnCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String superCd1 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String grandTtlSlot = null;
	/* Column Info */
	private String akUnit = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String preTo = null;
	/* Column Info */
	private String jo40ftN1stRto = null;
	/* Column Info */
	private String hcBsa40 = null;
	/* Column Info */
	private String rf20Qty = null;
	/* Column Info */
	private String hcBsa45 = null;
	/* Column Info */
	private String rf40Qty = null;
	/* Column Info */
	private String mt20 = null;
	/* Column Info */
	private String jo45ftSubTeuQty = null;
	/* Column Info */
	private String hcLd20 = null;
	/* Column Info */
	private String full20 = null;
	/* Column Info */
	private String allWgt = null;
	/* Column Info */
	private String mtTeu = null;
	/* Column Info */
	private String overSlot = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String jo45ftN2ndRto = null;
	/* Column Info */
	private String mtWt = null;
	/* Column Info */
	private String jo40ftSubTeuQty = null;
	/* Column Info */
	private String joRepCrrFlg = null;
	/* Column Info */
	private String sumFlg = null;
	/* Column Info */
	private String jo20ftSubTeuQty = null;
	/* Column Info */
	private String subChk = null;
	/* Column Info */
	private String overWgt = null;
	/* Column Info */
	private String allTeu = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String carrierCnt = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String source = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String grandTtlWgt = null;
	/* Column Info */
	private String jo20ftN1stRto = null;
	/* Column Info */
	private String dg20 = null;
	/* Column Info */
	private String dg40 = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String teuQty = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String splitNo = null;
	/* Column Info */
	private String seqNo = null;
	/* Column Info */
	private String rdrFlg = null;
	/* Column Info */
	private String rfRdrQty = null;	
	/* Column Info */
	private String usrId = null;	
	/* Column Info */
	private String clptSeq = null;	
	/* Column Info */
	private String pass = null;	
	/* Column Info */
	private String optTgt = null;
	/* Column Info */
	private String optClz = null;
	/* Column Info */
	private String mergeCrr = null;
	/* Column Info */
	private String rfRdr20 = null;
	/* Column Info */
	private String rfRdr40 = null;
	
		
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TdrLoadVO() {}

	public TdrLoadVO(String ibflag, String pagerows, String hcBsa40, String vslCd, String hcLd45, String rf20Qty, String hcBsa45, String akVoid, String hcBsa20, String rf40Qty, String mt20, String rlaneCd, String mt40, String hcLd20, String full20, String mtTeu, String allWgt, String full40, String preFr, String vpsPortCd, String overSlot, String hcLd40, String mtWt, String sumFlg, String joRgnCd, String vpsEtdDt, String superCd1, String skdVoyNo, String overWgt, String grandTtlSlot, String allTeu, String skdDirCd, String akUnit, String vvd, String slanCd, String source, String preTo, String oprCd, String grandTtlWgt, String jo20ftN1stRto, String jo20ftSubTeuQty, String jo40ftN1stRto, String jo40ftSubTeuQty, String jo45ftN1stRto, String jo45ftN2ndRto, String jo45ftSubTeuQty, String joRndRuleLvl, String carrierCnt, String subChk, String joRepCrrFlg, String dg20, String dg40, String trdCd, String teuQty, String tmlCd, String splitNo, String seqNo, String rdrFlg, String rfRdrQty, String usrId, String clptSeq, String pass, String optTgt, String optClz, String mergeCrr, String rfRdr20, String rfRdr40) {
		this.vslCd = vslCd;
		this.hcLd45 = hcLd45;
		this.akVoid = akVoid;
		this.hcBsa20 = hcBsa20;
		this.rlaneCd = rlaneCd;
		this.mt40 = mt40;
		this.jo45ftN1stRto = jo45ftN1stRto;
		this.full40 = full40;
		this.pagerows = pagerows;
		this.preFr = preFr;
		this.vpsPortCd = vpsPortCd;
		this.hcLd40 = hcLd40;
		this.joRndRuleLvl = joRndRuleLvl;
		this.joRgnCd = joRgnCd;
		this.vpsEtdDt = vpsEtdDt;
		this.superCd1 = superCd1;
		this.skdVoyNo = skdVoyNo;
		this.grandTtlSlot = grandTtlSlot;
		this.akUnit = akUnit;
		this.vvd = vvd;
		this.preTo = preTo;
		this.jo40ftN1stRto = jo40ftN1stRto;
		this.hcBsa40 = hcBsa40;
		this.rf20Qty = rf20Qty;
		this.hcBsa45 = hcBsa45;
		this.rf40Qty = rf40Qty;
		this.mt20 = mt20;
		this.jo45ftSubTeuQty = jo45ftSubTeuQty;
		this.hcLd20 = hcLd20;
		this.full20 = full20;
		this.allWgt = allWgt;
		this.mtTeu = mtTeu;
		this.overSlot = overSlot;
		this.ibflag = ibflag;
		this.jo45ftN2ndRto = jo45ftN2ndRto;
		this.mtWt = mtWt;
		this.jo40ftSubTeuQty = jo40ftSubTeuQty;
		this.joRepCrrFlg = joRepCrrFlg;
		this.sumFlg = sumFlg;
		this.jo20ftSubTeuQty = jo20ftSubTeuQty;
		this.subChk = subChk;
		this.overWgt = overWgt;
		this.allTeu = allTeu;
		this.skdDirCd = skdDirCd;
		this.carrierCnt = carrierCnt;
		this.slanCd = slanCd;
		this.source = source;
		this.oprCd = oprCd;
		this.grandTtlWgt = grandTtlWgt;
		this.jo20ftN1stRto = jo20ftN1stRto;
		this.dg20 = dg20;
		this.dg40 = dg40;
		this.trdCd = trdCd;
		this.teuQty = teuQty;		
		this.tmlCd = tmlCd;
		this.splitNo = splitNo;
		this.seqNo = seqNo;
		this.rdrFlg = rdrFlg;		
		this.rfRdrQty = rfRdrQty;		
		this.usrId = usrId;
		this.clptSeq = clptSeq;
		this.pass = pass;		
		this.optTgt = optTgt;
		this.optClz = optClz;
		this.mergeCrr = mergeCrr;
		this.rfRdr20 = rfRdr20;
		this.rfRdr40 = rfRdr40;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("hc_ld_45", getHcLd45());
		this.hashColumns.put("ak_void", getAkVoid());
		this.hashColumns.put("hc_bsa_20", getHcBsa20());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("mt_40", getMt40());
		this.hashColumns.put("jo_45ft_n1st_rto", getJo45ftN1stRto());
		this.hashColumns.put("full_40", getFull40());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pre_fr", getPreFr());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("hc_ld_40", getHcLd40());
		this.hashColumns.put("jo_rnd_rule_lvl", getJoRndRuleLvl());
		this.hashColumns.put("jo_rgn_cd", getJoRgnCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("super_cd1", getSuperCd1());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("grand_ttl_slot", getGrandTtlSlot());
		this.hashColumns.put("ak_unit", getAkUnit());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pre_to", getPreTo());
		this.hashColumns.put("jo_40ft_n1st_rto", getJo40ftN1stRto());
		this.hashColumns.put("hc_bsa_40", getHcBsa40());
		this.hashColumns.put("rf_20_qty", getRf20Qty());
		this.hashColumns.put("hc_bsa_45", getHcBsa45());
		this.hashColumns.put("rf_40_qty", getRf40Qty());
		this.hashColumns.put("mt_20", getMt20());
		this.hashColumns.put("jo_45ft_sub_teu_qty", getJo45ftSubTeuQty());
		this.hashColumns.put("hc_ld_20", getHcLd20());
		this.hashColumns.put("full_20", getFull20());
		this.hashColumns.put("all_wgt", getAllWgt());
		this.hashColumns.put("mt_teu", getMtTeu());
		this.hashColumns.put("over_slot", getOverSlot());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("jo_45ft_n2nd_rto", getJo45ftN2ndRto());
		this.hashColumns.put("mt_wt", getMtWt());
		this.hashColumns.put("jo_40ft_sub_teu_qty", getJo40ftSubTeuQty());
		this.hashColumns.put("jo_rep_crr_flg", getJoRepCrrFlg());
		this.hashColumns.put("sum_flg", getSumFlg());
		this.hashColumns.put("jo_20ft_sub_teu_qty", getJo20ftSubTeuQty());
		this.hashColumns.put("sub_chk", getSubChk());
		this.hashColumns.put("over_wgt", getOverWgt());
		this.hashColumns.put("all_teu", getAllTeu());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("carrier_cnt", getCarrierCnt());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("source", getSource());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("grand_ttl_wgt", getGrandTtlWgt());
		this.hashColumns.put("jo_20ft_n1st_rto", getJo20ftN1stRto());
		this.hashColumns.put("dg_20", getDg20());
		this.hashColumns.put("dg_40", getDg40());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("teu_qty", getTeuQty());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("split_no", getSplitNo());		
		this.hashColumns.put("seq_no", getSeqNo());		
		this.hashColumns.put("rdr_flg", getRdrFlg());		
		this.hashColumns.put("rf_rdr_qty", getRfRdrQty());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("pass", getPass());
		this.hashColumns.put("opt_tgt", getOptTgt());		
		this.hashColumns.put("opt_clz", getOptClz());		
		this.hashColumns.put("merge_crr", getMergeCrr());		
		this.hashColumns.put("rf_rdr_20", getRfRdr20());		
		this.hashColumns.put("rf_rdr_40", getRfRdr40());		
				
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("hc_ld_45", "hcLd45");
		this.hashFields.put("ak_void", "akVoid");
		this.hashFields.put("hc_bsa_20", "hcBsa20");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("mt_40", "mt40");
		this.hashFields.put("jo_45ft_n1st_rto", "jo45ftN1stRto");
		this.hashFields.put("full_40", "full40");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pre_fr", "preFr");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("hc_ld_40", "hcLd40");
		this.hashFields.put("jo_rnd_rule_lvl", "joRndRuleLvl");
		this.hashFields.put("jo_rgn_cd", "joRgnCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("super_cd1", "superCd1");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("grand_ttl_slot", "grandTtlSlot");
		this.hashFields.put("ak_unit", "akUnit");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pre_to", "preTo");
		this.hashFields.put("jo_40ft_n1st_rto", "jo40ftN1stRto");
		this.hashFields.put("hc_bsa_40", "hcBsa40");
		this.hashFields.put("rf_20_qty", "rf20Qty");
		this.hashFields.put("hc_bsa_45", "hcBsa45");
		this.hashFields.put("rf_40_qty", "rf40Qty");
		this.hashFields.put("mt_20", "mt20");
		this.hashFields.put("jo_45ft_sub_teu_qty", "jo45ftSubTeuQty");
		this.hashFields.put("hc_ld_20", "hcLd20");
		this.hashFields.put("full_20", "full20");
		this.hashFields.put("all_wgt", "allWgt");
		this.hashFields.put("mt_teu", "mtTeu");
		this.hashFields.put("over_slot", "overSlot");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("jo_45ft_n2nd_rto", "jo45ftN2ndRto");
		this.hashFields.put("mt_wt", "mtWt");
		this.hashFields.put("jo_40ft_sub_teu_qty", "jo40ftSubTeuQty");
		this.hashFields.put("jo_rep_crr_flg", "joRepCrrFlg");
		this.hashFields.put("sum_flg", "sumFlg");
		this.hashFields.put("jo_20ft_sub_teu_qty", "jo20ftSubTeuQty");
		this.hashFields.put("sub_chk", "subChk");
		this.hashFields.put("over_wgt", "overWgt");
		this.hashFields.put("all_teu", "allTeu");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("carrier_cnt", "carrierCnt");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("source", "source");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("grand_ttl_wgt", "grandTtlWgt");
		this.hashFields.put("jo_20ft_n1st_rto", "jo20ftN1stRto");
		this.hashFields.put("dg_20", "dg20");
		this.hashFields.put("dg_40", "dg40");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("teu_qty", "teuQty");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("split_no", "splitNo");
		this.hashFields.put("seq_no", "seqNo");
		this.hashFields.put("rdr_flg", "rdrFlg");		
		this.hashFields.put("rf_rdr_qty", "rfRdrQty");		
		this.hashFields.put("usr_id", "usrId");		
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("pass", "pass");		
		this.hashFields.put("opt_tgt", "optTgt");
		this.hashFields.put("opt_clz", "optClz");
		this.hashFields.put("merge_crr", "mergeCrr");		
		this.hashFields.put("rf_rdr_20", "rfRdr20");		
		this.hashFields.put("rf_rdr_40", "rfRdr40");		
		
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
	 * @return hcLd45
	 */
	public String getHcLd45() {
		return this.hcLd45;
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
	 * @return hcBsa20
	 */
	public String getHcBsa20() {
		return this.hcBsa20;
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
	 * @return mt40
	 */
	public String getMt40() {
		return this.mt40;
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
	 * @return full40
	 */
	public String getFull40() {
		return this.full40;
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
	 * @return preFr
	 */
	public String getPreFr() {
		return this.preFr;
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
	 * @return hcLd40
	 */
	public String getHcLd40() {
		return this.hcLd40;
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
	 * @return dg40
	 */
	public String getDg40() {
		return this.dg40;
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
	 * @return joRndRuleLvl
	 */
	public String getJoRndRuleLvl() {
		return this.joRndRuleLvl;
	}
	
	/**
	 * Column Info
	 * @return joRgnCd
	 */
	public String getJoRgnCd() {
		return this.joRgnCd;
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
	 * @return superCd1
	 */
	public String getSuperCd1() {
		return this.superCd1;
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
	 * @return grandTtlSlot
	 */
	public String getGrandTtlSlot() {
		return this.grandTtlSlot;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return preTo
	 */
	public String getPreTo() {
		return this.preTo;
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
	 * @return hcBsa40
	 */
	public String getHcBsa40() {
		return this.hcBsa40;
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
	 * @return hcBsa45
	 */
	public String getHcBsa45() {
		return this.hcBsa45;
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
	 * @return mt20
	 */
	public String getMt20() {
		return this.mt20;
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
	 * @return hcLd20
	 */
	public String getHcLd20() {
		return this.hcLd20;
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
	 * @return allWgt
	 */
	public String getAllWgt() {
		return this.allWgt;
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
	 * @return overSlot
	 */
	public String getOverSlot() {
		return this.overSlot;
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
	 * @return jo45ftN2ndRto
	 */
	public String getJo45ftN2ndRto() {
		return this.jo45ftN2ndRto;
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
	 * @return jo40ftSubTeuQty
	 */
	public String getJo40ftSubTeuQty() {
		return this.jo40ftSubTeuQty;
	}
	
	/**
	 * Column Info
	 * @return joRepCrrFlg
	 */
	public String getJoRepCrrFlg() {
		return this.joRepCrrFlg;
	}
	
	/**
	 * Column Info
	 * @return sumFlg
	 */
	public String getSumFlg() {
		return this.sumFlg;
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
	 * @return subChk
	 */
	public String getSubChk() {
		return this.subChk;
	}
	
	/**
	 * Column Info
	 * @return overWgt
	 */
	public String getOverWgt() {
		return this.overWgt;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return carrierCnt
	 */
	public String getCarrierCnt() {
		return this.carrierCnt;
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
	 * @return source
	 */
	public String getSource() {
		return this.source;
	}
	
	/**
	 * Column Info
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
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
	 * @return jo20ftN1stRto
	 */
	public String getJo20ftN1stRto() {
		return this.jo20ftN1stRto;
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
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}

	/**
	 * Column Info
	 * @return splitNo
	 */
	public String getSplitNo() {
		return this.splitNo;
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
	 * @return rdrFlg
	 */
	public String getRdrFlg() {
		return this.rdrFlg;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return pass
	 */
	public String getPass() {
		return this.pass;
	}

	/**
	 * Column Info
	 * @return optTgt
	 */
	public String getOptTgt() {
		return this.optTgt;
	}

	/**
	 * Column Info
	 * @return optClz
	 */
	public String getOptClz() {
		return this.optClz;
	}

	/**
	 * Column Info
	 * @return mergeCrr
	 */
	public String getMergeCrr() {
		return this.mergeCrr;
	}	

	/**
	 * Column Info
	 * @return rfRdr20
	 */
	public String getRfRdr20() {
		return this.rfRdr20;
	}	
	/**
	 * Column Info
	 * @return rfRdr40
	 */
	public String getRfRdr40() {
		return this.rfRdr40;
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
	 * @param hcLd45
	 */
	public void setHcLd45(String hcLd45) {
		this.hcLd45 = hcLd45;
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
	 * @param hcBsa20
	 */
	public void setHcBsa20(String hcBsa20) {
		this.hcBsa20 = hcBsa20;
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
	 * @param mt40
	 */
	public void setMt40(String mt40) {
		this.mt40 = mt40;
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
	 * @param full40
	 */
	public void setFull40(String full40) {
		this.full40 = full40;
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
	 * @param preFr
	 */
	public void setPreFr(String preFr) {
		this.preFr = preFr;
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
	 * @param hcLd40
	 */
	public void setHcLd40(String hcLd40) {
		this.hcLd40 = hcLd40;
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
	 * @param joRgnCd
	 */
	public void setJoRgnCd(String joRgnCd) {
		this.joRgnCd = joRgnCd;
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
	 * @param superCd1
	 */
	public void setSuperCd1(String superCd1) {
		this.superCd1 = superCd1;
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
	 * @param grandTtlSlot
	 */
	public void setGrandTtlSlot(String grandTtlSlot) {
		this.grandTtlSlot = grandTtlSlot;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param preTo
	 */
	public void setPreTo(String preTo) {
		this.preTo = preTo;
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
	 * @param hcBsa40
	 */
	public void setHcBsa40(String hcBsa40) {
		this.hcBsa40 = hcBsa40;
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
	 * @param hcBsa45
	 */
	public void setHcBsa45(String hcBsa45) {
		this.hcBsa45 = hcBsa45;
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
	 * @param mt20
	 */
	public void setMt20(String mt20) {
		this.mt20 = mt20;
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
	 * @param hcLd20
	 */
	public void setHcLd20(String hcLd20) {
		this.hcLd20 = hcLd20;
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
	 * @param allWgt
	 */
	public void setAllWgt(String allWgt) {
		this.allWgt = allWgt;
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
	 * @param overSlot
	 */
	public void setOverSlot(String overSlot) {
		this.overSlot = overSlot;
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
	 * @param jo45ftN2ndRto
	 */
	public void setJo45ftN2ndRto(String jo45ftN2ndRto) {
		this.jo45ftN2ndRto = jo45ftN2ndRto;
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
	 * @param jo40ftSubTeuQty
	 */
	public void setJo40ftSubTeuQty(String jo40ftSubTeuQty) {
		this.jo40ftSubTeuQty = jo40ftSubTeuQty;
	}
	
	/**
	 * Column Info
	 * @param joRepCrrFlg
	 */
	public void setJoRepCrrFlg(String joRepCrrFlg) {
		this.joRepCrrFlg = joRepCrrFlg;
	}
	
	/**
	 * Column Info
	 * @param sumFlg
	 */
	public void setSumFlg(String sumFlg) {
		this.sumFlg = sumFlg;
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
	 * @param subChk
	 */
	public void setSubChk(String subChk) {
		this.subChk = subChk;
	}
	
	/**
	 * Column Info
	 * @param overWgt
	 */
	public void setOverWgt(String overWgt) {
		this.overWgt = overWgt;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param carrierCnt
	 */
	public void setCarrierCnt(String carrierCnt) {
		this.carrierCnt = carrierCnt;
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
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Column Info
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
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
	 * @param jo20ftN1stRto
	 */
	public void setJo20ftN1stRto(String jo20ftN1stRto) {
		this.jo20ftN1stRto = jo20ftN1stRto;
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
	 * @param dg40
	 */
	public void setDg40(String dg40) {
		this.dg40 = dg40;
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
	 * @param teuQty
	 */
	public void setTeuQty(String teuQty) {
		this.teuQty = teuQty;
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
	 * @param splitNo
	 */
	public void setSplitNo(String splitNo) {
		this.splitNo = splitNo;
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
	 * @param rdrFlg
	 */
	public void setRdrFlg(String rdrFlg) {
		this.rdrFlg = rdrFlg;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}	

	/**
	 * Column Info
	 * @param optTgt
	 */
	public void setOptTgt(String optTgt) {
		this.optTgt = optTgt;
	}	
	
	/**
	 * Column Info
	 * @param optClz
	 */
	public void setOptClz(String optClz) {
		this.optClz = optClz;
	}	
	
	/**
	 * Column Info
	 * @param mergeCrr
	 */
	public void setMergeCrr(String mergeCrr) {
		this.mergeCrr = mergeCrr;
	}	

	/**
	 * Column Info
	 * @param rfRdr20
	 */
	public void setRfRdr20(String rfRdr20) {
		this.rfRdr20= rfRdr20;
	}	

	/**
	 * Column Info
	 * @param rfRdr40
	 */
	public void setRfRdr40(String rfRdr40) {
		this.rfRdr40 = rfRdr40;
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
		setHcLd45(JSPUtil.getParameter(request, prefix + "hc_ld_45", ""));
		setAkVoid(JSPUtil.getParameter(request, prefix + "ak_void", ""));
		setHcBsa20(JSPUtil.getParameter(request, prefix + "hc_bsa_20", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setMt40(JSPUtil.getParameter(request, prefix + "mt_40", ""));
		setJo45ftN1stRto(JSPUtil.getParameter(request, prefix + "jo_45ft_n1st_rto", ""));
		setFull40(JSPUtil.getParameter(request, prefix + "full_40", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPreFr(JSPUtil.getParameter(request, prefix + "pre_fr", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setHcLd40(JSPUtil.getParameter(request, prefix + "hc_ld_40", ""));
		setJoRndRuleLvl(JSPUtil.getParameter(request, prefix + "jo_rnd_rule_lvl", ""));
		setJoRgnCd(JSPUtil.getParameter(request, prefix + "jo_rgn_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setSuperCd1(JSPUtil.getParameter(request, prefix + "super_cd1", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setGrandTtlSlot(JSPUtil.getParameter(request, prefix + "grand_ttl_slot", ""));
		setAkUnit(JSPUtil.getParameter(request, prefix + "ak_unit", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPreTo(JSPUtil.getParameter(request, prefix + "pre_to", ""));
		setJo40ftN1stRto(JSPUtil.getParameter(request, prefix + "jo_40ft_n1st_rto", ""));
		setHcBsa40(JSPUtil.getParameter(request, prefix + "hc_bsa_40", ""));
		setRf20Qty(JSPUtil.getParameter(request, prefix + "rf_20_qty", ""));
		setHcBsa45(JSPUtil.getParameter(request, prefix + "hc_bsa_45", ""));
		setRf40Qty(JSPUtil.getParameter(request, prefix + "rf_40_qty", ""));
		setMt20(JSPUtil.getParameter(request, prefix + "mt_20", ""));
		setJo45ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_45ft_sub_teu_qty", ""));
		setHcLd20(JSPUtil.getParameter(request, prefix + "hc_ld_20", ""));
		setFull20(JSPUtil.getParameter(request, prefix + "full_20", ""));
		setAllWgt(JSPUtil.getParameter(request, prefix + "all_wgt", ""));
		setMtTeu(JSPUtil.getParameter(request, prefix + "mt_teu", ""));
		setOverSlot(JSPUtil.getParameter(request, prefix + "over_slot", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setJo45ftN2ndRto(JSPUtil.getParameter(request, prefix + "jo_45ft_n2nd_rto", ""));
		setMtWt(JSPUtil.getParameter(request, prefix + "mt_wt", ""));
		setJo40ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_40ft_sub_teu_qty", ""));
		setJoRepCrrFlg(JSPUtil.getParameter(request, prefix + "jo_rep_crr_flg", ""));
		setSumFlg(JSPUtil.getParameter(request, prefix + "sum_flg", ""));
		setJo20ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_20ft_sub_teu_qty", ""));
		setSubChk(JSPUtil.getParameter(request, prefix + "sub_chk", ""));
		setOverWgt(JSPUtil.getParameter(request, prefix + "over_wgt", ""));
		setAllTeu(JSPUtil.getParameter(request, prefix + "all_teu", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCarrierCnt(JSPUtil.getParameter(request, prefix + "carrier_cnt", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setSource(JSPUtil.getParameter(request, prefix + "source", ""));
		setOprCd(JSPUtil.getParameter(request, prefix + "opr_cd", ""));
		setGrandTtlWgt(JSPUtil.getParameter(request, prefix + "grand_ttl_wgt", ""));
		setJo20ftN1stRto(JSPUtil.getParameter(request, prefix + "jo_20ft_n1st_rto", ""));
		setDg20(JSPUtil.getParameter(request, prefix + "dg_20", ""));
		setDg40(JSPUtil.getParameter(request, prefix + "dg_40", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));		
		setTeuQty(JSPUtil.getParameter(request, prefix + "teu_qty", ""));	
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setSplitNo(JSPUtil.getParameter(request, prefix + "split_no", ""));
		setSeqNo(JSPUtil.getParameter(request, prefix + "seq_no", ""));	
		setRdrFlg(JSPUtil.getParameter(request, prefix + "rdr_flg", ""));
		setRfRdrQty(JSPUtil.getParameter(request, prefix + "rf_rdr_qty", ""));		
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));		
		setPass(JSPUtil.getParameter(request, prefix + "pass", ""));		
		setOptTgt(JSPUtil.getParameter(request, prefix + "opt_tgt", ""));		
		setOptClz(JSPUtil.getParameter(request, prefix + "opt_clz", ""));		
		setMergeCrr(JSPUtil.getParameter(request, prefix + "merge_crr", ""));		
		setRfRdr20(JSPUtil.getParameter(request, prefix + "rf_rdr_20", ""));		
		setRfRdr40(JSPUtil.getParameter(request, prefix + "rf_rdr_40", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TdrLoadVO[]
	 */
	public TdrLoadVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TdrLoadVO[]
	 */
	public TdrLoadVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TdrLoadVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] hcLd45 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_45", length));
			String[] akVoid = (JSPUtil.getParameter(request, prefix	+ "ak_void", length));
			String[] hcBsa20 = (JSPUtil.getParameter(request, prefix	+ "hc_bsa_20", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] mt40 = (JSPUtil.getParameter(request, prefix	+ "mt_40", length));
			String[] jo45ftN1stRto = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_n1st_rto", length));
			String[] full40 = (JSPUtil.getParameter(request, prefix	+ "full_40", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] preFr = (JSPUtil.getParameter(request, prefix	+ "pre_fr", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] hcLd40 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_40", length));
			String[] joRndRuleLvl = (JSPUtil.getParameter(request, prefix	+ "jo_rnd_rule_lvl", length));
			String[] joRgnCd = (JSPUtil.getParameter(request, prefix	+ "jo_rgn_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] superCd1 = (JSPUtil.getParameter(request, prefix	+ "super_cd1", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] grandTtlSlot = (JSPUtil.getParameter(request, prefix	+ "grand_ttl_slot", length));
			String[] akUnit = (JSPUtil.getParameter(request, prefix	+ "ak_unit", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] preTo = (JSPUtil.getParameter(request, prefix	+ "pre_to", length));
			String[] jo40ftN1stRto = (JSPUtil.getParameter(request, prefix	+ "jo_40ft_n1st_rto", length));
			String[] hcBsa40 = (JSPUtil.getParameter(request, prefix	+ "hc_bsa_40", length));
			String[] rf20Qty = (JSPUtil.getParameter(request, prefix	+ "rf_20_qty", length));
			String[] hcBsa45 = (JSPUtil.getParameter(request, prefix	+ "hc_bsa_45", length));
			String[] rf40Qty = (JSPUtil.getParameter(request, prefix	+ "rf_40_qty", length));
			String[] mt20 = (JSPUtil.getParameter(request, prefix	+ "mt_20", length));
			String[] jo45ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_sub_teu_qty", length));
			String[] hcLd20 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_20", length));
			String[] full20 = (JSPUtil.getParameter(request, prefix	+ "full_20", length));
			String[] allWgt = (JSPUtil.getParameter(request, prefix	+ "all_wgt", length));
			String[] mtTeu = (JSPUtil.getParameter(request, prefix	+ "mt_teu", length));
			String[] overSlot = (JSPUtil.getParameter(request, prefix	+ "over_slot", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] jo45ftN2ndRto = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_n2nd_rto", length));
			String[] mtWt = (JSPUtil.getParameter(request, prefix	+ "mt_wt", length));
			String[] jo40ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_40ft_sub_teu_qty", length));
			String[] joRepCrrFlg = (JSPUtil.getParameter(request, prefix	+ "jo_rep_crr_flg", length));
			String[] sumFlg = (JSPUtil.getParameter(request, prefix	+ "sum_flg", length));
			String[] jo20ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_20ft_sub_teu_qty", length));
			String[] subChk = (JSPUtil.getParameter(request, prefix	+ "sub_chk", length));
			String[] overWgt = (JSPUtil.getParameter(request, prefix	+ "over_wgt", length));
			String[] allTeu = (JSPUtil.getParameter(request, prefix	+ "all_teu", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] carrierCnt = (JSPUtil.getParameter(request, prefix	+ "carrier_cnt", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] source = (JSPUtil.getParameter(request, prefix	+ "source", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] grandTtlWgt = (JSPUtil.getParameter(request, prefix	+ "grand_ttl_wgt", length));
			String[] jo20ftN1stRto = (JSPUtil.getParameter(request, prefix	+ "jo_20ft_n1st_rto", length));
			String[] dg20 = (JSPUtil.getParameter(request, prefix	+ "dg_20", length));
			String[] dg40 = (JSPUtil.getParameter(request, prefix	+ "dg_40", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));			
			String[] teuQty = (JSPUtil.getParameter(request, prefix	+ "teu_qty", length));			
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] splitNo = (JSPUtil.getParameter(request, prefix	+ "split_no", length));			
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));			
			String[] rdrFlg = (JSPUtil.getParameter(request, prefix	+ "rdr_flg", length));
			String[] rfRdrQty = (JSPUtil.getParameter(request, prefix	+ "rf_rdr_qty", length));		
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] pass = (JSPUtil.getParameter(request, prefix	+ "pass", length));			
			String[] optTgt = (JSPUtil.getParameter(request, prefix	+ "opt_tgt", length));
			String[] optClz = (JSPUtil.getParameter(request, prefix	+ "opt_clz", length));		
			String[] mergeCrr = (JSPUtil.getParameter(request, prefix	+ "merge_crr", length));			
			String[] rfRdr20 = (JSPUtil.getParameter(request, prefix	+ "rf_rdr_20", length));			
			String[] rfRdr40 = (JSPUtil.getParameter(request, prefix	+ "rf_rdr_40", length));			
			
			for (int i = 0; i < length; i++) {
				model = new TdrLoadVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (hcLd45[i] != null)
					model.setHcLd45(hcLd45[i]);
				if (akVoid[i] != null)
					model.setAkVoid(akVoid[i]);
				if (hcBsa20[i] != null)
					model.setHcBsa20(hcBsa20[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (mt40[i] != null)
					model.setMt40(mt40[i]);
				if (jo45ftN1stRto[i] != null)
					model.setJo45ftN1stRto(jo45ftN1stRto[i]);
				if (full40[i] != null)
					model.setFull40(full40[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (preFr[i] != null)
					model.setPreFr(preFr[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (hcLd40[i] != null)
					model.setHcLd40(hcLd40[i]);
				if (joRndRuleLvl[i] != null)
					model.setJoRndRuleLvl(joRndRuleLvl[i]);
				if (joRgnCd[i] != null)
					model.setJoRgnCd(joRgnCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (superCd1[i] != null)
					model.setSuperCd1(superCd1[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (grandTtlSlot[i] != null)
					model.setGrandTtlSlot(grandTtlSlot[i]);
				if (akUnit[i] != null)
					model.setAkUnit(akUnit[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (preTo[i] != null)
					model.setPreTo(preTo[i]);
				if (jo40ftN1stRto[i] != null)
					model.setJo40ftN1stRto(jo40ftN1stRto[i]);
				if (hcBsa40[i] != null)
					model.setHcBsa40(hcBsa40[i]);
				if (rf20Qty[i] != null)
					model.setRf20Qty(rf20Qty[i]);
				if (hcBsa45[i] != null)
					model.setHcBsa45(hcBsa45[i]);
				if (rf40Qty[i] != null)
					model.setRf40Qty(rf40Qty[i]);
				if (mt20[i] != null)
					model.setMt20(mt20[i]);
				if (jo45ftSubTeuQty[i] != null)
					model.setJo45ftSubTeuQty(jo45ftSubTeuQty[i]);
				if (hcLd20[i] != null)
					model.setHcLd20(hcLd20[i]);
				if (full20[i] != null)
					model.setFull20(full20[i]);
				if (allWgt[i] != null)
					model.setAllWgt(allWgt[i]);
				if (mtTeu[i] != null)
					model.setMtTeu(mtTeu[i]);
				if (overSlot[i] != null)
					model.setOverSlot(overSlot[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (jo45ftN2ndRto[i] != null)
					model.setJo45ftN2ndRto(jo45ftN2ndRto[i]);
				if (mtWt[i] != null)
					model.setMtWt(mtWt[i]);
				if (jo40ftSubTeuQty[i] != null)
					model.setJo40ftSubTeuQty(jo40ftSubTeuQty[i]);
				if (joRepCrrFlg[i] != null)
					model.setJoRepCrrFlg(joRepCrrFlg[i]);
				if (sumFlg[i] != null)
					model.setSumFlg(sumFlg[i]);
				if (jo20ftSubTeuQty[i] != null)
					model.setJo20ftSubTeuQty(jo20ftSubTeuQty[i]);
				if (subChk[i] != null)
					model.setSubChk(subChk[i]);
				if (overWgt[i] != null)
					model.setOverWgt(overWgt[i]);
				if (allTeu[i] != null)
					model.setAllTeu(allTeu[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (carrierCnt[i] != null)
					model.setCarrierCnt(carrierCnt[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (source[i] != null)
					model.setSource(source[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (grandTtlWgt[i] != null)
					model.setGrandTtlWgt(grandTtlWgt[i]);
				if (jo20ftN1stRto[i] != null)
					model.setJo20ftN1stRto(jo20ftN1stRto[i]);
				if (dg20[i] != null)
					model.setDg20(oprCd[i]);
				if (dg40[i] != null)
					model.setDg40(dg40[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (teuQty[i] != null)
					model.setTeuQty(teuQty[i]);				
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (splitNo[i] != null)
					model.setSplitNo(splitNo[i]);
				if (seqNo[i] != null)
					model.setSeqNo(seqNo[i]);				
				if (rdrFlg[i] != null)
					model.setRdrFlg(rdrFlg[i]);
				if (rfRdrQty[i] != null)
					model.setRfRdrQty(rfRdrQty[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (pass[i] != null)
					model.setPass(pass[i]);				
				if (optTgt[i] != null)
					model.setOptTgt(optTgt[i]);
				if (optClz[i] != null)
					model.setOptClz(optClz[i]);
				if (mergeCrr[i] != null)
					model.setMergeCrr(mergeCrr[i]);
				if (rfRdr20[i] != null)
					model.setRfRdr20(rfRdr20[i]);
				if (rfRdr40[i] != null)
					model.setRfRdr40(rfRdr40[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTdrLoadVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TdrLoadVO[]
	 */
	public TdrLoadVO[] getTdrLoadVOs(){
		TdrLoadVO[] vos = (TdrLoadVO[])models.toArray(new TdrLoadVO[models.size()]);
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
		this.hcLd45 = this.hcLd45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akVoid = this.akVoid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcBsa20 = this.hcBsa20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt40 = this.mt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftN1stRto = this.jo45ftN1stRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full40 = this.full40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preFr = this.preFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcLd40 = this.hcLd40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRndRuleLvl = this.joRndRuleLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRgnCd = this.joRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.superCd1 = this.superCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grandTtlSlot = this.grandTtlSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akUnit = this.akUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preTo = this.preTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo40ftN1stRto = this.jo40ftN1stRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcBsa40 = this.hcBsa40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Qty = this.rf20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcBsa45 = this.hcBsa45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Qty = this.rf40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt20 = this.mt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftSubTeuQty = this.jo45ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcLd20 = this.hcLd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full20 = this.full20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allWgt = this.allWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtTeu = this.mtTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overSlot = this.overSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftN2ndRto = this.jo45ftN2ndRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtWt = this.mtWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo40ftSubTeuQty = this.jo40ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRepCrrFlg = this.joRepCrrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumFlg = this.sumFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo20ftSubTeuQty = this.jo20ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subChk = this.subChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overWgt = this.overWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allTeu = this.allTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrierCnt = this.carrierCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.source = this.source .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grandTtlWgt = this.grandTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo20ftN1stRto = this.jo20ftN1stRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20 = this.dg20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40 = this.dg40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuQty = this.teuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitNo = this.splitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.rdrFlg = this.rdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.rfRdrQty = this.rfRdrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.pass = this.pass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.optTgt = this.optTgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.optClz = this.optClz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.mergeCrr = this.mergeCrr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.rfRdr20 = this.rfRdr20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.rfRdr40 = this.rfRdr40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
