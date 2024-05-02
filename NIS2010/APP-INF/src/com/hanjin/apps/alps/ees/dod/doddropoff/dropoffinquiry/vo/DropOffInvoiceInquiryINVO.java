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

public class DropOffInvoiceInquiryINVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<DropOffInvoiceInquiryINVO> models = new ArrayList<DropOffInvoiceInquiryINVO>();
	private String sCfmOfcCd = null;
	private String sCfmFromDt = null;
	private String sCfmToDt = null;
	private String sIndCd = null;
	private String sBkgNo = null;
	private String sLocTpCd = null;
	private String sLocCd = null;
	private String sCustCd = null;
	private String sCustNm = null;
	private String sCntrNo= null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public DropOffInvoiceInquiryINVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_cfm_ofc_cd", getSCfmOfcCd());
		this.hashColumns.put("s_cfm_from_dt", getSCfmFromDt());
		this.hashColumns.put("s_cfm_to_dt", getSCfmToDt());
		this.hashColumns.put("s_ind_cd", getSIndCd());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("s_loc_tp_cd", getSLocTpCd());
		this.hashColumns.put("s_loc_cd", getSLocCd());
		this.hashColumns.put("s_cust_cd", getSCustCd());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("s_cntr_no", getSCntrNo());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_cfm_ofc_cd", "sCfmOfcCd");
		this.hashFields.put("s_cfm_from_dt", "sCfmFromDt");
		this.hashFields.put("s_cfm_to_dt", "sCfmToDt");
		this.hashFields.put("s_ind_cd", "sIndCd");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("s_loc_tp_cd", "sLocTpCd");
		this.hashFields.put("s_loc_cd", "sLocCd");
		this.hashFields.put("s_cust_cd", "sCustCd");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("s_cntr_no", "sCntrNo");
		return this.hashFields;
	}
	public String getSCfmOfcCd() {
		return this.sCfmOfcCd;
	}

	public String getSCfmFromDt() {
		return this.sCfmFromDt;
	}

	public String getSCfmToDt() {
		return this.sCfmToDt;
	}

	public String getSIndCd() {
		return this.sIndCd;
	}

	public String getSBkgNo() {
		return this.sBkgNo;
	}

	public String getSLocTpCd() {
		return this.sLocTpCd;
	}

	public String getSLocCd() {
		return this.sLocCd;
	}

	public String getSCustCd() {
		return this.sCustCd;
	}

	public String getSCustNm() {
		return this.sCustNm;
	}

	public String getSCntrNo() {
		return this.sCntrNo;
	}
	
	public void setSCfmOfcCd(String sCfmOfcCd) {
		this.sCfmOfcCd = sCfmOfcCd;
	}

	public void setSCfmFromDt(String sCfmFromDt) {
		this.sCfmFromDt = sCfmFromDt;
	}

	public void setSCfmToDt(String sCfmToDt) {
		this.sCfmToDt = sCfmToDt;
	}

	public void setSIndCd(String sIndCd) {
		this.sIndCd = sIndCd;
	}

	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
	}

	public void setSLocTpCd(String sLocTpCd) {
		this.sLocTpCd = sLocTpCd;
	}

	public void setSLocCd(String sLocCd) {
		this.sLocCd = sLocCd;
	}

	public void setSCustCd(String sCustCd) {
		this.sCustCd = sCustCd;
	}

	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
	}
   
	public void setSCntrNo(String sCntrNo) {
		this.sCntrNo = sCntrNo;
	}
	
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setSCfmOfcCd(JSPUtil.getParameter(request, prefix + "s_cfm_ofc_cd", ""));
		setSCfmFromDt(JSPUtil.getParameter(request, prefix + "s_cfm_from_dt", ""));
		setSCfmToDt(JSPUtil.getParameter(request, prefix + "s_cfm_to_dt", ""));
		setSIndCd(JSPUtil.getParameter(request, prefix + "s_ind_cd", ""));
		setSBkgNo(JSPUtil.getParameter(request, prefix + "s_bkg_no", ""));
		setSLocTpCd(JSPUtil.getParameter(request, prefix + "s_loc_tp_cd", ""));
		setSLocCd(JSPUtil.getParameter(request, prefix + "s_loc_cd", ""));
		setSCustCd(JSPUtil.getParameter(request, prefix + "s_cust_cd", ""));
		setSCustNm(JSPUtil.getParameter(request, prefix + "s_cust_nm", ""));
		setSCntrNo(JSPUtil.getParameter(request, prefix + "s_cntr_no", ""));
	}

	public DropOffInvoiceInquiryINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public DropOffInvoiceInquiryINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DropOffInvoiceInquiryINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] sCfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_cfm_ofc_cd", length));
			String[] sCfmFromDt = (JSPUtil.getParameter(request, prefix	+ "s_cfm_from_dt", length));
			String[] sCfmToDt = (JSPUtil.getParameter(request, prefix	+ "s_cfm_to_dt", length));
			String[] sIndCd = (JSPUtil.getParameter(request, prefix	+ "s_ind_cd", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] sLocTpCd = (JSPUtil.getParameter(request, prefix	+ "s_loc_tp_cd", length));
			String[] sLocCd = (JSPUtil.getParameter(request, prefix	+ "s_loc_cd", length));
			String[] sCustCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cd", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] sCntrNo = (JSPUtil.getParameter(request, prefix	+ "s_cntr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new DropOffInvoiceInquiryINVO();
				if (sCfmOfcCd[i] != null)
					model.setSCfmOfcCd(sCfmOfcCd[i]);
				if (sCfmFromDt[i] != null)
					model.setSCfmFromDt(sCfmFromDt[i]);
				if (sCfmToDt[i] != null)
					model.setSCfmToDt(sCfmToDt[i]);
				if (sIndCd[i] != null)
					model.setSIndCd(sIndCd[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (sLocTpCd[i] != null)
					model.setSLocTpCd(sLocTpCd[i]);
				if (sLocCd[i] != null)
					model.setSLocCd(sLocCd[i]);
				if (sCustCd[i] != null)
					model.setSCustCd(sCustCd[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (sCntrNo[i] != null)
					model.setSCntrNo(sCntrNo[i]);
				
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getDropOffInvoiceInquiryINVOs();
	}

	public DropOffInvoiceInquiryINVO[] getDropOffInvoiceInquiryINVOs(){
		DropOffInvoiceInquiryINVO[] vos = (DropOffInvoiceInquiryINVO[])models.toArray(new DropOffInvoiceInquiryINVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.sCfmOfcCd = this.sCfmOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCfmFromDt = this.sCfmFromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCfmToDt = this.sCfmToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIndCd = this.sIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLocTpCd = this.sLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLocCd = this.sLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCd = this.sCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrNo = this.sCntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}