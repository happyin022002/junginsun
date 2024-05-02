/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OfficeCodeInfoVO.java
*@FileTitle : OfficeCodeInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.08.02 김봉균
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OfficeCodeInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<OfficeCodeInfoVO> models = new ArrayList<OfficeCodeInfoVO>();

	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String porAr = null;
	/* Column Info */
	private String polAr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polFinc = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String commProcRsltRsn = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String apOfcCd = null;
	/* Column Info */
	private String porFinc = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String podContiCd = null;
	/* Column Info */
	private String podAr = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polContiCd = null;
	/* Column Info */
	private String ppdOfrtAmt = null;
	/* Column Info */
	private String cltChgAmt = null;
	/* Column Info */
	private String bkgOfcAr = null;
	/* Column Info */
	private String delContiCd = null;
	/* Column Info */
	private String delFinc = null;
	/* Column Info */
	private String podFinc = null;
	/* Column Info */
	private String ppdChgAmt = null;
	/* Column Info */
	private String apCtrCd = null;
	/* Column Info */
	private String delAr = null;
	/* Column Info */
	private String porContiCd = null;
	/* Column Info */
	private String cltOfrtAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public OfficeCodeInfoVO() {}

	public OfficeCodeInfoVO(String ibflag, String pagerows, String bkgNo, String bkgOfcCd, String bkgOfcAr, String porCd, String porFinc, String porAr, String polCd, String polFinc, String polAr, String podCd, String podFinc, String podAr, String delCd, String delFinc, String delAr, String porContiCd, String polContiCd, String podContiCd, String delContiCd, String ppdOfrtAmt, String ppdChgAmt, String cltOfrtAmt, String cltChgAmt, String commProcRsltRsn, String usrId, String arOfcCd, String apOfcCd, String apCtrCd) {
		this.porCd = porCd;
		this.porAr = porAr;
		this.polAr = polAr;
		this.pagerows = pagerows;
		this.polFinc = polFinc;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.commProcRsltRsn = commProcRsltRsn;
		this.bkgOfcCd = bkgOfcCd;
		this.apOfcCd = apOfcCd;
		this.porFinc = porFinc;
		this.delCd = delCd;
		this.podContiCd = podContiCd;
		this.podAr = podAr;
		this.arOfcCd = arOfcCd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.polContiCd = polContiCd;
		this.ppdOfrtAmt = ppdOfrtAmt;
		this.cltChgAmt = cltChgAmt;
		this.bkgOfcAr = bkgOfcAr;
		this.delContiCd = delContiCd;
		this.delFinc = delFinc;
		this.podFinc = podFinc;
		this.ppdChgAmt = ppdChgAmt;
		this.apCtrCd = apCtrCd;
		this.delAr = delAr;
		this.porContiCd = porContiCd;
		this.cltOfrtAmt = cltOfrtAmt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("por_ar", getPorAr());
		this.hashColumns.put("pol_ar", getPolAr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_finc", getPolFinc());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("comm_proc_rslt_rsn", getCommProcRsltRsn());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());
		this.hashColumns.put("por_finc", getPorFinc());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pod_conti_cd", getPodContiCd());
		this.hashColumns.put("pod_ar", getPodAr());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_conti_cd", getPolContiCd());
		this.hashColumns.put("ppd_ofrt_amt", getPpdOfrtAmt());
		this.hashColumns.put("clt_chg_amt", getCltChgAmt());
		this.hashColumns.put("bkg_ofc_ar", getBkgOfcAr());
		this.hashColumns.put("del_conti_cd", getDelContiCd());
		this.hashColumns.put("del_finc", getDelFinc());
		this.hashColumns.put("pod_finc", getPodFinc());
		this.hashColumns.put("ppd_chg_amt", getPpdChgAmt());
		this.hashColumns.put("ap_ctr_cd", getApCtrCd());
		this.hashColumns.put("del_ar", getDelAr());
		this.hashColumns.put("por_conti_cd", getPorContiCd());
		this.hashColumns.put("clt_ofrt_amt", getCltOfrtAmt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("por_ar", "porAr");
		this.hashFields.put("pol_ar", "polAr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_finc", "polFinc");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("comm_proc_rslt_rsn", "commProcRsltRsn");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("por_finc", "porFinc");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pod_conti_cd", "podContiCd");
		this.hashFields.put("pod_ar", "podAr");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_conti_cd", "polContiCd");
		this.hashFields.put("ppd_ofrt_amt", "ppdOfrtAmt");
		this.hashFields.put("clt_chg_amt", "cltChgAmt");
		this.hashFields.put("bkg_ofc_ar", "bkgOfcAr");
		this.hashFields.put("del_conti_cd", "delContiCd");
		this.hashFields.put("del_finc", "delFinc");
		this.hashFields.put("pod_finc", "podFinc");
		this.hashFields.put("ppd_chg_amt", "ppdChgAmt");
		this.hashFields.put("ap_ctr_cd", "apCtrCd");
		this.hashFields.put("del_ar", "delAr");
		this.hashFields.put("por_conti_cd", "porContiCd");
		this.hashFields.put("clt_ofrt_amt", "cltOfrtAmt");
		return this.hashFields;
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
	 * @return porAr
	 */
	public String getPorAr() {
		return this.porAr;
	}

	/**
	 * Column Info
	 * @return polAr
	 */
	public String getPolAr() {
		return this.polAr;
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
	 * @return polFinc
	 */
	public String getPolFinc() {
		return this.polFinc;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}

	/**
	 * Column Info
	 * @return commProcRsltRsn
	 */
	public String getCommProcRsltRsn() {
		return this.commProcRsltRsn;
	}

	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}

	/**
	 * Column Info
	 * @return apOfcCd
	 */
	public String getApOfcCd() {
		return this.apOfcCd;
	}

	/**
	 * Column Info
	 * @return porFinc
	 */
	public String getPorFinc() {
		return this.porFinc;
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
	 * @return podContiCd
	 */
	public String getPodContiCd() {
		return this.podContiCd;
	}

	/**
	 * Column Info
	 * @return podAr
	 */
	public String getPodAr() {
		return this.podAr;
	}

	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return polContiCd
	 */
	public String getPolContiCd() {
		return this.polContiCd;
	}

	/**
	 * Column Info
	 * @return ppdOfrtAmt
	 */
	public String getPpdOfrtAmt() {
		return this.ppdOfrtAmt;
	}

	/**
	 * Column Info
	 * @return cltChgAmt
	 */
	public String getCltChgAmt() {
		return this.cltChgAmt;
	}

	/**
	 * Column Info
	 * @return bkgOfcAr
	 */
	public String getBkgOfcAr() {
		return this.bkgOfcAr;
	}

	/**
	 * Column Info
	 * @return delContiCd
	 */
	public String getDelContiCd() {
		return this.delContiCd;
	}

	/**
	 * Column Info
	 * @return delFinc
	 */
	public String getDelFinc() {
		return this.delFinc;
	}

	/**
	 * Column Info
	 * @return podFinc
	 */
	public String getPodFinc() {
		return this.podFinc;
	}

	/**
	 * Column Info
	 * @return ppdChgAmt
	 */
	public String getPpdChgAmt() {
		return this.ppdChgAmt;
	}

	/**
	 * Column Info
	 * @return apCtrCd
	 */
	public String getApCtrCd() {
		return this.apCtrCd;
	}

	/**
	 * Column Info
	 * @return delAr
	 */
	public String getDelAr() {
		return this.delAr;
	}

	/**
	 * Column Info
	 * @return porContiCd
	 */
	public String getPorContiCd() {
		return this.porContiCd;
	}

	/**
	 * Column Info
	 * @return cltOfrtAmt
	 */
	public String getCltOfrtAmt() {
		return this.cltOfrtAmt;
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
	 * @param porAr
	 */
	public void setPorAr(String porAr) {
		this.porAr = porAr;
	}

	/**
	 * Column Info
	 * @param polAr
	 */
	public void setPolAr(String polAr) {
		this.polAr = polAr;
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
	 * @param polFinc
	 */
	public void setPolFinc(String polFinc) {
		this.polFinc = polFinc;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Column Info
	 * @param commProcRsltRsn
	 */
	public void setCommProcRsltRsn(String commProcRsltRsn) {
		this.commProcRsltRsn = commProcRsltRsn;
	}

	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}

	/**
	 * Column Info
	 * @param apOfcCd
	 */
	public void setApOfcCd(String apOfcCd) {
		this.apOfcCd = apOfcCd;
	}

	/**
	 * Column Info
	 * @param porFinc
	 */
	public void setPorFinc(String porFinc) {
		this.porFinc = porFinc;
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
	 * @param podContiCd
	 */
	public void setPodContiCd(String podContiCd) {
		this.podContiCd = podContiCd;
	}

	/**
	 * Column Info
	 * @param podAr
	 */
	public void setPodAr(String podAr) {
		this.podAr = podAr;
	}

	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param polContiCd
	 */
	public void setPolContiCd(String polContiCd) {
		this.polContiCd = polContiCd;
	}

	/**
	 * Column Info
	 * @param ppdOfrtAmt
	 */
	public void setPpdOfrtAmt(String ppdOfrtAmt) {
		this.ppdOfrtAmt = ppdOfrtAmt;
	}

	/**
	 * Column Info
	 * @param cltChgAmt
	 */
	public void setCltChgAmt(String cltChgAmt) {
		this.cltChgAmt = cltChgAmt;
	}

	/**
	 * Column Info
	 * @param bkgOfcAr
	 */
	public void setBkgOfcAr(String bkgOfcAr) {
		this.bkgOfcAr = bkgOfcAr;
	}

	/**
	 * Column Info
	 * @param delContiCd
	 */
	public void setDelContiCd(String delContiCd) {
		this.delContiCd = delContiCd;
	}

	/**
	 * Column Info
	 * @param delFinc
	 */
	public void setDelFinc(String delFinc) {
		this.delFinc = delFinc;
	}

	/**
	 * Column Info
	 * @param podFinc
	 */
	public void setPodFinc(String podFinc) {
		this.podFinc = podFinc;
	}

	/**
	 * Column Info
	 * @param ppdChgAmt
	 */
	public void setPpdChgAmt(String ppdChgAmt) {
		this.ppdChgAmt = ppdChgAmt;
	}

	/**
	 * Column Info
	 * @param apCtrCd
	 */
	public void setApCtrCd(String apCtrCd) {
		this.apCtrCd = apCtrCd;
	}

	/**
	 * Column Info
	 * @param delAr
	 */
	public void setDelAr(String delAr) {
		this.delAr = delAr;
	}

	/**
	 * Column Info
	 * @param porContiCd
	 */
	public void setPorContiCd(String porContiCd) {
		this.porContiCd = porContiCd;
	}

	/**
	 * Column Info
	 * @param cltOfrtAmt
	 */
	public void setCltOfrtAmt(String cltOfrtAmt) {
		this.cltOfrtAmt = cltOfrtAmt;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setPorAr(JSPUtil.getParameter(request, prefix + "por_ar", ""));
		setPolAr(JSPUtil.getParameter(request, prefix + "pol_ar", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolFinc(JSPUtil.getParameter(request, prefix + "pol_finc", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCommProcRsltRsn(JSPUtil.getParameter(request, prefix + "comm_proc_rslt_rsn", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setApOfcCd(JSPUtil.getParameter(request, prefix + "ap_ofc_cd", ""));
		setPorFinc(JSPUtil.getParameter(request, prefix + "por_finc", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPodContiCd(JSPUtil.getParameter(request, prefix + "pod_conti_cd", ""));
		setPodAr(JSPUtil.getParameter(request, prefix + "pod_ar", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolContiCd(JSPUtil.getParameter(request, prefix + "pol_conti_cd", ""));
		setPpdOfrtAmt(JSPUtil.getParameter(request, prefix + "ppd_ofrt_amt", ""));
		setCltChgAmt(JSPUtil.getParameter(request, prefix + "clt_chg_amt", ""));
		setBkgOfcAr(JSPUtil.getParameter(request, prefix + "bkg_ofc_ar", ""));
		setDelContiCd(JSPUtil.getParameter(request, prefix + "del_conti_cd", ""));
		setDelFinc(JSPUtil.getParameter(request, prefix + "del_finc", ""));
		setPodFinc(JSPUtil.getParameter(request, prefix + "pod_finc", ""));
		setPpdChgAmt(JSPUtil.getParameter(request, prefix + "ppd_chg_amt", ""));
		setApCtrCd(JSPUtil.getParameter(request, prefix + "ap_ctr_cd", ""));
		setDelAr(JSPUtil.getParameter(request, prefix + "del_ar", ""));
		setPorContiCd(JSPUtil.getParameter(request, prefix + "por_conti_cd", ""));
		setCltOfrtAmt(JSPUtil.getParameter(request, prefix + "clt_ofrt_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfficeCodeInfoVO[]
	 */
	public OfficeCodeInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return OfficeCodeInfoVO[]
	 */
	public OfficeCodeInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OfficeCodeInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] porAr = (JSPUtil.getParameter(request, prefix	+ "por_ar", length));
			String[] polAr = (JSPUtil.getParameter(request, prefix	+ "pol_ar", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polFinc = (JSPUtil.getParameter(request, prefix	+ "pol_finc", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] commProcRsltRsn = (JSPUtil.getParameter(request, prefix	+ "comm_proc_rslt_rsn", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] apOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ofc_cd", length));
			String[] porFinc = (JSPUtil.getParameter(request, prefix	+ "por_finc", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] podContiCd = (JSPUtil.getParameter(request, prefix	+ "pod_conti_cd", length));
			String[] podAr = (JSPUtil.getParameter(request, prefix	+ "pod_ar", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polContiCd = (JSPUtil.getParameter(request, prefix	+ "pol_conti_cd", length));
			String[] ppdOfrtAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_ofrt_amt", length));
			String[] cltChgAmt = (JSPUtil.getParameter(request, prefix	+ "clt_chg_amt", length));
			String[] bkgOfcAr = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_ar", length));
			String[] delContiCd = (JSPUtil.getParameter(request, prefix	+ "del_conti_cd", length));
			String[] delFinc = (JSPUtil.getParameter(request, prefix	+ "del_finc", length));
			String[] podFinc = (JSPUtil.getParameter(request, prefix	+ "pod_finc", length));
			String[] ppdChgAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_chg_amt", length));
			String[] apCtrCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctr_cd", length));
			String[] delAr = (JSPUtil.getParameter(request, prefix	+ "del_ar", length));
			String[] porContiCd = (JSPUtil.getParameter(request, prefix	+ "por_conti_cd", length));
			String[] cltOfrtAmt = (JSPUtil.getParameter(request, prefix	+ "clt_ofrt_amt", length));

			for (int i = 0; i < length; i++) {
				model = new OfficeCodeInfoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (porAr[i] != null)
					model.setPorAr(porAr[i]);
				if (polAr[i] != null)
					model.setPolAr(polAr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polFinc[i] != null)
					model.setPolFinc(polFinc[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (commProcRsltRsn[i] != null)
					model.setCommProcRsltRsn(commProcRsltRsn[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (apOfcCd[i] != null)
					model.setApOfcCd(apOfcCd[i]);
				if (porFinc[i] != null)
					model.setPorFinc(porFinc[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (podContiCd[i] != null)
					model.setPodContiCd(podContiCd[i]);
				if (podAr[i] != null)
					model.setPodAr(podAr[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polContiCd[i] != null)
					model.setPolContiCd(polContiCd[i]);
				if (ppdOfrtAmt[i] != null)
					model.setPpdOfrtAmt(ppdOfrtAmt[i]);
				if (cltChgAmt[i] != null)
					model.setCltChgAmt(cltChgAmt[i]);
				if (bkgOfcAr[i] != null)
					model.setBkgOfcAr(bkgOfcAr[i]);
				if (delContiCd[i] != null)
					model.setDelContiCd(delContiCd[i]);
				if (delFinc[i] != null)
					model.setDelFinc(delFinc[i]);
				if (podFinc[i] != null)
					model.setPodFinc(podFinc[i]);
				if (ppdChgAmt[i] != null)
					model.setPpdChgAmt(ppdChgAmt[i]);
				if (apCtrCd[i] != null)
					model.setApCtrCd(apCtrCd[i]);
				if (delAr[i] != null)
					model.setDelAr(delAr[i]);
				if (porContiCd[i] != null)
					model.setPorContiCd(porContiCd[i]);
				if (cltOfrtAmt[i] != null)
					model.setCltOfrtAmt(cltOfrtAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOfficeCodeInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OfficeCodeInfoVO[]
	 */
	public OfficeCodeInfoVO[] getOfficeCodeInfoVOs(){
		OfficeCodeInfoVO[] vos = (OfficeCodeInfoVO[])models.toArray(new OfficeCodeInfoVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAr = this.porAr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAr = this.polAr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polFinc = this.polFinc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commProcRsltRsn = this.commProcRsltRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd = this.apOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porFinc = this.porFinc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podContiCd = this.podContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAr = this.podAr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polContiCd = this.polContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdOfrtAmt = this.ppdOfrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltChgAmt = this.cltChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcAr = this.bkgOfcAr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delContiCd = this.delContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFinc = this.delFinc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podFinc = this.podFinc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdChgAmt = this.ppdChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCtrCd = this.apCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delAr = this.delAr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porContiCd = this.porContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfrtAmt = this.cltOfrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
