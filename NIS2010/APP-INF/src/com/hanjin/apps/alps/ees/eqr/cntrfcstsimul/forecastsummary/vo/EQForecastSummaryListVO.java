package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

public class EQForecastSummaryListVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<EQForecastSummaryListVO> models = new ArrayList<EQForecastSummaryListVO>();
	private String rccCd = null;
	private String division = null;
	private String cntrTpszCd = null;
	private String ivW0 = null;
	private String ivW1 = null;
	private String ivW2 = null;
	private String ivW3 = null;
	private String ivAvg = null;
	private String opW0 = null;
	private String opW1 = null;
	private String opW2 = null;
	private String opW3 = null;
	private String opAvg = null;
	private String optVol = null;
	private String prW0 = null;
	private String prW1 = null;
	private String prW2 = null;
	private String prW3 = null;
	private String prAvg = null;
	private String stkIcrzFlg = null;
	private String stkDcrzFlg = null;
	private String srosSplsFlg = null;
	private String normSplsFlg = null;
	private String srosShtgFlg = null;
	private String normShtgFlg = null;
	private String balFlg      = null;
	
	private String mbValue = null;
	private String mbStatus = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public EQForecastSummaryListVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("division", getDivision());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("iv_w0", getIvW0());
		this.hashColumns.put("iv_w1", getIvW1());
		this.hashColumns.put("iv_w2", getIvW2());
		this.hashColumns.put("iv_w3", getIvW3());
		this.hashColumns.put("iv_avg", getIvAvg());
		this.hashColumns.put("op_w0", getOpW0());
		this.hashColumns.put("op_w1", getOpW1());
		this.hashColumns.put("op_w2", getOpW2());
		this.hashColumns.put("op_w3", getOpW3());
		this.hashColumns.put("op_avg", getOpAvg());
		this.hashColumns.put("opt_vol", getOptVol());
		this.hashColumns.put("pr_w0", getPrW0());
		this.hashColumns.put("pr_w1", getPrW1());
		this.hashColumns.put("pr_w2", getPrW2());
		this.hashColumns.put("pr_w3", getPrW3());
		this.hashColumns.put("pr_avg", getPrAvg());
		this.hashColumns.put("stk_icrz_flg", getStkIcrzFlg());
		this.hashColumns.put("stk_dcrz_flg", getStkDcrzFlg());
		this.hashColumns.put("sros_spls_flg", getSrosSplsFlg());
		this.hashColumns.put("norm_spls_flg", getNormSplsFlg());
		this.hashColumns.put("sros_shtg_flg", getSrosShtgFlg());
		this.hashColumns.put("norm_shtg_flg", getNormShtgFlg());
		this.hashColumns.put("bal_flg", getBalFlg());
		this.hashColumns.put("mb_value",  getMbValue());
		this.hashColumns.put("mb_status", getMbStatus());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("division", "division");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("iv_w0", "ivW0");
		this.hashFields.put("iv_w1", "ivW1");
		this.hashFields.put("iv_w2", "ivW2");
		this.hashFields.put("iv_w3", "ivW3");
		this.hashFields.put("iv_avg", "ivAvg");
		this.hashFields.put("op_w0", "opW0");
		this.hashFields.put("op_w1", "opW1");
		this.hashFields.put("op_w2", "opW2");
		this.hashFields.put("op_w3", "opW3");
		this.hashFields.put("op_avg", "opAvg");
		this.hashFields.put("opt_vol", "optVol");
		this.hashFields.put("pr_w0", "prW0");
		this.hashFields.put("pr_w1", "prW1");
		this.hashFields.put("pr_w2", "prW2");
		this.hashFields.put("pr_w3", "prW3");
		this.hashFields.put("pr_avg", "prAvg");
		this.hashFields.put("stk_icrz_flg", "stkIcrzFlg");
		this.hashFields.put("stk_dcrz_flg", "stkDcrzFlg");
		this.hashFields.put("sros_spls_flg", "srosSplsFlg");
		this.hashFields.put("norm_spls_flg", "normSplsFlg");
		this.hashFields.put("sros_shtg_flg", "srosShtgFlg");
		this.hashFields.put("norm_shtg_flg", "normShtgFlg");
		this.hashFields.put("bal_flg",       "balFlg");
		this.hashFields.put("mb_value", "mbValue");
		this.hashFields.put("mb_status", "mbStatus");
		return this.hashFields;
	}
	public String getRccCd() {
		return this.rccCd;
	}

	public String getDivision() {
		return this.division;
	}

	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	public String getIvW0() {
		return this.ivW0;
	}

	public String getIvW1() {
		return this.ivW1;
	}

	public String getIvW2() {
		return this.ivW2;
	}

	public String getIvW3() {
		return this.ivW3;
	}

	public String getIvAvg() {
		return this.ivAvg;
	}

	public String getOpW0() {
		return this.opW0;
	}

	public String getOpW1() {
		return this.opW1;
	}

	public String getOpW2() {
		return this.opW2;
	}

	public String getOpW3() {
		return this.opW3;
	}

	public String getOpAvg() {
		return this.opAvg;
	}

	public String getPrW0() {
		return this.prW0;
	}

	public String getPrW1() {
		return this.prW1;
	}

	public String getPrW2() {
		return this.prW2;
	}

	public String getPrW3() {
		return this.prW3;
	}

	public String getPrAvg() {
		return this.prAvg;
	}

	public String getStkIcrzFlg() {
		return this.stkIcrzFlg;
	}

	public String getStkDcrzFlg() {
		return this.stkDcrzFlg;
	}

	public String getSrosSplsFlg() {
		return this.srosSplsFlg;
	}

	public String getNormSplsFlg() {
		return this.normSplsFlg;
	}

	public String getSrosShtgFlg() {
		return this.srosShtgFlg;
	}

	public String getNormShtgFlg() {
		return this.normShtgFlg;
	}

	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	public void setIvW0(String ivW0) {
		this.ivW0 = ivW0;
	}

	public void setIvW1(String ivW1) {
		this.ivW1 = ivW1;
	}

	public void setIvW2(String ivW2) {
		this.ivW2 = ivW2;
	}

	public void setIvW3(String ivW3) {
		this.ivW3 = ivW3;
	}

	public void setIvAvg(String ivAvg) {
		this.ivAvg = ivAvg;
	}

	public void setOpW0(String opW0) {
		this.opW0 = opW0;
	}

	public void setOpW1(String opW1) {
		this.opW1 = opW1;
	}

	public void setOpW2(String opW2) {
		this.opW2 = opW2;
	}

	public void setOpW3(String opW3) {
		this.opW3 = opW3;
	}

	public void setOpAvg(String opAvg) {
		this.opAvg = opAvg;
	}

	public void setPrW0(String prW0) {
		this.prW0 = prW0;
	}

	public void setPrW1(String prW1) {
		this.prW1 = prW1;
	}

	public void setPrW2(String prW2) {
		this.prW2 = prW2;
	}

	public void setPrW3(String prW3) {
		this.prW3 = prW3;
	}

	public void setPrAvg(String prAvg) {
		this.prAvg = prAvg;
	}

	public void setStkIcrzFlg(String stkIcrzFlg) {
		this.stkIcrzFlg = stkIcrzFlg;
	}

	public void setStkDcrzFlg(String stkDcrzFlg) {
		this.stkDcrzFlg = stkDcrzFlg;
	}

	public void setSrosSplsFlg(String srosSplsFlg) {
		this.srosSplsFlg = srosSplsFlg;
	}

	public void setNormSplsFlg(String normSplsFlg) {
		this.normSplsFlg = normSplsFlg;
	}

	public void setSrosShtgFlg(String srosShtgFlg) {
		this.srosShtgFlg = srosShtgFlg;
	}

	public void setNormShtgFlg(String normShtgFlg) {
		this.normShtgFlg = normShtgFlg;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setDivision(JSPUtil.getParameter(request, prefix + "division", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setIvW0(JSPUtil.getParameter(request, prefix + "iv_w0", ""));
		setIvW1(JSPUtil.getParameter(request, prefix + "iv_w1", ""));
		setIvW2(JSPUtil.getParameter(request, prefix + "iv_w2", ""));
		setIvW3(JSPUtil.getParameter(request, prefix + "iv_w3", ""));
		setIvAvg(JSPUtil.getParameter(request, prefix + "iv_avg", ""));
		setOpW0(JSPUtil.getParameter(request, prefix + "op_w0", ""));
		setOpW1(JSPUtil.getParameter(request, prefix + "op_w1", ""));
		setOpW2(JSPUtil.getParameter(request, prefix + "op_w2", ""));
		setOpW3(JSPUtil.getParameter(request, prefix + "op_w3", ""));
		setOpAvg(JSPUtil.getParameter(request, prefix + "op_avg", ""));
		setOptVol(JSPUtil.getParameter(request, prefix + "opt_vol", ""));
		setPrW0(JSPUtil.getParameter(request, prefix + "pr_w0", ""));
		setPrW1(JSPUtil.getParameter(request, prefix + "pr_w1", ""));
		setPrW2(JSPUtil.getParameter(request, prefix + "pr_w2", ""));
		setPrW3(JSPUtil.getParameter(request, prefix + "pr_w3", ""));
		setPrAvg(JSPUtil.getParameter(request, prefix + "pr_avg", ""));
		setStkIcrzFlg(JSPUtil.getParameter(request, prefix + "stk_icrz_flg", ""));
		setStkDcrzFlg(JSPUtil.getParameter(request, prefix + "stk_dcrz_flg", ""));
		setSrosSplsFlg(JSPUtil.getParameter(request, prefix + "sros_spls_flg", ""));
		setNormSplsFlg(JSPUtil.getParameter(request, prefix + "norm_spls_flg", ""));
		setSrosShtgFlg(JSPUtil.getParameter(request, prefix + "sros_shtg_flg", ""));
		setNormShtgFlg(JSPUtil.getParameter(request, prefix + "norm_shtg_flg", ""));
		setBalFlg(JSPUtil.getParameter(request, prefix + "bal_flg", ""));
		setMbValue(JSPUtil.getParameter(request, prefix + "mb_value", ""));
		setMbStatus(JSPUtil.getParameter(request, prefix + "mb_status", ""));
	}

	public EQForecastSummaryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public EQForecastSummaryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EQForecastSummaryListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] division = (JSPUtil.getParameter(request, prefix	+ "division", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] ivW0 = (JSPUtil.getParameter(request, prefix	+ "iv_w0", length));
			String[] ivW1 = (JSPUtil.getParameter(request, prefix	+ "iv_w1", length));
			String[] ivW2 = (JSPUtil.getParameter(request, prefix	+ "iv_w2", length));
			String[] ivW3 = (JSPUtil.getParameter(request, prefix	+ "iv_w3", length));
			String[] ivAvg = (JSPUtil.getParameter(request, prefix	+ "iv_avg", length));
			String[] opW0 = (JSPUtil.getParameter(request, prefix	+ "op_w0", length));
			String[] opW1 = (JSPUtil.getParameter(request, prefix	+ "op_w1", length));
			String[] opW2 = (JSPUtil.getParameter(request, prefix	+ "op_w2", length));
			String[] opW3 = (JSPUtil.getParameter(request, prefix	+ "op_w3", length));
			String[] opAvg = (JSPUtil.getParameter(request, prefix	+ "op_avg", length));
			String[] optVol = (JSPUtil.getParameter(request, prefix	+ "opt_vol", length));
			String[] prW0 = (JSPUtil.getParameter(request, prefix	+ "pr_w0", length));
			String[] prW1 = (JSPUtil.getParameter(request, prefix	+ "pr_w1", length));
			String[] prW2 = (JSPUtil.getParameter(request, prefix	+ "pr_w2", length));
			String[] prW3 = (JSPUtil.getParameter(request, prefix	+ "pr_w3", length));
			String[] prAvg = (JSPUtil.getParameter(request, prefix	+ "pr_avg", length));
			String[] stkIcrzFlg = (JSPUtil.getParameter(request, prefix	+ "stk_icrz_flg", length));
			String[] stkDcrzFlg = (JSPUtil.getParameter(request, prefix	+ "stk_dcrz_flg", length));
			String[] srosSplsFlg = (JSPUtil.getParameter(request, prefix	+ "sros_spls_flg", length));
			String[] normSplsFlg = (JSPUtil.getParameter(request, prefix	+ "norm_spls_flg", length));
			String[] srosShtgFlg = (JSPUtil.getParameter(request, prefix	+ "sros_shtg_flg", length));
			String[] normShtgFlg = (JSPUtil.getParameter(request, prefix	+ "norm_shtg_flg", length));
			String[] balFlg = (JSPUtil.getParameter(request, prefix	+ "bal_flg", length));
			String[] mbValue  = (JSPUtil.getParameter(request, prefix	+ "mb_value", length));
			String[] mbStatus = (JSPUtil.getParameter(request, prefix	+ "mb_status", length));
			for (int i = 0; i < length; i++) {
				model = new EQForecastSummaryListVO();
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (division[i] != null)
					model.setDivision(division[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (ivW0[i] != null)
					model.setIvW0(ivW0[i]);
				if (ivW1[i] != null)
					model.setIvW1(ivW1[i]);
				if (ivW2[i] != null)
					model.setIvW2(ivW2[i]);
				if (ivW3[i] != null)
					model.setIvW3(ivW3[i]);
				if (ivAvg[i] != null)
					model.setIvAvg(ivAvg[i]);
				if (opW0[i] != null)
					model.setOpW0(opW0[i]);
				if (opW1[i] != null)
					model.setOpW1(opW1[i]);
				if (opW2[i] != null)
					model.setOpW2(opW2[i]);
				if (opW3[i] != null)
					model.setOpW3(opW3[i]);
				if (opAvg[i] != null)
					model.setOpAvg(opAvg[i]);
				if (optVol[i] != null)
					model.setOptVol(optVol[i]);				
				if (prW0[i] != null)
					model.setPrW0(prW0[i]);
				if (prW1[i] != null)
					model.setPrW1(prW1[i]);
				if (prW2[i] != null)
					model.setPrW2(prW2[i]);
				if (prW3[i] != null)
					model.setPrW3(prW3[i]);
				if (prAvg[i] != null)
					model.setPrAvg(prAvg[i]);
				if (stkIcrzFlg[i] != null)
					model.setStkIcrzFlg(stkIcrzFlg[i]);
				if (stkDcrzFlg[i] != null)
					model.setStkDcrzFlg(stkDcrzFlg[i]);
				if (srosSplsFlg[i] != null)
					model.setSrosSplsFlg(srosSplsFlg[i]);
				if (normSplsFlg[i] != null)
					model.setNormSplsFlg(normSplsFlg[i]);
				if (srosShtgFlg[i] != null)
					model.setSrosShtgFlg(srosShtgFlg[i]);
				if (normShtgFlg[i] != null)
					model.setNormShtgFlg(normShtgFlg[i]);
				if (balFlg[i] != null)
					model.setBalFlg(balFlg[i]);				
				if (mbValue[i] != null)
					model.setMbValue(mbValue[i]);
				if (mbStatus[i] != null)
					model.setMbStatus(mbStatus[i]);				
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getEQForecastSummaryListVOs();
	}

	public EQForecastSummaryListVO[] getEQForecastSummaryListVOs(){
		EQForecastSummaryListVO[] vos = (EQForecastSummaryListVO[])models.toArray(new EQForecastSummaryListVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.rccCd = this.rccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.division = this.division.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ivW0 = this.ivW0.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ivW1 = this.ivW1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ivW2 = this.ivW2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ivW3 = this.ivW3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ivAvg = this.ivAvg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opW0 = this.opW0.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opW1 = this.opW1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opW2 = this.opW2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opW3 = this.opW3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opAvg = this.opAvg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optVol = this.optVol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prW0 = this.prW0.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prW1 = this.prW1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prW2 = this.prW2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prW3 = this.prW3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prAvg = this.prAvg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkIcrzFlg = this.stkIcrzFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkDcrzFlg = this.stkDcrzFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srosSplsFlg = this.srosSplsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.normSplsFlg = this.normSplsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srosShtgFlg = this.srosShtgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.normShtgFlg = this.normShtgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balFlg = this.balFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mbValue = this.mbValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mbStatus = this.mbStatus.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getOptVol() {
		return optVol;
	}

	public void setOptVol(String optVol) {
		this.optVol = optVol;
	}

	public String getMbValue() {
		return mbValue;
	}

	public void setMbValue(String mbValue) {
		this.mbValue = mbValue;
	}

	public String getMbStatus() {
		return mbStatus;
	}

	public void setMbStatus(String mbStatus) {
		this.mbStatus = mbStatus;
	}

	public String getBalFlg() {
		return balFlg;
	}

	public void setBalFlg(String balFlg) {
		this.balFlg = balFlg;
	}
}