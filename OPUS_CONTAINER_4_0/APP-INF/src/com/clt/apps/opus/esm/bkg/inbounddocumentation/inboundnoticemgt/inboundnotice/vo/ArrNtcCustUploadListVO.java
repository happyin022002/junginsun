/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrNtcCustUploadListVO.java
*@FileTitle : ArrNtcCustUploadListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArrNtcCustUploadListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArrNtcCustUploadListVO> models = new ArrayList<ArrNtcCustUploadListVO>();
	
	/* Column Info */
	private String faxNo1 = null;
	/* Column Info */
	private String ntcEml1 = null;
	/* Column Info */
	private String ntcEml2 = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String ntcEml3 = null;
	/* Column Info */
	private String custCntcTpCd = null;
	/* Column Info */
	private String faxNo3 = null;
	/* Column Info */
	private String faxNo2 = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ntcEml = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String isValidated = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArrNtcCustUploadListVO() {}

	public ArrNtcCustUploadListVO(String ibflag, String pagerows, String blNo, String bkgNo, String custNm, String bkgCustTpCd, String custCntCd, String faxNo1, String ntcEml1, String faxNo2, String ntcEml2, String faxNo3, String ntcEml3, String custCntcTpCd, String faxNo, String ntcEml, String isValidated) {
		this.faxNo1 = faxNo1;
		this.ntcEml1 = ntcEml1;
		this.ntcEml2 = ntcEml2;
		this.custNm = custNm;
		this.ntcEml3 = ntcEml3;
		this.custCntcTpCd = custCntcTpCd;
		this.faxNo3 = faxNo3;
		this.faxNo2 = faxNo2;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ntcEml = ntcEml;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.isValidated = isValidated;
		this.faxNo = faxNo;
		this.bkgCustTpCd = bkgCustTpCd;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fax_no1", getFaxNo1());
		this.hashColumns.put("ntc_eml1", getNtcEml1());
		this.hashColumns.put("ntc_eml2", getNtcEml2());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("ntc_eml3", getNtcEml3());
		this.hashColumns.put("cust_cntc_tp_cd", getCustCntcTpCd());
		this.hashColumns.put("fax_no3", getFaxNo3());
		this.hashColumns.put("fax_no2", getFaxNo2());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ntc_eml", getNtcEml());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("is_validated", getIsValidated());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fax_no1", "faxNo1");
		this.hashFields.put("ntc_eml1", "ntcEml1");
		this.hashFields.put("ntc_eml2", "ntcEml2");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("ntc_eml3", "ntcEml3");
		this.hashFields.put("cust_cntc_tp_cd", "custCntcTpCd");
		this.hashFields.put("fax_no3", "faxNo3");
		this.hashFields.put("fax_no2", "faxNo2");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ntc_eml", "ntcEml");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("is_validated", "isValidated");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return faxNo1
	 */
	public String getFaxNo1() {
		return this.faxNo1;
	}
	
	/**
	 * Column Info
	 * @return ntcEml1
	 */
	public String getNtcEml1() {
		return this.ntcEml1;
	}
	
	/**
	 * Column Info
	 * @return ntcEml2
	 */
	public String getNtcEml2() {
		return this.ntcEml2;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return ntcEml3
	 */
	public String getNtcEml3() {
		return this.ntcEml3;
	}
	
	/**
	 * Column Info
	 * @return custCntcTpCd
	 */
	public String getCustCntcTpCd() {
		return this.custCntcTpCd;
	}
	
	/**
	 * Column Info
	 * @return faxNo3
	 */
	public String getFaxNo3() {
		return this.faxNo3;
	}
	
	/**
	 * Column Info
	 * @return faxNo2
	 */
	public String getFaxNo2() {
		return this.faxNo2;
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
	 * @return ntcEml
	 */
	public String getNtcEml() {
		return this.ntcEml;
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
	 * @return isValidated
	 */
	public String getIsValidated() {
		return this.isValidated;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	

	/**
	 * Column Info
	 * @param faxNo1
	 */
	public void setFaxNo1(String faxNo1) {
		this.faxNo1 = faxNo1;
	}
	
	/**
	 * Column Info
	 * @param ntcEml1
	 */
	public void setNtcEml1(String ntcEml1) {
		this.ntcEml1 = ntcEml1;
	}
	
	/**
	 * Column Info
	 * @param ntcEml2
	 */
	public void setNtcEml2(String ntcEml2) {
		this.ntcEml2 = ntcEml2;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param ntcEml3
	 */
	public void setNtcEml3(String ntcEml3) {
		this.ntcEml3 = ntcEml3;
	}
	
	/**
	 * Column Info
	 * @param custCntcTpCd
	 */
	public void setCustCntcTpCd(String custCntcTpCd) {
		this.custCntcTpCd = custCntcTpCd;
	}
	
	/**
	 * Column Info
	 * @param faxNo3
	 */
	public void setFaxNo3(String faxNo3) {
		this.faxNo3 = faxNo3;
	}
	
	/**
	 * Column Info
	 * @param faxNo2
	 */
	public void setFaxNo2(String faxNo2) {
		this.faxNo2 = faxNo2;
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
	 * @param ntcEml
	 */
	public void setNtcEml(String ntcEml) {
		this.ntcEml = ntcEml;
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
	 * @param isValidated
	 */
	public void setIsValidated(String isValidated) {
		this.isValidated = isValidated;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFaxNo1(JSPUtil.getParameter(request, "fax_no1", ""));
		setNtcEml1(JSPUtil.getParameter(request, "ntc_eml1", ""));
		setNtcEml2(JSPUtil.getParameter(request, "ntc_eml2", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setNtcEml3(JSPUtil.getParameter(request, "ntc_eml3", ""));
		setCustCntcTpCd(JSPUtil.getParameter(request, "cust_cntc_tp_cd", ""));
		setFaxNo3(JSPUtil.getParameter(request, "fax_no3", ""));
		setFaxNo2(JSPUtil.getParameter(request, "fax_no2", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setNtcEml(JSPUtil.getParameter(request, "ntc_eml", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIsValidated(JSPUtil.getParameter(request, "is_validated", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, "bkg_cust_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArrNtcCustUploadListVO[]
	 */
	public ArrNtcCustUploadListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArrNtcCustUploadListVO[]
	 */
	public ArrNtcCustUploadListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArrNtcCustUploadListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] faxNo1 = (JSPUtil.getParameter(request, prefix	+ "fax_no1", length));
			String[] ntcEml1 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml1", length));
			String[] ntcEml2 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml2", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] ntcEml3 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml3", length));
			String[] custCntcTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_tp_cd", length));
			String[] faxNo3 = (JSPUtil.getParameter(request, prefix	+ "fax_no3", length));
			String[] faxNo2 = (JSPUtil.getParameter(request, prefix	+ "fax_no2", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ntcEml = (JSPUtil.getParameter(request, prefix	+ "ntc_eml", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] isValidated = (JSPUtil.getParameter(request, prefix	+ "is_validated", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArrNtcCustUploadListVO();
				if (faxNo1[i] != null)
					model.setFaxNo1(faxNo1[i]);
				if (ntcEml1[i] != null)
					model.setNtcEml1(ntcEml1[i]);
				if (ntcEml2[i] != null)
					model.setNtcEml2(ntcEml2[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (ntcEml3[i] != null)
					model.setNtcEml3(ntcEml3[i]);
				if (custCntcTpCd[i] != null)
					model.setCustCntcTpCd(custCntcTpCd[i]);
				if (faxNo3[i] != null)
					model.setFaxNo3(faxNo3[i]);
				if (faxNo2[i] != null)
					model.setFaxNo2(faxNo2[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ntcEml[i] != null)
					model.setNtcEml(ntcEml[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (isValidated[i] != null)
					model.setIsValidated(isValidated[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArrNtcCustUploadListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArrNtcCustUploadListVO[]
	 */
	public ArrNtcCustUploadListVO[] getArrNtcCustUploadListVOs(){
		ArrNtcCustUploadListVO[] vos = (ArrNtcCustUploadListVO[])models.toArray(new ArrNtcCustUploadListVO[models.size()]);
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
		this.faxNo1 = this.faxNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml1 = this.ntcEml1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml2 = this.ntcEml2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml3 = this.ntcEml3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcTpCd = this.custCntcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo3 = this.faxNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo2 = this.faxNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml = this.ntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isValidated = this.isValidated .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
