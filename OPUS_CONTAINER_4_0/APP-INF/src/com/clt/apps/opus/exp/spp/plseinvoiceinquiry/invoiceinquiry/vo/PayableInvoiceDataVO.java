/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableInvoiceDataVO.java
*@FileTitle : PayableInvoiceDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 손흥식
*@LastVersion : 1.0
* 2009.09.15 손흥식 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.vo;

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
 * @author 손흥식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PayableInvoiceDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PayableInvoiceDataVO> models = new ArrayList<PayableInvoiceDataVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String endDt = null;
	/* Column Info */
	private String lseInvApstsCd = null;
	/* Column Info */
	private String strDt = null;
	/* Column Info */
	private String apPayDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String payRntlCostAmt = null;
	/* Column Info */
	private String ttlCostAmt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String vndrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String lstmCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PayableInvoiceDataVO() {}

	public PayableInvoiceDataVO(String ibflag, String pagerows, String payRntlCostAmt, String ttlCostAmt, String invNo, String currCd, String endDt, String lseInvApstsCd, String vndrSeq, String strDt, String lstmCd, String apPayDt, String vndrNm) {
		this.currCd = currCd;
		this.endDt = endDt;
		this.lseInvApstsCd = lseInvApstsCd;
		this.strDt = strDt;
		this.apPayDt = apPayDt;
		this.pagerows = pagerows;
		this.payRntlCostAmt = payRntlCostAmt;
		this.ttlCostAmt = ttlCostAmt;
		this.invNo = invNo;
		this.vndrNm = vndrNm;
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.lstmCd = lstmCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("end_dt", getEndDt());
		this.hashColumns.put("lse_inv_apsts_cd", getLseInvApstsCd());
		this.hashColumns.put("str_dt", getStrDt());
		this.hashColumns.put("ap_pay_dt", getApPayDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pay_rntl_cost_amt", getPayRntlCostAmt());
		this.hashColumns.put("ttl_cost_amt", getTtlCostAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("lstm_cd", getLstmCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("end_dt", "endDt");
		this.hashFields.put("lse_inv_apsts_cd", "lseInvApstsCd");
		this.hashFields.put("str_dt", "strDt");
		this.hashFields.put("ap_pay_dt", "apPayDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pay_rntl_cost_amt", "payRntlCostAmt");
		this.hashFields.put("ttl_cost_amt", "ttlCostAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("lstm_cd", "lstmCd");
		return this.hashFields;
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
	 * @return endDt
	 */
	public String getEndDt() {
		return this.endDt;
	}
	
	/**
	 * Column Info
	 * @return lseInvApstsCd
	 */
	public String getLseInvApstsCd() {
		return this.lseInvApstsCd;
	}
	
	/**
	 * Column Info
	 * @return strDt
	 */
	public String getStrDt() {
		return this.strDt;
	}
	
	/**
	 * Column Info
	 * @return apPayDt
	 */
	public String getApPayDt() {
		return this.apPayDt;
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
	 * @return payRntlCostAmt
	 */
	public String getPayRntlCostAmt() {
		return this.payRntlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlCostAmt
	 */
	public String getTtlCostAmt() {
		return this.ttlCostAmt;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	
	/**
	 * Column Info
	 * @param lseInvApstsCd
	 */
	public void setLseInvApstsCd(String lseInvApstsCd) {
		this.lseInvApstsCd = lseInvApstsCd;
	}
	
	/**
	 * Column Info
	 * @param strDt
	 */
	public void setStrDt(String strDt) {
		this.strDt = strDt;
	}
	
	/**
	 * Column Info
	 * @param apPayDt
	 */
	public void setApPayDt(String apPayDt) {
		this.apPayDt = apPayDt;
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
	 * @param payRntlCostAmt
	 */
	public void setPayRntlCostAmt(String payRntlCostAmt) {
		this.payRntlCostAmt = payRntlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlCostAmt
	 */
	public void setTtlCostAmt(String ttlCostAmt) {
		this.ttlCostAmt = ttlCostAmt;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setEndDt(JSPUtil.getParameter(request, "end_dt", ""));
		setLseInvApstsCd(JSPUtil.getParameter(request, "lse_inv_apsts_cd", ""));
		setStrDt(JSPUtil.getParameter(request, "str_dt", ""));
		setApPayDt(JSPUtil.getParameter(request, "ap_pay_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPayRntlCostAmt(JSPUtil.getParameter(request, "pay_rntl_cost_amt", ""));
		setTtlCostAmt(JSPUtil.getParameter(request, "ttl_cost_amt", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setVndrNm(JSPUtil.getParameter(request, "vndr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PayableInvoiceDataVO[]
	 */
	public PayableInvoiceDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PayableInvoiceDataVO[]
	 */
	public PayableInvoiceDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PayableInvoiceDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] endDt = (JSPUtil.getParameter(request, prefix	+ "end_dt", length));
			String[] lseInvApstsCd = (JSPUtil.getParameter(request, prefix	+ "lse_inv_apsts_cd", length));
			String[] strDt = (JSPUtil.getParameter(request, prefix	+ "str_dt", length));
			String[] apPayDt = (JSPUtil.getParameter(request, prefix	+ "ap_pay_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] payRntlCostAmt = (JSPUtil.getParameter(request, prefix	+ "pay_rntl_cost_amt", length));
			String[] ttlCostAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_cost_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PayableInvoiceDataVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (endDt[i] != null)
					model.setEndDt(endDt[i]);
				if (lseInvApstsCd[i] != null)
					model.setLseInvApstsCd(lseInvApstsCd[i]);
				if (strDt[i] != null)
					model.setStrDt(strDt[i]);
				if (apPayDt[i] != null)
					model.setApPayDt(apPayDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (payRntlCostAmt[i] != null)
					model.setPayRntlCostAmt(payRntlCostAmt[i]);
				if (ttlCostAmt[i] != null)
					model.setTtlCostAmt(ttlCostAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPayableInvoiceDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PayableInvoiceDataVO[]
	 */
	public PayableInvoiceDataVO[] getPayableInvoiceDataVOs(){
		PayableInvoiceDataVO[] vos = (PayableInvoiceDataVO[])models.toArray(new PayableInvoiceDataVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDt = this.endDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseInvApstsCd = this.lseInvApstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strDt = this.strDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayDt = this.apPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payRntlCostAmt = this.payRntlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCostAmt = this.ttlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
