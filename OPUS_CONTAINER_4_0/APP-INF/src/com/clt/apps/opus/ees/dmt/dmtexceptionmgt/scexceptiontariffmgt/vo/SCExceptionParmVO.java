/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCExceptionParmVO.java
*@FileTitle : SCExceptionParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.04  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SCExceptionParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SCExceptionParmVO> models = new ArrayList<SCExceptionParmVO>();
	
	/* Column Info */
	private String scExptFmContiCd = null;
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String actCustList = null;
	/* Column Info */
	private String dmdtExptVerStsCd = null;
	/* Column Info */
	private String chkCalcTpCombined = null;
	/* Column Info */
	private String scExptVerSeq = null;
	/* Column Info */
	private String fnlDestRgnCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String scExptFmRgnCd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String chkCalcTpIn = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String custType = null;
	/* Column Info */
	private String dmdtCntrCgoTpCd = null;
	/* Column Info */
	private String scExptFmCntCd = null;
	/* Column Info */
	private String scExptFmSteCd = null;
	/* Column Info */
	private String scExptGrpSeq = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String fnlDestCntCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String histPropNo = null;
	/* Column Info */
	private String fnlDestLocCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String dmdtCtrtExptTpCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String coverageList = null;
	/* Column Info */
	private String scExptPrevVerSeq = null;
	/* Column Info */
	private String scExptFmLocCd = null;
	/* Column Info */
	private String cmdtList = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String prcCmdtTpCd = null;
	/* Column Info */
	private String fnlDestSteCd = null;
	/* Column Info */
	private String scExptHistVerSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SCExceptionParmVO() {}

	public SCExceptionParmVO(String ibflag, String pagerows, String propNo, String histPropNo, String amdtSeq, String scExptVerSeq, String scExptPrevVerSeq, String scExptHistVerSeq, String dmdtExptVerStsCd, String scExptGrpSeq, String creUsrId, String creOfcCd, String updUsrId, String updOfcCd, String prcCmdtTpCd, String custCntCd, String custSeq, String chkCalcTpIn, String dmdtCtrtExptTpCd, String chkCalcTpCombined, String dmdtTrfCd, String effDt, String expDt, String dmdtCntrCgoTpCd, String cntCd, String rgnCd, String steCd, String locCd, String scNo, String custCd, String ofcCd, String custType, String coverageList, String actCustList, String cmdtList, String scExptFmContiCd, String scExptFmCntCd, String scExptFmRgnCd, String scExptFmSteCd, String scExptFmLocCd, String fnlDestCntCd, String fnlDestRgnCd, String fnlDestSteCd, String fnlDestLocCd, String rcvDeTermCd) {
		this.scExptFmContiCd = scExptFmContiCd;
		this.rgnCd = rgnCd;
		this.amdtSeq = amdtSeq;
		this.actCustList = actCustList;
		this.dmdtExptVerStsCd = dmdtExptVerStsCd;
		this.chkCalcTpCombined = chkCalcTpCombined;
		this.scExptVerSeq = scExptVerSeq;
		this.fnlDestRgnCd = fnlDestRgnCd;
		this.pagerows = pagerows;
		this.scExptFmRgnCd = scExptFmRgnCd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.chkCalcTpIn = chkCalcTpIn;
		this.scNo = scNo;
		this.creOfcCd = creOfcCd;
		this.cntCd = cntCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.custCntCd = custCntCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.custType = custType;
		this.dmdtCntrCgoTpCd = dmdtCntrCgoTpCd;
		this.scExptFmCntCd = scExptFmCntCd;
		this.scExptFmSteCd = scExptFmSteCd;
		this.scExptGrpSeq = scExptGrpSeq;
		this.custSeq = custSeq;
		this.ofcCd = ofcCd;
		this.fnlDestCntCd = fnlDestCntCd;
		this.creUsrId = creUsrId;
		this.histPropNo = histPropNo;
		this.fnlDestLocCd = fnlDestLocCd;
		this.propNo = propNo;
		this.dmdtCtrtExptTpCd = dmdtCtrtExptTpCd;
		this.custCd = custCd;
		this.coverageList = coverageList;
		this.scExptPrevVerSeq = scExptPrevVerSeq;
		this.scExptFmLocCd = scExptFmLocCd;
		this.cmdtList = cmdtList;
		this.steCd = steCd;
		this.prcCmdtTpCd = prcCmdtTpCd;
		this.fnlDestSteCd = fnlDestSteCd;
		this.scExptHistVerSeq = scExptHistVerSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sc_expt_fm_conti_cd", getScExptFmContiCd());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("act_cust_list", getActCustList());
		this.hashColumns.put("dmdt_expt_ver_sts_cd", getDmdtExptVerStsCd());
		this.hashColumns.put("chk_calc_tp_combined", getChkCalcTpCombined());
		this.hashColumns.put("sc_expt_ver_seq", getScExptVerSeq());
		this.hashColumns.put("fnl_dest_rgn_cd", getFnlDestRgnCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sc_expt_fm_rgn_cd", getScExptFmRgnCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("chk_calc_tp_in", getChkCalcTpIn());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("cust_type", getCustType());
		this.hashColumns.put("dmdt_cntr_cgo_tp_cd", getDmdtCntrCgoTpCd());
		this.hashColumns.put("sc_expt_fm_cnt_cd", getScExptFmCntCd());
		this.hashColumns.put("sc_expt_fm_ste_cd", getScExptFmSteCd());
		this.hashColumns.put("sc_expt_grp_seq", getScExptGrpSeq());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("fnl_dest_cnt_cd", getFnlDestCntCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("hist_prop_no", getHistPropNo());
		this.hashColumns.put("fnl_dest_loc_cd", getFnlDestLocCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("dmdt_ctrt_expt_tp_cd", getDmdtCtrtExptTpCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("coverage_list", getCoverageList());
		this.hashColumns.put("sc_expt_prev_ver_seq", getScExptPrevVerSeq());
		this.hashColumns.put("sc_expt_fm_loc_cd", getScExptFmLocCd());
		this.hashColumns.put("cmdt_list", getCmdtList());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("prc_cmdt_tp_cd", getPrcCmdtTpCd());
		this.hashColumns.put("fnl_dest_ste_cd", getFnlDestSteCd());
		this.hashColumns.put("sc_expt_hist_ver_seq", getScExptHistVerSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sc_expt_fm_conti_cd", "scExptFmContiCd");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("act_cust_list", "actCustList");
		this.hashFields.put("dmdt_expt_ver_sts_cd", "dmdtExptVerStsCd");
		this.hashFields.put("chk_calc_tp_combined", "chkCalcTpCombined");
		this.hashFields.put("sc_expt_ver_seq", "scExptVerSeq");
		this.hashFields.put("fnl_dest_rgn_cd", "fnlDestRgnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sc_expt_fm_rgn_cd", "scExptFmRgnCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("chk_calc_tp_in", "chkCalcTpIn");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("cust_type", "custType");
		this.hashFields.put("dmdt_cntr_cgo_tp_cd", "dmdtCntrCgoTpCd");
		this.hashFields.put("sc_expt_fm_cnt_cd", "scExptFmCntCd");
		this.hashFields.put("sc_expt_fm_ste_cd", "scExptFmSteCd");
		this.hashFields.put("sc_expt_grp_seq", "scExptGrpSeq");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("fnl_dest_cnt_cd", "fnlDestCntCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("hist_prop_no", "histPropNo");
		this.hashFields.put("fnl_dest_loc_cd", "fnlDestLocCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("dmdt_ctrt_expt_tp_cd", "dmdtCtrtExptTpCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("coverage_list", "coverageList");
		this.hashFields.put("sc_expt_prev_ver_seq", "scExptPrevVerSeq");
		this.hashFields.put("sc_expt_fm_loc_cd", "scExptFmLocCd");
		this.hashFields.put("cmdt_list", "cmdtList");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("prc_cmdt_tp_cd", "prcCmdtTpCd");
		this.hashFields.put("fnl_dest_ste_cd", "fnlDestSteCd");
		this.hashFields.put("sc_expt_hist_ver_seq", "scExptHistVerSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scExptFmContiCd
	 */
	public String getScExptFmContiCd() {
		return this.scExptFmContiCd;
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return actCustList
	 */
	public String getActCustList() {
		return this.actCustList;
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
	 * @return chkCalcTpCombined
	 */
	public String getChkCalcTpCombined() {
		return this.chkCalcTpCombined;
	}
	
	/**
	 * Column Info
	 * @return scExptVerSeq
	 */
	public String getScExptVerSeq() {
		return this.scExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @return fnlDestRgnCd
	 */
	public String getFnlDestRgnCd() {
		return this.fnlDestRgnCd;
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
	 * @return scExptFmRgnCd
	 */
	public String getScExptFmRgnCd() {
		return this.scExptFmRgnCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return chkCalcTpIn
	 */
	public String getChkCalcTpIn() {
		return this.chkCalcTpIn;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return dmdtCntrCgoTpCd
	 */
	public String getDmdtCntrCgoTpCd() {
		return this.dmdtCntrCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return scExptFmCntCd
	 */
	public String getScExptFmCntCd() {
		return this.scExptFmCntCd;
	}
	
	/**
	 * Column Info
	 * @return scExptFmSteCd
	 */
	public String getScExptFmSteCd() {
		return this.scExptFmSteCd;
	}
	
	/**
	 * Column Info
	 * @return scExptGrpSeq
	 */
	public String getScExptGrpSeq() {
		return this.scExptGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return fnlDestCntCd
	 */
	public String getFnlDestCntCd() {
		return this.fnlDestCntCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return histPropNo
	 */
	public String getHistPropNo() {
		return this.histPropNo;
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
	 * @return dmdtCtrtExptTpCd
	 */
	public String getDmdtCtrtExptTpCd() {
		return this.dmdtCtrtExptTpCd;
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
	 * @return coverageList
	 */
	public String getCoverageList() {
		return this.coverageList;
	}
	
	/**
	 * Column Info
	 * @return scExptPrevVerSeq
	 */
	public String getScExptPrevVerSeq() {
		return this.scExptPrevVerSeq;
	}
	
	/**
	 * Column Info
	 * @return scExptFmLocCd
	 */
	public String getScExptFmLocCd() {
		return this.scExptFmLocCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtList
	 */
	public String getCmdtList() {
		return this.cmdtList;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtTpCd
	 */
	public String getPrcCmdtTpCd() {
		return this.prcCmdtTpCd;
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
	 * @return scExptHistVerSeq
	 */
	public String getScExptHistVerSeq() {
		return this.scExptHistVerSeq;
	}
	

	/**
	 * Column Info
	 * @param scExptFmContiCd
	 */
	public void setScExptFmContiCd(String scExptFmContiCd) {
		this.scExptFmContiCd = scExptFmContiCd;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param actCustList
	 */
	public void setActCustList(String actCustList) {
		this.actCustList = actCustList;
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
	 * @param chkCalcTpCombined
	 */
	public void setChkCalcTpCombined(String chkCalcTpCombined) {
		this.chkCalcTpCombined = chkCalcTpCombined;
	}
	
	/**
	 * Column Info
	 * @param scExptVerSeq
	 */
	public void setScExptVerSeq(String scExptVerSeq) {
		this.scExptVerSeq = scExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @param fnlDestRgnCd
	 */
	public void setFnlDestRgnCd(String fnlDestRgnCd) {
		this.fnlDestRgnCd = fnlDestRgnCd;
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
	 * @param scExptFmRgnCd
	 */
	public void setScExptFmRgnCd(String scExptFmRgnCd) {
		this.scExptFmRgnCd = scExptFmRgnCd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param chkCalcTpIn
	 */
	public void setChkCalcTpIn(String chkCalcTpIn) {
		this.chkCalcTpIn = chkCalcTpIn;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param dmdtCntrCgoTpCd
	 */
	public void setDmdtCntrCgoTpCd(String dmdtCntrCgoTpCd) {
		this.dmdtCntrCgoTpCd = dmdtCntrCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param scExptFmCntCd
	 */
	public void setScExptFmCntCd(String scExptFmCntCd) {
		this.scExptFmCntCd = scExptFmCntCd;
	}
	
	/**
	 * Column Info
	 * @param scExptFmSteCd
	 */
	public void setScExptFmSteCd(String scExptFmSteCd) {
		this.scExptFmSteCd = scExptFmSteCd;
	}
	
	/**
	 * Column Info
	 * @param scExptGrpSeq
	 */
	public void setScExptGrpSeq(String scExptGrpSeq) {
		this.scExptGrpSeq = scExptGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param fnlDestCntCd
	 */
	public void setFnlDestCntCd(String fnlDestCntCd) {
		this.fnlDestCntCd = fnlDestCntCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param histPropNo
	 */
	public void setHistPropNo(String histPropNo) {
		this.histPropNo = histPropNo;
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
	 * @param dmdtCtrtExptTpCd
	 */
	public void setDmdtCtrtExptTpCd(String dmdtCtrtExptTpCd) {
		this.dmdtCtrtExptTpCd = dmdtCtrtExptTpCd;
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
	 * @param coverageList
	 */
	public void setCoverageList(String coverageList) {
		this.coverageList = coverageList;
	}
	
	/**
	 * Column Info
	 * @param scExptPrevVerSeq
	 */
	public void setScExptPrevVerSeq(String scExptPrevVerSeq) {
		this.scExptPrevVerSeq = scExptPrevVerSeq;
	}
	
	/**
	 * Column Info
	 * @param scExptFmLocCd
	 */
	public void setScExptFmLocCd(String scExptFmLocCd) {
		this.scExptFmLocCd = scExptFmLocCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtList
	 */
	public void setCmdtList(String cmdtList) {
		this.cmdtList = cmdtList;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtTpCd
	 */
	public void setPrcCmdtTpCd(String prcCmdtTpCd) {
		this.prcCmdtTpCd = prcCmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @param fnlDestSteCd
	 */
	public void setFnlDestSteCd(String fnlDestSteCd) {
		this.fnlDestSteCd = fnlDestSteCd;
	}
	
	/**
	 * Column Info
	 * @param scExptHistVerSeq
	 */
	public void setScExptHistVerSeq(String scExptHistVerSeq) {
		this.scExptHistVerSeq = scExptHistVerSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setScExptFmContiCd(JSPUtil.getParameter(request, "sc_expt_fm_conti_cd", ""));
		setRgnCd(JSPUtil.getParameter(request, "rgn_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setActCustList(JSPUtil.getParameter(request, "act_cust_list", ""));
		setDmdtExptVerStsCd(JSPUtil.getParameter(request, "dmdt_expt_ver_sts_cd", ""));
		setChkCalcTpCombined(JSPUtil.getParameter(request, "chk_calc_tp_combined", ""));
		setScExptVerSeq(JSPUtil.getParameter(request, "sc_expt_ver_seq", ""));
		setFnlDestRgnCd(JSPUtil.getParameter(request, "fnl_dest_rgn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setScExptFmRgnCd(JSPUtil.getParameter(request, "sc_expt_fm_rgn_cd", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setChkCalcTpIn(JSPUtil.getParameter(request, "chk_calc_tp_in", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, "rcv_de_term_cd", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setCustType(JSPUtil.getParameter(request, "cust_type", ""));
		setDmdtCntrCgoTpCd(JSPUtil.getParameter(request, "dmdt_cntr_cgo_tp_cd", ""));
		setScExptFmCntCd(JSPUtil.getParameter(request, "sc_expt_fm_cnt_cd", ""));
		setScExptFmSteCd(JSPUtil.getParameter(request, "sc_expt_fm_ste_cd", ""));
		setScExptGrpSeq(JSPUtil.getParameter(request, "sc_expt_grp_seq", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setFnlDestCntCd(JSPUtil.getParameter(request, "fnl_dest_cnt_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setHistPropNo(JSPUtil.getParameter(request, "hist_prop_no", ""));
		setFnlDestLocCd(JSPUtil.getParameter(request, "fnl_dest_loc_cd", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setDmdtCtrtExptTpCd(JSPUtil.getParameter(request, "dmdt_ctrt_expt_tp_cd", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setCoverageList(JSPUtil.getParameter(request, "coverage_list", ""));
		setScExptPrevVerSeq(JSPUtil.getParameter(request, "sc_expt_prev_ver_seq", ""));
		setScExptFmLocCd(JSPUtil.getParameter(request, "sc_expt_fm_loc_cd", ""));
		setCmdtList(JSPUtil.getParameter(request, "cmdt_list", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
		setPrcCmdtTpCd(JSPUtil.getParameter(request, "prc_cmdt_tp_cd", ""));
		setFnlDestSteCd(JSPUtil.getParameter(request, "fnl_dest_ste_cd", ""));
		setScExptHistVerSeq(JSPUtil.getParameter(request, "sc_expt_hist_ver_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SCExceptionParmVO[]
	 */
	public SCExceptionParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SCExceptionParmVO[]
	 */
	public SCExceptionParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SCExceptionParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scExptFmContiCd = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_conti_cd", length));
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] actCustList = (JSPUtil.getParameter(request, prefix	+ "act_cust_list", length));
			String[] dmdtExptVerStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_ver_sts_cd", length));
			String[] chkCalcTpCombined = (JSPUtil.getParameter(request, prefix	+ "chk_calc_tp_combined", length));
			String[] scExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_ver_seq", length));
			String[] fnlDestRgnCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_rgn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] scExptFmRgnCd = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_rgn_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] chkCalcTpIn = (JSPUtil.getParameter(request, prefix	+ "chk_calc_tp_in", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] custType = (JSPUtil.getParameter(request, prefix	+ "cust_type", length));
			String[] dmdtCntrCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_cgo_tp_cd", length));
			String[] scExptFmCntCd = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_cnt_cd", length));
			String[] scExptFmSteCd = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_ste_cd", length));
			String[] scExptGrpSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_grp_seq", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] fnlDestCntCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_cnt_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] histPropNo = (JSPUtil.getParameter(request, prefix	+ "hist_prop_no", length));
			String[] fnlDestLocCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_loc_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] dmdtCtrtExptTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ctrt_expt_tp_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] coverageList = (JSPUtil.getParameter(request, prefix	+ "coverage_list", length));
			String[] scExptPrevVerSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_prev_ver_seq", length));
			String[] scExptFmLocCd = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_loc_cd", length));
			String[] cmdtList = (JSPUtil.getParameter(request, prefix	+ "cmdt_list", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] prcCmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_tp_cd", length));
			String[] fnlDestSteCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_ste_cd", length));
			String[] scExptHistVerSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_hist_ver_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SCExceptionParmVO();
				if (scExptFmContiCd[i] != null)
					model.setScExptFmContiCd(scExptFmContiCd[i]);
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (actCustList[i] != null)
					model.setActCustList(actCustList[i]);
				if (dmdtExptVerStsCd[i] != null)
					model.setDmdtExptVerStsCd(dmdtExptVerStsCd[i]);
				if (chkCalcTpCombined[i] != null)
					model.setChkCalcTpCombined(chkCalcTpCombined[i]);
				if (scExptVerSeq[i] != null)
					model.setScExptVerSeq(scExptVerSeq[i]);
				if (fnlDestRgnCd[i] != null)
					model.setFnlDestRgnCd(fnlDestRgnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (scExptFmRgnCd[i] != null)
					model.setScExptFmRgnCd(scExptFmRgnCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (chkCalcTpIn[i] != null)
					model.setChkCalcTpIn(chkCalcTpIn[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (custType[i] != null)
					model.setCustType(custType[i]);
				if (dmdtCntrCgoTpCd[i] != null)
					model.setDmdtCntrCgoTpCd(dmdtCntrCgoTpCd[i]);
				if (scExptFmCntCd[i] != null)
					model.setScExptFmCntCd(scExptFmCntCd[i]);
				if (scExptFmSteCd[i] != null)
					model.setScExptFmSteCd(scExptFmSteCd[i]);
				if (scExptGrpSeq[i] != null)
					model.setScExptGrpSeq(scExptGrpSeq[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (fnlDestCntCd[i] != null)
					model.setFnlDestCntCd(fnlDestCntCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (histPropNo[i] != null)
					model.setHistPropNo(histPropNo[i]);
				if (fnlDestLocCd[i] != null)
					model.setFnlDestLocCd(fnlDestLocCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (dmdtCtrtExptTpCd[i] != null)
					model.setDmdtCtrtExptTpCd(dmdtCtrtExptTpCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (coverageList[i] != null)
					model.setCoverageList(coverageList[i]);
				if (scExptPrevVerSeq[i] != null)
					model.setScExptPrevVerSeq(scExptPrevVerSeq[i]);
				if (scExptFmLocCd[i] != null)
					model.setScExptFmLocCd(scExptFmLocCd[i]);
				if (cmdtList[i] != null)
					model.setCmdtList(cmdtList[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (prcCmdtTpCd[i] != null)
					model.setPrcCmdtTpCd(prcCmdtTpCd[i]);
				if (fnlDestSteCd[i] != null)
					model.setFnlDestSteCd(fnlDestSteCd[i]);
				if (scExptHistVerSeq[i] != null)
					model.setScExptHistVerSeq(scExptHistVerSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSCExceptionParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SCExceptionParmVO[]
	 */
	public SCExceptionParmVO[] getSCExceptionParmVOs(){
		SCExceptionParmVO[] vos = (SCExceptionParmVO[])models.toArray(new SCExceptionParmVO[models.size()]);
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
		this.scExptFmContiCd = this.scExptFmContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustList = this.actCustList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptVerStsCd = this.dmdtExptVerStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCalcTpCombined = this.chkCalcTpCombined .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptVerSeq = this.scExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestRgnCd = this.fnlDestRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptFmRgnCd = this.scExptFmRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCalcTpIn = this.chkCalcTpIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custType = this.custType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrCgoTpCd = this.dmdtCntrCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptFmCntCd = this.scExptFmCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptFmSteCd = this.scExptFmSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptGrpSeq = this.scExptGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestCntCd = this.fnlDestCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.histPropNo = this.histPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestLocCd = this.fnlDestLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCtrtExptTpCd = this.dmdtCtrtExptTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coverageList = this.coverageList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptPrevVerSeq = this.scExptPrevVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptFmLocCd = this.scExptFmLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtList = this.cmdtList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtTpCd = this.prcCmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestSteCd = this.fnlDestSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptHistVerSeq = this.scExptHistVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
