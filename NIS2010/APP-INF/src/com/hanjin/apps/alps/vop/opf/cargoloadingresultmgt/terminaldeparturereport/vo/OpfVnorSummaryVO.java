/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OpfVnorSummaryVO.java
*@FileTitle : OpfVnorSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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

public class OpfVnorSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpfVnorSummaryVO> models = new ArrayList<OpfVnorSummaryVO>();
	
	/* Column Info */
	private String vnorOffhTpCd = null;
	/* Column Info */
	private String otItmRmk = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vnorOffhKndCd = null;
	/* Column Info */
	private String vnorStupStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ohItmRmk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String saDt = null;
	/* Column Info */
	private String mdItmVal = null;
	/* Column Info */
	private String vnorOffhFmDt = null;
	/* Column Info */
	private String tcItmVal = null;
	/* Column Info */
	private String vnorOffhToDt = null;
	/* Column Info */
	private String suDt = null;
	/* Column Info */
	private String vnorFmPortCd = null;
	/* Column Info */
	private String vnorItmOfcCd = null;
	/* Column Info */
	private String vnorVslStsCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ldItmVal = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String hfItmVal = null;
	/* Column Info */
	private String pcItmVal = null;
	/* Column Info */
	private String offHireTimeCd = null;
	/* Column Info */
	private String lfItmVal = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String vnorToPortCd = null;
	/* Column Info */
	private String vnorSeq = null;
	/* Column Info */
	private String ohItmVal = null;
	/* Column Info */
	private String otItmVal = null;
	/* Column Info */
	private String fmsStsCd = null;
	/* Column Info */
	private String createdBy = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OpfVnorSummaryVO() {}

	public OpfVnorSummaryVO(String ibflag, String pagerows, String vslCd, String vnorSeq, String skdVoyNo, String saDt, String suDt, String vnorOffhFmDt, String vnorOffhToDt, String ohItmVal, String ohItmRmk, String vnorVslStsCd, String vnorFmPortCd, String vnorToPortCd, String vnorOffhKndCd, String vnorOffhTpCd, String vnorStupStsCd, String fmsStsCd, String hfItmVal, String mdItmVal, String lfItmVal, String ldItmVal, String pcItmVal, String tcItmVal, String otItmVal, String vnorItmOfcCd, String otItmRmk, String offHireTimeCd, String fromDate, String toDate, String createdBy) {
		this.vnorOffhTpCd = vnorOffhTpCd;
		this.otItmRmk = otItmRmk;
		this.vslCd = vslCd;
		this.vnorOffhKndCd = vnorOffhKndCd;
		this.vnorStupStsCd = vnorStupStsCd;
		this.pagerows = pagerows;
		this.ohItmRmk = ohItmRmk;
		this.ibflag = ibflag;
		this.saDt = saDt;
		this.mdItmVal = mdItmVal;
		this.vnorOffhFmDt = vnorOffhFmDt;
		this.tcItmVal = tcItmVal;
		this.vnorOffhToDt = vnorOffhToDt;
		this.suDt = suDt;
		this.vnorFmPortCd = vnorFmPortCd;
		this.vnorItmOfcCd = vnorItmOfcCd;
		this.vnorVslStsCd = vnorVslStsCd;
		this.skdVoyNo = skdVoyNo;
		this.ldItmVal = ldItmVal;
		this.toDate = toDate;
		this.hfItmVal = hfItmVal;
		this.pcItmVal = pcItmVal;
		this.offHireTimeCd = offHireTimeCd;
		this.lfItmVal = lfItmVal;
		this.fromDate = fromDate;
		this.vnorToPortCd = vnorToPortCd;
		this.vnorSeq = vnorSeq;
		this.ohItmVal = ohItmVal;
		this.otItmVal = otItmVal;
		this.fmsStsCd = fmsStsCd;
		this.createdBy = createdBy;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vnor_offh_tp_cd", getVnorOffhTpCd());
		this.hashColumns.put("ot_itm_rmk", getOtItmRmk());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vnor_offh_knd_cd", getVnorOffhKndCd());
		this.hashColumns.put("vnor_stup_sts_cd", getVnorStupStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("oh_itm_rmk", getOhItmRmk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sa_dt", getSaDt());
		this.hashColumns.put("md_itm_val", getMdItmVal());
		this.hashColumns.put("vnor_offh_fm_dt", getVnorOffhFmDt());
		this.hashColumns.put("tc_itm_val", getTcItmVal());
		this.hashColumns.put("vnor_offh_to_dt", getVnorOffhToDt());
		this.hashColumns.put("su_dt", getSuDt());
		this.hashColumns.put("vnor_fm_port_cd", getVnorFmPortCd());
		this.hashColumns.put("vnor_itm_ofc_cd", getVnorItmOfcCd());
		this.hashColumns.put("vnor_vsl_sts_cd", getVnorVslStsCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ld_itm_val", getLdItmVal());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("hf_itm_val", getHfItmVal());
		this.hashColumns.put("pc_itm_val", getPcItmVal());
		this.hashColumns.put("off_hire_time_cd", getOffHireTimeCd());
		this.hashColumns.put("lf_itm_val", getLfItmVal());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("vnor_to_port_cd", getVnorToPortCd());
		this.hashColumns.put("vnor_seq", getVnorSeq());
		this.hashColumns.put("oh_itm_val", getOhItmVal());
		this.hashColumns.put("ot_itm_val", getOtItmVal());
		this.hashColumns.put("fms_sts_cd", getFmsStsCd());
		this.hashColumns.put("created_by", getCreatedBy());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vnor_offh_tp_cd", "vnorOffhTpCd");
		this.hashFields.put("ot_itm_rmk", "otItmRmk");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vnor_offh_knd_cd", "vnorOffhKndCd");
		this.hashFields.put("vnor_stup_sts_cd", "vnorStupStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("oh_itm_rmk", "ohItmRmk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sa_dt", "saDt");
		this.hashFields.put("md_itm_val", "mdItmVal");
		this.hashFields.put("vnor_offh_fm_dt", "vnorOffhFmDt");
		this.hashFields.put("tc_itm_val", "tcItmVal");
		this.hashFields.put("vnor_offh_to_dt", "vnorOffhToDt");
		this.hashFields.put("su_dt", "suDt");
		this.hashFields.put("vnor_fm_port_cd", "vnorFmPortCd");
		this.hashFields.put("vnor_itm_ofc_cd", "vnorItmOfcCd");
		this.hashFields.put("vnor_vsl_sts_cd", "vnorVslStsCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ld_itm_val", "ldItmVal");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("hf_itm_val", "hfItmVal");
		this.hashFields.put("pc_itm_val", "pcItmVal");
		this.hashFields.put("off_hire_time_cd", "offHireTimeCd");
		this.hashFields.put("lf_itm_val", "lfItmVal");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("vnor_to_port_cd", "vnorToPortCd");
		this.hashFields.put("vnor_seq", "vnorSeq");
		this.hashFields.put("oh_itm_val", "ohItmVal");
		this.hashFields.put("ot_itm_val", "otItmVal");
		this.hashFields.put("fms_sts_cd", "fmsStsCd");
		this.hashFields.put("created_by", "createdBy");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vnorOffhTpCd
	 */
	public String getVnorOffhTpCd() {
		return this.vnorOffhTpCd;
	}
	
	/**
	 * Column Info
	 * @return otItmRmk
	 */
	public String getOtItmRmk() {
		return this.otItmRmk;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return vnorOffhKndCd
	 */
	public String getVnorOffhKndCd() {
		return this.vnorOffhKndCd;
	}
	
	/**
	 * Column Info
	 * @return vnorStupStsCd
	 */
	public String getVnorStupStsCd() {
		return this.vnorStupStsCd;
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
	 * @return ohItmRmk
	 */
	public String getOhItmRmk() {
		return this.ohItmRmk;
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
	 * @return saDt
	 */
	public String getSaDt() {
		return this.saDt;
	}
	
	/**
	 * Column Info
	 * @return mdItmVal
	 */
	public String getMdItmVal() {
		return this.mdItmVal;
	}
	
	/**
	 * Column Info
	 * @return vnorOffhFmDt
	 */
	public String getVnorOffhFmDt() {
		return this.vnorOffhFmDt;
	}
	
	/**
	 * Column Info
	 * @return tcItmVal
	 */
	public String getTcItmVal() {
		return this.tcItmVal;
	}
	
	/**
	 * Column Info
	 * @return vnorOffhToDt
	 */
	public String getVnorOffhToDt() {
		return this.vnorOffhToDt;
	}
	
	/**
	 * Column Info
	 * @return suDt
	 */
	public String getSuDt() {
		return this.suDt;
	}
	
	/**
	 * Column Info
	 * @return vnorFmPortCd
	 */
	public String getVnorFmPortCd() {
		return this.vnorFmPortCd;
	}
	
	/**
	 * Column Info
	 * @return vnorItmOfcCd
	 */
	public String getVnorItmOfcCd() {
		return this.vnorItmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vnorVslStsCd
	 */
	public String getVnorVslStsCd() {
		return this.vnorVslStsCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return ldItmVal
	 */
	public String getLdItmVal() {
		return this.ldItmVal;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return hfItmVal
	 */
	public String getHfItmVal() {
		return this.hfItmVal;
	}
	
	/**
	 * Column Info
	 * @return pcItmVal
	 */
	public String getPcItmVal() {
		return this.pcItmVal;
	}
	
	/**
	 * Column Info
	 * @return offHireTimeCd
	 */
	public String getOffHireTimeCd() {
		return this.offHireTimeCd;
	}
	
	/**
	 * Column Info
	 * @return lfItmVal
	 */
	public String getLfItmVal() {
		return this.lfItmVal;
	}
	
	/**
	 * Column Info
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
	}
	
	/**
	 * Column Info
	 * @return vnorToPortCd
	 */
	public String getVnorToPortCd() {
		return this.vnorToPortCd;
	}
	
	/**
	 * Column Info
	 * @return vnorSeq
	 */
	public String getVnorSeq() {
		return this.vnorSeq;
	}
	
	/**
	 * Column Info
	 * @return ohItmVal
	 */
	public String getOhItmVal() {
		return this.ohItmVal;
	}
	
	/**
	 * Column Info
	 * @return otItmVal
	 */
	public String getOtItmVal() {
		return this.otItmVal;
	}
	
	/**
	 * Column Info
	 * @return fmsStsCd
	 */
	public String getFmsStsCd() {
		return this.fmsStsCd;
	}
	
	/**
	 * Column Info
	 * @return createdBy
	 */
	public String getCreatedBy() {
		return this.createdBy;
	}
	

	/**
	 * Column Info
	 * @param vnorOffhTpCd
	 */
	public void setVnorOffhTpCd(String vnorOffhTpCd) {
		this.vnorOffhTpCd = vnorOffhTpCd;
	}
	
	/**
	 * Column Info
	 * @param otItmRmk
	 */
	public void setOtItmRmk(String otItmRmk) {
		this.otItmRmk = otItmRmk;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param vnorOffhKndCd
	 */
	public void setVnorOffhKndCd(String vnorOffhKndCd) {
		this.vnorOffhKndCd = vnorOffhKndCd;
	}
	
	/**
	 * Column Info
	 * @param vnorStupStsCd
	 */
	public void setVnorStupStsCd(String vnorStupStsCd) {
		this.vnorStupStsCd = vnorStupStsCd;
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
	 * @param ohItmRmk
	 */
	public void setOhItmRmk(String ohItmRmk) {
		this.ohItmRmk = ohItmRmk;
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
	 * @param saDt
	 */
	public void setSaDt(String saDt) {
		this.saDt = saDt;
	}
	
	/**
	 * Column Info
	 * @param mdItmVal
	 */
	public void setMdItmVal(String mdItmVal) {
		this.mdItmVal = mdItmVal;
	}
	
	/**
	 * Column Info
	 * @param vnorOffhFmDt
	 */
	public void setVnorOffhFmDt(String vnorOffhFmDt) {
		this.vnorOffhFmDt = vnorOffhFmDt;
	}
	
	/**
	 * Column Info
	 * @param tcItmVal
	 */
	public void setTcItmVal(String tcItmVal) {
		this.tcItmVal = tcItmVal;
	}
	
	/**
	 * Column Info
	 * @param vnorOffhToDt
	 */
	public void setVnorOffhToDt(String vnorOffhToDt) {
		this.vnorOffhToDt = vnorOffhToDt;
	}
	
	/**
	 * Column Info
	 * @param suDt
	 */
	public void setSuDt(String suDt) {
		this.suDt = suDt;
	}
	
	/**
	 * Column Info
	 * @param vnorFmPortCd
	 */
	public void setVnorFmPortCd(String vnorFmPortCd) {
		this.vnorFmPortCd = vnorFmPortCd;
	}
	
	/**
	 * Column Info
	 * @param vnorItmOfcCd
	 */
	public void setVnorItmOfcCd(String vnorItmOfcCd) {
		this.vnorItmOfcCd = vnorItmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vnorVslStsCd
	 */
	public void setVnorVslStsCd(String vnorVslStsCd) {
		this.vnorVslStsCd = vnorVslStsCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param ldItmVal
	 */
	public void setLdItmVal(String ldItmVal) {
		this.ldItmVal = ldItmVal;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param hfItmVal
	 */
	public void setHfItmVal(String hfItmVal) {
		this.hfItmVal = hfItmVal;
	}
	
	/**
	 * Column Info
	 * @param pcItmVal
	 */
	public void setPcItmVal(String pcItmVal) {
		this.pcItmVal = pcItmVal;
	}
	
	/**
	 * Column Info
	 * @param offHireTimeCd
	 */
	public void setOffHireTimeCd(String offHireTimeCd) {
		this.offHireTimeCd = offHireTimeCd;
	}
	
	/**
	 * Column Info
	 * @param lfItmVal
	 */
	public void setLfItmVal(String lfItmVal) {
		this.lfItmVal = lfItmVal;
	}
	
	/**
	 * Column Info
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	/**
	 * Column Info
	 * @param vnorToPortCd
	 */
	public void setVnorToPortCd(String vnorToPortCd) {
		this.vnorToPortCd = vnorToPortCd;
	}
	
	/**
	 * Column Info
	 * @param vnorSeq
	 */
	public void setVnorSeq(String vnorSeq) {
		this.vnorSeq = vnorSeq;
	}
	
	/**
	 * Column Info
	 * @param ohItmVal
	 */
	public void setOhItmVal(String ohItmVal) {
		this.ohItmVal = ohItmVal;
	}
	
	/**
	 * Column Info
	 * @param otItmVal
	 */
	public void setOtItmVal(String otItmVal) {
		this.otItmVal = otItmVal;
	}
	
	/**
	 * Column Info
	 * @param fmsStsCd
	 */
	public void setFmsStsCd(String fmsStsCd) {
		this.fmsStsCd = fmsStsCd;
	}
	
	/**
	 * Column Info
	 * @param createdBy
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
		setVnorOffhTpCd(JSPUtil.getParameter(request, prefix + "vnor_offh_tp_cd", ""));
		setOtItmRmk(JSPUtil.getParameter(request, prefix + "ot_itm_rmk", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVnorOffhKndCd(JSPUtil.getParameter(request, prefix + "vnor_offh_knd_cd", ""));
		setVnorStupStsCd(JSPUtil.getParameter(request, prefix + "vnor_stup_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOhItmRmk(JSPUtil.getParameter(request, prefix + "oh_itm_rmk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSaDt(JSPUtil.getParameter(request, prefix + "sa_dt", ""));
		setMdItmVal(JSPUtil.getParameter(request, prefix + "md_itm_val", ""));
		setVnorOffhFmDt(JSPUtil.getParameter(request, prefix + "vnor_offh_fm_dt", ""));
		setTcItmVal(JSPUtil.getParameter(request, prefix + "tc_itm_val", ""));
		setVnorOffhToDt(JSPUtil.getParameter(request, prefix + "vnor_offh_to_dt", ""));
		setSuDt(JSPUtil.getParameter(request, prefix + "su_dt", ""));
		setVnorFmPortCd(JSPUtil.getParameter(request, prefix + "vnor_fm_port_cd", ""));
		setVnorItmOfcCd(JSPUtil.getParameter(request, prefix + "vnor_itm_ofc_cd", ""));
		setVnorVslStsCd(JSPUtil.getParameter(request, prefix + "vnor_vsl_sts_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setLdItmVal(JSPUtil.getParameter(request, prefix + "ld_itm_val", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setHfItmVal(JSPUtil.getParameter(request, prefix + "hf_itm_val", ""));
		setPcItmVal(JSPUtil.getParameter(request, prefix + "pc_itm_val", ""));
		setOffHireTimeCd(JSPUtil.getParameter(request, prefix + "off_hire_time_cd", ""));
		setLfItmVal(JSPUtil.getParameter(request, prefix + "lf_itm_val", ""));
		setFromDate(JSPUtil.getParameter(request, prefix + "from_date", ""));
		setVnorToPortCd(JSPUtil.getParameter(request, prefix + "vnor_to_port_cd", ""));
		setVnorSeq(JSPUtil.getParameter(request, prefix + "vnor_seq", ""));
		setOhItmVal(JSPUtil.getParameter(request, prefix + "oh_itm_val", ""));
		setOtItmVal(JSPUtil.getParameter(request, prefix + "ot_itm_val", ""));
		setFmsStsCd(JSPUtil.getParameter(request, prefix + "fms_sts_cd", ""));
		setFmsStsCd(JSPUtil.getParameter(request, prefix + "created_by", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpfVnorSummaryVO[]
	 */
	public OpfVnorSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpfVnorSummaryVO[]
	 */
	public OpfVnorSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpfVnorSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vnorOffhTpCd = (JSPUtil.getParameter(request, prefix	+ "vnor_offh_tp_cd", length));
			String[] otItmRmk = (JSPUtil.getParameter(request, prefix	+ "ot_itm_rmk", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vnorOffhKndCd = (JSPUtil.getParameter(request, prefix	+ "vnor_offh_knd_cd", length));
			String[] vnorStupStsCd = (JSPUtil.getParameter(request, prefix	+ "vnor_stup_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ohItmRmk = (JSPUtil.getParameter(request, prefix	+ "oh_itm_rmk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] saDt = (JSPUtil.getParameter(request, prefix	+ "sa_dt", length));
			String[] mdItmVal = (JSPUtil.getParameter(request, prefix	+ "md_itm_val", length));
			String[] vnorOffhFmDt = (JSPUtil.getParameter(request, prefix	+ "vnor_offh_fm_dt", length));
			String[] tcItmVal = (JSPUtil.getParameter(request, prefix	+ "tc_itm_val", length));
			String[] vnorOffhToDt = (JSPUtil.getParameter(request, prefix	+ "vnor_offh_to_dt", length));
			String[] suDt = (JSPUtil.getParameter(request, prefix	+ "su_dt", length));
			String[] vnorFmPortCd = (JSPUtil.getParameter(request, prefix	+ "vnor_fm_port_cd", length));
			String[] vnorItmOfcCd = (JSPUtil.getParameter(request, prefix	+ "vnor_itm_ofc_cd", length));
			String[] vnorVslStsCd = (JSPUtil.getParameter(request, prefix	+ "vnor_vsl_sts_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ldItmVal = (JSPUtil.getParameter(request, prefix	+ "ld_itm_val", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] hfItmVal = (JSPUtil.getParameter(request, prefix	+ "hf_itm_val", length));
			String[] pcItmVal = (JSPUtil.getParameter(request, prefix	+ "pc_itm_val", length));
			String[] offHireTimeCd = (JSPUtil.getParameter(request, prefix	+ "off_hire_time_cd", length));
			String[] lfItmVal = (JSPUtil.getParameter(request, prefix	+ "lf_itm_val", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] vnorToPortCd = (JSPUtil.getParameter(request, prefix	+ "vnor_to_port_cd", length));
			String[] vnorSeq = (JSPUtil.getParameter(request, prefix	+ "vnor_seq", length));
			String[] ohItmVal = (JSPUtil.getParameter(request, prefix	+ "oh_itm_val", length));
			String[] otItmVal = (JSPUtil.getParameter(request, prefix	+ "ot_itm_val", length));
			String[] fmsStsCd = (JSPUtil.getParameter(request, prefix	+ "fms_sts_cd", length));
			String[] createdBy = (JSPUtil.getParameter(request, prefix	+ "created_by", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpfVnorSummaryVO();
				if (vnorOffhTpCd[i] != null)
					model.setVnorOffhTpCd(vnorOffhTpCd[i]);
				if (otItmRmk[i] != null)
					model.setOtItmRmk(otItmRmk[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vnorOffhKndCd[i] != null)
					model.setVnorOffhKndCd(vnorOffhKndCd[i]);
				if (vnorStupStsCd[i] != null)
					model.setVnorStupStsCd(vnorStupStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ohItmRmk[i] != null)
					model.setOhItmRmk(ohItmRmk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (saDt[i] != null)
					model.setSaDt(saDt[i]);
				if (mdItmVal[i] != null)
					model.setMdItmVal(mdItmVal[i]);
				if (vnorOffhFmDt[i] != null)
					model.setVnorOffhFmDt(vnorOffhFmDt[i]);
				if (tcItmVal[i] != null)
					model.setTcItmVal(tcItmVal[i]);
				if (vnorOffhToDt[i] != null)
					model.setVnorOffhToDt(vnorOffhToDt[i]);
				if (suDt[i] != null)
					model.setSuDt(suDt[i]);
				if (vnorFmPortCd[i] != null)
					model.setVnorFmPortCd(vnorFmPortCd[i]);
				if (vnorItmOfcCd[i] != null)
					model.setVnorItmOfcCd(vnorItmOfcCd[i]);
				if (vnorVslStsCd[i] != null)
					model.setVnorVslStsCd(vnorVslStsCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ldItmVal[i] != null)
					model.setLdItmVal(ldItmVal[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (hfItmVal[i] != null)
					model.setHfItmVal(hfItmVal[i]);
				if (pcItmVal[i] != null)
					model.setPcItmVal(pcItmVal[i]);
				if (offHireTimeCd[i] != null)
					model.setOffHireTimeCd(offHireTimeCd[i]);
				if (lfItmVal[i] != null)
					model.setLfItmVal(lfItmVal[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (vnorToPortCd[i] != null)
					model.setVnorToPortCd(vnorToPortCd[i]);
				if (vnorSeq[i] != null)
					model.setVnorSeq(vnorSeq[i]);
				if (ohItmVal[i] != null)
					model.setOhItmVal(ohItmVal[i]);
				if (otItmVal[i] != null)
					model.setOtItmVal(otItmVal[i]);
				if (fmsStsCd[i] != null)
					model.setFmsStsCd(fmsStsCd[i]);
				if (createdBy[i] != null)
					model.setCreatedBy(createdBy[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpfVnorSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpfVnorSummaryVO[]
	 */
	public OpfVnorSummaryVO[] getOpfVnorSummaryVOs(){
		OpfVnorSummaryVO[] vos = (OpfVnorSummaryVO[])models.toArray(new OpfVnorSummaryVO[models.size()]);
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
		this.vnorOffhTpCd = this.vnorOffhTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otItmRmk = this.otItmRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorOffhKndCd = this.vnorOffhKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorStupStsCd = this.vnorStupStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ohItmRmk = this.ohItmRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saDt = this.saDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdItmVal = this.mdItmVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorOffhFmDt = this.vnorOffhFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tcItmVal = this.tcItmVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorOffhToDt = this.vnorOffhToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suDt = this.suDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorFmPortCd = this.vnorFmPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorItmOfcCd = this.vnorItmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorVslStsCd = this.vnorVslStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldItmVal = this.ldItmVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hfItmVal = this.hfItmVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcItmVal = this.pcItmVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offHireTimeCd = this.offHireTimeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfItmVal = this.lfItmVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorToPortCd = this.vnorToPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnorSeq = this.vnorSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ohItmVal = this.ohItmVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otItmVal = this.otItmVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmsStsCd = this.fmsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.createdBy = this.createdBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
