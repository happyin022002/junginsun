/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchDtlAgmtVO.java
*@FileTitle : SearchDtlAgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.03
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2010.06.03 김종호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo;

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
 * @author 김종호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDtlAgmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDtlAgmtVO> models = new ArrayList<SearchDtlAgmtVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String customerCd = null;
	/* Column Info */
	private String transTd = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String trspAgmtRtTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String transWt = null;
	/* Column Info */
	private String transWr = null;
	/* Column Info */
	private String searchToLoc = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String transWd = null;
	/* Column Info */
	private String trspAgmtEqTpSzCd = null;
	/* Column Info */
	private String searchViaLoc = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String cmdtGrpCd = null;
	/* Column Info */
	private String transRw = null;
	/* Column Info */
	private String transRt = null;
	/* Column Info */
	private String trspAgmtSeq = null;
	/* Column Info */
	private String searchFmLoc = null;
	/* Column Info */
	private String wgtMeasUtCd = null;
	/* Column Info */
	private String searchViaYard = null;
	/* Column Info */
	private String vndrPrmrySeq = null;
	/* Column Info */
	private String railSvcTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String toWgt = null;
	/* Column Info */
	private String way = null;
	/* Column Info */
	private String trspAgmtOfcCtyCd = null;
	/* Column Info */
	private String cargo = null;
	/* Column Info */
	private String searchToYard = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqtpsz = null;
	/* Column Info */
	private String searchDoorLoc = null;
	/* Column Info */
	private String searchFmYard = null;
	/* Column Info */
	private String wtrRcvTermCd = null;
	/* Column Info */
	private String transRd = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String wtrDeTermCd = null;
	/* Column Info */
	private String vndrPrmryNm = null;
	/* Column Info */
	private String trspCostModCd = null;
	/* Column Info */
	private String agmtVndrPrmryFlg = null;
	/* Column Info */
	private String costmode = null;
	/* Column Info */
	private String eqtype = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String searchDoorYard = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String transTw = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String transTr = null;
	/* Column Info */
	private String trspAgmtBdlQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDtlAgmtVO() {}

	public SearchDtlAgmtVO(String ibflag, String pagerows, String vndrPrmrySeq, String vndrPrmryNm, String agmtNo, String trspCostModCd, String cgoTpCd, String customerCd, String cmdtGrpCd, String railSvcTpCd, String fmNodCd, String viaNodCd, String dorNodCd, String toNodCd, String trspAgmtEqTpSzCd, String wtrRcvTermCd, String wtrDeTermCd, String trspAgmtBdlQty, String toWgt, String wgtMeasUtCd, String currCd, String transRd, String transTd, String transWd, String transRt, String transTr, String transWt, String transTw, String transRw, String transWr, String searchFmLoc, String searchViaLoc, String searchDoorLoc, String searchToLoc, String costmode, String cargo, String searchFmYard, String searchViaYard, String searchDoorYard, String searchToYard, String way, String eqtpsz, String eqtype, String agmtVndrPrmryFlg, String trspAgmtRtTpCd, String trspAgmtOfcCtyCd, String trspAgmtSeq, String custCntCd, String custSeq) {
		this.toNodCd = toNodCd;
		this.customerCd = customerCd;
		this.transTd = transTd;
		this.cgoTpCd = cgoTpCd;
		this.trspAgmtRtTpCd = trspAgmtRtTpCd;
		this.pagerows = pagerows;
		this.transWt = transWt;
		this.transWr = transWr;
		this.searchToLoc = searchToLoc;
		this.custCntCd = custCntCd;
		this.transWd = transWd;
		this.trspAgmtEqTpSzCd = trspAgmtEqTpSzCd;
		this.searchViaLoc = searchViaLoc;
		this.agmtNo = agmtNo;
		this.cmdtGrpCd = cmdtGrpCd;
		this.transRw = transRw;
		this.transRt = transRt;
		this.trspAgmtSeq = trspAgmtSeq;
		this.searchFmLoc = searchFmLoc;
		this.wgtMeasUtCd = wgtMeasUtCd;
		this.searchViaYard = searchViaYard;
		this.vndrPrmrySeq = vndrPrmrySeq;
		this.railSvcTpCd = railSvcTpCd;
		this.currCd = currCd;
		this.toWgt = toWgt;
		this.way = way;
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
		this.cargo = cargo;
		this.searchToYard = searchToYard;
		this.ibflag = ibflag;
		this.eqtpsz = eqtpsz;
		this.searchDoorLoc = searchDoorLoc;
		this.searchFmYard = searchFmYard;
		this.wtrRcvTermCd = wtrRcvTermCd;
		this.transRd = transRd;
		this.dorNodCd = dorNodCd;
		this.wtrDeTermCd = wtrDeTermCd;
		this.vndrPrmryNm = vndrPrmryNm;
		this.trspCostModCd = trspCostModCd;
		this.agmtVndrPrmryFlg = agmtVndrPrmryFlg;
		this.costmode = costmode;
		this.eqtype = eqtype;
		this.custSeq = custSeq;
		this.searchDoorYard = searchDoorYard;
		this.fmNodCd = fmNodCd;
		this.transTw = transTw;
		this.viaNodCd = viaNodCd;
		this.transTr = transTr;
		this.trspAgmtBdlQty = trspAgmtBdlQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("customer_cd", getCustomerCd());
		this.hashColumns.put("trans_td", getTransTd());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("trsp_agmt_rt_tp_cd", getTrspAgmtRtTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trans_wt", getTransWt());
		this.hashColumns.put("trans_wr", getTransWr());
		this.hashColumns.put("search_to_loc", getSearchToLoc());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("trans_wd", getTransWd());
		this.hashColumns.put("trsp_agmt_eq_tp_sz_cd", getTrspAgmtEqTpSzCd());
		this.hashColumns.put("search_via_loc", getSearchViaLoc());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("cmdt_grp_cd", getCmdtGrpCd());
		this.hashColumns.put("trans_rw", getTransRw());
		this.hashColumns.put("trans_rt", getTransRt());
		this.hashColumns.put("trsp_agmt_seq", getTrspAgmtSeq());
		this.hashColumns.put("search_fm_loc", getSearchFmLoc());
		this.hashColumns.put("wgt_meas_ut_cd", getWgtMeasUtCd());
		this.hashColumns.put("search_via_yard", getSearchViaYard());
		this.hashColumns.put("vndr_prmry_seq", getVndrPrmrySeq());
		this.hashColumns.put("rail_svc_tp_cd", getRailSvcTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("to_wgt", getToWgt());
		this.hashColumns.put("way", getWay());
		this.hashColumns.put("trsp_agmt_ofc_cty_cd", getTrspAgmtOfcCtyCd());
		this.hashColumns.put("cargo", getCargo());
		this.hashColumns.put("search_to_yard", getSearchToYard());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eqtpsz", getEqtpsz());
		this.hashColumns.put("search_door_loc", getSearchDoorLoc());
		this.hashColumns.put("search_fm_yard", getSearchFmYard());
		this.hashColumns.put("wtr_rcv_term_cd", getWtrRcvTermCd());
		this.hashColumns.put("trans_rd", getTransRd());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("wtr_de_term_cd", getWtrDeTermCd());
		this.hashColumns.put("vndr_prmry_nm", getVndrPrmryNm());
		this.hashColumns.put("trsp_cost_mod_cd", getTrspCostModCd());
		this.hashColumns.put("agmt_vndr_prmry_flg", getAgmtVndrPrmryFlg());
		this.hashColumns.put("costmode", getCostmode());
		this.hashColumns.put("eqtype", getEqtype());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("search_door_yard", getSearchDoorYard());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("trans_tw", getTransTw());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("trans_tr", getTransTr());
		this.hashColumns.put("trsp_agmt_bdl_qty", getTrspAgmtBdlQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("customer_cd", "customerCd");
		this.hashFields.put("trans_td", "transTd");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("trsp_agmt_rt_tp_cd", "trspAgmtRtTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trans_wt", "transWt");
		this.hashFields.put("trans_wr", "transWr");
		this.hashFields.put("search_to_loc", "searchToLoc");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("trans_wd", "transWd");
		this.hashFields.put("trsp_agmt_eq_tp_sz_cd", "trspAgmtEqTpSzCd");
		this.hashFields.put("search_via_loc", "searchViaLoc");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("cmdt_grp_cd", "cmdtGrpCd");
		this.hashFields.put("trans_rw", "transRw");
		this.hashFields.put("trans_rt", "transRt");
		this.hashFields.put("trsp_agmt_seq", "trspAgmtSeq");
		this.hashFields.put("search_fm_loc", "searchFmLoc");
		this.hashFields.put("wgt_meas_ut_cd", "wgtMeasUtCd");
		this.hashFields.put("search_via_yard", "searchViaYard");
		this.hashFields.put("vndr_prmry_seq", "vndrPrmrySeq");
		this.hashFields.put("rail_svc_tp_cd", "railSvcTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("to_wgt", "toWgt");
		this.hashFields.put("way", "way");
		this.hashFields.put("trsp_agmt_ofc_cty_cd", "trspAgmtOfcCtyCd");
		this.hashFields.put("cargo", "cargo");
		this.hashFields.put("search_to_yard", "searchToYard");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eqtpsz", "eqtpsz");
		this.hashFields.put("search_door_loc", "searchDoorLoc");
		this.hashFields.put("search_fm_yard", "searchFmYard");
		this.hashFields.put("wtr_rcv_term_cd", "wtrRcvTermCd");
		this.hashFields.put("trans_rd", "transRd");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("wtr_de_term_cd", "wtrDeTermCd");
		this.hashFields.put("vndr_prmry_nm", "vndrPrmryNm");
		this.hashFields.put("trsp_cost_mod_cd", "trspCostModCd");
		this.hashFields.put("agmt_vndr_prmry_flg", "agmtVndrPrmryFlg");
		this.hashFields.put("costmode", "costmode");
		this.hashFields.put("eqtype", "eqtype");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("search_door_yard", "searchDoorYard");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("trans_tw", "transTw");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("trans_tr", "transTr");
		this.hashFields.put("trsp_agmt_bdl_qty", "trspAgmtBdlQty");
		return this.hashFields;
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
	 * @return customerCd
	 */
	public String getCustomerCd() {
		return this.customerCd;
	}
	
	/**
	 * Column Info
	 * @return transTd
	 */
	public String getTransTd() {
		return this.transTd;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtRtTpCd
	 */
	public String getTrspAgmtRtTpCd() {
		return this.trspAgmtRtTpCd;
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
	 * @return transWt
	 */
	public String getTransWt() {
		return this.transWt;
	}
	
	/**
	 * Column Info
	 * @return transWr
	 */
	public String getTransWr() {
		return this.transWr;
	}
	
	/**
	 * Column Info
	 * @return searchToLoc
	 */
	public String getSearchToLoc() {
		return this.searchToLoc;
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
	 * @return transWd
	 */
	public String getTransWd() {
		return this.transWd;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtEqTpSzCd
	 */
	public String getTrspAgmtEqTpSzCd() {
		return this.trspAgmtEqTpSzCd;
	}
	
	/**
	 * Column Info
	 * @return searchViaLoc
	 */
	public String getSearchViaLoc() {
		return this.searchViaLoc;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return cmdtGrpCd
	 */
	public String getCmdtGrpCd() {
		return this.cmdtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return transRw
	 */
	public String getTransRw() {
		return this.transRw;
	}
	
	/**
	 * Column Info
	 * @return transRt
	 */
	public String getTransRt() {
		return this.transRt;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtSeq
	 */
	public String getTrspAgmtSeq() {
		return this.trspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return searchFmLoc
	 */
	public String getSearchFmLoc() {
		return this.searchFmLoc;
	}
	
	/**
	 * Column Info
	 * @return wgtMeasUtCd
	 */
	public String getWgtMeasUtCd() {
		return this.wgtMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return searchViaYard
	 */
	public String getSearchViaYard() {
		return this.searchViaYard;
	}
	
	/**
	 * Column Info
	 * @return vndrPrmrySeq
	 */
	public String getVndrPrmrySeq() {
		return this.vndrPrmrySeq;
	}
	
	/**
	 * Column Info
	 * @return railSvcTpCd
	 */
	public String getRailSvcTpCd() {
		return this.railSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return toWgt
	 */
	public String getToWgt() {
		return this.toWgt;
	}
	
	/**
	 * Column Info
	 * @return way
	 */
	public String getWay() {
		return this.way;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtOfcCtyCd
	 */
	public String getTrspAgmtOfcCtyCd() {
		return this.trspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return cargo
	 */
	public String getCargo() {
		return this.cargo;
	}
	
	/**
	 * Column Info
	 * @return searchToYard
	 */
	public String getSearchToYard() {
		return this.searchToYard;
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
	 * @return eqtpsz
	 */
	public String getEqtpsz() {
		return this.eqtpsz;
	}
	
	/**
	 * Column Info
	 * @return searchDoorLoc
	 */
	public String getSearchDoorLoc() {
		return this.searchDoorLoc;
	}
	
	/**
	 * Column Info
	 * @return searchFmYard
	 */
	public String getSearchFmYard() {
		return this.searchFmYard;
	}
	
	/**
	 * Column Info
	 * @return wtrRcvTermCd
	 */
	public String getWtrRcvTermCd() {
		return this.wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return transRd
	 */
	public String getTransRd() {
		return this.transRd;
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
	 * @return wtrDeTermCd
	 */
	public String getWtrDeTermCd() {
		return this.wtrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return vndrPrmryNm
	 */
	public String getVndrPrmryNm() {
		return this.vndrPrmryNm;
	}
	
	/**
	 * Column Info
	 * @return trspCostModCd
	 */
	public String getTrspCostModCd() {
		return this.trspCostModCd;
	}
	
	/**
	 * Column Info
	 * @return agmtVndrPrmryFlg
	 */
	public String getAgmtVndrPrmryFlg() {
		return this.agmtVndrPrmryFlg;
	}
	
	/**
	 * Column Info
	 * @return costmode
	 */
	public String getCostmode() {
		return this.costmode;
	}
	
	/**
	 * Column Info
	 * @return eqtype
	 */
	public String getEqtype() {
		return this.eqtype;
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
	 * @return searchDoorYard
	 */
	public String getSearchDoorYard() {
		return this.searchDoorYard;
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
	 * @return transTw
	 */
	public String getTransTw() {
		return this.transTw;
	}
	
	/**
	 * Column Info
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
	}
	
	/**
	 * Column Info
	 * @return transTr
	 */
	public String getTransTr() {
		return this.transTr;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtBdlQty
	 */
	public String getTrspAgmtBdlQty() {
		return this.trspAgmtBdlQty;
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
	 * @param customerCd
	 */
	public void setCustomerCd(String customerCd) {
		this.customerCd = customerCd;
	}
	
	/**
	 * Column Info
	 * @param transTd
	 */
	public void setTransTd(String transTd) {
		this.transTd = transTd;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtRtTpCd
	 */
	public void setTrspAgmtRtTpCd(String trspAgmtRtTpCd) {
		this.trspAgmtRtTpCd = trspAgmtRtTpCd;
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
	 * @param transWt
	 */
	public void setTransWt(String transWt) {
		this.transWt = transWt;
	}
	
	/**
	 * Column Info
	 * @param transWr
	 */
	public void setTransWr(String transWr) {
		this.transWr = transWr;
	}
	
	/**
	 * Column Info
	 * @param searchToLoc
	 */
	public void setSearchToLoc(String searchToLoc) {
		this.searchToLoc = searchToLoc;
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
	 * @param transWd
	 */
	public void setTransWd(String transWd) {
		this.transWd = transWd;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtEqTpSzCd
	 */
	public void setTrspAgmtEqTpSzCd(String trspAgmtEqTpSzCd) {
		this.trspAgmtEqTpSzCd = trspAgmtEqTpSzCd;
	}
	
	/**
	 * Column Info
	 * @param searchViaLoc
	 */
	public void setSearchViaLoc(String searchViaLoc) {
		this.searchViaLoc = searchViaLoc;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param cmdtGrpCd
	 */
	public void setCmdtGrpCd(String cmdtGrpCd) {
		this.cmdtGrpCd = cmdtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param transRw
	 */
	public void setTransRw(String transRw) {
		this.transRw = transRw;
	}
	
	/**
	 * Column Info
	 * @param transRt
	 */
	public void setTransRt(String transRt) {
		this.transRt = transRt;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtSeq
	 */
	public void setTrspAgmtSeq(String trspAgmtSeq) {
		this.trspAgmtSeq = trspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param searchFmLoc
	 */
	public void setSearchFmLoc(String searchFmLoc) {
		this.searchFmLoc = searchFmLoc;
	}
	
	/**
	 * Column Info
	 * @param wgtMeasUtCd
	 */
	public void setWgtMeasUtCd(String wgtMeasUtCd) {
		this.wgtMeasUtCd = wgtMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param searchViaYard
	 */
	public void setSearchViaYard(String searchViaYard) {
		this.searchViaYard = searchViaYard;
	}
	
	/**
	 * Column Info
	 * @param vndrPrmrySeq
	 */
	public void setVndrPrmrySeq(String vndrPrmrySeq) {
		this.vndrPrmrySeq = vndrPrmrySeq;
	}
	
	/**
	 * Column Info
	 * @param railSvcTpCd
	 */
	public void setRailSvcTpCd(String railSvcTpCd) {
		this.railSvcTpCd = railSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param toWgt
	 */
	public void setToWgt(String toWgt) {
		this.toWgt = toWgt;
	}
	
	/**
	 * Column Info
	 * @param way
	 */
	public void setWay(String way) {
		this.way = way;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtOfcCtyCd
	 */
	public void setTrspAgmtOfcCtyCd(String trspAgmtOfcCtyCd) {
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	/**
	 * Column Info
	 * @param searchToYard
	 */
	public void setSearchToYard(String searchToYard) {
		this.searchToYard = searchToYard;
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
	 * @param eqtpsz
	 */
	public void setEqtpsz(String eqtpsz) {
		this.eqtpsz = eqtpsz;
	}
	
	/**
	 * Column Info
	 * @param searchDoorLoc
	 */
	public void setSearchDoorLoc(String searchDoorLoc) {
		this.searchDoorLoc = searchDoorLoc;
	}
	
	/**
	 * Column Info
	 * @param searchFmYard
	 */
	public void setSearchFmYard(String searchFmYard) {
		this.searchFmYard = searchFmYard;
	}
	
	/**
	 * Column Info
	 * @param wtrRcvTermCd
	 */
	public void setWtrRcvTermCd(String wtrRcvTermCd) {
		this.wtrRcvTermCd = wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param transRd
	 */
	public void setTransRd(String transRd) {
		this.transRd = transRd;
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
	 * @param wtrDeTermCd
	 */
	public void setWtrDeTermCd(String wtrDeTermCd) {
		this.wtrDeTermCd = wtrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param vndrPrmryNm
	 */
	public void setVndrPrmryNm(String vndrPrmryNm) {
		this.vndrPrmryNm = vndrPrmryNm;
	}
	
	/**
	 * Column Info
	 * @param trspCostModCd
	 */
	public void setTrspCostModCd(String trspCostModCd) {
		this.trspCostModCd = trspCostModCd;
	}
	
	/**
	 * Column Info
	 * @param agmtVndrPrmryFlg
	 */
	public void setAgmtVndrPrmryFlg(String agmtVndrPrmryFlg) {
		this.agmtVndrPrmryFlg = agmtVndrPrmryFlg;
	}
	
	/**
	 * Column Info
	 * @param costmode
	 */
	public void setCostmode(String costmode) {
		this.costmode = costmode;
	}
	
	/**
	 * Column Info
	 * @param eqtype
	 */
	public void setEqtype(String eqtype) {
		this.eqtype = eqtype;
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
	 * @param searchDoorYard
	 */
	public void setSearchDoorYard(String searchDoorYard) {
		this.searchDoorYard = searchDoorYard;
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
	 * @param transTw
	 */
	public void setTransTw(String transTw) {
		this.transTw = transTw;
	}
	
	/**
	 * Column Info
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * Column Info
	 * @param transTr
	 */
	public void setTransTr(String transTr) {
		this.transTr = transTr;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtBdlQty
	 */
	public void setTrspAgmtBdlQty(String trspAgmtBdlQty) {
		this.trspAgmtBdlQty = trspAgmtBdlQty;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setCustomerCd(JSPUtil.getParameter(request, prefix + "customer_cd", ""));
		setTransTd(JSPUtil.getParameter(request, prefix + "trans_td", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setTrspAgmtRtTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTransWt(JSPUtil.getParameter(request, prefix + "trans_wt", ""));
		setTransWr(JSPUtil.getParameter(request, prefix + "trans_wr", ""));
		setSearchToLoc(JSPUtil.getParameter(request, prefix + "search_to_loc", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setTransWd(JSPUtil.getParameter(request, prefix + "trans_wd", ""));
		setTrspAgmtEqTpSzCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_eq_tp_sz_cd", ""));
		setSearchViaLoc(JSPUtil.getParameter(request, prefix + "search_via_loc", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setCmdtGrpCd(JSPUtil.getParameter(request, prefix + "cmdt_grp_cd", ""));
		setTransRw(JSPUtil.getParameter(request, prefix + "trans_rw", ""));
		setTransRt(JSPUtil.getParameter(request, prefix + "trans_rt", ""));
		setTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_seq", ""));
		setSearchFmLoc(JSPUtil.getParameter(request, prefix + "search_fm_loc", ""));
		setWgtMeasUtCd(JSPUtil.getParameter(request, prefix + "wgt_meas_ut_cd", ""));
		setSearchViaYard(JSPUtil.getParameter(request, prefix + "search_via_yard", ""));
		setVndrPrmrySeq(JSPUtil.getParameter(request, prefix + "vndr_prmry_seq", ""));
		setRailSvcTpCd(JSPUtil.getParameter(request, prefix + "rail_svc_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setToWgt(JSPUtil.getParameter(request, prefix + "to_wgt", ""));
		setWay(JSPUtil.getParameter(request, prefix + "way", ""));
		setTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_ofc_cty_cd", ""));
		setCargo(JSPUtil.getParameter(request, prefix + "cargo", ""));
		setSearchToYard(JSPUtil.getParameter(request, prefix + "search_to_yard", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqtpsz(JSPUtil.getParameter(request, prefix + "eqtpsz", ""));
		setSearchDoorLoc(JSPUtil.getParameter(request, prefix + "search_door_loc", ""));
		setSearchFmYard(JSPUtil.getParameter(request, prefix + "search_fm_yard", ""));
		setWtrRcvTermCd(JSPUtil.getParameter(request, prefix + "wtr_rcv_term_cd", ""));
		setTransRd(JSPUtil.getParameter(request, prefix + "trans_rd", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setWtrDeTermCd(JSPUtil.getParameter(request, prefix + "wtr_de_term_cd", ""));
		setVndrPrmryNm(JSPUtil.getParameter(request, prefix + "vndr_prmry_nm", ""));
		setTrspCostModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_mod_cd", ""));
		setAgmtVndrPrmryFlg(JSPUtil.getParameter(request, prefix + "agmt_vndr_prmry_flg", ""));
		setCostmode(JSPUtil.getParameter(request, prefix + "costmode", ""));
		setEqtype(JSPUtil.getParameter(request, prefix + "eqtype", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSearchDoorYard(JSPUtil.getParameter(request, prefix + "search_door_yard", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setTransTw(JSPUtil.getParameter(request, prefix + "trans_tw", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setTransTr(JSPUtil.getParameter(request, prefix + "trans_tr", ""));
		setTrspAgmtBdlQty(JSPUtil.getParameter(request, prefix + "trsp_agmt_bdl_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDtlAgmtVO[]
	 */
	public SearchDtlAgmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDtlAgmtVO[]
	 */
	public SearchDtlAgmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDtlAgmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] customerCd = (JSPUtil.getParameter(request, prefix	+ "customer_cd", length));
			String[] transTd = (JSPUtil.getParameter(request, prefix	+ "trans_td", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] trspAgmtRtTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_rt_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] transWt = (JSPUtil.getParameter(request, prefix	+ "trans_wt", length));
			String[] transWr = (JSPUtil.getParameter(request, prefix	+ "trans_wr", length));
			String[] searchToLoc = (JSPUtil.getParameter(request, prefix	+ "search_to_loc", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] transWd = (JSPUtil.getParameter(request, prefix	+ "trans_wd", length));
			String[] trspAgmtEqTpSzCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_eq_tp_sz_cd", length));
			String[] searchViaLoc = (JSPUtil.getParameter(request, prefix	+ "search_via_loc", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] cmdtGrpCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_grp_cd", length));
			String[] transRw = (JSPUtil.getParameter(request, prefix	+ "trans_rw", length));
			String[] transRt = (JSPUtil.getParameter(request, prefix	+ "trans_rt", length));
			String[] trspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_seq", length));
			String[] searchFmLoc = (JSPUtil.getParameter(request, prefix	+ "search_fm_loc", length));
			String[] wgtMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_meas_ut_cd", length));
			String[] searchViaYard = (JSPUtil.getParameter(request, prefix	+ "search_via_yard", length));
			String[] vndrPrmrySeq = (JSPUtil.getParameter(request, prefix	+ "vndr_prmry_seq", length));
			String[] railSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_svc_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] toWgt = (JSPUtil.getParameter(request, prefix	+ "to_wgt", length));
			String[] way = (JSPUtil.getParameter(request, prefix	+ "way", length));
			String[] trspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_ofc_cty_cd", length));
			String[] cargo = (JSPUtil.getParameter(request, prefix	+ "cargo", length));
			String[] searchToYard = (JSPUtil.getParameter(request, prefix	+ "search_to_yard", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqtpsz = (JSPUtil.getParameter(request, prefix	+ "eqtpsz", length));
			String[] searchDoorLoc = (JSPUtil.getParameter(request, prefix	+ "search_door_loc", length));
			String[] searchFmYard = (JSPUtil.getParameter(request, prefix	+ "search_fm_yard", length));
			String[] wtrRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_rcv_term_cd", length));
			String[] transRd = (JSPUtil.getParameter(request, prefix	+ "trans_rd", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] wtrDeTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_de_term_cd", length));
			String[] vndrPrmryNm = (JSPUtil.getParameter(request, prefix	+ "vndr_prmry_nm", length));
			String[] trspCostModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_mod_cd", length));
			String[] agmtVndrPrmryFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_vndr_prmry_flg", length));
			String[] costmode = (JSPUtil.getParameter(request, prefix	+ "costmode", length));
			String[] eqtype = (JSPUtil.getParameter(request, prefix	+ "eqtype", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] searchDoorYard = (JSPUtil.getParameter(request, prefix	+ "search_door_yard", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] transTw = (JSPUtil.getParameter(request, prefix	+ "trans_tw", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] transTr = (JSPUtil.getParameter(request, prefix	+ "trans_tr", length));
			String[] trspAgmtBdlQty = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_bdl_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDtlAgmtVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (customerCd[i] != null)
					model.setCustomerCd(customerCd[i]);
				if (transTd[i] != null)
					model.setTransTd(transTd[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (trspAgmtRtTpCd[i] != null)
					model.setTrspAgmtRtTpCd(trspAgmtRtTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (transWt[i] != null)
					model.setTransWt(transWt[i]);
				if (transWr[i] != null)
					model.setTransWr(transWr[i]);
				if (searchToLoc[i] != null)
					model.setSearchToLoc(searchToLoc[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (transWd[i] != null)
					model.setTransWd(transWd[i]);
				if (trspAgmtEqTpSzCd[i] != null)
					model.setTrspAgmtEqTpSzCd(trspAgmtEqTpSzCd[i]);
				if (searchViaLoc[i] != null)
					model.setSearchViaLoc(searchViaLoc[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (cmdtGrpCd[i] != null)
					model.setCmdtGrpCd(cmdtGrpCd[i]);
				if (transRw[i] != null)
					model.setTransRw(transRw[i]);
				if (transRt[i] != null)
					model.setTransRt(transRt[i]);
				if (trspAgmtSeq[i] != null)
					model.setTrspAgmtSeq(trspAgmtSeq[i]);
				if (searchFmLoc[i] != null)
					model.setSearchFmLoc(searchFmLoc[i]);
				if (wgtMeasUtCd[i] != null)
					model.setWgtMeasUtCd(wgtMeasUtCd[i]);
				if (searchViaYard[i] != null)
					model.setSearchViaYard(searchViaYard[i]);
				if (vndrPrmrySeq[i] != null)
					model.setVndrPrmrySeq(vndrPrmrySeq[i]);
				if (railSvcTpCd[i] != null)
					model.setRailSvcTpCd(railSvcTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (toWgt[i] != null)
					model.setToWgt(toWgt[i]);
				if (way[i] != null)
					model.setWay(way[i]);
				if (trspAgmtOfcCtyCd[i] != null)
					model.setTrspAgmtOfcCtyCd(trspAgmtOfcCtyCd[i]);
				if (cargo[i] != null)
					model.setCargo(cargo[i]);
				if (searchToYard[i] != null)
					model.setSearchToYard(searchToYard[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqtpsz[i] != null)
					model.setEqtpsz(eqtpsz[i]);
				if (searchDoorLoc[i] != null)
					model.setSearchDoorLoc(searchDoorLoc[i]);
				if (searchFmYard[i] != null)
					model.setSearchFmYard(searchFmYard[i]);
				if (wtrRcvTermCd[i] != null)
					model.setWtrRcvTermCd(wtrRcvTermCd[i]);
				if (transRd[i] != null)
					model.setTransRd(transRd[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (wtrDeTermCd[i] != null)
					model.setWtrDeTermCd(wtrDeTermCd[i]);
				if (vndrPrmryNm[i] != null)
					model.setVndrPrmryNm(vndrPrmryNm[i]);
				if (trspCostModCd[i] != null)
					model.setTrspCostModCd(trspCostModCd[i]);
				if (agmtVndrPrmryFlg[i] != null)
					model.setAgmtVndrPrmryFlg(agmtVndrPrmryFlg[i]);
				if (costmode[i] != null)
					model.setCostmode(costmode[i]);
				if (eqtype[i] != null)
					model.setEqtype(eqtype[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (searchDoorYard[i] != null)
					model.setSearchDoorYard(searchDoorYard[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (transTw[i] != null)
					model.setTransTw(transTw[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (transTr[i] != null)
					model.setTransTr(transTr[i]);
				if (trspAgmtBdlQty[i] != null)
					model.setTrspAgmtBdlQty(trspAgmtBdlQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDtlAgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDtlAgmtVO[]
	 */
	public SearchDtlAgmtVO[] getSearchDtlAgmtVOs(){
		SearchDtlAgmtVO[] vos = (SearchDtlAgmtVO[])models.toArray(new SearchDtlAgmtVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerCd = this.customerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTd = this.transTd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRtTpCd = this.trspAgmtRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transWt = this.transWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transWr = this.transWr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchToLoc = this.searchToLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transWd = this.transWd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtEqTpSzCd = this.trspAgmtEqTpSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchViaLoc = this.searchViaLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtGrpCd = this.cmdtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transRw = this.transRw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transRt = this.transRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtSeq = this.trspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchFmLoc = this.searchFmLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtMeasUtCd = this.wgtMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchViaYard = this.searchViaYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrPrmrySeq = this.vndrPrmrySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railSvcTpCd = this.railSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWgt = this.toWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.way = this.way .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtOfcCtyCd = this.trspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargo = this.cargo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchToYard = this.searchToYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqtpsz = this.eqtpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDoorLoc = this.searchDoorLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchFmYard = this.searchFmYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrRcvTermCd = this.wtrRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transRd = this.transRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrDeTermCd = this.wtrDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrPrmryNm = this.vndrPrmryNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostModCd = this.trspCostModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVndrPrmryFlg = this.agmtVndrPrmryFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costmode = this.costmode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqtype = this.eqtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDoorYard = this.searchDoorYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTw = this.transTw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTr = this.transTr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtBdlQty = this.trspAgmtBdlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
