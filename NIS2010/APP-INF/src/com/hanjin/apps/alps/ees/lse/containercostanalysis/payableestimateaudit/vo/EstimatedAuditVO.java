/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EstimatedAuditVO.java
*@FileTitle : EstimatedAuditVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.10.07 진준성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.vo;

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
 * @author 진준성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EstimatedAuditVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EstimatedAuditVO> models = new ArrayList<EstimatedAuditVO>();
	
	/* Column Info */
	private String opLseDivFlg = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String acctCode = null;
	/* Column Info */
	private String revMonth = null;
	/* Column Info */
	private String ttlTrfAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String hirDtAmt = null;
	/* Column Info */
	private String estimatedCost = null;
	/* Column Info */
	private String sysName = null;
	/* Column Info */
	private String periodStdt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String estBsaQty = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String estQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String tpSz = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String bizUnit = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String actualCost = null;
	/* Column Info */
	private String sltCostAmt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String accuralAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String actualMonth = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String revVvd = null;
	/* Column Info */
	private String periodEddt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EstimatedAuditVO() {}

	public EstimatedAuditVO(String ibflag, String pagerows, String seq, String actualMonth, String sysName, String revMonth, String acctCode, String agmtNo, String bizUnit, String revVvd, String tpSz, String estQty, String estimatedCost, String actualCost, String accuralAmt, String creUsrId, String creDt, String updUsrId, String updDt, String locCd, String opLseDivFlg, String ttlTrfAmt, String agmtCtyCd, String agmtSeq, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String estBsaQty, String sltCostAmt, String custSeq, String hirDtAmt, String periodStdt, String periodEddt) {
		this.opLseDivFlg = opLseDivFlg;
		this.vslCd = vslCd;
		this.acctCode = acctCode;
		this.revMonth = revMonth;
		this.ttlTrfAmt = ttlTrfAmt;
		this.creDt = creDt;
		this.hirDtAmt = hirDtAmt;
		this.estimatedCost = estimatedCost;
		this.sysName = sysName;
		this.periodStdt = periodStdt;
		this.pagerows = pagerows;
		this.estBsaQty = estBsaQty;
		this.revDirCd = revDirCd;
		this.estQty = estQty;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.agmtCtyCd = agmtCtyCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.tpSz = tpSz;
		this.agmtSeq = agmtSeq;
		this.agmtNo = agmtNo;
		this.skdVoyNo = skdVoyNo;
		this.bizUnit = bizUnit;
		this.custSeq = custSeq;
		this.actualCost = actualCost;
		this.sltCostAmt = sltCostAmt;
		this.skdDirCd = skdDirCd;
		this.accuralAmt = accuralAmt;
		this.creUsrId = creUsrId;
		this.actualMonth = actualMonth;
		this.seq = seq;
		this.revVvd = revVvd;
		this.periodEddt = periodEddt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("op_lse_div_flg", getOpLseDivFlg());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("acct_code", getAcctCode());
		this.hashColumns.put("rev_month", getRevMonth());
		this.hashColumns.put("ttl_trf_amt", getTtlTrfAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("hir_dt_amt", getHirDtAmt());
		this.hashColumns.put("estimated_cost", getEstimatedCost());
		this.hashColumns.put("sys_name", getSysName());
		this.hashColumns.put("period_stdt", getPeriodStdt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("est_bsa_qty", getEstBsaQty());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("est_qty", getEstQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("tp_sz", getTpSz());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("biz_unit", getBizUnit());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("actual_cost", getActualCost());
		this.hashColumns.put("slt_cost_amt", getSltCostAmt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("accural_amt", getAccuralAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("actual_month", getActualMonth());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("rev_vvd", getRevVvd());
		this.hashColumns.put("period_eddt", getPeriodEddt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("op_lse_div_flg", "opLseDivFlg");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("acct_code", "acctCode");
		this.hashFields.put("rev_month", "revMonth");
		this.hashFields.put("ttl_trf_amt", "ttlTrfAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("hir_dt_amt", "hirDtAmt");
		this.hashFields.put("estimated_cost", "estimatedCost");
		this.hashFields.put("sys_name", "sysName");
		this.hashFields.put("period_stdt", "periodStdt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("est_bsa_qty", "estBsaQty");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("est_qty", "estQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tp_sz", "tpSz");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("biz_unit", "bizUnit");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("actual_cost", "actualCost");
		this.hashFields.put("slt_cost_amt", "sltCostAmt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("accural_amt", "accuralAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("actual_month", "actualMonth");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("period_eddt", "periodEddt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return opLseDivFlg
	 */
	public String getOpLseDivFlg() {
		return this.opLseDivFlg;
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
	 * @return acctCode
	 */
	public String getAcctCode() {
		return this.acctCode;
	}
	
	/**
	 * Column Info
	 * @return revMonth
	 */
	public String getRevMonth() {
		return this.revMonth;
	}
	
	/**
	 * Column Info
	 * @return ttlTrfAmt
	 */
	public String getTtlTrfAmt() {
		return this.ttlTrfAmt;
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
	 * @return hirDtAmt
	 */
	public String getHirDtAmt() {
		return this.hirDtAmt;
	}
	
	/**
	 * Column Info
	 * @return estimatedCost
	 */
	public String getEstimatedCost() {
		return this.estimatedCost;
	}
	
	/**
	 * Column Info
	 * @return sysName
	 */
	public String getSysName() {
		return this.sysName;
	}
	
	/**
	 * Column Info
	 * @return periodStdt
	 */
	public String getPeriodStdt() {
		return this.periodStdt;
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
	 * @return estBsaQty
	 */
	public String getEstBsaQty() {
		return this.estBsaQty;
	}
	
	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
	}
	
	/**
	 * Column Info
	 * @return estQty
	 */
	public String getEstQty() {
		return this.estQty;
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
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return tpSz
	 */
	public String getTpSz() {
		return this.tpSz;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
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
	 * @return bizUnit
	 */
	public String getBizUnit() {
		return this.bizUnit;
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
	 * @return actualCost
	 */
	public String getActualCost() {
		return this.actualCost;
	}
	
	/**
	 * Column Info
	 * @return sltCostAmt
	 */
	public String getSltCostAmt() {
		return this.sltCostAmt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return accuralAmt
	 */
	public String getAccuralAmt() {
		return this.accuralAmt;
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
	 * @return actualMonth
	 */
	public String getActualMonth() {
		return this.actualMonth;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return revVvd
	 */
	public String getRevVvd() {
		return this.revVvd;
	}
	
	/**
	 * Column Info
	 * @return periodEddt
	 */
	public String getPeriodEddt() {
		return this.periodEddt;
	}
	

	/**
	 * Column Info
	 * @param opLseDivFlg
	 */
	public void setOpLseDivFlg(String opLseDivFlg) {
		this.opLseDivFlg = opLseDivFlg;
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
	 * @param acctCode
	 */
	public void setAcctCode(String acctCode) {
		this.acctCode = acctCode;
	}
	
	/**
	 * Column Info
	 * @param revMonth
	 */
	public void setRevMonth(String revMonth) {
		this.revMonth = revMonth;
	}
	
	/**
	 * Column Info
	 * @param ttlTrfAmt
	 */
	public void setTtlTrfAmt(String ttlTrfAmt) {
		this.ttlTrfAmt = ttlTrfAmt;
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
	 * @param hirDtAmt
	 */
	public void setHirDtAmt(String hirDtAmt) {
		this.hirDtAmt = hirDtAmt;
	}
	
	/**
	 * Column Info
	 * @param estimatedCost
	 */
	public void setEstimatedCost(String estimatedCost) {
		this.estimatedCost = estimatedCost;
	}
	
	/**
	 * Column Info
	 * @param sysName
	 */
	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
	
	/**
	 * Column Info
	 * @param periodStdt
	 */
	public void setPeriodStdt(String periodStdt) {
		this.periodStdt = periodStdt;
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
	 * @param estBsaQty
	 */
	public void setEstBsaQty(String estBsaQty) {
		this.estBsaQty = estBsaQty;
	}
	
	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
	}
	
	/**
	 * Column Info
	 * @param estQty
	 */
	public void setEstQty(String estQty) {
		this.estQty = estQty;
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
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param tpSz
	 */
	public void setTpSz(String tpSz) {
		this.tpSz = tpSz;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
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
	 * @param bizUnit
	 */
	public void setBizUnit(String bizUnit) {
		this.bizUnit = bizUnit;
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
	 * @param actualCost
	 */
	public void setActualCost(String actualCost) {
		this.actualCost = actualCost;
	}
	
	/**
	 * Column Info
	 * @param sltCostAmt
	 */
	public void setSltCostAmt(String sltCostAmt) {
		this.sltCostAmt = sltCostAmt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param accuralAmt
	 */
	public void setAccuralAmt(String accuralAmt) {
		this.accuralAmt = accuralAmt;
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
	 * @param actualMonth
	 */
	public void setActualMonth(String actualMonth) {
		this.actualMonth = actualMonth;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param revVvd
	 */
	public void setRevVvd(String revVvd) {
		this.revVvd = revVvd;
	}
	
	/**
	 * Column Info
	 * @param periodEddt
	 */
	public void setPeriodEddt(String periodEddt) {
		this.periodEddt = periodEddt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOpLseDivFlg(JSPUtil.getParameter(request, "op_lse_div_flg", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setAcctCode(JSPUtil.getParameter(request, "acct_code", ""));
		setRevMonth(JSPUtil.getParameter(request, "rev_month", ""));
		setTtlTrfAmt(JSPUtil.getParameter(request, "ttl_trf_amt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setHirDtAmt(JSPUtil.getParameter(request, "hir_dt_amt", ""));
		setEstimatedCost(JSPUtil.getParameter(request, "estimated_cost", ""));
		setSysName(JSPUtil.getParameter(request, "sys_name", ""));
		setPeriodStdt(JSPUtil.getParameter(request, "period_stdt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEstBsaQty(JSPUtil.getParameter(request, "est_bsa_qty", ""));
		setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
		setEstQty(JSPUtil.getParameter(request, "est_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setTpSz(JSPUtil.getParameter(request, "tp_sz", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setBizUnit(JSPUtil.getParameter(request, "biz_unit", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setActualCost(JSPUtil.getParameter(request, "actual_cost", ""));
		setSltCostAmt(JSPUtil.getParameter(request, "slt_cost_amt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setAccuralAmt(JSPUtil.getParameter(request, "accural_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setActualMonth(JSPUtil.getParameter(request, "actual_month", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
		setPeriodEddt(JSPUtil.getParameter(request, "period_eddt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EstimatedAuditVO[]
	 */
	public EstimatedAuditVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EstimatedAuditVO[]
	 */
	public EstimatedAuditVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EstimatedAuditVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] opLseDivFlg = (JSPUtil.getParameter(request, prefix	+ "op_lse_div_flg", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] acctCode = (JSPUtil.getParameter(request, prefix	+ "acct_code", length));
			String[] revMonth = (JSPUtil.getParameter(request, prefix	+ "rev_month", length));
			String[] ttlTrfAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_trf_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] hirDtAmt = (JSPUtil.getParameter(request, prefix	+ "hir_dt_amt", length));
			String[] estimatedCost = (JSPUtil.getParameter(request, prefix	+ "estimated_cost", length));
			String[] sysName = (JSPUtil.getParameter(request, prefix	+ "sys_name", length));
			String[] periodStdt = (JSPUtil.getParameter(request, prefix	+ "period_stdt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] estBsaQty = (JSPUtil.getParameter(request, prefix	+ "est_bsa_qty", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] estQty = (JSPUtil.getParameter(request, prefix	+ "est_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] tpSz = (JSPUtil.getParameter(request, prefix	+ "tp_sz", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] bizUnit = (JSPUtil.getParameter(request, prefix	+ "biz_unit", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] actualCost = (JSPUtil.getParameter(request, prefix	+ "actual_cost", length));
			String[] sltCostAmt = (JSPUtil.getParameter(request, prefix	+ "slt_cost_amt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] accuralAmt = (JSPUtil.getParameter(request, prefix	+ "accural_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] actualMonth = (JSPUtil.getParameter(request, prefix	+ "actual_month", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd", length));
			String[] periodEddt = (JSPUtil.getParameter(request, prefix	+ "period_eddt", length));
			
			for (int i = 0; i < length; i++) {
				model = new EstimatedAuditVO();
				if (opLseDivFlg[i] != null)
					model.setOpLseDivFlg(opLseDivFlg[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (acctCode[i] != null)
					model.setAcctCode(acctCode[i]);
				if (revMonth[i] != null)
					model.setRevMonth(revMonth[i]);
				if (ttlTrfAmt[i] != null)
					model.setTtlTrfAmt(ttlTrfAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (hirDtAmt[i] != null)
					model.setHirDtAmt(hirDtAmt[i]);
				if (estimatedCost[i] != null)
					model.setEstimatedCost(estimatedCost[i]);
				if (sysName[i] != null)
					model.setSysName(sysName[i]);
				if (periodStdt[i] != null)
					model.setPeriodStdt(periodStdt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (estBsaQty[i] != null)
					model.setEstBsaQty(estBsaQty[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (estQty[i] != null)
					model.setEstQty(estQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (tpSz[i] != null)
					model.setTpSz(tpSz[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bizUnit[i] != null)
					model.setBizUnit(bizUnit[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (actualCost[i] != null)
					model.setActualCost(actualCost[i]);
				if (sltCostAmt[i] != null)
					model.setSltCostAmt(sltCostAmt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (accuralAmt[i] != null)
					model.setAccuralAmt(accuralAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (actualMonth[i] != null)
					model.setActualMonth(actualMonth[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
				if (periodEddt[i] != null)
					model.setPeriodEddt(periodEddt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEstimatedAuditVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EstimatedAuditVO[]
	 */
	public EstimatedAuditVO[] getEstimatedAuditVOs(){
		EstimatedAuditVO[] vos = (EstimatedAuditVO[])models.toArray(new EstimatedAuditVO[models.size()]);
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
		this.opLseDivFlg = this.opLseDivFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCode = this.acctCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revMonth = this.revMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTrfAmt = this.ttlTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirDtAmt = this.hirDtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estimatedCost = this.estimatedCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysName = this.sysName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodStdt = this.periodStdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estBsaQty = this.estBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estQty = this.estQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpSz = this.tpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizUnit = this.bizUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actualCost = this.actualCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltCostAmt = this.sltCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accuralAmt = this.accuralAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actualMonth = this.actualMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodEddt = this.periodEddt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
