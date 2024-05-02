/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MdmCustomerVO.java
*@FileTitle : MdmCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MdmCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmCustomerVO> models = new ArrayList<MdmCustomerVO>();
	
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String bookingAlertToDate = null;
	/* Column Info */
	private String ffFmcNo = null;
	/* Column Info */
	private String noUse = null;
	/* Column Info */
	private String mrgCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String custStsCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String bzetAddr = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String custEml = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String locationCode = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String ctyNm = null;
	/* Column Info */
	private String custDivFlag = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MdmCustomerVO() {}

	public MdmCustomerVO(String ibflag, String pagerows, String custCd, String custLglEngNm, String custCntCd, String ctyNm, String bzetAddr, String phnNo, String faxNo, String custEml, String custStsCd, String bookingAlertToDate, String creDt, String srepCd, String ofcCd, String custSeq, String mrgCd, String ffFmcNo, String noUse, String custDivFlag, String zipCd, String steCd, String locationCode) {
		this.phnNo = phnNo;
		this.bookingAlertToDate = bookingAlertToDate;
		this.ffFmcNo = ffFmcNo;
		this.noUse = noUse;
		this.mrgCd = mrgCd;
		this.creDt = creDt;
		this.custStsCd = custStsCd;
		this.custSeq = custSeq;
		this.bzetAddr = bzetAddr;
		this.srepCd = srepCd;
		this.custEml = custEml;
		this.pagerows = pagerows;
		this.custLglEngNm = custLglEngNm;
		this.locationCode = locationCode;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.zipCd = zipCd;
		this.custCd = custCd;
		this.faxNo = faxNo;
		this.ctyNm = ctyNm;
		this.custDivFlag = custDivFlag;
		this.steCd = steCd;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("booking_alert_to_date", getBookingAlertToDate());
		this.hashColumns.put("ff_fmc_no", getFfFmcNo());
		this.hashColumns.put("no_use", getNoUse());
		this.hashColumns.put("mrg_cd", getMrgCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cust_sts_cd", getCustStsCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bzet_addr", getBzetAddr());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("location_code", getLocationCode());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("cust_div_flag", getCustDivFlag());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("booking_alert_to_date", "bookingAlertToDate");
		this.hashFields.put("ff_fmc_no", "ffFmcNo");
		this.hashFields.put("no_use", "noUse");
		this.hashFields.put("mrg_cd", "mrgCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cust_sts_cd", "custStsCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bzet_addr", "bzetAddr");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("location_code", "locationCode");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("cust_div_flag", "custDivFlag");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return bookingAlertToDate
	 */
	public String getBookingAlertToDate() {
		return this.bookingAlertToDate;
	}
	
	/**
	 * Column Info
	 * @return ffFmcNo
	 */
	public String getFfFmcNo() {
		return this.ffFmcNo;
	}
	
	/**
	 * Column Info
	 * @return noUse
	 */
	public String getNoUse() {
		return this.noUse;
	}
	
	/**
	 * Column Info
	 * @return mrgCd
	 */
	public String getMrgCd() {
		return this.mrgCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return custStsCd
	 */
	public String getCustStsCd() {
		return this.custStsCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return bzetAddr
	 */
	public String getBzetAddr() {
		return this.bzetAddr;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 * Column Info
	 * @return custEml
	 */
	public String getCustEml() {
		return this.custEml;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return locationCode
	 */
	public String getLocationCode() {
		return this.locationCode;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
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
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
	}
	
	/**
	 * Column Info
	 * @return custDivFlag
	 */
	public String getCustDivFlag() {
		return this.custDivFlag;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
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
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param bookingAlertToDate
	 */
	public void setBookingAlertToDate(String bookingAlertToDate) {
		this.bookingAlertToDate = bookingAlertToDate;
	}
	
	/**
	 * Column Info
	 * @param ffFmcNo
	 */
	public void setFfFmcNo(String ffFmcNo) {
		this.ffFmcNo = ffFmcNo;
	}
	
	/**
	 * Column Info
	 * @param noUse
	 */
	public void setNoUse(String noUse) {
		this.noUse = noUse;
	}
	
	/**
	 * Column Info
	 * @param mrgCd
	 */
	public void setMrgCd(String mrgCd) {
		this.mrgCd = mrgCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param custStsCd
	 */
	public void setCustStsCd(String custStsCd) {
		this.custStsCd = custStsCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param bzetAddr
	 */
	public void setBzetAddr(String bzetAddr) {
		this.bzetAddr = bzetAddr;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * Column Info
	 * @param custEml
	 */
	public void setCustEml(String custEml) {
		this.custEml = custEml;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param locationCode
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
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
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
	}
	
	/**
	 * Column Info
	 * @param custDivFlag
	 */
	public void setCustDivFlag(String custDivFlag) {
		this.custDivFlag = custDivFlag;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setBookingAlertToDate(JSPUtil.getParameter(request, prefix + "booking_alert_to_date", ""));
		setFfFmcNo(JSPUtil.getParameter(request, prefix + "ff_fmc_no", ""));
		setNoUse(JSPUtil.getParameter(request, prefix + "no_use", ""));
		setMrgCd(JSPUtil.getParameter(request, prefix + "mrg_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCustStsCd(JSPUtil.getParameter(request, prefix + "cust_sts_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setBzetAddr(JSPUtil.getParameter(request, prefix + "bzet_addr", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setLocationCode(JSPUtil.getParameter(request, prefix + "location_code", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setCtyNm(JSPUtil.getParameter(request, prefix + "cty_nm", ""));
		setCustDivFlag(JSPUtil.getParameter(request, prefix + "cust_div_flag", ""));
		setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MdmCustomerVO[]
	 */
	public MdmCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MdmCustomerVO[]
	 */
	public MdmCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] bookingAlertToDate = (JSPUtil.getParameter(request, prefix	+ "booking_alert_to_date", length));
			String[] ffFmcNo = (JSPUtil.getParameter(request, prefix	+ "ff_fmc_no", length));
			String[] noUse = (JSPUtil.getParameter(request, prefix	+ "no_use", length));
			String[] mrgCd = (JSPUtil.getParameter(request, prefix	+ "mrg_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] custStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_sts_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] bzetAddr = (JSPUtil.getParameter(request, prefix	+ "bzet_addr", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] locationCode = (JSPUtil.getParameter(request, prefix	+ "location_code", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm", length));
			String[] custDivFlag = (JSPUtil.getParameter(request, prefix	+ "cust_div_flag", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmCustomerVO();
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (bookingAlertToDate[i] != null)
					model.setBookingAlertToDate(bookingAlertToDate[i]);
				if (ffFmcNo[i] != null)
					model.setFfFmcNo(ffFmcNo[i]);
				if (noUse[i] != null)
					model.setNoUse(noUse[i]);
				if (mrgCd[i] != null)
					model.setMrgCd(mrgCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (custStsCd[i] != null)
					model.setCustStsCd(custStsCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (bzetAddr[i] != null)
					model.setBzetAddr(bzetAddr[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (locationCode[i] != null)
					model.setLocationCode(locationCode[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (ctyNm[i] != null)
					model.setCtyNm(ctyNm[i]);
				if (custDivFlag[i] != null)
					model.setCustDivFlag(custDivFlag[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMdmCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MdmCustomerVO[]
	 */
	public MdmCustomerVO[] getMdmCustomerVOs(){
		MdmCustomerVO[] vos = (MdmCustomerVO[])models.toArray(new MdmCustomerVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingAlertToDate = this.bookingAlertToDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffFmcNo = this.ffFmcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noUse = this.noUse .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrgCd = this.mrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStsCd = this.custStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetAddr = this.bzetAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCode = this.locationCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custDivFlag = this.custDivFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
