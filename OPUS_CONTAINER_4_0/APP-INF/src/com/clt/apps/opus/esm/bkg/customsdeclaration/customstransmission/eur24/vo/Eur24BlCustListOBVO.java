/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24BlCustListOBVO.java
*@FileTitle : Eur24BlCustListOBVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.04
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.08.04 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Eur24BlCustListOBVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eur24BlCustListOBVO> models = new ArrayList<Eur24BlCustListOBVO>();
	
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
	private String blNo = null;
	/* Column Info */
	private String custCtyNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blPtName = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cstmsPortCd = null;
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
	private String creUsrId = null;
	/* Column Info */
	private String blPtStreet = null;
	/* Column Info */
	private String blPtCity = null;
	/* Column Info */
	private String eoriNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eur24BlCustListOBVO() {}

	public Eur24BlCustListOBVO(String ibflag, String pagerows, String blPtType, String blPtTin, String blPtEori, String blPtName, String blPtAddress, String blPtStreet, String blPtCity, String blPtPostalCd, String blPtCntCd, String vslCd, String skdVoyNo, String skdDirCd, String blNo, String cstmsPortCd, String bkgCustTpCd, String trdrIdNo, String eoriNo, String custNm, String custAddr, String custCtyNm, String cstmsDeclCntCd, String custZipId, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.vslCd = vslCd;
		this.blPtAddress = blPtAddress;
		this.custNm = custNm;
		this.blPtEori = blPtEori;
		this.creDt = creDt;
		this.blPtCntCd = blPtCntCd;
		this.blNo = blNo;
		this.custCtyNm = custCtyNm;
		this.pagerows = pagerows;
		this.blPtName = blPtName;
		this.ibflag = ibflag;
		this.bkgCustTpCd = bkgCustTpCd;
		this.updUsrId = updUsrId;
		this.cstmsPortCd = cstmsPortCd;
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
		this.creUsrId = creUsrId;
		this.blPtStreet = blPtStreet;
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
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cust_cty_nm", getCustCtyNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_pt_name", getBlPtName());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
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
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bl_pt_street", getBlPtStreet());
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
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cust_cty_nm", "custCtyNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_pt_name", "blPtName");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
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
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bl_pt_street", "blPtStreet");
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
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
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCustCtyNm(JSPUtil.getParameter(request, prefix + "cust_cty_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlPtName(JSPUtil.getParameter(request, prefix + "bl_pt_name", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
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
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBlPtStreet(JSPUtil.getParameter(request, prefix + "bl_pt_street", ""));
		setBlPtCity(JSPUtil.getParameter(request, prefix + "bl_pt_city", ""));
		setEoriNo(JSPUtil.getParameter(request, prefix + "eori_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24BlCustListOBVO[]
	 */
	public Eur24BlCustListOBVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24BlCustListOBVO[]
	 */
	public Eur24BlCustListOBVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24BlCustListOBVO model = null;
		
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
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] custCtyNm = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blPtName = (JSPUtil.getParameter(request, prefix	+ "bl_pt_name", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
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
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] blPtStreet = (JSPUtil.getParameter(request, prefix	+ "bl_pt_street", length));
			String[] blPtCity = (JSPUtil.getParameter(request, prefix	+ "bl_pt_city", length));
			String[] eoriNo = (JSPUtil.getParameter(request, prefix	+ "eori_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eur24BlCustListOBVO();
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
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (custCtyNm[i] != null)
					model.setCustCtyNm(custCtyNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blPtName[i] != null)
					model.setBlPtName(blPtName[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
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
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (blPtStreet[i] != null)
					model.setBlPtStreet(blPtStreet[i]);
				if (blPtCity[i] != null)
					model.setBlPtCity(blPtCity[i]);
				if (eoriNo[i] != null)
					model.setEoriNo(eoriNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24BlCustListOBVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24BlCustListOBVO[]
	 */
	public Eur24BlCustListOBVO[] getEur24BlCustListOBVOs(){
		Eur24BlCustListOBVO[] vos = (Eur24BlCustListOBVO[])models.toArray(new Eur24BlCustListOBVO[models.size()]);
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
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNm = this.custCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtName = this.blPtName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtStreet = this.blPtStreet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtCity = this.blPtCity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eoriNo = this.eoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
