/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NotIssuedAgingVO.java
*@FileTitle : NotIssuedAgingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.27 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NotIssuedAgingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NotIssuedAgingVO> models = new ArrayList<NotIssuedAgingVO>();
	
	/* Column Info */
	private String belowDay4Cnt = null;
	/* Column Info */
	private String notArrivedAmt = null;
	/* Column Info */
	private String belowDay3Amt = null;
	/* Column Info */
	private String belowDay5Amt = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String wiTermCnt = null;
	/* Column Info */
	private String obCrTermDys = null;
	/* Column Info */
	private String crCltOfcCd = null;
	/* Column Info */
	private String ltCnt = null;
	/* Column Info */
	private String overDay5Cnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String ibCrTermDys = null;
	/* Column Info */
	private String ttlWiTermCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String wiTermAmt = null;
	/* Column Info */
	private String belowDay3Cnt = null;
	/* Column Info */
	private String belowDay2Amt = null;
	/* Column Info */
	private String ttlCnt = null;
	/* Column Info */
	private String ttlWiTermAmt = null;
	/* Column Info */
	private String belowDay1Amt = null;
	/* Column Info */
	private String notArrivedCnt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String belowDay2Cnt = null;
	/* Column Info */
	private String belowDay5Cnt = null;
	/* Column Info */
	private String belowDay4Amt = null;
	/* Column Info */
	private String day3 = null;
	/* Column Info */
	private String day2 = null;
	/* Column Info */
	private String day1 = null;
	/* Column Info */
	private String ttlLtAmt = null;
	/* Column Info */
	private String belowDay1Cnt = null;
	/* Column Info */
	private String day5 = null;
	/* Column Info */
	private String overDay5Amt = null;
	/* Column Info */
	private String day4 = null;
	/* Column Info */
	private String arOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NotIssuedAgingVO() {}

	public NotIssuedAgingVO(String ibflag, String pagerows, String ioBndCd, String crCltOfcCd, String crAmt, String ibCrTermDys, String obCrTermDys, String dpPrcsKnt, String day1, String day2, String day3, String day4, String day5, String ttlCnt, String ttlAmt, String notArrivedCnt, String notArrivedAmt, String wiTermCnt, String wiTermAmt, String ttlWiTermCnt, String ttlWiTermAmt, String ltCnt, String ttlLtAmt, String belowDay1Cnt, String belowDay1Amt, String belowDay2Cnt, String belowDay2Amt, String belowDay3Cnt, String belowDay3Amt, String belowDay4Cnt, String belowDay4Amt, String belowDay5Cnt, String belowDay5Amt, String overDay5Cnt, String overDay5Amt, String arOfcCd) {
		this.belowDay4Cnt = belowDay4Cnt;
		this.notArrivedAmt = notArrivedAmt;
		this.belowDay3Amt = belowDay3Amt;
		this.belowDay5Amt = belowDay5Amt;
		this.ttlAmt = ttlAmt;
		this.wiTermCnt = wiTermCnt;
		this.obCrTermDys = obCrTermDys;
		this.crCltOfcCd = crCltOfcCd;
		this.ltCnt = ltCnt;
		this.overDay5Cnt = overDay5Cnt;
		this.pagerows = pagerows;
		this.dpPrcsKnt = dpPrcsKnt;
		this.ibCrTermDys = ibCrTermDys;
		this.ttlWiTermCnt = ttlWiTermCnt;
		this.ibflag = ibflag;
		this.crAmt = crAmt;
		this.wiTermAmt = wiTermAmt;
		this.belowDay3Cnt = belowDay3Cnt;
		this.belowDay2Amt = belowDay2Amt;
		this.ttlCnt = ttlCnt;
		this.ttlWiTermAmt = ttlWiTermAmt;
		this.belowDay1Amt = belowDay1Amt;
		this.notArrivedCnt = notArrivedCnt;
		this.ioBndCd = ioBndCd;
		this.belowDay2Cnt = belowDay2Cnt;
		this.belowDay5Cnt = belowDay5Cnt;
		this.belowDay4Amt = belowDay4Amt;
		this.day3 = day3;
		this.day2 = day2;
		this.day1 = day1;
		this.ttlLtAmt = ttlLtAmt;
		this.belowDay1Cnt = belowDay1Cnt;
		this.day5 = day5;
		this.overDay5Amt = overDay5Amt;
		this.day4 = day4;
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("below_day4_cnt", getBelowDay4Cnt());
		this.hashColumns.put("not_arrived_amt", getNotArrivedAmt());
		this.hashColumns.put("below_day3_amt", getBelowDay3Amt());
		this.hashColumns.put("below_day5_amt", getBelowDay5Amt());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("wi_term_cnt", getWiTermCnt());
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
		this.hashColumns.put("cr_clt_ofc_cd", getCrCltOfcCd());
		this.hashColumns.put("lt_cnt", getLtCnt());
		this.hashColumns.put("over_day5_cnt", getOverDay5Cnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
		this.hashColumns.put("ttl_wi_term_cnt", getTtlWiTermCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("wi_term_amt", getWiTermAmt());
		this.hashColumns.put("below_day3_cnt", getBelowDay3Cnt());
		this.hashColumns.put("below_day2_amt", getBelowDay2Amt());
		this.hashColumns.put("ttl_cnt", getTtlCnt());
		this.hashColumns.put("ttl_wi_term_amt", getTtlWiTermAmt());
		this.hashColumns.put("below_day1_amt", getBelowDay1Amt());
		this.hashColumns.put("not_arrived_cnt", getNotArrivedCnt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("below_day2_cnt", getBelowDay2Cnt());
		this.hashColumns.put("below_day5_cnt", getBelowDay5Cnt());
		this.hashColumns.put("below_day4_amt", getBelowDay4Amt());
		this.hashColumns.put("day3", getDay3());
		this.hashColumns.put("day2", getDay2());
		this.hashColumns.put("day1", getDay1());
		this.hashColumns.put("ttl_lt_amt", getTtlLtAmt());
		this.hashColumns.put("below_day1_cnt", getBelowDay1Cnt());
		this.hashColumns.put("day5", getDay5());
		this.hashColumns.put("over_day5_amt", getOverDay5Amt());
		this.hashColumns.put("day4", getDay4());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("below_day4_cnt", "belowDay4Cnt");
		this.hashFields.put("not_arrived_amt", "notArrivedAmt");
		this.hashFields.put("below_day3_amt", "belowDay3Amt");
		this.hashFields.put("below_day5_amt", "belowDay5Amt");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("wi_term_cnt", "wiTermCnt");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("cr_clt_ofc_cd", "crCltOfcCd");
		this.hashFields.put("lt_cnt", "ltCnt");
		this.hashFields.put("over_day5_cnt", "overDay5Cnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("ttl_wi_term_cnt", "ttlWiTermCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("wi_term_amt", "wiTermAmt");
		this.hashFields.put("below_day3_cnt", "belowDay3Cnt");
		this.hashFields.put("below_day2_amt", "belowDay2Amt");
		this.hashFields.put("ttl_cnt", "ttlCnt");
		this.hashFields.put("ttl_wi_term_amt", "ttlWiTermAmt");
		this.hashFields.put("below_day1_amt", "belowDay1Amt");
		this.hashFields.put("not_arrived_cnt", "notArrivedCnt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("below_day2_cnt", "belowDay2Cnt");
		this.hashFields.put("below_day5_cnt", "belowDay5Cnt");
		this.hashFields.put("below_day4_amt", "belowDay4Amt");
		this.hashFields.put("day3", "day3");
		this.hashFields.put("day2", "day2");
		this.hashFields.put("day1", "day1");
		this.hashFields.put("ttl_lt_amt", "ttlLtAmt");
		this.hashFields.put("below_day1_cnt", "belowDay1Cnt");
		this.hashFields.put("day5", "day5");
		this.hashFields.put("over_day5_amt", "overDay5Amt");
		this.hashFields.put("day4", "day4");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return belowDay4Cnt
	 */
	public String getBelowDay4Cnt() {
		return this.belowDay4Cnt;
	}
	
	/**
	 * Column Info
	 * @return notArrivedAmt
	 */
	public String getNotArrivedAmt() {
		return this.notArrivedAmt;
	}
	
	/**
	 * Column Info
	 * @return belowDay3Amt
	 */
	public String getBelowDay3Amt() {
		return this.belowDay3Amt;
	}
	
	/**
	 * Column Info
	 * @return belowDay5Amt
	 */
	public String getBelowDay5Amt() {
		return this.belowDay5Amt;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return wiTermCnt
	 */
	public String getWiTermCnt() {
		return this.wiTermCnt;
	}
	
	/**
	 * Column Info
	 * @return obCrTermDys
	 */
	public String getObCrTermDys() {
		return this.obCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return crCltOfcCd
	 */
	public String getCrCltOfcCd() {
		return this.crCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ltCnt
	 */
	public String getLtCnt() {
		return this.ltCnt;
	}
	
	/**
	 * Column Info
	 * @return overDay5Cnt
	 */
	public String getOverDay5Cnt() {
		return this.overDay5Cnt;
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
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @return ibCrTermDys
	 */
	public String getIbCrTermDys() {
		return this.ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return ttlWiTermCnt
	 */
	public String getTtlWiTermCnt() {
		return this.ttlWiTermCnt;
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
	 * @return crAmt
	 */
	public String getCrAmt() {
		return this.crAmt;
	}
	
	/**
	 * Column Info
	 * @return wiTermAmt
	 */
	public String getWiTermAmt() {
		return this.wiTermAmt;
	}
	
	/**
	 * Column Info
	 * @return belowDay3Cnt
	 */
	public String getBelowDay3Cnt() {
		return this.belowDay3Cnt;
	}
	
	/**
	 * Column Info
	 * @return belowDay2Amt
	 */
	public String getBelowDay2Amt() {
		return this.belowDay2Amt;
	}
	
	/**
	 * Column Info
	 * @return ttlCnt
	 */
	public String getTtlCnt() {
		return this.ttlCnt;
	}
	
	/**
	 * Column Info
	 * @return ttlWiTermAmt
	 */
	public String getTtlWiTermAmt() {
		return this.ttlWiTermAmt;
	}
	
	/**
	 * Column Info
	 * @return belowDay1Amt
	 */
	public String getBelowDay1Amt() {
		return this.belowDay1Amt;
	}
	
	/**
	 * Column Info
	 * @return notArrivedCnt
	 */
	public String getNotArrivedCnt() {
		return this.notArrivedCnt;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return belowDay2Cnt
	 */
	public String getBelowDay2Cnt() {
		return this.belowDay2Cnt;
	}
	
	/**
	 * Column Info
	 * @return belowDay5Cnt
	 */
	public String getBelowDay5Cnt() {
		return this.belowDay5Cnt;
	}
	
	/**
	 * Column Info
	 * @return belowDay4Amt
	 */
	public String getBelowDay4Amt() {
		return this.belowDay4Amt;
	}
	
	/**
	 * Column Info
	 * @return day3
	 */
	public String getDay3() {
		return this.day3;
	}
	
	/**
	 * Column Info
	 * @return day2
	 */
	public String getDay2() {
		return this.day2;
	}
	
	/**
	 * Column Info
	 * @return day1
	 */
	public String getDay1() {
		return this.day1;
	}
	
	/**
	 * Column Info
	 * @return ttlLtAmt
	 */
	public String getTtlLtAmt() {
		return this.ttlLtAmt;
	}
	
	/**
	 * Column Info
	 * @return belowDay1Cnt
	 */
	public String getBelowDay1Cnt() {
		return this.belowDay1Cnt;
	}
	
	/**
	 * Column Info
	 * @return day5
	 */
	public String getDay5() {
		return this.day5;
	}
	
	/**
	 * Column Info
	 * @return overDay5Amt
	 */
	public String getOverDay5Amt() {
		return this.overDay5Amt;
	}
	
	/**
	 * Column Info
	 * @return day4
	 */
	public String getDay4() {
		return this.day4;
	}
	

	/**
	 * Column Info
	 * @param belowDay4Cnt
	 */
	public void setBelowDay4Cnt(String belowDay4Cnt) {
		this.belowDay4Cnt = belowDay4Cnt;
	}
	
	/**
	 * Column Info
	 * @param notArrivedAmt
	 */
	public void setNotArrivedAmt(String notArrivedAmt) {
		this.notArrivedAmt = notArrivedAmt;
	}
	
	/**
	 * Column Info
	 * @param belowDay3Amt
	 */
	public void setBelowDay3Amt(String belowDay3Amt) {
		this.belowDay3Amt = belowDay3Amt;
	}
	
	/**
	 * Column Info
	 * @param belowDay5Amt
	 */
	public void setBelowDay5Amt(String belowDay5Amt) {
		this.belowDay5Amt = belowDay5Amt;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param wiTermCnt
	 */
	public void setWiTermCnt(String wiTermCnt) {
		this.wiTermCnt = wiTermCnt;
	}
	
	/**
	 * Column Info
	 * @param obCrTermDys
	 */
	public void setObCrTermDys(String obCrTermDys) {
		this.obCrTermDys = obCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param crCltOfcCd
	 */
	public void setCrCltOfcCd(String crCltOfcCd) {
		this.crCltOfcCd = crCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ltCnt
	 */
	public void setLtCnt(String ltCnt) {
		this.ltCnt = ltCnt;
	}
	
	/**
	 * Column Info
	 * @param overDay5Cnt
	 */
	public void setOverDay5Cnt(String overDay5Cnt) {
		this.overDay5Cnt = overDay5Cnt;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @param ibCrTermDys
	 */
	public void setIbCrTermDys(String ibCrTermDys) {
		this.ibCrTermDys = ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param ttlWiTermCnt
	 */
	public void setTtlWiTermCnt(String ttlWiTermCnt) {
		this.ttlWiTermCnt = ttlWiTermCnt;
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
	 * @param crAmt
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}
	
	/**
	 * Column Info
	 * @param wiTermAmt
	 */
	public void setWiTermAmt(String wiTermAmt) {
		this.wiTermAmt = wiTermAmt;
	}
	
	/**
	 * Column Info
	 * @param belowDay3Cnt
	 */
	public void setBelowDay3Cnt(String belowDay3Cnt) {
		this.belowDay3Cnt = belowDay3Cnt;
	}
	
	/**
	 * Column Info
	 * @param belowDay2Amt
	 */
	public void setBelowDay2Amt(String belowDay2Amt) {
		this.belowDay2Amt = belowDay2Amt;
	}
	
	/**
	 * Column Info
	 * @param ttlCnt
	 */
	public void setTtlCnt(String ttlCnt) {
		this.ttlCnt = ttlCnt;
	}
	
	/**
	 * Column Info
	 * @param ttlWiTermAmt
	 */
	public void setTtlWiTermAmt(String ttlWiTermAmt) {
		this.ttlWiTermAmt = ttlWiTermAmt;
	}
	
	/**
	 * Column Info
	 * @param belowDay1Amt
	 */
	public void setBelowDay1Amt(String belowDay1Amt) {
		this.belowDay1Amt = belowDay1Amt;
	}
	
	/**
	 * Column Info
	 * @param notArrivedCnt
	 */
	public void setNotArrivedCnt(String notArrivedCnt) {
		this.notArrivedCnt = notArrivedCnt;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param belowDay2Cnt
	 */
	public void setBelowDay2Cnt(String belowDay2Cnt) {
		this.belowDay2Cnt = belowDay2Cnt;
	}
	
	/**
	 * Column Info
	 * @param belowDay5Cnt
	 */
	public void setBelowDay5Cnt(String belowDay5Cnt) {
		this.belowDay5Cnt = belowDay5Cnt;
	}
	
	/**
	 * Column Info
	 * @param belowDay4Amt
	 */
	public void setBelowDay4Amt(String belowDay4Amt) {
		this.belowDay4Amt = belowDay4Amt;
	}
	
	/**
	 * Column Info
	 * @param day3
	 */
	public void setDay3(String day3) {
		this.day3 = day3;
	}
	
	/**
	 * Column Info
	 * @param day2
	 */
	public void setDay2(String day2) {
		this.day2 = day2;
	}
	
	/**
	 * Column Info
	 * @param day1
	 */
	public void setDay1(String day1) {
		this.day1 = day1;
	}
	
	/**
	 * Column Info
	 * @param ttlLtAmt
	 */
	public void setTtlLtAmt(String ttlLtAmt) {
		this.ttlLtAmt = ttlLtAmt;
	}
	
	/**
	 * Column Info
	 * @param belowDay1Cnt
	 */
	public void setBelowDay1Cnt(String belowDay1Cnt) {
		this.belowDay1Cnt = belowDay1Cnt;
	}
	
	/**
	 * Column Info
	 * @param day5
	 */
	public void setDay5(String day5) {
		this.day5 = day5;
	}
	
	/**
	 * Column Info
	 * @param overDay5Amt
	 */
	public void setOverDay5Amt(String overDay5Amt) {
		this.overDay5Amt = overDay5Amt;
	}
	
	/**
	 * Column Info
	 * @param day4
	 */
	public void setDay4(String day4) {
		this.day4 = day4;
	}
	
	public String getArOfcCd() {
		return arOfcCd;
	}

	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBelowDay4Cnt(JSPUtil.getParameter(request, "below_day4_cnt", ""));
		setNotArrivedAmt(JSPUtil.getParameter(request, "not_arrived_amt", ""));
		setBelowDay3Amt(JSPUtil.getParameter(request, "below_day3_amt", ""));
		setBelowDay5Amt(JSPUtil.getParameter(request, "below_day5_amt", ""));
		setTtlAmt(JSPUtil.getParameter(request, "ttl_amt", ""));
		setWiTermCnt(JSPUtil.getParameter(request, "wi_term_cnt", ""));
		setObCrTermDys(JSPUtil.getParameter(request, "ob_cr_term_dys", ""));
		setCrCltOfcCd(JSPUtil.getParameter(request, "cr_clt_ofc_cd", ""));
		setLtCnt(JSPUtil.getParameter(request, "lt_cnt", ""));
		setOverDay5Cnt(JSPUtil.getParameter(request, "over_day5_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, "dp_prcs_knt", ""));
		setIbCrTermDys(JSPUtil.getParameter(request, "ib_cr_term_dys", ""));
		setTtlWiTermCnt(JSPUtil.getParameter(request, "ttl_wi_term_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setWiTermAmt(JSPUtil.getParameter(request, "wi_term_amt", ""));
		setBelowDay3Cnt(JSPUtil.getParameter(request, "below_day3_cnt", ""));
		setBelowDay2Amt(JSPUtil.getParameter(request, "below_day2_amt", ""));
		setTtlCnt(JSPUtil.getParameter(request, "ttl_cnt", ""));
		setTtlWiTermAmt(JSPUtil.getParameter(request, "ttl_wi_term_amt", ""));
		setBelowDay1Amt(JSPUtil.getParameter(request, "below_day1_amt", ""));
		setNotArrivedCnt(JSPUtil.getParameter(request, "not_arrived_cnt", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setBelowDay2Cnt(JSPUtil.getParameter(request, "below_day2_cnt", ""));
		setBelowDay5Cnt(JSPUtil.getParameter(request, "below_day5_cnt", ""));
		setBelowDay4Amt(JSPUtil.getParameter(request, "below_day4_amt", ""));
		setDay3(JSPUtil.getParameter(request, "day3", ""));
		setDay2(JSPUtil.getParameter(request, "day2", ""));
		setDay1(JSPUtil.getParameter(request, "day1", ""));
		setTtlLtAmt(JSPUtil.getParameter(request, "ttl_lt_amt", ""));
		setBelowDay1Cnt(JSPUtil.getParameter(request, "below_day1_cnt", ""));
		setDay5(JSPUtil.getParameter(request, "day5", ""));
		setOverDay5Amt(JSPUtil.getParameter(request, "over_day5_amt", ""));
		setDay4(JSPUtil.getParameter(request, "day4", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NotIssuedAgingVO[]
	 */
	public NotIssuedAgingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NotIssuedAgingVO[]
	 */
	public NotIssuedAgingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NotIssuedAgingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] belowDay4Cnt = (JSPUtil.getParameter(request, prefix	+ "below_day4_cnt", length));
			String[] notArrivedAmt = (JSPUtil.getParameter(request, prefix	+ "not_arrived_amt", length));
			String[] belowDay3Amt = (JSPUtil.getParameter(request, prefix	+ "below_day3_amt", length));
			String[] belowDay5Amt = (JSPUtil.getParameter(request, prefix	+ "below_day5_amt", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] wiTermCnt = (JSPUtil.getParameter(request, prefix	+ "wi_term_cnt", length));
			String[] obCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ob_cr_term_dys", length));
			String[] crCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "cr_clt_ofc_cd", length));
			String[] ltCnt = (JSPUtil.getParameter(request, prefix	+ "lt_cnt", length));
			String[] overDay5Cnt = (JSPUtil.getParameter(request, prefix	+ "over_day5_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ib_cr_term_dys", length));
			String[] ttlWiTermCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_wi_term_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] wiTermAmt = (JSPUtil.getParameter(request, prefix	+ "wi_term_amt", length));
			String[] belowDay3Cnt = (JSPUtil.getParameter(request, prefix	+ "below_day3_cnt", length));
			String[] belowDay2Amt = (JSPUtil.getParameter(request, prefix	+ "below_day2_amt", length));
			String[] ttlCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_cnt", length));
			String[] ttlWiTermAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_wi_term_amt", length));
			String[] belowDay1Amt = (JSPUtil.getParameter(request, prefix	+ "below_day1_amt", length));
			String[] notArrivedCnt = (JSPUtil.getParameter(request, prefix	+ "not_arrived_cnt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] belowDay2Cnt = (JSPUtil.getParameter(request, prefix	+ "below_day2_cnt", length));
			String[] belowDay5Cnt = (JSPUtil.getParameter(request, prefix	+ "below_day5_cnt", length));
			String[] belowDay4Amt = (JSPUtil.getParameter(request, prefix	+ "below_day4_amt", length));
			String[] day3 = (JSPUtil.getParameter(request, prefix	+ "day3", length));
			String[] day2 = (JSPUtil.getParameter(request, prefix	+ "day2", length));
			String[] day1 = (JSPUtil.getParameter(request, prefix	+ "day1", length));
			String[] ttlLtAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_lt_amt", length));
			String[] belowDay1Cnt = (JSPUtil.getParameter(request, prefix	+ "below_day1_cnt", length));
			String[] day5 = (JSPUtil.getParameter(request, prefix	+ "day5", length));
			String[] overDay5Amt = (JSPUtil.getParameter(request, prefix	+ "over_day5_amt", length));
			String[] day4 = (JSPUtil.getParameter(request, prefix	+ "day4", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new NotIssuedAgingVO();
				if (belowDay4Cnt[i] != null)
					model.setBelowDay4Cnt(belowDay4Cnt[i]);
				if (notArrivedAmt[i] != null)
					model.setNotArrivedAmt(notArrivedAmt[i]);
				if (belowDay3Amt[i] != null)
					model.setBelowDay3Amt(belowDay3Amt[i]);
				if (belowDay5Amt[i] != null)
					model.setBelowDay5Amt(belowDay5Amt[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (wiTermCnt[i] != null)
					model.setWiTermCnt(wiTermCnt[i]);
				if (obCrTermDys[i] != null)
					model.setObCrTermDys(obCrTermDys[i]);
				if (crCltOfcCd[i] != null)
					model.setCrCltOfcCd(crCltOfcCd[i]);
				if (ltCnt[i] != null)
					model.setLtCnt(ltCnt[i]);
				if (overDay5Cnt[i] != null)
					model.setOverDay5Cnt(overDay5Cnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (ibCrTermDys[i] != null)
					model.setIbCrTermDys(ibCrTermDys[i]);
				if (ttlWiTermCnt[i] != null)
					model.setTtlWiTermCnt(ttlWiTermCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (wiTermAmt[i] != null)
					model.setWiTermAmt(wiTermAmt[i]);
				if (belowDay3Cnt[i] != null)
					model.setBelowDay3Cnt(belowDay3Cnt[i]);
				if (belowDay2Amt[i] != null)
					model.setBelowDay2Amt(belowDay2Amt[i]);
				if (ttlCnt[i] != null)
					model.setTtlCnt(ttlCnt[i]);
				if (ttlWiTermAmt[i] != null)
					model.setTtlWiTermAmt(ttlWiTermAmt[i]);
				if (belowDay1Amt[i] != null)
					model.setBelowDay1Amt(belowDay1Amt[i]);
				if (notArrivedCnt[i] != null)
					model.setNotArrivedCnt(notArrivedCnt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (belowDay2Cnt[i] != null)
					model.setBelowDay2Cnt(belowDay2Cnt[i]);
				if (belowDay5Cnt[i] != null)
					model.setBelowDay5Cnt(belowDay5Cnt[i]);
				if (belowDay4Amt[i] != null)
					model.setBelowDay4Amt(belowDay4Amt[i]);
				if (day3[i] != null)
					model.setDay3(day3[i]);
				if (day2[i] != null)
					model.setDay2(day2[i]);
				if (day1[i] != null)
					model.setDay1(day1[i]);
				if (ttlLtAmt[i] != null)
					model.setTtlLtAmt(ttlLtAmt[i]);
				if (belowDay1Cnt[i] != null)
					model.setBelowDay1Cnt(belowDay1Cnt[i]);
				if (day5[i] != null)
					model.setDay5(day5[i]);
				if (overDay5Amt[i] != null)
					model.setOverDay5Amt(overDay5Amt[i]);
				if (day4[i] != null)
					model.setDay4(day4[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNotIssuedAgingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NotIssuedAgingVO[]
	 */
	public NotIssuedAgingVO[] getNotIssuedAgingVOs(){
		NotIssuedAgingVO[] vos = (NotIssuedAgingVO[])models.toArray(new NotIssuedAgingVO[models.size()]);
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
		this.belowDay4Cnt = this.belowDay4Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notArrivedAmt = this.notArrivedAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.belowDay3Amt = this.belowDay3Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.belowDay5Amt = this.belowDay5Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wiTermCnt = this.wiTermCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys = this.obCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCltOfcCd = this.crCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltCnt = this.ltCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDay5Cnt = this.overDay5Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys = this.ibCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlWiTermCnt = this.ttlWiTermCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wiTermAmt = this.wiTermAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.belowDay3Cnt = this.belowDay3Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.belowDay2Amt = this.belowDay2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCnt = this.ttlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlWiTermAmt = this.ttlWiTermAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.belowDay1Amt = this.belowDay1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notArrivedCnt = this.notArrivedCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.belowDay2Cnt = this.belowDay2Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.belowDay5Cnt = this.belowDay5Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.belowDay4Amt = this.belowDay4Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day3 = this.day3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day2 = this.day2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day1 = this.day1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLtAmt = this.ttlLtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.belowDay1Cnt = this.belowDay1Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day5 = this.day5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDay5Amt = this.overDay5Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.day4 = this.day4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
