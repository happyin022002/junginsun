/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ComCsrRequestHeaderVO.java
*@FileTitle : ComCsrRequestHeaderVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.csr.csrapproval.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class ComCsrRequestHeaderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComCsrRequestHeaderVO> models = new ArrayList<ComCsrRequestHeaderVO>();
	
	/* Column Info */
	private String budget = null;
	/* Column Info */
	private String payTo = null;
	/* Column Info */
	private String subject = null;
	/* Column Info */
	private String evidence = null;
	/* Column Info */
	private String csrdate = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String currency = null;
	/* Column Info */
	private String amount = null;
	/* Column Info */
	private String pymtAmt = null;
	/* Column Info */
	private String arOffsetNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aprLine = null;
	/* Column Info */
	private String description = null;
	/* Column Info */
	private String performance = null;
	/* Column Info */
	private String loginOffice = null;
	/* Column Info */
	private String lastAprId = null;
	/* Column Info */
	private String dueDate = null;
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String qty = null;
	/* Column Info */
	private String payGroup = null;
	/* Column Info */
	private String invoiceDate = null;
	/* Column Info */
	private String vatregistno = null;
	/* Column Info */
	private String prpdBy = null;
	/* Column Info */
	private String ratio = null;
	/* Column Info */
	private String asaNo = null;
	/* Column Info */
	private String csrType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ComCsrRequestHeaderVO() {}

	public ComCsrRequestHeaderVO(String ibflag, String pagerows, String subject, String vatregistno, String csrdate, String csrNo, String office, String prpdBy, String budget, String performance, String ratio, String payTo, String description, String evidence, String qty, String invoiceDate, String dueDate, String arOffsetNo, String csrType, String payGroup, String asaNo, String currency, String amount, String pymtAmt, String aprLine, String loginOffice, String lastAprId) {
		this.budget = budget;
		this.payTo = payTo;
		this.subject = subject;
		this.evidence = evidence;
		this.csrdate = csrdate;
		this.pagerows = pagerows;
		this.currency = currency;
		this.amount = amount;
		this.pymtAmt = pymtAmt;
		this.arOffsetNo = arOffsetNo;
		this.ibflag = ibflag;
		this.aprLine = aprLine;
		this.description = description;
		this.performance = performance;
		this.loginOffice = loginOffice;
		this.lastAprId = lastAprId;
		this.dueDate = dueDate;
		this.office = office;
		this.csrNo = csrNo;
		this.qty = qty;
		this.payGroup = payGroup;
		this.invoiceDate = invoiceDate;
		this.vatregistno = vatregistno;
		this.prpdBy = prpdBy;
		this.ratio = ratio;
		this.asaNo = asaNo;
		this.csrType = csrType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("budget", getBudget());
		this.hashColumns.put("pay_to", getPayTo());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("evidence", getEvidence());
		this.hashColumns.put("csrdate", getCsrdate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("currency", getCurrency());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("pymt_amt", getPymtAmt());
		this.hashColumns.put("ar_offset_no", getArOffsetNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("apr_line", getAprLine());
		this.hashColumns.put("description", getDescription());
		this.hashColumns.put("performance", getPerformance());
		this.hashColumns.put("login_office", getLoginOffice());
		this.hashColumns.put("last_apr_id", getLastAprId());
		this.hashColumns.put("due_date", getDueDate());
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("pay_group", getPayGroup());
		this.hashColumns.put("invoice_date", getInvoiceDate());
		this.hashColumns.put("vatregistno", getVatregistno());
		this.hashColumns.put("prpd_by", getPrpdBy());
		this.hashColumns.put("ratio", getRatio());
		this.hashColumns.put("asa_no", getAsaNo());
		this.hashColumns.put("csr_type", getCsrType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("budget", "budget");
		this.hashFields.put("pay_to", "payTo");
		this.hashFields.put("subject", "subject");
		this.hashFields.put("evidence", "evidence");
		this.hashFields.put("csrdate", "csrdate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("currency", "currency");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("pymt_amt", "pymtAmt");
		this.hashFields.put("ar_offset_no", "arOffsetNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("apr_line", "aprLine");
		this.hashFields.put("description", "description");
		this.hashFields.put("performance", "performance");
		this.hashFields.put("login_office", "loginOffice");
		this.hashFields.put("last_apr_id", "lastAprId");
		this.hashFields.put("due_date", "dueDate");
		this.hashFields.put("office", "office");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("pay_group", "payGroup");
		this.hashFields.put("invoice_date", "invoiceDate");
		this.hashFields.put("vatregistno", "vatregistno");
		this.hashFields.put("prpd_by", "prpdBy");
		this.hashFields.put("ratio", "ratio");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("csr_type", "csrType");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return budget
	 */
	public String getBudget() {
		return this.budget;
	}
	
	/**
	 * Column Info
	 * @return payTo
	 */
	public String getPayTo() {
		return this.payTo;
	}
	
	/**
	 * Column Info
	 * @return subject
	 */
	public String getSubject() {
		return this.subject;
	}
	
	/**
	 * Column Info
	 * @return evidence
	 */
	public String getEvidence() {
		return this.evidence;
	}
	
	/**
	 * Column Info
	 * @return csrdate
	 */
	public String getCsrdate() {
		return this.csrdate;
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
	 * @return currency
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Column Info
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
	}
	
	/**
	 * Column Info
	 * @return pymtAmt
	 */
	public String getPymtAmt() {
		return this.pymtAmt;
	}
	
	/**
	 * Column Info
	 * @return arOffsetNo
	 */
	public String getArOffsetNo() {
		return this.arOffsetNo;
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
	 * @return aprLine
	 */
	public String getAprLine() {
		return this.aprLine;
	}
	
	/**
	 * Column Info
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Column Info
	 * @return performance
	 */
	public String getPerformance() {
		return this.performance;
	}
	
	/**
	 * Column Info
	 * @return loginOffice
	 */
	public String getLoginOffice() {
		return this.loginOffice;
	}
	
	/**
	 * Column Info
	 * @return lastAprId
	 */
	public String getLastAprId() {
		return this.lastAprId;
	}
	
	/**
	 * Column Info
	 * @return dueDate
	 */
	public String getDueDate() {
		return this.dueDate;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
	}
	
	/**
	 * Column Info
	 * @return payGroup
	 */
	public String getPayGroup() {
		return this.payGroup;
	}
	
	/**
	 * Column Info
	 * @return invoiceDat
	 */
	public String getInvoiceDate() {
		return this.invoiceDate;
	}
	
	/**
	 * Column Info
	 * @return vatregistno
	 */
	public String getVatregistno() {
		return this.vatregistno;
	}
	
	/**
	 * Column Info
	 * @return prpdBy
	 */
	public String getPrpdBy() {
		return this.prpdBy;
	}
	
	/**
	 * Column Info
	 * @return ratio
	 */
	public String getRatio() {
		return this.ratio;
	}
	
	/**
	 * Column Info
	 * @return asaNo
	 */
	public String getAsaNo() {
		return this.asaNo;
	}
	
	/**
	 * Column Info
	 * @return csrType
	 */
	public String getCsrType() {
		return this.csrType;
	}
	

	/**
	 * Column Info
	 * @param budget
	 */
	public void setBudget(String budget) {
		this.budget = budget;
	}
	
	/**
	 * Column Info
	 * @param payTo
	 */
	public void setPayTo(String payTo) {
		this.payTo = payTo;
	}
	
	/**
	 * Column Info
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * Column Info
	 * @param evidence
	 */
	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}
	
	/**
	 * Column Info
	 * @param csrdate
	 */
	public void setCsrdate(String csrdate) {
		this.csrdate = csrdate;
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
	 * @param currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	/**
	 * Column Info
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * Column Info
	 * @param pymtAmt
	 */
	public void setPymtAmt(String pymtAmt) {
		this.pymtAmt = pymtAmt;
	}
	
	/**
	 * Column Info
	 * @param arOffsetNo
	 */
	public void setArOffsetNo(String arOffsetNo) {
		this.arOffsetNo = arOffsetNo;
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
	 * @param aprLine
	 */
	public void setAprLine(String aprLine) {
		this.aprLine = aprLine;
	}
	
	/**
	 * Column Info
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Column Info
	 * @param performance
	 */
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	
	/**
	 * Column Info
	 * @param loginOffice
	 */
	public void setLoginOffice(String loginOffice) {
		this.loginOffice = loginOffice;
	}
	
	/**
	 * Column Info
	 * @param lastAprId
	 */
	public void setLastAprId(String lastAprId) {
		this.lastAprId = lastAprId;
	}
	
	/**
	 * Column Info
	 * @param dueDate
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	/**
	 * Column Info
	 * @param payGroup
	 */
	public void setPayGroup(String payGroup) {
		this.payGroup = payGroup;
	}
	
	/**
	 * Column Info
	 * @param invoiceDat
	 */
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	/**
	 * Column Info
	 * @param vatregistno
	 */
	public void setVatregistno(String vatregistno) {
		this.vatregistno = vatregistno;
	}
	
	/**
	 * Column Info
	 * @param prpdBy
	 */
	public void setPrpdBy(String prpdBy) {
		this.prpdBy = prpdBy;
	}
	
	/**
	 * Column Info
	 * @param ratio
	 */
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	
	/**
	 * Column Info
	 * @param asaNo
	 */
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
	}
	
	/**
	 * Column Info
	 * @param csrType
	 */
	public void setCsrType(String csrType) {
		this.csrType = csrType;
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
		setBudget(JSPUtil.getParameter(request, prefix + "budget", ""));
		setPayTo(JSPUtil.getParameter(request, prefix + "pay_to", ""));
		setSubject(JSPUtil.getParameter(request, prefix + "subject", ""));
		setEvidence(JSPUtil.getParameter(request, prefix + "evidence", ""));
		setCsrdate(JSPUtil.getParameter(request, prefix + "csrdate", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCurrency(JSPUtil.getParameter(request, prefix + "currency", ""));
		setAmount(JSPUtil.getParameter(request, prefix + "amount", ""));
		setPymtAmt(JSPUtil.getParameter(request, prefix + "pymt_amt", ""));
		setArOffsetNo(JSPUtil.getParameter(request, prefix + "ar_offset_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAprLine(JSPUtil.getParameter(request, prefix + "apr_line", ""));
		setDescription(JSPUtil.getParameter(request, prefix + "description", ""));
		setPerformance(JSPUtil.getParameter(request, prefix + "performance", ""));
		setLoginOffice(JSPUtil.getParameter(request, prefix + "login_office", ""));
		setLastAprId(JSPUtil.getParameter(request, prefix + "last_apr_id", ""));
		setDueDate(JSPUtil.getParameter(request, prefix + "due_date", ""));
		setOffice(JSPUtil.getParameter(request, prefix + "office", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setQty(JSPUtil.getParameter(request, prefix + "qty", ""));
		setPayGroup(JSPUtil.getParameter(request, prefix + "pay_group", ""));
		setInvoiceDate(JSPUtil.getParameter(request, prefix + "invoice_date", ""));
		setVatregistno(JSPUtil.getParameter(request, prefix + "vatregistno", ""));
		setPrpdBy(JSPUtil.getParameter(request, prefix + "prpd_by", ""));
		setRatio(JSPUtil.getParameter(request, prefix + "ratio", ""));
		setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
		setCsrType(JSPUtil.getParameter(request, prefix + "csr_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComCsrRequestHeaderVO[]
	 */
	public ComCsrRequestHeaderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComCsrRequestHeaderVO[]
	 */
	public ComCsrRequestHeaderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComCsrRequestHeaderVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] budget = (JSPUtil.getParameter(request, prefix	+ "budget", length));
			String[] payTo = (JSPUtil.getParameter(request, prefix	+ "pay_to", length));
			String[] subject = (JSPUtil.getParameter(request, prefix	+ "subject", length));
			String[] evidence = (JSPUtil.getParameter(request, prefix	+ "evidence", length));
			String[] csrdate = (JSPUtil.getParameter(request, prefix	+ "csrdate", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] currency = (JSPUtil.getParameter(request, prefix	+ "currency", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] pymtAmt = (JSPUtil.getParameter(request, prefix	+ "pymt_amt", length));
			String[] arOffsetNo = (JSPUtil.getParameter(request, prefix	+ "ar_offset_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aprLine = (JSPUtil.getParameter(request, prefix	+ "apr_line", length));
			String[] description = (JSPUtil.getParameter(request, prefix	+ "description", length));
			String[] performance = (JSPUtil.getParameter(request, prefix	+ "performance", length));
			String[] loginOffice = (JSPUtil.getParameter(request, prefix	+ "login_office", length));
			String[] lastAprId = (JSPUtil.getParameter(request, prefix	+ "last_apr_id", length));
			String[] dueDate = (JSPUtil.getParameter(request, prefix	+ "due_date", length));
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty", length));
			String[] payGroup = (JSPUtil.getParameter(request, prefix	+ "pay_group", length));
			String[] invoiceDat = (JSPUtil.getParameter(request, prefix	+ "invoice_dat", length));
			String[] vatregistno = (JSPUtil.getParameter(request, prefix	+ "vatregistno", length));
			String[] prpdBy = (JSPUtil.getParameter(request, prefix	+ "prpd_by", length));
			String[] ratio = (JSPUtil.getParameter(request, prefix	+ "ratio", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			String[] csrType = (JSPUtil.getParameter(request, prefix	+ "csr_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComCsrRequestHeaderVO();
				if (budget[i] != null)
					model.setBudget(budget[i]);
				if (payTo[i] != null)
					model.setPayTo(payTo[i]);
				if (subject[i] != null)
					model.setSubject(subject[i]);
				if (evidence[i] != null)
					model.setEvidence(evidence[i]);
				if (csrdate[i] != null)
					model.setCsrdate(csrdate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (currency[i] != null)
					model.setCurrency(currency[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (pymtAmt[i] != null)
					model.setPymtAmt(pymtAmt[i]);
				if (arOffsetNo[i] != null)
					model.setArOffsetNo(arOffsetNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aprLine[i] != null)
					model.setAprLine(aprLine[i]);
				if (description[i] != null)
					model.setDescription(description[i]);
				if (performance[i] != null)
					model.setPerformance(performance[i]);
				if (loginOffice[i] != null)
					model.setLoginOffice(loginOffice[i]);
				if (lastAprId[i] != null)
					model.setLastAprId(lastAprId[i]);
				if (dueDate[i] != null)
					model.setDueDate(dueDate[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (payGroup[i] != null)
					model.setPayGroup(payGroup[i]);
				if (invoiceDat[i] != null)
					model.setInvoiceDate(invoiceDat[i]);
				if (vatregistno[i] != null)
					model.setVatregistno(vatregistno[i]);
				if (prpdBy[i] != null)
					model.setPrpdBy(prpdBy[i]);
				if (ratio[i] != null)
					model.setRatio(ratio[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				if (csrType[i] != null)
					model.setCsrType(csrType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComCsrRequestHeaderVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComCsrRequestHeaderVO[]
	 */
	public ComCsrRequestHeaderVO[] getComCsrRequestHeaderVOs(){
		ComCsrRequestHeaderVO[] vos = (ComCsrRequestHeaderVO[])models.toArray(new ComCsrRequestHeaderVO[models.size()]);
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
		this.budget = this.budget .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTo = this.payTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evidence = this.evidence .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrdate = this.csrdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currency = this.currency .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pymtAmt = this.pymtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOffsetNo = this.arOffsetNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aprLine = this.aprLine .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.description = this.description .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.performance = this.performance .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOffice = this.loginOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastAprId = this.lastAprId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDate = this.dueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payGroup = this.payGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceDate = this.invoiceDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatregistno = this.vatregistno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpdBy = this.prpdBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio = this.ratio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrType = this.csrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
