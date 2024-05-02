/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAccrualAccountCodeVO.java
*@FileTitle : SearchAccrualAccountCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.28 전재홍 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo;

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
 * @author 전재홍
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAccrualAccountCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccrualAccountCodeVO> models = new ArrayList<SearchAccrualAccountCodeVO>();
	
	/* Column Info */
	private String mnCostTpCd = null;
	/* Column Info */
	private String acctNm = null;
	/* Column Info */
	private String repAcctCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String subCostTpCd = null;
	/* Column Info */
	private String subCostTpNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAccrualAccountCodeVO() {}

	public SearchAccrualAccountCodeVO(String ibflag, String pagerows, String acctCd, String repAcctCd, String mnCostTpCd, String subCostTpCd, String subCostTpNm, String acctNm) {
		this.mnCostTpCd = mnCostTpCd;
		this.acctNm = acctNm;
		this.repAcctCd = repAcctCd;
		this.ibflag = ibflag;
		this.acctCd = acctCd;
		this.subCostTpCd = subCostTpCd;
		this.subCostTpNm = subCostTpNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mn_cost_tp_cd", getMnCostTpCd());
		this.hashColumns.put("acct_nm", getAcctNm());
		this.hashColumns.put("rep_acct_cd", getRepAcctCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("sub_cost_tp_cd", getSubCostTpCd());
		this.hashColumns.put("sub_cost_tp_nm", getSubCostTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mn_cost_tp_cd", "mnCostTpCd");
		this.hashFields.put("acct_nm", "acctNm");
		this.hashFields.put("rep_acct_cd", "repAcctCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("sub_cost_tp_cd", "subCostTpCd");
		this.hashFields.put("sub_cost_tp_nm", "subCostTpNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnCostTpCd
	 */
	public String getMnCostTpCd() {
		return this.mnCostTpCd;
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
	 * @return repAcctCd
	 */
	public String getRepAcctCd() {
		return this.repAcctCd;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return subCostTpCd
	 */
	public String getSubCostTpCd() {
		return this.subCostTpCd;
	}
	
	/**
	 * Column Info
	 * @return subCostTpNm
	 */
	public String getSubCostTpNm() {
		return this.subCostTpNm;
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
	 * @param mnCostTpCd
	 */
	public void setMnCostTpCd(String mnCostTpCd) {
		this.mnCostTpCd = mnCostTpCd;
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
	 * @param repAcctCd
	 */
	public void setRepAcctCd(String repAcctCd) {
		this.repAcctCd = repAcctCd;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param subCostTpCd
	 */
	public void setSubCostTpCd(String subCostTpCd) {
		this.subCostTpCd = subCostTpCd;
	}
	
	/**
	 * Column Info
	 * @param subCostTpNm
	 */
	public void setSubCostTpNm(String subCostTpNm) {
		this.subCostTpNm = subCostTpNm;
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
		setMnCostTpCd(JSPUtil.getParameter(request, "mn_cost_tp_cd", ""));
		setAcctNm(JSPUtil.getParameter(request, "acct_nm", ""));
		setRepAcctCd(JSPUtil.getParameter(request, "rep_acct_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setSubCostTpCd(JSPUtil.getParameter(request, "sub_cost_tp_cd", ""));
		setSubCostTpNm(JSPUtil.getParameter(request, "sub_cost_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAccrualAccountCodeVO[]
	 */
	public SearchAccrualAccountCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAccrualAccountCodeVO[]
	 */
	public SearchAccrualAccountCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAccrualAccountCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnCostTpCd = (JSPUtil.getParameter(request, prefix	+ "mn_cost_tp_cd", length));
			String[] acctNm = (JSPUtil.getParameter(request, prefix	+ "acct_nm", length));
			String[] repAcctCd = (JSPUtil.getParameter(request, prefix	+ "rep_acct_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] subCostTpCd = (JSPUtil.getParameter(request, prefix	+ "sub_cost_tp_cd", length));
			String[] subCostTpNm = (JSPUtil.getParameter(request, prefix	+ "sub_cost_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccrualAccountCodeVO();
				if (mnCostTpCd[i] != null)
					model.setMnCostTpCd(mnCostTpCd[i]);
				if (acctNm[i] != null)
					model.setAcctNm(acctNm[i]);
				if (repAcctCd[i] != null)
					model.setRepAcctCd(repAcctCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (subCostTpCd[i] != null)
					model.setSubCostTpCd(subCostTpCd[i]);
				if (subCostTpNm[i] != null)
					model.setSubCostTpNm(subCostTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAccrualAccountCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAccrualAccountCodeVO[]
	 */
	public SearchAccrualAccountCodeVO[] getSearchAccrualAccountCodeVOs(){
		SearchAccrualAccountCodeVO[] vos = (SearchAccrualAccountCodeVO[])models.toArray(new SearchAccrualAccountCodeVO[models.size()]);
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
		this.mnCostTpCd = this.mnCostTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctNm = this.acctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repAcctCd = this.repAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subCostTpCd = this.subCostTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subCostTpNm = this.subCostTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
