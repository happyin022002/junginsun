/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RocsSearchBlInfoVO.java
*@FileTitle : RocsSearchBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class RocsSearchBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsSearchBlInfoVO> models = new ArrayList<RocsSearchBlInfoVO>();
	
	/* Column Info */
	private String cneeEoriNo = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String ntfyCstmsDeclCntCd = null;
	/* Column Info */
	private String cneeCustSeq = null;
	/* Column Info */
	private String shprCstmsDeclCntCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ntfyCtyNm = null;
	/* Column Info */
	private String shprZipId = null;
	/* Column Info */
	private String cneeCstmsDeclCntCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cneeCntCd = null;
	/* Column Info */
	private String ntfyAddr2 = null;
	/* Column Info */
	private String shprStNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String shprCtyNm = null;
	/* Column Info */
	private String ntfyAddr1 = null;
	/* Column Info */
	private String cneeZipId = null;
	/* Column Info */
	private String ntfyEoriNo = null;
	/* Column Info */
	private String ntfyCntCd = null;
	/* Column Info */
	private String cneeCtyNm = null;
	/* Column Info */
	private String cneeStNm = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cneeAddr1 = null;
	/* Column Info */
	private String custEml = null;
	/* Column Info */
	private String cneeAddr2 = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String ntfyCustSeq = null;
	/* Column Info */
	private String ntfyZipId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String t1DocCd = null;
	/* Column Info */
	private String shprAddr2 = null;
	/* Column Info */
	private String shprCustSeq = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String shprEoriNo = null;
	/* Column Info */
	private String shprAddr1 = null;
	/* Column Info */
	private String vvdNumber = null;
	/* Column Info */
	private String ntfyStNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsSearchBlInfoVO() {}

	public RocsSearchBlInfoVO(String ibflag, String pagerows, String bkgNo, String blNo, String faxNo, String custEml, String shprAddr1, String shprAddr2, String cneeAddr1, String cneeAddr2, String ntfyAddr1, String ntfyAddr2, String vslCd, String skdVoyNo, String skdDirCd, String frtTermCd, String t1DocCd, String vvdNumber, String shprCntCd, String shprCustSeq, String cneeCntCd, String cneeCustSeq, String ntfyCntCd, String ntfyCustSeq, String shprEoriNo, String shprCtyNm, String shprCstmsDeclCntCd, String shprZipId, String shprStNm, String cneeEoriNo, String cneeCtyNm, String cneeCstmsDeclCntCd, String cneeZipId, String cneeStNm, String ntfyEoriNo, String ntfyCtyNm, String ntfyCstmsDeclCntCd, String ntfyZipId, String ntfyStNm) {
		this.cneeEoriNo = cneeEoriNo;
		this.vslCd = vslCd;
		this.ntfyCstmsDeclCntCd = ntfyCstmsDeclCntCd;
		this.cneeCustSeq = cneeCustSeq;
		this.shprCstmsDeclCntCd = shprCstmsDeclCntCd;
		this.blNo = blNo;
		this.ntfyCtyNm = ntfyCtyNm;
		this.shprZipId = shprZipId;
		this.cneeCstmsDeclCntCd = cneeCstmsDeclCntCd;
		this.pagerows = pagerows;
		this.cneeCntCd = cneeCntCd;
		this.ntfyAddr2 = ntfyAddr2;
		this.shprStNm = shprStNm;
		this.ibflag = ibflag;
		this.shprCtyNm = shprCtyNm;
		this.ntfyAddr1 = ntfyAddr1;
		this.cneeZipId = cneeZipId;
		this.ntfyEoriNo = ntfyEoriNo;
		this.ntfyCntCd = ntfyCntCd;
		this.cneeCtyNm = cneeCtyNm;
		this.cneeStNm = cneeStNm;
		this.frtTermCd = frtTermCd;
		this.shprCntCd = shprCntCd;
		this.skdVoyNo = skdVoyNo;
		this.cneeAddr1 = cneeAddr1;
		this.custEml = custEml;
		this.cneeAddr2 = cneeAddr2;
		this.skdDirCd = skdDirCd;
		this.ntfyCustSeq = ntfyCustSeq;
		this.ntfyZipId = ntfyZipId;
		this.bkgNo = bkgNo;
		this.t1DocCd = t1DocCd;
		this.shprAddr2 = shprAddr2;
		this.shprCustSeq = shprCustSeq;
		this.faxNo = faxNo;
		this.shprEoriNo = shprEoriNo;
		this.shprAddr1 = shprAddr1;
		this.vvdNumber = vvdNumber;
		this.ntfyStNm = ntfyStNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnee_eori_no", getCneeEoriNo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ntfy_cstms_decl_cnt_cd", getNtfyCstmsDeclCntCd());
		this.hashColumns.put("cnee_cust_seq", getCneeCustSeq());
		this.hashColumns.put("shpr_cstms_decl_cnt_cd", getShprCstmsDeclCntCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ntfy_cty_nm", getNtfyCtyNm());
		this.hashColumns.put("shpr_zip_id", getShprZipId());
		this.hashColumns.put("cnee_cstms_decl_cnt_cd", getCneeCstmsDeclCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
		this.hashColumns.put("ntfy_addr2", getNtfyAddr2());
		this.hashColumns.put("shpr_st_nm", getShprStNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("shpr_cty_nm", getShprCtyNm());
		this.hashColumns.put("ntfy_addr1", getNtfyAddr1());
		this.hashColumns.put("cnee_zip_id", getCneeZipId());
		this.hashColumns.put("ntfy_eori_no", getNtfyEoriNo());
		this.hashColumns.put("ntfy_cnt_cd", getNtfyCntCd());
		this.hashColumns.put("cnee_cty_nm", getCneeCtyNm());
		this.hashColumns.put("cnee_st_nm", getCneeStNm());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cnee_addr1", getCneeAddr1());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("cnee_addr2", getCneeAddr2());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ntfy_cust_seq", getNtfyCustSeq());
		this.hashColumns.put("ntfy_zip_id", getNtfyZipId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("t1_doc_cd", getT1DocCd());
		this.hashColumns.put("shpr_addr2", getShprAddr2());
		this.hashColumns.put("shpr_cust_seq", getShprCustSeq());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("shpr_eori_no", getShprEoriNo());
		this.hashColumns.put("shpr_addr1", getShprAddr1());
		this.hashColumns.put("vvd_number", getVvdNumber());
		this.hashColumns.put("ntfy_st_nm", getNtfyStNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnee_eori_no", "cneeEoriNo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ntfy_cstms_decl_cnt_cd", "ntfyCstmsDeclCntCd");
		this.hashFields.put("cnee_cust_seq", "cneeCustSeq");
		this.hashFields.put("shpr_cstms_decl_cnt_cd", "shprCstmsDeclCntCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ntfy_cty_nm", "ntfyCtyNm");
		this.hashFields.put("shpr_zip_id", "shprZipId");
		this.hashFields.put("cnee_cstms_decl_cnt_cd", "cneeCstmsDeclCntCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("ntfy_addr2", "ntfyAddr2");
		this.hashFields.put("shpr_st_nm", "shprStNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("shpr_cty_nm", "shprCtyNm");
		this.hashFields.put("ntfy_addr1", "ntfyAddr1");
		this.hashFields.put("cnee_zip_id", "cneeZipId");
		this.hashFields.put("ntfy_eori_no", "ntfyEoriNo");
		this.hashFields.put("ntfy_cnt_cd", "ntfyCntCd");
		this.hashFields.put("cnee_cty_nm", "cneeCtyNm");
		this.hashFields.put("cnee_st_nm", "cneeStNm");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cnee_addr1", "cneeAddr1");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("cnee_addr2", "cneeAddr2");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ntfy_cust_seq", "ntfyCustSeq");
		this.hashFields.put("ntfy_zip_id", "ntfyZipId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("t1_doc_cd", "t1DocCd");
		this.hashFields.put("shpr_addr2", "shprAddr2");
		this.hashFields.put("shpr_cust_seq", "shprCustSeq");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("shpr_eori_no", "shprEoriNo");
		this.hashFields.put("shpr_addr1", "shprAddr1");
		this.hashFields.put("vvd_number", "vvdNumber");
		this.hashFields.put("ntfy_st_nm", "ntfyStNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cneeEoriNo
	 */
	public String getCneeEoriNo() {
		return this.cneeEoriNo;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyCstmsDeclCntCd
	 */
	public String getNtfyCstmsDeclCntCd() {
		return this.ntfyCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @return cneeCustSeq
	 */
	public String getCneeCustSeq() {
		return this.cneeCustSeq;
	}
	
	/**
	 * Column Info
	 * @return shprCstmsDeclCntCd
	 */
	public String getShprCstmsDeclCntCd() {
		return this.shprCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return ntfyCtyNm
	 */
	public String getNtfyCtyNm() {
		return this.ntfyCtyNm;
	}
	
	/**
	 * Column Info
	 * @return shprZipId
	 */
	public String getShprZipId() {
		return this.shprZipId;
	}
	
	/**
	 * Column Info
	 * @return cneeCstmsDeclCntCd
	 */
	public String getCneeCstmsDeclCntCd() {
		return this.cneeCstmsDeclCntCd;
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
	 * @return cneeCntCd
	 */
	public String getCneeCntCd() {
		return this.cneeCntCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyAddr2
	 */
	public String getNtfyAddr2() {
		return this.ntfyAddr2;
	}
	
	/**
	 * Column Info
	 * @return shprStNm
	 */
	public String getShprStNm() {
		return this.shprStNm;
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
	 * @return shprCtyNm
	 */
	public String getShprCtyNm() {
		return this.shprCtyNm;
	}
	
	/**
	 * Column Info
	 * @return ntfyAddr1
	 */
	public String getNtfyAddr1() {
		return this.ntfyAddr1;
	}
	
	/**
	 * Column Info
	 * @return cneeZipId
	 */
	public String getCneeZipId() {
		return this.cneeZipId;
	}
	
	/**
	 * Column Info
	 * @return ntfyEoriNo
	 */
	public String getNtfyEoriNo() {
		return this.ntfyEoriNo;
	}
	
	/**
	 * Column Info
	 * @return ntfyCntCd
	 */
	public String getNtfyCntCd() {
		return this.ntfyCntCd;
	}
	
	/**
	 * Column Info
	 * @return cneeCtyNm
	 */
	public String getCneeCtyNm() {
		return this.cneeCtyNm;
	}
	
	/**
	 * Column Info
	 * @return cneeStNm
	 */
	public String getCneeStNm() {
		return this.cneeStNm;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr1
	 */
	public String getCneeAddr1() {
		return this.cneeAddr1;
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
	 * @return cneeAddr2
	 */
	public String getCneeAddr2() {
		return this.cneeAddr2;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyCustSeq
	 */
	public String getNtfyCustSeq() {
		return this.ntfyCustSeq;
	}
	
	/**
	 * Column Info
	 * @return ntfyZipId
	 */
	public String getNtfyZipId() {
		return this.ntfyZipId;
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
	 * @return t1DocCd
	 */
	public String getT1DocCd() {
		return this.t1DocCd;
	}
	
	/**
	 * Column Info
	 * @return shprAddr2
	 */
	public String getShprAddr2() {
		return this.shprAddr2;
	}
	
	/**
	 * Column Info
	 * @return shprCustSeq
	 */
	public String getShprCustSeq() {
		return this.shprCustSeq;
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
	 * @return shprEoriNo
	 */
	public String getShprEoriNo() {
		return this.shprEoriNo;
	}
	
	/**
	 * Column Info
	 * @return shprAddr1
	 */
	public String getShprAddr1() {
		return this.shprAddr1;
	}
	
	/**
	 * Column Info
	 * @return vvdNumber
	 */
	public String getVvdNumber() {
		return this.vvdNumber;
	}
	
	/**
	 * Column Info
	 * @return ntfyStNm
	 */
	public String getNtfyStNm() {
		return this.ntfyStNm;
	}
	

	/**
	 * Column Info
	 * @param cneeEoriNo
	 */
	public void setCneeEoriNo(String cneeEoriNo) {
		this.cneeEoriNo = cneeEoriNo;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyCstmsDeclCntCd
	 */
	public void setNtfyCstmsDeclCntCd(String ntfyCstmsDeclCntCd) {
		this.ntfyCstmsDeclCntCd = ntfyCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @param cneeCustSeq
	 */
	public void setCneeCustSeq(String cneeCustSeq) {
		this.cneeCustSeq = cneeCustSeq;
	}
	
	/**
	 * Column Info
	 * @param shprCstmsDeclCntCd
	 */
	public void setShprCstmsDeclCntCd(String shprCstmsDeclCntCd) {
		this.shprCstmsDeclCntCd = shprCstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param ntfyCtyNm
	 */
	public void setNtfyCtyNm(String ntfyCtyNm) {
		this.ntfyCtyNm = ntfyCtyNm;
	}
	
	/**
	 * Column Info
	 * @param shprZipId
	 */
	public void setShprZipId(String shprZipId) {
		this.shprZipId = shprZipId;
	}
	
	/**
	 * Column Info
	 * @param cneeCstmsDeclCntCd
	 */
	public void setCneeCstmsDeclCntCd(String cneeCstmsDeclCntCd) {
		this.cneeCstmsDeclCntCd = cneeCstmsDeclCntCd;
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
	 * @param cneeCntCd
	 */
	public void setCneeCntCd(String cneeCntCd) {
		this.cneeCntCd = cneeCntCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddr2
	 */
	public void setNtfyAddr2(String ntfyAddr2) {
		this.ntfyAddr2 = ntfyAddr2;
	}
	
	/**
	 * Column Info
	 * @param shprStNm
	 */
	public void setShprStNm(String shprStNm) {
		this.shprStNm = shprStNm;
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
	 * @param shprCtyNm
	 */
	public void setShprCtyNm(String shprCtyNm) {
		this.shprCtyNm = shprCtyNm;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddr1
	 */
	public void setNtfyAddr1(String ntfyAddr1) {
		this.ntfyAddr1 = ntfyAddr1;
	}
	
	/**
	 * Column Info
	 * @param cneeZipId
	 */
	public void setCneeZipId(String cneeZipId) {
		this.cneeZipId = cneeZipId;
	}
	
	/**
	 * Column Info
	 * @param ntfyEoriNo
	 */
	public void setNtfyEoriNo(String ntfyEoriNo) {
		this.ntfyEoriNo = ntfyEoriNo;
	}
	
	/**
	 * Column Info
	 * @param ntfyCntCd
	 */
	public void setNtfyCntCd(String ntfyCntCd) {
		this.ntfyCntCd = ntfyCntCd;
	}
	
	/**
	 * Column Info
	 * @param cneeCtyNm
	 */
	public void setCneeCtyNm(String cneeCtyNm) {
		this.cneeCtyNm = cneeCtyNm;
	}
	
	/**
	 * Column Info
	 * @param cneeStNm
	 */
	public void setCneeStNm(String cneeStNm) {
		this.cneeStNm = cneeStNm;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr1
	 */
	public void setCneeAddr1(String cneeAddr1) {
		this.cneeAddr1 = cneeAddr1;
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
	 * @param cneeAddr2
	 */
	public void setCneeAddr2(String cneeAddr2) {
		this.cneeAddr2 = cneeAddr2;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyCustSeq
	 */
	public void setNtfyCustSeq(String ntfyCustSeq) {
		this.ntfyCustSeq = ntfyCustSeq;
	}
	
	/**
	 * Column Info
	 * @param ntfyZipId
	 */
	public void setNtfyZipId(String ntfyZipId) {
		this.ntfyZipId = ntfyZipId;
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
	 * @param t1DocCd
	 */
	public void setT1DocCd(String t1DocCd) {
		this.t1DocCd = t1DocCd;
	}
	
	/**
	 * Column Info
	 * @param shprAddr2
	 */
	public void setShprAddr2(String shprAddr2) {
		this.shprAddr2 = shprAddr2;
	}
	
	/**
	 * Column Info
	 * @param shprCustSeq
	 */
	public void setShprCustSeq(String shprCustSeq) {
		this.shprCustSeq = shprCustSeq;
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
	 * @param shprEoriNo
	 */
	public void setShprEoriNo(String shprEoriNo) {
		this.shprEoriNo = shprEoriNo;
	}
	
	/**
	 * Column Info
	 * @param shprAddr1
	 */
	public void setShprAddr1(String shprAddr1) {
		this.shprAddr1 = shprAddr1;
	}
	
	/**
	 * Column Info
	 * @param vvdNumber
	 */
	public void setVvdNumber(String vvdNumber) {
		this.vvdNumber = vvdNumber;
	}
	
	/**
	 * Column Info
	 * @param ntfyStNm
	 */
	public void setNtfyStNm(String ntfyStNm) {
		this.ntfyStNm = ntfyStNm;
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
		setCneeEoriNo(JSPUtil.getParameter(request, prefix + "cnee_eori_no", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setNtfyCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "ntfy_cstms_decl_cnt_cd", ""));
		setCneeCustSeq(JSPUtil.getParameter(request, prefix + "cnee_cust_seq", ""));
		setShprCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "shpr_cstms_decl_cnt_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setNtfyCtyNm(JSPUtil.getParameter(request, prefix + "ntfy_cty_nm", ""));
		setShprZipId(JSPUtil.getParameter(request, prefix + "shpr_zip_id", ""));
		setCneeCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "cnee_cstms_decl_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCneeCntCd(JSPUtil.getParameter(request, prefix + "cnee_cnt_cd", ""));
		setNtfyAddr2(JSPUtil.getParameter(request, prefix + "ntfy_addr2", ""));
		setShprStNm(JSPUtil.getParameter(request, prefix + "shpr_st_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setShprCtyNm(JSPUtil.getParameter(request, prefix + "shpr_cty_nm", ""));
		setNtfyAddr1(JSPUtil.getParameter(request, prefix + "ntfy_addr1", ""));
		setCneeZipId(JSPUtil.getParameter(request, prefix + "cnee_zip_id", ""));
		setNtfyEoriNo(JSPUtil.getParameter(request, prefix + "ntfy_eori_no", ""));
		setNtfyCntCd(JSPUtil.getParameter(request, prefix + "ntfy_cnt_cd", ""));
		setCneeCtyNm(JSPUtil.getParameter(request, prefix + "cnee_cty_nm", ""));
		setCneeStNm(JSPUtil.getParameter(request, prefix + "cnee_st_nm", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCneeAddr1(JSPUtil.getParameter(request, prefix + "cnee_addr1", ""));
		setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
		setCneeAddr2(JSPUtil.getParameter(request, prefix + "cnee_addr2", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setNtfyCustSeq(JSPUtil.getParameter(request, prefix + "ntfy_cust_seq", ""));
		setNtfyZipId(JSPUtil.getParameter(request, prefix + "ntfy_zip_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setT1DocCd(JSPUtil.getParameter(request, prefix + "t1_doc_cd", ""));
		setShprAddr2(JSPUtil.getParameter(request, prefix + "shpr_addr2", ""));
		setShprCustSeq(JSPUtil.getParameter(request, prefix + "shpr_cust_seq", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setShprEoriNo(JSPUtil.getParameter(request, prefix + "shpr_eori_no", ""));
		setShprAddr1(JSPUtil.getParameter(request, prefix + "shpr_addr1", ""));
		setVvdNumber(JSPUtil.getParameter(request, prefix + "vvd_number", ""));
		setNtfyStNm(JSPUtil.getParameter(request, prefix + "ntfy_st_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsSearchBlInfoVO[]
	 */
	public RocsSearchBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsSearchBlInfoVO[]
	 */
	public RocsSearchBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsSearchBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cneeEoriNo = (JSPUtil.getParameter(request, prefix	+ "cnee_eori_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ntfyCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cstms_decl_cnt_cd", length));
			String[] cneeCustSeq = (JSPUtil.getParameter(request, prefix	+ "cnee_cust_seq", length));
			String[] shprCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cstms_decl_cnt_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ntfyCtyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_cty_nm", length));
			String[] shprZipId = (JSPUtil.getParameter(request, prefix	+ "shpr_zip_id", length));
			String[] cneeCstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cstms_decl_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cneeCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_cd", length));
			String[] ntfyAddr2 = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr2", length));
			String[] shprStNm = (JSPUtil.getParameter(request, prefix	+ "shpr_st_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] shprCtyNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cty_nm", length));
			String[] ntfyAddr1 = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr1", length));
			String[] cneeZipId = (JSPUtil.getParameter(request, prefix	+ "cnee_zip_id", length));
			String[] ntfyEoriNo = (JSPUtil.getParameter(request, prefix	+ "ntfy_eori_no", length));
			String[] ntfyCntCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cnt_cd", length));
			String[] cneeCtyNm = (JSPUtil.getParameter(request, prefix	+ "cnee_cty_nm", length));
			String[] cneeStNm = (JSPUtil.getParameter(request, prefix	+ "cnee_st_nm", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cneeAddr1 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr1", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] cneeAddr2 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr2", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] ntfyCustSeq = (JSPUtil.getParameter(request, prefix	+ "ntfy_cust_seq", length));
			String[] ntfyZipId = (JSPUtil.getParameter(request, prefix	+ "ntfy_zip_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] t1DocCd = (JSPUtil.getParameter(request, prefix	+ "t1_doc_cd", length));
			String[] shprAddr2 = (JSPUtil.getParameter(request, prefix	+ "shpr_addr2", length));
			String[] shprCustSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_seq", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] shprEoriNo = (JSPUtil.getParameter(request, prefix	+ "shpr_eori_no", length));
			String[] shprAddr1 = (JSPUtil.getParameter(request, prefix	+ "shpr_addr1", length));
			String[] vvdNumber = (JSPUtil.getParameter(request, prefix	+ "vvd_number", length));
			String[] ntfyStNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_st_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsSearchBlInfoVO();
				if (cneeEoriNo[i] != null)
					model.setCneeEoriNo(cneeEoriNo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ntfyCstmsDeclCntCd[i] != null)
					model.setNtfyCstmsDeclCntCd(ntfyCstmsDeclCntCd[i]);
				if (cneeCustSeq[i] != null)
					model.setCneeCustSeq(cneeCustSeq[i]);
				if (shprCstmsDeclCntCd[i] != null)
					model.setShprCstmsDeclCntCd(shprCstmsDeclCntCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ntfyCtyNm[i] != null)
					model.setNtfyCtyNm(ntfyCtyNm[i]);
				if (shprZipId[i] != null)
					model.setShprZipId(shprZipId[i]);
				if (cneeCstmsDeclCntCd[i] != null)
					model.setCneeCstmsDeclCntCd(cneeCstmsDeclCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cneeCntCd[i] != null)
					model.setCneeCntCd(cneeCntCd[i]);
				if (ntfyAddr2[i] != null)
					model.setNtfyAddr2(ntfyAddr2[i]);
				if (shprStNm[i] != null)
					model.setShprStNm(shprStNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (shprCtyNm[i] != null)
					model.setShprCtyNm(shprCtyNm[i]);
				if (ntfyAddr1[i] != null)
					model.setNtfyAddr1(ntfyAddr1[i]);
				if (cneeZipId[i] != null)
					model.setCneeZipId(cneeZipId[i]);
				if (ntfyEoriNo[i] != null)
					model.setNtfyEoriNo(ntfyEoriNo[i]);
				if (ntfyCntCd[i] != null)
					model.setNtfyCntCd(ntfyCntCd[i]);
				if (cneeCtyNm[i] != null)
					model.setCneeCtyNm(cneeCtyNm[i]);
				if (cneeStNm[i] != null)
					model.setCneeStNm(cneeStNm[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cneeAddr1[i] != null)
					model.setCneeAddr1(cneeAddr1[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (cneeAddr2[i] != null)
					model.setCneeAddr2(cneeAddr2[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (ntfyCustSeq[i] != null)
					model.setNtfyCustSeq(ntfyCustSeq[i]);
				if (ntfyZipId[i] != null)
					model.setNtfyZipId(ntfyZipId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (t1DocCd[i] != null)
					model.setT1DocCd(t1DocCd[i]);
				if (shprAddr2[i] != null)
					model.setShprAddr2(shprAddr2[i]);
				if (shprCustSeq[i] != null)
					model.setShprCustSeq(shprCustSeq[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (shprEoriNo[i] != null)
					model.setShprEoriNo(shprEoriNo[i]);
				if (shprAddr1[i] != null)
					model.setShprAddr1(shprAddr1[i]);
				if (vvdNumber[i] != null)
					model.setVvdNumber(vvdNumber[i]);
				if (ntfyStNm[i] != null)
					model.setNtfyStNm(ntfyStNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsSearchBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsSearchBlInfoVO[]
	 */
	public RocsSearchBlInfoVO[] getRocsSearchBlInfoVOs(){
		RocsSearchBlInfoVO[] vos = (RocsSearchBlInfoVO[])models.toArray(new RocsSearchBlInfoVO[models.size()]);
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
		this.cneeEoriNo = this.cneeEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCstmsDeclCntCd = this.ntfyCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCustSeq = this.cneeCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCstmsDeclCntCd = this.shprCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCtyNm = this.ntfyCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprZipId = this.shprZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCstmsDeclCntCd = this.cneeCstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntCd = this.cneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr2 = this.ntfyAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprStNm = this.shprStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCtyNm = this.shprCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr1 = this.ntfyAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeZipId = this.cneeZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyEoriNo = this.ntfyEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCntCd = this.ntfyCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCtyNm = this.cneeCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeStNm = this.cneeStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr1 = this.cneeAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr2 = this.cneeAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCustSeq = this.ntfyCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyZipId = this.ntfyZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t1DocCd = this.t1DocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr2 = this.shprAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustSeq = this.shprCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprEoriNo = this.shprEoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr1 = this.shprAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNumber = this.vvdNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyStNm = this.ntfyStNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
