/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSlipApprovalBillVO.java
*@FileTitle : SearchSlipApprovalBillVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.09.03 윤세영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

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
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSlipApprovalBillVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSlipApprovalBillVO> models = new ArrayList<SearchSlipApprovalBillVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String issDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String billNo = null;
	/* Column Info */
	private String splAmt = null;
	/* Column Info */
	private String splRgstNo = null;
	/* Column Info */
	private String coNm = null;
	/* Column Info */
	private String issDtTime = null;
	/* Column Info */
	private String taxCode = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSlipApprovalBillVO() {}

	public SearchSlipApprovalBillVO(String ibflag, String pagerows, String issDt, String splRgstNo, String ofcCd, String billNo, String splAmt, String taxAmt, String currCd, String taxCode, String coNm, String issDtTime) {
		this.ofcCd = ofcCd;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.taxAmt = taxAmt;
		this.billNo = billNo;
		this.splAmt = splAmt;
		this.splRgstNo = splRgstNo;
		this.coNm = coNm;
		this.issDtTime = issDtTime;
		this.taxCode = taxCode;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("bill_no", getBillNo());
		this.hashColumns.put("spl_amt", getSplAmt());
		this.hashColumns.put("spl_rgst_no", getSplRgstNo());
		this.hashColumns.put("co_nm", getCoNm());
		this.hashColumns.put("iss_dt_time", getIssDtTime());
		this.hashColumns.put("tax_code", getTaxCode());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("bill_no", "billNo");
		this.hashFields.put("spl_amt", "splAmt");
		this.hashFields.put("spl_rgst_no", "splRgstNo");
		this.hashFields.put("co_nm", "coNm");
		this.hashFields.put("iss_dt_time", "issDtTime");
		this.hashFields.put("tax_code", "taxCode");
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
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return taxAmt
	 */
	public String getTaxAmt() {
		return this.taxAmt;
	}
	
	/**
	 * Column Info
	 * @return billNo
	 */
	public String getBillNo() {
		return this.billNo;
	}
	
	/**
	 * Column Info
	 * @return splAmt
	 */
	public String getSplAmt() {
		return this.splAmt;
	}
	
	/**
	 * Column Info
	 * @return splRgstNo
	 */
	public String getSplRgstNo() {
		return this.splRgstNo;
	}
	
	/**
	 * Column Info
	 * @return coNm
	 */
	public String getCoNm() {
		return this.coNm;
	}
	
	/**
	 * Column Info
	 * @return issDtTime
	 */
	public String getIssDtTime() {
		return this.issDtTime;
	}
	
	/**
	 * Column Info
	 * @return taxCode
	 */
	public String getTaxCode() {
		return this.taxCode;
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
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param taxAmt
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}
	
	/**
	 * Column Info
	 * @param billNo
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	
	/**
	 * Column Info
	 * @param splAmt
	 */
	public void setSplAmt(String splAmt) {
		this.splAmt = splAmt;
	}
	
	/**
	 * Column Info
	 * @param splRgstNo
	 */
	public void setSplRgstNo(String splRgstNo) {
		this.splRgstNo = splRgstNo;
	}
	
	/**
	 * Column Info
	 * @param coNm
	 */
	public void setCoNm(String coNm) {
		this.coNm = coNm;
	}
	
	/**
	 * Column Info
	 * @param issDtTime
	 */
	public void setIssDtTime(String issDtTime) {
		this.issDtTime = issDtTime;
	}
	
	/**
	 * Column Info
	 * @param taxCode
	 */
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
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
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setTaxAmt(JSPUtil.getParameter(request, "tax_amt", ""));
		setBillNo(JSPUtil.getParameter(request, "bill_no", ""));
		setSplAmt(JSPUtil.getParameter(request, "spl_amt", ""));
		setSplRgstNo(JSPUtil.getParameter(request, "spl_rgst_no", ""));
		setCoNm(JSPUtil.getParameter(request, "co_nm", ""));
		setIssDtTime(JSPUtil.getParameter(request, "iss_dt_time", ""));
		setTaxCode(JSPUtil.getParameter(request, "tax_code", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSlipApprovalBillVO[]
	 */
	public SearchSlipApprovalBillVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSlipApprovalBillVO[]
	 */
	public SearchSlipApprovalBillVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSlipApprovalBillVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] billNo = (JSPUtil.getParameter(request, prefix	+ "bill_no", length));
			String[] splAmt = (JSPUtil.getParameter(request, prefix	+ "spl_amt", length));
			String[] splRgstNo = (JSPUtil.getParameter(request, prefix	+ "spl_rgst_no", length));
			String[] coNm = (JSPUtil.getParameter(request, prefix	+ "co_nm", length));
			String[] issDtTime = (JSPUtil.getParameter(request, prefix	+ "iss_dt_time", length));
			String[] taxCode = (JSPUtil.getParameter(request, prefix	+ "tax_code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSlipApprovalBillVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (billNo[i] != null)
					model.setBillNo(billNo[i]);
				if (splAmt[i] != null)
					model.setSplAmt(splAmt[i]);
				if (splRgstNo[i] != null)
					model.setSplRgstNo(splRgstNo[i]);
				if (coNm[i] != null)
					model.setCoNm(coNm[i]);
				if (issDtTime[i] != null)
					model.setIssDtTime(issDtTime[i]);
				if (taxCode[i] != null)
					model.setTaxCode(taxCode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSlipApprovalBillVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSlipApprovalBillVO[]
	 */
	public SearchSlipApprovalBillVO[] getSearchSlipApprovalBillVOs(){
		SearchSlipApprovalBillVO[] vos = (SearchSlipApprovalBillVO[])models.toArray(new SearchSlipApprovalBillVO[models.size()]);
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
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billNo = this.billNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splAmt = this.splAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splRgstNo = this.splRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coNm = this.coNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDtTime = this.issDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxCode = this.taxCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
