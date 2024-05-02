/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24BlCustListVO.java
*@FileTitle : Eur24BlCustListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.15
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.15 김경섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.vo;

import java.lang.reflect.Field;
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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Eur24BlCustListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eur24BlCustListVO> models = new ArrayList<Eur24BlCustListVO>();
	
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
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blPtName = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String markno = null;
	/* Column Info */
	private String stNm = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String eurCstmsPstId = null;
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
	private String ctyNm = null;
	/* Column Info */
	private String pstCntCd = null;
	/* Column Info */
	private String eoriNo = null;
	/* Column Info */
	private String descs = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eur24BlCustListVO() {}

	public Eur24BlCustListVO(String ibflag, String pagerows, String blPtType, String blPtTin, String blPtEori, String blPtName, String blPtAddress, String blPtStreet, String blPtCity, String blPtPostalCd, String blPtCntCd, String descs, String markno, String vslCd, String skdVoyNo, String skdDirCd, String blNo, String cstmsPortCd, String bkgCustTpCd, String trdrIdNo, String eoriNo, String custNm, String custAddr, String stNm, String ctyNm, String cstmsDeclCntCd, String eurCstmsPstId, String pstCntCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.vslCd = vslCd;
		this.blPtAddress = blPtAddress;
		this.custNm = custNm;
		this.blPtEori = blPtEori;
		this.creDt = creDt;
		this.blPtCntCd = blPtCntCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.blPtName = blPtName;
		this.ibflag = ibflag;
		this.markno = markno;
		this.stNm = stNm;
		this.bkgCustTpCd = bkgCustTpCd;
		this.updUsrId = updUsrId;
		this.cstmsPortCd = cstmsPortCd;
		this.updDt = updDt;
		this.eurCstmsPstId = eurCstmsPstId;
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
		this.ctyNm = ctyNm;
		this.pstCntCd = pstCntCd;
		this.eoriNo = eoriNo;
		this.descs = descs;
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
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_pt_name", getBlPtName());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("markno", getMarkno());
		this.hashColumns.put("st_nm", getStNm());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eur_cstms_pst_id", getEurCstmsPstId());
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
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("pst_cnt_cd", getPstCntCd());
		this.hashColumns.put("eori_no", getEoriNo());
		this.hashColumns.put("descs", getDescs());
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
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_pt_name", "blPtName");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("markno", "markno");
		this.hashFields.put("st_nm", "stNm");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("eur_cstms_pst_id", "eurCstmsPstId");
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
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("pst_cnt_cd", "pstCntCd");
		this.hashFields.put("eori_no", "eoriNo");
		this.hashFields.put("descs", "descs");
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
	 * @return markno
	 */
	public String getMarkno() {
		return this.markno;
	}
	
	/**
	 * Column Info
	 * @return stNm
	 */
	public String getStNm() {
		return this.stNm;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return eurCstmsPstId
	 */
	public String getEurCstmsPstId() {
		return this.eurCstmsPstId;
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
	 * @return ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
	}
	
	/**
	 * Column Info
	 * @return pstCntCd
	 */
	public String getPstCntCd() {
		return this.pstCntCd;
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
	 * @return descs
	 */
	public String getDescs() {
		return this.descs;
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
	 * @param markno
	 */
	public void setMarkno(String markno) {
		this.markno = markno;
	}
	
	/**
	 * Column Info
	 * @param stNm
	 */
	public void setStNm(String stNm) {
		this.stNm = stNm;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param eurCstmsPstId
	 */
	public void setEurCstmsPstId(String eurCstmsPstId) {
		this.eurCstmsPstId = eurCstmsPstId;
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
	 * @param ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
	}
	
	/**
	 * Column Info
	 * @param pstCntCd
	 */
	public void setPstCntCd(String pstCntCd) {
		this.pstCntCd = pstCntCd;
	}
	
	/**
	 * Column Info
	 * @param eoriNo
	 */
	public void setEoriNo(String eoriNo) {
		this.eoriNo = eoriNo;
	}
	
	/**
	 * Column Info
	 * @param descs
	 */
	public void setDescs(String descs) {
		this.descs = descs;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlPtName(JSPUtil.getParameter(request, prefix + "bl_pt_name", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMarkno(JSPUtil.getParameter(request, prefix + "markno", ""));
		setStNm(JSPUtil.getParameter(request, prefix + "st_nm", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setEurCstmsPstId(JSPUtil.getParameter(request, prefix + "eur_cstms_pst_id", ""));
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
		setCtyNm(JSPUtil.getParameter(request, prefix + "cty_nm", ""));
		setPstCntCd(JSPUtil.getParameter(request, prefix + "pst_cnt_cd", ""));
		setEoriNo(JSPUtil.getParameter(request, prefix + "eori_no", ""));
		setDescs(JSPUtil.getParameter(request, prefix + "descs", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24BlCustListVO[]
	 */
	public Eur24BlCustListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24BlCustListVO[]
	 */
	public Eur24BlCustListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24BlCustListVO model = null;
		
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
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blPtName = (JSPUtil.getParameter(request, prefix	+ "bl_pt_name", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] markno = (JSPUtil.getParameter(request, prefix	+ "markno", length));
			String[] stNm = (JSPUtil.getParameter(request, prefix	+ "st_nm", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] eurCstmsPstId = (JSPUtil.getParameter(request, prefix	+ "eur_cstms_pst_id", length));
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
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm", length));
			String[] pstCntCd = (JSPUtil.getParameter(request, prefix	+ "pst_cnt_cd", length));
			String[] eoriNo = (JSPUtil.getParameter(request, prefix	+ "eori_no", length));
			String[] descs = (JSPUtil.getParameter(request, prefix	+ "descs", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eur24BlCustListVO();
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
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blPtName[i] != null)
					model.setBlPtName(blPtName[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (markno[i] != null)
					model.setMarkno(markno[i]);
				if (stNm[i] != null)
					model.setStNm(stNm[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (eurCstmsPstId[i] != null)
					model.setEurCstmsPstId(eurCstmsPstId[i]);
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
				if (ctyNm[i] != null)
					model.setCtyNm(ctyNm[i]);
				if (pstCntCd[i] != null)
					model.setPstCntCd(pstCntCd[i]);
				if (eoriNo[i] != null)
					model.setEoriNo(eoriNo[i]);
				if (descs[i] != null)
					model.setDescs(descs[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24BlCustListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24BlCustListVO[]
	 */
	public Eur24BlCustListVO[] getEur24BlCustListVOs(){
		Eur24BlCustListVO[] vos = (Eur24BlCustListVO[])models.toArray(new Eur24BlCustListVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPtName = this.blPtName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.markno = this.markno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stNm = this.stNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurCstmsPstId = this.eurCstmsPstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstCntCd = this.pstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eoriNo = this.eoriNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.descs = this.descs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
