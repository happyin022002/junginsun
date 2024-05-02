/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchPremiumVO.java
*@FileTitle : SearchPremiumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.01.13 윤세영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.insurance.insurance.vo;

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
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPremiumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPremiumVO> models = new ArrayList<SearchPremiumVO>();
	
	/* Column Info */
	private String ttlXchRt = null;
	/* Column Info */
	private String rfndXchRt = null;
	/* Column Info */
	private String rfndDueDt = null;
	/* Column Info */
	private String adjCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String otsPayDt = null;
	/* Column Info */
	private String rfndUsdAmt = null;
	/* Column Info */
	private String adjLoclAmt = null;
	/* Column Info */
	private String insurPlcyYr = null;
	/* Column Info */
	private String rfndCurrCd = null;
	/* Column Info */
	private String adjXchRt = null;
	/* Column Info */
	private String insurClmPtyNoPrm = null;
	/* Column Info */
	private String otsUsdAmt = null;
	/* Column Info */
	private String otsDueDt = null;
	/* Column Info */
	private String otsLoclAmt = null;
	/* Column Info */
	private String insurTpCd = null;
	/* Column Info */
	private String insurClmPtyNmPrm = null;
	/* Column Info */
	private String ttlDueDt = null;
	/* Column Info */
	private String rfndLoclAmt = null;
	/* Column Info */
	private String ttlPayDt = null;
	/* Column Info */
	private String adjDueDt = null;
	/* Column Info */
	private String ttlUsdAmt = null;
	/* Column Info */
	private String adjPayDt = null;
	/* Column Info */
	private String insurPrmTpCd = null;
	/* Column Info */
	private String rfndPayDt = null;
	/* Column Info */
	private String ttlCurrCd = null;
	/* Column Info */
	private String otsCurrCd = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String ttlLoclAmt = null;
	/* Column Info */
	private String insurClmPtyNo = null;
	/* Column Info */
	private String otsXchRt = null;
	/* Column Info */
	private String adjUsdAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPremiumVO() {}

	public SearchPremiumVO(String ibflag, String pagerows, String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurClmPtyNoPrm, String insurClmPtyNmPrm, String insurPrmTpCd, String ttlLoclAmt, String ttlCurrCd, String ttlXchRt, String ttlUsdAmt, String ttlDueDt, String ttlPayDt, String adjLoclAmt, String adjCurrCd, String adjXchRt, String adjUsdAmt, String adjDueDt, String adjPayDt, String rfndLoclAmt, String rfndCurrCd, String rfndXchRt, String rfndUsdAmt, String rfndDueDt, String rfndPayDt, String otsLoclAmt, String otsCurrCd, String otsXchRt, String otsUsdAmt, String otsDueDt, String otsPayDt, String diffRmk) {
		this.ttlXchRt = ttlXchRt;
		this.rfndXchRt = rfndXchRt;
		this.rfndDueDt = rfndDueDt;
		this.adjCurrCd = adjCurrCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.otsPayDt = otsPayDt;
		this.rfndUsdAmt = rfndUsdAmt;
		this.adjLoclAmt = adjLoclAmt;
		this.insurPlcyYr = insurPlcyYr;
		this.rfndCurrCd = rfndCurrCd;
		this.adjXchRt = adjXchRt;
		this.insurClmPtyNoPrm = insurClmPtyNoPrm;
		this.otsUsdAmt = otsUsdAmt;
		this.otsDueDt = otsDueDt;
		this.otsLoclAmt = otsLoclAmt;
		this.insurTpCd = insurTpCd;
		this.insurClmPtyNmPrm = insurClmPtyNmPrm;
		this.ttlDueDt = ttlDueDt;
		this.rfndLoclAmt = rfndLoclAmt;
		this.ttlPayDt = ttlPayDt;
		this.adjDueDt = adjDueDt;
		this.ttlUsdAmt = ttlUsdAmt;
		this.adjPayDt = adjPayDt;
		this.insurPrmTpCd = insurPrmTpCd;
		this.rfndPayDt = rfndPayDt;
		this.ttlCurrCd = ttlCurrCd;
		this.otsCurrCd = otsCurrCd;
		this.diffRmk = diffRmk;
		this.ttlLoclAmt = ttlLoclAmt;
		this.insurClmPtyNo = insurClmPtyNo;
		this.otsXchRt = otsXchRt;
		this.adjUsdAmt = adjUsdAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ttl_xch_rt", getTtlXchRt());
		this.hashColumns.put("rfnd_xch_rt", getRfndXchRt());
		this.hashColumns.put("rfnd_due_dt", getRfndDueDt());
		this.hashColumns.put("adj_curr_cd", getAdjCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ots_pay_dt", getOtsPayDt());
		this.hashColumns.put("rfnd_usd_amt", getRfndUsdAmt());
		this.hashColumns.put("adj_locl_amt", getAdjLoclAmt());
		this.hashColumns.put("insur_plcy_yr", getInsurPlcyYr());
		this.hashColumns.put("rfnd_curr_cd", getRfndCurrCd());
		this.hashColumns.put("adj_xch_rt", getAdjXchRt());
		this.hashColumns.put("insur_clm_pty_no_prm", getInsurClmPtyNoPrm());
		this.hashColumns.put("ots_usd_amt", getOtsUsdAmt());
		this.hashColumns.put("ots_due_dt", getOtsDueDt());
		this.hashColumns.put("ots_locl_amt", getOtsLoclAmt());
		this.hashColumns.put("insur_tp_cd", getInsurTpCd());
		this.hashColumns.put("insur_clm_pty_nm_prm", getInsurClmPtyNmPrm());
		this.hashColumns.put("ttl_due_dt", getTtlDueDt());
		this.hashColumns.put("rfnd_locl_amt", getRfndLoclAmt());
		this.hashColumns.put("ttl_pay_dt", getTtlPayDt());
		this.hashColumns.put("adj_due_dt", getAdjDueDt());
		this.hashColumns.put("ttl_usd_amt", getTtlUsdAmt());
		this.hashColumns.put("adj_pay_dt", getAdjPayDt());
		this.hashColumns.put("insur_prm_tp_cd", getInsurPrmTpCd());
		this.hashColumns.put("rfnd_pay_dt", getRfndPayDt());
		this.hashColumns.put("ttl_curr_cd", getTtlCurrCd());
		this.hashColumns.put("ots_curr_cd", getOtsCurrCd());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("ttl_locl_amt", getTtlLoclAmt());
		this.hashColumns.put("insur_clm_pty_no", getInsurClmPtyNo());
		this.hashColumns.put("ots_xch_rt", getOtsXchRt());
		this.hashColumns.put("adj_usd_amt", getAdjUsdAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ttl_xch_rt", "ttlXchRt");
		this.hashFields.put("rfnd_xch_rt", "rfndXchRt");
		this.hashFields.put("rfnd_due_dt", "rfndDueDt");
		this.hashFields.put("adj_curr_cd", "adjCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ots_pay_dt", "otsPayDt");
		this.hashFields.put("rfnd_usd_amt", "rfndUsdAmt");
		this.hashFields.put("adj_locl_amt", "adjLoclAmt");
		this.hashFields.put("insur_plcy_yr", "insurPlcyYr");
		this.hashFields.put("rfnd_curr_cd", "rfndCurrCd");
		this.hashFields.put("adj_xch_rt", "adjXchRt");
		this.hashFields.put("insur_clm_pty_no_prm", "insurClmPtyNoPrm");
		this.hashFields.put("ots_usd_amt", "otsUsdAmt");
		this.hashFields.put("ots_due_dt", "otsDueDt");
		this.hashFields.put("ots_locl_amt", "otsLoclAmt");
		this.hashFields.put("insur_tp_cd", "insurTpCd");
		this.hashFields.put("insur_clm_pty_nm_prm", "insurClmPtyNmPrm");
		this.hashFields.put("ttl_due_dt", "ttlDueDt");
		this.hashFields.put("rfnd_locl_amt", "rfndLoclAmt");
		this.hashFields.put("ttl_pay_dt", "ttlPayDt");
		this.hashFields.put("adj_due_dt", "adjDueDt");
		this.hashFields.put("ttl_usd_amt", "ttlUsdAmt");
		this.hashFields.put("adj_pay_dt", "adjPayDt");
		this.hashFields.put("insur_prm_tp_cd", "insurPrmTpCd");
		this.hashFields.put("rfnd_pay_dt", "rfndPayDt");
		this.hashFields.put("ttl_curr_cd", "ttlCurrCd");
		this.hashFields.put("ots_curr_cd", "otsCurrCd");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("ttl_locl_amt", "ttlLoclAmt");
		this.hashFields.put("insur_clm_pty_no", "insurClmPtyNo");
		this.hashFields.put("ots_xch_rt", "otsXchRt");
		this.hashFields.put("adj_usd_amt", "adjUsdAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ttlXchRt
	 */
	public String getTtlXchRt() {
		return this.ttlXchRt;
	}
	
	/**
	 * Column Info
	 * @return rfndXchRt
	 */
	public String getRfndXchRt() {
		return this.rfndXchRt;
	}
	
	/**
	 * Column Info
	 * @return rfndDueDt
	 */
	public String getRfndDueDt() {
		return this.rfndDueDt;
	}
	
	/**
	 * Column Info
	 * @return adjCurrCd
	 */
	public String getAdjCurrCd() {
		return this.adjCurrCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return otsPayDt
	 */
	public String getOtsPayDt() {
		return this.otsPayDt;
	}
	
	/**
	 * Column Info
	 * @return rfndUsdAmt
	 */
	public String getRfndUsdAmt() {
		return this.rfndUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return adjLoclAmt
	 */
	public String getAdjLoclAmt() {
		return this.adjLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return insurPlcyYr
	 */
	public String getInsurPlcyYr() {
		return this.insurPlcyYr;
	}
	
	/**
	 * Column Info
	 * @return rfndCurrCd
	 */
	public String getRfndCurrCd() {
		return this.rfndCurrCd;
	}
	
	/**
	 * Column Info
	 * @return adjXchRt
	 */
	public String getAdjXchRt() {
		return this.adjXchRt;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyNoPrm
	 */
	public String getInsurClmPtyNoPrm() {
		return this.insurClmPtyNoPrm;
	}
	
	/**
	 * Column Info
	 * @return otsUsdAmt
	 */
	public String getOtsUsdAmt() {
		return this.otsUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return otsDueDt
	 */
	public String getOtsDueDt() {
		return this.otsDueDt;
	}
	
	/**
	 * Column Info
	 * @return otsLoclAmt
	 */
	public String getOtsLoclAmt() {
		return this.otsLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return insurTpCd
	 */
	public String getInsurTpCd() {
		return this.insurTpCd;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyNmPrm
	 */
	public String getInsurClmPtyNmPrm() {
		return this.insurClmPtyNmPrm;
	}
	
	/**
	 * Column Info
	 * @return ttlDueDt
	 */
	public String getTtlDueDt() {
		return this.ttlDueDt;
	}
	
	/**
	 * Column Info
	 * @return rfndLoclAmt
	 */
	public String getRfndLoclAmt() {
		return this.rfndLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlPayDt
	 */
	public String getTtlPayDt() {
		return this.ttlPayDt;
	}
	
	/**
	 * Column Info
	 * @return adjDueDt
	 */
	public String getAdjDueDt() {
		return this.adjDueDt;
	}
	
	/**
	 * Column Info
	 * @return ttlUsdAmt
	 */
	public String getTtlUsdAmt() {
		return this.ttlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return adjPayDt
	 */
	public String getAdjPayDt() {
		return this.adjPayDt;
	}
	
	/**
	 * Column Info
	 * @return insurPrmTpCd
	 */
	public String getInsurPrmTpCd() {
		return this.insurPrmTpCd;
	}
	
	/**
	 * Column Info
	 * @return rfndPayDt
	 */
	public String getRfndPayDt() {
		return this.rfndPayDt;
	}
	
	/**
	 * Column Info
	 * @return ttlCurrCd
	 */
	public String getTtlCurrCd() {
		return this.ttlCurrCd;
	}
	
	/**
	 * Column Info
	 * @return otsCurrCd
	 */
	public String getOtsCurrCd() {
		return this.otsCurrCd;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return ttlLoclAmt
	 */
	public String getTtlLoclAmt() {
		return this.ttlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyNo
	 */
	public String getInsurClmPtyNo() {
		return this.insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return otsXchRt
	 */
	public String getOtsXchRt() {
		return this.otsXchRt;
	}
	
	/**
	 * Column Info
	 * @return adjUsdAmt
	 */
	public String getAdjUsdAmt() {
		return this.adjUsdAmt;
	}
	

	/**
	 * Column Info
	 * @param ttlXchRt
	 */
	public void setTtlXchRt(String ttlXchRt) {
		this.ttlXchRt = ttlXchRt;
	}
	
	/**
	 * Column Info
	 * @param rfndXchRt
	 */
	public void setRfndXchRt(String rfndXchRt) {
		this.rfndXchRt = rfndXchRt;
	}
	
	/**
	 * Column Info
	 * @param rfndDueDt
	 */
	public void setRfndDueDt(String rfndDueDt) {
		this.rfndDueDt = rfndDueDt;
	}
	
	/**
	 * Column Info
	 * @param adjCurrCd
	 */
	public void setAdjCurrCd(String adjCurrCd) {
		this.adjCurrCd = adjCurrCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param otsPayDt
	 */
	public void setOtsPayDt(String otsPayDt) {
		this.otsPayDt = otsPayDt;
	}
	
	/**
	 * Column Info
	 * @param rfndUsdAmt
	 */
	public void setRfndUsdAmt(String rfndUsdAmt) {
		this.rfndUsdAmt = rfndUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param adjLoclAmt
	 */
	public void setAdjLoclAmt(String adjLoclAmt) {
		this.adjLoclAmt = adjLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param insurPlcyYr
	 */
	public void setInsurPlcyYr(String insurPlcyYr) {
		this.insurPlcyYr = insurPlcyYr;
	}
	
	/**
	 * Column Info
	 * @param rfndCurrCd
	 */
	public void setRfndCurrCd(String rfndCurrCd) {
		this.rfndCurrCd = rfndCurrCd;
	}
	
	/**
	 * Column Info
	 * @param adjXchRt
	 */
	public void setAdjXchRt(String adjXchRt) {
		this.adjXchRt = adjXchRt;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyNoPrm
	 */
	public void setInsurClmPtyNoPrm(String insurClmPtyNoPrm) {
		this.insurClmPtyNoPrm = insurClmPtyNoPrm;
	}
	
	/**
	 * Column Info
	 * @param otsUsdAmt
	 */
	public void setOtsUsdAmt(String otsUsdAmt) {
		this.otsUsdAmt = otsUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param otsDueDt
	 */
	public void setOtsDueDt(String otsDueDt) {
		this.otsDueDt = otsDueDt;
	}
	
	/**
	 * Column Info
	 * @param otsLoclAmt
	 */
	public void setOtsLoclAmt(String otsLoclAmt) {
		this.otsLoclAmt = otsLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param insurTpCd
	 */
	public void setInsurTpCd(String insurTpCd) {
		this.insurTpCd = insurTpCd;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyNmPrm
	 */
	public void setInsurClmPtyNmPrm(String insurClmPtyNmPrm) {
		this.insurClmPtyNmPrm = insurClmPtyNmPrm;
	}
	
	/**
	 * Column Info
	 * @param ttlDueDt
	 */
	public void setTtlDueDt(String ttlDueDt) {
		this.ttlDueDt = ttlDueDt;
	}
	
	/**
	 * Column Info
	 * @param rfndLoclAmt
	 */
	public void setRfndLoclAmt(String rfndLoclAmt) {
		this.rfndLoclAmt = rfndLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlPayDt
	 */
	public void setTtlPayDt(String ttlPayDt) {
		this.ttlPayDt = ttlPayDt;
	}
	
	/**
	 * Column Info
	 * @param adjDueDt
	 */
	public void setAdjDueDt(String adjDueDt) {
		this.adjDueDt = adjDueDt;
	}
	
	/**
	 * Column Info
	 * @param ttlUsdAmt
	 */
	public void setTtlUsdAmt(String ttlUsdAmt) {
		this.ttlUsdAmt = ttlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param adjPayDt
	 */
	public void setAdjPayDt(String adjPayDt) {
		this.adjPayDt = adjPayDt;
	}
	
	/**
	 * Column Info
	 * @param insurPrmTpCd
	 */
	public void setInsurPrmTpCd(String insurPrmTpCd) {
		this.insurPrmTpCd = insurPrmTpCd;
	}
	
	/**
	 * Column Info
	 * @param rfndPayDt
	 */
	public void setRfndPayDt(String rfndPayDt) {
		this.rfndPayDt = rfndPayDt;
	}
	
	/**
	 * Column Info
	 * @param ttlCurrCd
	 */
	public void setTtlCurrCd(String ttlCurrCd) {
		this.ttlCurrCd = ttlCurrCd;
	}
	
	/**
	 * Column Info
	 * @param otsCurrCd
	 */
	public void setOtsCurrCd(String otsCurrCd) {
		this.otsCurrCd = otsCurrCd;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param ttlLoclAmt
	 */
	public void setTtlLoclAmt(String ttlLoclAmt) {
		this.ttlLoclAmt = ttlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyNo
	 */
	public void setInsurClmPtyNo(String insurClmPtyNo) {
		this.insurClmPtyNo = insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param otsXchRt
	 */
	public void setOtsXchRt(String otsXchRt) {
		this.otsXchRt = otsXchRt;
	}
	
	/**
	 * Column Info
	 * @param adjUsdAmt
	 */
	public void setAdjUsdAmt(String adjUsdAmt) {
		this.adjUsdAmt = adjUsdAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTtlXchRt(JSPUtil.getParameter(request, "ttl_xch_rt", ""));
		setRfndXchRt(JSPUtil.getParameter(request, "rfnd_xch_rt", ""));
		setRfndDueDt(JSPUtil.getParameter(request, "rfnd_due_dt", ""));
		setAdjCurrCd(JSPUtil.getParameter(request, "adj_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOtsPayDt(JSPUtil.getParameter(request, "ots_pay_dt", ""));
		setRfndUsdAmt(JSPUtil.getParameter(request, "rfnd_usd_amt", ""));
		setAdjLoclAmt(JSPUtil.getParameter(request, "adj_locl_amt", ""));
		setInsurPlcyYr(JSPUtil.getParameter(request, "insur_plcy_yr", ""));
		setRfndCurrCd(JSPUtil.getParameter(request, "rfnd_curr_cd", ""));
		setAdjXchRt(JSPUtil.getParameter(request, "adj_xch_rt", ""));
		setInsurClmPtyNoPrm(JSPUtil.getParameter(request, "insur_clm_pty_no_prm", ""));
		setOtsUsdAmt(JSPUtil.getParameter(request, "ots_usd_amt", ""));
		setOtsDueDt(JSPUtil.getParameter(request, "ots_due_dt", ""));
		setOtsLoclAmt(JSPUtil.getParameter(request, "ots_locl_amt", ""));
		setInsurTpCd(JSPUtil.getParameter(request, "insur_tp_cd", ""));
		setInsurClmPtyNmPrm(JSPUtil.getParameter(request, "insur_clm_pty_nm_prm", ""));
		setTtlDueDt(JSPUtil.getParameter(request, "ttl_due_dt", ""));
		setRfndLoclAmt(JSPUtil.getParameter(request, "rfnd_locl_amt", ""));
		setTtlPayDt(JSPUtil.getParameter(request, "ttl_pay_dt", ""));
		setAdjDueDt(JSPUtil.getParameter(request, "adj_due_dt", ""));
		setTtlUsdAmt(JSPUtil.getParameter(request, "ttl_usd_amt", ""));
		setAdjPayDt(JSPUtil.getParameter(request, "adj_pay_dt", ""));
		setInsurPrmTpCd(JSPUtil.getParameter(request, "insur_prm_tp_cd", ""));
		setRfndPayDt(JSPUtil.getParameter(request, "rfnd_pay_dt", ""));
		setTtlCurrCd(JSPUtil.getParameter(request, "ttl_curr_cd", ""));
		setOtsCurrCd(JSPUtil.getParameter(request, "ots_curr_cd", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setTtlLoclAmt(JSPUtil.getParameter(request, "ttl_locl_amt", ""));
		setInsurClmPtyNo(JSPUtil.getParameter(request, "insur_clm_pty_no", ""));
		setOtsXchRt(JSPUtil.getParameter(request, "ots_xch_rt", ""));
		setAdjUsdAmt(JSPUtil.getParameter(request, "adj_usd_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPremiumVO[]
	 */
	public SearchPremiumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPremiumVO[]
	 */
	public SearchPremiumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPremiumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ttlXchRt = (JSPUtil.getParameter(request, prefix	+ "ttl_xch_rt", length));
			String[] rfndXchRt = (JSPUtil.getParameter(request, prefix	+ "rfnd_xch_rt", length));
			String[] rfndDueDt = (JSPUtil.getParameter(request, prefix	+ "rfnd_due_dt", length));
			String[] adjCurrCd = (JSPUtil.getParameter(request, prefix	+ "adj_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] otsPayDt = (JSPUtil.getParameter(request, prefix	+ "ots_pay_dt", length));
			String[] rfndUsdAmt = (JSPUtil.getParameter(request, prefix	+ "rfnd_usd_amt", length));
			String[] adjLoclAmt = (JSPUtil.getParameter(request, prefix	+ "adj_locl_amt", length));
			String[] insurPlcyYr = (JSPUtil.getParameter(request, prefix	+ "insur_plcy_yr", length));
			String[] rfndCurrCd = (JSPUtil.getParameter(request, prefix	+ "rfnd_curr_cd", length));
			String[] adjXchRt = (JSPUtil.getParameter(request, prefix	+ "adj_xch_rt", length));
			String[] insurClmPtyNoPrm = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_no_prm", length));
			String[] otsUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ots_usd_amt", length));
			String[] otsDueDt = (JSPUtil.getParameter(request, prefix	+ "ots_due_dt", length));
			String[] otsLoclAmt = (JSPUtil.getParameter(request, prefix	+ "ots_locl_amt", length));
			String[] insurTpCd = (JSPUtil.getParameter(request, prefix	+ "insur_tp_cd", length));
			String[] insurClmPtyNmPrm = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_nm_prm", length));
			String[] ttlDueDt = (JSPUtil.getParameter(request, prefix	+ "ttl_due_dt", length));
			String[] rfndLoclAmt = (JSPUtil.getParameter(request, prefix	+ "rfnd_locl_amt", length));
			String[] ttlPayDt = (JSPUtil.getParameter(request, prefix	+ "ttl_pay_dt", length));
			String[] adjDueDt = (JSPUtil.getParameter(request, prefix	+ "adj_due_dt", length));
			String[] ttlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_usd_amt", length));
			String[] adjPayDt = (JSPUtil.getParameter(request, prefix	+ "adj_pay_dt", length));
			String[] insurPrmTpCd = (JSPUtil.getParameter(request, prefix	+ "insur_prm_tp_cd", length));
			String[] rfndPayDt = (JSPUtil.getParameter(request, prefix	+ "rfnd_pay_dt", length));
			String[] ttlCurrCd = (JSPUtil.getParameter(request, prefix	+ "ttl_curr_cd", length));
			String[] otsCurrCd = (JSPUtil.getParameter(request, prefix	+ "ots_curr_cd", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] ttlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_locl_amt", length));
			String[] insurClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_no", length));
			String[] otsXchRt = (JSPUtil.getParameter(request, prefix	+ "ots_xch_rt", length));
			String[] adjUsdAmt = (JSPUtil.getParameter(request, prefix	+ "adj_usd_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPremiumVO();
				if (ttlXchRt[i] != null)
					model.setTtlXchRt(ttlXchRt[i]);
				if (rfndXchRt[i] != null)
					model.setRfndXchRt(rfndXchRt[i]);
				if (rfndDueDt[i] != null)
					model.setRfndDueDt(rfndDueDt[i]);
				if (adjCurrCd[i] != null)
					model.setAdjCurrCd(adjCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (otsPayDt[i] != null)
					model.setOtsPayDt(otsPayDt[i]);
				if (rfndUsdAmt[i] != null)
					model.setRfndUsdAmt(rfndUsdAmt[i]);
				if (adjLoclAmt[i] != null)
					model.setAdjLoclAmt(adjLoclAmt[i]);
				if (insurPlcyYr[i] != null)
					model.setInsurPlcyYr(insurPlcyYr[i]);
				if (rfndCurrCd[i] != null)
					model.setRfndCurrCd(rfndCurrCd[i]);
				if (adjXchRt[i] != null)
					model.setAdjXchRt(adjXchRt[i]);
				if (insurClmPtyNoPrm[i] != null)
					model.setInsurClmPtyNoPrm(insurClmPtyNoPrm[i]);
				if (otsUsdAmt[i] != null)
					model.setOtsUsdAmt(otsUsdAmt[i]);
				if (otsDueDt[i] != null)
					model.setOtsDueDt(otsDueDt[i]);
				if (otsLoclAmt[i] != null)
					model.setOtsLoclAmt(otsLoclAmt[i]);
				if (insurTpCd[i] != null)
					model.setInsurTpCd(insurTpCd[i]);
				if (insurClmPtyNmPrm[i] != null)
					model.setInsurClmPtyNmPrm(insurClmPtyNmPrm[i]);
				if (ttlDueDt[i] != null)
					model.setTtlDueDt(ttlDueDt[i]);
				if (rfndLoclAmt[i] != null)
					model.setRfndLoclAmt(rfndLoclAmt[i]);
				if (ttlPayDt[i] != null)
					model.setTtlPayDt(ttlPayDt[i]);
				if (adjDueDt[i] != null)
					model.setAdjDueDt(adjDueDt[i]);
				if (ttlUsdAmt[i] != null)
					model.setTtlUsdAmt(ttlUsdAmt[i]);
				if (adjPayDt[i] != null)
					model.setAdjPayDt(adjPayDt[i]);
				if (insurPrmTpCd[i] != null)
					model.setInsurPrmTpCd(insurPrmTpCd[i]);
				if (rfndPayDt[i] != null)
					model.setRfndPayDt(rfndPayDt[i]);
				if (ttlCurrCd[i] != null)
					model.setTtlCurrCd(ttlCurrCd[i]);
				if (otsCurrCd[i] != null)
					model.setOtsCurrCd(otsCurrCd[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (ttlLoclAmt[i] != null)
					model.setTtlLoclAmt(ttlLoclAmt[i]);
				if (insurClmPtyNo[i] != null)
					model.setInsurClmPtyNo(insurClmPtyNo[i]);
				if (otsXchRt[i] != null)
					model.setOtsXchRt(otsXchRt[i]);
				if (adjUsdAmt[i] != null)
					model.setAdjUsdAmt(adjUsdAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPremiumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPremiumVO[]
	 */
	public SearchPremiumVO[] getSearchPremiumVOs(){
		SearchPremiumVO[] vos = (SearchPremiumVO[])models.toArray(new SearchPremiumVO[models.size()]);
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
		this.ttlXchRt = this.ttlXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfndXchRt = this.rfndXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfndDueDt = this.rfndDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjCurrCd = this.adjCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsPayDt = this.otsPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfndUsdAmt = this.rfndUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjLoclAmt = this.adjLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurPlcyYr = this.insurPlcyYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfndCurrCd = this.rfndCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjXchRt = this.adjXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNoPrm = this.insurClmPtyNoPrm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsUsdAmt = this.otsUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDueDt = this.otsDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsLoclAmt = this.otsLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurTpCd = this.insurTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNmPrm = this.insurClmPtyNmPrm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDueDt = this.ttlDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfndLoclAmt = this.rfndLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPayDt = this.ttlPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjDueDt = this.adjDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlUsdAmt = this.ttlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjPayDt = this.adjPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurPrmTpCd = this.insurPrmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfndPayDt = this.rfndPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCurrCd = this.ttlCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsCurrCd = this.otsCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoclAmt = this.ttlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNo = this.insurClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsXchRt = this.otsXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjUsdAmt = this.adjUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
