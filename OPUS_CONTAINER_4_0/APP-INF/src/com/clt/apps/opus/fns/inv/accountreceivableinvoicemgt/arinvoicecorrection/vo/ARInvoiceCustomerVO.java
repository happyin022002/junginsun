/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCustomerVO.java
*@FileTitle : ARInvoiceCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.09 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARInvoiceCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInvoiceCustomerVO> models = new ArrayList<ARInvoiceCustomerVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String fwdrCustNm = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fwdrCustCntCd = null;
	/* Column Info */
	private String fwdrCustSeq = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String shprCustAddr = null;
	/* Column Info */
	private String shprCustNm = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String blInvIfDt = null;
	/* Column Info */
	private String glEffDt = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String sailDt = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String blInvCfmDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String shprCustCntCd = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String shprCustSeq = null;
	/* Column Info */
	private String fwdrCustAddr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARInvoiceCustomerVO() {}

	public ARInvoiceCustomerVO(String ibflag, String pagerows, String actCustCntCd, String actCustSeq, String custLglEngNm, String vvd, String svcScpCd, String porCd, String polCd, String podCd, String delCd, String blSrcNo, String arIfNo, String bkgNo, String shprCustCntCd, String shprCustSeq, String shprCustNm, String shprCustAddr, String fwdrCustCntCd, String fwdrCustSeq, String fwdrCustNm, String fwdrCustAddr, String blInvIfDt, String custNm, String invRmk, String blInvCfmDt, String sailArrDt, String ioBndCd, String arOfcCd, String glEffDt, String sailDt) {
		this.porCd = porCd;
		this.fwdrCustNm = fwdrCustNm;
		this.custNm = custNm;
		this.svcScpCd = svcScpCd;
		this.sailArrDt = sailArrDt;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.fwdrCustCntCd = fwdrCustCntCd;
		this.fwdrCustSeq = fwdrCustSeq;
		this.arIfNo = arIfNo;
		this.actCustCntCd = actCustCntCd;
		this.shprCustAddr = shprCustAddr;
		this.shprCustNm = shprCustNm;
		this.blSrcNo = blSrcNo;
		this.blInvIfDt = blInvIfDt;
		this.glEffDt = glEffDt;
		this.actCustSeq = actCustSeq;
		this.delCd = delCd;
		this.ioBndCd = ioBndCd;
		this.arOfcCd = arOfcCd;
		this.sailDt = sailDt;
		this.custLglEngNm = custLglEngNm;
		this.podCd = podCd;
		this.vvd = vvd;
		this.blInvCfmDt = blInvCfmDt;
		this.bkgNo = bkgNo;
		this.shprCustCntCd = shprCustCntCd;
		this.invRmk = invRmk;
		this.shprCustSeq = shprCustSeq;
		this.fwdrCustAddr = fwdrCustAddr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("fwdr_cust_nm", getFwdrCustNm());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fwdr_cust_cnt_cd", getFwdrCustCntCd());
		this.hashColumns.put("fwdr_cust_seq", getFwdrCustSeq());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("shpr_cust_addr", getShprCustAddr());
		this.hashColumns.put("shpr_cust_nm", getShprCustNm());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("bl_inv_if_dt", getBlInvIfDt());
		this.hashColumns.put("gl_eff_dt", getGlEffDt());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("sail_dt", getSailDt());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bl_inv_cfm_dt", getBlInvCfmDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("shpr_cust_cnt_cd", getShprCustCntCd());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("shpr_cust_seq", getShprCustSeq());
		this.hashColumns.put("fwdr_cust_addr", getFwdrCustAddr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("fwdr_cust_nm", "fwdrCustNm");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fwdr_cust_cnt_cd", "fwdrCustCntCd");
		this.hashFields.put("fwdr_cust_seq", "fwdrCustSeq");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("shpr_cust_addr", "shprCustAddr");
		this.hashFields.put("shpr_cust_nm", "shprCustNm");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("bl_inv_if_dt", "blInvIfDt");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bl_inv_cfm_dt", "blInvCfmDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("shpr_cust_cnt_cd", "shprCustCntCd");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("shpr_cust_seq", "shprCustSeq");
		this.hashFields.put("fwdr_cust_addr", "fwdrCustAddr");
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
	 * @return fwdrCustNm
	 */
	public String getFwdrCustNm() {
		return this.fwdrCustNm;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
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
	 * @return fwdrCustCntCd
	 */
	public String getFwdrCustCntCd() {
		return this.fwdrCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return fwdrCustSeq
	 */
	public String getFwdrCustSeq() {
		return this.fwdrCustSeq;
	}
	
	/**
	 * Column Info
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return shprCustAddr
	 */
	public String getShprCustAddr() {
		return this.shprCustAddr;
	}
	
	/**
	 * Column Info
	 * @return shprCustNm
	 */
	public String getShprCustNm() {
		return this.shprCustNm;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return blInvIfDt
	 */
	public String getBlInvIfDt() {
		return this.blInvIfDt;
	}
	
	/**
	 * Column Info
	 * @return glEffDt
	 */
	public String getGlEffDt() {
		return this.glEffDt;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return sailDt
	 */
	public String getSailDt() {
		return this.sailDt;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return blInvCfmDt
	 */
	public String getBlInvCfmDt() {
		return this.blInvCfmDt;
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
	 * @return shprCustCntCd
	 */
	public String getShprCustCntCd() {
		return this.shprCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return invRmk
	 */
	public String getInvRmk() {
		return this.invRmk;
	}
	
	/**
	 * Column Info
	 * @return shprCustSeq
	 */
	public String getShprCustSeq() {
		return this.shprCustSeq;
	}
	
	/**
	 * Column Info
	 * @return fwdrCustAddr
	 */
	public String getFwdrCustAddr() {
		return this.fwdrCustAddr;
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
	 * @param fwdrCustNm
	 */
	public void setFwdrCustNm(String fwdrCustNm) {
		this.fwdrCustNm = fwdrCustNm;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
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
	 * @param fwdrCustCntCd
	 */
	public void setFwdrCustCntCd(String fwdrCustCntCd) {
		this.fwdrCustCntCd = fwdrCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param fwdrCustSeq
	 */
	public void setFwdrCustSeq(String fwdrCustSeq) {
		this.fwdrCustSeq = fwdrCustSeq;
	}
	
	/**
	 * Column Info
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param shprCustAddr
	 */
	public void setShprCustAddr(String shprCustAddr) {
		this.shprCustAddr = shprCustAddr;
	}
	
	/**
	 * Column Info
	 * @param shprCustNm
	 */
	public void setShprCustNm(String shprCustNm) {
		this.shprCustNm = shprCustNm;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param blInvIfDt
	 */
	public void setBlInvIfDt(String blInvIfDt) {
		this.blInvIfDt = blInvIfDt;
	}
	
	/**
	 * Column Info
	 * @param glEffDt
	 */
	public void setGlEffDt(String glEffDt) {
		this.glEffDt = glEffDt;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param sailDt
	 */
	public void setSailDt(String sailDt) {
		this.sailDt = sailDt;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param blInvCfmDt
	 */
	public void setBlInvCfmDt(String blInvCfmDt) {
		this.blInvCfmDt = blInvCfmDt;
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
	 * @param shprCustCntCd
	 */
	public void setShprCustCntCd(String shprCustCntCd) {
		this.shprCustCntCd = shprCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param invRmk
	 */
	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
	}
	
	/**
	 * Column Info
	 * @param shprCustSeq
	 */
	public void setShprCustSeq(String shprCustSeq) {
		this.shprCustSeq = shprCustSeq;
	}
	
	/**
	 * Column Info
	 * @param fwdrCustAddr
	 */
	public void setFwdrCustAddr(String fwdrCustAddr) {
		this.fwdrCustAddr = fwdrCustAddr;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setFwdrCustNm(JSPUtil.getParameter(request, "fwdr_cust_nm", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFwdrCustCntCd(JSPUtil.getParameter(request, "fwdr_cust_cnt_cd", ""));
		setFwdrCustSeq(JSPUtil.getParameter(request, "fwdr_cust_seq", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setShprCustAddr(JSPUtil.getParameter(request, "shpr_cust_addr", ""));
		setShprCustNm(JSPUtil.getParameter(request, "shpr_cust_nm", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setBlInvIfDt(JSPUtil.getParameter(request, "bl_inv_if_dt", ""));
		setGlEffDt(JSPUtil.getParameter(request, "gl_eff_dt", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setSailDt(JSPUtil.getParameter(request, "sail_dt", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setBlInvCfmDt(JSPUtil.getParameter(request, "bl_inv_cfm_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setShprCustCntCd(JSPUtil.getParameter(request, "shpr_cust_cnt_cd", ""));
		setInvRmk(JSPUtil.getParameter(request, "inv_rmk", ""));
		setShprCustSeq(JSPUtil.getParameter(request, "shpr_cust_seq", ""));
		setFwdrCustAddr(JSPUtil.getParameter(request, "fwdr_cust_addr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInvoiceCustomerVO[]
	 */
	public ARInvoiceCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARInvoiceCustomerVO[]
	 */
	public ARInvoiceCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInvoiceCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] fwdrCustNm = (JSPUtil.getParameter(request, prefix	+ "fwdr_cust_nm", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fwdrCustCntCd = (JSPUtil.getParameter(request, prefix	+ "fwdr_cust_cnt_cd", length));
			String[] fwdrCustSeq = (JSPUtil.getParameter(request, prefix	+ "fwdr_cust_seq", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] shprCustAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_addr", length));
			String[] shprCustNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_nm", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] blInvIfDt = (JSPUtil.getParameter(request, prefix	+ "bl_inv_if_dt", length));
			String[] glEffDt = (JSPUtil.getParameter(request, prefix	+ "gl_eff_dt", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] sailDt = (JSPUtil.getParameter(request, prefix	+ "sail_dt", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] blInvCfmDt = (JSPUtil.getParameter(request, prefix	+ "bl_inv_cfm_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] shprCustCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_cnt_cd", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] shprCustSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_seq", length));
			String[] fwdrCustAddr = (JSPUtil.getParameter(request, prefix	+ "fwdr_cust_addr", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARInvoiceCustomerVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (fwdrCustNm[i] != null)
					model.setFwdrCustNm(fwdrCustNm[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fwdrCustCntCd[i] != null)
					model.setFwdrCustCntCd(fwdrCustCntCd[i]);
				if (fwdrCustSeq[i] != null)
					model.setFwdrCustSeq(fwdrCustSeq[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (shprCustAddr[i] != null)
					model.setShprCustAddr(shprCustAddr[i]);
				if (shprCustNm[i] != null)
					model.setShprCustNm(shprCustNm[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (blInvIfDt[i] != null)
					model.setBlInvIfDt(blInvIfDt[i]);
				if (glEffDt[i] != null)
					model.setGlEffDt(glEffDt[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (sailDt[i] != null)
					model.setSailDt(sailDt[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (blInvCfmDt[i] != null)
					model.setBlInvCfmDt(blInvCfmDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (shprCustCntCd[i] != null)
					model.setShprCustCntCd(shprCustCntCd[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (shprCustSeq[i] != null)
					model.setShprCustSeq(shprCustSeq[i]);
				if (fwdrCustAddr[i] != null)
					model.setFwdrCustAddr(fwdrCustAddr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARInvoiceCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARInvoiceCustomerVO[]
	 */
	public ARInvoiceCustomerVO[] getARInvoiceCustomerVOs(){
		ARInvoiceCustomerVO[] vos = (ARInvoiceCustomerVO[])models.toArray(new ARInvoiceCustomerVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdrCustNm = this.fwdrCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdrCustCntCd = this.fwdrCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdrCustSeq = this.fwdrCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustAddr = this.shprCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustNm = this.shprCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvIfDt = this.blInvIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt = this.glEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt = this.sailDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvCfmDt = this.blInvCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustCntCd = this.shprCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustSeq = this.shprCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdrCustAddr = this.fwdrCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
