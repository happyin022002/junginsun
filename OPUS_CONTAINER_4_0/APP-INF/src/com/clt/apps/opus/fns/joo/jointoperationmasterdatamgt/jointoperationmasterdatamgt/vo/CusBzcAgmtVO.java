/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CusBzcAgmtVO.java
*@FileTitle : CusBzcAgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.27
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.12.27 박희동 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CusBzcAgmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CusBzcAgmtVO> models = new ArrayList<CusBzcAgmtVO>();
	
	/* Column Info */
	private String agmtEffDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String joRfGnteInterQty = null;
	/* Column Info */
	private String jo20ftGnteQty = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String joSrcCd = null;
	/* Column Info */
	private String joTonWgtRndRt = null;
	/* Column Info */
	private String agmtExpDt = null;
	/* Column Info */
	private String joBkgTpCd = null;
	/* Column Info */
	private String jo20ftRndRt = null;
	/* Column Info */
	private String jo20ftTeuQty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String jo45ftTeuQty = null;
	/* Column Info */
	private String joTonTeuQty = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String jo45ftGnteQty = null;
	/* Column Info */
	private String joRefNo = null;
	/* Column Info */
	private String jo45ftRndRt = null;
	/* Column Info */
	private String jo40ftGnteQty = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String jo40ftTeuQty = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String joRefSeq = null;
	/* Column Info */
	private String bsaCapa = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String cgoTonWgt = null;
	/* Column Info */
	private String jo40ftRndRt = null;
	/* Column Info */
	private String joRfGnteOcnQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CusBzcAgmtVO() {}

	public CusBzcAgmtVO(String ibflag, String pagerows, String joRefNo, String joRefSeq, String ofcCd, String reDivrCd, String joCrrCd, String trdCd, String rlaneCd, String joSrcCd, String bsaCapa, String joTonTeuQty, String cgoTonWgt, String joTonWgtRndRt, String jo40ftGnteQty, String jo40ftTeuQty, String jo40ftRndRt, String jo20ftGnteQty, String jo20ftTeuQty, String jo20ftRndRt, String jo45ftGnteQty, String jo45ftTeuQty, String jo45ftRndRt, String joRfGnteOcnQty, String joRfGnteInterQty, String joBkgTpCd, String agmtEffDt, String agmtExpDt, String deltFlg, String creDt, String creUsrId, String updDt, String updUsrId, String creUsrNm) {
		this.agmtEffDt = agmtEffDt;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.joRfGnteInterQty = joRfGnteInterQty;
		this.jo20ftGnteQty = jo20ftGnteQty;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.joSrcCd = joSrcCd;
		this.joTonWgtRndRt = joTonWgtRndRt;
		this.agmtExpDt = agmtExpDt;
		this.joBkgTpCd = joBkgTpCd;
		this.jo20ftRndRt = jo20ftRndRt;
		this.jo20ftTeuQty = jo20ftTeuQty;
		this.updUsrId = updUsrId;
		this.jo45ftTeuQty = jo45ftTeuQty;
		this.joTonTeuQty = joTonTeuQty;
		this.updDt = updDt;
		this.jo45ftGnteQty = jo45ftGnteQty;
		this.joRefNo = joRefNo;
		this.jo45ftRndRt = jo45ftRndRt;
		this.jo40ftGnteQty = jo40ftGnteQty;
		this.joCrrCd = joCrrCd;
		this.jo40ftTeuQty = jo40ftTeuQty;
		this.creUsrNm = creUsrNm;
		this.joRefSeq = joRefSeq;
		this.bsaCapa = bsaCapa;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.reDivrCd = reDivrCd;
		this.cgoTonWgt = cgoTonWgt;
		this.jo40ftRndRt = jo40ftRndRt;
		this.joRfGnteOcnQty = joRfGnteOcnQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_eff_dt", getAgmtEffDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("jo_rf_gnte_inter_qty", getJoRfGnteInterQty());
		this.hashColumns.put("jo_20ft_gnte_qty", getJo20ftGnteQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("jo_src_cd", getJoSrcCd());
		this.hashColumns.put("jo_ton_wgt_rnd_rt", getJoTonWgtRndRt());
		this.hashColumns.put("agmt_exp_dt", getAgmtExpDt());
		this.hashColumns.put("jo_bkg_tp_cd", getJoBkgTpCd());
		this.hashColumns.put("jo_20ft_rnd_rt", getJo20ftRndRt());
		this.hashColumns.put("jo_20ft_teu_qty", getJo20ftTeuQty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("jo_45ft_teu_qty", getJo45ftTeuQty());
		this.hashColumns.put("jo_ton_teu_qty", getJoTonTeuQty());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("jo_45ft_gnte_qty", getJo45ftGnteQty());
		this.hashColumns.put("jo_ref_no", getJoRefNo());
		this.hashColumns.put("jo_45ft_rnd_rt", getJo45ftRndRt());
		this.hashColumns.put("jo_40ft_gnte_qty", getJo40ftGnteQty());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("jo_40ft_teu_qty", getJo40ftTeuQty());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("jo_ref_seq", getJoRefSeq());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("cgo_ton_wgt", getCgoTonWgt());
		this.hashColumns.put("jo_40ft_rnd_rt", getJo40ftRndRt());
		this.hashColumns.put("jo_rf_gnte_ocn_qty", getJoRfGnteOcnQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_eff_dt", "agmtEffDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("jo_rf_gnte_inter_qty", "joRfGnteInterQty");
		this.hashFields.put("jo_20ft_gnte_qty", "jo20ftGnteQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("jo_src_cd", "joSrcCd");
		this.hashFields.put("jo_ton_wgt_rnd_rt", "joTonWgtRndRt");
		this.hashFields.put("agmt_exp_dt", "agmtExpDt");
		this.hashFields.put("jo_bkg_tp_cd", "joBkgTpCd");
		this.hashFields.put("jo_20ft_rnd_rt", "jo20ftRndRt");
		this.hashFields.put("jo_20ft_teu_qty", "jo20ftTeuQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("jo_45ft_teu_qty", "jo45ftTeuQty");
		this.hashFields.put("jo_ton_teu_qty", "joTonTeuQty");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("jo_45ft_gnte_qty", "jo45ftGnteQty");
		this.hashFields.put("jo_ref_no", "joRefNo");
		this.hashFields.put("jo_45ft_rnd_rt", "jo45ftRndRt");
		this.hashFields.put("jo_40ft_gnte_qty", "jo40ftGnteQty");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("jo_40ft_teu_qty", "jo40ftTeuQty");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("jo_ref_seq", "joRefSeq");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("cgo_ton_wgt", "cgoTonWgt");
		this.hashFields.put("jo_40ft_rnd_rt", "jo40ftRndRt");
		this.hashFields.put("jo_rf_gnte_ocn_qty", "joRfGnteOcnQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return agmtEffDt
	 */
	public String getAgmtEffDt() {
		return this.agmtEffDt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return joRfGnteInterQty
	 */
	public String getJoRfGnteInterQty() {
		return this.joRfGnteInterQty;
	}
	
	/**
	 * Column Info
	 * @return jo20ftGnteQty
	 */
	public String getJo20ftGnteQty() {
		return this.jo20ftGnteQty;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return joSrcCd
	 */
	public String getJoSrcCd() {
		return this.joSrcCd;
	}
	
	/**
	 * Column Info
	 * @return joTonWgtRndRt
	 */
	public String getJoTonWgtRndRt() {
		return this.joTonWgtRndRt;
	}
	
	/**
	 * Column Info
	 * @return agmtExpDt
	 */
	public String getAgmtExpDt() {
		return this.agmtExpDt;
	}
	
	/**
	 * Column Info
	 * @return joBkgTpCd
	 */
	public String getJoBkgTpCd() {
		return this.joBkgTpCd;
	}
	
	/**
	 * Column Info
	 * @return jo20ftRndRt
	 */
	public String getJo20ftRndRt() {
		return this.jo20ftRndRt;
	}
	
	/**
	 * Column Info
	 * @return jo20ftTeuQty
	 */
	public String getJo20ftTeuQty() {
		return this.jo20ftTeuQty;
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
	 * @return jo45ftTeuQty
	 */
	public String getJo45ftTeuQty() {
		return this.jo45ftTeuQty;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return jo45ftGnteQty
	 */
	public String getJo45ftGnteQty() {
		return this.jo45ftGnteQty;
	}
	
	/**
	 * Column Info
	 * @return joRefNo
	 */
	public String getJoRefNo() {
		return this.joRefNo;
	}
	
	/**
	 * Column Info
	 * @return jo45ftRndRt
	 */
	public String getJo45ftRndRt() {
		return this.jo45ftRndRt;
	}
	
	/**
	 * Column Info
	 * @return jo40ftGnteQty
	 */
	public String getJo40ftGnteQty() {
		return this.jo40ftGnteQty;
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
	 * @return jo40ftTeuQty
	 */
	public String getJo40ftTeuQty() {
		return this.jo40ftTeuQty;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return joRefSeq
	 */
	public String getJoRefSeq() {
		return this.joRefSeq;
	}
	
	/**
	 * Column Info
	 * @return bsaCapa
	 */
	public String getBsaCapa() {
		return this.bsaCapa;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return cgoTonWgt
	 */
	public String getCgoTonWgt() {
		return this.cgoTonWgt;
	}
	
	/**
	 * Column Info
	 * @return jo40ftRndRt
	 */
	public String getJo40ftRndRt() {
		return this.jo40ftRndRt;
	}
	
	/**
	 * Column Info
	 * @return joRfGnteOcnQty
	 */
	public String getJoRfGnteOcnQty() {
		return this.joRfGnteOcnQty;
	}
	

	/**
	 * Column Info
	 * @param agmtEffDt
	 */
	public void setAgmtEffDt(String agmtEffDt) {
		this.agmtEffDt = agmtEffDt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param joRfGnteInterQty
	 */
	public void setJoRfGnteInterQty(String joRfGnteInterQty) {
		this.joRfGnteInterQty = joRfGnteInterQty;
	}
	
	/**
	 * Column Info
	 * @param jo20ftGnteQty
	 */
	public void setJo20ftGnteQty(String jo20ftGnteQty) {
		this.jo20ftGnteQty = jo20ftGnteQty;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param joSrcCd
	 */
	public void setJoSrcCd(String joSrcCd) {
		this.joSrcCd = joSrcCd;
	}
	
	/**
	 * Column Info
	 * @param joTonWgtRndRt
	 */
	public void setJoTonWgtRndRt(String joTonWgtRndRt) {
		this.joTonWgtRndRt = joTonWgtRndRt;
	}
	
	/**
	 * Column Info
	 * @param agmtExpDt
	 */
	public void setAgmtExpDt(String agmtExpDt) {
		this.agmtExpDt = agmtExpDt;
	}
	
	/**
	 * Column Info
	 * @param joBkgTpCd
	 */
	public void setJoBkgTpCd(String joBkgTpCd) {
		this.joBkgTpCd = joBkgTpCd;
	}
	
	/**
	 * Column Info
	 * @param jo20ftRndRt
	 */
	public void setJo20ftRndRt(String jo20ftRndRt) {
		this.jo20ftRndRt = jo20ftRndRt;
	}
	
	/**
	 * Column Info
	 * @param jo20ftTeuQty
	 */
	public void setJo20ftTeuQty(String jo20ftTeuQty) {
		this.jo20ftTeuQty = jo20ftTeuQty;
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
	 * @param jo45ftTeuQty
	 */
	public void setJo45ftTeuQty(String jo45ftTeuQty) {
		this.jo45ftTeuQty = jo45ftTeuQty;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param jo45ftGnteQty
	 */
	public void setJo45ftGnteQty(String jo45ftGnteQty) {
		this.jo45ftGnteQty = jo45ftGnteQty;
	}
	
	/**
	 * Column Info
	 * @param joRefNo
	 */
	public void setJoRefNo(String joRefNo) {
		this.joRefNo = joRefNo;
	}
	
	/**
	 * Column Info
	 * @param jo45ftRndRt
	 */
	public void setJo45ftRndRt(String jo45ftRndRt) {
		this.jo45ftRndRt = jo45ftRndRt;
	}
	
	/**
	 * Column Info
	 * @param jo40ftGnteQty
	 */
	public void setJo40ftGnteQty(String jo40ftGnteQty) {
		this.jo40ftGnteQty = jo40ftGnteQty;
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
	 * @param jo40ftTeuQty
	 */
	public void setJo40ftTeuQty(String jo40ftTeuQty) {
		this.jo40ftTeuQty = jo40ftTeuQty;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param joRefSeq
	 */
	public void setJoRefSeq(String joRefSeq) {
		this.joRefSeq = joRefSeq;
	}
	
	/**
	 * Column Info
	 * @param bsaCapa
	 */
	public void setBsaCapa(String bsaCapa) {
		this.bsaCapa = bsaCapa;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param cgoTonWgt
	 */
	public void setCgoTonWgt(String cgoTonWgt) {
		this.cgoTonWgt = cgoTonWgt;
	}
	
	/**
	 * Column Info
	 * @param jo40ftRndRt
	 */
	public void setJo40ftRndRt(String jo40ftRndRt) {
		this.jo40ftRndRt = jo40ftRndRt;
	}
	
	/**
	 * Column Info
	 * @param joRfGnteOcnQty
	 */
	public void setJoRfGnteOcnQty(String joRfGnteOcnQty) {
		this.joRfGnteOcnQty = joRfGnteOcnQty;
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
		setAgmtEffDt(JSPUtil.getParameter(request, prefix + "agmt_eff_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setJoRfGnteInterQty(JSPUtil.getParameter(request, prefix + "jo_rf_gnte_inter_qty", ""));
		setJo20ftGnteQty(JSPUtil.getParameter(request, prefix + "jo_20ft_gnte_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setJoSrcCd(JSPUtil.getParameter(request, prefix + "jo_src_cd", ""));
		setJoTonWgtRndRt(JSPUtil.getParameter(request, prefix + "jo_ton_wgt_rnd_rt", ""));
		setAgmtExpDt(JSPUtil.getParameter(request, prefix + "agmt_exp_dt", ""));
		setJoBkgTpCd(JSPUtil.getParameter(request, prefix + "jo_bkg_tp_cd", ""));
		setJo20ftRndRt(JSPUtil.getParameter(request, prefix + "jo_20ft_rnd_rt", ""));
		setJo20ftTeuQty(JSPUtil.getParameter(request, prefix + "jo_20ft_teu_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setJo45ftTeuQty(JSPUtil.getParameter(request, prefix + "jo_45ft_teu_qty", ""));
		setJoTonTeuQty(JSPUtil.getParameter(request, prefix + "jo_ton_teu_qty", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setJo45ftGnteQty(JSPUtil.getParameter(request, prefix + "jo_45ft_gnte_qty", ""));
		setJoRefNo(JSPUtil.getParameter(request, prefix + "jo_ref_no", ""));
		setJo45ftRndRt(JSPUtil.getParameter(request, prefix + "jo_45ft_rnd_rt", ""));
		setJo40ftGnteQty(JSPUtil.getParameter(request, prefix + "jo_40ft_gnte_qty", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setJo40ftTeuQty(JSPUtil.getParameter(request, prefix + "jo_40ft_teu_qty", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setJoRefSeq(JSPUtil.getParameter(request, prefix + "jo_ref_seq", ""));
		setBsaCapa(JSPUtil.getParameter(request, prefix + "bsa_capa", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
		setCgoTonWgt(JSPUtil.getParameter(request, prefix + "cgo_ton_wgt", ""));
		setJo40ftRndRt(JSPUtil.getParameter(request, prefix + "jo_40ft_rnd_rt", ""));
		setJoRfGnteOcnQty(JSPUtil.getParameter(request, prefix + "jo_rf_gnte_ocn_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CusBzcAgmtVO[]
	 */
	public CusBzcAgmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CusBzcAgmtVO[]
	 */
	public CusBzcAgmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CusBzcAgmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agmtEffDt = (JSPUtil.getParameter(request, prefix	+ "agmt_eff_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] joRfGnteInterQty = (JSPUtil.getParameter(request, prefix	+ "jo_rf_gnte_inter_qty", length));
			String[] jo20ftGnteQty = (JSPUtil.getParameter(request, prefix	+ "jo_20ft_gnte_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] joSrcCd = (JSPUtil.getParameter(request, prefix	+ "jo_src_cd", length));
			String[] joTonWgtRndRt = (JSPUtil.getParameter(request, prefix	+ "jo_ton_wgt_rnd_rt", length));
			String[] agmtExpDt = (JSPUtil.getParameter(request, prefix	+ "agmt_exp_dt", length));
			String[] joBkgTpCd = (JSPUtil.getParameter(request, prefix	+ "jo_bkg_tp_cd", length));
			String[] jo20ftRndRt = (JSPUtil.getParameter(request, prefix	+ "jo_20ft_rnd_rt", length));
			String[] jo20ftTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_20ft_teu_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] jo45ftTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_teu_qty", length));
			String[] joTonTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_ton_teu_qty", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] jo45ftGnteQty = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_gnte_qty", length));
			String[] joRefNo = (JSPUtil.getParameter(request, prefix	+ "jo_ref_no", length));
			String[] jo45ftRndRt = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_rnd_rt", length));
			String[] jo40ftGnteQty = (JSPUtil.getParameter(request, prefix	+ "jo_40ft_gnte_qty", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] jo40ftTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_40ft_teu_qty", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] joRefSeq = (JSPUtil.getParameter(request, prefix	+ "jo_ref_seq", length));
			String[] bsaCapa = (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] cgoTonWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_ton_wgt", length));
			String[] jo40ftRndRt = (JSPUtil.getParameter(request, prefix	+ "jo_40ft_rnd_rt", length));
			String[] joRfGnteOcnQty = (JSPUtil.getParameter(request, prefix	+ "jo_rf_gnte_ocn_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new CusBzcAgmtVO();
				if (agmtEffDt[i] != null)
					model.setAgmtEffDt(agmtEffDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (joRfGnteInterQty[i] != null)
					model.setJoRfGnteInterQty(joRfGnteInterQty[i]);
				if (jo20ftGnteQty[i] != null)
					model.setJo20ftGnteQty(jo20ftGnteQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (joSrcCd[i] != null)
					model.setJoSrcCd(joSrcCd[i]);
				if (joTonWgtRndRt[i] != null)
					model.setJoTonWgtRndRt(joTonWgtRndRt[i]);
				if (agmtExpDt[i] != null)
					model.setAgmtExpDt(agmtExpDt[i]);
				if (joBkgTpCd[i] != null)
					model.setJoBkgTpCd(joBkgTpCd[i]);
				if (jo20ftRndRt[i] != null)
					model.setJo20ftRndRt(jo20ftRndRt[i]);
				if (jo20ftTeuQty[i] != null)
					model.setJo20ftTeuQty(jo20ftTeuQty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (jo45ftTeuQty[i] != null)
					model.setJo45ftTeuQty(jo45ftTeuQty[i]);
				if (joTonTeuQty[i] != null)
					model.setJoTonTeuQty(joTonTeuQty[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (jo45ftGnteQty[i] != null)
					model.setJo45ftGnteQty(jo45ftGnteQty[i]);
				if (joRefNo[i] != null)
					model.setJoRefNo(joRefNo[i]);
				if (jo45ftRndRt[i] != null)
					model.setJo45ftRndRt(jo45ftRndRt[i]);
				if (jo40ftGnteQty[i] != null)
					model.setJo40ftGnteQty(jo40ftGnteQty[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (jo40ftTeuQty[i] != null)
					model.setJo40ftTeuQty(jo40ftTeuQty[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (joRefSeq[i] != null)
					model.setJoRefSeq(joRefSeq[i]);
				if (bsaCapa[i] != null)
					model.setBsaCapa(bsaCapa[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (cgoTonWgt[i] != null)
					model.setCgoTonWgt(cgoTonWgt[i]);
				if (jo40ftRndRt[i] != null)
					model.setJo40ftRndRt(jo40ftRndRt[i]);
				if (joRfGnteOcnQty[i] != null)
					model.setJoRfGnteOcnQty(joRfGnteOcnQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCusBzcAgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CusBzcAgmtVO[]
	 */
	public CusBzcAgmtVO[] getCusBzcAgmtVOs(){
		CusBzcAgmtVO[] vos = (CusBzcAgmtVO[])models.toArray(new CusBzcAgmtVO[models.size()]);
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
		this.agmtEffDt = this.agmtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRfGnteInterQty = this.joRfGnteInterQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo20ftGnteQty = this.jo20ftGnteQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joSrcCd = this.joSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joTonWgtRndRt = this.joTonWgtRndRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtExpDt = this.agmtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBkgTpCd = this.joBkgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo20ftRndRt = this.jo20ftRndRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo20ftTeuQty = this.jo20ftTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftTeuQty = this.jo45ftTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joTonTeuQty = this.joTonTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftGnteQty = this.jo45ftGnteQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRefNo = this.joRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftRndRt = this.jo45ftRndRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo40ftGnteQty = this.jo40ftGnteQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo40ftTeuQty = this.jo40ftTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRefSeq = this.joRefSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTonWgt = this.cgoTonWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo40ftRndRt = this.jo40ftRndRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRfGnteOcnQty = this.joRfGnteOcnQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
