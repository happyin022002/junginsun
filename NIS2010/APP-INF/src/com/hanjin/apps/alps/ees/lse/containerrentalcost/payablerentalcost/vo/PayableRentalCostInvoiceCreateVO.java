/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostInvoiceCreateVO.java
*@FileTitle : PayableRentalCostInvoiceCreateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.10.07 노정용 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo;

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
 * @author 노정용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PayableRentalCostInvoiceCreateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PayableRentalCostInvoiceCreateVO> models = new ArrayList<PayableRentalCostInvoiceCreateVO>();
	
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String lsePayChgTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ttlCostAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lseCtrtNo = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String costNm = null;
	/* Column Info */
	private String opSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PayableRentalCostInvoiceCreateVO() {}

	public PayableRentalCostInvoiceCreateVO(String ibflag, String pagerows, String chgSeq, String agmtCtyCd, String agmtSeq, String lstmCd, String lseCtrtNo, 
			                                String lsePayChgTpCd, String cntrTpszCd, String ttlCostAmt, String crAmt, String acctCd, String costCd, String agmtNo,
			                                String invNo, String vvd, String costNm, String opSeq) {
		this.agmtSeq = agmtSeq;
		this.chgSeq = chgSeq;
		this.lsePayChgTpCd = lsePayChgTpCd;
		this.pagerows = pagerows;
		this.ttlCostAmt = ttlCostAmt;
		this.ibflag = ibflag;
		this.lseCtrtNo = lseCtrtNo;
		this.crAmt = crAmt;
		this.costCd = costCd;
		this.agmtCtyCd = agmtCtyCd;
		this.cntrTpszCd = cntrTpszCd;
		this.acctCd = acctCd;
		this.lstmCd = lstmCd;
		this.agmtNo = agmtNo;
		this.invNo = invNo;
		this.vvd = vvd;
		this.costNm = costNm;
		this.opSeq = opSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("lse_pay_chg_tp_cd", getLsePayChgTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ttl_cost_amt", getTtlCostAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lse_ctrt_no", getLseCtrtNo());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cost_nm", getCostNm());
		this.hashColumns.put("op_seq", getOpSeq());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("lse_pay_chg_tp_cd", "lsePayChgTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_cost_amt", "ttlCostAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lse_ctrt_no", "lseCtrtNo");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cost_nm", "costNm");
		this.hashFields.put("op_seq", "opSeq");

		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return lsePayChgTpCd
	 */
	public String getLsePayChgTpCd() {
		return this.lsePayChgTpCd;
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
	 * @return ttlCostAmt
	 */
	public String getTtlCostAmt() {
		return this.ttlCostAmt;
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
	 * @return lseCtrtNo
	 */
	public String getLseCtrtNo() {
		return this.lseCtrtNo;
	}
	
	/**
	 * Column Info
	 * @return crAmt
	 */
	public String getCrAmt() {
		return this.crAmt;
	}
	
	/**
	 * Column Info
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
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
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param lsePayChgTpCd
	 */
	public void setLsePayChgTpCd(String lsePayChgTpCd) {
		this.lsePayChgTpCd = lsePayChgTpCd;
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
	 * @param ttlCostAmt
	 */
	public void setTtlCostAmt(String ttlCostAmt) {
		this.ttlCostAmt = ttlCostAmt;
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
	 * @param lseCtrtNo
	 */
	public void setLseCtrtNo(String lseCtrtNo) {
		this.lseCtrtNo = lseCtrtNo;
	}
	
	/**
	 * Column Info
	 * @param crAmt
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}
	
	/**
	 * Column Info
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}


	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	public String getAgmtNo() {
		return agmtNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public String getInvNo() {
		return invNo;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getVvd() {
		return vvd;
	}

	public void setCostNm(String costNm) {
		this.costNm = costNm;
	}

	public String getCostNm() {
		return costNm;
	}

	public void setOpSeq(String opSeq) {
		this.opSeq = opSeq;
	}

	public String getOpSeq() {
		return opSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setLsePayChgTpCd(JSPUtil.getParameter(request, "lse_pay_chg_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTtlCostAmt(JSPUtil.getParameter(request, "ttl_cost_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLseCtrtNo(JSPUtil.getParameter(request, "lse_ctrt_no", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setCostNm(JSPUtil.getParameter(request, "cost_nm", ""));
		setOpSeq(JSPUtil.getParameter(request, "op_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PayableRentalCostInvoiceCreateVO[]
	 */
	public PayableRentalCostInvoiceCreateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PayableRentalCostInvoiceCreateVO[]
	 */
	public PayableRentalCostInvoiceCreateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PayableRentalCostInvoiceCreateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] lsePayChgTpCd = (JSPUtil.getParameter(request, prefix	+ "lse_pay_chg_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ttlCostAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_cost_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lseCtrtNo = (JSPUtil.getParameter(request, prefix	+ "lse_ctrt_no", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] costNm = (JSPUtil.getParameter(request, prefix	+ "cost_nm", length));
			String[] opSeq = (JSPUtil.getParameter(request, prefix	+ "op_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new PayableRentalCostInvoiceCreateVO();
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (lsePayChgTpCd[i] != null)
					model.setLsePayChgTpCd(lsePayChgTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ttlCostAmt[i] != null)
					model.setTtlCostAmt(ttlCostAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lseCtrtNo[i] != null)
					model.setLseCtrtNo(lseCtrtNo[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (costNm[i] != null)
					model.setCostNm(costNm[i]);
				if (opSeq[i] != null)
					model.setOpSeq(opSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPayableRentalCostInvoiceCreateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PayableRentalCostInvoiceCreateVO[]
	 */
	public PayableRentalCostInvoiceCreateVO[] getPayableRentalCostInvoiceCreateVOs(){
		PayableRentalCostInvoiceCreateVO[] vos = (PayableRentalCostInvoiceCreateVO[])models.toArray(new PayableRentalCostInvoiceCreateVO[models.size()]);
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
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsePayChgTpCd = this.lsePayChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCostAmt = this.ttlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseCtrtNo = this.lseCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costNm = this.costNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opSeq = this.opSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}