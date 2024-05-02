/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Report0023R1VO.java
*@FileTitle : Report0023R1VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.07.17 진윤오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class Report0023R1VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Report0023R1VO> models = new ArrayList<Report0023R1VO>();
	
	/* Column Info */
	private String genExpnItmDesc = null;
	/* Column Info */
	private String expnGrpAbbrNm1 = null;
	/* Column Info */
	private String asgJanAmt = null;
	/* Column Info */
	private String expnGrpAbbrNm2 = null;
	/* Column Info */
	private String adAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String genExpnTrnsDivCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String asgMarAmt = null;
	/* Column Info */
	private String asgOctAmt = null;
	/* Column Info */
	private String genExpnRqstNo = null;
	/* Column Info */
	private String expnAbbrNm = null;
	/* Column Info */
	private String usdLoclXchRt = null;
	/* Column Info */
	private String asgSumAmt = null;
	/* Column Info */
	private String rqstUtVal = null;
	/* Column Info */
	private String genExpnItmNo = null;
	/* Column Info */
	private String loclKrwXchRt = null;
	/* Column Info */
	private String genExpnCalcBssDesc = null;
	/* Column Info */
	private String rqstOpinRmk = null;
	/* Column Info */
	private String asgAugAmt = null;
	/* Column Info */
	private String asgJulAmt = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String asgSepAmt = null;
	/* Column Info */
	private String asgDecAmt = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String asgAprAmt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String gemExpnGrpCd1 = null;
	/* Column Info */
	private String sumAmt = null;
	/* Column Info */
	private String gemExpnGrpCd2 = null;
	/* Column Info */
	private String acctXchRtYrmon = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String genExpnRqstSeq = null;
	/* Column Info */
	private String asgJunAmt = null;
	/* Column Info */
	private String asgNovAmt = null;
	/* Column Info */
	private String asgMayAmt = null;
	/* Column Info */
	private String asgFebAmt = null;
	/* Column Info */
	private String ticCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Report0023R1VO() {}

	public Report0023R1VO(String ibflag, String pagerows, String genExpnRqstNo, String gemExpnGrpCd1, String gemExpnGrpCd2, String expnGrpAbbrNm1, String expnGrpAbbrNm2, String genExpnCd, String genExpnItmNo, String genExpnItmDesc, String genExpnCalcBssDesc, String rqstOpinRmk, String asgJanAmt, String asgFebAmt, String asgMarAmt, String asgAprAmt, String asgMayAmt, String asgJunAmt, String asgJulAmt, String asgAugAmt, String asgSepAmt, String asgOctAmt, String asgNovAmt, String asgDecAmt, String asgSumAmt, String rqstOfcCd, String sumAmt, String adAmt, String loclCurrCd, String rqstUtVal, String acctXchRtYrmon, String usdLoclXchRt, String loclKrwXchRt, String ticCd, String genExpnRqstSeq, String ofcCd, String genExpnTrnsDivCd, String expnAbbrNm, String usdAmt) {
		this.genExpnItmDesc = genExpnItmDesc;
		this.expnGrpAbbrNm1 = expnGrpAbbrNm1;
		this.asgJanAmt = asgJanAmt;
		this.expnGrpAbbrNm2 = expnGrpAbbrNm2;
		this.adAmt = adAmt;
		this.pagerows = pagerows;
		this.genExpnTrnsDivCd = genExpnTrnsDivCd;
		this.ibflag = ibflag;
		this.asgMarAmt = asgMarAmt;
		this.asgOctAmt = asgOctAmt;
		this.genExpnRqstNo = genExpnRqstNo;
		this.expnAbbrNm = expnAbbrNm;
		this.usdLoclXchRt = usdLoclXchRt;
		this.asgSumAmt = asgSumAmt;
		this.rqstUtVal = rqstUtVal;
		this.genExpnItmNo = genExpnItmNo;
		this.loclKrwXchRt = loclKrwXchRt;
		this.genExpnCalcBssDesc = genExpnCalcBssDesc;
		this.rqstOpinRmk = rqstOpinRmk;
		this.asgAugAmt = asgAugAmt;
		this.asgJulAmt = asgJulAmt;
		this.loclCurrCd = loclCurrCd;
		this.asgSepAmt = asgSepAmt;
		this.asgDecAmt = asgDecAmt;
		this.genExpnCd = genExpnCd;
		this.asgAprAmt = asgAprAmt;
		this.ofcCd = ofcCd;
		this.usdAmt = usdAmt;
		this.gemExpnGrpCd1 = gemExpnGrpCd1;
		this.sumAmt = sumAmt;
		this.gemExpnGrpCd2 = gemExpnGrpCd2;
		this.acctXchRtYrmon = acctXchRtYrmon;
		this.rqstOfcCd = rqstOfcCd;
		this.genExpnRqstSeq = genExpnRqstSeq;
		this.asgJunAmt = asgJunAmt;
		this.asgNovAmt = asgNovAmt;
		this.asgMayAmt = asgMayAmt;
		this.asgFebAmt = asgFebAmt;
		this.ticCd = ticCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gen_expn_itm_desc", getGenExpnItmDesc());
		this.hashColumns.put("expn_grp_abbr_nm1", getExpnGrpAbbrNm1());
		this.hashColumns.put("asg_jan_amt", getAsgJanAmt());
		this.hashColumns.put("expn_grp_abbr_nm2", getExpnGrpAbbrNm2());
		this.hashColumns.put("ad_amt", getAdAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gen_expn_trns_div_cd", getGenExpnTrnsDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("asg_mar_amt", getAsgMarAmt());
		this.hashColumns.put("asg_oct_amt", getAsgOctAmt());
		this.hashColumns.put("gen_expn_rqst_no", getGenExpnRqstNo());
		this.hashColumns.put("expn_abbr_nm", getExpnAbbrNm());
		this.hashColumns.put("usd_locl_xch_rt", getUsdLoclXchRt());
		this.hashColumns.put("asg_sum_amt", getAsgSumAmt());
		this.hashColumns.put("rqst_ut_val", getRqstUtVal());
		this.hashColumns.put("gen_expn_itm_no", getGenExpnItmNo());
		this.hashColumns.put("locl_krw_xch_rt", getLoclKrwXchRt());
		this.hashColumns.put("gen_expn_calc_bss_desc", getGenExpnCalcBssDesc());
		this.hashColumns.put("rqst_opin_rmk", getRqstOpinRmk());
		this.hashColumns.put("asg_aug_amt", getAsgAugAmt());
		this.hashColumns.put("asg_jul_amt", getAsgJulAmt());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("asg_sep_amt", getAsgSepAmt());
		this.hashColumns.put("asg_dec_amt", getAsgDecAmt());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("asg_apr_amt", getAsgAprAmt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("gem_expn_grp_cd1", getGemExpnGrpCd1());
		this.hashColumns.put("sum_amt", getSumAmt());
		this.hashColumns.put("gem_expn_grp_cd2", getGemExpnGrpCd2());
		this.hashColumns.put("acct_xch_rt_yrmon", getAcctXchRtYrmon());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("gen_expn_rqst_seq", getGenExpnRqstSeq());
		this.hashColumns.put("asg_jun_amt", getAsgJunAmt());
		this.hashColumns.put("asg_nov_amt", getAsgNovAmt());
		this.hashColumns.put("asg_may_amt", getAsgMayAmt());
		this.hashColumns.put("asg_feb_amt", getAsgFebAmt());
		this.hashColumns.put("tic_cd", getTicCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gen_expn_itm_desc", "genExpnItmDesc");
		this.hashFields.put("expn_grp_abbr_nm1", "expnGrpAbbrNm1");
		this.hashFields.put("asg_jan_amt", "asgJanAmt");
		this.hashFields.put("expn_grp_abbr_nm2", "expnGrpAbbrNm2");
		this.hashFields.put("ad_amt", "adAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gen_expn_trns_div_cd", "genExpnTrnsDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("asg_mar_amt", "asgMarAmt");
		this.hashFields.put("asg_oct_amt", "asgOctAmt");
		this.hashFields.put("gen_expn_rqst_no", "genExpnRqstNo");
		this.hashFields.put("expn_abbr_nm", "expnAbbrNm");
		this.hashFields.put("usd_locl_xch_rt", "usdLoclXchRt");
		this.hashFields.put("asg_sum_amt", "asgSumAmt");
		this.hashFields.put("rqst_ut_val", "rqstUtVal");
		this.hashFields.put("gen_expn_itm_no", "genExpnItmNo");
		this.hashFields.put("locl_krw_xch_rt", "loclKrwXchRt");
		this.hashFields.put("gen_expn_calc_bss_desc", "genExpnCalcBssDesc");
		this.hashFields.put("rqst_opin_rmk", "rqstOpinRmk");
		this.hashFields.put("asg_aug_amt", "asgAugAmt");
		this.hashFields.put("asg_jul_amt", "asgJulAmt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("asg_sep_amt", "asgSepAmt");
		this.hashFields.put("asg_dec_amt", "asgDecAmt");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("asg_apr_amt", "asgAprAmt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("gem_expn_grp_cd1", "gemExpnGrpCd1");
		this.hashFields.put("sum_amt", "sumAmt");
		this.hashFields.put("gem_expn_grp_cd2", "gemExpnGrpCd2");
		this.hashFields.put("acct_xch_rt_yrmon", "acctXchRtYrmon");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("gen_expn_rqst_seq", "genExpnRqstSeq");
		this.hashFields.put("asg_jun_amt", "asgJunAmt");
		this.hashFields.put("asg_nov_amt", "asgNovAmt");
		this.hashFields.put("asg_may_amt", "asgMayAmt");
		this.hashFields.put("asg_feb_amt", "asgFebAmt");
		this.hashFields.put("tic_cd", "ticCd");
		return this.hashFields;
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
	 * @return expnGrpAbbrNm1
	 */
	public String getExpnGrpAbbrNm1() {
		return this.expnGrpAbbrNm1;
	}
	
	/**
	 * Column Info
	 * @return asgJanAmt
	 */
	public String getAsgJanAmt() {
		return this.asgJanAmt;
	}
	
	/**
	 * Column Info
	 * @return expnGrpAbbrNm2
	 */
	public String getExpnGrpAbbrNm2() {
		return this.expnGrpAbbrNm2;
	}
	
	/**
	 * Column Info
	 * @return adAmt
	 */
	public String getAdAmt() {
		return this.adAmt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return asgMarAmt
	 */
	public String getAsgMarAmt() {
		return this.asgMarAmt;
	}
	
	/**
	 * Column Info
	 * @return asgOctAmt
	 */
	public String getAsgOctAmt() {
		return this.asgOctAmt;
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
	 * @return usdLoclXchRt
	 */
	public String getUsdLoclXchRt() {
		return this.usdLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @return asgSumAmt
	 */
	public String getAsgSumAmt() {
		return this.asgSumAmt;
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
	 * @return genExpnItmNo
	 */
	public String getGenExpnItmNo() {
		return this.genExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @return loclKrwXchRt
	 */
	public String getLoclKrwXchRt() {
		return this.loclKrwXchRt;
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
	 * @return asgAugAmt
	 */
	public String getAsgAugAmt() {
		return this.asgAugAmt;
	}
	
	/**
	 * Column Info
	 * @return asgJulAmt
	 */
	public String getAsgJulAmt() {
		return this.asgJulAmt;
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
	 * @return asgSepAmt
	 */
	public String getAsgSepAmt() {
		return this.asgSepAmt;
	}
	
	/**
	 * Column Info
	 * @return asgDecAmt
	 */
	public String getAsgDecAmt() {
		return this.asgDecAmt;
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
	 * @return asgAprAmt
	 */
	public String getAsgAprAmt() {
		return this.asgAprAmt;
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
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
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
	 * @return sumAmt
	 */
	public String getSumAmt() {
		return this.sumAmt;
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
	 * @return acctXchRtYrmon
	 */
	public String getAcctXchRtYrmon() {
		return this.acctXchRtYrmon;
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
	 * @return genExpnRqstSeq
	 */
	public String getGenExpnRqstSeq() {
		return this.genExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return asgJunAmt
	 */
	public String getAsgJunAmt() {
		return this.asgJunAmt;
	}
	
	/**
	 * Column Info
	 * @return asgNovAmt
	 */
	public String getAsgNovAmt() {
		return this.asgNovAmt;
	}
	
	/**
	 * Column Info
	 * @return asgMayAmt
	 */
	public String getAsgMayAmt() {
		return this.asgMayAmt;
	}
	
	/**
	 * Column Info
	 * @return asgFebAmt
	 */
	public String getAsgFebAmt() {
		return this.asgFebAmt;
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
	 * @param genExpnItmDesc
	 */
	public void setGenExpnItmDesc(String genExpnItmDesc) {
		this.genExpnItmDesc = genExpnItmDesc;
	}
	
	/**
	 * Column Info
	 * @param expnGrpAbbrNm1
	 */
	public void setExpnGrpAbbrNm1(String expnGrpAbbrNm1) {
		this.expnGrpAbbrNm1 = expnGrpAbbrNm1;
	}
	
	/**
	 * Column Info
	 * @param asgJanAmt
	 */
	public void setAsgJanAmt(String asgJanAmt) {
		this.asgJanAmt = asgJanAmt;
	}
	
	/**
	 * Column Info
	 * @param expnGrpAbbrNm2
	 */
	public void setExpnGrpAbbrNm2(String expnGrpAbbrNm2) {
		this.expnGrpAbbrNm2 = expnGrpAbbrNm2;
	}
	
	/**
	 * Column Info
	 * @param adAmt
	 */
	public void setAdAmt(String adAmt) {
		this.adAmt = adAmt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param asgMarAmt
	 */
	public void setAsgMarAmt(String asgMarAmt) {
		this.asgMarAmt = asgMarAmt;
	}
	
	/**
	 * Column Info
	 * @param asgOctAmt
	 */
	public void setAsgOctAmt(String asgOctAmt) {
		this.asgOctAmt = asgOctAmt;
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
	 * @param usdLoclXchRt
	 */
	public void setUsdLoclXchRt(String usdLoclXchRt) {
		this.usdLoclXchRt = usdLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @param asgSumAmt
	 */
	public void setAsgSumAmt(String asgSumAmt) {
		this.asgSumAmt = asgSumAmt;
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
	 * @param genExpnItmNo
	 */
	public void setGenExpnItmNo(String genExpnItmNo) {
		this.genExpnItmNo = genExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @param loclKrwXchRt
	 */
	public void setLoclKrwXchRt(String loclKrwXchRt) {
		this.loclKrwXchRt = loclKrwXchRt;
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
	 * @param asgAugAmt
	 */
	public void setAsgAugAmt(String asgAugAmt) {
		this.asgAugAmt = asgAugAmt;
	}
	
	/**
	 * Column Info
	 * @param asgJulAmt
	 */
	public void setAsgJulAmt(String asgJulAmt) {
		this.asgJulAmt = asgJulAmt;
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
	 * @param asgSepAmt
	 */
	public void setAsgSepAmt(String asgSepAmt) {
		this.asgSepAmt = asgSepAmt;
	}
	
	/**
	 * Column Info
	 * @param asgDecAmt
	 */
	public void setAsgDecAmt(String asgDecAmt) {
		this.asgDecAmt = asgDecAmt;
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
	 * @param asgAprAmt
	 */
	public void setAsgAprAmt(String asgAprAmt) {
		this.asgAprAmt = asgAprAmt;
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
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
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
	 * @param sumAmt
	 */
	public void setSumAmt(String sumAmt) {
		this.sumAmt = sumAmt;
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
	 * @param acctXchRtYrmon
	 */
	public void setAcctXchRtYrmon(String acctXchRtYrmon) {
		this.acctXchRtYrmon = acctXchRtYrmon;
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
	 * @param genExpnRqstSeq
	 */
	public void setGenExpnRqstSeq(String genExpnRqstSeq) {
		this.genExpnRqstSeq = genExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param asgJunAmt
	 */
	public void setAsgJunAmt(String asgJunAmt) {
		this.asgJunAmt = asgJunAmt;
	}
	
	/**
	 * Column Info
	 * @param asgNovAmt
	 */
	public void setAsgNovAmt(String asgNovAmt) {
		this.asgNovAmt = asgNovAmt;
	}
	
	/**
	 * Column Info
	 * @param asgMayAmt
	 */
	public void setAsgMayAmt(String asgMayAmt) {
		this.asgMayAmt = asgMayAmt;
	}
	
	/**
	 * Column Info
	 * @param asgFebAmt
	 */
	public void setAsgFebAmt(String asgFebAmt) {
		this.asgFebAmt = asgFebAmt;
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
		setGenExpnItmDesc(JSPUtil.getParameter(request, "gen_expn_itm_desc", ""));
		setExpnGrpAbbrNm1(JSPUtil.getParameter(request, "expn_grp_abbr_nm1", ""));
		setAsgJanAmt(JSPUtil.getParameter(request, "asg_jan_amt", ""));
		setExpnGrpAbbrNm2(JSPUtil.getParameter(request, "expn_grp_abbr_nm2", ""));
		setAdAmt(JSPUtil.getParameter(request, "ad_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setGenExpnTrnsDivCd(JSPUtil.getParameter(request, "gen_expn_trns_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAsgMarAmt(JSPUtil.getParameter(request, "asg_mar_amt", ""));
		setAsgOctAmt(JSPUtil.getParameter(request, "asg_oct_amt", ""));
		setGenExpnRqstNo(JSPUtil.getParameter(request, "gen_expn_rqst_no", ""));
		setExpnAbbrNm(JSPUtil.getParameter(request, "expn_abbr_nm", ""));
		setUsdLoclXchRt(JSPUtil.getParameter(request, "usd_locl_xch_rt", ""));
		setAsgSumAmt(JSPUtil.getParameter(request, "asg_sum_amt", ""));
		setRqstUtVal(JSPUtil.getParameter(request, "rqst_ut_val", ""));
		setGenExpnItmNo(JSPUtil.getParameter(request, "gen_expn_itm_no", ""));
		setLoclKrwXchRt(JSPUtil.getParameter(request, "locl_krw_xch_rt", ""));
		setGenExpnCalcBssDesc(JSPUtil.getParameter(request, "gen_expn_calc_bss_desc", ""));
		setRqstOpinRmk(JSPUtil.getParameter(request, "rqst_opin_rmk", ""));
		setAsgAugAmt(JSPUtil.getParameter(request, "asg_aug_amt", ""));
		setAsgJulAmt(JSPUtil.getParameter(request, "asg_jul_amt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setAsgSepAmt(JSPUtil.getParameter(request, "asg_sep_amt", ""));
		setAsgDecAmt(JSPUtil.getParameter(request, "asg_dec_amt", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setAsgAprAmt(JSPUtil.getParameter(request, "asg_apr_amt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setUsdAmt(JSPUtil.getParameter(request, "usd_amt", ""));
		setGemExpnGrpCd1(JSPUtil.getParameter(request, "gem_expn_grp_cd1", ""));
		setSumAmt(JSPUtil.getParameter(request, "sum_amt", ""));
		setGemExpnGrpCd2(JSPUtil.getParameter(request, "gem_expn_grp_cd2", ""));
		setAcctXchRtYrmon(JSPUtil.getParameter(request, "acct_xch_rt_yrmon", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, "rqst_ofc_cd", ""));
		setGenExpnRqstSeq(JSPUtil.getParameter(request, "gen_expn_rqst_seq", ""));
		setAsgJunAmt(JSPUtil.getParameter(request, "asg_jun_amt", ""));
		setAsgNovAmt(JSPUtil.getParameter(request, "asg_nov_amt", ""));
		setAsgMayAmt(JSPUtil.getParameter(request, "asg_may_amt", ""));
		setAsgFebAmt(JSPUtil.getParameter(request, "asg_feb_amt", ""));
		setTicCd(JSPUtil.getParameter(request, "tic_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Report0023R1VO[]
	 */
	public Report0023R1VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Report0023R1VO[]
	 */
	public Report0023R1VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Report0023R1VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] genExpnItmDesc = (JSPUtil.getParameter(request, prefix	+ "gen_expn_itm_desc", length));
			String[] expnGrpAbbrNm1 = (JSPUtil.getParameter(request, prefix	+ "expn_grp_abbr_nm1", length));
			String[] asgJanAmt = (JSPUtil.getParameter(request, prefix	+ "asg_jan_amt", length));
			String[] expnGrpAbbrNm2 = (JSPUtil.getParameter(request, prefix	+ "expn_grp_abbr_nm2", length));
			String[] adAmt = (JSPUtil.getParameter(request, prefix	+ "ad_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] genExpnTrnsDivCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_trns_div_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] asgMarAmt = (JSPUtil.getParameter(request, prefix	+ "asg_mar_amt", length));
			String[] asgOctAmt = (JSPUtil.getParameter(request, prefix	+ "asg_oct_amt", length));
			String[] genExpnRqstNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no", length));
			String[] expnAbbrNm = (JSPUtil.getParameter(request, prefix	+ "expn_abbr_nm", length));
			String[] usdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_locl_xch_rt", length));
			String[] asgSumAmt = (JSPUtil.getParameter(request, prefix	+ "asg_sum_amt", length));
			String[] rqstUtVal = (JSPUtil.getParameter(request, prefix	+ "rqst_ut_val", length));
			String[] genExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_itm_no", length));
			String[] loclKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "locl_krw_xch_rt", length));
			String[] genExpnCalcBssDesc = (JSPUtil.getParameter(request, prefix	+ "gen_expn_calc_bss_desc", length));
			String[] rqstOpinRmk = (JSPUtil.getParameter(request, prefix	+ "rqst_opin_rmk", length));
			String[] asgAugAmt = (JSPUtil.getParameter(request, prefix	+ "asg_aug_amt", length));
			String[] asgJulAmt = (JSPUtil.getParameter(request, prefix	+ "asg_jul_amt", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] asgSepAmt = (JSPUtil.getParameter(request, prefix	+ "asg_sep_amt", length));
			String[] asgDecAmt = (JSPUtil.getParameter(request, prefix	+ "asg_dec_amt", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] asgAprAmt = (JSPUtil.getParameter(request, prefix	+ "asg_apr_amt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] gemExpnGrpCd1 = (JSPUtil.getParameter(request, prefix	+ "gem_expn_grp_cd1", length));
			String[] sumAmt = (JSPUtil.getParameter(request, prefix	+ "sum_amt", length));
			String[] gemExpnGrpCd2 = (JSPUtil.getParameter(request, prefix	+ "gem_expn_grp_cd2", length));
			String[] acctXchRtYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_xch_rt_yrmon", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] genExpnRqstSeq = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_seq", length));
			String[] asgJunAmt = (JSPUtil.getParameter(request, prefix	+ "asg_jun_amt", length));
			String[] asgNovAmt = (JSPUtil.getParameter(request, prefix	+ "asg_nov_amt", length));
			String[] asgMayAmt = (JSPUtil.getParameter(request, prefix	+ "asg_may_amt", length));
			String[] asgFebAmt = (JSPUtil.getParameter(request, prefix	+ "asg_feb_amt", length));
			String[] ticCd = (JSPUtil.getParameter(request, prefix	+ "tic_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new Report0023R1VO();
				if (genExpnItmDesc[i] != null)
					model.setGenExpnItmDesc(genExpnItmDesc[i]);
				if (expnGrpAbbrNm1[i] != null)
					model.setExpnGrpAbbrNm1(expnGrpAbbrNm1[i]);
				if (asgJanAmt[i] != null)
					model.setAsgJanAmt(asgJanAmt[i]);
				if (expnGrpAbbrNm2[i] != null)
					model.setExpnGrpAbbrNm2(expnGrpAbbrNm2[i]);
				if (adAmt[i] != null)
					model.setAdAmt(adAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (genExpnTrnsDivCd[i] != null)
					model.setGenExpnTrnsDivCd(genExpnTrnsDivCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (asgMarAmt[i] != null)
					model.setAsgMarAmt(asgMarAmt[i]);
				if (asgOctAmt[i] != null)
					model.setAsgOctAmt(asgOctAmt[i]);
				if (genExpnRqstNo[i] != null)
					model.setGenExpnRqstNo(genExpnRqstNo[i]);
				if (expnAbbrNm[i] != null)
					model.setExpnAbbrNm(expnAbbrNm[i]);
				if (usdLoclXchRt[i] != null)
					model.setUsdLoclXchRt(usdLoclXchRt[i]);
				if (asgSumAmt[i] != null)
					model.setAsgSumAmt(asgSumAmt[i]);
				if (rqstUtVal[i] != null)
					model.setRqstUtVal(rqstUtVal[i]);
				if (genExpnItmNo[i] != null)
					model.setGenExpnItmNo(genExpnItmNo[i]);
				if (loclKrwXchRt[i] != null)
					model.setLoclKrwXchRt(loclKrwXchRt[i]);
				if (genExpnCalcBssDesc[i] != null)
					model.setGenExpnCalcBssDesc(genExpnCalcBssDesc[i]);
				if (rqstOpinRmk[i] != null)
					model.setRqstOpinRmk(rqstOpinRmk[i]);
				if (asgAugAmt[i] != null)
					model.setAsgAugAmt(asgAugAmt[i]);
				if (asgJulAmt[i] != null)
					model.setAsgJulAmt(asgJulAmt[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (asgSepAmt[i] != null)
					model.setAsgSepAmt(asgSepAmt[i]);
				if (asgDecAmt[i] != null)
					model.setAsgDecAmt(asgDecAmt[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (asgAprAmt[i] != null)
					model.setAsgAprAmt(asgAprAmt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (gemExpnGrpCd1[i] != null)
					model.setGemExpnGrpCd1(gemExpnGrpCd1[i]);
				if (sumAmt[i] != null)
					model.setSumAmt(sumAmt[i]);
				if (gemExpnGrpCd2[i] != null)
					model.setGemExpnGrpCd2(gemExpnGrpCd2[i]);
				if (acctXchRtYrmon[i] != null)
					model.setAcctXchRtYrmon(acctXchRtYrmon[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (genExpnRqstSeq[i] != null)
					model.setGenExpnRqstSeq(genExpnRqstSeq[i]);
				if (asgJunAmt[i] != null)
					model.setAsgJunAmt(asgJunAmt[i]);
				if (asgNovAmt[i] != null)
					model.setAsgNovAmt(asgNovAmt[i]);
				if (asgMayAmt[i] != null)
					model.setAsgMayAmt(asgMayAmt[i]);
				if (asgFebAmt[i] != null)
					model.setAsgFebAmt(asgFebAmt[i]);
				if (ticCd[i] != null)
					model.setTicCd(ticCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReport0023R1VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Report0023R1VO[]
	 */
	public Report0023R1VO[] getReport0023R1VOs(){
		Report0023R1VO[] vos = (Report0023R1VO[])models.toArray(new Report0023R1VO[models.size()]);
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
		this.genExpnItmDesc = this.genExpnItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnGrpAbbrNm1 = this.expnGrpAbbrNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgJanAmt = this.asgJanAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnGrpAbbrNm2 = this.expnGrpAbbrNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adAmt = this.adAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnTrnsDivCd = this.genExpnTrnsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgMarAmt = this.asgMarAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgOctAmt = this.asgOctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo = this.genExpnRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnAbbrNm = this.expnAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLoclXchRt = this.usdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgSumAmt = this.asgSumAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUtVal = this.rqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnItmNo = this.genExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclKrwXchRt = this.loclKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCalcBssDesc = this.genExpnCalcBssDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOpinRmk = this.rqstOpinRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgAugAmt = this.asgAugAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgJulAmt = this.asgJulAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgSepAmt = this.asgSepAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgDecAmt = this.asgDecAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgAprAmt = this.asgAprAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gemExpnGrpCd1 = this.gemExpnGrpCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumAmt = this.sumAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gemExpnGrpCd2 = this.gemExpnGrpCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctXchRtYrmon = this.acctXchRtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstSeq = this.genExpnRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgJunAmt = this.asgJunAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgNovAmt = this.asgNovAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgMayAmt = this.asgMayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgFebAmt = this.asgFebAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticCd = this.ticCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
