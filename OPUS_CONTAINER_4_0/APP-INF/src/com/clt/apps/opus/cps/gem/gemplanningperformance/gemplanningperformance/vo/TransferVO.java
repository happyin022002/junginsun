/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferVO.java
*@FileTitle : TransferVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.13 진윤오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TransferVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TransferVO> models = new ArrayList<TransferVO>();
	
	/* Column Info */
	private String toSepAmt = null;
	/* Column Info */
	private String fmGenExpnItmDesc = null;
	/* Column Info */
	private String fmNovAmt = null;
	/* Column Info */
	private String fmRqstDecAmt = null;
	/* Column Info */
	private String toUsdLoclXchRt = null;
	/* Column Info */
	private String itmUpdDt = null;
	/* Column Info */
	private String toRqstNovAmt = null;
	/* Column Info */
	private String toGenExpnCd = null;
	/* Column Info */
	private String fmRqstAprAmt = null;
	/* Column Info */
	private String fmRqstJunAmt = null;
	/* Column Info */
	private String toRqstJulAmt = null;
	/* Column Info */
	private String fmOfcCd = null;
	/* Column Info */
	private String toTicCd = null;
	/* Column Info */
	private String fmOfcLvl2 = null;
	/* Column Info */
	private String fmOfcLvl1 = null;
	/* Column Info */
	private String fmRqstAugAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmRqstNovAmt = null;
	/* Column Info */
	private String toRqstLoclAmt = null;
	/* Column Info */
	private String fmAugAmt = null;
	/* Column Info */
	private String toRqstMarAmt = null;
	/* Column Info */
	private String fmRqstJanAmt = null;
	/* Column Info */
	private String fmRqstJulAmt = null;
	/* Column Info */
	private String fmRqstOctAmt = null;
	/* Column Info */
	private String fmGenExpnItmNo = null;
	/* Column Info */
	private String toJulAmt = null;
	/* Column Info */
	private String toRqstJunAmt = null;
	/* Column Info */
	private String toGenExpnItmNo = null;
	/* Column Info */
	private String toEngAbbrNm = null;
	/* Column Info */
	private String toTtl = null;
	/* Column Info */
	private String toJunAmt = null;
	/* Column Info */
	private String fmTicCd = null;
	/* Column Info */
	private String fmRqstSepAmt = null;
	/* Column Info */
	private String toRqstUsdAmt = null;
	/* Column Info */
	private String fmKrnAbbrNm = null;
	/* Column Info */
	private String fmRqstFebAmt = null;
	/* Column Info */
	private String fmSlsOfcDivCd = null;
	/* Column Info */
	private String toRqstOpinRmk = null;
	/* Column Info */
	private String toRqstSepAmt = null;
	/* Column Info */
	private String toOfcCd = null;
	/* Column Info */
	private String retrieveYn = null;
	/* Column Info */
	private String toAugAmt = null;
	/* Column Info */
	private String fmOctAmt = null;
	/* Column Info */
	private String toRqstAugAmt = null;
	/* Column Info */
	private String toChkAssigned = null;
	/* Column Info */
	private String toNovAmt = null;
	/* Column Info */
	private String toLoclCurrCd = null;
	/* Column Info */
	private String fmUsdLoclXchRt = null;
	/* Column Info */
	private String toMarAmt = null;
	/* Column Info */
	private String fmEngAbbrNm = null;
	/* Column Info */
	private String toRqstDecAmt = null;
	/* Column Info */
	private String toRqstUtVal = null;
	/* Column Info */
	private String fmLoclCurrCd = null;
	/* Column Info */
	private String toDecAmt = null;
	/* Column Info */
	private String toGenExpnItmDesc = null;
	/* Column Info */
	private String toGenExpnTrnsDivCd = null;
	/* Column Info */
	private String fmTtl = null;
	/* Column Info */
	private String fmSepAmt = null;
	/* Column Info */
	private String fmChkAssigned = null;
	/* Column Info */
	private String fmMayAmt = null;
	/* Column Info */
	private String fmDecAmt = null;
	/* Column Info */
	private String fmGenExpnCd = null;
	/* Column Info */
	private String fmRqstUsdAmt = null;
	/* Column Info */
	private String toRqstOctAmt = null;
	/* Column Info */
	private String toSlsOfcDivCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmFebAmt = null;
	/* Column Info */
	private String fmRqstMarAmt = null;
	/* Column Info */
	private String toRqstMayAmt = null;
	/* Column Info */
	private String toGenExpnRqstSeq = null;
	/* Column Info */
	private String toOfcLvl1 = null;
	/* Column Info */
	private String toOfcLvl2 = null;
	/* Column Info */
	private String toAprAmt = null;
	/* Column Info */
	private String fmJanAmt = null;
	/* Column Info */
	private String fmRqstOpinRmk = null;
	/* Column Info */
	private String toRqstAprAmt = null;
	/* Column Info */
	private String fmGenExpnCalcBssDesc = null;
	/* Column Info */
	private String fmJunAmt = null;
	/* Column Info */
	private String fmJulAmt = null;
	/* Column Info */
	private String fmRqstMayAmt = null;
	/* Column Info */
	private String toJanAmt = null;
	/* Column Info */
	private String fmAprAmt = null;
	/* Column Info */
	private String toRqstFebAmt = null;
	/* Column Info */
	private String toKrnAbbrNm = null;
	/* Column Info */
	private String reqUpdDt = null;
	/* Column Info */
	private String fmMarAmt = null;
	/* Column Info */
	private String toOctAmt = null;
	/* Column Info */
	private String toMayAmt = null;
	/* Column Info */
	private String fmRqstUtVal = null;
	/* Column Info */
	private String fmRqstLoclAmt = null;
	/* Column Info */
	private String fmGenExpnTrnsDivCd = null;
	/* Column Info */
	private String fmGenExpnRqstSeq = null;
	/* Column Info */
	private String toRqstJanAmt = null;
	/* Column Info */
	private String toFebAmt = null;
	/* Column Info */
	private String toGenExpnCalcBssDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TransferVO() {}

	public TransferVO(String ibflag, String pagerows, String fmGenExpnRqstSeq, String fmOfcCd, String fmGenExpnCd, String fmRqstLoclAmt, String fmRqstUsdAmt, String fmGenExpnTrnsDivCd, String fmSlsOfcDivCd, String fmOfcLvl1, String fmOfcLvl2, String fmEngAbbrNm, String fmKrnAbbrNm, String fmLoclCurrCd, String fmRqstUtVal, String fmUsdLoclXchRt, String fmTicCd, String fmChkAssigned, String fmGenExpnItmNo, String fmGenExpnItmDesc, String fmGenExpnCalcBssDesc, String fmRqstOpinRmk, String fmJanAmt, String fmFebAmt, String fmMarAmt, String fmAprAmt, String fmMayAmt, String fmJunAmt, String fmJulAmt, String fmAugAmt, String fmSepAmt, String fmOctAmt, String fmNovAmt, String fmDecAmt, String fmTtl, String fmRqstJanAmt, String fmRqstFebAmt, String fmRqstMarAmt, String fmRqstAprAmt, String fmRqstMayAmt, String fmRqstJunAmt, String fmRqstJulAmt, String fmRqstAugAmt, String fmRqstSepAmt, String fmRqstOctAmt, String fmRqstNovAmt, String fmRqstDecAmt, String toOfcCd, String toGenExpnCd, String toRqstLoclAmt, String toRqstUsdAmt, String toGenExpnRqstSeq, String toGenExpnTrnsDivCd, String toSlsOfcDivCd, String toOfcLvl1, String toOfcLvl2, String toEngAbbrNm, String toKrnAbbrNm, String toLoclCurrCd, String toRqstUtVal, String toUsdLoclXchRt, String toTicCd, String toChkAssigned, String toGenExpnItmNo, String toGenExpnItmDesc, String toGenExpnCalcBssDesc, String toRqstOpinRmk, String toJanAmt, String toFebAmt, String toMarAmt, String toAprAmt, String toMayAmt, String toJunAmt, String toJulAmt, String toAugAmt, String toSepAmt, String toOctAmt, String toNovAmt, String toDecAmt, String toTtl, String toRqstJanAmt, String toRqstFebAmt, String toRqstMarAmt, String toRqstAprAmt, String toRqstMayAmt, String toRqstJunAmt, String toRqstJulAmt, String toRqstAugAmt, String toRqstSepAmt, String toRqstOctAmt, String toRqstNovAmt, String toRqstDecAmt, String retrieveYn, String itmUpdDt, String reqUpdDt) {
		this.toSepAmt = toSepAmt;
		this.fmGenExpnItmDesc = fmGenExpnItmDesc;
		this.fmNovAmt = fmNovAmt;
		this.fmRqstDecAmt = fmRqstDecAmt;
		this.toUsdLoclXchRt = toUsdLoclXchRt;
		this.itmUpdDt = itmUpdDt;
		this.toRqstNovAmt = toRqstNovAmt;
		this.toGenExpnCd = toGenExpnCd;
		this.fmRqstAprAmt = fmRqstAprAmt;
		this.fmRqstJunAmt = fmRqstJunAmt;
		this.toRqstJulAmt = toRqstJulAmt;
		this.fmOfcCd = fmOfcCd;
		this.toTicCd = toTicCd;
		this.fmOfcLvl2 = fmOfcLvl2;
		this.fmOfcLvl1 = fmOfcLvl1;
		this.fmRqstAugAmt = fmRqstAugAmt;
		this.pagerows = pagerows;
		this.fmRqstNovAmt = fmRqstNovAmt;
		this.toRqstLoclAmt = toRqstLoclAmt;
		this.fmAugAmt = fmAugAmt;
		this.toRqstMarAmt = toRqstMarAmt;
		this.fmRqstJanAmt = fmRqstJanAmt;
		this.fmRqstJulAmt = fmRqstJulAmt;
		this.fmRqstOctAmt = fmRqstOctAmt;
		this.fmGenExpnItmNo = fmGenExpnItmNo;
		this.toJulAmt = toJulAmt;
		this.toRqstJunAmt = toRqstJunAmt;
		this.toGenExpnItmNo = toGenExpnItmNo;
		this.toEngAbbrNm = toEngAbbrNm;
		this.toTtl = toTtl;
		this.toJunAmt = toJunAmt;
		this.fmTicCd = fmTicCd;
		this.fmRqstSepAmt = fmRqstSepAmt;
		this.toRqstUsdAmt = toRqstUsdAmt;
		this.fmKrnAbbrNm = fmKrnAbbrNm;
		this.fmRqstFebAmt = fmRqstFebAmt;
		this.fmSlsOfcDivCd = fmSlsOfcDivCd;
		this.toRqstOpinRmk = toRqstOpinRmk;
		this.toRqstSepAmt = toRqstSepAmt;
		this.toOfcCd = toOfcCd;
		this.retrieveYn = retrieveYn;
		this.toAugAmt = toAugAmt;
		this.fmOctAmt = fmOctAmt;
		this.toRqstAugAmt = toRqstAugAmt;
		this.toChkAssigned = toChkAssigned;
		this.toNovAmt = toNovAmt;
		this.toLoclCurrCd = toLoclCurrCd;
		this.fmUsdLoclXchRt = fmUsdLoclXchRt;
		this.toMarAmt = toMarAmt;
		this.fmEngAbbrNm = fmEngAbbrNm;
		this.toRqstDecAmt = toRqstDecAmt;
		this.toRqstUtVal = toRqstUtVal;
		this.fmLoclCurrCd = fmLoclCurrCd;
		this.toDecAmt = toDecAmt;
		this.toGenExpnItmDesc = toGenExpnItmDesc;
		this.toGenExpnTrnsDivCd = toGenExpnTrnsDivCd;
		this.fmTtl = fmTtl;
		this.fmSepAmt = fmSepAmt;
		this.fmChkAssigned = fmChkAssigned;
		this.fmMayAmt = fmMayAmt;
		this.fmDecAmt = fmDecAmt;
		this.fmGenExpnCd = fmGenExpnCd;
		this.fmRqstUsdAmt = fmRqstUsdAmt;
		this.toRqstOctAmt = toRqstOctAmt;
		this.toSlsOfcDivCd = toSlsOfcDivCd;
		this.ibflag = ibflag;
		this.fmFebAmt = fmFebAmt;
		this.fmRqstMarAmt = fmRqstMarAmt;
		this.toRqstMayAmt = toRqstMayAmt;
		this.toGenExpnRqstSeq = toGenExpnRqstSeq;
		this.toOfcLvl1 = toOfcLvl1;
		this.toOfcLvl2 = toOfcLvl2;
		this.toAprAmt = toAprAmt;
		this.fmJanAmt = fmJanAmt;
		this.fmRqstOpinRmk = fmRqstOpinRmk;
		this.toRqstAprAmt = toRqstAprAmt;
		this.fmGenExpnCalcBssDesc = fmGenExpnCalcBssDesc;
		this.fmJunAmt = fmJunAmt;
		this.fmJulAmt = fmJulAmt;
		this.fmRqstMayAmt = fmRqstMayAmt;
		this.toJanAmt = toJanAmt;
		this.fmAprAmt = fmAprAmt;
		this.toRqstFebAmt = toRqstFebAmt;
		this.toKrnAbbrNm = toKrnAbbrNm;
		this.reqUpdDt = reqUpdDt;
		this.fmMarAmt = fmMarAmt;
		this.toOctAmt = toOctAmt;
		this.toMayAmt = toMayAmt;
		this.fmRqstUtVal = fmRqstUtVal;
		this.fmRqstLoclAmt = fmRqstLoclAmt;
		this.fmGenExpnTrnsDivCd = fmGenExpnTrnsDivCd;
		this.fmGenExpnRqstSeq = fmGenExpnRqstSeq;
		this.toRqstJanAmt = toRqstJanAmt;
		this.toFebAmt = toFebAmt;
		this.toGenExpnCalcBssDesc = toGenExpnCalcBssDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_sep_amt", getToSepAmt());
		this.hashColumns.put("fm_gen_expn_itm_desc", getFmGenExpnItmDesc());
		this.hashColumns.put("fm_nov_amt", getFmNovAmt());
		this.hashColumns.put("fm_rqst_dec_amt", getFmRqstDecAmt());
		this.hashColumns.put("to_usd_locl_xch_rt", getToUsdLoclXchRt());
		this.hashColumns.put("itm_upd_dt", getItmUpdDt());
		this.hashColumns.put("to_rqst_nov_amt", getToRqstNovAmt());
		this.hashColumns.put("to_gen_expn_cd", getToGenExpnCd());
		this.hashColumns.put("fm_rqst_apr_amt", getFmRqstAprAmt());
		this.hashColumns.put("fm_rqst_jun_amt", getFmRqstJunAmt());
		this.hashColumns.put("to_rqst_jul_amt", getToRqstJulAmt());
		this.hashColumns.put("fm_ofc_cd", getFmOfcCd());
		this.hashColumns.put("to_tic_cd", getToTicCd());
		this.hashColumns.put("fm_ofc_lvl2", getFmOfcLvl2());
		this.hashColumns.put("fm_ofc_lvl1", getFmOfcLvl1());
		this.hashColumns.put("fm_rqst_aug_amt", getFmRqstAugAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fm_rqst_nov_amt", getFmRqstNovAmt());
		this.hashColumns.put("to_rqst_locl_amt", getToRqstLoclAmt());
		this.hashColumns.put("fm_aug_amt", getFmAugAmt());
		this.hashColumns.put("to_rqst_mar_amt", getToRqstMarAmt());
		this.hashColumns.put("fm_rqst_jan_amt", getFmRqstJanAmt());
		this.hashColumns.put("fm_rqst_jul_amt", getFmRqstJulAmt());
		this.hashColumns.put("fm_rqst_oct_amt", getFmRqstOctAmt());
		this.hashColumns.put("fm_gen_expn_itm_no", getFmGenExpnItmNo());
		this.hashColumns.put("to_jul_amt", getToJulAmt());
		this.hashColumns.put("to_rqst_jun_amt", getToRqstJunAmt());
		this.hashColumns.put("to_gen_expn_itm_no", getToGenExpnItmNo());
		this.hashColumns.put("to_eng_abbr_nm", getToEngAbbrNm());
		this.hashColumns.put("to_ttl", getToTtl());
		this.hashColumns.put("to_jun_amt", getToJunAmt());
		this.hashColumns.put("fm_tic_cd", getFmTicCd());
		this.hashColumns.put("fm_rqst_sep_amt", getFmRqstSepAmt());
		this.hashColumns.put("to_rqst_usd_amt", getToRqstUsdAmt());
		this.hashColumns.put("fm_krn_abbr_nm", getFmKrnAbbrNm());
		this.hashColumns.put("fm_rqst_feb_amt", getFmRqstFebAmt());
		this.hashColumns.put("fm_sls_ofc_div_cd", getFmSlsOfcDivCd());
		this.hashColumns.put("to_rqst_opin_rmk", getToRqstOpinRmk());
		this.hashColumns.put("to_rqst_sep_amt", getToRqstSepAmt());
		this.hashColumns.put("to_ofc_cd", getToOfcCd());
		this.hashColumns.put("retrieve_yn", getRetrieveYn());
		this.hashColumns.put("to_aug_amt", getToAugAmt());
		this.hashColumns.put("fm_oct_amt", getFmOctAmt());
		this.hashColumns.put("to_rqst_aug_amt", getToRqstAugAmt());
		this.hashColumns.put("to_chk_assigned", getToChkAssigned());
		this.hashColumns.put("to_nov_amt", getToNovAmt());
		this.hashColumns.put("to_locl_curr_cd", getToLoclCurrCd());
		this.hashColumns.put("fm_usd_locl_xch_rt", getFmUsdLoclXchRt());
		this.hashColumns.put("to_mar_amt", getToMarAmt());
		this.hashColumns.put("fm_eng_abbr_nm", getFmEngAbbrNm());
		this.hashColumns.put("to_rqst_dec_amt", getToRqstDecAmt());
		this.hashColumns.put("to_rqst_ut_val", getToRqstUtVal());
		this.hashColumns.put("fm_locl_curr_cd", getFmLoclCurrCd());
		this.hashColumns.put("to_dec_amt", getToDecAmt());
		this.hashColumns.put("to_gen_expn_itm_desc", getToGenExpnItmDesc());
		this.hashColumns.put("to_gen_expn_trns_div_cd", getToGenExpnTrnsDivCd());
		this.hashColumns.put("fm_ttl", getFmTtl());
		this.hashColumns.put("fm_sep_amt", getFmSepAmt());
		this.hashColumns.put("fm_chk_assigned", getFmChkAssigned());
		this.hashColumns.put("fm_may_amt", getFmMayAmt());
		this.hashColumns.put("fm_dec_amt", getFmDecAmt());
		this.hashColumns.put("fm_gen_expn_cd", getFmGenExpnCd());
		this.hashColumns.put("fm_rqst_usd_amt", getFmRqstUsdAmt());
		this.hashColumns.put("to_rqst_oct_amt", getToRqstOctAmt());
		this.hashColumns.put("to_sls_ofc_div_cd", getToSlsOfcDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_feb_amt", getFmFebAmt());
		this.hashColumns.put("fm_rqst_mar_amt", getFmRqstMarAmt());
		this.hashColumns.put("to_rqst_may_amt", getToRqstMayAmt());
		this.hashColumns.put("to_gen_expn_rqst_seq", getToGenExpnRqstSeq());
		this.hashColumns.put("to_ofc_lvl1", getToOfcLvl1());
		this.hashColumns.put("to_ofc_lvl2", getToOfcLvl2());
		this.hashColumns.put("to_apr_amt", getToAprAmt());
		this.hashColumns.put("fm_jan_amt", getFmJanAmt());
		this.hashColumns.put("fm_rqst_opin_rmk", getFmRqstOpinRmk());
		this.hashColumns.put("to_rqst_apr_amt", getToRqstAprAmt());
		this.hashColumns.put("fm_gen_expn_calc_bss_desc", getFmGenExpnCalcBssDesc());
		this.hashColumns.put("fm_jun_amt", getFmJunAmt());
		this.hashColumns.put("fm_jul_amt", getFmJulAmt());
		this.hashColumns.put("fm_rqst_may_amt", getFmRqstMayAmt());
		this.hashColumns.put("to_jan_amt", getToJanAmt());
		this.hashColumns.put("fm_apr_amt", getFmAprAmt());
		this.hashColumns.put("to_rqst_feb_amt", getToRqstFebAmt());
		this.hashColumns.put("to_krn_abbr_nm", getToKrnAbbrNm());
		this.hashColumns.put("req_upd_dt", getReqUpdDt());
		this.hashColumns.put("fm_mar_amt", getFmMarAmt());
		this.hashColumns.put("to_oct_amt", getToOctAmt());
		this.hashColumns.put("to_may_amt", getToMayAmt());
		this.hashColumns.put("fm_rqst_ut_val", getFmRqstUtVal());
		this.hashColumns.put("fm_rqst_locl_amt", getFmRqstLoclAmt());
		this.hashColumns.put("fm_gen_expn_trns_div_cd", getFmGenExpnTrnsDivCd());
		this.hashColumns.put("fm_gen_expn_rqst_seq", getFmGenExpnRqstSeq());
		this.hashColumns.put("to_rqst_jan_amt", getToRqstJanAmt());
		this.hashColumns.put("to_feb_amt", getToFebAmt());
		this.hashColumns.put("to_gen_expn_calc_bss_desc", getToGenExpnCalcBssDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_sep_amt", "toSepAmt");
		this.hashFields.put("fm_gen_expn_itm_desc", "fmGenExpnItmDesc");
		this.hashFields.put("fm_nov_amt", "fmNovAmt");
		this.hashFields.put("fm_rqst_dec_amt", "fmRqstDecAmt");
		this.hashFields.put("to_usd_locl_xch_rt", "toUsdLoclXchRt");
		this.hashFields.put("itm_upd_dt", "itmUpdDt");
		this.hashFields.put("to_rqst_nov_amt", "toRqstNovAmt");
		this.hashFields.put("to_gen_expn_cd", "toGenExpnCd");
		this.hashFields.put("fm_rqst_apr_amt", "fmRqstAprAmt");
		this.hashFields.put("fm_rqst_jun_amt", "fmRqstJunAmt");
		this.hashFields.put("to_rqst_jul_amt", "toRqstJulAmt");
		this.hashFields.put("fm_ofc_cd", "fmOfcCd");
		this.hashFields.put("to_tic_cd", "toTicCd");
		this.hashFields.put("fm_ofc_lvl2", "fmOfcLvl2");
		this.hashFields.put("fm_ofc_lvl1", "fmOfcLvl1");
		this.hashFields.put("fm_rqst_aug_amt", "fmRqstAugAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fm_rqst_nov_amt", "fmRqstNovAmt");
		this.hashFields.put("to_rqst_locl_amt", "toRqstLoclAmt");
		this.hashFields.put("fm_aug_amt", "fmAugAmt");
		this.hashFields.put("to_rqst_mar_amt", "toRqstMarAmt");
		this.hashFields.put("fm_rqst_jan_amt", "fmRqstJanAmt");
		this.hashFields.put("fm_rqst_jul_amt", "fmRqstJulAmt");
		this.hashFields.put("fm_rqst_oct_amt", "fmRqstOctAmt");
		this.hashFields.put("fm_gen_expn_itm_no", "fmGenExpnItmNo");
		this.hashFields.put("to_jul_amt", "toJulAmt");
		this.hashFields.put("to_rqst_jun_amt", "toRqstJunAmt");
		this.hashFields.put("to_gen_expn_itm_no", "toGenExpnItmNo");
		this.hashFields.put("to_eng_abbr_nm", "toEngAbbrNm");
		this.hashFields.put("to_ttl", "toTtl");
		this.hashFields.put("to_jun_amt", "toJunAmt");
		this.hashFields.put("fm_tic_cd", "fmTicCd");
		this.hashFields.put("fm_rqst_sep_amt", "fmRqstSepAmt");
		this.hashFields.put("to_rqst_usd_amt", "toRqstUsdAmt");
		this.hashFields.put("fm_krn_abbr_nm", "fmKrnAbbrNm");
		this.hashFields.put("fm_rqst_feb_amt", "fmRqstFebAmt");
		this.hashFields.put("fm_sls_ofc_div_cd", "fmSlsOfcDivCd");
		this.hashFields.put("to_rqst_opin_rmk", "toRqstOpinRmk");
		this.hashFields.put("to_rqst_sep_amt", "toRqstSepAmt");
		this.hashFields.put("to_ofc_cd", "toOfcCd");
		this.hashFields.put("retrieve_yn", "retrieveYn");
		this.hashFields.put("to_aug_amt", "toAugAmt");
		this.hashFields.put("fm_oct_amt", "fmOctAmt");
		this.hashFields.put("to_rqst_aug_amt", "toRqstAugAmt");
		this.hashFields.put("to_chk_assigned", "toChkAssigned");
		this.hashFields.put("to_nov_amt", "toNovAmt");
		this.hashFields.put("to_locl_curr_cd", "toLoclCurrCd");
		this.hashFields.put("fm_usd_locl_xch_rt", "fmUsdLoclXchRt");
		this.hashFields.put("to_mar_amt", "toMarAmt");
		this.hashFields.put("fm_eng_abbr_nm", "fmEngAbbrNm");
		this.hashFields.put("to_rqst_dec_amt", "toRqstDecAmt");
		this.hashFields.put("to_rqst_ut_val", "toRqstUtVal");
		this.hashFields.put("fm_locl_curr_cd", "fmLoclCurrCd");
		this.hashFields.put("to_dec_amt", "toDecAmt");
		this.hashFields.put("to_gen_expn_itm_desc", "toGenExpnItmDesc");
		this.hashFields.put("to_gen_expn_trns_div_cd", "toGenExpnTrnsDivCd");
		this.hashFields.put("fm_ttl", "fmTtl");
		this.hashFields.put("fm_sep_amt", "fmSepAmt");
		this.hashFields.put("fm_chk_assigned", "fmChkAssigned");
		this.hashFields.put("fm_may_amt", "fmMayAmt");
		this.hashFields.put("fm_dec_amt", "fmDecAmt");
		this.hashFields.put("fm_gen_expn_cd", "fmGenExpnCd");
		this.hashFields.put("fm_rqst_usd_amt", "fmRqstUsdAmt");
		this.hashFields.put("to_rqst_oct_amt", "toRqstOctAmt");
		this.hashFields.put("to_sls_ofc_div_cd", "toSlsOfcDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_feb_amt", "fmFebAmt");
		this.hashFields.put("fm_rqst_mar_amt", "fmRqstMarAmt");
		this.hashFields.put("to_rqst_may_amt", "toRqstMayAmt");
		this.hashFields.put("to_gen_expn_rqst_seq", "toGenExpnRqstSeq");
		this.hashFields.put("to_ofc_lvl1", "toOfcLvl1");
		this.hashFields.put("to_ofc_lvl2", "toOfcLvl2");
		this.hashFields.put("to_apr_amt", "toAprAmt");
		this.hashFields.put("fm_jan_amt", "fmJanAmt");
		this.hashFields.put("fm_rqst_opin_rmk", "fmRqstOpinRmk");
		this.hashFields.put("to_rqst_apr_amt", "toRqstAprAmt");
		this.hashFields.put("fm_gen_expn_calc_bss_desc", "fmGenExpnCalcBssDesc");
		this.hashFields.put("fm_jun_amt", "fmJunAmt");
		this.hashFields.put("fm_jul_amt", "fmJulAmt");
		this.hashFields.put("fm_rqst_may_amt", "fmRqstMayAmt");
		this.hashFields.put("to_jan_amt", "toJanAmt");
		this.hashFields.put("fm_apr_amt", "fmAprAmt");
		this.hashFields.put("to_rqst_feb_amt", "toRqstFebAmt");
		this.hashFields.put("to_krn_abbr_nm", "toKrnAbbrNm");
		this.hashFields.put("req_upd_dt", "reqUpdDt");
		this.hashFields.put("fm_mar_amt", "fmMarAmt");
		this.hashFields.put("to_oct_amt", "toOctAmt");
		this.hashFields.put("to_may_amt", "toMayAmt");
		this.hashFields.put("fm_rqst_ut_val", "fmRqstUtVal");
		this.hashFields.put("fm_rqst_locl_amt", "fmRqstLoclAmt");
		this.hashFields.put("fm_gen_expn_trns_div_cd", "fmGenExpnTrnsDivCd");
		this.hashFields.put("fm_gen_expn_rqst_seq", "fmGenExpnRqstSeq");
		this.hashFields.put("to_rqst_jan_amt", "toRqstJanAmt");
		this.hashFields.put("to_feb_amt", "toFebAmt");
		this.hashFields.put("to_gen_expn_calc_bss_desc", "toGenExpnCalcBssDesc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toSepAmt
	 */
	public String getToSepAmt() {
		return this.toSepAmt;
	}
	
	/**
	 * Column Info
	 * @return fmGenExpnItmDesc
	 */
	public String getFmGenExpnItmDesc() {
		return this.fmGenExpnItmDesc;
	}
	
	/**
	 * Column Info
	 * @return fmNovAmt
	 */
	public String getFmNovAmt() {
		return this.fmNovAmt;
	}
	
	/**
	 * Column Info
	 * @return fmRqstDecAmt
	 */
	public String getFmRqstDecAmt() {
		return this.fmRqstDecAmt;
	}
	
	/**
	 * Column Info
	 * @return toUsdLoclXchRt
	 */
	public String getToUsdLoclXchRt() {
		return this.toUsdLoclXchRt;
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
	 * @return toRqstNovAmt
	 */
	public String getToRqstNovAmt() {
		return this.toRqstNovAmt;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnCd
	 */
	public String getToGenExpnCd() {
		return this.toGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @return fmRqstAprAmt
	 */
	public String getFmRqstAprAmt() {
		return this.fmRqstAprAmt;
	}
	
	/**
	 * Column Info
	 * @return fmRqstJunAmt
	 */
	public String getFmRqstJunAmt() {
		return this.fmRqstJunAmt;
	}
	
	/**
	 * Column Info
	 * @return toRqstJulAmt
	 */
	public String getToRqstJulAmt() {
		return this.toRqstJulAmt;
	}
	
	/**
	 * Column Info
	 * @return fmOfcCd
	 */
	public String getFmOfcCd() {
		return this.fmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return toTicCd
	 */
	public String getToTicCd() {
		return this.toTicCd;
	}
	
	/**
	 * Column Info
	 * @return fmOfcLvl2
	 */
	public String getFmOfcLvl2() {
		return this.fmOfcLvl2;
	}
	
	/**
	 * Column Info
	 * @return fmOfcLvl1
	 */
	public String getFmOfcLvl1() {
		return this.fmOfcLvl1;
	}
	
	/**
	 * Column Info
	 * @return fmRqstAugAmt
	 */
	public String getFmRqstAugAmt() {
		return this.fmRqstAugAmt;
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
	 * @return fmRqstNovAmt
	 */
	public String getFmRqstNovAmt() {
		return this.fmRqstNovAmt;
	}
	
	/**
	 * Column Info
	 * @return toRqstLoclAmt
	 */
	public String getToRqstLoclAmt() {
		return this.toRqstLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return fmAugAmt
	 */
	public String getFmAugAmt() {
		return this.fmAugAmt;
	}
	
	/**
	 * Column Info
	 * @return toRqstMarAmt
	 */
	public String getToRqstMarAmt() {
		return this.toRqstMarAmt;
	}
	
	/**
	 * Column Info
	 * @return fmRqstJanAmt
	 */
	public String getFmRqstJanAmt() {
		return this.fmRqstJanAmt;
	}
	
	/**
	 * Column Info
	 * @return fmRqstJulAmt
	 */
	public String getFmRqstJulAmt() {
		return this.fmRqstJulAmt;
	}
	
	/**
	 * Column Info
	 * @return fmRqstOctAmt
	 */
	public String getFmRqstOctAmt() {
		return this.fmRqstOctAmt;
	}
	
	/**
	 * Column Info
	 * @return fmGenExpnItmNo
	 */
	public String getFmGenExpnItmNo() {
		return this.fmGenExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @return toJulAmt
	 */
	public String getToJulAmt() {
		return this.toJulAmt;
	}
	
	/**
	 * Column Info
	 * @return toRqstJunAmt
	 */
	public String getToRqstJunAmt() {
		return this.toRqstJunAmt;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnItmNo
	 */
	public String getToGenExpnItmNo() {
		return this.toGenExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @return toEngAbbrNm
	 */
	public String getToEngAbbrNm() {
		return this.toEngAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return toTtl
	 */
	public String getToTtl() {
		return this.toTtl;
	}
	
	/**
	 * Column Info
	 * @return toJunAmt
	 */
	public String getToJunAmt() {
		return this.toJunAmt;
	}
	
	/**
	 * Column Info
	 * @return fmTicCd
	 */
	public String getFmTicCd() {
		return this.fmTicCd;
	}
	
	/**
	 * Column Info
	 * @return fmRqstSepAmt
	 */
	public String getFmRqstSepAmt() {
		return this.fmRqstSepAmt;
	}
	
	/**
	 * Column Info
	 * @return toRqstUsdAmt
	 */
	public String getToRqstUsdAmt() {
		return this.toRqstUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return fmKrnAbbrNm
	 */
	public String getFmKrnAbbrNm() {
		return this.fmKrnAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return fmRqstFebAmt
	 */
	public String getFmRqstFebAmt() {
		return this.fmRqstFebAmt;
	}
	
	/**
	 * Column Info
	 * @return fmSlsOfcDivCd
	 */
	public String getFmSlsOfcDivCd() {
		return this.fmSlsOfcDivCd;
	}
	
	/**
	 * Column Info
	 * @return toRqstOpinRmk
	 */
	public String getToRqstOpinRmk() {
		return this.toRqstOpinRmk;
	}
	
	/**
	 * Column Info
	 * @return toRqstSepAmt
	 */
	public String getToRqstSepAmt() {
		return this.toRqstSepAmt;
	}
	
	/**
	 * Column Info
	 * @return toOfcCd
	 */
	public String getToOfcCd() {
		return this.toOfcCd;
	}
	
	/**
	 * Column Info
	 * @return retrieveYn
	 */
	public String getRetrieveYn() {
		return this.retrieveYn;
	}
	
	/**
	 * Column Info
	 * @return toAugAmt
	 */
	public String getToAugAmt() {
		return this.toAugAmt;
	}
	
	/**
	 * Column Info
	 * @return fmOctAmt
	 */
	public String getFmOctAmt() {
		return this.fmOctAmt;
	}
	
	/**
	 * Column Info
	 * @return toRqstAugAmt
	 */
	public String getToRqstAugAmt() {
		return this.toRqstAugAmt;
	}
	
	/**
	 * Column Info
	 * @return toChkAssigned
	 */
	public String getToChkAssigned() {
		return this.toChkAssigned;
	}
	
	/**
	 * Column Info
	 * @return toNovAmt
	 */
	public String getToNovAmt() {
		return this.toNovAmt;
	}
	
	/**
	 * Column Info
	 * @return toLoclCurrCd
	 */
	public String getToLoclCurrCd() {
		return this.toLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return fmUsdLoclXchRt
	 */
	public String getFmUsdLoclXchRt() {
		return this.fmUsdLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @return toMarAmt
	 */
	public String getToMarAmt() {
		return this.toMarAmt;
	}
	
	/**
	 * Column Info
	 * @return fmEngAbbrNm
	 */
	public String getFmEngAbbrNm() {
		return this.fmEngAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return toRqstDecAmt
	 */
	public String getToRqstDecAmt() {
		return this.toRqstDecAmt;
	}
	
	/**
	 * Column Info
	 * @return toRqstUtVal
	 */
	public String getToRqstUtVal() {
		return this.toRqstUtVal;
	}
	
	/**
	 * Column Info
	 * @return fmLoclCurrCd
	 */
	public String getFmLoclCurrCd() {
		return this.fmLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return toDecAmt
	 */
	public String getToDecAmt() {
		return this.toDecAmt;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnItmDesc
	 */
	public String getToGenExpnItmDesc() {
		return this.toGenExpnItmDesc;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnTrnsDivCd
	 */
	public String getToGenExpnTrnsDivCd() {
		return this.toGenExpnTrnsDivCd;
	}
	
	/**
	 * Column Info
	 * @return fmTtl
	 */
	public String getFmTtl() {
		return this.fmTtl;
	}
	
	/**
	 * Column Info
	 * @return fmSepAmt
	 */
	public String getFmSepAmt() {
		return this.fmSepAmt;
	}
	
	/**
	 * Column Info
	 * @return fmChkAssigned
	 */
	public String getFmChkAssigned() {
		return this.fmChkAssigned;
	}
	
	/**
	 * Column Info
	 * @return fmMayAmt
	 */
	public String getFmMayAmt() {
		return this.fmMayAmt;
	}
	
	/**
	 * Column Info
	 * @return fmDecAmt
	 */
	public String getFmDecAmt() {
		return this.fmDecAmt;
	}
	
	/**
	 * Column Info
	 * @return fmGenExpnCd
	 */
	public String getFmGenExpnCd() {
		return this.fmGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @return fmRqstUsdAmt
	 */
	public String getFmRqstUsdAmt() {
		return this.fmRqstUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return toRqstOctAmt
	 */
	public String getToRqstOctAmt() {
		return this.toRqstOctAmt;
	}
	
	/**
	 * Column Info
	 * @return toSlsOfcDivCd
	 */
	public String getToSlsOfcDivCd() {
		return this.toSlsOfcDivCd;
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
	 * @return fmFebAmt
	 */
	public String getFmFebAmt() {
		return this.fmFebAmt;
	}
	
	/**
	 * Column Info
	 * @return fmRqstMarAmt
	 */
	public String getFmRqstMarAmt() {
		return this.fmRqstMarAmt;
	}
	
	/**
	 * Column Info
	 * @return toRqstMayAmt
	 */
	public String getToRqstMayAmt() {
		return this.toRqstMayAmt;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnRqstSeq
	 */
	public String getToGenExpnRqstSeq() {
		return this.toGenExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return toOfcLvl1
	 */
	public String getToOfcLvl1() {
		return this.toOfcLvl1;
	}
	
	/**
	 * Column Info
	 * @return toOfcLvl2
	 */
	public String getToOfcLvl2() {
		return this.toOfcLvl2;
	}
	
	/**
	 * Column Info
	 * @return toAprAmt
	 */
	public String getToAprAmt() {
		return this.toAprAmt;
	}
	
	/**
	 * Column Info
	 * @return fmJanAmt
	 */
	public String getFmJanAmt() {
		return this.fmJanAmt;
	}
	
	/**
	 * Column Info
	 * @return fmRqstOpinRmk
	 */
	public String getFmRqstOpinRmk() {
		return this.fmRqstOpinRmk;
	}
	
	/**
	 * Column Info
	 * @return toRqstAprAmt
	 */
	public String getToRqstAprAmt() {
		return this.toRqstAprAmt;
	}
	
	/**
	 * Column Info
	 * @return fmGenExpnCalcBssDesc
	 */
	public String getFmGenExpnCalcBssDesc() {
		return this.fmGenExpnCalcBssDesc;
	}
	
	/**
	 * Column Info
	 * @return fmJunAmt
	 */
	public String getFmJunAmt() {
		return this.fmJunAmt;
	}
	
	/**
	 * Column Info
	 * @return fmJulAmt
	 */
	public String getFmJulAmt() {
		return this.fmJulAmt;
	}
	
	/**
	 * Column Info
	 * @return fmRqstMayAmt
	 */
	public String getFmRqstMayAmt() {
		return this.fmRqstMayAmt;
	}
	
	/**
	 * Column Info
	 * @return toJanAmt
	 */
	public String getToJanAmt() {
		return this.toJanAmt;
	}
	
	/**
	 * Column Info
	 * @return fmAprAmt
	 */
	public String getFmAprAmt() {
		return this.fmAprAmt;
	}
	
	/**
	 * Column Info
	 * @return toRqstFebAmt
	 */
	public String getToRqstFebAmt() {
		return this.toRqstFebAmt;
	}
	
	/**
	 * Column Info
	 * @return toKrnAbbrNm
	 */
	public String getToKrnAbbrNm() {
		return this.toKrnAbbrNm;
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
	 * @return fmMarAmt
	 */
	public String getFmMarAmt() {
		return this.fmMarAmt;
	}
	
	/**
	 * Column Info
	 * @return toOctAmt
	 */
	public String getToOctAmt() {
		return this.toOctAmt;
	}
	
	/**
	 * Column Info
	 * @return toMayAmt
	 */
	public String getToMayAmt() {
		return this.toMayAmt;
	}
	
	/**
	 * Column Info
	 * @return fmRqstUtVal
	 */
	public String getFmRqstUtVal() {
		return this.fmRqstUtVal;
	}
	
	/**
	 * Column Info
	 * @return fmRqstLoclAmt
	 */
	public String getFmRqstLoclAmt() {
		return this.fmRqstLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return fmGenExpnTrnsDivCd
	 */
	public String getFmGenExpnTrnsDivCd() {
		return this.fmGenExpnTrnsDivCd;
	}
	
	/**
	 * Column Info
	 * @return fmGenExpnRqstSeq
	 */
	public String getFmGenExpnRqstSeq() {
		return this.fmGenExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return toRqstJanAmt
	 */
	public String getToRqstJanAmt() {
		return this.toRqstJanAmt;
	}
	
	/**
	 * Column Info
	 * @return toFebAmt
	 */
	public String getToFebAmt() {
		return this.toFebAmt;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnCalcBssDesc
	 */
	public String getToGenExpnCalcBssDesc() {
		return this.toGenExpnCalcBssDesc;
	}
	

	/**
	 * Column Info
	 * @param toSepAmt
	 */
	public void setToSepAmt(String toSepAmt) {
		this.toSepAmt = toSepAmt;
	}
	
	/**
	 * Column Info
	 * @param fmGenExpnItmDesc
	 */
	public void setFmGenExpnItmDesc(String fmGenExpnItmDesc) {
		this.fmGenExpnItmDesc = fmGenExpnItmDesc;
	}
	
	/**
	 * Column Info
	 * @param fmNovAmt
	 */
	public void setFmNovAmt(String fmNovAmt) {
		this.fmNovAmt = fmNovAmt;
	}
	
	/**
	 * Column Info
	 * @param fmRqstDecAmt
	 */
	public void setFmRqstDecAmt(String fmRqstDecAmt) {
		this.fmRqstDecAmt = fmRqstDecAmt;
	}
	
	/**
	 * Column Info
	 * @param toUsdLoclXchRt
	 */
	public void setToUsdLoclXchRt(String toUsdLoclXchRt) {
		this.toUsdLoclXchRt = toUsdLoclXchRt;
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
	 * @param toRqstNovAmt
	 */
	public void setToRqstNovAmt(String toRqstNovAmt) {
		this.toRqstNovAmt = toRqstNovAmt;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnCd
	 */
	public void setToGenExpnCd(String toGenExpnCd) {
		this.toGenExpnCd = toGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @param fmRqstAprAmt
	 */
	public void setFmRqstAprAmt(String fmRqstAprAmt) {
		this.fmRqstAprAmt = fmRqstAprAmt;
	}
	
	/**
	 * Column Info
	 * @param fmRqstJunAmt
	 */
	public void setFmRqstJunAmt(String fmRqstJunAmt) {
		this.fmRqstJunAmt = fmRqstJunAmt;
	}
	
	/**
	 * Column Info
	 * @param toRqstJulAmt
	 */
	public void setToRqstJulAmt(String toRqstJulAmt) {
		this.toRqstJulAmt = toRqstJulAmt;
	}
	
	/**
	 * Column Info
	 * @param fmOfcCd
	 */
	public void setFmOfcCd(String fmOfcCd) {
		this.fmOfcCd = fmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param toTicCd
	 */
	public void setToTicCd(String toTicCd) {
		this.toTicCd = toTicCd;
	}
	
	/**
	 * Column Info
	 * @param fmOfcLvl2
	 */
	public void setFmOfcLvl2(String fmOfcLvl2) {
		this.fmOfcLvl2 = fmOfcLvl2;
	}
	
	/**
	 * Column Info
	 * @param fmOfcLvl1
	 */
	public void setFmOfcLvl1(String fmOfcLvl1) {
		this.fmOfcLvl1 = fmOfcLvl1;
	}
	
	/**
	 * Column Info
	 * @param fmRqstAugAmt
	 */
	public void setFmRqstAugAmt(String fmRqstAugAmt) {
		this.fmRqstAugAmt = fmRqstAugAmt;
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
	 * @param fmRqstNovAmt
	 */
	public void setFmRqstNovAmt(String fmRqstNovAmt) {
		this.fmRqstNovAmt = fmRqstNovAmt;
	}
	
	/**
	 * Column Info
	 * @param toRqstLoclAmt
	 */
	public void setToRqstLoclAmt(String toRqstLoclAmt) {
		this.toRqstLoclAmt = toRqstLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param fmAugAmt
	 */
	public void setFmAugAmt(String fmAugAmt) {
		this.fmAugAmt = fmAugAmt;
	}
	
	/**
	 * Column Info
	 * @param toRqstMarAmt
	 */
	public void setToRqstMarAmt(String toRqstMarAmt) {
		this.toRqstMarAmt = toRqstMarAmt;
	}
	
	/**
	 * Column Info
	 * @param fmRqstJanAmt
	 */
	public void setFmRqstJanAmt(String fmRqstJanAmt) {
		this.fmRqstJanAmt = fmRqstJanAmt;
	}
	
	/**
	 * Column Info
	 * @param fmRqstJulAmt
	 */
	public void setFmRqstJulAmt(String fmRqstJulAmt) {
		this.fmRqstJulAmt = fmRqstJulAmt;
	}
	
	/**
	 * Column Info
	 * @param fmRqstOctAmt
	 */
	public void setFmRqstOctAmt(String fmRqstOctAmt) {
		this.fmRqstOctAmt = fmRqstOctAmt;
	}
	
	/**
	 * Column Info
	 * @param fmGenExpnItmNo
	 */
	public void setFmGenExpnItmNo(String fmGenExpnItmNo) {
		this.fmGenExpnItmNo = fmGenExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @param toJulAmt
	 */
	public void setToJulAmt(String toJulAmt) {
		this.toJulAmt = toJulAmt;
	}
	
	/**
	 * Column Info
	 * @param toRqstJunAmt
	 */
	public void setToRqstJunAmt(String toRqstJunAmt) {
		this.toRqstJunAmt = toRqstJunAmt;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnItmNo
	 */
	public void setToGenExpnItmNo(String toGenExpnItmNo) {
		this.toGenExpnItmNo = toGenExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @param toEngAbbrNm
	 */
	public void setToEngAbbrNm(String toEngAbbrNm) {
		this.toEngAbbrNm = toEngAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param toTtl
	 */
	public void setToTtl(String toTtl) {
		this.toTtl = toTtl;
	}
	
	/**
	 * Column Info
	 * @param toJunAmt
	 */
	public void setToJunAmt(String toJunAmt) {
		this.toJunAmt = toJunAmt;
	}
	
	/**
	 * Column Info
	 * @param fmTicCd
	 */
	public void setFmTicCd(String fmTicCd) {
		this.fmTicCd = fmTicCd;
	}
	
	/**
	 * Column Info
	 * @param fmRqstSepAmt
	 */
	public void setFmRqstSepAmt(String fmRqstSepAmt) {
		this.fmRqstSepAmt = fmRqstSepAmt;
	}
	
	/**
	 * Column Info
	 * @param toRqstUsdAmt
	 */
	public void setToRqstUsdAmt(String toRqstUsdAmt) {
		this.toRqstUsdAmt = toRqstUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param fmKrnAbbrNm
	 */
	public void setFmKrnAbbrNm(String fmKrnAbbrNm) {
		this.fmKrnAbbrNm = fmKrnAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param fmRqstFebAmt
	 */
	public void setFmRqstFebAmt(String fmRqstFebAmt) {
		this.fmRqstFebAmt = fmRqstFebAmt;
	}
	
	/**
	 * Column Info
	 * @param fmSlsOfcDivCd
	 */
	public void setFmSlsOfcDivCd(String fmSlsOfcDivCd) {
		this.fmSlsOfcDivCd = fmSlsOfcDivCd;
	}
	
	/**
	 * Column Info
	 * @param toRqstOpinRmk
	 */
	public void setToRqstOpinRmk(String toRqstOpinRmk) {
		this.toRqstOpinRmk = toRqstOpinRmk;
	}
	
	/**
	 * Column Info
	 * @param toRqstSepAmt
	 */
	public void setToRqstSepAmt(String toRqstSepAmt) {
		this.toRqstSepAmt = toRqstSepAmt;
	}
	
	/**
	 * Column Info
	 * @param toOfcCd
	 */
	public void setToOfcCd(String toOfcCd) {
		this.toOfcCd = toOfcCd;
	}
	
	/**
	 * Column Info
	 * @param retrieveYn
	 */
	public void setRetrieveYn(String retrieveYn) {
		this.retrieveYn = retrieveYn;
	}
	
	/**
	 * Column Info
	 * @param toAugAmt
	 */
	public void setToAugAmt(String toAugAmt) {
		this.toAugAmt = toAugAmt;
	}
	
	/**
	 * Column Info
	 * @param fmOctAmt
	 */
	public void setFmOctAmt(String fmOctAmt) {
		this.fmOctAmt = fmOctAmt;
	}
	
	/**
	 * Column Info
	 * @param toRqstAugAmt
	 */
	public void setToRqstAugAmt(String toRqstAugAmt) {
		this.toRqstAugAmt = toRqstAugAmt;
	}
	
	/**
	 * Column Info
	 * @param toChkAssigned
	 */
	public void setToChkAssigned(String toChkAssigned) {
		this.toChkAssigned = toChkAssigned;
	}
	
	/**
	 * Column Info
	 * @param toNovAmt
	 */
	public void setToNovAmt(String toNovAmt) {
		this.toNovAmt = toNovAmt;
	}
	
	/**
	 * Column Info
	 * @param toLoclCurrCd
	 */
	public void setToLoclCurrCd(String toLoclCurrCd) {
		this.toLoclCurrCd = toLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param fmUsdLoclXchRt
	 */
	public void setFmUsdLoclXchRt(String fmUsdLoclXchRt) {
		this.fmUsdLoclXchRt = fmUsdLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @param toMarAmt
	 */
	public void setToMarAmt(String toMarAmt) {
		this.toMarAmt = toMarAmt;
	}
	
	/**
	 * Column Info
	 * @param fmEngAbbrNm
	 */
	public void setFmEngAbbrNm(String fmEngAbbrNm) {
		this.fmEngAbbrNm = fmEngAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param toRqstDecAmt
	 */
	public void setToRqstDecAmt(String toRqstDecAmt) {
		this.toRqstDecAmt = toRqstDecAmt;
	}
	
	/**
	 * Column Info
	 * @param toRqstUtVal
	 */
	public void setToRqstUtVal(String toRqstUtVal) {
		this.toRqstUtVal = toRqstUtVal;
	}
	
	/**
	 * Column Info
	 * @param fmLoclCurrCd
	 */
	public void setFmLoclCurrCd(String fmLoclCurrCd) {
		this.fmLoclCurrCd = fmLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param toDecAmt
	 */
	public void setToDecAmt(String toDecAmt) {
		this.toDecAmt = toDecAmt;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnItmDesc
	 */
	public void setToGenExpnItmDesc(String toGenExpnItmDesc) {
		this.toGenExpnItmDesc = toGenExpnItmDesc;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnTrnsDivCd
	 */
	public void setToGenExpnTrnsDivCd(String toGenExpnTrnsDivCd) {
		this.toGenExpnTrnsDivCd = toGenExpnTrnsDivCd;
	}
	
	/**
	 * Column Info
	 * @param fmTtl
	 */
	public void setFmTtl(String fmTtl) {
		this.fmTtl = fmTtl;
	}
	
	/**
	 * Column Info
	 * @param fmSepAmt
	 */
	public void setFmSepAmt(String fmSepAmt) {
		this.fmSepAmt = fmSepAmt;
	}
	
	/**
	 * Column Info
	 * @param fmChkAssigned
	 */
	public void setFmChkAssigned(String fmChkAssigned) {
		this.fmChkAssigned = fmChkAssigned;
	}
	
	/**
	 * Column Info
	 * @param fmMayAmt
	 */
	public void setFmMayAmt(String fmMayAmt) {
		this.fmMayAmt = fmMayAmt;
	}
	
	/**
	 * Column Info
	 * @param fmDecAmt
	 */
	public void setFmDecAmt(String fmDecAmt) {
		this.fmDecAmt = fmDecAmt;
	}
	
	/**
	 * Column Info
	 * @param fmGenExpnCd
	 */
	public void setFmGenExpnCd(String fmGenExpnCd) {
		this.fmGenExpnCd = fmGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @param fmRqstUsdAmt
	 */
	public void setFmRqstUsdAmt(String fmRqstUsdAmt) {
		this.fmRqstUsdAmt = fmRqstUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param toRqstOctAmt
	 */
	public void setToRqstOctAmt(String toRqstOctAmt) {
		this.toRqstOctAmt = toRqstOctAmt;
	}
	
	/**
	 * Column Info
	 * @param toSlsOfcDivCd
	 */
	public void setToSlsOfcDivCd(String toSlsOfcDivCd) {
		this.toSlsOfcDivCd = toSlsOfcDivCd;
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
	 * @param fmFebAmt
	 */
	public void setFmFebAmt(String fmFebAmt) {
		this.fmFebAmt = fmFebAmt;
	}
	
	/**
	 * Column Info
	 * @param fmRqstMarAmt
	 */
	public void setFmRqstMarAmt(String fmRqstMarAmt) {
		this.fmRqstMarAmt = fmRqstMarAmt;
	}
	
	/**
	 * Column Info
	 * @param toRqstMayAmt
	 */
	public void setToRqstMayAmt(String toRqstMayAmt) {
		this.toRqstMayAmt = toRqstMayAmt;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnRqstSeq
	 */
	public void setToGenExpnRqstSeq(String toGenExpnRqstSeq) {
		this.toGenExpnRqstSeq = toGenExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param toOfcLvl1
	 */
	public void setToOfcLvl1(String toOfcLvl1) {
		this.toOfcLvl1 = toOfcLvl1;
	}
	
	/**
	 * Column Info
	 * @param toOfcLvl2
	 */
	public void setToOfcLvl2(String toOfcLvl2) {
		this.toOfcLvl2 = toOfcLvl2;
	}
	
	/**
	 * Column Info
	 * @param toAprAmt
	 */
	public void setToAprAmt(String toAprAmt) {
		this.toAprAmt = toAprAmt;
	}
	
	/**
	 * Column Info
	 * @param fmJanAmt
	 */
	public void setFmJanAmt(String fmJanAmt) {
		this.fmJanAmt = fmJanAmt;
	}
	
	/**
	 * Column Info
	 * @param fmRqstOpinRmk
	 */
	public void setFmRqstOpinRmk(String fmRqstOpinRmk) {
		this.fmRqstOpinRmk = fmRqstOpinRmk;
	}
	
	/**
	 * Column Info
	 * @param toRqstAprAmt
	 */
	public void setToRqstAprAmt(String toRqstAprAmt) {
		this.toRqstAprAmt = toRqstAprAmt;
	}
	
	/**
	 * Column Info
	 * @param fmGenExpnCalcBssDesc
	 */
	public void setFmGenExpnCalcBssDesc(String fmGenExpnCalcBssDesc) {
		this.fmGenExpnCalcBssDesc = fmGenExpnCalcBssDesc;
	}
	
	/**
	 * Column Info
	 * @param fmJunAmt
	 */
	public void setFmJunAmt(String fmJunAmt) {
		this.fmJunAmt = fmJunAmt;
	}
	
	/**
	 * Column Info
	 * @param fmJulAmt
	 */
	public void setFmJulAmt(String fmJulAmt) {
		this.fmJulAmt = fmJulAmt;
	}
	
	/**
	 * Column Info
	 * @param fmRqstMayAmt
	 */
	public void setFmRqstMayAmt(String fmRqstMayAmt) {
		this.fmRqstMayAmt = fmRqstMayAmt;
	}
	
	/**
	 * Column Info
	 * @param toJanAmt
	 */
	public void setToJanAmt(String toJanAmt) {
		this.toJanAmt = toJanAmt;
	}
	
	/**
	 * Column Info
	 * @param fmAprAmt
	 */
	public void setFmAprAmt(String fmAprAmt) {
		this.fmAprAmt = fmAprAmt;
	}
	
	/**
	 * Column Info
	 * @param toRqstFebAmt
	 */
	public void setToRqstFebAmt(String toRqstFebAmt) {
		this.toRqstFebAmt = toRqstFebAmt;
	}
	
	/**
	 * Column Info
	 * @param toKrnAbbrNm
	 */
	public void setToKrnAbbrNm(String toKrnAbbrNm) {
		this.toKrnAbbrNm = toKrnAbbrNm;
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
	 * @param fmMarAmt
	 */
	public void setFmMarAmt(String fmMarAmt) {
		this.fmMarAmt = fmMarAmt;
	}
	
	/**
	 * Column Info
	 * @param toOctAmt
	 */
	public void setToOctAmt(String toOctAmt) {
		this.toOctAmt = toOctAmt;
	}
	
	/**
	 * Column Info
	 * @param toMayAmt
	 */
	public void setToMayAmt(String toMayAmt) {
		this.toMayAmt = toMayAmt;
	}
	
	/**
	 * Column Info
	 * @param fmRqstUtVal
	 */
	public void setFmRqstUtVal(String fmRqstUtVal) {
		this.fmRqstUtVal = fmRqstUtVal;
	}
	
	/**
	 * Column Info
	 * @param fmRqstLoclAmt
	 */
	public void setFmRqstLoclAmt(String fmRqstLoclAmt) {
		this.fmRqstLoclAmt = fmRqstLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param fmGenExpnTrnsDivCd
	 */
	public void setFmGenExpnTrnsDivCd(String fmGenExpnTrnsDivCd) {
		this.fmGenExpnTrnsDivCd = fmGenExpnTrnsDivCd;
	}
	
	/**
	 * Column Info
	 * @param fmGenExpnRqstSeq
	 */
	public void setFmGenExpnRqstSeq(String fmGenExpnRqstSeq) {
		this.fmGenExpnRqstSeq = fmGenExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param toRqstJanAmt
	 */
	public void setToRqstJanAmt(String toRqstJanAmt) {
		this.toRqstJanAmt = toRqstJanAmt;
	}
	
	/**
	 * Column Info
	 * @param toFebAmt
	 */
	public void setToFebAmt(String toFebAmt) {
		this.toFebAmt = toFebAmt;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnCalcBssDesc
	 */
	public void setToGenExpnCalcBssDesc(String toGenExpnCalcBssDesc) {
		this.toGenExpnCalcBssDesc = toGenExpnCalcBssDesc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToSepAmt(JSPUtil.getParameter(request, "to_sep_amt", ""));
		setFmGenExpnItmDesc(JSPUtil.getParameter(request, "fm_gen_expn_itm_desc", ""));
		setFmNovAmt(JSPUtil.getParameter(request, "fm_nov_amt", ""));
		setFmRqstDecAmt(JSPUtil.getParameter(request, "fm_rqst_dec_amt", ""));
		setToUsdLoclXchRt(JSPUtil.getParameter(request, "to_usd_locl_xch_rt", ""));
		setItmUpdDt(JSPUtil.getParameter(request, "itm_upd_dt", ""));
		setToRqstNovAmt(JSPUtil.getParameter(request, "to_rqst_nov_amt", ""));
		setToGenExpnCd(JSPUtil.getParameter(request, "to_gen_expn_cd", ""));
		setFmRqstAprAmt(JSPUtil.getParameter(request, "fm_rqst_apr_amt", ""));
		setFmRqstJunAmt(JSPUtil.getParameter(request, "fm_rqst_jun_amt", ""));
		setToRqstJulAmt(JSPUtil.getParameter(request, "to_rqst_jul_amt", ""));
		setFmOfcCd(JSPUtil.getParameter(request, "fm_ofc_cd", ""));
		setToTicCd(JSPUtil.getParameter(request, "to_tic_cd", ""));
		setFmOfcLvl2(JSPUtil.getParameter(request, "fm_ofc_lvl2", ""));
		setFmOfcLvl1(JSPUtil.getParameter(request, "fm_ofc_lvl1", ""));
		setFmRqstAugAmt(JSPUtil.getParameter(request, "fm_rqst_aug_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFmRqstNovAmt(JSPUtil.getParameter(request, "fm_rqst_nov_amt", ""));
		setToRqstLoclAmt(JSPUtil.getParameter(request, "to_rqst_locl_amt", ""));
		setFmAugAmt(JSPUtil.getParameter(request, "fm_aug_amt", ""));
		setToRqstMarAmt(JSPUtil.getParameter(request, "to_rqst_mar_amt", ""));
		setFmRqstJanAmt(JSPUtil.getParameter(request, "fm_rqst_jan_amt", ""));
		setFmRqstJulAmt(JSPUtil.getParameter(request, "fm_rqst_jul_amt", ""));
		setFmRqstOctAmt(JSPUtil.getParameter(request, "fm_rqst_oct_amt", ""));
		setFmGenExpnItmNo(JSPUtil.getParameter(request, "fm_gen_expn_itm_no", ""));
		setToJulAmt(JSPUtil.getParameter(request, "to_jul_amt", ""));
		setToRqstJunAmt(JSPUtil.getParameter(request, "to_rqst_jun_amt", ""));
		setToGenExpnItmNo(JSPUtil.getParameter(request, "to_gen_expn_itm_no", ""));
		setToEngAbbrNm(JSPUtil.getParameter(request, "to_eng_abbr_nm", ""));
		setToTtl(JSPUtil.getParameter(request, "to_ttl", ""));
		setToJunAmt(JSPUtil.getParameter(request, "to_jun_amt", ""));
		setFmTicCd(JSPUtil.getParameter(request, "fm_tic_cd", ""));
		setFmRqstSepAmt(JSPUtil.getParameter(request, "fm_rqst_sep_amt", ""));
		setToRqstUsdAmt(JSPUtil.getParameter(request, "to_rqst_usd_amt", ""));
		setFmKrnAbbrNm(JSPUtil.getParameter(request, "fm_krn_abbr_nm", ""));
		setFmRqstFebAmt(JSPUtil.getParameter(request, "fm_rqst_feb_amt", ""));
		setFmSlsOfcDivCd(JSPUtil.getParameter(request, "fm_sls_ofc_div_cd", ""));
		setToRqstOpinRmk(JSPUtil.getParameter(request, "to_rqst_opin_rmk", ""));
		setToRqstSepAmt(JSPUtil.getParameter(request, "to_rqst_sep_amt", ""));
		setToOfcCd(JSPUtil.getParameter(request, "to_ofc_cd", ""));
		setRetrieveYn(JSPUtil.getParameter(request, "retrieve_yn", ""));
		setToAugAmt(JSPUtil.getParameter(request, "to_aug_amt", ""));
		setFmOctAmt(JSPUtil.getParameter(request, "fm_oct_amt", ""));
		setToRqstAugAmt(JSPUtil.getParameter(request, "to_rqst_aug_amt", ""));
		setToChkAssigned(JSPUtil.getParameter(request, "to_chk_assigned", ""));
		setToNovAmt(JSPUtil.getParameter(request, "to_nov_amt", ""));
		setToLoclCurrCd(JSPUtil.getParameter(request, "to_locl_curr_cd", ""));
		setFmUsdLoclXchRt(JSPUtil.getParameter(request, "fm_usd_locl_xch_rt", ""));
		setToMarAmt(JSPUtil.getParameter(request, "to_mar_amt", ""));
		setFmEngAbbrNm(JSPUtil.getParameter(request, "fm_eng_abbr_nm", ""));
		setToRqstDecAmt(JSPUtil.getParameter(request, "to_rqst_dec_amt", ""));
		setToRqstUtVal(JSPUtil.getParameter(request, "to_rqst_ut_val", ""));
		setFmLoclCurrCd(JSPUtil.getParameter(request, "fm_locl_curr_cd", ""));
		setToDecAmt(JSPUtil.getParameter(request, "to_dec_amt", ""));
		setToGenExpnItmDesc(JSPUtil.getParameter(request, "to_gen_expn_itm_desc", ""));
		setToGenExpnTrnsDivCd(JSPUtil.getParameter(request, "to_gen_expn_trns_div_cd", ""));
		setFmTtl(JSPUtil.getParameter(request, "fm_ttl", ""));
		setFmSepAmt(JSPUtil.getParameter(request, "fm_sep_amt", ""));
		setFmChkAssigned(JSPUtil.getParameter(request, "fm_chk_assigned", ""));
		setFmMayAmt(JSPUtil.getParameter(request, "fm_may_amt", ""));
		setFmDecAmt(JSPUtil.getParameter(request, "fm_dec_amt", ""));
		setFmGenExpnCd(JSPUtil.getParameter(request, "fm_gen_expn_cd", ""));
		setFmRqstUsdAmt(JSPUtil.getParameter(request, "fm_rqst_usd_amt", ""));
		setToRqstOctAmt(JSPUtil.getParameter(request, "to_rqst_oct_amt", ""));
		setToSlsOfcDivCd(JSPUtil.getParameter(request, "to_sls_ofc_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmFebAmt(JSPUtil.getParameter(request, "fm_feb_amt", ""));
		setFmRqstMarAmt(JSPUtil.getParameter(request, "fm_rqst_mar_amt", ""));
		setToRqstMayAmt(JSPUtil.getParameter(request, "to_rqst_may_amt", ""));
		setToGenExpnRqstSeq(JSPUtil.getParameter(request, "to_gen_expn_rqst_seq", ""));
		setToOfcLvl1(JSPUtil.getParameter(request, "to_ofc_lvl1", ""));
		setToOfcLvl2(JSPUtil.getParameter(request, "to_ofc_lvl2", ""));
		setToAprAmt(JSPUtil.getParameter(request, "to_apr_amt", ""));
		setFmJanAmt(JSPUtil.getParameter(request, "fm_jan_amt", ""));
		setFmRqstOpinRmk(JSPUtil.getParameter(request, "fm_rqst_opin_rmk", ""));
		setToRqstAprAmt(JSPUtil.getParameter(request, "to_rqst_apr_amt", ""));
		setFmGenExpnCalcBssDesc(JSPUtil.getParameter(request, "fm_gen_expn_calc_bss_desc", ""));
		setFmJunAmt(JSPUtil.getParameter(request, "fm_jun_amt", ""));
		setFmJulAmt(JSPUtil.getParameter(request, "fm_jul_amt", ""));
		setFmRqstMayAmt(JSPUtil.getParameter(request, "fm_rqst_may_amt", ""));
		setToJanAmt(JSPUtil.getParameter(request, "to_jan_amt", ""));
		setFmAprAmt(JSPUtil.getParameter(request, "fm_apr_amt", ""));
		setToRqstFebAmt(JSPUtil.getParameter(request, "to_rqst_feb_amt", ""));
		setToKrnAbbrNm(JSPUtil.getParameter(request, "to_krn_abbr_nm", ""));
		setReqUpdDt(JSPUtil.getParameter(request, "req_upd_dt", ""));
		setFmMarAmt(JSPUtil.getParameter(request, "fm_mar_amt", ""));
		setToOctAmt(JSPUtil.getParameter(request, "to_oct_amt", ""));
		setToMayAmt(JSPUtil.getParameter(request, "to_may_amt", ""));
		setFmRqstUtVal(JSPUtil.getParameter(request, "fm_rqst_ut_val", ""));
		setFmRqstLoclAmt(JSPUtil.getParameter(request, "fm_rqst_locl_amt", ""));
		setFmGenExpnTrnsDivCd(JSPUtil.getParameter(request, "fm_gen_expn_trns_div_cd", ""));
		setFmGenExpnRqstSeq(JSPUtil.getParameter(request, "fm_gen_expn_rqst_seq", ""));
		setToRqstJanAmt(JSPUtil.getParameter(request, "to_rqst_jan_amt", ""));
		setToFebAmt(JSPUtil.getParameter(request, "to_feb_amt", ""));
		setToGenExpnCalcBssDesc(JSPUtil.getParameter(request, "to_gen_expn_calc_bss_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TransferVO[]
	 */
	public TransferVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TransferVO[]
	 */
	public TransferVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TransferVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toSepAmt = (JSPUtil.getParameter(request, prefix	+ "to_sep_amt", length));
			String[] fmGenExpnItmDesc = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_itm_desc", length));
			String[] fmNovAmt = (JSPUtil.getParameter(request, prefix	+ "fm_nov_amt", length));
			String[] fmRqstDecAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_dec_amt", length));
			String[] toUsdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "to_usd_locl_xch_rt", length));
			String[] itmUpdDt = (JSPUtil.getParameter(request, prefix	+ "itm_upd_dt", length));
			String[] toRqstNovAmt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_nov_amt", length));
			String[] toGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_cd", length));
			String[] fmRqstAprAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_apr_amt", length));
			String[] fmRqstJunAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_jun_amt", length));
			String[] toRqstJulAmt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_jul_amt", length));
			String[] fmOfcCd = (JSPUtil.getParameter(request, prefix	+ "fm_ofc_cd", length));
			String[] toTicCd = (JSPUtil.getParameter(request, prefix	+ "to_tic_cd", length));
			String[] fmOfcLvl2 = (JSPUtil.getParameter(request, prefix	+ "fm_ofc_lvl2", length));
			String[] fmOfcLvl1 = (JSPUtil.getParameter(request, prefix	+ "fm_ofc_lvl1", length));
			String[] fmRqstAugAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_aug_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmRqstNovAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_nov_amt", length));
			String[] toRqstLoclAmt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_locl_amt", length));
			String[] fmAugAmt = (JSPUtil.getParameter(request, prefix	+ "fm_aug_amt", length));
			String[] toRqstMarAmt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_mar_amt", length));
			String[] fmRqstJanAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_jan_amt", length));
			String[] fmRqstJulAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_jul_amt", length));
			String[] fmRqstOctAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_oct_amt", length));
			String[] fmGenExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_itm_no", length));
			String[] toJulAmt = (JSPUtil.getParameter(request, prefix	+ "to_jul_amt", length));
			String[] toRqstJunAmt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_jun_amt", length));
			String[] toGenExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_itm_no", length));
			String[] toEngAbbrNm = (JSPUtil.getParameter(request, prefix	+ "to_eng_abbr_nm", length));
			String[] toTtl = (JSPUtil.getParameter(request, prefix	+ "to_ttl", length));
			String[] toJunAmt = (JSPUtil.getParameter(request, prefix	+ "to_jun_amt", length));
			String[] fmTicCd = (JSPUtil.getParameter(request, prefix	+ "fm_tic_cd", length));
			String[] fmRqstSepAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_sep_amt", length));
			String[] toRqstUsdAmt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_usd_amt", length));
			String[] fmKrnAbbrNm = (JSPUtil.getParameter(request, prefix	+ "fm_krn_abbr_nm", length));
			String[] fmRqstFebAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_feb_amt", length));
			String[] fmSlsOfcDivCd = (JSPUtil.getParameter(request, prefix	+ "fm_sls_ofc_div_cd", length));
			String[] toRqstOpinRmk = (JSPUtil.getParameter(request, prefix	+ "to_rqst_opin_rmk", length));
			String[] toRqstSepAmt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_sep_amt", length));
			String[] toOfcCd = (JSPUtil.getParameter(request, prefix	+ "to_ofc_cd", length));
			String[] retrieveYn = (JSPUtil.getParameter(request, prefix	+ "retrieve_yn", length));
			String[] toAugAmt = (JSPUtil.getParameter(request, prefix	+ "to_aug_amt", length));
			String[] fmOctAmt = (JSPUtil.getParameter(request, prefix	+ "fm_oct_amt", length));
			String[] toRqstAugAmt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_aug_amt", length));
			String[] toChkAssigned = (JSPUtil.getParameter(request, prefix	+ "to_chk_assigned", length));
			String[] toNovAmt = (JSPUtil.getParameter(request, prefix	+ "to_nov_amt", length));
			String[] toLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "to_locl_curr_cd", length));
			String[] fmUsdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "fm_usd_locl_xch_rt", length));
			String[] toMarAmt = (JSPUtil.getParameter(request, prefix	+ "to_mar_amt", length));
			String[] fmEngAbbrNm = (JSPUtil.getParameter(request, prefix	+ "fm_eng_abbr_nm", length));
			String[] toRqstDecAmt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_dec_amt", length));
			String[] toRqstUtVal = (JSPUtil.getParameter(request, prefix	+ "to_rqst_ut_val", length));
			String[] fmLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "fm_locl_curr_cd", length));
			String[] toDecAmt = (JSPUtil.getParameter(request, prefix	+ "to_dec_amt", length));
			String[] toGenExpnItmDesc = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_itm_desc", length));
			String[] toGenExpnTrnsDivCd = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_trns_div_cd", length));
			String[] fmTtl = (JSPUtil.getParameter(request, prefix	+ "fm_ttl", length));
			String[] fmSepAmt = (JSPUtil.getParameter(request, prefix	+ "fm_sep_amt", length));
			String[] fmChkAssigned = (JSPUtil.getParameter(request, prefix	+ "fm_chk_assigned", length));
			String[] fmMayAmt = (JSPUtil.getParameter(request, prefix	+ "fm_may_amt", length));
			String[] fmDecAmt = (JSPUtil.getParameter(request, prefix	+ "fm_dec_amt", length));
			String[] fmGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_cd", length));
			String[] fmRqstUsdAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_usd_amt", length));
			String[] toRqstOctAmt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_oct_amt", length));
			String[] toSlsOfcDivCd = (JSPUtil.getParameter(request, prefix	+ "to_sls_ofc_div_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmFebAmt = (JSPUtil.getParameter(request, prefix	+ "fm_feb_amt", length));
			String[] fmRqstMarAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_mar_amt", length));
			String[] toRqstMayAmt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_may_amt", length));
			String[] toGenExpnRqstSeq = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_rqst_seq", length));
			String[] toOfcLvl1 = (JSPUtil.getParameter(request, prefix	+ "to_ofc_lvl1", length));
			String[] toOfcLvl2 = (JSPUtil.getParameter(request, prefix	+ "to_ofc_lvl2", length));
			String[] toAprAmt = (JSPUtil.getParameter(request, prefix	+ "to_apr_amt", length));
			String[] fmJanAmt = (JSPUtil.getParameter(request, prefix	+ "fm_jan_amt", length));
			String[] fmRqstOpinRmk = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_opin_rmk", length));
			String[] toRqstAprAmt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_apr_amt", length));
			String[] fmGenExpnCalcBssDesc = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_calc_bss_desc", length));
			String[] fmJunAmt = (JSPUtil.getParameter(request, prefix	+ "fm_jun_amt", length));
			String[] fmJulAmt = (JSPUtil.getParameter(request, prefix	+ "fm_jul_amt", length));
			String[] fmRqstMayAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_may_amt", length));
			String[] toJanAmt = (JSPUtil.getParameter(request, prefix	+ "to_jan_amt", length));
			String[] fmAprAmt = (JSPUtil.getParameter(request, prefix	+ "fm_apr_amt", length));
			String[] toRqstFebAmt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_feb_amt", length));
			String[] toKrnAbbrNm = (JSPUtil.getParameter(request, prefix	+ "to_krn_abbr_nm", length));
			String[] reqUpdDt = (JSPUtil.getParameter(request, prefix	+ "req_upd_dt", length));
			String[] fmMarAmt = (JSPUtil.getParameter(request, prefix	+ "fm_mar_amt", length));
			String[] toOctAmt = (JSPUtil.getParameter(request, prefix	+ "to_oct_amt", length));
			String[] toMayAmt = (JSPUtil.getParameter(request, prefix	+ "to_may_amt", length));
			String[] fmRqstUtVal = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_ut_val", length));
			String[] fmRqstLoclAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_locl_amt", length));
			String[] fmGenExpnTrnsDivCd = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_trns_div_cd", length));
			String[] fmGenExpnRqstSeq = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_rqst_seq", length));
			String[] toRqstJanAmt = (JSPUtil.getParameter(request, prefix	+ "to_rqst_jan_amt", length));
			String[] toFebAmt = (JSPUtil.getParameter(request, prefix	+ "to_feb_amt", length));
			String[] toGenExpnCalcBssDesc = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_calc_bss_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new TransferVO();
				if (toSepAmt[i] != null)
					model.setToSepAmt(toSepAmt[i]);
				if (fmGenExpnItmDesc[i] != null)
					model.setFmGenExpnItmDesc(fmGenExpnItmDesc[i]);
				if (fmNovAmt[i] != null)
					model.setFmNovAmt(fmNovAmt[i]);
				if (fmRqstDecAmt[i] != null)
					model.setFmRqstDecAmt(fmRqstDecAmt[i]);
				if (toUsdLoclXchRt[i] != null)
					model.setToUsdLoclXchRt(toUsdLoclXchRt[i]);
				if (itmUpdDt[i] != null)
					model.setItmUpdDt(itmUpdDt[i]);
				if (toRqstNovAmt[i] != null)
					model.setToRqstNovAmt(toRqstNovAmt[i]);
				if (toGenExpnCd[i] != null)
					model.setToGenExpnCd(toGenExpnCd[i]);
				if (fmRqstAprAmt[i] != null)
					model.setFmRqstAprAmt(fmRqstAprAmt[i]);
				if (fmRqstJunAmt[i] != null)
					model.setFmRqstJunAmt(fmRqstJunAmt[i]);
				if (toRqstJulAmt[i] != null)
					model.setToRqstJulAmt(toRqstJulAmt[i]);
				if (fmOfcCd[i] != null)
					model.setFmOfcCd(fmOfcCd[i]);
				if (toTicCd[i] != null)
					model.setToTicCd(toTicCd[i]);
				if (fmOfcLvl2[i] != null)
					model.setFmOfcLvl2(fmOfcLvl2[i]);
				if (fmOfcLvl1[i] != null)
					model.setFmOfcLvl1(fmOfcLvl1[i]);
				if (fmRqstAugAmt[i] != null)
					model.setFmRqstAugAmt(fmRqstAugAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmRqstNovAmt[i] != null)
					model.setFmRqstNovAmt(fmRqstNovAmt[i]);
				if (toRqstLoclAmt[i] != null)
					model.setToRqstLoclAmt(toRqstLoclAmt[i]);
				if (fmAugAmt[i] != null)
					model.setFmAugAmt(fmAugAmt[i]);
				if (toRqstMarAmt[i] != null)
					model.setToRqstMarAmt(toRqstMarAmt[i]);
				if (fmRqstJanAmt[i] != null)
					model.setFmRqstJanAmt(fmRqstJanAmt[i]);
				if (fmRqstJulAmt[i] != null)
					model.setFmRqstJulAmt(fmRqstJulAmt[i]);
				if (fmRqstOctAmt[i] != null)
					model.setFmRqstOctAmt(fmRqstOctAmt[i]);
				if (fmGenExpnItmNo[i] != null)
					model.setFmGenExpnItmNo(fmGenExpnItmNo[i]);
				if (toJulAmt[i] != null)
					model.setToJulAmt(toJulAmt[i]);
				if (toRqstJunAmt[i] != null)
					model.setToRqstJunAmt(toRqstJunAmt[i]);
				if (toGenExpnItmNo[i] != null)
					model.setToGenExpnItmNo(toGenExpnItmNo[i]);
				if (toEngAbbrNm[i] != null)
					model.setToEngAbbrNm(toEngAbbrNm[i]);
				if (toTtl[i] != null)
					model.setToTtl(toTtl[i]);
				if (toJunAmt[i] != null)
					model.setToJunAmt(toJunAmt[i]);
				if (fmTicCd[i] != null)
					model.setFmTicCd(fmTicCd[i]);
				if (fmRqstSepAmt[i] != null)
					model.setFmRqstSepAmt(fmRqstSepAmt[i]);
				if (toRqstUsdAmt[i] != null)
					model.setToRqstUsdAmt(toRqstUsdAmt[i]);
				if (fmKrnAbbrNm[i] != null)
					model.setFmKrnAbbrNm(fmKrnAbbrNm[i]);
				if (fmRqstFebAmt[i] != null)
					model.setFmRqstFebAmt(fmRqstFebAmt[i]);
				if (fmSlsOfcDivCd[i] != null)
					model.setFmSlsOfcDivCd(fmSlsOfcDivCd[i]);
				if (toRqstOpinRmk[i] != null)
					model.setToRqstOpinRmk(toRqstOpinRmk[i]);
				if (toRqstSepAmt[i] != null)
					model.setToRqstSepAmt(toRqstSepAmt[i]);
				if (toOfcCd[i] != null)
					model.setToOfcCd(toOfcCd[i]);
				if (retrieveYn[i] != null)
					model.setRetrieveYn(retrieveYn[i]);
				if (toAugAmt[i] != null)
					model.setToAugAmt(toAugAmt[i]);
				if (fmOctAmt[i] != null)
					model.setFmOctAmt(fmOctAmt[i]);
				if (toRqstAugAmt[i] != null)
					model.setToRqstAugAmt(toRqstAugAmt[i]);
				if (toChkAssigned[i] != null)
					model.setToChkAssigned(toChkAssigned[i]);
				if (toNovAmt[i] != null)
					model.setToNovAmt(toNovAmt[i]);
				if (toLoclCurrCd[i] != null)
					model.setToLoclCurrCd(toLoclCurrCd[i]);
				if (fmUsdLoclXchRt[i] != null)
					model.setFmUsdLoclXchRt(fmUsdLoclXchRt[i]);
				if (toMarAmt[i] != null)
					model.setToMarAmt(toMarAmt[i]);
				if (fmEngAbbrNm[i] != null)
					model.setFmEngAbbrNm(fmEngAbbrNm[i]);
				if (toRqstDecAmt[i] != null)
					model.setToRqstDecAmt(toRqstDecAmt[i]);
				if (toRqstUtVal[i] != null)
					model.setToRqstUtVal(toRqstUtVal[i]);
				if (fmLoclCurrCd[i] != null)
					model.setFmLoclCurrCd(fmLoclCurrCd[i]);
				if (toDecAmt[i] != null)
					model.setToDecAmt(toDecAmt[i]);
				if (toGenExpnItmDesc[i] != null)
					model.setToGenExpnItmDesc(toGenExpnItmDesc[i]);
				if (toGenExpnTrnsDivCd[i] != null)
					model.setToGenExpnTrnsDivCd(toGenExpnTrnsDivCd[i]);
				if (fmTtl[i] != null)
					model.setFmTtl(fmTtl[i]);
				if (fmSepAmt[i] != null)
					model.setFmSepAmt(fmSepAmt[i]);
				if (fmChkAssigned[i] != null)
					model.setFmChkAssigned(fmChkAssigned[i]);
				if (fmMayAmt[i] != null)
					model.setFmMayAmt(fmMayAmt[i]);
				if (fmDecAmt[i] != null)
					model.setFmDecAmt(fmDecAmt[i]);
				if (fmGenExpnCd[i] != null)
					model.setFmGenExpnCd(fmGenExpnCd[i]);
				if (fmRqstUsdAmt[i] != null)
					model.setFmRqstUsdAmt(fmRqstUsdAmt[i]);
				if (toRqstOctAmt[i] != null)
					model.setToRqstOctAmt(toRqstOctAmt[i]);
				if (toSlsOfcDivCd[i] != null)
					model.setToSlsOfcDivCd(toSlsOfcDivCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmFebAmt[i] != null)
					model.setFmFebAmt(fmFebAmt[i]);
				if (fmRqstMarAmt[i] != null)
					model.setFmRqstMarAmt(fmRqstMarAmt[i]);
				if (toRqstMayAmt[i] != null)
					model.setToRqstMayAmt(toRqstMayAmt[i]);
				if (toGenExpnRqstSeq[i] != null)
					model.setToGenExpnRqstSeq(toGenExpnRqstSeq[i]);
				if (toOfcLvl1[i] != null)
					model.setToOfcLvl1(toOfcLvl1[i]);
				if (toOfcLvl2[i] != null)
					model.setToOfcLvl2(toOfcLvl2[i]);
				if (toAprAmt[i] != null)
					model.setToAprAmt(toAprAmt[i]);
				if (fmJanAmt[i] != null)
					model.setFmJanAmt(fmJanAmt[i]);
				if (fmRqstOpinRmk[i] != null)
					model.setFmRqstOpinRmk(fmRqstOpinRmk[i]);
				if (toRqstAprAmt[i] != null)
					model.setToRqstAprAmt(toRqstAprAmt[i]);
				if (fmGenExpnCalcBssDesc[i] != null)
					model.setFmGenExpnCalcBssDesc(fmGenExpnCalcBssDesc[i]);
				if (fmJunAmt[i] != null)
					model.setFmJunAmt(fmJunAmt[i]);
				if (fmJulAmt[i] != null)
					model.setFmJulAmt(fmJulAmt[i]);
				if (fmRqstMayAmt[i] != null)
					model.setFmRqstMayAmt(fmRqstMayAmt[i]);
				if (toJanAmt[i] != null)
					model.setToJanAmt(toJanAmt[i]);
				if (fmAprAmt[i] != null)
					model.setFmAprAmt(fmAprAmt[i]);
				if (toRqstFebAmt[i] != null)
					model.setToRqstFebAmt(toRqstFebAmt[i]);
				if (toKrnAbbrNm[i] != null)
					model.setToKrnAbbrNm(toKrnAbbrNm[i]);
				if (reqUpdDt[i] != null)
					model.setReqUpdDt(reqUpdDt[i]);
				if (fmMarAmt[i] != null)
					model.setFmMarAmt(fmMarAmt[i]);
				if (toOctAmt[i] != null)
					model.setToOctAmt(toOctAmt[i]);
				if (toMayAmt[i] != null)
					model.setToMayAmt(toMayAmt[i]);
				if (fmRqstUtVal[i] != null)
					model.setFmRqstUtVal(fmRqstUtVal[i]);
				if (fmRqstLoclAmt[i] != null)
					model.setFmRqstLoclAmt(fmRqstLoclAmt[i]);
				if (fmGenExpnTrnsDivCd[i] != null)
					model.setFmGenExpnTrnsDivCd(fmGenExpnTrnsDivCd[i]);
				if (fmGenExpnRqstSeq[i] != null)
					model.setFmGenExpnRqstSeq(fmGenExpnRqstSeq[i]);
				if (toRqstJanAmt[i] != null)
					model.setToRqstJanAmt(toRqstJanAmt[i]);
				if (toFebAmt[i] != null)
					model.setToFebAmt(toFebAmt[i]);
				if (toGenExpnCalcBssDesc[i] != null)
					model.setToGenExpnCalcBssDesc(toGenExpnCalcBssDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTransferVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TransferVO[]
	 */
	public TransferVO[] getTransferVOs(){
		TransferVO[] vos = (TransferVO[])models.toArray(new TransferVO[models.size()]);
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
		this.toSepAmt = this.toSepAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnItmDesc = this.fmGenExpnItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNovAmt = this.fmNovAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstDecAmt = this.fmRqstDecAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toUsdLoclXchRt = this.toUsdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmUpdDt = this.itmUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstNovAmt = this.toRqstNovAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnCd = this.toGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstAprAmt = this.fmRqstAprAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstJunAmt = this.fmRqstJunAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstJulAmt = this.toRqstJulAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmOfcCd = this.fmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTicCd = this.toTicCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmOfcLvl2 = this.fmOfcLvl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmOfcLvl1 = this.fmOfcLvl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstAugAmt = this.fmRqstAugAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstNovAmt = this.fmRqstNovAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstLoclAmt = this.toRqstLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAugAmt = this.fmAugAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstMarAmt = this.toRqstMarAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstJanAmt = this.fmRqstJanAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstJulAmt = this.fmRqstJulAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstOctAmt = this.fmRqstOctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnItmNo = this.fmGenExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toJulAmt = this.toJulAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstJunAmt = this.toRqstJunAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnItmNo = this.toGenExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEngAbbrNm = this.toEngAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTtl = this.toTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toJunAmt = this.toJunAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTicCd = this.fmTicCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstSepAmt = this.fmRqstSepAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstUsdAmt = this.toRqstUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmKrnAbbrNm = this.fmKrnAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstFebAmt = this.fmRqstFebAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSlsOfcDivCd = this.fmSlsOfcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstOpinRmk = this.toRqstOpinRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstSepAmt = this.toRqstSepAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOfcCd = this.toOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.retrieveYn = this.retrieveYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAugAmt = this.toAugAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmOctAmt = this.fmOctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstAugAmt = this.toRqstAugAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toChkAssigned = this.toChkAssigned .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNovAmt = this.toNovAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLoclCurrCd = this.toLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmUsdLoclXchRt = this.fmUsdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMarAmt = this.toMarAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEngAbbrNm = this.fmEngAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstDecAmt = this.toRqstDecAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstUtVal = this.toRqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLoclCurrCd = this.fmLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDecAmt = this.toDecAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnItmDesc = this.toGenExpnItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnTrnsDivCd = this.toGenExpnTrnsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTtl = this.fmTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSepAmt = this.fmSepAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmChkAssigned = this.fmChkAssigned .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMayAmt = this.fmMayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDecAmt = this.fmDecAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnCd = this.fmGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstUsdAmt = this.fmRqstUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstOctAmt = this.toRqstOctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSlsOfcDivCd = this.toSlsOfcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmFebAmt = this.fmFebAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstMarAmt = this.fmRqstMarAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstMayAmt = this.toRqstMayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnRqstSeq = this.toGenExpnRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOfcLvl1 = this.toOfcLvl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOfcLvl2 = this.toOfcLvl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAprAmt = this.toAprAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmJanAmt = this.fmJanAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstOpinRmk = this.fmRqstOpinRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstAprAmt = this.toRqstAprAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnCalcBssDesc = this.fmGenExpnCalcBssDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmJunAmt = this.fmJunAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmJulAmt = this.fmJulAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstMayAmt = this.fmRqstMayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toJanAmt = this.toJanAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAprAmt = this.fmAprAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstFebAmt = this.toRqstFebAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toKrnAbbrNm = this.toKrnAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqUpdDt = this.reqUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMarAmt = this.fmMarAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOctAmt = this.toOctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMayAmt = this.toMayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstUtVal = this.fmRqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstLoclAmt = this.fmRqstLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnTrnsDivCd = this.fmGenExpnTrnsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnRqstSeq = this.fmGenExpnRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstJanAmt = this.toRqstJanAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toFebAmt = this.toFebAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnCalcBssDesc = this.toGenExpnCalcBssDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
