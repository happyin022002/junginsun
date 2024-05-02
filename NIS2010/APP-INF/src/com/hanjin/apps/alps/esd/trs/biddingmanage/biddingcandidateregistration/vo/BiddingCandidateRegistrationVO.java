package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.vo;

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

public class BiddingCandidateRegistrationVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<BiddingCandidateRegistrationVO> models = new ArrayList<BiddingCandidateRegistrationVO>();
	private String spotBidCnddtTermSeq = null;
	private String toNodCd = null;
	private String fmNodCd = null;
	private String ibflag = null;
	private String deltFlg = null;
	private String vndrSeq = null;
	private String dorNodCd = null;
	private String viaNodCd = null;
	private String spotBidOfcCd = null;
	private String spotBidVndrEml = null;
	private String trspCrrModCd = null;
	private String pagerows = null;
	private String toLocValue = null;
	private String viaLocValue = null;
	private String fmLocValue = null;
	private String dorLocValue = null;
	private String dorYardValue = null;
	private String toYardValue = null;
	private String fmYardValue = null;
	private String viaYardValue = null;
	/* Pair Member */
	private String spPtalExistFlg = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BiddingCandidateRegistrationVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("spot_bid_cnddt_term_seq", getSpotBidCnddtTermSeq());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("spot_bid_ofc_cd", getSpotBidOfcCd());
		this.hashColumns.put("spot_bid_vndr_eml", getSpotBidVndrEml());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_loc_value", getToLocValue());
		this.hashColumns.put("via_loc_value", getViaLocValue());
		this.hashColumns.put("fm_loc_value", getFmLocValue());
		this.hashColumns.put("dor_loc_value", getDorLocValue());
		this.hashColumns.put("dor_yard_value", getDorYardValue());
		this.hashColumns.put("to_yard_value", getToYardValue());
		this.hashColumns.put("fm_yard_value", getFmYardValue());
		this.hashColumns.put("via_yard_value", getViaYardValue());
		this.hashColumns.put("sp_ptal_exist_flg", getSpPtalExistFlg());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("spot_bid_cnddt_term_seq", "spotBidCnddtTermSeq");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("spot_bid_ofc_cd", "spotBidOfcCd");
		this.hashFields.put("spot_bid_vndr_eml", "spotBidVndrEml");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_loc_value", "toLocValue");
		this.hashFields.put("via_loc_value", "viaLocValue");
		this.hashFields.put("fm_loc_value", "fmLocValue");
		this.hashFields.put("dor_loc_value", "dorLocValue");
		this.hashFields.put("dor_yard_value", "dorYardValue");
		this.hashFields.put("to_yard_value", "toYardValue");
		this.hashFields.put("fm_yard_value", "fmYardValue");
		this.hashFields.put("via_yard_value", "viaYardValue");
		this.hashFields.put("sp_ptal_exist_flg", "spPtalExistFlg");
		return this.hashFields;
	}
	public String getSpotBidCnddtTermSeq() {
		return this.spotBidCnddtTermSeq;
	}

	public String getToNodCd() {
		return this.toNodCd;
	}

	public String getFmNodCd() {
		return this.fmNodCd;
	}

	public String getIbflag() {
		return this.ibflag;
	}

	public String getDeltFlg() {
		return this.deltFlg;
	}

	public String getVndrSeq() {
		return this.vndrSeq;
	}

	public String getDorNodCd() {
		return this.dorNodCd;
	}

	public String getViaNodCd() {
		return this.viaNodCd;
	}

	public String getSpotBidOfcCd() {
		return this.spotBidOfcCd;
	}

	public String getSpotBidVndrEml() {
		return this.spotBidVndrEml;
	}

	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}

	public String getPagerows() {
		return this.pagerows;
	}

	public String getToLocValue() {
		return this.toLocValue;
	}

	public String getViaLocValue() {
		return this.viaLocValue;
	}

	public String getFmLocValue() {
		return this.fmLocValue;
	}

	public String getDorLocValue() {
		return this.dorLocValue;
	}

	public String getDorYardValue() {
		return this.dorYardValue;
	}

	public String getToYardValue() {
		return this.toYardValue;
	}

	public String getFmYardValue() {
		return this.fmYardValue;
	}

	public String getViaYardValue() {
		return this.viaYardValue;
	}

	public String getSpPtalExistFlg() {
		return this.spPtalExistFlg;
	}

	public void setSpotBidCnddtTermSeq(String spotBidCnddtTermSeq) {
		this.spotBidCnddtTermSeq = spotBidCnddtTermSeq;
	}

	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}

	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}

	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}

	public void setSpotBidOfcCd(String spotBidOfcCd) {
		this.spotBidOfcCd = spotBidOfcCd;
	}

	public void setSpotBidVndrEml(String spotBidVndrEml) {
		this.spotBidVndrEml = spotBidVndrEml;
	}

	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public void setToLocValue(String toLocValue) {
		this.toLocValue = toLocValue;
	}

	public void setViaLocValue(String viaLocValue) {
		this.viaLocValue = viaLocValue;
	}

	public void setFmLocValue(String fmLocValue) {
		this.fmLocValue = fmLocValue;
	}

	public void setDorLocValue(String dorLocValue) {
		this.dorLocValue = dorLocValue;
	}

	public void setDorYardValue(String dorYardValue) {
		this.dorYardValue = dorYardValue;
	}

	public void setToYardValue(String toYardValue) {
		this.toYardValue = toYardValue;
	}

	public void setFmYardValue(String fmYardValue) {
		this.fmYardValue = fmYardValue;
	}

	public void setViaYardValue(String viaYardValue) {
		this.viaYardValue = viaYardValue;
	}

	public void setSpPtalExistFlg(String spPtalExistFlg) {
		this.spPtalExistFlg = spPtalExistFlg;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setSpotBidCnddtTermSeq(JSPUtil.getParameter(request, prefix + "spot_bid_cnddt_term_seq", ""));
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setSpotBidOfcCd(JSPUtil.getParameter(request, prefix + "spot_bid_ofc_cd", ""));
		setSpotBidVndrEml(JSPUtil.getParameter(request, prefix + "spot_bid_vndr_eml", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setToLocValue(JSPUtil.getParameter(request, prefix + "to_loc_value", ""));
		setViaLocValue(JSPUtil.getParameter(request, prefix + "via_loc_value", ""));
		setFmLocValue(JSPUtil.getParameter(request, prefix + "fm_loc_value", ""));
		setDorLocValue(JSPUtil.getParameter(request, prefix + "dor_loc_value", ""));
		setDorYardValue(JSPUtil.getParameter(request, prefix + "dor_yard_value", ""));
		setToYardValue(JSPUtil.getParameter(request, prefix + "to_yard_value", ""));
		setFmYardValue(JSPUtil.getParameter(request, prefix + "fm_yard_value", ""));
		setViaYardValue(JSPUtil.getParameter(request, prefix + "via_yard_value", ""));
		setSpPtalExistFlg(JSPUtil.getParameter(request, prefix + "sp_ptal_exist_flg", ""));
	}

	public BiddingCandidateRegistrationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public BiddingCandidateRegistrationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BiddingCandidateRegistrationVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] spotBidCnddtTermSeq = (JSPUtil.getParameter(request, prefix	+ "spot_bid_cnddt_term_seq", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] spotBidOfcCd = (JSPUtil.getParameter(request, prefix	+ "spot_bid_ofc_cd", length));
			String[] spotBidVndrEml = (JSPUtil.getParameter(request, prefix	+ "spot_bid_vndr_eml", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toLocValue = (JSPUtil.getParameter(request, prefix	+ "to_loc_value", length));
			String[] viaLocValue = (JSPUtil.getParameter(request, prefix	+ "via_loc_value", length));
			String[] fmLocValue = (JSPUtil.getParameter(request, prefix	+ "fm_loc_value", length));
			String[] dorLocValue = (JSPUtil.getParameter(request, prefix	+ "dor_loc_value", length));
			String[] dorYardValue = (JSPUtil.getParameter(request, prefix	+ "dor_yard_value", length));
			String[] toYardValue = (JSPUtil.getParameter(request, prefix	+ "to_yard_value", length));
			String[] fmYardValue = (JSPUtil.getParameter(request, prefix	+ "fm_yard_value", length));
			String[] viaYardValue = (JSPUtil.getParameter(request, prefix	+ "via_yard_value", length));
			String[] spPtalExistFlg = (JSPUtil.getParameter(request, prefix	+ "sp_ptal_exist_flg", length));
			for (int i = 0; i < length; i++) {
				model = new BiddingCandidateRegistrationVO();
				if (spotBidCnddtTermSeq[i] != null)
					model.setSpotBidCnddtTermSeq(spotBidCnddtTermSeq[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (spotBidOfcCd[i] != null)
					model.setSpotBidOfcCd(spotBidOfcCd[i]);
				if (spotBidVndrEml[i] != null)
					model.setSpotBidVndrEml(spotBidVndrEml[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toLocValue[i] != null)
					model.setToLocValue(toLocValue[i]);
				if (viaLocValue[i] != null)
					model.setViaLocValue(viaLocValue[i]);
				if (fmLocValue[i] != null)
					model.setFmLocValue(fmLocValue[i]);
				if (dorLocValue[i] != null)
					model.setDorLocValue(dorLocValue[i]);
				if (dorYardValue[i] != null)
					model.setDorYardValue(dorYardValue[i]);
				if (toYardValue[i] != null)
					model.setToYardValue(toYardValue[i]);
				if (fmYardValue[i] != null)
					model.setFmYardValue(fmYardValue[i]);
				if (viaYardValue[i] != null)
					model.setViaYardValue(viaYardValue[i]);
				if (spPtalExistFlg[i] != null)
					model.setSpPtalExistFlg(spPtalExistFlg[i]);
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getBiddingCandidateRegistrationVOs();
	}

	public BiddingCandidateRegistrationVO[] getBiddingCandidateRegistrationVOs(){
		BiddingCandidateRegistrationVO[] vos = (BiddingCandidateRegistrationVO[])models.toArray(new BiddingCandidateRegistrationVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.spotBidCnddtTermSeq = this.spotBidCnddtTermSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidOfcCd = this.spotBidOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidVndrEml = this.spotBidVndrEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocValue = this.toLocValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaLocValue = this.viaLocValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocValue = this.fmLocValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorLocValue = this.dorLocValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorYardValue = this.dorYardValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYardValue = this.toYardValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYardValue = this.fmYardValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaYardValue = this.viaYardValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spPtalExistFlg = this.spPtalExistFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}