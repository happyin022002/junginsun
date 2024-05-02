/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustExrateInputVO.java
*@FileTitle : CustExrateInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.27 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo;

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
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustExrateInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustExrateInputVO> models = new ArrayList<CustExrateInputVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String invCustCd = null;
	/* Column Info */
	private String invCntryCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lclCurr = null;
	/* Column Info */
	private String curr = null;
	/* Column Info */
	private String exRateDate = null;
	/* Column Info */
	private String bnd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustExrateInputVO() {}

	public CustExrateInputVO(String ibflag, String pagerows, String invCntryCd, String invCustCd, String bnd, String curr, String lclCurr, String ofcCd, String exRateDate) {
		this.ofcCd = ofcCd;
		this.invCustCd = invCustCd;
		this.invCntryCd = invCntryCd;
		this.ibflag = ibflag;
		this.lclCurr = lclCurr;
		this.curr = curr;
		this.exRateDate = exRateDate;
		this.bnd = bnd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("inv_cust_cd", getInvCustCd());
		this.hashColumns.put("inv_cntry_cd", getInvCntryCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lcl_curr", getLclCurr());
		this.hashColumns.put("curr", getCurr());
		this.hashColumns.put("ex_rate_date", getExRateDate());
		this.hashColumns.put("bnd", getBnd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("inv_cust_cd", "invCustCd");
		this.hashFields.put("inv_cntry_cd", "invCntryCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lcl_curr", "lclCurr");
		this.hashFields.put("curr", "curr");
		this.hashFields.put("ex_rate_date", "exRateDate");
		this.hashFields.put("bnd", "bnd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return invCustCd
	 */
	public String getInvCustCd() {
		return this.invCustCd;
	}
	
	/**
	 * Column Info
	 * @return invCntryCd
	 */
	public String getInvCntryCd() {
		return this.invCntryCd;
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
	 * @return lclCurr
	 */
	public String getLclCurr() {
		return this.lclCurr;
	}
	
	/**
	 * Column Info
	 * @return curr
	 */
	public String getCurr() {
		return this.curr;
	}
	
	/**
	 * Column Info
	 * @return exRateDate
	 */
	public String getExRateDate() {
		return this.exRateDate;
	}
	
	/**
	 * Column Info
	 * @return bnd
	 */
	public String getBnd() {
		return this.bnd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param invCustCd
	 */
	public void setInvCustCd(String invCustCd) {
		this.invCustCd = invCustCd;
	}
	
	/**
	 * Column Info
	 * @param invCntryCd
	 */
	public void setInvCntryCd(String invCntryCd) {
		this.invCntryCd = invCntryCd;
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
	 * @param lclCurr
	 */
	public void setLclCurr(String lclCurr) {
		this.lclCurr = lclCurr;
	}
	
	/**
	 * Column Info
	 * @param curr
	 */
	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	/**
	 * Column Info
	 * @param exRateDate
	 */
	public void setExRateDate(String exRateDate) {
		this.exRateDate = exRateDate;
	}
	
	/**
	 * Column Info
	 * @param bnd
	 */
	public void setBnd(String bnd) {
		this.bnd = bnd;
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
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setInvCustCd(JSPUtil.getParameter(request, "inv_cust_cd", ""));
		setInvCntryCd(JSPUtil.getParameter(request, "inv_cntry_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLclCurr(JSPUtil.getParameter(request, "lcl_curr", ""));
		setCurr(JSPUtil.getParameter(request, "curr", ""));
		setExRateDate(JSPUtil.getParameter(request, "ex_rate_date", ""));
		setBnd(JSPUtil.getParameter(request, "bnd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustExrateInputVO[]
	 */
	public CustExrateInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustExrateInputVO[]
	 */
	public CustExrateInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustExrateInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] invCustCd = (JSPUtil.getParameter(request, prefix	+ "inv_cust_cd".trim(), length));
			String[] invCntryCd = (JSPUtil.getParameter(request, prefix	+ "inv_cntry_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] lclCurr = (JSPUtil.getParameter(request, prefix	+ "lcl_curr".trim(), length));
			String[] curr = (JSPUtil.getParameter(request, prefix	+ "curr".trim(), length));
			String[] exRateDate = (JSPUtil.getParameter(request, prefix	+ "ex_rate_date".trim(), length));
			String[] bnd = (JSPUtil.getParameter(request, prefix	+ "bnd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustExrateInputVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (invCustCd[i] != null)
					model.setInvCustCd(invCustCd[i]);
				if (invCntryCd[i] != null)
					model.setInvCntryCd(invCntryCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lclCurr[i] != null)
					model.setLclCurr(lclCurr[i]);
				if (curr[i] != null)
					model.setCurr(curr[i]);
				if (exRateDate[i] != null)
					model.setExRateDate(exRateDate[i]);
				if (bnd[i] != null)
					model.setBnd(bnd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustExrateInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustExrateInputVO[]
	 */
	public CustExrateInputVO[] getCustExrateInputVOs(){
		CustExrateInputVO[] vos = (CustExrateInputVO[])models.toArray(new CustExrateInputVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCd = this.invCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCntryCd = this.invCntryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclCurr = this.lclCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curr = this.curr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRateDate = this.exRateDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnd = this.bnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
