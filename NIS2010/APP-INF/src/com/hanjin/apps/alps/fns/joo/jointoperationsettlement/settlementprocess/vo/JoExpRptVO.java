/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JoExpRptVO.java
*@FileTitle : JoExpRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.21
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.09.21 민정호 
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

public class JoExpRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JoExpRptVO> models = new ArrayList<JoExpRptVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String hcLd45 = null;
	/* Column Info */
	private String joOvrBsaTeuQty = null;
	/* Column Info */
	private String hcBsa20 = null;
	/* Column Info */
	private String akVoid = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String joBsaTeuQty = null;
	/* Column Info */
	private String mt40 = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String rfRdrQty = null;
	/* Column Info */
	private String subletTeu = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String jo45ftN1stRto = null;
	/* Column Info */
	private String full40 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String hcLd40 = null;
	/* Column Info */
	private String joRndRuleLvl = null;
	/* Column Info */
	private String joRdrPortCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String akUnit = null;
	/* Column Info */
	private String teuQty = null;
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
	private String mtTeu = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String jo45ftN2ndRto = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String dg20 = null;
	/* Column Info */
	private String mtWt = null;
	/* Column Info */
	private String jo40ftSubTeuQty = null;
	/* Column Info */
	private String subChk = null;
	/* Column Info */
	private String jo20ftSubTeuQty = null;
	/* Column Info */
	private String dg40 = null;
	/* Column Info */
	private String allWgt2 = null;
	/* Column Info */
	private String allTeu2 = null;
	/* Column Info */
	private String rdrFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String pass = null;
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String source = null;
	/* Column Info */
	private String grandTtlWgt = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String jo20ftN1stRto = null;
	/* Column Info */
	private String joOvrTonWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public JoExpRptVO() {}

	public JoExpRptVO(String ibflag, String pagerows, String trdCd, String crrCd, String rlaneCd, String reDivrCd, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String tmlCd, String ydCd, String clptIndSeq, String vpsEtdDt, String rdrFlg, String revDirCd, String grandTtlWgt, String full20, String mt20, String full40, String mt40, String hcLd20, String hcBsa20, String hcLd40, String hcBsa40, String hcLd45, String hcBsa45, String akUnit, String rf20Qty, String rfRdrQty, String rf40Qty, String dg20, String dg40, String akVoid, String pass, String subChk, String allTeu2, String allWgt2, String source, String jo20ftSubTeuQty, String jo20ftN1stRto, String jo40ftSubTeuQty, String jo40ftN1stRto, String jo45ftSubTeuQty, String jo45ftN1stRto, String jo45ftN2ndRto, String joRndRuleLvl, String teuQty, String mtTeu, String mtWt, String portCd, String portSeq, String joBsaTeuQty, String joOvrBsaTeuQty, String joOvrTonWgt, String joRdrPortCd, String subletTeu) {
		this.vslCd = vslCd;
		this.hcLd45 = hcLd45;
		this.joOvrBsaTeuQty = joOvrBsaTeuQty;
		this.hcBsa20 = hcBsa20;
		this.akVoid = akVoid;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.joBsaTeuQty = joBsaTeuQty;
		this.mt40 = mt40;
		this.tmlCd = tmlCd;
		this.rfRdrQty = rfRdrQty;
		this.subletTeu = subletTeu;
		this.crrCd = crrCd;
		this.jo45ftN1stRto = jo45ftN1stRto;
		this.full40 = full40;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.hcLd40 = hcLd40;
		this.joRndRuleLvl = joRndRuleLvl;
		this.joRdrPortCd = joRdrPortCd;
		this.vpsEtdDt = vpsEtdDt;
		this.skdVoyNo = skdVoyNo;
		this.akUnit = akUnit;
		this.teuQty = teuQty;
		this.jo40ftN1stRto = jo40ftN1stRto;
		this.hcBsa40 = hcBsa40;
		this.rf20Qty = rf20Qty;
		this.hcBsa45 = hcBsa45;
		this.rf40Qty = rf40Qty;
		this.mt20 = mt20;
		this.jo45ftSubTeuQty = jo45ftSubTeuQty;
		this.hcLd20 = hcLd20;
		this.full20 = full20;
		this.mtTeu = mtTeu;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.jo45ftN2ndRto = jo45ftN2ndRto;
		this.portCd = portCd;
		this.dg20 = dg20;
		this.mtWt = mtWt;
		this.jo40ftSubTeuQty = jo40ftSubTeuQty;
		this.subChk = subChk;
		this.jo20ftSubTeuQty = jo20ftSubTeuQty;
		this.dg40 = dg40;
		this.allWgt2 = allWgt2;
		this.allTeu2 = allTeu2;
		this.rdrFlg = rdrFlg;
		this.skdDirCd = skdDirCd;
		this.pass = pass;
		this.portSeq = portSeq;
		this.source = source;
		this.grandTtlWgt = grandTtlWgt;
		this.ydCd = ydCd;
		this.reDivrCd = reDivrCd;
		this.clptIndSeq = clptIndSeq;
		this.jo20ftN1stRto = jo20ftN1stRto;
		this.joOvrTonWgt = joOvrTonWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("hc_ld_45", getHcLd45());
		this.hashColumns.put("jo_ovr_bsa_teu_qty", getJoOvrBsaTeuQty());
		this.hashColumns.put("hc_bsa_20", getHcBsa20());
		this.hashColumns.put("ak_void", getAkVoid());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("jo_bsa_teu_qty", getJoBsaTeuQty());
		this.hashColumns.put("mt_40", getMt40());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("rf_rdr_qty", getRfRdrQty());
		this.hashColumns.put("sublet_teu", getSubletTeu());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("jo_45ft_n1st_rto", getJo45ftN1stRto());
		this.hashColumns.put("full_40", getFull40());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("hc_ld_40", getHcLd40());
		this.hashColumns.put("jo_rnd_rule_lvl", getJoRndRuleLvl());
		this.hashColumns.put("jo_rdr_port_cd", getJoRdrPortCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ak_unit", getAkUnit());
		this.hashColumns.put("teu_qty", getTeuQty());
		this.hashColumns.put("jo_40ft_n1st_rto", getJo40ftN1stRto());
		this.hashColumns.put("hc_bsa_40", getHcBsa40());
		this.hashColumns.put("rf_20_qty", getRf20Qty());
		this.hashColumns.put("hc_bsa_45", getHcBsa45());
		this.hashColumns.put("rf_40_qty", getRf40Qty());
		this.hashColumns.put("mt_20", getMt20());
		this.hashColumns.put("jo_45ft_sub_teu_qty", getJo45ftSubTeuQty());
		this.hashColumns.put("hc_ld_20", getHcLd20());
		this.hashColumns.put("full_20", getFull20());
		this.hashColumns.put("mt_teu", getMtTeu());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("jo_45ft_n2nd_rto", getJo45ftN2ndRto());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("dg_20", getDg20());
		this.hashColumns.put("mt_wt", getMtWt());
		this.hashColumns.put("jo_40ft_sub_teu_qty", getJo40ftSubTeuQty());
		this.hashColumns.put("sub_chk", getSubChk());
		this.hashColumns.put("jo_20ft_sub_teu_qty", getJo20ftSubTeuQty());
		this.hashColumns.put("dg_40", getDg40());
		this.hashColumns.put("all_wgt2", getAllWgt2());
		this.hashColumns.put("all_teu2", getAllTeu2());
		this.hashColumns.put("rdr_flg", getRdrFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pass", getPass());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("source", getSource());
		this.hashColumns.put("grand_ttl_wgt", getGrandTtlWgt());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("jo_20ft_n1st_rto", getJo20ftN1stRto());
		this.hashColumns.put("jo_ovr_ton_wgt", getJoOvrTonWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("hc_ld_45", "hcLd45");
		this.hashFields.put("jo_ovr_bsa_teu_qty", "joOvrBsaTeuQty");
		this.hashFields.put("hc_bsa_20", "hcBsa20");
		this.hashFields.put("ak_void", "akVoid");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("jo_bsa_teu_qty", "joBsaTeuQty");
		this.hashFields.put("mt_40", "mt40");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("rf_rdr_qty", "rfRdrQty");
		this.hashFields.put("sublet_teu", "subletTeu");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("jo_45ft_n1st_rto", "jo45ftN1stRto");
		this.hashFields.put("full_40", "full40");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("hc_ld_40", "hcLd40");
		this.hashFields.put("jo_rnd_rule_lvl", "joRndRuleLvl");
		this.hashFields.put("jo_rdr_port_cd", "joRdrPortCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ak_unit", "akUnit");
		this.hashFields.put("teu_qty", "teuQty");
		this.hashFields.put("jo_40ft_n1st_rto", "jo40ftN1stRto");
		this.hashFields.put("hc_bsa_40", "hcBsa40");
		this.hashFields.put("rf_20_qty", "rf20Qty");
		this.hashFields.put("hc_bsa_45", "hcBsa45");
		this.hashFields.put("rf_40_qty", "rf40Qty");
		this.hashFields.put("mt_20", "mt20");
		this.hashFields.put("jo_45ft_sub_teu_qty", "jo45ftSubTeuQty");
		this.hashFields.put("hc_ld_20", "hcLd20");
		this.hashFields.put("full_20", "full20");
		this.hashFields.put("mt_teu", "mtTeu");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("jo_45ft_n2nd_rto", "jo45ftN2ndRto");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("dg_20", "dg20");
		this.hashFields.put("mt_wt", "mtWt");
		this.hashFields.put("jo_40ft_sub_teu_qty", "jo40ftSubTeuQty");
		this.hashFields.put("sub_chk", "subChk");
		this.hashFields.put("jo_20ft_sub_teu_qty", "jo20ftSubTeuQty");
		this.hashFields.put("dg_40", "dg40");
		this.hashFields.put("all_wgt2", "allWgt2");
		this.hashFields.put("all_teu2", "allTeu2");
		this.hashFields.put("rdr_flg", "rdrFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pass", "pass");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("source", "source");
		this.hashFields.put("grand_ttl_wgt", "grandTtlWgt");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("jo_20ft_n1st_rto", "jo20ftN1stRto");
		this.hashFields.put("jo_ovr_ton_wgt", "joOvrTonWgt");
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
	 * @return joOvrBsaTeuQty
	 */
	public String getJoOvrBsaTeuQty() {
		return this.joOvrBsaTeuQty;
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
	 * @return akVoid
	 */
	public String getAkVoid() {
		return this.akVoid;
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
	 * @return joBsaTeuQty
	 */
	public String getJoBsaTeuQty() {
		return this.joBsaTeuQty;
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
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
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
	 * @return subletTeu
	 */
	public String getSubletTeu() {
		return this.subletTeu;
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
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
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
	 * @return akUnit
	 */
	public String getAkUnit() {
		return this.akUnit;
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
	 * @return mtTeu
	 */
	public String getMtTeu() {
		return this.mtTeu;
	}
	
	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @return subChk
	 */
	public String getSubChk() {
		return this.subChk;
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
	 * @return dg40
	 */
	public String getDg40() {
		return this.dg40;
	}
	
	/**
	 * Column Info
	 * @return allWgt2
	 */
	public String getAllWgt2() {
		return this.allWgt2;
	}
	
	/**
	 * Column Info
	 * @return allTeu2
	 */
	public String getAllTeu2() {
		return this.allTeu2;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
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
	 * @return grandTtlWgt
	 */
	public String getGrandTtlWgt() {
		return this.grandTtlWgt;
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
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
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
	 * @return jo20ftN1stRto
	 */
	public String getJo20ftN1stRto() {
		return this.jo20ftN1stRto;
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
	 * @param joOvrBsaTeuQty
	 */
	public void setJoOvrBsaTeuQty(String joOvrBsaTeuQty) {
		this.joOvrBsaTeuQty = joOvrBsaTeuQty;
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
	 * @param akVoid
	 */
	public void setAkVoid(String akVoid) {
		this.akVoid = akVoid;
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
	 * @param joBsaTeuQty
	 */
	public void setJoBsaTeuQty(String joBsaTeuQty) {
		this.joBsaTeuQty = joBsaTeuQty;
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
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
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
	 * @param subletTeu
	 */
	public void setSubletTeu(String subletTeu) {
		this.subletTeu = subletTeu;
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
	 * @param joRdrPortCd
	 */
	public void setJoRdrPortCd(String joRdrPortCd) {
		this.joRdrPortCd = joRdrPortCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param teuQty
	 */
	public void setTeuQty(String teuQty) {
		this.teuQty = teuQty;
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
	 * @param mtTeu
	 */
	public void setMtTeu(String mtTeu) {
		this.mtTeu = mtTeu;
	}
	
	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
	 * @param subChk
	 */
	public void setSubChk(String subChk) {
		this.subChk = subChk;
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
	 * @param dg40
	 */
	public void setDg40(String dg40) {
		this.dg40 = dg40;
	}
	
	/**
	 * Column Info
	 * @param allWgt2
	 */
	public void setAllWgt2(String allWgt2) {
		this.allWgt2 = allWgt2;
	}
	
	/**
	 * Column Info
	 * @param allTeu2
	 */
	public void setAllTeu2(String allTeu2) {
		this.allTeu2 = allTeu2;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
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
	 * @param grandTtlWgt
	 */
	public void setGrandTtlWgt(String grandTtlWgt) {
		this.grandTtlWgt = grandTtlWgt;
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
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
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
	 * @param jo20ftN1stRto
	 */
	public void setJo20ftN1stRto(String jo20ftN1stRto) {
		this.jo20ftN1stRto = jo20ftN1stRto;
	}
	
	/**
	 * Column Info
	 * @param joOvrTonWgt
	 */
	public void setJoOvrTonWgt(String joOvrTonWgt) {
		this.joOvrTonWgt = joOvrTonWgt;
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
		setJoOvrBsaTeuQty(JSPUtil.getParameter(request, prefix + "jo_ovr_bsa_teu_qty", ""));
		setHcBsa20(JSPUtil.getParameter(request, prefix + "hc_bsa_20", ""));
		setAkVoid(JSPUtil.getParameter(request, prefix + "ak_void", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setJoBsaTeuQty(JSPUtil.getParameter(request, prefix + "jo_bsa_teu_qty", ""));
		setMt40(JSPUtil.getParameter(request, prefix + "mt_40", ""));
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setRfRdrQty(JSPUtil.getParameter(request, prefix + "rf_rdr_qty", ""));
		setSubletTeu(JSPUtil.getParameter(request, prefix + "sublet_teu", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setJo45ftN1stRto(JSPUtil.getParameter(request, prefix + "jo_45ft_n1st_rto", ""));
		setFull40(JSPUtil.getParameter(request, prefix + "full_40", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setHcLd40(JSPUtil.getParameter(request, prefix + "hc_ld_40", ""));
		setJoRndRuleLvl(JSPUtil.getParameter(request, prefix + "jo_rnd_rule_lvl", ""));
		setJoRdrPortCd(JSPUtil.getParameter(request, prefix + "jo_rdr_port_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setAkUnit(JSPUtil.getParameter(request, prefix + "ak_unit", ""));
		setTeuQty(JSPUtil.getParameter(request, prefix + "teu_qty", ""));
		setJo40ftN1stRto(JSPUtil.getParameter(request, prefix + "jo_40ft_n1st_rto", ""));
		setHcBsa40(JSPUtil.getParameter(request, prefix + "hc_bsa_40", ""));
		setRf20Qty(JSPUtil.getParameter(request, prefix + "rf_20_qty", ""));
		setHcBsa45(JSPUtil.getParameter(request, prefix + "hc_bsa_45", ""));
		setRf40Qty(JSPUtil.getParameter(request, prefix + "rf_40_qty", ""));
		setMt20(JSPUtil.getParameter(request, prefix + "mt_20", ""));
		setJo45ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_45ft_sub_teu_qty", ""));
		setHcLd20(JSPUtil.getParameter(request, prefix + "hc_ld_20", ""));
		setFull20(JSPUtil.getParameter(request, prefix + "full_20", ""));
		setMtTeu(JSPUtil.getParameter(request, prefix + "mt_teu", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setJo45ftN2ndRto(JSPUtil.getParameter(request, prefix + "jo_45ft_n2nd_rto", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setDg20(JSPUtil.getParameter(request, prefix + "dg_20", ""));
		setMtWt(JSPUtil.getParameter(request, prefix + "mt_wt", ""));
		setJo40ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_40ft_sub_teu_qty", ""));
		setSubChk(JSPUtil.getParameter(request, prefix + "sub_chk", ""));
		setJo20ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_20ft_sub_teu_qty", ""));
		setDg40(JSPUtil.getParameter(request, prefix + "dg_40", ""));
		setAllWgt2(JSPUtil.getParameter(request, prefix + "all_wgt2", ""));
		setAllTeu2(JSPUtil.getParameter(request, prefix + "all_teu2", ""));
		setRdrFlg(JSPUtil.getParameter(request, prefix + "rdr_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPass(JSPUtil.getParameter(request, prefix + "pass", ""));
		setPortSeq(JSPUtil.getParameter(request, prefix + "port_seq", ""));
		setSource(JSPUtil.getParameter(request, prefix + "source", ""));
		setGrandTtlWgt(JSPUtil.getParameter(request, prefix + "grand_ttl_wgt", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setJo20ftN1stRto(JSPUtil.getParameter(request, prefix + "jo_20ft_n1st_rto", ""));
		setJoOvrTonWgt(JSPUtil.getParameter(request, prefix + "jo_ovr_ton_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JoExpRptVO[]
	 */
	public JoExpRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JoExpRptVO[]
	 */
	public JoExpRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JoExpRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] hcLd45 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_45", length));
			String[] joOvrBsaTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_ovr_bsa_teu_qty", length));
			String[] hcBsa20 = (JSPUtil.getParameter(request, prefix	+ "hc_bsa_20", length));
			String[] akVoid = (JSPUtil.getParameter(request, prefix	+ "ak_void", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] joBsaTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_teu_qty", length));
			String[] mt40 = (JSPUtil.getParameter(request, prefix	+ "mt_40", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] rfRdrQty = (JSPUtil.getParameter(request, prefix	+ "rf_rdr_qty", length));
			String[] subletTeu = (JSPUtil.getParameter(request, prefix	+ "sublet_teu", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] jo45ftN1stRto = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_n1st_rto", length));
			String[] full40 = (JSPUtil.getParameter(request, prefix	+ "full_40", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] hcLd40 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_40", length));
			String[] joRndRuleLvl = (JSPUtil.getParameter(request, prefix	+ "jo_rnd_rule_lvl", length));
			String[] joRdrPortCd = (JSPUtil.getParameter(request, prefix	+ "jo_rdr_port_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] akUnit = (JSPUtil.getParameter(request, prefix	+ "ak_unit", length));
			String[] teuQty = (JSPUtil.getParameter(request, prefix	+ "teu_qty", length));
			String[] jo40ftN1stRto = (JSPUtil.getParameter(request, prefix	+ "jo_40ft_n1st_rto", length));
			String[] hcBsa40 = (JSPUtil.getParameter(request, prefix	+ "hc_bsa_40", length));
			String[] rf20Qty = (JSPUtil.getParameter(request, prefix	+ "rf_20_qty", length));
			String[] hcBsa45 = (JSPUtil.getParameter(request, prefix	+ "hc_bsa_45", length));
			String[] rf40Qty = (JSPUtil.getParameter(request, prefix	+ "rf_40_qty", length));
			String[] mt20 = (JSPUtil.getParameter(request, prefix	+ "mt_20", length));
			String[] jo45ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_sub_teu_qty", length));
			String[] hcLd20 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_20", length));
			String[] full20 = (JSPUtil.getParameter(request, prefix	+ "full_20", length));
			String[] mtTeu = (JSPUtil.getParameter(request, prefix	+ "mt_teu", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] jo45ftN2ndRto = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_n2nd_rto", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] dg20 = (JSPUtil.getParameter(request, prefix	+ "dg_20", length));
			String[] mtWt = (JSPUtil.getParameter(request, prefix	+ "mt_wt", length));
			String[] jo40ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_40ft_sub_teu_qty", length));
			String[] subChk = (JSPUtil.getParameter(request, prefix	+ "sub_chk", length));
			String[] jo20ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_20ft_sub_teu_qty", length));
			String[] dg40 = (JSPUtil.getParameter(request, prefix	+ "dg_40", length));
			String[] allWgt2 = (JSPUtil.getParameter(request, prefix	+ "all_wgt2", length));
			String[] allTeu2 = (JSPUtil.getParameter(request, prefix	+ "all_teu2", length));
			String[] rdrFlg = (JSPUtil.getParameter(request, prefix	+ "rdr_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pass = (JSPUtil.getParameter(request, prefix	+ "pass", length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] source = (JSPUtil.getParameter(request, prefix	+ "source", length));
			String[] grandTtlWgt = (JSPUtil.getParameter(request, prefix	+ "grand_ttl_wgt", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] jo20ftN1stRto = (JSPUtil.getParameter(request, prefix	+ "jo_20ft_n1st_rto", length));
			String[] joOvrTonWgt = (JSPUtil.getParameter(request, prefix	+ "jo_ovr_ton_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new JoExpRptVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (hcLd45[i] != null)
					model.setHcLd45(hcLd45[i]);
				if (joOvrBsaTeuQty[i] != null)
					model.setJoOvrBsaTeuQty(joOvrBsaTeuQty[i]);
				if (hcBsa20[i] != null)
					model.setHcBsa20(hcBsa20[i]);
				if (akVoid[i] != null)
					model.setAkVoid(akVoid[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (joBsaTeuQty[i] != null)
					model.setJoBsaTeuQty(joBsaTeuQty[i]);
				if (mt40[i] != null)
					model.setMt40(mt40[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (rfRdrQty[i] != null)
					model.setRfRdrQty(rfRdrQty[i]);
				if (subletTeu[i] != null)
					model.setSubletTeu(subletTeu[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (jo45ftN1stRto[i] != null)
					model.setJo45ftN1stRto(jo45ftN1stRto[i]);
				if (full40[i] != null)
					model.setFull40(full40[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (hcLd40[i] != null)
					model.setHcLd40(hcLd40[i]);
				if (joRndRuleLvl[i] != null)
					model.setJoRndRuleLvl(joRndRuleLvl[i]);
				if (joRdrPortCd[i] != null)
					model.setJoRdrPortCd(joRdrPortCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (akUnit[i] != null)
					model.setAkUnit(akUnit[i]);
				if (teuQty[i] != null)
					model.setTeuQty(teuQty[i]);
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
				if (mtTeu[i] != null)
					model.setMtTeu(mtTeu[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (jo45ftN2ndRto[i] != null)
					model.setJo45ftN2ndRto(jo45ftN2ndRto[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (dg20[i] != null)
					model.setDg20(dg20[i]);
				if (mtWt[i] != null)
					model.setMtWt(mtWt[i]);
				if (jo40ftSubTeuQty[i] != null)
					model.setJo40ftSubTeuQty(jo40ftSubTeuQty[i]);
				if (subChk[i] != null)
					model.setSubChk(subChk[i]);
				if (jo20ftSubTeuQty[i] != null)
					model.setJo20ftSubTeuQty(jo20ftSubTeuQty[i]);
				if (dg40[i] != null)
					model.setDg40(dg40[i]);
				if (allWgt2[i] != null)
					model.setAllWgt2(allWgt2[i]);
				if (allTeu2[i] != null)
					model.setAllTeu2(allTeu2[i]);
				if (rdrFlg[i] != null)
					model.setRdrFlg(rdrFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pass[i] != null)
					model.setPass(pass[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (source[i] != null)
					model.setSource(source[i]);
				if (grandTtlWgt[i] != null)
					model.setGrandTtlWgt(grandTtlWgt[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (jo20ftN1stRto[i] != null)
					model.setJo20ftN1stRto(jo20ftN1stRto[i]);
				if (joOvrTonWgt[i] != null)
					model.setJoOvrTonWgt(joOvrTonWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJoExpRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JoExpRptVO[]
	 */
	public JoExpRptVO[] getJoExpRptVOs(){
		JoExpRptVO[] vos = (JoExpRptVO[])models.toArray(new JoExpRptVO[models.size()]);
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
		this.joOvrBsaTeuQty = this.joOvrBsaTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcBsa20 = this.hcBsa20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akVoid = this.akVoid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaTeuQty = this.joBsaTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt40 = this.mt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRdrQty = this.rfRdrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subletTeu = this.subletTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftN1stRto = this.jo45ftN1stRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full40 = this.full40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcLd40 = this.hcLd40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRndRuleLvl = this.joRndRuleLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRdrPortCd = this.joRdrPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akUnit = this.akUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuQty = this.teuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo40ftN1stRto = this.jo40ftN1stRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcBsa40 = this.hcBsa40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Qty = this.rf20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcBsa45 = this.hcBsa45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Qty = this.rf40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt20 = this.mt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftSubTeuQty = this.jo45ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcLd20 = this.hcLd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full20 = this.full20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtTeu = this.mtTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftN2ndRto = this.jo45ftN2ndRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20 = this.dg20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtWt = this.mtWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo40ftSubTeuQty = this.jo40ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subChk = this.subChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo20ftSubTeuQty = this.jo20ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40 = this.dg40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allWgt2 = this.allWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allTeu2 = this.allTeu2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdrFlg = this.rdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pass = this.pass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.source = this.source .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grandTtlWgt = this.grandTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo20ftN1stRto = this.jo20ftN1stRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joOvrTonWgt = this.joOvrTonWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
