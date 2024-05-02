/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRFAExceptionListVO.java
*@FileTitle : SCRFAExceptionListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo;

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

public class SCRFAExceptionListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SCRFAExceptionListVO> models = new ArrayList<SCRFAExceptionListVO>();
	
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String dmdtExptVerStsTxt = null;
	/* Column Info */
	private String actCustFlg = null;
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String ftTotDys = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String dmdtExptVerStsCd = null;
	/* Column Info */
	private String fnlDestRgnCd = null;
	/* Column Info */
	private String rtFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String orgDestContiCd = null;
	/* Column Info */
	private String cvrgSeq = null;
	/* Column Info */
	private String grpSeq = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String tariff = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String orgDestRgnCd = null;
	/* Column Info */
	private String orgDestMulti = null;
	/* Column Info */
	private String rqstSeq = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String darNo = null;
	/* Column Info */
	private String apvlNo = null;
	/* Column Info */
	private String ftTir = null;
	/* Column Info */
	private String orgDestLocCd = null;
	/* Column Info */
	private String orgDestSteCd = null;
	/* Column Info */
	private String actCustCd = null;
	/* Column Info */
	private String verSeq = null;
	/* Column Info */
	private String fnlDestCntCd = null;
	/* Column Info */
	private String actCustNm = null;
	/* Column Info */
	private String fnlDestLocCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String cntrcgo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String orgDestCntCd = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* Column Info */
	private String repCmdtFlg = null;
	/* Column Info */
	private String ftAddDys = null;
	/* Column Info */
	private String fnlDestSteCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SCRFAExceptionListVO() {}

	public SCRFAExceptionListVO(String ibflag, String pagerows, String propNo, String scNo, String verSeq, String cvrgSeq, String rfaNo, String dmdtExptVerStsCd, String dmdtExptVerStsTxt, String status, String tariff, String effDt, String expDt, String cntrcgo, String cntCd, String rgnCd, String locCd, String ftTir, String ftAddDys, String ftTotDys, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String currCd, String orgDestMulti, String orgDestContiCd, String orgDestCntCd, String orgDestRgnCd, String orgDestSteCd, String orgDestLocCd, String fnlDestCntCd, String fnlDestRgnCd, String fnlDestSteCd, String fnlDestLocCd, String rcvDeTermCd, String rtFlg, String repCmdtFlg, String actCustFlg, String custCd, String custNm, String actCustCd, String actCustNm, String darNo, String apvlNo, String grpSeq, String amdtSeq, String rqstSeq) {
		this.xcldSatFlg = xcldSatFlg;
		this.xcldSunFlg = xcldSunFlg;
		this.dmdtExptVerStsTxt = dmdtExptVerStsTxt;
		this.actCustFlg = actCustFlg;
		this.rgnCd = rgnCd;
		this.ftTotDys = ftTotDys;
		this.currCd = currCd;
		this.custNm = custNm;
		this.amdtSeq = amdtSeq;
		this.dmdtExptVerStsCd = dmdtExptVerStsCd;
		this.fnlDestRgnCd = fnlDestRgnCd;
		this.rtFlg = rtFlg;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.orgDestContiCd = orgDestContiCd;
		this.cvrgSeq = cvrgSeq;
		this.grpSeq = grpSeq;
		this.scNo = scNo;
		this.tariff = tariff;
		this.cntCd = cntCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.expDt = expDt;
		this.orgDestRgnCd = orgDestRgnCd;
		this.orgDestMulti = orgDestMulti;
		this.rqstSeq = rqstSeq;
		this.status = status;
		this.darNo = darNo;
		this.apvlNo = apvlNo;
		this.ftTir = ftTir;
		this.orgDestLocCd = orgDestLocCd;
		this.orgDestSteCd = orgDestSteCd;
		this.actCustCd = actCustCd;
		this.verSeq = verSeq;
		this.fnlDestCntCd = fnlDestCntCd;
		this.actCustNm = actCustNm;
		this.fnlDestLocCd = fnlDestLocCd;
		this.propNo = propNo;
		this.cntrcgo = cntrcgo;
		this.custCd = custCd;
		this.orgDestCntCd = orgDestCntCd;
		this.xcldHolFlg = xcldHolFlg;
		this.repCmdtFlg = repCmdtFlg;
		this.ftAddDys = ftAddDys;
		this.fnlDestSteCd = fnlDestSteCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("dmdt_expt_ver_sts_txt", getDmdtExptVerStsTxt());
		this.hashColumns.put("act_cust_flg", getActCustFlg());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("ft_tot_dys", getFtTotDys());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("dmdt_expt_ver_sts_cd", getDmdtExptVerStsCd());
		this.hashColumns.put("fnl_dest_rgn_cd", getFnlDestRgnCd());
		this.hashColumns.put("rt_flg", getRtFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("org_dest_conti_cd", getOrgDestContiCd());
		this.hashColumns.put("cvrg_seq", getCvrgSeq());
		this.hashColumns.put("grp_seq", getGrpSeq());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("tariff", getTariff());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("org_dest_rgn_cd", getOrgDestRgnCd());
		this.hashColumns.put("org_dest_multi", getOrgDestMulti());
		this.hashColumns.put("rqst_seq", getRqstSeq());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("dar_no", getDarNo());
		this.hashColumns.put("apvl_no", getApvlNo());
		this.hashColumns.put("ft_tir", getFtTir());
		this.hashColumns.put("org_dest_loc_cd", getOrgDestLocCd());
		this.hashColumns.put("org_dest_ste_cd", getOrgDestSteCd());
		this.hashColumns.put("act_cust_cd", getActCustCd());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("fnl_dest_cnt_cd", getFnlDestCntCd());
		this.hashColumns.put("act_cust_nm", getActCustNm());
		this.hashColumns.put("fnl_dest_loc_cd", getFnlDestLocCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cntrcgo", getCntrcgo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("org_dest_cnt_cd", getOrgDestCntCd());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("rep_cmdt_flg", getRepCmdtFlg());
		this.hashColumns.put("ft_add_dys", getFtAddDys());
		this.hashColumns.put("fnl_dest_ste_cd", getFnlDestSteCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("dmdt_expt_ver_sts_txt", "dmdtExptVerStsTxt");
		this.hashFields.put("act_cust_flg", "actCustFlg");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("ft_tot_dys", "ftTotDys");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("dmdt_expt_ver_sts_cd", "dmdtExptVerStsCd");
		this.hashFields.put("fnl_dest_rgn_cd", "fnlDestRgnCd");
		this.hashFields.put("rt_flg", "rtFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("org_dest_conti_cd", "orgDestContiCd");
		this.hashFields.put("cvrg_seq", "cvrgSeq");
		this.hashFields.put("grp_seq", "grpSeq");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("tariff", "tariff");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("org_dest_rgn_cd", "orgDestRgnCd");
		this.hashFields.put("org_dest_multi", "orgDestMulti");
		this.hashFields.put("rqst_seq", "rqstSeq");
		this.hashFields.put("status", "status");
		this.hashFields.put("dar_no", "darNo");
		this.hashFields.put("apvl_no", "apvlNo");
		this.hashFields.put("ft_tir", "ftTir");
		this.hashFields.put("org_dest_loc_cd", "orgDestLocCd");
		this.hashFields.put("org_dest_ste_cd", "orgDestSteCd");
		this.hashFields.put("act_cust_cd", "actCustCd");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("fnl_dest_cnt_cd", "fnlDestCntCd");
		this.hashFields.put("act_cust_nm", "actCustNm");
		this.hashFields.put("fnl_dest_loc_cd", "fnlDestLocCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cntrcgo", "cntrcgo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("org_dest_cnt_cd", "orgDestCntCd");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("rep_cmdt_flg", "repCmdtFlg");
		this.hashFields.put("ft_add_dys", "ftAddDys");
		this.hashFields.put("fnl_dest_ste_cd", "fnlDestSteCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xcldSatFlg
	 */
	public String getXcldSatFlg() {
		return this.xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @return xcldSunFlg
	 */
	public String getXcldSunFlg() {
		return this.xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @return dmdtExptVerStsTxt
	 */
	public String getDmdtExptVerStsTxt() {
		return this.dmdtExptVerStsTxt;
	}
	
	/**
	 * Column Info
	 * @return actCustFlg
	 */
	public String getActCustFlg() {
		return this.actCustFlg;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return ftTotDys
	 */
	public String getFtTotDys() {
		return this.ftTotDys;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtExptVerStsCd
	 */
	public String getDmdtExptVerStsCd() {
		return this.dmdtExptVerStsCd;
	}
	
	/**
	 * Column Info
	 * @return fnlDestRgnCd
	 */
	public String getFnlDestRgnCd() {
		return this.fnlDestRgnCd;
	}
	
	/**
	 * Column Info
	 * @return rtFlg
	 */
	public String getRtFlg() {
		return this.rtFlg;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestContiCd
	 */
	public String getOrgDestContiCd() {
		return this.orgDestContiCd;
	}
	
	/**
	 * Column Info
	 * @return cvrgSeq
	 */
	public String getCvrgSeq() {
		return this.cvrgSeq;
	}
	
	/**
	 * Column Info
	 * @return grpSeq
	 */
	public String getGrpSeq() {
		return this.grpSeq;
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
	 * @return tariff
	 */
	public String getTariff() {
		return this.tariff;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return orgDestRgnCd
	 */
	public String getOrgDestRgnCd() {
		return this.orgDestRgnCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestMulti
	 */
	public String getOrgDestMulti() {
		return this.orgDestMulti;
	}
	
	/**
	 * Column Info
	 * @return rqstSeq
	 */
	public String getRqstSeq() {
		return this.rqstSeq;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return darNo
	 */
	public String getDarNo() {
		return this.darNo;
	}
	
	/**
	 * Column Info
	 * @return apvlNo
	 */
	public String getApvlNo() {
		return this.apvlNo;
	}
	
	/**
	 * Column Info
	 * @return ftTir
	 */
	public String getFtTir() {
		return this.ftTir;
	}
	
	/**
	 * Column Info
	 * @return orgDestLocCd
	 */
	public String getOrgDestLocCd() {
		return this.orgDestLocCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestSteCd
	 */
	public String getOrgDestSteCd() {
		return this.orgDestSteCd;
	}
	
	/**
	 * Column Info
	 * @return actCustCd
	 */
	public String getActCustCd() {
		return this.actCustCd;
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
	 * @return fnlDestCntCd
	 */
	public String getFnlDestCntCd() {
		return this.fnlDestCntCd;
	}
	
	/**
	 * Column Info
	 * @return actCustNm
	 */
	public String getActCustNm() {
		return this.actCustNm;
	}
	
	/**
	 * Column Info
	 * @return fnlDestLocCd
	 */
	public String getFnlDestLocCd() {
		return this.fnlDestLocCd;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return cntrcgo
	 */
	public String getCntrcgo() {
		return this.cntrcgo;
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
	 * @return orgDestCntCd
	 */
	public String getOrgDestCntCd() {
		return this.orgDestCntCd;
	}
	
	/**
	 * Column Info
	 * @return xcldHolFlg
	 */
	public String getXcldHolFlg() {
		return this.xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @return repCmdtFlg
	 */
	public String getRepCmdtFlg() {
		return this.repCmdtFlg;
	}
	
	/**
	 * Column Info
	 * @return ftAddDys
	 */
	public String getFtAddDys() {
		return this.ftAddDys;
	}
	
	/**
	 * Column Info
	 * @return fnlDestSteCd
	 */
	public String getFnlDestSteCd() {
		return this.fnlDestSteCd;
	}
	

	/**
	 * Column Info
	 * @param xcldSatFlg
	 */
	public void setXcldSatFlg(String xcldSatFlg) {
		this.xcldSatFlg = xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @param xcldSunFlg
	 */
	public void setXcldSunFlg(String xcldSunFlg) {
		this.xcldSunFlg = xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @param dmdtExptVerStsTxt
	 */
	public void setDmdtExptVerStsTxt(String dmdtExptVerStsTxt) {
		this.dmdtExptVerStsTxt = dmdtExptVerStsTxt;
	}
	
	/**
	 * Column Info
	 * @param actCustFlg
	 */
	public void setActCustFlg(String actCustFlg) {
		this.actCustFlg = actCustFlg;
	}
	
	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param ftTotDys
	 */
	public void setFtTotDys(String ftTotDys) {
		this.ftTotDys = ftTotDys;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtExptVerStsCd
	 */
	public void setDmdtExptVerStsCd(String dmdtExptVerStsCd) {
		this.dmdtExptVerStsCd = dmdtExptVerStsCd;
	}
	
	/**
	 * Column Info
	 * @param fnlDestRgnCd
	 */
	public void setFnlDestRgnCd(String fnlDestRgnCd) {
		this.fnlDestRgnCd = fnlDestRgnCd;
	}
	
	/**
	 * Column Info
	 * @param rtFlg
	 */
	public void setRtFlg(String rtFlg) {
		this.rtFlg = rtFlg;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestContiCd
	 */
	public void setOrgDestContiCd(String orgDestContiCd) {
		this.orgDestContiCd = orgDestContiCd;
	}
	
	/**
	 * Column Info
	 * @param cvrgSeq
	 */
	public void setCvrgSeq(String cvrgSeq) {
		this.cvrgSeq = cvrgSeq;
	}
	
	/**
	 * Column Info
	 * @param grpSeq
	 */
	public void setGrpSeq(String grpSeq) {
		this.grpSeq = grpSeq;
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
	 * @param tariff
	 */
	public void setTariff(String tariff) {
		this.tariff = tariff;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param orgDestRgnCd
	 */
	public void setOrgDestRgnCd(String orgDestRgnCd) {
		this.orgDestRgnCd = orgDestRgnCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestMulti
	 */
	public void setOrgDestMulti(String orgDestMulti) {
		this.orgDestMulti = orgDestMulti;
	}
	
	/**
	 * Column Info
	 * @param rqstSeq
	 */
	public void setRqstSeq(String rqstSeq) {
		this.rqstSeq = rqstSeq;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param darNo
	 */
	public void setDarNo(String darNo) {
		this.darNo = darNo;
	}
	
	/**
	 * Column Info
	 * @param apvlNo
	 */
	public void setApvlNo(String apvlNo) {
		this.apvlNo = apvlNo;
	}
	
	/**
	 * Column Info
	 * @param ftTir
	 */
	public void setFtTir(String ftTir) {
		this.ftTir = ftTir;
	}
	
	/**
	 * Column Info
	 * @param orgDestLocCd
	 */
	public void setOrgDestLocCd(String orgDestLocCd) {
		this.orgDestLocCd = orgDestLocCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestSteCd
	 */
	public void setOrgDestSteCd(String orgDestSteCd) {
		this.orgDestSteCd = orgDestSteCd;
	}
	
	/**
	 * Column Info
	 * @param actCustCd
	 */
	public void setActCustCd(String actCustCd) {
		this.actCustCd = actCustCd;
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
	 * @param fnlDestCntCd
	 */
	public void setFnlDestCntCd(String fnlDestCntCd) {
		this.fnlDestCntCd = fnlDestCntCd;
	}
	
	/**
	 * Column Info
	 * @param actCustNm
	 */
	public void setActCustNm(String actCustNm) {
		this.actCustNm = actCustNm;
	}
	
	/**
	 * Column Info
	 * @param fnlDestLocCd
	 */
	public void setFnlDestLocCd(String fnlDestLocCd) {
		this.fnlDestLocCd = fnlDestLocCd;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param cntrcgo
	 */
	public void setCntrcgo(String cntrcgo) {
		this.cntrcgo = cntrcgo;
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
	 * @param orgDestCntCd
	 */
	public void setOrgDestCntCd(String orgDestCntCd) {
		this.orgDestCntCd = orgDestCntCd;
	}
	
	/**
	 * Column Info
	 * @param xcldHolFlg
	 */
	public void setXcldHolFlg(String xcldHolFlg) {
		this.xcldHolFlg = xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @param repCmdtFlg
	 */
	public void setRepCmdtFlg(String repCmdtFlg) {
		this.repCmdtFlg = repCmdtFlg;
	}
	
	/**
	 * Column Info
	 * @param ftAddDys
	 */
	public void setFtAddDys(String ftAddDys) {
		this.ftAddDys = ftAddDys;
	}
	
	/**
	 * Column Info
	 * @param fnlDestSteCd
	 */
	public void setFnlDestSteCd(String fnlDestSteCd) {
		this.fnlDestSteCd = fnlDestSteCd;
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
		setXcldSatFlg(JSPUtil.getParameter(request, prefix + "xcld_sat_flg", ""));
		setXcldSunFlg(JSPUtil.getParameter(request, prefix + "xcld_sun_flg", ""));
		setDmdtExptVerStsTxt(JSPUtil.getParameter(request, prefix + "dmdt_expt_ver_sts_txt", ""));
		setActCustFlg(JSPUtil.getParameter(request, prefix + "act_cust_flg", ""));
		setRgnCd(JSPUtil.getParameter(request, prefix + "rgn_cd", ""));
		setFtTotDys(JSPUtil.getParameter(request, prefix + "ft_tot_dys", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setDmdtExptVerStsCd(JSPUtil.getParameter(request, prefix + "dmdt_expt_ver_sts_cd", ""));
		setFnlDestRgnCd(JSPUtil.getParameter(request, prefix + "fnl_dest_rgn_cd", ""));
		setRtFlg(JSPUtil.getParameter(request, prefix + "rt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setOrgDestContiCd(JSPUtil.getParameter(request, prefix + "org_dest_conti_cd", ""));
		setCvrgSeq(JSPUtil.getParameter(request, prefix + "cvrg_seq", ""));
		setGrpSeq(JSPUtil.getParameter(request, prefix + "grp_seq", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setTariff(JSPUtil.getParameter(request, prefix + "tariff", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setOrgDestRgnCd(JSPUtil.getParameter(request, prefix + "org_dest_rgn_cd", ""));
		setOrgDestMulti(JSPUtil.getParameter(request, prefix + "org_dest_multi", ""));
		setRqstSeq(JSPUtil.getParameter(request, prefix + "rqst_seq", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setDarNo(JSPUtil.getParameter(request, prefix + "dar_no", ""));
		setApvlNo(JSPUtil.getParameter(request, prefix + "apvl_no", ""));
		setFtTir(JSPUtil.getParameter(request, prefix + "ft_tir", ""));
		setOrgDestLocCd(JSPUtil.getParameter(request, prefix + "org_dest_loc_cd", ""));
		setOrgDestSteCd(JSPUtil.getParameter(request, prefix + "org_dest_ste_cd", ""));
		setActCustCd(JSPUtil.getParameter(request, prefix + "act_cust_cd", ""));
		setVerSeq(JSPUtil.getParameter(request, prefix + "ver_seq", ""));
		setFnlDestCntCd(JSPUtil.getParameter(request, prefix + "fnl_dest_cnt_cd", ""));
		setActCustNm(JSPUtil.getParameter(request, prefix + "act_cust_nm", ""));
		setFnlDestLocCd(JSPUtil.getParameter(request, prefix + "fnl_dest_loc_cd", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setCntrcgo(JSPUtil.getParameter(request, prefix + "cntrcgo", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setOrgDestCntCd(JSPUtil.getParameter(request, prefix + "org_dest_cnt_cd", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, prefix + "xcld_hol_flg", ""));
		setRepCmdtFlg(JSPUtil.getParameter(request, prefix + "rep_cmdt_flg", ""));
		setFtAddDys(JSPUtil.getParameter(request, prefix + "ft_add_dys", ""));
		setFnlDestSteCd(JSPUtil.getParameter(request, prefix + "fnl_dest_ste_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SCRFAExceptionListVO[]
	 */
	public SCRFAExceptionListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SCRFAExceptionListVO[]
	 */
	public SCRFAExceptionListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SCRFAExceptionListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] dmdtExptVerStsTxt = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_ver_sts_txt", length));
			String[] actCustFlg = (JSPUtil.getParameter(request, prefix	+ "act_cust_flg", length));
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] ftTotDys = (JSPUtil.getParameter(request, prefix	+ "ft_tot_dys", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] dmdtExptVerStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_ver_sts_cd", length));
			String[] fnlDestRgnCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_rgn_cd", length));
			String[] rtFlg = (JSPUtil.getParameter(request, prefix	+ "rt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] orgDestContiCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_conti_cd", length));
			String[] cvrgSeq = (JSPUtil.getParameter(request, prefix	+ "cvrg_seq", length));
			String[] grpSeq = (JSPUtil.getParameter(request, prefix	+ "grp_seq", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] tariff = (JSPUtil.getParameter(request, prefix	+ "tariff", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] orgDestRgnCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_rgn_cd", length));
			String[] orgDestMulti = (JSPUtil.getParameter(request, prefix	+ "org_dest_multi", length));
			String[] rqstSeq = (JSPUtil.getParameter(request, prefix	+ "rqst_seq", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] darNo = (JSPUtil.getParameter(request, prefix	+ "dar_no", length));
			String[] apvlNo = (JSPUtil.getParameter(request, prefix	+ "apvl_no", length));
			String[] ftTir = (JSPUtil.getParameter(request, prefix	+ "ft_tir", length));
			String[] orgDestLocCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_loc_cd", length));
			String[] orgDestSteCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_ste_cd", length));
			String[] actCustCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cd", length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq", length));
			String[] fnlDestCntCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_cnt_cd", length));
			String[] actCustNm = (JSPUtil.getParameter(request, prefix	+ "act_cust_nm", length));
			String[] fnlDestLocCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_loc_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] cntrcgo = (JSPUtil.getParameter(request, prefix	+ "cntrcgo", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] orgDestCntCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_cnt_cd", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] repCmdtFlg = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_flg", length));
			String[] ftAddDys = (JSPUtil.getParameter(request, prefix	+ "ft_add_dys", length));
			String[] fnlDestSteCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_ste_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SCRFAExceptionListVO();
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (dmdtExptVerStsTxt[i] != null)
					model.setDmdtExptVerStsTxt(dmdtExptVerStsTxt[i]);
				if (actCustFlg[i] != null)
					model.setActCustFlg(actCustFlg[i]);
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (ftTotDys[i] != null)
					model.setFtTotDys(ftTotDys[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (dmdtExptVerStsCd[i] != null)
					model.setDmdtExptVerStsCd(dmdtExptVerStsCd[i]);
				if (fnlDestRgnCd[i] != null)
					model.setFnlDestRgnCd(fnlDestRgnCd[i]);
				if (rtFlg[i] != null)
					model.setRtFlg(rtFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (orgDestContiCd[i] != null)
					model.setOrgDestContiCd(orgDestContiCd[i]);
				if (cvrgSeq[i] != null)
					model.setCvrgSeq(cvrgSeq[i]);
				if (grpSeq[i] != null)
					model.setGrpSeq(grpSeq[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (tariff[i] != null)
					model.setTariff(tariff[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (orgDestRgnCd[i] != null)
					model.setOrgDestRgnCd(orgDestRgnCd[i]);
				if (orgDestMulti[i] != null)
					model.setOrgDestMulti(orgDestMulti[i]);
				if (rqstSeq[i] != null)
					model.setRqstSeq(rqstSeq[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (darNo[i] != null)
					model.setDarNo(darNo[i]);
				if (apvlNo[i] != null)
					model.setApvlNo(apvlNo[i]);
				if (ftTir[i] != null)
					model.setFtTir(ftTir[i]);
				if (orgDestLocCd[i] != null)
					model.setOrgDestLocCd(orgDestLocCd[i]);
				if (orgDestSteCd[i] != null)
					model.setOrgDestSteCd(orgDestSteCd[i]);
				if (actCustCd[i] != null)
					model.setActCustCd(actCustCd[i]);
				if (verSeq[i] != null)
					model.setVerSeq(verSeq[i]);
				if (fnlDestCntCd[i] != null)
					model.setFnlDestCntCd(fnlDestCntCd[i]);
				if (actCustNm[i] != null)
					model.setActCustNm(actCustNm[i]);
				if (fnlDestLocCd[i] != null)
					model.setFnlDestLocCd(fnlDestLocCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (cntrcgo[i] != null)
					model.setCntrcgo(cntrcgo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (orgDestCntCd[i] != null)
					model.setOrgDestCntCd(orgDestCntCd[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (repCmdtFlg[i] != null)
					model.setRepCmdtFlg(repCmdtFlg[i]);
				if (ftAddDys[i] != null)
					model.setFtAddDys(ftAddDys[i]);
				if (fnlDestSteCd[i] != null)
					model.setFnlDestSteCd(fnlDestSteCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSCRFAExceptionListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SCRFAExceptionListVO[]
	 */
	public SCRFAExceptionListVO[] getSCRFAExceptionListVOs(){
		SCRFAExceptionListVO[] vos = (SCRFAExceptionListVO[])models.toArray(new SCRFAExceptionListVO[models.size()]);
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
		this.xcldSatFlg = this.xcldSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSunFlg = this.xcldSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptVerStsTxt = this.dmdtExptVerStsTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustFlg = this.actCustFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftTotDys = this.ftTotDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptVerStsCd = this.dmdtExptVerStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestRgnCd = this.fnlDestRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtFlg = this.rtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestContiCd = this.orgDestContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgSeq = this.cvrgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpSeq = this.grpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariff = this.tariff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestRgnCd = this.orgDestRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestMulti = this.orgDestMulti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstSeq = this.rqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.darNo = this.darNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlNo = this.apvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftTir = this.ftTir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestLocCd = this.orgDestLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestSteCd = this.orgDestSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCd = this.actCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestCntCd = this.fnlDestCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustNm = this.actCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestLocCd = this.fnlDestLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrcgo = this.cntrcgo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestCntCd = this.orgDestCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtFlg = this.repCmdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftAddDys = this.ftAddDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestSteCd = this.fnlDestSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
