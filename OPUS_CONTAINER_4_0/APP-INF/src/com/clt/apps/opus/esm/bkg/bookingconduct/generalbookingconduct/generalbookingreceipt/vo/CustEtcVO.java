/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustEtcVO.java
*@FileTitle : CustEtcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustEtcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustEtcVO> models = new ArrayList<CustEtcVO>();
	
	/* Column Info */
	private String applDt = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String frobFlag = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String agmtActCntCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ffRefNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String caFlg = null;
	/* Column Info */
	private String krCstmsCustTpCd = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String custToOrdFlg = null;
	/* Column Info */
	private String bkgVvd = null;
	/* Column Info */
	private String fmcCd = null;
	/* Column Info */
	private String samCneeNtfyFlg = null;
	/* Column Info */
	private String orgCntNm = null;
	/* Column Info */
	private String agmtActCustSeq = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String nlFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustEtcVO() {}

	public CustEtcVO(String ibflag, String pagerows, String bkgNo, String blNo, String blTpCd, String blNoTp, String bkgVvd, String porCd, String polCd, String podCd, String delCd, String scNo, String rfaNo, String svcScpCd, String samCneeNtfyFlg, String agmtActCntCd, String agmtActCustSeq, String krCstmsCustTpCd, String custToOrdFlg, String orgCntNm, String ffRefNo, String fmcCd, String frobFlag, String nlFlag, String bkgStsCd, String caFlg, String applDt) {
		this.applDt = applDt;
		this.porCd = porCd;
		this.svcScpCd = svcScpCd;
		this.frobFlag = frobFlag;
		this.bkgStsCd = bkgStsCd;
		this.blNo = blNo;
		this.agmtActCntCd = agmtActCntCd;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.ffRefNo = ffRefNo;
		this.scNo = scNo;
		this.caFlg = caFlg;
		this.krCstmsCustTpCd = krCstmsCustTpCd;
		this.blNoTp = blNoTp;
		this.custToOrdFlg = custToOrdFlg;
		this.bkgVvd = bkgVvd;
		this.fmcCd = fmcCd;
		this.samCneeNtfyFlg = samCneeNtfyFlg;
		this.orgCntNm = orgCntNm;
		this.agmtActCustSeq = agmtActCustSeq;
		this.delCd = delCd;
		this.blTpCd = blTpCd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.nlFlag = nlFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("appl_dt", getApplDt());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("frob_flag", getFrobFlag());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("agmt_act_cnt_cd", getAgmtActCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ff_ref_no", getFfRefNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ca_flg", getCaFlg());
		this.hashColumns.put("kr_cstms_cust_tp_cd", getKrCstmsCustTpCd());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("cust_to_ord_flg", getCustToOrdFlg());
		this.hashColumns.put("bkg_vvd", getBkgVvd());
		this.hashColumns.put("fmc_cd", getFmcCd());
		this.hashColumns.put("sam_cnee_ntfy_flg", getSamCneeNtfyFlg());
		this.hashColumns.put("org_cnt_nm", getOrgCntNm());
		this.hashColumns.put("agmt_act_cust_seq", getAgmtActCustSeq());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("nl_flag", getNlFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("appl_dt", "applDt");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("frob_flag", "frobFlag");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("agmt_act_cnt_cd", "agmtActCntCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ff_ref_no", "ffRefNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ca_flg", "caFlg");
		this.hashFields.put("kr_cstms_cust_tp_cd", "krCstmsCustTpCd");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("cust_to_ord_flg", "custToOrdFlg");
		this.hashFields.put("bkg_vvd", "bkgVvd");
		this.hashFields.put("fmc_cd", "fmcCd");
		this.hashFields.put("sam_cnee_ntfy_flg", "samCneeNtfyFlg");
		this.hashFields.put("org_cnt_nm", "orgCntNm");
		this.hashFields.put("agmt_act_cust_seq", "agmtActCustSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("nl_flag", "nlFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return applDt
	 */
	public String getApplDt() {
		return this.applDt;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return frobFlag
	 */
	public String getFrobFlag() {
		return this.frobFlag;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return agmtActCntCd
	 */
	public String getAgmtActCntCd() {
		return this.agmtActCntCd;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return ffRefNo
	 */
	public String getFfRefNo() {
		return this.ffRefNo;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return caFlg
	 */
	public String getCaFlg() {
		return this.caFlg;
	}
	
	/**
	 * Column Info
	 * @return krCstmsCustTpCd
	 */
	public String getKrCstmsCustTpCd() {
		return this.krCstmsCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return blNoTp
	 */
	public String getBlNoTp() {
		return this.blNoTp;
	}
	
	/**
	 * Column Info
	 * @return custToOrdFlg
	 */
	public String getCustToOrdFlg() {
		return this.custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgVvd
	 */
	public String getBkgVvd() {
		return this.bkgVvd;
	}
	
	/**
	 * Column Info
	 * @return fmcCd
	 */
	public String getFmcCd() {
		return this.fmcCd;
	}
	
	/**
	 * Column Info
	 * @return samCneeNtfyFlg
	 */
	public String getSamCneeNtfyFlg() {
		return this.samCneeNtfyFlg;
	}
	
	/**
	 * Column Info
	 * @return orgCntNm
	 */
	public String getOrgCntNm() {
		return this.orgCntNm;
	}
	
	/**
	 * Column Info
	 * @return agmtActCustSeq
	 */
	public String getAgmtActCustSeq() {
		return this.agmtActCustSeq;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return nlFlag
	 */
	public String getNlFlag() {
		return this.nlFlag;
	}
	

	/**
	 * Column Info
	 * @param applDt
	 */
	public void setApplDt(String applDt) {
		this.applDt = applDt;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param frobFlag
	 */
	public void setFrobFlag(String frobFlag) {
		this.frobFlag = frobFlag;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param agmtActCntCd
	 */
	public void setAgmtActCntCd(String agmtActCntCd) {
		this.agmtActCntCd = agmtActCntCd;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param ffRefNo
	 */
	public void setFfRefNo(String ffRefNo) {
		this.ffRefNo = ffRefNo;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param caFlg
	 */
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}
	
	/**
	 * Column Info
	 * @param krCstmsCustTpCd
	 */
	public void setKrCstmsCustTpCd(String krCstmsCustTpCd) {
		this.krCstmsCustTpCd = krCstmsCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param blNoTp
	 */
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
	}
	
	/**
	 * Column Info
	 * @param custToOrdFlg
	 */
	public void setCustToOrdFlg(String custToOrdFlg) {
		this.custToOrdFlg = custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgVvd
	 */
	public void setBkgVvd(String bkgVvd) {
		this.bkgVvd = bkgVvd;
	}
	
	/**
	 * Column Info
	 * @param fmcCd
	 */
	public void setFmcCd(String fmcCd) {
		this.fmcCd = fmcCd;
	}
	
	/**
	 * Column Info
	 * @param samCneeNtfyFlg
	 */
	public void setSamCneeNtfyFlg(String samCneeNtfyFlg) {
		this.samCneeNtfyFlg = samCneeNtfyFlg;
	}
	
	/**
	 * Column Info
	 * @param orgCntNm
	 */
	public void setOrgCntNm(String orgCntNm) {
		this.orgCntNm = orgCntNm;
	}
	
	/**
	 * Column Info
	 * @param agmtActCustSeq
	 */
	public void setAgmtActCustSeq(String agmtActCustSeq) {
		this.agmtActCustSeq = agmtActCustSeq;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param nlFlag
	 */
	public void setNlFlag(String nlFlag) {
		this.nlFlag = nlFlag;
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
		setApplDt(JSPUtil.getParameter(request, prefix + "appl_dt", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setFrobFlag(JSPUtil.getParameter(request, prefix + "frob_flag", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setAgmtActCntCd(JSPUtil.getParameter(request, prefix + "agmt_act_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFfRefNo(JSPUtil.getParameter(request, prefix + "ff_ref_no", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCaFlg(JSPUtil.getParameter(request, prefix + "ca_flg", ""));
		setKrCstmsCustTpCd(JSPUtil.getParameter(request, prefix + "kr_cstms_cust_tp_cd", ""));
		setBlNoTp(JSPUtil.getParameter(request, prefix + "bl_no_tp", ""));
		setCustToOrdFlg(JSPUtil.getParameter(request, prefix + "cust_to_ord_flg", ""));
		setBkgVvd(JSPUtil.getParameter(request, prefix + "bkg_vvd", ""));
		setFmcCd(JSPUtil.getParameter(request, prefix + "fmc_cd", ""));
		setSamCneeNtfyFlg(JSPUtil.getParameter(request, prefix + "sam_cnee_ntfy_flg", ""));
		setOrgCntNm(JSPUtil.getParameter(request, prefix + "org_cnt_nm", ""));
		setAgmtActCustSeq(JSPUtil.getParameter(request, prefix + "agmt_act_cust_seq", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setNlFlag(JSPUtil.getParameter(request, prefix + "nl_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustEtcVO[]
	 */
	public CustEtcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustEtcVO[]
	 */
	public CustEtcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustEtcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] applDt = (JSPUtil.getParameter(request, prefix	+ "appl_dt", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] frobFlag = (JSPUtil.getParameter(request, prefix	+ "frob_flag", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] agmtActCntCd = (JSPUtil.getParameter(request, prefix	+ "agmt_act_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ffRefNo = (JSPUtil.getParameter(request, prefix	+ "ff_ref_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));
			String[] krCstmsCustTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_cust_tp_cd", length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp", length));
			String[] custToOrdFlg = (JSPUtil.getParameter(request, prefix	+ "cust_to_ord_flg", length));
			String[] bkgVvd = (JSPUtil.getParameter(request, prefix	+ "bkg_vvd", length));
			String[] fmcCd = (JSPUtil.getParameter(request, prefix	+ "fmc_cd", length));
			String[] samCneeNtfyFlg = (JSPUtil.getParameter(request, prefix	+ "sam_cnee_ntfy_flg", length));
			String[] orgCntNm = (JSPUtil.getParameter(request, prefix	+ "org_cnt_nm", length));
			String[] agmtActCustSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_act_cust_seq", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] nlFlag = (JSPUtil.getParameter(request, prefix	+ "nl_flag", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustEtcVO();
				if (applDt[i] != null)
					model.setApplDt(applDt[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (frobFlag[i] != null)
					model.setFrobFlag(frobFlag[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (agmtActCntCd[i] != null)
					model.setAgmtActCntCd(agmtActCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ffRefNo[i] != null)
					model.setFfRefNo(ffRefNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				if (krCstmsCustTpCd[i] != null)
					model.setKrCstmsCustTpCd(krCstmsCustTpCd[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (custToOrdFlg[i] != null)
					model.setCustToOrdFlg(custToOrdFlg[i]);
				if (bkgVvd[i] != null)
					model.setBkgVvd(bkgVvd[i]);
				if (fmcCd[i] != null)
					model.setFmcCd(fmcCd[i]);
				if (samCneeNtfyFlg[i] != null)
					model.setSamCneeNtfyFlg(samCneeNtfyFlg[i]);
				if (orgCntNm[i] != null)
					model.setOrgCntNm(orgCntNm[i]);
				if (agmtActCustSeq[i] != null)
					model.setAgmtActCustSeq(agmtActCustSeq[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (nlFlag[i] != null)
					model.setNlFlag(nlFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustEtcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustEtcVO[]
	 */
	public CustEtcVO[] getCustEtcVOs(){
		CustEtcVO[] vos = (CustEtcVO[])models.toArray(new CustEtcVO[models.size()]);
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
		this.applDt = this.applDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frobFlag = this.frobFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtActCntCd = this.agmtActCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffRefNo = this.ffRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsCustTpCd = this.krCstmsCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custToOrdFlg = this.custToOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVvd = this.bkgVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcCd = this.fmcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.samCneeNtfyFlg = this.samCneeNtfyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCntNm = this.orgCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtActCustSeq = this.agmtActCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nlFlag = this.nlFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
