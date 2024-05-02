/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InterfaceChargeCalculationVO.java
*@FileTitle : InterfaceChargeCalculationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.12  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InterfaceChargeCalculationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InterfaceChargeCalculationVO> models = new ArrayList<InterfaceChargeCalculationVO>();
	
	/* Column Info */
	private String srcIfSeq = null;
	/* Column Info */
	private String bzcTrfCurrCd = null;
	/* Column Info */
	private String dulTpExptFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String ofcTrnsFlg = null;
	/* Column Info */
	private String scRfaExptAmt = null;
	/* Column Info */
	private String aftExptDcAmt = null;
	/* Column Info */
	private String scExptVerSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dmdtTrfAplyTpCd = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String srcIfDt = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fxFtOvrDys = null;
	/* Column Info */
	private String svrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rfaExptMapgSeq = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rfaExptDarNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String rfaRqstDtlSeq = null;
	/* Column Info */
	private String rfaExptVerSeq = null;
	/* Column Info */
	private String bzcTrfGrpSeq = null;
	/* Column Info */
	private String cmdtExptAmt = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String perTpCd = null;
	/* Column Info */
	private String scExptGrpSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String orgFtOvrDys = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String invDtlSeq = null;
	/* Column Info */
	private String bzcTrfSeq = null;
	/* Column Info */
	private String tvaFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InterfaceChargeCalculationVO() {}

	public InterfaceChargeCalculationVO(String ibflag, String pagerows, String srcIfDt, String srcIfSeq, String chgSeq, String currCd, String chgCd, String perTpCd, String trfNo, String tvaFlg, String creUsrId, String creDt, String updUsrId, String updDt, String svrId, String cntrNo, String cntrCycNo, String dmdtTrfCd, String dmdtChgLocDivCd, String dmdtTrfAplyTpCd, String bzcTrfSeq, String bzcTrfGrpSeq, String cntrTpszCd, String fxFtOvrDys, String bzcTrfCurrCd, String rfaExptDarNo, String rfaExptMapgSeq, String rfaExptVerSeq, String rfaRqstDtlSeq, String scNo, String scExptVerSeq, String scExptGrpSeq, String invDtlSeq, String creOfcCd, String invXchRt, String scRfaExptAmt, String aftExptDcAmt, String orgFtOvrDys, String cmdtExptAmt, String dulTpExptFlg, String ofcTrnsFlg, String bkgNo) {
		this.srcIfSeq = srcIfSeq;
		this.bzcTrfCurrCd = bzcTrfCurrCd;
		this.dulTpExptFlg = dulTpExptFlg;
		this.currCd = currCd;
		this.cntrCycNo = cntrCycNo;
		this.ofcTrnsFlg = ofcTrnsFlg;
		this.scRfaExptAmt = scRfaExptAmt;
		this.aftExptDcAmt = aftExptDcAmt;
		this.scExptVerSeq = scExptVerSeq;
		this.creDt = creDt;
		this.dmdtTrfAplyTpCd = dmdtTrfAplyTpCd;
		this.chgSeq = chgSeq;
		this.srcIfDt = srcIfDt;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.fxFtOvrDys = fxFtOvrDys;
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.rfaExptMapgSeq = rfaExptMapgSeq;
		this.creOfcCd = creOfcCd;
		this.scNo = scNo;
		this.rfaExptDarNo = rfaExptDarNo;
		this.cntrTpszCd = cntrTpszCd;
		this.rfaRqstDtlSeq = rfaRqstDtlSeq;
		this.rfaExptVerSeq = rfaExptVerSeq;
		this.bzcTrfGrpSeq = bzcTrfGrpSeq;
		this.cmdtExptAmt = cmdtExptAmt;
		this.invXchRt = invXchRt;
		this.updUsrId = updUsrId;
		this.dmdtTrfCd = dmdtTrfCd;
		this.updDt = updDt;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.perTpCd = perTpCd;
		this.scExptGrpSeq = scExptGrpSeq;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.orgFtOvrDys = orgFtOvrDys;
		this.trfNo = trfNo;
		this.cntrNo = cntrNo;
		this.invDtlSeq = invDtlSeq;
		this.bzcTrfSeq = bzcTrfSeq;
		this.tvaFlg = tvaFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("src_if_seq", getSrcIfSeq());
		this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd());
		this.hashColumns.put("dul_tp_expt_flg", getDulTpExptFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("ofc_trns_flg", getOfcTrnsFlg());
		this.hashColumns.put("sc_rfa_expt_amt", getScRfaExptAmt());
		this.hashColumns.put("aft_expt_dc_amt", getAftExptDcAmt());
		this.hashColumns.put("sc_expt_ver_seq", getScExptVerSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dmdt_trf_aply_tp_cd", getDmdtTrfAplyTpCd());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("src_if_dt", getSrcIfDt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rfa_expt_mapg_seq", getRfaExptMapgSeq());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rfa_expt_dar_no", getRfaExptDarNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("rfa_rqst_dtl_seq", getRfaRqstDtlSeq());
		this.hashColumns.put("rfa_expt_ver_seq", getRfaExptVerSeq());
		this.hashColumns.put("bzc_trf_grp_seq", getBzcTrfGrpSeq());
		this.hashColumns.put("cmdt_expt_amt", getCmdtExptAmt());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("per_tp_cd", getPerTpCd());
		this.hashColumns.put("sc_expt_grp_seq", getScExptGrpSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("org_ft_ovr_dys", getOrgFtOvrDys());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("inv_dtl_seq", getInvDtlSeq());
		this.hashColumns.put("bzc_trf_seq", getBzcTrfSeq());
		this.hashColumns.put("tva_flg", getTvaFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("src_if_seq", "srcIfSeq");
		this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
		this.hashFields.put("dul_tp_expt_flg", "dulTpExptFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("ofc_trns_flg", "ofcTrnsFlg");
		this.hashFields.put("sc_rfa_expt_amt", "scRfaExptAmt");
		this.hashFields.put("aft_expt_dc_amt", "aftExptDcAmt");
		this.hashFields.put("sc_expt_ver_seq", "scExptVerSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dmdt_trf_aply_tp_cd", "dmdtTrfAplyTpCd");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("src_if_dt", "srcIfDt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rfa_expt_mapg_seq", "rfaExptMapgSeq");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rfa_expt_dar_no", "rfaExptDarNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("rfa_rqst_dtl_seq", "rfaRqstDtlSeq");
		this.hashFields.put("rfa_expt_ver_seq", "rfaExptVerSeq");
		this.hashFields.put("bzc_trf_grp_seq", "bzcTrfGrpSeq");
		this.hashFields.put("cmdt_expt_amt", "cmdtExptAmt");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("per_tp_cd", "perTpCd");
		this.hashFields.put("sc_expt_grp_seq", "scExptGrpSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("org_ft_ovr_dys", "orgFtOvrDys");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("inv_dtl_seq", "invDtlSeq");
		this.hashFields.put("bzc_trf_seq", "bzcTrfSeq");
		this.hashFields.put("tva_flg", "tvaFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return srcIfSeq
	 */
	public String getSrcIfSeq() {
		return this.srcIfSeq;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfCurrCd
	 */
	public String getBzcTrfCurrCd() {
		return this.bzcTrfCurrCd;
	}
	
	/**
	 * Column Info
	 * @return dulTpExptFlg
	 */
	public String getDulTpExptFlg() {
		return this.dulTpExptFlg;
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
	 * @return cntrCycNo
	 */
	public String getCntrCycNo() {
		return this.cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @return ofcTrnsFlg
	 */
	public String getOfcTrnsFlg() {
		return this.ofcTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @return scRfaExptAmt
	 */
	public String getScRfaExptAmt() {
		return this.scRfaExptAmt;
	}
	
	/**
	 * Column Info
	 * @return aftExptDcAmt
	 */
	public String getAftExptDcAmt() {
		return this.aftExptDcAmt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfAplyTpCd
	 */
	public String getDmdtTrfAplyTpCd() {
		return this.dmdtTrfAplyTpCd;
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
	 * @return srcIfDt
	 */
	public String getSrcIfDt() {
		return this.srcIfDt;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return rfaExptMapgSeq
	 */
	public String getRfaExptMapgSeq() {
		return this.rfaExptMapgSeq;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return rfaExptDarNo
	 */
	public String getRfaExptDarNo() {
		return this.rfaExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return rfaRqstDtlSeq
	 */
	public String getRfaRqstDtlSeq() {
		return this.rfaRqstDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return rfaExptVerSeq
	 */
	public String getRfaExptVerSeq() {
		return this.rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfGrpSeq
	 */
	public String getBzcTrfGrpSeq() {
		return this.bzcTrfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtExptAmt
	 */
	public String getCmdtExptAmt() {
		return this.cmdtExptAmt;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
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
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgLocDivCd
	 */
	public String getDmdtChgLocDivCd() {
		return this.dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return perTpCd
	 */
	public String getPerTpCd() {
		return this.perTpCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return orgFtOvrDys
	 */
	public String getOrgFtOvrDys() {
		return this.orgFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
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
	 * @return invDtlSeq
	 */
	public String getInvDtlSeq() {
		return this.invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfSeq
	 */
	public String getBzcTrfSeq() {
		return this.bzcTrfSeq;
	}
	
	/**
	 * Column Info
	 * @return tvaFlg
	 */
	public String getTvaFlg() {
		return this.tvaFlg;
	}
	

	/**
	 * Column Info
	 * @param srcIfSeq
	 */
	public void setSrcIfSeq(String srcIfSeq) {
		this.srcIfSeq = srcIfSeq;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfCurrCd
	 */
	public void setBzcTrfCurrCd(String bzcTrfCurrCd) {
		this.bzcTrfCurrCd = bzcTrfCurrCd;
	}
	
	/**
	 * Column Info
	 * @param dulTpExptFlg
	 */
	public void setDulTpExptFlg(String dulTpExptFlg) {
		this.dulTpExptFlg = dulTpExptFlg;
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
	 * @param cntrCycNo
	 */
	public void setCntrCycNo(String cntrCycNo) {
		this.cntrCycNo = cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @param ofcTrnsFlg
	 */
	public void setOfcTrnsFlg(String ofcTrnsFlg) {
		this.ofcTrnsFlg = ofcTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @param scRfaExptAmt
	 */
	public void setScRfaExptAmt(String scRfaExptAmt) {
		this.scRfaExptAmt = scRfaExptAmt;
	}
	
	/**
	 * Column Info
	 * @param aftExptDcAmt
	 */
	public void setAftExptDcAmt(String aftExptDcAmt) {
		this.aftExptDcAmt = aftExptDcAmt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfAplyTpCd
	 */
	public void setDmdtTrfAplyTpCd(String dmdtTrfAplyTpCd) {
		this.dmdtTrfAplyTpCd = dmdtTrfAplyTpCd;
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
	 * @param srcIfDt
	 */
	public void setSrcIfDt(String srcIfDt) {
		this.srcIfDt = srcIfDt;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param rfaExptMapgSeq
	 */
	public void setRfaExptMapgSeq(String rfaExptMapgSeq) {
		this.rfaExptMapgSeq = rfaExptMapgSeq;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param rfaExptDarNo
	 */
	public void setRfaExptDarNo(String rfaExptDarNo) {
		this.rfaExptDarNo = rfaExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param rfaRqstDtlSeq
	 */
	public void setRfaRqstDtlSeq(String rfaRqstDtlSeq) {
		this.rfaRqstDtlSeq = rfaRqstDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param rfaExptVerSeq
	 */
	public void setRfaExptVerSeq(String rfaExptVerSeq) {
		this.rfaExptVerSeq = rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfGrpSeq
	 */
	public void setBzcTrfGrpSeq(String bzcTrfGrpSeq) {
		this.bzcTrfGrpSeq = bzcTrfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtExptAmt
	 */
	public void setCmdtExptAmt(String cmdtExptAmt) {
		this.cmdtExptAmt = cmdtExptAmt;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
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
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgLocDivCd
	 */
	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param perTpCd
	 */
	public void setPerTpCd(String perTpCd) {
		this.perTpCd = perTpCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param orgFtOvrDys
	 */
	public void setOrgFtOvrDys(String orgFtOvrDys) {
		this.orgFtOvrDys = orgFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
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
	 * @param invDtlSeq
	 */
	public void setInvDtlSeq(String invDtlSeq) {
		this.invDtlSeq = invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfSeq
	 */
	public void setBzcTrfSeq(String bzcTrfSeq) {
		this.bzcTrfSeq = bzcTrfSeq;
	}
	
	/**
	 * Column Info
	 * @param tvaFlg
	 */
	public void setTvaFlg(String tvaFlg) {
		this.tvaFlg = tvaFlg;
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
		setSrcIfSeq(JSPUtil.getParameter(request, prefix + "src_if_seq", ""));
		setBzcTrfCurrCd(JSPUtil.getParameter(request, prefix + "bzc_trf_curr_cd", ""));
		setDulTpExptFlg(JSPUtil.getParameter(request, prefix + "dul_tp_expt_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCntrCycNo(JSPUtil.getParameter(request, prefix + "cntr_cyc_no", ""));
		setOfcTrnsFlg(JSPUtil.getParameter(request, prefix + "ofc_trns_flg", ""));
		setScRfaExptAmt(JSPUtil.getParameter(request, prefix + "sc_rfa_expt_amt", ""));
		setAftExptDcAmt(JSPUtil.getParameter(request, prefix + "aft_expt_dc_amt", ""));
		setScExptVerSeq(JSPUtil.getParameter(request, prefix + "sc_expt_ver_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDmdtTrfAplyTpCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_aply_tp_cd", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setSrcIfDt(JSPUtil.getParameter(request, prefix + "src_if_dt", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFxFtOvrDys(JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRfaExptMapgSeq(JSPUtil.getParameter(request, prefix + "rfa_expt_mapg_seq", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setRfaExptDarNo(JSPUtil.getParameter(request, prefix + "rfa_expt_dar_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setRfaRqstDtlSeq(JSPUtil.getParameter(request, prefix + "rfa_rqst_dtl_seq", ""));
		setRfaExptVerSeq(JSPUtil.getParameter(request, prefix + "rfa_expt_ver_seq", ""));
		setBzcTrfGrpSeq(JSPUtil.getParameter(request, prefix + "bzc_trf_grp_seq", ""));
		setCmdtExptAmt(JSPUtil.getParameter(request, prefix + "cmdt_expt_amt", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
		setPerTpCd(JSPUtil.getParameter(request, prefix + "per_tp_cd", ""));
		setScExptGrpSeq(JSPUtil.getParameter(request, prefix + "sc_expt_grp_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setOrgFtOvrDys(JSPUtil.getParameter(request, prefix + "org_ft_ovr_dys", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setInvDtlSeq(JSPUtil.getParameter(request, prefix + "inv_dtl_seq", ""));
		setBzcTrfSeq(JSPUtil.getParameter(request, prefix + "bzc_trf_seq", ""));
		setTvaFlg(JSPUtil.getParameter(request, prefix + "tva_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InterfaceChargeCalculationVO[]
	 */
	public InterfaceChargeCalculationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InterfaceChargeCalculationVO[]
	 */
	public InterfaceChargeCalculationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InterfaceChargeCalculationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] srcIfSeq = (JSPUtil.getParameter(request, prefix	+ "src_if_seq", length));
			String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_curr_cd", length));
			String[] dulTpExptFlg = (JSPUtil.getParameter(request, prefix	+ "dul_tp_expt_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] ofcTrnsFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_trns_flg", length));
			String[] scRfaExptAmt = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_amt", length));
			String[] aftExptDcAmt = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dc_amt", length));
			String[] scExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_ver_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dmdtTrfAplyTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_aply_tp_cd", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] srcIfDt = (JSPUtil.getParameter(request, prefix	+ "src_if_dt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "fx_ft_ovr_dys", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rfaExptMapgSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_mapg_seq", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rfaExptDarNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_dar_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] rfaRqstDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_rqst_dtl_seq", length));
			String[] rfaExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_ver_seq", length));
			String[] bzcTrfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_grp_seq", length));
			String[] cmdtExptAmt = (JSPUtil.getParameter(request, prefix	+ "cmdt_expt_amt", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] perTpCd = (JSPUtil.getParameter(request, prefix	+ "per_tp_cd", length));
			String[] scExptGrpSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_grp_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] orgFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "org_ft_ovr_dys", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] invDtlSeq = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_seq", length));
			String[] bzcTrfSeq = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_seq", length));
			String[] tvaFlg = (JSPUtil.getParameter(request, prefix	+ "tva_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new InterfaceChargeCalculationVO();
				if (srcIfSeq[i] != null)
					model.setSrcIfSeq(srcIfSeq[i]);
				if (bzcTrfCurrCd[i] != null)
					model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
				if (dulTpExptFlg[i] != null)
					model.setDulTpExptFlg(dulTpExptFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (ofcTrnsFlg[i] != null)
					model.setOfcTrnsFlg(ofcTrnsFlg[i]);
				if (scRfaExptAmt[i] != null)
					model.setScRfaExptAmt(scRfaExptAmt[i]);
				if (aftExptDcAmt[i] != null)
					model.setAftExptDcAmt(aftExptDcAmt[i]);
				if (scExptVerSeq[i] != null)
					model.setScExptVerSeq(scExptVerSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dmdtTrfAplyTpCd[i] != null)
					model.setDmdtTrfAplyTpCd(dmdtTrfAplyTpCd[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (srcIfDt[i] != null)
					model.setSrcIfDt(srcIfDt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fxFtOvrDys[i] != null)
					model.setFxFtOvrDys(fxFtOvrDys[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rfaExptMapgSeq[i] != null)
					model.setRfaExptMapgSeq(rfaExptMapgSeq[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rfaExptDarNo[i] != null)
					model.setRfaExptDarNo(rfaExptDarNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (rfaRqstDtlSeq[i] != null)
					model.setRfaRqstDtlSeq(rfaRqstDtlSeq[i]);
				if (rfaExptVerSeq[i] != null)
					model.setRfaExptVerSeq(rfaExptVerSeq[i]);
				if (bzcTrfGrpSeq[i] != null)
					model.setBzcTrfGrpSeq(bzcTrfGrpSeq[i]);
				if (cmdtExptAmt[i] != null)
					model.setCmdtExptAmt(cmdtExptAmt[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (perTpCd[i] != null)
					model.setPerTpCd(perTpCd[i]);
				if (scExptGrpSeq[i] != null)
					model.setScExptGrpSeq(scExptGrpSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (orgFtOvrDys[i] != null)
					model.setOrgFtOvrDys(orgFtOvrDys[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (invDtlSeq[i] != null)
					model.setInvDtlSeq(invDtlSeq[i]);
				if (bzcTrfSeq[i] != null)
					model.setBzcTrfSeq(bzcTrfSeq[i]);
				if (tvaFlg[i] != null)
					model.setTvaFlg(tvaFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInterfaceChargeCalculationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InterfaceChargeCalculationVO[]
	 */
	public InterfaceChargeCalculationVO[] getInterfaceChargeCalculationVOs(){
		InterfaceChargeCalculationVO[] vos = (InterfaceChargeCalculationVO[])models.toArray(new InterfaceChargeCalculationVO[models.size()]);
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
		this.srcIfSeq = this.srcIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfCurrCd = this.bzcTrfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dulTpExptFlg = this.dulTpExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTrnsFlg = this.ofcTrnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptAmt = this.scRfaExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDcAmt = this.aftExptDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptVerSeq = this.scExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfAplyTpCd = this.dmdtTrfAplyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcIfDt = this.srcIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxFtOvrDys = this.fxFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptMapgSeq = this.rfaExptMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptDarNo = this.rfaExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaRqstDtlSeq = this.rfaRqstDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptVerSeq = this.rfaExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfGrpSeq = this.bzcTrfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtExptAmt = this.cmdtExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTpCd = this.perTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptGrpSeq = this.scExptGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFtOvrDys = this.orgFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlSeq = this.invDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfSeq = this.bzcTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaFlg = this.tvaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
