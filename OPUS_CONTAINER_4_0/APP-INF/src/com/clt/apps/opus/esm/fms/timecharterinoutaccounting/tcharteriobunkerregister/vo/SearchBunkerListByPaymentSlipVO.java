/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBunkerListByPaymentSlipVO.java
*@FileTitle : SearchBunkerListByPaymentSlipVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.13  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class SearchBunkerListByPaymentSlipVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBunkerListByPaymentSlipVO> models = new ArrayList<SearchBunkerListByPaymentSlipVO>();
	
	/* Column Info */
	private String vvdYn = null;
	/* Column Info */
	private String fletSrcTpCd = null;
	/* Column Info */
	private String acctNm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String fletMeasUtCd = null;
	/* Column Info */
	private String bnkPrcAmt = null;
	/* Column Info */
	private String bnkSeq = null;
	/* Column Info */
	private String bnkTpCd = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String bnkAmt = null;
	/* Column Info */
	private String vvdBunker = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String bnkDesc = null;
	/* Column Info */
	private String bnkQty = null;
	/* Column Info */
	private String toInvNo = null;
	/* Column Info */
	private String slpLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBunkerListByPaymentSlipVO() {}

	public SearchBunkerListByPaymentSlipVO(String ibflag, String pagerows, String bnkTpCd, String acctNm, String acctCd, String vvdBunker, String fletMeasUtCd, String bnkQty, String bnkPrcAmt, String currCd, String bnkAmt, String bnkDesc, String ctrCd, String slpLocCd, String fletSrcTpCd, String fletCtrtNo, String bnkSeq, String vvdYn, String toInvNo) {
		this.vvdYn = vvdYn;
		this.fletSrcTpCd = fletSrcTpCd;
		this.acctNm = acctNm;
		this.currCd = currCd;
		this.fletMeasUtCd = fletMeasUtCd;
		this.bnkPrcAmt = bnkPrcAmt;
		this.bnkSeq = bnkSeq;
		this.bnkTpCd = bnkTpCd;
		this.fletCtrtNo = fletCtrtNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ctrCd = ctrCd;
		this.bnkAmt = bnkAmt;
		this.vvdBunker = vvdBunker;
		this.acctCd = acctCd;
		this.bnkDesc = bnkDesc;
		this.bnkQty = bnkQty;
		this.toInvNo = toInvNo;
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd_yn", getVvdYn());
		this.hashColumns.put("flet_src_tp_cd", getFletSrcTpCd());
		this.hashColumns.put("acct_nm", getAcctNm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("flet_meas_ut_cd", getFletMeasUtCd());
		this.hashColumns.put("bnk_prc_amt", getBnkPrcAmt());
		this.hashColumns.put("bnk_seq", getBnkSeq());
		this.hashColumns.put("bnk_tp_cd", getBnkTpCd());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("bnk_amt", getBnkAmt());
		this.hashColumns.put("vvd_bunker", getVvdBunker());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("bnk_desc", getBnkDesc());
		this.hashColumns.put("bnk_qty", getBnkQty());
		this.hashColumns.put("to_inv_no", getToInvNo());
		this.hashColumns.put("slp_loc_cd", getSlpLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd_yn", "vvdYn");
		this.hashFields.put("flet_src_tp_cd", "fletSrcTpCd");
		this.hashFields.put("acct_nm", "acctNm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("flet_meas_ut_cd", "fletMeasUtCd");
		this.hashFields.put("bnk_prc_amt", "bnkPrcAmt");
		this.hashFields.put("bnk_seq", "bnkSeq");
		this.hashFields.put("bnk_tp_cd", "bnkTpCd");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("bnk_amt", "bnkAmt");
		this.hashFields.put("vvd_bunker", "vvdBunker");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("bnk_desc", "bnkDesc");
		this.hashFields.put("bnk_qty", "bnkQty");
		this.hashFields.put("to_inv_no", "toInvNo");
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
	 * @return fletMeasUtCd
	 */
	public String getFletMeasUtCd() {
		return this.fletMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return bnkPrcAmt
	 */
	public String getBnkPrcAmt() {
		return this.bnkPrcAmt;
	}
	
	/**
	 * Column Info
	 * @return bnkSeq
	 */
	public String getBnkSeq() {
		return this.bnkSeq;
	}
	
	/**
	 * Column Info
	 * @return bnkTpCd
	 */
	public String getBnkTpCd() {
		return this.bnkTpCd;
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
	 * @return ctrCd
	 */
	public String getCtrCd() {
		return this.ctrCd;
	}
	
	/**
	 * Column Info
	 * @return bnkAmt
	 */
	public String getBnkAmt() {
		return this.bnkAmt;
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
	 * @return bnkDesc
	 */
	public String getBnkDesc() {
		return this.bnkDesc;
	}
	
	/**
	 * Column Info
	 * @return bnkQty
	 */
	public String getBnkQty() {
		return this.bnkQty;
	}
	
	/**
	 * Column Info
	 * @return toInvNo
	 */
	public String getToInvNo() {
		return this.toInvNo;
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
	 * @param fletMeasUtCd
	 */
	public void setFletMeasUtCd(String fletMeasUtCd) {
		this.fletMeasUtCd = fletMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param bnkPrcAmt
	 */
	public void setBnkPrcAmt(String bnkPrcAmt) {
		this.bnkPrcAmt = bnkPrcAmt;
	}
	
	/**
	 * Column Info
	 * @param bnkSeq
	 */
	public void setBnkSeq(String bnkSeq) {
		this.bnkSeq = bnkSeq;
	}
	
	/**
	 * Column Info
	 * @param bnkTpCd
	 */
	public void setBnkTpCd(String bnkTpCd) {
		this.bnkTpCd = bnkTpCd;
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
	 * @param ctrCd
	 */
	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
	}
	
	/**
	 * Column Info
	 * @param bnkAmt
	 */
	public void setBnkAmt(String bnkAmt) {
		this.bnkAmt = bnkAmt;
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
	 * @param bnkDesc
	 */
	public void setBnkDesc(String bnkDesc) {
		this.bnkDesc = bnkDesc;
	}
	
	/**
	 * Column Info
	 * @param bnkQty
	 */
	public void setBnkQty(String bnkQty) {
		this.bnkQty = bnkQty;
	}
	
	/**
	 * Column Info
	 * @param toInvNo
	 */
	public void setToInvNo(String toInvNo) {
		this.toInvNo = toInvNo;
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
		setVvdYn(JSPUtil.getParameter(request, "vvd_yn", ""));
		setFletSrcTpCd(JSPUtil.getParameter(request, "flet_src_tp_cd", ""));
		setAcctNm(JSPUtil.getParameter(request, "acct_nm", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setFletMeasUtCd(JSPUtil.getParameter(request, "flet_meas_ut_cd", ""));
		setBnkPrcAmt(JSPUtil.getParameter(request, "bnk_prc_amt", ""));
		setBnkSeq(JSPUtil.getParameter(request, "bnk_seq", ""));
		setBnkTpCd(JSPUtil.getParameter(request, "bnk_tp_cd", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrCd(JSPUtil.getParameter(request, "ctr_cd", ""));
		setBnkAmt(JSPUtil.getParameter(request, "bnk_amt", ""));
		setVvdBunker(JSPUtil.getParameter(request, "vvd_bunker", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setBnkDesc(JSPUtil.getParameter(request, "bnk_desc", ""));
		setBnkQty(JSPUtil.getParameter(request, "bnk_qty", ""));
		setToInvNo(JSPUtil.getParameter(request, "to_inv_no", ""));
		setSlpLocCd(JSPUtil.getParameter(request, "slp_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBunkerListByPaymentSlipVO[]
	 */
	public SearchBunkerListByPaymentSlipVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBunkerListByPaymentSlipVO[]
	 */
	public SearchBunkerListByPaymentSlipVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBunkerListByPaymentSlipVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvdYn = (JSPUtil.getParameter(request, prefix	+ "vvd_yn", length));
			String[] fletSrcTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_src_tp_cd", length));
			String[] acctNm = (JSPUtil.getParameter(request, prefix	+ "acct_nm", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] fletMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "flet_meas_ut_cd", length));
			String[] bnkPrcAmt = (JSPUtil.getParameter(request, prefix	+ "bnk_prc_amt", length));
			String[] bnkSeq = (JSPUtil.getParameter(request, prefix	+ "bnk_seq", length));
			String[] bnkTpCd = (JSPUtil.getParameter(request, prefix	+ "bnk_tp_cd", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] bnkAmt = (JSPUtil.getParameter(request, prefix	+ "bnk_amt", length));
			String[] vvdBunker = (JSPUtil.getParameter(request, prefix	+ "vvd_bunker", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] bnkDesc = (JSPUtil.getParameter(request, prefix	+ "bnk_desc", length));
			String[] bnkQty = (JSPUtil.getParameter(request, prefix	+ "bnk_qty", length));
			String[] toInvNo = (JSPUtil.getParameter(request, prefix	+ "to_inv_no", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBunkerListByPaymentSlipVO();
				if (vvdYn[i] != null)
					model.setVvdYn(vvdYn[i]);
				if (fletSrcTpCd[i] != null)
					model.setFletSrcTpCd(fletSrcTpCd[i]);
				if (acctNm[i] != null)
					model.setAcctNm(acctNm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (fletMeasUtCd[i] != null)
					model.setFletMeasUtCd(fletMeasUtCd[i]);
				if (bnkPrcAmt[i] != null)
					model.setBnkPrcAmt(bnkPrcAmt[i]);
				if (bnkSeq[i] != null)
					model.setBnkSeq(bnkSeq[i]);
				if (bnkTpCd[i] != null)
					model.setBnkTpCd(bnkTpCd[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (bnkAmt[i] != null)
					model.setBnkAmt(bnkAmt[i]);
				if (vvdBunker[i] != null)
					model.setVvdBunker(vvdBunker[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (bnkDesc[i] != null)
					model.setBnkDesc(bnkDesc[i]);
				if (bnkQty[i] != null)
					model.setBnkQty(bnkQty[i]);
				if (toInvNo[i] != null)
					model.setToInvNo(toInvNo[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBunkerListByPaymentSlipVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBunkerListByPaymentSlipVO[]
	 */
	public SearchBunkerListByPaymentSlipVO[] getSearchBunkerListByPaymentSlipVOs(){
		SearchBunkerListByPaymentSlipVO[] vos = (SearchBunkerListByPaymentSlipVO[])models.toArray(new SearchBunkerListByPaymentSlipVO[models.size()]);
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
		this.fletSrcTpCd = this.fletSrcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctNm = this.acctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletMeasUtCd = this.fletMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkPrcAmt = this.bnkPrcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkSeq = this.bnkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkTpCd = this.bnkTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkAmt = this.bnkAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdBunker = this.vvdBunker .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkDesc = this.bnkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkQty = this.bnkQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvNo = this.toInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
