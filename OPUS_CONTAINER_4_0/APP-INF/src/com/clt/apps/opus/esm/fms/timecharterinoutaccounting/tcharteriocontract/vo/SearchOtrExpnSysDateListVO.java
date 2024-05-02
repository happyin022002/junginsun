/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOtrExpnSysDateListVO.java
*@FileTitle : SearchOtrExpnSysDateListVO
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
 
public class SearchOtrExpnSysDateListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOtrExpnSysDateListVO> models = new ArrayList<SearchOtrExpnSysDateListVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String acctItmNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String effDt = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String currCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String expDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String otrExpnAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchOtrExpnSysDateListVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String acctItmNm, String effDt, String expDt, String currCd, String otrExpnAmt
	 * @return 
	 */
	public SearchOtrExpnSysDateListVO(String ibflag, String pagerows, String acctItmNm, String effDt, String expDt, String currCd, String otrExpnAmt) {
		this.acctItmNm = acctItmNm;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.expDt = expDt;
		this.otrExpnAmt = otrExpnAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acct_itm_nm", getAcctItmNm());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("otr_expn_amt", getOtrExpnAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acct_itm_nm", "acctItmNm");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("otr_expn_amt", "otrExpnAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getAcctItmNm() {
		return this.acctItmNm;
	}
	public String getEffDt() {
		return this.effDt;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getCurrCd() {
		return this.currCd;
	}
	public String getExpDt() {
		return this.expDt;
	}
	public String getOtrExpnAmt() {
		return this.otrExpnAmt;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setAcctItmNm(String acctItmNm) {
		this.acctItmNm = acctItmNm;
		//this.acctItmNm=true;
	}
	public void setEffDt(String effDt) {
		this.effDt = effDt;
		//this.effDt=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
		//this.currCd=true;
	}
	public void setExpDt(String expDt) {
		this.expDt = expDt;
		//this.expDt=true;
	}
	public void setOtrExpnAmt(String otrExpnAmt) {
		this.otrExpnAmt = otrExpnAmt;
		//this.otrExpnAmt=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setAcctItmNm(JSPUtil.getParameter(request, "acct_itm_nm", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setOtrExpnAmt(JSPUtil.getParameter(request, "otr_expn_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchOtrExpnSysDateListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchOtrExpnSysDateListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOtrExpnSysDateListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acctItmNm = (JSPUtil.getParameter(request, prefix	+ "acct_itm_nm".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] otrExpnAmt = (JSPUtil.getParameter(request, prefix	+ "otr_expn_amt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOtrExpnSysDateListVO();
				if (acctItmNm[i] != null)
					model.setAcctItmNm(acctItmNm[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (otrExpnAmt[i] != null)
					model.setOtrExpnAmt(otrExpnAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchOtrExpnSysDateListVOs();
	}

	public SearchOtrExpnSysDateListVO[] getSearchOtrExpnSysDateListVOs(){
		SearchOtrExpnSysDateListVO[] vos = (SearchOtrExpnSysDateListVO[])models.toArray(new SearchOtrExpnSysDateListVO[models.size()]);
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
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrExpnAmt = this.otrExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
