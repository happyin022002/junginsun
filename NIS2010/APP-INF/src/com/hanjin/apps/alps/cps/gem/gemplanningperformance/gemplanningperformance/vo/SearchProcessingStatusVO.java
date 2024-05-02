/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchProcessingStatusVO.java
*@FileTitle : SearchProcessingStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.07.28 진윤오 
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

public class SearchProcessingStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchProcessingStatusVO> models = new ArrayList<SearchProcessingStatusVO>();
	
	/* Column Info */
	private String toLoclCurrCd = null;
	/* Column Info */
	private String fmUsdLoclXchRt = null;
	/* Column Info */
	private String fmGenExpnItmDesc = null;
	/* Column Info */
	private String crntGenExpnAproStepCd = null;
	/* Column Info */
	private String fmEngAbbrNm = null;
	/* Column Info */
	private String toUsdLoclXchRt = null;
	/* Column Info */
	private String fmUtVal = null;
	/* Column Info */
	private String toGenExpnCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fmLoclCurrCd = null;
	/* Column Info */
	private String toGenExpnItmDesc = null;
	/* Column Info */
	private String fmOfcCd = null;
	/* Column Info */
	private String fmGenExpnCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String genExpnRqstNo = null;
	/* Column Info */
	private String toLoclKrwXchRt = null;
	/* Column Info */
	private String toAdAmt = null;
	/* Column Info */
	private String fmGenExpnItmNo = null;
	/* Column Info */
	private String ap2 = null;
	/* Column Info */
	private String ap1 = null;
	/* Column Info */
	private String fmAdAmt = null;
	/* Column Info */
	private String fmUsdKrwXchRt = null;
	/* Column Info */
	private String fmLoclKrwXchRt = null;
	/* Column Info */
	private String ap4 = null;
	/* Column Info */
	private String ap3 = null;
	/* Column Info */
	private String toEngAbbrNm = null;
	/* Column Info */
	private String toGenExpnItmNo = null;
	/* Column Info */
	private String genExpnAproAuthOfcCd = null;
	/* Column Info */
	private String crntGenExpnApstsCd = null;
	/* Column Info */
	private String toUtVal = null;
	/* Column Info */
	private String toKrnAbbrNm = null;
	/* Column Info */
	private String fmKrnAbbrNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String toOfcCd = null;
	/* Column Info */
	private String genExpnRqstSeq = null;
	/* Column Info */
	private String toUsdKrwXchRt = null;
	/* Column Info */
	private String toRqAmt = null;
	/* Column Info */
	private String fmRqAmt = null;
	/* Column Info */
	private String genExpnRqstTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchProcessingStatusVO() {}

	public SearchProcessingStatusVO(String ibflag, String pagerows, String genExpnRqstNo, String genExpnRqstSeq, String fmGenExpnCd, String toGenExpnCd, String fmGenExpnItmNo, String toGenExpnItmNo, String fmGenExpnItmDesc, String toGenExpnItmDesc, String fmOfcCd, String toOfcCd, String rqstOfcCd, String fmRqAmt, String toRqAmt, String fmAdAmt, String toAdAmt, String crntGenExpnAproStepCd, String crntGenExpnApstsCd, String ap1, String ap2, String ap3, String ap4, String creUsrId, String genExpnRqstTpCd, String genExpnAproAuthOfcCd, String fmLoclCurrCd, String toLoclCurrCd, String fmUtVal, String toUtVal, String fmUsdLoclXchRt, String fmLoclKrwXchRt, String fmUsdKrwXchRt, String toUsdLoclXchRt, String toLoclKrwXchRt, String toUsdKrwXchRt, String creDt, String fmEngAbbrNm, String toEngAbbrNm, String fmKrnAbbrNm, String toKrnAbbrNm) {
		this.toLoclCurrCd = toLoclCurrCd;
		this.fmUsdLoclXchRt = fmUsdLoclXchRt;
		this.fmGenExpnItmDesc = fmGenExpnItmDesc;
		this.crntGenExpnAproStepCd = crntGenExpnAproStepCd;
		this.fmEngAbbrNm = fmEngAbbrNm;
		this.toUsdLoclXchRt = toUsdLoclXchRt;
		this.fmUtVal = fmUtVal;
		this.toGenExpnCd = toGenExpnCd;
		this.creDt = creDt;
		this.fmLoclCurrCd = fmLoclCurrCd;
		this.toGenExpnItmDesc = toGenExpnItmDesc;
		this.fmOfcCd = fmOfcCd;
		this.fmGenExpnCd = fmGenExpnCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.genExpnRqstNo = genExpnRqstNo;
		this.toLoclKrwXchRt = toLoclKrwXchRt;
		this.toAdAmt = toAdAmt;
		this.fmGenExpnItmNo = fmGenExpnItmNo;
		this.ap2 = ap2;
		this.ap1 = ap1;
		this.fmAdAmt = fmAdAmt;
		this.fmUsdKrwXchRt = fmUsdKrwXchRt;
		this.fmLoclKrwXchRt = fmLoclKrwXchRt;
		this.ap4 = ap4;
		this.ap3 = ap3;
		this.toEngAbbrNm = toEngAbbrNm;
		this.toGenExpnItmNo = toGenExpnItmNo;
		this.genExpnAproAuthOfcCd = genExpnAproAuthOfcCd;
		this.crntGenExpnApstsCd = crntGenExpnApstsCd;
		this.toUtVal = toUtVal;
		this.toKrnAbbrNm = toKrnAbbrNm;
		this.fmKrnAbbrNm = fmKrnAbbrNm;
		this.creUsrId = creUsrId;
		this.rqstOfcCd = rqstOfcCd;
		this.toOfcCd = toOfcCd;
		this.genExpnRqstSeq = genExpnRqstSeq;
		this.toUsdKrwXchRt = toUsdKrwXchRt;
		this.toRqAmt = toRqAmt;
		this.fmRqAmt = fmRqAmt;
		this.genExpnRqstTpCd = genExpnRqstTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_locl_curr_cd", getToLoclCurrCd());
		this.hashColumns.put("fm_usd_locl_xch_rt", getFmUsdLoclXchRt());
		this.hashColumns.put("fm_gen_expn_itm_desc", getFmGenExpnItmDesc());
		this.hashColumns.put("crnt_gen_expn_apro_step_cd", getCrntGenExpnAproStepCd());
		this.hashColumns.put("fm_eng_abbr_nm", getFmEngAbbrNm());
		this.hashColumns.put("to_usd_locl_xch_rt", getToUsdLoclXchRt());
		this.hashColumns.put("fm_ut_val", getFmUtVal());
		this.hashColumns.put("to_gen_expn_cd", getToGenExpnCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("fm_locl_curr_cd", getFmLoclCurrCd());
		this.hashColumns.put("to_gen_expn_itm_desc", getToGenExpnItmDesc());
		this.hashColumns.put("fm_ofc_cd", getFmOfcCd());
		this.hashColumns.put("fm_gen_expn_cd", getFmGenExpnCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gen_expn_rqst_no", getGenExpnRqstNo());
		this.hashColumns.put("to_locl_krw_xch_rt", getToLoclKrwXchRt());
		this.hashColumns.put("to_ad_amt", getToAdAmt());
		this.hashColumns.put("fm_gen_expn_itm_no", getFmGenExpnItmNo());
		this.hashColumns.put("ap2", getAp2());
		this.hashColumns.put("ap1", getAp1());
		this.hashColumns.put("fm_ad_amt", getFmAdAmt());
		this.hashColumns.put("fm_usd_krw_xch_rt", getFmUsdKrwXchRt());
		this.hashColumns.put("fm_locl_krw_xch_rt", getFmLoclKrwXchRt());
		this.hashColumns.put("ap4", getAp4());
		this.hashColumns.put("ap3", getAp3());
		this.hashColumns.put("to_eng_abbr_nm", getToEngAbbrNm());
		this.hashColumns.put("to_gen_expn_itm_no", getToGenExpnItmNo());
		this.hashColumns.put("gen_expn_apro_auth_ofc_cd", getGenExpnAproAuthOfcCd());
		this.hashColumns.put("crnt_gen_expn_apsts_cd", getCrntGenExpnApstsCd());
		this.hashColumns.put("to_ut_val", getToUtVal());
		this.hashColumns.put("to_krn_abbr_nm", getToKrnAbbrNm());
		this.hashColumns.put("fm_krn_abbr_nm", getFmKrnAbbrNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("to_ofc_cd", getToOfcCd());
		this.hashColumns.put("gen_expn_rqst_seq", getGenExpnRqstSeq());
		this.hashColumns.put("to_usd_krw_xch_rt", getToUsdKrwXchRt());
		this.hashColumns.put("to_rq_amt", getToRqAmt());
		this.hashColumns.put("fm_rq_amt", getFmRqAmt());
		this.hashColumns.put("gen_expn_rqst_tp_cd", getGenExpnRqstTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_locl_curr_cd", "toLoclCurrCd");
		this.hashFields.put("fm_usd_locl_xch_rt", "fmUsdLoclXchRt");
		this.hashFields.put("fm_gen_expn_itm_desc", "fmGenExpnItmDesc");
		this.hashFields.put("crnt_gen_expn_apro_step_cd", "crntGenExpnAproStepCd");
		this.hashFields.put("fm_eng_abbr_nm", "fmEngAbbrNm");
		this.hashFields.put("to_usd_locl_xch_rt", "toUsdLoclXchRt");
		this.hashFields.put("fm_ut_val", "fmUtVal");
		this.hashFields.put("to_gen_expn_cd", "toGenExpnCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("fm_locl_curr_cd", "fmLoclCurrCd");
		this.hashFields.put("to_gen_expn_itm_desc", "toGenExpnItmDesc");
		this.hashFields.put("fm_ofc_cd", "fmOfcCd");
		this.hashFields.put("fm_gen_expn_cd", "fmGenExpnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gen_expn_rqst_no", "genExpnRqstNo");
		this.hashFields.put("to_locl_krw_xch_rt", "toLoclKrwXchRt");
		this.hashFields.put("to_ad_amt", "toAdAmt");
		this.hashFields.put("fm_gen_expn_itm_no", "fmGenExpnItmNo");
		this.hashFields.put("ap2", "ap2");
		this.hashFields.put("ap1", "ap1");
		this.hashFields.put("fm_ad_amt", "fmAdAmt");
		this.hashFields.put("fm_usd_krw_xch_rt", "fmUsdKrwXchRt");
		this.hashFields.put("fm_locl_krw_xch_rt", "fmLoclKrwXchRt");
		this.hashFields.put("ap4", "ap4");
		this.hashFields.put("ap3", "ap3");
		this.hashFields.put("to_eng_abbr_nm", "toEngAbbrNm");
		this.hashFields.put("to_gen_expn_itm_no", "toGenExpnItmNo");
		this.hashFields.put("gen_expn_apro_auth_ofc_cd", "genExpnAproAuthOfcCd");
		this.hashFields.put("crnt_gen_expn_apsts_cd", "crntGenExpnApstsCd");
		this.hashFields.put("to_ut_val", "toUtVal");
		this.hashFields.put("to_krn_abbr_nm", "toKrnAbbrNm");
		this.hashFields.put("fm_krn_abbr_nm", "fmKrnAbbrNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("to_ofc_cd", "toOfcCd");
		this.hashFields.put("gen_expn_rqst_seq", "genExpnRqstSeq");
		this.hashFields.put("to_usd_krw_xch_rt", "toUsdKrwXchRt");
		this.hashFields.put("to_rq_amt", "toRqAmt");
		this.hashFields.put("fm_rq_amt", "fmRqAmt");
		this.hashFields.put("gen_expn_rqst_tp_cd", "genExpnRqstTpCd");
		return this.hashFields;
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
	 * @return fmGenExpnItmDesc
	 */
	public String getFmGenExpnItmDesc() {
		return this.fmGenExpnItmDesc;
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
	 * @return fmEngAbbrNm
	 */
	public String getFmEngAbbrNm() {
		return this.fmEngAbbrNm;
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
	 * @return fmUtVal
	 */
	public String getFmUtVal() {
		return this.fmUtVal;
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
	 * @return toGenExpnItmDesc
	 */
	public String getToGenExpnItmDesc() {
		return this.toGenExpnItmDesc;
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
	 * @return fmGenExpnCd
	 */
	public String getFmGenExpnCd() {
		return this.fmGenExpnCd;
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
	 * @return genExpnRqstNo
	 */
	public String getGenExpnRqstNo() {
		return this.genExpnRqstNo;
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
	 * @return toAdAmt
	 */
	public String getToAdAmt() {
		return this.toAdAmt;
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
	 * @return ap2
	 */
	public String getAp2() {
		return this.ap2;
	}
	
	/**
	 * Column Info
	 * @return ap1
	 */
	public String getAp1() {
		return this.ap1;
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
	 * @return fmLoclKrwXchRt
	 */
	public String getFmLoclKrwXchRt() {
		return this.fmLoclKrwXchRt;
	}
	
	/**
	 * Column Info
	 * @return ap4
	 */
	public String getAp4() {
		return this.ap4;
	}
	
	/**
	 * Column Info
	 * @return ap3
	 */
	public String getAp3() {
		return this.ap3;
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
	 * @return toGenExpnItmNo
	 */
	public String getToGenExpnItmNo() {
		return this.toGenExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @return genExpnAproAuthOfcCd
	 */
	public String getGenExpnAproAuthOfcCd() {
		return this.genExpnAproAuthOfcCd;
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
	 * @return toUtVal
	 */
	public String getToUtVal() {
		return this.toUtVal;
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
	 * @return fmKrnAbbrNm
	 */
	public String getFmKrnAbbrNm() {
		return this.fmKrnAbbrNm;
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
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
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
	 * @return genExpnRqstSeq
	 */
	public String getGenExpnRqstSeq() {
		return this.genExpnRqstSeq;
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
	 * @return toRqAmt
	 */
	public String getToRqAmt() {
		return this.toRqAmt;
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
	 * @param fmGenExpnItmDesc
	 */
	public void setFmGenExpnItmDesc(String fmGenExpnItmDesc) {
		this.fmGenExpnItmDesc = fmGenExpnItmDesc;
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
	 * @param fmEngAbbrNm
	 */
	public void setFmEngAbbrNm(String fmEngAbbrNm) {
		this.fmEngAbbrNm = fmEngAbbrNm;
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
	 * @param fmUtVal
	 */
	public void setFmUtVal(String fmUtVal) {
		this.fmUtVal = fmUtVal;
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
	 * @param toGenExpnItmDesc
	 */
	public void setToGenExpnItmDesc(String toGenExpnItmDesc) {
		this.toGenExpnItmDesc = toGenExpnItmDesc;
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
	 * @param fmGenExpnCd
	 */
	public void setFmGenExpnCd(String fmGenExpnCd) {
		this.fmGenExpnCd = fmGenExpnCd;
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
	 * @param genExpnRqstNo
	 */
	public void setGenExpnRqstNo(String genExpnRqstNo) {
		this.genExpnRqstNo = genExpnRqstNo;
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
	 * @param toAdAmt
	 */
	public void setToAdAmt(String toAdAmt) {
		this.toAdAmt = toAdAmt;
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
	 * @param ap2
	 */
	public void setAp2(String ap2) {
		this.ap2 = ap2;
	}
	
	/**
	 * Column Info
	 * @param ap1
	 */
	public void setAp1(String ap1) {
		this.ap1 = ap1;
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
	 * @param fmLoclKrwXchRt
	 */
	public void setFmLoclKrwXchRt(String fmLoclKrwXchRt) {
		this.fmLoclKrwXchRt = fmLoclKrwXchRt;
	}
	
	/**
	 * Column Info
	 * @param ap4
	 */
	public void setAp4(String ap4) {
		this.ap4 = ap4;
	}
	
	/**
	 * Column Info
	 * @param ap3
	 */
	public void setAp3(String ap3) {
		this.ap3 = ap3;
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
	 * @param toGenExpnItmNo
	 */
	public void setToGenExpnItmNo(String toGenExpnItmNo) {
		this.toGenExpnItmNo = toGenExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @param genExpnAproAuthOfcCd
	 */
	public void setGenExpnAproAuthOfcCd(String genExpnAproAuthOfcCd) {
		this.genExpnAproAuthOfcCd = genExpnAproAuthOfcCd;
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
	 * @param toUtVal
	 */
	public void setToUtVal(String toUtVal) {
		this.toUtVal = toUtVal;
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
	 * @param fmKrnAbbrNm
	 */
	public void setFmKrnAbbrNm(String fmKrnAbbrNm) {
		this.fmKrnAbbrNm = fmKrnAbbrNm;
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
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
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
	 * @param genExpnRqstSeq
	 */
	public void setGenExpnRqstSeq(String genExpnRqstSeq) {
		this.genExpnRqstSeq = genExpnRqstSeq;
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
	 * @param toRqAmt
	 */
	public void setToRqAmt(String toRqAmt) {
		this.toRqAmt = toRqAmt;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToLoclCurrCd(JSPUtil.getParameter(request, "to_locl_curr_cd", ""));
		setFmUsdLoclXchRt(JSPUtil.getParameter(request, "fm_usd_locl_xch_rt", ""));
		setFmGenExpnItmDesc(JSPUtil.getParameter(request, "fm_gen_expn_itm_desc", ""));
		setCrntGenExpnAproStepCd(JSPUtil.getParameter(request, "crnt_gen_expn_apro_step_cd", ""));
		setFmEngAbbrNm(JSPUtil.getParameter(request, "fm_eng_abbr_nm", ""));
		setToUsdLoclXchRt(JSPUtil.getParameter(request, "to_usd_locl_xch_rt", ""));
		setFmUtVal(JSPUtil.getParameter(request, "fm_ut_val", ""));
		setToGenExpnCd(JSPUtil.getParameter(request, "to_gen_expn_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setFmLoclCurrCd(JSPUtil.getParameter(request, "fm_locl_curr_cd", ""));
		setToGenExpnItmDesc(JSPUtil.getParameter(request, "to_gen_expn_itm_desc", ""));
		setFmOfcCd(JSPUtil.getParameter(request, "fm_ofc_cd", ""));
		setFmGenExpnCd(JSPUtil.getParameter(request, "fm_gen_expn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGenExpnRqstNo(JSPUtil.getParameter(request, "gen_expn_rqst_no", ""));
		setToLoclKrwXchRt(JSPUtil.getParameter(request, "to_locl_krw_xch_rt", ""));
		setToAdAmt(JSPUtil.getParameter(request, "to_ad_amt", ""));
		setFmGenExpnItmNo(JSPUtil.getParameter(request, "fm_gen_expn_itm_no", ""));
		setAp2(JSPUtil.getParameter(request, "ap2", ""));
		setAp1(JSPUtil.getParameter(request, "ap1", ""));
		setFmAdAmt(JSPUtil.getParameter(request, "fm_ad_amt", ""));
		setFmUsdKrwXchRt(JSPUtil.getParameter(request, "fm_usd_krw_xch_rt", ""));
		setFmLoclKrwXchRt(JSPUtil.getParameter(request, "fm_locl_krw_xch_rt", ""));
		setAp4(JSPUtil.getParameter(request, "ap4", ""));
		setAp3(JSPUtil.getParameter(request, "ap3", ""));
		setToEngAbbrNm(JSPUtil.getParameter(request, "to_eng_abbr_nm", ""));
		setToGenExpnItmNo(JSPUtil.getParameter(request, "to_gen_expn_itm_no", ""));
		setGenExpnAproAuthOfcCd(JSPUtil.getParameter(request, "gen_expn_apro_auth_ofc_cd", ""));
		setCrntGenExpnApstsCd(JSPUtil.getParameter(request, "crnt_gen_expn_apsts_cd", ""));
		setToUtVal(JSPUtil.getParameter(request, "to_ut_val", ""));
		setToKrnAbbrNm(JSPUtil.getParameter(request, "to_krn_abbr_nm", ""));
		setFmKrnAbbrNm(JSPUtil.getParameter(request, "fm_krn_abbr_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, "rqst_ofc_cd", ""));
		setToOfcCd(JSPUtil.getParameter(request, "to_ofc_cd", ""));
		setGenExpnRqstSeq(JSPUtil.getParameter(request, "gen_expn_rqst_seq", ""));
		setToUsdKrwXchRt(JSPUtil.getParameter(request, "to_usd_krw_xch_rt", ""));
		setToRqAmt(JSPUtil.getParameter(request, "to_rq_amt", ""));
		setFmRqAmt(JSPUtil.getParameter(request, "fm_rq_amt", ""));
		setGenExpnRqstTpCd(JSPUtil.getParameter(request, "gen_expn_rqst_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchProcessingStatusVO[]
	 */
	public SearchProcessingStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchProcessingStatusVO[]
	 */
	public SearchProcessingStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchProcessingStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "to_locl_curr_cd", length));
			String[] fmUsdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "fm_usd_locl_xch_rt", length));
			String[] fmGenExpnItmDesc = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_itm_desc", length));
			String[] crntGenExpnAproStepCd = (JSPUtil.getParameter(request, prefix	+ "crnt_gen_expn_apro_step_cd", length));
			String[] fmEngAbbrNm = (JSPUtil.getParameter(request, prefix	+ "fm_eng_abbr_nm", length));
			String[] toUsdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "to_usd_locl_xch_rt", length));
			String[] fmUtVal = (JSPUtil.getParameter(request, prefix	+ "fm_ut_val", length));
			String[] toGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fmLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "fm_locl_curr_cd", length));
			String[] toGenExpnItmDesc = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_itm_desc", length));
			String[] fmOfcCd = (JSPUtil.getParameter(request, prefix	+ "fm_ofc_cd", length));
			String[] fmGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] genExpnRqstNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no", length));
			String[] toLoclKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "to_locl_krw_xch_rt", length));
			String[] toAdAmt = (JSPUtil.getParameter(request, prefix	+ "to_ad_amt", length));
			String[] fmGenExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_itm_no", length));
			String[] ap2 = (JSPUtil.getParameter(request, prefix	+ "ap2", length));
			String[] ap1 = (JSPUtil.getParameter(request, prefix	+ "ap1", length));
			String[] fmAdAmt = (JSPUtil.getParameter(request, prefix	+ "fm_ad_amt", length));
			String[] fmUsdKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "fm_usd_krw_xch_rt", length));
			String[] fmLoclKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "fm_locl_krw_xch_rt", length));
			String[] ap4 = (JSPUtil.getParameter(request, prefix	+ "ap4", length));
			String[] ap3 = (JSPUtil.getParameter(request, prefix	+ "ap3", length));
			String[] toEngAbbrNm = (JSPUtil.getParameter(request, prefix	+ "to_eng_abbr_nm", length));
			String[] toGenExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_itm_no", length));
			String[] genExpnAproAuthOfcCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_apro_auth_ofc_cd", length));
			String[] crntGenExpnApstsCd = (JSPUtil.getParameter(request, prefix	+ "crnt_gen_expn_apsts_cd", length));
			String[] toUtVal = (JSPUtil.getParameter(request, prefix	+ "to_ut_val", length));
			String[] toKrnAbbrNm = (JSPUtil.getParameter(request, prefix	+ "to_krn_abbr_nm", length));
			String[] fmKrnAbbrNm = (JSPUtil.getParameter(request, prefix	+ "fm_krn_abbr_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] toOfcCd = (JSPUtil.getParameter(request, prefix	+ "to_ofc_cd", length));
			String[] genExpnRqstSeq = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_seq", length));
			String[] toUsdKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "to_usd_krw_xch_rt", length));
			String[] toRqAmt = (JSPUtil.getParameter(request, prefix	+ "to_rq_amt", length));
			String[] fmRqAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rq_amt", length));
			String[] genExpnRqstTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchProcessingStatusVO();
				if (toLoclCurrCd[i] != null)
					model.setToLoclCurrCd(toLoclCurrCd[i]);
				if (fmUsdLoclXchRt[i] != null)
					model.setFmUsdLoclXchRt(fmUsdLoclXchRt[i]);
				if (fmGenExpnItmDesc[i] != null)
					model.setFmGenExpnItmDesc(fmGenExpnItmDesc[i]);
				if (crntGenExpnAproStepCd[i] != null)
					model.setCrntGenExpnAproStepCd(crntGenExpnAproStepCd[i]);
				if (fmEngAbbrNm[i] != null)
					model.setFmEngAbbrNm(fmEngAbbrNm[i]);
				if (toUsdLoclXchRt[i] != null)
					model.setToUsdLoclXchRt(toUsdLoclXchRt[i]);
				if (fmUtVal[i] != null)
					model.setFmUtVal(fmUtVal[i]);
				if (toGenExpnCd[i] != null)
					model.setToGenExpnCd(toGenExpnCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fmLoclCurrCd[i] != null)
					model.setFmLoclCurrCd(fmLoclCurrCd[i]);
				if (toGenExpnItmDesc[i] != null)
					model.setToGenExpnItmDesc(toGenExpnItmDesc[i]);
				if (fmOfcCd[i] != null)
					model.setFmOfcCd(fmOfcCd[i]);
				if (fmGenExpnCd[i] != null)
					model.setFmGenExpnCd(fmGenExpnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (genExpnRqstNo[i] != null)
					model.setGenExpnRqstNo(genExpnRqstNo[i]);
				if (toLoclKrwXchRt[i] != null)
					model.setToLoclKrwXchRt(toLoclKrwXchRt[i]);
				if (toAdAmt[i] != null)
					model.setToAdAmt(toAdAmt[i]);
				if (fmGenExpnItmNo[i] != null)
					model.setFmGenExpnItmNo(fmGenExpnItmNo[i]);
				if (ap2[i] != null)
					model.setAp2(ap2[i]);
				if (ap1[i] != null)
					model.setAp1(ap1[i]);
				if (fmAdAmt[i] != null)
					model.setFmAdAmt(fmAdAmt[i]);
				if (fmUsdKrwXchRt[i] != null)
					model.setFmUsdKrwXchRt(fmUsdKrwXchRt[i]);
				if (fmLoclKrwXchRt[i] != null)
					model.setFmLoclKrwXchRt(fmLoclKrwXchRt[i]);
				if (ap4[i] != null)
					model.setAp4(ap4[i]);
				if (ap3[i] != null)
					model.setAp3(ap3[i]);
				if (toEngAbbrNm[i] != null)
					model.setToEngAbbrNm(toEngAbbrNm[i]);
				if (toGenExpnItmNo[i] != null)
					model.setToGenExpnItmNo(toGenExpnItmNo[i]);
				if (genExpnAproAuthOfcCd[i] != null)
					model.setGenExpnAproAuthOfcCd(genExpnAproAuthOfcCd[i]);
				if (crntGenExpnApstsCd[i] != null)
					model.setCrntGenExpnApstsCd(crntGenExpnApstsCd[i]);
				if (toUtVal[i] != null)
					model.setToUtVal(toUtVal[i]);
				if (toKrnAbbrNm[i] != null)
					model.setToKrnAbbrNm(toKrnAbbrNm[i]);
				if (fmKrnAbbrNm[i] != null)
					model.setFmKrnAbbrNm(fmKrnAbbrNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (toOfcCd[i] != null)
					model.setToOfcCd(toOfcCd[i]);
				if (genExpnRqstSeq[i] != null)
					model.setGenExpnRqstSeq(genExpnRqstSeq[i]);
				if (toUsdKrwXchRt[i] != null)
					model.setToUsdKrwXchRt(toUsdKrwXchRt[i]);
				if (toRqAmt[i] != null)
					model.setToRqAmt(toRqAmt[i]);
				if (fmRqAmt[i] != null)
					model.setFmRqAmt(fmRqAmt[i]);
				if (genExpnRqstTpCd[i] != null)
					model.setGenExpnRqstTpCd(genExpnRqstTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchProcessingStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchProcessingStatusVO[]
	 */
	public SearchProcessingStatusVO[] getSearchProcessingStatusVOs(){
		SearchProcessingStatusVO[] vos = (SearchProcessingStatusVO[])models.toArray(new SearchProcessingStatusVO[models.size()]);
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
		this.toLoclCurrCd = this.toLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmUsdLoclXchRt = this.fmUsdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnItmDesc = this.fmGenExpnItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntGenExpnAproStepCd = this.crntGenExpnAproStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEngAbbrNm = this.fmEngAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toUsdLoclXchRt = this.toUsdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmUtVal = this.fmUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnCd = this.toGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLoclCurrCd = this.fmLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnItmDesc = this.toGenExpnItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmOfcCd = this.fmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnCd = this.fmGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo = this.genExpnRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLoclKrwXchRt = this.toLoclKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAdAmt = this.toAdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnItmNo = this.fmGenExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ap2 = this.ap2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ap1 = this.ap1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAdAmt = this.fmAdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmUsdKrwXchRt = this.fmUsdKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLoclKrwXchRt = this.fmLoclKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ap4 = this.ap4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ap3 = this.ap3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEngAbbrNm = this.toEngAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnItmNo = this.toGenExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnAproAuthOfcCd = this.genExpnAproAuthOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntGenExpnApstsCd = this.crntGenExpnApstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toUtVal = this.toUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toKrnAbbrNm = this.toKrnAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmKrnAbbrNm = this.fmKrnAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOfcCd = this.toOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstSeq = this.genExpnRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toUsdKrwXchRt = this.toUsdKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqAmt = this.toRqAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqAmt = this.fmRqAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstTpCd = this.genExpnRqstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
