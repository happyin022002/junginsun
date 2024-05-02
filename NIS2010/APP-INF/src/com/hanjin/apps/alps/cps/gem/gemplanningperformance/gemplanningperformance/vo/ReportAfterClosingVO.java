/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReportAfterClosingVO.java
*@FileTitle : ReportAfterClosingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.07.13 박창준 
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
 * @author 박창준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ReportAfterClosingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReportAfterClosingVO> models = new ArrayList<ReportAfterClosingVO>();
	
	/* Column Info */
	private String usdRatio01 = null;
	/* Column Info */
	private String usdAccLoclXchRt = null;
	/* Column Info */
	private String usdRatio02 = null;
	/* Column Info */
	private String abbrNm = null;
	/* Column Info */
	private String l2 = null;
	/* Column Info */
	private String l3 = null;
	/* Column Info */
	private String usdRatio03 = null;
	/* Column Info */
	private String l1 = null;
	/* Column Info */
	private String genExpnInitAmt = null;
	/* Column Info */
	private String usdAssigned02 = null;
	/* Column Info */
	private String usdAssigned = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String usdAccAssigned = null;
	/* Column Info */
	private String level2 = null;
	/* Column Info */
	private String level3 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lclRatio03 = null;
	/* Column Info */
	private String lclRatio02 = null;
	/* Column Info */
	private String usdExpnInitAmt = null;
	/* Column Info */
	private String ofcCoDivCd = null;
	/* Column Info */
	private String lclAssigned = null;
	/* Column Info */
	private String lclRatio01 = null;
	/* Column Info */
	private String usdLoclXchRt = null;
	/* Column Info */
	private String rqstUtVal = null;
	/* Column Info */
	private String usdAccPerfAmt02 = null;
	/* Column Info */
	private String usdAccPerfAmt03 = null;
	/* Column Info */
	private String slsOfcFlg = null;
	/* Column Info */
	private String usdAccPerfAmt01 = null;
	/* Column Info */
	private String rgnOfcFlg = null;
	/* Column Info */
	private String officeExpense = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String usdPerfAmt03 = null;
	/* Column Info */
	private String subOfcCd = null;
	/* Column Info */
	private String rtToMon = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String rtFmMon = null;
	/* Column Info */
	private String slpPerfAmt = null;
	/* Column Info */
	private String usdPerfAmt02 = null;
	/* Column Info */
	private String usdAccExpnInitAmt = null;
	/* Column Info */
	private String usdPerfAmt01 = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String usdPerfAmt = null;
	/* Column Info */
	private String slpPerfAmt01 = null;
	/* Column Info */
	private String slpPerfAmt02 = null;
	/* Column Info */
	private String usdAccPerfAmt = null;
	/* Column Info */
	private String slpPerfAmt03 = null;
	/* Column Info */
	private String rtYr = null;
	/* Column Info */
	private String ticCd = null;
	/* Column Info */
	private String abbrNm01 = null;
	/* Column Info */
	private String abbrNm02 = null;
	/* Column Info */
	private String abbrNm03 = null;
	/* Column Info */
	private String rsltYrmon = null;
	/* Column Info */
	private String rsltYrmon01 = null;
	/* Column Info */
	private String lclSal = null;
	/* Column Info */
	private String lclNonSal = null;
	/* Column Info */
	private String usdSal = null;
	/* Column Info */
	private String usdNonSal = null;
	/* Column Info */
	private String salType = null;
	/* Column Info */
	private String ratioBa = null;
	/* Column Info */
	private String ratioFc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ReportAfterClosingVO() {}

	public ReportAfterClosingVO(String ibflag, String pagerows, String officeExpense, String loclCurrCd, String rqstUtVal, String rtYr, String rtFmMon, String rtToMon, String ofcCd, String subOfcCd, String ofcCoDivCd, String level2, String level3, String rgnOfcFlg, String slsOfcFlg, String genExpnCd, String abbrNm, String ticCd, String l1, String l2, String l3, String genExpnInitAmt, String lclAssigned, String slpPerfAmt, String usdExpnInitAmt, String usdAssigned, String usdPerfAmt, String usdAccExpnInitAmt, String usdAccAssigned, String usdAccPerfAmt, String usdLoclXchRt, String usdAccLoclXchRt, String slpPerfAmt01, String usdPerfAmt01, String usdAccPerfAmt01, String lclRatio01, String usdRatio01, String slpPerfAmt02, String usdAssigned02, String usdPerfAmt02, String usdAccPerfAmt02, String lclRatio02, String usdRatio02, String slpPerfAmt03, String usdPerfAmt03, String usdAccPerfAmt03, String lclRatio03, String usdRatio03, String abbrNm01, String abbrNm02, String abbrNm03, String rsltYrmon, String rsltYrmon01, String lclSal, String lclNonSal, String usdSal, String usdNonSal, String salType, String ratioBa, String ratioFc) {
		this.usdRatio01 = usdRatio01;
		this.usdAccLoclXchRt = usdAccLoclXchRt;
		this.usdRatio02 = usdRatio02;
		this.abbrNm = abbrNm;
		this.l2 = l2;
		this.l3 = l3;
		this.usdRatio03 = usdRatio03;
		this.l1 = l1;
		this.genExpnInitAmt = genExpnInitAmt;
		this.usdAssigned02 = usdAssigned02;
		this.usdAssigned = usdAssigned;
		this.pagerows = pagerows;
		this.usdAccAssigned = usdAccAssigned;
		this.level2 = level2;
		this.level3 = level3;
		this.ibflag = ibflag;
		this.lclRatio03 = lclRatio03;
		this.lclRatio02 = lclRatio02;
		this.usdExpnInitAmt = usdExpnInitAmt;
		this.ofcCoDivCd = ofcCoDivCd;
		this.lclAssigned = lclAssigned;
		this.lclRatio01 = lclRatio01;
		this.usdLoclXchRt = usdLoclXchRt;
		this.rqstUtVal = rqstUtVal;
		this.usdAccPerfAmt02 = usdAccPerfAmt02;
		this.usdAccPerfAmt03 = usdAccPerfAmt03;
		this.slsOfcFlg = slsOfcFlg;
		this.usdAccPerfAmt01 = usdAccPerfAmt01;
		this.rgnOfcFlg = rgnOfcFlg;
		this.officeExpense = officeExpense;
		this.loclCurrCd = loclCurrCd;
		this.usdPerfAmt03 = usdPerfAmt03;
		this.subOfcCd = subOfcCd;
		this.rtToMon = rtToMon;
		this.genExpnCd = genExpnCd;
		this.rtFmMon = rtFmMon;
		this.slpPerfAmt = slpPerfAmt;
		this.usdPerfAmt02 = usdPerfAmt02;
		this.usdAccExpnInitAmt = usdAccExpnInitAmt;
		this.usdPerfAmt01 = usdPerfAmt01;
		this.ofcCd = ofcCd;
		this.usdPerfAmt = usdPerfAmt;
		this.slpPerfAmt01 = slpPerfAmt01;
		this.slpPerfAmt02 = slpPerfAmt02;
		this.usdAccPerfAmt = usdAccPerfAmt;
		this.slpPerfAmt03 = slpPerfAmt03;
		this.rtYr = rtYr;
		this.ticCd = ticCd;
		this.abbrNm01 = abbrNm01;
		this.abbrNm02 = abbrNm02;
		this.abbrNm03 = abbrNm03;
		this.rsltYrmon = rsltYrmon;
		this.rsltYrmon01 = rsltYrmon01;
		this.lclSal = lclSal;
		this.lclNonSal = lclNonSal;
		this.usdSal = usdSal;
		this.usdNonSal = usdNonSal;
		this.salType = salType;
		this.ratioBa = ratioBa;
		this.ratioFc = ratioFc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("usd_ratio01", getUsdRatio01());
		this.hashColumns.put("usd_acc_locl_xch_rt", getUsdAccLoclXchRt());
		this.hashColumns.put("usd_ratio02", getUsdRatio02());
		this.hashColumns.put("abbr_nm", getAbbrNm());
		this.hashColumns.put("l_2", getL2());
		this.hashColumns.put("l_3", getL3());
		this.hashColumns.put("usd_ratio03", getUsdRatio03());
		this.hashColumns.put("l_1", getL1());
		this.hashColumns.put("gen_expn_init_amt", getGenExpnInitAmt());
		this.hashColumns.put("usd_assigned02", getUsdAssigned02());
		this.hashColumns.put("usd_assigned", getUsdAssigned());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("usd_acc_assigned", getUsdAccAssigned());
		this.hashColumns.put("level_2", getLevel2());
		this.hashColumns.put("level_3", getLevel3());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lcl_ratio03", getLclRatio03());
		this.hashColumns.put("lcl_ratio02", getLclRatio02());
		this.hashColumns.put("usd_expn_init_amt", getUsdExpnInitAmt());
		this.hashColumns.put("ofc_co_div_cd", getOfcCoDivCd());
		this.hashColumns.put("lcl_assigned", getLclAssigned());
		this.hashColumns.put("lcl_ratio01", getLclRatio01());
		this.hashColumns.put("usd_locl_xch_rt", getUsdLoclXchRt());
		this.hashColumns.put("rqst_ut_val", getRqstUtVal());
		this.hashColumns.put("usd_acc_perf_amt02", getUsdAccPerfAmt02());
		this.hashColumns.put("usd_acc_perf_amt03", getUsdAccPerfAmt03());
		this.hashColumns.put("sls_ofc_flg", getSlsOfcFlg());
		this.hashColumns.put("usd_acc_perf_amt01", getUsdAccPerfAmt01());
		this.hashColumns.put("rgn_ofc_flg", getRgnOfcFlg());
		this.hashColumns.put("office_expense", getOfficeExpense());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("usd_perf_amt03", getUsdPerfAmt03());
		this.hashColumns.put("sub_ofc_cd", getSubOfcCd());
		this.hashColumns.put("rt_to_mon", getRtToMon());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("rt_fm_mon", getRtFmMon());
		this.hashColumns.put("slp_perf_amt", getSlpPerfAmt());
		this.hashColumns.put("usd_perf_amt02", getUsdPerfAmt02());
		this.hashColumns.put("usd_acc_expn_init_amt", getUsdAccExpnInitAmt());
		this.hashColumns.put("usd_perf_amt01", getUsdPerfAmt01());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("usd_perf_amt", getUsdPerfAmt());
		this.hashColumns.put("slp_perf_amt01", getSlpPerfAmt01());
		this.hashColumns.put("slp_perf_amt02", getSlpPerfAmt02());
		this.hashColumns.put("usd_acc_perf_amt", getUsdAccPerfAmt());
		this.hashColumns.put("slp_perf_amt03", getSlpPerfAmt03());
		this.hashColumns.put("rt_yr", getRtYr());
		this.hashColumns.put("tic_cd", getTicCd());
		this.hashColumns.put("abbr_nm01", getAbbrNm01());
		this.hashColumns.put("abbr_nm02", getAbbrNm02());
		this.hashColumns.put("abbr_nm03", getAbbrNm03());
		this.hashColumns.put("rslt_yrmon", getRsltYrmon());
		this.hashColumns.put("rslt_yrmon01", getRsltYrmon01());
		this.hashColumns.put("lcl_sal", getLclSal());
		this.hashColumns.put("lcl_non_sal", getLclNonSal());
		this.hashColumns.put("usd_sal", getUsdSal());
		this.hashColumns.put("usd_non_sal", getUsdNonSal());
		this.hashColumns.put("sal_type", getSalType());
		this.hashColumns.put("ratio_ba", getRatioBa());
		this.hashColumns.put("ratio_fc", getRatioFc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("usd_ratio01", "usdRatio01");
		this.hashFields.put("usd_acc_locl_xch_rt", "usdAccLoclXchRt");
		this.hashFields.put("usd_ratio02", "usdRatio02");
		this.hashFields.put("abbr_nm", "abbrNm");
		this.hashFields.put("l_2", "l2");
		this.hashFields.put("l_3", "l3");
		this.hashFields.put("usd_ratio03", "usdRatio03");
		this.hashFields.put("l_1", "l1");
		this.hashFields.put("gen_expn_init_amt", "genExpnInitAmt");
		this.hashFields.put("usd_assigned02", "usdAssigned02");
		this.hashFields.put("usd_assigned", "usdAssigned");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usd_acc_assigned", "usdAccAssigned");
		this.hashFields.put("level_2", "level2");
		this.hashFields.put("level_3", "level3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lcl_ratio03", "lclRatio03");
		this.hashFields.put("lcl_ratio02", "lclRatio02");
		this.hashFields.put("usd_expn_init_amt", "usdExpnInitAmt");
		this.hashFields.put("ofc_co_div_cd", "ofcCoDivCd");
		this.hashFields.put("lcl_assigned", "lclAssigned");
		this.hashFields.put("lcl_ratio01", "lclRatio01");
		this.hashFields.put("usd_locl_xch_rt", "usdLoclXchRt");
		this.hashFields.put("rqst_ut_val", "rqstUtVal");
		this.hashFields.put("usd_acc_perf_amt02", "usdAccPerfAmt02");
		this.hashFields.put("usd_acc_perf_amt03", "usdAccPerfAmt03");
		this.hashFields.put("sls_ofc_flg", "slsOfcFlg");
		this.hashFields.put("usd_acc_perf_amt01", "usdAccPerfAmt01");
		this.hashFields.put("rgn_ofc_flg", "rgnOfcFlg");
		this.hashFields.put("office_expense", "officeExpense");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("usd_perf_amt03", "usdPerfAmt03");
		this.hashFields.put("sub_ofc_cd", "subOfcCd");
		this.hashFields.put("rt_to_mon", "rtToMon");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("rt_fm_mon", "rtFmMon");
		this.hashFields.put("slp_perf_amt", "slpPerfAmt");
		this.hashFields.put("usd_perf_amt02", "usdPerfAmt02");
		this.hashFields.put("usd_acc_expn_init_amt", "usdAccExpnInitAmt");
		this.hashFields.put("usd_perf_amt01", "usdPerfAmt01");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("usd_perf_amt", "usdPerfAmt");
		this.hashFields.put("slp_perf_amt01", "slpPerfAmt01");
		this.hashFields.put("slp_perf_amt02", "slpPerfAmt02");
		this.hashFields.put("usd_acc_perf_amt", "usdAccPerfAmt");
		this.hashFields.put("slp_perf_amt03", "slpPerfAmt03");
		this.hashFields.put("rt_yr", "rtYr");
		this.hashFields.put("tic_cd", "ticCd");
		this.hashFields.put("abbr_nm01", "abbrNm01");
		this.hashFields.put("abbr_nm02", "abbrNm02");
		this.hashFields.put("abbr_nm03", "abbrNm03");
		this.hashFields.put("rslt_yrmon", "rsltYrmon");
		this.hashFields.put("rslt_yrmon01", "rsltYrmon01");
		this.hashFields.put("lcl_sal", "lclSal");
		this.hashFields.put("lcl_non_sal", "lclNonSal");
		this.hashFields.put("usd_sal", "usdSal");
		this.hashFields.put("usd_non_sal", "usdNonSal");
		this.hashFields.put("sal_type", "salType");
		this.hashFields.put("ratio_ba", "ratioBa");
		this.hashFields.put("ratio_fc", "ratioFc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return usdRatio01
	 */
	public String getUsdRatio01() {
		return this.usdRatio01;
	}
	
	/**
	 * Column Info
	 * @return usdAccLoclXchRt
	 */
	public String getUsdAccLoclXchRt() {
		return this.usdAccLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @return usdRatio02
	 */
	public String getUsdRatio02() {
		return this.usdRatio02;
	}
	
	/**
	 * Column Info
	 * @return abbrNm
	 */
	public String getAbbrNm() {
		return this.abbrNm;
	}
	
	/**
	 * Column Info
	 * @return l2
	 */
	public String getL2() {
		return this.l2;
	}
	
	/**
	 * Column Info
	 * @return l3
	 */
	public String getL3() {
		return this.l3;
	}
	
	/**
	 * Column Info
	 * @return usdRatio03
	 */
	public String getUsdRatio03() {
		return this.usdRatio03;
	}
	
	/**
	 * Column Info
	 * @return l1
	 */
	public String getL1() {
		return this.l1;
	}
	
	/**
	 * Column Info
	 * @return genExpnInitAmt
	 */
	public String getGenExpnInitAmt() {
		return this.genExpnInitAmt;
	}
	
	/**
	 * Column Info
	 * @return usdAssigned02
	 */
	public String getUsdAssigned02() {
		return this.usdAssigned02;
	}
	
	/**
	 * Column Info
	 * @return usdAssigned
	 */
	public String getUsdAssigned() {
		return this.usdAssigned;
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
	 * @return usdAccAssigned
	 */
	public String getUsdAccAssigned() {
		return this.usdAccAssigned;
	}
	
	/**
	 * Column Info
	 * @return level2
	 */
	public String getLevel2() {
		return this.level2;
	}
	
	/**
	 * Column Info
	 * @return level3
	 */
	public String getLevel3() {
		return this.level3;
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
	 * @return lclRatio03
	 */
	public String getLclRatio03() {
		return this.lclRatio03;
	}
	
	/**
	 * Column Info
	 * @return lclRatio02
	 */
	public String getLclRatio02() {
		return this.lclRatio02;
	}
	
	/**
	 * Column Info
	 * @return usdExpnInitAmt
	 */
	public String getUsdExpnInitAmt() {
		return this.usdExpnInitAmt;
	}
	
	/**
	 * Column Info
	 * @return ofcCoDivCd
	 */
	public String getOfcCoDivCd() {
		return this.ofcCoDivCd;
	}
	
	/**
	 * Column Info
	 * @return lclAssigned
	 */
	public String getLclAssigned() {
		return this.lclAssigned;
	}
	
	/**
	 * Column Info
	 * @return lclRatio01
	 */
	public String getLclRatio01() {
		return this.lclRatio01;
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
	 * @return rqstUtVal
	 */
	public String getRqstUtVal() {
		return this.rqstUtVal;
	}
	
	/**
	 * Column Info
	 * @return usdAccPerfAmt02
	 */
	public String getUsdAccPerfAmt02() {
		return this.usdAccPerfAmt02;
	}
	
	/**
	 * Column Info
	 * @return usdAccPerfAmt03
	 */
	public String getUsdAccPerfAmt03() {
		return this.usdAccPerfAmt03;
	}
	
	/**
	 * Column Info
	 * @return slsOfcFlg
	 */
	public String getSlsOfcFlg() {
		return this.slsOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return usdAccPerfAmt01
	 */
	public String getUsdAccPerfAmt01() {
		return this.usdAccPerfAmt01;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcFlg
	 */
	public String getRgnOfcFlg() {
		return this.rgnOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return officeExpense
	 */
	public String getOfficeExpense() {
		return this.officeExpense;
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
	 * @return usdPerfAmt03
	 */
	public String getUsdPerfAmt03() {
		return this.usdPerfAmt03;
	}
	
	/**
	 * Column Info
	 * @return subOfcCd
	 */
	public String getSubOfcCd() {
		return this.subOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rtToMon
	 */
	public String getRtToMon() {
		return this.rtToMon;
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
	 * @return rtFmMon
	 */
	public String getRtFmMon() {
		return this.rtFmMon;
	}
	
	/**
	 * Column Info
	 * @return slpPerfAmt
	 */
	public String getSlpPerfAmt() {
		return this.slpPerfAmt;
	}
	
	/**
	 * Column Info
	 * @return usdPerfAmt02
	 */
	public String getUsdPerfAmt02() {
		return this.usdPerfAmt02;
	}
	
	/**
	 * Column Info
	 * @return usdAccExpnInitAmt
	 */
	public String getUsdAccExpnInitAmt() {
		return this.usdAccExpnInitAmt;
	}
	
	/**
	 * Column Info
	 * @return usdPerfAmt01
	 */
	public String getUsdPerfAmt01() {
		return this.usdPerfAmt01;
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
	 * @return usdPerfAmt
	 */
	public String getUsdPerfAmt() {
		return this.usdPerfAmt;
	}
	
	/**
	 * Column Info
	 * @return slpPerfAmt01
	 */
	public String getSlpPerfAmt01() {
		return this.slpPerfAmt01;
	}
	
	/**
	 * Column Info
	 * @return slpPerfAmt02
	 */
	public String getSlpPerfAmt02() {
		return this.slpPerfAmt02;
	}
	
	/**
	 * Column Info
	 * @return usdAccPerfAmt
	 */
	public String getUsdAccPerfAmt() {
		return this.usdAccPerfAmt;
	}
	
	/**
	 * Column Info
	 * @return slpPerfAmt03
	 */
	public String getSlpPerfAmt03() {
		return this.slpPerfAmt03;
	}
	
	/**
	 * Column Info
	 * @return rtYr
	 */
	public String getRtYr() {
		return this.rtYr;
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
	 * @return abbrNm01
	 */
	public String getAbbrNm01() {
		return this.abbrNm01;
	}
	
	/**
	 * Column Info
	 * @return abbrNm02
	 */
	public String getAbbrNm02() {
		return this.abbrNm02;
	}
	
	/**
	 * Column Info
	 * @return abbrNm03
	 */
	public String getAbbrNm03() {
		return this.abbrNm03;
	}
	
	/**
	 * Column Info
	 * @return rsltYrmon
	 */
	public String getRsltYrmon() {
		return this.rsltYrmon;
	}
	
	/**
	 * Column Info
	 * @return rsltYrmon01
	 */
	public String getRsltYrmon01() {
		return this.rsltYrmon01;
	}
	
	/**
	 * Column Info
	 * @return lclSal
	 */
	public String getLclSal() {
		return this.lclSal;
	}
	
	/**
	 * Column Info
	 * @return lclNonSal
	 */
	public String getLclNonSal() {
		return this.lclNonSal;
	}
	
	/**
	 * Column Info
	 * @return usdSal
	 */
	public String getUsdSal() {
		return this.usdSal;
	}
	
	/**
	 * Column Info
	 * @return usdNonSal
	 */
	public String getUsdNonSal() {
		return this.usdNonSal;
	}
	
	/**
	 * Column Info
	 * @return salType
	 */
	public String getSalType() {
		return this.salType;
	}
	
	/**
	 * Column Info
	 * @return ratioBa
	 */
	public String getRatioBa() {
		return this.ratioBa;
	}
	
	/**
	 * Column Info
	 * @return ratioFc
	 */
	public String getRatioFc() {
		return this.ratioFc;
	}
	

	/**
	 * Column Info
	 * @param usdRatio01
	 */
	public void setUsdRatio01(String usdRatio01) {
		this.usdRatio01 = usdRatio01;
	}
	
	/**
	 * Column Info
	 * @param usdAccLoclXchRt
	 */
	public void setUsdAccLoclXchRt(String usdAccLoclXchRt) {
		this.usdAccLoclXchRt = usdAccLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @param usdRatio02
	 */
	public void setUsdRatio02(String usdRatio02) {
		this.usdRatio02 = usdRatio02;
	}
	
	/**
	 * Column Info
	 * @param abbrNm
	 */
	public void setAbbrNm(String abbrNm) {
		this.abbrNm = abbrNm;
	}
	
	/**
	 * Column Info
	 * @param l2
	 */
	public void setL2(String l2) {
		this.l2 = l2;
	}
	
	/**
	 * Column Info
	 * @param l3
	 */
	public void setL3(String l3) {
		this.l3 = l3;
	}
	
	/**
	 * Column Info
	 * @param usdRatio03
	 */
	public void setUsdRatio03(String usdRatio03) {
		this.usdRatio03 = usdRatio03;
	}
	
	/**
	 * Column Info
	 * @param l1
	 */
	public void setL1(String l1) {
		this.l1 = l1;
	}
	
	/**
	 * Column Info
	 * @param genExpnInitAmt
	 */
	public void setGenExpnInitAmt(String genExpnInitAmt) {
		this.genExpnInitAmt = genExpnInitAmt;
	}
	
	/**
	 * Column Info
	 * @param usdAssigned02
	 */
	public void setUsdAssigned02(String usdAssigned02) {
		this.usdAssigned02 = usdAssigned02;
	}
	
	/**
	 * Column Info
	 * @param usdAssigned
	 */
	public void setUsdAssigned(String usdAssigned) {
		this.usdAssigned = usdAssigned;
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
	 * @param usdAccAssigned
	 */
	public void setUsdAccAssigned(String usdAccAssigned) {
		this.usdAccAssigned = usdAccAssigned;
	}
	
	/**
	 * Column Info
	 * @param level2
	 */
	public void setLevel2(String level2) {
		this.level2 = level2;
	}
	
	/**
	 * Column Info
	 * @param level3
	 */
	public void setLevel3(String level3) {
		this.level3 = level3;
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
	 * @param lclRatio03
	 */
	public void setLclRatio03(String lclRatio03) {
		this.lclRatio03 = lclRatio03;
	}
	
	/**
	 * Column Info
	 * @param lclRatio02
	 */
	public void setLclRatio02(String lclRatio02) {
		this.lclRatio02 = lclRatio02;
	}
	
	/**
	 * Column Info
	 * @param usdExpnInitAmt
	 */
	public void setUsdExpnInitAmt(String usdExpnInitAmt) {
		this.usdExpnInitAmt = usdExpnInitAmt;
	}
	
	/**
	 * Column Info
	 * @param ofcCoDivCd
	 */
	public void setOfcCoDivCd(String ofcCoDivCd) {
		this.ofcCoDivCd = ofcCoDivCd;
	}
	
	/**
	 * Column Info
	 * @param lclAssigned
	 */
	public void setLclAssigned(String lclAssigned) {
		this.lclAssigned = lclAssigned;
	}
	
	/**
	 * Column Info
	 * @param lclRatio01
	 */
	public void setLclRatio01(String lclRatio01) {
		this.lclRatio01 = lclRatio01;
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
	 * @param rqstUtVal
	 */
	public void setRqstUtVal(String rqstUtVal) {
		this.rqstUtVal = rqstUtVal;
	}
	
	/**
	 * Column Info
	 * @param usdAccPerfAmt02
	 */
	public void setUsdAccPerfAmt02(String usdAccPerfAmt02) {
		this.usdAccPerfAmt02 = usdAccPerfAmt02;
	}
	
	/**
	 * Column Info
	 * @param usdAccPerfAmt03
	 */
	public void setUsdAccPerfAmt03(String usdAccPerfAmt03) {
		this.usdAccPerfAmt03 = usdAccPerfAmt03;
	}
	
	/**
	 * Column Info
	 * @param slsOfcFlg
	 */
	public void setSlsOfcFlg(String slsOfcFlg) {
		this.slsOfcFlg = slsOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param usdAccPerfAmt01
	 */
	public void setUsdAccPerfAmt01(String usdAccPerfAmt01) {
		this.usdAccPerfAmt01 = usdAccPerfAmt01;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcFlg
	 */
	public void setRgnOfcFlg(String rgnOfcFlg) {
		this.rgnOfcFlg = rgnOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param officeExpense
	 */
	public void setOfficeExpense(String officeExpense) {
		this.officeExpense = officeExpense;
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
	 * @param usdPerfAmt03
	 */
	public void setUsdPerfAmt03(String usdPerfAmt03) {
		this.usdPerfAmt03 = usdPerfAmt03;
	}
	
	/**
	 * Column Info
	 * @param subOfcCd
	 */
	public void setSubOfcCd(String subOfcCd) {
		this.subOfcCd = subOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rtToMon
	 */
	public void setRtToMon(String rtToMon) {
		this.rtToMon = rtToMon;
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
	 * @param rtFmMon
	 */
	public void setRtFmMon(String rtFmMon) {
		this.rtFmMon = rtFmMon;
	}
	
	/**
	 * Column Info
	 * @param slpPerfAmt
	 */
	public void setSlpPerfAmt(String slpPerfAmt) {
		this.slpPerfAmt = slpPerfAmt;
	}
	
	/**
	 * Column Info
	 * @param usdPerfAmt02
	 */
	public void setUsdPerfAmt02(String usdPerfAmt02) {
		this.usdPerfAmt02 = usdPerfAmt02;
	}
	
	/**
	 * Column Info
	 * @param usdAccExpnInitAmt
	 */
	public void setUsdAccExpnInitAmt(String usdAccExpnInitAmt) {
		this.usdAccExpnInitAmt = usdAccExpnInitAmt;
	}
	
	/**
	 * Column Info
	 * @param usdPerfAmt01
	 */
	public void setUsdPerfAmt01(String usdPerfAmt01) {
		this.usdPerfAmt01 = usdPerfAmt01;
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
	 * @param usdPerfAmt
	 */
	public void setUsdPerfAmt(String usdPerfAmt) {
		this.usdPerfAmt = usdPerfAmt;
	}
	
	/**
	 * Column Info
	 * @param slpPerfAmt01
	 */
	public void setSlpPerfAmt01(String slpPerfAmt01) {
		this.slpPerfAmt01 = slpPerfAmt01;
	}
	
	/**
	 * Column Info
	 * @param slpPerfAmt02
	 */
	public void setSlpPerfAmt02(String slpPerfAmt02) {
		this.slpPerfAmt02 = slpPerfAmt02;
	}
	
	/**
	 * Column Info
	 * @param usdAccPerfAmt
	 */
	public void setUsdAccPerfAmt(String usdAccPerfAmt) {
		this.usdAccPerfAmt = usdAccPerfAmt;
	}
	
	/**
	 * Column Info
	 * @param slpPerfAmt03
	 */
	public void setSlpPerfAmt03(String slpPerfAmt03) {
		this.slpPerfAmt03 = slpPerfAmt03;
	}
	
	/**
	 * Column Info
	 * @param rtYr
	 */
	public void setRtYr(String rtYr) {
		this.rtYr = rtYr;
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
	 * @param abbrNm01
	 */
	public void setAbbrNm01(String abbrNm01) {
		this.abbrNm01 = abbrNm01;
	}
	
	/**
	 * Column Info
	 * @param abbrNm02
	 */
	public void setAbbrNm02(String abbrNm02) {
		this.abbrNm02 = abbrNm02;
	}
	
	/**
	 * Column Info
	 * @param abbrNm03
	 */
	public void setAbbrNm03(String abbrNm03) {
		this.abbrNm03 = abbrNm03;
	}
	
	/**
	 * Column Info
	 * @param rsltYrmon
	 */
	public void setRsltYrmon(String rsltYrmon) {
		this.rsltYrmon = rsltYrmon;
	}
	
	/**
	 * Column Info
	 * @param rsltYrmon01
	 */
	public void setRsltYrmon01(String rsltYrmon01) {
		this.rsltYrmon01 = rsltYrmon01;
	}
	
	/**
	 * Column Info
	 * @param lclSal
	 */
	public void setLclSal(String lclSal) {
		this.lclSal = lclSal;
	}
	
	/**
	 * Column Info
	 * @param lclNonSal
	 */
	public void setLclNonSal(String lclNonSal) {
		this.lclNonSal = lclNonSal;
	}
	
	/**
	 * Column Info
	 * @param usdSal
	 */
	public void setUsdSal(String usdSal) {
		this.usdSal = usdSal;
	}
	
	/**
	 * Column Info
	 * @param usdNonSal
	 */
	public void setUsdNonSal(String usdNonSal) {
		this.usdNonSal = usdNonSal;
	}
	
	/**
	 * Column Info
	 * @param salType
	 */
	public void setSalType(String salType) {
		this.salType = salType;
	}
	
	/**
	 * Column Info
	 * @param ratioBa
	 */
	public void setRatioBa(String ratioBa) {
		this.ratioBa = ratioBa;
	}
	
	/**
	 * Column Info
	 * @param ratioFc
	 */
	public void setRatioFc(String ratioFc) {
		this.ratioFc = ratioFc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUsdRatio01(JSPUtil.getParameter(request, "usd_ratio01", ""));
		setUsdAccLoclXchRt(JSPUtil.getParameter(request, "usd_acc_locl_xch_rt", ""));
		setUsdRatio02(JSPUtil.getParameter(request, "usd_ratio02", ""));
		setAbbrNm(JSPUtil.getParameter(request, "abbr_nm", ""));
		setL2(JSPUtil.getParameter(request, "l_2", ""));
		setL3(JSPUtil.getParameter(request, "l_3", ""));
		setUsdRatio03(JSPUtil.getParameter(request, "usd_ratio03", ""));
		setL1(JSPUtil.getParameter(request, "l_1", ""));
		setGenExpnInitAmt(JSPUtil.getParameter(request, "gen_expn_init_amt", ""));
		setUsdAssigned02(JSPUtil.getParameter(request, "usd_assigned02", ""));
		setUsdAssigned(JSPUtil.getParameter(request, "usd_assigned", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUsdAccAssigned(JSPUtil.getParameter(request, "usd_acc_assigned", ""));
		setLevel2(JSPUtil.getParameter(request, "level_2", ""));
		setLevel3(JSPUtil.getParameter(request, "level_3", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLclRatio03(JSPUtil.getParameter(request, "lcl_ratio03", ""));
		setLclRatio02(JSPUtil.getParameter(request, "lcl_ratio02", ""));
		setUsdExpnInitAmt(JSPUtil.getParameter(request, "usd_expn_init_amt", ""));
		setOfcCoDivCd(JSPUtil.getParameter(request, "ofc_co_div_cd", ""));
		setLclAssigned(JSPUtil.getParameter(request, "lcl_assigned", ""));
		setLclRatio01(JSPUtil.getParameter(request, "lcl_ratio01", ""));
		setUsdLoclXchRt(JSPUtil.getParameter(request, "usd_locl_xch_rt", ""));
		setRqstUtVal(JSPUtil.getParameter(request, "rqst_ut_val", ""));
		setUsdAccPerfAmt02(JSPUtil.getParameter(request, "usd_acc_perf_amt02", ""));
		setUsdAccPerfAmt03(JSPUtil.getParameter(request, "usd_acc_perf_amt03", ""));
		setSlsOfcFlg(JSPUtil.getParameter(request, "sls_ofc_flg", ""));
		setUsdAccPerfAmt01(JSPUtil.getParameter(request, "usd_acc_perf_amt01", ""));
		setRgnOfcFlg(JSPUtil.getParameter(request, "rgn_ofc_flg", ""));
		setOfficeExpense(JSPUtil.getParameter(request, "office_expense", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setUsdPerfAmt03(JSPUtil.getParameter(request, "usd_perf_amt03", ""));
		setSubOfcCd(JSPUtil.getParameter(request, "sub_ofc_cd", ""));
		setRtToMon(JSPUtil.getParameter(request, "rt_to_mon", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setRtFmMon(JSPUtil.getParameter(request, "rt_fm_mon", ""));
		setSlpPerfAmt(JSPUtil.getParameter(request, "slp_perf_amt", ""));
		setUsdPerfAmt02(JSPUtil.getParameter(request, "usd_perf_amt02", ""));
		setUsdAccExpnInitAmt(JSPUtil.getParameter(request, "usd_acc_expn_init_amt", ""));
		setUsdPerfAmt01(JSPUtil.getParameter(request, "usd_perf_amt01", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setUsdPerfAmt(JSPUtil.getParameter(request, "usd_perf_amt", ""));
		setSlpPerfAmt01(JSPUtil.getParameter(request, "slp_perf_amt01", ""));
		setSlpPerfAmt02(JSPUtil.getParameter(request, "slp_perf_amt02", ""));
		setUsdAccPerfAmt(JSPUtil.getParameter(request, "usd_acc_perf_amt", ""));
		setSlpPerfAmt03(JSPUtil.getParameter(request, "slp_perf_amt03", ""));
		setRtYr(JSPUtil.getParameter(request, "rt_yr", ""));
		setTicCd(JSPUtil.getParameter(request, "tic_cd", ""));
		setAbbrNm01(JSPUtil.getParameter(request, "abbr_nm01", ""));
		setAbbrNm02(JSPUtil.getParameter(request, "abbr_nm02", ""));
		setAbbrNm03(JSPUtil.getParameter(request, "abbr_nm03", ""));
		setRsltYrmon(JSPUtil.getParameter(request, "rslt_yrmon", ""));
		setRsltYrmon01(JSPUtil.getParameter(request, "rslt_yrmon01", ""));
		setLclSal(JSPUtil.getParameter(request, "lcl_sal", ""));
		setLclNonSal(JSPUtil.getParameter(request, "lcl_non_sal", ""));
		setUsdSal(JSPUtil.getParameter(request, "usd_sal", ""));
		setUsdNonSal(JSPUtil.getParameter(request, "usd_non_sal", ""));
		setSalType(JSPUtil.getParameter(request, "sal_type", ""));
		setRatioBa(JSPUtil.getParameter(request, "ratio_ba", ""));
		setRatioFc(JSPUtil.getParameter(request, "ratio_fc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReportAfterClosingVO[]
	 */
	public ReportAfterClosingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReportAfterClosingVO[]
	 */
	public ReportAfterClosingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReportAfterClosingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] usdRatio01 = (JSPUtil.getParameter(request, prefix	+ "usd_ratio01", length));
			String[] usdAccLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_acc_locl_xch_rt", length));
			String[] usdRatio02 = (JSPUtil.getParameter(request, prefix	+ "usd_ratio02", length));
			String[] abbrNm = (JSPUtil.getParameter(request, prefix	+ "abbr_nm", length));
			String[] l2 = (JSPUtil.getParameter(request, prefix	+ "l_2", length));
			String[] l3 = (JSPUtil.getParameter(request, prefix	+ "l_3", length));
			String[] usdRatio03 = (JSPUtil.getParameter(request, prefix	+ "usd_ratio03", length));
			String[] l1 = (JSPUtil.getParameter(request, prefix	+ "l_1", length));
			String[] genExpnInitAmt = (JSPUtil.getParameter(request, prefix	+ "gen_expn_init_amt", length));
			String[] usdAssigned02 = (JSPUtil.getParameter(request, prefix	+ "usd_assigned02", length));
			String[] usdAssigned = (JSPUtil.getParameter(request, prefix	+ "usd_assigned", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] usdAccAssigned = (JSPUtil.getParameter(request, prefix	+ "usd_acc_assigned", length));
			String[] level2 = (JSPUtil.getParameter(request, prefix	+ "level_2", length));
			String[] level3 = (JSPUtil.getParameter(request, prefix	+ "level_3", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lclRatio03 = (JSPUtil.getParameter(request, prefix	+ "lcl_ratio03", length));
			String[] lclRatio02 = (JSPUtil.getParameter(request, prefix	+ "lcl_ratio02", length));
			String[] usdExpnInitAmt = (JSPUtil.getParameter(request, prefix	+ "usd_expn_init_amt", length));
			String[] ofcCoDivCd = (JSPUtil.getParameter(request, prefix	+ "ofc_co_div_cd", length));
			String[] lclAssigned = (JSPUtil.getParameter(request, prefix	+ "lcl_assigned", length));
			String[] lclRatio01 = (JSPUtil.getParameter(request, prefix	+ "lcl_ratio01", length));
			String[] usdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_locl_xch_rt", length));
			String[] rqstUtVal = (JSPUtil.getParameter(request, prefix	+ "rqst_ut_val", length));
			String[] usdAccPerfAmt02 = (JSPUtil.getParameter(request, prefix	+ "usd_acc_perf_amt02", length));
			String[] usdAccPerfAmt03 = (JSPUtil.getParameter(request, prefix	+ "usd_acc_perf_amt03", length));
			String[] slsOfcFlg = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_flg", length));
			String[] usdAccPerfAmt01 = (JSPUtil.getParameter(request, prefix	+ "usd_acc_perf_amt01", length));
			String[] rgnOfcFlg = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_flg", length));
			String[] officeExpense = (JSPUtil.getParameter(request, prefix	+ "office_expense", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] usdPerfAmt03 = (JSPUtil.getParameter(request, prefix	+ "usd_perf_amt03", length));
			String[] subOfcCd = (JSPUtil.getParameter(request, prefix	+ "sub_ofc_cd", length));
			String[] rtToMon = (JSPUtil.getParameter(request, prefix	+ "rt_to_mon", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] rtFmMon = (JSPUtil.getParameter(request, prefix	+ "rt_fm_mon", length));
			String[] slpPerfAmt = (JSPUtil.getParameter(request, prefix	+ "slp_perf_amt", length));
			String[] usdPerfAmt02 = (JSPUtil.getParameter(request, prefix	+ "usd_perf_amt02", length));
			String[] usdAccExpnInitAmt = (JSPUtil.getParameter(request, prefix	+ "usd_acc_expn_init_amt", length));
			String[] usdPerfAmt01 = (JSPUtil.getParameter(request, prefix	+ "usd_perf_amt01", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] usdPerfAmt = (JSPUtil.getParameter(request, prefix	+ "usd_perf_amt", length));
			String[] slpPerfAmt01 = (JSPUtil.getParameter(request, prefix	+ "slp_perf_amt01", length));
			String[] slpPerfAmt02 = (JSPUtil.getParameter(request, prefix	+ "slp_perf_amt02", length));
			String[] usdAccPerfAmt = (JSPUtil.getParameter(request, prefix	+ "usd_acc_perf_amt", length));
			String[] slpPerfAmt03 = (JSPUtil.getParameter(request, prefix	+ "slp_perf_amt03", length));
			String[] rtYr = (JSPUtil.getParameter(request, prefix	+ "rt_yr", length));
			String[] ticCd = (JSPUtil.getParameter(request, prefix	+ "tic_cd", length));
			String[] abbrNm01 = (JSPUtil.getParameter(request, prefix	+ "abbr_nm01", length));
			String[] abbrNm02 = (JSPUtil.getParameter(request, prefix	+ "abbr_nm02", length));
			String[] abbrNm03 = (JSPUtil.getParameter(request, prefix	+ "abbr_nm03", length));
			String[] rsltYrmon = (JSPUtil.getParameter(request, prefix	+ "rslt_yrmon", length));
			String[] rsltYrmon01 = (JSPUtil.getParameter(request, prefix	+ "rslt_yrmon01", length));
			String[] lclSal = (JSPUtil.getParameter(request, prefix	+ "lcl_sal", length));
			String[] lclNonSal = (JSPUtil.getParameter(request, prefix	+ "lcl_non_sal", length));
			String[] usdSal = (JSPUtil.getParameter(request, prefix	+ "usd_sal", length));
			String[] usdNonSal = (JSPUtil.getParameter(request, prefix	+ "usd_non_sal", length));
			String[] salType = (JSPUtil.getParameter(request, prefix	+ "sal_type", length));
			String[] ratioBa = (JSPUtil.getParameter(request, prefix	+ "ratio_ba", length));
			String[] ratioFc = (JSPUtil.getParameter(request, prefix	+ "ratio_fc", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReportAfterClosingVO();
				if (usdRatio01[i] != null)
					model.setUsdRatio01(usdRatio01[i]);
				if (usdAccLoclXchRt[i] != null)
					model.setUsdAccLoclXchRt(usdAccLoclXchRt[i]);
				if (usdRatio02[i] != null)
					model.setUsdRatio02(usdRatio02[i]);
				if (abbrNm[i] != null)
					model.setAbbrNm(abbrNm[i]);
				if (l2[i] != null)
					model.setL2(l2[i]);
				if (l3[i] != null)
					model.setL3(l3[i]);
				if (usdRatio03[i] != null)
					model.setUsdRatio03(usdRatio03[i]);
				if (l1[i] != null)
					model.setL1(l1[i]);
				if (genExpnInitAmt[i] != null)
					model.setGenExpnInitAmt(genExpnInitAmt[i]);
				if (usdAssigned02[i] != null)
					model.setUsdAssigned02(usdAssigned02[i]);
				if (usdAssigned[i] != null)
					model.setUsdAssigned(usdAssigned[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (usdAccAssigned[i] != null)
					model.setUsdAccAssigned(usdAccAssigned[i]);
				if (level2[i] != null)
					model.setLevel2(level2[i]);
				if (level3[i] != null)
					model.setLevel3(level3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lclRatio03[i] != null)
					model.setLclRatio03(lclRatio03[i]);
				if (lclRatio02[i] != null)
					model.setLclRatio02(lclRatio02[i]);
				if (usdExpnInitAmt[i] != null)
					model.setUsdExpnInitAmt(usdExpnInitAmt[i]);
				if (ofcCoDivCd[i] != null)
					model.setOfcCoDivCd(ofcCoDivCd[i]);
				if (lclAssigned[i] != null)
					model.setLclAssigned(lclAssigned[i]);
				if (lclRatio01[i] != null)
					model.setLclRatio01(lclRatio01[i]);
				if (usdLoclXchRt[i] != null)
					model.setUsdLoclXchRt(usdLoclXchRt[i]);
				if (rqstUtVal[i] != null)
					model.setRqstUtVal(rqstUtVal[i]);
				if (usdAccPerfAmt02[i] != null)
					model.setUsdAccPerfAmt02(usdAccPerfAmt02[i]);
				if (usdAccPerfAmt03[i] != null)
					model.setUsdAccPerfAmt03(usdAccPerfAmt03[i]);
				if (slsOfcFlg[i] != null)
					model.setSlsOfcFlg(slsOfcFlg[i]);
				if (usdAccPerfAmt01[i] != null)
					model.setUsdAccPerfAmt01(usdAccPerfAmt01[i]);
				if (rgnOfcFlg[i] != null)
					model.setRgnOfcFlg(rgnOfcFlg[i]);
				if (officeExpense[i] != null)
					model.setOfficeExpense(officeExpense[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (usdPerfAmt03[i] != null)
					model.setUsdPerfAmt03(usdPerfAmt03[i]);
				if (subOfcCd[i] != null)
					model.setSubOfcCd(subOfcCd[i]);
				if (rtToMon[i] != null)
					model.setRtToMon(rtToMon[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (rtFmMon[i] != null)
					model.setRtFmMon(rtFmMon[i]);
				if (slpPerfAmt[i] != null)
					model.setSlpPerfAmt(slpPerfAmt[i]);
				if (usdPerfAmt02[i] != null)
					model.setUsdPerfAmt02(usdPerfAmt02[i]);
				if (usdAccExpnInitAmt[i] != null)
					model.setUsdAccExpnInitAmt(usdAccExpnInitAmt[i]);
				if (usdPerfAmt01[i] != null)
					model.setUsdPerfAmt01(usdPerfAmt01[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (usdPerfAmt[i] != null)
					model.setUsdPerfAmt(usdPerfAmt[i]);
				if (slpPerfAmt01[i] != null)
					model.setSlpPerfAmt01(slpPerfAmt01[i]);
				if (slpPerfAmt02[i] != null)
					model.setSlpPerfAmt02(slpPerfAmt02[i]);
				if (usdAccPerfAmt[i] != null)
					model.setUsdAccPerfAmt(usdAccPerfAmt[i]);
				if (slpPerfAmt03[i] != null)
					model.setSlpPerfAmt03(slpPerfAmt03[i]);
				if (rtYr[i] != null)
					model.setRtYr(rtYr[i]);
				if (ticCd[i] != null)
					model.setTicCd(ticCd[i]);
				if (abbrNm01[i] != null)
					model.setAbbrNm01(abbrNm01[i]);
				if (abbrNm02[i] != null)
					model.setAbbrNm02(abbrNm02[i]);
				if (abbrNm03[i] != null)
					model.setAbbrNm03(abbrNm03[i]);
				if (rsltYrmon[i] != null)
					model.setRsltYrmon(rsltYrmon[i]);
				if (rsltYrmon01[i] != null)
					model.setRsltYrmon01(rsltYrmon01[i]);
				if (lclSal[i] != null)
					model.setLclSal(lclSal[i]);
				if (lclNonSal[i] != null)
					model.setLclNonSal(lclNonSal[i]);
				if (usdSal[i] != null)
					model.setUsdSal(usdSal[i]);
				if (usdNonSal[i] != null)
					model.setUsdNonSal(usdNonSal[i]);
				if (salType[i] != null)
					model.setSalType(salType[i]);
				if (ratioBa[i] != null)
					model.setRatioBa(ratioBa[i]);
				if (ratioFc[i] != null)
					model.setRatioFc(ratioFc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReportAfterClosingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReportAfterClosingVO[]
	 */
	public ReportAfterClosingVO[] getReportAfterClosingVOs(){
		ReportAfterClosingVO[] vos = (ReportAfterClosingVO[])models.toArray(new ReportAfterClosingVO[models.size()]);
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
		this.usdRatio01 = this.usdRatio01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAccLoclXchRt = this.usdAccLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdRatio02 = this.usdRatio02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.abbrNm = this.abbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.l2 = this.l2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.l3 = this.l3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdRatio03 = this.usdRatio03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.l1 = this.l1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnInitAmt = this.genExpnInitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAssigned02 = this.usdAssigned02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAssigned = this.usdAssigned .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAccAssigned = this.usdAccAssigned .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level2 = this.level2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level3 = this.level3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclRatio03 = this.lclRatio03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclRatio02 = this.lclRatio02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdExpnInitAmt = this.usdExpnInitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCoDivCd = this.ofcCoDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclAssigned = this.lclAssigned .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclRatio01 = this.lclRatio01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLoclXchRt = this.usdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUtVal = this.rqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAccPerfAmt02 = this.usdAccPerfAmt02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAccPerfAmt03 = this.usdAccPerfAmt03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcFlg = this.slsOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAccPerfAmt01 = this.usdAccPerfAmt01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcFlg = this.rgnOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.officeExpense = this.officeExpense .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdPerfAmt03 = this.usdPerfAmt03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subOfcCd = this.subOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtToMon = this.rtToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtFmMon = this.rtFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpPerfAmt = this.slpPerfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdPerfAmt02 = this.usdPerfAmt02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAccExpnInitAmt = this.usdAccExpnInitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdPerfAmt01 = this.usdPerfAmt01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdPerfAmt = this.usdPerfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpPerfAmt01 = this.slpPerfAmt01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpPerfAmt02 = this.slpPerfAmt02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAccPerfAmt = this.usdAccPerfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpPerfAmt03 = this.slpPerfAmt03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtYr = this.rtYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticCd = this.ticCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.abbrNm01 = this.abbrNm01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.abbrNm02 = this.abbrNm02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.abbrNm03 = this.abbrNm03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltYrmon = this.rsltYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltYrmon01 = this.rsltYrmon01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclSal = this.lclSal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclNonSal = this.lclNonSal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdSal = this.usdSal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdNonSal = this.usdNonSal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salType = this.salType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratioBa = this.ratioBa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratioFc = this.ratioFc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
