/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandCostConditionVO.java
*@FileTitle : InlandCostConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.18
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.06.18 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InlandCostConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InlandCostConditionVO> models = new ArrayList<InlandCostConditionVO>();
	
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String inSortBy = null;
	/* Column Info */
	private String costFactorCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String excelRcvDeTermCd = null;
	/* Column Info */
	private String excelSysSrcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String excelCostFactorCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String excelDateFlg = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String inAscDesc = null;
	/* Column Info */
	private String costSelRoutFlg = null;
	/* Column Info */
	private String inCostTrfBatSeq = null;
	/* Column Info */
	private String dateFlg = null;
	/* Column Info */
	private String excelTrspCrrModCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String excelAdjustmentCd = null;
	/* Column Info */
	private String inCostTrfNo = null;
	/* Column Info */
	private String sysSrcCd = null;
	/* Column Info */
	private String hubNodCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String adjustmentCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String portNodCd = null;
	/* Column Info */
	private String bntFlg = null;
	/* Column Info */
	private String inCntCd = null;
	/* Column Info */
	private String locNodCd = null;
	/* Column Info */
	private String excelIoBndCd = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String costRoutGrpNo = null;
	/* Column Info */
	private String sCostRoutGrpNo = null;
	/* Column Info */
	private String excelFromDt = null;
	/* Column Info */
	private String excelToDt = null;
	/* Column Info */
	private String excelEffToDt = null;
	/* Column Info */
	private String excelChkIncl = null;
	/* Column Info */
	private String excelLocNodCd = null;
	/* Column Info */
	private String excelHubNodCd = null;
	/* Column Info */
	private String excelPortNodCd = null;
	/* Column Info */
	private String excelCostTrfNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InlandCostConditionVO() {}

	public InlandCostConditionVO(String ibflag, String pagerows, String fromDt, String currCd, String inSortBy, String costFactorCd, String excelRcvDeTermCd, String excelSysSrcCd, String excelCostFactorCd, String cntCd, String rcvDeTermCd, String excelDateFlg, String trspCrrModCd, String inAscDesc, String costSelRoutFlg, String dateFlg, String excelTrspCrrModCd, String rhqCd, String costTrfNo, String excelAdjustmentCd, String inCostTrfNo, String sysSrcCd, String hubNodCd, String ioBndCd, String toDt, String adjustmentCd, String portNodCd, String bntFlg, String inCntCd, String locNodCd, String effToDt, String inCostTrfBatSeq, String excelIoBndCd, String costRoutGrpNo, String sCostRoutGrpNo, String excelFromDt, String excelToDt, String excelEffToDt, String excelChkIncl, String excelLocNodCd, String excelHubNodCd, String excelPortNodCd, String excelCostTrfNo) {
		this.fromDt = fromDt;
		this.currCd = currCd;
		this.inSortBy = inSortBy;
		this.costFactorCd = costFactorCd;
		this.pagerows = pagerows;
		this.excelRcvDeTermCd = excelRcvDeTermCd;
		this.excelSysSrcCd = excelSysSrcCd;
		this.ibflag = ibflag;
		this.excelCostFactorCd = excelCostFactorCd;
		this.cntCd = cntCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.excelDateFlg = excelDateFlg;
		this.trspCrrModCd = trspCrrModCd;
		this.inAscDesc = inAscDesc;
		this.costSelRoutFlg = costSelRoutFlg;
		this.inCostTrfBatSeq = inCostTrfBatSeq;
		this.dateFlg = dateFlg;
		this.excelTrspCrrModCd = excelTrspCrrModCd;
		this.rhqCd = rhqCd;
		this.costTrfNo = costTrfNo;
		this.excelAdjustmentCd = excelAdjustmentCd;
		this.inCostTrfNo = inCostTrfNo;
		this.sysSrcCd = sysSrcCd;
		this.hubNodCd = hubNodCd;
		this.ioBndCd = ioBndCd;
		this.adjustmentCd = adjustmentCd;
		this.toDt = toDt;
		this.portNodCd = portNodCd;
		this.bntFlg = bntFlg;
		this.inCntCd = inCntCd;
		this.locNodCd = locNodCd;
		this.excelIoBndCd = excelIoBndCd;
		this.effToDt = effToDt;
		this.costRoutGrpNo = costRoutGrpNo;
		this.sCostRoutGrpNo = sCostRoutGrpNo;
		this.excelFromDt = excelFromDt;
		this.excelToDt = excelToDt;
		this.excelEffToDt = excelEffToDt;
		this.excelChkIncl = excelChkIncl;
		this.excelLocNodCd = excelLocNodCd;
		this.excelHubNodCd = excelHubNodCd;
		this.excelPortNodCd = excelPortNodCd;
		this.excelCostTrfNo = excelCostTrfNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("in_sort_by", getInSortBy());
		this.hashColumns.put("cost_factor_cd", getCostFactorCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("excel_rcv_de_term_cd", getExcelRcvDeTermCd());
		this.hashColumns.put("excel_sys_src_cd", getExcelSysSrcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("excel_cost_factor_cd", getExcelCostFactorCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("excel_date_flg", getExcelDateFlg());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("in_asc_desc", getInAscDesc());
		this.hashColumns.put("cost_sel_rout_flg", getCostSelRoutFlg());
		this.hashColumns.put("in_cost_trf_bat_seq", getInCostTrfBatSeq());
		this.hashColumns.put("date_flg", getDateFlg());
		this.hashColumns.put("excel_trsp_crr_mod_cd", getExcelTrspCrrModCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("excel_adjustment_cd", getExcelAdjustmentCd());
		this.hashColumns.put("in_cost_trf_no", getInCostTrfNo());
		this.hashColumns.put("sys_src_cd", getSysSrcCd());
		this.hashColumns.put("hub_nod_cd", getHubNodCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("adjustment_cd", getAdjustmentCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("port_nod_cd", getPortNodCd());
		this.hashColumns.put("bnt_flg", getBntFlg());
		this.hashColumns.put("in_cnt_cd", getInCntCd());
		this.hashColumns.put("loc_nod_cd", getLocNodCd());
		this.hashColumns.put("excel_io_bnd_cd", getExcelIoBndCd());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("cost_rout_grp_no", getCostRoutGrpNo());
		this.hashColumns.put("s_cost_rout_grp_no", getSCostRoutGrpNo());
		this.hashColumns.put("excel_from_dt", getExcelFromDt());
		this.hashColumns.put("excel_to_dt", getExcelToDt());
		this.hashColumns.put("excel_eff_to_dt", getExcelEffToDt());
		this.hashColumns.put("excel_chk_incl", getExcelChkIncl());
		this.hashColumns.put("excel_loc_nod_cd", getExcelLocNodCd());
		this.hashColumns.put("excel_hub_nod_cd", getExcelHubNodCd());
		this.hashColumns.put("excel_port_nod_cd", getExcelPortNodCd());
		this.hashColumns.put("excel_cost_trf_no", getExcelCostTrfNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("in_sort_by", "inSortBy");
		this.hashFields.put("cost_factor_cd", "costFactorCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("excel_rcv_de_term_cd", "excelRcvDeTermCd");
		this.hashFields.put("excel_sys_src_cd", "excelSysSrcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("excel_cost_factor_cd", "excelCostFactorCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("excel_date_flg", "excelDateFlg");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("in_asc_desc", "inAscDesc");
		this.hashFields.put("cost_sel_rout_flg", "costSelRoutFlg");
		this.hashFields.put("in_cost_trf_bat_seq", "inCostTrfBatSeq");
		this.hashFields.put("date_flg", "dateFlg");
		this.hashFields.put("excel_trsp_crr_mod_cd", "excelTrspCrrModCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("excel_adjustment_cd", "excelAdjustmentCd");
		this.hashFields.put("in_cost_trf_no", "inCostTrfNo");
		this.hashFields.put("sys_src_cd", "sysSrcCd");
		this.hashFields.put("hub_nod_cd", "hubNodCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("adjustment_cd", "adjustmentCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("port_nod_cd", "portNodCd");
		this.hashFields.put("bnt_flg", "bntFlg");
		this.hashFields.put("in_cnt_cd", "inCntCd");
		this.hashFields.put("loc_nod_cd", "locNodCd");
		this.hashFields.put("excel_io_bnd_cd", "excelIoBndCd");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("cost_rout_grp_no", "costRoutGrpNo");
		this.hashFields.put("s_cost_rout_grp_no", "sCostRoutGrpNo");
		this.hashFields.put("excel_from_dt", "excelFromDt");
		this.hashFields.put("excel_to_dt", "excelToDt");
		this.hashFields.put("excel_eff_to_dt", "excelEffToDt");
		this.hashFields.put("excel_chk_incl", "excelChkIncl");
		this.hashFields.put("excel_loc_nod_cd", "excelLocNodCd");
		this.hashFields.put("excel_hub_nod_cd", "excelHubNodCd");
		this.hashFields.put("excel_port_nod_cd", "excelPortNodCd");
		this.hashFields.put("excel_cost_trf_no", "excelCostTrfNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
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
	 * @return inSortBy
	 */
	public String getInSortBy() {
		return this.inSortBy;
	}
	
	/**
	 * Column Info
	 * @return costFactorCd
	 */
	public String getCostFactorCd() {
		return this.costFactorCd;
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
	 * @return excelRcvDeTermCd
	 */
	public String getExcelRcvDeTermCd() {
		return this.excelRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return excelSysSrcCd
	 */
	public String getExcelSysSrcCd() {
		return this.excelSysSrcCd;
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
	 * @return excelCostFactorCd
	 */
	public String getExcelCostFactorCd() {
		return this.excelCostFactorCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return excelDateFlg
	 */
	public String getExcelDateFlg() {
		return this.excelDateFlg;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return inAscDesc
	 */
	public String getInAscDesc() {
		return this.inAscDesc;
	}
	
	/**
	 * Column Info
	 * @return costSelRoutFlg
	 */
	public String getCostSelRoutFlg() {
		return this.costSelRoutFlg;
	}
	
	/**
	 * Column Info
	 * @return inCostTrfBatSeq
	 */
	public String getInCostTrfBatSeq() {
		return this.inCostTrfBatSeq;
	}
	
	/**
	 * Column Info
	 * @return dateFlg
	 */
	public String getDateFlg() {
		return this.dateFlg;
	}
	
	/**
	 * Column Info
	 * @return excelTrspCrrModCd
	 */
	public String getExcelTrspCrrModCd() {
		return this.excelTrspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return costTrfNo
	 */
	public String getCostTrfNo() {
		return this.costTrfNo;
	}
	
	/**
	 * Column Info
	 * @return excelAdjustmentCd
	 */
	public String getExcelAdjustmentCd() {
		return this.excelAdjustmentCd;
	}
	
	/**
	 * Column Info
	 * @return inCostTrfNo
	 */
	public String getInCostTrfNo() {
		return this.inCostTrfNo;
	}
	
	/**
	 * Column Info
	 * @return sysSrcCd
	 */
	public String getSysSrcCd() {
		return this.sysSrcCd;
	}
	
	/**
	 * Column Info
	 * @return hubNodCd
	 */
	public String getHubNodCd() {
		return this.hubNodCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return adjustmentCd
	 */
	public String getAdjustmentCd() {
		return this.adjustmentCd;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return portNodCd
	 */
	public String getPortNodCd() {
		return this.portNodCd;
	}
	
	/**
	 * Column Info
	 * @return bntFlg
	 */
	public String getBntFlg() {
		return this.bntFlg;
	}
	
	/**
	 * Column Info
	 * @return inCntCd
	 */
	public String getInCntCd() {
		return this.inCntCd;
	}
	
	/**
	 * Column Info
	 * @return locNodCd
	 */
	public String getLocNodCd() {
		return this.locNodCd;
	}
	
	/**
	 * Column Info
	 * @return excelIoBndCd
	 */
	public String getExcelIoBndCd() {
		return this.excelIoBndCd;
	}
	
	/**
	 * Column Info
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
	}
	
	/**
	 * Column Info
	 * @return costRoutGrpNo
	 */
	public String getCostRoutGrpNo() {
		return this.costRoutGrpNo;
	}
	
	/**
	 * Column Info
	 * @return sCostRoutGrpNo
	 */
	public String getSCostRoutGrpNo() {
		return this.sCostRoutGrpNo;
	}
	
	/**
	 * Column Info
	 * @return excelFromDt
	 */
	public String getExcelFromDt() {
		return this.excelFromDt;
	}
	
	/**
	 * Column Info
	 * @return excelToDt
	 */
	public String getExcelToDt() {
		return this.excelToDt;
	}
	
	/**
	 * Column Info
	 * @return excelEffToDt
	 */
	public String getExcelEffToDt() {
		return this.excelEffToDt;
	}
	
	/**
	 * Column Info
	 * @return excelChkIncl
	 */
	public String getExcelChkIncl() {
		return this.excelChkIncl;
	}
	
	/**
	 * Column Info
	 * @return excelLocNodCd
	 */
	public String getExcelLocNodCd() {
		return this.excelLocNodCd;
	}
	
	/**
	 * Column Info
	 * @return excelHubNodCd
	 */
	public String getExcelHubNodCd() {
		return this.excelHubNodCd;
	}
	
	/**
	 * Column Info
	 * @return excelPortNodCd
	 */
	public String getExcelPortNodCd() {
		return this.excelPortNodCd;
	}
	
	/**
	 * Column Info
	 * @return excelCostTrfNo
	 */
	public String getExcelCostTrfNo() {
		return this.excelCostTrfNo;
	}
	

	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
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
	 * @param inSortBy
	 */
	public void setInSortBy(String inSortBy) {
		this.inSortBy = inSortBy;
	}
	
	/**
	 * Column Info
	 * @param costFactorCd
	 */
	public void setCostFactorCd(String costFactorCd) {
		this.costFactorCd = costFactorCd;
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
	 * @param excelRcvDeTermCd
	 */
	public void setExcelRcvDeTermCd(String excelRcvDeTermCd) {
		this.excelRcvDeTermCd = excelRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param excelSysSrcCd
	 */
	public void setExcelSysSrcCd(String excelSysSrcCd) {
		this.excelSysSrcCd = excelSysSrcCd;
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
	 * @param excelCostFactorCd
	 */
	public void setExcelCostFactorCd(String excelCostFactorCd) {
		this.excelCostFactorCd = excelCostFactorCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param excelDateFlg
	 */
	public void setExcelDateFlg(String excelDateFlg) {
		this.excelDateFlg = excelDateFlg;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param inAscDesc
	 */
	public void setInAscDesc(String inAscDesc) {
		this.inAscDesc = inAscDesc;
	}
	
	/**
	 * Column Info
	 * @param costSelRoutFlg
	 */
	public void setCostSelRoutFlg(String costSelRoutFlg) {
		this.costSelRoutFlg = costSelRoutFlg;
	}
	
	/**
	 * Column Info
	 * @param inCostTrfBatSeq
	 */
	public void setInCostTrfBatSeq(String inCostTrfBatSeq) {
		this.inCostTrfBatSeq = inCostTrfBatSeq;
	}
	
	/**
	 * Column Info
	 * @param dateFlg
	 */
	public void setDateFlg(String dateFlg) {
		this.dateFlg = dateFlg;
	}
	
	/**
	 * Column Info
	 * @param excelTrspCrrModCd
	 */
	public void setExcelTrspCrrModCd(String excelTrspCrrModCd) {
		this.excelTrspCrrModCd = excelTrspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param costTrfNo
	 */
	public void setCostTrfNo(String costTrfNo) {
		this.costTrfNo = costTrfNo;
	}
	
	/**
	 * Column Info
	 * @param excelAdjustmentCd
	 */
	public void setExcelAdjustmentCd(String excelAdjustmentCd) {
		this.excelAdjustmentCd = excelAdjustmentCd;
	}
	
	/**
	 * Column Info
	 * @param inCostTrfNo
	 */
	public void setInCostTrfNo(String inCostTrfNo) {
		this.inCostTrfNo = inCostTrfNo;
	}
	
	/**
	 * Column Info
	 * @param sysSrcCd
	 */
	public void setSysSrcCd(String sysSrcCd) {
		this.sysSrcCd = sysSrcCd;
	}
	
	/**
	 * Column Info
	 * @param hubNodCd
	 */
	public void setHubNodCd(String hubNodCd) {
		this.hubNodCd = hubNodCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param adjustmentCd
	 */
	public void setAdjustmentCd(String adjustmentCd) {
		this.adjustmentCd = adjustmentCd;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param portNodCd
	 */
	public void setPortNodCd(String portNodCd) {
		this.portNodCd = portNodCd;
	}
	
	/**
	 * Column Info
	 * @param bntFlg
	 */
	public void setBntFlg(String bntFlg) {
		this.bntFlg = bntFlg;
	}
	
	/**
	 * Column Info
	 * @param inCntCd
	 */
	public void setInCntCd(String inCntCd) {
		this.inCntCd = inCntCd;
	}
	
	/**
	 * Column Info
	 * @param locNodCd
	 */
	public void setLocNodCd(String locNodCd) {
		this.locNodCd = locNodCd;
	}
	
	/**
	 * Column Info
	 * @param excelIoBndCd
	 */
	public void setExcelIoBndCd(String excelIoBndCd) {
		this.excelIoBndCd = excelIoBndCd;
	}
	
	/**
	 * Column Info
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
	}
	
	/**
	 * Column Info
	 * @param costRoutGrpNo
	 */
	public void setCostRoutGrpNo(String costRoutGrpNo) {
		this.costRoutGrpNo = costRoutGrpNo;
	}
	
	/**
	 * Column Info
	 * @param sCostRoutGrpNo
	 */
	public void setSCostRoutGrpNo(String sCostRoutGrpNo) {
		this.sCostRoutGrpNo = sCostRoutGrpNo;
	}
	
	/**
	 * Column Info
	 * @param excelFromDt
	 */
	public void setExcelFromDt(String excelFromDt) {
		this.excelFromDt = excelFromDt;
	}
	
	/**
	 * Column Info
	 * @param excelToDt
	 */
	public void setExcelToDt(String excelToDt) {
		this.excelToDt = excelToDt;
	}
	
	/**
	 * Column Info
	 * @param sCostRoutGrpNo
	 */
	public void setExcelEffToDt(String excelEffToDt) {
		this.excelEffToDt = excelEffToDt;
	}
	
	/**
	 * Column Info
	 * @param excelChkIncl
	 */
	public void setExcelChkIncl(String excelChkIncl) {
		this.excelChkIncl = excelChkIncl;
	}
	
	/**
	 * Column Info
	 * @param excelLocNodCd
	 */
	public void setExcelLocNodCd(String excelLocNodCd) {
		this.excelLocNodCd = excelLocNodCd;
	}
	
	/**
	 * Column Info
	 * @param excelHubNodCd
	 */
	public void setExcelHubNodCd(String excelHubNodCd) {
		this.excelHubNodCd = excelHubNodCd;
	}
	
	/**
	 * Column Info
	 * @param excelPortNodCd
	 */
	public void setExcelPortNodCd(String excelPortNodCd) {
		this.excelPortNodCd = excelPortNodCd;
	}
	
	/**
	 * Column Info
	 * @param excelCostTrfNo
	 */
	public void setExcelCostTrfNo(String excelCostTrfNo) {
		this.excelCostTrfNo = excelCostTrfNo;
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
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setInSortBy(JSPUtil.getParameter(request, prefix + "in_sort_by", ""));
		setCostFactorCd(JSPUtil.getParameter(request, prefix + "cost_factor_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setExcelRcvDeTermCd(JSPUtil.getParameter(request, prefix + "excel_rcv_de_term_cd", ""));
		setExcelSysSrcCd(JSPUtil.getParameter(request, prefix + "excel_sys_src_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExcelCostFactorCd(JSPUtil.getParameter(request, prefix + "excel_cost_factor_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setExcelDateFlg(JSPUtil.getParameter(request, prefix + "excel_date_flg", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setInAscDesc(JSPUtil.getParameter(request, prefix + "in_asc_desc", ""));
		setCostSelRoutFlg(JSPUtil.getParameter(request, prefix + "cost_sel_rout_flg", ""));
		setInCostTrfBatSeq(JSPUtil.getParameter(request, prefix + "in_cost_trf_bat_seq", ""));
		setDateFlg(JSPUtil.getParameter(request, prefix + "date_flg", ""));
		setExcelTrspCrrModCd(JSPUtil.getParameter(request, prefix + "excel_trsp_crr_mod_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setExcelAdjustmentCd(JSPUtil.getParameter(request, prefix + "excel_adjustment_cd", ""));
		setInCostTrfNo(JSPUtil.getParameter(request, prefix + "in_cost_trf_no", ""));
		setSysSrcCd(JSPUtil.getParameter(request, prefix + "sys_src_cd", ""));
		setHubNodCd(JSPUtil.getParameter(request, prefix + "hub_nod_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setAdjustmentCd(JSPUtil.getParameter(request, prefix + "adjustment_cd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setPortNodCd(JSPUtil.getParameter(request, prefix + "port_nod_cd", ""));
		setBntFlg(JSPUtil.getParameter(request, prefix + "bnt_flg", ""));
		setInCntCd(JSPUtil.getParameter(request, prefix + "in_cnt_cd", ""));
		setLocNodCd(JSPUtil.getParameter(request, prefix + "loc_nod_cd", ""));
		setExcelIoBndCd(JSPUtil.getParameter(request, prefix + "excel_io_bnd_cd", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setCostRoutGrpNo(JSPUtil.getParameter(request, prefix + "cost_rout_grp_no", ""));
		setSCostRoutGrpNo(JSPUtil.getParameter(request, prefix + "s_cost_rout_grp_no", ""));
		setExcelFromDt(JSPUtil.getParameter(request, prefix + "excel_from_dt", ""));
		setExcelToDt(JSPUtil.getParameter(request, prefix + "excel_to_dt", ""));
		setExcelEffToDt(JSPUtil.getParameter(request, prefix + "excel_eff_to_dt", ""));
		setExcelChkIncl(JSPUtil.getParameter(request, prefix + "excel_chk_incl", ""));
		setExcelLocNodCd(JSPUtil.getParameter(request, prefix + "excel_loc_nod_cd", ""));
		setExcelHubNodCd(JSPUtil.getParameter(request, prefix + "excel_hub_nod_cd", ""));
		setExcelPortNodCd(JSPUtil.getParameter(request, prefix + "excel_port_nod_cd", ""));
		setExcelCostTrfNo(JSPUtil.getParameter(request, prefix + "excel_cost_trf_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InlandCostConditionVO[]
	 */
	public InlandCostConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InlandCostConditionVO[]
	 */
	public InlandCostConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InlandCostConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] inSortBy = (JSPUtil.getParameter(request, prefix	+ "in_sort_by", length));
			String[] costFactorCd = (JSPUtil.getParameter(request, prefix	+ "cost_factor_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] excelRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "excel_rcv_de_term_cd", length));
			String[] excelSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "excel_sys_src_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] excelCostFactorCd = (JSPUtil.getParameter(request, prefix	+ "excel_cost_factor_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] excelDateFlg = (JSPUtil.getParameter(request, prefix	+ "excel_date_flg", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] inAscDesc = (JSPUtil.getParameter(request, prefix	+ "in_asc_desc", length));
			String[] costSelRoutFlg = (JSPUtil.getParameter(request, prefix	+ "cost_sel_rout_flg", length));
			String[] inCostTrfBatSeq = (JSPUtil.getParameter(request, prefix	+ "in_cost_trf_bat_seq", length));
			String[] dateFlg = (JSPUtil.getParameter(request, prefix	+ "date_flg", length));
			String[] excelTrspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "excel_trsp_crr_mod_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] excelAdjustmentCd = (JSPUtil.getParameter(request, prefix	+ "excel_adjustment_cd", length));
			String[] inCostTrfNo = (JSPUtil.getParameter(request, prefix	+ "in_cost_trf_no", length));
			String[] sysSrcCd = (JSPUtil.getParameter(request, prefix	+ "sys_src_cd", length));
			String[] hubNodCd = (JSPUtil.getParameter(request, prefix	+ "hub_nod_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] adjustmentCd = (JSPUtil.getParameter(request, prefix	+ "adjustment_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] portNodCd = (JSPUtil.getParameter(request, prefix	+ "port_nod_cd", length));
			String[] bntFlg = (JSPUtil.getParameter(request, prefix	+ "bnt_flg", length));
			String[] inCntCd = (JSPUtil.getParameter(request, prefix	+ "in_cnt_cd", length));
			String[] locNodCd = (JSPUtil.getParameter(request, prefix	+ "loc_nod_cd", length));
			String[] excelIoBndCd = (JSPUtil.getParameter(request, prefix	+ "excel_io_bnd_cd", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] costRoutGrpNo = (JSPUtil.getParameter(request, prefix	+ "cost_rout_grp_no", length));
			String[] sCostRoutGrpNo = (JSPUtil.getParameter(request, prefix	+ "s_cost_rout_grp_no", length));
			String[] excelFromDt = (JSPUtil.getParameter(request, prefix	+ "excel_from_dt", length));
			String[] excelToDt = (JSPUtil.getParameter(request, prefix	+ "excel_to_dt", length));
			String[] excelEffToDt = (JSPUtil.getParameter(request, prefix	+ "excel_eff_to_dt", length));
			String[] excelChkIncl = (JSPUtil.getParameter(request, prefix	+ "excel_chk_incl", length));
			String[] excelLocNodCd = (JSPUtil.getParameter(request, prefix	+ "excel_loc_nod_cd", length));
			String[] excelHubNodCd = (JSPUtil.getParameter(request, prefix	+ "excel_hub_nod_cd", length));
			String[] excelPortNodCd = (JSPUtil.getParameter(request, prefix	+ "excel_port_nod_cd", length));
			String[] excelCostTrfNo = (JSPUtil.getParameter(request, prefix	+ "excel_cost_trf_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new InlandCostConditionVO();
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (inSortBy[i] != null)
					model.setInSortBy(inSortBy[i]);
				if (costFactorCd[i] != null)
					model.setCostFactorCd(costFactorCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (excelRcvDeTermCd[i] != null)
					model.setExcelRcvDeTermCd(excelRcvDeTermCd[i]);
				if (excelSysSrcCd[i] != null)
					model.setExcelSysSrcCd(excelSysSrcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (excelCostFactorCd[i] != null)
					model.setExcelCostFactorCd(excelCostFactorCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (excelDateFlg[i] != null)
					model.setExcelDateFlg(excelDateFlg[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (inAscDesc[i] != null)
					model.setInAscDesc(inAscDesc[i]);
				if (costSelRoutFlg[i] != null)
					model.setCostSelRoutFlg(costSelRoutFlg[i]);
				if (inCostTrfBatSeq[i] != null)
					model.setInCostTrfBatSeq(inCostTrfBatSeq[i]);
				if (dateFlg[i] != null)
					model.setDateFlg(dateFlg[i]);
				if (excelTrspCrrModCd[i] != null)
					model.setExcelTrspCrrModCd(excelTrspCrrModCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (excelAdjustmentCd[i] != null)
					model.setExcelAdjustmentCd(excelAdjustmentCd[i]);
				if (inCostTrfNo[i] != null)
					model.setInCostTrfNo(inCostTrfNo[i]);
				if (sysSrcCd[i] != null)
					model.setSysSrcCd(sysSrcCd[i]);
				if (hubNodCd[i] != null)
					model.setHubNodCd(hubNodCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (adjustmentCd[i] != null)
					model.setAdjustmentCd(adjustmentCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (portNodCd[i] != null)
					model.setPortNodCd(portNodCd[i]);
				if (bntFlg[i] != null)
					model.setBntFlg(bntFlg[i]);
				if (inCntCd[i] != null)
					model.setInCntCd(inCntCd[i]);
				if (locNodCd[i] != null)
					model.setLocNodCd(locNodCd[i]);
				if (excelIoBndCd[i] != null)
					model.setExcelIoBndCd(excelIoBndCd[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (costRoutGrpNo[i] != null)
					model.setCostRoutGrpNo(costRoutGrpNo[i]);
				if (sCostRoutGrpNo[i] != null)
					model.setSCostRoutGrpNo(sCostRoutGrpNo[i]);
				if (excelFromDt[i] != null)
					model.setExcelFromDt(excelFromDt[i]);
				if (excelToDt[i] != null)
					model.setExcelToDt(excelToDt[i]);
				if (excelEffToDt[i] != null)
					model.setExcelEffToDt(excelEffToDt[i]);
				if (excelChkIncl[i] != null)
					model.setExcelChkIncl(excelChkIncl[i]);
				if (excelLocNodCd[i] != null)
					model.setExcelLocNodCd(excelLocNodCd[i]);
				if (excelHubNodCd[i] != null)
					model.setExcelHubNodCd(excelHubNodCd[i]);
				if (excelPortNodCd[i] != null)
					model.setExcelPortNodCd(excelPortNodCd[i]);
				if (excelCostTrfNo[i] != null)
					model.setExcelCostTrfNo(excelCostTrfNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInlandCostConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InlandCostConditionVO[]
	 */
	public InlandCostConditionVO[] getInlandCostConditionVOs(){
		InlandCostConditionVO[] vos = (InlandCostConditionVO[])models.toArray(new InlandCostConditionVO[models.size()]);
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
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSortBy = this.inSortBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costFactorCd = this.costFactorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelRcvDeTermCd = this.excelRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelSysSrcCd = this.excelSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelCostFactorCd = this.excelCostFactorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelDateFlg = this.excelDateFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inAscDesc = this.inAscDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSelRoutFlg = this.costSelRoutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCostTrfBatSeq = this.inCostTrfBatSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateFlg = this.dateFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelTrspCrrModCd = this.excelTrspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelAdjustmentCd = this.excelAdjustmentCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCostTrfNo = this.inCostTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSrcCd = this.sysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubNodCd = this.hubNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjustmentCd = this.adjustmentCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNodCd = this.portNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bntFlg = this.bntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntCd = this.inCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNodCd = this.locNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelIoBndCd = this.excelIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRoutGrpNo = this.costRoutGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCostRoutGrpNo = this.sCostRoutGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelFromDt = this.excelFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelToDt = this.excelToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelEffToDt = this.excelEffToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelChkIncl = this.excelChkIncl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelLocNodCd = this.excelLocNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelHubNodCd = this.excelHubNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelPortNodCd = this.excelPortNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelCostTrfNo = this.excelCostTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
