/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DocQueueSummaryReturnFeedbackVO.java
*@FileTitle : DocQueueSummaryReturnFeedbackVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.06.20 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocQueueSummaryReturnFeedbackVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocQueueSummaryReturnFeedbackVO> models = new ArrayList<DocQueueSummaryReturnFeedbackVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String foRqst = null;
	/* Column Info */
	private String totalPer = null;
	/* Column Info */
	private String kind = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String customerD3 = null;
	/* Column Info */
	private String customerD5 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String customerD1 = null;
	/* Column Info */
	private String customerPer = null;
	/* Column Info */
	private String customerRqst = null;
	/* Column Info */
	private String foPer = null;
	/* Column Info */
	private String totalRqst = null;
	/* Column Info */
	private String inputPer = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String rateD5 = null;
	/* Column Info */
	private String ratePer = null;
	/* Column Info */
	private String foD1 = null;
	/* Column Info */
	private String inputD5 = null;
	/* Column Info */
	private String inputRqst = null;
	/* Column Info */
	private String inputD3 = null;
	/* Column Info */
	private String rateRqst = null;
	/* Column Info */
	private String inputD1 = null;
	/* Column Info */
	private String foD5 = null;
	/* Column Info */
	private String foD3 = null;
	/* Column Info */
	private String rateD1 = null;
	/* Column Info */
	private String rateD3 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocQueueSummaryReturnFeedbackVO() {}

	public DocQueueSummaryReturnFeedbackVO(String ibflag, String pagerows, String region, String bkgOfcCd, String kind, String total, String totalRqst, String totalPer, String inputRqst, String inputD1, String inputD3, String inputD5, String inputPer, String rateRqst, String rateD1, String rateD3, String rateD5, String ratePer, String foRqst, String foD1, String foD3, String foD5, String foPer, String customerRqst, String customerD1, String customerD3, String customerD5, String customerPer) {
		this.total = total;
		this.region = region;
		this.foRqst = foRqst;
		this.totalPer = totalPer;
		this.kind = kind;
		this.pagerows = pagerows;
		this.customerD3 = customerD3;
		this.customerD5 = customerD5;
		this.ibflag = ibflag;
		this.customerD1 = customerD1;
		this.customerPer = customerPer;
		this.customerRqst = customerRqst;
		this.foPer = foPer;
		this.totalRqst = totalRqst;
		this.inputPer = inputPer;
		this.bkgOfcCd = bkgOfcCd;
		this.rateD5 = rateD5;
		this.ratePer = ratePer;
		this.foD1 = foD1;
		this.inputD5 = inputD5;
		this.inputRqst = inputRqst;
		this.inputD3 = inputD3;
		this.rateRqst = rateRqst;
		this.inputD1 = inputD1;
		this.foD5 = foD5;
		this.foD3 = foD3;
		this.rateD1 = rateD1;
		this.rateD3 = rateD3;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("fo_rqst", getFoRqst());
		this.hashColumns.put("total_per", getTotalPer());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("customer_d3", getCustomerD3());
		this.hashColumns.put("customer_d5", getCustomerD5());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("customer_d1", getCustomerD1());
		this.hashColumns.put("customer_per", getCustomerPer());
		this.hashColumns.put("customer_rqst", getCustomerRqst());
		this.hashColumns.put("fo_per", getFoPer());
		this.hashColumns.put("total_rqst", getTotalRqst());
		this.hashColumns.put("input_per", getInputPer());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("rate_d5", getRateD5());
		this.hashColumns.put("rate_per", getRatePer());
		this.hashColumns.put("fo_d1", getFoD1());
		this.hashColumns.put("input_d5", getInputD5());
		this.hashColumns.put("input_rqst", getInputRqst());
		this.hashColumns.put("input_d3", getInputD3());
		this.hashColumns.put("rate_rqst", getRateRqst());
		this.hashColumns.put("input_d1", getInputD1());
		this.hashColumns.put("fo_d5", getFoD5());
		this.hashColumns.put("fo_d3", getFoD3());
		this.hashColumns.put("rate_d1", getRateD1());
		this.hashColumns.put("rate_d3", getRateD3());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("region", "region");
		this.hashFields.put("fo_rqst", "foRqst");
		this.hashFields.put("total_per", "totalPer");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("customer_d3", "customerD3");
		this.hashFields.put("customer_d5", "customerD5");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("customer_d1", "customerD1");
		this.hashFields.put("customer_per", "customerPer");
		this.hashFields.put("customer_rqst", "customerRqst");
		this.hashFields.put("fo_per", "foPer");
		this.hashFields.put("total_rqst", "totalRqst");
		this.hashFields.put("input_per", "inputPer");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("rate_d5", "rateD5");
		this.hashFields.put("rate_per", "ratePer");
		this.hashFields.put("fo_d1", "foD1");
		this.hashFields.put("input_d5", "inputD5");
		this.hashFields.put("input_rqst", "inputRqst");
		this.hashFields.put("input_d3", "inputD3");
		this.hashFields.put("rate_rqst", "rateRqst");
		this.hashFields.put("input_d1", "inputD1");
		this.hashFields.put("fo_d5", "foD5");
		this.hashFields.put("fo_d3", "foD3");
		this.hashFields.put("rate_d1", "rateD1");
		this.hashFields.put("rate_d3", "rateD3");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Column Info
	 * @return foRqst
	 */
	public String getFoRqst() {
		return this.foRqst;
	}
	
	/**
	 * Column Info
	 * @return totalPer
	 */
	public String getTotalPer() {
		return this.totalPer;
	}
	
	/**
	 * Column Info
	 * @return kind
	 */
	public String getKind() {
		return this.kind;
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
	 * @return customerD3
	 */
	public String getCustomerD3() {
		return this.customerD3;
	}
	
	/**
	 * Column Info
	 * @return customerD5
	 */
	public String getCustomerD5() {
		return this.customerD5;
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
	 * @return customerD1
	 */
	public String getCustomerD1() {
		return this.customerD1;
	}
	
	/**
	 * Column Info
	 * @return customerPer
	 */
	public String getCustomerPer() {
		return this.customerPer;
	}
	
	/**
	 * Column Info
	 * @return customerRqst
	 */
	public String getCustomerRqst() {
		return this.customerRqst;
	}
	
	/**
	 * Column Info
	 * @return foPer
	 */
	public String getFoPer() {
		return this.foPer;
	}
	
	/**
	 * Column Info
	 * @return totalRqst
	 */
	public String getTotalRqst() {
		return this.totalRqst;
	}
	
	/**
	 * Column Info
	 * @return inputPer
	 */
	public String getInputPer() {
		return this.inputPer;
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
	 * @return rateD5
	 */
	public String getRateD5() {
		return this.rateD5;
	}
	
	/**
	 * Column Info
	 * @return ratePer
	 */
	public String getRatePer() {
		return this.ratePer;
	}
	
	/**
	 * Column Info
	 * @return foD1
	 */
	public String getFoD1() {
		return this.foD1;
	}
	
	/**
	 * Column Info
	 * @return inputD5
	 */
	public String getInputD5() {
		return this.inputD5;
	}
	
	/**
	 * Column Info
	 * @return inputRqst
	 */
	public String getInputRqst() {
		return this.inputRqst;
	}
	
	/**
	 * Column Info
	 * @return inputD3
	 */
	public String getInputD3() {
		return this.inputD3;
	}
	
	/**
	 * Column Info
	 * @return rateRqst
	 */
	public String getRateRqst() {
		return this.rateRqst;
	}
	
	/**
	 * Column Info
	 * @return inputD1
	 */
	public String getInputD1() {
		return this.inputD1;
	}
	
	/**
	 * Column Info
	 * @return foD5
	 */
	public String getFoD5() {
		return this.foD5;
	}
	
	/**
	 * Column Info
	 * @return foD3
	 */
	public String getFoD3() {
		return this.foD3;
	}
	
	/**
	 * Column Info
	 * @return rateD1
	 */
	public String getRateD1() {
		return this.rateD1;
	}
	
	/**
	 * Column Info
	 * @return rateD3
	 */
	public String getRateD3() {
		return this.rateD3;
	}
	

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Column Info
	 * @param foRqst
	 */
	public void setFoRqst(String foRqst) {
		this.foRqst = foRqst;
	}
	
	/**
	 * Column Info
	 * @param totalPer
	 */
	public void setTotalPer(String totalPer) {
		this.totalPer = totalPer;
	}
	
	/**
	 * Column Info
	 * @param kind
	 */
	public void setKind(String kind) {
		this.kind = kind;
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
	 * @param customerD3
	 */
	public void setCustomerD3(String customerD3) {
		this.customerD3 = customerD3;
	}
	
	/**
	 * Column Info
	 * @param customerD5
	 */
	public void setCustomerD5(String customerD5) {
		this.customerD5 = customerD5;
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
	 * @param customerD1
	 */
	public void setCustomerD1(String customerD1) {
		this.customerD1 = customerD1;
	}
	
	/**
	 * Column Info
	 * @param customerPer
	 */
	public void setCustomerPer(String customerPer) {
		this.customerPer = customerPer;
	}
	
	/**
	 * Column Info
	 * @param customerRqst
	 */
	public void setCustomerRqst(String customerRqst) {
		this.customerRqst = customerRqst;
	}
	
	/**
	 * Column Info
	 * @param foPer
	 */
	public void setFoPer(String foPer) {
		this.foPer = foPer;
	}
	
	/**
	 * Column Info
	 * @param totalRqst
	 */
	public void setTotalRqst(String totalRqst) {
		this.totalRqst = totalRqst;
	}
	
	/**
	 * Column Info
	 * @param inputPer
	 */
	public void setInputPer(String inputPer) {
		this.inputPer = inputPer;
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
	 * @param rateD5
	 */
	public void setRateD5(String rateD5) {
		this.rateD5 = rateD5;
	}
	
	/**
	 * Column Info
	 * @param ratePer
	 */
	public void setRatePer(String ratePer) {
		this.ratePer = ratePer;
	}
	
	/**
	 * Column Info
	 * @param foD1
	 */
	public void setFoD1(String foD1) {
		this.foD1 = foD1;
	}
	
	/**
	 * Column Info
	 * @param inputD5
	 */
	public void setInputD5(String inputD5) {
		this.inputD5 = inputD5;
	}
	
	/**
	 * Column Info
	 * @param inputRqst
	 */
	public void setInputRqst(String inputRqst) {
		this.inputRqst = inputRqst;
	}
	
	/**
	 * Column Info
	 * @param inputD3
	 */
	public void setInputD3(String inputD3) {
		this.inputD3 = inputD3;
	}
	
	/**
	 * Column Info
	 * @param rateRqst
	 */
	public void setRateRqst(String rateRqst) {
		this.rateRqst = rateRqst;
	}
	
	/**
	 * Column Info
	 * @param inputD1
	 */
	public void setInputD1(String inputD1) {
		this.inputD1 = inputD1;
	}
	
	/**
	 * Column Info
	 * @param foD5
	 */
	public void setFoD5(String foD5) {
		this.foD5 = foD5;
	}
	
	/**
	 * Column Info
	 * @param foD3
	 */
	public void setFoD3(String foD3) {
		this.foD3 = foD3;
	}
	
	/**
	 * Column Info
	 * @param rateD1
	 */
	public void setRateD1(String rateD1) {
		this.rateD1 = rateD1;
	}
	
	/**
	 * Column Info
	 * @param rateD3
	 */
	public void setRateD3(String rateD3) {
		this.rateD3 = rateD3;
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
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setRegion(JSPUtil.getParameter(request, prefix + "region", ""));
		setFoRqst(JSPUtil.getParameter(request, prefix + "fo_rqst", ""));
		setTotalPer(JSPUtil.getParameter(request, prefix + "total_per", ""));
		setKind(JSPUtil.getParameter(request, prefix + "kind", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustomerD3(JSPUtil.getParameter(request, prefix + "customer_d3", ""));
		setCustomerD5(JSPUtil.getParameter(request, prefix + "customer_d5", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCustomerD1(JSPUtil.getParameter(request, prefix + "customer_d1", ""));
		setCustomerPer(JSPUtil.getParameter(request, prefix + "customer_per", ""));
		setCustomerRqst(JSPUtil.getParameter(request, prefix + "customer_rqst", ""));
		setFoPer(JSPUtil.getParameter(request, prefix + "fo_per", ""));
		setTotalRqst(JSPUtil.getParameter(request, prefix + "total_rqst", ""));
		setInputPer(JSPUtil.getParameter(request, prefix + "input_per", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setRateD5(JSPUtil.getParameter(request, prefix + "rate_d5", ""));
		setRatePer(JSPUtil.getParameter(request, prefix + "rate_per", ""));
		setFoD1(JSPUtil.getParameter(request, prefix + "fo_d1", ""));
		setInputD5(JSPUtil.getParameter(request, prefix + "input_d5", ""));
		setInputRqst(JSPUtil.getParameter(request, prefix + "input_rqst", ""));
		setInputD3(JSPUtil.getParameter(request, prefix + "input_d3", ""));
		setRateRqst(JSPUtil.getParameter(request, prefix + "rate_rqst", ""));
		setInputD1(JSPUtil.getParameter(request, prefix + "input_d1", ""));
		setFoD5(JSPUtil.getParameter(request, prefix + "fo_d5", ""));
		setFoD3(JSPUtil.getParameter(request, prefix + "fo_d3", ""));
		setRateD1(JSPUtil.getParameter(request, prefix + "rate_d1", ""));
		setRateD3(JSPUtil.getParameter(request, prefix + "rate_d3", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocQueueSummaryReturnFeedbackVO[]
	 */
	public DocQueueSummaryReturnFeedbackVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocQueueSummaryReturnFeedbackVO[]
	 */
	public DocQueueSummaryReturnFeedbackVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocQueueSummaryReturnFeedbackVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] foRqst = (JSPUtil.getParameter(request, prefix	+ "fo_rqst", length));
			String[] totalPer = (JSPUtil.getParameter(request, prefix	+ "total_per", length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] customerD3 = (JSPUtil.getParameter(request, prefix	+ "customer_d3", length));
			String[] customerD5 = (JSPUtil.getParameter(request, prefix	+ "customer_d5", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] customerD1 = (JSPUtil.getParameter(request, prefix	+ "customer_d1", length));
			String[] customerPer = (JSPUtil.getParameter(request, prefix	+ "customer_per", length));
			String[] customerRqst = (JSPUtil.getParameter(request, prefix	+ "customer_rqst", length));
			String[] foPer = (JSPUtil.getParameter(request, prefix	+ "fo_per", length));
			String[] totalRqst = (JSPUtil.getParameter(request, prefix	+ "total_rqst", length));
			String[] inputPer = (JSPUtil.getParameter(request, prefix	+ "input_per", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] rateD5 = (JSPUtil.getParameter(request, prefix	+ "rate_d5", length));
			String[] ratePer = (JSPUtil.getParameter(request, prefix	+ "rate_per", length));
			String[] foD1 = (JSPUtil.getParameter(request, prefix	+ "fo_d1", length));
			String[] inputD5 = (JSPUtil.getParameter(request, prefix	+ "input_d5", length));
			String[] inputRqst = (JSPUtil.getParameter(request, prefix	+ "input_rqst", length));
			String[] inputD3 = (JSPUtil.getParameter(request, prefix	+ "input_d3", length));
			String[] rateRqst = (JSPUtil.getParameter(request, prefix	+ "rate_rqst", length));
			String[] inputD1 = (JSPUtil.getParameter(request, prefix	+ "input_d1", length));
			String[] foD5 = (JSPUtil.getParameter(request, prefix	+ "fo_d5", length));
			String[] foD3 = (JSPUtil.getParameter(request, prefix	+ "fo_d3", length));
			String[] rateD1 = (JSPUtil.getParameter(request, prefix	+ "rate_d1", length));
			String[] rateD3 = (JSPUtil.getParameter(request, prefix	+ "rate_d3", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocQueueSummaryReturnFeedbackVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (region[i] != null)
					model.setRegion(region[i]);
				if (foRqst[i] != null)
					model.setFoRqst(foRqst[i]);
				if (totalPer[i] != null)
					model.setTotalPer(totalPer[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (customerD3[i] != null)
					model.setCustomerD3(customerD3[i]);
				if (customerD5[i] != null)
					model.setCustomerD5(customerD5[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (customerD1[i] != null)
					model.setCustomerD1(customerD1[i]);
				if (customerPer[i] != null)
					model.setCustomerPer(customerPer[i]);
				if (customerRqst[i] != null)
					model.setCustomerRqst(customerRqst[i]);
				if (foPer[i] != null)
					model.setFoPer(foPer[i]);
				if (totalRqst[i] != null)
					model.setTotalRqst(totalRqst[i]);
				if (inputPer[i] != null)
					model.setInputPer(inputPer[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (rateD5[i] != null)
					model.setRateD5(rateD5[i]);
				if (ratePer[i] != null)
					model.setRatePer(ratePer[i]);
				if (foD1[i] != null)
					model.setFoD1(foD1[i]);
				if (inputD5[i] != null)
					model.setInputD5(inputD5[i]);
				if (inputRqst[i] != null)
					model.setInputRqst(inputRqst[i]);
				if (inputD3[i] != null)
					model.setInputD3(inputD3[i]);
				if (rateRqst[i] != null)
					model.setRateRqst(rateRqst[i]);
				if (inputD1[i] != null)
					model.setInputD1(inputD1[i]);
				if (foD5[i] != null)
					model.setFoD5(foD5[i]);
				if (foD3[i] != null)
					model.setFoD3(foD3[i]);
				if (rateD1[i] != null)
					model.setRateD1(rateD1[i]);
				if (rateD3[i] != null)
					model.setRateD3(rateD3[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocQueueSummaryReturnFeedbackVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocQueueSummaryReturnFeedbackVO[]
	 */
	public DocQueueSummaryReturnFeedbackVO[] getDocQueueSummaryReturnFeedbackVOs(){
		DocQueueSummaryReturnFeedbackVO[] vos = (DocQueueSummaryReturnFeedbackVO[])models.toArray(new DocQueueSummaryReturnFeedbackVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foRqst = this.foRqst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalPer = this.totalPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerD3 = this.customerD3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerD5 = this.customerD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerD1 = this.customerD1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerPer = this.customerPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerRqst = this.customerRqst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foPer = this.foPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalRqst = this.totalRqst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputPer = this.inputPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateD5 = this.rateD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratePer = this.ratePer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foD1 = this.foD1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputD5 = this.inputD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputRqst = this.inputRqst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputD3 = this.inputD3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateRqst = this.rateRqst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputD1 = this.inputD1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foD5 = this.foD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foD3 = this.foD3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateD1 = this.rateD1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateD3 = this.rateD3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
