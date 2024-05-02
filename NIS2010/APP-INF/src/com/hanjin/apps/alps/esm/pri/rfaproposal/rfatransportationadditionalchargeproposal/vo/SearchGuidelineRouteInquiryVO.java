package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

public class SearchGuidelineRouteInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private String[] pntLocCds = null;

	private String svcScpCd = null;

	private String pntLocCd = null;

	private String bsePortLocCd = null;

	private String svcTpCd = null;

	private String cntCd = null;

	private String effDt = null;

	private String orgDestTpCd;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	@SuppressWarnings("unused")
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchGuidelineRouteInquiryVO() {
	}

	public SearchGuidelineRouteInquiryVO(String svcScpCd, String pntLocCd, String bsePortLocCd, String svcTpCd, String cntCd, String effDt, String orgDestTpCd) {
		this.svcScpCd = svcScpCd;
		this.pntLocCd = pntLocCd;
		this.svcTpCd = svcTpCd;
		this.bsePortLocCd = bsePortLocCd;
		this.cntCd = cntCd;
		this.effDt = effDt;
		this.orgDestTpCd = orgDestTpCd;
	}

	public String[] getPntLocCds() {
		return pntLocCds;
	}

	public void setPntLocCds(String[] pntLocCds) {
		this.pntLocCds = pntLocCds;
	}

	public String getSvcScpCd() {
		return svcScpCd;
	}

	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}

	public String getPntLocCd() {
		return pntLocCd;
	}

	public void setPntLocCd(String pntLocCd) {
		this.pntLocCd = pntLocCd;
	}

	public String getBsePortLocCd() {
		return bsePortLocCd;
	}

	public void setBsePortLocCd(String bsePortLocCd) {
		this.bsePortLocCd = bsePortLocCd;
	}

	public String getSvcTpCd() {
		return svcTpCd;
	}

	public void setSvcTpCd(String svcTpCd) {
		this.svcTpCd = svcTpCd;
	}

	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	public String getEffDt() {
		return effDt;
	}

	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}

	public String getOrgDestTpCd() {
		return orgDestTpCd;
	}

	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}

	@Override
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pnt_loc_cd", getPntLocCd());
		this.hashColumns.put("svc_tp_cd", getSvcTpCd());
		this.hashColumns.put("bse_port_loc_cd", getBsePortLocCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		return this.hashColumns;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request, "");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPntLocCd(JSPUtil.getParameter(request, prefix + "pnt_loc_cd", ""));
		setSvcTpCd(JSPUtil.getParameter(request, prefix + "svc_tp_cd", ""));
		setBsePortLocCd(JSPUtil.getParameter(request, prefix + "bse_port_loc_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
	}
}
