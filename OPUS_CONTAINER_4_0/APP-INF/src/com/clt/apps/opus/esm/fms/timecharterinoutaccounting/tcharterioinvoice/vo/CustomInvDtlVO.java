/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomInvDtlVO.java
*@FileTitle : CustomInvDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.16 정윤태
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
 * @see ESM_FMS_0016HTMLAction
 */

public class CustomInvDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomInvDtlVO> models = new ArrayList<CustomInvDtlVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String chtrInvDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String currCd = null;
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
	private String invAmt = null;
	/* 而щ읆 �ㅻ챸 */
	private String slpTpCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String toInvNo = null;
	
	/* 입력자 ID */
	private String creUsrId = null;
	
	/* 수정자 ID */
	private String updUsrId = null;
	
	private String dtlSeq = null;
	
	/* SDMS No. */
	private String sdmsNo = null;
	
	/* Column Info */
	private String chtrPayRcvCd = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public CustomInvDtlVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String fletCtrtNo, String acctCd, String currCd, String invAmt, String slpTpCd, String chtrInvDt, String toInvNo, String bunkerVvd, String invDesc, String acctItmSeq, String fletIssTpCd, String invSeq, String invDtlSeq, String creUsrId, String updUsrId, String dtlSeq, String sdmsNo
	 * @return 
	 */
	public CustomInvDtlVO(String ibflag, String pagerows, String fletCtrtNo, String acctCd, String currCd, String invAmt, String slpTpCd, String chtrInvDt, String toInvNo, String bunkerVvd, String invDesc, String acctItmSeq, String fletIssTpCd, String invSeq, String invDtlSeq, String creUsrId, String updUsrId, String dtlSeq, String sdmsNo, String chtrPayRcvCd) {
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
		this.invAmt = invAmt;
		this.slpTpCd = slpTpCd;
		this.toInvNo = toInvNo;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.dtlSeq = dtlSeq;
		this.sdmsNo = sdmsNo;
		this.chtrPayRcvCd = chtrPayRcvCd;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
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
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("to_inv_no", getToInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dtl_seq", getDtlSeq());
		this.hashColumns.put("sdms_no", getSdmsNo());
		this.hashColumns.put("chtr_pay_rcv_cd", getChtrPayRcvCd());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
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
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("to_inv_no", "toInvNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dtl_seq", "dtlSeq");
		this.hashFields.put("sdms_no", "sdmsNo");
		this.hashFields.put("chtr_pay_rcv_cd", "chtrPayRcvCd");
		return this.hashFields;
	}
	
	public String getChtrInvDt() {
		return this.chtrInvDt;
	}
	public String getCurrCd() {
		return this.currCd;
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
	public String getInvAmt() {
		return this.invAmt;
	}
	public String getSlpTpCd() {
		return this.slpTpCd;
	}
	public String getToInvNo() {
		return this.toInvNo;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getDtlSeq() {
		return this.dtlSeq;
	}
	public String getSdmsNo() {
		return this.sdmsNo;
	}
	public String getChtrPayRcvCd() {
		return this.chtrPayRcvCd;
	}

	public void setChtrInvDt(String chtrInvDt) {
		this.chtrInvDt = chtrInvDt;
		//this.chtrInvDt=true;
	}
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
		//this.currCd=true;
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
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
		//this.invAmt=true;
	}
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
		//this.slpTpCd=true;
	}
	public void setToInvNo(String toInvNo) {
		this.toInvNo = toInvNo;
		//this.toInvNo=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setDtlSeq(String dtlSeq) {
		this.dtlSeq = dtlSeq;
		//this.dtlSeq=true;
	}
	public void setSdmsNo(String sdmsNo) {
		this.sdmsNo = sdmsNo;
		//this.sdmsNo=true;
	}
	public void setChtrPayRcvCd(String chtrPayRcvCd) {
		this.chtrPayRcvCd = chtrPayRcvCd;
		//this.chtrPayRcvCd=true;
	}
	public void fromRequest(HttpServletRequest request) {
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
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setToInvNo(JSPUtil.getParameter(request, "to_inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDtlSeq(JSPUtil.getParameter(request, "dtl_seq", ""));
		setSdmsNo(JSPUtil.getParameter(request, "sdms_no", ""));
		setChtrPayRcvCd(JSPUtil.getParameter(request, "chtr_pay_rcv_cd", ""));
	}

	public CustomInvDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CustomInvDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomInvDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chtrInvDt = (JSPUtil.getParameter(request, prefix	+ "chtr_inv_dt".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
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
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt".trim(), length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd".trim(), length));
			String[] toInvNo = (JSPUtil.getParameter(request, prefix	+ "to_inv_no".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] dtlSeq = (JSPUtil.getParameter(request, prefix	+ "dtl_seq".trim(), length));
			String[] sdmsNo = (JSPUtil.getParameter(request, prefix	+ "sdms_no".trim(), length));
			String[] chtrPayRcvCd = (JSPUtil.getParameter(request, prefix	+ "chtr_pay_rcv_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomInvDtlVO();
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
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (toInvNo[i] != null)
					model.setToInvNo(toInvNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dtlSeq[i] != null)
					model.setDtlSeq(dtlSeq[i]);
				if (sdmsNo[i] != null)
					model.setSdmsNo(sdmsNo[i]);
				if (chtrPayRcvCd[i] != null)
					model.setChtrPayRcvCd(chtrPayRcvCd[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCustomInvDtlVOs();
	}

	public CustomInvDtlVO[] getCustomInvDtlVOs(){
		CustomInvDtlVO[] vos = (CustomInvDtlVO[])models.toArray(new CustomInvDtlVO[models.size()]);
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
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvNo = this.toInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSeq = this.dtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdmsNo = this.sdmsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtrPayRcvCd = this.chtrPayRcvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
