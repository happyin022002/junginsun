/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : searchBlCustVO.java
*@FileTitle : searchBlCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo;

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

public class searchBlCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<searchBlCustVO> models = new ArrayList<searchBlCustVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String blPtAddress = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String blPtEori = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String blPtCntCd = null;
	/* Column Info */
	private String custCtyNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blPtName = null;
	/* Column Info */
	private String blPtFaxNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String blPtConName = null;
	/* Column Info */
	private String blPtEmNo = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custZipId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String blPtTin = null;
	/* Column Info */
	private String cstmsDeclCntCd = null;
	/* Column Info */
	private String trdrIdNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String blPtType = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String blPtPostalCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String blPtStreet = null;
	/* Column Info */
	private String blPtTelNo = null;
	/* Column Info */
	private String blPtCity = null;
	/* Column Info */
	private String eoriNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public searchBlCustVO() {}

	public searchBlCustVO(String ibflag, String pagerows, String blPtType, String blPtTin, String blPtEori, String blPtName, String blPtAddress, String blPtStreet, String blPtCity, String blPtPostalCd, String blPtCntCd, String vslCd, String skdVoyNo, String skdDirCd, String bkgNo, String polCd, String bkgCustTpCd, String trdrIdNo, String eoriNo, String custNm, String custAddr, String custCtyNm, String cstmsDeclCntCd, String custZipId, String creUsrId, String creDt, String updUsrId, String updDt, String blPtConName, String blPtFaxNo, String blPtEmNo, String blPtTelNo) {
		this.vslCd = vslCd;
		this.blPtAddress = blPtAddress;
		this.custNm = custNm;
		this.blPtEori = blPtEori;
		this.creDt = creDt;
		this.blPtCntCd = blPtCntCd;
		this.custCtyNm = custCtyNm;
		this.pagerows = pagerows;
		this.blPtName = blPtName;
		this.blPtFaxNo = blPtFaxNo;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.blPtConName = blPtConName;
		this.blPtEmNo = blPtEmNo;
		this.bkgCustTpCd = bkgCustTpCd;
		this.updUsrId = updUsrId;
		this.custZipId = custZipId;
		this.updDt = updDt;
		this.blPtTin = blPtTin;
		this.cstmsDeclCntCd = cstmsDeclCntCd;
		this.trdrIdNo = trdrIdNo;
		this.skdVoyNo = skdVoyNo;
		this.custAddr = custAddr;
		this.blPtType = blPtType;
		this.skdDirCd = skdDirCd;
		this.blPtPostalCd = blPtPostalCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.blPtStreet = blPtStreet;
		this.blPtTelNo = blPtTelNo;
		this.blPtCity = blPtCity;
		this.eoriNo = eoriNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bl_pt_address", getBlPtAddress());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("bl_pt_eori", getBlPtEori());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bl_pt_cnt_cd", getBlPtCntCd());
		this.hashColumns.put("cust_cty_nm", getCustCtyNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_pt_name", getBlPtName());
		this.hashColumns.put("bl_pt_fax_no", getBlPtFaxNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bl_pt_con_name", getBlPtConName());
		this.hashColumns.put("bl_pt_em_no", getBlPtEmNo());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_zip_id", getCustZipId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bl_pt_tin", getBlPtTin());
		this.hashColumns.put("cstms_decl_cnt_cd", getCstmsDeclCntCd());
		this.hashColumns.put("trdr_id_no", getTrdrIdNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("bl_pt_type", getBlPtType());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("bl_pt_postal_cd", getBlPtPostalCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bl_pt_street", getBlPtStreet());
		this.hashColumns.put("bl_pt_tel_no", getBlPtTelNo());
		this.hashColumns.put("bl_pt_city", getBlPtCity());
		this.hashColumns.put("eori_no", getEoriNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bl_pt_address", "blPtAddress");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bl_pt_eori", "blPtEori");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bl_pt_cnt_cd", "blPtCntCd");
		this.hashFields.put("cust_cty_nm", "custCtyNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_pt_name", "blPtName");
		this.hashFields.put("bl_pt_fax_no", "blPtFaxNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bl_pt_con_name", "blPtConName");
		this.hashFields.put("bl_pt_em_no", "blPtEmNo");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_zip_id", "custZipId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bl_pt_tin", "blPtTin");
		this.hashFields.put("cstms_decl_cnt_cd", "cstmsDeclCntCd");
		this.hashFields.put("trdr_id_no", "trdrIdNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("bl_pt_type", "blPtType");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("bl_pt_postal_cd", "blPtPostalCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bl_pt_street", "blPtStreet");
		this.hashFields.put("bl_pt_tel_no", "blPtTelNo");
		this.hashFields.put("bl_pt_city", "blPtCity");
		this.hashFields.put("eori_no", "eoriNo");
		return this.hashFields;
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
	 * @return blPtAddress
	 */
	public String getBlPtAddress() {
		return this.blPtAddress;
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
	 * @return blPtEori
	 */
	public String getBlPtEori() {
		return this.blPtEori;
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
	 * @return blPtCntCd
	 */
	public String getBlPtCntCd() {
		return this.blPtCntCd;
	}
	
	/**
	 * Column Info
	 * @return custCtyNm
	 */
	public String getCustCtyNm() {
		return this.custCtyNm;
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
	 * @return blPtName
	 */
	public String getBlPtName() {
		return this.blPtName;
	}
	
	/**
	 * Column Info
	 * @return blPtFaxNo
	 */
	public String getBlPtFaxNo() {
		return this.blPtFaxNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return blPtConName
	 */
	public String getBlPtConName() {
		return this.blPtConName;
	}
	
	/**
	 * Column Info
	 * @return blPtEmNo
	 */
	public String getBlPtEmNo() {
		return this.blPtEmNo;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return custZipId
	 */
	public String getCustZipId() {
		return this.custZipId;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return blPtTin
	 */
	public String getBlPtTin() {
		return this.blPtTin;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclCntCd
	 */
	public String getCstmsDeclCntCd() {
		return this.cstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @return trdrIdNo
	 */
	public String getTrdrIdNo() {
		return this.trdrIdNo;
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
	 * @return custAddr
	 */
	public String getCustAddr() {
		return this.custAddr;
	}
	
	/**
	 * Column Info
	 * @return blPtType
	 */
	public String getBlPtType() {
		return this.blPtType;
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
	 * @return blPtPostalCd
	 */
	public String getBlPtPostalCd() {
		return this.blPtPostalCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return blPtStreet
	 */
	public String getBlPtStreet() {
		return this.blPtStreet;
	}
	
	/**
	 * Column Info
	 * @return blPtTelNo
	 */
	public String getBlPtTelNo() {
		return this.blPtTelNo;
	}
	
	/**
	 * Column Info
	 * @return blPtCity
	 */
	public String getBlPtCity() {
		return this.blPtCity;
	}
	
	/**
	 * Column Info
	 * @return eoriNo
	 */
	public String getEoriNo() {
		return this.eoriNo;
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
	 * @param blPtAddress
	 */
	public void setBlPtAddress(String blPtAddress) {
		this.blPtAddress = blPtAddress;
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
	 * @param blPtEori
	 */
	public void setBlPtEori(String blPtEori) {
		this.blPtEori = blPtEori;
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
	 * @param blPtCntCd
	 */
	public void setBlPtCntCd(String blPtCntCd) {
		this.blPtCntCd = blPtCntCd;
	}
	
	/**
	 * Column Info
	 * @param custCtyNm
	 */
	public void setCustCtyNm(String custCtyNm) {
		this.custCtyNm = custCtyNm;
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
	 * @param blPtName
	 */
	public void setBlPtName(String blPtName) {
		this.blPtName = blPtName;
	}
	
	/**
	 * Column Info
	 * @param blPtFaxNo
	 */
	public void setBlPtFaxNo(String blPtFaxNo) {
		this.blPtFaxNo = blPtFaxNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param blPtConName
	 */
	public void setBlPtConName(String blPtConName) {
		this.blPtConName = blPtConName;
	}
	
	/**
	 * Column Info
	 * @param blPtEmNo
	 */
	public void setBlPtEmNo(String blPtEmNo) {
		this.blPtEmNo = blPtEmNo;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param custZipId
	 */
	public void setCustZipId(String custZipId) {
		this.custZipId = custZipId;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param blPtTin
	 */
	public void setBlPtTin(String blPtTin) {
		this.blPtTin = blPtTin;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclCntCd
	 */
	public void setCstmsDeclCntCd(String cstmsDeclCntCd) {
		this.cstmsDeclCntCd = cstmsDeclCntCd;
	}
	
	/**
	 * Column Info
	 * @param trdrIdNo
	 */
	public void setTrdrIdNo(String trdrIdNo) {
		this.trdrIdNo = trdrIdNo;
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
	 * @param custAddr
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	
	/**
	 * Column Info
	 * @param blPtType
	 */
	public void setBlPtType(String blPtType) {
		this.blPtType = blPtType;
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
	 * @param blPtPostalCd
	 */
	public void setBlPtPostalCd(String blPtPostalCd) {
		this.blPtPostalCd = blPtPostalCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param blPtStreet
	 */
	public void setBlPtStreet(String blPtStreet) {
		this.blPtStreet = blPtStreet;
	}
	
	/**
	 * Column Info
	 * @param blPtTelNo
	 */
	public void setBlPtTelNo(String blPtTelNo) {
		this.blPtTelNo = blPtTelNo;
	}
	
	/**
	 * Column Info
	 * @param blPtCity
	 */
	public void setBlPtCity(String blPtCity) {
		this.blPtCity = blPtCity;
	}
	
	/**
	 * Column Info
	 * @param eoriNo
	 */
	public void setEoriNo(String eoriNo) {
		this.eoriNo = eoriNo;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setBlPtAddress(JSPUtil.getParameter(request, prefix + "bl_pt_address", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setBlPtEori(JSPUtil.getParameter(request, prefix + "bl_pt_eori", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setBlPtCntCd(JSPUtil.getParameter(request, prefix + "bl_pt_cnt_cd", ""));
		setCustCtyNm(JSPUtil.getParameter(request, prefix + "cust_cty_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlPtName(JSPUtil.getParameter(request, prefix + "bl_pt_name", ""));
		setBlPtFaxNo(JSPUtil.getParameter(request, prefix + "bl_pt_fax_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBlPtConName(JSPUtil.getParameter(request, prefix + "bl_pt_con_name", ""));
		setBlPtEmNo(JSPUtil.getParameter(request, prefix + "bl_pt_em_no", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustZipId(JSPUtil.getParameter(request, prefix + "cust_zip_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setBlPtTin(JSPUtil.getParameter(request, prefix + "bl_pt_tin", ""));
		setCstmsDeclCntCd(JSPUtil.getParameter(request, prefix + "cstms_decl_cnt_cd", ""));
		setTrdrIdNo(JSPUtil.getParameter(request, prefix + "trdr_id_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCustAddr(JSPUtil.getParameter(request, prefix + "cust_addr", ""));
		setBlPtType(JSPUtil.getParameter(request, prefix + "bl_pt_type", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setBlPtPostalCd(JSPUtil.getParameter(request, prefix + "bl_pt_postal_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBlPtStreet(JSPUtil.getParameter(request, prefix + "bl_pt_street", ""));
		setBlPtTelNo(JSPUtil.getParameter(request, prefix + "bl_pt_tel_no", ""));
		setBlPtCity(JSPUtil.getParameter(request, prefix + "bl_pt_city", ""));
		setEoriNo(JSPUtil.getParameter(request, prefix + "eori_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchBlCustVO[]
	 */
	public searchBlCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchBlCustVO[]
	 */
	public searchBlCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		searchBlCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] blPtAddress = (JSPUtil.getParameter(request, prefix	+ "bl_pt_address", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] blPtEori = (JSPUtil.getParameter(request, prefix	+ "bl_pt_eori", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] blPtCntCd = (JSPUtil.getParameter(request, prefix	+ "bl_pt_cnt_cd", length));
			String[] custCtyNm = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blPtName = (JSPUtil.getParameter(request, prefix	+ "bl_pt_name", length));
			String[] blPtFaxNo = (JSPUtil.getParameter(request, prefix	+ "bl_pt_fax_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] blPtConName = (JSPUtil.getParameter(request, prefix	+ "bl_pt_con_name", length));
			String[] blPtEmNo = (JSPUtil.getParameter(request, prefix	+ "bl_pt_em_no", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custZipId = (JSPUtil.getParameter(request, prefix	+ "cust_zip_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] blPtTin = (JSPUtil.getParameter(request, prefix	+ "bl_pt_tin", length));
			String[] cstmsDeclCntCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_cnt_cd", length));
			String[] trdrIdNo = (JSPUtil.getParameter(request, prefix	+ "trdr_id_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr", length));
			String[] blPtType = (JSPUtil.getParameter(request, prefix	+ "bl_pt_type", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] blPtPostalCd = (JSPUtil.getParameter(request, prefix	+ "bl_pt_postal_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] blPtStreet = (JSPUtil.getParameter(request, prefix	+ "bl_pt_street", length));
			String[] blPtTelNo = (JSPUtil.getParameter(request, prefix	+ "bl_pt_tel_no", length));
			String[] blPtCity = (JSPUtil.getParameter(request, prefix	+ "bl_pt_city", length));
			String[] eoriNo = (JSPUtil.getParameter(request, prefix	+ "eori_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new searchBlCustVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (blPtAddress[i] != null)
					model.setBlPtAddress(blPtAddress[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (blPtEori[i] != null)
					model.setBlPtEori(blPtEori[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (blPtCntCd[i] != null)
					model.setBlPtCntCd(blPtCntCd[i]);
				if (custCtyNm[i] != null)
					model.setCustCtyNm(custCtyNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blPtName[i] != null)
					model.setBlPtName(blPtName[i]);
				if (blPtFaxNo[i] != null)
					model.setBlPtFaxNo(blPtFaxNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (blPtConName[i] != null)
					model.setBlPtConName(blPtConName[i]);
				if (blPtEmNo[i] != null)
					model.setBlPtEmNo(blPtEmNo[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custZipId[i] != null)
					model.setCustZipId(custZipId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (blPtTin[i] != null)
					model.setBlPtTin(blPtTin[i]);
				if (cstmsDeclCntCd[i] != null)
					model.setCstmsDeclCntCd(cstmsDeclCntCd[i]);
				if (trdrIdNo[i] != null)
					model.setTrdrIdNo(trdrIdNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (blPtType[i] != null)
					model.setBlPtType(blPtType[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (blPtPostalCd[i] != null)
					model.setBlPtPostalCd(blPtPostalCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (blPtStreet[i] != null)
					model.setBlPtStreet(blPtStreet[i]);
				if (blPtTelNo[i] != null)
					model.setBlPtTelNo(blPtTelNo[i]);
				if (blPtCity[i] != null)
					model.setBlPtCity(blPtCity[i]);
				if (eoriNo[i] != null)
					model.setEoriNo(eoriNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchBlCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchBlCustVO[]
	 */
	public searchBlCustVO[] getsearchBlCustVOs(){
		searchBlCustVO[] vos = (searchBlCustVO[])models.toArray(new searchBlCustVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtAddress = this.blPtAddress .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtEori = this.blPtEori .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtCntCd = this.blPtCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNm = this.custCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtName = this.blPtName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtFaxNo = this.blPtFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtConName = this.blPtConName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtEmNo = this.blPtEmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipId = this.custZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtTin = this.blPtTin .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclCntCd = this.cstmsDeclCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdrIdNo = this.trdrIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtType = this.blPtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtPostalCd = this.blPtPostalCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtStreet = this.blPtStreet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtTelNo = this.blPtTelNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtCity = this.blPtCity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eoriNo = this.eoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
