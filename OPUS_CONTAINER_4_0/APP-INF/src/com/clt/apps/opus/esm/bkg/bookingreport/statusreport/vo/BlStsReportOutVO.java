/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlStsReportOutVO.java
*@FileTitle : BlStsReportOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.01.20 김태경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlStsReportOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlStsReportOutVO> models = new ArrayList<BlStsReportOutVO>();
	
	/* Column Info */
	private String salesOffice = null;
	/* Column Info */
	private String orsNo = null;
	/* Column Info */
	private String payTermCd = null;
	/* Column Info */
	private String cct = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String orsOffice = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blReleased = null;
	/* Column Info */
	private String irBlType = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String rowsPerPage = null;
	/* Column Info */
	private String currPage = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String cct3rd = null;
	/* Column Info */
	private String bdiSr = null;
	/* Column Info */
	private String oblIssRmk = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String ppdOrg = null;
	/* Column Info */
	private String cctDest2 = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String obDate = null;
	/* Column Info */
	private String cct3rd2 = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String salesRep = null;
	/* Column Info */
	private String orsDo = null;
	/* Column Info */
	private String ppdOrg2 = null;
	/* Column Info */
	private String obType = null;
	/* Column Info */
	private String delOfc = null;
	/* Column Info */
	private String ppd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String blIssued = null;
	/* Column Info */
	private String orsSurrender = null;
	/* Column Info */
	private String consignee = null;
	/* Column Info */
	private String ppd3rd = null;
	/* Column Info */
	private String irOffice = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fowarder = null;
	/* Column Info */
	private String bkgOfc = null;
	/* Column Info */
	private String blPrint = null;
	/* Column Info */
	private String orsDate = null;
	/* Column Info */
	private String bdiBy = null;
	/* Column Info */
	private String cctDest = null;
	/* Column Info */
	private String shipper = null;
	/* Column Info */
	private String irBy = null;
	/* Column Info */
	private String ppd3rd2 = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String irDate = null;
	/* Column Info */
	private String bdiOffice = null;
	/* Column Info */
	private String bdiComplete = null;
	/* Column Info */
	private String bdiType = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlStsReportOutVO() {}

	public BlStsReportOutVO(String ibflag, String pagerows, String bkgNo, String blNo, String porCd, String polCd, String podCd, String delCd, String bkgOfc, String delOfc, String obType, String obDate, String irBlType, String irOffice, String irDate, String irBy, String orsOffice, String orsDate, String orsNo, String orsSurrender, String orsDo, String bdiSr, String bdiComplete, String bdiOffice, String bdiBy, String vvdCd, String shipper, String consignee, String salesOffice, String salesRep, String ppd, String cct, String blIssued, String blReleased, String ppdOrg, String ppd3rd, String cctDest, String cct3rd, String oblIssRmk, String ppdOrg2, String ppd3rd2, String cctDest2, String cct3rd2, String fowarder, String blPrint, String scRfaNo, String payTermCd, String totalCnt, String rowsPerPage, String currPage, String rnum, String bdiType) {
		this.salesOffice = salesOffice;
		this.orsNo = orsNo;
		this.payTermCd = payTermCd;
		this.cct = cct;
		this.blNo = blNo;
		this.orsOffice = orsOffice;
		this.pagerows = pagerows;
		this.blReleased = blReleased;
		this.irBlType = irBlType;
		this.polCd = polCd;
		this.rowsPerPage = rowsPerPage;
		this.currPage = currPage;
		this.vvdCd = vvdCd;
		this.rnum = rnum;
		this.cct3rd = cct3rd;
		this.bdiSr = bdiSr;
		this.oblIssRmk = oblIssRmk;
		this.totalCnt = totalCnt;
		this.ppdOrg = ppdOrg;
		this.cctDest2 = cctDest2;
		this.delCd = delCd;
		this.podCd = podCd;
		this.obDate = obDate;
		this.cct3rd2 = cct3rd2;
		this.bkgNo = bkgNo;
		this.salesRep = salesRep;
		this.orsDo = orsDo;
		this.ppdOrg2 = ppdOrg2;
		this.obType = obType;
		this.delOfc = delOfc;
		this.ppd = ppd;
		this.porCd = porCd;
		this.blIssued = blIssued;
		this.orsSurrender = orsSurrender;
		this.consignee = consignee;
		this.ppd3rd = ppd3rd;
		this.irOffice = irOffice;
		this.ibflag = ibflag;
		this.fowarder = fowarder;
		this.bkgOfc = bkgOfc;
		this.blPrint = blPrint;
		this.orsDate = orsDate;
		this.bdiBy = bdiBy;
		this.cctDest = cctDest;
		this.shipper = shipper;
		this.irBy = irBy;
		this.ppd3rd2 = ppd3rd2;
		this.scRfaNo = scRfaNo;
		this.irDate = irDate;
		this.bdiOffice = bdiOffice;
		this.bdiComplete = bdiComplete;
		this.bdiType = bdiType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sales_office", getSalesOffice());
		this.hashColumns.put("ors_no", getOrsNo());
		this.hashColumns.put("pay_term_cd", getPayTermCd());
		this.hashColumns.put("cct", getCct());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ors_office", getOrsOffice());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_released", getBlReleased());
		this.hashColumns.put("ir_bl_type", getIrBlType());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("rows_per_page", getRowsPerPage());
		this.hashColumns.put("curr_page", getCurrPage());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("cct_3rd", getCct3rd());
		this.hashColumns.put("bdi_sr", getBdiSr());
		this.hashColumns.put("obl_iss_rmk", getOblIssRmk());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("ppd_org", getPpdOrg());
		this.hashColumns.put("cct_dest2", getCctDest2());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ob_date", getObDate());
		this.hashColumns.put("cct_3rd2", getCct3rd2());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sales_rep", getSalesRep());
		this.hashColumns.put("ors_do", getOrsDo());
		this.hashColumns.put("ppd_org2", getPpdOrg2());
		this.hashColumns.put("ob_type", getObType());
		this.hashColumns.put("del_ofc", getDelOfc());
		this.hashColumns.put("ppd", getPpd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bl_issued", getBlIssued());
		this.hashColumns.put("ors_surrender", getOrsSurrender());
		this.hashColumns.put("consignee", getConsignee());
		this.hashColumns.put("ppd_3rd", getPpd3rd());
		this.hashColumns.put("ir_office", getIrOffice());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fowarder", getFowarder());
		this.hashColumns.put("bkg_ofc", getBkgOfc());
		this.hashColumns.put("bl_print", getBlPrint());
		this.hashColumns.put("ors_date", getOrsDate());
		this.hashColumns.put("bdi_by", getBdiBy());
		this.hashColumns.put("cct_dest", getCctDest());
		this.hashColumns.put("shipper", getShipper());
		this.hashColumns.put("ir_by", getIrBy());
		this.hashColumns.put("ppd_3rd2", getPpd3rd2());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("ir_date", getIrDate());
		this.hashColumns.put("bdi_office", getBdiOffice());
		this.hashColumns.put("bdi_complete", getBdiComplete());
		this.hashColumns.put("bdi_type", getBdiType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sales_office", "salesOffice");
		this.hashFields.put("ors_no", "orsNo");
		this.hashFields.put("pay_term_cd", "payTermCd");
		this.hashFields.put("cct", "cct");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ors_office", "orsOffice");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_released", "blReleased");
		this.hashFields.put("ir_bl_type", "irBlType");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("cct_3rd", "cct3rd");
		this.hashFields.put("bdi_sr", "bdiSr");
		this.hashFields.put("obl_iss_rmk", "oblIssRmk");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("ppd_org", "ppdOrg");
		this.hashFields.put("cct_dest2", "cctDest2");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ob_date", "obDate");
		this.hashFields.put("cct_3rd2", "cct3rd2");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sales_rep", "salesRep");
		this.hashFields.put("ors_do", "orsDo");
		this.hashFields.put("ppd_org2", "ppdOrg2");
		this.hashFields.put("ob_type", "obType");
		this.hashFields.put("del_ofc", "delOfc");
		this.hashFields.put("ppd", "ppd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bl_issued", "blIssued");
		this.hashFields.put("ors_surrender", "orsSurrender");
		this.hashFields.put("consignee", "consignee");
		this.hashFields.put("ppd_3rd", "ppd3rd");
		this.hashFields.put("ir_office", "irOffice");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fowarder", "fowarder");
		this.hashFields.put("bkg_ofc", "bkgOfc");
		this.hashFields.put("bl_print", "blPrint");
		this.hashFields.put("ors_date", "orsDate");
		this.hashFields.put("bdi_by", "bdiBy");
		this.hashFields.put("cct_dest", "cctDest");
		this.hashFields.put("shipper", "shipper");
		this.hashFields.put("ir_by", "irBy");
		this.hashFields.put("ppd_3rd2", "ppd3rd2");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("ir_date", "irDate");
		this.hashFields.put("bdi_office", "bdiOffice");
		this.hashFields.put("bdi_complete", "bdiComplete");
		this.hashFields.put("bdi_type", "bdiType");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return salesOffice
	 */
	public String getSalesOffice() {
		return this.salesOffice;
	}
	
	/**
	 * Column Info
	 * @return orsNo
	 */
	public String getOrsNo() {
		return this.orsNo;
	}
	
	/**
	 * Column Info
	 * @return payTermCd
	 */
	public String getPayTermCd() {
		return this.payTermCd;
	}
	
	/**
	 * Column Info
	 * @return cct
	 */
	public String getCct() {
		return this.cct;
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
	 * @return orsOffice
	 */
	public String getOrsOffice() {
		return this.orsOffice;
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
	 * @return blReleased
	 */
	public String getBlReleased() {
		return this.blReleased;
	}
	
	/**
	 * Column Info
	 * @return irBlType
	 */
	public String getIrBlType() {
		return this.irBlType;
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
	 * @return rowsPerPage
	 */
	public String getRowsPerPage() {
		return this.rowsPerPage;
	}
	
	/**
	 * Column Info
	 * @return currPage
	 */
	public String getCurrPage() {
		return this.currPage;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return cct3rd
	 */
	public String getCct3rd() {
		return this.cct3rd;
	}
	
	/**
	 * Column Info
	 * @return bdiSr
	 */
	public String getBdiSr() {
		return this.bdiSr;
	}
	
	/**
	 * Column Info
	 * @return oblIssRmk
	 */
	public String getOblIssRmk() {
		return this.oblIssRmk;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}
	
	/**
	 * Column Info
	 * @return ppdOrg
	 */
	public String getPpdOrg() {
		return this.ppdOrg;
	}
	
	/**
	 * Column Info
	 * @return cctDest2
	 */
	public String getCctDest2() {
		return this.cctDest2;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return obDate
	 */
	public String getObDate() {
		return this.obDate;
	}
	
	/**
	 * Column Info
	 * @return cct3rd2
	 */
	public String getCct3rd2() {
		return this.cct3rd2;
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
	 * @return salesRep
	 */
	public String getSalesRep() {
		return this.salesRep;
	}
	
	/**
	 * Column Info
	 * @return orsDo
	 */
	public String getOrsDo() {
		return this.orsDo;
	}
	
	/**
	 * Column Info
	 * @return ppdOrg2
	 */
	public String getPpdOrg2() {
		return this.ppdOrg2;
	}
	
	/**
	 * Column Info
	 * @return obType
	 */
	public String getObType() {
		return this.obType;
	}
	
	/**
	 * Column Info
	 * @return delOfc
	 */
	public String getDelOfc() {
		return this.delOfc;
	}
	
	/**
	 * Column Info
	 * @return ppd
	 */
	public String getPpd() {
		return this.ppd;
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
	 * @return blIssued
	 */
	public String getBlIssued() {
		return this.blIssued;
	}
	
	/**
	 * Column Info
	 * @return orsSurrender
	 */
	public String getOrsSurrender() {
		return this.orsSurrender;
	}
	
	/**
	 * Column Info
	 * @return consignee
	 */
	public String getConsignee() {
		return this.consignee;
	}
	
	/**
	 * Column Info
	 * @return ppd3rd
	 */
	public String getPpd3rd() {
		return this.ppd3rd;
	}
	
	/**
	 * Column Info
	 * @return irOffice
	 */
	public String getIrOffice() {
		return this.irOffice;
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
	 * @return fowarder
	 */
	public String getFowarder() {
		return this.fowarder;
	}
	
	/**
	 * Column Info
	 * @return bkgOfc
	 */
	public String getBkgOfc() {
		return this.bkgOfc;
	}
	
	/**
	 * Column Info
	 * @return blPrint
	 */
	public String getBlPrint() {
		return this.blPrint;
	}
	
	/**
	 * Column Info
	 * @return orsDate
	 */
	public String getOrsDate() {
		return this.orsDate;
	}
	
	/**
	 * Column Info
	 * @return bdiBy
	 */
	public String getBdiBy() {
		return this.bdiBy;
	}
	
	/**
	 * Column Info
	 * @return cctDest
	 */
	public String getCctDest() {
		return this.cctDest;
	}
	
	/**
	 * Column Info
	 * @return shipper
	 */
	public String getShipper() {
		return this.shipper;
	}
	
	/**
	 * Column Info
	 * @return irBy
	 */
	public String getIrBy() {
		return this.irBy;
	}
	
	/**
	 * Column Info
	 * @return ppd3rd2
	 */
	public String getPpd3rd2() {
		return this.ppd3rd2;
	}
	
	/**
	 * Column Info
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
	}
	
	/**
	 * Column Info
	 * @return irDate
	 */
	public String getIrDate() {
		return this.irDate;
	}
	
	/**
	 * Column Info
	 * @return bdiOffice
	 */
	public String getBdiOffice() {
		return this.bdiOffice;
	}
	
	/**
	 * Column Info
	 * @return bdiComplete
	 */
	public String getBdiComplete() {
		return this.bdiComplete;
	}
	
	/**
	 * Column Info
	 * @return bdiType
	 */
	public String getBdiType() {
		return this.bdiType;
	}

	/**
	 * Column Info
	 * @param salesOffice
	 */
	public void setSalesOffice(String salesOffice) {
		this.salesOffice = salesOffice;
	}
	
	/**
	 * Column Info
	 * @param orsNo
	 */
	public void setOrsNo(String orsNo) {
		this.orsNo = orsNo;
	}
	
	/**
	 * Column Info
	 * @param payTermCd
	 */
	public void setPayTermCd(String payTermCd) {
		this.payTermCd = payTermCd;
	}
	
	/**
	 * Column Info
	 * @param cct
	 */
	public void setCct(String cct) {
		this.cct = cct;
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
	 * @param orsOffice
	 */
	public void setOrsOffice(String orsOffice) {
		this.orsOffice = orsOffice;
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
	 * @param blReleased
	 */
	public void setBlReleased(String blReleased) {
		this.blReleased = blReleased;
	}
	
	/**
	 * Column Info
	 * @param irBlType
	 */
	public void setIrBlType(String irBlType) {
		this.irBlType = irBlType;
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
	 * @param rowsPerPage
	 */
	public void setRowsPerPage(String rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	
	/**
	 * Column Info
	 * @param currPage
	 */
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param cct3rd
	 */
	public void setCct3rd(String cct3rd) {
		this.cct3rd = cct3rd;
	}
	
	/**
	 * Column Info
	 * @param bdiSr
	 */
	public void setBdiSr(String bdiSr) {
		this.bdiSr = bdiSr;
	}
	
	/**
	 * Column Info
	 * @param oblIssRmk
	 */
	public void setOblIssRmk(String oblIssRmk) {
		this.oblIssRmk = oblIssRmk;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Column Info
	 * @param ppdOrg
	 */
	public void setPpdOrg(String ppdOrg) {
		this.ppdOrg = ppdOrg;
	}
	
	/**
	 * Column Info
	 * @param cctDest2
	 */
	public void setCctDest2(String cctDest2) {
		this.cctDest2 = cctDest2;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param obDate
	 */
	public void setObDate(String obDate) {
		this.obDate = obDate;
	}
	
	/**
	 * Column Info
	 * @param cct3rd2
	 */
	public void setCct3rd2(String cct3rd2) {
		this.cct3rd2 = cct3rd2;
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
	 * @param salesRep
	 */
	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
	}
	
	/**
	 * Column Info
	 * @param orsDo
	 */
	public void setOrsDo(String orsDo) {
		this.orsDo = orsDo;
	}
	
	/**
	 * Column Info
	 * @param ppdOrg2
	 */
	public void setPpdOrg2(String ppdOrg2) {
		this.ppdOrg2 = ppdOrg2;
	}
	
	/**
	 * Column Info
	 * @param obType
	 */
	public void setObType(String obType) {
		this.obType = obType;
	}
	
	/**
	 * Column Info
	 * @param delOfc
	 */
	public void setDelOfc(String delOfc) {
		this.delOfc = delOfc;
	}
	
	/**
	 * Column Info
	 * @param ppd
	 */
	public void setPpd(String ppd) {
		this.ppd = ppd;
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
	 * @param blIssued
	 */
	public void setBlIssued(String blIssued) {
		this.blIssued = blIssued;
	}
	
	/**
	 * Column Info
	 * @param orsSurrender
	 */
	public void setOrsSurrender(String orsSurrender) {
		this.orsSurrender = orsSurrender;
	}
	
	/**
	 * Column Info
	 * @param consignee
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	/**
	 * Column Info
	 * @param ppd3rd
	 */
	public void setPpd3rd(String ppd3rd) {
		this.ppd3rd = ppd3rd;
	}
	
	/**
	 * Column Info
	 * @param irOffice
	 */
	public void setIrOffice(String irOffice) {
		this.irOffice = irOffice;
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
	 * @param fowarder
	 */
	public void setFowarder(String fowarder) {
		this.fowarder = fowarder;
	}
	
	/**
	 * Column Info
	 * @param bkgOfc
	 */
	public void setBkgOfc(String bkgOfc) {
		this.bkgOfc = bkgOfc;
	}
	
	/**
	 * Column Info
	 * @param blPrint
	 */
	public void setBlPrint(String blPrint) {
		this.blPrint = blPrint;
	}
	
	/**
	 * Column Info
	 * @param orsDate
	 */
	public void setOrsDate(String orsDate) {
		this.orsDate = orsDate;
	}
	
	/**
	 * Column Info
	 * @param bdiBy
	 */
	public void setBdiBy(String bdiBy) {
		this.bdiBy = bdiBy;
	}
	
	/**
	 * Column Info
	 * @param cctDest
	 */
	public void setCctDest(String cctDest) {
		this.cctDest = cctDest;
	}
	
	/**
	 * Column Info
	 * @param shipper
	 */
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
	
	/**
	 * Column Info
	 * @param irBy
	 */
	public void setIrBy(String irBy) {
		this.irBy = irBy;
	}
	
	/**
	 * Column Info
	 * @param ppd3rd2
	 */
	public void setPpd3rd2(String ppd3rd2) {
		this.ppd3rd2 = ppd3rd2;
	}
	
	/**
	 * Column Info
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
	}
	
	/**
	 * Column Info
	 * @param irDate
	 */
	public void setIrDate(String irDate) {
		this.irDate = irDate;
	}
	
	/**
	 * Column Info
	 * @param bdiOffice
	 */
	public void setBdiOffice(String bdiOffice) {
		this.bdiOffice = bdiOffice;
	}
	
	/**
	 * Column Info
	 * @param bdiComplete
	 */
	public void setBdiComplete(String bdiComplete) {
		this.bdiComplete = bdiComplete;
	}
	
	/**
	 * Column Info
	 * @param bdiType
	 */
	public void setBdiType(String bdiType) {
		this.bdiType = bdiType;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSalesOffice(JSPUtil.getParameter(request, "sales_office", ""));
		setOrsNo(JSPUtil.getParameter(request, "ors_no", ""));
		setPayTermCd(JSPUtil.getParameter(request, "pay_term_cd", ""));
		setCct(JSPUtil.getParameter(request, "cct", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setOrsOffice(JSPUtil.getParameter(request, "ors_office", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBlReleased(JSPUtil.getParameter(request, "bl_released", ""));
		setIrBlType(JSPUtil.getParameter(request, "ir_bl_type", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setRowsPerPage(JSPUtil.getParameter(request, "rows_per_page", ""));
		setCurrPage(JSPUtil.getParameter(request, "curr_page", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setRnum(JSPUtil.getParameter(request, "rnum", ""));
		setCct3rd(JSPUtil.getParameter(request, "cct_3rd", ""));
		setBdiSr(JSPUtil.getParameter(request, "bdi_sr", ""));
		setOblIssRmk(JSPUtil.getParameter(request, "obl_iss_rmk", ""));
		setTotalCnt(JSPUtil.getParameter(request, "total_cnt", ""));
		setPpdOrg(JSPUtil.getParameter(request, "ppd_org", ""));
		setCctDest2(JSPUtil.getParameter(request, "cct_dest2", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setObDate(JSPUtil.getParameter(request, "ob_date", ""));
		setCct3rd2(JSPUtil.getParameter(request, "cct_3rd2", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSalesRep(JSPUtil.getParameter(request, "sales_rep", ""));
		setOrsDo(JSPUtil.getParameter(request, "ors_do", ""));
		setPpdOrg2(JSPUtil.getParameter(request, "ppd_org2", ""));
		setObType(JSPUtil.getParameter(request, "ob_type", ""));
		setDelOfc(JSPUtil.getParameter(request, "del_ofc", ""));
		setPpd(JSPUtil.getParameter(request, "ppd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setBlIssued(JSPUtil.getParameter(request, "bl_issued", ""));
		setOrsSurrender(JSPUtil.getParameter(request, "ors_surrender", ""));
		setConsignee(JSPUtil.getParameter(request, "consignee", ""));
		setPpd3rd(JSPUtil.getParameter(request, "ppd_3rd", ""));
		setIrOffice(JSPUtil.getParameter(request, "ir_office", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFowarder(JSPUtil.getParameter(request, "fowarder", ""));
		setBkgOfc(JSPUtil.getParameter(request, "bkg_ofc", ""));
		setBlPrint(JSPUtil.getParameter(request, "bl_print", ""));
		setOrsDate(JSPUtil.getParameter(request, "ors_date", ""));
		setBdiBy(JSPUtil.getParameter(request, "bdi_by", ""));
		setCctDest(JSPUtil.getParameter(request, "cct_dest", ""));
		setShipper(JSPUtil.getParameter(request, "shipper", ""));
		setIrBy(JSPUtil.getParameter(request, "ir_by", ""));
		setPpd3rd2(JSPUtil.getParameter(request, "ppd_3rd2", ""));
		setScRfaNo(JSPUtil.getParameter(request, "sc_rfa_no", ""));
		setIrDate(JSPUtil.getParameter(request, "ir_date", ""));
		setBdiOffice(JSPUtil.getParameter(request, "bdi_office", ""));
		setBdiComplete(JSPUtil.getParameter(request, "bdi_complete", ""));
		setBdiType(JSPUtil.getParameter(request, "bdi_type", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlStsReportOutVO[]
	 */
	public BlStsReportOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlStsReportOutVO[]
	 */
	public BlStsReportOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlStsReportOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] salesOffice = (JSPUtil.getParameter(request, prefix	+ "sales_office", length));
			String[] orsNo = (JSPUtil.getParameter(request, prefix	+ "ors_no", length));
			String[] payTermCd = (JSPUtil.getParameter(request, prefix	+ "pay_term_cd", length));
			String[] cct = (JSPUtil.getParameter(request, prefix	+ "cct", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] orsOffice = (JSPUtil.getParameter(request, prefix	+ "ors_office", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blReleased = (JSPUtil.getParameter(request, prefix	+ "bl_released", length));
			String[] irBlType = (JSPUtil.getParameter(request, prefix	+ "ir_bl_type", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] rowsPerPage = (JSPUtil.getParameter(request, prefix	+ "rows_per_page", length));
			String[] currPage = (JSPUtil.getParameter(request, prefix	+ "curr_page", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] cct3rd = (JSPUtil.getParameter(request, prefix	+ "cct_3rd", length));
			String[] bdiSr = (JSPUtil.getParameter(request, prefix	+ "bdi_sr", length));
			String[] oblIssRmk = (JSPUtil.getParameter(request, prefix	+ "obl_iss_rmk", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] ppdOrg = (JSPUtil.getParameter(request, prefix	+ "ppd_org", length));
			String[] cctDest2 = (JSPUtil.getParameter(request, prefix	+ "cct_dest2", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] obDate = (JSPUtil.getParameter(request, prefix	+ "ob_date", length));
			String[] cct3rd2 = (JSPUtil.getParameter(request, prefix	+ "cct_3rd2", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] salesRep = (JSPUtil.getParameter(request, prefix	+ "sales_rep", length));
			String[] orsDo = (JSPUtil.getParameter(request, prefix	+ "ors_do", length));
			String[] ppdOrg2 = (JSPUtil.getParameter(request, prefix	+ "ppd_org2", length));
			String[] obType = (JSPUtil.getParameter(request, prefix	+ "ob_type", length));
			String[] delOfc = (JSPUtil.getParameter(request, prefix	+ "del_ofc", length));
			String[] ppd = (JSPUtil.getParameter(request, prefix	+ "ppd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] blIssued = (JSPUtil.getParameter(request, prefix	+ "bl_issued", length));
			String[] orsSurrender = (JSPUtil.getParameter(request, prefix	+ "ors_surrender", length));
			String[] consignee = (JSPUtil.getParameter(request, prefix	+ "consignee", length));
			String[] ppd3rd = (JSPUtil.getParameter(request, prefix	+ "ppd_3rd", length));
			String[] irOffice = (JSPUtil.getParameter(request, prefix	+ "ir_office", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fowarder = (JSPUtil.getParameter(request, prefix	+ "fowarder", length));
			String[] bkgOfc = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc", length));
			String[] blPrint = (JSPUtil.getParameter(request, prefix	+ "bl_print", length));
			String[] orsDate = (JSPUtil.getParameter(request, prefix	+ "ors_date", length));
			String[] bdiBy = (JSPUtil.getParameter(request, prefix	+ "bdi_by", length));
			String[] cctDest = (JSPUtil.getParameter(request, prefix	+ "cct_dest", length));
			String[] shipper = (JSPUtil.getParameter(request, prefix	+ "shipper", length));
			String[] irBy = (JSPUtil.getParameter(request, prefix	+ "ir_by", length));
			String[] ppd3rd2 = (JSPUtil.getParameter(request, prefix	+ "ppd_3rd2", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] irDate = (JSPUtil.getParameter(request, prefix	+ "ir_date", length));
			String[] bdiOffice = (JSPUtil.getParameter(request, prefix	+ "bdi_office", length));
			String[] bdiComplete = (JSPUtil.getParameter(request, prefix	+ "bdi_complete", length));
			String[] bdiType = (JSPUtil.getParameter(request, prefix	+ "bdi_type", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new BlStsReportOutVO();
				if (salesOffice[i] != null)
					model.setSalesOffice(salesOffice[i]);
				if (orsNo[i] != null)
					model.setOrsNo(orsNo[i]);
				if (payTermCd[i] != null)
					model.setPayTermCd(payTermCd[i]);
				if (cct[i] != null)
					model.setCct(cct[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (orsOffice[i] != null)
					model.setOrsOffice(orsOffice[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blReleased[i] != null)
					model.setBlReleased(blReleased[i]);
				if (irBlType[i] != null)
					model.setIrBlType(irBlType[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (rowsPerPage[i] != null)
					model.setRowsPerPage(rowsPerPage[i]);
				if (currPage[i] != null)
					model.setCurrPage(currPage[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (cct3rd[i] != null)
					model.setCct3rd(cct3rd[i]);
				if (bdiSr[i] != null)
					model.setBdiSr(bdiSr[i]);
				if (oblIssRmk[i] != null)
					model.setOblIssRmk(oblIssRmk[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (ppdOrg[i] != null)
					model.setPpdOrg(ppdOrg[i]);
				if (cctDest2[i] != null)
					model.setCctDest2(cctDest2[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (obDate[i] != null)
					model.setObDate(obDate[i]);
				if (cct3rd2[i] != null)
					model.setCct3rd2(cct3rd2[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (salesRep[i] != null)
					model.setSalesRep(salesRep[i]);
				if (orsDo[i] != null)
					model.setOrsDo(orsDo[i]);
				if (ppdOrg2[i] != null)
					model.setPpdOrg2(ppdOrg2[i]);
				if (obType[i] != null)
					model.setObType(obType[i]);
				if (delOfc[i] != null)
					model.setDelOfc(delOfc[i]);
				if (ppd[i] != null)
					model.setPpd(ppd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (blIssued[i] != null)
					model.setBlIssued(blIssued[i]);
				if (orsSurrender[i] != null)
					model.setOrsSurrender(orsSurrender[i]);
				if (consignee[i] != null)
					model.setConsignee(consignee[i]);
				if (ppd3rd[i] != null)
					model.setPpd3rd(ppd3rd[i]);
				if (irOffice[i] != null)
					model.setIrOffice(irOffice[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fowarder[i] != null)
					model.setFowarder(fowarder[i]);
				if (bkgOfc[i] != null)
					model.setBkgOfc(bkgOfc[i]);
				if (blPrint[i] != null)
					model.setBlPrint(blPrint[i]);
				if (orsDate[i] != null)
					model.setOrsDate(orsDate[i]);
				if (bdiBy[i] != null)
					model.setBdiBy(bdiBy[i]);
				if (cctDest[i] != null)
					model.setCctDest(cctDest[i]);
				if (shipper[i] != null)
					model.setShipper(shipper[i]);
				if (irBy[i] != null)
					model.setIrBy(irBy[i]);
				if (ppd3rd2[i] != null)
					model.setPpd3rd2(ppd3rd2[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (irDate[i] != null)
					model.setIrDate(irDate[i]);
				if (bdiOffice[i] != null)
					model.setBdiOffice(bdiOffice[i]);
				if (bdiComplete[i] != null)
					model.setBdiComplete(bdiComplete[i]);
				if (bdiType[i] != null)
					model.setBdiType(bdiType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlStsReportOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlStsReportOutVO[]
	 */
	public BlStsReportOutVO[] getBlStsReportOutVOs(){
		BlStsReportOutVO[] vos = (BlStsReportOutVO[])models.toArray(new BlStsReportOutVO[models.size()]);
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
		this.salesOffice = this.salesOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orsNo = this.orsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermCd = this.payTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct = this.cct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orsOffice = this.orsOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blReleased = this.blReleased .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irBlType = this.irBlType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage = this.rowsPerPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage = this.currPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct3rd = this.cct3rd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdiSr = this.bdiSr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssRmk = this.oblIssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdOrg = this.ppdOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctDest2 = this.cctDest2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obDate = this.obDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct3rd2 = this.cct3rd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesRep = this.salesRep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orsDo = this.orsDo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdOrg2 = this.ppdOrg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obType = this.obType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delOfc = this.delOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppd = this.ppd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssued = this.blIssued .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orsSurrender = this.orsSurrender .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignee = this.consignee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppd3rd = this.ppd3rd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irOffice = this.irOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fowarder = this.fowarder .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfc = this.bkgOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPrint = this.blPrint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orsDate = this.orsDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdiBy = this.bdiBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctDest = this.cctDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipper = this.shipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irBy = this.irBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppd3rd2 = this.ppd3rd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irDate = this.irDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdiOffice = this.bdiOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdiComplete = this.bdiComplete .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdiType = this.bdiType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
