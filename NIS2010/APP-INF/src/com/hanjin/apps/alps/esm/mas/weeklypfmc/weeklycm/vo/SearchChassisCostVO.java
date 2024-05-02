/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchChassisCostVO.java
*@FileTitle : SearchChassisCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.26
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.02.26 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchChassisCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchChassisCostVO> models = new ArrayList<SearchChassisCostVO>();
	
	/* Column Info */
	private String onChssAmt = null;
	/* Column Info */
	private String migAmt = null;
	/* Column Info */
	private String toYear = null;
	/* Column Info */
	private String costTpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String scnoScccd = null;
	/* Column Info */
	private String costTpCd = null;
	/* Column Info */
	private String fCostQtrCd = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String costTpBxRt = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String onStUtCost = null;
	/* Column Info */
	private String errCd = null;
	/* Column Info */
	private String costTpBxRtTtl = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String onStAmt = null;
	/* Column Info */
	private String comTtlAmt = null;
	/* Column Info */
	private String comSubTtl = null;
	/* Column Info */
	private String chssDrygAmt = null;
	/* Column Info */
	private String chssRmk = null;
	/* Column Info */
	private String errMsg = null;
	/* Column Info */
	private String fEffToYrmon = null;
	/* Column Info */
	private String crMmAmt = null;
	/* Column Info */
	private String pErrorCode = null;
	/* Column Info */
	private String costYrQtr = null;
	/* Column Info */
	private String revShrAmt = null;
	/* Column Info */
	private String fScno = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costQtrCd = null;
	/* Column Info */
	private String effToYrmon = null;
	/* Column Info */
	private String fEffFmYrmon = null;
	/* Column Info */
	private String bkgBxQty = null;
	/* Column Info */
	private String stndUtCost = null;
	/* Column Info */
	private String fYearmonth = null;
	/* Column Info */
	private String effFmYrmon = null;
	/* Column Info */
	private String comUtCost = null;
	/* Column Info */
	private String miscReBilAmt = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String frYear = null;
	/* Column Info */
	private String estmAmt = null;
	/* Column Info */
	private String fCostYr = null;
	/* Column Info */
	private String toQtr = null;
	/* Column Info */
	private String frQtr = null;
	/* Column Info */
	private String onTmlAmt = null; 
	/* Column Info */
	private String delChk = null;
	/* Column Info */
	private String comSubTtlAmt = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String tYearmonth = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchChassisCostVO() {}

	public SearchChassisCostVO(String ibflag, String pagerows, String onChssAmt, String migAmt, String toYear, String costTpNm, String scnoScccd, String costTpCd, String fCostQtrCd, String costYrmon, String costTpBxRt, String scNo, String cntCd, String userId, String onStUtCost, String errCd, String updUsrId, String onStAmt, String comTtlAmt, String comSubTtl, String chssDrygAmt, String chssRmk, String errMsg, String fEffToYrmon, String crMmAmt, String pErrorCode, String costYrQtr, String revShrAmt, String fScno, String effToYrmon, String coCd, String fEffFmYrmon, String bkgBxQty, String stndUtCost, String fYearmonth, String effFmYrmon, String comUtCost, String miscReBilAmt, String frYear, String estmAmt, String fCostYr, String toQtr, String frQtr, String onTmlAmt, String delChk, String comSubTtlAmt, String sccCd, String costYr, String tYearmonth, String costTpBxRtTtl, String costQtrCd) {
		this.onChssAmt = onChssAmt;
		this.migAmt = migAmt;
		this.toYear = toYear;
		this.costTpNm = costTpNm;
		this.pagerows = pagerows;
		this.scnoScccd = scnoScccd;
		this.costTpCd = costTpCd;
		this.fCostQtrCd = fCostQtrCd;
		this.costYrmon = costYrmon;
		this.costTpBxRt = costTpBxRt;
		this.scNo = scNo;
		this.userId = userId;
		this.cntCd = cntCd;
		this.onStUtCost = onStUtCost;
		this.errCd = errCd;
		this.costTpBxRtTtl = costTpBxRtTtl;
		this.updUsrId = updUsrId;
		this.onStAmt = onStAmt;
		this.comTtlAmt = comTtlAmt;
		this.comSubTtl = comSubTtl;
		this.chssDrygAmt = chssDrygAmt;
		this.chssRmk = chssRmk;
		this.errMsg = errMsg;
		this.fEffToYrmon = fEffToYrmon;
		this.crMmAmt = crMmAmt;
		this.pErrorCode = pErrorCode;
		this.costYrQtr = costYrQtr;
		this.revShrAmt = revShrAmt;
		this.fScno = fScno;
		this.ibflag = ibflag;
		this.costQtrCd = costQtrCd;
		this.effToYrmon = effToYrmon;
		this.fEffFmYrmon = fEffFmYrmon;
		this.bkgBxQty = bkgBxQty;
		this.stndUtCost = stndUtCost;
		this.fYearmonth = fYearmonth;
		this.effFmYrmon = effFmYrmon;
		this.comUtCost = comUtCost;
		this.miscReBilAmt = miscReBilAmt;
		this.coCd = coCd;
		this.frYear = frYear;
		this.estmAmt = estmAmt;
		this.fCostYr = fCostYr;
		this.toQtr = toQtr;
		this.frQtr = frQtr;
		this.onTmlAmt = onTmlAmt;
		this.delChk = delChk;
		this.comSubTtlAmt = comSubTtlAmt;
		this.sccCd = sccCd;
		this.costYr = costYr;
		this.tYearmonth = tYearmonth;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("on_chss_amt", getOnChssAmt());
		this.hashColumns.put("mig_amt", getMigAmt());
		this.hashColumns.put("to_year", getToYear());
		this.hashColumns.put("cost_tp_nm", getCostTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("scno_scccd", getScnoScccd());
		this.hashColumns.put("cost_tp_cd", getCostTpCd());
		this.hashColumns.put("f_cost_qtr_cd", getFCostQtrCd());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cost_tp_bx_rt", getCostTpBxRt());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("on_st_ut_cost", getOnStUtCost());
		this.hashColumns.put("err_cd", getErrCd());
		this.hashColumns.put("cost_tp_bx_rt_ttl", getCostTpBxRtTtl());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("on_st_amt", getOnStAmt());
		this.hashColumns.put("com_ttl_amt", getComTtlAmt());
		this.hashColumns.put("com_sub_ttl", getComSubTtl());
		this.hashColumns.put("chss_dryg_amt", getChssDrygAmt());
		this.hashColumns.put("chss_rmk", getChssRmk());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("f_eff_to_yrmon", getFEffToYrmon());
		this.hashColumns.put("cr_mm_amt", getCrMmAmt());
		this.hashColumns.put("p_error_code", getPErrorCode());
		this.hashColumns.put("cost_yr_qtr", getCostYrQtr());
		this.hashColumns.put("rev_shr_amt", getRevShrAmt());
		this.hashColumns.put("f_scno", getFScno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_qtr_cd", getCostQtrCd());
		this.hashColumns.put("eff_to_yrmon", getEffToYrmon());
		this.hashColumns.put("f_eff_fm_yrmon", getFEffFmYrmon());
		this.hashColumns.put("bkg_bx_qty", getBkgBxQty());
		this.hashColumns.put("stnd_ut_cost", getStndUtCost());
		this.hashColumns.put("f_yearmonth", getFYearmonth());
		this.hashColumns.put("eff_fm_yrmon", getEffFmYrmon());
		this.hashColumns.put("com_ut_cost", getComUtCost());
		this.hashColumns.put("misc_re_bil_amt", getMiscReBilAmt());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("fr_year", getFrYear());
		this.hashColumns.put("estm_amt", getEstmAmt());
		this.hashColumns.put("f_cost_yr", getFCostYr());
		this.hashColumns.put("to_qtr", getToQtr());
		this.hashColumns.put("fr_qtr", getFrQtr());
		this.hashColumns.put("on_tml_amt", getOnTmlAmt());
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("com_sub_ttl_amt", getComSubTtlAmt());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("t_yearmonth", getTYearmonth());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("on_chss_amt", "onChssAmt");
		this.hashFields.put("mig_amt", "migAmt");
		this.hashFields.put("to_year", "toYear");
		this.hashFields.put("cost_tp_nm", "costTpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("scno_scccd", "scnoScccd");
		this.hashFields.put("cost_tp_cd", "costTpCd");
		this.hashFields.put("f_cost_qtr_cd", "fCostQtrCd");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cost_tp_bx_rt", "costTpBxRt");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("on_st_ut_cost", "onStUtCost");
		this.hashFields.put("err_cd", "errCd");
		this.hashFields.put("cost_tp_bx_rt_ttl", "costTpBxRtTtl");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("on_st_amt", "onStAmt");
		this.hashFields.put("com_ttl_amt", "comTtlAmt");
		this.hashFields.put("com_sub_ttl", "comSubTtl");
		this.hashFields.put("chss_dryg_amt", "chssDrygAmt");
		this.hashFields.put("chss_rmk", "chssRmk");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("f_eff_to_yrmon", "fEffToYrmon");
		this.hashFields.put("cr_mm_amt", "crMmAmt");
		this.hashFields.put("p_error_code", "pErrorCode");
		this.hashFields.put("cost_yr_qtr", "costYrQtr");
		this.hashFields.put("rev_shr_amt", "revShrAmt");
		this.hashFields.put("f_scno", "fScno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_qtr_cd", "costQtrCd");
		this.hashFields.put("eff_to_yrmon", "effToYrmon");
		this.hashFields.put("f_eff_fm_yrmon", "fEffFmYrmon");
		this.hashFields.put("bkg_bx_qty", "bkgBxQty");
		this.hashFields.put("stnd_ut_cost", "stndUtCost");
		this.hashFields.put("f_yearmonth", "fYearmonth");
		this.hashFields.put("eff_fm_yrmon", "effFmYrmon");
		this.hashFields.put("com_ut_cost", "comUtCost");
		this.hashFields.put("misc_re_bil_amt", "miscReBilAmt");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("fr_year", "frYear");
		this.hashFields.put("estm_amt", "estmAmt");
		this.hashFields.put("f_cost_yr", "fCostYr");
		this.hashFields.put("to_qtr", "toQtr");
		this.hashFields.put("fr_qtr", "frQtr");
		this.hashFields.put("on_tml_amt", "onTmlAmt");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("com_sub_ttl_amt", "comSubTtlAmt");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("t_yearmonth", "tYearmonth");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return onChssAmt
	 */
	public String getOnChssAmt() {
		return this.onChssAmt;
	}
	
	/**
	 * Column Info
	 * @return migAmt
	 */
	public String getMigAmt() {
		return this.migAmt;
	}
	
	/**
	 * Column Info
	 * @return toYear
	 */
	public String getToYear() {
		return this.toYear;
	}
	
	/**
	 * Column Info
	 * @return costTpNm
	 */
	public String getCostTpNm() {
		return this.costTpNm;
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
	 * @return scnoScccd
	 */
	public String getScnoScccd() {
		return this.scnoScccd;
	}
	
	/**
	 * Column Info
	 * @return costTpCd
	 */
	public String getCostTpCd() {
		return this.costTpCd;
	}
	
	/**
	 * Column Info
	 * @return fCostQtrCd
	 */
	public String getFCostQtrCd() {
		return this.fCostQtrCd;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return costTpBxRt
	 */
	public String getCostTpBxRt() {
		return this.costTpBxRt;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return onStUtCost
	 */
	public String getOnStUtCost() {
		return this.onStUtCost;
	}
	
	/**
	 * Column Info
	 * @return errCd
	 */
	public String getErrCd() {
		return this.errCd;
	}
	
	/**
	 * Column Info
	 * @return costTpBxRtTtl
	 */
	public String getCostTpBxRtTtl() {
		return this.costTpBxRtTtl;
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
	 * @return onStAmt
	 */
	public String getOnStAmt() {
		return this.onStAmt;
	}
	
	/**
	 * Column Info
	 * @return comTtlAmt
	 */
	public String getComTtlAmt() {
		return this.comTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return comSubTtl
	 */
	public String getComSubTtl() {
		return this.comSubTtl;
	}
	
	/**
	 * Column Info
	 * @return chssDrygAmt
	 */
	public String getChssDrygAmt() {
		return this.chssDrygAmt;
	}
	
	/**
	 * Column Info
	 * @return chssRmk
	 */
	public String getChssRmk() {
		return this.chssRmk;
	}
	
	/**
	 * Column Info
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
	}
	
	/**
	 * Column Info
	 * @return fEffToYrmon
	 */
	public String getFEffToYrmon() {
		return this.fEffToYrmon;
	}
	
	/**
	 * Column Info
	 * @return crMmAmt
	 */
	public String getCrMmAmt() {
		return this.crMmAmt;
	}
	
	/**
	 * Column Info
	 * @return pErrorCode
	 */
	public String getPErrorCode() {
		return this.pErrorCode;
	}
	
	/**
	 * Column Info
	 * @return costYrQtr
	 */
	public String getCostYrQtr() {
		return this.costYrQtr;
	}
	
	/**
	 * Column Info
	 * @return revShrAmt
	 */
	public String getRevShrAmt() {
		return this.revShrAmt;
	}
	
	/**
	 * Column Info
	 * @return fScno
	 */
	public String getFScno() {
		return this.fScno;
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
	 * @return costQtrCd
	 */
	public String getCostQtrCd() {
		return this.costQtrCd;
	}
	
	/**
	 * Column Info
	 * @return effToYrmon
	 */
	public String getEffToYrmon() {
		return this.effToYrmon;
	}
	
	/**
	 * Column Info
	 * @return fEffFmYrmon
	 */
	public String getFEffFmYrmon() {
		return this.fEffFmYrmon;
	}
	
	/**
	 * Column Info
	 * @return bkgBxQty
	 */
	public String getBkgBxQty() {
		return this.bkgBxQty;
	}
	
	/**
	 * Column Info
	 * @return stndUtCost
	 */
	public String getStndUtCost() {
		return this.stndUtCost;
	}
	
	/**
	 * Column Info
	 * @return fYearmonth
	 */
	public String getFYearmonth() {
		return this.fYearmonth;
	}
	
	/**
	 * Column Info
	 * @return effFmYrmon
	 */
	public String getEffFmYrmon() {
		return this.effFmYrmon;
	}
	
	/**
	 * Column Info
	 * @return comUtCost
	 */
	public String getComUtCost() {
		return this.comUtCost;
	}
	
	/**
	 * Column Info
	 * @return miscReBilAmt
	 */
	public String getMiscReBilAmt() {
		return this.miscReBilAmt;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return frYear
	 */
	public String getFrYear() {
		return this.frYear;
	}
	
	/**
	 * Column Info
	 * @return estmAmt
	 */
	public String getEstmAmt() {
		return this.estmAmt;
	}
	
	/**
	 * Column Info
	 * @return fCostYr
	 */
	public String getFCostYr() {
		return this.fCostYr;
	}
	
	/**
	 * Column Info
	 * @return toQtr
	 */
	public String getToQtr() {
		return this.toQtr;
	}
	
	/**
	 * Column Info
	 * @return frQtr
	 */
	public String getFrQtr() {
		return this.frQtr;
	}
	
	/**
	 * Column Info
	 * @return onTmlAmt
	 */
	public String getOnTmlAmt() {
		return this.onTmlAmt;
	}
	
	/**
	 * Column Info
	 * @return delChk
	 */
	public String getDelChk() {
		return this.delChk;
	}
	
	/**
	 * Column Info
	 * @return comSubTtlAmt
	 */
	public String getComSubTtlAmt() {
		return this.comSubTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return costYr
	 */
	public String getCostYr() {
		return this.costYr;
	}
	
	/**
	 * Column Info
	 * @return tYearmonth
	 */
	public String getTYearmonth() {
		return this.tYearmonth;
	}
	

	/**
	 * Column Info
	 * @param onChssAmt
	 */
	public void setOnChssAmt(String onChssAmt) {
		this.onChssAmt = onChssAmt;
	}
	
	/**
	 * Column Info
	 * @param migAmt
	 */
	public void setMigAmt(String migAmt) {
		this.migAmt = migAmt;
	}
	
	/**
	 * Column Info
	 * @param toYear
	 */
	public void setToYear(String toYear) {
		this.toYear = toYear;
	}
	
	/**
	 * Column Info
	 * @param costTpNm
	 */
	public void setCostTpNm(String costTpNm) {
		this.costTpNm = costTpNm;
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
	 * @param scnoScccd
	 */
	public void setScnoScccd(String scnoScccd) {
		this.scnoScccd = scnoScccd;
	}
	
	/**
	 * Column Info
	 * @param costTpCd
	 */
	public void setCostTpCd(String costTpCd) {
		this.costTpCd = costTpCd;
	}
	
	/**
	 * Column Info
	 * @param fCostQtrCd
	 */
	public void setFCostQtrCd(String fCostQtrCd) {
		this.fCostQtrCd = fCostQtrCd;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param costTpBxRt
	 */
	public void setCostTpBxRt(String costTpBxRt) {
		this.costTpBxRt = costTpBxRt;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param onStUtCost
	 */
	public void setOnStUtCost(String onStUtCost) {
		this.onStUtCost = onStUtCost;
	}
	
	/**
	 * Column Info
	 * @param errCd
	 */
	public void setErrCd(String errCd) {
		this.errCd = errCd;
	}
	
	/**
	 * Column Info
	 * @param costTpBxRtTtl
	 */
	public void setCostTpBxRtTtl(String costTpBxRtTtl) {
		this.costTpBxRtTtl = costTpBxRtTtl;
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
	 * @param onStAmt
	 */
	public void setOnStAmt(String onStAmt) {
		this.onStAmt = onStAmt;
	}
	
	/**
	 * Column Info
	 * @param comTtlAmt
	 */
	public void setComTtlAmt(String comTtlAmt) {
		this.comTtlAmt = comTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param comSubTtl
	 */
	public void setComSubTtl(String comSubTtl) {
		this.comSubTtl = comSubTtl;
	}
	
	/**
	 * Column Info
	 * @param chssDrygAmt
	 */
	public void setChssDrygAmt(String chssDrygAmt) {
		this.chssDrygAmt = chssDrygAmt;
	}
	
	/**
	 * Column Info
	 * @param chssRmk
	 */
	public void setChssRmk(String chssRmk) {
		this.chssRmk = chssRmk;
	}
	
	/**
	 * Column Info
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	/**
	 * Column Info
	 * @param fEffToYrmon
	 */
	public void setFEffToYrmon(String fEffToYrmon) {
		this.fEffToYrmon = fEffToYrmon;
	}
	
	/**
	 * Column Info
	 * @param crMmAmt
	 */
	public void setCrMmAmt(String crMmAmt) {
		this.crMmAmt = crMmAmt;
	}
	
	/**
	 * Column Info
	 * @param pErrorCode
	 */
	public void setPErrorCode(String pErrorCode) {
		this.pErrorCode = pErrorCode;
	}
	
	/**
	 * Column Info
	 * @param costYrQtr
	 */
	public void setCostYrQtr(String costYrQtr) {
		this.costYrQtr = costYrQtr;
	}
	
	/**
	 * Column Info
	 * @param revShrAmt
	 */
	public void setRevShrAmt(String revShrAmt) {
		this.revShrAmt = revShrAmt;
	}
	
	/**
	 * Column Info
	 * @param fScno
	 */
	public void setFScno(String fScno) {
		this.fScno = fScno;
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
	 * @param costQtrCd
	 */
	public void setCostQtrCd(String costQtrCd) {
		this.costQtrCd = costQtrCd;
	}
	
	/**
	 * Column Info
	 * @param effToYrmon
	 */
	public void setEffToYrmon(String effToYrmon) {
		this.effToYrmon = effToYrmon;
	}
	
	/**
	 * Column Info
	 * @param fEffFmYrmon
	 */
	public void setFEffFmYrmon(String fEffFmYrmon) {
		this.fEffFmYrmon = fEffFmYrmon;
	}
	
	/**
	 * Column Info
	 * @param bkgBxQty
	 */
	public void setBkgBxQty(String bkgBxQty) {
		this.bkgBxQty = bkgBxQty;
	}
	
	/**
	 * Column Info
	 * @param stndUtCost
	 */
	public void setStndUtCost(String stndUtCost) {
		this.stndUtCost = stndUtCost;
	}
	
	/**
	 * Column Info
	 * @param fYearmonth
	 */
	public void setFYearmonth(String fYearmonth) {
		this.fYearmonth = fYearmonth;
	}
	
	/**
	 * Column Info
	 * @param effFmYrmon
	 */
	public void setEffFmYrmon(String effFmYrmon) {
		this.effFmYrmon = effFmYrmon;
	}
	
	/**
	 * Column Info
	 * @param comUtCost
	 */
	public void setComUtCost(String comUtCost) {
		this.comUtCost = comUtCost;
	}
	
	/**
	 * Column Info
	 * @param miscReBilAmt
	 */
	public void setMiscReBilAmt(String miscReBilAmt) {
		this.miscReBilAmt = miscReBilAmt;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param frYear
	 */
	public void setFrYear(String frYear) {
		this.frYear = frYear;
	}
	
	/**
	 * Column Info
	 * @param estmAmt
	 */
	public void setEstmAmt(String estmAmt) {
		this.estmAmt = estmAmt;
	}
	
	/**
	 * Column Info
	 * @param fCostYr
	 */
	public void setFCostYr(String fCostYr) {
		this.fCostYr = fCostYr;
	}
	
	/**
	 * Column Info
	 * @param toQtr
	 */
	public void setToQtr(String toQtr) {
		this.toQtr = toQtr;
	}
	
	/**
	 * Column Info
	 * @param frQtr
	 */
	public void setFrQtr(String frQtr) {
		this.frQtr = frQtr;
	}
	
	/**
	 * Column Info
	 * @param onTmlAmt
	 */
	public void setOnTmlAmt(String onTmlAmt) {
		this.onTmlAmt = onTmlAmt;
	}
	
	/**
	 * Column Info
	 * @param delChk
	 */
	public void setDelChk(String delChk) {
		this.delChk = delChk;
	}
	
	/**
	 * Column Info
	 * @param comSubTtlAmt
	 */
	public void setComSubTtlAmt(String comSubTtlAmt) {
		this.comSubTtlAmt = comSubTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param costYr
	 */
	public void setCostYr(String costYr) {
		this.costYr = costYr;
	}
	
	/**
	 * Column Info
	 * @param tYearmonth
	 */
	public void setTYearmonth(String tYearmonth) {
		this.tYearmonth = tYearmonth;
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
		setOnChssAmt(JSPUtil.getParameter(request, prefix + "on_chss_amt", ""));
		setMigAmt(JSPUtil.getParameter(request, prefix + "mig_amt", ""));
		setToYear(JSPUtil.getParameter(request, prefix + "to_year", ""));
		setCostTpNm(JSPUtil.getParameter(request, prefix + "cost_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setScnoScccd(JSPUtil.getParameter(request, prefix + "scno_scccd", ""));
		setCostTpCd(JSPUtil.getParameter(request, prefix + "cost_tp_cd", ""));
		setFCostQtrCd(JSPUtil.getParameter(request, prefix + "f_cost_qtr_cd", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setCostTpBxRt(JSPUtil.getParameter(request, prefix + "cost_tp_bx_rt", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setOnStUtCost(JSPUtil.getParameter(request, prefix + "on_st_ut_cost", ""));
		setErrCd(JSPUtil.getParameter(request, prefix + "err_cd", ""));
		setCostTpBxRtTtl(JSPUtil.getParameter(request, prefix + "cost_tp_bx_rt_ttl", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOnStAmt(JSPUtil.getParameter(request, prefix + "on_st_amt", ""));
		setComTtlAmt(JSPUtil.getParameter(request, prefix + "com_ttl_amt", ""));
		setComSubTtl(JSPUtil.getParameter(request, prefix + "com_sub_ttl", ""));
		setChssDrygAmt(JSPUtil.getParameter(request, prefix + "chss_dryg_amt", ""));
		setChssRmk(JSPUtil.getParameter(request, prefix + "chss_rmk", ""));
		setErrMsg(JSPUtil.getParameter(request, prefix + "err_msg", ""));
		setFEffToYrmon(JSPUtil.getParameter(request, prefix + "f_eff_to_yrmon", ""));
		setCrMmAmt(JSPUtil.getParameter(request, prefix + "cr_mm_amt", ""));
		setPErrorCode(JSPUtil.getParameter(request, prefix + "p_error_code", ""));
		setCostYrQtr(JSPUtil.getParameter(request, prefix + "cost_yr_qtr", ""));
		setRevShrAmt(JSPUtil.getParameter(request, prefix + "rev_shr_amt", ""));
		setFScno(JSPUtil.getParameter(request, prefix + "f_scno", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostQtrCd(JSPUtil.getParameter(request, prefix + "cost_qtr_cd", ""));
		setEffToYrmon(JSPUtil.getParameter(request, prefix + "eff_to_yrmon", ""));
		setFEffFmYrmon(JSPUtil.getParameter(request, prefix + "f_eff_fm_yrmon", ""));
		setBkgBxQty(JSPUtil.getParameter(request, prefix + "bkg_bx_qty", ""));
		setStndUtCost(JSPUtil.getParameter(request, prefix + "stnd_ut_cost", ""));
		setFYearmonth(JSPUtil.getParameter(request, prefix + "f_yearmonth", ""));
		setEffFmYrmon(JSPUtil.getParameter(request, prefix + "eff_fm_yrmon", ""));
		setComUtCost(JSPUtil.getParameter(request, prefix + "com_ut_cost", ""));
		setMiscReBilAmt(JSPUtil.getParameter(request, prefix + "misc_re_bil_amt", ""));
		setCoCd(JSPUtil.getParameter(request, prefix + "co_cd", ""));
		setFrYear(JSPUtil.getParameter(request, prefix + "fr_year", ""));
		setEstmAmt(JSPUtil.getParameter(request, prefix + "estm_amt", ""));
		setFCostYr(JSPUtil.getParameter(request, prefix + "f_cost_yr", ""));
		setToQtr(JSPUtil.getParameter(request, prefix + "to_qtr", ""));
		setFrQtr(JSPUtil.getParameter(request, prefix + "fr_qtr", ""));
		setOnTmlAmt(JSPUtil.getParameter(request, prefix + "on_tml_amt", ""));
		setDelChk(JSPUtil.getParameter(request, prefix + "del_chk", ""));
		setComSubTtlAmt(JSPUtil.getParameter(request, prefix + "com_sub_ttl_amt", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setCostYr(JSPUtil.getParameter(request, prefix + "cost_yr", ""));
		setTYearmonth(JSPUtil.getParameter(request, prefix + "t_yearmonth", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchChassisCostVO[]
	 */
	public SearchChassisCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchChassisCostVO[]
	 */
	public SearchChassisCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchChassisCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] onChssAmt = (JSPUtil.getParameter(request, prefix	+ "on_chss_amt", length));
			String[] migAmt = (JSPUtil.getParameter(request, prefix	+ "mig_amt", length));
			String[] toYear = (JSPUtil.getParameter(request, prefix	+ "to_year", length));
			String[] costTpNm = (JSPUtil.getParameter(request, prefix	+ "cost_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] scnoScccd = (JSPUtil.getParameter(request, prefix	+ "scno_scccd", length));
			String[] costTpCd = (JSPUtil.getParameter(request, prefix	+ "cost_tp_cd", length));
			String[] fCostQtrCd = (JSPUtil.getParameter(request, prefix	+ "f_cost_qtr_cd", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] costTpBxRt = (JSPUtil.getParameter(request, prefix	+ "cost_tp_bx_rt", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] onStUtCost = (JSPUtil.getParameter(request, prefix	+ "on_st_ut_cost", length));
			String[] errCd = (JSPUtil.getParameter(request, prefix	+ "err_cd", length));
			String[] costTpBxRtTtl = (JSPUtil.getParameter(request, prefix	+ "cost_tp_bx_rt_ttl", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] onStAmt = (JSPUtil.getParameter(request, prefix	+ "on_st_amt", length));
			String[] comTtlAmt = (JSPUtil.getParameter(request, prefix	+ "com_ttl_amt", length));
			String[] comSubTtl = (JSPUtil.getParameter(request, prefix	+ "com_sub_ttl", length));
			String[] chssDrygAmt = (JSPUtil.getParameter(request, prefix	+ "chss_dryg_amt", length));
			String[] chssRmk = (JSPUtil.getParameter(request, prefix	+ "chss_rmk", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] fEffToYrmon = (JSPUtil.getParameter(request, prefix	+ "f_eff_to_yrmon", length));
			String[] crMmAmt = (JSPUtil.getParameter(request, prefix	+ "cr_mm_amt", length));
			String[] pErrorCode = (JSPUtil.getParameter(request, prefix	+ "p_error_code", length));
			String[] costYrQtr = (JSPUtil.getParameter(request, prefix	+ "cost_yr_qtr", length));
			String[] revShrAmt = (JSPUtil.getParameter(request, prefix	+ "rev_shr_amt", length));
			String[] fScno = (JSPUtil.getParameter(request, prefix	+ "f_scno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costQtrCd = (JSPUtil.getParameter(request, prefix	+ "cost_qtr_cd", length));
			String[] effToYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_to_yrmon", length));
			String[] fEffFmYrmon = (JSPUtil.getParameter(request, prefix	+ "f_eff_fm_yrmon", length));
			String[] bkgBxQty = (JSPUtil.getParameter(request, prefix	+ "bkg_bx_qty", length));
			String[] stndUtCost = (JSPUtil.getParameter(request, prefix	+ "stnd_ut_cost", length));
			String[] fYearmonth = (JSPUtil.getParameter(request, prefix	+ "f_yearmonth", length));
			String[] effFmYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_fm_yrmon", length));
			String[] comUtCost = (JSPUtil.getParameter(request, prefix	+ "com_ut_cost", length));
			String[] miscReBilAmt = (JSPUtil.getParameter(request, prefix	+ "misc_re_bil_amt", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] frYear = (JSPUtil.getParameter(request, prefix	+ "fr_year", length));
			String[] estmAmt = (JSPUtil.getParameter(request, prefix	+ "estm_amt", length));
			String[] fCostYr = (JSPUtil.getParameter(request, prefix	+ "f_cost_yr", length));
			String[] toQtr = (JSPUtil.getParameter(request, prefix	+ "to_qtr", length));
			String[] frQtr = (JSPUtil.getParameter(request, prefix	+ "fr_qtr", length));
			String[] onTmlAmt = (JSPUtil.getParameter(request, prefix	+ "on_tml_amt", length));
			String[] delChk = (JSPUtil.getParameter(request, prefix	+ "del_chk", length));
			String[] comSubTtlAmt = (JSPUtil.getParameter(request, prefix	+ "com_sub_ttl_amt", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] tYearmonth = (JSPUtil.getParameter(request, prefix	+ "t_yearmonth", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchChassisCostVO();
				if (onChssAmt[i] != null)
					model.setOnChssAmt(onChssAmt[i]);
				if (migAmt[i] != null)
					model.setMigAmt(migAmt[i]);
				if (toYear[i] != null)
					model.setToYear(toYear[i]);
				if (costTpNm[i] != null)
					model.setCostTpNm(costTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (scnoScccd[i] != null)
					model.setScnoScccd(scnoScccd[i]);
				if (costTpCd[i] != null)
					model.setCostTpCd(costTpCd[i]);
				if (fCostQtrCd[i] != null)
					model.setFCostQtrCd(fCostQtrCd[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (costTpBxRt[i] != null)
					model.setCostTpBxRt(costTpBxRt[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (onStUtCost[i] != null)
					model.setOnStUtCost(onStUtCost[i]);
				if (errCd[i] != null)
					model.setErrCd(errCd[i]);
				if (costTpBxRtTtl[i] != null)
					model.setCostTpBxRtTtl(costTpBxRtTtl[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (onStAmt[i] != null)
					model.setOnStAmt(onStAmt[i]);
				if (comTtlAmt[i] != null)
					model.setComTtlAmt(comTtlAmt[i]);
				if (comSubTtl[i] != null)
					model.setComSubTtl(comSubTtl[i]);
				if (chssDrygAmt[i] != null)
					model.setChssDrygAmt(chssDrygAmt[i]);
				if (chssRmk[i] != null)
					model.setChssRmk(chssRmk[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (fEffToYrmon[i] != null)
					model.setFEffToYrmon(fEffToYrmon[i]);
				if (crMmAmt[i] != null)
					model.setCrMmAmt(crMmAmt[i]);
				if (pErrorCode[i] != null)
					model.setPErrorCode(pErrorCode[i]);
				if (costYrQtr[i] != null)
					model.setCostYrQtr(costYrQtr[i]);
				if (revShrAmt[i] != null)
					model.setRevShrAmt(revShrAmt[i]);
				if (fScno[i] != null)
					model.setFScno(fScno[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costQtrCd[i] != null)
					model.setCostQtrCd(costQtrCd[i]);
				if (effToYrmon[i] != null)
					model.setEffToYrmon(effToYrmon[i]);
				if (fEffFmYrmon[i] != null)
					model.setFEffFmYrmon(fEffFmYrmon[i]);
				if (bkgBxQty[i] != null)
					model.setBkgBxQty(bkgBxQty[i]);
				if (stndUtCost[i] != null)
					model.setStndUtCost(stndUtCost[i]);
				if (fYearmonth[i] != null)
					model.setFYearmonth(fYearmonth[i]);
				if (effFmYrmon[i] != null)
					model.setEffFmYrmon(effFmYrmon[i]);
				if (comUtCost[i] != null)
					model.setComUtCost(comUtCost[i]);
				if (miscReBilAmt[i] != null)
					model.setMiscReBilAmt(miscReBilAmt[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (frYear[i] != null)
					model.setFrYear(frYear[i]);
				if (estmAmt[i] != null)
					model.setEstmAmt(estmAmt[i]);
				if (fCostYr[i] != null)
					model.setFCostYr(fCostYr[i]);
				if (toQtr[i] != null)
					model.setToQtr(toQtr[i]);
				if (frQtr[i] != null)
					model.setFrQtr(frQtr[i]);
				if (onTmlAmt[i] != null)
					model.setOnTmlAmt(onTmlAmt[i]);
				if (delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (comSubTtlAmt[i] != null)
					model.setComSubTtlAmt(comSubTtlAmt[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (tYearmonth[i] != null)
					model.setTYearmonth(tYearmonth[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchChassisCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchChassisCostVO[]
	 */
	public SearchChassisCostVO[] getSearchChassisCostVOs(){
		SearchChassisCostVO[] vos = (SearchChassisCostVO[])models.toArray(new SearchChassisCostVO[models.size()]);
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
		this.onChssAmt = this.onChssAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.migAmt = this.migAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYear = this.toYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTpNm = this.costTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnoScccd = this.scnoScccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTpCd = this.costTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostQtrCd = this.fCostQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTpBxRt = this.costTpBxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onStUtCost = this.onStUtCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCd = this.errCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTpBxRtTtl = this.costTpBxRtTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onStAmt = this.onStAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comTtlAmt = this.comTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comSubTtl = this.comSubTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssDrygAmt = this.chssDrygAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRmk = this.chssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEffToYrmon = this.fEffToYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crMmAmt = this.crMmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pErrorCode = this.pErrorCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrQtr = this.costYrQtr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revShrAmt = this.revShrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fScno = this.fScno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costQtrCd = this.costQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToYrmon = this.effToYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEffFmYrmon = this.fEffFmYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBxQty = this.bkgBxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndUtCost = this.stndUtCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYearmonth = this.fYearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmYrmon = this.effFmYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comUtCost = this.comUtCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miscReBilAmt = this.miscReBilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frYear = this.frYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmAmt = this.estmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostYr = this.fCostYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toQtr = this.toQtr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frQtr = this.frQtr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onTmlAmt = this.onTmlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk = this.delChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comSubTtlAmt = this.comSubTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tYearmonth = this.tYearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
