/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualInvoiceIssuedListVO.java
*@FileTitle : ManualInvoiceIssuedListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.10.06 문중철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ManualInvoiceIssuedListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManualInvoiceIssuedListVO> models = new ArrayList<ManualInvoiceIssuedListVO>();
	
	/* Column Info */
	private String reason = null;
	/* Column Info */
	private String bkgr = null;
	/* Column Info */
	private String payrcd = null;
	/* Column Info */
	private String bllamt = null;
	/* Column Info */
	private String dcamt = null;
	/* Column Info */
	private String ifnm = null;
	/* Column Info */
	private String arif = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invcur = null;
	/* Column Info */
	private String porcd = null;
	/* Column Info */
	private String payrnm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String delcd = null;
	/* Column Info */
	private String bkgd = null;
	/* Column Info */
	private String invno = null;
	/* Column Info */
	private String tariff = null;
	/* Column Info */
	private String issnm = null;
	/* Column Info */
	private String totamt = null;
	/* Column Info */
	private String podcd = null;
	/* Column Info */
	private String bkgno = null;
	/* Column Info */
	private String ifdt = null;
	/* Column Info */
	private String blno = null;
	/* Column Info */
	private String ifofc = null;
	/* Column Info */
	private String scno = null;
	/* Column Info */
	private String cntr = null;
	/* Column Info */
	private String crdref = null;
	/* Column Info */
	private String polcd = null;
	/* Column Info */
	private String taxamt = null;
	/* Column Info */
	private String stscd = null;
	/* Column Info */
	private String rmrk = null;
	/* Column Info */
	private String issdt = null;
	/* Column Info */
	private String rafno = null;
	/* Column Info */
	private String payamt = null;
	/* Column Info */
	private String issofc = null;
	/* Column Info */
	private String vvdcd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ManualInvoiceIssuedListVO() {}

	public ManualInvoiceIssuedListVO(String ibflag, String pagerows, String issofc, String reason, String tariff, String invno, String arif, String stscd, String cntr, String invcur, String totamt, String dcamt, String bllamt, String taxamt, String payamt, String bkgno, String blno, String vvdcd, String porcd, String polcd, String podcd, String delcd, String bkgr, String bkgd, String scno, String rafno, String issdt, String issnm, String ifdt, String ifofc, String ifnm, String payrcd, String payrnm, String crdref, String rmrk) {
		this.reason = reason;
		this.bkgr = bkgr;
		this.payrcd = payrcd;
		this.bllamt = bllamt;
		this.dcamt = dcamt;
		this.ifnm = ifnm;
		this.arif = arif;
		this.pagerows = pagerows;
		this.invcur = invcur;
		this.porcd = porcd;
		this.payrnm = payrnm;
		this.ibflag = ibflag;
		this.delcd = delcd;
		this.bkgd = bkgd;
		this.invno = invno;
		this.tariff = tariff;
		this.issnm = issnm;
		this.totamt = totamt;
		this.podcd = podcd;
		this.bkgno = bkgno;
		this.ifdt = ifdt;
		this.blno = blno;
		this.ifofc = ifofc;
		this.scno = scno;
		this.cntr = cntr;
		this.crdref = crdref;
		this.polcd = polcd;
		this.taxamt = taxamt;
		this.stscd = stscd;
		this.rmrk = rmrk;
		this.issdt = issdt;
		this.rafno = rafno;
		this.payamt = payamt;
		this.issofc = issofc;
		this.vvdcd = vvdcd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("reason", getReason());
		this.hashColumns.put("bkgr", getBkgr());
		this.hashColumns.put("payrcd", getPayrcd());
		this.hashColumns.put("bllamt", getBllamt());
		this.hashColumns.put("dcamt", getDcamt());
		this.hashColumns.put("ifnm", getIfnm());
		this.hashColumns.put("arif", getArif());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("invcur", getInvcur());
		this.hashColumns.put("porcd", getPorcd());
		this.hashColumns.put("payrnm", getPayrnm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("delcd", getDelcd());
		this.hashColumns.put("bkgd", getBkgd());
		this.hashColumns.put("invno", getInvno());
		this.hashColumns.put("tariff", getTariff());
		this.hashColumns.put("issnm", getIssnm());
		this.hashColumns.put("totamt", getTotamt());
		this.hashColumns.put("podcd", getPodcd());
		this.hashColumns.put("bkgno", getBkgno());
		this.hashColumns.put("ifdt", getIfdt());
		this.hashColumns.put("blno", getBlno());
		this.hashColumns.put("ifofc", getIfofc());
		this.hashColumns.put("scno", getScno());
		this.hashColumns.put("cntr", getCntr());
		this.hashColumns.put("crdref", getCrdref());
		this.hashColumns.put("polcd", getPolcd());
		this.hashColumns.put("taxamt", getTaxamt());
		this.hashColumns.put("stscd", getStscd());
		this.hashColumns.put("rmrk", getRmrk());
		this.hashColumns.put("issdt", getIssdt());
		this.hashColumns.put("rafno", getRafno());
		this.hashColumns.put("payamt", getPayamt());
		this.hashColumns.put("issofc", getIssofc());
		this.hashColumns.put("vvdcd", getVvdcd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("reason", "reason");
		this.hashFields.put("bkgr", "bkgr");
		this.hashFields.put("payrcd", "payrcd");
		this.hashFields.put("bllamt", "bllamt");
		this.hashFields.put("dcamt", "dcamt");
		this.hashFields.put("ifnm", "ifnm");
		this.hashFields.put("arif", "arif");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("invcur", "invcur");
		this.hashFields.put("porcd", "porcd");
		this.hashFields.put("payrnm", "payrnm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("delcd", "delcd");
		this.hashFields.put("bkgd", "bkgd");
		this.hashFields.put("invno", "invno");
		this.hashFields.put("tariff", "tariff");
		this.hashFields.put("issnm", "issnm");
		this.hashFields.put("totamt", "totamt");
		this.hashFields.put("podcd", "podcd");
		this.hashFields.put("bkgno", "bkgno");
		this.hashFields.put("ifdt", "ifdt");
		this.hashFields.put("blno", "blno");
		this.hashFields.put("ifofc", "ifofc");
		this.hashFields.put("scno", "scno");
		this.hashFields.put("cntr", "cntr");
		this.hashFields.put("crdref", "crdref");
		this.hashFields.put("polcd", "polcd");
		this.hashFields.put("taxamt", "taxamt");
		this.hashFields.put("stscd", "stscd");
		this.hashFields.put("rmrk", "rmrk");
		this.hashFields.put("issdt", "issdt");
		this.hashFields.put("rafno", "rafno");
		this.hashFields.put("payamt", "payamt");
		this.hashFields.put("issofc", "issofc");
		this.hashFields.put("vvdcd", "vvdcd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return reason
	 */
	public String getReason() {
		return this.reason;
	}
	
	/**
	 * Column Info
	 * @return bkgr
	 */
	public String getBkgr() {
		return this.bkgr;
	}
	
	/**
	 * Column Info
	 * @return payrcd
	 */
	public String getPayrcd() {
		return this.payrcd;
	}
	
	/**
	 * Column Info
	 * @return bllamt
	 */
	public String getBllamt() {
		return this.bllamt;
	}
	
	/**
	 * Column Info
	 * @return dcamt
	 */
	public String getDcamt() {
		return this.dcamt;
	}
	
	/**
	 * Column Info
	 * @return ifnm
	 */
	public String getIfnm() {
		return this.ifnm;
	}
	
	/**
	 * Column Info
	 * @return arif
	 */
	public String getArif() {
		return this.arif;
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
	 * @return invcur
	 */
	public String getInvcur() {
		return this.invcur;
	}
	
	/**
	 * Column Info
	 * @return porcd
	 */
	public String getPorcd() {
		return this.porcd;
	}
	
	/**
	 * Column Info
	 * @return payrnm
	 */
	public String getPayrnm() {
		return this.payrnm;
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
	 * @return delcd
	 */
	public String getDelcd() {
		return this.delcd;
	}
	
	/**
	 * Column Info
	 * @return bkgd
	 */
	public String getBkgd() {
		return this.bkgd;
	}
	
	/**
	 * Column Info
	 * @return invno
	 */
	public String getInvno() {
		return this.invno;
	}
	
	/**
	 * Column Info
	 * @return tariff
	 */
	public String getTariff() {
		return this.tariff;
	}
	
	/**
	 * Column Info
	 * @return issnm
	 */
	public String getIssnm() {
		return this.issnm;
	}
	
	/**
	 * Column Info
	 * @return totamt
	 */
	public String getTotamt() {
		return this.totamt;
	}
	
	/**
	 * Column Info
	 * @return podcd
	 */
	public String getPodcd() {
		return this.podcd;
	}
	
	/**
	 * Column Info
	 * @return bkgno
	 */
	public String getBkgno() {
		return this.bkgno;
	}
	
	/**
	 * Column Info
	 * @return ifdt
	 */
	public String getIfdt() {
		return this.ifdt;
	}
	
	/**
	 * Column Info
	 * @return blno
	 */
	public String getBlno() {
		return this.blno;
	}
	
	/**
	 * Column Info
	 * @return ifofc
	 */
	public String getIfofc() {
		return this.ifofc;
	}
	
	/**
	 * Column Info
	 * @return scno
	 */
	public String getScno() {
		return this.scno;
	}
	
	/**
	 * Column Info
	 * @return cntr
	 */
	public String getCntr() {
		return this.cntr;
	}
	
	/**
	 * Column Info
	 * @return crdref
	 */
	public String getCrdref() {
		return this.crdref;
	}
	
	/**
	 * Column Info
	 * @return polcd
	 */
	public String getPolcd() {
		return this.polcd;
	}
	
	/**
	 * Column Info
	 * @return taxamt
	 */
	public String getTaxamt() {
		return this.taxamt;
	}
	
	/**
	 * Column Info
	 * @return stscd
	 */
	public String getStscd() {
		return this.stscd;
	}
	
	/**
	 * Column Info
	 * @return rmrk
	 */
	public String getRmrk() {
		return this.rmrk;
	}
	
	/**
	 * Column Info
	 * @return issdt
	 */
	public String getIssdt() {
		return this.issdt;
	}
	
	/**
	 * Column Info
	 * @return rafno
	 */
	public String getRafno() {
		return this.rafno;
	}
	
	/**
	 * Column Info
	 * @return payamt
	 */
	public String getPayamt() {
		return this.payamt;
	}
	
	/**
	 * Column Info
	 * @return issofc
	 */
	public String getIssofc() {
		return this.issofc;
	}
	
	/**
	 * Column Info
	 * @return vvdcd
	 */
	public String getVvdcd() {
		return this.vvdcd;
	}
	

	/**
	 * Column Info
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	/**
	 * Column Info
	 * @param bkgr
	 */
	public void setBkgr(String bkgr) {
		this.bkgr = bkgr;
	}
	
	/**
	 * Column Info
	 * @param payrcd
	 */
	public void setPayrcd(String payrcd) {
		this.payrcd = payrcd;
	}
	
	/**
	 * Column Info
	 * @param bllamt
	 */
	public void setBllamt(String bllamt) {
		this.bllamt = bllamt;
	}
	
	/**
	 * Column Info
	 * @param dcamt
	 */
	public void setDcamt(String dcamt) {
		this.dcamt = dcamt;
	}
	
	/**
	 * Column Info
	 * @param ifnm
	 */
	public void setIfnm(String ifnm) {
		this.ifnm = ifnm;
	}
	
	/**
	 * Column Info
	 * @param arif
	 */
	public void setArif(String arif) {
		this.arif = arif;
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
	 * @param invcur
	 */
	public void setInvcur(String invcur) {
		this.invcur = invcur;
	}
	
	/**
	 * Column Info
	 * @param porcd
	 */
	public void setPorcd(String porcd) {
		this.porcd = porcd;
	}
	
	/**
	 * Column Info
	 * @param payrnm
	 */
	public void setPayrnm(String payrnm) {
		this.payrnm = payrnm;
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
	 * @param delcd
	 */
	public void setDelcd(String delcd) {
		this.delcd = delcd;
	}
	
	/**
	 * Column Info
	 * @param bkgd
	 */
	public void setBkgd(String bkgd) {
		this.bkgd = bkgd;
	}
	
	/**
	 * Column Info
	 * @param invno
	 */
	public void setInvno(String invno) {
		this.invno = invno;
	}
	
	/**
	 * Column Info
	 * @param tariff
	 */
	public void setTariff(String tariff) {
		this.tariff = tariff;
	}
	
	/**
	 * Column Info
	 * @param issnm
	 */
	public void setIssnm(String issnm) {
		this.issnm = issnm;
	}
	
	/**
	 * Column Info
	 * @param totamt
	 */
	public void setTotamt(String totamt) {
		this.totamt = totamt;
	}
	
	/**
	 * Column Info
	 * @param podcd
	 */
	public void setPodcd(String podcd) {
		this.podcd = podcd;
	}
	
	/**
	 * Column Info
	 * @param bkgno
	 */
	public void setBkgno(String bkgno) {
		this.bkgno = bkgno;
	}
	
	/**
	 * Column Info
	 * @param ifdt
	 */
	public void setIfdt(String ifdt) {
		this.ifdt = ifdt;
	}
	
	/**
	 * Column Info
	 * @param blno
	 */
	public void setBlno(String blno) {
		this.blno = blno;
	}
	
	/**
	 * Column Info
	 * @param ifofc
	 */
	public void setIfofc(String ifofc) {
		this.ifofc = ifofc;
	}
	
	/**
	 * Column Info
	 * @param scno
	 */
	public void setScno(String scno) {
		this.scno = scno;
	}
	
	/**
	 * Column Info
	 * @param cntr
	 */
	public void setCntr(String cntr) {
		this.cntr = cntr;
	}
	
	/**
	 * Column Info
	 * @param crdref
	 */
	public void setCrdref(String crdref) {
		this.crdref = crdref;
	}
	
	/**
	 * Column Info
	 * @param polcd
	 */
	public void setPolcd(String polcd) {
		this.polcd = polcd;
	}
	
	/**
	 * Column Info
	 * @param taxamt
	 */
	public void setTaxamt(String taxamt) {
		this.taxamt = taxamt;
	}
	
	/**
	 * Column Info
	 * @param stscd
	 */
	public void setStscd(String stscd) {
		this.stscd = stscd;
	}
	
	/**
	 * Column Info
	 * @param rmrk
	 */
	public void setRmrk(String rmrk) {
		this.rmrk = rmrk;
	}
	
	/**
	 * Column Info
	 * @param issdt
	 */
	public void setIssdt(String issdt) {
		this.issdt = issdt;
	}
	
	/**
	 * Column Info
	 * @param rafno
	 */
	public void setRafno(String rafno) {
		this.rafno = rafno;
	}
	
	/**
	 * Column Info
	 * @param payamt
	 */
	public void setPayamt(String payamt) {
		this.payamt = payamt;
	}
	
	/**
	 * Column Info
	 * @param issofc
	 */
	public void setIssofc(String issofc) {
		this.issofc = issofc;
	}
	
	/**
	 * Column Info
	 * @param vvdcd
	 */
	public void setVvdcd(String vvdcd) {
		this.vvdcd = vvdcd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setReason(JSPUtil.getParameter(request, "reason", ""));
		setBkgr(JSPUtil.getParameter(request, "bkgr", ""));
		setPayrcd(JSPUtil.getParameter(request, "payrcd", ""));
		setBllamt(JSPUtil.getParameter(request, "bllamt", ""));
		setDcamt(JSPUtil.getParameter(request, "dcamt", ""));
		setIfnm(JSPUtil.getParameter(request, "ifnm", ""));
		setArif(JSPUtil.getParameter(request, "arif", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvcur(JSPUtil.getParameter(request, "invcur", ""));
		setPorcd(JSPUtil.getParameter(request, "porcd", ""));
		setPayrnm(JSPUtil.getParameter(request, "payrnm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDelcd(JSPUtil.getParameter(request, "delcd", ""));
		setBkgd(JSPUtil.getParameter(request, "bkgd", ""));
		setInvno(JSPUtil.getParameter(request, "invno", ""));
		setTariff(JSPUtil.getParameter(request, "tariff", ""));
		setIssnm(JSPUtil.getParameter(request, "issnm", ""));
		setTotamt(JSPUtil.getParameter(request, "totamt", ""));
		setPodcd(JSPUtil.getParameter(request, "podcd", ""));
		setBkgno(JSPUtil.getParameter(request, "bkgno", ""));
		setIfdt(JSPUtil.getParameter(request, "ifdt", ""));
		setBlno(JSPUtil.getParameter(request, "blno", ""));
		setIfofc(JSPUtil.getParameter(request, "ifofc", ""));
		setScno(JSPUtil.getParameter(request, "scno", ""));
		setCntr(JSPUtil.getParameter(request, "cntr", ""));
		setCrdref(JSPUtil.getParameter(request, "crdref", ""));
		setPolcd(JSPUtil.getParameter(request, "polcd", ""));
		setTaxamt(JSPUtil.getParameter(request, "taxamt", ""));
		setStscd(JSPUtil.getParameter(request, "stscd", ""));
		setRmrk(JSPUtil.getParameter(request, "rmrk", ""));
		setIssdt(JSPUtil.getParameter(request, "issdt", ""));
		setRafno(JSPUtil.getParameter(request, "rafno", ""));
		setPayamt(JSPUtil.getParameter(request, "payamt", ""));
		setIssofc(JSPUtil.getParameter(request, "issofc", ""));
		setVvdcd(JSPUtil.getParameter(request, "vvdcd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManualInvoiceIssuedListVO[]
	 */
	public ManualInvoiceIssuedListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManualInvoiceIssuedListVO[]
	 */
	public ManualInvoiceIssuedListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManualInvoiceIssuedListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] reason = (JSPUtil.getParameter(request, prefix	+ "reason", length));
			String[] bkgr = (JSPUtil.getParameter(request, prefix	+ "bkgr", length));
			String[] payrcd = (JSPUtil.getParameter(request, prefix	+ "payrcd", length));
			String[] bllamt = (JSPUtil.getParameter(request, prefix	+ "bllamt", length));
			String[] dcamt = (JSPUtil.getParameter(request, prefix	+ "dcamt", length));
			String[] ifnm = (JSPUtil.getParameter(request, prefix	+ "ifnm", length));
			String[] arif = (JSPUtil.getParameter(request, prefix	+ "arif", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invcur = (JSPUtil.getParameter(request, prefix	+ "invcur", length));
			String[] porcd = (JSPUtil.getParameter(request, prefix	+ "porcd", length));
			String[] payrnm = (JSPUtil.getParameter(request, prefix	+ "payrnm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] delcd = (JSPUtil.getParameter(request, prefix	+ "delcd", length));
			String[] bkgd = (JSPUtil.getParameter(request, prefix	+ "bkgd", length));
			String[] invno = (JSPUtil.getParameter(request, prefix	+ "invno", length));
			String[] tariff = (JSPUtil.getParameter(request, prefix	+ "tariff", length));
			String[] issnm = (JSPUtil.getParameter(request, prefix	+ "issnm", length));
			String[] totamt = (JSPUtil.getParameter(request, prefix	+ "totamt", length));
			String[] podcd = (JSPUtil.getParameter(request, prefix	+ "podcd", length));
			String[] bkgno = (JSPUtil.getParameter(request, prefix	+ "bkgno", length));
			String[] ifdt = (JSPUtil.getParameter(request, prefix	+ "ifdt", length));
			String[] blno = (JSPUtil.getParameter(request, prefix	+ "blno", length));
			String[] ifofc = (JSPUtil.getParameter(request, prefix	+ "ifofc", length));
			String[] scno = (JSPUtil.getParameter(request, prefix	+ "scno", length));
			String[] cntr = (JSPUtil.getParameter(request, prefix	+ "cntr", length));
			String[] crdref = (JSPUtil.getParameter(request, prefix	+ "crdref", length));
			String[] polcd = (JSPUtil.getParameter(request, prefix	+ "polcd", length));
			String[] taxamt = (JSPUtil.getParameter(request, prefix	+ "taxamt", length));
			String[] stscd = (JSPUtil.getParameter(request, prefix	+ "stscd", length));
			String[] rmrk = (JSPUtil.getParameter(request, prefix	+ "rmrk", length));
			String[] issdt = (JSPUtil.getParameter(request, prefix	+ "issdt", length));
			String[] rafno = (JSPUtil.getParameter(request, prefix	+ "rafno", length));
			String[] payamt = (JSPUtil.getParameter(request, prefix	+ "payamt", length));
			String[] issofc = (JSPUtil.getParameter(request, prefix	+ "issofc", length));
			String[] vvdcd = (JSPUtil.getParameter(request, prefix	+ "vvdcd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManualInvoiceIssuedListVO();
				if (reason[i] != null)
					model.setReason(reason[i]);
				if (bkgr[i] != null)
					model.setBkgr(bkgr[i]);
				if (payrcd[i] != null)
					model.setPayrcd(payrcd[i]);
				if (bllamt[i] != null)
					model.setBllamt(bllamt[i]);
				if (dcamt[i] != null)
					model.setDcamt(dcamt[i]);
				if (ifnm[i] != null)
					model.setIfnm(ifnm[i]);
				if (arif[i] != null)
					model.setArif(arif[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invcur[i] != null)
					model.setInvcur(invcur[i]);
				if (porcd[i] != null)
					model.setPorcd(porcd[i]);
				if (payrnm[i] != null)
					model.setPayrnm(payrnm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (delcd[i] != null)
					model.setDelcd(delcd[i]);
				if (bkgd[i] != null)
					model.setBkgd(bkgd[i]);
				if (invno[i] != null)
					model.setInvno(invno[i]);
				if (tariff[i] != null)
					model.setTariff(tariff[i]);
				if (issnm[i] != null)
					model.setIssnm(issnm[i]);
				if (totamt[i] != null)
					model.setTotamt(totamt[i]);
				if (podcd[i] != null)
					model.setPodcd(podcd[i]);
				if (bkgno[i] != null)
					model.setBkgno(bkgno[i]);
				if (ifdt[i] != null)
					model.setIfdt(ifdt[i]);
				if (blno[i] != null)
					model.setBlno(blno[i]);
				if (ifofc[i] != null)
					model.setIfofc(ifofc[i]);
				if (scno[i] != null)
					model.setScno(scno[i]);
				if (cntr[i] != null)
					model.setCntr(cntr[i]);
				if (crdref[i] != null)
					model.setCrdref(crdref[i]);
				if (polcd[i] != null)
					model.setPolcd(polcd[i]);
				if (taxamt[i] != null)
					model.setTaxamt(taxamt[i]);
				if (stscd[i] != null)
					model.setStscd(stscd[i]);
				if (rmrk[i] != null)
					model.setRmrk(rmrk[i]);
				if (issdt[i] != null)
					model.setIssdt(issdt[i]);
				if (rafno[i] != null)
					model.setRafno(rafno[i]);
				if (payamt[i] != null)
					model.setPayamt(payamt[i]);
				if (issofc[i] != null)
					model.setIssofc(issofc[i]);
				if (vvdcd[i] != null)
					model.setVvdcd(vvdcd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManualInvoiceIssuedListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManualInvoiceIssuedListVO[]
	 */
	public ManualInvoiceIssuedListVO[] getManualInvoiceIssuedListVOs(){
		ManualInvoiceIssuedListVO[] vos = (ManualInvoiceIssuedListVO[])models.toArray(new ManualInvoiceIssuedListVO[models.size()]);
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
		this.reason = this.reason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgr = this.bkgr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrcd = this.payrcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bllamt = this.bllamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcamt = this.dcamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifnm = this.ifnm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arif = this.arif .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invcur = this.invcur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porcd = this.porcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrnm = this.payrnm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delcd = this.delcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgd = this.bkgd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invno = this.invno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariff = this.tariff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issnm = this.issnm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totamt = this.totamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podcd = this.podcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgno = this.bkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifdt = this.ifdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blno = this.blno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifofc = this.ifofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scno = this.scno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr = this.cntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdref = this.crdref .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polcd = this.polcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxamt = this.taxamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stscd = this.stscd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmrk = this.rmrk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issdt = this.issdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rafno = this.rafno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payamt = this.payamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issofc = this.issofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdcd = this.vvdcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
