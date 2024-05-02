/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvtOptionVO.java
*@FileTitle : InvtOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.20
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.20  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo;

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

public class InvtOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvtOptionVO> models = new ArrayList<InvtOptionVO>();
	
	/* Column Info */
	private String toDur = null;
	/* Column Info */
	private String viewFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String locBy = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String tpCd = null;
	/* Column Info */
	private String cntrHngrBarAtchKnt = null;
	/* Column Info */
	private String cntrHngrRckCdO = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String vvd3 = null;
	/* Column Info */
	private String viewCustomer = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bseDt = null;
	/* Column Info */
	private String dispFlg = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String longStayCd = null;
	/* Column Info */
	private String fullFlg = null;
	/* Column Info */
	private String stayDays = null;
	/* Column Info */
	private String cntrHngrRckCdR = null;
	/* Column Info */
	private String cntrUseCoCd = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String froms = null;
	/* Column Info */
	private String opTrndTpCd = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String fromBseDt = null;
	/* Column Info */
	private String objCntrTpszCd = null;
	/* Column Info */
	private String fmPrd = null;
	/* Column Info */
	private String d2PayldFlg = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String plstFlrFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String thsWk = null;
	/* Column Info */
	private String preBatWk = null;
	/* Column Info */
	private String nxtBatWk = null;
	/* Column Info */
	private String batWk = null;
	/* Column Info */
	private String batFlg = null;
	/* Column Info */
	private String yrwk = null;
	/* Column Info */
	private String wkFlg = null;
	/* Column Info */
	private String viewCommodity = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String cntrTpszCd14 = null;
	/* Column Info */
	private String cntrTpszCd15 = null;
	/* Column Info */
	private String cntrTpszCd16 = null;
	/* Column Info */
	private String cntrTpszCd17 = null;
	/* Column Info */
	private String cntrTpszCd18 = null;
	/* Column Info */
	private String cntrTpszCd19 = null;
	/* Column Info */
	private String rfTpCdReefer = null;
	/* Column Info */
	private String rccDate = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String rfCntr = null;
	/* Column Info */
	private String rfTpCdM = null;
	/* Column Info */
	private String rfTpCdC = null;
	/* Column Info */
	private String cntrTpszCd11 = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String cntrTpszCd10 = null;
	/* Column Info */
	private String rfTpCdH = null;
	/* Column Info */
	private String cntrTpszCd13 = null;
	/* Column Info */
	private String cntrTpszCd12 = null;
	/* Column Info */
	private String cntrTpszCd27 = null;
	/* Column Info */
	private String cntrTpszCd28 = null;
	/* Column Info */
	private String cntrTpszCd25 = null;
	/* Column Info */
	private String cntrTpszCd26 = null;
	/* Column Info */
	private String cntrTpszCd29 = null;
	/* Column Info */
	private String toPrd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String queryStr = null;
	/* Column Info */
	private String toBseDt = null;
	/* Column Info */
	private String tsCntrBehind = null;
	/* Column Info */
	private String overStayDays = null;
	/* Column Info */
	private String uclmLsDivCd = null;
	/* Column Info */
	private String yardCd = null;
	/* Column Info */
	private String cntrTpszCd20 = null;
	/* Column Info */
	private String nextVvd = null;
	/* Column Info */
	private String cntrTpszCd24 = null;
	/* Column Info */
	private String cntrTpszCd23 = null;
	/* Column Info */
	private String fmStkJbDt = null;
	/* Column Info */
	private String cntrTpszCd22 = null;
	/* Column Info */
	private String cntrTpszCd21 = null;
	/* Column Info */
	private String cntrHngrRckCd = null;
	/* Column Info */
	private String headCntrTpszCd = null;
	/* Column Info */
	private String offHireFlg = null;
	/* Column Info */
	private String routeTpCd = null;
	/* Column Info */
	private String dmgFlg = null;
	/* Column Info */
	private String locTypeCode = null;
	/* Column Info */
	private String tos = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toStkJbDt = null;
	/* Column Info */
	private String cntrTpszCd30 = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String overFreeDays = null;
	/* Column Info */
	private String polPodWise = null;
	/* Column Info */
	private String cntrTpszCd6 = null;
	/* Column Info */
	private String cntrTpszCd5 = null;
	/* Column Info */
	private String cntrTpszCd8 = null;
	/* Column Info */
	private String cntrTpszCd7 = null;
	/* Column Info */
	private String socCd = null;
	/* Column Info */
	private String cntrTpszCd9 = null;
	/* Column Info */
	private String cntrTpszCd2 = null;
	/* Column Info */
	private String cntrTpszCd1 = null;
	/* Column Info */
	private String cntrTpszCd4 = null;
	/* Column Info */
	private String fmDur = null;
	/* Column Info */
	private String cntrTpszCd3 = null;
	/* Column Info */
	private String dgFlg = null;
	/* Column Info */
	private String psaNo = null;
	/* Column Info */
	private String salesOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvtOptionVO() {}

	public InvtOptionVO(String ibflag, String pagerows, String cntrTpszCd14, String cntrTpszCd15, String cntrTpszCd16, String cntrTpszCd17, String cntrTpszCd18, String toDur, String cntrTpszCd19, String rfTpCdReefer, String rccDate, String viewFlg, String locCd, String locBy, String polCd, String rfCntr, String rfTpCdM, String cntCd, String cntrTpszCd, String tpCd, String rfTpCdC, String cntrHngrBarAtchKnt, String cntrTpszCd11, String lstmCd, String cntrTpszCd10, String rfTpCdH, String cntrTpszCd13, String cntrTpszCd12, String cntrTpszCd27, String cntrTpszCd28, String cntrTpszCd25, String cntrTpszCd26, String cntrHngrRckCdO, String cntrTpszCd29, String toPrd, String delCd, String vvd2, String viewCustomer, String vvd3, String queryStr, String vvd1, String tsCntrBehind, String bseDt, String toBseDt, String podCd, String dispFlg, String overStayDays, String overFreeDays, String uclmLsDivCd, String lvl, String yardCd, String longStayCd, String cntrTpszCd20, String nextVvd, String fullFlg, String stayDays, String cntrTpszCd24, String cntrTpszCd23, String fmStkJbDt, String cntrHngrRckCdR, String cntrTpszCd22, String cntrTpszCd21, String cntrHngrRckCd, String headCntrTpszCd, String cntrUseCoCd, String rdCgoFlg, String routeTpCd, String dmgFlg, String locTypeCode, String opTrndTpCd, String cnmvStsCd, String fromBseDt, String objCntrTpszCd, String toStkJbDt, String cntrTpszCd30, String coCd, String fmPrd, String polPodWise, String d2PayldFlg, String rccCd, String plstFlrFlg, String cntrTpszCd6, String cntrTpszCd5, String ofcCd, String thsWk, String preBatWk, String nxtBatWk, String batWk, String batFlg, String yrwk, String wkFlg, String cntrTpszCd8, String cntrTpszCd7, String viewCommodity, String socCd, String slanCd, String cntrTpszCd9, String cntrNo, String imdtExtFlg, String cntrTpszCd2, String cntrTpszCd1, String cntrTpszCd4, String fmDur, String cntrTpszCd3, String froms, String tos, String offHireFlg, String dgFlg, String psaNo, String salesOfcCd) {
		this.toDur = toDur;
		this.viewFlg = viewFlg;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.locBy = locBy;
		this.cntCd = cntCd;
		this.cntrTpszCd = cntrTpszCd;
		this.tpCd = tpCd;
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
		this.cntrHngrRckCdO = cntrHngrRckCdO;
		this.vvd2 = vvd2;
		this.vvd3 = vvd3;
		this.viewCustomer = viewCustomer;
		this.vvd1 = vvd1;
		this.podCd = podCd;
		this.bseDt = bseDt;
		this.dispFlg = dispFlg;
		this.lvl = lvl;
		this.longStayCd = longStayCd;
		this.fullFlg = fullFlg;
		this.stayDays = stayDays;
		this.cntrHngrRckCdR = cntrHngrRckCdR;
		this.cntrUseCoCd = cntrUseCoCd;
		this.rdCgoFlg = rdCgoFlg;
		this.froms = froms;
		this.opTrndTpCd = opTrndTpCd;
		this.cnmvStsCd = cnmvStsCd;
		this.fromBseDt = fromBseDt;
		this.objCntrTpszCd = objCntrTpszCd;
		this.fmPrd = fmPrd;
		this.d2PayldFlg = d2PayldFlg;
		this.rccCd = rccCd;
		this.plstFlrFlg = plstFlrFlg;
		this.ofcCd = ofcCd;
		this.thsWk = thsWk;
		this.preBatWk = preBatWk;
		this.nxtBatWk = nxtBatWk;
		this.batWk = batWk;
		this.batFlg = batFlg;
		this.yrwk = yrwk;
		this.wkFlg = wkFlg;
		this.viewCommodity = viewCommodity;
		this.slanCd = slanCd;
		this.cntrNo = cntrNo;
		this.imdtExtFlg = imdtExtFlg;
		this.cntrTpszCd14 = cntrTpszCd14;
		this.cntrTpszCd15 = cntrTpszCd15;
		this.cntrTpszCd16 = cntrTpszCd16;
		this.cntrTpszCd17 = cntrTpszCd17;
		this.cntrTpszCd18 = cntrTpszCd18;
		this.cntrTpszCd19 = cntrTpszCd19;
		this.rfTpCdReefer = rfTpCdReefer;
		this.rccDate = rccDate;
		this.polCd = polCd;
		this.rfCntr = rfCntr;
		this.rfTpCdM = rfTpCdM;
		this.rfTpCdC = rfTpCdC;
		this.cntrTpszCd11 = cntrTpszCd11;
		this.lstmCd = lstmCd;
		this.cntrTpszCd10 = cntrTpszCd10;
		this.rfTpCdH = rfTpCdH;
		this.cntrTpszCd13 = cntrTpszCd13;
		this.cntrTpszCd12 = cntrTpszCd12;
		this.cntrTpszCd27 = cntrTpszCd27;
		this.cntrTpszCd28 = cntrTpszCd28;
		this.cntrTpszCd25 = cntrTpszCd25;
		this.cntrTpszCd26 = cntrTpszCd26;
		this.cntrTpszCd29 = cntrTpszCd29;
		this.toPrd = toPrd;
		this.delCd = delCd;
		this.queryStr = queryStr;
		this.toBseDt = toBseDt;
		this.tsCntrBehind = tsCntrBehind;
		this.overStayDays = overStayDays;
		this.uclmLsDivCd = uclmLsDivCd;
		this.yardCd = yardCd;
		this.cntrTpszCd20 = cntrTpszCd20;
		this.nextVvd = nextVvd;
		this.cntrTpszCd24 = cntrTpszCd24;
		this.cntrTpszCd23 = cntrTpszCd23;
		this.fmStkJbDt = fmStkJbDt;
		this.cntrTpszCd22 = cntrTpszCd22;
		this.cntrTpszCd21 = cntrTpszCd21;
		this.cntrHngrRckCd = cntrHngrRckCd;
		this.headCntrTpszCd = headCntrTpszCd;
		this.offHireFlg = offHireFlg;
		this.routeTpCd = routeTpCd;
		this.dmgFlg = dmgFlg;
		this.locTypeCode = locTypeCode;
		this.tos = tos;
		this.ibflag = ibflag;
		this.toStkJbDt = toStkJbDt;
		this.cntrTpszCd30 = cntrTpszCd30;
		this.coCd = coCd;
		this.overFreeDays = overFreeDays;
		this.polPodWise = polPodWise;
		this.cntrTpszCd6 = cntrTpszCd6;
		this.cntrTpszCd5 = cntrTpszCd5;
		this.cntrTpszCd8 = cntrTpszCd8;
		this.cntrTpszCd7 = cntrTpszCd7;
		this.socCd = socCd;
		this.cntrTpszCd9 = cntrTpszCd9;
		this.cntrTpszCd2 = cntrTpszCd2;
		this.cntrTpszCd1 = cntrTpszCd1;
		this.cntrTpszCd4 = cntrTpszCd4;
		this.fmDur = fmDur;
		this.cntrTpszCd3 = cntrTpszCd3;
		this.dgFlg = dgFlg;
		this.psaNo = psaNo;
		this.salesOfcCd = salesOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_dur", getToDur());
		this.hashColumns.put("view_flg", getViewFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("loc_by", getLocBy());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("tp_cd", getTpCd());
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());
		this.hashColumns.put("cntr_hngr_rck_cd_o", getCntrHngrRckCdO());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("vvd3", getVvd3());
		this.hashColumns.put("view_customer", getViewCustomer());
		this.hashColumns.put("vvd1", getVvd1());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bse_dt", getBseDt());
		this.hashColumns.put("disp_flg", getDispFlg());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("long_stay_cd", getLongStayCd());
		this.hashColumns.put("full_flg", getFullFlg());
		this.hashColumns.put("stay_days", getStayDays());
		this.hashColumns.put("cntr_hngr_rck_cd_r", getCntrHngrRckCdR());
		this.hashColumns.put("cntr_use_co_cd", getCntrUseCoCd());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("froms", getFroms());
		this.hashColumns.put("op_trnd_tp_cd", getOpTrndTpCd());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("from_bse_dt", getFromBseDt());
		this.hashColumns.put("obj_cntr_tpsz_cd", getObjCntrTpszCd());
		this.hashColumns.put("fm_prd", getFmPrd());
		this.hashColumns.put("d2_payld_flg", getD2PayldFlg());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("plst_flr_flg", getPlstFlrFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ths_wk", getThsWk());
		this.hashColumns.put("pre_bat_wk", getPreBatWk());
		this.hashColumns.put("nxt_bar_wk", getNxtBatWk());
		this.hashColumns.put("bat_wk", getBatWk());
		this.hashColumns.put("bat_flg", getBatFlg());
		this.hashColumns.put("yrwk", getYrwk());
		this.hashColumns.put("wk_flg", getWkFlg());
		this.hashColumns.put("view_commodity", getViewCommodity());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("cntr_tpsz_cd14", getCntrTpszCd14());
		this.hashColumns.put("cntr_tpsz_cd15", getCntrTpszCd15());
		this.hashColumns.put("cntr_tpsz_cd16", getCntrTpszCd16());
		this.hashColumns.put("cntr_tpsz_cd17", getCntrTpszCd17());
		this.hashColumns.put("cntr_tpsz_cd18", getCntrTpszCd18());
		this.hashColumns.put("cntr_tpsz_cd19", getCntrTpszCd19());
		this.hashColumns.put("rf_tp_cd_reefer", getRfTpCdReefer());
		this.hashColumns.put("rcc_date", getRccDate());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("rf_cntr", getRfCntr());
		this.hashColumns.put("rf_tp_cd_m", getRfTpCdM());
		this.hashColumns.put("rf_tp_cd_c", getRfTpCdC());
		this.hashColumns.put("cntr_tpsz_cd11", getCntrTpszCd11());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("cntr_tpsz_cd10", getCntrTpszCd10());
		this.hashColumns.put("rf_tp_cd_h", getRfTpCdH());
		this.hashColumns.put("cntr_tpsz_cd13", getCntrTpszCd13());
		this.hashColumns.put("cntr_tpsz_cd12", getCntrTpszCd12());
		this.hashColumns.put("cntr_tpsz_cd27", getCntrTpszCd27());
		this.hashColumns.put("cntr_tpsz_cd28", getCntrTpszCd28());
		this.hashColumns.put("cntr_tpsz_cd25", getCntrTpszCd25());
		this.hashColumns.put("cntr_tpsz_cd26", getCntrTpszCd26());
		this.hashColumns.put("cntr_tpsz_cd29", getCntrTpszCd29());
		this.hashColumns.put("to_prd", getToPrd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("query_str", getQueryStr());
		this.hashColumns.put("to_bse_dt", getToBseDt());
		this.hashColumns.put("ts_cntr_behind", getTsCntrBehind());
		this.hashColumns.put("over_stay_days", getOverStayDays());
		this.hashColumns.put("uclm_ls_div_cd", getUclmLsDivCd());
		this.hashColumns.put("yard_cd", getYardCd());
		this.hashColumns.put("cntr_tpsz_cd20", getCntrTpszCd20());
		this.hashColumns.put("next_vvd", getNextVvd());
		this.hashColumns.put("cntr_tpsz_cd24", getCntrTpszCd24());
		this.hashColumns.put("cntr_tpsz_cd23", getCntrTpszCd23());
		this.hashColumns.put("fm_stk_jb_dt", getFmStkJbDt());
		this.hashColumns.put("cntr_tpsz_cd22", getCntrTpszCd22());
		this.hashColumns.put("cntr_tpsz_cd21", getCntrTpszCd21());
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());
		this.hashColumns.put("head_cntr_tpsz_cd", getHeadCntrTpszCd());
		this.hashColumns.put("off_hire_flg", getOffHireFlg());
		this.hashColumns.put("route_tp_cd", getRouteTpCd());
		this.hashColumns.put("dmg_flg", getDmgFlg());
		this.hashColumns.put("loc_type_code", getLocTypeCode());
		this.hashColumns.put("tos", getTos());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_stk_jb_dt", getToStkJbDt());
		this.hashColumns.put("cntr_tpsz_cd30", getCntrTpszCd30());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("over_free_days", getOverFreeDays());
		this.hashColumns.put("pol_pod_wise", getPolPodWise());
		this.hashColumns.put("cntr_tpsz_cd6", getCntrTpszCd6());
		this.hashColumns.put("cntr_tpsz_cd5", getCntrTpszCd5());
		this.hashColumns.put("cntr_tpsz_cd8", getCntrTpszCd8());
		this.hashColumns.put("cntr_tpsz_cd7", getCntrTpszCd7());
		this.hashColumns.put("soc_cd", getSocCd());
		this.hashColumns.put("cntr_tpsz_cd9", getCntrTpszCd9());
		this.hashColumns.put("cntr_tpsz_cd2", getCntrTpszCd2());
		this.hashColumns.put("cntr_tpsz_cd1", getCntrTpszCd1());
		this.hashColumns.put("cntr_tpsz_cd4", getCntrTpszCd4());
		this.hashColumns.put("fm_dur", getFmDur());
		this.hashColumns.put("cntr_tpsz_cd3", getCntrTpszCd3());
		this.hashColumns.put("dg_flg", getDgFlg());
		this.hashColumns.put("psa_no", getPsaNo());
		this.hashColumns.put("sales_ofc_cd", getSalesOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_dur", "toDur");
		this.hashFields.put("view_flg", "viewFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("loc_by", "locBy");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("cntr_hngr_rck_cd_o", "cntrHngrRckCdO");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("vvd3", "vvd3");
		this.hashFields.put("view_customer", "viewCustomer");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bse_dt", "bseDt");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("long_stay_cd", "longStayCd");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("stay_days", "stayDays");
		this.hashFields.put("cntr_hngr_rck_cd_r", "cntrHngrRckCdR");
		this.hashFields.put("cntr_use_co_cd", "cntrUseCoCd");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("froms", "froms");
		this.hashFields.put("op_trnd_tp_cd", "opTrndTpCd");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("from_bse_dt", "fromBseDt");
		this.hashFields.put("obj_cntr_tpsz_cd", "objCntrTpszCd");
		this.hashFields.put("fm_prd", "fmPrd");
		this.hashFields.put("d2_payld_flg", "d2PayldFlg");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("plst_flr_flg", "plstFlrFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ths_wk", "thsWk");
		this.hashFields.put("pre_bat_wk", "preBatWk");
		this.hashFields.put("nxt_bar_wk", "nxtBatWk");
		this.hashFields.put("bat_wk", "batWk");
		this.hashFields.put("bat_flg", "batFlg");
		this.hashFields.put("yrwk", "yrwk");
		this.hashFields.put("wk_flg", "wkFlg");
		this.hashFields.put("view_commodity", "viewCommodity");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("cntr_tpsz_cd14", "cntrTpszCd14");
		this.hashFields.put("cntr_tpsz_cd15", "cntrTpszCd15");
		this.hashFields.put("cntr_tpsz_cd16", "cntrTpszCd16");
		this.hashFields.put("cntr_tpsz_cd17", "cntrTpszCd17");
		this.hashFields.put("cntr_tpsz_cd18", "cntrTpszCd18");
		this.hashFields.put("cntr_tpsz_cd19", "cntrTpszCd19");
		this.hashFields.put("rf_tp_cd_reefer", "rfTpCdReefer");
		this.hashFields.put("rcc_date", "rccDate");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rf_cntr", "rfCntr");
		this.hashFields.put("rf_tp_cd_m", "rfTpCdM");
		this.hashFields.put("rf_tp_cd_c", "rfTpCdC");
		this.hashFields.put("cntr_tpsz_cd11", "cntrTpszCd11");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("cntr_tpsz_cd10", "cntrTpszCd10");
		this.hashFields.put("rf_tp_cd_h", "rfTpCdH");
		this.hashFields.put("cntr_tpsz_cd13", "cntrTpszCd13");
		this.hashFields.put("cntr_tpsz_cd12", "cntrTpszCd12");
		this.hashFields.put("cntr_tpsz_cd27", "cntrTpszCd27");
		this.hashFields.put("cntr_tpsz_cd28", "cntrTpszCd28");
		this.hashFields.put("cntr_tpsz_cd25", "cntrTpszCd25");
		this.hashFields.put("cntr_tpsz_cd26", "cntrTpszCd26");
		this.hashFields.put("cntr_tpsz_cd29", "cntrTpszCd29");
		this.hashFields.put("to_prd", "toPrd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("query_str", "queryStr");
		this.hashFields.put("to_bse_dt", "toBseDt");
		this.hashFields.put("ts_cntr_behind", "tsCntrBehind");
		this.hashFields.put("over_stay_days", "overStayDays");
		this.hashFields.put("uclm_ls_div_cd", "uclmLsDivCd");
		this.hashFields.put("yard_cd", "yardCd");
		this.hashFields.put("cntr_tpsz_cd20", "cntrTpszCd20");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("cntr_tpsz_cd24", "cntrTpszCd24");
		this.hashFields.put("cntr_tpsz_cd23", "cntrTpszCd23");
		this.hashFields.put("fm_stk_jb_dt", "fmStkJbDt");
		this.hashFields.put("cntr_tpsz_cd22", "cntrTpszCd22");
		this.hashFields.put("cntr_tpsz_cd21", "cntrTpszCd21");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		this.hashFields.put("head_cntr_tpsz_cd", "headCntrTpszCd");
		this.hashFields.put("off_hire_flg", "offHireFlg");
		this.hashFields.put("route_tp_cd", "routeTpCd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("loc_type_code", "locTypeCode");
		this.hashFields.put("tos", "tos");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_stk_jb_dt", "toStkJbDt");
		this.hashFields.put("cntr_tpsz_cd30", "cntrTpszCd30");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("over_free_days", "overFreeDays");
		this.hashFields.put("pol_pod_wise", "polPodWise");
		this.hashFields.put("cntr_tpsz_cd6", "cntrTpszCd6");
		this.hashFields.put("cntr_tpsz_cd5", "cntrTpszCd5");
		this.hashFields.put("cntr_tpsz_cd8", "cntrTpszCd8");
		this.hashFields.put("cntr_tpsz_cd7", "cntrTpszCd7");
		this.hashFields.put("soc_cd", "socCd");
		this.hashFields.put("cntr_tpsz_cd9", "cntrTpszCd9");
		this.hashFields.put("cntr_tpsz_cd2", "cntrTpszCd2");
		this.hashFields.put("cntr_tpsz_cd1", "cntrTpszCd1");
		this.hashFields.put("cntr_tpsz_cd4", "cntrTpszCd4");
		this.hashFields.put("fm_dur", "fmDur");
		this.hashFields.put("cntr_tpsz_cd3", "cntrTpszCd3");
		this.hashFields.put("dg_flg", "dgFlg");
		this.hashFields.put("psa_no", "psaNo");
		this.hashFields.put("sales_ofc_cd", "salesOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toDur
	 */
	public String getToDur() {
		return this.toDur;
	}
	
	/**
	 * Column Info
	 * @return viewFlg
	 */
	public String getViewFlg() {
		return this.viewFlg;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return locBy
	 */
	public String getLocBy() {
		return this.locBy;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return tpCd
	 */
	public String getTpCd() {
		return this.tpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrBarAtchKnt
	 */
	public String getCntrHngrBarAtchKnt() {
		return this.cntrHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrRckCdO
	 */
	public String getCntrHngrRckCdO() {
		return this.cntrHngrRckCdO;
	}
	
	/**
	 * Column Info
	 * @return vvd2
	 */
	public String getVvd2() {
		return this.vvd2;
	}
	
	/**
	 * Column Info
	 * @return vvd3
	 */
	public String getVvd3() {
		return this.vvd3;
	}
	
	/**
	 * Column Info
	 * @return viewCustomer
	 */
	public String getViewCustomer() {
		return this.viewCustomer;
	}
	
	/**
	 * Column Info
	 * @return vvd1
	 */
	public String getVvd1() {
		return this.vvd1;
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
	 * @return bseDt
	 */
	public String getBseDt() {
		return this.bseDt;
	}
	
	/**
	 * Column Info
	 * @return dispFlg
	 */
	public String getDispFlg() {
		return this.dispFlg;
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
	 * @return longStayCd
	 */
	public String getLongStayCd() {
		return this.longStayCd;
	}
	
	/**
	 * Column Info
	 * @return fullFlg
	 */
	public String getFullFlg() {
		return this.fullFlg;
	}
	
	/**
	 * Column Info
	 * @return stayDays
	 */
	public String getStayDays() {
		return this.stayDays;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrRckCdR
	 */
	public String getCntrHngrRckCdR() {
		return this.cntrHngrRckCdR;
	}
	
	/**
	 * Column Info
	 * @return cntrUseCoCd
	 */
	public String getCntrUseCoCd() {
		return this.cntrUseCoCd;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return froms
	 */
	public String getFroms() {
		return this.froms;
	}
	
	/**
	 * Column Info
	 * @return opTrndTpCd
	 */
	public String getOpTrndTpCd() {
		return this.opTrndTpCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return fromBseDt
	 */
	public String getFromBseDt() {
		return this.fromBseDt;
	}
	
	/**
	 * Column Info
	 * @return objCntrTpszCd
	 */
	public String getObjCntrTpszCd() {
		return this.objCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return fmPrd
	 */
	public String getFmPrd() {
		return this.fmPrd;
	}
	
	/**
	 * Column Info
	 * @return d2PayldFlg
	 */
	public String getD2PayldFlg() {
		return this.d2PayldFlg;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return plstFlrFlg
	 */
	public String getPlstFlrFlg() {
		return this.plstFlrFlg;
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
	 * @return thsWk
	 */
	public String getThsWk() {
		return this.thsWk;
	}
	
	/**
	 * Column Info
	 * @return preBatWk
	 */
	public String getPreBatWk() {
		return this.preBatWk;
	}
	
	/**
	 * Column Info
	 * @return nxtBatWk
	 */
	public String getNxtBatWk() {
		return this.nxtBatWk;
	}
	
	/**
	 * Column Info
	 * @return batWk
	 */
	public String getBatWk() {
		return this.batWk;
	}
	
	/**
	 * Column Info
	 * @return batFlg
	 */
	public String getBatFlg() {
		return this.batFlg;
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
	 * @return wkFlg
	 */
	public String getWkFlg() {
		return this.wkFlg;
	}	
	
	/**
	 * Column Info
	 * @return viewCommodity
	 */
	public String getViewCommodity() {
		return this.viewCommodity;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd14
	 */
	public String getCntrTpszCd14() {
		return this.cntrTpszCd14;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd15
	 */
	public String getCntrTpszCd15() {
		return this.cntrTpszCd15;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd16
	 */
	public String getCntrTpszCd16() {
		return this.cntrTpszCd16;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd17
	 */
	public String getCntrTpszCd17() {
		return this.cntrTpszCd17;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd18
	 */
	public String getCntrTpszCd18() {
		return this.cntrTpszCd18;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd19
	 */
	public String getCntrTpszCd19() {
		return this.cntrTpszCd19;
	}
	
	/**
	 * Column Info
	 * @return rfTpCdReefer
	 */
	public String getRfTpCdReefer() {
		return this.rfTpCdReefer;
	}
	
	/**
	 * Column Info
	 * @return rccDate
	 */
	public String getRccDate() {
		return this.rccDate;
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
	 * @return rfCntr
	 */
	public String getRfCntr() {
		return this.rfCntr;
	}
	
	/**
	 * Column Info
	 * @return rfTpCdM
	 */
	public String getRfTpCdM() {
		return this.rfTpCdM;
	}
	
	/**
	 * Column Info
	 * @return rfTpCdC
	 */
	public String getRfTpCdC() {
		return this.rfTpCdC;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd11
	 */
	public String getCntrTpszCd11() {
		return this.cntrTpszCd11;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd10
	 */
	public String getCntrTpszCd10() {
		return this.cntrTpszCd10;
	}
	
	/**
	 * Column Info
	 * @return rfTpCdH
	 */
	public String getRfTpCdH() {
		return this.rfTpCdH;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd13
	 */
	public String getCntrTpszCd13() {
		return this.cntrTpszCd13;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd12
	 */
	public String getCntrTpszCd12() {
		return this.cntrTpszCd12;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd27
	 */
	public String getCntrTpszCd27() {
		return this.cntrTpszCd27;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd28
	 */
	public String getCntrTpszCd28() {
		return this.cntrTpszCd28;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd25
	 */
	public String getCntrTpszCd25() {
		return this.cntrTpszCd25;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd26
	 */
	public String getCntrTpszCd26() {
		return this.cntrTpszCd26;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd29
	 */
	public String getCntrTpszCd29() {
		return this.cntrTpszCd29;
	}
	
	/**
	 * Column Info
	 * @return toPrd
	 */
	public String getToPrd() {
		return this.toPrd;
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
	 * @return queryStr
	 */
	public String getQueryStr() {
		return this.queryStr;
	}
	
	/**
	 * Column Info
	 * @return toBseDt
	 */
	public String getToBseDt() {
		return this.toBseDt;
	}
	
	/**
	 * Column Info
	 * @return tsCntrBehind
	 */
	public String getTsCntrBehind() {
		return this.tsCntrBehind;
	}
	
	/**
	 * Column Info
	 * @return overStayDays
	 */
	public String getOverStayDays() {
		return this.overStayDays;
	}
	
	/**
	 * Column Info
	 * @return uclmLsDivCd
	 */
	public String getUclmLsDivCd() {
		return this.uclmLsDivCd;
	}
	
	/**
	 * Column Info
	 * @return yardCd
	 */
	public String getYardCd() {
		return this.yardCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd20
	 */
	public String getCntrTpszCd20() {
		return this.cntrTpszCd20;
	}
	
	/**
	 * Column Info
	 * @return nextVvd
	 */
	public String getNextVvd() {
		return this.nextVvd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd24
	 */
	public String getCntrTpszCd24() {
		return this.cntrTpszCd24;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd23
	 */
	public String getCntrTpszCd23() {
		return this.cntrTpszCd23;
	}
	
	/**
	 * Column Info
	 * @return fmStkJbDt
	 */
	public String getFmStkJbDt() {
		return this.fmStkJbDt;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd22
	 */
	public String getCntrTpszCd22() {
		return this.cntrTpszCd22;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd21
	 */
	public String getCntrTpszCd21() {
		return this.cntrTpszCd21;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrRckCd
	 */
	public String getCntrHngrRckCd() {
		return this.cntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @return headCntrTpszCd
	 */
	public String getHeadCntrTpszCd() {
		return this.headCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return offHireFlg
	 */
	public String getOffHireFlg() {
		return this.offHireFlg;
	}
	
	/**
	 * Column Info
	 * @return routeTpCd
	 */
	public String getRouteTpCd() {
		return this.routeTpCd;
	}
	
	/**
	 * Column Info
	 * @return dmgFlg
	 */
	public String getDmgFlg() {
		return this.dmgFlg;
	}
	
	/**
	 * Column Info
	 * @return locTypeCode
	 */
	public String getLocTypeCode() {
		return this.locTypeCode;
	}
	
	/**
	 * Column Info
	 * @return tos
	 */
	public String getTos() {
		return this.tos;
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
	 * @return toStkJbDt
	 */
	public String getToStkJbDt() {
		return this.toStkJbDt;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd30
	 */
	public String getCntrTpszCd30() {
		return this.cntrTpszCd30;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return overFreeDays
	 */
	public String getOverFreeDays() {
		return this.overFreeDays;
	}
	
	/**
	 * Column Info
	 * @return polPodWise
	 */
	public String getPolPodWise() {
		return this.polPodWise;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd6
	 */
	public String getCntrTpszCd6() {
		return this.cntrTpszCd6;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd5
	 */
	public String getCntrTpszCd5() {
		return this.cntrTpszCd5;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd8
	 */
	public String getCntrTpszCd8() {
		return this.cntrTpszCd8;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd7
	 */
	public String getCntrTpszCd7() {
		return this.cntrTpszCd7;
	}
	
	/**
	 * Column Info
	 * @return socCd
	 */
	public String getSocCd() {
		return this.socCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd9
	 */
	public String getCntrTpszCd9() {
		return this.cntrTpszCd9;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd2
	 */
	public String getCntrTpszCd2() {
		return this.cntrTpszCd2;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd1
	 */
	public String getCntrTpszCd1() {
		return this.cntrTpszCd1;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd4
	 */
	public String getCntrTpszCd4() {
		return this.cntrTpszCd4;
	}
	
	/**
	 * Column Info
	 * @return fmDur
	 */
	public String getFmDur() {
		return this.fmDur;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd3
	 */
	public String getCntrTpszCd3() {
		return this.cntrTpszCd3;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd3
	 */
	public String getDgFlg() {
		return this.dgFlg;
	}
	
	/**
	 * Column Info
	 * @return psaNo
	 */
	public String getPsaNo() {
		return this.psaNo;
	}	
	
	/**
	 * Column Info
	 * @return salesOfcCd
	 */
	public String getSalesOfcCd() {
		return this.salesOfcCd;
	}	
	
	
	/**
	 * Column Info
	 * @param toDur
	 */
	public void setToDur(String toDur) {
		this.toDur = toDur;
	}
	
	/**
	 * Column Info
	 * @param viewFlg
	 */
	public void setViewFlg(String viewFlg) {
		this.viewFlg = viewFlg;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param locBy
	 */
	public void setLocBy(String locBy) {
		this.locBy = locBy;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param tpCd
	 */
	public void setTpCd(String tpCd) {
		this.tpCd = tpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrBarAtchKnt
	 */
	public void setCntrHngrBarAtchKnt(String cntrHngrBarAtchKnt) {
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrRckCdO
	 */
	public void setCntrHngrRckCdO(String cntrHngrRckCdO) {
		this.cntrHngrRckCdO = cntrHngrRckCdO;
	}
	
	/**
	 * Column Info
	 * @param vvd2
	 */
	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
	}
	
	/**
	 * Column Info
	 * @param vvd3
	 */
	public void setVvd3(String vvd3) {
		this.vvd3 = vvd3;
	}
	
	/**
	 * Column Info
	 * @param viewCustomer
	 */
	public void setViewCustomer(String viewCustomer) {
		this.viewCustomer = viewCustomer;
	}
	
	/**
	 * Column Info
	 * @param vvd1
	 */
	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
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
	 * @param bseDt
	 */
	public void setBseDt(String bseDt) {
		this.bseDt = bseDt;
	}
	
	/**
	 * Column Info
	 * @param dispFlg
	 */
	public void setDispFlg(String dispFlg) {
		this.dispFlg = dispFlg;
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
	 * @param longStayCd
	 */
	public void setLongStayCd(String longStayCd) {
		this.longStayCd = longStayCd;
	}
	
	/**
	 * Column Info
	 * @param fullFlg
	 */
	public void setFullFlg(String fullFlg) {
		this.fullFlg = fullFlg;
	}
	
	/**
	 * Column Info
	 * @param stayDays
	 */
	public void setStayDays(String stayDays) {
		this.stayDays = stayDays;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrRckCdR
	 */
	public void setCntrHngrRckCdR(String cntrHngrRckCdR) {
		this.cntrHngrRckCdR = cntrHngrRckCdR;
	}
	
	/**
	 * Column Info
	 * @param cntrUseCoCd
	 */
	public void setCntrUseCoCd(String cntrUseCoCd) {
		this.cntrUseCoCd = cntrUseCoCd;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param froms
	 */
	public void setFroms(String froms) {
		this.froms = froms;
	}
	
	/**
	 * Column Info
	 * @param opTrndTpCd
	 */
	public void setOpTrndTpCd(String opTrndTpCd) {
		this.opTrndTpCd = opTrndTpCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param fromBseDt
	 */
	public void setFromBseDt(String fromBseDt) {
		this.fromBseDt = fromBseDt;
	}
	
	/**
	 * Column Info
	 * @param objCntrTpszCd
	 */
	public void setObjCntrTpszCd(String objCntrTpszCd) {
		this.objCntrTpszCd = objCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param fmPrd
	 */
	public void setFmPrd(String fmPrd) {
		this.fmPrd = fmPrd;
	}
	
	/**
	 * Column Info
	 * @param d2PayldFlg
	 */
	public void setD2PayldFlg(String d2PayldFlg) {
		this.d2PayldFlg = d2PayldFlg;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param plstFlrFlg
	 */
	public void setPlstFlrFlg(String plstFlrFlg) {
		this.plstFlrFlg = plstFlrFlg;
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
	 * @param thsWk
	 */
	public void setThsWk(String thsWk) {
		this.thsWk = thsWk;
	}
	
	/**
	 * Column Info
	 * @param preBatWk
	 */
	public void setPreBatWk(String preBatWk) {
		this.preBatWk = preBatWk;
	}
	
	/**
	 * Column Info
	 * @param nxtBatWk
	 */
	public void setNxtBatWk(String nxtBatWk) {
		this.nxtBatWk = nxtBatWk;
	}
	
	/**
	 * Column Info
	 * @param batWk
	 */
	public void setBatWk(String batWk) {
		this.batWk = batWk;
	}
	
	/**
	 * Column Info
	 * @param batFlg
	 */
	public void setBatFlg(String batFlg) {
		this.batFlg = batFlg;
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
	 * @param wkFlg
	 */
	public void setWkFlg(String wkFlg) {
		this.wkFlg = wkFlg;
	}	
	
	/**
	 * Column Info
	 * @param viewCommodity
	 */
	public void setViewCommodity(String viewCommodity) {
		this.viewCommodity = viewCommodity;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd14
	 */
	public void setCntrTpszCd14(String cntrTpszCd14) {
		this.cntrTpszCd14 = cntrTpszCd14;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd15
	 */
	public void setCntrTpszCd15(String cntrTpszCd15) {
		this.cntrTpszCd15 = cntrTpszCd15;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd16
	 */
	public void setCntrTpszCd16(String cntrTpszCd16) {
		this.cntrTpszCd16 = cntrTpszCd16;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd17
	 */
	public void setCntrTpszCd17(String cntrTpszCd17) {
		this.cntrTpszCd17 = cntrTpszCd17;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd18
	 */
	public void setCntrTpszCd18(String cntrTpszCd18) {
		this.cntrTpszCd18 = cntrTpszCd18;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd19
	 */
	public void setCntrTpszCd19(String cntrTpszCd19) {
		this.cntrTpszCd19 = cntrTpszCd19;
	}
	
	/**
	 * Column Info
	 * @param rfTpCdReefer
	 */
	public void setRfTpCdReefer(String rfTpCdReefer) {
		this.rfTpCdReefer = rfTpCdReefer;
	}
	
	/**
	 * Column Info
	 * @param rccDate
	 */
	public void setRccDate(String rccDate) {
		this.rccDate = rccDate;
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
	 * @param rfCntr
	 */
	public void setRfCntr(String rfCntr) {
		this.rfCntr = rfCntr;
	}
	
	/**
	 * Column Info
	 * @param rfTpCdM
	 */
	public void setRfTpCdM(String rfTpCdM) {
		this.rfTpCdM = rfTpCdM;
	}
	
	/**
	 * Column Info
	 * @param rfTpCdC
	 */
	public void setRfTpCdC(String rfTpCdC) {
		this.rfTpCdC = rfTpCdC;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd11
	 */
	public void setCntrTpszCd11(String cntrTpszCd11) {
		this.cntrTpszCd11 = cntrTpszCd11;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd10
	 */
	public void setCntrTpszCd10(String cntrTpszCd10) {
		this.cntrTpszCd10 = cntrTpszCd10;
	}
	
	/**
	 * Column Info
	 * @param rfTpCdH
	 */
	public void setRfTpCdH(String rfTpCdH) {
		this.rfTpCdH = rfTpCdH;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd13
	 */
	public void setCntrTpszCd13(String cntrTpszCd13) {
		this.cntrTpszCd13 = cntrTpszCd13;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd12
	 */
	public void setCntrTpszCd12(String cntrTpszCd12) {
		this.cntrTpszCd12 = cntrTpszCd12;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd27
	 */
	public void setCntrTpszCd27(String cntrTpszCd27) {
		this.cntrTpszCd27 = cntrTpszCd27;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd28
	 */
	public void setCntrTpszCd28(String cntrTpszCd28) {
		this.cntrTpszCd28 = cntrTpszCd28;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd25
	 */
	public void setCntrTpszCd25(String cntrTpszCd25) {
		this.cntrTpszCd25 = cntrTpszCd25;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd26
	 */
	public void setCntrTpszCd26(String cntrTpszCd26) {
		this.cntrTpszCd26 = cntrTpszCd26;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd29
	 */
	public void setCntrTpszCd29(String cntrTpszCd29) {
		this.cntrTpszCd29 = cntrTpszCd29;
	}
	
	/**
	 * Column Info
	 * @param toPrd
	 */
	public void setToPrd(String toPrd) {
		this.toPrd = toPrd;
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
	 * @param queryStr
	 */
	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}
	
	/**
	 * Column Info
	 * @param toBseDt
	 */
	public void setToBseDt(String toBseDt) {
		this.toBseDt = toBseDt;
	}
	
	/**
	 * Column Info
	 * @param tsCntrBehind
	 */
	public void setTsCntrBehind(String tsCntrBehind) {
		this.tsCntrBehind = tsCntrBehind;
	}
	
	/**
	 * Column Info
	 * @param overStayDays
	 */
	public void setOverStayDays(String overStayDays) {
		this.overStayDays = overStayDays;
	}
	
	/**
	 * Column Info
	 * @param uclmLsDivCd
	 */
	public void setUclmLsDivCd(String uclmLsDivCd) {
		this.uclmLsDivCd = uclmLsDivCd;
	}
	
	/**
	 * Column Info
	 * @param yardCd
	 */
	public void setYardCd(String yardCd) {
		this.yardCd = yardCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd20
	 */
	public void setCntrTpszCd20(String cntrTpszCd20) {
		this.cntrTpszCd20 = cntrTpszCd20;
	}
	
	/**
	 * Column Info
	 * @param nextVvd
	 */
	public void setNextVvd(String nextVvd) {
		this.nextVvd = nextVvd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd24
	 */
	public void setCntrTpszCd24(String cntrTpszCd24) {
		this.cntrTpszCd24 = cntrTpszCd24;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd23
	 */
	public void setCntrTpszCd23(String cntrTpszCd23) {
		this.cntrTpszCd23 = cntrTpszCd23;
	}
	
	/**
	 * Column Info
	 * @param fmStkJbDt
	 */
	public void setFmStkJbDt(String fmStkJbDt) {
		this.fmStkJbDt = fmStkJbDt;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd22
	 */
	public void setCntrTpszCd22(String cntrTpszCd22) {
		this.cntrTpszCd22 = cntrTpszCd22;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd21
	 */
	public void setCntrTpszCd21(String cntrTpszCd21) {
		this.cntrTpszCd21 = cntrTpszCd21;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrRckCd
	 */
	public void setCntrHngrRckCd(String cntrHngrRckCd) {
		this.cntrHngrRckCd = cntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @param headCntrTpszCd
	 */
	public void setHeadCntrTpszCd(String headCntrTpszCd) {
		this.headCntrTpszCd = headCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param offHireFlg
	 */
	public void setOffHireFlg(String offHireFlg) {
		this.offHireFlg = offHireFlg;
	}
	
	/**
	 * Column Info
	 * @param routeTpCd
	 */
	public void setRouteTpCd(String routeTpCd) {
		this.routeTpCd = routeTpCd;
	}
	
	/**
	 * Column Info
	 * @param dmgFlg
	 */
	public void setDmgFlg(String dmgFlg) {
		this.dmgFlg = dmgFlg;
	}
	
	/**
	 * Column Info
	 * @param locTypeCode
	 */
	public void setLocTypeCode(String locTypeCode) {
		this.locTypeCode = locTypeCode;
	}
	
	/**
	 * Column Info
	 * @param tos
	 */
	public void setTos(String tos) {
		this.tos = tos;
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
	 * @param toStkJbDt
	 */
	public void setToStkJbDt(String toStkJbDt) {
		this.toStkJbDt = toStkJbDt;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd30
	 */
	public void setCntrTpszCd30(String cntrTpszCd30) {
		this.cntrTpszCd30 = cntrTpszCd30;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param overFreeDays
	 */
	public void setOverFreeDays(String overFreeDays) {
		this.overFreeDays = overFreeDays;
	}
	
	/**
	 * Column Info
	 * @param polPodWise
	 */
	public void setPolPodWise(String polPodWise) {
		this.polPodWise = polPodWise;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd6
	 */
	public void setCntrTpszCd6(String cntrTpszCd6) {
		this.cntrTpszCd6 = cntrTpszCd6;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd5
	 */
	public void setCntrTpszCd5(String cntrTpszCd5) {
		this.cntrTpszCd5 = cntrTpszCd5;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd8
	 */
	public void setCntrTpszCd8(String cntrTpszCd8) {
		this.cntrTpszCd8 = cntrTpszCd8;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd7
	 */
	public void setCntrTpszCd7(String cntrTpszCd7) {
		this.cntrTpszCd7 = cntrTpszCd7;
	}
	
	/**
	 * Column Info
	 * @param socCd
	 */
	public void setSocCd(String socCd) {
		this.socCd = socCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd9
	 */
	public void setCntrTpszCd9(String cntrTpszCd9) {
		this.cntrTpszCd9 = cntrTpszCd9;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd2
	 */
	public void setCntrTpszCd2(String cntrTpszCd2) {
		this.cntrTpszCd2 = cntrTpszCd2;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd1
	 */
	public void setCntrTpszCd1(String cntrTpszCd1) {
		this.cntrTpszCd1 = cntrTpszCd1;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd4
	 */
	public void setCntrTpszCd4(String cntrTpszCd4) {
		this.cntrTpszCd4 = cntrTpszCd4;
	}
	
	/**
	 * Column Info
	 * @param fmDur
	 */
	public void setFmDur(String fmDur) {
		this.fmDur = fmDur;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd3
	 */
	public void setCntrTpszCd3(String cntrTpszCd3) {
		this.cntrTpszCd3 = cntrTpszCd3;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd3
	 */
	public void setDgFlg(String dgFlg) {
		this.dgFlg = dgFlg;
	}
	
	/**
	 * Column Info
	 * @param psaNo
	 */
	public void setPsaNo(String psaNo) {
		this.psaNo = psaNo;
	}	
	
	/**
	 * Column Info
	 * @param salesOfcCd
	 */
	public void setSalesOfcCd(String salesOfcCd) {
		this.salesOfcCd = salesOfcCd;
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
		setToDur(JSPUtil.getParameter(request, prefix + "to_dur", ""));
		setViewFlg(JSPUtil.getParameter(request, prefix + "view_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setLocBy(JSPUtil.getParameter(request, prefix + "loc_by", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setTpCd(JSPUtil.getParameter(request, prefix + "tp_cd", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request, prefix + "cntr_hngr_bar_atch_knt", ""));
		setCntrHngrRckCdO(JSPUtil.getParameter(request, prefix + "cntr_hngr_rck_cd_o", ""));
		setVvd2(JSPUtil.getParameter(request, prefix + "vvd2", ""));
		setVvd3(JSPUtil.getParameter(request, prefix + "vvd3", ""));
		setViewCustomer(JSPUtil.getParameter(request, prefix + "view_customer", ""));
		setVvd1(JSPUtil.getParameter(request, prefix + "vvd1", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBseDt(JSPUtil.getParameter(request, prefix + "bse_dt", ""));
		setDispFlg(JSPUtil.getParameter(request, prefix + "disp_flg", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setLongStayCd(JSPUtil.getParameter(request, prefix + "long_stay_cd", ""));
		setFullFlg(JSPUtil.getParameter(request, prefix + "full_flg", ""));
		setStayDays(JSPUtil.getParameter(request, prefix + "stay_days", ""));
		setCntrHngrRckCdR(JSPUtil.getParameter(request, prefix + "cntr_hngr_rck_cd_r", ""));
		setCntrUseCoCd(JSPUtil.getParameter(request, prefix + "cntr_use_co_cd", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setFroms(JSPUtil.getParameter(request, prefix + "froms", ""));
		setOpTrndTpCd(JSPUtil.getParameter(request, prefix + "op_trnd_tp_cd", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setFromBseDt(JSPUtil.getParameter(request, prefix + "from_bse_dt", ""));
		setObjCntrTpszCd(JSPUtil.getParameter(request, prefix + "obj_cntr_tpsz_cd", ""));
		setFmPrd(JSPUtil.getParameter(request, prefix + "fm_prd", ""));
		setD2PayldFlg(JSPUtil.getParameter(request, prefix + "d2_payld_flg", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setPlstFlrFlg(JSPUtil.getParameter(request, prefix + "plst_flr_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setThsWk(JSPUtil.getParameter(request, prefix + "ths_wk", ""));
		setPreBatWk(JSPUtil.getParameter(request, prefix + "pre_bat_wk", ""));
		setNxtBatWk(JSPUtil.getParameter(request, prefix + "nxt_bar_wk", ""));
		setBatWk(JSPUtil.getParameter(request, prefix + "bat_wk", ""));
		setBatFlg(JSPUtil.getParameter(request, prefix + "bat_flg", ""));
		setYrwk(JSPUtil.getParameter(request, prefix + "yrwk", ""));
		setWkFlg(JSPUtil.getParameter(request, prefix + "wk_flg", ""));
		setViewCommodity(JSPUtil.getParameter(request, prefix + "view_commodity", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, prefix + "imdt_ext_flg", ""));
		setCntrTpszCd14(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd14", ""));
		setCntrTpszCd15(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd15", ""));
		setCntrTpszCd16(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd16", ""));
		setCntrTpszCd17(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd17", ""));
		setCntrTpszCd18(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd18", ""));
		setCntrTpszCd19(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd19", ""));
		setRfTpCdReefer(JSPUtil.getParameter(request, prefix + "rf_tp_cd_reefer", ""));
		setRccDate(JSPUtil.getParameter(request, prefix + "rcc_date", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setRfCntr(JSPUtil.getParameter(request, prefix + "rf_cntr", ""));
		setRfTpCdM(JSPUtil.getParameter(request, prefix + "rf_tp_cd_m", ""));
		setRfTpCdC(JSPUtil.getParameter(request, prefix + "rf_tp_cd_c", ""));
		setCntrTpszCd11(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd11", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setCntrTpszCd10(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd10", ""));
		setRfTpCdH(JSPUtil.getParameter(request, prefix + "rf_tp_cd_h", ""));
		setCntrTpszCd13(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd13", ""));
		setCntrTpszCd12(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd12", ""));
		setCntrTpszCd27(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd27", ""));
		setCntrTpszCd28(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd28", ""));
		setCntrTpszCd25(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd25", ""));
		setCntrTpszCd26(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd26", ""));
		setCntrTpszCd29(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd29", ""));
		setToPrd(JSPUtil.getParameter(request, prefix + "to_prd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setQueryStr(JSPUtil.getParameter(request, prefix + "query_str", ""));
		setToBseDt(JSPUtil.getParameter(request, prefix + "to_bse_dt", ""));
		setTsCntrBehind(JSPUtil.getParameter(request, prefix + "ts_cntr_behind", ""));
		setOverStayDays(JSPUtil.getParameter(request, prefix + "over_stay_days", ""));
		setUclmLsDivCd(JSPUtil.getParameter(request, prefix + "uclm_ls_div_cd", ""));
		setYardCd(JSPUtil.getParameter(request, prefix + "yard_cd", ""));
		setCntrTpszCd20(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd20", ""));
		setNextVvd(JSPUtil.getParameter(request, prefix + "next_vvd", ""));
		setCntrTpszCd24(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd24", ""));
		setCntrTpszCd23(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd23", ""));
		setFmStkJbDt(JSPUtil.getParameter(request, prefix + "fm_stk_jb_dt", ""));
		setCntrTpszCd22(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd22", ""));
		setCntrTpszCd21(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd21", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request, prefix + "cntr_hngr_rck_cd", ""));
		setHeadCntrTpszCd(JSPUtil.getParameter(request, prefix + "head_cntr_tpsz_cd", ""));
		setOffHireFlg(JSPUtil.getParameter(request, prefix + "off_hire_flg", ""));
		setRouteTpCd(JSPUtil.getParameter(request, prefix + "route_tp_cd", ""));
		setDmgFlg(JSPUtil.getParameter(request, prefix + "dmg_flg", ""));
		setLocTypeCode(JSPUtil.getParameter(request, prefix + "loc_type_code", ""));
		setTos(JSPUtil.getParameter(request, prefix + "tos", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setToStkJbDt(JSPUtil.getParameter(request, prefix + "to_stk_jb_dt", ""));
		setCntrTpszCd30(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd30", ""));
		setCoCd(JSPUtil.getParameter(request, prefix + "co_cd", ""));
		setOverFreeDays(JSPUtil.getParameter(request, prefix + "over_free_days", ""));
		setPolPodWise(JSPUtil.getParameter(request, prefix + "pol_pod_wise", ""));
		setCntrTpszCd6(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd6", ""));
		setCntrTpszCd5(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd5", ""));
		setCntrTpszCd8(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd8", ""));
		setCntrTpszCd7(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd7", ""));
		setSocCd(JSPUtil.getParameter(request, prefix + "soc_cd", ""));
		setCntrTpszCd9(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd9", ""));
		setCntrTpszCd2(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd2", ""));
		setCntrTpszCd1(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd1", ""));
		setCntrTpszCd4(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd4", ""));
		setFmDur(JSPUtil.getParameter(request, prefix + "fm_dur", ""));
		setCntrTpszCd3(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd3", ""));
		setDgFlg(JSPUtil.getParameter(request, prefix + "dg_flg", ""));
		setPsaNo(JSPUtil.getParameter(request, prefix + "psa_no", ""));
		setSalesOfcCd(JSPUtil.getParameter(request, prefix + "sales_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvtOptionVO[]
	 */
	public InvtOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvtOptionVO[]
	 */
	public InvtOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvtOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toDur = (JSPUtil.getParameter(request, prefix	+ "to_dur", length));
			String[] viewFlg = (JSPUtil.getParameter(request, prefix	+ "view_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] locBy = (JSPUtil.getParameter(request, prefix	+ "loc_by", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] tpCd = (JSPUtil.getParameter(request, prefix	+ "tp_cd", length));
			String[] cntrHngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_bar_atch_knt", length));
			String[] cntrHngrRckCdO = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd_o", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));
			String[] vvd3 = (JSPUtil.getParameter(request, prefix	+ "vvd3", length));
			String[] viewCustomer = (JSPUtil.getParameter(request, prefix	+ "view_customer", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd1", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bseDt = (JSPUtil.getParameter(request, prefix	+ "bse_dt", length));
			String[] dispFlg = (JSPUtil.getParameter(request, prefix	+ "disp_flg", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] longStayCd = (JSPUtil.getParameter(request, prefix	+ "long_stay_cd", length));
			String[] fullFlg = (JSPUtil.getParameter(request, prefix	+ "full_flg", length));
			String[] stayDays = (JSPUtil.getParameter(request, prefix	+ "stay_days", length));
			String[] cntrHngrRckCdR = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd_r", length));
			String[] cntrUseCoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_use_co_cd", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] froms = (JSPUtil.getParameter(request, prefix	+ "froms", length));
			String[] opTrndTpCd = (JSPUtil.getParameter(request, prefix	+ "op_trnd_tp_cd", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] fromBseDt = (JSPUtil.getParameter(request, prefix	+ "from_bse_dt", length));
			String[] objCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "obj_cntr_tpsz_cd", length));
			String[] fmPrd = (JSPUtil.getParameter(request, prefix	+ "fm_prd", length));
			String[] d2PayldFlg = (JSPUtil.getParameter(request, prefix	+ "d2_payld_flg", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] plstFlrFlg = (JSPUtil.getParameter(request, prefix	+ "plst_flr_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] thsWk = (JSPUtil.getParameter(request, prefix	+ "ths_wk", length));
			String[] preBatWk = (JSPUtil.getParameter(request, prefix	+ "pre_bat_wk", length));
			String[] nxtBatWk = (JSPUtil.getParameter(request, prefix	+ "nxt_bar_wk", length));
			String[] batWk = (JSPUtil.getParameter(request, prefix	+ "bat_wk", length));
			String[] batFlg = (JSPUtil.getParameter(request, prefix	+ "bat_flg", length));
			String[] yrwk = (JSPUtil.getParameter(request, prefix	+ "yrwk", length));
			String[] wkFlg = (JSPUtil.getParameter(request, prefix	+ "wk_flg", length));
			String[] viewCommodity = (JSPUtil.getParameter(request, prefix	+ "view_commodity", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] cntrTpszCd14 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd14", length));
			String[] cntrTpszCd15 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd15", length));
			String[] cntrTpszCd16 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd16", length));
			String[] cntrTpszCd17 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd17", length));
			String[] cntrTpszCd18 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd18", length));
			String[] cntrTpszCd19 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd19", length));
			String[] rfTpCdReefer = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd_reefer", length));
			String[] rccDate = (JSPUtil.getParameter(request, prefix	+ "rcc_date", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] rfCntr = (JSPUtil.getParameter(request, prefix	+ "rf_cntr", length));
			String[] rfTpCdM = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd_m", length));
			String[] rfTpCdC = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd_c", length));
			String[] cntrTpszCd11 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd11", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] cntrTpszCd10 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd10", length));
			String[] rfTpCdH = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd_h", length));
			String[] cntrTpszCd13 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd13", length));
			String[] cntrTpszCd12 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd12", length));
			String[] cntrTpszCd27 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd27", length));
			String[] cntrTpszCd28 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd28", length));
			String[] cntrTpszCd25 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd25", length));
			String[] cntrTpszCd26 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd26", length));
			String[] cntrTpszCd29 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd29", length));
			String[] toPrd = (JSPUtil.getParameter(request, prefix	+ "to_prd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] queryStr = (JSPUtil.getParameter(request, prefix	+ "query_str", length));
			String[] toBseDt = (JSPUtil.getParameter(request, prefix	+ "to_bse_dt", length));
			String[] tsCntrBehind = (JSPUtil.getParameter(request, prefix	+ "ts_cntr_behind", length));
			String[] overStayDays = (JSPUtil.getParameter(request, prefix	+ "over_stay_days", length));
			String[] uclmLsDivCd = (JSPUtil.getParameter(request, prefix	+ "uclm_ls_div_cd", length));
			String[] yardCd = (JSPUtil.getParameter(request, prefix	+ "yard_cd", length));
			String[] cntrTpszCd20 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd20", length));
			String[] nextVvd = (JSPUtil.getParameter(request, prefix	+ "next_vvd", length));
			String[] cntrTpszCd24 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd24", length));
			String[] cntrTpszCd23 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd23", length));
			String[] fmStkJbDt = (JSPUtil.getParameter(request, prefix	+ "fm_stk_jb_dt", length));
			String[] cntrTpszCd22 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd22", length));
			String[] cntrTpszCd21 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd21", length));
			String[] cntrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd", length));
			String[] headCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "head_cntr_tpsz_cd", length));
			String[] offHireFlg = (JSPUtil.getParameter(request, prefix	+ "off_hire_flg", length));
			String[] routeTpCd = (JSPUtil.getParameter(request, prefix	+ "route_tp_cd", length));
			String[] dmgFlg = (JSPUtil.getParameter(request, prefix	+ "dmg_flg", length));
			String[] locTypeCode = (JSPUtil.getParameter(request, prefix	+ "loc_type_code", length));
			String[] tos = (JSPUtil.getParameter(request, prefix	+ "tos", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toStkJbDt = (JSPUtil.getParameter(request, prefix	+ "to_stk_jb_dt", length));
			String[] cntrTpszCd30 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd30", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] overFreeDays = (JSPUtil.getParameter(request, prefix	+ "over_free_days", length));
			String[] polPodWise = (JSPUtil.getParameter(request, prefix	+ "pol_pod_wise", length));
			String[] cntrTpszCd6 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd6", length));
			String[] cntrTpszCd5 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd5", length));
			String[] cntrTpszCd8 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd8", length));
			String[] cntrTpszCd7 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd7", length));
			String[] socCd = (JSPUtil.getParameter(request, prefix	+ "soc_cd", length));
			String[] cntrTpszCd9 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd9", length));
			String[] cntrTpszCd2 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd2", length));
			String[] cntrTpszCd1 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd1", length));
			String[] cntrTpszCd4 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd4", length));
			String[] fmDur = (JSPUtil.getParameter(request, prefix	+ "fm_dur", length));
			String[] cntrTpszCd3 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd3", length));
			String[] dgFlg = (JSPUtil.getParameter(request, prefix	+ "dg_flg", length));
			String[] psaNo = (JSPUtil.getParameter(request, prefix	+ "psa_no", length));
			String[] salesOfcCd = (JSPUtil.getParameter(request, prefix	+ "sales_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvtOptionVO();
				if (toDur[i] != null)
					model.setToDur(toDur[i]);
				if (viewFlg[i] != null)
					model.setViewFlg(viewFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (locBy[i] != null)
					model.setLocBy(locBy[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (tpCd[i] != null)
					model.setTpCd(tpCd[i]);
				if (cntrHngrBarAtchKnt[i] != null)
					model.setCntrHngrBarAtchKnt(cntrHngrBarAtchKnt[i]);
				if (cntrHngrRckCdO[i] != null)
					model.setCntrHngrRckCdO(cntrHngrRckCdO[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (vvd3[i] != null)
					model.setVvd3(vvd3[i]);
				if (viewCustomer[i] != null)
					model.setViewCustomer(viewCustomer[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bseDt[i] != null)
					model.setBseDt(bseDt[i]);
				if (dispFlg[i] != null)
					model.setDispFlg(dispFlg[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (longStayCd[i] != null)
					model.setLongStayCd(longStayCd[i]);
				if (fullFlg[i] != null)
					model.setFullFlg(fullFlg[i]);
				if (stayDays[i] != null)
					model.setStayDays(stayDays[i]);
				if (cntrHngrRckCdR[i] != null)
					model.setCntrHngrRckCdR(cntrHngrRckCdR[i]);
				if (cntrUseCoCd[i] != null)
					model.setCntrUseCoCd(cntrUseCoCd[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (froms[i] != null)
					model.setFroms(froms[i]);
				if (opTrndTpCd[i] != null)
					model.setOpTrndTpCd(opTrndTpCd[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (fromBseDt[i] != null)
					model.setFromBseDt(fromBseDt[i]);
				if (objCntrTpszCd[i] != null)
					model.setObjCntrTpszCd(objCntrTpszCd[i]);
				if (fmPrd[i] != null)
					model.setFmPrd(fmPrd[i]);
				if (d2PayldFlg[i] != null)
					model.setD2PayldFlg(d2PayldFlg[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (plstFlrFlg[i] != null)
					model.setPlstFlrFlg(plstFlrFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (thsWk[i] != null)
					model.setThsWk(thsWk[i]);
				if (preBatWk[i] != null)
					model.setPreBatWk(preBatWk[i]);
				if (nxtBatWk[i] != null)
					model.setNxtBatWk(nxtBatWk[i]);
				if (batWk[i] != null)
					model.setBatWk(batWk[i]);
				if (batFlg[i] != null)
					model.setBatFlg(batFlg[i]);
				if (yrwk[i] != null)
					model.setYrwk(yrwk[i]);
				if (wkFlg[i] != null)
					model.setWkFlg(wkFlg[i]);
				if (viewCommodity[i] != null)
					model.setViewCommodity(viewCommodity[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (cntrTpszCd14[i] != null)
					model.setCntrTpszCd14(cntrTpszCd14[i]);
				if (cntrTpszCd15[i] != null)
					model.setCntrTpszCd15(cntrTpszCd15[i]);
				if (cntrTpszCd16[i] != null)
					model.setCntrTpszCd16(cntrTpszCd16[i]);
				if (cntrTpszCd17[i] != null)
					model.setCntrTpszCd17(cntrTpszCd17[i]);
				if (cntrTpszCd18[i] != null)
					model.setCntrTpszCd18(cntrTpszCd18[i]);
				if (cntrTpszCd19[i] != null)
					model.setCntrTpszCd19(cntrTpszCd19[i]);
				if (rfTpCdReefer[i] != null)
					model.setRfTpCdReefer(rfTpCdReefer[i]);
				if (rccDate[i] != null)
					model.setRccDate(rccDate[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (rfCntr[i] != null)
					model.setRfCntr(rfCntr[i]);
				if (rfTpCdM[i] != null)
					model.setRfTpCdM(rfTpCdM[i]);
				if (rfTpCdC[i] != null)
					model.setRfTpCdC(rfTpCdC[i]);
				if (cntrTpszCd11[i] != null)
					model.setCntrTpszCd11(cntrTpszCd11[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (cntrTpszCd10[i] != null)
					model.setCntrTpszCd10(cntrTpszCd10[i]);
				if (rfTpCdH[i] != null)
					model.setRfTpCdH(rfTpCdH[i]);
				if (cntrTpszCd13[i] != null)
					model.setCntrTpszCd13(cntrTpszCd13[i]);
				if (cntrTpszCd12[i] != null)
					model.setCntrTpszCd12(cntrTpszCd12[i]);
				if (cntrTpszCd27[i] != null)
					model.setCntrTpszCd27(cntrTpszCd27[i]);
				if (cntrTpszCd28[i] != null)
					model.setCntrTpszCd28(cntrTpszCd28[i]);
				if (cntrTpszCd25[i] != null)
					model.setCntrTpszCd25(cntrTpszCd25[i]);
				if (cntrTpszCd26[i] != null)
					model.setCntrTpszCd26(cntrTpszCd26[i]);
				if (cntrTpszCd29[i] != null)
					model.setCntrTpszCd29(cntrTpszCd29[i]);
				if (toPrd[i] != null)
					model.setToPrd(toPrd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (queryStr[i] != null)
					model.setQueryStr(queryStr[i]);
				if (toBseDt[i] != null)
					model.setToBseDt(toBseDt[i]);
				if (tsCntrBehind[i] != null)
					model.setTsCntrBehind(tsCntrBehind[i]);
				if (overStayDays[i] != null)
					model.setOverStayDays(overStayDays[i]);
				if (uclmLsDivCd[i] != null)
					model.setUclmLsDivCd(uclmLsDivCd[i]);
				if (yardCd[i] != null)
					model.setYardCd(yardCd[i]);
				if (cntrTpszCd20[i] != null)
					model.setCntrTpszCd20(cntrTpszCd20[i]);
				if (nextVvd[i] != null)
					model.setNextVvd(nextVvd[i]);
				if (cntrTpszCd24[i] != null)
					model.setCntrTpszCd24(cntrTpszCd24[i]);
				if (cntrTpszCd23[i] != null)
					model.setCntrTpszCd23(cntrTpszCd23[i]);
				if (fmStkJbDt[i] != null)
					model.setFmStkJbDt(fmStkJbDt[i]);
				if (cntrTpszCd22[i] != null)
					model.setCntrTpszCd22(cntrTpszCd22[i]);
				if (cntrTpszCd21[i] != null)
					model.setCntrTpszCd21(cntrTpszCd21[i]);
				if (cntrHngrRckCd[i] != null)
					model.setCntrHngrRckCd(cntrHngrRckCd[i]);
				if (headCntrTpszCd[i] != null)
					model.setHeadCntrTpszCd(headCntrTpszCd[i]);
				if (offHireFlg[i] != null)
					model.setOffHireFlg(offHireFlg[i]);
				if (routeTpCd[i] != null)
					model.setRouteTpCd(routeTpCd[i]);
				if (dmgFlg[i] != null)
					model.setDmgFlg(dmgFlg[i]);
				if (locTypeCode[i] != null)
					model.setLocTypeCode(locTypeCode[i]);
				if (tos[i] != null)
					model.setTos(tos[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toStkJbDt[i] != null)
					model.setToStkJbDt(toStkJbDt[i]);
				if (cntrTpszCd30[i] != null)
					model.setCntrTpszCd30(cntrTpszCd30[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (overFreeDays[i] != null)
					model.setOverFreeDays(overFreeDays[i]);
				if (polPodWise[i] != null)
					model.setPolPodWise(polPodWise[i]);
				if (cntrTpszCd6[i] != null)
					model.setCntrTpszCd6(cntrTpszCd6[i]);
				if (cntrTpszCd5[i] != null)
					model.setCntrTpszCd5(cntrTpszCd5[i]);
				if (cntrTpszCd8[i] != null)
					model.setCntrTpszCd8(cntrTpszCd8[i]);
				if (cntrTpszCd7[i] != null)
					model.setCntrTpszCd7(cntrTpszCd7[i]);
				if (socCd[i] != null)
					model.setSocCd(socCd[i]);
				if (cntrTpszCd9[i] != null)
					model.setCntrTpszCd9(cntrTpszCd9[i]);
				if (cntrTpszCd2[i] != null)
					model.setCntrTpszCd2(cntrTpszCd2[i]);
				if (cntrTpszCd1[i] != null)
					model.setCntrTpszCd1(cntrTpszCd1[i]);
				if (cntrTpszCd4[i] != null)
					model.setCntrTpszCd4(cntrTpszCd4[i]);
				if (fmDur[i] != null)
					model.setFmDur(fmDur[i]);
				if (cntrTpszCd3[i] != null)
					model.setCntrTpszCd3(cntrTpszCd3[i]);
				if (dgFlg[i] != null)
					model.setDgFlg(dgFlg[i]);
				if (psaNo[i] != null)
					model.setPsaNo(psaNo[i]);
				if (salesOfcCd[i] != null)
					model.setSalesOfcCd(salesOfcCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvtOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvtOptionVO[]
	 */
	public InvtOptionVO[] getInvtOptionVOs(){
		InvtOptionVO[] vos = (InvtOptionVO[])models.toArray(new InvtOptionVO[models.size()]);
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
		this.toDur = this.toDur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewFlg = this.viewFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locBy = this.locBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd = this.tpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt = this.cntrHngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCdO = this.cntrHngrRckCdO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3 = this.vvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewCustomer = this.viewCustomer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseDt = this.bseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg = this.dispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.longStayCd = this.longStayCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg = this.fullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays = this.stayDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCdR = this.cntrHngrRckCdR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrUseCoCd = this.cntrUseCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.froms = this.froms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opTrndTpCd = this.opTrndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromBseDt = this.fromBseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objCntrTpszCd = this.objCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrd = this.fmPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2PayldFlg = this.d2PayldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plstFlrFlg = this.plstFlrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thsWk = this.thsWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preBatWk = this.preBatWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtBatWk = this.nxtBatWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batWk = this.batWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batFlg = this.batFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrwk = this.yrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkFlg = this.wkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewCommodity = this.viewCommodity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd14 = this.cntrTpszCd14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd15 = this.cntrTpszCd15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd16 = this.cntrTpszCd16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd17 = this.cntrTpszCd17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd18 = this.cntrTpszCd18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd19 = this.cntrTpszCd19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCdReefer = this.rfTpCdReefer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccDate = this.rccDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntr = this.rfCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCdM = this.rfTpCdM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCdC = this.rfTpCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd11 = this.cntrTpszCd11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd10 = this.cntrTpszCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCdH = this.rfTpCdH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd13 = this.cntrTpszCd13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd12 = this.cntrTpszCd12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd27 = this.cntrTpszCd27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd28 = this.cntrTpszCd28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd25 = this.cntrTpszCd25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd26 = this.cntrTpszCd26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd29 = this.cntrTpszCd29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrd = this.toPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.queryStr = this.queryStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toBseDt = this.toBseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsCntrBehind = this.tsCntrBehind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overStayDays = this.overStayDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsDivCd = this.uclmLsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCd = this.yardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd20 = this.cntrTpszCd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd = this.nextVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd24 = this.cntrTpszCd24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd23 = this.cntrTpszCd23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmStkJbDt = this.fmStkJbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd22 = this.cntrTpszCd22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd21 = this.cntrTpszCd21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd = this.cntrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.headCntrTpszCd = this.headCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offHireFlg = this.offHireFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routeTpCd = this.routeTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg = this.dmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTypeCode = this.locTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tos = this.tos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toStkJbDt = this.toStkJbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd30 = this.cntrTpszCd30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overFreeDays = this.overFreeDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPodWise = this.polPodWise .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd6 = this.cntrTpszCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd5 = this.cntrTpszCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd8 = this.cntrTpszCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd7 = this.cntrTpszCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socCd = this.socCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd9 = this.cntrTpszCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd2 = this.cntrTpszCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd1 = this.cntrTpszCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd4 = this.cntrTpszCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDur = this.fmDur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd3 = this.cntrTpszCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFlg = this.dgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaNo = this.psaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesOfcCd = this.salesOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
