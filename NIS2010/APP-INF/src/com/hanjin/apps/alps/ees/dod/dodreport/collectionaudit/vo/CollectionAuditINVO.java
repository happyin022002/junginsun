package com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.vo;

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

public class CollectionAuditINVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<CollectionAuditINVO> models = new ArrayList<CollectionAuditINVO>();
	private String sOfcCd = null;
	private String sEqRtnFromDt = null;
	private String sEqRtnToDt = null;
	private String sArIfYn = null;
	private String sLocTpCd = null;
	private String sLocCd = null;
	private String sCustCd = null;
	private String sCustNm = null;
	private String sExemptionYn = null;
	private String sBkgNo = null;
	private String sCntrNo = null;
	private String sUnmatchYn = null;
	private String sRfaNo = null;
	private String sScNo = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CollectionAuditINVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("s_eq_rtn_from_dt", getSEqRtnFromDt());
		this.hashColumns.put("s_eq_rtn_to_dt", getSEqRtnToDt());
		this.hashColumns.put("s_ar_if_yn", getSArIfYn());
		this.hashColumns.put("s_loc_tp_cd", getSLocTpCd());
		this.hashColumns.put("s_loc_cd", getSLocCd());
		this.hashColumns.put("s_cust_cd", getSCustCd());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("s_exemption_yn", getSExemptionYn());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("s_cntr_no", getSCntrNo());
		this.hashColumns.put("s_unmatch_yn", getSUnmatchYn());
		this.hashColumns.put("s_rfa_no", getSRfaNo());
		this.hashColumns.put("s_sc_no", getSScNo());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("s_eq_rtn_from_dt", "sEqRtnFromDt");
		this.hashFields.put("s_eq_rtn_to_dt", "sEqRtnToDt");
		this.hashFields.put("s_ar_if_yn", "sArIfYn");
		this.hashFields.put("s_loc_tp_cd", "sLocTpCd");
		this.hashFields.put("s_loc_cd", "sLocCd");
		this.hashFields.put("s_cust_cd", "sCustCd");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("s_exemption_yn", "sExemptionYn");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("s_cntr_no", "sCntrNo");
		this.hashFields.put("s_unmatch_yn", "sUnmatchYn");
		this.hashFields.put("s_rfa_no", "sRfaNo");
		this.hashFields.put("s_sc_no", "sScNo");
		return this.hashFields;
	}
	public String getSOfcCd() {
		return this.sOfcCd;
	}

	public String getSEqRtnFromDt() {
		return this.sEqRtnFromDt;
	}

	public String getSEqRtnToDt() {
		return this.sEqRtnToDt;
	}

	public String getSArIfYn() {
		return this.sArIfYn;
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

	public String getSExemptionYn() {
		return this.sExemptionYn;
	}

	public String getSBkgNo() {
		return this.sBkgNo;
	}

	public String getSCntrNo() {
		return this.sCntrNo;
	}

	public String getSUnmatchYn() {
		return this.sUnmatchYn;
	}

	public String getSRfaNo() {
		return this.sRfaNo;
	}

	public String getSScNo() {
		return this.sScNo;
	}

	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}

	public void setSEqRtnFromDt(String sEqRtnFromDt) {
		this.sEqRtnFromDt = sEqRtnFromDt;
	}

	public void setSEqRtnToDt(String sEqRtnToDt) {
		this.sEqRtnToDt = sEqRtnToDt;
	}

	public void setSArIfYn(String sArIfYn) {
		this.sArIfYn = sArIfYn;
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

	public void setSExemptionYn(String sExemptionYn) {
		this.sExemptionYn = sExemptionYn;
	}

	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
	}

	public void setSCntrNo(String sCntrNo) {
		this.sCntrNo = sCntrNo;
	}

	public void setSUnmatchYn(String sUnmatchYn) {
		this.sUnmatchYn = sUnmatchYn;
	}

	public void setSRfaNo(String sRfaNo) {
		this.sRfaNo = sRfaNo;
	}

	public void setSScNo(String sScNo) {
		this.sScNo = sScNo;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setSEqRtnFromDt(JSPUtil.getParameter(request, prefix + "s_eq_rtn_from_dt", ""));
		setSEqRtnToDt(JSPUtil.getParameter(request, prefix + "s_eq_rtn_to_dt", ""));
		setSArIfYn(JSPUtil.getParameter(request, prefix + "s_ar_if_yn", ""));
		setSLocTpCd(JSPUtil.getParameter(request, prefix + "s_loc_tp_cd", ""));
		setSLocCd(JSPUtil.getParameter(request, prefix + "s_loc_cd", ""));
		setSCustCd(JSPUtil.getParameter(request, prefix + "s_cust_cd", ""));
		setSCustNm(JSPUtil.getParameter(request, prefix + "s_cust_nm", ""));
		setSExemptionYn(JSPUtil.getParameter(request, prefix + "s_exemption_yn", ""));
		setSBkgNo(JSPUtil.getParameter(request, prefix + "s_bkg_no", ""));
		setSCntrNo(JSPUtil.getParameter(request, prefix + "s_cntr_no", ""));
		setSUnmatchYn(JSPUtil.getParameter(request, prefix + "s_unmatch_yn", ""));
		setSRfaNo(JSPUtil.getParameter(request, prefix + "s_rfa_no", ""));
		setSScNo(JSPUtil.getParameter(request, prefix + "s_sc_no", ""));
	}

	public CollectionAuditINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CollectionAuditINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CollectionAuditINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] sEqRtnFromDt = (JSPUtil.getParameter(request, prefix	+ "s_eq_rtn_from_dt", length));
			String[] sEqRtnToDt = (JSPUtil.getParameter(request, prefix	+ "s_eq_rtn_to_dt", length));
			String[] sArIfYn = (JSPUtil.getParameter(request, prefix	+ "s_ar_if_yn", length));
			String[] sLocTpCd = (JSPUtil.getParameter(request, prefix	+ "s_loc_tp_cd", length));
			String[] sLocCd = (JSPUtil.getParameter(request, prefix	+ "s_loc_cd", length));
			String[] sCustCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cd", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] sExemptionYn = (JSPUtil.getParameter(request, prefix	+ "s_exemption_yn", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] sCntrNo = (JSPUtil.getParameter(request, prefix	+ "s_cntr_no", length));
			String[] sUnmatchYn = (JSPUtil.getParameter(request, prefix	+ "s_unmatch_yn", length));
			String[] sRfaNo = (JSPUtil.getParameter(request, prefix	+ "s_rfa_no", length));
			String[] sScNo = (JSPUtil.getParameter(request, prefix	+ "s_sc_no", length));
			for (int i = 0; i < length; i++) {
				model = new CollectionAuditINVO();
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (sEqRtnFromDt[i] != null)
					model.setSEqRtnFromDt(sEqRtnFromDt[i]);
				if (sEqRtnToDt[i] != null)
					model.setSEqRtnToDt(sEqRtnToDt[i]);
				if (sArIfYn[i] != null)
					model.setSArIfYn(sArIfYn[i]);
				if (sLocTpCd[i] != null)
					model.setSLocTpCd(sLocTpCd[i]);
				if (sLocCd[i] != null)
					model.setSLocCd(sLocCd[i]);
				if (sCustCd[i] != null)
					model.setSCustCd(sCustCd[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (sExemptionYn[i] != null)
					model.setSExemptionYn(sExemptionYn[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (sCntrNo[i] != null)
					model.setSCntrNo(sCntrNo[i]);
				if (sUnmatchYn[i] != null)
					model.setSUnmatchYn(sUnmatchYn[i]);
				if (sRfaNo[i] != null)
					model.setSRfaNo(sRfaNo[i]);
				if (sScNo[i] != null)
					model.setSScNo(sScNo[i]);
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getCollectionAuditINVOs();
	}

	public CollectionAuditINVO[] getCollectionAuditINVOs(){
		CollectionAuditINVO[] vos = (CollectionAuditINVO[])models.toArray(new CollectionAuditINVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.sOfcCd = this.sOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqRtnFromDt = this.sEqRtnFromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqRtnToDt = this.sEqRtnToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sArIfYn = this.sArIfYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLocTpCd = this.sLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLocCd = this.sLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCd = this.sCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sExemptionYn = this.sExemptionYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrNo = this.sCntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUnmatchYn = this.sUnmatchYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRfaNo = this.sRfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sScNo = this.sScNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}