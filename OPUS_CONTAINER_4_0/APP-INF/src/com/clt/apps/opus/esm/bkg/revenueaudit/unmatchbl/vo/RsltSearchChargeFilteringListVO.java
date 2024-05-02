/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltSearchChargeFilteringListVO.java
*@FileTitle : RsltSearchChargeFilteringListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.05.07 류선우 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo;

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
 * @author 류선우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchChargeFilteringListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchChargeFilteringListVO> models = new ArrayList<RsltSearchChargeFilteringListVO>();
	
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String usaSvcModNm = null;
	/* Column Info */
	private String rtBlTpCd = null;
	/* Column Info */
	private String searchDate = null;
	/* Column Info */
	private String rcFlgProp = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String chgCd1 = null;	
	/* Column Info */
	private String ctrtCustTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rdnStsNm = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String awkCgoFlgProp = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String autoRatCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String billTypeB = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String billTypeC = null;
	/* Column Info */
	private String ratAsQty = null;
	/* Column Info */
	private String billTypeN = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String billTypeM = null;
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String raterId = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bkgRhqCd = null;
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String rdnNo = null;
	/* Column Info */
	private String chargeNm = null;
	/* Column Info */
	private String eqSubstFlg = null;
	/* Column Info */
	private String eqSubstFlgProp = null;
	/* Column Info */
	private String usaSvcModCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hngrFlgProp = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String splitNm = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String cargoType = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String ctrtCustNm = null;
	/* Column Info */
	private String bkgStsNm = null;
	/* Column Info */
	private String autoRatFlg = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String nCustNm = null;
	/* Column Info */
	private String dcgoFlgProp = null;
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String bkgCtrtTpNm = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String autoRatNm = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String bkgSeq = null;
	/* Column Info */
	private String rdCgoFlgProp = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String chargeFlg = null;
	/* Column Info */
	private String ctrtCustValSgmNm = null;
	/* Column Info */
	private String hngrFlg = null;
	/* Column Info */
	private String bbCgoFlgProp = null;
	/* Column Info */
	private String rtBlTpNm = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String chargeType = null;
	/* Column Info */
	private String chargeCondition = null;
	/* Column Info */
	private String inrAuthNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchChargeFilteringListVO() {}

	public RsltSearchChargeFilteringListVO(String ibflag, String pagerows, String bkgSeq, String bkgRhqCd, String bkgOfcCd, String bkgNo, String blNo, String bkgCreDt, String rtAplyDt, String vpsEtdDt, String vvd, String bkgCtrtTpCd, String bkgCtrtTpNm, String ctrtNo, String repCmdtCd, String cmdtCd, String cmdtNm, String cstmsDesc, String dcgoFlg, String dcgoFlgProp, String rcFlg, String rcFlgProp, String awkCgoFlg, String awkCgoFlgProp, String bbCgoFlg, String bbCgoFlgProp, String rdCgoFlg, String rdCgoFlgProp, String hngrFlg, String hngrFlgProp, String eqSubstFlg, String eqSubstFlgProp, String svcScpCd, String porCd, String polCd, String podCd, String delCd, String rcvTermCd, String deTermCd, String usaSvcModCd, String usaSvcModNm, String sCustNm, String cCustNm, String nCustNm, String ctrtCustNm, String ctrtCustTpCd, String ctrtCustValSgmNm, String bdrFlg, String bkgStsCd, String bkgStsNm, String splitFlg, String splitNm, String chargeFlg, String chargeNm, String autoRatFlg, String autoRatNm, String rtBlTpCd, String rtBlTpNm, String raterId, String rdnNo, String rdnStsNm, String chgCd, String chgCd1, String currCd, String chgUtAmt, String ratAsQty, String ratUtCd, String chgAmt, String autoRatCd, String searchDate, String fromDt, String toDt, String cargoType, String billTypeN, String billTypeM, String billTypeC, String billTypeB, String bkgCustTpCd, String custCntCd, String custSeq, String custNm, String chargeType, String chargeCondition, String inrAuthNo) {
		this.rtAplyDt = rtAplyDt;
		this.svcScpCd = svcScpCd;
		this.usaSvcModNm = usaSvcModNm;
		this.rtBlTpCd = rtBlTpCd;
		this.searchDate = searchDate;
		this.rcFlgProp = rcFlgProp;
		this.blNo = blNo;
		this.chgCd = chgCd;
		this.chgCd1 = chgCd1;
		this.ctrtCustTpCd = ctrtCustTpCd;
		this.pagerows = pagerows;
		this.rdnStsNm = rdnStsNm;
		this.ctrtNo = ctrtNo;
		this.polCd = polCd;
		this.chgAmt = chgAmt;
		this.bkgCreDt = bkgCreDt;
		this.bkgCustTpCd = bkgCustTpCd;
		this.awkCgoFlgProp = awkCgoFlgProp;
		this.custCntCd = custCntCd;
		this.bkgOfcCd = bkgOfcCd;
		this.autoRatCd = autoRatCd;
		this.vpsEtdDt = vpsEtdDt;
		this.awkCgoFlg = awkCgoFlg;
		this.delCd = delCd;
		this.ratUtCd = ratUtCd;
		this.billTypeB = billTypeB;
		this.toDt = toDt;
		this.vvd = vvd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.billTypeC = billTypeC;
		this.ratAsQty = ratAsQty;
		this.billTypeN = billTypeN;
		this.rcFlg = rcFlg;
		this.billTypeM = billTypeM;
		this.splitFlg = splitFlg;
		this.porCd = porCd;
		this.fromDt = fromDt;
		this.currCd = currCd;
		this.raterId = raterId;
		this.custNm = custNm;
		this.rdCgoFlg = rdCgoFlg;
		this.bdrFlg = bdrFlg;
		this.bkgStsCd = bkgStsCd;
		this.bkgRhqCd = bkgRhqCd;
		this.cCustNm = cCustNm;
		this.rdnNo = rdnNo;
		this.chargeNm = chargeNm;
		this.eqSubstFlg = eqSubstFlg;
		this.eqSubstFlgProp = eqSubstFlgProp;
		this.usaSvcModCd = usaSvcModCd;
		this.ibflag = ibflag;
		this.hngrFlgProp = hngrFlgProp;
		this.cmdtCd = cmdtCd;
		this.splitNm = splitNm;
		this.bbCgoFlg = bbCgoFlg;
		this.cstmsDesc = cstmsDesc;
		this.cargoType = cargoType;
		this.dcgoFlg = dcgoFlg;
		this.ctrtCustNm = ctrtCustNm;
		this.bkgStsNm = bkgStsNm;
		this.autoRatFlg = autoRatFlg;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.rcvTermCd = rcvTermCd;
		this.nCustNm = nCustNm;
		this.dcgoFlgProp = dcgoFlgProp;
		this.chgUtAmt = chgUtAmt;
		this.bkgCtrtTpNm = bkgCtrtTpNm;
		this.sCustNm = sCustNm;
		this.autoRatNm = autoRatNm;
		this.custSeq = custSeq;
		this.cmdtNm = cmdtNm;
		this.bkgSeq = bkgSeq;
		this.rdCgoFlgProp = rdCgoFlgProp;
		this.deTermCd = deTermCd;
		this.chargeFlg = chargeFlg;
		this.ctrtCustValSgmNm = ctrtCustValSgmNm;
		this.hngrFlg = hngrFlg;
		this.bbCgoFlgProp = bbCgoFlgProp;
		this.rtBlTpNm = rtBlTpNm;
		this.repCmdtCd = repCmdtCd;
		this.chargeType = chargeType;
		this.chargeCondition = chargeCondition;
		this.inrAuthNo = inrAuthNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("usa_svc_mod_nm", getUsaSvcModNm());
		this.hashColumns.put("rt_bl_tp_cd", getRtBlTpCd());
		this.hashColumns.put("search_date", getSearchDate());
		this.hashColumns.put("rc_flg_prop", getRcFlgProp());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("chg_cd1", getChgCd1());
		this.hashColumns.put("ctrt_cust_tp_cd", getCtrtCustTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rdn_sts_nm", getRdnStsNm());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("awk_cgo_flg_prop", getAwkCgoFlgProp());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("auto_rat_cd", getAutoRatCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("bill_type_b", getBillTypeB());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bill_type_c", getBillTypeC());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("bill_type_n", getBillTypeN());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("bill_type_m", getBillTypeM());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rater_id", getRaterId());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bkg_rhq_cd", getBkgRhqCd());
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("rdn_no", getRdnNo());
		this.hashColumns.put("charge_nm", getChargeNm());
		this.hashColumns.put("eq_subst_flg", getEqSubstFlg());
		this.hashColumns.put("eq_subst_flg_prop", getEqSubstFlgProp());
		this.hashColumns.put("usa_svc_mod_cd", getUsaSvcModCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hngr_flg_prop", getHngrFlgProp());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("split_nm", getSplitNm());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("cargo_type", getCargoType());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("ctrt_cust_nm", getCtrtCustNm());
		this.hashColumns.put("bkg_sts_nm", getBkgStsNm());
		this.hashColumns.put("auto_rat_flg", getAutoRatFlg());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("n_cust_nm", getNCustNm());
		this.hashColumns.put("dcgo_flg_prop", getDcgoFlgProp());
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("bkg_ctrt_tp_nm", getBkgCtrtTpNm());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("auto_rat_nm", getAutoRatNm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("bkg_seq", getBkgSeq());
		this.hashColumns.put("rd_cgo_flg_prop", getRdCgoFlgProp());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("charge_flg", getChargeFlg());
		this.hashColumns.put("ctrt_cust_val_sgm_nm", getCtrtCustValSgmNm());
		this.hashColumns.put("hngr_flg", getHngrFlg());
		this.hashColumns.put("bb_cgo_flg_prop", getBbCgoFlgProp());
		this.hashColumns.put("rt_bl_tp_nm", getRtBlTpNm());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("charge_type", getChargeType());
		this.hashColumns.put("charge_condition", getChargeCondition());
		this.hashColumns.put("inr_auth_no", getInrAuthNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("usa_svc_mod_nm", "usaSvcModNm");
		this.hashFields.put("rt_bl_tp_cd", "rtBlTpCd");
		this.hashFields.put("search_date", "searchDate");
		this.hashFields.put("rc_flg_prop", "rcFlgProp");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("chg_cd1", "chgCd1");
		this.hashFields.put("ctrt_cust_tp_cd", "ctrtCustTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rdn_sts_nm", "rdnStsNm");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("awk_cgo_flg_prop", "awkCgoFlgProp");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("auto_rat_cd", "autoRatCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("bill_type_b", "billTypeB");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bill_type_c", "billTypeC");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("bill_type_n", "billTypeN");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("bill_type_m", "billTypeM");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rater_id", "raterId");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bkg_rhq_cd", "bkgRhqCd");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("rdn_no", "rdnNo");
		this.hashFields.put("charge_nm", "chargeNm");
		this.hashFields.put("eq_subst_flg", "eqSubstFlg");
		this.hashFields.put("eq_subst_flg_prop", "eqSubstFlgProp");
		this.hashFields.put("usa_svc_mod_cd", "usaSvcModCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hngr_flg_prop", "hngrFlgProp");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("split_nm", "splitNm");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("cargo_type", "cargoType");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("ctrt_cust_nm", "ctrtCustNm");
		this.hashFields.put("bkg_sts_nm", "bkgStsNm");
		this.hashFields.put("auto_rat_flg", "autoRatFlg");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("n_cust_nm", "nCustNm");
		this.hashFields.put("dcgo_flg_prop", "dcgoFlgProp");
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("bkg_ctrt_tp_nm", "bkgCtrtTpNm");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("auto_rat_nm", "autoRatNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("bkg_seq", "bkgSeq");
		this.hashFields.put("rd_cgo_flg_prop", "rdCgoFlgProp");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("charge_flg", "chargeFlg");
		this.hashFields.put("ctrt_cust_val_sgm_nm", "ctrtCustValSgmNm");
		this.hashFields.put("hngr_flg", "hngrFlg");
		this.hashFields.put("bb_cgo_flg_prop", "bbCgoFlgProp");
		this.hashFields.put("rt_bl_tp_nm", "rtBlTpNm");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("charge_type", "chargeType");
		this.hashFields.put("charge_condition", "chargeCondition");
		this.hashFields.put("inr_auth_no", "inrAuthNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rtAplyDt
	 */
	public String getRtAplyDt() {
		return this.rtAplyDt;
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
	 * @return usaSvcModNm
	 */
	public String getUsaSvcModNm() {
		return this.usaSvcModNm;
	}
	
	/**
	 * Column Info
	 * @return rtBlTpCd
	 */
	public String getRtBlTpCd() {
		return this.rtBlTpCd;
	}
	
	/**
	 * Column Info
	 * @return searchDate
	 */
	public String getSearchDate() {
		return this.searchDate;
	}
	
	/**
	 * Column Info
	 * @return rcFlgProp
	 */
	public String getRcFlgProp() {
		return this.rcFlgProp;
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
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}

	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd1() {
		return this.chgCd1;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustTpCd
	 */
	public String getCtrtCustTpCd() {
		return this.ctrtCustTpCd;
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
	 * @return rdnStsNm
	 */
	public String getRdnStsNm() {
		return this.rdnStsNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
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
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlgProp
	 */
	public String getAwkCgoFlgProp() {
		return this.awkCgoFlgProp;
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
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return autoRatCd
	 */
	public String getAutoRatCd() {
		return this.autoRatCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
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
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return billTypeB
	 */
	public String getBillTypeB() {
		return this.billTypeB;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return billTypeC
	 */
	public String getBillTypeC() {
		return this.billTypeC;
	}
	
	/**
	 * Column Info
	 * @return ratAsQty
	 */
	public String getRatAsQty() {
		return this.ratAsQty;
	}
	
	/**
	 * Column Info
	 * @return billTypeN
	 */
	public String getBillTypeN() {
		return this.billTypeN;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return billTypeM
	 */
	public String getBillTypeM() {
		return this.billTypeM;
	}
	
	/**
	 * Column Info
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
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
	 * @return raterId
	 */
	public String getRaterId() {
		return this.raterId;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRhqCd
	 */
	public String getBkgRhqCd() {
		return this.bkgRhqCd;
	}
	
	/**
	 * Column Info
	 * @return cCustNm
	 */
	public String getCCustNm() {
		return this.cCustNm;
	}
	
	/**
	 * Column Info
	 * @return rdnNo
	 */
	public String getRdnNo() {
		return this.rdnNo;
	}
	
	/**
	 * Column Info
	 * @return chargeNm
	 */
	public String getChargeNm() {
		return this.chargeNm;
	}
	
	/**
	 * Column Info
	 * @return eqSubstFlg
	 */
	public String getEqSubstFlg() {
		return this.eqSubstFlg;
	}
	
	/**
	 * Column Info
	 * @return eqSubstFlgProp
	 */
	public String getEqSubstFlgProp() {
		return this.eqSubstFlgProp;
	}
	
	/**
	 * Column Info
	 * @return usaSvcModCd
	 */
	public String getUsaSvcModCd() {
		return this.usaSvcModCd;
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
	 * @return hngrFlgProp
	 */
	public String getHngrFlgProp() {
		return this.hngrFlgProp;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return splitNm
	 */
	public String getSplitNm() {
		return this.splitNm;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @return cargoType
	 */
	public String getCargoType() {
		return this.cargoType;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustNm
	 */
	public String getCtrtCustNm() {
		return this.ctrtCustNm;
	}
	
	/**
	 * Column Info
	 * @return bkgStsNm
	 */
	public String getBkgStsNm() {
		return this.bkgStsNm;
	}
	
	/**
	 * Column Info
	 * @return autoRatFlg
	 */
	public String getAutoRatFlg() {
		return this.autoRatFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return nCustNm
	 */
	public String getNCustNm() {
		return this.nCustNm;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlgProp
	 */
	public String getDcgoFlgProp() {
		return this.dcgoFlgProp;
	}
	
	/**
	 * Column Info
	 * @return chgUtAmt
	 */
	public String getChgUtAmt() {
		return this.chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrtTpNm
	 */
	public String getBkgCtrtTpNm() {
		return this.bkgCtrtTpNm;
	}
	
	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
	}
	
	/**
	 * Column Info
	 * @return autoRatNm
	 */
	public String getAutoRatNm() {
		return this.autoRatNm;
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
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return bkgSeq
	 */
	public String getBkgSeq() {
		return this.bkgSeq;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlgProp
	 */
	public String getRdCgoFlgProp() {
		return this.rdCgoFlgProp;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return chargeFlg
	 */
	public String getChargeFlg() {
		return this.chargeFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustValSgmNm
	 */
	public String getCtrtCustValSgmNm() {
		return this.ctrtCustValSgmNm;
	}
	
	/**
	 * Column Info
	 * @return hngrFlg
	 */
	public String getHngrFlg() {
		return this.hngrFlg;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlgProp
	 */
	public String getBbCgoFlgProp() {
		return this.bbCgoFlgProp;
	}
	
	/**
	 * Column Info
	 * @return rtBlTpNm
	 */
	public String getRtBlTpNm() {
		return this.rtBlTpNm;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
	}

	/**
	 * Column Info
	 * @return chargeCondition
	 */
	public String getChargeType() {
		return this.chargeType;
	}	
	
	/**
	 * Column Info
	 * @return chargeCondition
	 */
	public String getChargeCondition() {
		return this.chargeCondition;
	}
	
	/**
	 * Column Info
	 * @return chargeCondition
	 */
	public String getInrAuthNo() {
		return this.inrAuthNo;
	}	

	/**
	 * Column Info
	 * @param rtAplyDt
	 */
	public void setRtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
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
	 * @param usaSvcModNm
	 */
	public void setUsaSvcModNm(String usaSvcModNm) {
		this.usaSvcModNm = usaSvcModNm;
	}
	
	/**
	 * Column Info
	 * @param rtBlTpCd
	 */
	public void setRtBlTpCd(String rtBlTpCd) {
		this.rtBlTpCd = rtBlTpCd;
	}
	
	/**
	 * Column Info
	 * @param searchDate
	 */
	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}
	
	/**
	 * Column Info
	 * @param rcFlgProp
	 */
	public void setRcFlgProp(String rcFlgProp) {
		this.rcFlgProp = rcFlgProp;
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
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd1(String chgCd1) {
		this.chgCd1 = chgCd1;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustTpCd
	 */
	public void setCtrtCustTpCd(String ctrtCustTpCd) {
		this.ctrtCustTpCd = ctrtCustTpCd;
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
	 * @param rdnStsNm
	 */
	public void setRdnStsNm(String rdnStsNm) {
		this.rdnStsNm = rdnStsNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
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
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlgProp
	 */
	public void setAwkCgoFlgProp(String awkCgoFlgProp) {
		this.awkCgoFlgProp = awkCgoFlgProp;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param autoRatCd
	 */
	public void setAutoRatCd(String autoRatCd) {
		this.autoRatCd = autoRatCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
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
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param billTypeB
	 */
	public void setBillTypeB(String billTypeB) {
		this.billTypeB = billTypeB;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param billTypeC
	 */
	public void setBillTypeC(String billTypeC) {
		this.billTypeC = billTypeC;
	}
	
	/**
	 * Column Info
	 * @param ratAsQty
	 */
	public void setRatAsQty(String ratAsQty) {
		this.ratAsQty = ratAsQty;
	}
	
	/**
	 * Column Info
	 * @param billTypeN
	 */
	public void setBillTypeN(String billTypeN) {
		this.billTypeN = billTypeN;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param billTypeM
	 */
	public void setBillTypeM(String billTypeM) {
		this.billTypeM = billTypeM;
	}
	
	/**
	 * Column Info
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
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
	 * @param raterId
	 */
	public void setRaterId(String raterId) {
		this.raterId = raterId;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRhqCd
	 */
	public void setBkgRhqCd(String bkgRhqCd) {
		this.bkgRhqCd = bkgRhqCd;
	}
	
	/**
	 * Column Info
	 * @param cCustNm
	 */
	public void setCCustNm(String cCustNm) {
		this.cCustNm = cCustNm;
	}
	
	/**
	 * Column Info
	 * @param rdnNo
	 */
	public void setRdnNo(String rdnNo) {
		this.rdnNo = rdnNo;
	}
	
	/**
	 * Column Info
	 * @param chargeNm
	 */
	public void setChargeNm(String chargeNm) {
		this.chargeNm = chargeNm;
	}
	
	/**
	 * Column Info
	 * @param eqSubstFlg
	 */
	public void setEqSubstFlg(String eqSubstFlg) {
		this.eqSubstFlg = eqSubstFlg;
	}
	
	/**
	 * Column Info
	 * @param eqSubstFlgProp
	 */
	public void setEqSubstFlgProp(String eqSubstFlgProp) {
		this.eqSubstFlgProp = eqSubstFlgProp;
	}
	
	/**
	 * Column Info
	 * @param usaSvcModCd
	 */
	public void setUsaSvcModCd(String usaSvcModCd) {
		this.usaSvcModCd = usaSvcModCd;
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
	 * @param hngrFlgProp
	 */
	public void setHngrFlgProp(String hngrFlgProp) {
		this.hngrFlgProp = hngrFlgProp;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param splitNm
	 */
	public void setSplitNm(String splitNm) {
		this.splitNm = splitNm;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @param cargoType
	 */
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustNm
	 */
	public void setCtrtCustNm(String ctrtCustNm) {
		this.ctrtCustNm = ctrtCustNm;
	}
	
	/**
	 * Column Info
	 * @param bkgStsNm
	 */
	public void setBkgStsNm(String bkgStsNm) {
		this.bkgStsNm = bkgStsNm;
	}
	
	/**
	 * Column Info
	 * @param autoRatFlg
	 */
	public void setAutoRatFlg(String autoRatFlg) {
		this.autoRatFlg = autoRatFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param nCustNm
	 */
	public void setNCustNm(String nCustNm) {
		this.nCustNm = nCustNm;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlgProp
	 */
	public void setDcgoFlgProp(String dcgoFlgProp) {
		this.dcgoFlgProp = dcgoFlgProp;
	}
	
	/**
	 * Column Info
	 * @param chgUtAmt
	 */
	public void setChgUtAmt(String chgUtAmt) {
		this.chgUtAmt = chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrtTpNm
	 */
	public void setBkgCtrtTpNm(String bkgCtrtTpNm) {
		this.bkgCtrtTpNm = bkgCtrtTpNm;
	}
	
	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
	}
	
	/**
	 * Column Info
	 * @param autoRatNm
	 */
	public void setAutoRatNm(String autoRatNm) {
		this.autoRatNm = autoRatNm;
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
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param bkgSeq
	 */
	public void setBkgSeq(String bkgSeq) {
		this.bkgSeq = bkgSeq;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlgProp
	 */
	public void setRdCgoFlgProp(String rdCgoFlgProp) {
		this.rdCgoFlgProp = rdCgoFlgProp;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param chargeFlg
	 */
	public void setChargeFlg(String chargeFlg) {
		this.chargeFlg = chargeFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustValSgmNm
	 */
	public void setCtrtCustValSgmNm(String ctrtCustValSgmNm) {
		this.ctrtCustValSgmNm = ctrtCustValSgmNm;
	}
	
	/**
	 * Column Info
	 * @param hngrFlg
	 */
	public void setHngrFlg(String hngrFlg) {
		this.hngrFlg = hngrFlg;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlgProp
	 */
	public void setBbCgoFlgProp(String bbCgoFlgProp) {
		this.bbCgoFlgProp = bbCgoFlgProp;
	}
	
	/**
	 * Column Info
	 * @param rtBlTpNm
	 */
	public void setRtBlTpNm(String rtBlTpNm) {
		this.rtBlTpNm = rtBlTpNm;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}

	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setChargeCondition(String chargeCondition) {
		this.chargeCondition = chargeCondition;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setInrAuthNo(String inrAuthNo) {
		this.inrAuthNo = inrAuthNo;
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
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setUsaSvcModNm(JSPUtil.getParameter(request, prefix + "usa_svc_mod_nm", ""));
		setRtBlTpCd(JSPUtil.getParameter(request, prefix + "rt_bl_tp_cd", ""));
		setSearchDate(JSPUtil.getParameter(request, prefix + "search_date", ""));
		setRcFlgProp(JSPUtil.getParameter(request, prefix + "rc_flg_prop", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setChgCd1(JSPUtil.getParameter(request, prefix + "chg_cd1", ""));
		setCtrtCustTpCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRdnStsNm(JSPUtil.getParameter(request, prefix + "rdn_sts_nm", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setAwkCgoFlgProp(JSPUtil.getParameter(request, prefix + "awk_cgo_flg_prop", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setAutoRatCd(JSPUtil.getParameter(request, prefix + "auto_rat_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setBillTypeB(JSPUtil.getParameter(request, prefix + "bill_type_b", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBillTypeC(JSPUtil.getParameter(request, prefix + "bill_type_c", ""));
		setRatAsQty(JSPUtil.getParameter(request, prefix + "rat_as_qty", ""));
		setBillTypeN(JSPUtil.getParameter(request, prefix + "bill_type_n", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setBillTypeM(JSPUtil.getParameter(request, prefix + "bill_type_m", ""));
		setSplitFlg(JSPUtil.getParameter(request, prefix + "split_flg", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setRaterId(JSPUtil.getParameter(request, prefix + "rater_id", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setBkgRhqCd(JSPUtil.getParameter(request, prefix + "bkg_rhq_cd", ""));
		setCCustNm(JSPUtil.getParameter(request, prefix + "c_cust_nm", ""));
		setRdnNo(JSPUtil.getParameter(request, prefix + "rdn_no", ""));
		setChargeNm(JSPUtil.getParameter(request, prefix + "charge_nm", ""));
		setEqSubstFlg(JSPUtil.getParameter(request, prefix + "eq_subst_flg", ""));
		setEqSubstFlgProp(JSPUtil.getParameter(request, prefix + "eq_subst_flg_prop", ""));
		setUsaSvcModCd(JSPUtil.getParameter(request, prefix + "usa_svc_mod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setHngrFlgProp(JSPUtil.getParameter(request, prefix + "hngr_flg_prop", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setSplitNm(JSPUtil.getParameter(request, prefix + "split_nm", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setCargoType(JSPUtil.getParameter(request, prefix + "cargo_type", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setCtrtCustNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_nm", ""));
		setBkgStsNm(JSPUtil.getParameter(request, prefix + "bkg_sts_nm", ""));
		setAutoRatFlg(JSPUtil.getParameter(request, prefix + "auto_rat_flg", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setNCustNm(JSPUtil.getParameter(request, prefix + "n_cust_nm", ""));
		setDcgoFlgProp(JSPUtil.getParameter(request, prefix + "dcgo_flg_prop", ""));
		setChgUtAmt(JSPUtil.getParameter(request, prefix + "chg_ut_amt", ""));
		setBkgCtrtTpNm(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_nm", ""));
		setSCustNm(JSPUtil.getParameter(request, prefix + "s_cust_nm", ""));
		setAutoRatNm(JSPUtil.getParameter(request, prefix + "auto_rat_nm", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setBkgSeq(JSPUtil.getParameter(request, prefix + "bkg_seq", ""));
		setRdCgoFlgProp(JSPUtil.getParameter(request, prefix + "rd_cgo_flg_prop", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setChargeFlg(JSPUtil.getParameter(request, prefix + "charge_flg", ""));
		setCtrtCustValSgmNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_val_sgm_nm", ""));
		setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
		setBbCgoFlgProp(JSPUtil.getParameter(request, prefix + "bb_cgo_flg_prop", ""));
		setRtBlTpNm(JSPUtil.getParameter(request, prefix + "rt_bl_tp_nm", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
		setChargeType(JSPUtil.getParameter(request, prefix + "charge_type", ""));
		setChargeCondition(JSPUtil.getParameter(request, prefix + "charge_condition", ""));
		setInrAuthNo(JSPUtil.getParameter(request, prefix + "inr_auth_no", ""));	
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchChargeFilteringListVO[]
	 */
	public RsltSearchChargeFilteringListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchChargeFilteringListVO[]
	 */
	public RsltSearchChargeFilteringListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchChargeFilteringListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] usaSvcModNm = (JSPUtil.getParameter(request, prefix	+ "usa_svc_mod_nm", length));
			String[] rtBlTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_bl_tp_cd", length));
			String[] searchDate = (JSPUtil.getParameter(request, prefix	+ "search_date", length));
			String[] rcFlgProp = (JSPUtil.getParameter(request, prefix	+ "rc_flg_prop", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] chgCd1 = (JSPUtil.getParameter(request, prefix	+ "chg_cd1", length));
			String[] ctrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rdnStsNm = (JSPUtil.getParameter(request, prefix	+ "rdn_sts_nm", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] awkCgoFlgProp = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg_prop", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] autoRatCd = (JSPUtil.getParameter(request, prefix	+ "auto_rat_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] billTypeB = (JSPUtil.getParameter(request, prefix	+ "bill_type_b", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] billTypeC = (JSPUtil.getParameter(request, prefix	+ "bill_type_c", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] billTypeN = (JSPUtil.getParameter(request, prefix	+ "bill_type_n", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] billTypeM = (JSPUtil.getParameter(request, prefix	+ "bill_type_m", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] raterId = (JSPUtil.getParameter(request, prefix	+ "rater_id", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] bkgRhqCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rhq_cd", length));
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm", length));
			String[] rdnNo = (JSPUtil.getParameter(request, prefix	+ "rdn_no", length));
			String[] chargeNm = (JSPUtil.getParameter(request, prefix	+ "charge_nm", length));
			String[] eqSubstFlg = (JSPUtil.getParameter(request, prefix	+ "eq_subst_flg", length));
			String[] eqSubstFlgProp = (JSPUtil.getParameter(request, prefix	+ "eq_subst_flg_prop", length));
			String[] usaSvcModCd = (JSPUtil.getParameter(request, prefix	+ "usa_svc_mod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hngrFlgProp = (JSPUtil.getParameter(request, prefix	+ "hngr_flg_prop", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] splitNm = (JSPUtil.getParameter(request, prefix	+ "split_nm", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] cargoType = (JSPUtil.getParameter(request, prefix	+ "cargo_type", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] ctrtCustNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_nm", length));
			String[] bkgStsNm = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_nm", length));
			String[] autoRatFlg = (JSPUtil.getParameter(request, prefix	+ "auto_rat_flg", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] nCustNm = (JSPUtil.getParameter(request, prefix	+ "n_cust_nm", length));
			String[] dcgoFlgProp = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg_prop", length));
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] bkgCtrtTpNm = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_nm", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] autoRatNm = (JSPUtil.getParameter(request, prefix	+ "auto_rat_nm", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] bkgSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_seq", length));
			String[] rdCgoFlgProp = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg_prop", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] chargeFlg = (JSPUtil.getParameter(request, prefix	+ "charge_flg", length));
			String[] ctrtCustValSgmNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_val_sgm_nm", length));
			String[] hngrFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_flg", length));
			String[] bbCgoFlgProp = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg_prop", length));
			String[] rtBlTpNm = (JSPUtil.getParameter(request, prefix	+ "rt_bl_tp_nm", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] chargeType = (JSPUtil.getParameter(request, prefix	+ "charge_type", length));
			String[] chargeCondition = (JSPUtil.getParameter(request, prefix	+ "charge_condition", length));
			String[] inrAuthNo = (JSPUtil.getParameter(request, prefix	+ "inr_auth_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchChargeFilteringListVO();
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (usaSvcModNm[i] != null)
					model.setUsaSvcModNm(usaSvcModNm[i]);
				if (rtBlTpCd[i] != null)
					model.setRtBlTpCd(rtBlTpCd[i]);
				if (searchDate[i] != null)
					model.setSearchDate(searchDate[i]);
				if (rcFlgProp[i] != null)
					model.setRcFlgProp(rcFlgProp[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (chgCd1[i] != null)
					model.setChgCd1(chgCd1[i]);
				if (ctrtCustTpCd[i] != null)
					model.setCtrtCustTpCd(ctrtCustTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rdnStsNm[i] != null)
					model.setRdnStsNm(rdnStsNm[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (awkCgoFlgProp[i] != null)
					model.setAwkCgoFlgProp(awkCgoFlgProp[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (autoRatCd[i] != null)
					model.setAutoRatCd(autoRatCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (billTypeB[i] != null)
					model.setBillTypeB(billTypeB[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (billTypeC[i] != null)
					model.setBillTypeC(billTypeC[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				if (billTypeN[i] != null)
					model.setBillTypeN(billTypeN[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (billTypeM[i] != null)
					model.setBillTypeM(billTypeM[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (raterId[i] != null)
					model.setRaterId(raterId[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bkgRhqCd[i] != null)
					model.setBkgRhqCd(bkgRhqCd[i]);
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (rdnNo[i] != null)
					model.setRdnNo(rdnNo[i]);
				if (chargeNm[i] != null)
					model.setChargeNm(chargeNm[i]);
				if (eqSubstFlg[i] != null)
					model.setEqSubstFlg(eqSubstFlg[i]);
				if (eqSubstFlgProp[i] != null)
					model.setEqSubstFlgProp(eqSubstFlgProp[i]);
				if (usaSvcModCd[i] != null)
					model.setUsaSvcModCd(usaSvcModCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hngrFlgProp[i] != null)
					model.setHngrFlgProp(hngrFlgProp[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (splitNm[i] != null)
					model.setSplitNm(splitNm[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (cargoType[i] != null)
					model.setCargoType(cargoType[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (ctrtCustNm[i] != null)
					model.setCtrtCustNm(ctrtCustNm[i]);
				if (bkgStsNm[i] != null)
					model.setBkgStsNm(bkgStsNm[i]);
				if (autoRatFlg[i] != null)
					model.setAutoRatFlg(autoRatFlg[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (nCustNm[i] != null)
					model.setNCustNm(nCustNm[i]);
				if (dcgoFlgProp[i] != null)
					model.setDcgoFlgProp(dcgoFlgProp[i]);
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (bkgCtrtTpNm[i] != null)
					model.setBkgCtrtTpNm(bkgCtrtTpNm[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (autoRatNm[i] != null)
					model.setAutoRatNm(autoRatNm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (bkgSeq[i] != null)
					model.setBkgSeq(bkgSeq[i]);
				if (rdCgoFlgProp[i] != null)
					model.setRdCgoFlgProp(rdCgoFlgProp[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (chargeFlg[i] != null)
					model.setChargeFlg(chargeFlg[i]);
				if (ctrtCustValSgmNm[i] != null)
					model.setCtrtCustValSgmNm(ctrtCustValSgmNm[i]);
				if (hngrFlg[i] != null)
					model.setHngrFlg(hngrFlg[i]);
				if (bbCgoFlgProp[i] != null)
					model.setBbCgoFlgProp(bbCgoFlgProp[i]);
				if (rtBlTpNm[i] != null)
					model.setRtBlTpNm(rtBlTpNm[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (chargeType[i] != null)
					model.setChargeType(chargeType[i]);
				if (chargeCondition[i] != null)
					model.setChargeCondition(chargeCondition[i]);
				if (inrAuthNo[i] != null)
					model.setInrAuthNo(inrAuthNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchChargeFilteringListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchChargeFilteringListVO[]
	 */
	public RsltSearchChargeFilteringListVO[] getRsltSearchChargeFilteringListVOs(){
		RsltSearchChargeFilteringListVO[] vos = (RsltSearchChargeFilteringListVO[])models.toArray(new RsltSearchChargeFilteringListVO[models.size()]);
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
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaSvcModNm = this.usaSvcModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtBlTpCd = this.rtBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDate = this.searchDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlgProp = this.rcFlgProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd1 = this.chgCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustTpCd = this.ctrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnStsNm = this.rdnStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlgProp = this.awkCgoFlgProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatCd = this.autoRatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billTypeB = this.billTypeB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billTypeC = this.billTypeC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billTypeN = this.billTypeN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billTypeM = this.billTypeM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raterId = this.raterId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRhqCd = this.bkgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnNo = this.rdnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeNm = this.chargeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstFlg = this.eqSubstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstFlgProp = this.eqSubstFlgProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaSvcModCd = this.usaSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlgProp = this.hngrFlgProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitNm = this.splitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoType = this.cargoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustNm = this.ctrtCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsNm = this.bkgStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatFlg = this.autoRatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustNm = this.nCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlgProp = this.dcgoFlgProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpNm = this.bkgCtrtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatNm = this.autoRatNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq = this.bkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlgProp = this.rdCgoFlgProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeFlg = this.chargeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustValSgmNm = this.ctrtCustValSgmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlg = this.hngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlgProp = this.bbCgoFlgProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtBlTpNm = this.rtBlTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeType = this.chargeType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeCondition = this.chargeCondition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inrAuthNo = this.inrAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
