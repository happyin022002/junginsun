/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchStockListVO.java
*@FileTitle : searchStockListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.08.12 김종준 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class searchStockListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<searchStockListVO> models = new ArrayList<searchStockListVO>();
	
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
	private String toDur = null;
	/* Column Info */
	private String cntrTpszCd19 = null;
	/* Column Info */
	private String rfTpCdReefer = null;
	/* Column Info */
	private String viewFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String rfCntr = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String tpCd = null;
	/* Column Info */
	private String rfTpCdC = null;
	/* Column Info */
	private String cntrHngrBarAtchKnt = null;
	/* Column Info */
	private String cntrTpszCd11 = null;
	/* Column Info */
	private String endStkJbDt = null;
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
	private String cntrHngrRckCdO = null;
	/* Column Info */
	private String cntrTpszCd29 = null;
	/* Column Info */
	private String toPrd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String vvd3 = null;
	/* Column Info */
	private String queryStr = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String tsCntrBehind = null;
	/* Column Info */
	private String bseDt = null;
	/* Column Info */
	private String toBseDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String dispFlg = null;
	/* Column Info */
	private String longStayCd = null;
	/* Column Info */
	private String cntrTpszCd20 = null;
	/* Column Info */
	private String fullFlg = null;
	/* Column Info */
	private String nextVvd = null;
	/* Column Info */
	private String stayDays = null;
	/* Column Info */
	private String cntrTpszCd24 = null;
	/* Column Info */
	private String cntrTpszCd23 = null;
	/* Column Info */
	private String cntrHngrRckCdR = null;
	/* Column Info */
	private String cntrTpszCd22 = null;
	/* Column Info */
	private String cntrTpszCd21 = null;
	/* Column Info */
	private String headCntrTpszCd = null;
	/* Column Info */
	private String strStkJbDt = null;
	/* Column Info */
	private String cntrUseCoCd = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String routeTpCd = null;
	/* Column Info */
	private String dmgFlg = null;
	/* Column Info */
	private String locTypeCode = null;
	/* Column Info */
	private String opTrndTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String fromBseDt = null;
	/* Column Info */
	private String cntrTpszCd30 = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String fmPrd = null;
	/* Column Info */
	private String polPodWise = null;
	/* Column Info */
	private String d2PayldFlg = null;
	/* Column Info */
	private String plstFlrFlg = null;
	/* Column Info */
	private String cntrTpszCd6 = null;
	/* Column Info */
	private String cntrTpszCd5 = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String cntrTpszCd8 = null;
	/* Column Info */
	private String cntrTpszCd7 = null;
	/* Column Info */
	private String socCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String cntrTpszCd9 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String imdtExtFlg = null;
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

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public searchStockListVO() {}

	public searchStockListVO(String ibflag, String pagerows, String fmDur, String viewFlg, String dispFlg, String tpCd, String fromBseDt, String locTypeCode, String dmgFlg, String bseDt, String fullFlg, String toDur, String ofcCd, String toPrd, String cntrHngrBarAtchKnt, String fmPrd, String locCd, String cntrNo, String d2PayldFlg, String cntrTpszCd, String cntrHngrRckCdR, String opTrndTpCd, String coCd, String cntrUseCoCd, String longStayCd, String toBseDt, String cntrHngrRckCdO, String cnmvStsCd, String lstmCd, String socCd, String headCntrTpszCd, String slanCd, String imdtExtFlg, String plstFlrFlg, String vvd1, String vvd2, String vvd3, String routeTpCd, String polCd, String podCd, String delCd, String rfTpCdC, String rfTpCdH, String rfCntr, String rdCgoFlg, String stayDays, String rfTpCdReefer, String polPodWise, String nextVvd, String tsCntrBehind, String cntCd, String queryStr, String strStkJbDt, String endStkJbDt, String cntrTpszCd1, String cntrTpszCd2, String cntrTpszCd3, String cntrTpszCd4, String cntrTpszCd5, String cntrTpszCd6, String cntrTpszCd7, String cntrTpszCd8, String cntrTpszCd9, String cntrTpszCd10, String cntrTpszCd11, String cntrTpszCd12, String cntrTpszCd13, String cntrTpszCd14, String cntrTpszCd15, String cntrTpszCd16, String cntrTpszCd17, String cntrTpszCd18, String cntrTpszCd19, String cntrTpszCd20, String cntrTpszCd21, String cntrTpszCd22, String cntrTpszCd23, String cntrTpszCd24, String cntrTpszCd25, String cntrTpszCd26, String cntrTpszCd27, String cntrTpszCd28, String cntrTpszCd29, String cntrTpszCd30) {
		this.cntrTpszCd14 = cntrTpszCd14;
		this.cntrTpszCd15 = cntrTpszCd15;
		this.cntrTpszCd16 = cntrTpszCd16;
		this.cntrTpszCd17 = cntrTpszCd17;
		this.cntrTpszCd18 = cntrTpszCd18;
		this.toDur = toDur;
		this.cntrTpszCd19 = cntrTpszCd19;
		this.rfTpCdReefer = rfTpCdReefer;
		this.viewFlg = viewFlg;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.polCd = polCd;
		this.rfCntr = rfCntr;
		this.cntCd = cntCd;
		this.cntrTpszCd = cntrTpszCd;
		this.tpCd = tpCd;
		this.rfTpCdC = rfTpCdC;
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
		this.cntrTpszCd11 = cntrTpszCd11;
		this.endStkJbDt = endStkJbDt;
		this.lstmCd = lstmCd;
		this.cntrTpszCd10 = cntrTpszCd10;
		this.rfTpCdH = rfTpCdH;
		this.cntrTpszCd13 = cntrTpszCd13;
		this.cntrTpszCd12 = cntrTpszCd12;
		this.cntrTpszCd27 = cntrTpszCd27;
		this.cntrTpszCd28 = cntrTpszCd28;
		this.cntrTpszCd25 = cntrTpszCd25;
		this.cntrTpszCd26 = cntrTpszCd26;
		this.cntrHngrRckCdO = cntrHngrRckCdO;
		this.cntrTpszCd29 = cntrTpszCd29;
		this.toPrd = toPrd;
		this.delCd = delCd;
		this.vvd2 = vvd2;
		this.vvd3 = vvd3;
		this.queryStr = queryStr;
		this.vvd1 = vvd1;
		this.tsCntrBehind = tsCntrBehind;
		this.bseDt = bseDt;
		this.toBseDt = toBseDt;
		this.podCd = podCd;
		this.dispFlg = dispFlg;
		this.longStayCd = longStayCd;
		this.cntrTpszCd20 = cntrTpszCd20;
		this.fullFlg = fullFlg;
		this.nextVvd = nextVvd;
		this.stayDays = stayDays;
		this.cntrTpszCd24 = cntrTpszCd24;
		this.cntrTpszCd23 = cntrTpszCd23;
		this.cntrHngrRckCdR = cntrHngrRckCdR;
		this.cntrTpszCd22 = cntrTpszCd22;
		this.cntrTpszCd21 = cntrTpszCd21;
		this.headCntrTpszCd = headCntrTpszCd;
		this.strStkJbDt = strStkJbDt;
		this.cntrUseCoCd = cntrUseCoCd;
		this.rdCgoFlg = rdCgoFlg;
		this.routeTpCd = routeTpCd;
		this.dmgFlg = dmgFlg;
		this.locTypeCode = locTypeCode;
		this.opTrndTpCd = opTrndTpCd;
		this.ibflag = ibflag;
		this.cnmvStsCd = cnmvStsCd;
		this.fromBseDt = fromBseDt;
		this.cntrTpszCd30 = cntrTpszCd30;
		this.coCd = coCd;
		this.fmPrd = fmPrd;
		this.polPodWise = polPodWise;
		this.d2PayldFlg = d2PayldFlg;
		this.plstFlrFlg = plstFlrFlg;
		this.cntrTpszCd6 = cntrTpszCd6;
		this.cntrTpszCd5 = cntrTpszCd5;
		this.ofcCd = ofcCd;
		this.cntrTpszCd8 = cntrTpszCd8;
		this.cntrTpszCd7 = cntrTpszCd7;
		this.socCd = socCd;
		this.slanCd = slanCd;
		this.cntrTpszCd9 = cntrTpszCd9;
		this.cntrNo = cntrNo;
		this.imdtExtFlg = imdtExtFlg;
		this.cntrTpszCd2 = cntrTpszCd2;
		this.cntrTpszCd1 = cntrTpszCd1;
		this.cntrTpszCd4 = cntrTpszCd4;
		this.fmDur = fmDur;
		this.cntrTpszCd3 = cntrTpszCd3;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_tpsz_cd14", getCntrTpszCd14());
		this.hashColumns.put("cntr_tpsz_cd15", getCntrTpszCd15());
		this.hashColumns.put("cntr_tpsz_cd16", getCntrTpszCd16());
		this.hashColumns.put("cntr_tpsz_cd17", getCntrTpszCd17());
		this.hashColumns.put("cntr_tpsz_cd18", getCntrTpszCd18());
		this.hashColumns.put("to_dur", getToDur());
		this.hashColumns.put("cntr_tpsz_cd19", getCntrTpszCd19());
		this.hashColumns.put("rf_tp_cd_reefer", getRfTpCdReefer());
		this.hashColumns.put("view_flg", getViewFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("rf_cntr", getRfCntr());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("tp_cd", getTpCd());
		this.hashColumns.put("rf_tp_cd_c", getRfTpCdC());
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());
		this.hashColumns.put("cntr_tpsz_cd11", getCntrTpszCd11());
		this.hashColumns.put("end_stk_jb_dt", getEndStkJbDt());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("cntr_tpsz_cd10", getCntrTpszCd10());
		this.hashColumns.put("rf_tp_cd_h", getRfTpCdH());
		this.hashColumns.put("cntr_tpsz_cd13", getCntrTpszCd13());
		this.hashColumns.put("cntr_tpsz_cd12", getCntrTpszCd12());
		this.hashColumns.put("cntr_tpsz_cd27", getCntrTpszCd27());
		this.hashColumns.put("cntr_tpsz_cd28", getCntrTpszCd28());
		this.hashColumns.put("cntr_tpsz_cd25", getCntrTpszCd25());
		this.hashColumns.put("cntr_tpsz_cd26", getCntrTpszCd26());
		this.hashColumns.put("cntr_hngr_rck_cd_o", getCntrHngrRckCdO());
		this.hashColumns.put("cntr_tpsz_cd29", getCntrTpszCd29());
		this.hashColumns.put("to_prd", getToPrd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("vvd3", getVvd3());
		this.hashColumns.put("query_str", getQueryStr());
		this.hashColumns.put("vvd1", getVvd1());
		this.hashColumns.put("ts_cntr_behind", getTsCntrBehind());
		this.hashColumns.put("bse_dt", getBseDt());
		this.hashColumns.put("to_bse_dt", getToBseDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("disp_flg", getDispFlg());
		this.hashColumns.put("long_stay_cd", getLongStayCd());
		this.hashColumns.put("cntr_tpsz_cd20", getCntrTpszCd20());
		this.hashColumns.put("full_flg", getFullFlg());
		this.hashColumns.put("next_vvd", getNextVvd());
		this.hashColumns.put("stay_days", getStayDays());
		this.hashColumns.put("cntr_tpsz_cd24", getCntrTpszCd24());
		this.hashColumns.put("cntr_tpsz_cd23", getCntrTpszCd23());
		this.hashColumns.put("cntr_hngr_rck_cd_r", getCntrHngrRckCdR());
		this.hashColumns.put("cntr_tpsz_cd22", getCntrTpszCd22());
		this.hashColumns.put("cntr_tpsz_cd21", getCntrTpszCd21());
		this.hashColumns.put("head_cntr_tpsz_cd", getHeadCntrTpszCd());
		this.hashColumns.put("str_stk_jb_dt", getStrStkJbDt());
		this.hashColumns.put("cntr_use_co_cd", getCntrUseCoCd());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("route_tp_cd", getRouteTpCd());
		this.hashColumns.put("dmg_flg", getDmgFlg());
		this.hashColumns.put("loc_type_code", getLocTypeCode());
		this.hashColumns.put("op_trnd_tp_cd", getOpTrndTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("from_bse_dt", getFromBseDt());
		this.hashColumns.put("cntr_tpsz_cd30", getCntrTpszCd30());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("fm_prd", getFmPrd());
		this.hashColumns.put("pol_pod_wise", getPolPodWise());
		this.hashColumns.put("d2_payld_flg", getD2PayldFlg());
		this.hashColumns.put("plst_flr_flg", getPlstFlrFlg());
		this.hashColumns.put("cntr_tpsz_cd6", getCntrTpszCd6());
		this.hashColumns.put("cntr_tpsz_cd5", getCntrTpszCd5());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cntr_tpsz_cd8", getCntrTpszCd8());
		this.hashColumns.put("cntr_tpsz_cd7", getCntrTpszCd7());
		this.hashColumns.put("soc_cd", getSocCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cntr_tpsz_cd9", getCntrTpszCd9());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("cntr_tpsz_cd2", getCntrTpszCd2());
		this.hashColumns.put("cntr_tpsz_cd1", getCntrTpszCd1());
		this.hashColumns.put("cntr_tpsz_cd4", getCntrTpszCd4());
		this.hashColumns.put("fm_dur", getFmDur());
		this.hashColumns.put("cntr_tpsz_cd3", getCntrTpszCd3());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_tpsz_cd14", "cntrTpszCd14");
		this.hashFields.put("cntr_tpsz_cd15", "cntrTpszCd15");
		this.hashFields.put("cntr_tpsz_cd16", "cntrTpszCd16");
		this.hashFields.put("cntr_tpsz_cd17", "cntrTpszCd17");
		this.hashFields.put("cntr_tpsz_cd18", "cntrTpszCd18");
		this.hashFields.put("to_dur", "toDur");
		this.hashFields.put("cntr_tpsz_cd19", "cntrTpszCd19");
		this.hashFields.put("rf_tp_cd_reefer", "rfTpCdReefer");
		this.hashFields.put("view_flg", "viewFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rf_cntr", "rfCntr");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("rf_tp_cd_c", "rfTpCdC");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("cntr_tpsz_cd11", "cntrTpszCd11");
		this.hashFields.put("end_stk_jb_dt", "endStkJbDt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("cntr_tpsz_cd10", "cntrTpszCd10");
		this.hashFields.put("rf_tp_cd_h", "rfTpCdH");
		this.hashFields.put("cntr_tpsz_cd13", "cntrTpszCd13");
		this.hashFields.put("cntr_tpsz_cd12", "cntrTpszCd12");
		this.hashFields.put("cntr_tpsz_cd27", "cntrTpszCd27");
		this.hashFields.put("cntr_tpsz_cd28", "cntrTpszCd28");
		this.hashFields.put("cntr_tpsz_cd25", "cntrTpszCd25");
		this.hashFields.put("cntr_tpsz_cd26", "cntrTpszCd26");
		this.hashFields.put("cntr_hngr_rck_cd_o", "cntrHngrRckCdO");
		this.hashFields.put("cntr_tpsz_cd29", "cntrTpszCd29");
		this.hashFields.put("to_prd", "toPrd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("vvd3", "vvd3");
		this.hashFields.put("query_str", "queryStr");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("ts_cntr_behind", "tsCntrBehind");
		this.hashFields.put("bse_dt", "bseDt");
		this.hashFields.put("to_bse_dt", "toBseDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("long_stay_cd", "longStayCd");
		this.hashFields.put("cntr_tpsz_cd20", "cntrTpszCd20");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("stay_days", "stayDays");
		this.hashFields.put("cntr_tpsz_cd24", "cntrTpszCd24");
		this.hashFields.put("cntr_tpsz_cd23", "cntrTpszCd23");
		this.hashFields.put("cntr_hngr_rck_cd_r", "cntrHngrRckCdR");
		this.hashFields.put("cntr_tpsz_cd22", "cntrTpszCd22");
		this.hashFields.put("cntr_tpsz_cd21", "cntrTpszCd21");
		this.hashFields.put("head_cntr_tpsz_cd", "headCntrTpszCd");
		this.hashFields.put("str_stk_jb_dt", "strStkJbDt");
		this.hashFields.put("cntr_use_co_cd", "cntrUseCoCd");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("route_tp_cd", "routeTpCd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("loc_type_code", "locTypeCode");
		this.hashFields.put("op_trnd_tp_cd", "opTrndTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("from_bse_dt", "fromBseDt");
		this.hashFields.put("cntr_tpsz_cd30", "cntrTpszCd30");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("fm_prd", "fmPrd");
		this.hashFields.put("pol_pod_wise", "polPodWise");
		this.hashFields.put("d2_payld_flg", "d2PayldFlg");
		this.hashFields.put("plst_flr_flg", "plstFlrFlg");
		this.hashFields.put("cntr_tpsz_cd6", "cntrTpszCd6");
		this.hashFields.put("cntr_tpsz_cd5", "cntrTpszCd5");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cntr_tpsz_cd8", "cntrTpszCd8");
		this.hashFields.put("cntr_tpsz_cd7", "cntrTpszCd7");
		this.hashFields.put("soc_cd", "socCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cntr_tpsz_cd9", "cntrTpszCd9");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("cntr_tpsz_cd2", "cntrTpszCd2");
		this.hashFields.put("cntr_tpsz_cd1", "cntrTpszCd1");
		this.hashFields.put("cntr_tpsz_cd4", "cntrTpszCd4");
		this.hashFields.put("fm_dur", "fmDur");
		this.hashFields.put("cntr_tpsz_cd3", "cntrTpszCd3");
		return this.hashFields;
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
	 * @return toDur
	 */
	public String getToDur() {
		return this.toDur;
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
	 * @return rfTpCdC
	 */
	public String getRfTpCdC() {
		return this.rfTpCdC;
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
	 * @return cntrTpszCd11
	 */
	public String getCntrTpszCd11() {
		return this.cntrTpszCd11;
	}
	
	/**
	 * Column Info
	 * @return endStkJbDt
	 */
	public String getEndStkJbDt() {
		return this.endStkJbDt;
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
	 * @return cntrHngrRckCdO
	 */
	public String getCntrHngrRckCdO() {
		return this.cntrHngrRckCdO;
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
	 * @return queryStr
	 */
	public String getQueryStr() {
		return this.queryStr;
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
	 * @return tsCntrBehind
	 */
	public String getTsCntrBehind() {
		return this.tsCntrBehind;
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
	 * @return toBseDt
	 */
	public String getToBseDt() {
		return this.toBseDt;
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
	 * @return dispFlg
	 */
	public String getDispFlg() {
		return this.dispFlg;
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
	 * @return cntrTpszCd20
	 */
	public String getCntrTpszCd20() {
		return this.cntrTpszCd20;
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
	 * @return nextVvd
	 */
	public String getNextVvd() {
		return this.nextVvd;
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
	 * @return cntrHngrRckCdR
	 */
	public String getCntrHngrRckCdR() {
		return this.cntrHngrRckCdR;
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
	 * @return headCntrTpszCd
	 */
	public String getHeadCntrTpszCd() {
		return this.headCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return strStkJbDt
	 */
	public String getStrStkJbDt() {
		return this.strStkJbDt;
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
	 * @return opTrndTpCd
	 */
	public String getOpTrndTpCd() {
		return this.opTrndTpCd;
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
	 * @return fmPrd
	 */
	public String getFmPrd() {
		return this.fmPrd;
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
	 * @return d2PayldFlg
	 */
	public String getD2PayldFlg() {
		return this.d2PayldFlg;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @param toDur
	 */
	public void setToDur(String toDur) {
		this.toDur = toDur;
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
	 * @param rfTpCdC
	 */
	public void setRfTpCdC(String rfTpCdC) {
		this.rfTpCdC = rfTpCdC;
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
	 * @param cntrTpszCd11
	 */
	public void setCntrTpszCd11(String cntrTpszCd11) {
		this.cntrTpszCd11 = cntrTpszCd11;
	}
	
	/**
	 * Column Info
	 * @param endStkJbDt
	 */
	public void setEndStkJbDt(String endStkJbDt) {
		this.endStkJbDt = endStkJbDt;
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
	 * @param cntrHngrRckCdO
	 */
	public void setCntrHngrRckCdO(String cntrHngrRckCdO) {
		this.cntrHngrRckCdO = cntrHngrRckCdO;
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
	 * @param queryStr
	 */
	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
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
	 * @param tsCntrBehind
	 */
	public void setTsCntrBehind(String tsCntrBehind) {
		this.tsCntrBehind = tsCntrBehind;
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
	 * @param toBseDt
	 */
	public void setToBseDt(String toBseDt) {
		this.toBseDt = toBseDt;
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
	 * @param dispFlg
	 */
	public void setDispFlg(String dispFlg) {
		this.dispFlg = dispFlg;
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
	 * @param cntrTpszCd20
	 */
	public void setCntrTpszCd20(String cntrTpszCd20) {
		this.cntrTpszCd20 = cntrTpszCd20;
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
	 * @param nextVvd
	 */
	public void setNextVvd(String nextVvd) {
		this.nextVvd = nextVvd;
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
	 * @param cntrHngrRckCdR
	 */
	public void setCntrHngrRckCdR(String cntrHngrRckCdR) {
		this.cntrHngrRckCdR = cntrHngrRckCdR;
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
	 * @param headCntrTpszCd
	 */
	public void setHeadCntrTpszCd(String headCntrTpszCd) {
		this.headCntrTpszCd = headCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param strStkJbDt
	 */
	public void setStrStkJbDt(String strStkJbDt) {
		this.strStkJbDt = strStkJbDt;
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
	 * @param opTrndTpCd
	 */
	public void setOpTrndTpCd(String opTrndTpCd) {
		this.opTrndTpCd = opTrndTpCd;
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
	 * @param fmPrd
	 */
	public void setFmPrd(String fmPrd) {
		this.fmPrd = fmPrd;
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
	 * @param d2PayldFlg
	 */
	public void setD2PayldFlg(String d2PayldFlg) {
		this.d2PayldFlg = d2PayldFlg;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrTpszCd14(JSPUtil.getParameter(request, "cntr_tpsz_cd14", ""));
		setCntrTpszCd15(JSPUtil.getParameter(request, "cntr_tpsz_cd15", ""));
		setCntrTpszCd16(JSPUtil.getParameter(request, "cntr_tpsz_cd16", ""));
		setCntrTpszCd17(JSPUtil.getParameter(request, "cntr_tpsz_cd17", ""));
		setCntrTpszCd18(JSPUtil.getParameter(request, "cntr_tpsz_cd18", ""));
		setToDur(JSPUtil.getParameter(request, "to_dur", ""));
		setCntrTpszCd19(JSPUtil.getParameter(request, "cntr_tpsz_cd19", ""));
		setRfTpCdReefer(JSPUtil.getParameter(request, "rf_tp_cd_reefer", ""));
		setViewFlg(JSPUtil.getParameter(request, "view_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setRfCntr(JSPUtil.getParameter(request, "rf_cntr", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setTpCd(JSPUtil.getParameter(request, "tp_cd", ""));
		setRfTpCdC(JSPUtil.getParameter(request, "rf_tp_cd_c", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request, "cntr_hngr_bar_atch_knt", ""));
		setCntrTpszCd11(JSPUtil.getParameter(request, "cntr_tpsz_cd11", ""));
		setEndStkJbDt(JSPUtil.getParameter(request, "end_stk_jb_dt", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setCntrTpszCd10(JSPUtil.getParameter(request, "cntr_tpsz_cd10", ""));
		setRfTpCdH(JSPUtil.getParameter(request, "rf_tp_cd_h", ""));
		setCntrTpszCd13(JSPUtil.getParameter(request, "cntr_tpsz_cd13", ""));
		setCntrTpszCd12(JSPUtil.getParameter(request, "cntr_tpsz_cd12", ""));
		setCntrTpszCd27(JSPUtil.getParameter(request, "cntr_tpsz_cd27", ""));
		setCntrTpszCd28(JSPUtil.getParameter(request, "cntr_tpsz_cd28", ""));
		setCntrTpszCd25(JSPUtil.getParameter(request, "cntr_tpsz_cd25", ""));
		setCntrTpszCd26(JSPUtil.getParameter(request, "cntr_tpsz_cd26", ""));
		setCntrHngrRckCdO(JSPUtil.getParameter(request, "cntr_hngr_rck_cd_o", ""));
		setCntrTpszCd29(JSPUtil.getParameter(request, "cntr_tpsz_cd29", ""));
		setToPrd(JSPUtil.getParameter(request, "to_prd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setVvd2(JSPUtil.getParameter(request, "vvd2", ""));
		setVvd3(JSPUtil.getParameter(request, "vvd3", ""));
		setQueryStr(JSPUtil.getParameter(request, "query_str", ""));
		setVvd1(JSPUtil.getParameter(request, "vvd1", ""));
		setTsCntrBehind(JSPUtil.getParameter(request, "ts_cntr_behind", ""));
		setBseDt(JSPUtil.getParameter(request, "bse_dt", ""));
		setToBseDt(JSPUtil.getParameter(request, "to_bse_dt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDispFlg(JSPUtil.getParameter(request, "disp_flg", ""));
		setLongStayCd(JSPUtil.getParameter(request, "long_stay_cd", ""));
		setCntrTpszCd20(JSPUtil.getParameter(request, "cntr_tpsz_cd20", ""));
		setFullFlg(JSPUtil.getParameter(request, "full_flg", ""));
		setNextVvd(JSPUtil.getParameter(request, "next_vvd", ""));
		setStayDays(JSPUtil.getParameter(request, "stay_days", ""));
		setCntrTpszCd24(JSPUtil.getParameter(request, "cntr_tpsz_cd24", ""));
		setCntrTpszCd23(JSPUtil.getParameter(request, "cntr_tpsz_cd23", ""));
		setCntrHngrRckCdR(JSPUtil.getParameter(request, "cntr_hngr_rck_cd_r", ""));
		setCntrTpszCd22(JSPUtil.getParameter(request, "cntr_tpsz_cd22", ""));
		setCntrTpszCd21(JSPUtil.getParameter(request, "cntr_tpsz_cd21", ""));
		setHeadCntrTpszCd(JSPUtil.getParameter(request, "head_cntr_tpsz_cd", ""));
		setStrStkJbDt(JSPUtil.getParameter(request, "str_stk_jb_dt", ""));
		setCntrUseCoCd(JSPUtil.getParameter(request, "cntr_use_co_cd", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, "rd_cgo_flg", ""));
		setRouteTpCd(JSPUtil.getParameter(request, "route_tp_cd", ""));
		setDmgFlg(JSPUtil.getParameter(request, "dmg_flg", ""));
		setLocTypeCode(JSPUtil.getParameter(request, "loc_type_code", ""));
		setOpTrndTpCd(JSPUtil.getParameter(request, "op_trnd_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setFromBseDt(JSPUtil.getParameter(request, "from_bse_dt", ""));
		setCntrTpszCd30(JSPUtil.getParameter(request, "cntr_tpsz_cd30", ""));
		setCoCd(JSPUtil.getParameter(request, "co_cd", ""));
		setFmPrd(JSPUtil.getParameter(request, "fm_prd", ""));
		setPolPodWise(JSPUtil.getParameter(request, "pol_pod_wise", ""));
		setD2PayldFlg(JSPUtil.getParameter(request, "d2_payld_flg", ""));
		setPlstFlrFlg(JSPUtil.getParameter(request, "plst_flr_flg", ""));
		setCntrTpszCd6(JSPUtil.getParameter(request, "cntr_tpsz_cd6", ""));
		setCntrTpszCd5(JSPUtil.getParameter(request, "cntr_tpsz_cd5", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCntrTpszCd8(JSPUtil.getParameter(request, "cntr_tpsz_cd8", ""));
		setCntrTpszCd7(JSPUtil.getParameter(request, "cntr_tpsz_cd7", ""));
		setSocCd(JSPUtil.getParameter(request, "soc_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setCntrTpszCd9(JSPUtil.getParameter(request, "cntr_tpsz_cd9", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, "imdt_ext_flg", ""));
		setCntrTpszCd2(JSPUtil.getParameter(request, "cntr_tpsz_cd2", ""));
		setCntrTpszCd1(JSPUtil.getParameter(request, "cntr_tpsz_cd1", ""));
		setCntrTpszCd4(JSPUtil.getParameter(request, "cntr_tpsz_cd4", ""));
		setFmDur(JSPUtil.getParameter(request, "fm_dur", ""));
		setCntrTpszCd3(JSPUtil.getParameter(request, "cntr_tpsz_cd3", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchStockListVO[]
	 */
	public searchStockListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchStockListVO[]
	 */
	public searchStockListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		searchStockListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrTpszCd14 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd14", length));
			String[] cntrTpszCd15 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd15", length));
			String[] cntrTpszCd16 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd16", length));
			String[] cntrTpszCd17 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd17", length));
			String[] cntrTpszCd18 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd18", length));
			String[] toDur = (JSPUtil.getParameter(request, prefix	+ "to_dur", length));
			String[] cntrTpszCd19 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd19", length));
			String[] rfTpCdReefer = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd_reefer", length));
			String[] viewFlg = (JSPUtil.getParameter(request, prefix	+ "view_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] rfCntr = (JSPUtil.getParameter(request, prefix	+ "rf_cntr", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] tpCd = (JSPUtil.getParameter(request, prefix	+ "tp_cd", length));
			String[] rfTpCdC = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd_c", length));
			String[] cntrHngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_bar_atch_knt", length));
			String[] cntrTpszCd11 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd11", length));
			String[] endStkJbDt = (JSPUtil.getParameter(request, prefix	+ "end_stk_jb_dt", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] cntrTpszCd10 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd10", length));
			String[] rfTpCdH = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd_h", length));
			String[] cntrTpszCd13 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd13", length));
			String[] cntrTpszCd12 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd12", length));
			String[] cntrTpszCd27 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd27", length));
			String[] cntrTpszCd28 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd28", length));
			String[] cntrTpszCd25 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd25", length));
			String[] cntrTpszCd26 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd26", length));
			String[] cntrHngrRckCdO = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd_o", length));
			String[] cntrTpszCd29 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd29", length));
			String[] toPrd = (JSPUtil.getParameter(request, prefix	+ "to_prd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));
			String[] vvd3 = (JSPUtil.getParameter(request, prefix	+ "vvd3", length));
			String[] queryStr = (JSPUtil.getParameter(request, prefix	+ "query_str", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd1", length));
			String[] tsCntrBehind = (JSPUtil.getParameter(request, prefix	+ "ts_cntr_behind", length));
			String[] bseDt = (JSPUtil.getParameter(request, prefix	+ "bse_dt", length));
			String[] toBseDt = (JSPUtil.getParameter(request, prefix	+ "to_bse_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] dispFlg = (JSPUtil.getParameter(request, prefix	+ "disp_flg", length));
			String[] longStayCd = (JSPUtil.getParameter(request, prefix	+ "long_stay_cd", length));
			String[] cntrTpszCd20 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd20", length));
			String[] fullFlg = (JSPUtil.getParameter(request, prefix	+ "full_flg", length));
			String[] nextVvd = (JSPUtil.getParameter(request, prefix	+ "next_vvd", length));
			String[] stayDays = (JSPUtil.getParameter(request, prefix	+ "stay_days", length));
			String[] cntrTpszCd24 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd24", length));
			String[] cntrTpszCd23 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd23", length));
			String[] cntrHngrRckCdR = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd_r", length));
			String[] cntrTpszCd22 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd22", length));
			String[] cntrTpszCd21 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd21", length));
			String[] headCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "head_cntr_tpsz_cd", length));
			String[] strStkJbDt = (JSPUtil.getParameter(request, prefix	+ "str_stk_jb_dt", length));
			String[] cntrUseCoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_use_co_cd", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] routeTpCd = (JSPUtil.getParameter(request, prefix	+ "route_tp_cd", length));
			String[] dmgFlg = (JSPUtil.getParameter(request, prefix	+ "dmg_flg", length));
			String[] locTypeCode = (JSPUtil.getParameter(request, prefix	+ "loc_type_code", length));
			String[] opTrndTpCd = (JSPUtil.getParameter(request, prefix	+ "op_trnd_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] fromBseDt = (JSPUtil.getParameter(request, prefix	+ "from_bse_dt", length));
			String[] cntrTpszCd30 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd30", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] fmPrd = (JSPUtil.getParameter(request, prefix	+ "fm_prd", length));
			String[] polPodWise = (JSPUtil.getParameter(request, prefix	+ "pol_pod_wise", length));
			String[] d2PayldFlg = (JSPUtil.getParameter(request, prefix	+ "d2_payld_flg", length));
			String[] plstFlrFlg = (JSPUtil.getParameter(request, prefix	+ "plst_flr_flg", length));
			String[] cntrTpszCd6 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd6", length));
			String[] cntrTpszCd5 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd5", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] cntrTpszCd8 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd8", length));
			String[] cntrTpszCd7 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd7", length));
			String[] socCd = (JSPUtil.getParameter(request, prefix	+ "soc_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] cntrTpszCd9 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd9", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] cntrTpszCd2 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd2", length));
			String[] cntrTpszCd1 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd1", length));
			String[] cntrTpszCd4 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd4", length));
			String[] fmDur = (JSPUtil.getParameter(request, prefix	+ "fm_dur", length));
			String[] cntrTpszCd3 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd3", length));
			
			for (int i = 0; i < length; i++) {
				model = new searchStockListVO();
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
				if (toDur[i] != null)
					model.setToDur(toDur[i]);
				if (cntrTpszCd19[i] != null)
					model.setCntrTpszCd19(cntrTpszCd19[i]);
				if (rfTpCdReefer[i] != null)
					model.setRfTpCdReefer(rfTpCdReefer[i]);
				if (viewFlg[i] != null)
					model.setViewFlg(viewFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (rfCntr[i] != null)
					model.setRfCntr(rfCntr[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (tpCd[i] != null)
					model.setTpCd(tpCd[i]);
				if (rfTpCdC[i] != null)
					model.setRfTpCdC(rfTpCdC[i]);
				if (cntrHngrBarAtchKnt[i] != null)
					model.setCntrHngrBarAtchKnt(cntrHngrBarAtchKnt[i]);
				if (cntrTpszCd11[i] != null)
					model.setCntrTpszCd11(cntrTpszCd11[i]);
				if (endStkJbDt[i] != null)
					model.setEndStkJbDt(endStkJbDt[i]);
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
				if (cntrHngrRckCdO[i] != null)
					model.setCntrHngrRckCdO(cntrHngrRckCdO[i]);
				if (cntrTpszCd29[i] != null)
					model.setCntrTpszCd29(cntrTpszCd29[i]);
				if (toPrd[i] != null)
					model.setToPrd(toPrd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (vvd3[i] != null)
					model.setVvd3(vvd3[i]);
				if (queryStr[i] != null)
					model.setQueryStr(queryStr[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (tsCntrBehind[i] != null)
					model.setTsCntrBehind(tsCntrBehind[i]);
				if (bseDt[i] != null)
					model.setBseDt(bseDt[i]);
				if (toBseDt[i] != null)
					model.setToBseDt(toBseDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (dispFlg[i] != null)
					model.setDispFlg(dispFlg[i]);
				if (longStayCd[i] != null)
					model.setLongStayCd(longStayCd[i]);
				if (cntrTpszCd20[i] != null)
					model.setCntrTpszCd20(cntrTpszCd20[i]);
				if (fullFlg[i] != null)
					model.setFullFlg(fullFlg[i]);
				if (nextVvd[i] != null)
					model.setNextVvd(nextVvd[i]);
				if (stayDays[i] != null)
					model.setStayDays(stayDays[i]);
				if (cntrTpszCd24[i] != null)
					model.setCntrTpszCd24(cntrTpszCd24[i]);
				if (cntrTpszCd23[i] != null)
					model.setCntrTpszCd23(cntrTpszCd23[i]);
				if (cntrHngrRckCdR[i] != null)
					model.setCntrHngrRckCdR(cntrHngrRckCdR[i]);
				if (cntrTpszCd22[i] != null)
					model.setCntrTpszCd22(cntrTpszCd22[i]);
				if (cntrTpszCd21[i] != null)
					model.setCntrTpszCd21(cntrTpszCd21[i]);
				if (headCntrTpszCd[i] != null)
					model.setHeadCntrTpszCd(headCntrTpszCd[i]);
				if (strStkJbDt[i] != null)
					model.setStrStkJbDt(strStkJbDt[i]);
				if (cntrUseCoCd[i] != null)
					model.setCntrUseCoCd(cntrUseCoCd[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (routeTpCd[i] != null)
					model.setRouteTpCd(routeTpCd[i]);
				if (dmgFlg[i] != null)
					model.setDmgFlg(dmgFlg[i]);
				if (locTypeCode[i] != null)
					model.setLocTypeCode(locTypeCode[i]);
				if (opTrndTpCd[i] != null)
					model.setOpTrndTpCd(opTrndTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (fromBseDt[i] != null)
					model.setFromBseDt(fromBseDt[i]);
				if (cntrTpszCd30[i] != null)
					model.setCntrTpszCd30(cntrTpszCd30[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (fmPrd[i] != null)
					model.setFmPrd(fmPrd[i]);
				if (polPodWise[i] != null)
					model.setPolPodWise(polPodWise[i]);
				if (d2PayldFlg[i] != null)
					model.setD2PayldFlg(d2PayldFlg[i]);
				if (plstFlrFlg[i] != null)
					model.setPlstFlrFlg(plstFlrFlg[i]);
				if (cntrTpszCd6[i] != null)
					model.setCntrTpszCd6(cntrTpszCd6[i]);
				if (cntrTpszCd5[i] != null)
					model.setCntrTpszCd5(cntrTpszCd5[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (cntrTpszCd8[i] != null)
					model.setCntrTpszCd8(cntrTpszCd8[i]);
				if (cntrTpszCd7[i] != null)
					model.setCntrTpszCd7(cntrTpszCd7[i]);
				if (socCd[i] != null)
					model.setSocCd(socCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (cntrTpszCd9[i] != null)
					model.setCntrTpszCd9(cntrTpszCd9[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
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
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchStockListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchStockListVO[]
	 */
	public searchStockListVO[] getsearchStockListVOs(){
		searchStockListVO[] vos = (searchStockListVO[])models.toArray(new searchStockListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.cntrTpszCd14 = this.cntrTpszCd14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd15 = this.cntrTpszCd15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd16 = this.cntrTpszCd16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd17 = this.cntrTpszCd17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd18 = this.cntrTpszCd18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDur = this.toDur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd19 = this.cntrTpszCd19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCdReefer = this.rfTpCdReefer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewFlg = this.viewFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntr = this.rfCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd = this.tpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCdC = this.rfTpCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt = this.cntrHngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd11 = this.cntrTpszCd11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endStkJbDt = this.endStkJbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd10 = this.cntrTpszCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCdH = this.rfTpCdH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd13 = this.cntrTpszCd13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd12 = this.cntrTpszCd12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd27 = this.cntrTpszCd27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd28 = this.cntrTpszCd28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd25 = this.cntrTpszCd25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd26 = this.cntrTpszCd26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCdO = this.cntrHngrRckCdO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd29 = this.cntrTpszCd29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrd = this.toPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3 = this.vvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.queryStr = this.queryStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsCntrBehind = this.tsCntrBehind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseDt = this.bseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toBseDt = this.toBseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg = this.dispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.longStayCd = this.longStayCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd20 = this.cntrTpszCd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg = this.fullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd = this.nextVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays = this.stayDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd24 = this.cntrTpszCd24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd23 = this.cntrTpszCd23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCdR = this.cntrHngrRckCdR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd22 = this.cntrTpszCd22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd21 = this.cntrTpszCd21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.headCntrTpszCd = this.headCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strStkJbDt = this.strStkJbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrUseCoCd = this.cntrUseCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routeTpCd = this.routeTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg = this.dmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTypeCode = this.locTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opTrndTpCd = this.opTrndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromBseDt = this.fromBseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd30 = this.cntrTpszCd30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrd = this.fmPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPodWise = this.polPodWise .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2PayldFlg = this.d2PayldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plstFlrFlg = this.plstFlrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd6 = this.cntrTpszCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd5 = this.cntrTpszCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd8 = this.cntrTpszCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd7 = this.cntrTpszCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socCd = this.socCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd9 = this.cntrTpszCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd2 = this.cntrTpszCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd1 = this.cntrTpszCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd4 = this.cntrTpszCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDur = this.fmDur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd3 = this.cntrTpszCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
