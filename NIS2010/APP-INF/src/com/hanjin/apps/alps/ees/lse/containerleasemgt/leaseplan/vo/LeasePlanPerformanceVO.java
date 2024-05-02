/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeasePlanPerformanceVO.java
*@FileTitle : LeasePlanPerformanceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.15
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.15 노정용 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 노정용
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class LeasePlanPerformanceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LeasePlanPerformanceVO> models = new ArrayList<LeasePlanPerformanceVO>();
	
	/* Column Info */
	private String frthQurtTot = null;
	/* Page Number */
	private String pagerows = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String plnYrmon = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String scndQurtTot = null;
	/* Column Info */
	private String yrTot = null;
	/* Column Info */
	private String mnth12 = null;
	/* Column Info */
	private String mnth11 = null;
	/* Column Info */
	private String mnth10 = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String thrdQurtTot = null;
	/* Column Info */
	private String mnth04 = null;
	/* Column Info */
	private String mnth03 = null;
	/* Column Info */
	private String mnth06 = null;
	/* Column Info */
	private String mnth05 = null;
	/* Column Info */
	private String mnth08 = null;
	/* Column Info */
	private String mnth07 = null;
	/* Column Info */
	private String mnth09 = null;
	/* Column Info */
	private String mftVndrSeq = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String deYr = null;
	/* Column Info */
	private String mnth02 = null;
	/* Column Info */
	private String frstQurtTot = null;
	/* Column Info */
	private String mnth01 = null;
	/* Column Info */
	private String rsltTp = null;
	/* Column Info */
	private String rsltTpSeq = null;
	/* Column Info */
	private String refNo = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	/**
	 * 생성자
	 */
	public LeasePlanPerformanceVO() {}

	/**
	 * 생성자
	 */
	public LeasePlanPerformanceVO(String ibflag, String pagerows, String plnYr, String plnYrmon, 
			String deYr, String agmtCtyCd, String agmtSeq, String agmtNo, String mftVndrSeq, 
			String vndrAbbrNm, String vndrLglEngNm, String delCd, String cntrTpszCd, 
			String rsltTp, String mnth01, String mnth02, String mnth03, String mnth04, 
			String mnth05, String mnth06, String mnth07, String mnth08, String mnth09, 
			String mnth10, String mnth11, String mnth12, String frstQurtTot, String scndQurtTot, 
			String thrdQurtTot, String frthQurtTot, String yrTot, String rsltTpSeq, String refNo) {
		this.plnYr = plnYr;
		this.plnYrmon = plnYrmon;
		this.frthQurtTot = frthQurtTot;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntrTpszCd = cntrTpszCd;
		this.scndQurtTot = scndQurtTot;
		this.yrTot = yrTot;
		this.mnth12 = mnth12;
		this.mnth11 = mnth11;
		this.mnth10 = mnth10;
		this.delCd = delCd;
		this.agmtNo = agmtNo;
		this.agmtSeq = agmtSeq;
		this.agmtCtyCd = agmtCtyCd;
		this.thrdQurtTot = thrdQurtTot;
		this.mnth04 = mnth04;
		this.mnth03 = mnth03;
		this.mnth06 = mnth06;
		this.mnth05 = mnth05;
		this.mnth08 = mnth08;
		this.mnth07 = mnth07;
		this.mnth09 = mnth09;
		this.mftVndrSeq = mftVndrSeq;
		this.vndrAbbrNm = vndrAbbrNm;
		this.vndrLglEngNm = vndrLglEngNm;
		this.deYr = deYr;
		this.mnth02 = mnth02;
		this.frstQurtTot = frstQurtTot;
		this.mnth01 = mnth01;
		this.rsltTp = rsltTp;
		this.rsltTpSeq = rsltTpSeq;
		this.refNo = refNo;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frth_qurt_tot", getFrthQurtTot());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("scnd_qurt_tot", getScndQurtTot());
		this.hashColumns.put("yr_tot", getYrTot());
		this.hashColumns.put("mnth_12", getMnth12());
		this.hashColumns.put("mnth_11", getMnth11());
		this.hashColumns.put("mnth_10", getMnth10());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("thrd_qurt_tot", getThrdQurtTot());
		this.hashColumns.put("mnth_04", getMnth04());
		this.hashColumns.put("mnth_03", getMnth03());
		this.hashColumns.put("mnth_06", getMnth06());
		this.hashColumns.put("mnth_05", getMnth05());
		this.hashColumns.put("mnth_08", getMnth08());
		this.hashColumns.put("mnth_07", getMnth07());
		this.hashColumns.put("mnth_09", getMnth09());		
		this.hashColumns.put("mft_vndr_seq", getMftVndrSeq());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("de_yr", getDeYr());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("pln_yrmon", getPlnYrmon());
		this.hashColumns.put("mnth_02", getMnth02());
		this.hashColumns.put("frst_qurt_tot", getFrstQurtTot());
		this.hashColumns.put("mnth_01", getMnth01());
		this.hashColumns.put("rslt_tp", getRsltTp());
		this.hashColumns.put("rslt_tp_seq", getRsltTpSeq());
		this.hashColumns.put("ref_no", getRefNo());

		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frth_qurt_tot", "frthQurtTot");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("scnd_qurt_tot", "scndQurtTot");
		this.hashFields.put("yr_tot", "yrTot");
		this.hashFields.put("mnth_12", "mnth12");
		this.hashFields.put("mnth_11", "mnth11");
		this.hashFields.put("mnth_10", "mnth10");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("thrd_qurt_tot", "thrdQurtTot");
		this.hashFields.put("mnth_04", "mnth04");
		this.hashFields.put("mnth_03", "mnth03");
		this.hashFields.put("mnth_06", "mnth06");
		this.hashFields.put("mnth_05", "mnth05");
		this.hashFields.put("mnth_08", "mnth08");
		this.hashFields.put("mnth_07", "mnth07");
		this.hashFields.put("mnth_09", "mnth09");
		this.hashFields.put("mft_vndr_seq", "mftVndrSeq");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");		
		this.hashFields.put("de_yr", "deYr");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("pln_yrmon", "plnYrmon");
		this.hashFields.put("mnth_02", "mnth02");
		this.hashFields.put("frst_qurt_tot", "frstQurtTot");
		this.hashFields.put("mnth_01", "mnth01");
		this.hashFields.put("rslt_tp", "rsltTp");
		this.hashFields.put("rslt_tp_seq", "rsltTpSeq");
		this.hashFields.put("ref_no", "refNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frthQurtTot
	 */
	public String getFrthQurtTot() {
		return this.frthQurtTot;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return scndQurtTot
	 */
	public String getScndQurtTot() {
		return this.scndQurtTot;
	}
	
	/**
	 * Column Info
	 * @return yrTot
	 */
	public String getYrTot() {
		return this.yrTot;
	}
	
	/**
	 * Column Info
	 * @return mnth12
	 */
	public String getMnth12() {
		return this.mnth12;
	}
	
	/**
	 * Column Info
	 * @return mnth11
	 */
	public String getMnth11() {
		return this.mnth11;
	}
	
	/**
	 * Column Info
	 * @return mnth10
	 */
	public String getMnth10() {
		return this.mnth10;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return thrdQurtTot
	 */
	public String getThrdQurtTot() {
		return this.thrdQurtTot;
	}
	
	/**
	 * Column Info
	 * @return mnth04
	 */
	public String getMnth04() {
		return this.mnth04;
	}
	
	/**
	 * Column Info
	 * @return mnth03
	 */
	public String getMnth03() {
		return this.mnth03;
	}
	
	/**
	 * Column Info
	 * @return mnth06
	 */
	public String getMnth06() {
		return this.mnth06;
	}
	
	/**
	 * Column Info
	 * @return mnth05
	 */
	public String getMnth05() {
		return this.mnth05;
	}
	
	/**
	 * Column Info
	 * @return mnth08
	 */
	public String getMnth08() {
		return this.mnth08;
	}
	
	/**
	 * Column Info
	 * @return mnth07
	 */
	public String getMnth07() {
		return this.mnth07;
	}
	
	/**
	 * Column Info
	 * @return mnth09
	 */
	public String getMnth09() {
		return this.mnth09;
	}
	
	/**
	 * Column Info
	 * @return mftVndrSeq
	 */
	public String getMftVndrSeq() {
		return this.mftVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return deYr
	 */
	public String getDeYr() {
		return this.deYr;
	}
	
	/**
	 * Column Info
	 * @return mnth02
	 */
	public String getMnth02() {
		return this.mnth02;
	}
	
	/**
	 * Column Info
	 * @return frstQurtTot
	 */
	public String getFrstQurtTot() {
		return this.frstQurtTot;
	}
	
	/**
	 * Column Info
	 * @return mnth01
	 */
	public String getMnth01() {
		return this.mnth01;
	}
	
	/**
	 * Column Info
	 * @return rsltTp
	 */
	public String getRsltTp() {
		return this.rsltTp;
	}
	
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	/**
	 * Column Info
	 * @param frthQurtTot
	 */
	public void setFrthQurtTot(String frthQurtTot) {
		this.frthQurtTot = frthQurtTot;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param scndQurtTot
	 */
	public void setScndQurtTot(String scndQurtTot) {
		this.scndQurtTot = scndQurtTot;
	}
	
	/**
	 * Column Info
	 * @param yrTot
	 */
	public void setYrTot(String yrTot) {
		this.yrTot = yrTot;
	}
	
	/**
	 * Column Info
	 * @param mnth12
	 */
	public void setMnth12(String mnth12) {
		this.mnth12 = mnth12;
	}
	
	/**
	 * Column Info
	 * @param mnth11
	 */
	public void setMnth11(String mnth11) {
		this.mnth11 = mnth11;
	}
	
	/**
	 * Column Info
	 * @param mnth10
	 */
	public void setMnth10(String mnth10) {
		this.mnth10 = mnth10;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param thrdQurtTot
	 */
	public void setThrdQurtTot(String thrdQurtTot) {
		this.thrdQurtTot = thrdQurtTot;
	}
	
	/**
	 * Column Info
	 * @param mnth04
	 */
	public void setMnth04(String mnth04) {
		this.mnth04 = mnth04;
	}
	
	/**
	 * Column Info
	 * @param mnth03
	 */
	public void setMnth03(String mnth03) {
		this.mnth03 = mnth03;
	}
	
	/**
	 * Column Info
	 * @param mnth06
	 */
	public void setMnth06(String mnth06) {
		this.mnth06 = mnth06;
	}
	
	/**
	 * Column Info
	 * @param mnth05
	 */
	public void setMnth05(String mnth05) {
		this.mnth05 = mnth05;
	}
	
	/**
	 * Column Info
	 * @param mnth08
	 */
	public void setMnth08(String mnth08) {
		this.mnth08 = mnth08;
	}
	
	/**
	 * Column Info
	 * @param mnth07
	 */
	public void setMnth07(String mnth07) {
		this.mnth07 = mnth07;
	}
	
	/**
	 * Column Info
	 * @param mnth09
	 */
	public void setMnth09(String mnth09) {
		this.mnth09 = mnth09;
	}
	
	/**
	 * Column Info
	 * @param mftVndrSeq
	 */
	public void setMftVndrSeq(String mftVndrSeq) {
		this.mftVndrSeq = mftVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param deYr
	 */
	public void setDeYr(String deYr) {
		this.deYr = deYr;
	}
	
	/**
	 * Column Info
	 * @param mnth02
	 */
	public void setMnth02(String mnth02) {
		this.mnth02 = mnth02;
	}
	
	/**
	 * Column Info
	 * @param frstQurtTot
	 */
	public void setFrstQurtTot(String frstQurtTot) {
		this.frstQurtTot = frstQurtTot;
	}
	
	/**
	 * Column Info
	 * @param mnth01
	 */
	public void setMnth01(String mnth01) {
		this.mnth01 = mnth01;
	}
	
	/**
	 * Column Info
	 * @param rsltTp
	 */
	public void setRsltTp(String rsltTp) {
		this.rsltTp = rsltTp;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFrthQurtTot(JSPUtil.getParameter(request, "frth_qurt_tot", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setScndQurtTot(JSPUtil.getParameter(request, "scnd_qurt_tot", ""));
		setYrTot(JSPUtil.getParameter(request, "yr_tot", ""));
		setMnth12(JSPUtil.getParameter(request, "mnth_12", ""));
		setMnth11(JSPUtil.getParameter(request, "mnth_11", ""));
		setMnth10(JSPUtil.getParameter(request, "mnth_10", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setThrdQurtTot(JSPUtil.getParameter(request, "thrd_qurt_tot", ""));
		setMnth04(JSPUtil.getParameter(request, "mnth_04", ""));
		setMnth03(JSPUtil.getParameter(request, "mnth_03", ""));
		setMnth06(JSPUtil.getParameter(request, "mnth_06", ""));
		setMnth05(JSPUtil.getParameter(request, "mnth_05", ""));
		setMnth08(JSPUtil.getParameter(request, "mnth_08", ""));
		setMnth07(JSPUtil.getParameter(request, "mnth_07", ""));
		setMnth09(JSPUtil.getParameter(request, "mnth_09", ""));
		setMftVndrSeq(JSPUtil.getParameter(request, "mft_vndr_seq", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));		
		setDeYr(JSPUtil.getParameter(request, "de_yr", ""));
		setMnth02(JSPUtil.getParameter(request, "mnth_02", ""));
		setFrstQurtTot(JSPUtil.getParameter(request, "frst_qurt_tot", ""));
		setMnth01(JSPUtil.getParameter(request, "mnth_01", ""));
		setRsltTp(JSPUtil.getParameter(request, "rslt_tp", ""));
		setRsltTpSeq(JSPUtil.getParameter(request, "rslt_tp_seq", ""));
		setPlnYr(JSPUtil.getParameter(request, "pln_yr", ""));
		setPlnYrmon(JSPUtil.getParameter(request, "pln_yrmon", ""));
		setRefNo(JSPUtil.getParameter(request,  "ref_no", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return LeasePlanPerformanceVO[]
	 */
	public LeasePlanPerformanceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LeasePlanPerformanceVO[]
	 */
	public LeasePlanPerformanceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LeasePlanPerformanceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frthQurtTot = (JSPUtil.getParameter(request, prefix	+ "frth_qurt_tot".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] scndQurtTot = (JSPUtil.getParameter(request, prefix	+ "scnd_qurt_tot".trim(), length));
			String[] yrTot = (JSPUtil.getParameter(request, prefix	+ "yr_tot".trim(), length));
			String[] mnth12 = (JSPUtil.getParameter(request, prefix	+ "mnth_12".trim(), length));
			String[] mnth11 = (JSPUtil.getParameter(request, prefix	+ "mnth_11".trim(), length));
			String[] mnth10 = (JSPUtil.getParameter(request, prefix	+ "mnth_10".trim(), length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd".trim(), length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no".trim(), length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq".trim(), length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd".trim(), length));
			String[] thrdQurtTot = (JSPUtil.getParameter(request, prefix	+ "thrd_qurt_tot".trim(), length));
			String[] mnth04 = (JSPUtil.getParameter(request, prefix	+ "mnth_04".trim(), length));
			String[] mnth03 = (JSPUtil.getParameter(request, prefix	+ "mnth_03".trim(), length));
			String[] mnth06 = (JSPUtil.getParameter(request, prefix	+ "mnth_06".trim(), length));
			String[] mnth05 = (JSPUtil.getParameter(request, prefix	+ "mnth_05".trim(), length));
			String[] mnth08 = (JSPUtil.getParameter(request, prefix	+ "mnth_08".trim(), length));
			String[] mnth07 = (JSPUtil.getParameter(request, prefix	+ "mnth_07".trim(), length));
			String[] mnth09 = (JSPUtil.getParameter(request, prefix	+ "mnth_09".trim(), length));
			String[] mftVndrSeq = (JSPUtil.getParameter(request, prefix	+ "mft_vndr_seq".trim(), length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm".trim(), length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm".trim(), length));			
			String[] deYr = (JSPUtil.getParameter(request, prefix	+ "de_yr".trim(), length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr".trim(), length));
			String[] plnYrmon = (JSPUtil.getParameter(request, prefix	+ "pln_yrmon".trim(), length));
			String[] mnth02 = (JSPUtil.getParameter(request, prefix	+ "mnth_02".trim(), length));
			String[] frstQurtTot = (JSPUtil.getParameter(request, prefix	+ "frst_qurt_tot".trim(), length));
			String[] mnth01 = (JSPUtil.getParameter(request, prefix	+ "mnth_01".trim(), length));
			String[] rsltTp = (JSPUtil.getParameter(request, prefix	+ "rslt_tp".trim(), length));
			String[] rsltTpSeq = (JSPUtil.getParameter(request, prefix	+ "rslt_tp_seq".trim(), length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new LeasePlanPerformanceVO();
				if (frthQurtTot[i] != null)
					model.setFrthQurtTot(frthQurtTot[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (scndQurtTot[i] != null)
					model.setScndQurtTot(scndQurtTot[i]);
				if (yrTot[i] != null)
					model.setYrTot(yrTot[i]);
				if (mnth12[i] != null)
					model.setMnth12(mnth12[i]);
				if (mnth11[i] != null)
					model.setMnth11(mnth11[i]);
				if (mnth10[i] != null)
					model.setMnth10(mnth10[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (thrdQurtTot[i] != null)
					model.setThrdQurtTot(thrdQurtTot[i]);
				if (mnth04[i] != null)
					model.setMnth04(mnth04[i]);
				if (mnth03[i] != null)
					model.setMnth03(mnth03[i]);
				if (mnth06[i] != null)
					model.setMnth06(mnth06[i]);
				if (mnth05[i] != null)
					model.setMnth05(mnth05[i]);
				if (mnth08[i] != null)
					model.setMnth08(mnth08[i]);
				if (mnth07[i] != null)
					model.setMnth07(mnth07[i]);
				if (mnth09[i] != null)
					model.setMnth09(mnth09[i]);
				if (mftVndrSeq[i] != null)
					model.setMftVndrSeq(mftVndrSeq[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);				
				if (deYr[i] != null)
					model.setDeYr(deYr[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (plnYrmon[i] != null)
					model.setPlnYrmon(plnYrmon[i]);
				if (mnth02[i] != null)
					model.setMnth02(mnth02[i]);
				if (frstQurtTot[i] != null)
					model.setFrstQurtTot(frstQurtTot[i]);
				if (mnth01[i] != null)
					model.setMnth01(mnth01[i]);
				if (rsltTp[i] != null)
					model.setRsltTp(rsltTp[i]);
				if (rsltTpSeq[i] != null)
					model.setRsltTpSeq(rsltTpSeq[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLeasePlanPerformanceVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return LeasePlanPerformanceVO[]
	 */
	public LeasePlanPerformanceVO[] getLeasePlanPerformanceVOs(){
		LeasePlanPerformanceVO[] vos = (LeasePlanPerformanceVO[])models.toArray(new LeasePlanPerformanceVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void unDataFormat(){
		this.frthQurtTot = this.frthQurtTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scndQurtTot = this.scndQurtTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrTot = this.yrTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth12 = this.mnth12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth11 = this.mnth11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth10 = this.mnth10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thrdQurtTot = this.thrdQurtTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth04 = this.mnth04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth03 = this.mnth03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth06 = this.mnth06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth05 = this.mnth05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth08 = this.mnth08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth07 = this.mnth07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth09 = this.mnth09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftVndrSeq = this.mftVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deYr = this.deYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth02 = this.mnth02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frstQurtTot = this.frstQurtTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth01 = this.mnth01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltTp = this.rsltTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltTpSeq = this.rsltTpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public void setRsltTpSeq(String rsltTpSeq) {
		this.rsltTpSeq = rsltTpSeq;
	}

	public String getRsltTpSeq() {
		return rsltTpSeq;
	}

	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}
	
	public void setPlnYrmon(String plnYrmon) {
		this.plnYrmon = plnYrmon;
	}

	public String getPlnYr() {
		return plnYr;
	}
	
	public String getPlnYrmon() {
		return plnYrmon;
	}
}
