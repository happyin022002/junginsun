/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpensePlanPerformanceVO.java
*@FileTitle : ExpensePlanPerformanceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.30 장준우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExpensePlanPerformanceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExpensePlanPerformanceVO> models = new ArrayList<ExpensePlanPerformanceVO>();
	
	private Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo");
	
	/* Page Number */
	private String pagerows = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String verSeq = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String eqKndNm = null;
	/* Column Info */
	private String eqTermNm = null;
	/* Column Info */
	private String frthQurtTot = null;
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
	private String mnth02 = null;
	/* Column Info */
	private String frstQurtTot = null;
	/* Column Info */
	private String mnth01 = null;
	/* Column Info */
	private String rsltTp = null;
	/* Column Info */
	private String rsltTpSeq = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	/**
	 * 생성자
	 */
	public ExpensePlanPerformanceVO() {}

	/**
	 * 생성자
	 */
	public ExpensePlanPerformanceVO(String ibflag, String pagerows, String plnYr, String verSeq, String eqKndCd, String eqKndNm, String eqTermNm, String rsltTp, String mnth01, String mnth02, String mnth03, String mnth04, String mnth05, String mnth06, String mnth07, String mnth08, String mnth09, String mnth10, String mnth11, String mnth12, String frstQurtTot, String scndQurtTot, String thrdQurtTot, String frthQurtTot, String yrTot, String rsltTpSeq) {
		this.plnYr = plnYr;
		this.verSeq = verSeq;
		this.eqKndCd = eqKndCd;
		this.eqKndNm = eqKndNm;
		this.eqTermNm = eqTermNm;
		this.frthQurtTot = frthQurtTot;
		this.pagerows = pagerows;
		this.ibflag = ibflag;		
		this.scndQurtTot = scndQurtTot;
		this.yrTot = yrTot;
		this.mnth12 = mnth12;
		this.mnth11 = mnth11;
		this.mnth10 = mnth10;
		this.thrdQurtTot = thrdQurtTot;
		this.mnth04 = mnth04;
		this.mnth03 = mnth03;
		this.mnth06 = mnth06;
		this.mnth05 = mnth05;
		this.mnth08 = mnth08;
		this.mnth07 = mnth07;
		this.mnth09 = mnth09;
		this.mnth02 = mnth02;
		this.frstQurtTot = frstQurtTot;
		this.mnth01 = mnth01;
		this.rsltTp = rsltTp;
		this.rsltTpSeq = rsltTpSeq;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frth_qurt_tot", getFrthQurtTot());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eq_knd_nm", getEqKndNm());
		this.hashColumns.put("scnd_qurt_tot", getScndQurtTot());
		this.hashColumns.put("yr_tot", getYrTot());
		this.hashColumns.put("mnth_12", getMnth12());
		this.hashColumns.put("mnth_11", getMnth11());
		this.hashColumns.put("mnth_10", getMnth10());
		this.hashColumns.put("eq_term_nm", getEqTermNm());
		this.hashColumns.put("thrd_qurt_tot", getThrdQurtTot());
		this.hashColumns.put("mnth_04", getMnth04());
		this.hashColumns.put("mnth_03", getMnth03());
		this.hashColumns.put("mnth_06", getMnth06());
		this.hashColumns.put("mnth_05", getMnth05());
		this.hashColumns.put("mnth_08", getMnth08());
		this.hashColumns.put("mnth_07", getMnth07());
		this.hashColumns.put("mnth_09", getMnth09());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("mnth_02", getMnth02());
		this.hashColumns.put("frst_qurt_tot", getFrstQurtTot());
		this.hashColumns.put("mnth_01", getMnth01());
		this.hashColumns.put("rslt_tp", getRsltTp());
		this.hashColumns.put("rslt_tp_seq", getRsltTpSeq());

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
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eq_knd_nm", "eqKndNm");
		this.hashFields.put("scnd_qurt_tot", "scndQurtTot");
		this.hashFields.put("yr_tot", "yrTot");
		this.hashFields.put("mnth_12", "mnth12");
		this.hashFields.put("mnth_11", "mnth11");
		this.hashFields.put("mnth_10", "mnth10");
		this.hashFields.put("eq_term_nm", "eqTermNm");
		this.hashFields.put("thrd_qurt_tot", "thrdQurtTot");
		this.hashFields.put("mnth_04", "mnth04");
		this.hashFields.put("mnth_03", "mnth03");
		this.hashFields.put("mnth_06", "mnth06");
		this.hashFields.put("mnth_05", "mnth05");
		this.hashFields.put("mnth_08", "mnth08");
		this.hashFields.put("mnth_07", "mnth07");
		this.hashFields.put("mnth_09", "mnth09");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("mnth_02", "mnth02");
		this.hashFields.put("frst_qurt_tot", "frstQurtTot");
		this.hashFields.put("mnth_01", "mnth01");
		this.hashFields.put("rslt_tp", "rsltTp");
		this.hashFields.put("rslt_tp_seq", "rsltTpSeq");
		
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndNm
	 */
	public String getEqKndNm() {
		return this.eqKndNm;
	}
	
	/**
	 * Column Info
	 * @return verSeq
	 */
	public String getVerSeq() {
		return this.verSeq;
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
	 * @return eqTermNm
	 */
	public String getEqTermNm() {
		return this.eqTermNm;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndNm
	 */
	public void setEqKndNm(String eqKndNm) {
		this.eqKndNm = eqKndNm;
	}
	
	/**
	 * Column Info
	 * @param verSeq
	 */
	public void setVerSeq(String verSeq) {
		this.verSeq = verSeq;
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
	 * @param eqTermNm
	 */
	public void setEqTermNm(String eqTermNm) {
		this.eqTermNm = eqTermNm;
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
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {		
		setFrthQurtTot(JSPUtil.getParameter(request, "frth_qurt_tot", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setEqKndNm(JSPUtil.getParameter(request, "eq_knd_nm", ""));
		setScndQurtTot(JSPUtil.getParameter(request, "scnd_qurt_tot", ""));
		setYrTot(JSPUtil.getParameter(request, "yr_tot", ""));
		setMnth12(JSPUtil.getParameter(request, "mnth_12", ""));
		setMnth11(JSPUtil.getParameter(request, "mnth_11", ""));
		setMnth10(JSPUtil.getParameter(request, "mnth_10", ""));
		setEqTermNm(JSPUtil.getParameter(request, "eq_term_nm", ""));
		setThrdQurtTot(JSPUtil.getParameter(request, "thrd_qurt_tot", ""));
		setMnth04(JSPUtil.getParameter(request, "mnth_04", ""));
		setMnth03(JSPUtil.getParameter(request, "mnth_03", ""));
		setMnth06(JSPUtil.getParameter(request, "mnth_06", ""));
		setMnth05(JSPUtil.getParameter(request, "mnth_05", ""));
		setMnth08(JSPUtil.getParameter(request, "mnth_08", ""));
		setMnth07(JSPUtil.getParameter(request, "mnth_07", ""));
		setMnth09(JSPUtil.getParameter(request, "mnth_09", ""));
		setMnth02(JSPUtil.getParameter(request, "mnth_02", ""));
		setFrstQurtTot(JSPUtil.getParameter(request, "frst_qurt_tot", ""));
		setMnth01(JSPUtil.getParameter(request, "mnth_01", ""));
		setRsltTp(JSPUtil.getParameter(request, "rslt_tp", ""));
		setRsltTpSeq(JSPUtil.getParameter(request, "rslt_tp_seq", ""));
		setPlnYr(JSPUtil.getParameter(request, "pln_yr", ""));
		setVerSeq(JSPUtil.getParameter(request, "ver_seq", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return ExpensePlanPerformanceVO[]
	 */
	public ExpensePlanPerformanceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExpensePlanPerformanceVO[]
	 */
	public ExpensePlanPerformanceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExpensePlanPerformanceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frthQurtTot = (JSPUtil.getParameter(request, prefix	+ "frth_qurt_tot".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd".trim(), length));
			String[] eqKndNm = (JSPUtil.getParameter(request, prefix	+ "eq_knd_nm".trim(), length));
			String[] scndQurtTot = (JSPUtil.getParameter(request, prefix	+ "scnd_qurt_tot".trim(), length));
			String[] yrTot = (JSPUtil.getParameter(request, prefix	+ "yr_tot".trim(), length));
			String[] mnth12 = (JSPUtil.getParameter(request, prefix	+ "mnth_12".trim(), length));
			String[] mnth11 = (JSPUtil.getParameter(request, prefix	+ "mnth_11".trim(), length));
			String[] mnth10 = (JSPUtil.getParameter(request, prefix	+ "mnth_10".trim(), length));
			String[] eqTermNm = (JSPUtil.getParameter(request, prefix	+ "eq_term_nm".trim(), length));
			String[] thrdQurtTot = (JSPUtil.getParameter(request, prefix	+ "thrd_qurt_tot".trim(), length));
			String[] mnth04 = (JSPUtil.getParameter(request, prefix	+ "mnth_04".trim(), length));
			String[] mnth03 = (JSPUtil.getParameter(request, prefix	+ "mnth_03".trim(), length));
			String[] mnth06 = (JSPUtil.getParameter(request, prefix	+ "mnth_06".trim(), length));
			String[] mnth05 = (JSPUtil.getParameter(request, prefix	+ "mnth_05".trim(), length));
			String[] mnth08 = (JSPUtil.getParameter(request, prefix	+ "mnth_08".trim(), length));
			String[] mnth07 = (JSPUtil.getParameter(request, prefix	+ "mnth_07".trim(), length));
			String[] mnth09 = (JSPUtil.getParameter(request, prefix	+ "mnth_09".trim(), length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr".trim(), length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq".trim(), length));
			String[] mnth02 = (JSPUtil.getParameter(request, prefix	+ "mnth_02".trim(), length));
			String[] frstQurtTot = (JSPUtil.getParameter(request, prefix	+ "frst_qurt_tot".trim(), length));
			String[] mnth01 = (JSPUtil.getParameter(request, prefix	+ "mnth_01".trim(), length));
			String[] rsltTp = (JSPUtil.getParameter(request, prefix	+ "rslt_tp".trim(), length));
			String[] rsltTpSeq = (JSPUtil.getParameter(request, prefix	+ "rslt_tp_seq".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ExpensePlanPerformanceVO();
				if (frthQurtTot[i] != null)
					model.setFrthQurtTot(frthQurtTot[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eqKndNm[i] != null)
					model.setEqKndNm(eqKndNm[i]);
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
				if (eqTermNm[i] != null)
					model.setEqTermNm(eqTermNm[i]);
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
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (verSeq[i] != null)
					model.setVerSeq(verSeq[i]);
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
				models.add(model);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return getExpensePlanPerformanceVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return ExpensePlanPerformanceVO[]
	 */
	public ExpensePlanPerformanceVO[] getExpensePlanPerformanceVOs(){
		ExpensePlanPerformanceVO[] vos = (ExpensePlanPerformanceVO[])models.toArray(new ExpensePlanPerformanceVO[models.size()]);
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
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndNm = this.eqKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scndQurtTot = this.scndQurtTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrTot = this.yrTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth12 = this.mnth12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth11 = this.mnth11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth10 = this.mnth10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTermNm = this.eqTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thrdQurtTot = this.thrdQurtTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth04 = this.mnth04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth03 = this.mnth03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth06 = this.mnth06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth05 = this.mnth05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth08 = this.mnth08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth07 = this.mnth07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnth09 = this.mnth09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
	
	public String getPlnYr() {
		return plnYr;
	}
}
