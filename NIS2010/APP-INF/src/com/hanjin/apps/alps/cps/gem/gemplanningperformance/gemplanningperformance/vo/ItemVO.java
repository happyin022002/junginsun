/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ItemVO.java
*@FileTitle : ItemVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.12 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ItemVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ItemVO> models = new ArrayList<ItemVO>();
	
	/* Column Info */
	private String aprAmt = null;
	/* Column Info */
	private String itmUpdDt = null;
	/* Column Info */
	private String rqstNovAmt = null;
	/* Column Info */
	private String marAmt = null;
	/* Column Info */
	private String augAmt = null;
	/* Column Info */
	private String novAmt = null;
	/* Column Info */
	private String rqstUsdAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String genExpnTrnsDivCd = null;
	/* Column Info */
	private String rqstMayAmt = null;
	/* Column Info */
	private String genExpnRqstNo = null;
	/* Column Info */
	private String rqstMarAmt = null;
	/* Column Info */
	private String decAmt = null;
	/* Column Info */
	private String genExpnItmNo = null;
	/* Column Info */
	private String crntGenExpnApstsCd = null;
	/* Column Info */
	private String julAmt = null;
	/* Column Info */
	private String rqstJanAmt = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String krnAbbrNm = null;
	/* Column Info */
	private String febAmt = null;
	/* Column Info */
	private String rqstFebAmt = null;
	/* Column Info */
	private String ofcLvl1 = null;
	/* Column Info */
	private String junAmt = null;
	/* Column Info */
	private String ofcLvl2 = null;
	/* Column Info */
	private String octAmt = null;
	/* Column Info */
	private String sepAmt = null;
	/* Column Info */
	private String rqstJulAmt = null;
	/* Column Info */
	private String genExpnItmDesc = null;
	/* Column Info */
	private String crntGenExpnAproStepCd = null;
	/* Column Info */
	private String mayAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String engAbbrNm = null;
	/* Column Info */
	private String rqstAprAmt = null;
	/* Column Info */
	private String rqstJunAmt = null;
	/* Column Info */
	private String usdLoclXchRt = null;
	/* Column Info */
	private String rqstLoclAmt = null;
	/* Column Info */
	private String rqstUtVal = null;
	/* Column Info */
	private String janAmt = null;
	/* Column Info */
	private String genExpnCalcBssDesc = null;
	/* Column Info */
	private String rqstOctAmt = null;
	/* Column Info */
	private String rqstOpinRmk = null;
	/* Column Info */
	private String chkAssigned = null;
	/* Column Info */
	private String rqstSepAmt = null;
	/* Column Info */
	private String rqstAugAmt = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String ttl = null;
	/* Column Info */
	private String reqUpdDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String rqstDecAmt = null;
	/* Column Info */
	private String genExpnRqstSeq = null;
	/* Column Info */
	private String ticCd = null;
	/* Column Info */
	private String slsOfcDivCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ItemVO() {}

	public ItemVO(String ibflag, String pagerows, String genExpnRqstNo, String ofcCd, String genExpnCd, String genExpnItmNo, String genExpnTrnsDivCd, String genExpnRqstSeq, String crntGenExpnAproStepCd, String crntGenExpnApstsCd, String genExpnItmDesc, String genExpnCalcBssDesc, String rqstOpinRmk, String janAmt, String febAmt, String marAmt, String aprAmt, String mayAmt, String junAmt, String julAmt, String augAmt, String sepAmt, String octAmt, String novAmt, String decAmt, String reqUpdDt, String itmUpdDt, String rqstJanAmt, String rqstFebAmt, String rqstMarAmt, String rqstAprAmt, String rqstMayAmt, String rqstJunAmt, String rqstJulAmt, String rqstAugAmt, String rqstSepAmt, String rqstOctAmt, String rqstNovAmt, String rqstDecAmt, String chkAssigned, String engAbbrNm, String krnAbbrNm, String rqstLoclAmt, String rqstUsdAmt, String ticCd, String ttl, String ofcLvl1, String ofcLvl2, String slsOfcDivCd, String usdLoclXchRt, String rqstUtVal, String loclCurrCd) {
		this.aprAmt = aprAmt;
		this.itmUpdDt = itmUpdDt;
		this.rqstNovAmt = rqstNovAmt;
		this.marAmt = marAmt;
		this.augAmt = augAmt;
		this.novAmt = novAmt;
		this.rqstUsdAmt = rqstUsdAmt;
		this.pagerows = pagerows;
		this.genExpnTrnsDivCd = genExpnTrnsDivCd;
		this.rqstMayAmt = rqstMayAmt;
		this.genExpnRqstNo = genExpnRqstNo;
		this.rqstMarAmt = rqstMarAmt;
		this.decAmt = decAmt;
		this.genExpnItmNo = genExpnItmNo;
		this.crntGenExpnApstsCd = crntGenExpnApstsCd;
		this.julAmt = julAmt;
		this.rqstJanAmt = rqstJanAmt;
		this.loclCurrCd = loclCurrCd;
		this.krnAbbrNm = krnAbbrNm;
		this.febAmt = febAmt;
		this.rqstFebAmt = rqstFebAmt;
		this.ofcLvl1 = ofcLvl1;
		this.junAmt = junAmt;
		this.ofcLvl2 = ofcLvl2;
		this.octAmt = octAmt;
		this.sepAmt = sepAmt;
		this.rqstJulAmt = rqstJulAmt;
		this.genExpnItmDesc = genExpnItmDesc;
		this.crntGenExpnAproStepCd = crntGenExpnAproStepCd;
		this.mayAmt = mayAmt;
		this.ibflag = ibflag;
		this.engAbbrNm = engAbbrNm;
		this.rqstAprAmt = rqstAprAmt;
		this.rqstJunAmt = rqstJunAmt;
		this.usdLoclXchRt = usdLoclXchRt;
		this.rqstLoclAmt = rqstLoclAmt;
		this.rqstUtVal = rqstUtVal;
		this.janAmt = janAmt;
		this.genExpnCalcBssDesc = genExpnCalcBssDesc;
		this.rqstOctAmt = rqstOctAmt;
		this.rqstOpinRmk = rqstOpinRmk;
		this.chkAssigned = chkAssigned;
		this.rqstSepAmt = rqstSepAmt;
		this.rqstAugAmt = rqstAugAmt;
		this.genExpnCd = genExpnCd;
		this.ttl = ttl;
		this.reqUpdDt = reqUpdDt;
		this.ofcCd = ofcCd;
		this.rqstDecAmt = rqstDecAmt;
		this.genExpnRqstSeq = genExpnRqstSeq;
		this.ticCd = ticCd;
		this.slsOfcDivCd = slsOfcDivCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apr_amt", getAprAmt());
		this.hashColumns.put("itm_upd_dt", getItmUpdDt());
		this.hashColumns.put("rqst_nov_amt", getRqstNovAmt());
		this.hashColumns.put("mar_amt", getMarAmt());
		this.hashColumns.put("aug_amt", getAugAmt());
		this.hashColumns.put("nov_amt", getNovAmt());
		this.hashColumns.put("rqst_usd_amt", getRqstUsdAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gen_expn_trns_div_cd", getGenExpnTrnsDivCd());
		this.hashColumns.put("rqst_may_amt", getRqstMayAmt());
		this.hashColumns.put("gen_expn_rqst_no", getGenExpnRqstNo());
		this.hashColumns.put("rqst_mar_amt", getRqstMarAmt());
		this.hashColumns.put("dec_amt", getDecAmt());
		this.hashColumns.put("gen_expn_itm_no", getGenExpnItmNo());
		this.hashColumns.put("crnt_gen_expn_apsts_cd", getCrntGenExpnApstsCd());
		this.hashColumns.put("jul_amt", getJulAmt());
		this.hashColumns.put("rqst_jan_amt", getRqstJanAmt());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("krn_abbr_nm", getKrnAbbrNm());
		this.hashColumns.put("feb_amt", getFebAmt());
		this.hashColumns.put("rqst_feb_amt", getRqstFebAmt());
		this.hashColumns.put("ofc_lvl1", getOfcLvl1());
		this.hashColumns.put("jun_amt", getJunAmt());
		this.hashColumns.put("ofc_lvl2", getOfcLvl2());
		this.hashColumns.put("oct_amt", getOctAmt());
		this.hashColumns.put("sep_amt", getSepAmt());
		this.hashColumns.put("rqst_jul_amt", getRqstJulAmt());
		this.hashColumns.put("gen_expn_itm_desc", getGenExpnItmDesc());
		this.hashColumns.put("crnt_gen_expn_apro_step_cd", getCrntGenExpnAproStepCd());
		this.hashColumns.put("may_amt", getMayAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eng_abbr_nm", getEngAbbrNm());
		this.hashColumns.put("rqst_apr_amt", getRqstAprAmt());
		this.hashColumns.put("rqst_jun_amt", getRqstJunAmt());
		this.hashColumns.put("usd_locl_xch_rt", getUsdLoclXchRt());
		this.hashColumns.put("rqst_locl_amt", getRqstLoclAmt());
		this.hashColumns.put("rqst_ut_val", getRqstUtVal());
		this.hashColumns.put("jan_amt", getJanAmt());
		this.hashColumns.put("gen_expn_calc_bss_desc", getGenExpnCalcBssDesc());
		this.hashColumns.put("rqst_oct_amt", getRqstOctAmt());
		this.hashColumns.put("rqst_opin_rmk", getRqstOpinRmk());
		this.hashColumns.put("chk_assigned", getChkAssigned());
		this.hashColumns.put("rqst_sep_amt", getRqstSepAmt());
		this.hashColumns.put("rqst_aug_amt", getRqstAugAmt());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("ttl", getTtl());
		this.hashColumns.put("req_upd_dt", getReqUpdDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("rqst_dec_amt", getRqstDecAmt());
		this.hashColumns.put("gen_expn_rqst_seq", getGenExpnRqstSeq());
		this.hashColumns.put("tic_cd", getTicCd());
		this.hashColumns.put("sls_ofc_div_cd", getSlsOfcDivCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apr_amt", "aprAmt");
		this.hashFields.put("itm_upd_dt", "itmUpdDt");
		this.hashFields.put("rqst_nov_amt", "rqstNovAmt");
		this.hashFields.put("mar_amt", "marAmt");
		this.hashFields.put("aug_amt", "augAmt");
		this.hashFields.put("nov_amt", "novAmt");
		this.hashFields.put("rqst_usd_amt", "rqstUsdAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gen_expn_trns_div_cd", "genExpnTrnsDivCd");
		this.hashFields.put("rqst_may_amt", "rqstMayAmt");
		this.hashFields.put("gen_expn_rqst_no", "genExpnRqstNo");
		this.hashFields.put("rqst_mar_amt", "rqstMarAmt");
		this.hashFields.put("dec_amt", "decAmt");
		this.hashFields.put("gen_expn_itm_no", "genExpnItmNo");
		this.hashFields.put("crnt_gen_expn_apsts_cd", "crntGenExpnApstsCd");
		this.hashFields.put("jul_amt", "julAmt");
		this.hashFields.put("rqst_jan_amt", "rqstJanAmt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("krn_abbr_nm", "krnAbbrNm");
		this.hashFields.put("feb_amt", "febAmt");
		this.hashFields.put("rqst_feb_amt", "rqstFebAmt");
		this.hashFields.put("ofc_lvl1", "ofcLvl1");
		this.hashFields.put("jun_amt", "junAmt");
		this.hashFields.put("ofc_lvl2", "ofcLvl2");
		this.hashFields.put("oct_amt", "octAmt");
		this.hashFields.put("sep_amt", "sepAmt");
		this.hashFields.put("rqst_jul_amt", "rqstJulAmt");
		this.hashFields.put("gen_expn_itm_desc", "genExpnItmDesc");
		this.hashFields.put("crnt_gen_expn_apro_step_cd", "crntGenExpnAproStepCd");
		this.hashFields.put("may_amt", "mayAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eng_abbr_nm", "engAbbrNm");
		this.hashFields.put("rqst_apr_amt", "rqstAprAmt");
		this.hashFields.put("rqst_jun_amt", "rqstJunAmt");
		this.hashFields.put("usd_locl_xch_rt", "usdLoclXchRt");
		this.hashFields.put("rqst_locl_amt", "rqstLoclAmt");
		this.hashFields.put("rqst_ut_val", "rqstUtVal");
		this.hashFields.put("jan_amt", "janAmt");
		this.hashFields.put("gen_expn_calc_bss_desc", "genExpnCalcBssDesc");
		this.hashFields.put("rqst_oct_amt", "rqstOctAmt");
		this.hashFields.put("rqst_opin_rmk", "rqstOpinRmk");
		this.hashFields.put("chk_assigned", "chkAssigned");
		this.hashFields.put("rqst_sep_amt", "rqstSepAmt");
		this.hashFields.put("rqst_aug_amt", "rqstAugAmt");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("ttl", "ttl");
		this.hashFields.put("req_upd_dt", "reqUpdDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("rqst_dec_amt", "rqstDecAmt");
		this.hashFields.put("gen_expn_rqst_seq", "genExpnRqstSeq");
		this.hashFields.put("tic_cd", "ticCd");
		this.hashFields.put("sls_ofc_div_cd", "slsOfcDivCd");
		return this.hashFields;
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
	 * @return itmUpdDt
	 */
	public String getItmUpdDt() {
		return this.itmUpdDt;
	}
	
	/**
	 * Column Info
	 * @return rqstNovAmt
	 */
	public String getRqstNovAmt() {
		return this.rqstNovAmt;
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
	 * Column Info
	 * @return rqstUsdAmt
	 */
	public String getRqstUsdAmt() {
		return this.rqstUsdAmt;
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
	 * @return genExpnTrnsDivCd
	 */
	public String getGenExpnTrnsDivCd() {
		return this.genExpnTrnsDivCd;
	}
	
	/**
	 * Column Info
	 * @return rqstMayAmt
	 */
	public String getRqstMayAmt() {
		return this.rqstMayAmt;
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
	 * @return rqstMarAmt
	 */
	public String getRqstMarAmt() {
		return this.rqstMarAmt;
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
	 * @return crntGenExpnApstsCd
	 */
	public String getCrntGenExpnApstsCd() {
		return this.crntGenExpnApstsCd;
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
	 * @return rqstJanAmt
	 */
	public String getRqstJanAmt() {
		return this.rqstJanAmt;
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
	 * @return krnAbbrNm
	 */
	public String getKrnAbbrNm() {
		return this.krnAbbrNm;
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
	 * @return rqstFebAmt
	 */
	public String getRqstFebAmt() {
		return this.rqstFebAmt;
	}
	
	/**
	 * Column Info
	 * @return ofcLvl1
	 */
	public String getOfcLvl1() {
		return this.ofcLvl1;
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
	 * @return ofcLvl2
	 */
	public String getOfcLvl2() {
		return this.ofcLvl2;
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
	 * @return rqstJulAmt
	 */
	public String getRqstJulAmt() {
		return this.rqstJulAmt;
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
	 * @return crntGenExpnAproStepCd
	 */
	public String getCrntGenExpnAproStepCd() {
		return this.crntGenExpnAproStepCd;
	}
	
	/**
	 * Column Info
	 * @return mayAmt
	 */
	public String getMayAmt() {
		return this.mayAmt;
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
	 * @return engAbbrNm
	 */
	public String getEngAbbrNm() {
		return this.engAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return rqstAprAmt
	 */
	public String getRqstAprAmt() {
		return this.rqstAprAmt;
	}
	
	/**
	 * Column Info
	 * @return rqstJunAmt
	 */
	public String getRqstJunAmt() {
		return this.rqstJunAmt;
	}
	
	/**
	 * Column Info
	 * @return usdLoclXchRt
	 */
	public String getUsdLoclXchRt() {
		return this.usdLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @return rqstLoclAmt
	 */
	public String getRqstLoclAmt() {
		return this.rqstLoclAmt;
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
	 * @return genExpnCalcBssDesc
	 */
	public String getGenExpnCalcBssDesc() {
		return this.genExpnCalcBssDesc;
	}
	
	/**
	 * Column Info
	 * @return rqstOctAmt
	 */
	public String getRqstOctAmt() {
		return this.rqstOctAmt;
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
	 * @return chkAssigned
	 */
	public String getChkAssigned() {
		return this.chkAssigned;
	}
	
	/**
	 * Column Info
	 * @return rqstSepAmt
	 */
	public String getRqstSepAmt() {
		return this.rqstSepAmt;
	}
	
	/**
	 * Column Info
	 * @return rqstAugAmt
	 */
	public String getRqstAugAmt() {
		return this.rqstAugAmt;
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
	 * @return ttl
	 */
	public String getTtl() {
		return this.ttl;
	}
	
	/**
	 * Column Info
	 * @return reqUpdDt
	 */
	public String getReqUpdDt() {
		return this.reqUpdDt;
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
	 * @return rqstDecAmt
	 */
	public String getRqstDecAmt() {
		return this.rqstDecAmt;
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
	 * @return slsOfcDivCd
	 */
	public String getSlsOfcDivCd() {
		return this.slsOfcDivCd;
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
	 * @param itmUpdDt
	 */
	public void setItmUpdDt(String itmUpdDt) {
		this.itmUpdDt = itmUpdDt;
	}
	
	/**
	 * Column Info
	 * @param rqstNovAmt
	 */
	public void setRqstNovAmt(String rqstNovAmt) {
		this.rqstNovAmt = rqstNovAmt;
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
	 * Column Info
	 * @param rqstUsdAmt
	 */
	public void setRqstUsdAmt(String rqstUsdAmt) {
		this.rqstUsdAmt = rqstUsdAmt;
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
	 * @param genExpnTrnsDivCd
	 */
	public void setGenExpnTrnsDivCd(String genExpnTrnsDivCd) {
		this.genExpnTrnsDivCd = genExpnTrnsDivCd;
	}
	
	/**
	 * Column Info
	 * @param rqstMayAmt
	 */
	public void setRqstMayAmt(String rqstMayAmt) {
		this.rqstMayAmt = rqstMayAmt;
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
	 * @param rqstMarAmt
	 */
	public void setRqstMarAmt(String rqstMarAmt) {
		this.rqstMarAmt = rqstMarAmt;
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
	 * @param crntGenExpnApstsCd
	 */
	public void setCrntGenExpnApstsCd(String crntGenExpnApstsCd) {
		this.crntGenExpnApstsCd = crntGenExpnApstsCd;
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
	 * @param rqstJanAmt
	 */
	public void setRqstJanAmt(String rqstJanAmt) {
		this.rqstJanAmt = rqstJanAmt;
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
	 * @param krnAbbrNm
	 */
	public void setKrnAbbrNm(String krnAbbrNm) {
		this.krnAbbrNm = krnAbbrNm;
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
	 * @param rqstFebAmt
	 */
	public void setRqstFebAmt(String rqstFebAmt) {
		this.rqstFebAmt = rqstFebAmt;
	}
	
	/**
	 * Column Info
	 * @param ofcLvl1
	 */
	public void setOfcLvl1(String ofcLvl1) {
		this.ofcLvl1 = ofcLvl1;
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
	 * @param ofcLvl2
	 */
	public void setOfcLvl2(String ofcLvl2) {
		this.ofcLvl2 = ofcLvl2;
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
	 * @param rqstJulAmt
	 */
	public void setRqstJulAmt(String rqstJulAmt) {
		this.rqstJulAmt = rqstJulAmt;
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
	 * @param crntGenExpnAproStepCd
	 */
	public void setCrntGenExpnAproStepCd(String crntGenExpnAproStepCd) {
		this.crntGenExpnAproStepCd = crntGenExpnAproStepCd;
	}
	
	/**
	 * Column Info
	 * @param mayAmt
	 */
	public void setMayAmt(String mayAmt) {
		this.mayAmt = mayAmt;
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
	 * @param engAbbrNm
	 */
	public void setEngAbbrNm(String engAbbrNm) {
		this.engAbbrNm = engAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param rqstAprAmt
	 */
	public void setRqstAprAmt(String rqstAprAmt) {
		this.rqstAprAmt = rqstAprAmt;
	}
	
	/**
	 * Column Info
	 * @param rqstJunAmt
	 */
	public void setRqstJunAmt(String rqstJunAmt) {
		this.rqstJunAmt = rqstJunAmt;
	}
	
	/**
	 * Column Info
	 * @param usdLoclXchRt
	 */
	public void setUsdLoclXchRt(String usdLoclXchRt) {
		this.usdLoclXchRt = usdLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @param rqstLoclAmt
	 */
	public void setRqstLoclAmt(String rqstLoclAmt) {
		this.rqstLoclAmt = rqstLoclAmt;
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
	 * @param genExpnCalcBssDesc
	 */
	public void setGenExpnCalcBssDesc(String genExpnCalcBssDesc) {
		this.genExpnCalcBssDesc = genExpnCalcBssDesc;
	}
	
	/**
	 * Column Info
	 * @param rqstOctAmt
	 */
	public void setRqstOctAmt(String rqstOctAmt) {
		this.rqstOctAmt = rqstOctAmt;
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
	 * @param chkAssigned
	 */
	public void setChkAssigned(String chkAssigned) {
		this.chkAssigned = chkAssigned;
	}
	
	/**
	 * Column Info
	 * @param rqstSepAmt
	 */
	public void setRqstSepAmt(String rqstSepAmt) {
		this.rqstSepAmt = rqstSepAmt;
	}
	
	/**
	 * Column Info
	 * @param rqstAugAmt
	 */
	public void setRqstAugAmt(String rqstAugAmt) {
		this.rqstAugAmt = rqstAugAmt;
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
	 * @param ttl
	 */
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	
	/**
	 * Column Info
	 * @param reqUpdDt
	 */
	public void setReqUpdDt(String reqUpdDt) {
		this.reqUpdDt = reqUpdDt;
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
	 * @param rqstDecAmt
	 */
	public void setRqstDecAmt(String rqstDecAmt) {
		this.rqstDecAmt = rqstDecAmt;
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
	 * Column Info
	 * @param slsOfcDivCd
	 */
	public void setSlsOfcDivCd(String slsOfcDivCd) {
		this.slsOfcDivCd = slsOfcDivCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAprAmt(JSPUtil.getParameter(request, "apr_amt", ""));
		setItmUpdDt(JSPUtil.getParameter(request, "itm_upd_dt", ""));
		setRqstNovAmt(JSPUtil.getParameter(request, "rqst_nov_amt", ""));
		setMarAmt(JSPUtil.getParameter(request, "mar_amt", ""));
		setAugAmt(JSPUtil.getParameter(request, "aug_amt", ""));
		setNovAmt(JSPUtil.getParameter(request, "nov_amt", ""));
		setRqstUsdAmt(JSPUtil.getParameter(request, "rqst_usd_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setGenExpnTrnsDivCd(JSPUtil.getParameter(request, "gen_expn_trns_div_cd", ""));
		setRqstMayAmt(JSPUtil.getParameter(request, "rqst_may_amt", ""));
		setGenExpnRqstNo(JSPUtil.getParameter(request, "gen_expn_rqst_no", ""));
		setRqstMarAmt(JSPUtil.getParameter(request, "rqst_mar_amt", ""));
		setDecAmt(JSPUtil.getParameter(request, "dec_amt", ""));
		setGenExpnItmNo(JSPUtil.getParameter(request, "gen_expn_itm_no", ""));
		setCrntGenExpnApstsCd(JSPUtil.getParameter(request, "crnt_gen_expn_apsts_cd", ""));
		setJulAmt(JSPUtil.getParameter(request, "jul_amt", ""));
		setRqstJanAmt(JSPUtil.getParameter(request, "rqst_jan_amt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setKrnAbbrNm(JSPUtil.getParameter(request, "krn_abbr_nm", ""));
		setFebAmt(JSPUtil.getParameter(request, "feb_amt", ""));
		setRqstFebAmt(JSPUtil.getParameter(request, "rqst_feb_amt", ""));
		setOfcLvl1(JSPUtil.getParameter(request, "ofc_lvl1", ""));
		setJunAmt(JSPUtil.getParameter(request, "jun_amt", ""));
		setOfcLvl2(JSPUtil.getParameter(request, "ofc_lvl2", ""));
		setOctAmt(JSPUtil.getParameter(request, "oct_amt", ""));
		setSepAmt(JSPUtil.getParameter(request, "sep_amt", ""));
		setRqstJulAmt(JSPUtil.getParameter(request, "rqst_jul_amt", ""));
		setGenExpnItmDesc(JSPUtil.getParameter(request, "gen_expn_itm_desc", ""));
		setCrntGenExpnAproStepCd(JSPUtil.getParameter(request, "crnt_gen_expn_apro_step_cd", ""));
		setMayAmt(JSPUtil.getParameter(request, "may_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEngAbbrNm(JSPUtil.getParameter(request, "eng_abbr_nm", ""));
		setRqstAprAmt(JSPUtil.getParameter(request, "rqst_apr_amt", ""));
		setRqstJunAmt(JSPUtil.getParameter(request, "rqst_jun_amt", ""));
		setUsdLoclXchRt(JSPUtil.getParameter(request, "usd_locl_xch_rt", ""));
		setRqstLoclAmt(JSPUtil.getParameter(request, "rqst_locl_amt", ""));
		setRqstUtVal(JSPUtil.getParameter(request, "rqst_ut_val", ""));
		setJanAmt(JSPUtil.getParameter(request, "jan_amt", ""));
		setGenExpnCalcBssDesc(JSPUtil.getParameter(request, "gen_expn_calc_bss_desc", ""));
		setRqstOctAmt(JSPUtil.getParameter(request, "rqst_oct_amt", ""));
		setRqstOpinRmk(JSPUtil.getParameter(request, "rqst_opin_rmk", ""));
		setChkAssigned(JSPUtil.getParameter(request, "chk_assigned", ""));
		setRqstSepAmt(JSPUtil.getParameter(request, "rqst_sep_amt", ""));
		setRqstAugAmt(JSPUtil.getParameter(request, "rqst_aug_amt", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setTtl(JSPUtil.getParameter(request, "ttl", ""));
		setReqUpdDt(JSPUtil.getParameter(request, "req_upd_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setRqstDecAmt(JSPUtil.getParameter(request, "rqst_dec_amt", ""));
		setGenExpnRqstSeq(JSPUtil.getParameter(request, "gen_expn_rqst_seq", ""));
		setTicCd(JSPUtil.getParameter(request, "tic_cd", ""));
		setSlsOfcDivCd(JSPUtil.getParameter(request, "sls_ofc_div_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ItemVO[]
	 */
	public ItemVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ItemVO[]
	 */
	public ItemVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ItemVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aprAmt = (JSPUtil.getParameter(request, prefix	+ "apr_amt", length));
			String[] itmUpdDt = (JSPUtil.getParameter(request, prefix	+ "itm_upd_dt", length));
			String[] rqstNovAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_nov_amt", length));
			String[] marAmt = (JSPUtil.getParameter(request, prefix	+ "mar_amt", length));
			String[] augAmt = (JSPUtil.getParameter(request, prefix	+ "aug_amt", length));
			String[] novAmt = (JSPUtil.getParameter(request, prefix	+ "nov_amt", length));
			String[] rqstUsdAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_usd_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] genExpnTrnsDivCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_trns_div_cd", length));
			String[] rqstMayAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_may_amt", length));
			String[] genExpnRqstNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no", length));
			String[] rqstMarAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_mar_amt", length));
			String[] decAmt = (JSPUtil.getParameter(request, prefix	+ "dec_amt", length));
			String[] genExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_itm_no", length));
			String[] crntGenExpnApstsCd = (JSPUtil.getParameter(request, prefix	+ "crnt_gen_expn_apsts_cd", length));
			String[] julAmt = (JSPUtil.getParameter(request, prefix	+ "jul_amt", length));
			String[] rqstJanAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_jan_amt", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] krnAbbrNm = (JSPUtil.getParameter(request, prefix	+ "krn_abbr_nm", length));
			String[] febAmt = (JSPUtil.getParameter(request, prefix	+ "feb_amt", length));
			String[] rqstFebAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_feb_amt", length));
			String[] ofcLvl1 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl1", length));
			String[] junAmt = (JSPUtil.getParameter(request, prefix	+ "jun_amt", length));
			String[] ofcLvl2 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl2", length));
			String[] octAmt = (JSPUtil.getParameter(request, prefix	+ "oct_amt", length));
			String[] sepAmt = (JSPUtil.getParameter(request, prefix	+ "sep_amt", length));
			String[] rqstJulAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_jul_amt", length));
			String[] genExpnItmDesc = (JSPUtil.getParameter(request, prefix	+ "gen_expn_itm_desc", length));
			String[] crntGenExpnAproStepCd = (JSPUtil.getParameter(request, prefix	+ "crnt_gen_expn_apro_step_cd", length));
			String[] mayAmt = (JSPUtil.getParameter(request, prefix	+ "may_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] engAbbrNm = (JSPUtil.getParameter(request, prefix	+ "eng_abbr_nm", length));
			String[] rqstAprAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_apr_amt", length));
			String[] rqstJunAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_jun_amt", length));
			String[] usdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_locl_xch_rt", length));
			String[] rqstLoclAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_locl_amt", length));
			String[] rqstUtVal = (JSPUtil.getParameter(request, prefix	+ "rqst_ut_val", length));
			String[] janAmt = (JSPUtil.getParameter(request, prefix	+ "jan_amt", length));
			String[] genExpnCalcBssDesc = (JSPUtil.getParameter(request, prefix	+ "gen_expn_calc_bss_desc", length));
			String[] rqstOctAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_oct_amt", length));
			String[] rqstOpinRmk = (JSPUtil.getParameter(request, prefix	+ "rqst_opin_rmk", length));
			String[] chkAssigned = (JSPUtil.getParameter(request, prefix	+ "chk_assigned", length));
			String[] rqstSepAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_sep_amt", length));
			String[] rqstAugAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_aug_amt", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] ttl = (JSPUtil.getParameter(request, prefix	+ "ttl", length));
			String[] reqUpdDt = (JSPUtil.getParameter(request, prefix	+ "req_upd_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] rqstDecAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_dec_amt", length));
			String[] genExpnRqstSeq = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_seq", length));
			String[] ticCd = (JSPUtil.getParameter(request, prefix	+ "tic_cd", length));
			String[] slsOfcDivCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_div_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ItemVO();
				if (aprAmt[i] != null)
					model.setAprAmt(aprAmt[i]);
				if (itmUpdDt[i] != null)
					model.setItmUpdDt(itmUpdDt[i]);
				if (rqstNovAmt[i] != null)
					model.setRqstNovAmt(rqstNovAmt[i]);
				if (marAmt[i] != null)
					model.setMarAmt(marAmt[i]);
				if (augAmt[i] != null)
					model.setAugAmt(augAmt[i]);
				if (novAmt[i] != null)
					model.setNovAmt(novAmt[i]);
				if (rqstUsdAmt[i] != null)
					model.setRqstUsdAmt(rqstUsdAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (genExpnTrnsDivCd[i] != null)
					model.setGenExpnTrnsDivCd(genExpnTrnsDivCd[i]);
				if (rqstMayAmt[i] != null)
					model.setRqstMayAmt(rqstMayAmt[i]);
				if (genExpnRqstNo[i] != null)
					model.setGenExpnRqstNo(genExpnRqstNo[i]);
				if (rqstMarAmt[i] != null)
					model.setRqstMarAmt(rqstMarAmt[i]);
				if (decAmt[i] != null)
					model.setDecAmt(decAmt[i]);
				if (genExpnItmNo[i] != null)
					model.setGenExpnItmNo(genExpnItmNo[i]);
				if (crntGenExpnApstsCd[i] != null)
					model.setCrntGenExpnApstsCd(crntGenExpnApstsCd[i]);
				if (julAmt[i] != null)
					model.setJulAmt(julAmt[i]);
				if (rqstJanAmt[i] != null)
					model.setRqstJanAmt(rqstJanAmt[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (krnAbbrNm[i] != null)
					model.setKrnAbbrNm(krnAbbrNm[i]);
				if (febAmt[i] != null)
					model.setFebAmt(febAmt[i]);
				if (rqstFebAmt[i] != null)
					model.setRqstFebAmt(rqstFebAmt[i]);
				if (ofcLvl1[i] != null)
					model.setOfcLvl1(ofcLvl1[i]);
				if (junAmt[i] != null)
					model.setJunAmt(junAmt[i]);
				if (ofcLvl2[i] != null)
					model.setOfcLvl2(ofcLvl2[i]);
				if (octAmt[i] != null)
					model.setOctAmt(octAmt[i]);
				if (sepAmt[i] != null)
					model.setSepAmt(sepAmt[i]);
				if (rqstJulAmt[i] != null)
					model.setRqstJulAmt(rqstJulAmt[i]);
				if (genExpnItmDesc[i] != null)
					model.setGenExpnItmDesc(genExpnItmDesc[i]);
				if (crntGenExpnAproStepCd[i] != null)
					model.setCrntGenExpnAproStepCd(crntGenExpnAproStepCd[i]);
				if (mayAmt[i] != null)
					model.setMayAmt(mayAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (engAbbrNm[i] != null)
					model.setEngAbbrNm(engAbbrNm[i]);
				if (rqstAprAmt[i] != null)
					model.setRqstAprAmt(rqstAprAmt[i]);
				if (rqstJunAmt[i] != null)
					model.setRqstJunAmt(rqstJunAmt[i]);
				if (usdLoclXchRt[i] != null)
					model.setUsdLoclXchRt(usdLoclXchRt[i]);
				if (rqstLoclAmt[i] != null)
					model.setRqstLoclAmt(rqstLoclAmt[i]);
				if (rqstUtVal[i] != null)
					model.setRqstUtVal(rqstUtVal[i]);
				if (janAmt[i] != null)
					model.setJanAmt(janAmt[i]);
				if (genExpnCalcBssDesc[i] != null)
					model.setGenExpnCalcBssDesc(genExpnCalcBssDesc[i]);
				if (rqstOctAmt[i] != null)
					model.setRqstOctAmt(rqstOctAmt[i]);
				if (rqstOpinRmk[i] != null)
					model.setRqstOpinRmk(rqstOpinRmk[i]);
				if (chkAssigned[i] != null)
					model.setChkAssigned(chkAssigned[i]);
				if (rqstSepAmt[i] != null)
					model.setRqstSepAmt(rqstSepAmt[i]);
				if (rqstAugAmt[i] != null)
					model.setRqstAugAmt(rqstAugAmt[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (ttl[i] != null)
					model.setTtl(ttl[i]);
				if (reqUpdDt[i] != null)
					model.setReqUpdDt(reqUpdDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (rqstDecAmt[i] != null)
					model.setRqstDecAmt(rqstDecAmt[i]);
				if (genExpnRqstSeq[i] != null)
					model.setGenExpnRqstSeq(genExpnRqstSeq[i]);
				if (ticCd[i] != null)
					model.setTicCd(ticCd[i]);
				if (slsOfcDivCd[i] != null)
					model.setSlsOfcDivCd(slsOfcDivCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getItemVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ItemVO[]
	 */
	public ItemVO[] getItemVOs(){
		ItemVO[] vos = (ItemVO[])models.toArray(new ItemVO[models.size()]);
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
		this.aprAmt = this.aprAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmUpdDt = this.itmUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNovAmt = this.rqstNovAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.marAmt = this.marAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.augAmt = this.augAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.novAmt = this.novAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsdAmt = this.rqstUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnTrnsDivCd = this.genExpnTrnsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstMayAmt = this.rqstMayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo = this.genExpnRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstMarAmt = this.rqstMarAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.decAmt = this.decAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnItmNo = this.genExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntGenExpnApstsCd = this.crntGenExpnApstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.julAmt = this.julAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstJanAmt = this.rqstJanAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krnAbbrNm = this.krnAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.febAmt = this.febAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstFebAmt = this.rqstFebAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl1 = this.ofcLvl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.junAmt = this.junAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl2 = this.ofcLvl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.octAmt = this.octAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sepAmt = this.sepAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstJulAmt = this.rqstJulAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnItmDesc = this.genExpnItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntGenExpnAproStepCd = this.crntGenExpnAproStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mayAmt = this.mayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engAbbrNm = this.engAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstAprAmt = this.rqstAprAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstJunAmt = this.rqstJunAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLoclXchRt = this.usdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstLoclAmt = this.rqstLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUtVal = this.rqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.janAmt = this.janAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCalcBssDesc = this.genExpnCalcBssDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOctAmt = this.rqstOctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOpinRmk = this.rqstOpinRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkAssigned = this.chkAssigned .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstSepAmt = this.rqstSepAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstAugAmt = this.rqstAugAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl = this.ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqUpdDt = this.reqUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDecAmt = this.rqstDecAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstSeq = this.genExpnRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticCd = this.ticCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcDivCd = this.slsOfcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
