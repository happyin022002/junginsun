/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCharterIniceListVO.java
*@FileTitle : SearchCharterIniceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.15
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.15 정윤태
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
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0016HTMLAction
 */

public class CondCharterInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondCharterInvoiceVO> models = new ArrayList<CondCharterInvoiceVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String chtrInvDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String currCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String toChtrInvDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String bunkerVvd = null;
	/* 而щ읆 �ㅻ챸 */
	private String invSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletIssTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletCtrtNo = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctItmSeq = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String invDesc = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String invDtlSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String slpTpCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String invAmt = null;
	/* 而щ읆 �ㅻ챸 */
	private String fromChtrInvDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String toInvNo = null;
	/* Column Info */
	private String chtrPayRcvCd = null;
	/* Column Info */
	private String dtFlg = null;
	/* Column Info */
	private String aproFlg = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public CondCharterInvoiceVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String fletCtrtNo, String fletIssTpCd, String invSeq, String invDtlSeq, String acctCd, String acctItmSeq, String currCd, String invAmt, String chtrInvDt, String invDesc, String toInvNo, String slpTpCd, String bunkerVvd, String fromChtrInvDt, String toChtrInvDt
	 * @return 
	 */
	public CondCharterInvoiceVO(String ibflag, String pagerows, String fletCtrtNo, String fletIssTpCd, String invSeq, String invDtlSeq, String acctCd, String acctItmSeq, String currCd, String invAmt, String chtrInvDt, String invDesc, String toInvNo, String slpTpCd, String bunkerVvd, String fromChtrInvDt, String toChtrInvDt, String chtrPayRcvCd, String dtFlg, String aproFlg) {
		this.chtrInvDt = chtrInvDt;
		this.currCd = currCd;
		this.toChtrInvDt = toChtrInvDt;
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
		this.fromChtrInvDt = fromChtrInvDt;
		this.toInvNo = toInvNo;
		this.chtrPayRcvCd = chtrPayRcvCd;
		this.dtFlg = dtFlg;
		this.aproFlg = aproFlg;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chtr_inv_dt", getChtrInvDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("to_chtr_inv_dt", getToChtrInvDt());
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
		this.hashColumns.put("from_chtr_inv_dt", getFromChtrInvDt());
		this.hashColumns.put("to_inv_no", getToInvNo());
		this.hashColumns.put("chtr_pay_rcv_cd", getChtrPayRcvCd());
		this.hashColumns.put("dt_flg", getDtFlg());
		this.hashColumns.put("apro_flg", getAproFlg());
		
		return this.hashColumns;
	}
	
	/** 
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chtr_inv_dt", "chtrInvDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("to_chtr_inv_dt", "toChtrInvDt");
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
		this.hashFields.put("from_chtr_inv_dt", "fromChtrInvDt");
		this.hashFields.put("to_inv_no", "toInvNo");
		this.hashFields.put("chtr_pay_rcv_cd", "chtrPayRcvCd");
		this.hashFields.put("dt_flg", "dtFlg");
		this.hashFields.put("apro_flg", "aproFlg");
		
		return this.hashFields;
	}
	
	public String getChtrInvDt() {
		return this.chtrInvDt;
	}
	public String getCurrCd() {
		return this.currCd;
	}
	public String getToChtrInvDt() {
		return this.toChtrInvDt;
	}
	public String getBunkerVvd() {
		return this.bunkerVvd;
	}
	public String getInvSeq() {
		return this.invSeq;
	}
	public String getFletIssTpCd() {
		return this.fletIssTpCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
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
	public String getSlpTpCd() {
		return this.slpTpCd;
	}
	public String getInvAmt() {
		return this.invAmt;
	}
	public String getFromChtrInvDt() {
		return this.fromChtrInvDt;
	}
	public String getToInvNo() {
		return this.toInvNo;
	}
	public String getChtrPayRcvCd() {
		return this.chtrPayRcvCd;
	}
	public String getDtFlg() {
		return this.dtFlg;
	}
	public String getAproFlg() {
		return this.aproFlg;
	}

	public void setChtrInvDt(String chtrInvDt) {
		this.chtrInvDt = chtrInvDt;
		//this.chtrInvDt=true;
	}
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
		//this.currCd=true;
	}
	public void setToChtrInvDt(String toChtrInvDt) {
		this.toChtrInvDt = toChtrInvDt;
		//this.toChtrInvDt=true;
	}
	public void setBunkerVvd(String bunkerVvd) {
		this.bunkerVvd = bunkerVvd;
		//this.bunkerVvd=true;
	}
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
		//this.invSeq=true;
	}
	public void setFletIssTpCd(String fletIssTpCd) {
		this.fletIssTpCd = fletIssTpCd;
		//this.fletIssTpCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
		//this.fletCtrtNo=true;
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
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
		//this.slpTpCd=true;
	}
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
		//this.invAmt=true;
	}
	public void setFromChtrInvDt(String fromChtrInvDt) {
		this.fromChtrInvDt = fromChtrInvDt;
		//this.fromChtrInvDt=true;
	}
	public void setToInvNo(String toInvNo) {
		this.toInvNo = toInvNo;
		//this.toInvNo=true;
	}
	public void setChtrPayRcvCd(String chtrPayRcvCd) {
		this.chtrPayRcvCd = chtrPayRcvCd;
		//this.chtrPayRcvCd=true;
	}
	public void setDtFlg(String dtFlg) {
		this.dtFlg = dtFlg;
	}
	public void setAproFlg(String aproFlg) {
		this.aproFlg = aproFlg;
	}
	public void fromRequest(HttpServletRequest request) {
		setChtrInvDt(JSPUtil.getParameter(request, "chtr_inv_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setToChtrInvDt(JSPUtil.getParameter(request, "to_chtr_inv_dt", ""));
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
		setFromChtrInvDt(JSPUtil.getParameter(request, "from_chtr_inv_dt", ""));
		setToInvNo(JSPUtil.getParameter(request, "to_inv_no", ""));
		setChtrPayRcvCd(JSPUtil.getParameter(request, "chtr_pay_rcv_cd", ""));
		setDtFlg(JSPUtil.getParameter(request, "dt_flg", ""));
		setAproFlg(JSPUtil.getParameter(request, "apro_flg", ""));
	}

	public CondCharterInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CondCharterInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondCharterInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chtrInvDt = (JSPUtil.getParameter(request, prefix	+ "chtr_inv_dt".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] toChtrInvDt = (JSPUtil.getParameter(request, prefix	+ "to_chtr_inv_dt".trim(), length));
			String[] bunkerVvd = (JSPUtil.getParameter(request, prefix	+ "bunker_vvd".trim(), length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq".trim(), length));
			String[] fletIssTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_iss_tp_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] acctItmSeq = (JSPUtil.getParameter(request, prefix	+ "acct_itm_seq".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc".trim(), length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd".trim(), length));
			String[] invDtlSeq = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_seq".trim(), length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd".trim(), length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt".trim(), length));
			String[] fromChtrInvDt = (JSPUtil.getParameter(request, prefix	+ "from_chtr_inv_dt".trim(), length));
			String[] toInvNo = (JSPUtil.getParameter(request, prefix	+ "to_inv_no".trim(), length));
			String[] chtrPayRcvCd = (JSPUtil.getParameter(request, prefix	+ "chtr_pay_rcv_cd".trim(), length));
			String[] dtFlg = (JSPUtil.getParameter(request, prefix	+ "dt_flg".trim(), length));
			String[] aproFlg = (JSPUtil.getParameter(request, prefix	+ "apro_flg".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CondCharterInvoiceVO();
				if (chtrInvDt[i] != null)
					model.setChtrInvDt(chtrInvDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (toChtrInvDt[i] != null)
					model.setToChtrInvDt(toChtrInvDt[i]);
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
				if (fromChtrInvDt[i] != null)
					model.setFromChtrInvDt(fromChtrInvDt[i]);
				if (toInvNo[i] != null)
					model.setToInvNo(toInvNo[i]);
				if (chtrPayRcvCd[i] != null)
					model.setChtrPayRcvCd(chtrPayRcvCd[i]);
				if (dtFlg[i] != null)
					model.setDtFlg(dtFlg[i]);
				if (aproFlg[i] != null)
					model.setAproFlg(aproFlg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchCharterIniceListVOs();
	}

	public CondCharterInvoiceVO[] getSearchCharterIniceListVOs(){
		CondCharterInvoiceVO[] vos = (CondCharterInvoiceVO[])models.toArray(new CondCharterInvoiceVO[models.size()]);
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
		this.chtrInvDt = this.chtrInvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toChtrInvDt = this.toChtrInvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.fromChtrInvDt = this.fromChtrInvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvNo = this.toInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtrPayRcvCd = this.chtrPayRcvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtFlg = this.dtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg = this.aproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

