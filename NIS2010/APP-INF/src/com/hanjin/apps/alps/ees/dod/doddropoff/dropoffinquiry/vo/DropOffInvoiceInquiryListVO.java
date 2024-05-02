package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

public class DropOffInvoiceInquiryListVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<DropOffInvoiceInquiryListVO> models = new ArrayList<DropOffInvoiceInquiryListVO>();
	private String bkgNo = null;
	private String currCd = null;
	private String ttlAmt = null;
	private String ttlUsdAmt = null;
	private String issDt = null;
	private String issOfcCd = null;
	private String issUser = null;
	private String spclCustCntCd = null;
	private String spclCustSeq = null;
	private String spclCustLglEngNm = null;
	private String drpOffChgMnlFlg = null;
	private String cxlFlg = null;
	private String customer = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public DropOffInvoiceInquiryListVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("ttl_usd_amt", getTtlUsdAmt());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
		this.hashColumns.put("iss_user", getIssUser());
		this.hashColumns.put("spcl_cust_cnt_cd", getSpclCustCntCd());
		this.hashColumns.put("spcl_cust_seq", getSpclCustSeq());
		this.hashColumns.put("spcl_cust_lgl_eng_nm", getSpclCustLglEngNm());
		this.hashColumns.put("drp_off_chg_mnl_flg", getDrpOffChgMnlFlg());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("customer", getCustomer());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("ttl_usd_amt", "ttlUsdAmt");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("iss_user", "issUser");
		this.hashFields.put("spcl_cust_cnt_cd", "spclCustCntCd");
		this.hashFields.put("spcl_cust_seq", "spclCustSeq");
		this.hashFields.put("spcl_cust_lgl_eng_nm", "spclCustLglEngNm");
		this.hashFields.put("drp_off_chg_mnl_flg", "drpOffChgMnlFlg");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("customer", "customer");
		return this.hashFields;
	}
	public String getBkgNo() {
		return this.bkgNo;
	}

	public String getCurrCd() {
		return this.currCd;
	}

	public String getTtlAmt() {
		return this.ttlAmt;
	}

	public String getTtlUsdAmt() {
		return this.ttlUsdAmt;
	}

	public String getIssDt() {
		return this.issDt;
	}

	public String getIssOfcCd() {
		return this.issOfcCd;
	}

	public String getIssUser() {
		return this.issUser;
	}

	public String getSpclCustCntCd() {
		return this.spclCustCntCd;
	}

	public String getSpclCustSeq() {
		return this.spclCustSeq;
	}

	public String getSpclCustLglEngNm() {
		return this.spclCustLglEngNm;
	}

	public String getDrpOffChgMnlFlg() {
		return this.drpOffChgMnlFlg;
	}

	public String getCxlFlg() {
		return this.cxlFlg;
	}

	public String getCustomer() {
		return this.customer;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}

	public void setTtlUsdAmt(String ttlUsdAmt) {
		this.ttlUsdAmt = ttlUsdAmt;
	}

	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}

	public void setIssOfcCd(String issOfcCd) {
		this.issOfcCd = issOfcCd;
	}

	public void setIssUser(String issUser) {
		this.issUser = issUser;
	}

	public void setSpclCustCntCd(String spclCustCntCd) {
		this.spclCustCntCd = spclCustCntCd;
	}

	public void setSpclCustSeq(String spclCustSeq) {
		this.spclCustSeq = spclCustSeq;
	}

	public void setSpclCustLglEngNm(String spclCustLglEngNm) {
		this.spclCustLglEngNm = spclCustLglEngNm;
	}

	public void setDrpOffChgMnlFlg(String drpOffChgMnlFlg) {
		this.drpOffChgMnlFlg = drpOffChgMnlFlg;
	}

	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setTtlUsdAmt(JSPUtil.getParameter(request, prefix + "ttl_usd_amt", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setIssOfcCd(JSPUtil.getParameter(request, prefix + "iss_ofc_cd", ""));
		setIssUser(JSPUtil.getParameter(request, prefix + "iss_user", ""));
		setSpclCustCntCd(JSPUtil.getParameter(request, prefix + "spcl_cust_cnt_cd", ""));
		setSpclCustSeq(JSPUtil.getParameter(request, prefix + "spcl_cust_seq", ""));
		setSpclCustLglEngNm(JSPUtil.getParameter(request, prefix + "spcl_cust_lgl_eng_nm", ""));
		setDrpOffChgMnlFlg(JSPUtil.getParameter(request, prefix + "drp_off_chg_mnl_flg", ""));
		setCxlFlg(JSPUtil.getParameter(request, prefix + "cxl_flg", ""));
		setCustomer(JSPUtil.getParameter(request, prefix + "customer", ""));
	}

	public DropOffInvoiceInquiryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public DropOffInvoiceInquiryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DropOffInvoiceInquiryListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] ttlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_usd_amt", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] issOfcCd = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_cd", length));
			String[] issUser = (JSPUtil.getParameter(request, prefix	+ "iss_user", length));
			String[] spclCustCntCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cust_cnt_cd", length));
			String[] spclCustSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cust_seq", length));
			String[] spclCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "spcl_cust_lgl_eng_nm", length));
			String[] drpOffChgMnlFlg = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_mnl_flg", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] customer = (JSPUtil.getParameter(request, prefix	+ "customer", length));
			for (int i = 0; i < length; i++) {
				model = new DropOffInvoiceInquiryListVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (ttlUsdAmt[i] != null)
					model.setTtlUsdAmt(ttlUsdAmt[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (issOfcCd[i] != null)
					model.setIssOfcCd(issOfcCd[i]);
				if (issUser[i] != null)
					model.setIssUser(issUser[i]);
				if (spclCustCntCd[i] != null)
					model.setSpclCustCntCd(spclCustCntCd[i]);
				if (spclCustSeq[i] != null)
					model.setSpclCustSeq(spclCustSeq[i]);
				if (spclCustLglEngNm[i] != null)
					model.setSpclCustLglEngNm(spclCustLglEngNm[i]);
				if (drpOffChgMnlFlg[i] != null)
					model.setDrpOffChgMnlFlg(drpOffChgMnlFlg[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (customer[i] != null)
					model.setCustomer(customer[i]);
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getDropOffInvoiceInquiryListVOs();
	}

	public DropOffInvoiceInquiryListVO[] getDropOffInvoiceInquiryListVOs(){
		DropOffInvoiceInquiryListVO[] vos = (DropOffInvoiceInquiryListVO[])models.toArray(new DropOffInvoiceInquiryListVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlUsdAmt = this.ttlUsdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd = this.issOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issUser = this.issUser.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustCntCd = this.spclCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustSeq = this.spclCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustLglEngNm = this.spclCustLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgMnlFlg = this.drpOffChgMnlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customer = this.customer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}