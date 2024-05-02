/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : HPEDISendVO.java
*@FileTitle : HPEDISendVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.20
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.01.20 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HPEDISendVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HPEDISendVO> models = new ArrayList<HPEDISendVO>();
	
	/* Column Info */
	private String cnRefPo = null;
	/* Column Info */
	private String vslPodFullname = null;
	/* Column Info */
	private String cnRefPt = null;
	/* Column Info */
	private String cgoRcvDt = null;
	/* Column Info */
	private String refPid = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String chFrtInd = null;
	/* Column Info */
	private String chRateString = null;
	/* Column Info */
	private String cntrShipId = null;
	/* Column Info */
	private String tariffSvcCd = null;
	/* Column Info */
	private String refAcb = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String vslFullname = null;
	/* Column Info */
	private String invNum = null;
	/* Column Info */
	private String finalEta = null;
	/* Column Info */
	private String vslOrigin = null;
	/* Column Info */
	private String custCity = null;
	/* Column Info */
	private String chRateCharge = null;
	/* Column Info */
	private String ref4g = null;
	/* Column Info */
	private String ref8x = null;
	/* Column Info */
	private String ref4l = null;
	/* Column Info */
	private String ref8v = null;
	/* Column Info */
	private String refF2 = null;
	/* Column Info */
	private String ref4m = null;
	/* Column Info */
	private String header = null;
	/* Column Info */
	private String vslPol = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chRate = null;
	/* Column Info */
	private String vslPoletd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String tsPre = null;
	/* Column Info */
	private String vslPod = null;
	/* Column Info */
	private String chPercent = null;
	/* Column Info */
	private String custName = null;
	/* Column Info */
	private String cntrLoad = null;
	/* Column Info */
	private String chBillCharge = null;
	/* Column Info */
	private String tsPost = null;
	/* Column Info */
	private String chRatedAs = null;
	/* Column Info */
	private String chCurCd = null;
	/* Column Info */
	private String locTpCd = null;
	/* Column Info */
	private String chBlRatedQty = null;
	/* Column Info */
	private String maxIfNo = null;
	/* Column Info */
	private String cmMea = null;
	/* Column Info */
	private String refT2 = null;
	/* Column Info */
	private String custName2 = null;
	/* Column Info */
	private String vslPor = null;
	/* Column Info */
	private String custName1 = null;
	/* Column Info */
	private String corInd = null;
	/* Column Info */
	private String incoTerm = null;
	/* Column Info */
	private String chExRate = null;
	/* Column Info */
	private String cmWgt = null;
	/* Column Info */
	private String locName = null;
	/* Column Info */
	private String currencyBillCd = null;
	/* Column Info */
	private String refVx = null;
	/* Column Info */
	private String chBlRatedQual = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnRefSi = null;
	/* Column Info */
	private String invType = null;
	/* Column Info */
	private String scacCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String refVc = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String vslPodetd = null;
	/* Column Info */
	private String vslBvvd1 = null;
	/* Column Info */
	private String custAddr1 = null;
	/* Column Info */
	private String refFr = null;
	/* Column Info */
	private String chPertype = null;
	/* Column Info */
	private String custPostal = null;
	/* Column Info */
	private String locCntName = null;
	/* Column Info */
	private String chCharge = null;
	/* Column Info */
	private String custState = null;
	/* Column Info */
	private String refBm = null;
	/* Column Info */
	private String blNum = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String refV9Des = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String cntrType = null;
	/* Column Info */
	private String chFctype = null;
	/* Column Info */
	private String locCntCd = null;
	/* Column Info */
	private String refUj = null;
	/* Column Info */
	private String vslPolFullname = null;
	/* Column Info */
	private String cmDesc = null;
	/* Column Info */
	private String vslLloydcode = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cmMeaCd = null;
	/* Column Info */
	private String vslDel = null;
	/* Column Info */
	private String cmPkgCd = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String cmPkg = null;
	/* Column Info */
	private String chBillCur = null;
	/* Column Info */
	private String refV9Ori = null;
	/* Column Info */
	private String cmWgtCd = null;
	/* Column Info */
	private String invPay = null;
	/* Column Info */
	private String invDate = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HPEDISendVO() {}

	public HPEDISendVO(String ibflag, String pagerows, String header, String invType, String invNum, String blNum, String invPay, String invDate, String invAmt, String finalEta, String scacCd, String corInd, String cgoRcvDt, String tariffSvcCd, String vvd, String vslLloydcode, String currencyBillCd, String ref4g, String ref4l, String ref4m, String ref8x, String refBm, String refF2, String refFr, String refT2, String refUj, String refVx, String ref8v, String refVc, String custTpCd, String custCd, String custName, String custName1, String custName2, String custAddr, String custAddr1, String custCity, String custState, String custPostal, String custCntCd, String locTpCd, String locCd, String locName, String locCntCd, String locCntName, String cntrNo, String cntrType, String cntrLoad, String cntrSealNo, String cntrShipId, String cnRefPo, String cnRefPt, String cnRefSi, String cmPkg, String cmPkgCd, String cmWgt, String cmWgtCd, String cmMea, String cmMeaCd, String cmDesc, String chFctype, String chRate, String chRatedAs, String chCharge, String chPertype, String chCurCd, String chBlRatedQty, String chBlRatedQual, String chPercent, String chFrtInd, String chBillCur, String chExRate, String vslBvvd1, String vslFullname, String vslOrigin, String vslPor, String vslPol, String vslPolFullname, String vslPod, String vslDel, String vslPodFullname, String vslPoletd, String vslPodetd, String bkgNo, String maxIfNo, String arOfcCd, String chRateCharge, String chBillCharge, String refAcb, String tsPre, String tsPost, String incoTerm, String refV9Ori, String refV9Des, String chRateString, String refPid) {
		this.cnRefPo = cnRefPo;
		this.vslPodFullname = vslPodFullname;
		this.cnRefPt = cnRefPt;
		this.cgoRcvDt = cgoRcvDt;
		this.refPid = refPid;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.chFrtInd = chFrtInd;
		this.chRateString = chRateString;
		this.cntrShipId = cntrShipId;
		this.tariffSvcCd = tariffSvcCd;
		this.refAcb = refAcb;
		this.custCntCd = custCntCd;
		this.vslFullname = vslFullname;
		this.invNum = invNum;
		this.finalEta = finalEta;
		this.vslOrigin = vslOrigin;
		this.custCity = custCity;
		this.chRateCharge = chRateCharge;
		this.ref4g = ref4g;
		this.ref8x = ref8x;
		this.ref4l = ref4l;
		this.ref8v = ref8v;
		this.refF2 = refF2;
		this.ref4m = ref4m;
		this.header = header;
		this.vslPol = vslPol;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.chRate = chRate;
		this.vslPoletd = vslPoletd;
		this.custCd = custCd;
		this.tsPre = tsPre;
		this.vslPod = vslPod;
		this.chPercent = chPercent;
		this.custName = custName;
		this.cntrLoad = cntrLoad;
		this.chBillCharge = chBillCharge;
		this.tsPost = tsPost;
		this.chRatedAs = chRatedAs;
		this.chCurCd = chCurCd;
		this.locTpCd = locTpCd;
		this.chBlRatedQty = chBlRatedQty;
		this.maxIfNo = maxIfNo;
		this.cmMea = cmMea;
		this.refT2 = refT2;
		this.custName2 = custName2;
		this.vslPor = vslPor;
		this.custName1 = custName1;
		this.corInd = corInd;
		this.incoTerm = incoTerm;
		this.chExRate = chExRate;
		this.cmWgt = cmWgt;
		this.locName = locName;
		this.currencyBillCd = currencyBillCd;
		this.refVx = refVx;
		this.chBlRatedQual = chBlRatedQual;
		this.ibflag = ibflag;
		this.cnRefSi = cnRefSi;
		this.invType = invType;
		this.scacCd = scacCd;
		this.invAmt = invAmt;
		this.refVc = refVc;
		this.custTpCd = custTpCd;
		this.vslPodetd = vslPodetd;
		this.vslBvvd1 = vslBvvd1;
		this.custAddr1 = custAddr1;
		this.refFr = refFr;
		this.chPertype = chPertype;
		this.custPostal = custPostal;
		this.locCntName = locCntName;
		this.chCharge = chCharge;
		this.custState = custState;
		this.refBm = refBm;
		this.blNum = blNum;
		this.custAddr = custAddr;
		this.refV9Des = refV9Des;
		this.arOfcCd = arOfcCd;
		this.cntrType = cntrType;
		this.chFctype = chFctype;
		this.locCntCd = locCntCd;
		this.refUj = refUj;
		this.vslPolFullname = vslPolFullname;
		this.cmDesc = cmDesc;
		this.vslLloydcode = vslLloydcode;
		this.cntrNo = cntrNo;
		this.cmMeaCd = cmMeaCd;
		this.vslDel = vslDel;
		this.cmPkgCd = cmPkgCd;
		this.cntrSealNo = cntrSealNo;
		this.cmPkg = cmPkg;
		this.chBillCur = chBillCur;
		this.refV9Ori = refV9Ori;
		this.cmWgtCd = cmWgtCd;
		this.invPay = invPay;
		this.invDate = invDate;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cn_ref_po", getCnRefPo());
		this.hashColumns.put("vsl_pod_fullname", getVslPodFullname());
		this.hashColumns.put("cn_ref_pt", getCnRefPt());
		this.hashColumns.put("cgo_rcv_dt", getCgoRcvDt());
		this.hashColumns.put("ref_pid", getRefPid());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ch_frt_ind", getChFrtInd());
		this.hashColumns.put("ch_rate_string", getChRateString());
		this.hashColumns.put("cntr_ship_id", getCntrShipId());
		this.hashColumns.put("tariff_svc_cd", getTariffSvcCd());
		this.hashColumns.put("ref_acb", getRefAcb());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("vsl_fullname", getVslFullname());
		this.hashColumns.put("inv_num", getInvNum());
		this.hashColumns.put("final_eta", getFinalEta());
		this.hashColumns.put("vsl_origin", getVslOrigin());
		this.hashColumns.put("cust_city", getCustCity());
		this.hashColumns.put("ch_rate_charge", getChRateCharge());
		this.hashColumns.put("ref_4g", getRef4g());
		this.hashColumns.put("ref_8x", getRef8x());
		this.hashColumns.put("ref_4l", getRef4l());
		this.hashColumns.put("ref_8v", getRef8v());
		this.hashColumns.put("ref_f2", getRefF2());
		this.hashColumns.put("ref_4m", getRef4m());
		this.hashColumns.put("header", getHeader());
		this.hashColumns.put("vsl_pol", getVslPol());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ch_rate", getChRate());
		this.hashColumns.put("vsl_poletd", getVslPoletd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("ts_pre", getTsPre());
		this.hashColumns.put("vsl_pod", getVslPod());
		this.hashColumns.put("ch_percent", getChPercent());
		this.hashColumns.put("cust_name", getCustName());
		this.hashColumns.put("cntr_load", getCntrLoad());
		this.hashColumns.put("ch_bill_charge", getChBillCharge());
		this.hashColumns.put("ts_post", getTsPost());
		this.hashColumns.put("ch_rated_as", getChRatedAs());
		this.hashColumns.put("ch_cur_cd", getChCurCd());
		this.hashColumns.put("loc_tp_cd", getLocTpCd());
		this.hashColumns.put("ch_bl_rated_qty", getChBlRatedQty());
		this.hashColumns.put("max_if_no", getMaxIfNo());
		this.hashColumns.put("cm_mea", getCmMea());
		this.hashColumns.put("ref_t2", getRefT2());
		this.hashColumns.put("cust_name2", getCustName2());
		this.hashColumns.put("vsl_por", getVslPor());
		this.hashColumns.put("cust_name1", getCustName1());
		this.hashColumns.put("cor_ind", getCorInd());
		this.hashColumns.put("inco_term", getIncoTerm());
		this.hashColumns.put("ch_ex_rate", getChExRate());
		this.hashColumns.put("cm_wgt", getCmWgt());
		this.hashColumns.put("loc_name", getLocName());
		this.hashColumns.put("currency_bill_cd", getCurrencyBillCd());
		this.hashColumns.put("ref_vx", getRefVx());
		this.hashColumns.put("ch_bl_rated_qual", getChBlRatedQual());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cn_ref_si", getCnRefSi());
		this.hashColumns.put("inv_type", getInvType());
		this.hashColumns.put("scac_cd", getScacCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("ref_vc", getRefVc());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("vsl_podetd", getVslPodetd());
		this.hashColumns.put("vsl_bvvd1", getVslBvvd1());
		this.hashColumns.put("cust_addr1", getCustAddr1());
		this.hashColumns.put("ref_fr", getRefFr());
		this.hashColumns.put("ch_pertype", getChPertype());
		this.hashColumns.put("cust_postal", getCustPostal());
		this.hashColumns.put("loc_cnt_name", getLocCntName());
		this.hashColumns.put("ch_charge", getChCharge());
		this.hashColumns.put("cust_state", getCustState());
		this.hashColumns.put("ref_bm", getRefBm());
		this.hashColumns.put("bl_num", getBlNum());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("ref_v9_des", getRefV9Des());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("ch_fctype", getChFctype());
		this.hashColumns.put("loc_cnt_cd", getLocCntCd());
		this.hashColumns.put("ref_uj", getRefUj());
		this.hashColumns.put("vsl_pol_fullname", getVslPolFullname());
		this.hashColumns.put("cm_desc", getCmDesc());
		this.hashColumns.put("vsl_lloydcode", getVslLloydcode());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cm_mea_cd", getCmMeaCd());
		this.hashColumns.put("vsl_del", getVslDel());
		this.hashColumns.put("cm_pkg_cd", getCmPkgCd());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("cm_pkg", getCmPkg());
		this.hashColumns.put("ch_bill_cur", getChBillCur());
		this.hashColumns.put("ref_v9_ori", getRefV9Ori());
		this.hashColumns.put("cm_wgt_cd", getCmWgtCd());
		this.hashColumns.put("inv_pay", getInvPay());
		this.hashColumns.put("inv_date", getInvDate());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cn_ref_po", "cnRefPo");
		this.hashFields.put("vsl_pod_fullname", "vslPodFullname");
		this.hashFields.put("cn_ref_pt", "cnRefPt");
		this.hashFields.put("cgo_rcv_dt", "cgoRcvDt");
		this.hashFields.put("ref_pid", "refPid");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ch_frt_ind", "chFrtInd");
		this.hashFields.put("ch_rate_string", "chRateString");
		this.hashFields.put("cntr_ship_id", "cntrShipId");
		this.hashFields.put("tariff_svc_cd", "tariffSvcCd");
		this.hashFields.put("ref_acb", "refAcb");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("vsl_fullname", "vslFullname");
		this.hashFields.put("inv_num", "invNum");
		this.hashFields.put("final_eta", "finalEta");
		this.hashFields.put("vsl_origin", "vslOrigin");
		this.hashFields.put("cust_city", "custCity");
		this.hashFields.put("ch_rate_charge", "chRateCharge");
		this.hashFields.put("ref_4g", "ref4g");
		this.hashFields.put("ref_8x", "ref8x");
		this.hashFields.put("ref_4l", "ref4l");
		this.hashFields.put("ref_8v", "ref8v");
		this.hashFields.put("ref_f2", "refF2");
		this.hashFields.put("ref_4m", "ref4m");
		this.hashFields.put("header", "header");
		this.hashFields.put("vsl_pol", "vslPol");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ch_rate", "chRate");
		this.hashFields.put("vsl_poletd", "vslPoletd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("ts_pre", "tsPre");
		this.hashFields.put("vsl_pod", "vslPod");
		this.hashFields.put("ch_percent", "chPercent");
		this.hashFields.put("cust_name", "custName");
		this.hashFields.put("cntr_load", "cntrLoad");
		this.hashFields.put("ch_bill_charge", "chBillCharge");
		this.hashFields.put("ts_post", "tsPost");
		this.hashFields.put("ch_rated_as", "chRatedAs");
		this.hashFields.put("ch_cur_cd", "chCurCd");
		this.hashFields.put("loc_tp_cd", "locTpCd");
		this.hashFields.put("ch_bl_rated_qty", "chBlRatedQty");
		this.hashFields.put("max_if_no", "maxIfNo");
		this.hashFields.put("cm_mea", "cmMea");
		this.hashFields.put("ref_t2", "refT2");
		this.hashFields.put("cust_name2", "custName2");
		this.hashFields.put("vsl_por", "vslPor");
		this.hashFields.put("cust_name1", "custName1");
		this.hashFields.put("cor_ind", "corInd");
		this.hashFields.put("inco_term", "incoTerm");
		this.hashFields.put("ch_ex_rate", "chExRate");
		this.hashFields.put("cm_wgt", "cmWgt");
		this.hashFields.put("loc_name", "locName");
		this.hashFields.put("currency_bill_cd", "currencyBillCd");
		this.hashFields.put("ref_vx", "refVx");
		this.hashFields.put("ch_bl_rated_qual", "chBlRatedQual");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cn_ref_si", "cnRefSi");
		this.hashFields.put("inv_type", "invType");
		this.hashFields.put("scac_cd", "scacCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("ref_vc", "refVc");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("vsl_podetd", "vslPodetd");
		this.hashFields.put("vsl_bvvd1", "vslBvvd1");
		this.hashFields.put("cust_addr1", "custAddr1");
		this.hashFields.put("ref_fr", "refFr");
		this.hashFields.put("ch_pertype", "chPertype");
		this.hashFields.put("cust_postal", "custPostal");
		this.hashFields.put("loc_cnt_name", "locCntName");
		this.hashFields.put("ch_charge", "chCharge");
		this.hashFields.put("cust_state", "custState");
		this.hashFields.put("ref_bm", "refBm");
		this.hashFields.put("bl_num", "blNum");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("ref_v9_des", "refV9Des");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("ch_fctype", "chFctype");
		this.hashFields.put("loc_cnt_cd", "locCntCd");
		this.hashFields.put("ref_uj", "refUj");
		this.hashFields.put("vsl_pol_fullname", "vslPolFullname");
		this.hashFields.put("cm_desc", "cmDesc");
		this.hashFields.put("vsl_lloydcode", "vslLloydcode");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cm_mea_cd", "cmMeaCd");
		this.hashFields.put("vsl_del", "vslDel");
		this.hashFields.put("cm_pkg_cd", "cmPkgCd");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("cm_pkg", "cmPkg");
		this.hashFields.put("ch_bill_cur", "chBillCur");
		this.hashFields.put("ref_v9_ori", "refV9Ori");
		this.hashFields.put("cm_wgt_cd", "cmWgtCd");
		this.hashFields.put("inv_pay", "invPay");
		this.hashFields.put("inv_date", "invDate");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cnRefPo
	 */
	public String getCnRefPo() {
		return this.cnRefPo;
	}
	
	/**
	 * Column Info
	 * @return vslPodFullname
	 */
	public String getVslPodFullname() {
		return this.vslPodFullname;
	}
	
	/**
	 * Column Info
	 * @return cnRefPt
	 */
	public String getCnRefPt() {
		return this.cnRefPt;
	}
	
	/**
	 * Column Info
	 * @return cgoRcvDt
	 */
	public String getCgoRcvDt() {
		return this.cgoRcvDt;
	}
	
	/**
	 * Column Info
	 * @return refPid
	 */
	public String getRefPid() {
		return this.refPid;
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
	 * @return chFrtInd
	 */
	public String getChFrtInd() {
		return this.chFrtInd;
	}
	
	/**
	 * Column Info
	 * @return chRateString
	 */
	public String getChRateString() {
		return this.chRateString;
	}
	
	/**
	 * Column Info
	 * @return cntrShipId
	 */
	public String getCntrShipId() {
		return this.cntrShipId;
	}
	
	/**
	 * Column Info
	 * @return tariffSvcCd
	 */
	public String getTariffSvcCd() {
		return this.tariffSvcCd;
	}
	
	/**
	 * Column Info
	 * @return refAcb
	 */
	public String getRefAcb() {
		return this.refAcb;
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
	 * @return vslFullname
	 */
	public String getVslFullname() {
		return this.vslFullname;
	}
	
	/**
	 * Column Info
	 * @return invNum
	 */
	public String getInvNum() {
		return this.invNum;
	}
	
	/**
	 * Column Info
	 * @return finalEta
	 */
	public String getFinalEta() {
		return this.finalEta;
	}
	
	/**
	 * Column Info
	 * @return vslOrigin
	 */
	public String getVslOrigin() {
		return this.vslOrigin;
	}
	
	/**
	 * Column Info
	 * @return custCity
	 */
	public String getCustCity() {
		return this.custCity;
	}
	
	/**
	 * Column Info
	 * @return chRateCharge
	 */
	public String getChRateCharge() {
		return this.chRateCharge;
	}
	
	/**
	 * Column Info
	 * @return ref4g
	 */
	public String getRef4g() {
		return this.ref4g;
	}
	
	/**
	 * Column Info
	 * @return ref8x
	 */
	public String getRef8x() {
		return this.ref8x;
	}
	
	/**
	 * Column Info
	 * @return ref4l
	 */
	public String getRef4l() {
		return this.ref4l;
	}
	
	/**
	 * Column Info
	 * @return ref8v
	 */
	public String getRef8v() {
		return this.ref8v;
	}
	
	/**
	 * Column Info
	 * @return refF2
	 */
	public String getRefF2() {
		return this.refF2;
	}
	
	/**
	 * Column Info
	 * @return ref4m
	 */
	public String getRef4m() {
		return this.ref4m;
	}
	
	/**
	 * Column Info
	 * @return header
	 */
	public String getHeader() {
		return this.header;
	}
	
	/**
	 * Column Info
	 * @return vslPol
	 */
	public String getVslPol() {
		return this.vslPol;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return chRate
	 */
	public String getChRate() {
		return this.chRate;
	}
	
	/**
	 * Column Info
	 * @return vslPoletd
	 */
	public String getVslPoletd() {
		return this.vslPoletd;
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
	 * @return tsPre
	 */
	public String getTsPre() {
		return this.tsPre;
	}
	
	/**
	 * Column Info
	 * @return vslPod
	 */
	public String getVslPod() {
		return this.vslPod;
	}
	
	/**
	 * Column Info
	 * @return chPercent
	 */
	public String getChPercent() {
		return this.chPercent;
	}
	
	/**
	 * Column Info
	 * @return custName
	 */
	public String getCustName() {
		return this.custName;
	}
	
	/**
	 * Column Info
	 * @return cntrLoad
	 */
	public String getCntrLoad() {
		return this.cntrLoad;
	}
	
	/**
	 * Column Info
	 * @return chBillCharge
	 */
	public String getChBillCharge() {
		return this.chBillCharge;
	}
	
	/**
	 * Column Info
	 * @return tsPost
	 */
	public String getTsPost() {
		return this.tsPost;
	}
	
	/**
	 * Column Info
	 * @return chRatedAs
	 */
	public String getChRatedAs() {
		return this.chRatedAs;
	}
	
	/**
	 * Column Info
	 * @return chCurCd
	 */
	public String getChCurCd() {
		return this.chCurCd;
	}
	
	/**
	 * Column Info
	 * @return locTpCd
	 */
	public String getLocTpCd() {
		return this.locTpCd;
	}
	
	/**
	 * Column Info
	 * @return chBlRatedQty
	 */
	public String getChBlRatedQty() {
		return this.chBlRatedQty;
	}
	
	/**
	 * Column Info
	 * @return maxIfNo
	 */
	public String getMaxIfNo() {
		return this.maxIfNo;
	}
	
	/**
	 * Column Info
	 * @return cmMea
	 */
	public String getCmMea() {
		return this.cmMea;
	}
	
	/**
	 * Column Info
	 * @return refT2
	 */
	public String getRefT2() {
		return this.refT2;
	}
	
	/**
	 * Column Info
	 * @return custName2
	 */
	public String getCustName2() {
		return this.custName2;
	}
	
	/**
	 * Column Info
	 * @return vslPor
	 */
	public String getVslPor() {
		return this.vslPor;
	}
	
	/**
	 * Column Info
	 * @return custName1
	 */
	public String getCustName1() {
		return this.custName1;
	}
	
	/**
	 * Column Info
	 * @return corInd
	 */
	public String getCorInd() {
		return this.corInd;
	}
	
	/**
	 * Column Info
	 * @return incoTerm
	 */
	public String getIncoTerm() {
		return this.incoTerm;
	}
	
	/**
	 * Column Info
	 * @return chExRate
	 */
	public String getChExRate() {
		return this.chExRate;
	}
	
	/**
	 * Column Info
	 * @return cmWgt
	 */
	public String getCmWgt() {
		return this.cmWgt;
	}
	
	/**
	 * Column Info
	 * @return locName
	 */
	public String getLocName() {
		return this.locName;
	}
	
	/**
	 * Column Info
	 * @return currencyBillCd
	 */
	public String getCurrencyBillCd() {
		return this.currencyBillCd;
	}
	
	/**
	 * Column Info
	 * @return refVx
	 */
	public String getRefVx() {
		return this.refVx;
	}
	
	/**
	 * Column Info
	 * @return chBlRatedQual
	 */
	public String getChBlRatedQual() {
		return this.chBlRatedQual;
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
	 * @return cnRefSi
	 */
	public String getCnRefSi() {
		return this.cnRefSi;
	}
	
	/**
	 * Column Info
	 * @return invType
	 */
	public String getInvType() {
		return this.invType;
	}
	
	/**
	 * Column Info
	 * @return scacCd
	 */
	public String getScacCd() {
		return this.scacCd;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return refVc
	 */
	public String getRefVc() {
		return this.refVc;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslPodetd
	 */
	public String getVslPodetd() {
		return this.vslPodetd;
	}
	
	/**
	 * Column Info
	 * @return vslBvvd1
	 */
	public String getVslBvvd1() {
		return this.vslBvvd1;
	}
	
	/**
	 * Column Info
	 * @return custAddr1
	 */
	public String getCustAddr1() {
		return this.custAddr1;
	}
	
	/**
	 * Column Info
	 * @return refFr
	 */
	public String getRefFr() {
		return this.refFr;
	}
	
	/**
	 * Column Info
	 * @return chPertype
	 */
	public String getChPertype() {
		return this.chPertype;
	}
	
	/**
	 * Column Info
	 * @return custPostal
	 */
	public String getCustPostal() {
		return this.custPostal;
	}
	
	/**
	 * Column Info
	 * @return locCntName
	 */
	public String getLocCntName() {
		return this.locCntName;
	}
	
	/**
	 * Column Info
	 * @return chCharge
	 */
	public String getChCharge() {
		return this.chCharge;
	}
	
	/**
	 * Column Info
	 * @return custState
	 */
	public String getCustState() {
		return this.custState;
	}
	
	/**
	 * Column Info
	 * @return refBm
	 */
	public String getRefBm() {
		return this.refBm;
	}
	
	/**
	 * Column Info
	 * @return blNum
	 */
	public String getBlNum() {
		return this.blNum;
	}
	
	/**
	 * Column Info
	 * @return custAddr
	 */
	public String getCustAddr() {
		return this.custAddr;
	}
	
	/**
	 * Column Info
	 * @return refV9Des
	 */
	public String getRefV9Des() {
		return this.refV9Des;
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
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
	}
	
	/**
	 * Column Info
	 * @return chFctype
	 */
	public String getChFctype() {
		return this.chFctype;
	}
	
	/**
	 * Column Info
	 * @return locCntCd
	 */
	public String getLocCntCd() {
		return this.locCntCd;
	}
	
	/**
	 * Column Info
	 * @return refUj
	 */
	public String getRefUj() {
		return this.refUj;
	}
	
	/**
	 * Column Info
	 * @return vslPolFullname
	 */
	public String getVslPolFullname() {
		return this.vslPolFullname;
	}
	
	/**
	 * Column Info
	 * @return cmDesc
	 */
	public String getCmDesc() {
		return this.cmDesc;
	}
	
	/**
	 * Column Info
	 * @return vslLloydcode
	 */
	public String getVslLloydcode() {
		return this.vslLloydcode;
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
	 * @return cmMeaCd
	 */
	public String getCmMeaCd() {
		return this.cmMeaCd;
	}
	
	/**
	 * Column Info
	 * @return vslDel
	 */
	public String getVslDel() {
		return this.vslDel;
	}
	
	/**
	 * Column Info
	 * @return cmPkgCd
	 */
	public String getCmPkgCd() {
		return this.cmPkgCd;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return cmPkg
	 */
	public String getCmPkg() {
		return this.cmPkg;
	}
	
	/**
	 * Column Info
	 * @return chBillCur
	 */
	public String getChBillCur() {
		return this.chBillCur;
	}
	
	/**
	 * Column Info
	 * @return refV9Ori
	 */
	public String getRefV9Ori() {
		return this.refV9Ori;
	}
	
	/**
	 * Column Info
	 * @return cmWgtCd
	 */
	public String getCmWgtCd() {
		return this.cmWgtCd;
	}
	
	/**
	 * Column Info
	 * @return invPay
	 */
	public String getInvPay() {
		return this.invPay;
	}
	
	/**
	 * Column Info
	 * @return invDate
	 */
	public String getInvDate() {
		return this.invDate;
	}
	

	/**
	 * Column Info
	 * @param cnRefPo
	 */
	public void setCnRefPo(String cnRefPo) {
		this.cnRefPo = cnRefPo;
	}
	
	/**
	 * Column Info
	 * @param vslPodFullname
	 */
	public void setVslPodFullname(String vslPodFullname) {
		this.vslPodFullname = vslPodFullname;
	}
	
	/**
	 * Column Info
	 * @param cnRefPt
	 */
	public void setCnRefPt(String cnRefPt) {
		this.cnRefPt = cnRefPt;
	}
	
	/**
	 * Column Info
	 * @param cgoRcvDt
	 */
	public void setCgoRcvDt(String cgoRcvDt) {
		this.cgoRcvDt = cgoRcvDt;
	}
	
	/**
	 * Column Info
	 * @param refPid
	 */
	public void setRefPid(String refPid) {
		this.refPid = refPid;
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
	 * @param chFrtInd
	 */
	public void setChFrtInd(String chFrtInd) {
		this.chFrtInd = chFrtInd;
	}
	
	/**
	 * Column Info
	 * @param chRateString
	 */
	public void setChRateString(String chRateString) {
		this.chRateString = chRateString;
	}
	
	/**
	 * Column Info
	 * @param cntrShipId
	 */
	public void setCntrShipId(String cntrShipId) {
		this.cntrShipId = cntrShipId;
	}
	
	/**
	 * Column Info
	 * @param tariffSvcCd
	 */
	public void setTariffSvcCd(String tariffSvcCd) {
		this.tariffSvcCd = tariffSvcCd;
	}
	
	/**
	 * Column Info
	 * @param refAcb
	 */
	public void setRefAcb(String refAcb) {
		this.refAcb = refAcb;
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
	 * @param vslFullname
	 */
	public void setVslFullname(String vslFullname) {
		this.vslFullname = vslFullname;
	}
	
	/**
	 * Column Info
	 * @param invNum
	 */
	public void setInvNum(String invNum) {
		this.invNum = invNum;
	}
	
	/**
	 * Column Info
	 * @param finalEta
	 */
	public void setFinalEta(String finalEta) {
		this.finalEta = finalEta;
	}
	
	/**
	 * Column Info
	 * @param vslOrigin
	 */
	public void setVslOrigin(String vslOrigin) {
		this.vslOrigin = vslOrigin;
	}
	
	/**
	 * Column Info
	 * @param custCity
	 */
	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}
	
	/**
	 * Column Info
	 * @param chRateCharge
	 */
	public void setChRateCharge(String chRateCharge) {
		this.chRateCharge = chRateCharge;
	}
	
	/**
	 * Column Info
	 * @param ref4g
	 */
	public void setRef4g(String ref4g) {
		this.ref4g = ref4g;
	}
	
	/**
	 * Column Info
	 * @param ref8x
	 */
	public void setRef8x(String ref8x) {
		this.ref8x = ref8x;
	}
	
	/**
	 * Column Info
	 * @param ref4l
	 */
	public void setRef4l(String ref4l) {
		this.ref4l = ref4l;
	}
	
	/**
	 * Column Info
	 * @param ref8v
	 */
	public void setRef8v(String ref8v) {
		this.ref8v = ref8v;
	}
	
	/**
	 * Column Info
	 * @param refF2
	 */
	public void setRefF2(String refF2) {
		this.refF2 = refF2;
	}
	
	/**
	 * Column Info
	 * @param ref4m
	 */
	public void setRef4m(String ref4m) {
		this.ref4m = ref4m;
	}
	
	/**
	 * Column Info
	 * @param header
	 */
	public void setHeader(String header) {
		this.header = header;
	}
	
	/**
	 * Column Info
	 * @param vslPol
	 */
	public void setVslPol(String vslPol) {
		this.vslPol = vslPol;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param chRate
	 */
	public void setChRate(String chRate) {
		this.chRate = chRate;
	}
	
	/**
	 * Column Info
	 * @param vslPoletd
	 */
	public void setVslPoletd(String vslPoletd) {
		this.vslPoletd = vslPoletd;
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
	 * @param tsPre
	 */
	public void setTsPre(String tsPre) {
		this.tsPre = tsPre;
	}
	
	/**
	 * Column Info
	 * @param vslPod
	 */
	public void setVslPod(String vslPod) {
		this.vslPod = vslPod;
	}
	
	/**
	 * Column Info
	 * @param chPercent
	 */
	public void setChPercent(String chPercent) {
		this.chPercent = chPercent;
	}
	
	/**
	 * Column Info
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	/**
	 * Column Info
	 * @param cntrLoad
	 */
	public void setCntrLoad(String cntrLoad) {
		this.cntrLoad = cntrLoad;
	}
	
	/**
	 * Column Info
	 * @param chBillCharge
	 */
	public void setChBillCharge(String chBillCharge) {
		this.chBillCharge = chBillCharge;
	}
	
	/**
	 * Column Info
	 * @param tsPost
	 */
	public void setTsPost(String tsPost) {
		this.tsPost = tsPost;
	}
	
	/**
	 * Column Info
	 * @param chRatedAs
	 */
	public void setChRatedAs(String chRatedAs) {
		this.chRatedAs = chRatedAs;
	}
	
	/**
	 * Column Info
	 * @param chCurCd
	 */
	public void setChCurCd(String chCurCd) {
		this.chCurCd = chCurCd;
	}
	
	/**
	 * Column Info
	 * @param locTpCd
	 */
	public void setLocTpCd(String locTpCd) {
		this.locTpCd = locTpCd;
	}
	
	/**
	 * Column Info
	 * @param chBlRatedQty
	 */
	public void setChBlRatedQty(String chBlRatedQty) {
		this.chBlRatedQty = chBlRatedQty;
	}
	
	/**
	 * Column Info
	 * @param maxIfNo
	 */
	public void setMaxIfNo(String maxIfNo) {
		this.maxIfNo = maxIfNo;
	}
	
	/**
	 * Column Info
	 * @param cmMea
	 */
	public void setCmMea(String cmMea) {
		this.cmMea = cmMea;
	}
	
	/**
	 * Column Info
	 * @param refT2
	 */
	public void setRefT2(String refT2) {
		this.refT2 = refT2;
	}
	
	/**
	 * Column Info
	 * @param custName2
	 */
	public void setCustName2(String custName2) {
		this.custName2 = custName2;
	}
	
	/**
	 * Column Info
	 * @param vslPor
	 */
	public void setVslPor(String vslPor) {
		this.vslPor = vslPor;
	}
	
	/**
	 * Column Info
	 * @param custName1
	 */
	public void setCustName1(String custName1) {
		this.custName1 = custName1;
	}
	
	/**
	 * Column Info
	 * @param corInd
	 */
	public void setCorInd(String corInd) {
		this.corInd = corInd;
	}
	
	/**
	 * Column Info
	 * @param incoTerm
	 */
	public void setIncoTerm(String incoTerm) {
		this.incoTerm = incoTerm;
	}
	
	/**
	 * Column Info
	 * @param chExRate
	 */
	public void setChExRate(String chExRate) {
		this.chExRate = chExRate;
	}
	
	/**
	 * Column Info
	 * @param cmWgt
	 */
	public void setCmWgt(String cmWgt) {
		this.cmWgt = cmWgt;
	}
	
	/**
	 * Column Info
	 * @param locName
	 */
	public void setLocName(String locName) {
		this.locName = locName;
	}
	
	/**
	 * Column Info
	 * @param currencyBillCd
	 */
	public void setCurrencyBillCd(String currencyBillCd) {
		this.currencyBillCd = currencyBillCd;
	}
	
	/**
	 * Column Info
	 * @param refVx
	 */
	public void setRefVx(String refVx) {
		this.refVx = refVx;
	}
	
	/**
	 * Column Info
	 * @param chBlRatedQual
	 */
	public void setChBlRatedQual(String chBlRatedQual) {
		this.chBlRatedQual = chBlRatedQual;
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
	 * @param cnRefSi
	 */
	public void setCnRefSi(String cnRefSi) {
		this.cnRefSi = cnRefSi;
	}
	
	/**
	 * Column Info
	 * @param invType
	 */
	public void setInvType(String invType) {
		this.invType = invType;
	}
	
	/**
	 * Column Info
	 * @param scacCd
	 */
	public void setScacCd(String scacCd) {
		this.scacCd = scacCd;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param refVc
	 */
	public void setRefVc(String refVc) {
		this.refVc = refVc;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslPodetd
	 */
	public void setVslPodetd(String vslPodetd) {
		this.vslPodetd = vslPodetd;
	}
	
	/**
	 * Column Info
	 * @param vslBvvd1
	 */
	public void setVslBvvd1(String vslBvvd1) {
		this.vslBvvd1 = vslBvvd1;
	}
	
	/**
	 * Column Info
	 * @param custAddr1
	 */
	public void setCustAddr1(String custAddr1) {
		this.custAddr1 = custAddr1;
	}
	
	/**
	 * Column Info
	 * @param refFr
	 */
	public void setRefFr(String refFr) {
		this.refFr = refFr;
	}
	
	/**
	 * Column Info
	 * @param chPertype
	 */
	public void setChPertype(String chPertype) {
		this.chPertype = chPertype;
	}
	
	/**
	 * Column Info
	 * @param custPostal
	 */
	public void setCustPostal(String custPostal) {
		this.custPostal = custPostal;
	}
	
	/**
	 * Column Info
	 * @param locCntName
	 */
	public void setLocCntName(String locCntName) {
		this.locCntName = locCntName;
	}
	
	/**
	 * Column Info
	 * @param chCharge
	 */
	public void setChCharge(String chCharge) {
		this.chCharge = chCharge;
	}
	
	/**
	 * Column Info
	 * @param custState
	 */
	public void setCustState(String custState) {
		this.custState = custState;
	}
	
	/**
	 * Column Info
	 * @param refBm
	 */
	public void setRefBm(String refBm) {
		this.refBm = refBm;
	}
	
	/**
	 * Column Info
	 * @param blNum
	 */
	public void setBlNum(String blNum) {
		this.blNum = blNum;
	}
	
	/**
	 * Column Info
	 * @param custAddr
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	
	/**
	 * Column Info
	 * @param refV9Des
	 */
	public void setRefV9Des(String refV9Des) {
		this.refV9Des = refV9Des;
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
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
	}
	
	/**
	 * Column Info
	 * @param chFctype
	 */
	public void setChFctype(String chFctype) {
		this.chFctype = chFctype;
	}
	
	/**
	 * Column Info
	 * @param locCntCd
	 */
	public void setLocCntCd(String locCntCd) {
		this.locCntCd = locCntCd;
	}
	
	/**
	 * Column Info
	 * @param refUj
	 */
	public void setRefUj(String refUj) {
		this.refUj = refUj;
	}
	
	/**
	 * Column Info
	 * @param vslPolFullname
	 */
	public void setVslPolFullname(String vslPolFullname) {
		this.vslPolFullname = vslPolFullname;
	}
	
	/**
	 * Column Info
	 * @param cmDesc
	 */
	public void setCmDesc(String cmDesc) {
		this.cmDesc = cmDesc;
	}
	
	/**
	 * Column Info
	 * @param vslLloydcode
	 */
	public void setVslLloydcode(String vslLloydcode) {
		this.vslLloydcode = vslLloydcode;
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
	 * @param cmMeaCd
	 */
	public void setCmMeaCd(String cmMeaCd) {
		this.cmMeaCd = cmMeaCd;
	}
	
	/**
	 * Column Info
	 * @param vslDel
	 */
	public void setVslDel(String vslDel) {
		this.vslDel = vslDel;
	}
	
	/**
	 * Column Info
	 * @param cmPkgCd
	 */
	public void setCmPkgCd(String cmPkgCd) {
		this.cmPkgCd = cmPkgCd;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param cmPkg
	 */
	public void setCmPkg(String cmPkg) {
		this.cmPkg = cmPkg;
	}
	
	/**
	 * Column Info
	 * @param chBillCur
	 */
	public void setChBillCur(String chBillCur) {
		this.chBillCur = chBillCur;
	}
	
	/**
	 * Column Info
	 * @param refV9Ori
	 */
	public void setRefV9Ori(String refV9Ori) {
		this.refV9Ori = refV9Ori;
	}
	
	/**
	 * Column Info
	 * @param cmWgtCd
	 */
	public void setCmWgtCd(String cmWgtCd) {
		this.cmWgtCd = cmWgtCd;
	}
	
	/**
	 * Column Info
	 * @param invPay
	 */
	public void setInvPay(String invPay) {
		this.invPay = invPay;
	}
	
	/**
	 * Column Info
	 * @param invDate
	 */
	public void setInvDate(String invDate) {
		this.invDate = invDate;
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
		setCnRefPo(JSPUtil.getParameter(request, prefix + "cn_ref_po", ""));
		setVslPodFullname(JSPUtil.getParameter(request, prefix + "vsl_pod_fullname", ""));
		setCnRefPt(JSPUtil.getParameter(request, prefix + "cn_ref_pt", ""));
		setCgoRcvDt(JSPUtil.getParameter(request, prefix + "cgo_rcv_dt", ""));
		setRefPid(JSPUtil.getParameter(request, prefix + "ref_pid", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setChFrtInd(JSPUtil.getParameter(request, prefix + "ch_frt_ind", ""));
		setChRateString(JSPUtil.getParameter(request, prefix + "ch_rate_string", ""));
		setCntrShipId(JSPUtil.getParameter(request, prefix + "cntr_ship_id", ""));
		setTariffSvcCd(JSPUtil.getParameter(request, prefix + "tariff_svc_cd", ""));
		setRefAcb(JSPUtil.getParameter(request, prefix + "ref_acb", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setVslFullname(JSPUtil.getParameter(request, prefix + "vsl_fullname", ""));
		setInvNum(JSPUtil.getParameter(request, prefix + "inv_num", ""));
		setFinalEta(JSPUtil.getParameter(request, prefix + "final_eta", ""));
		setVslOrigin(JSPUtil.getParameter(request, prefix + "vsl_origin", ""));
		setCustCity(JSPUtil.getParameter(request, prefix + "cust_city", ""));
		setChRateCharge(JSPUtil.getParameter(request, prefix + "ch_rate_charge", ""));
		setRef4g(JSPUtil.getParameter(request, prefix + "ref_4g", ""));
		setRef8x(JSPUtil.getParameter(request, prefix + "ref_8x", ""));
		setRef4l(JSPUtil.getParameter(request, prefix + "ref_4l", ""));
		setRef8v(JSPUtil.getParameter(request, prefix + "ref_8v", ""));
		setRefF2(JSPUtil.getParameter(request, prefix + "ref_f2", ""));
		setRef4m(JSPUtil.getParameter(request, prefix + "ref_4m", ""));
		setHeader(JSPUtil.getParameter(request, prefix + "header", ""));
		setVslPol(JSPUtil.getParameter(request, prefix + "vsl_pol", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setChRate(JSPUtil.getParameter(request, prefix + "ch_rate", ""));
		setVslPoletd(JSPUtil.getParameter(request, prefix + "vsl_poletd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setTsPre(JSPUtil.getParameter(request, prefix + "ts_pre", ""));
		setVslPod(JSPUtil.getParameter(request, prefix + "vsl_pod", ""));
		setChPercent(JSPUtil.getParameter(request, prefix + "ch_percent", ""));
		setCustName(JSPUtil.getParameter(request, prefix + "cust_name", ""));
		setCntrLoad(JSPUtil.getParameter(request, prefix + "cntr_load", ""));
		setChBillCharge(JSPUtil.getParameter(request, prefix + "ch_bill_charge", ""));
		setTsPost(JSPUtil.getParameter(request, prefix + "ts_post", ""));
		setChRatedAs(JSPUtil.getParameter(request, prefix + "ch_rated_as", ""));
		setChCurCd(JSPUtil.getParameter(request, prefix + "ch_cur_cd", ""));
		setLocTpCd(JSPUtil.getParameter(request, prefix + "loc_tp_cd", ""));
		setChBlRatedQty(JSPUtil.getParameter(request, prefix + "ch_bl_rated_qty", ""));
		setMaxIfNo(JSPUtil.getParameter(request, prefix + "max_if_no", ""));
		setCmMea(JSPUtil.getParameter(request, prefix + "cm_mea", ""));
		setRefT2(JSPUtil.getParameter(request, prefix + "ref_t2", ""));
		setCustName2(JSPUtil.getParameter(request, prefix + "cust_name2", ""));
		setVslPor(JSPUtil.getParameter(request, prefix + "vsl_por", ""));
		setCustName1(JSPUtil.getParameter(request, prefix + "cust_name1", ""));
		setCorInd(JSPUtil.getParameter(request, prefix + "cor_ind", ""));
		setIncoTerm(JSPUtil.getParameter(request, prefix + "inco_term", ""));
		setChExRate(JSPUtil.getParameter(request, prefix + "ch_ex_rate", ""));
		setCmWgt(JSPUtil.getParameter(request, prefix + "cm_wgt", ""));
		setLocName(JSPUtil.getParameter(request, prefix + "loc_name", ""));
		setCurrencyBillCd(JSPUtil.getParameter(request, prefix + "currency_bill_cd", ""));
		setRefVx(JSPUtil.getParameter(request, prefix + "ref_vx", ""));
		setChBlRatedQual(JSPUtil.getParameter(request, prefix + "ch_bl_rated_qual", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCnRefSi(JSPUtil.getParameter(request, prefix + "cn_ref_si", ""));
		setInvType(JSPUtil.getParameter(request, prefix + "inv_type", ""));
		setScacCd(JSPUtil.getParameter(request, prefix + "scac_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setRefVc(JSPUtil.getParameter(request, prefix + "ref_vc", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setVslPodetd(JSPUtil.getParameter(request, prefix + "vsl_podetd", ""));
		setVslBvvd1(JSPUtil.getParameter(request, prefix + "vsl_bvvd1", ""));
		setCustAddr1(JSPUtil.getParameter(request, prefix + "cust_addr1", ""));
		setRefFr(JSPUtil.getParameter(request, prefix + "ref_fr", ""));
		setChPertype(JSPUtil.getParameter(request, prefix + "ch_pertype", ""));
		setCustPostal(JSPUtil.getParameter(request, prefix + "cust_postal", ""));
		setLocCntName(JSPUtil.getParameter(request, prefix + "loc_cnt_name", ""));
		setChCharge(JSPUtil.getParameter(request, prefix + "ch_charge", ""));
		setCustState(JSPUtil.getParameter(request, prefix + "cust_state", ""));
		setRefBm(JSPUtil.getParameter(request, prefix + "ref_bm", ""));
		setBlNum(JSPUtil.getParameter(request, prefix + "bl_num", ""));
		setCustAddr(JSPUtil.getParameter(request, prefix + "cust_addr", ""));
		setRefV9Des(JSPUtil.getParameter(request, prefix + "ref_v9_des", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setCntrType(JSPUtil.getParameter(request, prefix + "cntr_type", ""));
		setChFctype(JSPUtil.getParameter(request, prefix + "ch_fctype", ""));
		setLocCntCd(JSPUtil.getParameter(request, prefix + "loc_cnt_cd", ""));
		setRefUj(JSPUtil.getParameter(request, prefix + "ref_uj", ""));
		setVslPolFullname(JSPUtil.getParameter(request, prefix + "vsl_pol_fullname", ""));
		setCmDesc(JSPUtil.getParameter(request, prefix + "cm_desc", ""));
		setVslLloydcode(JSPUtil.getParameter(request, prefix + "vsl_lloydcode", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCmMeaCd(JSPUtil.getParameter(request, prefix + "cm_mea_cd", ""));
		setVslDel(JSPUtil.getParameter(request, prefix + "vsl_del", ""));
		setCmPkgCd(JSPUtil.getParameter(request, prefix + "cm_pkg_cd", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setCmPkg(JSPUtil.getParameter(request, prefix + "cm_pkg", ""));
		setChBillCur(JSPUtil.getParameter(request, prefix + "ch_bill_cur", ""));
		setRefV9Ori(JSPUtil.getParameter(request, prefix + "ref_v9_ori", ""));
		setCmWgtCd(JSPUtil.getParameter(request, prefix + "cm_wgt_cd", ""));
		setInvPay(JSPUtil.getParameter(request, prefix + "inv_pay", ""));
		setInvDate(JSPUtil.getParameter(request, prefix + "inv_date", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HPEDISendVO[]
	 */
	public HPEDISendVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HPEDISendVO[]
	 */
	public HPEDISendVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HPEDISendVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cnRefPo = (JSPUtil.getParameter(request, prefix	+ "cn_ref_po", length));
			String[] vslPodFullname = (JSPUtil.getParameter(request, prefix	+ "vsl_pod_fullname", length));
			String[] cnRefPt = (JSPUtil.getParameter(request, prefix	+ "cn_ref_pt", length));
			String[] cgoRcvDt = (JSPUtil.getParameter(request, prefix	+ "cgo_rcv_dt", length));
			String[] refPid = (JSPUtil.getParameter(request, prefix	+ "ref_pid", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] chFrtInd = (JSPUtil.getParameter(request, prefix	+ "ch_frt_ind", length));
			String[] chRateString = (JSPUtil.getParameter(request, prefix	+ "ch_rate_string", length));
			String[] cntrShipId = (JSPUtil.getParameter(request, prefix	+ "cntr_ship_id", length));
			String[] tariffSvcCd = (JSPUtil.getParameter(request, prefix	+ "tariff_svc_cd", length));
			String[] refAcb = (JSPUtil.getParameter(request, prefix	+ "ref_acb", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] vslFullname = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname", length));
			String[] invNum = (JSPUtil.getParameter(request, prefix	+ "inv_num", length));
			String[] finalEta = (JSPUtil.getParameter(request, prefix	+ "final_eta", length));
			String[] vslOrigin = (JSPUtil.getParameter(request, prefix	+ "vsl_origin", length));
			String[] custCity = (JSPUtil.getParameter(request, prefix	+ "cust_city", length));
			String[] chRateCharge = (JSPUtil.getParameter(request, prefix	+ "ch_rate_charge", length));
			String[] ref4g = (JSPUtil.getParameter(request, prefix	+ "ref_4g", length));
			String[] ref8x = (JSPUtil.getParameter(request, prefix	+ "ref_8x", length));
			String[] ref4l = (JSPUtil.getParameter(request, prefix	+ "ref_4l", length));
			String[] ref8v = (JSPUtil.getParameter(request, prefix	+ "ref_8v", length));
			String[] refF2 = (JSPUtil.getParameter(request, prefix	+ "ref_f2", length));
			String[] ref4m = (JSPUtil.getParameter(request, prefix	+ "ref_4m", length));
			String[] header = (JSPUtil.getParameter(request, prefix	+ "header", length));
			String[] vslPol = (JSPUtil.getParameter(request, prefix	+ "vsl_pol", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chRate = (JSPUtil.getParameter(request, prefix	+ "ch_rate", length));
			String[] vslPoletd = (JSPUtil.getParameter(request, prefix	+ "vsl_poletd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] tsPre = (JSPUtil.getParameter(request, prefix	+ "ts_pre", length));
			String[] vslPod = (JSPUtil.getParameter(request, prefix	+ "vsl_pod", length));
			String[] chPercent = (JSPUtil.getParameter(request, prefix	+ "ch_percent", length));
			String[] custName = (JSPUtil.getParameter(request, prefix	+ "cust_name", length));
			String[] cntrLoad = (JSPUtil.getParameter(request, prefix	+ "cntr_load", length));
			String[] chBillCharge = (JSPUtil.getParameter(request, prefix	+ "ch_bill_charge", length));
			String[] tsPost = (JSPUtil.getParameter(request, prefix	+ "ts_post", length));
			String[] chRatedAs = (JSPUtil.getParameter(request, prefix	+ "ch_rated_as", length));
			String[] chCurCd = (JSPUtil.getParameter(request, prefix	+ "ch_cur_cd", length));
			String[] locTpCd = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd", length));
			String[] chBlRatedQty = (JSPUtil.getParameter(request, prefix	+ "ch_bl_rated_qty", length));
			String[] maxIfNo = (JSPUtil.getParameter(request, prefix	+ "max_if_no", length));
			String[] cmMea = (JSPUtil.getParameter(request, prefix	+ "cm_mea", length));
			String[] refT2 = (JSPUtil.getParameter(request, prefix	+ "ref_t2", length));
			String[] custName2 = (JSPUtil.getParameter(request, prefix	+ "cust_name2", length));
			String[] vslPor = (JSPUtil.getParameter(request, prefix	+ "vsl_por", length));
			String[] custName1 = (JSPUtil.getParameter(request, prefix	+ "cust_name1", length));
			String[] corInd = (JSPUtil.getParameter(request, prefix	+ "cor_ind", length));
			String[] incoTerm = (JSPUtil.getParameter(request, prefix	+ "inco_term", length));
			String[] chExRate = (JSPUtil.getParameter(request, prefix	+ "ch_ex_rate", length));
			String[] cmWgt = (JSPUtil.getParameter(request, prefix	+ "cm_wgt", length));
			String[] locName = (JSPUtil.getParameter(request, prefix	+ "loc_name", length));
			String[] currencyBillCd = (JSPUtil.getParameter(request, prefix	+ "currency_bill_cd", length));
			String[] refVx = (JSPUtil.getParameter(request, prefix	+ "ref_vx", length));
			String[] chBlRatedQual = (JSPUtil.getParameter(request, prefix	+ "ch_bl_rated_qual", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnRefSi = (JSPUtil.getParameter(request, prefix	+ "cn_ref_si", length));
			String[] invType = (JSPUtil.getParameter(request, prefix	+ "inv_type", length));
			String[] scacCd = (JSPUtil.getParameter(request, prefix	+ "scac_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] refVc = (JSPUtil.getParameter(request, prefix	+ "ref_vc", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] vslPodetd = (JSPUtil.getParameter(request, prefix	+ "vsl_podetd", length));
			String[] vslBvvd1 = (JSPUtil.getParameter(request, prefix	+ "vsl_bvvd1", length));
			String[] custAddr1 = (JSPUtil.getParameter(request, prefix	+ "cust_addr1", length));
			String[] refFr = (JSPUtil.getParameter(request, prefix	+ "ref_fr", length));
			String[] chPertype = (JSPUtil.getParameter(request, prefix	+ "ch_pertype", length));
			String[] custPostal = (JSPUtil.getParameter(request, prefix	+ "cust_postal", length));
			String[] locCntName = (JSPUtil.getParameter(request, prefix	+ "loc_cnt_name", length));
			String[] chCharge = (JSPUtil.getParameter(request, prefix	+ "ch_charge", length));
			String[] custState = (JSPUtil.getParameter(request, prefix	+ "cust_state", length));
			String[] refBm = (JSPUtil.getParameter(request, prefix	+ "ref_bm", length));
			String[] blNum = (JSPUtil.getParameter(request, prefix	+ "bl_num", length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr", length));
			String[] refV9Des = (JSPUtil.getParameter(request, prefix	+ "ref_v9_des", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] chFctype = (JSPUtil.getParameter(request, prefix	+ "ch_fctype", length));
			String[] locCntCd = (JSPUtil.getParameter(request, prefix	+ "loc_cnt_cd", length));
			String[] refUj = (JSPUtil.getParameter(request, prefix	+ "ref_uj", length));
			String[] vslPolFullname = (JSPUtil.getParameter(request, prefix	+ "vsl_pol_fullname", length));
			String[] cmDesc = (JSPUtil.getParameter(request, prefix	+ "cm_desc", length));
			String[] vslLloydcode = (JSPUtil.getParameter(request, prefix	+ "vsl_lloydcode", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cmMeaCd = (JSPUtil.getParameter(request, prefix	+ "cm_mea_cd", length));
			String[] vslDel = (JSPUtil.getParameter(request, prefix	+ "vsl_del", length));
			String[] cmPkgCd = (JSPUtil.getParameter(request, prefix	+ "cm_pkg_cd", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] cmPkg = (JSPUtil.getParameter(request, prefix	+ "cm_pkg", length));
			String[] chBillCur = (JSPUtil.getParameter(request, prefix	+ "ch_bill_cur", length));
			String[] refV9Ori = (JSPUtil.getParameter(request, prefix	+ "ref_v9_ori", length));
			String[] cmWgtCd = (JSPUtil.getParameter(request, prefix	+ "cm_wgt_cd", length));
			String[] invPay = (JSPUtil.getParameter(request, prefix	+ "inv_pay", length));
			String[] invDate = (JSPUtil.getParameter(request, prefix	+ "inv_date", length));
			
			for (int i = 0; i < length; i++) {
				model = new HPEDISendVO();
				if (cnRefPo[i] != null)
					model.setCnRefPo(cnRefPo[i]);
				if (vslPodFullname[i] != null)
					model.setVslPodFullname(vslPodFullname[i]);
				if (cnRefPt[i] != null)
					model.setCnRefPt(cnRefPt[i]);
				if (cgoRcvDt[i] != null)
					model.setCgoRcvDt(cgoRcvDt[i]);
				if (refPid[i] != null)
					model.setRefPid(refPid[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (chFrtInd[i] != null)
					model.setChFrtInd(chFrtInd[i]);
				if (chRateString[i] != null)
					model.setChRateString(chRateString[i]);
				if (cntrShipId[i] != null)
					model.setCntrShipId(cntrShipId[i]);
				if (tariffSvcCd[i] != null)
					model.setTariffSvcCd(tariffSvcCd[i]);
				if (refAcb[i] != null)
					model.setRefAcb(refAcb[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (vslFullname[i] != null)
					model.setVslFullname(vslFullname[i]);
				if (invNum[i] != null)
					model.setInvNum(invNum[i]);
				if (finalEta[i] != null)
					model.setFinalEta(finalEta[i]);
				if (vslOrigin[i] != null)
					model.setVslOrigin(vslOrigin[i]);
				if (custCity[i] != null)
					model.setCustCity(custCity[i]);
				if (chRateCharge[i] != null)
					model.setChRateCharge(chRateCharge[i]);
				if (ref4g[i] != null)
					model.setRef4g(ref4g[i]);
				if (ref8x[i] != null)
					model.setRef8x(ref8x[i]);
				if (ref4l[i] != null)
					model.setRef4l(ref4l[i]);
				if (ref8v[i] != null)
					model.setRef8v(ref8v[i]);
				if (refF2[i] != null)
					model.setRefF2(refF2[i]);
				if (ref4m[i] != null)
					model.setRef4m(ref4m[i]);
				if (header[i] != null)
					model.setHeader(header[i]);
				if (vslPol[i] != null)
					model.setVslPol(vslPol[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (chRate[i] != null)
					model.setChRate(chRate[i]);
				if (vslPoletd[i] != null)
					model.setVslPoletd(vslPoletd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (tsPre[i] != null)
					model.setTsPre(tsPre[i]);
				if (vslPod[i] != null)
					model.setVslPod(vslPod[i]);
				if (chPercent[i] != null)
					model.setChPercent(chPercent[i]);
				if (custName[i] != null)
					model.setCustName(custName[i]);
				if (cntrLoad[i] != null)
					model.setCntrLoad(cntrLoad[i]);
				if (chBillCharge[i] != null)
					model.setChBillCharge(chBillCharge[i]);
				if (tsPost[i] != null)
					model.setTsPost(tsPost[i]);
				if (chRatedAs[i] != null)
					model.setChRatedAs(chRatedAs[i]);
				if (chCurCd[i] != null)
					model.setChCurCd(chCurCd[i]);
				if (locTpCd[i] != null)
					model.setLocTpCd(locTpCd[i]);
				if (chBlRatedQty[i] != null)
					model.setChBlRatedQty(chBlRatedQty[i]);
				if (maxIfNo[i] != null)
					model.setMaxIfNo(maxIfNo[i]);
				if (cmMea[i] != null)
					model.setCmMea(cmMea[i]);
				if (refT2[i] != null)
					model.setRefT2(refT2[i]);
				if (custName2[i] != null)
					model.setCustName2(custName2[i]);
				if (vslPor[i] != null)
					model.setVslPor(vslPor[i]);
				if (custName1[i] != null)
					model.setCustName1(custName1[i]);
				if (corInd[i] != null)
					model.setCorInd(corInd[i]);
				if (incoTerm[i] != null)
					model.setIncoTerm(incoTerm[i]);
				if (chExRate[i] != null)
					model.setChExRate(chExRate[i]);
				if (cmWgt[i] != null)
					model.setCmWgt(cmWgt[i]);
				if (locName[i] != null)
					model.setLocName(locName[i]);
				if (currencyBillCd[i] != null)
					model.setCurrencyBillCd(currencyBillCd[i]);
				if (refVx[i] != null)
					model.setRefVx(refVx[i]);
				if (chBlRatedQual[i] != null)
					model.setChBlRatedQual(chBlRatedQual[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnRefSi[i] != null)
					model.setCnRefSi(cnRefSi[i]);
				if (invType[i] != null)
					model.setInvType(invType[i]);
				if (scacCd[i] != null)
					model.setScacCd(scacCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (refVc[i] != null)
					model.setRefVc(refVc[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (vslPodetd[i] != null)
					model.setVslPodetd(vslPodetd[i]);
				if (vslBvvd1[i] != null)
					model.setVslBvvd1(vslBvvd1[i]);
				if (custAddr1[i] != null)
					model.setCustAddr1(custAddr1[i]);
				if (refFr[i] != null)
					model.setRefFr(refFr[i]);
				if (chPertype[i] != null)
					model.setChPertype(chPertype[i]);
				if (custPostal[i] != null)
					model.setCustPostal(custPostal[i]);
				if (locCntName[i] != null)
					model.setLocCntName(locCntName[i]);
				if (chCharge[i] != null)
					model.setChCharge(chCharge[i]);
				if (custState[i] != null)
					model.setCustState(custState[i]);
				if (refBm[i] != null)
					model.setRefBm(refBm[i]);
				if (blNum[i] != null)
					model.setBlNum(blNum[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (refV9Des[i] != null)
					model.setRefV9Des(refV9Des[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (chFctype[i] != null)
					model.setChFctype(chFctype[i]);
				if (locCntCd[i] != null)
					model.setLocCntCd(locCntCd[i]);
				if (refUj[i] != null)
					model.setRefUj(refUj[i]);
				if (vslPolFullname[i] != null)
					model.setVslPolFullname(vslPolFullname[i]);
				if (cmDesc[i] != null)
					model.setCmDesc(cmDesc[i]);
				if (vslLloydcode[i] != null)
					model.setVslLloydcode(vslLloydcode[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cmMeaCd[i] != null)
					model.setCmMeaCd(cmMeaCd[i]);
				if (vslDel[i] != null)
					model.setVslDel(vslDel[i]);
				if (cmPkgCd[i] != null)
					model.setCmPkgCd(cmPkgCd[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (cmPkg[i] != null)
					model.setCmPkg(cmPkg[i]);
				if (chBillCur[i] != null)
					model.setChBillCur(chBillCur[i]);
				if (refV9Ori[i] != null)
					model.setRefV9Ori(refV9Ori[i]);
				if (cmWgtCd[i] != null)
					model.setCmWgtCd(cmWgtCd[i]);
				if (invPay[i] != null)
					model.setInvPay(invPay[i]);
				if (invDate[i] != null)
					model.setInvDate(invDate[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHPEDISendVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HPEDISendVO[]
	 */
	public HPEDISendVO[] getHPEDISendVOs(){
		HPEDISendVO[] vos = (HPEDISendVO[])models.toArray(new HPEDISendVO[models.size()]);
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
		this.cnRefPo = this.cnRefPo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPodFullname = this.vslPodFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnRefPt = this.cnRefPt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoRcvDt = this.cgoRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refPid = this.refPid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chFrtInd = this.chFrtInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chRateString = this.chRateString .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrShipId = this.cntrShipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariffSvcCd = this.tariffSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refAcb = this.refAcb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullname = this.vslFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNum = this.invNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalEta = this.finalEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOrigin = this.vslOrigin .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCity = this.custCity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chRateCharge = this.chRateCharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ref4g = this.ref4g .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ref8x = this.ref8x .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ref4l = this.ref4l .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ref8v = this.ref8v .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refF2 = this.refF2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ref4m = this.ref4m .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header = this.header .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPol = this.vslPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chRate = this.chRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPoletd = this.vslPoletd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPre = this.tsPre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPod = this.vslPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chPercent = this.chPercent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custName = this.custName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLoad = this.cntrLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chBillCharge = this.chBillCharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPost = this.tsPost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chRatedAs = this.chRatedAs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chCurCd = this.chCurCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCd = this.locTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chBlRatedQty = this.chBlRatedQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxIfNo = this.maxIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmMea = this.cmMea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refT2 = this.refT2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custName2 = this.custName2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPor = this.vslPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custName1 = this.custName1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corInd = this.corInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incoTerm = this.incoTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chExRate = this.chExRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmWgt = this.cmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locName = this.locName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currencyBillCd = this.currencyBillCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refVx = this.refVx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chBlRatedQual = this.chBlRatedQual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnRefSi = this.cnRefSi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invType = this.invType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scacCd = this.scacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refVc = this.refVc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPodetd = this.vslPodetd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBvvd1 = this.vslBvvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr1 = this.custAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refFr = this.refFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chPertype = this.chPertype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custPostal = this.custPostal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCntName = this.locCntName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chCharge = this.chCharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custState = this.custState .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refBm = this.refBm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNum = this.blNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refV9Des = this.refV9Des .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chFctype = this.chFctype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCntCd = this.locCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refUj = this.refUj .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPolFullname = this.vslPolFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmDesc = this.cmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLloydcode = this.vslLloydcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmMeaCd = this.cmMeaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDel = this.vslDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPkgCd = this.cmPkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPkg = this.cmPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chBillCur = this.chBillCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refV9Ori = this.refV9Ori .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmWgtCd = this.cmWgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPay = this.invPay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDate = this.invDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
