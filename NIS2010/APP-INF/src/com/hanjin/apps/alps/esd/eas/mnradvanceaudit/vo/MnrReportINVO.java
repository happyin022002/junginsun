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

public class MnrReportINVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<MnrReportINVO> models = new ArrayList<MnrReportINVO>();
	private String sCostDtlCd = null;
	private String ibflag = null;
	private String sParamLocCd = null;
	private String sEqTpszCd = null;
	private String sFromEqNo = null;
	private String sRangeStart = null;
	private String sRccCd = null;
	private String sDvAmt = null;
	private String sRprCnt = null;
	private String sSerial = null;
	private String sEqNo = null;
	private String sStartDt = null;
	private String sCntCd = null;
	private String sOverDvAmt = null;
	private String sRangeEnd = null;
	private String pagerows = null;
	private String sNoOfRepairs = null;
	private String sYdCd = null;
	private String sEndDt = null;
	private String sRcc = null;
	private String sVndrSeq = null;
	private String sLocCd = null;
	private String sRepairAmt = null;
	private String sPrefixEqNo = null;
	private String sOwnership = null;
	private String sToEqNo = null;
	private String sLocationCd = null;
	private String sRprAmt = null;
	private String pageNo = null;
	private String sCargoType = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public MnrReportINVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_cost_dtl_cd", getSCostDtlCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_param_loc_cd", getSParamLocCd());
		this.hashColumns.put("s_eq_tpsz_cd", getSEqTpszCd());
		this.hashColumns.put("s_from_eq_no", getSFromEqNo());
		this.hashColumns.put("s_range_start", getSRangeStart());
		this.hashColumns.put("s_rcc_cd", getSRccCd());
		this.hashColumns.put("s_dv_amt", getSDvAmt());
		this.hashColumns.put("s_rpr_cnt", getSRprCnt());
		this.hashColumns.put("s_serial", getSSerial());
		this.hashColumns.put("s_eq_no", getSEqNo());
		this.hashColumns.put("s_start_dt", getSStartDt());
		this.hashColumns.put("s_cnt_cd", getSCntCd());
		this.hashColumns.put("s_over_dv_amt", getSOverDvAmt());
		this.hashColumns.put("s_range_end", getSRangeEnd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_no_of_repairs", getSNoOfRepairs());
		this.hashColumns.put("s_yd_cd", getSYdCd());
		this.hashColumns.put("s_end_dt", getSEndDt());
		this.hashColumns.put("s_rcc", getSRcc());
		this.hashColumns.put("s_vndr_seq", getSVndrSeq());
		this.hashColumns.put("s_loc_cd", getSLocCd());
		this.hashColumns.put("s_repair_amt", getSRepairAmt());
		this.hashColumns.put("s_prefix_eq_no", getSPrefixEqNo());
		this.hashColumns.put("s_ownership", getSOwnership());
		this.hashColumns.put("s_to_eq_no", getSToEqNo());
		this.hashColumns.put("s_location_cd", getSLocationCd());
		this.hashColumns.put("s_rpr_amt", getSRprAmt());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("s_cargo_type", getSCargoType());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_cost_dtl_cd", "sCostDtlCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_param_loc_cd", "sParamLocCd");
		this.hashFields.put("s_eq_tpsz_cd", "sEqTpszCd");
		this.hashFields.put("s_from_eq_no", "sFromEqNo");
		this.hashFields.put("s_range_start", "sRangeStart");
		this.hashFields.put("s_rcc_cd", "sRccCd");
		this.hashFields.put("s_dv_amt", "sDvAmt");
		this.hashFields.put("s_rpr_cnt", "sRprCnt");
		this.hashFields.put("s_serial", "sSerial");
		this.hashFields.put("s_eq_no", "sEqNo");
		this.hashFields.put("s_start_dt", "sStartDt");
		this.hashFields.put("s_cnt_cd", "sCntCd");
		this.hashFields.put("s_over_dv_amt", "sOverDvAmt");
		this.hashFields.put("s_range_end", "sRangeEnd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_no_of_repairs", "sNoOfRepairs");
		this.hashFields.put("s_yd_cd", "sYdCd");
		this.hashFields.put("s_end_dt", "sEndDt");
		this.hashFields.put("s_rcc", "sRcc");
		this.hashFields.put("s_vndr_seq", "sVndrSeq");
		this.hashFields.put("s_loc_cd", "sLocCd");
		this.hashFields.put("s_repair_amt", "sRepairAmt");
		this.hashFields.put("s_prefix_eq_no", "sPrefixEqNo");
		this.hashFields.put("s_ownership", "sOwnership");
		this.hashFields.put("s_to_eq_no", "sToEqNo");
		this.hashFields.put("s_location_cd", "sLocationCd");
		this.hashFields.put("s_rpr_amt", "sRprAmt");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("s_cargo_type", "sCargoType");
		return this.hashFields;
	}
	public String getSCostDtlCd() {
		return this.sCostDtlCd;
	}

	public String getIbflag() {
		return this.ibflag;
	}

	public String getSParamLocCd() {
		return this.sParamLocCd;
	}

	public String getSEqTpszCd() {
		return this.sEqTpszCd;
	}

	public String getSFromEqNo() {
		return this.sFromEqNo;
	}

	public String getSRangeStart() {
		return this.sRangeStart;
	}

	public String getSRccCd() {
		return this.sRccCd;
	}

	public String getSDvAmt() {
		return this.sDvAmt;
	}

	public String getSRprCnt() {
		return this.sRprCnt;
	}

	public String getSSerial() {
		return this.sSerial;
	}

	public String getSEqNo() {
		return this.sEqNo;
	}

	public String getSStartDt() {
		return this.sStartDt;
	}

	public String getSCntCd() {
		return this.sCntCd;
	}

	public String getSOverDvAmt() {
		return this.sOverDvAmt;
	}

	public String getSRangeEnd() {
		return this.sRangeEnd;
	}

	public String getPagerows() {
		return this.pagerows;
	}

	public String getSNoOfRepairs() {
		return this.sNoOfRepairs;
	}

	public String getSYdCd() {
		return this.sYdCd;
	}

	public String getSEndDt() {
		return this.sEndDt;
	}

	public String getSRcc() {
		return this.sRcc;
	}

	public String getSVndrSeq() {
		return this.sVndrSeq;
	}

	public String getSLocCd() {
		return this.sLocCd;
	}

	public String getSRepairAmt() {
		return this.sRepairAmt;
	}

	public String getSPrefixEqNo() {
		return this.sPrefixEqNo;
	}

	public String getSOwnership() {
		return this.sOwnership;
	}

	public String getSToEqNo() {
		return this.sToEqNo;
	}

	public String getSLocationCd() {
		return this.sLocationCd;
	}

	public String getSRprAmt() {
		return this.sRprAmt;
	}

	public String getPageNo() {
		return this.pageNo;
	}

	public String getSCargoType() {
		return this.sCargoType;
	}

	public void setSCostDtlCd(String sCostDtlCd) {
		this.sCostDtlCd = sCostDtlCd;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public void setSParamLocCd(String sParamLocCd) {
		this.sParamLocCd = sParamLocCd;
	}

	public void setSEqTpszCd(String sEqTpszCd) {
		this.sEqTpszCd = sEqTpszCd;
	}

	public void setSFromEqNo(String sFromEqNo) {
		this.sFromEqNo = sFromEqNo;
	}

	public void setSRangeStart(String sRangeStart) {
		this.sRangeStart = sRangeStart;
	}

	public void setSRccCd(String sRccCd) {
		this.sRccCd = sRccCd;
	}

	public void setSDvAmt(String sDvAmt) {
		this.sDvAmt = sDvAmt;
	}

	public void setSRprCnt(String sRprCnt) {
		this.sRprCnt = sRprCnt;
	}

	public void setSSerial(String sSerial) {
		this.sSerial = sSerial;
	}

	public void setSEqNo(String sEqNo) {
		this.sEqNo = sEqNo;
	}

	public void setSStartDt(String sStartDt) {
		this.sStartDt = sStartDt;
	}

	public void setSCntCd(String sCntCd) {
		this.sCntCd = sCntCd;
	}

	public void setSOverDvAmt(String sOverDvAmt) {
		this.sOverDvAmt = sOverDvAmt;
	}

	public void setSRangeEnd(String sRangeEnd) {
		this.sRangeEnd = sRangeEnd;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public void setSNoOfRepairs(String sNoOfRepairs) {
		this.sNoOfRepairs = sNoOfRepairs;
	}

	public void setSYdCd(String sYdCd) {
		this.sYdCd = sYdCd;
	}

	public void setSEndDt(String sEndDt) {
		this.sEndDt = sEndDt;
	}

	public void setSRcc(String sRcc) {
		this.sRcc = sRcc;
	}

	public void setSVndrSeq(String sVndrSeq) {
		this.sVndrSeq = sVndrSeq;
	}

	public void setSLocCd(String sLocCd) {
		this.sLocCd = sLocCd;
	}

	public void setSRepairAmt(String sRepairAmt) {
		this.sRepairAmt = sRepairAmt;
	}

	public void setSPrefixEqNo(String sPrefixEqNo) {
		this.sPrefixEqNo = sPrefixEqNo;
	}

	public void setSOwnership(String sOwnership) {
		this.sOwnership = sOwnership;
	}

	public void setSToEqNo(String sToEqNo) {
		this.sToEqNo = sToEqNo;
	}

	public void setSLocationCd(String sLocationCd) {
		this.sLocationCd = sLocationCd;
	}

	public void setSRprAmt(String sRprAmt) {
		this.sRprAmt = sRprAmt;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public void setSCargoType(String sCargoType) {
		this.sCargoType = sCargoType;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setSCostDtlCd(JSPUtil.getParameter(request, prefix + "s_cost_dtl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSParamLocCd(JSPUtil.getParameter(request, prefix + "s_param_loc_cd", ""));
		setSEqTpszCd(JSPUtil.getParameter(request, prefix + "s_eq_tpsz_cd", ""));
		setSFromEqNo(JSPUtil.getParameter(request, prefix + "s_from_eq_no", ""));
		setSRangeStart(JSPUtil.getParameter(request, prefix + "s_range_start", ""));
		setSRccCd(JSPUtil.getParameter(request, prefix + "s_rcc_cd", ""));
		setSDvAmt(JSPUtil.getParameter(request, prefix + "s_dv_amt", ""));
		setSRprCnt(JSPUtil.getParameter(request, prefix + "s_rpr_cnt", ""));
		setSSerial(JSPUtil.getParameter(request, prefix + "s_serial", ""));
		setSEqNo(JSPUtil.getParameter(request, prefix + "s_eq_no", ""));
		setSStartDt(JSPUtil.getParameter(request, prefix + "s_start_dt", ""));
		setSCntCd(JSPUtil.getParameter(request, prefix + "s_cnt_cd", ""));
		setSOverDvAmt(JSPUtil.getParameter(request, prefix + "s_over_dv_amt", ""));
		setSRangeEnd(JSPUtil.getParameter(request, prefix + "s_range_end", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSNoOfRepairs(JSPUtil.getParameter(request, prefix + "s_no_of_repairs", ""));
		setSYdCd(JSPUtil.getParameter(request, prefix + "s_yd_cd", ""));
		setSEndDt(JSPUtil.getParameter(request, prefix + "s_end_dt", ""));
		setSRcc(JSPUtil.getParameter(request, prefix + "s_rcc", ""));
		setSVndrSeq(JSPUtil.getParameter(request, prefix + "s_vndr_seq", ""));
		setSLocCd(JSPUtil.getParameter(request, prefix + "s_loc_cd", ""));
		setSRepairAmt(JSPUtil.getParameter(request, prefix + "s_repair_amt", ""));
		setSPrefixEqNo(JSPUtil.getParameter(request, prefix + "s_prefix_eq_no", ""));
		setSOwnership(JSPUtil.getParameter(request, prefix + "s_ownership", ""));
		setSToEqNo(JSPUtil.getParameter(request, prefix + "s_to_eq_no", ""));
		setSLocationCd(JSPUtil.getParameter(request, prefix + "s_location_cd", ""));
		setSRprAmt(JSPUtil.getParameter(request, prefix + "s_rpr_amt", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setSCargoType(JSPUtil.getParameter(request, prefix + "s_cargo_type", ""));
	}

	public MnrReportINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public MnrReportINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MnrReportINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] sCostDtlCd = (JSPUtil.getParameter(request, prefix	+ "s_cost_dtl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sParamLocCd = (JSPUtil.getParameter(request, prefix	+ "s_param_loc_cd", length));
			String[] sEqTpszCd = (JSPUtil.getParameter(request, prefix	+ "s_eq_tpsz_cd", length));
			String[] sFromEqNo = (JSPUtil.getParameter(request, prefix	+ "s_from_eq_no", length));
			String[] sRangeStart = (JSPUtil.getParameter(request, prefix	+ "s_range_start", length));
			String[] sRccCd = (JSPUtil.getParameter(request, prefix	+ "s_rcc_cd", length));
			String[] sDvAmt = (JSPUtil.getParameter(request, prefix	+ "s_dv_amt", length));
			String[] sRprCnt = (JSPUtil.getParameter(request, prefix	+ "s_rpr_cnt", length));
			String[] sSerial = (JSPUtil.getParameter(request, prefix	+ "s_serial", length));
			String[] sEqNo = (JSPUtil.getParameter(request, prefix	+ "s_eq_no", length));
			String[] sStartDt = (JSPUtil.getParameter(request, prefix	+ "s_start_dt", length));
			String[] sCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cnt_cd", length));
			String[] sOverDvAmt = (JSPUtil.getParameter(request, prefix	+ "s_over_dv_amt", length));
			String[] sRangeEnd = (JSPUtil.getParameter(request, prefix	+ "s_range_end", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sNoOfRepairs = (JSPUtil.getParameter(request, prefix	+ "s_no_of_repairs", length));
			String[] sYdCd = (JSPUtil.getParameter(request, prefix	+ "s_yd_cd", length));
			String[] sEndDt = (JSPUtil.getParameter(request, prefix	+ "s_end_dt", length));
			String[] sRcc = (JSPUtil.getParameter(request, prefix	+ "s_rcc", length));
			String[] sVndrSeq = (JSPUtil.getParameter(request, prefix	+ "s_vndr_seq", length));
			String[] sLocCd = (JSPUtil.getParameter(request, prefix	+ "s_loc_cd", length));
			String[] sRepairAmt = (JSPUtil.getParameter(request, prefix	+ "s_repair_amt", length));
			String[] sPrefixEqNo = (JSPUtil.getParameter(request, prefix	+ "s_prefix_eq_no", length));
			String[] sOwnership = (JSPUtil.getParameter(request, prefix	+ "s_ownership", length));
			String[] sToEqNo = (JSPUtil.getParameter(request, prefix	+ "s_to_eq_no", length));
			String[] sLocationCd = (JSPUtil.getParameter(request, prefix	+ "s_location_cd", length));
			String[] sRprAmt = (JSPUtil.getParameter(request, prefix	+ "s_rpr_amt", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] sCargoType = (JSPUtil.getParameter(request, prefix	+ "s_cargo_type", length));
			for (int i = 0; i < length; i++) {
				model = new MnrReportINVO();
				if (sCostDtlCd[i] != null)
					model.setSCostDtlCd(sCostDtlCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sParamLocCd[i] != null)
					model.setSParamLocCd(sParamLocCd[i]);
				if (sEqTpszCd[i] != null)
					model.setSEqTpszCd(sEqTpszCd[i]);
				if (sFromEqNo[i] != null)
					model.setSFromEqNo(sFromEqNo[i]);
				if (sRangeStart[i] != null)
					model.setSRangeStart(sRangeStart[i]);
				if (sRccCd[i] != null)
					model.setSRccCd(sRccCd[i]);
				if (sDvAmt[i] != null)
					model.setSDvAmt(sDvAmt[i]);
				if (sRprCnt[i] != null)
					model.setSRprCnt(sRprCnt[i]);
				if (sSerial[i] != null)
					model.setSSerial(sSerial[i]);
				if (sEqNo[i] != null)
					model.setSEqNo(sEqNo[i]);
				if (sStartDt[i] != null)
					model.setSStartDt(sStartDt[i]);
				if (sCntCd[i] != null)
					model.setSCntCd(sCntCd[i]);
				if (sOverDvAmt[i] != null)
					model.setSOverDvAmt(sOverDvAmt[i]);
				if (sRangeEnd[i] != null)
					model.setSRangeEnd(sRangeEnd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sNoOfRepairs[i] != null)
					model.setSNoOfRepairs(sNoOfRepairs[i]);
				if (sYdCd[i] != null)
					model.setSYdCd(sYdCd[i]);
				if (sEndDt[i] != null)
					model.setSEndDt(sEndDt[i]);
				if (sRcc[i] != null)
					model.setSRcc(sRcc[i]);
				if (sVndrSeq[i] != null)
					model.setSVndrSeq(sVndrSeq[i]);
				if (sLocCd[i] != null)
					model.setSLocCd(sLocCd[i]);
				if (sRepairAmt[i] != null)
					model.setSRepairAmt(sRepairAmt[i]);
				if (sPrefixEqNo[i] != null)
					model.setSPrefixEqNo(sPrefixEqNo[i]);
				if (sOwnership[i] != null)
					model.setSOwnership(sOwnership[i]);
				if (sToEqNo[i] != null)
					model.setSToEqNo(sToEqNo[i]);
				if (sLocationCd[i] != null)
					model.setSLocationCd(sLocationCd[i]);
				if (sRprAmt[i] != null)
					model.setSRprAmt(sRprAmt[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (sCargoType[i] != null)
					model.setSCargoType(sCargoType[i]);
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getMnrReportINVOs();
	}

	public MnrReportINVO[] getMnrReportINVOs(){
		MnrReportINVO[] vos = (MnrReportINVO[])models.toArray(new MnrReportINVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.sCostDtlCd = this.sCostDtlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sParamLocCd = this.sParamLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqTpszCd = this.sEqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFromEqNo = this.sFromEqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRangeStart = this.sRangeStart.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRccCd = this.sRccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDvAmt = this.sDvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRprCnt = this.sRprCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSerial = this.sSerial.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqNo = this.sEqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sStartDt = this.sStartDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntCd = this.sCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOverDvAmt = this.sOverDvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRangeEnd = this.sRangeEnd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNoOfRepairs = this.sNoOfRepairs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sYdCd = this.sYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEndDt = this.sEndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRcc = this.sRcc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrSeq = this.sVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLocCd = this.sLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRepairAmt = this.sRepairAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPrefixEqNo = this.sPrefixEqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOwnership = this.sOwnership.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToEqNo = this.sToEqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLocationCd = this.sLocationCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRprAmt = this.sRprAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCargoType = this.sCargoType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}