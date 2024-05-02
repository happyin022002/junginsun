/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnApprovalPrintMasterVO.java
*@FileTitle : FFCmpnApprovalPrintMasterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.07
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.08.07 김영오
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FFCmpnApprovalPrintMasterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<FFCmpnApprovalPrintMasterVO> models = new ArrayList<FFCmpnApprovalPrintMasterVO>();

	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String hdrCsrNo = null;
	/* Column Info */
	private String hdrDesc = null;
	/* Column Info */
	private String hdrAmount = null;
	/* Column Info */
	private String hdrPrpdBy = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String amount = null;
	/* Column Info */
	private String hdrEviTp = null;
	/* Column Info */
	private String vendorNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hdrTitle = null;
	/* Column Info */
	private String hdrCurrCd = null;
	/* Column Info */
	private String hdrCsrType = null;
	/* Column Info */
	private String hdrPayGrp = null;
	/* Column Info */
	private String hdrInvDt = null;
	/* Column Info */
	private String hdrAmt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String hdrPayTo = null;
	/* Column Info */
	private String hdrDueDt = null;
	/* Column Info */
	private String vendor = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String hdrAsaNo = null;
	/* Column Info */
	private String hdrOffice = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String cur = null;
	/* Column Info */
	private String hdrApprdBy = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public FFCmpnApprovalPrintMasterVO() {}

	public FFCmpnApprovalPrintMasterVO(String ibflag, String pagerows, String seq, String csrNo, String dateFm, String dateTo, String vendor, String cur, String amount, String vendorNm, String hdrTitle, String hdrCsrNo, String hdrOffice, String hdrPrpdBy, String hdrPayTo, String hdrCsrType, String hdrDesc, String hdrPayGrp, String hdrEviTp, String hdrDueDt, String hdrAsaNo, String hdrInvDt, String hdrCurrCd, String hdrApprdBy, String hdrAmount, String hdrAmt) {
		this.dateFm = dateFm;
		this.hdrCsrNo = hdrCsrNo;
		this.hdrDesc = hdrDesc;
		this.hdrAmount = hdrAmount;
		this.hdrPrpdBy = hdrPrpdBy;
		this.pagerows = pagerows;
		this.amount = amount;
		this.hdrEviTp = hdrEviTp;
		this.vendorNm = vendorNm;
		this.ibflag = ibflag;
		this.hdrTitle = hdrTitle;
		this.hdrCurrCd = hdrCurrCd;
		this.hdrCsrType = hdrCsrType;
		this.hdrPayGrp = hdrPayGrp;
		this.hdrInvDt = hdrInvDt;
		this.hdrAmt = hdrAmt;
		this.csrNo = csrNo;
		this.hdrPayTo = hdrPayTo;
		this.hdrDueDt = hdrDueDt;
		this.vendor = vendor;
		this.dateTo = dateTo;
		this.hdrAsaNo = hdrAsaNo;
		this.hdrOffice = hdrOffice;
		this.seq = seq;
		this.cur = cur;
		this.hdrApprdBy = hdrApprdBy;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("hdr_csr_no", getHdrCsrNo());
		this.hashColumns.put("hdr_desc", getHdrDesc());
		this.hashColumns.put("hdr_amount", getHdrAmount());
		this.hashColumns.put("hdr_prpd_by", getHdrPrpdBy());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("hdr_evi_tp", getHdrEviTp());
		this.hashColumns.put("vendor_nm", getVendorNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hdr_title", getHdrTitle());
		this.hashColumns.put("hdr_curr_cd", getHdrCurrCd());
		this.hashColumns.put("hdr_csr_type", getHdrCsrType());
		this.hashColumns.put("hdr_pay_grp", getHdrPayGrp());
		this.hashColumns.put("hdr_inv_dt", getHdrInvDt());
		this.hashColumns.put("hdr_amt", getHdrAmt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("hdr_pay_to", getHdrPayTo());
		this.hashColumns.put("hdr_due_dt", getHdrDueDt());
		this.hashColumns.put("vendor", getVendor());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("hdr_asa_no", getHdrAsaNo());
		this.hashColumns.put("hdr_office", getHdrOffice());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("cur", getCur());
		this.hashColumns.put("hdr_apprd_by", getHdrApprdBy());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("hdr_csr_no", "hdrCsrNo");
		this.hashFields.put("hdr_desc", "hdrDesc");
		this.hashFields.put("hdr_amount", "hdrAmount");
		this.hashFields.put("hdr_prpd_by", "hdrPrpdBy");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("hdr_evi_tp", "hdrEviTp");
		this.hashFields.put("vendor_nm", "vendorNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hdr_title", "hdrTitle");
		this.hashFields.put("hdr_curr_cd", "hdrCurrCd");
		this.hashFields.put("hdr_csr_type", "hdrCsrType");
		this.hashFields.put("hdr_pay_grp", "hdrPayGrp");
		this.hashFields.put("hdr_inv_dt", "hdrInvDt");
		this.hashFields.put("hdr_amt", "hdrAmt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("hdr_pay_to", "hdrPayTo");
		this.hashFields.put("hdr_due_dt", "hdrDueDt");
		this.hashFields.put("vendor", "vendor");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("hdr_asa_no", "hdrAsaNo");
		this.hashFields.put("hdr_office", "hdrOffice");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("cur", "cur");
		this.hashFields.put("hdr_apprd_by", "hdrApprdBy");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return dateFm
	 */
	public String getDateFm() {
		return this.dateFm;
	}

	/**
	 * Column Info
	 * @return hdrCsrNo
	 */
	public String getHdrCsrNo() {
		return this.hdrCsrNo;
	}

	/**
	 * Column Info
	 * @return hdrDesc
	 */
	public String getHdrDesc() {
		return this.hdrDesc;
	}

	/**
	 * Column Info
	 * @return hdrAmount
	 */
	public String getHdrAmount() {
		return this.hdrAmount;
	}

	/**
	 * Column Info
	 * @return hdrPrpdBy
	 */
	public String getHdrPrpdBy() {
		return this.hdrPrpdBy;
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
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
	}

	/**
	 * Column Info
	 * @return hdrEviTp
	 */
	public String getHdrEviTp() {
		return this.hdrEviTp;
	}

	/**
	 * Column Info
	 * @return vendorNm
	 */
	public String getVendorNm() {
		return this.vendorNm;
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
	 * @return hdrTitle
	 */
	public String getHdrTitle() {
		return this.hdrTitle;
	}

	/**
	 * Column Info
	 * @return hdrCurrCd
	 */
	public String getHdrCurrCd() {
		return this.hdrCurrCd;
	}

	/**
	 * Column Info
	 * @return hdrCsrType
	 */
	public String getHdrCsrType() {
		return this.hdrCsrType;
	}

	/**
	 * Column Info
	 * @return hdrPayGrp
	 */
	public String getHdrPayGrp() {
		return this.hdrPayGrp;
	}

	/**
	 * Column Info
	 * @return hdrInvDt
	 */
	public String getHdrInvDt() {
		return this.hdrInvDt;
	}

	/**
	 * Column Info
	 * @return hdrAmt
	 */
	public String getHdrAmt() {
		return this.hdrAmt;
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
	 * @return hdrPayTo
	 */
	public String getHdrPayTo() {
		return this.hdrPayTo;
	}

	/**
	 * Column Info
	 * @return hdrDueDt
	 */
	public String getHdrDueDt() {
		return this.hdrDueDt;
	}

	/**
	 * Column Info
	 * @return vendor
	 */
	public String getVendor() {
		return this.vendor;
	}

	/**
	 * Column Info
	 * @return dateTo
	 */
	public String getDateTo() {
		return this.dateTo;
	}

	/**
	 * Column Info
	 * @return hdrAsaNo
	 */
	public String getHdrAsaNo() {
		return this.hdrAsaNo;
	}

	/**
	 * Column Info
	 * @return hdrOffice
	 */
	public String getHdrOffice() {
		return this.hdrOffice;
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
	 * @return cur
	 */
	public String getCur() {
		return this.cur;
	}

	/**
	 * Column Info
	 * @return hdrApprdBy
	 */
	public String getHdrApprdBy() {
		return this.hdrApprdBy;
	}


	/**
	 * Column Info
	 * @param dateFm
	 */
	public void setDateFm(String dateFm) {
		this.dateFm = dateFm;
	}

	/**
	 * Column Info
	 * @param hdrCsrNo
	 */
	public void setHdrCsrNo(String hdrCsrNo) {
		this.hdrCsrNo = hdrCsrNo;
	}

	/**
	 * Column Info
	 * @param hdrDesc
	 */
	public void setHdrDesc(String hdrDesc) {
		this.hdrDesc = hdrDesc;
	}

	/**
	 * Column Info
	 * @param hdrAmount
	 */
	public void setHdrAmount(String hdrAmount) {
		this.hdrAmount = hdrAmount;
	}

	/**
	 * Column Info
	 * @param hdrPrpdBy
	 */
	public void setHdrPrpdBy(String hdrPrpdBy) {
		this.hdrPrpdBy = hdrPrpdBy;
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
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * Column Info
	 * @param hdrEviTp
	 */
	public void setHdrEviTp(String hdrEviTp) {
		this.hdrEviTp = hdrEviTp;
	}

	/**
	 * Column Info
	 * @param vendorNm
	 */
	public void setVendorNm(String vendorNm) {
		this.vendorNm = vendorNm;
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
	 * @param hdrTitle
	 */
	public void setHdrTitle(String hdrTitle) {
		this.hdrTitle = hdrTitle;
	}

	/**
	 * Column Info
	 * @param hdrCurrCd
	 */
	public void setHdrCurrCd(String hdrCurrCd) {
		this.hdrCurrCd = hdrCurrCd;
	}

	/**
	 * Column Info
	 * @param hdrCsrType
	 */
	public void setHdrCsrType(String hdrCsrType) {
		this.hdrCsrType = hdrCsrType;
	}

	/**
	 * Column Info
	 * @param hdrPayGrp
	 */
	public void setHdrPayGrp(String hdrPayGrp) {
		this.hdrPayGrp = hdrPayGrp;
	}

	/**
	 * Column Info
	 * @param hdrInvDt
	 */
	public void setHdrInvDt(String hdrInvDt) {
		this.hdrInvDt = hdrInvDt;
	}

	/**
	 * Column Info
	 * @param hdrAmt
	 */
	public void setHdrAmt(String hdrAmt) {
		this.hdrAmt = hdrAmt;
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
	 * @param hdrPayTo
	 */
	public void setHdrPayTo(String hdrPayTo) {
		this.hdrPayTo = hdrPayTo;
	}

	/**
	 * Column Info
	 * @param hdrDueDt
	 */
	public void setHdrDueDt(String hdrDueDt) {
		this.hdrDueDt = hdrDueDt;
	}

	/**
	 * Column Info
	 * @param vendor
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	/**
	 * Column Info
	 * @param dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	/**
	 * Column Info
	 * @param hdrAsaNo
	 */
	public void setHdrAsaNo(String hdrAsaNo) {
		this.hdrAsaNo = hdrAsaNo;
	}

	/**
	 * Column Info
	 * @param hdrOffice
	 */
	public void setHdrOffice(String hdrOffice) {
		this.hdrOffice = hdrOffice;
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
	 * @param cur
	 */
	public void setCur(String cur) {
		this.cur = cur;
	}

	/**
	 * Column Info
	 * @param hdrApprdBy
	 */
	public void setHdrApprdBy(String hdrApprdBy) {
		this.hdrApprdBy = hdrApprdBy;
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
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setHdrCsrNo(JSPUtil.getParameter(request, prefix + "hdr_csr_no", ""));
		setHdrDesc(JSPUtil.getParameter(request, prefix + "hdr_desc", ""));
		setHdrAmount(JSPUtil.getParameter(request, prefix + "hdr_amount", ""));
		setHdrPrpdBy(JSPUtil.getParameter(request, prefix + "hdr_prpd_by", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAmount(JSPUtil.getParameter(request, prefix + "amount", ""));
		setHdrEviTp(JSPUtil.getParameter(request, prefix + "hdr_evi_tp", ""));
		setVendorNm(JSPUtil.getParameter(request, prefix + "vendor_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setHdrTitle(JSPUtil.getParameter(request, prefix + "hdr_title", ""));
		setHdrCurrCd(JSPUtil.getParameter(request, prefix + "hdr_curr_cd", ""));
		setHdrCsrType(JSPUtil.getParameter(request, prefix + "hdr_csr_type", ""));
		setHdrPayGrp(JSPUtil.getParameter(request, prefix + "hdr_pay_grp", ""));
		setHdrInvDt(JSPUtil.getParameter(request, prefix + "hdr_inv_dt", ""));
		setHdrAmt(JSPUtil.getParameter(request, prefix + "hdr_amt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setHdrPayTo(JSPUtil.getParameter(request, prefix + "hdr_pay_to", ""));
		setHdrDueDt(JSPUtil.getParameter(request, prefix + "hdr_due_dt", ""));
		setVendor(JSPUtil.getParameter(request, prefix + "vendor", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setHdrAsaNo(JSPUtil.getParameter(request, prefix + "hdr_asa_no", ""));
		setHdrOffice(JSPUtil.getParameter(request, prefix + "hdr_office", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setCur(JSPUtil.getParameter(request, prefix + "cur", ""));
		setHdrApprdBy(JSPUtil.getParameter(request, prefix + "hdr_apprd_by", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FFCmpnApprovalPrintMasterVO[]
	 */
	public FFCmpnApprovalPrintMasterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return FFCmpnApprovalPrintMasterVO[]
	 */
	public FFCmpnApprovalPrintMasterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FFCmpnApprovalPrintMasterVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] hdrCsrNo = (JSPUtil.getParameter(request, prefix	+ "hdr_csr_no", length));
			String[] hdrDesc = (JSPUtil.getParameter(request, prefix	+ "hdr_desc", length));
			String[] hdrAmount = (JSPUtil.getParameter(request, prefix	+ "hdr_amount", length));
			String[] hdrPrpdBy = (JSPUtil.getParameter(request, prefix	+ "hdr_prpd_by", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] hdrEviTp = (JSPUtil.getParameter(request, prefix	+ "hdr_evi_tp", length));
			String[] vendorNm = (JSPUtil.getParameter(request, prefix	+ "vendor_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hdrTitle = (JSPUtil.getParameter(request, prefix	+ "hdr_title", length));
			String[] hdrCurrCd = (JSPUtil.getParameter(request, prefix	+ "hdr_curr_cd", length));
			String[] hdrCsrType = (JSPUtil.getParameter(request, prefix	+ "hdr_csr_type", length));
			String[] hdrPayGrp = (JSPUtil.getParameter(request, prefix	+ "hdr_pay_grp", length));
			String[] hdrInvDt = (JSPUtil.getParameter(request, prefix	+ "hdr_inv_dt", length));
			String[] hdrAmt = (JSPUtil.getParameter(request, prefix	+ "hdr_amt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] hdrPayTo = (JSPUtil.getParameter(request, prefix	+ "hdr_pay_to", length));
			String[] hdrDueDt = (JSPUtil.getParameter(request, prefix	+ "hdr_due_dt", length));
			String[] vendor = (JSPUtil.getParameter(request, prefix	+ "vendor", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] hdrAsaNo = (JSPUtil.getParameter(request, prefix	+ "hdr_asa_no", length));
			String[] hdrOffice = (JSPUtil.getParameter(request, prefix	+ "hdr_office", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] cur = (JSPUtil.getParameter(request, prefix	+ "cur", length));
			String[] hdrApprdBy = (JSPUtil.getParameter(request, prefix	+ "hdr_apprd_by", length));

			for (int i = 0; i < length; i++) {
				model = new FFCmpnApprovalPrintMasterVO();
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (hdrCsrNo[i] != null)
					model.setHdrCsrNo(hdrCsrNo[i]);
				if (hdrDesc[i] != null)
					model.setHdrDesc(hdrDesc[i]);
				if (hdrAmount[i] != null)
					model.setHdrAmount(hdrAmount[i]);
				if (hdrPrpdBy[i] != null)
					model.setHdrPrpdBy(hdrPrpdBy[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (hdrEviTp[i] != null)
					model.setHdrEviTp(hdrEviTp[i]);
				if (vendorNm[i] != null)
					model.setVendorNm(vendorNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hdrTitle[i] != null)
					model.setHdrTitle(hdrTitle[i]);
				if (hdrCurrCd[i] != null)
					model.setHdrCurrCd(hdrCurrCd[i]);
				if (hdrCsrType[i] != null)
					model.setHdrCsrType(hdrCsrType[i]);
				if (hdrPayGrp[i] != null)
					model.setHdrPayGrp(hdrPayGrp[i]);
				if (hdrInvDt[i] != null)
					model.setHdrInvDt(hdrInvDt[i]);
				if (hdrAmt[i] != null)
					model.setHdrAmt(hdrAmt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (hdrPayTo[i] != null)
					model.setHdrPayTo(hdrPayTo[i]);
				if (hdrDueDt[i] != null)
					model.setHdrDueDt(hdrDueDt[i]);
				if (vendor[i] != null)
					model.setVendor(vendor[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (hdrAsaNo[i] != null)
					model.setHdrAsaNo(hdrAsaNo[i]);
				if (hdrOffice[i] != null)
					model.setHdrOffice(hdrOffice[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (cur[i] != null)
					model.setCur(cur[i]);
				if (hdrApprdBy[i] != null)
					model.setHdrApprdBy(hdrApprdBy[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFFCmpnApprovalPrintMasterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FFCmpnApprovalPrintMasterVO[]
	 */
	public FFCmpnApprovalPrintMasterVO[] getFFCmpnApprovalPrintMasterVOs(){
		FFCmpnApprovalPrintMasterVO[] vos = (FFCmpnApprovalPrintMasterVO[])models.toArray(new FFCmpnApprovalPrintMasterVO[models.size()]);
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
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCsrNo = this.hdrCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrDesc = this.hdrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAmount = this.hdrAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPrpdBy = this.hdrPrpdBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrEviTp = this.hdrEviTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vendorNm = this.vendorNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrTitle = this.hdrTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCurrCd = this.hdrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCsrType = this.hdrCsrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPayGrp = this.hdrPayGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrInvDt = this.hdrInvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAmt = this.hdrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPayTo = this.hdrPayTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrDueDt = this.hdrDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vendor = this.vendor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAsaNo = this.hdrAsaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrOffice = this.hdrOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cur = this.cur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrApprdBy = this.hdrApprdBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
