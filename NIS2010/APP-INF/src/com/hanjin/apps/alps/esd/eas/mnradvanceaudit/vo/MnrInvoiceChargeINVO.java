package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo;

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

public class MnrInvoiceChargeINVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<MnrInvoiceChargeINVO> models = new ArrayList<MnrInvoiceChargeINVO>();
	private String pagerows = null;
	private String sErrType = null;
	private String sDifference = null;
	private String ibflag = null;
	private String sEndDt = null;
	private String sRhqOfcCd = null;
	private String sCsrStatus = null;
	private String sAutoAudStsCd = null;
	private String sInvNo = null;
	private String sExpnAudStsCd = null;
	private String sVndrSeq = null;
	private String sCostCd = null;
	private String sCsrNo = null;
	private String sStartDt = null;
	private String sMnrCodeType = null;
	private String sOfcCd = null;
	private String sCostGroupCd = null;
	private String sEqKndCd = null;
	private String sSubsysNo = null;
	private String sMnrInvStsCd = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public MnrInvoiceChargeINVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_err_type", getSErrType());
		this.hashColumns.put("s_difference", getSDifference());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_end_dt", getSEndDt());
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("s_csr_status", getSCsrStatus());
		this.hashColumns.put("s_auto_aud_sts_cd", getSAutoAudStsCd());
		this.hashColumns.put("s_inv_no", getSInvNo());
		this.hashColumns.put("s_expn_aud_sts_cd", getSExpnAudStsCd());
		this.hashColumns.put("s_vndr_seq", getSVndrSeq());
		this.hashColumns.put("s_cost_cd", getSCostCd());
		this.hashColumns.put("s_csr_no", getSCsrNo());
		this.hashColumns.put("s_start_dt", getSStartDt());
		this.hashColumns.put("s_mnr_code_type", getSMnrCodeType());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("s_cost_group_cd", getSCostGroupCd());
		this.hashColumns.put("s_eq_knd_cd", getSEqKndCd());
		this.hashColumns.put("s_subsys_no", getSSubsysNo());
		this.hashColumns.put("s_mnr_inv_sts_cd", getSMnrInvStsCd());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_err_type", "sErrType");
		this.hashFields.put("s_difference", "sDifference");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_end_dt", "sEndDt");
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("s_csr_status", "sCsrStatus");
		this.hashFields.put("s_auto_aud_sts_cd", "sAutoAudStsCd");
		this.hashFields.put("s_inv_no", "sInvNo");
		this.hashFields.put("s_expn_aud_sts_cd", "sExpnAudStsCd");
		this.hashFields.put("s_vndr_seq", "sVndrSeq");
		this.hashFields.put("s_cost_cd", "sCostCd");
		this.hashFields.put("s_csr_no", "sCsrNo");
		this.hashFields.put("s_start_dt", "sStartDt");
		this.hashFields.put("s_mnr_code_type", "sMnrCodeType");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("s_cost_group_cd", "sCostGroupCd");
		this.hashFields.put("s_eq_knd_cd", "sEqKndCd");
		this.hashFields.put("s_subsys_no", "sSubsysNo");
		this.hashFields.put("s_mnr_inv_sts_cd", "sMnrInvStsCd");
		return this.hashFields;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public String getSErrType() {
		return this.sErrType;
	}

	public String getSDifference() {
		return this.sDifference;
	}

	public String getIbflag() {
		return this.ibflag;
	}

	public String getSEndDt() {
		return this.sEndDt;
	}

	public String getSRhqOfcCd() {
		return this.sRhqOfcCd;
	}

	public String getSCsrStatus() {
		return this.sCsrStatus;
	}

	public String getSAutoAudStsCd() {
		return this.sAutoAudStsCd;
	}

	public String getSInvNo() {
		return this.sInvNo;
	}

	public String getSExpnAudStsCd() {
		return this.sExpnAudStsCd;
	}

	public String getSVndrSeq() {
		return this.sVndrSeq;
	}

	public String getSCostCd() {
		return this.sCostCd;
	}

	public String getSCsrNo() {
		return this.sCsrNo;
	}

	public String getSStartDt() {
		return this.sStartDt;
	}

	public String getSMnrCodeType() {
		return this.sMnrCodeType;
	}

	public String getSOfcCd() {
		return this.sOfcCd;
	}

	public String getSCostGroupCd() {
		return this.sCostGroupCd;
	}

	public String getSEqKndCd() {
		return this.sEqKndCd;
	}

	public String getSSubsysNo() {
		return this.sSubsysNo;
	}

	public String getSMnrInvStsCd() {
		return this.sMnrInvStsCd;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public void setSErrType(String sErrType) {
		this.sErrType = sErrType;
	}

	public void setSDifference(String sDifference) {
		this.sDifference = sDifference;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public void setSEndDt(String sEndDt) {
		this.sEndDt = sEndDt;
	}

	public void setSRhqOfcCd(String sRhqOfcCd) {
		this.sRhqOfcCd = sRhqOfcCd;
	}

	public void setSCsrStatus(String sCsrStatus) {
		this.sCsrStatus = sCsrStatus;
	}

	public void setSAutoAudStsCd(String sAutoAudStsCd) {
		this.sAutoAudStsCd = sAutoAudStsCd;
	}

	public void setSInvNo(String sInvNo) {
		this.sInvNo = sInvNo;
	}

	public void setSExpnAudStsCd(String sExpnAudStsCd) {
		this.sExpnAudStsCd = sExpnAudStsCd;
	}

	public void setSVndrSeq(String sVndrSeq) {
		this.sVndrSeq = sVndrSeq;
	}

	public void setSCostCd(String sCostCd) {
		this.sCostCd = sCostCd;
	}

	public void setSCsrNo(String sCsrNo) {
		this.sCsrNo = sCsrNo;
	}

	public void setSStartDt(String sStartDt) {
		this.sStartDt = sStartDt;
	}

	public void setSMnrCodeType(String sMnrCodeType) {
		this.sMnrCodeType = sMnrCodeType;
	}

	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}

	public void setSCostGroupCd(String sCostGroupCd) {
		this.sCostGroupCd = sCostGroupCd;
	}

	public void setSEqKndCd(String sEqKndCd) {
		this.sEqKndCd = sEqKndCd;
	}

	public void setSSubsysNo(String sSubsysNo) {
		this.sSubsysNo = sSubsysNo;
	}

	public void setSMnrInvStsCd(String sMnrInvStsCd) {
		this.sMnrInvStsCd = sMnrInvStsCd;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSErrType(JSPUtil.getParameter(request, prefix + "s_err_type", ""));
		setSDifference(JSPUtil.getParameter(request, prefix + "s_difference", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSEndDt(JSPUtil.getParameter(request, prefix + "s_end_dt", ""));
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setSCsrStatus(JSPUtil.getParameter(request, prefix + "s_csr_status", ""));
		setSAutoAudStsCd(JSPUtil.getParameter(request, prefix + "s_auto_aud_sts_cd", ""));
		setSInvNo(JSPUtil.getParameter(request, prefix + "s_inv_no", ""));
		setSExpnAudStsCd(JSPUtil.getParameter(request, prefix + "s_expn_aud_sts_cd", ""));
		setSVndrSeq(JSPUtil.getParameter(request, prefix + "s_vndr_seq", ""));
		setSCostCd(JSPUtil.getParameter(request, prefix + "s_cost_cd", ""));
		setSCsrNo(JSPUtil.getParameter(request, prefix + "s_csr_no", ""));
		setSStartDt(JSPUtil.getParameter(request, prefix + "s_start_dt", ""));
		setSMnrCodeType(JSPUtil.getParameter(request, prefix + "s_mnr_code_type", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setSCostGroupCd(JSPUtil.getParameter(request, prefix + "s_cost_group_cd", ""));
		setSEqKndCd(JSPUtil.getParameter(request, prefix + "s_eq_knd_cd", ""));
		setSSubsysNo(JSPUtil.getParameter(request, prefix + "s_subsys_no", ""));
		setSMnrInvStsCd(JSPUtil.getParameter(request, prefix + "s_mnr_inv_sts_cd", ""));
	}

	public MnrInvoiceChargeINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public MnrInvoiceChargeINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MnrInvoiceChargeINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sErrType = (JSPUtil.getParameter(request, prefix	+ "s_err_type", length));
			String[] sDifference = (JSPUtil.getParameter(request, prefix	+ "s_difference", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sEndDt = (JSPUtil.getParameter(request, prefix	+ "s_end_dt", length));
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] sCsrStatus = (JSPUtil.getParameter(request, prefix	+ "s_csr_status", length));
			String[] sAutoAudStsCd = (JSPUtil.getParameter(request, prefix	+ "s_auto_aud_sts_cd", length));
			String[] sInvNo = (JSPUtil.getParameter(request, prefix	+ "s_inv_no", length));
			String[] sExpnAudStsCd = (JSPUtil.getParameter(request, prefix	+ "s_expn_aud_sts_cd", length));
			String[] sVndrSeq = (JSPUtil.getParameter(request, prefix	+ "s_vndr_seq", length));
			String[] sCostCd = (JSPUtil.getParameter(request, prefix	+ "s_cost_cd", length));
			String[] sCsrNo = (JSPUtil.getParameter(request, prefix	+ "s_csr_no", length));
			String[] sStartDt = (JSPUtil.getParameter(request, prefix	+ "s_start_dt", length));
			String[] sMnrCodeType = (JSPUtil.getParameter(request, prefix	+ "s_mnr_code_type", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] sCostGroupCd = (JSPUtil.getParameter(request, prefix	+ "s_cost_group_cd", length));
			String[] sEqKndCd = (JSPUtil.getParameter(request, prefix	+ "s_eq_knd_cd", length));
			String[] sSubsysNo = (JSPUtil.getParameter(request, prefix	+ "s_subsys_no", length));
			String[] sMnrInvStsCd = (JSPUtil.getParameter(request, prefix	+ "s_mnr_inv_sts_cd", length));
			for (int i = 0; i < length; i++) {
				model = new MnrInvoiceChargeINVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sErrType[i] != null)
					model.setSErrType(sErrType[i]);
				if (sDifference[i] != null)
					model.setSDifference(sDifference[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sEndDt[i] != null)
					model.setSEndDt(sEndDt[i]);
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (sCsrStatus[i] != null)
					model.setSCsrStatus(sCsrStatus[i]);
				if (sAutoAudStsCd[i] != null)
					model.setSAutoAudStsCd(sAutoAudStsCd[i]);
				if (sInvNo[i] != null)
					model.setSInvNo(sInvNo[i]);
				if (sExpnAudStsCd[i] != null)
					model.setSExpnAudStsCd(sExpnAudStsCd[i]);
				if (sVndrSeq[i] != null)
					model.setSVndrSeq(sVndrSeq[i]);
				if (sCostCd[i] != null)
					model.setSCostCd(sCostCd[i]);
				if (sCsrNo[i] != null)
					model.setSCsrNo(sCsrNo[i]);
				if (sStartDt[i] != null)
					model.setSStartDt(sStartDt[i]);
				if (sMnrCodeType[i] != null)
					model.setSMnrCodeType(sMnrCodeType[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (sCostGroupCd[i] != null)
					model.setSCostGroupCd(sCostGroupCd[i]);
				if (sEqKndCd[i] != null)
					model.setSEqKndCd(sEqKndCd[i]);
				if (sSubsysNo[i] != null)
					model.setSSubsysNo(sSubsysNo[i]);
				if (sMnrInvStsCd[i] != null)
					model.setSMnrInvStsCd(sMnrInvStsCd[i]);
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getMnrInvoiceChargeINVOs();
	}

	public MnrInvoiceChargeINVO[] getMnrInvoiceChargeINVOs(){
		MnrInvoiceChargeINVO[] vos = (MnrInvoiceChargeINVO[])models.toArray(new MnrInvoiceChargeINVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sErrType = this.sErrType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDifference = this.sDifference.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEndDt = this.sEndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqOfcCd = this.sRhqOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCsrStatus = this.sCsrStatus.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAutoAudStsCd = this.sAutoAudStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvNo = this.sInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sExpnAudStsCd = this.sExpnAudStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrSeq = this.sVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCostCd = this.sCostCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCsrNo = this.sCsrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sStartDt = this.sStartDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sMnrCodeType = this.sMnrCodeType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCostGroupCd = this.sCostGroupCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqKndCd = this.sEqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSubsysNo = this.sSubsysNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sMnrInvStsCd = this.sMnrInvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}