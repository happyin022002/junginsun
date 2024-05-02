/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchDailyForecastHistoryOfcListVO.java
*@FileTitle : SearchDailyForecastHistoryOfcListVO
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

public class SearchDailyForecastHistoryOfcListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDailyForecastHistoryOfcListVO> models = new ArrayList<SearchDailyForecastHistoryOfcListVO>();
	
	/* Column Info */
	private String fcastRdQty = null;
	/* Column Info */
	private String aloc40ftDryQty = null;
	/* Column Info */
	private String aloc53ftQty = null;
	/* Column Info */
	private String fcast20ftDryQty = null;
	/* Column Info */
	private String alocTtlWgt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String cfcastTtlWgt = null;
	/* Column Info */
	private String bkgTtlTeuQty = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String bkg40ftDryQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkg45ftHcQty = null;
	/* Column Info */
	private String cfcast53ftQty = null;
	/* Column Info */
	private String fcastLodQty = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String aloc45ftHcQty = null;
	/* Column Info */
	private String bkgRfQty = null;
	/* Column Info */
	private String fcast40ftDryQty = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String alocTtlQty = null;
	/* Column Info */
	private String fcastRfQty = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bseDt = null;
	/* Column Info */
	private String bkgTtlWgt = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String bkg20ftDryQty = null;
	/* Column Info */
	private String bkg40ftQty = null;
	/* Column Info */
	private String fcast40ftHcQty = null;
	/* Column Info */
	private String bkg40ftHcQty = null;
	/* Column Info */
	private String cfcastLodQty = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String destLocCd = null;
	/* Column Info */
	private String usaBkgModCd = null;
	/* Column Info */
	private String cfcast40ftHcQty = null;
	/* Column Info */
	private String fcastTtlTeuQty = null;
	/* Column Info */
	private String bkg20ftQty = null;
	/* Column Info */
	private String alocRfQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aloc40ftHcQty = null;
	/* Column Info */
	private String fcast53ftQty = null;
	/* Column Info */
	private String aloc20ftDryQty = null;
	/* Column Info */
	private String fcastTtlWgt = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String cfcast45ftHcQty = null;
	/* Column Info */
	private String bkgRdQty = null;
	/* Column Info */
	private String alocRdQty = null;
	/* Column Info */
	private String cfcastTtlTeuQty = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cfcastRfQty = null;
	/* Column Info */
	private String fcast45ftHcQty = null;
	/* Column Info */
	private String bkg53ftQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchDailyForecastHistoryOfcListVO() {}

	public SearchDailyForecastHistoryOfcListVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String rlaneCd, String skdDirCd, String iocCd, String slsOfcCd, String bseWk, String vvd, String bseDt, String usaBkgModCd, String custCtrlCd, String polCd, String podCd, String destLocCd, String fcastTtlTeuQty, String fcastLodQty, String fcast20ftDryQty, String fcast40ftDryQty, String fcast40ftHcQty, String fcast45ftHcQty, String fcast53ftQty, String fcastRfQty, String fcastRdQty, String fcastTtlWgt, String cfcastTtlTeuQty, String cfcastLodQty, String cfcast40ftHcQty, String cfcast45ftHcQty, String cfcast53ftQty, String cfcastRfQty, String cfcastTtlWgt, String alocTtlQty, String aloc20ftDryQty, String aloc40ftDryQty, String aloc40ftHcQty, String aloc45ftHcQty, String aloc53ftQty, String alocRfQty, String alocRdQty, String alocTtlWgt, String bkgTtlTeuQty, String bkg20ftQty, String bkg40ftQty, String bkg20ftDryQty, String bkg40ftDryQty, String bkg40ftHcQty, String bkg45ftHcQty, String bkg53ftQty, String bkgRfQty, String bkgRdQty, String bkgTtlWgt, String lvl, String contiCd) {
		this.fcastRdQty = fcastRdQty;
		this.aloc40ftDryQty = aloc40ftDryQty;
		this.aloc53ftQty = aloc53ftQty;
		this.fcast20ftDryQty = fcast20ftDryQty;
		this.alocTtlWgt = alocTtlWgt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.cfcastTtlWgt = cfcastTtlWgt;
		this.bkgTtlTeuQty = bkgTtlTeuQty;
		this.custCtrlCd = custCtrlCd;
		this.bkg40ftDryQty = bkg40ftDryQty;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.bkg45ftHcQty = bkg45ftHcQty;
		this.cfcast53ftQty = cfcast53ftQty;
		this.fcastLodQty = fcastLodQty;
		this.slsOfcCd = slsOfcCd;
		this.aloc45ftHcQty = aloc45ftHcQty;
		this.bkgRfQty = bkgRfQty;
		this.fcast40ftDryQty = fcast40ftDryQty;
		this.bseWk = bseWk;
		this.alocTtlQty = alocTtlQty;
		this.fcastRfQty = fcastRfQty;
		this.podCd = podCd;
		this.vvd = vvd;
		this.bseDt = bseDt;
		this.bkgTtlWgt = bkgTtlWgt;
		this.lvl = lvl;
		this.bkg20ftDryQty = bkg20ftDryQty;
		this.bkg40ftQty = bkg40ftQty;
		this.fcast40ftHcQty = fcast40ftHcQty;
		this.bkg40ftHcQty = bkg40ftHcQty;
		this.cfcastLodQty = cfcastLodQty;
		this.subTrdCd = subTrdCd;
		this.contiCd = contiCd;
		this.destLocCd = destLocCd;
		this.usaBkgModCd = usaBkgModCd;
		this.cfcast40ftHcQty = cfcast40ftHcQty;
		this.fcastTtlTeuQty = fcastTtlTeuQty;
		this.bkg20ftQty = bkg20ftQty;
		this.alocRfQty = alocRfQty;
		this.ibflag = ibflag;
		this.aloc40ftHcQty = aloc40ftHcQty;
		this.fcast53ftQty = fcast53ftQty;
		this.aloc20ftDryQty = aloc20ftDryQty;
		this.fcastTtlWgt = fcastTtlWgt;
		this.iocCd = iocCd;
		this.cfcast45ftHcQty = cfcast45ftHcQty;
		this.bkgRdQty = bkgRdQty;
		this.alocRdQty = alocRdQty;
		this.cfcastTtlTeuQty = cfcastTtlTeuQty;
		this.skdDirCd = skdDirCd;
		this.cfcastRfQty = cfcastRfQty;
		this.fcast45ftHcQty = fcast45ftHcQty;
		this.bkg53ftQty = bkg53ftQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fcast_rd_qty", getFcastRdQty());
		this.hashColumns.put("aloc_40ft_dry_qty", getAloc40ftDryQty());
		this.hashColumns.put("aloc_53ft_qty", getAloc53ftQty());
		this.hashColumns.put("fcast_20ft_dry_qty", getFcast20ftDryQty());
		this.hashColumns.put("aloc_ttl_wgt", getAlocTtlWgt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("cfcast_ttl_wgt", getCfcastTtlWgt());
		this.hashColumns.put("bkg_ttl_teu_qty", getBkgTtlTeuQty());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("bkg_40ft_dry_qty", getBkg40ftDryQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_45ft_hc_qty", getBkg45ftHcQty());
		this.hashColumns.put("cfcast_53ft_qty", getCfcast53ftQty());
		this.hashColumns.put("fcast_lod_qty", getFcastLodQty());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("aloc_45ft_hc_qty", getAloc45ftHcQty());
		this.hashColumns.put("bkg_rf_qty", getBkgRfQty());
		this.hashColumns.put("fcast_40ft_dry_qty", getFcast40ftDryQty());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("aloc_ttl_qty", getAlocTtlQty());
		this.hashColumns.put("fcast_rf_qty", getFcastRfQty());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bse_dt", getBseDt());
		this.hashColumns.put("bkg_ttl_wgt", getBkgTtlWgt());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("bkg_20ft_dry_qty", getBkg20ftDryQty());
		this.hashColumns.put("bkg_40ft_qty", getBkg40ftQty());
		this.hashColumns.put("fcast_40ft_hc_qty", getFcast40ftHcQty());
		this.hashColumns.put("bkg_40ft_hc_qty", getBkg40ftHcQty());
		this.hashColumns.put("cfcast_lod_qty", getCfcastLodQty());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("usa_bkg_mod_cd", getUsaBkgModCd());
		this.hashColumns.put("cfcast_40ft_hc_qty", getCfcast40ftHcQty());
		this.hashColumns.put("fcast_ttl_teu_qty", getFcastTtlTeuQty());
		this.hashColumns.put("bkg_20ft_qty", getBkg20ftQty());
		this.hashColumns.put("aloc_rf_qty", getAlocRfQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aloc_40ft_hc_qty", getAloc40ftHcQty());
		this.hashColumns.put("fcast_53ft_qty", getFcast53ftQty());
		this.hashColumns.put("aloc_20ft_dry_qty", getAloc20ftDryQty());
		this.hashColumns.put("fcast_ttl_wgt", getFcastTtlWgt());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("cfcast_45ft_hc_qty", getCfcast45ftHcQty());
		this.hashColumns.put("bkg_rd_qty", getBkgRdQty());
		this.hashColumns.put("aloc_rd_qty", getAlocRdQty());
		this.hashColumns.put("cfcast_ttl_teu_qty", getCfcastTtlTeuQty());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cfcast_rf_qty", getCfcastRfQty());
		this.hashColumns.put("fcast_45ft_hc_qty", getFcast45ftHcQty());
		this.hashColumns.put("bkg_53ft_qty", getBkg53ftQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fcast_rd_qty", "fcastRdQty");
		this.hashFields.put("aloc_40ft_dry_qty", "aloc40ftDryQty");
		this.hashFields.put("aloc_53ft_qty", "aloc53ftQty");
		this.hashFields.put("fcast_20ft_dry_qty", "fcast20ftDryQty");
		this.hashFields.put("aloc_ttl_wgt", "alocTtlWgt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("cfcast_ttl_wgt", "cfcastTtlWgt");
		this.hashFields.put("bkg_ttl_teu_qty", "bkgTtlTeuQty");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("bkg_40ft_dry_qty", "bkg40ftDryQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_45ft_hc_qty", "bkg45ftHcQty");
		this.hashFields.put("cfcast_53ft_qty", "cfcast53ftQty");
		this.hashFields.put("fcast_lod_qty", "fcastLodQty");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("aloc_45ft_hc_qty", "aloc45ftHcQty");
		this.hashFields.put("bkg_rf_qty", "bkgRfQty");
		this.hashFields.put("fcast_40ft_dry_qty", "fcast40ftDryQty");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("aloc_ttl_qty", "alocTtlQty");
		this.hashFields.put("fcast_rf_qty", "fcastRfQty");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bse_dt", "bseDt");
		this.hashFields.put("bkg_ttl_wgt", "bkgTtlWgt");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("bkg_20ft_dry_qty", "bkg20ftDryQty");
		this.hashFields.put("bkg_40ft_qty", "bkg40ftQty");
		this.hashFields.put("fcast_40ft_hc_qty", "fcast40ftHcQty");
		this.hashFields.put("bkg_40ft_hc_qty", "bkg40ftHcQty");
		this.hashFields.put("cfcast_lod_qty", "cfcastLodQty");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("usa_bkg_mod_cd", "usaBkgModCd");
		this.hashFields.put("cfcast_40ft_hc_qty", "cfcast40ftHcQty");
		this.hashFields.put("fcast_ttl_teu_qty", "fcastTtlTeuQty");
		this.hashFields.put("bkg_20ft_qty", "bkg20ftQty");
		this.hashFields.put("aloc_rf_qty", "alocRfQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aloc_40ft_hc_qty", "aloc40ftHcQty");
		this.hashFields.put("fcast_53ft_qty", "fcast53ftQty");
		this.hashFields.put("aloc_20ft_dry_qty", "aloc20ftDryQty");
		this.hashFields.put("fcast_ttl_wgt", "fcastTtlWgt");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("cfcast_45ft_hc_qty", "cfcast45ftHcQty");
		this.hashFields.put("bkg_rd_qty", "bkgRdQty");
		this.hashFields.put("aloc_rd_qty", "alocRdQty");
		this.hashFields.put("cfcast_ttl_teu_qty", "cfcastTtlTeuQty");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cfcast_rf_qty", "cfcastRfQty");
		this.hashFields.put("fcast_45ft_hc_qty", "fcast45ftHcQty");
		this.hashFields.put("bkg_53ft_qty", "bkg53ftQty");
		return this.hashFields;
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
	 * @return aloc40ftDryQty
	 */
	public String getAloc40ftDryQty() {
		return this.aloc40ftDryQty;
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
	 * @return fcast20ftDryQty
	 */
	public String getFcast20ftDryQty() {
		return this.fcast20ftDryQty;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return bkgTtlTeuQty
	 */
	public String getBkgTtlTeuQty() {
		return this.bkgTtlTeuQty;
	}
	
	/**
	 * Column Info
	 * @return custCtrlCd
	 */
	public String getCustCtrlCd() {
		return this.custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @return bkg40ftDryQty
	 */
	public String getBkg40ftDryQty() {
		return this.bkg40ftDryQty;
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
	 * Column Info
	 * @return bkg45ftHcQty
	 */
	public String getBkg45ftHcQty() {
		return this.bkg45ftHcQty;
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
	 * @return fcastLodQty
	 */
	public String getFcastLodQty() {
		return this.fcastLodQty;
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
	 * @return aloc45ftHcQty
	 */
	public String getAloc45ftHcQty() {
		return this.aloc45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return bkgRfQty
	 */
	public String getBkgRfQty() {
		return this.bkgRfQty;
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
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
	}
	
	/**
	 * Column Info
	 * @return alocTtlQty
	 */
	public String getAlocTtlQty() {
		return this.alocTtlQty;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return bseDt
	 */
	public String getBseDt() {
		return this.bseDt;
	}
	
	/**
	 * Column Info
	 * @return bkgTtlWgt
	 */
	public String getBkgTtlWgt() {
		return this.bkgTtlWgt;
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
	 * @return bkg20ftDryQty
	 */
	public String getBkg20ftDryQty() {
		return this.bkg20ftDryQty;
	}
	
	/**
	 * Column Info
	 * @return bkg40ftQty
	 */
	public String getBkg40ftQty() {
		return this.bkg40ftQty;
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
	 * @return bkg40ftHcQty
	 */
	public String getBkg40ftHcQty() {
		return this.bkg40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return cfcastLodQty
	 */
	public String getCfcastLodQty() {
		return this.cfcastLodQty;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @return destLocCd
	 */
	public String getDestLocCd() {
		return this.destLocCd;
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
	 * @return cfcast40ftHcQty
	 */
	public String getCfcast40ftHcQty() {
		return this.cfcast40ftHcQty;
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
	 * @return bkg20ftQty
	 */
	public String getBkg20ftQty() {
		return this.bkg20ftQty;
	}
	
	/**
	 * Column Info
	 * @return alocRfQty
	 */
	public String getAlocRfQty() {
		return this.alocRfQty;
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
	 * @return aloc40ftHcQty
	 */
	public String getAloc40ftHcQty() {
		return this.aloc40ftHcQty;
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
	 * @return aloc20ftDryQty
	 */
	public String getAloc20ftDryQty() {
		return this.aloc20ftDryQty;
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
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
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
	 * @return bkgRdQty
	 */
	public String getBkgRdQty() {
		return this.bkgRdQty;
	}
	
	/**
	 * Column Info
	 * @return alocRdQty
	 */
	public String getAlocRdQty() {
		return this.alocRdQty;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return fcast45ftHcQty
	 */
	public String getFcast45ftHcQty() {
		return this.fcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return bkg53ftQty
	 */
	public String getBkg53ftQty() {
		return this.bkg53ftQty;
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
	 * @param aloc40ftDryQty
	 */
	public void setAloc40ftDryQty(String aloc40ftDryQty) {
		this.aloc40ftDryQty = aloc40ftDryQty;
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
	 * @param fcast20ftDryQty
	 */
	public void setFcast20ftDryQty(String fcast20ftDryQty) {
		this.fcast20ftDryQty = fcast20ftDryQty;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param bkgTtlTeuQty
	 */
	public void setBkgTtlTeuQty(String bkgTtlTeuQty) {
		this.bkgTtlTeuQty = bkgTtlTeuQty;
	}
	
	/**
	 * Column Info
	 * @param custCtrlCd
	 */
	public void setCustCtrlCd(String custCtrlCd) {
		this.custCtrlCd = custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @param bkg40ftDryQty
	 */
	public void setBkg40ftDryQty(String bkg40ftDryQty) {
		this.bkg40ftDryQty = bkg40ftDryQty;
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
	 * Column Info
	 * @param bkg45ftHcQty
	 */
	public void setBkg45ftHcQty(String bkg45ftHcQty) {
		this.bkg45ftHcQty = bkg45ftHcQty;
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
	 * @param fcastLodQty
	 */
	public void setFcastLodQty(String fcastLodQty) {
		this.fcastLodQty = fcastLodQty;
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
	 * @param aloc45ftHcQty
	 */
	public void setAloc45ftHcQty(String aloc45ftHcQty) {
		this.aloc45ftHcQty = aloc45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param bkgRfQty
	 */
	public void setBkgRfQty(String bkgRfQty) {
		this.bkgRfQty = bkgRfQty;
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
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
	}
	
	/**
	 * Column Info
	 * @param alocTtlQty
	 */
	public void setAlocTtlQty(String alocTtlQty) {
		this.alocTtlQty = alocTtlQty;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param bseDt
	 */
	public void setBseDt(String bseDt) {
		this.bseDt = bseDt;
	}
	
	/**
	 * Column Info
	 * @param bkgTtlWgt
	 */
	public void setBkgTtlWgt(String bkgTtlWgt) {
		this.bkgTtlWgt = bkgTtlWgt;
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
	 * @param bkg20ftDryQty
	 */
	public void setBkg20ftDryQty(String bkg20ftDryQty) {
		this.bkg20ftDryQty = bkg20ftDryQty;
	}
	
	/**
	 * Column Info
	 * @param bkg40ftQty
	 */
	public void setBkg40ftQty(String bkg40ftQty) {
		this.bkg40ftQty = bkg40ftQty;
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
	 * @param bkg40ftHcQty
	 */
	public void setBkg40ftHcQty(String bkg40ftHcQty) {
		this.bkg40ftHcQty = bkg40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param cfcastLodQty
	 */
	public void setCfcastLodQty(String cfcastLodQty) {
		this.cfcastLodQty = cfcastLodQty;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
	 * @param destLocCd
	 */
	public void setDestLocCd(String destLocCd) {
		this.destLocCd = destLocCd;
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
	 * @param cfcast40ftHcQty
	 */
	public void setCfcast40ftHcQty(String cfcast40ftHcQty) {
		this.cfcast40ftHcQty = cfcast40ftHcQty;
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
	 * @param bkg20ftQty
	 */
	public void setBkg20ftQty(String bkg20ftQty) {
		this.bkg20ftQty = bkg20ftQty;
	}
	
	/**
	 * Column Info
	 * @param alocRfQty
	 */
	public void setAlocRfQty(String alocRfQty) {
		this.alocRfQty = alocRfQty;
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
	 * @param aloc40ftHcQty
	 */
	public void setAloc40ftHcQty(String aloc40ftHcQty) {
		this.aloc40ftHcQty = aloc40ftHcQty;
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
	 * @param aloc20ftDryQty
	 */
	public void setAloc20ftDryQty(String aloc20ftDryQty) {
		this.aloc20ftDryQty = aloc20ftDryQty;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
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
	 * @param bkgRdQty
	 */
	public void setBkgRdQty(String bkgRdQty) {
		this.bkgRdQty = bkgRdQty;
	}
	
	/**
	 * Column Info
	 * @param alocRdQty
	 */
	public void setAlocRdQty(String alocRdQty) {
		this.alocRdQty = alocRdQty;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param fcast45ftHcQty
	 */
	public void setFcast45ftHcQty(String fcast45ftHcQty) {
		this.fcast45ftHcQty = fcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param bkg53ftQty
	 */
	public void setBkg53ftQty(String bkg53ftQty) {
		this.bkg53ftQty = bkg53ftQty;
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
		setFcastRdQty(JSPUtil.getParameter(request, prefix + "fcast_rd_qty", ""));
		setAloc40ftDryQty(JSPUtil.getParameter(request, prefix + "aloc_40ft_dry_qty", ""));
		setAloc53ftQty(JSPUtil.getParameter(request, prefix + "aloc_53ft_qty", ""));
		setFcast20ftDryQty(JSPUtil.getParameter(request, prefix + "fcast_20ft_dry_qty", ""));
		setAlocTtlWgt(JSPUtil.getParameter(request, prefix + "aloc_ttl_wgt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setCfcastTtlWgt(JSPUtil.getParameter(request, prefix + "cfcast_ttl_wgt", ""));
		setBkgTtlTeuQty(JSPUtil.getParameter(request, prefix + "bkg_ttl_teu_qty", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setBkg40ftDryQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_dry_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBkg45ftHcQty(JSPUtil.getParameter(request, prefix + "bkg_45ft_hc_qty", ""));
		setCfcast53ftQty(JSPUtil.getParameter(request, prefix + "cfcast_53ft_qty", ""));
		setFcastLodQty(JSPUtil.getParameter(request, prefix + "fcast_lod_qty", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setAloc45ftHcQty(JSPUtil.getParameter(request, prefix + "aloc_45ft_hc_qty", ""));
		setBkgRfQty(JSPUtil.getParameter(request, prefix + "bkg_rf_qty", ""));
		setFcast40ftDryQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_dry_qty", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setAlocTtlQty(JSPUtil.getParameter(request, prefix + "aloc_ttl_qty", ""));
		setFcastRfQty(JSPUtil.getParameter(request, prefix + "fcast_rf_qty", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBseDt(JSPUtil.getParameter(request, prefix + "bse_dt", ""));
		setBkgTtlWgt(JSPUtil.getParameter(request, prefix + "bkg_ttl_wgt", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setBkg20ftDryQty(JSPUtil.getParameter(request, prefix + "bkg_20ft_dry_qty", ""));
		setBkg40ftQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_qty", ""));
		setFcast40ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_qty", ""));
		setBkg40ftHcQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_hc_qty", ""));
		setCfcastLodQty(JSPUtil.getParameter(request, prefix + "cfcast_lod_qty", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setDestLocCd(JSPUtil.getParameter(request, prefix + "dest_loc_cd", ""));
		setUsaBkgModCd(JSPUtil.getParameter(request, prefix + "usa_bkg_mod_cd", ""));
		setCfcast40ftHcQty(JSPUtil.getParameter(request, prefix + "cfcast_40ft_hc_qty", ""));
		setFcastTtlTeuQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_teu_qty", ""));
		setBkg20ftQty(JSPUtil.getParameter(request, prefix + "bkg_20ft_qty", ""));
		setAlocRfQty(JSPUtil.getParameter(request, prefix + "aloc_rf_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAloc40ftHcQty(JSPUtil.getParameter(request, prefix + "aloc_40ft_hc_qty", ""));
		setFcast53ftQty(JSPUtil.getParameter(request, prefix + "fcast_53ft_qty", ""));
		setAloc20ftDryQty(JSPUtil.getParameter(request, prefix + "aloc_20ft_dry_qty", ""));
		setFcastTtlWgt(JSPUtil.getParameter(request, prefix + "fcast_ttl_wgt", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setCfcast45ftHcQty(JSPUtil.getParameter(request, prefix + "cfcast_45ft_hc_qty", ""));
		setBkgRdQty(JSPUtil.getParameter(request, prefix + "bkg_rd_qty", ""));
		setAlocRdQty(JSPUtil.getParameter(request, prefix + "aloc_rd_qty", ""));
		setCfcastTtlTeuQty(JSPUtil.getParameter(request, prefix + "cfcast_ttl_teu_qty", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCfcastRfQty(JSPUtil.getParameter(request, prefix + "cfcast_rf_qty", ""));
		setFcast45ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_qty", ""));
		setBkg53ftQty(JSPUtil.getParameter(request, prefix + "bkg_53ft_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDailyForecastHistoryOfcListVO[]
	 */
	public SearchDailyForecastHistoryOfcListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDailyForecastHistoryOfcListVO[]
	 */
	public SearchDailyForecastHistoryOfcListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDailyForecastHistoryOfcListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fcastRdQty = (JSPUtil.getParameter(request, prefix	+ "fcast_rd_qty", length));
			String[] aloc40ftDryQty = (JSPUtil.getParameter(request, prefix	+ "aloc_40ft_dry_qty", length));
			String[] aloc53ftQty = (JSPUtil.getParameter(request, prefix	+ "aloc_53ft_qty", length));
			String[] fcast20ftDryQty = (JSPUtil.getParameter(request, prefix	+ "fcast_20ft_dry_qty", length));
			String[] alocTtlWgt = (JSPUtil.getParameter(request, prefix	+ "aloc_ttl_wgt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] cfcastTtlWgt = (JSPUtil.getParameter(request, prefix	+ "cfcast_ttl_wgt", length));
			String[] bkgTtlTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl_teu_qty", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] bkg40ftDryQty = (JSPUtil.getParameter(request, prefix	+ "bkg_40ft_dry_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkg45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "bkg_45ft_hc_qty", length));
			String[] cfcast53ftQty = (JSPUtil.getParameter(request, prefix	+ "cfcast_53ft_qty", length));
			String[] fcastLodQty = (JSPUtil.getParameter(request, prefix	+ "fcast_lod_qty", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] aloc45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "aloc_45ft_hc_qty", length));
			String[] bkgRfQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_qty", length));
			String[] fcast40ftDryQty = (JSPUtil.getParameter(request, prefix	+ "fcast_40ft_dry_qty", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] alocTtlQty = (JSPUtil.getParameter(request, prefix	+ "aloc_ttl_qty", length));
			String[] fcastRfQty = (JSPUtil.getParameter(request, prefix	+ "fcast_rf_qty", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bseDt = (JSPUtil.getParameter(request, prefix	+ "bse_dt", length));
			String[] bkgTtlWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl_wgt", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] bkg20ftDryQty = (JSPUtil.getParameter(request, prefix	+ "bkg_20ft_dry_qty", length));
			String[] bkg40ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_40ft_qty", length));
			String[] fcast40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "fcast_40ft_hc_qty", length));
			String[] bkg40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "bkg_40ft_hc_qty", length));
			String[] cfcastLodQty = (JSPUtil.getParameter(request, prefix	+ "cfcast_lod_qty", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] usaBkgModCd = (JSPUtil.getParameter(request, prefix	+ "usa_bkg_mod_cd", length));
			String[] cfcast40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "cfcast_40ft_hc_qty", length));
			String[] fcastTtlTeuQty = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_teu_qty", length));
			String[] bkg20ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_20ft_qty", length));
			String[] alocRfQty = (JSPUtil.getParameter(request, prefix	+ "aloc_rf_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aloc40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "aloc_40ft_hc_qty", length));
			String[] fcast53ftQty = (JSPUtil.getParameter(request, prefix	+ "fcast_53ft_qty", length));
			String[] aloc20ftDryQty = (JSPUtil.getParameter(request, prefix	+ "aloc_20ft_dry_qty", length));
			String[] fcastTtlWgt = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_wgt", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] cfcast45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "cfcast_45ft_hc_qty", length));
			String[] bkgRdQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rd_qty", length));
			String[] alocRdQty = (JSPUtil.getParameter(request, prefix	+ "aloc_rd_qty", length));
			String[] cfcastTtlTeuQty = (JSPUtil.getParameter(request, prefix	+ "cfcast_ttl_teu_qty", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cfcastRfQty = (JSPUtil.getParameter(request, prefix	+ "cfcast_rf_qty", length));
			String[] fcast45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "fcast_45ft_hc_qty", length));
			String[] bkg53ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_53ft_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDailyForecastHistoryOfcListVO();
				if (fcastRdQty[i] != null)
					model.setFcastRdQty(fcastRdQty[i]);
				if (aloc40ftDryQty[i] != null)
					model.setAloc40ftDryQty(aloc40ftDryQty[i]);
				if (aloc53ftQty[i] != null)
					model.setAloc53ftQty(aloc53ftQty[i]);
				if (fcast20ftDryQty[i] != null)
					model.setFcast20ftDryQty(fcast20ftDryQty[i]);
				if (alocTtlWgt[i] != null)
					model.setAlocTtlWgt(alocTtlWgt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (cfcastTtlWgt[i] != null)
					model.setCfcastTtlWgt(cfcastTtlWgt[i]);
				if (bkgTtlTeuQty[i] != null)
					model.setBkgTtlTeuQty(bkgTtlTeuQty[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (bkg40ftDryQty[i] != null)
					model.setBkg40ftDryQty(bkg40ftDryQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkg45ftHcQty[i] != null)
					model.setBkg45ftHcQty(bkg45ftHcQty[i]);
				if (cfcast53ftQty[i] != null)
					model.setCfcast53ftQty(cfcast53ftQty[i]);
				if (fcastLodQty[i] != null)
					model.setFcastLodQty(fcastLodQty[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (aloc45ftHcQty[i] != null)
					model.setAloc45ftHcQty(aloc45ftHcQty[i]);
				if (bkgRfQty[i] != null)
					model.setBkgRfQty(bkgRfQty[i]);
				if (fcast40ftDryQty[i] != null)
					model.setFcast40ftDryQty(fcast40ftDryQty[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (alocTtlQty[i] != null)
					model.setAlocTtlQty(alocTtlQty[i]);
				if (fcastRfQty[i] != null)
					model.setFcastRfQty(fcastRfQty[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bseDt[i] != null)
					model.setBseDt(bseDt[i]);
				if (bkgTtlWgt[i] != null)
					model.setBkgTtlWgt(bkgTtlWgt[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (bkg20ftDryQty[i] != null)
					model.setBkg20ftDryQty(bkg20ftDryQty[i]);
				if (bkg40ftQty[i] != null)
					model.setBkg40ftQty(bkg40ftQty[i]);
				if (fcast40ftHcQty[i] != null)
					model.setFcast40ftHcQty(fcast40ftHcQty[i]);
				if (bkg40ftHcQty[i] != null)
					model.setBkg40ftHcQty(bkg40ftHcQty[i]);
				if (cfcastLodQty[i] != null)
					model.setCfcastLodQty(cfcastLodQty[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (usaBkgModCd[i] != null)
					model.setUsaBkgModCd(usaBkgModCd[i]);
				if (cfcast40ftHcQty[i] != null)
					model.setCfcast40ftHcQty(cfcast40ftHcQty[i]);
				if (fcastTtlTeuQty[i] != null)
					model.setFcastTtlTeuQty(fcastTtlTeuQty[i]);
				if (bkg20ftQty[i] != null)
					model.setBkg20ftQty(bkg20ftQty[i]);
				if (alocRfQty[i] != null)
					model.setAlocRfQty(alocRfQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aloc40ftHcQty[i] != null)
					model.setAloc40ftHcQty(aloc40ftHcQty[i]);
				if (fcast53ftQty[i] != null)
					model.setFcast53ftQty(fcast53ftQty[i]);
				if (aloc20ftDryQty[i] != null)
					model.setAloc20ftDryQty(aloc20ftDryQty[i]);
				if (fcastTtlWgt[i] != null)
					model.setFcastTtlWgt(fcastTtlWgt[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (cfcast45ftHcQty[i] != null)
					model.setCfcast45ftHcQty(cfcast45ftHcQty[i]);
				if (bkgRdQty[i] != null)
					model.setBkgRdQty(bkgRdQty[i]);
				if (alocRdQty[i] != null)
					model.setAlocRdQty(alocRdQty[i]);
				if (cfcastTtlTeuQty[i] != null)
					model.setCfcastTtlTeuQty(cfcastTtlTeuQty[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cfcastRfQty[i] != null)
					model.setCfcastRfQty(cfcastRfQty[i]);
				if (fcast45ftHcQty[i] != null)
					model.setFcast45ftHcQty(fcast45ftHcQty[i]);
				if (bkg53ftQty[i] != null)
					model.setBkg53ftQty(bkg53ftQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDailyForecastHistoryOfcListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDailyForecastHistoryOfcListVO[]
	 */
	public SearchDailyForecastHistoryOfcListVO[] getSearchDailyForecastHistoryOfcListVOs(){
		SearchDailyForecastHistoryOfcListVO[] vos = (SearchDailyForecastHistoryOfcListVO[])models.toArray(new SearchDailyForecastHistoryOfcListVO[models.size()]);
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
		this.fcastRdQty = this.fcastRdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc40ftDryQty = this.aloc40ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc53ftQty = this.aloc53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast20ftDryQty = this.fcast20ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocTtlWgt = this.alocTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfcastTtlWgt = this.cfcastTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtlTeuQty = this.bkgTtlTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40ftDryQty = this.bkg40ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg45ftHcQty = this.bkg45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfcast53ftQty = this.cfcast53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastLodQty = this.fcastLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc45ftHcQty = this.aloc45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfQty = this.bkgRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40ftDryQty = this.fcast40ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocTtlQty = this.alocTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRfQty = this.fcastRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseDt = this.bseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtlWgt = this.bkgTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg20ftDryQty = this.bkg20ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40ftQty = this.bkg40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40ftHcQty = this.fcast40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40ftHcQty = this.bkg40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfcastLodQty = this.cfcastLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaBkgModCd = this.usaBkgModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfcast40ftHcQty = this.cfcast40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlTeuQty = this.fcastTtlTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg20ftQty = this.bkg20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocRfQty = this.alocRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc40ftHcQty = this.aloc40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast53ftQty = this.fcast53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc20ftDryQty = this.aloc20ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlWgt = this.fcastTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfcast45ftHcQty = this.cfcast45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRdQty = this.bkgRdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocRdQty = this.alocRdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfcastTtlTeuQty = this.cfcastTtlTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfcastRfQty = this.cfcastRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast45ftHcQty = this.fcast45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg53ftQty = this.bkg53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
