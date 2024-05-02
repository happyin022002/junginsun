/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomTaxDtlVO.java
*@FileTitle : CustomTaxDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.31 정윤태 
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
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomTaxDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomTaxDtlVO> models = new ArrayList<CustomTaxDtlVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String taxDtlSerNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String taxSerNo = null;
	/* Column Info */
	private String taxInvYrmon = null;
	/* Column Info */
	private String splAmt = null;
	/* Column Info */
	private String totalAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String itmNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomTaxDtlVO() {}

	public CustomTaxDtlVO(String ibflag, String pagerows, String taxInvYrmon, String ofcCd, String taxSerNo, String taxDtlSerNo, String itmNm, String splAmt, String taxAmt, String totalAmt, String creUsrId, String updUsrId) {
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.taxDtlSerNo = taxDtlSerNo;
		this.ibflag = ibflag;
		this.taxAmt = taxAmt;
		this.taxSerNo = taxSerNo;
		this.taxInvYrmon = taxInvYrmon;
		this.splAmt = splAmt;
		this.totalAmt = totalAmt;
		this.updUsrId = updUsrId;
		this.itmNm = itmNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("tax_dtl_ser_no", getTaxDtlSerNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("tax_ser_no", getTaxSerNo());
		this.hashColumns.put("tax_inv_yrmon", getTaxInvYrmon());
		this.hashColumns.put("spl_amt", getSplAmt());
		this.hashColumns.put("total_amt", getTotalAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("itm_nm", getItmNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("tax_dtl_ser_no", "taxDtlSerNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("tax_ser_no", "taxSerNo");
		this.hashFields.put("tax_inv_yrmon", "taxInvYrmon");
		this.hashFields.put("spl_amt", "splAmt");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("itm_nm", "itmNm");
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return taxDtlSerNo
	 */
	public String getTaxDtlSerNo() {
		return this.taxDtlSerNo;
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
	 * @return taxAmt
	 */
	public String getTaxAmt() {
		return this.taxAmt;
	}
	
	/**
	 * Column Info
	 * @return taxSerNo
	 */
	public String getTaxSerNo() {
		return this.taxSerNo;
	}
	
	/**
	 * Column Info
	 * @return taxInvYrmon
	 */
	public String getTaxInvYrmon() {
		return this.taxInvYrmon;
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
	 * @return totalAmt
	 */
	public String getTotalAmt() {
		return this.totalAmt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param taxDtlSerNo
	 */
	public void setTaxDtlSerNo(String taxDtlSerNo) {
		this.taxDtlSerNo = taxDtlSerNo;
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
	 * @param taxAmt
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}
	
	/**
	 * Column Info
	 * @param taxSerNo
	 */
	public void setTaxSerNo(String taxSerNo) {
		this.taxSerNo = taxSerNo;
	}
	
	/**
	 * Column Info
	 * @param taxInvYrmon
	 */
	public void setTaxInvYrmon(String taxInvYrmon) {
		this.taxInvYrmon = taxInvYrmon;
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
	 * @param totalAmt
	 */
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setTaxDtlSerNo(JSPUtil.getParameter(request, "tax_dtl_ser_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTaxAmt(JSPUtil.getParameter(request, "tax_amt", ""));
		setTaxSerNo(JSPUtil.getParameter(request, "tax_ser_no", ""));
		setTaxInvYrmon(JSPUtil.getParameter(request, "tax_inv_yrmon", ""));
		setSplAmt(JSPUtil.getParameter(request, "spl_amt", ""));
		setTotalAmt(JSPUtil.getParameter(request, "total_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setItmNm(JSPUtil.getParameter(request, "itm_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomTaxDtlVO[]
	 */
	public CustomTaxDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomTaxDtlVO[]
	 */
	public CustomTaxDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomTaxDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] taxDtlSerNo = (JSPUtil.getParameter(request, prefix	+ "tax_dtl_ser_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] taxSerNo = (JSPUtil.getParameter(request, prefix	+ "tax_ser_no", length));
			String[] taxInvYrmon = (JSPUtil.getParameter(request, prefix	+ "tax_inv_yrmon", length));
			String[] splAmt = (JSPUtil.getParameter(request, prefix	+ "spl_amt", length));
			String[] totalAmt = (JSPUtil.getParameter(request, prefix	+ "total_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] itmNm = (JSPUtil.getParameter(request, prefix	+ "itm_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomTaxDtlVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (taxDtlSerNo[i] != null)
					model.setTaxDtlSerNo(taxDtlSerNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (taxSerNo[i] != null)
					model.setTaxSerNo(taxSerNo[i]);
				if (taxInvYrmon[i] != null)
					model.setTaxInvYrmon(taxInvYrmon[i]);
				if (splAmt[i] != null)
					model.setSplAmt(splAmt[i]);
				if (totalAmt[i] != null)
					model.setTotalAmt(totalAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (itmNm[i] != null)
					model.setItmNm(itmNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomTaxDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomTaxDtlVO[]
	 */
	public CustomTaxDtlVO[] getCustomTaxDtlVOs(){
		CustomTaxDtlVO[] vos = (CustomTaxDtlVO[])models.toArray(new CustomTaxDtlVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxDtlSerNo = this.taxDtlSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxSerNo = this.taxSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvYrmon = this.taxInvYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splAmt = this.splAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt = this.totalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNm = this.itmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
