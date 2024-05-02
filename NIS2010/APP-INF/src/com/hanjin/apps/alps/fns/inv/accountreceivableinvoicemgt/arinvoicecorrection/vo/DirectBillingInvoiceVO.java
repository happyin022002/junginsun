/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DirectBillingInvoiceVO.java
*@FileTitle : DirectBillingInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.10 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DirectBillingInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DirectBillingInvoiceVO> models = new ArrayList<DirectBillingInvoiceVO>();
	
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String cntrNo18 = null;
	/* Column Info */
	private String cntrNo17 = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String cntrNo19 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrNo13 = null;
	/* Column Info */
	private String cntrTyp12 = null;
	/* Column Info */
	private String cntrNo14 = null;
	/* Column Info */
	private String cntrTyp11 = null;
	/* Column Info */
	private String cntrNo15 = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cntrTyp10 = null;
	/* Column Info */
	private String cntrNo16 = null;
	/* Column Info */
	private String cntrTyp16 = null;
	/* Column Info */
	private String cntrTyp15 = null;
	/* Column Info */
	private String cntrNo10 = null;
	/* Column Info */
	private String cntrTyp14 = null;
	/* Column Info */
	private String cntrNo11 = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTyp13 = null;
	/* Column Info */
	private String cntrNo12 = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String cntrTyp19 = null;
	/* Column Info */
	private String cntrTyp18 = null;
	/* Column Info */
	private String cntrTyp17 = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String cgoWgt = null;
	/* Column Info */
	private String cntrTyp4 = null;
	/* Column Info */
	private String cntrTyp5 = null;
	/* Column Info */
	private String cntrTyp2 = null;
	/* Column Info */
	private String cntrTyp3 = null;
	/* Column Info */
	private String cntrTyp8 = null;
	/* Column Info */
	private String cntrTyp9 = null;
	/* Column Info */
	private String cntrTyp6 = null;
	/* Column Info */
	private String cntrTyp7 = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cntrTyp30 = null;
	/* Column Info */
	private String cntrTyp21 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String cntrTyp20 = null;
	/* Column Info */
	private String cntrTyp23 = null;
	/* Column Info */
	private String cntrTyp22 = null;
	/* Column Info */
	private String cntrTyp25 = null;
	/* Column Info */
	private String cntrTyp24 = null;
	/* Column Info */
	private String cntrTyp27 = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String cntrTyp26 = null;
	/* Column Info */
	private String cntrTyp29 = null;
	/* Column Info */
	private String cntrTyp28 = null;
	/* Column Info */
	private String cntrTyp1 = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String cntrNo2 = null;
	/* Column Info */
	private String cntrNo3 = null;
	/* Column Info */
	private String cntrNo4 = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cntrNo5 = null;
	/* Column Info */
	private String cntrNo6 = null;
	/* Column Info */
	private String cntrNo7 = null;
	/* Column Info */
	private String cntrNo8 = null;
	/* Column Info */
	private String cntrNo9 = null;
	/* Column Info */
	private String trfRtAmt = null;
	/* Column Info */
	private String cntrNo1 = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo30 = null;
	/* Column Info */
	private String cgoMeasQty = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String cntrNo28 = null;
	/* Column Info */
	private String cntrNo29 = null;
	/* Column Info */
	private String perTpCd = null;
	/* Column Info */
	private String invRefNo = null;
	/* Column Info */
	private String loclAmt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String bkgRefNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String cntrNo23 = null;
	/* Column Info */
	private String cntrNo22 = null;
	/* Column Info */
	private String cntrNo21 = null;
	/* Column Info */
	private String cntrNo20 = null;
	/* Column Info */
	private String cntrNo27 = null;
	/* Column Info */
	private String cntrNo26 = null;
	/* Column Info */
	private String ratAsCntrQty = null;
	/* Column Info */
	private String cntrNo25 = null;
	/* Column Info */
	private String cntrNo24 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DirectBillingInvoiceVO() {}

	public DirectBillingInvoiceVO(String ibflag, String pagerows, String arOfcCd, String blSrcNo, String invNo, String issDt, String vvd, String ioBndCd, String svcScpCd, String slanCd, String sailArrDt, String custCd, String rfaNo, String scNo, String porCd, String polCd, String podCd, String delCd, String chgCd, String currCd, String trfRtAmt, String ratAsCntrQty, String perTpCd, String chgAmt, String invXchRt, String loclAmt, String bkgRefNo, String invRefNo, String cgoMeasQty, String cgoWgt, String cntrTyp1, String cntrNo1, String cntrTyp2, String cntrNo2, String cntrTyp3, String cntrNo3, String cntrTyp4, String cntrNo4, String cntrTyp5, String cntrNo5, String cntrTyp6, String cntrNo6, String cntrTyp7, String cntrNo7, String cntrTyp8, String cntrNo8, String cntrTyp9, String cntrNo9, String cntrTyp10, String cntrNo10, String cntrTyp11, String cntrNo11, String cntrTyp12, String cntrNo12, String cntrTyp13, String cntrNo13, String cntrTyp14, String cntrNo14, String cntrTyp15, String cntrNo15, String cntrTyp16, String cntrNo16, String cntrTyp17, String cntrNo17, String cntrTyp18, String cntrNo18, String cntrTyp19, String cntrNo19, String cntrTyp20, String cntrNo20, String cntrTyp21, String cntrNo21, String cntrTyp22, String cntrNo22, String cntrTyp23, String cntrNo23, String cntrTyp24, String cntrNo24, String cntrTyp25, String cntrNo25, String cntrTyp26, String cntrNo26, String cntrTyp27, String cntrNo27, String cntrTyp28, String cntrNo28, String cntrTyp29, String cntrNo29, String cntrTyp30, String cntrNo30) {
		this.svcScpCd = svcScpCd;
		this.cntrNo18 = cntrNo18;
		this.cntrNo17 = cntrNo17;
		this.sailArrDt = sailArrDt;
		this.chgCd = chgCd;
		this.cntrNo19 = cntrNo19;
		this.pagerows = pagerows;
		this.cntrNo13 = cntrNo13;
		this.cntrTyp12 = cntrTyp12;
		this.cntrNo14 = cntrNo14;
		this.cntrTyp11 = cntrTyp11;
		this.cntrNo15 = cntrNo15;
		this.polCd = polCd;
		this.cntrTyp10 = cntrTyp10;
		this.cntrNo16 = cntrNo16;
		this.cntrTyp16 = cntrTyp16;
		this.cntrTyp15 = cntrTyp15;
		this.cntrNo10 = cntrNo10;
		this.cntrTyp14 = cntrTyp14;
		this.cntrNo11 = cntrNo11;
		this.scNo = scNo;
		this.cntrTyp13 = cntrTyp13;
		this.cntrNo12 = cntrNo12;
		this.chgAmt = chgAmt;
		this.cntrTyp19 = cntrTyp19;
		this.cntrTyp18 = cntrTyp18;
		this.cntrTyp17 = cntrTyp17;
		this.invXchRt = invXchRt;
		this.cgoWgt = cgoWgt;
		this.cntrTyp4 = cntrTyp4;
		this.cntrTyp5 = cntrTyp5;
		this.cntrTyp2 = cntrTyp2;
		this.cntrTyp3 = cntrTyp3;
		this.cntrTyp8 = cntrTyp8;
		this.cntrTyp9 = cntrTyp9;
		this.cntrTyp6 = cntrTyp6;
		this.cntrTyp7 = cntrTyp7;
		this.delCd = delCd;
		this.cntrTyp30 = cntrTyp30;
		this.cntrTyp21 = cntrTyp21;
		this.podCd = podCd;
		this.vvd = vvd;
		this.cntrTyp20 = cntrTyp20;
		this.cntrTyp23 = cntrTyp23;
		this.cntrTyp22 = cntrTyp22;
		this.cntrTyp25 = cntrTyp25;
		this.cntrTyp24 = cntrTyp24;
		this.cntrTyp27 = cntrTyp27;
		this.custCd = custCd;
		this.cntrTyp26 = cntrTyp26;
		this.cntrTyp29 = cntrTyp29;
		this.cntrTyp28 = cntrTyp28;
		this.cntrTyp1 = cntrTyp1;
		this.porCd = porCd;
		this.cntrNo2 = cntrNo2;
		this.cntrNo3 = cntrNo3;
		this.cntrNo4 = cntrNo4;
		this.currCd = currCd;
		this.cntrNo5 = cntrNo5;
		this.cntrNo6 = cntrNo6;
		this.cntrNo7 = cntrNo7;
		this.cntrNo8 = cntrNo8;
		this.cntrNo9 = cntrNo9;
		this.trfRtAmt = trfRtAmt;
		this.cntrNo1 = cntrNo1;
		this.issDt = issDt;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.cntrNo30 = cntrNo30;
		this.cgoMeasQty = cgoMeasQty;
		this.blSrcNo = blSrcNo;
		this.cntrNo28 = cntrNo28;
		this.cntrNo29 = cntrNo29;
		this.perTpCd = perTpCd;
		this.invRefNo = invRefNo;
		this.loclAmt = loclAmt;
		this.ioBndCd = ioBndCd;
		this.arOfcCd = arOfcCd;
		this.invNo = invNo;
		this.bkgRefNo = bkgRefNo;
		this.slanCd = slanCd;
		this.cntrNo23 = cntrNo23;
		this.cntrNo22 = cntrNo22;
		this.cntrNo21 = cntrNo21;
		this.cntrNo20 = cntrNo20;
		this.cntrNo27 = cntrNo27;
		this.cntrNo26 = cntrNo26;
		this.ratAsCntrQty = ratAsCntrQty;
		this.cntrNo25 = cntrNo25;
		this.cntrNo24 = cntrNo24;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cntr_no_18", getCntrNo18());
		this.hashColumns.put("cntr_no_17", getCntrNo17());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("cntr_no_19", getCntrNo19());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_no_13", getCntrNo13());
		this.hashColumns.put("cntr_typ_12", getCntrTyp12());
		this.hashColumns.put("cntr_no_14", getCntrNo14());
		this.hashColumns.put("cntr_typ_11", getCntrTyp11());
		this.hashColumns.put("cntr_no_15", getCntrNo15());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cntr_typ_10", getCntrTyp10());
		this.hashColumns.put("cntr_no_16", getCntrNo16());
		this.hashColumns.put("cntr_typ_16", getCntrTyp16());
		this.hashColumns.put("cntr_typ_15", getCntrTyp15());
		this.hashColumns.put("cntr_no_10", getCntrNo10());
		this.hashColumns.put("cntr_typ_14", getCntrTyp14());
		this.hashColumns.put("cntr_no_11", getCntrNo11());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_typ_13", getCntrTyp13());
		this.hashColumns.put("cntr_no_12", getCntrNo12());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("cntr_typ_19", getCntrTyp19());
		this.hashColumns.put("cntr_typ_18", getCntrTyp18());
		this.hashColumns.put("cntr_typ_17", getCntrTyp17());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		this.hashColumns.put("cntr_typ_4", getCntrTyp4());
		this.hashColumns.put("cntr_typ_5", getCntrTyp5());
		this.hashColumns.put("cntr_typ_2", getCntrTyp2());
		this.hashColumns.put("cntr_typ_3", getCntrTyp3());
		this.hashColumns.put("cntr_typ_8", getCntrTyp8());
		this.hashColumns.put("cntr_typ_9", getCntrTyp9());
		this.hashColumns.put("cntr_typ_6", getCntrTyp6());
		this.hashColumns.put("cntr_typ_7", getCntrTyp7());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cntr_typ_30", getCntrTyp30());
		this.hashColumns.put("cntr_typ_21", getCntrTyp21());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cntr_typ_20", getCntrTyp20());
		this.hashColumns.put("cntr_typ_23", getCntrTyp23());
		this.hashColumns.put("cntr_typ_22", getCntrTyp22());
		this.hashColumns.put("cntr_typ_25", getCntrTyp25());
		this.hashColumns.put("cntr_typ_24", getCntrTyp24());
		this.hashColumns.put("cntr_typ_27", getCntrTyp27());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cntr_typ_26", getCntrTyp26());
		this.hashColumns.put("cntr_typ_29", getCntrTyp29());
		this.hashColumns.put("cntr_typ_28", getCntrTyp28());
		this.hashColumns.put("cntr_typ_1", getCntrTyp1());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cntr_no_2", getCntrNo2());
		this.hashColumns.put("cntr_no_3", getCntrNo3());
		this.hashColumns.put("cntr_no_4", getCntrNo4());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cntr_no_5", getCntrNo5());
		this.hashColumns.put("cntr_no_6", getCntrNo6());
		this.hashColumns.put("cntr_no_7", getCntrNo7());
		this.hashColumns.put("cntr_no_8", getCntrNo8());
		this.hashColumns.put("cntr_no_9", getCntrNo9());
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());
		this.hashColumns.put("cntr_no_1", getCntrNo1());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no_30", getCntrNo30());
		this.hashColumns.put("cgo_meas_qty", getCgoMeasQty());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("cntr_no_28", getCntrNo28());
		this.hashColumns.put("cntr_no_29", getCntrNo29());
		this.hashColumns.put("per_tp_cd", getPerTpCd());
		this.hashColumns.put("inv_ref_no", getInvRefNo());
		this.hashColumns.put("locl_amt", getLoclAmt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cntr_no_23", getCntrNo23());
		this.hashColumns.put("cntr_no_22", getCntrNo22());
		this.hashColumns.put("cntr_no_21", getCntrNo21());
		this.hashColumns.put("cntr_no_20", getCntrNo20());
		this.hashColumns.put("cntr_no_27", getCntrNo27());
		this.hashColumns.put("cntr_no_26", getCntrNo26());
		this.hashColumns.put("rat_as_cntr_qty", getRatAsCntrQty());
		this.hashColumns.put("cntr_no_25", getCntrNo25());
		this.hashColumns.put("cntr_no_24", getCntrNo24());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cntr_no_18", "cntrNo18");
		this.hashFields.put("cntr_no_17", "cntrNo17");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("cntr_no_19", "cntrNo19");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_no_13", "cntrNo13");
		this.hashFields.put("cntr_typ_12", "cntrTyp12");
		this.hashFields.put("cntr_no_14", "cntrNo14");
		this.hashFields.put("cntr_typ_11", "cntrTyp11");
		this.hashFields.put("cntr_no_15", "cntrNo15");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cntr_typ_10", "cntrTyp10");
		this.hashFields.put("cntr_no_16", "cntrNo16");
		this.hashFields.put("cntr_typ_16", "cntrTyp16");
		this.hashFields.put("cntr_typ_15", "cntrTyp15");
		this.hashFields.put("cntr_no_10", "cntrNo10");
		this.hashFields.put("cntr_typ_14", "cntrTyp14");
		this.hashFields.put("cntr_no_11", "cntrNo11");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_typ_13", "cntrTyp13");
		this.hashFields.put("cntr_no_12", "cntrNo12");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("cntr_typ_19", "cntrTyp19");
		this.hashFields.put("cntr_typ_18", "cntrTyp18");
		this.hashFields.put("cntr_typ_17", "cntrTyp17");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("cgo_wgt", "cgoWgt");
		this.hashFields.put("cntr_typ_4", "cntrTyp4");
		this.hashFields.put("cntr_typ_5", "cntrTyp5");
		this.hashFields.put("cntr_typ_2", "cntrTyp2");
		this.hashFields.put("cntr_typ_3", "cntrTyp3");
		this.hashFields.put("cntr_typ_8", "cntrTyp8");
		this.hashFields.put("cntr_typ_9", "cntrTyp9");
		this.hashFields.put("cntr_typ_6", "cntrTyp6");
		this.hashFields.put("cntr_typ_7", "cntrTyp7");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cntr_typ_30", "cntrTyp30");
		this.hashFields.put("cntr_typ_21", "cntrTyp21");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cntr_typ_20", "cntrTyp20");
		this.hashFields.put("cntr_typ_23", "cntrTyp23");
		this.hashFields.put("cntr_typ_22", "cntrTyp22");
		this.hashFields.put("cntr_typ_25", "cntrTyp25");
		this.hashFields.put("cntr_typ_24", "cntrTyp24");
		this.hashFields.put("cntr_typ_27", "cntrTyp27");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cntr_typ_26", "cntrTyp26");
		this.hashFields.put("cntr_typ_29", "cntrTyp29");
		this.hashFields.put("cntr_typ_28", "cntrTyp28");
		this.hashFields.put("cntr_typ_1", "cntrTyp1");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cntr_no_2", "cntrNo2");
		this.hashFields.put("cntr_no_3", "cntrNo3");
		this.hashFields.put("cntr_no_4", "cntrNo4");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cntr_no_5", "cntrNo5");
		this.hashFields.put("cntr_no_6", "cntrNo6");
		this.hashFields.put("cntr_no_7", "cntrNo7");
		this.hashFields.put("cntr_no_8", "cntrNo8");
		this.hashFields.put("cntr_no_9", "cntrNo9");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("cntr_no_1", "cntrNo1");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no_30", "cntrNo30");
		this.hashFields.put("cgo_meas_qty", "cgoMeasQty");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("cntr_no_28", "cntrNo28");
		this.hashFields.put("cntr_no_29", "cntrNo29");
		this.hashFields.put("per_tp_cd", "perTpCd");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("locl_amt", "loclAmt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cntr_no_23", "cntrNo23");
		this.hashFields.put("cntr_no_22", "cntrNo22");
		this.hashFields.put("cntr_no_21", "cntrNo21");
		this.hashFields.put("cntr_no_20", "cntrNo20");
		this.hashFields.put("cntr_no_27", "cntrNo27");
		this.hashFields.put("cntr_no_26", "cntrNo26");
		this.hashFields.put("rat_as_cntr_qty", "ratAsCntrQty");
		this.hashFields.put("cntr_no_25", "cntrNo25");
		this.hashFields.put("cntr_no_24", "cntrNo24");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo18
	 */
	public String getCntrNo18() {
		return this.cntrNo18;
	}
	
	/**
	 * Column Info
	 * @return cntrNo17
	 */
	public String getCntrNo17() {
		return this.cntrNo17;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo19
	 */
	public String getCntrNo19() {
		return this.cntrNo19;
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
	 * @return cntrNo13
	 */
	public String getCntrNo13() {
		return this.cntrNo13;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp12
	 */
	public String getCntrTyp12() {
		return this.cntrTyp12;
	}
	
	/**
	 * Column Info
	 * @return cntrNo14
	 */
	public String getCntrNo14() {
		return this.cntrNo14;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp11
	 */
	public String getCntrTyp11() {
		return this.cntrTyp11;
	}
	
	/**
	 * Column Info
	 * @return cntrNo15
	 */
	public String getCntrNo15() {
		return this.cntrNo15;
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
	 * @return cntrTyp10
	 */
	public String getCntrTyp10() {
		return this.cntrTyp10;
	}
	
	/**
	 * Column Info
	 * @return cntrNo16
	 */
	public String getCntrNo16() {
		return this.cntrNo16;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp16
	 */
	public String getCntrTyp16() {
		return this.cntrTyp16;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp15
	 */
	public String getCntrTyp15() {
		return this.cntrTyp15;
	}
	
	/**
	 * Column Info
	 * @return cntrNo10
	 */
	public String getCntrNo10() {
		return this.cntrNo10;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp14
	 */
	public String getCntrTyp14() {
		return this.cntrTyp14;
	}
	
	/**
	 * Column Info
	 * @return cntrNo11
	 */
	public String getCntrNo11() {
		return this.cntrNo11;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp13
	 */
	public String getCntrTyp13() {
		return this.cntrTyp13;
	}
	
	/**
	 * Column Info
	 * @return cntrNo12
	 */
	public String getCntrNo12() {
		return this.cntrNo12;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp19
	 */
	public String getCntrTyp19() {
		return this.cntrTyp19;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp18
	 */
	public String getCntrTyp18() {
		return this.cntrTyp18;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp17
	 */
	public String getCntrTyp17() {
		return this.cntrTyp17;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return cgoWgt
	 */
	public String getCgoWgt() {
		return this.cgoWgt;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp4
	 */
	public String getCntrTyp4() {
		return this.cntrTyp4;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp5
	 */
	public String getCntrTyp5() {
		return this.cntrTyp5;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp2
	 */
	public String getCntrTyp2() {
		return this.cntrTyp2;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp3
	 */
	public String getCntrTyp3() {
		return this.cntrTyp3;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp8
	 */
	public String getCntrTyp8() {
		return this.cntrTyp8;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp9
	 */
	public String getCntrTyp9() {
		return this.cntrTyp9;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp6
	 */
	public String getCntrTyp6() {
		return this.cntrTyp6;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp7
	 */
	public String getCntrTyp7() {
		return this.cntrTyp7;
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
	 * @return cntrTyp30
	 */
	public String getCntrTyp30() {
		return this.cntrTyp30;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp21
	 */
	public String getCntrTyp21() {
		return this.cntrTyp21;
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
	 * @return cntrTyp20
	 */
	public String getCntrTyp20() {
		return this.cntrTyp20;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp23
	 */
	public String getCntrTyp23() {
		return this.cntrTyp23;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp22
	 */
	public String getCntrTyp22() {
		return this.cntrTyp22;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp25
	 */
	public String getCntrTyp25() {
		return this.cntrTyp25;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp24
	 */
	public String getCntrTyp24() {
		return this.cntrTyp24;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp27
	 */
	public String getCntrTyp27() {
		return this.cntrTyp27;
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
	 * @return cntrTyp26
	 */
	public String getCntrTyp26() {
		return this.cntrTyp26;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp29
	 */
	public String getCntrTyp29() {
		return this.cntrTyp29;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp28
	 */
	public String getCntrTyp28() {
		return this.cntrTyp28;
	}
	
	/**
	 * Column Info
	 * @return cntrTyp1
	 */
	public String getCntrTyp1() {
		return this.cntrTyp1;
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
	 * @return cntrNo2
	 */
	public String getCntrNo2() {
		return this.cntrNo2;
	}
	
	/**
	 * Column Info
	 * @return cntrNo3
	 */
	public String getCntrNo3() {
		return this.cntrNo3;
	}
	
	/**
	 * Column Info
	 * @return cntrNo4
	 */
	public String getCntrNo4() {
		return this.cntrNo4;
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
	 * @return cntrNo5
	 */
	public String getCntrNo5() {
		return this.cntrNo5;
	}
	
	/**
	 * Column Info
	 * @return cntrNo6
	 */
	public String getCntrNo6() {
		return this.cntrNo6;
	}
	
	/**
	 * Column Info
	 * @return cntrNo7
	 */
	public String getCntrNo7() {
		return this.cntrNo7;
	}
	
	/**
	 * Column Info
	 * @return cntrNo8
	 */
	public String getCntrNo8() {
		return this.cntrNo8;
	}
	
	/**
	 * Column Info
	 * @return cntrNo9
	 */
	public String getCntrNo9() {
		return this.cntrNo9;
	}
	
	/**
	 * Column Info
	 * @return trfRtAmt
	 */
	public String getTrfRtAmt() {
		return this.trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrNo1
	 */
	public String getCntrNo1() {
		return this.cntrNo1;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return cntrNo30
	 */
	public String getCntrNo30() {
		return this.cntrNo30;
	}
	
	/**
	 * Column Info
	 * @return cgoMeasQty
	 */
	public String getCgoMeasQty() {
		return this.cgoMeasQty;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNo28
	 */
	public String getCntrNo28() {
		return this.cntrNo28;
	}
	
	/**
	 * Column Info
	 * @return cntrNo29
	 */
	public String getCntrNo29() {
		return this.cntrNo29;
	}
	
	/**
	 * Column Info
	 * @return perTpCd
	 */
	public String getPerTpCd() {
		return this.perTpCd;
	}
	
	/**
	 * Column Info
	 * @return invRefNo
	 */
	public String getInvRefNo() {
		return this.invRefNo;
	}
	
	/**
	 * Column Info
	 * @return loclAmt
	 */
	public String getLoclAmt() {
		return this.loclAmt;
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
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return bkgRefNo
	 */
	public String getBkgRefNo() {
		return this.bkgRefNo;
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
	 * @return cntrNo23
	 */
	public String getCntrNo23() {
		return this.cntrNo23;
	}
	
	/**
	 * Column Info
	 * @return cntrNo22
	 */
	public String getCntrNo22() {
		return this.cntrNo22;
	}
	
	/**
	 * Column Info
	 * @return cntrNo21
	 */
	public String getCntrNo21() {
		return this.cntrNo21;
	}
	
	/**
	 * Column Info
	 * @return cntrNo20
	 */
	public String getCntrNo20() {
		return this.cntrNo20;
	}
	
	/**
	 * Column Info
	 * @return cntrNo27
	 */
	public String getCntrNo27() {
		return this.cntrNo27;
	}
	
	/**
	 * Column Info
	 * @return cntrNo26
	 */
	public String getCntrNo26() {
		return this.cntrNo26;
	}
	
	/**
	 * Column Info
	 * @return ratAsCntrQty
	 */
	public String getRatAsCntrQty() {
		return this.ratAsCntrQty;
	}
	
	/**
	 * Column Info
	 * @return cntrNo25
	 */
	public String getCntrNo25() {
		return this.cntrNo25;
	}
	
	/**
	 * Column Info
	 * @return cntrNo24
	 */
	public String getCntrNo24() {
		return this.cntrNo24;
	}
	

	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo18
	 */
	public void setCntrNo18(String cntrNo18) {
		this.cntrNo18 = cntrNo18;
	}
	
	/**
	 * Column Info
	 * @param cntrNo17
	 */
	public void setCntrNo17(String cntrNo17) {
		this.cntrNo17 = cntrNo17;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo19
	 */
	public void setCntrNo19(String cntrNo19) {
		this.cntrNo19 = cntrNo19;
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
	 * @param cntrNo13
	 */
	public void setCntrNo13(String cntrNo13) {
		this.cntrNo13 = cntrNo13;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp12
	 */
	public void setCntrTyp12(String cntrTyp12) {
		this.cntrTyp12 = cntrTyp12;
	}
	
	/**
	 * Column Info
	 * @param cntrNo14
	 */
	public void setCntrNo14(String cntrNo14) {
		this.cntrNo14 = cntrNo14;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp11
	 */
	public void setCntrTyp11(String cntrTyp11) {
		this.cntrTyp11 = cntrTyp11;
	}
	
	/**
	 * Column Info
	 * @param cntrNo15
	 */
	public void setCntrNo15(String cntrNo15) {
		this.cntrNo15 = cntrNo15;
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
	 * @param cntrTyp10
	 */
	public void setCntrTyp10(String cntrTyp10) {
		this.cntrTyp10 = cntrTyp10;
	}
	
	/**
	 * Column Info
	 * @param cntrNo16
	 */
	public void setCntrNo16(String cntrNo16) {
		this.cntrNo16 = cntrNo16;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp16
	 */
	public void setCntrTyp16(String cntrTyp16) {
		this.cntrTyp16 = cntrTyp16;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp15
	 */
	public void setCntrTyp15(String cntrTyp15) {
		this.cntrTyp15 = cntrTyp15;
	}
	
	/**
	 * Column Info
	 * @param cntrNo10
	 */
	public void setCntrNo10(String cntrNo10) {
		this.cntrNo10 = cntrNo10;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp14
	 */
	public void setCntrTyp14(String cntrTyp14) {
		this.cntrTyp14 = cntrTyp14;
	}
	
	/**
	 * Column Info
	 * @param cntrNo11
	 */
	public void setCntrNo11(String cntrNo11) {
		this.cntrNo11 = cntrNo11;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp13
	 */
	public void setCntrTyp13(String cntrTyp13) {
		this.cntrTyp13 = cntrTyp13;
	}
	
	/**
	 * Column Info
	 * @param cntrNo12
	 */
	public void setCntrNo12(String cntrNo12) {
		this.cntrNo12 = cntrNo12;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp19
	 */
	public void setCntrTyp19(String cntrTyp19) {
		this.cntrTyp19 = cntrTyp19;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp18
	 */
	public void setCntrTyp18(String cntrTyp18) {
		this.cntrTyp18 = cntrTyp18;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp17
	 */
	public void setCntrTyp17(String cntrTyp17) {
		this.cntrTyp17 = cntrTyp17;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param cgoWgt
	 */
	public void setCgoWgt(String cgoWgt) {
		this.cgoWgt = cgoWgt;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp4
	 */
	public void setCntrTyp4(String cntrTyp4) {
		this.cntrTyp4 = cntrTyp4;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp5
	 */
	public void setCntrTyp5(String cntrTyp5) {
		this.cntrTyp5 = cntrTyp5;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp2
	 */
	public void setCntrTyp2(String cntrTyp2) {
		this.cntrTyp2 = cntrTyp2;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp3
	 */
	public void setCntrTyp3(String cntrTyp3) {
		this.cntrTyp3 = cntrTyp3;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp8
	 */
	public void setCntrTyp8(String cntrTyp8) {
		this.cntrTyp8 = cntrTyp8;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp9
	 */
	public void setCntrTyp9(String cntrTyp9) {
		this.cntrTyp9 = cntrTyp9;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp6
	 */
	public void setCntrTyp6(String cntrTyp6) {
		this.cntrTyp6 = cntrTyp6;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp7
	 */
	public void setCntrTyp7(String cntrTyp7) {
		this.cntrTyp7 = cntrTyp7;
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
	 * @param cntrTyp30
	 */
	public void setCntrTyp30(String cntrTyp30) {
		this.cntrTyp30 = cntrTyp30;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp21
	 */
	public void setCntrTyp21(String cntrTyp21) {
		this.cntrTyp21 = cntrTyp21;
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
	 * @param cntrTyp20
	 */
	public void setCntrTyp20(String cntrTyp20) {
		this.cntrTyp20 = cntrTyp20;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp23
	 */
	public void setCntrTyp23(String cntrTyp23) {
		this.cntrTyp23 = cntrTyp23;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp22
	 */
	public void setCntrTyp22(String cntrTyp22) {
		this.cntrTyp22 = cntrTyp22;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp25
	 */
	public void setCntrTyp25(String cntrTyp25) {
		this.cntrTyp25 = cntrTyp25;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp24
	 */
	public void setCntrTyp24(String cntrTyp24) {
		this.cntrTyp24 = cntrTyp24;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp27
	 */
	public void setCntrTyp27(String cntrTyp27) {
		this.cntrTyp27 = cntrTyp27;
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
	 * @param cntrTyp26
	 */
	public void setCntrTyp26(String cntrTyp26) {
		this.cntrTyp26 = cntrTyp26;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp29
	 */
	public void setCntrTyp29(String cntrTyp29) {
		this.cntrTyp29 = cntrTyp29;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp28
	 */
	public void setCntrTyp28(String cntrTyp28) {
		this.cntrTyp28 = cntrTyp28;
	}
	
	/**
	 * Column Info
	 * @param cntrTyp1
	 */
	public void setCntrTyp1(String cntrTyp1) {
		this.cntrTyp1 = cntrTyp1;
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
	 * @param cntrNo2
	 */
	public void setCntrNo2(String cntrNo2) {
		this.cntrNo2 = cntrNo2;
	}
	
	/**
	 * Column Info
	 * @param cntrNo3
	 */
	public void setCntrNo3(String cntrNo3) {
		this.cntrNo3 = cntrNo3;
	}
	
	/**
	 * Column Info
	 * @param cntrNo4
	 */
	public void setCntrNo4(String cntrNo4) {
		this.cntrNo4 = cntrNo4;
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
	 * @param cntrNo5
	 */
	public void setCntrNo5(String cntrNo5) {
		this.cntrNo5 = cntrNo5;
	}
	
	/**
	 * Column Info
	 * @param cntrNo6
	 */
	public void setCntrNo6(String cntrNo6) {
		this.cntrNo6 = cntrNo6;
	}
	
	/**
	 * Column Info
	 * @param cntrNo7
	 */
	public void setCntrNo7(String cntrNo7) {
		this.cntrNo7 = cntrNo7;
	}
	
	/**
	 * Column Info
	 * @param cntrNo8
	 */
	public void setCntrNo8(String cntrNo8) {
		this.cntrNo8 = cntrNo8;
	}
	
	/**
	 * Column Info
	 * @param cntrNo9
	 */
	public void setCntrNo9(String cntrNo9) {
		this.cntrNo9 = cntrNo9;
	}
	
	/**
	 * Column Info
	 * @param trfRtAmt
	 */
	public void setTrfRtAmt(String trfRtAmt) {
		this.trfRtAmt = trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrNo1
	 */
	public void setCntrNo1(String cntrNo1) {
		this.cntrNo1 = cntrNo1;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param cntrNo30
	 */
	public void setCntrNo30(String cntrNo30) {
		this.cntrNo30 = cntrNo30;
	}
	
	/**
	 * Column Info
	 * @param cgoMeasQty
	 */
	public void setCgoMeasQty(String cgoMeasQty) {
		this.cgoMeasQty = cgoMeasQty;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNo28
	 */
	public void setCntrNo28(String cntrNo28) {
		this.cntrNo28 = cntrNo28;
	}
	
	/**
	 * Column Info
	 * @param cntrNo29
	 */
	public void setCntrNo29(String cntrNo29) {
		this.cntrNo29 = cntrNo29;
	}
	
	/**
	 * Column Info
	 * @param perTpCd
	 */
	public void setPerTpCd(String perTpCd) {
		this.perTpCd = perTpCd;
	}
	
	/**
	 * Column Info
	 * @param invRefNo
	 */
	public void setInvRefNo(String invRefNo) {
		this.invRefNo = invRefNo;
	}
	
	/**
	 * Column Info
	 * @param loclAmt
	 */
	public void setLoclAmt(String loclAmt) {
		this.loclAmt = loclAmt;
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
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param bkgRefNo
	 */
	public void setBkgRefNo(String bkgRefNo) {
		this.bkgRefNo = bkgRefNo;
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
	 * @param cntrNo23
	 */
	public void setCntrNo23(String cntrNo23) {
		this.cntrNo23 = cntrNo23;
	}
	
	/**
	 * Column Info
	 * @param cntrNo22
	 */
	public void setCntrNo22(String cntrNo22) {
		this.cntrNo22 = cntrNo22;
	}
	
	/**
	 * Column Info
	 * @param cntrNo21
	 */
	public void setCntrNo21(String cntrNo21) {
		this.cntrNo21 = cntrNo21;
	}
	
	/**
	 * Column Info
	 * @param cntrNo20
	 */
	public void setCntrNo20(String cntrNo20) {
		this.cntrNo20 = cntrNo20;
	}
	
	/**
	 * Column Info
	 * @param cntrNo27
	 */
	public void setCntrNo27(String cntrNo27) {
		this.cntrNo27 = cntrNo27;
	}
	
	/**
	 * Column Info
	 * @param cntrNo26
	 */
	public void setCntrNo26(String cntrNo26) {
		this.cntrNo26 = cntrNo26;
	}
	
	/**
	 * Column Info
	 * @param ratAsCntrQty
	 */
	public void setRatAsCntrQty(String ratAsCntrQty) {
		this.ratAsCntrQty = ratAsCntrQty;
	}
	
	/**
	 * Column Info
	 * @param cntrNo25
	 */
	public void setCntrNo25(String cntrNo25) {
		this.cntrNo25 = cntrNo25;
	}
	
	/**
	 * Column Info
	 * @param cntrNo24
	 */
	public void setCntrNo24(String cntrNo24) {
		this.cntrNo24 = cntrNo24;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCntrNo18(JSPUtil.getParameter(request, "cntr_no_18", ""));
		setCntrNo17(JSPUtil.getParameter(request, "cntr_no_17", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setCntrNo19(JSPUtil.getParameter(request, "cntr_no_19", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrNo13(JSPUtil.getParameter(request, "cntr_no_13", ""));
		setCntrTyp12(JSPUtil.getParameter(request, "cntr_typ_12", ""));
		setCntrNo14(JSPUtil.getParameter(request, "cntr_no_14", ""));
		setCntrTyp11(JSPUtil.getParameter(request, "cntr_typ_11", ""));
		setCntrNo15(JSPUtil.getParameter(request, "cntr_no_15", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCntrTyp10(JSPUtil.getParameter(request, "cntr_typ_10", ""));
		setCntrNo16(JSPUtil.getParameter(request, "cntr_no_16", ""));
		setCntrTyp16(JSPUtil.getParameter(request, "cntr_typ_16", ""));
		setCntrTyp15(JSPUtil.getParameter(request, "cntr_typ_15", ""));
		setCntrNo10(JSPUtil.getParameter(request, "cntr_no_10", ""));
		setCntrTyp14(JSPUtil.getParameter(request, "cntr_typ_14", ""));
		setCntrNo11(JSPUtil.getParameter(request, "cntr_no_11", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCntrTyp13(JSPUtil.getParameter(request, "cntr_typ_13", ""));
		setCntrNo12(JSPUtil.getParameter(request, "cntr_no_12", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setCntrTyp19(JSPUtil.getParameter(request, "cntr_typ_19", ""));
		setCntrTyp18(JSPUtil.getParameter(request, "cntr_typ_18", ""));
		setCntrTyp17(JSPUtil.getParameter(request, "cntr_typ_17", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setCgoWgt(JSPUtil.getParameter(request, "cgo_wgt", ""));
		setCntrTyp4(JSPUtil.getParameter(request, "cntr_typ_4", ""));
		setCntrTyp5(JSPUtil.getParameter(request, "cntr_typ_5", ""));
		setCntrTyp2(JSPUtil.getParameter(request, "cntr_typ_2", ""));
		setCntrTyp3(JSPUtil.getParameter(request, "cntr_typ_3", ""));
		setCntrTyp8(JSPUtil.getParameter(request, "cntr_typ_8", ""));
		setCntrTyp9(JSPUtil.getParameter(request, "cntr_typ_9", ""));
		setCntrTyp6(JSPUtil.getParameter(request, "cntr_typ_6", ""));
		setCntrTyp7(JSPUtil.getParameter(request, "cntr_typ_7", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCntrTyp30(JSPUtil.getParameter(request, "cntr_typ_30", ""));
		setCntrTyp21(JSPUtil.getParameter(request, "cntr_typ_21", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setCntrTyp20(JSPUtil.getParameter(request, "cntr_typ_20", ""));
		setCntrTyp23(JSPUtil.getParameter(request, "cntr_typ_23", ""));
		setCntrTyp22(JSPUtil.getParameter(request, "cntr_typ_22", ""));
		setCntrTyp25(JSPUtil.getParameter(request, "cntr_typ_25", ""));
		setCntrTyp24(JSPUtil.getParameter(request, "cntr_typ_24", ""));
		setCntrTyp27(JSPUtil.getParameter(request, "cntr_typ_27", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setCntrTyp26(JSPUtil.getParameter(request, "cntr_typ_26", ""));
		setCntrTyp29(JSPUtil.getParameter(request, "cntr_typ_29", ""));
		setCntrTyp28(JSPUtil.getParameter(request, "cntr_typ_28", ""));
		setCntrTyp1(JSPUtil.getParameter(request, "cntr_typ_1", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCntrNo2(JSPUtil.getParameter(request, "cntr_no_2", ""));
		setCntrNo3(JSPUtil.getParameter(request, "cntr_no_3", ""));
		setCntrNo4(JSPUtil.getParameter(request, "cntr_no_4", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCntrNo5(JSPUtil.getParameter(request, "cntr_no_5", ""));
		setCntrNo6(JSPUtil.getParameter(request, "cntr_no_6", ""));
		setCntrNo7(JSPUtil.getParameter(request, "cntr_no_7", ""));
		setCntrNo8(JSPUtil.getParameter(request, "cntr_no_8", ""));
		setCntrNo9(JSPUtil.getParameter(request, "cntr_no_9", ""));
		setTrfRtAmt(JSPUtil.getParameter(request, "trf_rt_amt", ""));
		setCntrNo1(JSPUtil.getParameter(request, "cntr_no_1", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo30(JSPUtil.getParameter(request, "cntr_no_30", ""));
		setCgoMeasQty(JSPUtil.getParameter(request, "cgo_meas_qty", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setCntrNo28(JSPUtil.getParameter(request, "cntr_no_28", ""));
		setCntrNo29(JSPUtil.getParameter(request, "cntr_no_29", ""));
		setPerTpCd(JSPUtil.getParameter(request, "per_tp_cd", ""));
		setInvRefNo(JSPUtil.getParameter(request, "inv_ref_no", ""));
		setLoclAmt(JSPUtil.getParameter(request, "locl_amt", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setBkgRefNo(JSPUtil.getParameter(request, "bkg_ref_no", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setCntrNo23(JSPUtil.getParameter(request, "cntr_no_23", ""));
		setCntrNo22(JSPUtil.getParameter(request, "cntr_no_22", ""));
		setCntrNo21(JSPUtil.getParameter(request, "cntr_no_21", ""));
		setCntrNo20(JSPUtil.getParameter(request, "cntr_no_20", ""));
		setCntrNo27(JSPUtil.getParameter(request, "cntr_no_27", ""));
		setCntrNo26(JSPUtil.getParameter(request, "cntr_no_26", ""));
		setRatAsCntrQty(JSPUtil.getParameter(request, "rat_as_cntr_qty", ""));
		setCntrNo25(JSPUtil.getParameter(request, "cntr_no_25", ""));
		setCntrNo24(JSPUtil.getParameter(request, "cntr_no_24", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DirectBillingInvoiceVO[]
	 */
	public DirectBillingInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DirectBillingInvoiceVO[]
	 */
	public DirectBillingInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DirectBillingInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] cntrNo18 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_18", length));
			String[] cntrNo17 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_17", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] cntrNo19 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_19", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrNo13 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_13", length));
			String[] cntrTyp12 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_12", length));
			String[] cntrNo14 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_14", length));
			String[] cntrTyp11 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_11", length));
			String[] cntrNo15 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_15", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cntrTyp10 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_10", length));
			String[] cntrNo16 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_16", length));
			String[] cntrTyp16 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_16", length));
			String[] cntrTyp15 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_15", length));
			String[] cntrNo10 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_10", length));
			String[] cntrTyp14 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_14", length));
			String[] cntrNo11 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_11", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTyp13 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_13", length));
			String[] cntrNo12 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_12", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] cntrTyp19 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_19", length));
			String[] cntrTyp18 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_18", length));
			String[] cntrTyp17 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_17", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt", length));
			String[] cntrTyp4 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_4", length));
			String[] cntrTyp5 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_5", length));
			String[] cntrTyp2 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_2", length));
			String[] cntrTyp3 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_3", length));
			String[] cntrTyp8 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_8", length));
			String[] cntrTyp9 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_9", length));
			String[] cntrTyp6 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_6", length));
			String[] cntrTyp7 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_7", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cntrTyp30 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_30", length));
			String[] cntrTyp21 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_21", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] cntrTyp20 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_20", length));
			String[] cntrTyp23 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_23", length));
			String[] cntrTyp22 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_22", length));
			String[] cntrTyp25 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_25", length));
			String[] cntrTyp24 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_24", length));
			String[] cntrTyp27 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_27", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] cntrTyp26 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_26", length));
			String[] cntrTyp29 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_29", length));
			String[] cntrTyp28 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_28", length));
			String[] cntrTyp1 = (JSPUtil.getParameter(request, prefix	+ "cntr_typ_1", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] cntrNo2 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_2", length));
			String[] cntrNo3 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_3", length));
			String[] cntrNo4 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_4", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cntrNo5 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_5", length));
			String[] cntrNo6 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_6", length));
			String[] cntrNo7 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_7", length));
			String[] cntrNo8 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_8", length));
			String[] cntrNo9 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_9", length));
			String[] trfRtAmt = (JSPUtil.getParameter(request, prefix	+ "trf_rt_amt", length));
			String[] cntrNo1 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_1", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo30 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_30", length));
			String[] cgoMeasQty = (JSPUtil.getParameter(request, prefix	+ "cgo_meas_qty", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] cntrNo28 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_28", length));
			String[] cntrNo29 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_29", length));
			String[] perTpCd = (JSPUtil.getParameter(request, prefix	+ "per_tp_cd", length));
			String[] invRefNo = (JSPUtil.getParameter(request, prefix	+ "inv_ref_no", length));
			String[] loclAmt = (JSPUtil.getParameter(request, prefix	+ "locl_amt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] bkgRefNo = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] cntrNo23 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_23", length));
			String[] cntrNo22 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_22", length));
			String[] cntrNo21 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_21", length));
			String[] cntrNo20 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_20", length));
			String[] cntrNo27 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_27", length));
			String[] cntrNo26 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_26", length));
			String[] ratAsCntrQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_cntr_qty", length));
			String[] cntrNo25 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_25", length));
			String[] cntrNo24 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_24", length));
			
			for (int i = 0; i < length; i++) {
				model = new DirectBillingInvoiceVO();
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (cntrNo18[i] != null)
					model.setCntrNo18(cntrNo18[i]);
				if (cntrNo17[i] != null)
					model.setCntrNo17(cntrNo17[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (cntrNo19[i] != null)
					model.setCntrNo19(cntrNo19[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrNo13[i] != null)
					model.setCntrNo13(cntrNo13[i]);
				if (cntrTyp12[i] != null)
					model.setCntrTyp12(cntrTyp12[i]);
				if (cntrNo14[i] != null)
					model.setCntrNo14(cntrNo14[i]);
				if (cntrTyp11[i] != null)
					model.setCntrTyp11(cntrTyp11[i]);
				if (cntrNo15[i] != null)
					model.setCntrNo15(cntrNo15[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cntrTyp10[i] != null)
					model.setCntrTyp10(cntrTyp10[i]);
				if (cntrNo16[i] != null)
					model.setCntrNo16(cntrNo16[i]);
				if (cntrTyp16[i] != null)
					model.setCntrTyp16(cntrTyp16[i]);
				if (cntrTyp15[i] != null)
					model.setCntrTyp15(cntrTyp15[i]);
				if (cntrNo10[i] != null)
					model.setCntrNo10(cntrNo10[i]);
				if (cntrTyp14[i] != null)
					model.setCntrTyp14(cntrTyp14[i]);
				if (cntrNo11[i] != null)
					model.setCntrNo11(cntrNo11[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTyp13[i] != null)
					model.setCntrTyp13(cntrTyp13[i]);
				if (cntrNo12[i] != null)
					model.setCntrNo12(cntrNo12[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (cntrTyp19[i] != null)
					model.setCntrTyp19(cntrTyp19[i]);
				if (cntrTyp18[i] != null)
					model.setCntrTyp18(cntrTyp18[i]);
				if (cntrTyp17[i] != null)
					model.setCntrTyp17(cntrTyp17[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				if (cntrTyp4[i] != null)
					model.setCntrTyp4(cntrTyp4[i]);
				if (cntrTyp5[i] != null)
					model.setCntrTyp5(cntrTyp5[i]);
				if (cntrTyp2[i] != null)
					model.setCntrTyp2(cntrTyp2[i]);
				if (cntrTyp3[i] != null)
					model.setCntrTyp3(cntrTyp3[i]);
				if (cntrTyp8[i] != null)
					model.setCntrTyp8(cntrTyp8[i]);
				if (cntrTyp9[i] != null)
					model.setCntrTyp9(cntrTyp9[i]);
				if (cntrTyp6[i] != null)
					model.setCntrTyp6(cntrTyp6[i]);
				if (cntrTyp7[i] != null)
					model.setCntrTyp7(cntrTyp7[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cntrTyp30[i] != null)
					model.setCntrTyp30(cntrTyp30[i]);
				if (cntrTyp21[i] != null)
					model.setCntrTyp21(cntrTyp21[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (cntrTyp20[i] != null)
					model.setCntrTyp20(cntrTyp20[i]);
				if (cntrTyp23[i] != null)
					model.setCntrTyp23(cntrTyp23[i]);
				if (cntrTyp22[i] != null)
					model.setCntrTyp22(cntrTyp22[i]);
				if (cntrTyp25[i] != null)
					model.setCntrTyp25(cntrTyp25[i]);
				if (cntrTyp24[i] != null)
					model.setCntrTyp24(cntrTyp24[i]);
				if (cntrTyp27[i] != null)
					model.setCntrTyp27(cntrTyp27[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (cntrTyp26[i] != null)
					model.setCntrTyp26(cntrTyp26[i]);
				if (cntrTyp29[i] != null)
					model.setCntrTyp29(cntrTyp29[i]);
				if (cntrTyp28[i] != null)
					model.setCntrTyp28(cntrTyp28[i]);
				if (cntrTyp1[i] != null)
					model.setCntrTyp1(cntrTyp1[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (cntrNo2[i] != null)
					model.setCntrNo2(cntrNo2[i]);
				if (cntrNo3[i] != null)
					model.setCntrNo3(cntrNo3[i]);
				if (cntrNo4[i] != null)
					model.setCntrNo4(cntrNo4[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cntrNo5[i] != null)
					model.setCntrNo5(cntrNo5[i]);
				if (cntrNo6[i] != null)
					model.setCntrNo6(cntrNo6[i]);
				if (cntrNo7[i] != null)
					model.setCntrNo7(cntrNo7[i]);
				if (cntrNo8[i] != null)
					model.setCntrNo8(cntrNo8[i]);
				if (cntrNo9[i] != null)
					model.setCntrNo9(cntrNo9[i]);
				if (trfRtAmt[i] != null)
					model.setTrfRtAmt(trfRtAmt[i]);
				if (cntrNo1[i] != null)
					model.setCntrNo1(cntrNo1[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo30[i] != null)
					model.setCntrNo30(cntrNo30[i]);
				if (cgoMeasQty[i] != null)
					model.setCgoMeasQty(cgoMeasQty[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (cntrNo28[i] != null)
					model.setCntrNo28(cntrNo28[i]);
				if (cntrNo29[i] != null)
					model.setCntrNo29(cntrNo29[i]);
				if (perTpCd[i] != null)
					model.setPerTpCd(perTpCd[i]);
				if (invRefNo[i] != null)
					model.setInvRefNo(invRefNo[i]);
				if (loclAmt[i] != null)
					model.setLoclAmt(loclAmt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (bkgRefNo[i] != null)
					model.setBkgRefNo(bkgRefNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (cntrNo23[i] != null)
					model.setCntrNo23(cntrNo23[i]);
				if (cntrNo22[i] != null)
					model.setCntrNo22(cntrNo22[i]);
				if (cntrNo21[i] != null)
					model.setCntrNo21(cntrNo21[i]);
				if (cntrNo20[i] != null)
					model.setCntrNo20(cntrNo20[i]);
				if (cntrNo27[i] != null)
					model.setCntrNo27(cntrNo27[i]);
				if (cntrNo26[i] != null)
					model.setCntrNo26(cntrNo26[i]);
				if (ratAsCntrQty[i] != null)
					model.setRatAsCntrQty(ratAsCntrQty[i]);
				if (cntrNo25[i] != null)
					model.setCntrNo25(cntrNo25[i]);
				if (cntrNo24[i] != null)
					model.setCntrNo24(cntrNo24[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDirectBillingInvoiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DirectBillingInvoiceVO[]
	 */
	public DirectBillingInvoiceVO[] getDirectBillingInvoiceVOs(){
		DirectBillingInvoiceVO[] vos = (DirectBillingInvoiceVO[])models.toArray(new DirectBillingInvoiceVO[models.size()]);
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
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo18 = this.cntrNo18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo17 = this.cntrNo17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo19 = this.cntrNo19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo13 = this.cntrNo13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp12 = this.cntrTyp12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo14 = this.cntrNo14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp11 = this.cntrTyp11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo15 = this.cntrNo15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp10 = this.cntrTyp10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo16 = this.cntrNo16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp16 = this.cntrTyp16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp15 = this.cntrTyp15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo10 = this.cntrNo10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp14 = this.cntrTyp14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo11 = this.cntrNo11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp13 = this.cntrTyp13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo12 = this.cntrNo12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp19 = this.cntrTyp19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp18 = this.cntrTyp18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp17 = this.cntrTyp17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp4 = this.cntrTyp4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp5 = this.cntrTyp5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp2 = this.cntrTyp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp3 = this.cntrTyp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp8 = this.cntrTyp8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp9 = this.cntrTyp9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp6 = this.cntrTyp6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp7 = this.cntrTyp7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp30 = this.cntrTyp30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp21 = this.cntrTyp21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp20 = this.cntrTyp20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp23 = this.cntrTyp23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp22 = this.cntrTyp22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp25 = this.cntrTyp25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp24 = this.cntrTyp24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp27 = this.cntrTyp27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp26 = this.cntrTyp26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp29 = this.cntrTyp29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp28 = this.cntrTyp28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTyp1 = this.cntrTyp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo2 = this.cntrNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo3 = this.cntrNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo4 = this.cntrNo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo5 = this.cntrNo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo6 = this.cntrNo6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo7 = this.cntrNo7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo8 = this.cntrNo8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo9 = this.cntrNo9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt = this.trfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo1 = this.cntrNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo30 = this.cntrNo30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoMeasQty = this.cgoMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo28 = this.cntrNo28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo29 = this.cntrNo29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTpCd = this.perTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo = this.invRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAmt = this.loclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo = this.bkgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo23 = this.cntrNo23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo22 = this.cntrNo22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo21 = this.cntrNo21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo20 = this.cntrNo20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo27 = this.cntrNo27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo26 = this.cntrNo26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsCntrQty = this.ratAsCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo25 = this.cntrNo25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo24 = this.cntrNo24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
