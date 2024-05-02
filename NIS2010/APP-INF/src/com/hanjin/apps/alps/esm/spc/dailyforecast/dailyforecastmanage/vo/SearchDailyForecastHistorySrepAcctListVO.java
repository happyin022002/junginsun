/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchDailyForecastHistorySrepAcctListVO.java
*@FileTitle : SearchDailyForecastHistorySrepAcctListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.24
*@LastModifier : Okyoung Im
*@LastVersion : 1.0
* 2014.07.24 Okyoung Im 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo;

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
 * @author Okyoung Im
 * @since J2EE 1.6
 * @see AbstractValueObject
 * * 2014.07.30 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청	
 */

public class SearchDailyForecastHistorySrepAcctListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDailyForecastHistorySrepAcctListVO> models = new ArrayList<SearchDailyForecastHistorySrepAcctListVO>();
	
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String fcastRdQty = null;
	/* Column Info */
	private String destLocCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String usaBkgModCd = null;
	/* Column Info */
	private String usdBkg53ftQty = null;
	/* Column Info */
	private String fcast20ftDryQty = null;
	/* Column Info */
	private String cfcast40ftHcQty = null;
	/* Column Info */
	private String usdBkg20ftQty = null;
	/* Column Info */
	private String fcastTtlTeuQty = null;
	/* Column Info */
	private String cfcastTtlWgt = null;
	/* Column Info */
	private String usdBkg40ftQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cfcastTtlQty = null;
	/* Column Info */
	private String fcastTtlQty = null;
	/* Column Info */
	private String cfcast53ftQty = null;
	/* Column Info */
	private String usdBkgRfQty = null;
	/* Column Info */
	private String usdBkgTtlQty = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String modiUsr = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String fcast53ftQty = null;
	/* Column Info */
	private String usdBkg40ftHcQty = null;
	/* Column Info */
	private String fcastTtlWgt = null;
	/* Column Info */
	private String cfcast45ftHcQty = null;
	/* Column Info */
	private String usdBkg40ftDryQty = null;
	/* Column Info */
	private String fcast40ftDryQty = null;
	/* Column Info */
	private String modiGdt = null;
	/* Column Info */
	private String cfcastTtlTeuQty = null;
	/* Column Info */
	private String srepUsrId = null;
	/* Column Info */
	private String fcastRfQty = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cfcastRfQty = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String usdBkg45ftHcQty = null;
	/* Column Info */
	private String fcast45ftHcQty = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String fcastCustTpCd = null;
	/* Column Info */
	private String usdBkgTtlWgt = null;
	/* Column Info */
	private String fcast40ftHcQty = null;
	/* Column Info */
	private String usdBkg20ftDryQty = null;
	/* Column Info */
	private String usdBkgRdQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchDailyForecastHistorySrepAcctListVO() {}

	public SearchDailyForecastHistorySrepAcctListVO(String ibflag, String pagerows, String slsOfcCd, String srepUsrId, String srepNm, String modiGdt, String modiUsr, String fcastCustTpCd, String usaBkgModCd, String custCd, String custNm, String polCd, String podCd, String destLocCd, String fcastTtlTeuQty, String fcastTtlQty, String fcast20ftDryQty, String fcast40ftDryQty, String fcast40ftHcQty, String fcast45ftHcQty, String fcast53ftQty, String fcastRfQty, String fcastRdQty, String fcastTtlWgt, String usdBkgTtlQty, String usdBkg20ftQty, String usdBkg40ftQty, String usdBkg20ftDryQty, String usdBkg40ftDryQty, String usdBkg40ftHcQty, String usdBkg45ftHcQty, String usdBkg53ftQty, String usdBkgRfQty, String usdBkgRdQty, String usdBkgTtlWgt, String cfcastTtlTeuQty, String cfcastTtlQty, String cfcast40ftHcQty, String cfcast45ftHcQty, String cfcast53ftQty, String cfcastRfQty, String cfcastTtlWgt, String lvl, String contiCd) {
		this.contiCd = contiCd;
		this.fcastRdQty = fcastRdQty;
		this.destLocCd = destLocCd;
		this.custNm = custNm;
		this.usaBkgModCd = usaBkgModCd;
		this.usdBkg53ftQty = usdBkg53ftQty;
		this.fcast20ftDryQty = fcast20ftDryQty;
		this.cfcast40ftHcQty = cfcast40ftHcQty;
		this.usdBkg20ftQty = usdBkg20ftQty;
		this.fcastTtlTeuQty = fcastTtlTeuQty;
		this.cfcastTtlWgt = cfcastTtlWgt;
		this.usdBkg40ftQty = usdBkg40ftQty;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cfcastTtlQty = cfcastTtlQty;
		this.fcastTtlQty = fcastTtlQty;
		this.cfcast53ftQty = cfcast53ftQty;
		this.usdBkgRfQty = usdBkgRfQty;
		this.usdBkgTtlQty = usdBkgTtlQty;
		this.srepNm = srepNm;
		this.modiUsr = modiUsr;
		this.slsOfcCd = slsOfcCd;
		this.fcast53ftQty = fcast53ftQty;
		this.usdBkg40ftHcQty = usdBkg40ftHcQty;
		this.fcastTtlWgt = fcastTtlWgt;
		this.cfcast45ftHcQty = cfcast45ftHcQty;
		this.usdBkg40ftDryQty = usdBkg40ftDryQty;
		this.fcast40ftDryQty = fcast40ftDryQty;
		this.modiGdt = modiGdt;
		this.cfcastTtlTeuQty = cfcastTtlTeuQty;
		this.srepUsrId = srepUsrId;
		this.fcastRfQty = fcastRfQty;
		this.podCd = podCd;
		this.cfcastRfQty = cfcastRfQty;
		this.lvl = lvl;
		this.usdBkg45ftHcQty = usdBkg45ftHcQty;
		this.fcast45ftHcQty = fcast45ftHcQty;
		this.custCd = custCd;
		this.fcastCustTpCd = fcastCustTpCd;
		this.usdBkgTtlWgt = usdBkgTtlWgt;
		this.fcast40ftHcQty = fcast40ftHcQty;
		this.usdBkg20ftDryQty = usdBkg20ftDryQty;
		this.usdBkgRdQty = usdBkgRdQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("fcast_rd_qty", getFcastRdQty());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("usa_bkg_mod_cd", getUsaBkgModCd());
		this.hashColumns.put("usd_bkg_53ft_qty", getUsdBkg53ftQty());
		this.hashColumns.put("fcast_20ft_dry_qty", getFcast20ftDryQty());
		this.hashColumns.put("cfcast_40ft_hc_qty", getCfcast40ftHcQty());
		this.hashColumns.put("usd_bkg_20ft_qty", getUsdBkg20ftQty());
		this.hashColumns.put("fcast_ttl_teu_qty", getFcastTtlTeuQty());
		this.hashColumns.put("cfcast_ttl_wgt", getCfcastTtlWgt());
		this.hashColumns.put("usd_bkg_40ft_qty", getUsdBkg40ftQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cfcast_ttl_qty", getCfcastTtlQty());
		this.hashColumns.put("fcast_ttl_qty", getFcastTtlQty());
		this.hashColumns.put("cfcast_53ft_qty", getCfcast53ftQty());
		this.hashColumns.put("usd_bkg_rf_qty", getUsdBkgRfQty());
		this.hashColumns.put("usd_bkg_ttl_qty", getUsdBkgTtlQty());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("modi_usr", getModiUsr());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("fcast_53ft_qty", getFcast53ftQty());
		this.hashColumns.put("usd_bkg_40ft_hc_qty", getUsdBkg40ftHcQty());
		this.hashColumns.put("fcast_ttl_wgt", getFcastTtlWgt());
		this.hashColumns.put("cfcast_45ft_hc_qty", getCfcast45ftHcQty());
		this.hashColumns.put("usd_bkg_40ft_dry_qty", getUsdBkg40ftDryQty());
		this.hashColumns.put("fcast_40ft_dry_qty", getFcast40ftDryQty());
		this.hashColumns.put("modi_gdt", getModiGdt());
		this.hashColumns.put("cfcast_ttl_teu_qty", getCfcastTtlTeuQty());
		this.hashColumns.put("srep_usr_id", getSrepUsrId());
		this.hashColumns.put("fcast_rf_qty", getFcastRfQty());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cfcast_rf_qty", getCfcastRfQty());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("usd_bkg_45ft_hc_qty", getUsdBkg45ftHcQty());
		this.hashColumns.put("fcast_45ft_hc_qty", getFcast45ftHcQty());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("fcast_cust_tp_cd", getFcastCustTpCd());
		this.hashColumns.put("usd_bkg_ttl_wgt", getUsdBkgTtlWgt());
		this.hashColumns.put("fcast_40ft_hc_qty", getFcast40ftHcQty());
		this.hashColumns.put("usd_bkg_20ft_dry_qty", getUsdBkg20ftDryQty());
		this.hashColumns.put("usd_bkg_rd_qty", getUsdBkgRdQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("fcast_rd_qty", "fcastRdQty");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("usa_bkg_mod_cd", "usaBkgModCd");
		this.hashFields.put("usd_bkg_53ft_qty", "usdBkg53ftQty");
		this.hashFields.put("fcast_20ft_dry_qty", "fcast20ftDryQty");
		this.hashFields.put("cfcast_40ft_hc_qty", "cfcast40ftHcQty");
		this.hashFields.put("usd_bkg_20ft_qty", "usdBkg20ftQty");
		this.hashFields.put("fcast_ttl_teu_qty", "fcastTtlTeuQty");
		this.hashFields.put("cfcast_ttl_wgt", "cfcastTtlWgt");
		this.hashFields.put("usd_bkg_40ft_qty", "usdBkg40ftQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cfcast_ttl_qty", "cfcastTtlQty");
		this.hashFields.put("fcast_ttl_qty", "fcastTtlQty");
		this.hashFields.put("cfcast_53ft_qty", "cfcast53ftQty");
		this.hashFields.put("usd_bkg_rf_qty", "usdBkgRfQty");
		this.hashFields.put("usd_bkg_ttl_qty", "usdBkgTtlQty");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("modi_usr", "modiUsr");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("fcast_53ft_qty", "fcast53ftQty");
		this.hashFields.put("usd_bkg_40ft_hc_qty", "usdBkg40ftHcQty");
		this.hashFields.put("fcast_ttl_wgt", "fcastTtlWgt");
		this.hashFields.put("cfcast_45ft_hc_qty", "cfcast45ftHcQty");
		this.hashFields.put("usd_bkg_40ft_dry_qty", "usdBkg40ftDryQty");
		this.hashFields.put("fcast_40ft_dry_qty", "fcast40ftDryQty");
		this.hashFields.put("modi_gdt", "modiGdt");
		this.hashFields.put("cfcast_ttl_teu_qty", "cfcastTtlTeuQty");
		this.hashFields.put("srep_usr_id", "srepUsrId");
		this.hashFields.put("fcast_rf_qty", "fcastRfQty");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cfcast_rf_qty", "cfcastRfQty");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("usd_bkg_45ft_hc_qty", "usdBkg45ftHcQty");
		this.hashFields.put("fcast_45ft_hc_qty", "fcast45ftHcQty");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("fcast_cust_tp_cd", "fcastCustTpCd");
		this.hashFields.put("usd_bkg_ttl_wgt", "usdBkgTtlWgt");
		this.hashFields.put("fcast_40ft_hc_qty", "fcast40ftHcQty");
		this.hashFields.put("usd_bkg_20ft_dry_qty", "usdBkg20ftDryQty");
		this.hashFields.put("usd_bkg_rd_qty", "usdBkgRdQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
	}
	
	/**
	 * Column Info
	 * @return fcastRdQty
	 */
	public String getFcastRdQty() {
		return this.fcastRdQty;
	}
	
	/**
	 * Column Info
	 * @return destLocCd
	 */
	public String getDestLocCd() {
		return this.destLocCd;
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
	 * @return usaBkgModCd
	 */
	public String getUsaBkgModCd() {
		return this.usaBkgModCd;
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
	 * @return fcast20ftDryQty
	 */
	public String getFcast20ftDryQty() {
		return this.fcast20ftDryQty;
	}
	
	/**
	 * Column Info
	 * @return cfcast40ftHcQty
	 */
	public String getCfcast40ftHcQty() {
		return this.cfcast40ftHcQty;
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
	 * @return cfcastTtlWgt
	 */
	public String getCfcastTtlWgt() {
		return this.cfcastTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return usdBkg40ftQty
	 */
	public String getUsdBkg40ftQty() {
		return this.usdBkg40ftQty;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cfcastTtlQty
	 */
	public String getCfcastTtlQty() {
		return this.cfcastTtlQty;
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
	 * @return cfcast53ftQty
	 */
	public String getCfcast53ftQty() {
		return this.cfcast53ftQty;
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
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
	}
	
	/**
	 * Column Info
	 * @return modiUsr
	 */
	public String getModiUsr() {
		return this.modiUsr;
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
	 * @return usdBkg40ftHcQty
	 */
	public String getUsdBkg40ftHcQty() {
		return this.usdBkg40ftHcQty;
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
	 * @return cfcast45ftHcQty
	 */
	public String getCfcast45ftHcQty() {
		return this.cfcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return usdBkg40ftDryQty
	 */
	public String getUsdBkg40ftDryQty() {
		return this.usdBkg40ftDryQty;
	}
	
	/**
	 * Column Info
	 * @return fcast40ftDryQty
	 */
	public String getFcast40ftDryQty() {
		return this.fcast40ftDryQty;
	}
	
	/**
	 * Column Info
	 * @return modiGdt
	 */
	public String getModiGdt() {
		return this.modiGdt;
	}
	
	/**
	 * Column Info
	 * @return cfcastTtlTeuQty
	 */
	public String getCfcastTtlTeuQty() {
		return this.cfcastTtlTeuQty;
	}
	
	/**
	 * Column Info
	 * @return srepUsrId
	 */
	public String getSrepUsrId() {
		return this.srepUsrId;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return cfcastRfQty
	 */
	public String getCfcastRfQty() {
		return this.cfcastRfQty;
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
	 * @return fcast45ftHcQty
	 */
	public String getFcast45ftHcQty() {
		return this.fcast45ftHcQty;
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
	 * @return fcastCustTpCd
	 */
	public String getFcastCustTpCd() {
		return this.fcastCustTpCd;
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
	 * @return usdBkg20ftDryQty
	 */
	public String getUsdBkg20ftDryQty() {
		return this.usdBkg20ftDryQty;
	}
	
	/**
	 * Column Info
	 * @return usdBkgRdQty
	 */
	public String getUsdBkgRdQty() {
		return this.usdBkgRdQty;
	}
	

	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}
	
	/**
	 * Column Info
	 * @param fcastRdQty
	 */
	public void setFcastRdQty(String fcastRdQty) {
		this.fcastRdQty = fcastRdQty;
	}
	
	/**
	 * Column Info
	 * @param destLocCd
	 */
	public void setDestLocCd(String destLocCd) {
		this.destLocCd = destLocCd;
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
	 * @param usaBkgModCd
	 */
	public void setUsaBkgModCd(String usaBkgModCd) {
		this.usaBkgModCd = usaBkgModCd;
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
	 * @param fcast20ftDryQty
	 */
	public void setFcast20ftDryQty(String fcast20ftDryQty) {
		this.fcast20ftDryQty = fcast20ftDryQty;
	}
	
	/**
	 * Column Info
	 * @param cfcast40ftHcQty
	 */
	public void setCfcast40ftHcQty(String cfcast40ftHcQty) {
		this.cfcast40ftHcQty = cfcast40ftHcQty;
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
	 * @param cfcastTtlWgt
	 */
	public void setCfcastTtlWgt(String cfcastTtlWgt) {
		this.cfcastTtlWgt = cfcastTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param usdBkg40ftQty
	 */
	public void setUsdBkg40ftQty(String usdBkg40ftQty) {
		this.usdBkg40ftQty = usdBkg40ftQty;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cfcastTtlQty
	 */
	public void setCfcastTtlQty(String cfcastTtlQty) {
		this.cfcastTtlQty = cfcastTtlQty;
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
	 * @param cfcast53ftQty
	 */
	public void setCfcast53ftQty(String cfcast53ftQty) {
		this.cfcast53ftQty = cfcast53ftQty;
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
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * Column Info
	 * @param modiUsr
	 */
	public void setModiUsr(String modiUsr) {
		this.modiUsr = modiUsr;
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
	 * @param usdBkg40ftHcQty
	 */
	public void setUsdBkg40ftHcQty(String usdBkg40ftHcQty) {
		this.usdBkg40ftHcQty = usdBkg40ftHcQty;
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
	 * @param cfcast45ftHcQty
	 */
	public void setCfcast45ftHcQty(String cfcast45ftHcQty) {
		this.cfcast45ftHcQty = cfcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param usdBkg40ftDryQty
	 */
	public void setUsdBkg40ftDryQty(String usdBkg40ftDryQty) {
		this.usdBkg40ftDryQty = usdBkg40ftDryQty;
	}
	
	/**
	 * Column Info
	 * @param fcast40ftDryQty
	 */
	public void setFcast40ftDryQty(String fcast40ftDryQty) {
		this.fcast40ftDryQty = fcast40ftDryQty;
	}
	
	/**
	 * Column Info
	 * @param modiGdt
	 */
	public void setModiGdt(String modiGdt) {
		this.modiGdt = modiGdt;
	}
	
	/**
	 * Column Info
	 * @param cfcastTtlTeuQty
	 */
	public void setCfcastTtlTeuQty(String cfcastTtlTeuQty) {
		this.cfcastTtlTeuQty = cfcastTtlTeuQty;
	}
	
	/**
	 * Column Info
	 * @param srepUsrId
	 */
	public void setSrepUsrId(String srepUsrId) {
		this.srepUsrId = srepUsrId;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param cfcastRfQty
	 */
	public void setCfcastRfQty(String cfcastRfQty) {
		this.cfcastRfQty = cfcastRfQty;
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
	 * @param fcast45ftHcQty
	 */
	public void setFcast45ftHcQty(String fcast45ftHcQty) {
		this.fcast45ftHcQty = fcast45ftHcQty;
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
	 * @param fcastCustTpCd
	 */
	public void setFcastCustTpCd(String fcastCustTpCd) {
		this.fcastCustTpCd = fcastCustTpCd;
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
	 * Column Info
	 * @param usdBkg20ftDryQty
	 */
	public void setUsdBkg20ftDryQty(String usdBkg20ftDryQty) {
		this.usdBkg20ftDryQty = usdBkg20ftDryQty;
	}
	
	/**
	 * Column Info
	 * @param usdBkgRdQty
	 */
	public void setUsdBkgRdQty(String usdBkgRdQty) {
		this.usdBkgRdQty = usdBkgRdQty;
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
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setFcastRdQty(JSPUtil.getParameter(request, prefix + "fcast_rd_qty", ""));
		setDestLocCd(JSPUtil.getParameter(request, prefix + "dest_loc_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setUsaBkgModCd(JSPUtil.getParameter(request, prefix + "usa_bkg_mod_cd", ""));
		setUsdBkg53ftQty(JSPUtil.getParameter(request, prefix + "usd_bkg_53ft_qty", ""));
		setFcast20ftDryQty(JSPUtil.getParameter(request, prefix + "fcast_20ft_dry_qty", ""));
		setCfcast40ftHcQty(JSPUtil.getParameter(request, prefix + "cfcast_40ft_hc_qty", ""));
		setUsdBkg20ftQty(JSPUtil.getParameter(request, prefix + "usd_bkg_20ft_qty", ""));
		setFcastTtlTeuQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_teu_qty", ""));
		setCfcastTtlWgt(JSPUtil.getParameter(request, prefix + "cfcast_ttl_wgt", ""));
		setUsdBkg40ftQty(JSPUtil.getParameter(request, prefix + "usd_bkg_40ft_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCfcastTtlQty(JSPUtil.getParameter(request, prefix + "cfcast_ttl_qty", ""));
		setFcastTtlQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_qty", ""));
		setCfcast53ftQty(JSPUtil.getParameter(request, prefix + "cfcast_53ft_qty", ""));
		setUsdBkgRfQty(JSPUtil.getParameter(request, prefix + "usd_bkg_rf_qty", ""));
		setUsdBkgTtlQty(JSPUtil.getParameter(request, prefix + "usd_bkg_ttl_qty", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setModiUsr(JSPUtil.getParameter(request, prefix + "modi_usr", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setFcast53ftQty(JSPUtil.getParameter(request, prefix + "fcast_53ft_qty", ""));
		setUsdBkg40ftHcQty(JSPUtil.getParameter(request, prefix + "usd_bkg_40ft_hc_qty", ""));
		setFcastTtlWgt(JSPUtil.getParameter(request, prefix + "fcast_ttl_wgt", ""));
		setCfcast45ftHcQty(JSPUtil.getParameter(request, prefix + "cfcast_45ft_hc_qty", ""));
		setUsdBkg40ftDryQty(JSPUtil.getParameter(request, prefix + "usd_bkg_40ft_dry_qty", ""));
		setFcast40ftDryQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_dry_qty", ""));
		setModiGdt(JSPUtil.getParameter(request, prefix + "modi_gdt", ""));
		setCfcastTtlTeuQty(JSPUtil.getParameter(request, prefix + "cfcast_ttl_teu_qty", ""));
		setSrepUsrId(JSPUtil.getParameter(request, prefix + "srep_usr_id", ""));
		setFcastRfQty(JSPUtil.getParameter(request, prefix + "fcast_rf_qty", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCfcastRfQty(JSPUtil.getParameter(request, prefix + "cfcast_rf_qty", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setUsdBkg45ftHcQty(JSPUtil.getParameter(request, prefix + "usd_bkg_45ft_hc_qty", ""));
		setFcast45ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_qty", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setFcastCustTpCd(JSPUtil.getParameter(request, prefix + "fcast_cust_tp_cd", ""));
		setUsdBkgTtlWgt(JSPUtil.getParameter(request, prefix + "usd_bkg_ttl_wgt", ""));
		setFcast40ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_qty", ""));
		setUsdBkg20ftDryQty(JSPUtil.getParameter(request, prefix + "usd_bkg_20ft_dry_qty", ""));
		setUsdBkgRdQty(JSPUtil.getParameter(request, prefix + "usd_bkg_rd_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDailyForecastHistorySrepAcctListVO[]
	 */
	public SearchDailyForecastHistorySrepAcctListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDailyForecastHistorySrepAcctListVO[]
	 */
	public SearchDailyForecastHistorySrepAcctListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDailyForecastHistorySrepAcctListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] fcastRdQty = (JSPUtil.getParameter(request, prefix	+ "fcast_rd_qty", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] usaBkgModCd = (JSPUtil.getParameter(request, prefix	+ "usa_bkg_mod_cd", length));
			String[] usdBkg53ftQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_53ft_qty", length));
			String[] fcast20ftDryQty = (JSPUtil.getParameter(request, prefix	+ "fcast_20ft_dry_qty", length));
			String[] cfcast40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "cfcast_40ft_hc_qty", length));
			String[] usdBkg20ftQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_20ft_qty", length));
			String[] fcastTtlTeuQty = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_teu_qty", length));
			String[] cfcastTtlWgt = (JSPUtil.getParameter(request, prefix	+ "cfcast_ttl_wgt", length));
			String[] usdBkg40ftQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_40ft_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cfcastTtlQty = (JSPUtil.getParameter(request, prefix	+ "cfcast_ttl_qty", length));
			String[] fcastTtlQty = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_qty", length));
			String[] cfcast53ftQty = (JSPUtil.getParameter(request, prefix	+ "cfcast_53ft_qty", length));
			String[] usdBkgRfQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_rf_qty", length));
			String[] usdBkgTtlQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_ttl_qty", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] modiUsr = (JSPUtil.getParameter(request, prefix	+ "modi_usr", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] fcast53ftQty = (JSPUtil.getParameter(request, prefix	+ "fcast_53ft_qty", length));
			String[] usdBkg40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_40ft_hc_qty", length));
			String[] fcastTtlWgt = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_wgt", length));
			String[] cfcast45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "cfcast_45ft_hc_qty", length));
			String[] usdBkg40ftDryQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_40ft_dry_qty", length));
			String[] fcast40ftDryQty = (JSPUtil.getParameter(request, prefix	+ "fcast_40ft_dry_qty", length));
			String[] modiGdt = (JSPUtil.getParameter(request, prefix	+ "modi_gdt", length));
			String[] cfcastTtlTeuQty = (JSPUtil.getParameter(request, prefix	+ "cfcast_ttl_teu_qty", length));
			String[] srepUsrId = (JSPUtil.getParameter(request, prefix	+ "srep_usr_id", length));
			String[] fcastRfQty = (JSPUtil.getParameter(request, prefix	+ "fcast_rf_qty", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cfcastRfQty = (JSPUtil.getParameter(request, prefix	+ "cfcast_rf_qty", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] usdBkg45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_45ft_hc_qty", length));
			String[] fcast45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "fcast_45ft_hc_qty", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] fcastCustTpCd = (JSPUtil.getParameter(request, prefix	+ "fcast_cust_tp_cd", length));
			String[] usdBkgTtlWgt = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_ttl_wgt", length));
			String[] fcast40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "fcast_40ft_hc_qty", length));
			String[] usdBkg20ftDryQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_20ft_dry_qty", length));
			String[] usdBkgRdQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_rd_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDailyForecastHistorySrepAcctListVO();
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (fcastRdQty[i] != null)
					model.setFcastRdQty(fcastRdQty[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (usaBkgModCd[i] != null)
					model.setUsaBkgModCd(usaBkgModCd[i]);
				if (usdBkg53ftQty[i] != null)
					model.setUsdBkg53ftQty(usdBkg53ftQty[i]);
				if (fcast20ftDryQty[i] != null)
					model.setFcast20ftDryQty(fcast20ftDryQty[i]);
				if (cfcast40ftHcQty[i] != null)
					model.setCfcast40ftHcQty(cfcast40ftHcQty[i]);
				if (usdBkg20ftQty[i] != null)
					model.setUsdBkg20ftQty(usdBkg20ftQty[i]);
				if (fcastTtlTeuQty[i] != null)
					model.setFcastTtlTeuQty(fcastTtlTeuQty[i]);
				if (cfcastTtlWgt[i] != null)
					model.setCfcastTtlWgt(cfcastTtlWgt[i]);
				if (usdBkg40ftQty[i] != null)
					model.setUsdBkg40ftQty(usdBkg40ftQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cfcastTtlQty[i] != null)
					model.setCfcastTtlQty(cfcastTtlQty[i]);
				if (fcastTtlQty[i] != null)
					model.setFcastTtlQty(fcastTtlQty[i]);
				if (cfcast53ftQty[i] != null)
					model.setCfcast53ftQty(cfcast53ftQty[i]);
				if (usdBkgRfQty[i] != null)
					model.setUsdBkgRfQty(usdBkgRfQty[i]);
				if (usdBkgTtlQty[i] != null)
					model.setUsdBkgTtlQty(usdBkgTtlQty[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (modiUsr[i] != null)
					model.setModiUsr(modiUsr[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (fcast53ftQty[i] != null)
					model.setFcast53ftQty(fcast53ftQty[i]);
				if (usdBkg40ftHcQty[i] != null)
					model.setUsdBkg40ftHcQty(usdBkg40ftHcQty[i]);
				if (fcastTtlWgt[i] != null)
					model.setFcastTtlWgt(fcastTtlWgt[i]);
				if (cfcast45ftHcQty[i] != null)
					model.setCfcast45ftHcQty(cfcast45ftHcQty[i]);
				if (usdBkg40ftDryQty[i] != null)
					model.setUsdBkg40ftDryQty(usdBkg40ftDryQty[i]);
				if (fcast40ftDryQty[i] != null)
					model.setFcast40ftDryQty(fcast40ftDryQty[i]);
				if (modiGdt[i] != null)
					model.setModiGdt(modiGdt[i]);
				if (cfcastTtlTeuQty[i] != null)
					model.setCfcastTtlTeuQty(cfcastTtlTeuQty[i]);
				if (srepUsrId[i] != null)
					model.setSrepUsrId(srepUsrId[i]);
				if (fcastRfQty[i] != null)
					model.setFcastRfQty(fcastRfQty[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cfcastRfQty[i] != null)
					model.setCfcastRfQty(cfcastRfQty[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (usdBkg45ftHcQty[i] != null)
					model.setUsdBkg45ftHcQty(usdBkg45ftHcQty[i]);
				if (fcast45ftHcQty[i] != null)
					model.setFcast45ftHcQty(fcast45ftHcQty[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (fcastCustTpCd[i] != null)
					model.setFcastCustTpCd(fcastCustTpCd[i]);
				if (usdBkgTtlWgt[i] != null)
					model.setUsdBkgTtlWgt(usdBkgTtlWgt[i]);
				if (fcast40ftHcQty[i] != null)
					model.setFcast40ftHcQty(fcast40ftHcQty[i]);
				if (usdBkg20ftDryQty[i] != null)
					model.setUsdBkg20ftDryQty(usdBkg20ftDryQty[i]);
				if (usdBkgRdQty[i] != null)
					model.setUsdBkgRdQty(usdBkgRdQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDailyForecastHistorySrepAcctListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDailyForecastHistorySrepAcctListVO[]
	 */
	public SearchDailyForecastHistorySrepAcctListVO[] getSearchDailyForecastHistorySrepAcctListVOs(){
		SearchDailyForecastHistorySrepAcctListVO[] vos = (SearchDailyForecastHistorySrepAcctListVO[])models.toArray(new SearchDailyForecastHistorySrepAcctListVO[models.size()]);
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
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRdQty = this.fcastRdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaBkgModCd = this.usaBkgModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg53ftQty = this.usdBkg53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast20ftDryQty = this.fcast20ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfcast40ftHcQty = this.cfcast40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg20ftQty = this.usdBkg20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlTeuQty = this.fcastTtlTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfcastTtlWgt = this.cfcastTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg40ftQty = this.usdBkg40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfcastTtlQty = this.cfcastTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlQty = this.fcastTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfcast53ftQty = this.cfcast53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgRfQty = this.usdBkgRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgTtlQty = this.usdBkgTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiUsr = this.modiUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast53ftQty = this.fcast53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg40ftHcQty = this.usdBkg40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlWgt = this.fcastTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfcast45ftHcQty = this.cfcast45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg40ftDryQty = this.usdBkg40ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40ftDryQty = this.fcast40ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiGdt = this.modiGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfcastTtlTeuQty = this.cfcastTtlTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepUsrId = this.srepUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRfQty = this.fcastRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfcastRfQty = this.cfcastRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg45ftHcQty = this.usdBkg45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast45ftHcQty = this.fcast45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCustTpCd = this.fcastCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgTtlWgt = this.usdBkgTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40ftHcQty = this.fcast40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg20ftDryQty = this.usdBkg20ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgRdQty = this.usdBkgRdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
