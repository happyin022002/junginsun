/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BsaInformationEntryVO.java
*@FileTitle : BsaInformationEntryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.27
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.09.27 최덕우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo;

import java.lang.reflect.Field;
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
 * @author 최덕우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BsaInformationEntryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BsaInformationEntryVO> models = new ArrayList<BsaInformationEntryVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String joOvrBsaTeuQty = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String joAddCrrCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String joBsaTeuQty = null;
	/* Column Info */
	private String joOvrOcnPrc = null;
	/* Column Info */
	private String toYrWk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String joSctrPrcFlg = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String fmEtdDt = null;
	/* Column Info */
	private String joBsaEntrRdrRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String joRndRuleLvl = null;
	/* Column Info */
	private String joTonTeuQty = null;
	/* Column Info */
	private String joRdrPortCd = null;
	/* Column Info */
	private String joBsaAddTeuQty = null;
	/* Column Info */
	private String joPrcFshFlg = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String joBsaAddRefSeq = null;
	/* Column Info */
	private String joRfInterPrc = null;
	/* Column Info */
	private String joBsaEntrRmk = null;
	/* Column Info */
	private String addCarrier = null;
	/* Column Info */
	private String joRfInterTeuQty = null;
	/* Column Info */
	private String joBsaRefSeq = null;
	/* Column Info */
	private String creDtFr = null;
	/* Column Info */
	private String joInterOvrFlg = null;
	/* Column Info */
	private String joRndKndFlg = null;
	/* Column Info */
	private String joOvrMtOcnPrc = null;
	/* Column Info */
	private String joRfOcnPrc = null;
	/* Column Info */
	private String joOvrMtInterPrc = null;
	/* Column Info */
	private String jo45ftUndRto = null;
	/* Column Info */
	private String fmYrWk = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String jo45ftOvrRto = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String jo45ftSubTeuQty = null;
	/* Column Info */
	private String vvdPort = null;
	/* Column Info */
	private String creDtTo = null;
	/* Column Info */
	private String joAddBsaCrrFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String yrwk = null;
	/* Column Info */
	private String joRfOcnTeuQty = null;
	/* Column Info */
	private String toEtdDt = null;
	/* Column Info */
	private String jo20ftOvrRto = null;
	/* Column Info */
	private String joBsaPrc = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String jo40ftOvrRto = null;
	/* Column Info */
	private String jo40ftSubTeuQty = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String jo20ftSubTeuQty = null;
	/* Column Info */
	private String revPortEtdDt = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String joPrcFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String joFshFlg = null;
	/* Column Info */
	private String joOvrInterPrc = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String joOvrTonWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BsaInformationEntryVO() {}

	public BsaInformationEntryVO(String ibflag, String pagerows, String vslCd, String joOvrBsaTeuQty, String trdCd, String rlaneCd, String joBsaTeuQty, String joOvrOcnPrc, String toYrWk, String joSctrPrcFlg, String vvdCd, String fmEtdDt, String joBsaEntrRdrRmk, String updUsrId, String joTonTeuQty, String joRndRuleLvl, String joRdrPortCd, String joBsaAddTeuQty, String joPrcFshFlg, String skdVoyNo, String joBsaAddRefSeq, String joRfInterPrc, String joBsaEntrRmk, String addCarrier, String joRfInterTeuQty, String joBsaRefSeq, String creDtFr, String joInterOvrFlg, String joRndKndFlg, String joOvrMtOcnPrc, String joRfOcnPrc, String joOvrMtInterPrc, String jo45ftUndRto, String fmYrWk, String deltFlg, String jo45ftOvrRto, String creDt, String jo45ftSubTeuQty, String vvdPort, String creDtTo, String joAddBsaCrrFlg, String usrNm, String yrwk, String joRfOcnTeuQty, String toEtdDt, String jo20ftOvrRto, String joBsaPrc, String portCd, String jo40ftOvrRto, String jo40ftSubTeuQty, String jo20ftSubTeuQty, String revPortEtdDt, String joCrrCd, String joPrcFlg, String skdDirCd, String ofcCd, String portSeq, String joFshFlg, String joOvrInterPrc, String reDivrCd, String joOvrTonWgt, String joAddCrrCd, String updDt) {
		this.vslCd = vslCd;
		this.joOvrBsaTeuQty = joOvrBsaTeuQty;
		this.trdCd = trdCd;
		this.joAddCrrCd = joAddCrrCd;
		this.rlaneCd = rlaneCd;
		this.joBsaTeuQty = joBsaTeuQty;
		this.joOvrOcnPrc = joOvrOcnPrc;
		this.toYrWk = toYrWk;
		this.pagerows = pagerows;
		this.joSctrPrcFlg = joSctrPrcFlg;
		this.vvdCd = vvdCd;
		this.fmEtdDt = fmEtdDt;
		this.joBsaEntrRdrRmk = joBsaEntrRdrRmk;
		this.updUsrId = updUsrId;
		this.joRndRuleLvl = joRndRuleLvl;
		this.joTonTeuQty = joTonTeuQty;
		this.joRdrPortCd = joRdrPortCd;
		this.joBsaAddTeuQty = joBsaAddTeuQty;
		this.joPrcFshFlg = joPrcFshFlg;
		this.skdVoyNo = skdVoyNo;
		this.joBsaAddRefSeq = joBsaAddRefSeq;
		this.joRfInterPrc = joRfInterPrc;
		this.joBsaEntrRmk = joBsaEntrRmk;
		this.addCarrier = addCarrier;
		this.joRfInterTeuQty = joRfInterTeuQty;
		this.joBsaRefSeq = joBsaRefSeq;
		this.creDtFr = creDtFr;
		this.joInterOvrFlg = joInterOvrFlg;
		this.joRndKndFlg = joRndKndFlg;
		this.joOvrMtOcnPrc = joOvrMtOcnPrc;
		this.joRfOcnPrc = joRfOcnPrc;
		this.joOvrMtInterPrc = joOvrMtInterPrc;
		this.jo45ftUndRto = jo45ftUndRto;
		this.fmYrWk = fmYrWk;
		this.deltFlg = deltFlg;
		this.jo45ftOvrRto = jo45ftOvrRto;
		this.creDt = creDt;
		this.jo45ftSubTeuQty = jo45ftSubTeuQty;
		this.vvdPort = vvdPort;
		this.creDtTo = creDtTo;
		this.joAddBsaCrrFlg = joAddBsaCrrFlg;
		this.ibflag = ibflag;
		this.usrNm = usrNm;
		this.yrwk = yrwk;
		this.joRfOcnTeuQty = joRfOcnTeuQty;
		this.toEtdDt = toEtdDt;
		this.jo20ftOvrRto = jo20ftOvrRto;
		this.joBsaPrc = joBsaPrc;
		this.portCd = portCd;
		this.jo40ftOvrRto = jo40ftOvrRto;
		this.jo40ftSubTeuQty = jo40ftSubTeuQty;
		this.updDt = updDt;
		this.jo20ftSubTeuQty = jo20ftSubTeuQty;
		this.revPortEtdDt = revPortEtdDt;
		this.joCrrCd = joCrrCd;
		this.joPrcFlg = joPrcFlg;
		this.skdDirCd = skdDirCd;
		this.portSeq = portSeq;
		this.ofcCd = ofcCd;
		this.joFshFlg = joFshFlg;
		this.joOvrInterPrc = joOvrInterPrc;
		this.reDivrCd = reDivrCd;
		this.joOvrTonWgt = joOvrTonWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("jo_ovr_bsa_teu_qty", getJoOvrBsaTeuQty());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("jo_add_crr_cd", getJoAddCrrCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("jo_bsa_teu_qty", getJoBsaTeuQty());
		this.hashColumns.put("jo_ovr_ocn_prc", getJoOvrOcnPrc());
		this.hashColumns.put("to_yr_wk", getToYrWk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("jo_sctr_prc_flg", getJoSctrPrcFlg());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("fm_etd_dt", getFmEtdDt());
		this.hashColumns.put("jo_bsa_entr_rdr_rmk", getJoBsaEntrRdrRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("jo_rnd_rule_lvl", getJoRndRuleLvl());
		this.hashColumns.put("jo_ton_teu_qty", getJoTonTeuQty());
		this.hashColumns.put("jo_rdr_port_cd", getJoRdrPortCd());
		this.hashColumns.put("jo_bsa_add_teu_qty", getJoBsaAddTeuQty());
		this.hashColumns.put("jo_prc_fsh_flg", getJoPrcFshFlg());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("jo_bsa_add_ref_seq", getJoBsaAddRefSeq());
		this.hashColumns.put("jo_rf_inter_prc", getJoRfInterPrc());
		this.hashColumns.put("jo_bsa_entr_rmk", getJoBsaEntrRmk());
		this.hashColumns.put("add_carrier", getAddCarrier());
		this.hashColumns.put("jo_rf_inter_teu_qty", getJoRfInterTeuQty());
		this.hashColumns.put("jo_bsa_ref_seq", getJoBsaRefSeq());
		this.hashColumns.put("cre_dt_fr", getCreDtFr());
		this.hashColumns.put("jo_inter_ovr_flg", getJoInterOvrFlg());
		this.hashColumns.put("jo_rnd_knd_flg", getJoRndKndFlg());
		this.hashColumns.put("jo_ovr_mt_ocn_prc", getJoOvrMtOcnPrc());
		this.hashColumns.put("jo_rf_ocn_prc", getJoRfOcnPrc());
		this.hashColumns.put("jo_ovr_mt_inter_prc", getJoOvrMtInterPrc());
		this.hashColumns.put("jo_45ft_und_rto", getJo45ftUndRto());
		this.hashColumns.put("fm_yr_wk", getFmYrWk());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("jo_45ft_ovr_rto", getJo45ftOvrRto());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("jo_45ft_sub_teu_qty", getJo45ftSubTeuQty());
		this.hashColumns.put("vvd_port", getVvdPort());
		this.hashColumns.put("cre_dt_to", getCreDtTo());
		this.hashColumns.put("jo_add_bsa_crr_flg", getJoAddBsaCrrFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("yrwk", getYrwk());
		this.hashColumns.put("jo_rf_ocn_teu_qty", getJoRfOcnTeuQty());
		this.hashColumns.put("to_etd_dt", getToEtdDt());
		this.hashColumns.put("jo_20ft_ovr_rto", getJo20ftOvrRto());
		this.hashColumns.put("jo_bsa_prc", getJoBsaPrc());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("jo_40ft_ovr_rto", getJo40ftOvrRto());
		this.hashColumns.put("jo_40ft_sub_teu_qty", getJo40ftSubTeuQty());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("jo_20ft_sub_teu_qty", getJo20ftSubTeuQty());
		this.hashColumns.put("rev_port_etd_dt", getRevPortEtdDt());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("jo_prc_flg", getJoPrcFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("jo_fsh_flg", getJoFshFlg());
		this.hashColumns.put("jo_ovr_inter_prc", getJoOvrInterPrc());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("jo_ovr_ton_wgt", getJoOvrTonWgt());
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
		this.hashFields.put("jo_add_crr_cd", "joAddCrrCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("jo_bsa_teu_qty", "joBsaTeuQty");
		this.hashFields.put("jo_ovr_ocn_prc", "joOvrOcnPrc");
		this.hashFields.put("to_yr_wk", "toYrWk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("jo_sctr_prc_flg", "joSctrPrcFlg");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("fm_etd_dt", "fmEtdDt");
		this.hashFields.put("jo_bsa_entr_rdr_rmk", "joBsaEntrRdrRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("jo_rnd_rule_lvl", "joRndRuleLvl");
		this.hashFields.put("jo_ton_teu_qty", "joTonTeuQty");
		this.hashFields.put("jo_rdr_port_cd", "joRdrPortCd");
		this.hashFields.put("jo_bsa_add_teu_qty", "joBsaAddTeuQty");
		this.hashFields.put("jo_prc_fsh_flg", "joPrcFshFlg");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("jo_bsa_add_ref_seq", "joBsaAddRefSeq");
		this.hashFields.put("jo_rf_inter_prc", "joRfInterPrc");
		this.hashFields.put("jo_bsa_entr_rmk", "joBsaEntrRmk");
		this.hashFields.put("add_carrier", "addCarrier");
		this.hashFields.put("jo_rf_inter_teu_qty", "joRfInterTeuQty");
		this.hashFields.put("jo_bsa_ref_seq", "joBsaRefSeq");
		this.hashFields.put("cre_dt_fr", "creDtFr");
		this.hashFields.put("jo_inter_ovr_flg", "joInterOvrFlg");
		this.hashFields.put("jo_rnd_knd_flg", "joRndKndFlg");
		this.hashFields.put("jo_ovr_mt_ocn_prc", "joOvrMtOcnPrc");
		this.hashFields.put("jo_rf_ocn_prc", "joRfOcnPrc");
		this.hashFields.put("jo_ovr_mt_inter_prc", "joOvrMtInterPrc");
		this.hashFields.put("jo_45ft_und_rto", "jo45ftUndRto");
		this.hashFields.put("fm_yr_wk", "fmYrWk");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("jo_45ft_ovr_rto", "jo45ftOvrRto");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("jo_45ft_sub_teu_qty", "jo45ftSubTeuQty");
		this.hashFields.put("vvd_port", "vvdPort");
		this.hashFields.put("cre_dt_to", "creDtTo");
		this.hashFields.put("jo_add_bsa_crr_flg", "joAddBsaCrrFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("yrwk", "yrwk");
		this.hashFields.put("jo_rf_ocn_teu_qty", "joRfOcnTeuQty");
		this.hashFields.put("to_etd_dt", "toEtdDt");
		this.hashFields.put("jo_20ft_ovr_rto", "jo20ftOvrRto");
		this.hashFields.put("jo_bsa_prc", "joBsaPrc");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("jo_40ft_ovr_rto", "jo40ftOvrRto");
		this.hashFields.put("jo_40ft_sub_teu_qty", "jo40ftSubTeuQty");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("jo_20ft_sub_teu_qty", "jo20ftSubTeuQty");
		this.hashFields.put("rev_port_etd_dt", "revPortEtdDt");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("jo_prc_flg", "joPrcFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("jo_fsh_flg", "joFshFlg");
		this.hashFields.put("jo_ovr_inter_prc", "joOvrInterPrc");
		this.hashFields.put("re_divr_cd", "reDivrCd");
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
	 * @return joAddCrrCd
	 */
	public String getJoAddCrrCd() {
		return this.joAddCrrCd;
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
	 * @return joOvrOcnPrc
	 */
	public String getJoOvrOcnPrc() {
		return this.joOvrOcnPrc;
	}
	
	/**
	 * Column Info
	 * @return toYrWk
	 */
	public String getToYrWk() {
		return this.toYrWk;
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
	 * @return joSctrPrcFlg
	 */
	public String getJoSctrPrcFlg() {
		return this.joSctrPrcFlg;
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
	 * @return fmEtdDt
	 */
	public String getFmEtdDt() {
		return this.fmEtdDt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return joTonTeuQty
	 */
	public String getJoTonTeuQty() {
		return this.joTonTeuQty;
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
	 * @return joBsaAddRefSeq
	 */
	public String getJoBsaAddRefSeq() {
		return this.joBsaAddRefSeq;
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
	 * @return addCarrier
	 */
	public String getAddCarrier() {
		return this.addCarrier;
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
	 * @return joBsaRefSeq
	 */
	public String getJoBsaRefSeq() {
		return this.joBsaRefSeq;
	}
	
	/**
	 * Column Info
	 * @return creDtFr
	 */
	public String getCreDtFr() {
		return this.creDtFr;
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
	 * @return joRndKndFlg
	 */
	public String getJoRndKndFlg() {
		return this.joRndKndFlg;
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
	 * @return fmYrWk
	 */
	public String getFmYrWk() {
		return this.fmYrWk;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return vvdPort
	 */
	public String getVvdPort() {
		return this.vvdPort;
	}
	
	/**
	 * Column Info
	 * @return creDtTo
	 */
	public String getCreDtTo() {
		return this.creDtTo;
	}
	
	/**
	 * Column Info
	 * @return joAddBsaCrrFlg
	 */
	public String getJoAddBsaCrrFlg() {
		return this.joAddBsaCrrFlg;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return yrwk
	 */
	public String getYrwk() {
		return this.yrwk;
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
	 * @return toEtdDt
	 */
	public String getToEtdDt() {
		return this.toEtdDt;
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
	 * @return joBsaPrc
	 */
	public String getJoBsaPrc() {
		return this.joBsaPrc;
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
	 * @return jo40ftOvrRto
	 */
	public String getJo40ftOvrRto() {
		return this.jo40ftOvrRto;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return joPrcFlg
	 */
	public String getJoPrcFlg() {
		return this.joPrcFlg;
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
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @param joAddCrrCd
	 */
	public void setJoAddCrrCd(String joAddCrrCd) {
		this.joAddCrrCd = joAddCrrCd;
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
	 * @param joOvrOcnPrc
	 */
	public void setJoOvrOcnPrc(String joOvrOcnPrc) {
		this.joOvrOcnPrc = joOvrOcnPrc;
	}
	
	/**
	 * Column Info
	 * @param toYrWk
	 */
	public void setToYrWk(String toYrWk) {
		this.toYrWk = toYrWk;
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
	 * @param joSctrPrcFlg
	 */
	public void setJoSctrPrcFlg(String joSctrPrcFlg) {
		this.joSctrPrcFlg = joSctrPrcFlg;
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
	 * @param fmEtdDt
	 */
	public void setFmEtdDt(String fmEtdDt) {
		this.fmEtdDt = fmEtdDt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param joTonTeuQty
	 */
	public void setJoTonTeuQty(String joTonTeuQty) {
		this.joTonTeuQty = joTonTeuQty;
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
	 * @param joBsaAddRefSeq
	 */
	public void setJoBsaAddRefSeq(String joBsaAddRefSeq) {
		this.joBsaAddRefSeq = joBsaAddRefSeq;
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
	 * @param addCarrier
	 */
	public void setAddCarrier(String addCarrier) {
		this.addCarrier = addCarrier;
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
	 * @param joBsaRefSeq
	 */
	public void setJoBsaRefSeq(String joBsaRefSeq) {
		this.joBsaRefSeq = joBsaRefSeq;
	}
	
	/**
	 * Column Info
	 * @param creDtFr
	 */
	public void setCreDtFr(String creDtFr) {
		this.creDtFr = creDtFr;
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
	 * @param joRndKndFlg
	 */
	public void setJoRndKndFlg(String joRndKndFlg) {
		this.joRndKndFlg = joRndKndFlg;
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
	 * @param fmYrWk
	 */
	public void setFmYrWk(String fmYrWk) {
		this.fmYrWk = fmYrWk;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param vvdPort
	 */
	public void setVvdPort(String vvdPort) {
		this.vvdPort = vvdPort;
	}
	
	/**
	 * Column Info
	 * @param creDtTo
	 */
	public void setCreDtTo(String creDtTo) {
		this.creDtTo = creDtTo;
	}
	
	/**
	 * Column Info
	 * @param joAddBsaCrrFlg
	 */
	public void setJoAddBsaCrrFlg(String joAddBsaCrrFlg) {
		this.joAddBsaCrrFlg = joAddBsaCrrFlg;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param yrwk
	 */
	public void setYrwk(String yrwk) {
		this.yrwk = yrwk;
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
	 * @param toEtdDt
	 */
	public void setToEtdDt(String toEtdDt) {
		this.toEtdDt = toEtdDt;
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
	 * @param joBsaPrc
	 */
	public void setJoBsaPrc(String joBsaPrc) {
		this.joBsaPrc = joBsaPrc;
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
	 * @param jo40ftOvrRto
	 */
	public void setJo40ftOvrRto(String jo40ftOvrRto) {
		this.jo40ftOvrRto = jo40ftOvrRto;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param joPrcFlg
	 */
	public void setJoPrcFlg(String joPrcFlg) {
		this.joPrcFlg = joPrcFlg;
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
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
		setJoAddCrrCd(JSPUtil.getParameter(request, prefix + "jo_add_crr_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setJoBsaTeuQty(JSPUtil.getParameter(request, prefix + "jo_bsa_teu_qty", ""));
		setJoOvrOcnPrc(JSPUtil.getParameter(request, prefix + "jo_ovr_ocn_prc", ""));
		setToYrWk(JSPUtil.getParameter(request, prefix + "to_yr_wk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setJoSctrPrcFlg(JSPUtil.getParameter(request, prefix + "jo_sctr_prc_flg", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setFmEtdDt(JSPUtil.getParameter(request, prefix + "fm_etd_dt", ""));
		setJoBsaEntrRdrRmk(JSPUtil.getParameter(request, prefix + "jo_bsa_entr_rdr_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setJoRndRuleLvl(JSPUtil.getParameter(request, prefix + "jo_rnd_rule_lvl", ""));
		setJoTonTeuQty(JSPUtil.getParameter(request, prefix + "jo_ton_teu_qty", ""));
		setJoRdrPortCd(JSPUtil.getParameter(request, prefix + "jo_rdr_port_cd", ""));
		setJoBsaAddTeuQty(JSPUtil.getParameter(request, prefix + "jo_bsa_add_teu_qty", ""));
		setJoPrcFshFlg(JSPUtil.getParameter(request, prefix + "jo_prc_fsh_flg", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setJoBsaAddRefSeq(JSPUtil.getParameter(request, prefix + "jo_bsa_add_ref_seq", ""));
		setJoRfInterPrc(JSPUtil.getParameter(request, prefix + "jo_rf_inter_prc", ""));
		setJoBsaEntrRmk(JSPUtil.getParameter(request, prefix + "jo_bsa_entr_rmk", ""));
		setAddCarrier(JSPUtil.getParameter(request, prefix + "add_carrier", ""));
		setJoRfInterTeuQty(JSPUtil.getParameter(request, prefix + "jo_rf_inter_teu_qty", ""));
		setJoBsaRefSeq(JSPUtil.getParameter(request, prefix + "jo_bsa_ref_seq", ""));
		setCreDtFr(JSPUtil.getParameter(request, prefix + "cre_dt_fr", ""));
		setJoInterOvrFlg(JSPUtil.getParameter(request, prefix + "jo_inter_ovr_flg", ""));
		setJoRndKndFlg(JSPUtil.getParameter(request, prefix + "jo_rnd_knd_flg", ""));
		setJoOvrMtOcnPrc(JSPUtil.getParameter(request, prefix + "jo_ovr_mt_ocn_prc", ""));
		setJoRfOcnPrc(JSPUtil.getParameter(request, prefix + "jo_rf_ocn_prc", ""));
		setJoOvrMtInterPrc(JSPUtil.getParameter(request, prefix + "jo_ovr_mt_inter_prc", ""));
		setJo45ftUndRto(JSPUtil.getParameter(request, prefix + "jo_45ft_und_rto", ""));
		setFmYrWk(JSPUtil.getParameter(request, prefix + "fm_yr_wk", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setJo45ftOvrRto(JSPUtil.getParameter(request, prefix + "jo_45ft_ovr_rto", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setJo45ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_45ft_sub_teu_qty", ""));
		setVvdPort(JSPUtil.getParameter(request, prefix + "vvd_port", ""));
		setCreDtTo(JSPUtil.getParameter(request, prefix + "cre_dt_to", ""));
		setJoAddBsaCrrFlg(JSPUtil.getParameter(request, prefix + "jo_add_bsa_crr_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setYrwk(JSPUtil.getParameter(request, prefix + "yrwk", ""));
		setJoRfOcnTeuQty(JSPUtil.getParameter(request, prefix + "jo_rf_ocn_teu_qty", ""));
		setToEtdDt(JSPUtil.getParameter(request, prefix + "to_etd_dt", ""));
		setJo20ftOvrRto(JSPUtil.getParameter(request, prefix + "jo_20ft_ovr_rto", ""));
		setJoBsaPrc(JSPUtil.getParameter(request, prefix + "jo_bsa_prc", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setJo40ftOvrRto(JSPUtil.getParameter(request, prefix + "jo_40ft_ovr_rto", ""));
		setJo40ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_40ft_sub_teu_qty", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setJo20ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_20ft_sub_teu_qty", ""));
		setRevPortEtdDt(JSPUtil.getParameter(request, prefix + "rev_port_etd_dt", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setJoPrcFlg(JSPUtil.getParameter(request, prefix + "jo_prc_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPortSeq(JSPUtil.getParameter(request, prefix + "port_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setJoFshFlg(JSPUtil.getParameter(request, prefix + "jo_fsh_flg", ""));
		setJoOvrInterPrc(JSPUtil.getParameter(request, prefix + "jo_ovr_inter_prc", ""));
		setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
		setJoOvrTonWgt(JSPUtil.getParameter(request, prefix + "jo_ovr_ton_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BsaInformationEntryVO[]
	 */
	public BsaInformationEntryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BsaInformationEntryVO[]
	 */
	public BsaInformationEntryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BsaInformationEntryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] joOvrBsaTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_ovr_bsa_teu_qty", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] joAddCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_add_crr_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] joBsaTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_teu_qty", length));
			String[] joOvrOcnPrc = (JSPUtil.getParameter(request, prefix	+ "jo_ovr_ocn_prc", length));
			String[] toYrWk = (JSPUtil.getParameter(request, prefix	+ "to_yr_wk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] joSctrPrcFlg = (JSPUtil.getParameter(request, prefix	+ "jo_sctr_prc_flg", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] fmEtdDt = (JSPUtil.getParameter(request, prefix	+ "fm_etd_dt", length));
			String[] joBsaEntrRdrRmk = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_entr_rdr_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] joRndRuleLvl = (JSPUtil.getParameter(request, prefix	+ "jo_rnd_rule_lvl", length));
			String[] joTonTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_ton_teu_qty", length));
			String[] joRdrPortCd = (JSPUtil.getParameter(request, prefix	+ "jo_rdr_port_cd", length));
			String[] joBsaAddTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_add_teu_qty", length));
			String[] joPrcFshFlg = (JSPUtil.getParameter(request, prefix	+ "jo_prc_fsh_flg", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] joBsaAddRefSeq = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_add_ref_seq", length));
			String[] joRfInterPrc = (JSPUtil.getParameter(request, prefix	+ "jo_rf_inter_prc", length));
			String[] joBsaEntrRmk = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_entr_rmk", length));
			String[] addCarrier = (JSPUtil.getParameter(request, prefix	+ "add_carrier", length));
			String[] joRfInterTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_rf_inter_teu_qty", length));
			String[] joBsaRefSeq = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_ref_seq", length));
			String[] creDtFr = (JSPUtil.getParameter(request, prefix	+ "cre_dt_fr", length));
			String[] joInterOvrFlg = (JSPUtil.getParameter(request, prefix	+ "jo_inter_ovr_flg", length));
			String[] joRndKndFlg = (JSPUtil.getParameter(request, prefix	+ "jo_rnd_knd_flg", length));
			String[] joOvrMtOcnPrc = (JSPUtil.getParameter(request, prefix	+ "jo_ovr_mt_ocn_prc", length));
			String[] joRfOcnPrc = (JSPUtil.getParameter(request, prefix	+ "jo_rf_ocn_prc", length));
			String[] joOvrMtInterPrc = (JSPUtil.getParameter(request, prefix	+ "jo_ovr_mt_inter_prc", length));
			String[] jo45ftUndRto = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_und_rto", length));
			String[] fmYrWk = (JSPUtil.getParameter(request, prefix	+ "fm_yr_wk", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] jo45ftOvrRto = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_ovr_rto", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] jo45ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_sub_teu_qty", length));
			String[] vvdPort = (JSPUtil.getParameter(request, prefix	+ "vvd_port", length));
			String[] creDtTo = (JSPUtil.getParameter(request, prefix	+ "cre_dt_to", length));
			String[] joAddBsaCrrFlg = (JSPUtil.getParameter(request, prefix	+ "jo_add_bsa_crr_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] yrwk = (JSPUtil.getParameter(request, prefix	+ "yrwk", length));
			String[] joRfOcnTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_rf_ocn_teu_qty", length));
			String[] toEtdDt = (JSPUtil.getParameter(request, prefix	+ "to_etd_dt", length));
			String[] jo20ftOvrRto = (JSPUtil.getParameter(request, prefix	+ "jo_20ft_ovr_rto", length));
			String[] joBsaPrc = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_prc", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] jo40ftOvrRto = (JSPUtil.getParameter(request, prefix	+ "jo_40ft_ovr_rto", length));
			String[] jo40ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_40ft_sub_teu_qty", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] jo20ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_20ft_sub_teu_qty", length));
			String[] revPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "rev_port_etd_dt", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] joPrcFlg = (JSPUtil.getParameter(request, prefix	+ "jo_prc_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] joFshFlg = (JSPUtil.getParameter(request, prefix	+ "jo_fsh_flg", length));
			String[] joOvrInterPrc = (JSPUtil.getParameter(request, prefix	+ "jo_ovr_inter_prc", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] joOvrTonWgt = (JSPUtil.getParameter(request, prefix	+ "jo_ovr_ton_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BsaInformationEntryVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (joOvrBsaTeuQty[i] != null)
					model.setJoOvrBsaTeuQty(joOvrBsaTeuQty[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (joAddCrrCd[i] != null)
					model.setJoAddCrrCd(joAddCrrCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (joBsaTeuQty[i] != null)
					model.setJoBsaTeuQty(joBsaTeuQty[i]);
				if (joOvrOcnPrc[i] != null)
					model.setJoOvrOcnPrc(joOvrOcnPrc[i]);
				if (toYrWk[i] != null)
					model.setToYrWk(toYrWk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (joSctrPrcFlg[i] != null)
					model.setJoSctrPrcFlg(joSctrPrcFlg[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (fmEtdDt[i] != null)
					model.setFmEtdDt(fmEtdDt[i]);
				if (joBsaEntrRdrRmk[i] != null)
					model.setJoBsaEntrRdrRmk(joBsaEntrRdrRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (joRndRuleLvl[i] != null)
					model.setJoRndRuleLvl(joRndRuleLvl[i]);
				if (joTonTeuQty[i] != null)
					model.setJoTonTeuQty(joTonTeuQty[i]);
				if (joRdrPortCd[i] != null)
					model.setJoRdrPortCd(joRdrPortCd[i]);
				if (joBsaAddTeuQty[i] != null)
					model.setJoBsaAddTeuQty(joBsaAddTeuQty[i]);
				if (joPrcFshFlg[i] != null)
					model.setJoPrcFshFlg(joPrcFshFlg[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (joBsaAddRefSeq[i] != null)
					model.setJoBsaAddRefSeq(joBsaAddRefSeq[i]);
				if (joRfInterPrc[i] != null)
					model.setJoRfInterPrc(joRfInterPrc[i]);
				if (joBsaEntrRmk[i] != null)
					model.setJoBsaEntrRmk(joBsaEntrRmk[i]);
				if (addCarrier[i] != null)
					model.setAddCarrier(addCarrier[i]);
				if (joRfInterTeuQty[i] != null)
					model.setJoRfInterTeuQty(joRfInterTeuQty[i]);
				if (joBsaRefSeq[i] != null)
					model.setJoBsaRefSeq(joBsaRefSeq[i]);
				if (creDtFr[i] != null)
					model.setCreDtFr(creDtFr[i]);
				if (joInterOvrFlg[i] != null)
					model.setJoInterOvrFlg(joInterOvrFlg[i]);
				if (joRndKndFlg[i] != null)
					model.setJoRndKndFlg(joRndKndFlg[i]);
				if (joOvrMtOcnPrc[i] != null)
					model.setJoOvrMtOcnPrc(joOvrMtOcnPrc[i]);
				if (joRfOcnPrc[i] != null)
					model.setJoRfOcnPrc(joRfOcnPrc[i]);
				if (joOvrMtInterPrc[i] != null)
					model.setJoOvrMtInterPrc(joOvrMtInterPrc[i]);
				if (jo45ftUndRto[i] != null)
					model.setJo45ftUndRto(jo45ftUndRto[i]);
				if (fmYrWk[i] != null)
					model.setFmYrWk(fmYrWk[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (jo45ftOvrRto[i] != null)
					model.setJo45ftOvrRto(jo45ftOvrRto[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (jo45ftSubTeuQty[i] != null)
					model.setJo45ftSubTeuQty(jo45ftSubTeuQty[i]);
				if (vvdPort[i] != null)
					model.setVvdPort(vvdPort[i]);
				if (creDtTo[i] != null)
					model.setCreDtTo(creDtTo[i]);
				if (joAddBsaCrrFlg[i] != null)
					model.setJoAddBsaCrrFlg(joAddBsaCrrFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (yrwk[i] != null)
					model.setYrwk(yrwk[i]);
				if (joRfOcnTeuQty[i] != null)
					model.setJoRfOcnTeuQty(joRfOcnTeuQty[i]);
				if (toEtdDt[i] != null)
					model.setToEtdDt(toEtdDt[i]);
				if (jo20ftOvrRto[i] != null)
					model.setJo20ftOvrRto(jo20ftOvrRto[i]);
				if (joBsaPrc[i] != null)
					model.setJoBsaPrc(joBsaPrc[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (jo40ftOvrRto[i] != null)
					model.setJo40ftOvrRto(jo40ftOvrRto[i]);
				if (jo40ftSubTeuQty[i] != null)
					model.setJo40ftSubTeuQty(jo40ftSubTeuQty[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (jo20ftSubTeuQty[i] != null)
					model.setJo20ftSubTeuQty(jo20ftSubTeuQty[i]);
				if (revPortEtdDt[i] != null)
					model.setRevPortEtdDt(revPortEtdDt[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (joPrcFlg[i] != null)
					model.setJoPrcFlg(joPrcFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (joFshFlg[i] != null)
					model.setJoFshFlg(joFshFlg[i]);
				if (joOvrInterPrc[i] != null)
					model.setJoOvrInterPrc(joOvrInterPrc[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (joOvrTonWgt[i] != null)
					model.setJoOvrTonWgt(joOvrTonWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBsaInformationEntryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BsaInformationEntryVO[]
	 */
	public BsaInformationEntryVO[] getBsaInformationEntryVOs(){
		BsaInformationEntryVO[] vos = (BsaInformationEntryVO[])models.toArray(new BsaInformationEntryVO[models.size()]);
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
		this.joAddCrrCd = this.joAddCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaTeuQty = this.joBsaTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joOvrOcnPrc = this.joOvrOcnPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYrWk = this.toYrWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joSctrPrcFlg = this.joSctrPrcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEtdDt = this.fmEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaEntrRdrRmk = this.joBsaEntrRdrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRndRuleLvl = this.joRndRuleLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joTonTeuQty = this.joTonTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRdrPortCd = this.joRdrPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaAddTeuQty = this.joBsaAddTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joPrcFshFlg = this.joPrcFshFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaAddRefSeq = this.joBsaAddRefSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRfInterPrc = this.joRfInterPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaEntrRmk = this.joBsaEntrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addCarrier = this.addCarrier .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRfInterTeuQty = this.joRfInterTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaRefSeq = this.joBsaRefSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtFr = this.creDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joInterOvrFlg = this.joInterOvrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRndKndFlg = this.joRndKndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joOvrMtOcnPrc = this.joOvrMtOcnPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRfOcnPrc = this.joRfOcnPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joOvrMtInterPrc = this.joOvrMtInterPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftUndRto = this.jo45ftUndRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYrWk = this.fmYrWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftOvrRto = this.jo45ftOvrRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftSubTeuQty = this.jo45ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPort = this.vvdPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtTo = this.creDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joAddBsaCrrFlg = this.joAddBsaCrrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrwk = this.yrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRfOcnTeuQty = this.joRfOcnTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtdDt = this.toEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo20ftOvrRto = this.jo20ftOvrRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaPrc = this.joBsaPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo40ftOvrRto = this.jo40ftOvrRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo40ftSubTeuQty = this.jo40ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo20ftSubTeuQty = this.jo20ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revPortEtdDt = this.revPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joPrcFlg = this.joPrcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joFshFlg = this.joFshFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joOvrInterPrc = this.joOvrInterPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joOvrTonWgt = this.joOvrTonWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
