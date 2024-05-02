/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SdmsReportVO.java
*@FileTitle : SdmsReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.02 이선영 
* 1.0 Creation
* 2011.04.01 공창식 [CHM-201109535-01] SDMS Damage Creation 변경 요청사항
=========================================================*/

package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo;

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
 * @author 이선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SdmsReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SdmsReportVO> models = new ArrayList<SdmsReportVO>();
	
	/* Column Info */
	private String grp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ratBillAmt = null;
	/* Column Info */
	private String ratComp = null;
	/* Column Info */
	private String ratUnknown = null;
	/* Column Info */
	private String ratAmtComp = null;
	/* Column Info */
	private String ratBill = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String ratRep = null;
	/* Column Info */
	private String stvDmgEvntDtFrom = null;
	/* Column Info */
	private String stvDmgEvntDtTo = null;
	/* Column Info */
	private String vslOshpCntrBlkTpCd = null;
	/* Column Info */
	private String groupBy = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String stvDmgPrtCateCd = null;
	/* Column Info */
	private String stvDmgPrtCd = null;
	/* Column Info */
	private String stvDmgTpCd = null;
	/* Column Info */
	private String stvDmgRespbPtyKwnCd = null;
	/* Column Info */
	private String stvDmgStepCd = null;
	/* Column Info */
	private String stvDmgRprProcStsCd = null;
	/* Column Info */
	private String stvDmgCmpnProcStsCd = null;
	/* Column Info */
	private String stvDmgStlProcStsCd = null;
	/* Column Info */
	private String slaneCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SdmsReportVO() {}

	public SdmsReportVO(String ibflag, String pagerows, String grp, String period, String ratUnknown, String ratRep, String stvDmgEvntDtFrom, String stvDmgEvntDtTo, String vslOshpCntrBlkTpCd, String groupBy, String locCd, String vpsPortCd, String vslCd, String stvDmgPrtCateCd, String stvDmgPrtCd, String stvDmgTpCd, String stvDmgRespbPtyKwnCd, String stvDmgStepCd, String stvDmgRprProcStsCd, String stvDmgCmpnProcStsCd, String stvDmgStlProcStsCd, String slaneCd, String ratComp, String ratAmtComp, String ratBill, String ratBillAmt) {
		this.grp = grp;
		this.ibflag = ibflag;
		this.ratBillAmt = ratBillAmt;
		this.ratComp = ratComp;
		this.ratUnknown = ratUnknown;
		this.ratAmtComp = ratAmtComp;
		this.ratBill = ratBill;
		this.period = period;
		this.ratRep = ratRep;
		this.stvDmgEvntDtFrom = stvDmgEvntDtFrom;
		this.stvDmgEvntDtTo = stvDmgEvntDtTo;
		this.vslOshpCntrBlkTpCd = vslOshpCntrBlkTpCd;
		this.groupBy = groupBy;
		this.locCd = locCd;
		this.vpsPortCd = vpsPortCd;
		this.vslCd = vslCd;
		this.stvDmgPrtCateCd = stvDmgPrtCateCd;
		this.stvDmgPrtCd = stvDmgPrtCd;
		this.stvDmgTpCd = stvDmgTpCd;
		this.stvDmgRespbPtyKwnCd = stvDmgRespbPtyKwnCd;
		this.stvDmgStepCd = stvDmgStepCd;
		this.stvDmgRprProcStsCd = stvDmgRprProcStsCd;
		this.stvDmgCmpnProcStsCd = stvDmgCmpnProcStsCd;
		this.stvDmgStlProcStsCd = stvDmgStlProcStsCd;
		this.slaneCd = slaneCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("grp", getGrp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rat_bill_amt", getRatBillAmt());
		this.hashColumns.put("rat_comp", getRatComp());
		this.hashColumns.put("rat_unknown", getRatUnknown());
		this.hashColumns.put("rat_amt_comp", getRatAmtComp());
		this.hashColumns.put("rat_bill", getRatBill());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("rat_rep", getRatRep());
		this.hashColumns.put("stv_dmg_evnt_dt_from", getStvDmgEvntDtFrom());
		this.hashColumns.put("stv_dmg_evnt_dt_to", getStvDmgEvntDtTo());
		this.hashColumns.put("vsl_oshp_cntr_blk_tp_cd", getVslOshpCntrBlkTpCd());
		this.hashColumns.put("group_by", getGroupBy());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("stv_dmg_prt_cate_cd", getStvDmgPrtCateCd());
		this.hashColumns.put("stv_dmg_prt_cd", getStvDmgPrtCd());
		this.hashColumns.put("stv_dmg_tp_cd", getStvDmgTpCd());
		this.hashColumns.put("stv_dmg_respb_pty_kwn_cd", getStvDmgRespbPtyKwnCd());
		this.hashColumns.put("stv_dmg_step_cd", getStvDmgStepCd());
		this.hashColumns.put("stv_dmg_rpr_proc_sts_cd", getStvDmgRprProcStsCd());
		this.hashColumns.put("stv_dmg_cmpn_proc_sts_cd", getStvDmgCmpnProcStsCd());
		this.hashColumns.put("stv_dmg_stl_proc_sts_cd", getStvDmgStlProcStsCd());
		this.hashColumns.put("slane_cd", getSlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("grp", "grp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rat_bill_amt", "ratBillAmt");
		this.hashFields.put("rat_comp", "ratComp");
		this.hashFields.put("rat_unknown", "ratUnknown");
		this.hashFields.put("rat_amt_comp", "ratAmtComp");
		this.hashFields.put("rat_bill", "ratBill");
		this.hashFields.put("period", "period");
		this.hashFields.put("rat_rep", "ratRep");
		this.hashFields.put("stv_dmg_evnt_dt_from", "stvDmgEvntDtFrom");
		this.hashFields.put("stv_dmg_evnt_dt_to", "stvDmgEvntDtTo");
		this.hashFields.put("vsl_oshp_cntr_blk_tp_cd", "vslOshpCntrBlkTpCd");
		this.hashFields.put("group_by", "groupBy");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("stv_dmg_prt_cate_cd", "stvDmgPrtCateCd");
		this.hashFields.put("stv_dmg_prt_cd", "stvDmgPrtCd");
		this.hashFields.put("stv_dmg_tp_cd", "stvDmgTpCd");
		this.hashFields.put("stv_dmg_respb_pty_kwn_cd", "stvDmgRespbPtyKwnCd");
		this.hashFields.put("stv_dmg_step_cd", "stvDmgStepCd");
		this.hashFields.put("stv_dmg_rpr_proc_sts_cd", "stvDmgRprProcStsCd");
		this.hashFields.put("stv_dmg_cmpn_proc_sts_cd", "stvDmgCmpnProcStsCd");
		this.hashFields.put("stv_dmg_stl_proc_sts_cd", "stvDmgStlProcStsCd");
		this.hashFields.put("slane_cd", "slaneCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return grp
	 */
	public String getGrp() {
		return this.grp;
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
	 * @return ratBillAmt
	 */
	public String getRatBillAmt() {
		return this.ratBillAmt;
	}
	
	/**
	 * Column Info
	 * @return ratComp
	 */
	public String getRatComp() {
		return this.ratComp;
	}
	
	/**
	 * Column Info
	 * @return ratUnknown
	 */
	public String getRatUnknown() {
		return this.ratUnknown;
	}
	
	/**
	 * Column Info
	 * @return ratAmtComp
	 */
	public String getRatAmtComp() {
		return this.ratAmtComp;
	}
	
	/**
	 * Column Info
	 * @return ratBill
	 */
	public String getRatBill() {
		return this.ratBill;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
	}
	
	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getRatRep() {
		return this.ratRep;
	}

	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getStvDmgEvntDtFrom() {
		return this.stvDmgEvntDtFrom;
	}

	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getStvDmgEvntDtTo() {
		return this.stvDmgEvntDtTo;
	}

	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getVslOshpCntrBlkTpCd() {
		return this.vslOshpCntrBlkTpCd;
	}

	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getGroupBy() {
		return this.groupBy;
	}

	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getLocCd() {
		return this.locCd;
	}

	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}

	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getVslCd() {
		return this.vslCd;
	}

	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getStvDmgPrtCateCd() {
		return this.stvDmgPrtCateCd;
	}

	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getStvDmgPrtCd() {
		return this.stvDmgPrtCd;
	}

	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getStvDmgTpCd() {
		return this.stvDmgTpCd;
	}

	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getStvDmgRespbPtyKwnCd() {
		return this.stvDmgRespbPtyKwnCd;
	}

	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getStvDmgStepCd() {
		return this.stvDmgStepCd;
	}
	
	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getStvDmgRprProcStsCd() {
		return this.stvDmgRprProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getStvDmgCmpnProcStsCd() {
		return this.stvDmgCmpnProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getStvDmgStlProcStsCd() {
		return this.stvDmgStlProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return ratRep
	 */
	public String getSlaneCd() {
		return this.slaneCd;
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
	 * @param grp
	 */
	public void setGrp(String grp) {
		this.grp = grp;
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
	 * @param ratBillAmt
	 */
	public void setRatBillAmt(String ratBillAmt) {
		this.ratBillAmt = ratBillAmt;
	}
	
	/**
	 * Column Info
	 * @param ratComp
	 */
	public void setRatComp(String ratComp) {
		this.ratComp = ratComp;
	}
	
	/**
	 * Column Info
	 * @param ratUnknown
	 */
	public void setRatUnknown(String ratUnknown) {
		this.ratUnknown = ratUnknown;
	}
	
	/**
	 * Column Info
	 * @param ratAmtComp
	 */
	public void setRatAmtComp(String ratAmtComp) {
		this.ratAmtComp = ratAmtComp;
	}
	
	/**
	 * Column Info
	 * @param ratBill
	 */
	public void setRatBill(String ratBill) {
		this.ratBill = ratBill;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setRatRep(String ratRep) {
		this.ratRep = ratRep;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setStvDmgEvntDtFrom(String stvDmgEvntDtFrom) {
		this.stvDmgEvntDtFrom = stvDmgEvntDtFrom;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setStvDmgEvntDtTo(String stvDmgEvntDtTo) {
		this.stvDmgEvntDtTo = stvDmgEvntDtTo;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setVslOshpCntrBlkTpCd(String vslOshpCntrBlkTpCd) {
		this.vslOshpCntrBlkTpCd = vslOshpCntrBlkTpCd;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setStvDmgPrtCateCd(String stvDmgPrtCateCd) {
		this.stvDmgPrtCateCd = stvDmgPrtCateCd;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setStvDmgPrtCd(String stvDmgPrtCd) {
		this.stvDmgPrtCd = stvDmgPrtCd;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setStvDmgTpCd(String stvDmgTpCd) {
		this.stvDmgTpCd = stvDmgTpCd;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setStvDmgRespbPtyKwnCd(String stvDmgRespbPtyKwnCd) {
		this.stvDmgRespbPtyKwnCd = stvDmgRespbPtyKwnCd;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setStvDmgStepCd(String stvDmgStepCd) {
		this.stvDmgStepCd = stvDmgStepCd;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setStvDmgRprProcStsCd(String stvDmgRprProcStsCd) {
		this.stvDmgRprProcStsCd = stvDmgRprProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setStvDmgCmpnProcStsCd(String stvDmgCmpnProcStsCd) {
		this.stvDmgCmpnProcStsCd = stvDmgCmpnProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setStvDmgStlProcStsCd(String stvDmgStlProcStsCd) {
		this.stvDmgStlProcStsCd = stvDmgStlProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param ratRep
	 */
	public void setSlaneCd(String slaneCd) {
		this.slaneCd = slaneCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setGrp(JSPUtil.getParameter(request, "grp", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRatBillAmt(JSPUtil.getParameter(request, "rat_bill_amt", ""));
		setRatComp(JSPUtil.getParameter(request, "rat_comp", ""));
		setRatUnknown(JSPUtil.getParameter(request, "rat_unknown", ""));
		setRatAmtComp(JSPUtil.getParameter(request, "rat_amt_comp", ""));
		setRatBill(JSPUtil.getParameter(request, "rat_bill", ""));
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setRatRep(JSPUtil.getParameter(request, "rat_rep", ""));
		setStvDmgEvntDtFrom(JSPUtil.getParameter(request, "stv_dmg_evnt_dt_from", ""));
		setStvDmgEvntDtTo(JSPUtil.getParameter(request, "stv_dmg_evnt_dt_to", ""));
		setVslOshpCntrBlkTpCd(JSPUtil.getParameter(request, "vsl_oshp_cntr_blk_tp_cd", ""));
		setGroupBy(JSPUtil.getParameter(request, "group_by", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setStvDmgPrtCateCd(JSPUtil.getParameter(request, "stv_dmg_prt_cate_cd", ""));
		setStvDmgPrtCd(JSPUtil.getParameter(request, "stv_dmg_prt_cd", ""));
		setStvDmgTpCd(JSPUtil.getParameter(request, "stv_dmg_tp_cd", ""));
		setStvDmgRespbPtyKwnCd(JSPUtil.getParameter(request, "stv_dmg_respb_pty_kwn_cd", ""));
		setStvDmgStepCd(JSPUtil.getParameter(request, "stv_dmg_step_cd", ""));
		setStvDmgRprProcStsCd(JSPUtil.getParameter(request, "stv_dmg_rpr_proc_sts_cd", ""));
		setStvDmgCmpnProcStsCd(JSPUtil.getParameter(request, "stv_dmg_cmpn_proc_sts_cd", ""));
		setStvDmgStlProcStsCd(JSPUtil.getParameter(request, "stv_dmg_stl_proc_sts_cd", ""));
		setSlaneCd(JSPUtil.getParameter(request, "slane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SdmsReportVO[]
	 */
	public SdmsReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SdmsReportVO[]
	 */
	public SdmsReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SdmsReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] grp = (JSPUtil.getParameter(request, prefix	+ "grp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ratBillAmt = (JSPUtil.getParameter(request, prefix	+ "rat_bill_amt", length));
			String[] ratComp = (JSPUtil.getParameter(request, prefix	+ "rat_comp", length));
			String[] ratUnknown = (JSPUtil.getParameter(request, prefix	+ "rat_unknown", length));
			String[] ratAmtComp = (JSPUtil.getParameter(request, prefix	+ "rat_amt_comp", length));
			String[] ratBill = (JSPUtil.getParameter(request, prefix	+ "rat_bill", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] ratRep = (JSPUtil.getParameter(request, prefix	+ "rat_rep", length));
			String[] stvDmgEvntDtFrom = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_evnt_dt_from", length));
			String[] stvDmgEvntDtTo = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_evnt_dt_to", length));
			String[] vslOshpCntrBlkTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cntr_blk_tp_cd", length));
			String[] groupBy = (JSPUtil.getParameter(request, prefix	+ "group_by", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] stvDmgPrtCateCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_prt_cate_cd", length));
			String[] stvDmgPrtCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_prt_cd", length));
			String[] stvDmgTpCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_tp_cd", length));
			String[] stvDmgRespbPtyKwnCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_respb_pty_kwn_cd", length));
			String[] stvDmgStepCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_step_cd", length));
			String[] stvDmgRprProcStsCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_rpr_proc_sts_cd", length));
			String[] stvDmgCmpnProcStsCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_cmpn_proc_sts_cd", length));
			String[] stvDmgStlProcStsCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_stl_proc_sts_cd", length));
			String[] slaneCd = (JSPUtil.getParameter(request, prefix	+ "slane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SdmsReportVO();
				if (grp[i] != null)
					model.setGrp(grp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ratBillAmt[i] != null)
					model.setRatBillAmt(ratBillAmt[i]);
				if (ratComp[i] != null)
					model.setRatComp(ratComp[i]);
				if (ratUnknown[i] != null)
					model.setRatUnknown(ratUnknown[i]);
				if (ratAmtComp[i] != null)
					model.setRatAmtComp(ratAmtComp[i]);
				if (ratBill[i] != null)
					model.setRatBill(ratBill[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (ratRep[i] != null)
					model.setRatRep(ratRep[i]);
				if (stvDmgEvntDtFrom[i] != null)
					model.setStvDmgEvntDtFrom(stvDmgEvntDtFrom[i]);
				if (stvDmgEvntDtTo[i] != null)
					model.setStvDmgEvntDtTo(stvDmgEvntDtTo[i]);
				if (vslOshpCntrBlkTpCd[i] != null)
					model.setVslOshpCntrBlkTpCd(vslOshpCntrBlkTpCd[i]);
				if (groupBy[i] != null)
					model.setGroupBy(groupBy[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (stvDmgPrtCateCd[i] != null)
					model.setStvDmgPrtCateCd(stvDmgPrtCateCd[i]);
				if (stvDmgPrtCd[i] != null)
					model.setStvDmgPrtCd(stvDmgPrtCd[i]);
				if (stvDmgTpCd[i] != null)
					model.setStvDmgTpCd(stvDmgTpCd[i]);
				if (stvDmgRespbPtyKwnCd[i] != null)
					model.setStvDmgRespbPtyKwnCd(stvDmgRespbPtyKwnCd[i]);
				if (stvDmgStepCd[i] != null)
					model.setStvDmgStepCd(stvDmgStepCd[i]);
				if (stvDmgRprProcStsCd[i] != null)
					model.setStvDmgRprProcStsCd(stvDmgRprProcStsCd[i]);
				if (stvDmgCmpnProcStsCd[i] != null)
					model.setStvDmgCmpnProcStsCd(stvDmgCmpnProcStsCd[i]);
				if (stvDmgStlProcStsCd[i] != null)
					model.setStvDmgStlProcStsCd(stvDmgStlProcStsCd[i]);
				if (slaneCd[i] != null)
					model.setSlaneCd(slaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSdmsReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SdmsReportVO[]
	 */
	public SdmsReportVO[] getSdmsReportVOs(){
		SdmsReportVO[] vos = (SdmsReportVO[])models.toArray(new SdmsReportVO[models.size()]);
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
		this.grp = this.grp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratBillAmt = this.ratBillAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratComp = this.ratComp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUnknown = this.ratUnknown .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAmtComp = this.ratAmtComp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratBill = this.ratBill .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratRep = this.ratRep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgEvntDtFrom = this.stvDmgEvntDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgEvntDtTo = this.stvDmgEvntDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCntrBlkTpCd = this.vslOshpCntrBlkTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupBy = this.groupBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgPrtCateCd = this.stvDmgPrtCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgPrtCd = this.stvDmgPrtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgTpCd = this.stvDmgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgRespbPtyKwnCd = this.stvDmgRespbPtyKwnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgStepCd = this.stvDmgStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgRprProcStsCd = this.stvDmgRprProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgCmpnProcStsCd = this.stvDmgCmpnProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgStlProcStsCd = this.stvDmgStlProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slaneCd = this.slaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
