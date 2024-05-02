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

public class DropOffInvoiceInquiryDetailListVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<DropOffInvoiceInquiryDetailListVO> models = new ArrayList<DropOffInvoiceInquiryDetailListVO>();
	private String troIbCfmOfcCd = null;
	private String bkgNo = null;
	private String troIbCfmDt = null;
	private String cntrNo = null;
	private String cntrTpszCd = null;
	private String delCd = null;
	private String cntrRtnYdCd = null;
	private String cntrRtnDt = null;
	private String custCntCd = null;
	private String custSeq = null;
	private String custLglEngNm = null;
	private String spclCustCntCd = null;
	private String spclCustSeq = null;
	private String customer = null;
	private String spcCustomer = null;
	private String spclCustLglEngNm = null;
	private String rfaNo = null;
	private String scNo = null;
	private String currCd = null;
	private String genTrfAmt = null;
	private String spclTrfAmt = null;
	private String dcAmt = null;
	private String ttlAmt = null;
	private String updDt = null;
	private String updUsrId = null;
	private String cxlFlg = null;
	private String svcFeeAmt = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public DropOffInvoiceInquiryDetailListVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tro_ib_cfm_ofc_cd", getTroIbCfmOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("tro_ib_cfm_dt", getTroIbCfmDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cntr_rtn_yd_cd", getCntrRtnYdCd());
		this.hashColumns.put("cntr_rtn_dt", getCntrRtnDt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("spcl_cust_cnt_cd", getSpclCustCntCd());
		this.hashColumns.put("spcl_cust_seq", getSpclCustSeq());
		this.hashColumns.put("customer", getCustomer());
		this.hashColumns.put("spc_customer", getSpcCustomer());
		this.hashColumns.put("spcl_cust_lgl_eng_nm", getSpclCustLglEngNm());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("gen_trf_amt", getGenTrfAmt());
		this.hashColumns.put("spcl_trf_amt", getSpclTrfAmt());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("svc_fee_amt", getSvcFeeAmt());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tro_ib_cfm_ofc_cd", "troIbCfmOfcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("tro_ib_cfm_dt", "troIbCfmDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cntr_rtn_yd_cd", "cntrRtnYdCd");
		this.hashFields.put("cntr_rtn_dt", "cntrRtnDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("spcl_cust_cnt_cd", "spclCustCntCd");
		this.hashFields.put("spcl_cust_seq", "spclCustSeq");
		this.hashFields.put("customer", "customer");
		this.hashFields.put("spc_customer", "spcCustomer");
		this.hashFields.put("spcl_cust_lgl_eng_nm", "spclCustLglEngNm");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("gen_trf_amt", "genTrfAmt");
		this.hashFields.put("spcl_trf_amt", "spclTrfAmt");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("svc_fee_amt", "svcFeeAmt");
		return this.hashFields;
	}
	public String getTroIbCfmOfcCd() {
		return this.troIbCfmOfcCd;
	}

	public String getBkgNo() {
		return this.bkgNo;
	}

	public String getTroIbCfmDt() {
		return this.troIbCfmDt;
	}

	public String getCntrNo() {
		return this.cntrNo;
	}

	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	public String getDelCd() {
		return this.delCd;
	}

	public String getCntrRtnYdCd() {
		return this.cntrRtnYdCd;
	}

	public String getCntrRtnDt() {
		return this.cntrRtnDt;
	}

	public String getCustCntCd() {
		return this.custCntCd;
	}

	public String getCustSeq() {
		return this.custSeq;
	}

	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}

	public String getSpclCustCntCd() {
		return this.spclCustCntCd;
	}

	public String getSpclCustSeq() {
		return this.spclCustSeq;
	}

	public String getCustomer() {
		return this.customer;
	}

	public String getSpcCustomer() {
		return this.spcCustomer;
	}

	public String getSpclCustLglEngNm() {
		return this.spclCustLglEngNm;
	}

	public String getRfaNo() {
		return this.rfaNo;
	}

	public String getScNo() {
		return this.scNo;
	}

	public String getCurrCd() {
		return this.currCd;
	}

	public String getGenTrfAmt() {
		return this.genTrfAmt;
	}

	public String getSpclTrfAmt() {
		return this.spclTrfAmt;
	}

	public String getDcAmt() {
		return this.dcAmt;
	}

	public String getTtlAmt() {
		return this.ttlAmt;
	}

	public String getUpdDt() {
		return this.updDt;
	}

	public String getUpdUsrId() {
		return this.updUsrId;
	}

	public String getCxlFlg() {
		return this.cxlFlg;
	}

	public String getSvcFeeAmt() {
		return this.svcFeeAmt;
	}

	public void setTroIbCfmOfcCd(String troIbCfmOfcCd) {
		this.troIbCfmOfcCd = troIbCfmOfcCd;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public void setTroIbCfmDt(String troIbCfmDt) {
		this.troIbCfmDt = troIbCfmDt;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	public void setCntrRtnYdCd(String cntrRtnYdCd) {
		this.cntrRtnYdCd = cntrRtnYdCd;
	}

	public void setCntrRtnDt(String cntrRtnDt) {
		this.cntrRtnDt = cntrRtnDt;
	}

	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}

	public void setSpclCustCntCd(String spclCustCntCd) {
		this.spclCustCntCd = spclCustCntCd;
	}

	public void setSpclCustSeq(String spclCustSeq) {
		this.spclCustSeq = spclCustSeq;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setSpcCustomer(String spcCustomer) {
		this.spcCustomer = spcCustomer;
	}

	public void setSpclCustLglEngNm(String spclCustLglEngNm) {
		this.spclCustLglEngNm = spclCustLglEngNm;
	}

	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}

	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	public void setGenTrfAmt(String genTrfAmt) {
		this.genTrfAmt = genTrfAmt;
	}

	public void setSpclTrfAmt(String spclTrfAmt) {
		this.spclTrfAmt = spclTrfAmt;
	}

	public void setDcAmt(String dcAmt) {
		this.dcAmt = dcAmt;
	}

	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
	}

	public void setSvcFeeAmt(String svcFeeAmt) {
		this.svcFeeAmt = svcFeeAmt;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setTroIbCfmOfcCd(JSPUtil.getParameter(request, prefix + "tro_ib_cfm_ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTroIbCfmDt(JSPUtil.getParameter(request, prefix + "tro_ib_cfm_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCntrRtnYdCd(JSPUtil.getParameter(request, prefix + "cntr_rtn_yd_cd", ""));
		setCntrRtnDt(JSPUtil.getParameter(request, prefix + "cntr_rtn_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setSpclCustCntCd(JSPUtil.getParameter(request, prefix + "spcl_cust_cnt_cd", ""));
		setSpclCustSeq(JSPUtil.getParameter(request, prefix + "spcl_cust_seq", ""));
		setCustomer(JSPUtil.getParameter(request, prefix + "customer", ""));
		setSpcCustomer(JSPUtil.getParameter(request, prefix + "spc_customer", ""));
		setSpclCustLglEngNm(JSPUtil.getParameter(request, prefix + "spcl_cust_lgl_eng_nm", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setGenTrfAmt(JSPUtil.getParameter(request, prefix + "gen_trf_amt", ""));
		setSpclTrfAmt(JSPUtil.getParameter(request, prefix + "spcl_trf_amt", ""));
		setDcAmt(JSPUtil.getParameter(request, prefix + "dc_amt", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCxlFlg(JSPUtil.getParameter(request, prefix + "cxl_flg", ""));
		setSvcFeeAmt(JSPUtil.getParameter(request, prefix + "svc_fee_amt", ""));
	}

	public DropOffInvoiceInquiryDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public DropOffInvoiceInquiryDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DropOffInvoiceInquiryDetailListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] troIbCfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "tro_ib_cfm_ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] troIbCfmDt = (JSPUtil.getParameter(request, prefix	+ "tro_ib_cfm_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cntrRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_yd_cd", length));
			String[] cntrRtnDt = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_dt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] spclCustCntCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cust_cnt_cd", length));
			String[] spclCustSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cust_seq", length));
			String[] customer = (JSPUtil.getParameter(request, prefix	+ "customer", length));
			String[] spcCustomer = (JSPUtil.getParameter(request, prefix	+ "spc_customer", length));
			String[] spclCustLglEngNm = (JSPUtil.getParameter(request, prefix	+ "spcl_cust_lgl_eng_nm", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] genTrfAmt = (JSPUtil.getParameter(request, prefix	+ "gen_trf_amt", length));
			String[] spclTrfAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_trf_amt", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] svcFeeAmt = (JSPUtil.getParameter(request, prefix	+ "svc_fee_amt", length));
			for (int i = 0; i < length; i++) {
				model = new DropOffInvoiceInquiryDetailListVO();
				if (troIbCfmOfcCd[i] != null)
					model.setTroIbCfmOfcCd(troIbCfmOfcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (troIbCfmDt[i] != null)
					model.setTroIbCfmDt(troIbCfmDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cntrRtnYdCd[i] != null)
					model.setCntrRtnYdCd(cntrRtnYdCd[i]);
				if (cntrRtnDt[i] != null)
					model.setCntrRtnDt(cntrRtnDt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (spclCustCntCd[i] != null)
					model.setSpclCustCntCd(spclCustCntCd[i]);
				if (spclCustSeq[i] != null)
					model.setSpclCustSeq(spclCustSeq[i]);
				if (customer[i] != null)
					model.setCustomer(customer[i]);
				if (spcCustomer[i] != null)
					model.setSpcCustomer(spcCustomer[i]);
				if (spclCustLglEngNm[i] != null)
					model.setSpclCustLglEngNm(spclCustLglEngNm[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (genTrfAmt[i] != null)
					model.setGenTrfAmt(genTrfAmt[i]);
				if (spclTrfAmt[i] != null)
					model.setSpclTrfAmt(spclTrfAmt[i]);
				if (dcAmt[i] != null)
					model.setDcAmt(dcAmt[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (svcFeeAmt[i] != null)
					model.setSvcFeeAmt(svcFeeAmt[i]);
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getDropOffInvoiceInquiryDetailListVOs();
	}

	public DropOffInvoiceInquiryDetailListVO[] getDropOffInvoiceInquiryDetailListVOs(){
		DropOffInvoiceInquiryDetailListVO[] vos = (DropOffInvoiceInquiryDetailListVO[])models.toArray(new DropOffInvoiceInquiryDetailListVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.troIbCfmOfcCd = this.troIbCfmOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troIbCfmDt = this.troIbCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnYdCd = this.cntrRtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnDt = this.cntrRtnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustCntCd = this.spclCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustSeq = this.spclCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customer = this.customer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCustomer = this.spcCustomer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustLglEngNm = this.spclCustLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genTrfAmt = this.genTrfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclTrfAmt = this.spclTrfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcFeeAmt = this.svcFeeAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}