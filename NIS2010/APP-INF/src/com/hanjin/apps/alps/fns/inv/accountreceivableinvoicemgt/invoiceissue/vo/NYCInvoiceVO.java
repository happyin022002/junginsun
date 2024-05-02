/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NYCInvoiceVO.java
*@FileTitle : NYCInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2014.08.27 최도순
* 1.0 Creation
* --------------------------------------------------------
* History
* 2014.08.26 최도순 [CHM-201431413] 미주지역 Inv Issue 프로그램 개발 요청
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

/**
 * @author c9014800
 *
 */
public class NYCInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NYCInvoiceVO> models = new ArrayList<NYCInvoiceVO>();
	
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String custEml = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custFaxNo = null;
	/* Column Info */
	private String sendFlg = null;
	/* Column Info */
	private String emailSubject = null;
	/* Column Info */
	private String emailFileName = null;
	/* Column Info */
	private String emailContent = null;
	/* Column Info */
	private String custCode = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String ttlAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	
	public NYCInvoiceVO() {}

	public NYCInvoiceVO(String ibflag, String pagerows, String arOfcCd, String emailContent, String dueDt, String blSrcNo, String bkgNo, String sailArrDt, String custFaxNo, String custEml,  String sendFlg, String emailSubject, String emailFileName, String custCode, String custNm, String crAmt, String ttlAmt) {
		this.blSrcNo = blSrcNo;
		this.bkgNo = bkgNo;
		this.sailArrDt = sailArrDt;
		this.dueDt = dueDt;
		this.emailContent = emailContent;
		this.custEml = custEml;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.custFaxNo = custFaxNo;
		this.sendFlg = sendFlg;
		this.emailSubject = emailSubject;
		this.emailFileName = emailFileName;
		this.custCode = custCode;
		this.custNm = custNm;
		this.crAmt = crAmt;
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("email_content", getEmailContent());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_fax_no", getCustFaxNo());
		this.hashColumns.put("send_flg", getSendFlg());
		this.hashColumns.put("email_subject", getEmailSubject());
		this.hashColumns.put("email_file_name", getEmailFileName());
		this.hashColumns.put("cust_code", getCustCode());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("email_content", "emailContent");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_fax_no", "custFaxNo");
		this.hashFields.put("send_flg", "sendFlg");
		this.hashFields.put("email_subject", "emailSubject");
		this.hashFields.put("email_file_name", "emailFileName");
		this.hashFields.put("cust_code", "custCode");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("ttl_amt", "ttlAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
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
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return emailContent
	 */
	public String getEmailContent() {
		return this.emailContent;
	}
	
	/**
	 * Column Info
	 * @return custEml
	 */
	public String getCustEml() {
		return this.custEml;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	
	/**
	 * Column Info
	 * @return custFaxNo
	 */
	public String getCustFaxNo() {
		return this.custFaxNo;
	}
	

	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
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
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param emailContent
	 */
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}
	
	
	/**
	 * Column Info
	 * @param custEml
	 */
	public void setCustEml(String custEml) {
		this.custEml = custEml;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param custFaxNo
	 */
	public void setCustFaxNo(String custFaxNo) {
		this.custFaxNo = custFaxNo;
	}
	
	
	public String getSendFlg() {
		return sendFlg;
	}

	public void setSendFlg(String sendFlg) {
		this.sendFlg = sendFlg;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailFileName() {
		return emailFileName;
	}

	public void setEmailFileName(String emailFileName) {
		this.emailFileName = emailFileName;
	}
	
	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}


	public String getCustNm() {
		return custNm;
	}

	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	

	public String getCrAmt() {
		return crAmt;
	}

	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}

	public String getTtlAmt() {
		return ttlAmt;
	}

	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setEmailContent(JSPUtil.getParameter(request, "email_content", ""));
		setCustEml(JSPUtil.getParameter(request, "cust_eml", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustFaxNo(JSPUtil.getParameter(request, "cust_fax_no", ""));
		setSendFlg(JSPUtil.getParameter(request, "send_flg", ""));
		setEmailSubject(JSPUtil.getParameter(request, "email_subject", ""));
		setEmailFileName(JSPUtil.getParameter(request, "email_file_name", ""));
		setCustCode(JSPUtil.getParameter(request, "cust_code", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setTtlAmt(JSPUtil.getParameter(request, "ttl_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NYCInvoiceVO[]
	 */
	public NYCInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NYCInvoiceVO[]
	 */
	public NYCInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NYCInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] emailContent = (JSPUtil.getParameter(request, prefix	+ "email_content", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custFaxNo = (JSPUtil.getParameter(request, prefix	+ "cust_fax_no", length));
			String[] sendFlg = (JSPUtil.getParameter(request, prefix	+ "send_flg", length));
			String[] emailSubject = (JSPUtil.getParameter(request, prefix	+ "email_subject", length));
			String[] emailFileName = (JSPUtil.getParameter(request, prefix	+ "email_file_name", length));
			String[] custCode = (JSPUtil.getParameter(request, prefix	+ "cust_code", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new NYCInvoiceVO();
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (emailContent[i] != null)
					model.setEmailContent(emailContent[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custFaxNo[i] != null)
					model.setCustFaxNo(custFaxNo[i]);
				if (sendFlg[i] != null)
					model.setSendFlg(sendFlg[i]);
				if (emailSubject[i] != null)
					model.setEmailSubject(emailSubject[i]);
				if (emailFileName[i] != null)
					model.setEmailFileName(emailFileName[i]);
				if (custCode[i] != null)
					model.setCustCode(custCode[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNYCInvoiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NYCInvoiceVO[]
	 */
	public NYCInvoiceVO[] getNYCInvoiceVOs(){
		NYCInvoiceVO[] vos = (NYCInvoiceVO[])models.toArray(new NYCInvoiceVO[models.size()]);
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
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emailContent = this.emailContent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFaxNo = this.custFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendFlg = this.sendFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emailSubject = this.emailSubject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emailFileName = this.emailFileName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCode = this.custCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
