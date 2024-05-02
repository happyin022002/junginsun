/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchInBoundCustListVO.java
*@FileTitle : SearchInBoundCustListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class SearchInBoundCustListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchInBoundCustListVO> models = new ArrayList<SearchInBoundCustListVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bcoType = null;
	/* Column Info */
	private String historyYn = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String noUseRsn = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String custSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String rowsPerPage = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currPage = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String ctyNm = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String frtFwrdFmcNo = null;
	/* Column Info */
	private String areaCd = null;
	/* Column Info */
	private String noUse = null;
	/* Column Info */
	private String bklst = null;
	/* Column Info */
	private String include = null;
	/* Column Info */
	private String rBklst = null;
	/* Column Info */
	private String locationCode = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchInBoundCustListVO() {}

	public SearchInBoundCustListVO(String ibflag, String pagerows, String deltFlg, String historyYn, String custCntCd, String custSeq, String code, String custNm, String custAddr, String ofcCd, String ctyNm, String steCd, String zipCd, String bcoType, String bkgNo, String rnum, String totalCnt, String rowsPerPage, String locationCode, String currPage, String noUseRsn, String phnNo, String srepNm, String frtFwrdFmcNo, String areaCd, String noUse, String bklst, String include, String rBklst) {
		this.bcoType = bcoType;
		this.bkgNo = bkgNo;
		this.historyYn = historyYn;
		this.custNm = custNm;
		this.deltFlg = deltFlg;
		this.noUseRsn = noUseRsn;
		this.custAddr = custAddr;
		this.code = code;
		this.custSeq = custSeq;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.rowsPerPage = rowsPerPage;
		this.ibflag = ibflag;
		this.currPage = currPage;
		this.rnum = rnum;
		this.zipCd = zipCd;
		this.ctyNm = ctyNm;
		this.totalCnt = totalCnt;
		this.steCd = steCd;
		this.custCntCd = custCntCd;
		this.phnNo = phnNo;
		this.srepNm = srepNm;
		this.frtFwrdFmcNo = frtFwrdFmcNo;
		this.locationCode = locationCode;
		
		this.areaCd = areaCd;
		this.noUse = noUse;
		this.bklst = bklst;
		this.include = include;
		this.rBklst = rBklst;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bco_type", getBcoType());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("history_yn", getHistoryYn());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("no_use_rsn", getNoUseRsn());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("rows_per_page", getRowsPerPage());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_page", getCurrPage());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("frt_fwrd_fmc_no", getFrtFwrdFmcNo());
		this.hashColumns.put("location_code", getLocationCode());
		this.hashColumns.put("area_cd", getAreaCd());
		this.hashColumns.put("no_use", getNoUse());
		this.hashColumns.put("bklst", getBklst());
		this.hashColumns.put("include", getInclude());
		this.hashColumns.put("r_bklst", getRBklst());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bco_type", "bcoType");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("history_yn", "historyYn");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("no_use_rsn", "noUseRsn");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("code", "code");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("frt_fwrd_fmc_no", "frtFwrdFmcNo");
		this.hashFields.put("location_code", "locationCode");
		this.hashFields.put("area_cd", "areaCd");
		this.hashFields.put("no_use", "noUse");
		this.hashFields.put("bklst", "bklst");
		this.hashFields.put("include", "include");
		this.hashFields.put("r_bklst", "rBklst");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return locationCode
	 */
	public String getLocationCode() {
		return this.locationCode;
	}
	
	
	/**
	 * Column Info
	 * @return bcoType
	 */
	public String getBcoType() {
		return this.bcoType;
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
	 * @return historyYn
	 */
	public String getHistoryYn() {
		return this.historyYn;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return noUseRsn
	 */
	public String getNoUseRsn() {
		return this.noUseRsn;
	}
	
	/**
	 * Column Info
	 * @return custAddr
	 */
	public String getCustAddr() {
		return this.custAddr;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return rowsPerPage
	 */
	public String getRowsPerPage() {
		return this.rowsPerPage;
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
	 * @return currPage
	 */
	public String getCurrPage() {
		return this.currPage;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdFmcNo
	 */
	public String getFrtFwrdFmcNo() {
		return this.frtFwrdFmcNo;
	}
	
	/**
	 * Column Info
	 * @return noUse
	 */
	public String getNoUse() {
		return this.noUse;
	}
	
	/**
	 * Column Info
	 * @return bklst
	 */
	public String getBklst() {
		return this.bklst;
	}
	
	/**
	 * Column Info
	 * @return include
	 */
	public String getInclude() {
		return this.include;
	}
	
	/**
	 * Column Info
	 * @return areaCd
	 */
	public String getAreaCd() {
		return this.areaCd;
	}

	/**
	 * Column Info
	 * @return rBklst
	 */
	public String getRBklst() {
		return this.rBklst;
	}

	/**
	 * Column Info
	 * @param bcoType
	 */
	public void setBcoType(String bcoType) {
		this.bcoType = bcoType;
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
	 * @param historyYn
	 */
	public void setHistoryYn(String historyYn) {
		this.historyYn = historyYn;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param noUseRsn
	 */
	public void setNoUseRsn(String noUseRsn) {
		this.noUseRsn = noUseRsn;
	}
	
	/**
	 * Column Info
	 * @param custAddr
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param rowsPerPage
	 */
	public void setRowsPerPage(String rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
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
	 * @param currPage
	 */
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdFmcNo
	 */
	public void setFrtFwrdFmcNo(String frtFwrdFmcNo) {
		this.frtFwrdFmcNo = frtFwrdFmcNo;
	}
	
	/**
	 * Column Info
	 * @param noUse
	 */
	public void setNoUse(String noUse) {
		this.noUse = noUse;
	}
	
	/**
	 * Column Info
	 * @param bklst
	 */
	public void setBklst(String bklst) {
		this.bklst = bklst;
	}
	
	/**
	 * Column Info
	 * @param include
	 */
	public void setInclude(String include) {
		this.include = include;
	}
	
	/**
	 * Column Info
	 * @param areaCd
	 */
	public void setAreaCd(String areaCd) {
		this.areaCd = areaCd;
	}
	
	/**
	 * Column Info
	 * @param rBklst
	 */
	public void setRBklst(String rBklst) {
		this.rBklst = rBklst;
	}
	
	/**
	 * Column Info
	 * @param locationCode
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
	
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBcoType(JSPUtil.getParameter(request, "bco_type", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setHistoryYn(JSPUtil.getParameter(request, "history_yn", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCustAddr(JSPUtil.getParameter(request, "cust_addr", ""));
		setCode(JSPUtil.getParameter(request, "code", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setRowsPerPage(JSPUtil.getParameter(request, "rows_per_page", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCurrPage(JSPUtil.getParameter(request, "curr_page", ""));
		setRnum(JSPUtil.getParameter(request, "rnum", ""));
		setZipCd(JSPUtil.getParameter(request, "zip_cd", ""));
		setCtyNm(JSPUtil.getParameter(request, "cty_nm", ""));
		setTotalCnt(JSPUtil.getParameter(request, "total_cnt", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setNoUseRsn(JSPUtil.getParameter(request, "no_use_rsn", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setSrepNm(JSPUtil.getParameter(request, "srep_nm", ""));
		setFrtFwrdFmcNo(JSPUtil.getParameter(request, "frt_fwrd_fmc_no", ""));
		setNoUse(JSPUtil.getParameter(request,  "no_use", ""));
		setBklst(JSPUtil.getParameter(request,  "bklst", ""));
		setInclude(JSPUtil.getParameter(request, "include", ""));
		setAreaCd(JSPUtil.getParameter(request,  "area_cd", ""));
		setRBklst(JSPUtil.getParameter(request,  "r_bklst", ""));
		setLocationCode(JSPUtil.getParameter(request, "location_code", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInBoundCustListVO[]
	 */
	public SearchInBoundCustListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInBoundCustListVO[]
	 */
	public SearchInBoundCustListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchInBoundCustListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bcoType = (JSPUtil.getParameter(request, prefix	+ "bco_type".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] historyYn = (JSPUtil.getParameter(request, prefix	+ "history_yn".trim(), length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr".trim(), length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] rowsPerPage = (JSPUtil.getParameter(request, prefix	+ "rows_per_page".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] currPage = (JSPUtil.getParameter(request, prefix	+ "curr_page".trim(), length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum".trim(), length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd".trim(), length));
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm".trim(), length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt".trim(), length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			String[] noUseRsn = (JSPUtil.getParameter(request, prefix	+ "no_use_rsn".trim(), length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no".trim(), length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm".trim(), length));
			String[] frtFwrdFmcNo = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_fmc_no".trim(), length));
			String[] noUse = (JSPUtil.getParameter(request, prefix	+ "no_use", length));
			String[] bklst = (JSPUtil.getParameter(request, prefix	+ "bklst", length));
			String[] include = (JSPUtil.getParameter(request, prefix	+ "include", length));
			String[] areaCd = (JSPUtil.getParameter(request, prefix	+ "area_cd", length));
			String[] rBklst = (JSPUtil.getParameter(request, prefix	+ "r_bklst", length));
			String[] locationCode = (JSPUtil.getParameter(request, prefix	+ "location_code", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchInBoundCustListVO();
				if (bcoType[i] != null)
					model.setBcoType(bcoType[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (historyYn[i] != null)
					model.setHistoryYn(historyYn[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (noUseRsn[i] != null)
					model.setNoUseRsn(noUseRsn[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (rowsPerPage[i] != null)
					model.setRowsPerPage(rowsPerPage[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currPage[i] != null)
					model.setCurrPage(currPage[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (ctyNm[i] != null)
					model.setCtyNm(ctyNm[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (frtFwrdFmcNo[i] != null)
					model.setFrtFwrdFmcNo(frtFwrdFmcNo[i]);
				if (noUse[i] != null)
					model.setNoUse(noUse[i]);
				if (bklst[i] != null)
					model.setBklst(bklst[i]);
				if (include[i] != null)
					model.setInclude(include[i]);
				if (areaCd[i] != null)
					model.setAreaCd(areaCd[i]);
				if (rBklst[i] != null)
					model.setRBklst(rBklst[i]);
				if (locationCode[i] != null)
					model.setLocationCode(locationCode[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInBoundCustListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchInBoundCustListVO[]
	 */
	public SearchInBoundCustListVO[] getSearchInBoundCustListVOs(){
		SearchInBoundCustListVO[] vos = (SearchInBoundCustListVO[])models.toArray(new SearchInBoundCustListVO[models.size()]);
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
		this.bcoType = this.bcoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.historyYn = this.historyYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noUseRsn = this.noUseRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage = this.rowsPerPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage = this.currPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdFmcNo = this.frtFwrdFmcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noUse = this.noUse .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bklst = this.bklst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.include = this.include .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaCd = this.areaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rBklst = this.rBklst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCode = this.locationCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
