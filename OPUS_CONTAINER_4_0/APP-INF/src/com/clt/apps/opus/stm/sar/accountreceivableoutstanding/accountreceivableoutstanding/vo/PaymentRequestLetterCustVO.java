/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PaymentRequestLetterCustVO.java
*@FileTitle : PaymentRequestLetterCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.12  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class PaymentRequestLetterCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentRequestLetterCustVO> models = new ArrayList<PaymentRequestLetterCustVO>();
	
	/* Column Info */
	private String totLcl = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String overdueTo = null;
	/* Column Info */
	private String bnd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String balAmt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String overdueFrom = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String exRate = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String overDue = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String xcldOtsTpCd = null;
	/* Column Info */
	private String otsOpy = null;
	/* Column Info */
	private String invDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PaymentRequestLetterCustVO() {}

	public PaymentRequestLetterCustVO(String ibflag, String pagerows, String vvdCd, String blNo, String invNo, String refNo, String polCd, String podCd, String sailArrDt, String invDt, String dueDt, String overDue, String currCd, String balAmt, String exRate, String totLcl, String custCd, String arOfcCd, String bnd, String overdueFrom, String overdueTo, String otsOpy, String xcldOtsTpCd) {
		this.totLcl = totLcl;
		this.currCd = currCd;
		this.overdueTo = overdueTo;
		this.bnd = bnd;
		this.blNo = blNo;
		this.sailArrDt = sailArrDt;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.balAmt = balAmt;
		this.invNo = invNo;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.overdueFrom = overdueFrom;
		this.vvdCd = vvdCd;
		this.custCd = custCd;
		this.exRate = exRate;
		this.refNo = refNo;
		this.overDue = overDue;
		this.dueDt = dueDt;
		this.xcldOtsTpCd = xcldOtsTpCd;
		this.otsOpy = otsOpy;
		this.invDt = invDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tot_lcl", getTotLcl());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("overdue_to", getOverdueTo());
		this.hashColumns.put("bnd", getBnd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bal_amt", getBalAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("overdue_from", getOverdueFrom());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("ex_rate", getExRate());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("over_due", getOverDue());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("xcld_ots_tp_cd", getXcldOtsTpCd());
		this.hashColumns.put("ots_opy", getOtsOpy());
		this.hashColumns.put("inv_dt", getInvDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tot_lcl", "totLcl");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("overdue_to", "overdueTo");
		this.hashFields.put("bnd", "bnd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bal_amt", "balAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("overdue_from", "overdueFrom");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("ex_rate", "exRate");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("over_due", "overDue");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("xcld_ots_tp_cd", "xcldOtsTpCd");
		this.hashFields.put("ots_opy", "otsOpy");
		this.hashFields.put("inv_dt", "invDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return totLcl
	 */
	public String getTotLcl() {
		return this.totLcl;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return overdueTo
	 */
	public String getOverdueTo() {
		return this.overdueTo;
	}
	
	/**
	 * Column Info
	 * @return bnd
	 */
	public String getBnd() {
		return this.bnd;
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
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return balAmt
	 */
	public String getBalAmt() {
		return this.balAmt;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return overdueFrom
	 */
	public String getOverdueFrom() {
		return this.overdueFrom;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return exRate
	 */
	public String getExRate() {
		return this.exRate;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return overDue
	 */
	public String getOverDue() {
		return this.overDue;
	}
	
	/**
	 * Column Info
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return xcldOtsTpCd
	 */
	public String getXcldOtsTpCd() {
		return this.xcldOtsTpCd;
	}
	
	/**
	 * Column Info
	 * @return otsOpy
	 */
	public String getOtsOpy() {
		return this.otsOpy;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
	}
	

	/**
	 * Column Info
	 * @param totLcl
	 */
	public void setTotLcl(String totLcl) {
		this.totLcl = totLcl;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param overdueTo
	 */
	public void setOverdueTo(String overdueTo) {
		this.overdueTo = overdueTo;
	}
	
	/**
	 * Column Info
	 * @param bnd
	 */
	public void setBnd(String bnd) {
		this.bnd = bnd;
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
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param balAmt
	 */
	public void setBalAmt(String balAmt) {
		this.balAmt = balAmt;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param overdueFrom
	 */
	public void setOverdueFrom(String overdueFrom) {
		this.overdueFrom = overdueFrom;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param exRate
	 */
	public void setExRate(String exRate) {
		this.exRate = exRate;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param overDue
	 */
	public void setOverDue(String overDue) {
		this.overDue = overDue;
	}
	
	/**
	 * Column Info
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param xcldOtsTpCd
	 */
	public void setXcldOtsTpCd(String xcldOtsTpCd) {
		this.xcldOtsTpCd = xcldOtsTpCd;
	}
	
	/**
	 * Column Info
	 * @param otsOpy
	 */
	public void setOtsOpy(String otsOpy) {
		this.otsOpy = otsOpy;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
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
		setTotLcl(JSPUtil.getParameter(request, prefix + "tot_lcl", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setOverdueTo(JSPUtil.getParameter(request, prefix + "overdue_to", ""));
		setBnd(JSPUtil.getParameter(request, prefix + "bnd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBalAmt(JSPUtil.getParameter(request, prefix + "bal_amt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setOverdueFrom(JSPUtil.getParameter(request, prefix + "overdue_from", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setExRate(JSPUtil.getParameter(request, prefix + "ex_rate", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setOverDue(JSPUtil.getParameter(request, prefix + "over_due", ""));
		setDueDt(JSPUtil.getParameter(request, prefix + "due_dt", ""));
		setXcldOtsTpCd(JSPUtil.getParameter(request, prefix + "xcld_ots_tp_cd", ""));
		setOtsOpy(JSPUtil.getParameter(request, prefix + "ots_opy", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentRequestLetterCustVO[]
	 */
	public PaymentRequestLetterCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentRequestLetterCustVO[]
	 */
	public PaymentRequestLetterCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentRequestLetterCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totLcl = (JSPUtil.getParameter(request, prefix	+ "tot_lcl", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] overdueTo = (JSPUtil.getParameter(request, prefix	+ "overdue_to", length));
			String[] bnd = (JSPUtil.getParameter(request, prefix	+ "bnd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] balAmt = (JSPUtil.getParameter(request, prefix	+ "bal_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] overdueFrom = (JSPUtil.getParameter(request, prefix	+ "overdue_from", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] exRate = (JSPUtil.getParameter(request, prefix	+ "ex_rate", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] overDue = (JSPUtil.getParameter(request, prefix	+ "over_due", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] xcldOtsTpCd = (JSPUtil.getParameter(request, prefix	+ "xcld_ots_tp_cd", length));
			String[] otsOpy = (JSPUtil.getParameter(request, prefix	+ "ots_opy", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentRequestLetterCustVO();
				if (totLcl[i] != null)
					model.setTotLcl(totLcl[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (overdueTo[i] != null)
					model.setOverdueTo(overdueTo[i]);
				if (bnd[i] != null)
					model.setBnd(bnd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (balAmt[i] != null)
					model.setBalAmt(balAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (overdueFrom[i] != null)
					model.setOverdueFrom(overdueFrom[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (exRate[i] != null)
					model.setExRate(exRate[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (overDue[i] != null)
					model.setOverDue(overDue[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (xcldOtsTpCd[i] != null)
					model.setXcldOtsTpCd(xcldOtsTpCd[i]);
				if (otsOpy[i] != null)
					model.setOtsOpy(otsOpy[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentRequestLetterCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentRequestLetterCustVO[]
	 */
	public PaymentRequestLetterCustVO[] getPaymentRequestLetterCustVOs(){
		PaymentRequestLetterCustVO[] vos = (PaymentRequestLetterCustVO[])models.toArray(new PaymentRequestLetterCustVO[models.size()]);
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
		this.totLcl = this.totLcl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overdueTo = this.overdueTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnd = this.bnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balAmt = this.balAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overdueFrom = this.overdueFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRate = this.exRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDue = this.overDue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldOtsTpCd = this.xcldOtsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOpy = this.otsOpy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
