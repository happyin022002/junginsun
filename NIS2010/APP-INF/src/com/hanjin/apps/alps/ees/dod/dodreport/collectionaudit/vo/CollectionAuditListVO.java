package com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

public class CollectionAuditListVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<CollectionAuditListVO> models = new ArrayList<CollectionAuditListVO>();
	private String cfmOfcCd = null;
	private String cntrNo = null;
	private String cntrTpszCd = null;
	private String delCd = null;
	private String troCntrRtnYdCd = null;
	private String troCntrRtnDt = null;
	private String actTrnYard = null;
	private String cntrRtnDt = null;
	private String bkgNo = null;
	private String porCd = null;
	private String polCd = null;
	private String podCd = null;
	private String scNo = null;
	private String rfaNo = null;
	private String custCntCd = null;
	private String custSeq = null;
	private String customer = null;
	private String custLglEngNm = null;
	private String polEtdDt = null;
	private String troDt = null;
	private String arIfDt = null;
	private String currCd = null;
	private String genTrfAmt = null;
	private String spclTrfAmt = null;
	private String incurredAmt = null;
	private String adjustAmt = null;
	private String invoiceAmt = null;
	private String invoiceUsdAmt = null;
	private String exemption = null;
	private String adjustApproval = null;
	private String remark = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CollectionAuditListVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cfm_ofc_cd", getCfmOfcCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("tro_cntr_rtn_yd_cd", getTroCntrRtnYdCd());
		this.hashColumns.put("tro_cntr_rtn_dt", getTroCntrRtnDt());
		this.hashColumns.put("act_trn_yard", getActTrnYard());
		this.hashColumns.put("cntr_rtn_dt", getCntrRtnDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("customer", getCustomer());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("pol_etd_dt", getPolEtdDt());
		this.hashColumns.put("tro_dt", getTroDt());
		this.hashColumns.put("ar_if_dt", getArIfDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("gen_trf_amt", getGenTrfAmt());
		this.hashColumns.put("spcl_trf_amt", getSpclTrfAmt());
		this.hashColumns.put("incurred_amt", getIncurredAmt());
		this.hashColumns.put("adjust_amt", getAdjustAmt());
		this.hashColumns.put("invoice_amt", getInvoiceAmt());
		this.hashColumns.put("invoice_usd_amt", getInvoiceUsdAmt());
		this.hashColumns.put("exemption", getExemption());
		this.hashColumns.put("adjust_approval", getAdjustApproval());
		this.hashColumns.put("remark", getRemark());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cfm_ofc_cd", "cfmOfcCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("tro_cntr_rtn_yd_cd", "troCntrRtnYdCd");
		this.hashFields.put("tro_cntr_rtn_dt", "troCntrRtnDt");
		this.hashFields.put("act_trn_yard", "actTrnYard");
		this.hashFields.put("cntr_rtn_dt", "cntrRtnDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("customer", "customer");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("pol_etd_dt", "polEtdDt");
		this.hashFields.put("tro_dt", "troDt");
		this.hashFields.put("ar_if_dt", "arIfDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("gen_trf_amt", "genTrfAmt");
		this.hashFields.put("spcl_trf_amt", "spclTrfAmt");
		this.hashFields.put("incurred_amt", "incurredAmt");
		this.hashFields.put("adjust_amt", "adjustAmt");
		this.hashFields.put("invoice_amt", "invoiceAmt");
		this.hashFields.put("invoice_usd_amt", "invoiceUsdAmt");
		this.hashFields.put("exemption", "exemption");
		this.hashFields.put("adjust_approval", "adjustApproval");
		this.hashFields.put("remark", "remark");
		return this.hashFields;
	}
	public String getCfmOfcCd() {
		return this.cfmOfcCd;
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

	public String getTroCntrRtnYdCd() {
		return this.troCntrRtnYdCd;
	}

	public String getTroCntrRtnDt() {
		return this.troCntrRtnDt;
	}

	public String getActTrnYard() {
		return this.actTrnYard;
	}

	public String getCntrRtnDt() {
		return this.cntrRtnDt;
	}

	public String getBkgNo() {
		return this.bkgNo;
	}

	public String getPorCd() {
		return this.porCd;
	}

	public String getPolCd() {
		return this.polCd;
	}

	public String getPodCd() {
		return this.podCd;
	}

	public String getScNo() {
		return this.scNo;
	}

	public String getRfaNo() {
		return this.rfaNo;
	}

	public String getCustCntCd() {
		return this.custCntCd;
	}

	public String getCustSeq() {
		return this.custSeq;
	}

	public String getCustomer() {
		return this.customer;
	}

	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}

	public String getPolEtdDt() {
		return this.polEtdDt;
	}

	public String getTroDt() {
		return this.troDt;
	}

	public String getArIfDt() {
		return this.arIfDt;
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

	public String getIncurredAmt() {
		return this.incurredAmt;
	}

	public String getAdjustAmt() {
		return this.adjustAmt;
	}

	public String getInvoiceAmt() {
		return this.invoiceAmt;
	}

	public String getInvoiceUsdAmt() {
		return this.invoiceUsdAmt;
	}

	public String getExemption() {
		return this.exemption;
	}

	public String getAdjustApproval() {
		return this.adjustApproval;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setCfmOfcCd(String cfmOfcCd) {
		this.cfmOfcCd = cfmOfcCd;
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

	public void setTroCntrRtnYdCd(String troCntrRtnYdCd) {
		this.troCntrRtnYdCd = troCntrRtnYdCd;
	}

	public void setTroCntrRtnDt(String troCntrRtnDt) {
		this.troCntrRtnDt = troCntrRtnDt;
	}

	public void setActTrnYard(String actTrnYard) {
		this.actTrnYard = actTrnYard;
	}

	public void setCntrRtnDt(String cntrRtnDt) {
		this.cntrRtnDt = cntrRtnDt;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}

	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}

	public void setPolEtdDt(String polEtdDt) {
		this.polEtdDt = polEtdDt;
	}

	public void setTroDt(String troDt) {
		this.troDt = troDt;
	}

	public void setArIfDt(String arIfDt) {
		this.arIfDt = arIfDt;
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

	public void setIncurredAmt(String incurredAmt) {
		this.incurredAmt = incurredAmt;
	}

	public void setAdjustAmt(String adjustAmt) {
		this.adjustAmt = adjustAmt;
	}

	public void setInvoiceAmt(String invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}

	public void setInvoiceUsdAmt(String invoiceUsdAmt) {
		this.invoiceUsdAmt = invoiceUsdAmt;
	}

	public void setExemption(String exemption) {
		this.exemption = exemption;
	}

	public void setAdjustApproval(String adjustApproval) {
		this.adjustApproval = adjustApproval;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setCfmOfcCd(JSPUtil.getParameter(request, prefix + "cfm_ofc_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setTroCntrRtnYdCd(JSPUtil.getParameter(request, prefix + "tro_cntr_rtn_yd_cd", ""));
		setTroCntrRtnDt(JSPUtil.getParameter(request, prefix + "tro_cntr_rtn_dt", ""));
		setActTrnYard(JSPUtil.getParameter(request, prefix + "act_trn_yard", ""));
		setCntrRtnDt(JSPUtil.getParameter(request, prefix + "cntr_rtn_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCustomer(JSPUtil.getParameter(request, prefix + "customer", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setPolEtdDt(JSPUtil.getParameter(request, prefix + "pol_etd_dt", ""));
		setTroDt(JSPUtil.getParameter(request, prefix + "tro_dt", ""));
		setArIfDt(JSPUtil.getParameter(request, prefix + "ar_if_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setGenTrfAmt(JSPUtil.getParameter(request, prefix + "gen_trf_amt", ""));
		setSpclTrfAmt(JSPUtil.getParameter(request, prefix + "spcl_trf_amt", ""));
		setIncurredAmt(JSPUtil.getParameter(request, prefix + "incurred_amt", ""));
		setAdjustAmt(JSPUtil.getParameter(request, prefix + "adjust_amt", ""));
		setInvoiceAmt(JSPUtil.getParameter(request, prefix + "invoice_amt", ""));
		setInvoiceUsdAmt(JSPUtil.getParameter(request, prefix + "invoice_usd_amt", ""));
		setExemption(JSPUtil.getParameter(request, prefix + "exemption", ""));
		setAdjustApproval(JSPUtil.getParameter(request, prefix + "adjust_approval", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
	}

	public CollectionAuditListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CollectionAuditListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CollectionAuditListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "cfm_ofc_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] troCntrRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "tro_cntr_rtn_yd_cd", length));
			String[] troCntrRtnDt = (JSPUtil.getParameter(request, prefix	+ "tro_cntr_rtn_dt", length));
			String[] actTrnYard = (JSPUtil.getParameter(request, prefix	+ "act_trn_yard", length));
			String[] cntrRtnDt = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] customer = (JSPUtil.getParameter(request, prefix	+ "customer", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] polEtdDt = (JSPUtil.getParameter(request, prefix	+ "pol_etd_dt", length));
			String[] troDt = (JSPUtil.getParameter(request, prefix	+ "tro_dt", length));
			String[] arIfDt = (JSPUtil.getParameter(request, prefix	+ "ar_if_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] genTrfAmt = (JSPUtil.getParameter(request, prefix	+ "gen_trf_amt", length));
			String[] spclTrfAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_trf_amt", length));
			String[] incurredAmt = (JSPUtil.getParameter(request, prefix	+ "incurred_amt", length));
			String[] adjustAmt = (JSPUtil.getParameter(request, prefix	+ "adjust_amt", length));
			String[] invoiceAmt = (JSPUtil.getParameter(request, prefix	+ "invoice_amt", length));
			String[] invoiceUsdAmt = (JSPUtil.getParameter(request, prefix	+ "invoice_usd_amt", length));
			String[] exemption = (JSPUtil.getParameter(request, prefix	+ "exemption", length));
			String[] adjustApproval = (JSPUtil.getParameter(request, prefix	+ "adjust_approval", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			for (int i = 0; i < length; i++) {
				model = new CollectionAuditListVO();
				if (cfmOfcCd[i] != null)
					model.setCfmOfcCd(cfmOfcCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (troCntrRtnYdCd[i] != null)
					model.setTroCntrRtnYdCd(troCntrRtnYdCd[i]);
				if (troCntrRtnDt[i] != null)
					model.setTroCntrRtnDt(troCntrRtnDt[i]);
				if (actTrnYard[i] != null)
					model.setActTrnYard(actTrnYard[i]);
				if (cntrRtnDt[i] != null)
					model.setCntrRtnDt(cntrRtnDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (customer[i] != null)
					model.setCustomer(customer[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (polEtdDt[i] != null)
					model.setPolEtdDt(polEtdDt[i]);
				if (troDt[i] != null)
					model.setTroDt(troDt[i]);
				if (arIfDt[i] != null)
					model.setArIfDt(arIfDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (genTrfAmt[i] != null)
					model.setGenTrfAmt(genTrfAmt[i]);
				if (spclTrfAmt[i] != null)
					model.setSpclTrfAmt(spclTrfAmt[i]);
				if (incurredAmt[i] != null)
					model.setIncurredAmt(incurredAmt[i]);
				if (adjustAmt[i] != null)
					model.setAdjustAmt(adjustAmt[i]);
				if (invoiceAmt[i] != null)
					model.setInvoiceAmt(invoiceAmt[i]);
				if (invoiceUsdAmt[i] != null)
					model.setInvoiceUsdAmt(invoiceUsdAmt[i]);
				if (exemption[i] != null)
					model.setExemption(exemption[i]);
				if (adjustApproval[i] != null)
					model.setAdjustApproval(adjustApproval[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getCollectionAuditListVOs();
	}

	public CollectionAuditListVO[] getCollectionAuditListVOs(){
		CollectionAuditListVO[] vos = (CollectionAuditListVO[])models.toArray(new CollectionAuditListVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.cfmOfcCd = this.cfmOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCntrRtnYdCd = this.troCntrRtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCntrRtnDt = this.troCntrRtnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actTrnYard = this.actTrnYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnDt = this.cntrRtnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customer = this.customer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdDt = this.polEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troDt = this.troDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfDt = this.arIfDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genTrfAmt = this.genTrfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclTrfAmt = this.spclTrfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incurredAmt = this.incurredAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjustAmt = this.adjustAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceAmt = this.invoiceAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceUsdAmt = this.invoiceUsdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exemption = this.exemption.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjustApproval = this.adjustApproval.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}