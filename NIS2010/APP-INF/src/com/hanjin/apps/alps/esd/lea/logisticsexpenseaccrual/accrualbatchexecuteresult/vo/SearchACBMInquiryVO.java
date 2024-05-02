/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchACBMInquiryVO.java
*@FileTitle : SearchACBMInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchACBMInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchACBMInquiryVO> models = new ArrayList<SearchACBMInquiryVO>();
	
	/* Column Info */
	private String coaCostSrcCd = null;
	/* Column Info */
	private String diffBudRto = null;
	/* Column Info */
	private String prdSum = null;
	/* Column Info */
	private String costDesc = null;
	/* Column Info */
	private String fRhqCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ttlBudRto = null;
	/* Column Info */
	private String diffBud = null;
	/* Column Info */
	private String ttlBud = null;
	/* Column Info */
	private String fCostTypeM = null;
	/* Column Info */
	private String glMonTo = null;
	/* Column Info */
	private String glMonFrom = null;
	/* Column Info */
	private String bindSubOfcCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String fCostTypeF = null;
	/* Column Info */
	private String mnCostTpNm = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String fSubOfcCd = null;
	/* Column Info */
	private String subCostTpNm = null;
	/* Column Info */
	private String fOfcCd = null;
	/* Column Info */
	private String monBud = null;
	/* Column Info */
	private String prntOfcCd = null;
	/* Column Info */
	private String fReport = null;
	/* Column Info */
	private String bindOfcCd = null;
	/* Column Info */
	private String costSrcSysCd = null;
	/* Column Info */
	private String lstyrFrom = null;
	/* Column Info */
	private String lstyrTo = null;
	/* Column Info */
	private String lstyrSum = null;
	/* Column Info */
	private String diffLstyr = null;
	/* Column Info */
	private String mon1 = null;
	/* Column Info */
	private String mon2 = null;
	/* Column Info */
	private String mon3 = null;
		/* Column Info */
	private String mon4 = null;
	/* Column Info */
	private String mon5 = null;
	/* Column Info */
	private String mon6 = null;
	/* Column Info */
	private String mon7 = null;
	/* Column Info */
	private String mon8 = null;
	/* Column Info */
	private String mon9 = null;
	/* Column Info */
	private String mon10 = null;
	/* Column Info */
	private String mon11 = null;
	/* Column Info */
	private String mon12 = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchACBMInquiryVO() {}

	public SearchACBMInquiryVO(String ibflag, String pagerows, String glMonFrom, String glMonTo, String prntOfcCd, String rhqCd, String ctrlOfcCd, String mnCostTpNm, String subCostTpNm, String coaCostSrcCd, String costDesc, String monBud, String prdSum, String diffBud, String diffBudRto, String ttlBud, String ttlBudRto, String fCostTypeF, String fCostTypeM, String fOfcCd, String bindOfcCd, String bindSubOfcCd, String fSubOfcCd, String fRhqCd, String fReport,String costSrcSysCd, String lstyrFrom, String lstyrTo, String lstyrSum, String diffLstyr, String mon1, String mon2, String mon3, String mon4,String mon5,String mon6,String mon7, String mon8, String mon9, String mon10, String mon11, String mon12) {
		this.coaCostSrcCd = coaCostSrcCd;
		this.diffBudRto = diffBudRto;
		this.prdSum = prdSum;
		this.costDesc = costDesc;
		this.fRhqCd = fRhqCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ttlBudRto = ttlBudRto;
		this.diffBud = diffBud;
		this.ttlBud = ttlBud;
		this.fCostTypeM = fCostTypeM;
		this.glMonTo = glMonTo;
		this.glMonFrom = glMonFrom;
		this.bindSubOfcCd = bindSubOfcCd;
		this.rhqCd = rhqCd;
		this.fCostTypeF = fCostTypeF;
		this.mnCostTpNm = mnCostTpNm;
		this.ctrlOfcCd = ctrlOfcCd;
		this.fSubOfcCd = fSubOfcCd;
		this.subCostTpNm = subCostTpNm;
		this.fOfcCd = fOfcCd;
		this.monBud = monBud;
		this.prntOfcCd = prntOfcCd;
		this.fReport = fReport;
		this.bindOfcCd = bindOfcCd;
		this.costSrcSysCd = costSrcSysCd;
		this.lstyrFrom = lstyrFrom;
		this.lstyrTo = lstyrTo;
		this.lstyrSum = lstyrSum;
		this.diffLstyr = diffLstyr;
		this.mon1 = mon1;
		this.mon2 = mon2;
		this.mon3 = mon3;
		this.mon4 = mon4;
		this.mon5 = mon5;
		this.mon6 = mon6;
		this.mon7 = mon7;
		this.mon8 = mon8;
		this.mon9 = mon9;
		this.mon10 = mon10;
		this.mon11 = mon11;
		this.mon12 = mon12;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("coa_cost_src_cd", getCoaCostSrcCd());
		this.hashColumns.put("diff_bud_rto", getDiffBudRto());
		this.hashColumns.put("prd_sum", getPrdSum());
		this.hashColumns.put("cost_desc", getCostDesc());
		this.hashColumns.put("f_rhq_cd", getFRhqCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ttl_bud_rto", getTtlBudRto());
		this.hashColumns.put("diff_bud", getDiffBud());
		this.hashColumns.put("ttl_bud", getTtlBud());
		this.hashColumns.put("f_cost_type_m", getFCostTypeM());
		this.hashColumns.put("gl_mon_to", getGlMonTo());
		this.hashColumns.put("gl_mon_from", getGlMonFrom());
		this.hashColumns.put("bind_sub_ofc_cd", getBindSubOfcCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("f_cost_type_f", getFCostTypeF());
		this.hashColumns.put("mn_cost_tp_nm", getMnCostTpNm());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("f_sub_ofc_cd", getFSubOfcCd());
		this.hashColumns.put("sub_cost_tp_nm", getSubCostTpNm());
		this.hashColumns.put("f_ofc_cd", getFOfcCd());
		this.hashColumns.put("mon_bud", getMonBud());
		this.hashColumns.put("prnt_ofc_cd", getPrntOfcCd());
		this.hashColumns.put("f_report", getFReport());
		this.hashColumns.put("bind_ofc_cd", getBindOfcCd());
		this.hashColumns.put("cost_src_sys_cd", getCostSrcSysCd());
		this.hashColumns.put("lstyr_from", getLstyrFrom());
		this.hashColumns.put("lstyr_to", getLstyrTo());
		this.hashColumns.put("lstyr_sum", getLstyrSum());
		this.hashColumns.put("diff_lstyr", getDiffLstyr());
		this.hashColumns.put("mon1", getMon1());
		this.hashColumns.put("mon2", getMon2());
		this.hashColumns.put("mon3", getMon3());
		this.hashColumns.put("mon4", getMon4());
		this.hashColumns.put("mon5", getMon5());
		this.hashColumns.put("mon6", getMon6());
		this.hashColumns.put("mon7", getMon7());
		this.hashColumns.put("mon8", getMon8());
		this.hashColumns.put("mon9", getMon9());
  	    this.hashColumns.put("mon10", getMon10());
		this.hashColumns.put("mon11", getMon11());
		this.hashColumns.put("mon12", getMon12());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("coa_cost_src_cd", "coaCostSrcCd");
		this.hashFields.put("diff_bud_rto", "diffBudRto");
		this.hashFields.put("prd_sum", "prdSum");
		this.hashFields.put("cost_desc", "costDesc");
		this.hashFields.put("f_rhq_cd", "fRhqCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ttl_bud_rto", "ttlBudRto");
		this.hashFields.put("diff_bud", "diffBud");
		this.hashFields.put("ttl_bud", "ttlBud");
		this.hashFields.put("f_cost_type_m", "fCostTypeM");
		this.hashFields.put("gl_mon_to", "glMonTo");
		this.hashFields.put("gl_mon_from", "glMonFrom");
		this.hashFields.put("bind_sub_ofc_cd", "bindSubOfcCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("f_cost_type_f", "fCostTypeF");
		this.hashFields.put("mn_cost_tp_nm", "mnCostTpNm");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("f_sub_ofc_cd", "fSubOfcCd");
		this.hashFields.put("sub_cost_tp_nm", "subCostTpNm");
		this.hashFields.put("f_ofc_cd", "fOfcCd");
		this.hashFields.put("mon_bud", "monBud");
		this.hashFields.put("prnt_ofc_cd", "prntOfcCd");
		this.hashFields.put("f_report", "fReport");
		this.hashFields.put("bind_ofc_cd", "bindOfcCd");
		this.hashFields.put("cost_src_sys_cd", "costSrcSysCd");
		this.hashFields.put("lstyr_from", "lstyrFrom");
		this.hashFields.put("lstyr_to", "lstyrTo");
		this.hashFields.put("lstyr_sum", "lstyrSum");
		this.hashFields.put("diff_lstyr", "diffLstyr");
		this.hashFields.put("mon1", "mon1");
		this.hashFields.put("mon2", "mon2");
		this.hashFields.put("mon3", "mon3");
		this.hashFields.put("mon4", "mon4");
		this.hashFields.put("mon5", "mon5");
		this.hashFields.put("mon6", "mon6");
		this.hashFields.put("mon7", "mon7");
		this.hashFields.put("mon8", "mon8");
		this.hashFields.put("mon9", "mon9");
		this.hashFields.put("mon10", "mon10");
		this.hashFields.put("mon11", "mon11");
		this.hashFields.put("mon12", "mon12");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return coaCostSrcCd
	 */
	public String getCoaCostSrcCd() {
		return this.coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return diffBudRto
	 */
	public String getDiffBudRto() {
		return this.diffBudRto;
	}
	
	/**
	 * Column Info
	 * @return prdSum
	 */
	public String getPrdSum() {
		return this.prdSum;
	}
	
	/**
	 * Column Info
	 * @return costDesc
	 */
	public String getCostDesc() {
		return this.costDesc;
	}
	
	/**
	 * Column Info
	 * @return fRhqCd
	 */
	public String getFRhqCd() {
		return this.fRhqCd;
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
	 * @return ttlBudRto
	 */
	public String getTtlBudRto() {
		return this.ttlBudRto;
	}
	
	/**
	 * Column Info
	 * @return diffBud
	 */
	public String getDiffBud() {
		return this.diffBud;
	}
	
	/**
	 * Column Info
	 * @return ttlBud
	 */
	public String getTtlBud() {
		return this.ttlBud;
	}
	
	/**
	 * Column Info
	 * @return fCostTypeM
	 */
	public String getFCostTypeM() {
		return this.fCostTypeM;
	}
	
	/**
	 * Column Info
	 * @return glMonTo
	 */
	public String getGlMonTo() {
		return this.glMonTo;
	}
	
	/**
	 * Column Info
	 * @return glMonFrom
	 */
	public String getGlMonFrom() {
		return this.glMonFrom;
	}
	
	/**
	 * Column Info
	 * @return bindSubOfcCd
	 */
	public String getBindSubOfcCd() {
		return this.bindSubOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return fCostTypeF
	 */
	public String getFCostTypeF() {
		return this.fCostTypeF;
	}
	
	/**
	 * Column Info
	 * @return mnCostTpNm
	 */
	public String getMnCostTpNm() {
		return this.mnCostTpNm;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fSubOfcCd
	 */
	public String getFSubOfcCd() {
		return this.fSubOfcCd;
	}
	
	/**
	 * Column Info
	 * @return subCostTpNm
	 */
	public String getSubCostTpNm() {
		return this.subCostTpNm;
	}
	
	/**
	 * Column Info
	 * @return fOfcCd
	 */
	public String getFOfcCd() {
		return this.fOfcCd;
	}

	/**
	 * Column Info
	 * @return monBud
	 */
	public String getMonBud() {
		return this.monBud;
	}
	
	/**
	 * Column Info
	 * @return prntOfcCd
	 */
	public String getPrntOfcCd() {
		return this.prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fReport
	 */
	public String getFReport() {
		return this.fReport;
	}
	
	/**
	 * Column Info
	 * @return bindOfcCd
	 */
	public String getBindOfcCd() {
		return this.bindOfcCd;
	}
	
	/**
	 * Column Info
	 * @return costSrcSysCd
	 */
	public String getCostSrcSysCd() {
		return this.costSrcSysCd;
	}
	
	/**
	 * Column Info
	 * @return lstyrFrom
	 */
	public String getLstyrFrom() {
		return this.lstyrFrom;
	}
	
	/**
	 * Column Info
	 * @return lstyrTo
	 */
	public String getLstyrTo() {
		return this.lstyrTo;
	}
	
	/**
	 * Column Info
	 * @return lstyrSum
	 */
	public String getLstyrSum() {
		return this.lstyrSum;
	}
	
	/**
	 * Column Info
	 * @return diffLstyr
	 */
	public String getDiffLstyr() {
		return this.diffLstyr;
	}

	/**
	 * Column Info
	 * @param coaCostSrcCd
	 */
	public void setCoaCostSrcCd(String coaCostSrcCd) {
		this.coaCostSrcCd = coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param diffBudRto
	 */
	public void setDiffBudRto(String diffBudRto) {
		this.diffBudRto = diffBudRto;
	}
	
	/**
	 * Column Info
	 * @param prdSum
	 */
	public void setPrdSum(String prdSum) {
		this.prdSum = prdSum;
	}
	
	/**
	 * Column Info
	 * @param costDesc
	 */
	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
	}
	
	/**
	 * Column Info
	 * @param fRhqCd
	 */
	public void setFRhqCd(String fRhqCd) {
		this.fRhqCd = fRhqCd;
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
	 * @param ttlBudRto
	 */
	public void setTtlBudRto(String ttlBudRto) {
		this.ttlBudRto = ttlBudRto;
	}
	
	/**
	 * Column Info
	 * @param diffBud
	 */
	public void setDiffBud(String diffBud) {
		this.diffBud = diffBud;
	}
	
	/**
	 * Column Info
	 * @param ttlBud
	 */
	public void setTtlBud(String ttlBud) {
		this.ttlBud = ttlBud;
	}
	
	/**
	 * Column Info
	 * @param fCostTypeM
	 */
	public void setFCostTypeM(String fCostTypeM) {
		this.fCostTypeM = fCostTypeM;
	}
	
	/**
	 * Column Info
	 * @param glMonTo
	 */
	public void setGlMonTo(String glMonTo) {
		this.glMonTo = glMonTo;
	}
	
	/**
	 * Column Info
	 * @param glMonFrom
	 */
	public void setGlMonFrom(String glMonFrom) {
		this.glMonFrom = glMonFrom;
	}
	
	/**
	 * Column Info
	 * @param bindSubOfcCd
	 */
	public void setBindSubOfcCd(String bindSubOfcCd) {
		this.bindSubOfcCd = bindSubOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param fCostTypeF
	 */
	public void setFCostTypeF(String fCostTypeF) {
		this.fCostTypeF = fCostTypeF;
	}
	
	/**
	 * Column Info
	 * @param mnCostTpNm
	 */
	public void setMnCostTpNm(String mnCostTpNm) {
		this.mnCostTpNm = mnCostTpNm;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fSubOfcCd
	 */
	public void setFSubOfcCd(String fSubOfcCd) {
		this.fSubOfcCd = fSubOfcCd;
	}
	
	/**
	 * Column Info
	 * @param subCostTpNm
	 */
	public void setSubCostTpNm(String subCostTpNm) {
		this.subCostTpNm = subCostTpNm;
	}
	
	/**
	 * Column Info
	 * @param fOfcCd
	 */
	public void setFOfcCd(String fOfcCd) {
		this.fOfcCd = fOfcCd;
	}
	
	/**
	 * Column Info
	 * @param monBud
	 */
	public void setMonBud(String monBud) {
		this.monBud = monBud;
	}
	
	/**
	 * Column Info
	 * @param prntOfcCd
	 */
	public void setPrntOfcCd(String prntOfcCd) {
		this.prntOfcCd = prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fReport
	 */
	public void setFReport(String fReport) {
		this.fReport = fReport;
	}
	
	/**
	 * Column Info
	 * @param bindOfcCd
	 */
	public void setBindOfcCd(String bindOfcCd) {
		this.bindOfcCd = bindOfcCd;
	}
	
	/**
	 * Column Info
	 * @param costSrcSysCd
	 */
	public void setCostSrcSysCd(String costSrcSysCd) {
		this.costSrcSysCd = costSrcSysCd;
	}
	
	/**
	 * Column Info
	 * @param lstyrFrom
	 */
	public void setLstyrFrom(String lstyrFrom) {
		this.lstyrFrom = lstyrFrom;
	}
	
	/**
	 * Column Info
	 * @param lstyrTo
	 */
	public void setLstyrTo(String lstyrTo) {
		this.lstyrTo = lstyrTo;
	}
	
	/**
	 * Column Info
	 * @param lstyrSum
	 */
	public void setLstyrSum(String lstyrSum) {
		this.lstyrSum = lstyrSum;
	}
	
	/**
	 * Column Info
	 * @param diffLstyr
	 */
	public void setDiffLstyr(String diffLstyr) {
		this.diffLstyr = diffLstyr;
	}

/**
	 * @return the mon1
	 */
	public String getMon1() {
		return this.mon1;
	}

	/**
	 * @param mon1 the mon1 to set
	 */
	public void setMon1(String mon1) {
		this.mon1 = mon1;
	}

	/**
	 * @return the mon2
	 */
	public String getMon2() {
		return this.mon2;
	}

	/**
	 * @param mon2 the mon2 to set
	 */
	public void setMon2(String mon2) {
		this.mon2 = mon2;
	}

	/**
	 * @return the mon3
	 */
	public String getMon3() {
		return this.mon3;
	}

	/**
	 * @param mon3 the mon3 to set
	 */
	public void setMon3(String mon3) {
		this.mon3 = mon3;
	}

	/**
	 * @return the mon4
	 */
	public String getMon4() {
		return this.mon4;
	}

	/**
	 * @param mon4 the mon4 to set
	 */
	public void setMon4(String mon4) {
		this.mon4 = mon4;
	}

	/**
	 * @return the mon5
	 */
	public String getMon5() {
		return this.mon5;
	}

	/**
	 * @param mon5 the mon5 to set
	 */
	public void setMon5(String mon5) {
		this.mon5 = mon5;
	}

	/**
	 * @return the mon6
	 */
	public String getMon6() {
		return this.mon6;
	}

	/**
	 * @param mon6 the mon6 to set
	 */
	public void setMon6(String mon6) {
		this.mon6 = mon6;
	}

	/**
	 * @return the mon7
	 */
	public String getMon7() {
		return this.mon7;
	}

	/**
	 * @param mon7 the mon7 to set
	 */
	public void setMon7(String mon7) {
		this.mon7 = mon7;
	}

	/**
	 * @return the mon8
	 */
	public String getMon8() {
		return this.mon8;
	}

	/**
	 * @param mon8 the mon8 to set
	 */
	public void setMon8(String mon8) {
		this.mon8 = mon8;
	}

	/**
	 * @return the mon9
	 */
	public String getMon9() {
		return this.mon9;
	}

	/**
	 * @param mon9 the mon9 to set
	 */
	public void setMon9(String mon9) {
		this.mon9 = mon9;
	}
	

/**
	 * @return the mon10
	 */
	public String getMon10() {
		return this.mon10;
	}

	/**
	 * @param mon10 the mon10 to set
	 */
	public void setMon10(String mon10) {
		this.mon10 = mon10;
	}

	/**
	 * @return the mon11
	 */
	public String getMon11() {
		return this.mon11;
	}

	/**
	 * @param mon11 the mon11 to set
	 */
	public void setMon11(String mon11) {
		this.mon11 = mon11;
	}

	/**
	 * @return the mon12
	 */
	public String getMon12() {
		return this.mon12;
	}

	/**
	 * @param mon12 the mon12 to set
	 */
	public void setMon12(String mon12) {
		this.mon12 = mon12;
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
		setCoaCostSrcCd(JSPUtil.getParameter(request, prefix + "coa_cost_src_cd", ""));
		setDiffBudRto(JSPUtil.getParameter(request, prefix + "diff_bud_rto", ""));
		setPrdSum(JSPUtil.getParameter(request, prefix + "prd_sum", ""));
		setCostDesc(JSPUtil.getParameter(request, prefix + "cost_desc", ""));
		setFRhqCd(JSPUtil.getParameter(request, prefix + "f_rhq_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTtlBudRto(JSPUtil.getParameter(request, prefix + "ttl_bud_rto", ""));
		setDiffBud(JSPUtil.getParameter(request, prefix + "diff_bud", ""));
		setTtlBud(JSPUtil.getParameter(request, prefix + "ttl_bud", ""));
		setFCostTypeM(JSPUtil.getParameter(request, prefix + "f_cost_type_m", ""));
		setGlMonTo(JSPUtil.getParameter(request, prefix + "gl_mon_to", ""));
		setGlMonFrom(JSPUtil.getParameter(request, prefix + "gl_mon_from", ""));
		setBindSubOfcCd(JSPUtil.getParameter(request, prefix + "bind_sub_ofc_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setFCostTypeF(JSPUtil.getParameter(request, prefix + "f_cost_type_f", ""));
		setMnCostTpNm(JSPUtil.getParameter(request, prefix + "mn_cost_tp_nm", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setFSubOfcCd(JSPUtil.getParameter(request, prefix + "f_sub_ofc_cd", ""));
		setSubCostTpNm(JSPUtil.getParameter(request, prefix + "sub_cost_tp_nm", ""));
		setFOfcCd(JSPUtil.getParameter(request, prefix + "f_ofc_cd", ""));
		setMonBud(JSPUtil.getParameter(request, prefix + "mon_bud", ""));
		setPrntOfcCd(JSPUtil.getParameter(request, prefix + "prnt_ofc_cd", ""));
		setFReport(JSPUtil.getParameter(request, prefix + "f_report", ""));
		setBindOfcCd(JSPUtil.getParameter(request, prefix + "bind_ofc_cd", ""));
		setCostSrcSysCd(JSPUtil.getParameter(request, prefix + "cost_src_sys_cd", ""));
		setLstyrFrom(JSPUtil.getParameter(request, prefix + "lstyr_from", ""));
		setLstyrTo(JSPUtil.getParameter(request, prefix + "lstyr_to", ""));
		setLstyrSum(JSPUtil.getParameter(request, prefix + "lstyr_sum", ""));
		setDiffLstyr(JSPUtil.getParameter(request, prefix + "diff_lstyr", ""));
		setMon1(JSPUtil.getParameter(request, prefix + "mon1", ""));
		setMon2(JSPUtil.getParameter(request, prefix + "mon2", ""));
		setMon3(JSPUtil.getParameter(request, prefix + "mon3", ""));
		setMon4(JSPUtil.getParameter(request, prefix + "mon4", ""));
		setMon5(JSPUtil.getParameter(request, prefix + "mon5", ""));
		setMon6(JSPUtil.getParameter(request, prefix + "mon6", ""));
		setMon7(JSPUtil.getParameter(request, prefix + "mon7", ""));
		setMon8(JSPUtil.getParameter(request, prefix + "mon8", ""));
		setMon9(JSPUtil.getParameter(request, prefix + "mon9", ""));
		setMon10(JSPUtil.getParameter(request, prefix + "mon10", ""));
		setMon11(JSPUtil.getParameter(request, prefix + "mon11", ""));
		setMon12(JSPUtil.getParameter(request, prefix + "mon12", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchACBMInquiryVO[]
	 */
	public SearchACBMInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchACBMInquiryVO[]
	 */
	public SearchACBMInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchACBMInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] coaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd", length));
			String[] diffBudRto = (JSPUtil.getParameter(request, prefix	+ "diff_bud_rto", length));
			String[] prdSum = (JSPUtil.getParameter(request, prefix	+ "prd_sum", length));
			String[] costDesc = (JSPUtil.getParameter(request, prefix	+ "cost_desc", length));
			String[] fRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_rhq_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ttlBudRto = (JSPUtil.getParameter(request, prefix	+ "ttl_bud_rto", length));
			String[] diffBud = (JSPUtil.getParameter(request, prefix	+ "diff_bud", length));
			String[] ttlBud = (JSPUtil.getParameter(request, prefix	+ "ttl_bud", length));
			String[] fCostTypeM = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_m", length));
			String[] glMonTo = (JSPUtil.getParameter(request, prefix	+ "gl_mon_to", length));
			String[] glMonFrom = (JSPUtil.getParameter(request, prefix	+ "gl_mon_from", length));
			String[] bindSubOfcCd = (JSPUtil.getParameter(request, prefix	+ "bind_sub_ofc_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] fCostTypeF = (JSPUtil.getParameter(request, prefix	+ "f_cost_type_f", length));
			String[] mnCostTpNm = (JSPUtil.getParameter(request, prefix	+ "mn_cost_tp_nm", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] fSubOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_sub_ofc_cd", length));
			String[] subCostTpNm = (JSPUtil.getParameter(request, prefix	+ "sub_cost_tp_nm", length));
			String[] fOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ofc_cd", length));
			String[] monBud = (JSPUtil.getParameter(request, prefix	+ "mon_bud", length));
			String[] prntOfcCd = (JSPUtil.getParameter(request, prefix	+ "prnt_ofc_cd", length));
			String[] fReport = (JSPUtil.getParameter(request, prefix	+ "f_report", length));
			String[] bindOfcCd = (JSPUtil.getParameter(request, prefix	+ "bind_ofc_cd", length));
			String[] costSrcSysCd = (JSPUtil.getParameter(request, prefix	+ "cost_src_sys_cd", length));
			String[] lstyrFrom = (JSPUtil.getParameter(request, prefix	+ "lstyr_from", length));
			String[] lstyrTo = (JSPUtil.getParameter(request, prefix	+ "lstyr_to", length));
			String[] lstyrSum = (JSPUtil.getParameter(request, prefix	+ "lstyr_sum", length));
			String[] diffLstyr = (JSPUtil.getParameter(request, prefix	+ "diff_lstyr", length));
			String[] mon1 = (JSPUtil.getParameter(request, prefix	+ "mon1", length));
			String[] mon2 = (JSPUtil.getParameter(request, prefix	+ "mon2", length));
			String[] mon3 = (JSPUtil.getParameter(request, prefix	+ "mon3", length));
			String[] mon4 = (JSPUtil.getParameter(request, prefix	+ "mon4", length));
			String[] mon5 = (JSPUtil.getParameter(request, prefix	+ "mon5", length));
			String[] mon6 = (JSPUtil.getParameter(request, prefix	+ "mon6", length));
			String[] mon7 = (JSPUtil.getParameter(request, prefix	+ "mon7", length));
			String[] mon8 = (JSPUtil.getParameter(request, prefix	+ "mon8", length));
			String[] mon9 = (JSPUtil.getParameter(request, prefix	+ "mon9", length));
			String[] mon10 = (JSPUtil.getParameter(request, prefix	+ "mon10", length));
			String[] mon11 = (JSPUtil.getParameter(request, prefix	+ "mon11", length));
			String[] mon12 = (JSPUtil.getParameter(request, prefix	+ "mon12", length));

			
			for (int i = 0; i < length; i++) {
				model = new SearchACBMInquiryVO();
				if (coaCostSrcCd[i] != null)
					model.setCoaCostSrcCd(coaCostSrcCd[i]);
				if (diffBudRto[i] != null)
					model.setDiffBudRto(diffBudRto[i]);
				if (prdSum[i] != null)
					model.setPrdSum(prdSum[i]);
				if (costDesc[i] != null)
					model.setCostDesc(costDesc[i]);
				if (fRhqCd[i] != null)
					model.setFRhqCd(fRhqCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ttlBudRto[i] != null)
					model.setTtlBudRto(ttlBudRto[i]);
				if (diffBud[i] != null)
					model.setDiffBud(diffBud[i]);
				if (ttlBud[i] != null)
					model.setTtlBud(ttlBud[i]);
				if (fCostTypeM[i] != null)
					model.setFCostTypeM(fCostTypeM[i]);
				if (glMonTo[i] != null)
					model.setGlMonTo(glMonTo[i]);
				if (glMonFrom[i] != null)
					model.setGlMonFrom(glMonFrom[i]);
				if (bindSubOfcCd[i] != null)
					model.setBindSubOfcCd(bindSubOfcCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (fCostTypeF[i] != null)
					model.setFCostTypeF(fCostTypeF[i]);
				if (mnCostTpNm[i] != null)
					model.setMnCostTpNm(mnCostTpNm[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (fSubOfcCd[i] != null)
					model.setFSubOfcCd(fSubOfcCd[i]);
				if (subCostTpNm[i] != null)
					model.setSubCostTpNm(subCostTpNm[i]);
				if (fOfcCd[i] != null)
					model.setFOfcCd(fOfcCd[i]);
				if (monBud[i] != null)
					model.setMonBud(monBud[i]);
				if (prntOfcCd[i] != null)
					model.setPrntOfcCd(prntOfcCd[i]);
				if (fReport[i] != null)
					model.setFReport(fReport[i]);
				if (bindOfcCd[i] != null)
					model.setBindOfcCd(bindOfcCd[i]);
				if (costSrcSysCd[i] != null)
					model.setCostSrcSysCd(costSrcSysCd[i]);
				if (lstyrFrom[i] != null)
					model.setLstyrFrom(lstyrFrom[i]);
				if (lstyrTo[i] != null)
					model.setLstyrTo(lstyrTo[i]);
				if (lstyrSum[i] != null)
					model.setLstyrSum(lstyrSum[i]);
				if (diffLstyr[i] != null)
					model.setDiffLstyr(diffLstyr[i]);
				if (mon1[i] != null)
					model.setMon1(mon1[i]);
				if (mon2[i] != null)
					model.setMon2(mon2[i]);
				if (mon3[i] != null)
					model.setMon3(mon3[i]);
				if (mon4[i] != null)
					model.setMon4(mon4[i]);
				if (mon5[i] != null)
					model.setMon5(mon5[i]);
				if (mon6[i] != null)
					model.setMon6(mon6[i]);
				if (mon7[i] != null)
					model.setMon7(mon7[i]);
				if (mon8[i] != null)
					model.setMon8(mon8[i]);
				if (mon9[i] != null)
					model.setMon9(mon9[i]);
				if (mon10[i] != null)
					model.setMon10(mon10[i]);
				if (mon11[i] != null)
					model.setMon11(mon11[i]);
				if (mon12[i] != null)
					model.setMon12(mon12[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchACBMInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchACBMInquiryVO[]
	 */
	public SearchACBMInquiryVO[] getSearchACBMInquiryVOs(){
		SearchACBMInquiryVO[] vos = (SearchACBMInquiryVO[])models.toArray(new SearchACBMInquiryVO[models.size()]);
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
		this.coaCostSrcCd = this.coaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffBudRto = this.diffBudRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prdSum = this.prdSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDesc = this.costDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRhqCd = this.fRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBudRto = this.ttlBudRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffBud = this.diffBud .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBud = this.ttlBud .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeM = this.fCostTypeM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glMonTo = this.glMonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glMonFrom = this.glMonFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bindSubOfcCd = this.bindSubOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostTypeF = this.fCostTypeF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnCostTpNm = this.mnCostTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSubOfcCd = this.fSubOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subCostTpNm = this.subCostTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcCd = this.fOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monBud = this.monBud .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntOfcCd = this.prntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fReport = this.fReport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bindOfcCd = this.bindOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSrcSysCd = this.costSrcSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstyrFrom = this.lstyrFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstyrTo = this.lstyrTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstyrSum = this.lstyrSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffLstyr = this.diffLstyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon1 = this.mon1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon2 = this.mon2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon3 = this.mon3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon4 = this.mon4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon5 = this.mon5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon6 = this.mon6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon7 = this.mon7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon8 = this.mon8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon9 = this.mon9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon10 = this.mon10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon11 = this.mon11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon12 = this.mon12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
