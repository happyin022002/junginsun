/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceInterfaceARParmVO.java
*@FileTitle : InvoiceInterfaceARParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.13 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceInterfaceARParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceInterfaceARParmVO> models = new ArrayList<InvoiceInterfaceARParmVO>();
	
	/* Column Info */
	private String chkHold = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String condType = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String shCustNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String shInvCurrCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String shCustCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceInterfaceARParmVO() {}

	public InvoiceInterfaceARParmVO(String ibflag, String pagerows, String ofcCd, String dmdtTrfCd, String chkHold, String fmDt, String toDt, String invNo, String bkgNo, String blNo, String custCd, String condType, String shCustCd, String shCustNm, String shInvCurrCd) {
		this.chkHold = chkHold;
		this.fmDt = fmDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.invNo = invNo;
		this.condType = condType;
		this.ofcCd = ofcCd;
		this.shCustNm = shCustNm;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.shInvCurrCd = shInvCurrCd;
		this.custCd = custCd;
		this.shCustCd = shCustCd;
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chk_hold", getChkHold());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cond_type", getCondType());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("sh_cust_nm", getShCustNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sh_inv_curr_cd", getShInvCurrCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("sh_cust_cd", getShCustCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chk_hold", "chkHold");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cond_type", "condType");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("sh_cust_nm", "shCustNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sh_inv_curr_cd", "shInvCurrCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("sh_cust_cd", "shCustCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chkHold
	 */
	public String getChkHold() {
		return this.chkHold;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return condType
	 */
	public String getCondType() {
		return this.condType;
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
	 * @return shCustNm
	 */
	public String getShCustNm() {
		return this.shCustNm;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return shInvCurrCd
	 */
	public String getShInvCurrCd() {
		return this.shInvCurrCd;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return shCustCd
	 */
	public String getShCustCd() {
		return this.shCustCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	

	/**
	 * Column Info
	 * @param chkHold
	 */
	public void setChkHold(String chkHold) {
		this.chkHold = chkHold;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param condType
	 */
	public void setCondType(String condType) {
		this.condType = condType;
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
	 * @param shCustNm
	 */
	public void setShCustNm(String shCustNm) {
		this.shCustNm = shCustNm;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param shInvCurrCd
	 */
	public void setShInvCurrCd(String shInvCurrCd) {
		this.shInvCurrCd = shInvCurrCd;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param shCustCd
	 */
	public void setShCustCd(String shCustCd) {
		this.shCustCd = shCustCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setChkHold(JSPUtil.getParameter(request, "chk_hold", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setCondType(JSPUtil.getParameter(request, "cond_type", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setShCustNm(JSPUtil.getParameter(request, "sh_cust_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setShInvCurrCd(JSPUtil.getParameter(request, "sh_inv_curr_cd", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setShCustCd(JSPUtil.getParameter(request, "sh_cust_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceInterfaceARParmVO[]
	 */
	public InvoiceInterfaceARParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceInterfaceARParmVO[]
	 */
	public InvoiceInterfaceARParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceInterfaceARParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chkHold = (JSPUtil.getParameter(request, prefix	+ "chk_hold", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] condType = (JSPUtil.getParameter(request, prefix	+ "cond_type", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] shCustNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] shInvCurrCd = (JSPUtil.getParameter(request, prefix	+ "sh_inv_curr_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] shCustCd = (JSPUtil.getParameter(request, prefix	+ "sh_cust_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceInterfaceARParmVO();
				if (chkHold[i] != null)
					model.setChkHold(chkHold[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (condType[i] != null)
					model.setCondType(condType[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (shCustNm[i] != null)
					model.setShCustNm(shCustNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (shInvCurrCd[i] != null)
					model.setShInvCurrCd(shInvCurrCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (shCustCd[i] != null)
					model.setShCustCd(shCustCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceInterfaceARParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceInterfaceARParmVO[]
	 */
	public InvoiceInterfaceARParmVO[] getInvoiceInterfaceARParmVOs(){
		InvoiceInterfaceARParmVO[] vos = (InvoiceInterfaceARParmVO[])models.toArray(new InvoiceInterfaceARParmVO[models.size()]);
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
		this.chkHold = this.chkHold .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condType = this.condType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustNm = this.shCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shInvCurrCd = this.shInvCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustCd = this.shCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
