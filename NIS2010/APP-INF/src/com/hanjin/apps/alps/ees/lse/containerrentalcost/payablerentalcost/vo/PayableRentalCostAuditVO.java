/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostAuditVO.java
*@FileTitle : PayableRentalCostAuditVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.10.01 노정용 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo;

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
 * @author 노정용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PayableRentalCostAuditVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PayableRentalCostAuditVO> models = new ArrayList<PayableRentalCostAuditVO>();
	
	/* Column Info */
	private String dscrPdRtAmt = null;
	/* Column Info */
	private String offhLocCd = null;
	/* Column Info */
	private String pdRtAmt = null;
	/* Column Info */
	private String lsePayChgTpCd = null;
	/* Column Info */
	private String dscrOnhDt = null;
	/* Column Info */
	private String chgCostYrmon = null;
	/* Column Info */
	private String dscrOffhDt = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String dscrCostAmt = null;
	/* Column Info */
	private String onhDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lseCtrtNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String crNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String costDys = null;
	/* Column Info */
	private String offhDt = null;
	/* Column Info */
	private String bilDys = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String onhLocCd = null;
	/* Column Info */
	private String ttlCostAmt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String dscrOnhLocCd = null;
	/* Column Info */
	private String chgFreeDys = null;
	/* Column Info */
	private String dtlSeq = null;
	/* Column Info */
	private String cntrAudStsCd = null;
	/* Column Info */
	private String dscrOffhLocCd = null;
	/* Column Info */
	private String dscrRtAmt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String payChgStsCd = null;
	/* Column Info */
	private String lsePayChgTpNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PayableRentalCostAuditVO() {}

	public PayableRentalCostAuditVO(String ibflag, String pagerows, String chgCostYrmon, String chgSeq, String agmtCtyCd, String agmtSeq, String invNo, 
			                        String cntrNo, String cntrTpszCd, String agmtNo, String lseCtrtNo, String lsePayChgTpCd, String onhDt, 
			                        String onhLocCd, String offhDt, String offhLocCd, String costDys, String chgFreeDys, String bilDys, String pdRtAmt, 
			                        String ttlCostAmt, String crAmt, String crNo, String dscrOnhDt, String dscrOnhLocCd, String dscrOffhDt, String dscrPdRtAmt, 
			                        String dscrCostAmt, String dtlSeq, String cntrAudStsCd, String dscrOffhLocCd, String dscrRtAmt, String usrId,
			                        String payChgStsCd, String lsePayChgTpNm) {
		this.cntrAudStsCd = cntrAudStsCd;
		this.dscrOffhLocCd = dscrOffhLocCd;
		this.dscrRtAmt = dscrRtAmt;
		this.dscrPdRtAmt = dscrPdRtAmt;
		this.offhLocCd = offhLocCd;
		this.pdRtAmt = pdRtAmt;
		this.lsePayChgTpCd = lsePayChgTpCd;
		this.dscrOnhDt = dscrOnhDt;
		this.chgCostYrmon = chgCostYrmon;
		this.dscrOffhDt = dscrOffhDt;
		this.chgSeq = chgSeq;
		this.dscrCostAmt = dscrCostAmt;
		this.onhDt = onhDt;
		this.pagerows = pagerows;
		this.lseCtrtNo = lseCtrtNo;
		this.ibflag = ibflag;
		this.crAmt = crAmt;
		this.crNo = crNo;
		this.cntrTpszCd = cntrTpszCd;
		this.agmtCtyCd = agmtCtyCd;
		this.costDys = costDys;
		this.offhDt = offhDt;
		this.bilDys = bilDys;
		this.agmtSeq = agmtSeq;
		this.agmtNo = agmtNo;
		this.invNo = invNo;
		this.onhLocCd = onhLocCd;
		this.ttlCostAmt = ttlCostAmt;
		this.cntrNo = cntrNo;
		this.dscrOnhLocCd = dscrOnhLocCd;
		this.chgFreeDys = chgFreeDys;
		this.dtlSeq = dtlSeq;
		this.usrId = usrId;
		this.payChgStsCd = payChgStsCd;
		this.lsePayChgTpNm = lsePayChgTpNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dscr_pd_rt_amt", getDscrPdRtAmt());
		this.hashColumns.put("offh_loc_cd", getOffhLocCd());
		this.hashColumns.put("pd_rt_amt", getPdRtAmt());
		this.hashColumns.put("lse_pay_chg_tp_cd", getLsePayChgTpCd());
		this.hashColumns.put("dscr_onh_dt", getDscrOnhDt());
		this.hashColumns.put("chg_cost_yrmon", getChgCostYrmon());
		this.hashColumns.put("dscr_offh_dt", getDscrOffhDt());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("dscr_cost_amt", getDscrCostAmt());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lse_ctrt_no", getLseCtrtNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("cr_no", getCrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cost_dys", getCostDys());
		this.hashColumns.put("offh_dt", getOffhDt());
		this.hashColumns.put("bil_dys", getBilDys());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("onh_loc_cd", getOnhLocCd());
		this.hashColumns.put("ttl_cost_amt", getTtlCostAmt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dscr_onh_loc_cd", getDscrOnhLocCd());
		this.hashColumns.put("chg_free_dys", getChgFreeDys());
		this.hashColumns.put("dtl_seq", getDtlSeq());
		this.hashColumns.put("cntr_aud_sts_cd", getCntrAudStsCd());
		this.hashColumns.put("dscr_offh_loc_cd", getDscrOffhLocCd());
		this.hashColumns.put("dscr_rt_amt", getDscrRtAmt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("pay_chg_sts_cd", getPayChgStsCd());
		this.hashColumns.put("lse_pay_chg_tp_nm", getLsePayChgTpNm());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dscr_pd_rt_amt", "dscrPdRtAmt");
		this.hashFields.put("offh_loc_cd", "offhLocCd");
		this.hashFields.put("pd_rt_amt", "pdRtAmt");
		this.hashFields.put("lse_pay_chg_tp_cd", "lsePayChgTpCd");
		this.hashFields.put("dscr_onh_dt", "dscrOnhDt");
		this.hashFields.put("chg_cost_yrmon", "chgCostYrmon");
		this.hashFields.put("dscr_offh_dt", "dscrOffhDt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("dscr_cost_amt", "dscrCostAmt");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lse_ctrt_no", "lseCtrtNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("cr_no", "crNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cost_dys", "costDys");
		this.hashFields.put("offh_dt", "offhDt");
		this.hashFields.put("bil_dys", "bilDys");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("onh_loc_cd", "onhLocCd");
		this.hashFields.put("ttl_cost_amt", "ttlCostAmt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dscr_onh_loc_cd", "dscrOnhLocCd");
		this.hashFields.put("chg_free_dys", "chgFreeDys");
		this.hashFields.put("dtl_seq", "dtlSeq");
		this.hashFields.put("cntr_aud_sts_cd", "cntrAudStsCd");
		this.hashFields.put("dscr_offh_loc_cd", "dscrOffhLocCd");
		this.hashFields.put("dscr_rt_amt", "dscrRtAmt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pay_chg_sts_cd", "payChgStsCd");
		this.hashFields.put("lse_pay_chg_tp_nm", "lsePayChgTpNm");

		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dscrPdRtAmt
	 */
	public String getDscrPdRtAmt() {
		return this.dscrPdRtAmt;
	}
	
	/**
	 * Column Info
	 * @return offhLocCd
	 */
	public String getOffhLocCd() {
		return this.offhLocCd;
	}
	
	/**
	 * Column Info
	 * @return pdRtAmt
	 */
	public String getPdRtAmt() {
		return this.pdRtAmt;
	}
	
	/**
	 * Column Info
	 * @return lsePayChgTpCd
	 */
	public String getLsePayChgTpCd() {
		return this.lsePayChgTpCd;
	}
	
	/**
	 * Column Info
	 * @return dscrOnhDt
	 */
	public String getDscrOnhDt() {
		return this.dscrOnhDt;
	}
	
	/**
	 * Column Info
	 * @return chgCostYrmon
	 */
	public String getChgCostYrmon() {
		return this.chgCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return dscrOffhDt
	 */
	public String getDscrOffhDt() {
		return this.dscrOffhDt;
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
	 * @return dscrCostAmt
	 */
	public String getDscrCostAmt() {
		return this.dscrCostAmt;
	}
	
	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
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
	 * @return lseCtrtNo
	 */
	public String getLseCtrtNo() {
		return this.lseCtrtNo;
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
	 * @return crAmt
	 */
	public String getCrAmt() {
		return this.crAmt;
	}
	
	/**
	 * Column Info
	 * @return crNo
	 */
	public String getCrNo() {
		return this.crNo;
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
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return costDys
	 */
	public String getCostDys() {
		return this.costDys;
	}
	
	/**
	 * Column Info
	 * @return offhDt
	 */
	public String getOffhDt() {
		return this.offhDt;
	}
	
	/**
	 * Column Info
	 * @return bilDys
	 */
	public String getBilDys() {
		return this.bilDys;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return onhLocCd
	 */
	public String getOnhLocCd() {
		return this.onhLocCd;
	}
	
	/**
	 * Column Info
	 * @return ttlCostAmt
	 */
	public String getTtlCostAmt() {
		return this.ttlCostAmt;
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
	 * @return dscrOnhLocCd
	 */
	public String getDscrOnhLocCd() {
		return this.dscrOnhLocCd;
	}
	
	/**
	 * Column Info
	 * @return chgFreeDys
	 */
	public String getChgFreeDys() {
		return this.chgFreeDys;
	}
	

	/**
	 * Column Info
	 * @param dscrPdRtAmt
	 */
	public void setDscrPdRtAmt(String dscrPdRtAmt) {
		this.dscrPdRtAmt = dscrPdRtAmt;
	}
	
	/**
	 * Column Info
	 * @param offhLocCd
	 */
	public void setOffhLocCd(String offhLocCd) {
		this.offhLocCd = offhLocCd;
	}
	
	/**
	 * Column Info
	 * @param pdRtAmt
	 */
	public void setPdRtAmt(String pdRtAmt) {
		this.pdRtAmt = pdRtAmt;
	}
	
	/**
	 * Column Info
	 * @param lsePayChgTpCd
	 */
	public void setLsePayChgTpCd(String lsePayChgTpCd) {
		this.lsePayChgTpCd = lsePayChgTpCd;
	}
	
	/**
	 * Column Info
	 * @param dscrOnhDt
	 */
	public void setDscrOnhDt(String dscrOnhDt) {
		this.dscrOnhDt = dscrOnhDt;
	}
	
	/**
	 * Column Info
	 * @param chgCostYrmon
	 */
	public void setChgCostYrmon(String chgCostYrmon) {
		this.chgCostYrmon = chgCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param dscrOffhDt
	 */
	public void setDscrOffhDt(String dscrOffhDt) {
		this.dscrOffhDt = dscrOffhDt;
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
	 * @param dscrCostAmt
	 */
	public void setDscrCostAmt(String dscrCostAmt) {
		this.dscrCostAmt = dscrCostAmt;
	}
	
	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
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
	 * @param lseCtrtNo
	 */
	public void setLseCtrtNo(String lseCtrtNo) {
		this.lseCtrtNo = lseCtrtNo;
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
	 * @param crAmt
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}
	
	/**
	 * Column Info
	 * @param crNo
	 */
	public void setCrNo(String crNo) {
		this.crNo = crNo;
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
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param costDys
	 */
	public void setCostDys(String costDys) {
		this.costDys = costDys;
	}
	
	/**
	 * Column Info
	 * @param offhDt
	 */
	public void setOffhDt(String offhDt) {
		this.offhDt = offhDt;
	}
	
	/**
	 * Column Info
	 * @param bilDys
	 */
	public void setBilDys(String bilDys) {
		this.bilDys = bilDys;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param onhLocCd
	 */
	public void setOnhLocCd(String onhLocCd) {
		this.onhLocCd = onhLocCd;
	}
	
	/**
	 * Column Info
	 * @param ttlCostAmt
	 */
	public void setTtlCostAmt(String ttlCostAmt) {
		this.ttlCostAmt = ttlCostAmt;
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
	 * @param dscrOnhLocCd
	 */
	public void setDscrOnhLocCd(String dscrOnhLocCd) {
		this.dscrOnhLocCd = dscrOnhLocCd;
	}
	
	/**
	 * Column Info
	 * @param chgFreeDys
	 */
	public void setChgFreeDys(String chgFreeDys) {
		this.chgFreeDys = chgFreeDys;
	}

	public void setDtlSeq(String dtlSeq) {
		this.dtlSeq = dtlSeq;
	}

	public String getDtlSeq() {
		return dtlSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDscrPdRtAmt(JSPUtil.getParameter(request, "dscr_pd_rt_amt", ""));
		setOffhLocCd(JSPUtil.getParameter(request, "offh_loc_cd", ""));
		setPdRtAmt(JSPUtil.getParameter(request, "pd_rt_amt", ""));
		setLsePayChgTpCd(JSPUtil.getParameter(request, "lse_pay_chg_tp_cd", ""));
		setDscrOnhDt(JSPUtil.getParameter(request, "dscr_onh_dt", ""));
		setChgCostYrmon(JSPUtil.getParameter(request, "chg_cost_yrmon", ""));
		setDscrOffhDt(JSPUtil.getParameter(request, "dscr_offh_dt", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setDscrCostAmt(JSPUtil.getParameter(request, "dscr_cost_amt", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLseCtrtNo(JSPUtil.getParameter(request, "lse_ctrt_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setCrNo(JSPUtil.getParameter(request, "cr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setCostDys(JSPUtil.getParameter(request, "cost_dys", ""));
		setOffhDt(JSPUtil.getParameter(request, "offh_dt", ""));
		setBilDys(JSPUtil.getParameter(request, "bil_dys", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setOnhLocCd(JSPUtil.getParameter(request, "onh_loc_cd", ""));
		setTtlCostAmt(JSPUtil.getParameter(request, "ttl_cost_amt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setDscrOnhLocCd(JSPUtil.getParameter(request, "dscr_onh_loc_cd", ""));
		setChgFreeDys(JSPUtil.getParameter(request, "chg_free_dys", ""));
		setDtlSeq(JSPUtil.getParameter(request, "dtl_seq", ""));
		setCntrAudStsCd(JSPUtil.getParameter(request, "cntr_aud_sts_cd", ""));
		setDscrOffhLocCd(JSPUtil.getParameter(request, "dscr_offh_loc_cd", ""));
		setDscrRtAmt(JSPUtil.getParameter(request, "dscr_rt_amt", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setPayChgStsCd(JSPUtil.getParameter(request, "pay_chg_sts_cd", ""));
		setLsePayChgTpNm(JSPUtil.getParameter(request, "lse_pay_chg_tp_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PayableRentalCostAuditVO[]
	 */
	public PayableRentalCostAuditVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PayableRentalCostAuditVO[]
	 */
	public PayableRentalCostAuditVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PayableRentalCostAuditVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dscrPdRtAmt = (JSPUtil.getParameter(request, prefix	+ "dscr_pd_rt_amt", length));
			String[] offhLocCd = (JSPUtil.getParameter(request, prefix	+ "offh_loc_cd", length));
			String[] pdRtAmt = (JSPUtil.getParameter(request, prefix	+ "pd_rt_amt", length));
			String[] lsePayChgTpCd = (JSPUtil.getParameter(request, prefix	+ "lse_pay_chg_tp_cd", length));
			String[] dscrOnhDt = (JSPUtil.getParameter(request, prefix	+ "dscr_onh_dt", length));
			String[] chgCostYrmon = (JSPUtil.getParameter(request, prefix	+ "chg_cost_yrmon", length));
			String[] dscrOffhDt = (JSPUtil.getParameter(request, prefix	+ "dscr_offh_dt", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] dscrCostAmt = (JSPUtil.getParameter(request, prefix	+ "dscr_cost_amt", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lseCtrtNo = (JSPUtil.getParameter(request, prefix	+ "lse_ctrt_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] crNo = (JSPUtil.getParameter(request, prefix	+ "cr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] costDys = (JSPUtil.getParameter(request, prefix	+ "cost_dys", length));
			String[] offhDt = (JSPUtil.getParameter(request, prefix	+ "offh_dt", length));
			String[] bilDys = (JSPUtil.getParameter(request, prefix	+ "bil_dys", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] onhLocCd = (JSPUtil.getParameter(request, prefix	+ "onh_loc_cd", length));
			String[] ttlCostAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_cost_amt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] dscrOnhLocCd = (JSPUtil.getParameter(request, prefix	+ "dscr_onh_loc_cd", length));
			String[] chgFreeDys = (JSPUtil.getParameter(request, prefix	+ "chg_free_dys", length));
			String[] dtlSeq = (JSPUtil.getParameter(request, prefix	+ "dtl_seq", length));
			String[] cntrAudStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_aud_sts_cd", length));
			String[] dscrOffhLocCd = (JSPUtil.getParameter(request, prefix	+ "dscr_offh_loc_cd", length));
			String[] dscrRtAmt = (JSPUtil.getParameter(request, prefix	+ "dscr_rt_amt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] payChgStsCd = (JSPUtil.getParameter(request, prefix	+ "pay_chg_sts_cd", length));
			String[] lsePayChgTpNm = (JSPUtil.getParameter(request, prefix	+ "lse_pay_chg_tp_nm", length));

			for (int i = 0; i < length; i++) {
				model = new PayableRentalCostAuditVO();
				if (dscrPdRtAmt[i] != null)
					model.setDscrPdRtAmt(dscrPdRtAmt[i]);
				if (offhLocCd[i] != null)
					model.setOffhLocCd(offhLocCd[i]);
				if (pdRtAmt[i] != null)
					model.setPdRtAmt(pdRtAmt[i]);
				if (lsePayChgTpCd[i] != null)
					model.setLsePayChgTpCd(lsePayChgTpCd[i]);
				if (dscrOnhDt[i] != null)
					model.setDscrOnhDt(dscrOnhDt[i]);
				if (chgCostYrmon[i] != null)
					model.setChgCostYrmon(chgCostYrmon[i]);
				if (dscrOffhDt[i] != null)
					model.setDscrOffhDt(dscrOffhDt[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (dscrCostAmt[i] != null)
					model.setDscrCostAmt(dscrCostAmt[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lseCtrtNo[i] != null)
					model.setLseCtrtNo(lseCtrtNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (crNo[i] != null)
					model.setCrNo(crNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (costDys[i] != null)
					model.setCostDys(costDys[i]);
				if (offhDt[i] != null)
					model.setOffhDt(offhDt[i]);
				if (bilDys[i] != null)
					model.setBilDys(bilDys[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (onhLocCd[i] != null)
					model.setOnhLocCd(onhLocCd[i]);
				if (ttlCostAmt[i] != null)
					model.setTtlCostAmt(ttlCostAmt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (dscrOnhLocCd[i] != null)
					model.setDscrOnhLocCd(dscrOnhLocCd[i]);
				if (chgFreeDys[i] != null)
					model.setChgFreeDys(chgFreeDys[i]);
				if (dtlSeq[i] != null)
					model.setDtlSeq(dtlSeq[i]);
				if (cntrAudStsCd[i] != null)
					model.setCntrAudStsCd(cntrAudStsCd[i]);
				if (dscrOffhLocCd[i] != null)
					model.setDscrOffhLocCd(dscrOffhLocCd[i]);
				if (dscrRtAmt[i] != null)
					model.setDscrRtAmt(dscrRtAmt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (payChgStsCd[i] != null)
					model.setPayChgStsCd(payChgStsCd[i]);
				if (lsePayChgTpNm[i] != null)
					model.setLsePayChgTpNm(lsePayChgTpNm[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPayableRentalCostAuditVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PayableRentalCostAuditVO[]
	 */
	public PayableRentalCostAuditVO[] getPayableRentalCostAuditVOs(){
		PayableRentalCostAuditVO[] vos = (PayableRentalCostAuditVO[])models.toArray(new PayableRentalCostAuditVO[models.size()]);
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
		this.dscrPdRtAmt = this.dscrPdRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhLocCd = this.offhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdRtAmt = this.pdRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsePayChgTpCd = this.lsePayChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscrOnhDt = this.dscrOnhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCostYrmon = this.chgCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscrOffhDt = this.dscrOffhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscrCostAmt = this.dscrCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseCtrtNo = this.lseCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crNo = this.crNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDys = this.costDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDt = this.offhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilDys = this.bilDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhLocCd = this.onhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCostAmt = this.ttlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscrOnhLocCd = this.dscrOnhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgFreeDys = this.chgFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSeq = this.dtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAudStsCd = this.cntrAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscrOffhLocCd = this.dscrOffhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscrRtAmt = this.dscrRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payChgStsCd = this.payChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsePayChgTpNm = this.lsePayChgTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public void setCntrAudStsCd(String cntrAudStsCd) {
		this.cntrAudStsCd = cntrAudStsCd;
	}

	public String getCntrAudStsCd() {
		return cntrAudStsCd;
	}

	public void setDscrOffhLocCd(String dscrOffhLocCd) {
		this.dscrOffhLocCd = dscrOffhLocCd;
	}

	public String getDscrOffhLocCd() {
		return dscrOffhLocCd;
	}

	public void setDscrRtAmt(String dscrRtAmt) {
		this.dscrRtAmt = dscrRtAmt;
	}

	public String getDscrRtAmt() {
		return dscrRtAmt;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setPayChgStsCd(String payChgStsCd) {
		this.payChgStsCd = payChgStsCd;
	}

	public String getPayChgStsCd() {
		return payChgStsCd;
	}

	public void setLsePayChgTpNm(String lsePayChgTpNm) {
		this.lsePayChgTpNm = lsePayChgTpNm;
	}

	public String getLsePayChgTpNm() {
		return lsePayChgTpNm;
	}
}