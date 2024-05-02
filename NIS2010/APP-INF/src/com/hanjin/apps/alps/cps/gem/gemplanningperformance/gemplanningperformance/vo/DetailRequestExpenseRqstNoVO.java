/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DetailRequestExpenseRqstNoVO.java
*@FileTitle : DetailRequestExpenseRqstNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.07.17 최정미 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최정미
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DetailRequestExpenseRqstNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DetailRequestExpenseRqstNoVO> models = new ArrayList<DetailRequestExpenseRqstNoVO>();
	
	/* Column Info */
	private String comTotal = null;
	/* Column Info */
	private String genExpnItmDesc = null;
	/* Column Info */
	private String ticTotal = null;
	/* Column Info */
	private String aprAmt = null;
	/* Column Info */
	private String rhqlbuSts = null;
	/* Column Info */
	private String ofcTotal = null;
	/* Column Info */
	private String marAmt = null;
	/* Column Info */
	private String augAmt = null;
	/* Column Info */
	private String novAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String genExpnAproStepCd = null;
	/* Column Info */
	private String mayAmt = null;
	/* Column Info */
	private String genExpnTrnsDivCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String comSts = null;
	/* Column Info */
	private String genExpnRqstNo = null;
	/* Column Info */
	private String expnAbbrNm = null;
	/* Column Info */
	private String rqstUtVal = null;
	/* Column Info */
	private String janAmt = null;
	/* Column Info */
	private String decAmt = null;
	/* Column Info */
	private String genExpnItmNo = null;
	/* Column Info */
	private String genExpnCalcBssDesc = null;
	/* Column Info */
	private String rqstOpinRmk = null;
	/* Column Info */
	private String julAmt = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String febAmt = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String rhqlbuTotal = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String junAmt = null;
	/* Column Info */
	private String ofcSts = null;
	/* Column Info */
	private String ticSts = null;
	/* Column Info */
	private String octAmt = null;
	/* Column Info */
	private String sepAmt = null;
	/* Column Info */
	private String genExpnRqstSeq = null;
	/* Column Info */
	private String ticCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DetailRequestExpenseRqstNoVO() {}

	public DetailRequestExpenseRqstNoVO(String ibflag, String pagerows, String genExpnRqstNo, String ofcCd, String genExpnCd, String genExpnItmNo, String genExpnTrnsDivCd, String genExpnRqstSeq, String genExpnAproStepCd, String ofcSts, String rhqlbuSts, String ticSts, String comSts, String rhqOfcCd, String loclCurrCd, String rqstUtVal, String expnAbbrNm, String ticCd, String janAmt, String febAmt, String marAmt, String aprAmt, String mayAmt, String junAmt, String julAmt, String augAmt, String sepAmt, String octAmt, String novAmt, String decAmt, String ofcTotal, String rhqlbuTotal, String ticTotal, String comTotal, String genExpnItmDesc, String genExpnCalcBssDesc, String rqstOpinRmk, String creUsrId) {
		this.comTotal = comTotal;
		this.genExpnItmDesc = genExpnItmDesc;
		this.ticTotal = ticTotal;
		this.aprAmt = aprAmt;
		this.rhqlbuSts = rhqlbuSts;
		this.ofcTotal = ofcTotal;
		this.marAmt = marAmt;
		this.augAmt = augAmt;
		this.novAmt = novAmt;
		this.pagerows = pagerows;
		this.genExpnAproStepCd = genExpnAproStepCd;
		this.mayAmt = mayAmt;
		this.genExpnTrnsDivCd = genExpnTrnsDivCd;
		this.ibflag = ibflag;
		this.comSts = comSts;
		this.genExpnRqstNo = genExpnRqstNo;
		this.expnAbbrNm = expnAbbrNm;
		this.rqstUtVal = rqstUtVal;
		this.janAmt = janAmt;
		this.decAmt = decAmt;
		this.genExpnItmNo = genExpnItmNo;
		this.genExpnCalcBssDesc = genExpnCalcBssDesc;
		this.rqstOpinRmk = rqstOpinRmk;
		this.julAmt = julAmt;
		this.loclCurrCd = loclCurrCd;
		this.genExpnCd = genExpnCd;
		this.febAmt = febAmt;
		this.rhqOfcCd = rhqOfcCd;
		this.rhqlbuTotal = rhqlbuTotal;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.junAmt = junAmt;
		this.ofcSts = ofcSts;
		this.ticSts = ticSts;
		this.octAmt = octAmt;
		this.sepAmt = sepAmt;
		this.genExpnRqstSeq = genExpnRqstSeq;
		this.ticCd = ticCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("com_total", getComTotal());
		this.hashColumns.put("gen_expn_itm_desc", getGenExpnItmDesc());
		this.hashColumns.put("tic_total", getTicTotal());
		this.hashColumns.put("apr_amt", getAprAmt());
		this.hashColumns.put("rhqlbu_sts", getRhqlbuSts());
		this.hashColumns.put("ofc_total", getOfcTotal());
		this.hashColumns.put("mar_amt", getMarAmt());
		this.hashColumns.put("aug_amt", getAugAmt());
		this.hashColumns.put("nov_amt", getNovAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gen_expn_apro_step_cd", getGenExpnAproStepCd());
		this.hashColumns.put("may_amt", getMayAmt());
		this.hashColumns.put("gen_expn_trns_div_cd", getGenExpnTrnsDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("com_sts", getComSts());
		this.hashColumns.put("gen_expn_rqst_no", getGenExpnRqstNo());
		this.hashColumns.put("expn_abbr_nm", getExpnAbbrNm());
		this.hashColumns.put("rqst_ut_val", getRqstUtVal());
		this.hashColumns.put("jan_amt", getJanAmt());
		this.hashColumns.put("dec_amt", getDecAmt());
		this.hashColumns.put("gen_expn_itm_no", getGenExpnItmNo());
		this.hashColumns.put("gen_expn_calc_bss_desc", getGenExpnCalcBssDesc());
		this.hashColumns.put("rqst_opin_rmk", getRqstOpinRmk());
		this.hashColumns.put("jul_amt", getJulAmt());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("feb_amt", getFebAmt());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("rhqlbu_total", getRhqlbuTotal());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("jun_amt", getJunAmt());
		this.hashColumns.put("ofc_sts", getOfcSts());
		this.hashColumns.put("tic_sts", getTicSts());
		this.hashColumns.put("oct_amt", getOctAmt());
		this.hashColumns.put("sep_amt", getSepAmt());
		this.hashColumns.put("gen_expn_rqst_seq", getGenExpnRqstSeq());
		this.hashColumns.put("tic_cd", getTicCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("com_total", "comTotal");
		this.hashFields.put("gen_expn_itm_desc", "genExpnItmDesc");
		this.hashFields.put("tic_total", "ticTotal");
		this.hashFields.put("apr_amt", "aprAmt");
		this.hashFields.put("rhqlbu_sts", "rhqlbuSts");
		this.hashFields.put("ofc_total", "ofcTotal");
		this.hashFields.put("mar_amt", "marAmt");
		this.hashFields.put("aug_amt", "augAmt");
		this.hashFields.put("nov_amt", "novAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gen_expn_apro_step_cd", "genExpnAproStepCd");
		this.hashFields.put("may_amt", "mayAmt");
		this.hashFields.put("gen_expn_trns_div_cd", "genExpnTrnsDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("com_sts", "comSts");
		this.hashFields.put("gen_expn_rqst_no", "genExpnRqstNo");
		this.hashFields.put("expn_abbr_nm", "expnAbbrNm");
		this.hashFields.put("rqst_ut_val", "rqstUtVal");
		this.hashFields.put("jan_amt", "janAmt");
		this.hashFields.put("dec_amt", "decAmt");
		this.hashFields.put("gen_expn_itm_no", "genExpnItmNo");
		this.hashFields.put("gen_expn_calc_bss_desc", "genExpnCalcBssDesc");
		this.hashFields.put("rqst_opin_rmk", "rqstOpinRmk");
		this.hashFields.put("jul_amt", "julAmt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("feb_amt", "febAmt");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("rhqlbu_total", "rhqlbuTotal");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("jun_amt", "junAmt");
		this.hashFields.put("ofc_sts", "ofcSts");
		this.hashFields.put("tic_sts", "ticSts");
		this.hashFields.put("oct_amt", "octAmt");
		this.hashFields.put("sep_amt", "sepAmt");
		this.hashFields.put("gen_expn_rqst_seq", "genExpnRqstSeq");
		this.hashFields.put("tic_cd", "ticCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return comTotal
	 */
	public String getComTotal() {
		return this.comTotal;
	}
	
	/**
	 * Column Info
	 * @return genExpnItmDesc
	 */
	public String getGenExpnItmDesc() {
		return this.genExpnItmDesc;
	}
	
	/**
	 * Column Info
	 * @return ticTotal
	 */
	public String getTicTotal() {
		return this.ticTotal;
	}
	
	/**
	 * Column Info
	 * @return aprAmt
	 */
	public String getAprAmt() {
		return this.aprAmt;
	}
	
	/**
	 * Column Info
	 * @return rhqlbuSts
	 */
	public String getRhqlbuSts() {
		return this.rhqlbuSts;
	}
	
	/**
	 * Column Info
	 * @return ofcTotal
	 */
	public String getOfcTotal() {
		return this.ofcTotal;
	}
	
	/**
	 * Column Info
	 * @return marAmt
	 */
	public String getMarAmt() {
		return this.marAmt;
	}
	
	/**
	 * Column Info
	 * @return augAmt
	 */
	public String getAugAmt() {
		return this.augAmt;
	}
	
	/**
	 * Column Info
	 * @return novAmt
	 */
	public String getNovAmt() {
		return this.novAmt;
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
	 * @return genExpnAproStepCd
	 */
	public String getGenExpnAproStepCd() {
		return this.genExpnAproStepCd;
	}
	
	/**
	 * Column Info
	 * @return mayAmt
	 */
	public String getMayAmt() {
		return this.mayAmt;
	}
	
	/**
	 * Column Info
	 * @return genExpnTrnsDivCd
	 */
	public String getGenExpnTrnsDivCd() {
		return this.genExpnTrnsDivCd;
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
	 * @return comSts
	 */
	public String getComSts() {
		return this.comSts;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstNo
	 */
	public String getGenExpnRqstNo() {
		return this.genExpnRqstNo;
	}
	
	/**
	 * Column Info
	 * @return expnAbbrNm
	 */
	public String getExpnAbbrNm() {
		return this.expnAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return rqstUtVal
	 */
	public String getRqstUtVal() {
		return this.rqstUtVal;
	}
	
	/**
	 * Column Info
	 * @return janAmt
	 */
	public String getJanAmt() {
		return this.janAmt;
	}
	
	/**
	 * Column Info
	 * @return decAmt
	 */
	public String getDecAmt() {
		return this.decAmt;
	}
	
	/**
	 * Column Info
	 * @return genExpnItmNo
	 */
	public String getGenExpnItmNo() {
		return this.genExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @return genExpnCalcBssDesc
	 */
	public String getGenExpnCalcBssDesc() {
		return this.genExpnCalcBssDesc;
	}
	
	/**
	 * Column Info
	 * @return rqstOpinRmk
	 */
	public String getRqstOpinRmk() {
		return this.rqstOpinRmk;
	}
	
	/**
	 * Column Info
	 * @return julAmt
	 */
	public String getJulAmt() {
		return this.julAmt;
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
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
	}
	
	/**
	 * Column Info
	 * @return febAmt
	 */
	public String getFebAmt() {
		return this.febAmt;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rhqlbuTotal
	 */
	public String getRhqlbuTotal() {
		return this.rhqlbuTotal;
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
	 * @return junAmt
	 */
	public String getJunAmt() {
		return this.junAmt;
	}
	
	/**
	 * Column Info
	 * @return ofcSts
	 */
	public String getOfcSts() {
		return this.ofcSts;
	}
	
	/**
	 * Column Info
	 * @return ticSts
	 */
	public String getTicSts() {
		return this.ticSts;
	}
	
	/**
	 * Column Info
	 * @return octAmt
	 */
	public String getOctAmt() {
		return this.octAmt;
	}
	
	/**
	 * Column Info
	 * @return sepAmt
	 */
	public String getSepAmt() {
		return this.sepAmt;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstSeq
	 */
	public String getGenExpnRqstSeq() {
		return this.genExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return ticCd
	 */
	public String getTicCd() {
		return this.ticCd;
	}
	

	/**
	 * Column Info
	 * @param comTotal
	 */
	public void setComTotal(String comTotal) {
		this.comTotal = comTotal;
	}
	
	/**
	 * Column Info
	 * @param genExpnItmDesc
	 */
	public void setGenExpnItmDesc(String genExpnItmDesc) {
		this.genExpnItmDesc = genExpnItmDesc;
	}
	
	/**
	 * Column Info
	 * @param ticTotal
	 */
	public void setTicTotal(String ticTotal) {
		this.ticTotal = ticTotal;
	}
	
	/**
	 * Column Info
	 * @param aprAmt
	 */
	public void setAprAmt(String aprAmt) {
		this.aprAmt = aprAmt;
	}
	
	/**
	 * Column Info
	 * @param rhqlbuSts
	 */
	public void setRhqlbuSts(String rhqlbuSts) {
		this.rhqlbuSts = rhqlbuSts;
	}
	
	/**
	 * Column Info
	 * @param ofcTotal
	 */
	public void setOfcTotal(String ofcTotal) {
		this.ofcTotal = ofcTotal;
	}
	
	/**
	 * Column Info
	 * @param marAmt
	 */
	public void setMarAmt(String marAmt) {
		this.marAmt = marAmt;
	}
	
	/**
	 * Column Info
	 * @param augAmt
	 */
	public void setAugAmt(String augAmt) {
		this.augAmt = augAmt;
	}
	
	/**
	 * Column Info
	 * @param novAmt
	 */
	public void setNovAmt(String novAmt) {
		this.novAmt = novAmt;
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
	 * @param genExpnAproStepCd
	 */
	public void setGenExpnAproStepCd(String genExpnAproStepCd) {
		this.genExpnAproStepCd = genExpnAproStepCd;
	}
	
	/**
	 * Column Info
	 * @param mayAmt
	 */
	public void setMayAmt(String mayAmt) {
		this.mayAmt = mayAmt;
	}
	
	/**
	 * Column Info
	 * @param genExpnTrnsDivCd
	 */
	public void setGenExpnTrnsDivCd(String genExpnTrnsDivCd) {
		this.genExpnTrnsDivCd = genExpnTrnsDivCd;
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
	 * @param comSts
	 */
	public void setComSts(String comSts) {
		this.comSts = comSts;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstNo
	 */
	public void setGenExpnRqstNo(String genExpnRqstNo) {
		this.genExpnRqstNo = genExpnRqstNo;
	}
	
	/**
	 * Column Info
	 * @param expnAbbrNm
	 */
	public void setExpnAbbrNm(String expnAbbrNm) {
		this.expnAbbrNm = expnAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param rqstUtVal
	 */
	public void setRqstUtVal(String rqstUtVal) {
		this.rqstUtVal = rqstUtVal;
	}
	
	/**
	 * Column Info
	 * @param janAmt
	 */
	public void setJanAmt(String janAmt) {
		this.janAmt = janAmt;
	}
	
	/**
	 * Column Info
	 * @param decAmt
	 */
	public void setDecAmt(String decAmt) {
		this.decAmt = decAmt;
	}
	
	/**
	 * Column Info
	 * @param genExpnItmNo
	 */
	public void setGenExpnItmNo(String genExpnItmNo) {
		this.genExpnItmNo = genExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @param genExpnCalcBssDesc
	 */
	public void setGenExpnCalcBssDesc(String genExpnCalcBssDesc) {
		this.genExpnCalcBssDesc = genExpnCalcBssDesc;
	}
	
	/**
	 * Column Info
	 * @param rqstOpinRmk
	 */
	public void setRqstOpinRmk(String rqstOpinRmk) {
		this.rqstOpinRmk = rqstOpinRmk;
	}
	
	/**
	 * Column Info
	 * @param julAmt
	 */
	public void setJulAmt(String julAmt) {
		this.julAmt = julAmt;
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
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}
	
	/**
	 * Column Info
	 * @param febAmt
	 */
	public void setFebAmt(String febAmt) {
		this.febAmt = febAmt;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rhqlbuTotal
	 */
	public void setRhqlbuTotal(String rhqlbuTotal) {
		this.rhqlbuTotal = rhqlbuTotal;
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
	 * @param junAmt
	 */
	public void setJunAmt(String junAmt) {
		this.junAmt = junAmt;
	}
	
	/**
	 * Column Info
	 * @param ofcSts
	 */
	public void setOfcSts(String ofcSts) {
		this.ofcSts = ofcSts;
	}
	
	/**
	 * Column Info
	 * @param ticSts
	 */
	public void setTicSts(String ticSts) {
		this.ticSts = ticSts;
	}
	
	/**
	 * Column Info
	 * @param octAmt
	 */
	public void setOctAmt(String octAmt) {
		this.octAmt = octAmt;
	}
	
	/**
	 * Column Info
	 * @param sepAmt
	 */
	public void setSepAmt(String sepAmt) {
		this.sepAmt = sepAmt;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstSeq
	 */
	public void setGenExpnRqstSeq(String genExpnRqstSeq) {
		this.genExpnRqstSeq = genExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param ticCd
	 */
	public void setTicCd(String ticCd) {
		this.ticCd = ticCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setComTotal(JSPUtil.getParameter(request, "com_total", ""));
		setGenExpnItmDesc(JSPUtil.getParameter(request, "gen_expn_itm_desc", ""));
		setTicTotal(JSPUtil.getParameter(request, "tic_total", ""));
		setAprAmt(JSPUtil.getParameter(request, "apr_amt", ""));
		setRhqlbuSts(JSPUtil.getParameter(request, "rhqlbu_sts", ""));
		setOfcTotal(JSPUtil.getParameter(request, "ofc_total", ""));
		setMarAmt(JSPUtil.getParameter(request, "mar_amt", ""));
		setAugAmt(JSPUtil.getParameter(request, "aug_amt", ""));
		setNovAmt(JSPUtil.getParameter(request, "nov_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setGenExpnAproStepCd(JSPUtil.getParameter(request, "gen_expn_apro_step_cd", ""));
		setMayAmt(JSPUtil.getParameter(request, "may_amt", ""));
		setGenExpnTrnsDivCd(JSPUtil.getParameter(request, "gen_expn_trns_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setComSts(JSPUtil.getParameter(request, "com_sts", ""));
		setGenExpnRqstNo(JSPUtil.getParameter(request, "gen_expn_rqst_no", ""));
		setExpnAbbrNm(JSPUtil.getParameter(request, "expn_abbr_nm", ""));
		setRqstUtVal(JSPUtil.getParameter(request, "rqst_ut_val", ""));
		setJanAmt(JSPUtil.getParameter(request, "jan_amt", ""));
		setDecAmt(JSPUtil.getParameter(request, "dec_amt", ""));
		setGenExpnItmNo(JSPUtil.getParameter(request, "gen_expn_itm_no", ""));
		setGenExpnCalcBssDesc(JSPUtil.getParameter(request, "gen_expn_calc_bss_desc", ""));
		setRqstOpinRmk(JSPUtil.getParameter(request, "rqst_opin_rmk", ""));
		setJulAmt(JSPUtil.getParameter(request, "jul_amt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setFebAmt(JSPUtil.getParameter(request, "feb_amt", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, "rhq_ofc_cd", ""));
		setRhqlbuTotal(JSPUtil.getParameter(request, "rhqlbu_total", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setJunAmt(JSPUtil.getParameter(request, "jun_amt", ""));
		setOfcSts(JSPUtil.getParameter(request, "ofc_sts", ""));
		setTicSts(JSPUtil.getParameter(request, "tic_sts", ""));
		setOctAmt(JSPUtil.getParameter(request, "oct_amt", ""));
		setSepAmt(JSPUtil.getParameter(request, "sep_amt", ""));
		setGenExpnRqstSeq(JSPUtil.getParameter(request, "gen_expn_rqst_seq", ""));
		setTicCd(JSPUtil.getParameter(request, "tic_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DetailRequestExpenseRqstNoVO[]
	 */
	public DetailRequestExpenseRqstNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DetailRequestExpenseRqstNoVO[]
	 */
	public DetailRequestExpenseRqstNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DetailRequestExpenseRqstNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] comTotal = (JSPUtil.getParameter(request, prefix	+ "com_total", length));
			String[] genExpnItmDesc = (JSPUtil.getParameter(request, prefix	+ "gen_expn_itm_desc", length));
			String[] ticTotal = (JSPUtil.getParameter(request, prefix	+ "tic_total", length));
			String[] aprAmt = (JSPUtil.getParameter(request, prefix	+ "apr_amt", length));
			String[] rhqlbuSts = (JSPUtil.getParameter(request, prefix	+ "rhqlbu_sts", length));
			String[] ofcTotal = (JSPUtil.getParameter(request, prefix	+ "ofc_total", length));
			String[] marAmt = (JSPUtil.getParameter(request, prefix	+ "mar_amt", length));
			String[] augAmt = (JSPUtil.getParameter(request, prefix	+ "aug_amt", length));
			String[] novAmt = (JSPUtil.getParameter(request, prefix	+ "nov_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] genExpnAproStepCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_apro_step_cd", length));
			String[] mayAmt = (JSPUtil.getParameter(request, prefix	+ "may_amt", length));
			String[] genExpnTrnsDivCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_trns_div_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] comSts = (JSPUtil.getParameter(request, prefix	+ "com_sts", length));
			String[] genExpnRqstNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no", length));
			String[] expnAbbrNm = (JSPUtil.getParameter(request, prefix	+ "expn_abbr_nm", length));
			String[] rqstUtVal = (JSPUtil.getParameter(request, prefix	+ "rqst_ut_val", length));
			String[] janAmt = (JSPUtil.getParameter(request, prefix	+ "jan_amt", length));
			String[] decAmt = (JSPUtil.getParameter(request, prefix	+ "dec_amt", length));
			String[] genExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_itm_no", length));
			String[] genExpnCalcBssDesc = (JSPUtil.getParameter(request, prefix	+ "gen_expn_calc_bss_desc", length));
			String[] rqstOpinRmk = (JSPUtil.getParameter(request, prefix	+ "rqst_opin_rmk", length));
			String[] julAmt = (JSPUtil.getParameter(request, prefix	+ "jul_amt", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] febAmt = (JSPUtil.getParameter(request, prefix	+ "feb_amt", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] rhqlbuTotal = (JSPUtil.getParameter(request, prefix	+ "rhqlbu_total", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] junAmt = (JSPUtil.getParameter(request, prefix	+ "jun_amt", length));
			String[] ofcSts = (JSPUtil.getParameter(request, prefix	+ "ofc_sts", length));
			String[] ticSts = (JSPUtil.getParameter(request, prefix	+ "tic_sts", length));
			String[] octAmt = (JSPUtil.getParameter(request, prefix	+ "oct_amt", length));
			String[] sepAmt = (JSPUtil.getParameter(request, prefix	+ "sep_amt", length));
			String[] genExpnRqstSeq = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_seq", length));
			String[] ticCd = (JSPUtil.getParameter(request, prefix	+ "tic_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DetailRequestExpenseRqstNoVO();
				if (comTotal[i] != null)
					model.setComTotal(comTotal[i]);
				if (genExpnItmDesc[i] != null)
					model.setGenExpnItmDesc(genExpnItmDesc[i]);
				if (ticTotal[i] != null)
					model.setTicTotal(ticTotal[i]);
				if (aprAmt[i] != null)
					model.setAprAmt(aprAmt[i]);
				if (rhqlbuSts[i] != null)
					model.setRhqlbuSts(rhqlbuSts[i]);
				if (ofcTotal[i] != null)
					model.setOfcTotal(ofcTotal[i]);
				if (marAmt[i] != null)
					model.setMarAmt(marAmt[i]);
				if (augAmt[i] != null)
					model.setAugAmt(augAmt[i]);
				if (novAmt[i] != null)
					model.setNovAmt(novAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (genExpnAproStepCd[i] != null)
					model.setGenExpnAproStepCd(genExpnAproStepCd[i]);
				if (mayAmt[i] != null)
					model.setMayAmt(mayAmt[i]);
				if (genExpnTrnsDivCd[i] != null)
					model.setGenExpnTrnsDivCd(genExpnTrnsDivCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (comSts[i] != null)
					model.setComSts(comSts[i]);
				if (genExpnRqstNo[i] != null)
					model.setGenExpnRqstNo(genExpnRqstNo[i]);
				if (expnAbbrNm[i] != null)
					model.setExpnAbbrNm(expnAbbrNm[i]);
				if (rqstUtVal[i] != null)
					model.setRqstUtVal(rqstUtVal[i]);
				if (janAmt[i] != null)
					model.setJanAmt(janAmt[i]);
				if (decAmt[i] != null)
					model.setDecAmt(decAmt[i]);
				if (genExpnItmNo[i] != null)
					model.setGenExpnItmNo(genExpnItmNo[i]);
				if (genExpnCalcBssDesc[i] != null)
					model.setGenExpnCalcBssDesc(genExpnCalcBssDesc[i]);
				if (rqstOpinRmk[i] != null)
					model.setRqstOpinRmk(rqstOpinRmk[i]);
				if (julAmt[i] != null)
					model.setJulAmt(julAmt[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (febAmt[i] != null)
					model.setFebAmt(febAmt[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (rhqlbuTotal[i] != null)
					model.setRhqlbuTotal(rhqlbuTotal[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (junAmt[i] != null)
					model.setJunAmt(junAmt[i]);
				if (ofcSts[i] != null)
					model.setOfcSts(ofcSts[i]);
				if (ticSts[i] != null)
					model.setTicSts(ticSts[i]);
				if (octAmt[i] != null)
					model.setOctAmt(octAmt[i]);
				if (sepAmt[i] != null)
					model.setSepAmt(sepAmt[i]);
				if (genExpnRqstSeq[i] != null)
					model.setGenExpnRqstSeq(genExpnRqstSeq[i]);
				if (ticCd[i] != null)
					model.setTicCd(ticCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDetailRequestExpenseRqstNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DetailRequestExpenseRqstNoVO[]
	 */
	public DetailRequestExpenseRqstNoVO[] getDetailRequestExpenseRqstNoVOs(){
		DetailRequestExpenseRqstNoVO[] vos = (DetailRequestExpenseRqstNoVO[])models.toArray(new DetailRequestExpenseRqstNoVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.comTotal = this.comTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnItmDesc = this.genExpnItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticTotal = this.ticTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aprAmt = this.aprAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqlbuSts = this.rhqlbuSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTotal = this.ofcTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.marAmt = this.marAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.augAmt = this.augAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.novAmt = this.novAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnAproStepCd = this.genExpnAproStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mayAmt = this.mayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnTrnsDivCd = this.genExpnTrnsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comSts = this.comSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo = this.genExpnRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnAbbrNm = this.expnAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUtVal = this.rqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.janAmt = this.janAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.decAmt = this.decAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnItmNo = this.genExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCalcBssDesc = this.genExpnCalcBssDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOpinRmk = this.rqstOpinRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.julAmt = this.julAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.febAmt = this.febAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqlbuTotal = this.rhqlbuTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.junAmt = this.junAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcSts = this.ofcSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticSts = this.ticSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.octAmt = this.octAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sepAmt = this.sepAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstSeq = this.genExpnRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticCd = this.ticCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
