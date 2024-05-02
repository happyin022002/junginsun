/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchNodeDefaultSpInfoListVO.java
*@FileTitle : SearchNodeDefaultSpInfoListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo;

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

public class SearchNodeDefaultSpInfoListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchNodeDefaultSpInfoListVO> models = new ArrayList<SearchNodeDefaultSpInfoListVO>();
	
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String n4thVndrCntCd = null;
	/* Column Info */
	private String spName = null;
	/* Column Info */
	private String n4thVndrSeq = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String inclSubOfcFlg = null;
	/* Column Info */
	private String ydFctyTpPsdoYdFlg = null;
	/* Column Info */
	private String ydFctyTpBrgRmpFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String spCode = null;
	/* Column Info */
	private String n6thVndrSeq = null;
	/* Column Info */
	private String ydFctyTpCfsFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String chkVndrSeq = null;
	/* Column Info */
	private String oldOfcCd = null;
	/* Column Info */
	private String updusrid = null;
	/* Column Info */
	private String ydFctyTpCyFlg = null;
	/* Column Info */
	private String chkOsC = null;
	/* Column Info */
	private String chkOsB = null;
	/* Column Info */
	private String os = null;
	/* Column Info */
	private String chkOsE = null;
	/* Column Info */
	private String chkOsD = null;
	/* Column Info */
	private String chkOsF = null;
	/* Column Info */
	private String ydFctyTpRailRmpFlg = null;
	/* Column Info */
	private String ydFctyTpMrnTmlFlg = null;
	/* Column Info */
	private String countryCode = null;
	/* Column Info */
	private String chkOsA = null;
	/* Column Info */
	private String country = null;
	/* Column Info */
	private String n5thVndrCntCd = null;
	/* Column Info */
	private String n5thVndrSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String chkOsAll = null;
	/* Column Info */
	private String ydChrCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String updateYn = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String n6thVndrCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchNodeDefaultSpInfoListVO() {}

	public SearchNodeDefaultSpInfoListVO(String ibflag, String pagerows, String ydCd, String ydNm, String ofcCd, String ydFctyTpMrnTmlFlg, String ydFctyTpBrgRmpFlg, String ydFctyTpCyFlg, String ydFctyTpCfsFlg, String ydFctyTpRailRmpFlg, String ydFctyTpPsdoYdFlg, String ydChrCd, String os, String spCode, String spName, String locCd, String country, String n4thVndrCntCd, String n4thVndrSeq, String n5thVndrCntCd, String n5thVndrSeq, String n6thVndrCntCd, String n6thVndrSeq, String updusrid, String countryCode, String inclSubOfcFlg, String oldOfcCd, String vndrSeq, String vndrLglEngNm, String vndrCntCd, String chkVndrSeq, String updateYn, String chkOsAll, String chkOsA, String chkOsB, String chkOsC, String chkOsD, String chkOsE, String chkOsF) {
		this.vndrCntCd = vndrCntCd;
		this.n4thVndrCntCd = n4thVndrCntCd;
		this.spName = spName;
		this.n4thVndrSeq = n4thVndrSeq;
		this.vndrLglEngNm = vndrLglEngNm;
		this.inclSubOfcFlg = inclSubOfcFlg;
		this.ydFctyTpPsdoYdFlg = ydFctyTpPsdoYdFlg;
		this.ydFctyTpBrgRmpFlg = ydFctyTpBrgRmpFlg;
		this.pagerows = pagerows;
		this.spCode = spCode;
		this.n6thVndrSeq = n6thVndrSeq;
		this.ydFctyTpCfsFlg = ydFctyTpCfsFlg;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.chkVndrSeq = chkVndrSeq;
		this.oldOfcCd = oldOfcCd;
		this.updusrid = updusrid;
		this.ydFctyTpCyFlg = ydFctyTpCyFlg;
		this.chkOsC = chkOsC;
		this.chkOsB = chkOsB;
		this.os = os;
		this.chkOsE = chkOsE;
		this.chkOsD = chkOsD;
		this.chkOsF = chkOsF;
		this.ydFctyTpRailRmpFlg = ydFctyTpRailRmpFlg;
		this.ydFctyTpMrnTmlFlg = ydFctyTpMrnTmlFlg;
		this.countryCode = countryCode;
		this.chkOsA = chkOsA;
		this.country = country;
		this.n5thVndrCntCd = n5thVndrCntCd;
		this.n5thVndrSeq = n5thVndrSeq;
		this.ofcCd = ofcCd;
		this.chkOsAll = chkOsAll;
		this.ydChrCd = ydChrCd;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.updateYn = updateYn;
		this.ydNm = ydNm;
		this.n6thVndrCntCd = n6thVndrCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("n4th_vndr_cnt_cd", getN4thVndrCntCd());
		this.hashColumns.put("sp_name", getSpName());
		this.hashColumns.put("n4th_vndr_seq", getN4thVndrSeq());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("incl_sub_ofc_flg", getInclSubOfcFlg());
		this.hashColumns.put("yd_fcty_tp_psdo_yd_flg", getYdFctyTpPsdoYdFlg());
		this.hashColumns.put("yd_fcty_tp_brg_rmp_flg", getYdFctyTpBrgRmpFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sp_code", getSpCode());
		this.hashColumns.put("n6th_vndr_seq", getN6thVndrSeq());
		this.hashColumns.put("yd_fcty_tp_cfs_flg", getYdFctyTpCfsFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("chk_vndr_seq", getChkVndrSeq());
		this.hashColumns.put("old_ofc_cd", getOldOfcCd());
		this.hashColumns.put("updusrid", getUpdusrid());
		this.hashColumns.put("yd_fcty_tp_cy_flg", getYdFctyTpCyFlg());
		this.hashColumns.put("chk_os_c", getChkOsC());
		this.hashColumns.put("chk_os_b", getChkOsB());
		this.hashColumns.put("os", getOs());
		this.hashColumns.put("chk_os_e", getChkOsE());
		this.hashColumns.put("chk_os_d", getChkOsD());
		this.hashColumns.put("chk_os_f", getChkOsF());
		this.hashColumns.put("yd_fcty_tp_rail_rmp_flg", getYdFctyTpRailRmpFlg());
		this.hashColumns.put("yd_fcty_tp_mrn_tml_flg", getYdFctyTpMrnTmlFlg());
		this.hashColumns.put("country_code", getCountryCode());
		this.hashColumns.put("chk_os_a", getChkOsA());
		this.hashColumns.put("country", getCountry());
		this.hashColumns.put("n5th_vndr_cnt_cd", getN5thVndrCntCd());
		this.hashColumns.put("n5th_vndr_seq", getN5thVndrSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("chk_os_all", getChkOsAll());
		this.hashColumns.put("yd_chr_cd", getYdChrCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("update_yn", getUpdateYn());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("n6th_vndr_cnt_cd", getN6thVndrCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("n4th_vndr_cnt_cd", "n4thVndrCntCd");
		this.hashFields.put("sp_name", "spName");
		this.hashFields.put("n4th_vndr_seq", "n4thVndrSeq");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("incl_sub_ofc_flg", "inclSubOfcFlg");
		this.hashFields.put("yd_fcty_tp_psdo_yd_flg", "ydFctyTpPsdoYdFlg");
		this.hashFields.put("yd_fcty_tp_brg_rmp_flg", "ydFctyTpBrgRmpFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sp_code", "spCode");
		this.hashFields.put("n6th_vndr_seq", "n6thVndrSeq");
		this.hashFields.put("yd_fcty_tp_cfs_flg", "ydFctyTpCfsFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("chk_vndr_seq", "chkVndrSeq");
		this.hashFields.put("old_ofc_cd", "oldOfcCd");
		this.hashFields.put("updusrid", "updusrid");
		this.hashFields.put("yd_fcty_tp_cy_flg", "ydFctyTpCyFlg");
		this.hashFields.put("chk_os_c", "chkOsC");
		this.hashFields.put("chk_os_b", "chkOsB");
		this.hashFields.put("os", "os");
		this.hashFields.put("chk_os_e", "chkOsE");
		this.hashFields.put("chk_os_d", "chkOsD");
		this.hashFields.put("chk_os_f", "chkOsF");
		this.hashFields.put("yd_fcty_tp_rail_rmp_flg", "ydFctyTpRailRmpFlg");
		this.hashFields.put("yd_fcty_tp_mrn_tml_flg", "ydFctyTpMrnTmlFlg");
		this.hashFields.put("country_code", "countryCode");
		this.hashFields.put("chk_os_a", "chkOsA");
		this.hashFields.put("country", "country");
		this.hashFields.put("n5th_vndr_cnt_cd", "n5thVndrCntCd");
		this.hashFields.put("n5th_vndr_seq", "n5thVndrSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("chk_os_all", "chkOsAll");
		this.hashFields.put("yd_chr_cd", "ydChrCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("update_yn", "updateYn");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("n6th_vndr_cnt_cd", "n6thVndrCntCd");
		return this.hashFields;
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
	 * @return n4thVndrCntCd
	 */
	public String getN4thVndrCntCd() {
		return this.n4thVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return spName
	 */
	public String getSpName() {
		return this.spName;
	}
	
	/**
	 * Column Info
	 * @return n4thVndrSeq
	 */
	public String getN4thVndrSeq() {
		return this.n4thVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return inclSubOfcFlg
	 */
	public String getInclSubOfcFlg() {
		return this.inclSubOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return ydFctyTpPsdoYdFlg
	 */
	public String getYdFctyTpPsdoYdFlg() {
		return this.ydFctyTpPsdoYdFlg;
	}
	
	/**
	 * Column Info
	 * @return ydFctyTpBrgRmpFlg
	 */
	public String getYdFctyTpBrgRmpFlg() {
		return this.ydFctyTpBrgRmpFlg;
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
	 * @return spCode
	 */
	public String getSpCode() {
		return this.spCode;
	}
	
	/**
	 * Column Info
	 * @return n6thVndrSeq
	 */
	public String getN6thVndrSeq() {
		return this.n6thVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return ydFctyTpCfsFlg
	 */
	public String getYdFctyTpCfsFlg() {
		return this.ydFctyTpCfsFlg;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return chkVndrSeq
	 */
	public String getChkVndrSeq() {
		return this.chkVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return oldOfcCd
	 */
	public String getOldOfcCd() {
		return this.oldOfcCd;
	}
	
	/**
	 * Column Info
	 * @return updusrid
	 */
	public String getUpdusrid() {
		return this.updusrid;
	}
	
	/**
	 * Column Info
	 * @return ydFctyTpCyFlg
	 */
	public String getYdFctyTpCyFlg() {
		return this.ydFctyTpCyFlg;
	}
	
	/**
	 * Column Info
	 * @return chkOsC
	 */
	public String getChkOsC() {
		return this.chkOsC;
	}
	
	/**
	 * Column Info
	 * @return chkOsB
	 */
	public String getChkOsB() {
		return this.chkOsB;
	}
	
	/**
	 * Column Info
	 * @return os
	 */
	public String getOs() {
		return this.os;
	}
	
	/**
	 * Column Info
	 * @return chkOsE
	 */
	public String getChkOsE() {
		return this.chkOsE;
	}
	
	/**
	 * Column Info
	 * @return chkOsD
	 */
	public String getChkOsD() {
		return this.chkOsD;
	}
	
	/**
	 * Column Info
	 * @return chkOsF
	 */
	public String getChkOsF() {
		return this.chkOsF;
	}
	
	/**
	 * Column Info
	 * @return ydFctyTpRailRmpFlg
	 */
	public String getYdFctyTpRailRmpFlg() {
		return this.ydFctyTpRailRmpFlg;
	}
	
	/**
	 * Column Info
	 * @return ydFctyTpMrnTmlFlg
	 */
	public String getYdFctyTpMrnTmlFlg() {
		return this.ydFctyTpMrnTmlFlg;
	}
	
	/**
	 * Column Info
	 * @return countryCode
	 */
	public String getCountryCode() {
		return this.countryCode;
	}
	
	/**
	 * Column Info
	 * @return chkOsA
	 */
	public String getChkOsA() {
		return this.chkOsA;
	}
	
	/**
	 * Column Info
	 * @return country
	 */
	public String getCountry() {
		return this.country;
	}
	
	/**
	 * Column Info
	 * @return n5thVndrCntCd
	 */
	public String getN5thVndrCntCd() {
		return this.n5thVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return n5thVndrSeq
	 */
	public String getN5thVndrSeq() {
		return this.n5thVndrSeq;
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
	 * @return chkOsAll
	 */
	public String getChkOsAll() {
		return this.chkOsAll;
	}
	
	/**
	 * Column Info
	 * @return ydChrCd
	 */
	public String getYdChrCd() {
		return this.ydChrCd;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return updateYn
	 */
	public String getUpdateYn() {
		return this.updateYn;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return n6thVndrCntCd
	 */
	public String getN6thVndrCntCd() {
		return this.n6thVndrCntCd;
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
	 * @param n4thVndrCntCd
	 */
	public void setN4thVndrCntCd(String n4thVndrCntCd) {
		this.n4thVndrCntCd = n4thVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param spName
	 */
	public void setSpName(String spName) {
		this.spName = spName;
	}
	
	/**
	 * Column Info
	 * @param n4thVndrSeq
	 */
	public void setN4thVndrSeq(String n4thVndrSeq) {
		this.n4thVndrSeq = n4thVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param inclSubOfcFlg
	 */
	public void setInclSubOfcFlg(String inclSubOfcFlg) {
		this.inclSubOfcFlg = inclSubOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param ydFctyTpPsdoYdFlg
	 */
	public void setYdFctyTpPsdoYdFlg(String ydFctyTpPsdoYdFlg) {
		this.ydFctyTpPsdoYdFlg = ydFctyTpPsdoYdFlg;
	}
	
	/**
	 * Column Info
	 * @param ydFctyTpBrgRmpFlg
	 */
	public void setYdFctyTpBrgRmpFlg(String ydFctyTpBrgRmpFlg) {
		this.ydFctyTpBrgRmpFlg = ydFctyTpBrgRmpFlg;
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
	 * @param spCode
	 */
	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}
	
	/**
	 * Column Info
	 * @param n6thVndrSeq
	 */
	public void setN6thVndrSeq(String n6thVndrSeq) {
		this.n6thVndrSeq = n6thVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param ydFctyTpCfsFlg
	 */
	public void setYdFctyTpCfsFlg(String ydFctyTpCfsFlg) {
		this.ydFctyTpCfsFlg = ydFctyTpCfsFlg;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param chkVndrSeq
	 */
	public void setChkVndrSeq(String chkVndrSeq) {
		this.chkVndrSeq = chkVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param oldOfcCd
	 */
	public void setOldOfcCd(String oldOfcCd) {
		this.oldOfcCd = oldOfcCd;
	}
	
	/**
	 * Column Info
	 * @param updusrid
	 */
	public void setUpdusrid(String updusrid) {
		this.updusrid = updusrid;
	}
	
	/**
	 * Column Info
	 * @param ydFctyTpCyFlg
	 */
	public void setYdFctyTpCyFlg(String ydFctyTpCyFlg) {
		this.ydFctyTpCyFlg = ydFctyTpCyFlg;
	}
	
	/**
	 * Column Info
	 * @param chkOsC
	 */
	public void setChkOsC(String chkOsC) {
		this.chkOsC = chkOsC;
	}
	
	/**
	 * Column Info
	 * @param chkOsB
	 */
	public void setChkOsB(String chkOsB) {
		this.chkOsB = chkOsB;
	}
	
	/**
	 * Column Info
	 * @param os
	 */
	public void setOs(String os) {
		this.os = os;
	}
	
	/**
	 * Column Info
	 * @param chkOsE
	 */
	public void setChkOsE(String chkOsE) {
		this.chkOsE = chkOsE;
	}
	
	/**
	 * Column Info
	 * @param chkOsD
	 */
	public void setChkOsD(String chkOsD) {
		this.chkOsD = chkOsD;
	}
	
	/**
	 * Column Info
	 * @param chkOsF
	 */
	public void setChkOsF(String chkOsF) {
		this.chkOsF = chkOsF;
	}
	
	/**
	 * Column Info
	 * @param ydFctyTpRailRmpFlg
	 */
	public void setYdFctyTpRailRmpFlg(String ydFctyTpRailRmpFlg) {
		this.ydFctyTpRailRmpFlg = ydFctyTpRailRmpFlg;
	}
	
	/**
	 * Column Info
	 * @param ydFctyTpMrnTmlFlg
	 */
	public void setYdFctyTpMrnTmlFlg(String ydFctyTpMrnTmlFlg) {
		this.ydFctyTpMrnTmlFlg = ydFctyTpMrnTmlFlg;
	}
	
	/**
	 * Column Info
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	/**
	 * Column Info
	 * @param chkOsA
	 */
	public void setChkOsA(String chkOsA) {
		this.chkOsA = chkOsA;
	}
	
	/**
	 * Column Info
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Column Info
	 * @param n5thVndrCntCd
	 */
	public void setN5thVndrCntCd(String n5thVndrCntCd) {
		this.n5thVndrCntCd = n5thVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param n5thVndrSeq
	 */
	public void setN5thVndrSeq(String n5thVndrSeq) {
		this.n5thVndrSeq = n5thVndrSeq;
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
	 * @param chkOsAll
	 */
	public void setChkOsAll(String chkOsAll) {
		this.chkOsAll = chkOsAll;
	}
	
	/**
	 * Column Info
	 * @param ydChrCd
	 */
	public void setYdChrCd(String ydChrCd) {
		this.ydChrCd = ydChrCd;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param updateYn
	 */
	public void setUpdateYn(String updateYn) {
		this.updateYn = updateYn;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param n6thVndrCntCd
	 */
	public void setN6thVndrCntCd(String n6thVndrCntCd) {
		this.n6thVndrCntCd = n6thVndrCntCd;
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
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setN4thVndrCntCd(JSPUtil.getParameter(request, prefix + "n4th_vndr_cnt_cd", ""));
		setSpName(JSPUtil.getParameter(request, prefix + "sp_name", ""));
		setN4thVndrSeq(JSPUtil.getParameter(request, prefix + "n4th_vndr_seq", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setInclSubOfcFlg(JSPUtil.getParameter(request, prefix + "incl_sub_ofc_flg", ""));
		setYdFctyTpPsdoYdFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_psdo_yd_flg", ""));
		setYdFctyTpBrgRmpFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_brg_rmp_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSpCode(JSPUtil.getParameter(request, prefix + "sp_code", ""));
		setN6thVndrSeq(JSPUtil.getParameter(request, prefix + "n6th_vndr_seq", ""));
		setYdFctyTpCfsFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cfs_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setChkVndrSeq(JSPUtil.getParameter(request, prefix + "chk_vndr_seq", ""));
		setOldOfcCd(JSPUtil.getParameter(request, prefix + "old_ofc_cd", ""));
		setUpdusrid(JSPUtil.getParameter(request, prefix + "updusrid", ""));
		setYdFctyTpCyFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cy_flg", ""));
		setChkOsC(JSPUtil.getParameter(request, prefix + "chk_os_c", ""));
		setChkOsB(JSPUtil.getParameter(request, prefix + "chk_os_b", ""));
		setOs(JSPUtil.getParameter(request, prefix + "os", ""));
		setChkOsE(JSPUtil.getParameter(request, prefix + "chk_os_e", ""));
		setChkOsD(JSPUtil.getParameter(request, prefix + "chk_os_d", ""));
		setChkOsF(JSPUtil.getParameter(request, prefix + "chk_os_f", ""));
		setYdFctyTpRailRmpFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_rail_rmp_flg", ""));
		setYdFctyTpMrnTmlFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_mrn_tml_flg", ""));
		setCountryCode(JSPUtil.getParameter(request, prefix + "country_code", ""));
		setChkOsA(JSPUtil.getParameter(request, prefix + "chk_os_a", ""));
		setCountry(JSPUtil.getParameter(request, prefix + "country", ""));
		setN5thVndrCntCd(JSPUtil.getParameter(request, prefix + "n5th_vndr_cnt_cd", ""));
		setN5thVndrSeq(JSPUtil.getParameter(request, prefix + "n5th_vndr_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setChkOsAll(JSPUtil.getParameter(request, prefix + "chk_os_all", ""));
		setYdChrCd(JSPUtil.getParameter(request, prefix + "yd_chr_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setUpdateYn(JSPUtil.getParameter(request, prefix + "update_yn", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setN6thVndrCntCd(JSPUtil.getParameter(request, prefix + "n6th_vndr_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchNodeDefaultSpInfoListVO[]
	 */
	public SearchNodeDefaultSpInfoListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchNodeDefaultSpInfoListVO[]
	 */
	public SearchNodeDefaultSpInfoListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchNodeDefaultSpInfoListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] n4thVndrCntCd = (JSPUtil.getParameter(request, prefix	+ "n4th_vndr_cnt_cd", length));
			String[] spName = (JSPUtil.getParameter(request, prefix	+ "sp_name", length));
			String[] n4thVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n4th_vndr_seq", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] inclSubOfcFlg = (JSPUtil.getParameter(request, prefix	+ "incl_sub_ofc_flg", length));
			String[] ydFctyTpPsdoYdFlg = (JSPUtil.getParameter(request, prefix	+ "yd_fcty_tp_psdo_yd_flg", length));
			String[] ydFctyTpBrgRmpFlg = (JSPUtil.getParameter(request, prefix	+ "yd_fcty_tp_brg_rmp_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] spCode = (JSPUtil.getParameter(request, prefix	+ "sp_code", length));
			String[] n6thVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n6th_vndr_seq", length));
			String[] ydFctyTpCfsFlg = (JSPUtil.getParameter(request, prefix	+ "yd_fcty_tp_cfs_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] chkVndrSeq = (JSPUtil.getParameter(request, prefix	+ "chk_vndr_seq", length));
			String[] oldOfcCd = (JSPUtil.getParameter(request, prefix	+ "old_ofc_cd", length));
			String[] updusrid = (JSPUtil.getParameter(request, prefix	+ "updusrid", length));
			String[] ydFctyTpCyFlg = (JSPUtil.getParameter(request, prefix	+ "yd_fcty_tp_cy_flg", length));
			String[] chkOsC = (JSPUtil.getParameter(request, prefix	+ "chk_os_c", length));
			String[] chkOsB = (JSPUtil.getParameter(request, prefix	+ "chk_os_b", length));
			String[] os = (JSPUtil.getParameter(request, prefix	+ "os", length));
			String[] chkOsE = (JSPUtil.getParameter(request, prefix	+ "chk_os_e", length));
			String[] chkOsD = (JSPUtil.getParameter(request, prefix	+ "chk_os_d", length));
			String[] chkOsF = (JSPUtil.getParameter(request, prefix	+ "chk_os_f", length));
			String[] ydFctyTpRailRmpFlg = (JSPUtil.getParameter(request, prefix	+ "yd_fcty_tp_rail_rmp_flg", length));
			String[] ydFctyTpMrnTmlFlg = (JSPUtil.getParameter(request, prefix	+ "yd_fcty_tp_mrn_tml_flg", length));
			String[] countryCode = (JSPUtil.getParameter(request, prefix	+ "country_code", length));
			String[] chkOsA = (JSPUtil.getParameter(request, prefix	+ "chk_os_a", length));
			String[] country = (JSPUtil.getParameter(request, prefix	+ "country", length));
			String[] n5thVndrCntCd = (JSPUtil.getParameter(request, prefix	+ "n5th_vndr_cnt_cd", length));
			String[] n5thVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n5th_vndr_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] chkOsAll = (JSPUtil.getParameter(request, prefix	+ "chk_os_all", length));
			String[] ydChrCd = (JSPUtil.getParameter(request, prefix	+ "yd_chr_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] updateYn = (JSPUtil.getParameter(request, prefix	+ "update_yn", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] n6thVndrCntCd = (JSPUtil.getParameter(request, prefix	+ "n6th_vndr_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchNodeDefaultSpInfoListVO();
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (n4thVndrCntCd[i] != null)
					model.setN4thVndrCntCd(n4thVndrCntCd[i]);
				if (spName[i] != null)
					model.setSpName(spName[i]);
				if (n4thVndrSeq[i] != null)
					model.setN4thVndrSeq(n4thVndrSeq[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (inclSubOfcFlg[i] != null)
					model.setInclSubOfcFlg(inclSubOfcFlg[i]);
				if (ydFctyTpPsdoYdFlg[i] != null)
					model.setYdFctyTpPsdoYdFlg(ydFctyTpPsdoYdFlg[i]);
				if (ydFctyTpBrgRmpFlg[i] != null)
					model.setYdFctyTpBrgRmpFlg(ydFctyTpBrgRmpFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (spCode[i] != null)
					model.setSpCode(spCode[i]);
				if (n6thVndrSeq[i] != null)
					model.setN6thVndrSeq(n6thVndrSeq[i]);
				if (ydFctyTpCfsFlg[i] != null)
					model.setYdFctyTpCfsFlg(ydFctyTpCfsFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (chkVndrSeq[i] != null)
					model.setChkVndrSeq(chkVndrSeq[i]);
				if (oldOfcCd[i] != null)
					model.setOldOfcCd(oldOfcCd[i]);
				if (updusrid[i] != null)
					model.setUpdusrid(updusrid[i]);
				if (ydFctyTpCyFlg[i] != null)
					model.setYdFctyTpCyFlg(ydFctyTpCyFlg[i]);
				if (chkOsC[i] != null)
					model.setChkOsC(chkOsC[i]);
				if (chkOsB[i] != null)
					model.setChkOsB(chkOsB[i]);
				if (os[i] != null)
					model.setOs(os[i]);
				if (chkOsE[i] != null)
					model.setChkOsE(chkOsE[i]);
				if (chkOsD[i] != null)
					model.setChkOsD(chkOsD[i]);
				if (chkOsF[i] != null)
					model.setChkOsF(chkOsF[i]);
				if (ydFctyTpRailRmpFlg[i] != null)
					model.setYdFctyTpRailRmpFlg(ydFctyTpRailRmpFlg[i]);
				if (ydFctyTpMrnTmlFlg[i] != null)
					model.setYdFctyTpMrnTmlFlg(ydFctyTpMrnTmlFlg[i]);
				if (countryCode[i] != null)
					model.setCountryCode(countryCode[i]);
				if (chkOsA[i] != null)
					model.setChkOsA(chkOsA[i]);
				if (country[i] != null)
					model.setCountry(country[i]);
				if (n5thVndrCntCd[i] != null)
					model.setN5thVndrCntCd(n5thVndrCntCd[i]);
				if (n5thVndrSeq[i] != null)
					model.setN5thVndrSeq(n5thVndrSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (chkOsAll[i] != null)
					model.setChkOsAll(chkOsAll[i]);
				if (ydChrCd[i] != null)
					model.setYdChrCd(ydChrCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (updateYn[i] != null)
					model.setUpdateYn(updateYn[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (n6thVndrCntCd[i] != null)
					model.setN6thVndrCntCd(n6thVndrCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchNodeDefaultSpInfoListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchNodeDefaultSpInfoListVO[]
	 */
	public SearchNodeDefaultSpInfoListVO[] getSearchNodeDefaultSpInfoListVOs(){
		SearchNodeDefaultSpInfoListVO[] vos = (SearchNodeDefaultSpInfoListVO[])models.toArray(new SearchNodeDefaultSpInfoListVO[models.size()]);
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
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thVndrCntCd = this.n4thVndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spName = this.spName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thVndrSeq = this.n4thVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclSubOfcFlg = this.inclSubOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydFctyTpPsdoYdFlg = this.ydFctyTpPsdoYdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydFctyTpBrgRmpFlg = this.ydFctyTpBrgRmpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCode = this.spCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6thVndrSeq = this.n6thVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydFctyTpCfsFlg = this.ydFctyTpCfsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkVndrSeq = this.chkVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldOfcCd = this.oldOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updusrid = this.updusrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydFctyTpCyFlg = this.ydFctyTpCyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOsC = this.chkOsC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOsB = this.chkOsB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.os = this.os .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOsE = this.chkOsE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOsD = this.chkOsD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOsF = this.chkOsF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydFctyTpRailRmpFlg = this.ydFctyTpRailRmpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydFctyTpMrnTmlFlg = this.ydFctyTpMrnTmlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.countryCode = this.countryCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOsA = this.chkOsA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.country = this.country .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thVndrCntCd = this.n5thVndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thVndrSeq = this.n5thVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOsAll = this.chkOsAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChrCd = this.ydChrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateYn = this.updateYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6thVndrCntCd = this.n6thVndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
