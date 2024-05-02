/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChargeByOfficeOrVVDVO.java
*@FileTitle : ChargeByOfficeOrVVDVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeByOfficeOrVVDVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeByOfficeOrVVDVO> models = new ArrayList<ChargeByOfficeOrVVDVO>();
	
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fxFtOvrDys = null;
	/* Column Info */
	private String condType = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmdtChgStsCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String inclInv = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String demType = null;
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
	private String toMvmtStsCd = null;
	/* Column Info */
	private String bypodeta = null;
	/* Column Info */
	private String fmMvmtStsCd = null;
	/* Column Info */
	private String dmdtCntrTpCd = null;
	/* Column Info */
	private String cs = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String svcProvdr = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String webMt = null;
	/* Column Info */
	private String dmdtBkgCgoTpCd = null;
	/* Column Info */
	private String bkgDeTermCd = null;
	/* Column Info */
	private String toMvmtYdCd = null;
	/* Column Info */
	private String opBkgNo = null;
	/* Column Info */
	private String ofcTrnsRhqCngFlg = null;
	/* Column Info */
	private String optDate = null;
	/* Column Info */
	private String optItemList = null;
	/* Column Info */
	private String orgGubunCd = null;
	/* Column Info */
	private String destGubunCd = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String fmBzcTrfAplyDt = null;
	/* Column Info */
	private String toBzcTrfAplyDt = null;
	/* Column Info */
	private String fmLocCd = null;
	/* Column Info */
	private String toLocCd = null;
	/* Column Info */
	private String uclmFlg = null;
	/* Column Info */
	private String dmdtArIfCd = null;
	/* Column Info */
	private String ovrDue = null;
	/* Column Info */
	private String usOfcYn = null;
	/* Column Info */
	private String inactStsCd = null;
	/* Column Info */
	private String inactNo = null;
	/* Column Info */
	private String aftDarStsCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChargeByOfficeOrVVDVO() {}

	public ChargeByOfficeOrVVDVO(String ibflag, String pagerows, String chgSeq, String blNo, String condType, String fxFtOvrDys, String rfaNo, String polCd, String dmdtChgStsCd, String vvdCd, String inclInv, String demType, String scNo, String usrRhqOfcCd, String toMvmtDt, String dmdtTrfCd, String custType, String fmMvmtYdCd, String chgType, String bypodeta, String cs, String podCd, String ofcCd, String bkgNo, String cntrNo, String custCd, String svcProvdr, String webMt, String fmMvmtDt, String toMvmtYdCd, String dmdtCntrTpCd, String dmdtBkgCgoTpCd, String bkgRcvTermCd, String bkgDeTermCd, String fmMvmtStsCd, String toMvmtStsCd, String opBkgNo, String ofcTrnsRhqCngFlg, String optDate,String optItemList,String orgGubunCd,String destGubunCd,String costYrmon,String fmBzcTrfAplyDt, String toBzcTrfAplyDt, String fmLocCd, String toLocCd, String uclmFlg, String dmdtArIfCd, String ovrDue, String usOfcYn, String inactStsCd, String inactNo, String aftDarStsCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.chgSeq = chgSeq;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.fxFtOvrDys = fxFtOvrDys;
		this.condType = condType;
		this.rfaNo = rfaNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.dmdtChgStsCd = dmdtChgStsCd;
		this.vvdCd = vvdCd;
		this.inclInv = inclInv;
		this.scNo = scNo;
		this.demType = demType;
		this.usrRhqOfcCd = usrRhqOfcCd;
		this.toMvmtDt = toMvmtDt;
		this.dmdtTrfCd = dmdtTrfCd;
		this.custType = custType;
		this.fmMvmtYdCd = fmMvmtYdCd;
		this.chgType = chgType;
		this.toMvmtStsCd = toMvmtStsCd;
		this.bypodeta = bypodeta;
		this.fmMvmtStsCd = fmMvmtStsCd;
		this.dmdtCntrTpCd = dmdtCntrTpCd;
		this.cs = cs;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.custCd = custCd;
		this.cntrNo = cntrNo;
		this.svcProvdr = svcProvdr;
		this.fmMvmtDt = fmMvmtDt;
		this.webMt = webMt;
		this.dmdtBkgCgoTpCd = dmdtBkgCgoTpCd;
		this.bkgDeTermCd = bkgDeTermCd;
		this.toMvmtYdCd = toMvmtYdCd;
		this.opBkgNo = opBkgNo;
		this.ofcTrnsRhqCngFlg = ofcTrnsRhqCngFlg;
		this.optDate = optDate;
		this.optItemList = optItemList;
		this.orgGubunCd = orgGubunCd;
		this.destGubunCd = destGubunCd;
		this.costYrmon = costYrmon;
		this.fmBzcTrfAplyDt = fmBzcTrfAplyDt;
		this.toBzcTrfAplyDt = toBzcTrfAplyDt;
		this.fmLocCd = fmLocCd;
		this.toLocCd = toLocCd;
		this.uclmFlg = uclmFlg;
		this.dmdtArIfCd = dmdtArIfCd;
		this.ovrDue = ovrDue;
		this.usOfcYn = usOfcYn;
		this.inactStsCd = inactStsCd;
		this.inactNo = inactNo;
		this.aftDarStsCd = aftDarStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
		this.hashColumns.put("cond_type", getCondType());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("incl_inv", getInclInv());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("dem_type", getDemType());
		this.hashColumns.put("usr_rhq_ofc_cd", getUsrRhqOfcCd());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("cust_type", getCustType());
		this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
		this.hashColumns.put("chg_type", getChgType());
		this.hashColumns.put("to_mvmt_sts_cd", getToMvmtStsCd());
		this.hashColumns.put("bypodeta", getBypodeta());
		this.hashColumns.put("fm_mvmt_sts_cd", getFmMvmtStsCd());
		this.hashColumns.put("dmdt_cntr_tp_cd", getDmdtCntrTpCd());
		this.hashColumns.put("cs", getCs());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("svc_provdr", getSvcProvdr());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("web_mt", getWebMt());
		this.hashColumns.put("dmdt_bkg_cgo_tp_cd", getDmdtBkgCgoTpCd());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		this.hashColumns.put("to_mvmt_yd_cd", getToMvmtYdCd());
		this.hashColumns.put("op_bkg_no", getOpBkgNo());
		this.hashColumns.put("ofc_trns_rhq_cng_flg", getOfcTrnsRhqCngFlg());
		this.hashColumns.put("opt_date", getOptDate());
		this.hashColumns.put("opt_item_list", getOptItemList());
		this.hashColumns.put("org_gubun_cd", getOrgGubunCd());
		this.hashColumns.put("dest_gubun_cd", getDestGubunCd());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("fm_bzc_trf_aply_dt", getFmBzcTrfAplyDt());
		this.hashColumns.put("to_bzc_trf_aply_dt", getToBzcTrfAplyDt());
		this.hashColumns.put("fm_loc_cd", getFmLocCd());
		this.hashColumns.put("to_loc_cd", getToLocCd());
		this.hashColumns.put("uclm_flg", getUclmFlg());
		this.hashColumns.put("dmdt_ar_if_cd", getDmdtArIfCd());
		this.hashColumns.put("ovr_due", getOvrDue());
		this.hashColumns.put("us_ofc_yn", getUsOfcYn());
		this.hashColumns.put("inact_sts_cd", getInactStsCd());
		this.hashColumns.put("inact_no", getInactNo());
		this.hashColumns.put("aft_dar_sts_cd", getAftDarStsCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
		this.hashFields.put("cond_type", "condType");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("incl_inv", "inclInv");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("dem_type", "demType");
		this.hashFields.put("usr_rhq_ofc_cd", "usrRhqOfcCd");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("cust_type", "custType");
		this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
		this.hashFields.put("chg_type", "chgType");
		this.hashFields.put("to_mvmt_sts_cd", "toMvmtStsCd");
		this.hashFields.put("bypodeta", "bypodeta");
		this.hashFields.put("fm_mvmt_sts_cd", "fmMvmtStsCd");
		this.hashFields.put("dmdt_cntr_tp_cd", "dmdtCntrTpCd");
		this.hashFields.put("cs", "cs");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("svc_provdr", "svcProvdr");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("web_mt", "webMt");
		this.hashFields.put("dmdt_bkg_cgo_tp_cd", "dmdtBkgCgoTpCd");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		this.hashFields.put("to_mvmt_yd_cd", "toMvmtYdCd");
		this.hashFields.put("op_bkg_no", "opBkgNo");
		this.hashFields.put("ofc_trns_rhq_cng_flg", "ofcTrnsRhqCngFlg");
		this.hashFields.put("opt_date", "optDate");
		this.hashFields.put("opt_item_list", "optItemList");
		this.hashFields.put("org_gubun_cd", "orgGubunCd");
		this.hashFields.put("dest_gubun_cd", "destGubunCd");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("fm_bzc_trf_aply_dt", "fmBzcTrfAplyDt");
		this.hashFields.put("to_bzc_trf_aply_dt", "toBzcTrfAplyDt");
		this.hashFields.put("fm_loc_cd", "fmLocCd");
		this.hashFields.put("to_loc_cd", "toLocCd");
		this.hashFields.put("uclm_flg", "uclmFlg");
		this.hashFields.put("dmdt_ar_if_cd", "dmdtArIfCd");
		this.hashFields.put("ovr_due", "ovrDue");
		this.hashFields.put("us_ofc_yn", "usOfcYn");
		this.hashFields.put("inact_sts_cd", "inactStsCd");
		this.hashFields.put("inact_no", "inactNo");
		this.hashFields.put("aft_dar_sts_cd", "aftDarStsCd");
		
		return this.hashFields;
	}
	
	
	
	public String getAftDarStsCd() {
		return aftDarStsCd;
	}

	public void setAftDarStsCd(String aftDarStsCd) {
		this.aftDarStsCd = aftDarStsCd;
	}

	/**
	 * Column Info
	 * @return bkgRcvTermCd
	 */
	public String getBkgRcvTermCd() {
		return this.bkgRcvTermCd;
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
	 * @return fxFtOvrDys
	 */
	public String getFxFtOvrDys() {
		return this.fxFtOvrDys;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return toMvmtStsCd
	 */
	public String getToMvmtStsCd() {
		return this.toMvmtStsCd;
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
	 * @return fmMvmtStsCd
	 */
	public String getFmMvmtStsCd() {
		return this.fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpCd
	 */
	public String getDmdtCntrTpCd() {
		return this.dmdtCntrTpCd;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
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
	 * @return svcProvdr
	 */
	public String getSvcProvdr() {
		return this.svcProvdr;
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
	 * @return webMt
	 */
	public String getWebMt() {
		return this.webMt;
	}
	
	/**
	 * Column Info
	 * @return dmdtBkgCgoTpCd
	 */
	public String getDmdtBkgCgoTpCd() {
		return this.dmdtBkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDeTermCd
	 */
	public String getBkgDeTermCd() {
		return this.bkgDeTermCd;
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
	 * @return opBkgNo
	 */
	public String getOpBkgNo() {
		return this.opBkgNo;
	}
	
	/**
	 * Column Info
	 * @return ofcTrnsRhqCngFlg
	 */
	public String getOfcTrnsRhqCngFlg() {
		return this.ofcTrnsRhqCngFlg;
	}
	
	/**
	 * Column Info
	 * @return optDate
	 */
	public String getOptDate() {
		return this.optDate;
	}

	/**
	 * Column Info
	 * @return optItemList
	 */
	public String getOptItemList() {
		return this.optItemList;
	}
	
	/**
	 * Column Info
	 * @return orgGubunCd
	 */
	public String getOrgGubunCd() {
		return this.orgGubunCd;
	}
	
	/**
	 * Column Info
	 * @return destGubunCd
	 */
	public String getDestGubunCd() {
		return this.destGubunCd;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return fmBzcTrfAplyDt
	 */
	public String getFmBzcTrfAplyDt() {
		return this.fmBzcTrfAplyDt;
	}
	
	/**
	 * Column Info
	 * @return toBzcTrfAplyDt
	 */
	public String getToBzcTrfAplyDt() {
		return this.toBzcTrfAplyDt;
	}
	
	/**
	 * Column Info
	 * @return fmLocCd
	 */
	public String getFmLocCd() {
		return this.fmLocCd;
	}
	
	/**
	 * Column Info
	 * @return toLocCd
	 */
	public String getToLocCd() {
		return this.toLocCd;
	}
	
	/**
	 * Column Info
	 * @return uclmFlg
	 */
	public String getUclmFlg() {
		return this.uclmFlg;
	}
	
	/**
	 * Column Info
	 * @return dmdtArIfCd
	 */
	public String getDmdtArIfCd() {
		return this.dmdtArIfCd;
	}
	
	/**
	 * Column Info
	 * @return ovrDue
	 */
	public String getOvrDue() {
		return this.ovrDue;
	}
	
	/**
	 * Column Info
	 * @return usOfcYn
	 */
	public String getUsOfcYn() {
		return this.usOfcYn;
	}	
	
	/**
	 * Column Info
	 * @param bkgRcvTermCd
	 */
	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
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
	 * @param fxFtOvrDys
	 */
	public void setFxFtOvrDys(String fxFtOvrDys) {
		this.fxFtOvrDys = fxFtOvrDys;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param toMvmtStsCd
	 */
	public void setToMvmtStsCd(String toMvmtStsCd) {
		this.toMvmtStsCd = toMvmtStsCd;
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
	 * @param fmMvmtStsCd
	 */
	public void setFmMvmtStsCd(String fmMvmtStsCd) {
		this.fmMvmtStsCd = fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpCd
	 */
	public void setDmdtCntrTpCd(String dmdtCntrTpCd) {
		this.dmdtCntrTpCd = dmdtCntrTpCd;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
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
	 * @param svcProvdr
	 */
	public void setSvcProvdr(String svcProvdr) {
		this.svcProvdr = svcProvdr;
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
	 * @param webMt
	 */
	public void setWebMt(String webMt) {
		this.webMt = webMt;
	}
	
	/**
	 * Column Info
	 * @param dmdtBkgCgoTpCd
	 */
	public void setDmdtBkgCgoTpCd(String dmdtBkgCgoTpCd) {
		this.dmdtBkgCgoTpCd = dmdtBkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDeTermCd
	 */
	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param toMvmtYdCd
	 */
	public void setToMvmtYdCd(String toMvmtYdCd) {
		this.toMvmtYdCd = toMvmtYdCd;
	}

	/**
	 * Column Info
	 * @param opBkgNo
	 */
	public void setOpBkgNo(String opBkgNo) {
		this.opBkgNo = opBkgNo;
	}

	/**
	 * Column Info
	 * @param ofcTrnsRhqCngFlg
	 */
	public void setOfcTrnsRhqCngFlg(String ofcTrnsRhqCngFlg) {
		this.ofcTrnsRhqCngFlg = ofcTrnsRhqCngFlg;
	}
	
	/**
	 * Column Info
	 * @param optDate
	 */
	public void setOptDate(String optDate) {
		this.optDate = optDate;
	}

	/**
	 * Column Info
	 * @param optItemList
	 */
	public void setOptItemList(String optItemList) {
		this.optItemList = optItemList;
	}

	/**
	 * Column Info
	 * @param orgGubunCd
	 */
	public void setOrgGubunCd(String orgGubunCd) {
		this.orgGubunCd = orgGubunCd;
	}

	/**
	 * Column Info
	 * @param destGubunCd
	 */
	public void setDestGubunCd(String destGubunCd) {
		this.destGubunCd = destGubunCd;
	}

	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}

	/**
	 * Column Info
	 * @param fmBzcTrfAplyDt
	 */
	public void setFmBzcTrfAplyDt(String fmBzcTrfAplyDt) {
		this.fmBzcTrfAplyDt = fmBzcTrfAplyDt;
	}

	/**
	 * Column Info
	 * @param toBzcTrfAplyDt
	 */
	public void setToBzcTrfAplyDt(String toBzcTrfAplyDt) {
		this.toBzcTrfAplyDt = toBzcTrfAplyDt;
	}


	/**
	 * Column Info
	 * @param fmLocCd
	 */
	public void setFmLocCd(String fmLocCd) {
		this.fmLocCd = fmLocCd;
	}

	/**
	 * Column Info
	 * @param toLocCd
	 */
	public void setToLocCd(String toLocCd) {
		this.toLocCd = toLocCd;
	}
	
	/**
	 * Column Info
	 * @return uclmFlg
	 */	
	public void setUclmFlg(String uclmFlg) {
		this.uclmFlg = uclmFlg;
	}
	
	/**
	 * Column Info
	 * @return dmdtArIfCd
	 */	
	public void setDmdtArIfCd(String dmdtArIfCd) {
		this.dmdtArIfCd = dmdtArIfCd;
	}
	
	/**
	 * Column Info
	 * @return ovrDue
	 */	
	public void setOvrDue(String ovrDue) {
		this.ovrDue = ovrDue;
	}
	
	/**
	 * Column Info
	 * @param usOfcYn
	 */
	public void setUsOfcYn(String usOfcYn) {
		this.usOfcYn = usOfcYn;
	}	
	
	public String getInactStsCd() {
		return inactStsCd;
	}

	public void setInactStsCd(String inactStsCd) {
		this.inactStsCd = inactStsCd;
	}

	public String getInactNo() {
		return inactNo;
	}

	public void setInactNo(String inactNo) {
		this.inactNo = inactNo;
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
		setBkgRcvTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFxFtOvrDys(JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", ""));
		setCondType(JSPUtil.getParameter(request, prefix + "cond_type", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_sts_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setInclInv(JSPUtil.getParameter(request, prefix + "incl_inv", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setDemType(JSPUtil.getParameter(request, prefix + "dem_type", ""));
		setUsrRhqOfcCd(JSPUtil.getParameter(request, prefix + "usr_rhq_ofc_cd", ""));
		setToMvmtDt(JSPUtil.getParameter(request, prefix + "to_mvmt_dt", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setCustType(JSPUtil.getParameter(request, prefix + "cust_type", ""));
		setFmMvmtYdCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", ""));
		setChgType(JSPUtil.getParameter(request, prefix + "chg_type", ""));
		setToMvmtStsCd(JSPUtil.getParameter(request, prefix + "to_mvmt_sts_cd", ""));
		setBypodeta(JSPUtil.getParameter(request, prefix + "bypodeta", ""));
		setFmMvmtStsCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_sts_cd", ""));
		setDmdtCntrTpCd(JSPUtil.getParameter(request, prefix + "dmdt_cntr_tp_cd", ""));
		setCs(JSPUtil.getParameter(request, prefix + "cs", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSvcProvdr(JSPUtil.getParameter(request, prefix + "svc_provdr", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", ""));
		setWebMt(JSPUtil.getParameter(request, prefix + "web_mt", ""));
		setDmdtBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "dmdt_bkg_cgo_tp_cd", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", ""));
		setToMvmtYdCd(JSPUtil.getParameter(request, prefix + "to_mvmt_yd_cd", ""));
		setOpBkgNo(JSPUtil.getParameter(request, prefix + "op_bkg_no", ""));
		setOfcTrnsRhqCngFlg(JSPUtil.getParameter(request, prefix + "ofc_trns_rhq_cng_flg", ""));
		setOptDate(JSPUtil.getParameter(request, prefix + "opt_date", ""));
		setOptItemList(JSPUtil.getParameter(request, prefix + "opt_item_list", ""));
		setOrgGubunCd(JSPUtil.getParameter(request, prefix + "org_gubun_cd", ""));
		setDestGubunCd(JSPUtil.getParameter(request, prefix + "dest_gubun_cd", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setFmBzcTrfAplyDt(JSPUtil.getParameter(request, prefix + "fm_bzc_trf_aply_dt", ""));
		setToBzcTrfAplyDt(JSPUtil.getParameter(request, prefix + "to_bzc_trf_aply_dt", ""));
		setFmLocCd(JSPUtil.getParameter(request, prefix + "fm_loc_cd", ""));
		setToLocCd(JSPUtil.getParameter(request, prefix + "to_loc_cd", ""));
		setUclmFlg(JSPUtil.getParameter(request, prefix + "uclm_flg", ""));
		setDmdtArIfCd(JSPUtil.getParameter(request, prefix + "dmdt_ar_if_cd", ""));
		setOvrDue(JSPUtil.getParameter(request, prefix + "ovr_due", ""));
		setUsOfcYn(JSPUtil.getParameter(request, prefix + "us_ofc_yn", ""));
		setInactStsCd(JSPUtil.getParameter(request, prefix + "inact_sts_cd", ""));
		setInactNo(JSPUtil.getParameter(request, prefix + "inact_no", ""));
		setAftDarStsCd(JSPUtil.getParameter(request, prefix + "aft_dar_sts_cd", ""));
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
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "fx_ft_ovr_dys", length));
			String[] condType = (JSPUtil.getParameter(request, prefix	+ "cond_type", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] inclInv = (JSPUtil.getParameter(request, prefix	+ "incl_inv", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] demType = (JSPUtil.getParameter(request, prefix	+ "dem_type", length));
			String[] usrRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_rhq_ofc_cd", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] custType = (JSPUtil.getParameter(request, prefix	+ "cust_type", length));
			String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yd_cd", length));
			String[] chgType = (JSPUtil.getParameter(request, prefix	+ "chg_type", length));
			String[] toMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_sts_cd", length));
			String[] bypodeta = (JSPUtil.getParameter(request, prefix	+ "bypodeta", length));
			String[] fmMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_sts_cd", length));
			String[] dmdtCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_cd", length));
			String[] cs = (JSPUtil.getParameter(request, prefix	+ "cs", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] svcProvdr = (JSPUtil.getParameter(request, prefix	+ "svc_provdr", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] webMt = (JSPUtil.getParameter(request, prefix	+ "web_mt", length));
			String[] dmdtBkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_bkg_cgo_tp_cd", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_de_term_cd", length));
			String[] toMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_yd_cd", length));
			String[] opBkgNo = (JSPUtil.getParameter(request, prefix	+ "op_bkg_no", length));
			String[] ofcTrnsRhqCngFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_trns_rhq_cng_flg", length));
			String[] optDate = (JSPUtil.getParameter(request, prefix	+ "opt_date", length));
			String[] optItemList = (JSPUtil.getParameter(request, prefix	+ "opt_item_list", length));
			String[] orgGubunCd = (JSPUtil.getParameter(request, prefix	+ "org_gubun_cd", length));
			String[] destGubunCd = (JSPUtil.getParameter(request, prefix	+ "dest_gubun_cd", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] fmBzcTrfAplyDt = (JSPUtil.getParameter(request, prefix	+ "fm_bzc_trf_aply_dt", length));
			String[] toBzcTrfAplyDt = (JSPUtil.getParameter(request, prefix	+ "to_bzc_trf_aply_dt", length));
			String[] fmLocCd = (JSPUtil.getParameter(request, prefix	+ "fm_loc_cd", length));
			String[] toLocCd = (JSPUtil.getParameter(request, prefix	+ "to_loc_cd", length));
			String[] uclmFlg = (JSPUtil.getParameter(request, prefix	+ "uclm_flg", length));
			String[] dmdtArIfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ar_if_cd", length));
			String[] ovrDue = (JSPUtil.getParameter(request, prefix	+ "ovr_due", length));
			String[] usOfcYn = (JSPUtil.getParameter(request, prefix	+ "us_ofc_yn", length));
			String[] inactStsCd = (JSPUtil.getParameter(request, prefix	+ "inact_sts_cd", length));
			String[] inactNo = (JSPUtil.getParameter(request, prefix	+ "inact_no", length));
			String[] aftDarStsCd = (JSPUtil.getParameter(request, prefix	+ "aft_dar_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeByOfficeOrVVDVO();
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fxFtOvrDys[i] != null)
					model.setFxFtOvrDys(fxFtOvrDys[i]);
				if (condType[i] != null)
					model.setCondType(condType[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmdtChgStsCd[i] != null)
					model.setDmdtChgStsCd(dmdtChgStsCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (inclInv[i] != null)
					model.setInclInv(inclInv[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (demType[i] != null)
					model.setDemType(demType[i]);
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
				if (toMvmtStsCd[i] != null)
					model.setToMvmtStsCd(toMvmtStsCd[i]);
				if (bypodeta[i] != null)
					model.setBypodeta(bypodeta[i]);
				if (fmMvmtStsCd[i] != null)
					model.setFmMvmtStsCd(fmMvmtStsCd[i]);
				if (dmdtCntrTpCd[i] != null)
					model.setDmdtCntrTpCd(dmdtCntrTpCd[i]);
				if (cs[i] != null)
					model.setCs(cs[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (svcProvdr[i] != null)
					model.setSvcProvdr(svcProvdr[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (webMt[i] != null)
					model.setWebMt(webMt[i]);
				if (dmdtBkgCgoTpCd[i] != null)
					model.setDmdtBkgCgoTpCd(dmdtBkgCgoTpCd[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				if (toMvmtYdCd[i] != null)
					model.setToMvmtYdCd(toMvmtYdCd[i]);
				if (opBkgNo[i] != null)
					model.setOpBkgNo(opBkgNo[i]);
				if (ofcTrnsRhqCngFlg[i] != null)
					model.setOfcTrnsRhqCngFlg(ofcTrnsRhqCngFlg[i]);
				if (optDate[i] != null)
					model.setOptDate(optDate[i]);
				if (optItemList[i] != null)
					model.setOptItemList(optItemList[i]);
				if (orgGubunCd[i] != null)
					model.setOrgGubunCd(orgGubunCd[i]);
				if (destGubunCd[i] != null)
					model.setDestGubunCd(destGubunCd[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (fmBzcTrfAplyDt[i] != null)
					model.setFmBzcTrfAplyDt(fmBzcTrfAplyDt[i]);
				if (toBzcTrfAplyDt[i] != null)
					model.setToBzcTrfAplyDt(toBzcTrfAplyDt[i]);
				if (fmLocCd[i] != null)
					model.setFmLocCd(fmLocCd[i]);
				if (toLocCd[i] != null)
					model.setToLocCd(toLocCd[i]);
				if (uclmFlg[i] != null)
					model.setUclmFlg(uclmFlg[i]);
				if (dmdtArIfCd[i] != null)
					model.setDmdtArIfCd(dmdtArIfCd[i]);
				if (ovrDue[i] != null)
					model.setOvrDue(ovrDue[i]);
				if (usOfcYn[i] != null)
					model.setUsOfcYn(usOfcYn[i]);
				if (inactStsCd[i] != null)
					model.setInactStsCd(inactStsCd[i]);
				if (inactNo[i] != null)
					model.setInactNo(inactNo[i]);
				if (aftDarStsCd[i] != null)
					model.setAftDarStsCd(aftDarStsCd[i]);
				
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
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxFtOvrDys = this.fxFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condType = this.condType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclInv = this.inclInv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demType = this.demType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRhqOfcCd = this.usrRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custType = this.custType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYdCd = this.fmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgType = this.chgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtStsCd = this.toMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bypodeta = this.bypodeta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtStsCd = this.fmMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpCd = this.dmdtCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cs = this.cs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcProvdr = this.svcProvdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webMt = this.webMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBkgCgoTpCd = this.dmdtBkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtYdCd = this.toMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opBkgNo = this.opBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTrnsRhqCngFlg = this.ofcTrnsRhqCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optDate = this.optDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optItemList = this.optItemList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgGubunCd = this.orgGubunCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destGubunCd = this.destGubunCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmBzcTrfAplyDt = this.fmBzcTrfAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toBzcTrfAplyDt = this.toBzcTrfAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmFlg = this.uclmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtArIfCd = this.dmdtArIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDue = this.ovrDue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usOfcYn = this.usOfcYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactStsCd = this.inactStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactNo = this.inactNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftDarStsCd = this.aftDarStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
