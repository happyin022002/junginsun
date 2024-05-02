/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchParamVO.java
*@FileTitle : SearchParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.04 장준우
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo;

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
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchParamVO> models = new ArrayList<SearchParamVO>();

	/* Column Info */
	private String fmChgAmt = null;
	/* Column Info */
	private String toCurrCd = null;
	/* Column Info */
	private String toCurrRt = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String fmCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String invIsuDt = null;
	/* Column Info */
	private String invDueDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String qtyYrmon = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rcvRntlSeq = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String srcIfSeq = null;
	/* Column Info */
	private String srcIfDt = null;
	/* Column Info */
	private String blInvIfFlg = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String loclTaxFlg = null;
	/* Column Info */
	private String toChgAmt = null;
	/* Column Info */
	private String taxAmount = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchParamVO() {}

	public SearchParamVO(String ibflag, String pagerows, String toChgAmt, String taxAmount, String custCntCd, String custSeq, String loclTaxFlg, String toCurrRt, String srcIfSeq, String srcIfDt, String invDueDt, String vndrSeq, String costYrmon, String qtyYrmon, String lstmCd, String ofcCd, String agmtSeq, String agmtCtyCd, String rcvRntlSeq, String fmCurrCd, String toCurrCd, String invIsuDt, String fmChgAmt, String creUsrId, String updUsrId, String invNo, String blInvIfFlg) {
		this.fmChgAmt = fmChgAmt;
		this.toCurrCd = toCurrCd;
		this.toCurrRt = toCurrRt;
		this.agmtSeq = agmtSeq;
		this.fmCurrCd = fmCurrCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.invIsuDt = invIsuDt;
		this.invDueDt = invDueDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.vndrSeq = vndrSeq;
		this.qtyYrmon = qtyYrmon;
		this.agmtCtyCd = agmtCtyCd;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.rcvRntlSeq = rcvRntlSeq;
		this.invNo = invNo;
		this.blInvIfFlg = blInvIfFlg;
		this.srcIfSeq = srcIfSeq;
		this.srcIfDt = srcIfDt;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.loclTaxFlg = loclTaxFlg;
		this.toChgAmt = toChgAmt;
		this.taxAmount = taxAmount;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_chg_amt", getFmChgAmt());
		this.hashColumns.put("to_curr_cd", getToCurrCd());
		this.hashColumns.put("to_curr_rt", getToCurrRt());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("fm_curr_cd", getFmCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("inv_isu_dt", getInvIsuDt());
		this.hashColumns.put("inv_due_dt", getInvDueDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("qty_yrmon", getQtyYrmon());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rcv_rntl_seq", getRcvRntlSeq());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("bl_inv_if_flg", getBlInvIfFlg());
		this.hashColumns.put("src_if_seq", getSrcIfSeq());
		this.hashColumns.put("src_if_dt", getSrcIfDt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("locl_tax_flg", getLoclTaxFlg());
		this.hashColumns.put("to_chg_amt", getToChgAmt());
		this.hashColumns.put("tax_amount", getTaxAmount());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_chg_amt", "fmChgAmt");
		this.hashFields.put("to_curr_cd", "toCurrCd");
		this.hashFields.put("to_curr_rt", "toCurrRt");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("fm_curr_cd", "fmCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("inv_isu_dt", "invIsuDt");
		this.hashFields.put("inv_due_dt", "invDueDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("qty_yrmon", "qtyYrmon");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rcv_rntl_seq", "rcvRntlSeq");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("bl_inv_if_flg", "blInvIfFlg");
		this.hashFields.put("src_if_seq", "srcIfSeq");
		this.hashFields.put("src_if_dt", "srcIfDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("locl_tax_flg", "loclTaxFlg");
		this.hashFields.put("to_chg_amt", "toChgAmt");
		this.hashFields.put("tax_amount", "taxAmount");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return fmChgAmt
	 */
	public String getFmChgAmt() {
		return this.fmChgAmt;
	}

	/**
	 * Column Info
	 * @return toCurrCd
	 */
	public String getToCurrCd() {
		return this.toCurrCd;
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
	 * @return fmCurrCd
	 */
	public String getFmCurrCd() {
		return this.fmCurrCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}

	/**
	 * Column Info
	 * @return invIsuDt
	 */
	public String getInvIsuDt() {
		return this.invIsuDt;
	}

	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
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
	 * @return qtyYrmon
	 */
	public String getQtyYrmon() {
		return this.qtyYrmon;
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
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}

	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * @return rcvRntlSeq
	 */
	public String getRcvRntlSeq() {
		return this.rcvRntlSeq;
	}


	/**
	 * Column Info
	 * @param fmChgAmt
	 */
	public void setFmChgAmt(String fmChgAmt) {
		this.fmChgAmt = fmChgAmt;
	}

	/**
	 * Column Info
	 * @param toCurrCd
	 */
	public void setToCurrCd(String toCurrCd) {
		this.toCurrCd = toCurrCd;
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
	 * @param fmCurrCd
	 */
	public void setFmCurrCd(String fmCurrCd) {
		this.fmCurrCd = fmCurrCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * Column Info
	 * @param invIsuDt
	 */
	public void setInvIsuDt(String invIsuDt) {
		this.invIsuDt = invIsuDt;
	}

	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
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
	 * @param qtyYrmon
	 */
	public void setQtyYrmon(String qtyYrmon) {
		this.qtyYrmon = qtyYrmon;
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
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * @param rcvRntlSeq
	 */
	public void setRcvRntlSeq(String rcvRntlSeq) {
		this.rcvRntlSeq = rcvRntlSeq;
	}

	/**
	 * @return the invNo
	 */
	public String getInvNo() {
		return invNo;
	}

	/**
	 * @param invNo the invNo to set
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	/**
	 * @return the blInvIfFlg
	 */
	public String getBlInvIfFlg() {
		return blInvIfFlg;
	}

	/**
	 * @param blInvIfFlg the blInvIfFlg to set
	 */
	public void setBlInvIfFlg(String blInvIfFlg) {
		this.blInvIfFlg = blInvIfFlg;
	}

	/**
	 * @return the invDueDt
	 */
	public String getInvDueDt() {
		return invDueDt;
	}

	/**
	 * @param invDueDt the invDueDt to set
	 */
	public void setInvDueDt(String invDueDt) {
		this.invDueDt = invDueDt;
	}

	/**
	 * @return the srcIfSeq
	 */
	public String getSrcIfSeq() {
		return srcIfSeq;
	}

	/**
	 * @param srcIfSeq the srcIfSeq to set
	 */
	public void setSrcIfSeq(String srcIfSeq) {
		this.srcIfSeq = srcIfSeq;
	}

	/**
	 * @return the srcIfDt
	 */
	public String getSrcIfDt() {
		return srcIfDt;
	}

	/**
	 * @param srcIfDt the srcIfDt to set
	 */
	public void setSrcIfDt(String srcIfDt) {
		this.srcIfDt = srcIfDt;
	}

	/**
	 * @return the toCurrRt
	 */
	public String getToCurrRt() {
		return toCurrRt;
	}

	/**
	 * @param toCurrRt the toCurrRt to set
	 */
	public void setToCurrRt(String toCurrRt) {
		this.toCurrRt = toCurrRt;
	}

	/**
	 * @return the custCntCd
	 */
	public String getCustCntCd() {
		return custCntCd;
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * @return the custSeq
	 */
	public String getCustSeq() {
		return custSeq;
	}

	/**
	 * @param custSeq the custSeq to set
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * @return the loclTaxFlg
	 */
	public String getLoclTaxFlg() {
		return loclTaxFlg;
	}

	/**
	 * @param loclTaxFlg the loclTaxFlg to set
	 */
	public void setLoclTaxFlg(String loclTaxFlg) {
		this.loclTaxFlg = loclTaxFlg;
	}

	/**
	 * @return the toChgAmt
	 */
	public String getToChgAmt() {
		return toChgAmt;
	}

	/**
	 * @param toChgAmt the toChgAmt to set
	 */
	public void setToChgAmt(String toChgAmt) {
		this.toChgAmt = toChgAmt;
	}

	/**
	 * @return the taxAmount
	 */
	public String getTaxAmount() {
		return taxAmount;
	}

	/**
	 * @param taxAmount the taxAmount to set
	 */
	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmChgAmt(JSPUtil.getParameter(request, "fm_chg_amt", "").replaceAll(",", ""));
		setToCurrCd(JSPUtil.getParameter(request, "to_curr_cd", ""));
		setToCurrRt(JSPUtil.getParameter(request, "to_curr_rt", "").replaceAll(",", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setFmCurrCd(JSPUtil.getParameter(request, "fm_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setInvIsuDt(JSPUtil.getParameter(request, "inv_isu_dt", "").replaceAll("-", ""));
		setInvDueDt(JSPUtil.getParameter(request, "inv_due_dt", "").replaceAll("-", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", "").replaceAll("-", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setQtyYrmon(JSPUtil.getParameter(request, "qty_yrmon", "").replaceAll("-", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRcvRntlSeq(JSPUtil.getParameter(request, "rcv_rntl_seq", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setBlInvIfFlg(JSPUtil.getParameter(request, "bl_inv_if_flg", ""));
		setSrcIfSeq(JSPUtil.getParameter(request, "src_if_seq", ""));
		setSrcIfDt(JSPUtil.getParameter(request, "src_if_dt", "").replaceAll("-", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setLoclTaxFlg(JSPUtil.getParameter(request, "locl_tax_flg", ""));
		setToChgAmt(JSPUtil.getParameter(request, "to_chg_amt", "").replaceAll(",", ""));
		setTaxAmount(JSPUtil.getParameter(request, "tax_amount", "").replaceAll(",", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchParamVO[]
	 */
	public SearchParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchParamVO[]
	 */
	public SearchParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchParamVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] fmChgAmt = (JSPUtil.getParameter(request, prefix	+ "fm_chg_amt", length));
			String[] toCurrCd = (JSPUtil.getParameter(request, prefix	+ "to_curr_cd", length));
			String[] toCurrRt = (JSPUtil.getParameter(request, prefix	+ "to_curr_rt", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] fmCurrCd = (JSPUtil.getParameter(request, prefix	+ "fm_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] invIsuDt = (JSPUtil.getParameter(request, prefix	+ "inv_isu_dt", length));
			String[] invDueDt = (JSPUtil.getParameter(request, prefix	+ "inv_due_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] qtyYrmon = (JSPUtil.getParameter(request, prefix	+ "qty_yrmon", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rcvRntlSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_rntl_seq", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] blInvIfFlg = (JSPUtil.getParameter(request, prefix	+ "bl_inv_if_flg", length));
			String[] srcIfSeq = (JSPUtil.getParameter(request, prefix	+ "src_if_seq", length));
			String[] srcIfDt = (JSPUtil.getParameter(request, prefix	+ "src_if_dt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] loclTaxFlg = (JSPUtil.getParameter(request, prefix	+ "locl_tax_flg", length));
			String[] toChgAmt = (JSPUtil.getParameter(request, prefix	+ "to_chg_amt", length));
			String[] taxAmount = (JSPUtil.getParameter(request, prefix	+ "tax_amount", length));

			for (int i = 0; i < length; i++) {
				model = new SearchParamVO();
				if (fmChgAmt[i] != null)
					model.setFmChgAmt(fmChgAmt[i]);
				if (toCurrCd[i] != null)
					model.setToCurrCd(toCurrCd[i]);
				if (toCurrRt[i] != null)
					model.setToCurrRt(toCurrRt[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (fmCurrCd[i] != null)
					model.setFmCurrCd(fmCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (invIsuDt[i] != null)
					model.setInvIsuDt(invIsuDt[i]);
				if (invDueDt[i] != null)
					model.setInvDueDt(invDueDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (qtyYrmon[i] != null)
					model.setQtyYrmon(qtyYrmon[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rcvRntlSeq[i] != null)
					model.setRcvRntlSeq(rcvRntlSeq[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (blInvIfFlg[i] != null)
					model.setBlInvIfFlg(blInvIfFlg[i]);
				if (srcIfSeq[i] != null)
					model.setSrcIfSeq(srcIfSeq[i]);
				if (srcIfDt[i] != null)
					model.setSrcIfDt(srcIfDt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (loclTaxFlg[i] != null)
					model.setLoclTaxFlg(loclTaxFlg[i]);
				if (toChgAmt[i] != null)
					model.setToChgAmt(toChgAmt[i]);
				if (taxAmount[i] != null)
					model.setTaxAmount(taxAmount[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchParamVO[]
	 */
	public SearchParamVO[] getSearchParamVOs(){
		SearchParamVO[] vos = (SearchParamVO[])models.toArray(new SearchParamVO[models.size()]);
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
		this.fmChgAmt = this.fmChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCurrCd = this.toCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCurrRt = this.toCurrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCurrCd = this.fmCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIsuDt = this.invIsuDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDueDt = this.invDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyYrmon = this.qtyYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvRntlSeq = this.rcvRntlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvIfFlg = this.blInvIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcIfSeq = this.srcIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcIfDt = this.srcIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTaxFlg = this.loclTaxFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toChgAmt = this.toChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmount = this.taxAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
