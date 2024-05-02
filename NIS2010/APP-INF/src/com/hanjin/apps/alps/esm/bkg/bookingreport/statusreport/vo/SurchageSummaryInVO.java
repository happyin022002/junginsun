/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SurchageSummaryInVO.java
*@FileTitle : SurchageSummaryInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.03
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.09.03 조원주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 조원주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SurchageSummaryInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SurchageSummaryInVO> models = new ArrayList<SurchageSummaryInVO>();
	
	/* Column Info */
	private String ratingTtl = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String pRhqCtrtOfcCd = null;
	/* Column Info */
	private String pSelOfcCd = null;
	private String pSelOfcCd2 = null;
	/* Column Info */
	private String pCtrtOfcCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String gsoBkgOfcCd = null;
	/* Column Info */
	private String customerCode = null;
	/* Column Info */
	private String contractNo = null;
	/* Column Info */
	private String pGsoBkgOfcCd = null;
	/* Column Info */
	private String pPolCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String rhqCtrtOfcCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String podCntCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String polCntCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String blRateCnt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String pRhqBkgOfcCd = null;
	/* Column Info */
	private String aplyDt = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String pSvcScpCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String paymentTermCd = null;
	/* Column Info */
	private String frDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pDelCd = null;
	/* Column Info */
	private String ctrRfaNo = null;
	/* Column Info */
	private String customerName = null;
	/* Column Info */
	private String rhqBkgOfcCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String pPodCd = null;
	/* Column Info */
	private String chargeCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String charge = null;
	/* Column Info */
	private String termCd = null;
	/* Column Info */
	private String tabCd = null;
	/* Column Info */
	private String pPorCd = null;
	/* Column Info */
	private String applRatio = null;
	/* Column Info */
	private String blCnt = null;
	/* Column Info */
	private String ctrRfaCd = null;
	/* Column Info */
	private String surrenderOfcCd = null;
	/* Column Info */
	private String surrenderDt = null;
	/* Column Info */
	private String reissueOfcCd = null;
	/* Column Info */
	private String reissueDt = null;
	/* Column Info */
	private String corrOfcCd = null;
	private String oblIssOfcCd = null;
	
	private String ocLocalDate = null;
	private String scope       = null;
	private String custNm      = null;
	private String blNo        = null;
	private String etd         = null;
	private String chgAmt      = null;
	private String lbpCnt      = null;
	private String blObrdDt    = null;
	private String updUsrId    = null;	
	private String oblIssDt    = null;
	
	
	private String scNo          = null;
	private String frtTermCd     = null;
	private String ppdRcvOfcCd   = null;
	private String cltOfcCd      = null;
	private String n3ptyRcvOfcCd = null;
	private String ppd3rd = null;
	private String cct3rd = null;
	
	private String rfaNo;
	private String flag;

	
	
	private String fCmd       = null;//DAO의 exel down을 위해 사용함.
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SurchageSummaryInVO() {}

	public SurchageSummaryInVO(String ibflag, String pagerows, String tabCd, String chargeCd, String frDt, String toDt, String pRhqBkgOfcCd, String pGsoBkgOfcCd, String pRhqCtrtOfcCd, String pCtrtOfcCd, String pSelOfcCd,String pSelOfcCd2, String ctrRfaNo, String pPorCd, String pPolCd, String pPodCd, String pDelCd, String pSvcScpCd, String bkgNo, String trdCd, String subTrdCd, String svcScpCd, String skdDirCd, String slanCd, String vvd, String rhqBkgOfcCd, String gsoBkgOfcCd, String bkgOfcCd, String aplyDt, String contractNo, String customerCode, String customerName, String rhqCtrtOfcCd, String ctrtOfcCd, String teu, String porCd, String polCd, String polCntCd, String podCd, String podCntCd, String delCd, String termCd, String charge, String paymentTermCd, String chgCd, String currCd, String blCnt, String blRateCnt, String applRatio, String ratingTtl, String ctrRfaCd,String surrenderOfcCd,String surrenderDt,String reissueOfcCd,String reissueDt,String corrOfcCd,String oblIssOfcCd
							  ,String ocLocalDate, String scope,  String custNm, String blNo, String etd, String chgAmt,String lbpCnt, String blObrdDt, String updUsrId,  String oblIssDt
							  ,String scNo, String frtTermCd, String ppdRcvOfcCd,String cltOfcCd,String n3ptyRcvOfcCd,String ppd3rd, String cct3rd
							  ,String rfaNo, String flag
								) {
		this.ratingTtl = ratingTtl;
		this.svcScpCd = svcScpCd;
		this.trdCd = trdCd;
		this.pRhqCtrtOfcCd = pRhqCtrtOfcCd;
		this.pSelOfcCd = pSelOfcCd;
		this.pSelOfcCd2 = pSelOfcCd2;
		this.pCtrtOfcCd = pCtrtOfcCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.gsoBkgOfcCd = gsoBkgOfcCd;
		this.customerCode = customerCode;
		this.contractNo = contractNo;
		this.pGsoBkgOfcCd = pGsoBkgOfcCd;
		this.pPolCd = pPolCd;
		this.bkgOfcCd = bkgOfcCd;
		this.rhqCtrtOfcCd = rhqCtrtOfcCd;
		this.delCd = delCd;
		this.podCntCd = podCntCd;
		this.vvd = vvd;
		this.toDt = toDt;
		this.polCntCd = polCntCd;
		this.podCd = podCd;
		this.blRateCnt = blRateCnt;
		this.bkgNo = bkgNo;
		this.pRhqBkgOfcCd = pRhqBkgOfcCd;
		this.aplyDt = aplyDt;
		this.teu = teu;
		this.pSvcScpCd = pSvcScpCd;
		this.subTrdCd = subTrdCd;
		this.porCd = porCd;
		this.currCd = currCd;
		this.paymentTermCd = paymentTermCd;
		this.frDt = frDt;
		this.ibflag = ibflag;
		this.pDelCd = pDelCd;
		this.ctrRfaNo = ctrRfaNo;
		this.customerName = customerName;
		this.rhqBkgOfcCd = rhqBkgOfcCd;
		this.skdDirCd = skdDirCd;
		this.pPodCd = pPodCd;
		this.chargeCd = chargeCd;
		this.slanCd = slanCd;
		this.charge = charge;
		this.termCd = termCd;
		this.tabCd = tabCd;
		this.pPorCd = pPorCd;
		this.applRatio = applRatio;
		this.blCnt = blCnt;
		this.ctrRfaCd = ctrRfaCd;
		this.surrenderOfcCd = surrenderOfcCd;
		this.surrenderDt = surrenderDt;
		this.reissueOfcCd = reissueOfcCd;
		this.reissueDt = reissueDt;
		this.corrOfcCd = corrOfcCd;
		this.oblIssOfcCd = oblIssOfcCd;
		
		this.ocLocalDate = ocLocalDate;
		this.scope       = scope;
		this.custNm      = custNm;
		this.blNo        = blNo;
		this.etd         = etd;
		this.chgAmt      = chgAmt;
		this.lbpCnt      = lbpCnt;
		this.blObrdDt    = blObrdDt;
		this.updUsrId    = updUsrId;
		this.oblIssDt    = oblIssDt;
		
		this.scNo          = scNo         ;
		this.frtTermCd     = frtTermCd    ;
		this.ppdRcvOfcCd   = ppdRcvOfcCd  ;
		this.cltOfcCd      = cltOfcCd     ;
		this.n3ptyRcvOfcCd = n3ptyRcvOfcCd;
		this.ppd3rd = ppd3rd;
		this.cct3rd = cct3rd;
		this.rfaNo = rfaNo;
		this.flag = flag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rating_ttl", getRatingTtl());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("p_rhq_ctrt_ofc_cd", getPRhqCtrtOfcCd());
		this.hashColumns.put("p_sel_ofc_cd", getPSelOfcCd());
		this.hashColumns.put("p_sel_ofc_cd2", getPSelOfcCd2());
		this.hashColumns.put("p_ctrt_ofc_cd", getPCtrtOfcCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("gso_bkg_ofc_cd", getGsoBkgOfcCd());
		this.hashColumns.put("customer_code", getCustomerCode());
		this.hashColumns.put("contract_no", getContractNo());
		this.hashColumns.put("p_gso_bkg_ofc_cd", getPGsoBkgOfcCd());
		this.hashColumns.put("p_pol_cd", getPPolCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("rhq_ctrt_ofc_cd", getRhqCtrtOfcCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pod_cnt_cd", getPodCntCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("pol_cnt_cd", getPolCntCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bl_rate_cnt", getBlRateCnt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("p_rhq_bkg_ofc_cd", getPRhqBkgOfcCd());
		this.hashColumns.put("aply_dt", getAplyDt());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("p_svc_scp_cd", getPSvcScpCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("payment_term_cd", getPaymentTermCd());
		this.hashColumns.put("fr_dt", getFrDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_del_cd", getPDelCd());
		this.hashColumns.put("ctr_rfa_no", getCtrRfaNo());
		this.hashColumns.put("customer_name", getCustomerName());
		this.hashColumns.put("rhq_bkg_ofc_cd", getRhqBkgOfcCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("p_pod_cd", getPPodCd());
		this.hashColumns.put("charge_cd", getChargeCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("charge", getCharge());
		this.hashColumns.put("term_cd", getTermCd());
		this.hashColumns.put("tab_cd", getTabCd());
		this.hashColumns.put("p_por_cd", getPPorCd());
		this.hashColumns.put("appl_ratio", getApplRatio());
		this.hashColumns.put("bl_cnt", getBlCnt());
		this.hashColumns.put("ctr_rfa_cd", getCtrRfaCd());
		this.hashColumns.put("surrender_ofc_cd", getSurrenderOfcCd());
		this.hashColumns.put("surrender_dt", getSurrenderDt());
		this.hashColumns.put("reissue_ofc_cd", getReissueOfcCd());
		this.hashColumns.put("reissue_dt", getReissueDt());
		this.hashColumns.put("corr_ofc_cd", getCorrOfcCd());
		this.hashColumns.put("obl_iss_ofc_cd", getOblIssOfcCd());
		
		

		this.hashColumns.put("oc_local_date", getOcLocalDate());
		this.hashColumns.put("scope", getScope());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("lbp_cnt", getLbpCnt());
		this.hashColumns.put("bl_obrd_dt", getBlObrdDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("obl_iss_dt", getOblIssDt());
		
		
		this.hashColumns.put("sc_no",          getScNo());
	    this.hashColumns.put("frt_term_cd",     getFrtTermCd());
		this.hashColumns.put("ppd_rcv_ofc_cd",   getPpdRcvOfcCd ());
		this.hashColumns.put("clt_ofc_cd"    ,  getCltOfcCd());
		this.hashColumns.put("n3pty_rcv_ofc_cd", getN3ptyRcvOfcCd());
		this.hashColumns.put("ppd_3rd", getPpd3rd());
		this.hashColumns.put("cct_3rd", getCct3rd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("flag", getFlag());
		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rating_ttl", "ratingTtl");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("p_rhq_ctrt_ofc_cd", "pRhqCtrtOfcCd");
		this.hashFields.put("p_sel_ofc_cd", "pSelOfcCd");
		this.hashFields.put("p_sel_ofc_cd2", "pSelOfcCd2");
		this.hashFields.put("p_ctrt_ofc_cd", "pCtrtOfcCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("gso_bkg_ofc_cd", "gsoBkgOfcCd");
		this.hashFields.put("customer_code", "customerCode");
		this.hashFields.put("contract_no", "contractNo");
		this.hashFields.put("p_gso_bkg_ofc_cd", "pGsoBkgOfcCd");
		this.hashFields.put("p_pol_cd", "pPolCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("rhq_ctrt_ofc_cd", "rhqCtrtOfcCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pod_cnt_cd", "podCntCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("pol_cnt_cd", "polCntCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bl_rate_cnt", "blRateCnt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("p_rhq_bkg_ofc_cd", "pRhqBkgOfcCd");
		this.hashFields.put("aply_dt", "aplyDt");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("p_svc_scp_cd", "pSvcScpCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("payment_term_cd", "paymentTermCd");
		this.hashFields.put("fr_dt", "frDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_del_cd", "pDelCd");
		this.hashFields.put("ctr_rfa_no", "ctrRfaNo");
		this.hashFields.put("customer_name", "customerName");
		this.hashFields.put("rhq_bkg_ofc_cd", "rhqBkgOfcCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("p_pod_cd", "pPodCd");
		this.hashFields.put("charge_cd", "chargeCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("charge", "charge");
		this.hashFields.put("term_cd", "termCd");
		this.hashFields.put("tab_cd", "tabCd");
		this.hashFields.put("p_por_cd", "pPorCd");
		this.hashFields.put("appl_ratio", "applRatio");
		this.hashFields.put("bl_cnt", "blCnt");
		this.hashFields.put("ctr_rfa_cd", "ctrRfaCd");
		this.hashFields.put("surrender_ofc_cd", "surrenderOfcCd");
		this.hashFields.put("surrender_dt", "surrenderDt");
		this.hashFields.put("reissue_ofc_cd", "reissueOfcCd");
		this.hashFields.put("reissue_dt", "reissueDt");
		this.hashFields.put("corr_ofc_cd", "corrOfcCd");
		this.hashFields.put("obl_iss_ofc_cd", "oblIssOfcCd");
		
		this.hashFields.put("oc_local_date", "ocLocalDate");
		this.hashFields.put("scope", "scope");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("lbp_cnt", "lbpCnt");
		this.hashFields.put("bl_obrd_dt", "blObrdDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("obl_iss_dt", "oblIssDt");
		
		
		this.hashFields.put("sc_no"            ,"scNo");
		this.hashFields.put("frt_term_cd"      ,"frtTermCd");
		this.hashFields.put("ppd_rcv_ofc_cd"   ,"ppdRcvOfcCd");
		this.hashFields.put("clt_ofc_cd"       ,"cltOfcCd");
		this.hashFields.put("n3pty_rcv_ofc_cd" ,"n3ptyRcvOfcCd");
		this.hashFields.put("ppd_3rd" ,"ppd3rd");
		this.hashFields.put("cct_3rd" ,"cct3rd");
		this.hashFields.put("rfa_no" ,"rfaNo");
		this.hashFields.put("flag" ,"flag");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ratingTtl
	 */
	public String getRatingTtl() {
		return this.ratingTtl;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return pRhqCtrtOfcCd
	 */
	public String getPRhqCtrtOfcCd() {
		return this.pRhqCtrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return pSelOfcCd
	 */
	public String getPSelOfcCd() {
		return this.pSelOfcCd;
	}
	
	/**
	 * Column Info
	 * @return pCtrtOfcCd
	 */
	public String getPCtrtOfcCd() {
		return this.pCtrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return gsoBkgOfcCd
	 */
	public String getGsoBkgOfcCd() {
		return this.gsoBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return customerCode
	 */
	public String getCustomerCode() {
		return this.customerCode;
	}
	
	/**
	 * Column Info
	 * @return contractNo
	 */
	public String getContractNo() {
		return this.contractNo;
	}
	
	/**
	 * Column Info
	 * @return pGsoBkgOfcCd
	 */
	public String getPGsoBkgOfcCd() {
		return this.pGsoBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return pPolCd
	 */
	public String getPPolCd() {
		return this.pPolCd;
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
	 * @return rhqCtrtOfcCd
	 */
	public String getRhqCtrtOfcCd() {
		return this.rhqCtrtOfcCd;
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
	 * @return podCntCd
	 */
	public String getPodCntCd() {
		return this.podCntCd;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return polCntCd
	 */
	public String getPolCntCd() {
		return this.polCntCd;
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
	 * @return blRateCnt
	 */
	public String getBlRateCnt() {
		return this.blRateCnt;
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
	 * @return pRhqBkgOfcCd
	 */
	public String getPRhqBkgOfcCd() {
		return this.pRhqBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return aplyDt
	 */
	public String getAplyDt() {
		return this.aplyDt;
	}
	
	/**
	 * Column Info
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	
	/**
	 * Column Info
	 * @return pSvcScpCd
	 */
	public String getPSvcScpCd() {
		return this.pSvcScpCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return paymentTermCd
	 */
	public String getPaymentTermCd() {
		return this.paymentTermCd;
	}
	
	/**
	 * Column Info
	 * @return frDt
	 */
	public String getFrDt() {
		return this.frDt;
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
	 * @return pDelCd
	 */
	public String getPDelCd() {
		return this.pDelCd;
	}
	
	/**
	 * Column Info
	 * @return ctrRfaNo
	 */
	public String getCtrRfaNo() {
		return this.ctrRfaNo;
	}
	
	/**
	 * Column Info
	 * @return customerName
	 */
	public String getCustomerName() {
		return this.customerName;
	}
	
	/**
	 * Column Info
	 * @return rhqBkgOfcCd
	 */
	public String getRhqBkgOfcCd() {
		return this.rhqBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return pPodCd
	 */
	public String getPPodCd() {
		return this.pPodCd;
	}
	
	/**
	 * Column Info
	 * @return chargeCd
	 */
	public String getChargeCd() {
		return this.chargeCd;
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
	 * @return charge
	 */
	public String getCharge() {
		return this.charge;
	}
	
	/**
	 * Column Info
	 * @return termCd
	 */
	public String getTermCd() {
		return this.termCd;
	}
	
	/**
	 * Column Info
	 * @return tabCd
	 */
	public String getTabCd() {
		return this.tabCd;
	}
	
	/**
	 * Column Info
	 * @return pPorCd
	 */
	public String getPPorCd() {
		return this.pPorCd;
	}
	
	/**
	 * Column Info
	 * @return applRatio
	 */
	public String getApplRatio() {
		return this.applRatio;
	}
	
	/**
	 * Column Info
	 * @return blCnt
	 */
	public String getBlCnt() {
		return this.blCnt;
	}
	
	/**
	 * Column Info
	 * @return ctrRfaCd
	 */
	public String getCtrRfaCd() {
		return this.ctrRfaCd;
	}
	/**
	 * Column Info
	 * @return surrenderOfcCd
	 */
	public String getSurrenderOfcCd() {
		return this.surrenderOfcCd;
	}
	/**
	 * Column Info
	 * @return surrenderDt
	 */
	public String getSurrenderDt() {
		return this.surrenderDt;
	}
	/**
	 * Column Info
	 * @return reissueOfcCd
	 */
	public String getReissueOfcCd() {
		return this.reissueOfcCd;
	}
	/**
	 * Column Info
	 * @return reissueDt
	 */
	public String getReissueDt() {
		return this.reissueDt;
	}
	/**
	 * Column Info
	 * @return corrOfcCd
	 */
	public String getCorrOfcCd() {
		return this.corrOfcCd;
	}	
	

	/**
	 * Column Info
	 * @param ratingTtl
	 */
	public void setRatingTtl(String ratingTtl) {
		this.ratingTtl = ratingTtl;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param pRhqCtrtOfcCd
	 */
	public void setPRhqCtrtOfcCd(String pRhqCtrtOfcCd) {
		this.pRhqCtrtOfcCd = pRhqCtrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param pSelOfcCd
	 */
	public void setPSelOfcCd(String pSelOfcCd) {
		this.pSelOfcCd = pSelOfcCd;
	}
	
	/**
	 * Column Info
	 * @param pCtrtOfcCd
	 */
	public void setPCtrtOfcCd(String pCtrtOfcCd) {
		this.pCtrtOfcCd = pCtrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param gsoBkgOfcCd
	 */
	public void setGsoBkgOfcCd(String gsoBkgOfcCd) {
		this.gsoBkgOfcCd = gsoBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param customerCode
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	/**
	 * Column Info
	 * @param contractNo
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	/**
	 * Column Info
	 * @param pGsoBkgOfcCd
	 */
	public void setPGsoBkgOfcCd(String pGsoBkgOfcCd) {
		this.pGsoBkgOfcCd = pGsoBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param pPolCd
	 */
	public void setPPolCd(String pPolCd) {
		this.pPolCd = pPolCd;
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
	 * @param rhqCtrtOfcCd
	 */
	public void setRhqCtrtOfcCd(String rhqCtrtOfcCd) {
		this.rhqCtrtOfcCd = rhqCtrtOfcCd;
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
	 * @param podCntCd
	 */
	public void setPodCntCd(String podCntCd) {
		this.podCntCd = podCntCd;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param polCntCd
	 */
	public void setPolCntCd(String polCntCd) {
		this.polCntCd = polCntCd;
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
	 * @param blRateCnt
	 */
	public void setBlRateCnt(String blRateCnt) {
		this.blRateCnt = blRateCnt;
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
	 * @param pRhqBkgOfcCd
	 */
	public void setPRhqBkgOfcCd(String pRhqBkgOfcCd) {
		this.pRhqBkgOfcCd = pRhqBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param aplyDt
	 */
	public void setAplyDt(String aplyDt) {
		this.aplyDt = aplyDt;
	}
	
	/**
	 * Column Info
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Column Info
	 * @param pSvcScpCd
	 */
	public void setPSvcScpCd(String pSvcScpCd) {
		this.pSvcScpCd = pSvcScpCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param paymentTermCd
	 */
	public void setPaymentTermCd(String paymentTermCd) {
		this.paymentTermCd = paymentTermCd;
	}
	
	/**
	 * Column Info
	 * @param frDt
	 */
	public void setFrDt(String frDt) {
		this.frDt = frDt;
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
	 * @param pDelCd
	 */
	public void setPDelCd(String pDelCd) {
		this.pDelCd = pDelCd;
	}
	
	/**
	 * Column Info
	 * @param ctrRfaNo
	 */
	public void setCtrRfaNo(String ctrRfaNo) {
		this.ctrRfaNo = ctrRfaNo;
	}
	
	/**
	 * Column Info
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	/**
	 * Column Info
	 * @param rhqBkgOfcCd
	 */
	public void setRhqBkgOfcCd(String rhqBkgOfcCd) {
		this.rhqBkgOfcCd = rhqBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param pPodCd
	 */
	public void setPPodCd(String pPodCd) {
		this.pPodCd = pPodCd;
	}
	
	/**
	 * Column Info
	 * @param chargeCd
	 */
	public void setChargeCd(String chargeCd) {
		this.chargeCd = chargeCd;
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
	 * @param charge
	 */
	public void setCharge(String charge) {
		this.charge = charge;
	}
	
	/**
	 * Column Info
	 * @param termCd
	 */
	public void setTermCd(String termCd) {
		this.termCd = termCd;
	}
	
	/**
	 * Column Info
	 * @param tabCd
	 */
	public void setTabCd(String tabCd) {
		this.tabCd = tabCd;
	}
	
	/**
	 * Column Info
	 * @param pPorCd
	 */
	public void setPPorCd(String pPorCd) {
		this.pPorCd = pPorCd;
	}
	
	/**
	 * Column Info
	 * @param applRatio
	 */
	public void setApplRatio(String applRatio) {
		this.applRatio = applRatio;
	}
	
	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
	}
	
	/**
	 * Column Info
	 * @param ctrRfaCd
	 */
	public void setCtrRfaCd(String ctrRfaCd) {
		this.ctrRfaCd = ctrRfaCd;
	}
	/**
	 * Column Info
	 * @param surrenderOfcCd
	 */
	public void setSurrenderOfcCd(String surrenderOfcCd) {
		this.surrenderOfcCd = surrenderOfcCd;
	}
	/**
	 * Column Info
	 * @param surrenderDt
	 */
	public void setSurrenderDt(String surrenderDt) {
		this.surrenderDt = surrenderDt;
	}
	/**
	 * Column Info
	 * @param reissueOfcCd
	 */
	public void setReissueOfcCd(String reissueOfcCd) {
		this.reissueOfcCd = reissueOfcCd;
	}
	/**
	 * Column Info
	 * @param reissueDt
	 */
	public void setReissueDt(String reissueDt) {
		this.reissueDt = reissueDt;
	}
	/**
	 * Column Info
	 * @param corrOfcCd
	 */
	public void setCorrOfcCd(String corrOfcCd) {
		this.reissueDt = corrOfcCd;
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
		setRatingTtl(JSPUtil.getParameter(request, prefix + "rating_ttl", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setPRhqCtrtOfcCd(JSPUtil.getParameter(request, prefix + "p_rhq_ctrt_ofc_cd", ""));
		setPSelOfcCd(JSPUtil.getParameter(request, prefix + "p_sel_ofc_cd", ""));
		setPSelOfcCd2(JSPUtil.getParameter(request, prefix + "p_sel_ofc_cd2", ""));
		setPCtrtOfcCd(JSPUtil.getParameter(request, prefix + "p_ctrt_ofc_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setGsoBkgOfcCd(JSPUtil.getParameter(request, prefix + "gso_bkg_ofc_cd", ""));
		setCustomerCode(JSPUtil.getParameter(request, prefix + "customer_code", ""));
		setContractNo(JSPUtil.getParameter(request, prefix + "contract_no", ""));
		setPGsoBkgOfcCd(JSPUtil.getParameter(request, prefix + "p_gso_bkg_ofc_cd", ""));
		setPPolCd(JSPUtil.getParameter(request, prefix + "p_pol_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setRhqCtrtOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ctrt_ofc_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPodCntCd(JSPUtil.getParameter(request, prefix + "pod_cnt_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setPolCntCd(JSPUtil.getParameter(request, prefix + "pol_cnt_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBlRateCnt(JSPUtil.getParameter(request, prefix + "bl_rate_cnt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPRhqBkgOfcCd(JSPUtil.getParameter(request, prefix + "p_rhq_bkg_ofc_cd", ""));
		setAplyDt(JSPUtil.getParameter(request, prefix + "aply_dt", ""));
		setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
		setPSvcScpCd(JSPUtil.getParameter(request, prefix + "p_svc_scp_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPaymentTermCd(JSPUtil.getParameter(request, prefix + "payment_term_cd", ""));
		setFrDt(JSPUtil.getParameter(request, prefix + "fr_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPDelCd(JSPUtil.getParameter(request, prefix + "p_del_cd", ""));
		setCtrRfaNo(JSPUtil.getParameter(request, prefix + "ctr_rfa_no", ""));
		setCustomerName(JSPUtil.getParameter(request, prefix + "customer_name", ""));
		setRhqBkgOfcCd(JSPUtil.getParameter(request, prefix + "rhq_bkg_ofc_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPPodCd(JSPUtil.getParameter(request, prefix + "p_pod_cd", ""));
		setChargeCd(JSPUtil.getParameter(request, prefix + "charge_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setCharge(JSPUtil.getParameter(request, prefix + "charge", ""));
		setTermCd(JSPUtil.getParameter(request, prefix + "term_cd", ""));
		setTabCd(JSPUtil.getParameter(request, prefix + "tab_cd", ""));
		setPPorCd(JSPUtil.getParameter(request, prefix + "p_por_cd", ""));
		setApplRatio(JSPUtil.getParameter(request, prefix + "appl_ratio", ""));
		setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
		setCtrRfaCd(JSPUtil.getParameter(request, prefix + "ctr_rfa_cd", ""));
		setSurrenderOfcCd(JSPUtil.getParameter(request, prefix + "surrender_ofc_cd", ""));
		setSurrenderDt(JSPUtil.getParameter(request, prefix + "surrender_dt", ""));
		setReissueOfcCd(JSPUtil.getParameter(request, prefix + "reissue_ofc_cd", ""));
		setReissueDt(JSPUtil.getParameter(request, prefix + "reissue_dt", ""));
		setCorrOfcCd(JSPUtil.getParameter(request, prefix + "corr_ofc_cd", ""));
		setOblIssOfcCd(JSPUtil.getParameter(request, prefix + "obl_iss_ofc_cd", ""));
		
		
		
		setOcLocalDate(JSPUtil.getParameter(request, prefix + "oc_local_date", ""));
		setScope      (JSPUtil.getParameter(request, prefix + "scope", ""));
		setCustNm     (JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setBlNo       (JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setEtd        (JSPUtil.getParameter(request, prefix + "etd", ""));
		setChgAmt     (JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setLbpCnt     (JSPUtil.getParameter(request, prefix + "lbp_cnt", ""));
		setBlObrdDt   (JSPUtil.getParameter(request, prefix + "bl_obrd_dt", ""));
		setUpdUsrId   (JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOblIssDt   (JSPUtil.getParameter(request, prefix + "obl_iss_dt", ""));
		
		 setScNo         (JSPUtil.getParameter(request, prefix + "sc_no"            , ""));
		 setFrtTermCd    (JSPUtil.getParameter(request, prefix + "frt_term_cd"      , ""));
		 setPpdRcvOfcCd  (JSPUtil.getParameter(request, prefix + "ppd_rcv_ofc_cd"   , ""));
		 setCltOfcCd     (JSPUtil.getParameter(request, prefix + "clt_ofc_cd"       , ""));
		 setN3ptyRcvOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_rcv_ofc_cd" , ""));
		 setPpd3rd(JSPUtil.getParameter(request, prefix + "ppd_3rd" , ""));
		 setCct3rd(JSPUtil.getParameter(request, prefix + "ppd_3rd" , ""));
		 setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no" , ""));
		 setFlag(JSPUtil.getParameter(request, prefix + "flag" , ""));
		
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SurchageSummaryInVO[]
	 */
	public SurchageSummaryInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SurchageSummaryInVO[]
	 */
	public SurchageSummaryInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SurchageSummaryInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ratingTtl = (JSPUtil.getParameter(request, prefix	+ "rating_ttl", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] pRhqCtrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_rhq_ctrt_ofc_cd", length));
			String[] pSelOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_sel_ofc_cd", length));
			String[] pSelOfcCd2 = (JSPUtil.getParameter(request, prefix	+ "p_sel_ofc_cd2", length));
			String[] pCtrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_ctrt_ofc_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] gsoBkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "gso_bkg_ofc_cd", length));
			String[] customerCode = (JSPUtil.getParameter(request, prefix	+ "customer_code", length));
			String[] contractNo = (JSPUtil.getParameter(request, prefix	+ "contract_no", length));
			String[] pGsoBkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_gso_bkg_ofc_cd", length));
			String[] pPolCd = (JSPUtil.getParameter(request, prefix	+ "p_pol_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] rhqCtrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ctrt_ofc_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] podCntCd = (JSPUtil.getParameter(request, prefix	+ "pod_cnt_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] polCntCd = (JSPUtil.getParameter(request, prefix	+ "pol_cnt_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] blRateCnt = (JSPUtil.getParameter(request, prefix	+ "bl_rate_cnt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] pRhqBkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_rhq_bkg_ofc_cd", length));
			String[] aplyDt = (JSPUtil.getParameter(request, prefix	+ "aply_dt", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] pSvcScpCd = (JSPUtil.getParameter(request, prefix	+ "p_svc_scp_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] paymentTermCd = (JSPUtil.getParameter(request, prefix	+ "payment_term_cd", length));
			String[] frDt = (JSPUtil.getParameter(request, prefix	+ "fr_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pDelCd = (JSPUtil.getParameter(request, prefix	+ "p_del_cd", length));
			String[] ctrRfaNo = (JSPUtil.getParameter(request, prefix	+ "ctr_rfa_no", length));
			String[] customerName = (JSPUtil.getParameter(request, prefix	+ "customer_name", length));
			String[] rhqBkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_bkg_ofc_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pPodCd = (JSPUtil.getParameter(request, prefix	+ "p_pod_cd", length));
			String[] chargeCd = (JSPUtil.getParameter(request, prefix	+ "charge_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] charge = (JSPUtil.getParameter(request, prefix	+ "charge", length));
			String[] termCd = (JSPUtil.getParameter(request, prefix	+ "term_cd", length));
			String[] tabCd = (JSPUtil.getParameter(request, prefix	+ "tab_cd", length));
			String[] pPorCd = (JSPUtil.getParameter(request, prefix	+ "p_por_cd", length));
			String[] applRatio = (JSPUtil.getParameter(request, prefix	+ "appl_ratio", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			String[] ctrRfaCd = (JSPUtil.getParameter(request, prefix	+ "ctr_rfa_cd", length));
			String[] surrenderOfcCd = (JSPUtil.getParameter(request, prefix	+ "surrender_ofc_cd", length));
			String[] surrenderDt = (JSPUtil.getParameter(request, prefix	+ "surrender_dt", length));
			String[] reissueOfcCd = (JSPUtil.getParameter(request, prefix	+ "reissue_ofc_cd", length));
			String[] reissueDt = (JSPUtil.getParameter(request, prefix	+ "reissue_dt", length));
			String[] corrOfcCd = (JSPUtil.getParameter(request, prefix	+ "corr_ofc_cd", length));
			String[] oblIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_ofc_cd", length));
			
			
			String[] ocLocalDate= (JSPUtil.getParameter(request, prefix + "oc_local_date", length));
			String[] scope      = (JSPUtil.getParameter(request, prefix + "scope"        , length));
			String[] custNm     = (JSPUtil.getParameter(request, prefix + "cust_nm"      , length));
			String[] blNo       = (JSPUtil.getParameter(request, prefix + "bl_no"        , length));
			String[] etd        = (JSPUtil.getParameter(request, prefix + "etd"          , length));
			String[] chgAmt     = (JSPUtil.getParameter(request, prefix + "chg_amt"      , length));
			String[] lbpCnt     = (JSPUtil.getParameter(request, prefix + "lbp_cnt"      , length));
			String[] blObrdDt   = (JSPUtil.getParameter(request, prefix + "bl_obrd_dt"   , length));
			String[] updUsrId   = (JSPUtil.getParameter(request, prefix + "upd_usr_id"   , length));
			String[] oblIssDt   = (JSPUtil.getParameter(request, prefix + "obl_iss_dt"   , length));
			
			
			String[] scNo          = (JSPUtil.getParameter(request, prefix + "sc_no"           , length));   
			String[] frtTermCd     = (JSPUtil.getParameter(request, prefix + "frt_term_cd"     , length)); 
			String[] ppdRcvOfcCd   = (JSPUtil.getParameter(request, prefix + "ppd_rcv_ofc_cd"  , length)); 
			String[] cltOfcCd      = (JSPUtil.getParameter(request, prefix + "clt_ofc_cd"      , length)); 
			String[] n3ptyRcvOfcCd = (JSPUtil.getParameter(request, prefix + "n3pty_rcv_ofc_cd", length)); 
			String[] ppd3rd = (JSPUtil.getParameter(request, prefix + "cct_3rd", length)); 
			String[] cct3rd = (JSPUtil.getParameter(request, prefix + "cct_3rd", length)); 
			String[] rfaNo         = (JSPUtil.getParameter(request, prefix + "rfa_no", length)); 
			String[] flag          = (JSPUtil.getParameter(request, prefix + "flag", length)); 
			
			
			for (int i = 0; i < length; i++) {
				model = new SurchageSummaryInVO();
				if (ratingTtl[i] != null)
					model.setRatingTtl(ratingTtl[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (pRhqCtrtOfcCd[i] != null)
					model.setPRhqCtrtOfcCd(pRhqCtrtOfcCd[i]);
				if (pSelOfcCd[i] != null)
					model.setPSelOfcCd(pSelOfcCd[i]);
				if (pSelOfcCd2[i] != null)
					model.setPSelOfcCd2(pSelOfcCd2[i]);
				if (pCtrtOfcCd[i] != null)
					model.setPCtrtOfcCd(pCtrtOfcCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (gsoBkgOfcCd[i] != null)
					model.setGsoBkgOfcCd(gsoBkgOfcCd[i]);
				if (customerCode[i] != null)
					model.setCustomerCode(customerCode[i]);
				if (contractNo[i] != null)
					model.setContractNo(contractNo[i]);
				if (pGsoBkgOfcCd[i] != null)
					model.setPGsoBkgOfcCd(pGsoBkgOfcCd[i]);
				if (pPolCd[i] != null)
					model.setPPolCd(pPolCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (rhqCtrtOfcCd[i] != null)
					model.setRhqCtrtOfcCd(rhqCtrtOfcCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (podCntCd[i] != null)
					model.setPodCntCd(podCntCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (polCntCd[i] != null)
					model.setPolCntCd(polCntCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (blRateCnt[i] != null)
					model.setBlRateCnt(blRateCnt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (pRhqBkgOfcCd[i] != null)
					model.setPRhqBkgOfcCd(pRhqBkgOfcCd[i]);
				if (aplyDt[i] != null)
					model.setAplyDt(aplyDt[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (pSvcScpCd[i] != null)
					model.setPSvcScpCd(pSvcScpCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (paymentTermCd[i] != null)
					model.setPaymentTermCd(paymentTermCd[i]);
				if (frDt[i] != null)
					model.setFrDt(frDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pDelCd[i] != null)
					model.setPDelCd(pDelCd[i]);
				if (ctrRfaNo[i] != null)
					model.setCtrRfaNo(ctrRfaNo[i]);
				if (customerName[i] != null)
					model.setCustomerName(customerName[i]);
				if (rhqBkgOfcCd[i] != null)
					model.setRhqBkgOfcCd(rhqBkgOfcCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pPodCd[i] != null)
					model.setPPodCd(pPodCd[i]);
				if (chargeCd[i] != null)
					model.setChargeCd(chargeCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (charge[i] != null)
					model.setCharge(charge[i]);
				if (termCd[i] != null)
					model.setTermCd(termCd[i]);
				if (tabCd[i] != null)
					model.setTabCd(tabCd[i]);
				if (pPorCd[i] != null)
					model.setPPorCd(pPorCd[i]);
				if (applRatio[i] != null)
					model.setApplRatio(applRatio[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				if (ctrRfaCd[i] != null)
					model.setCtrRfaCd(ctrRfaCd[i]);
				if (surrenderOfcCd[i] != null)
					model.setSurrenderOfcCd(surrenderOfcCd[i]);
				if (surrenderDt[i] != null)
					model.setSurrenderDt(surrenderDt[i]);
				if (reissueOfcCd[i] != null)
					model.setReissueOfcCd(reissueOfcCd[i]);
				if (reissueDt[i] != null)
					model.setReissueDt(reissueDt[i]);
				if (corrOfcCd[i] != null)
					model.setCorrOfcCd(corrOfcCd[i]);
				if (oblIssOfcCd[i] != null)
					model.setOblIssOfcCd(oblIssOfcCd[i]);
				
				
				if ( ocLocalDate[i] != null) model.setOcLocalDate(ocLocalDate[i]);
				if ( scope      [i] != null) model.setScope      (scope      [i]);
				if ( custNm     [i] != null) model.setCustNm     (custNm     [i]);
				if ( blNo       [i] != null) model.setBlNo       (blNo       [i]);
				if ( etd        [i] != null) model.setEtd        (etd        [i]);
				if ( chgAmt     [i] != null) model.setChgAmt     (chgAmt     [i]);
				if ( lbpCnt     [i] != null) model.setLbpCnt     (lbpCnt     [i]);
				if ( blObrdDt   [i] != null) model.setBlObrdDt   (blObrdDt   [i]);
				if ( updUsrId   [i] != null) model.setUpdUsrId   (updUsrId   [i]);
				if ( oblIssDt   [i] != null) model.setOblIssDt   (oblIssDt   [i]);
				
				if ( scNo         [i] != null) model.setScNo         (scNo         [i]);
				if ( frtTermCd    [i] != null) model.setFrtTermCd    (frtTermCd    [i]);
				if ( ppdRcvOfcCd  [i] != null) model.setPpdRcvOfcCd  (ppdRcvOfcCd  [i]);
				if ( cltOfcCd     [i] != null) model.setCltOfcCd     (cltOfcCd     [i]);
				if ( n3ptyRcvOfcCd[i] != null) model.setN3ptyRcvOfcCd(n3ptyRcvOfcCd[i]);
				if ( ppd3rd[i] != null) model.setPpd3rd(ppd3rd[i]);
				if ( cct3rd[i] != null) model.setPpd3rd(cct3rd[i]);
				if ( rfaNo[i] != null) model.setRfaNo(rfaNo[i]);
				if ( flag[i] != null) model.setFlag(flag[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSurchageSummaryInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SurchageSummaryInVO[]
	 */
	public SurchageSummaryInVO[] getSurchageSummaryInVOs(){
		SurchageSummaryInVO[] vos = (SurchageSummaryInVO[])models.toArray(new SurchageSummaryInVO[models.size()]);
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
		this.ratingTtl = this.ratingTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pRhqCtrtOfcCd = this.pRhqCtrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSelOfcCd = this.pSelOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSelOfcCd2 = this.pSelOfcCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCtrtOfcCd = this.pCtrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gsoBkgOfcCd = this.gsoBkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerCode = this.customerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractNo = this.contractNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pGsoBkgOfcCd = this.pGsoBkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPolCd = this.pPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCtrtOfcCd = this.rhqCtrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCntCd = this.podCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCntCd = this.polCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRateCnt = this.blRateCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pRhqBkgOfcCd = this.pRhqBkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyDt = this.aplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSvcScpCd = this.pSvcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paymentTermCd = this.paymentTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frDt = this.frDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDelCd = this.pDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrRfaNo = this.ctrRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerName = this.customerName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqBkgOfcCd = this.rhqBkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPodCd = this.pPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeCd = this.chargeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.charge = this.charge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termCd = this.termCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabCd = this.tabCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPorCd = this.pPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.applRatio = this.applRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrRfaCd = this.ctrRfaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surrenderOfcCd = this.surrenderOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surrenderDt = this.surrenderDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reissueOfcCd = this.reissueOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reissueDt = this.reissueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrOfcCd = this.corrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssOfcCd = this.oblIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		
		this.ocLocalDate =   this.ocLocalDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scope       =   this.scope      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm      =   this.custNm     .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo        =   this.blNo       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd         =   this.etd        .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt      =   this.chgAmt     .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbpCnt      =   this.lbpCnt     .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDt    =   this.blObrdDt   .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId    =   this.updUsrId   .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDt    =	 this.oblIssDt   .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		
		this.scNo          = this.scNo         .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd     = this.frtTermCd    .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdRcvOfcCd   = this.ppdRcvOfcCd  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd      = this.cltOfcCd     .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyRcvOfcCd = this.n3ptyRcvOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppd3rd = this.ppd3rd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct3rd = this.cct3rd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getOblIssOfcCd() {
		return oblIssOfcCd;
	}

	public void setOblIssOfcCd(String oblIssOfcCd) {
		this.oblIssOfcCd = oblIssOfcCd;
	}

	public String getOcLocalDate() {
		return ocLocalDate;
	}

	public void setOcLocalDate(String ocLocalDate) {
		this.ocLocalDate = ocLocalDate;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getCustNm() {
		return custNm;
	}

	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getEtd() {
		return etd;
	}

	public void setEtd(String etd) {
		this.etd = etd;
	}

	public String getChgAmt() {
		return chgAmt;
	}

	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}

	public String getLbpCnt() {
		return lbpCnt;
	}

	public void setLbpCnt(String lbpCnt) {
		this.lbpCnt = lbpCnt;
	}

	public String getBlObrdDt() {
		return blObrdDt;
	}

	public void setBlObrdDt(String blObrdDt) {
		this.blObrdDt = blObrdDt;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getOblIssDt() {
		return oblIssDt;
	}

	public void setOblIssDt(String oblIssDt) {
		this.oblIssDt = oblIssDt;
	}

	public String getfCmd() {
		return fCmd;
	}

	public void setfCmd(String fCmd) {
		this.fCmd = fCmd;
	}

	public String getScNo() {
		return scNo;
	}

	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	public String getFrtTermCd() {
		return frtTermCd;
	}

	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}

	public String getPpdRcvOfcCd() {
		return ppdRcvOfcCd;
	}

	public void setPpdRcvOfcCd(String ppdRcvOfcCd) {
		this.ppdRcvOfcCd = ppdRcvOfcCd;
	}

	public String getCltOfcCd() {
		return cltOfcCd;
	}

	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
	}

	public String getN3ptyRcvOfcCd() {
		return n3ptyRcvOfcCd;
	}

	public void setN3ptyRcvOfcCd(String n3ptyRcvOfcCd) {
		this.n3ptyRcvOfcCd = n3ptyRcvOfcCd;
	}

	public String getRfaNo() {
		return rfaNo;
	}

	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getPSelOfcCd2() {
		return pSelOfcCd2;
	}

	public void setPSelOfcCd2(String pSelOfcCd2) {
		this.pSelOfcCd2 = pSelOfcCd2;
	}

	public String getPpd3rd() {
		return ppd3rd;
	}

	public void setPpd3rd(String ppd3rd) {
		this.ppd3rd = ppd3rd;
	}

	public String getCct3rd() {
		return cct3rd;
	}

	public void setCct3rd(String cct3rd) {
		this.cct3rd = cct3rd;
	}
}
