/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ARInterfaceParmVO.java
*@FileTitle : ARInterfaceParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.18
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.12.18 임창빈 
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
 * @author 임창빈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARInterfaceParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInterfaceParmVO> models = new ArrayList<ARInterfaceParmVO>();
	
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String fmDtT2 = null;
	/* Column Info */
	private String toDtT2 = null;
	/* Column Info */
	private String ofcTp = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String actCustCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String sessionOfcCd = null;
	/* Column Info */
	private String btnId = null;
	/* Column Info - Tariff Type Tab1 */
	private String dmdtTrfCdT1 = null;
	/* Column Info - Tariff Type Tab3 */
	private String dmdtTrfCdT3 = null;
	/* Column Info */
	private String custType = null;
	/* Column Info */
	private String fmPayDt = null;
	/* Column Info */
	private String toPayDt = null;
	/* Column Info */
	private String fmIfDt = null;
	/* Column Info */
	private String toIfDt = null;
	/* Column Info */
	private String invoiceNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sInvoiceNo = null;
	/* Column Info */
	private String sBkgNo = null;
	/* Column Info */
	private String erpOfc = null;
	/* Column Info */
	private String erpDt = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARInterfaceParmVO() {}

	public ARInterfaceParmVO(String ibflag, String pagerows, String fmDt, String fmDtT2, String toDtT2, String ofcTp, String type, String ioBndCd, String actCustCd, String chgCd, String toDt, String ofcCd, String usrOfcCd, String sessionOfcCd, String custCd, String dmdtTrfCdT1, String dmdtTrfCdT3, String custType, String btnId, String fmPayDt, String toPayDt, String fmIfDt, String toIfDt, String invoiceNo, String bkgNo, String sInvoiceNo, String sBkgNo, String erpOfc, String erpDt) {
		this.fmDt = fmDt;
		this.fmDtT2 = fmDtT2;
		this.toDtT2 = toDtT2;
		this.ofcTp = ofcTp;
		this.type = type;
		this.ioBndCd = ioBndCd;
		this.actCustCd = actCustCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.usrOfcCd = usrOfcCd;
		this.custCd = custCd;
		this.sessionOfcCd = sessionOfcCd;
		this.btnId = btnId;
		this.dmdtTrfCdT1 = dmdtTrfCdT1;
		this.dmdtTrfCdT3 = dmdtTrfCdT3;
		this.custType = custType;
		this.fmPayDt = fmPayDt;
		this.toPayDt = toPayDt;
		this.fmIfDt  = fmIfDt;
		this.toIfDt  = toIfDt;		
		this.invoiceNo = invoiceNo;
		this.bkgNo = bkgNo;
		this.sInvoiceNo = sInvoiceNo;
		this.sBkgNo = sBkgNo;
		this.erpDt = erpDt;
		this.erpOfc = erpOfc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("fm_dt_t2", getFmDtT2());
		this.hashColumns.put("to_dt_t2", getToDtT2());
		this.hashColumns.put("ofc_tp", getOfcTp());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("act_cust_cd", getActCustCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("session_ofc_cd", getSessionOfcCd());
		this.hashColumns.put("btn_id", getBtnId());
		this.hashColumns.put("dmdt_trf_cd_t1", getDmdtTrfCdT1());
		this.hashColumns.put("dmdt_trf_cd_t3", getDmdtTrfCdT3());
		this.hashColumns.put("cust_type", getCustType());
		this.hashColumns.put("fm_pay_dt", getFmPayDt());
		this.hashColumns.put("to_pay_dt", getToPayDt());
		this.hashColumns.put("fm_if_dt",  getFmIfDt());
		this.hashColumns.put("to_if_dt",  getToIfDt());	
		this.hashColumns.put("invoice_no",  getInvoiceNo());	
		this.hashColumns.put("bkg_no",  getBkgNo());	
		this.hashColumns.put("s_invoice_no",  getSInvoiceNo());	
		this.hashColumns.put("s_bkg_no",  getSBkgNo());	
		this.hashColumns.put("erp_ofc",  getErpOfc());	
		this.hashColumns.put("erp_dt",  getErpDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("fm_dt_t2", "fmDtT2");
		this.hashFields.put("to_dt_t2", "toDtT2");
		this.hashFields.put("ofc_tp", "ofcTp");
		this.hashFields.put("type", "type");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("act_cust_cd", "actCustCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("session_ofc_cd", "sessionOfcCd");
		this.hashFields.put("btn_id", "btnId");
		this.hashFields.put("dmdt_trf_cd_t1", "dmdtTrfCdT1");
		this.hashFields.put("dmdt_trf_cd_t3", "dmdtTrfCdT3");
		this.hashFields.put("cust_type", "custType");
		this.hashFields.put("fm_pay_dt", "fmPayDt");
		this.hashFields.put("to_pay_dt", "toPayDt");
		this.hashFields.put("fm_if_dt",  "fmIfDt");
		this.hashFields.put("to_if_dt",  "toIfDt");	
		this.hashFields.put("invoice_no",  "invoiceNo");
		this.hashFields.put("bkg_no",  "bkgNo");		
		this.hashFields.put("s_invoice_no",  "sInvoiceNo");
		this.hashFields.put("s_bkg_no",  "sBkgNo");		
		this.hashFields.put("erp_dt",  "erpDt");	
		this.hashFields.put("erp_ofc",  "erpOfc");		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return fmDtT2
	 */
	public String getFmDtT2() {
		return this.fmDtT2;
	}
	
	/**
	 * Column Info
	 * @return toDtT2
	 */
	public String getToDtT2() {
		return this.toDtT2;
	}
	
	/**
	 * Column Info
	 * @return ofcTp
	 */
	public String getOfcTp() {
		return this.ofcTp;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
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
	 * @return actCustCd
	 */
	public String getActCustCd() {
		return this.actCustCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return usrOfcCd
	 */
	public String getUsrOfcCd() {
		return this.usrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return sessionOfcCd
	 */
	public String getSessionOfcCd() {
		return this.sessionOfcCd;
	}
	
	/**
	 * Column Info
	 * @return btnId
	 */
	public String getBtnId() {
		return this.btnId;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCdT1
	 */
	public String getDmdtTrfCdT1() {
		return this.dmdtTrfCdT1;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCdT3
	 */
	public String getDmdtTrfCdT3() {
		return this.dmdtTrfCdT3;
	}
	
	/**
	 * Column Info
	 * @return custType
	 */
	public String getCustType() {
		return this.custType;
	}
	
	/**
	 * Column Info
	 * @return custType
	 */
	public String getFmPayDt() {
		return this.fmPayDt;
	}
	
	/**
	 * Column Info
	 * @return custType
	 */
	public String getToPayDt() {
		return this.toPayDt;
	}
	
	/**
	 * Column Info
	 * @return custType
	 */
	public String getFmIfDt() {
		return this.fmIfDt;
	}
	
	/**
	 * Column Info
	 * @return toIfDt
	 */
	public String getToIfDt() {
		return this.toIfDt;
	}
	
	/**
	 * Column Info
	 * @return invoiceNo
	 */
	public String getInvoiceNo() {
		return this.invoiceNo;
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
	 * @return sInvoiceNo
	 */
	public String getSInvoiceNo() {
		return this.sInvoiceNo;
	}
	
	/**
	 * Column Info
	 * @return sBkgNo
	 */
	public String getSBkgNo() {
		return this.sBkgNo;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param fmDtT2
	 */
	public void setFmDtT2(String fmDtT2) {
		this.fmDtT2 = fmDtT2;
	}
	
	/**
	 * Column Info
	 * @param toDtT2
	 */
	public void setToDtT2(String toDtT2) {
		this.toDtT2 = toDtT2;
	}
	
	/**
	 * Column Info
	 * @param ofcTp
	 */
	public void setOfcTp(String ofcTp) {
		this.ofcTp = ofcTp;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @param actCustCd
	 */
	public void setActCustCd(String actCustCd) {
		this.actCustCd = actCustCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param usrOfcCd
	 */
	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param sessionOfcCd
	 */
	public void setSessionOfcCd(String sessionOfcCd) {
		this.sessionOfcCd = sessionOfcCd;
	}
	
	/**
	 * Column Info
	 * @param btnId
	 */
	public void setBtnId(String btnId) {
		this.btnId = btnId;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCdT1
	 */
	public void setDmdtTrfCdT1(String dmdtTrfCdT1) {
		this.dmdtTrfCdT1 = dmdtTrfCdT1;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCdT3
	 */
	public void setDmdtTrfCdT3(String dmdtTrfCdT3) {
		this.dmdtTrfCdT3 = dmdtTrfCdT3;
	}
	
	/**
	 * Column Info
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType;
	}
	
	/**
	 * Column Info
	 * @param fmPayDt
	 */	
	public void setFmPayDt(String fmPayDt) {
		this.fmPayDt = fmPayDt;
	}

	/**
	 * Column Info
	 * @param toPayDt
	 */
	public void setToPayDt(String toPayDt) {
		this.toPayDt = toPayDt;
	}

	/**
	 * Column Info
	 * @param fmIfDt
	 */
	public void setFmIfDt(String fmIfDt) {
		this.fmIfDt = fmIfDt;
	}

	/**
	 * Column Info
	 * @param toIfDt
	 */
	public void setToIfDt(String toIfDt) {
		this.toIfDt = toIfDt;
	}
	
	/**
	 * Column Info
	 * @param invoiceNo
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
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
	 * @param sInvoiceNo
	 */
	public void setSInvoiceNo(String sInvoiceNo) {
		this.sInvoiceNo = sInvoiceNo;
	}
	
	/**
	 * Column Info
	 * @param sBkgNo
	 */
	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
	}
	
	public String getErpOfc() {
		return erpOfc;
	}

	public void setErpOfc(String erpOfc) {
		this.erpOfc = erpOfc;
	}

	public String getErpDt() {
		return erpDt;
	}

	public void setErpDt(String erpDt) {
		this.erpDt = erpDt;
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
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setFmDtT2(JSPUtil.getParameter(request, prefix + "fm_dt_t2", ""));
		setToDtT2(JSPUtil.getParameter(request, prefix + "to_dt_t2", ""));
		setOfcTp(JSPUtil.getParameter(request, prefix + "ofc_tp", ""));
		setType(JSPUtil.getParameter(request, prefix + "type", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setActCustCd(JSPUtil.getParameter(request, prefix + "act_cust_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, prefix + "usr_ofc_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setSessionOfcCd(JSPUtil.getParameter(request, prefix + "session_ofc_cd", ""));
		setBtnId(JSPUtil.getParameter(request, prefix + "btn_id", ""));
		setDmdtTrfCdT1(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd_t1", ""));
		setDmdtTrfCdT3(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd_t3", ""));
		setCustType(JSPUtil.getParameter(request, prefix + "cust_type", ""));
		setFmPayDt(JSPUtil.getParameter(request, prefix + "fm_pay_dt", ""));
		setToPayDt(JSPUtil.getParameter(request, prefix + "to_pay_dt", ""));
		setFmIfDt(JSPUtil.getParameter(request, prefix + "fm_if_dt", ""));
		setToIfDt(JSPUtil.getParameter(request, prefix + "to_if_dt", ""));	
		setInvoiceNo(JSPUtil.getParameter(request, prefix + "invoice_no", ""));	
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));			
		setSInvoiceNo(JSPUtil.getParameter(request, prefix + "s_invoice_no", ""));	
		setSBkgNo(JSPUtil.getParameter(request, prefix + "s_bkg_no", ""));			
		setErpOfc(JSPUtil.getParameter(request, prefix + "erp_ofc", ""));			
		setErpDt(JSPUtil.getParameter(request, prefix + "erp_dt", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInterfaceParmVO[]
	 */
	public ARInterfaceParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARInterfaceParmVO[]
	 */
	public ARInterfaceParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInterfaceParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] fmDtT2 = (JSPUtil.getParameter(request, prefix	+ "fm_dt_t2", length));
			String[] toDtT2 = (JSPUtil.getParameter(request, prefix	+ "to_dt_t2", length));
			String[] ofcTp = (JSPUtil.getParameter(request, prefix	+ "ofc_tp", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] actCustCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] sessionOfcCd = (JSPUtil.getParameter(request, prefix	+ "session_ofc_cd", length));
			String[] btnId = (JSPUtil.getParameter(request, prefix	+ "btn_id", length));
			String[] dmdtTrfCdT1 = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd_t1", length));
			String[] dmdtTrfCdT3 = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd_t3", length));
			String[] custType = (JSPUtil.getParameter(request, prefix	+ "cust_type", length));
			String[] fmPayDt = (JSPUtil.getParameter(request, prefix+ "fm_pay_dt", length));
			String[] toPayDt = (JSPUtil.getParameter(request, prefix+ "to_pay_dt", length));
			String[] fmIfDt  = (JSPUtil.getParameter(request, prefix+ "fm_if_dt",  length));
			String[] toIfDt  = (JSPUtil.getParameter(request, prefix+ "to_if_dt",  length));
			String[] invoiceNo  = (JSPUtil.getParameter(request, prefix+ "invoice_no",  length));
			String[] bkgNo  = (JSPUtil.getParameter(request, prefix+ "bkg_no",  length));
			String[] sInvoiceNo  = (JSPUtil.getParameter(request, prefix+ "s_invoice_no",  length));
			String[] sBkgNo  = (JSPUtil.getParameter(request, prefix+ "s_bkg_no",  length));
			String[] erpOfc  = (JSPUtil.getParameter(request, prefix+ "erp_ofc",  length));
			String[] erpDt  = (JSPUtil.getParameter(request, prefix+ "erp_dt",  length));
			
			for (int i = 0; i < length; i++) {
				model = new ARInterfaceParmVO();
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (fmDtT2[i] != null)
					model.setFmDtT2(fmDtT2[i]);
				if (toDtT2[i] != null)
					model.setToDtT2(toDtT2[i]);
				if (ofcTp[i] != null)
					model.setOfcTp(ofcTp[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (actCustCd[i] != null)
					model.setActCustCd(actCustCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (sessionOfcCd[i] != null)
					model.setSessionOfcCd(sessionOfcCd[i]);
				if (btnId[i] != null)
					model.setBtnId(btnId[i]);
				if (dmdtTrfCdT1[i] != null)
					model.setDmdtTrfCdT1(dmdtTrfCdT1[i]);
				if (dmdtTrfCdT3[i] != null)
					model.setDmdtTrfCdT3(dmdtTrfCdT3[i]);
				if (custType[i] != null)
					model.setCustType(custType[i]);
				if (fmPayDt[i] != null)
					model.setFmPayDt(fmPayDt[i]);
				if (toPayDt[i] != null)
					model.setToPayDt(toPayDt[i]);
				if (fmIfDt[i] != null)
					model.setFmIfDt(fmIfDt[i]);
				if (toIfDt[i] != null)
					model.setToIfDt(toIfDt[i]);	
				if (invoiceNo[i] != null)
					model.setInvoiceNo(invoiceNo[i]);	
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);					
				if (sInvoiceNo[i] != null)
					model.setSInvoiceNo(sInvoiceNo[i]);	
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);			
				if (erpOfc[i] != null)
					model.setErpOfc(erpOfc[i]);			
				if (erpDt[i] != null)
					model.setErpDt(erpDt[i]);			
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARInterfaceParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARInterfaceParmVO[]
	 */
	public ARInterfaceParmVO[] getARInterfaceParmVOs(){
		ARInterfaceParmVO[] vos = (ARInterfaceParmVO[])models.toArray(new ARInterfaceParmVO[models.size()]);
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
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDtT2 = this.fmDtT2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDtT2 = this.toDtT2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTp = this.ofcTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCd = this.actCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sessionOfcCd = this.sessionOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btnId = this.btnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCdT1 = this.dmdtTrfCdT1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCdT3 = this.dmdtTrfCdT3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custType = this.custType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPayDt = this.fmPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPayDt = this.toPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmIfDt = this.fmIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toIfDt = this.toIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceNo = this.invoiceNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.sInvoiceNo = this.sInvoiceNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.erpOfc = this.erpOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.erpDt = this.erpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
	}
}
