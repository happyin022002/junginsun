/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchStatementOfAccountListVO.java
*@FileTitle : SearchStatementOfAccountListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.06.12 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchStatementOfAccountListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchStatementOfAccountListVO> models = new ArrayList<SearchStatementOfAccountListVO>();
	
	/* Column Info */
	private String acctDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String drAmt = null;
	/* Column Info */
	private String currCd2 = null;
	/* Column Info */
	private String acctDesc = null;
	/* Column Info */
	private String currCd1 = null;
	/* Column Info */
	private String hireNo = null;
	/* Column Info */
	private String itmNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchStatementOfAccountListVO() {}

	public SearchStatementOfAccountListVO(String ibflag, String pagerows, String itmNm, String hireNo, String acctDt, String acctDesc, String currCd1, String drAmt, String currCd2, String crAmt) {
		this.acctDt = acctDt;
		this.ibflag = ibflag;
		this.crAmt = crAmt;
		this.drAmt = drAmt;
		this.currCd2 = currCd2;
		this.acctDesc = acctDesc;
		this.currCd1 = currCd1;
		this.hireNo = hireNo;
		this.itmNm = itmNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acct_dt", getAcctDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("dr_amt", getDrAmt());
		this.hashColumns.put("curr_cd2", getCurrCd2());
		this.hashColumns.put("acct_desc", getAcctDesc());
		this.hashColumns.put("curr_cd1", getCurrCd1());
		this.hashColumns.put("hire_no", getHireNo());
		this.hashColumns.put("itm_nm", getItmNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acct_dt", "acctDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("dr_amt", "drAmt");
		this.hashFields.put("curr_cd2", "currCd2");
		this.hashFields.put("acct_desc", "acctDesc");
		this.hashFields.put("curr_cd1", "currCd1");
		this.hashFields.put("hire_no", "hireNo");
		this.hashFields.put("itm_nm", "itmNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return acctDt
	 */
	public String getAcctDt() {
		return this.acctDt;
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
	 * @return crAmt
	 */
	public String getCrAmt() {
		return this.crAmt;
	}
	
	/**
	 * Column Info
	 * @return drAmt
	 */
	public String getDrAmt() {
		return this.drAmt;
	}
	
	/**
	 * Column Info
	 * @return currCd2
	 */
	public String getCurrCd2() {
		return this.currCd2;
	}
	
	/**
	 * Column Info
	 * @return acctDesc
	 */
	public String getAcctDesc() {
		return this.acctDesc;
	}
	
	/**
	 * Column Info
	 * @return currCd1
	 */
	public String getCurrCd1() {
		return this.currCd1;
	}
	
	/**
	 * Column Info
	 * @return hireNo
	 */
	public String getHireNo() {
		return this.hireNo;
	}
	
	/**
	 * Column Info
	 * @return itmNm
	 */
	public String getItmNm() {
		return this.itmNm;
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
	 * @param acctDt
	 */
	public void setAcctDt(String acctDt) {
		this.acctDt = acctDt;
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
	 * @param crAmt
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}
	
	/**
	 * Column Info
	 * @param drAmt
	 */
	public void setDrAmt(String drAmt) {
		this.drAmt = drAmt;
	}
	
	/**
	 * Column Info
	 * @param currCd2
	 */
	public void setCurrCd2(String currCd2) {
		this.currCd2 = currCd2;
	}
	
	/**
	 * Column Info
	 * @param acctDesc
	 */
	public void setAcctDesc(String acctDesc) {
		this.acctDesc = acctDesc;
	}
	
	/**
	 * Column Info
	 * @param currCd1
	 */
	public void setCurrCd1(String currCd1) {
		this.currCd1 = currCd1;
	}
	
	/**
	 * Column Info
	 * @param hireNo
	 */
	public void setHireNo(String hireNo) {
		this.hireNo = hireNo;
	}
	
	/**
	 * Column Info
	 * @param itmNm
	 */
	public void setItmNm(String itmNm) {
		this.itmNm = itmNm;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAcctDt(JSPUtil.getParameter(request, "acct_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setDrAmt(JSPUtil.getParameter(request, "dr_amt", ""));
		setCurrCd2(JSPUtil.getParameter(request, "curr_cd2", ""));
		setAcctDesc(JSPUtil.getParameter(request, "acct_desc", ""));
		setCurrCd1(JSPUtil.getParameter(request, "curr_cd1", ""));
		setHireNo(JSPUtil.getParameter(request, "hire_no", ""));
		setItmNm(JSPUtil.getParameter(request, "itm_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchStatementOfAccountListVO[]
	 */
	public SearchStatementOfAccountListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchStatementOfAccountListVO[]
	 */
	public SearchStatementOfAccountListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchStatementOfAccountListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acctDt = (JSPUtil.getParameter(request, prefix	+ "acct_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt".trim(), length));
			String[] drAmt = (JSPUtil.getParameter(request, prefix	+ "dr_amt".trim(), length));
			String[] currCd2 = (JSPUtil.getParameter(request, prefix	+ "curr_cd2".trim(), length));
			String[] acctDesc = (JSPUtil.getParameter(request, prefix	+ "acct_desc".trim(), length));
			String[] currCd1 = (JSPUtil.getParameter(request, prefix	+ "curr_cd1".trim(), length));
			String[] hireNo = (JSPUtil.getParameter(request, prefix	+ "hire_no".trim(), length));
			String[] itmNm = (JSPUtil.getParameter(request, prefix	+ "itm_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchStatementOfAccountListVO();
				if (acctDt[i] != null)
					model.setAcctDt(acctDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (drAmt[i] != null)
					model.setDrAmt(drAmt[i]);
				if (currCd2[i] != null)
					model.setCurrCd2(currCd2[i]);
				if (acctDesc[i] != null)
					model.setAcctDesc(acctDesc[i]);
				if (currCd1[i] != null)
					model.setCurrCd1(currCd1[i]);
				if (hireNo[i] != null)
					model.setHireNo(hireNo[i]);
				if (itmNm[i] != null)
					model.setItmNm(itmNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchStatementOfAccountListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchStatementOfAccountListVO[]
	 */
	public SearchStatementOfAccountListVO[] getSearchStatementOfAccountListVOs(){
		SearchStatementOfAccountListVO[] vos = (SearchStatementOfAccountListVO[])models.toArray(new SearchStatementOfAccountListVO[models.size()]);
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
		this.acctDt = this.acctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drAmt = this.drAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd2 = this.currCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctDesc = this.acctDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd1 = this.currCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hireNo = this.hireNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNm = this.itmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
