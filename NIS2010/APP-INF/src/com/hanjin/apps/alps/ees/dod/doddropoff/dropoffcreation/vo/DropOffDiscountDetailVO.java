package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

public class DropOffDiscountDetailVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<DropOffDiscountDetailVO> models = new ArrayList<DropOffDiscountDetailVO>();
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
	private String customer = null;
	private String customerNm = null;
	private String spclCustCntCd = null;
	private String spclCustSeq = null;
	private String spclCustomer = null;
	private String spclCustomerNm = null;
	private String rfaNo = null;
	private String scNo = null;
	private String currCd = null;
	private String genTrfAmt = null;
	private String spclTrfAmt = null;
	private String dcAmt = null;
	private String ttlAmt = null;
	private String dcRmk = null;
	private String authAproRqstNo = null;
	private String atchFileLnkCnt   =  null;
	private String atchFileLnkId   =  null;
	
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public DropOffDiscountDetailVO() {}

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
		this.hashColumns.put("customer", getCustomer());
		this.hashColumns.put("customer_nm", getCustomerNm());
		this.hashColumns.put("spcl_cust_cnt_cd", getSpclCustCntCd());
		this.hashColumns.put("spcl_cust_seq", getSpclCustSeq());
		this.hashColumns.put("spcl_customer", getSpclCustomer());
		this.hashColumns.put("spcl_customer_nm", getSpclCustomerNm());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("gen_trf_amt", getGenTrfAmt());
		this.hashColumns.put("spcl_trf_amt", getSpclTrfAmt());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("dc_rmk", getDcRmk());
		this.hashColumns.put("auth_apro_rqst_no", getAuthAproRqstNo());
		this.hashColumns.put("atch_file_lnk_cnt", getAtchFileLnkCnt());
		this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
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
		this.hashFields.put("customer", "customer");
		this.hashFields.put("customer_nm", "customerNm");
		this.hashFields.put("spcl_cust_cnt_cd", "spclCustCntCd");
		this.hashFields.put("spcl_cust_seq", "spclCustSeq");
		this.hashFields.put("spcl_customer", "spclCustomer");
		this.hashFields.put("spcl_customer_nm", "spclCustomerNm");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("gen_trf_amt", "genTrfAmt");
		this.hashFields.put("spcl_trf_amt", "spclTrfAmt");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("dc_rmk", "dcRmk");
		this.hashFields.put("auth_apro_rqst_no", "authAproRqstNo");
		this.hashFields.put("atch_file_lnk_cnt", "atchFileLnkCnt");
		this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
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

	public String getCustomer() {
		return this.customer;
	}

	public String getCustomerNm() {
		return this.customerNm;
	}

	public String getSpclCustCntCd() {
		return this.spclCustCntCd;
	}

	public String getSpclCustSeq() {
		return this.spclCustSeq;
	}

	public String getSpclCustomer() {
		return this.spclCustomer;
	}

	public String getSpclCustomerNm() {
		return this.spclCustomerNm;
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

	public String getDcRmk() {
		return this.dcRmk;
	}

	public String getAuthAproRqstNo() {
		return authAproRqstNo;
	}

	public String getAtchFileLnkCnt() {
		return atchFileLnkCnt;
	}

	public String getAtchFileLnkId() {
		return atchFileLnkId;
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

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setCustomerNm(String customerNm) {
		this.customerNm = customerNm;
	}

	public void setSpclCustCntCd(String spclCustCntCd) {
		this.spclCustCntCd = spclCustCntCd;
	}

	public void setSpclCustSeq(String spclCustSeq) {
		this.spclCustSeq = spclCustSeq;
	}

	public void setSpclCustomer(String spclCustomer) {
		this.spclCustomer = spclCustomer;
	}

	public void setSpclCustomerNm(String spclCustomerNm) {
		this.spclCustomerNm = spclCustomerNm;
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

	public void setDcRmk(String dcRmk) {
		this.dcRmk = dcRmk;
	}

	public void setAuthAproRqstNo(String authAproRqstNo) {
		this.authAproRqstNo = authAproRqstNo;
	}

	public void setAtchFileLnkCnt(String atchFileLnkCnt) {
		this.atchFileLnkCnt = atchFileLnkCnt;
	}

	public void setAtchFileLnkId(String atchFileLnkId) {
		this.atchFileLnkId = atchFileLnkId;
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
		setCustomer(JSPUtil.getParameter(request, prefix + "customer", ""));
		setCustomerNm(JSPUtil.getParameter(request, prefix + "customer_nm", ""));
		setSpclCustCntCd(JSPUtil.getParameter(request, prefix + "spcl_cust_cnt_cd", ""));
		setSpclCustSeq(JSPUtil.getParameter(request, prefix + "spcl_cust_seq", ""));
		setSpclCustomer(JSPUtil.getParameter(request, prefix + "spcl_customer", ""));
		setSpclCustomerNm(JSPUtil.getParameter(request, prefix + "spcl_customer_nm", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setGenTrfAmt(JSPUtil.getParameter(request, prefix + "gen_trf_amt", ""));
		setSpclTrfAmt(JSPUtil.getParameter(request, prefix + "spcl_trf_amt", ""));
		setDcAmt(JSPUtil.getParameter(request, prefix + "dc_amt", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setDcRmk(JSPUtil.getParameter(request, prefix + "dc_rmk", ""));
		setAuthAproRqstNo(JSPUtil.getParameter(request, prefix + "auth_apro_rqst_no", ""));
		setAtchFileLnkCnt(JSPUtil.getParameter(request,	prefix + "atch_file_lnk_cnt", ""));
		setAtchFileLnkId(JSPUtil.getParameter(request,	prefix + "atch_file_lnk_id", ""));
	}

	public DropOffDiscountDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public DropOffDiscountDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DropOffDiscountDetailVO model = null;

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
			String[] customer = (JSPUtil.getParameter(request, prefix	+ "customer", length));
			String[] customerNm = (JSPUtil.getParameter(request, prefix	+ "customer_nm", length));
			String[] spclCustCntCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cust_cnt_cd", length));
			String[] spclCustSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cust_seq", length));
			String[] spclCustomer = (JSPUtil.getParameter(request, prefix	+ "spcl_customer", length));
			String[] spclCustomerNm = (JSPUtil.getParameter(request, prefix	+ "spcl_customer_nm", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] genTrfAmt = (JSPUtil.getParameter(request, prefix	+ "gen_trf_amt", length));
			String[] spclTrfAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_trf_amt", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] dcRmk = (JSPUtil.getParameter(request, prefix	+ "dc_rmk", length));
			String[] authAproRqstNo = (JSPUtil.getParameter(request, prefix	+ "auth_apro_rqst_no", length));
			String[] atchFileLnkCnt = (JSPUtil.getParameter(request, prefix +	"atch_file_lnk_cnt".trim(),	length));
			String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix +	"atch_file_lnk_id".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new DropOffDiscountDetailVO();
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
				if (customer[i] != null)
					model.setCustomer(customer[i]);
				if (customerNm[i] != null)
					model.setCustomerNm(customerNm[i]);
				if (spclCustCntCd[i] != null)
					model.setSpclCustCntCd(spclCustCntCd[i]);
				if (spclCustSeq[i] != null)
					model.setSpclCustSeq(spclCustSeq[i]);
				if (spclCustomer[i] != null)
					model.setSpclCustomer(spclCustomer[i]);
				if (spclCustomerNm[i] != null)
					model.setSpclCustomerNm(spclCustomerNm[i]);
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
				if (dcRmk[i] != null)
					model.setDcRmk(dcRmk[i]);
				if (authAproRqstNo[i] != null)
					model.setAuthAproRqstNo(authAproRqstNo[i]);
				if ( atchFileLnkCnt[i] != null)
					model.setAtchFileLnkCnt( atchFileLnkCnt[i]);
				if ( atchFileLnkId[i] != null)
					model.setAtchFileLnkId( atchFileLnkId[i]);
				
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getDropOffDiscountDetailVOs();
	}

	public DropOffDiscountDetailVO[] getDropOffDiscountDetailVOs(){
		DropOffDiscountDetailVO[] vos = (DropOffDiscountDetailVO[])models.toArray(new DropOffDiscountDetailVO[models.size()]);
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
		this.customer = this.customer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerNm = this.customerNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustCntCd = this.spclCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustSeq = this.spclCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustomer = this.spclCustomer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustomerNm = this.spclCustomerNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genTrfAmt = this.genTrfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclTrfAmt = this.spclTrfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcRmk = this.dcRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproRqstNo = this.authAproRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkCnt	= this.atchFileLnkCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkId = this.atchFileLnkId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}