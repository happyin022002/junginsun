/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Report0025R1VO.java
*@FileTitle : Report0025R1VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.07.17 진윤오 
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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Report0025R1VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Report0025R1VO> models = new ArrayList<Report0025R1VO>();
	
	/* Column Info */
	private String toAsgOctAmt = null;
	/* Column Info */
	private String toAsgNovAmt = null;
	/* Column Info */
	private String fmGenExpnItmDesc = null;
	/* Column Info */
	private String fmUtVal = null;
	/* Column Info */
	private String toUsdLoclXchRt = null;
	/* Column Info */
	private String toGenExpnCd = null;
	/* Column Info */
	private String fmOfcCd = null;
	/* Column Info */
	private String toTicCd = null;
	/* Column Info */
	private String fmAsgJulAmt = null;
	/* Column Info */
	private String fmAsgFebAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toCrntGenExpnAproStepCd = null;
	/* Column Info */
	private String toCrntGenExpnApstsCd = null;
	/* Column Info */
	private String genExpnRqstNo = null;
	/* Column Info */
	private String toAsgMarAmt = null;
	/* Column Info */
	private String fmAdAmt = null;
	/* Column Info */
	private String fmUsdKrwXchRt = null;
	/* Column Info */
	private String fmRqstOfcCd = null;
	/* Column Info */
	private String fmAsgMarAmt = null;
	/* Column Info */
	private String fmTicCd = null;
	/* Column Info */
	private String toAsgAprAmt = null;
	/* Column Info */
	private String fmAsgSepAmt = null;
	/* Column Info */
	private String toAsgJunAmt = null;
	/* Column Info */
	private String toGenExpnItemNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String toRqstOpinRmk = null;
	/* Column Info */
	private String toUsdAmt = null;
	/* Column Info */
	private String toAsgDecAmt = null;
	/* Column Info */
	private String toOfcCd = null;
	/* Column Info */
	private String toRqAmt = null;
	/* Column Info */
	private String fmCrntGenExpnAproStepCd = null;
	/* Column Info */
	private String fmAsgAugAmt = null;
	/* Column Info */
	private String fmAsgOctAmt = null;
	/* Column Info */
	private String fmGenExpnItemNo = null;
	/* Column Info */
	private String toLoclCurrCd = null;
	/* Column Info */
	private String fmUsdLoclXchRt = null;
	/* Column Info */
	private String toAsgAugAmt = null;
	/* Column Info */
	private String toAsgFebAmt = null;
	/* Column Info */
	private String fmAsgDecAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fmLoclCurrCd = null;
	/* Column Info */
	private String fmAdUsdAmt = null;
	/* Column Info */
	private String toGenExpnItmDesc = null;
	/* Column Info */
	private String fmAsgAprAmt = null;
	/* Column Info */
	private String fmGenExpnCd = null;
	/* Column Info */
	private String toAsgMayAmt = null;
	/* Column Info */
	private String fmAsgNovAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toAsgJanAmt = null;
	/* Column Info */
	private String toAdUsdAmt = null;
	/* Column Info */
	private String toAdAmt = null;
	/* Column Info */
	private String toLoclKrwXchRt = null;
	/* Column Info */
	private String fmLoclKrwXchRt = null;
	/* Column Info */
	private String fmAsgJunAmt = null;
	/* Column Info */
	private String fmRqstOpinRmk = null;
	/* Column Info */
	private String fmGenExpnCalcBssDesc = null;
	/* Column Info */
	private String fmAsgMayAmt = null;
	/* Column Info */
	private String toExpnAbbrNm = null;
	/* Column Info */
	private String toUtVal = null;
	/* Column Info */
	private String toAsgSepAmt = null;
	/* Column Info */
	private String toExpnGrpAbbrNm1 = null;
	/* Column Info */
	private String toExpnGrpAbbrNm2 = null;
	/* Column Info */
	private String toRqstOfcCd = null;
	/* Column Info */
	private String gemExpnGrpCd1 = null;
	/* Column Info */
	private String fmCrntGenExpnApstsCd = null;
	/* Column Info */
	private String gemExpnGrpCd2 = null;
	/* Column Info */
	private String fmExpnGrpAbbrNm2 = null;
	/* Column Info */
	private String fmUsdAmt = null;
	/* Column Info */
	private String fmExpnGrpAbbrNm1 = null;
	/* Column Info */
	private String genExpnRqstSeq = null;
	/* Column Info */
	private String toAsgJulAmt = null;
	/* Column Info */
	private String fmExpnAbbrNm = null;
	/* Column Info */
	private String toUsdKrwXchRt = null;
	/* Column Info */
	private String toGenExpnCalcBssDesc = null;
	/* Column Info */
	private String fmRqAmt = null;
	/* Column Info */
	private String genExpnRqstTpCd = null;
	/* Column Info */
	private String fmAsgJanAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Report0025R1VO() {}

	public Report0025R1VO(String ibflag, String pagerows, String genExpnRqstTpCd, String genExpnRqstNo, String genExpnRqstSeq, String creUsrId, String creDt, String fmOfcCd, String toOfcCd, String fmGenExpnCd, String toGenExpnCd, String gemExpnGrpCd1, String gemExpnGrpCd2, String fmExpnGrpAbbrNm1, String toExpnGrpAbbrNm1, String fmExpnGrpAbbrNm2, String toExpnGrpAbbrNm2, String fmExpnAbbrNm, String toExpnAbbrNm, String fmTicCd, String toTicCd, String fmGenExpnItemNo, String toGenExpnItemNo, String fmCrntGenExpnAproStepCd, String toCrntGenExpnAproStepCd, String fmCrntGenExpnApstsCd, String toCrntGenExpnApstsCd, String fmRqstOfcCd, String toRqstOfcCd, String fmGenExpnItmDesc, String toGenExpnItmDesc, String fmGenExpnCalcBssDesc, String toGenExpnCalcBssDesc, String fmRqstOpinRmk, String toRqstOpinRmk, String fmLoclCurrCd, String toLoclCurrCd, String fmUtVal, String toUtVal, String fmUsdLoclXchRt, String toUsdLoclXchRt, String fmLoclKrwXchRt, String toLoclKrwXchRt, String fmUsdKrwXchRt, String toUsdKrwXchRt, String fmAsgJanAmt, String fmAsgFebAmt, String fmAsgMarAmt, String fmAsgAprAmt, String fmAsgMayAmt, String fmAsgJunAmt, String fmAsgJulAmt, String fmAsgAugAmt, String fmAsgSepAmt, String fmAsgOctAmt, String fmAsgNovAmt, String fmAsgDecAmt, String toAsgJanAmt, String toAsgFebAmt, String toAsgMarAmt, String toAsgAprAmt, String toAsgMayAmt, String toAsgJunAmt, String toAsgJulAmt, String toAsgAugAmt, String toAsgSepAmt, String toAsgOctAmt, String toAsgNovAmt, String toAsgDecAmt, String fmRqAmt, String toRqAmt, String fmAdAmt, String toAdAmt, String fmUsdAmt, String toUsdAmt, String fmAdUsdAmt, String toAdUsdAmt) {
		this.toAsgOctAmt = toAsgOctAmt;
		this.toAsgNovAmt = toAsgNovAmt;
		this.fmGenExpnItmDesc = fmGenExpnItmDesc;
		this.fmUtVal = fmUtVal;
		this.toUsdLoclXchRt = toUsdLoclXchRt;
		this.toGenExpnCd = toGenExpnCd;
		this.fmOfcCd = fmOfcCd;
		this.toTicCd = toTicCd;
		this.fmAsgJulAmt = fmAsgJulAmt;
		this.fmAsgFebAmt = fmAsgFebAmt;
		this.pagerows = pagerows;
		this.toCrntGenExpnAproStepCd = toCrntGenExpnAproStepCd;
		this.toCrntGenExpnApstsCd = toCrntGenExpnApstsCd;
		this.genExpnRqstNo = genExpnRqstNo;
		this.toAsgMarAmt = toAsgMarAmt;
		this.fmAdAmt = fmAdAmt;
		this.fmUsdKrwXchRt = fmUsdKrwXchRt;
		this.fmRqstOfcCd = fmRqstOfcCd;
		this.fmAsgMarAmt = fmAsgMarAmt;
		this.fmTicCd = fmTicCd;
		this.toAsgAprAmt = toAsgAprAmt;
		this.fmAsgSepAmt = fmAsgSepAmt;
		this.toAsgJunAmt = toAsgJunAmt;
		this.toGenExpnItemNo = toGenExpnItemNo;
		this.creUsrId = creUsrId;
		this.toRqstOpinRmk = toRqstOpinRmk;
		this.toUsdAmt = toUsdAmt;
		this.toAsgDecAmt = toAsgDecAmt;
		this.toOfcCd = toOfcCd;
		this.toRqAmt = toRqAmt;
		this.fmCrntGenExpnAproStepCd = fmCrntGenExpnAproStepCd;
		this.fmAsgAugAmt = fmAsgAugAmt;
		this.fmAsgOctAmt = fmAsgOctAmt;
		this.fmGenExpnItemNo = fmGenExpnItemNo;
		this.toLoclCurrCd = toLoclCurrCd;
		this.fmUsdLoclXchRt = fmUsdLoclXchRt;
		this.toAsgAugAmt = toAsgAugAmt;
		this.toAsgFebAmt = toAsgFebAmt;
		this.fmAsgDecAmt = fmAsgDecAmt;
		this.creDt = creDt;
		this.fmLoclCurrCd = fmLoclCurrCd;
		this.fmAdUsdAmt = fmAdUsdAmt;
		this.toGenExpnItmDesc = toGenExpnItmDesc;
		this.fmAsgAprAmt = fmAsgAprAmt;
		this.fmGenExpnCd = fmGenExpnCd;
		this.toAsgMayAmt = toAsgMayAmt;
		this.fmAsgNovAmt = fmAsgNovAmt;
		this.ibflag = ibflag;
		this.toAsgJanAmt = toAsgJanAmt;
		this.toAdUsdAmt = toAdUsdAmt;
		this.toAdAmt = toAdAmt;
		this.toLoclKrwXchRt = toLoclKrwXchRt;
		this.fmLoclKrwXchRt = fmLoclKrwXchRt;
		this.fmAsgJunAmt = fmAsgJunAmt;
		this.fmRqstOpinRmk = fmRqstOpinRmk;
		this.fmGenExpnCalcBssDesc = fmGenExpnCalcBssDesc;
		this.fmAsgMayAmt = fmAsgMayAmt;
		this.toExpnAbbrNm = toExpnAbbrNm;
		this.toUtVal = toUtVal;
		this.toAsgSepAmt = toAsgSepAmt;
		this.toExpnGrpAbbrNm1 = toExpnGrpAbbrNm1;
		this.toExpnGrpAbbrNm2 = toExpnGrpAbbrNm2;
		this.toRqstOfcCd = toRqstOfcCd;
		this.gemExpnGrpCd1 = gemExpnGrpCd1;
		this.fmCrntGenExpnApstsCd = fmCrntGenExpnApstsCd;
		this.gemExpnGrpCd2 = gemExpnGrpCd2;
		this.fmExpnGrpAbbrNm2 = fmExpnGrpAbbrNm2;
		this.fmUsdAmt = fmUsdAmt;
		this.fmExpnGrpAbbrNm1 = fmExpnGrpAbbrNm1;
		this.genExpnRqstSeq = genExpnRqstSeq;
		this.toAsgJulAmt = toAsgJulAmt;
		this.fmExpnAbbrNm = fmExpnAbbrNm;
		this.toUsdKrwXchRt = toUsdKrwXchRt;
		this.toGenExpnCalcBssDesc = toGenExpnCalcBssDesc;
		this.fmRqAmt = fmRqAmt;
		this.genExpnRqstTpCd = genExpnRqstTpCd;
		this.fmAsgJanAmt = fmAsgJanAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_asg_oct_amt", getToAsgOctAmt());
		this.hashColumns.put("to_asg_nov_amt", getToAsgNovAmt());
		this.hashColumns.put("fm_gen_expn_itm_desc", getFmGenExpnItmDesc());
		this.hashColumns.put("fm_ut_val", getFmUtVal());
		this.hashColumns.put("to_usd_locl_xch_rt", getToUsdLoclXchRt());
		this.hashColumns.put("to_gen_expn_cd", getToGenExpnCd());
		this.hashColumns.put("fm_ofc_cd", getFmOfcCd());
		this.hashColumns.put("to_tic_cd", getToTicCd());
		this.hashColumns.put("fm_asg_jul_amt", getFmAsgJulAmt());
		this.hashColumns.put("fm_asg_feb_amt", getFmAsgFebAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_crnt_gen_expn_apro_step_cd", getToCrntGenExpnAproStepCd());
		this.hashColumns.put("to_crnt_gen_expn_apsts_cd", getToCrntGenExpnApstsCd());
		this.hashColumns.put("gen_expn_rqst_no", getGenExpnRqstNo());
		this.hashColumns.put("to_asg_mar_amt", getToAsgMarAmt());
		this.hashColumns.put("fm_ad_amt", getFmAdAmt());
		this.hashColumns.put("fm_usd_krw_xch_rt", getFmUsdKrwXchRt());
		this.hashColumns.put("fm_rqst_ofc_cd", getFmRqstOfcCd());
		this.hashColumns.put("fm_asg_mar_amt", getFmAsgMarAmt());
		this.hashColumns.put("fm_tic_cd", getFmTicCd());
		this.hashColumns.put("to_asg_apr_amt", getToAsgAprAmt());
		this.hashColumns.put("fm_asg_sep_amt", getFmAsgSepAmt());
		this.hashColumns.put("to_asg_jun_amt", getToAsgJunAmt());
		this.hashColumns.put("to_gen_expn_item_no", getToGenExpnItemNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("to_rqst_opin_rmk", getToRqstOpinRmk());
		this.hashColumns.put("to_usd_amt", getToUsdAmt());
		this.hashColumns.put("to_asg_dec_amt", getToAsgDecAmt());
		this.hashColumns.put("to_ofc_cd", getToOfcCd());
		this.hashColumns.put("to_rq_amt", getToRqAmt());
		this.hashColumns.put("fm_crnt_gen_expn_apro_step_cd", getFmCrntGenExpnAproStepCd());
		this.hashColumns.put("fm_asg_aug_amt", getFmAsgAugAmt());
		this.hashColumns.put("fm_asg_oct_amt", getFmAsgOctAmt());
		this.hashColumns.put("fm_gen_expn_item_no", getFmGenExpnItemNo());
		this.hashColumns.put("to_locl_curr_cd", getToLoclCurrCd());
		this.hashColumns.put("fm_usd_locl_xch_rt", getFmUsdLoclXchRt());
		this.hashColumns.put("to_asg_aug_amt", getToAsgAugAmt());
		this.hashColumns.put("to_asg_feb_amt", getToAsgFebAmt());
		this.hashColumns.put("fm_asg_dec_amt", getFmAsgDecAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("fm_locl_curr_cd", getFmLoclCurrCd());
		this.hashColumns.put("fm_ad_usd_amt", getFmAdUsdAmt());
		this.hashColumns.put("to_gen_expn_itm_desc", getToGenExpnItmDesc());
		this.hashColumns.put("fm_asg_apr_amt", getFmAsgAprAmt());
		this.hashColumns.put("fm_gen_expn_cd", getFmGenExpnCd());
		this.hashColumns.put("to_asg_may_amt", getToAsgMayAmt());
		this.hashColumns.put("fm_asg_nov_amt", getFmAsgNovAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_asg_jan_amt", getToAsgJanAmt());
		this.hashColumns.put("to_ad_usd_amt", getToAdUsdAmt());
		this.hashColumns.put("to_ad_amt", getToAdAmt());
		this.hashColumns.put("to_locl_krw_xch_rt", getToLoclKrwXchRt());
		this.hashColumns.put("fm_locl_krw_xch_rt", getFmLoclKrwXchRt());
		this.hashColumns.put("fm_asg_jun_amt", getFmAsgJunAmt());
		this.hashColumns.put("fm_rqst_opin_rmk", getFmRqstOpinRmk());
		this.hashColumns.put("fm_gen_expn_calc_bss_desc", getFmGenExpnCalcBssDesc());
		this.hashColumns.put("fm_asg_may_amt", getFmAsgMayAmt());
		this.hashColumns.put("to_expn_abbr_nm", getToExpnAbbrNm());
		this.hashColumns.put("to_ut_val", getToUtVal());
		this.hashColumns.put("to_asg_sep_amt", getToAsgSepAmt());
		this.hashColumns.put("to_expn_grp_abbr_nm1", getToExpnGrpAbbrNm1());
		this.hashColumns.put("to_expn_grp_abbr_nm2", getToExpnGrpAbbrNm2());
		this.hashColumns.put("to_rqst_ofc_cd", getToRqstOfcCd());
		this.hashColumns.put("gem_expn_grp_cd1", getGemExpnGrpCd1());
		this.hashColumns.put("fm_crnt_gen_expn_apsts_cd", getFmCrntGenExpnApstsCd());
		this.hashColumns.put("gem_expn_grp_cd2", getGemExpnGrpCd2());
		this.hashColumns.put("fm_expn_grp_abbr_nm2", getFmExpnGrpAbbrNm2());
		this.hashColumns.put("fm_usd_amt", getFmUsdAmt());
		this.hashColumns.put("fm_expn_grp_abbr_nm1", getFmExpnGrpAbbrNm1());
		this.hashColumns.put("gen_expn_rqst_seq", getGenExpnRqstSeq());
		this.hashColumns.put("to_asg_jul_amt", getToAsgJulAmt());
		this.hashColumns.put("fm_expn_abbr_nm", getFmExpnAbbrNm());
		this.hashColumns.put("to_usd_krw_xch_rt", getToUsdKrwXchRt());
		this.hashColumns.put("to_gen_expn_calc_bss_desc", getToGenExpnCalcBssDesc());
		this.hashColumns.put("fm_rq_amt", getFmRqAmt());
		this.hashColumns.put("gen_expn_rqst_tp_cd", getGenExpnRqstTpCd());
		this.hashColumns.put("fm_asg_jan_amt", getFmAsgJanAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_asg_oct_amt", "toAsgOctAmt");
		this.hashFields.put("to_asg_nov_amt", "toAsgNovAmt");
		this.hashFields.put("fm_gen_expn_itm_desc", "fmGenExpnItmDesc");
		this.hashFields.put("fm_ut_val", "fmUtVal");
		this.hashFields.put("to_usd_locl_xch_rt", "toUsdLoclXchRt");
		this.hashFields.put("to_gen_expn_cd", "toGenExpnCd");
		this.hashFields.put("fm_ofc_cd", "fmOfcCd");
		this.hashFields.put("to_tic_cd", "toTicCd");
		this.hashFields.put("fm_asg_jul_amt", "fmAsgJulAmt");
		this.hashFields.put("fm_asg_feb_amt", "fmAsgFebAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_crnt_gen_expn_apro_step_cd", "toCrntGenExpnAproStepCd");
		this.hashFields.put("to_crnt_gen_expn_apsts_cd", "toCrntGenExpnApstsCd");
		this.hashFields.put("gen_expn_rqst_no", "genExpnRqstNo");
		this.hashFields.put("to_asg_mar_amt", "toAsgMarAmt");
		this.hashFields.put("fm_ad_amt", "fmAdAmt");
		this.hashFields.put("fm_usd_krw_xch_rt", "fmUsdKrwXchRt");
		this.hashFields.put("fm_rqst_ofc_cd", "fmRqstOfcCd");
		this.hashFields.put("fm_asg_mar_amt", "fmAsgMarAmt");
		this.hashFields.put("fm_tic_cd", "fmTicCd");
		this.hashFields.put("to_asg_apr_amt", "toAsgAprAmt");
		this.hashFields.put("fm_asg_sep_amt", "fmAsgSepAmt");
		this.hashFields.put("to_asg_jun_amt", "toAsgJunAmt");
		this.hashFields.put("to_gen_expn_item_no", "toGenExpnItemNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("to_rqst_opin_rmk", "toRqstOpinRmk");
		this.hashFields.put("to_usd_amt", "toUsdAmt");
		this.hashFields.put("to_asg_dec_amt", "toAsgDecAmt");
		this.hashFields.put("to_ofc_cd", "toOfcCd");
		this.hashFields.put("to_rq_amt", "toRqAmt");
		this.hashFields.put("fm_crnt_gen_expn_apro_step_cd", "fmCrntGenExpnAproStepCd");
		this.hashFields.put("fm_asg_aug_amt", "fmAsgAugAmt");
		this.hashFields.put("fm_asg_oct_amt", "fmAsgOctAmt");
		this.hashFields.put("fm_gen_expn_item_no", "fmGenExpnItemNo");
		this.hashFields.put("to_locl_curr_cd", "toLoclCurrCd");
		this.hashFields.put("fm_usd_locl_xch_rt", "fmUsdLoclXchRt");
		this.hashFields.put("to_asg_aug_amt", "toAsgAugAmt");
		this.hashFields.put("to_asg_feb_amt", "toAsgFebAmt");
		this.hashFields.put("fm_asg_dec_amt", "fmAsgDecAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("fm_locl_curr_cd", "fmLoclCurrCd");
		this.hashFields.put("fm_ad_usd_amt", "fmAdUsdAmt");
		this.hashFields.put("to_gen_expn_itm_desc", "toGenExpnItmDesc");
		this.hashFields.put("fm_asg_apr_amt", "fmAsgAprAmt");
		this.hashFields.put("fm_gen_expn_cd", "fmGenExpnCd");
		this.hashFields.put("to_asg_may_amt", "toAsgMayAmt");
		this.hashFields.put("fm_asg_nov_amt", "fmAsgNovAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_asg_jan_amt", "toAsgJanAmt");
		this.hashFields.put("to_ad_usd_amt", "toAdUsdAmt");
		this.hashFields.put("to_ad_amt", "toAdAmt");
		this.hashFields.put("to_locl_krw_xch_rt", "toLoclKrwXchRt");
		this.hashFields.put("fm_locl_krw_xch_rt", "fmLoclKrwXchRt");
		this.hashFields.put("fm_asg_jun_amt", "fmAsgJunAmt");
		this.hashFields.put("fm_rqst_opin_rmk", "fmRqstOpinRmk");
		this.hashFields.put("fm_gen_expn_calc_bss_desc", "fmGenExpnCalcBssDesc");
		this.hashFields.put("fm_asg_may_amt", "fmAsgMayAmt");
		this.hashFields.put("to_expn_abbr_nm", "toExpnAbbrNm");
		this.hashFields.put("to_ut_val", "toUtVal");
		this.hashFields.put("to_asg_sep_amt", "toAsgSepAmt");
		this.hashFields.put("to_expn_grp_abbr_nm1", "toExpnGrpAbbrNm1");
		this.hashFields.put("to_expn_grp_abbr_nm2", "toExpnGrpAbbrNm2");
		this.hashFields.put("to_rqst_ofc_cd", "toRqstOfcCd");
		this.hashFields.put("gem_expn_grp_cd1", "gemExpnGrpCd1");
		this.hashFields.put("fm_crnt_gen_expn_apsts_cd", "fmCrntGenExpnApstsCd");
		this.hashFields.put("gem_expn_grp_cd2", "gemExpnGrpCd2");
		this.hashFields.put("fm_expn_grp_abbr_nm2", "fmExpnGrpAbbrNm2");
		this.hashFields.put("fm_usd_amt", "fmUsdAmt");
		this.hashFields.put("fm_expn_grp_abbr_nm1", "fmExpnGrpAbbrNm1");
		this.hashFields.put("gen_expn_rqst_seq", "genExpnRqstSeq");
		this.hashFields.put("to_asg_jul_amt", "toAsgJulAmt");
		this.hashFields.put("fm_expn_abbr_nm", "fmExpnAbbrNm");
		this.hashFields.put("to_usd_krw_xch_rt", "toUsdKrwXchRt");
		this.hashFields.put("to_gen_expn_calc_bss_desc", "toGenExpnCalcBssDesc");
		this.hashFields.put("fm_rq_amt", "fmRqAmt");
		this.hashFields.put("gen_expn_rqst_tp_cd", "genExpnRqstTpCd");
		this.hashFields.put("fm_asg_jan_amt", "fmAsgJanAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toAsgOctAmt
	 */
	public String getToAsgOctAmt() {
		return this.toAsgOctAmt;
	}
	
	/**
	 * Column Info
	 * @return toAsgNovAmt
	 */
	public String getToAsgNovAmt() {
		return this.toAsgNovAmt;
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
	 * @return fmUtVal
	 */
	public String getFmUtVal() {
		return this.fmUtVal;
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
	 * @return toGenExpnCd
	 */
	public String getToGenExpnCd() {
		return this.toGenExpnCd;
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
	 * @return fmAsgJulAmt
	 */
	public String getFmAsgJulAmt() {
		return this.fmAsgJulAmt;
	}
	
	/**
	 * Column Info
	 * @return fmAsgFebAmt
	 */
	public String getFmAsgFebAmt() {
		return this.fmAsgFebAmt;
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
	 * @return toCrntGenExpnAproStepCd
	 */
	public String getToCrntGenExpnAproStepCd() {
		return this.toCrntGenExpnAproStepCd;
	}
	
	/**
	 * Column Info
	 * @return toCrntGenExpnApstsCd
	 */
	public String getToCrntGenExpnApstsCd() {
		return this.toCrntGenExpnApstsCd;
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
	 * @return toAsgMarAmt
	 */
	public String getToAsgMarAmt() {
		return this.toAsgMarAmt;
	}
	
	/**
	 * Column Info
	 * @return fmAdAmt
	 */
	public String getFmAdAmt() {
		return this.fmAdAmt;
	}
	
	/**
	 * Column Info
	 * @return fmUsdKrwXchRt
	 */
	public String getFmUsdKrwXchRt() {
		return this.fmUsdKrwXchRt;
	}
	
	/**
	 * Column Info
	 * @return fmRqstOfcCd
	 */
	public String getFmRqstOfcCd() {
		return this.fmRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fmAsgMarAmt
	 */
	public String getFmAsgMarAmt() {
		return this.fmAsgMarAmt;
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
	 * @return toAsgAprAmt
	 */
	public String getToAsgAprAmt() {
		return this.toAsgAprAmt;
	}
	
	/**
	 * Column Info
	 * @return fmAsgSepAmt
	 */
	public String getFmAsgSepAmt() {
		return this.fmAsgSepAmt;
	}
	
	/**
	 * Column Info
	 * @return toAsgJunAmt
	 */
	public String getToAsgJunAmt() {
		return this.toAsgJunAmt;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnItemNo
	 */
	public String getToGenExpnItemNo() {
		return this.toGenExpnItemNo;
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
	 * @return toRqstOpinRmk
	 */
	public String getToRqstOpinRmk() {
		return this.toRqstOpinRmk;
	}
	
	/**
	 * Column Info
	 * @return toUsdAmt
	 */
	public String getToUsdAmt() {
		return this.toUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return toAsgDecAmt
	 */
	public String getToAsgDecAmt() {
		return this.toAsgDecAmt;
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
	 * @return toRqAmt
	 */
	public String getToRqAmt() {
		return this.toRqAmt;
	}
	
	/**
	 * Column Info
	 * @return fmCrntGenExpnAproStepCd
	 */
	public String getFmCrntGenExpnAproStepCd() {
		return this.fmCrntGenExpnAproStepCd;
	}
	
	/**
	 * Column Info
	 * @return fmAsgAugAmt
	 */
	public String getFmAsgAugAmt() {
		return this.fmAsgAugAmt;
	}
	
	/**
	 * Column Info
	 * @return fmAsgOctAmt
	 */
	public String getFmAsgOctAmt() {
		return this.fmAsgOctAmt;
	}
	
	/**
	 * Column Info
	 * @return fmGenExpnItemNo
	 */
	public String getFmGenExpnItemNo() {
		return this.fmGenExpnItemNo;
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
	 * @return toAsgAugAmt
	 */
	public String getToAsgAugAmt() {
		return this.toAsgAugAmt;
	}
	
	/**
	 * Column Info
	 * @return toAsgFebAmt
	 */
	public String getToAsgFebAmt() {
		return this.toAsgFebAmt;
	}
	
	/**
	 * Column Info
	 * @return fmAsgDecAmt
	 */
	public String getFmAsgDecAmt() {
		return this.fmAsgDecAmt;
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
	 * @return fmLoclCurrCd
	 */
	public String getFmLoclCurrCd() {
		return this.fmLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return fmAdUsdAmt
	 */
	public String getFmAdUsdAmt() {
		return this.fmAdUsdAmt;
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
	 * @return fmAsgAprAmt
	 */
	public String getFmAsgAprAmt() {
		return this.fmAsgAprAmt;
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
	 * @return toAsgMayAmt
	 */
	public String getToAsgMayAmt() {
		return this.toAsgMayAmt;
	}
	
	/**
	 * Column Info
	 * @return fmAsgNovAmt
	 */
	public String getFmAsgNovAmt() {
		return this.fmAsgNovAmt;
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
	 * @return toAsgJanAmt
	 */
	public String getToAsgJanAmt() {
		return this.toAsgJanAmt;
	}
	
	/**
	 * Column Info
	 * @return toAdUsdAmt
	 */
	public String getToAdUsdAmt() {
		return this.toAdUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return toAdAmt
	 */
	public String getToAdAmt() {
		return this.toAdAmt;
	}
	
	/**
	 * Column Info
	 * @return toLoclKrwXchRt
	 */
	public String getToLoclKrwXchRt() {
		return this.toLoclKrwXchRt;
	}
	
	/**
	 * Column Info
	 * @return fmLoclKrwXchRt
	 */
	public String getFmLoclKrwXchRt() {
		return this.fmLoclKrwXchRt;
	}
	
	/**
	 * Column Info
	 * @return fmAsgJunAmt
	 */
	public String getFmAsgJunAmt() {
		return this.fmAsgJunAmt;
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
	 * @return fmGenExpnCalcBssDesc
	 */
	public String getFmGenExpnCalcBssDesc() {
		return this.fmGenExpnCalcBssDesc;
	}
	
	/**
	 * Column Info
	 * @return fmAsgMayAmt
	 */
	public String getFmAsgMayAmt() {
		return this.fmAsgMayAmt;
	}
	
	/**
	 * Column Info
	 * @return toExpnAbbrNm
	 */
	public String getToExpnAbbrNm() {
		return this.toExpnAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return toUtVal
	 */
	public String getToUtVal() {
		return this.toUtVal;
	}
	
	/**
	 * Column Info
	 * @return toAsgSepAmt
	 */
	public String getToAsgSepAmt() {
		return this.toAsgSepAmt;
	}
	
	/**
	 * Column Info
	 * @return toExpnGrpAbbrNm1
	 */
	public String getToExpnGrpAbbrNm1() {
		return this.toExpnGrpAbbrNm1;
	}
	
	/**
	 * Column Info
	 * @return toExpnGrpAbbrNm2
	 */
	public String getToExpnGrpAbbrNm2() {
		return this.toExpnGrpAbbrNm2;
	}
	
	/**
	 * Column Info
	 * @return toRqstOfcCd
	 */
	public String getToRqstOfcCd() {
		return this.toRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return gemExpnGrpCd1
	 */
	public String getGemExpnGrpCd1() {
		return this.gemExpnGrpCd1;
	}
	
	/**
	 * Column Info
	 * @return fmCrntGenExpnApstsCd
	 */
	public String getFmCrntGenExpnApstsCd() {
		return this.fmCrntGenExpnApstsCd;
	}
	
	/**
	 * Column Info
	 * @return gemExpnGrpCd2
	 */
	public String getGemExpnGrpCd2() {
		return this.gemExpnGrpCd2;
	}
	
	/**
	 * Column Info
	 * @return fmExpnGrpAbbrNm2
	 */
	public String getFmExpnGrpAbbrNm2() {
		return this.fmExpnGrpAbbrNm2;
	}
	
	/**
	 * Column Info
	 * @return fmUsdAmt
	 */
	public String getFmUsdAmt() {
		return this.fmUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return fmExpnGrpAbbrNm1
	 */
	public String getFmExpnGrpAbbrNm1() {
		return this.fmExpnGrpAbbrNm1;
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
	 * @return toAsgJulAmt
	 */
	public String getToAsgJulAmt() {
		return this.toAsgJulAmt;
	}
	
	/**
	 * Column Info
	 * @return fmExpnAbbrNm
	 */
	public String getFmExpnAbbrNm() {
		return this.fmExpnAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return toUsdKrwXchRt
	 */
	public String getToUsdKrwXchRt() {
		return this.toUsdKrwXchRt;
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
	 * @return fmRqAmt
	 */
	public String getFmRqAmt() {
		return this.fmRqAmt;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstTpCd
	 */
	public String getGenExpnRqstTpCd() {
		return this.genExpnRqstTpCd;
	}
	
	/**
	 * Column Info
	 * @return fmAsgJanAmt
	 */
	public String getFmAsgJanAmt() {
		return this.fmAsgJanAmt;
	}
	

	/**
	 * Column Info
	 * @param toAsgOctAmt
	 */
	public void setToAsgOctAmt(String toAsgOctAmt) {
		this.toAsgOctAmt = toAsgOctAmt;
	}
	
	/**
	 * Column Info
	 * @param toAsgNovAmt
	 */
	public void setToAsgNovAmt(String toAsgNovAmt) {
		this.toAsgNovAmt = toAsgNovAmt;
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
	 * @param fmUtVal
	 */
	public void setFmUtVal(String fmUtVal) {
		this.fmUtVal = fmUtVal;
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
	 * @param toGenExpnCd
	 */
	public void setToGenExpnCd(String toGenExpnCd) {
		this.toGenExpnCd = toGenExpnCd;
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
	 * @param fmAsgJulAmt
	 */
	public void setFmAsgJulAmt(String fmAsgJulAmt) {
		this.fmAsgJulAmt = fmAsgJulAmt;
	}
	
	/**
	 * Column Info
	 * @param fmAsgFebAmt
	 */
	public void setFmAsgFebAmt(String fmAsgFebAmt) {
		this.fmAsgFebAmt = fmAsgFebAmt;
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
	 * @param toCrntGenExpnAproStepCd
	 */
	public void setToCrntGenExpnAproStepCd(String toCrntGenExpnAproStepCd) {
		this.toCrntGenExpnAproStepCd = toCrntGenExpnAproStepCd;
	}
	
	/**
	 * Column Info
	 * @param toCrntGenExpnApstsCd
	 */
	public void setToCrntGenExpnApstsCd(String toCrntGenExpnApstsCd) {
		this.toCrntGenExpnApstsCd = toCrntGenExpnApstsCd;
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
	 * @param toAsgMarAmt
	 */
	public void setToAsgMarAmt(String toAsgMarAmt) {
		this.toAsgMarAmt = toAsgMarAmt;
	}
	
	/**
	 * Column Info
	 * @param fmAdAmt
	 */
	public void setFmAdAmt(String fmAdAmt) {
		this.fmAdAmt = fmAdAmt;
	}
	
	/**
	 * Column Info
	 * @param fmUsdKrwXchRt
	 */
	public void setFmUsdKrwXchRt(String fmUsdKrwXchRt) {
		this.fmUsdKrwXchRt = fmUsdKrwXchRt;
	}
	
	/**
	 * Column Info
	 * @param fmRqstOfcCd
	 */
	public void setFmRqstOfcCd(String fmRqstOfcCd) {
		this.fmRqstOfcCd = fmRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fmAsgMarAmt
	 */
	public void setFmAsgMarAmt(String fmAsgMarAmt) {
		this.fmAsgMarAmt = fmAsgMarAmt;
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
	 * @param toAsgAprAmt
	 */
	public void setToAsgAprAmt(String toAsgAprAmt) {
		this.toAsgAprAmt = toAsgAprAmt;
	}
	
	/**
	 * Column Info
	 * @param fmAsgSepAmt
	 */
	public void setFmAsgSepAmt(String fmAsgSepAmt) {
		this.fmAsgSepAmt = fmAsgSepAmt;
	}
	
	/**
	 * Column Info
	 * @param toAsgJunAmt
	 */
	public void setToAsgJunAmt(String toAsgJunAmt) {
		this.toAsgJunAmt = toAsgJunAmt;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnItemNo
	 */
	public void setToGenExpnItemNo(String toGenExpnItemNo) {
		this.toGenExpnItemNo = toGenExpnItemNo;
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
	 * @param toRqstOpinRmk
	 */
	public void setToRqstOpinRmk(String toRqstOpinRmk) {
		this.toRqstOpinRmk = toRqstOpinRmk;
	}
	
	/**
	 * Column Info
	 * @param toUsdAmt
	 */
	public void setToUsdAmt(String toUsdAmt) {
		this.toUsdAmt = toUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param toAsgDecAmt
	 */
	public void setToAsgDecAmt(String toAsgDecAmt) {
		this.toAsgDecAmt = toAsgDecAmt;
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
	 * @param toRqAmt
	 */
	public void setToRqAmt(String toRqAmt) {
		this.toRqAmt = toRqAmt;
	}
	
	/**
	 * Column Info
	 * @param fmCrntGenExpnAproStepCd
	 */
	public void setFmCrntGenExpnAproStepCd(String fmCrntGenExpnAproStepCd) {
		this.fmCrntGenExpnAproStepCd = fmCrntGenExpnAproStepCd;
	}
	
	/**
	 * Column Info
	 * @param fmAsgAugAmt
	 */
	public void setFmAsgAugAmt(String fmAsgAugAmt) {
		this.fmAsgAugAmt = fmAsgAugAmt;
	}
	
	/**
	 * Column Info
	 * @param fmAsgOctAmt
	 */
	public void setFmAsgOctAmt(String fmAsgOctAmt) {
		this.fmAsgOctAmt = fmAsgOctAmt;
	}
	
	/**
	 * Column Info
	 * @param fmGenExpnItemNo
	 */
	public void setFmGenExpnItemNo(String fmGenExpnItemNo) {
		this.fmGenExpnItemNo = fmGenExpnItemNo;
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
	 * @param toAsgAugAmt
	 */
	public void setToAsgAugAmt(String toAsgAugAmt) {
		this.toAsgAugAmt = toAsgAugAmt;
	}
	
	/**
	 * Column Info
	 * @param toAsgFebAmt
	 */
	public void setToAsgFebAmt(String toAsgFebAmt) {
		this.toAsgFebAmt = toAsgFebAmt;
	}
	
	/**
	 * Column Info
	 * @param fmAsgDecAmt
	 */
	public void setFmAsgDecAmt(String fmAsgDecAmt) {
		this.fmAsgDecAmt = fmAsgDecAmt;
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
	 * @param fmLoclCurrCd
	 */
	public void setFmLoclCurrCd(String fmLoclCurrCd) {
		this.fmLoclCurrCd = fmLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param fmAdUsdAmt
	 */
	public void setFmAdUsdAmt(String fmAdUsdAmt) {
		this.fmAdUsdAmt = fmAdUsdAmt;
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
	 * @param fmAsgAprAmt
	 */
	public void setFmAsgAprAmt(String fmAsgAprAmt) {
		this.fmAsgAprAmt = fmAsgAprAmt;
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
	 * @param toAsgMayAmt
	 */
	public void setToAsgMayAmt(String toAsgMayAmt) {
		this.toAsgMayAmt = toAsgMayAmt;
	}
	
	/**
	 * Column Info
	 * @param fmAsgNovAmt
	 */
	public void setFmAsgNovAmt(String fmAsgNovAmt) {
		this.fmAsgNovAmt = fmAsgNovAmt;
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
	 * @param toAsgJanAmt
	 */
	public void setToAsgJanAmt(String toAsgJanAmt) {
		this.toAsgJanAmt = toAsgJanAmt;
	}
	
	/**
	 * Column Info
	 * @param toAdUsdAmt
	 */
	public void setToAdUsdAmt(String toAdUsdAmt) {
		this.toAdUsdAmt = toAdUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param toAdAmt
	 */
	public void setToAdAmt(String toAdAmt) {
		this.toAdAmt = toAdAmt;
	}
	
	/**
	 * Column Info
	 * @param toLoclKrwXchRt
	 */
	public void setToLoclKrwXchRt(String toLoclKrwXchRt) {
		this.toLoclKrwXchRt = toLoclKrwXchRt;
	}
	
	/**
	 * Column Info
	 * @param fmLoclKrwXchRt
	 */
	public void setFmLoclKrwXchRt(String fmLoclKrwXchRt) {
		this.fmLoclKrwXchRt = fmLoclKrwXchRt;
	}
	
	/**
	 * Column Info
	 * @param fmAsgJunAmt
	 */
	public void setFmAsgJunAmt(String fmAsgJunAmt) {
		this.fmAsgJunAmt = fmAsgJunAmt;
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
	 * @param fmGenExpnCalcBssDesc
	 */
	public void setFmGenExpnCalcBssDesc(String fmGenExpnCalcBssDesc) {
		this.fmGenExpnCalcBssDesc = fmGenExpnCalcBssDesc;
	}
	
	/**
	 * Column Info
	 * @param fmAsgMayAmt
	 */
	public void setFmAsgMayAmt(String fmAsgMayAmt) {
		this.fmAsgMayAmt = fmAsgMayAmt;
	}
	
	/**
	 * Column Info
	 * @param toExpnAbbrNm
	 */
	public void setToExpnAbbrNm(String toExpnAbbrNm) {
		this.toExpnAbbrNm = toExpnAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param toUtVal
	 */
	public void setToUtVal(String toUtVal) {
		this.toUtVal = toUtVal;
	}
	
	/**
	 * Column Info
	 * @param toAsgSepAmt
	 */
	public void setToAsgSepAmt(String toAsgSepAmt) {
		this.toAsgSepAmt = toAsgSepAmt;
	}
	
	/**
	 * Column Info
	 * @param toExpnGrpAbbrNm1
	 */
	public void setToExpnGrpAbbrNm1(String toExpnGrpAbbrNm1) {
		this.toExpnGrpAbbrNm1 = toExpnGrpAbbrNm1;
	}
	
	/**
	 * Column Info
	 * @param toExpnGrpAbbrNm2
	 */
	public void setToExpnGrpAbbrNm2(String toExpnGrpAbbrNm2) {
		this.toExpnGrpAbbrNm2 = toExpnGrpAbbrNm2;
	}
	
	/**
	 * Column Info
	 * @param toRqstOfcCd
	 */
	public void setToRqstOfcCd(String toRqstOfcCd) {
		this.toRqstOfcCd = toRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param gemExpnGrpCd1
	 */
	public void setGemExpnGrpCd1(String gemExpnGrpCd1) {
		this.gemExpnGrpCd1 = gemExpnGrpCd1;
	}
	
	/**
	 * Column Info
	 * @param fmCrntGenExpnApstsCd
	 */
	public void setFmCrntGenExpnApstsCd(String fmCrntGenExpnApstsCd) {
		this.fmCrntGenExpnApstsCd = fmCrntGenExpnApstsCd;
	}
	
	/**
	 * Column Info
	 * @param gemExpnGrpCd2
	 */
	public void setGemExpnGrpCd2(String gemExpnGrpCd2) {
		this.gemExpnGrpCd2 = gemExpnGrpCd2;
	}
	
	/**
	 * Column Info
	 * @param fmExpnGrpAbbrNm2
	 */
	public void setFmExpnGrpAbbrNm2(String fmExpnGrpAbbrNm2) {
		this.fmExpnGrpAbbrNm2 = fmExpnGrpAbbrNm2;
	}
	
	/**
	 * Column Info
	 * @param fmUsdAmt
	 */
	public void setFmUsdAmt(String fmUsdAmt) {
		this.fmUsdAmt = fmUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param fmExpnGrpAbbrNm1
	 */
	public void setFmExpnGrpAbbrNm1(String fmExpnGrpAbbrNm1) {
		this.fmExpnGrpAbbrNm1 = fmExpnGrpAbbrNm1;
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
	 * @param toAsgJulAmt
	 */
	public void setToAsgJulAmt(String toAsgJulAmt) {
		this.toAsgJulAmt = toAsgJulAmt;
	}
	
	/**
	 * Column Info
	 * @param fmExpnAbbrNm
	 */
	public void setFmExpnAbbrNm(String fmExpnAbbrNm) {
		this.fmExpnAbbrNm = fmExpnAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param toUsdKrwXchRt
	 */
	public void setToUsdKrwXchRt(String toUsdKrwXchRt) {
		this.toUsdKrwXchRt = toUsdKrwXchRt;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnCalcBssDesc
	 */
	public void setToGenExpnCalcBssDesc(String toGenExpnCalcBssDesc) {
		this.toGenExpnCalcBssDesc = toGenExpnCalcBssDesc;
	}
	
	/**
	 * Column Info
	 * @param fmRqAmt
	 */
	public void setFmRqAmt(String fmRqAmt) {
		this.fmRqAmt = fmRqAmt;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstTpCd
	 */
	public void setGenExpnRqstTpCd(String genExpnRqstTpCd) {
		this.genExpnRqstTpCd = genExpnRqstTpCd;
	}
	
	/**
	 * Column Info
	 * @param fmAsgJanAmt
	 */
	public void setFmAsgJanAmt(String fmAsgJanAmt) {
		this.fmAsgJanAmt = fmAsgJanAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToAsgOctAmt(JSPUtil.getParameter(request, "to_asg_oct_amt", ""));
		setToAsgNovAmt(JSPUtil.getParameter(request, "to_asg_nov_amt", ""));
		setFmGenExpnItmDesc(JSPUtil.getParameter(request, "fm_gen_expn_itm_desc", ""));
		setFmUtVal(JSPUtil.getParameter(request, "fm_ut_val", ""));
		setToUsdLoclXchRt(JSPUtil.getParameter(request, "to_usd_locl_xch_rt", ""));
		setToGenExpnCd(JSPUtil.getParameter(request, "to_gen_expn_cd", ""));
		setFmOfcCd(JSPUtil.getParameter(request, "fm_ofc_cd", ""));
		setToTicCd(JSPUtil.getParameter(request, "to_tic_cd", ""));
		setFmAsgJulAmt(JSPUtil.getParameter(request, "fm_asg_jul_amt", ""));
		setFmAsgFebAmt(JSPUtil.getParameter(request, "fm_asg_feb_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToCrntGenExpnAproStepCd(JSPUtil.getParameter(request, "to_crnt_gen_expn_apro_step_cd", ""));
		setToCrntGenExpnApstsCd(JSPUtil.getParameter(request, "to_crnt_gen_expn_apsts_cd", ""));
		setGenExpnRqstNo(JSPUtil.getParameter(request, "gen_expn_rqst_no", ""));
		setToAsgMarAmt(JSPUtil.getParameter(request, "to_asg_mar_amt", ""));
		setFmAdAmt(JSPUtil.getParameter(request, "fm_ad_amt", ""));
		setFmUsdKrwXchRt(JSPUtil.getParameter(request, "fm_usd_krw_xch_rt", ""));
		setFmRqstOfcCd(JSPUtil.getParameter(request, "fm_rqst_ofc_cd", ""));
		setFmAsgMarAmt(JSPUtil.getParameter(request, "fm_asg_mar_amt", ""));
		setFmTicCd(JSPUtil.getParameter(request, "fm_tic_cd", ""));
		setToAsgAprAmt(JSPUtil.getParameter(request, "to_asg_apr_amt", ""));
		setFmAsgSepAmt(JSPUtil.getParameter(request, "fm_asg_sep_amt", ""));
		setToAsgJunAmt(JSPUtil.getParameter(request, "to_asg_jun_amt", ""));
		setToGenExpnItemNo(JSPUtil.getParameter(request, "to_gen_expn_item_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setToRqstOpinRmk(JSPUtil.getParameter(request, "to_rqst_opin_rmk", ""));
		setToUsdAmt(JSPUtil.getParameter(request, "to_usd_amt", ""));
		setToAsgDecAmt(JSPUtil.getParameter(request, "to_asg_dec_amt", ""));
		setToOfcCd(JSPUtil.getParameter(request, "to_ofc_cd", ""));
		setToRqAmt(JSPUtil.getParameter(request, "to_rq_amt", ""));
		setFmCrntGenExpnAproStepCd(JSPUtil.getParameter(request, "fm_crnt_gen_expn_apro_step_cd", ""));
		setFmAsgAugAmt(JSPUtil.getParameter(request, "fm_asg_aug_amt", ""));
		setFmAsgOctAmt(JSPUtil.getParameter(request, "fm_asg_oct_amt", ""));
		setFmGenExpnItemNo(JSPUtil.getParameter(request, "fm_gen_expn_item_no", ""));
		setToLoclCurrCd(JSPUtil.getParameter(request, "to_locl_curr_cd", ""));
		setFmUsdLoclXchRt(JSPUtil.getParameter(request, "fm_usd_locl_xch_rt", ""));
		setToAsgAugAmt(JSPUtil.getParameter(request, "to_asg_aug_amt", ""));
		setToAsgFebAmt(JSPUtil.getParameter(request, "to_asg_feb_amt", ""));
		setFmAsgDecAmt(JSPUtil.getParameter(request, "fm_asg_dec_amt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setFmLoclCurrCd(JSPUtil.getParameter(request, "fm_locl_curr_cd", ""));
		setFmAdUsdAmt(JSPUtil.getParameter(request, "fm_ad_usd_amt", ""));
		setToGenExpnItmDesc(JSPUtil.getParameter(request, "to_gen_expn_itm_desc", ""));
		setFmAsgAprAmt(JSPUtil.getParameter(request, "fm_asg_apr_amt", ""));
		setFmGenExpnCd(JSPUtil.getParameter(request, "fm_gen_expn_cd", ""));
		setToAsgMayAmt(JSPUtil.getParameter(request, "to_asg_may_amt", ""));
		setFmAsgNovAmt(JSPUtil.getParameter(request, "fm_asg_nov_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToAsgJanAmt(JSPUtil.getParameter(request, "to_asg_jan_amt", ""));
		setToAdUsdAmt(JSPUtil.getParameter(request, "to_ad_usd_amt", ""));
		setToAdAmt(JSPUtil.getParameter(request, "to_ad_amt", ""));
		setToLoclKrwXchRt(JSPUtil.getParameter(request, "to_locl_krw_xch_rt", ""));
		setFmLoclKrwXchRt(JSPUtil.getParameter(request, "fm_locl_krw_xch_rt", ""));
		setFmAsgJunAmt(JSPUtil.getParameter(request, "fm_asg_jun_amt", ""));
		setFmRqstOpinRmk(JSPUtil.getParameter(request, "fm_rqst_opin_rmk", ""));
		setFmGenExpnCalcBssDesc(JSPUtil.getParameter(request, "fm_gen_expn_calc_bss_desc", ""));
		setFmAsgMayAmt(JSPUtil.getParameter(request, "fm_asg_may_amt", ""));
		setToExpnAbbrNm(JSPUtil.getParameter(request, "to_expn_abbr_nm", ""));
		setToUtVal(JSPUtil.getParameter(request, "to_ut_val", ""));
		setToAsgSepAmt(JSPUtil.getParameter(request, "to_asg_sep_amt", ""));
		setToExpnGrpAbbrNm1(JSPUtil.getParameter(request, "to_expn_grp_abbr_nm1", ""));
		setToExpnGrpAbbrNm2(JSPUtil.getParameter(request, "to_expn_grp_abbr_nm2", ""));
		setToRqstOfcCd(JSPUtil.getParameter(request, "to_rqst_ofc_cd", ""));
		setGemExpnGrpCd1(JSPUtil.getParameter(request, "gem_expn_grp_cd1", ""));
		setFmCrntGenExpnApstsCd(JSPUtil.getParameter(request, "fm_crnt_gen_expn_apsts_cd", ""));
		setGemExpnGrpCd2(JSPUtil.getParameter(request, "gem_expn_grp_cd2", ""));
		setFmExpnGrpAbbrNm2(JSPUtil.getParameter(request, "fm_expn_grp_abbr_nm2", ""));
		setFmUsdAmt(JSPUtil.getParameter(request, "fm_usd_amt", ""));
		setFmExpnGrpAbbrNm1(JSPUtil.getParameter(request, "fm_expn_grp_abbr_nm1", ""));
		setGenExpnRqstSeq(JSPUtil.getParameter(request, "gen_expn_rqst_seq", ""));
		setToAsgJulAmt(JSPUtil.getParameter(request, "to_asg_jul_amt", ""));
		setFmExpnAbbrNm(JSPUtil.getParameter(request, "fm_expn_abbr_nm", ""));
		setToUsdKrwXchRt(JSPUtil.getParameter(request, "to_usd_krw_xch_rt", ""));
		setToGenExpnCalcBssDesc(JSPUtil.getParameter(request, "to_gen_expn_calc_bss_desc", ""));
		setFmRqAmt(JSPUtil.getParameter(request, "fm_rq_amt", ""));
		setGenExpnRqstTpCd(JSPUtil.getParameter(request, "gen_expn_rqst_tp_cd", ""));
		setFmAsgJanAmt(JSPUtil.getParameter(request, "fm_asg_jan_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Report0025R1VO[]
	 */
	public Report0025R1VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Report0025R1VO[]
	 */
	public Report0025R1VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Report0025R1VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toAsgOctAmt = (JSPUtil.getParameter(request, prefix	+ "to_asg_oct_amt", length));
			String[] toAsgNovAmt = (JSPUtil.getParameter(request, prefix	+ "to_asg_nov_amt", length));
			String[] fmGenExpnItmDesc = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_itm_desc", length));
			String[] fmUtVal = (JSPUtil.getParameter(request, prefix	+ "fm_ut_val", length));
			String[] toUsdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "to_usd_locl_xch_rt", length));
			String[] toGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_cd", length));
			String[] fmOfcCd = (JSPUtil.getParameter(request, prefix	+ "fm_ofc_cd", length));
			String[] toTicCd = (JSPUtil.getParameter(request, prefix	+ "to_tic_cd", length));
			String[] fmAsgJulAmt = (JSPUtil.getParameter(request, prefix	+ "fm_asg_jul_amt", length));
			String[] fmAsgFebAmt = (JSPUtil.getParameter(request, prefix	+ "fm_asg_feb_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toCrntGenExpnAproStepCd = (JSPUtil.getParameter(request, prefix	+ "to_crnt_gen_expn_apro_step_cd", length));
			String[] toCrntGenExpnApstsCd = (JSPUtil.getParameter(request, prefix	+ "to_crnt_gen_expn_apsts_cd", length));
			String[] genExpnRqstNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no", length));
			String[] toAsgMarAmt = (JSPUtil.getParameter(request, prefix	+ "to_asg_mar_amt", length));
			String[] fmAdAmt = (JSPUtil.getParameter(request, prefix	+ "fm_ad_amt", length));
			String[] fmUsdKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "fm_usd_krw_xch_rt", length));
			String[] fmRqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_ofc_cd", length));
			String[] fmAsgMarAmt = (JSPUtil.getParameter(request, prefix	+ "fm_asg_mar_amt", length));
			String[] fmTicCd = (JSPUtil.getParameter(request, prefix	+ "fm_tic_cd", length));
			String[] toAsgAprAmt = (JSPUtil.getParameter(request, prefix	+ "to_asg_apr_amt", length));
			String[] fmAsgSepAmt = (JSPUtil.getParameter(request, prefix	+ "fm_asg_sep_amt", length));
			String[] toAsgJunAmt = (JSPUtil.getParameter(request, prefix	+ "to_asg_jun_amt", length));
			String[] toGenExpnItemNo = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_item_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] toRqstOpinRmk = (JSPUtil.getParameter(request, prefix	+ "to_rqst_opin_rmk", length));
			String[] toUsdAmt = (JSPUtil.getParameter(request, prefix	+ "to_usd_amt", length));
			String[] toAsgDecAmt = (JSPUtil.getParameter(request, prefix	+ "to_asg_dec_amt", length));
			String[] toOfcCd = (JSPUtil.getParameter(request, prefix	+ "to_ofc_cd", length));
			String[] toRqAmt = (JSPUtil.getParameter(request, prefix	+ "to_rq_amt", length));
			String[] fmCrntGenExpnAproStepCd = (JSPUtil.getParameter(request, prefix	+ "fm_crnt_gen_expn_apro_step_cd", length));
			String[] fmAsgAugAmt = (JSPUtil.getParameter(request, prefix	+ "fm_asg_aug_amt", length));
			String[] fmAsgOctAmt = (JSPUtil.getParameter(request, prefix	+ "fm_asg_oct_amt", length));
			String[] fmGenExpnItemNo = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_item_no", length));
			String[] toLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "to_locl_curr_cd", length));
			String[] fmUsdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "fm_usd_locl_xch_rt", length));
			String[] toAsgAugAmt = (JSPUtil.getParameter(request, prefix	+ "to_asg_aug_amt", length));
			String[] toAsgFebAmt = (JSPUtil.getParameter(request, prefix	+ "to_asg_feb_amt", length));
			String[] fmAsgDecAmt = (JSPUtil.getParameter(request, prefix	+ "fm_asg_dec_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fmLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "fm_locl_curr_cd", length));
			String[] fmAdUsdAmt = (JSPUtil.getParameter(request, prefix	+ "fm_ad_usd_amt", length));
			String[] toGenExpnItmDesc = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_itm_desc", length));
			String[] fmAsgAprAmt = (JSPUtil.getParameter(request, prefix	+ "fm_asg_apr_amt", length));
			String[] fmGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_cd", length));
			String[] toAsgMayAmt = (JSPUtil.getParameter(request, prefix	+ "to_asg_may_amt", length));
			String[] fmAsgNovAmt = (JSPUtil.getParameter(request, prefix	+ "fm_asg_nov_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toAsgJanAmt = (JSPUtil.getParameter(request, prefix	+ "to_asg_jan_amt", length));
			String[] toAdUsdAmt = (JSPUtil.getParameter(request, prefix	+ "to_ad_usd_amt", length));
			String[] toAdAmt = (JSPUtil.getParameter(request, prefix	+ "to_ad_amt", length));
			String[] toLoclKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "to_locl_krw_xch_rt", length));
			String[] fmLoclKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "fm_locl_krw_xch_rt", length));
			String[] fmAsgJunAmt = (JSPUtil.getParameter(request, prefix	+ "fm_asg_jun_amt", length));
			String[] fmRqstOpinRmk = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_opin_rmk", length));
			String[] fmGenExpnCalcBssDesc = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_calc_bss_desc", length));
			String[] fmAsgMayAmt = (JSPUtil.getParameter(request, prefix	+ "fm_asg_may_amt", length));
			String[] toExpnAbbrNm = (JSPUtil.getParameter(request, prefix	+ "to_expn_abbr_nm", length));
			String[] toUtVal = (JSPUtil.getParameter(request, prefix	+ "to_ut_val", length));
			String[] toAsgSepAmt = (JSPUtil.getParameter(request, prefix	+ "to_asg_sep_amt", length));
			String[] toExpnGrpAbbrNm1 = (JSPUtil.getParameter(request, prefix	+ "to_expn_grp_abbr_nm1", length));
			String[] toExpnGrpAbbrNm2 = (JSPUtil.getParameter(request, prefix	+ "to_expn_grp_abbr_nm2", length));
			String[] toRqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "to_rqst_ofc_cd", length));
			String[] gemExpnGrpCd1 = (JSPUtil.getParameter(request, prefix	+ "gem_expn_grp_cd1", length));
			String[] fmCrntGenExpnApstsCd = (JSPUtil.getParameter(request, prefix	+ "fm_crnt_gen_expn_apsts_cd", length));
			String[] gemExpnGrpCd2 = (JSPUtil.getParameter(request, prefix	+ "gem_expn_grp_cd2", length));
			String[] fmExpnGrpAbbrNm2 = (JSPUtil.getParameter(request, prefix	+ "fm_expn_grp_abbr_nm2", length));
			String[] fmUsdAmt = (JSPUtil.getParameter(request, prefix	+ "fm_usd_amt", length));
			String[] fmExpnGrpAbbrNm1 = (JSPUtil.getParameter(request, prefix	+ "fm_expn_grp_abbr_nm1", length));
			String[] genExpnRqstSeq = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_seq", length));
			String[] toAsgJulAmt = (JSPUtil.getParameter(request, prefix	+ "to_asg_jul_amt", length));
			String[] fmExpnAbbrNm = (JSPUtil.getParameter(request, prefix	+ "fm_expn_abbr_nm", length));
			String[] toUsdKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "to_usd_krw_xch_rt", length));
			String[] toGenExpnCalcBssDesc = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_calc_bss_desc", length));
			String[] fmRqAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rq_amt", length));
			String[] genExpnRqstTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_tp_cd", length));
			String[] fmAsgJanAmt = (JSPUtil.getParameter(request, prefix	+ "fm_asg_jan_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new Report0025R1VO();
				if (toAsgOctAmt[i] != null)
					model.setToAsgOctAmt(toAsgOctAmt[i]);
				if (toAsgNovAmt[i] != null)
					model.setToAsgNovAmt(toAsgNovAmt[i]);
				if (fmGenExpnItmDesc[i] != null)
					model.setFmGenExpnItmDesc(fmGenExpnItmDesc[i]);
				if (fmUtVal[i] != null)
					model.setFmUtVal(fmUtVal[i]);
				if (toUsdLoclXchRt[i] != null)
					model.setToUsdLoclXchRt(toUsdLoclXchRt[i]);
				if (toGenExpnCd[i] != null)
					model.setToGenExpnCd(toGenExpnCd[i]);
				if (fmOfcCd[i] != null)
					model.setFmOfcCd(fmOfcCd[i]);
				if (toTicCd[i] != null)
					model.setToTicCd(toTicCd[i]);
				if (fmAsgJulAmt[i] != null)
					model.setFmAsgJulAmt(fmAsgJulAmt[i]);
				if (fmAsgFebAmt[i] != null)
					model.setFmAsgFebAmt(fmAsgFebAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toCrntGenExpnAproStepCd[i] != null)
					model.setToCrntGenExpnAproStepCd(toCrntGenExpnAproStepCd[i]);
				if (toCrntGenExpnApstsCd[i] != null)
					model.setToCrntGenExpnApstsCd(toCrntGenExpnApstsCd[i]);
				if (genExpnRqstNo[i] != null)
					model.setGenExpnRqstNo(genExpnRqstNo[i]);
				if (toAsgMarAmt[i] != null)
					model.setToAsgMarAmt(toAsgMarAmt[i]);
				if (fmAdAmt[i] != null)
					model.setFmAdAmt(fmAdAmt[i]);
				if (fmUsdKrwXchRt[i] != null)
					model.setFmUsdKrwXchRt(fmUsdKrwXchRt[i]);
				if (fmRqstOfcCd[i] != null)
					model.setFmRqstOfcCd(fmRqstOfcCd[i]);
				if (fmAsgMarAmt[i] != null)
					model.setFmAsgMarAmt(fmAsgMarAmt[i]);
				if (fmTicCd[i] != null)
					model.setFmTicCd(fmTicCd[i]);
				if (toAsgAprAmt[i] != null)
					model.setToAsgAprAmt(toAsgAprAmt[i]);
				if (fmAsgSepAmt[i] != null)
					model.setFmAsgSepAmt(fmAsgSepAmt[i]);
				if (toAsgJunAmt[i] != null)
					model.setToAsgJunAmt(toAsgJunAmt[i]);
				if (toGenExpnItemNo[i] != null)
					model.setToGenExpnItemNo(toGenExpnItemNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (toRqstOpinRmk[i] != null)
					model.setToRqstOpinRmk(toRqstOpinRmk[i]);
				if (toUsdAmt[i] != null)
					model.setToUsdAmt(toUsdAmt[i]);
				if (toAsgDecAmt[i] != null)
					model.setToAsgDecAmt(toAsgDecAmt[i]);
				if (toOfcCd[i] != null)
					model.setToOfcCd(toOfcCd[i]);
				if (toRqAmt[i] != null)
					model.setToRqAmt(toRqAmt[i]);
				if (fmCrntGenExpnAproStepCd[i] != null)
					model.setFmCrntGenExpnAproStepCd(fmCrntGenExpnAproStepCd[i]);
				if (fmAsgAugAmt[i] != null)
					model.setFmAsgAugAmt(fmAsgAugAmt[i]);
				if (fmAsgOctAmt[i] != null)
					model.setFmAsgOctAmt(fmAsgOctAmt[i]);
				if (fmGenExpnItemNo[i] != null)
					model.setFmGenExpnItemNo(fmGenExpnItemNo[i]);
				if (toLoclCurrCd[i] != null)
					model.setToLoclCurrCd(toLoclCurrCd[i]);
				if (fmUsdLoclXchRt[i] != null)
					model.setFmUsdLoclXchRt(fmUsdLoclXchRt[i]);
				if (toAsgAugAmt[i] != null)
					model.setToAsgAugAmt(toAsgAugAmt[i]);
				if (toAsgFebAmt[i] != null)
					model.setToAsgFebAmt(toAsgFebAmt[i]);
				if (fmAsgDecAmt[i] != null)
					model.setFmAsgDecAmt(fmAsgDecAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fmLoclCurrCd[i] != null)
					model.setFmLoclCurrCd(fmLoclCurrCd[i]);
				if (fmAdUsdAmt[i] != null)
					model.setFmAdUsdAmt(fmAdUsdAmt[i]);
				if (toGenExpnItmDesc[i] != null)
					model.setToGenExpnItmDesc(toGenExpnItmDesc[i]);
				if (fmAsgAprAmt[i] != null)
					model.setFmAsgAprAmt(fmAsgAprAmt[i]);
				if (fmGenExpnCd[i] != null)
					model.setFmGenExpnCd(fmGenExpnCd[i]);
				if (toAsgMayAmt[i] != null)
					model.setToAsgMayAmt(toAsgMayAmt[i]);
				if (fmAsgNovAmt[i] != null)
					model.setFmAsgNovAmt(fmAsgNovAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toAsgJanAmt[i] != null)
					model.setToAsgJanAmt(toAsgJanAmt[i]);
				if (toAdUsdAmt[i] != null)
					model.setToAdUsdAmt(toAdUsdAmt[i]);
				if (toAdAmt[i] != null)
					model.setToAdAmt(toAdAmt[i]);
				if (toLoclKrwXchRt[i] != null)
					model.setToLoclKrwXchRt(toLoclKrwXchRt[i]);
				if (fmLoclKrwXchRt[i] != null)
					model.setFmLoclKrwXchRt(fmLoclKrwXchRt[i]);
				if (fmAsgJunAmt[i] != null)
					model.setFmAsgJunAmt(fmAsgJunAmt[i]);
				if (fmRqstOpinRmk[i] != null)
					model.setFmRqstOpinRmk(fmRqstOpinRmk[i]);
				if (fmGenExpnCalcBssDesc[i] != null)
					model.setFmGenExpnCalcBssDesc(fmGenExpnCalcBssDesc[i]);
				if (fmAsgMayAmt[i] != null)
					model.setFmAsgMayAmt(fmAsgMayAmt[i]);
				if (toExpnAbbrNm[i] != null)
					model.setToExpnAbbrNm(toExpnAbbrNm[i]);
				if (toUtVal[i] != null)
					model.setToUtVal(toUtVal[i]);
				if (toAsgSepAmt[i] != null)
					model.setToAsgSepAmt(toAsgSepAmt[i]);
				if (toExpnGrpAbbrNm1[i] != null)
					model.setToExpnGrpAbbrNm1(toExpnGrpAbbrNm1[i]);
				if (toExpnGrpAbbrNm2[i] != null)
					model.setToExpnGrpAbbrNm2(toExpnGrpAbbrNm2[i]);
				if (toRqstOfcCd[i] != null)
					model.setToRqstOfcCd(toRqstOfcCd[i]);
				if (gemExpnGrpCd1[i] != null)
					model.setGemExpnGrpCd1(gemExpnGrpCd1[i]);
				if (fmCrntGenExpnApstsCd[i] != null)
					model.setFmCrntGenExpnApstsCd(fmCrntGenExpnApstsCd[i]);
				if (gemExpnGrpCd2[i] != null)
					model.setGemExpnGrpCd2(gemExpnGrpCd2[i]);
				if (fmExpnGrpAbbrNm2[i] != null)
					model.setFmExpnGrpAbbrNm2(fmExpnGrpAbbrNm2[i]);
				if (fmUsdAmt[i] != null)
					model.setFmUsdAmt(fmUsdAmt[i]);
				if (fmExpnGrpAbbrNm1[i] != null)
					model.setFmExpnGrpAbbrNm1(fmExpnGrpAbbrNm1[i]);
				if (genExpnRqstSeq[i] != null)
					model.setGenExpnRqstSeq(genExpnRqstSeq[i]);
				if (toAsgJulAmt[i] != null)
					model.setToAsgJulAmt(toAsgJulAmt[i]);
				if (fmExpnAbbrNm[i] != null)
					model.setFmExpnAbbrNm(fmExpnAbbrNm[i]);
				if (toUsdKrwXchRt[i] != null)
					model.setToUsdKrwXchRt(toUsdKrwXchRt[i]);
				if (toGenExpnCalcBssDesc[i] != null)
					model.setToGenExpnCalcBssDesc(toGenExpnCalcBssDesc[i]);
				if (fmRqAmt[i] != null)
					model.setFmRqAmt(fmRqAmt[i]);
				if (genExpnRqstTpCd[i] != null)
					model.setGenExpnRqstTpCd(genExpnRqstTpCd[i]);
				if (fmAsgJanAmt[i] != null)
					model.setFmAsgJanAmt(fmAsgJanAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReport0025R1VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Report0025R1VO[]
	 */
	public Report0025R1VO[] getReport0025R1VOs(){
		Report0025R1VO[] vos = (Report0025R1VO[])models.toArray(new Report0025R1VO[models.size()]);
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
		this.toAsgOctAmt = this.toAsgOctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAsgNovAmt = this.toAsgNovAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnItmDesc = this.fmGenExpnItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmUtVal = this.fmUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toUsdLoclXchRt = this.toUsdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnCd = this.toGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmOfcCd = this.fmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTicCd = this.toTicCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAsgJulAmt = this.fmAsgJulAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAsgFebAmt = this.fmAsgFebAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCrntGenExpnAproStepCd = this.toCrntGenExpnAproStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCrntGenExpnApstsCd = this.toCrntGenExpnApstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo = this.genExpnRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAsgMarAmt = this.toAsgMarAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAdAmt = this.fmAdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmUsdKrwXchRt = this.fmUsdKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstOfcCd = this.fmRqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAsgMarAmt = this.fmAsgMarAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTicCd = this.fmTicCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAsgAprAmt = this.toAsgAprAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAsgSepAmt = this.fmAsgSepAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAsgJunAmt = this.toAsgJunAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnItemNo = this.toGenExpnItemNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstOpinRmk = this.toRqstOpinRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toUsdAmt = this.toUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAsgDecAmt = this.toAsgDecAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOfcCd = this.toOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqAmt = this.toRqAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCrntGenExpnAproStepCd = this.fmCrntGenExpnAproStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAsgAugAmt = this.fmAsgAugAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAsgOctAmt = this.fmAsgOctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnItemNo = this.fmGenExpnItemNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLoclCurrCd = this.toLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmUsdLoclXchRt = this.fmUsdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAsgAugAmt = this.toAsgAugAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAsgFebAmt = this.toAsgFebAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAsgDecAmt = this.fmAsgDecAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLoclCurrCd = this.fmLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAdUsdAmt = this.fmAdUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnItmDesc = this.toGenExpnItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAsgAprAmt = this.fmAsgAprAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnCd = this.fmGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAsgMayAmt = this.toAsgMayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAsgNovAmt = this.fmAsgNovAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAsgJanAmt = this.toAsgJanAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAdUsdAmt = this.toAdUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAdAmt = this.toAdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLoclKrwXchRt = this.toLoclKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLoclKrwXchRt = this.fmLoclKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAsgJunAmt = this.fmAsgJunAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstOpinRmk = this.fmRqstOpinRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnCalcBssDesc = this.fmGenExpnCalcBssDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAsgMayAmt = this.fmAsgMayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toExpnAbbrNm = this.toExpnAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toUtVal = this.toUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAsgSepAmt = this.toAsgSepAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toExpnGrpAbbrNm1 = this.toExpnGrpAbbrNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toExpnGrpAbbrNm2 = this.toExpnGrpAbbrNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstOfcCd = this.toRqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gemExpnGrpCd1 = this.gemExpnGrpCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCrntGenExpnApstsCd = this.fmCrntGenExpnApstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gemExpnGrpCd2 = this.gemExpnGrpCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmExpnGrpAbbrNm2 = this.fmExpnGrpAbbrNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmUsdAmt = this.fmUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmExpnGrpAbbrNm1 = this.fmExpnGrpAbbrNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstSeq = this.genExpnRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAsgJulAmt = this.toAsgJulAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmExpnAbbrNm = this.fmExpnAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toUsdKrwXchRt = this.toUsdKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnCalcBssDesc = this.toGenExpnCalcBssDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqAmt = this.fmRqAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstTpCd = this.genExpnRqstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAsgJanAmt = this.fmAsgJanAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
