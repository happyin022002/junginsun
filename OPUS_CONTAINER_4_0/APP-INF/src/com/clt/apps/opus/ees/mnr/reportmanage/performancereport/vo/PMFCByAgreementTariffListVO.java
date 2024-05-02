/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PMFCByAgreementTariffListVO.java
*@FileTitle : PMFCByAgreementTariffListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.12.23 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PMFCByAgreementTariffListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PMFCByAgreementTariffListVO> models = new ArrayList<PMFCByAgreementTariffListVO>();
	
	/* Column Info */
	private String agmtRtAmt = null;
	/* Column Info */
	private String mnrTrfStsCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String trfDivCd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String eqRprCd = null;
	/* Column Info */
	private String costGrpNm = null;
	/* Column Info */
	private String mtrlRecoAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrTrfStsNm = null;
	/* Column Info */
	private String vndrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String agmtCurrCd = null;
	/* Column Info */
	private String mtrlCostAmt = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String costGrpCd = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String rprLbrHrs = null;
	/* Column Info */
	private String eqCmpoCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PMFCByAgreementTariffListVO() {}

	public PMFCByAgreementTariffListVO(String ibflag, String pagerows, String agmtRtAmt, String mnrTrfStsCd, String currCd, String trfDivCd, String agmtNo, String arHdQtrOfcCd, String eqRprCd, String costGrpNm, String mtrlRecoAmt, String mnrTrfStsNm, String vndrNm, String mtrlCostAmt, String vndrSeq, String trfNo, String rqstOfcCd, String costGrpCd, String rprLbrHrs, String eqCmpoCd, String agmtCurrCd) {
		this.agmtRtAmt = agmtRtAmt;
		this.mnrTrfStsCd = mnrTrfStsCd;
		this.currCd = currCd;
		this.trfDivCd = trfDivCd;
		this.agmtNo = agmtNo;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.eqRprCd = eqRprCd;
		this.costGrpNm = costGrpNm;
		this.mtrlRecoAmt = mtrlRecoAmt;
		this.pagerows = pagerows;
		this.mnrTrfStsNm = mnrTrfStsNm;
		this.vndrNm = vndrNm;
		this.ibflag = ibflag;
		this.agmtCurrCd = agmtCurrCd;
		this.mtrlCostAmt = mtrlCostAmt;
		this.trfNo = trfNo;
		this.vndrSeq = vndrSeq;
		this.costGrpCd = costGrpCd;
		this.rqstOfcCd = rqstOfcCd;
		this.rprLbrHrs = rprLbrHrs;
		this.eqCmpoCd = eqCmpoCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_rt_amt", getAgmtRtAmt());
		this.hashColumns.put("mnr_trf_sts_cd", getMnrTrfStsCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("trf_div_cd", getTrfDivCd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("eq_rpr_cd", getEqRprCd());
		this.hashColumns.put("cost_grp_nm", getCostGrpNm());
		this.hashColumns.put("mtrl_reco_amt", getMtrlRecoAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_trf_sts_nm", getMnrTrfStsNm());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agmt_curr_cd", getAgmtCurrCd());
		this.hashColumns.put("mtrl_cost_amt", getMtrlCostAmt());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cost_grp_cd", getCostGrpCd());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("rpr_lbr_hrs", getRprLbrHrs());
		this.hashColumns.put("eq_cmpo_cd", getEqCmpoCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_rt_amt", "agmtRtAmt");
		this.hashFields.put("mnr_trf_sts_cd", "mnrTrfStsCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("trf_div_cd", "trfDivCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("eq_rpr_cd", "eqRprCd");
		this.hashFields.put("cost_grp_nm", "costGrpNm");
		this.hashFields.put("mtrl_reco_amt", "mtrlRecoAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_trf_sts_nm", "mnrTrfStsNm");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("agmt_curr_cd", "agmtCurrCd");
		this.hashFields.put("mtrl_cost_amt", "mtrlCostAmt");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cost_grp_cd", "costGrpCd");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("rpr_lbr_hrs", "rprLbrHrs");
		this.hashFields.put("eq_cmpo_cd", "eqCmpoCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return agmtRtAmt
	 */
	public String getAgmtRtAmt() {
		return this.agmtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return mnrTrfStsCd
	 */
	public String getMnrTrfStsCd() {
		return this.mnrTrfStsCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return trfDivCd
	 */
	public String getTrfDivCd() {
		return this.trfDivCd;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eqRprCd
	 */
	public String getEqRprCd() {
		return this.eqRprCd;
	}
	
	/**
	 * Column Info
	 * @return costGrpNm
	 */
	public String getCostGrpNm() {
		return this.costGrpNm;
	}
	
	/**
	 * Column Info
	 * @return mtrlRecoAmt
	 */
	public String getMtrlRecoAmt() {
		return this.mtrlRecoAmt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return mnrTrfStsNm
	 */
	public String getMnrTrfStsNm() {
		return this.mnrTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return agmtCurrCd
	 */
	public String getAgmtCurrCd() {
		return this.agmtCurrCd;
	}
	
	/**
	 * Column Info
	 * @return mtrlCostAmt
	 */
	public String getMtrlCostAmt() {
		return this.mtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return costGrpCd
	 */
	public String getCostGrpCd() {
		return this.costGrpCd;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rprLbrHrs
	 */
	public String getRprLbrHrs() {
		return this.rprLbrHrs;
	}
	
	/**
	 * Column Info
	 * @return eqCmpoCd
	 */
	public String getEqCmpoCd() {
		return this.eqCmpoCd;
	}
	

	/**
	 * Column Info
	 * @param agmtRtAmt
	 */
	public void setAgmtRtAmt(String agmtRtAmt) {
		this.agmtRtAmt = agmtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param mnrTrfStsCd
	 */
	public void setMnrTrfStsCd(String mnrTrfStsCd) {
		this.mnrTrfStsCd = mnrTrfStsCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param trfDivCd
	 */
	public void setTrfDivCd(String trfDivCd) {
		this.trfDivCd = trfDivCd;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eqRprCd
	 */
	public void setEqRprCd(String eqRprCd) {
		this.eqRprCd = eqRprCd;
	}
	
	/**
	 * Column Info
	 * @param costGrpNm
	 */
	public void setCostGrpNm(String costGrpNm) {
		this.costGrpNm = costGrpNm;
	}
	
	/**
	 * Column Info
	 * @param mtrlRecoAmt
	 */
	public void setMtrlRecoAmt(String mtrlRecoAmt) {
		this.mtrlRecoAmt = mtrlRecoAmt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param mnrTrfStsNm
	 */
	public void setMnrTrfStsNm(String mnrTrfStsNm) {
		this.mnrTrfStsNm = mnrTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param agmtCurrCd
	 */
	public void setAgmtCurrCd(String agmtCurrCd) {
		this.agmtCurrCd = agmtCurrCd;
	}
	
	/**
	 * Column Info
	 * @param mtrlCostAmt
	 */
	public void setMtrlCostAmt(String mtrlCostAmt) {
		this.mtrlCostAmt = mtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param costGrpCd
	 */
	public void setCostGrpCd(String costGrpCd) {
		this.costGrpCd = costGrpCd;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rprLbrHrs
	 */
	public void setRprLbrHrs(String rprLbrHrs) {
		this.rprLbrHrs = rprLbrHrs;
	}
	
	/**
	 * Column Info
	 * @param eqCmpoCd
	 */
	public void setEqCmpoCd(String eqCmpoCd) {
		this.eqCmpoCd = eqCmpoCd;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setAgmtRtAmt(JSPUtil.getParameter(request, prefix + "agmt_rt_amt", ""));
		setMnrTrfStsCd(JSPUtil.getParameter(request, prefix + "mnr_trf_sts_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTrfDivCd(JSPUtil.getParameter(request, prefix + "trf_div_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setEqRprCd(JSPUtil.getParameter(request, prefix + "eq_rpr_cd", ""));
		setCostGrpNm(JSPUtil.getParameter(request, prefix + "cost_grp_nm", ""));
		setMtrlRecoAmt(JSPUtil.getParameter(request, prefix + "mtrl_reco_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnrTrfStsNm(JSPUtil.getParameter(request, prefix + "mnr_trf_sts_nm", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAgmtCurrCd(JSPUtil.getParameter(request, prefix + "agmt_curr_cd", ""));
		setMtrlCostAmt(JSPUtil.getParameter(request, prefix + "mtrl_cost_amt", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCostGrpCd(JSPUtil.getParameter(request, prefix + "cost_grp_cd", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setRprLbrHrs(JSPUtil.getParameter(request, prefix + "rpr_lbr_hrs", ""));
		setEqCmpoCd(JSPUtil.getParameter(request, prefix + "eq_cmpo_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PMFCByAgreementTariffListVO[]
	 */
	public PMFCByAgreementTariffListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PMFCByAgreementTariffListVO[]
	 */
	public PMFCByAgreementTariffListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PMFCByAgreementTariffListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agmtRtAmt = (JSPUtil.getParameter(request, prefix	+ "agmt_rt_amt", length));
			String[] mnrTrfStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_sts_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] trfDivCd = (JSPUtil.getParameter(request, prefix	+ "trf_div_cd", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] eqRprCd = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_cd", length));
			String[] costGrpNm = (JSPUtil.getParameter(request, prefix	+ "cost_grp_nm", length));
			String[] mtrlRecoAmt = (JSPUtil.getParameter(request, prefix	+ "mtrl_reco_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrTrfStsNm = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_sts_nm", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] agmtCurrCd = (JSPUtil.getParameter(request, prefix	+ "agmt_curr_cd", length));
			String[] mtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mtrl_cost_amt", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] costGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_grp_cd", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] rprLbrHrs = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_hrs", length));
			String[] eqCmpoCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PMFCByAgreementTariffListVO();
				if (agmtRtAmt[i] != null)
					model.setAgmtRtAmt(agmtRtAmt[i]);
				if (mnrTrfStsCd[i] != null)
					model.setMnrTrfStsCd(mnrTrfStsCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (trfDivCd[i] != null)
					model.setTrfDivCd(trfDivCd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (eqRprCd[i] != null)
					model.setEqRprCd(eqRprCd[i]);
				if (costGrpNm[i] != null)
					model.setCostGrpNm(costGrpNm[i]);
				if (mtrlRecoAmt[i] != null)
					model.setMtrlRecoAmt(mtrlRecoAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrTrfStsNm[i] != null)
					model.setMnrTrfStsNm(mnrTrfStsNm[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (agmtCurrCd[i] != null)
					model.setAgmtCurrCd(agmtCurrCd[i]);
				if (mtrlCostAmt[i] != null)
					model.setMtrlCostAmt(mtrlCostAmt[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (costGrpCd[i] != null)
					model.setCostGrpCd(costGrpCd[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (rprLbrHrs[i] != null)
					model.setRprLbrHrs(rprLbrHrs[i]);
				if (eqCmpoCd[i] != null)
					model.setEqCmpoCd(eqCmpoCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPMFCByAgreementTariffListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PMFCByAgreementTariffListVO[]
	 */
	public PMFCByAgreementTariffListVO[] getPMFCByAgreementTariffListVOs(){
		PMFCByAgreementTariffListVO[] vos = (PMFCByAgreementTariffListVO[])models.toArray(new PMFCByAgreementTariffListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.agmtRtAmt = this.agmtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfStsCd = this.mnrTrfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfDivCd = this.trfDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprCd = this.eqRprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costGrpNm = this.costGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlRecoAmt = this.mtrlRecoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfStsNm = this.mnrTrfStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCurrCd = this.agmtCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlCostAmt = this.mtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costGrpCd = this.costGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrHrs = this.rprLbrHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCd = this.eqCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
