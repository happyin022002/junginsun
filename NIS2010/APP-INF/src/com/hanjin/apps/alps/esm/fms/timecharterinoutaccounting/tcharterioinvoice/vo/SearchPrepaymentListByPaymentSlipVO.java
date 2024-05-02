/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchPrepaymentListByPaymentSlipVO.java
*@FileTitle : SearchPrepaymentListByPaymentSlipVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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

public class SearchPrepaymentListByPaymentSlipVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPrepaymentListByPaymentSlipVO> models = new ArrayList<SearchPrepaymentListByPaymentSlipVO>();
	
	/* Column Info */
	private String fletSrcTpCd = null;
	/* Column Info */
	private String acctNm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String ppayHirNo = null;
	/* Column Info */
	private String fletIssTpCd = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String invDtlSeq = null;
	/* Column Info */
	private String imsPpayHirNo = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String slpLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPrepaymentListByPaymentSlipVO() {}

	public SearchPrepaymentListByPaymentSlipVO(String ibflag, String pagerows, String imsPpayHirNo, String ppayHirNo, String acctNm, String acctCd, String effDt, String expDt, String currCd, String invAmt, String invDesc, String ctrCd, String slpLocCd, String fletIssTpCd, String invSeq, String invDtlSeq, String fletSrcTpCd, String fletCtrtNo) {
		this.fletSrcTpCd = fletSrcTpCd;
		this.acctNm = acctNm;
		this.currCd = currCd;
		this.invSeq = invSeq;
		this.ppayHirNo = ppayHirNo;
		this.fletIssTpCd = fletIssTpCd;
		this.fletCtrtNo = fletCtrtNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.invDesc = invDesc;
		this.ctrCd = ctrCd;
		this.acctCd = acctCd;
		this.invDtlSeq = invDtlSeq;
		this.imsPpayHirNo = imsPpayHirNo;
		this.invAmt = invAmt;
		this.expDt = expDt;
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("flet_src_tp_cd", getFletSrcTpCd());
		this.hashColumns.put("acct_nm", getAcctNm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("ppay_hir_no", getPpayHirNo());
		this.hashColumns.put("flet_iss_tp_cd", getFletIssTpCd());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("inv_dtl_seq", getInvDtlSeq());
		this.hashColumns.put("ims_ppay_hir_no", getImsPpayHirNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("slp_loc_cd", getSlpLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("flet_src_tp_cd", "fletSrcTpCd");
		this.hashFields.put("acct_nm", "acctNm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("ppay_hir_no", "ppayHirNo");
		this.hashFields.put("flet_iss_tp_cd", "fletIssTpCd");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("inv_dtl_seq", "invDtlSeq");
		this.hashFields.put("ims_ppay_hir_no", "imsPpayHirNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("slp_loc_cd", "slpLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fletSrcTpCd
	 */
	public String getFletSrcTpCd() {
		return this.fletSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @return acctNm
	 */
	public String getAcctNm() {
		return this.acctNm;
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
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return ppayHirNo
	 */
	public String getPpayHirNo() {
		return this.ppayHirNo;
	}
	
	/**
	 * Column Info
	 * @return fletIssTpCd
	 */
	public String getFletIssTpCd() {
		return this.fletIssTpCd;
	}
	
	/**
	 * Column Info
	 * @return fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return invDesc
	 */
	public String getInvDesc() {
		return this.invDesc;
	}
	
	/**
	 * Column Info
	 * @return ctrCd
	 */
	public String getCtrCd() {
		return this.ctrCd;
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
	 * @return invDtlSeq
	 */
	public String getInvDtlSeq() {
		return this.invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return imsPpayHirNo
	 */
	public String getImsPpayHirNo() {
		return this.imsPpayHirNo;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return slpLocCd
	 */
	public String getSlpLocCd() {
		return this.slpLocCd;
	}
	

	/**
	 * Column Info
	 * @param fletSrcTpCd
	 */
	public void setFletSrcTpCd(String fletSrcTpCd) {
		this.fletSrcTpCd = fletSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @param acctNm
	 */
	public void setAcctNm(String acctNm) {
		this.acctNm = acctNm;
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
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param ppayHirNo
	 */
	public void setPpayHirNo(String ppayHirNo) {
		this.ppayHirNo = ppayHirNo;
	}
	
	/**
	 * Column Info
	 * @param fletIssTpCd
	 */
	public void setFletIssTpCd(String fletIssTpCd) {
		this.fletIssTpCd = fletIssTpCd;
	}
	
	/**
	 * Column Info
	 * @param fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param invDesc
	 */
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
	}
	
	/**
	 * Column Info
	 * @param ctrCd
	 */
	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
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
	 * @param invDtlSeq
	 */
	public void setInvDtlSeq(String invDtlSeq) {
		this.invDtlSeq = invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param imsPpayHirNo
	 */
	public void setImsPpayHirNo(String imsPpayHirNo) {
		this.imsPpayHirNo = imsPpayHirNo;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param slpLocCd
	 */
	public void setSlpLocCd(String slpLocCd) {
		this.slpLocCd = slpLocCd;
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
		setFletSrcTpCd(JSPUtil.getParameter(request, prefix + "flet_src_tp_cd", ""));
		setAcctNm(JSPUtil.getParameter(request, prefix + "acct_nm", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setPpayHirNo(JSPUtil.getParameter(request, prefix + "ppay_hir_no", ""));
		setFletIssTpCd(JSPUtil.getParameter(request, prefix + "flet_iss_tp_cd", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, prefix + "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setCtrCd(JSPUtil.getParameter(request, prefix + "ctr_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setInvDtlSeq(JSPUtil.getParameter(request, prefix + "inv_dtl_seq", ""));
		setImsPpayHirNo(JSPUtil.getParameter(request, prefix + "ims_ppay_hir_no", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setSlpLocCd(JSPUtil.getParameter(request, prefix + "slp_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPrepaymentListByPaymentSlipVO[]
	 */
	public SearchPrepaymentListByPaymentSlipVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPrepaymentListByPaymentSlipVO[]
	 */
	public SearchPrepaymentListByPaymentSlipVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPrepaymentListByPaymentSlipVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fletSrcTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_src_tp_cd", length));
			String[] acctNm = (JSPUtil.getParameter(request, prefix	+ "acct_nm", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] ppayHirNo = (JSPUtil.getParameter(request, prefix	+ "ppay_hir_no", length));
			String[] fletIssTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_iss_tp_cd", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] invDtlSeq = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_seq", length));
			String[] imsPpayHirNo = (JSPUtil.getParameter(request, prefix	+ "ims_ppay_hir_no", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPrepaymentListByPaymentSlipVO();
				if (fletSrcTpCd[i] != null)
					model.setFletSrcTpCd(fletSrcTpCd[i]);
				if (acctNm[i] != null)
					model.setAcctNm(acctNm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (ppayHirNo[i] != null)
					model.setPpayHirNo(ppayHirNo[i]);
				if (fletIssTpCd[i] != null)
					model.setFletIssTpCd(fletIssTpCd[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (invDtlSeq[i] != null)
					model.setInvDtlSeq(invDtlSeq[i]);
				if (imsPpayHirNo[i] != null)
					model.setImsPpayHirNo(imsPpayHirNo[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPrepaymentListByPaymentSlipVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPrepaymentListByPaymentSlipVO[]
	 */
	public SearchPrepaymentListByPaymentSlipVO[] getSearchPrepaymentListByPaymentSlipVOs(){
		SearchPrepaymentListByPaymentSlipVO[] vos = (SearchPrepaymentListByPaymentSlipVO[])models.toArray(new SearchPrepaymentListByPaymentSlipVO[models.size()]);
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
		this.fletSrcTpCd = this.fletSrcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctNm = this.acctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayHirNo = this.ppayHirNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletIssTpCd = this.fletIssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlSeq = this.invDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imsPpayHirNo = this.imsPpayHirNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
