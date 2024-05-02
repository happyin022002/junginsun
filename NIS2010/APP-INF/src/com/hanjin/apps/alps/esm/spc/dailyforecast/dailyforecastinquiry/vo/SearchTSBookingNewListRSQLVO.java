/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchTSBookingNewListRSQLVO.java
*@FileTitle : SearchTSBookingNewListRSQLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.29  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo;

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

public class SearchTSBookingNewListRSQLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTSBookingNewListRSQLVO> models = new ArrayList<SearchTSBookingNewListRSQLVO>();
	
	/* Column Info */
	private String postVvd3 = null;
	/* Column Info */
	private String postVvd2 = null;
	/* Column Info */
	private String tLane = null;
	/* Column Info */
	private String postLane4 = null;
	/* Column Info */
	private String bkgAkQty = null;
	/* Column Info */
	private String postLane3 = null;
	/* Column Info */
	private String postLane2 = null;
	/* Column Info */
	private String postEtbDt = null;
	/* Column Info */
	private String prePort1 = null;
	/* Column Info */
	private String bkg20ftQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tVvdEtb = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String preSlan = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkg45ftHcQty = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String preVvd = null;
	/* Column Info */
	private String yrwk = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String postPort3 = null;
	/* Column Info */
	private String postVvd4 = null;
	/* Column Info */
	private String postVvd3Etb = null;
	/* Column Info */
	private String postPort2 = null;
	/* Column Info */
	private String bkgDgQty = null;
	/* Column Info */
	private String postVvd = null;
	/* Column Info */
	private String delEtb = null;
	/* Column Info */
	private String preLane1 = null;
	/* Column Info */
	private String tsPort = null;
	/* Column Info */
	private String tslanCd = null;
	/* Column Info */
	private String tPod = null;
	/* Column Info */
	private String bkgRf20Qty = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bkgTtlQty = null;
	/* Column Info */
	private String tlane = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgTtlWgt = null;
	/* Column Info */
	private String postSlan = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String preVvd1 = null;
	/* Column Info */
	private String postVvd2Etb = null;
	/* Column Info */
	private String preVvd1Etb = null;
	/* Column Info */
	private String preEtbDt = null;
	/* Column Info */
	private String bkg40ftQty = null;
	/* Column Info */
	private String bkg40ftHcQty = null;
	/* Column Info */
	private String bkgRf40Qty = null;
	/* Column Info */
	private String tPort = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchTSBookingNewListRSQLVO() {}

	public SearchTSBookingNewListRSQLVO(String ibflag, String pagerows, String yrwk, String preSlan, String preVvd, String preEtbDt, String postSlan, String postVvd, String postEtbDt, String tsPort, String polCd, String podCd, String delCd, String slsOfcCd, String tslanCd, String vvd, String lvl, String bkgTtlQty, String bkgTtlWgt, String bkg20ftQty, String bkg40ftQty, String bkg40ftHcQty, String bkg45ftHcQty, String bkgRf20Qty, String bkgRf40Qty, String bkgDgQty, String bkgAkQty, String preVvd1, String preLane1, String prePort1, String preVvd1Etb, String tVvd, String tLane, String tPort, String tPod, String tVvdEtb, String postVvd2, String postLane2, String postPort2, String postVvd2Etb, String postVvd3, String postLane3, String postPort3, String postVvd3Etb, String postVvd4, String postLane4, String delEtb, String tlane) {
		this.postVvd3 = postVvd3;
		this.postVvd2 = postVvd2;
		this.tLane = tLane;
		this.postLane4 = postLane4;
		this.bkgAkQty = bkgAkQty;
		this.postLane3 = postLane3;
		this.postLane2 = postLane2;
		this.postEtbDt = postEtbDt;
		this.prePort1 = prePort1;
		this.bkg20ftQty = bkg20ftQty;
		this.pagerows = pagerows;
		this.tVvdEtb = tVvdEtb;
		this.polCd = polCd;
		this.preSlan = preSlan;
		this.ibflag = ibflag;
		this.bkg45ftHcQty = bkg45ftHcQty;
		this.tVvd = tVvd;
		this.preVvd = preVvd;
		this.yrwk = yrwk;
		this.slsOfcCd = slsOfcCd;
		this.postPort3 = postPort3;
		this.postVvd4 = postVvd4;
		this.postVvd3Etb = postVvd3Etb;
		this.postPort2 = postPort2;
		this.bkgDgQty = bkgDgQty;
		this.postVvd = postVvd;
		this.delEtb = delEtb;
		this.preLane1 = preLane1;
		this.tsPort = tsPort;
		this.tslanCd = tslanCd;
		this.tPod = tPod;
		this.bkgRf20Qty = bkgRf20Qty;
		this.delCd = delCd;
		this.bkgTtlQty = bkgTtlQty;
		this.tlane = tlane;
		this.podCd = podCd;
		this.vvd = vvd;
		this.bkgTtlWgt = bkgTtlWgt;
		this.postSlan = postSlan;
		this.lvl = lvl;
		this.preVvd1 = preVvd1;
		this.postVvd2Etb = postVvd2Etb;
		this.preVvd1Etb = preVvd1Etb;
		this.preEtbDt = preEtbDt;
		this.bkg40ftQty = bkg40ftQty;
		this.bkg40ftHcQty = bkg40ftHcQty;
		this.bkgRf40Qty = bkgRf40Qty;
		this.tPort = tPort;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("post_vvd3", getPostVvd3());
		this.hashColumns.put("post_vvd2", getPostVvd2());
		this.hashColumns.put("t_lane", getTLane());
		this.hashColumns.put("post_lane4", getPostLane4());
		this.hashColumns.put("bkg_ak_qty", getBkgAkQty());
		this.hashColumns.put("post_lane3", getPostLane3());
		this.hashColumns.put("post_lane2", getPostLane2());
		this.hashColumns.put("post_etb_dt", getPostEtbDt());
		this.hashColumns.put("pre_port1", getPrePort1());
		this.hashColumns.put("bkg_20ft_qty", getBkg20ftQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("t_vvd_etb", getTVvdEtb());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pre_slan", getPreSlan());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_45ft_hc_qty", getBkg45ftHcQty());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("pre_vvd", getPreVvd());
		this.hashColumns.put("yrwk", getYrwk());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("post_port3", getPostPort3());
		this.hashColumns.put("post_vvd4", getPostVvd4());
		this.hashColumns.put("post_vvd3_etb", getPostVvd3Etb());
		this.hashColumns.put("post_port2", getPostPort2());
		this.hashColumns.put("bkg_dg_qty", getBkgDgQty());
		this.hashColumns.put("post_vvd", getPostVvd());
		this.hashColumns.put("del_etb", getDelEtb());
		this.hashColumns.put("pre_lane1", getPreLane1());
		this.hashColumns.put("ts_port", getTsPort());
		this.hashColumns.put("tslan_cd", getTslanCd());
		this.hashColumns.put("t_pod", getTPod());
		this.hashColumns.put("bkg_rf20_qty", getBkgRf20Qty());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bkg_ttl_qty", getBkgTtlQty());
		this.hashColumns.put("tlane", getTlane());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_ttl_wgt", getBkgTtlWgt());
		this.hashColumns.put("post_slan", getPostSlan());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("pre_vvd1", getPreVvd1());
		this.hashColumns.put("post_vvd2_etb", getPostVvd2Etb());
		this.hashColumns.put("pre_vvd1_etb", getPreVvd1Etb());
		this.hashColumns.put("pre_etb_dt", getPreEtbDt());
		this.hashColumns.put("bkg_40ft_qty", getBkg40ftQty());
		this.hashColumns.put("bkg_40ft_hc_qty", getBkg40ftHcQty());
		this.hashColumns.put("bkg_rf40_qty", getBkgRf40Qty());
		this.hashColumns.put("t_port", getTPort());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("post_vvd3", "postVvd3");
		this.hashFields.put("post_vvd2", "postVvd2");
		this.hashFields.put("t_lane", "tLane");
		this.hashFields.put("post_lane4", "postLane4");
		this.hashFields.put("bkg_ak_qty", "bkgAkQty");
		this.hashFields.put("post_lane3", "postLane3");
		this.hashFields.put("post_lane2", "postLane2");
		this.hashFields.put("post_etb_dt", "postEtbDt");
		this.hashFields.put("pre_port1", "prePort1");
		this.hashFields.put("bkg_20ft_qty", "bkg20ftQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("t_vvd_etb", "tVvdEtb");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pre_slan", "preSlan");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_45ft_hc_qty", "bkg45ftHcQty");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("pre_vvd", "preVvd");
		this.hashFields.put("yrwk", "yrwk");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("post_port3", "postPort3");
		this.hashFields.put("post_vvd4", "postVvd4");
		this.hashFields.put("post_vvd3_etb", "postVvd3Etb");
		this.hashFields.put("post_port2", "postPort2");
		this.hashFields.put("bkg_dg_qty", "bkgDgQty");
		this.hashFields.put("post_vvd", "postVvd");
		this.hashFields.put("del_etb", "delEtb");
		this.hashFields.put("pre_lane1", "preLane1");
		this.hashFields.put("ts_port", "tsPort");
		this.hashFields.put("tslan_cd", "tslanCd");
		this.hashFields.put("t_pod", "tPod");
		this.hashFields.put("bkg_rf20_qty", "bkgRf20Qty");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bkg_ttl_qty", "bkgTtlQty");
		this.hashFields.put("tlane", "tlane");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_ttl_wgt", "bkgTtlWgt");
		this.hashFields.put("post_slan", "postSlan");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("pre_vvd1", "preVvd1");
		this.hashFields.put("post_vvd2_etb", "postVvd2Etb");
		this.hashFields.put("pre_vvd1_etb", "preVvd1Etb");
		this.hashFields.put("pre_etb_dt", "preEtbDt");
		this.hashFields.put("bkg_40ft_qty", "bkg40ftQty");
		this.hashFields.put("bkg_40ft_hc_qty", "bkg40ftHcQty");
		this.hashFields.put("bkg_rf40_qty", "bkgRf40Qty");
		this.hashFields.put("t_port", "tPort");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return postVvd3
	 */
	public String getPostVvd3() {
		return this.postVvd3;
	}
	
	/**
	 * Column Info
	 * @return postVvd2
	 */
	public String getPostVvd2() {
		return this.postVvd2;
	}
	
	/**
	 * Column Info
	 * @return tLane
	 */
	public String getTLane() {
		return this.tLane;
	}
	
	/**
	 * Column Info
	 * @return postLane4
	 */
	public String getPostLane4() {
		return this.postLane4;
	}
	
	/**
	 * Column Info
	 * @return bkgAkQty
	 */
	public String getBkgAkQty() {
		return this.bkgAkQty;
	}
	
	/**
	 * Column Info
	 * @return postLane3
	 */
	public String getPostLane3() {
		return this.postLane3;
	}
	
	/**
	 * Column Info
	 * @return postLane2
	 */
	public String getPostLane2() {
		return this.postLane2;
	}
	
	/**
	 * Column Info
	 * @return postEtbDt
	 */
	public String getPostEtbDt() {
		return this.postEtbDt;
	}
	
	/**
	 * Column Info
	 * @return prePort1
	 */
	public String getPrePort1() {
		return this.prePort1;
	}
	
	/**
	 * Column Info
	 * @return bkg20ftQty
	 */
	public String getBkg20ftQty() {
		return this.bkg20ftQty;
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
	 * @return tVvdEtb
	 */
	public String getTVvdEtb() {
		return this.tVvdEtb;
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
	 * @return preSlan
	 */
	public String getPreSlan() {
		return this.preSlan;
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
	 * @return bkg45ftHcQty
	 */
	public String getBkg45ftHcQty() {
		return this.bkg45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}
	
	/**
	 * Column Info
	 * @return preVvd
	 */
	public String getPreVvd() {
		return this.preVvd;
	}
	
	/**
	 * Column Info
	 * @return yrwk
	 */
	public String getYrwk() {
		return this.yrwk;
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
	 * @return postPort3
	 */
	public String getPostPort3() {
		return this.postPort3;
	}
	
	/**
	 * Column Info
	 * @return postVvd4
	 */
	public String getPostVvd4() {
		return this.postVvd4;
	}
	
	/**
	 * Column Info
	 * @return postVvd3Etb
	 */
	public String getPostVvd3Etb() {
		return this.postVvd3Etb;
	}
	
	/**
	 * Column Info
	 * @return postPort2
	 */
	public String getPostPort2() {
		return this.postPort2;
	}
	
	/**
	 * Column Info
	 * @return bkgDgQty
	 */
	public String getBkgDgQty() {
		return this.bkgDgQty;
	}
	
	/**
	 * Column Info
	 * @return postVvd
	 */
	public String getPostVvd() {
		return this.postVvd;
	}
	
	/**
	 * Column Info
	 * @return delEtb
	 */
	public String getDelEtb() {
		return this.delEtb;
	}
	
	/**
	 * Column Info
	 * @return preLane1
	 */
	public String getPreLane1() {
		return this.preLane1;
	}
	
	/**
	 * Column Info
	 * @return tsPort
	 */
	public String getTsPort() {
		return this.tsPort;
	}
	
	/**
	 * Column Info
	 * @return tslanCd
	 */
	public String getTslanCd() {
		return this.tslanCd;
	}
	
	/**
	 * Column Info
	 * @return tPod
	 */
	public String getTPod() {
		return this.tPod;
	}
	
	/**
	 * Column Info
	 * @return bkgRf20Qty
	 */
	public String getBkgRf20Qty() {
		return this.bkgRf20Qty;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return bkgTtlQty
	 */
	public String getBkgTtlQty() {
		return this.bkgTtlQty;
	}
	
	/**
	 * Column Info
	 * @return tlane
	 */
	public String getTlane() {
		return this.tlane;
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
	 * @return bkgTtlWgt
	 */
	public String getBkgTtlWgt() {
		return this.bkgTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return postSlan
	 */
	public String getPostSlan() {
		return this.postSlan;
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
	 * @return preVvd1
	 */
	public String getPreVvd1() {
		return this.preVvd1;
	}
	
	/**
	 * Column Info
	 * @return postVvd2Etb
	 */
	public String getPostVvd2Etb() {
		return this.postVvd2Etb;
	}
	
	/**
	 * Column Info
	 * @return preVvd1Etb
	 */
	public String getPreVvd1Etb() {
		return this.preVvd1Etb;
	}
	
	/**
	 * Column Info
	 * @return preEtbDt
	 */
	public String getPreEtbDt() {
		return this.preEtbDt;
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
	 * @return bkg40ftHcQty
	 */
	public String getBkg40ftHcQty() {
		return this.bkg40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return bkgRf40Qty
	 */
	public String getBkgRf40Qty() {
		return this.bkgRf40Qty;
	}
	
	/**
	 * Column Info
	 * @return tPort
	 */
	public String getTPort() {
		return this.tPort;
	}
	

	/**
	 * Column Info
	 * @param postVvd3
	 */
	public void setPostVvd3(String postVvd3) {
		this.postVvd3 = postVvd3;
	}
	
	/**
	 * Column Info
	 * @param postVvd2
	 */
	public void setPostVvd2(String postVvd2) {
		this.postVvd2 = postVvd2;
	}
	
	/**
	 * Column Info
	 * @param tLane
	 */
	public void setTLane(String tLane) {
		this.tLane = tLane;
	}
	
	/**
	 * Column Info
	 * @param postLane4
	 */
	public void setPostLane4(String postLane4) {
		this.postLane4 = postLane4;
	}
	
	/**
	 * Column Info
	 * @param bkgAkQty
	 */
	public void setBkgAkQty(String bkgAkQty) {
		this.bkgAkQty = bkgAkQty;
	}
	
	/**
	 * Column Info
	 * @param postLane3
	 */
	public void setPostLane3(String postLane3) {
		this.postLane3 = postLane3;
	}
	
	/**
	 * Column Info
	 * @param postLane2
	 */
	public void setPostLane2(String postLane2) {
		this.postLane2 = postLane2;
	}
	
	/**
	 * Column Info
	 * @param postEtbDt
	 */
	public void setPostEtbDt(String postEtbDt) {
		this.postEtbDt = postEtbDt;
	}
	
	/**
	 * Column Info
	 * @param prePort1
	 */
	public void setPrePort1(String prePort1) {
		this.prePort1 = prePort1;
	}
	
	/**
	 * Column Info
	 * @param bkg20ftQty
	 */
	public void setBkg20ftQty(String bkg20ftQty) {
		this.bkg20ftQty = bkg20ftQty;
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
	 * @param tVvdEtb
	 */
	public void setTVvdEtb(String tVvdEtb) {
		this.tVvdEtb = tVvdEtb;
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
	 * @param preSlan
	 */
	public void setPreSlan(String preSlan) {
		this.preSlan = preSlan;
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
	 * @param bkg45ftHcQty
	 */
	public void setBkg45ftHcQty(String bkg45ftHcQty) {
		this.bkg45ftHcQty = bkg45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}
	
	/**
	 * Column Info
	 * @param preVvd
	 */
	public void setPreVvd(String preVvd) {
		this.preVvd = preVvd;
	}
	
	/**
	 * Column Info
	 * @param yrwk
	 */
	public void setYrwk(String yrwk) {
		this.yrwk = yrwk;
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
	 * @param postPort3
	 */
	public void setPostPort3(String postPort3) {
		this.postPort3 = postPort3;
	}
	
	/**
	 * Column Info
	 * @param postVvd4
	 */
	public void setPostVvd4(String postVvd4) {
		this.postVvd4 = postVvd4;
	}
	
	/**
	 * Column Info
	 * @param postVvd3Etb
	 */
	public void setPostVvd3Etb(String postVvd3Etb) {
		this.postVvd3Etb = postVvd3Etb;
	}
	
	/**
	 * Column Info
	 * @param postPort2
	 */
	public void setPostPort2(String postPort2) {
		this.postPort2 = postPort2;
	}
	
	/**
	 * Column Info
	 * @param bkgDgQty
	 */
	public void setBkgDgQty(String bkgDgQty) {
		this.bkgDgQty = bkgDgQty;
	}
	
	/**
	 * Column Info
	 * @param postVvd
	 */
	public void setPostVvd(String postVvd) {
		this.postVvd = postVvd;
	}
	
	/**
	 * Column Info
	 * @param delEtb
	 */
	public void setDelEtb(String delEtb) {
		this.delEtb = delEtb;
	}
	
	/**
	 * Column Info
	 * @param preLane1
	 */
	public void setPreLane1(String preLane1) {
		this.preLane1 = preLane1;
	}
	
	/**
	 * Column Info
	 * @param tsPort
	 */
	public void setTsPort(String tsPort) {
		this.tsPort = tsPort;
	}
	
	/**
	 * Column Info
	 * @param tslanCd
	 */
	public void setTslanCd(String tslanCd) {
		this.tslanCd = tslanCd;
	}
	
	/**
	 * Column Info
	 * @param tPod
	 */
	public void setTPod(String tPod) {
		this.tPod = tPod;
	}
	
	/**
	 * Column Info
	 * @param bkgRf20Qty
	 */
	public void setBkgRf20Qty(String bkgRf20Qty) {
		this.bkgRf20Qty = bkgRf20Qty;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param bkgTtlQty
	 */
	public void setBkgTtlQty(String bkgTtlQty) {
		this.bkgTtlQty = bkgTtlQty;
	}
	
	/**
	 * Column Info
	 * @param tlane
	 */
	public void setTlane(String tlane) {
		this.tlane = tlane;
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
	 * @param bkgTtlWgt
	 */
	public void setBkgTtlWgt(String bkgTtlWgt) {
		this.bkgTtlWgt = bkgTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param postSlan
	 */
	public void setPostSlan(String postSlan) {
		this.postSlan = postSlan;
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
	 * @param preVvd1
	 */
	public void setPreVvd1(String preVvd1) {
		this.preVvd1 = preVvd1;
	}
	
	/**
	 * Column Info
	 * @param postVvd2Etb
	 */
	public void setPostVvd2Etb(String postVvd2Etb) {
		this.postVvd2Etb = postVvd2Etb;
	}
	
	/**
	 * Column Info
	 * @param preVvd1Etb
	 */
	public void setPreVvd1Etb(String preVvd1Etb) {
		this.preVvd1Etb = preVvd1Etb;
	}
	
	/**
	 * Column Info
	 * @param preEtbDt
	 */
	public void setPreEtbDt(String preEtbDt) {
		this.preEtbDt = preEtbDt;
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
	 * @param bkg40ftHcQty
	 */
	public void setBkg40ftHcQty(String bkg40ftHcQty) {
		this.bkg40ftHcQty = bkg40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param bkgRf40Qty
	 */
	public void setBkgRf40Qty(String bkgRf40Qty) {
		this.bkgRf40Qty = bkgRf40Qty;
	}
	
	/**
	 * Column Info
	 * @param tPort
	 */
	public void setTPort(String tPort) {
		this.tPort = tPort;
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
		setPostVvd3(JSPUtil.getParameter(request, prefix + "post_vvd3", ""));
		setPostVvd2(JSPUtil.getParameter(request, prefix + "post_vvd2", ""));
		setTLane(JSPUtil.getParameter(request, prefix + "t_lane", ""));
		setPostLane4(JSPUtil.getParameter(request, prefix + "post_lane4", ""));
		setBkgAkQty(JSPUtil.getParameter(request, prefix + "bkg_ak_qty", ""));
		setPostLane3(JSPUtil.getParameter(request, prefix + "post_lane3", ""));
		setPostLane2(JSPUtil.getParameter(request, prefix + "post_lane2", ""));
		setPostEtbDt(JSPUtil.getParameter(request, prefix + "post_etb_dt", ""));
		setPrePort1(JSPUtil.getParameter(request, prefix + "pre_port1", ""));
		setBkg20ftQty(JSPUtil.getParameter(request, prefix + "bkg_20ft_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTVvdEtb(JSPUtil.getParameter(request, prefix + "t_vvd_etb", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPreSlan(JSPUtil.getParameter(request, prefix + "pre_slan", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkg45ftHcQty(JSPUtil.getParameter(request, prefix + "bkg_45ft_hc_qty", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setPreVvd(JSPUtil.getParameter(request, prefix + "pre_vvd", ""));
		setYrwk(JSPUtil.getParameter(request, prefix + "yrwk", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setPostPort3(JSPUtil.getParameter(request, prefix + "post_port3", ""));
		setPostVvd4(JSPUtil.getParameter(request, prefix + "post_vvd4", ""));
		setPostVvd3Etb(JSPUtil.getParameter(request, prefix + "post_vvd3_etb", ""));
		setPostPort2(JSPUtil.getParameter(request, prefix + "post_port2", ""));
		setBkgDgQty(JSPUtil.getParameter(request, prefix + "bkg_dg_qty", ""));
		setPostVvd(JSPUtil.getParameter(request, prefix + "post_vvd", ""));
		setDelEtb(JSPUtil.getParameter(request, prefix + "del_etb", ""));
		setPreLane1(JSPUtil.getParameter(request, prefix + "pre_lane1", ""));
		setTsPort(JSPUtil.getParameter(request, prefix + "ts_port", ""));
		setTslanCd(JSPUtil.getParameter(request, prefix + "tslan_cd", ""));
		setTPod(JSPUtil.getParameter(request, prefix + "t_pod", ""));
		setBkgRf20Qty(JSPUtil.getParameter(request, prefix + "bkg_rf20_qty", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBkgTtlQty(JSPUtil.getParameter(request, prefix + "bkg_ttl_qty", ""));
		setTlane(JSPUtil.getParameter(request, prefix + "tlane", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgTtlWgt(JSPUtil.getParameter(request, prefix + "bkg_ttl_wgt", ""));
		setPostSlan(JSPUtil.getParameter(request, prefix + "post_slan", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setPreVvd1(JSPUtil.getParameter(request, prefix + "pre_vvd1", ""));
		setPostVvd2Etb(JSPUtil.getParameter(request, prefix + "post_vvd2_etb", ""));
		setPreVvd1Etb(JSPUtil.getParameter(request, prefix + "pre_vvd1_etb", ""));
		setPreEtbDt(JSPUtil.getParameter(request, prefix + "pre_etb_dt", ""));
		setBkg40ftQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_qty", ""));
		setBkg40ftHcQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_hc_qty", ""));
		setBkgRf40Qty(JSPUtil.getParameter(request, prefix + "bkg_rf40_qty", ""));
		setTPort(JSPUtil.getParameter(request, prefix + "t_port", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTSBookingNewListRSQLVO[]
	 */
	public SearchTSBookingNewListRSQLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTSBookingNewListRSQLVO[]
	 */
	public SearchTSBookingNewListRSQLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTSBookingNewListRSQLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] postVvd3 = (JSPUtil.getParameter(request, prefix	+ "post_vvd3", length));
			String[] postVvd2 = (JSPUtil.getParameter(request, prefix	+ "post_vvd2", length));
			String[] tLane = (JSPUtil.getParameter(request, prefix	+ "t_lane", length));
			String[] postLane4 = (JSPUtil.getParameter(request, prefix	+ "post_lane4", length));
			String[] bkgAkQty = (JSPUtil.getParameter(request, prefix	+ "bkg_ak_qty", length));
			String[] postLane3 = (JSPUtil.getParameter(request, prefix	+ "post_lane3", length));
			String[] postLane2 = (JSPUtil.getParameter(request, prefix	+ "post_lane2", length));
			String[] postEtbDt = (JSPUtil.getParameter(request, prefix	+ "post_etb_dt", length));
			String[] prePort1 = (JSPUtil.getParameter(request, prefix	+ "pre_port1", length));
			String[] bkg20ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_20ft_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tVvdEtb = (JSPUtil.getParameter(request, prefix	+ "t_vvd_etb", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] preSlan = (JSPUtil.getParameter(request, prefix	+ "pre_slan", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkg45ftHcQty = (JSPUtil.getParameter(request, prefix	+ "bkg_45ft_hc_qty", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] preVvd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd", length));
			String[] yrwk = (JSPUtil.getParameter(request, prefix	+ "yrwk", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] postPort3 = (JSPUtil.getParameter(request, prefix	+ "post_port3", length));
			String[] postVvd4 = (JSPUtil.getParameter(request, prefix	+ "post_vvd4", length));
			String[] postVvd3Etb = (JSPUtil.getParameter(request, prefix	+ "post_vvd3_etb", length));
			String[] postPort2 = (JSPUtil.getParameter(request, prefix	+ "post_port2", length));
			String[] bkgDgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_dg_qty", length));
			String[] postVvd = (JSPUtil.getParameter(request, prefix	+ "post_vvd", length));
			String[] delEtb = (JSPUtil.getParameter(request, prefix	+ "del_etb", length));
			String[] preLane1 = (JSPUtil.getParameter(request, prefix	+ "pre_lane1", length));
			String[] tsPort = (JSPUtil.getParameter(request, prefix	+ "ts_port", length));
			String[] tslanCd = (JSPUtil.getParameter(request, prefix	+ "tslan_cd", length));
			String[] tPod = (JSPUtil.getParameter(request, prefix	+ "t_pod", length));
			String[] bkgRf20Qty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf20_qty", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bkgTtlQty = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl_qty", length));
			String[] tlane = (JSPUtil.getParameter(request, prefix	+ "tlane", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgTtlWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl_wgt", length));
			String[] postSlan = (JSPUtil.getParameter(request, prefix	+ "post_slan", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] preVvd1 = (JSPUtil.getParameter(request, prefix	+ "pre_vvd1", length));
			String[] postVvd2Etb = (JSPUtil.getParameter(request, prefix	+ "post_vvd2_etb", length));
			String[] preVvd1Etb = (JSPUtil.getParameter(request, prefix	+ "pre_vvd1_etb", length));
			String[] preEtbDt = (JSPUtil.getParameter(request, prefix	+ "pre_etb_dt", length));
			String[] bkg40ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_40ft_qty", length));
			String[] bkg40ftHcQty = (JSPUtil.getParameter(request, prefix	+ "bkg_40ft_hc_qty", length));
			String[] bkgRf40Qty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf40_qty", length));
			String[] tPort = (JSPUtil.getParameter(request, prefix	+ "t_port", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTSBookingNewListRSQLVO();
				if (postVvd3[i] != null)
					model.setPostVvd3(postVvd3[i]);
				if (postVvd2[i] != null)
					model.setPostVvd2(postVvd2[i]);
				if (tLane[i] != null)
					model.setTLane(tLane[i]);
				if (postLane4[i] != null)
					model.setPostLane4(postLane4[i]);
				if (bkgAkQty[i] != null)
					model.setBkgAkQty(bkgAkQty[i]);
				if (postLane3[i] != null)
					model.setPostLane3(postLane3[i]);
				if (postLane2[i] != null)
					model.setPostLane2(postLane2[i]);
				if (postEtbDt[i] != null)
					model.setPostEtbDt(postEtbDt[i]);
				if (prePort1[i] != null)
					model.setPrePort1(prePort1[i]);
				if (bkg20ftQty[i] != null)
					model.setBkg20ftQty(bkg20ftQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tVvdEtb[i] != null)
					model.setTVvdEtb(tVvdEtb[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (preSlan[i] != null)
					model.setPreSlan(preSlan[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkg45ftHcQty[i] != null)
					model.setBkg45ftHcQty(bkg45ftHcQty[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (preVvd[i] != null)
					model.setPreVvd(preVvd[i]);
				if (yrwk[i] != null)
					model.setYrwk(yrwk[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (postPort3[i] != null)
					model.setPostPort3(postPort3[i]);
				if (postVvd4[i] != null)
					model.setPostVvd4(postVvd4[i]);
				if (postVvd3Etb[i] != null)
					model.setPostVvd3Etb(postVvd3Etb[i]);
				if (postPort2[i] != null)
					model.setPostPort2(postPort2[i]);
				if (bkgDgQty[i] != null)
					model.setBkgDgQty(bkgDgQty[i]);
				if (postVvd[i] != null)
					model.setPostVvd(postVvd[i]);
				if (delEtb[i] != null)
					model.setDelEtb(delEtb[i]);
				if (preLane1[i] != null)
					model.setPreLane1(preLane1[i]);
				if (tsPort[i] != null)
					model.setTsPort(tsPort[i]);
				if (tslanCd[i] != null)
					model.setTslanCd(tslanCd[i]);
				if (tPod[i] != null)
					model.setTPod(tPod[i]);
				if (bkgRf20Qty[i] != null)
					model.setBkgRf20Qty(bkgRf20Qty[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bkgTtlQty[i] != null)
					model.setBkgTtlQty(bkgTtlQty[i]);
				if (tlane[i] != null)
					model.setTlane(tlane[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgTtlWgt[i] != null)
					model.setBkgTtlWgt(bkgTtlWgt[i]);
				if (postSlan[i] != null)
					model.setPostSlan(postSlan[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (preVvd1[i] != null)
					model.setPreVvd1(preVvd1[i]);
				if (postVvd2Etb[i] != null)
					model.setPostVvd2Etb(postVvd2Etb[i]);
				if (preVvd1Etb[i] != null)
					model.setPreVvd1Etb(preVvd1Etb[i]);
				if (preEtbDt[i] != null)
					model.setPreEtbDt(preEtbDt[i]);
				if (bkg40ftQty[i] != null)
					model.setBkg40ftQty(bkg40ftQty[i]);
				if (bkg40ftHcQty[i] != null)
					model.setBkg40ftHcQty(bkg40ftHcQty[i]);
				if (bkgRf40Qty[i] != null)
					model.setBkgRf40Qty(bkgRf40Qty[i]);
				if (tPort[i] != null)
					model.setTPort(tPort[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTSBookingNewListRSQLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTSBookingNewListRSQLVO[]
	 */
	public SearchTSBookingNewListRSQLVO[] getSearchTSBookingNewListRSQLVOs(){
		SearchTSBookingNewListRSQLVO[] vos = (SearchTSBookingNewListRSQLVO[])models.toArray(new SearchTSBookingNewListRSQLVO[models.size()]);
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
		this.postVvd3 = this.postVvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postVvd2 = this.postVvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tLane = this.tLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postLane4 = this.postLane4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAkQty = this.bkgAkQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postLane3 = this.postLane3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postLane2 = this.postLane2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postEtbDt = this.postEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePort1 = this.prePort1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg20ftQty = this.bkg20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvdEtb = this.tVvdEtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSlan = this.preSlan .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg45ftHcQty = this.bkg45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd = this.preVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrwk = this.yrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postPort3 = this.postPort3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postVvd4 = this.postVvd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postVvd3Etb = this.postVvd3Etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postPort2 = this.postPort2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDgQty = this.bkgDgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postVvd = this.postVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEtb = this.delEtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preLane1 = this.preLane1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPort = this.tsPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tslanCd = this.tslanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tPod = this.tPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRf20Qty = this.bkgRf20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtlQty = this.bkgTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlane = this.tlane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtlWgt = this.bkgTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postSlan = this.postSlan .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd1 = this.preVvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postVvd2Etb = this.postVvd2Etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd1Etb = this.preVvd1Etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEtbDt = this.preEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40ftQty = this.bkg40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40ftHcQty = this.bkg40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRf40Qty = this.bkgRf40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tPort = this.tPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
