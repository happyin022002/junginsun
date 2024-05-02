/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchSpaceControlInquiryListVO.java
*@FileTitle : SearchSpaceControlInquiryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.02
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.07.02 이상용 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

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
 * @author 이상용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceControlInquiryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlInquiryListVO> models = new ArrayList<SearchSpaceControlInquiryListVO>();
	
	/* Column Info */
	private String usdBkg53ftQty = null;
	/* Column Info */
	private String aloc53ftQty = null;
	/* Column Info */
	private String alocTtlWgt = null;
	/* Column Info */
	private String usdBkg20ftQty = null;
	/* Column Info */
	private String fcastTtlTeuQty = null;
	/* Column Info */
	private String usdBkg40ftQty = null;
	/* Column Info */
	private String alocLodQty = null;
	/* Column Info */
	private String alocRfQty = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fcastTtlQty = null;
	/* Column Info */
	private String usdBkgRfQty = null;
	/* Column Info */
	private String usdBkgTtlQty = null;
	/* Column Info */
	private String aloc40ftHcQty = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String fcast53ftQty = null;
	/* Column Info */
	private String aloc45ftHcQty = null;
	/* Column Info */
	private String fcastTtlWgt = null;
	/* Column Info */
	private String usdBkg40ftHcQty = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String fcastRfQty = null;
	/* Column Info */
	private String userNm = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String usdBkg45ftHcQty = null;
	/* Column Info */
	private String alocGdt = null;
	/* Column Info */
	private String fcast45ftHcQty = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String usdBkgTtlWgt = null;
	/* Column Info */
	private String fcast40ftHcQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceControlInquiryListVO() {}

	public SearchSpaceControlInquiryListVO(String ibflag, String pagerows, String alocGdt, String userNm, String slsOfcCd, String polYdCd, String podYdCd, String alocLodQty, String aloc40ftHcQty, String aloc45ftHcQty, String aloc53ftQty, String alocRfQty, String alocTtlWgt, String fcastTtlTeuQty, String fcastTtlQty, String fcast40ftHcQty, String fcast45ftHcQty, String fcast53ftQty, String fcastRfQty, String fcastTtlWgt, String usdBkgTtlQty, String usdBkg20ftQty, String usdBkg40ftQty, String usdBkg40ftHcQty, String usdBkg45ftHcQty, String usdBkg53ftQty, String usdBkgRfQty, String usdBkgTtlWgt, String lvl) {
		this.usdBkg53ftQty = usdBkg53ftQty;
		this.aloc53ftQty = aloc53ftQty;
		this.alocTtlWgt = alocTtlWgt;
		this.usdBkg20ftQty = usdBkg20ftQty;
		this.fcastTtlTeuQty = fcastTtlTeuQty;
		this.usdBkg40ftQty = usdBkg40ftQty;
		this.alocLodQty = alocLodQty;
		this.alocRfQty = alocRfQty;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.fcastTtlQty = fcastTtlQty;
		this.usdBkgRfQty = usdBkgRfQty;
		this.usdBkgTtlQty = usdBkgTtlQty;
		this.aloc40ftHcQty = aloc40ftHcQty;
		this.slsOfcCd = slsOfcCd;
		this.fcast53ftQty = fcast53ftQty;
		this.aloc45ftHcQty = aloc45ftHcQty;
		this.fcastTtlWgt = fcastTtlWgt;
		this.usdBkg40ftHcQty = usdBkg40ftHcQty;
		this.podYdCd = podYdCd;
		this.fcastRfQty = fcastRfQty;
		this.userNm = userNm;
		this.lvl = lvl;
		this.usdBkg45ftHcQty = usdBkg45ftHcQty;
		this.alocGdt = alocGdt;
		this.fcast45ftHcQty = fcast45ftHcQty;
		this.polYdCd = polYdCd;
		this.usdBkgTtlWgt = usdBkgTtlWgt;
		this.fcast40ftHcQty = fcast40ftHcQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("usd_bkg_53ft_qty", getUsdBkg53ftQty());
		this.hashColumns.put("aloc_53ft_qty", getAloc53ftQty());
		this.hashColumns.put("aloc_ttl_wgt", getAlocTtlWgt());
		this.hashColumns.put("usd_bkg_20ft_qty", getUsdBkg20ftQty());
		this.hashColumns.put("fcast_ttl_teu_qty", getFcastTtlTeuQty());
		this.hashColumns.put("usd_bkg_40ft_qty", getUsdBkg40ftQty());
		this.hashColumns.put("aloc_lod_qty", getAlocLodQty());
		this.hashColumns.put("aloc_rf_qty", getAlocRfQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fcast_ttl_qty", getFcastTtlQty());
		this.hashColumns.put("usd_bkg_rf_qty", getUsdBkgRfQty());
		this.hashColumns.put("usd_bkg_ttl_qty", getUsdBkgTtlQty());
		this.hashColumns.put("aloc_40ft_hc_qty", getAloc40ftHcQty());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("fcast_53ft_qty", getFcast53ftQty());
		this.hashColumns.put("aloc_45ft_hc_qty", getAloc45ftHcQty());
		this.hashColumns.put("fcast_ttl_wgt", getFcastTtlWgt());
		this.hashColumns.put("usd_bkg_40ft_hc_qty", getUsdBkg40ftHcQty());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("fcast_rf_qty", getFcastRfQty());
		this.hashColumns.put("user_nm", getUserNm());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("usd_bkg_45ft_hc_qty", getUsdBkg45ftHcQty());
		this.hashColumns.put("aloc_gdt", getAlocGdt());
		this.hashColumns.put("fcast_45ft_hc_qty", getFcast45ftHcQty());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("usd_bkg_ttl_wgt", getUsdBkgTtlWgt());
		this.hashColumns.put("fcast_40ft_hc_qty", getFcast40ftHcQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("usd_bkg_53ft_qty", "usdBkg53ftQty");
		this.hashFields.put("aloc_53ft_qty", "aloc53ftQty");
		this.hashFields.put("aloc_ttl_wgt", "alocTtlWgt");
		this.hashFields.put("usd_bkg_20ft_qty", "usdBkg20ftQty");
		this.hashFields.put("fcast_ttl_teu_qty", "fcastTtlTeuQty");
		this.hashFields.put("usd_bkg_40ft_qty", "usdBkg40ftQty");
		this.hashFields.put("aloc_lod_qty", "alocLodQty");
		this.hashFields.put("aloc_rf_qty", "alocRfQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fcast_ttl_qty", "fcastTtlQty");
		this.hashFields.put("usd_bkg_rf_qty", "usdBkgRfQty");
		this.hashFields.put("usd_bkg_ttl_qty", "usdBkgTtlQty");
		this.hashFields.put("aloc_40ft_hc_qty", "aloc40ftHcQty");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("fcast_53ft_qty", "fcast53ftQty");
		this.hashFields.put("aloc_45ft_hc_qty", "aloc45ftHcQty");
		this.hashFields.put("fcast_ttl_wgt", "fcastTtlWgt");
		this.hashFields.put("usd_bkg_40ft_hc_qty", "usdBkg40ftHcQty");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("fcast_rf_qty", "fcastRfQty");
		this.hashFields.put("user_nm", "userNm");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("usd_bkg_45ft_hc_qty", "usdBkg45ftHcQty");
		this.hashFields.put("aloc_gdt", "alocGdt");
		this.hashFields.put("fcast_45ft_hc_qty", "fcast45ftHcQty");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("usd_bkg_ttl_wgt", "usdBkgTtlWgt");
		this.hashFields.put("fcast_40ft_hc_qty", "fcast40ftHcQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return usdBkg53ftQty
	 */
	public String getUsdBkg53ftQty() {
		return this.usdBkg53ftQty;
	}
	
	/**
	 * Column Info
	 * @return aloc53ftQty
	 */
	public String getAloc53ftQty() {
		return this.aloc53ftQty;
	}
	
	/**
	 * Column Info
	 * @return alocTtlWgt
	 */
	public String getAlocTtlWgt() {
		return this.alocTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return usdBkg20ftQty
	 */
	public String getUsdBkg20ftQty() {
		return this.usdBkg20ftQty;
	}
	
	/**
	 * Column Info
	 * @return fcastTtlTeuQty
	 */
	public String getFcastTtlTeuQty() {
		return this.fcastTtlTeuQty;
	}
	
	/**
	 * Column Info
	 * @return usdBkg40ftQty
	 */
	public String getUsdBkg40ftQty() {
		return this.usdBkg40ftQty;
	}
	
	/**
	 * Column Info
	 * @return alocLodQty
	 */
	public String getAlocLodQty() {
		return this.alocLodQty;
	}
	
	/**
	 * Column Info
	 * @return alocRfQty
	 */
	public String getAlocRfQty() {
		return this.alocRfQty;
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
	 * @return fcastTtlQty
	 */
	public String getFcastTtlQty() {
		return this.fcastTtlQty;
	}
	
	/**
	 * Column Info
	 * @return usdBkgRfQty
	 */
	public String getUsdBkgRfQty() {
		return this.usdBkgRfQty;
	}
	
	/**
	 * Column Info
	 * @return usdBkgTtlQty
	 */
	public String getUsdBkgTtlQty() {
		return this.usdBkgTtlQty;
	}
	
	/**
	 * Column Info
	 * @return aloc40ftHcQty
	 */
	public String getAloc40ftHcQty() {
		return this.aloc40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fcast53ftQty
	 */
	public String getFcast53ftQty() {
		return this.fcast53ftQty;
	}
	
	/**
	 * Column Info
	 * @return aloc45ftHcQty
	 */
	public String getAloc45ftHcQty() {
		return this.aloc45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return fcastTtlWgt
	 */
	public String getFcastTtlWgt() {
		return this.fcastTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return usdBkg40ftHcQty
	 */
	public String getUsdBkg40ftHcQty() {
		return this.usdBkg40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return fcastRfQty
	 */
	public String getFcastRfQty() {
		return this.fcastRfQty;
	}
	
	/**
	 * Column Info
	 * @return userNm
	 */
	public String getUserNm() {
		return this.userNm;
	}
	
	/**
	 * Column Info
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	
	/**
	 * Column Info
	 * @return usdBkg45ftHcQty
	 */
	public String getUsdBkg45ftHcQty() {
		return this.usdBkg45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return alocGdt
	 */
	public String getAlocGdt() {
		return this.alocGdt;
	}
	
	/**
	 * Column Info
	 * @return fcast45ftHcQty
	 */
	public String getFcast45ftHcQty() {
		return this.fcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return usdBkgTtlWgt
	 */
	public String getUsdBkgTtlWgt() {
		return this.usdBkgTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return fcast40ftHcQty
	 */
	public String getFcast40ftHcQty() {
		return this.fcast40ftHcQty;
	}
	

	/**
	 * Column Info
	 * @param usdBkg53ftQty
	 */
	public void setUsdBkg53ftQty(String usdBkg53ftQty) {
		this.usdBkg53ftQty = usdBkg53ftQty;
	}
	
	/**
	 * Column Info
	 * @param aloc53ftQty
	 */
	public void setAloc53ftQty(String aloc53ftQty) {
		this.aloc53ftQty = aloc53ftQty;
	}
	
	/**
	 * Column Info
	 * @param alocTtlWgt
	 */
	public void setAlocTtlWgt(String alocTtlWgt) {
		this.alocTtlWgt = alocTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param usdBkg20ftQty
	 */
	public void setUsdBkg20ftQty(String usdBkg20ftQty) {
		this.usdBkg20ftQty = usdBkg20ftQty;
	}
	
	/**
	 * Column Info
	 * @param fcastTtlTeuQty
	 */
	public void setFcastTtlTeuQty(String fcastTtlTeuQty) {
		this.fcastTtlTeuQty = fcastTtlTeuQty;
	}
	
	/**
	 * Column Info
	 * @param usdBkg40ftQty
	 */
	public void setUsdBkg40ftQty(String usdBkg40ftQty) {
		this.usdBkg40ftQty = usdBkg40ftQty;
	}
	
	/**
	 * Column Info
	 * @param alocLodQty
	 */
	public void setAlocLodQty(String alocLodQty) {
		this.alocLodQty = alocLodQty;
	}
	
	/**
	 * Column Info
	 * @param alocRfQty
	 */
	public void setAlocRfQty(String alocRfQty) {
		this.alocRfQty = alocRfQty;
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
	 * @param fcastTtlQty
	 */
	public void setFcastTtlQty(String fcastTtlQty) {
		this.fcastTtlQty = fcastTtlQty;
	}
	
	/**
	 * Column Info
	 * @param usdBkgRfQty
	 */
	public void setUsdBkgRfQty(String usdBkgRfQty) {
		this.usdBkgRfQty = usdBkgRfQty;
	}
	
	/**
	 * Column Info
	 * @param usdBkgTtlQty
	 */
	public void setUsdBkgTtlQty(String usdBkgTtlQty) {
		this.usdBkgTtlQty = usdBkgTtlQty;
	}
	
	/**
	 * Column Info
	 * @param aloc40ftHcQty
	 */
	public void setAloc40ftHcQty(String aloc40ftHcQty) {
		this.aloc40ftHcQty = aloc40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fcast53ftQty
	 */
	public void setFcast53ftQty(String fcast53ftQty) {
		this.fcast53ftQty = fcast53ftQty;
	}
	
	/**
	 * Column Info
	 * @param aloc45ftHcQty
	 */
	public void setAloc45ftHcQty(String aloc45ftHcQty) {
		this.aloc45ftHcQty = aloc45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param fcastTtlWgt
	 */
	public void setFcastTtlWgt(String fcastTtlWgt) {
		this.fcastTtlWgt = fcastTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param usdBkg40ftHcQty
	 */
	public void setUsdBkg40ftHcQty(String usdBkg40ftHcQty) {
		this.usdBkg40ftHcQty = usdBkg40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param fcastRfQty
	 */
	public void setFcastRfQty(String fcastRfQty) {
		this.fcastRfQty = fcastRfQty;
	}
	
	/**
	 * Column Info
	 * @param userNm
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	/**
	 * Column Info
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Column Info
	 * @param usdBkg45ftHcQty
	 */
	public void setUsdBkg45ftHcQty(String usdBkg45ftHcQty) {
		this.usdBkg45ftHcQty = usdBkg45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param alocGdt
	 */
	public void setAlocGdt(String alocGdt) {
		this.alocGdt = alocGdt;
	}
	
	/**
	 * Column Info
	 * @param fcast45ftHcQty
	 */
	public void setFcast45ftHcQty(String fcast45ftHcQty) {
		this.fcast45ftHcQty = fcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param usdBkgTtlWgt
	 */
	public void setUsdBkgTtlWgt(String usdBkgTtlWgt) {
		this.usdBkgTtlWgt = usdBkgTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param fcast40ftHcQty
	 */
	public void setFcast40ftHcQty(String fcast40ftHcQty) {
		this.fcast40ftHcQty = fcast40ftHcQty;
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
		setUsdBkg53ftQty(JSPUtil.getParameter(request, prefix + "usd_bkg_53ft_qty", ""));
		setAloc53ftQty(JSPUtil.getParameter(request, prefix + "aloc_53ft_qty", ""));
		setAlocTtlWgt(JSPUtil.getParameter(request, prefix + "aloc_ttl_wgt", ""));
		setUsdBkg20ftQty(JSPUtil.getParameter(request, prefix + "usd_bkg_20ft_qty", ""));
		setFcastTtlTeuQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_teu_qty", ""));
		setUsdBkg40ftQty(JSPUtil.getParameter(request, prefix + "usd_bkg_40ft_qty", ""));
		setAlocLodQty(JSPUtil.getParameter(request, prefix + "aloc_lod_qty", ""));
		setAlocRfQty(JSPUtil.getParameter(request, prefix + "aloc_rf_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFcastTtlQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_qty", ""));
		setUsdBkgRfQty(JSPUtil.getParameter(request, prefix + "usd_bkg_rf_qty", ""));
		setUsdBkgTtlQty(JSPUtil.getParameter(request, prefix + "usd_bkg_ttl_qty", ""));
		setAloc40ftHcQty(JSPUtil.getParameter(request, prefix + "aloc_40ft_hc_qty", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setFcast53ftQty(JSPUtil.getParameter(request, prefix + "fcast_53ft_qty", ""));
		setAloc45ftHcQty(JSPUtil.getParameter(request, prefix + "aloc_45ft_hc_qty", ""));
		setFcastTtlWgt(JSPUtil.getParameter(request, prefix + "fcast_ttl_wgt", ""));
		setUsdBkg40ftHcQty(JSPUtil.getParameter(request, prefix + "usd_bkg_40ft_hc_qty", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setFcastRfQty(JSPUtil.getParameter(request, prefix + "fcast_rf_qty", ""));
		setUserNm(JSPUtil.getParameter(request, prefix + "user_nm", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setUsdBkg45ftHcQty(JSPUtil.getParameter(request, prefix + "usd_bkg_45ft_hc_qty", ""));
		setAlocGdt(JSPUtil.getParameter(request, prefix + "aloc_gdt", ""));
		setFcast45ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_qty", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setUsdBkgTtlWgt(JSPUtil.getParameter(request, prefix + "usd_bkg_ttl_wgt", ""));
		setFcast40ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlInquiryListVO[]
	 */
	public SearchSpaceControlInquiryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlInquiryListVO[]
	 */
	public SearchSpaceControlInquiryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlInquiryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] usdBkg53ftQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_53ft_qty", length));
			String[] aloc53ftQty = (JSPUtil.getParameter(request, prefix	+ "aloc_53ft_qty", length));
			String[] alocTtlWgt = (JSPUtil.getParameter(request, prefix	+ "aloc_ttl_wgt", length));
			String[] usdBkg20ftQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_20ft_qty", length));
			String[] fcastTtlTeuQty = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_teu_qty", length));
			String[] usdBkg40ftQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_40ft_qty", length));
			String[] alocLodQty = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty", length));
			String[] alocRfQty = (JSPUtil.getParameter(request, prefix	+ "aloc_rf_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fcastTtlQty = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_qty", length));
			String[] usdBkgRfQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_rf_qty", length));
			String[] usdBkgTtlQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_ttl_qty", length));
			String[] aloc40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "aloc_40ft_hc_qty", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] fcast53ftQty = (JSPUtil.getParameter(request, prefix	+ "fcast_53ft_qty", length));
			String[] aloc45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "aloc_45ft_hc_qty", length));
			String[] fcastTtlWgt = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_wgt", length));
			String[] usdBkg40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_40ft_hc_qty", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] fcastRfQty = (JSPUtil.getParameter(request, prefix	+ "fcast_rf_qty", length));
			String[] userNm = (JSPUtil.getParameter(request, prefix	+ "user_nm", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] usdBkg45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_45ft_hc_qty", length));
			String[] alocGdt = (JSPUtil.getParameter(request, prefix	+ "aloc_gdt", length));
			String[] fcast45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "fcast_45ft_hc_qty", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] usdBkgTtlWgt = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_ttl_wgt", length));
			String[] fcast40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "fcast_40ft_hc_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlInquiryListVO();
				if (usdBkg53ftQty[i] != null)
					model.setUsdBkg53ftQty(usdBkg53ftQty[i]);
				if (aloc53ftQty[i] != null)
					model.setAloc53ftQty(aloc53ftQty[i]);
				if (alocTtlWgt[i] != null)
					model.setAlocTtlWgt(alocTtlWgt[i]);
				if (usdBkg20ftQty[i] != null)
					model.setUsdBkg20ftQty(usdBkg20ftQty[i]);
				if (fcastTtlTeuQty[i] != null)
					model.setFcastTtlTeuQty(fcastTtlTeuQty[i]);
				if (usdBkg40ftQty[i] != null)
					model.setUsdBkg40ftQty(usdBkg40ftQty[i]);
				if (alocLodQty[i] != null)
					model.setAlocLodQty(alocLodQty[i]);
				if (alocRfQty[i] != null)
					model.setAlocRfQty(alocRfQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fcastTtlQty[i] != null)
					model.setFcastTtlQty(fcastTtlQty[i]);
				if (usdBkgRfQty[i] != null)
					model.setUsdBkgRfQty(usdBkgRfQty[i]);
				if (usdBkgTtlQty[i] != null)
					model.setUsdBkgTtlQty(usdBkgTtlQty[i]);
				if (aloc40ftHcQty[i] != null)
					model.setAloc40ftHcQty(aloc40ftHcQty[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (fcast53ftQty[i] != null)
					model.setFcast53ftQty(fcast53ftQty[i]);
				if (aloc45ftHcQty[i] != null)
					model.setAloc45ftHcQty(aloc45ftHcQty[i]);
				if (fcastTtlWgt[i] != null)
					model.setFcastTtlWgt(fcastTtlWgt[i]);
				if (usdBkg40ftHcQty[i] != null)
					model.setUsdBkg40ftHcQty(usdBkg40ftHcQty[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (fcastRfQty[i] != null)
					model.setFcastRfQty(fcastRfQty[i]);
				if (userNm[i] != null)
					model.setUserNm(userNm[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (usdBkg45ftHcQty[i] != null)
					model.setUsdBkg45ftHcQty(usdBkg45ftHcQty[i]);
				if (alocGdt[i] != null)
					model.setAlocGdt(alocGdt[i]);
				if (fcast45ftHcQty[i] != null)
					model.setFcast45ftHcQty(fcast45ftHcQty[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (usdBkgTtlWgt[i] != null)
					model.setUsdBkgTtlWgt(usdBkgTtlWgt[i]);
				if (fcast40ftHcQty[i] != null)
					model.setFcast40ftHcQty(fcast40ftHcQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlInquiryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlInquiryListVO[]
	 */
	public SearchSpaceControlInquiryListVO[] getSearchSpaceControlInquiryListVOs(){
		SearchSpaceControlInquiryListVO[] vos = (SearchSpaceControlInquiryListVO[])models.toArray(new SearchSpaceControlInquiryListVO[models.size()]);
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
		this.usdBkg53ftQty = this.usdBkg53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc53ftQty = this.aloc53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocTtlWgt = this.alocTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg20ftQty = this.usdBkg20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlTeuQty = this.fcastTtlTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg40ftQty = this.usdBkg40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQty = this.alocLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocRfQty = this.alocRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlQty = this.fcastTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgRfQty = this.usdBkgRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgTtlQty = this.usdBkgTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc40ftHcQty = this.aloc40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast53ftQty = this.fcast53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc45ftHcQty = this.aloc45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlWgt = this.fcastTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg40ftHcQty = this.usdBkg40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRfQty = this.fcastRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userNm = this.userNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg45ftHcQty = this.usdBkg45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocGdt = this.alocGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast45ftHcQty = this.fcast45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgTtlWgt = this.usdBkgTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40ftHcQty = this.fcast40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
