/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchSpaceControlInquiryListVO.java
*@FileTitle : SearchSpaceControlInquiryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.07
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.08.07 신자영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

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
 * @author 신자영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceControlInquiryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlInquiryListVO> models = new ArrayList<SearchSpaceControlInquiryListVO>();
	
	/* Column Info */
	private String aloc40ftDryQty = null;
	/* Column Info */
	private String fcastRdQty = null;
	/* Column Info */
	private String aloc53ftQty = null;
	/* Column Info */
	private String usdBkg53ftQty = null;
	/* Column Info */
	private String fcast20ftDryQty = null;
	/* Column Info */
	private String alocTtlWgt = null;
	/* Column Info */
	private String asgn20ftDryQty = null;
	/* Column Info */
	private String usdBkg40ftQty = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String ctrtFcastRfQty = null;
	/* Column Info */
	private String ctrtFcast40ftHcQty = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String aloc45ftHcQty = null;
	/* Column Info */
	private String ctrtFcastTtlTeuQty = null;
	/* Column Info */
	private String usdBkg40ftHcQty = null;
	/* Column Info */
	private String bkgAval20ftDryQty = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String fcast40ftDryQty = null;
	/* Column Info */
	private String acctGrp = null;
	/* Column Info */
	private String ctrtFcast53ftQty = null;
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
	private String fcast40ftHcQty = null;
	/* Column Info */
	private String usdBkg20ftDryQty = null;
	/* Column Info */
	private String ctrtFcastTtlWgt = null;
	/* Column Info */
	private String usdBkgRdQty = null;
	/* Column Info */
	private String destLocCd = null;
	/* Column Info */
	private String usaBkgModCd = null;
	/* Column Info */
	private String usdBkg20ftQty = null;
	/* Column Info */
	private String fcastTtlTeuQty = null;
	/* Column Info */
	private String asgn40ftDryQty = null;
	/* Column Info */
	private String bkgAvalRdQty = null;
	/* Column Info */
	private String alocLodQty = null;
	/* Column Info */
	private String ctrtFcast45ftHcQty = null;
	/* Column Info */
	private String alocRfQty = null;
	/* Column Info */
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
	private String fcast53ftQty = null;
	/* Column Info */
	private String aloc20ftDryQty = null;
	/* Column Info */
	private String fcastTtlWgt = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String usdBkg40ftDryQty = null;
	/* Column Info */
	private String asgnRdQty = null;
	/* Column Info */
	private String alocRdQty = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ctrtFcastTtlQty = null;
	/* Column Info */
	private String fcast45ftHcQty = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String usdBkgTtlWgt = null;
	/* Column Info */
	private String bkgAval40ftDryQty = null;
	
	private String custLglEngNm = null;
	
	private String custAcct = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchSpaceControlInquiryListVO() {}

	public SearchSpaceControlInquiryListVO(String ibflag, String pagerows, String aloc53ftQty, String usdBkg53ftQty, String usdBkg20ftQty, String alocTtlWgt, String fcastTtlTeuQty, String usdBkg40ftQty, String alocLodQty, String ctrtFcastRfQty, String ctrtFcast45ftHcQty, String alocRfQty, String fcastTtlQty, String usdBkgTtlQty, String usdBkgRfQty, String ctrtFcast40ftHcQty, String aloc40ftHcQty, String slsOfcCd, String fcast53ftQty, String aloc45ftHcQty, String fcastTtlWgt, String usdBkg40ftHcQty, String podYdCd, String acctGrp, String ctrtFcast53ftQty, String fcastRfQty, String userNm, String lvl, String usdBkg45ftHcQty, String ctrtFcastTtlQty, String fcast45ftHcQty, String alocGdt, String polYdCd, String usdBkgTtlWgt, String fcast40ftHcQty, String ctrtFcastTtlWgt, String ctrtFcastTtlTeuQty, String custCntCd, String custSeq, String usaBkgModCd, String destLocCd, String asgn20ftDryQty, String asgn40ftDryQty, String asgnRdQty, String bkgAval20ftDryQty, String bkgAval40ftDryQty, String bkgAvalRdQty, String fcast20ftDryQty, String fcast40ftDryQty, String fcastRdQty, String usdBkg20ftDryQty, String usdBkg40ftDryQty, String usdBkgRdQty, String aloc20ftDryQty, String aloc40ftDryQty, String alocRdQty, String custLglEngNm, String custAcct) {
		this.aloc40ftDryQty = aloc40ftDryQty;
		this.fcastRdQty = fcastRdQty;
		this.aloc53ftQty = aloc53ftQty;
		this.usdBkg53ftQty = usdBkg53ftQty;
		this.fcast20ftDryQty = fcast20ftDryQty;
		this.alocTtlWgt = alocTtlWgt;
		this.asgn20ftDryQty = asgn20ftDryQty;
		this.usdBkg40ftQty = usdBkg40ftQty;
		this.pagerows = pagerows;
		this.ctrtFcastRfQty = ctrtFcastRfQty;
		this.ctrtFcast40ftHcQty = ctrtFcast40ftHcQty;
		this.slsOfcCd = slsOfcCd;
		this.aloc45ftHcQty = aloc45ftHcQty;
		this.ctrtFcastTtlTeuQty = ctrtFcastTtlTeuQty;
		this.usdBkg40ftHcQty = usdBkg40ftHcQty;
		this.bkgAval20ftDryQty = bkgAval20ftDryQty;
		this.custCntCd = custCntCd;
		this.fcast40ftDryQty = fcast40ftDryQty;
		this.acctGrp = acctGrp;
		this.ctrtFcast53ftQty = ctrtFcast53ftQty;
		this.fcastRfQty = fcastRfQty;
		this.userNm = userNm;
		this.lvl = lvl;
		this.usdBkg45ftHcQty = usdBkg45ftHcQty;
		this.alocGdt = alocGdt;
		this.fcast40ftHcQty = fcast40ftHcQty;
		this.usdBkg20ftDryQty = usdBkg20ftDryQty;
		this.ctrtFcastTtlWgt = ctrtFcastTtlWgt;
		this.usdBkgRdQty = usdBkgRdQty;
		this.destLocCd = destLocCd;
		this.usaBkgModCd = usaBkgModCd;
		this.usdBkg20ftQty = usdBkg20ftQty;
		this.fcastTtlTeuQty = fcastTtlTeuQty;
		this.asgn40ftDryQty = asgn40ftDryQty;
		this.bkgAvalRdQty = bkgAvalRdQty;
		this.alocLodQty = alocLodQty;
		this.ctrtFcast45ftHcQty = ctrtFcast45ftHcQty;
		this.alocRfQty = alocRfQty;
		this.ibflag = ibflag;
		this.fcastTtlQty = fcastTtlQty;
		this.usdBkgRfQty = usdBkgRfQty;
		this.usdBkgTtlQty = usdBkgTtlQty;
		this.aloc40ftHcQty = aloc40ftHcQty;
		this.fcast53ftQty = fcast53ftQty;
		this.aloc20ftDryQty = aloc20ftDryQty;
		this.fcastTtlWgt = fcastTtlWgt;
		this.podYdCd = podYdCd;
		this.usdBkg40ftDryQty = usdBkg40ftDryQty;
		this.asgnRdQty = asgnRdQty;
		this.alocRdQty = alocRdQty;
		this.custSeq = custSeq;
		this.ctrtFcastTtlQty = ctrtFcastTtlQty;
		this.fcast45ftHcQty = fcast45ftHcQty;
		this.polYdCd = polYdCd;
		this.usdBkgTtlWgt = usdBkgTtlWgt;
		this.bkgAval40ftDryQty = bkgAval40ftDryQty;
		this.custLglEngNm = custLglEngNm;
		this.custAcct = custAcct;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aloc_40ft_dry_qty", getAloc40ftDryQty());
		this.hashColumns.put("fcast_rd_qty", getFcastRdQty());
		this.hashColumns.put("aloc_53ft_qty", getAloc53ftQty());
		this.hashColumns.put("usd_bkg_53ft_qty", getUsdBkg53ftQty());
		this.hashColumns.put("fcast_20ft_dry_qty", getFcast20ftDryQty());
		this.hashColumns.put("aloc_ttl_wgt", getAlocTtlWgt());
		this.hashColumns.put("asgn_20ft_dry_qty", getAsgn20ftDryQty());
		this.hashColumns.put("usd_bkg_40ft_qty", getUsdBkg40ftQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_fcast_rf_qty", getCtrtFcastRfQty());
		this.hashColumns.put("ctrt_fcast_40ft_hc_qty", getCtrtFcast40ftHcQty());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("aloc_45ft_hc_qty", getAloc45ftHcQty());
		this.hashColumns.put("ctrt_fcast_ttl_teu_qty", getCtrtFcastTtlTeuQty());
		this.hashColumns.put("usd_bkg_40ft_hc_qty", getUsdBkg40ftHcQty());
		this.hashColumns.put("bkg_aval_20ft_dry_qty", getBkgAval20ftDryQty());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("fcast_40ft_dry_qty", getFcast40ftDryQty());
		this.hashColumns.put("acct_grp", getAcctGrp());
		this.hashColumns.put("ctrt_fcast_53ft_qty", getCtrtFcast53ftQty());
		this.hashColumns.put("fcast_rf_qty", getFcastRfQty());
		this.hashColumns.put("user_nm", getUserNm());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("usd_bkg_45ft_hc_qty", getUsdBkg45ftHcQty());
		this.hashColumns.put("aloc_gdt", getAlocGdt());
		this.hashColumns.put("fcast_40ft_hc_qty", getFcast40ftHcQty());
		this.hashColumns.put("usd_bkg_20ft_dry_qty", getUsdBkg20ftDryQty());
		this.hashColumns.put("ctrt_fcast_ttl_wgt", getCtrtFcastTtlWgt());
		this.hashColumns.put("usd_bkg_rd_qty", getUsdBkgRdQty());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("usa_bkg_mod_cd", getUsaBkgModCd());
		this.hashColumns.put("usd_bkg_20ft_qty", getUsdBkg20ftQty());
		this.hashColumns.put("fcast_ttl_teu_qty", getFcastTtlTeuQty());
		this.hashColumns.put("asgn_40ft_dry_qty", getAsgn40ftDryQty());
		this.hashColumns.put("bkg_aval_rd_qty", getBkgAvalRdQty());
		this.hashColumns.put("aloc_lod_qty", getAlocLodQty());
		this.hashColumns.put("ctrt_fcast_45ft_hc_qty", getCtrtFcast45ftHcQty());
		this.hashColumns.put("aloc_rf_qty", getAlocRfQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fcast_ttl_qty", getFcastTtlQty());
		this.hashColumns.put("usd_bkg_rf_qty", getUsdBkgRfQty());
		this.hashColumns.put("usd_bkg_ttl_qty", getUsdBkgTtlQty());
		this.hashColumns.put("aloc_40ft_hc_qty", getAloc40ftHcQty());
		this.hashColumns.put("fcast_53ft_qty", getFcast53ftQty());
		this.hashColumns.put("aloc_20ft_dry_qty", getAloc20ftDryQty());
		this.hashColumns.put("fcast_ttl_wgt", getFcastTtlWgt());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("usd_bkg_40ft_dry_qty", getUsdBkg40ftDryQty());
		this.hashColumns.put("asgn_rd_qty", getAsgnRdQty());
		this.hashColumns.put("aloc_rd_qty", getAlocRdQty());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ctrt_fcast_ttl_qty", getCtrtFcastTtlQty());
		this.hashColumns.put("fcast_45ft_hc_qty", getFcast45ftHcQty());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("usd_bkg_ttl_wgt", getUsdBkgTtlWgt());
		this.hashColumns.put("bkg_aval_40ft_dry_qty", getBkgAval40ftDryQty());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("cust_acct", getCustAcct());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("aloc_40ft_dry_qty", "aloc40ftDryQty");
		this.hashFields.put("fcast_rd_qty", "fcastRdQty");
		this.hashFields.put("aloc_53ft_qty", "aloc53ftQty");
		this.hashFields.put("usd_bkg_53ft_qty", "usdBkg53ftQty");
		this.hashFields.put("fcast_20ft_dry_qty", "fcast20ftDryQty");
		this.hashFields.put("aloc_ttl_wgt", "alocTtlWgt");
		this.hashFields.put("asgn_20ft_dry_qty", "asgn20ftDryQty");
		this.hashFields.put("usd_bkg_40ft_qty", "usdBkg40ftQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_fcast_rf_qty", "ctrtFcastRfQty");
		this.hashFields.put("ctrt_fcast_40ft_hc_qty", "ctrtFcast40ftHcQty");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("aloc_45ft_hc_qty", "aloc45ftHcQty");
		this.hashFields.put("ctrt_fcast_ttl_teu_qty", "ctrtFcastTtlTeuQty");
		this.hashFields.put("usd_bkg_40ft_hc_qty", "usdBkg40ftHcQty");
		this.hashFields.put("bkg_aval_20ft_dry_qty", "bkgAval20ftDryQty");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("fcast_40ft_dry_qty", "fcast40ftDryQty");
		this.hashFields.put("acct_grp", "acctGrp");
		this.hashFields.put("ctrt_fcast_53ft_qty", "ctrtFcast53ftQty");
		this.hashFields.put("fcast_rf_qty", "fcastRfQty");
		this.hashFields.put("user_nm", "userNm");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("usd_bkg_45ft_hc_qty", "usdBkg45ftHcQty");
		this.hashFields.put("aloc_gdt", "alocGdt");
		this.hashFields.put("fcast_40ft_hc_qty", "fcast40ftHcQty");
		this.hashFields.put("usd_bkg_20ft_dry_qty", "usdBkg20ftDryQty");
		this.hashFields.put("ctrt_fcast_ttl_wgt", "ctrtFcastTtlWgt");
		this.hashFields.put("usd_bkg_rd_qty", "usdBkgRdQty");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("usa_bkg_mod_cd", "usaBkgModCd");
		this.hashFields.put("usd_bkg_20ft_qty", "usdBkg20ftQty");
		this.hashFields.put("fcast_ttl_teu_qty", "fcastTtlTeuQty");
		this.hashFields.put("asgn_40ft_dry_qty", "asgn40ftDryQty");
		this.hashFields.put("bkg_aval_rd_qty", "bkgAvalRdQty");
		this.hashFields.put("aloc_lod_qty", "alocLodQty");
		this.hashFields.put("ctrt_fcast_45ft_hc_qty", "ctrtFcast45ftHcQty");
		this.hashFields.put("aloc_rf_qty", "alocRfQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fcast_ttl_qty", "fcastTtlQty");
		this.hashFields.put("usd_bkg_rf_qty", "usdBkgRfQty");
		this.hashFields.put("usd_bkg_ttl_qty", "usdBkgTtlQty");
		this.hashFields.put("aloc_40ft_hc_qty", "aloc40ftHcQty");
		this.hashFields.put("fcast_53ft_qty", "fcast53ftQty");
		this.hashFields.put("aloc_20ft_dry_qty", "aloc20ftDryQty");
		this.hashFields.put("fcast_ttl_wgt", "fcastTtlWgt");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("usd_bkg_40ft_dry_qty", "usdBkg40ftDryQty");
		this.hashFields.put("asgn_rd_qty", "asgnRdQty");
		this.hashFields.put("aloc_rd_qty", "alocRdQty");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ctrt_fcast_ttl_qty", "ctrtFcastTtlQty");
		this.hashFields.put("fcast_45ft_hc_qty", "fcast45ftHcQty");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("usd_bkg_ttl_wgt", "usdBkgTtlWgt");
		this.hashFields.put("bkg_aval_40ft_dry_qty", "bkgAval40ftDryQty");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("cust_acct", "custAcct");
		return this.hashFields;
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
	 * @return fcastRdQty
	 */
	public String getFcastRdQty() {
		return this.fcastRdQty;
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
	 * @return alocTtlWgt
	 */
	public String getAlocTtlWgt() {
		return this.alocTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return asgn20ftDryQty
	 */
	public String getAsgn20ftDryQty() {
		return this.asgn20ftDryQty;
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
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return ctrtFcastRfQty
	 */
	public String getCtrtFcastRfQty() {
		return this.ctrtFcastRfQty;
	}
	
	/**
	 * Column Info
	 * @return ctrtFcast40ftHcQty
	 */
	public String getCtrtFcast40ftHcQty() {
		return this.ctrtFcast40ftHcQty;
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
	 * @return ctrtFcastTtlTeuQty
	 */
	public String getCtrtFcastTtlTeuQty() {
		return this.ctrtFcastTtlTeuQty;
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
	 * @return bkgAval20ftDryQty
	 */
	public String getBkgAval20ftDryQty() {
		return this.bkgAval20ftDryQty;
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
	 * @return fcast40ftDryQty
	 */
	public String getFcast40ftDryQty() {
		return this.fcast40ftDryQty;
	}
	
	/**
	 * Column Info
	 * @return acctGrp
	 */
	public String getAcctGrp() {
		return this.acctGrp;
	}
	
	/**
	 * Column Info
	 * @return ctrtFcast53ftQty
	 */
	public String getCtrtFcast53ftQty() {
		return this.ctrtFcast53ftQty;
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
	 * @return ctrtFcastTtlWgt
	 */
	public String getCtrtFcastTtlWgt() {
		return this.ctrtFcastTtlWgt;
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
	 * @return asgn40ftDryQty
	 */
	public String getAsgn40ftDryQty() {
		return this.asgn40ftDryQty;
	}
	
	/**
	 * Column Info
	 * @return bkgAvalRdQty
	 */
	public String getBkgAvalRdQty() {
		return this.bkgAvalRdQty;
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
	 * @return ctrtFcast45ftHcQty
	 */
	public String getCtrtFcast45ftHcQty() {
		return this.ctrtFcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return alocRfQty
	 */
	public String getAlocRfQty() {
		return this.alocRfQty;
	}
	
	/**
	 * Column Info
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
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
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
	 * @return asgnRdQty
	 */
	public String getAsgnRdQty() {
		return this.asgnRdQty;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return ctrtFcastTtlQty
	 */
	public String getCtrtFcastTtlQty() {
		return this.ctrtFcastTtlQty;
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
	 * @return bkgAval40ftDryQty
	 */
	public String getBkgAval40ftDryQty() {
		return this.bkgAval40ftDryQty;
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
	 * @param fcastRdQty
	 */
	public void setFcastRdQty(String fcastRdQty) {
		this.fcastRdQty = fcastRdQty;
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
	 * @param alocTtlWgt
	 */
	public void setAlocTtlWgt(String alocTtlWgt) {
		this.alocTtlWgt = alocTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param asgn20ftDryQty
	 */
	public void setAsgn20ftDryQty(String asgn20ftDryQty) {
		this.asgn20ftDryQty = asgn20ftDryQty;
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
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param ctrtFcastRfQty
	 */
	public void setCtrtFcastRfQty(String ctrtFcastRfQty) {
		this.ctrtFcastRfQty = ctrtFcastRfQty;
	}
	
	/**
	 * Column Info
	 * @param ctrtFcast40ftHcQty
	 */
	public void setCtrtFcast40ftHcQty(String ctrtFcast40ftHcQty) {
		this.ctrtFcast40ftHcQty = ctrtFcast40ftHcQty;
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
	 * @param ctrtFcastTtlTeuQty
	 */
	public void setCtrtFcastTtlTeuQty(String ctrtFcastTtlTeuQty) {
		this.ctrtFcastTtlTeuQty = ctrtFcastTtlTeuQty;
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
	 * @param bkgAval20ftDryQty
	 */
	public void setBkgAval20ftDryQty(String bkgAval20ftDryQty) {
		this.bkgAval20ftDryQty = bkgAval20ftDryQty;
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
	 * @param fcast40ftDryQty
	 */
	public void setFcast40ftDryQty(String fcast40ftDryQty) {
		this.fcast40ftDryQty = fcast40ftDryQty;
	}
	
	/**
	 * Column Info
	 * @param acctGrp
	 */
	public void setAcctGrp(String acctGrp) {
		this.acctGrp = acctGrp;
	}
	
	/**
	 * Column Info
	 * @param ctrtFcast53ftQty
	 */
	public void setCtrtFcast53ftQty(String ctrtFcast53ftQty) {
		this.ctrtFcast53ftQty = ctrtFcast53ftQty;
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
	 * @param ctrtFcastTtlWgt
	 */
	public void setCtrtFcastTtlWgt(String ctrtFcastTtlWgt) {
		this.ctrtFcastTtlWgt = ctrtFcastTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param usdBkgRdQty
	 */
	public void setUsdBkgRdQty(String usdBkgRdQty) {
		this.usdBkgRdQty = usdBkgRdQty;
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
	 * @param asgn40ftDryQty
	 */
	public void setAsgn40ftDryQty(String asgn40ftDryQty) {
		this.asgn40ftDryQty = asgn40ftDryQty;
	}
	
	/**
	 * Column Info
	 * @param bkgAvalRdQty
	 */
	public void setBkgAvalRdQty(String bkgAvalRdQty) {
		this.bkgAvalRdQty = bkgAvalRdQty;
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
	 * @param ctrtFcast45ftHcQty
	 */
	public void setCtrtFcast45ftHcQty(String ctrtFcast45ftHcQty) {
		this.ctrtFcast45ftHcQty = ctrtFcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param alocRfQty
	 */
	public void setAlocRfQty(String alocRfQty) {
		this.alocRfQty = alocRfQty;
	}
	
	/**
	 * Column Info
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
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
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
	 * @param asgnRdQty
	 */
	public void setAsgnRdQty(String asgnRdQty) {
		this.asgnRdQty = asgnRdQty;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param ctrtFcastTtlQty
	 */
	public void setCtrtFcastTtlQty(String ctrtFcastTtlQty) {
		this.ctrtFcastTtlQty = ctrtFcastTtlQty;
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
	 * @param bkgAval40ftDryQty
	 */
	public void setBkgAval40ftDryQty(String bkgAval40ftDryQty) {
		this.bkgAval40ftDryQty = bkgAval40ftDryQty;
	}
	
	public String getCustLglEngNm() {
		return custLglEngNm;
	}

	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}

	public String getCustAcct() {
		return custAcct;
	}

	public void setCustAcct(String custAcct) {
		this.custAcct = custAcct;
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
		setAloc40ftDryQty(JSPUtil.getParameter(request, prefix + "aloc_40ft_dry_qty", ""));
		setFcastRdQty(JSPUtil.getParameter(request, prefix + "fcast_rd_qty", ""));
		setAloc53ftQty(JSPUtil.getParameter(request, prefix + "aloc_53ft_qty", ""));
		setUsdBkg53ftQty(JSPUtil.getParameter(request, prefix + "usd_bkg_53ft_qty", ""));
		setFcast20ftDryQty(JSPUtil.getParameter(request, prefix + "fcast_20ft_dry_qty", ""));
		setAlocTtlWgt(JSPUtil.getParameter(request, prefix + "aloc_ttl_wgt", ""));
		setAsgn20ftDryQty(JSPUtil.getParameter(request, prefix + "asgn_20ft_dry_qty", ""));
		setUsdBkg40ftQty(JSPUtil.getParameter(request, prefix + "usd_bkg_40ft_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtFcastRfQty(JSPUtil.getParameter(request, prefix + "ctrt_fcast_rf_qty", ""));
		setCtrtFcast40ftHcQty(JSPUtil.getParameter(request, prefix + "ctrt_fcast_40ft_hc_qty", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setAloc45ftHcQty(JSPUtil.getParameter(request, prefix + "aloc_45ft_hc_qty", ""));
		setCtrtFcastTtlTeuQty(JSPUtil.getParameter(request, prefix + "ctrt_fcast_ttl_teu_qty", ""));
		setUsdBkg40ftHcQty(JSPUtil.getParameter(request, prefix + "usd_bkg_40ft_hc_qty", ""));
		setBkgAval20ftDryQty(JSPUtil.getParameter(request, prefix + "bkg_aval_20ft_dry_qty", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setFcast40ftDryQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_dry_qty", ""));
		setAcctGrp(JSPUtil.getParameter(request, prefix + "acct_grp", ""));
		setCtrtFcast53ftQty(JSPUtil.getParameter(request, prefix + "ctrt_fcast_53ft_qty", ""));
		setFcastRfQty(JSPUtil.getParameter(request, prefix + "fcast_rf_qty", ""));
		setUserNm(JSPUtil.getParameter(request, prefix + "user_nm", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setUsdBkg45ftHcQty(JSPUtil.getParameter(request, prefix + "usd_bkg_45ft_hc_qty", ""));
		setAlocGdt(JSPUtil.getParameter(request, prefix + "aloc_gdt", ""));
		setFcast40ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_qty", ""));
		setUsdBkg20ftDryQty(JSPUtil.getParameter(request, prefix + "usd_bkg_20ft_dry_qty", ""));
		setCtrtFcastTtlWgt(JSPUtil.getParameter(request, prefix + "ctrt_fcast_ttl_wgt", ""));
		setUsdBkgRdQty(JSPUtil.getParameter(request, prefix + "usd_bkg_rd_qty", ""));
		setDestLocCd(JSPUtil.getParameter(request, prefix + "dest_loc_cd", ""));
		setUsaBkgModCd(JSPUtil.getParameter(request, prefix + "usa_bkg_mod_cd", ""));
		setUsdBkg20ftQty(JSPUtil.getParameter(request, prefix + "usd_bkg_20ft_qty", ""));
		setFcastTtlTeuQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_teu_qty", ""));
		setAsgn40ftDryQty(JSPUtil.getParameter(request, prefix + "asgn_40ft_dry_qty", ""));
		setBkgAvalRdQty(JSPUtil.getParameter(request, prefix + "bkg_aval_rd_qty", ""));
		setAlocLodQty(JSPUtil.getParameter(request, prefix + "aloc_lod_qty", ""));
		setCtrtFcast45ftHcQty(JSPUtil.getParameter(request, prefix + "ctrt_fcast_45ft_hc_qty", ""));
		setAlocRfQty(JSPUtil.getParameter(request, prefix + "aloc_rf_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFcastTtlQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_qty", ""));
		setUsdBkgRfQty(JSPUtil.getParameter(request, prefix + "usd_bkg_rf_qty", ""));
		setUsdBkgTtlQty(JSPUtil.getParameter(request, prefix + "usd_bkg_ttl_qty", ""));
		setAloc40ftHcQty(JSPUtil.getParameter(request, prefix + "aloc_40ft_hc_qty", ""));
		setFcast53ftQty(JSPUtil.getParameter(request, prefix + "fcast_53ft_qty", ""));
		setAloc20ftDryQty(JSPUtil.getParameter(request, prefix + "aloc_20ft_dry_qty", ""));
		setFcastTtlWgt(JSPUtil.getParameter(request, prefix + "fcast_ttl_wgt", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setUsdBkg40ftDryQty(JSPUtil.getParameter(request, prefix + "usd_bkg_40ft_dry_qty", ""));
		setAsgnRdQty(JSPUtil.getParameter(request, prefix + "asgn_rd_qty", ""));
		setAlocRdQty(JSPUtil.getParameter(request, prefix + "aloc_rd_qty", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCtrtFcastTtlQty(JSPUtil.getParameter(request, prefix + "ctrt_fcast_ttl_qty", ""));
		setFcast45ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_qty", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setUsdBkgTtlWgt(JSPUtil.getParameter(request, prefix + "usd_bkg_ttl_wgt", ""));
		setBkgAval40ftDryQty(JSPUtil.getParameter(request, prefix + "bkg_aval_40ft_dry_qty", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setCustAcct(JSPUtil.getParameter(request, prefix + "cust_acct", ""));
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
			String[] aloc40ftDryQty = (JSPUtil.getParameter(request, prefix	+ "aloc_40ft_dry_qty", length));
			String[] fcastRdQty = (JSPUtil.getParameter(request, prefix	+ "fcast_rd_qty", length));
			String[] aloc53ftQty = (JSPUtil.getParameter(request, prefix	+ "aloc_53ft_qty", length));
			String[] usdBkg53ftQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_53ft_qty", length));
			String[] fcast20ftDryQty = (JSPUtil.getParameter(request, prefix	+ "fcast_20ft_dry_qty", length));
			String[] alocTtlWgt = (JSPUtil.getParameter(request, prefix	+ "aloc_ttl_wgt", length));
			String[] asgn20ftDryQty = (JSPUtil.getParameter(request, prefix	+ "asgn_20ft_dry_qty", length));
			String[] usdBkg40ftQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_40ft_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtFcastRfQty = (JSPUtil.getParameter(request, prefix	+ "ctrt_fcast_rf_qty", length));
			String[] ctrtFcast40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "ctrt_fcast_40ft_hc_qty", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] aloc45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "aloc_45ft_hc_qty", length));
			String[] ctrtFcastTtlTeuQty = (JSPUtil.getParameter(request, prefix	+ "ctrt_fcast_ttl_teu_qty", length));
			String[] usdBkg40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_40ft_hc_qty", length));
			String[] bkgAval20ftDryQty = (JSPUtil.getParameter(request, prefix	+ "bkg_aval_20ft_dry_qty", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] fcast40ftDryQty = (JSPUtil.getParameter(request, prefix	+ "fcast_40ft_dry_qty", length));
			String[] acctGrp = (JSPUtil.getParameter(request, prefix	+ "acct_grp", length));
			String[] ctrtFcast53ftQty = (JSPUtil.getParameter(request, prefix	+ "ctrt_fcast_53ft_qty", length));
			String[] fcastRfQty = (JSPUtil.getParameter(request, prefix	+ "fcast_rf_qty", length));
			String[] userNm = (JSPUtil.getParameter(request, prefix	+ "user_nm", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] usdBkg45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_45ft_hc_qty", length));
			String[] alocGdt = (JSPUtil.getParameter(request, prefix	+ "aloc_gdt", length));
			String[] fcast40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "fcast_40ft_hc_qty", length));
			String[] usdBkg20ftDryQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_20ft_dry_qty", length));
			String[] ctrtFcastTtlWgt = (JSPUtil.getParameter(request, prefix	+ "ctrt_fcast_ttl_wgt", length));
			String[] usdBkgRdQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_rd_qty", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] usaBkgModCd = (JSPUtil.getParameter(request, prefix	+ "usa_bkg_mod_cd", length));
			String[] usdBkg20ftQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_20ft_qty", length));
			String[] fcastTtlTeuQty = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_teu_qty", length));
			String[] asgn40ftDryQty = (JSPUtil.getParameter(request, prefix	+ "asgn_40ft_dry_qty", length));
			String[] bkgAvalRdQty = (JSPUtil.getParameter(request, prefix	+ "bkg_aval_rd_qty", length));
			String[] alocLodQty = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty", length));
			String[] ctrtFcast45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "ctrt_fcast_45ft_hc_qty", length));
			String[] alocRfQty = (JSPUtil.getParameter(request, prefix	+ "aloc_rf_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fcastTtlQty = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_qty", length));
			String[] usdBkgRfQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_rf_qty", length));
			String[] usdBkgTtlQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_ttl_qty", length));
			String[] aloc40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "aloc_40ft_hc_qty", length));
			String[] fcast53ftQty = (JSPUtil.getParameter(request, prefix	+ "fcast_53ft_qty", length));
			String[] aloc20ftDryQty = (JSPUtil.getParameter(request, prefix	+ "aloc_20ft_dry_qty", length));
			String[] fcastTtlWgt = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_wgt", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] usdBkg40ftDryQty = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_40ft_dry_qty", length));
			String[] asgnRdQty = (JSPUtil.getParameter(request, prefix	+ "asgn_rd_qty", length));
			String[] alocRdQty = (JSPUtil.getParameter(request, prefix	+ "aloc_rd_qty", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ctrtFcastTtlQty = (JSPUtil.getParameter(request, prefix	+ "ctrt_fcast_ttl_qty", length));
			String[] fcast45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "fcast_45ft_hc_qty", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] usdBkgTtlWgt = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_ttl_wgt", length));
			String[] bkgAval40ftDryQty = (JSPUtil.getParameter(request, prefix	+ "bkg_aval_40ft_dry_qty", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] custAcct = (JSPUtil.getParameter(request, prefix	+ "cust_acct", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlInquiryListVO();
				if (aloc40ftDryQty[i] != null)
					model.setAloc40ftDryQty(aloc40ftDryQty[i]);
				if (fcastRdQty[i] != null)
					model.setFcastRdQty(fcastRdQty[i]);
				if (aloc53ftQty[i] != null)
					model.setAloc53ftQty(aloc53ftQty[i]);
				if (usdBkg53ftQty[i] != null)
					model.setUsdBkg53ftQty(usdBkg53ftQty[i]);
				if (fcast20ftDryQty[i] != null)
					model.setFcast20ftDryQty(fcast20ftDryQty[i]);
				if (alocTtlWgt[i] != null)
					model.setAlocTtlWgt(alocTtlWgt[i]);
				if (asgn20ftDryQty[i] != null)
					model.setAsgn20ftDryQty(asgn20ftDryQty[i]);
				if (usdBkg40ftQty[i] != null)
					model.setUsdBkg40ftQty(usdBkg40ftQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtFcastRfQty[i] != null)
					model.setCtrtFcastRfQty(ctrtFcastRfQty[i]);
				if (ctrtFcast40ftHcQty[i] != null)
					model.setCtrtFcast40ftHcQty(ctrtFcast40ftHcQty[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (aloc45ftHcQty[i] != null)
					model.setAloc45ftHcQty(aloc45ftHcQty[i]);
				if (ctrtFcastTtlTeuQty[i] != null)
					model.setCtrtFcastTtlTeuQty(ctrtFcastTtlTeuQty[i]);
				if (usdBkg40ftHcQty[i] != null)
					model.setUsdBkg40ftHcQty(usdBkg40ftHcQty[i]);
				if (bkgAval20ftDryQty[i] != null)
					model.setBkgAval20ftDryQty(bkgAval20ftDryQty[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (fcast40ftDryQty[i] != null)
					model.setFcast40ftDryQty(fcast40ftDryQty[i]);
				if (acctGrp[i] != null)
					model.setAcctGrp(acctGrp[i]);
				if (ctrtFcast53ftQty[i] != null)
					model.setCtrtFcast53ftQty(ctrtFcast53ftQty[i]);
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
				if (fcast40ftHcQty[i] != null)
					model.setFcast40ftHcQty(fcast40ftHcQty[i]);
				if (usdBkg20ftDryQty[i] != null)
					model.setUsdBkg20ftDryQty(usdBkg20ftDryQty[i]);
				if (ctrtFcastTtlWgt[i] != null)
					model.setCtrtFcastTtlWgt(ctrtFcastTtlWgt[i]);
				if (usdBkgRdQty[i] != null)
					model.setUsdBkgRdQty(usdBkgRdQty[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (usaBkgModCd[i] != null)
					model.setUsaBkgModCd(usaBkgModCd[i]);
				if (usdBkg20ftQty[i] != null)
					model.setUsdBkg20ftQty(usdBkg20ftQty[i]);
				if (fcastTtlTeuQty[i] != null)
					model.setFcastTtlTeuQty(fcastTtlTeuQty[i]);
				if (asgn40ftDryQty[i] != null)
					model.setAsgn40ftDryQty(asgn40ftDryQty[i]);
				if (bkgAvalRdQty[i] != null)
					model.setBkgAvalRdQty(bkgAvalRdQty[i]);
				if (alocLodQty[i] != null)
					model.setAlocLodQty(alocLodQty[i]);
				if (ctrtFcast45ftHcQty[i] != null)
					model.setCtrtFcast45ftHcQty(ctrtFcast45ftHcQty[i]);
				if (alocRfQty[i] != null)
					model.setAlocRfQty(alocRfQty[i]);
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
				if (fcast53ftQty[i] != null)
					model.setFcast53ftQty(fcast53ftQty[i]);
				if (aloc20ftDryQty[i] != null)
					model.setAloc20ftDryQty(aloc20ftDryQty[i]);
				if (fcastTtlWgt[i] != null)
					model.setFcastTtlWgt(fcastTtlWgt[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (usdBkg40ftDryQty[i] != null)
					model.setUsdBkg40ftDryQty(usdBkg40ftDryQty[i]);
				if (asgnRdQty[i] != null)
					model.setAsgnRdQty(asgnRdQty[i]);
				if (alocRdQty[i] != null)
					model.setAlocRdQty(alocRdQty[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ctrtFcastTtlQty[i] != null)
					model.setCtrtFcastTtlQty(ctrtFcastTtlQty[i]);
				if (fcast45ftHcQty[i] != null)
					model.setFcast45ftHcQty(fcast45ftHcQty[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (usdBkgTtlWgt[i] != null)
					model.setUsdBkgTtlWgt(usdBkgTtlWgt[i]);
				if (bkgAval40ftDryQty[i] != null)
					model.setBkgAval40ftDryQty(bkgAval40ftDryQty[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (custAcct[i] != null)
					model.setCustAcct(custAcct[i]);
				
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
		this.aloc40ftDryQty = this.aloc40ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRdQty = this.fcastRdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc53ftQty = this.aloc53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg53ftQty = this.usdBkg53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast20ftDryQty = this.fcast20ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocTtlWgt = this.alocTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgn20ftDryQty = this.asgn20ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg40ftQty = this.usdBkg40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtFcastRfQty = this.ctrtFcastRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtFcast40ftHcQty = this.ctrtFcast40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc45ftHcQty = this.aloc45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtFcastTtlTeuQty = this.ctrtFcastTtlTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg40ftHcQty = this.usdBkg40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAval20ftDryQty = this.bkgAval20ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40ftDryQty = this.fcast40ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctGrp = this.acctGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtFcast53ftQty = this.ctrtFcast53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRfQty = this.fcastRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userNm = this.userNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg45ftHcQty = this.usdBkg45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocGdt = this.alocGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40ftHcQty = this.fcast40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg20ftDryQty = this.usdBkg20ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtFcastTtlWgt = this.ctrtFcastTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgRdQty = this.usdBkgRdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaBkgModCd = this.usaBkgModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg20ftQty = this.usdBkg20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlTeuQty = this.fcastTtlTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgn40ftDryQty = this.asgn40ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAvalRdQty = this.bkgAvalRdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQty = this.alocLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtFcast45ftHcQty = this.ctrtFcast45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocRfQty = this.alocRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlQty = this.fcastTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgRfQty = this.usdBkgRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgTtlQty = this.usdBkgTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc40ftHcQty = this.aloc40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast53ftQty = this.fcast53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc20ftDryQty = this.aloc20ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlWgt = this.fcastTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg40ftDryQty = this.usdBkg40ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnRdQty = this.asgnRdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocRdQty = this.alocRdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtFcastTtlQty = this.ctrtFcastTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast45ftHcQty = this.fcast45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgTtlWgt = this.usdBkgTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAval40ftDryQty = this.bkgAval40ftDryQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAcct = this.custAcct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
