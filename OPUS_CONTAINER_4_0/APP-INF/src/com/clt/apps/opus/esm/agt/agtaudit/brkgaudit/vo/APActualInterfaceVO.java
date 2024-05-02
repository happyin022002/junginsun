/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : APActualInterfaceVO.java
*@FileTitle : APActualInterfaceVO
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

public class APActualInterfaceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<APActualInterfaceVO> models = new ArrayList<APActualInterfaceVO>();
	
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String ifDate = null;
	/* Column Info */
	private String searchDtTo = null;
	/* Column Info */
	private String blNo = null;
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
	private String bkgNo = null;
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

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public APActualInterfaceVO() {}

	public APActualInterfaceVO(String ibflag, String pagerows, String fwdr, String vndr, String fwdrName, String csrNo, String bkgNo, String blNo, String totCnt, String totAmt, String vndrSeq, String apOfcCd, String ifDate, String ifRsn, String rcvRsn, String ifFlg, String rcvFlg, String payAmt, String payDt, String ftuUseCtnt1, String payMzdLuCd, String ifOption, String searchDtFr, String searchDtTo, String ffCntCd, String blNos) {
		this.payDt = payDt;
		this.totAmt = totAmt;
		this.ifDate = ifDate;
		this.searchDtTo = searchDtTo;
		this.blNo = blNo;
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
		this.bkgNo = bkgNo;
		this.rcvRsn = rcvRsn;
		this.payMzdLuCd = payMzdLuCd;
		this.ifOption = ifOption;
		this.vndrSeq = vndrSeq;
		this.ffCntCd = ffCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("if_date", getIfDate());
		this.hashColumns.put("search_dt_to", getSearchDtTo());
		this.hashColumns.put("bl_no", getBlNo());
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
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rcv_rsn", getRcvRsn());
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());
		this.hashColumns.put("if_option", getIfOption());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
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
		this.hashFields.put("search_dt_to", "searchDtTo");
		this.hashFields.put("bl_no", "blNo");
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
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rcv_rsn", "rcvRsn");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("if_option", "ifOption");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
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
	 * @return searchDtTo
	 */
	public String getSearchDtTo() {
		return this.searchDtTo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @param searchDtTo
	 */
	public void setSearchDtTo(String searchDtTo) {
		this.searchDtTo = searchDtTo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPayDt(JSPUtil.getParameter(request, "pay_dt", ""));
		setTotAmt(JSPUtil.getParameter(request, "tot_amt", ""));
		setIfDate(JSPUtil.getParameter(request, "if_date", ""));
		setSearchDtTo(JSPUtil.getParameter(request, "search_dt_to", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
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
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setRcvRsn(JSPUtil.getParameter(request, "rcv_rsn", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request, "pay_mzd_lu_cd", ""));
		setIfOption(JSPUtil.getParameter(request, "if_option", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setFfCntCd(JSPUtil.getParameter(request, "ff_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APActualInterfaceVO[]
	 */
	public APActualInterfaceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return APActualInterfaceVO[]
	 */
	public APActualInterfaceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		APActualInterfaceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] ifDate = (JSPUtil.getParameter(request, prefix	+ "if_date", length));
			String[] searchDtTo = (JSPUtil.getParameter(request, prefix	+ "search_dt_to", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
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
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rcvRsn = (JSPUtil.getParameter(request, prefix	+ "rcv_rsn", length));
			String[] payMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_lu_cd", length));
			String[] ifOption = (JSPUtil.getParameter(request, prefix	+ "if_option", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new APActualInterfaceVO();
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (ifDate[i] != null)
					model.setIfDate(ifDate[i]);
				if (searchDtTo[i] != null)
					model.setSearchDtTo(searchDtTo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
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
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
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
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAPActualInterfaceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return APActualInterfaceVO[]
	 */
	public APActualInterfaceVO[] getAPActualInterfaceVOs(){
		APActualInterfaceVO[] vos = (APActualInterfaceVO[])models.toArray(new APActualInterfaceVO[models.size()]);
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
		this.searchDtTo = this.searchDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvRsn = this.rcvRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd = this.payMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOption = this.ifOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
