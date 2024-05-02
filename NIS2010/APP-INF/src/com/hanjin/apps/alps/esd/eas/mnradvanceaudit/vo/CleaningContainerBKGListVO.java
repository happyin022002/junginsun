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

public class CleaningContainerBKGListVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<CleaningContainerBKGListVO> models = new ArrayList<CleaningContainerBKGListVO>();
	private String pagerows = null;
	private String ofcCd = null;
	private String eqNo = null;
	private String costDtlNm = null;
	private String ibflag = null;
	private String mnrInpDt = null;
	private String locCd = null;
	private String currCd = null;
	private String costAmt = null;
	private String preBkgNo = null;
	private String postVpsEtdDt = null;
	private String woNo = null;
	private String preVpsEtdDt = null;
	private String ydCd = null;
	private String rhqOfcCd = null;
	private String postBkgNo = null;
	private String eqTpszCd = null;
	private String lstmCd = null;
	private String ownrCoCd = null;
	private String preSpecial = null;
	private String preCmdtCd = null;
	private String preCmdtNm = null;
	private String preCstmsDesc = null;
	private String preUnNo = null;
	private String preCdoTemp = null;
	private String postSpecial = null;
	private String postCmdtCd = null;
	private String postCmdtNm = null;
	private String postCstmsDesc = null;
	private String postUnNo = null;
	private String postCdoTemp = null;
	private String podYard = null;
	private String polYard = null;
	private String rowNum = null;
	private String total = null;
	private String maxRow = null;
	private String woUser = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CleaningContainerBKGListVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cost_dtl_nm", getCostDtlNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_inp_dt", getMnrInpDt());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cost_amt", getCostAmt());
		this.hashColumns.put("pre_bkg_no", getPreBkgNo());
		this.hashColumns.put("post_vps_etd_dt", getPostVpsEtdDt());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("pre_vps_etd_dt", getPreVpsEtdDt());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("post_bkg_no", getPostBkgNo());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("ownr_co_cd", getOwnrCoCd());
		this.hashColumns.put("pre_special", getPreSpecial());
		this.hashColumns.put("pre_cmdt_cd", getPreCmdtCd());
		this.hashColumns.put("pre_cmdt_nm", getPreCmdtNm());
		this.hashColumns.put("pre_cstms_desc", getPreCstmsDesc());
		this.hashColumns.put("pre_un_no", getPreUnNo());
		this.hashColumns.put("pre_cdo_temp", getPreCdoTemp());
		this.hashColumns.put("post_special", getPostSpecial());
		this.hashColumns.put("post_cmdt_cd", getPostCmdtCd());
		this.hashColumns.put("post_cmdt_nm", getPostCmdtNm());
		this.hashColumns.put("post_cstms_desc", getPostCstmsDesc());
		this.hashColumns.put("post_un_no", getPostUnNo());
		this.hashColumns.put("post_cdo_temp", getPostCdoTemp());
		this.hashColumns.put("pod_yard", getPodYard());
		this.hashColumns.put("pol_yard", getPolYard());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("max_row", getMaxRow());
		this.hashColumns.put("wo_user", getWoUser());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cost_dtl_nm", "costDtlNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_inp_dt", "mnrInpDt");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("pre_bkg_no", "preBkgNo");
		this.hashFields.put("post_vps_etd_dt", "postVpsEtdDt");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("pre_vps_etd_dt", "preVpsEtdDt");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("post_bkg_no", "postBkgNo");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("ownr_co_cd", "ownrCoCd");
		this.hashFields.put("pre_special", "preSpecial");
		this.hashFields.put("pre_cmdt_cd", "preCmdtCd");
		this.hashFields.put("pre_cmdt_nm", "preCmdtNm");
		this.hashFields.put("pre_cstms_desc", "preCstmsDesc");
		this.hashFields.put("pre_un_no", "preUnNo");
		this.hashFields.put("pre_cdo_temp", "preCdoTemp");
		this.hashFields.put("post_special", "postSpecial");
		this.hashFields.put("post_cmdt_cd", "postCmdtCd");
		this.hashFields.put("post_cmdt_nm", "postCmdtNm");
		this.hashFields.put("post_cstms_desc", "postCstmsDesc");
		this.hashFields.put("post_un_no", "postUnNo");
		this.hashFields.put("post_cdo_temp", "postCdoTemp");
		this.hashFields.put("pod_yard", "podYard");
		this.hashFields.put("pol_yard", "polYard");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("total", "total");
		this.hashFields.put("max_row", "maxRow");
		this.hashFields.put("wo_user", "woUser");
		return this.hashFields;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public String getOfcCd() {
		return this.ofcCd;
	}

	public String getEqNo() {
		return this.eqNo;
	}

	public String getCostDtlNm() {
		return this.costDtlNm;
	}

	public String getIbflag() {
		return this.ibflag;
	}

	public String getMnrInpDt() {
		return this.mnrInpDt;
	}

	public String getLocCd() {
		return this.locCd;
	}

	public String getCurrCd() {
		return this.currCd;
	}

	public String getCostAmt() {
		return this.costAmt;
	}

	public String getPreBkgNo() {
		return this.preBkgNo;
	}

	public String getPostVpsEtdDt() {
		return this.postVpsEtdDt;
	}

	public String getWoNo() {
		return this.woNo;
	}

	public String getPreVpsEtdDt() {
		return this.preVpsEtdDt;
	}

	public String getYdCd() {
		return this.ydCd;
	}

	public String getRhqOfcCd() {
		return this.rhqOfcCd;
	}

	public String getPostBkgNo() {
		return this.postBkgNo;
	}

	public String getEqTpszCd() {
		return this.eqTpszCd;
	}

	public String getLstmCd() {
		return this.lstmCd;
	}

	public String getOwnrCoCd() {
		return this.ownrCoCd;
	}

	public String getPreSpecial() {
		return this.preSpecial;
	}

	public String getPreCmdtCd() {
		return this.preCmdtCd;
	}

	public String getPreCmdtNm() {
		return this.preCmdtNm;
	}

	public String getPreCstmsDesc() {
		return this.preCstmsDesc;
	}

	public String getPreUnNo() {
		return this.preUnNo;
	}

	public String getPreCdoTemp() {
		return this.preCdoTemp;
	}

	public String getPostSpecial() {
		return this.postSpecial;
	}

	public String getPostCmdtCd() {
		return this.postCmdtCd;
	}

	public String getPostCmdtNm() {
		return this.postCmdtNm;
	}

	public String getPostCstmsDesc() {
		return this.postCstmsDesc;
	}

	public String getPostUnNo() {
		return this.postUnNo;
	}

	public String getPostCdoTemp() {
		return this.postCdoTemp;
	}

	public String getPodYard() {
		return this.podYard;
	}

	public String getPolYard() {
		return this.polYard;
	}

	public String getRowNum() {
		return this.rowNum;
	}

	public String getTotal() {
		return this.total;
	}

	public String getMaxRow() {
		return this.maxRow;
	}
	
	public String getWoUser() {
		return this.woUser;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}

	public void setCostDtlNm(String costDtlNm) {
		this.costDtlNm = costDtlNm;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public void setMnrInpDt(String mnrInpDt) {
		this.mnrInpDt = mnrInpDt;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
	}

	public void setPreBkgNo(String preBkgNo) {
		this.preBkgNo = preBkgNo;
	}

	public void setPostVpsEtdDt(String postVpsEtdDt) {
		this.postVpsEtdDt = postVpsEtdDt;
	}

	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}

	public void setPreVpsEtdDt(String preVpsEtdDt) {
		this.preVpsEtdDt = preVpsEtdDt;
	}

	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}

	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}

	public void setPostBkgNo(String postBkgNo) {
		this.postBkgNo = postBkgNo;
	}

	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}

	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	public void setOwnrCoCd(String ownrCoCd) {
		this.ownrCoCd = ownrCoCd;
	}

	public void setPreSpecial(String preSpecial) {
		this.preSpecial = preSpecial;
	}

	public void setPreCmdtCd(String preCmdtCd) {
		this.preCmdtCd = preCmdtCd;
	}

	public void setPreCmdtNm(String preCmdtNm) {
		this.preCmdtNm = preCmdtNm;
	}

	public void setPreCstmsDesc(String preCstmsDesc) {
		this.preCstmsDesc = preCstmsDesc;
	}

	public void setPreUnNo(String preUnNo) {
		this.preUnNo = preUnNo;
	}

	public void setPreCdoTemp(String preCdoTemp) {
		this.preCdoTemp = preCdoTemp;
	}

	public void setPostSpecial(String postSpecial) {
		this.postSpecial = postSpecial;
	}

	public void setPostCmdtCd(String postCmdtCd) {
		this.postCmdtCd = postCmdtCd;
	}

	public void setPostCmdtNm(String postCmdtNm) {
		this.postCmdtNm = postCmdtNm;
	}

	public void setPostCstmsDesc(String postCstmsDesc) {
		this.postCstmsDesc = postCstmsDesc;
	}

	public void setPostUnNo(String postUnNo) {
		this.postUnNo = postUnNo;
	}

	public void setPostCdoTemp(String postCdoTemp) {
		this.postCdoTemp = postCdoTemp;
	}

	public void setPodYard(String podYard) {
		this.podYard = podYard;
	}

	public void setPolYard(String polYard) {
		this.polYard = polYard;
	}

	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public void setMaxRow(String maxRow) {
		this.maxRow = maxRow;
	}
	
	public void setWoUser(String woUser) {
		this.woUser = woUser;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setCostDtlNm(JSPUtil.getParameter(request, prefix + "cost_dtl_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMnrInpDt(JSPUtil.getParameter(request, prefix + "mnr_inp_dt", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCostAmt(JSPUtil.getParameter(request, prefix + "cost_amt", ""));
		setPreBkgNo(JSPUtil.getParameter(request, prefix + "pre_bkg_no", ""));
		setPostVpsEtdDt(JSPUtil.getParameter(request, prefix + "post_vps_etd_dt", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setPreVpsEtdDt(JSPUtil.getParameter(request, prefix + "pre_vps_etd_dt", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setPostBkgNo(JSPUtil.getParameter(request, prefix + "post_bkg_no", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setOwnrCoCd(JSPUtil.getParameter(request, prefix + "ownr_co_cd", ""));
		setPreSpecial(JSPUtil.getParameter(request, prefix + "pre_special", ""));
		setPreCmdtCd(JSPUtil.getParameter(request, prefix + "pre_cmdt_cd", ""));
		setPreCmdtNm(JSPUtil.getParameter(request, prefix + "pre_cmdt_nm", ""));
		setPreCstmsDesc(JSPUtil.getParameter(request, prefix + "pre_cstms_desc", ""));
		setPreUnNo(JSPUtil.getParameter(request, prefix + "pre_un_no", ""));
		setPreCdoTemp(JSPUtil.getParameter(request, prefix + "pre_cdo_temp", ""));
		setPostSpecial(JSPUtil.getParameter(request, prefix + "post_special", ""));
		setPostCmdtCd(JSPUtil.getParameter(request, prefix + "post_cmdt_cd", ""));
		setPostCmdtNm(JSPUtil.getParameter(request, prefix + "post_cmdt_nm", ""));
		setPostCstmsDesc(JSPUtil.getParameter(request, prefix + "post_cstms_desc", ""));
		setPostUnNo(JSPUtil.getParameter(request, prefix + "post_un_no", ""));
		setPostCdoTemp(JSPUtil.getParameter(request, prefix + "post_cdo_temp", ""));
		setPodYard(JSPUtil.getParameter(request, prefix + "pod_yard", ""));
		setPolYard(JSPUtil.getParameter(request, prefix + "pol_yard", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setMaxRow(JSPUtil.getParameter(request, prefix + "max_row", ""));
		setWoUser(JSPUtil.getParameter(request, prefix + "wo_user", ""));
	}

	public CleaningContainerBKGListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CleaningContainerBKGListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CleaningContainerBKGListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] costDtlNm = (JSPUtil.getParameter(request, prefix	+ "cost_dtl_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrInpDt = (JSPUtil.getParameter(request, prefix	+ "mnr_inp_dt", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] costAmt = (JSPUtil.getParameter(request, prefix	+ "cost_amt", length));
			String[] preBkgNo = (JSPUtil.getParameter(request, prefix	+ "pre_bkg_no", length));
			String[] postVpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "post_vps_etd_dt", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] preVpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "pre_vps_etd_dt", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] postBkgNo = (JSPUtil.getParameter(request, prefix	+ "post_bkg_no", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] ownrCoCd = (JSPUtil.getParameter(request, prefix	+ "ownr_co_cd", length));
			String[] preSpecial = (JSPUtil.getParameter(request, prefix	+ "pre_special", length));
			String[] preCmdtCd = (JSPUtil.getParameter(request, prefix	+ "pre_cmdt_cd", length));
			String[] preCmdtNm = (JSPUtil.getParameter(request, prefix	+ "pre_cmdt_nm", length));
			String[] preCstmsDesc = (JSPUtil.getParameter(request, prefix	+ "pre_cstms_desc", length));
			String[] preUnNo = (JSPUtil.getParameter(request, prefix	+ "pre_un_no", length));
			String[] preCdoTemp = (JSPUtil.getParameter(request, prefix	+ "pre_cdo_temp", length));
			String[] postSpecial = (JSPUtil.getParameter(request, prefix	+ "post_special", length));
			String[] postCmdtCd = (JSPUtil.getParameter(request, prefix	+ "post_cmdt_cd", length));
			String[] postCmdtNm = (JSPUtil.getParameter(request, prefix	+ "post_cmdt_nm", length));
			String[] postCstmsDesc = (JSPUtil.getParameter(request, prefix	+ "post_cstms_desc", length));
			String[] postUnNo = (JSPUtil.getParameter(request, prefix	+ "post_un_no", length));
			String[] postCdoTemp = (JSPUtil.getParameter(request, prefix	+ "post_cdo_temp", length));
			String[] podYard = (JSPUtil.getParameter(request, prefix	+ "pod_yard", length));
			String[] polYard = (JSPUtil.getParameter(request, prefix	+ "pol_yard", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] maxRow = (JSPUtil.getParameter(request, prefix	+ "max_row", length));
			String[] woUser = (JSPUtil.getParameter(request, prefix	+ "wo_user", length));
			for (int i = 0; i < length; i++) {
				model = new CleaningContainerBKGListVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (costDtlNm[i] != null)
					model.setCostDtlNm(costDtlNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrInpDt[i] != null)
					model.setMnrInpDt(mnrInpDt[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (costAmt[i] != null)
					model.setCostAmt(costAmt[i]);
				if (preBkgNo[i] != null)
					model.setPreBkgNo(preBkgNo[i]);
				if (postVpsEtdDt[i] != null)
					model.setPostVpsEtdDt(postVpsEtdDt[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (preVpsEtdDt[i] != null)
					model.setPreVpsEtdDt(preVpsEtdDt[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (postBkgNo[i] != null)
					model.setPostBkgNo(postBkgNo[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (ownrCoCd[i] != null)
					model.setOwnrCoCd(ownrCoCd[i]);
				if (preSpecial[i] != null)
					model.setPreSpecial(preSpecial[i]);
				if (preCmdtCd[i] != null)
					model.setPreCmdtCd(preCmdtCd[i]);
				if (preCmdtNm[i] != null)
					model.setPreCmdtNm(preCmdtNm[i]);
				if (preCstmsDesc[i] != null)
					model.setPreCstmsDesc(preCstmsDesc[i]);
				if (preUnNo[i] != null)
					model.setPreUnNo(preUnNo[i]);
				if (preCdoTemp[i] != null)
					model.setPreCdoTemp(preCdoTemp[i]);
				if (postSpecial[i] != null)
					model.setPostSpecial(postSpecial[i]);
				if (postCmdtCd[i] != null)
					model.setPostCmdtCd(postCmdtCd[i]);
				if (postCmdtNm[i] != null)
					model.setPostCmdtNm(postCmdtNm[i]);
				if (postCstmsDesc[i] != null)
					model.setPostCstmsDesc(postCstmsDesc[i]);
				if (postUnNo[i] != null)
					model.setPostUnNo(postUnNo[i]);
				if (postCdoTemp[i] != null)
					model.setPostCdoTemp(postCdoTemp[i]);
				if (podYard[i] != null)
					model.setPodYard(podYard[i]);
				if (polYard[i] != null)
					model.setPolYard(polYard[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (total[i] != null)
					model.setTotal(total[i]);
				if (maxRow[i] != null)
					model.setMaxRow(maxRow[i]);
				if (woUser[i] != null)
					model.setWoUser(woUser[i]);
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getCleaningContainerBKGListVOs();
	}

	public CleaningContainerBKGListVO[] getCleaningContainerBKGListVOs(){
		CleaningContainerBKGListVO[] vos = (CleaningContainerBKGListVO[])models.toArray(new CleaningContainerBKGListVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDtlNm = this.costDtlNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInpDt = this.mnrInpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt = this.costAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preBkgNo = this.preBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postVpsEtdDt = this.postVpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVpsEtdDt = this.preVpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postBkgNo = this.postBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrCoCd = this.ownrCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSpecial = this.preSpecial.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCmdtCd = this.preCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCmdtNm = this.preCmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCstmsDesc = this.preCstmsDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preUnNo = this.preUnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCdoTemp = this.preCdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postSpecial = this.postSpecial.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postCmdtCd = this.postCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postCmdtNm = this.postCmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postCstmsDesc = this.postCstmsDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postUnNo = this.postUnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postCdoTemp = this.postCdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYard = this.podYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYard = this.polYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total = this.total.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxRow = this.maxRow.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woUser = this.woUser.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}