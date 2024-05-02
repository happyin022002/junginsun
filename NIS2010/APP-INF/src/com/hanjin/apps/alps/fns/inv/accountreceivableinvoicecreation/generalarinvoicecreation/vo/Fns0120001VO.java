/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Fns0120001VO.java
*@FileTitle : Fns0120001VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.09.10 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo;

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
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Fns0120001VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Fns0120001VO> models = new ArrayList<Fns0120001VO>();
	
	/* Column Info */
	private String crInvNo = null;
	/* Column Info */
	private String logRgstDt = null;
	/* Column Info */  
	private String invCntryCd = null;
	/* Column Info */
	private String slipNo = null;
	/* Column Info */
	private String ratedAs = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String revDir = null;
	/* Column Info */
	private String revEffDt = null;
	/* Column Info */
	private String rowCount = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String zoneIoc = null;
	/* Column Info */
	private String oriChgAmt = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String revCoaCenter = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String curr = null;
	/* Column Info */
	private String revCoaCompany = null;
	/* Column Info */
	private String taxInd = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String perTyp = null;
	/* Column Info */
	private String chgFullNm = null;
	/* Column Info */
	private String salesOfc = null;
	/* Column Info */
	private String logUpdtDt = null;
	/* Column Info */
	private String revVsl = null;
	/* Column Info */
	private String actCustCd = null;
	/* Column Info */
	private String sailingDt = null;
	/* Column Info */
	private String cntrTpSz = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String invCoaAccount = null;
	/* Column Info */
	private String ctyCd = null;
	/* Column Info */
	private String invCoaFuture1 = null;
	/* Column Info */
	private String taxExRate = null;
	/* Column Info */
	private String invCoaFuture2 = null;
	/* Column Info */
	private String invCustCd = null;
	/* Column Info */
	private String revCoaAccount = null;
	/* Column Info */
	private String setoffNo = null;
	/* Column Info */
	private String chgCur = null;
	/* Column Info */
	private String oblMk = null;
	/* Column Info */
	private String acct = null;
	/* Column Info */
	private String whfDecNo = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String invCoaInterCompany = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String vsl = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String revCoaFuture2 = null;
	/* Column Info */
	private String revCoaFuture1 = null;
	/* Column Info */
	private String erpIfDt = null;
	/* Column Info */
	private String thirdExRateType = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String mainIfSer = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String chgTyp = null;
	/* Column Info */
	private String invCoaCenter = null;
	/* Column Info */
	private String scp = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String revCoaVvd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String revCoaRegion = null;
	/* Column Info */
	private String creditMk = null;
	/* Column Info */
	private String repChgTyp = null;
	/* Column Info */
	private String transTyp = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String invCoaVvd = null;
	/* Column Info */
	private String lclAmt = null;
	/* Column Info */
	private String lifid = null;
	/* Column Info */
	private String custRefNo = null;
	/* Column Info */
	private String bnd = null;
	/* Column Info */
	private String hjsRefNo = null;
	/* Column Info */
	private String dtlIfNo = null;
	/* Column Info */
	private String dtlIfSer = null;
	/* Column Info */
	private String ifFlag = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String revVoy = null;
	/* Column Info */
	private String onboardDt = null;
	/* Column Info */
	private String joInd = null;
	/* Column Info */
	private String actCntryCd = null;
	/* Column Info */
	private String invCoaRegion = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String revCoaInterCompany = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String saDt = null;
	/* Column Info */
	private String dir = null;
	/* Column Info */
	private String mainIfNo = null;
	/* Column Info */
	private String totalCount = null;
	/* Column Info */
	private String contNo = null;
	/* Column Info */
	private String slsmanCd = null;
	/* Column Info */
	private String exRateType = null;
	/* Column Info */
	private String sobId = null;
	/* Column Info */
	private String revLane = null;
	/* Column Info */
	private String invCoaCompany = null;
	/* Column Info */
	private String voy = null;
	/* Column Info */
	private String revTyp = null;
	/* Column Info */
	private String oriChgCur = null;
	/* Column Info */
	private String creditTerm = null;
	/* Column Info */
	private String caDt = null;
	/* Column Info */
	private String source = null;
	/* Column Info */
	private String caNo = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String exRateCustDate = null;
	/* Column Info */
	private String cttDecNo = null;
	/* Column Info */
	private String ofc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Fns0120001VO() {}

	public Fns0120001VO(String ibflag, String pagerows, String crInvNo, String lifid, String seq, String totalCount, String rowCount, String flag, String mainIfNo, String mainIfSer, String blNo, String blNoTp, String bkgNo, String source, String transTyp, String invNo, String caNo, String caDt, String rhq, String ofc, String actCntryCd, String actCustCd, String invCntryCd, String invCustCd, String vsl, String voy, String dir, String tVvd, String revVsl, String revVoy, String revDir, String saDt, String por, String pol, String pod, String del, String scp, String lane, String bnd, String creditMk, String slsmanCd, String dueDt, String usdAmt, String lclAmt, String whfDecNo, String cttDecNo, String zoneIoc, String ifFlag, String erpIfDt, String invCoaCompany, String invCoaRegion, String invCoaCenter, String invCoaAccount, String invCoaInterCompany, String invCoaVvd, String invCoaFuture1, String invCoaFuture2, String revLane, String contNo, String creditTerm, String sailingDt, String glDt, String exRateType, String exRateCustDate, String setoffNo, String custRefNo, String hjsRefNo, String taxExRate, String taxInd, String onboardDt, String oblMk, String ctyCd, String salesOfc, String rmk, String curr, String userId, String logRgstDt, String logUpdtDt, String issDt, String slipNo, String joInd, String dtlIfNo, String dtlIfSer, String chgSeq, String chgTyp, String repChgTyp, String chgCur, String revTyp, String chgAmt, String taxAmt, String revCoaCompany, String revCoaRegion, String revCoaCenter, String revCoaAccount, String revCoaInterCompany, String revCoaVvd, String revCoaFuture1, String revCoaFuture2, String oriChgCur, String oriChgAmt, String revEffDt, String perTyp, String rate, String ratedAs, String sobId, String chgFullNm, String acct, String cntrNo, String cntrTpSz, String rfaNo, String thirdExRateType) {
		this.crInvNo = crInvNo;
		this.logRgstDt = logRgstDt;
		this.invCntryCd = invCntryCd;
		this.slipNo = slipNo;
		this.ratedAs = ratedAs;
		this.por = por;
		this.revDir = revDir;
		this.revEffDt = revEffDt;
		this.rowCount = rowCount;
		this.pagerows = pagerows;
		this.zoneIoc = zoneIoc;
		this.oriChgAmt = oriChgAmt;
		this.tVvd = tVvd;
		this.revCoaCenter = revCoaCenter;
		this.pol = pol;
		this.chgAmt = chgAmt;
		this.curr = curr;
		this.revCoaCompany = revCoaCompany;
		this.taxInd = taxInd;
		this.pod = pod;
		this.rhq = rhq;
		this.perTyp = perTyp;
		this.chgFullNm = chgFullNm;
		this.salesOfc = salesOfc;
		this.logUpdtDt = logUpdtDt;
		this.revVsl = revVsl;
		this.actCustCd = actCustCd;
		this.sailingDt = sailingDt;
		this.cntrTpSz = cntrTpSz;
		this.bkgNo = bkgNo;
		this.invCoaAccount = invCoaAccount;
		this.ctyCd = ctyCd;
		this.invCoaFuture1 = invCoaFuture1;
		this.taxExRate = taxExRate;
		this.invCoaFuture2 = invCoaFuture2;
		this.invCustCd = invCustCd;
		this.revCoaAccount = revCoaAccount;
		this.setoffNo = setoffNo;
		this.chgCur = chgCur;
		this.oblMk = oblMk;
		this.acct = acct;
		this.whfDecNo = whfDecNo;
		this.issDt = issDt;
		this.invCoaInterCompany = invCoaInterCompany;
		this.taxAmt = taxAmt;
		this.vsl = vsl;
		this.del = del;
		this.dueDt = dueDt;
		this.rmk = rmk;
		this.revCoaFuture2 = revCoaFuture2;
		this.revCoaFuture1 = revCoaFuture1;
		this.erpIfDt = erpIfDt;
		this.thirdExRateType = thirdExRateType;
		this.invNo = invNo;
		this.usdAmt = usdAmt;
		this.mainIfSer = mainIfSer;
		this.cntrNo = cntrNo;
		this.chgTyp = chgTyp;
		this.invCoaCenter = invCoaCenter;
		this.scp = scp;
		this.glDt = glDt;
		this.revCoaVvd = revCoaVvd;
		this.blNo = blNo;
		this.revCoaRegion = revCoaRegion;
		this.creditMk = creditMk;
		this.repChgTyp = repChgTyp;
		this.transTyp = transTyp;
		this.userId = userId;
		this.blNoTp = blNoTp;
		this.invCoaVvd = invCoaVvd;
		this.lclAmt = lclAmt;
		this.lifid = lifid;
		this.custRefNo = custRefNo;
		this.bnd = bnd;
		this.hjsRefNo = hjsRefNo;
		this.dtlIfNo = dtlIfNo;
		this.dtlIfSer = dtlIfSer;
		this.ifFlag = ifFlag;
		this.flag = flag;
		this.revVoy = revVoy;
		this.onboardDt = onboardDt;
		this.joInd = joInd;
		this.actCntryCd = actCntryCd;
		this.invCoaRegion = invCoaRegion;
		this.chgSeq = chgSeq;
		this.revCoaInterCompany = revCoaInterCompany;
		this.lane = lane;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.rate = rate;
		this.saDt = saDt;
		this.dir = dir;
		this.mainIfNo = mainIfNo;
		this.totalCount = totalCount;
		this.contNo = contNo;
		this.slsmanCd = slsmanCd;
		this.exRateType = exRateType;
		this.sobId = sobId;
		this.revLane = revLane;
		this.invCoaCompany = invCoaCompany;
		this.voy = voy;
		this.revTyp = revTyp;
		this.oriChgCur = oriChgCur;
		this.creditTerm = creditTerm;
		this.caDt = caDt;
		this.source = source;
		this.caNo = caNo;
		this.seq = seq;
		this.exRateCustDate = exRateCustDate;
		this.cttDecNo = cttDecNo;
		this.ofc = ofc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cr_inv_no", getCrInvNo());
		this.hashColumns.put("log_rgst_dt", getLogRgstDt());
		this.hashColumns.put("inv_cntry_cd", getInvCntryCd());
		this.hashColumns.put("slip_no", getSlipNo());
		this.hashColumns.put("rated_as", getRatedAs());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("rev_dir", getRevDir());
		this.hashColumns.put("rev_eff_dt", getRevEffDt());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("zone_ioc", getZoneIoc());
		this.hashColumns.put("ori_chg_amt", getOriChgAmt());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("rev_coa_center", getRevCoaCenter());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("curr", getCurr());
		this.hashColumns.put("rev_coa_company", getRevCoaCompany());
		this.hashColumns.put("tax_ind", getTaxInd());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("per_typ", getPerTyp());
		this.hashColumns.put("chg_full_nm", getChgFullNm());
		this.hashColumns.put("sales_ofc", getSalesOfc());
		this.hashColumns.put("log_updt_dt", getLogUpdtDt());
		this.hashColumns.put("rev_vsl", getRevVsl());
		this.hashColumns.put("act_cust_cd", getActCustCd());
		this.hashColumns.put("sailing_dt", getSailingDt());
		this.hashColumns.put("cntr_tp_sz", getCntrTpSz());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("inv_coa_account", getInvCoaAccount());
		this.hashColumns.put("cty_cd", getCtyCd());
		this.hashColumns.put("inv_coa_future1", getInvCoaFuture1());
		this.hashColumns.put("tax_ex_rate", getTaxExRate());
		this.hashColumns.put("inv_coa_future2", getInvCoaFuture2());
		this.hashColumns.put("inv_cust_cd", getInvCustCd());
		this.hashColumns.put("rev_coa_account", getRevCoaAccount());
		this.hashColumns.put("setoff_no", getSetoffNo());
		this.hashColumns.put("chg_cur", getChgCur());
		this.hashColumns.put("obl_mk", getOblMk());
		this.hashColumns.put("acct", getAcct());
		this.hashColumns.put("whf_dec_no", getWhfDecNo());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("inv_coa_inter_company", getInvCoaInterCompany());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("vsl", getVsl());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("rev_coa_future2", getRevCoaFuture2());
		this.hashColumns.put("rev_coa_future1", getRevCoaFuture1());
		this.hashColumns.put("erp_if_dt", getErpIfDt());
		this.hashColumns.put("third_ex_rate_type", getThirdExRateType());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("main_if_ser", getMainIfSer());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("chg_typ", getChgTyp());
		this.hashColumns.put("inv_coa_center", getInvCoaCenter());
		this.hashColumns.put("scp", getScp());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("rev_coa_vvd", getRevCoaVvd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("rev_coa_region", getRevCoaRegion());
		this.hashColumns.put("credit_mk", getCreditMk());
		this.hashColumns.put("rep_chg_typ", getRepChgTyp());
		this.hashColumns.put("trans_typ", getTransTyp());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("inv_coa_vvd", getInvCoaVvd());
		this.hashColumns.put("lcl_amt", getLclAmt());
		this.hashColumns.put("lifid", getLifid());
		this.hashColumns.put("cust_ref_no", getCustRefNo());
		this.hashColumns.put("bnd", getBnd());
		this.hashColumns.put("hjs_ref_no", getHjsRefNo());
		this.hashColumns.put("dtl_if_no", getDtlIfNo());
		this.hashColumns.put("dtl_if_ser", getDtlIfSer());
		this.hashColumns.put("if_flag", getIfFlag());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("rev_voy", getRevVoy());
		this.hashColumns.put("onboard_dt", getOnboardDt());
		this.hashColumns.put("jo_ind", getJoInd());
		this.hashColumns.put("act_cntry_cd", getActCntryCd());
		this.hashColumns.put("inv_coa_region", getInvCoaRegion());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("rev_coa_inter_company", getRevCoaInterCompany());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("sa_dt", getSaDt());
		this.hashColumns.put("dir", getDir());
		this.hashColumns.put("main_if_no", getMainIfNo());
		this.hashColumns.put("total_count", getTotalCount());
		this.hashColumns.put("cont_no", getContNo());
		this.hashColumns.put("slsman_cd", getSlsmanCd());
		this.hashColumns.put("ex_rate_type", getExRateType());
		this.hashColumns.put("sob_id", getSobId());
		this.hashColumns.put("rev_lane", getRevLane());
		this.hashColumns.put("inv_coa_company", getInvCoaCompany());
		this.hashColumns.put("voy", getVoy());
		this.hashColumns.put("rev_typ", getRevTyp());
		this.hashColumns.put("ori_chg_cur", getOriChgCur());
		this.hashColumns.put("credit_term", getCreditTerm());
		this.hashColumns.put("ca_dt", getCaDt());
		this.hashColumns.put("source", getSource());
		this.hashColumns.put("ca_no", getCaNo());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("ex_rate_cust_date", getExRateCustDate());
		this.hashColumns.put("ctt_dec_no", getCttDecNo());
		this.hashColumns.put("ofc", getOfc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cr_inv_no", "crInvNo");
		this.hashFields.put("log_rgst_dt", "logRgstDt");
		this.hashFields.put("inv_cntry_cd", "invCntryCd");
		this.hashFields.put("slip_no", "slipNo");
		this.hashFields.put("rated_as", "ratedAs");
		this.hashFields.put("por", "por");
		this.hashFields.put("rev_dir", "revDir");
		this.hashFields.put("rev_eff_dt", "revEffDt");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("zone_ioc", "zoneIoc");
		this.hashFields.put("ori_chg_amt", "oriChgAmt");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("rev_coa_center", "revCoaCenter");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("curr", "curr");
		this.hashFields.put("rev_coa_company", "revCoaCompany");
		this.hashFields.put("tax_ind", "taxInd");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("per_typ", "perTyp");
		this.hashFields.put("chg_full_nm", "chgFullNm");
		this.hashFields.put("sales_ofc", "salesOfc");
		this.hashFields.put("log_updt_dt", "logUpdtDt");
		this.hashFields.put("rev_vsl", "revVsl");
		this.hashFields.put("act_cust_cd", "actCustCd");
		this.hashFields.put("sailing_dt", "sailingDt");
		this.hashFields.put("cntr_tp_sz", "cntrTpSz");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("inv_coa_account", "invCoaAccount");
		this.hashFields.put("cty_cd", "ctyCd");
		this.hashFields.put("inv_coa_future1", "invCoaFuture1");
		this.hashFields.put("tax_ex_rate", "taxExRate");
		this.hashFields.put("inv_coa_future2", "invCoaFuture2");
		this.hashFields.put("inv_cust_cd", "invCustCd");
		this.hashFields.put("rev_coa_account", "revCoaAccount");
		this.hashFields.put("setoff_no", "setoffNo");
		this.hashFields.put("chg_cur", "chgCur");
		this.hashFields.put("obl_mk", "oblMk");
		this.hashFields.put("acct", "acct");
		this.hashFields.put("whf_dec_no", "whfDecNo");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("inv_coa_inter_company", "invCoaInterCompany");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("vsl", "vsl");
		this.hashFields.put("del", "del");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("rev_coa_future2", "revCoaFuture2");
		this.hashFields.put("rev_coa_future1", "revCoaFuture1");
		this.hashFields.put("erp_if_dt", "erpIfDt");
		this.hashFields.put("third_ex_rate_type", "thirdExRateType");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("main_if_ser", "mainIfSer");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("chg_typ", "chgTyp");
		this.hashFields.put("inv_coa_center", "invCoaCenter");
		this.hashFields.put("scp", "scp");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("rev_coa_vvd", "revCoaVvd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("rev_coa_region", "revCoaRegion");
		this.hashFields.put("credit_mk", "creditMk");
		this.hashFields.put("rep_chg_typ", "repChgTyp");
		this.hashFields.put("trans_typ", "transTyp");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("inv_coa_vvd", "invCoaVvd");
		this.hashFields.put("lcl_amt", "lclAmt");
		this.hashFields.put("lifid", "lifid");
		this.hashFields.put("cust_ref_no", "custRefNo");
		this.hashFields.put("bnd", "bnd");
		this.hashFields.put("hjs_ref_no", "hjsRefNo");
		this.hashFields.put("dtl_if_no", "dtlIfNo");
		this.hashFields.put("dtl_if_ser", "dtlIfSer");
		this.hashFields.put("if_flag", "ifFlag");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("rev_voy", "revVoy");
		this.hashFields.put("onboard_dt", "onboardDt");
		this.hashFields.put("jo_ind", "joInd");
		this.hashFields.put("act_cntry_cd", "actCntryCd");
		this.hashFields.put("inv_coa_region", "invCoaRegion");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("rev_coa_inter_company", "revCoaInterCompany");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("sa_dt", "saDt");
		this.hashFields.put("dir", "dir");
		this.hashFields.put("main_if_no", "mainIfNo");
		this.hashFields.put("total_count", "totalCount");
		this.hashFields.put("cont_no", "contNo");
		this.hashFields.put("slsman_cd", "slsmanCd");
		this.hashFields.put("ex_rate_type", "exRateType");
		this.hashFields.put("sob_id", "sobId");
		this.hashFields.put("rev_lane", "revLane");
		this.hashFields.put("inv_coa_company", "invCoaCompany");
		this.hashFields.put("voy", "voy");
		this.hashFields.put("rev_typ", "revTyp");
		this.hashFields.put("ori_chg_cur", "oriChgCur");
		this.hashFields.put("credit_term", "creditTerm");
		this.hashFields.put("ca_dt", "caDt");
		this.hashFields.put("source", "source");
		this.hashFields.put("ca_no", "caNo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("ex_rate_cust_date", "exRateCustDate");
		this.hashFields.put("ctt_dec_no", "cttDecNo");
		this.hashFields.put("ofc", "ofc");
		return this.hashFields;
	}
	
	/**
	 * @return the crInvNo
	 */
	public String getCrInvNo() {
		return crInvNo;
	}
	
	/**
	 * Column Info
	 * @return logRgstDt
	 */
	public String getLogRgstDt() {
		return this.logRgstDt;
	}
	
	/**
	 * Column Info
	 * @return invCntryCd
	 */
	public String getInvCntryCd() {
		return this.invCntryCd;
	}
	
	/**
	 * Column Info
	 * @return slipNo
	 */
	public String getSlipNo() {
		return this.slipNo;
	}
	
	/**
	 * Column Info
	 * @return ratedAs
	 */
	public String getRatedAs() {
		return this.ratedAs;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return revDir
	 */
	public String getRevDir() {
		return this.revDir;
	}
	
	/**
	 * Column Info
	 * @return revEffDt
	 */
	public String getRevEffDt() {
		return this.revEffDt;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
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
	 * @return zoneIoc
	 */
	public String getZoneIoc() {
		return this.zoneIoc;
	}
	
	/**
	 * Column Info
	 * @return oriChgAmt
	 */
	public String getOriChgAmt() {
		return this.oriChgAmt;
	}
	
	/**
	 * Column Info
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}
	
	/**
	 * Column Info
	 * @return revCoaCenter
	 */
	public String getRevCoaCenter() {
		return this.revCoaCenter;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
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
	 * @return curr
	 */
	public String getCurr() {
		return this.curr;
	}
	
	/**
	 * Column Info
	 * @return revCoaCompany
	 */
	public String getRevCoaCompany() {
		return this.revCoaCompany;
	}
	
	/**
	 * Column Info
	 * @return taxInd
	 */
	public String getTaxInd() {
		return this.taxInd;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return perTyp
	 */
	public String getPerTyp() {
		return this.perTyp;
	}
	
	/**
	 * Column Info
	 * @return chgFullNm
	 */
	public String getChgFullNm() {
		return this.chgFullNm;
	}
	
	/**
	 * Column Info
	 * @return salesOfc
	 */
	public String getSalesOfc() {
		return this.salesOfc;
	}
	
	/**
	 * Column Info
	 * @return logUpdtDt
	 */
	public String getLogUpdtDt() {
		return this.logUpdtDt;
	}
	
	/**
	 * Column Info
	 * @return revVsl
	 */
	public String getRevVsl() {
		return this.revVsl;
	}
	
	/**
	 * Column Info
	 * @return actCustCd
	 */
	public String getActCustCd() {
		return this.actCustCd;
	}
	
	/**
	 * Column Info
	 * @return sailingDt
	 */
	public String getSailingDt() {
		return this.sailingDt;
	}
	
	/**
	 * Column Info
	 * @return cntrTpSz
	 */
	public String getCntrTpSz() {
		return this.cntrTpSz;
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
	 * @return invCoaAccount
	 */
	public String getInvCoaAccount() {
		return this.invCoaAccount;
	}
	
	/**
	 * Column Info
	 * @return ctyCd
	 */
	public String getCtyCd() {
		return this.ctyCd;
	}
	
	/**
	 * Column Info
	 * @return invCoaFuture1
	 */
	public String getInvCoaFuture1() {
		return this.invCoaFuture1;
	}
	
	/**
	 * Column Info
	 * @return taxExRate
	 */
	public String getTaxExRate() {
		return this.taxExRate;
	}
	
	/**
	 * Column Info
	 * @return invCoaFuture2
	 */
	public String getInvCoaFuture2() {
		return this.invCoaFuture2;
	}
	
	/**
	 * Column Info
	 * @return invCustCd
	 */
	public String getInvCustCd() {
		return this.invCustCd;
	}
	
	/**
	 * Column Info
	 * @return revCoaAccount
	 */
	public String getRevCoaAccount() {
		return this.revCoaAccount;
	}
	
	/**
	 * Column Info
	 * @return setoffNo
	 */
	public String getSetoffNo() {
		return this.setoffNo;
	}
	
	/**
	 * Column Info
	 * @return chgCur
	 */
	public String getChgCur() {
		return this.chgCur;
	}
	
	/**
	 * Column Info
	 * @return oblMk
	 */
	public String getOblMk() {
		return this.oblMk;
	}
	
	/**
	 * Column Info
	 * @return acct
	 */
	public String getAcct() {
		return this.acct;
	}
	
	/**
	 * Column Info
	 * @return whfDecNo
	 */
	public String getWhfDecNo() {
		return this.whfDecNo;
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
	 * @return invCoaInterCompany
	 */
	public String getInvCoaInterCompany() {
		return this.invCoaInterCompany;
	}
	
	/**
	 * Column Info
	 * @return taxAmt
	 */
	public String getTaxAmt() {
		return this.taxAmt;
	}
	
	/**
	 * Column Info
	 * @return vsl
	 */
	public String getVsl() {
		return this.vsl;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
	}
	
	/**
	 * Column Info
	 * @return revCoaFuture2
	 */
	public String getRevCoaFuture2() {
		return this.revCoaFuture2;
	}
	
	/**
	 * Column Info
	 * @return revCoaFuture1
	 */
	public String getRevCoaFuture1() {
		return this.revCoaFuture1;
	}
	
	/**
	 * Column Info
	 * @return erpIfDt
	 */
	public String getErpIfDt() {
		return this.erpIfDt;
	}
	
	/**
	 * Column Info
	 * @return thirdExRateType
	 */
	public String getThirdExRateType() {
		return this.thirdExRateType;
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
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
	}
	
	/**
	 * Column Info
	 * @return mainIfSer
	 */
	public String getMainIfSer() {
		return this.mainIfSer;
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
	 * @return chgTyp
	 */
	public String getChgTyp() {
		return this.chgTyp;
	}
	
	/**
	 * Column Info
	 * @return invCoaCenter
	 */
	public String getInvCoaCenter() {
		return this.invCoaCenter;
	}
	
	/**
	 * Column Info
	 * @return scp
	 */
	public String getScp() {
		return this.scp;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
	}
	
	/**
	 * Column Info
	 * @return revCoaVvd
	 */
	public String getRevCoaVvd() {
		return this.revCoaVvd;
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
	 * @return revCoaRegion
	 */
	public String getRevCoaRegion() {
		return this.revCoaRegion;
	}
	
	/**
	 * Column Info
	 * @return creditMk
	 */
	public String getCreditMk() {
		return this.creditMk;
	}
	
	/**
	 * Column Info
	 * @return repChgTyp
	 */
	public String getRepChgTyp() {
		return this.repChgTyp;
	}
	
	/**
	 * Column Info
	 * @return transTyp
	 */
	public String getTransTyp() {
		return this.transTyp;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return blNoTp
	 */
	public String getBlNoTp() {
		return this.blNoTp;
	}
	
	/**
	 * Column Info
	 * @return invCoaVvd
	 */
	public String getInvCoaVvd() {
		return this.invCoaVvd;
	}
	
	/**
	 * Column Info
	 * @return lclAmt
	 */
	public String getLclAmt() {
		return this.lclAmt;
	}
	
	/**
	 * Column Info
	 * @return lifid
	 */
	public String getLifid() {
		return this.lifid;
	}
	
	/**
	 * Column Info
	 * @return custRefNo
	 */
	public String getCustRefNo() {
		return this.custRefNo;
	}
	
	/**
	 * Column Info
	 * @return bnd
	 */
	public String getBnd() {
		return this.bnd;
	}
	
	/**
	 * Column Info
	 * @return hjsRefNo
	 */
	public String getHjsRefNo() {
		return this.hjsRefNo;
	}
	
	/**
	 * Column Info
	 * @return dtlIfNo
	 */
	public String getDtlIfNo() {
		return this.dtlIfNo;
	}
	
	/**
	 * Column Info
	 * @return dtlIfSer
	 */
	public String getDtlIfSer() {
		return this.dtlIfSer;
	}
	
	/**
	 * Column Info
	 * @return ifFlag
	 */
	public String getIfFlag() {
		return this.ifFlag;
	}
	
	/**
	 * Column Info
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
	}
	
	/**
	 * Column Info
	 * @return revVoy
	 */
	public String getRevVoy() {
		return this.revVoy;
	}
	
	/**
	 * Column Info
	 * @return onboardDt
	 */
	public String getOnboardDt() {
		return this.onboardDt;
	}
	
	/**
	 * Column Info
	 * @return joInd
	 */
	public String getJoInd() {
		return this.joInd;
	}
	
	/**
	 * Column Info
	 * @return actCntryCd
	 */
	public String getActCntryCd() {
		return this.actCntryCd;
	}
	
	/**
	 * Column Info
	 * @return invCoaRegion
	 */
	public String getInvCoaRegion() {
		return this.invCoaRegion;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return revCoaInterCompany
	 */
	public String getRevCoaInterCompany() {
		return this.revCoaInterCompany;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Column Info
	 * @return saDt
	 */
	public String getSaDt() {
		return this.saDt;
	}
	
	/**
	 * Column Info
	 * @return dir
	 */
	public String getDir() {
		return this.dir;
	}
	
	/**
	 * Column Info
	 * @return mainIfNo
	 */
	public String getMainIfNo() {
		return this.mainIfNo;
	}
	
	/**
	 * Column Info
	 * @return totalCount
	 */
	public String getTotalCount() {
		return this.totalCount;
	}
	
	/**
	 * Column Info
	 * @return contNo
	 */
	public String getContNo() {
		return this.contNo;
	}
	
	/**
	 * Column Info
	 * @return slsmanCd
	 */
	public String getSlsmanCd() {
		return this.slsmanCd;
	}
	
	/**
	 * Column Info
	 * @return exRateType
	 */
	public String getExRateType() {
		return this.exRateType;
	}
	
	/**
	 * Column Info
	 * @return sobId
	 */
	public String getSobId() {
		return this.sobId;
	}
	
	/**
	 * Column Info
	 * @return revLane
	 */
	public String getRevLane() {
		return this.revLane;
	}
	
	/**
	 * Column Info
	 * @return invCoaCompany
	 */
	public String getInvCoaCompany() {
		return this.invCoaCompany;
	}
	
	/**
	 * Column Info
	 * @return voy
	 */
	public String getVoy() {
		return this.voy;
	}
	
	/**
	 * Column Info
	 * @return revTyp
	 */
	public String getRevTyp() {
		return this.revTyp;
	}
	
	/**
	 * Column Info
	 * @return oriChgCur
	 */
	public String getOriChgCur() {
		return this.oriChgCur;
	}
	
	/**
	 * Column Info
	 * @return creditTerm
	 */
	public String getCreditTerm() {
		return this.creditTerm;
	}
	
	/**
	 * Column Info
	 * @return caDt
	 */
	public String getCaDt() {
		return this.caDt;
	}
	
	/**
	 * Column Info
	 * @return source
	 */
	public String getSource() {
		return this.source;
	}
	
	/**
	 * Column Info
	 * @return caNo
	 */
	public String getCaNo() {
		return this.caNo;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return exRateCustDate
	 */
	public String getExRateCustDate() {
		return this.exRateCustDate;
	}
	
	/**
	 * Column Info
	 * @return cttDecNo
	 */
	public String getCttDecNo() {
		return this.cttDecNo;
	}
	
	/**
	 * Column Info
	 * @return ofc
	 */
	public String getOfc() {
		return this.ofc;
	}
	

	/**
	 * Column Info
	 * @param crInvNo
	 */
	public void setCrInvNo(String crInvNo) {
		this.crInvNo = crInvNo;
	}
	
	/**
	 * Column Info
	 * @param logRgstDt
	 */
	public void setLogRgstDt(String logRgstDt) {
		this.logRgstDt = logRgstDt;
	}
	
	/**
	 * Column Info
	 * @param invCntryCd
	 */
	public void setInvCntryCd(String invCntryCd) {
		this.invCntryCd = invCntryCd;
	}
	
	/**
	 * Column Info
	 * @param slipNo
	 */
	public void setSlipNo(String slipNo) {
		this.slipNo = slipNo;
	}
	
	/**
	 * Column Info
	 * @param ratedAs
	 */
	public void setRatedAs(String ratedAs) {
		this.ratedAs = ratedAs;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param revDir
	 */
	public void setRevDir(String revDir) {
		this.revDir = revDir;
	}
	
	/**
	 * Column Info
	 * @param revEffDt
	 */
	public void setRevEffDt(String revEffDt) {
		this.revEffDt = revEffDt;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
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
	 * @param zoneIoc
	 */
	public void setZoneIoc(String zoneIoc) {
		this.zoneIoc = zoneIoc;
	}
	
	/**
	 * Column Info
	 * @param oriChgAmt
	 */
	public void setOriChgAmt(String oriChgAmt) {
		this.oriChgAmt = oriChgAmt;
	}
	
	/**
	 * Column Info
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}
	
	/**
	 * Column Info
	 * @param revCoaCenter
	 */
	public void setRevCoaCenter(String revCoaCenter) {
		this.revCoaCenter = revCoaCenter;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
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
	 * @param curr
	 */
	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	/**
	 * Column Info
	 * @param revCoaCompany
	 */
	public void setRevCoaCompany(String revCoaCompany) {
		this.revCoaCompany = revCoaCompany;
	}
	
	/**
	 * Column Info
	 * @param taxInd
	 */
	public void setTaxInd(String taxInd) {
		this.taxInd = taxInd;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param perTyp
	 */
	public void setPerTyp(String perTyp) {
		this.perTyp = perTyp;
	}
	
	/**
	 * Column Info
	 * @param chgFullNm
	 */
	public void setChgFullNm(String chgFullNm) {
		this.chgFullNm = chgFullNm;
	}
	
	/**
	 * Column Info
	 * @param salesOfc
	 */
	public void setSalesOfc(String salesOfc) {
		this.salesOfc = salesOfc;
	}
	
	/**
	 * Column Info
	 * @param logUpdtDt
	 */
	public void setLogUpdtDt(String logUpdtDt) {
		this.logUpdtDt = logUpdtDt;
	}
	
	/**
	 * Column Info
	 * @param revVsl
	 */
	public void setRevVsl(String revVsl) {
		this.revVsl = revVsl;
	}
	
	/**
	 * Column Info
	 * @param actCustCd
	 */
	public void setActCustCd(String actCustCd) {
		this.actCustCd = actCustCd;
	}
	
	/**
	 * Column Info
	 * @param sailingDt
	 */
	public void setSailingDt(String sailingDt) {
		this.sailingDt = sailingDt;
	}
	
	/**
	 * Column Info
	 * @param cntrTpSz
	 */
	public void setCntrTpSz(String cntrTpSz) {
		this.cntrTpSz = cntrTpSz;
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
	 * @param invCoaAccount
	 */
	public void setInvCoaAccount(String invCoaAccount) {
		this.invCoaAccount = invCoaAccount;
	}
	
	/**
	 * Column Info
	 * @param ctyCd
	 */
	public void setCtyCd(String ctyCd) {
		this.ctyCd = ctyCd;
	}
	
	/**
	 * Column Info
	 * @param invCoaFuture1
	 */
	public void setInvCoaFuture1(String invCoaFuture1) {
		this.invCoaFuture1 = invCoaFuture1;
	}
	
	/**
	 * Column Info
	 * @param taxExRate
	 */
	public void setTaxExRate(String taxExRate) {
		this.taxExRate = taxExRate;
	}
	
	/**
	 * Column Info
	 * @param invCoaFuture2
	 */
	public void setInvCoaFuture2(String invCoaFuture2) {
		this.invCoaFuture2 = invCoaFuture2;
	}
	
	/**
	 * Column Info
	 * @param invCustCd
	 */
	public void setInvCustCd(String invCustCd) {
		this.invCustCd = invCustCd;
	}
	
	/**
	 * Column Info
	 * @param revCoaAccount
	 */
	public void setRevCoaAccount(String revCoaAccount) {
		this.revCoaAccount = revCoaAccount;
	}
	
	/**
	 * Column Info
	 * @param setoffNo
	 */
	public void setSetoffNo(String setoffNo) {
		this.setoffNo = setoffNo;
	}
	
	/**
	 * Column Info
	 * @param chgCur
	 */
	public void setChgCur(String chgCur) {
		this.chgCur = chgCur;
	}
	
	/**
	 * Column Info
	 * @param oblMk
	 */
	public void setOblMk(String oblMk) {
		this.oblMk = oblMk;
	}
	
	/**
	 * Column Info
	 * @param acct
	 */
	public void setAcct(String acct) {
		this.acct = acct;
	}
	
	/**
	 * Column Info
	 * @param whfDecNo
	 */
	public void setWhfDecNo(String whfDecNo) {
		this.whfDecNo = whfDecNo;
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
	 * @param invCoaInterCompany
	 */
	public void setInvCoaInterCompany(String invCoaInterCompany) {
		this.invCoaInterCompany = invCoaInterCompany;
	}
	
	/**
	 * Column Info
	 * @param taxAmt
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}
	
	/**
	 * Column Info
	 * @param vsl
	 */
	public void setVsl(String vsl) {
		this.vsl = vsl;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	/**
	 * Column Info
	 * @param revCoaFuture2
	 */
	public void setRevCoaFuture2(String revCoaFuture2) {
		this.revCoaFuture2 = revCoaFuture2;
	}
	
	/**
	 * Column Info
	 * @param revCoaFuture1
	 */
	public void setRevCoaFuture1(String revCoaFuture1) {
		this.revCoaFuture1 = revCoaFuture1;
	}
	
	/**
	 * Column Info
	 * @param erpIfDt
	 */
	public void setErpIfDt(String erpIfDt) {
		this.erpIfDt = erpIfDt;
	}
	
	/**
	 * Column Info
	 * @param thirdExRateType
	 */
	public void setThirdExRateType(String thirdExRateType) {
		this.thirdExRateType = thirdExRateType;
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
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
	}
	
	/**
	 * Column Info
	 * @param mainIfSer
	 */
	public void setMainIfSer(String mainIfSer) {
		this.mainIfSer = mainIfSer;
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
	 * @param chgTyp
	 */
	public void setChgTyp(String chgTyp) {
		this.chgTyp = chgTyp;
	}
	
	/**
	 * Column Info
	 * @param invCoaCenter
	 */
	public void setInvCoaCenter(String invCoaCenter) {
		this.invCoaCenter = invCoaCenter;
	}
	
	/**
	 * Column Info
	 * @param scp
	 */
	public void setScp(String scp) {
		this.scp = scp;
	}
	
	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
	}
	
	/**
	 * Column Info
	 * @param revCoaVvd
	 */
	public void setRevCoaVvd(String revCoaVvd) {
		this.revCoaVvd = revCoaVvd;
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
	 * @param revCoaRegion
	 */
	public void setRevCoaRegion(String revCoaRegion) {
		this.revCoaRegion = revCoaRegion;
	}
	
	/**
	 * Column Info
	 * @param creditMk
	 */
	public void setCreditMk(String creditMk) {
		this.creditMk = creditMk;
	}
	
	/**
	 * Column Info
	 * @param repChgTyp
	 */
	public void setRepChgTyp(String repChgTyp) {
		this.repChgTyp = repChgTyp;
	}
	
	/**
	 * Column Info
	 * @param transTyp
	 */
	public void setTransTyp(String transTyp) {
		this.transTyp = transTyp;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param blNoTp
	 */
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
	}
	
	/**
	 * Column Info
	 * @param invCoaVvd
	 */
	public void setInvCoaVvd(String invCoaVvd) {
		this.invCoaVvd = invCoaVvd;
	}
	
	/**
	 * Column Info
	 * @param lclAmt
	 */
	public void setLclAmt(String lclAmt) {
		this.lclAmt = lclAmt;
	}
	
	/**
	 * Column Info
	 * @param lifid
	 */
	public void setLifid(String lifid) {
		this.lifid = lifid;
	}
	
	/**
	 * Column Info
	 * @param custRefNo
	 */
	public void setCustRefNo(String custRefNo) {
		this.custRefNo = custRefNo;
	}
	
	/**
	 * Column Info
	 * @param bnd
	 */
	public void setBnd(String bnd) {
		this.bnd = bnd;
	}
	
	/**
	 * Column Info
	 * @param hjsRefNo
	 */
	public void setHjsRefNo(String hjsRefNo) {
		this.hjsRefNo = hjsRefNo;
	}
	
	/**
	 * Column Info
	 * @param dtlIfNo
	 */
	public void setDtlIfNo(String dtlIfNo) {
		this.dtlIfNo = dtlIfNo;
	}
	
	/**
	 * Column Info
	 * @param dtlIfSer
	 */
	public void setDtlIfSer(String dtlIfSer) {
		this.dtlIfSer = dtlIfSer;
	}
	
	/**
	 * Column Info
	 * @param ifFlag
	 */
	public void setIfFlag(String ifFlag) {
		this.ifFlag = ifFlag;
	}
	
	/**
	 * Column Info
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * Column Info
	 * @param revVoy
	 */
	public void setRevVoy(String revVoy) {
		this.revVoy = revVoy;
	}
	
	/**
	 * Column Info
	 * @param onboardDt
	 */
	public void setOnboardDt(String onboardDt) {
		this.onboardDt = onboardDt;
	}
	
	/**
	 * Column Info
	 * @param joInd
	 */
	public void setJoInd(String joInd) {
		this.joInd = joInd;
	}
	
	/**
	 * Column Info
	 * @param actCntryCd
	 */
	public void setActCntryCd(String actCntryCd) {
		this.actCntryCd = actCntryCd;
	}
	
	/**
	 * Column Info
	 * @param invCoaRegion
	 */
	public void setInvCoaRegion(String invCoaRegion) {
		this.invCoaRegion = invCoaRegion;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param revCoaInterCompany
	 */
	public void setRevCoaInterCompany(String revCoaInterCompany) {
		this.revCoaInterCompany = revCoaInterCompany;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * Column Info
	 * @param saDt
	 */
	public void setSaDt(String saDt) {
		this.saDt = saDt;
	}
	
	/**
	 * Column Info
	 * @param dir
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}
	
	/**
	 * Column Info
	 * @param mainIfNo
	 */
	public void setMainIfNo(String mainIfNo) {
		this.mainIfNo = mainIfNo;
	}
	
	/**
	 * Column Info
	 * @param totalCount
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * Column Info
	 * @param contNo
	 */
	public void setContNo(String contNo) {
		this.contNo = contNo;
	}
	
	/**
	 * Column Info
	 * @param slsmanCd
	 */
	public void setSlsmanCd(String slsmanCd) {
		this.slsmanCd = slsmanCd;
	}
	
	/**
	 * Column Info
	 * @param exRateType
	 */
	public void setExRateType(String exRateType) {
		this.exRateType = exRateType;
	}
	
	/**
	 * Column Info
	 * @param sobId
	 */
	public void setSobId(String sobId) {
		this.sobId = sobId;
	}
	
	/**
	 * Column Info
	 * @param revLane
	 */
	public void setRevLane(String revLane) {
		this.revLane = revLane;
	}
	
	/**
	 * Column Info
	 * @param invCoaCompany
	 */
	public void setInvCoaCompany(String invCoaCompany) {
		this.invCoaCompany = invCoaCompany;
	}
	
	/**
	 * Column Info
	 * @param voy
	 */
	public void setVoy(String voy) {
		this.voy = voy;
	}
	
	/**
	 * Column Info
	 * @param revTyp
	 */
	public void setRevTyp(String revTyp) {
		this.revTyp = revTyp;
	}
	
	/**
	 * Column Info
	 * @param oriChgCur
	 */
	public void setOriChgCur(String oriChgCur) {
		this.oriChgCur = oriChgCur;
	}
	
	/**
	 * Column Info
	 * @param creditTerm
	 */
	public void setCreditTerm(String creditTerm) {
		this.creditTerm = creditTerm;
	}
	
	/**
	 * Column Info
	 * @param caDt
	 */
	public void setCaDt(String caDt) {
		this.caDt = caDt;
	}
	
	/**
	 * Column Info
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Column Info
	 * @param caNo
	 */
	public void setCaNo(String caNo) {
		this.caNo = caNo;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param exRateCustDate
	 */
	public void setExRateCustDate(String exRateCustDate) {
		this.exRateCustDate = exRateCustDate;
	}
	
	/**
	 * Column Info
	 * @param cttDecNo
	 */
	public void setCttDecNo(String cttDecNo) {
		this.cttDecNo = cttDecNo;
	}
	
	/**
	 * Column Info
	 * @param ofc
	 */
	public void setOfc(String ofc) {
		this.ofc = ofc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCrInvNo(JSPUtil.getParameter(request, "cr_inv_no", ""));
		setLogRgstDt(JSPUtil.getParameter(request, "log_rgst_dt", ""));
		setInvCntryCd(JSPUtil.getParameter(request, "inv_cntry_cd", ""));
		setSlipNo(JSPUtil.getParameter(request, "slip_no", ""));
		setRatedAs(JSPUtil.getParameter(request, "rated_as", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setRevDir(JSPUtil.getParameter(request, "rev_dir", ""));
		setRevEffDt(JSPUtil.getParameter(request, "rev_eff_dt", ""));
		setRowCount(JSPUtil.getParameter(request, "row_count", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setZoneIoc(JSPUtil.getParameter(request, "zone_ioc", ""));
		setOriChgAmt(JSPUtil.getParameter(request, "ori_chg_amt", ""));
		setTVvd(JSPUtil.getParameter(request, "t_vvd", ""));
		setRevCoaCenter(JSPUtil.getParameter(request, "rev_coa_center", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setCurr(JSPUtil.getParameter(request, "curr", ""));
		setRevCoaCompany(JSPUtil.getParameter(request, "rev_coa_company", ""));
		setTaxInd(JSPUtil.getParameter(request, "tax_ind", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
		setPerTyp(JSPUtil.getParameter(request, "per_typ", ""));
		setChgFullNm(JSPUtil.getParameter(request, "chg_full_nm", ""));
		setSalesOfc(JSPUtil.getParameter(request, "sales_ofc", ""));
		setLogUpdtDt(JSPUtil.getParameter(request, "log_updt_dt", ""));
		setRevVsl(JSPUtil.getParameter(request, "rev_vsl", ""));
		setActCustCd(JSPUtil.getParameter(request, "act_cust_cd", ""));
		setSailingDt(JSPUtil.getParameter(request, "sailing_dt", ""));
		setCntrTpSz(JSPUtil.getParameter(request, "cntr_tp_sz", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setInvCoaAccount(JSPUtil.getParameter(request, "inv_coa_account", ""));
		setCtyCd(JSPUtil.getParameter(request, "cty_cd", ""));
		setInvCoaFuture1(JSPUtil.getParameter(request, "inv_coa_future1", ""));
		setTaxExRate(JSPUtil.getParameter(request, "tax_ex_rate", ""));
		setInvCoaFuture2(JSPUtil.getParameter(request, "inv_coa_future2", ""));
		setInvCustCd(JSPUtil.getParameter(request, "inv_cust_cd", ""));
		setRevCoaAccount(JSPUtil.getParameter(request, "rev_coa_account", ""));
		setSetoffNo(JSPUtil.getParameter(request, "setoff_no", ""));
		setChgCur(JSPUtil.getParameter(request, "chg_cur", ""));
		setOblMk(JSPUtil.getParameter(request, "obl_mk", ""));
		setAcct(JSPUtil.getParameter(request, "acct", ""));
		setWhfDecNo(JSPUtil.getParameter(request, "whf_dec_no", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setInvCoaInterCompany(JSPUtil.getParameter(request, "inv_coa_inter_company", ""));
		setTaxAmt(JSPUtil.getParameter(request, "tax_amt", ""));
		setVsl(JSPUtil.getParameter(request, "vsl", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setRmk(JSPUtil.getParameter(request, "rmk", ""));
		setRevCoaFuture2(JSPUtil.getParameter(request, "rev_coa_future2", ""));
		setRevCoaFuture1(JSPUtil.getParameter(request, "rev_coa_future1", ""));
		setErpIfDt(JSPUtil.getParameter(request, "erp_if_dt", ""));
		setThirdExRateType(JSPUtil.getParameter(request, "third_ex_rate_type", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setUsdAmt(JSPUtil.getParameter(request, "usd_amt", ""));
		setMainIfSer(JSPUtil.getParameter(request, "main_if_ser", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setChgTyp(JSPUtil.getParameter(request, "chg_typ", ""));
		setInvCoaCenter(JSPUtil.getParameter(request, "inv_coa_center", ""));
		setScp(JSPUtil.getParameter(request, "scp", ""));
		setGlDt(JSPUtil.getParameter(request, "gl_dt", ""));
		setRevCoaVvd(JSPUtil.getParameter(request, "rev_coa_vvd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setRevCoaRegion(JSPUtil.getParameter(request, "rev_coa_region", ""));
		setCreditMk(JSPUtil.getParameter(request, "credit_mk", ""));
		setRepChgTyp(JSPUtil.getParameter(request, "rep_chg_typ", ""));
		setTransTyp(JSPUtil.getParameter(request, "trans_typ", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));
		setInvCoaVvd(JSPUtil.getParameter(request, "inv_coa_vvd", ""));
		setLclAmt(JSPUtil.getParameter(request, "lcl_amt", ""));
		setLifid(JSPUtil.getParameter(request, "lifid", ""));
		setCustRefNo(JSPUtil.getParameter(request, "cust_ref_no", ""));
		setBnd(JSPUtil.getParameter(request, "bnd", ""));
		setHjsRefNo(JSPUtil.getParameter(request, "hjs_ref_no", ""));
		setDtlIfNo(JSPUtil.getParameter(request, "dtl_if_no", ""));
		setDtlIfSer(JSPUtil.getParameter(request, "dtl_if_ser", ""));
		setIfFlag(JSPUtil.getParameter(request, "if_flag", ""));
		setFlag(JSPUtil.getParameter(request, "flag", ""));
		setRevVoy(JSPUtil.getParameter(request, "rev_voy", ""));
		setOnboardDt(JSPUtil.getParameter(request, "onboard_dt", ""));
		setJoInd(JSPUtil.getParameter(request, "jo_ind", ""));
		setActCntryCd(JSPUtil.getParameter(request, "act_cntry_cd", ""));
		setInvCoaRegion(JSPUtil.getParameter(request, "inv_coa_region", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setRevCoaInterCompany(JSPUtil.getParameter(request, "rev_coa_inter_company", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRate(JSPUtil.getParameter(request, "rate", ""));
		setSaDt(JSPUtil.getParameter(request, "sa_dt", ""));
		setDir(JSPUtil.getParameter(request, "dir", ""));
		setMainIfNo(JSPUtil.getParameter(request, "main_if_no", ""));
		setTotalCount(JSPUtil.getParameter(request, "total_count", ""));
		setContNo(JSPUtil.getParameter(request, "cont_no", ""));
		setSlsmanCd(JSPUtil.getParameter(request, "slsman_cd", ""));
		setExRateType(JSPUtil.getParameter(request, "ex_rate_type", ""));
		setSobId(JSPUtil.getParameter(request, "sob_id", ""));
		setRevLane(JSPUtil.getParameter(request, "rev_lane", ""));
		setInvCoaCompany(JSPUtil.getParameter(request, "inv_coa_company", ""));
		setVoy(JSPUtil.getParameter(request, "voy", ""));
		setRevTyp(JSPUtil.getParameter(request, "rev_typ", ""));
		setOriChgCur(JSPUtil.getParameter(request, "ori_chg_cur", ""));
		setCreditTerm(JSPUtil.getParameter(request, "credit_term", ""));
		setCaDt(JSPUtil.getParameter(request, "ca_dt", ""));
		setSource(JSPUtil.getParameter(request, "source", ""));
		setCaNo(JSPUtil.getParameter(request, "ca_no", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setExRateCustDate(JSPUtil.getParameter(request, "ex_rate_cust_date", ""));
		setCttDecNo(JSPUtil.getParameter(request, "ctt_dec_no", ""));
		setOfc(JSPUtil.getParameter(request, "ofc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Fns0120001VO[]
	 */
	public Fns0120001VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Fns0120001VO[]
	 */
	public Fns0120001VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Fns0120001VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] crInvNo = (JSPUtil.getParameter(request, prefix	+ "cr_inv_no", length));
			String[] logRgstDt = (JSPUtil.getParameter(request, prefix	+ "log_rgst_dt", length));
			String[] invCntryCd = (JSPUtil.getParameter(request, prefix	+ "inv_cntry_cd", length));
			String[] slipNo = (JSPUtil.getParameter(request, prefix	+ "slip_no", length));
			String[] ratedAs = (JSPUtil.getParameter(request, prefix	+ "rated_as", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] revDir = (JSPUtil.getParameter(request, prefix	+ "rev_dir", length));
			String[] revEffDt = (JSPUtil.getParameter(request, prefix	+ "rev_eff_dt", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] zoneIoc = (JSPUtil.getParameter(request, prefix	+ "zone_ioc", length));
			String[] oriChgAmt = (JSPUtil.getParameter(request, prefix	+ "ori_chg_amt", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] revCoaCenter = (JSPUtil.getParameter(request, prefix	+ "rev_coa_center", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] curr = (JSPUtil.getParameter(request, prefix	+ "curr", length));
			String[] revCoaCompany = (JSPUtil.getParameter(request, prefix	+ "rev_coa_company", length));
			String[] taxInd = (JSPUtil.getParameter(request, prefix	+ "tax_ind", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] perTyp = (JSPUtil.getParameter(request, prefix	+ "per_typ", length));
			String[] chgFullNm = (JSPUtil.getParameter(request, prefix	+ "chg_full_nm", length));
			String[] salesOfc = (JSPUtil.getParameter(request, prefix	+ "sales_ofc", length));
			String[] logUpdtDt = (JSPUtil.getParameter(request, prefix	+ "log_updt_dt", length));
			String[] revVsl = (JSPUtil.getParameter(request, prefix	+ "rev_vsl", length));
			String[] actCustCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cd", length));
			String[] sailingDt = (JSPUtil.getParameter(request, prefix	+ "sailing_dt", length));
			String[] cntrTpSz = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_sz", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] invCoaAccount = (JSPUtil.getParameter(request, prefix	+ "inv_coa_account", length));
			String[] ctyCd = (JSPUtil.getParameter(request, prefix	+ "cty_cd", length));
			String[] invCoaFuture1 = (JSPUtil.getParameter(request, prefix	+ "inv_coa_future1", length));
			String[] taxExRate = (JSPUtil.getParameter(request, prefix	+ "tax_ex_rate", length));
			String[] invCoaFuture2 = (JSPUtil.getParameter(request, prefix	+ "inv_coa_future2", length));
			String[] invCustCd = (JSPUtil.getParameter(request, prefix	+ "inv_cust_cd", length));
			String[] revCoaAccount = (JSPUtil.getParameter(request, prefix	+ "rev_coa_account", length));
			String[] setoffNo = (JSPUtil.getParameter(request, prefix	+ "setoff_no", length));
			String[] chgCur = (JSPUtil.getParameter(request, prefix	+ "chg_cur", length));
			String[] oblMk = (JSPUtil.getParameter(request, prefix	+ "obl_mk", length));
			String[] acct = (JSPUtil.getParameter(request, prefix	+ "acct", length));
			String[] whfDecNo = (JSPUtil.getParameter(request, prefix	+ "whf_dec_no", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] invCoaInterCompany = (JSPUtil.getParameter(request, prefix	+ "inv_coa_inter_company", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] vsl = (JSPUtil.getParameter(request, prefix	+ "vsl", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] revCoaFuture2 = (JSPUtil.getParameter(request, prefix	+ "rev_coa_future2", length));
			String[] revCoaFuture1 = (JSPUtil.getParameter(request, prefix	+ "rev_coa_future1", length));
			String[] erpIfDt = (JSPUtil.getParameter(request, prefix	+ "erp_if_dt", length));
			String[] thirdExRateType = (JSPUtil.getParameter(request, prefix	+ "third_ex_rate_type", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] mainIfSer = (JSPUtil.getParameter(request, prefix	+ "main_if_ser", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] chgTyp = (JSPUtil.getParameter(request, prefix	+ "chg_typ", length));
			String[] invCoaCenter = (JSPUtil.getParameter(request, prefix	+ "inv_coa_center", length));
			String[] scp = (JSPUtil.getParameter(request, prefix	+ "scp", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] revCoaVvd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_vvd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] revCoaRegion = (JSPUtil.getParameter(request, prefix	+ "rev_coa_region", length));
			String[] creditMk = (JSPUtil.getParameter(request, prefix	+ "credit_mk", length));
			String[] repChgTyp = (JSPUtil.getParameter(request, prefix	+ "rep_chg_typ", length));
			String[] transTyp = (JSPUtil.getParameter(request, prefix	+ "trans_typ", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp", length));
			String[] invCoaVvd = (JSPUtil.getParameter(request, prefix	+ "inv_coa_vvd", length));
			String[] lclAmt = (JSPUtil.getParameter(request, prefix	+ "lcl_amt", length));
			String[] lifid = (JSPUtil.getParameter(request, prefix	+ "lifid", length));
			String[] custRefNo = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no", length));
			String[] bnd = (JSPUtil.getParameter(request, prefix	+ "bnd", length));
			String[] hjsRefNo = (JSPUtil.getParameter(request, prefix	+ "hjs_ref_no", length));
			String[] dtlIfNo = (JSPUtil.getParameter(request, prefix	+ "dtl_if_no", length));
			String[] dtlIfSer = (JSPUtil.getParameter(request, prefix	+ "dtl_if_ser", length));
			String[] ifFlag = (JSPUtil.getParameter(request, prefix	+ "if_flag", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] revVoy = (JSPUtil.getParameter(request, prefix	+ "rev_voy", length));
			String[] onboardDt = (JSPUtil.getParameter(request, prefix	+ "onboard_dt", length));
			String[] joInd = (JSPUtil.getParameter(request, prefix	+ "jo_ind", length));
			String[] actCntryCd = (JSPUtil.getParameter(request, prefix	+ "act_cntry_cd", length));
			String[] invCoaRegion = (JSPUtil.getParameter(request, prefix	+ "inv_coa_region", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] revCoaInterCompany = (JSPUtil.getParameter(request, prefix	+ "rev_coa_inter_company", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] saDt = (JSPUtil.getParameter(request, prefix	+ "sa_dt", length));
			String[] dir = (JSPUtil.getParameter(request, prefix	+ "dir", length));
			String[] mainIfNo = (JSPUtil.getParameter(request, prefix	+ "main_if_no", length));
			String[] totalCount = (JSPUtil.getParameter(request, prefix	+ "total_count", length));
			String[] contNo = (JSPUtil.getParameter(request, prefix	+ "cont_no", length));
			String[] slsmanCd = (JSPUtil.getParameter(request, prefix	+ "slsman_cd", length));
			String[] exRateType = (JSPUtil.getParameter(request, prefix	+ "ex_rate_type", length));
			String[] sobId = (JSPUtil.getParameter(request, prefix	+ "sob_id", length));
			String[] revLane = (JSPUtil.getParameter(request, prefix	+ "rev_lane", length));
			String[] invCoaCompany = (JSPUtil.getParameter(request, prefix	+ "inv_coa_company", length));
			String[] voy = (JSPUtil.getParameter(request, prefix	+ "voy", length));
			String[] revTyp = (JSPUtil.getParameter(request, prefix	+ "rev_typ", length));
			String[] oriChgCur = (JSPUtil.getParameter(request, prefix	+ "ori_chg_cur", length));
			String[] creditTerm = (JSPUtil.getParameter(request, prefix	+ "credit_term", length));
			String[] caDt = (JSPUtil.getParameter(request, prefix	+ "ca_dt", length));
			String[] source = (JSPUtil.getParameter(request, prefix	+ "source", length));
			String[] caNo = (JSPUtil.getParameter(request, prefix	+ "ca_no", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] exRateCustDate = (JSPUtil.getParameter(request, prefix	+ "ex_rate_cust_date", length));
			String[] cttDecNo = (JSPUtil.getParameter(request, prefix	+ "ctt_dec_no", length));
			String[] ofc = (JSPUtil.getParameter(request, prefix	+ "ofc", length));
			
			for (int i = 0; i < length; i++) {
				model = new Fns0120001VO();
				if (crInvNo[i] != null)
					model.setCrInvNo(crInvNo[i]);
				if (logRgstDt[i] != null)
					model.setLogRgstDt(logRgstDt[i]);
				if (invCntryCd[i] != null)
					model.setInvCntryCd(invCntryCd[i]);
				if (slipNo[i] != null)
					model.setSlipNo(slipNo[i]);
				if (ratedAs[i] != null)
					model.setRatedAs(ratedAs[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (revDir[i] != null)
					model.setRevDir(revDir[i]);
				if (revEffDt[i] != null)
					model.setRevEffDt(revEffDt[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (zoneIoc[i] != null)
					model.setZoneIoc(zoneIoc[i]);
				if (oriChgAmt[i] != null)
					model.setOriChgAmt(oriChgAmt[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (revCoaCenter[i] != null)
					model.setRevCoaCenter(revCoaCenter[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (curr[i] != null)
					model.setCurr(curr[i]);
				if (revCoaCompany[i] != null)
					model.setRevCoaCompany(revCoaCompany[i]);
				if (taxInd[i] != null)
					model.setTaxInd(taxInd[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (perTyp[i] != null)
					model.setPerTyp(perTyp[i]);
				if (chgFullNm[i] != null)
					model.setChgFullNm(chgFullNm[i]);
				if (salesOfc[i] != null)
					model.setSalesOfc(salesOfc[i]);
				if (logUpdtDt[i] != null)
					model.setLogUpdtDt(logUpdtDt[i]);
				if (revVsl[i] != null)
					model.setRevVsl(revVsl[i]);
				if (actCustCd[i] != null)
					model.setActCustCd(actCustCd[i]);
				if (sailingDt[i] != null)
					model.setSailingDt(sailingDt[i]);
				if (cntrTpSz[i] != null)
					model.setCntrTpSz(cntrTpSz[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (invCoaAccount[i] != null)
					model.setInvCoaAccount(invCoaAccount[i]);
				if (ctyCd[i] != null)
					model.setCtyCd(ctyCd[i]);
				if (invCoaFuture1[i] != null)
					model.setInvCoaFuture1(invCoaFuture1[i]);
				if (taxExRate[i] != null)
					model.setTaxExRate(taxExRate[i]);
				if (invCoaFuture2[i] != null)
					model.setInvCoaFuture2(invCoaFuture2[i]);
				if (invCustCd[i] != null)
					model.setInvCustCd(invCustCd[i]);
				if (revCoaAccount[i] != null)
					model.setRevCoaAccount(revCoaAccount[i]);
				if (setoffNo[i] != null)
					model.setSetoffNo(setoffNo[i]);
				if (chgCur[i] != null)
					model.setChgCur(chgCur[i]);
				if (oblMk[i] != null)
					model.setOblMk(oblMk[i]);
				if (acct[i] != null)
					model.setAcct(acct[i]);
				if (whfDecNo[i] != null)
					model.setWhfDecNo(whfDecNo[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (invCoaInterCompany[i] != null)
					model.setInvCoaInterCompany(invCoaInterCompany[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (vsl[i] != null)
					model.setVsl(vsl[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (revCoaFuture2[i] != null)
					model.setRevCoaFuture2(revCoaFuture2[i]);
				if (revCoaFuture1[i] != null)
					model.setRevCoaFuture1(revCoaFuture1[i]);
				if (erpIfDt[i] != null)
					model.setErpIfDt(erpIfDt[i]);
				if (thirdExRateType[i] != null)
					model.setThirdExRateType(thirdExRateType[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (mainIfSer[i] != null)
					model.setMainIfSer(mainIfSer[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (chgTyp[i] != null)
					model.setChgTyp(chgTyp[i]);
				if (invCoaCenter[i] != null)
					model.setInvCoaCenter(invCoaCenter[i]);
				if (scp[i] != null)
					model.setScp(scp[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (revCoaVvd[i] != null)
					model.setRevCoaVvd(revCoaVvd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (revCoaRegion[i] != null)
					model.setRevCoaRegion(revCoaRegion[i]);
				if (creditMk[i] != null)
					model.setCreditMk(creditMk[i]);
				if (repChgTyp[i] != null)
					model.setRepChgTyp(repChgTyp[i]);
				if (transTyp[i] != null)
					model.setTransTyp(transTyp[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (invCoaVvd[i] != null)
					model.setInvCoaVvd(invCoaVvd[i]);
				if (lclAmt[i] != null)
					model.setLclAmt(lclAmt[i]);
				if (lifid[i] != null)
					model.setLifid(lifid[i]);
				if (custRefNo[i] != null)
					model.setCustRefNo(custRefNo[i]);
				if (bnd[i] != null)
					model.setBnd(bnd[i]);
				if (hjsRefNo[i] != null)
					model.setHjsRefNo(hjsRefNo[i]);
				if (dtlIfNo[i] != null)
					model.setDtlIfNo(dtlIfNo[i]);
				if (dtlIfSer[i] != null)
					model.setDtlIfSer(dtlIfSer[i]);
				if (ifFlag[i] != null)
					model.setIfFlag(ifFlag[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (revVoy[i] != null)
					model.setRevVoy(revVoy[i]);
				if (onboardDt[i] != null)
					model.setOnboardDt(onboardDt[i]);
				if (joInd[i] != null)
					model.setJoInd(joInd[i]);
				if (actCntryCd[i] != null)
					model.setActCntryCd(actCntryCd[i]);
				if (invCoaRegion[i] != null)
					model.setInvCoaRegion(invCoaRegion[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (revCoaInterCompany[i] != null)
					model.setRevCoaInterCompany(revCoaInterCompany[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (saDt[i] != null)
					model.setSaDt(saDt[i]);
				if (dir[i] != null)
					model.setDir(dir[i]);
				if (mainIfNo[i] != null)
					model.setMainIfNo(mainIfNo[i]);
				if (totalCount[i] != null)
					model.setTotalCount(totalCount[i]);
				if (contNo[i] != null)
					model.setContNo(contNo[i]);
				if (slsmanCd[i] != null)
					model.setSlsmanCd(slsmanCd[i]);
				if (exRateType[i] != null)
					model.setExRateType(exRateType[i]);
				if (sobId[i] != null)
					model.setSobId(sobId[i]);
				if (revLane[i] != null)
					model.setRevLane(revLane[i]);
				if (invCoaCompany[i] != null)
					model.setInvCoaCompany(invCoaCompany[i]);
				if (voy[i] != null)
					model.setVoy(voy[i]);
				if (revTyp[i] != null)
					model.setRevTyp(revTyp[i]);
				if (oriChgCur[i] != null)
					model.setOriChgCur(oriChgCur[i]);
				if (creditTerm[i] != null)
					model.setCreditTerm(creditTerm[i]);
				if (caDt[i] != null)
					model.setCaDt(caDt[i]);
				if (source[i] != null)
					model.setSource(source[i]);
				if (caNo[i] != null)
					model.setCaNo(caNo[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (exRateCustDate[i] != null)
					model.setExRateCustDate(exRateCustDate[i]);
				if (cttDecNo[i] != null)
					model.setCttDecNo(cttDecNo[i]);
				if (ofc[i] != null)
					model.setOfc(ofc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFns0120001VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Fns0120001VO[]
	 */
	public Fns0120001VO[] getFns0120001VOs(){
		Fns0120001VO[] vos = (Fns0120001VO[])models.toArray(new Fns0120001VO[models.size()]);
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
		this.crInvNo = this.crInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logRgstDt = this.logRgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCntryCd = this.invCntryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slipNo = this.slipNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratedAs = this.ratedAs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDir = this.revDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revEffDt = this.revEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zoneIoc = this.zoneIoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriChgAmt = this.oriChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaCenter = this.revCoaCenter .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curr = this.curr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaCompany = this.revCoaCompany .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInd = this.taxInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTyp = this.perTyp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgFullNm = this.chgFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesOfc = this.salesOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logUpdtDt = this.logUpdtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVsl = this.revVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCd = this.actCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailingDt = this.sailingDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpSz = this.cntrTpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaAccount = this.invCoaAccount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyCd = this.ctyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaFuture1 = this.invCoaFuture1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxExRate = this.taxExRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaFuture2 = this.invCoaFuture2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCd = this.invCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaAccount = this.revCoaAccount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.setoffNo = this.setoffNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCur = this.chgCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblMk = this.oblMk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acct = this.acct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDecNo = this.whfDecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaInterCompany = this.invCoaInterCompany .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vsl = this.vsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaFuture2 = this.revCoaFuture2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaFuture1 = this.revCoaFuture1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfDt = this.erpIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thirdExRateType = this.thirdExRateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mainIfSer = this.mainIfSer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTyp = this.chgTyp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaCenter = this.invCoaCenter .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scp = this.scp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaVvd = this.revCoaVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaRegion = this.revCoaRegion .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creditMk = this.creditMk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repChgTyp = this.repChgTyp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTyp = this.transTyp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaVvd = this.invCoaVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclAmt = this.lclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lifid = this.lifid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNo = this.custRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnd = this.bnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsRefNo = this.hjsRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlIfNo = this.dtlIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlIfSer = this.dtlIfSer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlag = this.ifFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVoy = this.revVoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onboardDt = this.onboardDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joInd = this.joInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCntryCd = this.actCntryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaRegion = this.invCoaRegion .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaInterCompany = this.revCoaInterCompany .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saDt = this.saDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dir = this.dir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mainIfNo = this.mainIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCount = this.totalCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contNo = this.contNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsmanCd = this.slsmanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRateType = this.exRateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sobId = this.sobId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revLane = this.revLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaCompany = this.invCoaCompany .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voy = this.voy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTyp = this.revTyp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriChgCur = this.oriChgCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creditTerm = this.creditTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caDt = this.caDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.source = this.source .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caNo = this.caNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRateCustDate = this.exRateCustDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cttDecNo = this.cttDecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofc = this.ofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
