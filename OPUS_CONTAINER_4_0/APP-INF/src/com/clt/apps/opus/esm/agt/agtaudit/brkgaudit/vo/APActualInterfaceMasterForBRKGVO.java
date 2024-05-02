/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : APActualInterfaceMasterForBRKGVO.java
*@FileTitle : APActualInterfaceMasterForBRKGVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.10.29 추경원 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo;

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
 * @author 추경원
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class APActualInterfaceMasterForBRKGVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<APActualInterfaceMasterForBRKGVO> models = new ArrayList<APActualInterfaceMasterForBRKGVO>();
	
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String ifDate = null;
	/* Column Info */
	private String stsOption = null;
	/* Column Info */
	private String searchDtTo = null;
	/* Column Info */
	private String vndr = null;
	/* Column Info */
	private String fwdrName = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blNos = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String ftuUseCtnt1 = null;
	/* Column Info */
	private String searchDtFr = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String apOfcCd = null;
	/* Column Info */
	private String totCnt = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String fwdr = null;
	/* Column Info */
	private String rcvFlg = null;
	/* Column Info */
	private String ifRsn = null;
	/* Column Info */
	private String rcvRsn = null;
	/* Column Info */
	private String payMzdLuCd = null;
	/* Column Info */
	private String ifOption = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ffCntCd = null;
	
	private String effDate = null;

	private String bkgNo = null;
	
	private String bkgCreDt = null;
	
	private String locDt = null;
	
	private String csrGubun = null;
	
	private String vndrTermNm = null;
	
	private String coaInterCompyCd = null;
	
	private String invDesc = null;
	
	private String fwdrVndrSeqApOfcCd = null;
	
	private String fincRgnCd = null;

	private String aproStep = null;
	
	private String invRgstNo = null;
	
	private String brogAproNo = null;
	
	private String statusCd = null;
	
	private String invOfcCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public APActualInterfaceMasterForBRKGVO() {}

	public APActualInterfaceMasterForBRKGVO(String ibflag, String pagerows, String fwdr, 
			String vndr, String fwdrName, String totCnt, String totAmt, String vndrSeq, 
			String apOfcCd, String csrNo, String ifDate, String ifRsn, String rcvRsn, 
			String ifFlg, String rcvFlg, String payAmt, String payDt, String ftuUseCtnt1, 
			String payMzdLuCd, String blNos, String ffCntCd, String ifOption, 
			String stsOption, String searchDtFr, String searchDtTo, String effDate, 
			String bkgNo, String bkgCreDt, String locDt, String csrGubun, String vndrTermNm, 
			String coaInterCompyCd, String invDesc, String fwdrVndrSeqApOfcCd, String fincRgnCd, String aproStep, String invRgstNo, String brogAproNo, String statusCd, String invOfcCd) {
		this.payDt = payDt;
		this.totAmt = totAmt;
		this.ifDate = ifDate;
		this.stsOption = stsOption;
		this.searchDtTo = searchDtTo;
		this.vndr = vndr;
		this.fwdrName = fwdrName;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.blNos = blNos;
		this.payAmt = payAmt;
		this.ftuUseCtnt1 = ftuUseCtnt1;
		this.searchDtFr = searchDtFr;
		this.csrNo = csrNo;
		this.apOfcCd = apOfcCd;
		this.totCnt = totCnt;
		this.ifFlg = ifFlg;
		this.fwdr = fwdr;
		this.rcvFlg = rcvFlg;
		this.ifRsn = ifRsn;
		this.rcvRsn = rcvRsn;
		this.payMzdLuCd = payMzdLuCd;
		this.ifOption = ifOption;
		this.vndrSeq = vndrSeq;
		this.ffCntCd = ffCntCd;
		this.effDate = effDate;
		this.bkgNo = bkgNo;
		this.bkgCreDt = bkgCreDt;
		this.locDt = locDt;
		this.csrGubun = csrGubun;
		this.vndrTermNm = vndrTermNm;
		this.coaInterCompyCd = coaInterCompyCd;
		this.invDesc = invDesc;
		this.fwdrVndrSeqApOfcCd = fwdrVndrSeqApOfcCd;
		this.fincRgnCd = fincRgnCd;
		this.aproStep = aproStep;
		this.invRgstNo = invRgstNo;
		this.brogAproNo = brogAproNo;
		this.statusCd = statusCd;
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("if_date", getIfDate());
		this.hashColumns.put("sts_option", getStsOption());
		this.hashColumns.put("search_dt_to", getSearchDtTo());
		this.hashColumns.put("vndr", getVndr());
		this.hashColumns.put("fwdr_name", getFwdrName());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_nos", getBlNos());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("ftu_use_ctnt1", getFtuUseCtnt1());
		this.hashColumns.put("search_dt_fr", getSearchDtFr());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());
		this.hashColumns.put("tot_cnt", getTotCnt());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("fwdr", getFwdr());
		this.hashColumns.put("rcv_flg", getRcvFlg());
		this.hashColumns.put("if_rsn", getIfRsn());
		this.hashColumns.put("rcv_rsn", getRcvRsn());
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());
		this.hashColumns.put("if_option", getIfOption());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
		this.hashColumns.put("eff_date", getEffDate());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("loc_dt", getLocDt());
		this.hashColumns.put("csr_gubun", getCsrGubun());
		this.hashColumns.put("fwdr_vndrSeq_apOfcCd", getFwdrVndrSeqApOfcCd());
		this.hashColumns.put("finc_rgn_cd", getFincRgnCd());
		this.hashColumns.put("apro_step", getAproStep());
		this.hashColumns.put("invRgstNo", getInvRgstNo());
		this.hashColumns.put("brogAproNo", getBrogAproNo());
		this.hashColumns.put("statusCd", getStatusCd());
		this.hashColumns.put("invOfcCd", getInvOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("tot_amt", "totAmt");
		this.hashFields.put("if_date", "ifDate");
		this.hashFields.put("sts_option", "stsOption");
		this.hashFields.put("search_dt_to", "searchDtTo");
		this.hashFields.put("vndr", "vndr");
		this.hashFields.put("fwdr_name", "fwdrName");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_nos", "blNos");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("ftu_use_ctnt1", "ftuUseCtnt1");
		this.hashFields.put("search_dt_fr", "searchDtFr");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("tot_cnt", "totCnt");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("fwdr", "fwdr");
		this.hashFields.put("rcv_flg", "rcvFlg");
		this.hashFields.put("if_rsn", "ifRsn");
		this.hashFields.put("rcv_rsn", "rcvRsn");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("if_option", "ifOption");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
		this.hashFields.put("eff_date", "effDate");
		this.hashFields.put("fwrd_vndr_ofc", "fwrdVndrOfc");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("loc_dt", "locDt");
		this.hashFields.put("csr_gubun", "csrGubun");
		this.hashFields.put("fwdr_vndrSeq_apOfcCd", "fwdrVndrSeqApOfcCd");
		this.hashFields.put("finc_rgn_cd", "fincRgnCd");
		this.hashFields.put("apro_step", "aproStep");
		this.hashFields.put("inv_rgst_no", "invRgstNo");
		this.hashFields.put("brog_apro_no", "brogAproNo");
		this.hashFields.put("status_cd", "statusCd");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return payDt
	 */
	public String getPayDt() {
		return this.payDt;
	}
	
	/**
	 * Column Info
	 * @return totAmt
	 */
	public String getTotAmt() {
		return this.totAmt;
	}
	
	/**
	 * Column Info
	 * @return ifDate
	 */
	public String getIfDate() {
		return this.ifDate;
	}
	
	/**
	 * Column Info
	 * @return stsOption
	 */
	public String getStsOption() {
		return this.stsOption;
	}
	
	/**
	 * Column Info
	 * @return searchDtTo
	 */
	public String getSearchDtTo() {
		return this.searchDtTo;
	}
	
	/**
	 * Column Info
	 * @return vndr
	 */
	public String getVndr() {
		return this.vndr;
	}
	
	/**
	 * Column Info
	 * @return fwdrName
	 */
	public String getFwdrName() {
		return this.fwdrName;
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
	 * @return blNos
	 */
	public String getBlNos() {
		return this.blNos;
	}
	
	/**
	 * Column Info
	 * @return payAmt
	 */
	public String getPayAmt() {
		return this.payAmt;
	}
	
	/**
	 * Column Info
	 * @return ftuUseCtnt1
	 */
	public String getFtuUseCtnt1() {
		return this.ftuUseCtnt1;
	}
	
	/**
	 * Column Info
	 * @return searchDtFr
	 */
	public String getSearchDtFr() {
		return this.searchDtFr;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return apOfcCd
	 */
	public String getApOfcCd() {
		return this.apOfcCd;
	}
	
	/**
	 * Column Info
	 * @return totCnt
	 */
	public String getTotCnt() {
		return this.totCnt;
	}
	
	/**
	 * Column Info
	 * @return ifFlg
	 */
	public String getIfFlg() {
		return this.ifFlg;
	}
	
	/**
	 * Column Info
	 * @return fwdr
	 */
	public String getFwdr() {
		return this.fwdr;
	}
	
	/**
	 * Column Info
	 * @return rcvFlg
	 */
	public String getRcvFlg() {
		return this.rcvFlg;
	}
	
	/**
	 * Column Info
	 * @return ifRsn
	 */
	public String getIfRsn() {
		return this.ifRsn;
	}
	
	/**
	 * Column Info
	 * @return rcvRsn
	 */
	public String getRcvRsn() {
		return this.rcvRsn;
	}
	
	/**
	 * Column Info
	 * @return payMzdLuCd
	 */
	public String getPayMzdLuCd() {
		return this.payMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @return ifOption
	 */
	public String getIfOption() {
		return this.ifOption;
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
	 * @return ffCntCd
	 */
	public String getFfCntCd() {
		return this.ffCntCd;
	}
	
	
	public String getEffDate() {
    	return effDate;
    }

	
	public String getBkgNo() {
		return bkgNo;
	}

	public String getBkgCreDt() {
		return bkgCreDt;
	}
	
	
	public String getLocDt() {
		return locDt;
	}
	
	
	public String getCsrGubun() {
		return csrGubun;
	}
	
	public String getVndrTermNm() {
		return vndrTermNm;
	}

	public String getCoaInterCompyCd() {
		return coaInterCompyCd;
	}

	public String getInvDesc() {
		return invDesc;
	}
	
	public String getFwdrVndrSeqApOfcCd() {
		return fwdrVndrSeqApOfcCd;
	}

	
	public String getFincRgnCd() {
		return fincRgnCd;
	}

	public String getAproStep() {
		return aproStep;
	}
	
	public String getInvRgstNo() {
		return invRgstNo;
	}
	
	public String getBrogAproNo() {
		return brogAproNo;
	}
	
	public String getStatusCd() {
		return statusCd;
	}
	
	public String getInvOfcCd() {
		return invOfcCd;
	}

	/**
	 * Column Info
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}
	
	/**
	 * Column Info
	 * @param totAmt
	 */
	public void setTotAmt(String totAmt) {
		this.totAmt = totAmt;
	}
	
	/**
	 * Column Info
	 * @param ifDate
	 */
	public void setIfDate(String ifDate) {
		this.ifDate = ifDate;
	}
	
	/**
	 * Column Info
	 * @param stsOption
	 */
	public void setStsOption(String stsOption) {
		this.stsOption = stsOption;
	}
	
	/**
	 * Column Info
	 * @param searchDtTo
	 */
	public void setSearchDtTo(String searchDtTo) {
		this.searchDtTo = searchDtTo;
	}
	
	/**
	 * Column Info
	 * @param vndr
	 */
	public void setVndr(String vndr) {
		this.vndr = vndr;
	}
	
	/**
	 * Column Info
	 * @param fwdrName
	 */
	public void setFwdrName(String fwdrName) {
		this.fwdrName = fwdrName;
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
	 * @param blNos
	 */
	public void setBlNos(String blNos) {
		this.blNos = blNos;
	}
	
	/**
	 * Column Info
	 * @param payAmt
	 */
	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}
	
	/**
	 * Column Info
	 * @param ftuUseCtnt1
	 */
	public void setFtuUseCtnt1(String ftuUseCtnt1) {
		this.ftuUseCtnt1 = ftuUseCtnt1;
	}
	
	/**
	 * Column Info
	 * @param searchDtFr
	 */
	public void setSearchDtFr(String searchDtFr) {
		this.searchDtFr = searchDtFr;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param apOfcCd
	 */
	public void setApOfcCd(String apOfcCd) {
		this.apOfcCd = apOfcCd;
	}
	
	/**
	 * Column Info
	 * @param totCnt
	 */
	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}
	
	/**
	 * Column Info
	 * @param ifFlg
	 */
	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
	}
	
	/**
	 * Column Info
	 * @param fwdr
	 */
	public void setFwdr(String fwdr) {
		this.fwdr = fwdr;
	}
	
	/**
	 * Column Info
	 * @param rcvFlg
	 */
	public void setRcvFlg(String rcvFlg) {
		this.rcvFlg = rcvFlg;
	}
	
	/**
	 * Column Info
	 * @param ifRsn
	 */
	public void setIfRsn(String ifRsn) {
		this.ifRsn = ifRsn;
	}
	
	/**
	 * Column Info
	 * @param rcvRsn
	 */
	public void setRcvRsn(String rcvRsn) {
		this.rcvRsn = rcvRsn;
	}
	
	/**
	 * Column Info
	 * @param payMzdLuCd
	 */
	public void setPayMzdLuCd(String payMzdLuCd) {
		this.payMzdLuCd = payMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @param ifOption
	 */
	public void setIfOption(String ifOption) {
		this.ifOption = ifOption;
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
	 * @param ffCntCd
	 */
	public void setFfCntCd(String ffCntCd) {
		this.ffCntCd = ffCntCd;
	}
	
	public void setEffDate(String effDate) {
    	this.effDate = effDate;
    }
		
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
	}
	
	public void setLocDt(String locDt) {
		this.locDt = locDt;
	}
	
	public void setCsrGubun(String csrGubun) {
		this.csrGubun = csrGubun;
	}

	public void setVndrTermNm(String vndrTermNm) {
		this.vndrTermNm = vndrTermNm;
	}
	
	public void setCoaInterCompyCd(String coaInterCompyCd) {
		this.coaInterCompyCd = coaInterCompyCd;
	}
	
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
	}
	
	public void setFwdrVndrSeqApOfcCd(String fwdrVndrSeqApOfcCd) {
		this.fwdrVndrSeqApOfcCd = fwdrVndrSeqApOfcCd;
	}
	
	public void setFincRgnCd(String fincRgnCd) {
		this.fincRgnCd = fincRgnCd;
	}

	public void setAproStep(String aproStep) {
		this.aproStep = aproStep;
	}
	
	public void setInvRgstNo(String invRgstNo) {
		this.invRgstNo = invRgstNo;
	}
	
	public void setBrogAproNo(String brogAproNo) {
		this.brogAproNo = brogAproNo;
	}
	
	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}
	
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPayDt(JSPUtil.getParameter(request, "pay_dt", ""));
		setTotAmt(JSPUtil.getParameter(request, "tot_amt", ""));
		setIfDate(JSPUtil.getParameter(request, "if_date", ""));
		setStsOption(JSPUtil.getParameter(request, "sts_option", ""));
		setSearchDtTo(JSPUtil.getParameter(request, "search_dt_to", ""));
		setVndr(JSPUtil.getParameter(request, "vndr", ""));
		setFwdrName(JSPUtil.getParameter(request, "fwdr_name", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBlNos(JSPUtil.getParameter(request, "bl_nos", ""));
		setPayAmt(JSPUtil.getParameter(request, "pay_amt", ""));
		setFtuUseCtnt1(JSPUtil.getParameter(request, "ftu_use_ctnt1", ""));
		setSearchDtFr(JSPUtil.getParameter(request, "search_dt_fr", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setApOfcCd(JSPUtil.getParameter(request, "ap_ofc_cd", ""));
		setTotCnt(JSPUtil.getParameter(request, "tot_cnt", ""));
		setIfFlg(JSPUtil.getParameter(request, "if_flg", ""));
		setFwdr(JSPUtil.getParameter(request, "fwdr", ""));
		setRcvFlg(JSPUtil.getParameter(request, "rcv_flg", ""));
		setIfRsn(JSPUtil.getParameter(request, "if_rsn", ""));
		setRcvRsn(JSPUtil.getParameter(request, "rcv_rsn", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request, "pay_mzd_lu_cd", ""));
		setIfOption(JSPUtil.getParameter(request, "if_option", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setFfCntCd(JSPUtil.getParameter(request, "ff_cnt_cd", ""));
		setEffDate(JSPUtil.getParameter(request, "eff_date", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBkgCreDt(JSPUtil.getParameter(request, "bkg_cre_dt", ""));
		setLocDt(JSPUtil.getParameter(request, "loc_dt", ""));
		setCsrGubun(JSPUtil.getParameter(request, "csr_gubun", ""));
		setFwdrVndrSeqApOfcCd(JSPUtil.getParameter(request, "fwdr_vndrSeq_apOfcCd", ""));
		setFincRgnCd(JSPUtil.getParameter(request, "finc_rgn_cd", ""));
		setAproStep(JSPUtil.getParameter(request, "apro_step", ""));
		setInvRgstNo(JSPUtil.getParameter(request, "inv_rgst_no", ""));
		setBrogAproNo(JSPUtil.getParameter(request, "brog_apro_no", ""));
		setStatusCd(JSPUtil.getParameter(request, "status_cd", ""));
		setInvOfcCd(JSPUtil.getParameter(request, "inv_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APActualInterfaceMasterForBRKGVO[]
	 */
	public APActualInterfaceMasterForBRKGVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return APActualInterfaceMasterForBRKGVO[]
	 */
	public APActualInterfaceMasterForBRKGVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		APActualInterfaceMasterForBRKGVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] ifDate = (JSPUtil.getParameter(request, prefix	+ "if_date", length));
			String[] stsOption = (JSPUtil.getParameter(request, prefix	+ "sts_option", length));
			String[] searchDtTo = (JSPUtil.getParameter(request, prefix	+ "search_dt_to", length));
			String[] vndr = (JSPUtil.getParameter(request, prefix	+ "vndr", length));
			String[] fwdrName = (JSPUtil.getParameter(request, prefix	+ "fwdr_name", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blNos = (JSPUtil.getParameter(request, prefix	+ "bl_nos", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	+ "pay_amt", length));
			String[] ftuUseCtnt1 = (JSPUtil.getParameter(request, prefix	+ "ftu_use_ctnt1", length));
			String[] searchDtFr = (JSPUtil.getParameter(request, prefix	+ "search_dt_fr", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] apOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ofc_cd", length));
			String[] totCnt = (JSPUtil.getParameter(request, prefix	+ "tot_cnt", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] fwdr = (JSPUtil.getParameter(request, prefix	+ "fwdr", length));
			String[] rcvFlg = (JSPUtil.getParameter(request, prefix	+ "rcv_flg", length));
			String[] ifRsn = (JSPUtil.getParameter(request, prefix	+ "if_rsn", length));
			String[] rcvRsn = (JSPUtil.getParameter(request, prefix	+ "rcv_rsn", length));
			String[] payMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_lu_cd", length));
			String[] ifOption = (JSPUtil.getParameter(request, prefix	+ "if_option", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			String[] effDate = (JSPUtil.getParameter(request, prefix	+ "eff_date", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] locDt = (JSPUtil.getParameter(request, prefix	+ "loc_dt", length));
			String[] csrGubun = (JSPUtil.getParameter(request, prefix	+ "csr_gubun", length));
			String[] fwdrVndrSeqApOfcCd = (JSPUtil.getParameter(request, prefix	+ "fwdr_vndrSeq_apOfcCd", length));
			String[] fincRgnCd = (JSPUtil.getParameter(request, prefix	+ "finc_rgn_cd", length));
			String[] aproStep = (JSPUtil.getParameter(request, prefix	+ "apro_step", length));
			String[] invRgstNo = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_no", length));
			String[] brogAproNo = (JSPUtil.getParameter(request, prefix	+ "brog_apro_no", length));
			String[] statusCd = (JSPUtil.getParameter(request, prefix	+ "status_cd", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new APActualInterfaceMasterForBRKGVO();
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (ifDate[i] != null)
					model.setIfDate(ifDate[i]);
				if (stsOption[i] != null)
					model.setStsOption(stsOption[i]);
				if (searchDtTo[i] != null)
					model.setSearchDtTo(searchDtTo[i]);
				if (vndr[i] != null)
					model.setVndr(vndr[i]);
				if (fwdrName[i] != null)
					model.setFwdrName(fwdrName[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blNos[i] != null)
					model.setBlNos(blNos[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (ftuUseCtnt1[i] != null)
					model.setFtuUseCtnt1(ftuUseCtnt1[i]);
				if (searchDtFr[i] != null)
					model.setSearchDtFr(searchDtFr[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (apOfcCd[i] != null)
					model.setApOfcCd(apOfcCd[i]);
				if (totCnt[i] != null)
					model.setTotCnt(totCnt[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (fwdr[i] != null)
					model.setFwdr(fwdr[i]);
				if (rcvFlg[i] != null)
					model.setRcvFlg(rcvFlg[i]);
				if (ifRsn[i] != null)
					model.setIfRsn(ifRsn[i]);
				if (rcvRsn[i] != null)
					model.setRcvRsn(rcvRsn[i]);
				if (payMzdLuCd[i] != null)
					model.setPayMzdLuCd(payMzdLuCd[i]);
				if (ifOption[i] != null)
					model.setIfOption(ifOption[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ffCntCd[i] != null)
					model.setFfCntCd(ffCntCd[i]);
				if (effDate[i] != null)
					model.setEffDate(effDate[i]);
				if(bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if(bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if(locDt[i] != null)
					model.setLocDt(locDt[i]);
				if(csrGubun[i] != null)
					model.setCsrGubun(csrGubun[i]);
				if(fwdrVndrSeqApOfcCd[i] != null)
					model.setFwdrVndrSeqApOfcCd(fwdrVndrSeqApOfcCd[i]);
				if(fincRgnCd[i] != null)
					model.setFincRgnCd(fincRgnCd[i]);
				if(aproStep[i] != null)
					model.setAproStep(aproStep[i]);
				if(invRgstNo[i] != null)
					model.setInvRgstNo(invRgstNo[i]);
				if(brogAproNo[i] != null)
					model.setBrogAproNo(brogAproNo[i]);
				if(statusCd[i] != null)
					model.setStatusCd(statusCd[i]);
				if(invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAPActualInterfaceMasterForBRKGVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return APActualInterfaceMasterForBRKGVO[]
	 */
	public APActualInterfaceMasterForBRKGVO[] getAPActualInterfaceMasterForBRKGVOs(){
		APActualInterfaceMasterForBRKGVO[] vos = (APActualInterfaceMasterForBRKGVO[])models.toArray(new APActualInterfaceMasterForBRKGVO[models.size()]);
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
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmt = this.totAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifDate = this.ifDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsOption = this.stsOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtTo = this.searchDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndr = this.vndr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdrName = this.fwdrName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNos = this.blNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftuUseCtnt1 = this.ftuUseCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtFr = this.searchDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd = this.apOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCnt = this.totCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdr = this.fwdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvFlg = this.rcvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRsn = this.ifRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvRsn = this.rcvRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd = this.payMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOption = this.ifOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDate = this.effDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locDt = this.locDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrGubun = this.csrGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdrVndrSeqApOfcCd = this.fwdrVndrSeqApOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincRgnCd = this.fincRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.aproStep = this.aproStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstNo = this.invRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogAproNo = this.brogAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusCd = this.statusCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
