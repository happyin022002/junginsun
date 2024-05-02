/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SubLeaseOutDetailVO.java
*@FileTitle : SubLeaseOutDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.08.13 장준우
* 1.0 Creation
* ================================
* 2010.12.01 박명신 [CHM-201007443-01] REF_NO 항목 추가
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo;

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
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SubLeaseOutDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SubLeaseOutDetailVO> models = new ArrayList<SubLeaseOutDetailVO>();

	/* Column Info */
	private String cntrFullFlg = null;
	/* Column Info */
	private String cntrStsEvntDt = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String lsiAgmtCtyCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String lsiAgmtSeq = null;
	/* Column Info */
	private String cntrStsCd = null;
	/* Column Info */
	private String ttlUseDys = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String lsiAgmtNo = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String lsiRefNo = null;
	/* Column Info */
	private String rccCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lccCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrNo = null;	
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntryCd = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String rntlChgFreeDys = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String pdmAmt = null;
	/* Column Info */
	private String lonAmt = null;
	/* Column Info */
	private String lofAmt = null;
	/* Column Info */
	private String docAmt = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String cntrRtnEvntDt = null;
	/* Column Info */
	private String rtnYdCd = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SubLeaseOutDetailVO() {}

	public SubLeaseOutDetailVO(String ibflag, String pagerows, String cntrRtnEvntDt, String rtnYdCd, String pdmAmt, String lonAmt, String lofAmt, String docAmt, String ttlAmt, String cntrNo, String cntrStsCd, String cntrTpszCd, String lstmCd, String locCd, String cntrStsEvntDt, String rccCd, String lccCd, String sccCd, String ydCd, String cntryCd, String agmtCtyCd, String lsiAgmtCtyCd, String agmtSeq, String lsiAgmtSeq, String agmtNo, String refNo, String lsiRefNo, String lsiAgmtNo, String vndrSeq, String vndrAbbrNm, String cntrFullFlg, String rntlChgFreeDys, String ttlUseDys) {
		this.cntrFullFlg = cntrFullFlg;
		this.cntrStsEvntDt = cntrStsEvntDt;
		this.agmtSeq = agmtSeq;
		this.lsiAgmtSeq = lsiAgmtSeq;
		this.cntrStsCd = cntrStsCd;
		this.ttlUseDys = ttlUseDys;
		this.agmtNo = agmtNo;
		this.lsiAgmtNo = lsiAgmtNo;
		this.refNo = refNo;
		this.lsiRefNo = lsiRefNo;		
		this.rccCd = rccCd;
		this.pagerows = pagerows;
		this.lccCd = lccCd;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.sccCd = sccCd;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.cntrNo = cntrNo;
		this.agmtCtyCd = agmtCtyCd;
		this.lsiAgmtCtyCd = lsiAgmtCtyCd;		
		this.cntrTpszCd = cntrTpszCd;
		this.cntryCd = cntryCd;
		this.vndrAbbrNm = vndrAbbrNm;
		this.rntlChgFreeDys = rntlChgFreeDys;
		this.lstmCd = lstmCd;
		this.pdmAmt = pdmAmt;
		this.lonAmt = lonAmt;
		this.lofAmt = lofAmt;
		this.docAmt = docAmt;
		this.ttlAmt = ttlAmt;
		this.cntrRtnEvntDt = cntrRtnEvntDt;
		this.rtnYdCd = rtnYdCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_full_flg", getCntrFullFlg());
		this.hashColumns.put("cntr_sts_evnt_dt", getCntrStsEvntDt());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("lsi_agmt_seq", getLsiAgmtSeq());
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());
		this.hashColumns.put("ttl_use_dys", getTtlUseDys());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("lsi_agmt_no", getLsiAgmtNo());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("lsi_ref_no", getLsiRefNo());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("lsi_agmt_cty_cd", getLsiAgmtCtyCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntry_cd", getCntryCd());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("rntl_chg_free_dys", getRntlChgFreeDys());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("pdm_amt", getPdmAmt());
		this.hashColumns.put("lon_amt", getLonAmt());
		this.hashColumns.put("lof_amt", getLofAmt());
		this.hashColumns.put("doc_amt", getDocAmt());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("cntr_rtn_evnt_dt", getCntrRtnEvntDt());
		this.hashColumns.put("rtn_yd_cd", getRtnYdCd());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_full_flg", "cntrFullFlg");
		this.hashFields.put("cntr_sts_evnt_dt", "cntrStsEvntDt");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("lsi_agmt_seq", "lsiAgmtSeq");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("ttl_use_dys", "ttlUseDys");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("lsi_agmt_no", "lsiAgmtNo");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("lsi_ref_no", "lsiRefNo");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("lsi_agmt_cty_cd", "lsiAgmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntry_cd", "cntryCd");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("rntl_chg_free_dys", "rntlChgFreeDys");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("pdm_amt", "pdmAmt");
		this.hashFields.put("lon_amt", "lonAmt");
		this.hashFields.put("lof_amt", "lofAmt");
		this.hashFields.put("doc_amt", "docAmt");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("cntr_rtn_evnt_dt", "cntrRtnEvntDt");
		this.hashFields.put("rtn_yd_cd", "rtnYdCd");

		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return cntrFullFlg
	 */
	public String getCntrFullFlg() {
		return this.cntrFullFlg;
	}

	/**
	 * Column Info
	 * @return cntrStsEvntDt
	 */
	public String getCntrStsEvntDt() {
		return this.cntrStsEvntDt;
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
	 * @return lsiAgmtSeq
	 */
	public String getLsiAgmtSeq() {
		return this.lsiAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrStsCd
	 */
	public String getCntrStsCd() {
		return this.cntrStsCd;
	}

	/**
	 * Column Info
	 * @return ttlUseDys
	 */
	public String getTtlUseDys() {
		return this.ttlUseDys;
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
	 * @return lsiAgmtNo
	 */
	public String getLsiAgmtNo() {
		return this.lsiAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return lsiRefNo
	 */
	public String getLsiRefNo() {
		return this.lsiRefNo;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
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
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
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
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return lsiAgmtCtyCd
	 */
	public String getLsiAgmtCtyCd() {
		return this.lsiAgmtCtyCd;
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
	 * @return cntryCd
	 */
	public String getCntryCd() {
		return this.cntryCd;
	}

	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
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
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}


	/**
	 * Column Info
	 * @param cntrFullFlg
	 */
	public void setCntrFullFlg(String cntrFullFlg) {
		this.cntrFullFlg = cntrFullFlg;
	}

	/**
	 * Column Info
	 * @param cntrStsEvntDt
	 */
	public void setCntrStsEvntDt(String cntrStsEvntDt) {
		this.cntrStsEvntDt = cntrStsEvntDt;
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
	 * @param lsiAgmtSeq
	 */
	public void setLsiAgmtSeq(String lsiAgmtSeq) {
		this.lsiAgmtSeq = lsiAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrStsCd
	 */
	public void setCntrStsCd(String cntrStsCd) {
		this.cntrStsCd = cntrStsCd;
	}

	/**
	 * Column Info
	 * @param ttlUseDys
	 */
	public void setTtlUseDys(String ttlUseDys) {
		this.ttlUseDys = ttlUseDys;
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
	 * @param lsiAgmtNo
	 */
	public void setLsiAgmtNo(String lsiAgmtNo) {
		this.lsiAgmtNo = lsiAgmtNo;
	}

	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param lsiRefNo
	 */
	public void setLsiRefNo(String lsiRefNo) {
		this.lsiRefNo = lsiRefNo;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
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
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
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
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	/**
	 * Column Info
	 * @param lsiAgmtCtyCd
	 */
	public void setLsiAgmtCtyCd(String lsiAgmtCtyCd) {
		this.lsiAgmtCtyCd = lsiAgmtCtyCd;
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
	 * @param cntryCd
	 */
	public void setCntryCd(String cntryCd) {
		this.cntryCd = cntryCd;
	}

	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
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
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	/**
	 * @return the pdmAmt
	 */
	public String getPdmAmt() {
		return pdmAmt;
	}

	/**
	 * @param pdmAmt the pdmAmt to set
	 */
	public void setPdmAmt(String pdmAmt) {
		this.pdmAmt = pdmAmt;
	}

	/**
	 * @return the lonAmt
	 */
	public String getLonAmt() {
		return lonAmt;
	}

	/**
	 * @param lonAmt the lonAmt to set
	 */
	public void setLonAmt(String lonAmt) {
		this.lonAmt = lonAmt;
	}

	/**
	 * @return the lofAmt
	 */
	public String getLofAmt() {
		return lofAmt;
	}

	/**
	 * @param lofAmt the lofAmt to set
	 */
	public void setLofAmt(String lofAmt) {
		this.lofAmt = lofAmt;
	}

	/**
	 * @return the docAmt
	 */
	public String getDocAmt() {
		return docAmt;
	}

	/**
	 * @param docAmt the docAmt to set
	 */
	public void setDocAmt(String docAmt) {
		this.docAmt = docAmt;
	}

	/**
	 * @return the ttlAmt
	 */
	public String getTtlAmt() {
		return ttlAmt;
	}

	/**
	 * @param ttlAmt the ttlAmt to set
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}

	/**
	 * @return the cntrRtnEvntDt
	 */
	public String getCntrRtnEvntDt() {
		return cntrRtnEvntDt;
	}

	/**
	 * @param cntrRtnEvntDt the cntrRtnEvntDt to set
	 */
	public void setCntrRtnEvntDt(String cntrRtnEvntDt) {
		this.cntrRtnEvntDt = cntrRtnEvntDt;
	}

	/**
	 * @return the rtnYdCd
	 */
	public String getRtnYdCd() {
		return rtnYdCd;
	}

	/**
	 * @param rtnYdCd the rtnYdCd to set
	 */
	public void setRtnYdCd(String rtnYdCd) {
		this.rtnYdCd = rtnYdCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrFullFlg(JSPUtil.getParameter(request, "cntr_full_flg", ""));
		setCntrStsEvntDt(JSPUtil.getParameter(request, "cntr_sts_evnt_dt", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setLsiAgmtSeq(JSPUtil.getParameter(request, "lsi_agmt_seq", ""));
		setCntrStsCd(JSPUtil.getParameter(request, "cntr_sts_cd", ""));
		setTtlUseDys(JSPUtil.getParameter(request, "ttl_use_dys", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setLsiAgmtNo(JSPUtil.getParameter(request, "lsi_agmt_no", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLccCd(JSPUtil.getParameter(request, "lcc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setLsiAgmtCtyCd(JSPUtil.getParameter(request, "lsi_agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntryCd(JSPUtil.getParameter(request, "cntry_cd", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setRntlChgFreeDys(JSPUtil.getParameter(request, "rntl_chg_free_dys", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setPdmAmt(JSPUtil.getParameter(request, "pdm_amt", ""));
		setLonAmt(JSPUtil.getParameter(request, "lon_amt", ""));
		setLofAmt(JSPUtil.getParameter(request, "lof_amt", ""));
		setDocAmt(JSPUtil.getParameter(request, "doc_amt", ""));
		setTtlAmt(JSPUtil.getParameter(request, "ttl_amt", ""));
		setCntrRtnEvntDt(JSPUtil.getParameter(request, "cntr_rtn_evnt_dt", ""));
		setRtnYdCd(JSPUtil.getParameter(request, "rtn_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SubLeaseOutDetailVO[]
	 */
	public SubLeaseOutDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SubLeaseOutDetailVO[]
	 */
	public SubLeaseOutDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SubLeaseOutDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cntrFullFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_full_flg", length));
			String[] cntrStsEvntDt = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_evnt_dt", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] lsiAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "lsi_agmt_seq", length));
			String[] cntrStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd", length));
			String[] ttlUseDys = (JSPUtil.getParameter(request, prefix	+ "ttl_use_dys", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] lsiAgmtNo = (JSPUtil.getParameter(request, prefix	+ "lsi_agmt_no", length));			
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] lsiRefNo = (JSPUtil.getParameter(request, prefix	+ "lsi_ref_no", length));			
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] lsiAgmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "lsi_agmt_cty_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntryCd = (JSPUtil.getParameter(request, prefix	+ "cntry_cd", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] rntlChgFreeDys = (JSPUtil.getParameter(request, prefix	+ "rntl_chg_free_dys", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] pdmAmt = (JSPUtil.getParameter(request, prefix	+ "pdm_amt", length));
			String[] lonAmt = (JSPUtil.getParameter(request, prefix	+ "lon_amt", length));
			String[] lofAmt = (JSPUtil.getParameter(request, prefix	+ "lof_amt", length));
			String[] docAmt = (JSPUtil.getParameter(request, prefix	+ "doc_amt", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] cntrRtnEvntDt = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_evnt_dt", length));
			String[] rtnYdCd = (JSPUtil.getParameter(request, prefix	+ "rtn_yd_cd", length));

			for (int i = 0; i < length; i++) {
				model = new SubLeaseOutDetailVO();
				if (cntrFullFlg[i] != null)
					model.setCntrFullFlg(cntrFullFlg[i]);
				if (cntrStsEvntDt[i] != null)
					model.setCntrStsEvntDt(cntrStsEvntDt[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (lsiAgmtSeq[i] != null)
					model.setLsiAgmtSeq(lsiAgmtSeq[i]);
				if (cntrStsCd[i] != null)
					model.setCntrStsCd(cntrStsCd[i]);
				if (ttlUseDys[i] != null)
					model.setTtlUseDys(ttlUseDys[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (lsiAgmtNo[i] != null)
					model.setLsiAgmtNo(lsiAgmtNo[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (lsiRefNo[i] != null)
					model.setLsiRefNo(lsiRefNo[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (lsiAgmtCtyCd[i] != null)
					model.setLsiAgmtCtyCd(lsiAgmtCtyCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntryCd[i] != null)
					model.setCntryCd(cntryCd[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (rntlChgFreeDys[i] != null)
					model.setRntlChgFreeDys(rntlChgFreeDys[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (pdmAmt[i] != null)
					model.setPdmAmt(pdmAmt[i]);
				if (lonAmt[i] != null)
					model.setLonAmt(lonAmt[i]);
				if (lofAmt[i] != null)
					model.setLofAmt(lofAmt[i]);
				if (docAmt[i] != null)
					model.setDocAmt(docAmt[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (cntrRtnEvntDt[i] != null)
					model.setCntrRtnEvntDt(cntrRtnEvntDt[i]);
				if (rtnYdCd[i] != null)
					model.setRtnYdCd(rtnYdCd[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSubLeaseOutDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SubLeaseOutDetailVO[]
	 */
	public SubLeaseOutDetailVO[] getSubLeaseOutDetailVOs(){
		SubLeaseOutDetailVO[] vos = (SubLeaseOutDetailVO[])models.toArray(new SubLeaseOutDetailVO[models.size()]);
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
		this.cntrFullFlg = this.cntrFullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsEvntDt = this.cntrStsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsiAgmtSeq = this.lsiAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd = this.cntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlUseDys = this.ttlUseDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsiAgmtNo = this.lsiAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsiRefNo = this.lsiRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsiAgmtCtyCd = this.lsiAgmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntryCd = this.cntryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlChgFreeDys = this.rntlChgFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdmAmt = this.pdmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lonAmt = this.lonAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lofAmt = this.lofAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docAmt = this.docAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnEvntDt = this.cntrRtnEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnYdCd = this.rtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
