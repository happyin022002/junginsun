/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchCharterListByPaymentSlipVO.java
*@FileTitle : SearchCharterListByPaymentSlipVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.19  
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

public class SearchCharterListByPaymentSlipVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCharterListByPaymentSlipVO> models = new ArrayList<SearchCharterListByPaymentSlipVO>();
	
	/* Column Info */
	private String vvdYn = null;
	/* Column Info */
	private String acctNm = null;
	/* Column Info */
	private String fletSrcTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String fletIssTpCd = null;
	/* Column Info */
	private String chtrPayRcvCd = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String vvdBunker = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String invDtlSeq = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String slpLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCharterListByPaymentSlipVO() {}

	public SearchCharterListByPaymentSlipVO(String ibflag, String pagerows, String acctNm, String acctCd, String currCd, String invAmt, String invDesc, String ctrCd, String slpLocCd, String fletIssTpCd, String invSeq, String invDtlSeq, String fletSrcTpCd, String vvdBunker, String vvdYn, String chtrPayRcvCd, String fletCtrtNo) {
		this.vvdYn = vvdYn;
		this.acctNm = acctNm;
		this.fletSrcTpCd = fletSrcTpCd;
		this.currCd = currCd;
		this.invSeq = invSeq;
		this.fletIssTpCd = fletIssTpCd;
		this.chtrPayRcvCd = chtrPayRcvCd;
		this.fletCtrtNo = fletCtrtNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.invDesc = invDesc;
		this.ctrCd = ctrCd;
		this.vvdBunker = vvdBunker;
		this.acctCd = acctCd;
		this.invDtlSeq = invDtlSeq;
		this.invAmt = invAmt;
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd_yn", getVvdYn());
		this.hashColumns.put("acct_nm", getAcctNm());
		this.hashColumns.put("flet_src_tp_cd", getFletSrcTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("flet_iss_tp_cd", getFletIssTpCd());
		this.hashColumns.put("chtr_pay_rcv_cd", getChtrPayRcvCd());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("vvd_bunker", getVvdBunker());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("inv_dtl_seq", getInvDtlSeq());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("slp_loc_cd", getSlpLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd_yn", "vvdYn");
		this.hashFields.put("acct_nm", "acctNm");
		this.hashFields.put("flet_src_tp_cd", "fletSrcTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("flet_iss_tp_cd", "fletIssTpCd");
		this.hashFields.put("chtr_pay_rcv_cd", "chtrPayRcvCd");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("vvd_bunker", "vvdBunker");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("inv_dtl_seq", "invDtlSeq");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("slp_loc_cd", "slpLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvdYn
	 */
	public String getVvdYn() {
		return this.vvdYn;
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
	 * @return fletSrcTpCd
	 */
	public String getFletSrcTpCd() {
		return this.fletSrcTpCd;
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
	 * @return fletIssTpCd
	 */
	public String getFletIssTpCd() {
		return this.fletIssTpCd;
	}
	
	/**
	 * Column Info
	 * @return chtrPayRcvCd
	 */
	public String getChtrPayRcvCd() {
		return this.chtrPayRcvCd;
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
	 * @return vvdBunker
	 */
	public String getVvdBunker() {
		return this.vvdBunker;
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
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
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
	 * @param vvdYn
	 */
	public void setVvdYn(String vvdYn) {
		this.vvdYn = vvdYn;
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
	 * @param fletSrcTpCd
	 */
	public void setFletSrcTpCd(String fletSrcTpCd) {
		this.fletSrcTpCd = fletSrcTpCd;
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
	 * @param fletIssTpCd
	 */
	public void setFletIssTpCd(String fletIssTpCd) {
		this.fletIssTpCd = fletIssTpCd;
	}
	
	/**
	 * Column Info
	 * @param chtrPayRcvCd
	 */
	public void setChtrPayRcvCd(String chtrPayRcvCd) {
		this.chtrPayRcvCd = chtrPayRcvCd;
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
	 * @param vvdBunker
	 */
	public void setVvdBunker(String vvdBunker) {
		this.vvdBunker = vvdBunker;
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
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
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
		setVvdYn(JSPUtil.getParameter(request, prefix + "vvd_yn", ""));
		setAcctNm(JSPUtil.getParameter(request, prefix + "acct_nm", ""));
		setFletSrcTpCd(JSPUtil.getParameter(request, prefix + "flet_src_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setFletIssTpCd(JSPUtil.getParameter(request, prefix + "flet_iss_tp_cd", ""));
		setChtrPayRcvCd(JSPUtil.getParameter(request, prefix + "chtr_pay_rcv_cd", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, prefix + "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setCtrCd(JSPUtil.getParameter(request, prefix + "ctr_cd", ""));
		setVvdBunker(JSPUtil.getParameter(request, prefix + "vvd_bunker", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setInvDtlSeq(JSPUtil.getParameter(request, prefix + "inv_dtl_seq", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setSlpLocCd(JSPUtil.getParameter(request, prefix + "slp_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCharterListByPaymentSlipVO[]
	 */
	public SearchCharterListByPaymentSlipVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCharterListByPaymentSlipVO[]
	 */
	public SearchCharterListByPaymentSlipVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCharterListByPaymentSlipVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvdYn = (JSPUtil.getParameter(request, prefix	+ "vvd_yn", length));
			String[] acctNm = (JSPUtil.getParameter(request, prefix	+ "acct_nm", length));
			String[] fletSrcTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_src_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] fletIssTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_iss_tp_cd", length));
			String[] chtrPayRcvCd = (JSPUtil.getParameter(request, prefix	+ "chtr_pay_rcv_cd", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] vvdBunker = (JSPUtil.getParameter(request, prefix	+ "vvd_bunker", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] invDtlSeq = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_seq", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCharterListByPaymentSlipVO();
				if (vvdYn[i] != null)
					model.setVvdYn(vvdYn[i]);
				if (acctNm[i] != null)
					model.setAcctNm(acctNm[i]);
				if (fletSrcTpCd[i] != null)
					model.setFletSrcTpCd(fletSrcTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (fletIssTpCd[i] != null)
					model.setFletIssTpCd(fletIssTpCd[i]);
				if (chtrPayRcvCd[i] != null)
					model.setChtrPayRcvCd(chtrPayRcvCd[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (vvdBunker[i] != null)
					model.setVvdBunker(vvdBunker[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (invDtlSeq[i] != null)
					model.setInvDtlSeq(invDtlSeq[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCharterListByPaymentSlipVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCharterListByPaymentSlipVO[]
	 */
	public SearchCharterListByPaymentSlipVO[] getSearchCharterListByPaymentSlipVOs(){
		SearchCharterListByPaymentSlipVO[] vos = (SearchCharterListByPaymentSlipVO[])models.toArray(new SearchCharterListByPaymentSlipVO[models.size()]);
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
		this.vvdYn = this.vvdYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctNm = this.acctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletSrcTpCd = this.fletSrcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletIssTpCd = this.fletIssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtrPayRcvCd = this.chtrPayRcvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdBunker = this.vvdBunker .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlSeq = this.invDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
