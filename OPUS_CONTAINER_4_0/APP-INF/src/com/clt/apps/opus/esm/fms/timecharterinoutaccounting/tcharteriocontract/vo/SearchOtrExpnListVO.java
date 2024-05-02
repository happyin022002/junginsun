/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOtrExpnListVO.java
*@FileTitle : SearchOtrExpnListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.23 정윤태
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo;

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
 * @see ESM_FMS_0001HTMLAction
 */
 
public class SearchOtrExpnListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOtrExpnListVO> models = new ArrayList<SearchOtrExpnListVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String acctItmNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String currCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String oriExpDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String oriAcctCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String oriEffDt = null;
	/* Page Number */
	private String pagerows = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletCtrtNo = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctItmSeq = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String effDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String oriAcctItmSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String expDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String otrExpnAmt = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchOtrExpnListVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String fletCtrtNo, String acctItmNm, String acctCd, String acctItmSeq, String oriAcctCd, String oriAcctItmSeq, String effDt, String expDt, String oriEffDt, String oriExpDt, String currCd, String otrExpnAmt
	 * @return 
	 */
	public SearchOtrExpnListVO(String ibflag, String pagerows, String fletCtrtNo, String acctItmNm, String acctCd, String acctItmSeq, String oriAcctCd, String oriAcctItmSeq, String effDt, String expDt, String oriEffDt, String oriExpDt, String currCd, String otrExpnAmt) {
		this.acctItmNm = acctItmNm;
		this.currCd = currCd;
		this.oriExpDt = oriExpDt;
		this.oriAcctCd = oriAcctCd;
		this.oriEffDt = oriEffDt;
		this.pagerows = pagerows;
		this.fletCtrtNo = fletCtrtNo;
		this.acctItmSeq = acctItmSeq;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.acctCd = acctCd;
		this.oriAcctItmSeq = oriAcctItmSeq;
		this.expDt = expDt;
		this.otrExpnAmt = otrExpnAmt;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acct_itm_nm", getAcctItmNm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ori_exp_dt", getOriExpDt());
		this.hashColumns.put("ori_acct_cd", getOriAcctCd());
		this.hashColumns.put("ori_eff_dt", getOriEffDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("acct_itm_seq", getAcctItmSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("ori_acct_itm_seq", getOriAcctItmSeq());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("otr_expn_amt", getOtrExpnAmt());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acct_itm_nm", "acctItmNm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ori_exp_dt", "oriExpDt");
		this.hashFields.put("ori_acct_cd", "oriAcctCd");
		this.hashFields.put("ori_eff_dt", "oriEffDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("acct_itm_seq", "acctItmSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("ori_acct_itm_seq", "oriAcctItmSeq");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("otr_expn_amt", "otrExpnAmt");
		return this.hashFields;
	}
	
	public String getAcctItmNm() {
		return this.acctItmNm;
	}
	public String getCurrCd() {
		return this.currCd;
	}
	public String getOriExpDt() {
		return this.oriExpDt;
	}
	public String getOriAcctCd() {
		return this.oriAcctCd;
	}
	public String getOriEffDt() {
		return this.oriEffDt;
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
	public String getEffDt() {
		return this.effDt;
	}
	public String getAcctCd() {
		return this.acctCd;
	}
	public String getOriAcctItmSeq() {
		return this.oriAcctItmSeq;
	}
	public String getExpDt() {
		return this.expDt;
	}
	public String getOtrExpnAmt() {
		return this.otrExpnAmt;
	}

	public void setAcctItmNm(String acctItmNm) {
		this.acctItmNm = acctItmNm;
		//this.acctItmNm=true;
	}
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
		//this.currCd=true;
	}
	public void setOriExpDt(String oriExpDt) {
		this.oriExpDt = oriExpDt;
		//this.oriExpDt=true;
	}
	public void setOriAcctCd(String oriAcctCd) {
		this.oriAcctCd = oriAcctCd;
		//this.oriAcctCd=true;
	}
	public void setOriEffDt(String oriEffDt) {
		this.oriEffDt = oriEffDt;
		//this.oriEffDt=true;
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
	public void setEffDt(String effDt) {
		this.effDt = effDt;
		//this.effDt=true;
	}
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
		//this.acctCd=true;
	}
	public void setOriAcctItmSeq(String oriAcctItmSeq) {
		this.oriAcctItmSeq = oriAcctItmSeq;
		//this.oriAcctItmSeq=true;
	}
	public void setExpDt(String expDt) {
		this.expDt = expDt;
		//this.expDt=true;
	}
	public void setOtrExpnAmt(String otrExpnAmt) {
		this.otrExpnAmt = otrExpnAmt;
		//this.otrExpnAmt=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setAcctItmNm(JSPUtil.getParameter(request, "acct_itm_nm", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setOriExpDt(JSPUtil.getParameter(request, "ori_exp_dt", ""));
		setOriAcctCd(JSPUtil.getParameter(request, "ori_acct_cd", ""));
		setOriEffDt(JSPUtil.getParameter(request, "ori_eff_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setAcctItmSeq(JSPUtil.getParameter(request, "acct_itm_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setOriAcctItmSeq(JSPUtil.getParameter(request, "ori_acct_itm_seq", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setOtrExpnAmt(JSPUtil.getParameter(request, "otr_expn_amt", ""));
	}

	public SearchOtrExpnListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchOtrExpnListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOtrExpnListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acctItmNm = (JSPUtil.getParameter(request, prefix	+ "acct_itm_nm".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] oriExpDt = (JSPUtil.getParameter(request, prefix	+ "ori_exp_dt".trim(), length));
			String[] oriAcctCd = (JSPUtil.getParameter(request, prefix	+ "ori_acct_cd".trim(), length));
			String[] oriEffDt = (JSPUtil.getParameter(request, prefix	+ "ori_eff_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] acctItmSeq = (JSPUtil.getParameter(request, prefix	+ "acct_itm_seq".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd".trim(), length));
			String[] oriAcctItmSeq = (JSPUtil.getParameter(request, prefix	+ "ori_acct_itm_seq".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] otrExpnAmt = (JSPUtil.getParameter(request, prefix	+ "otr_expn_amt".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOtrExpnListVO();
				if (acctItmNm[i] != null)
					model.setAcctItmNm(acctItmNm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (oriExpDt[i] != null)
					model.setOriExpDt(oriExpDt[i]);
				if (oriAcctCd[i] != null)
					model.setOriAcctCd(oriAcctCd[i]);
				if (oriEffDt[i] != null)
					model.setOriEffDt(oriEffDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (acctItmSeq[i] != null)
					model.setAcctItmSeq(acctItmSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (oriAcctItmSeq[i] != null)
					model.setOriAcctItmSeq(oriAcctItmSeq[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (otrExpnAmt[i] != null)
					model.setOtrExpnAmt(otrExpnAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchOtrExpnListVOs();
	}

	public SearchOtrExpnListVO[] getSearchOtrExpnListVOs(){
		SearchOtrExpnListVO[] vos = (SearchOtrExpnListVO[])models.toArray(new SearchOtrExpnListVO[models.size()]);
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
		this.oriExpDt = this.oriExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriAcctCd = this.oriAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriEffDt = this.oriEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmSeq = this.acctItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriAcctItmSeq = this.oriAcctItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrExpnAmt = this.otrExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
