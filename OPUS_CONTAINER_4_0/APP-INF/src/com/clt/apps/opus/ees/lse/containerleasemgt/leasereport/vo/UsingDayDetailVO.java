/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsingDayDetailVO.java
*@FileTitle : UsingDayDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.10.15 장준우
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo;

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
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsingDayDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<UsingDayDetailVO> models = new ArrayList<UsingDayDetailVO>();

	/* Column Info */
	private String dppAmt = null;
	/* Column Info */
	private String offHrDt = null;
	/* Column Info */
	private String dcrAmt = null;
	/* Column Info */
	private String termChgFlg = null;
	/* Column Info */
	private String usedDys = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String mtDrayageCost = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lonAmt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String pdmAmt = null;
	/* Column Info */
	private String offHrYdCd = null;
	/* Column Info */
	private String rntlChgFreeDys = null;
	/* Column Info */
	private String onhDrayageCost = null;
	/* Column Info */
	private String mnrCost = null;
	/* Column Info */
	private String onHrDt = null;
	/* Column Info */
	private String minOhDays = null;
	/* Column Info */
	private String pcrAmt = null;
	/* Column Info */
	private String pucAmt = null;
	/* Column Info */
	private String lofAmt = null;
	/* Column Info */
	private String docAmt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String onHrYdCd = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String diiFlg = null;
	/* Column Info */
	private String offhDrayageCost = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String lstmCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public UsingDayDetailVO() {}

	public UsingDayDetailVO(String ibflag, String pagerows, String lstmCd, String agmtNo, String refNo, String cntrNo, String cntrTpszCd, String onHrDt, String onHrYdCd, String rntlChgFreeDys, String offHrDt, String offHrYdCd, String usedDys, String crntYdCd, String cnmvStsCd, String mtDrayageCost, String termChgFlg, String diiFlg, String imdtExtFlg, String pdmAmt, String lonAmt, String pucAmt, String pcrAmt, String lofAmt, String minOhDays, String docAmt, String dcrAmt, String onhDrayageCost, String offhDrayageCost, String mnrCost, String dppAmt, String ttlAmt) {
		this.dppAmt = dppAmt;
		this.offHrDt = offHrDt;
		this.dcrAmt = dcrAmt;
		this.termChgFlg = termChgFlg;
		this.usedDys = usedDys;
		this.crntYdCd = crntYdCd;
		this.ttlAmt = ttlAmt;
		this.mtDrayageCost = mtDrayageCost;
		this.pagerows = pagerows;
		this.cnmvStsCd = cnmvStsCd;
		this.ibflag = ibflag;
		this.lonAmt = lonAmt;
		this.cntrTpszCd = cntrTpszCd;
		this.pdmAmt = pdmAmt;
		this.offHrYdCd = offHrYdCd;
		this.rntlChgFreeDys = rntlChgFreeDys;
		this.onhDrayageCost = onhDrayageCost;
		this.mnrCost = mnrCost;
		this.onHrDt = onHrDt;
		this.minOhDays = minOhDays;
		this.pcrAmt = pcrAmt;
		this.pucAmt = pucAmt;
		this.lofAmt = lofAmt;
		this.docAmt = docAmt;
		this.cntrNo = cntrNo;
		this.onHrYdCd = onHrYdCd;
		this.imdtExtFlg = imdtExtFlg;
		this.diiFlg = diiFlg;
		this.offhDrayageCost = offhDrayageCost;
		this.agmtNo = agmtNo;
		this.refNo = refNo;
		this.lstmCd = lstmCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dpp_amt", getDppAmt());
		this.hashColumns.put("off_hr_dt", getOffHrDt());
		this.hashColumns.put("dcr_amt", getDcrAmt());
		this.hashColumns.put("term_chg_flg", getTermChgFlg());
		this.hashColumns.put("used_dys", getUsedDys());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("mt_drayage_cost", getMtDrayageCost());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lon_amt", getLonAmt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pdm_amt", getPdmAmt());
		this.hashColumns.put("off_hr_yd_cd", getOffHrYdCd());
		this.hashColumns.put("rntl_chg_free_dys", getRntlChgFreeDys());
		this.hashColumns.put("onh_drayage_cost", getOnhDrayageCost());
		this.hashColumns.put("mnr_cost", getMnrCost());
		this.hashColumns.put("on_hr_dt", getOnHrDt());
		this.hashColumns.put("min_oh_days", getMinOhDays());
		this.hashColumns.put("pcr_amt", getPcrAmt());
		this.hashColumns.put("puc_amt", getPucAmt());
		this.hashColumns.put("lof_amt", getLofAmt());
		this.hashColumns.put("doc_amt", getDocAmt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("on_hr_yd_cd", getOnHrYdCd());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("dii_flg", getDiiFlg());
		this.hashColumns.put("offh_drayage_cost", getOffhDrayageCost());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("lstm_cd", getLstmCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dpp_amt", "dppAmt");
		this.hashFields.put("off_hr_dt", "offHrDt");
		this.hashFields.put("dcr_amt", "dcrAmt");
		this.hashFields.put("term_chg_flg", "termChgFlg");
		this.hashFields.put("used_dys", "usedDys");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("mt_drayage_cost", "mtDrayageCost");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lon_amt", "lonAmt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pdm_amt", "pdmAmt");
		this.hashFields.put("off_hr_yd_cd", "offHrYdCd");
		this.hashFields.put("rntl_chg_free_dys", "rntlChgFreeDys");
		this.hashFields.put("onh_drayage_cost", "onhDrayageCost");
		this.hashFields.put("mnr_cost", "mnrCost");
		this.hashFields.put("on_hr_dt", "onHrDt");
		this.hashFields.put("min_oh_days", "minOhDays");
		this.hashFields.put("pcr_amt", "pcrAmt");
		this.hashFields.put("puc_amt", "pucAmt");
		this.hashFields.put("lof_amt", "lofAmt");
		this.hashFields.put("doc_amt", "docAmt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("on_hr_yd_cd", "onHrYdCd");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("dii_flg", "diiFlg");
		this.hashFields.put("offh_drayage_cost", "offhDrayageCost");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("lstm_cd", "lstmCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return dppAmt
	 */
	public String getDppAmt() {
		return this.dppAmt;
	}

	/**
	 * Column Info
	 * @return offHrDt
	 */
	public String getOffHrDt() {
		return this.offHrDt;
	}

	/**
	 * Column Info
	 * @return dcrAmt
	 */
	public String getDcrAmt() {
		return this.dcrAmt;
	}

	/**
	 * Column Info
	 * @return termChgFlg
	 */
	public String getTermChgFlg() {
		return this.termChgFlg;
	}

	/**
	 * Column Info
	 * @return usedDys
	 */
	public String getUsedDys() {
		return this.usedDys;
	}

	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}

	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}

	/**
	 * Column Info
	 * @return mtDrayageCost
	 */
	public String getMtDrayageCost() {
		return this.mtDrayageCost;
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
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return lonAmt
	 */
	public String getLonAmt() {
		return this.lonAmt;
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
	 * @return pdmAmt
	 */
	public String getPdmAmt() {
		return this.pdmAmt;
	}

	/**
	 * Column Info
	 * @return offHrYdCd
	 */
	public String getOffHrYdCd() {
		return this.offHrYdCd;
	}

	/**
	 * Column Info
	 * @return rntlChgFreeDys
	 */
	public String getRntlChgFreeDys() {
		return this.rntlChgFreeDys;
	}

	/**
	 * Column Info
	 * @return onhDrayageCost
	 */
	public String getOnhDrayageCost() {
		return this.onhDrayageCost;
	}

	/**
	 * Column Info
	 * @return mnrCost
	 */
	public String getMnrCost() {
		return this.mnrCost;
	}

	/**
	 * Column Info
	 * @return onHrDt
	 */
	public String getOnHrDt() {
		return this.onHrDt;
	}

	/**
	 * Column Info
	 * @return minOhDays
	 */
	public String getMinOhDays() {
		return this.minOhDays;
	}

	/**
	 * Column Info
	 * @return pcrAmt
	 */
	public String getPcrAmt() {
		return this.pcrAmt;
	}

	/**
	 * Column Info
	 * @return pucAmt
	 */
	public String getPucAmt() {
		return this.pucAmt;
	}

	/**
	 * Column Info
	 * @return lofAmt
	 */
	public String getLofAmt() {
		return this.lofAmt;
	}

	/**
	 * Column Info
	 * @return docAmt
	 */
	public String getDocAmt() {
		return this.docAmt;
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
	 * @return onHrYdCd
	 */
	public String getOnHrYdCd() {
		return this.onHrYdCd;
	}

	/**
	 * Column Info
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}

	/**
	 * Column Info
	 * @return diiFlg
	 */
	public String getDiiFlg() {
		return this.diiFlg;
	}

	/**
	 * Column Info
	 * @return offhDrayageCost
	 */
	public String getOffhDrayageCost() {
		return this.offhDrayageCost;
	}


	/**
	 * Column Info
	 * @param dppAmt
	 */
	public void setDppAmt(String dppAmt) {
		this.dppAmt = dppAmt;
	}

	/**
	 * Column Info
	 * @param offHrDt
	 */
	public void setOffHrDt(String offHrDt) {
		this.offHrDt = offHrDt;
	}

	/**
	 * Column Info
	 * @param dcrAmt
	 */
	public void setDcrAmt(String dcrAmt) {
		this.dcrAmt = dcrAmt;
	}

	/**
	 * Column Info
	 * @param termChgFlg
	 */
	public void setTermChgFlg(String termChgFlg) {
		this.termChgFlg = termChgFlg;
	}

	/**
	 * Column Info
	 * @param usedDys
	 */
	public void setUsedDys(String usedDys) {
		this.usedDys = usedDys;
	}

	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}

	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}

	/**
	 * Column Info
	 * @param mtDrayageCost
	 */
	public void setMtDrayageCost(String mtDrayageCost) {
		this.mtDrayageCost = mtDrayageCost;
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
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param lonAmt
	 */
	public void setLonAmt(String lonAmt) {
		this.lonAmt = lonAmt;
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
	 * @param pdmAmt
	 */
	public void setPdmAmt(String pdmAmt) {
		this.pdmAmt = pdmAmt;
	}

	/**
	 * Column Info
	 * @param offHrYdCd
	 */
	public void setOffHrYdCd(String offHrYdCd) {
		this.offHrYdCd = offHrYdCd;
	}

	/**
	 * Column Info
	 * @param rntlChgFreeDys
	 */
	public void setRntlChgFreeDys(String rntlChgFreeDys) {
		this.rntlChgFreeDys = rntlChgFreeDys;
	}

	/**
	 * Column Info
	 * @param onhDrayageCost
	 */
	public void setOnhDrayageCost(String onhDrayageCost) {
		this.onhDrayageCost = onhDrayageCost;
	}

	/**
	 * Column Info
	 * @param mnrCost
	 */
	public void setMnrCost(String mnrCost) {
		this.mnrCost = mnrCost;
	}

	/**
	 * Column Info
	 * @param onHrDt
	 */
	public void setOnHrDt(String onHrDt) {
		this.onHrDt = onHrDt;
	}

	/**
	 * Column Info
	 * @param minOhDays
	 */
	public void setMinOhDays(String minOhDays) {
		this.minOhDays = minOhDays;
	}

	/**
	 * Column Info
	 * @param pcrAmt
	 */
	public void setPcrAmt(String pcrAmt) {
		this.pcrAmt = pcrAmt;
	}

	/**
	 * Column Info
	 * @param pucAmt
	 */
	public void setPucAmt(String pucAmt) {
		this.pucAmt = pucAmt;
	}

	/**
	 * Column Info
	 * @param lofAmt
	 */
	public void setLofAmt(String lofAmt) {
		this.lofAmt = lofAmt;
	}

	/**
	 * Column Info
	 * @param docAmt
	 */
	public void setDocAmt(String docAmt) {
		this.docAmt = docAmt;
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
	 * @param onHrYdCd
	 */
	public void setOnHrYdCd(String onHrYdCd) {
		this.onHrYdCd = onHrYdCd;
	}

	/**
	 * Column Info
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}

	/**
	 * Column Info
	 * @param diiFlg
	 */
	public void setDiiFlg(String diiFlg) {
		this.diiFlg = diiFlg;
	}

	/**
	 * Column Info
	 * @param offhDrayageCost
	 */
	public void setOffhDrayageCost(String offhDrayageCost) {
		this.offhDrayageCost = offhDrayageCost;
	}

	/**
	 * @return the agmtNo
	 */
	public String getAgmtNo() {
		return agmtNo;
	}

	/**
	 * @param agmtNo the agmtNo to set
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	/**
	 * @return the refNo
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * @param refNo the refNo to set
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * @return the lstmCd
	 */
	public String getLstmCd() {
		return lstmCd;
	}

	/**
	 * @param lstmCd the lstmCd to set
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDppAmt(JSPUtil.getParameter(request, "dpp_amt", ""));
		setOffHrDt(JSPUtil.getParameter(request, "off_hr_dt", ""));
		setDcrAmt(JSPUtil.getParameter(request, "dcr_amt", ""));
		setTermChgFlg(JSPUtil.getParameter(request, "term_chg_flg", ""));
		setUsedDys(JSPUtil.getParameter(request, "used_dys", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setTtlAmt(JSPUtil.getParameter(request, "ttl_amt", ""));
		setMtDrayageCost(JSPUtil.getParameter(request, "mt_drayage_cost", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLonAmt(JSPUtil.getParameter(request, "lon_amt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setPdmAmt(JSPUtil.getParameter(request, "pdm_amt", ""));
		setOffHrYdCd(JSPUtil.getParameter(request, "off_hr_yd_cd", ""));
		setRntlChgFreeDys(JSPUtil.getParameter(request, "rntl_chg_free_dys", ""));
		setOnhDrayageCost(JSPUtil.getParameter(request, "onh_drayage_cost", ""));
		setMnrCost(JSPUtil.getParameter(request, "mnr_cost", ""));
		setOnHrDt(JSPUtil.getParameter(request, "on_hr_dt", ""));
		setMinOhDays(JSPUtil.getParameter(request, "min_oh_days", ""));
		setPcrAmt(JSPUtil.getParameter(request, "pcr_amt", ""));
		setPucAmt(JSPUtil.getParameter(request, "puc_amt", ""));
		setLofAmt(JSPUtil.getParameter(request, "lof_amt", ""));
		setDocAmt(JSPUtil.getParameter(request, "doc_amt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setOnHrYdCd(JSPUtil.getParameter(request, "on_hr_yd_cd", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, "imdt_ext_flg", ""));
		setDiiFlg(JSPUtil.getParameter(request, "dii_flg", ""));
		setOffhDrayageCost(JSPUtil.getParameter(request, "offh_drayage_cost", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsingDayDetailVO[]
	 */
	public UsingDayDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return UsingDayDetailVO[]
	 */
	public UsingDayDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsingDayDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] dppAmt = (JSPUtil.getParameter(request, prefix	+ "dpp_amt", length));
			String[] offHrDt = (JSPUtil.getParameter(request, prefix	+ "off_hr_dt", length));
			String[] dcrAmt = (JSPUtil.getParameter(request, prefix	+ "dcr_amt", length));
			String[] termChgFlg = (JSPUtil.getParameter(request, prefix	+ "term_chg_flg", length));
			String[] usedDys = (JSPUtil.getParameter(request, prefix	+ "used_dys", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] mtDrayageCost = (JSPUtil.getParameter(request, prefix	+ "mt_drayage_cost", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lonAmt = (JSPUtil.getParameter(request, prefix	+ "lon_amt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] pdmAmt = (JSPUtil.getParameter(request, prefix	+ "pdm_amt", length));
			String[] offHrYdCd = (JSPUtil.getParameter(request, prefix	+ "off_hr_yd_cd", length));
			String[] rntlChgFreeDys = (JSPUtil.getParameter(request, prefix	+ "rntl_chg_free_dys", length));
			String[] onhDrayageCost = (JSPUtil.getParameter(request, prefix	+ "onh_drayage_cost", length));
			String[] mnrCost = (JSPUtil.getParameter(request, prefix	+ "mnr_cost", length));
			String[] onHrDt = (JSPUtil.getParameter(request, prefix	+ "on_hr_dt", length));
			String[] minOhDays = (JSPUtil.getParameter(request, prefix	+ "min_oh_days", length));
			String[] pcrAmt = (JSPUtil.getParameter(request, prefix	+ "pcr_amt", length));
			String[] pucAmt = (JSPUtil.getParameter(request, prefix	+ "puc_amt", length));
			String[] lofAmt = (JSPUtil.getParameter(request, prefix	+ "lof_amt", length));
			String[] docAmt = (JSPUtil.getParameter(request, prefix	+ "doc_amt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] onHrYdCd = (JSPUtil.getParameter(request, prefix	+ "on_hr_yd_cd", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] diiFlg = (JSPUtil.getParameter(request, prefix	+ "dii_flg", length));
			String[] offhDrayageCost = (JSPUtil.getParameter(request, prefix	+ "offh_drayage_cost", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));

			for (int i = 0; i < length; i++) {
				model = new UsingDayDetailVO();
				if (dppAmt[i] != null)
					model.setDppAmt(dppAmt[i]);
				if (offHrDt[i] != null)
					model.setOffHrDt(offHrDt[i]);
				if (dcrAmt[i] != null)
					model.setDcrAmt(dcrAmt[i]);
				if (termChgFlg[i] != null)
					model.setTermChgFlg(termChgFlg[i]);
				if (usedDys[i] != null)
					model.setUsedDys(usedDys[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (mtDrayageCost[i] != null)
					model.setMtDrayageCost(mtDrayageCost[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lonAmt[i] != null)
					model.setLonAmt(lonAmt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pdmAmt[i] != null)
					model.setPdmAmt(pdmAmt[i]);
				if (offHrYdCd[i] != null)
					model.setOffHrYdCd(offHrYdCd[i]);
				if (rntlChgFreeDys[i] != null)
					model.setRntlChgFreeDys(rntlChgFreeDys[i]);
				if (onhDrayageCost[i] != null)
					model.setOnhDrayageCost(onhDrayageCost[i]);
				if (mnrCost[i] != null)
					model.setMnrCost(mnrCost[i]);
				if (onHrDt[i] != null)
					model.setOnHrDt(onHrDt[i]);
				if (minOhDays[i] != null)
					model.setMinOhDays(minOhDays[i]);
				if (pcrAmt[i] != null)
					model.setPcrAmt(pcrAmt[i]);
				if (pucAmt[i] != null)
					model.setPucAmt(pucAmt[i]);
				if (lofAmt[i] != null)
					model.setLofAmt(lofAmt[i]);
				if (docAmt[i] != null)
					model.setDocAmt(docAmt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (onHrYdCd[i] != null)
					model.setOnHrYdCd(onHrYdCd[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (diiFlg[i] != null)
					model.setDiiFlg(diiFlg[i]);
				if (offhDrayageCost[i] != null)
					model.setOffhDrayageCost(offhDrayageCost[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsingDayDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsingDayDetailVO[]
	 */
	public UsingDayDetailVO[] getUsingDayDetailVOs(){
		UsingDayDetailVO[] vos = (UsingDayDetailVO[])models.toArray(new UsingDayDetailVO[models.size()]);
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
		this.dppAmt = this.dppAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offHrDt = this.offHrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcrAmt = this.dcrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termChgFlg = this.termChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usedDys = this.usedDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtDrayageCost = this.mtDrayageCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lonAmt = this.lonAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdmAmt = this.pdmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offHrYdCd = this.offHrYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlChgFreeDys = this.rntlChgFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDrayageCost = this.onhDrayageCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCost = this.mnrCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onHrDt = this.onHrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minOhDays = this.minOhDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcrAmt = this.pcrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pucAmt = this.pucAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lofAmt = this.lofAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docAmt = this.docAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onHrYdCd = this.onHrYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diiFlg = this.diiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDrayageCost = this.offhDrayageCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
