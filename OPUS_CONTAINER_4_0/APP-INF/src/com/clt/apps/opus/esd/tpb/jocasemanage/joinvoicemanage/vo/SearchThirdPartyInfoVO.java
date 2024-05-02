/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchThirdPartyInfoVO.java
*@FileTitle : SearchThirdPartyInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.11.10 박성진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchThirdPartyInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchThirdPartyInfoVO> models = new ArrayList<SearchThirdPartyInfoVO>();
	
	/* Column Info */
	private String vndrCustEml = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String engAddr = null;
	/* Column Info */
	private String trdPartyCode = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String sheetSetCount = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String bilToLocDivCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrCustAddr = null;
	/* Column Info */
	private String vndrCustAddr2 = null;
	/* Column Info */
	private String vatXchRt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrCustNm = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String prcsCnt = null;
	/* Column Info */
	private String rgstNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchThirdPartyInfoVO() {}

	public SearchThirdPartyInfoVO(String ibflag, String pagerows, String vndrCustEml, String vndrCntCd, String phnNo, String engAddr, String trdPartyCode, String currCd, String rhqCd, String sheetSetCount, String custSeq, String bilToLocDivCd, String vndrCustAddr2, String vndrCustAddr, String vatXchRt, String vndrCustNm, String vndrSeq, String faxNo, String custCntCd, String prcsCnt, String rgstNo) {
		this.vndrCustEml = vndrCustEml;
		this.vndrCntCd = vndrCntCd;
		this.phnNo = phnNo;
		this.engAddr = engAddr;
		this.trdPartyCode = trdPartyCode;
		this.currCd = currCd;
		this.rhqCd = rhqCd;
		this.sheetSetCount = sheetSetCount;
		this.custSeq = custSeq;
		this.bilToLocDivCd = bilToLocDivCd;
		this.pagerows = pagerows;
		this.vndrCustAddr = vndrCustAddr;
		this.vndrCustAddr2 = vndrCustAddr2;
		this.vatXchRt = vatXchRt;
		this.ibflag = ibflag;
		this.vndrCustNm = vndrCustNm;
		this.vndrSeq = vndrSeq;
		this.faxNo = faxNo;
		this.custCntCd = custCntCd;
		this.prcsCnt = prcsCnt;
		this.rgstNo = rgstNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_cust_eml", getVndrCustEml());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("eng_addr", getEngAddr());
		this.hashColumns.put("trd_party_code", getTrdPartyCode());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("sheet_set_count", getSheetSetCount());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bil_to_loc_div_cd", getBilToLocDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_cust_addr", getVndrCustAddr());
		this.hashColumns.put("vndr_cust_addr2", getVndrCustAddr2());
		this.hashColumns.put("vat_xch_rt", getVatXchRt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_cust_nm", getVndrCustNm());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("prcs_cnt", getPrcsCnt());
		this.hashColumns.put("rgst_no", getRgstNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_cust_eml", "vndrCustEml");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("eng_addr", "engAddr");
		this.hashFields.put("trd_party_code", "trdPartyCode");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("sheet_set_count", "sheetSetCount");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bil_to_loc_div_cd", "bilToLocDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_cust_addr", "vndrCustAddr");
		this.hashFields.put("vndr_cust_addr2", "vndrCustAddr2");
		this.hashFields.put("vat_xch_rt", "vatXchRt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_cust_nm", "vndrCustNm");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("prcs_cnt", "prcsCnt");
		this.hashFields.put("rgst_no", "rgstNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vndrCustEml
	 */
	public String getVndrCustEml() {
		return this.vndrCustEml;
	}
	
	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
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
	 * @return engAddr
	 */
	public String getEngAddr() {
		return this.engAddr;
	}
	
	/**
	 * Column Info
	 * @return trdPartyCode
	 */
	public String getTrdPartyCode() {
		return this.trdPartyCode;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return sheetSetCount
	 */
	public String getSheetSetCount() {
		return this.sheetSetCount;
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
	 * @return bilToLocDivCd
	 */
	public String getBilToLocDivCd() {
		return this.bilToLocDivCd;
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
	 * @return vndrCustAddr
	 */
	public String getVndrCustAddr() {
		return this.vndrCustAddr;
	}
	
	/**
	 * Column Info
	 * @return vndrCustAddr2
	 */
	public String getVndrCustAddr2() {
		return this.vndrCustAddr2;
	}
	
	/**
	 * Column Info
	 * @return vatXchRt
	 */
	public String getVatXchRt() {
		return this.vatXchRt;
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
	 * @return vndrCustNm
	 */
	public String getVndrCustNm() {
		return this.vndrCustNm;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return prcsCnt
	 */
	public String getPrcsCnt() {
		return this.prcsCnt;
	}
	
	/**
	 * Column Info
	 * @return rgstNo
	 */
	public String getRgstNo() {
		return this.rgstNo;
	}
	

	/**
	 * Column Info
	 * @param vndrCustEml
	 */
	public void setVndrCustEml(String vndrCustEml) {
		this.vndrCustEml = vndrCustEml;
	}
	
	/**
	 * Column Info
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
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
	 * @param engAddr
	 */
	public void setEngAddr(String engAddr) {
		this.engAddr = engAddr;
	}
	
	/**
	 * Column Info
	 * @param trdPartyCode
	 */
	public void setTrdPartyCode(String trdPartyCode) {
		this.trdPartyCode = trdPartyCode;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param sheetSetCount
	 */
	public void setSheetSetCount(String sheetSetCount) {
		this.sheetSetCount = sheetSetCount;
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
	 * @param bilToLocDivCd
	 */
	public void setBilToLocDivCd(String bilToLocDivCd) {
		this.bilToLocDivCd = bilToLocDivCd;
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
	 * @param vndrCustAddr
	 */
	public void setVndrCustAddr(String vndrCustAddr) {
		this.vndrCustAddr = vndrCustAddr;
	}
	
	/**
	 * Column Info
	 * @param vndrCustAddr2
	 */
	public void setVndrCustAddr2(String vndrCustAddr2) {
		this.vndrCustAddr2 = vndrCustAddr2;
	}
	
	/**
	 * Column Info
	 * @param vatXchRt
	 */
	public void setVatXchRt(String vatXchRt) {
		this.vatXchRt = vatXchRt;
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
	 * @param vndrCustNm
	 */
	public void setVndrCustNm(String vndrCustNm) {
		this.vndrCustNm = vndrCustNm;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param prcsCnt
	 */
	public void setPrcsCnt(String prcsCnt) {
		this.prcsCnt = prcsCnt;
	}
	
	/**
	 * Column Info
	 * @param rgstNo
	 */
	public void setRgstNo(String rgstNo) {
		this.rgstNo = rgstNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVndrCustEml(JSPUtil.getParameter(request, "vndr_cust_eml", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setEngAddr(JSPUtil.getParameter(request, "eng_addr", ""));
		setTrdPartyCode(JSPUtil.getParameter(request, "trd_party_code", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setSheetSetCount(JSPUtil.getParameter(request, "sheet_set_count", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setBilToLocDivCd(JSPUtil.getParameter(request, "bil_to_loc_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVndrCustAddr(JSPUtil.getParameter(request, "vndr_cust_addr", ""));
		setVndrCustAddr2(JSPUtil.getParameter(request, "vndr_cust_addr2", ""));
		setVatXchRt(JSPUtil.getParameter(request, "vat_xch_rt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVndrCustNm(JSPUtil.getParameter(request, "vndr_cust_nm", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setPrcsCnt(JSPUtil.getParameter(request, "prcs_cnt", ""));
		setRgstNo(JSPUtil.getParameter(request, "rgst_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchThirdPartyInfoVO[]
	 */
	public SearchThirdPartyInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchThirdPartyInfoVO[]
	 */
	public SearchThirdPartyInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchThirdPartyInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrCustEml = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_eml", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] engAddr = (JSPUtil.getParameter(request, prefix	+ "eng_addr", length));
			String[] trdPartyCode = (JSPUtil.getParameter(request, prefix	+ "trd_party_code", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] sheetSetCount = (JSPUtil.getParameter(request, prefix	+ "sheet_set_count", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] bilToLocDivCd = (JSPUtil.getParameter(request, prefix	+ "bil_to_loc_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrCustAddr = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_addr", length));
			String[] vndrCustAddr2 = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_addr2", length));
			String[] vatXchRt = (JSPUtil.getParameter(request, prefix	+ "vat_xch_rt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrCustNm = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_nm", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] prcsCnt = (JSPUtil.getParameter(request, prefix	+ "prcs_cnt", length));
			String[] rgstNo = (JSPUtil.getParameter(request, prefix	+ "rgst_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchThirdPartyInfoVO();
				if (vndrCustEml[i] != null)
					model.setVndrCustEml(vndrCustEml[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (engAddr[i] != null)
					model.setEngAddr(engAddr[i]);
				if (trdPartyCode[i] != null)
					model.setTrdPartyCode(trdPartyCode[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (sheetSetCount[i] != null)
					model.setSheetSetCount(sheetSetCount[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (bilToLocDivCd[i] != null)
					model.setBilToLocDivCd(bilToLocDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrCustAddr[i] != null)
					model.setVndrCustAddr(vndrCustAddr[i]);
				if (vndrCustAddr2[i] != null)
					model.setVndrCustAddr2(vndrCustAddr2[i]);
				if (vatXchRt[i] != null)
					model.setVatXchRt(vatXchRt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrCustNm[i] != null)
					model.setVndrCustNm(vndrCustNm[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (prcsCnt[i] != null)
					model.setPrcsCnt(prcsCnt[i]);
				if (rgstNo[i] != null)
					model.setRgstNo(rgstNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchThirdPartyInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchThirdPartyInfoVO[]
	 */
	public SearchThirdPartyInfoVO[] getSearchThirdPartyInfoVOs(){
		SearchThirdPartyInfoVO[] vos = (SearchThirdPartyInfoVO[])models.toArray(new SearchThirdPartyInfoVO[models.size()]);
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
		this.vndrCustEml = this.vndrCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engAddr = this.engAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyCode = this.trdPartyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetSetCount = this.sheetSetCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToLocDivCd = this.bilToLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustAddr = this.vndrCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustAddr2 = this.vndrCustAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatXchRt = this.vatXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustNm = this.vndrCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcsCnt = this.prcsCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstNo = this.rgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
