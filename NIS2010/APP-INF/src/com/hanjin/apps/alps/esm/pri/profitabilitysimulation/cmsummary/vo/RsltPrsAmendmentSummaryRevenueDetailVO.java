/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPrsAmendmentSummaryRevenueDetailVO.java
*@FileTitle : RsltPrsAmendmentSummaryRevenueDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.10.15 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPrsAmendmentSummaryRevenueDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPrsAmendmentSummaryRevenueDetailVO> models = new ArrayList<RsltPrsAmendmentSummaryRevenueDetailVO>();
	
	/* Column Info */
	private String a1Load = null;
	/* Column Info */
	private String sumLoad = null;
	/* Column Info */
	private String sumGRev = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String sumPscSurcharge = null;
	/* Column Info */
	private String e1Load = null;
	/* Column Info */
	private String sumOthersSurcharge = null;
	/* Column Info */
	private String a1PscSurcharge = null;
	/* Column Info */
	private String a1IfcSurcharge = null;
	/* Column Info */
	private String e1OftSurcharge = null;
	/* Column Info */
	private String a1WeekCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String a1OftSurcharge = null;
	/* Column Info */
	private String aScNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String e1BucSurcharge = null;
	/* Column Info */
	private String a1BucSurcharge = null;
	/* Column Info */
	private String a1OthersSurcharge = null;
	/* Column Info */
	private String a1GRev = null;
	/* Column Info */
	private String sumOftSurcharge = null;
	/* Column Info */
	private String e2ScNo = null;
	/* Column Info */
	private String e1ScNo = null;
	/* Column Info */
	private String e1GRev = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String mqcQty = null;
	/* Column Info */
	private String e1OthersSurcharge = null;
	/* Column Info */
	private String e1IfcSurcharge = null;
	/* Column Info */
	private String sumIfcSurcharge = null;
	/* Column Info */
	private String sumBucSurcharge = null;
	/* Column Info */
	private String e1PscSurcharge = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPrsAmendmentSummaryRevenueDetailVO() {}

	public RsltPrsAmendmentSummaryRevenueDetailVO(String ibflag, String pagerows, String aScNo, String e1ScNo, String e2ScNo, String a1Load, String a1GRev, String a1OftSurcharge, String a1BucSurcharge, String a1IfcSurcharge, String a1PscSurcharge, String a1OthersSurcharge, String a1WeekCnt, String e1Load, String e1GRev, String e1OftSurcharge, String e1BucSurcharge, String e1IfcSurcharge, String e1PscSurcharge, String e1OthersSurcharge, String sumLoad, String sumGRev, String sumOftSurcharge, String sumBucSurcharge, String sumIfcSurcharge, String sumPscSurcharge, String sumOthersSurcharge, String custNm, String propOfcCd, String mqcQty) {
		this.a1Load = a1Load;
		this.sumLoad = sumLoad;
		this.sumGRev = sumGRev;
		this.custNm = custNm;
		this.sumPscSurcharge = sumPscSurcharge;
		this.e1Load = e1Load;
		this.sumOthersSurcharge = sumOthersSurcharge;
		this.a1PscSurcharge = a1PscSurcharge;
		this.a1IfcSurcharge = a1IfcSurcharge;
		this.e1OftSurcharge = e1OftSurcharge;
		this.a1WeekCnt = a1WeekCnt;
		this.pagerows = pagerows;
		this.a1OftSurcharge = a1OftSurcharge;
		this.aScNo = aScNo;
		this.ibflag = ibflag;
		this.e1BucSurcharge = e1BucSurcharge;
		this.a1BucSurcharge = a1BucSurcharge;
		this.a1OthersSurcharge = a1OthersSurcharge;
		this.a1GRev = a1GRev;
		this.sumOftSurcharge = sumOftSurcharge;
		this.e2ScNo = e2ScNo;
		this.e1ScNo = e1ScNo;
		this.e1GRev = e1GRev;
		this.propOfcCd = propOfcCd;
		this.mqcQty = mqcQty;
		this.e1OthersSurcharge = e1OthersSurcharge;
		this.e1IfcSurcharge = e1IfcSurcharge;
		this.sumIfcSurcharge = sumIfcSurcharge;
		this.sumBucSurcharge = sumBucSurcharge;
		this.e1PscSurcharge = e1PscSurcharge;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("a1_load", getA1Load());
		this.hashColumns.put("sum_load", getSumLoad());
		this.hashColumns.put("sum_g_rev", getSumGRev());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("sum_psc_surcharge", getSumPscSurcharge());
		this.hashColumns.put("e1_load", getE1Load());
		this.hashColumns.put("sum_others_surcharge", getSumOthersSurcharge());
		this.hashColumns.put("a1_psc_surcharge", getA1PscSurcharge());
		this.hashColumns.put("a1_ifc_surcharge", getA1IfcSurcharge());
		this.hashColumns.put("e1_oft_surcharge", getE1OftSurcharge());
		this.hashColumns.put("a1_week_cnt", getA1WeekCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("a1_oft_surcharge", getA1OftSurcharge());
		this.hashColumns.put("a_sc_no", getAScNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("e1_buc_surcharge", getE1BucSurcharge());
		this.hashColumns.put("a1_buc_surcharge", getA1BucSurcharge());
		this.hashColumns.put("a1_others_surcharge", getA1OthersSurcharge());
		this.hashColumns.put("a1_g_rev", getA1GRev());
		this.hashColumns.put("sum_oft_surcharge", getSumOftSurcharge());
		this.hashColumns.put("e2_sc_no", getE2ScNo());
		this.hashColumns.put("e1_sc_no", getE1ScNo());
		this.hashColumns.put("e1_g_rev", getE1GRev());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("mqc_qty", getMqcQty());
		this.hashColumns.put("e1_others_surcharge", getE1OthersSurcharge());
		this.hashColumns.put("e1_ifc_surcharge", getE1IfcSurcharge());
		this.hashColumns.put("sum_ifc_surcharge", getSumIfcSurcharge());
		this.hashColumns.put("sum_buc_surcharge", getSumBucSurcharge());
		this.hashColumns.put("e1_psc_surcharge", getE1PscSurcharge());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("a1_load", "a1Load");
		this.hashFields.put("sum_load", "sumLoad");
		this.hashFields.put("sum_g_rev", "sumGRev");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("sum_psc_surcharge", "sumPscSurcharge");
		this.hashFields.put("e1_load", "e1Load");
		this.hashFields.put("sum_others_surcharge", "sumOthersSurcharge");
		this.hashFields.put("a1_psc_surcharge", "a1PscSurcharge");
		this.hashFields.put("a1_ifc_surcharge", "a1IfcSurcharge");
		this.hashFields.put("e1_oft_surcharge", "e1OftSurcharge");
		this.hashFields.put("a1_week_cnt", "a1WeekCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("a1_oft_surcharge", "a1OftSurcharge");
		this.hashFields.put("a_sc_no", "aScNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("e1_buc_surcharge", "e1BucSurcharge");
		this.hashFields.put("a1_buc_surcharge", "a1BucSurcharge");
		this.hashFields.put("a1_others_surcharge", "a1OthersSurcharge");
		this.hashFields.put("a1_g_rev", "a1GRev");
		this.hashFields.put("sum_oft_surcharge", "sumOftSurcharge");
		this.hashFields.put("e2_sc_no", "e2ScNo");
		this.hashFields.put("e1_sc_no", "e1ScNo");
		this.hashFields.put("e1_g_rev", "e1GRev");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("mqc_qty", "mqcQty");
		this.hashFields.put("e1_others_surcharge", "e1OthersSurcharge");
		this.hashFields.put("e1_ifc_surcharge", "e1IfcSurcharge");
		this.hashFields.put("sum_ifc_surcharge", "sumIfcSurcharge");
		this.hashFields.put("sum_buc_surcharge", "sumBucSurcharge");
		this.hashFields.put("e1_psc_surcharge", "e1PscSurcharge");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return a1Load
	 */
	public String getA1Load() {
		return this.a1Load;
	}
	
	/**
	 * Column Info
	 * @return sumLoad
	 */
	public String getSumLoad() {
		return this.sumLoad;
	}
	
	/**
	 * Column Info
	 * @return sumGRev
	 */
	public String getSumGRev() {
		return this.sumGRev;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return sumPscSurcharge
	 */
	public String getSumPscSurcharge() {
		return this.sumPscSurcharge;
	}
	
	/**
	 * Column Info
	 * @return e1Load
	 */
	public String getE1Load() {
		return this.e1Load;
	}
	
	/**
	 * Column Info
	 * @return sumOthersSurcharge
	 */
	public String getSumOthersSurcharge() {
		return this.sumOthersSurcharge;
	}
	
	/**
	 * Column Info
	 * @return a1PscSurcharge
	 */
	public String getA1PscSurcharge() {
		return this.a1PscSurcharge;
	}
	
	/**
	 * Column Info
	 * @return a1IfcSurcharge
	 */
	public String getA1IfcSurcharge() {
		return this.a1IfcSurcharge;
	}
	
	/**
	 * Column Info
	 * @return e1OftSurcharge
	 */
	public String getE1OftSurcharge() {
		return this.e1OftSurcharge;
	}
	
	/**
	 * Column Info
	 * @return a1WeekCnt
	 */
	public String getA1WeekCnt() {
		return this.a1WeekCnt;
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
	 * @return a1OftSurcharge
	 */
	public String getA1OftSurcharge() {
		return this.a1OftSurcharge;
	}
	
	/**
	 * Column Info
	 * @return aScNo
	 */
	public String getAScNo() {
		return this.aScNo;
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
	 * @return e1BucSurcharge
	 */
	public String getE1BucSurcharge() {
		return this.e1BucSurcharge;
	}
	
	/**
	 * Column Info
	 * @return a1BucSurcharge
	 */
	public String getA1BucSurcharge() {
		return this.a1BucSurcharge;
	}
	
	/**
	 * Column Info
	 * @return a1OthersSurcharge
	 */
	public String getA1OthersSurcharge() {
		return this.a1OthersSurcharge;
	}
	
	/**
	 * Column Info
	 * @return a1GRev
	 */
	public String getA1GRev() {
		return this.a1GRev;
	}
	
	/**
	 * Column Info
	 * @return sumOftSurcharge
	 */
	public String getSumOftSurcharge() {
		return this.sumOftSurcharge;
	}
	
	/**
	 * Column Info
	 * @return e2ScNo
	 */
	public String getE2ScNo() {
		return this.e2ScNo;
	}
	
	/**
	 * Column Info
	 * @return e1ScNo
	 */
	public String getE1ScNo() {
		return this.e1ScNo;
	}
	
	/**
	 * Column Info
	 * @return e1GRev
	 */
	public String getE1GRev() {
		return this.e1GRev;
	}
	
	/**
	 * Column Info
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mqcQty
	 */
	public String getMqcQty() {
		return this.mqcQty;
	}
	
	/**
	 * Column Info
	 * @return e1OthersSurcharge
	 */
	public String getE1OthersSurcharge() {
		return this.e1OthersSurcharge;
	}
	
	/**
	 * Column Info
	 * @return e1IfcSurcharge
	 */
	public String getE1IfcSurcharge() {
		return this.e1IfcSurcharge;
	}
	
	/**
	 * Column Info
	 * @return sumIfcSurcharge
	 */
	public String getSumIfcSurcharge() {
		return this.sumIfcSurcharge;
	}
	
	/**
	 * Column Info
	 * @return sumBucSurcharge
	 */
	public String getSumBucSurcharge() {
		return this.sumBucSurcharge;
	}
	
	/**
	 * Column Info
	 * @return e1PscSurcharge
	 */
	public String getE1PscSurcharge() {
		return this.e1PscSurcharge;
	}
	

	/**
	 * Column Info
	 * @param a1Load
	 */
	public void setA1Load(String a1Load) {
		this.a1Load = a1Load;
	}
	
	/**
	 * Column Info
	 * @param sumLoad
	 */
	public void setSumLoad(String sumLoad) {
		this.sumLoad = sumLoad;
	}
	
	/**
	 * Column Info
	 * @param sumGRev
	 */
	public void setSumGRev(String sumGRev) {
		this.sumGRev = sumGRev;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param sumPscSurcharge
	 */
	public void setSumPscSurcharge(String sumPscSurcharge) {
		this.sumPscSurcharge = sumPscSurcharge;
	}
	
	/**
	 * Column Info
	 * @param e1Load
	 */
	public void setE1Load(String e1Load) {
		this.e1Load = e1Load;
	}
	
	/**
	 * Column Info
	 * @param sumOthersSurcharge
	 */
	public void setSumOthersSurcharge(String sumOthersSurcharge) {
		this.sumOthersSurcharge = sumOthersSurcharge;
	}
	
	/**
	 * Column Info
	 * @param a1PscSurcharge
	 */
	public void setA1PscSurcharge(String a1PscSurcharge) {
		this.a1PscSurcharge = a1PscSurcharge;
	}
	
	/**
	 * Column Info
	 * @param a1IfcSurcharge
	 */
	public void setA1IfcSurcharge(String a1IfcSurcharge) {
		this.a1IfcSurcharge = a1IfcSurcharge;
	}
	
	/**
	 * Column Info
	 * @param e1OftSurcharge
	 */
	public void setE1OftSurcharge(String e1OftSurcharge) {
		this.e1OftSurcharge = e1OftSurcharge;
	}
	
	/**
	 * Column Info
	 * @param a1WeekCnt
	 */
	public void setA1WeekCnt(String a1WeekCnt) {
		this.a1WeekCnt = a1WeekCnt;
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
	 * @param a1OftSurcharge
	 */
	public void setA1OftSurcharge(String a1OftSurcharge) {
		this.a1OftSurcharge = a1OftSurcharge;
	}
	
	/**
	 * Column Info
	 * @param aScNo
	 */
	public void setAScNo(String aScNo) {
		this.aScNo = aScNo;
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
	 * @param e1BucSurcharge
	 */
	public void setE1BucSurcharge(String e1BucSurcharge) {
		this.e1BucSurcharge = e1BucSurcharge;
	}
	
	/**
	 * Column Info
	 * @param a1BucSurcharge
	 */
	public void setA1BucSurcharge(String a1BucSurcharge) {
		this.a1BucSurcharge = a1BucSurcharge;
	}
	
	/**
	 * Column Info
	 * @param a1OthersSurcharge
	 */
	public void setA1OthersSurcharge(String a1OthersSurcharge) {
		this.a1OthersSurcharge = a1OthersSurcharge;
	}
	
	/**
	 * Column Info
	 * @param a1GRev
	 */
	public void setA1GRev(String a1GRev) {
		this.a1GRev = a1GRev;
	}
	
	/**
	 * Column Info
	 * @param sumOftSurcharge
	 */
	public void setSumOftSurcharge(String sumOftSurcharge) {
		this.sumOftSurcharge = sumOftSurcharge;
	}
	
	/**
	 * Column Info
	 * @param e2ScNo
	 */
	public void setE2ScNo(String e2ScNo) {
		this.e2ScNo = e2ScNo;
	}
	
	/**
	 * Column Info
	 * @param e1ScNo
	 */
	public void setE1ScNo(String e1ScNo) {
		this.e1ScNo = e1ScNo;
	}
	
	/**
	 * Column Info
	 * @param e1GRev
	 */
	public void setE1GRev(String e1GRev) {
		this.e1GRev = e1GRev;
	}
	
	/**
	 * Column Info
	 * @param propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mqcQty
	 */
	public void setMqcQty(String mqcQty) {
		this.mqcQty = mqcQty;
	}
	
	/**
	 * Column Info
	 * @param e1OthersSurcharge
	 */
	public void setE1OthersSurcharge(String e1OthersSurcharge) {
		this.e1OthersSurcharge = e1OthersSurcharge;
	}
	
	/**
	 * Column Info
	 * @param e1IfcSurcharge
	 */
	public void setE1IfcSurcharge(String e1IfcSurcharge) {
		this.e1IfcSurcharge = e1IfcSurcharge;
	}
	
	/**
	 * Column Info
	 * @param sumIfcSurcharge
	 */
	public void setSumIfcSurcharge(String sumIfcSurcharge) {
		this.sumIfcSurcharge = sumIfcSurcharge;
	}
	
	/**
	 * Column Info
	 * @param sumBucSurcharge
	 */
	public void setSumBucSurcharge(String sumBucSurcharge) {
		this.sumBucSurcharge = sumBucSurcharge;
	}
	
	/**
	 * Column Info
	 * @param e1PscSurcharge
	 */
	public void setE1PscSurcharge(String e1PscSurcharge) {
		this.e1PscSurcharge = e1PscSurcharge;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setA1Load(JSPUtil.getParameter(request, "a1_load", ""));
		setSumLoad(JSPUtil.getParameter(request, "sum_load", ""));
		setSumGRev(JSPUtil.getParameter(request, "sum_g_rev", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setSumPscSurcharge(JSPUtil.getParameter(request, "sum_psc_surcharge", ""));
		setE1Load(JSPUtil.getParameter(request, "e1_load", ""));
		setSumOthersSurcharge(JSPUtil.getParameter(request, "sum_others_surcharge", ""));
		setA1PscSurcharge(JSPUtil.getParameter(request, "a1_psc_surcharge", ""));
		setA1IfcSurcharge(JSPUtil.getParameter(request, "a1_ifc_surcharge", ""));
		setE1OftSurcharge(JSPUtil.getParameter(request, "e1_oft_surcharge", ""));
		setA1WeekCnt(JSPUtil.getParameter(request, "a1_week_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setA1OftSurcharge(JSPUtil.getParameter(request, "a1_oft_surcharge", ""));
		setAScNo(JSPUtil.getParameter(request, "a_sc_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setE1BucSurcharge(JSPUtil.getParameter(request, "e1_buc_surcharge", ""));
		setA1BucSurcharge(JSPUtil.getParameter(request, "a1_buc_surcharge", ""));
		setA1OthersSurcharge(JSPUtil.getParameter(request, "a1_others_surcharge", ""));
		setA1GRev(JSPUtil.getParameter(request, "a1_g_rev", ""));
		setSumOftSurcharge(JSPUtil.getParameter(request, "sum_oft_surcharge", ""));
		setE2ScNo(JSPUtil.getParameter(request, "e2_sc_no", ""));
		setE1ScNo(JSPUtil.getParameter(request, "e1_sc_no", ""));
		setE1GRev(JSPUtil.getParameter(request, "e1_g_rev", ""));
		setPropOfcCd(JSPUtil.getParameter(request, "prop_ofc_cd", ""));
		setMqcQty(JSPUtil.getParameter(request, "mqc_qty", ""));
		setE1OthersSurcharge(JSPUtil.getParameter(request, "e1_others_surcharge", ""));
		setE1IfcSurcharge(JSPUtil.getParameter(request, "e1_ifc_surcharge", ""));
		setSumIfcSurcharge(JSPUtil.getParameter(request, "sum_ifc_surcharge", ""));
		setSumBucSurcharge(JSPUtil.getParameter(request, "sum_buc_surcharge", ""));
		setE1PscSurcharge(JSPUtil.getParameter(request, "e1_psc_surcharge", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPrsAmendmentSummaryRevenueDetailVO[]
	 */
	public RsltPrsAmendmentSummaryRevenueDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPrsAmendmentSummaryRevenueDetailVO[]
	 */
	public RsltPrsAmendmentSummaryRevenueDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPrsAmendmentSummaryRevenueDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] a1Load = (JSPUtil.getParameter(request, prefix	+ "a1_load", length));
			String[] sumLoad = (JSPUtil.getParameter(request, prefix	+ "sum_load", length));
			String[] sumGRev = (JSPUtil.getParameter(request, prefix	+ "sum_g_rev", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] sumPscSurcharge = (JSPUtil.getParameter(request, prefix	+ "sum_psc_surcharge", length));
			String[] e1Load = (JSPUtil.getParameter(request, prefix	+ "e1_load", length));
			String[] sumOthersSurcharge = (JSPUtil.getParameter(request, prefix	+ "sum_others_surcharge", length));
			String[] a1PscSurcharge = (JSPUtil.getParameter(request, prefix	+ "a1_psc_surcharge", length));
			String[] a1IfcSurcharge = (JSPUtil.getParameter(request, prefix	+ "a1_ifc_surcharge", length));
			String[] e1OftSurcharge = (JSPUtil.getParameter(request, prefix	+ "e1_oft_surcharge", length));
			String[] a1WeekCnt = (JSPUtil.getParameter(request, prefix	+ "a1_week_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] a1OftSurcharge = (JSPUtil.getParameter(request, prefix	+ "a1_oft_surcharge", length));
			String[] aScNo = (JSPUtil.getParameter(request, prefix	+ "a_sc_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] e1BucSurcharge = (JSPUtil.getParameter(request, prefix	+ "e1_buc_surcharge", length));
			String[] a1BucSurcharge = (JSPUtil.getParameter(request, prefix	+ "a1_buc_surcharge", length));
			String[] a1OthersSurcharge = (JSPUtil.getParameter(request, prefix	+ "a1_others_surcharge", length));
			String[] a1GRev = (JSPUtil.getParameter(request, prefix	+ "a1_g_rev", length));
			String[] sumOftSurcharge = (JSPUtil.getParameter(request, prefix	+ "sum_oft_surcharge", length));
			String[] e2ScNo = (JSPUtil.getParameter(request, prefix	+ "e2_sc_no", length));
			String[] e1ScNo = (JSPUtil.getParameter(request, prefix	+ "e1_sc_no", length));
			String[] e1GRev = (JSPUtil.getParameter(request, prefix	+ "e1_g_rev", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] mqcQty = (JSPUtil.getParameter(request, prefix	+ "mqc_qty", length));
			String[] e1OthersSurcharge = (JSPUtil.getParameter(request, prefix	+ "e1_others_surcharge", length));
			String[] e1IfcSurcharge = (JSPUtil.getParameter(request, prefix	+ "e1_ifc_surcharge", length));
			String[] sumIfcSurcharge = (JSPUtil.getParameter(request, prefix	+ "sum_ifc_surcharge", length));
			String[] sumBucSurcharge = (JSPUtil.getParameter(request, prefix	+ "sum_buc_surcharge", length));
			String[] e1PscSurcharge = (JSPUtil.getParameter(request, prefix	+ "e1_psc_surcharge", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPrsAmendmentSummaryRevenueDetailVO();
				if (a1Load[i] != null)
					model.setA1Load(a1Load[i]);
				if (sumLoad[i] != null)
					model.setSumLoad(sumLoad[i]);
				if (sumGRev[i] != null)
					model.setSumGRev(sumGRev[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (sumPscSurcharge[i] != null)
					model.setSumPscSurcharge(sumPscSurcharge[i]);
				if (e1Load[i] != null)
					model.setE1Load(e1Load[i]);
				if (sumOthersSurcharge[i] != null)
					model.setSumOthersSurcharge(sumOthersSurcharge[i]);
				if (a1PscSurcharge[i] != null)
					model.setA1PscSurcharge(a1PscSurcharge[i]);
				if (a1IfcSurcharge[i] != null)
					model.setA1IfcSurcharge(a1IfcSurcharge[i]);
				if (e1OftSurcharge[i] != null)
					model.setE1OftSurcharge(e1OftSurcharge[i]);
				if (a1WeekCnt[i] != null)
					model.setA1WeekCnt(a1WeekCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (a1OftSurcharge[i] != null)
					model.setA1OftSurcharge(a1OftSurcharge[i]);
				if (aScNo[i] != null)
					model.setAScNo(aScNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (e1BucSurcharge[i] != null)
					model.setE1BucSurcharge(e1BucSurcharge[i]);
				if (a1BucSurcharge[i] != null)
					model.setA1BucSurcharge(a1BucSurcharge[i]);
				if (a1OthersSurcharge[i] != null)
					model.setA1OthersSurcharge(a1OthersSurcharge[i]);
				if (a1GRev[i] != null)
					model.setA1GRev(a1GRev[i]);
				if (sumOftSurcharge[i] != null)
					model.setSumOftSurcharge(sumOftSurcharge[i]);
				if (e2ScNo[i] != null)
					model.setE2ScNo(e2ScNo[i]);
				if (e1ScNo[i] != null)
					model.setE1ScNo(e1ScNo[i]);
				if (e1GRev[i] != null)
					model.setE1GRev(e1GRev[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (mqcQty[i] != null)
					model.setMqcQty(mqcQty[i]);
				if (e1OthersSurcharge[i] != null)
					model.setE1OthersSurcharge(e1OthersSurcharge[i]);
				if (e1IfcSurcharge[i] != null)
					model.setE1IfcSurcharge(e1IfcSurcharge[i]);
				if (sumIfcSurcharge[i] != null)
					model.setSumIfcSurcharge(sumIfcSurcharge[i]);
				if (sumBucSurcharge[i] != null)
					model.setSumBucSurcharge(sumBucSurcharge[i]);
				if (e1PscSurcharge[i] != null)
					model.setE1PscSurcharge(e1PscSurcharge[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPrsAmendmentSummaryRevenueDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPrsAmendmentSummaryRevenueDetailVO[]
	 */
	public RsltPrsAmendmentSummaryRevenueDetailVO[] getRsltPrsAmendmentSummaryRevenueDetailVOs(){
		RsltPrsAmendmentSummaryRevenueDetailVO[] vos = (RsltPrsAmendmentSummaryRevenueDetailVO[])models.toArray(new RsltPrsAmendmentSummaryRevenueDetailVO[models.size()]);
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
		this.a1Load = this.a1Load .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumLoad = this.sumLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumGRev = this.sumGRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumPscSurcharge = this.sumPscSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1Load = this.e1Load .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumOthersSurcharge = this.sumOthersSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1PscSurcharge = this.a1PscSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1IfcSurcharge = this.a1IfcSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1OftSurcharge = this.e1OftSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1WeekCnt = this.a1WeekCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1OftSurcharge = this.a1OftSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aScNo = this.aScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1BucSurcharge = this.e1BucSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1BucSurcharge = this.a1BucSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1OthersSurcharge = this.a1OthersSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1GRev = this.a1GRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumOftSurcharge = this.sumOftSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e2ScNo = this.e2ScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1ScNo = this.e1ScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1GRev = this.e1GRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqcQty = this.mqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1OthersSurcharge = this.e1OthersSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1IfcSurcharge = this.e1IfcSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumIfcSurcharge = this.sumIfcSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumBucSurcharge = this.sumBucSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e1PscSurcharge = this.e1PscSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
