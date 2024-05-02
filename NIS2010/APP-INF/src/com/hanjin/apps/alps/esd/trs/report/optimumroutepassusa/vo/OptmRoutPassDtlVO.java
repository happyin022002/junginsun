/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OptmRoutPassDtlVO.java
*@FileTitle : OptmRoutPassDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.13  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OptmRoutPassDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OptmRoutPassDtlVO> models = new ArrayList<OptmRoutPassDtlVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String railFmNodCd = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String soDscrRsnCd = null;
	/* Column Info */
	private String actCntrQty = null;
	/* Column Info */
	private String routOrgNodCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dorPstCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String porDelNm = null;
	/* Column Info */
	private String railToNodCd = null;
	/* Column Info */
	private String irgToNodCd = null;
	/* Column Info */
	private String shipNm = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String routDestNodCd = null;
	/* Column Info */
	private String irgTrspCrrModCtnt = null;
	/* Column Info */
	private String optimumPassYn = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String irgRailToNodCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String irgDorNodCd = null;
	/* Column Info */
	private String woCreOfcCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String fctryNm = null;
	/* Column Info */
	private String irgRailFmNodCd = null;
	/* Column Info */
	private String trspCrrModCtnt = null;
	/* Column Info */
	private String bkgTrem = null;
	/* Column Info */
	private String irgFmNodCd = null;
	/* Column Info */
	private String bkgCntrQty = null;
	/* Column Info */
	private String qryOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OptmRoutPassDtlVO() {}

	public OptmRoutPassDtlVO(String ibflag, String pagerows, String optimumPassYn, String woCreOfcCd, String soDscrRsnCd, String routOrgNodCd, String routDestNodCd, String porDelNm, String bkgNo, String bkgTrem, String bkgCntrQty, String actCntrQty, String trspBndCd, String trspCrrModCtnt, String railFmNodCd, String railToNodCd, String fmNodCd, String toNodCd, String dorNodCd, String fctryNm, String dorPstCd, String irgTrspCrrModCtnt, String irgRailFmNodCd, String irgRailToNodCd, String irgFmNodCd, String irgToNodCd, String irgDorNodCd, String porCd, String polCd, String podCd, String delCd, String shipNm, String cneeNm, String qryOfcCd) {
		this.porCd = porCd;
		this.railFmNodCd = railFmNodCd;
		this.toNodCd = toNodCd;
		this.soDscrRsnCd = soDscrRsnCd;
		this.actCntrQty = actCntrQty;
		this.routOrgNodCd = routOrgNodCd;
		this.pagerows = pagerows;
		this.dorPstCd = dorPstCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.porDelNm = porDelNm;
		this.railToNodCd = railToNodCd;
		this.irgToNodCd = irgToNodCd;
		this.shipNm = shipNm;
		this.dorNodCd = dorNodCd;
		this.routDestNodCd = routDestNodCd;
		this.irgTrspCrrModCtnt = irgTrspCrrModCtnt;
		this.optimumPassYn = optimumPassYn;
		this.trspBndCd = trspBndCd;
		this.irgRailToNodCd = irgRailToNodCd;
		this.delCd = delCd;
		this.irgDorNodCd = irgDorNodCd;
		this.woCreOfcCd = woCreOfcCd;
		this.podCd = podCd;
		this.fmNodCd = fmNodCd;
		this.cneeNm = cneeNm;
		this.bkgNo = bkgNo;
		this.fctryNm = fctryNm;
		this.irgRailFmNodCd = irgRailFmNodCd;
		this.trspCrrModCtnt = trspCrrModCtnt;
		this.bkgTrem = bkgTrem;
		this.irgFmNodCd = irgFmNodCd;
		this.bkgCntrQty = bkgCntrQty;
		this.qryOfcCd = qryOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("rail_fm_nod_cd", getRailFmNodCd());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("so_dscr_rsn_cd", getSoDscrRsnCd());
		this.hashColumns.put("act_cntr_qty", getActCntrQty());
		this.hashColumns.put("rout_org_nod_cd", getRoutOrgNodCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dor_pst_cd", getDorPstCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("por_del_nm", getPorDelNm());
		this.hashColumns.put("rail_to_nod_cd", getRailToNodCd());
		this.hashColumns.put("irg_to_nod_cd", getIrgToNodCd());
		this.hashColumns.put("ship_nm", getShipNm());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("rout_dest_nod_cd", getRoutDestNodCd());
		this.hashColumns.put("irg_trsp_crr_mod_ctnt", getIrgTrspCrrModCtnt());
		this.hashColumns.put("optimum_pass_yn", getOptimumPassYn());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("irg_rail_to_nod_cd", getIrgRailToNodCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("irg_dor_nod_cd", getIrgDorNodCd());
		this.hashColumns.put("wo_cre_ofc_cd", getWoCreOfcCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("fctry_nm", getFctryNm());
		this.hashColumns.put("irg_rail_fm_nod_cd", getIrgRailFmNodCd());
		this.hashColumns.put("trsp_crr_mod_ctnt", getTrspCrrModCtnt());
		this.hashColumns.put("bkg_trem", getBkgTrem());
		this.hashColumns.put("irg_fm_nod_cd", getIrgFmNodCd());
		this.hashColumns.put("bkg_cntr_qty", getBkgCntrQty());
		this.hashColumns.put("qry_ofc_cd", getQryOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("rail_fm_nod_cd", "railFmNodCd");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("so_dscr_rsn_cd", "soDscrRsnCd");
		this.hashFields.put("act_cntr_qty", "actCntrQty");
		this.hashFields.put("rout_org_nod_cd", "routOrgNodCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dor_pst_cd", "dorPstCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("por_del_nm", "porDelNm");
		this.hashFields.put("rail_to_nod_cd", "railToNodCd");
		this.hashFields.put("irg_to_nod_cd", "irgToNodCd");
		this.hashFields.put("ship_nm", "shipNm");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("rout_dest_nod_cd", "routDestNodCd");
		this.hashFields.put("irg_trsp_crr_mod_ctnt", "irgTrspCrrModCtnt");
		this.hashFields.put("optimum_pass_yn", "optimumPassYn");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("irg_rail_to_nod_cd", "irgRailToNodCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("irg_dor_nod_cd", "irgDorNodCd");
		this.hashFields.put("wo_cre_ofc_cd", "woCreOfcCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("fctry_nm", "fctryNm");
		this.hashFields.put("irg_rail_fm_nod_cd", "irgRailFmNodCd");
		this.hashFields.put("trsp_crr_mod_ctnt", "trspCrrModCtnt");
		this.hashFields.put("bkg_trem", "bkgTrem");
		this.hashFields.put("irg_fm_nod_cd", "irgFmNodCd");
		this.hashFields.put("bkg_cntr_qty", "bkgCntrQty");
		this.hashFields.put("qry_ofc_cd", "qryOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return railFmNodCd
	 */
	public String getRailFmNodCd() {
		return this.railFmNodCd;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return soDscrRsnCd
	 */
	public String getSoDscrRsnCd() {
		return this.soDscrRsnCd;
	}
	
	/**
	 * Column Info
	 * @return actCntrQty
	 */
	public String getActCntrQty() {
		return this.actCntrQty;
	}
	
	/**
	 * Column Info
	 * @return routOrgNodCd
	 */
	public String getRoutOrgNodCd() {
		return this.routOrgNodCd;
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
	 * @return dorPstCd
	 */
	public String getDorPstCd() {
		return this.dorPstCd;
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
	 * @return porDelNm
	 */
	public String getPorDelNm() {
		return this.porDelNm;
	}
	
	/**
	 * Column Info
	 * @return railToNodCd
	 */
	public String getRailToNodCd() {
		return this.railToNodCd;
	}
	
	/**
	 * Column Info
	 * @return irgToNodCd
	 */
	public String getIrgToNodCd() {
		return this.irgToNodCd;
	}
	
	/**
	 * Column Info
	 * @return shipNm
	 */
	public String getShipNm() {
		return this.shipNm;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	
	/**
	 * Column Info
	 * @return routDestNodCd
	 */
	public String getRoutDestNodCd() {
		return this.routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @return irgTrspCrrModCtnt
	 */
	public String getIrgTrspCrrModCtnt() {
		return this.irgTrspCrrModCtnt;
	}
	
	/**
	 * Column Info
	 * @return optimumPassYn
	 */
	public String getOptimumPassYn() {
		return this.optimumPassYn;
	}
	
	/**
	 * Column Info
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}
	
	/**
	 * Column Info
	 * @return irgRailToNodCd
	 */
	public String getIrgRailToNodCd() {
		return this.irgRailToNodCd;
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
	 * @return irgDorNodCd
	 */
	public String getIrgDorNodCd() {
		return this.irgDorNodCd;
	}
	
	/**
	 * Column Info
	 * @return woCreOfcCd
	 */
	public String getWoCreOfcCd() {
		return this.woCreOfcCd;
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
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
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
	 * @return fctryNm
	 */
	public String getFctryNm() {
		return this.fctryNm;
	}
	
	/**
	 * Column Info
	 * @return irgRailFmNodCd
	 */
	public String getIrgRailFmNodCd() {
		return this.irgRailFmNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCtnt
	 */
	public String getTrspCrrModCtnt() {
		return this.trspCrrModCtnt;
	}
	
	/**
	 * Column Info
	 * @return bkgTrem
	 */
	public String getBkgTrem() {
		return this.bkgTrem;
	}
	
	/**
	 * Column Info
	 * @return irgFmNodCd
	 */
	public String getIrgFmNodCd() {
		return this.irgFmNodCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCntrQty
	 */
	public String getBkgCntrQty() {
		return this.bkgCntrQty;
	}
	
	/**
	 * Column Info
	 * @return qryOfcCd
	 */
	public String getQryOfcCd() {
		return this.qryOfcCd;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param railFmNodCd
	 */
	public void setRailFmNodCd(String railFmNodCd) {
		this.railFmNodCd = railFmNodCd;
	}
	
	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param soDscrRsnCd
	 */
	public void setSoDscrRsnCd(String soDscrRsnCd) {
		this.soDscrRsnCd = soDscrRsnCd;
	}
	
	/**
	 * Column Info
	 * @param actCntrQty
	 */
	public void setActCntrQty(String actCntrQty) {
		this.actCntrQty = actCntrQty;
	}
	
	/**
	 * Column Info
	 * @param routOrgNodCd
	 */
	public void setRoutOrgNodCd(String routOrgNodCd) {
		this.routOrgNodCd = routOrgNodCd;
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
	 * @param dorPstCd
	 */
	public void setDorPstCd(String dorPstCd) {
		this.dorPstCd = dorPstCd;
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
	 * @param porDelNm
	 */
	public void setPorDelNm(String porDelNm) {
		this.porDelNm = porDelNm;
	}
	
	/**
	 * Column Info
	 * @param railToNodCd
	 */
	public void setRailToNodCd(String railToNodCd) {
		this.railToNodCd = railToNodCd;
	}
	
	/**
	 * Column Info
	 * @param irgToNodCd
	 */
	public void setIrgToNodCd(String irgToNodCd) {
		this.irgToNodCd = irgToNodCd;
	}
	
	/**
	 * Column Info
	 * @param shipNm
	 */
	public void setShipNm(String shipNm) {
		this.shipNm = shipNm;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * Column Info
	 * @param routDestNodCd
	 */
	public void setRoutDestNodCd(String routDestNodCd) {
		this.routDestNodCd = routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @param irgTrspCrrModCtnt
	 */
	public void setIrgTrspCrrModCtnt(String irgTrspCrrModCtnt) {
		this.irgTrspCrrModCtnt = irgTrspCrrModCtnt;
	}
	
	/**
	 * Column Info
	 * @param optimumPassYn
	 */
	public void setOptimumPassYn(String optimumPassYn) {
		this.optimumPassYn = optimumPassYn;
	}
	
	/**
	 * Column Info
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
	 * Column Info
	 * @param irgRailToNodCd
	 */
	public void setIrgRailToNodCd(String irgRailToNodCd) {
		this.irgRailToNodCd = irgRailToNodCd;
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
	 * @param irgDorNodCd
	 */
	public void setIrgDorNodCd(String irgDorNodCd) {
		this.irgDorNodCd = irgDorNodCd;
	}
	
	/**
	 * Column Info
	 * @param woCreOfcCd
	 */
	public void setWoCreOfcCd(String woCreOfcCd) {
		this.woCreOfcCd = woCreOfcCd;
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
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
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
	 * @param fctryNm
	 */
	public void setFctryNm(String fctryNm) {
		this.fctryNm = fctryNm;
	}
	
	/**
	 * Column Info
	 * @param irgRailFmNodCd
	 */
	public void setIrgRailFmNodCd(String irgRailFmNodCd) {
		this.irgRailFmNodCd = irgRailFmNodCd;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCtnt
	 */
	public void setTrspCrrModCtnt(String trspCrrModCtnt) {
		this.trspCrrModCtnt = trspCrrModCtnt;
	}
	
	/**
	 * Column Info
	 * @param bkgTrem
	 */
	public void setBkgTrem(String bkgTrem) {
		this.bkgTrem = bkgTrem;
	}
	
	/**
	 * Column Info
	 * @param irgFmNodCd
	 */
	public void setIrgFmNodCd(String irgFmNodCd) {
		this.irgFmNodCd = irgFmNodCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCntrQty
	 */
	public void setBkgCntrQty(String bkgCntrQty) {
		this.bkgCntrQty = bkgCntrQty;
	}
	
	/**
	 * Column Info
	 * @param qryOfcCd
	 */
	public void setQryOfcCd(String qryOfcCd) {
		this.qryOfcCd = qryOfcCd;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setRailFmNodCd(JSPUtil.getParameter(request, prefix + "rail_fm_nod_cd", ""));
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setSoDscrRsnCd(JSPUtil.getParameter(request, prefix + "so_dscr_rsn_cd", ""));
		setActCntrQty(JSPUtil.getParameter(request, prefix + "act_cntr_qty", ""));
		setRoutOrgNodCd(JSPUtil.getParameter(request, prefix + "rout_org_nod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDorPstCd(JSPUtil.getParameter(request, prefix + "dor_pst_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPorDelNm(JSPUtil.getParameter(request, prefix + "por_del_nm", ""));
		setRailToNodCd(JSPUtil.getParameter(request, prefix + "rail_to_nod_cd", ""));
		setIrgToNodCd(JSPUtil.getParameter(request, prefix + "irg_to_nod_cd", ""));
		setShipNm(JSPUtil.getParameter(request, prefix + "ship_nm", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setRoutDestNodCd(JSPUtil.getParameter(request, prefix + "rout_dest_nod_cd", ""));
		setIrgTrspCrrModCtnt(JSPUtil.getParameter(request, prefix + "irg_trsp_crr_mod_ctnt", ""));
		setOptimumPassYn(JSPUtil.getParameter(request, prefix + "optimum_pass_yn", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setIrgRailToNodCd(JSPUtil.getParameter(request, prefix + "irg_rail_to_nod_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setIrgDorNodCd(JSPUtil.getParameter(request, prefix + "irg_dor_nod_cd", ""));
		setWoCreOfcCd(JSPUtil.getParameter(request, prefix + "wo_cre_ofc_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setFctryNm(JSPUtil.getParameter(request, prefix + "fctry_nm", ""));
		setIrgRailFmNodCd(JSPUtil.getParameter(request, prefix + "irg_rail_fm_nod_cd", ""));
		setTrspCrrModCtnt(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_ctnt", ""));
		setBkgTrem(JSPUtil.getParameter(request, prefix + "bkg_trem", ""));
		setIrgFmNodCd(JSPUtil.getParameter(request, prefix + "irg_fm_nod_cd", ""));
		setBkgCntrQty(JSPUtil.getParameter(request, prefix + "bkg_cntr_qty", ""));
		setQryOfcCd(JSPUtil.getParameter(request, prefix + "qry_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OptmRoutPassDtlVO[]
	 */
	public OptmRoutPassDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OptmRoutPassDtlVO[]
	 */
	public OptmRoutPassDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OptmRoutPassDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] railFmNodCd = (JSPUtil.getParameter(request, prefix	+ "rail_fm_nod_cd", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] soDscrRsnCd = (JSPUtil.getParameter(request, prefix	+ "so_dscr_rsn_cd", length));
			String[] actCntrQty = (JSPUtil.getParameter(request, prefix	+ "act_cntr_qty", length));
			String[] routOrgNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_org_nod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dorPstCd = (JSPUtil.getParameter(request, prefix	+ "dor_pst_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] porDelNm = (JSPUtil.getParameter(request, prefix	+ "por_del_nm", length));
			String[] railToNodCd = (JSPUtil.getParameter(request, prefix	+ "rail_to_nod_cd", length));
			String[] irgToNodCd = (JSPUtil.getParameter(request, prefix	+ "irg_to_nod_cd", length));
			String[] shipNm = (JSPUtil.getParameter(request, prefix	+ "ship_nm", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] routDestNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_dest_nod_cd", length));
			String[] irgTrspCrrModCtnt = (JSPUtil.getParameter(request, prefix	+ "irg_trsp_crr_mod_ctnt", length));
			String[] optimumPassYn = (JSPUtil.getParameter(request, prefix	+ "optimum_pass_yn", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] irgRailToNodCd = (JSPUtil.getParameter(request, prefix	+ "irg_rail_to_nod_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] irgDorNodCd = (JSPUtil.getParameter(request, prefix	+ "irg_dor_nod_cd", length));
			String[] woCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_cre_ofc_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] fctryNm = (JSPUtil.getParameter(request, prefix	+ "fctry_nm", length));
			String[] irgRailFmNodCd = (JSPUtil.getParameter(request, prefix	+ "irg_rail_fm_nod_cd", length));
			String[] trspCrrModCtnt = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_ctnt", length));
			String[] bkgTrem = (JSPUtil.getParameter(request, prefix	+ "bkg_trem", length));
			String[] irgFmNodCd = (JSPUtil.getParameter(request, prefix	+ "irg_fm_nod_cd", length));
			String[] bkgCntrQty = (JSPUtil.getParameter(request, prefix	+ "bkg_cntr_qty", length));
			String[] qryOfcCd = (JSPUtil.getParameter(request, prefix	+ "qry_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OptmRoutPassDtlVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (railFmNodCd[i] != null)
					model.setRailFmNodCd(railFmNodCd[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (soDscrRsnCd[i] != null)
					model.setSoDscrRsnCd(soDscrRsnCd[i]);
				if (actCntrQty[i] != null)
					model.setActCntrQty(actCntrQty[i]);
				if (routOrgNodCd[i] != null)
					model.setRoutOrgNodCd(routOrgNodCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dorPstCd[i] != null)
					model.setDorPstCd(dorPstCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (porDelNm[i] != null)
					model.setPorDelNm(porDelNm[i]);
				if (railToNodCd[i] != null)
					model.setRailToNodCd(railToNodCd[i]);
				if (irgToNodCd[i] != null)
					model.setIrgToNodCd(irgToNodCd[i]);
				if (shipNm[i] != null)
					model.setShipNm(shipNm[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (routDestNodCd[i] != null)
					model.setRoutDestNodCd(routDestNodCd[i]);
				if (irgTrspCrrModCtnt[i] != null)
					model.setIrgTrspCrrModCtnt(irgTrspCrrModCtnt[i]);
				if (optimumPassYn[i] != null)
					model.setOptimumPassYn(optimumPassYn[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (irgRailToNodCd[i] != null)
					model.setIrgRailToNodCd(irgRailToNodCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (irgDorNodCd[i] != null)
					model.setIrgDorNodCd(irgDorNodCd[i]);
				if (woCreOfcCd[i] != null)
					model.setWoCreOfcCd(woCreOfcCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (fctryNm[i] != null)
					model.setFctryNm(fctryNm[i]);
				if (irgRailFmNodCd[i] != null)
					model.setIrgRailFmNodCd(irgRailFmNodCd[i]);
				if (trspCrrModCtnt[i] != null)
					model.setTrspCrrModCtnt(trspCrrModCtnt[i]);
				if (bkgTrem[i] != null)
					model.setBkgTrem(bkgTrem[i]);
				if (irgFmNodCd[i] != null)
					model.setIrgFmNodCd(irgFmNodCd[i]);
				if (bkgCntrQty[i] != null)
					model.setBkgCntrQty(bkgCntrQty[i]);
				if (qryOfcCd[i] != null)
					model.setQryOfcCd(qryOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOptmRoutPassDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OptmRoutPassDtlVO[]
	 */
	public OptmRoutPassDtlVO[] getOptmRoutPassDtlVOs(){
		OptmRoutPassDtlVO[] vos = (OptmRoutPassDtlVO[])models.toArray(new OptmRoutPassDtlVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railFmNodCd = this.railFmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soDscrRsnCd = this.soDscrRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCntrQty = this.actCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routOrgNodCd = this.routOrgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorPstCd = this.dorPstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDelNm = this.porDelNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railToNodCd = this.railToNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irgToNodCd = this.irgToNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipNm = this.shipNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDestNodCd = this.routDestNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irgTrspCrrModCtnt = this.irgTrspCrrModCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optimumPassYn = this.optimumPassYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irgRailToNodCd = this.irgRailToNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irgDorNodCd = this.irgDorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCreOfcCd = this.woCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctryNm = this.fctryNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irgRailFmNodCd = this.irgRailFmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCtnt = this.trspCrrModCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrem = this.bkgTrem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irgFmNodCd = this.irgFmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntrQty = this.bkgCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qryOfcCd = this.qryOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
