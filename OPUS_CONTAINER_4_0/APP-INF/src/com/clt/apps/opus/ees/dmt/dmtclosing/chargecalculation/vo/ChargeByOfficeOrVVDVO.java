/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeByOfficeOrVVDVO.java
*@FileTitle : ChargeByOfficeOrVVDVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.04.14 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeByOfficeOrVVDVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeByOfficeOrVVDVO> models = new ArrayList<ChargeByOfficeOrVVDVO>();
	
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String condType = null;
	/* Column Info */
	private String fxFtOvrDys = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String dmdtChgStsCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String inclInv = null;
	/* Column Info */
	private String demType = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String usrRhqOfcCd = null;
	/* Column Info */
	private String toMvmtDt = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String custType = null;
	/* Column Info */
	private String fmMvmtYdCd = null;
	/* Column Info */
	private String chgType = null;
	/* Column Info */
	private String bypodeta = null;
	/* Column Info */
	private String cs = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String svcProvdr = null;
	/* Column Info */
	private String webMt = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String toMvmtYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChargeByOfficeOrVVDVO() {}

	public ChargeByOfficeOrVVDVO(String ibflag, String pagerows, String ofcCd, String usrRhqOfcCd, String dmdtTrfCd, String dmdtChgStsCd, String chgSeq, String chgType, String fxFtOvrDys, String fmMvmtDt, String toMvmtDt, String fmMvmtYdCd, String toMvmtYdCd, String vvdCd, String polCd, String podCd, String demType, String bkgNo, String blNo, String cntrNo, String custType, String custCd, String svcProvdr, String scNo, String rfaNo, String condType, String bypodeta, String cs, String webMt, String inclInv) {
		this.chgSeq = chgSeq;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.condType = condType;
		this.fxFtOvrDys = fxFtOvrDys;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.dmdtChgStsCd = dmdtChgStsCd;
		this.vvdCd = vvdCd;
		this.inclInv = inclInv;
		this.demType = demType;
		this.scNo = scNo;
		this.usrRhqOfcCd = usrRhqOfcCd;
		this.toMvmtDt = toMvmtDt;
		this.dmdtTrfCd = dmdtTrfCd;
		this.custType = custType;
		this.fmMvmtYdCd = fmMvmtYdCd;
		this.chgType = chgType;
		this.bypodeta = bypodeta;
		this.cs = cs;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.custCd = custCd;
		this.svcProvdr = svcProvdr;
		this.webMt = webMt;
		this.fmMvmtDt = fmMvmtDt;
		this.toMvmtYdCd = toMvmtYdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cond_type", getCondType());
		this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("incl_inv", getInclInv());
		this.hashColumns.put("dem_type", getDemType());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("usr_rhq_ofc_cd", getUsrRhqOfcCd());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("cust_type", getCustType());
		this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
		this.hashColumns.put("chg_type", getChgType());
		this.hashColumns.put("bypodeta", getBypodeta());
		this.hashColumns.put("cs", getCs());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("svc_provdr", getSvcProvdr());
		this.hashColumns.put("web_mt", getWebMt());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("to_mvmt_yd_cd", getToMvmtYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cond_type", "condType");
		this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("incl_inv", "inclInv");
		this.hashFields.put("dem_type", "demType");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("usr_rhq_ofc_cd", "usrRhqOfcCd");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("cust_type", "custType");
		this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
		this.hashFields.put("chg_type", "chgType");
		this.hashFields.put("bypodeta", "bypodeta");
		this.hashFields.put("cs", "cs");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("svc_provdr", "svcProvdr");
		this.hashFields.put("web_mt", "webMt");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("to_mvmt_yd_cd", "toMvmtYdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return condType
	 */
	public String getCondType() {
		return this.condType;
	}
	
	/**
	 * Column Info
	 * @return fxFtOvrDys
	 */
	public String getFxFtOvrDys() {
		return this.fxFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgStsCd
	 */
	public String getDmdtChgStsCd() {
		return this.dmdtChgStsCd;
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
	 * @return inclInv
	 */
	public String getInclInv() {
		return this.inclInv;
	}
	
	/**
	 * Column Info
	 * @return demType
	 */
	public String getDemType() {
		return this.demType;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return usrRhqOfcCd
	 */
	public String getUsrRhqOfcCd() {
		return this.usrRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return toMvmtDt
	 */
	public String getToMvmtDt() {
		return this.toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return custType
	 */
	public String getCustType() {
		return this.custType;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtYdCd
	 */
	public String getFmMvmtYdCd() {
		return this.fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return chgType
	 */
	public String getChgType() {
		return this.chgType;
	}
	
	/**
	 * Column Info
	 * @return bypodeta
	 */
	public String getBypodeta() {
		return this.bypodeta;
	}
	
	/**
	 * Column Info
	 * @return cs
	 */
	public String getCs() {
		return this.cs;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return svcProvdr
	 */
	public String getSvcProvdr() {
		return this.svcProvdr;
	}
	
	/**
	 * Column Info
	 * @return webMt
	 */
	public String getWebMt() {
		return this.webMt;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtDt
	 */
	public String getFmMvmtDt() {
		return this.fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return toMvmtYdCd
	 */
	public String getToMvmtYdCd() {
		return this.toMvmtYdCd;
	}
	

	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param condType
	 */
	public void setCondType(String condType) {
		this.condType = condType;
	}
	
	/**
	 * Column Info
	 * @param fxFtOvrDys
	 */
	public void setFxFtOvrDys(String fxFtOvrDys) {
		this.fxFtOvrDys = fxFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgStsCd
	 */
	public void setDmdtChgStsCd(String dmdtChgStsCd) {
		this.dmdtChgStsCd = dmdtChgStsCd;
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
	 * @param inclInv
	 */
	public void setInclInv(String inclInv) {
		this.inclInv = inclInv;
	}
	
	/**
	 * Column Info
	 * @param demType
	 */
	public void setDemType(String demType) {
		this.demType = demType;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param usrRhqOfcCd
	 */
	public void setUsrRhqOfcCd(String usrRhqOfcCd) {
		this.usrRhqOfcCd = usrRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param toMvmtDt
	 */
	public void setToMvmtDt(String toMvmtDt) {
		this.toMvmtDt = toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtYdCd
	 */
	public void setFmMvmtYdCd(String fmMvmtYdCd) {
		this.fmMvmtYdCd = fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @param chgType
	 */
	public void setChgType(String chgType) {
		this.chgType = chgType;
	}
	
	/**
	 * Column Info
	 * @param bypodeta
	 */
	public void setBypodeta(String bypodeta) {
		this.bypodeta = bypodeta;
	}
	
	/**
	 * Column Info
	 * @param cs
	 */
	public void setCs(String cs) {
		this.cs = cs;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param svcProvdr
	 */
	public void setSvcProvdr(String svcProvdr) {
		this.svcProvdr = svcProvdr;
	}
	
	/**
	 * Column Info
	 * @param webMt
	 */
	public void setWebMt(String webMt) {
		this.webMt = webMt;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtDt
	 */
	public void setFmMvmtDt(String fmMvmtDt) {
		this.fmMvmtDt = fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param toMvmtYdCd
	 */
	public void setToMvmtYdCd(String toMvmtYdCd) {
		this.toMvmtYdCd = toMvmtYdCd;
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
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCondType(JSPUtil.getParameter(request, prefix + "cond_type", ""));
		setFxFtOvrDys(JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_sts_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setInclInv(JSPUtil.getParameter(request, prefix + "incl_inv", ""));
		setDemType(JSPUtil.getParameter(request, prefix + "dem_type", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setUsrRhqOfcCd(JSPUtil.getParameter(request, prefix + "usr_rhq_ofc_cd", ""));
		setToMvmtDt(JSPUtil.getParameter(request, prefix + "to_mvmt_dt", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setCustType(JSPUtil.getParameter(request, prefix + "cust_type", ""));
		setFmMvmtYdCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", ""));
		setChgType(JSPUtil.getParameter(request, prefix + "chg_type", ""));
		setBypodeta(JSPUtil.getParameter(request, prefix + "bypodeta", ""));
		setCs(JSPUtil.getParameter(request, prefix + "cs", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setSvcProvdr(JSPUtil.getParameter(request, prefix + "svc_provdr", ""));
		setWebMt(JSPUtil.getParameter(request, prefix + "web_mt", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", ""));
		setToMvmtYdCd(JSPUtil.getParameter(request, prefix + "to_mvmt_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeByOfficeOrVVDVO[]
	 */
	public ChargeByOfficeOrVVDVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeByOfficeOrVVDVO[]
	 */
	public ChargeByOfficeOrVVDVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeByOfficeOrVVDVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] condType = (JSPUtil.getParameter(request, prefix	+ "cond_type", length));
			String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "fx_ft_ovr_dys", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] inclInv = (JSPUtil.getParameter(request, prefix	+ "incl_inv", length));
			String[] demType = (JSPUtil.getParameter(request, prefix	+ "dem_type", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] usrRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_rhq_ofc_cd", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] custType = (JSPUtil.getParameter(request, prefix	+ "cust_type", length));
			String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yd_cd", length));
			String[] chgType = (JSPUtil.getParameter(request, prefix	+ "chg_type", length));
			String[] bypodeta = (JSPUtil.getParameter(request, prefix	+ "bypodeta", length));
			String[] cs = (JSPUtil.getParameter(request, prefix	+ "cs", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] svcProvdr = (JSPUtil.getParameter(request, prefix	+ "svc_provdr", length));
			String[] webMt = (JSPUtil.getParameter(request, prefix	+ "web_mt", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] toMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeByOfficeOrVVDVO();
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (condType[i] != null)
					model.setCondType(condType[i]);
				if (fxFtOvrDys[i] != null)
					model.setFxFtOvrDys(fxFtOvrDys[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (dmdtChgStsCd[i] != null)
					model.setDmdtChgStsCd(dmdtChgStsCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (inclInv[i] != null)
					model.setInclInv(inclInv[i]);
				if (demType[i] != null)
					model.setDemType(demType[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (usrRhqOfcCd[i] != null)
					model.setUsrRhqOfcCd(usrRhqOfcCd[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (custType[i] != null)
					model.setCustType(custType[i]);
				if (fmMvmtYdCd[i] != null)
					model.setFmMvmtYdCd(fmMvmtYdCd[i]);
				if (chgType[i] != null)
					model.setChgType(chgType[i]);
				if (bypodeta[i] != null)
					model.setBypodeta(bypodeta[i]);
				if (cs[i] != null)
					model.setCs(cs[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (svcProvdr[i] != null)
					model.setSvcProvdr(svcProvdr[i]);
				if (webMt[i] != null)
					model.setWebMt(webMt[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (toMvmtYdCd[i] != null)
					model.setToMvmtYdCd(toMvmtYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeByOfficeOrVVDVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeByOfficeOrVVDVO[]
	 */
	public ChargeByOfficeOrVVDVO[] getChargeByOfficeOrVVDVOs(){
		ChargeByOfficeOrVVDVO[] vos = (ChargeByOfficeOrVVDVO[])models.toArray(new ChargeByOfficeOrVVDVO[models.size()]);
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
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condType = this.condType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxFtOvrDys = this.fxFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclInv = this.inclInv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demType = this.demType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRhqOfcCd = this.usrRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custType = this.custType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYdCd = this.fmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgType = this.chgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bypodeta = this.bypodeta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cs = this.cs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcProvdr = this.svcProvdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webMt = this.webMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtYdCd = this.toMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
