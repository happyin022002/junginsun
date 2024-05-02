/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfDecEdiVvdVO.java
*@FileTitle : KrWhfDecEdiVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.10.21 정재엽 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

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
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfDecEdiVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfDecEdiVvdVO> models = new ArrayList<KrWhfDecEdiVvdVO>();
	
	/* Column Info */
	private String f10Ttl = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String rtonTtl = null;
	/* Column Info */
	private String fetcTtl = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String dschInd = null;
	/* Column Info */
	private String tmnlCd = null;
	/* Column Info */
	private String ioInd = null;
	/* Column Info */
	private String sndInd = null;
	/* Column Info */
	private String e40Ttl = null;
	/* Column Info */
	private String e20Ttl = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String f45Ttl = null;
	/* Column Info */
	private String amount = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String freeAmount = null;
	/* Column Info */
	private String rton = null;
	/* Column Info */
	private String inSeq = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String sumAmount = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String vslFullname = null;
	/* Column Info */
	private String eetcTtl = null;
	/* Column Info */
	private String vslCallsign = null;
	/* Column Info */
	private String f35Ttl = null;
	/* Column Info */
	private String estVol = null;
	/* Column Info */
	private String dschCom = null;
	/* Column Info */
	private String f40Ttl = null;
	/* Column Info */
	private String freeRton = null;
	/* Column Info */
	private String e45Ttl = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String e10Ttl = null;
	/* Column Info */
	private String vslCountry = null;
	/* Column Info */
	private String taxDate = null;
	/* Column Info */
	private String e35Ttl = null;
	/* Column Info */
	private String f20Ttl = null;
	/* Column Info */
	private String dscRate = null;
	/* Column Info */
	private String amountTtl = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfDecEdiVvdVO() {}

	public KrWhfDecEdiVvdVO(String ibflag, String pagerows, String f10Ttl, String eta, String rtonTtl, String etd, String fetcTtl, String dschInd, String ioInd, String tmnlCd, String sndInd, String e40Ttl, String e20Ttl, String f45Ttl, String amount, String freeAmount, String rton, String inSeq, String pol, String portCd, String pod, String vslFullname, String eetcTtl, String vslCallsign, String f35Ttl, String dschCom, String freeRton, String f40Ttl, String e45Ttl, String vvd, String e10Ttl, String vslCountry, String taxDate, String e35Ttl, String f20Ttl, String dscRate, String amountTtl, String estVol, String sumAmount) {
		this.f10Ttl = f10Ttl;
		this.eta = eta;
		this.rtonTtl = rtonTtl;
		this.fetcTtl = fetcTtl;
		this.etd = etd;
		this.dschInd = dschInd;
		this.tmnlCd = tmnlCd;
		this.ioInd = ioInd;
		this.sndInd = sndInd;
		this.e40Ttl = e40Ttl;
		this.e20Ttl = e20Ttl;
		this.pagerows = pagerows;
		this.f45Ttl = f45Ttl;
		this.amount = amount;
		this.ibflag = ibflag;
		this.freeAmount = freeAmount;
		this.rton = rton;
		this.inSeq = inSeq;
		this.pol = pol;
		this.portCd = portCd;
		this.sumAmount = sumAmount;
		this.pod = pod;
		this.vslFullname = vslFullname;
		this.eetcTtl = eetcTtl;
		this.vslCallsign = vslCallsign;
		this.f35Ttl = f35Ttl;
		this.estVol = estVol;
		this.dschCom = dschCom;
		this.f40Ttl = f40Ttl;
		this.freeRton = freeRton;
		this.e45Ttl = e45Ttl;
		this.vvd = vvd;
		this.e10Ttl = e10Ttl;
		this.vslCountry = vslCountry;
		this.taxDate = taxDate;
		this.e35Ttl = e35Ttl;
		this.f20Ttl = f20Ttl;
		this.dscRate = dscRate;
		this.amountTtl = amountTtl;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f10_ttl", getF10Ttl());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("rton_ttl", getRtonTtl());
		this.hashColumns.put("fetc_ttl", getFetcTtl());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("dsch_ind", getDschInd());
		this.hashColumns.put("tmnl_cd", getTmnlCd());
		this.hashColumns.put("io_ind", getIoInd());
		this.hashColumns.put("snd_ind", getSndInd());
		this.hashColumns.put("e40_ttl", getE40Ttl());
		this.hashColumns.put("e20_ttl", getE20Ttl());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f45_ttl", getF45Ttl());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("free_amount", getFreeAmount());
		this.hashColumns.put("rton", getRton());
		this.hashColumns.put("in_seq", getInSeq());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("sum_amount", getSumAmount());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("vsl_fullname", getVslFullname());
		this.hashColumns.put("eetc_ttl", getEetcTtl());
		this.hashColumns.put("vsl_callsign", getVslCallsign());
		this.hashColumns.put("f35_ttl", getF35Ttl());
		this.hashColumns.put("est_vol", getEstVol());
		this.hashColumns.put("dsch_com", getDschCom());
		this.hashColumns.put("f40_ttl", getF40Ttl());
		this.hashColumns.put("free_rton", getFreeRton());
		this.hashColumns.put("e45_ttl", getE45Ttl());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("e10_ttl", getE10Ttl());
		this.hashColumns.put("vsl_country", getVslCountry());
		this.hashColumns.put("tax_date", getTaxDate());
		this.hashColumns.put("e35_ttl", getE35Ttl());
		this.hashColumns.put("f20_ttl", getF20Ttl());
		this.hashColumns.put("dsc_rate", getDscRate());
		this.hashColumns.put("amount_ttl", getAmountTtl());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f10_ttl", "f10Ttl");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("rton_ttl", "rtonTtl");
		this.hashFields.put("fetc_ttl", "fetcTtl");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("dsch_ind", "dschInd");
		this.hashFields.put("tmnl_cd", "tmnlCd");
		this.hashFields.put("io_ind", "ioInd");
		this.hashFields.put("snd_ind", "sndInd");
		this.hashFields.put("e40_ttl", "e40Ttl");
		this.hashFields.put("e20_ttl", "e20Ttl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f45_ttl", "f45Ttl");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("free_amount", "freeAmount");
		this.hashFields.put("rton", "rton");
		this.hashFields.put("in_seq", "inSeq");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("sum_amount", "sumAmount");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("vsl_fullname", "vslFullname");
		this.hashFields.put("eetc_ttl", "eetcTtl");
		this.hashFields.put("vsl_callsign", "vslCallsign");
		this.hashFields.put("f35_ttl", "f35Ttl");
		this.hashFields.put("est_vol", "estVol");
		this.hashFields.put("dsch_com", "dschCom");
		this.hashFields.put("f40_ttl", "f40Ttl");
		this.hashFields.put("free_rton", "freeRton");
		this.hashFields.put("e45_ttl", "e45Ttl");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("e10_ttl", "e10Ttl");
		this.hashFields.put("vsl_country", "vslCountry");
		this.hashFields.put("tax_date", "taxDate");
		this.hashFields.put("e35_ttl", "e35Ttl");
		this.hashFields.put("f20_ttl", "f20Ttl");
		this.hashFields.put("dsc_rate", "dscRate");
		this.hashFields.put("amount_ttl", "amountTtl");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return f10Ttl
	 */
	public String getF10Ttl() {
		return this.f10Ttl;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return rtonTtl
	 */
	public String getRtonTtl() {
		return this.rtonTtl;
	}
	
	/**
	 * Column Info
	 * @return fetcTtl
	 */
	public String getFetcTtl() {
		return this.fetcTtl;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return dschInd
	 */
	public String getDschInd() {
		return this.dschInd;
	}
	
	/**
	 * Column Info
	 * @return tmnlCd
	 */
	public String getTmnlCd() {
		return this.tmnlCd;
	}
	
	/**
	 * Column Info
	 * @return ioInd
	 */
	public String getIoInd() {
		return this.ioInd;
	}
	
	/**
	 * Column Info
	 * @return sndInd
	 */
	public String getSndInd() {
		return this.sndInd;
	}
	
	/**
	 * Column Info
	 * @return e40Ttl
	 */
	public String getE40Ttl() {
		return this.e40Ttl;
	}
	
	/**
	 * Column Info
	 * @return e20Ttl
	 */
	public String getE20Ttl() {
		return this.e20Ttl;
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
	 * @return f45Ttl
	 */
	public String getF45Ttl() {
		return this.f45Ttl;
	}
	
	/**
	 * Column Info
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
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
	 * @return freeAmount
	 */
	public String getFreeAmount() {
		return this.freeAmount;
	}
	
	/**
	 * Column Info
	 * @return rton
	 */
	public String getRton() {
		return this.rton;
	}
	
	/**
	 * Column Info
	 * @return inSeq
	 */
	public String getInSeq() {
		return this.inSeq;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return sumAmount
	 */
	public String getSumAmount() {
		return this.sumAmount;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return vslFullname
	 */
	public String getVslFullname() {
		return this.vslFullname;
	}
	
	/**
	 * Column Info
	 * @return eetcTtl
	 */
	public String getEetcTtl() {
		return this.eetcTtl;
	}
	
	/**
	 * Column Info
	 * @return vslCallsign
	 */
	public String getVslCallsign() {
		return this.vslCallsign;
	}
	
	/**
	 * Column Info
	 * @return f35Ttl
	 */
	public String getF35Ttl() {
		return this.f35Ttl;
	}
	
	/**
	 * Column Info
	 * @return estVol
	 */
	public String getEstVol() {
		return this.estVol;
	}
	
	/**
	 * Column Info
	 * @return dschCom
	 */
	public String getDschCom() {
		return this.dschCom;
	}
	
	/**
	 * Column Info
	 * @return f40Ttl
	 */
	public String getF40Ttl() {
		return this.f40Ttl;
	}
	
	/**
	 * Column Info
	 * @return freeRton
	 */
	public String getFreeRton() {
		return this.freeRton;
	}
	
	/**
	 * Column Info
	 * @return e45Ttl
	 */
	public String getE45Ttl() {
		return this.e45Ttl;
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
	 * @return e10Ttl
	 */
	public String getE10Ttl() {
		return this.e10Ttl;
	}
	
	/**
	 * Column Info
	 * @return vslCountry
	 */
	public String getVslCountry() {
		return this.vslCountry;
	}
	
	/**
	 * Column Info
	 * @return taxDate
	 */
	public String getTaxDate() {
		return this.taxDate;
	}
	
	/**
	 * Column Info
	 * @return e35Ttl
	 */
	public String getE35Ttl() {
		return this.e35Ttl;
	}
	
	/**
	 * Column Info
	 * @return f20Ttl
	 */
	public String getF20Ttl() {
		return this.f20Ttl;
	}
	
	/**
	 * Column Info
	 * @return dscRate
	 */
	public String getDscRate() {
		return this.dscRate;
	}
	
	/**
	 * Column Info
	 * @return amountTtl
	 */
	public String getAmountTtl() {
		return this.amountTtl;
	}
	

	/**
	 * Column Info
	 * @param f10Ttl
	 */
	public void setF10Ttl(String f10Ttl) {
		this.f10Ttl = f10Ttl;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param rtonTtl
	 */
	public void setRtonTtl(String rtonTtl) {
		this.rtonTtl = rtonTtl;
	}
	
	/**
	 * Column Info
	 * @param fetcTtl
	 */
	public void setFetcTtl(String fetcTtl) {
		this.fetcTtl = fetcTtl;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param dschInd
	 */
	public void setDschInd(String dschInd) {
		this.dschInd = dschInd;
	}
	
	/**
	 * Column Info
	 * @param tmnlCd
	 */
	public void setTmnlCd(String tmnlCd) {
		this.tmnlCd = tmnlCd;
	}
	
	/**
	 * Column Info
	 * @param ioInd
	 */
	public void setIoInd(String ioInd) {
		this.ioInd = ioInd;
	}
	
	/**
	 * Column Info
	 * @param sndInd
	 */
	public void setSndInd(String sndInd) {
		this.sndInd = sndInd;
	}
	
	/**
	 * Column Info
	 * @param e40Ttl
	 */
	public void setE40Ttl(String e40Ttl) {
		this.e40Ttl = e40Ttl;
	}
	
	/**
	 * Column Info
	 * @param e20Ttl
	 */
	public void setE20Ttl(String e20Ttl) {
		this.e20Ttl = e20Ttl;
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
	 * @param f45Ttl
	 */
	public void setF45Ttl(String f45Ttl) {
		this.f45Ttl = f45Ttl;
	}
	
	/**
	 * Column Info
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
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
	 * @param freeAmount
	 */
	public void setFreeAmount(String freeAmount) {
		this.freeAmount = freeAmount;
	}
	
	/**
	 * Column Info
	 * @param rton
	 */
	public void setRton(String rton) {
		this.rton = rton;
	}
	
	/**
	 * Column Info
	 * @param inSeq
	 */
	public void setInSeq(String inSeq) {
		this.inSeq = inSeq;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param sumAmount
	 */
	public void setSumAmount(String sumAmount) {
		this.sumAmount = sumAmount;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param vslFullname
	 */
	public void setVslFullname(String vslFullname) {
		this.vslFullname = vslFullname;
	}
	
	/**
	 * Column Info
	 * @param eetcTtl
	 */
	public void setEetcTtl(String eetcTtl) {
		this.eetcTtl = eetcTtl;
	}
	
	/**
	 * Column Info
	 * @param vslCallsign
	 */
	public void setVslCallsign(String vslCallsign) {
		this.vslCallsign = vslCallsign;
	}
	
	/**
	 * Column Info
	 * @param f35Ttl
	 */
	public void setF35Ttl(String f35Ttl) {
		this.f35Ttl = f35Ttl;
	}
	
	/**
	 * Column Info
	 * @param estVol
	 */
	public void setEstVol(String estVol) {
		this.estVol = estVol;
	}
	
	/**
	 * Column Info
	 * @param dschCom
	 */
	public void setDschCom(String dschCom) {
		this.dschCom = dschCom;
	}
	
	/**
	 * Column Info
	 * @param f40Ttl
	 */
	public void setF40Ttl(String f40Ttl) {
		this.f40Ttl = f40Ttl;
	}
	
	/**
	 * Column Info
	 * @param freeRton
	 */
	public void setFreeRton(String freeRton) {
		this.freeRton = freeRton;
	}
	
	/**
	 * Column Info
	 * @param e45Ttl
	 */
	public void setE45Ttl(String e45Ttl) {
		this.e45Ttl = e45Ttl;
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
	 * @param e10Ttl
	 */
	public void setE10Ttl(String e10Ttl) {
		this.e10Ttl = e10Ttl;
	}
	
	/**
	 * Column Info
	 * @param vslCountry
	 */
	public void setVslCountry(String vslCountry) {
		this.vslCountry = vslCountry;
	}
	
	/**
	 * Column Info
	 * @param taxDate
	 */
	public void setTaxDate(String taxDate) {
		this.taxDate = taxDate;
	}
	
	/**
	 * Column Info
	 * @param e35Ttl
	 */
	public void setE35Ttl(String e35Ttl) {
		this.e35Ttl = e35Ttl;
	}
	
	/**
	 * Column Info
	 * @param f20Ttl
	 */
	public void setF20Ttl(String f20Ttl) {
		this.f20Ttl = f20Ttl;
	}
	
	/**
	 * Column Info
	 * @param dscRate
	 */
	public void setDscRate(String dscRate) {
		this.dscRate = dscRate;
	}
	
	/**
	 * Column Info
	 * @param amountTtl
	 */
	public void setAmountTtl(String amountTtl) {
		this.amountTtl = amountTtl;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setF10Ttl(JSPUtil.getParameter(request, "f10_ttl", ""));
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setRtonTtl(JSPUtil.getParameter(request, "rton_ttl", ""));
		setFetcTtl(JSPUtil.getParameter(request, "fetc_ttl", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setDschInd(JSPUtil.getParameter(request, "dsch_ind", ""));
		setTmnlCd(JSPUtil.getParameter(request, "tmnl_cd", ""));
		setIoInd(JSPUtil.getParameter(request, "io_ind", ""));
		setSndInd(JSPUtil.getParameter(request, "snd_ind", ""));
		setE40Ttl(JSPUtil.getParameter(request, "e40_ttl", ""));
		setE20Ttl(JSPUtil.getParameter(request, "e20_ttl", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setF45Ttl(JSPUtil.getParameter(request, "f45_ttl", ""));
		setAmount(JSPUtil.getParameter(request, "amount", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFreeAmount(JSPUtil.getParameter(request, "free_amount", ""));
		setRton(JSPUtil.getParameter(request, "rton", ""));
		setInSeq(JSPUtil.getParameter(request, "in_seq", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setSumAmount(JSPUtil.getParameter(request, "sum_amount", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setVslFullname(JSPUtil.getParameter(request, "vsl_fullname", ""));
		setEetcTtl(JSPUtil.getParameter(request, "eetc_ttl", ""));
		setVslCallsign(JSPUtil.getParameter(request, "vsl_callsign", ""));
		setF35Ttl(JSPUtil.getParameter(request, "f35_ttl", ""));
		setEstVol(JSPUtil.getParameter(request, "est_vol", ""));
		setDschCom(JSPUtil.getParameter(request, "dsch_com", ""));
		setF40Ttl(JSPUtil.getParameter(request, "f40_ttl", ""));
		setFreeRton(JSPUtil.getParameter(request, "free_rton", ""));
		setE45Ttl(JSPUtil.getParameter(request, "e45_ttl", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setE10Ttl(JSPUtil.getParameter(request, "e10_ttl", ""));
		setVslCountry(JSPUtil.getParameter(request, "vsl_country", ""));
		setTaxDate(JSPUtil.getParameter(request, "tax_date", ""));
		setE35Ttl(JSPUtil.getParameter(request, "e35_ttl", ""));
		setF20Ttl(JSPUtil.getParameter(request, "f20_ttl", ""));
		setDscRate(JSPUtil.getParameter(request, "dsc_rate", ""));
		setAmountTtl(JSPUtil.getParameter(request, "amount_ttl", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfDecEdiVvdVO[]
	 */
	public KrWhfDecEdiVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfDecEdiVvdVO[]
	 */
	public KrWhfDecEdiVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfDecEdiVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] f10Ttl = (JSPUtil.getParameter(request, prefix	+ "f10_ttl", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] rtonTtl = (JSPUtil.getParameter(request, prefix	+ "rton_ttl", length));
			String[] fetcTtl = (JSPUtil.getParameter(request, prefix	+ "fetc_ttl", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] dschInd = (JSPUtil.getParameter(request, prefix	+ "dsch_ind", length));
			String[] tmnlCd = (JSPUtil.getParameter(request, prefix	+ "tmnl_cd", length));
			String[] ioInd = (JSPUtil.getParameter(request, prefix	+ "io_ind", length));
			String[] sndInd = (JSPUtil.getParameter(request, prefix	+ "snd_ind", length));
			String[] e40Ttl = (JSPUtil.getParameter(request, prefix	+ "e40_ttl", length));
			String[] e20Ttl = (JSPUtil.getParameter(request, prefix	+ "e20_ttl", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] f45Ttl = (JSPUtil.getParameter(request, prefix	+ "f45_ttl", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] freeAmount = (JSPUtil.getParameter(request, prefix	+ "free_amount", length));
			String[] rton = (JSPUtil.getParameter(request, prefix	+ "rton", length));
			String[] inSeq = (JSPUtil.getParameter(request, prefix	+ "in_seq", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] sumAmount = (JSPUtil.getParameter(request, prefix	+ "sum_amount", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] vslFullname = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname", length));
			String[] eetcTtl = (JSPUtil.getParameter(request, prefix	+ "eetc_ttl", length));
			String[] vslCallsign = (JSPUtil.getParameter(request, prefix	+ "vsl_callsign", length));
			String[] f35Ttl = (JSPUtil.getParameter(request, prefix	+ "f35_ttl", length));
			String[] estVol = (JSPUtil.getParameter(request, prefix	+ "est_vol", length));
			String[] dschCom = (JSPUtil.getParameter(request, prefix	+ "dsch_com", length));
			String[] f40Ttl = (JSPUtil.getParameter(request, prefix	+ "f40_ttl", length));
			String[] freeRton = (JSPUtil.getParameter(request, prefix	+ "free_rton", length));
			String[] e45Ttl = (JSPUtil.getParameter(request, prefix	+ "e45_ttl", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] e10Ttl = (JSPUtil.getParameter(request, prefix	+ "e10_ttl", length));
			String[] vslCountry = (JSPUtil.getParameter(request, prefix	+ "vsl_country", length));
			String[] taxDate = (JSPUtil.getParameter(request, prefix	+ "tax_date", length));
			String[] e35Ttl = (JSPUtil.getParameter(request, prefix	+ "e35_ttl", length));
			String[] f20Ttl = (JSPUtil.getParameter(request, prefix	+ "f20_ttl", length));
			String[] dscRate = (JSPUtil.getParameter(request, prefix	+ "dsc_rate", length));
			String[] amountTtl = (JSPUtil.getParameter(request, prefix	+ "amount_ttl", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfDecEdiVvdVO();
				if (f10Ttl[i] != null)
					model.setF10Ttl(f10Ttl[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (rtonTtl[i] != null)
					model.setRtonTtl(rtonTtl[i]);
				if (fetcTtl[i] != null)
					model.setFetcTtl(fetcTtl[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (dschInd[i] != null)
					model.setDschInd(dschInd[i]);
				if (tmnlCd[i] != null)
					model.setTmnlCd(tmnlCd[i]);
				if (ioInd[i] != null)
					model.setIoInd(ioInd[i]);
				if (sndInd[i] != null)
					model.setSndInd(sndInd[i]);
				if (e40Ttl[i] != null)
					model.setE40Ttl(e40Ttl[i]);
				if (e20Ttl[i] != null)
					model.setE20Ttl(e20Ttl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (f45Ttl[i] != null)
					model.setF45Ttl(f45Ttl[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (freeAmount[i] != null)
					model.setFreeAmount(freeAmount[i]);
				if (rton[i] != null)
					model.setRton(rton[i]);
				if (inSeq[i] != null)
					model.setInSeq(inSeq[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (sumAmount[i] != null)
					model.setSumAmount(sumAmount[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (vslFullname[i] != null)
					model.setVslFullname(vslFullname[i]);
				if (eetcTtl[i] != null)
					model.setEetcTtl(eetcTtl[i]);
				if (vslCallsign[i] != null)
					model.setVslCallsign(vslCallsign[i]);
				if (f35Ttl[i] != null)
					model.setF35Ttl(f35Ttl[i]);
				if (estVol[i] != null)
					model.setEstVol(estVol[i]);
				if (dschCom[i] != null)
					model.setDschCom(dschCom[i]);
				if (f40Ttl[i] != null)
					model.setF40Ttl(f40Ttl[i]);
				if (freeRton[i] != null)
					model.setFreeRton(freeRton[i]);
				if (e45Ttl[i] != null)
					model.setE45Ttl(e45Ttl[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (e10Ttl[i] != null)
					model.setE10Ttl(e10Ttl[i]);
				if (vslCountry[i] != null)
					model.setVslCountry(vslCountry[i]);
				if (taxDate[i] != null)
					model.setTaxDate(taxDate[i]);
				if (e35Ttl[i] != null)
					model.setE35Ttl(e35Ttl[i]);
				if (f20Ttl[i] != null)
					model.setF20Ttl(f20Ttl[i]);
				if (dscRate[i] != null)
					model.setDscRate(dscRate[i]);
				if (amountTtl[i] != null)
					model.setAmountTtl(amountTtl[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfDecEdiVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfDecEdiVvdVO[]
	 */
	public KrWhfDecEdiVvdVO[] getKrWhfDecEdiVvdVOs(){
		KrWhfDecEdiVvdVO[] vos = (KrWhfDecEdiVvdVO[])models.toArray(new KrWhfDecEdiVvdVO[models.size()]);
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
		this.f10Ttl = this.f10Ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtonTtl = this.rtonTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fetcTtl = this.fetcTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dschInd = this.dschInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmnlCd = this.tmnlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioInd = this.ioInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndInd = this.sndInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e40Ttl = this.e40Ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e20Ttl = this.e20Ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f45Ttl = this.f45Ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeAmount = this.freeAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rton = this.rton .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSeq = this.inSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumAmount = this.sumAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullname = this.vslFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eetcTtl = this.eetcTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallsign = this.vslCallsign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f35Ttl = this.f35Ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estVol = this.estVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dschCom = this.dschCom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f40Ttl = this.f40Ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeRton = this.freeRton .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e45Ttl = this.e45Ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e10Ttl = this.e10Ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCountry = this.vslCountry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxDate = this.taxDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e35Ttl = this.e35Ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f20Ttl = this.f20Ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscRate = this.dscRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amountTtl = this.amountTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
