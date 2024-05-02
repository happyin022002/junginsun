/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ExceptionChargeCalculationVO.java
*@FileTitle : ExceptionChargeCalculationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.24
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2013.01.24 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExceptionChargeCalculationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExceptionChargeCalculationVO> models = new ArrayList<ExceptionChargeCalculationVO>();
	
	/* Column Info */
	private String exptCntrTeuKnt = null;
	/* Column Info */
	private String incurCntrTeuKnt = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String ydExptCostSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String chgSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String exptTrfRtAdjAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String incurQty = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String exptFtEndDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String exptCostAmt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String incurAmt = null;
	/* Column Info */
	private String dmdtBzcFtEndDt = null;
	/* Column Info */
	private String exptFtAmt = null;
	/* Column Info */
	private String exptQty = null;
	/* Column Info */
	private String exptDys = null;
	/* Column Info */
	private String dmdtChgStsCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExceptionChargeCalculationVO() {}

	public ExceptionChargeCalculationVO(String ibflag, String pagerows, String exptCntrTeuKnt, String incurCntrTeuKnt, String cntrCycNo, String ydExptCostSeq, String creDt, String chgSeq, String exptTrfRtAdjAmt, String bkgQty, String creOfcCd, String incurQty, String updOfcCd, String updUsrId, String dmdtTrfCd, String exptFtEndDt, String updDt, String dmdtChgLocDivCd, String exptCostAmt, String bkgNo, String creUsrId, String ydCd, String cntrNo, String incurAmt, String dmdtBzcFtEndDt, String exptQty, String exptFtAmt, String exptDys, String ofcCd, String cntrTpszCd, String dmdtChgStsCd) {
		this.exptCntrTeuKnt = exptCntrTeuKnt;
		this.incurCntrTeuKnt = incurCntrTeuKnt;
		this.cntrCycNo = cntrCycNo;
		this.ydExptCostSeq = ydExptCostSeq;
		this.creDt = creDt;
		this.chgSeq = chgSeq;
		this.pagerows = pagerows;
		this.exptTrfRtAdjAmt = exptTrfRtAdjAmt;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.bkgQty = bkgQty;
		this.cntrTpszCd = cntrTpszCd;
		this.incurQty = incurQty;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.dmdtTrfCd = dmdtTrfCd;
		this.exptFtEndDt = exptFtEndDt;
		this.updDt = updDt;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.exptCostAmt = exptCostAmt;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.incurAmt = incurAmt;
		this.dmdtBzcFtEndDt = dmdtBzcFtEndDt;
		this.exptFtAmt = exptFtAmt;
		this.exptQty = exptQty;
		this.exptDys = exptDys;
		this.dmdtChgStsCd = dmdtChgStsCd;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("expt_cntr_teu_knt", getExptCntrTeuKnt());
		this.hashColumns.put("incur_cntr_teu_knt", getIncurCntrTeuKnt());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("yd_expt_cost_seq", getYdExptCostSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("expt_trf_rt_adj_amt", getExptTrfRtAdjAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("incur_qty", getIncurQty());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("expt_ft_end_dt", getExptFtEndDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("expt_cost_amt", getExptCostAmt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("incur_amt", getIncurAmt());
		this.hashColumns.put("dmdt_bzc_ft_end_dt", getDmdtBzcFtEndDt());
		this.hashColumns.put("expt_ft_amt", getExptFtAmt());
		this.hashColumns.put("expt_qty", getExptQty());
		this.hashColumns.put("expt_dys", getExptDys());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("expt_cntr_teu_knt", "exptCntrTeuKnt");
		this.hashFields.put("incur_cntr_teu_knt", "incurCntrTeuKnt");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("yd_expt_cost_seq", "ydExptCostSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("expt_trf_rt_adj_amt", "exptTrfRtAdjAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("incur_qty", "incurQty");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("expt_ft_end_dt", "exptFtEndDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("expt_cost_amt", "exptCostAmt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("incur_amt", "incurAmt");
		this.hashFields.put("dmdt_bzc_ft_end_dt", "dmdtBzcFtEndDt");
		this.hashFields.put("expt_ft_amt", "exptFtAmt");
		this.hashFields.put("expt_qty", "exptQty");
		this.hashFields.put("expt_dys", "exptDys");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return exptCntrTeuKnt
	 */
	public String getExptCntrTeuKnt() {
		return this.exptCntrTeuKnt;
	}
	
	/**
	 * Column Info
	 * @return incurCntrTeuKnt
	 */
	public String getIncurCntrTeuKnt() {
		return this.incurCntrTeuKnt;
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
	 * @return ydExptCostSeq
	 */
	public String getYdExptCostSeq() {
		return this.ydExptCostSeq;
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
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
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
	 * @return exptTrfRtAdjAmt
	 */
	public String getExptTrfRtAdjAmt() {
		return this.exptTrfRtAdjAmt;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgQty
	 */
	public String getBkgQty() {
		return this.bkgQty;
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
	 * @return incurQty
	 */
	public String getIncurQty() {
		return this.incurQty;
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
	 * @return exptFtEndDt
	 */
	public String getExptFtEndDt() {
		return this.exptFtEndDt;
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
	 * @return exptCostAmt
	 */
	public String getExptCostAmt() {
		return this.exptCostAmt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return incurAmt
	 */
	public String getIncurAmt() {
		return this.incurAmt;
	}
	
	/**
	 * Column Info
	 * @return dmdtBzcFtEndDt
	 */
	public String getDmdtBzcFtEndDt() {
		return this.dmdtBzcFtEndDt;
	}
	
	/**
	 * Column Info
	 * @return exptFtAmt
	 */
	public String getExptFtAmt() {
		return this.exptFtAmt;
	}
	
	/**
	 * Column Info
	 * @return exptQty
	 */
	public String getExptQty() {
		return this.exptQty;
	}
	
	/**
	 * Column Info
	 * @return exptDys
	 */
	public String getExptDys() {
		return this.exptDys;
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
	 * @param exptCntrTeuKnt
	 */
	public void setExptCntrTeuKnt(String exptCntrTeuKnt) {
		this.exptCntrTeuKnt = exptCntrTeuKnt;
	}
	
	/**
	 * Column Info
	 * @param incurCntrTeuKnt
	 */
	public void setIncurCntrTeuKnt(String incurCntrTeuKnt) {
		this.incurCntrTeuKnt = incurCntrTeuKnt;
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
	 * @param ydExptCostSeq
	 */
	public void setYdExptCostSeq(String ydExptCostSeq) {
		this.ydExptCostSeq = ydExptCostSeq;
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
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
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
	 * @param exptTrfRtAdjAmt
	 */
	public void setExptTrfRtAdjAmt(String exptTrfRtAdjAmt) {
		this.exptTrfRtAdjAmt = exptTrfRtAdjAmt;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgQty
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
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
	 * @param incurQty
	 */
	public void setIncurQty(String incurQty) {
		this.incurQty = incurQty;
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
	 * @param exptFtEndDt
	 */
	public void setExptFtEndDt(String exptFtEndDt) {
		this.exptFtEndDt = exptFtEndDt;
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
	 * @param exptCostAmt
	 */
	public void setExptCostAmt(String exptCostAmt) {
		this.exptCostAmt = exptCostAmt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param incurAmt
	 */
	public void setIncurAmt(String incurAmt) {
		this.incurAmt = incurAmt;
	}
	
	/**
	 * Column Info
	 * @param dmdtBzcFtEndDt
	 */
	public void setDmdtBzcFtEndDt(String dmdtBzcFtEndDt) {
		this.dmdtBzcFtEndDt = dmdtBzcFtEndDt;
	}
	
	/**
	 * Column Info
	 * @param exptFtAmt
	 */
	public void setExptFtAmt(String exptFtAmt) {
		this.exptFtAmt = exptFtAmt;
	}
	
	/**
	 * Column Info
	 * @param exptQty
	 */
	public void setExptQty(String exptQty) {
		this.exptQty = exptQty;
	}
	
	/**
	 * Column Info
	 * @param exptDys
	 */
	public void setExptDys(String exptDys) {
		this.exptDys = exptDys;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgStsCd
	 */
	public void setDmdtChgStsCd(String dmdtChgStsCd) {
		this.dmdtChgStsCd = dmdtChgStsCd;
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
		setExptCntrTeuKnt(JSPUtil.getParameter(request, prefix + "expt_cntr_teu_knt", ""));
		setIncurCntrTeuKnt(JSPUtil.getParameter(request, prefix + "incur_cntr_teu_knt", ""));
		setCntrCycNo(JSPUtil.getParameter(request, prefix + "cntr_cyc_no", ""));
		setYdExptCostSeq(JSPUtil.getParameter(request, prefix + "yd_expt_cost_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setExptTrfRtAdjAmt(JSPUtil.getParameter(request, prefix + "expt_trf_rt_adj_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setBkgQty(JSPUtil.getParameter(request, prefix + "bkg_qty", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setIncurQty(JSPUtil.getParameter(request, prefix + "incur_qty", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setExptFtEndDt(JSPUtil.getParameter(request, prefix + "expt_ft_end_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
		setExptCostAmt(JSPUtil.getParameter(request, prefix + "expt_cost_amt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setIncurAmt(JSPUtil.getParameter(request, prefix + "incur_amt", ""));
		setDmdtBzcFtEndDt(JSPUtil.getParameter(request, prefix + "dmdt_bzc_ft_end_dt", ""));
		setExptFtAmt(JSPUtil.getParameter(request, prefix + "expt_ft_amt", ""));
		setExptQty(JSPUtil.getParameter(request, prefix + "expt_qty", ""));
		setExptDys(JSPUtil.getParameter(request, prefix + "expt_dys", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExceptionChargeCalculationVO[]
	 */
	public ExceptionChargeCalculationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExceptionChargeCalculationVO[]
	 */
	public ExceptionChargeCalculationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExceptionChargeCalculationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] exptCntrTeuKnt = (JSPUtil.getParameter(request, prefix	+ "expt_cntr_teu_knt", length));
			String[] incurCntrTeuKnt = (JSPUtil.getParameter(request, prefix	+ "incur_cntr_teu_knt", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] ydExptCostSeq = (JSPUtil.getParameter(request, prefix	+ "yd_expt_cost_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] exptTrfRtAdjAmt = (JSPUtil.getParameter(request, prefix	+ "expt_trf_rt_adj_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] incurQty = (JSPUtil.getParameter(request, prefix	+ "incur_qty", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] exptFtEndDt = (JSPUtil.getParameter(request, prefix	+ "expt_ft_end_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] exptCostAmt = (JSPUtil.getParameter(request, prefix	+ "expt_cost_amt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] incurAmt = (JSPUtil.getParameter(request, prefix	+ "incur_amt", length));
			String[] dmdtBzcFtEndDt = (JSPUtil.getParameter(request, prefix	+ "dmdt_bzc_ft_end_dt", length));
			String[] exptFtAmt = (JSPUtil.getParameter(request, prefix	+ "expt_ft_amt", length));
			String[] exptQty = (JSPUtil.getParameter(request, prefix	+ "expt_qty", length));
			String[] exptDys = (JSPUtil.getParameter(request, prefix	+ "expt_dys", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ExceptionChargeCalculationVO();
				if (exptCntrTeuKnt[i] != null)
					model.setExptCntrTeuKnt(exptCntrTeuKnt[i]);
				if (incurCntrTeuKnt[i] != null)
					model.setIncurCntrTeuKnt(incurCntrTeuKnt[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (ydExptCostSeq[i] != null)
					model.setYdExptCostSeq(ydExptCostSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (exptTrfRtAdjAmt[i] != null)
					model.setExptTrfRtAdjAmt(exptTrfRtAdjAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (incurQty[i] != null)
					model.setIncurQty(incurQty[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (exptFtEndDt[i] != null)
					model.setExptFtEndDt(exptFtEndDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (exptCostAmt[i] != null)
					model.setExptCostAmt(exptCostAmt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (incurAmt[i] != null)
					model.setIncurAmt(incurAmt[i]);
				if (dmdtBzcFtEndDt[i] != null)
					model.setDmdtBzcFtEndDt(dmdtBzcFtEndDt[i]);
				if (exptFtAmt[i] != null)
					model.setExptFtAmt(exptFtAmt[i]);
				if (exptQty[i] != null)
					model.setExptQty(exptQty[i]);
				if (exptDys[i] != null)
					model.setExptDys(exptDys[i]);
				if (dmdtChgStsCd[i] != null)
					model.setDmdtChgStsCd(dmdtChgStsCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExceptionChargeCalculationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExceptionChargeCalculationVO[]
	 */
	public ExceptionChargeCalculationVO[] getExceptionChargeCalculationVOs(){
		ExceptionChargeCalculationVO[] vos = (ExceptionChargeCalculationVO[])models.toArray(new ExceptionChargeCalculationVO[models.size()]);
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
		this.exptCntrTeuKnt = this.exptCntrTeuKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incurCntrTeuKnt = this.incurCntrTeuKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydExptCostSeq = this.ydExptCostSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptTrfRtAdjAmt = this.exptTrfRtAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incurQty = this.incurQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptFtEndDt = this.exptFtEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptCostAmt = this.exptCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incurAmt = this.incurAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBzcFtEndDt = this.dmdtBzcFtEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptFtAmt = this.exptFtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptQty = this.exptQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptDys = this.exptDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
