/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DeclarantCustomerInfoVO.java
*@FileTitle : DeclarantCustomerInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class DeclarantCustomerInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DeclarantCustomerInfoVO> models = new ArrayList<DeclarantCustomerInfoVO>();
	
	/* Column Info */
	private String cnCustNm = null;
	/* Column Info */
	private String shDgDeclSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dcgoSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cnCustZipId = null;
	/* Column Info */
	private String cnCustSeq = null;
	/* Column Info */
	private String cnDgDeclSeq = null;
	/* Column Info */
	private String cntrCgoSeq = null;
	/* Column Info */
	private String shCustNm = null;
	/* Column Info */
	private String cnCstmsDeclCntCd = null;
	/* Column Info */
	private String dgCntrSeq = null;
	/* Column Info */
	private String cnCustAddr = null;
	/* Column Info */
	private String shCustSeq = null;
	/* Column Info */
	private String shCustZipId = null;
	/* Column Info */
	private String shCustFaxNo = null;
	/* Column Info */
	private String cnCustCtyNm = null;
	/* Column Info */
	private String cnCustSteCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String shCstmsDeclCntCd = null;
	/* Column Info */
	private String shCustCntCd = null;
	/* Column Info */
	private String shCustAddr = null;
	/* Column Info */
	private String declNm = null;
	/* Column Info */
	private String cnCustEml = null;
	/* Column Info */
	private String shCustCtyNm = null;
	/* Column Info */
	private String shCustSteCd = null;
	/* Column Info */
	private String shCustEml = null;
	/* Column Info */
	private String cnCustCntCd = null;
	/* Column Info */
	private String cnCustFaxNo = null;
	/* Column Info */
	private String cnPhnNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String shPhnNo = null;
	/* Column Info */
	private String dgCntrOrdSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DeclarantCustomerInfoVO() {}

	public DeclarantCustomerInfoVO(String ibflag, String pagerows, String bkgNo, String dcgoSeq, String dgCntrSeq, String cntrCgoSeq, String cntrNo, String declNm, String shDgDeclSeq, String shCustCntCd, String shCustSeq, String shCustNm, String shCustAddr, String shCustCtyNm, String shCustZipId, String shCustSteCd, String shCstmsDeclCntCd, String shPhnNo, String shCustFaxNo, String shCustEml, String cnDgDeclSeq, String cnCustCntCd, String cnCustSeq, String cnCustNm, String cnCustAddr, String cnCustCtyNm, String cnCustZipId, String cnCustSteCd, String cnCstmsDeclCntCd, String cnPhnNo, String cnCustFaxNo, String cnCustEml, String dgCntrOrdSeq) {
		this.cnCustNm = cnCustNm;
		this.shDgDeclSeq = shDgDeclSeq;
		this.ibflag = ibflag;
		this.dcgoSeq = dcgoSeq;
		this.bkgNo = bkgNo;
		this.cnCustZipId = cnCustZipId;
		this.cnCustSeq = cnCustSeq;
		this.cnDgDeclSeq = cnDgDeclSeq;
		this.cntrCgoSeq = cntrCgoSeq;
		this.shCustNm = shCustNm;
		this.cnCstmsDeclCntCd = cnCstmsDeclCntCd;
		this.dgCntrSeq = dgCntrSeq;
		this.cnCustAddr = cnCustAddr;
		this.shCustSeq = shCustSeq;
		this.shCustZipId = shCustZipId;
		this.shCustFaxNo = shCustFaxNo;
		this.cnCustCtyNm = cnCustCtyNm;
		this.cnCustSteCd = cnCustSteCd;
		this.pagerows = pagerows;
		this.shCstmsDeclCntCd = shCstmsDeclCntCd;
		this.shCustCntCd = shCustCntCd;
		this.shCustAddr = shCustAddr;
		this.declNm = declNm;
		this.cnCustEml = cnCustEml;
		this.shCustCtyNm = shCustCtyNm;
		this.shCustSteCd = shCustSteCd;
		this.shCustEml = shCustEml;
		this.cnCustCntCd = cnCustCntCd;
		this.cnCustFaxNo = cnCustFaxNo;
		this.cnPhnNo = cnPhnNo;
		this.cntrNo = cntrNo;
		this.shPhnNo = shPhnNo;
		this.dgCntrOrdSeq = dgCntrOrdSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cn_cust_nm", getCnCustNm());
		this.hashColumns.put("sh_dg_decl_seq", getShDgDeclSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dcgo_seq", getDcgoSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cn_cust_zip_id", getCnCustZipId());
		this.hashColumns.put("cn_cust_seq", getCnCustSeq());
		this.hashColumns.put("cn_dg_decl_seq", getCnDgDeclSeq());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("sh_cust_nm", getShCustNm());
		this.hashColumns.put("cn_cstms_decl_cnt_cd", getCnCstmsDeclCntCd());
		this.hashColumns.put("dg_cntr_seq", getDgCntrSeq());
		this.hashColumns.put("cn_cust_addr", getCnCustAddr());
		this.hashColumns.put("sh_cust_seq", getShCustSeq());
		this.hashColumns.put("sh_cust_zip_id", getShCustZipId());
		this.hashColumns.put("sh_cust_fax_no", getShCustFaxNo());
		this.hashColumns.put("cn_cust_cty_nm", getCnCustCtyNm());
		this.hashColumns.put("cn_cust_ste_cd", getCnCustSteCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sh_cstms_decl_cnt_cd", getShCstmsDeclCntCd());
		this.hashColumns.put("sh_cust_cnt_cd", getShCustCntCd());
		this.hashColumns.put("sh_cust_addr", getShCustAddr());
		this.hashColumns.put("decl_nm", getDeclNm());
		this.hashColumns.put("cn_cust_eml", getCnCustEml());
		this.hashColumns.put("sh_cust_cty_nm", getShCustCtyNm());
		this.hashColumns.put("sh_cust_ste_cd", getShCustSteCd());
		this.hashColumns.put("sh_cust_eml", getShCustEml());
		this.hashColumns.put("cn_cust_cnt_cd", getCnCustCntCd());
		this.hashColumns.put("cn_cust_fax_no", getCnCustFaxNo());
		this.hashColumns.put("cn_phn_no", getCnPhnNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sh_phn_no", getShPhnNo());
		this.hashColumns.put("dg_cntr_ord_seq", getDgCntrOrdSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cn_cust_nm", "cnCustNm");
		this.hashFields.put("sh_dg_decl_seq", "shDgDeclSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cn_cust_zip_id", "cnCustZipId");
		this.hashFields.put("cn_cust_seq", "cnCustSeq");
		this.hashFields.put("cn_dg_decl_seq", "cnDgDeclSeq");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("sh_cust_nm", "shCustNm");
		this.hashFields.put("cn_cstms_decl_cnt_cd", "cnCstmsDeclCntCd");
		this.hashFields.put("dg_cntr_seq", "dgCntrSeq");
		this.hashFields.put("cn_cust_addr", "cnCustAddr");
		this.hashFields.put("sh_cust_seq", "shCustSeq");
		this.hashFields.put("sh_cust_zip_id", "shCustZipId");
		this.hashFields.put("sh_cust_fax_no", "shCustFaxNo");
		this.hashFields.put("cn_cust_cty_nm", "cnCustCtyNm");
		this.hashFields.put("cn_cust_ste_cd", "cnCustSteCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sh_cstms_decl_cnt_cd", "shCstmsDeclCntCd");
		this.hashFields.put("sh_cust_cnt_cd", "shCustCntCd");
		this.hashFields.put("sh_cust_addr", "shCustAddr");
		this.hashFields.put("decl_nm", "declNm");
		this.hashFields.put("cn_cust_eml", "cnCustEml");
		this.hashFields.put("sh_cust_cty_nm", "shCustCtyNm");
		this.hashFields.put("sh_cust_ste_cd", "shCustSteCd");
		this.hashFields.put("sh_cust_eml", "shCustEml");
		this.hashFields.put("cn_cust_cnt_cd", "cnCustCntCd");
		this.hashFields.put("cn_cust_fax_no", "cnCustFaxNo");
		this.hashFields.put("cn_phn_no", "cnPhnNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sh_phn_no", "shPhnNo");
		this.hashFields.put("dg_cntr_ord_seq", "dgCntrOrdSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cnCustNm
	 */
	public String getCnCustNm() {
		return this.cnCustNm;
	}
	
	/**
	 * Column Info
	 * @return shDgDeclSeq
	 */
	public String getShDgDeclSeq() {
		return this.shDgDeclSeq;
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
	 * @return dcgoSeq
	 */
	public String getDcgoSeq() {
		return this.dcgoSeq;
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
	 * @return cnCustZipId
	 */
	public String getCnCustZipId() {
		return this.cnCustZipId;
	}
	
	/**
	 * Column Info
	 * @return cnCustSeq
	 */
	public String getCnCustSeq() {
		return this.cnCustSeq;
	}
	
	/**
	 * Column Info
	 * @return cnDgDeclSeq
	 */
	public String getCnDgDeclSeq() {
		return this.cnDgDeclSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrCgoSeq
	 */
	public String getCntrCgoSeq() {
		return this.cntrCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return shCustNm
	 */
	public String getShCustNm() {
		return this.shCustNm;
	}
	
	/**
	 * Column Info
	 * @return cnCstmsDeclCntCd
	 */
	public String getCnCstmsDeclCntCd() {
		return this.cnCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @return dgCntrSeq
	 */
	public String getDgCntrSeq() {
		return this.dgCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return cnCustAddr
	 */
	public String getCnCustAddr() {
		return this.cnCustAddr;
	}
	
	/**
	 * Column Info
	 * @return shCustSeq
	 */
	public String getShCustSeq() {
		return this.shCustSeq;
	}
	
	/**
	 * Column Info
	 * @return shCustZipId
	 */
	public String getShCustZipId() {
		return this.shCustZipId;
	}
	
	/**
	 * Column Info
	 * @return shCustFaxNo
	 */
	public String getShCustFaxNo() {
		return this.shCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @return cnCustCtyNm
	 */
	public String getCnCustCtyNm() {
		return this.cnCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @return cnCustSteCd
	 */
	public String getCnCustSteCd() {
		return this.cnCustSteCd;
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
	 * @return shCstmsDeclCntCd
	 */
	public String getShCstmsDeclCntCd() {
		return this.shCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @return shCustCntCd
	 */
	public String getShCustCntCd() {
		return this.shCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return shCustAddr
	 */
	public String getShCustAddr() {
		return this.shCustAddr;
	}
	
	/**
	 * Column Info
	 * @return declNm
	 */
	public String getDeclNm() {
		return this.declNm;
	}
	
	/**
	 * Column Info
	 * @return cnCustEml
	 */
	public String getCnCustEml() {
		return this.cnCustEml;
	}
	
	/**
	 * Column Info
	 * @return shCustCtyNm
	 */
	public String getShCustCtyNm() {
		return this.shCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @return shCustSteCd
	 */
	public String getShCustSteCd() {
		return this.shCustSteCd;
	}
	
	/**
	 * Column Info
	 * @return shCustEml
	 */
	public String getShCustEml() {
		return this.shCustEml;
	}
	
	/**
	 * Column Info
	 * @return cnCustCntCd
	 */
	public String getCnCustCntCd() {
		return this.cnCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return cnCustFaxNo
	 */
	public String getCnCustFaxNo() {
		return this.cnCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @return cnPhnNo
	 */
	public String getCnPhnNo() {
		return this.cnPhnNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return shPhnNo
	 */
	public String getShPhnNo() {
		return this.shPhnNo;
	}
	
	/**
	 * Column Info
	 * @return dgCntrOrdSeq
	 */
	public String getDgCntrOrdSeq() {
		return this.dgCntrOrdSeq;
	}
	

	/**
	 * Column Info
	 * @param cnCustNm
	 */
	public void setCnCustNm(String cnCustNm) {
		this.cnCustNm = cnCustNm;
	}
	
	/**
	 * Column Info
	 * @param shDgDeclSeq
	 */
	public void setShDgDeclSeq(String shDgDeclSeq) {
		this.shDgDeclSeq = shDgDeclSeq;
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
	 * @param dcgoSeq
	 */
	public void setDcgoSeq(String dcgoSeq) {
		this.dcgoSeq = dcgoSeq;
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
	 * @param cnCustZipId
	 */
	public void setCnCustZipId(String cnCustZipId) {
		this.cnCustZipId = cnCustZipId;
	}
	
	/**
	 * Column Info
	 * @param cnCustSeq
	 */
	public void setCnCustSeq(String cnCustSeq) {
		this.cnCustSeq = cnCustSeq;
	}
	
	/**
	 * Column Info
	 * @param cnDgDeclSeq
	 */
	public void setCnDgDeclSeq(String cnDgDeclSeq) {
		this.cnDgDeclSeq = cnDgDeclSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrCgoSeq
	 */
	public void setCntrCgoSeq(String cntrCgoSeq) {
		this.cntrCgoSeq = cntrCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param shCustNm
	 */
	public void setShCustNm(String shCustNm) {
		this.shCustNm = shCustNm;
	}
	
	/**
	 * Column Info
	 * @param cnCstmsDeclCntCd
	 */
	public void setCnCstmsDeclCntCd(String cnCstmsDeclCntCd) {
		this.cnCstmsDeclCntCd = cnCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @param dgCntrSeq
	 */
	public void setDgCntrSeq(String dgCntrSeq) {
		this.dgCntrSeq = dgCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param cnCustAddr
	 */
	public void setCnCustAddr(String cnCustAddr) {
		this.cnCustAddr = cnCustAddr;
	}
	
	/**
	 * Column Info
	 * @param shCustSeq
	 */
	public void setShCustSeq(String shCustSeq) {
		this.shCustSeq = shCustSeq;
	}
	
	/**
	 * Column Info
	 * @param shCustZipId
	 */
	public void setShCustZipId(String shCustZipId) {
		this.shCustZipId = shCustZipId;
	}
	
	/**
	 * Column Info
	 * @param shCustFaxNo
	 */
	public void setShCustFaxNo(String shCustFaxNo) {
		this.shCustFaxNo = shCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @param cnCustCtyNm
	 */
	public void setCnCustCtyNm(String cnCustCtyNm) {
		this.cnCustCtyNm = cnCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @param cnCustSteCd
	 */
	public void setCnCustSteCd(String cnCustSteCd) {
		this.cnCustSteCd = cnCustSteCd;
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
	 * @param shCstmsDeclCntCd
	 */
	public void setShCstmsDeclCntCd(String shCstmsDeclCntCd) {
		this.shCstmsDeclCntCd = shCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @param shCustCntCd
	 */
	public void setShCustCntCd(String shCustCntCd) {
		this.shCustCntCd = shCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param shCustAddr
	 */
	public void setShCustAddr(String shCustAddr) {
		this.shCustAddr = shCustAddr;
	}
	
	/**
	 * Column Info
	 * @param declNm
	 */
	public void setDeclNm(String declNm) {
		this.declNm = declNm;
	}
	
	/**
	 * Column Info
	 * @param cnCustEml
	 */
	public void setCnCustEml(String cnCustEml) {
		this.cnCustEml = cnCustEml;
	}
	
	/**
	 * Column Info
	 * @param shCustCtyNm
	 */
	public void setShCustCtyNm(String shCustCtyNm) {
		this.shCustCtyNm = shCustCtyNm;
	}
	
	/**
	 * Column Info
	 * @param shCustSteCd
	 */
	public void setShCustSteCd(String shCustSteCd) {
		this.shCustSteCd = shCustSteCd;
	}
	
	/**
	 * Column Info
	 * @param shCustEml
	 */
	public void setShCustEml(String shCustEml) {
		this.shCustEml = shCustEml;
	}
	
	/**
	 * Column Info
	 * @param cnCustCntCd
	 */
	public void setCnCustCntCd(String cnCustCntCd) {
		this.cnCustCntCd = cnCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param cnCustFaxNo
	 */
	public void setCnCustFaxNo(String cnCustFaxNo) {
		this.cnCustFaxNo = cnCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @param cnPhnNo
	 */
	public void setCnPhnNo(String cnPhnNo) {
		this.cnPhnNo = cnPhnNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param shPhnNo
	 */
	public void setShPhnNo(String shPhnNo) {
		this.shPhnNo = shPhnNo;
	}
	
	/**
	 * Column Info
	 * @param dgCntrOrdSeq
	 */
	public void setDgCntrOrdSeq(String dgCntrOrdSeq) {
		this.dgCntrOrdSeq = dgCntrOrdSeq;
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
		setCnCustNm(JSPUtil.getParameter(request, prefix + "cn_cust_nm", ""));
		setShDgDeclSeq(JSPUtil.getParameter(request, prefix + "sh_dg_decl_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDcgoSeq(JSPUtil.getParameter(request, prefix + "dcgo_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCnCustZipId(JSPUtil.getParameter(request, prefix + "cn_cust_zip_id", ""));
		setCnCustSeq(JSPUtil.getParameter(request, prefix + "cn_cust_seq", ""));
		setCnDgDeclSeq(JSPUtil.getParameter(request, prefix + "cn_dg_decl_seq", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
		setShCustNm(JSPUtil.getParameter(request, prefix + "sh_cust_nm", ""));
		setCnCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "cn_cstms_decl_cnt_cd", ""));
		setDgCntrSeq(JSPUtil.getParameter(request, prefix + "dg_cntr_seq", ""));
		setCnCustAddr(JSPUtil.getParameter(request, prefix + "cn_cust_addr", ""));
		setShCustSeq(JSPUtil.getParameter(request, prefix + "sh_cust_seq", ""));
		setShCustZipId(JSPUtil.getParameter(request, prefix + "sh_cust_zip_id", ""));
		setShCustFaxNo(JSPUtil.getParameter(request, prefix + "sh_cust_fax_no", ""));
		setCnCustCtyNm(JSPUtil.getParameter(request, prefix + "cn_cust_cty_nm", ""));
		setCnCustSteCd(JSPUtil.getParameter(request, prefix + "cn_cust_ste_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setShCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "sh_cstms_decl_cnt_cd", ""));
		setShCustCntCd(JSPUtil.getParameter(request, prefix + "sh_cust_cnt_cd", ""));
		setShCustAddr(JSPUtil.getParameter(request, prefix + "sh_cust_addr", ""));
		setDeclNm(JSPUtil.getParameter(request, prefix + "decl_nm", ""));
		setCnCustEml(JSPUtil.getParameter(request, prefix + "cn_cust_eml", ""));
		setShCustCtyNm(JSPUtil.getParameter(request, prefix + "sh_cust_cty_nm", ""));
		setShCustSteCd(JSPUtil.getParameter(request, prefix + "sh_cust_ste_cd", ""));
		setShCustEml(JSPUtil.getParameter(request, prefix + "sh_cust_eml", ""));
		setCnCustCntCd(JSPUtil.getParameter(request, prefix + "cn_cust_cnt_cd", ""));
		setCnCustFaxNo(JSPUtil.getParameter(request, prefix + "cn_cust_fax_no", ""));
		setCnPhnNo(JSPUtil.getParameter(request, prefix + "cn_phn_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setShPhnNo(JSPUtil.getParameter(request, prefix + "sh_phn_no", ""));
		setDgCntrOrdSeq(JSPUtil.getParameter(request, prefix + "dg_cntr_ord_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DeclarantCustomerInfoVO[]
	 */
	public DeclarantCustomerInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DeclarantCustomerInfoVO[]
	 */
	public DeclarantCustomerInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DeclarantCustomerInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cnCustNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_nm", length));
			String[] shDgDeclSeq = (JSPUtil.getParameter(request, prefix	+ "sh_dg_decl_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dcgoSeq = (JSPUtil.getParameter(request, prefix	+ "dcgo_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cnCustZipId = (JSPUtil.getParameter(request, prefix	+ "cn_cust_zip_id", length));
			String[] cnCustSeq = (JSPUtil.getParameter(request, prefix	+ "cn_cust_seq", length));
			String[] cnDgDeclSeq = (JSPUtil.getParameter(request, prefix	+ "cn_dg_decl_seq", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] shCustNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_nm", length));
			String[] cnCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "cn_cstms_decl_cnt_cd", length));
			String[] dgCntrSeq = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_seq", length));
			String[] cnCustAddr = (JSPUtil.getParameter(request, prefix	+ "cn_cust_addr", length));
			String[] shCustSeq = (JSPUtil.getParameter(request, prefix	+ "sh_cust_seq", length));
			String[] shCustZipId = (JSPUtil.getParameter(request, prefix	+ "sh_cust_zip_id", length));
			String[] shCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "sh_cust_fax_no", length));
			String[] cnCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_cty_nm", length));
			String[] cnCustSteCd = (JSPUtil.getParameter(request, prefix	+ "cn_cust_ste_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] shCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "sh_cstms_decl_cnt_cd", length));
			String[] shCustCntCd = (JSPUtil.getParameter(request, prefix	+ "sh_cust_cnt_cd", length));
			String[] shCustAddr = (JSPUtil.getParameter(request, prefix	+ "sh_cust_addr", length));
			String[] declNm = (JSPUtil.getParameter(request, prefix	+ "decl_nm", length));
			String[] cnCustEml = (JSPUtil.getParameter(request, prefix	+ "cn_cust_eml", length));
			String[] shCustCtyNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_cty_nm", length));
			String[] shCustSteCd = (JSPUtil.getParameter(request, prefix	+ "sh_cust_ste_cd", length));
			String[] shCustEml = (JSPUtil.getParameter(request, prefix	+ "sh_cust_eml", length));
			String[] cnCustCntCd = (JSPUtil.getParameter(request, prefix	+ "cn_cust_cnt_cd", length));
			String[] cnCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "cn_cust_fax_no", length));
			String[] cnPhnNo = (JSPUtil.getParameter(request, prefix	+ "cn_phn_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] shPhnNo = (JSPUtil.getParameter(request, prefix	+ "sh_phn_no", length));
			String[] dgCntrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_ord_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new DeclarantCustomerInfoVO();
				if (cnCustNm[i] != null)
					model.setCnCustNm(cnCustNm[i]);
				if (shDgDeclSeq[i] != null)
					model.setShDgDeclSeq(shDgDeclSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dcgoSeq[i] != null)
					model.setDcgoSeq(dcgoSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cnCustZipId[i] != null)
					model.setCnCustZipId(cnCustZipId[i]);
				if (cnCustSeq[i] != null)
					model.setCnCustSeq(cnCustSeq[i]);
				if (cnDgDeclSeq[i] != null)
					model.setCnDgDeclSeq(cnDgDeclSeq[i]);
				if (cntrCgoSeq[i] != null)
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (shCustNm[i] != null)
					model.setShCustNm(shCustNm[i]);
				if (cnCstmsDeclCntCd[i] != null)
					model.setCnCstmsDeclCntCd(cnCstmsDeclCntCd[i]);
				if (dgCntrSeq[i] != null)
					model.setDgCntrSeq(dgCntrSeq[i]);
				if (cnCustAddr[i] != null)
					model.setCnCustAddr(cnCustAddr[i]);
				if (shCustSeq[i] != null)
					model.setShCustSeq(shCustSeq[i]);
				if (shCustZipId[i] != null)
					model.setShCustZipId(shCustZipId[i]);
				if (shCustFaxNo[i] != null)
					model.setShCustFaxNo(shCustFaxNo[i]);
				if (cnCustCtyNm[i] != null)
					model.setCnCustCtyNm(cnCustCtyNm[i]);
				if (cnCustSteCd[i] != null)
					model.setCnCustSteCd(cnCustSteCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (shCstmsDeclCntCd[i] != null)
					model.setShCstmsDeclCntCd(shCstmsDeclCntCd[i]);
				if (shCustCntCd[i] != null)
					model.setShCustCntCd(shCustCntCd[i]);
				if (shCustAddr[i] != null)
					model.setShCustAddr(shCustAddr[i]);
				if (declNm[i] != null)
					model.setDeclNm(declNm[i]);
				if (cnCustEml[i] != null)
					model.setCnCustEml(cnCustEml[i]);
				if (shCustCtyNm[i] != null)
					model.setShCustCtyNm(shCustCtyNm[i]);
				if (shCustSteCd[i] != null)
					model.setShCustSteCd(shCustSteCd[i]);
				if (shCustEml[i] != null)
					model.setShCustEml(shCustEml[i]);
				if (cnCustCntCd[i] != null)
					model.setCnCustCntCd(cnCustCntCd[i]);
				if (cnCustFaxNo[i] != null)
					model.setCnCustFaxNo(cnCustFaxNo[i]);
				if (cnPhnNo[i] != null)
					model.setCnPhnNo(cnPhnNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (shPhnNo[i] != null)
					model.setShPhnNo(shPhnNo[i]);
				if (dgCntrOrdSeq[i] != null)
					model.setDgCntrOrdSeq(dgCntrOrdSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDeclarantCustomerInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DeclarantCustomerInfoVO[]
	 */
	public DeclarantCustomerInfoVO[] getDeclarantCustomerInfoVOs(){
		DeclarantCustomerInfoVO[] vos = (DeclarantCustomerInfoVO[])models.toArray(new DeclarantCustomerInfoVO[models.size()]);
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
		this.cnCustNm = this.cnCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shDgDeclSeq = this.shDgDeclSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq = this.dcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustZipId = this.cnCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustSeq = this.cnCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnDgDeclSeq = this.cnDgDeclSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustNm = this.shCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCstmsDeclCntCd = this.cnCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrSeq = this.dgCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustAddr = this.cnCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustSeq = this.shCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustZipId = this.shCustZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustFaxNo = this.shCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustCtyNm = this.cnCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustSteCd = this.cnCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCstmsDeclCntCd = this.shCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustCntCd = this.shCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustAddr = this.shCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.declNm = this.declNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustEml = this.cnCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustCtyNm = this.shCustCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustSteCd = this.shCustSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustEml = this.shCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustCntCd = this.cnCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustFaxNo = this.cnCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnPhnNo = this.cnPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shPhnNo = this.shPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrOrdSeq = this.dgCntrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
