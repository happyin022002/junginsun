/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OtsInquiryBySummaryVO.java
*@FileTitle : OtsInquiryBySummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OtsInquiryBySummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OtsInquiryBySummaryVO> models = new ArrayList<OtsInquiryBySummaryVO>();
	
	/* Column Info */
	private String cticyn = null;
	/* Column Info */
	private String dmofyn = null;
	/* Column Info */
	private String payern = null;
	/* Column Info */
	private String bllamt = null;
	/* Column Info */
	private String useflg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctocyn = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invocr = null;
	/* Column Info */
	private String payerc = null;
	/* Column Info */
	private String invocn = null;
	/* Column Info */
	private String taxamt = null;
	/* Column Info */
	private String dticyn = null;
	/* Column Info */
	private String dtocyn = null;
	/* Column Info */
	private String totamt = null;
	/* Column Info */
	private String dmifyn = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String dmdtVtInvYn = null;
	/* Column Info */
	private String colCharge = null;
	/* Column Info */
	private String colTax = null;
	/* Column Info */
	private String colDate = null;
	/* Column Info */
	private String uncolAmt = null;
	
	// Sending 관련 필드 추가	
	/* Column Info */
	private String otsShGrpCd = null;
	/* Column Info */
	private String sndCycCd = null;
	/* Column Info */
	private String sndCntrListFlg = null;
	/* Column Info */
	private String sndInvFlg = null;
	/* Column Info */
	private String emlExistFlg = null;
	
	// Contract 관련 필드 추가
	/* Column Info */
	private String ctrtSrepCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String ctrtCustCd = null;
	/* Column Info */
	private String ctrtCustNm = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String ctrtTp = null;
	/* Column Info */
	private String udsLoclXchRt = null;
	/* Column Info */
	private String invList = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OtsInquiryBySummaryVO() {}

	public OtsInquiryBySummaryVO(String ibflag, String pagerows, String payerc, String payern, String invocn, String invocr, String bllamt, String taxamt, String totamt, String useflg, String dmifyn, String dticyn, String dmofyn, String dtocyn, String cticyn, String ctocyn, String obSrepCd, String dmdtVtInvYn, String colCharge, String colTax, String colDate, String uncolAmt, String otsShGrpCd, String sndCycCd, String sndCntrListFlg, String sndInvFlg, String emlExistFlg, String ctrtSrepCd, String ctrtOfcCd, String ctrtCustCd, String ctrtCustNm, String ctrtNo, String ctrtTp, String udsLoclXchRt, String invList) {
		this.cticyn = cticyn;
		this.dmofyn = dmofyn;
		this.payern = payern;
		this.bllamt = bllamt;
		this.useflg = useflg;
		this.pagerows = pagerows;
		this.ctocyn = ctocyn;
		this.ibflag = ibflag;
		this.invocr = invocr;
		this.payerc = payerc;
		this.invocn = invocn;
		this.taxamt = taxamt;
		this.dticyn = dticyn;
		this.dtocyn = dtocyn;
		this.totamt = totamt;
		this.dmifyn = dmifyn;
		this.obSrepCd = obSrepCd;
		this.dmdtVtInvYn = dmdtVtInvYn;
		this.colCharge = colCharge; 
		this.colTax = colTax;
		this.colDate = colDate;
		this.uncolAmt = uncolAmt;
		this.otsShGrpCd = otsShGrpCd;
		this.sndCycCd = sndCycCd;
		this.sndCntrListFlg = sndCntrListFlg;
		this.sndInvFlg = sndInvFlg;
		this.emlExistFlg = emlExistFlg;
		this.ctrtSrepCd = ctrtSrepCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.ctrtCustCd = ctrtCustCd;
		this.ctrtCustNm = ctrtCustNm;
		this.ctrtNo = ctrtNo;
		this.ctrtTp = ctrtTp;
		this.udsLoclXchRt = udsLoclXchRt;
		this.invList = invList;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cticyn", getCticyn());
		this.hashColumns.put("dmofyn", getDmofyn());
		this.hashColumns.put("payern", getPayern());
		this.hashColumns.put("bllamt", getBllamt());
		this.hashColumns.put("useflg", getUseflg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctocyn", getCtocyn());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("invocr", getInvocr());
		this.hashColumns.put("payerc", getPayerc());
		this.hashColumns.put("invocn", getInvocn());
		this.hashColumns.put("taxamt", getTaxamt());
		this.hashColumns.put("dticyn", getDticyn());
		this.hashColumns.put("dtocyn", getDtocyn());
		this.hashColumns.put("totamt", getTotamt());
		this.hashColumns.put("dmifyn", getDmifyn());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("dmdt_vt_inv_yn", getDmdtVtInvYn());
		this.hashColumns.put("col_charge", getColCharge());
		this.hashColumns.put("col_tax", getColTax());
		this.hashColumns.put("col_date", getColDate());
		this.hashColumns.put("uncol_amt", getUncolAmt());	
		this.hashColumns.put("ots_sh_grp_cd", getOtsShGrpCd());	
		this.hashColumns.put("snd_cyc_cd", getSndCycCd());	
		this.hashColumns.put("snd_cntr_list_flg", getSndCntrListFlg());	
		this.hashColumns.put("snd_inv_flg", getSndInvFlg());	
		this.hashColumns.put("eml_exist_flg", getEmlExistFlg());
		this.hashColumns.put("ctrt_srep_cd", getCtrtSrepCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("ctrt_cust_cd", getCtrtCustCd());
		this.hashColumns.put("ctrt_cust_nm", getCtrtCustNm());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("ctrt_tp", getCtrtTp());
		this.hashColumns.put("usd_locl_xch_rt", getUdsLoclXchRt());
		this.hashColumns.put("inv_list", getInvList());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cticyn", "cticyn");
		this.hashFields.put("dmofyn", "dmofyn");
		this.hashFields.put("payern", "payern");
		this.hashFields.put("bllamt", "bllamt");
		this.hashFields.put("useflg", "useflg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctocyn", "ctocyn");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("invocr", "invocr");
		this.hashFields.put("payerc", "payerc");
		this.hashFields.put("invocn", "invocn");
		this.hashFields.put("taxamt", "taxamt");
		this.hashFields.put("dticyn", "dticyn");
		this.hashFields.put("dtocyn", "dtocyn");
		this.hashFields.put("totamt", "totamt");
		this.hashFields.put("dmifyn", "dmifyn");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("dmdt_vt_inv_yn", "dmdtVtInvYn");
		this.hashFields.put("col_charge", "colCharge");
		this.hashFields.put("col_tax", "colTax");
		this.hashFields.put("col_date", "colDate");
		this.hashFields.put("uncol_amt", "uncolAmt");
		this.hashFields.put("ots_sh_grp_cd", "otsShGrpCd");
		this.hashFields.put("snd_cyc_cd", "sndCycCd");
		this.hashFields.put("snd_cntr_list_flg", "sndCntrListFlg");
		this.hashFields.put("snd_inv_flg", "sndInvFlg");
		this.hashFields.put("eml_exist_flg", "emlExistFlg");
		this.hashFields.put("ctrt_srep_cd", "ctrtSrepCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("ctrt_cust_cd", "ctrtCustCd");
		this.hashFields.put("ctrt_cust_nm", "ctrtCustNm");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("ctrt_tp", "ctrtTp");
		this.hashFields.put("usd_locl_xch_rt", "udsLoclXchRt");
		this.hashFields.put("inv_list", "invList");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cticyn
	 */
	public String getCticyn() {
		return this.cticyn;
	}
	
	/**
	 * Column Info
	 * @return dmofyn
	 */
	public String getDmofyn() {
		return this.dmofyn;
	}
	
	/**
	 * Column Info
	 * @return payern
	 */
	public String getPayern() {
		return this.payern;
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
	 * @return useflg
	 */
	public String getUseflg() {
		return this.useflg;
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
	 * @return ctocyn
	 */
	public String getCtocyn() {
		return this.ctocyn;
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
	 * @return invocr
	 */
	public String getInvocr() {
		return this.invocr;
	}
	
	/**
	 * Column Info
	 * @return payerc
	 */
	public String getPayerc() {
		return this.payerc;
	}
	
	/**
	 * Column Info
	 * @return invocn
	 */
	public String getInvocn() {
		return this.invocn;
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
	 * @return dticyn
	 */
	public String getDticyn() {
		return this.dticyn;
	}
	
	/**
	 * Column Info
	 * @return dtocyn
	 */
	public String getDtocyn() {
		return this.dtocyn;
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
	 * @return dmifyn
	 */
	public String getDmifyn() {
		return this.dmifyn;
	}
	
	/**
	 * Column Info
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtVtInvYn
	 */
	public String getDmdtVtInvYn() {
		return this.dmdtVtInvYn;
	}	
	
	/**
	 * Column Info
	 * @param cticyn
	 */
	public void setCticyn(String cticyn) {
		this.cticyn = cticyn;
	}
	
	/**
	 * Column Info
	 * @param dmofyn
	 */
	public void setDmofyn(String dmofyn) {
		this.dmofyn = dmofyn;
	}
	
	/**
	 * Column Info
	 * @param payern
	 */
	public void setPayern(String payern) {
		this.payern = payern;
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
	 * @param useflg
	 */
	public void setUseflg(String useflg) {
		this.useflg = useflg;
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
	 * @param ctocyn
	 */
	public void setCtocyn(String ctocyn) {
		this.ctocyn = ctocyn;
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
	 * @param invocr
	 */
	public void setInvocr(String invocr) {
		this.invocr = invocr;
	}
	
	/**
	 * Column Info
	 * @param payerc
	 */
	public void setPayerc(String payerc) {
		this.payerc = payerc;
	}
	
	/**
	 * Column Info
	 * @param invocn
	 */
	public void setInvocn(String invocn) {
		this.invocn = invocn;
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
	 * @param dticyn
	 */
	public void setDticyn(String dticyn) {
		this.dticyn = dticyn;
	}
	
	/**
	 * Column Info
	 * @param dtocyn
	 */
	public void setDtocyn(String dtocyn) {
		this.dtocyn = dtocyn;
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
	 * @param dmifyn
	 */
	public void setDmifyn(String dmifyn) {
		this.dmifyn = dmifyn;
	}
	
	/**
	 * Column Info
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtVtInvYn
	 */
	public void setDmdtVtInvYn(String dmdtVtInvYn) {
		this.dmdtVtInvYn = dmdtVtInvYn;
	}

	
	public String getUdsLoclXchRt() {
		return udsLoclXchRt;
	}

	public void setUdsLoclXchRt(String udsLoclXchRt) {
		this.udsLoclXchRt = udsLoclXchRt;
	}

	public String getCtrtSrepCd() {
		return ctrtSrepCd;
	}

	public void setCtrtSrepCd(String ctrtSrepCd) {
		this.ctrtSrepCd = ctrtSrepCd;
	}

	public String getEmlExistFlg() {
		return emlExistFlg;
	}

	public void setEmlExistFlg(String emlExistFlg) {
		this.emlExistFlg = emlExistFlg;
	}

	public String getOtsShGrpCd() {
		return otsShGrpCd;
	}

	public void setOtsShGrpCd(String otsShGrpCd) {
		this.otsShGrpCd = otsShGrpCd;
	}

	public String getSndCycCd() {
		return sndCycCd;
	}

	public void setSndCycCd(String sndCycCd) {
		this.sndCycCd = sndCycCd;
	}

	public String getSndCntrListFlg() {
		return sndCntrListFlg;
	}

	public void setSndCntrListFlg(String sndCntrListFlg) {
		this.sndCntrListFlg = sndCntrListFlg;
	}

	public String getSndInvFlg() {
		return sndInvFlg;
	}

	public void setSndInvFlg(String sndInvFlg) {
		this.sndInvFlg = sndInvFlg;
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
	
	public String getCtrtOfcCd() {
		return ctrtOfcCd;
	}

	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}

	public String getCtrtCustCd() {
		return ctrtCustCd;
	}

	public void setCtrtCustCd(String ctrtCustCd) {
		this.ctrtCustCd = ctrtCustCd;
	}

	public String getCtrtCustNm() {
		return ctrtCustNm;
	}

	public void setCtrtCustNm(String ctrtCustNm) {
		this.ctrtCustNm = ctrtCustNm;
	}

	public String getCtrtNo() {
		return ctrtNo;
	}

	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}

	public String getCtrtTp() {
		return ctrtTp;
	}

	public void setCtrtTp(String ctrtTp) {
		this.ctrtTp = ctrtTp;
	}

	public String getInvList() {
		return invList;
	}

	public void setInvList(String invList) {
		this.invList = invList;
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
		setCticyn(JSPUtil.getParameter(request, prefix + "cticyn", ""));
		setDmofyn(JSPUtil.getParameter(request, prefix + "dmofyn", ""));
		setPayern(JSPUtil.getParameter(request, prefix + "payern", ""));
		setBllamt(JSPUtil.getParameter(request, prefix + "bllamt", ""));
		setUseflg(JSPUtil.getParameter(request, prefix + "useflg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtocyn(JSPUtil.getParameter(request, prefix + "ctocyn", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvocr(JSPUtil.getParameter(request, prefix + "invocr", ""));
		setPayerc(JSPUtil.getParameter(request, prefix + "payerc", ""));
		setInvocn(JSPUtil.getParameter(request, prefix + "invocn", ""));
		setTaxamt(JSPUtil.getParameter(request, prefix + "taxamt", ""));
		setDticyn(JSPUtil.getParameter(request, prefix + "dticyn", ""));
		setDtocyn(JSPUtil.getParameter(request, prefix + "dtocyn", ""));
		setTotamt(JSPUtil.getParameter(request, prefix + "totamt", ""));
		setDmifyn(JSPUtil.getParameter(request, prefix + "dmifyn", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setDmdtVtInvYn(JSPUtil.getParameter(request, prefix + "dmdt_vt_inv_yn", ""));
		setColCharge(JSPUtil.getParameter(request, prefix + "col_charge", ""));
		setColTax(JSPUtil.getParameter(request, prefix + "col_tax", ""));
		setColDate(JSPUtil.getParameter(request, prefix + "col_date", ""));
		setUncolAmt(JSPUtil.getParameter(request, prefix + "uncol_amt", ""));
		setOtsShGrpCd(JSPUtil.getParameter(request, prefix + "ots_sh_grp_cd", ""));
		setSndCycCd(JSPUtil.getParameter(request, prefix + "snd_cyc_cd", ""));
		setSndCntrListFlg(JSPUtil.getParameter(request, prefix + "snd_cntr_list_flg", ""));
		setSndInvFlg(JSPUtil.getParameter(request, prefix + "snd_inv_flg", ""));
		setEmlExistFlg(JSPUtil.getParameter(request, prefix + "eml_exist_flg", ""));
		setCtrtSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_srep_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setCtrtCustCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cd", ""));
		setCtrtCustNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_nm", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setCtrtTp(JSPUtil.getParameter(request, prefix + "ctrt_tp", ""));
		setUseflg(JSPUtil.getParameter(request, prefix + "usd_locl_xch_rt", ""));
		setInvList(JSPUtil.getParameter(request, prefix + "inv_list", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OtsInquiryBySummaryVO[]
	 */
	public OtsInquiryBySummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OtsInquiryBySummaryVO[]
	 */
	public OtsInquiryBySummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OtsInquiryBySummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cticyn = (JSPUtil.getParameter(request, prefix	+ "cticyn", length));
			String[] dmofyn = (JSPUtil.getParameter(request, prefix	+ "dmofyn", length));
			String[] payern = (JSPUtil.getParameter(request, prefix	+ "payern", length));
			String[] bllamt = (JSPUtil.getParameter(request, prefix	+ "bllamt", length));
			String[] useflg = (JSPUtil.getParameter(request, prefix	+ "useflg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctocyn = (JSPUtil.getParameter(request, prefix	+ "ctocyn", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invocr = (JSPUtil.getParameter(request, prefix	+ "invocr", length));
			String[] payerc = (JSPUtil.getParameter(request, prefix	+ "payerc", length));
			String[] invocn = (JSPUtil.getParameter(request, prefix	+ "invocn", length));
			String[] taxamt = (JSPUtil.getParameter(request, prefix	+ "taxamt", length));
			String[] dticyn = (JSPUtil.getParameter(request, prefix	+ "dticyn", length));
			String[] dtocyn = (JSPUtil.getParameter(request, prefix	+ "dtocyn", length));
			String[] totamt = (JSPUtil.getParameter(request, prefix	+ "totamt", length));
			String[] dmifyn = (JSPUtil.getParameter(request, prefix	+ "dmifyn", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] dmdtVtInvYn = (JSPUtil.getParameter(request, prefix	+ "dmdt_vt_inv_yn", length));
			String[] colCharge = (JSPUtil.getParameter(request, prefix	+ "col_charge", length));
			String[] colTax = (JSPUtil.getParameter(request, prefix	+ "col_tax", length));
			String[] colDate = (JSPUtil.getParameter(request, prefix	+ "col_date", length));
			String[] uncolAmt = (JSPUtil.getParameter(request, prefix	+ "uncol_amt", length));
			String[] otsShGrpCd = (JSPUtil.getParameter(request, prefix	+ "ots_sh_grp_cd", length));
			String[] sndCycCd = (JSPUtil.getParameter(request, prefix	+ "snd_cyc_cd", length));
			String[] sndCntrListFlg = (JSPUtil.getParameter(request, prefix	+ "snd_cntr_list_flg", length));
			String[] sndInvFlg = (JSPUtil.getParameter(request, prefix	+ "snd_inv_flg", length));
			String[] emlExistFlg = (JSPUtil.getParameter(request, prefix	+ "eml_exist_flg", length));
			String[] ctrtSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_srep_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] ctrtCustCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cd", length));
			String[] ctrtCustNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_nm", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] ctrtTp = (JSPUtil.getParameter(request, prefix	+ "ctrt_tp", length));
			String[] udsLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_locl_xch_rt", length));
			String[] invList = (JSPUtil.getParameter(request, prefix	+ "inv_list", length));
			
			for (int i = 0; i < length; i++) {
				model = new OtsInquiryBySummaryVO();
				if (cticyn[i] != null)
					model.setCticyn(cticyn[i]);
				if (dmofyn[i] != null)
					model.setDmofyn(dmofyn[i]);
				if (payern[i] != null)
					model.setPayern(payern[i]);
				if (bllamt[i] != null)
					model.setBllamt(bllamt[i]);
				if (useflg[i] != null)
					model.setUseflg(useflg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctocyn[i] != null)
					model.setCtocyn(ctocyn[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invocr[i] != null)
					model.setInvocr(invocr[i]);
				if (payerc[i] != null)
					model.setPayerc(payerc[i]);
				if (invocn[i] != null)
					model.setInvocn(invocn[i]);
				if (taxamt[i] != null)
					model.setTaxamt(taxamt[i]);
				if (dticyn[i] != null)
					model.setDticyn(dticyn[i]);
				if (dtocyn[i] != null)
					model.setDtocyn(dtocyn[i]);
				if (totamt[i] != null)
					model.setTotamt(totamt[i]);
				if (dmifyn[i] != null)
					model.setDmifyn(dmifyn[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (dmdtVtInvYn[i] != null)
					model.setDmdtVtInvYn(dmdtVtInvYn[i]);
				if (colCharge[i] != null)
					model.setColCharge(colCharge[i]);
				if (colTax[i] != null)
					model.setColTax(colTax[i]);
				if (colDate[i] != null)
					model.setColDate(colDate[i]);
				if (uncolAmt[i] != null)
					model.setUncolAmt(uncolAmt[i]);
				if (otsShGrpCd[i] != null)
					model.setOtsShGrpCd(otsShGrpCd[i]);
				if (sndCycCd[i] != null)
					model.setSndCycCd(sndCycCd[i]);
				if (sndCntrListFlg[i] != null)
					model.setSndCntrListFlg(sndCntrListFlg[i]);
				if (sndInvFlg[i] != null)
					model.setSndInvFlg(sndInvFlg[i]);
				if (emlExistFlg[i] != null)
					model.setEmlExistFlg(emlExistFlg[i]);				
				if (ctrtSrepCd[i] != null)
					model.setCtrtSrepCd(ctrtSrepCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (ctrtCustCd[i] != null)
					model.setCtrtCustCd(ctrtCustCd[i]);
				if (ctrtCustNm[i] != null)
					model.setCtrtCustNm(ctrtCustNm[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (ctrtTp[i] != null)
					model.setCtrtTp(ctrtTp[i]);
				if (udsLoclXchRt[i] != null)
					model.setUdsLoclXchRt(udsLoclXchRt[i]);
				if (invList[i] != null)
					model.setInvList(invList[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOtsInquiryBySummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OtsInquiryBySummaryVO[]
	 */
	public OtsInquiryBySummaryVO[] getOtsInquiryBySummaryVOs(){
		OtsInquiryBySummaryVO[] vos = (OtsInquiryBySummaryVO[])models.toArray(new OtsInquiryBySummaryVO[models.size()]);
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
		this.cticyn = this.cticyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmofyn = this.dmofyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payern = this.payern .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bllamt = this.bllamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useflg = this.useflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctocyn = this.ctocyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invocr = this.invocr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerc = this.payerc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invocn = this.invocn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxamt = this.taxamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dticyn = this.dticyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtocyn = this.dtocyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totamt = this.totamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmifyn = this.dmifyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtVtInvYn = this.dmdtVtInvYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colCharge = this.colCharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colTax = this.colTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colDate = this.colDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uncolAmt = this.uncolAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsShGrpCd = this.otsShGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndCycCd = this.sndCycCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndCntrListFlg = this.sndCntrListFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndInvFlg = this.sndInvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlExistFlg = this.emlExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSrepCd = this.ctrtSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCd = this.ctrtCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustNm = this.ctrtCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtTp = this.ctrtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udsLoclXchRt = this.udsLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invList = this.invList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
