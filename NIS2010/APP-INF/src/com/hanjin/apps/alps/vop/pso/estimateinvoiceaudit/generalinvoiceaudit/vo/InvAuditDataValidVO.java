/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvAuditDataValidVO.java
*@FileTitle : InvAuditDataValidVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2010.02.02 김진주 
* 1.0 Creation
*
* History
* 2012.11.26 진마리아 CHM-201220618-01 TPB 비용 정보 지정시 해당 정보를 TPB IF용 테이블에 저장하고 제어함
* 2014.08.05 이성훈 CHM-201430972 		[PSO] Invoice내 Exchanage Rate 칼럼 추가
=========================================================*/

package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo;

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
 * @author 김진주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvAuditDataValidVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvAuditDataValidVO> models = new ArrayList<InvAuditDataValidVO>();
	
	/* Column Info */
	private String sanitation = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String buoy = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String loclTaxAmt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String inspection = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tariffCost = null;
	/* Column Info */
	private String newservice = null;
	/* Column Info */
	private String deplh = null;
	/* Column Info */
	private String amount = null;
	/* Column Info */
	private String apEffDt = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String orgFlg = null;
	/* Column Info */
	private String arrnt = null;
	/* Column Info */
	private String arrtp = null;
	/* Column Info */
	private String ydChgNo = null;
	/* Column Info */
	private String lgsCostFullNm = null;
	/* Column Info */
	private String adjcost = null;
	/* Column Info */
	private String arrtuh = null;
	/* Column Info */
	private String loclNetAmt = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String deptp = null;
	/* Column Info */
	private String budScnrNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String payTermDys = null;
	/* Column Info */
	private String updateflag = null;
	/* Column Info */
	private String holiday = null;
	/* Column Info */
	private String deptuh = null;
	/* Column Info */
	private String usdhrs = null;
	/* Column Info */
	private String soDtlSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String psoChgStsCd = null;
	/* Column Info */
	private String barge = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String psoTrnsSlpCtnt = null;
	/* Column Info */
	private String soSeq = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String loclWhldTaxAmt = null;
	/* Column Info */
	private String issCtyCd = null;
	/* Column Info */
	private String foml2 = null;
	/* Column Info */
	private String cond1 = null;
	/* Column Info */
	private String foml1 = null;
	/* Column Info */
	private String cond2 = null;
	/* Column Info */
	private String issDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tugrope = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String ydChgVerSeq = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String atd = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String invRgstNo = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String acptDt = null;
	/* Column Info */
	private String arrlh = null;
	/* Column Info */
	private String loclAmt = null;
	/* Column Info */
	private String boat = null;
	/* Column Info */
	private String ttlUsdAmt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String io = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String depnt = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String ttlLoclAmt = null;
	/* Column Info */
	private String loclDdctAmt = null;
	/* Column Info */
	private String night = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String credit = null;	//[2010.02.24:jmh]
	/* Column Info */
	private String copilot = null;
	/* Column Info */
	private String invLoclAmt = null;
	/* Column Info */
	private String delChk = null;	//[2010.04.14:jmh]
	/* Column Info */
	private String ioChk = null;	//[2010.08.23:이준범]	
	/* Column Info */
	private String n3ptyBilIfFlg = null;	
	/* Column Info */
	private String n3ptyBilTpCd = null;	
	/* Column Info */
	private String ifRmk = null;	
	/* Column Info */
	private String n3ptyVndrSeq = null;	
	/* Column Info */
	private String mnlInpXchRt = null;	
	/* Column Info */
	private String trfCurrCd = null;	
	/* Column Info */
	private String costCalcEffFmDt = null;	//2015.03.12	
	/* Column Info */
	private String costCalcEffToDt = null;	//2015.03.12
	/* Column Info */
	private String bafRt = null;	//2015.12.16
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvAuditDataValidVO() {}

	public InvAuditDataValidVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String acctCd, String costCd, String io, String vndrLglEngNm, String lgsCostFullNm, String tariffCost, String adjcost, String amount, String foml1, String foml2, String cond1, String cond2, String remark, String ydChgNo, String ydChgVerSeq, String usrId, String issCtyCd, String soSeq, String soDtlSeq, String ydCd, String vndrSeq, String costOfcCd, String invOfcCd, String invNo, String currCd, String ttlLoclAmt, String ttlUsdAmt, String loclAmt, String loclTaxAmt, String loclNetAmt, String loclDdctAmt, String loclWhldTaxAmt, String acptDt, String issDt, String effDt, String payTermDys, String dueDt, String apEffDt, String psoChgStsCd, String invRgstNo, String atd, String updateflag, String revYrmon, String night, String holiday, String boat, String tugrope, String buoy, String sanitation, String barge, String inspection, String arrtp, String deptp, String arrnt, String depnt, String arrtuh, String deptuh, String arrlh, String deplh, String psoTrnsSlpCtnt, String orgFlg, String budScnrNo, String newservice, String rlaneCd, String usdhrs, String vvd, String credit, String copilot, String invLoclAmt, String delChk, String ioChk, String n3ptyBilIfFlg, String n3ptyBilTpCd, String ifRmk, String n3ptyVndrSeq, String mnlInpXchRt, String trfCurrCd, String costCalcEffFmDt,String costCalcEffToDt,String bafRt) {
		this.sanitation = sanitation;
		this.vslCd = vslCd;
		this.buoy = buoy;
		this.remark = remark;
		this.loclTaxAmt = loclTaxAmt;
		this.rlaneCd = rlaneCd;
		this.inspection = inspection;
		this.pagerows = pagerows;
		this.tariffCost = tariffCost;
		this.newservice = newservice;
		this.deplh = deplh;
		this.amount = amount;
		this.apEffDt = apEffDt;
		this.effDt = effDt;
		this.costCd = costCd;
		this.orgFlg = orgFlg;
		this.arrnt = arrnt;
		this.arrtp = arrtp;
		this.ydChgNo = ydChgNo;
		this.lgsCostFullNm = lgsCostFullNm;
		this.adjcost = adjcost;
		this.arrtuh = arrtuh;
		this.loclNetAmt = loclNetAmt;
		this.revYrmon = revYrmon;
		this.deptp = deptp;
		this.budScnrNo = budScnrNo;
		this.skdVoyNo = skdVoyNo;
		this.payTermDys = payTermDys;
		this.updateflag = updateflag;
		this.holiday = holiday;
		this.deptuh = deptuh;
		this.usdhrs = usdhrs;
		this.soDtlSeq = soDtlSeq;
		this.vndrSeq = vndrSeq;
		this.psoChgStsCd = psoChgStsCd;
		this.barge = barge;
		this.currCd = currCd;
		this.psoTrnsSlpCtnt = psoTrnsSlpCtnt;
		this.soSeq = soSeq;
		this.vndrLglEngNm = vndrLglEngNm;
		this.loclWhldTaxAmt = loclWhldTaxAmt;
		this.issCtyCd = issCtyCd;
		this.foml2 = foml2;
		this.cond1 = cond1;
		this.foml1 = foml1;
		this.cond2 = cond2;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.tugrope = tugrope;
		this.usrId = usrId;
		this.ydChgVerSeq = ydChgVerSeq;
		this.acctCd = acctCd;
		this.atd = atd;
		this.dueDt = dueDt;
		this.invOfcCd = invOfcCd;
		this.invRgstNo = invRgstNo;
		this.costOfcCd = costOfcCd;
		this.acptDt = acptDt;
		this.arrlh = arrlh;
		this.loclAmt = loclAmt;
		this.boat = boat;
		this.ttlUsdAmt = ttlUsdAmt;
		this.skdDirCd = skdDirCd;
		this.io = io;
		this.invNo = invNo;
		this.depnt = depnt;
		this.ydCd = ydCd;
		this.ttlLoclAmt = ttlLoclAmt;
		this.loclDdctAmt = loclDdctAmt;
		this.night = night;
		this.vvd = vvd;
		this.credit = credit;
		this.copilot = copilot;
		this.invLoclAmt = invLoclAmt;
		this.delChk = delChk;
		this.ioChk = ioChk;
		this.n3ptyBilIfFlg = n3ptyBilIfFlg;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.ifRmk = ifRmk;
		this.n3ptyVndrSeq = n3ptyVndrSeq;
		this.mnlInpXchRt = mnlInpXchRt;
		this.trfCurrCd = trfCurrCd;
		this.costCalcEffFmDt = costCalcEffFmDt;
		this.costCalcEffToDt = costCalcEffToDt;
		this.bafRt   = bafRt;
		

		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sanitation", getSanitation());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("buoy", getBuoy());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("locl_tax_amt", getLoclTaxAmt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("inspection", getInspection());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tariff_cost", getTariffCost());
		this.hashColumns.put("newservice", getNewservice());
		this.hashColumns.put("deplh", getDeplh());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("ap_eff_dt", getApEffDt());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("org_flg", getOrgFlg());
		this.hashColumns.put("arrnt", getArrnt());
		this.hashColumns.put("arrtp", getArrtp());
		this.hashColumns.put("yd_chg_no", getYdChgNo());
		this.hashColumns.put("lgs_cost_full_nm", getLgsCostFullNm());
		this.hashColumns.put("adjcost", getAdjcost());
		this.hashColumns.put("arrtuh", getArrtuh());
		this.hashColumns.put("locl_net_amt", getLoclNetAmt());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("deptp", getDeptp());
		this.hashColumns.put("bud_scnr_no", getBudScnrNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pay_term_dys", getPayTermDys());
		this.hashColumns.put("updateflag", getUpdateflag());
		this.hashColumns.put("holiday", getHoliday());
		this.hashColumns.put("deptuh", getDeptuh());
		this.hashColumns.put("usdhrs", getUsdhrs());
		this.hashColumns.put("so_dtl_seq", getSoDtlSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("pso_chg_sts_cd", getPsoChgStsCd());
		this.hashColumns.put("barge", getBarge());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pso_trns_slp_ctnt", getPsoTrnsSlpCtnt());
		this.hashColumns.put("so_seq", getSoSeq());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("locl_whld_tax_amt", getLoclWhldTaxAmt());
		this.hashColumns.put("iss_cty_cd", getIssCtyCd());
		this.hashColumns.put("foml2", getFoml2());
		this.hashColumns.put("cond1", getCond1());
		this.hashColumns.put("foml1", getFoml1());
		this.hashColumns.put("cond2", getCond2());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tugrope", getTugrope());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("atd", getAtd());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("inv_rgst_no", getInvRgstNo());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("acpt_dt", getAcptDt());
		this.hashColumns.put("arrlh", getArrlh());
		this.hashColumns.put("locl_amt", getLoclAmt());
		this.hashColumns.put("boat", getBoat());
		this.hashColumns.put("ttl_usd_amt", getTtlUsdAmt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("io", getIo());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("depnt", getDepnt());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("ttl_locl_amt", getTtlLoclAmt());
		this.hashColumns.put("locl_ddct_amt", getLoclDdctAmt());
		this.hashColumns.put("night", getNight());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("credit", getCredit());
		this.hashColumns.put("copilot", getCopilot());
		this.hashColumns.put("inv_locl_amt", getInvLoclAmt());
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("io_chk", getIoChk());
		this.hashColumns.put("n3pty_bil_if_flg", getN3ptyBilIfFlg());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("if_rmk", getIfRmk());
		this.hashColumns.put("n3pty_vndr_seq", getN3ptyVndrSeq());
		this.hashColumns.put("mnl_inp_xch_rt", getMnlInpXchRt());
		this.hashColumns.put("trf_curr_cd", getTrfCurrCd());
		this.hashColumns.put("cost_calc_eff_fm_dt", getCostCalcEffFmDt());
		this.hashColumns.put("cost_calc_eff_to_dt", getCostCalcEffToDt());
		this.hashColumns.put("baf_rt", getBafRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sanitation", "sanitation");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("buoy", "buoy");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("locl_tax_amt", "loclTaxAmt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("inspection", "inspection");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tariff_cost", "tariffCost");
		this.hashFields.put("newservice", "newservice");
		this.hashFields.put("deplh", "deplh");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("ap_eff_dt", "apEffDt");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("org_flg", "orgFlg");
		this.hashFields.put("arrnt", "arrnt");
		this.hashFields.put("arrtp", "arrtp");
		this.hashFields.put("yd_chg_no", "ydChgNo");
		this.hashFields.put("lgs_cost_full_nm", "lgsCostFullNm");
		this.hashFields.put("adjcost", "adjcost");
		this.hashFields.put("arrtuh", "arrtuh");
		this.hashFields.put("locl_net_amt", "loclNetAmt");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("deptp", "deptp");
		this.hashFields.put("bud_scnr_no", "budScnrNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pay_term_dys", "payTermDys");
		this.hashFields.put("updateflag", "updateflag");
		this.hashFields.put("holiday", "holiday");
		this.hashFields.put("deptuh", "deptuh");
		this.hashFields.put("usdhrs", "usdhrs");
		this.hashFields.put("so_dtl_seq", "soDtlSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("pso_chg_sts_cd", "psoChgStsCd");
		this.hashFields.put("barge", "barge");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pso_trns_slp_ctnt", "psoTrnsSlpCtnt");
		this.hashFields.put("so_seq", "soSeq");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("locl_whld_tax_amt", "loclWhldTaxAmt");
		this.hashFields.put("iss_cty_cd", "issCtyCd");
		this.hashFields.put("foml2", "foml2");
		this.hashFields.put("cond1", "cond1");
		this.hashFields.put("foml1", "foml1");
		this.hashFields.put("cond2", "cond2");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tugrope", "tugrope");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("atd", "atd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("inv_rgst_no", "invRgstNo");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("acpt_dt", "acptDt");
		this.hashFields.put("arrlh", "arrlh");
		this.hashFields.put("locl_amt", "loclAmt");
		this.hashFields.put("boat", "boat");
		this.hashFields.put("ttl_usd_amt", "ttlUsdAmt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("io", "io");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("depnt", "depnt");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("ttl_locl_amt", "ttlLoclAmt");
		this.hashFields.put("locl_ddct_amt", "loclDdctAmt");
		this.hashFields.put("night", "night");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("credit", "credit");
		this.hashFields.put("copilot", "copilot");
		this.hashFields.put("inv_locl_amt", "invLoclAmt");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("io_chk", "ioChk");		
		this.hashFields.put("n3pty_bil_if_flg", "n3ptyBilIfFlg");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("if_rmk", "ifRmk");
		this.hashFields.put("n3pty_vndr_seq", "n3ptyVndrSeq");
		this.hashFields.put("mnl_inp_xch_rt", "mnlInpXchRt");
		this.hashFields.put("trf_curr_cd", "trfCurrCd");
		this.hashFields.put("cost_calc_eff_fm_dt", "costCalcEffFmDt");
		this.hashFields.put("cost_calc_eff_to_dt", "costCalcEffToDt");
		this.hashFields.put("baf_rt", "bafRt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bafRt
	 */
	public String getBafRt() {
		return this.bafRt;
	}
	
	/**
	 * Column Info
	 * @return costCalcEffFmDt
	 */
	public String getCostCalcEffFmDt() {
		return this.costCalcEffFmDt;
	}
	
	/**
	 * Column Info
	 * @return costCalcEffToDt
	 */
	public String getCostCalcEffToDt() {
		return this.costCalcEffToDt;
	}
	/**
	 * Column Info
	 * @return sanitation
	 */
	public String getSanitation() {
		return this.sanitation;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return buoy
	 */
	public String getBuoy() {
		return this.buoy;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return loclTaxAmt
	 */
	public String getLoclTaxAmt() {
		return this.loclTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return inspection
	 */
	public String getInspection() {
		return this.inspection;
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
	 * @return tariffCost
	 */
	public String getTariffCost() {
		return this.tariffCost;
	}
	
	/**
	 * Column Info
	 * @return newservice
	 */
	public String getNewservice() {
		return this.newservice;
	}
	
	/**
	 * Column Info
	 * @return deplh
	 */
	public String getDeplh() {
		return this.deplh;
	}
	
	/**
	 * Column Info
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
	}
	
	/**
	 * Column Info
	 * @return apEffDt
	 */
	public String getApEffDt() {
		return this.apEffDt;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return orgFlg
	 */
	public String getOrgFlg() {
		return this.orgFlg;
	}
	
	/**
	 * Column Info
	 * @return arrnt
	 */
	public String getArrnt() {
		return this.arrnt;
	}
	
	/**
	 * Column Info
	 * @return arrtp
	 */
	public String getArrtp() {
		return this.arrtp;
	}
	
	/**
	 * Column Info
	 * @return ydChgNo
	 */
	public String getYdChgNo() {
		return this.ydChgNo;
	}
	
	/**
	 * Column Info
	 * @return lgsCostFullNm
	 */
	public String getLgsCostFullNm() {
		return this.lgsCostFullNm;
	}
	
	/**
	 * Column Info
	 * @return adjcost
	 */
	public String getAdjcost() {
		return this.adjcost;
	}
	
	/**
	 * Column Info
	 * @return arrtuh
	 */
	public String getArrtuh() {
		return this.arrtuh;
	}
	
	/**
	 * Column Info
	 * @return loclNetAmt
	 */
	public String getLoclNetAmt() {
		return this.loclNetAmt;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return deptp
	 */
	public String getDeptp() {
		return this.deptp;
	}
	
	/**
	 * Column Info
	 * @return budScnrNo
	 */
	public String getBudScnrNo() {
		return this.budScnrNo;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return payTermDys
	 */
	public String getPayTermDys() {
		return this.payTermDys;
	}
	
	/**
	 * Column Info
	 * @return updateflag
	 */
	public String getUpdateflag() {
		return this.updateflag;
	}
	
	/**
	 * Column Info
	 * @return holiday
	 */
	public String getHoliday() {
		return this.holiday;
	}
	
	/**
	 * Column Info
	 * @return deptuh
	 */
	public String getDeptuh() {
		return this.deptuh;
	}
	
	/**
	 * Column Info
	 * @return usdhrs
	 */
	public String getUsdhrs() {
		return this.usdhrs;
	}
	
	/**
	 * Column Info
	 * @return soDtlSeq
	 */
	public String getSoDtlSeq() {
		return this.soDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return psoChgStsCd
	 */
	public String getPsoChgStsCd() {
		return this.psoChgStsCd;
	}
	
	/**
	 * Column Info
	 * @return barge
	 */
	public String getBarge() {
		return this.barge;
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
	 * @return psoTrnsSlpCtnt
	 */
	public String getPsoTrnsSlpCtnt() {
		return this.psoTrnsSlpCtnt;
	}
	
	/**
	 * Column Info
	 * @return soSeq
	 */
	public String getSoSeq() {
		return this.soSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return loclWhldTaxAmt
	 */
	public String getLoclWhldTaxAmt() {
		return this.loclWhldTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return issCtyCd
	 */
	public String getIssCtyCd() {
		return this.issCtyCd;
	}
	
	/**
	 * Column Info
	 * @return foml2
	 */
	public String getFoml2() {
		return this.foml2;
	}
	
	/**
	 * Column Info
	 * @return cond1
	 */
	public String getCond1() {
		return this.cond1;
	}
	
	/**
	 * Column Info
	 * @return foml1
	 */
	public String getFoml1() {
		return this.foml1;
	}
	
	/**
	 * Column Info
	 * @return cond2
	 */
	public String getCond2() {
		return this.cond2;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return tugrope
	 */
	public String getTugrope() {
		return this.tugrope;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return ydChgVerSeq
	 */
	public String getYdChgVerSeq() {
		return this.ydChgVerSeq;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return atd
	 */
	public String getAtd() {
		return this.atd;
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
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invRgstNo
	 */
	public String getInvRgstNo() {
		return this.invRgstNo;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return acptDt
	 */
	public String getAcptDt() {
		return this.acptDt;
	}
	
	/**
	 * Column Info
	 * @return arrlh
	 */
	public String getArrlh() {
		return this.arrlh;
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
	 * @return boat
	 */
	public String getBoat() {
		return this.boat;
	}
	
	/**
	 * Column Info
	 * @return ttlUsdAmt
	 */
	public String getTtlUsdAmt() {
		return this.ttlUsdAmt;
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
	 * @return io
	 */
	public String getIo() {
		return this.io;
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
	 * @return depnt
	 */
	public String getDepnt() {
		return this.depnt;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return ttlLoclAmt
	 */
	public String getTtlLoclAmt() {
		return this.ttlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return loclDdctAmt
	 */
	public String getLoclDdctAmt() {
		return this.loclDdctAmt;
	}
	
	/**
	 * Column Info
	 * @return night
	 */
	public String getNight() {
		return this.night;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilIfFlg
	 */
	public String getN3ptyBilIfFlg() {
		return this.n3ptyBilIfFlg;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpCd
	 */
	public String getN3ptyBilTpCd() {
		return this.n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @return ifRmk
	 */
	public String getIfRmk() {
		return this.ifRmk;
	}
	
	/**
	 * Column Info
	 * @return n3ptyVndrSeq
	 */
	public String getN3ptyVndrSeq() {
		return this.n3ptyVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return mnlInpXchRt
	 */
	public String getMnlInpXchRt() {
		return this.mnlInpXchRt;
	}
	
	/**
	 * Column Info
	 * @return trfCurrCd
	 */
	public String getTrfCurrCd() {
		return this.trfCurrCd;
	}
	
	/**
	 * Column Info
	 * @param sanitation
	 */
	public void setSanitation(String sanitation) {
		this.sanitation = sanitation;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param buoy
	 */
	public void setBuoy(String buoy) {
		this.buoy = buoy;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param loclTaxAmt
	 */
	public void setLoclTaxAmt(String loclTaxAmt) {
		this.loclTaxAmt = loclTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param inspection
	 */
	public void setInspection(String inspection) {
		this.inspection = inspection;
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
	 * @param tariffCost
	 */
	public void setTariffCost(String tariffCost) {
		this.tariffCost = tariffCost;
	}
	
	/**
	 * Column Info
	 * @param newservice
	 */
	public void setNewservice(String newservice) {
		this.newservice = newservice;
	}
	
	/**
	 * Column Info
	 * @param deplh
	 */
	public void setDeplh(String deplh) {
		this.deplh = deplh;
	}
	
	/**
	 * Column Info
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * Column Info
	 * @param apEffDt
	 */
	public void setApEffDt(String apEffDt) {
		this.apEffDt = apEffDt;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param orgFlg
	 */
	public void setOrgFlg(String orgFlg) {
		this.orgFlg = orgFlg;
	}
	
	/**
	 * Column Info
	 * @param arrnt
	 */
	public void setArrnt(String arrnt) {
		this.arrnt = arrnt;
	}
	
	/**
	 * Column Info
	 * @param arrtp
	 */
	public void setArrtp(String arrtp) {
		this.arrtp = arrtp;
	}
	
	/**
	 * Column Info
	 * @param ydChgNo
	 */
	public void setYdChgNo(String ydChgNo) {
		this.ydChgNo = ydChgNo;
	}
	
	/**
	 * Column Info
	 * @param lgsCostFullNm
	 */
	public void setLgsCostFullNm(String lgsCostFullNm) {
		this.lgsCostFullNm = lgsCostFullNm;
	}
	
	/**
	 * Column Info
	 * @param adjcost
	 */
	public void setAdjcost(String adjcost) {
		this.adjcost = adjcost;
	}
	
	/**
	 * Column Info
	 * @param arrtuh
	 */
	public void setArrtuh(String arrtuh) {
		this.arrtuh = arrtuh;
	}
	
	/**
	 * Column Info
	 * @param loclNetAmt
	 */
	public void setLoclNetAmt(String loclNetAmt) {
		this.loclNetAmt = loclNetAmt;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param deptp
	 */
	public void setDeptp(String deptp) {
		this.deptp = deptp;
	}
	
	/**
	 * Column Info
	 * @param budScnrNo
	 */
	public void setBudScnrNo(String budScnrNo) {
		this.budScnrNo = budScnrNo;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param payTermDys
	 */
	public void setPayTermDys(String payTermDys) {
		this.payTermDys = payTermDys;
	}
	
	/**
	 * Column Info
	 * @param updateflag
	 */
	public void setUpdateflag(String updateflag) {
		this.updateflag = updateflag;
	}
	
	/**
	 * Column Info
	 * @param holiday
	 */
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	
	/**
	 * Column Info
	 * @param deptuh
	 */
	public void setDeptuh(String deptuh) {
		this.deptuh = deptuh;
	}
	
	/**
	 * Column Info
	 * @param usdhrs
	 */
	public void setUsdhrs(String usdhrs) {
		this.usdhrs = usdhrs;
	}
	
	/**
	 * Column Info
	 * @param soDtlSeq
	 */
	public void setSoDtlSeq(String soDtlSeq) {
		this.soDtlSeq = soDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param psoChgStsCd
	 */
	public void setPsoChgStsCd(String psoChgStsCd) {
		this.psoChgStsCd = psoChgStsCd;
	}
	
	/**
	 * Column Info
	 * @param barge
	 */
	public void setBarge(String barge) {
		this.barge = barge;
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
	 * @param psoTrnsSlpCtnt
	 */
	public void setPsoTrnsSlpCtnt(String psoTrnsSlpCtnt) {
		this.psoTrnsSlpCtnt = psoTrnsSlpCtnt;
	}
	
	/**
	 * Column Info
	 * @param soSeq
	 */
	public void setSoSeq(String soSeq) {
		this.soSeq = soSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param loclWhldTaxAmt
	 */
	public void setLoclWhldTaxAmt(String loclWhldTaxAmt) {
		this.loclWhldTaxAmt = loclWhldTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param issCtyCd
	 */
	public void setIssCtyCd(String issCtyCd) {
		this.issCtyCd = issCtyCd;
	}
	
	/**
	 * Column Info
	 * @param foml2
	 */
	public void setFoml2(String foml2) {
		this.foml2 = foml2;
	}
	
	/**
	 * Column Info
	 * @param cond1
	 */
	public void setCond1(String cond1) {
		this.cond1 = cond1;
	}
	
	/**
	 * Column Info
	 * @param foml1
	 */
	public void setFoml1(String foml1) {
		this.foml1 = foml1;
	}
	
	/**
	 * Column Info
	 * @param cond2
	 */
	public void setCond2(String cond2) {
		this.cond2 = cond2;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param tugrope
	 */
	public void setTugrope(String tugrope) {
		this.tugrope = tugrope;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param ydChgVerSeq
	 */
	public void setYdChgVerSeq(String ydChgVerSeq) {
		this.ydChgVerSeq = ydChgVerSeq;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param atd
	 */
	public void setAtd(String atd) {
		this.atd = atd;
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
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invRgstNo
	 */
	public void setInvRgstNo(String invRgstNo) {
		this.invRgstNo = invRgstNo;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param acptDt
	 */
	public void setAcptDt(String acptDt) {
		this.acptDt = acptDt;
	}
	
	/**
	 * Column Info
	 * @param arrlh
	 */
	public void setArrlh(String arrlh) {
		this.arrlh = arrlh;
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
	 * @param boat
	 */
	public void setBoat(String boat) {
		this.boat = boat;
	}
	
	/**
	 * Column Info
	 * @param ttlUsdAmt
	 */
	public void setTtlUsdAmt(String ttlUsdAmt) {
		this.ttlUsdAmt = ttlUsdAmt;
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
	 * @param io
	 */
	public void setIo(String io) {
		this.io = io;
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
	 * @param depnt
	 */
	public void setDepnt(String depnt) {
		this.depnt = depnt;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param ttlLoclAmt
	 */
	public void setTtlLoclAmt(String ttlLoclAmt) {
		this.ttlLoclAmt = ttlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param loclDdctAmt
	 */
	public void setLoclDdctAmt(String loclDdctAmt) {
		this.loclDdctAmt = loclDdctAmt;
	}
	
	/**
	 * Column Info
	 * @param night
	 */
	public void setNight(String night) {
		this.night = night;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilIfFlg
	 */
	public void setN3ptyBilIfFlg(String n3ptyBilIfFlg) {
		this.n3ptyBilIfFlg = n3ptyBilIfFlg;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpCd
	 */
	public void setN3ptyBilTpCd(String n3ptyBilTpCd) {
		this.n3ptyBilTpCd = n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @param ifRmk
	 */
	public void setIfRmk(String ifRmk) {
		this.ifRmk = ifRmk;
	}
	
	/**
	 * Column Info
	 * @param n3ptyVndrSeq
	 */
	public void setN3ptyVndrSeq(String n3ptyVndrSeq) {
		this.n3ptyVndrSeq = n3ptyVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param mnlInpXchRt
	 */
	public void setMnlInpXchRt(String mnlInpXchRt) {
		this.mnlInpXchRt = mnlInpXchRt;
	}
	
	/**
	 * Column Info
	 * @param trfCurrCd
	 */
	public void setTrfCurrCd(String trfCurrCd) {
		this.trfCurrCd = trfCurrCd;
	}
	
	/**
	 * Column Info
	 * @param costCalcEffFmDt
	 */
	public void setCostCalcEffFmDt(String costCalcEffFmDt) {
		this.costCalcEffFmDt = costCalcEffFmDt;
	}
	
	/**
	 * Column Info
	 * @param costCalcEffToDt
	 */
	public void setCostCalcEffToDt(String costCalcEffToDt) {
		this.costCalcEffToDt = costCalcEffToDt;
	}
	
	/**
	 * Column Info
	 * @param bafRt
	 */
	public void setBafRt(String bafRt) {
		this.bafRt = bafRt;
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
		setSanitation(JSPUtil.getParameter(request, prefix + "sanitation", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setBuoy(JSPUtil.getParameter(request, prefix + "buoy", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setLoclTaxAmt(JSPUtil.getParameter(request, prefix + "locl_tax_amt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setInspection(JSPUtil.getParameter(request, prefix + "inspection", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTariffCost(JSPUtil.getParameter(request, prefix + "tariff_cost", ""));
		setNewservice(JSPUtil.getParameter(request, prefix + "newservice", ""));
		setDeplh(JSPUtil.getParameter(request, prefix + "deplh", ""));
		setAmount(JSPUtil.getParameter(request, prefix + "amount", ""));
		setApEffDt(JSPUtil.getParameter(request, prefix + "ap_eff_dt", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setOrgFlg(JSPUtil.getParameter(request, prefix + "org_flg", ""));
		setArrnt(JSPUtil.getParameter(request, prefix + "arrnt", ""));
		setArrtp(JSPUtil.getParameter(request, prefix + "arrtp", ""));
		setYdChgNo(JSPUtil.getParameter(request, prefix + "yd_chg_no", ""));
		setLgsCostFullNm(JSPUtil.getParameter(request, prefix + "lgs_cost_full_nm", ""));
		setAdjcost(JSPUtil.getParameter(request, prefix + "adjcost", ""));
		setArrtuh(JSPUtil.getParameter(request, prefix + "arrtuh", ""));
		setLoclNetAmt(JSPUtil.getParameter(request, prefix + "locl_net_amt", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setDeptp(JSPUtil.getParameter(request, prefix + "deptp", ""));
		setBudScnrNo(JSPUtil.getParameter(request, prefix + "bud_scnr_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setPayTermDys(JSPUtil.getParameter(request, prefix + "pay_term_dys", ""));
		setUpdateflag(JSPUtil.getParameter(request, prefix + "updateflag", ""));
		setHoliday(JSPUtil.getParameter(request, prefix + "holiday", ""));
		setDeptuh(JSPUtil.getParameter(request, prefix + "deptuh", ""));
		setUsdhrs(JSPUtil.getParameter(request, prefix + "usdhrs", ""));
		setSoDtlSeq(JSPUtil.getParameter(request, prefix + "so_dtl_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setPsoChgStsCd(JSPUtil.getParameter(request, prefix + "pso_chg_sts_cd", ""));
		setBarge(JSPUtil.getParameter(request, prefix + "barge", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPsoTrnsSlpCtnt(JSPUtil.getParameter(request, prefix + "pso_trns_slp_ctnt", ""));
		setSoSeq(JSPUtil.getParameter(request, prefix + "so_seq", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setLoclWhldTaxAmt(JSPUtil.getParameter(request, prefix + "locl_whld_tax_amt", ""));
		setIssCtyCd(JSPUtil.getParameter(request, prefix + "iss_cty_cd", ""));
		setFoml2(JSPUtil.getParameter(request, prefix + "foml2", ""));
		setCond1(JSPUtil.getParameter(request, prefix + "cond1", ""));
		setFoml1(JSPUtil.getParameter(request, prefix + "foml1", ""));
		setCond2(JSPUtil.getParameter(request, prefix + "cond2", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTugrope(JSPUtil.getParameter(request, prefix + "tugrope", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setYdChgVerSeq(JSPUtil.getParameter(request, prefix + "yd_chg_ver_seq", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setAtd(JSPUtil.getParameter(request, prefix + "atd", ""));
		setDueDt(JSPUtil.getParameter(request, prefix + "due_dt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setInvRgstNo(JSPUtil.getParameter(request, prefix + "inv_rgst_no", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setAcptDt(JSPUtil.getParameter(request, prefix + "acpt_dt", ""));
		setArrlh(JSPUtil.getParameter(request, prefix + "arrlh", ""));
		setLoclAmt(JSPUtil.getParameter(request, prefix + "locl_amt", ""));
		setBoat(JSPUtil.getParameter(request, prefix + "boat", ""));
		setTtlUsdAmt(JSPUtil.getParameter(request, prefix + "ttl_usd_amt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setIo(JSPUtil.getParameter(request, prefix + "io", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setDepnt(JSPUtil.getParameter(request, prefix + "depnt", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setTtlLoclAmt(JSPUtil.getParameter(request, prefix + "ttl_locl_amt", ""));
		setLoclDdctAmt(JSPUtil.getParameter(request, prefix + "locl_ddct_amt", ""));
		setNight(JSPUtil.getParameter(request, prefix + "night", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setCredit(JSPUtil.getParameter(request, prefix + "credit", ""));
		setCopilot(JSPUtil.getParameter(request, prefix + "copilot", ""));
		setInvLoclAmt(JSPUtil.getParameter(request, prefix + "inv_locl_amt", ""));
		setDelChk(JSPUtil.getParameter(request, prefix + "del_chk", ""));
		setIoChk(JSPUtil.getParameter(request, prefix + "io_chk", ""));
		setN3ptyBilIfFlg(JSPUtil.getParameter(request, prefix + "n3pty_bil_if_flg", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, prefix + "n3pty_bil_tp_cd", ""));
		setIfRmk(JSPUtil.getParameter(request, prefix + "if_rmk", ""));
		setN3ptyVndrSeq(JSPUtil.getParameter(request, prefix + "n3pty_vndr_seq", ""));
		setMnlInpXchRt(JSPUtil.getParameter(request, prefix + "mnl_inp_xch_rt", ""));
		setTrfCurrCd(JSPUtil.getParameter(request, prefix + "trf_curr_cd", ""));
		setCostCalcEffFmDt(JSPUtil.getParameter(request, prefix + "cost_calc_eff_fm_dt", ""));
		setCostCalcEffToDt(JSPUtil.getParameter(request, prefix + "cost_calc_eff_to_dt", ""));
		setBafRt(JSPUtil.getParameter(request, prefix + "baf_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvAuditDataValidVO[]
	 */
	public InvAuditDataValidVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvAuditDataValidVO[]
	 */
	public InvAuditDataValidVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvAuditDataValidVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sanitation = (JSPUtil.getParameter(request, prefix	+ "sanitation", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] buoy = (JSPUtil.getParameter(request, prefix	+ "buoy", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] loclTaxAmt = (JSPUtil.getParameter(request, prefix	+ "locl_tax_amt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] inspection = (JSPUtil.getParameter(request, prefix	+ "inspection", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tariffCost = (JSPUtil.getParameter(request, prefix	+ "tariff_cost", length));
			String[] newservice = (JSPUtil.getParameter(request, prefix	+ "newservice", length));
			String[] deplh = (JSPUtil.getParameter(request, prefix	+ "deplh", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] apEffDt = (JSPUtil.getParameter(request, prefix	+ "ap_eff_dt", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] orgFlg = (JSPUtil.getParameter(request, prefix	+ "org_flg", length));
			String[] arrnt = (JSPUtil.getParameter(request, prefix	+ "arrnt", length));
			String[] arrtp = (JSPUtil.getParameter(request, prefix	+ "arrtp", length));
			String[] ydChgNo = (JSPUtil.getParameter(request, prefix	+ "yd_chg_no", length));
			String[] lgsCostFullNm = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_full_nm", length));
			String[] adjcost = (JSPUtil.getParameter(request, prefix	+ "adjcost", length));
			String[] arrtuh = (JSPUtil.getParameter(request, prefix	+ "arrtuh", length));
			String[] loclNetAmt = (JSPUtil.getParameter(request, prefix	+ "locl_net_amt", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] deptp = (JSPUtil.getParameter(request, prefix	+ "deptp", length));
			String[] budScnrNo = (JSPUtil.getParameter(request, prefix	+ "bud_scnr_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] payTermDys = (JSPUtil.getParameter(request, prefix	+ "pay_term_dys", length));
			String[] updateflag = (JSPUtil.getParameter(request, prefix	+ "updateflag", length));
			String[] holiday = (JSPUtil.getParameter(request, prefix	+ "holiday", length));
			String[] deptuh = (JSPUtil.getParameter(request, prefix	+ "deptuh", length));
			String[] usdhrs = (JSPUtil.getParameter(request, prefix	+ "usdhrs", length));
			String[] soDtlSeq = (JSPUtil.getParameter(request, prefix	+ "so_dtl_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] psoChgStsCd = (JSPUtil.getParameter(request, prefix	+ "pso_chg_sts_cd", length));
			String[] barge = (JSPUtil.getParameter(request, prefix	+ "barge", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] psoTrnsSlpCtnt = (JSPUtil.getParameter(request, prefix	+ "pso_trns_slp_ctnt", length));
			String[] soSeq = (JSPUtil.getParameter(request, prefix	+ "so_seq", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] loclWhldTaxAmt = (JSPUtil.getParameter(request, prefix	+ "locl_whld_tax_amt", length));
			String[] issCtyCd = (JSPUtil.getParameter(request, prefix	+ "iss_cty_cd", length));
			String[] foml2 = (JSPUtil.getParameter(request, prefix	+ "foml2", length));
			String[] cond1 = (JSPUtil.getParameter(request, prefix	+ "cond1", length));
			String[] foml1 = (JSPUtil.getParameter(request, prefix	+ "foml1", length));
			String[] cond2 = (JSPUtil.getParameter(request, prefix	+ "cond2", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tugrope = (JSPUtil.getParameter(request, prefix	+ "tugrope", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix	+ "yd_chg_ver_seq", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] atd = (JSPUtil.getParameter(request, prefix	+ "atd", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] invRgstNo = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_no", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] acptDt = (JSPUtil.getParameter(request, prefix	+ "acpt_dt", length));
			String[] arrlh = (JSPUtil.getParameter(request, prefix	+ "arrlh", length));
			String[] loclAmt = (JSPUtil.getParameter(request, prefix	+ "locl_amt", length));
			String[] boat = (JSPUtil.getParameter(request, prefix	+ "boat", length));
			String[] ttlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_usd_amt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] io = (JSPUtil.getParameter(request, prefix	+ "io", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] depnt = (JSPUtil.getParameter(request, prefix	+ "depnt", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] ttlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_locl_amt", length));
			String[] loclDdctAmt = (JSPUtil.getParameter(request, prefix	+ "locl_ddct_amt", length));
			String[] night = (JSPUtil.getParameter(request, prefix	+ "night", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] credit = (JSPUtil.getParameter(request, prefix	+ "credit", length));
			String[] copilot = (JSPUtil.getParameter(request, prefix	+ "copilot", length));
			String[] invLoclAmt = (JSPUtil.getParameter(request, prefix	+ "inv_locl_amt", length));
			String[] delChk = (JSPUtil.getParameter(request, prefix	+ "del_chk", length));
			String[] ioChk = (JSPUtil.getParameter(request, prefix	+ "io_chk", length));
			String[] n3ptyBilIfFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_if_flg", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] ifRmk = (JSPUtil.getParameter(request, prefix	+ "if_rmk", length));
			String[] n3ptyVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_vndr_seq", length));
			String[] mnlInpXchRt = (JSPUtil.getParameter(request, prefix	+ "mnl_inp_xch_rt", length));
			String[] trfCurrCd = (JSPUtil.getParameter(request, prefix	+ "trf_curr_cd", length));
			String[] costCalcEffFmDt = (JSPUtil.getParameter(request, prefix	+ "cost_calc_eff_fm_dt", length));
			String[] costCalcEffToDt = (JSPUtil.getParameter(request, prefix	+ "cost_calc_eff_to_dt", length));
			String[] bafRt = (JSPUtil.getParameter(request, prefix	+ "baf_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvAuditDataValidVO();
				if (sanitation[i] != null)
					model.setSanitation(sanitation[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (buoy[i] != null)
					model.setBuoy(buoy[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (loclTaxAmt[i] != null)
					model.setLoclTaxAmt(loclTaxAmt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (inspection[i] != null)
					model.setInspection(inspection[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tariffCost[i] != null)
					model.setTariffCost(tariffCost[i]);
				if (newservice[i] != null)
					model.setNewservice(newservice[i]);
				if (deplh[i] != null)
					model.setDeplh(deplh[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (apEffDt[i] != null)
					model.setApEffDt(apEffDt[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (orgFlg[i] != null)
					model.setOrgFlg(orgFlg[i]);
				if (arrnt[i] != null)
					model.setArrnt(arrnt[i]);
				if (arrtp[i] != null)
					model.setArrtp(arrtp[i]);
				if (ydChgNo[i] != null)
					model.setYdChgNo(ydChgNo[i]);
				if (lgsCostFullNm[i] != null)
					model.setLgsCostFullNm(lgsCostFullNm[i]);
				if (adjcost[i] != null)
					model.setAdjcost(adjcost[i]);
				if (arrtuh[i] != null)
					model.setArrtuh(arrtuh[i]);
				if (loclNetAmt[i] != null)
					model.setLoclNetAmt(loclNetAmt[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (deptp[i] != null)
					model.setDeptp(deptp[i]);
				if (budScnrNo[i] != null)
					model.setBudScnrNo(budScnrNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (payTermDys[i] != null)
					model.setPayTermDys(payTermDys[i]);
				if (updateflag[i] != null)
					model.setUpdateflag(updateflag[i]);
				if (holiday[i] != null)
					model.setHoliday(holiday[i]);
				if (deptuh[i] != null)
					model.setDeptuh(deptuh[i]);
				if (usdhrs[i] != null)
					model.setUsdhrs(usdhrs[i]);
				if (soDtlSeq[i] != null)
					model.setSoDtlSeq(soDtlSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (psoChgStsCd[i] != null)
					model.setPsoChgStsCd(psoChgStsCd[i]);
				if (barge[i] != null)
					model.setBarge(barge[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (psoTrnsSlpCtnt[i] != null)
					model.setPsoTrnsSlpCtnt(psoTrnsSlpCtnt[i]);
				if (soSeq[i] != null)
					model.setSoSeq(soSeq[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (loclWhldTaxAmt[i] != null)
					model.setLoclWhldTaxAmt(loclWhldTaxAmt[i]);
				if (issCtyCd[i] != null)
					model.setIssCtyCd(issCtyCd[i]);
				if (foml2[i] != null)
					model.setFoml2(foml2[i]);
				if (cond1[i] != null)
					model.setCond1(cond1[i]);
				if (foml1[i] != null)
					model.setFoml1(foml1[i]);
				if (cond2[i] != null)
					model.setCond2(cond2[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tugrope[i] != null)
					model.setTugrope(tugrope[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (ydChgVerSeq[i] != null)
					model.setYdChgVerSeq(ydChgVerSeq[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (atd[i] != null)
					model.setAtd(atd[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (invRgstNo[i] != null)
					model.setInvRgstNo(invRgstNo[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (acptDt[i] != null)
					model.setAcptDt(acptDt[i]);
				if (arrlh[i] != null)
					model.setArrlh(arrlh[i]);
				if (loclAmt[i] != null)
					model.setLoclAmt(loclAmt[i]);
				if (boat[i] != null)
					model.setBoat(boat[i]);
				if (ttlUsdAmt[i] != null)
					model.setTtlUsdAmt(ttlUsdAmt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (io[i] != null)
					model.setIo(io[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (depnt[i] != null)
					model.setDepnt(depnt[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (ttlLoclAmt[i] != null)
					model.setTtlLoclAmt(ttlLoclAmt[i]);
				if (loclDdctAmt[i] != null)
					model.setLoclDdctAmt(loclDdctAmt[i]);
				if (night[i] != null)
					model.setNight(night[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (credit[i] != null)
					model.setCredit(credit[i]);
				if (copilot[i] != null)
					model.setCopilot(copilot[i]);
				if (invLoclAmt[i] != null)
					model.setInvLoclAmt(invLoclAmt[i]);
				if (delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (ioChk[i] != null)
					model.setIoChk(ioChk[i]);				
				if (n3ptyBilIfFlg[i] != null)
					model.setN3ptyBilIfFlg(n3ptyBilIfFlg[i]);				
				if (n3ptyBilTpCd[i] != null)
					model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);				
				if (ifRmk[i] != null)
					model.setIfRmk(ifRmk[i]);				
				if (n3ptyVndrSeq[i] != null)
					model.setN3ptyVndrSeq(n3ptyVndrSeq[i]);
				if (mnlInpXchRt[i] != null)
					model.setMnlInpXchRt(mnlInpXchRt[i]);	
				if (trfCurrCd[i] != null)
					 model.setTrfCurrCd(trfCurrCd[i]);	
				if (costCalcEffFmDt[i] != null)
					 model.setCostCalcEffFmDt(costCalcEffFmDt[i]);	
				if (costCalcEffToDt[i] != null)
					 model.setCostCalcEffToDt(costCalcEffToDt[i]);
				if (bafRt[i] != null)
					 model.setBafRt(bafRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvAuditDataValidVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvAuditDataValidVO[]
	 */
	public InvAuditDataValidVO[] getInvAuditDataValidVOs(){
		InvAuditDataValidVO[] vos = (InvAuditDataValidVO[])models.toArray(new InvAuditDataValidVO[models.size()]);
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
		this.sanitation = this.sanitation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buoy = this.buoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTaxAmt = this.loclTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inspection = this.inspection .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariffCost = this.tariffCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newservice = this.newservice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deplh = this.deplh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apEffDt = this.apEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFlg = this.orgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrnt = this.arrnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrtp = this.arrtp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgNo = this.ydChgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostFullNm = this.lgsCostFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjcost = this.adjcost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrtuh = this.arrtuh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclNetAmt = this.loclNetAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deptp = this.deptp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budScnrNo = this.budScnrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermDys = this.payTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateflag = this.updateflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holiday = this.holiday .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deptuh = this.deptuh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdhrs = this.usdhrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soDtlSeq = this.soDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoChgStsCd = this.psoChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.barge = this.barge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoTrnsSlpCtnt = this.psoTrnsSlpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soSeq = this.soSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclWhldTaxAmt = this.loclWhldTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issCtyCd = this.issCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foml2 = this.foml2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cond1 = this.cond1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foml1 = this.foml1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cond2 = this.cond2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tugrope = this.tugrope .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgVerSeq = this.ydChgVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atd = this.atd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstNo = this.invRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptDt = this.acptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrlh = this.arrlh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAmt = this.loclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boat = this.boat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlUsdAmt = this.ttlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.io = this.io .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depnt = this.depnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoclAmt = this.ttlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclDdctAmt = this.loclDdctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.night = this.night .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.credit = this.credit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copilot = this.copilot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLoclAmt = this.invLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk = this.delChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioChk = this.ioChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilIfFlg = this.n3ptyBilIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRmk = this.ifRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyVndrSeq = this.n3ptyVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlInpXchRt = this.mnlInpXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCurrCd = this.trfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.costCalcEffFmDt = this.costCalcEffFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.costCalcEffToDt = this.costCalcEffToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.bafRt = this.bafRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
	}

	/**
	 * @return the vvd
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @param vvd the vvd to set
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * @return the credit
	 */
	public String getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(String credit) {
		this.credit = credit;
	}

	/**
	 * @return the credit
	 */
	public String getCopilot() {
		return copilot;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCopilot(String copilot) {
		this.copilot = copilot;
	}

	/**
	 * @return the invLoclAmt
	 */
	public String getInvLoclAmt() {
		return invLoclAmt;
	}

	/**
	 * @param invLoclAmt the invLoclAmt to set
	 */
	public void setInvLoclAmt(String invLoclAmt) {
		this.invLoclAmt = invLoclAmt;
	}

	/**
	 * @return the delChk
	 */
	public String getDelChk() {
		return delChk;
	}
	
	/**
	 * @return the ioChk
	 */
	public String getIoChk() {
		return ioChk;
	}
	
	/**
	 * @param delChk the delChk to set
	 */
	public void setDelChk(String delChk) {
		this.delChk = delChk;
	}
	
	/**
	 * @param ioChk the ioChk to set
	 */
	public void setIoChk(String ioChk) {
		this.ioChk = ioChk;
	}
}
