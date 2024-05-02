/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOffhireInvoiceListVO.java
*@FileTitle : SearchOffhireInvoiceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.11 정윤태 
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
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0014HTMLAction
 */

public class SearchOffhireInvoiceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOffhireInvoiceListVO> models = new ArrayList<SearchOffhireInvoiceListVO>();
	
	/* Column Info */
	private String acctItmNm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String oriInvAmt2 = null;
	/* Column Info */
	private String currCd2 = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String fletIssTpCd = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String acctItmSeq = null;
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
	private String oriInvAmt = null;
	/* Column Info */
	private String firInvAmt = null;
	/* Column Info */
	private String firInvAmt2 = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchOffhireInvoiceListVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String acctItmNm, String acctCd, String acctItmSeq, String currCd, String invAmt, String oriInvAmt, String currCd2, String invAmt2, String oriInvAmt2, String slpTpCd, String invDesc, String fletCtrtNo, String fletIssTpCd, String invSeq, String invDtlSeq, String firInvAmt, String firInvAmt2
	 * @return 
	 */
	public SearchOffhireInvoiceListVO(String ibflag, String pagerows, String acctItmNm, String acctCd, String acctItmSeq, String currCd, String invAmt, String oriInvAmt, String currCd2, String invAmt2, String oriInvAmt2, String slpTpCd, String invDesc, String fletCtrtNo, String fletIssTpCd, String invSeq, String invDtlSeq, String firInvAmt, String firInvAmt2) {
		this.acctItmNm = acctItmNm;
		this.currCd = currCd;
		this.oriInvAmt2 = oriInvAmt2;
		this.currCd2 = currCd2;
		this.invSeq = invSeq;
		this.fletIssTpCd = fletIssTpCd;
		this.fletCtrtNo = fletCtrtNo;
		this.pagerows = pagerows;
		this.acctItmSeq = acctItmSeq;
		this.ibflag = ibflag;
		this.invDesc = invDesc;
		this.acctCd = acctCd;
		this.invDtlSeq = invDtlSeq;
		this.invAmt2 = invAmt2;
		this.invAmt = invAmt;
		this.slpTpCd = slpTpCd;
		this.oriInvAmt = oriInvAmt;
		this.firInvAmt = firInvAmt;
		this.firInvAmt2 = firInvAmt2;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acct_itm_nm", getAcctItmNm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ori_inv_amt2", getOriInvAmt2());
		this.hashColumns.put("curr_cd2", getCurrCd2());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("flet_iss_tp_cd", getFletIssTpCd());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("acct_itm_seq", getAcctItmSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("inv_dtl_seq", getInvDtlSeq());
		this.hashColumns.put("inv_amt2", getInvAmt2());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("ori_inv_amt", getOriInvAmt());
		this.hashColumns.put("fir_inv_amt", getFirInvAmt());
		this.hashColumns.put("fir_inv_amt2", getFirInvAmt2());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acct_itm_nm", "acctItmNm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ori_inv_amt2", "oriInvAmt2");
		this.hashFields.put("curr_cd2", "currCd2");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("flet_iss_tp_cd", "fletIssTpCd");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("acct_itm_seq", "acctItmSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("inv_dtl_seq", "invDtlSeq");
		this.hashFields.put("inv_amt2", "invAmt2");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("ori_inv_amt", "oriInvAmt");
		this.hashFields.put("fir_inv_amt", "firInvAmt");
		this.hashFields.put("fir_inv_amt2", "firInvAmt2");
		return this.hashFields;
	}
	
	public String getAcctItmNm() {
		return this.acctItmNm;
	}
	public String getCurrCd() {
		return this.currCd;
	}
	public String getOriInvAmt2() {
		return this.oriInvAmt2;
	}
	public String getCurrCd2() {
		return this.currCd2;
	}
	public String getInvSeq() {
		return this.invSeq;
	}
	public String getFletIssTpCd() {
		return this.fletIssTpCd;
	}
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getAcctItmSeq() {
		return this.acctItmSeq;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getInvDesc() {
		return this.invDesc;
	}
	public String getAcctCd() {
		return this.acctCd;
	}
	public String getInvDtlSeq() {
		return this.invDtlSeq;
	}
	public String getInvAmt2() {
		return this.invAmt2;
	}
	public String getInvAmt() {
		return this.invAmt;
	}
	public String getSlpTpCd() {
		return this.slpTpCd;
	}
	public String getOriInvAmt() {
		return this.oriInvAmt;
	}
	public String getFirInvAmt() {
		return this.firInvAmt;
	}
	public String getFirInvAmt2() {
		return this.firInvAmt2;
	}

	public void setAcctItmNm(String acctItmNm) {
		this.acctItmNm = acctItmNm;
		//this.acctItmNm=true;
	}
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
		//this.currCd=true;
	}
	public void setOriInvAmt2(String oriInvAmt2) {
		this.oriInvAmt2 = oriInvAmt2;
		//this.oriInvAmt2=true;
	}
	public void setCurrCd2(String currCd2) {
		this.currCd2 = currCd2;
		//this.currCd2=true;
	}
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
		//this.invSeq=true;
	}
	public void setFletIssTpCd(String fletIssTpCd) {
		this.fletIssTpCd = fletIssTpCd;
		//this.fletIssTpCd=true;
	}
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
		//this.fletCtrtNo=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setAcctItmSeq(String acctItmSeq) {
		this.acctItmSeq = acctItmSeq;
		//this.acctItmSeq=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
		//this.invDesc=true;
	}
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
		//this.acctCd=true;
	}
	public void setInvDtlSeq(String invDtlSeq) {
		this.invDtlSeq = invDtlSeq;
		//this.invDtlSeq=true;
	}
	public void setInvAmt2(String invAmt2) {
		this.invAmt2 = invAmt2;
		//this.invAmt2=true;
	}
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
		//this.invAmt=true;
	}
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
		//this.slpTpCd=true;
	}
	public void setOriInvAmt(String oriInvAmt) {
		this.oriInvAmt = oriInvAmt;
		//this.oriInvAmt=true;
	}
	public void setFirInvAmt(String firInvAmt) {
		this.firInvAmt = firInvAmt;
		//this.firInvAmt=true;
	}
	public void setFirInvAmt2(String firInvAmt2) {
		this.firInvAmt2 = firInvAmt2;
		//this.firInvAmt2=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setAcctItmNm(JSPUtil.getParameter(request, "acct_itm_nm", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setOriInvAmt2(JSPUtil.getParameter(request, "ori_inv_amt2", ""));
		setCurrCd2(JSPUtil.getParameter(request, "curr_cd2", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setFletIssTpCd(JSPUtil.getParameter(request, "flet_iss_tp_cd", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAcctItmSeq(JSPUtil.getParameter(request, "acct_itm_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInvDesc(JSPUtil.getParameter(request, "inv_desc", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setInvDtlSeq(JSPUtil.getParameter(request, "inv_dtl_seq", ""));
		setInvAmt2(JSPUtil.getParameter(request, "inv_amt2", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setOriInvAmt(JSPUtil.getParameter(request, "ori_inv_amt", ""));
		setFirInvAmt(JSPUtil.getParameter(request, "fir_inv_amt", ""));
		setFirInvAmt2(JSPUtil.getParameter(request, "fir_inv_amt2", ""));
	}

	public SearchOffhireInvoiceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchOffhireInvoiceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOffhireInvoiceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acctItmNm = (JSPUtil.getParameter(request, prefix	+ "acct_itm_nm".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] oriInvAmt2 = (JSPUtil.getParameter(request, prefix	+ "ori_inv_amt2".trim(), length));
			String[] currCd2 = (JSPUtil.getParameter(request, prefix	+ "curr_cd2".trim(), length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq".trim(), length));
			String[] fletIssTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_iss_tp_cd".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] acctItmSeq = (JSPUtil.getParameter(request, prefix	+ "acct_itm_seq".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc".trim(), length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd".trim(), length));
			String[] invDtlSeq = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_seq".trim(), length));
			String[] invAmt2 = (JSPUtil.getParameter(request, prefix	+ "inv_amt2".trim(), length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt".trim(), length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd".trim(), length));
			String[] oriInvAmt = (JSPUtil.getParameter(request, prefix	+ "ori_inv_amt".trim(), length));
			String[] firInvAmt = (JSPUtil.getParameter(request, prefix	+ "fir_inv_amt".trim(), length));
			String[] firInvAmt2 = (JSPUtil.getParameter(request, prefix	+ "fir_inv_amt2".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOffhireInvoiceListVO();
				if (acctItmNm[i] != null)
					model.setAcctItmNm(acctItmNm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (oriInvAmt2[i] != null)
					model.setOriInvAmt2(oriInvAmt2[i]);
				if (currCd2[i] != null)
					model.setCurrCd2(currCd2[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (fletIssTpCd[i] != null)
					model.setFletIssTpCd(fletIssTpCd[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
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
				if (invAmt2[i] != null)
					model.setInvAmt2(invAmt2[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (oriInvAmt[i] != null)
					model.setOriInvAmt(oriInvAmt[i]);
				if (firInvAmt[i] != null)
					model.setFirInvAmt(firInvAmt[i]);
				if (firInvAmt2[i] != null)
					model.setFirInvAmt2(firInvAmt2[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchOffhireInvoiceListVOs();
	}

	public SearchOffhireInvoiceListVO[] getSearchOffhireInvoiceListVOs(){
		SearchOffhireInvoiceListVO[] vos = (SearchOffhireInvoiceListVO[])models.toArray(new SearchOffhireInvoiceListVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.acctItmNm = this.acctItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriInvAmt2 = this.oriInvAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd2 = this.currCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletIssTpCd = this.fletIssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmSeq = this.acctItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlSeq = this.invDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt2 = this.invAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriInvAmt = this.oriInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firInvAmt = this.firInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firInvAmt2 = this.firInvAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
