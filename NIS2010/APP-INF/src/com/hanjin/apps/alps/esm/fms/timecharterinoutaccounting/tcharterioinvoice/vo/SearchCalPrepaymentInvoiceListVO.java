/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCalPrepaymentInvoiceListVO.java
*@FileTitle : SearchCalPrepaymentInvoiceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.22 정윤태 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCalPrepaymentInvoiceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCalPrepaymentInvoiceListVO> models = new ArrayList<SearchCalPrepaymentInvoiceListVO>();
	
	/* Column Info */
	private String acctItmNm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String oriInvAmt2 = null;
	/* Column Info */
	private String currCd2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Column Info */
	private String acctItmSeq = null;
	/* Column Info */
	private String effDt = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String invDtlSeq = null;
	/* Column Info */
	private String invAmt2 = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String invUsdDys = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String oriInvAmt = null;
	/* Column Info */
	private String sortKey = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchCalPrepaymentInvoiceListVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String acctItmNm, String acctCd, String currCd, String invAmt, String oriInvAmt, String currCd2, String invAmt2, String oriInvAmt2, String slpTpCd, String invDesc, String fletCtrtNo, String invDtlSeq, String acctItmSeq, String effDt, String expDt, String invUsdDys, String sortKey
	 * @return 
	 */
	public SearchCalPrepaymentInvoiceListVO(String ibflag, String pagerows, String acctItmNm, String acctCd, String currCd, String invAmt, String oriInvAmt, String currCd2, String invAmt2, String oriInvAmt2, String slpTpCd, String invDesc, String fletCtrtNo, String invDtlSeq, String acctItmSeq, String effDt, String expDt, String invUsdDys, String sortKey) {
		this.acctItmNm = acctItmNm;
		this.currCd = currCd;
		this.oriInvAmt2 = oriInvAmt2;
		this.currCd2 = currCd2;
		this.pagerows = pagerows;
		this.fletCtrtNo = fletCtrtNo;
		this.acctItmSeq = acctItmSeq;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.invDesc = invDesc;
		this.acctCd = acctCd;
		this.invDtlSeq = invDtlSeq;
		this.invAmt2 = invAmt2;
		this.invAmt = invAmt;
		this.slpTpCd = slpTpCd;
		this.invUsdDys = invUsdDys;
		this.expDt = expDt;
		this.oriInvAmt = oriInvAmt;
		this.sortKey = sortKey;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acct_itm_nm", getAcctItmNm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ori_inv_amt2", getOriInvAmt2());
		this.hashColumns.put("curr_cd2", getCurrCd2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("acct_itm_seq", getAcctItmSeq());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("inv_dtl_seq", getInvDtlSeq());
		this.hashColumns.put("inv_amt2", getInvAmt2());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("inv_usd_dys", getInvUsdDys());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("ori_inv_amt", getOriInvAmt());
		this.hashColumns.put("sort_key", getSortKey());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acct_itm_nm", "acctItmNm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ori_inv_amt2", "oriInvAmt2");
		this.hashFields.put("curr_cd2", "currCd2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("acct_itm_seq", "acctItmSeq");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("inv_dtl_seq", "invDtlSeq");
		this.hashFields.put("inv_amt2", "invAmt2");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("inv_usd_dys", "invUsdDys");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("ori_inv_amt", "oriInvAmt");
		this.hashFields.put("sort_key", "sortKey");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return acctItmNm
	 */
	public String getAcctItmNm() {
		return this.acctItmNm;
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
	 * @return oriInvAmt2
	 */
	public String getOriInvAmt2() {
		return this.oriInvAmt2;
	}
	
	/**
	 * Column Info
	 * @return currCd2
	 */
	public String getCurrCd2() {
		return this.currCd2;
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
	 * @return fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	
	/**
	 * Column Info
	 * @return acctItmSeq
	 */
	public String getAcctItmSeq() {
		return this.acctItmSeq;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Status
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
	 * @return invAmt2
	 */
	public String getInvAmt2() {
		return this.invAmt2;
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
	 * @return slpTpCd
	 */
	public String getSlpTpCd() {
		return this.slpTpCd;
	}
	
	/**
	 * Column Info
	 * @return invUsdDys
	 */
	public String getInvUsdDys() {
		return this.invUsdDys;
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
	 * @return oriInvAmt
	 */
	public String getOriInvAmt() {
		return this.oriInvAmt;
	}
	
	/**
	 * Column Info
	 * @return sortKey
	 */
	public String getSortKey() {
		return this.sortKey;
	}
	

	/**
	 * Column Info
	 * @param acctItmNm
	 */
	public void setAcctItmNm(String acctItmNm) {
		this.acctItmNm = acctItmNm;
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
	 * @param oriInvAmt2
	 */
	public void setOriInvAmt2(String oriInvAmt2) {
		this.oriInvAmt2 = oriInvAmt2;
	}
	
	/**
	 * Column Info
	 * @param currCd2
	 */
	public void setCurrCd2(String currCd2) {
		this.currCd2 = currCd2;
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
	 * @param fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
	
	/**
	 * Column Info
	 * @param acctItmSeq
	 */
	public void setAcctItmSeq(String acctItmSeq) {
		this.acctItmSeq = acctItmSeq;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Status
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
	 * @param invAmt2
	 */
	public void setInvAmt2(String invAmt2) {
		this.invAmt2 = invAmt2;
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
	 * @param slpTpCd
	 */
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
	}
	
	/**
	 * Column Info
	 * @param invUsdDys
	 */
	public void setInvUsdDys(String invUsdDys) {
		this.invUsdDys = invUsdDys;
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
	 * @param oriInvAmt
	 */
	public void setOriInvAmt(String oriInvAmt) {
		this.oriInvAmt = oriInvAmt;
	}
	
	/**
	 * Column Info
	 * @param sortKey
	 */
	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
		//this.sortKey=true;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAcctItmNm(JSPUtil.getParameter(request, "acct_itm_nm", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setOriInvAmt2(JSPUtil.getParameter(request, "ori_inv_amt2", ""));
		setCurrCd2(JSPUtil.getParameter(request, "curr_cd2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setAcctItmSeq(JSPUtil.getParameter(request, "acct_itm_seq", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInvDesc(JSPUtil.getParameter(request, "inv_desc", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setInvDtlSeq(JSPUtil.getParameter(request, "inv_dtl_seq", ""));
		setInvAmt2(JSPUtil.getParameter(request, "inv_amt2", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setInvUsdDys(JSPUtil.getParameter(request, "inv_usd_dys", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setOriInvAmt(JSPUtil.getParameter(request, "ori_inv_amt", ""));
		setSortKey(JSPUtil.getParameter(request, "sort_key", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCalPrepaymentInvoiceListVO[]
	 */
	public SearchCalPrepaymentInvoiceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCalPrepaymentInvoiceListVO[]
	 */
	public SearchCalPrepaymentInvoiceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCalPrepaymentInvoiceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acctItmNm = (JSPUtil.getParameter(request, prefix	+ "acct_itm_nm".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] oriInvAmt2 = (JSPUtil.getParameter(request, prefix	+ "ori_inv_amt2".trim(), length));
			String[] currCd2 = (JSPUtil.getParameter(request, prefix	+ "curr_cd2".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] acctItmSeq = (JSPUtil.getParameter(request, prefix	+ "acct_itm_seq".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc".trim(), length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd".trim(), length));
			String[] invDtlSeq = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_seq".trim(), length));
			String[] invAmt2 = (JSPUtil.getParameter(request, prefix	+ "inv_amt2".trim(), length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt".trim(), length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd".trim(), length));
			String[] invUsdDys = (JSPUtil.getParameter(request, prefix	+ "inv_usd_dys".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] oriInvAmt = (JSPUtil.getParameter(request, prefix	+ "ori_inv_amt".trim(), length));
			String[] sortKey = (JSPUtil.getParameter(request, prefix	+ "sort_key".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCalPrepaymentInvoiceListVO();
				if (acctItmNm[i] != null)
					model.setAcctItmNm(acctItmNm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (oriInvAmt2[i] != null)
					model.setOriInvAmt2(oriInvAmt2[i]);
				if (currCd2[i] != null)
					model.setCurrCd2(currCd2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (acctItmSeq[i] != null)
					model.setAcctItmSeq(acctItmSeq[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (invDtlSeq[i] != null)
					model.setInvDtlSeq(invDtlSeq[i]);
				if (invAmt2[i] != null)
					model.setInvAmt2(invAmt2[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (invUsdDys[i] != null)
					model.setInvUsdDys(invUsdDys[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (oriInvAmt[i] != null)
					model.setOriInvAmt(oriInvAmt[i]);
				if (sortKey[i] != null)
					model.setSortKey(sortKey[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCalPrepaymentInvoiceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCalPrepaymentInvoiceListVO[]
	 */
	public SearchCalPrepaymentInvoiceListVO[] getSearchCalPrepaymentInvoiceListVOs(){
		SearchCalPrepaymentInvoiceListVO[] vos = (SearchCalPrepaymentInvoiceListVO[])models.toArray(new SearchCalPrepaymentInvoiceListVO[models.size()]);
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
		this.acctItmNm = this.acctItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriInvAmt2 = this.oriInvAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd2 = this.currCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmSeq = this.acctItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlSeq = this.invDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt2 = this.invAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdDys = this.invUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriInvAmt = this.oriInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortKey = this.sortKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
