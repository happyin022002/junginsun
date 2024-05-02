/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PaymentRequestLetterSumVO.java
*@FileTitle : PaymentRequestLetterSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.26  
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

public class PaymentRequestLetterSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentRequestLetterSumVO> models = new ArrayList<PaymentRequestLetterSumVO>();
	
	/* Column Info */
	private String dpPrcsKnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sumCurrCd = null;
	/* Column Info */
	private String sumInBal = null;
	/* Column Info */
	private String sumTotLcl = null;
	/* Column Info */
	private String sumCount = null;
	/* Column Info */
	private String sumOverBal = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PaymentRequestLetterSumVO() {}

	public PaymentRequestLetterSumVO(String ibflag, String pagerows, String sumCurrCd, String sumInBal, String sumTotLcl, String sumCount, String sumOverBal, String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
		this.ibflag = ibflag;
		this.sumCurrCd = sumCurrCd;
		this.sumInBal = sumInBal;
		this.sumTotLcl = sumTotLcl;
		this.sumCount = sumCount;
		this.sumOverBal = sumOverBal;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sum_curr_cd", getSumCurrCd());
		this.hashColumns.put("sum_in_bal", getSumInBal());
		this.hashColumns.put("sum_tot_lcl", getSumTotLcl());
		this.hashColumns.put("sum_count", getSumCount());
		this.hashColumns.put("sum_over_bal", getSumOverBal());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sum_curr_cd", "sumCurrCd");
		this.hashFields.put("sum_in_bal", "sumInBal");
		this.hashFields.put("sum_tot_lcl", "sumTotLcl");
		this.hashFields.put("sum_count", "sumCount");
		this.hashFields.put("sum_over_bal", "sumOverBal");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
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
	 * @return sumCurrCd
	 */
	public String getSumCurrCd() {
		return this.sumCurrCd;
	}
	
	/**
	 * Column Info
	 * @return sumInBal
	 */
	public String getSumInBal() {
		return this.sumInBal;
	}
	
	/**
	 * Column Info
	 * @return sumTotLcl
	 */
	public String getSumTotLcl() {
		return this.sumTotLcl;
	}
	
	/**
	 * Column Info
	 * @return sumCount
	 */
	public String getSumCount() {
		return this.sumCount;
	}
	
	/**
	 * Column Info
	 * @return sumOverBal
	 */
	public String getSumOverBal() {
		return this.sumOverBal;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
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
	 * @param sumCurrCd
	 */
	public void setSumCurrCd(String sumCurrCd) {
		this.sumCurrCd = sumCurrCd;
	}
	
	/**
	 * Column Info
	 * @param sumInBal
	 */
	public void setSumInBal(String sumInBal) {
		this.sumInBal = sumInBal;
	}
	
	/**
	 * Column Info
	 * @param sumTotLcl
	 */
	public void setSumTotLcl(String sumTotLcl) {
		this.sumTotLcl = sumTotLcl;
	}
	
	/**
	 * Column Info
	 * @param sumCount
	 */
	public void setSumCount(String sumCount) {
		this.sumCount = sumCount;
	}
	
	/**
	 * Column Info
	 * @param sumOverBal
	 */
	public void setSumOverBal(String sumOverBal) {
		this.sumOverBal = sumOverBal;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setDpPrcsKnt(JSPUtil.getParameter(request, prefix + "dp_prcs_knt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSumCurrCd(JSPUtil.getParameter(request, prefix + "sum_curr_cd", ""));
		setSumInBal(JSPUtil.getParameter(request, prefix + "sum_in_bal", ""));
		setSumTotLcl(JSPUtil.getParameter(request, prefix + "sum_tot_lcl", ""));
		setSumCount(JSPUtil.getParameter(request, prefix + "sum_count", ""));
		setSumOverBal(JSPUtil.getParameter(request, prefix + "sum_over_bal", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentRequestLetterSumVO[]
	 */
	public PaymentRequestLetterSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentRequestLetterSumVO[]
	 */
	public PaymentRequestLetterSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentRequestLetterSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sumCurrCd = (JSPUtil.getParameter(request, prefix	+ "sum_curr_cd", length));
			String[] sumInBal = (JSPUtil.getParameter(request, prefix	+ "sum_in_bal", length));
			String[] sumTotLcl = (JSPUtil.getParameter(request, prefix	+ "sum_tot_lcl", length));
			String[] sumCount = (JSPUtil.getParameter(request, prefix	+ "sum_count", length));
			String[] sumOverBal = (JSPUtil.getParameter(request, prefix	+ "sum_over_bal", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentRequestLetterSumVO();
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sumCurrCd[i] != null)
					model.setSumCurrCd(sumCurrCd[i]);
				if (sumInBal[i] != null)
					model.setSumInBal(sumInBal[i]);
				if (sumTotLcl[i] != null)
					model.setSumTotLcl(sumTotLcl[i]);
				if (sumCount[i] != null)
					model.setSumCount(sumCount[i]);
				if (sumOverBal[i] != null)
					model.setSumOverBal(sumOverBal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentRequestLetterSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentRequestLetterSumVO[]
	 */
	public PaymentRequestLetterSumVO[] getPaymentRequestLetterSumVOs(){
		PaymentRequestLetterSumVO[] vos = (PaymentRequestLetterSumVO[])models.toArray(new PaymentRequestLetterSumVO[models.size()]);
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
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCurrCd = this.sumCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumInBal = this.sumInBal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTotLcl = this.sumTotLcl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCount = this.sumCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumOverBal = this.sumOverBal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
