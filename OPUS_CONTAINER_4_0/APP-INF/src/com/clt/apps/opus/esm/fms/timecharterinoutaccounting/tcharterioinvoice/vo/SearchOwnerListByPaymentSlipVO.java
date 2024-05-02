/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchOwnerListByPaymentSlipVO.java
*@FileTitle : SearchOwnerListByPaymentSlipVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.14  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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

public class SearchOwnerListByPaymentSlipVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOwnerListByPaymentSlipVO> models = new ArrayList<SearchOwnerListByPaymentSlipVO>();
	
	/* Column Info */
	private String vvdYn = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String fletSrcTpCd = null;
	/* Column Info */
	private String acctNm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String apDesc = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String fletOlayCommRtAmt = null;
	/* Column Info */
	private String orgSlpNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String manhourCh = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCurrCd = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String vvdBunker = null;
	/* Column Info */
	private String n1stAmt = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String locAmt = null;
	/* Column Info */
	private String slpSerNo = null;
	/* Column Info */
	private String slpLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOwnerListByPaymentSlipVO() {}

	public SearchOwnerListByPaymentSlipVO(String ibflag, String pagerows, String acctNm, String acctCd, String vvdBunker, String currCd, String n1stAmt, String locCurrCd, String locAmt, String manhourCh, String apDesc, String ctrCd, String slpLocCd, String fletOlayCommRtAmt, String fletSrcTpCd, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo, String slpSeqNo, String vvdYn, String orgSlpNo) {
		this.vvdYn = vvdYn;
		this.slpFuncCd = slpFuncCd;
		this.fletSrcTpCd = fletSrcTpCd;
		this.acctNm = acctNm;
		this.currCd = currCd;
		this.slpSeqNo = slpSeqNo;
		this.apDesc = apDesc;
		this.slpIssDt = slpIssDt;
		this.slpOfcCd = slpOfcCd;
		this.fletOlayCommRtAmt = fletOlayCommRtAmt;
		this.orgSlpNo = orgSlpNo;
		this.pagerows = pagerows;
		this.manhourCh = manhourCh;
		this.ibflag = ibflag;
		this.locCurrCd = locCurrCd;
		this.ctrCd = ctrCd;
		this.vvdBunker = vvdBunker;
		this.n1stAmt = n1stAmt;
		this.acctCd = acctCd;
		this.slpTpCd = slpTpCd;
		this.locAmt = locAmt;
		this.slpSerNo = slpSerNo;
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd_yn", getVvdYn());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("flet_src_tp_cd", getFletSrcTpCd());
		this.hashColumns.put("acct_nm", getAcctNm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("ap_desc", getApDesc());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("flet_olay_comm_rt_amt", getFletOlayCommRtAmt());
		this.hashColumns.put("org_slp_no", getOrgSlpNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("manhour_ch", getManhourCh());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_curr_cd", getLocCurrCd());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("vvd_bunker", getVvdBunker());
		this.hashColumns.put("n1st_amt", getN1stAmt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("loc_amt", getLocAmt());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("slp_loc_cd", getSlpLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd_yn", "vvdYn");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("flet_src_tp_cd", "fletSrcTpCd");
		this.hashFields.put("acct_nm", "acctNm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("ap_desc", "apDesc");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("flet_olay_comm_rt_amt", "fletOlayCommRtAmt");
		this.hashFields.put("org_slp_no", "orgSlpNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("manhour_ch", "manhourCh");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_curr_cd", "locCurrCd");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("vvd_bunker", "vvdBunker");
		this.hashFields.put("n1st_amt", "n1stAmt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("loc_amt", "locAmt");
		this.hashFields.put("slp_ser_no", "slpSerNo");
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
	 * @return slpFuncCd
	 */
	public String getSlpFuncCd() {
		return this.slpFuncCd;
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
	 * @return slpSeqNo
	 */
	public String getSlpSeqNo() {
		return this.slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return apDesc
	 */
	public String getApDesc() {
		return this.apDesc;
	}
	
	/**
	 * Column Info
	 * @return slpIssDt
	 */
	public String getSlpIssDt() {
		return this.slpIssDt;
	}
	
	/**
	 * Column Info
	 * @return slpOfcCd
	 */
	public String getSlpOfcCd() {
		return this.slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fletOlayCommRtAmt
	 */
	public String getFletOlayCommRtAmt() {
		return this.fletOlayCommRtAmt;
	}
	
	/**
	 * Column Info
	 * @return orgSlpNo
	 */
	public String getOrgSlpNo() {
		return this.orgSlpNo;
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
	 * @return manhourCh
	 */
	public String getManhourCh() {
		return this.manhourCh;
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
	 * @return locCurrCd
	 */
	public String getLocCurrCd() {
		return this.locCurrCd;
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
	 * @return n1stAmt
	 */
	public String getN1stAmt() {
		return this.n1stAmt;
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
	 * @return slpTpCd
	 */
	public String getSlpTpCd() {
		return this.slpTpCd;
	}
	
	/**
	 * Column Info
	 * @return locAmt
	 */
	public String getLocAmt() {
		return this.locAmt;
	}
	
	/**
	 * Column Info
	 * @return slpSerNo
	 */
	public String getSlpSerNo() {
		return this.slpSerNo;
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
	 * @param slpFuncCd
	 */
	public void setSlpFuncCd(String slpFuncCd) {
		this.slpFuncCd = slpFuncCd;
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
	 * @param slpSeqNo
	 */
	public void setSlpSeqNo(String slpSeqNo) {
		this.slpSeqNo = slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param apDesc
	 */
	public void setApDesc(String apDesc) {
		this.apDesc = apDesc;
	}
	
	/**
	 * Column Info
	 * @param slpIssDt
	 */
	public void setSlpIssDt(String slpIssDt) {
		this.slpIssDt = slpIssDt;
	}
	
	/**
	 * Column Info
	 * @param slpOfcCd
	 */
	public void setSlpOfcCd(String slpOfcCd) {
		this.slpOfcCd = slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fletOlayCommRtAmt
	 */
	public void setFletOlayCommRtAmt(String fletOlayCommRtAmt) {
		this.fletOlayCommRtAmt = fletOlayCommRtAmt;
	}
	
	/**
	 * Column Info
	 * @param orgSlpNo
	 */
	public void setOrgSlpNo(String orgSlpNo) {
		this.orgSlpNo = orgSlpNo;
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
	 * @param manhourCh
	 */
	public void setManhourCh(String manhourCh) {
		this.manhourCh = manhourCh;
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
	 * @param locCurrCd
	 */
	public void setLocCurrCd(String locCurrCd) {
		this.locCurrCd = locCurrCd;
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
	 * @param n1stAmt
	 */
	public void setN1stAmt(String n1stAmt) {
		this.n1stAmt = n1stAmt;
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
	 * @param slpTpCd
	 */
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
	}
	
	/**
	 * Column Info
	 * @param locAmt
	 */
	public void setLocAmt(String locAmt) {
		this.locAmt = locAmt;
	}
	
	/**
	 * Column Info
	 * @param slpSerNo
	 */
	public void setSlpSerNo(String slpSerNo) {
		this.slpSerNo = slpSerNo;
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
		setSlpFuncCd(JSPUtil.getParameter(request, prefix + "slp_func_cd", ""));
		setFletSrcTpCd(JSPUtil.getParameter(request, prefix + "flet_src_tp_cd", ""));
		setAcctNm(JSPUtil.getParameter(request, prefix + "acct_nm", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, prefix + "slp_seq_no", ""));
		setApDesc(JSPUtil.getParameter(request, prefix + "ap_desc", ""));
		setSlpIssDt(JSPUtil.getParameter(request, prefix + "slp_iss_dt", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, prefix + "slp_ofc_cd", ""));
		setFletOlayCommRtAmt(JSPUtil.getParameter(request, prefix + "flet_olay_comm_rt_amt", ""));
		setOrgSlpNo(JSPUtil.getParameter(request, prefix + "org_slp_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setManhourCh(JSPUtil.getParameter(request, prefix + "manhour_ch", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCurrCd(JSPUtil.getParameter(request, prefix + "loc_curr_cd", ""));
		setCtrCd(JSPUtil.getParameter(request, prefix + "ctr_cd", ""));
		setVvdBunker(JSPUtil.getParameter(request, prefix + "vvd_bunker", ""));
		setN1stAmt(JSPUtil.getParameter(request, prefix + "n1st_amt", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setSlpTpCd(JSPUtil.getParameter(request, prefix + "slp_tp_cd", ""));
		setLocAmt(JSPUtil.getParameter(request, prefix + "loc_amt", ""));
		setSlpSerNo(JSPUtil.getParameter(request, prefix + "slp_ser_no", ""));
		setSlpLocCd(JSPUtil.getParameter(request, prefix + "slp_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOwnerListByPaymentSlipVO[]
	 */
	public SearchOwnerListByPaymentSlipVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOwnerListByPaymentSlipVO[]
	 */
	public SearchOwnerListByPaymentSlipVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOwnerListByPaymentSlipVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvdYn = (JSPUtil.getParameter(request, prefix	+ "vvd_yn", length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] fletSrcTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_src_tp_cd", length));
			String[] acctNm = (JSPUtil.getParameter(request, prefix	+ "acct_nm", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no", length));
			String[] apDesc = (JSPUtil.getParameter(request, prefix	+ "ap_desc", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] fletOlayCommRtAmt = (JSPUtil.getParameter(request, prefix	+ "flet_olay_comm_rt_amt", length));
			String[] orgSlpNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] manhourCh = (JSPUtil.getParameter(request, prefix	+ "manhour_ch", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCurrCd = (JSPUtil.getParameter(request, prefix	+ "loc_curr_cd", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] vvdBunker = (JSPUtil.getParameter(request, prefix	+ "vvd_bunker", length));
			String[] n1stAmt = (JSPUtil.getParameter(request, prefix	+ "n1st_amt", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] locAmt = (JSPUtil.getParameter(request, prefix	+ "loc_amt", length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOwnerListByPaymentSlipVO();
				if (vvdYn[i] != null)
					model.setVvdYn(vvdYn[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (fletSrcTpCd[i] != null)
					model.setFletSrcTpCd(fletSrcTpCd[i]);
				if (acctNm[i] != null)
					model.setAcctNm(acctNm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (apDesc[i] != null)
					model.setApDesc(apDesc[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (fletOlayCommRtAmt[i] != null)
					model.setFletOlayCommRtAmt(fletOlayCommRtAmt[i]);
				if (orgSlpNo[i] != null)
					model.setOrgSlpNo(orgSlpNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (manhourCh[i] != null)
					model.setManhourCh(manhourCh[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCurrCd[i] != null)
					model.setLocCurrCd(locCurrCd[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (vvdBunker[i] != null)
					model.setVvdBunker(vvdBunker[i]);
				if (n1stAmt[i] != null)
					model.setN1stAmt(n1stAmt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (locAmt[i] != null)
					model.setLocAmt(locAmt[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOwnerListByPaymentSlipVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOwnerListByPaymentSlipVO[]
	 */
	public SearchOwnerListByPaymentSlipVO[] getSearchOwnerListByPaymentSlipVOs(){
		SearchOwnerListByPaymentSlipVO[] vos = (SearchOwnerListByPaymentSlipVO[])models.toArray(new SearchOwnerListByPaymentSlipVO[models.size()]);
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
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletSrcTpCd = this.fletSrcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctNm = this.acctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc = this.apDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletOlayCommRtAmt = this.fletOlayCommRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpNo = this.orgSlpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manhourCh = this.manhourCh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCurrCd = this.locCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdBunker = this.vvdBunker .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stAmt = this.n1stAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locAmt = this.locAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
