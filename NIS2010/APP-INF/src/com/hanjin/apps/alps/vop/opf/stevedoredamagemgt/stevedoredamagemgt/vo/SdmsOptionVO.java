/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SdmsOptionVO.java
*@FileTitle : SdmsOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.10
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.02.10 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SdmsOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SdmsOptionVO> models = new ArrayList<SdmsOptionVO>();
	
	/* Column Info */
	private String stvDmgEvntDtFrom = null;
	/* Column Info */
	private String elapseDay = null;
	/* Column Info */
	private String stvDmgEvntDtTo = null;
	/* Column Info */
	private String stvDmgCmpnProcStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String reqPortCd = null;
	/* Column Info */
	private String rprCostUsdAmt = null;
	/* Column Info */
	private String payUsdAmt = null;
	/* Column Info */
	private String stvDmgReqCateCd = null;
	/* Column Info */
	private String qttnCostUsdAmt = null;
	/* Column Info */
	private String dmgAuthStsCd = null;
	/* Column Info */
	private String stvDmgStlProcStsCd = null;
	/* Column Info */
	private String cmpnCostUsdAmt = null;
	/* Column Info */
	private String stvDmgRefNo = null;
	/* Column Info */
	private String stvDmgRprProcStsCd = null;
	/* Column Info */
	private String stvDmgTpCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String clmHndlOfcCd = null;
	/* Column Info */
	private String stvDmgEvntDt = null;
	/* Column Info */
	private String reqEtaDt = null;
	/* Column Info */
	private String stvDmgNo = null;
	/* Column Info */
	private String vslTypeCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SdmsOptionVO() {}

	public SdmsOptionVO(String ibflag, String pagerows, String stvDmgNo, String vvdCd, String vpsPortCd, String stvDmgEvntDt, String stvDmgTpCd, String elapseDay, String dmgAuthStsCd, String stvDmgReqCateCd, String stvDmgRprProcStsCd, String stvDmgCmpnProcStsCd, String stvDmgStlProcStsCd, String reqPortCd, String reqEtaDt, String qttnCostUsdAmt, String rprCostUsdAmt, String payUsdAmt, String clmHndlOfcCd, String slanCd, String stvDmgEvntDtFrom, String stvDmgEvntDtTo, String stvDmgRefNo, String vslTypeCd, String cmpnCostUsdAmt) {
		this.stvDmgEvntDtFrom = stvDmgEvntDtFrom;
		this.elapseDay = elapseDay;
		this.stvDmgEvntDtTo = stvDmgEvntDtTo;
		this.stvDmgCmpnProcStsCd = stvDmgCmpnProcStsCd;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.reqPortCd = reqPortCd;
		this.rprCostUsdAmt = rprCostUsdAmt;
		this.payUsdAmt = payUsdAmt;
		this.stvDmgReqCateCd = stvDmgReqCateCd;
		this.qttnCostUsdAmt = qttnCostUsdAmt;
		this.dmgAuthStsCd = dmgAuthStsCd;
		this.stvDmgStlProcStsCd = stvDmgStlProcStsCd;
		this.cmpnCostUsdAmt = cmpnCostUsdAmt;
		this.stvDmgRefNo = stvDmgRefNo;
		this.stvDmgRprProcStsCd = stvDmgRprProcStsCd;
		this.stvDmgTpCd = stvDmgTpCd;
		this.slanCd = slanCd;
		this.clmHndlOfcCd = clmHndlOfcCd;
		this.stvDmgEvntDt = stvDmgEvntDt;
		this.reqEtaDt = reqEtaDt;
		this.stvDmgNo = stvDmgNo;
		this.vslTypeCd = vslTypeCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("stv_dmg_evnt_dt_from", getStvDmgEvntDtFrom());
		this.hashColumns.put("elapse_day", getElapseDay());
		this.hashColumns.put("stv_dmg_evnt_dt_to", getStvDmgEvntDtTo());
		this.hashColumns.put("stv_dmg_cmpn_proc_sts_cd", getStvDmgCmpnProcStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("req_port_cd", getReqPortCd());
		this.hashColumns.put("rpr_cost_usd_amt", getRprCostUsdAmt());
		this.hashColumns.put("pay_usd_amt", getPayUsdAmt());
		this.hashColumns.put("stv_dmg_req_cate_cd", getStvDmgReqCateCd());
		this.hashColumns.put("qttn_cost_usd_amt", getQttnCostUsdAmt());
		this.hashColumns.put("dmg_auth_sts_cd", getDmgAuthStsCd());
		this.hashColumns.put("stv_dmg_stl_proc_sts_cd", getStvDmgStlProcStsCd());
		this.hashColumns.put("cmpn_cost_usd_amt", getCmpnCostUsdAmt());
		this.hashColumns.put("stv_dmg_ref_no", getStvDmgRefNo());
		this.hashColumns.put("stv_dmg_rpr_proc_sts_cd", getStvDmgRprProcStsCd());
		this.hashColumns.put("stv_dmg_tp_cd", getStvDmgTpCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("clm_hndl_ofc_cd", getClmHndlOfcCd());
		this.hashColumns.put("stv_dmg_evnt_dt", getStvDmgEvntDt());
		this.hashColumns.put("req_eta_dt", getReqEtaDt());
		this.hashColumns.put("stv_dmg_no", getStvDmgNo());
		this.hashColumns.put("vsl_type_cd", getVslTypeCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("stv_dmg_evnt_dt_from", "stvDmgEvntDtFrom");
		this.hashFields.put("elapse_day", "elapseDay");
		this.hashFields.put("stv_dmg_evnt_dt_to", "stvDmgEvntDtTo");
		this.hashFields.put("stv_dmg_cmpn_proc_sts_cd", "stvDmgCmpnProcStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("req_port_cd", "reqPortCd");
		this.hashFields.put("rpr_cost_usd_amt", "rprCostUsdAmt");
		this.hashFields.put("pay_usd_amt", "payUsdAmt");
		this.hashFields.put("stv_dmg_req_cate_cd", "stvDmgReqCateCd");
		this.hashFields.put("qttn_cost_usd_amt", "qttnCostUsdAmt");
		this.hashFields.put("dmg_auth_sts_cd", "dmgAuthStsCd");
		this.hashFields.put("stv_dmg_stl_proc_sts_cd", "stvDmgStlProcStsCd");
		this.hashFields.put("cmpn_cost_usd_amt", "cmpnCostUsdAmt");
		this.hashFields.put("stv_dmg_ref_no", "stvDmgRefNo");
		this.hashFields.put("stv_dmg_rpr_proc_sts_cd", "stvDmgRprProcStsCd");
		this.hashFields.put("stv_dmg_tp_cd", "stvDmgTpCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("clm_hndl_ofc_cd", "clmHndlOfcCd");
		this.hashFields.put("stv_dmg_evnt_dt", "stvDmgEvntDt");
		this.hashFields.put("req_eta_dt", "reqEtaDt");
		this.hashFields.put("stv_dmg_no", "stvDmgNo");
		this.hashFields.put("vsl_type_cd", "vslTypeCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stvDmgEvntDtFrom
	 */
	public String getStvDmgEvntDtFrom() {
		return this.stvDmgEvntDtFrom;
	}
	
	/**
	 * Column Info
	 * @return elapseDay
	 */
	public String getElapseDay() {
		return this.elapseDay;
	}
	
	/**
	 * Column Info
	 * @return stvDmgEvntDtTo
	 */
	public String getStvDmgEvntDtTo() {
		return this.stvDmgEvntDtTo;
	}
	
	/**
	 * Column Info
	 * @return stvDmgCmpnProcStsCd
	 */
	public String getStvDmgCmpnProcStsCd() {
		return this.stvDmgCmpnProcStsCd;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return reqPortCd
	 */
	public String getReqPortCd() {
		return this.reqPortCd;
	}
	
	/**
	 * Column Info
	 * @return rprCostUsdAmt
	 */
	public String getRprCostUsdAmt() {
		return this.rprCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return payUsdAmt
	 */
	public String getPayUsdAmt() {
		return this.payUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return stvDmgReqCateCd
	 */
	public String getStvDmgReqCateCd() {
		return this.stvDmgReqCateCd;
	}
	
	/**
	 * Column Info
	 * @return qttnCostUsdAmt
	 */
	public String getQttnCostUsdAmt() {
		return this.qttnCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return dmgAuthStsCd
	 */
	public String getDmgAuthStsCd() {
		return this.dmgAuthStsCd;
	}
	
	/**
	 * Column Info
	 * @return stvDmgStlProcStsCd
	 */
	public String getStvDmgStlProcStsCd() {
		return this.stvDmgStlProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return cmpnCostUsdAmt
	 */
	public String getCmpnCostUsdAmt() {
		return this.cmpnCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return stvDmgRefNo
	 */
	public String getStvDmgRefNo() {
		return this.stvDmgRefNo;
	}
	
	/**
	 * Column Info
	 * @return stvDmgRprProcStsCd
	 */
	public String getStvDmgRprProcStsCd() {
		return this.stvDmgRprProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return stvDmgTpCd
	 */
	public String getStvDmgTpCd() {
		return this.stvDmgTpCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return clmHndlOfcCd
	 */
	public String getClmHndlOfcCd() {
		return this.clmHndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return stvDmgEvntDt
	 */
	public String getStvDmgEvntDt() {
		return this.stvDmgEvntDt;
	}
	
	/**
	 * Column Info
	 * @return reqEtaDt
	 */
	public String getReqEtaDt() {
		return this.reqEtaDt;
	}
	
	/**
	 * Column Info
	 * @return stvDmgNo
	 */
	public String getStvDmgNo() {
		return this.stvDmgNo;
	}
	
	/**
	 * Column Info
	 * @return vslTypeCd
	 */
	public String getVslTypeCd() {
		return this.vslTypeCd;
	}
	

	/**
	 * Column Info
	 * @param stvDmgEvntDtFrom
	 */
	public void setStvDmgEvntDtFrom(String stvDmgEvntDtFrom) {
		this.stvDmgEvntDtFrom = stvDmgEvntDtFrom;
	}
	
	/**
	 * Column Info
	 * @param elapseDay
	 */
	public void setElapseDay(String elapseDay) {
		this.elapseDay = elapseDay;
	}
	
	/**
	 * Column Info
	 * @param stvDmgEvntDtTo
	 */
	public void setStvDmgEvntDtTo(String stvDmgEvntDtTo) {
		this.stvDmgEvntDtTo = stvDmgEvntDtTo;
	}
	
	/**
	 * Column Info
	 * @param stvDmgCmpnProcStsCd
	 */
	public void setStvDmgCmpnProcStsCd(String stvDmgCmpnProcStsCd) {
		this.stvDmgCmpnProcStsCd = stvDmgCmpnProcStsCd;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param reqPortCd
	 */
	public void setReqPortCd(String reqPortCd) {
		this.reqPortCd = reqPortCd;
	}
	
	/**
	 * Column Info
	 * @param rprCostUsdAmt
	 */
	public void setRprCostUsdAmt(String rprCostUsdAmt) {
		this.rprCostUsdAmt = rprCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param payUsdAmt
	 */
	public void setPayUsdAmt(String payUsdAmt) {
		this.payUsdAmt = payUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param stvDmgReqCateCd
	 */
	public void setStvDmgReqCateCd(String stvDmgReqCateCd) {
		this.stvDmgReqCateCd = stvDmgReqCateCd;
	}
	
	/**
	 * Column Info
	 * @param qttnCostUsdAmt
	 */
	public void setQttnCostUsdAmt(String qttnCostUsdAmt) {
		this.qttnCostUsdAmt = qttnCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param dmgAuthStsCd
	 */
	public void setDmgAuthStsCd(String dmgAuthStsCd) {
		this.dmgAuthStsCd = dmgAuthStsCd;
	}
	
	/**
	 * Column Info
	 * @param stvDmgStlProcStsCd
	 */
	public void setStvDmgStlProcStsCd(String stvDmgStlProcStsCd) {
		this.stvDmgStlProcStsCd = stvDmgStlProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param cmpnCostUsdAmt
	 */
	public void setCmpnCostUsdAmt(String cmpnCostUsdAmt) {
		this.cmpnCostUsdAmt = cmpnCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param stvDmgRefNo
	 */
	public void setStvDmgRefNo(String stvDmgRefNo) {
		this.stvDmgRefNo = stvDmgRefNo;
	}
	
	/**
	 * Column Info
	 * @param stvDmgRprProcStsCd
	 */
	public void setStvDmgRprProcStsCd(String stvDmgRprProcStsCd) {
		this.stvDmgRprProcStsCd = stvDmgRprProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param stvDmgTpCd
	 */
	public void setStvDmgTpCd(String stvDmgTpCd) {
		this.stvDmgTpCd = stvDmgTpCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param clmHndlOfcCd
	 */
	public void setClmHndlOfcCd(String clmHndlOfcCd) {
		this.clmHndlOfcCd = clmHndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param stvDmgEvntDt
	 */
	public void setStvDmgEvntDt(String stvDmgEvntDt) {
		this.stvDmgEvntDt = stvDmgEvntDt;
	}
	
	/**
	 * Column Info
	 * @param reqEtaDt
	 */
	public void setReqEtaDt(String reqEtaDt) {
		this.reqEtaDt = reqEtaDt;
	}
	
	/**
	 * Column Info
	 * @param stvDmgNo
	 */
	public void setStvDmgNo(String stvDmgNo) {
		this.stvDmgNo = stvDmgNo;
	}
	
	/**
	 * Column Info
	 * @param vslTypeCd
	 */
	public void setVslTypeCd(String vslTypeCd) {
		this.vslTypeCd = vslTypeCd;
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
		setStvDmgEvntDtFrom(JSPUtil.getParameter(request, prefix + "stv_dmg_evnt_dt_from", ""));
		setElapseDay(JSPUtil.getParameter(request, prefix + "elapse_day", ""));
		setStvDmgEvntDtTo(JSPUtil.getParameter(request, prefix + "stv_dmg_evnt_dt_to", ""));
		setStvDmgCmpnProcStsCd(JSPUtil.getParameter(request, prefix + "stv_dmg_cmpn_proc_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setReqPortCd(JSPUtil.getParameter(request, prefix + "req_port_cd", ""));
		setRprCostUsdAmt(JSPUtil.getParameter(request, prefix + "rpr_cost_usd_amt", ""));
		setPayUsdAmt(JSPUtil.getParameter(request, prefix + "pay_usd_amt", ""));
		setStvDmgReqCateCd(JSPUtil.getParameter(request, prefix + "stv_dmg_req_cate_cd", ""));
		setQttnCostUsdAmt(JSPUtil.getParameter(request, prefix + "qttn_cost_usd_amt", ""));
		setDmgAuthStsCd(JSPUtil.getParameter(request, prefix + "dmg_auth_sts_cd", ""));
		setStvDmgStlProcStsCd(JSPUtil.getParameter(request, prefix + "stv_dmg_stl_proc_sts_cd", ""));
		setCmpnCostUsdAmt(JSPUtil.getParameter(request, prefix + "cmpn_cost_usd_amt", ""));
		setStvDmgRefNo(JSPUtil.getParameter(request, prefix + "stv_dmg_ref_no", ""));
		setStvDmgRprProcStsCd(JSPUtil.getParameter(request, prefix + "stv_dmg_rpr_proc_sts_cd", ""));
		setStvDmgTpCd(JSPUtil.getParameter(request, prefix + "stv_dmg_tp_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setClmHndlOfcCd(JSPUtil.getParameter(request, prefix + "clm_hndl_ofc_cd", ""));
		setStvDmgEvntDt(JSPUtil.getParameter(request, prefix + "stv_dmg_evnt_dt", ""));
		setReqEtaDt(JSPUtil.getParameter(request, prefix + "req_eta_dt", ""));
		setStvDmgNo(JSPUtil.getParameter(request, prefix + "stv_dmg_no", ""));
		setVslTypeCd(JSPUtil.getParameter(request, prefix + "vsl_type_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SdmsOptionVO[]
	 */
	public SdmsOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SdmsOptionVO[]
	 */
	public SdmsOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SdmsOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stvDmgEvntDtFrom = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_evnt_dt_from", length));
			String[] elapseDay = (JSPUtil.getParameter(request, prefix	+ "elapse_day", length));
			String[] stvDmgEvntDtTo = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_evnt_dt_to", length));
			String[] stvDmgCmpnProcStsCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_cmpn_proc_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] reqPortCd = (JSPUtil.getParameter(request, prefix	+ "req_port_cd", length));
			String[] rprCostUsdAmt = (JSPUtil.getParameter(request, prefix	+ "rpr_cost_usd_amt", length));
			String[] payUsdAmt = (JSPUtil.getParameter(request, prefix	+ "pay_usd_amt", length));
			String[] stvDmgReqCateCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_req_cate_cd", length));
			String[] qttnCostUsdAmt = (JSPUtil.getParameter(request, prefix	+ "qttn_cost_usd_amt", length));
			String[] dmgAuthStsCd = (JSPUtil.getParameter(request, prefix	+ "dmg_auth_sts_cd", length));
			String[] stvDmgStlProcStsCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_stl_proc_sts_cd", length));
			String[] cmpnCostUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cmpn_cost_usd_amt", length));
			String[] stvDmgRefNo = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_ref_no", length));
			String[] stvDmgRprProcStsCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_rpr_proc_sts_cd", length));
			String[] stvDmgTpCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_tp_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] clmHndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "clm_hndl_ofc_cd", length));
			String[] stvDmgEvntDt = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_evnt_dt", length));
			String[] reqEtaDt = (JSPUtil.getParameter(request, prefix	+ "req_eta_dt", length));
			String[] stvDmgNo = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_no", length));
			String[] vslTypeCd = (JSPUtil.getParameter(request, prefix	+ "vsl_type_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SdmsOptionVO();
				if (stvDmgEvntDtFrom[i] != null)
					model.setStvDmgEvntDtFrom(stvDmgEvntDtFrom[i]);
				if (elapseDay[i] != null)
					model.setElapseDay(elapseDay[i]);
				if (stvDmgEvntDtTo[i] != null)
					model.setStvDmgEvntDtTo(stvDmgEvntDtTo[i]);
				if (stvDmgCmpnProcStsCd[i] != null)
					model.setStvDmgCmpnProcStsCd(stvDmgCmpnProcStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (reqPortCd[i] != null)
					model.setReqPortCd(reqPortCd[i]);
				if (rprCostUsdAmt[i] != null)
					model.setRprCostUsdAmt(rprCostUsdAmt[i]);
				if (payUsdAmt[i] != null)
					model.setPayUsdAmt(payUsdAmt[i]);
				if (stvDmgReqCateCd[i] != null)
					model.setStvDmgReqCateCd(stvDmgReqCateCd[i]);
				if (qttnCostUsdAmt[i] != null)
					model.setQttnCostUsdAmt(qttnCostUsdAmt[i]);
				if (dmgAuthStsCd[i] != null)
					model.setDmgAuthStsCd(dmgAuthStsCd[i]);
				if (stvDmgStlProcStsCd[i] != null)
					model.setStvDmgStlProcStsCd(stvDmgStlProcStsCd[i]);
				if (cmpnCostUsdAmt[i] != null)
					model.setCmpnCostUsdAmt(cmpnCostUsdAmt[i]);
				if (stvDmgRefNo[i] != null)
					model.setStvDmgRefNo(stvDmgRefNo[i]);
				if (stvDmgRprProcStsCd[i] != null)
					model.setStvDmgRprProcStsCd(stvDmgRprProcStsCd[i]);
				if (stvDmgTpCd[i] != null)
					model.setStvDmgTpCd(stvDmgTpCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (clmHndlOfcCd[i] != null)
					model.setClmHndlOfcCd(clmHndlOfcCd[i]);
				if (stvDmgEvntDt[i] != null)
					model.setStvDmgEvntDt(stvDmgEvntDt[i]);
				if (reqEtaDt[i] != null)
					model.setReqEtaDt(reqEtaDt[i]);
				if (stvDmgNo[i] != null)
					model.setStvDmgNo(stvDmgNo[i]);
				if (vslTypeCd[i] != null)
					model.setVslTypeCd(vslTypeCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSdmsOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SdmsOptionVO[]
	 */
	public SdmsOptionVO[] getSdmsOptionVOs(){
		SdmsOptionVO[] vos = (SdmsOptionVO[])models.toArray(new SdmsOptionVO[models.size()]);
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
		this.stvDmgEvntDtFrom = this.stvDmgEvntDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elapseDay = this.elapseDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgEvntDtTo = this.stvDmgEvntDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgCmpnProcStsCd = this.stvDmgCmpnProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqPortCd = this.reqPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprCostUsdAmt = this.rprCostUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payUsdAmt = this.payUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgReqCateCd = this.stvDmgReqCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnCostUsdAmt = this.qttnCostUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgAuthStsCd = this.dmgAuthStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgStlProcStsCd = this.stvDmgStlProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnCostUsdAmt = this.cmpnCostUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgRefNo = this.stvDmgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgRprProcStsCd = this.stvDmgRprProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgTpCd = this.stvDmgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmHndlOfcCd = this.clmHndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgEvntDt = this.stvDmgEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqEtaDt = this.reqEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgNo = this.stvDmgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTypeCd = this.vslTypeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
