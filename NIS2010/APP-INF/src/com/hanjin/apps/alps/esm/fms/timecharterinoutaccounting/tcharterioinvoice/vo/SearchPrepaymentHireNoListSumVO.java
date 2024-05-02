/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchPrepaymentHireNoListSumVO.java
*@FileTitle : SearchPrepaymentHireNoListSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.26 정윤태 
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

public class SearchPrepaymentHireNoListSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPrepaymentHireNoListSumVO> models = new ArrayList<SearchPrepaymentHireNoListSumVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String currCd2 = null;
	/* Column Info */
	private String invAmt2 = null;
	/* Column Info */
	private String invAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchPrepaymentHireNoListSumVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String currCd, String invAmt, String currCd2, String invAmt2
	 * @return 
	 */
	public SearchPrepaymentHireNoListSumVO(String ibflag, String pagerows, String currCd, String invAmt, String currCd2, String invAmt2) {
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.currCd2 = currCd2;
		this.invAmt2 = invAmt2;
		this.invAmt = invAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("curr_cd2", getCurrCd2());
		this.hashColumns.put("inv_amt2", getInvAmt2());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("curr_cd2", "currCd2");
		this.hashFields.put("inv_amt2", "invAmt2");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCurrCd2(JSPUtil.getParameter(request, "curr_cd2", ""));
		setInvAmt2(JSPUtil.getParameter(request, "inv_amt2", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPrepaymentHireNoListSumVO[]
	 */
	public SearchPrepaymentHireNoListSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPrepaymentHireNoListSumVO[]
	 */
	public SearchPrepaymentHireNoListSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPrepaymentHireNoListSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] currCd2 = (JSPUtil.getParameter(request, prefix	+ "curr_cd2".trim(), length));
			String[] invAmt2 = (JSPUtil.getParameter(request, prefix	+ "inv_amt2".trim(), length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPrepaymentHireNoListSumVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (currCd2[i] != null)
					model.setCurrCd2(currCd2[i]);
				if (invAmt2[i] != null)
					model.setInvAmt2(invAmt2[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPrepaymentHireNoListSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPrepaymentHireNoListSumVO[]
	 */
	public SearchPrepaymentHireNoListSumVO[] getSearchPrepaymentHireNoListSumVOs(){
		SearchPrepaymentHireNoListSumVO[] vos = (SearchPrepaymentHireNoListSumVO[])models.toArray(new SearchPrepaymentHireNoListSumVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd2 = this.currCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt2 = this.invAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
