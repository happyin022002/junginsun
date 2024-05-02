/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCharterInvoiceListVO.java
*@FileTitle : SearchCharterInvoiceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.11 정윤태 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCharterInvoiceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCharterInvoiceListVO> models = new ArrayList<SearchCharterInvoiceListVO>();
	
	/* Column Info */
	private String acctItmNm = null;
	/* Column Info */
	private String chtrInvDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String bunkerVvd = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String fletIssTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Column Info */
	private String acctItmSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String invDtlSeq = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String toInvNo = null;
	/* Column Info */
	private String sdmsNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCharterInvoiceListVO() {}

	public SearchCharterInvoiceListVO(String ibflag, String pagerows, String fletCtrtNo, String fletIssTpCd, String invSeq, String invDtlSeq, String acctItmNm, String acctCd, String acctItmSeq, String currCd, String invAmt, String chtrInvDt, String invDesc, String toInvNo, String slpTpCd, String bunkerVvd, String sdmsNo) {
		this.acctItmNm = acctItmNm;
		this.chtrInvDt = chtrInvDt;
		this.currCd = currCd;
		this.bunkerVvd = bunkerVvd;
		this.invSeq = invSeq;
		this.fletIssTpCd = fletIssTpCd;
		this.pagerows = pagerows;
		this.fletCtrtNo = fletCtrtNo;
		this.acctItmSeq = acctItmSeq;
		this.ibflag = ibflag;
		this.invDesc = invDesc;
		this.acctCd = acctCd;
		this.invDtlSeq = invDtlSeq;
		this.slpTpCd = slpTpCd;
		this.invAmt = invAmt;
		this.toInvNo = toInvNo;
		this.sdmsNo = sdmsNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acct_itm_nm", getAcctItmNm());
		this.hashColumns.put("chtr_inv_dt", getChtrInvDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("bunker_vvd", getBunkerVvd());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("flet_iss_tp_cd", getFletIssTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("acct_itm_seq", getAcctItmSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("inv_dtl_seq", getInvDtlSeq());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("to_inv_no", getToInvNo());
		this.hashColumns.put("sdms_no", getSdmsNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acct_itm_nm", "acctItmNm");
		this.hashFields.put("chtr_inv_dt", "chtrInvDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("bunker_vvd", "bunkerVvd");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("flet_iss_tp_cd", "fletIssTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("acct_itm_seq", "acctItmSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("inv_dtl_seq", "invDtlSeq");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("to_inv_no", "toInvNo");
		this.hashFields.put("sdms_no", "sdmsNo");
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
	 * @return chtrInvDt
	 */
	public String getChtrInvDt() {
		return this.chtrInvDt;
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
	 * @return bunkerVvd
	 */
	public String getBunkerVvd() {
		return this.bunkerVvd;
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
	 * @return slpTpCd
	 */
	public String getSlpTpCd() {
		return this.slpTpCd;
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
	 * @return toInvNo
	 */
	public String getToInvNo() {
		return this.toInvNo;
	}
	
	/**
	 * Column Info
	 * @return sdmsNo
	 */
	public String getSdmsNo() {
		return this.sdmsNo;
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
	 * @param chtrInvDt
	 */
	public void setChtrInvDt(String chtrInvDt) {
		this.chtrInvDt = chtrInvDt;
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
	 * @param bunkerVvd
	 */
	public void setBunkerVvd(String bunkerVvd) {
		this.bunkerVvd = bunkerVvd;
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
	 * @param slpTpCd
	 */
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
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
	 * @param toInvNo
	 */
	public void setToInvNo(String toInvNo) {
		this.toInvNo = toInvNo;
	}
	
	/**
	 * Column Info
	 * @param sdmsNo
	 */
	public void setSdmsNo(String sdmsNo) {
		this.sdmsNo = sdmsNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAcctItmNm(JSPUtil.getParameter(request, "acct_itm_nm", ""));
		setChtrInvDt(JSPUtil.getParameter(request, "chtr_inv_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setBunkerVvd(JSPUtil.getParameter(request, "bunker_vvd", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setFletIssTpCd(JSPUtil.getParameter(request, "flet_iss_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setAcctItmSeq(JSPUtil.getParameter(request, "acct_itm_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInvDesc(JSPUtil.getParameter(request, "inv_desc", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setInvDtlSeq(JSPUtil.getParameter(request, "inv_dtl_seq", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setToInvNo(JSPUtil.getParameter(request, "to_inv_no", ""));
		setSdmsNo(JSPUtil.getParameter(request, "sdms_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCharterInvoiceListVO[]
	 */
	public SearchCharterInvoiceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCharterInvoiceListVO[]
	 */
	public SearchCharterInvoiceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCharterInvoiceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acctItmNm = (JSPUtil.getParameter(request, prefix	+ "acct_itm_nm", length));
			String[] chtrInvDt = (JSPUtil.getParameter(request, prefix	+ "chtr_inv_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] bunkerVvd = (JSPUtil.getParameter(request, prefix	+ "bunker_vvd", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] fletIssTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_iss_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] acctItmSeq = (JSPUtil.getParameter(request, prefix	+ "acct_itm_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] invDtlSeq = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_seq", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] toInvNo = (JSPUtil.getParameter(request, prefix	+ "to_inv_no", length));
			String[] sdmsNo = (JSPUtil.getParameter(request, prefix	+ "sdms_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCharterInvoiceListVO();
				if (acctItmNm[i] != null)
					model.setAcctItmNm(acctItmNm[i]);
				if (chtrInvDt[i] != null)
					model.setChtrInvDt(chtrInvDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (bunkerVvd[i] != null)
					model.setBunkerVvd(bunkerVvd[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (fletIssTpCd[i] != null)
					model.setFletIssTpCd(fletIssTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (acctItmSeq[i] != null)
					model.setAcctItmSeq(acctItmSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (invDtlSeq[i] != null)
					model.setInvDtlSeq(invDtlSeq[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (toInvNo[i] != null)
					model.setToInvNo(toInvNo[i]);
				if (sdmsNo[i] != null)
					model.setSdmsNo(sdmsNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCharterInvoiceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCharterInvoiceListVO[]
	 */
	public SearchCharterInvoiceListVO[] getSearchCharterInvoiceListVOs(){
		SearchCharterInvoiceListVO[] vos = (SearchCharterInvoiceListVO[])models.toArray(new SearchCharterInvoiceListVO[models.size()]);
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
		this.chtrInvDt = this.chtrInvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bunkerVvd = this.bunkerVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletIssTpCd = this.fletIssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmSeq = this.acctItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlSeq = this.invDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvNo = this.toInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdmsNo = this.sdmsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
