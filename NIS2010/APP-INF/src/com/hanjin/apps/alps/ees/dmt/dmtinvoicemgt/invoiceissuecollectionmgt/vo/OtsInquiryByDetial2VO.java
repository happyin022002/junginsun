/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OtsInquiryByDetialVO2.java
*@FileTitle : OtsInquiryByDetialVO2
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.09.24 문중철 
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

public class OtsInquiryByDetial2VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OtsInquiryByDetial2VO> models = new ArrayList<OtsInquiryByDetial2VO>();
	
	/* Column Info */
	private String loccdd = null;
	/* Column Info */
	private String blnooo = null;
	/* Column Info */
	private String overdy = null;
	/* Column Info */
	private String cntrno = null;
	/* Column Info */
	private String ftcmpl = null;
	/* Column Info */
	private String stpdfr = null;
	/* Column Info */
	private String freedy = null;
	/* Column Info */
	private String invnoo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String currcy = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oveday = null;
	/* Column Info */
	private String issudt = null;
	/* Column Info */
	private String charge = null;
	/* Column Info */
	private String netamt = null;
	/* Column Info */
	private String scnooo = null;
	/* Column Info */
	private String taxamt = null;
	/* Column Info */
	private String stpdto = null;
	/* Column Info */
	private String tyszcd = null;
	/* Column Info */
	private String totamt = null;
	/* Column Info */
	private String vvdcdd = null;
	/* Column Info */
	private String ftcmnc = null;
	/* Column Info */
	private String orgChgAmt = null;
	/* Column Info */
	private String cmdtExptAmt = null;
	/* Column Info */
	private String scRfaExptAmt = null;
	/* Column Info */
	private String aftExptDcAmt = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String shCustCd = null;
	/* Column Info */
	private String shCustNm = null;
	/* Column Info */
	private String cnCustCd = null;
	/* Column Info */
	private String cnCustNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String colCharge = null;
	/* Column Info */
	private String colTax = null;
	/* Column Info */
	private String colDate = null;
	/* Column Info */
	private String uncolAmt = null;
	/* Column Info */
	private String otsCltFlg = null;
	
	public String getOtsCltFlg() {
		return otsCltFlg;
	}

	public void setOtsCltFlg(String otsCltFlg) {
		this.otsCltFlg = otsCltFlg;
	}
	public String getColCharge() {
		return colCharge;
	}

	public void setColCharge(String colCharge) {
		this.colCharge = colCharge;
	}

	public String getColTax() {
		return colTax;
	}

	public void setColTax(String colTax) {
		this.colTax = colTax;
	}

	public String getColDate() {
		return colDate;
	}

	public void setColDate(String colDate) {
		this.colDate = colDate;
	}

	public String getUncolAmt() {
		return uncolAmt;
	}

	public void setUncolAmt(String uncolAmt) {
		this.uncolAmt = uncolAmt;
	}
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OtsInquiryByDetial2VO() {}

	public OtsInquiryByDetial2VO(String ibflag, String pagerows, String invnoo, String charge, String vvdcdd, String scnooo, String blnooo, String loccdd, String cntrno, String tyszcd, String stpdfr, String stpdto, String ftcmnc, String ftcmpl, String freedy, String overdy, String currcy, String netamt, String taxamt, String totamt, String issudt, String oveday, String orgChgAmt, String cmdtExptAmt, String scRfaExptAmt, String aftExptDcAmt, String invRmk, String rfaNo, String taaNo, String shCustCd, String shCustNm, String cnCustCd, String cnCustNm, String polCd, String podCd, String delCd, String colCharge, String colTax, String uncolAmt, String otsCltFlg, String colDate) {
		this.loccdd = loccdd;
		this.blnooo = blnooo;
		this.overdy = overdy;
		this.cntrno = cntrno;
		this.ftcmpl = ftcmpl;
		this.stpdfr = stpdfr;
		this.freedy = freedy;
		this.invnoo = invnoo;
		this.pagerows = pagerows;
		this.currcy = currcy;
		this.ibflag = ibflag;
		this.oveday = oveday;
		this.issudt = issudt;
		this.charge = charge;
		this.netamt = netamt;
		this.scnooo = scnooo;
		this.taxamt = taxamt;
		this.stpdto = stpdto;
		this.tyszcd = tyszcd;
		this.totamt = totamt;
		this.vvdcdd = vvdcdd;
		this.ftcmnc = ftcmnc;
		this.orgChgAmt = orgChgAmt;
		this.cmdtExptAmt = cmdtExptAmt;
		this.scRfaExptAmt = scRfaExptAmt;
		this.aftExptDcAmt = aftExptDcAmt;
		this.invRmk = invRmk;
		this.rfaNo = rfaNo;
		this.taaNo = taaNo;
		this.shCustCd = shCustCd;
		this.shCustNm = shCustNm;
		this.cnCustCd = cnCustCd;
		this.cnCustNm = cnCustNm;
		this.polCd = polCd;
		this.podCd = podCd;
		this.delCd = delCd;
		this.colCharge = colCharge; 
		this.colTax = colTax;
		this.colDate = colDate;
		this.uncolAmt = uncolAmt;
		this.otsCltFlg = otsCltFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loccdd", getLoccdd());
		this.hashColumns.put("blnooo", getBlnooo());
		this.hashColumns.put("overdy", getOverdy());
		this.hashColumns.put("cntrno", getCntrno());
		this.hashColumns.put("ftcmpl", getFtcmpl());
		this.hashColumns.put("stpdfr", getStpdfr());
		this.hashColumns.put("freedy", getFreedy());
		this.hashColumns.put("invnoo", getInvnoo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("currcy", getCurrcy());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("oveday", getOveday());
		this.hashColumns.put("issudt", getIssudt());
		this.hashColumns.put("charge", getCharge());
		this.hashColumns.put("netamt", getNetamt());
		this.hashColumns.put("scnooo", getScnooo());
		this.hashColumns.put("taxamt", getTaxamt());
		this.hashColumns.put("stpdto", getStpdto());
		this.hashColumns.put("tyszcd", getTyszcd());
		this.hashColumns.put("totamt", getTotamt());
		this.hashColumns.put("vvdcdd", getVvdcdd());
		this.hashColumns.put("ftcmnc", getFtcmnc());
		this.hashColumns.put("org_chg_amt", getOrgChgAmt());
		this.hashColumns.put("cmdt_expt_amt", getCmdtExptAmt());
		this.hashColumns.put("sc_rfa_expt_amt", getScRfaExptAmt());
		this.hashColumns.put("aft_expt_dc_amt", getAftExptDcAmt());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("sh_cust_cd", getShCustCd());
		this.hashColumns.put("sh_cust_nm", getShCustNm());
		this.hashColumns.put("cn_cust_cd", getCnCustCd());
		this.hashColumns.put("cn_cust_nm", getCnCustNm());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("col_charge", getColCharge());
		this.hashColumns.put("col_tax", getColTax());
		this.hashColumns.put("col_date", getColDate());
		this.hashColumns.put("uncol_amt", getUncolAmt());	
		this.hashColumns.put("ots_clt_flg", getOtsCltFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loccdd", "loccdd");
		this.hashFields.put("blnooo", "blnooo");
		this.hashFields.put("overdy", "overdy");
		this.hashFields.put("cntrno", "cntrno");
		this.hashFields.put("ftcmpl", "ftcmpl");
		this.hashFields.put("stpdfr", "stpdfr");
		this.hashFields.put("freedy", "freedy");
		this.hashFields.put("invnoo", "invnoo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("currcy", "currcy");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("oveday", "oveday");
		this.hashFields.put("issudt", "issudt");
		this.hashFields.put("charge", "charge");
		this.hashFields.put("netamt", "netamt");
		this.hashFields.put("scnooo", "scnooo");
		this.hashFields.put("taxamt", "taxamt");
		this.hashFields.put("stpdto", "stpdto");
		this.hashFields.put("tyszcd", "tyszcd");
		this.hashFields.put("totamt", "totamt");
		this.hashFields.put("vvdcdd", "vvdcdd");
		this.hashFields.put("ftcmnc", "ftcmnc");
		this.hashFields.put("org_chg_amt", "orgChgAmt");
		this.hashFields.put("cmdt_expt_amt", "cmdtExptAmt");
		this.hashFields.put("sc_rfa_expt_amt", "scRfaExptAmt");
		this.hashFields.put("aft_expt_dc_amt", "aftExptDcAmt");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("sh_cust_cd", "shCustCd");
		this.hashFields.put("sh_cust_nm", "shCustNm");
		this.hashFields.put("cn_cust_cd", "cnCustCd");
		this.hashFields.put("cn_cust_nm", "cnCustNm");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("col_charge", "colCharge");
		this.hashFields.put("col_tax", "colTax");
		this.hashFields.put("col_date", "colDate");
		this.hashFields.put("uncol_amt", "uncolAmt");
		this.hashFields.put("ots_clt_flg", "otsCltFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return loccdd
	 */
	public String getLoccdd() {
		return this.loccdd;
	}
	
	/**
	 * Column Info
	 * @return blnooo
	 */
	public String getBlnooo() {
		return this.blnooo;
	}
	
	/**
	 * Column Info
	 * @return overdy
	 */
	public String getOverdy() {
		return this.overdy;
	}
	
	/**
	 * Column Info
	 * @return cntrno
	 */
	public String getCntrno() {
		return this.cntrno;
	}
	
	/**
	 * Column Info
	 * @return ftcmpl
	 */
	public String getFtcmpl() {
		return this.ftcmpl;
	}
	
	/**
	 * Column Info
	 * @return stpdfr
	 */
	public String getStpdfr() {
		return this.stpdfr;
	}
	
	/**
	 * Column Info
	 * @return freedy
	 */
	public String getFreedy() {
		return this.freedy;
	}
	
	/**
	 * Column Info
	 * @return invnoo
	 */
	public String getInvnoo() {
		return this.invnoo;
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
	 * @return currcy
	 */
	public String getCurrcy() {
		return this.currcy;
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
	 * @return oveday
	 */
	public String getOveday() {
		return this.oveday;
	}
	
	/**
	 * Column Info
	 * @return issudt
	 */
	public String getIssudt() {
		return this.issudt;
	}
	
	/**
	 * Column Info
	 * @return charge
	 */
	public String getCharge() {
		return this.charge;
	}
	
	/**
	 * Column Info
	 * @return netamt
	 */
	public String getNetamt() {
		return this.netamt;
	}
	
	/**
	 * Column Info
	 * @return scnooo
	 */
	public String getScnooo() {
		return this.scnooo;
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
	 * @return stpdto
	 */
	public String getStpdto() {
		return this.stpdto;
	}
	
	/**
	 * Column Info
	 * @return tyszcd
	 */
	public String getTyszcd() {
		return this.tyszcd;
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
	 * @return vvdcdd
	 */
	public String getVvdcdd() {
		return this.vvdcdd;
	}
	
	/**
	 * Column Info
	 * @return ftcmnc
	 */
	public String getFtcmnc() {
		return this.ftcmnc;
	}
	

	/**
	 * Column Info
	 * @param loccdd
	 */
	public void setLoccdd(String loccdd) {
		this.loccdd = loccdd;
	}
	
	/**
	 * Column Info
	 * @param blnooo
	 */
	public void setBlnooo(String blnooo) {
		this.blnooo = blnooo;
	}
	
	/**
	 * Column Info
	 * @param overdy
	 */
	public void setOverdy(String overdy) {
		this.overdy = overdy;
	}
	
	/**
	 * Column Info
	 * @param cntrno
	 */
	public void setCntrno(String cntrno) {
		this.cntrno = cntrno;
	}
	
	/**
	 * Column Info
	 * @param ftcmpl
	 */
	public void setFtcmpl(String ftcmpl) {
		this.ftcmpl = ftcmpl;
	}
	
	/**
	 * Column Info
	 * @param stpdfr
	 */
	public void setStpdfr(String stpdfr) {
		this.stpdfr = stpdfr;
	}
	
	/**
	 * Column Info
	 * @param freedy
	 */
	public void setFreedy(String freedy) {
		this.freedy = freedy;
	}
	
	/**
	 * Column Info
	 * @param invnoo
	 */
	public void setInvnoo(String invnoo) {
		this.invnoo = invnoo;
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
	 * @param currcy
	 */
	public void setCurrcy(String currcy) {
		this.currcy = currcy;
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
	 * @param oveday
	 */
	public void setOveday(String oveday) {
		this.oveday = oveday;
	}
	
	/**
	 * Column Info
	 * @param issudt
	 */
	public void setIssudt(String issudt) {
		this.issudt = issudt;
	}
	
	/**
	 * Column Info
	 * @param charge
	 */
	public void setCharge(String charge) {
		this.charge = charge;
	}
	
	/**
	 * Column Info
	 * @param netamt
	 */
	public void setNetamt(String netamt) {
		this.netamt = netamt;
	}
	
	/**
	 * Column Info
	 * @param scnooo
	 */
	public void setScnooo(String scnooo) {
		this.scnooo = scnooo;
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
	 * @param stpdto
	 */
	public void setStpdto(String stpdto) {
		this.stpdto = stpdto;
	}
	
	/**
	 * Column Info
	 * @param tyszcd
	 */
	public void setTyszcd(String tyszcd) {
		this.tyszcd = tyszcd;
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
	 * @param vvdcdd
	 */
	public void setVvdcdd(String vvdcdd) {
		this.vvdcdd = vvdcdd;
	}
	
	/**
	 * Column Info
	 * @param ftcmnc
	 */
	public void setFtcmnc(String ftcmnc) {
		this.ftcmnc = ftcmnc;
	}
	
	public String getOrgChgAmt() {
		return orgChgAmt;
	}

	public void setOrgChgAmt(String orgChgAmt) {
		this.orgChgAmt = orgChgAmt;
	}

	public String getCmdtExptAmt() {
		return cmdtExptAmt;
	}

	public void setCmdtExptAmt(String cmdtExptAmt) {
		this.cmdtExptAmt = cmdtExptAmt;
	}

	public String getScRfaExptAmt() {
		return scRfaExptAmt;
	}

	public void setScRfaExptAmt(String scRfaExptAmt) {
		this.scRfaExptAmt = scRfaExptAmt;
	}

	public String getAftExptDcAmt() {
		return aftExptDcAmt;
	}

	public void setAftExptDcAmt(String aftExptDcAmt) {
		this.aftExptDcAmt = aftExptDcAmt;
	}

	public String getInvRmk() {
		return invRmk;
	}

	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
	}

	public String getRfaNo() {
		return rfaNo;
	}

	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}

	public String getTaaNo() {
		return taaNo;
	}

	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
	}

	public String getShCustCd() {
		return shCustCd;
	}

	public void setShCustCd(String shCustCd) {
		this.shCustCd = shCustCd;
	}

	public String getShCustNm() {
		return shCustNm;
	}

	public void setShCustNm(String shCustNm) {
		this.shCustNm = shCustNm;
	}

	public String getCnCustCd() {
		return cnCustCd;
	}

	public void setCnCustCd(String cnCustCd) {
		this.cnCustCd = cnCustCd;
	}

	public String getCnCustNm() {
		return cnCustNm;
	}

	public void setCnCustNm(String cnCustNm) {
		this.cnCustNm = cnCustNm;
	}

	public String getPodCd() {
		return podCd;
	}

	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	public String getPolCd() {
		return polCd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	public String getDelCd() {
		return delCd;
	}

	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLoccdd(JSPUtil.getParameter(request, "loccdd", ""));
		setBlnooo(JSPUtil.getParameter(request, "blnooo", ""));
		setOverdy(JSPUtil.getParameter(request, "overdy", ""));
		setCntrno(JSPUtil.getParameter(request, "cntrno", ""));
		setFtcmpl(JSPUtil.getParameter(request, "ftcmpl", ""));
		setStpdfr(JSPUtil.getParameter(request, "stpdfr", ""));
		setFreedy(JSPUtil.getParameter(request, "freedy", ""));
		setInvnoo(JSPUtil.getParameter(request, "invnoo", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCurrcy(JSPUtil.getParameter(request, "currcy", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOveday(JSPUtil.getParameter(request, "oveday", ""));
		setIssudt(JSPUtil.getParameter(request, "issudt", ""));
		setCharge(JSPUtil.getParameter(request, "charge", ""));
		setNetamt(JSPUtil.getParameter(request, "netamt", ""));
		setScnooo(JSPUtil.getParameter(request, "scnooo", ""));
		setTaxamt(JSPUtil.getParameter(request, "taxamt", ""));
		setStpdto(JSPUtil.getParameter(request, "stpdto", ""));
		setTyszcd(JSPUtil.getParameter(request, "tyszcd", ""));
		setTotamt(JSPUtil.getParameter(request, "totamt", ""));
		setVvdcdd(JSPUtil.getParameter(request, "vvdcdd", ""));
		setFtcmnc(JSPUtil.getParameter(request, "ftcmnc", ""));
		setOrgChgAmt(JSPUtil.getParameter(request, "org_chg_amt", ""));
		setCmdtExptAmt(JSPUtil.getParameter(request, "cmdt_expt_amt", ""));
		setScRfaExptAmt(JSPUtil.getParameter(request, "sc_rfa_expt_amt", ""));
		setAftExptDcAmt(JSPUtil.getParameter(request, "aft_expt_dc_amt", ""));
		setInvRmk(JSPUtil.getParameter(request, "inv_rmk", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setTaaNo(JSPUtil.getParameter(request, "taa_no", ""));
		setShCustCd(JSPUtil.getParameter(request, "sh_cust_cd", ""));
		setShCustNm(JSPUtil.getParameter(request, "sh_cust_nm", ""));
		setCnCustCd(JSPUtil.getParameter(request, "cn_cust_cd", ""));
		setCnCustNm(JSPUtil.getParameter(request, "cn_cust_nm", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setColCharge(JSPUtil.getParameter(request, "col_charge", ""));
		setColTax(JSPUtil.getParameter(request,  "col_tax", ""));
		setColDate(JSPUtil.getParameter(request,  "col_date", ""));
		setUncolAmt(JSPUtil.getParameter(request, "uncol_amt", ""));
		setOtsCltFlg(JSPUtil.getParameter(request, "ots_clt_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OtsInquiryByDetialVO2[]
	 */
	public OtsInquiryByDetial2VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OtsInquiryByDetialVO2[]
	 */
	public OtsInquiryByDetial2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OtsInquiryByDetial2VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] loccdd = (JSPUtil.getParameter(request, prefix	+ "loccdd", length));
			String[] blnooo = (JSPUtil.getParameter(request, prefix	+ "blnooo", length));
			String[] overdy = (JSPUtil.getParameter(request, prefix	+ "overdy", length));
			String[] cntrno = (JSPUtil.getParameter(request, prefix	+ "cntrno", length));
			String[] ftcmpl = (JSPUtil.getParameter(request, prefix	+ "ftcmpl", length));
			String[] stpdfr = (JSPUtil.getParameter(request, prefix	+ "stpdfr", length));
			String[] freedy = (JSPUtil.getParameter(request, prefix	+ "freedy", length));
			String[] invnoo = (JSPUtil.getParameter(request, prefix	+ "invnoo", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] currcy = (JSPUtil.getParameter(request, prefix	+ "currcy", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oveday = (JSPUtil.getParameter(request, prefix	+ "oveday", length));
			String[] issudt = (JSPUtil.getParameter(request, prefix	+ "issudt", length));
			String[] charge = (JSPUtil.getParameter(request, prefix	+ "charge", length));
			String[] netamt = (JSPUtil.getParameter(request, prefix	+ "netamt", length));
			String[] scnooo = (JSPUtil.getParameter(request, prefix	+ "scnooo", length));
			String[] taxamt = (JSPUtil.getParameter(request, prefix	+ "taxamt", length));
			String[] stpdto = (JSPUtil.getParameter(request, prefix	+ "stpdto", length));
			String[] tyszcd = (JSPUtil.getParameter(request, prefix	+ "tyszcd", length));
			String[] totamt = (JSPUtil.getParameter(request, prefix	+ "totamt", length));
			String[] vvdcdd = (JSPUtil.getParameter(request, prefix	+ "vvdcdd", length));
			String[] ftcmnc = (JSPUtil.getParameter(request, prefix	+ "ftcmnc", length));
			String[] orgChgAmt = (JSPUtil.getParameter(request, prefix	+ "org_chg_amt", length));
			String[] cmdtExptAmt = (JSPUtil.getParameter(request, prefix	+ "cmdt_expt_amt", length));
			String[] scRfaExptAmt = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_amt", length));
			String[] aftExptDcAmt = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dc_amt", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] shCustCd = (JSPUtil.getParameter(request, prefix	+ "sh_cust_cd", length));
			String[] shCustNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_nm", length));
			String[] cnCustCd = (JSPUtil.getParameter(request, prefix	+ "cn_cust_cd", length));
			String[] cnCustNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_nm", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] colCharge = (JSPUtil.getParameter(request, prefix	+ "col_charge", length));
			String[] colTax = (JSPUtil.getParameter(request, prefix	+ "col_tax", length));
			String[] colDate = (JSPUtil.getParameter(request, prefix	+ "col_date", length));
			String[] uncolAmt = (JSPUtil.getParameter(request, prefix	+ "uncol_amt", length));
			String[] otsCltFlg = (JSPUtil.getParameter(request, prefix	+ "ots_clt_flg", length));		
			
			for (int i = 0; i < length; i++) {
				model = new OtsInquiryByDetial2VO();
				if (loccdd[i] != null)
					model.setLoccdd(loccdd[i]);
				if (blnooo[i] != null)
					model.setBlnooo(blnooo[i]);
				if (overdy[i] != null)
					model.setOverdy(overdy[i]);
				if (cntrno[i] != null)
					model.setCntrno(cntrno[i]);
				if (ftcmpl[i] != null)
					model.setFtcmpl(ftcmpl[i]);
				if (stpdfr[i] != null)
					model.setStpdfr(stpdfr[i]);
				if (freedy[i] != null)
					model.setFreedy(freedy[i]);
				if (invnoo[i] != null)
					model.setInvnoo(invnoo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (currcy[i] != null)
					model.setCurrcy(currcy[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oveday[i] != null)
					model.setOveday(oveday[i]);
				if (issudt[i] != null)
					model.setIssudt(issudt[i]);
				if (charge[i] != null)
					model.setCharge(charge[i]);
				if (netamt[i] != null)
					model.setNetamt(netamt[i]);
				if (scnooo[i] != null)
					model.setScnooo(scnooo[i]);
				if (taxamt[i] != null)
					model.setTaxamt(taxamt[i]);
				if (stpdto[i] != null)
					model.setStpdto(stpdto[i]);
				if (tyszcd[i] != null)
					model.setTyszcd(tyszcd[i]);
				if (totamt[i] != null)
					model.setTotamt(totamt[i]);
				if (vvdcdd[i] != null)
					model.setVvdcdd(vvdcdd[i]);
				if (ftcmnc[i] != null)
					model.setFtcmnc(ftcmnc[i]);
				if (orgChgAmt[i] != null)
					model.setOrgChgAmt(orgChgAmt[i]);
				if (cmdtExptAmt[i] != null)
					model.setCmdtExptAmt(cmdtExptAmt[i]);
				if (scRfaExptAmt[i] != null)
					model.setScRfaExptAmt(scRfaExptAmt[i]);
				if (aftExptDcAmt[i] != null)
					model.setAftExptDcAmt(aftExptDcAmt[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (shCustCd[i] != null)
					model.setShCustCd(shCustCd[i]);
				if (shCustNm[i] != null)
					model.setShCustNm(shCustNm[i]);
				if (cnCustCd[i] != null)
					model.setCnCustCd(cnCustCd[i]);
				if (cnCustNm[i] != null)
					model.setCnCustNm(cnCustNm[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (colCharge[i] != null)
					model.setColCharge(colCharge[i]);
				if (colTax[i] != null)
					model.setColTax(colTax[i]);
				if (colDate[i] != null)
					model.setColDate(colDate[i]);
				if (uncolAmt[i] != null)
					model.setUncolAmt(uncolAmt[i]);
				if (otsCltFlg[i] != null)
					model.setOtsCltFlg(otsCltFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOtsInquiryByDetialVO2s();
	}

	/**
	 * VO 배열을 반환
	 * @return OtsInquiryByDetialVO2[]
	 */
	public OtsInquiryByDetial2VO[] getOtsInquiryByDetialVO2s(){
		OtsInquiryByDetial2VO[] vos = (OtsInquiryByDetial2VO[])models.toArray(new OtsInquiryByDetial2VO[models.size()]);
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
		this.loccdd = this.loccdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnooo = this.blnooo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overdy = this.overdy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrno = this.cntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftcmpl = this.ftcmpl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stpdfr = this.stpdfr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freedy = this.freedy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invnoo = this.invnoo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currcy = this.currcy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oveday = this.oveday .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issudt = this.issudt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.charge = this.charge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netamt = this.netamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnooo = this.scnooo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxamt = this.taxamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stpdto = this.stpdto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tyszcd = this.tyszcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totamt = this.totamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdcdd = this.vvdcdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftcmnc = this.ftcmnc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgChgAmt = this.orgChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtExptAmt = this.cmdtExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptAmt = this.scRfaExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDcAmt = this.aftExptDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustCd = this.shCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustNm = this.shCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustCd = this.cnCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustNm = this.cnCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colCharge = this.colCharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colTax = this.colTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colDate = this.colDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uncolAmt = this.uncolAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsCltFlg = this.otsCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
