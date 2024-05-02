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

public class MnrChargeDetailListVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<MnrChargeDetailListVO> models = new ArrayList<MnrChargeDetailListVO>();
	private String ibflag = null;
	private String mnrOrdOfcCtyCd = null;
	private String costAmt = null;
	private String costCdNm = null;
	private String agmtNo = null;
	private String woOfcCd = null;
	private String woNo = null;
	private String costCd = null;
	private String invOfcCd = null;
	private String woCurrCd = null;
	private String trfNo = null;
	private String chgWoAmt = null;
	private String sprPrtUcAmt = null;
	private String eacNo = null;
	private String eqKndCdNm = null;
	private String estVrfyYn = null;
	private String bzcAmt = null;
	private String pagerows = null;
	private String mnrOrdSeq = null;
	private String eqNo = null;
	private String invAmt = null;
	private String invNo = null;
	private String invCurrCd = null;
	private String agmtOfcCd = null;
	private String eqKndCd = null;
	private String vndrSeq = null;
	private String wkVrfyDesc = null;
	private String cfmDt = null;
	private String rhqInvOfcCd = null;
	private String estYn = null;
	private String woYn = null;
	private String invUsdAmt = null;
	private String invDiffPct = null;
	private String trfAmt = null;
	private String eqTpszCd = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public MnrChargeDetailListVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());
		this.hashColumns.put("cost_amt", getCostAmt());
		this.hashColumns.put("cost_cd_nm", getCostCdNm());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("wo_ofc_cd", getWoOfcCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("wo_curr_cd", getWoCurrCd());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("chg_wo_amt", getChgWoAmt());
		this.hashColumns.put("spr_prt_uc_amt", getSprPrtUcAmt());
		this.hashColumns.put("eac_no", getEacNo());
		this.hashColumns.put("eq_knd_cd_nm", getEqKndCdNm());
		this.hashColumns.put("est_vrfy_yn", getEstVrfyYn());
		this.hashColumns.put("bzc_amt", getBzcAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("agmt_ofc_cd", getAgmtOfcCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("wk_vrfy_desc", getWkVrfyDesc());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("rhq_inv_ofc_cd", getRhqInvOfcCd());
		this.hashColumns.put("est_yn", getEstYn());
		this.hashColumns.put("wo_yn", getWoYn());
		this.hashColumns.put("inv_usd_amt", getInvUsdAmt());
		this.hashColumns.put("inv_diff_pct", getInvDiffPct());
		this.hashColumns.put("trf_amt", getTrfAmt());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_ord_ofc_cty_cd", "mnrOrdOfcCtyCd");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("cost_cd_nm", "costCdNm");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("wo_ofc_cd", "woOfcCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("wo_curr_cd", "woCurrCd");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("chg_wo_amt", "chgWoAmt");
		this.hashFields.put("spr_prt_uc_amt", "sprPrtUcAmt");
		this.hashFields.put("eac_no", "eacNo");
		this.hashFields.put("eq_knd_cd_nm", "eqKndCdNm");
		this.hashFields.put("est_vrfy_yn", "estVrfyYn");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("agmt_ofc_cd", "agmtOfcCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("wk_vrfy_desc", "wkVrfyDesc");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("rhq_inv_ofc_cd", "rhqInvOfcCd");
		this.hashFields.put("est_yn", "estYn");
		this.hashFields.put("wo_yn", "woYn");
		this.hashFields.put("inv_usd_amt", "invUsdAmt");
		this.hashFields.put("inv_diff_pct", "invDiffPct");
		this.hashFields.put("trf_amt", "trfAmt");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		return this.hashFields;
	}
	public String getIbflag() {
		return this.ibflag;
	}

	public String getMnrOrdOfcCtyCd() {
		return this.mnrOrdOfcCtyCd;
	}

	public String getCostAmt() {
		return this.costAmt;
	}

	public String getCostCdNm() {
		return this.costCdNm;
	}

	public String getAgmtNo() {
		return this.agmtNo;
	}

	public String getWoOfcCd() {
		return this.woOfcCd;
	}

	public String getWoNo() {
		return this.woNo;
	}

	public String getCostCd() {
		return this.costCd;
	}

	public String getInvOfcCd() {
		return this.invOfcCd;
	}

	public String getWoCurrCd() {
		return this.woCurrCd;
	}

	public String getTrfNo() {
		return this.trfNo;
	}

	public String getChgWoAmt() {
		return this.chgWoAmt;
	}

	public String getSprPrtUcAmt() {
		return this.sprPrtUcAmt;
	}

	public String getEacNo() {
		return this.eacNo;
	}

	public String getEqKndCdNm() {
		return this.eqKndCdNm;
	}

	public String getEstVrfyYn() {
		return this.estVrfyYn;
	}

	public String getBzcAmt() {
		return this.bzcAmt;
	}

	public String getPagerows() {
		return this.pagerows;
	}

	public String getMnrOrdSeq() {
		return this.mnrOrdSeq;
	}

	public String getEqNo() {
		return this.eqNo;
	}

	public String getInvAmt() {
		return this.invAmt;
	}

	public String getInvNo() {
		return this.invNo;
	}

	public String getInvCurrCd() {
		return this.invCurrCd;
	}

	public String getAgmtOfcCd() {
		return this.agmtOfcCd;
	}

	public String getEqKndCd() {
		return this.eqKndCd;
	}

	public String getVndrSeq() {
		return this.vndrSeq;
	}

	public String getWkVrfyDesc() {
		return this.wkVrfyDesc;
	}

	public String getCfmDt() {
		return this.cfmDt;
	}

	public String getRhqInvOfcCd() {
		return this.rhqInvOfcCd;
	}

	public String getEstYn() {
		return this.estYn;
	}

	public String getWoYn() {
		return this.woYn;
	}

	public String getInvUsdAmt() {
		return this.invUsdAmt;
	}

	public String getInvDiffPct() {
		return this.invDiffPct;
	}

	public String getTrfAmt() {
		return this.trfAmt;
	}

	public String getEqTpszCd() {
		return this.eqTpszCd;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public void setMnrOrdOfcCtyCd(String mnrOrdOfcCtyCd) {
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
	}

	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
	}

	public void setCostCdNm(String costCdNm) {
		this.costCdNm = costCdNm;
	}

	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	public void setWoOfcCd(String woOfcCd) {
		this.woOfcCd = woOfcCd;
	}

	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}

	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}

	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}

	public void setWoCurrCd(String woCurrCd) {
		this.woCurrCd = woCurrCd;
	}

	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}

	public void setChgWoAmt(String chgWoAmt) {
		this.chgWoAmt = chgWoAmt;
	}

	public void setSprPrtUcAmt(String sprPrtUcAmt) {
		this.sprPrtUcAmt = sprPrtUcAmt;
	}

	public void setEacNo(String eacNo) {
		this.eacNo = eacNo;
	}

	public void setEqKndCdNm(String eqKndCdNm) {
		this.eqKndCdNm = eqKndCdNm;
	}

	public void setEstVrfyYn(String estVrfyYn) {
		this.estVrfyYn = estVrfyYn;
	}

	public void setBzcAmt(String bzcAmt) {
		this.bzcAmt = bzcAmt;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public void setMnrOrdSeq(String mnrOrdSeq) {
		this.mnrOrdSeq = mnrOrdSeq;
	}

	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}

	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}

	public void setAgmtOfcCd(String agmtOfcCd) {
		this.agmtOfcCd = agmtOfcCd;
	}

	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public void setWkVrfyDesc(String wkVrfyDesc) {
		this.wkVrfyDesc = wkVrfyDesc;
	}

	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
	}

	public void setRhqInvOfcCd(String rhqInvOfcCd) {
		this.rhqInvOfcCd = rhqInvOfcCd;
	}

	public void setEstYn(String estYn) {
		this.estYn = estYn;
	}

	public void setWoYn(String woYn) {
		this.woYn = woYn;
	}

	public void setInvUsdAmt(String invUsdAmt) {
		this.invUsdAmt = invUsdAmt;
	}

	public void setInvDiffPct(String invDiffPct) {
		this.invDiffPct = invDiffPct;
	}

	public void setTrfAmt(String trfAmt) {
		this.trfAmt = trfAmt;
	}

	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMnrOrdOfcCtyCd(JSPUtil.getParameter(request, prefix + "mnr_ord_ofc_cty_cd", ""));
		setCostAmt(JSPUtil.getParameter(request, prefix + "cost_amt", ""));
		setCostCdNm(JSPUtil.getParameter(request, prefix + "cost_cd_nm", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setWoOfcCd(JSPUtil.getParameter(request, prefix + "wo_ofc_cd", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setWoCurrCd(JSPUtil.getParameter(request, prefix + "wo_curr_cd", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setChgWoAmt(JSPUtil.getParameter(request, prefix + "chg_wo_amt", ""));
		setSprPrtUcAmt(JSPUtil.getParameter(request, prefix + "spr_prt_uc_amt", ""));
		setEacNo(JSPUtil.getParameter(request, prefix + "eac_no", ""));
		setEqKndCdNm(JSPUtil.getParameter(request, prefix + "eq_knd_cd_nm", ""));
		setEstVrfyYn(JSPUtil.getParameter(request, prefix + "est_vrfy_yn", ""));
		setBzcAmt(JSPUtil.getParameter(request, prefix + "bzc_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, prefix + "mnr_ord_seq", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setAgmtOfcCd(JSPUtil.getParameter(request, prefix + "agmt_ofc_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setWkVrfyDesc(JSPUtil.getParameter(request, prefix + "wk_vrfy_desc", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setRhqInvOfcCd(JSPUtil.getParameter(request, prefix + "rhq_inv_ofc_cd", ""));
		setEstYn(JSPUtil.getParameter(request, prefix + "est_yn", ""));
		setWoYn(JSPUtil.getParameter(request, prefix + "wo_yn", ""));
		setInvUsdAmt(JSPUtil.getParameter(request, prefix + "inv_usd_amt", ""));
		setInvDiffPct(JSPUtil.getParameter(request, prefix + "inv_diff_pct", ""));
		setTrfAmt(JSPUtil.getParameter(request, prefix + "trf_amt", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
	}

	public MnrChargeDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public MnrChargeDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MnrChargeDetailListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrOrdOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_ofc_cty_cd", length));
			String[] costAmt = (JSPUtil.getParameter(request, prefix	+ "cost_amt", length));
			String[] costCdNm = (JSPUtil.getParameter(request, prefix	+ "cost_cd_nm", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] woOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_ofc_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] woCurrCd = (JSPUtil.getParameter(request, prefix	+ "wo_curr_cd", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] chgWoAmt = (JSPUtil.getParameter(request, prefix	+ "chg_wo_amt", length));
			String[] sprPrtUcAmt = (JSPUtil.getParameter(request, prefix	+ "spr_prt_uc_amt", length));
			String[] eacNo = (JSPUtil.getParameter(request, prefix	+ "eac_no", length));
			String[] eqKndCdNm = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd_nm", length));
			String[] estVrfyYn = (JSPUtil.getParameter(request, prefix	+ "est_vrfy_yn", length));
			String[] bzcAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] agmtOfcCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] wkVrfyDesc = (JSPUtil.getParameter(request, prefix	+ "wk_vrfy_desc", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] rhqInvOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_inv_ofc_cd", length));
			String[] estYn = (JSPUtil.getParameter(request, prefix	+ "est_yn", length));
			String[] woYn = (JSPUtil.getParameter(request, prefix	+ "wo_yn", length));
			String[] invUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_usd_amt", length));
			String[] invDiffPct = (JSPUtil.getParameter(request, prefix	+ "inv_diff_pct", length));
			String[] trfAmt = (JSPUtil.getParameter(request, prefix	+ "trf_amt", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			for (int i = 0; i < length; i++) {
				model = new MnrChargeDetailListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrOrdOfcCtyCd[i] != null)
					model.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd[i]);
				if (costAmt[i] != null)
					model.setCostAmt(costAmt[i]);
				if (costCdNm[i] != null)
					model.setCostCdNm(costCdNm[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (woOfcCd[i] != null)
					model.setWoOfcCd(woOfcCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (woCurrCd[i] != null)
					model.setWoCurrCd(woCurrCd[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (chgWoAmt[i] != null)
					model.setChgWoAmt(chgWoAmt[i]);
				if (sprPrtUcAmt[i] != null)
					model.setSprPrtUcAmt(sprPrtUcAmt[i]);
				if (eacNo[i] != null)
					model.setEacNo(eacNo[i]);
				if (eqKndCdNm[i] != null)
					model.setEqKndCdNm(eqKndCdNm[i]);
				if (estVrfyYn[i] != null)
					model.setEstVrfyYn(estVrfyYn[i]);
				if (bzcAmt[i] != null)
					model.setBzcAmt(bzcAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (agmtOfcCd[i] != null)
					model.setAgmtOfcCd(agmtOfcCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (wkVrfyDesc[i] != null)
					model.setWkVrfyDesc(wkVrfyDesc[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (rhqInvOfcCd[i] != null)
					model.setRhqInvOfcCd(rhqInvOfcCd[i]);
				if (estYn[i] != null)
					model.setEstYn(estYn[i]);
				if (woYn[i] != null)
					model.setWoYn(woYn[i]);
				if (invUsdAmt[i] != null)
					model.setInvUsdAmt(invUsdAmt[i]);
				if (invDiffPct[i] != null)
					model.setInvDiffPct(invDiffPct[i]);
				if (trfAmt[i] != null)
					model.setTrfAmt(trfAmt[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getMnrChargeDetailListVOs();
	}

	public MnrChargeDetailListVO[] getMnrChargeDetailListVOs(){
		MnrChargeDetailListVO[] vos = (MnrChargeDetailListVO[])models.toArray(new MnrChargeDetailListVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdOfcCtyCd = this.mnrOrdOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt = this.costAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCdNm = this.costCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woOfcCd = this.woOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCurrCd = this.woCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgWoAmt = this.chgWoAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtUcAmt = this.sprPrtUcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacNo = this.eacNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCdNm = this.eqKndCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estVrfyYn = this.estVrfyYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt = this.bzcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCd = this.agmtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkVrfyDesc = this.wkVrfyDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqInvOfcCd = this.rhqInvOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estYn = this.estYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woYn = this.woYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdAmt = this.invUsdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDiffPct = this.invDiffPct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfAmt = this.trfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}